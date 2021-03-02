package com.tencent.mm.plugin.offline.a;

import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public final class k extends m {
    public static String AJF = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    public String AJA = "";
    public String AJB = "";
    public String AJC = "";
    public String AJD = "";
    public String AJE = "";
    public String AJG = "";
    public int AJH = 0;
    public String AJI = "";
    public String AJJ = "";
    public String AJK = "";
    public int AJL = g.sHCENCODEVIDEOTIMEOUT;
    public String token = "";

    public k(Bankcard bankcard, String str, int i2) {
        AppMethodBeat.i(66300);
        String aoG = q.aoG();
        String str2 = (String) l.aol().get(256);
        if (!Util.isNullOrNil(str2) && str2.equals(aoG)) {
            h.INSTANCE.dN(965, 48);
        }
        Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", str2, aoG);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put(TPDownloadProxyEnum.USER_DEVICE_ID, aoG);
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(d.KyO));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i2));
        this.AJL = i2;
        String mD5String = MD5Util.getMD5String(MD5Util.getMD5String(f.getUsername()) + MD5Util.getMD5String(q.aoG()));
        hashMap.put(AccessToken.USER_ID_KEY, mD5String);
        b hhj = b.hhj();
        com.tencent.mm.wallet_core.b.hgC();
        String hr = hhj.hr(mD5String, com.tencent.mm.wallet_core.b.hgE() ? 1 : 0);
        com.tencent.mm.wallet_core.b.hgC();
        Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", hr, Boolean.valueOf(com.tencent.mm.wallet_core.b.hgE()));
        hashMap.put("crt_csr", hr);
        hashMap.put("type", AJF);
        hashMap.put("version_number", AJF);
        setRequestData(hashMap);
        AppMethodBeat.o(66300);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 46;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66301);
        if (jSONObject != null) {
            this.AJB = jSONObject.optString("crt_crt");
            this.AJA = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.AJC = jSONObject.optString("valid_end");
            this.AJD = jSONObject.optString("encrypt_str");
            this.AJE = jSONObject.optString("deviceid");
            if (b.hhj().importCert(this.AJA, this.AJB)) {
                Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
            }
            this.AJG = jSONObject.optString("token_v2");
            this.AJH = jSONObject.optInt("algorithm_type");
            this.AJI = jSONObject.optString("card_list");
            this.AJJ = jSONObject.optString("key_list");
            this.AJK = jSONObject.optString("token_pin");
            String optString = jSONObject.optString("notice_url");
            String optString2 = jSONObject.optString("auth_codes");
            int optInt = jSONObject.optInt("update_interval");
            String optString3 = jSONObject.optString("code_ver");
            int optInt2 = jSONObject.optInt("cipher_type", 0);
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196617, this.AJA);
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196626, this.AJC);
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196627, this.AJD);
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196628, this.AJE);
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196630, "1");
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196632, new StringBuilder().append(System.currentTimeMillis() / 1000).toString());
            a.w(this.token, this.AJG, this.AJI, this.AJJ);
            a.Uf(this.AJH);
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196647, this.AJK);
            a.aJn(optString);
            com.tencent.mm.plugin.offline.k.ezn();
            String TX = com.tencent.mm.plugin.offline.k.TX(196617);
            b.hhj();
            b.clearToken(TX);
            b.hhj();
            boolean F = b.F(this.AJA, optString2, optInt2 == 1);
            Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", Boolean.valueOf(F), this.AJA);
            if (!F) {
                Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder sb = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                b.hhj();
                Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", sb.append(b.getLastError()).toString());
            } else {
                Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            }
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196649, String.valueOf(optInt));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, q.dr(true));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, optString3);
        }
        AppMethodBeat.o(66301);
    }

    @Override // com.tencent.mm.wallet_core.c.w, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66302);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        if (!(i3 == 0 && i4 == 0)) {
            com.tencent.mm.plugin.offline.k.ezn();
            com.tencent.mm.plugin.offline.k.bN(196630, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(c.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(c.CTRL_INDEX);
        iDKey2.SetValue(1);
        if (i4 == 0 && i4 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(66302);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd2(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(66303);
        b.hhj().hhk();
        AppMethodBeat.o(66303);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 565;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
