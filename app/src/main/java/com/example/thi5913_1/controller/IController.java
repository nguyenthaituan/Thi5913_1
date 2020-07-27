package com.example.thi5913_1.controller;

import com.example.thi5913_1.model.MonHoc;

import java.util.List;

public interface IController {
    public List<MonHoc> getListMonHoc();
    public void addMonHoc(MonHoc monHoc);
}
