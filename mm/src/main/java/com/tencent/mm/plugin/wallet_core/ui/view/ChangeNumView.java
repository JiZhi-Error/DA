package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ChangeNumView extends TextView {
    private int FNL = -1;
    private int ImS = 0;
    private boolean ImT = false;
    private final int ImU = 100;
    private int max = 0;
    private int min = 0;

    public ChangeNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeNumView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setInteral(int i2) {
        this.FNL = i2;
    }
}
