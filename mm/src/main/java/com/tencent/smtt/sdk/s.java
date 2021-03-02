package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

/* access modifiers changed from: package-private */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2125a = null;

    /* renamed from: b  reason: collision with root package name */
    private Object f2126b = null;

    public s(DexLoader dexLoader) {
        this.f2125a = dexLoader;
    }

    public Object a(Context context, Object obj, Bundle bundle) {
        AppMethodBeat.i(188185);
        if (this.f2125a != null) {
            this.f2126b = this.f2125a.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[]{Context.class, Object.class, Bundle.class}, context, obj, bundle);
        }
        Object obj2 = this.f2126b;
        AppMethodBeat.o(188185);
        return obj2;
    }

    public void a() {
        AppMethodBeat.i(188186);
        if (this.f2125a != null) {
            this.f2125a.invokeMethod(this.f2126b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.o(188186);
    }

    public void b() {
        AppMethodBeat.i(188187);
        if (this.f2125a != null) {
            this.f2125a.invokeMethod(this.f2126b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.o(188187);
    }

    public void c() {
        AppMethodBeat.i(188188);
        if (this.f2125a != null) {
            this.f2125a.invokeMethod(this.f2126b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.o(188188);
    }

    public void a(boolean z) {
        AppMethodBeat.i(188189);
        if (this.f2125a != null) {
            this.f2125a.invokeMethod(this.f2126b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
        AppMethodBeat.o(188189);
    }

    public long d() {
        AppMethodBeat.i(188190);
        if (this.f2125a != null) {
            Object invokeMethod = this.f2125a.invokeMethod(this.f2126b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
            if (invokeMethod instanceof Long) {
                long longValue = ((Long) invokeMethod).longValue();
                AppMethodBeat.o(188190);
                return longValue;
            }
        }
        AppMethodBeat.o(188190);
        return 0;
    }

    public int e() {
        AppMethodBeat.i(188191);
        if (this.f2125a != null) {
            Object invokeMethod = this.f2125a.invokeMethod(this.f2126b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                int intValue = ((Integer) invokeMethod).intValue();
                AppMethodBeat.o(188191);
                return intValue;
            }
        }
        AppMethodBeat.o(188191);
        return 0;
    }

    public int f() {
        AppMethodBeat.i(188192);
        if (this.f2125a != null) {
            Object invokeMethod = this.f2125a.invokeMethod(this.f2126b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                int intValue = ((Integer) invokeMethod).intValue();
                AppMethodBeat.o(188192);
                return intValue;
            }
        }
        AppMethodBeat.o(188192);
        return 0;
    }
}
