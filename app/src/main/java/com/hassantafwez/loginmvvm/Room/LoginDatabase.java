package com.hassantafwez.loginmvvm.Room;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.hassantafwez.loginmvvm.Model.Datum;

@Database(entities = {Datum.class},version = 5)
public abstract class LoginDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "Cat";
    public abstract LoginDao catimgDao();
    public static volatile LoginDatabase INSTANCE = null;

    public static LoginDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (LoginDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, LoginDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyn(INSTANCE);
        }
    };

    static  class  PopulateDbAsyn extends AsyncTask<Void,Void,Void>{
        private LoginDao catimgDao;
        public PopulateDbAsyn(LoginDatabase catDatabase)
        {
            catimgDao=catDatabase.catimgDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            catimgDao.deleteAll();
            return null;
        }
    }
}