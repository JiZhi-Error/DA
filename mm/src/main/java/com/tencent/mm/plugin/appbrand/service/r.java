package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

@e(c.class)
public interface r extends com.tencent.mm.kernel.c.a {

    public interface a {
        void bNR();

        void bNS();
    }

    void a(Context context, g gVar);

    void a(Context context, String str, int i2, String str2, AppBrandStatObject appBrandStatObject, String str3, String str4);

    @Deprecated
    void a(Context context, String str, String str2, int i2, int i3, String str3, AppBrandStatObject appBrandStatObject);

    void a(Context context, String str, String str2, int i2, int i3, String str3, AppBrandStatObject appBrandStatObject, String str4);

    void a(Context context, String str, String str2, String str3, int i2, a aVar);

    void a(Context context, String str, String str2, String str3, String str4, int i2, int i3);

    void a(Context context, String str, String str2, boolean z, k.b bVar, Bundle bundle);

    void a(i iVar);

    void b(Context context, String str, String str2, String str3, int i2, String str4, int i3);

    void b(Context context, String str, String str2, boolean z, k.b bVar, Bundle bundle);

    void b(g gVar, f fVar);

    boolean bW(String str, int i2);

    void ej(String str, String str2);
}
