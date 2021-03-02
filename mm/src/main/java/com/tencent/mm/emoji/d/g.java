package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class g extends d {
    public g(EmojiInfo emojiInfo, boolean z, d.a aVar) {
        super(emojiInfo, z, aVar);
        AppMethodBeat.i(104496);
        new l(emojiInfo, z, emojiInfo.field_attachedText, emojiInfo.hYw(), emojiInfo.field_imitateMd5).gXA = new l.b() {
            /* class com.tencent.mm.emoji.d.g.AnonymousClass1 */

            @Override // com.tencent.mm.emoji.b.l.b
            public final void b(int i2, int i3, String str, boolean z) {
                AppMethodBeat.i(104495);
                if (i2 == 0 && i3 == 0) {
                    g.this.C(0, str);
                    AppMethodBeat.o(104495);
                } else if (z) {
                    g.this.pt(2);
                    AppMethodBeat.o(104495);
                } else {
                    g.this.pt(i3);
                    AppMethodBeat.o(104495);
                }
            }
        };
        AppMethodBeat.o(104496);
    }
}
