package com.tencent.mm.plugin.vlog.remux;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.g;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.player.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.IntBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0001<B´\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00128\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011\u0012#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u00103\u001a\u00020\u0017J\u0010\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u000106J@\u00107\u001a\u00020\u001728\u00108\u001a4\u0012\u0013\u0012\u001109¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011J\u0010\u0010;\u001a\u00020\u00172\b\b\u0002\u00101\u001a\u000202R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000RC\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R.\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "", "surface", "Landroid/view/Surface;", "width", "", "height", "inputVideoWidth", "inputVideoHeight", "durationMs", "frameRate", "widthScale", "", "heightScale", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onDecode", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pts", "frameCount", "", "onDecodeEnd", "Lkotlin/Function1;", "(Landroid/view/Surface;IIIIIIFFLcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "getDurationMs", "()I", "framePassDuration", "getFrameRate", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "getHeight", "lastFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "getOnDecode", "()Lkotlin/jvm/functions/Function2;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function1;", "getSurface", "()Landroid/view/Surface;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "getWidth", "withSnapshot", "", "release", "setCropRect", "rect", "Landroid/graphics/Rect;", "setSnapshotCallback", "callback", "Ljava/nio/IntBuffer;", "buffer", "startDecode", "Companion", "plugin-vlog_release"})
public final class b {
    public static final a GCU = new a((byte) 0);
    private long BKF = -1;
    private com.tencent.mm.plugin.recordvideo.ui.editor.b.a BKG;
    private g BKH;
    final com.tencent.mm.plugin.vlog.player.c GCP;
    private final com.tencent.mm.plugin.vlog.player.g GCQ;
    boolean GCR;
    final m<Long, Integer, x> GCS;
    final kotlin.g.a.b<Long, x> GCT;
    private volatile int frameCount;
    private final int frameRate;
    private final int height;
    final kotlin.g.a.b<Long, Bitmap> ihf = new C1855b(this);
    private final int jkS;
    private final Surface surface;
    private final int width;

