package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class m extends g {
    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final boolean f(b bVar) {
        AppMethodBeat.i(113684);
        if (this.pQV == null) {
            Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.o(113684);
            return true;
        } else if (bVar == null) {
            Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.o(113684);
            return false;
        } else if (this.pQV.csR().LcG != bVar.csR().LcG) {
            Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
            AppMethodBeat.o(113684);
            return true;
        } else {
            abz abz = this.pQV.csR().LcF;
            abz abz2 = bVar.csR().LcF;
            if ((abz == null && abz2 != null) || (abz != null && abz2 == null)) {
                Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
                AppMethodBeat.o(113684);
                return true;
            } else if (abz == null || abz2 == null || abz.title == null || abz2.title == null || !abz.title.equals(abz2.title)) {
                abz abz3 = this.pQV.csQ().Lfe;
                abz abz4 = bVar.csQ().Lfe;
                if ((abz3 == null && abz4 != null) || (abz3 != null && abz4 == null)) {
                    Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    AppMethodBeat.o(113684);
                    return true;
                } else if (abz3 != null && abz4 != null && abz3.title != null && abz4.title != null && !abz3.title.equals(abz4.title)) {
                    Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    AppMethodBeat.o(113684);
                    return true;
                } else if (abz3 == null || abz4 == null || abz3.pRZ == null || abz4.pRZ == null || abz3.pRZ.equals(abz4.pRZ)) {
                    AppMethodBeat.o(113684);
                    return false;
                } else {
                    Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    AppMethodBeat.o(113684);
                    return true;
                }
            } else {
                Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
                AppMethodBeat.o(113684);
                return true;
            }
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final String e(c cVar) {
        int i2;
        boolean z;
        AppMethodBeat.i(113685);
        Log.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
        g cug = am.cug();
        b bVar = this.pQV;
        String str = "";
        if (bVar == null) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
        } else {
            cug.ctj();
            cug.pRd = cVar;
            String csU = bVar.csU();
            Cursor rawQuery = am.cue().db.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{csU});
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i2 = rawQuery.getInt(0);
                rawQuery.close();
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
                z = false;
            } else {
                i ajl = am.cuf().ajl(csU);
                if (ajl != null) {
                    if (g.a(ajl)) {
                        cug.pRd = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                        z = false;
                    } else if (i2 < ajl.field_lower_bound && l.isNetworkAvailable(MMApplicationContext.getContext())) {
                        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", Integer.valueOf(i2), Integer.valueOf(ajl.field_lower_bound));
                        cug.pRd = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                        z = false;
                    }
                }
                z = true;
            }
            if (!z) {
                Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
                cug.a(bVar, r.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
                AppMethodBeat.o(113685);
                return "";
            }
            k ajn = am.cue().ajn(bVar.csU());
            if (ajn == null) {
                Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", bVar.csU());
                cug.a(bVar, r.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
                AppMethodBeat.o(113685);
                return "";
            }
            k ajo = am.cue().ajo(csU);
            if (ajo != null && am.cue().fr(csU, ajo.field_code_id)) {
                cug.a(csU, ajo.field_code_id, cVar);
            }
            cug.gVP = 0;
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", csU, ajn.field_code_id, Integer.valueOf(cVar.action));
            String csU2 = bVar.csU();
            if (ajn == null) {
                str = "";
            } else {
                str = e.fx(csU2, ajn.field_code);
                i ajl2 = am.cuf().ajl(csU2);
                if (ajl2 == null || Util.isNullOrNil(str) || !ajl2.field_need_insert_show_timestamp || Util.isNullOrNil(ajl2.field_show_timestamp_encrypt_key)) {
                    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
                } else {
                    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
                    str = e.fz(str, ajl2.field_show_timestamp_encrypt_key);
                }
            }
            if (Util.isNullOrNil(str)) {
                cug.ak(1, "");
                AppMethodBeat.o(113685);
                return "";
            }
            ajn.field_status = 1;
            if (!am.cue().update(ajn, "card_id", "code_id")) {
                Log.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", ajn.field_card_id, ajn.field_code_id, Integer.valueOf(ajn.field_status));
            } else {
                Log.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", ajn.field_card_id, ajn.field_code_id, Integer.valueOf(ajn.field_status));
            }
            g cug2 = am.cug();
            i ajl3 = am.cuf().ajl(bVar.csU());
            if (ajl3 == null) {
                Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
            } else {
                long j2 = (long) (ajl3.field_show_expire_interval * 1000);
                Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(j2)));
                cug2.pRe.startTimer(j2);
            }
        }
        AppMethodBeat.o(113685);
        return str;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxB() {
        AppMethodBeat.i(113686);
        n nVar = new n(this, this.pQZ);
        AppMethodBeat.o(113686);
        return nVar;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxC() {
        AppMethodBeat.i(113687);
        f fVar = new f(this, this.pQZ);
        AppMethodBeat.o(113687);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxD() {
        AppMethodBeat.i(113688);
        t tVar = new t(this, this.pQZ);
        AppMethodBeat.o(113688);
        return tVar;
    }
}
