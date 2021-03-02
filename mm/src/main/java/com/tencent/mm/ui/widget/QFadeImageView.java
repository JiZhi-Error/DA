package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.memory.ui.QPictureView;

public class QFadeImageView extends QPictureView {
    long DMd;
    String key;

    public QFadeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFadeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void T(long j2, String str) {
        this.DMd = j2;
        this.key = str;
    }

    public String getImageKey() {
        return this.key;
    }

    public long getStartTimeMillis() {
        return this.DMd;
    }
}
