package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONObject;

public final class ac {
    public String NgK = "";
    public String Ntg = "";
    public String Ruk = "";
    public String Rul = "";
    public int Rum = 0;

    public ac() {
    }

    public ac(JSONObject jSONObject) {
        AppMethodBeat.i(72811);
        this.Ruk = jSONObject.optString(TPDownloadProxyEnum.USER_DEVICE_ID);
        this.Ntg = jSONObject.optString("device_name");
        this.Rul = jSONObject.optString("device_os");
        this.Rum = jSONObject.optInt("Is_cur_device");
        this.NgK = jSONObject.optString("crt_no");
        AppMethodBeat.o(72811);
    }
}
