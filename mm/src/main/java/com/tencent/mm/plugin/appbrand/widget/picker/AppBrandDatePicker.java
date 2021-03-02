package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mm.ui.widget.picker.f;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class AppBrandDatePicker extends YADatePicker implements c<String> {
    public boolean ozb = true;
    public boolean ozc = true;
    public boolean ozd = true;
    public NumberPicker oze;
    public NumberPicker ozf;
    public NumberPicker ozg;
    private Date ozh;
    private Date ozi;
    private final Calendar ozj;
    private final String[] ozk = new String[12];

    static /* synthetic */ void a(AppBrandDatePicker appBrandDatePicker) {
        AppMethodBeat.i(137984);
        appBrandDatePicker.ccq();
        AppMethodBeat.o(137984);
    }

    @Keep
    public AppBrandDatePicker(Context context) {
        super(new ContextThemeWrapper(context, (int) R.style.a1j));
        AppMethodBeat.i(137973);
        for (int i2 = 0; i2 < this.ozk.length; i2++) {
            this.ozk[i2] = new StringBuilder().append(i2 + 1).toString();
        }
        this.ozj = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.oze = ((YADatePicker.c) getUIDelegate()).QUi;
        this.ozf = ((YADatePicker.c) getUIDelegate()).QUh;
        this.ozg = ((YADatePicker.c) getUIDelegate()).QUg;
        Drawable drawable = getResources().getDrawable(R.drawable.ee);
        f.a(this.oze, drawable);
        f.a(this.ozf, drawable);
        f.a(this.ozg, drawable);
        f.d(this.oze);
        f.d(this.ozf);
        f.d(this.ozg);
        d.a(this.oze);
        d.a(this.ozf);
        d.a(this.ozg);
        AnonymousClass1 r0 = new NumberPicker.OnValueChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker.AnonymousClass1 */

            public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                AppMethodBeat.i(137972);
                AppBrandDatePicker.a(AppBrandDatePicker.this);
                AppMethodBeat.o(137972);
            }
        };
        if (this.oze != null) {
            this.oze.setOnValueChangedListener(r0);
            this.oze.setMinValue(1900);
        }
        if (this.ozf != null) {
            this.ozf.setOnValueChangedListener(r0);
        }
        if (this.ozg != null) {
            this.ozg.setOnValueChangedListener(r0);
        }
        ccq();
        f.f(this.oze);
        f.f(this.ozf);
        f.f(this.ozg);
        AppMethodBeat.o(137973);
    }

    private void ccq() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(137974);
        if (this.oze == null || this.ozf == null || this.ozg == null) {
            AppMethodBeat.o(137974);
            return;
        }
        this.ozf.setDisplayedValues(null);
        if (this.oze.getValue() != this.oze.getMaxValue() || this.ozi == null) {
            this.ozf.setMaxValue(11);
            z = false;
        } else {
            this.ozf.setMaxValue(this.ozi.getMonth());
            if (this.ozf.getValue() == this.ozf.getMaxValue() && this.ozi != null) {
                this.ozg.setMaxValue(this.ozi.getDate());
                z = true;
            }
            z = false;
        }
        if (!z) {
            this.ozj.set(this.oze.getValue(), this.ozf.getValue(), 1);
            this.ozg.setMaxValue(this.ozj.getActualMaximum(5));
        }
        if (this.oze.getValue() != this.oze.getMinValue() || this.ozh == null) {
            this.ozf.setMinValue(0);
        } else {
            this.ozf.setMinValue(this.ozh.getMonth());
            if (this.ozf.getValue() == this.ozf.getMinValue() && this.ozh != null) {
                this.ozg.setMinValue(this.ozh.getDate());
                z2 = true;
            }
        }
        if (!z2) {
            this.ozg.setMinValue(1);
        }
        this.ozf.setDisplayedValues((String[]) Arrays.copyOfRange(this.ozk, this.ozf.getMinValue(), this.ozf.getMaxValue() + 1));
        this.oze.setWrapSelectorWheel(true);
        this.ozf.setWrapSelectorWheel(true);
        this.ozg.setWrapSelectorWheel(true);
        AppMethodBeat.o(137974);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public final void setMaxDate(long j2) {
        AppMethodBeat.i(137975);
        super.setMaxDate(j2);
        this.ozi = new Date(j2);
        if (this.oze != null) {
            this.oze.setMaxValue(this.ozi.getYear() + 1900);
        }
        AppMethodBeat.o(137975);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public final void setMinDate(long j2) {
        AppMethodBeat.i(137976);
        super.setMinDate(j2);
        this.ozh = new Date(j2);
        if (this.oze != null) {
            this.oze.setMinValue(this.ozh.getYear() + 1900);
        }
        AppMethodBeat.o(137976);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(137977);
        super.onAttachedToWindow();
        f.e(this.oze);
        f.e(this.ozf);
        f.e(this.ozg);
        AppMethodBeat.o(137977);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onShow(c cVar) {
        AppMethodBeat.i(137978);
        ccq();
        AppMethodBeat.o(137978);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onHide(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onAttach(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onDetach(c cVar) {
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public final void a(int i2, int i3, int i4, YADatePicker.d dVar) {
        AppMethodBeat.i(137979);
        super.a(i2, Math.max(i3 - 1, 0), i4, dVar);
        ccq();
        AppMethodBeat.o(137979);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public final int getYear() {
        AppMethodBeat.i(137980);
        if (this.oze != null) {
            int value = this.oze.getValue();
            AppMethodBeat.o(137980);
            return value;
        }
        int year = super.getYear();
        AppMethodBeat.o(137980);
        return year;
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public final int getMonth() {
        int month;
        AppMethodBeat.i(137981);
        if (this.ozf != null) {
            month = this.ozf.getValue() + 1;
        } else {
            month = super.getMonth() + 1;
        }
        int max = Math.max(Math.min(month, 12), 0);
        AppMethodBeat.o(137981);
        return max;
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public final int getDayOfMonth() {
        AppMethodBeat.i(137982);
        if (this.ozg != null) {
            int value = this.ozg.getValue();
            AppMethodBeat.o(137982);
            return value;
        }
        int dayOfMonth = super.getDayOfMonth();
        AppMethodBeat.o(137982);
        return dayOfMonth;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final /* synthetic */ String currentValue() {
        AppMethodBeat.i(137983);
        if (this.ozd) {
            String format = String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth()));
            AppMethodBeat.o(137983);
            return format;
        } else if (this.ozc) {
            String format2 = String.format(Locale.US, "%04d-%02d", Integer.valueOf(getYear()), Integer.valueOf(getMonth()));
            AppMethodBeat.o(137983);
            return format2;
        } else {
            String format3 = String.format(Locale.US, "%04d", Integer.valueOf(getYear()));
            AppMethodBeat.o(137983);
            return format3;
        }
    }
}
