package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker extends YADatePicker {
    private boolean ozc = true;
    private boolean ozd = true;
    private NumberPicker oze;
    private NumberPicker ozf;
    private NumberPicker ozg;
    private Date ozh;
    private Date ozi;
    private Calendar ozj;
    private String[] ozk;

    static /* synthetic */ void a(CustomDatePicker customDatePicker) {
        AppMethodBeat.i(159507);
        customDatePicker.ccq();
        AppMethodBeat.o(159507);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159492);
        initView();
        AppMethodBeat.o(159492);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159493);
        initView();
        AppMethodBeat.o(159493);
    }

    private void initView() {
        AppMethodBeat.i(159494);
        this.ozk = new String[12];
        for (int i2 = 0; i2 < this.ozk.length; i2++) {
            this.ozk[i2] = new StringBuilder().append(i2 + 1).toString();
        }
        this.ozj = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.oze = ((YADatePicker.c) getUIDelegate()).QUi;
        this.ozf = ((YADatePicker.c) getUIDelegate()).QUh;
        this.ozg = ((YADatePicker.c) getUIDelegate()).QUg;
        hcd();
        f.d(this.oze);
        f.d(this.ozf);
        f.d(this.ozg);
        f.b(this.oze, getResources().getColor(R.color.a2x));
        f.b(this.ozf, getResources().getColor(R.color.a2x));
        f.b(this.ozg, getResources().getColor(R.color.a2x));
        AnonymousClass1 r0 = new NumberPicker.OnValueChangeListener() {
            /* class com.tencent.mm.ui.widget.picker.CustomDatePicker.AnonymousClass1 */

            public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                AppMethodBeat.i(159491);
                CustomDatePicker.a(CustomDatePicker.this);
                AppMethodBeat.o(159491);
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
        AppMethodBeat.o(159494);
    }

    private void hcd() {
        AppMethodBeat.i(159495);
        Drawable drawable = getResources().getDrawable(R.drawable.aod);
        f.a(this.oze, drawable);
        f.a(this.ozf, drawable);
        f.a(this.ozg, drawable);
        AppMethodBeat.o(159495);
    }

    public final void ccq() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(159496);
        if (this.oze == null || this.ozf == null || this.ozg == null) {
            AppMethodBeat.o(159496);
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
        AppMethodBeat.o(159496);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public void setMaxDate(long j2) {
        AppMethodBeat.i(159497);
        super.setMaxDate(j2);
        this.ozi = new Date(j2);
        if (this.oze != null) {
            this.oze.setMaxValue(this.ozi.getYear() + 1900);
        }
        ccq();
        AppMethodBeat.o(159497);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public void setMinDate(long j2) {
        AppMethodBeat.i(159498);
        super.setMinDate(j2);
        this.ozh = new Date(j2);
        if (this.oze != null) {
            this.oze.setMinValue(this.ozh.getYear() + 1900);
        }
        AppMethodBeat.o(159498);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public final void a(int i2, int i3, int i4, YADatePicker.d dVar) {
        AppMethodBeat.i(159500);
        super.a(i2, Math.max(i3 - 1, 0), i4, dVar);
        ccq();
        AppMethodBeat.o(159500);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public int getYear() {
        AppMethodBeat.i(159501);
        if (this.oze != null) {
            int value = this.oze.getValue();
            AppMethodBeat.o(159501);
            return value;
        }
        int year = super.getYear();
        AppMethodBeat.o(159501);
        return year;
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public int getMonth() {
        int month;
        AppMethodBeat.i(159502);
        if (this.ozf != null) {
            month = this.ozf.getValue() + 1;
        } else {
            month = super.getMonth() + 1;
        }
        int max = Math.max(Math.min(month, 12), 0);
        AppMethodBeat.o(159502);
        return max;
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public int getDayOfMonth() {
        AppMethodBeat.i(159503);
        if (this.ozg != null) {
            int value = this.ozg.getValue();
            AppMethodBeat.o(159503);
            return value;
        }
        int dayOfMonth = super.getDayOfMonth();
        AppMethodBeat.o(159503);
        return dayOfMonth;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(159504);
        super.onAttachedToWindow();
        f.e(this.oze);
        f.e(this.ozf);
        f.e(this.ozg);
        AppMethodBeat.o(159504);
    }
}
