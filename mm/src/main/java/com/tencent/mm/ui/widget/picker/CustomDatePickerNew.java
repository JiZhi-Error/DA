package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.ui.widget.picker.d.f;
import com.tencent.mm.ui.widget.picker.d.g;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomDatePickerNew extends FrameLayout {
    private h QSK;
    private boolean QSL = false;
    private Context context;
    private View mView = null;
    private int mmI;
    private int mmJ;
    private int mmK;
    private boolean ozb = true;
    private boolean ozc = true;
    private boolean ozd = true;
    private Date ozh;
    private Date ozi;
    private int ozm;
    private int ozn;
    private int ozo;

    public CustomDatePickerNew(Context context2) {
        super(new ContextThemeWrapper(context2, (int) R.style.a4y));
        AppMethodBeat.i(198387);
        this.context = context2;
        this.QSK = new h(context2);
        AppMethodBeat.o(198387);
    }

    public CustomDatePickerNew(Context context2, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context2, (int) R.style.a4y), attributeSet);
        AppMethodBeat.i(198388);
        this.context = context2;
        this.QSK = new h(context2);
        AppMethodBeat.o(198388);
    }

    public CustomDatePickerNew(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(198389);
        this.context = context2;
        this.QSK = new h(context2);
        AppMethodBeat.o(198389);
    }

    public final String currentValue() {
        AppMethodBeat.i(198390);
        this.QSK.blg();
        if (this.ozd) {
            String format = String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(this.ozm), Integer.valueOf(this.ozn), Integer.valueOf(this.ozo));
            AppMethodBeat.o(198390);
            return format;
        } else if (this.ozc) {
            String format2 = String.format(Locale.US, "%04d-%02d", Integer.valueOf(this.ozm), Integer.valueOf(this.ozn));
            AppMethodBeat.o(198390);
            return format2;
        } else {
            String format3 = String.format(Locale.US, "%04d", Integer.valueOf(this.ozm));
            AppMethodBeat.o(198390);
            return format3;
        }
    }

    public View getView() {
        AppMethodBeat.i(198391);
        if (this.mView == null) {
            this.mView = this.QSK.bli();
        }
        View view = this.mView;
        AppMethodBeat.o(198391);
        return view;
    }

    public final void aW(int i2, int i3, int i4) {
        AppMethodBeat.i(198392);
        this.mmI = i2;
        this.mmJ = i3;
        this.mmK = i4;
        if (this.mView == null) {
            this.mView = this.QSK.bli();
        }
        AppMethodBeat.o(198392);
    }

    public void setMaxDate(Long l) {
        AppMethodBeat.i(198393);
        this.ozi = new Date(l.longValue());
        AppMethodBeat.o(198393);
    }

    public void setMinDate(Long l) {
        AppMethodBeat.i(198394);
        this.ozh = new Date(l.longValue());
        AppMethodBeat.o(198394);
    }

    public int getYear() {
        AppMethodBeat.i(198395);
        if (this.QSK != null) {
            this.QSK.blg();
        }
        int i2 = this.ozm;
        AppMethodBeat.o(198395);
        return i2;
    }

    public int getMonth() {
        AppMethodBeat.i(198396);
        if (this.QSK != null) {
            this.QSK.blg();
        }
        int i2 = this.ozn;
        AppMethodBeat.o(198396);
        return i2;
    }

    public int getDayOfMonth() {
        AppMethodBeat.i(198397);
        if (this.QSK != null) {
            this.QSK.blg();
        }
        int i2 = this.ozo;
        AppMethodBeat.o(198397);
        return i2;
    }

    public final void bg(boolean z, boolean z2) {
        this.ozd = z2;
        this.ozc = z;
        this.ozb = true;
    }

    public void setLongTermYear(boolean z) {
        this.QSL = z;
    }

    public final void onShow() {
        AppMethodBeat.i(198398);
        if (this.QSL) {
            this.mmI++;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(this.mmI, this.mmJ - 1, this.mmK);
        Calendar instance2 = Calendar.getInstance();
        if (this.ozh == null) {
            this.ozh = new Date(instance.getTimeInMillis());
        }
        instance2.setTime(this.ozh);
        Calendar instance3 = Calendar.getInstance();
        if (this.ozi == null) {
            Calendar instance4 = Calendar.getInstance();
            instance4.set(this.mmI + 100, this.mmJ - 1, this.mmK);
            this.ozi = new Date(instance4.getTimeInMillis());
        }
        instance3.setTime(this.ozi);
        h hVar = this.QSK;
        boolean z = this.QSL;
        hVar.QTz = z;
        if (hVar.QTy != null) {
            hVar.QTy.QTL = z;
        }
        b bVar = new b(this.context, new g() {
            /* class com.tencent.mm.ui.widget.picker.CustomDatePickerNew.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.picker.d.g
            public final void a(Date date) {
                AppMethodBeat.i(198386);
                CustomDatePickerNew.a(CustomDatePickerNew.this, date);
                as.i("pvTime", "onTimeSelect", new Object[0]);
                AppMethodBeat.o(198386);
            }
        });
        bVar.QSH.QUB = new f() {
            /* class com.tencent.mm.ui.widget.picker.CustomDatePickerNew.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.picker.d.f
            public final void hce() {
                AppMethodBeat.i(198385);
                as.i("pvTime", "onTimeSelectChanged", new Object[0]);
                AppMethodBeat.o(198385);
            }
        };
        b b2 = bVar.hcv().c(new boolean[]{this.ozb, this.ozc, this.ozd, false, false, false}).b(instance).b(instance2, instance3);
        b2.QSH.kn = this.context.getResources().getDimensionPixelSize(R.dimen.ce);
        b2.c(this.QSK);
        this.QSK.setDividerHeight((float) this.context.getResources().getDimensionPixelSize(R.dimen.tv));
        this.context.getResources().getDimensionPixelSize(R.dimen.ce);
        h hVar2 = this.QSK;
        boolean z2 = this.QSL;
        if (hVar2.QTy != null) {
            j jVar = hVar2.QTy;
            jVar.QTL = z2;
            jVar.QTK.QUx = z2;
            jVar.QTE.setLongTermYear(z2);
            jVar.QTF.setLongTermMonthDay(z2);
            jVar.QTG.setLongTermMonthDay(z2);
        }
        this.QSK.QTy.setDividerColor(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1));
        this.QSK.dE(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
        int i2 = 0;
        for (WheelView wheelView : this.QSK.hcm()) {
            if (!this.QSL || this.mmI != 2 || i2 <= 0) {
                wheelView.aps(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_9)).apr(this.context.getResources().getDimensionPixelSize(R.dimen.cb)).setBackgroundColor(android.support.v4.content.b.n(this.context, R.color.f3048f));
            } else {
                wheelView.aps(0).apr(this.context.getResources().getDimensionPixelSize(R.dimen.cb)).setBackgroundColor(android.support.v4.content.b.n(this.context, R.color.f3048f));
            }
            i2++;
        }
        List<WheelView> hcm = this.QSK.hcm();
        if (hcm.size() == 1) {
            hcm.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(198398);
        } else if (hcm.size() == 2) {
            hcm.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            hcm.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(198398);
        } else {
            if (hcm.size() == 3) {
                hcm.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                hcm.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                hcm.get(2).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            }
            AppMethodBeat.o(198398);
        }
    }

    static /* synthetic */ void a(CustomDatePickerNew customDatePickerNew, Date date) {
        AppMethodBeat.i(198399);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        customDatePickerNew.ozm = instance.get(1);
        customDatePickerNew.ozn = instance.get(2) + 1;
        customDatePickerNew.ozo = instance.get(5);
        AppMethodBeat.o(198399);
    }
}
