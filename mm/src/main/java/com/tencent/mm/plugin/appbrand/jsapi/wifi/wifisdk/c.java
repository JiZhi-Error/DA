package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c {
    public int frequency;
    public String mHX = "";
    public String mHY = "";
    public int mHZ;
    public boolean mIa = false;
    public boolean mIb = false;
    public boolean mIc = false;

    public final String toString() {
        AppMethodBeat.i(144694);
        String str = "WiFiItem{mSsid='" + this.mHX + '\'' + ", mBssid='" + this.mHY + '\'' + ", mSignalStrength=" + this.mHZ + ", mSecurity=" + this.mIa + ", frequency=" + this.frequency + '}';
        AppMethodBeat.o(144694);
        return str;
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.i(144695);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.mHX);
        jSONObject.put("BSSID", this.mHY);
        jSONObject.put("secure", this.mIa);
        jSONObject.put("signalStrength", this.mHZ);
        jSONObject.put("frequency", this.frequency);
        AppMethodBeat.o(144695);
        return jSONObject;
    }
}
