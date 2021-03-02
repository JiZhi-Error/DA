package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a;

public class WalletItemView extends LinearLayout {
    private String AQG;
    private TextView Bau;
    private int Bbb;
    private Object mData;
    private TextView mPa;
    private String mTitle;
    private int mType;

    public WalletItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(69847);
        this.Bbb = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.WalletItemView, i2, 0);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.c9g, (ViewGroup) this, true);
        this.mPa = (TextView) inflate.findViewById(R.id.ir3);
        this.Bau = (TextView) inflate.findViewById(R.id.iek);
        if (this.mPa != null) {
            this.mPa.setText(this.mTitle);
        }
        if (this.Bau != null) {
            this.Bau.setText(this.AQG);
            this.Bau.setLines(this.Bbb);
        }
        AppMethodBeat.o(69847);
    }

    public WalletItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(69848);
        this.mTitle = str;
        this.mPa.setText(this.mTitle);
        AppMethodBeat.o(69848);
    }

    public void setSummary(String str) {
        AppMethodBeat.i(69849);
        this.AQG = str;
        this.Bau.setText(this.AQG);
        AppMethodBeat.o(69849);
    }

    public void setSummary(Spanned spanned) {
        AppMethodBeat.i(69850);
        this.AQG = spanned.toString();
        this.Bau.setText(this.AQG);
        AppMethodBeat.o(69850);
    }

    public int getType() {
        return this.mType;
    }

    public Object getData() {
        return this.mData;
    }
}
