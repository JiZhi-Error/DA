package com.tencent.mm.plugin.gamelife.a;

import com.tencent.mm.sdk.storage.MStorage;
import java.util.List;
import java.util.Map;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void U(boolean z, boolean z2);
    }

    /* renamed from: com.tencent.mm.plugin.gamelife.a.b$b  reason: collision with other inner class name */
    public interface AbstractC1411b {
        void mM(boolean z);
    }

    public interface c {
        void aj(Map<String, a> map);
    }

    void a(String str, a aVar);

    void a(String str, c cVar);

    void a(String str, boolean z, boolean z2, AbstractC1411b bVar);

    void a(List<String> list, c cVar);

    a aAR(String str);

    void aAS(String str);

    void l(MStorage.IOnStorageChange iOnStorageChange);

    void m(MStorage.IOnStorageChange iOnStorageChange);
}
