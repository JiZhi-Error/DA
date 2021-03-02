package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.r;

public final class h extends r {
    private TextView NIC;
    private View mContentView = null;
    private Context mContext;
    private ProgressBar olQ;

    private h(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(73061);
        this.mContext = context;
        if (this.mContentView == null) {
            this.mContentView = View.inflate(this.mContext, R.layout.c_o, null);
            this.NIC = (TextView) this.mContentView.findViewById(R.id.fgd);
            this.olQ = (ProgressBar) this.mContentView.findViewById(R.id.fgc);
            setCanceledOnTouchOutside(true);
        }
        AppMethodBeat.o(73061);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(73062);
        super.onCreate(bundle);
        setContentView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().addFlags(2);
        attributes.dimAmount = 0.65f;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(73062);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(73063);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(73063);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(73064);
        this.NIC.setText(charSequence);
        AppMethodBeat.o(73064);
    }

    public static Dialog c(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(73065);
        h hVar = new h(context);
        hVar.setMessage(charSequence);
        hVar.setCancelable(z);
        hVar.setOnCancelListener(onCancelListener);
        hVar.setCanceledOnTouchOutside(false);
        hVar.show();
        AppMethodBeat.o(73065);
        return hVar;
    }

    public static Dialog a(Context context, String str, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(73066);
        View inflate = View.inflate(context, R.layout.c_p, null);
        h(context, inflate);
        ((TextView) inflate.findViewById(R.id.br5)).setText(str);
        i iVar = new i(context, R.style.a14);
        iVar.setCancelable(false);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        AppMethodBeat.o(73066);
        return iVar;
    }

    public static Dialog a(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(73067);
        View inflate = View.inflate(context, R.layout.c_p, null);
        h(context, inflate);
        i iVar = new i(context, R.style.a14);
        iVar.setCancelable(z);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        AppMethodBeat.o(73067);
        return iVar;
    }

    public static Dialog b(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(73068);
        View inflate = View.inflate(context, R.layout.c_p, null);
        h(context, inflate);
        i iVar = new i(context, R.style.a14);
        iVar.setCancelable(z);
        iVar.setContentView(inflate);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        AppMethodBeat.o(73068);
        return iVar;
    }

    public static Dialog c(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(73069);
        context.getString(R.string.ty);
        q a2 = com.tencent.mm.ui.base.h.a(context, context.getString(R.string.inu), z, onCancelListener);
        AppMethodBeat.o(73069);
        return a2;
    }

    private static void h(Context context, View view) {
        AppMethodBeat.i(214343);
        float ez = a.ez(context);
        float f2 = ez > 1.4f ? 1.4f : ez;
        float fromDPToPix = (float) a.fromDPToPix(context, 8.0f);
        TextView textView = (TextView) view.findViewById(R.id.br5);
        float minimumWidth = (float) view.getMinimumWidth();
        TextPaint paint = textView.getPaint();
        float measureText = paint.measureText(textView.getText().toString());
        float gvi = com.tencent.mm.cc.a.gvi();
        if (((minimumWidth - measureText) * gvi) / 2.0f < fromDPToPix) {
            float[] fArr = {1.4f, 1.125f, 1.12f, 1.1f, 1.0f, 0.8f};
            float textSize = textView.getTextSize();
            float f3 = f2;
            for (int i2 = 0; i2 < 6; i2++) {
                if (f3 >= fArr[i2]) {
                    f3 = fArr[i2];
                    paint.setTextSize((textSize / f2) * f3);
                    float measureText2 = paint.measureText(textView.getText().toString());
                    float f4 = ((minimumWidth - measureText2) * gvi) / 2.0f;
                    Log.i("MicroMsg.WalletProgressDialog", "resetTextSize viewPx:" + minimumWidth + " tvPx:" + measureText2 + " fontScale:" + f3 + " distance:" + f4);
                    if (f4 >= fromDPToPix) {
                        break;
                    }
                }
            }
            textView.setTextSize(0, (textSize / f2) * f3);
        }
        AppMethodBeat.o(214343);
    }

    @Override // com.tencent.mm.ui.base.r
    public final void dismiss() {
        AppMethodBeat.i(73070);
        try {
            super.dismiss();
            AppMethodBeat.o(73070);
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(73070);
        }
    }
}
