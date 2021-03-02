package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 f2\u00020\u0001:\u0001fB{\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012>\b\u0002\u0010\t\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\n\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\b\u0010[\u001a\u00020\u0015H\u0016J\n\u0010\\\u001a\u0004\u0018\u00010FH\u0016J\b\u0010]\u001a\u00020\u0015H\u0016J\u001a\u0010^\u001a\u00020\u00102\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010!\u001a\u00020\"H\u0004J\u001a\u0010a\u001a\u00020\u00102\u0012\b\u0002\u0010b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012JF\u0010c\u001a\u00020\u00102>\b\u0002\u0010b\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\nJ\b\u0010d\u001a\u00020\u0010H&J\b\u0010e\u001a\u00020\u0010H\u0016R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010/\"\u0004\b<\u00101RP\u0010\t\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001e\"\u0004\bQ\u0010 R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010/\"\u0004\bS\u00101R\u0014\u0010T\u001a\u00020UX\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010/\"\u0004\bZ\u00101¨\u0006g"}, hxF = {"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "getChannelCount", "getMediaFormat", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "setOnDecodeEndCallback", "callback", "setOnFrameDecodeCallback", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class e {
    private static final int iel = 2048;
    private static final int iem = 4096;
    public static final a ien = new a((byte) 0);
    private int audioChannelCount;
    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    String dtX;
    long endTimeMs;
    MediaFormat ida;
    z iec;
    protected volatile boolean ied;
    int iee;
    long ief;
    private long ieg;
    private boolean ieh;
    com.tencent.mm.media.f.a iei;
    public m<? super byte[], ? super Long, x> iej;
    public kotlin.g.a.a<x> iek;
    private String mime = "";
    long startTimeMs;
    final Object stopLock = new Object();

    public abstract void startDecoder();

    public e(com.tencent.mm.media.f.a aVar, String str, long j2, long j3, m<? super byte[], ? super Long, x> mVar, kotlin.g.a.a<x> aVar2) {
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        p.h(str, "audioId");
        this.iei = aVar;
        this.dtX = str;
        this.startTimeMs = j2;
        this.endTimeMs = j3;
        this.iej = mVar;
        this.iek = aVar2;
        com.tencent.mm.media.f.a aVar3 = this.iei;
        if (aVar3 != null) {
            this.ida = aVar3.igi;
            Log.i("MicroMsg.IAudioDecoder", "create MediaCodecAACDecoder, audioId:" + this.dtX + ", startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs + ", mediaFormat:" + this.ida);
            if (this.ida != null) {
                MediaFormat mediaFormat3 = this.ida;
                if (mediaFormat3 == null) {
                    p.hyc();
                }
                this.audioChannelCount = mediaFormat3.getInteger("channel-count");
                MediaFormat mediaFormat4 = this.ida;
                if (mediaFormat4 != null) {
                    mediaFormat4.setInteger("max-input-size", this.audioChannelCount * 16384);
                }
                MediaFormat mediaFormat5 = this.ida;
                if (mediaFormat5 == null) {
                    p.hyc();
                }
                this.iee = mediaFormat5.getInteger("sample-rate");
                MediaFormat mediaFormat6 = this.ida;
                if (mediaFormat6 == null) {
                    p.hyc();
                }
                String string = mediaFormat6.getString("mime");
                p.g(string, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
                this.mime = string;
                MediaFormat mediaFormat7 = this.ida;
                if (!(mediaFormat7 == null || !mediaFormat7.containsKey("encoder-delay") || (mediaFormat2 = this.ida) == null)) {
                    mediaFormat2.setInteger("encoder-delay", 0);
                }
                MediaFormat mediaFormat8 = this.ida;
                if (!(mediaFormat8 == null || !mediaFormat8.containsKey("encoder-padding") || (mediaFormat = this.ida) == null)) {
                    mediaFormat.setInteger("encoder-padding", 0);
                }
                aVar3.aMr();
                if (this.startTimeMs >= 0) {
                    aVar3.seek(this.startTimeMs * 1000);
                }
                this.iec = z.DZ(this.mime);
                z zVar = this.iec;
                if (zVar != null) {
                    zVar.a(this.ida, (Surface) null, 0);
                }
            }
        }
    }

    public void aMc() {
        Log.printDebugStack("MicroMsg.IAudioDecoder", "stop decoder", new Object[0]);
        synchronized (this.stopLock) {
            Log.i("MicroMsg.IAudioDecoder", "stopDecoder in lock");
            try {
                if (!this.ied) {
                    this.ied = true;
                    z zVar = this.iec;
                    if (zVar != null) {
                        zVar.stop();
                    }
                    z zVar2 = this.iec;
                    if (zVar2 != null) {
                        zVar2.release();
                    }
                    kotlin.g.a.a<x> aVar = this.iek;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    Log.i("MicroMsg.IAudioDecoder", hashCode() + " total decode used " + this.ieg);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.IAudioDecoder", e2, "stopDecoder error", new Object[0]);
            }
            x xVar = x.SXb;
        }
    }

    public int getChannelCount() {
        return this.audioChannelCount;
    }

    public int getSampleRate() {
        return this.iee;
    }

    /* access modifiers changed from: protected */
    public final void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo2) {
        int i2;
        p.h(bufferInfo2, "bufferInfo");
        if (byteBuffer != null) {
            byteBuffer.position(bufferInfo2.offset);
            byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.position(0);
            byteBuffer.get(bArr);
            if (!(bArr.length == 0)) {
                Log.i("MicroMsg.IAudioDecoder", "decoder pcmData size:" + bArr.length + ", pts:" + bufferInfo2.presentationTimeUs + ", audioId:" + this.dtX);
                long ticksToNow = Util.ticksToNow(this.ief);
                this.ieg += ticksToNow;
                Log.i("MicroMsg.IAudioDecoder", hashCode() + " decode frame cost " + ticksToNow);
                this.ieh = true;
                int i3 = this.audioChannelCount == 1 ? iel : iem;
                if (bArr.length > i3) {
                    int length = bArr.length;
                    int i4 = 0;
                    while (length > 0) {
                        if (length > i3) {
                            i2 = i3;
                        } else {
                            i2 = length;
                        }
                        byte[] bArr2 = new byte[i2];
                        System.arraycopy(bArr, i4, bArr2, 0, i2);
                        length -= i2;
                        i4 += i2;
                        Log.i("MicroMsg.IAudioDecoder", "split ret pcmData, leftSize:" + length + ", sizeOffset:" + i4 + ", maxBufferSize:" + i3 + ", copySize:" + i2 + ", data.size:" + bArr2.length);
                        m<? super byte[], ? super Long, x> mVar = this.iej;
                        if (mVar != null) {
                            mVar.invoke(bArr2, Long.valueOf(bufferInfo2.presentationTimeUs));
                        }
                    }
                    return;
                }
                m<? super byte[], ? super Long, x> mVar2 = this.iej;
                if (mVar2 != null) {
                    mVar2.invoke(bArr, Long.valueOf(bufferInfo2.presentationTimeUs));
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/media/decoder/IAudioDecoder$Companion;", "", "()V", "MONO_CHANNEL_BUF_SIZE", "", "STEREO_CHANNLE_BUF_SIZE", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
