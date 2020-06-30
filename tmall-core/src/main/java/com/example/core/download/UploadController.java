package com.example.core.download;


import com.example.core.user.controller.UserInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

@Slf4j
@RestController("tamll/fileupload")
@Api(value = "文件上传", tags = "file-upload")
public class UploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/files")
    public String getUserInfo2(MultipartFile uploadFiles[], HttpServletRequest req) {

        String result = null;
        // 遍历所有上传的文件
        for (MultipartFile uploadFile : uploadFiles) {
            // 上传的文件将保存在项目运行目录下的 uploadFile 文件夹
            String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
            System.out.println(realPath);

            // 并且在 uploadFile 文件夹中通过日期对上传的文件归类保存
            // 比如：/uploadFile/2019/06/06/32091e5f-c9e9-4506-9567-43e724f1fe37.png
            String format = sdf.format(new Date());
            File folder = new File(realPath + format);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }

            // 对上传的文件重命名，避免文件重名
            String oldName = uploadFile.getOriginalFilename();
            String newName = UUID.randomUUID().toString()
                    + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                // 文件保存
                uploadFile.transferTo(new File(folder, newName));

                // 获取上传文件的访问路径
                String filePath = req.getScheme() + "://" + req.getServerName() + ":"
                        + req.getServerPort() + "/uploadFile/" + format + newName;
                result += filePath + "<br>";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 返回所有上传文件的访问路径
        return result;


    }



}
