package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class b extends Drawable {
    final ActionBarContainer ahz;

    public b(ActionBarContainer actionBarContainer) {
        this.ahz = actionBarContainer;
    }

    public final void draw(Canvas canvas) {
        if (!this.ahz.ahG) {
            if (this.ahz.afZ != null) {
                this.ahz.afZ.draw(canvas);
            }
            if (this.ahz.ahE != null && this.ahz.ahH) {
                this.ahz.ahE.draw(canvas);
            }
        } else if (this.ahz.ahF != null) {
            this.ahz.ahF.draw(canvas);
        }
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }

    public final void getOutline(Outline outline) {
        if (this.ahz.ahG) {
            if (this.ahz.ahF != null) {
                this.ahz.ahF.getOutline(outline);
            }
        } else if (this.ahz.afZ != null) {
            this.ahz.afZ.getOutline(outline);
        }
    }
}
