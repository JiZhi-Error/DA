package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.InputStream;

public final class d extends b {
    private final Rect Ky;
    private MMHandler czp;
    private int gsi;
    private float mDensity;
    private boolean mIsRunning;
    private final Paint mPaint;
    private boolean ydQ;
    private volatile long ydR;
    private AssetFileDescriptor ydS;
    private final int[] ydT;
    private float ydU;
    private float ydV;
    private boolean ydW;
    private int[] ydX;
    private Bitmap ydY;
    private boolean ydZ;
    private int yea;
    private int yeb;
    private long yec;
    private long yed;
    private long yee;
    private long yef;
    private long yeg;
    private long yeh;
    private int yei;
    private boolean yej;
    public int yek;
    private int yel;
    k yem;
    private boolean yen;
    private boolean yeo;
    private final Runnable yep;
    private final Runnable yeq;
    private final Runnable yer;
    private final Runnable yes;
    private final Runnable yet;
    private final Runnable yeu;

    static /* synthetic */ void a(d dVar, Runnable runnable, long j2) {
        AppMethodBeat.i(104640);
        dVar.l(runnable, j2);
        AppMethodBeat.o(104640);
    }

    static /* synthetic */ int m(d dVar) {
        int i2 = dVar.yel;
        dVar.yel = i2 + 1;
        return i2;
    }

    private void l(Runnable runnable, long j2) {
        AppMethodBeat.i(104619);
        this.yeh = SystemClock.uptimeMillis() + j2;
        if (this.czp != null) {
            this.czp.postAtTime(runnable, this.yeh);
        }
        AppMethodBeat.o(104619);
    }

    public d(Resources resources, int i2) {
        this(resources.openRawResource(i2));
        AppMethodBeat.i(104620);
        AppMethodBeat.o(104620);
    }

