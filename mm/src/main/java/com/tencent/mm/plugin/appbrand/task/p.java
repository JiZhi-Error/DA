package com.tencent.mm.plugin.appbrand.task;

import android.content.Context;
import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.z;

public interface p {

    public interface a {
        n a(String str, String str2, g gVar);

        void a(g gVar, z zVar, boolean z);

        void afk(String str);

        n b(String str, g gVar);

        void b(n nVar);
    }

    void Ue(String str);

    void a(g gVar, z zVar);

    void a(String str, AppBrandRemoteTaskController appBrandRemoteTaskController);

    void a(String str, g gVar);

    void a(String str, String str2, AppBrandRemoteTaskController appBrandRemoteTaskController);

    void afe(String str);

    Class aff(String str);

    Class afg(String str);

    boolean afi(String str);

    Pair<String, Integer> afj(String str);

    void bVX();

    int[] bVY();

    void cl(String str, int i2);

    boolean cn(String str, int i2);

    String co(String str, int i2);

    int d(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject);

    void e(z zVar);

    int g(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject);

    void onNetworkChange();

    void zn(int i2);
}
