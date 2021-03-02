package com.tencent.b.a.a;

import android.content.Context;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n implements Runnable {
    public static long dfZ = -1;
    private a dfX = null;
    int dfY = 0;
    private Context mContext = null;
    private int mType = 0;

    public n(Context context, int i2) {
        this.mContext = context;
        this.mType = i2;
    }

    private void Uc() {
        AppMethodBeat.i(87614);
        g M = r.bs(this.mContext).M(new ArrayList(Arrays.asList(1)));
        g M2 = r.bs(this.mContext).M(new ArrayList(Arrays.asList(2)));
        g M3 = r.bs(this.mContext).M(new ArrayList(Arrays.asList(4)));
        if (!s.b(M, M2) || !s.b(M, M3)) {
            g a2 = s.a(s.a(M, M2), s.a(M, M3));
            new StringBuilder("local mid check failed, redress with mid:").append(a2.toString());
            s.Uf();
            r.bs(this.mContext).b(a2);
            AppMethodBeat.o(87614);
            return;
        }
        s.Uf();
        AppMethodBeat.o(87614);
    }

    private void r(JSONObject jSONObject) {
        AppMethodBeat.i(87615);
        if (i.dfN != null) {
            if (j.dfT == 1) {
                s.Uf();
                AppMethodBeat.o(87615);
                return;
            } else if (j.dfU <= 0 || this.dfY <= j.dfU) {
                String jSONObject2 = new m(this.mContext, jSONObject).toJSONObject().toString();
                "request data:".concat(String.valueOf(jSONObject2));
                s.Uf();
                i.dfN.eW("[" + jSONObject2 + "]");
                dfZ = System.currentTimeMillis();
                this.dfY++;
            } else {
                new StringBuilder("limit dispatch:").append(j.dfU);
                s.Uf();
                AppMethodBeat.o(87615);
                return;
            }
        }
        AppMethodBeat.o(87615);
    }

    public final void run() {
        AppMethodBeat.i(87616);
        new StringBuilder("request type:").append(this.mType);
        s.Uf();
        switch (this.mType) {
            case 1:
                r(null);
                AppMethodBeat.o(87616);
                return;
            case 2:
                if (this.dfX == null) {
                    this.dfX = r.bs(this.mContext).Ue();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i.dfO <= 0) {
                    i.dfO = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0);
                }
                long abs = Math.abs(currentTimeMillis - i.dfO);
                new StringBuilder("check entity: ").append(this.dfX.toString()).append(",duration:").append(abs);
                s.Uf();
                if (this.dfX.dfq < 0 || this.dfX.dfq > 100) {
                    this.dfX.dfq = 3;
                }
                long j2 = ((long) this.dfX.dfq) * e.dfI;
                new StringBuilder("duration:").append(abs).append(",maxCheckDays:").append(j2).append(",mLastCheckTime:").append(i.dfO).append(",mCheckEntity:").append(this.dfX);
                s.Uf();
                if (abs >= j2) {
                    Uc();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dur", abs);
                        jSONObject.put("md", j2);
                        jSONObject.put("lct", i.dfO);
                        jSONObject.put("cur", currentTimeMillis);
                    } catch (JSONException e2) {
                    }
                    if (dfZ <= 0) {
                        r(jSONObject);
                    }
                } else if (abs > e.dfI) {
                    Uc();
                    AppMethodBeat.o(87616);
                    return;
                }
                AppMethodBeat.o(87616);
                return;
            default:
                new StringBuilder("wrong type:").append(this.mType);
                s.Uf();
                AppMethodBeat.o(87616);
                return;
        }
    }
}
