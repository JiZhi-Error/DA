package com.tencent.mm.plugin.multitask.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.BottomSheetBehavior;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.a.b;

public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
    private AbstractC1517a Aca = null;
    private ViewTreeObserver afI;
    public View lJI;
    private Context mContext;
    private Dialog mLH;
    private BottomSheetBehavior mLK;
    private boolean mLL = false;
    private int mLM;
    private boolean mLO = false;
    private boolean mLP = false;
    private View qK;
    private boolean wjM;
    private boolean wjN = false;

    /* renamed from: com.tencent.mm.plugin.multitask.e.a$a  reason: collision with other inner class name */
    public interface AbstractC1517a {
        void onDismiss();
    }

    public a(Context context) {
        AppMethodBeat.i(200263);
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.qK = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        Context context2 = this.mContext;
        if (this.mLP) {
            this.mLH = new b(context2);
        } else {
            this.mLH = new android.support.design.widget.a(context2, R.style.fq);
        }
        this.lJI = View.inflate(context2, R.layout.bdk, null);
        this.mLL = isLandscape();
        this.mLH.setContentView(this.lJI);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        this.mLK.setState(3);
        this.mLK.ok = new BottomSheetBehavior.a() {
            /* class com.tencent.mm.plugin.multitask.e.a.AnonymousClass1 */

            @Override // android.support.design.widget.BottomSheetBehavior.a
            public final void f(View view, int i2) {
            }

            @Override // android.support.design.widget.BottomSheetBehavior.a
            public final void m(View view) {
            }
        };
        this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.multitask.e.a.AnonymousClass2 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(200262);
                if (a.this.afI != null) {
                    if (!a.this.afI.isAlive()) {
                        a.this.afI = a.this.qK.getViewTreeObserver();
                    }
                    a.this.afI.removeGlobalOnLayoutListener(a.this);
                    a.this.afI = null;
                }
                if (!a.this.wjN) {
                    a.this.mLH = null;
                }
                if (a.this.Aca != null) {
                    a.this.Aca.onDismiss();
                }
                AppMethodBeat.o(200262);
            }
        });
        AppMethodBeat.o(200263);
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(200264);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(200264);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(200264);
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.i(200265);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            i2 = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(200265);
        return i2;
    }

    public final a erk() {
        AppMethodBeat.i(200266);
        LayoutInflater.from(this.lJI.getContext()).inflate(R.layout.bdo, (ViewGroup) ((LinearLayout) this.lJI.findViewById(R.id.ab3)), true);
        AppMethodBeat.o(200266);
        return this;
    }

    public final void dGm() {
        boolean z;
        AppMethodBeat.i(200267);
        this.mLL = isLandscape();
        this.mLM = getRotation();
        if (this.mLH != null) {
            ((ViewGroup) this.lJI.getParent()).setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
            if (this.mLL && this.qK != null) {
                Rect rect = new Rect();
                this.qK.getWindowVisibleDisplayFrame(rect);
                layoutParams.width = rect.right;
            }
            this.lJI.setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 21) {
                this.mLH.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.wjM && Build.VERSION.SDK_INT >= 23 && this.mLH != null) {
                this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.mLH.getWindow().setStatusBarColor(0);
            }
            if (this.mLO) {
                this.mLH.getWindow().setFlags(8, 8);
                this.mLH.getWindow().addFlags(131200);
                this.mLH.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.mLH.getWindow().clearFlags(8);
                this.mLH.getWindow().clearFlags(131072);
                this.mLH.getWindow().clearFlags(128);
                this.mLH.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.qK != null) {
                if (this.afI == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.afI = this.qK.getViewTreeObserver();
                if (z) {
                    this.afI.addOnGlobalLayoutListener(this);
                }
            }
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
                this.mLH.show();
            }
            if (this.mLK != null) {
                this.mLK.ob = false;
            }
        }
        AppMethodBeat.o(200267);
    }

    public final void bMo() {
        AppMethodBeat.i(200268);
        if (this.mLH != null) {
            if (!(this.mContext instanceof Activity) || (this.mContext != null && !((Activity) this.mContext).isFinishing() && !((Activity) this.mContext).isDestroyed())) {
                this.mLH.dismiss();
            }
            if (this.mLK != null) {
                this.mLK.ob = true;
            }
        }
        AppMethodBeat.o(200268);
    }

    private boolean isShowing() {
        AppMethodBeat.i(200269);
        if (this.mLH == null || !this.mLH.isShowing()) {
            AppMethodBeat.o(200269);
            return false;
        }
        AppMethodBeat.o(200269);
        return true;
    }

    private boolean isLandscape() {
        AppMethodBeat.i(200270);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(200270);
            return true;
        }
        AppMethodBeat.o(200270);
        return false;
    }

    public final void a(AbstractC1517a aVar) {
        this.Aca = aVar;
    }
}
