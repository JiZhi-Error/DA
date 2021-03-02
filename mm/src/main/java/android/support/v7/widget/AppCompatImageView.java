package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements s, android.support.v4.widget.s {
    private final i akF;
    private final e akc;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i2) {
        super(aw.ae(context), attributeSet, i2);
        this.akc = new e(this);
        this.akc.a(attributeSet, i2);
        this.akF = new i(this);
        this.akF.a(attributeSet, i2);
    }

    public void setImageResource(int i2) {
        if (this.akF != null) {
            this.akF.setImageResource(i2);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.akF != null) {
            this.akF.jl();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.akF != null) {
            this.akF.jl();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.akF != null) {
            this.akF.jl();
        }
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

    @Override // android.support.v4.widget.s
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.akF != null) {
            this.akF.setSupportImageTintList(colorStateList);
        }
    }

    @Override // android.support.v4.widget.s
    public ColorStateList getSupportImageTintList() {
        if (this.akF != null) {
            return this.akF.getSupportImageTintList();
        }
        return null;
    }

    @Override // android.support.v4.widget.s
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.akF != null) {
            this.akF.setSupportImageTintMode(mode);
        }
    }

    @Override // android.support.v4.widget.s
    public PorterDuff.Mode getSupportImageTintMode() {
        if (this.akF != null) {
            return this.akF.getSupportImageTintMode();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akc != null) {
            this.akc.jg();
        }
        if (this.akF != null) {
            this.akF.jl();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.akF.hasOverlappingRendering() && super.hasOverlappingRendering();
    }
}
