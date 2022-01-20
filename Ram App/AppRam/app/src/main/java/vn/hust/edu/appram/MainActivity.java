package vn.hust.edu.appram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    activity_list listFragment;
    activity_item itemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
            }
        }

        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();

                //Tao du lieu vi du cho TextFile.txt
                try {
                    String content = "Đại học Bách Khoa Hà Nội";
                    FileOutputStream fos = new FileOutputStream(sdPath + "/TextABC.txt");
                    OutputStreamWriter writer = new OutputStreamWriter(fos);
                    writer.write(content);
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                updateData(sdPath);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 200)
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission granted");
                String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();

                //Tao du lieu vi du cho TextFile.txt
                try {
                    String content = "Đại học Bách Khoa Hà Nội";
                    FileOutputStream fos = new FileOutputStream(sdPath + "/TextABC.txt");
                    OutputStreamWriter writer = new OutputStreamWriter(fos);
                    writer.write(content);
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.v("TAG", "sai");
                }

                updateData(sdPath);
            }
            else {
                Log.v("TAG", "Permission denied");
                Toast.makeText(this, "Access failed. Please provide the permission to the application!", Toast.LENGTH_LONG).show();
            }
    }

    @Override
    public void updateData(String text) {
        File folderFile = new File(text);
        if (folderFile.isDirectory()) {
            try{
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                listFragment = listFragment.newInstance(text);
                ft.add(R.id.home_main, listFragment);
                ft.addToBackStack("Hà Nội");
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (folderFile.isFile()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            itemFragment = itemFragment.newInstance(text);
            ft.add(R.id.home_main, itemFragment);
            ft.addToBackStack("Hà Nội");
            ft.commit();
        }
    }
}