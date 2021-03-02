package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kn;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.i;
import com.tencent.mm.plugin.appbrand.keylogger.f;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0018\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001d\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016J.\u0010\u001e\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002J\f\u0010(\u001a\u00020\u0014*\u00020)H\u0007R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "checkReportDebugFlag", "", "onProcessEnd", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"})
public final class o implements com.tencent.mm.plugin.appbrand.keylogger.base.b {
    private static final ConcurrentHashMap<String, String> nMc = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> nMd = new ConcurrentHashMap<>();
    public static final o nMe = new o();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"})
    public enum a {
        START,
        OK,
        FAIL;

        static {
            AppMethodBeat.i(229322);
            AppMethodBeat.o(229322);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(229324);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(229324);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"makeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<kn> {
        final /* synthetic */ String kPQ;
        final /* synthetic */ String nIb;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.keylogger.base.a nMj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, String str2, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar) {
            super(0);
            this.nIb = str;
            this.kPQ = str2;
            this.nMj = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kn invoke() {
            AppMethodBeat.i(229326);
            kn bVn = bVn();
            AppMethodBeat.o(229326);
            return bVn;
        }

        public final kn bVn() {
            String name;
            AppMethodBeat.i(229327);
            kn knVar = new kn();
            knVar.xS(this.nIb);
            knVar.xT(this.kPQ);
            knVar.xU(this.nMj.name());
            o oVar = o.nMe;
            com.tencent.mm.plugin.appbrand.keylogger.base.a aVar = (com.tencent.mm.plugin.appbrand.keylogger.base.a) o.nMd.get(this.nMj);
            if (aVar == null) {
                name = null;
            } else if (KSProcessWeAppLaunch.stepLaunch == aVar) {
                name = "StartUp";
            } else {
                name = aVar.name();
            }
            knVar.xV(name);
            String bMW = this.nMj.bMW();
            p.g(bMW, "step.desc()");
            if (n.a((CharSequence) bMW, (CharSequence) "(Global)", false)) {
                knVar.tM(0);
            } else {
                String bMW2 = this.nMj.bMW();
                p.g(bMW2, "step.desc()");
                if (n.a((CharSequence) bMW2, (CharSequence) "(View)", false)) {
                    knVar.tM(1);
                } else {
                    String bMW3 = this.nMj.bMW();
                    p.g(bMW3, "step.desc()");
                    if (n.a((CharSequence) bMW3, (CharSequence) "(Service)", false)) {
                        knVar.tM(2);
                    } else {
                        knVar.tM(3);
                    }
                }
            }
            AppMethodBeat.o(229327);
            return knVar;
        }
    }

    static {
        AppMethodBeat.i(229339);
        bVl();
        h h2 = f.h(KSProcessWeAppLaunch.class, WeChatBrands.Business.GROUP_MP);
        p.g(h2, "root");
        c(h2);
        AppMethodBeat.o(229339);
    }

    private o() {
    }

    public static final boolean bVk() {
        AppMethodBeat.i(229328);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || DebuggerShell.bAx()) {
            AppMethodBeat.o(229328);
            return true;
        }
        AppMethodBeat.o(229328);
        return false;
    }

    public static final void bVl() {
        AppMethodBeat.i(229329);
        if (DebuggerShell.bAx() && bVk()) {
            try {
                SmcLogic.SetDebugFlag(true);
                c.CxC = true;
            } catch (UnsatisfiedLinkError e2) {
                c.CxC = true;
            } catch (Throwable th) {
                c.CxC = true;
                AppMethodBeat.o(229329);
                throw th;
            }
            Log.setLevel(0, false);
            Log.setConsoleLogOpen(true);
        }
        AppMethodBeat.o(229329);
    }

    private static void c(h hVar) {
        AppMethodBeat.i(229330);
        v bNa = hVar.bNa();
        if (bNa == null) {
            bNa = v.SXr;
        }
        for (T t : bNa) {
            p.g(t, "child");
            List<h> bNa2 = t.bNa();
            if (!(bNa2 == null || bNa2.isEmpty())) {
                c(t);
            }
            if (hVar.bNb() != null) {
                ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> concurrentHashMap = nMd;
                com.tencent.mm.plugin.appbrand.keylogger.base.a bNb = t.bNb();
                if (bNb == null) {
                    p.hyc();
                }
                p.g(bNb, "child.asStep()!!");
                com.tencent.mm.plugin.appbrand.keylogger.base.a bNb2 = hVar.bNb();
                if (bNb2 == null) {
                    p.hyc();
                }
                p.g(bNb2, "node.asStep()!!");
                concurrentHashMap.put(bNb, bNb2);
            }
        }
        AppMethodBeat.o(229330);
    }

    public static void eI(String str, String str2) {
        AppMethodBeat.i(229331);
        p.h(str2, "instanceId");
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(229331);
            return;
        }
        nMc.put(str, str2);
        AppMethodBeat.o(229331);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.b
    public final void b(String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar, long j2) {
        AppMethodBeat.i(229332);
        Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", "onStepOk id:" + str + " step:" + (aVar != null ? aVar.name() : null) + " cost:" + j2);
        a(str, aVar, j2, a.OK);
        AppMethodBeat.o(229332);
    }

