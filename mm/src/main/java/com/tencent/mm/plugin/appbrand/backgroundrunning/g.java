package com.tencent.mm.plugin.appbrand.backgroundrunning;

import java.util.List;

public interface g extends com.tencent.mm.kernel.c.a {

    public interface a {
        void a(List<AppBrandBackgroundRunningApp> list, AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel, int i2);
    }

    void a(a aVar);

    void b(a aVar);

    List<AppBrandBackgroundRunningApp> byZ();

    void bza();

    void bzb();

    void c(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel);
}
