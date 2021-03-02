package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;

@e(c.class)
public interface q extends com.tencent.mm.kernel.c.a {

    public interface a {
        void b(WxaAttributes wxaAttributes);
    }

    WxaAttributes Xk(String str);

    WxaAttributes Xl(String str);

    String Xm(String str);

    com.tencent.mm.vending.g.e<WxaAttributes> Xn(String str);

    void a(String str, a aVar);

    void b(String str, a aVar);

    void bq(List<String> list);

    void c(String str, a aVar);
}
