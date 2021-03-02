package com.tencent.mm.ui.chatting.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.a;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.a.e;

public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public e.b PGl;
    public boolean PGm = false;
    public ViewTreeObserver afI;
    public View lJI;
    public Context mContext;
    public Dialog mLH;
    public BottomSheetBehavior mLK;
    public boolean mLL = false;
    public int mLM;
    public boolean mLO = false;
    public View qK;
    private boolean wjN = false;

    public b(Context context, View view) {
        AppMethodBeat.i(185898);
        this.lJI = view;
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.qK = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        this.mLH = new a(this.mContext, R.style.fq);
        this.mLL = isLandscape();
        if (this.mLH != null) {
            this.mLH.setContentView(this.lJI);
        }
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        this.mLK.setState(3);
        if (this.mLH != null) {
            this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.ui.chatting.view.b.AnonymousClass1 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(185896);
                    if (b.this.afI != null) {
                        if (!b.this.afI.isAlive()) {
                            b.this.afI = b.this.qK.getViewTreeObserver();
                        }
                        b.this.afI.removeGlobalOnLayoutListener(b.this);
                        b.this.afI = null;
                    }
                    if (!b.this.wjN) {
                        b.this.mLH = null;
                    }
                    AppMethodBeat.o(185896);
                }
            });
        }
        AppMethodBeat.o(185898);
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(185899);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(185899);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(185899);
    }

    @SuppressLint({"WrongConstant"})
    public final int getRotation() {
        AppMethodBeat.i(185900);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            i2 = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(185900);
        return i2;
    }

    public final void bMo() {
        AppMethodBeat.i(185901);
        if (this.mLH != null) {
            if (this.mLK != null) {
                this.mLK.ob = true;
            }
            if (!(this.mContext instanceof Activity) || (this.mContext != null && !((Activity) this.mContext).isFinishing() && !((Activity) this.mContext).isDestroyed())) {
                this.mLH.dismiss();
            }
        }
        AppMethodBeat.o(185901);
    }

    public final boolean isLandscape() {
        AppMethodBeat.i(185902);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(185902);
            return true;
        }
        AppMethodBeat.o(185902);
        return false;
    }

    private boolean isShowing() {
        AppMethodBeat.i(185903);
        if (this.mLH == null || !this.mLH.isShowing()) {
            AppMethodBeat.o(185903);
            return false;
        }
        AppMethodBeat.o(185903);
        return true;
    }
}
