package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.emoji.sync.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;

public final class e extends d {
    public e(EmojiInfo emojiInfo, boolean z, d.a aVar) {
        super(emojiInfo, z, aVar);
        AppMethodBeat.i(104489);
        new f(emojiInfo, z, new d.a() {
            /* class com.tencent.mm.emoji.d.e.AnonymousClass1 */

            @Override // com.tencent.mm.emoji.d.d.a
            public final void A(int i2, String str) {
                AppMethodBeat.i(104487);
                if (i2 == 0) {
                    e.a(e.this, str);
                    AppMethodBeat.o(104487);
                    return;
                }
                e.this.pt(i2);
                AppMethodBeat.o(104487);
            }
        });
        AppMethodBeat.o(104489);
    }

    static /* synthetic */ void a(e eVar, final String str) {
        int i2 = 1;
        AppMethodBeat.i(104490);
        Log.i("MicroMsg.EmojiUploadBackup", "backup: origin %s, gif %s", eVar.gWm.field_md5, str);
        if (!eVar.gXv) {
            i2 = 0;
        }
        new a(i2, Collections.singletonList(str)).aYI().g(new com.tencent.mm.vending.c.a<Void, c.a<il>>() {
            /* class com.tencent.mm.emoji.d.e.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(c.a<il> aVar) {
                AppMethodBeat.i(104488);
                Void a2 = a(aVar);
                AppMethodBeat.o(104488);
                return a2;
            }

            private Void a(c.a<il> aVar) {
                AppMethodBeat.i(183921);
                int i2 = aVar.errType;
                int i3 = aVar.errCode;
                Log.i("MicroMsg.EmojiUploadBackup", "backup callback: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 0 && i3 == 0) {
                    e.this.C(0, str);
                } else if (i3 == -434) {
                    if (e.this.gXv) {
                        k kVar = k.gXr;
                        k.ea(true);
                        g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                    } else {
                        k kVar2 = k.gXr;
                        k.dZ(true);
                        g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                    }
                    e.this.pt(3);
                } else {
                    e.this.aws();
                }
                Void r0 = QZL;
                AppMethodBeat.o(183921);
                return r0;
            }
        });
        AppMethodBeat.o(104490);
    }
}
