package com.controller.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dto.ImgResultDTO;
import com.dto.ResultDTO;
import com.dto.ResultEnum;
import com.util.CommonUtil;
import com.util.ResultUtil;
import com.util.StringUtil;

@RequestMapping("/img")
@RestController
public class ImgController {

	@Value("${files.img.path}")
	private String imgUrl;
	
	@RequestMapping("/uploadImage")
	public ResultDTO uploadImage(String imgType, @RequestParam MultipartFile imgsFile) {
		// 主路径
		File mainUrl = new File(imgUrl);
		if (!mainUrl.exists() && !mainUrl.isDirectory()) {
			mainUrl.mkdir();
		}

		if (imgsFile != null) {// 判断上传的文件是否为空
			String type = null;// 文件类型
			String fileName = imgsFile.getOriginalFilename();// 文件原名称
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(
					fileName.lastIndexOf(".") + 1, fileName.length()) : null;
			if (type != null) {// 判断文件类型是否为空
				if ("GIF".equals(type.toUpperCase())
						|| "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {

					String realPath = imgUrl + "/" + imgType;
					File fileUrl = new File(realPath);
					if (!fileUrl.exists() && !fileUrl.isDirectory()) {
						fileUrl.mkdir();
					}
					// 自定义的文件名称
					String trueFileName = CommonUtil.getUUID() + "." + type;
					// 设置存放图片文件的路径
					String path = realPath + "/" + trueFileName;
					// 转存文件到指定的路径
					try {
						imgsFile.transferTo(new File(path));
					} catch (IOException e) {
						e.printStackTrace();
						return ResultUtil.error(ResultEnum.FILE_ERROR);
					}
					Map<String, String> map = new HashMap<String, String>();
					map.put("localPath", "/" + imgType + "/" + trueFileName);
					map.put("showPath", imgUrl+"/" + imgType + "/" + trueFileName);
					return ResultUtil.success(map);
				} else {
					return ResultUtil.error(ResultEnum.FILE_ERROR);
				}
			} else {
				return ResultUtil.error(ResultEnum.FILE_ERROR);
			}
		} else {
			return ResultUtil.error(ResultEnum.FILE_UNFOUND);
		}
	}
	

	/**
	 * imgType user->用户头像
	 * 
	 * @param imgType
	 * @param imgsFile
	 * @return
	 */
	@RequestMapping("/uploadjournalImage")
	public ImgResultDTO uploadjournalImage(String imgType, @RequestParam MultipartFile imgsFile) {
		// 主路径
		File mainUrl = new File(imgUrl);
		if (!mainUrl.exists() && !mainUrl.isDirectory()) {
			mainUrl.mkdir();
		}

		if (imgsFile != null) {// 判断上传的文件是否为空
			String type = null;// 文件类型
			String fileName = imgsFile.getOriginalFilename();// 文件原名称
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(
					fileName.lastIndexOf(".") + 1, fileName.length()) : null;
			if (type != null) {// 判断文件类型是否为空
				if ("GIF".equals(type.toUpperCase())
						|| "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {

					String realPath = imgUrl + "/" + imgType;
					File fileUrl = new File(realPath);
					if (!fileUrl.exists() && !fileUrl.isDirectory()) {
						fileUrl.mkdir();
					}
					// 自定义的文件名称
					String trueFileName = CommonUtil.getUUID() + "." + type;
					// 设置存放图片文件的路径
					String path = realPath + "/" + trueFileName;
					// 转存文件到指定的路径
					try {
						imgsFile.transferTo(new File(path));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Map<String, String> map = new HashMap<String, String>();
					map.put("localPath", "/" + imgType + "/" + trueFileName);
					map.put("showPath", imgUrl+"/" + imgType + "/" + trueFileName);
					return ResultUtil.imgSuccess(new String[]{ "/img/url/?imgPath=/" + imgType + "/" + trueFileName});
				} else {
					return ResultUtil.imgSuccess(new String[]{""});
				}
			} else {
				return ResultUtil.imgSuccess(new String[]{""});
			}
		} else {
			return ResultUtil.imgSuccess(new String[]{""});
		}
	}
	
	@RequestMapping("/url")
	public void img(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,String imgPath) throws Exception {
		if(!StringUtil.isEmpty(imgPath)){
			File f = new File(imgUrl+imgPath);
	        BufferedImage bi;        
	        try {        
	            bi = ImageIO.read(f);        
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();        
	            ImageIO.write(bi, "jpg", baos);        
	            byte[] bytes = baos.toByteArray();        
	            OutputStream stream;
	    		stream = response.getOutputStream();
	    		stream.write(bytes);
	    		stream.flush();
	    		stream.close();
	        } catch (IOException e) {        
	            e.printStackTrace();        
	        }	
		}
	}	
}
