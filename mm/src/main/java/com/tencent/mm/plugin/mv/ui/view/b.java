package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES30;
import android.os.HandlerThread;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u0014\u0010 \u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"J\b\u0010#\u001a\u00020\u000eH\u0002J\u001c\u0010$\u001a\u00020\u000e2\u0014\u0010%\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\fJ\b\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020)J8\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020)2\b\b\u0002\u0010.\u001a\u00020)J\u000e\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\rJ\u0016\u00101\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvBitmapEffector;", "", "()V", "TAG", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eGLHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eGLThread", "Landroid/os/HandlerThread;", "effectCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "height", "", "imageBitmap", "imageTex", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputTex", "texNeedCrop", "", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "width", "createEGLEnvironmentIfNeed", "createEGLThread", "destroy", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "queue", "call", "Lkotlin/Function0;", "render", "requestEffect", "callback", "requestRender", "setBlurEffect", "blurRadius", "", "setGradientBlurEffect", "blurTop", "blurBottom", "blurMaskRatio", "contentOffset", "setInputBitmap", "bitmap", "setOutputSize", "plugin-mv_release"})
public final class b {
    HandlerThread AsC;
    MMHandler AsD;
    VLogDirector AsI = new VLogDirector();
    com.tencent.mm.media.g.d Axw;
    com.tencent.mm.media.g.d Axx;
    kotlin.g.a.b<? super Bitmap, x> Axy;
    boolean Axz = true;
    final String TAG = ("MicroMsg.Mv.MusicMvBitmapEffector@" + hashCode());
    int height;
    c.b ilw;
    Bitmap imageBitmap;
    EffectManager wet = new EffectManager();
    int width;

    public b() {
        AppMethodBeat.i(257472);
        AppMethodBeat.o(257472);
    }

    public final void k(kotlin.g.a.a<x> aVar) {
        MMHandler mMHandler;
        AppMethodBeat.i(257471);
        p.h(aVar, "call");
        HandlerThread handlerThread = this.AsC;
        if (handlerThread == null) {
            AppMethodBeat.o(257471);
        } else if (!handlerThread.isAlive() || (mMHandler = this.AsD) == null) {
            AppMethodBeat.o(257471);
        } else {
            mMHandler.post(new c(aVar));
            AppMethodBeat.o(257471);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/mv/ui/view/MusicMvBitmapEffector$render$1$1"})
    static final class c implements Runnable {
        final /* synthetic */ b AxA;
        final /* synthetic */ Bitmap AxB;

        c(Bitmap bitmap, b bVar) {
            this.AxB = bitmap;
            this.AxA = bVar;
        }

        public final void run() {
            AppMethodBeat.i(257468);
            kotlin.g.a.b<? super Bitmap, x> bVar = this.AxA.Axy;
            if (bVar != null) {
                bVar.invoke(this.AxB);
                AppMethodBeat.o(257468);
                return;
            }
            AppMethodBeat.o(257468);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b AxA;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, int i2, int i3) {
            super(0);
            this.AxA = bVar;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(257466);
            this.AxA.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, null, this.cKE, this.cKF, null, 16);
            this.AxA.AsI.init();
            this.AxA.AsI.setSize(this.cKE, this.cKF);
            this.AxA.AsI.b(this.AxA.wet);
            this.AxA.Axw = new com.tencent.mm.media.g.d(true, 15);
            b bVar = this.AxA;
            com.tencent.mm.media.g.d dVar = new com.tencent.mm.media.g.d(true, 15);
            GLES30.glBindTexture(3553, dVar.igv);
            GLES30.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.cKE, this.cKF, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES30.glBindTexture(3553, 0);
            bVar.Axx = dVar;
            x xVar = x.SXb;
            AppMethodBeat.o(257466);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b AxA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.AxA = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            int i3;
            AppMethodBeat.i(257469);
            b bVar = this.AxA;
            Log.i(bVar.TAG, "start render, size:[" + bVar.width + ',' + bVar.height + "], bitmap:" + bVar.imageBitmap);
            Bitmap bitmap = bVar.imageBitmap;
            if (bitmap != null) {
                com.tencent.mm.media.g.d dVar = bVar.Axw;
                if (dVar != null) {
                    dVar.setSize(bitmap.getWidth(), bitmap.getHeight());
                }
                com.tencent.mm.media.g.d dVar2 = bVar.Axw;
                if (dVar2 != null) {
                    dVar2.c(bitmap, bitmap.getWidth(), bitmap.getHeight());
                }
                com.tencent.mm.media.g.d dVar3 = bVar.Axw;
                if (dVar3 != null) {
                    i2 = dVar3.igv;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    com.tencent.mm.media.g.d dVar4 = bVar.Axx;
                    if (dVar4 != null) {
                        i3 = dVar4.igv;
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 0) {
                        bVar.AsI.setSize(bVar.width, bVar.height);
                        bVar.AsI.setOutputSize(bVar.width, bVar.height);
                        bVar.AsI.mm(bVar.width, bVar.height);
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        com.tencent.mm.xeffect.b bVar2 = new com.tencent.mm.xeffect.b(i2, width, height, false, 0);
                        bVar2.RxI.setEmpty();
                        bVar2.RxJ.set(0, 0, width, height);
                        if (bVar.Axz) {
                            Rect rect = bVar2.RxJ;
                            p.g(rect, "inputTex.contentCrop");
                            com.tencent.mm.videocomposition.l.c(rect, new Rect(0, 0, bVar.width, bVar.height));
                        } else {
                            bVar2.RxH = false;
                        }
                        bVar.AsI.a(j.listOf(bVar2), i3, 0);
                        c.a aVar = com.tencent.mm.media.k.c.ilt;
                        Bitmap L = c.a.L(i3, bVar.width, bVar.height);
                        if (bVar.Axy != null) {
                            h.RTc.aV(new c(L, bVar));
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(257469);
                return xVar;
            }
            Log.i(bVar.TAG, "render finished");
            x xVar2 = x.SXb;
            AppMethodBeat.o(257469);
            return xVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.view.b$b  reason: collision with other inner class name */
    static final class C1560b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b AxA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1560b(b bVar) {
            super(0);
            this.AxA = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(257467);
            Log.i(this.AxA.TAG, "do destroy");
            com.tencent.mm.media.g.d dVar = this.AxA.Axw;
            if (dVar != null) {
                dVar.close();
            }
            com.tencent.mm.media.g.d dVar2 = this.AxA.Axx;
            if (dVar2 != null) {
                dVar2.close();
            }
            this.AxA.wet.hiv();
            this.AxA.AsI.destroy();
            c.b bVar = this.AxA.ilw;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            this.AxA.ilw = null;
            HandlerThread handlerThread = this.AxA.AsC;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.AxA.AsC = null;
            this.AxA.AsD = null;
            this.AxA.wet.destroy();
            x xVar = x.SXb;
            AppMethodBeat.o(257467);
            return xVar;
        }
    }
}
