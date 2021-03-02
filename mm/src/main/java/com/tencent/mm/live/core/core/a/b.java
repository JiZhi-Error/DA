package com.tencent.mm.live.core.core.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.core.b.d;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.trtc.TRTCCloud;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0005\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J0\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J&\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u001dH\u0016J \u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016J\u001c\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\nH\u0016J\u0018\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\bH\u0016J\b\u00101\u001a\u00020\nH\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u00065"}, hxF = {"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "()V", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "endScaleAnimation", "", "time", "", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "", "dontFinish", "generateType", "opType", "normalMode", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "release", "resetPkConfig", "setupPkConfig", "roomId", ch.COL_USERNAME, "pkSign", "startCrossLinkMic", "startPreview", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "startPush", "startScaleAnimation", "scale", "", "stopCrossLinkMic", "stopPush", "updateRenderMirror", "isMirror", "Companion", "plugin-core_release"})
public final class b extends com.tencent.mm.live.core.core.trtc.a implements a {
    private static b hyu;
    public static final a hyv = new a((byte) 0);
    private final RunnableC0380b hyt = new RunnableC0380b(this);

    static {
        AppMethodBeat.i(196443);
        AppMethodBeat.o(196443);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
    public static final class d extends q implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x> {
        final /* synthetic */ b hyw;
        final /* synthetic */ long hyx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, long j2) {
            super(3);
            this.hyw = bVar;
            this.hyx = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(com.tencent.mm.live.core.b.l lVar, Integer num, Integer num2) {
            AppMethodBeat.i(196427);
            final com.tencent.mm.live.core.b.l lVar2 = lVar;
            num.intValue();
            num2.intValue();
            p.h(lVar2, "surface");
            lVar2.hEC = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.core.core.a.b.d.AnonymousClass1 */
                final /* synthetic */ d hyz;

                {
                    this.hyz = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(196425);
                    lVar2.hEC = null;
                    this.hyz.hyw.hAr.bO(lVar2.beb);
                    com.tencent.mm.live.core.c.a.qz((int) Util.ticksToNow(this.hyz.hyx));
                    x xVar = x.SXb;
                    AppMethodBeat.o(196425);
                    return xVar;
                }
            };
            lVar2.hED = new m<Integer, Integer, x>(this) {
                /* class com.tencent.mm.live.core.core.a.b.d.AnonymousClass2 */
                final /* synthetic */ d hyz;

                {
                    this.hyz = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, Integer num2) {
                    AppMethodBeat.i(196426);
                    this.hyz.hyw.hAr.cX(num.intValue(), num2.intValue());
                    x xVar = x.SXb;
                    AppMethodBeat.o(196426);
                    return xVar;
                }
            };
            x xVar = x.SXb;
            AppMethodBeat.o(196427);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "mFps", "", "invoke"})
    static final class e extends q implements kotlin.g.a.b<Integer, x> {
        public static final e hyB = new e();

        static {
            AppMethodBeat.i(196429);
            AppMethodBeat.o(196429);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(196428);
            int intValue = num.intValue();
            if (intValue <= 5) {
                com.tencent.mm.live.core.c.a.aEH();
            } else if (intValue <= 10) {
                com.tencent.mm.live.core.c.a.aEI();
            } else if (intValue > 10) {
                com.tencent.mm.live.core.c.a.aEJ();
            }
            com.tencent.mm.live.core.c.a.qC(intValue);
            x xVar = x.SXb;
            AppMethodBeat.o(196428);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "cost", "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Integer, x> {
        public static final f hyC = new f();

        static {
            AppMethodBeat.i(196431);
            AppMethodBeat.o(196431);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(196430);
            com.tencent.mm.live.core.c.a.qB(num.intValue());
            x xVar = x.SXb;
            AppMethodBeat.o(196430);
            return xVar;
        }
    }

