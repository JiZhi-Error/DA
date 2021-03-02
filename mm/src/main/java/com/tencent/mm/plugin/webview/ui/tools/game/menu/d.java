package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b;
import com.tencent.mm.ui.base.m;

public final class d implements ViewTreeObserver.OnGlobalLayoutListener {
    private m HMc;
    private e JrZ;
    public b.AbstractC1995b Jsa;
    private GameMenuView Jsb;
    private f Jsc;
    private ViewTreeObserver afI;
    private Context mContext;
    private boolean mLL = false;
    public boolean mLN;
    public boolean mLO = false;
    private View qK;
    private boolean wjM;

    public final void onGlobalLayout() {
        AppMethodBeat.i(80972);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || !view.isShown()) {
                bMo();
                AppMethodBeat.o(80972);
                return;
            } else if (isShowing() && this.mLL != isLandscape()) {
                bMo();
            }
        }
        AppMethodBeat.o(80972);
    }

    public d(Context context) {
        AppMethodBeat.i(80973);
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.qK = viewGroup.getChildAt(0);
            } else {
                this.qK = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.HMc = new m(context2);
        this.JrZ = new e(context2);
        this.Jsb = new GameMenuView(context2);
        this.Jsc = new f(context2);
        this.Jsb.setAdapter(this.Jsc);
        this.mLL = isLandscape();
        this.JrZ.setContentView(this.Jsb);
        AppMethodBeat.o(80973);
    }

    @TargetApi(23)
    private void ghk() {
        AppMethodBeat.i(80974);
        if (Build.VERSION.SDK_INT >= 23 && this.JrZ != null) {
            this.JrZ.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.JrZ.getWindow().setStatusBarColor(0);
        }
        AppMethodBeat.o(80974);
    }

    public final void dGm() {
        boolean z = false;
        AppMethodBeat.i(80975);
        this.mLL = isLandscape();
        if (this.Jsa != null) {
            this.Jsa.onCreateMMMenu(this.HMc);
        }
        if (this.JrZ != null) {
            if (this.Jsc != null) {
                this.Jsc.a(this.HMc);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.JrZ.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.wjM) {
                ghk();
            }
            if (this.mLN) {
                this.JrZ.getWindow().addFlags(1024);
            }
            if (this.mLO) {
                this.JrZ.getWindow().setFlags(8, 8);
                this.JrZ.getWindow().addFlags(131200);
                this.JrZ.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.JrZ.getWindow().clearFlags(8);
                this.JrZ.getWindow().clearFlags(131072);
                this.JrZ.getWindow().clearFlags(128);
                this.JrZ.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.qK != null) {
                if (this.afI == null) {
                    z = true;
                }
                this.afI = this.qK.getViewTreeObserver();
                if (z) {
                    this.afI.addOnGlobalLayoutListener(this);
                }
            }
            this.JrZ.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.game.menu.d.AnonymousClass1 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(80970);
                    d.this.bMo();
                    AppMethodBeat.o(80970);
                }
            });
            if (this.Jsb != null) {
                this.Jsb.setDismissListener(new b.a() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.game.menu.d.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a
                    public final void onDismiss() {
                        AppMethodBeat.i(80971);
                        d.this.bMo();
                        AppMethodBeat.o(80971);
                    }
                });
            }
            this.JrZ.show();
        }
        AppMethodBeat.o(80975);
    }

    public final void bMo() {
        AppMethodBeat.i(80976);
        if (this.afI != null) {
            if (!this.afI.isAlive()) {
                this.afI = this.qK.getViewTreeObserver();
            }
            this.afI.removeGlobalOnLayoutListener(this);
            this.afI = null;
        }
        if (this.JrZ != null) {
            this.JrZ.dismiss();
        }
        AppMethodBeat.o(80976);
    }

    private boolean isShowing() {
        AppMethodBeat.i(80977);
        if (this.JrZ == null) {
            AppMethodBeat.o(80977);
            return false;
        } else if (this.JrZ.isShowing()) {
            AppMethodBeat.o(80977);
            return true;
        } else {
            AppMethodBeat.o(80977);
            return false;
        }
    }

    public final void a(b.c cVar) {
        AppMethodBeat.i(80978);
        if (this.Jsb != null) {
            this.Jsb.setGameMenuItemSelectedListener(cVar);
        }
        AppMethodBeat.o(80978);
    }

    private boolean isLandscape() {
        AppMethodBeat.i(80979);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            AppMethodBeat.o(80979);
            return true;
        }
        AppMethodBeat.o(80979);
        return false;
    }
}
