package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Constructor;

public class a {
    private static Constructor<StaticLayout> huZ;
    private static Object hva;

    @TargetApi(18)
    private static synchronized Object aBt() {
        Object obj;
        synchronized (a.class) {
            AppMethodBeat.i(196224);
            if (hva != null) {
                obj = hva;
                AppMethodBeat.o(196224);
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 18) {
                        hva = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    } else {
                        Class<?> loadClass = a.class.getClassLoader().loadClass("android.text.TextDirectionHeuristics");
                        hva = loadClass.getField("FIRSTSTRONG_LTR").get(loadClass);
                    }
                    obj = hva;
                    AppMethodBeat.o(196224);
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", e, "TextDirectionHeuristic class not found.", new Object[0]);
                    Log.w("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                    RuntimeException runtimeException = new RuntimeException(e);
                    AppMethodBeat.o(196224);
                    throw runtimeException;
                } catch (NoSuchFieldException e3) {
                    e = e3;
                    Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", e, "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", new Object[0]);
                    Log.w("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                    RuntimeException runtimeException2 = new RuntimeException(e);
                    AppMethodBeat.o(196224);
                    throw runtimeException2;
                } catch (IllegalAccessException e4) {
                    e = e4;
                    Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", e, "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", new Object[0]);
                    Log.w("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                    RuntimeException runtimeException22 = new RuntimeException(e);
                    AppMethodBeat.o(196224);
                    throw runtimeException22;
                } catch (Throwable th) {
                    e = th;
                    Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", e, "Other error.", new Object[0]);
                    Log.w("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                    RuntimeException runtimeException222 = new RuntimeException(e);
                    AppMethodBeat.o(196224);
                    throw runtimeException222;
                }
            }
        }
        return obj;
    }

    @TargetApi(18)
    private static synchronized Constructor<StaticLayout> aBu() {
        Class<?> loadClass;
        Constructor<StaticLayout> constructor = null;
        boolean z = true;
        synchronized (a.class) {
            AppMethodBeat.i(196225);
            if (huZ != null) {
                constructor = huZ;
                AppMethodBeat.o(196225);
            } else {
                if (Build.VERSION.SDK_INT < 29) {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(196225);
                } else {
                    try {
                        if (Build.VERSION.SDK_INT >= 18) {
                            loadClass = TextDirectionHeuristic.class;
                        } else {
                            loadClass = a.class.getClassLoader().loadClass("android.text.TextDirectionHeuristic");
                        }
                        Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, loadClass, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
                        huZ = declaredConstructor;
                        declaredConstructor.setAccessible(true);
                        e = null;
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", e, "StaticLayout constructor with max lines not found.", new Object[0]);
                    } catch (ClassNotFoundException e3) {
                        e = e3;
                        Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", e, "TextDirectionHeuristic class not found.", new Object[0]);
                    } catch (Throwable th) {
                        e = th;
                        Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", e, "Other error.", new Object[0]);
                    }
                    if (e != null) {
                        Log.w("StaticTextView.StaticLayoutWithMaxLines", "create StaticLayout constructor fail: " + e.getMessage());
                        Log.w("StaticTextView.StaticLayoutWithMaxLines", "use builtin StaticLayout.Builder as fallback!");
                        AppMethodBeat.o(196225);
                    } else {
                        constructor = huZ;
                        AppMethodBeat.o(196225);
                    }
                }
            }
        }
        return constructor;
    }

    private static StaticLayout a(CharSequence charSequence, int i2, int i3, TextPaint textPaint, int i4, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f2, float f3, boolean z, TextUtils.TruncateAt truncateAt, int i5, int i6) {
        AppMethodBeat.i(196226);
        StaticLayout build = StaticLayout.Builder.obtain(charSequence, i2, i3, textPaint, i4).setAlignment(alignment).setTextDirection(textDirectionHeuristic).setLineSpacing(f3, f2).setIncludePad(z).setEllipsizedWidth(i5).setEllipsize(truncateAt).setMaxLines(i6).build();
        AppMethodBeat.o(196226);
        return build;
    }

    @SuppressLint({"NewApi"})
    public static synchronized StaticLayout a(CharSequence charSequence, int i2, int i3, TextPaint textPaint, int i4, Layout.Alignment alignment, float f2, float f3, boolean z, TextUtils.TruncateAt truncateAt, int i5, int i6) {
        StaticLayout newInstance;
        synchronized (a.class) {
            AppMethodBeat.i(141138);
            try {
                Object aBt = aBt();
                Constructor<StaticLayout> aBu = aBu();
                if (aBu == null) {
                    newInstance = a(charSequence, i2, i3, textPaint, i4, alignment, (TextDirectionHeuristic) aBt, f2, f3, z, truncateAt, i5, i6);
                    AppMethodBeat.o(141138);
                } else {
                    newInstance = aBu.newInstance(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), textPaint, Integer.valueOf(i4), alignment, aBt, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), truncateAt, Integer.valueOf(i5), Integer.valueOf(i6));
                    AppMethodBeat.o(141138);
                }
            } catch (Exception e2) {
                IllegalStateException illegalStateException = new IllegalStateException("Error creating StaticLayout with max lines: " + e2.getCause());
                AppMethodBeat.o(141138);
                throw illegalStateException;
            }
        }
        return newInstance;
    }

    @SuppressLint({"NewApi"})
    public static synchronized StaticLayout b(CharSequence charSequence, int i2, int i3, TextPaint textPaint, int i4, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f2, float f3, boolean z, TextUtils.TruncateAt truncateAt, int i5, int i6) {
        StaticLayout newInstance;
        synchronized (a.class) {
            AppMethodBeat.i(141139);
            try {
                Object aBt = aBt();
                Constructor<StaticLayout> aBu = aBu();
                if (aBu == null) {
                    newInstance = a(charSequence, i2, i3, textPaint, i4, alignment, (TextDirectionHeuristic) aBt, f2, f3, z, truncateAt, i5, i6);
                    AppMethodBeat.o(141139);
                } else {
                    newInstance = aBu.newInstance(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), textPaint, Integer.valueOf(i4), alignment, textDirectionHeuristic, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), truncateAt, Integer.valueOf(i5), Integer.valueOf(i6));
                    AppMethodBeat.o(141139);
                }
            } catch (Exception e2) {
                IllegalStateException illegalStateException = new IllegalStateException("Error creating StaticLayout with max lines: " + e2.getCause());
                AppMethodBeat.o(141139);
                throw illegalStateException;
            }
        }
        return newInstance;
    }
}
