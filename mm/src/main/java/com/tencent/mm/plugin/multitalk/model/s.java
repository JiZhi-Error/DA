package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.f;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.c.b;
import com.tencent.mm.plugin.multitalk.model.d;
import com.tencent.mm.plugin.multitalk.ui.widget.m;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.multitalk.ui.widget.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.eri;
import com.tencent.mm.protocal.protobuf.esd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

public final class s implements d {
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private List<d.a> listeners = new ArrayList();
    private LinkedList<String> zNv = null;
    private LinkedList<String> zNw = new LinkedList<>();
    private LinkedList<String> zNx = new LinkedList<>();

    public final LinkedList<String> enT() {
        AppMethodBeat.i(114540);
        if (this.zNx == null) {
            this.zNx = new LinkedList<>();
        }
        LinkedList<String> linkedList = this.zNx;
        AppMethodBeat.o(114540);
        return linkedList;
    }

    public s() {
        AppMethodBeat.i(114541);
        AppMethodBeat.o(114541);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final synchronized void a(d.a aVar) {
        AppMethodBeat.i(114542);
        this.listeners.add(aVar);
        AppMethodBeat.o(114542);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final synchronized void b(d.a aVar) {
        AppMethodBeat.i(114543);
        this.listeners.remove(aVar);
        AppMethodBeat.o(114543);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final void aFG(final String str) {
        AppMethodBeat.i(114544);
        if (ab.Eq(str) && aFJ(str)) {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            g.aAh().azQ().get(2, (Object) null);
            if (ac.eom().zME != null && ac.eom().zME.zHE.equals(str)) {
                Log.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                ac.eom().j(false, false, false);
            }
            this.handler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.multitalk.model.s.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(114538);
                    s.this.aFO(str);
                    rh rhVar = new rh();
                    rhVar.dXY.type = 2;
                    EventCenter.instance.publish(rhVar);
                    AppMethodBeat.o(114538);
                }
            }, 2000);
        }
        AppMethodBeat.o(114544);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean aFH(String str) {
        AppMethodBeat.i(114545);
        f aFI = ac.eoi().aFI(str);
        if (aFI == null || aFI.field_wxGroupId == null || !aFI.field_wxGroupId.equals(str)) {
            AppMethodBeat.o(114545);
            return false;
        } else if (System.currentTimeMillis() - aFI.field_createTime > 21600000) {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
            aFO(str);
            AppMethodBeat.o(114545);
            return false;
        } else {
            AppMethodBeat.o(114545);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean aFJ(String str) {
        AppMethodBeat.i(114546);
        if (this.zNv == null) {
            enU();
        }
        if (this.zNv == null || !this.zNv.contains(str)) {
            AppMethodBeat.o(114546);
            return false;
        }
        AppMethodBeat.o(114546);
        return true;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final List<String> aFK(String str) {
        AppMethodBeat.i(114547);
        LinkedList<b> aGq = ac.eoj().aGq(str);
        LinkedList linkedList = new LinkedList();
        for (b bVar : aGq) {
            linkedList.add(bVar.field_userName);
        }
        AppMethodBeat.o(114547);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean iL(String str, String str2) {
        AppMethodBeat.i(114548);
        if (ac.eoj().iP(str, str2) != null) {
            AppMethodBeat.o(114548);
            return true;
        }
        AppMethodBeat.o(114548);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean ems() {
        AppMethodBeat.i(114550);
        boolean ems = ac.eom().ems();
        AppMethodBeat.o(114550);
        return ems;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean emr() {
        AppMethodBeat.i(114551);
        boolean emr = ac.eom().emr();
        AppMethodBeat.o(114551);
        return emr;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean emp() {
        AppMethodBeat.i(114552);
        if (!ac.eom().ems() || !(ac.eom().zMD == o.Starting || ac.eom().zMD == o.Creating)) {
            AppMethodBeat.o(114552);
            return false;
        }
        AppMethodBeat.o(114552);
        return true;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean aFL(String str) {
        m mVar;
        m mVar2;
        AppMethodBeat.i(114553);
        n eon = ac.eon();
        if (str != null) {
            if (eon.intent != null) {
                Intent intent = eon.intent;
                String stringExtra = intent != null ? intent.getStringExtra("enterMainUiWxGroupId") : null;
                m mVar3 = eon.zTM;
                if (com.tencent.pb.common.c.f.eP(stringExtra) || !p.j(str, stringExtra) || !(mVar3 instanceof m)) {
                    AppMethodBeat.o(114553);
                    return false;
                } else if (mVar3.getVisibility() == 0) {
                    AppMethodBeat.o(114553);
                    return true;
                } else {
                    AppMethodBeat.o(114553);
                    return false;
                }
            } else {
                AppMethodBeat.o(114553);
                return false;
            }
        } else if (eon.zTM == null || (mVar = eon.zTM) == null || mVar.getVisibility() != 0 || (mVar2 = eon.zTM) == null || !mVar2.isShown()) {
            AppMethodBeat.o(114553);
            return false;
        } else {
            AppMethodBeat.o(114553);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean emq() {
        AppMethodBeat.i(114554);
        if (com.tencent.mm.plugin.voip.b.m.isVoipStarted() || ac.eom().emr() || ac.eom().ems() || ac.eom().ent()) {
            AppMethodBeat.o(114554);
            return true;
        }
        AppMethodBeat.o(114554);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final String iN(String str, String str2) {
        AppMethodBeat.i(114555);
        b iP = ac.eoj().iP(str, str2);
        if (iP != null) {
            String str3 = iP.field_inviteUserName;
            AppMethodBeat.o(114555);
            return str3;
        }
        AppMethodBeat.o(114555);
        return null;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final String getDisplayName(String str) {
        AppMethodBeat.i(114556);
        String displayName = aa.getDisplayName(str);
        AppMethodBeat.o(114556);
        return displayName;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final void aFQ(String str) {
        AppMethodBeat.i(114559);
        if (this.zNw == null) {
            this.zNw = new LinkedList<>();
            if (!this.zNw.contains(str)) {
                this.zNw.add(str);
                AppMethodBeat.o(114559);
                return;
            }
        } else if (!this.zNw.contains(str)) {
            this.zNw.add(str);
        }
        AppMethodBeat.o(114559);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final int iM(String str, String str2) {
        AppMethodBeat.i(114562);
        b iP = ac.eoj().iP(str, str2);
        if (iP != null) {
            int i2 = iP.field_status;
            AppMethodBeat.o(114562);
            return i2;
        }
        AppMethodBeat.o(114562);
        return 30;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final void aFO(String str) {
        AppMethodBeat.i(114563);
        if (com.tencent.pb.common.c.f.isNullOrEmpty(str)) {
            Log.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            AppMethodBeat.o(114563);
            return;
        }
        Log.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", str);
        gC(str);
        ac.eoj().gC(str);
        aGh(str);
        AppMethodBeat.o(114563);
    }

    public final void a(String str, a.bh bhVar) {
        AppMethodBeat.i(239419);
        Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", str);
        c(str, bhVar);
        if (b(str, bhVar)) {
            aGi(str);
        }
        aGh(str);
        AppMethodBeat.o(239419);
    }

    public final void a(String str, eri eri) {
        AppMethodBeat.i(239420);
        Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", str);
        c(str, eri);
        if (d(str, eri)) {
            aGi(str);
        }
        aGh(str);
        AppMethodBeat.o(239420);
    }

    public final void aGf(String str) {
        AppMethodBeat.i(114565);
        if (this.zNw == null) {
            this.zNw = new LinkedList<>();
            AppMethodBeat.o(114565);
            return;
        }
        this.zNw.remove(str);
        AppMethodBeat.o(114565);
    }

    public final boolean aGg(String str) {
        AppMethodBeat.i(114566);
        if (this.zNw == null) {
            AppMethodBeat.o(114566);
            return false;
        }
        boolean contains = this.zNw.contains(str);
        AppMethodBeat.o(114566);
        return contains;
    }

    public final void aGh(final String str) {
        AppMethodBeat.i(114567);
        for (final d.a aVar : this.listeners) {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.multitalk.model.s.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(114539);
                    aVar.aFR(str);
                    AppMethodBeat.o(114539);
                }
            });
        }
        AppMethodBeat.o(114567);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final f aFI(String str) {
        AppMethodBeat.i(261697);
        f aFI = ac.eoi().aFI(str);
        AppMethodBeat.o(261697);
        return aFI;
    }

    public final void enU() {
        AppMethodBeat.i(114569);
        LinkedList<f> eot = ac.eoi().eot();
        Log.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.zNv = new LinkedList<>();
        Iterator<f> it = eot.iterator();
        while (it.hasNext()) {
            this.zNv.add(it.next().field_wxGroupId);
        }
        rh rhVar = new rh();
        rhVar.dXY.type = 1;
        EventCenter.instance.publish(rhVar);
        AppMethodBeat.o(114569);
    }

    private void aGi(String str) {
        AppMethodBeat.i(114570);
        Log.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(str)));
        if (this.zNv == null) {
            enU();
            if (this.zNv != null) {
                this.zNv.add(str);
            }
        } else if (!this.zNv.contains(str)) {
            this.zNv.add(str);
            AppMethodBeat.o(114570);
            return;
        }
        AppMethodBeat.o(114570);
    }

    private static boolean b(String str, a.bh bhVar) {
        int i2 = 0;
        AppMethodBeat.i(239422);
        if (bhVar == null) {
            AppMethodBeat.o(239422);
            return false;
        }
        f fVar = new f();
        fVar.field_wxGroupId = str;
        fVar.field_groupId = bhVar.groupId;
        fVar.field_roomId = bhVar.GXO;
        fVar.field_roomKey = bhVar.GXP;
        fVar.field_routeId = bhVar.RDt;
        fVar.field_inviteUserName = bhVar.RGL;
        a.bb[] bbVarArr = bhVar.REK;
        if (bbVarArr.length > 0) {
            i2 = bbVarArr.length;
        }
        fVar.field_memberCount = i2;
        fVar.field_createTime = System.currentTimeMillis();
        fVar.field_ilinkRoomId = 0;
        if (ac.eoi().aFI(str) == null) {
            boolean a2 = ac.eoi().a(fVar);
            AppMethodBeat.o(239422);
            return a2;
        }
        boolean b2 = ac.eoi().b(fVar);
        AppMethodBeat.o(239422);
        return b2;
    }

    private static boolean c(String str, a.bh bhVar) {
        AppMethodBeat.i(239423);
        if (bhVar == null) {
            AppMethodBeat.o(239423);
            return false;
        }
        boolean z = true;
        a.bb[] bbVarArr = bhVar.REK;
        if (bbVarArr == null || bbVarArr.length <= 0) {
            AppMethodBeat.o(239423);
            return true;
        }
        ac.eoj().gC(str);
        for (a.bb bbVar : bbVarArr) {
            b bVar = new b();
            bVar.field_wxGroupId = str;
            bVar.field_inviteUserName = bbVar.RGr;
            bVar.field_memberUuid = (long) bbVar.KBb;
            bVar.field_userName = bbVar.dLN;
            bVar.field_status = bbVar.status;
            if (!ac.eoj().a(bVar)) {
                Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, bbVar.dLN, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName);
                z = false;
            }
            Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, bbVar.dLN, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName);
        }
        AppMethodBeat.o(239423);
        return z;
    }

    static boolean d(String str, a.bh bhVar) {
        boolean z;
        AppMethodBeat.i(239424);
        if (bhVar == null) {
            AppMethodBeat.o(239424);
            return false;
        }
        a.bb[] bbVarArr = bhVar.REK;
        LinkedList linkedList = new LinkedList();
        for (a.bb bbVar : bbVarArr) {
            linkedList.add(bbVar.dLN);
        }
        String str2 = (String) g.aAh().azQ().get(2, (Object) null);
        if (str2 == null) {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            b(str, bhVar);
            AppMethodBeat.o(239424);
            return true;
        }
        LinkedList<b> aGq = ac.eoj().aGq(str);
        LinkedList linkedList2 = new LinkedList();
        b bVar = null;
        for (b bVar2 : aGq) {
            linkedList2.add(bVar2.field_userName);
            if (!bVar2.field_userName.equals(str2)) {
                bVar2 = bVar;
            }
            bVar = bVar2;
        }
        if (bVar == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (a.bb bbVar2 : bbVarArr) {
                if (!(bbVar2.dLN == null || !bbVar2.dLN.equals(str2) || bbVar2.status == bVar.field_status)) {
                    b bVar3 = new b();
                    bVar3.field_wxGroupId = str;
                    bVar3.field_inviteUserName = bbVar2.RGr;
                    bVar3.field_memberUuid = (long) bbVar2.KBb;
                    bVar3.field_userName = bbVar2.dLN;
                    bVar3.field_status = bbVar2.status;
                    if (!ac.eoj().a(bVar3)) {
                        Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, bbVar2.dLN, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName);
                        z = false;
                    }
                    Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, bbVar2.dLN, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName);
                }
            }
        }
        boolean z2 = z;
        for (a.bb bbVar3 : bbVarArr) {
            if (!linkedList2.contains(bbVar3.dLN)) {
                b bVar4 = new b();
                bVar4.field_wxGroupId = str;
                bVar4.field_inviteUserName = bbVar3.RGr;
                bVar4.field_memberUuid = (long) bbVar3.KBb;
                bVar4.field_userName = bbVar3.dLN;
                bVar4.field_status = bbVar3.status;
                if (!ac.eoj().a(bVar4)) {
                    Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, bbVar3.dLN, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName);
                    z2 = false;
                }
                Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, bbVar3.dLN, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName);
            }
        }
        Iterator it = linkedList2.iterator();
        boolean z3 = z2;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (!linkedList.contains(str3)) {
                if (ac.eoj().fr(str, str3)) {
                    Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str3);
                } else {
                    z3 = false;
                    Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str3);
                }
            }
            z3 = z3;
        }
        AppMethodBeat.o(239424);
        return z3;
    }

    public static boolean b(String str, eri eri) {
        AppMethodBeat.i(239425);
        boolean z = true;
        LinkedList<esd> linkedList = eri.NoY;
        LinkedList linkedList2 = new LinkedList();
        Iterator<esd> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add(it.next().Npo.username);
        }
        String str2 = (String) g.aAh().azQ().get(2, (Object) null);
        if (str2 == null) {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            d(str, eri);
            AppMethodBeat.o(239425);
            return true;
        }
        LinkedList<b> aGq = ac.eoj().aGq(str);
        LinkedList linkedList3 = new LinkedList();
        b bVar = null;
        for (b bVar2 : aGq) {
            linkedList3.add(bVar2.field_userName);
            if (!bVar2.field_userName.equals(str2)) {
                bVar2 = bVar;
            }
            bVar = bVar2;
        }
        if (bVar != null && linkedList2.contains(str2)) {
            Iterator<esd> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                esd next = it2.next();
                int i2 = 20;
                if (next.status == 1) {
                    i2 = 10;
                }
                if (next.status == 2 || next.status == 3) {
                    i2 = 1;
                }
                if (!(next.Npo.username == null || !next.Npo.username.equals(str2) || next.status == bVar.field_status)) {
                    b bVar3 = new b();
                    bVar3.field_wxGroupId = str;
                    bVar3.field_inviteUserName = eri.Npb;
                    bVar3.field_memberUuid = 0;
                    bVar3.field_userName = next.Npo.username;
                    bVar3.field_status = i2;
                    if (!ac.eoj().b(bVar3)) {
                        Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, next.Npo.username, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName);
                        z = false;
                    }
                    Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", str, next.Npo.username, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName, Integer.valueOf(bVar3.field_status));
                }
                z = z;
            }
        }
        Iterator<esd> it3 = linkedList.iterator();
        while (it3.hasNext()) {
            esd next2 = it3.next();
            if (!linkedList3.contains(next2.Npo.username)) {
                b bVar4 = new b();
                bVar4.field_wxGroupId = str;
                bVar4.field_inviteUserName = eri.Npb;
                bVar4.field_memberUuid = 0;
                bVar4.field_userName = next2.Npo.username;
                bVar4.field_status = 20;
                if (next2.status == 1) {
                    bVar4.field_status = 10;
                }
                if (next2.status == 2 || next2.status == 3) {
                    bVar4.field_status = 1;
                }
                if (!ac.eoj().b(bVar4)) {
                    Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, next2.Npo.username, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName);
                    z = false;
                }
                Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", str, next2.Npo.username, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName, Integer.valueOf(bVar4.field_status));
            }
        }
        Iterator it4 = linkedList3.iterator();
        while (it4.hasNext()) {
            String str3 = (String) it4.next();
            if (!linkedList2.contains(str3)) {
                if (ac.eoj().fr(str, str3)) {
                    Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str3);
                } else {
                    z = false;
                    Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str3);
                }
            }
        }
        AppMethodBeat.o(239425);
        return z;
    }

    private static boolean c(String str, eri eri) {
        AppMethodBeat.i(239426);
        if (eri == null) {
            AppMethodBeat.o(239426);
            return false;
        }
        LinkedList<esd> linkedList = eri.NoY;
        if (linkedList == null || linkedList.size() <= 0) {
            AppMethodBeat.o(239426);
            return true;
        }
        ac.eoj().gC(str);
        Iterator<esd> it = linkedList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            esd next = it.next();
            b bVar = new b();
            bVar.field_wxGroupId = str;
            bVar.field_inviteUserName = eri.Npb;
            bVar.field_memberUuid = 0;
            bVar.field_userName = next.Npo.username;
            bVar.field_status = next.status;
            bVar.field_status = 20;
            if (next.status == 1) {
                bVar.field_status = 10;
            }
            if (next.status == 2 || next.status == 3) {
                bVar.field_status = 1;
            }
            if (!ac.eoj().b(bVar)) {
                Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, next.Npo.username, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName);
                z = false;
            }
            Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", str, next.Npo.username, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName, Integer.valueOf(bVar.field_status));
        }
        AppMethodBeat.o(239426);
        return z;
    }

    private static boolean d(String str, eri eri) {
        int i2 = 0;
        AppMethodBeat.i(239427);
        if (eri == null) {
            AppMethodBeat.o(239427);
            return false;
        }
        f fVar = new f();
        fVar.field_wxGroupId = str;
        fVar.field_groupId = eri.NoX;
        fVar.field_roomId = (int) eri.Lnw;
        fVar.field_roomKey = 0;
        fVar.field_routeId = 0;
        fVar.field_inviteUserName = eri.Npb;
        fVar.field_ilinkRoomId = eri.Lnw;
        LinkedList<esd> linkedList = eri.NoY;
        if (linkedList.size() > 0) {
            i2 = linkedList.size();
        }
        fVar.field_memberCount = i2;
        fVar.field_createTime = System.currentTimeMillis();
        if (ac.eoi().aFI(str) == null) {
            boolean a2 = ac.eoi().a(fVar);
            AppMethodBeat.o(239427);
            return a2;
        }
        boolean b2 = ac.eoi().b(fVar);
        AppMethodBeat.o(239427);
        return b2;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean gC(String str) {
        AppMethodBeat.i(114549);
        if (this.zNv != null) {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(str)));
            this.zNv.remove(str);
        } else {
            enU();
        }
        boolean gC = ac.eoi().gC(str);
        AppMethodBeat.o(114549);
        return gC;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean cC(Context context) {
        AppMethodBeat.i(114557);
        boolean cC = com.tencent.mm.q.a.cC(context);
        AppMethodBeat.o(114557);
        return cC;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean aFP(String str) {
        AppMethodBeat.i(114558);
        f aFI = ac.eoi().aFI(str);
        if (aFI == null) {
            AppMethodBeat.o(114558);
            return false;
        } else if (ac.eom().aFW(str)) {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "ilink reject call, roomid:" + aFI.field_roomId + " wxgroupid:" + str + " ilinkroomid:" + aFI.field_ilinkRoomId);
            com.tencent.mm.plugin.multitalk.b.p.INSTANCE.Rb(1);
            AppMethodBeat.o(114558);
            return true;
        } else {
            boolean c2 = com.tencent.wecall.talkroom.model.a.hqJ().c(aFI.field_groupId, aFI.field_roomId, aFI.field_roomKey, 1);
            AppMethodBeat.o(114558);
            return c2;
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean aFM(String str) {
        AppMethodBeat.i(114560);
        f aFI = ac.eoi().aFI(str);
        if (aFI != null) {
            boolean aFM = ac.eol().zMd.aFM(aFI.field_groupId);
            AppMethodBeat.o(114560);
            return aFM;
        }
        AppMethodBeat.o(114560);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d
    public final boolean aFN(String str) {
        boolean z;
        AppMethodBeat.i(114561);
        f aFI = ac.eoi().aFI(str);
        if (aFI != null) {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + aFI.field_roomId + " ilinkroomid:" + aFI.field_ilinkRoomId + " wxgroupid:" + str + " wifigateway:" + v2protocal.fJa());
            boolean aFW = ac.eom().aFW(str);
            boolean z2 = aFI.field_ilinkRoomId != 0;
            if (aFW || z2) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk:isILink:%b, isILinkCallFromBanner:%b,  groupid:%s", Boolean.valueOf(z), Boolean.valueOf(z2), aFI.field_groupId);
            if (z) {
                com.tencent.mm.plugin.multitalk.b.p.INSTANCE.y((long) Util.nullAsNil((Integer) g.aAh().hqB.get(1)), z.aTY());
                ac.eom().eM(str, 2);
                com.tencent.mm.plugin.multitalk.b.p pVar = com.tencent.mm.plugin.multitalk.b.p.INSTANCE;
                String str2 = aFI.field_groupId;
                Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkJoinRoom. %s, %s", str2, str);
                pVar.aj(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bf: INVOKE  
                      (r0v14 'pVar' com.tencent.mm.plugin.multitalk.b.p)
                      (wrap: com.tencent.mm.plugin.multitalk.b.p$23 : 0x00bc: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.multitalk.b.p$23) = (r0v14 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r13v0 'str' java.lang.String), (r3v16 'str2' java.lang.String) call: com.tencent.mm.plugin.multitalk.b.p.23.<init>(com.tencent.mm.plugin.multitalk.b.p, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.plugin.multitalk.b.p.aj(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.model.s.aFN(java.lang.String):boolean, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bc: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.multitalk.b.p$23) = (r0v14 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r13v0 'str' java.lang.String), (r3v16 'str2' java.lang.String) call: com.tencent.mm.plugin.multitalk.b.p.23.<init>(com.tencent.mm.plugin.multitalk.b.p, java.lang.String, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.model.s.aFN(java.lang.String):boolean, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                // Method dump skipped, instructions count: 239
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.s.aFN(java.lang.String):boolean");
            }
        }
