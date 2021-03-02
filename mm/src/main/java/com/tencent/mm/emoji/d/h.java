package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/upload/EmojiUploadFactory;", "", "()V", "useCdn", "", "getUpload", "Lcom/tencent/mm/emoji/upload/EmojiUpload;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "callback", "Lcom/tencent/mm/emoji/upload/EmojiUpload$Callback;", "plugin-emojisdk_release"})
public final class h {
    public static final h hdL = new h();

    static {
        AppMethodBeat.i(105778);
        AppMethodBeat.o(105778);
    }

    private h() {
    }

    public static d a(EmojiInfo emojiInfo, boolean z, d.a aVar) {
        AppMethodBeat.i(105777);
        p.h(emojiInfo, "emojiInfo");
        p.h(aVar, "callback");
        if (n.avl()) {
            e eVar = new e(emojiInfo, z, aVar);
            AppMethodBeat.o(105777);
            return eVar;
        }
        g gVar = new g(emojiInfo, z, aVar);
        AppMethodBeat.o(105777);
        return gVar;
    }
}
