package com.google.firebase.iid;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class q {
    private static final long bLT = TimeUnit.DAYS.toMillis(7);
    final String bLU;
    private final String bLV;
    private final long timestamp;

    static {
        AppMethodBeat.i(4200);
        AppMethodBeat.o(4200);
    }

    private q(String str, String str2, long j2) {
        this.bLU = str;
        this.bLV = str2;
        this.timestamp = j2;
    }

    static String b(String str, String str2, long j2) {
        AppMethodBeat.i(4198);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put(AppMeasurement.Param.TIMESTAMP, j2);
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(4198);
            return jSONObject2;
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to encode token: ").append(valueOf);
            AppMethodBeat.o(4198);
            return null;
        }
    }

    static q bR(String str) {
        AppMethodBeat.i(4197);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(4197);
            return null;
        } else if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                q qVar = new q(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(AppMeasurement.Param.TIMESTAMP));
                AppMethodBeat.o(4197);
                return qVar;
            } catch (JSONException e2) {
                String valueOf = String.valueOf(e2);
                new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf);
                AppMethodBeat.o(4197);
                return null;
            }
        } else {
            q qVar2 = new q(str, null, 0);
            AppMethodBeat.o(4197);
            return qVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean bS(String str) {
        AppMethodBeat.i(4199);
        if (System.currentTimeMillis() > this.timestamp + bLT || !str.equals(this.bLV)) {
            AppMethodBeat.o(4199);
            return true;
        }
        AppMethodBeat.o(4199);
        return false;
    }
}
