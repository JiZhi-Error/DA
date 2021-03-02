package com.tencent.mm.ui.widget.cedit.edit;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class AdaptEditText extends AppCompatEditText {
    public AdaptEditText(Context context) {
        super(context);
    }

    public AdaptEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdaptEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean hasFocus() {
        return true;
    }
}
