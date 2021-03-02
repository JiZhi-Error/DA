package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.g;
import com.tencent.mm.media.d.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tav.decoder.EncoderWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0006\u0010!\u001a\u00020\"J*\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020\u001cH\u0016J,\u0010+\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010.H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", FirebaseAnalytics.b.INDEX, "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"})
public final class a extends com.tencent.mm.media.d.e {
    public static final c GCD = new c((byte) 0);
    private long GCA = 23;
    private long GCB = -1;
    private long GCC;
    private ArrayList<d> GCs = new ArrayList<>();
    private volatile int GCt;
    private volatile int GCu;
    private MMHandler GCv;
    private HandlerThread GCw;
    MediaFormat GCx;
    private volatile int GCy = 1;
    private volatile int GCz = 44100;
    private final List<s> GzQ;

    static {
        AppMethodBeat.i(111019);
        AppMethodBeat.o(111019);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$2"})
    /* renamed from: com.tencent.mm.plugin.vlog.remux.a$a  reason: collision with other inner class name */
    static final class C1854a extends q implements m<byte[], Long, x> {
        final /* synthetic */ s GCE;
        final /* synthetic */ a GCF;
        final /* synthetic */ int puW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1854a(int i2, s sVar, a aVar) {
            super(2);
            this.puW = i2;
            this.GCE = sVar;
            this.GCF = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(111005);
            long longValue = l.longValue();
            a.a(this.GCF, bArr, longValue, this.puW, (aj) this.GCE);
            x xVar = x.SXb;
            AppMethodBeat.o(111005);
            return xVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r27v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.vlog.model.s> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(List<? extends s> list) {
        super(null, "background", -1, -1, null, null);
        com.tencent.mm.media.d.e hVar;
        p.h(list, "materials");
        AppMethodBeat.i(111018);
        this.GzQ = list;
        int i2 = 0;
        for (T t : this.GzQ) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            if (t2 instanceof aj) {
                com.tencent.mm.media.f.a aVar = new com.tencent.mm.media.f.a(t2.path);
                MediaFormat mediaFormat = aVar.igi;
                if (mediaFormat != null && mediaFormat.containsKey("frame-rate")) {
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i2 + ", material:" + t2.path + ", audioFps:" + mediaFormat.getInteger("frame-rate"));
                }
                long j2 = t2.GzW;
                long j3 = (t2.endTime - t2.startTime) + j2;
                if (com.tencent.mm.compatible.util.d.oE(23)) {
                    hVar = new g(aVar, "background", j2, j3);
                } else {
                    hVar = new h(aVar, "background", j2, j3);
                }
                hVar.iej = new C1854a(i2, t2, this);
                hVar.iek = new b(i2, t2, hVar, aVar, this);
                this.GCs.add(new d(i2, t2, hVar, aVar, j2, j3));
                Log.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i2 + ", material:" + t2.path + ", start:" + j2 + ',' + t2.startTime + ", end:" + j3 + ',' + t2.endTime);
            }
            i2 = i3;
        }
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, decoderList:" + this.GCs.size());
        if (fCr()) {
            this.GCy = this.GCs.get(0).GCL.getChannelCount();
            this.GCz = this.GCs.get(0).GCL.getSampleRate();
            this.GCA = 23;
            Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.GCy + ", currentSampleRate:" + this.GCz + ", currentAudioFrameInterval:" + this.GCA);
        }
        HandlerThread hB = com.tencent.f.c.d.hB("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
        p.g(hB, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
        this.GCw = hB;
        this.GCw.start();
        this.GCv = new MMHandler(this.GCw.getLooper());
        MediaFormat mediaFormat2 = new MediaFormat();
        mediaFormat2.setString("mime", EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
        mediaFormat2.setInteger("aac-profile", 2);
        mediaFormat2.setInteger("sample-rate", 44100);
        mediaFormat2.setInteger("channel-count", 1);
        mediaFormat2.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 64000);
        mediaFormat2.setInteger("max-input-size", 16384);
        this.GCx = mediaFormat2;
        this.GCt = 0;
        this.GCu = 0;
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, defaultMediaFormat:" + this.GCx);
        AppMethodBeat.o(111018);
    }

    public static final /* synthetic */ void a(a aVar, int i2, s sVar, com.tencent.mm.media.d.e eVar, com.tencent.mm.media.f.a aVar2) {
        AppMethodBeat.i(111021);
        aVar.a(i2, sVar, eVar, aVar2);
        AppMethodBeat.o(111021);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$Companion;", "", "()V", "DEFAULT_AUDIO_FRAME_INTERVAL", "", "TAG", "", "plugin-vlog_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    public final boolean fCr() {
        AppMethodBeat.i(111013);
        if (!this.GCs.isEmpty()) {
            AppMethodBeat.o(111013);
            return true;
        }
        AppMethodBeat.o(111013);
        return false;
    }

    @Override // com.tencent.mm.media.d.e
    public final int getChannelCount() {
        return this.GCy;
    }

    @Override // com.tencent.mm.media.d.e
    public final int getSampleRate() {
        return this.GCz;
    }

    @Override // com.tencent.mm.media.d.e
    public final void startDecoder() {
        AppMethodBeat.i(111014);
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "startDecoder: " + this.GCs.size());
        if (fCr()) {
            this.GCC = 0;
            this.GCu = 0;
            this.GCt = 0;
            s sVar = this.GzQ.get(0);
            if (sVar instanceof com.tencent.mm.plugin.vlog.model.q) {
                Log.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + sVar.startTime + ", endTime:" + sVar.endTime);
                a(sVar);
                Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first image material, index:" + this.GCt);
                a(this.GCu, sVar, null, null);
                AppMethodBeat.o(111014);
                return;
            } else if (this.GCs.get(0).ihK.aMp()) {
                this.GCy = this.GCs.get(0).GCL.getChannelCount();
                this.GCz = this.GCs.get(0).GCL.getSampleRate();
                this.GCB = -1;
                this.GCs.get(0).GCL.startDecoder();
                AppMethodBeat.o(111014);
                return;
            } else {
                Log.i("MicroMsg.VLogAudioBackgroundDecoder", "first video not have audio:" + this.GCs.get(0).GCK.path);
                a(this.GCs.get(0).GCK);
                Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
                a(this.GCu, this.GCs.get(0).GCK, this.GCs.get(0).GCL, this.GCs.get(0).ihK);
            }
        }
        AppMethodBeat.o(111014);
    }

