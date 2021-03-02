package com.tencent.mm.plugin.i.a;

import com.tencent.mm.sdk.storage.MStorage;
import java.util.List;

public interface m extends com.tencent.mm.kernel.c.a {

    public interface a {
        void c(ah ahVar);
    }

    public interface b {
        void er(List<ah> list);
    }

    public interface c {
        void yL(int i2);
    }

    int a(String str, c cVar);

    void a(String str, a aVar);

    void a(String str, Boolean bool);

    void a(String str, Long l, Long l2, a aVar);

    void a(String str, String str2, a aVar);

    ah ava(String str);

    ah avb(String str);

    boolean avc(String str);

    void dqf();

    void l(MStorage.IOnStorageChange iOnStorageChange);

    void m(MStorage.IOnStorageChange iOnStorageChange);
}
