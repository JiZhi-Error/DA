package com.tencent.mm.choosemsgfile.compat;

import com.tencent.mm.av.g;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.storage.ca;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void cs(int i2, int i3);

        void t(int i2, String str);
    }

    /* renamed from: com.tencent.mm.choosemsgfile.compat.b$b  reason: collision with other inner class name */
    public interface AbstractC0294b {
        void u(int i2, String str);
    }

    com.tencent.mm.vending.e.a a(long j2, String str, a aVar);

    String a(ca caVar, g gVar);

    void a(c cVar);

    void a(ca caVar, a aVar);

    boolean a(ca caVar, c cVar);

    boolean a(String str, ca caVar, AbstractC0294b bVar);

    boolean j(ca caVar);

    g k(ca caVar);

    String l(ca caVar);

    boolean m(ca caVar);

    c s(String str, long j2);
}
