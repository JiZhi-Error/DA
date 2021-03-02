package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/CustomPanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class f extends ab<e> {
    private final i gYa;
    private e gYb = avs();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.emoji.b.b.w] */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(105532);
        e eVar2 = eVar;
        p.h(eVar2, "<set-?>");
        this.gYb = eVar2;
        AppMethodBeat.o(105532);
    }

    /* Return type fixed from 'com.tencent.mm.emoji.b.b.w' to match base method */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* synthetic */ e avr() {
        AppMethodBeat.i(105534);
        e avs = avs();
        AppMethodBeat.o(105534);
        return avs;
    }

    public f(i iVar) {
        p.h(iVar, "config");
        AppMethodBeat.i(105535);
        this.gYa = iVar;
        AppMethodBeat.o(105535);
    }

    private e avs() {
        AppMethodBeat.i(105533);
        e eVar = new e(this.gYa.gYj, this.gYa.gYi);
        AppMethodBeat.o(105533);
        return eVar;
    }

    /* Return type fixed from 'com.tencent.mm.emoji.b.b.w' to match base method */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* bridge */ /* synthetic */ e avp() {
        return this.gYb;
    }
}
