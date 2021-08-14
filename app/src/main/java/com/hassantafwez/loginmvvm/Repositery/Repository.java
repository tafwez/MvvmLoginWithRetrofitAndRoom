package com.hassantafwez.loginmvvm.Repositery;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.hassantafwez.loginmvvm.Model.Datum;
import com.hassantafwez.loginmvvm.Room.LoginDao;
import com.hassantafwez.loginmvvm.Room.LoginDatabase;

import java.util.List;


public class Repository {
    public LoginDao catimgDao;
    public LiveData<List<Datum>> getAllCats;
    private LoginDatabase database;

    public Repository(Application application){
        database= LoginDatabase.getInstance(application);
        catimgDao=database.catimgDao();
        getAllCats=catimgDao.getcats();

    }

    public void insert(List<Datum> cats){
        new InsertAsyncTask(catimgDao).execute(cats);

    }

    public void deleteAll(){
        new DeleteAlltAsyncTask(database).execute();
    }

    public LiveData<List<Datum>> getAllCats(){
        return getAllCats;
    }
    private static class InsertAsyncTask extends AsyncTask<List<Datum>,Void,Void> {
        private LoginDao catimgDao;

        public InsertAsyncTask(LoginDao catDao)
        {
            this.catimgDao=catDao;
        }
        @Override
        protected Void doInBackground(List<Datum>... lists) {
            catimgDao.insert(lists[0]);
            return null;
        }
    }


    private static class DeleteAlltAsyncTask extends AsyncTask<Void,Void,Void> {
        private LoginDao catimgDao;
        public DeleteAlltAsyncTask(LoginDatabase catDatabase)
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