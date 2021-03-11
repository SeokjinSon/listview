package com.example.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemDataAdapter extends ArrayAdapter<ItemData> {
    // Member Variable ------------------------------------------------
    private Context                 context;
    private int                     layoutResId;
    private ArrayList<ItemData>     dataList;


    // context 데이터, UI, 상속받은 것
    // 어댑터는 레이아웃에 맞게 그려주는 역할
    // Constructor Method ---------------------------------------------
    public ItemDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ItemData> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResId = resource;
        this.dataList = objects;
    }


    // Override Method ------------------------------------------------

    @Override
    public int getCount() {
        return dataList.size();
    }

    // 화면에 그려줌(convertView : 그려주는 곳
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Data ==> XML layout 넣어서 보이고 사용할 수 있도록 객체 생성
        // (1) item Layout XML  ==>  Java 객체로 변환 필요

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResId, null);

            ItemDataHolder holder = new ItemDataHolder(convertView);
            convertView.setTag(holder);
        }

        ItemDataHolder holder = (ItemDataHolder)convertView.getTag();

        // (2) item Layout's view 객체 가져오기
//        TextView nameTXT = convertView.findViewById(R.id.nameTXT);
//        TextView phoneTXT = convertView.findViewById(R.id.phoneTXT);
//        TextView addrTXT = convertView.findViewById(R.id.addressTXT);
//        ImageView iconIMG = convertView.findViewById(R.id.iconIMG);
        TextView nameTXT = holder.nameTXT;
        TextView phoneTXT = holder.phoneTXT;
        TextView addrTXT = holder.addressTXT;
        ImageView iconIMG = holder.iconIMG;


        // (3) Data 준비
        final ItemData item = dataList.get(position);

        // (4) Layout <---> Data
        nameTXT.setText(item.getName());
        phoneTXT.setText(item.getPhone());
        addrTXT.setText(item.getAddress());

        // Image 크기 동일하게
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), item.getImgResId());
        bitmap = bitmap.createScaledBitmap(bitmap, 100, 100, true);
        iconIMG.setImageBitmap(bitmap);

        return convertView;
    }
}
