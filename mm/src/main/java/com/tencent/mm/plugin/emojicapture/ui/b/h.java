package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.mm.media.j.a;
import com.tencent.mm.sticker.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "renderOutputType", "", "(I)V", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "pauseRender", "resumeRender", "setRemoveBg", "remove", "", "plugin-emojicapture_release"})
public abstract class h extends a implements l {
    private h() {
        super(0, 0, 0, 0, 1, 1);
    }

    public /* synthetic */ h(byte b2) {
        this();
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void a(f fVar) {
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (!(aVar instanceof l)) {
            aVar = null;
        }
        l lVar = (l) aVar;
        if (lVar != null) {
            lVar.a(fVar);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void lF(boolean z) {
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (!(aVar instanceof l)) {
            aVar = null;
        }
        l lVar = (l) aVar;
        if (lVar != null) {
            lVar.lF(z);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void aEb() {
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (!(aVar instanceof l)) {
            aVar = null;
        }
        l lVar = (l) aVar;
        if (lVar != null) {
            lVar.aEb();
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void aEa() {
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (!(aVar instanceof l)) {
            aVar = null;
        }
        l lVar = (l) aVar;
        if (lVar != null) {
            lVar.aEa();
        }
    }
}
