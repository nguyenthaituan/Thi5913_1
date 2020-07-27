package com.example.thi5913_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thi5913_1.controller.IController;
import com.example.thi5913_1.model.MonHoc;

import java.util.ArrayList;
import java.util.List;


public class HienThiFragment extends Fragment {
    Toolbar toolbar;
    RecyclerView recyclerView;
    IController controller;
    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_hien_thi, container, false);
        addView(view);
        addEvent();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.itemAdd){
            navController.navigate(R.id.action_hienThiFragment_to_themFragment);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addEvent() {
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
//        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Cho phép xuất hiện nút back
//        toolbar.setNavigationIcon(R.drawable.ic_action_back); //Chỉnh sửa nút back trên thanh toolbar
//
//        //thêm sự kiện cho nút back
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                navController.navigate(R.id.action_hienthiFragment_to_themFragment);
//            }
//        });
    }

    private void addView(View view) {
        toolbar = view.findViewById(R.id.tbds);
        recyclerView = view.findViewById(R.id.rcvlist);
        navController = NavHostFragment.findNavController(HienThiFragment.this);
        controller = ((MainActivity)getActivity()).controller;
        recyclerView.setLayoutManager(new LinearLayoutManager(HienThiFragment.this.getActivity()));

        MonHocAdapter adapter = new MonHocAdapter(controller.getListMonHoc());
        recyclerView.setAdapter(adapter);
    }

    public class MonHocViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvShowTen, tvShowNgayBD, tvShowNgayKT,tvShowGiangDuong,tvShowHinhThucThi;

        public MonHocViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShowTen = itemView.findViewById(R.id.ShowTen);
            tvShowNgayBD = itemView.findViewById(R.id.ShowNgayBD);
            tvShowNgayKT = itemView.findViewById(R.id.ShowNgayKT);
            tvShowGiangDuong = itemView.findViewById(R.id.ShowGiangDuong);
            tvShowHinhThucThi = itemView.findViewById(R.id.ShowHinhThucThi);
        }

        public void bind(MonHoc monHoc)
        {
            tvShowTen.setText(monHoc.getTenMH());
            tvShowNgayBD.setText(monHoc.getNgayBD());
            tvShowNgayKT.setText(monHoc.getNgayKT());
            tvShowGiangDuong.setText(monHoc.getDiaDiem());
            tvShowHinhThucThi.setText(monHoc.getHinhThucThi());
        }
    }

    public class MonHocAdapter extends RecyclerView.Adapter<MonHocViewHolder>{

        List<MonHoc> listMonHoc = new ArrayList<>();

        public MonHocAdapter(List<MonHoc> listMonHoc) {
            this.listMonHoc = listMonHoc;
        }

        @NonNull
        @Override
        public MonHocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.monhoc,parent,false);
            return new MonHocViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MonHocViewHolder holder, int position) {
            holder.bind(listMonHoc.get(position));
        }

        @Override
        public int getItemCount() {
            return listMonHoc.size();
        }
    }


}