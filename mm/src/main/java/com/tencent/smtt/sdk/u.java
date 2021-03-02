package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class u {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2133a = null;

    public u(DexLoader dexLoader) {
        this.f2133a = dexLoader;
    }

    public void a(Context context, String str) {
        Object newInstance;
        AppMethodBeat.i(188413);
        if (!(this.f2133a == null || (newInstance = this.f2133a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null)) {
            this.f2133a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
        }
        AppMethodBeat.o(188413);
    }

    public String a(Context context) {
        Object newInstance;
        Object invokeMethod;
        AppMethodBeat.i(188414);
        if (this.f2133a == null || (newInstance = this.f2133a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null || (invokeMethod = this.f2133a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context)) == null) {
            AppMethodBeat.o(188414);
            return "";
        }
        String valueOf = String.valueOf(invokeMethod);
        AppMethodBeat.o(188414);
        return valueOf;
    }
}
