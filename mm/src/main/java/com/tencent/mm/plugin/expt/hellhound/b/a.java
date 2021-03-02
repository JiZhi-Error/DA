package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.b.a.a;
import com.tencent.mm.plugin.expt.hellhound.b.a.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi;", "", "()V", "Companion", "plugin-expt_release"})
public final class a {
    public static int sJD;
    private static int sJE;
    public static final i sJF = b.sJH;
    public static final C1022a sJG = new C1022a((byte) 0);

    public static final void cRc() {
        AppMethodBeat.i(221156);
        C1022a.Ht(2);
        AppMethodBeat.o(221156);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi$Companion;", "", "()V", "SCENE_GET_HELL_MANUAL_AUTH", "", "SCENE_GET_HELL_TIME_OUT", "TAG", "", "getHellEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "intervalHell", "lastUpdateTimeHell", "checkNeedUpdateHell", "", "scene", "resetCacheTimeHell", "resetLastUpdateTime", "updateConfig", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "updateHell", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.b.a$a  reason: collision with other inner class name */
    public static final class C1022a {
        private C1022a() {
        }

        public /* synthetic */ C1022a(byte b2) {
            this();
        }

        public static void Ht(int i2) {
            String str;
            AppMethodBeat.i(221152);
            if (!com.tencent.mm.plugin.expt.hellhound.a.cNu()) {
                AppMethodBeat.o(221152);
                return;
            }
            Log.i("HABBYGE-MALI.HellCgi", "updateHell: ".concat(String.valueOf(i2)));
            String cNE = com.tencent.mm.plugin.expt.hellhound.core.b.cNE();
            String str2 = com.tencent.mm.loader.j.a.BUILD_TAG;
            if (str2 == null) {
                str = "";
            } else {
                str = str2;
            }
            t azz = g.azz();
            p.g(cNE, "rversion");
            azz.b(new b(i2, cNE, str));
            AppMethodBeat.o(221152);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    static final class b implements i {
        public static final b sJH = new b();

        static {
            AppMethodBeat.i(221151);
            AppMethodBeat.o(221151);
        }

        b() {
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(221150);
            Log.i("HABBYGE-MALI.HellCgi", "getHellEnd: errType[" + i2 + "] errCode[" + i3 + "] errMsg[" + str + ']');
            if (qVar instanceof b) {
                C1022a aVar = a.sJG;
                a.sJD = 0;
                a.sJE = 0;
            }
            AppMethodBeat.o(221150);
        }
    }

    static {
        AppMethodBeat.i(221153);
        AppMethodBeat.o(221153);
    }

    public static final void cRa() {
        AppMethodBeat.i(221154);
        sJD = 0;
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_GET_HELL_LAST_TIME_SEC_INT, (Object) 0);
        AppMethodBeat.o(221154);
    }

    public static final void cRb() {
        AppMethodBeat.i(221155);
        if (!g.aAc()) {
            Log.w("HABBYGE-MALI.HellCgi", "account is not ready, don't get expt config");
            AppMethodBeat.o(221155);
        } else if (!MMApplicationContext.isMainProcess()) {
            Log.w("HABBYGE-MALI.HellCgi", "it is not mm process, why you call update expt?");
            AppMethodBeat.o(221155);
        } else {
            if (sJD <= 0) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(ar.a.USERINFO_GET_HELL_LAST_TIME_SEC_INT, (Object) 0);
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(221155);
                    throw tVar;
                }
                sJD = ((Integer) obj).intValue();
            }
            if (sJE <= 0) {
                e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                Object obj2 = aAh2.azQ().get(ar.a.USERINFO_GET_HELL_INTERVAL_SEC_INT, Integer.valueOf((int) LocalCache.TIME_DAY));
                if (obj2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(221155);
                    throw tVar2;
                }
                int intValue = ((Integer) obj2).intValue();
                sJE = intValue;
                if (intValue <= 3600) {
                    Log.w("HABBYGE-MALI.HellCgi", "interval is less than 1 hour, something warn here: " + sJE);
                    sJE = LocalCache.TIME_HOUR;
                } else if (sJE >= 604800) {
                    Log.w("HABBYGE-MALI.HellCgi", "interval is too big than 24 hours, something warn here: " + sJE);
                    sJE = LocalCache.TIME_DAY;
                }
            }
            long secondsToNow = Util.secondsToNow((long) sJD);
            Log.i("HABBYGE-MALI.HellCgi", "checkNeedUpdateHell: interval=" + sJE + ", secondsToNow=" + secondsToNow);
            if (secondsToNow >= ((long) sJE)) {
                C1022a.Ht(1);
            }
            AppMethodBeat.o(221155);
        }
    }

