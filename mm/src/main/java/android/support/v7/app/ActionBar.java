package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public abstract class ActionBar {

    @Deprecated
    public static abstract class a {
        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract CharSequence getText();
    }

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public abstract int getHeight();

    public abstract CharSequence getTitle();

    public abstract void gr();

    public abstract void gs();

    public abstract void gt();

    public abstract void gu();

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract void setBackgroundDrawable(Drawable drawable);

    public abstract void setCustomView(int i2);

    public abstract void setCustomView(View view);

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public abstract void setDisplayOptions(int i2);

    public abstract void setLogo(Drawable drawable);

    public abstract void setTitle(CharSequence charSequence);

    public abstract void show();

    public Context getThemedContext() {
        return null;
    }

    public void setHomeActionContentDescription(int i2) {
    }

    public void gv() {
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void setElevation(float f2) {
        if (f2 != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void P(boolean z) {
    }

    public void Q(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void R(boolean z) {
    }

    public b a(b.a aVar) {
        return null;
    }

    public boolean gw() {
        return false;
    }

    public boolean gx() {
        return false;
    }

    public boolean gy() {
        return false;
    }

    public boolean b(KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void setWindowTitle(CharSequence charSequence) {
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }
}
