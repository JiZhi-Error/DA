package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "OpenIMAccTypeInfo")};
    public h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(a aVar) {
        AppMethodBeat.i(151327);
        boolean a2 = a(aVar);
        AppMethodBeat.o(151327);
        return a2;
    }

    static {
        AppMethodBeat.i(151328);
        AppMethodBeat.o(151328);
    }

    public b(h hVar) {
        super(hVar, a.info, "OpenIMAccTypeInfo", null);
        this.iFy = hVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(151326);
        aVar.field_updateTime = Util.nowSecond();
        boolean replace = super.replace(aVar);
        AppMethodBeat.o(151326);
        return replace;
    }
}
