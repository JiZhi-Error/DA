package android.support.design.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.design.circularreveal.b;
import android.support.design.circularreveal.c;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;

public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements c {
    private final b jF = new b(this);

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.circularreveal.c
    public final void bu() {
        this.jF.bu();
    }

    @Override // android.support.design.circularreveal.c
    public final void bv() {
        this.jF.bv();
    }

    @Override // android.support.design.circularreveal.c
    public void setRevealInfo(c.d dVar) {
        this.jF.setRevealInfo(dVar);
    }

    @Override // android.support.design.circularreveal.c
    public c.d getRevealInfo() {
        return this.jF.getRevealInfo();
    }

    @Override // android.support.design.circularreveal.c
    public void setCircularRevealScrimColor(int i2) {
        this.jF.setCircularRevealScrimColor(i2);
    }

    @Override // android.support.design.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.jF.jK.getColor();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.jF.jM;
    }

    @Override // android.support.design.circularreveal.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.jF.setCircularRevealOverlayDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        if (this.jF != null) {
            this.jF.draw(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.support.design.circularreveal.b.a
    public final void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean isOpaque() {
        if (this.jF != null) {
            return this.jF.isOpaque();
        }
        return super.isOpaque();
    }

    @Override // android.support.design.circularreveal.b.a
    public final boolean bw() {
        return super.isOpaque();
    }
}
