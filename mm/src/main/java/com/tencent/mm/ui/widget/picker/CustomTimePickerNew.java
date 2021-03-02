package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.ui.widget.picker.d.g;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomTimePickerNew extends FrameLayout {
    h QSK;
    private Context context;
    int currentHour;
    int currentMinute;
    public int mMaxTimeHour = -1;
    public int mMaxTimeMinute = -1;
    public int mMinTimeHour = -1;
    public int mMinTimeMinute = -1;
    private View mView = null;
    public int mnn = -1;
    public int mno = -1;

    public CustomTimePickerNew(Context context2) {
        super(new ContextThemeWrapper(context2, (int) R.style.a4y));
        AppMethodBeat.i(198414);
        this.context = context2;
        this.QSK = new h(context2);
        AppMethodBeat.o(198414);
    }

    public CustomTimePickerNew(Context context2, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context2, (int) R.style.a4y), attributeSet);
        AppMethodBeat.i(198415);
        this.context = context2;
        this.QSK = new h(context2);
        AppMethodBeat.o(198415);
    }

    public CustomTimePickerNew(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(198416);
        this.context = context2;
        this.QSK = new h(context2);
        AppMethodBeat.o(198416);
    }

    public View getView() {
        AppMethodBeat.i(198417);
        if (this.mView == null) {
            this.mView = this.QSK.bli();
        }
        View view = this.mView;
        AppMethodBeat.o(198417);
        return view;
    }

    public final void onShow() {
        AppMethodBeat.i(198418);
        Calendar instance = Calendar.getInstance();
        instance.set(11, this.mnn);
        instance.set(12, this.mno);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(11, this.mMinTimeHour);
        instance2.set(12, this.mMinTimeMinute);
        Calendar instance3 = Calendar.getInstance();
        instance3.set(11, this.mMaxTimeHour);
        instance3.set(12, this.mMaxTimeMinute);
        b hcv = new b(this.context, new g() {
            /* class com.tencent.mm.ui.widget.picker.CustomTimePickerNew.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.picker.d.g
            public final void a(Date date) {
                AppMethodBeat.i(198413);
                CustomTimePickerNew.a(CustomTimePickerNew.this, date);
                AppMethodBeat.o(198413);
            }
        }).c(new boolean[]{false, false, false, true, true, false}).b(instance).b(instance2, instance3).hcv();
        hcv.QSH.jKu = android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1);
        hcv.c(this.QSK);
        this.QSK.setDividerHeight((float) this.context.getResources().getDimensionPixelSize(R.dimen.tv));
        this.context.getResources().getDimensionPixelSize(R.dimen.ce);
        this.QSK.dE(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
        for (WheelView wheelView : this.QSK.QTy.bll()) {
            wheelView.aps(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_9)).apr(this.context.getResources().getDimensionPixelSize(R.dimen.cb)).setBackgroundColor(android.support.v4.content.b.n(this.context, R.color.f3048f));
        }
        List<WheelView> bll = this.QSK.QTy.bll();
        if (bll.size() == 1) {
            bll.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(198418);
        } else if (bll.size() == 2) {
            bll.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            bll.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(198418);
        } else {
            if (bll.size() == 3) {
                bll.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                bll.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
                bll.get(2).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bt), this.context.getResources().getDimensionPixelSize(R.dimen.cb), 0, this.context.getResources().getDimensionPixelSize(R.dimen.cb));
            }
            AppMethodBeat.o(198418);
        }
    }

    static /* synthetic */ void a(CustomTimePickerNew customTimePickerNew, Date date) {
        AppMethodBeat.i(198419);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        customTimePickerNew.currentHour = instance.get(11);
        customTimePickerNew.currentMinute = instance.get(12);
        AppMethodBeat.o(198419);
    }
}
