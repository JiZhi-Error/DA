package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u0000 d2\u00020\u0001:\u0001dB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0004J\u001c\u0010#\u001a\u00020\u001f2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001f\u0018\u00010%J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\nJ(\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020!2\u0018\b\u0002\u0010$\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001f\u0018\u00010%J&\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J(\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0012J\u0016\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0012J\b\u00108\u001a\u00020\nH\u0002J\u0016\u00109\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0004J\u0006\u0010:\u001a\u00020\u001fJ\u0018\u0010;\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u0004J\u001e\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\nJ\u000e\u0010D\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u0004J\u0016\u0010E\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0004J\u0018\u0010F\u001a\u00020\u001f2\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010GJ\u0016\u0010H\u001a\u00020\u001f2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010GJ4\u0010I\u001a\u00020\u001f2,\u0010$\u001a(\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f\u0018\u00010Jj\u0004\u0018\u0001`LJ\u0016\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\u0004J\u0016\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\nJ\u000e\u0010V\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020\u0004J\u0006\u0010W\u001a\u00020\u001fJ\u0012\u0010X\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010Y\u001a\u00020\u001fJ\u0018\u0010Z\u001a\u00020\u001f2\b\u0010[\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0004J\u001e\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010`\u001a\u00020\u001f2\u0006\u0010a\u001a\u00020BJ\u001d\u0010b\u001a\u00020\u001f2\u0006\u0010a\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010cR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "", "()V", "mCameraOrientation", "", "getMCameraOrientation", "()I", "setMCameraOrientation", "(I)V", "mIsMirror", "", "getMIsMirror", "()Z", "setMIsMirror", "(Z)V", "mLocalWindowSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "mPboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "getMPboSurfaceRender", "()Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "setMPboSurfaceRender", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;)V", "mRemoteWindowsSurfaceRenderer", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "addRenderSurface", "", "surface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "renderSide", "checkInit", "callback", "Lkotlin/Function1;", "choiceRenderSurface", "mIsRenderLocal", "createSurface", "glSurface", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getFaceBeautyType", "initLocalSurfaceRenderer", "pboSurfaceRender", "initPboSurfaceRenderer", "width", "height", "initRemoteSurfaceRenderer", "isUseFaceBeauty", "onCameraPreviewApply", "release", "removeSurface", "setCameraIsMirror", "mirror", "setCameraOrientation", "orientation", "setCameraPreviewSize", "size", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "setLocalRenderOrientation", "setLocalVideoSize", "setOnDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "setOnFrameAvailableCallback", "setOnFrameDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setSTFilterMotionNoiseData", "motion", "noise", "", "setShowMode", "mode", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateLocalRenderSize", "renderSize", "updateRendererSize", "(Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;)V", "Companion", "plugin-voip_release"})
public final class m {
    public static final a Hpn = new a((byte) 0);
    boolean HhF;
    public g Hpj;
    public n Hpk;
    public n Hpl;
    c Hpm;
    private int sUv;

    static {
        AppMethodBeat.i(236358);
        AppMethodBeat.o(236358);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<g, x> {
        final /* synthetic */ m Hpo;
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar, kotlin.g.a.b bVar) {
            super(1);
            this.Hpo = mVar;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
            java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:267)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
            */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(com.tencent.mm.plugin.voip.video.render.g r6) {
            /*
            // Method dump skipped, instructions count: 108
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.render.m.b.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b {
        final /* synthetic */ m Hpo;
        final /* synthetic */ z.e Hpp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(m mVar, z.e eVar) {
            super(1);
            this.Hpo = mVar;
            this.Hpp = eVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(236336);
            long longValue = ((Number) obj).longValue();
            if (!m.b(this.Hpo)) {
                c cVar = this.Hpo.Hpm;
                if (cVar != null) {
                    cVar.ag(longValue, 1);
                }
            } else {
                this.Hpp.SYF = longValue;
            }
            AppMethodBeat.o(236336);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "(J)Lkotlin/Unit;"})
    public static final class d extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ m Hpo;
        final /* synthetic */ z.e Hpp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(m mVar, z.e eVar) {
            super(1);
            this.Hpo = mVar;
            this.Hpp = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(236337);
            long longValue = l.longValue();
            c cVar = this.Hpo.Hpm;
            if (cVar != null) {
                cVar.ag(longValue + this.Hpp.SYF, 1);
                x xVar = x.SXb;
                AppMethodBeat.o(236337);
                return xVar;
            }
            AppMethodBeat.o(236337);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "renderer", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "invoke"})
    static final class e extends q implements kotlin.g.a.b<d, x> {
        public static final e Hpq = new e();

