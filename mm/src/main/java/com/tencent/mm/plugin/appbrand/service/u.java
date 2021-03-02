package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.appcache.bd;

@e(c.class)
public interface u extends com.tencent.mm.kernel.c.a {

    public interface a {
        void onError(int i2, String str);
    }

    public interface b {
        void a(bd bdVar, String str);
    }

    void a(String str, int i2, b bVar, a aVar);

    void r(String str, String str2, int i2);
}
