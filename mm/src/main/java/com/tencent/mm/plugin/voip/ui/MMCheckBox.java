package com.tencent.mm.plugin.voip.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class MMCheckBox extends CheckBox {
    private Drawable HcG;
    private int HcH;

    public MMCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MMCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        AppMethodBeat.i(115297);
        if (i2 == 0 || i2 != this.HcH) {
            this.HcH = i2;
            Drawable drawable = null;
            if (this.HcH != 0) {
                drawable = getResources().getDrawable(this.HcH);
            }
            setButtonDrawable(drawable);
            AppMethodBeat.o(115297);
            return;
        }
        AppMethodBeat.o(115297);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.HcG = drawable;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(115298);
        super.drawableStateChanged();
        if (this.HcG != null) {
            this.HcG.setState(getDrawableState());
            invalidate();
        }
        AppMethodBeat.o(115298);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(115299);
        if (super.verifyDrawable(drawable) || drawable == this.HcG) {
            AppMethodBeat.o(115299);
            return true;
        }
        AppMethodBeat.o(115299);
        return false;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        AppMethodBeat.i(115300);
        super.jumpDrawablesToCurrentState();
        if (Build.VERSION.SDK_INT >= 11 && this.HcG != null) {
            this.HcG.jumpToCurrentState();
        }
        AppMethodBeat.o(115300);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int height;
        int i2 = 0;
        AppMethodBeat.i(115301);
        super.onDraw(canvas);
        Drawable drawable = this.HcG;
        if (drawable != null) {
            int gravity = getGravity() & 112;
            int gravity2 = getGravity() & 7;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            switch (gravity) {
                case 16:
                    height = (getHeight() - intrinsicHeight) / 2;
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    height = getHeight() - intrinsicHeight;
                    break;
                default:
                    height = 0;
                    break;
            }
            switch (gravity2) {
                case 1:
                    i2 = (getWidth() - intrinsicWidth) / 2;
                    break;
                case 5:
                    i2 = getWidth() - intrinsicWidth;
                    break;
            }
            drawable.setBounds(i2, height, i2 + intrinsicWidth, intrinsicHeight + height);
            drawable.draw(canvas);
        }
        AppMethodBeat.o(115301);
    }
}
