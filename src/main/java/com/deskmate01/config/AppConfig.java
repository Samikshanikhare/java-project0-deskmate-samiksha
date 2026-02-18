package com.deskmate01.config;

import com.deshmate.service.DeskService;
import com.deskmate.Dao.DeskDao;
import com.deskmate.Dao.Impl.JdbcDeskDao;
import com.deskmate.controller.DeskController;


public class AppConfig {

    public DeskController deskController() {
        DeskDao deskDao = new JdbcDeskDao();
        DeskService deskService = new DeskService(deskDao);
        return new DeskController(deskService);
    }

   
}