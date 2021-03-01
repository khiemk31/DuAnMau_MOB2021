package com.example.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.DAO.ThuThu_DAO;
import com.example.myapplication.Object.ThuThu;
import com.example.myapplication.R;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    List<ThuThu> arrThuThu;
    public Activity context;
    public LayoutInflater inflater;
    ThuThu_DAO thuThu_DAO;

    public NguoiDungAdapter(Activity context, List<ThuThu> arrayThuThu) {
        super();
        this.context = context;
        this.arrThuThu = arrayThuThu;
        this.inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        thuThu_DAO = new ThuThu_DAO(context);
    }

    @Override
    public int getCount() {
        return arrThuThu.size();
    }

    @Override
    public Object getItem(int position) {
        return arrThuThu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtPhone;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_nguoi_dung, null);
            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.txtName = (TextView) convertView.findViewById(R.id.tvName);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    thuThu_DAO.deleteNguoiDungByID(arrThuThu.get(position).getUserName());
                    arrThuThu.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        ThuThu _entry = (ThuThu) arrThuThu.get(position);
        if (position % 3 == 0) {
            holder.img.setImageResource(R.drawable.emone);
        } else if (position % 3 == 1) {
            holder.img.setImageResource(R.drawable.emtwo);
        } else {
            holder.img.setImageResource(R.drawable.emthree);
        }
        holder.txtName.setText(_entry.getHoTen());
        holder.txtPhone.setText(_entry.getPhone());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<ThuThu> items) {
        this.arrThuThu = items;
        notifyDataSetChanged();
    }
}
