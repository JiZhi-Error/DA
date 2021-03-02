package com.tencent.tbs.one.impl.common;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import java.util.HashMap;
import java.util.Map;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static a f2579a;

    public interface a {
        void a(String str, int i2, Map map);
    }

    public static void a(int i2, String str, int i3, int i4, String str2, Throwable th) {
        AppMethodBeat.i(174257);
        f.a("Reporting error: [%d] %s", Integer.valueOf(i4), str2, th);
        HashMap hashMap = new HashMap();
        hashMap.put("DEPS_VERSION_CODE", Integer.valueOf(i2));
        hashMap.put("COMPONENT_NAME", str);
        hashMap.put("COMPONENT_VERSION_CODE", Integer.valueOf(i3));
        hashMap.put(ShareConstants.DESCRIPTION, str2);
        hashMap.put("THROWABLE", th);
        a("TBSOneError", i4, hashMap);
        AppMethodBeat.o(174257);
    }

    public static void a(String str, int i2, Map map) {
        AppMethodBeat.i(174256);
        if (f2579a != null) {
            f2579a.a(str, i2, map);
        }
        AppMethodBeat.o(174256);
    }
}
