package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class d extends MAutoStorage<c> {
    public static final String[] INDEX_CREATE = new String[0];
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "ExptItem")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(122469);
        AppMethodBeat.o(122469);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "ExptItem", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.expt.h.c HD(int r11) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.i.d.HD(int):com.tencent.mm.plugin.expt.h.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.expt.h.c> cSc() {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.i.d.cSc():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.Integer> cSd() {
        /*
            r8 = this;
            r3 = 0
            r7 = 122463(0x1de5f, float:1.71607E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            java.lang.String r0 = "select exptId from ExptItem ORDER BY exptId ASC"
            com.tencent.mm.sdk.storage.ISQLiteDatabase r1 = r8.db     // Catch:{ Exception -> 0x005c, all -> 0x004f }
            r2 = 0
            android.database.Cursor r2 = r1.rawQuery(r0, r2)     // Catch:{ Exception -> 0x005c, all -> 0x004f }
            if (r2 == 0) goto L_0x0048
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0060 }
            r0.<init>()     // Catch:{ Exception -> 0x0060 }
        L_0x0018:
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x002b }
            if (r1 == 0) goto L_0x0049
            r1 = 0
            int r1 = r2.getInt(r1)     // Catch:{ Exception -> 0x002b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x002b }
            r0.add(r1)     // Catch:{ Exception -> 0x002b }
            goto L_0x0018
        L_0x002b:
            r1 = move-exception
        L_0x002c:
            java.lang.String r3 = "MicroMsg.ExptStorage"
            java.lang.String r4 = "get all expt id error[%s]"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x005a }
            r6 = 0
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005a }
            r5[r6] = r1     // Catch:{ all -> 0x005a }
            com.tencent.mm.sdk.platformtools.Log.e(r3, r4, r5)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0044
            r2.close()
        L_0x0044:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return r0
        L_0x0048:
            r0 = r3
        L_0x0049:
            if (r2 == 0) goto L_0x0044
            r2.close()
            goto L_0x0044
        L_0x004f:
            r0 = move-exception
            r2 = r3
        L_0x0051:
            if (r2 == 0) goto L_0x0056
            r2.close()
        L_0x0056:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            throw r0
        L_0x005a:
            r0 = move-exception
            goto L_0x0051
        L_0x005c:
            r1 = move-exception
            r2 = r3
            r0 = r3
            goto L_0x002c
        L_0x0060:
            r1 = move-exception
            r0 = r3
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.i.d.cSd():java.util.ArrayList");
    }

    private boolean HE(int i2) {
        int i3;
        AppMethodBeat.i(122464);
        try {
            i3 = this.db.delete("ExptItem", "exptId=?", new String[]{String.valueOf(i2)});
        } catch (Exception e2) {
            Log.e("MicroMsg.ExptStorage", "delete expt by id [%s]", e2.toString());
            i3 = 0;
        }
        if (i3 > 0) {
            AppMethodBeat.o(122464);
            return true;
        }
        AppMethodBeat.o(122464);
        return false;
    }

    private boolean a(c cVar) {
        boolean z;
        AppMethodBeat.i(122465);
        if (cVar == null) {
            AppMethodBeat.o(122465);
            return false;
        }
        try {
            z = super.replace(cVar);
        } catch (Exception e2) {
            Log.e("MicroMsg.ExptStorage", "replace expt error [%s]", e2.toString());
            z = false;
        }
        Log.d("MicroMsg.ExptStorage", "replace expt ret[%b] item[%s]", Boolean.valueOf(z), cVar.toString());
        AppMethodBeat.o(122465);
        return z;
    }

    public final List<c> dB(List<c> list) {
        h hVar;
        long j2 = -1;
        AppMethodBeat.i(122466);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(122466);
            return null;
        }
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(j2);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            LinkedList linkedList = new LinkedList();
            for (c cVar : list) {
                if (a(cVar)) {
                    linkedList.add(cVar);
                }
            }
            return linkedList;
        } finally {
            if (hVar != null) {
                hVar.endTransaction(j2);
            }
            AppMethodBeat.o(122466);
        }
    }

    public final int dv(List<Integer> list) {
        h hVar;
        int i2;
        long j2 = -1;
        int i3 = 0;
        AppMethodBeat.i(122467);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(122467);
        } else {
            if (this.db instanceof h) {
                h hVar2 = (h) this.db;
                j2 = hVar2.beginTransaction(j2);
                hVar = hVar2;
            } else {
                hVar = null;
            }
            try {
                for (Integer num : list) {
                    if (HE(num.intValue())) {
                        i2 = i3 + 1;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
            } finally {
                if (hVar != null) {
                    hVar.endTransaction(j2);
                }
                AppMethodBeat.o(122467);
            }
        }
        return i3;
    }

    public final int cRZ() {
        int i2 = 0;
        AppMethodBeat.i(122468);
        try {
            i2 = this.db.delete("ExptItem", null, null);
        } catch (Exception e2) {
            Log.e("MicroMsg.ExptStorage", "delete all expt error[%s]", e2.toString());
        }
        AppMethodBeat.o(122468);
        return i2;
    }
}
