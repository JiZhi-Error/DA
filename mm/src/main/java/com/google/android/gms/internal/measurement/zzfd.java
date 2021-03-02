package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
@VisibleForTesting
public final class zzfd extends SQLiteOpenHelper {
    private final /* synthetic */ zzfc zzaii;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfd(zzfc zzfc, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzaii = zzfc;
    }

    public final SQLiteDatabase getWritableDatabase() {
        AppMethodBeat.i(1352);
        try {
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            AppMethodBeat.o(1352);
            return writableDatabase;
        } catch (SQLiteDatabaseLockedException e2) {
            AppMethodBeat.o(1352);
            throw e2;
        } catch (SQLiteException e3) {
            this.zzaii.zzge().zzim().log("Opening the local database failed, dropping and recreating it");
            if (!this.zzaii.getContext().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zzaii.zzge().zzim().zzg("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                SQLiteDatabase writableDatabase2 = super.getWritableDatabase();
                AppMethodBeat.o(1352);
                return writableDatabase2;
            } catch (SQLiteException e4) {
                this.zzaii.zzge().zzim().zzg("Failed to open local database. Events will bypass local storage", e4);
                AppMethodBeat.o(1352);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(1354);
        zzei.zza(this.zzaii.zzge(), sQLiteDatabase);
        AppMethodBeat.o(1354);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r8) {
        /*
            r7 = this;
            r5 = 0
            r6 = 1353(0x549, float:1.896E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 15
            if (r0 >= r1) goto L_0x001c
            java.lang.String r0 = "PRAGMA journal_mode=memory"
            r1 = 0
            android.database.Cursor r1 = r8.rawQuery(r0, r1)     // Catch:{ all -> 0x0033 }
            r1.moveToFirst()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x001c
            r1.close()
        L_0x001c:
            com.google.android.gms.internal.measurement.zzfc r0 = r7.zzaii
            com.google.android.gms.internal.measurement.zzfg r0 = r0.zzge()
            java.lang.String r2 = "messages"
            java.lang.String r3 = "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)"
            java.lang.String r4 = "type,entry"
            r1 = r8
            com.google.android.gms.internal.measurement.zzei.zza(r0, r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0033:
            r0 = move-exception
        L_0x0034:
            if (r5 == 0) goto L_0x0039
            r5.close()
        L_0x0039:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r0
        L_0x003d:
            r0 = move-exception
            r5 = r1
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfd.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
