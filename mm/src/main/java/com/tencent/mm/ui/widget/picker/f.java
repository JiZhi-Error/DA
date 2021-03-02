package com.tencent.mm.ui.widget.picker;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.as;

public final class f {
    public static void b(NumberPicker numberPicker, int i2) {
        AppMethodBeat.i(159574);
        int childCount = numberPicker.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = numberPicker.getChildAt(i3);
            if (childAt instanceof EditText) {
                Paint c2 = c(numberPicker);
                if (c2 != null) {
                    c2.setColor(i2);
                }
                ((EditText) childAt).setTextColor(i2);
                numberPicker.invalidate();
            }
        }
        AppMethodBeat.o(159574);
    }

    public static void a(NumberPicker numberPicker, Drawable drawable) {
        AppMethodBeat.i(159575);
        if (numberPicker != null) {
            try {
                new an(numberPicker, "mSelectionDivider").set(drawable);
            } catch (Exception e2) {
                AppMethodBeat.o(159575);
                return;
            }
        }
        AppMethodBeat.o(159575);
    }

    public static EditText b(NumberPicker numberPicker) {
        AppMethodBeat.i(159576);
        if (numberPicker == null) {
            AppMethodBeat.o(159576);
            return null;
        }
        try {
            EditText editText = (EditText) new an(numberPicker, "mInputText").get();
            AppMethodBeat.o(159576);
            return editText;
        } catch (IllegalAccessException e2) {
            as.printErrStackTrace("NumberPickerUtil", e2, "getInputText IllegalAccessException", new Object[0]);
            AppMethodBeat.o(159576);
            return null;
        } catch (NoSuchFieldException e3) {
            as.printErrStackTrace("NumberPickerUtil", e3, "getInputText NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(159576);
            return null;
        }
    }

    private static Paint c(NumberPicker numberPicker) {
        AppMethodBeat.i(159577);
        if (numberPicker == null) {
            AppMethodBeat.o(159577);
            return null;
        }
        try {
            Paint paint = (Paint) new an(numberPicker, "mSelectorWheelPaint").get();
            AppMethodBeat.o(159577);
            return paint;
        } catch (IllegalAccessException e2) {
            as.printErrStackTrace("NumberPickerUtil", e2, "getSelectorWheelPaint IllegalAccessException", new Object[0]);
            AppMethodBeat.o(159577);
            return null;
        } catch (NoSuchFieldException e3) {
            as.printErrStackTrace("NumberPickerUtil", e3, "getSelectorWheelPaint NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(159577);
            return null;
        }
    }

    public static void d(NumberPicker numberPicker) {
        AppMethodBeat.i(159578);
        if (numberPicker == null) {
            AppMethodBeat.o(159578);
            return;
        }
        numberPicker.setDescendantFocusability(393216);
        AppMethodBeat.o(159578);
    }

    public static void e(NumberPicker numberPicker) {
        AppMethodBeat.i(159579);
        if (numberPicker == null) {
            AppMethodBeat.o(159579);
            return;
        }
        try {
            EditText editText = (EditText) new an(numberPicker, "mInputText").get();
            if (editText != null) {
                editText.setFilters(new InputFilter[0]);
            }
            AppMethodBeat.o(159579);
        } catch (IllegalAccessException e2) {
            as.printErrStackTrace("NumberPickerUtil", e2, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
            AppMethodBeat.o(159579);
        } catch (NoSuchFieldException e3) {
            as.printErrStackTrace("NumberPickerUtil", e3, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(159579);
        }
    }

    public static void f(NumberPicker numberPicker) {
        AppMethodBeat.i(159580);
        if (numberPicker == null) {
            AppMethodBeat.o(159580);
            return;
        }
        try {
            Runnable runnable = (Runnable) new an(numberPicker, "mSetSelectionCommand").get();
            if (runnable != null) {
                numberPicker.removeCallbacks(runnable);
            }
            AppMethodBeat.o(159580);
        } catch (IllegalAccessException e2) {
            as.printErrStackTrace("NumberPickerUtil", e2, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
            AppMethodBeat.o(159580);
        } catch (NoSuchFieldException e3) {
            as.printErrStackTrace("NumberPickerUtil", e3, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(159580);
        }
    }
}
