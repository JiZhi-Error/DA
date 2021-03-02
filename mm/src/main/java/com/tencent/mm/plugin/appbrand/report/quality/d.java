package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.g.b.a.mo;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebView;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.xwalk.core.XWalkEnvironment;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006JB\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J$\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010%J\u0016\u0010&\u001a\u00020\u0004*\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u000bH\u0002¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt;", "", "()V", "pagecontainerInitReport", "", "pagecontainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "report15815MainContextLibInject", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "name", "", "sourceLength", "", StateEvent.ProcessResult.SUCCEED, "", "startTimeMs", "", "endTimeMs", "extraParams", "reportAllProcessRuntimeDistribution", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "reportCgiSpeed", "appId", "userName", "weAppQualityCGISpeedStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityCGISpeedStruct;", "servicePreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityAppServiceUSageStruct;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "staticWebViewKernelVersionForQualityReport", "webviewPreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityWebviewUsageStruct;", "webviewTypeForQualityReport", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "DEBUG_ASSERT", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "message", "IPC_getProcessAliveRuntimeCount", "plugin-appbrand-integration_release"})
public class d {
    public static void a(c cVar, String str, int i2, long j2, long j3, Object obj) {
        String str2;
        Object obj2;
        int i3;
        String bvb;
        AppMethodBeat.i(175214);
        p.h(cVar, "service");
        ICommLibReader bqZ = cVar.bqZ();
        if (bqZ == null || (bvb = bqZ.bvb()) == null) {
            str2 = "invalid";
        } else {
            str2 = bvb;
        }
        p.g(str2, "service.libReader?.versionName() ?: \"invalid\"");
        if (!(obj instanceof m.c)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        m.c cVar2 = (m.c) obj2;
        Log.i("MicroMsg.AppBrandQualitySystemKVProtocol", "Inject MainContextLibScript[" + str + "] Succeed wx.version = " + str2 + ", appId = " + cVar.getAppId());
        if (cVar.bsW() || cVar.isRunning()) {
            mj vZ = b.bUZ().l(cVar).zy(str).vZ((long) i2);
            if (cVar2 == null || cVar2.codeCacheStatus < 0 || cVar2.codeCacheStatus >= v.mNV.length) {
                i3 = 4;
            } else {
                i3 = v.mNV[cVar2.codeCacheStatus];
            }
            mj wd = vZ.wa((long) i3).wb(cVar.Mj() ? 1 : 0).wc(cVar2 != null ? cVar2.flatJSCompileCost : 0).wd((long) (cVar2 != null ? cVar2.dqm : 0));
            if (cVar2 != null) {
                j2 = cVar2.dqk;
            }
            wd.vX(j2);
            if (cVar2 != null) {
                j3 = cVar2.dql;
            }
            wd.vY(j3);
            wd.vW(wd.aiW() - wd.aiV());
            wd.zA(V8.getV8Version());
            wd.bfK();
        }
        AppMethodBeat.o(175214);
    }

    public static long z(ag agVar) {
        int i2;
        AppMethodBeat.i(51044);
        am bRI = agVar != null ? agVar.bRI() : null;
        if (bRI != null) {
            if (bRI.isSysKernel()) {
                i2 = 4;
            } else if (bRI.getIsX5Kernel()) {
                i2 = 2;
            } else if (bRI.isXWalkKernel()) {
                i2 = 3;
            }
            long j2 = (long) i2;
            AppMethodBeat.o(51044);
            return j2;
        }
        i2 = -1;
        long j22 = (long) i2;
        AppMethodBeat.o(51044);
        return j22;
    }

    public static long bVa() {
        int availableVersion;
        AppMethodBeat.i(51045);
        try {
            WebView.c curWebType = WebView.getCurWebType();
            if (curWebType != null) {
                switch (e.haE[curWebType.ordinal()]) {
                    case 1:
                        break;
                    case 2:
                        availableVersion = XWalkEnvironment.safeGetChromiunVersion();
                        break;
                    case 3:
                        availableVersion = WebView.getInstalledTbsCoreVersion(MMApplicationContext.getContext());
                        break;
                    case 4:
                        availableVersion = XWalkEnvironment.getAvailableVersion();
                        break;
                    default:
                        kotlin.m mVar = new kotlin.m();
                        AppMethodBeat.o(51045);
                        throw mVar;
                }
                long j2 = (long) availableVersion;
                AppMethodBeat.o(51045);
                return j2;
            }
            availableVersion = 0;
            long j22 = (long) availableVersion;
            AppMethodBeat.o(51045);
            return j22;
        } catch (Throwable th) {
            AppMethodBeat.o(51045);
            return -1;
        }
    }

    public static void a(QualitySessionRuntime qualitySessionRuntime, String str) {
        AppMethodBeat.i(51046);
        if (qualitySessionRuntime != null || !BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(51046);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        AppMethodBeat.o(51046);
        throw illegalArgumentException;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandInitConfigWC kFH;
        final /* synthetic */ QualitySession nKA;
        final /* synthetic */ int nKz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i2, QualitySession qualitySession, AppBrandInitConfigWC appBrandInitConfigWC) {
            super(0);
            this.nKz = i2;
            this.nKA = qualitySession;
            this.kFH = appBrandInitConfigWC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(51042);
            LinkedList linkedList = new LinkedList();
            String[] strArr = g.hrf;
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str = MMApplicationContext.getPackageName() + strArr[i4];
                if (p.j(MMApplicationContext.getProcessName(), str)) {
                    i2 = this.nKz;
                } else if (MMApplicationContext.isProcessExist(str)) {
                    IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a(str, IPCVoid.hnE, a.class);
                    i2 = iPCInteger != null ? iPCInteger.value : 0;
                } else {
                    i2 = -1;
                }
                linkedList.addLast(Integer.valueOf(i2));
            }
            mo moVar = new mo();
            moVar.zP(this.nKA.kEY);
            moVar.zQ(this.nKA.appId);
            moVar.wt((long) this.nKA.nLk);
            moVar.a(mo.a.mz(this.nKA.nJE));
            moVar.wu((long) this.nKA.apptype);
            moVar.wv((long) this.nKA.scene);
            ArrayList arrayList = new ArrayList();
            for (Object obj : linkedList) {
                if (((Number) obj).intValue() >= 0) {
                    arrayList.add(obj);
                }
            }
            long size = (long) arrayList.size();
            if (this.kFH.ldU) {
                i3 = 1;
            }
            moVar.ww(size - ((long) i3));
            moVar.wx((long) this.nKz);
            moVar.zR(org.apache.commons.b.g.a(linkedList, "_"));
            moVar.wy(MMApplicationContext.isProcessExist(new StringBuilder().append(MMApplicationContext.getPackageName()).append(":toolsmp").toString()) ? 1 : 0);
            moVar.bfK();
            x xVar = x.SXb;
            AppMethodBeat.o(51042);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt$IPC_getProcessAliveRuntimeCount;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
    static final class a implements k<IPCVoid, IPCInteger> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCInteger invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(51040);
            IPCInteger iPCInteger = new IPCInteger(com.tencent.mm.plugin.appbrand.a.bqV());
            AppMethodBeat.o(51040);
            return iPCInteger;
        }
    }
}
