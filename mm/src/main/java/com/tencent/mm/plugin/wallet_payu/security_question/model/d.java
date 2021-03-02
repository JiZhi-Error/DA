package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public ArrayList<PayUSecurityQuestion> IuJ;

    public d() {
        AppMethodBeat.i(72213);
        setRequestData(new HashMap());
        AppMethodBeat.o(72213);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 11;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72214);
        if (jSONObject != null) {
            this.IuJ = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("security_question_list");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        this.IuJ.add(new PayUSecurityQuestion(optJSONObject.optString("id"), optJSONObject.optString("description")));
                    }
                }
            }
        }
        AppMethodBeat.o(72214);
    }
}
