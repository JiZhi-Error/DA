package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.emoji.b.b;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;

public final class b extends y {
    public b() {
        super(com.tencent.mm.br.b.bfR("emoji"));
        AppMethodBeat.i(108544);
        b.a.qYv = new com.tencent.mm.plugin.emoji.b.b() {
            /* class com.tencent.mm.plugin.emoji.model.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.emoji.b.b
            public final d getEmojiMgr() {
                AppMethodBeat.i(108541);
                f cGf = k.cGf();
                AppMethodBeat.o(108541);
                return cGf;
            }

            @Override // com.tencent.mm.plugin.emoji.b.b
            public final bj getEmojiStorageMgr() {
                AppMethodBeat.i(108542);
                bj emojiStorageMgr = k.getEmojiStorageMgr();
                AppMethodBeat.o(108542);
                return emojiStorageMgr;
            }

            @Override // com.tencent.mm.plugin.emoji.b.b
            public final bf getEmojiDescMgr() {
                AppMethodBeat.i(108543);
                bf emojiDescMgr = k.getEmojiDescMgr();
                AppMethodBeat.o(108543);
                return emojiDescMgr;
            }
        };
        AppMethodBeat.o(108544);
    }
}
