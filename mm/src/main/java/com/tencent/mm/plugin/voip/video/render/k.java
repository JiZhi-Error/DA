package com.tencent.mm.plugin.voip.video.render;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.video.c.b;
import com.tencent.mm.plugin.voip.video.c.c;
import com.tencent.mm.plugin.voip.video.c.e;
import com.tencent.mm.plugin.voip.video.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 `2\u00020\u0001:\u0001`B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010G\u001a\u00020#H\u0014J\b\u0010H\u001a\u00020#H\u0014J\r\u0010I\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010JJ\r\u0010K\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010JJ\b\u0010L\u001a\u0004\u0018\u00010\u0018J\b\u0010M\u001a\u0004\u0018\u00010*J\b\u0010N\u001a\u00020#H\u0016J\b\u0010O\u001a\u00020#H\u0014J\u000e\u0010P\u001a\u00020#2\u0006\u0010Q\u001a\u00020\u0018J\u0010\u0010R\u001a\u00020#2\u0006\u0010Q\u001a\u00020\u0003H\u0016J\u0016\u0010S\u001a\u00020#2\u0006\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\rJ\u0016\u0010V\u001a\u00020#2\u0006\u0010T\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u0003J\u0018\u0010X\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0003H\u0016J\u001e\u0010[\u001a\u00020#2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0003J\u0018\u0010_\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u000e\u0010\u001f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R4\u0010 \u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!j\u0004\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R@\u0010+\u001a(\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#\u0018\u00010,j\u0004\u0018\u0001`.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R@\u00103\u001a(\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#\u0018\u00010,j\u0004\u0018\u0001`4X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00102R\u0010\u00107\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0014\"\u0004\b>\u0010\u0016R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "beautyInputTexture", "beautyParam", "encodeMirror", "", "getEncodeMirror", "()Z", "setEncodeMirror", "(Z)V", "encodeRotate", "getEncodeRotate", "()I", "setEncodeRotate", "(I)V", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalTexture", "faceBeautyAlgo", "getFaceBeautyAlgo", "setFaceBeautyAlgo", "isFaceBeautyAlogChanged", "setFaceBeautyAlogChanged", "isViewPortChange", "mSTFilterMotionNoiseDataCallback", "Lkotlin/Function2;", "", "", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseDataCallBack;", "getMSTFilterMotionNoiseDataCallback", "()Lkotlin/jvm/functions/Function2;", "setMSTFilterMotionNoiseDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "mSTFilterMotionNoiseDataTemp", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFitlerMotionNoiseData;", "onFaceBeautyDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "getOnFaceBeautyDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnFaceBeautyDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onSTFilterDataCallback", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "getOnSTFilterDataCallback", "setOnSTFilterDataCallback", "outputTexturObject", "programId", "stFilterOutputTexturObject", "stFilterProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "stfilterParam", "getStfilterParam", "setStfilterParam", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "useSTfilterScreenOut", "useSkipFilterProcess", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getDrawHeight", "()Ljava/lang/Integer;", "getDrawWidth", "getOutputRendererTexture", "getSTFilterMotionNoiseData", "release", "renderImpl", "setInputGLTexture", "texture", "setInputTexture", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoipBeauty", "algorithm", "updateDrawViewSize", "width", "height", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class k extends com.tencent.mm.media.j.b.a {
    public static final a Hpg = new a((byte) 0);
    private int HiD;
    private int HoM = -1;
    com.tencent.mm.plugin.voip.video.c.c HoN;
    com.tencent.mm.plugin.voip.video.c.b HoO;
    g HoP;
    com.tencent.mm.plugin.voip.video.c.e HoQ;
    com.tencent.mm.media.g.d HoR;
    r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> HoS;
    r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> HoT;
    private boolean HoU = true;
    boolean HoV;
    private int HoW;
    int HoX;
    private int HoY;
    int HoZ;
    private boolean Hpa;
    boolean Hpb;
    com.tencent.mm.media.g.d Hpc;
    private com.tencent.mm.media.g.d Hpd;
    private com.tencent.mm.plugin.voip.video.d.a Hpe = new com.tencent.mm.plugin.voip.video.d.a();
    m<? super Integer, ? super Float, x> Hpf;
    int ikx = -1;
    private int programId;

    static {
        AppMethodBeat.i(236329);
        AppMethodBeat.o(236329);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "motion", "", "noise", "", "invoke"})
    static final class b extends q implements m<Integer, Float, x> {
        final /* synthetic */ k Hph;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(k kVar) {
            super(2);
            this.Hph = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Float f2) {
            AppMethodBeat.i(236313);
            int intValue = num.intValue();
            float floatValue = f2.floatValue();
            this.Hph.Hpe.HpA = intValue;
            this.Hph.Hpe.HpB = floatValue;
            x xVar = x.SXb;
            AppMethodBeat.o(236313);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class c extends q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ k Hph;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar) {
            super(4);
            this.Hph = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            AppMethodBeat.i(236314);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            p.h(byteBuffer2, "data");
            r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> rVar = this.Hph.HoT;
            if (rVar != null) {
                rVar.invoke(byteBuffer2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236314);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class d extends q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ k Hph;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar) {
            super(4);
            this.Hph = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            AppMethodBeat.i(236315);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            p.h(byteBuffer2, "data");
            r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> rVar = this.Hph.HoS;
            if (rVar != null) {
                rVar.invoke(byteBuffer2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236315);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class e extends q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ k Hph;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(k kVar) {
            super(4);
            this.Hph = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            AppMethodBeat.i(236316);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            p.h(byteBuffer2, "data");
            r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> rVar = this.Hph.HoS;
            if (rVar != null) {
                rVar.invoke(byteBuffer2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236316);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class f extends q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ k Hph;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(k kVar) {
            super(4);
            this.Hph = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            AppMethodBeat.i(236317);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            p.h(byteBuffer2, "data");
            r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> rVar = this.Hph.HoS;
            if (rVar != null) {
                rVar.invoke(byteBuffer2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236317);
            return xVar;
        }
    }

    public k(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5, 2, 1);
        AppMethodBeat.i(236328);
        AppMethodBeat.o(236328);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.ikx = i2;
    }

    public final void bm(int i2, boolean z) {
        AppMethodBeat.i(236318);
        Log.i("MicroMsg.VoipRenderProcExternalTexture", "setSTFilter(Hseasun), isON:%d", Integer.valueOf(i2));
        if (this.HoX == 1) {
            this.HoW = 0;
            AppMethodBeat.o(236318);
            return;
        }
        this.HoW = i2;
        if (this.HoW == 1) {
            if (this.HoQ == null) {
                this.HoQ = new com.tencent.mm.plugin.voip.video.c.e();
            }
            Log.i("MicroMsg.VoipRenderProcExternalTexture", "faceBeautyAlgo:  " + this.HoX + ", isFaceBeautyAlogChanged: " + this.HoV);
            if (this.HoX == 0 || this.HoX == 3) {
                com.tencent.mm.plugin.voip.video.c.e eVar = this.HoQ;
                if (eVar != null) {
                    c cVar = new c(this);
                    p.h(cVar, "callback");
                    if (eVar.Hmt) {
                        a aVar = eVar.Hms;
                        if (aVar != null) {
                            aVar.HmO = cVar;
                        }
                    } else {
                        com.tencent.mm.media.j.b.e eVar2 = eVar.hEx;
                        if (eVar2 != null) {
                            eVar2.ijK = new e.b(eVar, cVar);
                        }
                    }
                }
                this.HoX = 3;
                this.ijy = 2;
                this.HoV = true;
                this.HoY = 1;
                this.Hpa = z;
                AppMethodBeat.o(236318);
                return;
            } else if (this.HoX != 3) {
                this.HoY = 0;
            }
        }
        AppMethodBeat.o(236318);
    }

    public final void jO(int i2, int i3) {
        AppMethodBeat.i(236319);
        Log.printInfoStack("MicroMsg.VoipRenderProcExternalTexture", "setVoIPBeauty, isON:%d", Integer.valueOf(i2));
        this.HiD = i2;
        if (this.HoX == i3 || this.HoX == 3 || i2 == 0) {
            this.HoV = false;
        } else {
            this.HoX = i3;
            this.HoU = true;
            this.HoV = true;
        }
        switch (i3) {
            case 1:
                if (this.HoO == null) {
                    this.HoO = new com.tencent.mm.plugin.voip.video.c.b();
                    com.tencent.mm.plugin.voip.video.c.b bVar = this.HoO;
                    if (bVar != null) {
                        e eVar = new e(this);
                        p.h(eVar, "callback");
                        if (bVar.Hmt) {
                            a aVar = bVar.Hms;
                            if (aVar != null) {
                                aVar.HmO = eVar;
                            }
                        } else {
                            com.tencent.mm.media.j.b.e eVar2 = bVar.hEx;
                            if (eVar2 != null) {
                                eVar2.ijK = new b.a(bVar, eVar);
                            }
                        }
                    }
                    h.a aVar2 = h.Hhl;
                    h.a.adK(2);
                }
                this.ijy = 2;
                AppMethodBeat.o(236319);
                return;
            case 2:
                if (this.HoP == null) {
                    this.HoP = new g();
                    g gVar = this.HoP;
                    if (gVar != null) {
                        d dVar = new d(this);
                        p.h(dVar, "callback");
                        if (gVar.Hmt) {
                            a aVar3 = gVar.Hms;
                            if (aVar3 != null) {
                                aVar3.HmO = dVar;
                            }
                        } else {
                            com.tencent.mm.media.j.b.e eVar3 = gVar.hEx;
                            if (eVar3 != null) {
                                eVar3.ijK = new g.b(gVar, dVar);
                            }
                        }
                    }
                    h.a aVar4 = h.Hhl;
                    h.a.adK(1);
                }
                Log.i("MicroMsg.VoipRenderProcExternalTexture", "render YT face-beauty algorithm");
                this.ijy = 2;
                AppMethodBeat.o(236319);
                return;
            default:
                if (this.HoN == null) {
                    this.HoN = new com.tencent.mm.plugin.voip.video.c.c();
                    com.tencent.mm.plugin.voip.video.c.c cVar = this.HoN;
                    if (cVar != null) {
                        f fVar = new f(this);
                        p.h(fVar, "callback");
                        if (cVar.Hmt) {
                            a aVar5 = cVar.Hms;
                            if (aVar5 != null) {
                                aVar5.HmO = fVar;
                            }
                        } else {
                            com.tencent.mm.media.j.b.e eVar4 = cVar.hEx;
                            if (eVar4 != null) {
                                eVar4.ijK = new c.a(cVar, fVar);
                            }
                        }
                    }
                    h.a aVar6 = h.Hhl;
                    h.a.adK(0);
                }
                this.ijy = 1;
                AppMethodBeat.o(236319);
                return;
        }
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void cZ(int i2, int i3) {
        AppMethodBeat.i(236320);
        super.cZ(i2, i3);
        this.HoU = true;
        AppMethodBeat.o(236320);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aEB() {
        boolean z;
        int i2;
        float f2;
        float f3;
        AppMethodBeat.i(236324);
        if (this.HoU) {
            this.hDT.position(0);
            if (this.HoX != 0) {
                this.hDT.put(k(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
            } else {
                float f4 = ((float) this.ijS.x) / ((float) this.hDn);
                float f5 = (((float) this.ijS.y) - 1.0f) / ((float) this.hDo);
                float f6 = (((float) this.ijT.x) - 1.0f) / ((float) this.hDn);
                float f7 = ((float) this.ijT.y) / ((float) this.hDo);
                float[] fArr = com.tencent.mm.media.k.c.iln;
                float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                if (this.ijt == 90 || this.ijt == 270) {
                    z = true;
                } else {
                    z = false;
                }
                int i3 = this.ijT.x - this.ijS.x;
                int i4 = this.ijS.y - this.ijT.y;
                if (z) {
                    i2 = i4;
                } else {
                    i2 = i3;
                }
                if (!z) {
                    i3 = i4;
                }
                float f8 = ((float) this.hEp) / ((float) i2);
                float f9 = ((float) this.hEq) / ((float) i3);
                float f10 = 0.0f;
                float f11 = 0.0f;
                if (f8 < f9) {
                    f10 = ((float) i2) - (((float) this.hEp) / f9);
                } else if (f8 > f9) {
                    f11 = ((float) i3) - (((float) this.hEq) / f8);
                }
                this.ijO = i2 - ((int) f10);
                this.ijP = i3 - ((int) f11);
                if (z) {
                    f3 = (f11 / 2.0f) / ((float) i3);
                    f2 = (f10 / 2.0f) / ((float) i2);
                } else {
                    f2 = (f11 / 2.0f) / ((float) i3);
                    f3 = (f10 / 2.0f) / ((float) i2);
                }
                float f12 = f4 + f3;
                float f13 = f6 - f3;
                float f14 = f7 + f2;
                float f15 = f5 - f2;
                copyOf[0] = f12;
                copyOf[1] = f15;
                copyOf[2] = f13;
                copyOf[3] = f15;
                copyOf[4] = f12;
                copyOf[5] = f14;
                copyOf[6] = f13;
                copyOf[7] = f14;
                FloatBuffer floatBuffer = this.hDT;
                p.g(copyOf, "cropTextureCoord");
                floatBuffer.put(k(copyOf));
            }
            this.hDT.position(0);
            this.hDU.position(0);
            this.hDU.put(com.tencent.mm.media.k.c.ilm);
            this.hDU.position(0);
        }
        if (com.tencent.mm.plugin.voip.b.g.fKg()) {
            if (this.ijD == null) {
                this.ijD = com.tencent.mm.media.g.c.a(true, 3);
                com.tencent.mm.media.g.c cVar = com.tencent.mm.media.g.c.igu;
                this.ijE = com.tencent.mm.media.g.c.zI(3);
            }
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.a.a(this.ijE, this.ijD, this.hEp, this.hEq);
        } else if (this.HoX != 0) {
            if (this.ijD == null) {
                this.ijD = com.tencent.mm.media.g.c.a(true, 3);
                com.tencent.mm.media.g.c cVar2 = com.tencent.mm.media.g.c.igu;
                this.ijE = com.tencent.mm.media.g.c.zI(3);
            }
            c.a aVar2 = com.tencent.mm.media.k.c.ilt;
            c.a.a(this.ijE, this.ijD, this.hEp, this.hEq);
        }
        GLES20.glViewport(0, 0, this.hEp, this.hEq);
        AppMethodBeat.o(236324);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        com.tencent.mm.media.g.d dVar;
        com.tencent.mm.media.g.d dVar2;
        com.tencent.mm.cm.a.f fVar;
        Float f2;
        AppMethodBeat.i(236325);
        if (this.HoW == 1) {
            if (this.Hpf == null) {
                this.Hpf = new b(this);
            }
            com.tencent.mm.plugin.voip.video.d.a aVar = this.Hpe;
            com.tencent.mm.plugin.voip.video.c.e eVar = this.HoQ;
            if (eVar != null) {
                Integer valueOf = aVar != null ? Integer.valueOf(aVar.HpA) : null;
                if (valueOf == null) {
                    p.hyc();
                }
                int intValue = valueOf.intValue();
                if (aVar != null) {
                    f2 = Float.valueOf(aVar.HpB);
                } else {
                    f2 = null;
                }
                if (f2 == null) {
                    p.hyc();
                }
                eVar.w(intValue, f2.floatValue());
            }
            com.tencent.mm.plugin.voip.video.c.e eVar2 = this.HoQ;
            if (eVar2 != null) {
                int i2 = this.hEp;
                int i3 = this.hEq;
                FloatBuffer floatBuffer = this.hDU;
                FloatBuffer floatBuffer2 = this.hDT;
                int i4 = this.ikx;
                dVar2 = this.ijD;
                if (dVar2 == null) {
                    p.hyc();
                }
                int i5 = this.HoY;
                int i6 = this.HoZ;
                boolean z = this.Hpb;
                boolean z2 = this.Hpa;
                p.h(floatBuffer, "cubeBuffer");
                p.h(floatBuffer2, "textureCoordBuff");
                p.h(dVar2, "outputTexture");
                if (i4 != -1) {
                    GLES20.glBindFramebuffer(36160, 0);
                    c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                    c.a.a(eVar2.HmD, eVar2.HmC, i2, i3);
                    GLES20.glUseProgram(eVar2.programId);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(36197, i4);
                    GLES20.glUniform1i(eVar2.hEA, 0);
                    floatBuffer.position(0);
                    GLES20.glVertexAttribPointer(eVar2.hEy, 2, 5126, false, 0, (Buffer) floatBuffer);
                    GLES20.glEnableVertexAttribArray(eVar2.hEy);
                    floatBuffer2.position(0);
                    GLES20.glVertexAttribPointer(eVar2.hEz, 2, 5126, false, 0, (Buffer) floatBuffer2);
                    GLES20.glEnableVertexAttribArray(eVar2.hEz);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glDisableVertexAttribArray(eVar2.hEy);
                    GLES20.glDisableVertexAttribArray(eVar2.hEz);
                    GLES20.glBindTexture(36197, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                    if (eVar2.hEv == null && eVar2.HmB != null) {
                        eVar2.hEv = com.tencent.mm.media.g.c.a(true, 14);
                        com.tencent.mm.media.g.c cVar = com.tencent.mm.media.g.c.igu;
                        eVar2.HmA = com.tencent.mm.media.g.c.zI(3);
                    }
                    com.tencent.mm.cm.a.f fVar2 = eVar2.HmB;
                    if (fVar2 != null) {
                        com.tencent.mm.media.g.d dVar3 = eVar2.hEv;
                        Integer valueOf2 = dVar3 != null ? Integer.valueOf(dVar3.igv) : null;
                        if (valueOf2 == null) {
                            p.hyc();
                        }
                        fVar2.apK(valueOf2.intValue());
                    }
                    if (!z2 && (fVar = eVar2.HmB) != null) {
                        com.tencent.mm.cm.a.f fVar3 = eVar2.HmB;
                        if (fVar3 != null) {
                            fVar3.lS(i2, i3);
                        }
                        com.tencent.mm.media.g.d dVar4 = eVar2.HmC;
                        Integer valueOf3 = dVar4 != null ? Integer.valueOf(dVar4.igv) : null;
                        if (valueOf3 == null) {
                            p.hyc();
                        }
                        int intValue2 = valueOf3.intValue();
                        com.tencent.mm.media.g.d dVar5 = eVar2.HmC;
                        Integer valueOf4 = dVar5 != null ? Integer.valueOf(dVar5.igv) : null;
                        if (valueOf4 == null) {
                            p.hyc();
                        }
                        int intValue3 = valueOf4.intValue();
                        com.tencent.mm.media.g.d dVar6 = eVar2.HmC;
                        Integer valueOf5 = dVar6 != null ? Integer.valueOf(dVar6.igv) : null;
                        if (valueOf5 == null) {
                            p.hyc();
                        }
                        fVar.a(intValue2, intValue3, valueOf5.intValue(), floatBuffer, floatBuffer2);
                    }
                    if (i5 == 1) {
                        if (eVar2.Hmt) {
                            a aVar3 = eVar2.Hms;
                            if (aVar3 != null) {
                                if (!z2) {
                                    com.tencent.mm.media.g.d dVar7 = eVar2.hEv;
                                    Integer valueOf6 = dVar7 != null ? Integer.valueOf(dVar7.igv) : null;
                                    if (valueOf6 == null) {
                                        p.hyc();
                                    }
                                    aVar3.Gxi = valueOf6.intValue();
                                } else {
                                    com.tencent.mm.media.g.d dVar8 = eVar2.HmC;
                                    Integer valueOf7 = dVar8 != null ? Integer.valueOf(dVar8.igv) : null;
                                    if (valueOf7 == null) {
                                        p.hyc();
                                    }
                                    aVar3.Gxi = valueOf7.intValue();
                                }
                                aVar3.jj(i2, i3);
                                aVar3.requestRender();
                            }
                        } else {
                            com.tencent.mm.media.j.b.e eVar3 = eVar2.hEx;
                            if (eVar3 != null) {
                                eVar3.qx(i6);
                                eVar3.iju = z;
                                if (!z2) {
                                    com.tencent.mm.media.g.d dVar9 = eVar2.hEv;
                                    Integer valueOf8 = dVar9 != null ? Integer.valueOf(dVar9.igv) : null;
                                    if (valueOf8 == null) {
                                        p.hyc();
                                    }
                                    eVar3.hDl = valueOf8.intValue();
                                } else {
                                    com.tencent.mm.media.g.d dVar10 = eVar2.HmC;
                                    Integer valueOf9 = dVar10 != null ? Integer.valueOf(dVar10.igv) : null;
                                    if (valueOf9 == null) {
                                        p.hyc();
                                    }
                                    eVar3.hDl = valueOf9.intValue();
                                }
                                eVar3.cZ(i2, i3);
                                eVar3.cY(i3, i2);
                                eVar3.dc(i3, i2);
                                eVar3.ijM = true;
                                eVar3.aED();
                            }
                        }
                    }
                    if (!z2) {
                        dVar2 = eVar2.hEv;
                    } else {
                        dVar2 = eVar2.HmC;
                    }
                }
            } else {
                dVar2 = null;
            }
            this.Hpd = dVar2;
            com.tencent.mm.media.g.d dVar11 = this.Hpd;
            Integer valueOf10 = dVar11 != null ? Integer.valueOf(dVar11.igv) : null;
            if (valueOf10 == null) {
                p.hyc();
            }
            this.HoM = valueOf10.intValue();
        } else {
            this.HoM = this.ikx;
        }
        switch (this.HoX) {
            case 1:
                com.tencent.mm.plugin.voip.video.c.b bVar = this.HoO;
                if (bVar != null) {
                    int i7 = this.hEp;
                    int i8 = this.hEq;
                    FloatBuffer floatBuffer3 = this.hDU;
                    FloatBuffer floatBuffer4 = this.hDT;
                    int i9 = this.ikx;
                    com.tencent.mm.media.g.d dVar12 = this.ijD;
                    if (dVar12 == null) {
                        p.hyc();
                    }
                    int i10 = this.HoZ;
                    boolean z3 = this.Hpb;
                    p.h(floatBuffer3, "cubeBuffer");
                    p.h(floatBuffer4, "textureCoordBuff");
                    p.h(dVar12, "outputTexture");
                    if (i9 != -1) {
                        GLES20.glUseProgram(bVar.programId);
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(36197, i9);
                        GLES20.glUniform1i(bVar.hEA, 0);
                        GLES20.glUniform1f(bVar.Hle, 0.5f);
                        GLES20.glUniform1i(bVar.Hlf, 0);
                        GLES20.glUniform1i(bVar.Hlg, 2);
                        GLES20.glUniform1f(bVar.Hlh, 0.8f);
                        GLES20.glUniform1f(bVar.Hli, (float) i7);
                        GLES20.glUniform1f(bVar.Hlj, (float) i8);
                        floatBuffer3.position(0);
                        GLES20.glVertexAttribPointer(bVar.hEy, 2, 5126, false, 8, (Buffer) floatBuffer3);
                        GLES20.glEnableVertexAttribArray(bVar.hEy);
                        floatBuffer4.position(0);
                        GLES20.glVertexAttribPointer(bVar.hEz, 2, 5126, false, 8, (Buffer) floatBuffer4);
                        GLES20.glEnableVertexAttribArray(bVar.hEz);
                        GLES20.glDrawArrays(5, 0, 4);
                        GLES20.glDisableVertexAttribArray(bVar.hEy);
                        GLES20.glDisableVertexAttribArray(bVar.hEz);
                        GLES20.glBindTexture(36197, 0);
                        if (bVar.Hmt) {
                            a aVar4 = bVar.Hms;
                            if (aVar4 != null) {
                                aVar4.Gxi = dVar12.igv;
                                aVar4.jj(i7, i8);
                                aVar4.requestRender();
                                AppMethodBeat.o(236325);
                                return;
                            }
                            AppMethodBeat.o(236325);
                            return;
                        }
                        com.tencent.mm.media.j.b.e eVar4 = bVar.hEx;
                        if (eVar4 != null) {
                            eVar4.qx(i10);
                            eVar4.iju = z3;
                            eVar4.hDl = dVar12.igv;
                            eVar4.cZ(i7, i8);
                            eVar4.cY(i8, i7);
                            eVar4.dc(i8, i7);
                            eVar4.ijM = true;
                            eVar4.aED();
                            AppMethodBeat.o(236325);
                            return;
                        }
                    }
                    AppMethodBeat.o(236325);
                    return;
                }
                AppMethodBeat.o(236325);
                return;
            case 2:
                g gVar = this.HoP;
                if (gVar != null) {
                    int i11 = this.hEp;
                    int i12 = this.hEq;
                    FloatBuffer floatBuffer5 = this.hDU;
                    FloatBuffer floatBuffer6 = this.hDT;
                    int i13 = this.HoM;
                    com.tencent.mm.media.g.d dVar13 = this.ijD;
                    if (dVar13 == null) {
                        p.hyc();
                    }
                    dVar = gVar.a(i11, i12, floatBuffer5, floatBuffer6, i13, dVar13, this.HiD, this.HoW, this.HoZ, this.Hpb);
                } else {
                    dVar = null;
                }
                this.Hpc = dVar;
                AppMethodBeat.o(236325);
                return;
            case 3:
                this.Hpc = this.Hpd;
                AppMethodBeat.o(236325);
                return;
            default:
                com.tencent.mm.plugin.voip.video.c.c cVar2 = this.HoN;
                if (cVar2 != null) {
                    int i14 = this.hEp;
                    int i15 = this.hEq;
                    FloatBuffer floatBuffer7 = this.hDU;
                    FloatBuffer floatBuffer8 = this.hDT;
                    int i16 = this.ikx;
                    com.tencent.mm.media.g.d dVar14 = this.ijD;
                    if (dVar14 == null) {
                        p.hyc();
                    }
                    int i17 = this.HoZ;
                    boolean z4 = this.Hpb;
                    p.h(floatBuffer7, "cubeBuffer");
                    p.h(floatBuffer8, "textureCoordBuff");
                    p.h(dVar14, "outputTexture");
                    if (i16 != -1) {
                        GLES20.glUseProgram(cVar2.programId);
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(36197, i16);
                        GLES20.glUniform1i(cVar2.hEA, 0);
                        GLES20.glVertexAttribPointer(cVar2.hEy, 2, 5126, false, 8, (Buffer) floatBuffer7);
                        GLES20.glEnableVertexAttribArray(cVar2.hEy);
                        GLES20.glVertexAttribPointer(cVar2.hEz, 2, 5126, false, 8, (Buffer) floatBuffer8);
                        GLES20.glEnableVertexAttribArray(cVar2.hEz);
                        GLES20.glDrawArrays(5, 0, 4);
                        GLES20.glDisableVertexAttribArray(cVar2.hEy);
                        GLES20.glDisableVertexAttribArray(cVar2.hEz);
                        if (com.tencent.mm.plugin.voip.b.g.fKg()) {
                            GLES20.glBindTexture(36197, 0);
                            if (cVar2.Hmt) {
                                a aVar5 = cVar2.Hms;
                                if (aVar5 != null) {
                                    aVar5.Gxi = dVar14.igv;
                                    aVar5.jj(i14, i15);
                                    aVar5.requestRender();
                                    AppMethodBeat.o(236325);
                                    return;
                                }
                                AppMethodBeat.o(236325);
                                return;
                            }
                            com.tencent.mm.media.j.b.e eVar5 = cVar2.hEx;
                            if (eVar5 != null) {
                                eVar5.qx(i17);
                                eVar5.iju = z4;
                                eVar5.hDl = dVar14.igv;
                                eVar5.cZ(i14, i15);
                                eVar5.cY(i15, i14);
                                eVar5.dc(i15, i14);
                                eVar5.ijM = true;
                                eVar5.aED();
                                AppMethodBeat.o(236325);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.o(236325);
                    return;
                }
                AppMethodBeat.o(236325);
                return;
        }
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aMU() {
        AppMethodBeat.i(236326);
        if (com.tencent.mm.plugin.voip.b.g.fKg()) {
            GLES20.glBindFramebuffer(36160, 0);
        } else if (this.HoX != 0) {
            GLES20.glBindFramebuffer(36160, 0);
        }
        GLES20.glFinish();
        AppMethodBeat.o(236326);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void release() {
        AppMethodBeat.i(236327);
        super.release();
        com.tencent.mm.plugin.voip.video.c.c cVar = this.HoN;
        if (cVar != null) {
            a aVar = cVar.Hms;
            if (aVar != null) {
                aVar.release();
            }
            com.tencent.mm.media.j.b.e eVar = cVar.hEx;
            if (eVar != null) {
                eVar.release();
            }
            GLES20.glDeleteProgram(cVar.programId);
        }
        g gVar = this.HoP;
        if (gVar != null) {
            com.tencent.mm.media.j.b.e eVar2 = gVar.hEx;
            if (eVar2 != null) {
                eVar2.release();
            }
            com.tencent.mm.media.g.d dVar = gVar.hEv;
            if (dVar != null) {
                dVar.close();
            }
            com.tencent.mm.plugin.voip.video.a.d dVar2 = gVar.HmH;
            if (dVar2 != null) {
                String str = com.tencent.mm.plugin.voip.video.a.d.TAG;
                Thread currentThread = Thread.currentThread();
                p.g(currentThread, "Thread.currentThread()");
                Log.i(str, "clear %s %d", dVar2, Long.valueOf(currentThread.getId()));
                try {
                    com.tencent.mm.media.g.d dVar3 = dVar2.hDm;
                    if (dVar3 != null) {
                        dVar3.close();
                    }
                    if (dVar2.hiH != null) {
                        com.tencent.mm.plugin.xlabeffect.b bVar = dVar2.hiH;
                        if (bVar == null) {
                            p.hyc();
                        }
                        bVar.destroy();
                        dVar2.hiH = null;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, e2, "clear error: %s", e2.getMessage());
                }
            }
            a aVar2 = gVar.Hms;
            if (aVar2 != null) {
                aVar2.release();
            }
            GLES20.glDeleteProgram(gVar.programId);
        }
        com.tencent.mm.plugin.voip.video.c.b bVar2 = this.HoO;
        if (bVar2 != null) {
            a aVar3 = bVar2.Hms;
            if (aVar3 != null) {
                aVar3.release();
            }
            com.tencent.mm.media.j.b.e eVar3 = bVar2.hEx;
            if (eVar3 != null) {
                eVar3.release();
            }
            GLES20.glDeleteProgram(bVar2.programId);
        }
        GLES20.glDeleteProgram(this.programId);
        AppMethodBeat.o(236327);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(236321);
        if (!(i2 == this.hEp && i3 == this.hEq)) {
            super.cY(i2, i3);
            this.HoU = true;
        }
        AppMethodBeat.o(236321);
    }

    public final Integer fMb() {
        AppMethodBeat.i(236322);
        Integer valueOf = Integer.valueOf(this.hEp);
        AppMethodBeat.o(236322);
        return valueOf;
    }

    public final Integer fMc() {
        AppMethodBeat.i(236323);
        Integer valueOf = Integer.valueOf(this.hEq);
        AppMethodBeat.o(236323);
        return valueOf;
    }
}
