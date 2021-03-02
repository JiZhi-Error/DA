package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.ae;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u0012\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\"H\u0002J\u0006\u0010+\u001a\u00020\u0019J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u0004\u0018\u00010.J\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010/\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0012\u00100\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u00010\"H\u0016J\"\u00102\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0012\u00103\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u00010\"H\u0016J\u0006\u00104\u001a\u00020\u0019J\u0006\u00105\u001a\u00020\u0019J\u000e\u00106\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u00107\u001a\u00020\u0019J\u0010\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010\rJ\u000e\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u000fJ@\u0010<\u001a\u00020\u001928\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013J@\u0010=\u001a\u00020\u001928\u0010\u001a\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013J\b\u0010>\u001a\u00020\u0019H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R@\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R@\u0010\u001a\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPreloadPlayView extends MMTextureView implements TextureView.SurfaceTextureListener {
    public static final a GOy = new a((byte) 0);
    public k GBp;
    private m<? super Long, ? super Long, x> GBq;
    public com.tencent.mm.plugin.vlog.player.c GCP;
    public ah GFW;
    public HandlerThread GOn;
    public MMHandler GOo;
    private m<? super Integer, ? super Integer, x> GOp;
    public volatile boolean GOq;
    private ae GOx = com.tencent.mm.plugin.vlog.ui.manager.c.fCM();
    private Rect iiw;
    public SurfaceTexture ipT;

    static {
        AppMethodBeat.i(111223);
        AppMethodBeat.o(111223);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "pts", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$1"})
    public static final class b extends q implements m<Long, Long, x> {
        final /* synthetic */ VLogPreloadPlayView GOz;
        final /* synthetic */ SurfaceTexture iqJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VLogPreloadPlayView vLogPreloadPlayView, SurfaceTexture surfaceTexture) {
            super(2);
            this.GOz = vLogPreloadPlayView;
            this.iqJ = surfaceTexture;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Long l2) {
            AppMethodBeat.i(111212);
            long longValue = l.longValue();
            long longValue2 = l2.longValue();
            VLogPreloadPlayView.a(this.GOz);
            m mVar = this.GOz.GBq;
            if (mVar != null) {
                mVar.invoke(Long.valueOf(longValue), Long.valueOf(longValue2));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111212);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$2"})
    public static final class c extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ VLogPreloadPlayView GOz;
        final /* synthetic */ SurfaceTexture iqJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(VLogPreloadPlayView vLogPreloadPlayView, SurfaceTexture surfaceTexture) {
            super(1);
            this.GOz = vLogPreloadPlayView;
            this.iqJ = surfaceTexture;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(111213);
            l.longValue();
            Log.i("MicroMsg.VLogPreloadPlayView", "onDecodeEnd");
            VLogPreloadPlayView.a(this.GOz);
            x xVar = x.SXb;
            AppMethodBeat.o(111213);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public VLogPreloadPlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(111220);
        HandlerThread hA = com.tencent.f.c.d.hA("VLogPlayView_PreviewPlayer", -4);
        p.g(hA, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
        this.GOn = hA;
        setSurfaceTextureListener(this);
        com.tencent.mm.plugin.vlog.ui.manager.c cVar = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
        AppMethodBeat.o(111220);
    }

    public VLogPreloadPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111221);
        HandlerThread hA = com.tencent.f.c.d.hA("VLogPlayView_PreviewPlayer", -4);
        p.g(hA, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
        this.GOn = hA;
        setSurfaceTextureListener(this);
        com.tencent.mm.plugin.vlog.ui.manager.c cVar = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
        AppMethodBeat.o(111221);
    }

    public VLogPreloadPlayView(Context context) {
        super(context);
        AppMethodBeat.i(111222);
        HandlerThread hA = com.tencent.f.c.d.hA("VLogPlayView_PreviewPlayer", -4);
        p.g(hA, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
        this.GOn = hA;
        setSurfaceTextureListener(this);
        com.tencent.mm.plugin.vlog.ui.manager.c cVar = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
        AppMethodBeat.o(111222);
    }

    public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, x> mVar) {
        this.GOp = mVar;
    }

    public final void setOnProgressListener(m<? super Long, ? super Long, x> mVar) {
        this.GBq = mVar;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(111215);
        Log.i("MicroMsg.VLogPreloadPlayView", "surfaceSizeChanged, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        AppMethodBeat.o(111215);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(111216);
        Log.i("MicroMsg.VLogPreloadPlayView", "surfaceDestroy");
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        AppMethodBeat.o(111216);
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(111217);
        Log.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        this.ipT = surfaceTexture;
        if (!this.GOn.isAlive()) {
            this.GOn.start();
            Log.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
        } else {
            Log.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is alive");
        }
        this.GOo = new MMHandler(this.GOn.getLooper());
        n(surfaceTexture);
        m<? super Integer, ? super Integer, x> mVar = this.GOp;
        if (mVar != null) {
            mVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(111217);
            return;
        }
        AppMethodBeat.o(111217);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.vlog.player.c GOw;

        d(com.tencent.mm.plugin.vlog.player.c cVar) {
            this.GOw = cVar;
        }

        public final void run() {
            AppMethodBeat.i(111214);
            com.tencent.mm.plugin.vlog.player.c.a(this.GOw, null, false, 7);
            AppMethodBeat.o(111214);
        }
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(111218);
        com.tencent.mm.plugin.vlog.player.c cVar = this.GCP;
        if (cVar != null) {
            cVar.setMute(z);
            AppMethodBeat.o(111218);
            return;
        }
        AppMethodBeat.o(111218);
    }

    public final void setCropRect(Rect rect) {
        AppMethodBeat.i(192020);
        if (this.GCP == null) {
            this.iiw = rect;
            AppMethodBeat.o(192020);
            return;
        }
        com.tencent.mm.plugin.vlog.player.c cVar = this.GCP;
        if (cVar != null) {
            cVar.setCropRect(rect);
            AppMethodBeat.o(192020);
            return;
        }
        AppMethodBeat.o(192020);
    }

    public final Size getSize() {
        AppMethodBeat.i(192021);
        com.tencent.mm.plugin.vlog.player.c cVar = this.GCP;
        if (cVar != null) {
            Size size = new Size(cVar.width, cVar.height);
            AppMethodBeat.o(192021);
            return size;
        }
        AppMethodBeat.o(192021);
        return null;
    }

    public final void n(SurfaceTexture surfaceTexture) {
        int i2;
        AppMethodBeat.i(111219);
        Log.i("MicroMsg.VLogPreloadPlayView", "bindPreloadManager surfaceTexture:".concat(String.valueOf(surfaceTexture)));
        if (surfaceTexture != null) {
            StringBuilder sb = new StringBuilder("vLogDirector init : ");
            com.tencent.mm.plugin.vlog.ui.manager.c cVar = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
            com.tencent.mm.plugin.vlog.player.c fCO = com.tencent.mm.plugin.vlog.ui.manager.c.fCO();
            StringBuilder append = sb.append(fCO != null ? fCO.hashCode() : 0).append(", vLogSurface : ");
            com.tencent.mm.plugin.vlog.ui.manager.c cVar2 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
            g fCN = com.tencent.mm.plugin.vlog.ui.manager.c.fCN();
            if (fCN != null) {
                i2 = fCN.hashCode();
            } else {
                i2 = 0;
            }
            Log.i("MicroMsg.VLogPreloadPlayView", append.append(i2).toString());
            com.tencent.mm.plugin.vlog.ui.manager.c cVar3 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
            this.GCP = com.tencent.mm.plugin.vlog.ui.manager.c.fCO();
            com.tencent.mm.plugin.vlog.ui.manager.c cVar4 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
            this.GBp = com.tencent.mm.plugin.vlog.ui.manager.c.fCN();
            k kVar = this.GBp;
            if (kVar != null) {
                com.tencent.mm.plugin.vlog.ui.manager.c cVar5 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
                g fCN2 = com.tencent.mm.plugin.vlog.ui.manager.c.fCN();
                if (fCN2 == null) {
                    p.hyc();
                }
                c.b bVar = fCN2.hDs;
                if (bVar == null) {
                    p.hyc();
                }
                EGLContext eGLContext = bVar.ilv;
                com.tencent.mm.plugin.vlog.ui.manager.c cVar6 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
                g fCN3 = com.tencent.mm.plugin.vlog.ui.manager.c.fCN();
                if (fCN3 == null) {
                    p.hyc();
                }
                c.b bVar2 = fCN3.hDs;
                if (bVar2 == null) {
                    p.hyc();
                }
                kVar.a(eGLContext, bVar2.ilu, new Surface(surfaceTexture), getWidth(), getHeight());
            }
            ah ahVar = this.GFW;
            if (ahVar != null) {
                Log.i("MicroMsg.VLogPreloadPlayView", "later set model: " + this.GFW);
                com.tencent.mm.plugin.vlog.player.c cVar7 = this.GCP;
                if (cVar7 != null) {
                    cVar7.a(ahVar, ahVar.getVideoDurationMs(), ahVar.GzR);
                }
            }
            com.tencent.mm.plugin.vlog.player.c cVar8 = this.GCP;
            if (cVar8 != null) {
                cVar8.fCm();
            }
            com.tencent.mm.plugin.vlog.player.c cVar9 = this.GCP;
            if (cVar9 != null) {
                cVar9.GBq = new b(this, surfaceTexture);
                cVar9.GBr = new c(this, surfaceTexture);
                if (this.iiw != null) {
                    cVar9.setCropRect(this.iiw);
                }
            }
            com.tencent.mm.plugin.vlog.player.c cVar10 = this.GCP;
            if (cVar10 != null) {
                cVar10.cX(getWidth(), getHeight());
            }
            com.tencent.mm.plugin.vlog.player.c cVar11 = this.GCP;
            if (cVar11 != null) {
                com.tencent.mm.plugin.vlog.player.c.a(cVar11, null, false, 7);
                AppMethodBeat.o(111219);
                return;
            }
        }
        AppMethodBeat.o(111219);
    }

    public static final /* synthetic */ void a(VLogPreloadPlayView vLogPreloadPlayView) {
        AppMethodBeat.i(111224);
        com.tencent.mm.plugin.vlog.player.c cVar = vLogPreloadPlayView.GCP;
        if (cVar != null) {
            if (vLogPreloadPlayView.GOq) {
                MMHandler mMHandler = vLogPreloadPlayView.GOo;
                if (mMHandler != null) {
                    mMHandler.removeCallbacksAndMessages(null);
                }
                MMHandler mMHandler2 = vLogPreloadPlayView.GOo;
                if (mMHandler2 != null) {
                    mMHandler2.postDelayed(new d(cVar), cVar.GBt);
                    AppMethodBeat.o(111224);
                    return;
                }
            }
            AppMethodBeat.o(111224);
            return;
        }
        AppMethodBeat.o(111224);
    }
}
