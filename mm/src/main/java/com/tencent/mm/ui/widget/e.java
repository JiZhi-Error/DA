package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends DatePickerDialog {
    private boolean QCB;
    private long QCC;
    private int QCD;

    public e(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4, long j2) {
        super(context, 3, onDateSetListener, i2, i3, i4);
        this.QCB = true;
        this.QCB = true;
        this.QCC = j2;
        this.QCD = 1;
    }

    public e(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4, long j2, byte b2) {
        super(context, 3, onDateSetListener, i2, i3, i4);
        this.QCB = true;
        this.QCB = true;
        this.QCC = j2;
        this.QCD = 1;
    }

    class a {
        a() {
        }

        @TargetApi(11)
        public final NumberPicker Q(ViewGroup viewGroup) {
            NumberPicker Q;
            AppMethodBeat.i(143340);
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof NumberPicker) {
                        NumberPicker numberPicker = (NumberPicker) childAt;
                        if (numberPicker.getMaxValue() >= 28 && numberPicker.getMaxValue() <= 31) {
                            AppMethodBeat.o(143340);
                            return numberPicker;
                        }
                    }
                    if ((childAt instanceof ViewGroup) && (Q = Q((ViewGroup) childAt)) != null) {
                        AppMethodBeat.o(143340);
                        return Q;
                    }
                }
            }
            AppMethodBeat.o(143340);
            return null;
        }
    }

    class b {
        b() {
        }

        public final View o(ViewGroup viewGroup, int i2) {
            View o;
            AppMethodBeat.i(143341);
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    Class<?> cls = childAt.getClass();
                    Log.d("MicroMsg.MMDatePickerDialog", "NAME = ".concat(String.valueOf(cls.getName())));
                    Log.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + cls.getSimpleName());
                    if ("NumberPicker".equals(cls.getSimpleName()) && i3 == i2) {
                        AppMethodBeat.o(143341);
                        return childAt;
                    } else if ((childAt instanceof ViewGroup) && (o = o((ViewGroup) childAt, i2)) != null) {
                        AppMethodBeat.o(143341);
                        return o;
                    }
                }
            }
            AppMethodBeat.o(143341);
            return null;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public final void show() {
        View o;
        int i2 = 1;
        AppMethodBeat.i(143342);
        super.show();
        if (this.QCB) {
            if (Build.VERSION.SDK_INT >= 11) {
                NumberPicker Q = new a().Q((ViewGroup) getWindow().getDecorView());
                if (Q != null && this.QCD > 1) {
                    Q.setVisibility(8);
                }
            } else {
                String string = Settings.System.getString(getContext().getContentResolver(), "date_format");
                if (string != null) {
                    string = string.toLowerCase();
                }
                if ("dd/mm/yyyy".equals(string) || "dd-mm-yyyy".equals(string)) {
                    i2 = 0;
                } else if (!"mm/dd/yyyy".equals(string) && !"mm-dd-yyyy".equals(string)) {
                    i2 = ("yyyy/mm/dd".equals(string) || "yyyy-mm-dd".equals(string)) ? 2 : -1;
                }
                if (!(i2 == -1 || (o = new b().o((ViewGroup) getWindow().getDecorView(), i2)) == null)) {
                    o.setVisibility(8);
                }
            }
            int year = getDatePicker().getYear();
            int month = getDatePicker().getMonth();
            getDatePicker().getDayOfMonth();
            lw(year, month);
        }
        this.QCB = false;
        AppMethodBeat.o(143342);
    }

    public final void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
        AppMethodBeat.i(143343);
        super.onDateChanged(datePicker, i2, i3, i4);
        lw(i2, i3);
        AppMethodBeat.o(143343);
    }

    private void lw(int i2, int i3) {
        AppMethodBeat.i(143344);
        if (this.QCD > 1) {
            setTitle(getContext().getString(R.string.dgn, Integer.valueOf(i2), Integer.valueOf(i3 + 1)));
        }
        AppMethodBeat.o(143344);
    }

    public final void Oa(long j2) {
        AppMethodBeat.i(143345);
        getDatePicker().setMaxDate(j2);
        AppMethodBeat.o(143345);
    }

    public final void Ob(long j2) {
        AppMethodBeat.i(143346);
        getDatePicker().setMinDate(j2);
        AppMethodBeat.o(143346);
    }
}