    public static final void a(boj boj) {
        boj boj2;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(221157);
        p.h(boj, "resp");
        b.a aVar = b.sJM;
        if (boj == null) {
            AppMethodBeat.o(221157);
            return;
        }
        Log.i("HABBYGE-MALI.HellResponseDao", "setResp...");
        boj cRe = b.a.cRe();
        if (cRe == null) {
            boj boj3 = new boj();
            boj3.LWz = boj.LWz;
            boj3.LWA = boj.LWA;
            Iterator<cfi> it = boj.LWB.iterator();
            while (it.hasNext()) {
                cfi next = it.next();
                if (!(next == null || next.cSx == 1)) {
                    boj3.LWB.add(next);
                    a.C1023a aVar2 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
                    a.C1023a.a(next.Mlu.id, next.Mlu.type, next.Mlu.vtY, next.dNA, next.Mlv);
                }
            }
            LinkedList<cfi> linkedList = boj3.LWB;
            p.g(linkedList, "respOld.jsonPackages");
            if (linkedList.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                boj2 = boj3;
            }
            AppMethodBeat.o(221157);
        }
        cRe.LWz = boj.LWz;
        cRe.LWA = boj.LWA;
        ArrayList arrayList = new ArrayList();
        Iterator<cfi> it2 = boj.LWB.iterator();
        while (it2.hasNext()) {
            cfi next2 = it2.next();
            if (next2 != null) {
                int size = cRe.LWB.size() - 1;
                while (true) {
                    if (size >= 0) {
                        cfi cfi = cRe.LWB.get(size);
                        p.g(cfi, "respOld.jsonPackages[index]");
                        cfi cfi2 = cfi;
                        if (p.j(next2.Mlu.id, cfi2.Mlu.id)) {
                            if (next2.cSx == 1) {
                                cRe.LWB.remove(size);
                                a.C1023a aVar3 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
                                String str = cfi2.Mlu.id;
                                int i2 = cfi2.Mlu.type;
                                if (str != null) {
                                    a.C1023a.are(str);
                                    switch (i2) {
                                        case 3:
                                            a.C1023a.a(str, "", (List<? extends cft>) null, true, false);
                                            break;
                                    }
                                }
                            } else {
                                cRe.LWB.set(size, next2);
                                a.C1023a aVar4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
                                a.C1023a.a(next2.Mlu.id, next2.Mlu.type, next2.Mlu.vtY, next2.dNA, next2.Mlv);
                            }
                            z = false;
                        } else {
                            size--;
                        }
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    arrayList.add(next2);
                    a.C1023a aVar5 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
                    a.C1023a.a(next2.Mlu.id, next2.Mlu.type, next2.Mlu.vtY, next2.dNA, next2.Mlv);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            cRe.LWB.addAll(arrayList);
        }
        if (cRe.LWB.isEmpty()) {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_resp_mkv_key", new byte[0]);
            a.C1023a aVar6 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_cgi_cc_dat", new byte[0]);
            a.C1023a.a("-100", "", (List<? extends cft>) null, true, false);
            AppMethodBeat.o(221157);
            return;
        }
        boj2 = cRe;
        try {
            if (boj2.BaseResponse == null) {
                boj2.BaseResponse = new BaseResponse();
                boj2.BaseResponse.Ret = 0;
                boj2.BaseResponse.ErrMsg = new dqi();
                dqi dqi = boj2.BaseResponse.ErrMsg;
                p.g(dqi, "resp.BaseResponse.ErrMsg");
                dqi.bhy("");
            }
            byte[] byteArray = boj2.toByteArray();
            p.g(byteArray, "resp.toByteArray()");
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_resp_mkv_key", byteArray);
            AppMethodBeat.o(221157);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellResponseDao", e2, "HellResponseDao, write: " + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(221157);
        }
    }
}
