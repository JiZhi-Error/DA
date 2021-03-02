package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private int gwE = 3;
    public b pQV;
    private MMActivity pQZ;
    public List<com.tencent.mm.plugin.card.model.b> pRa = new ArrayList();
    public com.tencent.mm.plugin.card.model.b pRb;
    private ArrayList<us> pRc;

    public f(MMActivity mMActivity) {
        AppMethodBeat.i(112618);
        this.pQZ = mMActivity;
        AppMethodBeat.o(112618);
    }

    public final void a(b bVar, ArrayList<us> arrayList, int i2) {
        this.pQV = bVar;
        this.pRc = arrayList;
        this.gwE = i2;
    }

    public final List<com.tencent.mm.plugin.card.model.b> ctr() {
        boolean z;
        List<com.tencent.mm.plugin.card.model.b> cX;
        AppMethodBeat.i(112619);
        this.pRa.clear();
        if (this.pQV.csR().LcD != null && !Util.isNullOrNil(this.pQV.csR().LcD.title)) {
            com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
            bVar.pSi = 1;
            bVar.title = this.pQV.csR().LcD.title;
            bVar.pWf = "";
            bVar.url = "card://jump_card_gift";
            bVar.qGB = this.pQV.csR().LcD.qGB;
            this.pRa.add(bVar);
        }
        if (!(this.pQV.csR().Lcm == null || this.pQV.csR().Lcm.size() <= 0 || (cX = l.cX(this.pQV.csR().Lcm)) == null)) {
            cX.get(0).pSj = false;
            this.pRa.addAll(cX);
        }
        if (((this.gwE == 6 && this.pQV.csR().Lcq <= 0) || l.EJ(this.gwE)) && this.pQV.csM() && this.pQV.csv() && this.pQV.csD()) {
            com.tencent.mm.plugin.card.model.b bVar2 = new com.tencent.mm.plugin.card.model.b();
            bVar2.pSi = 1;
            if (!Util.isNullOrNil(this.pQV.csQ().Lfl)) {
                bVar2.title = this.pQV.csQ().Lfl;
            } else if (this.pQV.csB()) {
                bVar2.title = MMApplicationContext.getResources().getString(R.string.arf);
            } else {
                bVar2.title = MMApplicationContext.getContext().getString(R.string.are);
            }
            bVar2.pWf = "";
            bVar2.url = "card://jump_gift";
            this.pRa.add(bVar2);
        }
        if (!(this.pQV.csR().status == 0 || this.pQV.csR().status == 1)) {
            this.pQV.csR();
        }
        if (this.gwE != 3 && this.gwE == 6) {
            this.pQV.csR();
        }
        agy agy = this.pQV.csQ().LeS;
        if (this.pQV.csR().Lcw != null) {
            TextUtils.isEmpty(this.pQV.csR().Lcw.title);
        }
        com.tencent.mm.plugin.card.model.b bVar3 = new com.tencent.mm.plugin.card.model.b();
        if (this.pQV.csB()) {
            z = false;
        } else if (agy == null || agy.LqB == null || agy.LqB.size() <= 0 || TextUtils.isEmpty(agy.LqB.get(0))) {
            z = true;
        } else {
            z = false;
        }
        bVar3.pSj = false;
        bVar3.pSi = 1;
        bVar3.title = getTitle() + getString(R.string.aoe);
        bVar3.pRY = "";
        bVar3.pWf = "";
        bVar3.url = "card://jump_detail";
        if (z) {
            this.pRa.add(bVar3);
        }
        if (!this.pQV.csz() || this.pQV.csQ().LeF <= 0) {
            if (!this.pQV.csx() || this.pQV.csQ().LeF <= 0) {
                if (this.pQV.csQ().LeF > 0) {
                    Log.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.pQV.csQ().LeF);
                    if (this.pQV.csQ().LeF > 0 && this.pRc != null && this.pRc.size() > 0) {
                        us usVar = this.pRc.get(0);
                        if (usVar != null && usVar.DWG < 50000.0f) {
                            com.tencent.mm.plugin.card.model.b bVar4 = new com.tencent.mm.plugin.card.model.b();
                            bVar4.pSi = 2;
                            bVar4.title = usVar.name;
                            bVar4.pRY = this.pQZ.getString(R.string.at1, new Object[]{l.f(this.pQZ, usVar.DWG), usVar.iUO});
                            bVar4.pWf = "";
                            bVar4.url = "card://jump_shop";
                            bVar4.pSm = usVar.pSm;
                            bVar4.ixw = this.pQV.csQ().ixw;
                            this.pRa.add(bVar4);
                        } else if (usVar != null) {
                            Log.e("MicroMsg.CardDetailDataMgr", "distance:" + usVar.DWG);
                        }
                    }
                }
            }
            if (this.pQV.csQ().LeF > 0 && this.pRc == null) {
                com.tencent.mm.plugin.card.model.b bVar5 = new com.tencent.mm.plugin.card.model.b();
                bVar5.pSi = 1;
                if (!TextUtils.isEmpty(this.pQV.csQ().Lfd)) {
                    bVar5.title = this.pQV.csQ().Lfd;
                } else {
                    bVar5.title = getString(R.string.anm);
                }
                bVar5.pRY = "";
                bVar5.pWf = "";
                bVar5.url = "card://jump_shop_list";
                this.pRa.add(bVar5);
            } else if (this.pQV.csQ().LeF > 0 && this.pRc != null && this.pRc.size() > 0) {
                com.tencent.mm.plugin.card.model.b bVar6 = new com.tencent.mm.plugin.card.model.b();
                bVar6.pSi = 1;
                us usVar2 = this.pRc.get(0);
                if (!TextUtils.isEmpty(this.pQV.csQ().Lfd)) {
                    bVar6.title = this.pQV.csQ().Lfd;
                } else if (this.pQV.csx() || usVar2.DWG >= 5000.0f) {
                    bVar6.title = getString(R.string.anm);
                } else if (this.pQV.csQ().LeF == 1 || this.pRc.size() == 1) {
                    Log.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                } else {
                    bVar6.title = getString(R.string.ant);
                }
                if (!this.pQV.csx() || usVar2.DWG >= 2000.0f) {
                    bVar6.pRY = "";
                } else if (this.pQV.csQ().LeF > 1 || (this.pRc != null && this.pRc.size() > 1)) {
                    bVar6.pRY = this.pQZ.getString(R.string.ara, new Object[]{l.f(this.pQZ, usVar2.DWG)});
                } else {
                    bVar6.pRY = l.f(this.pQZ, usVar2.DWG);
                }
                bVar6.pWf = "";
                bVar6.url = "card://jump_shop_list";
                this.pRa.add(bVar6);
            }
        }
        if ((!this.pQV.csB() || this.pQV.csR().status != 3) && !TextUtils.isEmpty(this.pQV.csQ().KZR)) {
            this.pRa.add(ctu());
        }
        if (this.pQV.csx()) {
            for (com.tencent.mm.plugin.card.model.b bVar7 : this.pRa) {
                bVar7.pSl = true;
            }
        }
        List<com.tencent.mm.plugin.card.model.b> list = this.pRa;
        AppMethodBeat.o(112619);
        return list;
    }

    private boolean cts() {
        AppMethodBeat.i(112620);
        if (l.EH(this.gwE) || l.EI(this.gwE) || this.gwE == 23) {
            if (this.pQV.isAcceptable() && this.pQV.csQ().LeU != null && !TextUtils.isEmpty(this.pQV.csQ().LeU.text) && !TextUtils.isEmpty(this.pQV.csQ().KZR)) {
                AppMethodBeat.o(112620);
                return true;
            }
        } else if (this.gwE == 6 && this.pQV.csN() && this.pQV.csQ().LeU != null && !TextUtils.isEmpty(this.pQV.csQ().LeU.text) && !TextUtils.isEmpty(this.pQV.csQ().KZR)) {
            AppMethodBeat.o(112620);
            return true;
        }
        AppMethodBeat.o(112620);
        return false;
    }

    public final boolean ctt() {
        if (this.pRb == null) {
            return false;
        }
        return this.pRb.edw;
    }

    public final com.tencent.mm.plugin.card.model.b ctu() {
        AppMethodBeat.i(112621);
        com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
        bVar.pSi = 1;
        bVar.pSk = cts();
        if (!bVar.pSk && !TextUtils.isEmpty(this.pQV.csQ().LeN)) {
            bVar.title = this.pQV.csQ().LeN;
        } else if (ab.IS(this.pQV.csQ().KZR)) {
            bVar.title = getString(R.string.ard);
            bVar.pSk = false;
        } else {
            bVar.title = getString(R.string.arc);
            if (this.pQV.csQ().LeU == null || this.pQV.csQ().LeU.LOA != 1) {
                bVar.edw = false;
            } else {
                bVar.edw = true;
            }
        }
        if (!TextUtils.isEmpty(this.pQV.csQ().LeP)) {
            bVar.pRY = this.pQV.csQ().LeP;
        }
        bVar.pWf = "";
        bVar.url = "card://jump_service";
        this.pRb = bVar;
        com.tencent.mm.plugin.card.model.b bVar2 = this.pRb;
        AppMethodBeat.o(112621);
        return bVar2;
    }

    public final String getTitle() {
        AppMethodBeat.i(112622);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.pQV.csQ().pTn)) {
            sb.append(this.pQV.csQ().pTn);
        } else if (this.pQV.csx()) {
            sb.append(getString(R.string.ar9));
        } else if (this.pQV.csy()) {
            sb.append(getString(R.string.ao_));
        } else if (this.pQV.csz()) {
            sb.append(getString(R.string.anr));
        } else if (this.pQV.csA()) {
            sb.append(getString(R.string.aoj));
        } else if (this.pQV.csB()) {
            sb.append(getString(R.string.aqe));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(112622);
        return sb2;
    }

    private String getString(int i2) {
        AppMethodBeat.i(112623);
        String string = this.pQZ.getString(i2);
        AppMethodBeat.o(112623);
        return string;
    }
}
