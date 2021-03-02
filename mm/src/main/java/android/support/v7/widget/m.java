package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.a.a;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class m {
    private static final RectF alw = new RectF();
    private static ConcurrentHashMap<String, Method> alx = new ConcurrentHashMap<>();
    private final TextView Ws;
    float alA = -1.0f;
    float alB = -1.0f;
    float alC = -1.0f;
    int[] alD = new int[0];
    private boolean alE = false;
    private TextPaint alF;
    int aly = 0;
    private boolean alz = false;
    private final Context mContext;

    m(TextView textView) {
        this.Ws = textView;
        this.mContext = this.Ws.getContext();
    }

    /* access modifiers changed from: package-private */
    public final void a(AttributeSet attributeSet, int i2) {
        float f2;
        float f3;
        float f4;
        int resourceId;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.C0040a.AppCompatTextView, i2, 0);
        if (obtainStyledAttributes.hasValue(5)) {
            this.aly = obtainStyledAttributes.getInt(5, 0);
        }
        if (obtainStyledAttributes.hasValue(4)) {
            f2 = obtainStyledAttributes.getDimension(4, -1.0f);
        } else {
            f2 = -1.0f;
        }
        if (obtainStyledAttributes.hasValue(2)) {
            f3 = obtainStyledAttributes.getDimension(2, -1.0f);
        } else {
            f3 = -1.0f;
        }
        if (obtainStyledAttributes.hasValue(1)) {
            f4 = obtainStyledAttributes.getDimension(1, -1.0f);
        } else {
            f4 = -1.0f;
        }
        if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            b(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!jw()) {
            this.aly = 0;
        } else if (this.aly == 1) {
            if (!this.alE) {
                DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                if (f3 == -1.0f) {
                    f3 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f4 == -1.0f) {
                    f4 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f2 == -1.0f) {
                    f2 = 1.0f;
                }
                g(f3, f4, f2);
            }
            js();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setAutoSizeTextTypeWithDefaults(int i2) {
        if (jw()) {
            switch (i2) {
                case 0:
                    ju();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    g(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (js()) {
                        jt();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (jw()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            g(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (js()) {
                jt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (jw()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                this.alD = i(iArr2);
                if (!jr()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.alE = false;
            }
            if (js()) {
                jt();
            }
        }
    }

    private void b(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.alD = i(iArr);
            jr();
        }
    }

    private boolean jr() {
        int length = this.alD.length;
        this.alE = length > 0;
        if (this.alE) {
            this.aly = 1;
            this.alB = (float) this.alD[0];
            this.alC = (float) this.alD[length - 1];
            this.alA = -1.0f;
        }
        return this.alE;
    }

    private static int[] i(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                iArr = new int[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
                }
            }
        }
        return iArr;
    }

    private void g(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        } else {
            this.aly = 1;
            this.alB = f2;
            this.alC = f3;
            this.alA = f4;
            this.alE = false;
        }
    }

    private boolean js() {
        if (!jw() || this.aly != 1) {
            this.alz = false;
        } else {
            if (!this.alE || this.alD.length == 0) {
                float round = (float) Math.round(this.alB);
                int i2 = 1;
                while (Math.round(this.alA + round) <= Math.round(this.alC)) {
                    i2++;
                    round += this.alA;
                }
                int[] iArr = new int[i2];
                float f2 = this.alB;
                int i3 = 0;
                while (i3 < i2) {
                    iArr[i3] = Math.round(f2);
                    i3++;
                    f2 = this.alA + f2;
                }
                this.alD = i(iArr);
            }
            this.alz = true;
        }
        return this.alz;
    }

    /* access modifiers changed from: package-private */
    public final void jt() {
        int measuredWidth;
        if (jv()) {
            if (this.alz) {
                if (this.Ws.getMeasuredHeight() > 0 && this.Ws.getMeasuredWidth() > 0) {
                    if (((Boolean) a(this.Ws, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
                        measuredWidth = 1048576;
                    } else {
                        measuredWidth = (this.Ws.getMeasuredWidth() - this.Ws.getTotalPaddingLeft()) - this.Ws.getTotalPaddingRight();
                    }
                    int height = (this.Ws.getHeight() - this.Ws.getCompoundPaddingBottom()) - this.Ws.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        synchronized (alw) {
                            alw.setEmpty();
                            alw.right = (float) measuredWidth;
                            alw.bottom = (float) height;
                            float d2 = (float) d(alw);
                            if (d2 != this.Ws.getTextSize()) {
                                e(0, d2);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.alz = true;
        }
    }

    private void ju() {
        this.aly = 0;
        this.alB = -1.0f;
        this.alC = -1.0f;
        this.alA = -1.0f;
        this.alD = new int[0];
        this.alz = false;
    }

    /* access modifiers changed from: package-private */
    public final void e(int i2, float f2) {
        Resources resources;
        if (this.mContext == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.mContext.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }

    private void setRawTextSize(float f2) {
        boolean z;
        if (f2 != this.Ws.getPaint().getTextSize()) {
            this.Ws.getPaint().setTextSize(f2);
            if (Build.VERSION.SDK_INT >= 18) {
                z = this.Ws.isInLayout();
            } else {
                z = false;
            }
            if (this.Ws.getLayout() != null) {
                this.alz = false;
                try {
                    Method E = E("nullLayouts");
                    if (E != null) {
                        E.invoke(this.Ws, new Object[0]);
                    }
                } catch (Exception e2) {
                }
                if (!z) {
                    this.Ws.requestLayout();
                } else {
                    this.Ws.forceLayout();
                }
                this.Ws.invalidate();
            }
        }
    }

    private int d(RectF rectF) {
        int length = this.alD.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = 1;
        int i3 = length - 1;
        int i4 = 0;
        while (i2 <= i3) {
            int i5 = (i2 + i3) / 2;
            if (a(this.alD[i5], rectF)) {
                i4 = i2;
                i2 = i5 + 1;
            } else {
                int i6 = i5 - 1;
                i4 = i6;
                i3 = i6;
            }
        }
        return this.alD[i4];
    }

    private boolean a(int i2, RectF rectF) {
        StaticLayout a2;
        CharSequence transformation;
        CharSequence text = this.Ws.getText();
        TransformationMethod transformationMethod = this.Ws.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.Ws)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.Ws.getMaxLines() : -1;
        if (this.alF == null) {
            this.alF = new TextPaint();
        } else {
            this.alF.reset();
        }
        this.alF.set(this.Ws.getPaint());
        this.alF.setTextSize((float) i2);
        Layout.Alignment alignment = (Layout.Alignment) a(this.Ws, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        if (Build.VERSION.SDK_INT >= 23) {
            a2 = a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            a2 = a(text, alignment, Math.round(rectF.right));
        }
        if (maxLines != -1 && (a2.getLineCount() > maxLines || a2.getLineEnd(a2.getLineCount() - 1) != text.length())) {
            return false;
        }
        if (((float) a2.getHeight()) > rectF.bottom) {
            return false;
        }
        return true;
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) a(this.Ws, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.alF, i2).setAlignment(alignment).setLineSpacing(this.Ws.getLineSpacingExtra(), this.Ws.getLineSpacingMultiplier()).setIncludePad(this.Ws.getIncludeFontPadding()).setBreakStrategy(this.Ws.getBreakStrategy()).setHyphenationFrequency(this.Ws.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i3).setTextDirection(textDirectionHeuristic).build();
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        float floatValue;
        float floatValue2;
        boolean booleanValue;
        if (Build.VERSION.SDK_INT >= 16) {
            floatValue = this.Ws.getLineSpacingMultiplier();
            floatValue2 = this.Ws.getLineSpacingExtra();
            booleanValue = this.Ws.getIncludeFontPadding();
        } else {
            floatValue = ((Float) a(this.Ws, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            floatValue2 = ((Float) a(this.Ws, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            booleanValue = ((Boolean) a(this.Ws, "getIncludeFontPadding", Boolean.TRUE)).booleanValue();
        }
        return new StaticLayout(charSequence, this.alF, i2, alignment, floatValue, floatValue2, booleanValue);
    }

    private static <T> T a(Object obj, String str, T t) {
        try {
            t = (T) E(str).invoke(obj, new Object[0]);
            if (t == null) {
            }
        } catch (Exception e2) {
            new StringBuilder("Failed to invoke TextView#").append(str).append("() method");
        }
        return t;
    }

    private static Method E(String str) {
        try {
            Method method = alx.get(str);
            if (method != null) {
                return method;
            }
            Method declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0]);
            if (declaredMethod == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            alx.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e2) {
            new StringBuilder("Failed to retrieve TextView#").append(str).append("() method");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean jv() {
        return jw() && this.aly != 0;
    }

    private boolean jw() {
        return !(this.Ws instanceof AppCompatEditText);
    }
}
