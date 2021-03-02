package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import com.tencent.mm.ui.widget.picker.f;
import com.tencent.mm.ui.widget.picker.g;
import java.util.Locale;

public final class AppBrandTimePicker extends TimePicker implements c<String> {
    public int mMaxTimeHour = -1;
    public int mMaxTimeMinute = -1;
    public int mMinTimeHour = -1;
    public int mMinTimeMinute = -1;
    public NumberPicker ozT;
    private NumberPicker ozU;

    static /* synthetic */ void a(AppBrandTimePicker appBrandTimePicker) {
        AppMethodBeat.i(138074);
        appBrandTimePicker.dgV();
        AppMethodBeat.o(138074);
    }

    @Keep
    public AppBrandTimePicker(Context context) {
        super(new ContextThemeWrapper(context, (int) R.style.a1j));
        AppMethodBeat.i(138065);
        setIs24HourView(Boolean.TRUE);
        this.ozT = agd("mHourSpinner");
        this.ozU = agd("mMinuteSpinner");
        f.d(this.ozT);
        f.d(this.ozU);
        d.a(this.ozT);
        d.a(this.ozU);
        Drawable drawable = getResources().getDrawable(R.drawable.ee);
        f.a(this.ozT, drawable);
        f.a(this.ozU, drawable);
        if (this.ozT != null) {
            this.ozT.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker.AnonymousClass1 */

                public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                    AppMethodBeat.i(138064);
                    AppBrandTimePicker.a(AppBrandTimePicker.this);
                    AppMethodBeat.o(138064);
                }
            });
        }
        if (this.ozU != null && Build.VERSION.SDK_INT >= 21) {
            this.ozU.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker.AnonymousClass2 */

                public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                }
            });
        }
        f.f(this.ozT);
        f.f(this.ozU);
        AppMethodBeat.o(138065);
    }

    public final void dgV() {
        AppMethodBeat.i(138066);
        if (e.Ax(this.mMinTimeHour) && g.Aw(this.mMinTimeMinute) && this.ozT != null && this.ozU != null) {
            if (this.ozT.getValue() == this.mMinTimeHour) {
                this.ozU.setMinValue(this.mMinTimeMinute);
            } else {
                this.ozU.setMinValue(0);
            }
        }
        if (!(!e.Ax(this.mMaxTimeHour) || this.ozT == null || this.ozU == null)) {
            if (this.ozT.getValue() == this.mMaxTimeHour) {
                this.ozU.setMaxValue(this.mMaxTimeMinute);
                AppMethodBeat.o(138066);
                return;
            }
            this.ozU.setMaxValue(59);
        }
        AppMethodBeat.o(138066);
    }

    public final void setCurrentMinute(Integer num) {
        AppMethodBeat.i(138067);
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        dgV();
        AppMethodBeat.o(138067);
    }

    public final void setCurrentHour(Integer num) {
        AppMethodBeat.i(138068);
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        dgV();
        AppMethodBeat.o(138068);
    }

    private NumberPicker agd(String str) {
        AppMethodBeat.i(138069);
        if (Build.VERSION.SDK_INT >= 21) {
            NumberPicker agf = agf(str);
            AppMethodBeat.o(138069);
            return agf;
        }
        NumberPicker age = age(str);
        AppMethodBeat.o(138069);
        return age;
    }

    private NumberPicker age(String str) {
        AppMethodBeat.i(138070);
        try {
            NumberPicker numberPicker = (NumberPicker) new com.tencent.mm.compatible.loader.c(this, str, null).get();
            AppMethodBeat.o(138070);
            return numberPicker;
        } catch (Exception e2) {
            AppMethodBeat.o(138070);
            return null;
        }
    }

    private NumberPicker agf(String str) {
        AppMethodBeat.i(138071);
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(this, "mDelegate", null).get();
            if (obj != null) {
                NumberPicker numberPicker = (NumberPicker) new com.tencent.mm.compatible.loader.c(obj, str, null).get();
                AppMethodBeat.o(138071);
                return numberPicker;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(138071);
        return null;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(138072);
        super.onAttachedToWindow();
        f.e(this.ozT);
        f.e(this.ozU);
        AppMethodBeat.o(138072);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final void onShow(c cVar) {
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

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final /* synthetic */ String currentValue() {
        AppMethodBeat.i(138073);
        String format = String.format(Locale.US, "%02d:%02d", getCurrentHour(), getCurrentMinute());
        AppMethodBeat.o(138073);
        return format;
    }
}
