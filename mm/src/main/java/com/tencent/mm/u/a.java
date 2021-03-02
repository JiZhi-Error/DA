package com.tencent.mm.u;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s;
import com.tencent.mm.api.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bs;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a implements t, i, f {
    public static long dfO;
    private static long heJ;
    public static final e heK;
    public static boolean heL;
    private static final s heM = new com.tencent.mm.r.a();
    public static final a heN;
    public static boolean isInit = true;

    static {
        AppMethodBeat.i(114115);
        a aVar = new a();
        heN = aVar;
        heK = new e(aVar);
        AppMethodBeat.o(114115);
    }

    private a() {
    }

    public static boolean awF() {
        boolean z;
        long j2;
        AppMethodBeat.i(114111);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long akg = aAh.azQ().akg(8196);
        boolean z2 = (7 & akg) != 0;
        if (heL || System.currentTimeMillis() - dfO >= 15000) {
            z = true;
        } else {
            z = false;
        }
        Log.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + akg + ", isContinueSync:" + z2 + ", isNeedCheck:" + z + ", isNeedCheckSoon:" + heL);
        if (z2) {
            j2 = SystemClock.uptimeMillis();
        } else {
            j2 = 0;
        }
        heJ = j2;
        if (0 != heJ) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - heJ >= 1800000) {
                h.INSTANCE.idkeyStat(1021, 0, 1, true);
            } else if (uptimeMillis - heJ >= 1200000) {
                h.INSTANCE.idkeyStat(1021, 1, 1, true);
            } else if (uptimeMillis - heJ >= 600000) {
                h.INSTANCE.idkeyStat(1021, 2, 1, true);
            }
        }
        if (z2 || !z) {
            AppMethodBeat.o(114111);
            return false;
        }
        AppMethodBeat.o(114111);
        return true;
    }

    @Override // com.tencent.mm.api.t
    public final void a(de deVar, Map<String, String> map) {
        String str;
        AppMethodBeat.i(114112);
        p.h(deVar, "addMsg");
        p.h(map, "values");
        Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", Integer.valueOf(deVar.CreateTime), Integer.valueOf(Util.getInt(map.get(".sysmsg.functionmsg.op"), 0)));
        heL = true;
        long currentTimeMillis = System.currentTimeMillis();
        C2069a aVar = new C2069a(deVar, map);
        Map<String, String> map2 = aVar.values;
        String str2 = map2.get(".sysmsg.functionmsg.cgi");
        int i2 = Util.getInt(map2.get(".sysmsg.functionmsg.cmdid"), 0);
        String str3 = map2.get(".sysmsg.functionmsg.functionmsgid");
        long j2 = Util.getLong(map2.get(".sysmsg.functionmsg.version"), 0);
        int i3 = Util.getInt(map2.get(".sysmsg.functionmsg.op"), 0);
        int i4 = Util.getInt(map2.get(".sysmsg.functionmsg.retryinterval"), 0);
        int i5 = Util.getInt(map2.get(".sysmsg.functionmsg.reportid"), 0);
        int i6 = Util.getInt(map2.get(".sysmsg.functionmsg.successkey"), 0);
        int i7 = Util.getInt(map2.get(".sysmsg.functionmsg.failkey"), 0);
        int i8 = Util.getInt(map2.get(".sysmsg.functionmsg.finalfailkey"), 0);
        String str4 = map2.get(".sysmsg.functionmsg.custombuff");
        long j3 = Util.getLong(map2.get(".sysmsg.functionmsg.businessid"), 0);
        String str5 = map2.get(".sysmsg.functionmsg.businessbuff");
        long j4 = Util.getLong(map2.get(".sysmsg.functionmsg.actiontime"), 0);
        long j5 = Util.getLong(map2.get(".sysmsg.functionmsg.delaytime"), 0);
        int i9 = Util.getInt(map2.get(".sysmsg.functionmsg.retrycount"), 3);
        String a2 = z.a(aVar.heO.KHn);
        p.g(a2, "content");
        int a3 = n.a((CharSequence) a2, "<addmsg>", 0, false, 6);
        int a4 = n.a((CharSequence) a2, "</addmsg>", 0, false, 6) + 9;
        if (a4 <= a3 || a4 == -1 || a3 == -1) {
            str = "";
        } else {
            String substring = a2.substring(a3, a4);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str = substring;
        }
        Log.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", Integer.valueOf(i3), str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str4, Long.valueOf(j3), str5, Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i9));
        com.tencent.mm.api.i iVar = new com.tencent.mm.api.i();
        iVar.iG(i3);
        iVar.fx(str2);
        iVar.setCmdId(i2);
        if (str3 == null) {
            p.hyc();
        }
        iVar.fy(str3);
        iVar.bo(j2);
        iVar.setRetryInterval(i4);
        iVar.iH(i5);
        iVar.iI(i6);
        iVar.iJ(i7);
        iVar.iK(i8);
        iVar.fz(str4);
        iVar.Vr();
        iVar.a(aVar.heO);
        iVar.fA(str);
        rx rxVar = new rx();
        rxVar.KZn = j3;
        if (!Util.isNullOrNil(str5)) {
            rxVar.KZo = new b(Base64.decode(str5, 0));
        }
        iVar.a(rxVar);
        iVar.br(j4);
        iVar.bq(j5);
        iVar.Vs();
        iVar.iL(i9);
        bs bsVar = bs.OqA;
        String Vk = iVar.Vk();
        p.g(Vk, "item.functionMsgId");
        com.tencent.mm.api.i bkw = bs.bkw(Vk);
        if (bkw != null) {
            Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", bkw);
        } else {
            Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", iVar.Vk());
        }
        com.tencent.mm.v.a aVar2 = com.tencent.mm.v.a.heZ;
        com.tencent.mm.v.b pu = com.tencent.mm.v.a.pu(iVar.Vj());
        if (pu != null) {
            pu.a(heK, heM, bs.OqA, iVar, bkw, (long) deVar.CreateTime);
        }
        Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(114112);
    }

    @Override // com.tencent.mm.u.f
    public final void a(int i2, d dVar) {
        AppMethodBeat.i(114113);
        p.h(dVar, "task");
        Log.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + dVar.heU.Vk() + " op:" + i2 + " status:" + dVar.heU.getStatus());
        dVar.heV.a(heK, heM, dVar);
        AppMethodBeat.o(114113);
    }

    public static void awG() {
        AppMethodBeat.i(114114);
        Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
        bs bsVar = bs.OqA;
        for (T t : bs.gDb()) {
            Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", t);
            if (t.Vj() != -1) {
                com.tencent.mm.v.a aVar = com.tencent.mm.v.a.heZ;
                com.tencent.mm.v.b pu = com.tencent.mm.v.a.pu(t.Vj());
                if (pu != null) {
                    heK.a(t.Vj(), t, pu);
                }
            }
        }
        bs bsVar2 = bs.OqA;
        bs.gDc();
        AppMethodBeat.o(114114);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
    /* renamed from: com.tencent.mm.u.a$a  reason: collision with other inner class name */
    static final class C2069a {
        final de heO;
        final Map<String, String> values;

        public C2069a(de deVar, Map<String, String> map) {
            p.h(deVar, "addMsg");
            p.h(map, "values");
            AppMethodBeat.i(114110);
            this.heO = deVar;
            this.values = map;
            AppMethodBeat.o(114110);
        }
    }
}
