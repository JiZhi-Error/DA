package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u000b\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J(\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J*\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0003J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"J3\u0010#\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010%R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "mSharedGLContext", "Landroid/opengl/EGLContext;", "postCreatedGLContext", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "", "h", "flag", "", "setLocalRenderOrientation", "rotateDegree", "setMirror", "isMirror", "setSharedContext", "sharedContext", "updateLocalRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "updateRendererSize", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public final class n extends d {
    public static final a Hpt = new a((byte) 0);
    private kotlin.g.a.b<? super d, x> HnA;
    private boolean Hpr;
    private EGLContext Hps;

    static {
        AppMethodBeat.i(236374);
        AppMethodBeat.o(236374);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<com.tencent.mm.media.g.d, x> {
        final /* synthetic */ n Hpu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(n nVar) {
            super(1);
            this.Hpu = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.g.d dVar) {
            AppMethodBeat.i(236360);
            com.tencent.mm.media.g.d dVar2 = dVar;
            if (this.Hpu.Hng && dVar2 != null) {
                this.Hpu.b(dVar2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236360);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public n(boolean z) {
        super(z, Hpt.hashCode());
        AppMethodBeat.i(236373);
        AppMethodBeat.o(236373);
    }

    @Override // com.tencent.mm.plugin.voip.video.render.d
    public final void a(kotlin.g.a.b<? super d, x> bVar, g gVar, boolean z) {
        EGLContext eGLContext;
        AppMethodBeat.i(236369);
        if (gVar != null) {
            c.b bVar2 = gVar.ilw;
            if (bVar2 != null) {
                eGLContext = bVar2.ilv;
            } else {
                eGLContext = null;
            }
            if (eGLContext != null) {
                this.Hps = eGLContext;
                xz(true);
            }
            if (z) {
                b bVar3 = new b(this);
                if (!gVar.HnC.contains(bVar3)) {
                    gVar.HnC.add(bVar3);
                }
            } else {
                this.HnA = bVar;
            }
            this.Hnk = gVar.width;
            this.Hnl = gVar.height;
            AppMethodBeat.o(236369);
            return;
        }
        this.HnA = bVar;
        xz(false);
        AppMethodBeat.o(236369);
    }

    @Override // com.tencent.mm.plugin.voip.video.render.d
    public final void a(g gVar, ac acVar, Integer num, Boolean bool) {
        int i2;
        boolean z;
        com.tencent.mm.media.g.d dVar;
        boolean z2;
        int i3 = 0;
        AppMethodBeat.i(236370);
        p.h(acVar, "renderSize");
        if (gVar != null) {
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 90;
            }
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
            p.h(acVar, "cameraSize");
            Log.printInfoStack("MicroMsg.PboSurfaceRender", "updatePboAndWindowsSize is " + acVar.width + " and " + acVar.height + " and " + i2, new Object[0]);
            k kVar = gVar.Hnx;
            if (kVar != null) {
                kVar.cZ(acVar.width, acVar.height);
            }
            k kVar2 = gVar.Hnx;
            if (kVar2 != null) {
                kVar2.qx(i2);
            }
            k kVar3 = gVar.Hnx;
            if (kVar3 != null) {
                if (!z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                kVar3.iju = z2;
            }
            k kVar4 = gVar.Hnx;
            if (kVar4 != null) {
                dVar = kVar4.ijD;
            } else {
                dVar = null;
            }
            a(dVar);
            l lVar = this.Hnj;
            if (lVar != null) {
                lVar.qx(0);
                AppMethodBeat.o(236370);
                return;
            }
            AppMethodBeat.o(236370);
            return;
        }
        l lVar2 = this.Hnj;
        if (lVar2 != null) {
            lVar2.cZ(acVar.width, acVar.height);
        }
        l lVar3 = this.Hnj;
        if (lVar3 != null) {
            if (num != null) {
                i3 = num.intValue();
            }
            lVar3.qx(i3);
            AppMethodBeat.o(236370);
            return;
        }
        AppMethodBeat.o(236370);
    }

    @Override // com.tencent.mm.plugin.voip.video.render.d
    public final void xz(boolean z) {
        AppMethodBeat.i(236371);
        if (this.Hpr) {
            AppMethodBeat.o(236371);
        } else if (!z) {
            k(new d(this));
            this.Hpr = true;
            AppMethodBeat.o(236371);
        } else if (this.Hps == null) {
            AppMethodBeat.o(236371);
        } else {
            k(new c(this));
            this.Hpr = true;
            AppMethodBeat.o(236371);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ n Hpu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.Hpu = nVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$1$1$1"})
        static final class a implements SurfaceTexture.OnFrameAvailableListener {
            final /* synthetic */ com.tencent.mm.media.g.d Hpv;
            final /* synthetic */ c Hpw;

            a(com.tencent.mm.media.g.d dVar, c cVar) {
                this.Hpv = dVar;
                this.Hpw = cVar;
            }

            public final void onFrameAvailable(final SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(236362);
                this.Hpw.Hpu.k(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.voip.video.render.n.c.a.AnonymousClass1 */
                    final /* synthetic */ a Hpx;

                    {
                        this.Hpx = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(236361);
                        try {
                            surfaceTexture.updateTexImage();
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WindowSurfaceRenderer", "error happened in update tex image");
                        }
                        this.Hpx.Hpw.Hpu.b(this.Hpx.Hpv);
                        x xVar = x.SXb;
                        AppMethodBeat.o(236361);
                        return xVar;
                    }
                });
                AppMethodBeat.o(236362);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236364);
            n nVar = this.Hpu;
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            EGLContext eGLContext = this.Hpu.Hps;
            if (eGLContext == null) {
                p.hyc();
            }
            nVar.ilw = c.a.a(null, null, 1, 1, eGLContext);
            this.Hpu.Hnj = new l(this.Hpu.Hnm);
            if (!this.Hpu.Hng) {
                if (this.Hpu.Hko == null) {
                    this.Hpu.Hko = com.tencent.mm.media.g.c.a(false, 14);
                    com.tencent.mm.media.g.d dVar = this.Hpu.Hko;
                    if (dVar != null) {
                        this.Hpu.a(dVar);
                        this.Hpu.surfaceTexture = new SurfaceTexture(dVar.igv);
                        this.Hpu.surface = new Surface(this.Hpu.surfaceTexture);
                        SurfaceTexture surfaceTexture = this.Hpu.surfaceTexture;
                        if (surfaceTexture != null) {
                            surfaceTexture.setOnFrameAvailableListener(new a(dVar, this));
                        }
                    }
                    MMHandlerThread.postToMainThread(new Runnable(this) {
                        /* class com.tencent.mm.plugin.voip.video.render.n.c.AnonymousClass1 */
                        final /* synthetic */ c Hpw;

                        {
                            this.Hpw = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(236363);
                            kotlin.g.a.b bVar = this.Hpw.Hpu.HnA;
                            if (bVar != null) {
                                bVar.invoke(this.Hpw.Hpu);
                                AppMethodBeat.o(236363);
                                return;
                            }
                            AppMethodBeat.o(236363);
                        }
                    });
                } else {
                    this.Hpu.a(this.Hpu.Hko);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236364);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ n Hpu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(n nVar) {
            super(0);
            this.Hpu = nVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$2$1$1"})
        static final class a implements SurfaceTexture.OnFrameAvailableListener {
            final /* synthetic */ com.tencent.mm.media.g.d Hpv;
            final /* synthetic */ d Hpy;

            a(com.tencent.mm.media.g.d dVar, d dVar2) {
                this.Hpv = dVar;
                this.Hpy = dVar2;
            }

            public final void onFrameAvailable(final SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(236366);
                this.Hpy.Hpu.k(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.voip.video.render.n.d.a.AnonymousClass1 */
                    final /* synthetic */ a Hpz;

                    {
                        this.Hpz = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(236365);
                        try {
                            surfaceTexture.updateTexImage();
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WindowSurfaceRenderer", "error happened in update tex image");
                        }
                        this.Hpz.Hpy.Hpu.b(this.Hpz.Hpv);
                        x xVar = x.SXb;
                        AppMethodBeat.o(236365);
                        return xVar;
                    }
                });
                AppMethodBeat.o(236366);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236368);
            this.Hpu.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, null, 1, 1, null, 16);
            this.Hpu.Hnj = new l(this.Hpu.Hnm);
            if (!this.Hpu.Hng) {
                this.Hpu.Hko = com.tencent.mm.media.g.c.a(false, 14);
                com.tencent.mm.media.g.d dVar = this.Hpu.Hko;
                if (dVar != null) {
                    this.Hpu.a(dVar);
                    this.Hpu.surfaceTexture = new SurfaceTexture(dVar.igv);
                    this.Hpu.surface = new Surface(this.Hpu.surfaceTexture);
                    SurfaceTexture surfaceTexture = this.Hpu.surfaceTexture;
                    if (surfaceTexture != null) {
                        surfaceTexture.setOnFrameAvailableListener(new a(dVar, this));
                    }
                }
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.voip.video.render.n.d.AnonymousClass1 */
                    final /* synthetic */ d Hpy;

                    {
                        this.Hpy = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(236367);
                        kotlin.g.a.b bVar = this.Hpy.Hpu.HnA;
                        if (bVar != null) {
                            bVar.invoke(this.Hpy.Hpu);
                            AppMethodBeat.o(236367);
                            return;
                        }
                        AppMethodBeat.o(236367);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236368);
            return xVar;
        }
    }

    public final void aeb(int i2) {
        AppMethodBeat.i(236372);
        l lVar = this.Hnj;
        if (lVar != null) {
            lVar.qx(i2);
            AppMethodBeat.o(236372);
            return;
        }
        AppMethodBeat.o(236372);
    }

    public final void setMirror(boolean z) {
        l lVar = this.Hnj;
        if (lVar != null) {
            lVar.iju = z;
        }
    }
}
