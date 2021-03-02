package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static Set<String> njT;

    static {
        AppMethodBeat.i(47770);
        HashSet hashSet = new HashSet();
        njT = hashSet;
        hashSet.add(MD5Util.getMD5String("wx9a3998a6d8b89d42"));
        AppMethodBeat.o(47770);
    }

    public static boolean adj(String str) {
        AppMethodBeat.i(47769);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(47769);
            return true;
        }
        boolean contains = njT.contains(MD5Util.getMD5String(str));
        AppMethodBeat.o(47769);
        return contains;
    }
}
