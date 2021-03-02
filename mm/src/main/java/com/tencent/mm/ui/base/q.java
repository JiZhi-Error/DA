package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public class q extends r {
    private TextView NIC;
    private View mContentView;
    private Context mContext;
    public ProgressBar olQ;
    private int style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected q(Context context, int i2, int i3) {
        super(context, i2);
        int i4 = R.layout.ba5;
        AppMethodBeat.i(142066);
        this.mContext = context;
        this.style = i3;
        switch (this.style) {
            case 1:
                i4 = R.layout.ba6;
                break;
        }
        this.mContentView = aa.jQ(this.mContext).inflate(i4, (ViewGroup) null);
        this.NIC = (TextView) this.mContentView.findViewById(R.id.fgd);
        this.NIC.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.base.q.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(205237);
                if (q.this.NIC.getLineCount() > 1) {
                    q.this.NIC.setTextSize(0, (float) a.aG(q.this.mContext, R.dimen.bd));
                }
                q.this.NIC.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AppMethodBeat.o(205237);
            }
        });
        this.olQ = (ProgressBar) this.mContentView.findViewById(R.id.fgc);
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(142066);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(142067);
        super.onCreate(bundle);
        setContentView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        if (this.style == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(142067);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(142068);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(142068);
    }

    public void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(142069);
        this.NIC.setText(charSequence);
        AppMethodBeat.o(142069);
    }

    public static q b(Context context, CharSequence charSequence, boolean z, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(259381);
        q a2 = a(context, charSequence, z, i2, -1, onCancelListener);
        AppMethodBeat.o(259381);
        return a2;
    }

    private static q a(Context context, CharSequence charSequence, boolean z, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(142071);
        if (i3 <= 0) {
            switch (i2) {
                case 0:
                    i3 = R.style.a66;
                    break;
                case 1:
                    i3 = R.style.a66;
                    break;
                case 2:
                    i3 = R.style.a66;
                    break;
                case 3:
                    i3 = R.style.a6a;
                    break;
                default:
                    i3 = R.style.a6a;
                    break;
            }
        }
        q qVar = new q(context, i3, i2);
        qVar.setMessage(charSequence);
        qVar.setCancelable(z);
        qVar.setOnCancelListener(onCancelListener);
        qVar.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(142071);
        return qVar;
    }

    public static q a(Context context, CharSequence charSequence, boolean z, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(142072);
        q b2 = b(context, charSequence, z, i2, -1, onCancelListener);
        AppMethodBeat.o(142072);
        return b2;
    }

    public static q b(Context context, CharSequence charSequence, boolean z, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(142073);
        q a2 = a(context, charSequence, z, i2, i3, onCancelListener);
        a2.show();
        AppMethodBeat.o(142073);
        return a2;
    }

    public void show() {
        AppMethodBeat.i(142074);
        try {
            super.show();
            AppMethodBeat.o(142074);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMProgressDialog", e2, "", new Object[0]);
            AppMethodBeat.o(142074);
        }
    }

    @Override // com.tencent.mm.ui.base.r
    public void dismiss() {
        AppMethodBeat.i(142075);
        try {
            super.dismiss();
            AppMethodBeat.o(142075);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(142075);
        }
    }
}
