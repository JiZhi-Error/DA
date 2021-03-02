package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "()V", "reportAll", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class c extends b {
    public static final a mYA = new a((byte) 0);

    static {
        AppMethodBeat.i(228749);
        AppMethodBeat.o(228749);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC$Companion;", "", "()V", "TAG", "", "TASK_KEY_DOWNLOAD_INFO", "", "TASK_KEY_LAUNCH", "TASK_KEY_PRE_RETRIEVE_LAUNCH_PRAMS", "getLaunchTask", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "parallelTasksCollection", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "getPreGetPkgDownloadInfo", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void c(QualitySession qualitySession) {
        AppMethodBeat.i(228748);
        p.h(qualitySession, "qualitySession");
        for (Map.Entry<Integer, com.tencent.luggage.sdk.e.a<?>> entry : this.cCy.entrySet()) {
            com.tencent.luggage.sdk.e.a<?> value = entry.getValue();
            if (value.OZ()) {
                if (value == null) {
                    try {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.parallel.AppBrandBasePreFetchTaskWC<*>");
                        AppMethodBeat.o(228748);
                        throw tVar;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "reportAll:report #" + value.OY() + " task fail %s", e2.getMessage());
                    }
                } else {
                    ((a) value).b(qualitySession);
                }
            }
        }
        AppMethodBeat.o(228748);
    }

    public static final g a(b bVar) {
        AppMethodBeat.i(228750);
        p.h(bVar, "parallelTasksCollection");
        com.tencent.luggage.sdk.e.a<?> aVar = bVar.cCy.get(0);
        if (aVar == null) {
            aVar = null;
        } else if (aVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
            AppMethodBeat.o(228750);
            throw tVar;
        }
        if (aVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getLaunchTask: ret == null!");
            AppMethodBeat.o(228750);
            return null;
        }
        g gVar = (g) aVar;
        AppMethodBeat.o(228750);
        return gVar;
    }
}
