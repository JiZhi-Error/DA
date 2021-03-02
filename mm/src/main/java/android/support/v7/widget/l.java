package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.a.f;
import android.support.v4.widget.b;
import android.support.v4.widget.q;
import android.support.v7.a.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class l {
    private final TextView alj;
    private ax alk;
    private ax all;
    private ax alm;
    private ax aln;
    private ax alo;
    private ax alp;
    final m alq;
    Typeface alr;
    boolean als;
    int mStyle = 0;

    l(TextView textView) {
        this.alj = textView;
        this.alq = new m(this.alj);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public final void a(AttributeSet attributeSet, int i2) {
        Context context = this.alj.getContext();
        g jk = g.jk();
        az a2 = az.a(context, attributeSet, a.C0040a.AppCompatTextHelper, i2, 0);
        int resourceId = a2.getResourceId(0, -1);
        if (a2.hasValue(3)) {
            this.alk = a(context, jk, a2.getResourceId(3, 0));
        }
        if (a2.hasValue(1)) {
            this.all = a(context, jk, a2.getResourceId(1, 0));
        }
        if (a2.hasValue(4)) {
            this.alm = a(context, jk, a2.getResourceId(4, 0));
        }
        if (a2.hasValue(2)) {
            this.aln = a(context, jk, a2.getResourceId(2, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a2.hasValue(5)) {
                this.alo = a(context, jk, a2.getResourceId(5, 0));
            }
            if (a2.hasValue(6)) {
                this.alp = a(context, jk, a2.getResourceId(6, 0));
            }
        }
        a2.ayy.recycle();
        boolean z = this.alj.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z2 = false;
        boolean z3 = false;
        ColorStateList colorStateList = null;
        ColorStateList colorStateList2 = null;
        ColorStateList colorStateList3 = null;
        if (resourceId != -1) {
            az a3 = az.a(context, resourceId, a.C0040a.TextAppearance);
            if (!z && a3.hasValue(12)) {
                z3 = true;
                z2 = a3.getBoolean(12, false);
            }
            a(context, a3);
            if (Build.VERSION.SDK_INT < 23) {
                if (a3.hasValue(3)) {
                    colorStateList = a3.getColorStateList(3);
                }
                if (a3.hasValue(4)) {
                    colorStateList2 = a3.getColorStateList(4);
                }
                if (a3.hasValue(5)) {
                    colorStateList3 = a3.getColorStateList(5);
                }
            }
            a3.ayy.recycle();
        }
        az a4 = az.a(context, attributeSet, a.C0040a.TextAppearance, i2, 0);
        if (!z && a4.hasValue(12)) {
            z3 = true;
            z2 = a4.getBoolean(12, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a4.hasValue(3)) {
                colorStateList = a4.getColorStateList(3);
            }
            if (a4.hasValue(4)) {
                colorStateList2 = a4.getColorStateList(4);
            }
            if (a4.hasValue(5)) {
                colorStateList3 = a4.getColorStateList(5);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && a4.hasValue(0) && a4.getDimensionPixelSize(0, -1) == 0) {
            this.alj.setTextSize(0, 0.0f);
        }
        a(context, a4);
        a4.ayy.recycle();
        if (colorStateList != null) {
            this.alj.setTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.alj.setHintTextColor(colorStateList2);
        }
        if (colorStateList3 != null) {
            this.alj.setLinkTextColor(colorStateList3);
        }
        if (!z && z3) {
            setAllCaps(z2);
        }
        if (this.alr != null) {
            this.alj.setTypeface(this.alr, this.mStyle);
        }
        this.alq.a(attributeSet, i2);
        if (b.SC && this.alq.aly != 0) {
            int[] iArr = this.alq.alD;
            if (iArr.length > 0) {
                if (((float) this.alj.getAutoSizeStepGranularity()) != -1.0f) {
                    this.alj.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.alq.alB), Math.round(this.alq.alC), Math.round(this.alq.alA), 0);
                } else {
                    this.alj.setAutoSizeTextTypeUniformWithPresetSizes(iArr, 0);
                }
            }
        }
        az a5 = az.a(context, attributeSet, a.C0040a.AppCompatTextView);
        int dimensionPixelSize = a5.getDimensionPixelSize(6, -1);
        int dimensionPixelSize2 = a5.getDimensionPixelSize(8, -1);
        int dimensionPixelSize3 = a5.getDimensionPixelSize(9, -1);
        a5.ayy.recycle();
        if (dimensionPixelSize != -1) {
            q.e(this.alj, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            q.f(this.alj, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            q.g(this.alj, dimensionPixelSize3);
        }
    }

    private void a(Context context, az azVar) {
        String string;
        int i2 = 11;
        this.mStyle = azVar.getInt(2, this.mStyle);
        if (azVar.hasValue(10) || azVar.hasValue(11)) {
            this.alr = null;
            if (!azVar.hasValue(11)) {
                i2 = 10;
            }
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.alj);
                try {
                    this.alr = azVar.a(i2, this.mStyle, new f.a() {
                        /* class android.support.v7.widget.l.AnonymousClass1 */

                        @Override // android.support.v4.content.a.f.a
                        public final void a(Typeface typeface) {
                            l lVar = l.this;
                            WeakReference weakReference = weakReference;
                            if (lVar.als) {
                                lVar.alr = typeface;
                                TextView textView = (TextView) weakReference.get();
                                if (textView != null) {
                                    textView.setTypeface(typeface, lVar.mStyle);
                                }
                            }
                        }

                        @Override // android.support.v4.content.a.f.a
                        public final void D(int i2) {
                        }
                    });
                    this.als = this.alr == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException e2) {
                }
            }
            if (this.alr == null && (string = azVar.getString(i2)) != null) {
                this.alr = Typeface.create(string, this.mStyle);
            }
        } else if (azVar.hasValue(1)) {
            this.als = false;
            switch (azVar.getInt(1, 1)) {
                case 1:
                    this.alr = Typeface.SANS_SERIF;
                    return;
                case 2:
                    this.alr = Typeface.SERIF;
                    return;
                case 3:
                    this.alr = Typeface.MONOSPACE;
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void u(Context context, int i2) {
        ColorStateList colorStateList;
        az a2 = az.a(context, i2, a.C0040a.TextAppearance);
        if (a2.hasValue(12)) {
            setAllCaps(a2.getBoolean(12, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a2.hasValue(3) && (colorStateList = a2.getColorStateList(3)) != null) {
            this.alj.setTextColor(colorStateList);
        }
        if (a2.hasValue(0) && a2.getDimensionPixelSize(0, -1) == 0) {
            this.alj.setTextSize(0, 0.0f);
        }
        a(context, a2);
        a2.ayy.recycle();
        if (this.alr != null) {
            this.alj.setTypeface(this.alr, this.mStyle);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setAllCaps(boolean z) {
        this.alj.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public final void jo() {
        if (!(this.alk == null && this.all == null && this.alm == null && this.aln == null)) {
            Drawable[] compoundDrawables = this.alj.getCompoundDrawables();
            a(compoundDrawables[0], this.alk);
            a(compoundDrawables[1], this.all);
            a(compoundDrawables[2], this.alm);
            a(compoundDrawables[3], this.aln);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.alo != null || this.alp != null) {
            Drawable[] compoundDrawablesRelative = this.alj.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.alo);
            a(compoundDrawablesRelative[2], this.alp);
        }
    }

    private void a(Drawable drawable, ax axVar) {
        if (drawable != null && axVar != null) {
            g.a(drawable, axVar, this.alj.getDrawableState());
        }
    }

    private static ax a(Context context, g gVar, int i2) {
        ColorStateList s = gVar.s(context, i2);
        if (s == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.acT = true;
        axVar.Kr = s;
        return axVar;
    }

    /* access modifiers changed from: package-private */
    public final void jp() {
        if (!b.SC) {
            this.alq.jt();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setTextSize(int i2, float f2) {
        if (!b.SC && !this.alq.jv()) {
            e(i2, f2);
        }
    }

    private void e(int i2, float f2) {
        this.alq.e(i2, f2);
    }

    /* access modifiers changed from: package-private */
    public final void setAutoSizeTextTypeWithDefaults(int i2) {
        this.alq.setAutoSizeTextTypeWithDefaults(i2);
    }

    /* access modifiers changed from: package-private */
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        this.alq.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        this.alq.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
    }
}