        static {
            AppMethodBeat.i(236339);
            AppMethodBeat.o(236339);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(d dVar) {
            AppMethodBeat.i(236338);
            d dVar2 = dVar;
            p.h(dVar2, "renderer");
            if (v2protocal.HcC == null && dVar2.surfaceTexture != null) {
                v2protocal.mSurfaceTexture = dVar2.surfaceTexture;
                v2protocal.HcD = dVar2.Hko;
                v2protocal.HcC = dVar2.surface;
                h.a aVar = h.Hhl;
                h.a.xt(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236338);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ m Hpo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(m mVar) {
            super(1);
            this.Hpo = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            c cVar;
            AppMethodBeat.i(236340);
            long longValue = l.longValue();
            if (longValue > 0 && (cVar = this.Hpo.Hpm) != null) {
                cVar.ag(longValue, 2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236340);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "(J)Lkotlin/Unit;"})
    static final class g extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ m Hpo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(m mVar) {
            super(1);
            this.Hpo = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(236341);
            long longValue = l.longValue();
            c cVar = this.Hpo.Hpm;
            if (cVar != null) {
                cVar.ag(longValue, 0);
                x xVar = x.SXb;
                AppMethodBeat.o(236341);
                return xVar;
            }
            AppMethodBeat.o(236341);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ boolean b(m mVar) {
        AppMethodBeat.i(236359);
        boolean fMe = mVar.fMe();
        AppMethodBeat.o(236359);
        return fMe;
    }

    public final void aF(int i2, int i3, int i4) {
        AppMethodBeat.i(236342);
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.aF(i2, i3, i4);
            AppMethodBeat.o(236342);
            return;
        }
        AppMethodBeat.o(236342);
    }

    public final void x(int i2, float f2) {
        AppMethodBeat.i(236343);
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.x(i2, f2);
            AppMethodBeat.o(236343);
            return;
        }
        AppMethodBeat.o(236343);
    }

    public final int fMd() {
        g gVar = this.Hpj;
        if (gVar != null) {
            return gVar.HnF;
        }
        return 0;
    }

    public final void a(ac acVar, int i2, boolean z) {
        AppMethodBeat.i(236344);
        p.h(acVar, "size");
        g gVar = this.Hpj;
        if (gVar != null) {
            n nVar = this.Hpk;
            if (nVar != null) {
                nVar.a(gVar, acVar, Integer.valueOf(i2), Boolean.valueOf(z));
                AppMethodBeat.o(236344);
                return;
            }
            AppMethodBeat.o(236344);
            return;
        }
        AppMethodBeat.o(236344);
    }

    public final void aeb(int i2) {
        AppMethodBeat.i(236345);
        if (!this.HhF) {
            if (i2 == 180 || i2 == 0) {
                n nVar = this.Hpk;
                if (nVar != null) {
                    nVar.aeb(TXLiveConstants.RENDER_ROTATION_180);
                }
            } else {
                n nVar2 = this.Hpk;
                if (nVar2 != null) {
                    nVar2.aeb((i2 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1);
                }
            }
            n nVar3 = this.Hpk;
            if (nVar3 != null) {
                nVar3.setMirror(true);
            }
        } else {
            if (i2 == 180 || i2 == 0) {
                n nVar4 = this.Hpk;
                if (nVar4 != null) {
                    nVar4.aeb(0);
                }
            } else {
                n nVar5 = this.Hpk;
                if (nVar5 != null) {
                    nVar5.aeb(i2 % v2helper.VOIP_ENC_HEIGHT_LV1);
                }
            }
            n nVar6 = this.Hpk;
            if (nVar6 != null) {
                nVar6.setMirror(false);
            }
        }
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.HhF = this.HhF;
        }
        g gVar2 = this.Hpj;
        if (gVar2 != null) {
            gVar2.jN(i2, this.sUv);
            AppMethodBeat.o(236345);
            return;
        }
        AppMethodBeat.o(236345);
    }

    public final void aee(int i2) {
        this.sUv = i2;
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.sUv = i2;
        }
    }

    public final void ad(kotlin.g.a.a<x> aVar) {
        n nVar = this.Hpk;
        if (nVar != null) {
            nVar.Hnc = aVar;
        }
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.Hnc = aVar;
        }
        n nVar2 = this.Hpl;
        if (nVar2 != null) {
            nVar2.Hnc = aVar;
        }
    }

    public final void i(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> rVar) {
        AppMethodBeat.i(236346);
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.h(rVar);
            AppMethodBeat.o(236346);
            return;
        }
        AppMethodBeat.o(236346);
    }