    public d(String str, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(104621);
        this.mIsRunning = true;
        this.ydQ = false;
        this.ydS = null;
        this.ydT = new int[6];
        this.ydU = 1.0f;
        this.ydV = 1.0f;
        this.Ky = new Rect();
        this.mPaint = new Paint(6);
        this.ydZ = false;
        this.yea = 0;
        this.yeb = -1;
        this.yec = 0;
        this.yed = 0;
        this.yee = 0;
        this.yef = 0;
        this.yeh = 0;
        this.yej = false;
        this.yek = 0;
        this.yel = 0;
        this.czp = new MMHandler(Looper.getMainLooper());
        this.yen = true;
        this.yeo = false;
        this.yep = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(104613);
                if (d.this.yem != null) {
                    k unused = d.this.yem;
                }
                AppMethodBeat.o(104613);
            }
        };
        this.yeq = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(104614);
                if ((d.this.isRunning() || d.this.yeb == 0) && SystemClock.uptimeMillis() >= d.this.yeh) {
                    d.this.yef = System.currentTimeMillis();
                    d.this.yen = true;
                    d.this.invalidateSelf();
                    if (d.this.yem != null) {
                        d.this.yem.invalidate();
                    }
                }
                AppMethodBeat.o(104614);
            }
        };
        this.yer = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(104615);
                MMGIFJNI.restoreRemainder(d.this.ydR);
                d.a(d.this, d.this.yeq, d.this.yee);
                AppMethodBeat.o(104615);
            }
        };
        this.yes = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(104616);
                MMGIFJNI.reset(d.this.ydR);
                d.this.yeb = -1;
                d.a(d.this, d.this.yeq, 0);
                AppMethodBeat.o(104616);
            }
        };
        this.yet = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(104617);
                MMGIFJNI.saveRemainder(d.this.ydR);
                AppMethodBeat.o(104617);
            }
        };
        this.yeu = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(104618);
                if (d.this.ydQ) {
                    Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    AppMethodBeat.o(104618);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (d.this.yeb + 1 > d.this.yea - 1) {
                    d.this.yeb = -1;
                }
                d.this.yeb++;
                boolean drawFramePixels = MMGIFJNI.drawFramePixels(d.this.ydR, d.this.ydX, d.this.ydT);
                d.this.ydZ = true;
                if (drawFramePixels) {
                    d.m(d.this);
                }
                d.this.yec = System.currentTimeMillis() - currentTimeMillis;
                if (d.this.yed != 0) {
                    d.this.yee = (d.this.yed - d.this.yec) - d.this.yeg;
                    if (d.this.yee < 0) {
                        Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(d.this.yec), Long.valueOf(d.this.yeg), Long.valueOf(d.this.yee), Long.valueOf(d.this.yed), Integer.valueOf(d.this.ydT[5]));
                        h.INSTANCE.idkeyStat(401, 0, 1, false);
                        h.INSTANCE.idkeyStat(401, 1, Math.abs(d.this.yee), false);
                        if (d.this.yee < -100) {
                            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable, d.this.gsi);
                            d.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                d.a(d.this, d.this.yeq, d.this.yee > 0 ? d.this.yee : 0);
                if (d.this.ydT[2] == 1) {
                    d.this.yed = 5000;
                    AppMethodBeat.o(104618);
                    return;
                }
                d.this.yed = (long) d.this.ydT[4];
                AppMethodBeat.o(104618);
            }
        };
        this.yeo = z;
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("file path is null.");
            AppMethodBeat.o(104621);
            throw nullPointerException;
        }
        this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : i2, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.ydR = MMGIFJNI.openByFilePath(str, this.ydT);
        init();
        AppMethodBeat.o(104621);
    }

    public d(String str) {
        AppMethodBeat.i(104622);
        this.mIsRunning = true;
        this.ydQ = false;
        this.ydS = null;
        this.ydT = new int[6];
        this.ydU = 1.0f;
        this.ydV = 1.0f;
        this.Ky = new Rect();
        this.mPaint = new Paint(6);
        this.ydZ = false;
        this.yea = 0;
        this.yeb = -1;
        this.yec = 0;
        this.yed = 0;
        this.yee = 0;
        this.yef = 0;
        this.yeh = 0;
        this.yej = false;
        this.yek = 0;
        this.yel = 0;
        this.czp = new MMHandler(Looper.getMainLooper());
        this.yen = true;
        this.yeo = false;
        this.yep = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(104613);
                if (d.this.yem != null) {
                    k unused = d.this.yem;
                }
                AppMethodBeat.o(104613);
            }
        };
        this.yeq = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(104614);
                if ((d.this.isRunning() || d.this.yeb == 0) && SystemClock.uptimeMillis() >= d.this.yeh) {
                    d.this.yef = System.currentTimeMillis();
                    d.this.yen = true;
                    d.this.invalidateSelf();
                    if (d.this.yem != null) {
                        d.this.yem.invalidate();
                    }
                }
                AppMethodBeat.o(104614);
            }
        };
        this.yer = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(104615);
                MMGIFJNI.restoreRemainder(d.this.ydR);
                d.a(d.this, d.this.yeq, d.this.yee);
                AppMethodBeat.o(104615);
            }
        };
        this.yes = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(104616);
                MMGIFJNI.reset(d.this.ydR);
                d.this.yeb = -1;
                d.a(d.this, d.this.yeq, 0);
                AppMethodBeat.o(104616);
            }
        };
        this.yet = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(104617);
                MMGIFJNI.saveRemainder(d.this.ydR);
                AppMethodBeat.o(104617);
            }
        };
        this.yeu = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(104618);
                if (d.this.ydQ) {
                    Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    AppMethodBeat.o(104618);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (d.this.yeb + 1 > d.this.yea - 1) {
                    d.this.yeb = -1;
                }
                d.this.yeb++;
                boolean drawFramePixels = MMGIFJNI.drawFramePixels(d.this.ydR, d.this.ydX, d.this.ydT);
                d.this.ydZ = true;
                if (drawFramePixels) {
                    d.m(d.this);
                }
                d.this.yec = System.currentTimeMillis() - currentTimeMillis;
                if (d.this.yed != 0) {
                    d.this.yee = (d.this.yed - d.this.yec) - d.this.yeg;
                    if (d.this.yee < 0) {
                        Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(d.this.yec), Long.valueOf(d.this.yeg), Long.valueOf(d.this.yee), Long.valueOf(d.this.yed), Integer.valueOf(d.this.ydT[5]));
                        h.INSTANCE.idkeyStat(401, 0, 1, false);
                        h.INSTANCE.idkeyStat(401, 1, Math.abs(d.this.yee), false);
                        if (d.this.yee < -100) {
                            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable, d.this.gsi);
                            d.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                d.a(d.this, d.this.yeq, d.this.yee > 0 ? d.this.yee : 0);
                if (d.this.ydT[2] == 1) {
                    d.this.yed = 5000;
                    AppMethodBeat.o(104618);
                    return;
                }
                d.this.yed = (long) d.this.ydT[4];
                AppMethodBeat.o(104618);
            }
        };
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("file path is null.");
            AppMethodBeat.o(104622);
            throw nullPointerException;
        }
        this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.ydR = MMGIFJNI.openByFilePath(q.k(str, false), this.ydT);
        init();
        AppMethodBeat.o(104622);
    }

    public d(InputStream inputStream) {
        int i2 = 0;
        AppMethodBeat.i(104623);
        this.mIsRunning = true;
        this.ydQ = false;
        this.ydS = null;
        this.ydT = new int[6];
        this.ydU = 1.0f;
        this.ydV = 1.0f;
        this.Ky = new Rect();
        this.mPaint = new Paint(6);
        this.ydZ = false;
        this.yea = 0;
        this.yeb = -1;
        this.yec = 0;
        this.yed = 0;
        this.yee = 0;
        this.yef = 0;
        this.yeh = 0;
        this.yej = false;
        this.yek = 0;
        this.yel = 0;
        this.czp = new MMHandler(Looper.getMainLooper());
        this.yen = true;
        this.yeo = false;
        this.yep = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(104613);
                if (d.this.yem != null) {
                    k unused = d.this.yem;
                }
                AppMethodBeat.o(104613);
            }
        };
        this.yeq = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(104614);
                if ((d.this.isRunning() || d.this.yeb == 0) && SystemClock.uptimeMillis() >= d.this.yeh) {
                    d.this.yef = System.currentTimeMillis();
                    d.this.yen = true;
                    d.this.invalidateSelf();
                    if (d.this.yem != null) {
                        d.this.yem.invalidate();
                    }
                }
                AppMethodBeat.o(104614);
            }
        };
        this.yer = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(104615);
                MMGIFJNI.restoreRemainder(d.this.ydR);
                d.a(d.this, d.this.yeq, d.this.yee);
                AppMethodBeat.o(104615);
            }
        };
        this.yes = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(104616);
                MMGIFJNI.reset(d.this.ydR);
                d.this.yeb = -1;
                d.a(d.this, d.this.yeq, 0);
                AppMethodBeat.o(104616);
            }
        };
        this.yet = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(104617);
                MMGIFJNI.saveRemainder(d.this.ydR);
                AppMethodBeat.o(104617);
            }
        };
        this.yeu = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(104618);
                if (d.this.ydQ) {
                    Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    AppMethodBeat.o(104618);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (d.this.yeb + 1 > d.this.yea - 1) {
                    d.this.yeb = -1;
                }
                d.this.yeb++;
                boolean drawFramePixels = MMGIFJNI.drawFramePixels(d.this.ydR, d.this.ydX, d.this.ydT);
                d.this.ydZ = true;
                if (drawFramePixels) {
                    d.m(d.this);
                }
                d.this.yec = System.currentTimeMillis() - currentTimeMillis;
                if (d.this.yed != 0) {
                    d.this.yee = (d.this.yed - d.this.yec) - d.this.yeg;
                    if (d.this.yee < 0) {
                        Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(d.this.yec), Long.valueOf(d.this.yeg), Long.valueOf(d.this.yee), Long.valueOf(d.this.yed), Integer.valueOf(d.this.ydT[5]));
                        h.INSTANCE.idkeyStat(401, 0, 1, false);
                        h.INSTANCE.idkeyStat(401, 1, Math.abs(d.this.yee), false);
                        if (d.this.yee < -100) {
                            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable, d.this.gsi);
                            d.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                d.a(d.this, d.this.yeq, d.this.yee > 0 ? d.this.yee : 0);
                if (d.this.ydT[2] == 1) {
                    d.this.yed = 5000;
                    AppMethodBeat.o(104618);
                    return;
                }
                d.this.yed = (long) d.this.ydT[4];
                AppMethodBeat.o(104618);
            }
        };
        if (inputStream == null) {
            NullPointerException nullPointerException = new NullPointerException("input stream is null.");
            AppMethodBeat.o(104623);
            throw nullPointerException;
        }
        this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : i2, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.ydR = MMGIFJNI.openByInputStrem(inputStream, this.ydT);
        init();
        AppMethodBeat.o(104623);
    }

    public d(byte[] bArr, String str) {
        this(bArr);
        AppMethodBeat.i(104624);
        b bVar = b.gVU;
        if (b.EP(str) != null) {
            b bVar2 = b.gVU;
            this.ydY = b.EP(str);
        }
        AppMethodBeat.o(104624);
    }

    public d(byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.i(104625);
        this.mIsRunning = true;
        this.ydQ = false;
        this.ydS = null;
        this.ydT = new int[6];
        this.ydU = 1.0f;
        this.ydV = 1.0f;
        this.Ky = new Rect();
        this.mPaint = new Paint(6);
        this.ydZ = false;
        this.yea = 0;
        this.yeb = -1;
        this.yec = 0;
        this.yed = 0;
        this.yee = 0;
        this.yef = 0;
        this.yeh = 0;
        this.yej = false;
        this.yek = 0;
        this.yel = 0;
        this.czp = new MMHandler(Looper.getMainLooper());
        this.yen = true;
        this.yeo = false;
        this.yep = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(104613);
                if (d.this.yem != null) {
                    k unused = d.this.yem;
                }
                AppMethodBeat.o(104613);
            }
        };
        this.yeq = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(104614);
                if ((d.this.isRunning() || d.this.yeb == 0) && SystemClock.uptimeMillis() >= d.this.yeh) {
                    d.this.yef = System.currentTimeMillis();
                    d.this.yen = true;
                    d.this.invalidateSelf();
                    if (d.this.yem != null) {
                        d.this.yem.invalidate();
                    }
                }
                AppMethodBeat.o(104614);
            }
        };
        this.yer = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(104615);
                MMGIFJNI.restoreRemainder(d.this.ydR);
                d.a(d.this, d.this.yeq, d.this.yee);
                AppMethodBeat.o(104615);
            }
        };
        this.yes = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(104616);
                MMGIFJNI.reset(d.this.ydR);
                d.this.yeb = -1;
                d.a(d.this, d.this.yeq, 0);
                AppMethodBeat.o(104616);
            }
        };
        this.yet = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(104617);
                MMGIFJNI.saveRemainder(d.this.ydR);
                AppMethodBeat.o(104617);
            }
        };
        this.yeu = new Runnable() {
            /* class com.tencent.mm.plugin.gif.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(104618);
                if (d.this.ydQ) {
                    Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    AppMethodBeat.o(104618);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (d.this.yeb + 1 > d.this.yea - 1) {
                    d.this.yeb = -1;
                }
                d.this.yeb++;
                boolean drawFramePixels = MMGIFJNI.drawFramePixels(d.this.ydR, d.this.ydX, d.this.ydT);
                d.this.ydZ = true;
                if (drawFramePixels) {
                    d.m(d.this);
                }
                d.this.yec = System.currentTimeMillis() - currentTimeMillis;
                if (d.this.yed != 0) {
                    d.this.yee = (d.this.yed - d.this.yec) - d.this.yeg;
                    if (d.this.yee < 0) {
                        Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(d.this.yec), Long.valueOf(d.this.yeg), Long.valueOf(d.this.yee), Long.valueOf(d.this.yed), Integer.valueOf(d.this.ydT[5]));
                        h.INSTANCE.idkeyStat(401, 0, 1, false);
                        h.INSTANCE.idkeyStat(401, 1, Math.abs(d.this.yee), false);
                        if (d.this.yee < -100) {
                            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable, d.this.gsi);
                            d.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                d.a(d.this, d.this.yeq, d.this.yee > 0 ? d.this.yee : 0);
                if (d.this.ydT[2] == 1) {
                    d.this.yed = 5000;
                    AppMethodBeat.o(104618);
                    return;
                }
                d.this.yed = (long) d.this.ydT[4];
                AppMethodBeat.o(104618);
            }
        };
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("bytes is null.");
            AppMethodBeat.o(104625);
            throw nullPointerException;
        }
        this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : i2, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.ydR = MMGIFJNI.openByByteArray(bArr, this.ydT);
        init();
        AppMethodBeat.o(104625);
    }

    private void init() {
        AppMethodBeat.i(104626);
        Log.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", Long.valueOf(this.ydR));
        this.yea = this.ydT[2];
        this.yei = a.aG(MMApplicationContext.getContext(), R.dimen.a3i);
        if (this.yeo || (this.ydT[0] <= 1024 && this.ydT[1] <= 1024)) {
            this.ydX = new int[(this.ydT[0] * this.ydT[1])];
            AppMethodBeat.o(104626);
            return;
        }
        Log.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.ydT[0]), Integer.valueOf(this.ydT[1]));
        this.ydX = new int[(this.yei * this.yei)];
        this.yej = true;
        h.INSTANCE.idkeyStat(401, 2, 1, false);
        AppMethodBeat.o(104626);
    }

    public final float getEmojiDensityScale() {
        AppMethodBeat.i(104627);
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(MMApplicationContext.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f2 = this.mDensity;
        AppMethodBeat.o(104627);
        return f2;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(104628);
        int emojiDensityScale = (int) (((float) this.ydT[0]) * getEmojiDensityScale());
        AppMethodBeat.o(104628);
        return emojiDensityScale;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.i(104629);
        int emojiDensityScale = (int) (((float) this.ydT[1]) * getEmojiDensityScale());
        AppMethodBeat.o(104629);
        return emojiDensityScale;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(104630);
        super.onBoundsChange(rect);
        this.ydW = true;
        AppMethodBeat.o(104630);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(104631);
        if (this.ydW) {
            this.Ky.set(getBounds());
            this.ydU = ((float) this.Ky.width()) / ((float) this.ydT[0]);
            this.ydV = ((float) this.Ky.height()) / ((float) this.ydT[1]);
            this.ydW = false;
        }
        if (this.mPaint.getShader() == null) {
            if (this.yef == 0) {
                this.yef = System.currentTimeMillis();
            }
            int[] iArr = this.ydX;
            if (iArr == null) {
                Log.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (!this.ydZ && this.ydY != null) {
                canvas.scale(((float) this.Ky.width()) / ((float) this.ydY.getWidth()), ((float) this.Ky.width()) / ((float) this.ydY.getHeight()));
                canvas.drawBitmap(this.ydY, 0.0f, 0.0f, this.mPaint);
            } else if (iArr.length == this.ydT[0] * this.ydT[1]) {
                canvas.scale(this.ydU, this.ydV);
                canvas.drawBitmap(iArr, 0, this.ydT[0], 0.0f, 0.0f, this.ydT[0], this.ydT[1], true, this.mPaint);
            } else {
                canvas.scale(this.ydU, this.ydV);
                canvas.drawRGB(230, 230, 230);
                Log.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", Integer.valueOf(iArr.length), Integer.valueOf(this.ydT[0]), Integer.valueOf(this.ydT[1]));
            }
            this.yeg = System.currentTimeMillis() - this.yef;
            if (this.yej || this.ydT[2] <= 0) {
                Log.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", Integer.valueOf(this.ydT[2]), Integer.valueOf(this.ydT[4]), Boolean.valueOf(this.yej));
            } else {
                if (this.ydT[4] < 0) {
                    Log.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
                }
                if (this.yek != 0 && this.yel > this.yek - 1) {
                    l(this.yep, 0);
                    AppMethodBeat.o(104631);
                    return;
                } else if (this.yen) {
                    com.tencent.mm.au.a.f(this.yeu, 0);
                    this.yen = false;
                    AppMethodBeat.o(104631);
                    return;
                }
            }
            AppMethodBeat.o(104631);
            return;
        }
        Log.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.Ky, this.mPaint);
        AppMethodBeat.o(104631);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i2) {
        AppMethodBeat.i(104632);
        this.mPaint.setAlpha(i2);
        AppMethodBeat.o(104632);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(104633);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.o(104633);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void start() {
        AppMethodBeat.i(104634);
        this.mIsRunning = true;
        com.tencent.mm.au.a.f(this.yer, 0);
        AppMethodBeat.o(104634);
    }

    public final void stop() {
        boolean z = true;
        AppMethodBeat.i(104635);
        Log.d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.mIsRunning = false;
        if (this.gsi != 0) {
            Log.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", Integer.valueOf(this.gsi));
            if (!WXHardCoderJNI.hcGifEnable && !WXHardCoderJNI.hcGifFrameEnable) {
                z = false;
            }
            WXHardCoderJNI.stopPerformance(z, this.gsi);
            this.gsi = 0;
        }
        com.tencent.mm.au.a.f(this.yet, 300);
        AppMethodBeat.o(104635);
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void pause() {
        this.mIsRunning = false;
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void resume() {
        AppMethodBeat.i(104636);
        if (!this.ydQ) {
            this.mIsRunning = true;
            l(this.yeq, 0);
        }
        AppMethodBeat.o(104636);
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void reset() {
        AppMethodBeat.i(104637);
        this.ydQ = false;
        this.mIsRunning = true;
        com.tencent.mm.au.a.f(this.yes, 0);
        AppMethodBeat.o(104637);
    }

    @Override // com.tencent.mm.plugin.gif.b
    public final void recycle() {
        AppMethodBeat.i(104638);
        Log.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.ydQ = true;
        this.mIsRunning = false;
        long j2 = this.ydR;
        this.ydR = 0;
        MMGIFJNI.recycle(j2);
        this.ydX = null;
        if (this.ydS != null) {
            try {
                this.ydS.close();
                AppMethodBeat.o(104638);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(104638);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(104639);
        try {
            recycle();
            AppMethodBeat.o(104639);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(104639);
        }
    }

    public final int dXy() {
        return this.ydT[0];
    }

    public final int dXz() {
        return this.ydT[1];
    }
}
