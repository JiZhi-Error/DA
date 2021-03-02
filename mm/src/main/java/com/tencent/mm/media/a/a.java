package com.tencent.mm.media.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Message;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001MBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0002\u0010\rJ \u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0019H\u0002J*\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,J\u000e\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u000bJ*\u0010;\u001a\u00020\f2\b\u0010<\u001a\u0004\u0018\u00010\"2\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,J \u0010=\u001a\u00020\f2\u0006\u0010/\u001a\u00020\t2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u000bH\u0002J\b\u0010@\u001a\u00020\fH\u0002J\b\u0010A\u001a\u00020\fH\u0002J\u001a\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020,H\u0002J\u0010\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u0019H\u0002J\b\u0010F\u001a\u00020\fH\u0002J\b\u0010G\u001a\u00020\fH\u0002J\u0018\u0010H\u001a\u00020\f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,H\u0002J\b\u0010I\u001a\u00020\fH\u0002J\u001a\u0010J\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020,H\u0002J\u0018\u0010K\u001a\u00020\u00192\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010*H\u0016J\b\u0010L\u001a\u00020\u0019H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, hxF = {"Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "Lcom/tencent/mm/media/codec/IAudioCodec;", "bufId", "", "mixType", "sampleRate", "channelCount", "onFrameEncode", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Landroid/media/MediaCodec$BufferInfo;", "Landroid/media/MediaFormat;", "", "(IIIILkotlin/jvm/functions/Function3;)V", "TAG", "", "cacheAACFilePath", "decodeBackgroundFrameCount", "decodeMusicFrameCount", "encodeFrameCount", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "isBackgroundDecodeEnd", "", "isDecodeEnd", "isMusicDecodeEnd", "isPostEncodeEnd", "mAudioEncoder", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mAudioMixCodec", "Lcom/tencent/mm/media/mix/AudioMixCodec;", "mBackgroundDecoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mBackgroundDecoderRunnable", "Ljava/lang/Runnable;", "mMediaFormat", "mMusicDecoder", "mMusicDecoderRunnable", "mixCount", "mixFinishCallback", "Lkotlin/Function0;", "mixStartTime", "", "useAsync", "checkPostEncoder", "data", "", "pts", "isEnd", "initDecoder", "background", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "music", "startTime", "endTime", "initEncoder", "mediaFormat", "initWithBackgroundDecoder", "backgroundDecoder", "onAudioFrameEncode", "bufferInfo", "format", "onAudioFrameEncodeEnd", "onBackgroundDecodeEnd", "onBackgroundFrameDecodeEnd", "pcmData", "onDecodeEnd", "isBackground", "onEncodeEnd", "onFrameMix", "onFrameMixEnd", "onMusicDecodeEnd", "onMusicFrameDecodeEnd", "startCodec", "stopCodec", "EncoderData", "plugin-mediaeditor_release"})
public final class a {
    public final String TAG = "MicroMsg.MediaCodecAACCodec";
    private final int bufId;
    private final int channelCount;
    private int dwu;
    public com.tencent.mm.media.d.e icW;
    public com.tencent.mm.media.d.e icX;
    com.tencent.mm.media.e.a icY;
    private com.tencent.mm.media.h.a icZ;
    private MediaFormat ida;
    private volatile boolean idb;
    private boolean idc;
    private boolean idd;
    private HandlerThread ide;
    private MMHandler idf;
    private kotlin.g.a.a<kotlin.x> idg;
    private final String idh;
    private int idi;
    private int idj;
    private int idk;
    Runnable idl;
    Runnable idm;
    public boolean idn;
    private long ido;
    boolean idp;
    private int idq;
    private final kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, kotlin.x> idr;
    private final int sampleRate;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "audioData", "", "pts", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93475);
            byte[] bArr2 = bArr;
            long longValue = l.longValue();
            kotlin.g.b.p.h(bArr2, "audioData");
            a.b(this.ids, bArr2, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93475);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93476);
            long longValue = l.longValue();
            a.a(this.ids, bArr, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93476);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93478);
            long longValue = l.longValue();
            a.a(this.ids, bArr, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93478);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93480);
            long longValue = l.longValue();
            a.c(this.ids, bArr, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93480);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93482);
            long longValue = l.longValue();
            a.c(this.ids, bArr, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93482);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "pcmData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "desMediaFormat", "Landroid/media/MediaFormat;", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(a aVar) {
            super(3);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
            AppMethodBeat.i(93483);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            MediaFormat mediaFormat2 = mediaFormat;
            kotlin.g.b.p.h(byteBuffer2, "pcmData");
            kotlin.g.b.p.h(bufferInfo2, "bufferInfo");
            kotlin.g.b.p.h(mediaFormat2, "desMediaFormat");
            a.a(this.ids, byteBuffer2, bufferInfo2, mediaFormat2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93483);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "pcmData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "desMediaFormat", "Landroid/media/MediaFormat;", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(a aVar) {
            super(3);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
            AppMethodBeat.i(93485);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            MediaFormat mediaFormat2 = mediaFormat;
            kotlin.g.b.p.h(byteBuffer2, "pcmData");
            kotlin.g.b.p.h(bufferInfo2, "bufferInfo");
            kotlin.g.b.p.h(mediaFormat2, "desMediaFormat");
            a.a(this.ids, byteBuffer2, bufferInfo2, mediaFormat2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93485);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93487);
            long longValue = l.longValue();
            a.a(this.ids, bArr, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93487);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93489);
            long longValue = l.longValue();
            a.c(this.ids, bArr, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93489);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.m<byte[], Long, kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(a aVar) {
            super(2);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
            AppMethodBeat.i(93491);
            long longValue = l.longValue();
            a.c(this.ids, bArr, longValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93491);
            return xVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: kotlin.g.a.q<? super java.nio.ByteBuffer, ? super android.media.MediaCodec$BufferInfo, ? super android.media.MediaFormat, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(int i2, int i3, int i4, int i5, kotlin.g.a.q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, kotlin.x> qVar) {
        AppMethodBeat.i(93504);
        this.bufId = i2;
        this.idq = i3;
        this.sampleRate = i4;
        this.channelCount = i5;
        this.idr = qVar;
        HandlerThread hB = com.tencent.f.c.d.hB("MediaCodecAACCodec_EncodeThread", 5);
        kotlin.g.b.p.g(hB, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
        this.ide = hB;
        this.idh = com.tencent.mm.loader.j.b.aKJ() + "cache.pcm";
        this.idl = new w(this);
        this.idm = new x(this);
        Log.i(this.TAG, "init MediaCodecAACCodec, sampleRate:" + this.sampleRate + ", channelCount:" + this.channelCount);
        this.icZ = new com.tencent.mm.media.h.a(this.sampleRate, this.channelCount, kotlin.a.j.listOf((Object[]) new Integer[]{3, 1}).contains(Integer.valueOf(this.idq)), kotlin.a.j.listOf((Object[]) new Integer[]{2, 3}).contains(Integer.valueOf(this.idq)), new kotlin.g.a.a<kotlin.x>(this) {
            /* class com.tencent.mm.media.a.a.AnonymousClass1 */
            final /* synthetic */ a ids;

            {
                this.ids = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(93466);
                a.b(this.ids);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(93466);
                return xVar;
            }
        }, new kotlin.g.a.m<byte[], Long, kotlin.x>(this) {
            /* class com.tencent.mm.media.a.a.AnonymousClass2 */
            final /* synthetic */ a ids;

            {
                this.ids = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ kotlin.x invoke(byte[] bArr, Long l) {
                AppMethodBeat.i(93467);
                byte[] bArr2 = bArr;
                long longValue = l.longValue();
                kotlin.g.b.p.h(bArr2, "audioData");
                a.b(this.ids, bArr2, longValue);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(93467);
                return xVar;
            }
        });
        AppMethodBeat.o(93504);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class w implements Runnable {
        final /* synthetic */ a ids;

        w(a aVar) {
            this.ids = aVar;
        }

        public final void run() {
            AppMethodBeat.i(93493);
            com.tencent.mm.media.d.e eVar = this.ids.icX;
            if (eVar != null) {
                eVar.startDecoder();
                AppMethodBeat.o(93493);
                return;
            }
            AppMethodBeat.o(93493);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class x implements Runnable {
        final /* synthetic */ a ids;

        x(a aVar) {
            this.ids = aVar;
        }

        public final void run() {
            AppMethodBeat.i(93494);
            com.tencent.mm.media.d.e eVar = this.ids.icW;
            if (eVar != null) {
                eVar.startDecoder();
                AppMethodBeat.o(93494);
                return;
            }
            AppMethodBeat.o(93494);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/media/codec/MediaCodecAACCodec$EncoderData;", "", "data", "", "pts", "", "isEnd", "", "([BJZ)V", "getData", "()[B", "()Z", "getPts", "()J", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.a.a$a  reason: collision with other inner class name */
    public static final class C0410a {
        final byte[] data;
        final boolean idt;
        final long pts;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (r5.idt == r6.idt) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 93471(0x16d1f, float:1.30981E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0026
                boolean r0 = r6 instanceof com.tencent.mm.media.a.a.C0410a
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.media.a.a$a r6 = (com.tencent.mm.media.a.a.C0410a) r6
                byte[] r0 = r5.data
                byte[] r1 = r6.data
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002b
                long r0 = r5.pts
                long r2 = r6.pts
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002b
                boolean r0 = r5.idt
                boolean r1 = r6.idt
                if (r0 != r1) goto L_0x002b
            L_0x0026:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x002a:
                return r0
            L_0x002b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.a.a.C0410a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(93470);
            byte[] bArr = this.data;
            int hashCode = bArr != null ? Arrays.hashCode(bArr) : 0;
            long j2 = this.pts;
            int i2 = ((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            boolean z = this.idt;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 + i2;
            AppMethodBeat.o(93470);
            return i6;
        }

        public final String toString() {
            AppMethodBeat.i(93469);
            String str = "EncoderData(data=" + Arrays.toString(this.data) + ", pts=" + this.pts + ", isEnd=" + this.idt + ")";
            AppMethodBeat.o(93469);
            return str;
        }

        public C0410a(byte[] bArr, long j2, boolean z) {
            kotlin.g.b.p.h(bArr, "data");
            AppMethodBeat.i(93468);
            this.data = bArr;
            this.pts = j2;
            this.idt = z;
            AppMethodBeat.o(93468);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr, long j2, boolean z2) {
        AppMethodBeat.i(93498);
        if (this.idf == null) {
            this.ide.start();
            this.idf = new MMHandler(this.ide.getLooper(), new b(this));
        }
        if (z2) {
            this.idp = true;
        }
        MMHandler mMHandler = this.idf;
        Message obtainMessage = mMHandler != null ? mMHandler.obtainMessage() : null;
        if (obtainMessage != null) {
            obtainMessage.what = 1024;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.g.b.p.g(copyOf, "Arrays.copyOf(data, data.size)");
        C0410a aVar = new C0410a(copyOf, j2, z2);
        if (obtainMessage != null) {
            obtainMessage.obj = aVar;
        }
        MMHandler mMHandler2 = this.idf;
        if (mMHandler2 != null) {
            mMHandler2.sendMessage(obtainMessage);
            AppMethodBeat.o(93498);
            return;
        }
        AppMethodBeat.o(93498);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    public static final class b implements MMHandler.Callback {
        final /* synthetic */ a ids;

        b(a aVar) {
            this.ids = aVar;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(93472);
            if (message.what == 1024) {
                Object obj = message.obj;
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.media.codec.MediaCodecAACCodec.EncoderData");
                    AppMethodBeat.o(93472);
                    throw tVar;
                }
                C0410a aVar = (C0410a) obj;
                Log.i(this.ids.TAG, "start encode data " + aVar.data.length + ", pts:" + aVar.pts + ", isLast: " + aVar.idt);
                com.tencent.mm.media.e.a aVar2 = this.ids.icY;
                if (aVar2 == null) {
                    kotlin.g.b.p.btv("mAudioEncoder");
                }
                aVar2.b(aVar.data, aVar.pts, aVar.idt);
            }
            AppMethodBeat.o(93472);
            return false;
        }
    }

    public final void a(com.tencent.mm.media.f.a aVar, com.tencent.mm.media.f.a aVar2, long j2, long j3) {
        MediaFormat mediaFormat;
        com.tencent.mm.media.d.h hVar;
        com.tencent.mm.media.d.h hVar2;
        AppMethodBeat.i(93499);
        Log.i(this.TAG, "init decoder background " + aVar + "music is " + aVar2);
        if (aVar != null) {
            try {
                mediaFormat = aVar.igi;
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOD();
                Exception exc = e2;
                AppMethodBeat.o(93499);
                throw exc;
            }
        } else {
            mediaFormat = null;
        }
        this.ida = mediaFormat;
        if (this.ida == null && this.idq == 3) {
            this.idq = 2;
            Log.w(this.TAG, "background AudioFormat is null, recreate AudioMixCodec, sampleRate:" + this.sampleRate + ", channelCount:" + this.channelCount);
            this.icZ = new com.tencent.mm.media.h.a(this.sampleRate, this.channelCount, kotlin.a.j.listOf((Object[]) new Integer[]{3, 1}).contains(Integer.valueOf(this.idq)), kotlin.a.j.listOf((Object[]) new Integer[]{2, 3}).contains(Integer.valueOf(this.idq)), new c(this), new e(this));
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOJ();
        }
        if (this.idq == 3 && aVar != null) {
            this.ida = aVar.igi;
            if (com.tencent.mm.compatible.util.d.oE(23)) {
                hVar2 = new com.tencent.mm.media.d.g(aVar, "background", j2, j3, new f(this), new g(this));
            } else {
                this.idn = true;
                hVar2 = new com.tencent.mm.media.d.h(aVar, "background", j2, j3, new h(this), new i(this));
            }
            this.icX = hVar2;
        }
        if (aVar2 != null) {
            if (com.tencent.mm.compatible.util.d.oE(23)) {
                hVar = new com.tencent.mm.media.d.g(aVar2, "music", 0, j3 - j2, new j(this), new k(this));
            } else {
                this.idn = true;
                hVar = new com.tencent.mm.media.d.h(aVar2, "music", 0, j3 - j2, new l(this), new d(this));
            }
            this.icW = hVar;
            AppMethodBeat.o(93499);
            return;
        }
        AppMethodBeat.o(93499);
    }

    private final synchronized void eS(boolean z2) {
        AppMethodBeat.i(93500);
        Log.printInfoStack(this.TAG, "onDecodeEnd, isDecodeEnd:" + this.idb + ", isBackground:" + z2 + ", mixCount:" + this.dwu + ", decodeMusicFrameCount:" + this.idk + ", decodeBackgroundFrameCount:" + this.idj, new Object[0]);
        if (z2) {
            this.idd = true;
        } else {
            this.idc = true;
        }
        if (this.idq == 3 && this.idc && this.idd) {
            if (!this.idb) {
                this.idb = true;
                com.tencent.mm.media.d.e eVar = this.icW;
                if (eVar != null) {
                    eVar.aMc();
                }
                com.tencent.mm.media.d.e eVar2 = this.icX;
                if (eVar2 != null) {
                    eVar2.aMc();
                }
                a(new byte[0], Util.currentTicks(), true);
                AppMethodBeat.o(93500);
            }
            AppMethodBeat.o(93500);
        } else if (this.idq != 2 || !this.idc) {
            if (this.idq == 1 && this.idd && !this.idb) {
                this.idb = true;
                com.tencent.mm.media.d.e eVar3 = this.icX;
                if (eVar3 != null) {
                    eVar3.aMc();
                    AppMethodBeat.o(93500);
                }
            }
            AppMethodBeat.o(93500);
        } else {
            if (!this.idb) {
                this.idb = true;
                com.tencent.mm.media.d.e eVar4 = this.icW;
                if (eVar4 != null) {
                    eVar4.aMc();
                }
                MMHandler mMHandler = this.idf;
                if (mMHandler != null) {
                    mMHandler.postDelayed(new y(this), 200);
                    AppMethodBeat.o(93500);
                } else {
                    AppMethodBeat.o(93500);
                }
            }
            AppMethodBeat.o(93500);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class y implements Runnable {
        final /* synthetic */ a ids;

        y(a aVar) {
            this.ids = aVar;
        }

        public final void run() {
            AppMethodBeat.i(93495);
            Log.i(this.ids.TAG, "mixMusic onDecodeEnd delay check, isPostEncodeEnd:" + this.ids.idp);
            if (!this.ids.idp) {
                this.ids.a(new byte[0], Util.currentTicks(), true);
            }
            AppMethodBeat.o(93495);
        }
    }

    public final void c(MediaFormat mediaFormat) {
        com.tencent.mm.media.e.a dVar;
        AppMethodBeat.i(93501);
        kotlin.g.b.p.h(mediaFormat, "mediaFormat");
        try {
            if (com.tencent.mm.compatible.util.d.oE(23)) {
                dVar = new com.tencent.mm.media.e.c(mediaFormat, new m(this), new n(this));
            } else {
                this.idn = true;
                dVar = new com.tencent.mm.media.e.d(mediaFormat, new o(this), new p(this));
            }
            this.icY = dVar;
            AppMethodBeat.o(93501);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOE();
            AppMethodBeat.o(93501);
        }
    }

    public final boolean p(kotlin.g.a.a<kotlin.x> aVar) {
        AppMethodBeat.i(93502);
        com.tencent.mm.media.h.a aVar2 = this.icZ;
        if (aVar2 != null) {
            Log.i(aVar2.TAG, "startMix");
            aVar2.igG = true;
            com.tencent.mm.ac.d.a("AudioMixCodec_MixAudio", true, (kotlin.g.a.a) new a.c(aVar2));
        }
        if (this.idq == 3 || this.idq == 1) {
            com.tencent.mm.ac.d.a("BackgroundDecoder", true, (kotlin.g.a.a) new z(this));
        }
        if (this.icW != null) {
            com.tencent.mm.ac.d.a("MusicDecoder", true, (kotlin.g.a.a) new aa(this));
        }
        Log.i(this.TAG, "startCodec");
        this.idg = aVar;
        this.ido = Util.currentTicks();
        AppMethodBeat.o(93502);
        return true;
    }

    public final boolean aLO() {
        AppMethodBeat.i(93503);
        Log.i(this.TAG, "stopCodec, isPostDecodeEnd:" + this.idp);
        com.tencent.mm.media.d.e eVar = this.icX;
        if (eVar != null) {
            eVar.aMc();
        }
        com.tencent.mm.media.d.e eVar2 = this.icW;
        if (eVar2 != null) {
            eVar2.aMc();
        }
        com.tencent.mm.media.e.a aVar = this.icY;
        if (aVar == null) {
            kotlin.g.b.p.btv("mAudioEncoder");
        }
        aVar.aMh();
        this.ide.quitSafely();
        if (this.ido > 0) {
            long ticksToNow = Util.ticksToNow(this.ido);
            if (this.idn) {
                com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOG();
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.zR(ticksToNow);
            } else {
                com.tencent.mm.media.k.e eVar5 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOH();
                com.tencent.mm.media.k.e eVar6 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.zS(ticksToNow);
            }
        }
        AppMethodBeat.o(93503);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93488);
            a.a(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93488);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93490);
            a.c(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93490);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93492);
            a.c(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93492);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93473);
            a.b(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93473);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93477);
            a.a(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93477);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93479);
            a.a(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93479);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93481);
            a.c(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93481);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93474);
            a.c(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93474);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93484);
            a.d(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93484);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93486);
            a.d(this.ids);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93486);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93496);
            Log.i(this.ids.TAG, "startCodec BackgroundDecoder");
            this.ids.idl.run();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93496);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a ids;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(a aVar) {
            super(0);
            this.ids = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(93497);
            Log.i(this.ids.TAG, "startCodec MusicDecoder");
            this.ids.idm.run();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(93497);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, byte[] bArr, long j2) {
        AppMethodBeat.i(93505);
        Log.i(aVar.TAG, "on background frame decode, isDecodeEnd:" + aVar.idb);
        if (!aVar.idb) {
            aVar.idj++;
            if (bArr != null) {
                Log.i(aVar.TAG, "input background data");
                com.tencent.mm.media.d.e eVar = aVar.icX;
                if (eVar != null) {
                    com.tencent.mm.media.h.a aVar2 = aVar.icZ;
                    if (aVar2 != null) {
                        aVar2.a(bArr, "background", j2, eVar.getSampleRate(), eVar.getChannelCount());
                        AppMethodBeat.o(93505);
                        return;
                    }
                    AppMethodBeat.o(93505);
                    return;
                }
            }
        }
        AppMethodBeat.o(93505);
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(93506);
        Log.i(aVar.TAG, "on background decode end");
        com.tencent.mm.media.h.a aVar2 = aVar.icZ;
        if (aVar2 != null) {
            aVar2.Hm("background");
        }
        aVar.eS(true);
        AppMethodBeat.o(93506);
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(93507);
        Log.i(aVar.TAG, "onFrameMix");
        AppMethodBeat.o(93507);
    }

    public static final /* synthetic */ void b(a aVar, byte[] bArr, long j2) {
        boolean z2 = true;
        AppMethodBeat.i(93508);
        aVar.dwu++;
        Log.i(aVar.TAG, "onFrameMixEnd, mixCount:" + aVar.dwu + ", decodeMusicFrameCount:" + aVar.idk + ", decodeBackgroundFrameCount:" + aVar.idj + ", mixType:" + aVar.idq + ", data:" + bArr.length + ", pts:" + j2);
        if (aVar.idq == 3) {
            if (!aVar.idb || aVar.dwu != aVar.idj) {
                z2 = false;
            }
            aVar.a(bArr, j2, z2);
            AppMethodBeat.o(93508);
        } else if (!aVar.idb) {
            aVar.a(bArr, j2, false);
            AppMethodBeat.o(93508);
        } else if (aVar.idq == 2) {
            if (!aVar.idb || aVar.dwu != aVar.idk) {
                z2 = false;
            }
            aVar.a(bArr, j2, z2);
            AppMethodBeat.o(93508);
        } else {
            if (!aVar.idb || aVar.dwu != aVar.idj) {
                z2 = false;
            }
            aVar.a(bArr, j2, z2);
            AppMethodBeat.o(93508);
        }
    }

    public static final /* synthetic */ void c(a aVar, byte[] bArr, long j2) {
        com.tencent.mm.media.h.a aVar2;
        AppMethodBeat.i(93509);
        Log.i(aVar.TAG, "on music frame decode, isDecodeEnd:" + aVar.idb);
        if (!aVar.idb || aVar.idk != aVar.idj) {
            aVar.idk++;
            if (bArr != null) {
                com.tencent.mm.media.d.e eVar = aVar.icW;
                if (!(eVar == null || (aVar2 = aVar.icZ) == null)) {
                    aVar2.a(bArr, "music", j2, eVar.getSampleRate(), eVar.getChannelCount());
                }
                Log.i(aVar.TAG, "input music data");
            }
        }
        AppMethodBeat.o(93509);
    }

    public static final /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(93510);
        Log.i(aVar.TAG, "on music decode end");
        com.tencent.mm.media.h.a aVar2 = aVar.icZ;
        if (aVar2 != null) {
            aVar2.Hm("music");
        }
        aVar.eS(false);
        AppMethodBeat.o(93510);
    }

    public static final /* synthetic */ void a(a aVar, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
        AppMethodBeat.i(93511);
        String str = aVar.TAG;
        StringBuilder append = new StringBuilder("encode end ,data size is ").append(byteBuffer).append(' ');
        int i2 = aVar.idi;
        aVar.idi = i2 + 1;
        Log.i(str, append.append(i2).toString());
        kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, kotlin.x> qVar = aVar.idr;
        if (qVar != null) {
            qVar.d(byteBuffer, bufferInfo, mediaFormat);
            AppMethodBeat.o(93511);
            return;
        }
        AppMethodBeat.o(93511);
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: ? super byte[] */
    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(93512);
        Log.i(aVar.TAG, "onFrameEncodeEnd, mixCount:" + aVar.dwu);
        com.tencent.mm.media.h.a aVar2 = aVar.icZ;
        if (aVar2 != null) {
            Log.i(aVar2.TAG, "stopMix");
            List<com.tencent.mm.audio.mix.a.e> list = aVar2.igE;
            kotlin.g.b.p.g(list, "pcmDataList");
            synchronized (list) {
                try {
                    aVar2.igE.clear();
                    kotlin.x xVar = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(93512);
                }
            }
            synchronized (aVar2.igI) {
                try {
                    aVar2.igH = true;
                    try {
                        aVar2.igI.notifyAll();
                    } catch (Exception e2) {
                    }
                    kotlin.x xVar2 = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(93512);
                }
            }
            Log.i(aVar2.TAG, "isMixingFinish1 " + aVar2.igF);
            if (!aVar2.igF) {
                synchronized (aVar2.igJ) {
                    try {
                        if (!aVar2.igF) {
                            Log.i(aVar2.TAG, "isMixingFinish2 " + aVar2.igF);
                            aVar2.igJ.wait();
                        }
                    } catch (Exception e3) {
                    }
                    try {
                        kotlin.x xVar3 = kotlin.x.SXb;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            byte[] ZC = aVar2.igz.ZC();
            aVar2.igz.release();
            Log.i(aVar2.TAG, "stopMix, final dstAudio:" + (ZC != null ? ZC.length : 0));
            if (ZC != null) {
                aVar2.igS.invoke(ZC, Long.valueOf(aVar2.igB));
            } else {
                aVar2.igS.invoke(new byte[0], Long.valueOf(aVar2.igB));
            }
            Log.i(aVar2.TAG, "stopMix finish");
        }
        com.tencent.mm.media.e.a aVar3 = aVar.icY;
        if (aVar3 == null) {
            kotlin.g.b.p.btv("mAudioEncoder");
        }
        aVar3.aMh();
        com.tencent.mm.media.e.a aVar4 = aVar.icY;
        if (aVar4 == null) {
            kotlin.g.b.p.btv("mAudioEncoder");
        }
        aVar4.aMi();
        kotlin.g.a.a<kotlin.x> aVar5 = aVar.idg;
        if (aVar5 != null) {
            aVar5.invoke();
            AppMethodBeat.o(93512);
            return;
        }
        AppMethodBeat.o(93512);
    }
}
