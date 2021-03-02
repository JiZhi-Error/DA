package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.loading.MMProgressLoading;

public final class g extends j implements k, k.a {
    private DialogInterface.OnShowListener FVX;
    private TextView JhH;
    private MMProgressLoading JhI;
    private View contentView;
    private m jCf;
    private DialogInterface.OnCancelListener kke;
    private DialogInterface.OnDismissListener opQ;
    private boolean ox = true;
    private boolean oy;

    public g(Context context) {
        super(context);
        AppMethodBeat.i(147741);
        try {
            onCreate(null);
        } catch (Exception e2) {
        }
        setContentView(R.layout.ccz);
        AppMethodBeat.o(147741);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
        AppMethodBeat.i(147742);
        if (this.FVX != null) {
            this.FVX.onShow(this);
        }
        this.jCf = mVar;
        AppMethodBeat.o(147742);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final View getContentView() {
        return this.contentView;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjb() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void ut(int i2) {
    }

    @Override // android.app.Dialog
    public final void setContentView(int i2) {
        AppMethodBeat.i(147743);
        setContentView(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null));
        AppMethodBeat.o(147743);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(230014);
        this.contentView = view;
        this.JhH = (TextView) this.contentView.findViewById(R.id.jrk);
        AppMethodBeat.o(230014);
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(147744);
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
        AppMethodBeat.o(147744);
    }

    @Override // com.tencent.mm.ui.widget.a.j
    public final void show() {
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        AppMethodBeat.i(147745);
        super.setOnShowListener(onShowListener);
        this.FVX = onShowListener;
        AppMethodBeat.o(147745);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void onCancel() {
        AppMethodBeat.i(147746);
        if (this.kke != null) {
            this.kke.onCancel(this);
        }
        AppMethodBeat.o(147746);
    }

    @Override // com.tencent.mm.ui.widget.a.j
    public final void dismiss() {
        AppMethodBeat.i(147747);
        if (this.jCf != null) {
            this.jCf.c(this);
            if (this.opQ != null) {
                this.opQ.onDismiss(this);
            }
        }
        AppMethodBeat.o(147747);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        AppMethodBeat.i(147748);
        super.setOnDismissListener(onDismissListener);
        this.opQ = onDismissListener;
        AppMethodBeat.o(147748);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k.a
    public final void setCanceledOnTouchOutside(boolean z) {
        AppMethodBeat.i(147749);
        super.setCanceledOnTouchOutside(z);
        this.oy = z;
        AppMethodBeat.o(147749);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjc() {
        return this.oy;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k.a, com.tencent.mm.ui.widget.a.j
    public final void setCancelable(boolean z) {
        AppMethodBeat.i(147750);
        super.setCancelable(z);
        this.ox = z;
        AppMethodBeat.o(147750);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean isCancelable() {
        return this.ox;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final int getPosition() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k.a
    public final void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(147751);
        super.setOnCancelListener(onCancelListener);
        this.kke = onCancelListener;
        AppMethodBeat.o(147751);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k.a, com.tencent.mm.ui.widget.a.j
    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(230015);
        this.JhH.setText(charSequence);
        AppMethodBeat.o(230015);
    }

    public final void setProgress(final int i2) {
        AppMethodBeat.i(230016);
        if (!MMHandlerThread.isMainThread()) {
            this.contentView.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.dialog.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(230013);
                    g.this.setProgress(i2);
                    AppMethodBeat.o(230013);
                }
            });
            AppMethodBeat.o(230016);
            return;
        }
        if (this.JhI == null) {
            this.JhI = (MMProgressLoading) this.contentView.findViewById(R.id.jrl);
            this.JhI.setVisibility(0);
            this.contentView.findViewById(R.id.jrj).setVisibility(8);
        }
        this.JhI.setProgress(i2);
        AppMethodBeat.o(230016);
    }
}
