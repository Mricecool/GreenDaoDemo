package com.dbdemo;

import android.app.Application;
import android.content.Context;

import com.dbdemo.dao.DaoMaster;
import com.dbdemo.dao.DaoSession;
import com.dbdemo.utils.GreenDaoContext;

import org.greenrobot.greendao.database.Database;

/**
 * Created by app on 2017/10/17.
 */
public class DBApplication extends Application {

    public static Context context;
    public static DaoSession daoSession = null;
    private final static String DBNAME = "MY_DB.db";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //initGreenDAO();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void initGreenDAO() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(new GreenDaoContext(), DBNAME);
        Database database = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }



    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
