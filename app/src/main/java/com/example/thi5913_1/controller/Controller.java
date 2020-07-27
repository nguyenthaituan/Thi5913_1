package com.example.thi5913_1.controller;

import android.app.Application;

import com.example.thi5913_1.model.MonHoc;

import java.util.ArrayList;
import java.util.List;

public class Controller extends Application implements IController {
    List<MonHoc> listHienThiMH ;

    public Controller() {
        this.listHienThiMH = new ArrayList<>();
    }

    @Override
    public List<MonHoc> getListMonHoc() {
        return listHienThiMH;
    }

    @Override
    public void addMonHoc(MonHoc monHoc) {
        listHienThiMH.add(monHoc);
    }
}
