package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class e extends b {
    private final Rect Ky = new Rect();
    private MMHandler czp = new MMHandler(Looper.getMainLooper());
    boolean gNC = true;
    private Context mContext;
    private int mHeight;
    private final Paint mPaint = new Paint(6);
    private Resources mResources;
    private int mWidth;
    int rmJ = 0;
    private float ydU = 1.0f;
    private float ydV = 1.0f;
    private boolean ydW;
    private Bitmap yeA = null;
    private boolean yeB = false;
    boolean yeC = true;
    private String yeD;
    int yeE = 0;
    private k yeF;
    private long yeh = 0;
    private final Runnable yep = new Runnable() {
        /* class com.tencent.mm.plugin.gif.e.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(104643);
            if (e.this.yeF != null) {
                k unused = e.this.yeF;
            }
            AppMethodBeat.o(104643);
        }
    };
    private final Runnable yeq = new Runnable() {
        /* class com.tencent.mm.plugin.gif.e.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(104642);
            if (SystemClock.uptimeMillis() >= e.this.yeh) {
                e.this.invalidateSelf();
            }
            AppMethodBeat.o(104642);
        }
    };
    private volatile boolean yew = false;
    private int yex;
    private int yey;
    private int[] yez;

    public e(Context context, boolean z, boolean z2, int i2, int[] iArr, String str) {
        AppMethodBeat.i(104644);
        this.mContext = context;
        this.mResources = this.mContext.getResources();
        this.yeB = false;
        this.gNC = z;
        this.yeC = z2;
        this.yeD = str;
        this.yey = i2;
        this.yez = iArr;
        if (!z) {
            this.yeA = OG(aBe(str));
        } else {
            this.yeA = OG(this.yez[0]);
        }
        this.mWidth = this.yeA.getWidth();
        this.mHeight = this.yeA.getHeight();
        if (this.yez.length == 3) {
            this.yex = 300;
        } else {
            this.yex = 100;
        }
        this.yeE = 0;
        AppMethodBeat.o(104644);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(104645);
        if (this.ydW) {
            this.Ky.set(getBounds());
            this.ydU = ((float) this.Ky.width()) / ((float) this.mWidth);
            this.ydV = ((float) this.Ky.height()) / ((float) this.mHeight);
            this.ydW = false;
        }
        if (this.mPaint.getShader() == null) {
            canvas.scale(this.ydU, this.ydV);
            if (this.yeB) {
                this.yeA = OG(this.yey);
                if (this.yeA != null && !this.yeA.isRecycled()) {
                    canvas.drawBitmap(this.yeA, 0.0f, 0.0f, this.mPaint);
                    AppMethodBeat.o(104645);
                    return;
                }
            } else if (!this.gNC) {
                this.yeA = OG(aBe(this.yeD));
                if (this.yeA != null && !this.yeA.isRecycled()) {
                    canvas.drawBitmap(this.yeA, 0.0f, 0.0f, this.mPaint);
                    AppMethodBeat.o(104645);
                    return;
                }
            } else {
                this.yeA = OG(this.yez[this.rmJ]);
                if (this.yeA != null && !this.yeA.isRecycled()) {
                    canvas.drawBitmap(this.yeA, 0.0f, 0.0f, this.mPaint);
                }
                this.rmJ++;
                if (this.yeE < 3) {
                    if (this.rmJ >= this.yez.length) {
                        this.rmJ = 0;
                        if (!this.yeC) {
                            this.yeE = 0;
                        } else {
                            this.yeE++;
                        }
                    }
                    l(this.yeq, (long) this.yex);
                    AppMethodBeat.o(104645);
                    return;
                }
                this.gNC = false;
                l(this.yeq, (long) this.yex);
                l(this.yep, 0);
                AppMethodBeat.o(104645);
                return;
            }
        } else {
            Log.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
            canvas.drawRect(this.Ky, this.mPaint);
        }
        AppMethodBeat.o(104645);
    }

    private void l(Runnable runnable, long j2) {
        AppMethodBeat.i(104646);
        this.yeh = SystemClock.uptimeMillis() + j2;
        if (this.czp != null) {
            this.czp.postDelayed(runnable, j2);
        }
        AppMethodBeat.o(104646);
    }

    public final int getIntrinsicHeight() {
        return this.mHeight;
    }

    public final int getIntrinsicWidth() {
        return this.mWidth;
    }

    public final void setAlpha(int i2) {
        AppMethodBeat.i(104647);
        this.mPaint.setAlpha(i2);
        AppMethodBeat.o(104647);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(104648);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.o(104648);
    }

    public final int getOpacity() {
        return -2;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(104649);
        super.onBoundsChange(rect);
        this.ydW = true;
        AppMethodBeat.o(104649);
    }

    public final void start() {
        AppMethodBeat.i(104650);
        this.yew = true;
        this.czp.post(this.yeq);
        AppMethodBeat.o(104650);
    }

    public final void stop() {
        this.yew = false;
    }

    public final boolean isRunning() {
        return this.yew;
    }

    private Bitmap OG(int i2) {
        AppMethodBeat.i(104651);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mResources, i2);
        AppMethodBeat.o(104651);
        return decodeResource;
    }

    private int aBe(String str) {
        AppMethodBeat.i(104652);
        int identifier = this.mResources.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
        AppMethodBeat.o(104652);
        return identifier;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(104653);
        this.yeF = null;
        super.finalize();
        AppMethodBeat.o(104653);
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void recycle() {
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void resume() {
    }
}
