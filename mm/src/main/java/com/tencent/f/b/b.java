package com.tencent.f.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.f.b.a;
import com.tencent.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class b extends SQLiteOpenHelper implements d {
    private SQLiteDatabase RTB;

    public b(Context context) {
        super(context, "Scheduler.db", (SQLiteDatabase.CursorFactory) null, 1);
        AppMethodBeat.i(183214);
        try {
            this.RTB = getWritableDatabase();
            AppMethodBeat.o(183214);
        } catch (Exception e2) {
            d.RSS.e("ExperienceStorage", "%s", e2.toString());
            AppMethodBeat.o(183214);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(183215);
        if (sQLiteDatabase == null) {
            AppMethodBeat.o(183215);
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DisposedTask(_ID INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL, taskName TEXT NOT NULL, threadTime LONG NOT NULL, time LONG NOT NULL, rate REAL NOT NULL, timestamp LONG NOT NULL, scheduler TEXT NOT NULL )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS timestampIndex ON DisposedTask(timestamp)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS taskNameIndex ON DisposedTask(taskName)");
        AppMethodBeat.o(183215);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    @Override // com.tencent.f.b.d
    public final void q(Collection<a.C0135a> collection) {
        AppMethodBeat.i(183216);
        if (this.RTB == null || collection.size() <= 0) {
            AppMethodBeat.o(183216);
            return;
        }
        try {
            this.RTB.beginTransaction();
            for (a.C0135a aVar : collection) {
                a.b bVar = new a.b(aVar.name, aVar.RTu, aVar.dwv, "");
                bVar.timestamp = System.currentTimeMillis();
                SQLiteDatabase sQLiteDatabase = this.RTB;
                ContentValues contentValues = new ContentValues();
                contentValues.put("taskName", bVar.name);
                contentValues.put("threadTime", Long.valueOf(bVar.AVw));
                contentValues.put("time", Long.valueOf(bVar.time));
                contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(bVar.timestamp));
                contentValues.put("rate", Float.valueOf(bVar.rate));
                contentValues.put("scheduler", bVar.RTA);
                sQLiteDatabase.insert("DisposedTask", null, contentValues);
            }
        } catch (Exception e2) {
            d.RSS.e("ExperienceStorage", "%s", e2.toString());
        } finally {
            this.RTB.setTransactionSuccessful();
            this.RTB.endTransaction();
            AppMethodBeat.o(183216);
        }
    }

    @Override // com.tencent.f.b.d
    public final void delete(long j2) {
        long currentTimeMillis;
        AppMethodBeat.i(183217);
        if (this.RTB == null) {
            AppMethodBeat.o(183217);
            return;
        }
        if (j2 <= 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = System.currentTimeMillis() + j2;
        }
        try {
            this.RTB.delete("DisposedTask", "timestamp<?", new String[]{String.valueOf(currentTimeMillis)});
            AppMethodBeat.o(183217);
        } catch (Exception e2) {
            d.RSS.e("ExperienceStorage", "%s", e2.toString());
            AppMethodBeat.o(183217);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ac  */
    @Override // com.tencent.f.b.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, com.tencent.f.b.a.C0135a> hml() {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.f.b.b.hml():java.util.Map");
    }

    public class a extends CursorWrapper {
        a(Cursor cursor) {
            super(cursor);
        }
    }
}
