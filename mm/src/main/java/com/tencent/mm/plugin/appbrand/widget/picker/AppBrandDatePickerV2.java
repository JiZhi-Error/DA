package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.picker.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AppBrandDatePickerV2 implements c<String> {
    private Context context;
    private View mView = null;
    private boolean ozc;
    private boolean ozd;
    public Date ozh;
    public Date ozi;
    private int ozm;
    private int ozn;
    private int ozo;
    private com.tencent.mm.picker.f.c pvTime;

    @Keep
    AppBrandDatePickerV2(Context context2) {
        AppMethodBeat.i(137986);
        this.context = context2;
        this.pvTime = new com.tencent.mm.picker.f.c(context2);
        AppMethodBeat.o(137986);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public View getView() {
        AppMethodBeat.i(137987);
        if (this.mView == null) {
            this.mView = this.pvTime.bli();
        }
        View view = this.mView;
        AppMethodBeat.o(137987);
        return view;
    }

    public final void a(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(137988);
        this.ozd = z3;
        this.ozc = z2;
        Calendar instance = Calendar.getInstance();
        instance.set(i2, i3 - 1, i4);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(this.ozh);
        Calendar instance3 = Calendar.getInstance();
        instance3.setTime(this.ozi);
        b bVar = new b(this.context, new e() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2.AnonymousClass2 */

            @Override // com.tencent.mm.picker.d.e
            public final void a(Date date) {
                AppMethodBeat.i(137985);
                AppBrandDatePickerV2.a(AppBrandDatePickerV2.this, date);
                AppMethodBeat.o(137985);
            }
        });
        bVar.jKP.jKT = new d() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2.AnonymousClass1 */
        };
        b a2 = bVar.bkZ().b(new boolean[]{z, z2, z3, false, false, false}).a(instance).a(instance2, instance3);
        a2.jKP.kn = this.context.getResources().getDimensionPixelSize(R.dimen.afs);
        a2.a(this.pvTime);
        this.pvTime.setDividerHeight((float) this.context.getResources().getDimensionPixelSize(R.dimen.tv));
        this.context.getResources().getDimensionPixelSize(R.dimen.afs);
        com.tencent.mm.picker.f.c cVar = this.pvTime;
        cVar.jLJ.setDividerColor(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1));
        this.pvTime.dE(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
        for (WheelView wheelView : this.pvTime.jLJ.bll()) {
            wheelView.uL(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_9)).uK(this.context.getResources().getDimensionPixelSize(R.dimen.cb)).setBackgroundColor(android.support.v4.content.b.n(this.context, R.color.f3048f));
        }
        List<WheelView> bll = this.pvTime.jLJ.bll();
        if (bll.size() == 1) {
            bll.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(137988);
        } else if (bll.size() == 2) {
            bll.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            bll.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(137988);
        } else {
            if (bll.size() == 3) {
                bll.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                bll.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                bll.get(2).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            }
            AppMethodBeat.o(137988);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onShow(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onHide(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onAttach(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onDetach(c cVar) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public /* synthetic */ String currentValue() {
        AppMethodBeat.i(137989);
        this.pvTime.blg();
        if (this.ozd) {
            String format = String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(this.ozm), Integer.valueOf(this.ozn), Integer.valueOf(this.ozo));
            AppMethodBeat.o(137989);
            return format;
        } else if (this.ozc) {
            String format2 = String.format(Locale.US, "%04d-%02d", Integer.valueOf(this.ozm), Integer.valueOf(this.ozn));
            AppMethodBeat.o(137989);
            return format2;
        } else {
            String format3 = String.format(Locale.US, "%04d", Integer.valueOf(this.ozm));
            AppMethodBeat.o(137989);
            return format3;
        }
    }

    static /* synthetic */ void a(AppBrandDatePickerV2 appBrandDatePickerV2, Date date) {
        AppMethodBeat.i(137990);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        appBrandDatePickerV2.ozm = instance.get(1);
        appBrandDatePickerV2.ozn = instance.get(2) + 1;
        appBrandDatePickerV2.ozo = instance.get(5);
        AppMethodBeat.o(137990);
    }
}
