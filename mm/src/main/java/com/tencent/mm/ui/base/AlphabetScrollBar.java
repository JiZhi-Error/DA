package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.rtmp.sharp.jni.QLog;

public class AlphabetScrollBar extends VerticalScrollBar {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.VerticalScrollBar
    public void ann() {
        this.yuX = new String[]{"↑", "☆", "A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.yuV = 1.6f;
        this.yuW = 79;
    }

    public AlphabetScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.VerticalScrollBar
    public int getToastLayoutId() {
        return R.layout.bsf;
    }

    public void setTextColor(int i2) {
        this.textColor = i2;
    }

    public void setWhiteTextColor(int i2) {
        this.OWM = i2;
    }

    public void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
    }
}
