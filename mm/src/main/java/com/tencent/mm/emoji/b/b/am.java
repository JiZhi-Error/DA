package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0006\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/StorePanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class am extends ab<al> {
    private final EmojiGroupInfo gVA;
    private al gZl = new al(this.gVA, true);

    public am(EmojiGroupInfo emojiGroupInfo) {
        p.h(emojiGroupInfo, "groupInfo");
        AppMethodBeat.i(105591);
        this.gVA = emojiGroupInfo;
        AppMethodBeat.o(105591);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.emoji.b.b.w] */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* synthetic */ void a(al alVar) {
        AppMethodBeat.i(105588);
        al alVar2 = alVar;
        p.h(alVar2, "<set-?>");
        this.gZl = alVar2;
        AppMethodBeat.o(105588);
    }

    /* Return type fixed from 'com.tencent.mm.emoji.b.b.w' to match base method */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* bridge */ /* synthetic */ al avp() {
        return this.gZl;
    }

    /* Return type fixed from 'com.tencent.mm.emoji.b.b.w' to match base method */
    @Override // com.tencent.mm.emoji.b.b.ab
    public final /* synthetic */ al avr() {
        AppMethodBeat.i(105590);
        al alVar = new al(this.gVA);
        AppMethodBeat.o(105590);
        return alVar;
    }
}
