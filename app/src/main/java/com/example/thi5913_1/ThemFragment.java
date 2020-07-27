package com.example.thi5913_1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.thi5913_1.controller.IController;
import com.example.thi5913_1.model.MonHoc;

import java.util.Calendar;

public class ThemFragment extends Fragment {
    Toolbar toolbar;
    private EditText mTenMH;
    private EditText mNgayBatDau;
    private EditText mNgayKetThuc;
    private EditText mGiangDuong;
    private Spinner mSpinner;
    private Button mBTNThem;
    private Button mBTNXemDS;
    private Toolbar mTbthem;
    private ImageView imgbd, imgkt;

    NavController navController;
    IController controller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_them, container, false);
        addView(view);
        addEvent();
        return view;

    }

    private void addView(View view) {
        toolbar = view.findViewById(R.id.tbthem);
        mTbthem = view.findViewById(R.id.tbthem);
        mTenMH = view.findViewById(R.id.tenMH);
        mNgayBatDau = view.findViewById(R.id.ngayBatDau);
        mNgayKetThuc = view.findViewById(R.id.ngayKetThuc);
        mGiangDuong = view.findViewById(R.id.giangDuong);
        mSpinner = view.findViewById(R.id.spinner);
        mBTNThem = view.findViewById(R.id.BTNThem);
        mBTNXemDS = view.findViewById(R.id.BTNXemDS);
        imgbd = view.findViewById(R.id.imgBD);
        imgkt = view.findViewById(R.id.imgKT);
        navController = NavHostFragment.findNavController(ThemFragment.this);
        controller = ((MainActivity)getActivity()).controller;

        String[] hinhThucThi = new String[]{"Phong may","Trac ngiem","Project"}; // Khai báo 1 mảng dữ liệu cho spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ThemFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,hinhThucThi);
        //Tạo ra một adapter cho spinner theo chiều dọc đi xuống (support_simple_spinner_dropdown_item)
        mSpinner.setAdapter(arrayAdapter);// gắn adapter cho spinner
    }

    private void addEvent() {

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Cho phép xuất hiện nút back
        toolbar.setNavigationIcon(R.drawable.ic_action_back); //Chỉnh sửa nút back trên thanh toolbar

        //thêm sự kiện cho nút back
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_themFragment_to_hienThiFragment);
            }
        });

        imgbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year)
                                .append("-")
                                .append(++month)
                                .append("-")
                                .append(dayOfMonth);
                        mNgayBatDau.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });


        imgkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year)
                                .append("-")
                                .append(++month)
                                .append("-")
                                .append(dayOfMonth);
                        mNgayKetThuc.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        mBTNThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MonHoc mh = new MonHoc();
                mh.setTenMH(mTenMH.getText().toString());
                mh.setNgayBD(mNgayBatDau.getText().toString());
                mh.setNgayKT(mNgayKetThuc.getText().toString());
                mh.setDiaDiem(mGiangDuong.getText().toString());
                mh.setHinhThucThi(mSpinner.getSelectedItem().toString());
                controller.addMonHoc(mh);
                Toast.makeText(getActivity(),"Đã thêm thành công", Toast.LENGTH_LONG).show();
            }
        });

        mBTNXemDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_themFragment_to_hienThiFragment);
            }
        });

    }
}