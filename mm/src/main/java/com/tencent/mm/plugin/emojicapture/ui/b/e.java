package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0014J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"})
public final class e extends h implements k {
    private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
    private boolean ilO;

    public e() {
        super((byte) 0);
    }

    @Override // com.tencent.mm.media.j.a
    public final a aEC() {
        AppMethodBeat.i(JsApiGetRecentUsageList.CTRL_INDEX);
        Log.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.ilO);
        if (this.ilO) {
            f fVar = new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
            AppMethodBeat.o(JsApiGetRecentUsageList.CTRL_INDEX);
            return fVar;
        }
        a aVar = new a(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
        AppMethodBeat.o(JsApiGetRecentUsageList.CTRL_INDEX);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.k
    public final d cJX() {
        AppMethodBeat.i(256451);
        a aVar = this.ijo;
        if (!(aVar instanceof k)) {
            aVar = null;
        }
        k kVar = (k) aVar;
        if (kVar != null) {
            d cJX = kVar.cJX();
            AppMethodBeat.o(256451);
            return cJX;
        }
        AppMethodBeat.o(256451);
        return null;
    }
}
