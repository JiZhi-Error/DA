package com.tencent.mm.storagebase.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.storagebase.a.f;
import java.util.HashMap;

public interface d<T> extends Cursor {
    void AO(boolean z);

    void a(f.a aVar);

    boolean a(Object obj, a aVar);

    void akA(int i2);

    boolean aky(int i2);

    a akz(int i2);

    boolean ed(Object obj);

    a ee(Object obj);

    SparseArray<T>[] gFv();

    HashMap<Object, T> gFw();

    boolean gFx();
}