    @Override // com.tencent.mm.media.d.e
    public final void aMc() {
        AppMethodBeat.i(111015);
        Log.printInfoStack("MicroMsg.VLogAudioBackgroundDecoder", "stopDecoder, decoderStop:" + this.ied, new Object[0]);
        if (!this.ied) {
            Iterator<T> it = this.GCs.iterator();
            while (it.hasNext()) {
                it.next().GCL.aMc();
            }
            this.GCs.clear();
        }
        this.GCw.quitSafely();
        this.GCt = 0;
        this.GCu = 0;
        AppMethodBeat.o(111015);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ a GCF;
        final /* synthetic */ aj GCN;
        final /* synthetic */ byte[] GCO;
        final /* synthetic */ long ihy;

        f(a aVar, long j2, aj ajVar, byte[] bArr) {
            this.GCF = aVar;
            this.ihy = j2;
            this.GCN = ajVar;
            this.GCO = bArr;
        }

        public final void run() {
            AppMethodBeat.i(111012);
            long j2 = (this.ihy - this.GCN.GzW) + (this.GCN.startTime * 1000);
            m mVar = this.GCF.iej;
            if (mVar != null) {
                mVar.invoke(this.GCO, Long.valueOf(j2));
            }
            this.GCF.GCC = j2;
            AppMethodBeat.o(111012);
        }
    }

