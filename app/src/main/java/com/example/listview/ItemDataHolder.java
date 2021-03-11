package com.example.listview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// ListView item 표시해주는 XML Layout ==> java Object 저장
public class ItemDataHolder {
    public ImageView iconIMG;
    public TextView nameTXT;
    public TextView phoneTXT;
    public TextView addressTXT;

    public ItemDataHolder(View root) {
        this.iconIMG = root.findViewById(R.id.iconIMG);
        this.nameTXT = root.findViewById(R.id.nameTXT);
        this.phoneTXT = root.findViewById(R.id.phoneTXT);
        this.addressTXT = root.findViewById(R.id.addressTXT);
    }
}
