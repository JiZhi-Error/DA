package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019J\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002JS\u0010\u001c\u001a\u00020\u00162K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00160\u001eJ\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "", "()V", "decoderOutputSurface", "Landroid/view/Surface;", "decoderOutputSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "decoderOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "height", "", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "width", "getSurface", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setRgbBufferListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "setSize", "plugin-multitalk_release"})
public final class aa {
    c.b hDs;
    private Handler handler;
    HandlerThread handlerThread;
    int height = 1;
    int width = 1;
    com.tencent.mm.media.g.d zOF;
    SurfaceTexture zOG;
    Surface zOH;
    com.tencent.mm.media.j.b.c zOI;

    public final void eog() {
        aa aaVar;
        AppMethodBeat.i(239674);
        if (this.handlerThread != null) {
            AppMethodBeat.o(239674);
            return;
        }
        HandlerThread hz = com.tencent.f.c.d.hz("multatalk_HW_render_thread", -4);
        if (hz != null) {
            hz.start();
            this.handler = new Handler(hz.getLooper());
            aaVar = this;
        } else {
            hz = null;
            aaVar = this;
        }
        aaVar.handlerThread = hz;
        U(new a(this));
        AppMethodBeat.o(239674);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int cKE = 1;
        final /* synthetic */ int cKF = 1;
        final /* synthetic */ aa zOJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(aa aaVar) {
            super(0);
            this.zOJ = aaVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper$init$2$1$1$1", "com/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper$init$2$$special$$inlined$apply$lambda$1"})
        /* renamed from: com.tencent.mm.plugin.multitalk.model.aa$a$a  reason: collision with other inner class name */
        static final class C1491a implements SurfaceTexture.OnFrameAvailableListener {
            final /* synthetic */ SurfaceTexture zOK;
            final /* synthetic */ a zOL;

            C1491a(SurfaceTexture surfaceTexture, a aVar) {
                this.zOK = surfaceTexture;
                this.zOL = aVar;
            }

            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(239667);
                aa aaVar = this.zOL.zOJ;
                aaVar.U(new c(aaVar));
                this.zOK.updateTexImage();
                AppMethodBeat.o(239667);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239668);
            this.zOJ.hDs = c.a.a(com.tencent.mm.media.k.c.ilt, null, this.cKE, this.cKF, null, 16);
            aa aaVar = this.zOJ;
            com.tencent.mm.media.g.d dVar = new com.tencent.mm.media.g.d(false, 19);
            aa aaVar2 = this.zOJ;
            SurfaceTexture surfaceTexture = new SurfaceTexture(dVar.igv);
            surfaceTexture.setOnFrameAvailableListener(new C1491a(surfaceTexture, this));
            aaVar2.zOG = surfaceTexture;
            this.zOJ.zOH = new Surface(this.zOJ.zOG);
            aaVar.zOF = dVar;
            aa aaVar3 = this.zOJ;
            com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(this.cKE, this.cKF);
            cVar.ijL = false;
            aaVar3.zOI = cVar;
            x xVar = x.SXb;
            AppMethodBeat.o(239668);
            return xVar;
        }
    }

    public final void c(kotlin.g.a.q<? super ByteBuffer, ? super Integer, ? super Integer, x> qVar) {
        AppMethodBeat.i(239675);
        p.h(qVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        U(new d(this, qVar));
        AppMethodBeat.o(239675);
    }

    public final void U(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(239676);
        p.h(aVar, "task");
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.post(new ab(aVar));
            AppMethodBeat.o(239676);
            return;
        }
        AppMethodBeat.o(239676);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa zOJ;
        final /* synthetic */ kotlin.g.a.q zOM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(aa aaVar, kotlin.g.a.q qVar) {
            super(0);
            this.zOJ = aaVar;
            this.zOM = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239673);
            com.tencent.mm.media.j.b.c cVar = this.zOJ.zOI;
            if (cVar != null) {
                cVar.ijK = new kotlin.g.a.b<ByteBuffer, x>(this) {
                    /* class com.tencent.mm.plugin.multitalk.model.aa.d.AnonymousClass1 */
                    final /* synthetic */ d zON;

                    {
                        this.zON = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(ByteBuffer byteBuffer) {
                        AppMethodBeat.i(239672);
                        ByteBuffer byteBuffer2 = byteBuffer;
                        p.h(byteBuffer2, LocaleUtil.ITALIAN);
                        this.zON.zOM.d(byteBuffer2, Integer.valueOf(this.zON.zOJ.width), Integer.valueOf(this.zON.zOJ.height));
                        x xVar = x.SXb;
                        AppMethodBeat.o(239672);
                        return xVar;
                    }
                };
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239673);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa zOJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(aa aaVar) {
            super(0);
            this.zOJ = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239669);
            com.tencent.mm.media.j.b.c cVar = this.zOJ.zOI;
            if (cVar != null) {
                cVar.ijK = null;
            }
            Surface surface = this.zOJ.zOH;
            if (surface != null) {
                surface.release();
            }
            SurfaceTexture surfaceTexture = this.zOJ.zOG;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            com.tencent.mm.media.g.d dVar = this.zOJ.zOF;
            if (dVar != null) {
                dVar.close();
            }
            com.tencent.mm.media.j.b.c cVar2 = this.zOJ.zOI;
            if (cVar2 != null) {
                cVar2.release();
            }
            c.b bVar = this.zOJ.hDs;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239669);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa zOJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(aa aaVar) {
            super(0);
            this.zOJ = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(239670);
            com.tencent.mm.media.j.b.c cVar = this.zOJ.zOI;
            if (cVar != null) {
                com.tencent.mm.media.g.d dVar = this.zOJ.zOF;
                if (dVar != null) {
                    i2 = dVar.igv;
                } else {
                    i2 = 0;
                }
                cVar.ikx = i2;
                cVar.cZ(this.zOJ.width, this.zOJ.height);
                cVar.cY(this.zOJ.width, this.zOJ.height);
                cVar.ijM = true;
                cVar.aED();
                c.b bVar = this.zOJ.hDs;
                if (bVar != null) {
                    c.a aVar = com.tencent.mm.media.k.c.ilt;
                    c.a.a(bVar.ilu, bVar.eglSurface);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239670);
            return xVar;
        }
    }
}
