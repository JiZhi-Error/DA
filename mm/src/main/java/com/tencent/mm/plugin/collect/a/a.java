package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.l;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.g;
import com.tencent.mm.plugin.collect.model.p;
import com.tencent.mm.plugin.collect.model.u;
import com.tencent.mm.plugin.collect.model.v;
import com.tencent.mm.plugin.collect.model.voice.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a implements bd {
    private IListener<l> qvA = new IListener<l>() {
        /* class com.tencent.mm.plugin.collect.a.a.AnonymousClass3 */

        {
            AppMethodBeat.i(160789);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(160789);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(63759);
            a.this.qvz = lVar.dCi.isActive;
            AppMethodBeat.o(63759);
            return false;
        }
    };
    private cj.a qvw = new cj.a() {
        /* class com.tencent.mm.plugin.collect.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(63757);
            a.czp();
            if (a.czq() != null) {
                String a2 = z.a(aVar.heO.KHn);
                a.czp();
                d czq = a.czq();
                long j2 = (long) aVar.heO.CreateTime;
                Log.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(a2)));
                if (Util.isNullOrNil(a2)) {
                    Log.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
                    AppMethodBeat.o(63757);
                    return;
                }
                Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
                int i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), 0);
                if (i2 == 9 || i2 == 26) {
                    u uVar = new u();
                    uVar.username = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.username"));
                    uVar.qwJ = Util.getDouble(parseXml.get(".sysmsg.paymsg.fee"), 0.0d) / 100.0d;
                    uVar.dFv = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.feetype"));
                    uVar.qwL = Util.getInt(parseXml.get(".sysmsg.paymsgtimestamp"), (int) Util.nowSecond());
                    uVar.dDM = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.transid"));
                    uVar.gCv = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.displayname"));
                    uVar.scene = Util.getInt(parseXml.get(".sysmsg.paymsg.scene"), 1);
                    uVar.status = Util.getInt(parseXml.get(".sysmsg.paymsg.status"), 0);
                    uVar.msgType = i2;
                    uVar.qwM = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.outtradeno"));
                    uVar.type = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.type"));
                    String nullAsNil = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.voice_content"));
                    String nullAsNil2 = Util.nullAsNil(parseXml.get(".sysmsg.paymsg.expire_voice_timestamp"));
                    int i3 = Util.getInt(parseXml.get(".sysmsg.paymsg.need_failover"), 1);
                    for (d.a aVar2 : czq.pQG) {
                        if (aVar2 != null) {
                            aVar2.a(uVar);
                        }
                    }
                    if (uVar.status == 1) {
                        ci ciVar = new ci();
                        ciVar.dFt.dFu = (int) Math.round(uVar.qwJ * 100.0d);
                        ciVar.dFt.dFv = uVar.dFv;
                        ciVar.dFt.dFx = uVar.type;
                        ciVar.dFt.dFw = uVar.qwM;
                        ciVar.dFt.gY = cl.aWz() - (j2 * 1000);
                        ciVar.dFt.source = 1;
                        ciVar.dFt.dFy = nullAsNil;
                        ciVar.dFt.dFz = nullAsNil2;
                        if (i3 == 0) {
                            ciVar.dFt.dFA = false;
                        } else {
                            ciVar.dFt.dFA = true;
                        }
                        EventCenter.instance.publish(ciVar);
                    }
                    AppMethodBeat.o(63757);
                    return;
                }
                Log.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i2)));
                AppMethodBeat.o(63757);
                return;
            }
            Log.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
            AppMethodBeat.o(63757);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private g qvx = new g();
    private v qvy = new v();
    public boolean qvz = false;

    public a() {
        AppMethodBeat.i(63760);
        AppMethodBeat.o(63760);
    }

    public static a czp() {
        AppMethodBeat.i(63761);
        a aVar = (a) y.at(a.class);
        AppMethodBeat.o(63761);
        return aVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(63762);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.qvw, true);
        this.qvA.alive();
        g gVar = this.qvx;
        gVar.alive();
        gVar.qvM = new ConcurrentLinkedQueue<>();
        com.tencent.mm.plugin.collect.model.voice.a czG = com.tencent.mm.plugin.collect.model.voice.a.czG();
        czG.qwZ = gVar;
        czG.qxa = new a.b(czG.qwZ);
        com.tencent.mm.kernel.g.aAh().azQ().add(czG);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1384, gVar);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1317, gVar);
        this.qvy.alive();
        AppMethodBeat.o(63762);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(63763);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.qvw, true);
        g gVar = this.qvx;
        gVar.dead();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1384, gVar);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1317, gVar);
        g.czv();
        com.tencent.mm.plugin.collect.model.voice.a czG = com.tencent.mm.plugin.collect.model.voice.a.czG();
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
        try {
            if (czG.qwY != null) {
                czG.qwY.qxv.destroy();
            }
        } catch (Exception e2) {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy() synthesizer.destroy() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
        if (czG.qxe != null) {
            czG.qxe.dead();
        }
        if (czG.qxf != null) {
            czG.qxf.dead();
        }
        com.tencent.mm.kernel.g.aAh().azQ().remove(czG);
        com.tencent.mm.plugin.collect.model.voice.a.qwT = false;
        this.qvy.dead();
        this.qvA.dead();
        AppMethodBeat.o(63763);
    }

    public static d czq() {
        AppMethodBeat.i(63764);
        com.tencent.mm.kernel.g.aAf().azk();
        d dVar = d.INSTANCE;
        AppMethodBeat.o(63764);
        return dVar;
    }

    public static boolean czr() {
        AppMethodBeat.i(63765);
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_F2F_RING_TONE_STRING, "");
        long aUd = com.tencent.mm.model.z.aUd();
        if (!Util.isNullOrNil(str) && !str.equals("in.caf")) {
            Log.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
            com.tencent.mm.kernel.g.aAh().azQ().set(147457, Long.valueOf(aUd | 32768));
            cqb cqb = new cqb();
            cqb.Cyb = 1;
            ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(209, cqb));
            AppMethodBeat.o(63765);
            return true;
        } else if ((aUd & 32768) != 0) {
            AppMethodBeat.o(63765);
            return true;
        } else {
            AppMethodBeat.o(63765);
            return false;
        }
    }

    public final void czs() {
        AppMethodBeat.i(63766);
        akK("cash.caf");
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_F2F_RING_TONE_STRING, "cash.caf");
        AppMethodBeat.o(63766);
    }

    public final void czt() {
        AppMethodBeat.i(63767);
        akK("in.caf");
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_F2F_RING_TONE_STRING, "in.caf");
        AppMethodBeat.o(63767);
    }

    private void akK(String str) {
        AppMethodBeat.i(63768);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(304, new i() {
            /* class com.tencent.mm.plugin.collect.a.a.AnonymousClass2 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(63758);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.b(304, this);
                if (!(i2 == 0 && i3 == 0)) {
                    Log.i("MicroMsg.SubCoreCollect", "set sound fail!");
                }
                AppMethodBeat.o(63758);
            }
        });
        p pVar = new p(Util.nullAs(str, ""));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(pVar, 0);
        AppMethodBeat.o(63768);
    }
}
