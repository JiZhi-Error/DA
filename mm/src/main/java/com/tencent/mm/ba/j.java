package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class j extends MStorage implements k {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    h iFy;

    public j(h hVar) {
        this.iFy = hVar;
    }

    public final boolean c(k.b bVar) {
        AppMethodBeat.i(116842);
        if (bVar == null) {
            AppMethodBeat.o(116842);
            return true;
        }
        if (this.iFy.delete("oplog2", "id= ? AND inserTime= ?", new String[]{new StringBuilder().append(bVar.id).toString(), new StringBuilder().append(bVar.iWh).toString()}) >= 0) {
            AppMethodBeat.o(116842);
            return true;
        }
        AppMethodBeat.o(116842);
        return false;
    }
}
