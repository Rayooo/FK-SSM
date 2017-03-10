package org.fkit.controller;

import org.springframework.stereotype.Controller;
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
                filePath.getParentFile().mkdir();
            }

            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + fileName));

            return "success";
        }
        else{
            return "error";
        }
    }



}
