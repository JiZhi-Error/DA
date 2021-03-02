package com.tencent.mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.h;
import com.tencent.mm.booter.i;
import com.tencent.mm.booter.m;
import com.tencent.mm.booter.n;
import com.tencent.mm.bs.a;
import com.tencent.mm.bs.b;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.modelstat.g;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.j;
import java.util.LinkedList;
import java.util.List;

public final class s extends IListener<ps> {
    public s() {
        AppMethodBeat.i(161308);
        this.__eventId = ps.class.getName().hashCode();
        AppMethodBeat.o(161308);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ps psVar) {
        boolean z;
        AppMethodBeat.i(22434);
        if (ay.a.iDs != null) {
            ay.a.iDs.aVq();
        }
        if ((bg.aAc() && !bg.azj() && (z.aUl() & 16) == 0) && i.akM()) {
            bg.aVF();
            ao azQ = c.azQ();
            int nullAsNil = Util.nullAsNil((Integer) azQ.get(67073, (Object) null));
            int nullAsNil2 = Util.nullAsNil((Integer) azQ.get(67074, (Object) null));
            int nullAsNil3 = Util.nullAsNil((Integer) azQ.get(67075, (Object) null));
            int nullAsNil4 = Util.nullAsNil((Integer) azQ.get(67076, (Object) null));
            bg.aVF();
            com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ = c.aSQ();
            int eF = aSQ.eF("medianote", 1);
            int eF2 = aSQ.eF("medianote", 3);
            int eF3 = aSQ.eF("medianote", 34);
            int eF4 = aSQ.eF("medianote", 43);
            if (eF - nullAsNil > 0) {
                cna cna = new cna();
                cna.Msx = eF - nullAsNil;
                cna.Msy = 1;
                azQ.set(67073, Integer.valueOf(eF));
            }
            if (eF2 - nullAsNil2 > 0) {
                cna cna2 = new cna();
                cna2.Msx = eF2 - nullAsNil2;
                cna2.Msy = 3;
                azQ.set(67074, Integer.valueOf(eF2));
            }
            if (eF3 - nullAsNil3 > 0) {
                cna cna3 = new cna();
                cna3.Msx = eF3 - nullAsNil3;
                cna3.Msy = 34;
                azQ.set(67075, Integer.valueOf(eF3));
            }
            if (eF4 - nullAsNil4 > 0) {
                cna cna4 = new cna();
                cna4.Msx = eF4 - nullAsNil4;
                cna4.Msy = 43;
                azQ.set(67076, Integer.valueOf(eF4));
            }
            bg.aVF();
            c.azQ().set(66817, Long.valueOf(Util.nowSecond()));
        }
        j.run();
        a.run();
        bg.aVF();
        boolean nullAs = Util.nullAs((Boolean) c.azQ().get(67841, (Object) null), true);
        if (!(l.bnZ() == l.a.SUCC || l.bnZ() == l.a.SUCC_UNLOAD)) {
            nullAs = false;
        }
        if (nullAs) {
            Log.d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List<com.tencent.mm.plugin.account.friend.a.a> SV = com.tencent.mm.plugin.account.a.getAddrUploadStg().SV("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + Util.escapeSqlValue("") + "\" )");
            Log.d("MicroMsg.PostTaskUpdateCtRemark", "list " + SV.size());
            for (int i2 = 0; i2 < SV.size(); i2++) {
                String username = SV.get(i2).getUsername();
                String trim = SV.get(i2).bnK().trim();
                if (username != null && !username.equals("") && trim != null && !trim.equals("")) {
                    bg.aVF();
                    as Kn = c.aSN().Kn(username);
                    if (com.tencent.mm.contact.c.oR(Kn.field_type) && (Kn.field_conRemark == null || Kn.field_conRemark.equals(""))) {
                        Log.d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        ab.c(Kn, trim);
                    }
                }
            }
            bg.aVF();
            c.azQ().set(67841, Boolean.FALSE);
        }
        Log.d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
        cf.aWl().aWm();
        LinkedList linkedList = new LinkedList();
        int nullAs2 = Util.nullAs((Integer) bg.aVD().get(19), 0);
        for (int i3 = 0; i3 < nullAs2; i3++) {
            cga cga = new cga();
            cga.Cya = 31;
            cga.Cyk = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            linkedList.add(cga);
        }
        int nullAs3 = Util.nullAs((Integer) bg.aVD().get(20), 0);
        for (int i4 = 0; i4 < nullAs3; i4++) {
            cga cga2 = new cga();
            cga2.Cya = 31;
            cga2.Cyk = "1";
            linkedList.add(cga2);
        }
        if (linkedList.size() > 0) {
            cf.b(linkedList);
            bg.aVD().set(19, 0);
            bg.aVD().set(20, 0);
        }
        n.run();
        h.run();
        if (bg.aAc() && !bg.azj()) {
            if (Util.isNullOrNil(com.tencent.mm.bs.c.gtd())) {
                br.KA("ver" + d.KyO);
            } else {
                bg.aVF();
                if (Util.secondsToNow(Util.nullAs((Long) c.azQ().get(77833, (Object) null), 0)) * 1000 >= 604800000) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10719, com.tencent.mm.bs.c.gsZ(), com.tencent.mm.bs.c.gta(), com.tencent.mm.bs.c.gtb(), com.tencent.mm.bs.c.getRomInfo(), com.tencent.mm.bs.c.gtc(), "", com.tencent.mm.bs.c.gtd());
                    bg.aVF();
                    c.azQ().set(77833, Long.valueOf(Util.nowSecond()));
                    Log.d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                }
            }
        }
        if (bg.aAc() && !bg.azj()) {
            long nowSecond = Util.nowSecond();
            bg.aVF();
            if (Util.nullAs((Long) c.azQ().get(331777, (Object) null), 0) < nowSecond) {
                bg.aVF();
                c.azQ().set(331777, Long.valueOf(nowSecond + 259200));
                com.tencent.mm.plugin.report.b.d.eOz();
            }
            com.tencent.mm.plugin.report.b.d.E(3, 0, "");
        }
        b.run();
        if (!bg.aAc()) {
            Log.e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
        } else {
            bg.aVF();
            long nullAsNil5 = Util.nullAsNil((Long) c.azQ().get(74, (Object) null));
            if (10010 == ac.jOC && ac.jOD > 0) {
                nullAsNil5 = Util.nowSecond() - ((long) ac.jOD);
                Log.d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", Integer.valueOf(ac.jOD), Long.valueOf(nullAsNil5));
                ac.jOD = 0;
            }
            long nowSecond2 = Util.nowSecond();
            Log.d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", Long.valueOf(nowSecond2), Long.valueOf(nullAsNil5), Long.valueOf(nowSecond2 - nullAsNil5));
            if ((nowSecond2 - nullAsNil5) * 1000 >= Util.MILLSECONDS_OF_DAY) {
                bg.aVF();
                c.azQ().set(74, Long.valueOf(nowSecond2));
                if (q.bgo() == null) {
                    Log.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                } else {
                    long nowMilliSecond = (Util.nowMilliSecond() / Util.MILLSECONDS_OF_DAY) - 1;
                    k tU = q.bgo().tU((int) nowMilliSecond);
                    if (tU == null || tU.jog != ((int) nowMilliSecond)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(tU == null ? -1 : tU.jog);
                        objArr[1] = Long.valueOf(nowMilliSecond);
                        Log.e("MicroMsg.PostTaskReportDataFlow", "ERR: NetStatInfo:%d lastDate:%d", objArr);
                    } else if (q.bgm() == null) {
                        Log.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                    } else {
                        g.a bgh = q.bgm().bgh();
                        if (bgh == null) {
                            Log.w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                            bgh = new g.a();
                        }
                        Log.i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", Long.valueOf(nowMilliSecond), Integer.valueOf(tU.jog), Long.valueOf(tU.jos), Long.valueOf(tU.joE), Long.valueOf(tU.jor), Long.valueOf(tU.joD), Long.valueOf(tU.joq), Long.valueOf(tU.joC), Long.valueOf(tU.jop), Long.valueOf(tU.joB), Integer.valueOf(bgh.job), Integer.valueOf(bgh.subType), bgh.ispName, bgh.extraInfo);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10900, Long.valueOf((nowMilliSecond * Util.MILLSECONDS_OF_DAY) / 1000), Long.valueOf(tU.jos), Long.valueOf(tU.joE), Long.valueOf(tU.jor), Long.valueOf(tU.joD), Long.valueOf(tU.joq), Long.valueOf(tU.joC), Long.valueOf(tU.jop), Long.valueOf(tU.joB), Integer.valueOf(bgh.job), Integer.valueOf(bgh.subType), bgh.ispName, bgh.extraInfo);
                    }
                }
            }
        }
        ah.run();
        bg.aVF();
        if (Util.milliSecondsToNow(Util.nullAsNil((Long) c.azQ().get(282881, (Object) null))) > 172800000) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bg.aVF();
            c.azQ().set(282881, Long.valueOf(Util.nowMilliSecond()));
            EventCenter.instance.publish(new sr());
        }
        if (bg.aAc() && !bg.azj()) {
            long nowSecond3 = Util.nowSecond();
            bg.aVF();
            long nullAs4 = Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, (Object) null), 0);
            com.tencent.mm.kernel.g.aAf();
            String salt = com.tencent.mm.kernel.a.getSalt();
            if (nullAs4 < nowSecond3 || Util.isNullOrNil(salt)) {
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, Long.valueOf(604800 + nowSecond3));
                String aTY = z.aTY();
                if (!TextUtils.isEmpty(aTY)) {
                    bg.azz().a(new p(aTY), 0);
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(nullAs4 < nowSecond3);
                objArr2[1] = Boolean.valueOf(Util.isNullOrNil(salt));
                Log.i("MicroMsg.PostTaskGetProfile", "expire: %b or salt is empty:%b", objArr2);
            }
        }
        if (bg.aAc() && !bg.azj()) {
            long nowSecond4 = Util.nowSecond();
            bg.aVF();
            if (Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, (Object) null), 0) < nowSecond4) {
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, Long.valueOf((Util.getBeginTimeOfToday() / 1000) + 86400));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    if (defaultAdapter.getState() == 12) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11921, 1);
                    } else if (defaultAdapter.getState() == 10) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11921, 0);
                    }
                }
            }
        }
        com.tencent.mm.booter.l.run();
        m.run();
        com.tencent.mm.booter.k.run();
        com.tencent.mm.booter.j.run();
        AppMethodBeat.o(22434);
        return false;
    }
}
