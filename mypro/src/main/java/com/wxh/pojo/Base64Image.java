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
	 * ͼƬת����base64�ַ���
	 * 
	 * @param imgFilePath
	 * @return
	 */
	public static String GetImageStr(String imgFilePath) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��

		//String imgFile = "d:\\111.jpg";// �������ͼƬ
		byte[] data = null;

		// ��ȡͼƬ�ֽ�����
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
		// ���ֽ�����Base64����
//		BASE64Encoder encoder = new BASE64Encoder();
//		return encoder.encode(data);
	}

	/**
	 * base64�ַ���ת����ͼƬ
	 * 
	 * @param imgStr base64�ַ���
	 * @return
	 */
	public static boolean GenerateImage(String imgStr) { // ���ֽ������ַ�������Base64���벢����ͼƬ
		if (imgStr == null) // ͼ������Ϊ��
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// �����쳣����
					b[i] += 256;
				}
			}
			String filePath = getFilePath("new.jpg");
			IMG_PATH = filePath;
			System.out.println("ͼƬ·����"+filePath);
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
	 * �����µ��ļ�����yyyy/MM/dd/DateTime&randomNum.xxx��
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
			// ���Ŀ¼�����ڣ��򴴽�Ŀ¼
			file.mkdirs();
		}
		// �����µ��ļ���
		String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS") + RandomUtils.nextInt(100, 9999) + "."
				+ StringUtils.substringAfterLast(sourceFileName, ".");
		return fileFolder + File.separator + fileName;
	}
}
