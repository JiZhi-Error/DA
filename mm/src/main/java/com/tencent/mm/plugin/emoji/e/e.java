package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    private static final c qZD;

    public static c fQ(String str, String str2) {
        AppMethodBeat.i(108427);
        c h2 = h(str, str2, new Object[0]);
        AppMethodBeat.o(108427);
        return h2;
    }

    public static c cFG() {
        AppMethodBeat.i(108430);
        c.a aVar = new c.a();
        aVar.jbd = true;
        aVar.jbf = false;
        aVar.jbi = 3;
        c bdv = aVar.bdv();
        AppMethodBeat.o(108430);
        return bdv;
    }

    public static c j(String str, String str2, Object... objArr) {
        AppMethodBeat.i(108431);
        String str3 = g.aAh().hqG;
        a aVar = a.hdT;
        String j2 = EmojiLogic.j(a.awt(), str, str2);
        if (!Util.isNullOrNil(j2)) {
            c.a aVar2 = new c.a();
            aVar2.jbd = true;
            aVar2.jbf = true;
            aVar2.fullPath = j2;
            aVar2.prefixPath = str3;
            aVar2.jbE = objArr;
            c bdv = aVar2.bdv();
            AppMethodBeat.o(108431);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108431);
        return null;
    }

    static {
        AppMethodBeat.i(108438);
        c.a aVar = new c.a();
        aVar.jbd = true;
        aVar.jbi = 1;
        aVar.hZF = false;
        qZD = aVar.bdv();
        AppMethodBeat.o(108438);
    }

    public static c a(String str, int i2, Object... objArr) {
        AppMethodBeat.i(108433);
        if (!Util.isNullOrNil(str)) {
            c.a aVar = new c.a();
            aVar.jbf = true;
            aVar.fullPath = str;
            aVar.hZA = i2;
            aVar.hZz = i2;
            aVar.jbE = objArr;
            c bdv = aVar.bdv();
            AppMethodBeat.o(108433);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108433);
        return null;
    }

    public static c h(String str, String str2, Object... objArr) {
        AppMethodBeat.i(108428);
        a aVar = a.hdT;
        String j2 = EmojiLogic.j(a.awt(), str, str2);
        if (!Util.isNullOrNil(j2)) {
            c.a aVar2 = new c.a();
            aVar2.jbd = true;
            aVar2.jbf = true;
            aVar2.fullPath = j2;
            aVar2.jbE = objArr;
            c bdv = aVar2.bdv();
            AppMethodBeat.o(108428);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108428);
        return null;
    }

    public static c K(String str, String str2, int i2) {
        AppMethodBeat.i(108429);
        a aVar = a.hdT;
        String j2 = EmojiLogic.j(a.awt(), str, str2);
        if (!Util.isNullOrNil(j2)) {
            c.a aVar2 = new c.a();
            aVar2.jbd = true;
            aVar2.jbf = true;
            aVar2.fullPath = j2;
            aVar2.hZA = i2;
            aVar2.hZz = i2;
            c bdv = aVar2.bdv();
            AppMethodBeat.o(108429);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108429);
        return null;
    }

    public static c fR(String str, String str2) {
        AppMethodBeat.i(108434);
        a aVar = a.hdT;
        String j2 = EmojiLogic.j(a.awt(), str, str2);
        if (!Util.isNullOrNil(j2)) {
            c.a aVar2 = new c.a();
            aVar2.jbd = true;
            aVar2.jbf = true;
            aVar2.fullPath = j2;
            aVar2.iaT = true;
            c bdv = aVar2.bdv();
            AppMethodBeat.o(108434);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108434);
        return null;
    }

    public static c fS(String str, String str2) {
        AppMethodBeat.i(108435);
        a aVar = a.hdT;
        String j2 = EmojiLogic.j(a.awt(), str, str2);
        if (!Util.isNullOrNil(j2)) {
            c.a aVar2 = new c.a();
            aVar2.jbd = true;
            aVar2.jbf = true;
            aVar2.fullPath = j2;
            aVar2.iaT = false;
            c bdv = aVar2.bdv();
            AppMethodBeat.o(108435);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108435);
        return null;
    }

    public static c k(String str, String str2, Object... objArr) {
        AppMethodBeat.i(108436);
        a aVar = a.hdT;
        String j2 = EmojiLogic.j(a.awt(), str, str2);
        if (!Util.isNullOrNil(j2)) {
            c.a aVar2 = new c.a();
            aVar2.jbd = false;
            aVar2.jbf = true;
            aVar2.fullPath = j2;
            aVar2.jbE = objArr;
            c bdv = aVar2.bdv();
            AppMethodBeat.o(108436);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108436);
        return null;
    }

    public static c l(String str, String str2, Object... objArr) {
        AppMethodBeat.i(108437);
        a aVar = a.hdT;
        String j2 = EmojiLogic.j(a.awt(), str, str2);
        if (!Util.isNullOrNil(j2)) {
            c.a aVar2 = new c.a();
            aVar2.jbd = true;
            aVar2.jbf = true;
            aVar2.fullPath = j2;
            aVar2.jbE = objArr;
            c bdv = aVar2.bdv();
            AppMethodBeat.o(108437);
            return bdv;
        }
        Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
        AppMethodBeat.o(108437);
        return null;
    }
}
