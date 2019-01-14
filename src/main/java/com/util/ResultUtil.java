package com.util;

import com.dto.ImgResultDTO;
import com.dto.ResultDTO;
import com.dto.ResultEnum;

public class ResultUtil {
	
	public static ResultDTO success(Object data){
		ResultDTO r = new ResultDTO();
		r.setCode(0);
		r.setMessage("操作成功！");
		r.setData(data);
		return r;
	}
	
	public static ResultDTO error(ResultEnum re){
		ResultDTO r = new ResultDTO();
		r.setCode(re.getCode());
		r.setMessage(re.getMsg());
		return r;
	}
	
	public static ResultDTO success(){
		return success(null);
	}
	
	public static ImgResultDTO imgSuccess(String[] data){
		ImgResultDTO imgResultDTO = new ImgResultDTO();
		imgResultDTO.setErrno("0");
		imgResultDTO.setData(data);
		return imgResultDTO;
	}
}
