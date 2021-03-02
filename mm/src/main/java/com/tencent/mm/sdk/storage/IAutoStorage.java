package com.tencent.mm.sdk.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public interface IAutoStorage<T extends IAutoDBItem> {
    boolean delete(long j2);

    boolean delete(T t, boolean z, String... strArr);

    boolean delete(T t, String... strArr);

    boolean deleteNotify(long j2, boolean z);

    boolean execSQL(String str, String str2);

    boolean get(long j2, T t);

    boolean get(T t, String... strArr);

    Cursor getAll();

    int getCount();

    boolean insert(T t);

    boolean insertNotify(T t, boolean z);

    Cursor rawQuery(String str, String... strArr);

    boolean replace(T t);

    boolean update(long j2, T t);

    boolean update(long j2, T t, boolean z);

    boolean update(T t, String... strArr);

    boolean updateNotify(T t, boolean z, String... strArr);
}
