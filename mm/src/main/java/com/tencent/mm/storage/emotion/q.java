package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class q extends MAutoStorage<p> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(p.info, "EmotionRewardTipInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105125);
        AppMethodBeat.o(105125);
    }

    public q(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, p.info, "EmotionRewardTipInfo");
    }

    private q(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.emotion.p gFq() {
        /*
            r8 = this;
            r1 = 0
            r2 = 0
            r7 = 105122(0x19aa2, float:1.47307E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            java.lang.String r0 = "select * from EmotionRewardTipInfo order by modifyTime desc limit 1 "
            java.lang.String[] r2 = new java.lang.String[r2]
            com.tencent.mm.sdk.storage.ISQLiteDatabase r3 = r8.db     // Catch:{ Exception -> 0x0037, all -> 0x0052 }
            r4 = 2
            android.database.Cursor r2 = r3.rawQuery(r0, r2, r4)     // Catch:{ Exception -> 0x0037, all -> 0x0052 }
            if (r2 == 0) goto L_0x002d
            boolean r0 = r2.moveToFirst()     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.storage.emotion.p r0 = new com.tencent.mm.storage.emotion.p     // Catch:{ Exception -> 0x005f }
            r0.<init>()     // Catch:{ Exception -> 0x005f }
            r0.convertFrom(r2)     // Catch:{ Exception -> 0x005f }
            if (r2 == 0) goto L_0x0029
            r2.close()
        L_0x0029:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
        L_0x002c:
            return r0
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.close()
        L_0x0032:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            r0 = r1
            goto L_0x002c
        L_0x0037:
            r0 = move-exception
            r2 = r1
        L_0x0039:
            java.lang.String r3 = "MicroMsg.emoji.EmotionRewardTipStorage"
            java.lang.String r4 = "getLastSendProductID failed. :%s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x005d }
            r6 = 0
            java.lang.String r0 = com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r0)     // Catch:{ all -> 0x005d }
            r5[r6] = r0     // Catch:{ all -> 0x005d }
            com.tencent.mm.sdk.platformtools.Log.e(r3, r4, r5)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0032
            r2.close()
            goto L_0x0032
        L_0x0052:
            r0 = move-exception
            r2 = r1
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.close()
        L_0x0059:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            throw r0
        L_0x005d:
            r0 = move-exception
            goto L_0x0054
        L_0x005f:
            r0 = move-exception
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.q.gFq():com.tencent.mm.storage.emotion.p");
    }

    public final boolean gU(String str, int i2) {
        AppMethodBeat.i(105123);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            AppMethodBeat.o(105123);
            return false;
        }
        boolean execSQL = this.db.execSQL("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i2 + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
        Log.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", Boolean.valueOf(execSQL));
        AppMethodBeat.o(105123);
        return execSQL;
    }

    public final boolean a(p pVar) {
        AppMethodBeat.i(105124);
        if (pVar == null) {
            Log.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            AppMethodBeat.o(105124);
            return false;
        }
        long replace = this.db.replace("EmotionRewardTipInfo", "prodcutID", pVar.convertTo());
        if (replace > 0) {
            Log.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            Log.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            AppMethodBeat.o(105124);
            return true;
        }
        AppMethodBeat.o(105124);
        return false;
    }
}
