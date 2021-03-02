package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView extends LinearLayout implements View.OnClickListener {
    private CollectRadioBtnView qCh;
    private CollectRadioBtnView qCi;
    private CollectRadioBtnView qCj;
    private MMSpinnerDatePicker qCk;
    private TextView qCl;
    private TextView qCm;
    private int qCn = 0;

    public DatePickerDialogView(Context context) {
        super(context);
        AppMethodBeat.i(64198);
        init(context);
        AppMethodBeat.o(64198);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(64199);
        init(context);
        AppMethodBeat.o(64199);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(64200);
        init(context);
        AppMethodBeat.o(64200);
    }

    private void init(Context context) {
        AppMethodBeat.i(64201);
        View inflate = aa.jQ(context).inflate(R.layout.uw, this);
        this.qCh = (CollectRadioBtnView) inflate.findViewById(R.id.jsm);
        this.qCi = (CollectRadioBtnView) inflate.findViewById(R.id.fjm);
        this.qCj = (CollectRadioBtnView) inflate.findViewById(R.id.bks);
        this.qCl = (TextView) inflate.findViewById(R.id.b_4);
        this.qCm = (TextView) inflate.findViewById(R.id.aib);
        this.qCh.setOnClickListener(this);
        this.qCi.setOnClickListener(this);
        this.qCj.setOnClickListener(this);
        this.qCh.setTitleText("年");
        this.qCi.setTitleText("月");
        this.qCj.setTitleText("日");
        this.qCk = (MMSpinnerDatePicker) inflate.findViewById(R.id.bkq);
        this.qCk.gYR();
        this.qCk.setTextSize(R.dimen.is);
        AppMethodBeat.o(64201);
    }

    public void onClick(View view) {
        AppMethodBeat.i(64202);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        int id = view.getId();
        if (id == R.id.jsm) {
            this.qCn = 2;
        } else if (id == R.id.fjm) {
            this.qCn = 1;
        } else if (id == R.id.bks) {
            this.qCn = 0;
        } else {
            Log.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", view.getClass().toString());
        }
        cAH();
        a.a(this, "com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64202);
    }

    private void cAH() {
        AppMethodBeat.i(64203);
        if (this.qCn == 2) {
            this.qCh.setRadioSrc(R.raw.radio_on);
            this.qCi.setRadioSrc(R.raw.radio_off);
            this.qCj.setRadioSrc(R.raw.radio_off);
        } else if (this.qCn == 1) {
            this.qCh.setRadioSrc(R.raw.radio_off);
            this.qCi.setRadioSrc(R.raw.radio_on);
            this.qCj.setRadioSrc(R.raw.radio_off);
        } else {
            this.qCh.setRadioSrc(R.raw.radio_off);
            this.qCi.setRadioSrc(R.raw.radio_off);
            this.qCj.setRadioSrc(R.raw.radio_on);
        }
        this.qCk.setPickerMode(this.qCn);
        AppMethodBeat.o(64203);
    }

    public void setDatePickerMode(int i2) {
        AppMethodBeat.i(64204);
        this.qCn = i2;
        cAH();
        AppMethodBeat.o(64204);
    }

    public void setOnOkBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(64205);
        this.qCl.setOnClickListener(onClickListener);
        AppMethodBeat.o(64205);
    }

    public void setOnCancelBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(64206);
        this.qCm.setOnClickListener(onClickListener);
        AppMethodBeat.o(64206);
    }

    public int getYear() {
        AppMethodBeat.i(64207);
        int year = this.qCk.getYear();
        AppMethodBeat.o(64207);
        return year;
    }

    public int getMonth() {
        AppMethodBeat.i(64208);
        int month = this.qCk.getMonth();
        AppMethodBeat.o(64208);
        return month;
    }

    public int getDayOfMonth() {
        AppMethodBeat.i(64209);
        int dayOfMonth = this.qCk.getDayOfMonth();
        AppMethodBeat.o(64209);
        return dayOfMonth;
    }

    public int getDatePickerMode() {
        AppMethodBeat.i(64210);
        int pickerMode = this.qCk.getPickerMode();
        AppMethodBeat.o(64210);
        return pickerMode;
    }
}
