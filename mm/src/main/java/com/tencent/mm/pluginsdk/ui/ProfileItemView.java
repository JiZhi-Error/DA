package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mm.storage.as;

public abstract class ProfileItemView extends FrameLayout {
    public as rjX;

    public abstract boolean eEV();

    public abstract int getLayout();

    public abstract void init();

    public ProfileItemView(Context context) {
        this(context, null);
    }

    public ProfileItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(getLayout(), this);
        init();
    }

    public boolean aj(as asVar) {
        this.rjX = asVar;
        return eEV();
    }
}
