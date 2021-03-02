package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(c.class)
public interface ah extends a, IStorage {
    boolean bi(String str, int i2);

    List<LocalUsageInfo> dP(int i2, int i3);

    List<LocalUsageInfo> vW(int i2);
}
