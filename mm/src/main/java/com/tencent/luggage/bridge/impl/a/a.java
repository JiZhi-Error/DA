package com.tencent.luggage.bridge.impl.a;

import com.tencent.mm.plugin.appbrand.f.a;
import java.util.Map;

public abstract class a implements a.AbstractC0580a {
    public boolean equals(Object obj) {
        if (!(obj instanceof a.AbstractC0580a)) {
            return false;
        }
        if (Lb().equalsIgnoreCase(((a.AbstractC0580a) obj).Lb())) {
            return true;
        }
        return super.equals(obj);
    }

    public void a(String str, a.c cVar) {
        a(str, null, cVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public void a(String str, Map<String, String> map, a.c cVar) {
        a(str, cVar);
    }
}
