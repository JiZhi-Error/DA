package com.tencent.mm.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.h;
import com.tencent.mm.api.i;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements g {
    @Override // com.tencent.mm.ak.g
    public final int atz() {
        return 10002;
    }

    @Override // com.tencent.mm.ak.g
    public final int atA() {
        return 0;
    }

    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        AppMethodBeat.i(114099);
        h.b b2 = ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b(aVar);
        AppMethodBeat.o(114099);
        return b2;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        rx rxVar;
        AppMethodBeat.i(114100);
        if (!(cVar == null || !(cVar.iMd instanceof i) || (rxVar = ((i) cVar.iMd).field_businessInfo) == null || rxVar.KZo == null)) {
            try {
                String yO = rxVar.KZo.yO();
                Log.i("FunctionMsg.NewXmlMsgExtension", "bussinessInfo:%s", yO);
                JSONObject jSONObject = new JSONObject(yO);
                cVar.iMf = jSONObject.optString("msgid");
                cVar.iMe = jSONObject.optString("msgtype");
            } catch (JSONException e2) {
            }
        }
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b(cVar);
        AppMethodBeat.o(114100);
    }
}
