package com.tencent.mm.ui.base;

import android.os.Build;
import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class z extends q {
    private final y OWt;

    public abstract View e(int i2, View view);

    public z() {
        this(new y());
    }

    private z(y yVar) {
        this.OWt = yVar;
        SparseArray<View>[] sparseArrayArr = new SparseArray[1];
        for (int i2 = 0; i2 <= 0; i2++) {
            sparseArrayArr[0] = new SparseArray<>();
        }
        yVar.BCE = 1;
        yVar.OWs = sparseArrayArr[0];
        yVar.OWr = sparseArrayArr;
    }

    @Override // android.support.v4.view.q
    public void notifyDataSetChanged() {
        y yVar = this.OWt;
        View[] viewArr = yVar.OWp;
        int[] iArr = yVar.OWq;
        boolean z = yVar.BCE > 1;
        SparseArray<View> sparseArray = yVar.OWs;
        for (int length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                int i2 = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if (i2 >= 0) {
                    if (z) {
                        sparseArray = yVar.OWr[i2];
                    }
                    sparseArray.put(length, view);
                    if (Build.VERSION.SDK_INT >= 14) {
                        view.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        int length2 = yVar.OWp.length;
        int i3 = yVar.BCE;
        SparseArray<View>[] sparseArrayArr = yVar.OWr;
        for (int i4 = 0; i4 < i3; i4++) {
            SparseArray<View> sparseArray2 = sparseArrayArr[i4];
            int size = sparseArray2.size();
            int i5 = size - length2;
            int i6 = size - 1;
            int i7 = 0;
            while (i7 < i5) {
                sparseArray2.remove(sparseArray2.keyAt(i6));
                i7++;
                i6--;
            }
        }
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.q
    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        View view;
        y yVar = this.OWt;
        if (yVar.BCE == 1) {
            view = y.d(yVar.OWs, i2);
        } else if (yVar.OWr.length > 0) {
            view = y.d(yVar.OWr[0], i2);
        } else {
            view = null;
        }
        View e2 = e(i2, view);
        viewGroup.addView(e2);
        return e2;
    }

    @Override // android.support.v4.view.q
    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        y yVar = this.OWt;
        if (yVar.BCE == 1) {
            yVar.OWs.put(i2, view);
        } else {
            yVar.OWr[0].put(i2, view);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            view.setAccessibilityDelegate(null);
        }
    }

    @Override // android.support.v4.view.q
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
