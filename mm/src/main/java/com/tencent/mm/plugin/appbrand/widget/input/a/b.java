package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.mm.pointers.PInt;

public interface b extends com.tencent.luggage.a.b {

    public static class a {
        public int owH;
        public int owI;
        public int owJ;
    }

    Spannable a(Spannable spannable, int i2, PInt pInt, Spannable.Factory factory);

    SpannableString a(Context context, CharSequence charSequence, float f2);

    a ys(int i2);
}
