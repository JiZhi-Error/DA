package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.os.Looper;
import android.view.Surface;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.media.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020AH&J\b\u0010B\u001a\u00020\u0006H&J\b\u0010C\u001a\u00020\u0016H\u0016J\u0006\u0010D\u001a\u00020\fJ\b\u0010E\u001a\u00020AH&J@\u0010F\u001a\u00020\u000628\u0010G\u001a4\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0006\u0018\u00010'J\u0016\u00102\u001a\u00020\u00062\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103J\u0018\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020(2\u0006\u0010-\u001a\u00020,H\u0004J\b\u0010J\u001a\u00020\u0006H&J\u000e\u0010K\u001a\u00020\u00062\u0006\u0010K\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR-\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#RL\u0010&\u001a4\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0006\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010!\"\u0004\b:\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006L"}, hxF = {"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b {
    private final String TAG = "MicroMsg.IMediaCodecTransEncoder";
    public int frameNum;
    public boolean iex;
    protected Surface ifa;
    public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> ifb;
    public a<x> ifc;
    volatile boolean ifd;
    volatile boolean ife;
    final Object iff = new Object();
    private d ifg;
    private kotlin.g.a.b<? super b, x> ifh;

    public abstract void aMi();

    public abstract void aMj();

    public abstract void aMl();

    public abstract long aMm();

    public b(d dVar, kotlin.g.a.b<? super b, x> bVar) {
        p.h(dVar, "videoCodecConfig");
        this.ifg = dVar;
        this.ifh = bVar;
    }

    /* access modifiers changed from: protected */
    public final Surface aMk() {
        Surface surface = this.ifa;
        if (surface == null) {
            p.btv("codecSurface");
        }
        return surface;
    }

    /* access modifiers changed from: protected */
    public final void g(Surface surface) {
        p.h(surface, "<set-?>");
        this.ifa = surface;
    }

    public final Surface getInputSurface() {
        Surface surface = this.ifa;
        if (surface == null) {
            p.btv("codecSurface");
        }
        return surface;
    }

    /* access modifiers changed from: protected */
    public final void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        p.h(byteBuffer, "buffer");
        p.h(bufferInfo, "bufferInfo");
        Log.i(this.TAG, "processEncodeBuffer, buffer " + byteBuffer + ", pts: " + bufferInfo.presentationTimeUs + ", size: " + bufferInfo.size + ", isMain: " + p.j(Looper.getMainLooper(), Looper.myLooper()));
        m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> mVar = this.ifb;
        if (mVar != null) {
            mVar.invoke(byteBuffer, bufferInfo);
        }
        this.frameNum++;
    }
}
