package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,BI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\u001dH\u0002J\u0012\u0010%\u001a\u00020\u001d2\b\b\u0001\u0010&\u001a\u00020\u0007H\u0016J\u0012\u0010%\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010(\u001a\u00020\u001d*\u00020\u001b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler$ICheckAppHandlerErrorPromptDelegate;", "Lcom/tencent/mm/plugin/appbrand/launching/ILaunchStep;", "appId", "", "versionType", "", "isGame", "", "enterPath", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(Ljava/lang/String;IZLjava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "canShowErrorPrompt", "isFromRemoteDebug", "()Z", "setFromRemoteDebug", "(Z)V", "preDownloadCalled", "call", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "callPreDownload", "", "onDownloadProgress", "progress", "postDownload", "preDownload", "setCanShowErrorPrompt", "can", "showDevPkgNoRecordPrompt", "toast", "resId", "error", "fillReadyPkgList", "pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Companion", "plugin-appbrand-integration_release"})
public class ae implements aa, w, w.a {
    @Deprecated
    public static final a mUZ = new a((byte) 0);
    private final String appId;
    private final boolean cuy;
    private final int iOo;
    private final String kHw;
    private final ICommLibReader leM;
    private WxaAttributes.WxaVersionInfo lgq;
    private final acc mSK;
    boolean mSa;
    private boolean mUW = true;
    private boolean mUX;
    private final QualitySession mUY;

    static {
        AppMethodBeat.i(180616);
        AppMethodBeat.o(180616);
    }

    public ae(String str, int i2, boolean z, String str2, WxaAttributes.WxaVersionInfo wxaVersionInfo, ICommLibReader iCommLibReader, QualitySession qualitySession, acc acc) {
        p.h(str, "appId");
        p.h(wxaVersionInfo, "versionInfo");
        p.h(qualitySession, "reportQualitySession");
        p.h(acc, "cgiCommRequestSource");
        AppMethodBeat.i(228691);
        this.appId = str;
        this.iOo = i2;
        this.cuy = z;
        this.kHw = str2;
        this.lgq = wxaVersionInfo;
        this.leM = iCommLibReader;
        this.mUY = qualitySession;
        this.mSK = acc;
        AppMethodBeat.o(228691);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public /* synthetic */ WxaPkgWrappingInfo call() {
        AppMethodBeat.i(180614);
        WxaPkgWrappingInfo bCi = bCi();
        AppMethodBeat.o(180614);
        return bCi;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.w.a
    public final void hX(boolean z) {
        this.mUW = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aa
    public final boolean bNh() {
        return this.mUW;
    }

    public final void acb(String str) {
        AppMethodBeat.i(180612);
        if (this.mUW) {
            ax.a(str, this);
            AppMethodBeat.o(180612);
            return;
        }
        Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "silent toast:error=" + str + ", stack=" + android.util.Log.getStackTraceString(new Throwable()));
        AppMethodBeat.o(180612);
    }

    private WxaPkgWrappingInfo bCi() {
        List ac;
        ArrayList arrayList;
        T t;
        WxaAttributes.WxaVersionInfo XM;
        WxaAttributes.WxaVersionModuleInfo wxaVersionModuleInfo = null;
        AppMethodBeat.i(180613);
        if (j.a.sE(this.iOo) && this.lgq.appVersion != 0) {
            String bU = ((t) n.W(t.class)).bU(this.appId, this.iOo);
            if (bU == null || (XM = ac.XM(bU)) == null) {
                WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) new b(this).invoke();
                AppMethodBeat.o(180613);
                return wxaPkgWrappingInfo;
            }
            this.lgq = XM;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo2 = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo2.pkgVersion = this.lgq.appVersion;
        wxaPkgWrappingInfo2.kNW = this.iOo;
        wxaPkgWrappingInfo2.md5 = this.lgq.lgS;
        wxaPkgWrappingInfo2.kOb = new WxaRuntimeModulePluginListMap();
        ac acVar = ac.mUH;
        WxaAttributes.WxaVersionInfo wxaVersionInfo = this.lgq;
        String str = this.appId;
        ac acVar2 = ac.mUH;
        Map<String, WxaAttributes.WxaWidgetInfo> a2 = ac.a(wxaVersionInfo, str, ac.a(this.appId, this.iOo, this.lgq.appVersion, this.cuy, this.leM));
        for (Map.Entry<String, WxaAttributes.WxaWidgetInfo> entry : a2.entrySet()) {
            String str2 = (String) o.e(entry);
            WxaAttributes.WxaWidgetInfo wxaWidgetInfo = (WxaAttributes.WxaWidgetInfo) o.f(entry);
            if (!p.j(ModulePkgInfo.MAIN_MODULE_NAME, str2)) {
                LinkedList<ModulePkgInfo> linkedList = wxaPkgWrappingInfo2.kNZ;
                ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
                List<WxaAttributes.WxaVersionModuleInfo> list = this.lgq.moduleList;
                p.g(list, "versionInfo.moduleList");
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(str2, next.name)) {
                        t = next;
                        break;
                    }
                }
                if (t == null) {
                    p.hyc();
                }
                T t2 = t;
                modulePkgInfo.name = str2;
                modulePkgInfo.md5 = wxaWidgetInfo.lhj;
                modulePkgInfo.independent = t2.independent;
                modulePkgInfo.aliases = t2.aliases;
                modulePkgInfo.pkgVersion = this.lgq.appVersion;
                linkedList.add(modulePkgInfo);
            }
            List<WxaAttributes.WxaPluginCodeInfo> list2 = wxaWidgetInfo.lhk;
            if (!(list2 == null || list2.isEmpty())) {
                WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = wxaPkgWrappingInfo2.kOb;
                if (wxaRuntimeModulePluginListMap == null) {
                    p.hyc();
                }
                List<WxaAttributes.WxaPluginCodeInfo> list3 = wxaWidgetInfo.lhk;
                List<WxaAttributes.WxaPluginCodeInfo> list4 = list3;
                if (list4 == null || list4.isEmpty()) {
                    arrayList = null;
                } else {
                    List<WxaAttributes.WxaPluginCodeInfo> list5 = list3;
                    ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list5, 10));
                    for (T t3 : list5) {
                        p.h(t3, "$this$toPkgInfo");
                        WxaPluginPkgInfo wxaPluginPkgInfo = new WxaPluginPkgInfo();
                        wxaPluginPkgInfo.provider = t3.provider;
                        wxaPluginPkgInfo.version = t3.version;
                        wxaPluginPkgInfo.md5 = t3.md5;
                        wxaPluginPkgInfo.prefixPath = t3.prefixPath;
                        wxaPluginPkgInfo.contexts = t3.contexts;
                        arrayList2.add(wxaPluginPkgInfo);
                    }
                    arrayList = arrayList2;
                }
                p.h(str2, "moduleName");
                if (arrayList != null && !arrayList.isEmpty()) {
                    wxaRuntimeModulePluginListMap.kOk.put(new WxaRuntimeModulePluginListMap.c.a(str2), arrayList);
                }
            }
        }
        WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap2 = wxaPkgWrappingInfo2.kOb;
        if (wxaRuntimeModulePluginListMap2 != null) {
            wxaRuntimeModulePluginListMap2.bwB();
        }
        if (!this.cuy || !af.Ut(this.kHw)) {
            if (!this.lgq.lgX || Util.isNullOrNil(this.lgq.moduleList)) {
                ac = kotlin.a.j.ac(ModulePkgInfo.MAIN_MODULE_NAME);
            } else {
                LinkedList linkedList2 = new LinkedList();
                String dM = com.tencent.luggage.h.l.dM(LaunchParcel.Wf(this.kHw));
                String str3 = dM;
                if (str3 == null || str3.length() == 0) {
                    String str4 = this.lgq.lgY;
                    if (!(str4 == null || str4.length() == 0)) {
                        Iterator<WxaAttributes.WxaVersionModuleInfo> it2 = this.lgq.moduleList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            WxaAttributes.WxaVersionModuleInfo next2 = it2.next();
                            if (p.j(this.lgq.lgY, next2.name)) {
                                wxaVersionModuleInfo = next2;
                                break;
                            }
                        }
                    }
                } else {
                    List<WxaAttributes.WxaVersionModuleInfo> list6 = this.lgq.moduleList;
                    p.g(list6, "versionInfo.moduleList");
                    wxaVersionModuleInfo = (WxaAttributes.WxaVersionModuleInfo) h.d(list6, dM, "LaunchCheckPkgHandlerSeparatedPluginsCompatible  appId:" + this.appId + " versionType:" + this.iOo);
                }
                if (wxaVersionModuleInfo != null) {
                    linkedList2.add(wxaVersionModuleInfo.name);
                }
                if (wxaVersionModuleInfo == null || (!wxaVersionModuleInfo.independent && (!p.j(ModulePkgInfo.MAIN_MODULE_NAME, wxaVersionModuleInfo.name)))) {
                    linkedList2.add(ModulePkgInfo.MAIN_MODULE_NAME);
                }
                ac = linkedList2;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicReference atomicReference = new AtomicReference();
            d.b("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible[" + this.appId + '|' + this.iOo + ']', new c(this, ac, a2, wxaPkgWrappingInfo2, atomicReference, countDownLatch));
            try {
                countDownLatch.await();
            } catch (Throwable th) {
                Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "await semaphore failed with appId(" + this.appId + ") versionType(" + this.iOo + ')');
            }
            WxaPkgWrappingInfo wxaPkgWrappingInfo3 = (WxaPkgWrappingInfo) atomicReference.get();
            AppMethodBeat.o(180613);
            return wxaPkgWrappingInfo3;
        }
        AppMethodBeat.o(180613);
        return wxaPkgWrappingInfo2;
    }

    public void bNi() {
    }

    public void onDownloadProgress(int i2) {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a {
        final /* synthetic */ ae mVa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ae aeVar) {
            super(0);
            this.mVa = aeVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(180607);
            ae.a(this.mVa);
            a unused = ae.mUZ;
            Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "call() parse extInfoJson failed with appId[" + this.mVa.appId + "] versionType[" + this.mVa.iOo + ']');
            AppMethodBeat.o(180607);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae mVa;
        final /* synthetic */ List mVb;
        final /* synthetic */ Map mVc;
        final /* synthetic */ WxaPkgWrappingInfo mVd;
        final /* synthetic */ AtomicReference mVe;
        final /* synthetic */ CountDownLatch mVf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ae aeVar, List list, Map map, WxaPkgWrappingInfo wxaPkgWrappingInfo, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            super(0);
            this.mVa = aeVar;
            this.mVb = list;
            this.mVc = map;
            this.mVd = wxaPkgWrappingInfo;
            this.mVe = atomicReference;
            this.mVf = countDownLatch;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            ICommLibReader iCommLibReader;
            AppMethodBeat.i(180611);
            ac acVar = ac.mUH;
            String str = this.mVa.mUY.kEY;
            p.g(str, "reportQualitySession.instanceId");
            ac.aca(str);
            l lVar = l.mSI;
            String str2 = this.mVa.appId;
            int i2 = this.mVa.lgq.appVersion;
            int i3 = this.mVa.iOo;
            List list = this.mVb;
            Map map = this.mVc;
            QualitySession qualitySession = this.mVa.mUY;
            AnonymousClass1 r6 = new kotlin.g.a.b<List<? extends IPkgInfo>, x>(this) {
                /* class com.tencent.mm.plugin.appbrand.launching.ae.c.AnonymousClass1 */
                final /* synthetic */ c mVg;

                {
                    this.mVg = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(List<? extends IPkgInfo> list) {
                    AppMethodBeat.i(180608);
                    List<? extends IPkgInfo> list2 = list;
                    p.h(list2, LocaleUtil.ITALIAN);
                    ae.a(this.mVg.mVd, list2);
                    this.mVg.mVe.set(this.mVg.mVd);
                    this.mVg.mVf.countDown();
                    x xVar = x.SXb;
                    AppMethodBeat.o(180608);
                    return xVar;
                }
            };
            AnonymousClass2 r7 = new kotlin.g.a.b<WxaPkgLoadProgress, x>(this) {
                /* class com.tencent.mm.plugin.appbrand.launching.ae.c.AnonymousClass2 */
                final /* synthetic */ c mVg;

                {
                    this.mVg = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    AppMethodBeat.i(180609);
                    WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
                    p.h(wxaPkgLoadProgress2, "progress");
                    ae.f(this.mVg.mVa);
                    this.mVg.mVa.onDownloadProgress(wxaPkgLoadProgress2.progress);
                    x xVar = x.SXb;
                    AppMethodBeat.o(180609);
                    return xVar;
                }
            };
            AnonymousClass3 r8 = new m<Integer, String, x>(this) {
                /* class com.tencent.mm.plugin.appbrand.launching.ae.c.AnonymousClass3 */
                final /* synthetic */ c mVg;

                {
                    this.mVg = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, String str) {
                    boolean z;
                    AppMethodBeat.i(180610);
                    int intValue = num.intValue();
                    String str2 = str;
                    a unused = ae.mUZ;
                    Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "waitForPkgList onError(" + intValue + ", " + str2 + ')');
                    if (!j.a.sE(this.mVg.mVa.iOo) || x.a.PKG_RECORD_NULL.code != intValue) {
                        StringBuilder append = new StringBuilder().append(f.getMMString(R.string.pd, 2, Integer.valueOf(intValue)));
                        String str3 = str2;
                        if (str3 == null || str3.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.mVg.mVa.acb(append.append(z ? "" : "\n".concat(String.valueOf(str2))).toString());
                    } else {
                        ae.a(this.mVg.mVa);
                    }
                    this.mVg.mVf.countDown();
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(180610);
                    return xVar;
                }
            };
            if (!this.mVa.mSa) {
                v.a.C0742a aVar = v.a.mTH;
                if (v.a.C0742a.hW(this.mVa.cuy) && (iCommLibReader = this.mVa.leM) != null) {
                    aa.a aVar2 = aa.nqC;
                    if (aa.a.d(iCommLibReader)) {
                        z = false;
                        acc acc = this.mVa.mSK;
                        ac acVar2 = ac.mUH;
                        l.a(str2, i2, i3, list, map, qualitySession, r6, r7, r8, z, acc, ac.a(this.mVa.mUY, true, this.mVa.mSK.LmF, new kotlin.g.a.b<x.d, kotlin.x>(this) {
                            /* class com.tencent.mm.plugin.appbrand.launching.ae.c.AnonymousClass4 */
                            final /* synthetic */ c mVg;

                            {
                                this.mVg = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // kotlin.g.a.b
                            public final /* synthetic */ kotlin.x invoke(x.d dVar) {
                                AppMethodBeat.i(228690);
                                p.h(dVar, LocaleUtil.ITALIAN);
                                ae.f(this.mVg.mVa);
                                kotlin.x xVar = kotlin.x.SXb;
                                AppMethodBeat.o(228690);
                                return xVar;
                            }
                        }));
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(180611);
                        return xVar;
                    }
                }
            }
            z = true;
            acc acc2 = this.mVa.mSK;
            ac acVar22 = ac.mUH;
            l.a(str2, i2, i3, list, map, qualitySession, r6, r7, r8, z, acc2, ac.a(this.mVa.mUY, true, this.mVa.mSK.LmF, new kotlin.g.a.b<x.d, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.appbrand.launching.ae.c.AnonymousClass4 */
                final /* synthetic */ c mVg;

                {
                    this.mVg = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ kotlin.x invoke(x.d dVar) {
                    AppMethodBeat.i(228690);
                    p.h(dVar, LocaleUtil.ITALIAN);
                    ae.f(this.mVg.mVa);
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(228690);
                    return xVar;
                }
            }));
            kotlin.x xVar2 = kotlin.x.SXb;
            AppMethodBeat.o(180611);
            return xVar2;
        }
    }

    public static final /* synthetic */ void a(ae aeVar) {
        String mMString;
        AppMethodBeat.i(228692);
        switch (aeVar.iOo) {
            case 1:
                mMString = f.getMMString(R.string.na, new Object[0]);
                break;
            default:
                mMString = f.getMMString(R.string.pg, e.vO(aeVar.iOo));
                break;
        }
        aeVar.acb(mMString);
        AppMethodBeat.o(228692);
    }

    public static final /* synthetic */ void a(WxaPkgWrappingInfo wxaPkgWrappingInfo, List list) {
        Object obj;
        AppMethodBeat.i(180617);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IPkgInfo iPkgInfo = (IPkgInfo) it.next();
            if (iPkgInfo instanceof ModulePkgInfo) {
                Iterator it2 = wxaPkgWrappingInfo.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it2.next();
                    if (p.j(((ModulePkgInfo) next).name, ((ModulePkgInfo) iPkgInfo).name)) {
                        obj = next;
                        break;
                    }
                }
                if (obj == null) {
                    p.hyc();
                }
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) obj;
                modulePkgInfo.pkgPath = ((ModulePkgInfo) iPkgInfo).pkgPath;
                modulePkgInfo.md5 = ((ModulePkgInfo) iPkgInfo).md5;
            } else if (iPkgInfo instanceof WxaPluginPkgInfo) {
                WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = wxaPkgWrappingInfo.kOb;
                if (wxaRuntimeModulePluginListMap == null) {
                    p.hyc();
                }
                wxaRuntimeModulePluginListMap.a((WxaPluginPkgInfo) iPkgInfo);
            }
        }
        AppMethodBeat.o(180617);
    }

    public static final /* synthetic */ void f(ae aeVar) {
        AppMethodBeat.i(228693);
        if (!aeVar.mUX) {
            aeVar.bNi();
            aeVar.mUX = true;
        }
        AppMethodBeat.o(228693);
    }
}
