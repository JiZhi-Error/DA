package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.f.j;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class f extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a {
    protected int bDU;
    protected float bDY;
    private final AtomicBoolean kQW;
    volatile boolean mAU;
    Context mAppContext;
    com.google.android.exoplayer2.f mCc;
    private boolean mCd;
    private C0715f mCe;
    private k mCf;
    private List<r> mCg;
    private f.a mCh;
    private c mCi;
    private k mCj;
    int mCk;
    private boolean mCl;
    private final AtomicBoolean mCm;
    protected int mCn;
    protected int mCo;
    protected int mCp;
    protected int mCq;
    protected int mCr;
    protected int mCs;
    private int mCt;
    private volatile boolean mCu;
    private volatile boolean mCv;
    private HandlerThread mHandlerThread;
    private boolean mIsLooping;
    private Handler mMainHandler;
    private Surface mSurface;
    int mVideoHeight;
    int mVideoWidth;

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(235038);
        fVar.bKC();
        AppMethodBeat.o(235038);
    }

    static /* synthetic */ void a(f fVar, boolean z) {
        AppMethodBeat.i(235039);
        fVar.hR(z);
        AppMethodBeat.o(235039);
    }

    public f() {
        this(null);
    }

    public f(Handler handler) {
        this(handler, 0, 0.75f, 10000, 25000, 15000, CommonUtils.MAX_TIMEOUT_MS, 2500);
    }

    public f(Handler handler, int i2, int i3, int i4) {
        this(handler, 0, 0.75f, 10000, 25000, i2, i3, i4);
    }

    public f(int i2, float f2, int i3, int i4, int i5, int i6) {
        this(null, i2, f2, i3, i4, i5, i6, 2500);
    }

    public f(Handler handler, int i2, float f2, int i3, int i4, int i5, int i6) {
        this(handler, i2, f2, i3, i4, i5, i6, 2500);
    }

    private f(Handler handler, int i2, float f2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(235006);
        this.kQW = new AtomicBoolean();
        this.mCm = new AtomicBoolean(false);
        this.bDU = 0;
        this.bDY = 0.75f;
        this.mCn = 10000;
        this.mCo = 25000;
        this.mCp = 15000;
        this.mCq = CommonUtils.MAX_TIMEOUT_MS;
        this.mCr = 2500;
        this.mCs = 5000;
        this.mCt = 0;
        this.mCu = false;
        this.mCv = false;
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", handler, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), 5000);
        this.bDU = 0;
        this.bDY = f2;
        this.mCn = i3;
        this.mCo = i4;
        this.mCp = i5;
        this.mCq = i6;
        this.mCr = i7;
        this.mCs = 5000;
        d(handler);
        AppMethodBeat.o(235006);
    }

    private void d(Handler handler) {
        AppMethodBeat.i(235007);
        this.mAppContext = MMApplicationContext.getContext();
        this.mCe = new C0715f((byte) 0);
        if (handler != null) {
            this.mMainHandler = handler;
        } else {
            this.mHandlerThread = com.tencent.f.c.d.hA("ExoMediaPlayer_HandlerThread", 5);
            this.mHandlerThread.start();
            this.mMainHandler = new Handler(this.mHandlerThread.getLooper());
        }
        this.mCh = new d(this, (byte) 0);
        this.mCi = new c(this, (byte) 0);
        this.mCj = new k(this.mMainHandler);
        this.mCj.mCF = 1000;
        this.mCj.mCH = new a(this, (byte) 0);
        e eVar = new e(this, (byte) 0);
        this.mCg = new d(this.mAppContext, this.mMainHandler, eVar, eVar, eVar, eVar).bKB();
        if (handler == null || handler.getLooper() != Looper.myLooper()) {
            this.mMainHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(234971);
                    synchronized (f.this) {
                        try {
                            f.a(f.this);
                            f.this.notifyAll();
                        } finally {
                            AppMethodBeat.o(234971);
                        }
                    }
                }
            });
            synchronized (this) {
                while (this.mCc == null) {
                    try {
                        try {
                            wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    } finally {
                        AppMethodBeat.o(235007);
                    }
                }
            }
            return;
        }
        bKC();
        AppMethodBeat.o(235007);
    }

    private void bKC() {
        AppMethodBeat.i(235008);
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
        this.mCc = g.a((r[]) this.mCg.toArray(new r[this.mCg.size()]), new com.google.android.exoplayer2.g.c(new c.b(g.bKK(), this.bDU, this.mCn, this.mCo, this.bDY)), new com.google.android.exoplayer2.c(new com.google.android.exoplayer2.h.k(), this.mCp, this.mCq, (long) this.mCr, (long) this.mCs));
        this.mCc.a(this.mCh);
        AppMethodBeat.o(235008);
    }

    public final int bKD() {
        return this.mCp;
    }

    public final int bKE() {
        return this.mCq;
    }

    public final int bKF() {
        return this.mCr;
    }

    /* access modifiers changed from: package-private */
    public final boolean available() {
        if (this.mCc != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final boolean isPlaying() {
        AppMethodBeat.i(235009);
        if (available()) {
            switch (this.mCc.ti()) {
                case 1:
                case 3:
                    boolean tj = this.mCc.tj();
                    AppMethodBeat.o(235009);
                    return tj;
                case 2:
                case 4:
                    if (this.mIsLooping) {
                        AppMethodBeat.o(235009);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.o(235009);
            return false;
        }
        AppMethodBeat.o(235009);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setDataSource(String str) {
        AppMethodBeat.i(235010);
        dU(str, null);
        AppMethodBeat.o(235010);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dU(String str, String str2) {
        AppMethodBeat.i(235011);
        this.mCf = a(Uri.parse(str), str2, "");
        this.mCt = 0;
        this.mAT = 1;
        AppMethodBeat.o(235011);
    }

    public final void dV(String str, String str2) {
        AppMethodBeat.i(235012);
        this.mCf = a(Uri.parse(str), (String) null, str2);
        this.mCt = 0;
        this.mAT = 1;
        AppMethodBeat.o(235012);
    }

    private k a(Uri uri, String str, String str2) {
        AppMethodBeat.i(235013);
        int q = q(uri);
        Map<String, String> aaG = com.tencent.mm.plugin.appbrand.jsapi.u.d.aaG(str);
        switch (q) {
            case 2:
                Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", uri);
                h hVar = new h(uri, g.a(this.mAppContext, aaG), this.mMainHandler, this.mCi);
                AppMethodBeat.o(235013);
                return hVar;
            case 3:
                Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", uri);
                if (str2 == null || str2.length() <= 0) {
                    com.google.android.exoplayer2.source.h hVar2 = new com.google.android.exoplayer2.source.h(uri, V(aaG), bKG(), this.mMainHandler, this.mCi);
                    AppMethodBeat.o(235013);
                    return hVar2;
                }
                Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_VIDEO_PRELOAD] buildMediaSource with cutomkey = %s", str2);
                com.google.android.exoplayer2.source.h hVar3 = new com.google.android.exoplayer2.source.h(uri, V(aaG), bKG(), this.mMainHandler, this.mCi, str2);
                AppMethodBeat.o(235013);
                return hVar3;
            default:
                Log.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + q + ", url:" + uri);
                AppMethodBeat.o(235013);
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public int q(Uri uri) {
        AppMethodBeat.i(235014);
        int i2 = 3;
        if (uri != null) {
            String uri2 = uri.toString();
            if (uri2.contains(".m3u8") || uri2.contains(".m3u")) {
                i2 = 2;
            }
        }
        AppMethodBeat.o(235014);
        return i2;
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.c.h bKG() {
        AppMethodBeat.i(235015);
        e eVar = new e();
        AppMethodBeat.o(235015);
        return eVar;
    }

    private g.a V(Map<String, String> map) {
        AppMethodBeat.i(235016);
        if (map == null && !j.bJE().mwX) {
            g.a aVar = null;
            if (com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
                aVar = ((com.tencent.mm.plugin.appbrand.jsapi.video.g) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).bJs();
            }
            if (aVar != null) {
                Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
                AppMethodBeat.o(235016);
                return aVar;
            }
        }
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
        g.a a2 = g.a(this.mAppContext, map);
        AppMethodBeat.o(235016);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(235017);
        if (available() && available()) {
            if (this.mSurface == null || this.mSurface == surface || surface == null) {
                a(2, 1, surface, false);
            } else {
                if (this.mCd) {
                    this.mSurface.release();
                }
                a(2, 1, surface, true);
                final long currentPosition = this.mCc.getCurrentPosition();
                if (x.SDK_INT < 23) {
                    this.mMainHandler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(234972);
                            if (f.this.available()) {
                                f.this.mCc.seekTo(currentPosition);
                            }
                            AppMethodBeat.o(234972);
                        }
                    }, 200);
                }
            }
            this.mSurface = surface;
            this.mCd = false;
        }
        AppMethodBeat.o(235017);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final boolean aP(float f2) {
        AppMethodBeat.i(235018);
        if (available()) {
            this.mCc.a(new p(f2, 1.0f));
            AppMethodBeat.o(235018);
            return true;
        }
        AppMethodBeat.o(235018);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setMute(boolean z) {
        AppMethodBeat.i(235019);
        if (available()) {
            if (z) {
                setVolume(0.0f, 0.0f);
                AppMethodBeat.o(235019);
                return;
            }
            setVolume(1.0f, 1.0f);
        }
        AppMethodBeat.o(235019);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setVolume(float f2, float f3) {
        AppMethodBeat.i(235020);
        cJ(Float.valueOf(f2));
        AppMethodBeat.o(235020);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setLooping(boolean z) {
        this.mIsLooping = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getDuration() {
        AppMethodBeat.i(235021);
        if (available()) {
            int duration = (int) this.mCc.getDuration();
            AppMethodBeat.o(235021);
            return duration;
        }
        AppMethodBeat.o(235021);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getCurrentPosition() {
        AppMethodBeat.i(235022);
        if (available()) {
            int currentPosition = (int) this.mCc.getCurrentPosition();
            AppMethodBeat.o(235022);
            return currentPosition;
        }
        AppMethodBeat.o(235022);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void prepareAsync() {
        AppMethodBeat.i(235023);
        if (this.mCf == null) {
            Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
            AppMethodBeat.o(235023);
            return;
        }
        if (available()) {
            this.mCc.aO(false);
            this.mCc.a(this.mCf);
            this.mCu = true;
        }
        AppMethodBeat.o(235023);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void start() {
        AppMethodBeat.i(235024);
        if (available()) {
            if (this.mCc.ti() == 4) {
                this.mCc.seekTo(0);
            }
            this.mCc.aO(true);
            this.mAT = 3;
            this.kQW.set(false);
        }
        AppMethodBeat.o(235024);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void pause() {
        AppMethodBeat.i(235025);
        if (available()) {
            this.mCc.aO(false);
            this.mAT = 3;
        }
        AppMethodBeat.o(235025);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void seekTo(long j2) {
        boolean z;
        AppMethodBeat.i(235026);
        if (available()) {
            this.mCc.seekTo(j2);
            C0715f fVar = this.mCe;
            if ((this.mCe.mCA[3] & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0) {
                z = true;
            } else {
                z = false;
            }
            fVar.q(z, 100);
            this.mCm.set(true);
        }
        AppMethodBeat.o(235026);
    }

    public final void k(long j2, boolean z) {
        AppMethodBeat.i(235027);
        if (available()) {
            this.mCc.seekTo(j2);
            this.mCe.q(z, 100);
        }
        AppMethodBeat.o(235027);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void stop() {
        AppMethodBeat.i(235028);
        if (available() && !this.kQW.getAndSet(true)) {
            this.mCc.aO(false);
            this.mCc.stop();
            this.mAT = 5;
        }
        AppMethodBeat.o(235028);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void reset() {
        AppMethodBeat.i(235029);
        if (available()) {
            hR(false);
            if (available()) {
                this.mCc.aO(false);
                this.mCc.stop();
            }
            this.mIsLooping = false;
            this.mCk = 0;
            this.mCe.mCA = new int[]{1, 1, 1, 1};
            this.mAT = 0;
        }
        AppMethodBeat.o(235029);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a, com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void release() {
        AppMethodBeat.i(235030);
        this.mAU = true;
        if (available()) {
            hR(false);
            if (available()) {
                this.mCc.release();
                this.mCc.b(this.mCh);
                this.mCc = null;
            }
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
            this.mCk = 0;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        if (this.mSurface != null) {
            if (this.mCd) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
        this.mAV = null;
        this.mAW = null;
        this.mAX = null;
        this.mAY = null;
        this.mAZ = null;
        this.mBa = null;
        this.mBb = null;
        this.mAT = -2;
        super.release();
        AppMethodBeat.o(235030);
    }

    /* access modifiers changed from: package-private */
    public final int getBufferedPercentage() {
        AppMethodBeat.i(235031);
        if (available()) {
            int bufferedPercentage = this.mCc.getBufferedPercentage();
            AppMethodBeat.o(235031);
            return bufferedPercentage;
        }
        AppMethodBeat.o(235031);
        return 0;
    }

    private void hR(boolean z) {
        AppMethodBeat.i(235032);
        Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(z)));
        if (!z || this.mBa == null) {
            this.mCj.mCE = false;
            AppMethodBeat.o(235032);
            return;
        }
        this.mCj.start();
        AppMethodBeat.o(235032);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean ej(int i2, int i3) {
        AppMethodBeat.i(235033);
        boolean ej = super.ej(i2, i3);
        this.mCv = true;
        this.mCt = 0;
        AppMethodBeat.o(235033);
        return ej;
    }

    /* access modifiers changed from: package-private */
    public class a implements k.b {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b.k.b
        public final void awp() {
            AppMethodBeat.i(234973);
            synchronized (f.this) {
                try {
                    if (!f.this.mAU) {
                        if (f.this.available()) {
                            switch (f.this.mCc.ti()) {
                                case 1:
                                case 4:
                                    f.a(f.this, false);
                                    break;
                                case 2:
                                case 3:
                                    int bufferedPercentage = f.this.getBufferedPercentage();
                                    if (bufferedPercentage != f.this.mCk) {
                                        f.this.xF(bufferedPercentage);
                                        f.this.mCk = bufferedPercentage;
                                        break;
                                    }
                                    break;
                            }
                        }
                        AppMethodBeat.o(234973);
                    }
                } finally {
                    AppMethodBeat.o(234973);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements com.google.android.exoplayer2.source.b, h.a {
        private c() {
        }

        /* synthetic */ c(f fVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(com.google.android.exoplayer2.h.j jVar, int i2, Format format, long j2, long j3, long j4) {
            AppMethodBeat.i(234974);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(234974);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void b(com.google.android.exoplayer2.h.j jVar, int i2, Format format, long j2, long j3, long j4) {
            AppMethodBeat.i(234975);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(234975);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void c(com.google.android.exoplayer2.h.j jVar, int i2, Format format, long j2, long j3, long j4) {
            AppMethodBeat.i(234976);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(234976);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(com.google.android.exoplayer2.h.j jVar, int i2, Format format, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            AppMethodBeat.i(234977);
            Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", iOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Boolean.valueOf(z));
            f.b(f.this);
            AppMethodBeat.o(234977);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(int i2, Format format, long j2) {
            AppMethodBeat.i(234978);
            Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", Integer.valueOf(i2), format, Long.valueOf(j2));
            f.this.abt(format.id);
            AppMethodBeat.o(234978);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void vl() {
            AppMethodBeat.i(234979);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
            AppMethodBeat.o(234979);
        }

        @Override // com.google.android.exoplayer2.source.h.a
        public final void onLoadError(IOException iOException) {
            AppMethodBeat.i(234980);
            Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", iOException, "onLoadError2, IOException", new Object[0]);
            f.b(f.this);
            AppMethodBeat.o(234980);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements f.a {
        private d() {
        }

        /* synthetic */ d(f fVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void ty() {
            AppMethodBeat.i(234981);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
            AppMethodBeat.o(234981);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tA() {
            AppMethodBeat.i(234982);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
            AppMethodBeat.o(234982);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tz() {
            AppMethodBeat.i(234983);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
            AppMethodBeat.o(234983);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void b(p pVar) {
            AppMethodBeat.i(234984);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPlaybackParametersChanged, params=[" + pVar.bdN + ", " + pVar.pitch + "]");
            AppMethodBeat.o(234984);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aA(int i2) {
            AppMethodBeat.i(234985);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onRepeatModeChanged, repeatMode=".concat(String.valueOf(i2)));
            AppMethodBeat.o(234985);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aR(boolean z) {
            AppMethodBeat.i(234986);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadingChanged, isLoading=".concat(String.valueOf(z)));
            if (z) {
                f.a(f.this, true);
            }
            AppMethodBeat.o(234986);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void c(boolean z, int i2) {
            AppMethodBeat.i(234987);
            Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayerStateChanged, playWhenReady=" + z + ", playbackState=" + i2);
            f.this.bKH();
            AppMethodBeat.o(234987);
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x0159  */
        @Override // com.google.android.exoplayer2.q.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.google.android.exoplayer2.e r9) {
            /*
            // Method dump skipped, instructions count: 390
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f.d.a(com.google.android.exoplayer2.e):void");
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e {
        private e() {
        }

        /* synthetic */ e(f fVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void c(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(234989);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
            AppMethodBeat.o(234989);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void dG(int i2) {
            AppMethodBeat.i(234990);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
            AppMethodBeat.o(234990);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void c(String str, long j2, long j3) {
            AppMethodBeat.i(234991);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
            AppMethodBeat.o(234991);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(Format format) {
            AppMethodBeat.i(234992);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
            AppMethodBeat.o(234992);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(int i2, long j2, long j3) {
            AppMethodBeat.i(234993);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
            AppMethodBeat.o(234993);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(234994);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
            AppMethodBeat.o(234994);
        }

        @Override // com.google.android.exoplayer2.metadata.e.a
        public final void b(Metadata metadata) {
            AppMethodBeat.i(234995);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
            AppMethodBeat.o(234995);
        }

        @Override // com.google.android.exoplayer2.f.j.a
        public final void s(List<com.google.android.exoplayer2.f.a> list) {
            AppMethodBeat.i(234996);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
            AppMethodBeat.o(234996);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void a(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(234997);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
            AppMethodBeat.o(234997);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void b(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(234998);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
            AppMethodBeat.o(234998);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void b(String str, long j2, long j3) {
            AppMethodBeat.i(234999);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
            AppMethodBeat.o(234999);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void c(Format format) {
            AppMethodBeat.i(235000);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
            AppMethodBeat.o(235000);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void h(int i2, long j2) {
            AppMethodBeat.i(235001);
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
            AppMethodBeat.o(235001);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void c(Surface surface) {
            AppMethodBeat.i(235002);
            Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
            f.this.ek(3, 0);
            AppMethodBeat.o(235002);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void a(int i2, int i3, int i4, float f2) {
            AppMethodBeat.i(235003);
            Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2));
            f.this.mVideoWidth = i2;
            f.this.mVideoHeight = i3;
            f.this.ei(i2, i3);
            AppMethodBeat.o(235003);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f$f  reason: collision with other inner class name */
    public static class C0715f {
        int[] mCA;

        private C0715f() {
            AppMethodBeat.i(235004);
            this.mCA = new int[]{1, 1, 1, 1};
            AppMethodBeat.o(235004);
        }

        /* synthetic */ C0715f(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void q(boolean z, int i2) {
            AppMethodBeat.i(235005);
            int r = r(z, i2);
            Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + z + "," + i2 + "], lastState=" + this.mCA[3] + ", newState=" + r);
            if (this.mCA[3] == r) {
                AppMethodBeat.o(235005);
                return;
            }
            this.mCA[0] = this.mCA[1];
            this.mCA[1] = this.mCA[2];
            this.mCA[2] = this.mCA[3];
            this.mCA[3] = r;
            Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.mCA[0] + "," + this.mCA[1] + "," + this.mCA[2] + "," + this.mCA[3] + "]");
            AppMethodBeat.o(235005);
        }

        static int r(boolean z, int i2) {
            return (z ? ShareElfFile.SectionHeader.SHF_MASKPROC : 0) | i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int[] iArr, boolean z) {
            int i2 = z ? 268435455 : -1;
            int length = this.mCA.length - iArr.length;
            boolean z2 = true;
            for (int i3 = length; i3 < this.mCA.length; i3++) {
                z2 &= (this.mCA[i3] & i2) == (iArr[i3 - length] & i2);
            }
            return z2;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void bKH() {
        AppMethodBeat.i(235034);
        if (this.mCc == null || this.mAU) {
            AppMethodBeat.o(235034);
        } else {
            int ti = this.mCc.ti();
            boolean tj = this.mCc.tj();
            int r = C0715f.r(tj, ti);
            if (r != this.mCe.mCA[3]) {
                Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + tj + "," + ti + "]");
                this.mCe.q(tj, ti);
                if (r == 3) {
                    hR(true);
                } else if (r == 1 || r == 4) {
                    hR(false);
                }
                if (r == C0715f.r(true, 4)) {
                    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, isSeeking: %b, loopingPlaySeek: %b", Boolean.valueOf(this.mCm.get()), Boolean.valueOf(this.mCl));
                    if (this.mCm.getAndSet(false) && !this.mCl) {
                        bKz();
                    }
                    if (this.mIsLooping) {
                        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
                        this.mCl = true;
                        seekTo(0);
                        AppMethodBeat.o(235034);
                    } else {
                        this.mAT = 6;
                        bKy();
                        AppMethodBeat.o(235034);
                    }
                } else {
                    if (this.mCe.a(new int[]{C0715f.r(false, 1), C0715f.r(false, 2), C0715f.r(false, 3)}, false)) {
                        this.mAT = 2;
                        bKx();
                        this.mCu = false;
                        AppMethodBeat.o(235034);
                    } else if ((this.mCe.a(new int[]{100, 2, 3}, true) | this.mCe.a(new int[]{2, 100, 3}, true)) || this.mCe.a(new int[]{100, 3, 2, 3}, true)) {
                        if (!this.mCl) {
                            bKz();
                        } else {
                            this.mCl = false;
                        }
                        this.mCm.set(false);
                        AppMethodBeat.o(235034);
                    } else {
                        if (this.mCe.a(new int[]{C0715f.r(true, 3), C0715f.r(true, 2)}, false)) {
                            ek(701, getBufferedPercentage());
                            AppMethodBeat.o(235034);
                        } else {
                            if (this.mCe.a(new int[]{C0715f.r(true, 2), C0715f.r(true, 3)}, false)) {
                                ek(702, getBufferedPercentage());
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(235034);
        }
    }

    private void cJ(Object obj) {
        AppMethodBeat.i(235035);
        a(1, 2, obj, false);
        AppMethodBeat.o(235035);
    }

    private void a(int i2, int i3, Object obj, boolean z) {
        AppMethodBeat.i(235036);
        if (this.mCg.isEmpty()) {
            AppMethodBeat.o(235036);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.mCg) {
            if (rVar.getTrackType() == i2) {
                arrayList.add(new f.c(rVar, i3, obj));
            }
        }
        if (z) {
            this.mCc.b((f.c[]) arrayList.toArray(new f.c[arrayList.size()]));
            AppMethodBeat.o(235036);
            return;
        }
        this.mCc.a((f.c[]) arrayList.toArray(new f.c[arrayList.size()]));
        AppMethodBeat.o(235036);
    }

    public static class b {
        public final boolean mCy;
        public final boolean mCz;

        public b(boolean z, boolean z2) {
            this.mCy = z;
            this.mCz = z2;
        }
    }

    public final b bKI() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(235037);
        if (this.mCu) {
            if (this.mCt > 0) {
                z = false;
                z2 = true;
            } else if (!this.mCv) {
                z = true;
                z2 = false;
            }
            Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "statErrorPlayerNotFound, hasLoadError: %b, hasOtherError: %b", Boolean.valueOf(z2), Boolean.valueOf(z));
            b bVar = new b(z2, z);
            AppMethodBeat.o(235037);
            return bVar;
        }
        z = false;
        z2 = false;
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "statErrorPlayerNotFound, hasLoadError: %b, hasOtherError: %b", Boolean.valueOf(z2), Boolean.valueOf(z));
        b bVar2 = new b(z2, z);
        AppMethodBeat.o(235037);
        return bVar2;
    }

    static /* synthetic */ void b(f fVar) {
        AppMethodBeat.i(235040);
        Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "dispatchOnErrorWorkaroundWhenLoadErrorIfNeed");
        fVar.mCt++;
        if (6 <= fVar.mCt && !g.isNetworkAvailable(fVar.mAppContext)) {
            Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "dispatchOnErrorWorkaroundWhenLoadErrorIfNeed, notifyOnError");
            fVar.ej(-4006, -2);
        }
        AppMethodBeat.o(235040);
    }
}
