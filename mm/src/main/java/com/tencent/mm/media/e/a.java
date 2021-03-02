package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.decoder.EncoderWriter;
import java.nio.ByteBuffer;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0005\b&\u0018\u0000 F2\u00020\u0001:\u0001FBl\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012M\u0010\u0004\u001aI\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010<\u001a\u00020\rJ\u0006\u0010=\u001a\u00020+J\u0018\u0010>\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010@\u001a\u00020\rH\u0004J \u0010A\u001a\u00020\r2\u0006\u0010\t\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020+H&J\u0006\u0010E\u001a\u00020\rR\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!Ra\u0010\u0004\u001aI\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001b¨\u0006G"}, hxF = {"Lcom/tencent/mm/media/encoder/IAudioEncoder;", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "format", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "dstMediaFormat", "getDstMediaFormat", "()Landroid/media/MediaFormat;", "setDstMediaFormat", "(Landroid/media/MediaFormat;)V", "encodeStartTick", "", "getEncodeStartTick", "()J", "setEncodeStartTick", "(J)V", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getEncoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setEncoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "getFrameEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setFrameEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "getFrameEncodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameEncodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "mMimeType", "", "getMMimeType", "()Ljava/lang/String;", "setMMimeType", "(Ljava/lang/String;)V", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalEncodeTime", "getTotalEncodeTime", "setTotalEncodeTime", "finishEncode", "isIgnoreCodecConfig", "processEncodeBuffer", "buffer", "releaseEncoder", "startEncoder", "", "pts", "isLast", "stopEncoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a {
    public static final C0413a ieZ = new C0413a((byte) 0);
    volatile boolean idt;
    z ieT;
    MediaFormat ieU;
    long ieV;
    private long ieW;
    private q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> ieX;
    private kotlin.g.a.a<x> ieY;
    private String mMimeType;
    final Object stopLock = new Object();

    public abstract void b(byte[] bArr, long j2, boolean z);

    public a(MediaFormat mediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> qVar, kotlin.g.a.a<x> aVar) {
        int i2 = 1;
        p.h(mediaFormat, "mediaFormat");
        p.h(qVar, "frameEncodeCallback");
        p.h(aVar, "frameEncodeEndCallback");
        this.ieX = qVar;
        this.ieY = aVar;
        Log.i("MicroMsg.IAudioEncoder", "init audio encoder");
        this.mMimeType = mediaFormat.getString("mime");
        try {
            this.ieU = new MediaFormat();
            this.ieU.setString("mime", EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
            this.ieU.setInteger("aac-profile", 2);
            this.ieU.setInteger("sample-rate", 44100);
            int integer = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 0;
            i2 = integer > 0 ? integer : i2;
            this.ieU.setInteger("channel-count", i2);
            this.ieU.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE));
            this.ieU.setInteger("max-input-size", i2 * 2048);
            z Ea = z.Ea(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
            p.g(Ea, "MediaCodecProxy.createEncoderByType(AAC_MIME_TYPE)");
            this.ieT = Ea;
            this.ieT.a(this.ieU, (Surface) null, 1);
            Log.i("MicroMsg.IAudioEncoder", "finish init audio encoder, dstMediaFormat:" + this.ieU);
        } catch (Exception e2) {
            throw new IllegalStateException("init encoder error");
        }
    }

    /* access modifiers changed from: protected */
    public final void d(MediaFormat mediaFormat) {
        p.h(mediaFormat, "<set-?>");
        this.ieU = mediaFormat;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/media/encoder/IAudioEncoder$Companion;", "", "()V", "AAC_MIME_TYPE", "", "TAG", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.e.a$a  reason: collision with other inner class name */
    public static final class C0413a {
        private C0413a() {
        }

        public /* synthetic */ C0413a(byte b2) {
            this();
        }
    }

    public final void aMh() {
        aMj();
    }

    public final void aMi() {
        aMj();
    }

    public final void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        p.h(bufferInfo, "bufferInfo");
        if (byteBuffer == null) {
            Log.e("MicroMsg.IAudioEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        } else if (bufferInfo.size > 0) {
            Log.i("MicroMsg.IAudioEncoder", "encoder output buffer:" + bufferInfo.size + ", pts:" + bufferInfo.presentationTimeUs);
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            long ticksToNow = Util.ticksToNow(this.ieV);
            this.ieW += ticksToNow;
            Log.i("MicroMsg.IAudioEncoder", hashCode() + " encode frame used " + ticksToNow);
            this.ieX.d(byteBuffer, bufferInfo, this.ieU);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void aMj() {
        try {
            synchronized (this.stopLock) {
                if (!this.idt) {
                    this.idt = true;
                    Log.i("MicroMsg.IAudioEncoder", "releaseEncoder");
                    this.ieT.stop();
                    this.ieT.release();
                    this.ieY.invoke();
                }
                Log.i("MicroMsg.IAudioEncoder", "total encode used " + this.ieW);
                x xVar = x.SXb;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.IAudioEncoder", "releaseEncoder error: %s", e2.getMessage());
        }
        return;
    }
}
