package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import android.annotation.TargetApi;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(5)
public abstract class a implements c {
    private Map<String, Object> mFA = new ConcurrentHashMap();

    /* access modifiers changed from: protected */
    public void S(String str, int i2, int i3) {
        Iterator<Object> it = this.mFA.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
