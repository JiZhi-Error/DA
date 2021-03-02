package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.dfa;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData;", "", "()V", "Companion", "plugin-expt_release"})
public final class a {
    public static final C1023a sJL = new C1023a((byte) 0);

    static {
        AppMethodBeat.i(221171);
        AppMethodBeat.o(221171);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J:\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0002J&\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\tJ8\u0010 \u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\"\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010#\u001a\u00020\u000eH\u0002J\u0006\u0010$\u001a\u00020\u000eJ:\u0010%\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData$Companion;", "", "()V", "CONFIG_TYPE_SESSION", "", "CONFIG_TYPE_SESSION_PAGE", "CONFIG_TYPE_UBA", "CONFIG_TYPE_VIEW_BLACK_LIST", "MMKV_KEY", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/CgiConfigProguard;", "_write", "", "parguard", "addJson", "id", "type", "isReport", "", "json", "kvMap", "", "Lcom/tencent/mm/protocal/protobuf/KV;", "addKv", "delKv", "geViewResName", "viewId", "pageList", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", BuildConfig.KINDA_DEFAULT, "notifySessionPageConfigChange", "isDel", "removeJson", "reset", "resetJson", "updateJson", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.b.a.a$a  reason: collision with other inner class name */
    public static final class C1023a {
        private C1023a() {
        }

        public /* synthetic */ C1023a(byte b2) {
            this();
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static void a(String str, int i2, boolean z, String str2, List<? extends cft> list) {
            AppMethodBeat.i(221164);
            if (str == null || str2 == null || list == null || list.isEmpty()) {
                AppMethodBeat.o(221164);
                return;
            }
            r(str, list);
            switch (i2) {
                case 1:
                    AppMethodBeat.o(221164);
                    return;
                case 3:
                    a(str, str2, list, false, z);
                    break;
            }
            AppMethodBeat.o(221164);
        }

        private static void r(String str, List<? extends cft> list) {
            AppMethodBeat.i(221165);
            vl cRd = cRd();
            if (cRd == null) {
                vl vlVar = new vl();
                dfa dfa = new dfa();
                dfa.id = str;
                dfa.MKb.addAll(list);
                vlVar.LgA.add(dfa);
                a(vlVar);
                AppMethodBeat.o(221165);
                return;
            }
            Iterator<dfa> it = cRd.LgA.iterator();
            while (it.hasNext()) {
                dfa next = it.next();
                if (p.j(str, next.id)) {
                    next.MKb.clear();
                    next.MKb.addAll(list);
                    a(cRd);
                    AppMethodBeat.o(221165);
                    return;
                }
            }
            dfa dfa2 = new dfa();
            dfa2.id = str;
            dfa2.MKb.addAll(list);
            cRd.LgA.add(dfa2);
            a(cRd);
            AppMethodBeat.o(221165);
        }

        public static void are(String str) {
            AppMethodBeat.i(221166);
            vl cRd = cRd();
            if (cRd == null) {
                AppMethodBeat.o(221166);
                return;
            }
            Iterator<dfa> it = cRd.LgA.iterator();
            while (it.hasNext()) {
                dfa next = it.next();
                if (p.j(str, next.id)) {
                    cRd.LgA.remove(next);
                    a(cRd);
                    AppMethodBeat.o(221166);
                    return;
                }
            }
            AppMethodBeat.o(221166);
        }

        public static String b(String str, List<? extends dvg> list, String str2) {
            AppMethodBeat.i(221167);
            p.h(str, "viewId");
            p.h(list, "pageList");
            for (dvg dvg : list) {
                Iterator<ere> it = dvg.MWm.iterator();
                while (true) {
                    if (it.hasNext()) {
                        ere next = it.next();
                        if (p.j(str, next.viewId)) {
                            if (next.NoL != null) {
                                l.a aVar = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
                                l.a.Bt(130);
                                String str3 = next.NoL;
                                p.g(str3, "viewOp.resName");
                                AppMethodBeat.o(221167);
                                return str3;
                            }
                            Log.i("HABBYGE-MALI.HellCloudData", "geViewResName, viewId=" + str + ", viewOp.viewId=" + next.viewId + ", viewOp.resName=" + next.NoL);
                            l.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
                            l.a.Bt(159);
                            if (str2 != null) {
                                str = str2;
                            }
                            AppMethodBeat.o(221167);
                            return str;
                        }
                    }
                }
            }
            if (str2 != null) {
                str = str2;
            }
            AppMethodBeat.o(221167);
            return str;
        }

        public static void a(String str, String str2, List<? extends cft> list, boolean z, boolean z2) {
            AppMethodBeat.i(221168);
            Log.i("HABBYGE-MALI.HellCloudData", "notifySessionPageConfigChange: " + str + ", " + z2 + ", " + z);
            ug ugVar = new ug();
            ugVar.eaD.eaB = Long.parseLong(str);
            ugVar.eaD.dNA = str2;
            ugVar.eaD.eaz = Boolean.valueOf(z);
            ugVar.eaD.eaF = Boolean.valueOf(z2);
            ugVar.eaD.eaE = list;
            ugVar.eaD.version = 2;
            EventCenter.instance.publish(ugVar);
            AppMethodBeat.o(221168);
        }

        private static void a(vl vlVar) {
            AppMethodBeat.i(221169);
            try {
                byte[] byteArray = vlVar.toByteArray();
                p.g(byteArray, "parguard.toByteArray()");
                b.o("hell_cgi_cc_dat", byteArray);
                AppMethodBeat.o(221169);
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", e2, "HellCloudData, write: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221169);
            }
        }

        private static vl cRd() {
            AppMethodBeat.i(221170);
            byte[] bytes = b.getBytes("hell_cgi_cc_dat");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    vl vlVar = new vl();
                    try {
                        vlVar.parseFrom(bytes);
                        AppMethodBeat.o(221170);
                        return vlVar;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", e2, "HellCloudData, read: " + e2.getMessage(), new Object[0]);
                        AppMethodBeat.o(221170);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(221170);
            return null;
        }
    }
}
