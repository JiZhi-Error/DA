package com.tencent.mm.model;

import android.app.Activity;
import android.content.Intent;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.c.b;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e;
import java.util.ArrayList;

public final class k implements n {
    private LruCache<String, b> iBU = new LruCache<>(3);

    public k() {
        AppMethodBeat.i(212151);
        AppMethodBeat.o(212151);
    }

    @Override // com.tencent.mm.api.n
    public final boolean fD(String str) {
        AppMethodBeat.i(123961);
        if (ag.bah().MT(str).Uz()) {
            AppMethodBeat.o(123961);
            return true;
        }
        AppMethodBeat.o(123961);
        return false;
    }

    @Override // com.tencent.mm.api.n
    public final ArrayList<String> fE(String str) {
        AppMethodBeat.i(123962);
        try {
            c.b cG = ag.bah().MT(str).cG(false);
            if (cG.dic == null && cG.dhz != null) {
                cG.dic = c.b.a.fq(cG.dhz.optString("AcctTransferInfo"));
            }
            ArrayList<String> arrayList = cG.dic.die;
            AppMethodBeat.o(123962);
            return arrayList;
        } catch (Exception e2) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            AppMethodBeat.o(123962);
            return arrayList2;
        }
    }

    @Override // com.tencent.mm.api.n
    public final void a(Intent intent, drt drt, int i2) {
        AppMethodBeat.i(123963);
        String a2 = z.a(drt.Lqk);
        intent.putExtra("Contact_User", a2);
        intent.putExtra("Contact_Nick", z.a(drt.Mjj));
        intent.putExtra("Contact_PyInitial", z.a(drt.LpA));
        intent.putExtra("Contact_QuanPin", z.a(drt.LpB));
        intent.putExtra("Contact_Alias", drt.ked);
        intent.putExtra("Contact_Sex", drt.kdY);
        intent.putExtra("Contact_VUser_Info", drt.MmL);
        intent.putExtra("Contact_VUser_Info_Flag", drt.MmK);
        intent.putExtra("Contact_KWeibo_flag", drt.MmO);
        intent.putExtra("Contact_KWeibo", drt.MmM);
        intent.putExtra("Contact_KWeiboNick", drt.MmN);
        intent.putExtra("Contact_Scene", i2);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(drt.keh, drt.kdZ, drt.kea));
        intent.putExtra("Contact_Signature", drt.keb);
        intent.putExtra("Contact_BrandList", drt.kei);
        intent.putExtra("Contact_KSnsIFlag", drt.MmQ.kej);
        intent.putExtra("Contact_KSnsBgId", drt.MmQ.kel);
        intent.putExtra("Contact_KSnsBgUrl", drt.MmQ.kek);
        intent.putExtra("Contact_BIZ_KF_WORKER_ID", drt.MUn);
        intent.putExtra(e.d.OyT, drt.LRO);
        intent.putExtra("Contact_BIZ_PopupInfoMsg", drt.MUo);
        Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", drt.LRO);
        c cVar = new c();
        cVar.field_username = a2;
        cVar.field_brandList = drt.kei;
        cVar.field_kfWorkerId = drt.MUn;
        aeq aeq = drt.MmR;
        if (aeq != null) {
            cVar.field_brandFlag = aeq.kem;
            cVar.field_brandInfo = aeq.keo;
            cVar.field_extInfo = aeq.ken;
            cVar.field_attrSyncVersion = null;
            cVar.field_brandIconURL = aeq.kep;
        }
        if (!ag.bah().h(cVar)) {
            ag.bah().g(cVar);
        }
        AppMethodBeat.o(123963);
    }

    @Override // com.tencent.mm.api.n
    public final void a(Intent intent, drr drr, int i2) {
        AppMethodBeat.i(123964);
        String a2 = z.a(drr.Lqk);
        intent.putExtra("Contact_User", a2);
        intent.putExtra("Contact_Nick", z.a(drr.Mjj));
        intent.putExtra("Contact_PyInitial", z.a(drr.LpA));
        intent.putExtra("Contact_QuanPin", z.a(drr.LpB));
        intent.putExtra("Contact_Alias", drr.ked);
        intent.putExtra("Contact_Sex", drr.kdY);
        intent.putExtra("Contact_VUser_Info", drr.MmL);
        intent.putExtra("Contact_VUser_Info_Flag", drr.MmK);
        intent.putExtra("Contact_KWeibo_flag", drr.MmO);
        intent.putExtra("Contact_KWeibo", drr.MmM);
        intent.putExtra("Contact_KWeiboNick", drr.MmN);
        intent.putExtra("Contact_Scene", i2);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(drr.keh, drr.kdZ, drr.kea));
        intent.putExtra("Contact_Signature", drr.keb);
        intent.putExtra("Contact_BrandList", drr.kei);
        intent.putExtra("Contact_KSnsIFlag", drr.MmQ.kej);
        intent.putExtra("Contact_KSnsBgId", drr.MmQ.kel);
        intent.putExtra("Contact_KSnsBgUrl", drr.MmQ.kek);
        intent.putExtra(e.d.OyT, drr.LRO);
        Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", drr.LRO);
        c cVar = new c();
        cVar.field_username = a2;
        cVar.field_brandList = drr.kei;
        aeq aeq = drr.MmR;
        if (aeq != null) {
            cVar.field_brandFlag = aeq.kem;
            cVar.field_brandInfo = aeq.keo;
            cVar.field_extInfo = aeq.ken;
            cVar.field_attrSyncVersion = null;
            cVar.field_brandIconURL = aeq.kep;
        }
        if (!ag.bah().h(cVar)) {
            ag.bah().g(cVar);
        }
        AppMethodBeat.o(123964);
    }

    private b HP(String str) {
        AppMethodBeat.i(212152);
        b bVar = this.iBU.get(str);
        if (bVar == null) {
            bVar = new b();
            this.iBU.put(str, bVar);
        }
        AppMethodBeat.o(212152);
        return bVar;
    }

    @Override // com.tencent.mm.api.n
    public final boolean fF(String str) {
        AppMethodBeat.i(212153);
        boolean fF = g.fF(str);
        AppMethodBeat.o(212153);
        return fF;
    }

    @Override // com.tencent.mm.api.n
    public final String fG(String str) {
        AppMethodBeat.i(212154);
        String fG = g.fG(str);
        AppMethodBeat.o(212154);
        return fG;
    }

    @Override // com.tencent.mm.api.n
    public final String fH(String str) {
        AppMethodBeat.i(212155);
        String fH = g.fH(str);
        AppMethodBeat.o(212155);
        return fH;
    }

    @Override // com.tencent.mm.api.n
    public final void fI(String str) {
        AppMethodBeat.i(212156);
        HP(str).fI(str);
        AppMethodBeat.o(212156);
    }

    @Override // com.tencent.mm.api.n
    public final void b(Activity activity, String str) {
        AppMethodBeat.i(212157);
        HP(str).z(activity);
        AppMethodBeat.o(212157);
    }
}
