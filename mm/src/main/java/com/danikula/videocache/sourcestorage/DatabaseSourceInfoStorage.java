package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.Preconditions;
import com.danikula.videocache.SourceInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    private static final String[] ALL_COLUMNS = {COLUMN_ID, "url", COLUMN_LENGTH, COLUMN_MIME};
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_MIME = "mime";
    private static final String COLUMN_URL = "url";
    private static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final String TABLE = "SourceInfo";

    DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        AppMethodBeat.i(183630);
        Preconditions.checkNotNull(context);
        AppMethodBeat.o(183630);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(183631);
        Preconditions.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(CREATE_SQL);
        AppMethodBeat.o(183631);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        AppMethodBeat.i(183632);
        IllegalStateException illegalStateException = new IllegalStateException("Should not be called. There is no any migration");
        AppMethodBeat.o(183632);
        throw illegalStateException;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e  */
    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.danikula.videocache.SourceInfo get(java.lang.String r11) {
        /*
            r10 = this;
            r9 = 183633(0x2cd51, float:2.57325E-40)
            r8 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r9)
            com.danikula.videocache.Preconditions.checkNotNull(r11)
            android.database.sqlite.SQLiteDatabase r0 = r10.getReadableDatabase()     // Catch:{ all -> 0x003a }
            java.lang.String r1 = "SourceInfo"
            java.lang.String[] r2 = com.danikula.videocache.sourcestorage.DatabaseSourceInfoStorage.ALL_COLUMNS     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "url=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x003a }
            r5 = 0
            r4[r5] = r11     // Catch:{ all -> 0x003a }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x002b
            boolean r0 = r1.moveToFirst()     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0035
        L_0x002b:
            r0 = r8
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
            return r0
        L_0x0035:
            com.danikula.videocache.SourceInfo r0 = r10.convert(r1)
            goto L_0x002c
        L_0x003a:
            r0 = move-exception
        L_0x003b:
            if (r8 == 0) goto L_0x0040
            r8.close()
        L_0x0040:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
            throw r0
        L_0x0044:
            r0 = move-exception
            r8 = r1
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.sourcestorage.DatabaseSourceInfoStorage.get(java.lang.String):com.danikula.videocache.SourceInfo");
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
        AppMethodBeat.i(183634);
        Preconditions.checkAllNotNull(str, sourceInfo);
        boolean z = get(str) != null;
        ContentValues convert = convert(sourceInfo);
        if (z) {
            getWritableDatabase().update(TABLE, convert, "url=?", new String[]{str});
            AppMethodBeat.o(183634);
            return;
        }
        getWritableDatabase().insert(TABLE, null, convert);
        AppMethodBeat.o(183634);
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void release() {
        AppMethodBeat.i(223216);
        close();
        AppMethodBeat.o(223216);
    }

    private SourceInfo convert(Cursor cursor) {
        AppMethodBeat.i(223217);
        SourceInfo sourceInfo = new SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MIME)));
        AppMethodBeat.o(223217);
        return sourceInfo;
    }

    private ContentValues convert(SourceInfo sourceInfo) {
        AppMethodBeat.i(223218);
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.url);
        contentValues.put(COLUMN_LENGTH, Long.valueOf(sourceInfo.length));
        contentValues.put(COLUMN_MIME, sourceInfo.mime);
        AppMethodBeat.o(223218);
        return contentValues;
    }
}
