package com.tencent.mm.plugin.vlog.remux;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.a.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.plugin.vlog.remux.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class d implements com.tencent.mm.plugin.recordvideo.background.c.c {
    public static final a GDf = new a((byte) 0);
    private final ah GBQ;
    private b GCX;
    private final com.tencent.mm.media.b.d GCY = new com.tencent.mm.media.b.d();
    private volatile boolean GCZ;
    private volatile boolean GDa;
    private r<? super String, ? super String, ? super Boolean, ? super Integer, x> GDb;
    private boolean GDc;
    private Point GDd;
    private af GDe;
    private final int bufId = SightVideoJNI.initDataBufferForRemux(false);
    private int frameCount;
    private long gXF;
    private com.tencent.mm.media.e.b ihT;
    private com.tencent.mm.media.a.a ihV;
    private com.tencent.mm.media.i.i ihX;
    private com.tencent.mm.media.f.a ihY;
    private HandlerThread iia;
    private HandlerThread iib;
    private String iiv;
    private Rect iiw;
    private boolean isb;
    private float mLi = 1.0f;
    private float mLj = 1.0f;
    private String thumbPath;

    static {
        AppMethodBeat.i(111088);
        AppMethodBeat.o(111088);
    }

    public static final class c extends q implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x> {
        final /* synthetic */ d GDg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar) {
            super(3);
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
            AppMethodBeat.i(111069);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            MediaFormat mediaFormat2 = mediaFormat;
            p.h(byteBuffer2, "buffer");
            p.h(bufferInfo2, "bufferInfo");
            p.h(mediaFormat2, "format");
            this.GDg.ihX.a(byteBuffer2, bufferInfo2, mediaFormat2);
            x xVar = x.SXb;
            AppMethodBeat.o(111069);
            return xVar;
        }
    }

    public static final class e extends q implements m<Long, Integer, x> {
        final /* synthetic */ d GDg;
        final /* synthetic */ com.tencent.mm.media.e.b GDh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(com.tencent.mm.media.e.b bVar, d dVar) {
            super(2);
            this.GDh = bVar;
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Integer num) {
            AppMethodBeat.i(111071);
            long longValue = l.longValue();
            int intValue = num.intValue();
            Log.i("MicroMsg.VLogRemuxer", "on frame decode, pts:" + longValue + ", frameCount:" + intValue + ", remuxForThumb:" + this.GDg.GDc);
            if (intValue != 0) {
                this.GDh.aMl();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111071);
            return xVar;
        }
    }

    public static final class f extends q implements m<IntBuffer, Integer, x> {
        final /* synthetic */ d GDg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar) {
            super(2);
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(IntBuffer intBuffer, Integer num) {
            AppMethodBeat.i(111073);
            IntBuffer intBuffer2 = intBuffer;
            int intValue = num.intValue();
            p.h(intBuffer2, "buffer");
            Log.i("MicroMsg.VLogRemuxer", "on snapshot callback, buffer:" + intBuffer2 + ", frameCount:" + intValue);
            if (this.GDg.GDc && intValue > 0) {
                intBuffer2.position(0);
                Bitmap createBitmap = Bitmap.createBitmap(this.GDg.GDe.targetWidth, this.GDg.GDe.targetHeight, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(intBuffer2);
                BitmapUtil.saveBitmapToImage(createBitmap, 60, Bitmap.CompressFormat.JPEG, this.GDg.thumbPath, true);
                StringBuilder append = new StringBuilder("remuxForThumb finish, thumbPath:").append(this.GDg.thumbPath).append(", thumb:[");
                p.g(createBitmap, "thumb");
                Log.i("MicroMsg.VLogRemuxer", append.append(createBitmap.getWidth()).append(", ").append(createBitmap.getHeight()).append(']').toString());
                this.GDg.GDc = false;
                this.GDg.release();
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.vlog.remux.d.f.AnonymousClass1 */
                    final /* synthetic */ f GDi;

                    {
                        this.GDi = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(111072);
                        r rVar = this.GDi.GDg.GDb;
                        if (rVar != null) {
                            rVar.invoke("", this.GDi.GDg.thumbPath, Boolean.TRUE, -1);
                            AppMethodBeat.o(111072);
                            return;
                        }
                        AppMethodBeat.o(111072);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111073);
            return xVar;
        }
    }

    public static final class g extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ com.tencent.mm.media.e.b GDh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(com.tencent.mm.media.e.b bVar) {
            super(1);
            this.GDh = bVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(111074);
            l.longValue();
            this.GDh.aMi();
            x xVar = x.SXb;
            AppMethodBeat.o(111074);
            return xVar;
        }
    }

    public static final class h extends q implements kotlin.g.a.b<com.tencent.mm.media.e.b, x> {
        final /* synthetic */ d GDg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(d dVar) {
            super(1);
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.e.b bVar) {
            AppMethodBeat.i(111077);
            com.tencent.mm.media.e.b bVar2 = bVar;
            p.h(bVar2, "iMediaCodecTransEncoder");
            bVar2.ifb = new m<ByteBuffer, MediaCodec.BufferInfo, x>(this) {
                /* class com.tencent.mm.plugin.vlog.remux.d.h.AnonymousClass1 */
                final /* synthetic */ h GDj;

                {
                    this.GDj = r2;
                }

                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
                    AppMethodBeat.i(111075);
                    ByteBuffer byteBuffer2 = byteBuffer;
                    MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
                    p.h(byteBuffer2, "byteBuffer");
                    p.h(bufferInfo2, "bufferInfo");
                    StringBuilder append = new StringBuilder("writeH264Data  ,bufferInfo.size : ").append(bufferInfo2.size).append("  frameCount :");
                    d dVar = this.GDj.GDg;
                    int i2 = dVar.frameCount;
                    dVar.frameCount = i2 + 1;
                    Log.i("MicroMsg.VLogRemuxer", append.append(i2).append("  presentationTimeUs:").append(bufferInfo2.presentationTimeUs).toString());
                    this.GDj.GDg.ihX.g(byteBuffer2, bufferInfo2);
                    x xVar = x.SXb;
                    AppMethodBeat.o(111075);
                    return xVar;
                }
            };
            bVar2.ifc = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.vlog.remux.d.h.AnonymousClass2 */
                final /* synthetic */ h GDj;

                {
                    this.GDj = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(111076);
                    Log.i("MicroMsg.VLogRemuxer", "video onEncodeEnd");
                    com.tencent.mm.media.e.b bVar = this.GDj.GDg.ihT;
                    if (bVar != null) {
                        bVar.aMj();
                    }
                    this.GDj.GDg.GDa = true;
                    d.g(this.GDj.GDg);
                    x xVar = x.SXb;
                    AppMethodBeat.o(111076);
                    return xVar;
                }
            };
            bVar2.iex = true;
            x xVar = x.SXb;
            AppMethodBeat.o(111077);
            return xVar;
        }
    }

    public d(ah ahVar, af afVar) {
        p.h(ahVar, "scriptModel");
        p.h(afVar, "remuxModel");
        AppMethodBeat.i(111087);
        this.GBQ = ahVar;
        this.GDe = afVar;
        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        this.thumbPath = com.tencent.mm.plugin.recordvideo.e.c.aLI(this.GDe.rpE);
        this.GCY.bitrate = this.GDe.videoBitrate;
        this.GCY.frameRate = this.GDe.frameRate;
        this.GCY.targetHeight = this.GDe.targetHeight;
        this.GCY.targetWidth = this.GDe.targetWidth;
        this.ihX = new com.tencent.mm.media.i.i(0, ((s) kotlin.a.j.ku(this.GBQ.GzQ)).endTime, this.GDe.videoBitrate, false);
        Log.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.GCY + ' ');
        Log.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.GDe + ' ');
        AppMethodBeat.o(111087);
    }

    public static final /* synthetic */ void g(d dVar) {
        AppMethodBeat.i(111091);
        dVar.fCs();
        AppMethodBeat.o(111091);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void aUg(String str) {
        AppMethodBeat.i(111080);
        Log.i("MicroMsg.VLogRemuxer", "setMusicPath path");
        this.iiv = str;
        AppMethodBeat.o(111080);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.c.c
    public final void e(r<? super String, ? super String, ? super Boolean, ? super Integer, x> rVar) {
        AppMethodBeat.i(111081);
        Log.i("MicroMsg.VLogRemuxer", "start");
        this.GDb = rVar;
        this.gXF = Util.currentTicks();
        HandlerThread handlerThread = this.iib;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.iib = com.tencent.mm.ac.d.a("VLogRemuxer_remuxVideo", false, (kotlin.g.a.a) new i(this));
        HandlerThread handlerThread2 = this.iia;
        if (handlerThread2 != null) {
            handlerThread2.quit();
        }
        this.iia = com.tencent.mm.ac.d.a("VLogRemuxer_remuxMusic", false, (kotlin.g.a.a) new j(this));
        AppMethodBeat.o(111081);
    }

    public final void jw(int i2, int i3) {
        AppMethodBeat.i(111083);
        if (this.GDd != null) {
            Point point = this.GDd;
            if (point == null) {
                p.hyc();
            }
            if (point.x > 0) {
                Point point2 = this.GDd;
                if (point2 == null) {
                    p.hyc();
                }
                if (point2.y > 0) {
                    float f2 = (float) i2;
                    Point point3 = this.GDd;
                    if (point3 == null) {
                        p.hyc();
                    }
                    this.mLi = f2 / ((float) point3.x);
                    float f3 = (float) i3;
                    Point point4 = this.GDd;
                    if (point4 == null) {
                        p.hyc();
                    }
                    this.mLj = f3 / ((float) point4.y);
                    Log.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + i2 + ", " + i3 + "], scale:[" + this.mLi + ", " + this.mLj + ']');
                    AppMethodBeat.o(111083);
                }
            }
        }
        this.mLi = ((float) i2) / ((float) this.GDe.targetWidth);
        this.mLj = ((float) i3) / ((float) this.GDe.targetHeight);
        Log.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + i2 + ", " + i3 + "], scale:[" + this.mLi + ", " + this.mLj + ']');
        AppMethodBeat.o(111083);
    }

    private final void fCs() {
        boolean z = false;
        AppMethodBeat.i(111084);
        if (this.GCZ && this.GDa) {
            int a2 = this.ihX.a(null, this.GDe.rpE, this.GDe.audioSampleRate, this.GDe.audioChannelCount, false);
            if (a2 >= 0) {
                z = true;
            }
            Log.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + Util.ticksToNow(this.gXF) + ",succ:" + z + "  result:" + a2 + ", path:" + this.GDe + ".outputPath");
            release();
            if (z) {
                SightVideoJNI.optimizeMP4VFS(this.GDe.rpE);
                com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.jG(this.GDe.rpE, this.thumbPath);
            }
            r<? super String, ? super String, ? super Boolean, ? super Integer, x> rVar = this.GDb;
            if (rVar != null) {
                rVar.invoke(this.GDe.rpE, this.thumbPath, Boolean.valueOf(z), -1);
                AppMethodBeat.o(111084);
                return;
            }
        }
        AppMethodBeat.o(111084);
    }

    public final void release() {
        AppMethodBeat.i(111085);
        Log.i("MicroMsg.VLogRemuxer", "release");
        cancel();
        this.ihX.release();
        AppMethodBeat.o(111085);
    }

    private final void cancel() {
        AppMethodBeat.i(111086);
        b bVar = this.GCX;
        if (bVar != null) {
            bVar.release();
        }
        com.tencent.mm.media.e.b bVar2 = this.ihT;
        if (bVar2 != null) {
            bVar2.aMj();
        }
        HandlerThread handlerThread = this.iib;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        HandlerThread handlerThread2 = this.iia;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
            AppMethodBeat.o(111086);
            return;
        }
        AppMethodBeat.o(111086);
    }

    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d GDg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(d dVar) {
            super(0);
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(111078);
            d dVar = this.GDg;
            int unused = this.GDg.bufId;
            d.a(dVar);
            x xVar = x.SXb;
            AppMethodBeat.o(111078);
            return xVar;
        }
    }

    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d GDg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(d dVar) {
            super(0);
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(111079);
            d.a(this.GDg, this.GDg.bufId);
            x xVar = x.SXb;
            AppMethodBeat.o(111079);
            return xVar;
        }
    }

    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d GDg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(111068);
            d dVar = this.GDg;
            int unused = this.GDg.bufId;
            d.a(dVar);
            x xVar = x.SXb;
            AppMethodBeat.o(111068);
            return xVar;
        }
    }

    /* renamed from: com.tencent.mm.plugin.vlog.remux.d$d */
    public static final class C1856d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d GDg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1856d(d dVar) {
            super(0);
            this.GDg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(111070);
            com.tencent.mm.media.a.a aVar = this.GDg.ihV;
            if (aVar != null) {
                aVar.aLO();
            }
            com.tencent.mm.media.f.a aVar2 = this.GDg.ihY;
            if (aVar2 != null) {
                aVar2.release();
            }
            this.GDg.GCZ = true;
            d.g(this.GDg);
            x xVar = x.SXb;
            AppMethodBeat.o(111070);
            return xVar;
        }
    }

    public static /* synthetic */ void a(d dVar, r rVar) {
        AppMethodBeat.i(111082);
        dVar.GDb = rVar;
        dVar.GDc = true;
        Log.i("MicroMsg.VLogRemuxer", "thumbPath : " + dVar.thumbPath);
        HandlerThread handlerThread = dVar.iib;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        dVar.iib = com.tencent.mm.ac.d.a("VLogRemuxer_remuxVideo", false, (kotlin.g.a.a) new b(dVar));
        AppMethodBeat.o(111082);
    }

    public static final /* synthetic */ void a(d dVar) {
        int i2;
        int i3;
        b bVar;
        com.tencent.mm.media.e.b eVar;
        AppMethodBeat.i(111089);
        h hVar = new h(dVar);
        try {
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                eVar = new com.tencent.mm.media.e.f(dVar.GCY, hVar);
            } else {
                eVar = new com.tencent.mm.media.e.e(dVar.GCY, hVar);
            }
            dVar.ihT = eVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VLogRemuxer", e2, "remux error", new Object[0]);
            dVar.cancel();
            r<? super String, ? super String, ? super Boolean, ? super Integer, x> rVar = dVar.GDb;
            if (rVar != null) {
                rVar.invoke("", "", Boolean.FALSE, 3);
            }
        }
        com.tencent.mm.media.e.b bVar2 = dVar.ihT;
        if (bVar2 != null) {
            Surface inputSurface = bVar2.getInputSurface();
            Point point = dVar.GDd;
            if (point != null) {
                i2 = point.x;
            } else {
                i2 = dVar.GDe.targetWidth;
            }
            Point point2 = dVar.GDd;
            if (point2 != null) {
                i3 = point2.y;
            } else {
                i3 = dVar.GDe.targetHeight;
            }
            dVar.GCX = new b(inputSurface, dVar.GDe.targetWidth, dVar.GDe.targetHeight, i2, i3, dVar.GDe.GzL, dVar.GCY.frameRate, dVar.mLi, dVar.mLj, dVar.GBQ, new e(bVar2, dVar), new g(bVar2));
            if (dVar.GDc && (bVar = dVar.GCX) != null) {
                bVar.GCP.GBs = new b.c(bVar, new f(dVar));
            }
            b bVar3 = dVar.GCX;
            if (bVar3 != null) {
                bVar3.GCP.setCropRect(dVar.iiw);
            }
            b bVar4 = dVar.GCX;
            if (bVar4 != null) {
                boolean z = dVar.GDc;
                Log.i("MicroMsg.VLogDecoder", "startDecode, withSnapshot:".concat(String.valueOf(z)));
                bVar4.GCR = z;
                com.tencent.mm.plugin.vlog.player.c.a(bVar4.GCP, bVar4.ihf.invoke(0L), z, 4);
                AppMethodBeat.o(111089);
                return;
            }
            AppMethodBeat.o(111089);
            return;
        }
        AppMethodBeat.o(111089);
    }

    public static final /* synthetic */ void a(d dVar, int i2) {
        MediaFormat mediaFormat;
        com.tencent.mm.media.d.h hVar;
        AppMethodBeat.i(111090);
        if (dVar.GDe.audioChannelCount <= 0) {
            dVar.GDe.audioChannelCount = 1;
        }
        if (dVar.GDe.audioSampleRate <= 0) {
            dVar.GDe.audioSampleRate = 44100;
        }
        if (!com.tencent.mm.vfs.s.YS(dVar.iiv)) {
            Log.i("MicroMsg.VLogRemuxer", "local has no music ,musicPath:" + dVar.iiv + "  and set Mute");
            dVar.GCZ = true;
            dVar.isb = true;
            AppMethodBeat.o(111090);
        } else if (dVar.GDe.GzM == 0) {
            Log.i("MicroMsg.VLogRemuxer", "mix silent, ignore remuxMusic");
            dVar.GCZ = true;
            dVar.isb = true;
            AppMethodBeat.o(111090);
        } else {
            MediaFormat mediaFormat2 = null;
            Log.i("MicroMsg.VLogRemuxer", "remuxMusic, mixType:" + dVar.GDe.GzM + " musicPath:" + dVar.iiv);
            String str = dVar.iiv;
            if (str != null) {
                com.tencent.mm.media.f.a aVar = new com.tencent.mm.media.f.a(str);
                if (aVar.igl) {
                    com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aOy();
                    Log.e("MicroMsg.VLogRemuxer", "markRemuxMusicMediaExtractorCreateFailed");
                    dVar.GCZ = true;
                    dVar.isb = true;
                    dVar.cancel();
                    r<? super String, ? super String, ? super Boolean, ? super Integer, x> rVar = dVar.GDb;
                    if (rVar != null) {
                        rVar.invoke("", "", Boolean.FALSE, 2);
                        AppMethodBeat.o(111090);
                        return;
                    }
                    AppMethodBeat.o(111090);
                    return;
                }
                dVar.ihY = aVar;
                com.tencent.mm.media.f.a aVar2 = dVar.ihY;
                if (aVar2 != null) {
                    mediaFormat2 = aVar2.igi;
                } else {
                    mediaFormat2 = null;
                }
            }
            a aVar3 = new a(dVar.GBQ.GzQ);
            if (dVar.GDe.GzM == 1) {
                Log.i("MicroMsg.VLogRemuxer", "mix background, delete musicFile:" + dVar.iiv);
                com.tencent.mm.vfs.s.deleteFile(dVar.iiv);
                dVar.iiv = null;
                com.tencent.mm.media.f.a aVar4 = dVar.ihY;
                if (aVar4 != null) {
                    aVar4.release();
                }
                dVar.ihY = null;
                mediaFormat = aVar3.GCx;
            } else {
                mediaFormat = mediaFormat2;
            }
            if (dVar.GDe.GzM == 3) {
                if (aVar3.fCr()) {
                    Log.i("MicroMsg.VLogRemuxer", "has video mix all");
                    dVar.GDe.GzM = 3;
                } else {
                    Log.i("MicroMsg.VLogRemuxer", "do not have video mix music");
                    dVar.GDe.GzM = 2;
                }
            }
            dVar.ihV = new com.tencent.mm.media.a.a(i2, dVar.GDe.GzM, dVar.GDe.audioSampleRate, dVar.GDe.audioChannelCount, new c(dVar));
            if (dVar.GDe.GzM == 2) {
                com.tencent.mm.media.a.a aVar5 = dVar.ihV;
                if (aVar5 != null) {
                    aVar5.a((com.tencent.mm.media.f.a) null, dVar.ihY, 0, (long) dVar.GDe.GzL);
                }
                aVar3.aMc();
            } else {
                com.tencent.mm.media.a.a aVar6 = dVar.ihV;
                if (aVar6 != null) {
                    a aVar7 = aVar3;
                    com.tencent.mm.media.f.a aVar8 = dVar.ihY;
                    long j2 = (long) dVar.GDe.GzL;
                    Log.i(aVar6.TAG, "initWithBackgroundDecoder, backgroundDecoder:" + aVar7 + ", music:" + aVar8 + ", startTime:0, endTime:" + j2);
                    try {
                        aVar6.icX = aVar7;
                        com.tencent.mm.media.d.e eVar2 = aVar6.icX;
                        if (eVar2 != null) {
                            eVar2.iej = new a.q(aVar6);
                        }
                        com.tencent.mm.media.d.e eVar3 = aVar6.icX;
                        if (eVar3 != null) {
                            eVar3.iek = new a.r(aVar6);
                        }
                        if (aVar8 != null) {
                            if (com.tencent.mm.compatible.util.d.oE(23)) {
                                hVar = new com.tencent.mm.media.d.g(aVar8, "music", 0, j2 - 0, new a.s(aVar6), new a.t(aVar6));
                            } else {
                                aVar6.idn = true;
                                hVar = new com.tencent.mm.media.d.h(aVar8, "music", 0, j2 - 0, new a.u(aVar6), new a.v(aVar6));
                            }
                            aVar6.icW = hVar;
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace(aVar6.TAG, e2, "", new Object[0]);
                        com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aOD();
                        Exception exc = e2;
                        AppMethodBeat.o(111090);
                        throw exc;
                    }
                }
            }
            boolean z = false;
            if (mediaFormat != null && !mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) {
                mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, dVar.GDe.audioBitrate);
            }
            if (mediaFormat != null) {
                mediaFormat.setInteger("channel-count", dVar.GDe.audioChannelCount);
            }
            if (mediaFormat != null) {
                com.tencent.mm.media.a.a aVar9 = dVar.ihV;
                if (aVar9 != null) {
                    aVar9.c(mediaFormat);
                }
                z = true;
            }
            if (z) {
                com.tencent.mm.media.a.a aVar10 = dVar.ihV;
                if (aVar10 != null) {
                    aVar10.p(new C1856d(dVar));
                    AppMethodBeat.o(111090);
                    return;
                }
                AppMethodBeat.o(111090);
                return;
            }
            Log.e("MicroMsg.VLogRemuxer", "remuxMusic cannot init encoder, return");
            com.tencent.mm.media.f.a aVar11 = dVar.ihY;
            if (aVar11 != null) {
                aVar11.release();
            }
            dVar.GCZ = true;
            dVar.fCs();
            AppMethodBeat.o(111090);
        }
    }
}
