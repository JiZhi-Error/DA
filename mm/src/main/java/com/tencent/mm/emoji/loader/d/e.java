package com.tencent.mm.emoji.loader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
public final class e extends i<x> {
    private final i.a gWA;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(EmojiInfo emojiInfo, i.a aVar) {
        super(emojiInfo);
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105464);
        this.gWA = aVar;
        AppMethodBeat.o(105464);
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public final void dR(boolean z) {
        AppMethodBeat.i(105463);
        i.a aVar = this.gWA;
        if (aVar != null) {
            aVar.dQ(z);
            AppMethodBeat.o(105463);
            return;
        }
        AppMethodBeat.o(105463);
    }
}
