package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class x extends MAutoStorage<w> {
    public static int EmU = 1;
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(w.info, "SnsWsFoldGroup")};
    public static int STATE_DEFAULT = 0;
    public h iFy;

    static {
        AppMethodBeat.i(203224);
        AppMethodBeat.o(203224);
    }

    public x(h hVar) {
        super(hVar, s.info, "SnsWsFoldGroup", null);
        this.iFy = hVar;
    }

    public final boolean a(w wVar) {
        AppMethodBeat.i(203223);
        if (wVar.field_size >= ah.DKg) {
            wVar.field_state = EmU;
        }
        boolean z = this.iFy.replace("SnsWsFoldGroup", "bottom", wVar.convertTo()) > 0;
        Log.d("MicroMsg.SnsWsFoldGroupStorage", "SnsWsFoldGroup replace result ".concat(String.valueOf(z)));
        AppMethodBeat.o(203223);
        return z;
    }
}
