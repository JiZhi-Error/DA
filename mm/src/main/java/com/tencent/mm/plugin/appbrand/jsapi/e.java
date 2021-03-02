package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.a.a;

public abstract class e {
    private String lxk;

    public e() {
        Assert.assertTrue("Must declare NAME in subclasses", true);
    }

    public final String getName() {
        if (Util.isNullOrNil(this.lxk)) {
            try {
                this.lxk = (String) a.bF(getClass()).bvr("NAME").object;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", Util.stackTraceToString(e2));
            }
        }
        return this.lxk;
    }
}
