package com.demo.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileTest {

	@Test
	public void test() {


	}

	public static void main(String[] args) throws Exception {

		String[] names = { "饶亚楠", "张喜庆", "付更强", "黄天志", "彭强盛", "黎思浩", "章佳怡", "陈梦莹", "杜婷婷", "郑策", "丁宇振", "应有杰", "曾权辉", "易明", "周子豪", "黄锐", "张震", "罗炜皓",
				"吴文平", "乐华荣", "陈淞", "任智翔", "张羽", "王良良", "占杨羊", "陈振威", "许彬勇", "王宇辰", "陈建豪", "陈杰瑞", "艾锦辉", "章梦成", "乐佳斌", "饶开涛", "邓涛", "黄宇恒", "宁冰", "方成",
				"曾俊豪", "娄耕瑞", "欧阳锟", "陈帮松", "陈志鹏", "曾志恒", "姜高峰", "张鹤明", "孙盼盼", "占卫烨" };

		File file = new File("F:\\desktop\\新建文件夹");
		List<String> sName = new ArrayList<String>();
		if (!file.exists()) {
			throw new Exception("目录不存在！");
		}
		String[] fiels = file.list();
		String name = "";
		String name2 = "";
		for (int i = 0; i < names.length; i++) {
			name = names[i];
			boolean flag = false;
			for (int j = 0; j < fiels.length; j++) {
				name2 = fiels[j].split("-")[0];
				if (name.equals(name2)) {
					flag = true;
					break;
				} else {
					continue;
				}
			}
			if (!flag) {
				sName.add(name);
			}
		}
		for (String s : sName) {
			System.out.println(s);
		}
	}

}
