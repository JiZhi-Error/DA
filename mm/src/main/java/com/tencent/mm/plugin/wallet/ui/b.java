package com.tencent.mm.plugin.wallet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.i;

public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private AbstractC1908b HMA;
    private AbstractC1908b HMB;
    private AbstractC1908b HMC;
    private boolean HMD = false;
    private int HMp;
    private int HMq;
    private LinearLayout HMr;
    private Button HMs;
    private Button HMt;
    private Button HMu;
    private LinearLayout HMv;
    private LinearLayout HMw;
    private LinearLayout HMx;
    private TextView HMy;
    private a HMz;
    private ViewTreeObserver afI;
    public View lJI;
    private Context mContext;
    private Dialog mLH;
    private boolean mLL = false;
    private int mLM;
    private boolean mLO = false;
    private boolean mLP = false;
    private boolean ox = true;
    private View qK;
    private boolean wjM;
    private boolean wjN = false;

    public interface a {
        void fPA();
    }

    /* renamed from: com.tencent.mm.plugin.wallet.ui.b$b  reason: collision with other inner class name */
    public interface AbstractC1908b {
        void onClick();
    }

    public b(Context context, int i2, int i3) {
        AppMethodBeat.i(214116);
        this.mContext = context;
        this.HMp = i2;
        this.HMq = i3;
        bh(this.mContext);
        AppMethodBeat.o(214116);
    }

    public b(Context context) {
        AppMethodBeat.i(214117);
        this.mContext = context;
        this.HMp = 0;
        this.HMq = 3;
        this.mLP = true;
        bh(this.mContext);
        AppMethodBeat.o(214117);
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(214118);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(214118);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(214118);
    }

    private int getRotation() {
        AppMethodBeat.i(214119);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            i2 = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(214119);
        return i2;
    }

    private void bh(Context context) {
        AppMethodBeat.i(214120);
        if (this.mContext instanceof Activity) {
            this.qK = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        if (this.mLP) {
            this.mLH = new com.tencent.mm.ui.widget.a.b(context);
        } else {
            this.mLH = new i(context);
        }
        this.lJI = View.inflate(context, R.layout.b8b, null);
        this.HMv = (LinearLayout) this.lJI.findViewById(R.id.ab9);
        this.HMw = (LinearLayout) this.lJI.findViewById(R.id.ab4);
        this.HMx = (LinearLayout) this.lJI.findViewById(R.id.ab3);
        fPz();
        initHeaderView();
        this.mLL = isLandscape();
        if (this.mLP && this.mLL) {
            this.mLO = true;
        }
        this.mLH.setContentView(this.lJI);
        this.mLH.setCancelable(this.ox);
        yf(false);
        this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.wallet.ui.b.AnonymousClass1 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(214111);
                if (b.this.mLO && b.b(b.this)) {
                    ((Activity) b.this.mContext).getWindow().clearFlags(512);
                }
                if (b.this.HMz != null) {
                    b.this.HMz.fPA();
                }
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
                AppMethodBeat.o(214111);
            }
        });
        AppMethodBeat.o(214120);
    }

    public final void aeF(int i2) {
        AppMethodBeat.i(214121);
        if (this.HMu != null) {
            this.HMu.setTextColor(i2);
        }
        AppMethodBeat.o(214121);
    }

    public final void fPx() {
        AppMethodBeat.i(214122);
        if (this.HMu != null) {
            this.HMu.setBackgroundResource(R.drawable.b55);
        }
        AppMethodBeat.o(214122);
    }

    public final void fPy() {
        AppMethodBeat.i(214123);
        Window window = this.mLH.getWindow();
        if (window == null) {
            AppMethodBeat.o(214123);
            return;
        }
        window.setWindowAnimations(R.style.l6);
        AppMethodBeat.o(214123);
    }

    public final void T(CharSequence charSequence) {
        AppMethodBeat.i(214124);
        if (this.HMu != null) {
            this.HMu.setText(charSequence);
        }
        AppMethodBeat.o(214124);
    }

    public final void a(AbstractC1908b bVar) {
        this.HMC = bVar;
    }

    public final void setHeaderView(View view) {
        AppMethodBeat.i(214125);
        if (this.HMv != null) {
            this.HMv.setVisibility(0);
            this.HMv.removeAllViews();
            this.HMv.setGravity(17);
            this.HMv.addView(view, -1, -2);
        }
        AppMethodBeat.o(214125);
    }

    public final b yf(boolean z) {
        AppMethodBeat.i(214126);
        this.HMD = z;
        if (this.lJI == null) {
            AppMethodBeat.o(214126);
        } else if (this.HMD) {
            if (!this.mLP || !this.mLL) {
                this.lJI.setBackgroundResource(R.drawable.b1d);
                AppMethodBeat.o(214126);
            } else {
                this.lJI.setBackgroundColor(this.mContext.getResources().getColor(R.color.a1));
                AppMethodBeat.o(214126);
            }
        } else if (!this.mLP || !this.mLL) {
            this.lJI.setBackgroundResource(R.drawable.b1g);
            AppMethodBeat.o(214126);
        } else {
            this.lJI.setBackgroundColor(this.mContext.getResources().getColor(R.color.f3048f));
            AppMethodBeat.o(214126);
        }
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void fPz() {
        AppMethodBeat.i(214127);
        this.HMr = (LinearLayout) this.lJI.findViewById(R.id.aex);
        this.HMs = (Button) this.lJI.findViewById(R.id.aes);
        this.HMt = (Button) this.lJI.findViewById(R.id.aet);
        this.HMu = (Button) this.lJI.findViewById(R.id.af_);
        switch (this.HMp) {
            case 0:
                this.HMr.setVisibility(8);
                AppMethodBeat.o(214127);
                return;
            case 1:
                this.HMr.setVisibility(0);
                this.HMu.setVisibility(8);
                this.HMs.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.ui.b.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(214112);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (b.this.HMA != null) {
                            b.this.HMA.onClick();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(214112);
                    }
                });
                this.HMt.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.ui.b.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(214113);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (b.this.HMB != null) {
                            b.this.HMB.onClick();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(214113);
                    }
                });
                AppMethodBeat.o(214127);
                return;
            case 2:
                this.HMr.setVisibility(0);
                this.HMs.setVisibility(8);
                this.HMt.setVisibility(8);
                this.HMu.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.ui.b.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(214114);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (b.this.HMC != null) {
                            b.this.HMC.onClick();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(214114);
                    }
                });
                break;
        }
        AppMethodBeat.o(214127);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void initHeaderView() {
        AppMethodBeat.i(214128);
        if (this.HMv != null) {
            this.HMv.setVisibility(0);
            switch (this.HMq) {
                case 0:
                    this.HMv.setVisibility(8);
                    AppMethodBeat.o(214128);
                    return;
                case 1:
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.au2, (ViewGroup) null);
                    inflate.findViewById(R.id.b4g).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.ui.b.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(214115);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            b.this.bMo();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(214115);
                        }
                    });
                    this.HMv.removeAllViews();
                    this.HMv.setGravity(17);
                    this.HMv.addView(inflate, -1, -2);
                    AppMethodBeat.o(214128);
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
        AppMethodBeat.o(214128);
    }

    public final void setCustomView(View view) {
        AppMethodBeat.i(214129);
        if (this.HMx != null) {
            this.HMx.setVisibility(0);
            this.HMx.removeAllViews();
            this.HMx.setGravity(17);
            this.HMx.addView(view, -1, -2);
        }
        AppMethodBeat.o(214129);
    }

    public final void dGm() {
        boolean z;
        AppMethodBeat.i(214130);
        this.mLL = isLandscape();
        this.mLM = getRotation();
        if (this.mLH != null) {
            ((ViewGroup) this.lJI.getParent()).setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
            if (this.mLL && this.qK != null) {
                Rect rect = new Rect();
                this.qK.getWindowVisibleDisplayFrame(rect);
                layoutParams.width = Math.min(rect.right, rect.bottom);
                if (this.mLP) {
                    layoutParams.height = au.az(this.mContext).y;
                    layoutParams.width = au.az(this.mContext).y;
                }
            }
            this.lJI.setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 21) {
                this.mLH.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.wjM && Build.VERSION.SDK_INT >= 23 && this.mLH != null) {
                this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.mLH.getWindow().setStatusBarColor(0);
            }
            Window window = this.mLH.getWindow();
            if (this.mLO) {
                window.setFlags(8, 8);
                window.addFlags(131200);
                window.addFlags(1024);
                b(window);
            } else {
                window.clearFlags(8);
                window.clearFlags(131072);
                window.clearFlags(128);
                window.clearFlags(1024);
                window.getDecorView().setSystemUiVisibility(0);
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
                Window window2 = ((Activity) this.mContext).getWindow();
                if (this.mLO) {
                    window2.addFlags(512);
                }
                this.mLH.show();
                if (this.mLO) {
                    b(window);
                    b(window2);
                    window.clearFlags(8);
                }
            }
        }
        AppMethodBeat.o(214130);
    }

    private static void b(Window window) {
        AppMethodBeat.i(214131);
        if (window == null) {
            AppMethodBeat.o(214131);
            return;
        }
        window.getDecorView().setSystemUiVisibility(7942);
        AppMethodBeat.o(214131);
    }

    public final void bMo() {
        AppMethodBeat.i(214132);
        if (this.mLH != null && (!(this.mContext instanceof Activity) || (this.mContext != null && !((Activity) this.mContext).isFinishing() && !((Activity) this.mContext).isDestroyed()))) {
            this.mLH.dismiss();
        }
        AppMethodBeat.o(214132);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(214133);
        if (this.mLH == null || !this.mLH.isShowing()) {
            AppMethodBeat.o(214133);
            return false;
        }
        AppMethodBeat.o(214133);
        return true;
    }

    public final void a(a aVar) {
        this.HMz = aVar;
    }

    public final void b(DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(214134);
        if (this.mLH != null) {
            this.mLH.setOnCancelListener(onCancelListener);
        }
        AppMethodBeat.o(214134);
    }

    private boolean isLandscape() {
        AppMethodBeat.i(214135);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(214135);
            return true;
        }
        AppMethodBeat.o(214135);
        return false;
    }

    static /* synthetic */ boolean b(b bVar) {
        AppMethodBeat.i(214136);
        if (bVar.mContext == null || !(bVar.mContext instanceof Activity)) {
            AppMethodBeat.o(214136);
            return false;
        } else if (((Activity) bVar.mContext).isFinishing() || ((Activity) bVar.mContext).isDestroyed()) {
            AppMethodBeat.o(214136);
            return false;
        } else {
            AppMethodBeat.o(214136);
            return true;
        }
    }
}
