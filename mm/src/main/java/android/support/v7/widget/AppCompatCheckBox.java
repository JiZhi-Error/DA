package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.r;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.mm.R;

public class AppCompatCheckBox extends CheckBox implements r {
    private final f akj;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.e9);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(aw.ae(context), attributeSet, i2);
        this.akj = new f(this);
        this.akj.a(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.akj != null) {
            this.akj.ji();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(a.l(getContext(), i2));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.akj != null ? this.akj.bI(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // android.support.v4.widget.r
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.akj != null) {
            this.akj.setSupportButtonTintList(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.akj != null) {
            return this.akj.akl;
        }
        return null;
    }

    @Override // android.support.v4.widget.r
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.akj != null) {
            this.akj.setSupportButtonTintMode(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.akj != null) {
            return this.akj.akm;
        }
        return null;
    }
}
