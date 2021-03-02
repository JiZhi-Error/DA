package com.tencent.mm.plugin.webview.fts.ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    List<a> IQB;
    public com.tencent.mm.plugin.webview.fts.c.a IQC;
    b.AbstractC1953b IQD;
    private MMWebView iGY;
    public MMHandler mHandler;
    public int nsA = -1;
    public int nsw = -1;
    public float[] nsx;
    View nsy;

    @SuppressLint({"ClickableViewAccessibility"})
    public b(MMWebView mMWebView, b.AbstractC1953b bVar) {
        AppMethodBeat.i(78132);
        this.iGY = mMWebView;
        this.mHandler = new MMHandler(Looper.getMainLooper());
        this.IQB = new LinkedList();
        this.nsy = new View(mMWebView.getContext());
        this.IQD = bVar;
        AppMethodBeat.o(78132);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view, int i2, int i3, float[] fArr, int i4) {
        int i5 = 0;
        AppMethodBeat.i(78133);
        if (view == null || fArr == null || fArr.length < 5) {
            AppMethodBeat.o(78133);
            return false;
        }
        ViewGroup afQ = afQ(i3);
        if (afQ == null) {
            AppMethodBeat.o(78133);
            return false;
        } else if (getViewById(i2) != null) {
            AppMethodBeat.o(78133);
            return false;
        } else {
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            int i6 = (int) fArr[4];
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) f4, (int) f5);
            int et = et(i3, i6);
            if (et < 0) {
                et = 0;
            }
            if (et > afQ.getChildCount()) {
                et = afQ.getChildCount();
            }
            if (i4 != Integer.MAX_VALUE && i4 >= 0) {
                if (i4 != 0) {
                    i5 = 8;
                }
                view.setVisibility(i5);
            }
            afQ.addView(view, et, layoutParams);
            view.setX(f2);
            view.setY(f3);
            e(view, i2, i3, i6);
            AppMethodBeat.o(78133);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final ViewGroup afQ(int i2) {
        AppMethodBeat.i(78134);
        if (i2 == 0) {
            ViewGroup topView = this.iGY.getTopView();
            if (topView instanceof AbsoluteLayout) {
                AppMethodBeat.o(78134);
                return topView;
            }
            AppMethodBeat.o(78134);
            return null;
        }
        a afR = afR(i2);
        if (afR == null) {
            AppMethodBeat.o(78134);
            return null;
        }
        View view = afR.nsR.get();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            AppMethodBeat.o(78134);
            return viewGroup;
        }
        AppMethodBeat.o(78134);
        return null;
    }

    public final boolean a(int i2, float[] fArr, int i3) {
        AppMethodBeat.i(78135);
        if (wH(i2)) {
            AppMethodBeat.o(78135);
            return true;
        }
        a afR = afR(i2);
        if (afR == null) {
            AppMethodBeat.o(78135);
            return false;
        }
        View view = afR.nsR.get();
        ViewGroup afQ = afQ(afR.parent);
        if (afQ == null) {
            AppMethodBeat.o(78135);
            return false;
        }
        if (i3 >= 0 && i3 != Integer.MAX_VALUE) {
            view.setVisibility(i3 == 0 ? 0 : 8);
        }
        if (fArr == null || fArr.length < 5) {
            AppMethodBeat.o(78135);
            return true;
        }
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[3];
        int i4 = (int) fArr[4];
        this.IQB.remove(afR);
        if (afR.z != i4) {
            afQ.removeView(view);
            if (a(view, i2, afR.parent, fArr, i3)) {
                AppMethodBeat.o(78135);
                return true;
            }
            a(afR);
            AppMethodBeat.o(78135);
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (f4 != Float.MAX_VALUE) {
            layoutParams.width = (int) f4;
        }
        if (f5 != Float.MAX_VALUE) {
            layoutParams.height = (int) f5;
        }
        if (f2 != Float.MAX_VALUE) {
            view.setX(f2);
        }
        if (f3 != Float.MAX_VALUE) {
            view.setY(f3);
        }
        view.requestLayout();
        e(view, i2, afR.parent, i4);
        int indexOfChild = afQ.indexOfChild(this.nsy);
        if (afQ.indexOfChild(view) == -1 && indexOfChild != -1) {
            afQ.addView(view, indexOfChild);
            afQ.removeView(this.nsy);
        }
        AppMethodBeat.o(78135);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        AppMethodBeat.i(78136);
        this.IQB.removeAll(b(aVar));
        AppMethodBeat.o(78136);
    }

    private List<a> b(a aVar) {
        AppMethodBeat.i(78137);
        LinkedList linkedList = new LinkedList();
        for (a aVar2 : this.IQB) {
            if (aVar2.parent == aVar.id) {
                linkedList.addAll(b(aVar2));
            }
        }
        linkedList.add(aVar);
        AppMethodBeat.o(78137);
        return linkedList;
    }

    private int et(int i2, int i3) {
        AppMethodBeat.i(78138);
        int i4 = 0;
        Iterator<a> it = this.IQB.iterator();
        while (true) {
            int i5 = i4;
            if (it.hasNext()) {
                a next = it.next();
                if (i2 == next.parent && i3 >= next.z) {
                    i5++;
                }
                i4 = i5;
            } else {
                AppMethodBeat.o(78138);
                return i5;
            }
        }
    }

    public final a afR(int i2) {
        AppMethodBeat.i(78139);
        for (a aVar : this.IQB) {
            if (aVar.id == i2) {
                AppMethodBeat.o(78139);
                return aVar;
            }
        }
        AppMethodBeat.o(78139);
        return null;
    }

    public final View getViewById(int i2) {
        AppMethodBeat.i(78140);
        a afR = afR(i2);
        if (afR == null) {
            AppMethodBeat.o(78140);
            return null;
        }
        View view = afR.nsR.get();
        AppMethodBeat.o(78140);
        return view;
    }

    private void e(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(78141);
        this.IQB.add(new a(view, i2, i3, i4));
        AppMethodBeat.o(78141);
    }

    public static class a {
        int id;
        public WeakReference<View> nsR;
        int parent;
        int z;

        public a(View view, int i2, int i3, int i4) {
            AppMethodBeat.i(78131);
            this.nsR = new WeakReference<>(view);
            this.id = i2;
            this.parent = i3;
            this.z = i4;
            AppMethodBeat.o(78131);
        }
    }

    public final boolean wH(int i2) {
        return this.nsA == i2 || this.nsw == i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean yQ(int i2) {
        AppMethodBeat.i(78142);
        if (i2 != this.nsw) {
            AppMethodBeat.o(78142);
            return false;
        } else if (afR(i2) == null) {
            AppMethodBeat.o(78142);
            return false;
        } else {
            this.IQD.gaO();
            AppMethodBeat.o(78142);
            return true;
        }
    }
}
