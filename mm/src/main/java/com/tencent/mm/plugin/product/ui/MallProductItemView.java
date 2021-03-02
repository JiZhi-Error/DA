package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a;

public class MallProductItemView extends LinearLayout {
    private String AQG;
    private TextView Bau;
    private ImageView Bav;
    private int Bbb;
    private Object mData;
    private TextView mPa;
    private String mTitle;
    private int mType;

    public MallProductItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(66984);
        this.Bbb = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.MallProductItemView, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId2 != 0) {
            this.AQG = context.getString(resourceId2);
        }
        this.Bbb = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.bj2, (ViewGroup) this, true);
        this.mPa = (TextView) inflate.findViewById(R.id.ir3);
        this.Bau = (TextView) inflate.findViewById(R.id.iek);
        this.Bav = (ImageView) inflate.findViewById(R.id.dxq);
        this.mPa.setText(this.mTitle);
        this.Bau.setText(this.AQG);
        this.Bau.setLines(this.Bbb);
        AppMethodBeat.o(66984);
    }

    public MallProductItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(66985);
        this.mTitle = str;
        this.mPa.setText(this.mTitle);
        AppMethodBeat.o(66985);
    }

    public void setSummary(String str) {
        AppMethodBeat.i(66986);
        this.AQG = str;
        this.Bau.setText(this.AQG);
        AppMethodBeat.o(66986);
    }

    public void setSummary(Spanned spanned) {
        AppMethodBeat.i(66987);
        this.AQG = spanned.toString();
        this.Bau.setText(this.AQG);
        AppMethodBeat.o(66987);
    }

    public int getType() {
        return this.mType;
    }

    public Object getData() {
        return this.mData;
    }
}
