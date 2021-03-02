package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver;", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "()V", "TAG", "", "THREAD_TAG", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "forcePendingUpdateHistoryAndStar", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPendingFetchHistoryAndStarTask", "", "isAppBackground", "fetchStartAndHistory", "", "onDeleteMsg", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "parseWxaInfo", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "values", "", "prefix", "process", "xml", "processPendingFetching", "register", "unregister", "plugin-appbrand-integration_release"})
public final class ar implements cj.a {
    public static final o.a appForegroundListener = new a();
    private static final String kWD;
    private static volatile boolean kWE = true;
    private static volatile boolean kWF;
    private static AtomicBoolean kWG = new AtomicBoolean(true);
    public static final ar kWH;

    static {
        AppMethodBeat.i(228147);
        ar arVar = new ar();
        kWH = arVar;
        kWD = String.valueOf(arVar.hashCode());
        AppMethodBeat.o(228147);
    }

    private ar() {
    }

    public static final /* synthetic */ void byz() {
        AppMethodBeat.i(228148);
        byy();
        AppMethodBeat.o(228148);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-appbrand-integration_release"})
    public static final class a extends o.a {
        a() {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(228136);
            p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppForeground");
            ar arVar = ar.kWH;
            ar.kWE = false;
            ar arVar2 = ar.kWH;
            ar.byx();
            AppMethodBeat.o(228136);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(228137);
            p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppBackground");
            ar arVar = ar.kWH;
            ar.kWE = true;
            AppMethodBeat.o(228137);
        }
    }

    public static void byx() {
        AppMethodBeat.i(228143);
        if (kWF) {
            kWF = false;
            com.tencent.mm.ac.d.c(kWD, d.kWK);
        }
        AppMethodBeat.o(228143);
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(228144);
        p.h(aVar, "addMsgInfo");
        String a2 = z.a(aVar.heO.KHn);
        if (Util.isNullOrNil(a2)) {
            AppMethodBeat.o(228144);
            return;
        }
        com.tencent.mm.ac.d.c(kWD, new b(a2));
        AppMethodBeat.o(228144);
    }

    private static void byy() {
        AppMethodBeat.i(228145);
        Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "fetchStartAndHistory");
        j.bxQ().a(Util.nowMilliSecond(), true, null, 4, 0);
        AppMethodBeat.o(228145);
    }

    private static List<aq> e(Map<String, String> map, String str) {
        boolean z;
        AppMethodBeat.i(228146);
        int i2 = Util.getInt(map.get(str + ".DeleteCount"), 0);
        ArrayList arrayList = new ArrayList();
        if (i2 > 0) {
            int i3 = 0;
            while (i3 < i2) {
                String str2 = str + ".DeleteList.DeleteAppInfo" + (i3 == 0 ? "" : Integer.valueOf(i3));
                String str3 = map.get(str2 + ".UserName");
                String str4 = map.get(str2 + ".AppID");
                int i4 = Util.getInt(map.get(str2 + ".AppType"), 0);
                String str5 = str3;
                if (str5 == null || str5.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    String str6 = str4;
                    if (!(str6 == null || str6.length() == 0)) {
                        arrayList.add(new aq(str3, str4, i4));
                    }
                }
                i3++;
            }
        }
        AppMethodBeat.o(228146);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        public static final d kWK = new d();

        static {
            AppMethodBeat.i(228142);
            AppMethodBeat.o(228142);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(228141);
            ar arVar = ar.kWH;
            ar.byz();
            x xVar = x.SXb;
            AppMethodBeat.o(228141);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String kWI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.kWI = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(228138);
            ar arVar = ar.kWH;
            String str = this.kWI;
            p.g(str, "msgContent");
            ar.Wx(str);
            x xVar = x.SXb;
            AppMethodBeat.o(228138);
            return xVar;
        }
    }

    public static final /* synthetic */ void Wx(String str) {
        AppMethodBeat.i(228149);
        if (!g.aAc()) {
            Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "parseThenProcess, account not ready");
            AppMethodBeat.o(228149);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (!(parseXml == null || parseXml.isEmpty())) {
            int i2 = Util.getInt(parseXml.get(".sysmsg.UpdateWxaUsageListNotify" + ".Type"), 0);
            StringBuilder sb = new StringBuilder("type:");
            ak.a aVar = ak.kWj;
            Object wa = ak.a.wa(i2);
            if (wa == null) {
                wa = "NULL";
            }
            Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", sb.append(wa).toString());
            if ((kWE || kWG.get()) && (i2 == ak.MODIFY_HISTORY_LIST.value || i2 == ak.MODIFY_STAR_LIST.value)) {
                Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "app is in background status or force pending fetching,pending execute history and star fetching");
                kWF = true;
                if (kWG.get()) {
                    com.tencent.mm.ac.d.a(1500, c.kWJ);
                }
                AppMethodBeat.o(228149);
                return;
            }
            ak.a aVar2 = ak.kWj;
            ak wa2 = ak.a.wa(i2);
            if (wa2 != null) {
                switch (as.$EnumSwitchMapping$0[wa2.ordinal()]) {
                    case 1:
                        byy();
                        AppMethodBeat.o(228149);
                        return;
                    case 2:
                        byy();
                        AppMethodBeat.o(228149);
                        return;
                    case 3:
                        for (aq aqVar : e(parseXml, ".sysmsg.UpdateWxaUsageListNotify")) {
                            an.t(aqVar.userName, aqVar.appId, aqVar.iOo);
                        }
                        break;
                    case 4:
                        for (aq aqVar2 : e(parseXml, ".sysmsg.UpdateWxaUsageListNotify")) {
                            an.t(aqVar2.userName, aqVar2.appId, aqVar2.iOo);
                            n.buK().j(aqVar2.userName, aqVar2.iOo, false);
                        }
                        break;
                }
            } else {
                AppMethodBeat.o(228149);
                return;
            }
        }
        AppMethodBeat.o(228149);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        public static final c kWJ = new c();

        static {
            AppMethodBeat.i(228140);
            AppMethodBeat.o(228140);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(228139);
            ar arVar = ar.kWH;
            if (ar.kWG.getAndSet(false)) {
                ar arVar2 = ar.kWH;
                if (!ar.kWE) {
                    ar arVar3 = ar.kWH;
                    ar.byx();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228139);
            return xVar;
        }
    }
}
