package com.itheima.controller;
/*
*体检套餐管理
*/

//import com.itheima.constant.MessageConstant;
//import com.itheima.entity.Result;
//import com.itheima.utils.QiniuUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/setmeal")
//public class SetmealController {
//    //文件上传
//    @RequestMapping("/upload")
//    public Result upload(@RequestParam("imgFile")MultipartFile imgFile){
//        System.out.println(imgFile);
//        String originalFilename = imgFile.getOriginalFilename();//原始文件名
//        int indes = originalFilename.lastIndexOf(".");
//        String extention = originalFilename.substring(indes - 1);//.jpg
//        String fileName = UUID.randomUUID().toString() + extention;//FuM1Sa5TtL_ekLsdkYWcf5pyjKGu
//
//        try {
//            //将文件上传到七牛云服务器
//            QiniuUtils.upload2Qiniu(imgFile.getBytes(),fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
//        }
//        return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS,fileName);
//    }
//}
//
//


import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.utils.QiniuUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;
/**
 * 套餐管理
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    //图片上传
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile")MultipartFile imgFile){

            //获取原始文件名
            String originalFilename = imgFile.getOriginalFilename();
            int index = originalFilename.lastIndexOf(".");
            //获取文件后缀
            String extention = originalFilename.substring(index - 1);
            //使用UUID随机产生文件名称，防止同名文件覆盖
            //String fileName = UUID.randomUUID().toString() + suffix;
            String fileName = UUID.randomUUID().toString() + extention;
        try{
            QiniuUtils.upload2Qiniu(imgFile.getBytes(),fileName);
            //图片上传成功
//            Result result = new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS);
//            result.setData(fileName);
//            return result;
        }catch (Exception e){
            e.printStackTrace();
            //图片上传失败
            return new Result(false,MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS,fileName);
    }
}

























