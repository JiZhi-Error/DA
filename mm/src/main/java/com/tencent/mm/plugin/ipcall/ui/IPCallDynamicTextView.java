package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView extends TextView {
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25759);
            switch (message.what) {
                case 1:
                    if ((IPCallDynamicTextView.this.yvz <= 0.0d || IPCallDynamicTextView.this.yvA >= IPCallDynamicTextView.this.yvB) && (IPCallDynamicTextView.this.yvz >= 0.0d || IPCallDynamicTextView.this.yvA <= IPCallDynamicTextView.this.yvB)) {
                        IPCallDynamicTextView.this.yvC = false;
                        IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.this.yvB);
                        break;
                    } else {
                        IPCallDynamicTextView.this.yvC = true;
                        IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.this.yvA);
                        IPCallDynamicTextView.this.yvA += IPCallDynamicTextView.this.yvz;
                        IPCallDynamicTextView.this.mHandler.sendEmptyMessageDelayed(1, (long) IPCallDynamicTextView.this.yvE);
                        AppMethodBeat.o(25759);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(25759);
        }
    };
    private int mHeight;
    private String mValue;
    private double yvA;
    private double yvB;
    private boolean yvC;
    private int yvD = 4000;
    private int yvE = 50;
    DecimalFormat yvF = new DecimalFormat("0.00");
    private String yvG = "";
    private String yvH = "";
    private int yvy;
    private double yvz;

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25761);
        init();
        AppMethodBeat.o(25761);
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(25762);
        init();
        AppMethodBeat.o(25762);
    }

    private void init() {
        AppMethodBeat.i(25763);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView.AnonymousClass2 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(25760);
                if (IPCallDynamicTextView.this.yvA != IPCallDynamicTextView.this.yvB) {
                    IPCallDynamicTextView.this.mHandler.sendEmptyMessage(1);
                }
                AppMethodBeat.o(25760);
            }
        });
        AppMethodBeat.o(25763);
    }

    public void setLocHeight(int i2) {
        this.yvy = i2;
    }

    public final void setValue(String str, String str2) {
        AppMethodBeat.i(25764);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            setText(str2);
            AppMethodBeat.o(25764);
            return;
        }
        try {
            this.yvA = Double.parseDouble(aCl(str));
            this.yvG = "";
            int i2 = 0;
            while (i2 < str2.length() && !Character.isDigit(str2.charAt(i2))) {
                this.yvG += str2.charAt(i2);
                i2++;
            }
            this.yvH = "";
            int length = str2.length() - 1;
            while (length > 0 && !Character.isDigit(str2.charAt(length))) {
                this.yvH += str2.charAt(length);
                length--;
            }
            try {
                this.yvB = Double.parseDouble(str2.substring(this.yvG.length(), str2.length() - this.yvH.length()));
                this.mValue = str2;
                this.yvz = (this.yvB - this.yvA) / ((double) (this.yvD / this.yvE));
                if (this.yvz == 0.0d) {
                    setText(str2);
                    AppMethodBeat.o(25764);
                    return;
                }
                this.yvz = new BigDecimal(this.yvz).setScale(2, 4).doubleValue();
                if (isShown()) {
                    this.mHandler.sendEmptyMessage(1);
                }
                AppMethodBeat.o(25764);
            } catch (NumberFormatException e2) {
                setText(str2);
                AppMethodBeat.o(25764);
            }
        } catch (NumberFormatException e3) {
            setText(str2);
            AppMethodBeat.o(25764);
        }
    }

    public static String aCl(String str) {
        AppMethodBeat.i(25765);
        String str2 = "";
        int i2 = 0;
        while (i2 < str.length() && !Character.isDigit(str.charAt(i2))) {
            str2 = str2 + str.charAt(i2);
            i2++;
        }
        String str3 = "";
        int length = str.length() - 1;
        while (length > 0 && !Character.isDigit(str.charAt(length))) {
            str3 = str3 + str.charAt(length);
            length--;
        }
        String substring = str.substring(str2.length(), str.length() - str3.length());
        AppMethodBeat.o(25765);
        return substring;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(25766);
        super.onMeasure(i2, i3);
        this.mHeight = getMeasuredHeight();
        AppMethodBeat.o(25766);
    }

    static /* synthetic */ void a(IPCallDynamicTextView iPCallDynamicTextView, double d2) {
        AppMethodBeat.i(25767);
        if (d2 == iPCallDynamicTextView.yvB) {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.mValue);
            AppMethodBeat.o(25767);
            return;
        }
        iPCallDynamicTextView.setText(iPCallDynamicTextView.yvG + iPCallDynamicTextView.yvF.format(d2) + iPCallDynamicTextView.yvH);
        AppMethodBeat.o(25767);
    }
}
