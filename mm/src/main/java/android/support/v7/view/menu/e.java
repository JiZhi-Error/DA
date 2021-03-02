package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.d;
import android.support.v4.view.u;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ag;
import android.support.v7.widget.ah;
import android.support.v7.widget.y;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

final class e extends m implements o, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int afn = R.layout.as;
    private boolean XI;
    View afA;
    private int afB;
    private boolean afC;
    private boolean afD;
    private int afE;
    private int afF;
    private boolean afG;
    private o.a afH;
    ViewTreeObserver afI;
    private PopupWindow.OnDismissListener afJ;
    boolean afK;
    private final int afo;
    private final int afp;
    private final int afq;
    private final boolean afr;
    final Handler afs;
    private final List<h> aft = new ArrayList();
    final List<a> afu = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener afv = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class android.support.v7.view.menu.e.AnonymousClass1 */

        public final void onGlobalLayout() {
            if (e.this.isShowing() && e.this.afu.size() > 0 && !e.this.afu.get(0).afQ.arz) {
                View view = e.this.afA;
                if (view == null || !view.isShown()) {
                    e.this.dismiss();
                    return;
                }
                for (a aVar : e.this.afu) {
                    aVar.afQ.show();
                }
            }
        }
    };
    private final View.OnAttachStateChangeListener afw = new View.OnAttachStateChangeListener() {
        /* class android.support.v7.view.menu.e.AnonymousClass2 */

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (e.this.afI != null) {
                if (!e.this.afI.isAlive()) {
                    e.this.afI = view.getViewTreeObserver();
                }
                e.this.afI.removeGlobalOnLayoutListener(e.this.afv);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final ag afx = new ag() {
        /* class android.support.v7.view.menu.e.AnonymousClass3 */

        @Override // android.support.v7.widget.ag
        public final void b(h hVar, MenuItem menuItem) {
            e.this.afs.removeCallbacksAndMessages(hVar);
        }

        @Override // android.support.v7.widget.ag
        public final void c(final h hVar, final MenuItem menuItem) {
            int i2;
            final a aVar;
            e.this.afs.removeCallbacksAndMessages(null);
            int i3 = 0;
            int size = e.this.afu.size();
            while (true) {
                if (i3 >= size) {
                    i2 = -1;
                    break;
                } else if (hVar == e.this.afu.get(i3).kE) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 != -1) {
                int i4 = i2 + 1;
                if (i4 < e.this.afu.size()) {
                    aVar = e.this.afu.get(i4);
                } else {
                    aVar = null;
                }
                e.this.afs.postAtTime(new Runnable() {
                    /* class android.support.v7.view.menu.e.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        if (aVar != null) {
                            e.this.afK = true;
                            aVar.kE.aa(false);
                            e.this.afK = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.a(menuItem, (o) null, 4);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int afy = 0;
    private int afz = 0;
    private final Context mContext;
    private View qK;

    public e(Context context, View view, int i2, int i3, boolean z) {
        this.mContext = context;
        this.qK = view;
        this.afp = i2;
        this.afq = i3;
        this.afr = z;
        this.afG = false;
        this.afB = hR();
        Resources resources = context.getResources();
        this.afo = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.mh));
        this.afs = new Handler();
    }

    @Override // android.support.v7.view.menu.m
    public final void setForceShowIcon(boolean z) {
        this.afG = z;
    }

    private ah hQ() {
        ah ahVar = new ah(this.mContext, this.afp, this.afq);
        ahVar.arD = this.afx;
        ahVar.ars = this;
        ahVar.setOnDismissListener(this);
        ahVar.arp = this.qK;
        ahVar.afz = this.afz;
        ahVar.setModal(true);
        ahVar.kC();
        return ahVar;
    }

    @Override // android.support.v7.view.menu.s
    public final void show() {
        if (!isShowing()) {
            for (h hVar : this.aft) {
                g(hVar);
            }
            this.aft.clear();
            this.afA = this.qK;
            if (this.afA != null) {
                boolean z = this.afI == null;
                this.afI = this.afA.getViewTreeObserver();
                if (z) {
                    this.afI.addOnGlobalLayoutListener(this.afv);
                }
                this.afA.addOnAttachStateChangeListener(this.afw);
            }
        }
    }

    @Override // android.support.v7.view.menu.s
    public final void dismiss() {
        int size = this.afu.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.afu.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.afQ.arA.isShowing()) {
                    aVar.afQ.dismiss();
                }
            }
        }
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    private int hR() {
        if (u.Z(this.qK) == 1) {
            return 0;
        }
        return 1;
    }

    private int bu(int i2) {
        y yVar = this.afu.get(this.afu.size() - 1).afQ.arc;
        int[] iArr = new int[2];
        yVar.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.afA.getWindowVisibleDisplayFrame(rect);
        if (this.afB != 1) {
            return iArr[0] - i2 < 0 ? 1 : 0;
        }
        return (yVar.getWidth() + iArr[0]) + i2 > rect.right ? 0 : 1;
    }

    @Override // android.support.v7.view.menu.m
    public final void f(h hVar) {
        hVar.a(this, this.mContext);
        if (isShowing()) {
            g(hVar);
        } else {
            this.aft.add(hVar);
        }
    }

    private void g(h hVar) {
        View view;
        a aVar;
        boolean z;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        g gVar = new g(hVar, from, this.afr, afn);
        if (!isShowing() && this.afG) {
            gVar.afG = true;
        } else if (isShowing()) {
            gVar.afG = m.h(hVar);
        }
        int a2 = a(gVar, null, this.mContext, this.afo);
        ah hQ = hQ();
        hQ.setAdapter(gVar);
        hQ.setContentWidth(a2);
        hQ.afz = this.afz;
        if (this.afu.size() > 0) {
            a aVar2 = this.afu.get(this.afu.size() - 1);
            view = a(aVar2, hVar);
            aVar = aVar2;
        } else {
            view = null;
            aVar = null;
        }
        if (view != null) {
            hQ.kF();
            hQ.kE();
            int bu = bu(a2);
            if (bu == 1) {
                z = true;
            } else {
                z = false;
            }
            this.afB = bu;
            if (Build.VERSION.SDK_INT >= 26) {
                hQ.arp = view;
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.qK.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.afz & 7) == 5) {
                    iArr[0] = iArr[0] + this.qK.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.afz & 5) == 5) {
                if (z) {
                    i4 = i2 + a2;
                } else {
                    i4 = i2 - view.getWidth();
                }
            } else if (z) {
                i4 = view.getWidth() + i2;
            } else {
                i4 = i2 - a2;
            }
            hQ.are = i4;
            hQ.kD();
            hQ.setVerticalOffset(i3);
        } else {
            if (this.afC) {
                hQ.are = this.afE;
            }
            if (this.afD) {
                hQ.setVerticalOffset(this.afF);
            }
            hQ.ahd = this.ahd;
        }
        this.afu.add(new a(hQ, hVar, this.afB));
        hQ.show();
        y yVar = hQ.arc;
        yVar.setOnKeyListener(this);
        if (aVar == null && this.XI && hVar.agy != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.az, (ViewGroup) yVar, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(hVar.agy);
            yVar.addHeaderView(frameLayout, null, false);
            hQ.show();
        }
    }

    private static MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = hVar.getItem(i2);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private static View a(a aVar, h hVar) {
        g gVar;
        int i2;
        int i3;
        int i4 = 0;
        MenuItem a2 = a(aVar.kE, hVar);
        if (a2 == null) {
            return null;
        }
        y yVar = aVar.afQ.arc;
        ListAdapter adapter = yVar.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            i2 = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i4 >= count) {
                i3 = -1;
                break;
            } else if (a2 == gVar.getItem(i4)) {
                i3 = i4;
                break;
            } else {
                i4++;
            }
        }
        if (i3 == -1) {
            return null;
        }
        int firstVisiblePosition = (i3 + i2) - yVar.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= yVar.getChildCount()) {
            return null;
        }
        return yVar.getChildAt(firstVisiblePosition);
    }

    @Override // android.support.v7.view.menu.s
    public final boolean isShowing() {
        return this.afu.size() > 0 && this.afu.get(0).afQ.arA.isShowing();
    }

    public final void onDismiss() {
        a aVar;
        int size = this.afu.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.afu.get(i2);
            if (!aVar.afQ.arA.isShowing()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.kE.aa(false);
        }
    }

    @Override // android.support.v7.view.menu.o
    public final void p(boolean z) {
        for (a aVar : this.afu) {
            a(aVar.afQ.arc.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.o
    public final void a(o.a aVar) {
        this.afH = aVar;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean a(u uVar) {
        for (a aVar : this.afu) {
            if (uVar == aVar.kE) {
                aVar.afQ.arc.requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        f(uVar);
        if (this.afH != null) {
            this.afH.d(uVar);
        }
        return true;
    }

    @Override // android.support.v7.view.menu.o
    public final void a(h hVar, boolean z) {
        int size = this.afu.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (hVar == this.afu.get(i2).kE) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int i3 = i2 + 1;
            if (i3 < this.afu.size()) {
                this.afu.get(i3).kE.aa(false);
            }
            a remove = this.afu.remove(i2);
            remove.kE.b(this);
            if (this.afK) {
                ah ahVar = remove.afQ;
                if (Build.VERSION.SDK_INT >= 23) {
                    ahVar.arA.setExitTransition(null);
                }
                remove.afQ.setAnimationStyle(0);
            }
            remove.afQ.dismiss();
            int size2 = this.afu.size();
            if (size2 > 0) {
                this.afB = this.afu.get(size2 - 1).position;
            } else {
                this.afB = hR();
            }
            if (size2 == 0) {
                dismiss();
                if (this.afH != null) {
                    this.afH.a(hVar, true);
                }
                if (this.afI != null) {
                    if (this.afI.isAlive()) {
                        this.afI.removeGlobalOnLayoutListener(this.afv);
                    }
                    this.afI = null;
                }
                this.afA.removeOnAttachStateChangeListener(this.afw);
                this.afJ.onDismiss();
            } else if (z) {
                this.afu.get(0).kE.aa(false);
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
    public final void setGravity(int i2) {
        if (this.afy != i2) {
            this.afy = i2;
            this.afz = d.getAbsoluteGravity(i2, u.Z(this.qK));
        }
    }

    @Override // android.support.v7.view.menu.m
    public final void setAnchorView(View view) {
        if (this.qK != view) {
            this.qK = view;
            this.afz = d.getAbsoluteGravity(this.afy, u.Z(this.qK));
        }
    }

    @Override // android.support.v7.view.menu.m
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.afJ = onDismissListener;
    }

    @Override // android.support.v7.view.menu.s
    public final ListView getListView() {
        if (this.afu.isEmpty()) {
            return null;
        }
        return this.afu.get(this.afu.size() - 1).afQ.arc;
    }

    @Override // android.support.v7.view.menu.m
    public final void setHorizontalOffset(int i2) {
        this.afC = true;
        this.afE = i2;
    }

    @Override // android.support.v7.view.menu.m
    public final void setVerticalOffset(int i2) {
        this.afD = true;
        this.afF = i2;
    }

    @Override // android.support.v7.view.menu.m
    public final void setShowTitle(boolean z) {
        this.XI = z;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.view.menu.m
    public final boolean hS() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public final ah afQ;
        public final h kE;
        public final int position;

        public a(ah ahVar, h hVar, int i2) {
            this.afQ = ahVar;
            this.kE = hVar;
            this.position = i2;
        }
    }
}
