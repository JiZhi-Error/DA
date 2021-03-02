package com.tencent.mm.media.i;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010;\u001a\u00020\u0018H\u0002R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R_\u0010\u000e\u001aG\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RX\u0010$\u001a<\u00122\u00120\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0018\u0018\u00010%¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00180%8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R-\u0010-\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0018\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000RJ\u00100\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u001801X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006<"}, hxF = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "Landroid/media/MediaFormat;", "format", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "Lkotlin/Function2;", "getVideoEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setVideoEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"})
public final class g {
    final String TAG = "MicroMsg.RemuxerCallback";
    int frameCount;
    String gWS = "";
    int idq;
    int ihS;
    i ihX;
    com.tencent.mm.media.f.a iiY;
    int iiZ;
    int ija;
    kotlin.g.a.b<? super String, x> ijb;
    public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> ijc = new d(this);
    public q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> ijd = new a(this);
    public kotlin.g.a.b<? super kotlin.g.a.b<? super String, x>, x> ije = new c(this);
    public kotlin.g.a.a<x> ijf = new b(this);
    String outputFilePath = "";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
    static final class a extends kotlin.g.b.q implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x> {
        final /* synthetic */ g ijg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar) {
            super(3);
            this.ijg = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
            AppMethodBeat.i(93817);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            MediaFormat mediaFormat2 = mediaFormat;
            p.h(byteBuffer2, "data");
            p.h(bufferInfo2, "bufferInfo");
            p.h(mediaFormat2, "format");
            i iVar = this.ijg.ihX;
            if (iVar != null) {
                iVar.a(byteBuffer2, bufferInfo2, mediaFormat2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93817);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012%\u0010\u0002\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.g.a.b<? super String, ? extends x>, x> {
        final /* synthetic */ g ijg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar) {
            super(1);
            this.ijg = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: kotlin.g.a.b<? super java.lang.String, ? extends kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(kotlin.g.a.b<? super String, ? extends x> bVar) {
            int i2;
            boolean z;
            int i3 = -1;
            int i4 = 0;
            AppMethodBeat.i(93818);
            Log.i(this.ijg.TAG, "onEncodeEnd");
            this.ijg.ijb = bVar;
            g gVar = this.ijg;
            boolean z2 = gVar.idq == 0;
            if (!Util.isNullOrNil(gVar.outputFilePath)) {
                if (gVar.idq == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (gVar.ihS > 0) {
                    i iVar = gVar.ihX;
                    if (iVar != null) {
                        com.tencent.mm.media.f.a aVar = gVar.iiY;
                        String str = gVar.outputFilePath;
                        int i5 = z ? 0 : gVar.iiZ;
                        if (!z) {
                            i4 = gVar.ija;
                        }
                        i2 = iVar.a(aVar, str, i5, i4, z2);
                    } else {
                        i2 = -1;
                    }
                    SightVideoJNI.tagRotateVideoVFS(gVar.outputFilePath, gVar.gWS, gVar.ihS);
                    s.nx(gVar.gWS, gVar.outputFilePath);
                } else {
                    i iVar2 = gVar.ihX;
                    if (iVar2 != null) {
                        com.tencent.mm.media.f.a aVar2 = gVar.iiY;
                        String str2 = gVar.outputFilePath;
                        int i6 = z ? 0 : gVar.iiZ;
                        if (!z) {
                            i4 = gVar.ija;
                        }
                        i3 = iVar2.a(aVar2, str2, i6, i4, z2);
                    }
                    i2 = i3;
                }
            } else {
                i2 = 0;
            }
            Log.i(gVar.TAG, "output mediaInfo :".concat(String.valueOf(e.aNx(gVar.outputFilePath))));
            Log.i(gVar.TAG, "finish process, ret:".concat(String.valueOf(i2)));
            if (i2 >= 0) {
                kotlin.g.a.b<? super String, x> bVar2 = gVar.ijb;
                if (bVar2 != null) {
                    bVar2.invoke(gVar.outputFilePath);
                }
            } else {
                kotlin.g.a.b<? super String, x> bVar3 = gVar.ijb;
                if (bVar3 != null) {
                    bVar3.invoke(null);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93818);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    static final class d extends kotlin.g.b.q implements m<ByteBuffer, MediaCodec.BufferInfo, x> {
        final /* synthetic */ g ijg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(2);
            this.ijg = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            AppMethodBeat.i(93819);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            p.h(byteBuffer2, "data");
            p.h(bufferInfo2, "bufferInfo");
            i iVar = this.ijg.ihX;
            if (iVar != null) {
                iVar.g(byteBuffer2, bufferInfo2);
            }
            Log.i("MicroMsg.TimeCost", "onFrameDraw : " + this.ijg.frameCount);
            x xVar = x.SXb;
            AppMethodBeat.o(93819);
            return xVar;
        }
    }

    public g(i iVar, com.tencent.mm.media.f.a aVar, String str, int i2, int i3) {
        p.h(iVar, "mixMuxerController");
        p.h(str, "outputFilePath");
        AppMethodBeat.i(93820);
        this.gWS = str + "_" + System.currentTimeMillis() + ".mp4";
        this.ihX = iVar;
        this.iiY = aVar;
        this.outputFilePath = str;
        this.iiZ = i3;
        this.ija = 1;
        this.idq = i2;
        AppMethodBeat.o(93820);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g ijg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(0);
            this.ijg = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            this.ijg.frameCount++;
            return x.SXb;
        }
    }
}
