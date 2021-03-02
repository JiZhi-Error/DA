package com.tencent.mm.ui.widget.a;

import android.annotation.TargetApi;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public class g implements ViewTreeObserver.OnGlobalLayoutListener {
    private int HMp = 0;
    private int HMq = 0;
    private LinearLayout HMr;
    private Button HMs;
    private Button HMt;
    private Button HMu;
    private LinearLayout HMv;
    private LinearLayout HMw;
    private LinearLayout HMx;
    private TextView HMy;
    private a QOR;
    private a QOS;
    public a QOT;
    private ViewTreeObserver afI;
    private int kca;
    public View lJI;
    private Context mContext;
    private Dialog mLH;
    private BottomSheetBehavior mLK;
    private boolean mLL = false;
    private int mLM;
    private boolean mLO = false;
    private boolean ox = true;
    private View qK;
    private boolean wjM;
    private boolean wjN = false;

    public interface a {
        void onClick();
    }

    public g(Context context) {
        AppMethodBeat.i(198255);
        this.mContext = context;
        this.HMp = 0;
        this.HMq = 0;
        bh(this.mContext);
        AppMethodBeat.o(198255);
    }

    public g(Context context, int i2, int i3) {
        AppMethodBeat.i(198256);
        this.mContext = context;
        this.HMp = i2;
        this.HMq = i3;
        bh(this.mContext);
        AppMethodBeat.o(198256);
    }

    public g(Context context, int i2, int i3, boolean z) {
        AppMethodBeat.i(198257);
        this.mContext = context;
        this.HMp = i2;
        this.HMq = i3;
        this.ox = z;
        bh(this.mContext);
        AppMethodBeat.o(198257);
    }

    public void onGlobalLayout() {
        AppMethodBeat.i(198258);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(198258);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(198258);
    }

    private int getRotation() {
        AppMethodBeat.i(198259);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            i2 = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(198259);
        return i2;
    }

    private void bh(Context context) {
        AppMethodBeat.i(198260);
        if (this.mContext instanceof Activity) {
            this.qK = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        this.mLH = new android.support.design.widget.a(context, R.style.fq);
        this.lJI = View.inflate(context, R.layout.b8b, null);
        this.HMv = (LinearLayout) this.lJI.findViewById(R.id.ab9);
        this.HMw = (LinearLayout) this.lJI.findViewById(R.id.ab4);
        this.HMx = (LinearLayout) this.lJI.findViewById(R.id.ab3);
        fPz();
        initHeaderView();
        this.mLL = isLandscape();
        this.mLH.setContentView(this.lJI);
        this.mLH.setCancelable(this.ox);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        this.mLK.setState(3);
        this.mLK.ok = new BottomSheetBehavior.a() {
            /* class com.tencent.mm.ui.widget.a.g.AnonymousClass1 */

            @Override // android.support.design.widget.BottomSheetBehavior.a
            public final void f(View view, int i2) {
            }

            @Override // android.support.design.widget.BottomSheetBehavior.a
            public final void m(View view) {
            }
        };
        this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.ui.widget.a.g.AnonymousClass2 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(198250);
                if (g.this.afI != null) {
                    if (!g.this.afI.isAlive()) {
                        g.this.afI = g.this.qK.getViewTreeObserver();
                    }
                    g.this.afI.removeGlobalOnLayoutListener(g.this);
                    g.this.afI = null;
                }
                if (!g.this.wjN) {
                    g.this.mLH = null;
                }
                AppMethodBeat.o(198250);
            }
        });
        AppMethodBeat.o(198260);
    }

    public final void setHeight(int i2) {
        AppMethodBeat.i(198261);
        if (i2 != 0) {
            this.kca = i2;
            if (this.kca != 0) {
                this.mLK.J(this.kca);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
            layoutParams.height = i2;
            this.lJI.setLayoutParams(layoutParams);
            this.lJI.invalidate();
        }
        AppMethodBeat.o(198261);
    }

    public final void b(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(198262);
        if (!(this.HMs == null || this.HMt == null)) {
            this.HMs.setText(charSequence);
            this.HMt.setText(charSequence2);
        }
        AppMethodBeat.o(198262);
    }

    public final void apd(int i2) {
        AppMethodBeat.i(198263);
        if (this.HMs != null) {
            this.HMs.setTextColor(i2);
        }
        AppMethodBeat.o(198263);
    }

    public final void aeF(int i2) {
        AppMethodBeat.i(198264);
        if (this.HMu != null) {
            this.HMu.setTextColor(i2);
        }
        AppMethodBeat.o(198264);
    }

    public final void a(a aVar, a aVar2) {
        this.QOR = aVar;
        this.QOS = aVar2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void axv(int i2) {
        AppMethodBeat.i(258269);
        if (this.HMt != null) {
            switch (i2) {
                case 0:
                    this.HMt.setBackgroundResource(R.drawable.k7);
                    AppMethodBeat.o(258269);
                    return;
                case 2:
                    this.HMt.setBackgroundResource(R.drawable.kb);
                    AppMethodBeat.o(258269);
                    return;
                case 3:
                    this.HMt.setBackgroundResource(R.drawable.kg);
                    AppMethodBeat.o(258269);
                    return;
                case 4:
                    this.HMt.setBackgroundResource(R.drawable.k3);
                    AppMethodBeat.o(258269);
                    return;
                case 5:
                    this.HMt.setBackgroundResource(R.drawable.k_);
                    break;
            }
        }
        AppMethodBeat.o(258269);
    }

    public final void T(CharSequence charSequence) {
        AppMethodBeat.i(198266);
        if (this.HMu != null) {
            this.HMu.setText(charSequence);
        }
        AppMethodBeat.o(198266);
    }

    public final void a(a aVar) {
        this.QOT = aVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void ape(int i2) {
        AppMethodBeat.i(198267);
        if (this.HMu != null) {
            this.HMu.setTextColor(this.mContext.getResources().getColor(R.color.jq));
            switch (i2) {
                case 0:
                    this.HMu.setBackgroundResource(R.drawable.k7);
                    AppMethodBeat.o(198267);
                    return;
                case 1:
                    this.HMu.setBackgroundResource(R.drawable.k9);
                    this.HMu.setTextColor(this.mContext.getResources().getColor(R.color.ag0));
                    AppMethodBeat.o(198267);
                    return;
                case 2:
                    this.HMu.setBackgroundResource(R.drawable.kb);
                    AppMethodBeat.o(198267);
                    return;
                case 3:
                    this.HMu.setBackgroundResource(R.drawable.kg);
                    AppMethodBeat.o(198267);
                    return;
                case 4:
                    this.HMu.setBackgroundResource(R.drawable.k3);
                    AppMethodBeat.o(198267);
                    return;
                case 5:
                    this.HMu.setBackgroundResource(R.drawable.k_);
                    break;
            }
        }
        AppMethodBeat.o(198267);
    }

    public final void aE(CharSequence charSequence) {
        AppMethodBeat.i(198268);
        if (this.HMy != null) {
            this.HMy.setText(charSequence);
        }
        AppMethodBeat.o(198268);
    }

    public final void setHeaderView(View view) {
        AppMethodBeat.i(198269);
        if (this.HMv != null) {
            this.HMv.setVisibility(0);
            this.HMv.removeAllViews();
            this.HMv.setGravity(17);
            this.HMv.addView(view, -1, -2);
        }
        AppMethodBeat.o(198269);
    }

    public final void hv(View view) {
        AppMethodBeat.i(198270);
        if (this.HMv != null) {
            this.HMv.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HMv.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.HMv.setLayoutParams(layoutParams);
            this.HMv.removeAllViews();
            this.HMv.setGravity(17);
            this.HMv.addView(view, -1, -2);
        }
        AppMethodBeat.o(198270);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void fPz() {
        AppMethodBeat.i(198271);
        this.HMr = (LinearLayout) this.lJI.findViewById(R.id.aex);
        this.HMs = (Button) this.lJI.findViewById(R.id.aes);
        this.HMt = (Button) this.lJI.findViewById(R.id.aet);
        this.HMu = (Button) this.lJI.findViewById(R.id.af_);
        switch (this.HMp) {
            case 0:
                this.HMr.setVisibility(8);
                AppMethodBeat.o(198271);
                return;
            case 1:
                this.HMr.setVisibility(0);
                this.HMu.setVisibility(8);
                this.HMs.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.g.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(198251);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (g.this.QOR != null) {
                            g.this.QOR.onClick();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198251);
                    }
                });
                this.HMt.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.g.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(198252);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (g.this.QOS != null) {
                            g.this.QOS.onClick();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198252);
                    }
                });
                AppMethodBeat.o(198271);
                return;
            case 2:
                this.HMr.setVisibility(0);
                this.HMs.setVisibility(8);
                this.HMt.setVisibility(8);
                this.HMu.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.g.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(198253);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (g.this.QOT != null) {
                            g.this.QOT.onClick();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198253);
                    }
                });
                break;
        }
        AppMethodBeat.o(198271);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void initHeaderView() {
        AppMethodBeat.i(198272);
        if (this.HMv != null) {
            this.HMv.setVisibility(0);
            switch (this.HMq) {
                case 0:
                    this.HMv.setVisibility(8);
                    AppMethodBeat.o(198272);
                    return;
                case 1:
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.au2, (ViewGroup) null);
                    inflate.findViewById(R.id.b4g).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.widget.a.g.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(198254);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            g.this.bMo();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(198254);
                        }
                    });
                    this.HMv.removeAllViews();
                    this.HMv.setGravity(17);
                    this.HMv.addView(inflate, -1, -2);
                    AppMethodBeat.o(198272);
                    return;
                case 2:
                    View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.au3, (ViewGroup) null);
                    this.HMy = (TextView) inflate2.findViewById(R.id.iqz);
                    this.HMv.removeAllViews();
                    this.HMv.setGravity(17);
                    this.HMv.addView(inflate2, -1, -2);
                    break;
            }
        }
        AppMethodBeat.o(198272);
    }

    @TargetApi(23)
    private void ghk() {
        AppMethodBeat.i(198273);
        if (Build.VERSION.SDK_INT >= 23 && this.mLH != null) {
            this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.mLH.getWindow().setStatusBarColor(0);
        }
        AppMethodBeat.o(198273);
    }

    public final g apf(int i2) {
        AppMethodBeat.i(198274);
        if (this.HMx != null) {
            this.HMx.setVisibility(0);
            LayoutInflater.from(this.lJI.getContext()).inflate(i2, (ViewGroup) this.HMx, true);
        }
        AppMethodBeat.o(198274);
        return this;
    }

    public final void setCustomView(View view) {
        AppMethodBeat.i(198275);
        if (this.HMx != null) {
            this.HMx.setVisibility(0);
            this.HMx.removeAllViews();
            this.HMx.setGravity(17);
            this.HMx.addView(view, -1, -2);
        }
        AppMethodBeat.o(198275);
    }

    public final void dGm() {
        boolean z;
        AppMethodBeat.i(198276);
        this.mLL = isLandscape();
        this.mLM = getRotation();
        if (this.mLH != null) {
            ((ViewGroup) this.lJI.getParent()).setVisibility(0);
            hbt();
            if (Build.VERSION.SDK_INT >= 21) {
                this.mLH.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.wjM) {
                ghk();
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
        AppMethodBeat.o(198276);
    }

    public final void bMo() {
        AppMethodBeat.i(198277);
        if (this.mLH != null) {
            if (!(this.mContext instanceof Activity) || (this.mContext != null && !((Activity) this.mContext).isFinishing() && !((Activity) this.mContext).isDestroyed())) {
                this.mLH.dismiss();
            }
            if (this.mLK != null) {
                this.mLK.ob = true;
            }
        }
        AppMethodBeat.o(198277);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(198278);
        if (this.mLH == null || !this.mLH.isShowing()) {
            AppMethodBeat.o(198278);
            return false;
        }
        AppMethodBeat.o(198278);
        return true;
    }

    private void hbt() {
        AppMethodBeat.i(198279);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
        if (this.mLL && this.qK != null) {
            Rect rect = new Rect();
            this.qK.getWindowVisibleDisplayFrame(rect);
            layoutParams.width = rect.right;
        }
        this.lJI.setLayoutParams(layoutParams);
        AppMethodBeat.o(198279);
    }

    private boolean isLandscape() {
        AppMethodBeat.i(198280);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(198280);
            return true;
        }
        AppMethodBeat.o(198280);
        return false;
    }
}
