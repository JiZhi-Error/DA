package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.mm.sdk.storage.MStorageEx;

public interface IStorageEx {
    void add(MStorageEx.IOnStorageChange iOnStorageChange);

    void add(MStorageEx.IOnStorageChange iOnStorageChange, Looper looper);

    void add(MStorageEx.IOnStorageChange iOnStorageChange, a aVar);

    void doNotify(int i2, MStorageEx mStorageEx, Object obj);

    void remove(MStorageEx.IOnStorageChange iOnStorageChange);
}
