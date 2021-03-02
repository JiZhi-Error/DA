package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p {
    public static final p GnV = new p();
    eiw GnW;

    static {
        AppMethodBeat.i(126175);
        AppMethodBeat.o(126175);
    }

    static boolean l(eiw eiw) {
        if (eiw.Niy == 100201 || eiw.Niy == 100203) {
            return false;
        }
        return true;
    }

    public final void a(b bVar, int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        AppMethodBeat.i(126172);
        if (i2 == 1024) {
            if (i3 == -1) {
                Toast.makeText(MMApplicationContext.getContext(), (int) R.string.z0, 1).show();
                i.a(bVar.fyD(), this.GnW, "1", z.aTY(), "");
                AppMethodBeat.o(126172);
                return;
            }
        } else if (i2 == 2048 && i3 == -1 && (stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames")) != null && stringArrayListExtra.size() > 0) {
            StringBuilder sb = new StringBuilder("");
            StringBuilder sb2 = new StringBuilder("");
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (ab.Eq(next)) {
                    sb.append(3);
                    sb.append(";");
                } else {
                    sb.append(2);
                    sb.append(";");
                }
                sb2.append(next);
                sb2.append(";");
            }
            i.a(bVar.fyD(), this.GnW, sb.toString(), z.aTY(), sb2.toString());
        }
        AppMethodBeat.o(126172);
    }

    static JSONArray hL(List<aca> list) {
        AppMethodBeat.i(126173);
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                JSONObject jSONObject = new JSONObject();
                aca aca = list.get(i2);
                jSONObject.put("key", aca.key);
                jSONObject.put("uintValue", aca.LmC);
                jSONObject.put("textValue", aca.LmD);
                jSONArray.put(jSONObject);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(126173);
        return jSONArray;
    }

    public static void a(MMActivity mMActivity, eit eit, eiw eiw) {
        AppMethodBeat.i(126174);
        cz czVar = new cz();
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        String string = Util.isNullOrNil(eiw.xDQ) ? mMActivity.getString(R.string.fvf) : eiw.xDQ;
        aml.bgl(eiw.rCq);
        aml.bgf(eiw.msN);
        aml.bgg(string);
        aml.bgo(eiw.IED);
        aml.As(true);
        aml.At(true);
        aml.ajd(5);
        anq anq = new anq();
        anq.bhv(eiw.IED);
        anq.bhs(eiw.msN);
        anq.bht(string);
        anb.b(anq);
        aj ajVar = new aj();
        ajVar.IEy = eiw.psI;
        ajVar.IEz = eiw.Nir;
        ajVar.IEA = eit.hes;
        ajVar.IEB = eiw.Niq;
        ajVar.IEC = 100201;
        ajVar.rCq = eiw.rCq;
        ajVar.msN = eiw.msN;
        ajVar.xDQ = eiw.xDQ;
        ajVar.IED = eiw.IED;
        ajVar.IEE = eiw.IEE;
        ajVar.IEF = eiw.IEF;
        ajVar.source = eiw.source;
        ajVar.eby = eiw.eby;
        ajVar.IEG = eiw.IEG;
        ajVar.IEH = eiw.IEH;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(eit.IDO);
        linkedList.addAll(eiw.IDO);
        ajVar.IEJ = h.hK(eiw.xuO).toString();
        ajVar.IEI = hL(linkedList).toString();
        ajVar.IEK = eiw.Niy;
        ajVar.thumbUrl = eiw.Nio;
        StringBuilder sb = new StringBuilder();
        ajVar.a(sb, null, null, null, 0, 0);
        anq.bhx(sb.toString());
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(3);
        anh.MA(Util.nowMilliSecond());
        anh.bhm(eiw.rCq);
        anh.bhh(eiw.rCq);
        czVar.dFZ.title = aml.title;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.dGf = 25;
        czVar.dFZ.scene = 2;
        czVar.dFZ.type = 5;
        czVar.dFZ.activity = mMActivity;
        anb.a(anh);
        anb.ppH.add(aml);
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(126174);
    }
}
