package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class NetSceneKindaGenDigitalCert extends m {
    private final String TAG = "kinda.NetSceneKindaGenDigitalCert";

    private void baseRequset(Map<String, String> map) {
        int i2 = 0;
        AppMethodBeat.i(18666);
        g.aAi();
        g.aAf();
        String string = p.getString(a.getUin());
        String dr = q.dr(false);
        byte[] bArr = new byte[16];
        byte[] bytes = y.hhp().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = new StringBuilder().append(System.currentTimeMillis()).toString().getBytes();
        }
        int i3 = 0;
        int i4 = 0;
        do {
            bArr[i4] = bytes[i3];
            i4++;
            i3++;
            if (i3 >= bytes.length) {
                i3 = 0;
                continue;
            }
        } while (i4 < 16);
        String str = new String(bArr);
        String mD5String = MD5Util.getMD5String(string + dr);
        String mD5String2 = MD5Util.getMD5String(string + mD5String + new String(bArr));
        Log.i("kinda.NetSceneKindaGenDigitalCert", "salt " + new String(bArr));
        Log.i("kinda.NetSceneKindaGenDigitalCert", "crt_csr uin: %s: devideid: %s crt: %s", string, dr, mD5String2);
        b hhj = b.hhj();
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.hgF()) {
            i2 = 1;
        }
        String hr = hhj.hr(mD5String2, i2);
        try {
            map.put("sn_salt", com.tencent.mm.compatible.util.q.encode(str));
            map.put("crt_csr", com.tencent.mm.compatible.util.q.encode(hr));
            map.put("crt_device_id", mD5String);
            map.put("device_os", d.ics);
            map.put("device_name", d.KyL);
            AppMethodBeat.o(18666);
        } catch (Exception e2) {
            AppMethodBeat.o(18666);
        }
    }

    public NetSceneKindaGenDigitalCert(KGenDigitalCrtReq kGenDigitalCrtReq) {
        AppMethodBeat.i(18667);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        baseRequset(hashMap);
        if (kGenDigitalCrtReq.mType == 1) {
            hashMap.put("type", com.tencent.mm.compatible.util.q.encode("1"));
            hashMap.put("id_no", com.tencent.mm.compatible.util.q.encode(kGenDigitalCrtReq.getIdNo()));
            hashMap.put("id_type", com.tencent.mm.compatible.util.q.encode(new StringBuilder().append(kGenDigitalCrtReq.getIdType()).toString()));
        } else if (kGenDigitalCrtReq.mType == 2) {
            hashMap.put("type", com.tencent.mm.compatible.util.q.encode("2"));
            hashMap.put("crt_sms", com.tencent.mm.compatible.util.q.encode(kGenDigitalCrtReq.getVerifyCode()));
            hashMap.put("reqkey", com.tencent.mm.compatible.util.q.encode(kGenDigitalCrtReq.getReqKey()));
        } else if (kGenDigitalCrtReq.mType == 3) {
            hashMap.put("type", com.tencent.mm.compatible.util.q.encode(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL));
            hashMap.put("crt_token", com.tencent.mm.compatible.util.q.encode(kGenDigitalCrtReq.getToken()));
        } else if (kGenDigitalCrtReq.mType == 4) {
            hashMap.put("type", com.tencent.mm.compatible.util.q.encode("4"));
            hashMap.put("id_type", com.tencent.mm.compatible.util.q.encode(new StringBuilder().append(kGenDigitalCrtReq.getIdType()).toString()));
            hashMap.put("cre_tail", com.tencent.mm.compatible.util.q.encode(kGenDigitalCrtReq.getCreTail()));
            hashMap.put("reqkey", com.tencent.mm.compatible.util.q.encode(kGenDigitalCrtReq.getReqKey()));
        } else {
            Log.e("kinda.NetSceneKindaGenDigitalCert", "KGenDigitalCrtReq.mType is illeagl.");
        }
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(18667);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 1580;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        return 1580;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    @Override // com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public int getType() {
        return 1580;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd2(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(18668);
        super.onGYNetEnd2(eVar, jSONObject);
        Log.i("kinda.NetSceneKindaGenDigitalCert", "errCode %d errMsg %s", Integer.valueOf(eVar.errCode), eVar.errMsg);
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            if (eVar.errCode == 0) {
                boolean importCert = b.hhj().importCert(optString2, optString);
                ad.bpn(optString2);
                if (importCert) {
                    Log.i("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt success");
                } else {
                    Log.e("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt fail");
                }
            } else {
                b.hhj().hhk();
                Log.e("kinda.NetSceneKindaGenDigitalCert", " importCert crt_crt was not executed because of cgi resp error");
            }
            Log.i("kinda.NetSceneKindaGenDigitalCert", "_crt_crt %s _crt_no %s", MD5Util.getMD5String(optString), optString2);
            AppMethodBeat.o(18668);
        } catch (Exception e2) {
            Log.printErrStackTrace("kinda.NetSceneKindaGenDigitalCert", e2, "", new Object[0]);
            AppMethodBeat.o(18668);
        }
    }
}
