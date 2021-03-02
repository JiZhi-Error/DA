package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.picker.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AppBrandTimePickerV2 implements c<String> {
    private Context context;
    private int currentHour;
    private int currentMinute;
    private int mMaxTimeHour = -1;
    private int mMaxTimeMinute = -1;
    private int mMinTimeHour = -1;
    private int mMinTimeMinute = -1;
    private View mView;
    private com.tencent.mm.picker.f.c pvTime;

    static /* synthetic */ void access$000(AppBrandTimePickerV2 appBrandTimePickerV2, Date date) {
        AppMethodBeat.i(138083);
        appBrandTimePickerV2.getTimeString(date);
        AppMethodBeat.o(138083);
    }

    @Keep
    AppBrandTimePickerV2(Context context2) {
        AppMethodBeat.i(138076);
        this.pvTime = new com.tencent.mm.picker.f.c(context2);
        this.context = context2;
        AppMethodBeat.o(138076);
    }

    public void init(int i2, int i3) {
        AppMethodBeat.i(138077);
        Calendar instance = Calendar.getInstance();
        instance.set(11, i2);
        instance.set(12, i3);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(11, this.mMinTimeHour);
        instance2.set(12, this.mMinTimeMinute);
        Calendar instance3 = Calendar.getInstance();
        instance3.set(11, this.mMaxTimeHour);
        instance3.set(12, this.mMaxTimeMinute);
        b bkZ = new b(this.context, new e() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePickerV2.AnonymousClass1 */

            @Override // com.tencent.mm.picker.d.e
            public final void a(Date date) {
                AppMethodBeat.i(138075);
                AppBrandTimePickerV2.access$000(AppBrandTimePickerV2.this, date);
                AppMethodBeat.o(138075);
            }
        }).b(new boolean[]{false, false, false, true, true, false}).a(instance).a(instance2, instance3).bkZ();
        bkZ.jKP.jKu = android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1);
        bkZ.a(this.pvTime);
        this.pvTime.setDividerHeight((float) this.context.getResources().getDimensionPixelSize(R.dimen.tv));
        this.context.getResources().getDimensionPixelSize(R.dimen.afs);
        this.pvTime.dE(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
        for (WheelView wheelView : this.pvTime.jLJ.bll()) {
            wheelView.uL(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_9)).uK(this.context.getResources().getDimensionPixelSize(R.dimen.cb)).setBackgroundColor(android.support.v4.content.b.n(this.context, R.color.f3048f));
        }
        configPadding(this.pvTime.jLJ.bll());
        AppMethodBeat.o(138077);
    }

    private void configPadding(List<WheelView> list) {
        AppMethodBeat.i(138078);
        if (list.size() == 1) {
            list.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(138078);
        } else if (list.size() == 2) {
            list.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            list.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(138078);
        } else {
            if (list.size() == 3) {
                list.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                list.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                list.get(2).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            }
            AppMethodBeat.o(138078);
        }
    }

    public void setMinTime(int i2, int i3) {
        this.mMinTimeHour = i2;
        this.mMinTimeMinute = i3;
    }

    public void setMaxTime(int i2, int i3) {
        this.mMaxTimeHour = i2;
        this.mMaxTimeMinute = i3;
    }

    private void getTimeString(Date date) {
        AppMethodBeat.i(138079);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        this.currentHour = instance.get(11);
        this.currentMinute = instance.get(12);
        AppMethodBeat.o(138079);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public String currentValue() {
        AppMethodBeat.i(138080);
        this.pvTime.blg();
        String format = String.format(Locale.US, "%02d:%02d", Integer.valueOf(this.currentHour), Integer.valueOf(this.currentMinute));
        AppMethodBeat.o(138080);
        return format;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public View getView() {
        AppMethodBeat.i(138081);
        if (this.mView == null) {
            this.mView = this.pvTime.bli();
        }
        View view = this.mView;
        AppMethodBeat.o(138081);
        return view;
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

    public boolean isNewPicker() {
        return true;
    }
}
