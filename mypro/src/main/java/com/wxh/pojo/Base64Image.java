package com.wxh.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;

import Decoder.BASE64Decoder;


public class Base64Image {

	static String REPOSITORY_PATH = "D:\\fileupload-images";
	public static String IMG_PATH = null;

	/**
	 * 图片转化成base64字符串
	 * 
	 * @param imgFilePath
	 * @return
	 */
	public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理

		//String imgFile = "d:\\111.jpg";// 待处理的图片
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Base64.encodeBase64String(data).toString());
		return Base64.encodeBase64String(data);
		// 对字节数组Base64编码
//		BASE64Encoder encoder = new BASE64Encoder();
//		return encoder.encode(data);
	}

	/**
	 * base64字符串转化成图片
	 * 
	 * @param imgStr base64字符串
	 * @return
	 */
	public static boolean GenerateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			String filePath = getFilePath("new.jpg");
			IMG_PATH = filePath;
			System.out.println("图片路径："+filePath);
			OutputStream out = new FileOutputStream(filePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 生成新的文件名（yyyy/MM/dd/DateTime&randomNum.xxx）
	 * 
	 * @param sourceFileName
	 * @return
	 */
	private static String getFilePath(String sourceFileName) {
		String baseFolder = REPOSITORY_PATH + File.separator + "images";
		Date nowDate = new Date();
		// yyyy/MM/dd
		String fileFolder = baseFolder + File.separator + new DateTime(nowDate).toString("yyyy") + File.separator
				+ new DateTime(nowDate).toString("MM") + File.separator + new DateTime(nowDate).toString("dd");
		File file = new File(fileFolder);
		if (!file.exists()) {
			// 如果目录不存在，则创建目录
			file.mkdirs();
		}
		// 生成新的文件名
		String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS") + RandomUtils.nextInt(100, 9999) + "."
				+ StringUtils.substringAfterLast(sourceFileName, ".");
		return fileFolder + File.separator + fileName;
	}
}