    public final void fLT() {
        AppMethodBeat.i(236347);
        n nVar = this.Hpk;
        if (nVar != null) {
            nVar.xA(true);
        }
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.fLT();
        }
        n nVar2 = this.Hpl;
        if (nVar2 != null) {
            nVar2.xA(false);
            AppMethodBeat.o(236347);
            return;
        }
        AppMethodBeat.o(236347);
    }

    public final void b(f fVar, int i2) {
        AppMethodBeat.i(236348);
        if (fVar != null) {
            Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "add render surface renderSide " + i2 + " and :" + fVar, new Object[0]);
            n nVar = this.Hpk;
            if (nVar != null) {
                nVar.b(fVar, i2);
            }
            g gVar = this.Hpj;
            if (gVar != null) {
                gVar.b(fVar, i2);
            }
            n nVar2 = this.Hpl;
            if (nVar2 != null) {
                nVar2.b(fVar, i2);
                AppMethodBeat.o(236348);
                return;
            }
            AppMethodBeat.o(236348);
            return;
        }
        Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "add a null surface");
        AppMethodBeat.o(236348);
    }

    /* access modifiers changed from: package-private */
    public final boolean fMe() {
        g gVar = this.Hpj;
        return gVar == null || gVar.HnF != 0;
    }

    public final void c(f fVar, int i2) {
        AppMethodBeat.i(236349);
        if (fVar != null) {
            n nVar = this.Hpk;
            if (nVar != null) {
                nVar.c(fVar, i2);
            }
            g gVar = this.Hpj;
            if (gVar != null) {
                gVar.c(fVar, i2);
            }
            n nVar2 = this.Hpl;
            if (nVar2 != null) {
                nVar2.c(fVar, i2);
                AppMethodBeat.o(236349);
                return;
            }
            AppMethodBeat.o(236349);
            return;
        }
        Log.e("MicroMsg.LocalWindowsSurfaceRenderer", "remove a null surface");
        AppMethodBeat.o(236349);
    }

    public static /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(236351);
        mVar.a((f) null);
        AppMethodBeat.o(236351);
    }

    public final void a(f fVar) {
        n nVar;
        AppMethodBeat.i(236350);
        if (fMe() && (nVar = this.Hpk) != null) {
            nVar.a(fVar);
        }
        n nVar2 = this.Hpl;
        if (nVar2 != null) {
            nVar2.a((d) ((f) null));
            AppMethodBeat.o(236350);
            return;
        }
        AppMethodBeat.o(236350);
    }

    public final void fLR() {
        n nVar;
        AppMethodBeat.i(236352);
        if (fMe() && (nVar = this.Hpk) != null) {
            nVar.fLR();
        }
        n nVar2 = this.Hpl;
        if (nVar2 != null) {
            nVar2.fLR();
            AppMethodBeat.o(236352);
            return;
        }
        AppMethodBeat.o(236352);
    }

    public final void a(f fVar, int i2) {
        AppMethodBeat.i(236353);
        n nVar = this.Hpk;
        if (nVar != null) {
            nVar.a(fVar, i2);
        }
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.a(fVar, i2);
        }
        n nVar2 = this.Hpl;
        if (nVar2 != null) {
            nVar2.a(fVar, i2);
            AppMethodBeat.o(236353);
            return;
        }
        AppMethodBeat.o(236353);
    }

    public final void a(f fVar, kotlin.g.a.b<? super f, x> bVar) {
        AppMethodBeat.i(236354);
        p.h(fVar, "glSurface");
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.a(fVar, bVar);
            AppMethodBeat.o(236354);
            return;
        }
        AppMethodBeat.o(236354);
    }

    public final void setShowMode(int i2) {
        AppMethodBeat.i(236355);
        n nVar = this.Hpl;
        if (nVar != null) {
            nVar.setShowMode(i2);
            AppMethodBeat.o(236355);
            return;
        }
        AppMethodBeat.o(236355);
    }

    public final void a(ac acVar, Integer num) {
        AppMethodBeat.i(236356);
        p.h(acVar, "renderSize");
        n nVar = this.Hpl;
        if (nVar != null) {
            nVar.a(null, acVar, num, null);
            AppMethodBeat.o(236356);
            return;
        }
        AppMethodBeat.o(236356);
    }

    public final void release() {
        AppMethodBeat.i(236357);
        g gVar = this.Hpj;
        if (gVar != null) {
            gVar.stop();
        }
        g gVar2 = this.Hpj;
        if (gVar2 != null) {
            gVar2.destroy();
        }
        n nVar = this.Hpk;
        if (nVar != null) {
            nVar.a((d) ((f) null));
        }
        n nVar2 = this.Hpk;
        if (nVar2 != null) {
            nVar2.release();
        }
        n nVar3 = this.Hpl;
        if (nVar3 != null) {
            nVar3.a((d) ((f) null));
        }
        n nVar4 = this.Hpl;
        if (nVar4 != null) {
            nVar4.release();
            AppMethodBeat.o(236357);
            return;
        }
        AppMethodBeat.o(236357);
    }
}
