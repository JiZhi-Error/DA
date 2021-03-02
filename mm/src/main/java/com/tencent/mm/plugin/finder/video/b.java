package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\fH\u0016JG\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00100\u001fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "playStart", "", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class b implements p {
    final VideoCompositionPlayView wbi;
    private final c wbj;
    private final EffectManager wbk = new EffectManager();
    private long wbl;

    public b(Context context, cjl cjl) {
        p.h(context, "context");
        p.h(cjl, "media");
        AppMethodBeat.i(253884);
        this.wbi = new VideoCompositionPlayView(context);
        acn acn = cjl.MfU;
        acn = acn == null ? new acn() : acn;
        p.g(acn, "media.videoCompositionInfo ?: CompositionInfo()");
        acn.iiv = "";
        acn.Gzo = false;
        this.wbj = i.d(acn);
        this.wbj.start();
        ac d2 = i.d(acn, this.wbk);
        d2.O(this.wbj);
        this.wbi.a(d2.getComposition());
        this.wbl = d2.Gez.getPlayStart();
        AppMethodBeat.o(253884);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview$start$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-finder_release"})
    public static final class a implements a.C2159a.b {
        final /* synthetic */ b wbm;
        final /* synthetic */ kotlin.g.a.a wbn;
        final /* synthetic */ kotlin.g.a.a wbo;
        final /* synthetic */ kotlin.g.a.b wbp;

        a(b bVar, kotlin.g.a.a aVar, kotlin.g.a.a aVar2, kotlin.g.a.b bVar2) {
            this.wbm = bVar;
            this.wbn = aVar;
            this.wbo = aVar2;
            this.wbp = bVar2;
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dER() {
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dES() {
            AppMethodBeat.i(253877);
            this.wbn.invoke();
            AppMethodBeat.o(253877);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dET() {
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void Go(long j2) {
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dEU() {
            AppMethodBeat.i(253878);
            this.wbm.wbi.pause();
            this.wbo.invoke();
            AppMethodBeat.o(253878);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dEV() {
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.b
        public final void dEW() {
            AppMethodBeat.i(253879);
            this.wbp.invoke(0L);
            AppMethodBeat.o(253879);
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final void a(kotlin.g.a.a<x> aVar, kotlin.g.a.a<x> aVar2, kotlin.g.a.b<? super Long, x> bVar) {
        AppMethodBeat.i(253880);
        p.h(aVar, "onReady");
        p.h(aVar2, "onDestroy");
        p.h(bVar, "onSeekFrame");
        this.wbi.setPlayerCallback(new a(this, aVar2, aVar, bVar));
        AppMethodBeat.o(253880);
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final void seekTo(long j2) {
        AppMethodBeat.i(253881);
        this.wbi.seekTo(this.wbl + j2);
        AppMethodBeat.o(253881);
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final void destroy() {
        AppMethodBeat.i(253882);
        this.wbj.destroy();
        this.wbk.destroy();
        this.wbi.release();
        AppMethodBeat.o(253882);
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final View getView() {
        return this.wbi;
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final Bitmap getBitmap() {
        AppMethodBeat.i(253883);
        Bitmap bitmap = this.wbi.getBitmap();
        AppMethodBeat.o(253883);
        return bitmap;
    }
}
