package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.d.c;
import android.support.v4.view.s;
import android.support.v4.widget.b;
import android.support.v4.widget.q;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements s, b {
    private final e akc;
    private final l akd;
    private Future<c> alv;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(aw.ae(context), attributeSet, i2);
        this.akc = new e(this);
        this.akc.a(attributeSet, i2);
        this.akd = new l(this);
        this.akd.a(attributeSet, i2);
        this.akd.jo();
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (this.akc != null) {
            this.akc.bH(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.akc != null) {
            this.akc.jf();
        }
    }

    @Override // android.support.v4.view.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.akc != null) {
            this.akc.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.view.s
    public ColorStateList getSupportBackgroundTintList() {
        if (this.akc != null) {
            return this.akc.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.view.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.akc != null) {
            this.akc.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.view.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.akc != null) {
            return this.akc.getSupportBackgroundTintMode();
        }
        return null;
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (this.akd != null) {
            this.akd.u(context, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akc != null) {
            this.akc.jg();
        }
        if (this.akd != null) {
            this.akd.jo();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.akd != null) {
            this.akd.jp();
        }
    }

    public void setTextSize(int i2, float f2) {
        if (SC) {
            super.setTextSize(i2, f2);
        } else if (this.akd != null) {
            this.akd.setTextSize(i2, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (this.akd != null && !SC && this.akd.alq.jv()) {
            this.akd.alq.jt();
        }
    }

    @Override // android.support.v4.widget.b
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (SC) {
            super.setAutoSizeTextTypeWithDefaults(i2);
        } else if (this.akd != null) {
            this.akd.setAutoSizeTextTypeWithDefaults(i2);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (SC) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        } else if (this.akd != null) {
            this.akd.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (SC) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        } else if (this.akd != null) {
            this.akd.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }
    }

    public int getAutoSizeTextType() {
        if (SC) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.akd != null) {
            return this.akd.alq.aly;
        }
        return 0;
    }

    public int getAutoSizeStepGranularity() {
        if (SC) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.akd != null) {
            return Math.round(this.akd.alq.alA);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (SC) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.akd != null) {
            return Math.round(this.akd.alq.alB);
        }
        return -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (SC) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.akd != null) {
            return Math.round(this.akd.alq.alC);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (SC) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.akd != null) {
            return this.akd.alq.alD;
        }
        return new int[0];
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return h.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            q.e(this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            q.f(this, i2);
        }
    }

    public void setLineHeight(int i2) {
        q.g(this, i2);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(q.a(this, callback));
    }

    public c.a getTextMetricsParamsCompat() {
        return q.e(this);
    }

    public void setPrecomputedText(c cVar) {
        q.a(this, cVar);
    }

    private void jq() {
        if (this.alv != null) {
            try {
                Future<c> future = this.alv;
                this.alv = null;
                q.a(this, future.get());
            } catch (InterruptedException | ExecutionException e2) {
            }
        }
    }

    public CharSequence getText() {
        jq();
        return super.getText();
    }

    public void setTextFuture(Future<c> future) {
        this.alv = future;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        jq();
        super.onMeasure(i2, i3);
    }

    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        int i2;
        if (Build.VERSION.SDK_INT >= 18) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.Om;
            if (!(textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
                if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                    i2 = 2;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                    i2 = 3;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                    i2 = 4;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                    i2 = 5;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                    i2 = 6;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                    i2 = 7;
                }
                setTextDirection(i2);
            }
            i2 = 1;
            setTextDirection(i2);
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = aVar.Ol.getTextScaleX();
            getPaint().set(aVar.Ol);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
            return;
        }
        getPaint().set(aVar.Ol);
        setBreakStrategy(aVar.On);
        setHyphenationFrequency(aVar.Oo);
    }
}
