package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.as;

public class CustomTimePicker extends TimePicker {
    private int mMaxTimeHour = -1;
    private int mMaxTimeMinute = -1;
    private int mMinTimeHour = -1;
    private int mMinTimeMinute = -1;
    private NumberPicker ozT;
    private NumberPicker ozU;

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, (int) R.style.a4y), attributeSet);
        AppMethodBeat.i(159509);
        initView();
        AppMethodBeat.o(159509);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159510);
        initView();
        AppMethodBeat.o(159510);
    }

    private void initView() {
        AppMethodBeat.i(159511);
        setIs24HourView(Boolean.TRUE);
        this.ozT = agd("mHourSpinner");
        this.ozU = agd("mMinuteSpinner");
        f.d(this.ozT);
        f.d(this.ozU);
        hcd();
        if (this.ozT != null) {
            this.ozT.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                /* class com.tencent.mm.ui.widget.picker.CustomTimePicker.AnonymousClass1 */

                public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                    AppMethodBeat.i(159508);
                    CustomTimePicker.a(CustomTimePicker.this);
                    AppMethodBeat.o(159508);
                }
            });
        }
        if (this.ozU != null && Build.VERSION.SDK_INT >= 21) {
            this.ozU.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                /* class com.tencent.mm.ui.widget.picker.CustomTimePicker.AnonymousClass2 */

                public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                }
            });
        }
        f.f(this.ozT);
        f.f(this.ozU);
        AppMethodBeat.o(159511);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(159513);
        super.onAttachedToWindow();
        f.e(this.ozT);
        f.e(this.ozU);
        AppMethodBeat.o(159513);
    }

    private NumberPicker agd(String str) {
        AppMethodBeat.i(159517);
        if (Build.VERSION.SDK_INT >= 21) {
            NumberPicker agf = agf(str);
            AppMethodBeat.o(159517);
            return agf;
        }
        NumberPicker age = age(str);
        AppMethodBeat.o(159517);
        return age;
    }

    private NumberPicker age(String str) {
        AppMethodBeat.i(159518);
        try {
            NumberPicker numberPicker = (NumberPicker) new an(this, str).get();
            AppMethodBeat.o(159518);
            return numberPicker;
        } catch (Exception e2) {
            AppMethodBeat.o(159518);
            return null;
        }
    }

    private NumberPicker agf(String str) {
        AppMethodBeat.i(159519);
        try {
            Object obj = new an(this, "mDelegate").get();
            if (obj != null) {
                NumberPicker numberPicker = (NumberPicker) new an(obj, str).get();
                AppMethodBeat.o(159519);
                return numberPicker;
            }
        } catch (NoSuchFieldException e2) {
            as.printErrStackTrace("CustomTimePicker", e2, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
        } catch (IllegalAccessException e3) {
            as.printErrStackTrace("CustomTimePicker", e3, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
        }
        AppMethodBeat.o(159519);
        return null;
    }

    private void hcd() {
        AppMethodBeat.i(159520);
        Drawable drawable = getResources().getDrawable(R.drawable.aod);
        f.a(this.ozT, drawable);
        f.a(this.ozU, drawable);
        AppMethodBeat.o(159520);
    }

    static /* synthetic */ void a(CustomTimePicker customTimePicker) {
        AppMethodBeat.i(159521);
        if (g.Ax(customTimePicker.mMinTimeHour) && g.Aw(customTimePicker.mMinTimeMinute) && customTimePicker.ozT != null && customTimePicker.ozU != null) {
            if (customTimePicker.ozT.getValue() == customTimePicker.mMinTimeHour) {
                customTimePicker.ozU.setMinValue(customTimePicker.mMinTimeMinute);
            } else {
                customTimePicker.ozU.setMinValue(0);
            }
        }
        if (!(!g.Ax(customTimePicker.mMaxTimeHour) || customTimePicker.ozT == null || customTimePicker.ozU == null)) {
            if (customTimePicker.ozT.getValue() == customTimePicker.mMaxTimeHour) {
                customTimePicker.ozU.setMaxValue(customTimePicker.mMaxTimeMinute);
                AppMethodBeat.o(159521);
                return;
            }
            customTimePicker.ozU.setMaxValue(59);
        }
        AppMethodBeat.o(159521);
    }
}
