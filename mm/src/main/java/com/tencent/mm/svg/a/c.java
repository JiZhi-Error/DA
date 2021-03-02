package com.tencent.mm.svg.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.svg.b.b;
import com.tencent.mm.svg.b.d;

public final class c extends b {
    private a OuH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Picture picture, int i2) {
        super(picture != null ? picture.getWidth() : 0, picture != null ? picture.getHeight() : 0, i2);
        AppMethodBeat.i(148720);
        this.OuH = new a(picture, i2);
        gFP();
        AppMethodBeat.o(148720);
    }

    public final Drawable.ConstantState getConstantState() {
        return this.OuH;
    }

    public final void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(148721);
        long gFZ = b.gFZ();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.OuH.OuI == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.Ouy));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.OuH.OuJ == null || this.OuH.OuJ.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.Ouy));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.OuH.OuI.draw(canvas2);
                            this.OuH.OuJ = createBitmap;
                            b.Nn(nanoTime);
                            d.gGa();
                            y(canvas2);
                        }
                    }
                }
                if (this.OuH.OuJ == null || this.OuH.OuJ.isRecycled()) {
                    z = false;
                } else {
                    gFQ();
                    canvas.drawBitmap(this.OuH.OuJ, (Rect) null, this.Ky, this.OuA);
                }
                z2 = z;
            } else if (this.OuH.OuJ != null && !this.OuH.OuJ.isRecycled()) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.OuH.OuJ.toString());
                this.OuH.OuJ.recycle();
                this.OuH.OuJ = null;
            }
            View gFS = gFS();
            if (gFS == null) {
                gFS = a.C(this);
                gr(gFS);
            }
            a.b(gFS, this.OuA);
            if (!z2) {
                if (!canvas.isHardwareAccelerated() || Build.VERSION.SDK_INT >= 16) {
                    Picture picture = this.OuH.OuI;
                    if (picture != null) {
                        gFQ();
                        canvas.save();
                        canvas.drawPicture(picture, this.Ky);
                        canvas.restore();
                    }
                } else {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.mDuration = b.Nn(gFZ);
            d.gGb();
            y(canvas);
            AppMethodBeat.o(148721);
        } finally {
            this.mDuration = b.Nn(gFZ);
            d.gGb();
            y(canvas);
            AppMethodBeat.o(148721);
        }
    }

    public static class a extends Drawable.ConstantState {
        protected int GRb;
        protected Picture OuI;
        protected Bitmap OuJ;

        public a(Picture picture, int i2) {
            this.OuI = picture;
            this.GRb = i2;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(148717);
            c cVar = new c(this.OuI, this.GRb);
            AppMethodBeat.o(148717);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources) {
            AppMethodBeat.i(148718);
            Drawable newDrawable = newDrawable();
            AppMethodBeat.o(148718);
            return newDrawable;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AppMethodBeat.i(148719);
            Drawable newDrawable = newDrawable(resources);
            AppMethodBeat.o(148719);
            return newDrawable;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }
}
