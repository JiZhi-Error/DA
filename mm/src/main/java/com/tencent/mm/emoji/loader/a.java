package com.tencent.mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "isLegal", "", "uniqueValue", "", "plugin-emojisdk_release"})
public final class a implements c {
    final EmojiGroupInfo gVA;

    public a(EmojiGroupInfo emojiGroupInfo) {
        p.h(emojiGroupInfo, "groupInfo");
        AppMethodBeat.i(105380);
        this.gVA = emojiGroupInfo;
        AppMethodBeat.o(105380);
    }

    @Override // com.tencent.mm.loader.h.a.c
    public final String auA() {
        AppMethodBeat.i(105379);
        String hYf = this.gVA.hYf();
        p.g(hYf, "groupInfo.productID");
        AppMethodBeat.o(105379);
        return hYf;
    }
}
