package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;

final class p extends i implements DialogInterface {
    Button HRF = ((Button) this.NIA.findViewById(R.id.ffp));
    private LinearLayout NIA = ((LinearLayout) aa.jQ(this.mContext).inflate(R.layout.b7h, (ViewGroup) null));
    TextView NIC = ((TextView) this.NIA.findViewById(R.id.ffh));
    private TextView NIE = ((TextView) this.NIA.findViewById(R.id.ffn));
    LinearLayout NIK = ((LinearLayout) this.NIA.findViewById(R.id.ffj));
    private LinearLayout NIM = ((LinearLayout) this.NIA.findViewById(R.id.ffd));
    private TextView jUu = ((TextView) this.NIA.findViewById(R.id.ffq));
    private Context mContext;
    private View olO = this.NIA.findViewById(R.id.ffr);
    private boolean ox;

    public p(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(33393);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(33393);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(33394);
        super.onCreate(bundle);
        setContentView(this.NIA);
        AppMethodBeat.o(33394);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(33395);
        this.olO.setVisibility(0);
        this.jUu.setVisibility(0);
        this.jUu.setMaxLines(2);
        this.jUu.setText(charSequence);
        gIB();
        AppMethodBeat.o(33395);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i2) {
        AppMethodBeat.i(33396);
        this.olO.setVisibility(0);
        this.jUu.setVisibility(0);
        this.jUu.setMaxLines(2);
        this.jUu.setText(i2);
        gIB();
        AppMethodBeat.o(33396);
    }

    private void gIB() {
        AppMethodBeat.i(33397);
        if (this.NIC != null) {
            this.NIC.setTextColor(this.NIC.getContext().getResources().getColor(R.color.ly));
        }
        AppMethodBeat.o(33397);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(33398);
        this.NIK.setVisibility(0);
        this.NIC.setVisibility(0);
        this.NIC.setText(charSequence);
        AppMethodBeat.o(33398);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(33399);
        super.setCancelable(z);
        this.ox = z;
        setCanceledOnTouchOutside(this.ox);
        AppMethodBeat.o(33399);
    }

    public final void gIC() {
        AppMethodBeat.i(33400);
        super.setCancelable(false);
        AppMethodBeat.o(33400);
    }

    @Override // com.tencent.mm.ui.base.i
    public final void show() {
        AppMethodBeat.i(33401);
        try {
            super.show();
            AppMethodBeat.o(33401);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LiteDependDialog", e2, "", new Object[0]);
            AppMethodBeat.o(33401);
        }
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(33402);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.p.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(33392);
                    p.this.dismiss();
                    AppMethodBeat.o(33392);
                }
            });
            Log.e("MicroMsg.LiteDependDialog", Util.getStack().toString());
            AppMethodBeat.o(33402);
            return;
        }
        try {
            super.dismiss();
            AppMethodBeat.o(33402);
        } catch (Exception e2) {
            Log.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(33402);
        }
    }
}