    private final void a(s sVar) {
        AppMethodBeat.i(111016);
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.GCy + ", currentSampleRate:" + this.GCz + ", currentAudioFrameInterval:" + this.GCA);
        kotlin.k.g a2 = kotlin.k.j.a(new i(sVar.startTime, sVar.endTime), this.GCA);
        long j2 = a2.first;
        long j3 = a2.SZc;
        long j4 = a2.BMh;
        if (j4 < 0 ? j2 >= j3 : j2 <= j3) {
            while (true) {
                this.GCv.post(new e(this));
                if (j2 == j3) {
                    break;
                }
                j2 += j4;
            }
        }
        AppMethodBeat.o(111016);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ a GCF;

        e(a aVar) {
            this.GCF = aVar;
        }

        public final void run() {
            AppMethodBeat.i(111011);
            int i2 = this.GCF.GCy * 2048;
            m mVar = this.GCF.iej;
            if (mVar != null) {
                mVar.invoke(new byte[i2], Long.valueOf(this.GCF.GCC));
            }
            this.GCF.GCC += this.GCF.GCA * 1000;
            AppMethodBeat.o(111011);
        }
    }

    private final void a(int i2, s sVar, com.tencent.mm.media.d.e eVar, com.tencent.mm.media.f.a aVar) {
        T t;
        boolean z;
        AppMethodBeat.i(111017);
        while (true) {
            Log.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + i2 + ", material:" + sVar.path + ", currentPts:" + this.GCC);
            if (eVar != null) {
                try {
                    eVar.aMc();
                } catch (Exception e2) {
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd release decoder and extractor error");
                }
            }
            if (aVar != null) {
                aVar.release();
            }
            if (i2 + 1 < this.GzQ.size()) {
                s sVar2 = this.GzQ.get(i2 + 1);
                this.GCu = i2 + 1;
                Log.i("MicroMsg.VLogAudioBackgroundDecoder", "nextMaterial:" + sVar2.path);
                if (sVar2 instanceof aj) {
                    Iterator<T> it = this.GCs.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (next.index == i2 + 1) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            t = next;
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (i2 + 1) + ", hasAudio:" + t2.ihK.aMp());
                        if (!t2.ihK.aMp()) {
                            Log.i("MicroMsg.VLogAudioBackgroundDecoder", "next material not have audio: " + t2.GCK.path);
                            a(t2.GCK);
                            Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process mute video material, index:" + this.GCt);
                            a(this.GCu, t2.GCK, t2.GCL, t2.ihK);
                        } else {
                            this.GCy = t2.GCL.getChannelCount();
                            this.GCz = t2.GCL.getSampleRate();
                            this.GCB = -1;
                            t2.GCL.startDecoder();
                        }
                    }
                    this.GCt = i2 + 1;
                    AppMethodBeat.o(111017);
                    return;
                } else if (sVar2 instanceof com.tencent.mm.plugin.vlog.model.q) {
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + sVar2.startTime + ", endTime:" + sVar2.endTime);
                    a(sVar2);
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process image material, index:" + this.GCt);
                    i2 = this.GCu;
                    aVar = null;
                    eVar = null;
                    sVar = sVar2;
                } else {
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "cannot find next material");
                    AppMethodBeat.o(111017);
                    return;
                }
            } else {
                Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish decode all material");
                kotlin.g.a.a<x> aVar2 = this.iek;
                if (aVar2 != null) {
                    aVar2.invoke();
                    AppMethodBeat.o(111017);
                    return;
                }
                AppMethodBeat.o(111017);
                return;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", FirebaseAnalytics.b.INDEX, "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-vlog_release"})
    public static final class d {
        final aj GCK;
        final com.tencent.mm.media.d.e GCL;
        private final long endTime;
        final com.tencent.mm.media.f.a ihK;
        final int index;
        private final long startTime;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            if (r5.endTime == r6.endTime) goto L_0x0042;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 111010(0x1b1a2, float:1.55558E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0042
                boolean r0 = r6 instanceof com.tencent.mm.plugin.vlog.remux.a.d
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.plugin.vlog.remux.a$d r6 = (com.tencent.mm.plugin.vlog.remux.a.d) r6
                int r0 = r5.index
                int r1 = r6.index
                if (r0 != r1) goto L_0x0047
                com.tencent.mm.plugin.vlog.model.aj r0 = r5.GCK
                com.tencent.mm.plugin.vlog.model.aj r1 = r6.GCK
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.media.d.e r0 = r5.GCL
                com.tencent.mm.media.d.e r1 = r6.GCL
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.media.f.a r0 = r5.ihK
                com.tencent.mm.media.f.a r1 = r6.ihK
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                long r0 = r5.startTime
                long r2 = r6.startTime
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0047
                long r0 = r5.endTime
                long r2 = r6.endTime
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0047
            L_0x0042:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0046:
                return r0
            L_0x0047:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0046
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.remux.a.d.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(111009);
            int i3 = this.index * 31;
            aj ajVar = this.GCK;
            int hashCode = ((ajVar != null ? ajVar.hashCode() : 0) + i3) * 31;
            com.tencent.mm.media.d.e eVar = this.GCL;
            int hashCode2 = ((eVar != null ? eVar.hashCode() : 0) + hashCode) * 31;
            com.tencent.mm.media.f.a aVar = this.ihK;
            if (aVar != null) {
                i2 = aVar.hashCode();
            }
            long j2 = this.startTime;
            long j3 = this.endTime;
            int i4 = ((((hashCode2 + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
            AppMethodBeat.o(111009);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(111008);
            String str = "VideoDecoder(index=" + this.index + ", material=" + this.GCK + ", decoder=" + this.GCL + ", mediaExtractor=" + this.ihK + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
            AppMethodBeat.o(111008);
            return str;
        }

        public d(int i2, aj ajVar, com.tencent.mm.media.d.e eVar, com.tencent.mm.media.f.a aVar, long j2, long j3) {
            p.h(ajVar, "material");
            p.h(eVar, "decoder");
            p.h(aVar, "mediaExtractor");
            AppMethodBeat.i(111007);
            this.index = i2;
            this.GCK = ajVar;
            this.GCL = eVar;
            this.ihK = aVar;
            this.startTime = j2;
            this.endTime = j3;
            AppMethodBeat.o(111007);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$3"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a GCF;
        final /* synthetic */ int GCG;
        final /* synthetic */ s GCH;
        final /* synthetic */ com.tencent.mm.media.d.e GCI;
        final /* synthetic */ com.tencent.mm.media.f.a GCJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i2, s sVar, com.tencent.mm.media.d.e eVar, com.tencent.mm.media.f.a aVar, a aVar2) {
            super(0);
            this.GCG = i2;
            this.GCH = sVar;
            this.GCI = eVar;
            this.GCJ = aVar;
            this.GCF = aVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(111006);
            a.a(this.GCF, this.GCG, this.GCH, this.GCI, this.GCJ);
            x xVar = x.SXb;
            AppMethodBeat.o(111006);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, byte[] bArr, long j2, int i2, aj ajVar) {
        Integer num;
        AppMethodBeat.i(111020);
        StringBuilder sb = new StringBuilder("onFrameDecode: ");
        if (bArr != null) {
            num = Integer.valueOf(bArr.length);
        } else {
            num = null;
        }
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", sb.append(num).append(", pts:").append(j2).append(", index:").append(i2).append(", materialStart:").append(ajVar.startTime).append(", materialEnd:").append(ajVar.endTime).toString());
        if (aVar.GCB > 0 && j2 - aVar.GCB > 0) {
            aVar.GCA = (j2 - aVar.GCB) / 1000;
            if (aVar.GCA <= 0) {
                aVar.GCA = 23;
            }
        }
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "onFrameDecode, currentAudioFrameInterval:" + aVar.GCA);
        aVar.GCv.post(new f(aVar, j2, ajVar, bArr));
        aVar.GCB = j2;
        AppMethodBeat.o(111020);
    }
}
