package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ln;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandFileOccupationReporter;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a {
    public static final C0662a lUE = new C0662a((byte) 0);

    static {
        AppMethodBeat.i(180476);
        AppMethodBeat.o(180476);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandFileOccupationReporter$Companion;", "", "()V", "TAG", "", "reportOccupation", "", "fileSystems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystem;", "appId", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.a$a  reason: collision with other inner class name */
    public static final class C0662a {
        private C0662a() {
        }

        public /* synthetic */ C0662a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.a$a$a  reason: collision with other inner class name */
        static final class C0663a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ String kPQ;
            final /* synthetic */ List lUF;
            final /* synthetic */ QualitySessionRuntime lUG;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0663a(List list, String str, QualitySessionRuntime qualitySessionRuntime) {
                super(0);
                this.lUF = list;
                this.kPQ = str;
                this.lUG = qualitySessionRuntime;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                ln lnVar;
                AppMethodBeat.i(180475);
                ArrayList<ln> arrayList = new ArrayList();
                for (o oVar : this.lUF) {
                    B b2 = oVar.second;
                    B b3 = b2;
                    if (b3 == null || n.aL(b3)) {
                        Log.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "reportOccupation: prefix = [%s] got a null path", oVar.first);
                        lnVar = null;
                    } else {
                        ln lnVar2 = new ln();
                        lnVar2.yT(this.kPQ);
                        AppBrandSysConfigWC TR = com.tencent.mm.plugin.appbrand.a.TR(this.kPQ);
                        if (TR != null) {
                            lnVar2.vb((long) TR.leE.pkgVersion);
                        } else {
                            lnVar2.vb((long) this.lUG.nLk);
                        }
                        lnVar2.a(ln.a.mb(this.lUG.nJE));
                        lnVar2.vc((long) this.lUG.apptype);
                        lnVar2.vd(kotlin.h.a.L(((double) com.tencent.mm.plugin.appbrand.appstorage.n.q(new com.tencent.mm.vfs.o((String) b2))) / 1024.0d));
                        lnVar2.yU(oVar.first);
                        lnVar = lnVar2;
                    }
                    if (lnVar != null) {
                        arrayList.add(lnVar);
                    }
                }
                for (ln lnVar3 : arrayList) {
                    if (!e.asList(new String[]{"tmp", "usr", "opendata", "ad"}).contains(lnVar3.aiS())) {
                        Log.d("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "reportOccupation: no need report prefix = [%s]", lnVar3.aiS());
                    } else {
                        Log.d("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "reportOccupation: (appId,prefix,occupation) = [%s,%s,%d]", lnVar3.getAppId(), lnVar3.aiS(), Long.valueOf(lnVar3.aiR()));
                        lnVar3.bfK();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(180475);
                return xVar;
            }
        }
    }
}
