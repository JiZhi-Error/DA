package com.tencent.mm.plugin.appbrand.e;

import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.platformtools.AppBrands;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.xweb.ah;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory;", "Lcom/tencent/mm/sdk/crash/ICrashReporter$ICrashReportExtraMessageGetter;", "()V", "mRunningAppInfos", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "getCrashReportExtraMessage", "", "onRuntimeDestroyed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onRuntimeResumed", "ReportWeAppInfo", "plugin-appbrand-integration_release"})
public final class a implements ICrashReporter.ICrashReportExtraMessageGetter {
    private static final LinkedHashMap<C0578a, Boolean> lhv = new LinkedHashMap<>(5, 0.7f, true);
    public static final a lhw = new a();

    static {
        AppMethodBeat.i(50345);
        AppBrands.setAppBrandInfoGetterSupplier(AnonymousClass1.lhx);
        AppMethodBeat.o(50345);
    }

    private a() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0000H\u0002J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "appId", "", "appName", "appType", "", "appVersion", "(Ljava/lang/String;Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getAppName", "getAppType", "()I", "getAppVersion", "compareTo", FacebookRequestErrorClassification.KEY_OTHER, "equals", "", "", "hashCode", "Companion", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.e.a$a  reason: collision with other inner class name */
    public static final class C0578a implements Comparable<C0578a> {
        public static final C0579a lhy = new C0579a((byte) 0);
        final String appId;
        final String appName;
        final int appType;
        final int appVersion;

        static {
            AppMethodBeat.i(50341);
            AppMethodBeat.o(50341);
        }

        public C0578a(String str, String str2, int i2, int i3) {
            p.h(str, "appId");
            p.h(str2, "appName");
            AppMethodBeat.i(50340);
            this.appId = str;
            this.appName = str2;
            this.appType = i2;
            this.appVersion = i3;
            AppMethodBeat.o(50340);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(C0578a aVar) {
            AppMethodBeat.i(50337);
            int a2 = a(aVar);
            AppMethodBeat.o(50337);
            return a2;
        }

        private int a(C0578a aVar) {
            AppMethodBeat.i(50336);
            p.h(aVar, FacebookRequestErrorClassification.KEY_OTHER);
            int compareTo = this.appId.compareTo(aVar.appId);
            if (compareTo == 0) {
                compareTo = this.appType - aVar.appType;
            }
            if (compareTo == 0 && j.a.vP(this.appType)) {
                compareTo = this.appVersion - aVar.appVersion;
            }
            AppMethodBeat.o(50336);
            return compareTo;
        }

        public final int hashCode() {
            AppMethodBeat.i(50338);
            int hashCode = ("[" + this.appId + "::" + this.appType + "::" + this.appVersion + ']').hashCode();
            AppMethodBeat.o(50338);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(50339);
            if (!(obj instanceof C0578a) || a((C0578a) obj) != 0) {
                AppMethodBeat.o(50339);
                return false;
            }
            AppMethodBeat.o(50339);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.e.a$a$a  reason: collision with other inner class name */
        public static final class C0579a {
            private C0579a() {
            }

            public /* synthetic */ C0579a(byte b2) {
                this();
            }

            public static C0578a S(AppBrandRuntime appBrandRuntime) {
                String str;
                int i2;
                String str2;
                int i3 = -1;
                AppMethodBeat.i(50335);
                p.h(appBrandRuntime, "runtime");
                String appId = appBrandRuntime.getAppId();
                p.g(appId, "runtime.appId");
                AppBrandInitConfig OU = appBrandRuntime.OU();
                if (OU == null || (str2 = OU.brandName) == null) {
                    str = "unknown";
                } else {
                    str = str2;
                }
                AppBrandInitConfig OU2 = appBrandRuntime.OU();
                if (!(OU2 instanceof AppBrandInitConfigLU)) {
                    OU2 = null;
                }
                AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) OU2;
                if (appBrandInitConfigLU != null) {
                    i2 = appBrandInitConfigLU.eix;
                } else {
                    i2 = -1;
                }
                AppBrandInitConfig OU3 = appBrandRuntime.OU();
                if (!(OU3 instanceof AppBrandInitConfigLU)) {
                    OU3 = null;
                }
                AppBrandInitConfigLU appBrandInitConfigLU2 = (AppBrandInitConfigLU) OU3;
                if (appBrandInitConfigLU2 != null) {
                    i3 = appBrandInitConfigLU2.appVersion;
                }
                C0578a aVar = new C0578a(appId, str, i2, i3);
                AppMethodBeat.o(50335);
                return aVar;
            }
        }
    }

    public static final void Q(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(50342);
        p.h(appBrandRuntime, "runtime");
        synchronized (lhv) {
            try {
                LinkedHashMap<C0578a, Boolean> linkedHashMap = lhv;
                C0578a.C0579a aVar = C0578a.lhy;
                linkedHashMap.put(C0578a.C0579a.S(appBrandRuntime), Boolean.TRUE);
            } catch (Throwable th) {
                AppMethodBeat.o(50342);
                throw th;
            }
        }
        ah.m(90001, new String[]{appBrandRuntime.getAppId()});
        AppMethodBeat.o(50342);
    }

    public static final void R(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(50343);
        p.h(appBrandRuntime, "runtime");
        synchronized (lhv) {
            try {
                LinkedHashMap<C0578a, Boolean> linkedHashMap = lhv;
                C0578a.C0579a aVar = C0578a.lhy;
                linkedHashMap.remove(C0578a.C0579a.S(appBrandRuntime));
            } finally {
                AppMethodBeat.o(50343);
            }
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter
    public final String getCrashReportExtraMessage() {
        String str;
        C0578a aVar;
        AppMethodBeat.i(50344);
        LinkedList linkedList = new LinkedList();
        ICommLibReader bvV = WxaCommLibRuntimeReader.bvV();
        linkedList.add(new o("weapp_lib_version_int", Integer.valueOf(bvV != null ? bvV.bvd() : -1)));
        if (bvV == null || (str = bvV.bvb()) == null) {
            str = "unknown";
        }
        linkedList.add(new o("weapp_lib_version_str", str));
        synchronized (lhv) {
            try {
                if (lhv.size() > 0) {
                    Iterator<C0578a> it = lhv.keySet().iterator();
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        C0578a next = it.next();
                        p.g(next, "it.next()");
                        aVar = next;
                        if (!it.hasNext()) {
                            break;
                        }
                        sb.append(aVar.appId).append(',');
                    }
                    linkedList.add(new o(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, aVar.appId));
                    linkedList.add(new o(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, aVar.appName));
                    linkedList.add(new o("weapp_version", Integer.valueOf(aVar.appVersion)));
                    String sb2 = sb.toString();
                    p.g(sb2, "this");
                    int max = Math.max(n.b((CharSequence) sb2, ','), 0);
                    if (sb2 == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(50344);
                        throw tVar;
                    }
                    String substring = sb2.substring(0, max);
                    p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (!TextUtils.isEmpty(substring)) {
                        linkedList.add(new o("weapp_other_ids", substring));
                    }
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(50344);
                throw th;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            o oVar = (o) it2.next();
            sb3.append((String) oVar.first).append(':').append(oVar.second.toString()).append(';');
        }
        String sb4 = sb3.toString();
        AppMethodBeat.o(50344);
        return sb4;
    }
}