    public static final void a(kn knVar) {
        AppMethodBeat.i(229333);
        p.h(knVar, "$this$reportCustom");
        boolean bAx = DebuggerShell.bAx();
        String abV = knVar.abV();
        Log.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + abV + " |reportNow:" + bAx);
        com.tencent.mm.plugin.appbrand.report.a aVar = com.tencent.mm.plugin.appbrand.report.a.nFX;
        int id = knVar.getId();
        p.g(abV, "rptValue");
        com.tencent.mm.plugin.appbrand.report.a.a(id, bAx, bAx, bAx, abV);
        AppMethodBeat.o(229333);
    }

    private static /* synthetic */ void a(o oVar, String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar, a aVar2) {
        AppMethodBeat.i(229335);
        oVar.a(str, aVar, 0, aVar2);
        AppMethodBeat.o(229335);
    }

    private final void a(String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar, long j2, a aVar2) {
        AppMethodBeat.i(229334);
        if (!bVk()) {
            AppMethodBeat.o(229334);
        } else if (aVar == null) {
            AppMethodBeat.o(229334);
        } else if (str == null) {
            AppMethodBeat.o(229334);
        } else {
            if (DebuggerShell.bAx()) {
                SmcLogic.SetDebugFlag(true);
            }
            if (aVar instanceof i) {
                abV(str);
            }
            if (!MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(str, false)) {
                AppMethodBeat.o(229334);
                return;
            }
            String str2 = nMc.get(str);
            if (str2 == null) {
                AppMethodBeat.o(229334);
                return;
            }
            p.g(str2, "mapAppId2InstanceId[appId] ?: return");
            b bVar = new b(str2, str, aVar);
            if (aVar instanceof i) {
                kn bVn = bVar.bVn();
                bVn.xU("StartUp");
                bVn.tL(0);
                bVn.tK(Util.nowMilliSecond());
                a(bVn);
                AppMethodBeat.o(229334);
            } else if (aVar instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f) {
                kn bVn2 = bVar.bVn();
                bVn2.xU("StartUp");
                bVn2.tL(1);
                bVn2.tK(Util.nowMilliSecond());
                a(bVn2);
                AppMethodBeat.o(229334);
            } else {
                switch (p.$EnumSwitchMapping$0[aVar2.ordinal()]) {
                    case 1:
                        if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(str + "__SPLITOR_PROCESS_REPORTED_STARTED__" + aVar.name())) {
                            AppMethodBeat.o(229334);
                            return;
                        }
                        kn bVn3 = bVar.bVn();
                        bVn3.tL(0);
                        bVn3.tK(Util.nowMilliSecond());
                        a(bVn3);
                        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(str + "__SPLITOR_PROCESS_REPORTED_STARTED__" + aVar.name(), Util.nowMilliSecond());
                        AppMethodBeat.o(229334);
                        return;
                    default:
                        if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(str + "__SPLITOR_PROCESS_REPORTED_STARTED__" + aVar.name())) {
                            long nowMilliSecond = Util.nowMilliSecond();
                            j2 = nowMilliSecond - MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(str + "__SPLITOR_PROCESS_REPORTED_STARTED__" + aVar.name(), nowMilliSecond);
                        }
                        if (j2 > 0) {
                            kn bVn4 = bVar.bVn();
                            bVn4.tL(a.OK == aVar2 ? 1 : 3);
                            bVn4.tK(Util.nowMilliSecond());
                            a(bVn4);
                            if (!MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(str + "__SPLITOR_PROCESS_REPORTED_STARTED__" + aVar.name())) {
                                kn bVn5 = bVar.bVn();
                                bVn5.tL(0);
                                bVn5.tK(Util.nowMilliSecond() - j2);
                                a(bVn5);
                                AppMethodBeat.o(229334);
                                return;
                            }
                        } else {
                            kn bVn6 = bVar.bVn();
                            bVn6.tL(2);
                            bVn6.tK(Util.nowMilliSecond());
                            a(bVn6);
                        }
                        AppMethodBeat.o(229334);
                        return;
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.b
    public final void f(String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar) {
        AppMethodBeat.i(229336);
        Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", "onStepStart id:" + str + " step:" + (aVar != null ? aVar.name() : null));
        a(this, str, aVar, a.START);
        AppMethodBeat.o(229336);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.b
    public final void abW(String str) {
        AppMethodBeat.i(229337);
        if (str == null) {
            AppMethodBeat.o(229337);
            return;
        }
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str).apply();
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str + "_RUNNING_RESOURCE_PREPARING");
        if (DebuggerShell.bAx()) {
            com.tencent.mm.plugin.appbrand.report.a.bUe();
        }
        AppMethodBeat.o(229337);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.b
    public final void abV(String str) {
        String str2;
        AppMethodBeat.i(229338);
        if (str == null) {
            AppMethodBeat.o(229338);
            return;
        }
        String[] allKeys = MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).allKeys();
        if (allKeys == null) {
            allKeys = new String[0];
        }
        for (String str3 : allKeys) {
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            if (n.J(str2, str, false)) {
                MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str3);
            }
        }
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(str, true).apply();
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str + "_RUNNING_RESOURCE_PREPARING");
        AppMethodBeat.o(229338);
    }
}
