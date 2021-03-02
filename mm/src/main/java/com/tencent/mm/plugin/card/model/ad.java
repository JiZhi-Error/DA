package com.tencent.mm.plugin.card.model;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.dtc;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class ad extends q implements m {
    private i callback;
    public boolean pUn = false;
    public vc pUo;
    public dtc pUp;
    public int pUq;
    private final d rr;

    public ad(double d2, double d3, int i2) {
        AppMethodBeat.i(112846);
        d.a aVar = new d.a();
        aVar.iLN = new bkt();
        aVar.iLO = new bku();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardslayout";
        aVar.funcId = 1054;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bkt bkt = (bkt) this.rr.iLK.iLR;
        bkt.latitude = d2;
        bkt.longitude = d3;
        bkt.scene = i2;
        bkt.LTF = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, (Object) null);
        AppMethodBeat.o(112846);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        int i5;
        AppMethodBeat.i(112847);
        Log.i("MicroMsg.NetSceneGetCardsLayout", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        bku bku = (bku) this.rr.iLL.iLR;
        Log.v("MicroMsg.NetSceneGetCardsLayout", "json:" + bku.pTY);
        this.pUo = bku.LTG;
        if (i3 == 0 && i4 == 0) {
            g.aAh().azQ().set(ar.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, bku.LTF);
            String str2 = bku.pTY;
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = (String) g.aAh().azQ().get(ar.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, (Object) null);
            if (!Util.isNullOrNil(str3)) {
                str2 = str3;
            }
            bkx akd = j.akd(str2);
            am.ctQ().db.execSQL("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 , label_wording='' where stickyIndex>0");
            if (akd == null) {
                Log.w("MicroMsg.CardStickyHelper", "[doUpdateStickyInfoLogic] resp null");
                z = false;
            } else {
                z = false;
                if (akd.LTL != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("expiring_list", 2);
                    hashMap.put("member_card_list", 2);
                    hashMap.put("nearby_list", 3);
                    hashMap.put("first_list", 5);
                    if (akd.LTO == 100) {
                        hashMap.put("expiring_list", 4);
                    } else if (akd.LTO == 102) {
                        hashMap.put("member_card_list", 4);
                    } else if (akd.LTO == 101) {
                        hashMap.put("nearby_list", 4);
                    }
                    long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                    if (akd.LTL.Lht == null || akd.LTL.Lht.Lhs == null || akd.LTL.Lht.Lhs.size() <= 0) {
                        i5 = 0;
                    } else {
                        z = true;
                        j.d(akd.LTL.Lht.Lhs, (((Integer) hashMap.get("expiring_list")).intValue() * 100000) + 3);
                        i5 = akd.LTL.Lht.Lhs.size() + 0;
                    }
                    if (!(akd.LTL.Lhu == null || akd.LTL.Lhu.Lhs == null || akd.LTL.Lhu.Lhs.size() <= 0)) {
                        z = true;
                        j.d(akd.LTL.Lhu.Lhs, (((Integer) hashMap.get("member_card_list")).intValue() * 100000) + 2);
                        i5 += akd.LTL.Lhu.Lhs.size();
                    }
                    if (!(akd.LTL.Lhv == null || akd.LTL.Lhv.Lhs == null || akd.LTL.Lhv.Lhs.size() <= 0)) {
                        z = true;
                        j.d(akd.LTL.Lhv.Lhs, (((Integer) hashMap.get("nearby_list")).intValue() * 100000) + 1);
                        i5 += akd.LTL.Lhv.Lhs.size();
                    }
                    if (!(akd.LTL.Lhw == null || akd.LTL.Lhw.Lhs == null || akd.LTL.Lhw.Lhs.size() <= 0)) {
                        z = true;
                        i5 += akd.LTL.Lhw.Lhs.size();
                        j.e(akd.LTL.Lhw.Lhs, 0);
                    }
                    if (!(akd.LTL.Lhx == null || akd.LTL.Lhx.Lhs == null || akd.LTL.Lhx.Lhs.size() <= 0)) {
                        z = true;
                        int intValue = (((Integer) hashMap.get("first_list")).intValue() * 100000) + 4;
                        j.d(akd.LTL.Lhx.Lhs, intValue);
                        j.e(akd.LTL.Lhx.Lhs, intValue);
                        i5 += akd.LTL.Lhx.Lhs.size();
                    }
                    g.aAh().hqK.endTransaction(beginTransaction);
                } else {
                    i5 = 0;
                }
                am.ctV().putValue("key_get_card_layout_resp", akd);
                g.aAh().azQ().set(ar.a.USERINFO_CARD_GET_LAYOUT_JSON_STRING_SYNC, str2);
                if (i5 > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList<IDKey> arrayList = new ArrayList<>();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(36);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(37);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(38);
                    iDKey3.SetValue((long) i5);
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(40);
                    iDKey4.SetValue((long) (((int) (currentTimeMillis2 - currentTimeMillis)) / i5));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.INSTANCE.b(arrayList, true);
                }
            }
            this.pUn = z;
            if (this.pUo != null) {
                try {
                    byte[] byteArray = this.pUo.toByteArray();
                    g.aAh().azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, new String(byteArray, 0, byteArray.length, KindaConfigCacheStg.SAVE_CHARSET));
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneGetCardsLayout", e2, "", new Object[0]);
                }
            } else {
                g.aAh().azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, "");
            }
            this.pUq = bku.LTH;
            if (this.pUq < 0) {
                this.pUq = 0;
            }
            g.aAh().azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, Integer.valueOf(this.pUq));
            if (bku.LTI != null) {
                this.pUp = bku.LTI;
                try {
                    byte[] byteArray2 = bku.LTI.toByteArray();
                    g.aAh().azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, new String(byteArray2, 0, byteArray2.length, KindaConfigCacheStg.SAVE_CHARSET));
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.NetSceneGetCardsLayout", e3, "", new Object[0]);
                }
                g.aAh().azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.TRUE);
            } else {
                g.aAh().azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, "");
                g.aAh().azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112847);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1054;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(112848);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112848);
        return dispatch;
    }
}
