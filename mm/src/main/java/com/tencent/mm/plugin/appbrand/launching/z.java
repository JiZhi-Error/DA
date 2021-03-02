package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public interface z extends aa {

    public interface a {
        void a(WxaPkgLoadProgress wxaPkgLoadProgress);
    }

    void a(a aVar);

    void a(b bVar);

    void a(QualitySession qualitySession);

    void prepareAsync();

    public static abstract class b {
        public void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        }
    }
}
