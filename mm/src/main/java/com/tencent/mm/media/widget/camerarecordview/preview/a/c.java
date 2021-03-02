package com.tencent.mm.media.widget.camerarecordview.preview.a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"})
public final class c extends a {
    private final String TAG = "MicroMsg.GPUPreviewController";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "invoke"})
    static final class a extends q implements b<SurfaceTexture, x> {
        final /* synthetic */ com.tencent.mm.media.j.a iqV;
        final /* synthetic */ c iqY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, com.tencent.mm.media.j.a aVar) {
            super(1);
            this.iqY = cVar;
            this.iqV = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
            int i2;
            AppMethodBeat.i(94364);
            p.h(surfaceTexture, LocaleUtil.ITALIAN);
            com.tencent.mm.media.j.a aVar = this.iqV;
            d dVar = this.iqV.ijq;
            if (dVar != null) {
                i2 = dVar.igv;
            } else {
                i2 = -1;
            }
            aVar.input(i2);
            this.iqY.iqQ.requestRender();
            x xVar = x.SXb;
            AppMethodBeat.o(94364);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(f fVar) {
        super(fVar);
        p.h(fVar, "view");
        AppMethodBeat.i(94366);
        AppMethodBeat.o(94366);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.a.a
    public final void b(com.tencent.mm.media.j.a aVar) {
        AppMethodBeat.i(94365);
        p.h(aVar, "renderer");
        super.b(aVar);
        aVar.ijv = new a(this, aVar);
        Log.i(this.TAG, "setPreviewRenderer: " + aVar.hashCode());
        AppMethodBeat.o(94365);
    }
}
