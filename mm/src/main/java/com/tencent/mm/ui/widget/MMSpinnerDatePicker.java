package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker extends DatePicker implements DatePicker.OnDateChangedListener {
    private NumberPicker QDf;
    private NumberPicker QDg;
    private NumberPicker QDh;
    private a QDi;
    private int QDj = 0;

    public interface a {
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143397);
        init();
        AppMethodBeat.o(143397);
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143398);
        init();
        AppMethodBeat.o(143398);
    }

    private void init() {
        AppMethodBeat.i(143399);
        setCalendarViewShown(false);
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("year", "id", "android");
        int identifier2 = system.getIdentifier("month", "id", "android");
        int identifier3 = system.getIdentifier("day", "id", "android");
        this.QDf = (NumberPicker) findViewById(identifier);
        this.QDg = (NumberPicker) findViewById(identifier2);
        this.QDh = (NumberPicker) findViewById(identifier3);
        View childAt = getChildAt(0);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        layoutParams.width = -1;
        childAt.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.QDf.getLayoutParams();
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        layoutParams2.weight = 1.0f;
        this.QDf.setLayoutParams(layoutParams2);
        this.QDg.setLayoutParams(layoutParams2);
        this.QDh.setLayoutParams(layoutParams2);
        setDescendantFocusability(393216);
        setPickerMode(2);
        AppMethodBeat.o(143399);
    }

    public void setPickerMode(int i2) {
        AppMethodBeat.i(143400);
        this.QDj = i2;
        if (this.QDj == 0) {
            this.QDf.setVisibility(0);
            this.QDg.setVisibility(0);
            this.QDh.setVisibility(0);
            AppMethodBeat.o(143400);
        } else if (this.QDj == 1) {
            this.QDf.setVisibility(0);
            this.QDg.setVisibility(0);
            this.QDh.setVisibility(8);
            AppMethodBeat.o(143400);
        } else {
            this.QDf.setVisibility(0);
            this.QDg.setVisibility(8);
            this.QDh.setVisibility(8);
            AppMethodBeat.o(143400);
        }
    }

    public int getPickerMode() {
        return this.QDj;
    }

    public void setOnDateChangeListener(a aVar) {
        this.QDi = aVar;
    }

    public void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
    }

    public final boolean gYR() {
        AppMethodBeat.i(143401);
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(getResources().getColor(R.color.ac_));
            declaredField.set(this.QDf, colorDrawable);
            declaredField.set(this.QDg, colorDrawable);
            declaredField.set(this.QDh, colorDrawable);
            invalidate();
            AppMethodBeat.o(143401);
            return true;
        } catch (IllegalAccessException e2) {
            Log.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            AppMethodBeat.o(143401);
            return false;
        } catch (NoSuchFieldException e3) {
            Log.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e3, "", new Object[0]);
            AppMethodBeat.o(143401);
            return false;
        }
    }

    public void setTextSize(int i2) {
        AppMethodBeat.i(143402);
        a(this.QDf, i2);
        a(this.QDg, i2);
        a(this.QDh, i2);
        AppMethodBeat.o(143402);
    }

    private void a(NumberPicker numberPicker, int i2) {
        AppMethodBeat.i(143403);
        if (numberPicker == null) {
            AppMethodBeat.o(143403);
            return;
        }
        EditText editText = (EditText) numberPicker.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", "id", "android"));
        editText.setTextSize(0, getResources().getDimension(i2));
        int textSize = (int) editText.getTextSize();
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mTextSize");
            declaredField.setAccessible(true);
            declaredField.set(numberPicker, Integer.valueOf(textSize));
            Field declaredField2 = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
            declaredField2.setAccessible(true);
            Paint paint = (Paint) declaredField2.get(numberPicker);
            paint.setTextSize((float) textSize);
            declaredField2.set(numberPicker, paint);
            AppMethodBeat.o(143403);
        } catch (NoSuchFieldException e2) {
            Log.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            AppMethodBeat.o(143403);
        } catch (IllegalAccessException e3) {
            Log.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e3, "", new Object[0]);
            AppMethodBeat.o(143403);
        }
    }
}
