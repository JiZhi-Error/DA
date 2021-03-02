package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

class RecentsRecyclerView extends LoadMoreRecyclerView {
    private View oeo;

    public RecentsRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(49272);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.o(49272);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49273);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.o(49273);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(49274);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.o(49274);
    }

    @Override // android.support.v7.widget.RecyclerView
    public int getChildDrawingOrder(int i2, int i3) {
        AppMethodBeat.i(49275);
        if (this.oeo == null) {
            int childDrawingOrder = super.getChildDrawingOrder(i2, i3);
            AppMethodBeat.o(49275);
            return childDrawingOrder;
        }
        int indexOfChild = indexOfChild(this.oeo);
        if (indexOfChild < 0) {
            int childDrawingOrder2 = super.getChildDrawingOrder(i2, i3);
            AppMethodBeat.o(49275);
            return childDrawingOrder2;
        } else if (i3 == i2 - 1) {
            AppMethodBeat.o(49275);
            return indexOfChild;
        } else if (i3 == indexOfChild) {
            int i4 = i2 - 1;
            AppMethodBeat.o(49275);
            return i4;
        } else {
            int childDrawingOrder3 = super.getChildDrawingOrder(i2, i3);
            AppMethodBeat.o(49275);
            return childDrawingOrder3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(49276);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(49276);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(49276);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(49277);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(49277);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(49277);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(49278);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            try {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(49278);
                return onTouchEvent;
            } catch (IndexOutOfBoundsException e2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                boolean onTouchEvent2 = super.onTouchEvent(obtain);
                AppMethodBeat.o(49278);
                return onTouchEvent2;
            }
        } else {
            AppMethodBeat.o(49278);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void cJ(View view) {
        AppMethodBeat.i(49279);
        if (view.getParent() != this) {
            AppMethodBeat.o(49279);
        } else if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(1.0f);
            AppMethodBeat.o(49279);
        } else {
            this.oeo = view;
            AppMethodBeat.o(49279);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cK(View view) {
        AppMethodBeat.i(49280);
        if (view.getParent() != this) {
            AppMethodBeat.o(49280);
        } else if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(0.0f);
            AppMethodBeat.o(49280);
        } else {
            if (this.oeo == view) {
                this.oeo = null;
            }
            AppMethodBeat.o(49280);
        }
    }
}
