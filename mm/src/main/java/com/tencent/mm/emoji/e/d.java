package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.protocal.protobuf.ajd;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/util/EmojiUserDataUtil;", "", "()V", "addPurchase", "", "groupId", "", "isPurchased", "", "plugin-emojisdk_release"})
public final class d {
    public static final d hdY = new d();

    static {
        AppMethodBeat.i(200014);
        AppMethodBeat.o(200014);
    }

    private d() {
    }

    public static boolean EZ(String str) {
        AppMethodBeat.i(200012);
        p.h(str, "groupId");
        j auL = j.auL();
        p.g(auL, "EmojiStorageCache.getInstance()");
        boolean contains = auL.auM().LsH.contains(str);
        AppMethodBeat.o(200012);
        return contains;
    }

    public static void Fa(String str) {
        AppMethodBeat.i(200013);
        p.h(str, "groupId");
        j auL = j.auL();
        p.g(auL, "EmojiStorageCache.getInstance()");
        ajd auM = auL.auM();
        if (!auM.LsH.contains(str)) {
            auM.LsH.add(str);
            j.auL().auN();
        }
        AppMethodBeat.o(200013);
    }
}
