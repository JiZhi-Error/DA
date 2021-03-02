package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import java.util.ArrayList;
import java.util.List;

public final class AppBrandMultiOptionsPickerV2 extends LinearLayout implements c<int[]> {
    private boolean asn;
    private boolean ozs;
    private c ozt;
    public List<AppBrandOptionsPickerV3> ozx = new ArrayList();

    @Keep
    public AppBrandMultiOptionsPickerV2(Context context) {
        super(context);
        AppMethodBeat.i(138007);
        setOrientation(0);
        AppMethodBeat.o(138007);
    }

    public static final class a {
        public final String[] ozw;
        public final int selected;

        public a(String[] strArr, int i2) {
            AppMethodBeat.i(138006);
            this.ozw = strArr;
            this.selected = Math.max(0, Math.min(i2, strArr.length - 1));
            AppMethodBeat.o(138006);
        }
    }

    public final void setLayoutFrozen(boolean z) {
        AppMethodBeat.i(138008);
        if (this.asn != z) {
            this.asn = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                AppMethodBeat.o(138008);
                return;
            } else if (this.ozs) {
                requestLayout();
            }
        }
        AppMethodBeat.o(138008);
    }

    public final void requestLayout() {
        AppMethodBeat.i(138009);
        if (this.asn) {
            this.ozs = true;
            AppMethodBeat.o(138009);
            return;
        }
        super.requestLayout();
        AppMethodBeat.o(138009);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(138010);
        if (this.asn) {
            AppMethodBeat.o(138010);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(138010);
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(138011);
        if (this.asn) {
            AppMethodBeat.o(138011);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(138011);
        return onTouchEvent;
    }

    public final AppBrandOptionsPickerV3 Av(int i2) {
        AppMethodBeat.i(138012);
        if (i2 < 0) {
            AppMethodBeat.o(138012);
            return null;
        }
        AppBrandOptionsPickerV3 appBrandOptionsPickerV3 = this.ozx.get(i2);
        AppMethodBeat.o(138012);
        return appBrandOptionsPickerV3;
    }

    public final int getPickersCount() {
        AppMethodBeat.i(138013);
        int childCount = getChildCount();
        AppMethodBeat.o(138013);
        return childCount;
    }

    public final void ccr() {
        AppMethodBeat.i(138014);
        if (this.ozx.size() == 1) {
            this.ozx.get(0).ozD.blh().setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.cb), 0, getContext().getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(138014);
        } else if (this.ozx.size() == 2) {
            this.ozx.get(0).ozD.blh().setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.cb), getContext().getResources().getDimensionPixelSize(R.dimen.cb), getContext().getResources().getDimensionPixelSize(R.dimen.cb));
            this.ozx.get(1).ozD.blh().setPadding(getContext().getResources().getDimensionPixelSize(R.dimen.cb), getContext().getResources().getDimensionPixelSize(R.dimen.cb), 0, getContext().getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(138014);
        } else {
            if (this.ozx.size() == 3) {
                this.ozx.get(0).ozD.blh().setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.cb), getContext().getResources().getDimensionPixelSize(R.dimen.bt), getContext().getResources().getDimensionPixelSize(R.dimen.cb));
                this.ozx.get(1).ozD.blh().setPadding(getContext().getResources().getDimensionPixelSize(R.dimen.bt), getContext().getResources().getDimensionPixelSize(R.dimen.cb), getContext().getResources().getDimensionPixelSize(R.dimen.bt), getContext().getResources().getDimensionPixelSize(R.dimen.cb));
                this.ozx.get(2).ozD.blh().setPadding(getContext().getResources().getDimensionPixelSize(R.dimen.bt), getContext().getResources().getDimensionPixelSize(R.dimen.cb), 0, getContext().getResources().getDimensionPixelSize(R.dimen.cb));
            }
            AppMethodBeat.o(138014);
        }
    }

    public final void Au(int i2) {
        AppMethodBeat.i(138015);
        if (i2 <= 0) {
            AppMethodBeat.o(138015);
            return;
        }
        int pickersCount = getPickersCount() - 1;
        while (i2 > 0) {
            removeViewAt(pickersCount);
            pickersCount--;
            i2--;
        }
        ccr();
        AppMethodBeat.o(138015);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onShow(c cVar) {
        this.ozt = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onHide(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onAttach(c cVar) {
        this.ozt = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onDetach(c cVar) {
        this.ozt = null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final /* synthetic */ int[] currentValue() {
        AppMethodBeat.i(138016);
        int pickersCount = getPickersCount();
        if (pickersCount <= 0) {
            int[] iArr = new int[0];
            AppMethodBeat.o(138016);
            return iArr;
        }
        int[] iArr2 = new int[pickersCount];
        for (int i2 = 0; i2 < pickersCount; i2++) {
            iArr2[i2] = Av(i2).getValue();
        }
        AppMethodBeat.o(138016);
        return iArr2;
    }
}
