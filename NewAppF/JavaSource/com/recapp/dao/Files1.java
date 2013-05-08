package com.recapp.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Files1 {
	public static File fileRead() {
		try {
			File f = new File(
					"/home/srinivasc/Books/Radio Lessons 1-50/01 Basics.mp3");

			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bif = new BufferedInputStream(fis);
			File nf = new File("basic.mp3");
			FileOutputStream fos = new FileOutputStream(nf);
			BufferedOutputStream bof = new BufferedOutputStream(fos);
			int a;
			while ((a = bif.read()) != -1) {
				bof.write(a);
			}
			bif.close();
			bof.close();
			return nf;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
