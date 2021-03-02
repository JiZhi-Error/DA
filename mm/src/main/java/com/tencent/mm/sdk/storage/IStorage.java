package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.mm.sdk.storage.MStorage;

public interface IStorage {
    void add(a aVar, MStorage.IOnStorageChange iOnStorageChange);

    void add(MStorage.IOnStorageChange iOnStorageChange);

    void add(MStorage.IOnStorageChange iOnStorageChange, Looper looper);

    void add(String str, MStorage.IOnStorageChange iOnStorageChange);

    void addLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded);

    void doNotify();

    void doNotify(String str);

    void doNotify(String str, int i2, Object obj);

    void lock();

    int lockCount();

    void remove(MStorage.IOnStorageChange iOnStorageChange);

    void removeLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded);

    void unlock();
}
