package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.u;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ah;
import android.support.v7.widget.y;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.R;

final class t extends m implements o, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private static final int afn = R.layout.b0;
    private boolean XI;
    private final h aaQ;
    View afA;
    private o.a afH;
    ViewTreeObserver afI;
    private PopupWindow.OnDismissListener afJ;
    private final int afp;
    private final int afq;
    private final boolean afr;
    final ViewTreeObserver.OnGlobalLayoutListener afv = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class android.support.v7.view.menu.t.AnonymousClass1 */

        public final void onGlobalLayout() {
            if (t.this.isShowing() && !t.this.ahj.arz) {
                View view = t.this.afA;
                if (view == null || !view.isShown()) {
                    t.this.dismiss();
                } else {
                    t.this.ahj.show();
                }
            }
        }
    };
    private final View.OnAttachStateChangeListener afw = new View.OnAttachStateChangeListener() {
        /* class android.support.v7.view.menu.t.AnonymousClass2 */

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (t.this.afI != null) {
                if (!t.this.afI.isAlive()) {
                    t.this.afI = view.getViewTreeObserver();
                }
                t.this.afI.removeGlobalOnLayoutListener(t.this.afv);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int afz = 0;
    private final g ahh;
    private final int ahi;
    final ah ahj;
    private boolean ahk;
    private boolean ahl;
    private int ahm;
    private final Context mContext;
    private View qK;

    public t(Context context, h hVar, View view, int i2, int i3, boolean z) {
        this.mContext = context;
        this.aaQ = hVar;
        this.afr = z;
        this.ahh = new g(hVar, LayoutInflater.from(context), this.afr, afn);
        this.afp = i2;
        this.afq = i3;
        Resources resources = context.getResources();
        this.ahi = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.mh));
        this.qK = view;
        this.ahj = new ah(this.mContext, this.afp, this.afq);
        hVar.a(this, context);
    }

    @Override // android.support.v7.view.menu.m
    public final void setForceShowIcon(boolean z) {
        this.ahh.afG = z;
    }

    @Override // android.support.v7.view.menu.m
    public final void setGravity(int i2) {
        this.afz = i2;
    }

    @Override // android.support.v7.view.menu.s
    public final void show() {
        boolean z = true;
        if (!isShowing()) {
            if (this.ahk || this.qK == null) {
                z = false;
            } else {
                this.afA = this.qK;
                this.ahj.setOnDismissListener(this);
                this.ahj.ars = this;
                this.ahj.setModal(true);
                View view = this.afA;
                boolean z2 = this.afI == null;
                this.afI = view.getViewTreeObserver();
                if (z2) {
                    this.afI.addOnGlobalLayoutListener(this.afv);
                }
                view.addOnAttachStateChangeListener(this.afw);
                this.ahj.arp = view;
                this.ahj.afz = this.afz;
                if (!this.ahl) {
                    this.ahm = a(this.ahh, null, this.mContext, this.ahi);
                    this.ahl = true;
                }
                this.ahj.setContentWidth(this.ahm);
                this.ahj.kC();
                this.ahj.ahd = this.ahd;
                this.ahj.show();
                y yVar = this.ahj.arc;
                yVar.setOnKeyListener(this);
                if (this.XI && this.aaQ.agy != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.az, (ViewGroup) yVar, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.aaQ.agy);
                    }
                    frameLayout.setEnabled(false);
                    yVar.addHeaderView(frameLayout, null, false);
                }
                this.ahj.setAdapter(this.ahh);
                this.ahj.show();
            }
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.support.v7.view.menu.s
    public final void dismiss() {
        if (isShowing()) {
            this.ahj.dismiss();
        }
    }

    @Override // android.support.v7.view.menu.m
    public final void f(h hVar) {
    }

    @Override // android.support.v7.view.menu.s
    public final boolean isShowing() {
        return !this.ahk && this.ahj.arA.isShowing();
    }

    public final void onDismiss() {
        this.ahk = true;
        this.aaQ.close();
        if (this.afI != null) {
            if (!this.afI.isAlive()) {
                this.afI = this.afA.getViewTreeObserver();
            }
            this.afI.removeGlobalOnLayoutListener(this.afv);
            this.afI = null;
        }
        this.afA.removeOnAttachStateChangeListener(this.afw);
        if (this.afJ != null) {
            this.afJ.onDismiss();
        }
    }

    @Override // android.support.v7.view.menu.o
    public final void p(boolean z) {
        this.ahl = false;
        if (this.ahh != null) {
            this.ahh.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.o
    public final void a(o.a aVar) {
        this.afH = aVar;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean a(u uVar) {
        boolean z;
        if (uVar.hasVisibleItems()) {
            n nVar = new n(this.mContext, uVar, this.afA, this.afr, this.afp, this.afq);
            nVar.c(this.afH);
            nVar.setForceShowIcon(m.h(uVar));
            nVar.afJ = this.afJ;
            this.afJ = null;
            this.aaQ.aa(false);
            int i2 = this.ahj.are;
            int verticalOffset = this.ahj.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.afz, u.Z(this.qK)) & 7) == 5) {
                i2 += this.qK.getWidth();
            }
            if (nVar.isShowing()) {
                z = true;
            } else if (nVar.qK == null) {
                z = false;
            } else {
                nVar.b(i2, verticalOffset, true, true);
                z = true;
            }
            if (z) {
                if (this.afH != null) {
                    this.afH.d(uVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final void a(h hVar, boolean z) {
        if (hVar == this.aaQ) {
            dismiss();
            if (this.afH != null) {
                this.afH.a(hVar, z);
            }
        }
    }

    @Override // android.support.v7.view.menu.o
    public final boolean bF() {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // android.support.v7.view.menu.o
    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // android.support.v7.view.menu.m
    public final void setAnchorView(View view) {
        this.qK = view;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // android.support.v7.view.menu.m
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.afJ = onDismissListener;
    }

    @Override // android.support.v7.view.menu.s
    public final ListView getListView() {
        return this.ahj.arc;
    }

    @Override // android.support.v7.view.menu.m
    public final void setHorizontalOffset(int i2) {
        this.ahj.are = i2;
    }

    @Override // android.support.v7.view.menu.m
    public final void setVerticalOffset(int i2) {
        this.ahj.setVerticalOffset(i2);
    }

    @Override // android.support.v7.view.menu.m
    public final void setShowTitle(boolean z) {
        this.XI = z;
    }
}
