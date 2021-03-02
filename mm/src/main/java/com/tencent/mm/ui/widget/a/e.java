package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class e implements ViewTreeObserver.OnGlobalLayoutListener {
    private boolean BFo = false;
    private boolean Bln;
    public o.f HLX;
    public o.g HLY;
    private o.g HLZ;
    private boolean HMD = false;
    public o.b HMa;
    public o.c HMb;
    public m HMc;
    private m HMd;
    private boolean HMf = false;
    public boolean HMg = false;
    private LinearLayout HMv;
    private LinearLayout HMw;
    public b PGl;
    private boolean PGm = false;
    public c QNG;
    public o.f QNH;
    private o.f QNI;
    public o.f QNJ;
    public o.g QNK;
    private o.g QNL;
    public o.g QNM;
    private AbstractC2138e QNN;
    public a QNO;
    public o.b QNP;
    public o.b QNQ;
    private o.a QNR;
    private o.c QNS;
    private m QNT;
    private m QNU;
    private m QNV;
    private Boolean QNW = Boolean.FALSE;
    private LinearLayout QNX;
    private LinearLayout QNY;
    private CustomScrollView QNZ;
    private boolean QOA = false;
    private View QOa;
    private View QOb;
    private TextView QOc;
    public f QOd;
    private f QOe;
    private boolean QOf = false;
    private boolean QOg = false;
    private boolean QOh = false;
    private RecyclerView QOi;
    private ImageView QOj;
    private ImageView QOk;
    private int QOl = 4;
    private int QOm = (this.QOl * 3);
    private int QOn = 6;
    private int QOo;
    public boolean QOp = false;
    private int QOq = 0;
    public boolean QOr = false;
    public RecyclerView.r QOs = null;
    private boolean QOt = false;
    private boolean QOu = false;
    private boolean QOv = true;
    private String QOw = null;
    private o.b QOx = null;
    private o.a QOy = null;
    private o.h QOz = null;
    private ViewTreeObserver afI;
    public int jKz = 0;
    private View lJI;
    private Context mContext;
    private Dialog mLH;
    private int mLJ;
    private BottomSheetBehavior mLK;
    private boolean mLL = false;
    private int mLM;
    public boolean mLN;
    public boolean mLO = false;
    private boolean mLP = false;
    public int mLQ = 0;
    public RecyclerView mRecyclerView;
    private View qK;
    private boolean wjM;
    public boolean wjN = false;

    public interface a {
        void onClick();
    }

    public interface b {
        void onDismiss();
    }

    public interface c {
        void onShow();
    }

    /* renamed from: com.tencent.mm.ui.widget.a.e$e  reason: collision with other inner class name */
    public interface AbstractC2138e {
        void onClick();
    }

    public e(Context context, int i2, boolean z) {
        AppMethodBeat.i(159351);
        this.QOo = i2;
        this.mContext = context;
        this.Bln = z;
        this.QOp = false;
        if (this.mContext instanceof Activity) {
            this.qK = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        bh(this.mContext);
        AppMethodBeat.o(159351);
    }

    public e(Context context, boolean z, int i2) {
        AppMethodBeat.i(198239);
        this.QOo = i2;
        this.mContext = context;
        this.mLP = z;
        if (this.mContext instanceof Activity) {
            this.qK = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        bh(this.mContext);
        AppMethodBeat.o(198239);
    }

    public void onGlobalLayout() {
        AppMethodBeat.i(159353);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(159353);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(159353);
    }

    public final int hbo() {
        return this.QOo;
    }

    public final boolean hbp() {
        return this.wjM;
    }

    public final boolean isHideStatusBar() {
        return this.mLN;
    }

    public final boolean hbq() {
        return this.mLO;
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.i(159354);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            i2 = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(159354);
        return i2;
    }

    private void bh(Context context) {
        AppMethodBeat.i(159355);
        this.HMc = new m(context);
        this.HMd = new m(context);
        this.QNT = new m(context);
        this.QNU = new m(context);
        this.QNV = new m(context);
        if (this.mLP) {
            this.mLH = new b(context);
        } else {
            this.mLH = new i(context);
        }
        this.lJI = View.inflate(context, R.layout.b7n, null);
        this.HMv = (LinearLayout) this.lJI.findViewById(R.id.ab9);
        this.HMw = (LinearLayout) this.lJI.findViewById(R.id.ab4);
        this.QNX = (LinearLayout) this.lJI.findViewById(R.id.ab1);
        this.QOb = this.lJI.findViewById(R.id.aih);
        this.QNY = (LinearLayout) this.lJI.findViewById(R.id.ab5);
        this.QOc = (TextView) this.lJI.findViewById(R.id.aii);
        this.QNZ = (CustomScrollView) this.lJI.findViewById(R.id.bf9);
        this.QOa = this.lJI.findViewById(R.id.dku);
        this.QOj = (ImageView) this.lJI.findViewById(R.id.boz);
        this.QOk = (ImageView) this.lJI.findViewById(R.id.fda);
        this.QNX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.a.e.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(159340);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.bMo();
                if (e.this.QNO != null) {
                    e.this.QNO.onClick();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159340);
            }
        });
        this.mRecyclerView = (RecyclerView) this.lJI.findViewById(R.id.ab7);
        this.mRecyclerView.setHasFixedSize(true);
        if (this.mRecyclerView.getItemAnimator() != null) {
            this.mRecyclerView.getItemAnimator().atn = 100;
        }
        this.QOi = (RecyclerView) this.lJI.findViewById(R.id.ab8);
        this.QOi.setHasFixedSize(true);
        this.QOs = new ae(this.mRecyclerView.getContext()) {
            /* class com.tencent.mm.ui.widget.a.e.AnonymousClass4 */

            @Override // android.support.v7.widget.ae
            public final int kz() {
                return -1;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 1.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.RecyclerView.r
            public final PointF bZ(int i2) {
                AppMethodBeat.i(198226);
                if (e.this.mRecyclerView == null || e.this.mRecyclerView.getLayoutManager() == null || !(e.this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                    PointF bZ = super.bZ(i2);
                    AppMethodBeat.o(198226);
                    return bZ;
                }
                PointF bZ2 = ((LinearLayoutManager) e.this.mRecyclerView.getLayoutManager()).bZ(i2);
                AppMethodBeat.o(198226);
                return bZ2;
            }
        };
        this.mLL = isLandscape();
        if (this.QOo == 0) {
            this.QOh = true;
            if (this.mLL) {
                this.QOl = 7;
                this.QOm = this.QOl * 2;
                this.mLJ = at.aH(this.mContext, R.dimen.v) + at.aH(this.mContext, R.dimen.a8u);
            } else {
                this.mLJ = at.aH(this.mContext, R.dimen.u) + at.aH(this.mContext, R.dimen.a8u);
            }
            if (this.Bln) {
                this.mLJ += at.aH(this.mContext, R.dimen.a8u);
            }
            this.QNX.setVisibility(0);
            if (this.lJI != null) {
                if (!this.mLP || !isLandscape()) {
                    this.lJI.setBackgroundResource(R.drawable.b1e);
                } else {
                    this.lJI.setBackgroundColor(this.mContext.getResources().getColor(R.color.f3044b));
                }
            }
            this.QNZ.setOnScrollChangeListener(new CustomScrollView.a() {
                /* class com.tencent.mm.ui.widget.a.e.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.CustomScrollView.a
                public final void a(ScrollView scrollView, int i2, int i3) {
                    AppMethodBeat.i(198227);
                    if (scrollView.getChildAt(0).getMeasuredHeight() - (scrollView.getHeight() + scrollView.getScrollY()) < 50) {
                        e.this.QOa.setVisibility(8);
                        AppMethodBeat.o(198227);
                        return;
                    }
                    e.this.QOa.setVisibility(0);
                    AppMethodBeat.o(198227);
                }
            });
        } else if (this.QOo == 2) {
            this.HMf = true;
            int aH = at.aH(this.mContext, R.dimen.tz);
            if (this.mLL) {
                this.QOn = 2;
                this.mLJ = ((int) (((double) aH) * 2.5d)) + at.aH(this.mContext, R.dimen.tv);
            } else {
                this.QOn = 3;
                this.mLJ = ((int) (((double) aH) * 3.5d)) + at.aH(this.mContext, R.dimen.tv);
            }
            if (this.Bln) {
                this.mLJ += at.fromDPToPix(this.mContext, 88);
            }
        } else {
            this.QOg = true;
            int aH2 = at.aH(this.mContext, R.dimen.u2);
            if (this.mLL) {
                this.QOn = 4;
                this.mLJ = ((int) (((double) aH2) * 4.5d)) + at.aH(this.mContext, R.dimen.tv);
            } else {
                this.QOn = 6;
                this.mLJ = ((int) (((double) aH2) * 6.5d)) + at.aH(this.mContext, R.dimen.tv);
            }
            if (this.Bln) {
                this.mLJ += at.aH(this.mContext, R.dimen.a8u);
            }
            if (this.QNX != null) {
                this.QNX.setVisibility(0);
            }
        }
        if (this.Bln && this.QOj != null && this.QOp) {
            this.QOj.setVisibility(0);
        }
        if (this.QOo == 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
            linearLayoutManager.setOrientation(0);
            this.mRecyclerView.setLayoutManager(linearLayoutManager);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager();
            linearLayoutManager2.setOrientation(0);
            this.QOi.setLayoutManager(linearLayoutManager2);
        } else {
            this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
        }
        this.mRecyclerView.setFocusable(false);
        this.mRecyclerView.setItemViewCacheSize(20);
        this.QOd = new f(false);
        this.QOd.HMj = this.HMc;
        this.QOd.ars = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.widget.a.e.AnonymousClass6 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(198228);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 < e.this.HMc.size()) {
                    n nVar = (n) e.this.HMc.ORD.get(i2);
                    if (nVar == null || nVar.neT) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(198228);
                        return;
                    } else if (e.this.HLY != null) {
                        e.this.HLY.onMMMenuItemSelected(nVar, i2);
                    } else {
                        nVar.performClick();
                    }
                } else if (e.this.HMd.size() > 0 && i2 < e.this.HMc.size() + e.this.HMd.size()) {
                    n nVar2 = (n) e.this.HMd.getItem(i2 - e.this.HMc.size());
                    if (nVar2 == null || nVar2.neT) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(198228);
                        return;
                    } else if (e.this.HLZ != null) {
                        e.this.HLZ.onMMMenuItemSelected(nVar2, i2);
                    } else {
                        nVar2.performClick();
                    }
                } else if (!e.this.QOv) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(198228);
                    return;
                } else {
                    e.j(e.this);
                }
                if (!e.this.BFo) {
                    e.this.bMo();
                }
                e.this.PGm = true;
                e.this.jKz = i2;
                e.this.QOd.atj.notifyChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(198228);
            }
        };
        this.mRecyclerView.setAdapter(this.QOd);
        this.mRecyclerView.setOverScrollMode(1);
        this.QOe = new f(true);
        this.QOe.HMj = this.QNT;
        this.QOe.ars = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.widget.a.e.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(198229);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 >= e.this.QNT.size()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(198229);
                    return;
                }
                n nVar = (n) e.this.QNT.ORD.get(i2);
                if (nVar == null || !nVar.neT) {
                    if (i2 < e.this.QNT.size() && e.this.QNK != null) {
                        e.this.QNK.onMMMenuItemSelected(e.this.QNT.getItem(i2), i2);
                    }
                    if (!e.this.BFo) {
                        e.this.bMo();
                    }
                    e.this.PGm = true;
                    e.this.QOe.atj.notifyChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(198229);
                    return;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(198229);
            }
        };
        this.QOi.setAdapter(this.QOe);
        this.QOi.setOverScrollMode(1);
        if (this.mLH != null) {
            this.mLH.setContentView(this.lJI);
        }
        if (this.mLH != null) {
            this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.ui.widget.a.e.AnonymousClass8 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(159345);
                    if (e.this.afI != null) {
                        if (!e.this.afI.isAlive()) {
                            e.this.afI = e.this.qK.getViewTreeObserver();
                        }
                        e.this.afI.removeGlobalOnLayoutListener(e.this);
                        e.this.afI = null;
                    }
                    if (!e.this.wjN) {
                        e.this.mLH = null;
                    }
                    AppMethodBeat.o(159345);
                }
            });
        }
        AppMethodBeat.o(159355);
    }

    public final void setTitleView(View view) {
        AppMethodBeat.i(258268);
        V(view, false);
        AppMethodBeat.o(258268);
    }

    public final void V(View view, boolean z) {
        AppMethodBeat.i(159356);
        if (view == null) {
            AppMethodBeat.o(159356);
            return;
        }
        this.Bln = true;
        if (this.QOj != null) {
            this.QOj.setVisibility(z ? 4 : 0);
        }
        if (this.HMv != null) {
            this.HMv.setVisibility(0);
            this.HMv.removeAllViews();
            this.HMv.setGravity(17);
            this.HMv.addView(view, -1, -2);
        }
        AppMethodBeat.o(159356);
    }

    public final void o(CharSequence charSequence, int i2) {
        AppMethodBeat.i(159357);
        if (this.HMv != null && this.Bln) {
            this.HMv.setVisibility(0);
            this.HMv.removeAllViews();
            this.HMv.setGravity(i2);
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.b7r, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.iqz);
            textView.setText(charSequence);
            textView.setGravity(i2 | 80);
            if (this.HMD) {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
            }
            this.HMv.addView(inflate, -1, -2);
        }
        AppMethodBeat.o(159357);
    }

    public final void j(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(198241);
        if (this.HMv != null && this.Bln) {
            this.HMv.setVisibility(0);
            this.HMv.removeAllViews();
            this.HMv.setGravity(i2);
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.b7r, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.iqz);
            textView.setText(charSequence);
            textView.setTextSize(0, (float) i3);
            textView.setGravity(i2 | 80);
            if (this.HMD) {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
            }
            this.HMv.addView(inflate, -1, -2);
        }
        AppMethodBeat.o(198241);
    }

    public final void setFooterView(View view) {
        AppMethodBeat.i(159358);
        if (this.HMw != null) {
            if (view == null) {
                this.HMw.setVisibility(8);
                AppMethodBeat.o(159358);
                return;
            }
            this.HMw.setVisibility(0);
            this.HMw.removeAllViews();
            this.HMw.setGravity(17);
            this.HMw.addView(view, -1, -2);
        }
        AppMethodBeat.o(159358);
    }

    public final void Dm(boolean z) {
        AppMethodBeat.i(198242);
        if (this.QNX == null) {
            AppMethodBeat.o(198242);
        } else if (z) {
            this.QNX.setVisibility(8);
            AppMethodBeat.o(198242);
        } else {
            this.QNX.setVisibility(0);
            AppMethodBeat.o(198242);
        }
    }

    public final void setBackgroundColor(int i2) {
        AppMethodBeat.i(159360);
        if (this.lJI != null) {
            this.lJI.setBackgroundColor(i2);
        }
        this.QNW = Boolean.valueOf(ar.aln(i2));
        if (this.QNW.booleanValue() && this.QOj != null) {
            this.QOj.setImageDrawable(this.mContext.getResources().getDrawable(R.color.ks));
        }
        AppMethodBeat.o(159360);
    }

    public final e hbr() {
        AppMethodBeat.i(198243);
        this.HMD = true;
        if (this.lJI != null) {
            if (this.HMD) {
                if (this.QOo == 0) {
                    this.lJI.setBackgroundResource(R.drawable.b1f);
                } else {
                    this.lJI.setBackgroundResource(R.drawable.b1d);
                }
                this.QOb.setBackgroundColor(this.mContext.getResources().getColor(R.color.x));
                this.QOc.setTextColor(this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
                this.QOc.setBackgroundResource(R.drawable.r_);
            } else {
                this.lJI.setBackgroundResource(R.drawable.b1g);
            }
        }
        AppMethodBeat.o(198243);
        return this;
    }

    @TargetApi(23)
    private void ghk() {
        AppMethodBeat.i(159361);
        if (Build.VERSION.SDK_INT >= 23 && this.mLH != null) {
            this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.mLH.getWindow().setStatusBarColor(0);
        }
        AppMethodBeat.o(159361);
    }

    public final void a(AbstractC2138e eVar) {
        this.QOf = false;
        this.QNN = eVar;
    }

    public final void a(AbstractC2138e eVar, String str, o.b bVar, o.a aVar, o.h hVar) {
        AppMethodBeat.i(198244);
        this.QOf = true;
        this.QNN = eVar;
        this.QOu = true;
        this.QOw = str;
        this.QOx = bVar;
        this.QOy = aVar;
        this.QOz = hVar;
        if (!this.QOA) {
            if (this.mRecyclerView == null) {
                AppMethodBeat.o(198244);
                return;
            } else {
                this.mRecyclerView.a(new d(this, (byte) 0));
                this.QOA = true;
            }
        }
        AppMethodBeat.o(198244);
    }

    public final void Dn(boolean z) {
        this.QOv = z;
    }

    public final void a(m mVar, o.g gVar, o.c cVar) {
        boolean z;
        AppMethodBeat.i(198245);
        this.QOt = true;
        this.HMd = mVar;
        this.HLZ = gVar;
        this.QNS = cVar;
        if (!this.QOA) {
            if (this.mRecyclerView == null || mVar == null) {
                AppMethodBeat.o(198245);
                return;
            }
            List<MenuItem> list = mVar.ORD;
            if (list == null || list.isEmpty()) {
                AppMethodBeat.o(198245);
                return;
            }
            Iterator<MenuItem> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                MenuItem next = it.next();
                if ((next instanceof n) && ((n) next).ORL != null) {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.mRecyclerView.a(new d(this, (byte) 0));
                this.QOA = true;
            }
        }
        AppMethodBeat.o(198245);
    }

    public final void hbs() {
        this.BFo = true;
    }

    public final void Do(boolean z) {
        this.mLO = z;
    }

    public final void dGm() {
        View view;
        View view2;
        boolean z = false;
        AppMethodBeat.i(159362);
        this.PGm = false;
        this.mLL = isLandscape();
        this.mLM = getRotation();
        if (this.HLX != null) {
            this.HLX.onCreateMMMenu(this.HMc);
        }
        if (this.QNH != null) {
            this.QNH.onCreateMMMenu(this.QNT);
        }
        if (this.QNI != null) {
            this.QNI.onCreateMMMenu(this.QNU);
        }
        if (this.QNJ != null) {
            this.QNJ.onCreateMMMenu(this.QNV);
        }
        if (this.mLH != null) {
            hbt();
            if (this.QOh) {
                if (this.QNT.size() > 0) {
                    this.QOk.setVisibility(0);
                    this.QOi.setVisibility(0);
                    if (this.QOb != null) {
                        this.QOb.setVisibility(8);
                    }
                }
                if (this.QNU.size() > 0) {
                    if (this.HMv != null) {
                        this.HMv.setVisibility(0);
                        this.HMv.removeAllViews();
                        this.HMv.setGravity(17);
                    }
                    View inflate = View.inflate(this.mContext, R.layout.lk, null);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fd_);
                    for (final int i2 = 0; i2 < this.QNU.size(); i2++) {
                        n nVar = (n) this.QNU.ORD.get(i2);
                        if (nVar.Bno) {
                            view2 = View.inflate(this.mContext, R.layout.li, null);
                        } else {
                            View inflate2 = View.inflate(this.mContext, R.layout.lj, null);
                            WeImageView weImageView = (WeImageView) inflate2.findViewById(R.id.fdz);
                            TextView textView = (TextView) inflate2.findViewById(R.id.fdq);
                            TextView textView2 = (TextView) inflate2.findViewById(R.id.fd2);
                            if (this.QNP != null) {
                                this.QNP.a(weImageView, nVar);
                            } else {
                                weImageView.setImageDrawable(nVar.getIcon());
                            }
                            weImageView.setIconColor(nVar.uzt);
                            textView.setText(nVar.getTitle());
                            if (nVar.xdb != null) {
                                textView2.setVisibility(0);
                                textView2.setText(nVar.xdb);
                            }
                            inflate2.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.ui.widget.a.e.AnonymousClass9 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(198230);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    if (e.this.QNL != null && i2 < e.this.QNU.size()) {
                                        e.this.QNL.onMMMenuItemSelected(e.this.QNU.getItem(i2), i2);
                                    }
                                    if (!e.this.BFo) {
                                        e.this.bMo();
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(198230);
                                }
                            });
                            view2 = inflate2;
                        }
                        linearLayout.addView(view2);
                    }
                    this.HMv.addView(inflate);
                }
                if (this.QNV.size() > 0) {
                    if (this.QNY != null) {
                        this.QNY.setVisibility(0);
                        this.QNY.removeAllViews();
                        this.QNY.setGravity(17);
                    }
                    View inflate3 = View.inflate(this.mContext, R.layout.lh, null);
                    LinearLayout linearLayout2 = (LinearLayout) inflate3.findViewById(R.id.fd_);
                    for (final int i3 = 0; i3 < this.QNV.size(); i3++) {
                        n nVar2 = (n) this.QNV.ORD.get(i3);
                        if (nVar2.Bno) {
                            view = View.inflate(this.mContext, R.layout.lf, null);
                        } else {
                            View inflate4 = View.inflate(this.mContext, R.layout.lg, null);
                            WeImageView weImageView2 = (WeImageView) inflate4.findViewById(R.id.fdz);
                            TextView textView3 = (TextView) inflate4.findViewById(R.id.fdq);
                            TextView textView4 = (TextView) inflate4.findViewById(R.id.fd2);
                            if (this.QNQ != null) {
                                this.QNQ.a(weImageView2, nVar2);
                            } else {
                                weImageView2.setImageDrawable(nVar2.getIcon());
                            }
                            weImageView2.setIconColor(nVar2.uzt);
                            textView3.setText(nVar2.getTitle());
                            if (nVar2.xdb != null) {
                                textView4.setVisibility(0);
                                textView4.setText(nVar2.xdb);
                            }
                            inflate4.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.ui.widget.a.e.AnonymousClass10 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(198231);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    if (e.this.QNM != null && i3 < e.this.QNV.size()) {
                                        e.this.QNM.onMMMenuItemSelected(e.this.QNV.getItem(i3), i3);
                                    }
                                    if (!e.this.BFo) {
                                        e.this.bMo();
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(198231);
                                }
                            });
                            view = inflate4;
                        }
                        linearLayout2.addView(view);
                    }
                    if (this.QNY != null) {
                        this.QNY.addView(inflate3);
                    }
                }
                int aH = at.aH(this.mContext, R.dimen.a8u);
                int aH2 = at.aH(this.mContext, R.dimen.cb);
                if (this.Bln && this.HMv.getVisibility() == 0) {
                    aH = at.fromDPToPix(this.mContext, 0);
                }
                this.mRecyclerView.setPadding(0, aH, this.mRecyclerView.getPaddingRight(), this.mRecyclerView.getPaddingBottom());
                if (this.QNY != null && this.QNY.getVisibility() == 0) {
                    this.QNY.setPadding(0, this.QNY.getPaddingTop(), this.QNY.getPaddingRight(), aH2);
                    this.QOi.setPadding(0, this.QOi.getPaddingTop(), this.QOi.getPaddingRight(), aH2);
                } else if (isLandscape()) {
                    this.QOi.setPadding(0, this.QOi.getPaddingTop(), this.QOi.getPaddingRight(), aH2);
                } else {
                    this.QOi.setPadding(0, this.QOi.getPaddingTop(), this.QOi.getPaddingRight(), this.QOi.getPaddingBottom());
                }
                this.QNZ.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                if (this.QNZ.getChildAt(0) != null) {
                    Rect rect = new Rect();
                    this.qK.getWindowVisibleDisplayFrame(rect);
                    if (this.QNZ.getChildAt(0).getMeasuredHeight() + at.aH(this.mContext, R.dimen.cp) > rect.bottom) {
                        this.QOa.setVisibility(0);
                    }
                }
            } else {
                this.mRecyclerView.setPadding(0, 0, 0, 0);
            }
            if (!(this.HMd == null || this.QOd == null)) {
                this.QOd.atj.notifyChanged();
            }
            if (this.QOe != null) {
                this.QOe.atj.notifyChanged();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.mLH.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.wjM) {
                ghk();
            }
            if (this.mLN) {
                this.mLH.getWindow().addFlags(1024);
            }
            if (this.mLO) {
                this.mLH.getWindow().setFlags(8, 8);
                this.mLH.getWindow().addFlags(131200);
                this.mLH.getWindow().getDecorView().setSystemUiVisibility(4102);
            } else {
                this.mLH.getWindow().clearFlags(8);
                this.mLH.getWindow().clearFlags(131072);
                this.mLH.getWindow().clearFlags(128);
                this.mLH.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.mLK != null) {
                this.mLK.ob = false;
            }
            if (this.PGl != null) {
                this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.ui.widget.a.e.AnonymousClass11 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(198232);
                        if (!e.this.PGm) {
                            e.this.PGl.onDismiss();
                        }
                        AppMethodBeat.o(198232);
                    }
                });
            }
            this.mLH.setOnShowListener(new DialogInterface.OnShowListener() {
                /* class com.tencent.mm.ui.widget.a.e.AnonymousClass2 */

                public final void onShow(DialogInterface dialogInterface) {
                    AppMethodBeat.i(198224);
                    if (e.this.QNG != null && !e.this.PGm) {
                        e.this.QNG.onShow();
                    }
                    AppMethodBeat.o(198224);
                }
            });
            if (this.qK != null) {
                if (this.afI == null) {
                    z = true;
                }
                this.afI = this.qK.getViewTreeObserver();
                if (z) {
                    this.afI.addOnGlobalLayoutListener(this);
                }
            }
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
                this.mLH.show();
            }
        }
        AppMethodBeat.o(159362);
    }

    public final void fPw() {
        AppMethodBeat.i(159363);
        if (this.mLH != null) {
            if (!(this.HMd == null || this.QOd == null)) {
                this.QOd.atj.notifyChanged();
            }
            if (this.QOe != null) {
                this.QOe.atj.notifyChanged();
            }
            this.mLH.setOnShowListener(new DialogInterface.OnShowListener() {
                /* class com.tencent.mm.ui.widget.a.e.AnonymousClass3 */

                public final void onShow(DialogInterface dialogInterface) {
                    AppMethodBeat.i(198225);
                    if (e.this.QNG != null && !e.this.PGm) {
                        e.this.QNG.onShow();
                    }
                    AppMethodBeat.o(198225);
                }
            });
            this.mLH.show();
        }
        AppMethodBeat.o(159363);
    }

    public final void bMo() {
        AppMethodBeat.i(159364);
        if (this.mLH != null) {
            if (this.mLK != null) {
                this.mLK.ob = true;
            }
            if (!(this.mContext instanceof Activity) || (this.mContext != null && !((Activity) this.mContext).isFinishing() && !((Activity) this.mContext).isDestroyed())) {
                this.mLH.dismiss();
            }
        }
        AppMethodBeat.o(159364);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(159365);
        if (this.mLH == null || !this.mLH.isShowing()) {
            AppMethodBeat.o(159365);
            return false;
        }
        AppMethodBeat.o(159365);
        return true;
    }

    private void hbt() {
        AppMethodBeat.i(159366);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
        this.HMc.size();
        if (!this.QOf && this.HMd.size() > 0) {
            this.HMd.size();
        }
        if (this.mLL && this.qK != null) {
            Rect rect = new Rect();
            this.qK.getWindowVisibleDisplayFrame(rect);
            if (this.mLP) {
                layoutParams.width = (int) ((((float) rect.right) * 1.0f) / 2.0f);
                if (this.mLQ != 0) {
                    layoutParams.width = this.mLQ;
                }
                if (au.jX(this.mContext)) {
                    layoutParams.height = rect.bottom - au.ay(this.mContext);
                } else {
                    layoutParams.height = rect.bottom;
                }
            } else {
                layoutParams.width = Math.min(rect.right, rect.bottom);
                if (this.mLQ != 0) {
                    layoutParams.width = this.mLQ;
                }
            }
        }
        this.lJI.setLayoutParams(layoutParams);
        AppMethodBeat.o(159366);
    }

    public final void a(o.a aVar) {
        this.QNR = aVar;
    }

    public final void a(o.f fVar) {
        this.HLX = fVar;
    }

    public final void a(o.g gVar) {
        this.HLY = gVar;
    }

    public final void b(o.f fVar) {
        this.QNH = fVar;
    }

    public final void b(o.g gVar) {
        this.QNK = gVar;
    }

    public final void b(b bVar) {
        this.PGl = bVar;
    }

    public final void a(a aVar) {
        this.QNO = aVar;
    }

    private boolean isLandscape() {
        AppMethodBeat.i(159367);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(159367);
            return true;
        }
        AppMethodBeat.o(159367);
        return false;
    }

    public class f extends RecyclerView.a<a> {
        m HMj;
        private final boolean QOC;
        AdapterView.OnItemClickListener ars;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            float f2;
            AppMethodBeat.i(159349);
            final a aVar2 = aVar;
            if (i2 < this.HMj.size()) {
                if (e.this.jKz >= this.HMj.size()) {
                    e.this.jKz = 0;
                }
                n nVar = (n) this.HMj.ORD.get(i2);
                aVar2.hbb.setText(nVar.getTitle());
                aVar2.hbb.setEllipsize(nVar.ORF);
                if (nVar.getIcon() != null) {
                    aVar2.uGm.setVisibility(0);
                    aVar2.uGm.setImageDrawable(nVar.getIcon());
                    if (e.this.HMf) {
                        aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.ac_));
                    } else if (nVar.uzt != 0) {
                        aVar2.uGm.setIconColor(nVar.uzt);
                    } else {
                        aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.ac_));
                    }
                } else if (e.this.HMa != null) {
                    aVar2.uGm.setVisibility(0);
                    aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.ac_));
                    e.this.HMa.a(aVar2.uGm, nVar);
                } else if (e.this.HMg) {
                    aVar2.uGm.setVisibility(4);
                } else {
                    aVar2.uGm.setVisibility(8);
                }
                if (e.this.HMb != null) {
                    e.this.HMb.a(aVar2.hbb, nVar);
                }
                if (nVar.neT) {
                    if (e.this.QNW.booleanValue() || e.this.HMD) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.ag3));
                    } else {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g1));
                    }
                    if (e.this.QOh) {
                        if (e.this.QNW.booleanValue() || e.this.HMD) {
                            aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.BW_70_dark));
                            if (aVar2.QOG != null) {
                                aVar2.QOG.setBackgroundResource(R.drawable.apx);
                            }
                        } else {
                            aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.BW_70));
                        }
                        if (aVar2.QOG != null) {
                            aVar2.QOG.setAlpha(128);
                        }
                    } else {
                        aVar2.uGm.setAlpha(77);
                        aVar2.HMm.setBackgroundResource(R.color.ac_);
                    }
                } else {
                    aVar2.uGm.setAlpha(255);
                    if (aVar2.QOG != null) {
                        aVar2.QOG.setAlpha(255);
                    }
                    if (e.this.QNW.booleanValue() || e.this.HMD) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
                        if (e.this.QOg && aVar2.jCB != null) {
                            aVar2.jCB.setTextColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_5));
                        }
                        if (e.this.QOh) {
                            if (nVar.uzt == e.this.mContext.getResources().getColor(R.color.FG_0)) {
                                aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
                            }
                            if (aVar2.QOG != null) {
                                aVar2.QOG.setBackgroundResource(R.drawable.apx);
                            }
                        }
                    } else if (e.this.QOh) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g2));
                    } else {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g0));
                    }
                }
                aVar2.uGm.setEnableColorFilter(nVar.ORG);
                if (aVar2.jCB != null) {
                    if (nVar.xdb == null || nVar.xdb.length() <= 0) {
                        aVar2.jCB.setVisibility(8);
                    } else {
                        aVar2.jCB.setVisibility(0);
                        aVar2.jCB.setText(nVar.xdb);
                        if (e.this.HMf) {
                            aVar2.jCB.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                    }
                }
                if (e.this.HMf) {
                    if (nVar.neT) {
                        aVar2.QOH.setVisibility(8);
                        aVar2.jCB.setTextColor(e.this.mContext.getResources().getColor(R.color.g1));
                    } else {
                        aVar2.jCB.setTextColor(e.this.mContext.getResources().getColor(R.color.g2));
                        aVar2.QOH.setVisibility(0);
                        if (e.this.jKz == i2) {
                            aVar2.QOH.setChecked(true);
                        } else {
                            aVar2.QOH.setChecked(false);
                        }
                    }
                    aVar2.HMl.setVisibility(0);
                }
                if (aVar2.QOI != null) {
                    if (nVar.ORE) {
                        aVar2.QOI.setVisibility(0);
                    } else {
                        aVar2.QOI.setVisibility(8);
                    }
                }
                if (aVar2.hbJ != null) {
                    if (nVar.eaY) {
                        aVar2.hbJ.setVisibility(0);
                    } else {
                        aVar2.hbJ.setVisibility(8);
                    }
                }
                if (e.this.QOg && e.this.HMD) {
                    if (nVar.uzt != 0) {
                        aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    }
                    if (aVar2.HMl != null) {
                        aVar2.HMl.setBackgroundColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_0_5));
                    }
                }
                if (aVar2.QOF != null) {
                    aVar2.QOF.setVisibility(8);
                }
            } else if (e.this.HMd.size() > 0 && i2 < this.HMj.size() + e.this.HMd.size()) {
                n nVar2 = (n) e.this.HMd.ORD.get(i2 - this.HMj.size());
                aVar2.hbb.setText(nVar2.getTitle());
                if (e.this.jKz >= this.HMj.size() + e.this.HMd.size()) {
                    e.this.jKz = 0;
                }
                if (nVar2.getIcon() != null) {
                    aVar2.uGm.setVisibility(0);
                    aVar2.uGm.setImageDrawable(nVar2.getIcon());
                } else {
                    aVar2.uGm.setVisibility(8);
                }
                if (e.this.QOt) {
                    LinearLayout linearLayout = aVar2.HMm;
                    if (nVar2.neT) {
                        f2 = 0.3f;
                    } else {
                        f2 = 1.0f;
                    }
                    linearLayout.setAlpha(f2);
                    if (nVar2.uzt != 0) {
                        aVar2.uGm.setIconColor(nVar2.uzt);
                    } else {
                        aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.ac_));
                    }
                    aVar2.uGm.setTag(nVar2);
                    nVar2.ORK = new o.d() {
                        /* class com.tencent.mm.ui.widget.a.e.f.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.d
                        public final void a(n nVar) {
                            AppMethodBeat.i(198237);
                            Object tag = aVar2.uGm.getTag();
                            if ((tag instanceof n) && nVar.equals((n) tag)) {
                                aVar2.uGm.setVisibility(0);
                                aVar2.uGm.setImageDrawable(nVar.getIcon());
                            }
                            AppMethodBeat.o(198237);
                        }
                    };
                    aVar2.uGm.setAlpha(255);
                    if (aVar2.QOG != null) {
                        aVar2.QOG.setAlpha(255);
                    }
                    if (e.this.QNS != null) {
                        e.this.QNS.a(aVar2.hbb, nVar2);
                    }
                    if (e.this.QNW.booleanValue() || e.this.HMD) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_5));
                    } else if (e.this.QOh) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g2));
                    } else {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g0));
                    }
                } else if (nVar2.neT) {
                    if (e.this.QNW.booleanValue() || e.this.HMD) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.ag3));
                    } else {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g1));
                    }
                    aVar2.HMm.setBackgroundResource(R.color.ac_);
                } else if (e.this.QNW.booleanValue() || e.this.HMD) {
                    aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    aVar2.HMm.setBackgroundResource(R.drawable.asg);
                } else {
                    aVar2.hbb.setTextColor(aVar2.hbb.getTextColors());
                    aVar2.HMm.setBackgroundResource(R.drawable.asf);
                }
                if (aVar2.jCB != null) {
                    if (nVar2.xdb != null) {
                        aVar2.jCB.setVisibility(0);
                        aVar2.jCB.setText(nVar2.xdb);
                    } else {
                        aVar2.jCB.setVisibility(8);
                    }
                }
                if (e.this.HMf) {
                    if (nVar2.neT) {
                        aVar2.QOH.setVisibility(8);
                        aVar2.jCB.setTextColor(e.this.mContext.getResources().getColor(R.color.g1));
                    } else {
                        aVar2.jCB.setTextColor(e.this.mContext.getResources().getColor(R.color.g2));
                        aVar2.QOH.setVisibility(0);
                        if (e.this.jKz == i2) {
                            aVar2.QOH.setChecked(true);
                        } else {
                            aVar2.QOH.setChecked(false);
                        }
                    }
                    aVar2.HMl.setVisibility(0);
                }
                if (aVar2.QOF != null) {
                    if (e.this.QNR != null) {
                        aVar2.QOF.setVisibility(0);
                        e.this.QNR.f(aVar2.QOF);
                    } else {
                        aVar2.QOF.setVisibility(8);
                    }
                }
            } else if (e.this.QOf) {
                if (TextUtils.isEmpty(e.this.QOw)) {
                    aVar2.hbb.setText(R.string.all);
                } else {
                    aVar2.hbb.setText(e.this.QOw);
                }
                if (e.this.QOx != null) {
                    e.this.QOx.a(aVar2.uGm, null);
                } else {
                    aVar2.uGm.setImageResource(R.raw.bottomsheet_icon_more);
                }
                if (aVar2.QOF != null) {
                    if (e.this.QOy != null) {
                        aVar2.QOF.setVisibility(0);
                        e.this.QOy.f(aVar2.QOF);
                    } else {
                        aVar2.QOF.setVisibility(8);
                    }
                }
                if (e.this.QOu) {
                    aVar2.HMm.setAlpha(e.this.QOv ? 1.0f : 0.3f);
                    aVar2.uGm.setIconColor(e.this.mContext.getResources().getColor(R.color.ac_));
                    aVar2.uGm.setAlpha(255);
                    if (aVar2.QOG != null) {
                        aVar2.QOG.setAlpha(255);
                    }
                    if (e.this.QNW.booleanValue() || e.this.HMD) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_5));
                    } else if (e.this.QOh) {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g2));
                    } else {
                        aVar2.hbb.setTextColor(e.this.mContext.getResources().getColor(R.color.g0));
                    }
                }
            }
            if (e.this.QOg && !e.this.QOr) {
                aVar2.uGm.setVisibility(8);
            }
            AppMethodBeat.o(159349);
        }

        public f(boolean z) {
            this.QOC = z;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(159348);
            int size = this.HMj.size();
            if (!this.QOC || !e.this.QOt) {
                size += e.this.HMd.size();
            }
            if (e.this.QOf && (!this.QOC || !e.this.QOt)) {
                size++;
            }
            AppMethodBeat.o(159348);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(198238);
            if (i2 >= 0 && i2 < this.HMj.size()) {
                MenuItem item = this.HMj.getItem(i2);
                if ((item instanceof n) && !((n) item).ORG) {
                    AppMethodBeat.o(198238);
                    return 1;
                }
            } else if (e.this.HMd.size() > 0 && i2 < this.HMj.size() + e.this.HMd.size()) {
                AppMethodBeat.o(198238);
                return 2;
            } else if (e.this.QOf && i2 == this.HMj.size() + e.this.HMd.size()) {
                AppMethodBeat.o(198238);
                return 3;
            }
            AppMethodBeat.o(198238);
            return 0;
        }

        public class a extends RecyclerView.v implements View.OnClickListener {
            ImageView HMl;
            LinearLayout HMm;
            ImageView QOF = null;
            ImageView QOG;
            RadioButton QOH;
            View QOI;
            View hbJ;
            TextView hbb;
            TextView jCB;
            WeImageView uGm;

            public a(View view) {
                super(view);
                AppMethodBeat.i(159346);
                view.setOnClickListener(this);
                this.hbb = (TextView) view.findViewById(R.id.ipm);
                this.uGm = (WeImageView) view.findViewById(R.id.dt5);
                this.HMm = (LinearLayout) view.findViewById(R.id.h8v);
                this.QOI = view.findViewById(R.id.fxi);
                this.hbJ = view.findViewById(R.id.gy4);
                if (e.this.QOh) {
                    this.QOG = (ImageView) view.findViewById(R.id.dtj);
                    this.QOF = (ImageView) view.findViewById(R.id.dti);
                }
                if (e.this.HMf) {
                    this.QOH = (RadioButton) view.findViewById(R.id.gqn);
                }
                if (e.this.HMf || e.this.QOg) {
                    this.jCB = (TextView) view.findViewById(R.id.bmr);
                    this.HMl = (ImageView) view.findViewById(R.id.brt);
                }
                AppMethodBeat.o(159346);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(159347);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (f.this.ars != null) {
                    f.this.ars.onItemClick(null, view, getPosition(), (long) getPosition());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159347);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            View inflate;
            AppMethodBeat.i(159350);
            if (e.this.QOo == 0) {
                inflate = LayoutInflater.from(e.this.mContext).inflate(R.layout.b7o, viewGroup, false);
            } else if (e.this.QOo == 2) {
                inflate = LayoutInflater.from(e.this.mContext).inflate(R.layout.b7p, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(e.this.mContext).inflate(R.layout.b7q, viewGroup, false);
            }
            a aVar = new a(inflate);
            AppMethodBeat.o(159350);
            return aVar;
        }
    }

    public final e Dp(boolean z) {
        this.QOr = z;
        return this;
    }

    class d extends RecyclerView.l {
        private d() {
        }

        /* synthetic */ d(e eVar, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(198233);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            v(recyclerView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(198233);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(198234);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            v(recyclerView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(198234);
        }

        private void v(RecyclerView recyclerView) {
            AppMethodBeat.i(198235);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                AppMethodBeat.o(198235);
                return;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int ku = linearLayoutManager.ku();
            for (int ks = linearLayoutManager.ks(); ks <= ku; ks++) {
                n aoZ = aoZ(ks);
                if (aoZ != null) {
                    o.h hVar = aoZ.ORL;
                    if (hVar != null) {
                        hVar.cy(linearLayoutManager.findViewByPosition(ks));
                    }
                } else if (ks == e.this.HMc.size() + e.this.HMd.size() && e.this.QOz != null) {
                    e.this.QOz.cy(linearLayoutManager.findViewByPosition(ks));
                }
            }
            AppMethodBeat.o(198235);
        }

        private n aoZ(int i2) {
            AppMethodBeat.i(198236);
            if (i2 < 0) {
                AppMethodBeat.o(198236);
                return null;
            } else if (i2 < e.this.HMc.size()) {
                n nVar = (n) e.this.HMc.ORD.get(i2);
                AppMethodBeat.o(198236);
                return nVar;
            } else if (e.this.HMd.size() <= 0 || i2 >= e.this.HMc.size() + e.this.HMd.size()) {
                AppMethodBeat.o(198236);
                return null;
            } else {
                n nVar2 = (n) e.this.HMd.getItem(i2 - e.this.HMc.size());
                AppMethodBeat.o(198236);
                return nVar2;
            }
        }
    }

    static /* synthetic */ void j(e eVar) {
        AppMethodBeat.i(198246);
        eVar.QNN.onClick();
        AppMethodBeat.o(198246);
    }
}
