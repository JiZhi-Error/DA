package com.tencent.mm.plugin.ai.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.text.SimpleDateFormat;

public final class f extends MAutoStorage<e> {
    public static final String[] INDEX_CREATE = new String[0];
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "WechatAppHistory")};
    private SimpleDateFormat kxO = null;
    private r.a kxP;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(e eVar) {
        AppMethodBeat.i(238955);
        boolean insertNotify = super.insertNotify(eVar, false);
        AppMethodBeat.o(238955);
        return insertNotify;
    }

    static {
        AppMethodBeat.i(238956);
        AppMethodBeat.o(238956);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.tencent.mm.platformtools.r.a r8) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ai.f.f.<init>(com.tencent.mm.platformtools.r$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        r11.kxP.endTransaction(r4);
        com.tencent.matrix.trace.core.AppMethodBeat.o(238952);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r4 
      PHI: (r4v1 long) = (r4v0 long), (r4v6 long), (r4v6 long) binds: [B:4:0x0018, B:5:?, B:7:0x002b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:4:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int bb(java.util.List<com.tencent.mm.plugin.ai.f.e> r12) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ai.f.f.bb(java.util.List):int");
    }

    public final SimpleDateFormat bqD() {
        AppMethodBeat.i(238953);
        if (this.kxO == null) {
            this.kxO = new SimpleDateFormat("yyyyMMdd");
        }
        SimpleDateFormat simpleDateFormat = this.kxO;
        AppMethodBeat.o(238953);
        return simpleDateFormat;
    }

    public final long TO(String str) {
        Cursor cursor = null;
        AppMethodBeat.i(238954);
        long j2 = 0;
        try {
            Cursor rawQuery = this.kxP.rawQuery(str, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.WechatDurationHistoryStorage", "do sql error[%s] sql[%s]", e2.toString(), str);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(238954);
            throw th;
        }
        AppMethodBeat.o(238954);
        return j2;
    }
}
