package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.e;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class f implements e {
    private d<String, Integer> ial = new d<>(10);

    @Override // com.tencent.mm.loader.d.e
    public final synchronized boolean b(a<?> aVar) {
        boolean z;
        if (this.ial.check(aVar.toString())) {
            int intValue = this.ial.get(aVar.toString()).intValue();
            this.ial.put(aVar.toString(), Integer.valueOf(intValue + 1));
            if (intValue >= 50) {
                if (intValue == 50 || intValue % 500 == 0) {
                    Log.i("MicroMsg.Loader.DefaultImageRetryDownloadListener", "Url %s retry over time %d current time:%d, then stop retry download", aVar, 50, Integer.valueOf(intValue));
                }
                z = false;
            }
            z = true;
        } else {
            this.ial.put(aVar.toString(), 1);
            z = true;
        }
        return z;
    }
}
