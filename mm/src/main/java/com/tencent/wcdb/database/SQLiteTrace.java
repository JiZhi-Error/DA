package com.tencent.wcdb.database;

import java.util.List;

public interface SQLiteTrace {
    void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j2, boolean z);

    void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, long j2, boolean z, List<TraceInfo<String>> list, List<TraceInfo<StackTraceElement[]>> list2);

    void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase);

    void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i2, long j2);

    public static class TraceInfo<T> {
        public final T info;
        public final int tid;
        public final long time;

        TraceInfo(T t, long j2, int i2) {
            this.info = t;
            this.time = j2;
            this.tid = i2;
        }
    }
}
