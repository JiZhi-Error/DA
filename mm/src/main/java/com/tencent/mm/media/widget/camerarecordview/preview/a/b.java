package com.tencent.mm.media.widget.camerarecordview.preview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "frameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "drawFrame", "", "data", "", "getFrameDataCallback", "plugin-mediaeditor_release"})
public final class b extends a {
    private final g iqW = new a(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar);
        p.h(eVar, "view");
        AppMethodBeat.i(94363);
        AppMethodBeat.o(94363);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onFrameData"})
    static final class a implements g {
        final /* synthetic */ b iqX;

        a(b bVar) {
            this.iqX = bVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.model.g
        public final boolean ai(byte[] bArr) {
            AppMethodBeat.i(94362);
            b bVar = this.iqX;
            if (bArr != null) {
                com.tencent.mm.media.j.a aVar = bVar.ihs;
                if (aVar != null) {
                    com.tencent.mm.media.j.a.a(aVar, bArr);
                }
                bVar.iqQ.requestRender();
            } else {
                Log.v("MicroMsg.CameraPreviewGLSurfaceView", "passing draw");
            }
            AppMethodBeat.o(94362);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.a.a
    public final g getFrameDataCallback() {
        return this.iqW;
    }
}
