package com.tencent.tmediacodec.b;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmediacodec.e.a;
import com.tencent.tmediacodec.g.d;
import com.tencent.tmediacodec.g.e;
import com.tencent.tmediacodec.hook.PreloadSurface;
import com.tencent.tmediacodec.hook.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkCoreWrapper;

public abstract class f implements c {
    private static final Map<Surface, f> SlQ = new ConcurrentHashMap();
    public b SlA = b.Started;
    public final e SlB;
    protected final b SlC;
    private String SlD = "";
    private boolean SlE;
    private a SlF = a.Uninitialized;
    private final a.EnumC2218a SlG;
    private final HashSet<Integer> SlH = new HashSet<>();
    private long SlI;
    private final ArrayList<Long> SlJ = new ArrayList<>();
    public com.tencent.tmediacodec.a.a SlK;
    private boolean SlL;
    private a.b SlM = a.b.KEEP_CODEC_RESULT_NO;
    private boolean SlN;
    private final Set<SurfaceTexture> SlO = new LinkedHashSet();
    private int[] SlP = new int[2];
    private boolean SlR = false;
    private boolean SlS = false;
    private int SlT = 0;
    public boolean aHN;
    public boolean bsX;
    public boolean bsY;
    private MediaCodecInfo.CodecCapabilities bsZ;
    private final MediaCodec btk;
    protected final String gJW;
    protected Surface mSurface;

    public abstract a.b a(e eVar);

    public static c a(MediaCodec mediaCodec, String str, e eVar) {
        return d.by(str) ? new g(mediaCodec, eVar) : new a(mediaCodec, eVar);
    }

    private boolean hpv() {
        return Thread.currentThread().getId() != this.SlI;
    }

