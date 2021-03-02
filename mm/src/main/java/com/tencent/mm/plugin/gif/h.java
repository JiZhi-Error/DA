package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.s;

public final class h extends b {
    private final Rect Ky;
    private MMHandler czp;
    private int gsi;
    private int loopCount;
    private float mDensity;
    private int mHeight;
    private boolean mIsRunning;
    private final Paint mPaint;
    private int mWidth;
    private boolean ydQ;
    private int[] ydT;
    private float ydU;
    private float ydV;
    private boolean ydW;
    private Bitmap ydY;
    private volatile long yeJ;
    private final Object yeK;
    private int[] yeL;
    private Bitmap[] yeM;
    private int yeN;
    private int yeO;
    private boolean yeP;
    private Runnable yeQ;
    private int yeR;
    private int yea;
    private int yeb;
    private long yec;
    private long yed;
    private long yee;
    private long yef;
    private long yeg;
    private long yeh;
    private boolean yen;
    private final Runnable yeq;
    private final Runnable yer;
    private final Runnable yes;
    private final Runnable yeu;

    static /* synthetic */ void a(h hVar, Runnable runnable, long j2) {
        AppMethodBeat.i(104680);
        hVar.l(runnable, j2);
        AppMethodBeat.o(104680);
    }

    private void l(Runnable runnable, long j2) {
        AppMethodBeat.i(104663);
        this.yeh = SystemClock.uptimeMillis() + j2;
        if (this.czp != null) {
            this.czp.postAtTime(runnable, this.yeh);
        }
        AppMethodBeat.o(104663);
    }

    public h(String str) {
        this(s.aW(str, 0, (int) s.boW(str)));
        AppMethodBeat.i(104664);
        AppMethodBeat.o(104664);
    }

    public h(byte[] bArr, String str) {
        this(bArr);
        AppMethodBeat.i(104665);
        b bVar = b.gVU;
        if (b.EP(str) != null) {
            b bVar2 = b.gVU;
            this.ydY = b.EP(str);
        }
        AppMethodBeat.o(104665);
    }

