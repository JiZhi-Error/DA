package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001_B®\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012%\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017¢\u0006\u0002\u0010\u001cJ\b\u0010O\u001a\u00020\u001bH\u0002J\b\u0010P\u001a\u00020\u001bH\u0002J\u0010\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u0015H\u0002J\b\u0010S\u001a\u00020TH\u0002J\u0010\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\u0015H\u0002J\b\u0010W\u001a\u00020\tH\u0016J\b\u0010X\u001a\u00020\u001bH\u0002J\b\u0010Y\u001a\u00020\u001bH\u0002J\u0010\u0010Z\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020%H\u0016J\u001e\u0010\\\u001a\u00020\u001b2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010%0\u0017H\u0016J\u001e\u0010]\u001a\u00020\u001b2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010%0\u0017H\u0016R\u000e\u0010\u001d\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R-\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"})
public final class e extends com.tencent.mm.media.i.d implements com.tencent.mm.media.i.c {
    public static final a BLG = new a((byte) 0);
    private static final long iiK = 1000;
    private static final long iiL = 1000;
    private d BLD;
    private com.tencent.mm.media.e.g BLE;
    boolean BLF;
    private ArrayList<String> BLy;
    private final String TAG = "MicroMsg.MediaCodecRemuxerFake";
    private volatile boolean idb;
    private int idi;
    private int idq;
    private volatile boolean ifd;
    private int ihQ;
    private int ihR;
    private com.tencent.mm.media.e.b ihT;
    private com.tencent.mm.media.a.a ihV;
    private com.tencent.mm.media.i.i ihX;
    private com.tencent.mm.media.f.a ihY;
    private com.tencent.mm.media.f.a ihZ;
    private kotlin.g.a.b<? super Long, Bitmap> ihf;
    private long iho;
    private int iiB;
    private kotlin.g.a.b<? super String, x> iiJ;
    private HandlerThread iia;
    private HandlerThread iib;
    private boolean iic;
    private boolean iid;
    private com.tencent.mm.media.i.g iie;
    private long iig;
    private final com.tencent.mm.media.k.a iih;
    private boolean iii;
    private boolean iij;
    private boolean iik;
    private int iil;
    private int iim;
    private final Runnable iiu;
    private final String iiv;
    private int iix;
    private int iiy;
    private int iiz;
    private final String outputFilePath;
    private int outputHeight;
    private int outputWidth;
    private long remuxEndTime;
    private int videoDuration = -1;
    private int videoFps;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", "", "invoke"})
    static final class i extends q implements kotlin.g.a.m<d, Boolean, x> {
        final /* synthetic */ e BLH;
        final /* synthetic */ com.tencent.mm.media.b.d BLI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(e eVar, com.tencent.mm.media.b.d dVar) {
            super(2);
            this.BLH = eVar;
            this.BLI = dVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
        static final class a extends q implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x> {
            final /* synthetic */ i BLJ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(i iVar) {
                super(4);
                this.BLJ = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.r
            public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Long l, MediaCodec.BufferInfo bufferInfo, Boolean bool) {
                long j2;
                d dVar;
                AppMethodBeat.i(182841);
                long longValue = l.longValue();
                boolean booleanValue = bool.booleanValue();
                p.h(bufferInfo, "<anonymous parameter 2>");
                this.BLJ.BLH.iil++;
                if (!booleanValue && (dVar = this.BLJ.BLH.BLD) != null) {
                    dVar.eU(true);
                }
                if (this.BLJ.BLH.iho >= 0) {
                    j2 = longValue - (this.BLJ.BLH.iho * 1000);
                } else {
                    j2 = longValue;
                }
                if (!this.BLJ.BLH.BLF) {
                    if (this.BLJ.BLH.iil == 1) {
                        this.BLJ.BLH.ihX.zJ(-1 * ((long) Math.round(1000.0f / ((float) this.BLJ.BLH.iiB))) * 1000);
                    }
                    this.BLJ.BLH.ihX.zJ(j2);
                }
                Log.d(this.BLJ.BLH.TAG, "onDecode, drawPts:" + j2 + ", pts:" + longValue + ", remuxStartTime:" + this.BLJ.BLH.iho);
                x xVar = x.SXb;
                AppMethodBeat.o(182841);
                return xVar;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(d dVar, Boolean bool) {
            AppMethodBeat.i(75287);
            d dVar2 = dVar;
            boolean booleanValue = bool.booleanValue();
            p.h(dVar2, "$receiver");
            if (!booleanValue) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOB();
            }
            dVar2.ieo = new a(this);
            dVar2.iep = new b(this);
            dVar2.iex = true;
            dVar2.BLw = this.BLH.ihf;
            dVar2.BLx = new kotlin.g.a.m<Boolean, Buffer, x>(this) {
                /* class com.tencent.mm.plugin.recordvideo.background.b.e.i.AnonymousClass1 */
                final /* synthetic */ i BLJ;

                {
                    this.BLJ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Boolean bool, Buffer buffer) {
                    kotlin.g.a.a<x> aVar;
                    AppMethodBeat.i(75284);
                    Buffer buffer2 = buffer;
                    if (!bool.booleanValue()) {
                        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aOC();
                    }
                    this.BLJ.BLH.iim++;
                    Log.i(this.BLJ.BLH.TAG, "onFrameDraw, drawFrameCount:" + this.BLJ.BLH.iim + ", encodeFrameCount:" + this.BLJ.BLH.idi + ", isDecodeEnd:" + this.BLJ.BLH.idb);
                    com.tencent.mm.media.i.g gVar = this.BLJ.BLH.iie;
                    if (!(gVar == null || (aVar = gVar.ijf) == null)) {
                        aVar.invoke();
                    }
                    if (!this.BLJ.BLH.BLF) {
                        com.tencent.mm.media.e.b bVar = this.BLJ.BLH.ihT;
                        if (bVar != null) {
                            bVar.aMl();
                        }
                    } else if (buffer2 != null) {
                        com.tencent.mm.media.e.g gVar2 = this.BLJ.BLH.BLE;
                        if (gVar2 != null) {
                            int i2 = this.BLJ.BLI.targetWidth;
                            int i3 = this.BLJ.BLI.targetHeight;
                            p.h(buffer2, "data");
                            if (gVar2.bufId < 0) {
                                Log.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
                            } else {
                                synchronized (gVar2.stopLock) {
                                    try {
                                        if (gVar2.isStop || gVar2.ifz) {
                                            Log.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
                                        } else {
                                            long currentTicks = Util.currentTicks();
                                            SightVideoJNI.writeRGBDataForMMSight(gVar2.bufId, buffer2, i2, i3, false, false, i2, i3);
                                            StringBuilder append = new StringBuilder("writeRGBData ").append(i2).append(", ").append(i3).append(" cost ").append(Util.ticksToNow(currentTicks)).append("ms, ");
                                            int i4 = gVar2.frameCount;
                                            gVar2.frameCount = i4 + 1;
                                            Log.i("MicroMsg.X264TransEncoder", append.append(i4).toString());
                                            if (!gVar2.ifB) {
                                                com.tencent.f.e.f<?> fVar = gVar2.ifx;
                                                if (fVar != null) {
                                                    fVar.begin();
                                                }
                                                gVar2.ifB = true;
                                            }
                                            x xVar = x.SXb;
                                        }
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(75284);
                                        throw th;
                                    }
                                }
                            }
                        }
                        this.BLJ.BLH.idi++;
                        e.h(this.BLJ.BLH);
                    } else {
                        Log.w(this.BLJ.BLH.TAG, "encode error, useX264Encode true but outputBuffer null");
                    }
                    d dVar = this.BLJ.BLH.BLD;
                    if (dVar != null) {
                        dVar.eU(false);
                    }
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(75284);
                    return xVar2;
                }
            };
            this.BLH.iic = true;
            if (this.BLH.iid) {
                this.BLH.aMG();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75287);
            return xVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ i BLJ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(i iVar) {
                super(0);
                this.BLJ = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(75286);
                Log.i(this.BLJ.BLH.TAG, "onDecodeEnd, encodeFrameCount:" + this.BLJ.BLH.idi + ", drawFrameCount:" + this.BLJ.BLH.iim);
                this.BLJ.BLH.idb = true;
                e.h(this.BLJ.BLH);
                x xVar = x.SXb;
                AppMethodBeat.o(75286);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.background.b.e$e  reason: collision with other inner class name */
    static final class C1642e extends q implements kotlin.g.a.b<com.tencent.mm.media.e.b, x> {
        final /* synthetic */ kotlin.g.a.m iiO;
        final /* synthetic */ kotlin.g.a.a iiP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1642e(kotlin.g.a.m mVar, kotlin.g.a.a aVar) {
            super(1);
            this.iiO = mVar;
            this.iiP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.e.b bVar) {
            AppMethodBeat.i(75280);
            com.tencent.mm.media.e.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            bVar2.ifb = this.iiO;
            bVar2.ifc = this.iiP;
            bVar2.iex = true;
            x xVar = x.SXb;
            AppMethodBeat.o(75280);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<com.tencent.mm.media.e.b, x> {
        final /* synthetic */ kotlin.g.a.m iiO;
        final /* synthetic */ kotlin.g.a.a iiP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(kotlin.g.a.m mVar, kotlin.g.a.a aVar) {
            super(1);
            this.iiO = mVar;
            this.iiP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.e.b bVar) {
            AppMethodBeat.i(75281);
            com.tencent.mm.media.e.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            bVar2.ifb = this.iiO;
            bVar2.ifc = this.iiP;
            bVar2.iex = true;
            x xVar = x.SXb;
            AppMethodBeat.o(75281);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    static final class g extends q implements kotlin.g.a.b<com.tencent.mm.media.e.b, x> {
        final /* synthetic */ kotlin.g.a.m iiO;
        final /* synthetic */ kotlin.g.a.a iiP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(kotlin.g.a.m mVar, kotlin.g.a.a aVar) {
            super(1);
            this.iiO = mVar;
            this.iiP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.e.b bVar) {
            AppMethodBeat.i(75282);
            com.tencent.mm.media.e.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            bVar2.ifb = this.iiO;
            bVar2.ifc = this.iiP;
            bVar2.iex = true;
            x xVar = x.SXb;
            AppMethodBeat.o(75282);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    static final class h extends q implements kotlin.g.a.b<com.tencent.mm.media.e.b, x> {
        final /* synthetic */ kotlin.g.a.m iiO;
        final /* synthetic */ kotlin.g.a.a iiP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(kotlin.g.a.m mVar, kotlin.g.a.a aVar) {
            super(1);
            this.iiO = mVar;
            this.iiP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.e.b bVar) {
            AppMethodBeat.i(75283);
            com.tencent.mm.media.e.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            bVar2.ifb = this.iiO;
            bVar2.ifc = this.iiP;
            bVar2.iex = true;
            x xVar = x.SXb;
            AppMethodBeat.o(75283);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    static final class j extends q implements kotlin.g.a.m<ByteBuffer, MediaCodec.BufferInfo, x> {
        final /* synthetic */ e BLH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(e eVar) {
            super(2);
            this.BLH = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            kotlin.g.a.m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> mVar;
            AppMethodBeat.i(75288);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            p.h(byteBuffer2, "byteBuffer");
            p.h(bufferInfo2, "bufferInfo");
            Log.i(this.BLH.TAG, "onEncode: " + this.BLH.idi + ", isDecodeEnd:" + this.BLH.idb + ", drawFrameCount:" + this.BLH.iim + ", decodeFrameCount:" + this.BLH.iil);
            this.BLH.idi++;
            com.tencent.mm.media.i.g gVar = this.BLH.iie;
            if (((gVar == null || (mVar = gVar.ijc) == null) ? null : mVar.invoke(byteBuffer2, bufferInfo2)) == null) {
                p.hyc();
            }
            e.h(this.BLH);
            x xVar = x.SXb;
            AppMethodBeat.o(75288);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
    public static final class l extends q implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x> {
        final /* synthetic */ e BLH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(e eVar) {
            super(3);
            this.BLH = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
            kotlin.g.a.q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> qVar;
            AppMethodBeat.i(75290);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            MediaFormat mediaFormat2 = mediaFormat;
            p.h(byteBuffer2, "buffer");
            p.h(bufferInfo2, "bufferInfo");
            p.h(mediaFormat2, "format");
            com.tencent.mm.media.i.g gVar = this.BLH.iie;
            if (!(gVar == null || (qVar = gVar.ijd) == null)) {
                qVar.d(byteBuffer2, bufferInfo2, mediaFormat2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75290);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(e eVar, boolean z) {
        AppMethodBeat.i(75302);
        eVar.eX(z);
        AppMethodBeat.o(75302);
    }

    public static final /* synthetic */ void v(e eVar) {
        AppMethodBeat.i(75304);
        eVar.aMi();
        AppMethodBeat.o(75304);
    }

    public e(String str, ArrayList<String> arrayList, int i2, String str2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, long j3, boolean z, kotlin.g.a.b<? super String, x> bVar) {
        boolean z2;
        com.tencent.mm.media.i.i iVar;
        com.tencent.mm.media.e.b eVar;
        Surface surface;
        com.tencent.mm.media.e.b eVar2;
        p.h(arrayList, "imageList");
        p.h(str2, "outputFilePath");
        AppMethodBeat.i(75299);
        this.iiv = str;
        this.BLy = arrayList;
        this.idq = i2;
        this.outputFilePath = str2;
        this.outputWidth = i3;
        this.outputHeight = i4;
        this.iix = i5;
        this.iiy = i6;
        this.iiz = i7;
        this.iiB = i8;
        this.BLF = z;
        this.iiJ = bVar;
        this.iho = j2;
        this.remuxEndTime = -1;
        this.iih = new com.tencent.mm.media.k.a("remuxCost");
        Iterator<String> it = this.BLy.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!s.YS(it.next())) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        if (!z2 || Util.isNullOrNil(this.outputFilePath) || this.outputWidth <= 0 || this.outputHeight <= 0) {
            Log.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.iiB);
            com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOv();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("create MediaCodecRemuxer error");
            AppMethodBeat.o(75299);
            throw illegalArgumentException;
        }
        com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.rn(this.idq);
        s.boN(s.boZ(this.outputFilePath));
        com.tencent.mm.plugin.recordvideo.b.e.BNm.eJv();
        com.tencent.mm.plugin.recordvideo.b.e eVar5 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        this.ihQ = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
        com.tencent.mm.plugin.recordvideo.b.e eVar6 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        this.ihR = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
        com.tencent.mm.plugin.recordvideo.b.e eVar7 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        this.videoFps = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
        com.tencent.mm.plugin.recordvideo.b.e eVar8 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        this.videoDuration = com.tencent.mm.plugin.recordvideo.b.e.eJs();
        if (j3 == 0) {
            this.remuxEndTime = (long) this.videoDuration;
        } else {
            this.remuxEndTime = j3;
        }
        if (this.BLF) {
            Log.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", Integer.valueOf(this.iix), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Integer.valueOf(this.iiB));
            iVar = new com.tencent.mm.media.i.i(this.iho, this.remuxEndTime, this.iix, this.outputWidth, this.outputHeight, this.BLF, (float) this.iiB);
        } else {
            iVar = new com.tencent.mm.media.i.i(this.iho, this.remuxEndTime, this.iix, this.BLF);
        }
        this.ihX = iVar;
        Log.printInfoStack(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.ihQ + ", inputHeight: " + this.ihR + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.iix + ", outputAudioBitrate:" + this.iiy + " , outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + j2 + ", endTimeMs: " + j3 + " , outputFps: " + this.iiB + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.iho + " ,remuxEndTime: " + this.remuxEndTime, new Object[0]);
        this.ihZ = null;
        this.iie = new com.tencent.mm.media.i.g(this.ihX, this.ihZ, this.outputFilePath, this.idq, this.iiz);
        if (s.YS(this.iiv)) {
            String str3 = this.iiv;
            if (str3 == null) {
                p.hyc();
            }
            com.tencent.mm.media.f.a aVar = new com.tencent.mm.media.f.a(str3);
            if (aVar.igl) {
                com.tencent.mm.media.k.e eVar9 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOy();
            }
            this.ihY = aVar;
        }
        try {
            int min = this.iiB > 0 ? Math.min(this.iiB, this.videoFps) : this.videoFps;
            com.tencent.mm.media.b.d dVar = new com.tencent.mm.media.b.d();
            dVar.bitrate = this.iix;
            dVar.frameRate = min;
            dVar.targetHeight = this.outputHeight;
            dVar.targetWidth = this.outputWidth;
            dVar.idD = true;
            j jVar = new j(this);
            k kVar = new k(this);
            try {
                if (this.BLF) {
                    Log.i(this.TAG, "useX264Encode");
                    this.BLE = new com.tencent.mm.media.e.g(this.ihX.bufId, dVar.targetWidth, dVar.targetHeight);
                    com.tencent.mm.media.e.g gVar = this.BLE;
                    if (gVar != null) {
                        gVar.start();
                    }
                } else {
                    if (com.tencent.mm.compatible.util.d.oD(23)) {
                        eVar2 = new com.tencent.mm.media.e.f(dVar, new C1642e(jVar, kVar));
                    } else {
                        eVar2 = new com.tencent.mm.media.e.e(dVar, new f(jVar, kVar));
                    }
                    this.ihT = eVar2;
                }
            } catch (Exception e2) {
                if (dVar.idD) {
                    dVar.idD = false;
                    try {
                        if (com.tencent.mm.compatible.util.d.oD(23)) {
                            eVar = new com.tencent.mm.media.e.f(dVar, new g(jVar, kVar));
                        } else {
                            eVar = new com.tencent.mm.media.e.e(dVar, new h(jVar, kVar));
                        }
                        this.ihT = eVar;
                        com.tencent.mm.plugin.recordvideo.d.d dVar2 = com.tencent.mm.plugin.recordvideo.d.d.BXS;
                        com.tencent.mm.plugin.recordvideo.d.d.eLc();
                    } catch (Exception e3) {
                        Log.printErrStackTrace(this.TAG, e2, "create encoder again error", new Object[0]);
                        com.tencent.mm.media.k.e eVar10 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aOz();
                        eJl();
                        com.tencent.mm.plugin.recordvideo.d.d dVar3 = com.tencent.mm.plugin.recordvideo.d.d.BXS;
                        com.tencent.mm.plugin.recordvideo.d.d.eLb();
                    }
                } else {
                    Log.printErrStackTrace(this.TAG, e2, "create encoder error", new Object[0]);
                    com.tencent.mm.media.k.e eVar11 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aOz();
                    eJl();
                    com.tencent.mm.plugin.recordvideo.d.d dVar4 = com.tencent.mm.plugin.recordvideo.d.d.BXS;
                    com.tencent.mm.plugin.recordvideo.d.d.eLb();
                }
            }
            if (!(this.BLE == null && this.ihT == null)) {
                if (this.ihT != null) {
                    com.tencent.mm.media.e.b bVar2 = this.ihT;
                    if (bVar2 == null) {
                        p.hyc();
                    }
                    surface = bVar2.getInputSurface();
                } else {
                    surface = null;
                }
                this.BLD = new d(this.BLy, this.iho, this.remuxEndTime, surface, this.outputWidth, this.outputHeight, this.BLF, this.iiB, new i(this, dVar));
            }
        } catch (Exception e4) {
            Log.printErrStackTrace(this.TAG, e4, "remux impl error", new Object[0]);
        }
        this.iiu = new b(this);
        AppMethodBeat.o(75299);
    }

    @Override // com.tencent.mm.media.i.d
    public final void D(Bitmap bitmap) {
        AppMethodBeat.i(75292);
        p.h(bitmap, "bitmap");
        AppMethodBeat.o(75292);
    }

    @Override // com.tencent.mm.media.i.c
    public final void k(kotlin.g.a.b<? super Long, Bitmap> bVar) {
        AppMethodBeat.i(75293);
        p.h(bVar, "blendBitmapProvider");
        this.ihf = bVar;
        AppMethodBeat.o(75293);
    }

    @Override // com.tencent.mm.media.i.d, com.tencent.mm.media.i.c
    public final int aMG() {
        AppMethodBeat.i(75294);
        Log.i(this.TAG, "start remux, initFinish:" + this.iic);
        this.iig = Util.currentTicks();
        this.iih.hvh.reset();
        if (Log.getLogLevel() > 0) {
            com.tencent.mm.plugin.recordvideo.b.e eVar = com.tencent.mm.plugin.recordvideo.b.e.BNm;
            if (!com.tencent.mm.plugin.recordvideo.b.e.eJt()) {
                this.iic = false;
            }
        }
        if (this.iic) {
            com.tencent.mm.plugin.recordvideo.d.d dVar = com.tencent.mm.plugin.recordvideo.d.d.BXS;
            com.tencent.mm.plugin.recordvideo.d.d.eLa();
            HandlerThread handlerThread = this.iia;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.iia = com.tencent.mm.ac.d.a("MediaCodecRemux_audioMix", false, (kotlin.g.a.a) new c(this));
            HandlerThread handlerThread2 = this.iib;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            if (this.BLD != null) {
                this.iib = com.tencent.mm.ac.d.a("MediaCodecRemux_videoMix", false, (kotlin.g.a.a) new d(this));
            }
        } else {
            this.iid = true;
        }
        AppMethodBeat.o(75294);
        return 0;
    }

    @Override // com.tencent.mm.media.i.c
    public final void l(kotlin.g.a.b<? super Long, Bitmap> bVar) {
        AppMethodBeat.i(75295);
        p.h(bVar, "blurBgProvider");
        AppMethodBeat.o(75295);
    }

    private final void aMi() {
        AppMethodBeat.i(75296);
        Log.i(this.TAG, "finishEncode %s", Boolean.valueOf(this.BLF));
        if (this.BLF) {
            com.tencent.mm.media.e.g gVar = this.BLE;
            if (gVar != null) {
                com.tencent.mm.media.e.g.a(gVar);
            }
            eX(true);
        } else {
            com.tencent.mm.media.e.b bVar = this.ihT;
            if (bVar != null) {
                bVar.aMi();
            }
        }
        MMHandlerThread.removeRunnable(this.iiu);
        this.ifd = true;
        AppMethodBeat.o(75296);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ e BLH;

        b(e eVar) {
            this.BLH = eVar;
        }

        public final void run() {
            AppMethodBeat.i(75277);
            Log.i(this.BLH.TAG, "decode end after " + e.iiL + ", isFinishEncode:" + this.BLH.ifd);
            if (!this.BLH.ifd) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOW();
                e.v(this.BLH);
            }
            AppMethodBeat.o(75277);
        }
    }

    private final synchronized void eX(boolean z) {
        kotlin.g.a.b<? super kotlin.g.a.b<? super String, x>, x> bVar;
        AppMethodBeat.i(75297);
        Log.i(this.TAG, "finishRemux, isVideo: " + z + ", isAudioRemuxFinish:" + this.iik + ", isVideoRemuxFinish:" + this.iij + ", isInvokeEndCallback:" + this.iii);
        if (z) {
            this.iij = true;
        } else {
            this.iik = true;
        }
        if (this.iik && this.iij && !this.iii) {
            this.iih.aBw();
            this.iii = true;
            com.tencent.mm.media.f.a aVar = this.ihZ;
            if (aVar != null) {
                aVar.release();
            }
            com.tencent.mm.media.i.g gVar = this.iie;
            if (!(gVar == null || (bVar = gVar.ije) == null)) {
                bVar.invoke(this.iiJ);
            }
            HandlerThread handlerThread = this.iia;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            HandlerThread handlerThread2 = this.iib;
            if (handlerThread2 != null) {
                handlerThread2.quitSafely();
            }
            long ticksToNow = Util.ticksToNow(this.iig);
            Log.i(this.TAG, "remux used " + ticksToNow + " decodeFrame:" + this.iil + ", encodeFrame:" + this.idi + ", drawFrameCount:" + this.iim);
            try {
                com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(this.outputFilePath);
                if (aNx != null) {
                    com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.y(this.idq, ticksToNow);
                    com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.f((long) aNx.videoBitrate, (long) aNx.frameRate, (long) this.videoFps);
                    if (((double) (((float) this.iil) / ((float) this.idi))) >= 1.5d) {
                        com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aOI();
                        AppMethodBeat.o(75297);
                    }
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(75297);
    }

    private final synchronized void eJl() {
        AppMethodBeat.i(75298);
        Log.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.iii) {
            this.iih.aBw();
            this.iii = true;
            try {
                com.tencent.mm.media.f.a aVar = this.ihZ;
                if (aVar != null) {
                    aVar.release();
                }
                HandlerThread handlerThread = this.iia;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                HandlerThread handlerThread2 = this.iib;
                if (handlerThread2 != null) {
                    handlerThread2.quit();
                }
                s.deleteFile(this.outputFilePath);
                Log.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(Util.ticksToNow(this.iig))));
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "onDecoderEncoderFailed error:" + e2.getMessage(), new Object[0]);
            }
            kotlin.g.a.b<? super String, x> bVar = this.iiJ;
            if (bVar != null) {
                bVar.invoke(null);
                AppMethodBeat.o(75298);
            }
        }
        AppMethodBeat.o(75298);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer$Companion;", "", "()V", "CHECK_FRAME_DRWA_TIMEOUT", "", "DECODE_END_FINISH_ENCODE_CHECK_TIMEOUT", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75300);
        AppMethodBeat.o(75300);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e BLH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(e eVar) {
            super(0);
            this.BLH = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75289);
            Log.i(this.BLH.TAG, "onEncodeEnd: " + this.BLH.idi);
            com.tencent.mm.media.e.b bVar = this.BLH.ihT;
            if (bVar != null) {
                bVar.aMj();
            }
            e.a(this.BLH, true);
            x xVar = x.SXb;
            AppMethodBeat.o(75289);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e BLH;
        final /* synthetic */ long iiX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(e eVar, long j2) {
            super(0);
            this.BLH = eVar;
            this.iiX = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75291);
            com.tencent.mm.media.a.a aVar = this.BLH.ihV;
            if (aVar != null) {
                aVar.aLO();
            }
            Log.i(this.BLH.TAG, "mix audio used " + Util.ticksToNow(this.iiX));
            com.tencent.mm.media.f.a aVar2 = this.BLH.ihY;
            if (aVar2 != null) {
                aVar2.release();
            }
            e.a(this.BLH, false);
            x xVar = x.SXb;
            AppMethodBeat.o(75291);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e BLH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(0);
            this.BLH = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75278);
            e.t(this.BLH);
            x xVar = x.SXb;
            AppMethodBeat.o(75278);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e BLH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(0);
            this.BLH = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75279);
            d dVar = this.BLH.BLD;
            if (dVar != null) {
                dVar.startDecode();
                x xVar = x.SXb;
                AppMethodBeat.o(75279);
                return xVar;
            }
            AppMethodBeat.o(75279);
            return null;
        }
    }

    public static final /* synthetic */ void h(e eVar) {
        AppMethodBeat.i(75301);
        Log.i(eVar.TAG, "checkFinishEncode, encodeFrameCount:" + eVar.idi + ", drawFrameCount:" + eVar.iim + ", isFinishEncode:" + eVar.ifd + ", isDecodeEnd:" + eVar.idb);
        if (eVar.idi < eVar.iim || !eVar.idb) {
            if (eVar.idb) {
                MMHandlerThread.removeRunnable(eVar.iiu);
                MMHandlerThread.postToMainThreadDelayed(eVar.iiu, iiL);
            }
            AppMethodBeat.o(75301);
            return;
        }
        eVar.aMi();
        com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOV();
        AppMethodBeat.o(75301);
    }

    public static final /* synthetic */ void t(e eVar) {
        MediaFormat mediaFormat;
        AppMethodBeat.i(75303);
        Log.i(eVar.TAG, "runAudioMix, mixType:" + eVar.idq);
        com.tencent.mm.media.f.a aVar = eVar.ihZ;
        if (aVar != null) {
            aVar.aMr();
        }
        int i2 = eVar.idq;
        if (i2 == 1) {
            com.tencent.mm.media.i.i.a(eVar.ihX, eVar.ihZ);
            eVar.eX(false);
            AppMethodBeat.o(75303);
            return;
        }
        if (kotlin.a.j.listOf((Object[]) new Integer[]{2, 3}).contains(Integer.valueOf(i2))) {
            try {
                long currentTicks = Util.currentTicks();
                eVar.ihV = new com.tencent.mm.media.a.a(eVar.ihX.bufId, eVar.idq, eVar.iiz, 1, new l(eVar));
                com.tencent.mm.media.a.a aVar2 = eVar.ihV;
                if (aVar2 != null) {
                    aVar2.a(eVar.ihZ, eVar.ihY, eVar.ihX.iho, eVar.ihX.remuxEndTime);
                }
                com.tencent.mm.media.f.a aVar3 = eVar.ihY;
                if (aVar3 != null) {
                    mediaFormat = aVar3.igi;
                } else {
                    mediaFormat = null;
                }
                if (mediaFormat == null) {
                    p.hyc();
                }
                if (!mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) {
                    mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, eVar.iiy);
                }
                mediaFormat.setInteger("channel-count", 1);
                com.tencent.mm.media.a.a aVar4 = eVar.ihV;
                if (aVar4 != null) {
                    aVar4.c(mediaFormat);
                }
                com.tencent.mm.media.a.a aVar5 = eVar.ihV;
                if (aVar5 != null) {
                    aVar5.p(new m(eVar, currentTicks));
                    AppMethodBeat.o(75303);
                    return;
                }
                AppMethodBeat.o(75303);
            } catch (Exception e2) {
                Log.printErrStackTrace(eVar.TAG, e2, "mix audio error: " + e2.getMessage(), new Object[0]);
                eVar.eX(false);
                AppMethodBeat.o(75303);
            }
        } else {
            if (i2 == 0) {
                eVar.eX(false);
            }
            AppMethodBeat.o(75303);
        }
    }
}
