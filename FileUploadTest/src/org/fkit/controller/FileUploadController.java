package org.fkit.controller;

import org.apache.commons.io.FileUtils;
import org.fkit.domain.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Ray on 2017/3/10.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("description") String description, @RequestParam("file")MultipartFile file) throws Exception{
        System.out.println(description);
        if(!file.isEmpty()){
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");

            //上传文件名
            String fileName = file.getOriginalFilename();
            File filePath = new File(path,fileName);

            //判断路径是否存在，如果不存在就创建一个
            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }

            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + fileName));

            return "success";
        }
        else{
            return "error";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, @ModelAttribute User user, Model model) throws Exception{
        System.out.println(user.getUsername());

        if(!user.getImage().isEmpty()){
            String path = request.getServletContext().getRealPath("/images");
            String fileName = user.getImage().getOriginalFilename();
            File filePath = new File(path, fileName);

            if(!filePath.exists()){
                filePath.getParentFile().mkdirs();
            }

            user.getImage().transferTo(new File(path + File.separator + fileName));
            model.addAttribute("user",user);
            return "userInfo";
        }
        else {
            return "error";
        }

    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename")String filename, Model model) throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");

        File file = new File(path + File.separator + filename);

        HttpHeaders headers = new HttpHeaders();

        //下载显示的文件名，解决中文名称乱码问题
        String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");

        //通知浏览器以attachment(下载方式)打开图片
        headers.setContentDispositionFormData("attachment", downloadFileName);

        //application/octet-stream 二进制流数据（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

    }

}
