package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.b.a.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends h {
    public String AJC;
    public String AJD;
    public String AJE;
    public String AJG;
    public int AJH;
    public String AJI;
    public String AJJ;
    public String AJK;
    private String AJM;
    private int AJN;
    public String AJO;
    public int AJP;
    int AJQ;
    String dRM;
    public String token;

    public m(String str, int i2) {
        this(str, i2, i2);
        AppMethodBeat.i(66306);
        AppMethodBeat.o(66306);
    }

    public m(String str, int i2, int i3) {
        String str2;
        int i4;
        String str3;
        AppMethodBeat.i(66307);
        this.token = "";
        this.AJC = "";
        this.AJD = "";
        this.AJE = "";
        this.AJG = "";
        this.AJH = 0;
        this.AJI = "";
        this.AJJ = "";
        this.AJK = "";
        this.AJP = 0;
        this.AJQ = 0;
        this.dRM = d.getMessageDigest(new StringBuilder().append(System.currentTimeMillis()).toString().getBytes());
        Log.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", Integer.valueOf(i2), Util.getStack().toString());
        String token2 = a.getToken();
        k.ezn();
        String TX = k.TX(196628);
        TX = TextUtils.isEmpty(TX) ? q.aoG() : TX;
        if (TextUtils.isEmpty(token2)) {
            str2 = TX + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000);
        } else {
            str2 = TX + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000) + "&" + token2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token_src", str2);
        k.ezn();
        String TX2 = k.TX(196617);
        switch (i3) {
            case 0:
                i4 = 12;
                break;
            case 1:
                i4 = 13;
                break;
            case 2:
                i4 = 14;
                break;
            case 3:
                i4 = 15;
                break;
            case 4:
                i4 = 16;
                break;
            case 5:
                i4 = 17;
                break;
            case 6:
                i4 = 18;
                break;
            case 7:
                i4 = 19;
                break;
            case 8:
                i4 = 20;
                break;
            case 9:
                i4 = 24;
                break;
            case 10:
                i4 = 72;
                break;
            default:
                i4 = 12;
                break;
        }
        h.INSTANCE.idkeyStat(135, (long) i4, 1, true);
        i iVar = new i();
        iVar.hM(this.dRM);
        iVar.ejW = 1;
        b.hhj();
        if (b.isCertExist(TX2)) {
            iVar.ejX = 1;
            b.hhj();
            iVar.ejY = (long) b.getLastError();
            iVar.bfK();
            i iVar2 = new i();
            iVar2.hM(this.dRM);
            iVar2.ejW = 3;
            b.hhj();
            str3 = b.genUserSig(TX2, str2);
            if (Util.isNullOrNil(str3)) {
                iVar2.ejX = 0;
                b.hhj();
                iVar2.ejY = (long) b.getLastError();
                iVar2.bfK();
            } else {
                iVar2.ejX = 1;
                b.hhj();
                iVar2.ejY = (long) b.getLastError();
                iVar2.bfK();
            }
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder sb = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            b.hhj();
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", sb.append(b.getLastError()).toString());
            iVar.ejX = 0;
            b.hhj();
            iVar.ejY = (long) b.getLastError();
            iVar.bfK();
            h.INSTANCE.idkeyStat(135, 6, 1, true);
            i iVar3 = new i();
            iVar3.hM(this.dRM);
            iVar3.ejW = 2;
            g.aAi();
            String str4 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, "");
            if (str4 == null || !str4.equals(q.dr(true))) {
                iVar3.ejX = 0;
                b.hhj();
                iVar3.ejY = (long) b.getLastError();
                Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                h.INSTANCE.idkeyStat(135, 5, 1, true);
            } else {
                Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
                iVar3.ejX = 1;
                b.hhj();
                iVar3.ejY = (long) b.getLastError();
            }
            iVar3.bfK();
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(TX2)));
            str3 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            h.INSTANCE.idkeyStat(135, 4, 1, true);
        } else {
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", str3);
        hashMap.put("cert_no", TX2);
        hashMap.put("type", k.AJF);
        hashMap.put("version_number", k.AJF);
        if (a.eAy() == 2) {
            hashMap.put("last_token", a.eAz());
        } else {
            hashMap.put("last_token", a.getToken());
        }
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", Boolean.valueOf(k.AIX));
        if (i2 == 65281) {
            hashMap.put("fetch_tag", "2");
        } else if (k.AIX) {
            hashMap.put("fetch_tag", "1");
        } else {
            hashMap.put("fetch_tag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        hashMap.put("scene", String.valueOf(i2 == 65281 ? 3 : i2));
        setRequestData(hashMap);
        AppMethodBeat.o(66307);
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final int getTenpayCgicmd() {
        if (k.AIX) {
            return 52;
        }
        return 1725;
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66308);
        Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
        if (i2 == 0) {
            this.token = jSONObject.optString("token");
            this.AJC = jSONObject.optString("valid_end");
            this.AJD = jSONObject.optString("encrypt_str");
            this.AJE = jSONObject.optString("deviceid");
            this.AJG = jSONObject.optString("token_v2");
            this.AJH = jSONObject.optInt("algorithm_type");
            this.AJI = jSONObject.optString("card_list");
            this.AJJ = jSONObject.optString("key_list");
            this.AJK = jSONObject.optString("token_pin");
            this.AJM = jSONObject.optString("auth_codes");
            this.AJN = jSONObject.optInt("update_interval");
            this.AJO = jSONObject.optString("code_ver");
            this.AJP = jSONObject.optInt("reget_token_num", 0);
            this.AJQ = jSONObject.optInt("cipher_type", 0);
            a.Uh(this.AJP);
            Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", jSONObject.toString());
        }
        AppMethodBeat.o(66308);
    }

    public final boolean ezs() {
        AppMethodBeat.i(66309);
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        k.ezn();
        k.bN(196626, this.AJC);
        k.ezn();
        k.bN(196627, this.AJD);
        k.ezn();
        k.bN(196628, this.AJE);
        k.ezn();
        k.bN(196632, new StringBuilder().append(System.currentTimeMillis() / 1000).toString());
        a.w(this.token, this.AJG, this.AJI, this.AJJ);
        a.Uf(this.AJH);
        k.ezn();
        k.bN(196647, this.AJK);
        k.ezn();
        String TX = k.TX(196617);
        b.hhj();
        b.clearToken(TX);
        b.hhj();
        boolean F = b.F(TX, this.AJM, this.AJQ == 1);
        i iVar = new i();
        iVar.hM(this.dRM);
        iVar.ejW = 3;
        if (!F) {
            iVar.ejX = 0;
            b.hhj();
            iVar.ejY = (long) b.getLastError();
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder sb = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            b.hhj();
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", sb.append(b.getLastError()).toString());
        } else {
            iVar.ejX = 1;
            b.hhj();
            iVar.ejY = (long) b.getLastError();
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        }
        iVar.bfK();
        k.ezn();
        k.bN(196649, new StringBuilder().append(this.AJN).toString());
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, this.AJO);
        AppMethodBeat.o(66309);
        return F;
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final int getFuncId() {
        if (k.AIX) {
            return 571;
        }
        return 1725;
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final String getUri() {
        if (k.AIX) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
        }
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
    }
}
