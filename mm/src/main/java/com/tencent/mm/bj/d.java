package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;

public class d implements bd {
    public static int ibS = 0;
    public static int[] jpG = new int[1000];
    private final int dnp = 0;
    private e jpC = new e();
    private b jpD = new b();
    private final long jpE = 259200000;
    private final int jpF = 2;
    private IListener jpH = new IListener<go>() {
        /* class com.tencent.mm.bj.d.AnonymousClass1 */

        {
            AppMethodBeat.i(161281);
            this.__eventId = go.class.getName().hashCode();
            AppMethodBeat.o(161281);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(go goVar) {
            AppMethodBeat.i(20664);
            go goVar2 = goVar;
            int i2 = goVar2.dKw.dKy;
            String str = goVar2.dKw.talker;
            int i3 = goVar2.dKw.state;
            if (i2 == 1) {
                bm bgN = d.bgN();
                bl blVar = new bl();
                blVar.field_state = -1;
                Cursor rawQuery = bgN.db.rawQuery(String.format("select %s from %s where %s = %s", "state", "fmessage_conversation", "talker", h.Fl(str)), null, 2);
                if (rawQuery.moveToFirst()) {
                    blVar.convertFrom(rawQuery);
                }
                rawQuery.close();
                i3 = blVar.field_state;
            } else if (i2 == 0) {
                if (i3 == 2) {
                    d.bgN().gP(str, 2);
                } else if (i3 == 1) {
                    d.bgN().gP(str, 1);
                } else {
                    d.bgN().gP(str, 0);
                }
            }
            goVar2.dKx.state = i3;
            AppMethodBeat.o(20664);
            return false;
        }
    };

    public d() {
        AppMethodBeat.i(20665);
        AppMethodBeat.o(20665);
    }

    public static bo bgM() {
        AppMethodBeat.i(20666);
        g.aAf().azk();
        bm bgN = bgN();
        bo boVar = (bo) ((l) g.af(l.class)).eix();
        boVar.add(bgN, g.aAk().getLooper());
        AppMethodBeat.o(20666);
        return boVar;
    }

    public static bm bgN() {
        AppMethodBeat.i(20667);
        g.aAf().azk();
        bm bmVar = (bm) ((l) g.af(l.class)).eiw();
        AppMethodBeat.o(20667);
        return bmVar;
    }

    public static by bgO() {
        AppMethodBeat.i(20668);
        g.aAf().azk();
        by byVar = (by) ((l) g.af(l.class)).eiv();
        AppMethodBeat.o(20668);
        return byVar;
    }

    public static cm bgP() {
        AppMethodBeat.i(20669);
        g.aAf().azk();
        cm cmVar = (cm) ((l) g.af(l.class)).eiu();
        AppMethodBeat.o(20669);
        return cmVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(20670);
        h.d.b(37, this.jpC);
        h.d.b(65, this.jpC);
        h.d.b(40, this.jpD);
        EventCenter.instance.removeListener(this.jpH);
        bg.getNotification().alb();
        AppMethodBeat.o(20670);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(20671);
        h.d.a(37, this.jpC);
        h.d.a(65, this.jpC);
        h.d.a(40, this.jpD);
        EventCenter.instance.addListener(this.jpH);
        int gCR = bgN().gCR();
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        long nullAs = currentTimeMillis - Util.nullAs((Long) c.azQ().get(340225, (Object) null), 0);
        Log.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(nullAs)));
        if (nullAs > 259200000 && gCR > 0) {
            Cursor rawQuery = bgN().db.rawQuery(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", "contentNickname", "fmessage_conversation", 2), null, 2);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("contentNickname")));
            }
            rawQuery.close();
            int size = arrayList.size();
            if (size > 0) {
                String str = (String) arrayList.get(0);
                for (int i2 = 1; i2 < size; i2++) {
                    str = str + ", " + ((String) arrayList.get(i2));
                }
                Log.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(str)));
                nx nxVar = new nx();
                nxVar.dTZ.userName = null;
                nxVar.dTZ.nickName = str;
                nxVar.dTZ.type = 0;
                EventCenter.instance.publish(nxVar);
                bg.aVF();
                c.azQ().set(340225, Long.valueOf(System.currentTimeMillis()));
            }
        }
        AppMethodBeat.o(20671);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static void a(de deVar, ca.d dVar) {
        AppMethodBeat.i(20672);
        Log.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + deVar.oTW + ", id = " + deVar.Brn);
        bx bxVar = new bx();
        bxVar.field_content = z.a(deVar.KHn);
        bxVar.field_createtime = Util.nowSecond();
        bxVar.field_imgpath = "";
        bxVar.field_sayhicontent = dVar.content;
        bxVar.field_sayhiuser = dVar.dkU;
        bxVar.field_scene = dVar.scene;
        bxVar.field_status = deVar.oTW > 3 ? deVar.oTW : 3;
        bxVar.field_svrid = deVar.Brn;
        bxVar.field_talker = z.a(deVar.KHl);
        bxVar.field_type = deVar.xKb;
        bxVar.field_isSend = 0;
        bxVar.field_sayhiencryptuser = dVar.OqZ;
        bxVar.field_ticket = dVar.wZz;
        bxVar.field_flag = 1;
        ((by) ((l) g.af(l.class)).eiv()).a(bxVar);
        com.tencent.mm.aj.c.ap(bxVar.field_sayhiencryptuser, 3);
        AppMethodBeat.o(20672);
    }

    public static void b(de deVar, ca.d dVar) {
        AppMethodBeat.i(20673);
        Log.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + deVar.oTW + ", id = " + deVar.Brn);
        cl clVar = new cl();
        clVar.field_content = z.a(deVar.KHn);
        clVar.field_createtime = Util.nowSecond();
        clVar.field_imgpath = "";
        clVar.field_sayhicontent = dVar.content;
        clVar.field_sayhiuser = dVar.dkU;
        clVar.field_scene = dVar.scene;
        clVar.field_status = deVar.oTW > 3 ? deVar.oTW : 3;
        clVar.field_svrid = deVar.Brn;
        clVar.field_talker = z.a(deVar.KHl);
        clVar.field_type = deVar.xKb;
        clVar.field_isSend = 0;
        ((cm) ((l) g.af(l.class)).eiu()).a(clVar);
        com.tencent.mm.aj.c.ap(clVar.field_sayhiuser, 3);
        AppMethodBeat.o(20673);
    }
}
