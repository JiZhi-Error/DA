package com.tencent.mm.kiss.widget.textview;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

public final class f {
    public int breakStrategy = -1;
    public int gravity;
    public boolean huF = true;
    CharSequence huG;
    public StaticLayout huH;
    public Layout.Alignment huw;
    public TextUtils.TruncateAt hux;
    public TextPaint iW;
    public int maxLength;
    public int maxLines;
    CharSequence text;

    public f(StaticLayout staticLayout) {
        this.huH = staticLayout;
    }
}