    public b() {
        super(true);
        AppMethodBeat.i(196442);
        AppMethodBeat.o(196442);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b aDo() {
            AppMethodBeat.i(196418);
            if (b.hyu == null) {
                b.hyu = new b();
            }
            b bVar = b.hyu;
            if (bVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(196418);
            return bVar;
        }

        public static boolean aDp() {
            AppMethodBeat.i(196419);
            if (b.hyu != null) {
                AppMethodBeat.o(196419);
                return true;
            }
            AppMethodBeat.o(196419);
            return false;
        }

        public static void releaseInstance() {
            AppMethodBeat.i(196420);
            b bVar = b.hyu;
            if (bVar != null) {
                bVar.release();
            }
            b.hyu = null;
            AppMethodBeat.o(196420);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
    /* renamed from: com.tencent.mm.live.core.core.a.b$b  reason: collision with other inner class name */
    public static final class RunnableC0380b implements Runnable {
        final /* synthetic */ b hyw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        RunnableC0380b(b bVar) {
            this.hyw = bVar;
        }

        public final void run() {
            AppMethodBeat.i(196421);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            TRTCCloud tRTCCloud = this.hyw.hAl;
            if (tRTCCloud == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
                AppMethodBeat.o(196421);
                throw tVar;
            }
            com.tencent.mm.live.core.debug.a.GC(((com.tencent.mm.live.core.core.trtc.b) tRTCCloud).aDA().toString());
            this.hyw.hAk.removeCallbacks(this);
            this.hyw.hAk.postDelayed(this, 10000);
            AppMethodBeat.o(196421);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"})
    public static final class c implements TextureView.SurfaceTextureListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ b hyw;
        final /* synthetic */ long hyx;
        final /* synthetic */ TextureView hyy;

        c(b bVar, long j2, Context context, TextureView textureView) {
            this.hyw = bVar;
            this.hyx = j2;
            this.$context = context;
            this.hyy = textureView;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(196422);
            Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureSizeChanged, surface:" + surfaceTexture + ", size:[" + i2 + ", " + i3 + ']');
            this.hyw.hAr.cX(i2, i3);
            AppMethodBeat.o(196422);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(196423);
            Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureDestroyed");
            AppMethodBeat.o(196423);
            return false;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            int i4;
            int i5;
            AppMethodBeat.i(196424);
            Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureAvailable, surface:" + surfaceTexture + ", size:[" + i2 + ", " + i3 + ']');
            com.tencent.mm.live.core.c.a.qA((int) Util.ticksToNow(this.hyx));
            int i6 = au.az(this.$context).x;
            int i7 = au.az(this.$context).y;
            if (i6 > i7) {
                i4 = i7;
                i5 = i6;
            } else if (i7 > i6) {
                i4 = i6;
                i5 = i7;
            } else {
                i4 = i6;
                i5 = i7;
            }
            if (i2 < i3) {
                i3 = (int) ((((float) i5) / ((float) i4)) * ((float) i2));
            } else if (i3 < i2) {
                i2 = (int) ((((float) i5) / ((float) i4)) * ((float) i3));
            }
            this.hyw.hAr.bO(this.hyy.getSurfaceTexture());
            this.hyw.hAr.cX(i2, i3);
            AppMethodBeat.o(196424);
        }
    }

    @Override // com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.a
    public final void a(com.tencent.mm.live.core.core.c cVar) {
        AppMethodBeat.i(196433);
        p.h(cVar, "callback");
        super.a(cVar);
        com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
        com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC2, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC2.aDE();
        p.g(aDD, "videoConfig");
        aDD.eC(true);
        p.g(aDE, "audioConfig");
        aDE.ez(true);
        com.tencent.mm.live.core.core.trtc.a.c cVar2 = this.hAn;
        if (cVar2 != null) {
            cVar2.startLocalAudio();
        }
        com.tencent.mm.live.core.core.trtc.a.c cVar3 = this.hAn;
        if (cVar3 != null) {
            cVar3.ey(aDE.aDQ());
            AppMethodBeat.o(196433);
            return;
        }
        AppMethodBeat.o(196433);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a, com.tencent.mm.live.core.core.trtc.a.d
    public final void onEnterRoom(long j2) {
        AppMethodBeat.i(196434);
        super.onEnterRoom(j2);
        this.hAk.post(this.hyt);
        AppMethodBeat.o(196434);
    }

    @Override // com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.a
    public final void aBU() {
        AppMethodBeat.i(196437);
        long currentTicks = Util.currentTicks();
        super.aBU();
        LivePreviewView livePreviewView = this.hAs;
        if (livePreviewView != null) {
            livePreviewView.a(new d(this, currentTicks));
            AppMethodBeat.o(196437);
            return;
        }
        AppMethodBeat.o(196437);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a, com.tencent.mm.live.core.core.trtc.a.d
    public final void onError(int i2, String str, Bundle bundle) {
        AppMethodBeat.i(196438);
        if (i2 == -3301) {
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.GB("[-3301]create room fail,".concat(String.valueOf(str)));
            com.tencent.mm.live.core.core.c cVar = this.hAv;
            if (cVar != null) {
                c.a.a(cVar, i2);
            }
            this.hAv = null;
            AppMethodBeat.o(196438);
            return;
        }
        super.onError(i2, str, bundle);
        AppMethodBeat.o(196438);
    }

    public final void bE(String str, String str2, String str3) {
        AppMethodBeat.i(261590);
        p.h(str, "roomId");
        p.h(str2, ch.COL_USERNAME);
        p.h(str3, "pkSign");
        Log.i("MicroMsg.LiveCoreAnchor", "startCrossLinkMic roomId:" + str + " username:" + str2 + " pkSign:" + str3);
        this.hAz.hzD = g.e.ROLE_APPLY_PK;
        bF(str, str2, str3);
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar != null) {
            cVar.bG(str, str2, str3);
            AppMethodBeat.o(261590);
            return;
        }
        AppMethodBeat.o(261590);
    }

    public final void aFT() {
        AppMethodBeat.i(261591);
        Log.i("MicroMsg.LiveCoreAnchor", "stopCrossLinkMic is applyPkRole:" + this.hAz.bmy());
        if (this.hAz.bmy()) {
            aFU();
            com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
            if (cVar != null) {
                cVar.bpZ();
            }
            this.hAz.hzD = g.e.ROLE_DEFAULT;
        }
        AppMethodBeat.o(261591);
    }

    public static void bF(String str, String str2, String str3) {
        AppMethodBeat.i(261592);
        com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.c aDF = aDC.aDF();
        if (aDF != null) {
            aDF.bxi(str3);
            aDF.bxh(str2);
            aDF.ie(true);
            aDF.bxg(str);
            AppMethodBeat.o(261592);
            return;
        }
        AppMethodBeat.o(261592);
    }

    public static void aFU() {
        AppMethodBeat.i(261593);
        com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.c aDF = aDC.aDF();
        if (aDF != null) {
            aDF.bxi("");
            aDF.bxh("");
            aDF.ie(false);
            aDF.bxg("");
            AppMethodBeat.o(261593);
            return;
        }
        AppMethodBeat.o(261593);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a
    public final void release() {
        AppMethodBeat.i(196441);
        super.release();
        this.hAk.removeCallbacks(this.hyt);
        this.hAv = null;
        this.hAw = null;
        AppMethodBeat.o(196441);
    }

    @Override // com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.a
    public final int a(Context context, boolean z, boolean z2, int i2, int i3) {
        com.tencent.mm.live.core.b.f fVar;
        com.tencent.mm.live.core.core.b.e eVar;
        AppMethodBeat.i(196432);
        p.h(context, "context");
        g gVar = this.hAz;
        com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
        if (!gVar.b((fVar2 == null || (eVar = fVar2.hwP) == null) ? null : Long.valueOf(eVar.liveId))) {
            AppMethodBeat.o(196432);
            return -4;
        }
        long currentTicks = Util.currentTicks();
        TextureView textureView = new TextureView(MMApplicationContext.getContext());
        textureView.setSurfaceTextureListener(new c(this, currentTicks, context, textureView));
        com.tencent.mm.live.core.b.g gVar2 = this.hAr.hDw;
        if (!(gVar2 == null || (fVar = gVar2.hDO) == null)) {
            fVar.hDL = 0;
            fVar.hDK = 0;
        }
        this.hAq.co(textureView);
        int a2 = super.a(context, z, z2, i2, i3);
        AppMethodBeat.o(196432);
        return a2;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final int aBX() {
        AppMethodBeat.i(196435);
        this.hAr.e((kotlin.g.a.b<? super Integer, x>) null);
        this.hAl.enableCustomVideoCapture(false);
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar != null) {
            cVar.stopLocalAudio();
        }
        this.hAA = false;
        AppMethodBeat.o(196435);
        return 0;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final int aBY() {
        AppMethodBeat.i(196436);
        this.hAl.enableCustomVideoCapture(true);
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar != null) {
            cVar.startLocalAudio();
        }
        this.hAA = true;
        this.hAr.e(e.hyB);
        this.hAr.f(f.hyC);
        AppMethodBeat.o(196436);
        return 0;
    }

    public final void a(com.tencent.mm.live.core.b.a aVar, com.tencent.mm.live.core.b.b bVar) {
        AppMethodBeat.i(196439);
        a(this.hAs, aVar, bVar);
        AppMethodBeat.o(196439);
    }

    public final void ew(boolean z) {
        AppMethodBeat.i(196440);
        com.tencent.mm.live.core.b.d dVar = this.hAr;
        dVar.j(new d.i(dVar, z));
        AppMethodBeat.o(196440);
    }
}
