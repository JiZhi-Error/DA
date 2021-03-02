package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import com.tencent.mm.R;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements s {
    private static final int[] afR = {16843126};
    private final e akc;
    private final l akd;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bp);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(aw.ae(context), attributeSet, i2);
        az a2 = az.a(getContext(), attributeSet, afR, i2, 0);
        if (a2.hasValue(0)) {
            setDropDownBackgroundDrawable(a2.getDrawable(0));
        }
        a2.ayy.recycle();
        this.akc = new e(this);
        this.akc.a(attributeSet, i2);
        this.akd = new l(this);
        this.akd.a(attributeSet, i2);
        this.akd.jo();
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.l(getContext(), i2));
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

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (this.akd != null) {
            this.akd.u(context, i2);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return h.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
