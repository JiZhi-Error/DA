package com.tencent.luggage.game.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a extends AppCompatButton {
    private RectF cuJ;
    private boolean cuK;
    private float cuL;
    private float cuM;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(130484);
        setGravity(17);
        setText("vConsole");
        setTextColor(-1);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        setPadding((int) (13.0f * f2), (int) (4.0f * f2), (int) (13.0f * f2), (int) (f2 * 6.0f));
        setBackgroundDrawable(new C0169a(this, (byte) 0));
        AppMethodBeat.o(130484);
    }

    private boolean s(float f2, float f3) {
        AppMethodBeat.i(130485);
        if (this.cuJ == null) {
            AppMethodBeat.o(130485);
            return false;
        }
        boolean contains = this.cuJ.contains(f2, f3);
        AppMethodBeat.o(130485);
        return contains;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(130486);
        switch (motionEvent.getAction()) {
            case 0:
                this.cuJ = new RectF(getX(), getY(), getX() + ((float) getWidth()), getY() + ((float) getHeight()));
                this.cuK = false;
                break;
            case 1:
                if (!this.cuK && s(motionEvent.getRawX(), motionEvent.getRawY())) {
                    performClick();
                    break;
                }
            case 2:
                if (this.cuK || !s(motionEvent.getRawX(), motionEvent.getRawY())) {
                    setX(getX() + (motionEvent.getRawX() - this.cuL));
                    setY(getY() + (motionEvent.getRawY() - this.cuM));
                    requestLayout();
                    this.cuK = true;
                    break;
                }
        }
        this.cuL = motionEvent.getRawX();
        this.cuM = motionEvent.getRawY();
        AppMethodBeat.o(130486);
        return true;
    }

    /* renamed from: com.tencent.luggage.game.c.a$a  reason: collision with other inner class name */
    class C0169a extends Drawable {
        RectF cuN;
        Paint paint;

        private C0169a() {
            AppMethodBeat.i(130482);
            this.paint = new Paint(1);
            this.cuN = new RectF();
            this.paint.setColor(-12748166);
            this.paint.setStyle(Paint.Style.FILL);
            AppMethodBeat.o(130482);
        }

        /* synthetic */ C0169a(a aVar, byte b2) {
            this();
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(130483);
            float height = ((float) canvas.getHeight()) / 2.0f;
            RectF rectF = this.cuN;
            this.cuN.top = 0.0f;
            rectF.left = 0.0f;
            RectF rectF2 = this.cuN;
            float f2 = height * 2.0f;
            this.cuN.bottom = f2;
            rectF2.right = f2;
            canvas.drawArc(this.cuN, 90.0f, 180.0f, false, this.paint);
            this.cuN.left = ((float) canvas.getWidth()) - (height * 2.0f);
            this.cuN.top = 0.0f;
            this.cuN.right = (float) canvas.getWidth();
            this.cuN.bottom = (float) canvas.getHeight();
            canvas.drawArc(this.cuN, -90.0f, 180.0f, false, this.paint);
            canvas.drawRect(height - 1.0f, 0.0f, (((float) a.this.getWidth()) - height) + 1.0f, (float) a.this.getHeight(), this.paint);
            AppMethodBeat.o(130483);
        }

        public final void setAlpha(int i2) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -1;
        }
    }
}
