package com.tencent.mm.emoji.loader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyFactory;", "", "()V", "createVerifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verify", "", "plugin-emojisdk_release"})
public final class c {
    public static final c gWT = new c();

    static {
        AppMethodBeat.i(105492);
        AppMethodBeat.o(105492);
    }

    private c() {
    }

    public static boolean k(EmojiInfo emojiInfo) {
        int i2;
        boolean z;
        AppMethodBeat.i(105491);
        p.h(emojiInfo, "emojiInfo");
        a aVar = new a();
        p.h(emojiInfo, "emojiInfo");
        String md5 = emojiInfo.getMd5();
        String str = emojiInfo.hYx() + "_temp";
        if (i.i(emojiInfo)) {
            i2 = 2;
            md5 = emojiInfo.field_externMd5;
            z = true;
        } else if (i.j(emojiInfo)) {
            i2 = 1;
            z = true;
        } else if (i.h(emojiInfo)) {
            i2 = 3;
            z = true;
        } else {
            i2 = 0;
            z = false;
        }
        if (md5 == null) {
            md5 = "";
        }
        String str2 = emojiInfo.field_aeskey;
        if (str2 == null) {
            str2 = "";
        }
        String hYx = emojiInfo.hYx();
        if (hYx == null) {
            hYx = "";
        }
        boolean a2 = aVar.a(new b(emojiInfo, md5, z, str2, hYx, str, i2));
        AppMethodBeat.o(105491);
        return a2;
    }
}
