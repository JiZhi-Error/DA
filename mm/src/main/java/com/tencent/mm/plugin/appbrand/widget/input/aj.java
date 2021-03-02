package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;
import java.util.Locale;

public enum aj {
    ;
    
    static final Class ovu;

    static {
        AppMethodBeat.i(136598);
        Class<?> cls = null;
        try {
            cls = Class.forName("android.view.inputmethod.ComposingText");
        } catch (ClassNotFoundException e2) {
            Log.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", e2);
        }
        ovu = cls;
        AppMethodBeat.o(136598);
    }

    public static aj valueOf(String str) {
        AppMethodBeat.i(136589);
        aj ajVar = (aj) Enum.valueOf(aj.class, str);
        AppMethodBeat.o(136589);
        return ajVar;
    }

    static Spannable H(CharSequence charSequence) {
        CharSequence charSequence2;
        AppMethodBeat.i(136590);
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2 instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence2;
            AppMethodBeat.o(136590);
            return spannable;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2);
        AppMethodBeat.o(136590);
        return spannableStringBuilder;
    }

    public static boolean I(CharSequence charSequence) {
        AppMethodBeat.i(136591);
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Object[] spans = spanned.getSpans(0, spanned.length(), ovu);
            if (spans == null || spans.length <= 0) {
                AppMethodBeat.o(136591);
                return false;
            }
            AppMethodBeat.o(136591);
            return true;
        }
        AppMethodBeat.o(136591);
        return false;
    }

    static boolean cX(Object obj) {
        AppMethodBeat.i(136592);
        boolean isInstance = ovu.isInstance(obj);
        AppMethodBeat.o(136592);
        return isInstance;
    }

    public static InputMethodManager dg(View view) {
        Context context;
        AppMethodBeat.i(136593);
        if (view == null || (context = view.getContext()) == null) {
            context = MMApplicationContext.getContext();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        AppMethodBeat.o(136593);
        return inputMethodManager;
    }

    public static void dh(View view) {
        String format;
        AppMethodBeat.i(136594);
        if (Build.VERSION.SDK_INT >= 30) {
            Log.w("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo skip >=30");
            AppMethodBeat.o(136594);
            return;
        }
        InputMethodManager dg = dg(view);
        if (dg == null) {
            format = "NULL Imm";
        } else {
            try {
                format = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", (View) org.a.a.gG(dg).get("mServedView"), (View) org.a.a.gG(dg).get("mNextServedView"));
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo reflect failed %s", e2);
                AppMethodBeat.o(136594);
                return;
            }
        }
        Log.i("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", format);
        AppMethodBeat.o(136594);
    }

    public static boolean i(View view, View view2) {
        AppMethodBeat.i(136595);
        if (view == null || view2 == null) {
            AppMethodBeat.o(136595);
            return false;
        }
        ViewParent parent = view2.getParent();
        while (view != parent) {
            parent = parent.getParent();
            if (parent == null) {
                AppMethodBeat.o(136595);
                return false;
            }
        }
        AppMethodBeat.o(136595);
        return true;
    }

    public static boolean i(Boolean bool) {
        AppMethodBeat.i(136596);
        if (bool == null || !bool.booleanValue()) {
            AppMethodBeat.o(136596);
            return false;
        }
        AppMethodBeat.o(136596);
        return true;
    }

    static int j(Integer num) {
        AppMethodBeat.i(136597);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(136597);
            return intValue;
        }
        AppMethodBeat.o(136597);
        return 0;
    }

    enum a {
        ;

        public static a valueOf(String str) {
            AppMethodBeat.i(136584);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(136584);
            return aVar;
        }

        static void c(EditText editText) {
            AppMethodBeat.i(136585);
            if (editText == null) {
                AppMethodBeat.o(136585);
                return;
            }
            aj.dg(editText).hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
            AppMethodBeat.o(136585);
        }

        static void setNoSystemInputOnEditText(EditText editText) {
            AppMethodBeat.i(136586);
            if (editText == null) {
                AppMethodBeat.o(136586);
            } else if (Build.VERSION.SDK_INT >= 21) {
                editText.setShowSoftInputOnFocus(false);
                AppMethodBeat.o(136586);
            } else {
                try {
                    Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(editText, Boolean.FALSE);
                    method.setAccessible(false);
                    AppMethodBeat.o(136586);
                } catch (NoSuchMethodException e2) {
                    Log.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(Build.VERSION.SDK_INT));
                    try {
                        Method method2 = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
                        method2.setAccessible(true);
                        method2.invoke(editText, Boolean.FALSE);
                        method2.setAccessible(false);
                        AppMethodBeat.o(136586);
                    } catch (Exception e3) {
                        Log.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", Util.stackTraceToString(e3));
                        if (editText.getContext() != null && (editText.getContext() instanceof ad)) {
                            ((ad) editText.getContext()).hideVKB(editText);
                        }
                        AppMethodBeat.o(136586);
                    }
                } catch (Exception e4) {
                    Log.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", Util.stackTraceToString(e4));
                    AppMethodBeat.o(136586);
                }
            }
        }

        static int a(EditText editText, float f2, float f3) {
            int i2;
            AppMethodBeat.i(136587);
            int paddingTop = editText.getPaddingTop();
            Layout layout = editText.getLayout();
            if (layout == null) {
                AppMethodBeat.o(136587);
                return -1;
            }
            Editable editableText = editText.getEditableText();
            if (editableText == null) {
                AppMethodBeat.o(136587);
                return -1;
            }
            TextPaint paint = editText.getPaint();
            if (paint == null) {
                AppMethodBeat.o(136587);
                return -1;
            }
            Rect rect = new Rect();
            for (int i3 = 0; i3 < layout.getLineCount(); i3++) {
                layout.getLineBounds(i3, rect);
                paddingTop += rect.height();
                if (((float) paddingTop) >= f3) {
                    int lineStart = layout.getLineStart(i3);
                    int lineEnd = layout.getLineEnd(i3);
                    if (i3 != layout.getLineCount() - 1) {
                        i2 = Math.max(lineEnd - 1, lineStart);
                    } else {
                        i2 = lineEnd;
                    }
                    if (lineStart == i2) {
                        AppMethodBeat.o(136587);
                        return lineStart;
                    }
                    RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) editableText.getSpans(lineStart, i2, RelativeSizeSpan.class);
                    float f4 = 1.0f;
                    if (relativeSizeSpanArr != null) {
                        for (RelativeSizeSpan relativeSizeSpan : relativeSizeSpanArr) {
                            f4 = relativeSizeSpan.getSizeChange();
                        }
                    }
                    String charSequence = editableText.subSequence(lineStart, i2).toString();
                    float[] fArr = new float[charSequence.length()];
                    paint.getTextWidths(charSequence, fArr);
                    float f5 = 0.0f;
                    for (int i4 = 0; i4 < charSequence.length(); i4++) {
                        f5 += fArr[i4] * f4;
                        if (i4 == charSequence.length() - 1 && f2 >= f5) {
                            int length = charSequence.length() + lineStart;
                            AppMethodBeat.o(136587);
                            return length;
                        } else if (f5 >= f2 || i4 == charSequence.length() - 1) {
                            int i5 = lineStart + i4;
                            AppMethodBeat.o(136587);
                            return i5;
                        }
                    }
                    continue;
                }
            }
            AppMethodBeat.o(136587);
            return -1;
        }
    }
}
