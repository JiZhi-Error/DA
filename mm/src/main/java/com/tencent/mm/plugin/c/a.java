package com.tencent.mm.plugin.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.g;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class a implements com.tencent.mm.kernel.api.a, e, c {
    private static final HashMap<Integer, h.b> baseDBFactories;
    private static a kxQ;
    private g kxR;

    private a() {
    }

    public static synchronized a bqE() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(151420);
            if (kxQ == null) {
                kxQ = new a();
            }
            aVar = kxQ;
            AppMethodBeat.o(151420);
        }
        return aVar;
    }

    public final g aTp() {
        AppMethodBeat.i(151421);
        com.tencent.mm.kernel.g.aAf().azk();
        g gVar = this.kxR;
        AppMethodBeat.o(151421);
        return gVar;
    }

    public static boolean D(CharSequence charSequence) {
        AppMethodBeat.i(151422);
        if (Util.isNullOrNil(charSequence) || !com.tencent.mm.kernel.g.aAf().hpY) {
            AppMethodBeat.o(151422);
            return false;
        }
        try {
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ClipProtectPattern");
            if (!Util.isNullOrNil(value)) {
                String str = new String(Base64.decode(value, 0));
                if (!Util.isNullOrNil(str) && Pattern.compile(str).matcher(charSequence).matches()) {
                    AppMethodBeat.o(151422);
                    return true;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(151422);
        return false;
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(151423);
        this.kxR = new g(hVar);
        AppMethodBeat.o(151423);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    static {
        AppMethodBeat.i(151424);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.c.a.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return g.SQL_CREATE;
            }
        });
        AppMethodBeat.o(151424);
    }
}
