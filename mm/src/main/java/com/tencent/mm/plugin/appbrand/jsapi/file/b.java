package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lo;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.file.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J6\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0012H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "appId", "", "kotlin.jvm.PlatformType", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "scrFile", "Lcom/tencent/mm/vfs/VFSFile;", "suffix", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"})
public final class b extends at {
    private final String appId;
    private final d lUH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(d dVar, d dVar2) {
        super(dVar, dVar2);
        o oVar;
        p.h(dVar, "rt");
        p.h(dVar2, "config");
        AppMethodBeat.i(50510);
        this.lUH = dVar2;
        this.appId = dVar.getAppId();
        bxv().addFirst(e.btJ());
        a.C0662a aVar = a.lUE;
        LinkedList<q> bxv = bxv();
        p.g(bxv, "orderedFileSystemList");
        String str = this.appId;
        p.g(str, "appId");
        p.h(bxv, "fileSystems");
        p.h(str, "appId");
        QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(str);
        if (aeU == null) {
            AppMethodBeat.o(50510);
            return;
        }
        p.g(aeU, "AppBrandQualitySystem.getSession(appId) ?: return");
        ArrayList arrayList = new ArrayList();
        for (T t : bxv) {
            if (t instanceof com.tencent.mm.plugin.appbrand.appstorage.o) {
                oVar = new o(t.kSO, t.getRootPath());
            } else if (t instanceof z) {
                String bxB = t.bxB();
                p.g(bxB, "fs.pathPrefix");
                oVar = new o(n.j(bxB, "wxfile://", "", false), t.getRootPath());
            } else {
                Log.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "unknown type: %s", t.getClass().getSimpleName());
                oVar = null;
            }
            if (oVar != null) {
                arrayList.add(oVar);
            }
        }
        com.tencent.mm.ac.d.i(new a.C0662a.C0663a(arrayList, str, aeU));
        AppMethodBeat.o(50510);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.v, com.tencent.mm.plugin.appbrand.jsapi.file.at
    public final m a(com.tencent.mm.vfs.o oVar, String str, boolean z, i<String> iVar) {
        long j2;
        QualitySessionRuntime aeU;
        AppMethodBeat.i(175167);
        if (oVar != null) {
            j2 = c.w(oVar);
        } else {
            j2 = -1;
        }
        m a2 = super.a(oVar, str, z, iVar);
        if (a2 == m.OK && (aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.appId)) != null) {
            lo a3 = c.a(aeU);
            a3.vg(j2);
            a3.bfK();
        }
        p.g(a2, "super.createTempFileFrom…}\n            }\n        }");
        AppMethodBeat.o(175167);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
    public static final class a implements r {
        @Override // com.tencent.mm.plugin.appbrand.appstorage.r
        public final void b(String str, com.tencent.mm.vfs.o oVar) {
            AppMethodBeat.i(175166);
            if (str == null) {
                AppMethodBeat.o(175166);
                return;
            }
            QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(str);
            if (aeU == null) {
                AppMethodBeat.o(175166);
                return;
            }
            lo a2 = c.a(aeU);
            a2.vg(c.w(oVar));
            a2.bfK();
            AppMethodBeat.o(175166);
        }
    }
}
