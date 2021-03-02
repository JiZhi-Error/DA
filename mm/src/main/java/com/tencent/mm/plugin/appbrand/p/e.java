package com.tencent.mm.plugin.appbrand.p;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public interface e {

    public interface a {
        void YR(String str);

        void a(c cVar);
    }

    public interface b extends a {
        void a(android.arch.a.c.a<AppBrandRuntime, Boolean> aVar);
    }

    public static abstract class c {
        public static volatile c ngP = null;

        public abstract e j(AppBrandRuntime appBrandRuntime, String str);
    }

    void a(a aVar);

    void start();
}
