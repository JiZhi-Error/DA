package com.tencent.mm.sdk.storage;

public interface ISQLiteDatabaseEx extends ISQLiteDatabase {
    long beginTransaction(long j2);

    void close();

    int endTransaction(long j2);
}
