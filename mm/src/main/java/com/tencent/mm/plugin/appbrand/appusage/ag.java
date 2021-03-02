package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.sdk.storage.IStorage;
import java.util.List;

@e(c.class)
public interface ag extends com.tencent.mm.kernel.c.a, IStorage {
    List<LocalUsageInfo> a(int i2, a aVar);

    List<LocalUsageInfo> a(int i2, a aVar, int i3);

    boolean bf(String str, int i2);

    int bg(String str, int i2);

    boolean bh(String str, int i2);

    void bxG();

    int bxH();

    boolean g(List<LocalUsageInfo> list, int i2);

    int getCount();

    public enum a {
        DESC,
        ASC,
        UPATE_TIME_DESC;

        public static a valueOf(String str) {
            AppMethodBeat.i(153195);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(153195);
            return aVar;
        }

        static {
            AppMethodBeat.i(153196);
            AppMethodBeat.o(153196);
        }
    }
}
