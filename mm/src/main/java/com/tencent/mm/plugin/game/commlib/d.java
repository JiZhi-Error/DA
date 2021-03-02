package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.plugin.game.commlib.b.b;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class d implements a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.commlib.a.a {
    private b xvo;

    @Override // com.tencent.mm.plugin.game.commlib.a.a
    public final void a(String str, com.tencent.mm.bw.a aVar) {
        AppMethodBeat.i(89937);
        this.xvo.b(str, aVar);
        AppMethodBeat.o(89937);
    }

    @Override // com.tencent.mm.plugin.game.commlib.a.a
    public final void q(String str, byte[] bArr) {
        AppMethodBeat.i(184537);
        this.xvo.r(str, bArr);
        AppMethodBeat.o(184537);
    }

    @Override // com.tencent.mm.plugin.game.commlib.a.a
    public final byte[] azn(String str) {
        AppMethodBeat.i(89938);
        if (this.xvo == null) {
            AppMethodBeat.o(89938);
            return null;
        }
        byte[] azn = this.xvo.azn(str);
        AppMethodBeat.o(89938);
        return azn;
    }

    @Override // com.tencent.mm.plugin.game.commlib.a.a
    public final void azo(String str) {
        AppMethodBeat.i(184538);
        this.xvo.azo(str);
        AppMethodBeat.o(184538);
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(89939);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.game.commlib.d.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(89939);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(89940);
        this.xvo = new b(hVar);
        AppMethodBeat.o(89940);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }
}
