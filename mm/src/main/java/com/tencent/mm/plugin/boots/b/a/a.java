package com.tencent.mm.plugin.boots.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class a extends MAutoStorage<com.tencent.mm.plugin.boots.a.a> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.boots.a.a.info, "ActiveInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(117376);
        AppMethodBeat.o(117376);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, com.tencent.mm.plugin.boots.a.a.info, "ActiveInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.storagebase.g.a
    public final String getTableName() {
        return "ActiveInfo";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int CO(int r12) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.boots.b.a.a.CO(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.boots.a.a CP(int r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            r10 = 117374(0x1ca7e, float:1.64476E-40)
            r8 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r10)
            com.tencent.mm.plugin.boots.a.a r9 = new com.tencent.mm.plugin.boots.a.a
            r9.<init>()
            java.lang.String r3 = "key =?"
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r0 = java.lang.String.valueOf(r12)
            r4[r1] = r0
            com.tencent.mm.sdk.storage.ISQLiteDatabase r0 = r11.db     // Catch:{ Exception -> 0x003a, all -> 0x0055 }
            java.lang.String r1 = "ActiveInfo"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x003a, all -> 0x0055 }
            if (r1 == 0) goto L_0x0031
            boolean r0 = r1.moveToFirst()     // Catch:{ Exception -> 0x0062 }
            if (r0 == 0) goto L_0x0031
            r9.convertFrom(r1)     // Catch:{ Exception -> 0x0062 }
        L_0x0031:
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            return r9
        L_0x003a:
            r0 = move-exception
            r1 = r8
        L_0x003c:
            java.lang.String r2 = "MicroMsg.Tinker.ActiveInfoStorage"
            java.lang.String r3 = "getActiveInfoByKey %s failed."
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0060 }
            r5 = 0
            java.lang.String r6 = java.lang.Integer.toHexString(r12)     // Catch:{ all -> 0x0060 }
            r4[r5] = r6     // Catch:{ all -> 0x0060 }
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r2, r0, r3, r4)     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0036
            r1.close()
            goto L_0x0036
        L_0x0055:
            r0 = move-exception
            r1 = r8
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            r1.close()
        L_0x005c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            throw r0
        L_0x0060:
            r0 = move-exception
            goto L_0x0057
        L_0x0062:
            r0 = move-exception
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.boots.b.a.a.CP(int):com.tencent.mm.plugin.boots.a.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.boots.a.a> ckR() {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.boots.b.a.a.ckR():java.util.List");
    }
}
