package com.example.app_nhac.Database;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Database {

    public static SQLiteDatabase initDatabase(Activity activity, String DATABASE_NAME) {

        File dbfile = activity.getDatabasePath(DATABASE_NAME);
        if (!dbfile.exists()) {
            try {
                try {
                    InputStream inputStream;
                    inputStream = activity.getAssets().open(DATABASE_NAME);
                    String outFileName = activity.getApplicationInfo().dataDir + "/databases/" + DATABASE_NAME;
                    File f = new File(activity.getApplicationInfo().dataDir + "/databases/");
                    if (!f.exists())
                        f.mkdir();
                    OutputStream outputStream = new FileOutputStream(outFileName);
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    outputStream.write(buffer);
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                    Toast.makeText(activity, "Đọc thành công", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                Toast.makeText(activity, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        return activity.openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE,null);
    }

}



