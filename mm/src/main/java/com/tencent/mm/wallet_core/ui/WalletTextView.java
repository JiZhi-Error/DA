package com.tencent.mm.wallet_core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.f.b;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView extends TextView {
    private static final String TAG = ("MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString());
    private Object RvL;
    private int RvM;
    private String mPrefix;

    static {
        AppMethodBeat.i(73077);
        AppMethodBeat.o(73077);
    }

    public WalletTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WalletTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(73071);
        this.RvL = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.WalletTextViewAttrs, i2, 0);
        this.RvM = obtainStyledAttributes.getInteger(1, 4);
        this.mPrefix = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        try {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), f.aqk(this.RvM)));
            AppMethodBeat.o(73071);
        } catch (Exception e2) {
            Log.e(TAG, "updateWalletTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(73071);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String str;
        AppMethodBeat.i(73072);
        String charSequence2 = charSequence.toString();
        if (charSequence2 == null || charSequence2.length() == 0) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder(7);
            for (int i2 = 0; i2 < 7; i2++) {
                sb.append((char) ((int) ((6222620280936476253 >> ((6 - i2) * 8)) & 255)));
            }
            String sb2 = sb.toString();
            sb.delete(0, sb.length());
            str = charSequence2.replaceAll(sb2, sb.toString());
        }
        this.RvL = str;
        String str2 = !Util.isNullOrNil(this.mPrefix) ? this.mPrefix + ((Object) charSequence) : charSequence;
        if (this.RvM < 4 && !Util.isNullOrNil(str2) && Pattern.compile(".*?[a-zA-Z]+.*?").matcher(str2).matches()) {
            Log.i(TAG, "force use std font");
            if (str2 instanceof String) {
                str2 = ((String) str2).toLowerCase();
            }
        }
        super.setText(str2, bufferType);
        AppMethodBeat.o(73072);
    }

    public void setTypeface(int i2) {
        AppMethodBeat.i(73073);
        this.RvM = i2;
        try {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), f.aqk(i2)));
            AppMethodBeat.o(73073);
        } catch (Exception e2) {
            Log.e(TAG, "setTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(73073);
        }
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    @Deprecated
    public CharSequence getText() {
        AppMethodBeat.i(73074);
        if (com.tencent.mm.wallet_core.f.a.hhH().ew(this)) {
            CharSequence text = super.getText();
            AppMethodBeat.o(73074);
            return text;
        }
        Log.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
        if (b.hhK() || g.isMIUI()) {
            CharSequence charSequence = (CharSequence) (b.hhJ() ? this.RvL : super.getText());
            AppMethodBeat.o(73074);
            return charSequence;
        }
        CharSequence text2 = super.getText();
        AppMethodBeat.o(73074);
        return text2;
    }
}