    public h(byte[] bArr) {
        AppMethodBeat.i(104666);
        this.mIsRunning = false;
        this.ydQ = false;
        this.yeK = new Object();
        this.ydT = new int[4];
        this.yeL = new int[4];
        this.ydU = 1.0f;
        this.ydV = 1.0f;
        this.Ky = new Rect();
        this.mPaint = new Paint(6);
        this.yeM = new Bitmap[2];
        this.yeN = 0;
        this.yea = 0;
        this.yeO = 0;
        this.yeb = -1;
        this.yec = 0;
        this.yed = 0;
        this.yee = 0;
        this.yef = 0;
        this.yeh = 0;
        this.yeP = false;
        this.czp = new MMHandler(Looper.getMainLooper());
        this.yen = true;
        this.yeq = new Runnable() {
            /* class com.tencent.mm.plugin.gif.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(104659);
                if (!h.this.ydQ && ((h.this.isRunning() || h.this.yeb == 0) && SystemClock.uptimeMillis() >= h.this.yeh)) {
                    h.this.yef = System.currentTimeMillis();
                    h.this.yen = true;
                    h.this.invalidateSelf();
                }
                AppMethodBeat.o(104659);
            }
        };
        this.yer = new Runnable() {
            /* class com.tencent.mm.plugin.gif.h.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(104660);
                h.a(h.this, h.this.yeq, h.this.yee);
                AppMethodBeat.o(104660);
            }
        };
        this.yes = new Runnable() {
            /* class com.tencent.mm.plugin.gif.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(104661);
                h.this.yeb = -1;
                synchronized (h.this.yeK) {
                    try {
                        MMWXGFJNI.nativeRewindBuffer(h.this.yeJ);
                    } catch (Throwable th) {
                        AppMethodBeat.o(104661);
                        throw th;
                    }
                }
                h.a(h.this, h.this.yeq, 0);
                AppMethodBeat.o(104661);
            }
        };
        this.yeR = -1;
        this.loopCount = 0;
        this.yeu = new Runnable() {
            /* class com.tencent.mm.plugin.gif.h.AnonymousClass4 */

            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0171, code lost:
                if (r12.yeS.yed == 0) goto L_0x0248;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x0173, code lost:
                r12.yeS.yee = (r12.yeS.yed - r12.yeS.yec) - r12.yeS.yeg;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0196, code lost:
                if (r12.yeS.yee >= 0) goto L_0x0248;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x0198, code lost:
                com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.GIF.MMWXGFDrawable", "%s Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", r12, java.lang.Long.valueOf(r12.yeS.yec), java.lang.Long.valueOf(r12.yeS.yeg), java.lang.Long.valueOf(r12.yeS.yee), java.lang.Long.valueOf(r12.yeS.yed), java.lang.Integer.valueOf(r12.yeS.yeb));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x01f2, code lost:
                if (r12.yeS.yee >= -100) goto L_0x0248;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x01f4, code lost:
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(401, 16, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(401, 17, java.lang.Math.abs(r12.yeS.yee), false);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x0216, code lost:
                if (com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifEnable != false) goto L_0x021c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:57:0x021a, code lost:
                if (com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameEnable == false) goto L_0x0296;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x021c, code lost:
                r0 = true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x021d, code lost:
                com.tencent.mm.hardcoder.WXHardCoderJNI.stopPerformance(r0, r12.yeS.gsi);
                r0 = r12.yeS;
                r1 = com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameEnable;
                r2 = com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameDelay;
                r3 = com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameCPU;
                r4 = com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameIO;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x0232, code lost:
                if (com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameThr == false) goto L_0x0298;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x0234, code lost:
                r5 = android.os.Process.myTid();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:0x0238, code lost:
                r0.gsi = com.tencent.mm.hardcoder.WXHardCoderJNI.startPerformance(r1, r2, r3, r4, r5, com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameTimeout, 602, com.tencent.mm.hardcoder.WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x0248, code lost:
                r2 = r12.yeS;
                r3 = r12.yeS.yeq;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:64:0x025a, code lost:
                if (r12.yeS.yee <= 0) goto L_0x029a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x025c, code lost:
                r0 = r12.yeS.yee;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x0262, code lost:
                com.tencent.mm.plugin.gif.h.a(r2, r3, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:67:0x026e, code lost:
                if (r12.yeS.yeL[0] <= 0) goto L_0x029d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:68:0x0270, code lost:
                r0 = r12.yeS.yeL[0];
             */
            /* JADX WARNING: Code restructure failed: missing block: B:69:0x0279, code lost:
                r12.yeS.yed = (long) r0;
                r12.yeS.yeP = false;
                com.tencent.matrix.trace.core.AppMethodBeat.o(104662);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:74:0x0296, code lost:
                r0 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:75:0x0298, code lost:
                r5 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:76:0x029a, code lost:
                r0 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:77:0x029d, code lost:
                r0 = 100;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 672
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gif.h.AnonymousClass4.run():void");
            }
        };
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("bytes is null.");
            AppMethodBeat.o(104666);
            throw nullPointerException;
        }
        this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
        this.yeJ = MMWXGFJNI.nativeInitWxAMDecoder();
        if (this.yeJ == 0 || this.yeJ == -901) {
            Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", Long.valueOf(this.yeJ));
            if (this.yeJ == -901) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 5, 1, false);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 4, 1, false);
            MMGIFException mMGIFException = new MMGIFException(201);
            AppMethodBeat.o(104666);
            throw mMGIFException;
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.yeJ, bArr, bArr.length);
        if (nativeDecodeBufferHeader != 0) {
            Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 8, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 3, 1, false);
            }
            MMGIFException mMGIFException2 = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.o(104666);
            throw mMGIFException2;
        }
        int nativeGetOption = MMWXGFJNI.nativeGetOption(this.yeJ, bArr, bArr.length, this.ydT);
        if (nativeGetOption != 0) {
            Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeGetOption));
            if (nativeGetOption == -903) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 7, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 3, 1, false);
            }
            MMGIFException mMGIFException3 = new MMGIFException(nativeGetOption);
            AppMethodBeat.o(104666);
            throw mMGIFException3;
        }
        this.yea = this.ydT[0];
        this.mWidth = this.ydT[1];
        this.mHeight = this.ydT[2];
        this.yeO = this.ydT[3];
        if (this.yeO <= 0) {
            this.yeO = 1;
        }
        if (this.mWidth == 0 || this.mHeight == 0) {
            int aG = a.aG(MMApplicationContext.getContext(), R.dimen.a3i);
            this.mHeight = aG;
            this.mWidth = aG;
        }
        AppMethodBeat.o(104666);
    }

    public final int dXA() {
        return this.yeO;
    }

    public final void OH(int i2) {
        this.yeR = i2;
    }

    public final void au(Runnable runnable) {
        this.yeQ = runnable;
    }

    public final void rU() {
        AppMethodBeat.i(199789);
        com.tencent.mm.au.a.f(this.yeu, 0);
        AppMethodBeat.o(199789);
    }

    public final float getEmojiDensityScale() {
        AppMethodBeat.i(104667);
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(MMApplicationContext.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f2 = this.mDensity;
        AppMethodBeat.o(104667);
        return f2;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(104668);
        int emojiDensityScale = (int) (((float) this.mWidth) * getEmojiDensityScale());
        AppMethodBeat.o(104668);
        return emojiDensityScale;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.i(104669);
        int emojiDensityScale = (int) (((float) this.mHeight) * getEmojiDensityScale());
        AppMethodBeat.o(104669);
        return emojiDensityScale;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(104670);
        super.onBoundsChange(rect);
        this.ydW = true;
        AppMethodBeat.o(104670);
    }

    public final void draw(Canvas canvas) {
        boolean z = true;
        AppMethodBeat.i(104671);
        if (this.ydW) {
            this.Ky.set(getBounds());
            this.ydU = ((float) this.Ky.width()) / ((float) this.mWidth);
            this.ydV = ((float) this.Ky.height()) / ((float) this.mHeight);
            this.ydW = false;
        }
        if (this.mPaint.getShader() == null) {
            if (this.yef == 0) {
                this.yef = System.currentTimeMillis();
            }
            if (this.yen) {
                this.yeN = (this.yeN + 1) % this.yeM.length;
            }
            Bitmap bitmap = this.yeM[this.yeN];
            if (bitmap == null) {
                bitmap = this.yeM[(this.yeN + 1) % this.yeM.length];
                Log.i("MicroMsg.GIF.MMWXGFDrawable", "use last decode bitmap %s  hash:[%s]", bitmap, Integer.valueOf(hashCode()));
            }
            if (bitmap != null && !bitmap.isRecycled() && !this.ydQ) {
                canvas.scale(this.ydU, this.ydV);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
            } else if (this.ydY != null) {
                canvas.scale(((float) this.Ky.width()) / ((float) this.ydY.getWidth()), ((float) this.Ky.height()) / ((float) this.ydY.getHeight()));
                canvas.drawBitmap(this.ydY, 0.0f, 0.0f, this.mPaint);
            } else {
                Log.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle %s", Integer.valueOf(hashCode()));
            }
            this.yeg = System.currentTimeMillis() - this.yef;
            if (this.yen) {
                if (this.yeR > 0 && this.yeb == -1) {
                    this.loopCount++;
                    if (this.loopCount >= this.yeR) {
                        this.mIsRunning = false;
                        l(this.yeQ, this.yed);
                        z = false;
                    }
                }
                if (z) {
                    com.tencent.mm.au.a.f(this.yeu, 0);
                }
                this.yen = false;
            }
            AppMethodBeat.o(104671);
            return;
        }
        canvas.drawRect(this.Ky, this.mPaint);
        AppMethodBeat.o(104671);
    }

    public final void setAlpha(int i2) {
        AppMethodBeat.i(104672);
        this.mPaint.setAlpha(i2);
        AppMethodBeat.o(104672);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(104673);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.o(104673);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void start() {
        AppMethodBeat.i(104674);
        this.mIsRunning = true;
        com.tencent.mm.au.a.f(this.yer, 0);
        AppMethodBeat.o(104674);
    }

    public final void stop() {
        boolean z = true;
        AppMethodBeat.i(104675);
        this.mIsRunning = false;
        if (this.gsi != 0) {
            Log.i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", Integer.valueOf(this.gsi));
            if (!WXHardCoderJNI.hcGifEnable && !WXHardCoderJNI.hcGifFrameEnable) {
                z = false;
            }
            WXHardCoderJNI.stopPerformance(z, this.gsi);
            this.gsi = 0;
        }
        AppMethodBeat.o(104675);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(104676);
        try {
            recycle();
            AppMethodBeat.o(104676);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", th, "", new Object[0]);
            super.finalize();
            AppMethodBeat.o(104676);
        }
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void pause() {
        this.mIsRunning = false;
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void resume() {
        AppMethodBeat.i(104677);
        if (!this.ydQ) {
            this.mIsRunning = true;
            l(this.yeq, 0);
        }
        AppMethodBeat.o(104677);
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void reset() {
        AppMethodBeat.i(104678);
        this.mIsRunning = true;
        com.tencent.mm.au.a.f(this.yes, 0);
        AppMethodBeat.o(104678);
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final synchronized void recycle() {
        AppMethodBeat.i(104679);
        Log.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", Long.valueOf(this.yeJ));
        synchronized (this.yeK) {
            try {
                this.ydQ = true;
                this.mIsRunning = false;
                long j2 = this.yeJ;
                this.yeJ = 0;
                this.czp.removeCallbacks(this.yeq);
                int nativeUninit = MMWXGFJNI.nativeUninit(j2);
                if (nativeUninit == -906) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(401, 10, 1, false);
                }
                Log.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", Integer.valueOf(nativeUninit), Long.valueOf(j2), Boolean.valueOf(this.yeP));
                this.yeM = null;
                this.yeQ = null;
            } finally {
                AppMethodBeat.o(104679);
            }
        }
    }

    public final int dXy() {
        return this.ydT[1];
    }

    public final int dXz() {
        return this.ydT[2];
    }
}
