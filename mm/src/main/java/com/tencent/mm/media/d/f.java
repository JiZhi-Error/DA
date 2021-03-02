package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.media.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b&\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010o\u001a\u00020\nJ\u0006\u0010p\u001a\u00020\nJ\b\u0010q\u001a\u00020\nH\u0002J\b\u0010r\u001a\u0004\u0018\u00010=J\u0006\u00102\u001a\u00020\fJ\b\u0010s\u001a\u00020\fH\u0004Jn\u0010t\u001a\u00020L2f\u0010u\u001ab\u0012\u0015\u0012\u0013\u0018\u00010D¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110I¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\f¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(K\u0012\u0006\u0012\u0004\u0018\u00010L\u0018\u00010CJ\u0016\u0010Q\u001a\u00020L2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010RJ\u0016\u0010W\u001a\u00020L2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010RJ+\u0010Z\u001a\u00020L2#\u0010u\u001a\u001f\u0012\u0013\u0012\u00110=¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020L\u0018\u00010[J\u0018\u0010v\u001a\u00020L2\u0006\u0010w\u001a\u00020\n2\u0006\u0010J\u001a\u00020IH\u0004J\b\u0010x\u001a\u00020LH\u0016J\u000e\u0010y\u001a\u00020L2\u0006\u0010z\u001a\u00020\nJ\u0010\u0010{\u001a\u00020L2\u0006\u0010|\u001a\u00020\fH\u0016J\b\u0010}\u001a\u00020LH&J\u000e\u0010~\u001a\u00020L2\u0006\u0010~\u001a\u00020\fR\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u000e\u00109\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010ARz\u0010B\u001ab\u0012\u0015\u0012\u0013\u0018\u00010D¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110I¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\f¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(K\u0012\u0006\u0012\u0004\u0018\u00010L\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR7\u0010Z\u001a\u001f\u0012\u0013\u0012\u00110=¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020L\u0018\u00010[X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u000e\u0010`\u001a\u00020aX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\u00030cj\b\u0012\u0004\u0012\u00020\u0003`dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010'\"\u0004\bf\u0010)R\u001a\u0010g\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00104\"\u0004\bi\u00106R\u001a\u0010j\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006"}, hxF = {"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZ)V", "TAG", "", "bFrameNum", "decodeHelper", "Lcom/tencent/mm/media/decoder/DecodeHelper;", "getDecodeHelper", "()Lcom/tencent/mm/media/decoder/DecodeHelper;", "setDecodeHelper", "(Lcom/tencent/mm/media/decoder/DecodeHelper;)V", "decodePts", "getDecodeSurface", "()Landroid/view/Surface;", "setDecodeSurface", "(Landroid/view/Surface;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "hasBFrame", "isFinished", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "lastDecodePts", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "duplicate", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onDecodeError", "getOnDecodeError", "setOnDecodeError", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "ptsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getBFrameNum", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "bufferIndex", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
public abstract class f {
    public final String TAG;
    protected volatile boolean dLD;
    long endTimeMs;
    private int frameCount;
    private volatile boolean ieA;
    private volatile int ieB;
    private ArrayList<Long> ieC;
    protected Surface ieD;
    z iec;
    final a iei;
    public r<? super ByteBuffer, ? super Long, ? super MediaCodec.BufferInfo, ? super Boolean, x> ieo;
    public kotlin.g.a.a<x> iep;
    public b<? super MediaFormat, x> ieq;
    public kotlin.g.a.a<x> ier;
    public int ies;
    private final Semaphore iet;
    final Object ieu;
    private float iev;
    private b iew;
    public boolean iex;
    private long iey;
    private long iez;
    volatile boolean isFinished;
    public MediaFormat mediaFormat;
    long startTimeMs;
    private int videoFps;

    public abstract void startDecode();

    public f(long j2, long j3, a aVar, Surface surface, int i2, boolean z) {
        String str;
        a aVar2;
        this.startTimeMs = j2;
        this.endTimeMs = j3;
        this.iei = aVar;
        this.ieD = surface;
        this.TAG = "MicroMsg.IMediaCodecTransDecoder";
        this.iet = new Semaphore(1);
        this.ieu = new Object();
        this.iey = -1;
        this.iez = -1;
        this.ieC = new ArrayList<>();
        Log.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs);
        a aVar3 = this.iei;
        if (aVar3 != null) {
            aVar3.aMq();
        }
        if (this.startTimeMs >= 0 && (aVar2 = this.iei) != null) {
            aVar2.seek(this.startTimeMs * 1000);
        }
        a aVar4 = this.iei;
        if (aVar4 != null) {
            str = aVar4.filePath;
        } else {
            str = null;
        }
        this.iew = new b(str, i2, this.startTimeMs * 1000, z);
        this.ieB = 0;
    }

    public /* synthetic */ f(long j2, long j3, Surface surface, int i2) {
        this(j2, j3, null, surface, i2, false);
    }

    public void eU(boolean z) {
        long currentTicks = Util.currentTicks();
        this.dLD = z;
        Log.d(this.TAG, "setPauseDecoder:" + z + ", remain:" + this.iet.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + currentTicks);
        if (z) {
            Log.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + currentTicks);
            this.iet.acquire();
        } else {
            Log.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + currentTicks);
            this.iet.release();
        }
        Log.d(this.TAG, "after setPauseDecoder:" + z + ", remain:" + this.iet.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + currentTicks);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01c2 A[EDGE_INSN: B:126:0x01c2->B:47:0x01c2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r13, android.media.MediaCodec.BufferInfo r14) {
        /*
        // Method dump skipped, instructions count: 917
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.d.f.a(int, android.media.MediaCodec$BufferInfo):void");
    }

    public void releaseDecoder() {
        Log.i(this.TAG, "releaseDecoder  " + hashCode());
        synchronized (this.ieu) {
            try {
                this.iew.bHs.clear();
                z zVar = this.iec;
                if (zVar != null) {
                    zVar.stop();
                }
                Log.i(this.TAG, "decoder?.stop()");
                z zVar2 = this.iec;
                if (zVar2 != null) {
                    zVar2.release();
                }
                Log.i(this.TAG, "decoder?.release()");
                this.isFinished = true;
                Surface surface = this.ieD;
                if (surface != null) {
                    surface.release();
                }
                Log.i(this.TAG, "releaseDecoder end");
            } catch (Exception e2) {
            }
            x xVar = x.SXb;
        }
    }
}
