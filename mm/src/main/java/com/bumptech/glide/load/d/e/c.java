package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.d.a.b;
import android.view.Gravity;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.d.e.g;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.List;

public class c extends Drawable implements Animatable, b, g.b {
    boolean aHN;
    final a aLL;
    private int aLM;
    private boolean aLN;
    private Rect aLO;
    private List<Object> aLP;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private Paint paint;

    public c(Context context, com.bumptech.glide.b.a aVar, l<Bitmap> lVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.af(context), aVar, i2, i3, lVar, bitmap)));
        AppMethodBeat.i(77484);
        AppMethodBeat.o(77484);
    }

    c(a aVar) {
        AppMethodBeat.i(77485);
        this.isVisible = true;
        this.aLM = -1;
        this.aLL = (a) j.checkNotNull(aVar, "Argument must not be null");
        AppMethodBeat.o(77485);
    }

    public final Bitmap pJ() {
        return this.aLL.aLQ.aLY;
    }

    public final ByteBuffer getBuffer() {
        AppMethodBeat.i(77486);
        ByteBuffer asReadOnlyBuffer = this.aLL.aLQ.aLR.getData().asReadOnlyBuffer();
        AppMethodBeat.o(77486);
        return asReadOnlyBuffer;
    }

    public void start() {
        AppMethodBeat.i(77487);
        this.isStarted = true;
        this.loopCount = 0;
        if (this.isVisible) {
            pK();
        }
        AppMethodBeat.o(77487);
    }

    public void stop() {
        AppMethodBeat.i(77488);
        this.isStarted = false;
        pL();
        AppMethodBeat.o(77488);
    }

    private void pK() {
        AppMethodBeat.i(77489);
        j.checkArgument(!this.aHN, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.aLL.aLQ.getFrameCount() == 1) {
            invalidateSelf();
            AppMethodBeat.o(77489);
            return;
        }
        if (!this.isRunning) {
            this.isRunning = true;
            this.aLL.aLQ.a(this);
            invalidateSelf();
        }
        AppMethodBeat.o(77489);
    }

    private void pL() {
        AppMethodBeat.i(77490);
        this.isRunning = false;
        this.aLL.aLQ.b(this);
        AppMethodBeat.o(77490);
    }

    public boolean setVisible(boolean z, boolean z2) {
        AppMethodBeat.i(77491);
        j.checkArgument(!this.aHN, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = z;
        if (!z) {
            pL();
        } else if (this.isStarted) {
            pK();
        }
        boolean visible = super.setVisible(z, z2);
        AppMethodBeat.o(77491);
        return visible;
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.i(77492);
        int width = this.aLL.aLQ.pO().getWidth();
        AppMethodBeat.o(77492);
        return width;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.i(77493);
        int height = this.aLL.aLQ.pO().getHeight();
        AppMethodBeat.o(77493);
        return height;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        AppMethodBeat.i(77494);
        super.onBoundsChange(rect);
        this.aLN = true;
        AppMethodBeat.o(77494);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(77495);
        if (this.aHN) {
            AppMethodBeat.o(77495);
            return;
        }
        if (this.aLN) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), pM());
            this.aLN = false;
        }
        canvas.drawBitmap(this.aLL.aLQ.pO(), (Rect) null, pM(), getPaint());
        AppMethodBeat.o(77495);
    }

    public void setAlpha(int i2) {
        AppMethodBeat.i(77496);
        getPaint().setAlpha(i2);
        AppMethodBeat.o(77496);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(77497);
        getPaint().setColorFilter(colorFilter);
        AppMethodBeat.o(77497);
    }

    private Rect pM() {
        AppMethodBeat.i(77498);
        if (this.aLO == null) {
            this.aLO = new Rect();
        }
        Rect rect = this.aLO;
        AppMethodBeat.o(77498);
        return rect;
    }

    private Paint getPaint() {
        AppMethodBeat.i(77499);
        if (this.paint == null) {
            this.paint = new Paint(2);
        }
        Paint paint2 = this.paint;
        AppMethodBeat.o(77499);
        return paint2;
    }

    public int getOpacity() {
        return -2;
    }

    public Drawable.ConstantState getConstantState() {
        return this.aLL;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends Drawable.ConstantState {
        final g aLQ;

        a(g gVar) {
            this.aLQ = gVar;
        }

        public final Drawable newDrawable(Resources resources) {
            AppMethodBeat.i(77482);
            Drawable newDrawable = newDrawable();
            AppMethodBeat.o(77482);
            return newDrawable;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(77483);
            c cVar = new c(this);
            AppMethodBeat.o(77483);
            return cVar;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    @Override // com.bumptech.glide.load.d.e.g.b
    public final void pN() {
        AppMethodBeat.i(77500);
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            AppMethodBeat.o(77500);
            return;
        }
        invalidateSelf();
        g gVar = this.aLL.aLQ;
        if ((gVar.aLV != null ? gVar.aLV.index : -1) == this.aLL.aLQ.getFrameCount() - 1) {
            this.loopCount++;
        }
        if (this.aLM != -1 && this.loopCount >= this.aLM) {
            if (this.aLP != null) {
                int size = this.aLP.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.aLP.get(i2);
                }
            }
            stop();
        }
        AppMethodBeat.o(77500);
    }
}
