package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/CapturePanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class d extends ab<c> {
    private c gXZ = avq();
    private final i gYa;

    public d(i iVar) {
        p.h(iVar, "config");
        AppMethodBeat.i(105530);
        this.gYa = iVar;
        AppMethodBeat.o(105530);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.emoji.b.b.w] */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(105527);
        c cVar2 = cVar;
        p.h(cVar2, "<set-?>");
        this.gXZ = cVar2;
        AppMethodBeat.o(105527);
    }

    /* Return type fixed from 'com.tencent.mm.emoji.b.b.w' to match base method */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* synthetic */ c avr() {
        AppMethodBeat.i(105529);
        c avq = avq();
        AppMethodBeat.o(105529);
        return avq;
    }

    private c avq() {
        AppMethodBeat.i(105528);
        c cVar = new c(this.gYa.gYl);
        AppMethodBeat.o(105528);
        return cVar;
    }

    /* Return type fixed from 'com.tencent.mm.emoji.b.b.w' to match base method */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* bridge */ /* synthetic */ c avp() {
        return this.gXZ;
    }
}