    static {
        AppMethodBeat.i(111028);
        AppMethodBeat.o(111028);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.vlog.remux.b$b  reason: collision with other inner class name */
    static final class C1855b extends q implements kotlin.g.a.b<Long, Bitmap> {
        final /* synthetic */ b GCV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1855b(b bVar) {
            super(1);
            this.GCV = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Bitmap invoke(Long l) {
            Long l2;
            AppMethodBeat.i(111024);
            long longValue = l.longValue();
            Log.i("MicroMsg.VLogDecoder", "get bitmap ".concat(String.valueOf(longValue)));
            while (longValue > this.GCV.BKF) {
                com.tencent.mm.plugin.recordvideo.ui.editor.b.a cJu = b.c(this.GCV).cJu();
                StringBuilder sb = new StringBuilder("get frame ");
                if (cJu != null) {
                    l2 = Long.valueOf(cJu.CgA);
                } else {
                    l2 = null;
                }
                Log.i("MicroMsg.VLogDecoder", sb.append(l2).append(" blendBitmapProvider: ").append(longValue).toString());
                if (cJu == null || cJu.CgA <= 0) {
                    break;
                }
                this.GCV.BKF += cJu.CgA;
                this.GCV.BKG = cJu;
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.b.a aVar = this.GCV.BKG;
            if (aVar != null) {
                Bitmap bitmap = aVar.bitmap;
                AppMethodBeat.o(111024);
                return bitmap;
            }
            AppMethodBeat.o(111024);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/nio/IntBuffer;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<IntBuffer, x> {
        final /* synthetic */ b GCV;
        final /* synthetic */ m nzd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, m mVar) {
            super(1);
            this.GCV = bVar;
            this.nzd = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IntBuffer intBuffer) {
            AppMethodBeat.i(111025);
            IntBuffer intBuffer2 = intBuffer;
            p.h(intBuffer2, LocaleUtil.ITALIAN);
            Log.i("MicroMsg.VLogDecoder", "on Snapshot callback, frameCount:" + this.GCV.frameCount);
            m mVar = this.nzd;
            if (mVar != null) {
                mVar.invoke(intBuffer2, Integer.valueOf(this.GCV.frameCount));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111025);
            return xVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r25v0, resolved type: kotlin.g.a.m<? super java.lang.Long, ? super java.lang.Integer, kotlin.x> */
    /* JADX DEBUG: Multi-variable search result rejected for r26v0, resolved type: kotlin.g.a.b<? super java.lang.Long, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(Surface surface2, int i2, int i3, int i4, int i5, int i6, int i7, float f2, float f3, ah ahVar, m<? super Long, ? super Integer, x> mVar, kotlin.g.a.b<? super Long, x> bVar) {
        p.h(surface2, "surface");
        p.h(ahVar, "scriptModel");
        AppMethodBeat.i(190887);
        this.surface = surface2;
        this.width = i2;
        this.height = i3;
        this.jkS = i6;
        this.frameRate = i7;
        this.GCS = mVar;
        this.GCT = bVar;
        this.GCP = new com.tencent.mm.plugin.vlog.player.c(this.width, this.height, i4, i5, f2, f3);
        this.GCQ = new com.tencent.mm.plugin.vlog.player.g(this.width, this.height, i4, i5);
        e eVar = e.GBH;
        e.clearCache();
        this.GCQ.k(this.surface);
        this.GCP.a(this.GCQ);
        this.GCP.fCl();
        com.tencent.mm.plugin.vlog.player.c.a(this.GCP, ahVar, this.jkS);
        com.tencent.mm.plugin.vlog.player.c cVar = this.GCP;
        AnonymousClass1 r2 = new m<Long, Long, x>(this) {
            /* class com.tencent.mm.plugin.vlog.remux.b.AnonymousClass1 */
            final /* synthetic */ b GCV;

            {
                this.GCV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, Long l2) {
                AppMethodBeat.i(111022);
                long longValue = l.longValue();
                l2.longValue();
                m<Long, Integer, x> mVar = this.GCV.GCS;
                if (mVar != null) {
                    Long valueOf = Long.valueOf(longValue);
                    b bVar = this.GCV;
                    int i2 = bVar.frameCount;
                    bVar.frameCount = i2 + 1;
                    mVar.invoke(valueOf, Integer.valueOf(i2));
                }
                com.tencent.mm.plugin.vlog.player.c.a(this.GCV.GCP, (Bitmap) this.GCV.ihf.invoke(Long.valueOf(longValue)), this.GCV.GCR, 4);
                x xVar = x.SXb;
                AppMethodBeat.o(111022);
                return xVar;
            }
        };
        AnonymousClass2 r3 = new kotlin.g.a.b<Long, x>(this) {
            /* class com.tencent.mm.plugin.vlog.remux.b.AnonymousClass2 */
            final /* synthetic */ b GCV;

            {
                this.GCV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Long l) {
                AppMethodBeat.i(111023);
                long longValue = l.longValue();
                Log.i("MicroMsg.VLogDecoder", "onDecodeEnd");
                kotlin.g.a.b<Long, x> bVar = this.GCV.GCT;
                if (bVar != null) {
                    bVar.invoke(Long.valueOf(longValue));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(111023);
                return xVar;
            }
        };
        p.h(r2, "onProgress");
        p.h(r3, "onEnd");
        Log.i("MicroMsg.VLogDirector", "setCallback");
        cVar.GBq = r2;
        cVar.GBr = r3;
        this.BKH = new g(new d(ahVar.BKV, ahVar.BKW, ahVar.BNn, this.width, this.height, this.width, this.height, 0, true, null, 512));
        g gVar = this.BKH;
        if (gVar == null) {
            p.btv("frameRetriever");
        }
        gVar.start();
        AppMethodBeat.o(190887);
    }

    public static final /* synthetic */ g c(b bVar) {
        AppMethodBeat.i(190888);
        g gVar = bVar.BKH;
        if (gVar == null) {
            p.btv("frameRetriever");
        }
        AppMethodBeat.o(190888);
        return gVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void release() {
        AppMethodBeat.i(111026);
        Log.i("MicroMsg.VLogDecoder", "release");
        this.GCP.release();
        g gVar = this.BKH;
        if (gVar == null) {
            p.btv("frameRetriever");
        }
        gVar.destroy();
        AppMethodBeat.o(111026);
    }
}
