package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker;

public final class AppBrandMultiOptionsPicker extends FrameLayout implements c<int[]> {
    private boolean asn;
    private final Drawable ozq;
    public LinearLayout ozr;
    private boolean ozs;
    private c ozt;
    public final YANumberPicker.b ozu = new YANumberPicker.b() {
        /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.b
        public final void a(YANumberPicker yANumberPicker, int i2) {
            AppMethodBeat.i(137993);
            if (AppBrandMultiOptionsPicker.this.ozt != null) {
                int intValue = ((Integer) yANumberPicker.getTag(R.id.pj)).intValue();
                AppBrandMultiOptionsPicker.this.ozt.cY(new int[]{intValue, i2});
            }
            AppMethodBeat.o(137993);
        }
    };

    @Keep
    public AppBrandMultiOptionsPicker(Context context) {
        super(context);
        AppMethodBeat.i(137995);
        this.ozq = context.getResources().getDrawable(R.drawable.d6);
        this.ozr = new LinearLayout(context);
        this.ozr.setPadding(com.tencent.mm.cb.a.fromDPToPix(context, 2), 0, com.tencent.mm.cb.a.fromDPToPix(context, 2), 0);
        this.ozr.setOrientation(0);
        addView(this.ozr, new FrameLayout.LayoutParams(-1, -1, 17));
        this.ozr.setDividerDrawable(this.ozq);
        this.ozr.setShowDividers(2);
        AppMethodBeat.o(137995);
    }

    public static final class a {
        public final String[] ozw;
        public final int selected;

        public a(String[] strArr, int i2) {
            AppMethodBeat.i(137994);
            this.ozw = strArr;
            this.selected = Math.max(0, Math.min(i2, strArr.length - 1));
            AppMethodBeat.o(137994);
        }
    }

    public final void setLayoutFrozen(boolean z) {
        AppMethodBeat.i(137996);
        if (this.asn != z) {
            this.asn = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                AppMethodBeat.o(137996);
                return;
            } else if (this.ozs) {
                requestLayout();
            }
        }
        AppMethodBeat.o(137996);
    }

    public final void requestLayout() {
        AppMethodBeat.i(137997);
        if (this.asn) {
            this.ozs = true;
            AppMethodBeat.o(137997);
            return;
        }
        super.requestLayout();
        AppMethodBeat.o(137997);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(137998);
        if (this.asn) {
            AppMethodBeat.o(137998);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(137998);
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(137999);
        if (this.asn) {
            AppMethodBeat.o(137999);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(137999);
        return onTouchEvent;
    }

    public final AppBrandOptionsPickerV2 At(int i2) {
        AppMethodBeat.i(138000);
        if (i2 < 0) {
            AppMethodBeat.o(138000);
            return null;
        } else if (this.ozr == null) {
            AppMethodBeat.o(138000);
            return null;
        } else {
            AppBrandOptionsPickerV2 appBrandOptionsPickerV2 = (AppBrandOptionsPickerV2) this.ozr.getChildAt(i2);
            AppMethodBeat.o(138000);
            return appBrandOptionsPickerV2;
        }
    }

    public final int getPickersCount() {
        AppMethodBeat.i(138001);
        if (this.ozr == null) {
            AppMethodBeat.o(138001);
            return 0;
        }
        int childCount = this.ozr.getChildCount();
        AppMethodBeat.o(138001);
        return childCount;
    }

    public final void Au(int i2) {
        AppMethodBeat.i(193734);
        if (i2 <= 0) {
            AppMethodBeat.o(193734);
            return;
        }
        int pickersCount = getPickersCount() - 1;
        while (i2 > 0) {
            this.ozr.removeViewAt(pickersCount);
            pickersCount--;
            i2--;
        }
        AppMethodBeat.o(193734);
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
        AppMethodBeat.i(138002);
        int pickersCount = getPickersCount();
        for (int i2 = 0; i2 < pickersCount; i2++) {
            AppBrandOptionsPickerV2 At = At(i2);
            if (At != null) {
                At.ccG();
            }
        }
        AppMethodBeat.o(138002);
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
        AppMethodBeat.i(138003);
        int pickersCount = getPickersCount();
        if (pickersCount <= 0) {
            int[] iArr = new int[0];
            AppMethodBeat.o(138003);
            return iArr;
        }
        int[] iArr2 = new int[pickersCount];
        for (int i2 = 0; i2 < pickersCount; i2++) {
            iArr2[i2] = At(i2).getValue();
        }
        AppMethodBeat.o(138003);
        return iArr2;
    }
}
