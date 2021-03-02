package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "T", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "()V", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "plugin-appbrand-integration_release"})
public abstract class a<T> extends com.tencent.luggage.sdk.e.a<T> {
    public void b(QualitySession qualitySession) {
        p.h(qualitySession, "qualitySession");
    }
}
