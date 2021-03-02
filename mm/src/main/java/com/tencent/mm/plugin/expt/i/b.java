package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.List;

public final class b extends MAutoStorage<a> {
    public static final String[] INDEX_CREATE = new String[0];
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "ExptKeyMapId")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(122452);
        AppMethodBeat.o(122452);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "ExptKeyMapId", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int arf(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.i.b.arf(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.expt.i.a ark(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.i.b.ark(java.lang.String):com.tencent.mm.plugin.expt.i.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int dw(java.util.List<com.tencent.mm.plugin.expt.i.a> r13) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.i.b.dw(java.util.List):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int dx(java.util.List<com.tencent.mm.plugin.expt.i.a> r13) {
        /*
        // Method dump skipped, instructions count: 147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.i.b.dx(java.util.List):int");
    }

    public final int dy(List<Integer> list) {
        h hVar;
        int i2;
        AppMethodBeat.i(122450);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(122450);
            return 0;
        }
        int i3 = 0;
        long j2 = -1;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            for (Integer num : list) {
                if (this.db.delete("ExptKeyMapId", "exptId=?", new String[]{String.valueOf(num.intValue())}) > 0) {
                    i2 = i3 + 1;
                } else {
                    i2 = i3;
                }
                i3 = i2;
            }
            if (hVar != null) {
                hVar.endTransaction(j2);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", e2.toString(), 0);
            if (hVar != null) {
                hVar.endTransaction(j2);
            }
        } catch (Throwable th) {
            if (hVar != null) {
                hVar.endTransaction(j2);
            }
            AppMethodBeat.o(122450);
            throw th;
        }
        Log.i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", Integer.valueOf(list.size()), Integer.valueOf(i3));
        AppMethodBeat.o(122450);
        return i3;
    }

    public final int cRZ() {
        int i2 = 0;
        AppMethodBeat.i(122451);
        try {
            i2 = this.db.delete("ExptKeyMapId", null, null);
        } catch (Exception e2) {
            Log.e("MicroMsg.ExptKeyMapIdStorage", "delete all expt error[%s]", e2.toString());
        }
        AppMethodBeat.o(122451);
        return i2;
    }
}
