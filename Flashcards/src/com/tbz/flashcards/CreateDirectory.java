/**
 * @author Davina
 *
 * Diese Klasse ist für das Erstellen und Loeschen der Kategorie-Ordner zuständig.
 */
package com.tbz.flashcards;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class CreateDirectory extends Activity{
	
	private String kategoryName;
	private String imageDir;
	
	public CreateDirectory()
    {
        this.imageDir = "image";
    }
	
	public void CreateDir(String kategory) {
		if (NameOk(kategory)){
		   //Erzeugen eines leeren Kategori-Ordners
		   File dirKat = getDir(kategory, MODE_WORLD_READABLE);
		   //Erzeugen eines Images-Ordners im kategorie-Ordner
		   //createFile(dirKat, "image");
		   File dirIMG = getDir(kategory + "_img", MODE_WORLD_READABLE);
		}
    }
		
	/*private void createFile(File dir, String name) {
		FileOutputStream fos = null;
		try {
			File file = new File(dir, name);
			// Datei anlegen
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			Log.e(TAG, "openFileOutput()", e);
		} finally {
			// Datei schliessen
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
	}*/
	public void DeleteDir(File dirKategory){
		if(DirExists(dirKategory)){
			dirKategory.delete();
		} 
	}
	
	public boolean DirExists(File dirFile){
		if (dirFile.exists()){
			return true;	
		} else {
			return false;
		} 
	}
	
	public boolean NameOk(String kategory){
		//String expression = [\p{Punct}];
		//| name.matches(expression)
		//lieber mit fkt isEmpty()
		String name = kategory;
		if ( name == ""){
		   return false;
		} else {
		   return true;
		}   
	}
	
}