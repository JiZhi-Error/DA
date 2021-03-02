package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.g.a.a.a;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public final class h implements a {
    protected final Properties Sft;

    public h() {
        this(null);
    }

    public h(Properties properties) {
        AppMethodBeat.i(189659);
        this.Sft = new Properties();
        if (properties != null) {
            for (Map.Entry entry : properties.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        AppMethodBeat.o(189659);
    }

    @Override // com.tencent.thumbplayer.g.a.a.a
    public final void put(String str, String str2) {
        AppMethodBeat.i(189660);
        if (str != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.Sft.put(str, str2);
                AppMethodBeat.o(189660);
                return;
            }
            this.Sft.put(str, "");
        }
        AppMethodBeat.o(189660);
    }

    @Override // com.tencent.thumbplayer.g.a.a.a
    public final void put(String str, int i2) {
        AppMethodBeat.i(189661);
        this.Sft.put(str, String.valueOf(i2));
        AppMethodBeat.o(189661);
    }

    @Override // com.tencent.thumbplayer.g.a.a.a
    public final void put(String str, long j2) {
        AppMethodBeat.i(189662);
        this.Sft.put(str, String.valueOf(j2));
        AppMethodBeat.o(189662);
    }

    @Override // com.tencent.thumbplayer.g.a.a.a
    public final void put(String str, float f2) {
        AppMethodBeat.i(189663);
        this.Sft.put(str, String.valueOf(f2));
        AppMethodBeat.o(189663);
    }

    public final Properties getProperties() {
        return this.Sft;
    }

    public final String toString() {
        AppMethodBeat.i(189664);
        JSONObject jSONObject = new JSONObject(this.Sft);
        if (jSONObject.has("data")) {
            try {
                String string = jSONObject.getString("data");
                jSONObject.remove("data");
                jSONObject.put("data", new JSONObject(string));
            } catch (JSONException e2) {
                g.e("TPProperties", e2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(189664);
        return jSONObject2;
    }
}
