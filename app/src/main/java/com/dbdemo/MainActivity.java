package com.dbdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.dbdemo.dao.DaoMaster;
import com.dbdemo.dao.DaoSession;
import com.dbdemo.utils.GreenDaoContext;

import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.database.Database;

public class MainActivity extends AppCompatActivity {
    public static DaoSession daoSession = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else{
            initGreenDAO();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    initGreenDAO();
                }else{
                    Toast.makeText(MainActivity.this,"权限不足",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private void initGreenDAO() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(new GreenDaoContext(), "mydb.db");
        Database database = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
