package com.tencent.mm.plugin.finder.view;

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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class d implements ViewTreeObserver.OnGlobalLayoutListener {
    private LinearLayout QNX;
    private View QOb;
    private TextView QOc;
    private b UVo;
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
    private a wjO = null;

    public interface a {
        void onDismiss();
    }

    public interface b {
    }

    public d(Context context) {
        AppMethodBeat.i(178057);
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.qK = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        Context context2 = this.mContext;
        if (this.mLP) {
            this.mLH = new com.tencent.mm.ui.widget.a.b(context2);
        } else {
            this.mLH = new android.support.design.widget.a(context2, R.style.fq);
        }
        this.lJI = View.inflate(context2, R.layout.agv, null);
        this.QNX = (LinearLayout) this.lJI.findViewById(R.id.ab1);
        this.QOb = this.lJI.findViewById(R.id.aih);
        this.QOc = (TextView) this.lJI.findViewById(R.id.aii);
        this.QNX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.finder.view.d.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(260054);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.bMo();
                if (d.this.UVo != null) {
                    b unused = d.this.UVo;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(260054);
            }
        });
        this.mLL = isLandscape();
        this.mLH.setContentView(this.lJI);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        this.mLK.setState(3);
        this.mLK.ok = new BottomSheetBehavior.a() {
            /* class com.tencent.mm.plugin.finder.view.d.AnonymousClass2 */

            @Override // android.support.design.widget.BottomSheetBehavior.a
            public final void f(View view, int i2) {
            }

            @Override // android.support.design.widget.BottomSheetBehavior.a
            public final void m(View view) {
            }
        };
        this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.finder.view.d.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(260055);
                if (d.this.afI != null) {
                    if (!d.this.afI.isAlive()) {
                        d.this.afI = d.this.qK.getViewTreeObserver();
                    }
                    d.this.afI.removeGlobalOnLayoutListener(d.this);
                    d.this.afI = null;
                }
                if (!d.this.wjN) {
                    d.this.mLH = null;
                }
                if (d.this.wjO != null) {
                    d.this.wjO.onDismiss();
                }
                AppMethodBeat.o(260055);
            }
        });
        AppMethodBeat.o(178057);
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(178058);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(178058);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(178058);
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.i(178059);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            i2 = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(178059);
        return i2;
    }

    public final d Ml(int i2) {
        AppMethodBeat.i(241821);
        LayoutInflater.from(this.lJI.getContext()).inflate(i2, (ViewGroup) ((LinearLayout) this.lJI.findViewById(R.id.ab3)), true);
        AppMethodBeat.o(241821);
        return this;
    }

    public final void dGm() {
        boolean z;
        AppMethodBeat.i(178061);
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
        AppMethodBeat.o(178061);
    }

    public final void bMo() {
        AppMethodBeat.i(178062);
        if (this.mLH != null) {
            if (!(this.mContext instanceof Activity) || (this.mContext != null && !((Activity) this.mContext).isFinishing() && !((Activity) this.mContext).isDestroyed())) {
                this.mLH.dismiss();
            }
            if (this.mLK != null) {
                this.mLK.ob = true;
            }
        }
        AppMethodBeat.o(178062);
    }

    private boolean isShowing() {
        AppMethodBeat.i(178063);
        if (this.mLH == null || !this.mLH.isShowing()) {
            AppMethodBeat.o(178063);
            return false;
        }
        AppMethodBeat.o(178063);
        return true;
    }

    private boolean isLandscape() {
        AppMethodBeat.i(178064);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(178064);
            return true;
        }
        AppMethodBeat.o(178064);
        return false;
    }

    public final void a(a aVar) {
        this.wjO = aVar;
    }

    public final void hVw() {
        this.wjN = true;
    }

    public final void hVx() {
        AppMethodBeat.i(260056);
        if (this.QNX == null) {
            AppMethodBeat.o(260056);
            return;
        }
        this.QNX.setVisibility(0);
        AppMethodBeat.o(260056);
    }

    public final d hVy() {
        AppMethodBeat.i(260057);
        if (this.lJI != null) {
            this.lJI.setBackgroundResource(R.drawable.b1d);
            this.QOb.setBackgroundColor(this.mContext.getResources().getColor(R.color.x));
            this.QOc.setTextColor(this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
            this.QOc.setBackgroundResource(R.drawable.r_);
        }
        AppMethodBeat.o(260057);
        return this;
    }
}
