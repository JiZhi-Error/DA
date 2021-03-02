package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbe;
import org.json.JSONObject;

public final class bi {
    public cbe yXW;

    public static bi bc(JSONObject jSONObject) {
        AppMethodBeat.i(213333);
        if (jSONObject == null) {
            AppMethodBeat.o(213333);
            return null;
        }
        bi biVar = new bi();
        biVar.yXW = ac.bb(jSONObject);
        AppMethodBeat.o(213333);
        return biVar;
    }
}
