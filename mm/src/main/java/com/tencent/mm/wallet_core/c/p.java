package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends m {
    private int RtU = 0;
    private a RtV = null;
    private boolean ebI = true;

    public interface a {
        void fTo();
    }

    private static void baseRequset(Map<String, String> map) {
        int i2 = 0;
        AppMethodBeat.i(72783);
        g.aAi();
        g.aAf();
        String string = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin());
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
        Log.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        Log.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", string, dr, mD5String2);
        b hhj = b.hhj();
        b.hgC();
        if (b.hgF()) {
            i2 = 1;
        }
        String hr = hhj.hr(mD5String2, i2);
        try {
            map.put("sn_salt", com.tencent.mm.compatible.util.q.encode(str));
            map.put("crt_csr", com.tencent.mm.compatible.util.q.encode(hr));
            map.put("crt_device_id", mD5String);
            map.put("device_os", d.ics);
            map.put("device_name", d.KyL);
            AppMethodBeat.o(72783);
        } catch (Exception e2) {
            AppMethodBeat.o(72783);
        }
    }

    public p(String str, int i2) {
        AppMethodBeat.i(214333);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.RtU = 1;
        baseRequset(hashMap);
        hashMap.put("type", com.tencent.mm.compatible.util.q.encode("1"));
        hashMap.put("id_no", com.tencent.mm.compatible.util.q.encode(str));
        hashMap.put("id_type", com.tencent.mm.compatible.util.q.encode(String.valueOf(i2)));
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(214333);
    }

    public p(String str, String str2, a aVar, boolean z) {
        AppMethodBeat.i(72785);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.ebI = z;
        this.RtU = 2;
        baseRequset(hashMap);
        hashMap.put("type", com.tencent.mm.compatible.util.q.encode("2"));
        hashMap.put("crt_sms", com.tencent.mm.compatible.util.q.encode(str));
        hashMap.put("reqkey", com.tencent.mm.compatible.util.q.encode(str2));
        this.RtV = aVar;
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(72785);
    }

    public p(String str, String str2, String str3, a aVar, boolean z) {
        AppMethodBeat.i(72786);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.RtU = 4;
        this.RtV = aVar;
        this.ebI = z;
        baseRequset(hashMap);
        hashMap.put("type", com.tencent.mm.compatible.util.q.encode("4"));
        hashMap.put("id_type", com.tencent.mm.compatible.util.q.encode(str));
        hashMap.put("cre_tail", com.tencent.mm.compatible.util.q.encode(str2));
        hashMap.put("reqkey", com.tencent.mm.compatible.util.q.encode(str3));
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(72786);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1580;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1580;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72787);
        Log.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", Integer.valueOf(i2), str);
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            h.INSTANCE.idkeyStat(414, 0, 1, true);
            boolean importCert = b.hhj().importCert(optString2, optString);
            ad.bpn(optString2);
            if (importCert) {
                h.INSTANCE.idkeyStat(414, 1, 1, true);
                Log.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                h.INSTANCE.idkeyStat(414, 2, 1, true);
                Log.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.RtU == 1) {
                h.INSTANCE.a(13731, 3);
            } else if (this.RtU == 2) {
                h.INSTANCE.a(13731, 7);
            }
            Log.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", MD5Util.getMD5String(optString), optString2);
            AppMethodBeat.o(72787);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", e2, "", new Object[0]);
            AppMethodBeat.o(72787);
        }
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd2(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(72788);
        b.hhj().hhk();
        if (eVar.errCode != 0) {
            if (this.RtU == 1) {
                h.INSTANCE.a(13731, 4);
            } else if (this.RtU == 2) {
                h.INSTANCE.a(13731, 8);
            }
        }
        if (this.RtV != null && (!this.ebI || eVar.errCode == 0)) {
            this.RtV.fTo();
        }
        AppMethodBeat.o(72788);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean isBlock() {
        return this.ebI;
    }
}
