package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class v extends MAutoStorage<u> {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS snsWsFoldGroupIdIndex ON SnsWsFoldGroupDetail ( groupId )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(u.info, "SnsWsFoldGroupDetail")};
    public Map<Long, List<Long>> EmT = new HashMap();
    public h iFy;

    static {
        AppMethodBeat.i(203221);
        AppMethodBeat.o(203221);
    }

    public v(h hVar) {
        super(hVar, s.info, "SnsWsFoldGroupDetail", INDEX_CREATE);
        AppMethodBeat.i(203217);
        this.iFy = hVar;
        AppMethodBeat.o(203217);
    }

    public final boolean a(u uVar) {
        AppMethodBeat.i(203218);
        boolean z = this.iFy.replace("SnsWsFoldGroupDetail", "groupId", uVar.convertTo()) > 0;
        Log.d("MicroMsg.SnsWsFoldDetailStorage", "SnsWsFoldDetail replace result ".concat(String.valueOf(z)));
        try {
            ebn ebn = new ebn();
            ebn.parseFrom(uVar.field_groupStrcut);
            if (!Util.isNullOrNil(ebn.Nbk)) {
                this.EmT.put(Long.valueOf(uVar.field_groupId), ebn.Nbk);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.SnsWsFoldDetailStorage", "parse SnsWsGroupStruct fail:%s", e2.getMessage());
        }
        AppMethodBeat.o(203218);
        return z;
    }

    public final u JN(long j2) {
        u uVar = null;
        AppMethodBeat.i(203219);
        Cursor rawQuery = this.iFy.rawQuery("select *,rowid from SnsWsFoldGroupDetail  where SnsWsFoldGroupDetail.groupId=".concat(String.valueOf(j2)), null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToNext()) {
                uVar = new u();
                uVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(203219);
        return uVar;
    }

    public final boolean JO(long j2) {
        AppMethodBeat.i(203220);
        int delete = this.iFy.delete("SnsWsFoldGroupDetail", "groupId=?", new String[]{String.valueOf(j2)});
        Log.d("MicroMsg.SnsWsFoldDetailStorage", "removeByGroupId " + j2 + " res " + delete);
        this.EmT.remove(Long.valueOf(j2));
        if (delete > 0) {
            AppMethodBeat.o(203220);
            return true;
        }
        AppMethodBeat.o(203220);
        return false;
    }
}
