package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/emoji/report/AnimateEmojiReporter;", "", "()V", "isRecentClick", "", "()Z", "setRecentClick", "(Z)V", "plugin-emojisdk_release"})
public final class a {
    private static boolean hbY;
    public static final a hbZ = new a();

    static {
        AppMethodBeat.i(199998);
        AppMethodBeat.o(199998);
    }

    private a() {
    }

    public static boolean avY() {
        return hbY;
    }

    public static void ed(boolean z) {
        hbY = z;
    }
}
