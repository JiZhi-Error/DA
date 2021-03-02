package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;

public class b extends d implements k {
    private DialogInterface.OnShowListener FVX;
    private boolean FWb = false;
    private View contentView;
    private m jCf;
    private DialogInterface.OnCancelListener kke;
    private DialogInterface.OnDismissListener opQ;
    private boolean ox = true;
    private boolean oy;

    public b(Context context) {
        super(context, (byte) 0);
        AppMethodBeat.i(135470);
        setContentView(super.getContentView());
        setCanceledOnTouchOutside(false);
        AppMethodBeat.o(135470);
    }

    public b(Context context, byte b2) {
        super(context, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
        AppMethodBeat.i(135471);
        if (this.FVX != null) {
            this.FVX.onShow(this);
        }
        this.jCf = mVar;
        AppMethodBeat.o(135471);
    }

    @Override // com.tencent.mm.ui.widget.a.d, com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final View getContentView() {
        AppMethodBeat.i(135472);
        if (this.contentView != null) {
            View view = this.contentView;
            AppMethodBeat.o(135472);
            return view;
        }
        View contentView2 = super.getContentView();
        AppMethodBeat.o(135472);
        return contentView2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjb() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void ut(int i2) {
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        AppMethodBeat.i(135473);
        setContentView(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null));
        AppMethodBeat.o(135473);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        AppMethodBeat.i(135474);
        if (!(view instanceof a)) {
            view = new a(view.getContext(), view);
        }
        this.contentView = view;
        AppMethodBeat.o(135474);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(135475);
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
        AppMethodBeat.o(135475);
    }

    @Override // com.tencent.mm.ui.widget.a.d
    public void show() {
    }

    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        AppMethodBeat.i(135476);
        super.setOnShowListener(onShowListener);
        this.FVX = onShowListener;
        AppMethodBeat.o(135476);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void onCancel() {
        AppMethodBeat.i(135477);
        if (this.kke != null) {
            this.kke.onCancel(this);
        }
        AppMethodBeat.o(135477);
    }

    @Override // com.tencent.mm.ui.widget.a.d
    public void dismiss() {
        AppMethodBeat.i(135478);
        if (this.FWb) {
            AppMethodBeat.o(135478);
            return;
        }
        this.FWb = true;
        if (this.jCf != null) {
            this.jCf.c(this);
            if (this.opQ != null) {
                this.opQ.onDismiss(this);
            }
        }
        AppMethodBeat.o(135478);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        AppMethodBeat.i(135479);
        super.setOnDismissListener(onDismissListener);
        this.opQ = onDismissListener;
        AppMethodBeat.o(135479);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        AppMethodBeat.i(135480);
        super.setCanceledOnTouchOutside(z);
        this.oy = z;
        AppMethodBeat.o(135480);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjc() {
        return this.oy;
    }

    @Override // com.tencent.mm.ui.widget.a.d
    public void setCancelable(boolean z) {
        AppMethodBeat.i(135481);
        super.setCancelable(z);
        this.ox = z;
        AppMethodBeat.o(135481);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean isCancelable() {
        return this.ox;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public int getPosition() {
        return 1;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(135482);
        super.setOnCancelListener(onCancelListener);
        this.kke = onCancelListener;
        AppMethodBeat.o(135482);
    }
}
