package com.tencent.mm.plugin.ai.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class d extends MAutoStorage<c> {
    public static final String[] INDEX_CREATE = new String[0];
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "FinderRedDotHistory")};
    private ISQLiteDatabase db;
    private SimpleDateFormat kxO = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(238947);
        boolean insertNotify = super.insertNotify(cVar, false);
        AppMethodBeat.o(238947);
        return insertNotify;
    }

    static {
        AppMethodBeat.i(238948);
        AppMethodBeat.o(238948);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(com.tencent.mm.sdk.storage.ISQLiteDatabase r8) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ai.f.d.<init>(com.tencent.mm.sdk.storage.ISQLiteDatabase):void");
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(238942);
        boolean insertNotify = super.insertNotify(cVar, false);
        AppMethodBeat.o(238942);
        return insertNotify;
    }

    public final int vu(int i2) {
        Cursor cursor = null;
        int i3 = 0;
        AppMethodBeat.i(238944);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!a(Util.nowMilliSecond(), pInt, pInt2)) {
            AppMethodBeat.o(238944);
        } else {
            try {
                Cursor rawQuery = this.db.rawQuery("SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( ds >= " + pInt.value + " AND ds <= " + pInt2.value + " )  AND hour = " + i2, null);
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    i3 = rawQuery.getInt(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", e2.toString());
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                AppMethodBeat.o(238944);
                throw th;
            }
            AppMethodBeat.o(238944);
        }
        return i3;
    }

    public final int vv(int i2) {
        Cursor cursor = null;
        int i3 = 0;
        AppMethodBeat.i(238945);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!a(Util.nowMilliSecond(), pInt, pInt2)) {
            AppMethodBeat.o(238945);
        } else {
            try {
                Cursor rawQuery = this.db.rawQuery("SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( ds >= " + pInt.value + " AND ds <= " + pInt2.value + " )  AND hour = " + i2 + " AND isGoToFinderUI = 1 ", null);
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    i3 = rawQuery.getInt(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", e2.toString());
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                AppMethodBeat.o(238945);
                throw th;
            }
            AppMethodBeat.o(238945);
        }
        return i3;
    }

    public final int vw(int i2) {
        Cursor cursor = null;
        int i3 = 0;
        AppMethodBeat.i(238946);
        long nowMilliSecond = Util.nowMilliSecond();
        try {
            Cursor rawQuery = this.db.rawQuery("SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( actionMs >= " + (nowMilliSecond - ((long) ((i2 * 60) * 1000))) + " AND actionMs <= " + nowMilliSecond + " ) ", null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                i3 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(238946);
            throw th;
        }
        AppMethodBeat.o(238946);
        return i3;
    }

    private boolean a(long j2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(238943);
        if (this.kxO == null) {
            this.kxO = new SimpleDateFormat("yyyyMMdd");
        }
        int i2 = Util.getInt(this.kxO.format(new Date(j2)), -1);
        if (i2 > 0) {
            pInt.value = i2 - 7;
            pInt2.value = i2 - 1;
            Log.i("MicroMsg.FinderRedDotHistoryStorage", "to sql date [%d, %d] day[%d] timeMs[%d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), 7, Long.valueOf(j2));
            AppMethodBeat.o(238943);
            return true;
        }
        AppMethodBeat.o(238943);
        return false;
    }
}
