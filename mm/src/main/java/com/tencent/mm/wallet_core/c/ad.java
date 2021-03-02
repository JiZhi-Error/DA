package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad {
    private static ad Rut;
    private int Run = 0;
    public String Ruo = "";
    public String Rup = "";
    public String Ruq = "";
    public String Rur = "";
    public Vector<ac> Rus = new Vector<>();
    public String TAG = "MicroMsg.WalletDigCertManager";

    public static void bpn(String str) {
        AppMethodBeat.i(72812);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLETDIGITAL_CERT_NO_STRING_SYNC, str);
        AppMethodBeat.o(72812);
    }

    public static String getCrtNo() {
        AppMethodBeat.i(72813);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLETDIGITAL_CERT_NO_STRING_SYNC, "");
        AppMethodBeat.o(72813);
        return str;
    }

    public ad() {
        AppMethodBeat.i(72814);
        AppMethodBeat.o(72814);
    }

    public static ad hhv() {
        AppMethodBeat.i(72815);
        if (Rut == null) {
            Rut = new ad();
        }
        ad adVar = Rut;
        AppMethodBeat.o(72815);
        return adVar;
    }

    public final void ck(JSONObject jSONObject) {
        AppMethodBeat.i(72817);
        JSONObject optJSONObject = jSONObject.optJSONObject("cert_info");
        if (optJSONObject == null) {
            AppMethodBeat.o(72817);
            return;
        }
        this.Rus = new Vector<>();
        int optInt = optJSONObject.optInt("show_crt_info");
        this.Run = optJSONObject.optInt("is_crt_install");
        this.Rur = optJSONObject.optString("crt_item_logo_url");
        this.Ruo = optJSONObject.optString("crt_entry_desc");
        this.Rup = optJSONObject.optString("crt_entry_title");
        this.Ruq = optJSONObject.optString("crt_status_name");
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC, Integer.valueOf(optInt));
        String crtNo = getCrtNo();
        JSONArray optJSONArray = optJSONObject.optJSONArray("crt_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    ac acVar = new ac(optJSONArray.getJSONObject(i2));
                    if (acVar.Rum == 0) {
                        this.Rus.add(acVar);
                    } else if (Util.isNullOrNil(crtNo)) {
                        Log.i(this.TAG, "drop crt list no exist local drop: %s", acVar.NgK);
                    } else if (acVar.NgK.equals(crtNo)) {
                        this.Rus.add(acVar);
                    } else {
                        Log.i(this.TAG, "drop crt list %s drop: %s", crtNo, acVar.NgK);
                    }
                } catch (Exception e2) {
                    Log.i(this.TAG, "WalletDigCertManager error %s", e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(72817);
    }

    public final void bpo(String str) {
        AppMethodBeat.i(72818);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(72818);
            return;
        }
        if (str.equals(getCrtNo())) {
            this.Run = 0;
            bpn("");
            Log.i(this.TAG, "clean token %s  stack %s ", str, Util.getStack().toString());
            b.hhj();
            b.clearCert(str);
        }
        Iterator<ac> it = this.Rus.iterator();
        while (it.hasNext()) {
            ac next = it.next();
            if (Util.isEqual(str, next.NgK)) {
                this.Rus.remove(next);
                AppMethodBeat.o(72818);
                return;
            }
        }
        AppMethodBeat.o(72818);
    }

    public final boolean hhw() {
        AppMethodBeat.i(72816);
        if (Util.isNullOrNil(getCrtNo())) {
            AppMethodBeat.o(72816);
            return false;
        } else if (this.Run > 0) {
            AppMethodBeat.o(72816);
            return true;
        } else {
            AppMethodBeat.o(72816);
            return false;
        }
    }
}
