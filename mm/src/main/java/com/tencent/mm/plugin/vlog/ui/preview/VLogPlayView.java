package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMTextureView;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\"\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0012\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010,H\u0016J\"\u0010/\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0012\u00100\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010,H\u0016J\u0006\u00101\u001a\u00020\u001aJ\u0006\u00102\u001a\u00020\u001aJ\u000e\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020'J\u0006\u00105\u001a\u00020\u001aJ\u0006\u00106\u001a\u00020\u001aJ\u0010\u00107\u001a\u00020\u001a2\b\u00108\u001a\u0004\u0018\u00010\u000fJ\u000e\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\rJ\u0014\u0010;\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001fJ\u0006\u0010<\u001a\u00020\u001aJ\b\u0010=\u001a\u00020\u001aH\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R@\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R@\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canResume", "", "cropRect", "Landroid/graphics/Rect;", "frameCount", "invokePrepareCallback", "isRendering", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "prepareCallback", "Lkotlin/Function0;", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "model", "reset", "resume", "setCropRect", "rect", "setMute", "mute", "setPrepareCallback", "stop", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPlayView extends MMTextureView implements TextureView.SurfaceTextureListener {
    public static final a GOu = new a((byte) 0);
    boolean Cel;
    k GBp;
    private m<? super Long, ? super Long, x> GBq;
    com.tencent.mm.plugin.vlog.player.c GCP;
    HandlerThread GOn;
    MMHandler GOo;
    private m<? super Integer, ? super Integer, x> GOp;
    volatile boolean GOq;
    ah GOr;
    kotlin.g.a.a<x> GOs;
    boolean GOt;
    int frameCount;
    private Rect iiw;

    static {
        AppMethodBeat.i(111210);
        AppMethodBeat.o(111210);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "pts", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$1"})
    static final class b extends q implements m<Long, Long, x> {
        final /* synthetic */ VLogPlayView GOv;
        final /* synthetic */ int ifE;
        final /* synthetic */ int ifF;
        final /* synthetic */ SurfaceTexture iqJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VLogPlayView vLogPlayView, int i2, int i3, SurfaceTexture surfaceTexture) {
            super(2);
            this.GOv = vLogPlayView;
            this.ifE = i2;
            this.ifF = i3;
            this.iqJ = surfaceTexture;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Long l2) {
            AppMethodBeat.i(111197);
            long longValue = l.longValue();
            long longValue2 = l2.longValue();
            VLogPlayView.a(this.GOv);
            m mVar = this.GOv.GBq;
            if (mVar != null) {
                mVar.invoke(Long.valueOf(longValue), Long.valueOf(longValue2));
            }
            if (this.GOv.frameCount > 1 && !this.GOv.GOt) {
                kotlin.g.a.a aVar = this.GOv.GOs;
                if (aVar != null) {
                    aVar.invoke();
                }
                this.GOv.GOt = true;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111197);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$2"})
    static final class c extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ VLogPlayView GOv;
        final /* synthetic */ int ifE;
        final /* synthetic */ int ifF;
        final /* synthetic */ SurfaceTexture iqJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(VLogPlayView vLogPlayView, int i2, int i3, SurfaceTexture surfaceTexture) {
            super(1);
            this.GOv = vLogPlayView;
            this.ifE = i2;
            this.ifF = i3;
            this.iqJ = surfaceTexture;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(111198);
            l.longValue();
            Log.i("MicroMsg.VLogPlayView", "onDecodeEnd");
            VLogPlayView.a(this.GOv);
            x xVar = x.SXb;
            AppMethodBeat.o(111198);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public VLogPlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(111208);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(111208);
    }

    public VLogPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111209);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(111209);
    }

    public final void setCropRect(Rect rect) {
        AppMethodBeat.i(192019);
        if (this.GCP == null) {
            this.iiw = rect;
            AppMethodBeat.o(192019);
            return;
        }
        com.tencent.mm.plugin.vlog.player.c cVar = this.GCP;
        if (cVar != null) {
            cVar.setCropRect(rect);
            AppMethodBeat.o(192019);
            return;
        }
        AppMethodBeat.o(192019);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(111200);
        Log.i("MicroMsg.VLogPlayView", "surfaceSizeChanged, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        AppMethodBeat.o(111200);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(111201);
        Log.i("MicroMsg.VLogPlayView", "surfaceDestroy");
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        AppMethodBeat.o(111201);
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(111202);
        Log.i("MicroMsg.VLogPlayView", "surfaceAvailable, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        this.GOn = com.tencent.f.c.d.hA("VLogPlayView_PreviewPlayer", -4);
        HandlerThread handlerThread = this.GOn;
        if (handlerThread != null) {
            handlerThread.start();
        }
        HandlerThread handlerThread2 = this.GOn;
        this.GOo = new MMHandler(handlerThread2 != null ? handlerThread2.getLooper() : null);
        if (surfaceTexture != null) {
            this.GBp = new g(i2, i3);
            k kVar = this.GBp;
            if (kVar != null) {
                kVar.k(new Surface(surfaceTexture));
            }
            this.GCP = new com.tencent.mm.plugin.vlog.player.c(i2, i3);
            com.tencent.mm.plugin.vlog.player.c cVar = this.GCP;
            if (cVar != null) {
                k kVar2 = this.GBp;
                if (kVar2 == null) {
                    p.hyc();
                }
                cVar.a(kVar2);
            }
            com.tencent.mm.plugin.vlog.player.c cVar2 = this.GCP;
            if (cVar2 != null) {
                cVar2.fCl();
            }
            m<? super Integer, ? super Integer, x> mVar = this.GOp;
            if (mVar != null) {
                mVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            }
            com.tencent.mm.plugin.vlog.player.c cVar3 = this.GCP;
            if (cVar3 != null) {
                cVar3.GBq = new b(this, i2, i3, surfaceTexture);
                cVar3.GBr = new c(this, i2, i3, surfaceTexture);
                ah ahVar = this.GOr;
                if (ahVar != null) {
                    Log.i("MicroMsg.VLogPlayView", "play in onSurfaceTextureAvailable " + ahVar.hashCode());
                    this.GOq = true;
                    cVar3.a(ahVar, ahVar.getVideoDurationMs(), ahVar.GzR);
                    com.tencent.mm.plugin.vlog.player.c.a(cVar3, null, false, 7);
                    this.frameCount++;
                }
                if (this.iiw != null) {
                    cVar3.setCropRect(this.iiw);
                }
                AppMethodBeat.o(111202);
                return;
            }
        }
        AppMethodBeat.o(111202);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$updateFrameOnTime$1$1"})
    public static final class d implements Runnable {
        final /* synthetic */ VLogPlayView GOv;
        final /* synthetic */ com.tencent.mm.plugin.vlog.player.c GOw;

        d(com.tencent.mm.plugin.vlog.player.c cVar, VLogPlayView vLogPlayView) {
            this.GOw = cVar;
            this.GOv = vLogPlayView;
        }

        public final void run() {
            AppMethodBeat.i(111199);
            com.tencent.mm.plugin.vlog.player.c.a(this.GOw, null, false, 7);
            this.GOv.frameCount++;
            AppMethodBeat.o(111199);
        }
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(111206);
        com.tencent.mm.plugin.vlog.player.c cVar = this.GCP;
        if (cVar != null) {
            cVar.setMute(z);
            AppMethodBeat.o(111206);
            return;
        }
        AppMethodBeat.o(111206);
    }

    public final void setPrepareCallback(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(111207);
        p.h(aVar, "prepareCallback");
        this.GOs = aVar;
        AppMethodBeat.o(111207);
    }

    public static final /* synthetic */ void a(VLogPlayView vLogPlayView) {
        AppMethodBeat.i(111211);
        com.tencent.mm.plugin.vlog.player.c cVar = vLogPlayView.GCP;
        if (cVar != null) {
            if (vLogPlayView.GOq) {
                MMHandler mMHandler = vLogPlayView.GOo;
                if (mMHandler != null) {
                    mMHandler.removeCallbacksAndMessages(null);
                }
                MMHandler mMHandler2 = vLogPlayView.GOo;
                if (mMHandler2 != null) {
                    mMHandler2.postDelayed(new d(cVar, vLogPlayView), cVar.GBt);
                    AppMethodBeat.o(111211);
                    return;
                }
            }
            AppMethodBeat.o(111211);
            return;
        }
        AppMethodBeat.o(111211);
    }
}
