package com.example.thi5913_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.thi5913_1.controller.Controller;
import com.example.thi5913_1.controller.IController;

public class MainActivity extends AppCompatActivity {
    IController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller();
        controller = (IController) getApplication();
    }
}