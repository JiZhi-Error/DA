package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.sdk.SynchronizedPool;
import java.util.HashMap;
import java.util.Map;

public abstract class a<T> {
    private Map<String, SynchronizedPool> map = new HashMap();

    public abstract <T> T WE(String str);

    public final <T extends BaseDrawActionArg> T WC(String str) {
        T t = (T) ((BaseDrawActionArg) WD(str).acquire());
        if (t == null) {
            return WE(str);
        }
        return t;
    }

    public final void a(BaseDrawActionArg baseDrawActionArg) {
        if (baseDrawActionArg != null) {
            if (TextUtils.isEmpty(baseDrawActionArg.method)) {
                throw new IllegalStateException("method is empty " + baseDrawActionArg.toString());
            }
            WD(baseDrawActionArg.method).release(baseDrawActionArg);
        }
    }

    private SynchronizedPool WD(String str) {
        SynchronizedPool synchronizedPool = this.map.get(str);
        if (synchronizedPool != null) {
            return synchronizedPool;
        }
        SynchronizedPool synchronizedPool2 = new SynchronizedPool(500);
        this.map.put(str, synchronizedPool2);
        return synchronizedPool2;
    }
}
