package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONArray;

public final class d {
    public String jFn = "ok";
    public List<c> mIe = null;

    public final String toString() {
        AppMethodBeat.i(144696);
        StringBuilder sb = new StringBuilder();
        sb.append("mErrorMsg:");
        sb.append(this.jFn);
        sb.append(" mWifiList:");
        if (this.mIe == null || this.mIe.size() <= 0) {
            sb.append("null:");
        } else {
            for (c cVar : this.mIe) {
                sb.append(" WiFiItem:");
                sb.append(cVar);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(144696);
        return sb2;
    }

    public final JSONArray bLF() {
        AppMethodBeat.i(144697);
        JSONArray jSONArray = new JSONArray();
        for (c cVar : this.mIe) {
            jSONArray.put(cVar.toJSONObject());
        }
        AppMethodBeat.o(144697);
        return jSONArray;
    }
}