    private final void setSurface(Surface surface) {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(", oldSurface:").append(this.mSurface).append(" CodecWrapperSetSurface surface:").append(surface);
            com.tencent.tmediacodec.g.b.bqR("ReuseCodecWrapper");
        }
        com.tencent.tmediacodec.hook.a.bqO(this.SlD);
        z(new HashSet(Collections.singletonList(this.SlD)));
        Surface surface2 = this.mSurface;
        try {
            if (surface2 instanceof PreloadSurface) {
                SurfaceTexture surfaceTexture = ((PreloadSurface) surface2).surfaceTexture;
                if (surfaceTexture instanceof com.tencent.tmediacodec.hook.b) {
                    this.SlO.add(surfaceTexture);
                }
                if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                    new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(surface2).append(" success");
                    com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
                }
            }
        } catch (Throwable th) {
            new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(surface2).append(" failed");
            com.tencent.tmediacodec.g.b.bqV("ReuseCodecWrapper");
        }
        this.mSurface = surface;
        this.SlD = "";
        if (surface != null) {
            this.SlD = d.n(surface);
        }
        bqN(this.SlD);
        if (surface != null) {
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                new StringBuilder().append(this).append(" checkSurfaceBinding size:").append(SlQ.size()).append(" mSurfaceMap:").append(SlQ);
                com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
            }
            if (SlQ.containsKey(surface)) {
                f fVar = SlQ.get(surface);
                boolean z = fVar != null && fVar.SlE;
                if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                    new StringBuilder().append(this).append(", surface:").append(surface).append(" has been used by ").append(fVar).append(" isReleaseCalled:").append(z).append(", ignore but we can release it...");
                    com.tencent.tmediacodec.g.b.bqU("ReuseCodecWrapper");
                }
                if (z) {
                    fVar.recycle();
                }
            }
            SlQ.put(surface, this);
            com.tencent.tmediacodec.hook.a.a(this.SlD, new c() {
                /* class com.tencent.tmediacodec.b.f.AnonymousClass1 */

                @Override // com.tencent.tmediacodec.hook.c
                public final void s(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(190120);
                    if (TextUtils.equals(f.this.SlD, surfaceTexture.toString())) {
                        f.this.SlO.add(surfaceTexture);
                        new StringBuilder().append(f.this).append("      surfaceDestroyed ... surfaceTexture:").append(surfaceTexture).append("     mStoreToRelease.size:").append(f.this.SlO.size());
                        com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
                    }
                    AppMethodBeat.o(190120);
                }
            });
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final a.b b(e eVar) {
        this.SlM = a(eVar);
        return this.SlM;
    }

    private final void bqN(String str) {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(", removeStoreSurfaceTexture nameSurfaceTexture:").append(str);
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        Iterator<SurfaceTexture> it = this.SlO.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().toString(), str)) {
                it.remove();
                return;
            }
        }
    }

    private void z(Set set) {
        d(set, Collections.emptySet());
    }

    private void d(Set set, Set set2) {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(", removeSurfaceBinding toReleaseNameSet:").append(set).append(" toReleaseCodecSet:").append(set2);
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        Iterator<Map.Entry<Surface, f>> it = SlQ.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Surface, f> next = it.next();
            String n = d.n(next.getKey());
            if (set.contains(n) || set2.contains(next.getValue())) {
                it.remove();
                com.tencent.tmediacodec.hook.a.bqO(n);
            }
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void hpt() {
        long id = Thread.currentThread().getId();
        if (!this.SlJ.contains(Long.valueOf(id))) {
            this.SlI = id;
            this.SlJ.add(Long.valueOf(this.SlI));
            if (this.SlJ.size() > 100) {
                this.SlJ.remove(0);
            }
        }
    }

    private void d(int i2, String str, Throwable th) {
        a(i2, str, th, false, this.mSurface);
    }

    private void a(int i2, String str, Throwable th, boolean z, Surface surface) {
        int m;
        this.SlR = true;
        String str2 = str + " handleCoreAPIException exception:" + (th == null ? "" : th.getLocalizedMessage());
        if (z && (m = m(surface)) != 0) {
            i2 = m;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i2);
            jSONObject.put("exceptionMsg", str2);
            if (this.SlK != null) {
                this.SlK.onReuseCodecAPIException(jSONObject.toString(), th);
            }
        } catch (JSONException e2) {
        }
        new StringBuilder("hasReused:").append(this.SlL).append("    errorCode:").append(i2).append(", ").append(str2);
        com.tencent.tmediacodec.g.b.bqV("ReuseCodecWrapper");
        asv(i2);
    }

    private void asv(int i2) {
        if (i2 < 40000) {
            new StringBuilder().append(this).append("    releaseCodecWhenError, errorCode:").append(i2);
            com.tencent.tmediacodec.g.b.bqU("ReuseCodecWrapper");
            release();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Eb(boolean z) {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(", releaseStoreSurfaceTexture mStoreToRelease:").append(this.SlO);
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        if (!this.SlO.isEmpty()) {
            final ArrayList arrayList = new ArrayList(this.SlO);
            this.SlO.clear();
            if (z) {
                e.execute(new Runnable() {
                    /* class com.tencent.tmediacodec.b.f.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(190121);
                        f.this.ke(arrayList);
                        AppMethodBeat.o(190121);
                    }
                });
            } else {
                ke(arrayList);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void ke(List<SurfaceTexture> list) {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(", releaseSurfaceTexture toReleaseSet:").append(list);
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (SurfaceTexture surfaceTexture : list) {
            com.tencent.tmediacodec.hook.a.t(surfaceTexture);
            linkedHashSet.add(surfaceTexture.toString());
        }
        z(linkedHashSet);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void a(com.tencent.tmediacodec.a.a aVar) {
        this.SlK = aVar;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final MediaCodec hps() {
        return this.btk;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        int i3 = 0;
        if (hpv()) {
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
            return;
        }
        this.SlN = true;
        this.SlE = false;
        if (this.SlF == a.Uninitialized) {
            try {
                if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                    String str = this + ", realConfigure mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:0" + " state:" + this.SlF + " mHasConfigureCalled：" + this.SlN;
                    com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
                }
                this.btk.configure(mediaFormat, surface, mediaCrypto, 0);
                setSurface(surface);
                this.SlF = a.Configured;
            } catch (Throwable th) {
                if (th instanceof IllegalStateException) {
                    i3 = 10000;
                } else if (th instanceof MediaCodec.CryptoException) {
                    i3 = 10001;
                }
                a(i3, null, th, true, surface);
                throw th;
            }
        } else if (surface != null) {
            this.SlP[0] = 0;
            this.SlP[1] = 0;
            c(surface, true);
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void start() {
        if (this.SlF != a.Configured) {
            new StringBuilder("start ignore:").append(this.SlF);
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
            return;
        }
        try {
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                String str = this + ", start state:" + this.SlF;
                com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
            }
            if (this.SlF == a.Configured) {
                this.btk.start();
                this.SlF = a.Running;
            }
        } catch (Throwable th) {
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i2 = 20001;
            } else if (th instanceof IllegalStateException) {
                i2 = g.sHCENCODEVIDEOTIMEOUT;
            }
            d(i2, null, th);
            throw th;
        }
    }

    @TargetApi(23)
    private void c(Surface surface, boolean z) {
        if (this.mSurface == surface) {
            new StringBuilder().append(this).append(", innerSetOutputSurface error surface:").append(surface).append(" is same, stack:").append(Log.getStackTraceString(new Throwable()));
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
            return;
        }
        String str = null;
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            str = this + " configure, call innerSetOutputSurface surface:" + surface + "  decodeState:" + this.SlA + " callByInner:" + z;
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        try {
            setSurface(surface);
            this.btk.setOutputSurface(surface);
            Eb(true);
        } catch (Throwable th) {
            int i2 = 0;
            if (th instanceof IllegalStateException) {
                i2 = CommonUtils.MAX_TIMEOUT_MS;
            } else if (th instanceof IllegalArgumentException) {
                i2 = CdnLogic.kMediaLittleAppPacket;
            }
            a(i2, str, th, true, surface);
            throw th;
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    @TargetApi(23)
    public final void setOutputSurface(Surface surface) {
        c(surface, false);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void stop() {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(", stop");
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        if (!hpw()) {
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                new StringBuilder().append(this).append(", codec real stop");
                com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
            }
            this.btk.stop();
            this.SlF = a.Uninitialized;
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void release() {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(" call release mHoldBufferOutIndex:").append(this.SlH).append(" mReleaseCalled:").append(this.SlE).append(" stack:").append(Log.getStackTraceString(new Throwable()));
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        this.SlE = true;
        this.SlN = false;
        if (hpw()) {
            flush();
            com.tencent.tmediacodec.a.hpn().b(this);
            return;
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder("Don't not keep the codec, release it ..., mErrorHappened:").append(this.SlR);
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
        }
        com.tencent.tmediacodec.a.hpn().a(this);
        recycle();
        this.SlF = a.Released;
    }

    public final void recycle() {
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder().append(this).append(", recycle isRecycled:").append(this.aHN).append(" ...... stack:").append(Log.getStackTraceString(new Throwable()));
            com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        this.SlN = false;
        this.aHN = true;
        d(Collections.emptySet(), Collections.singleton(this));
        e.runOnSubThread(new Runnable() {
            /* class com.tencent.tmediacodec.b.f.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(190122);
                try {
                    f.this.btk.stop();
                    try {
                        f.this.btk.release();
                        f.this.Eb(false);
                    } catch (Throwable th) {
                        com.tencent.tmediacodec.g.b.bqT("ReuseCodecWrapper");
                    }
                    if (f.this.SlK != null) {
                        f.this.SlK.onRealRelease();
                    }
                    AppMethodBeat.o(190122);
                } catch (Throwable th2) {
                    f.this.btk.release();
                    AppMethodBeat.o(190122);
                    throw th2;
                }
            }
        });
        if (this.mSurface != null) {
            SlQ.remove(this.mSurface);
        }
        this.SlF = a.Uninitialized;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final int dequeueInputBuffer(long j2) {
        int i2 = 0;
        if (hpv()) {
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
            return -1;
        }
        try {
            int dequeueInputBuffer = this.btk.dequeueInputBuffer(j2);
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                String str = this + ", dequeueInputBuffer state:" + this.SlF + " decodeState:" + this.SlA + " , result=" + dequeueInputBuffer;
                com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
            }
            this.SlA = b.DequeueIn;
            this.SlF = a.Running;
            mL(0, dequeueInputBuffer);
            return dequeueInputBuffer;
        } catch (Throwable th) {
            if (th instanceof IllegalStateException) {
                i2 = 40000;
            } else if (th instanceof IllegalArgumentException) {
                i2 = CdnLogic.kMediaTypeStoryAudio;
            }
            d(i2, null, th);
            throw th;
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void a(int i2, int i3, long j2, int i4) {
        String str;
        int i5;
        if (hpv()) {
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
            return;
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
            str = this + ", queueInputBuffer index:" + i2 + " offset:0 size:" + i3 + " presentationTimeUs:" + j2 + ' ' + "flags:" + i4 + " state:" + this.SlF + " decodeState:" + this.SlA;
        } else {
            str = null;
        }
        try {
            if (this.SlL) {
                switch (this.SlM) {
                    case KEEP_CODEC_RESULT_NO:
                        com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
                        break;
                    case KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION:
                        this.btk.queueInputBuffer(i2, 0, i3, j2, i4);
                        break;
                    case KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION:
                        this.btk.queueInputBuffer(i2, 0, i3, j2, i4);
                        break;
                }
            } else {
                this.btk.queueInputBuffer(i2, 0, i3, j2, i4);
            }
            this.SlA = b.QueueIn;
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i5 = XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY;
            } else if (th instanceof IllegalStateException) {
                i5 = SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
            } else if (th instanceof MediaCodec.CryptoException) {
                i5 = XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT;
            } else {
                i5 = 0;
            }
            d(i5, str, th);
            throw th;
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j2) {
        if (hpv()) {
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
            return -1;
        }
        try {
            int dequeueOutputBuffer = this.btk.dequeueOutputBuffer(bufferInfo, j2);
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                String str = this + ", dequeueOutputBuffer outIndex:" + dequeueOutputBuffer;
                if (this instanceof g) {
                    com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
                }
            }
            this.SlH.add(Integer.valueOf(dequeueOutputBuffer));
            this.SlA = b.DequeueOut;
            mL(1, dequeueOutputBuffer);
            return dequeueOutputBuffer;
        } catch (Throwable th) {
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i2 = 60001;
            } else if (th instanceof IllegalStateException) {
                i2 = 60000;
            }
            d(i2, null, th);
            throw th;
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void flush() {
        if (hpv()) {
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
        }
        try {
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                String str = this + ", flush state:" + this.SlF;
                com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
            }
            this.btk.flush();
            this.SlF = a.Flushed;
        } catch (Throwable th) {
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i2 = 90001;
            } else if (th instanceof IllegalStateException) {
                i2 = 90000;
            }
            d(i2, null, th);
            throw th;
        }
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void releaseOutputBuffer(int i2, boolean z) {
        String str;
        if (hpv()) {
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
            return;
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
            str = this + ", releaseOutputBuffer render:" + z;
        } else {
            str = null;
        }
        try {
            this.SlH.remove(Integer.valueOf(i2));
            this.btk.releaseOutputBuffer(i2, z);
        } catch (Throwable th) {
            if (this.SlF != a.Flushed) {
                new StringBuilder().append(this).append(", releaseOutputBuffer failed, ignore e:");
                com.tencent.tmediacodec.g.b.bqT("ReuseCodecWrapper");
            }
            int i3 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i3 = 70002;
            } else if (th instanceof IllegalStateException) {
                i3 = 70001;
            }
            d(i3, str, th);
        }
        this.SlA = b.ReleaseOut;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void hpu() {
        this.SlS = false;
        this.SlT = 0;
        if (this.SlF != a.Flushed) {
            flush();
        }
        this.SlL = true;
    }

    public boolean hpw() {
        return !this.SlR && com.tencent.tmediacodec.a.hpn().Slc;
    }

    public String toString() {
        return super.toString() + " mReleaseCalled:" + this.SlE + " isRecycled:" + this.aHN;
    }

    public final void hpx() {
        this.SlT++;
    }

    public final boolean hpy() {
        return this.SlT >= 3;
    }

    public f(MediaCodec mediaCodec, e eVar) {
        a.EnumC2218a aVar;
        boolean z = true;
        this.btk = mediaCodec;
        this.SlB = eVar;
        this.SlC = new b(eVar.maxWidth, eVar.maxHeight, eVar.bdr);
        this.gJW = d.a(this.btk);
        String str = this.gJW;
        if (Build.VERSION.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure" == str && (Build.MODEL.startsWith("SM-T585") || Build.MODEL.startsWith("SM-A510") || Build.MODEL.startsWith("SM-A520") || Build.MODEL.startsWith("SM-J700"))) {
            aVar = a.EnumC2218a.ADAPTATION_WORKAROUND_MODE_ALWAYS;
        } else if (Build.VERSION.SDK_INT >= 24 || !(("OMX.Nvidia.h264.decode" == str || "OMX.Nvidia.h264.decode.secure" == str) && ("flounder" == Build.DEVICE || "flounder_lte" == Build.DEVICE || "grouper" == Build.DEVICE || "tilapia" == Build.DEVICE))) {
            aVar = a.EnumC2218a.ADAPTATION_WORKAROUND_MODE_NEVER;
        } else {
            aVar = a.EnumC2218a.ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;
        }
        this.SlG = aVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bsZ = this.btk.getCodecInfo().getCapabilitiesForType(eVar.bdq);
        }
        this.bsX = this.bsZ != null && d.a(this.bsZ);
        this.bsY = (this.bsZ == null || !d.b(this.bsZ)) ? false : z;
    }

    public final String hpz() {
        return this.gJW;
    }

    private void mL(int i2, int i3) {
        if (!this.SlS && mM(i2, i3)) {
            this.SlS = true;
            String str = this + ", trackDecodeApi state:" + this.SlF + "  surfaceState:" + (this.mSurface != null ? Boolean.valueOf(this.mSurface.isValid()) : null);
            if (i2 == 0) {
                d(40002, str, null);
            } else if (i2 == 1) {
                d(60002, str, null);
            }
        }
    }

    private boolean mM(int i2, int i3) {
        if (i3 == -1) {
            int[] iArr = this.SlP;
            iArr[i2] = iArr[i2] + 1;
            if (this.SlP[i2] > 100) {
                return true;
            }
            return false;
        }
        this.SlP[i2] = 0;
        return false;
    }

    private static int m(Surface surface) {
        if (surface == null) {
            return ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;
        }
        if (!surface.isValid()) {
            return ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL;
        }
        return 0;
    }

    public enum a {
        Uninitialized,
        Configured,
        Error,
        Flushed,
        Running,
        EndOfStream,
        Released;

        public static a valueOf(String str) {
            AppMethodBeat.i(190125);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(190125);
            return aVar;
        }

        static {
            AppMethodBeat.i(190126);
            AppMethodBeat.o(190126);
        }
    }

    public enum b {
        Started,
        DequeueIn,
        QueueIn,
        DequeueOut,
        ReleaseOut;

        public static b valueOf(String str) {
            AppMethodBeat.i(190128);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(190128);
            return bVar;
        }

        static {
            AppMethodBeat.i(190129);
            AppMethodBeat.o(190129);
        }
    }
}
