package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import org.json.JSONObject;

public final class l extends h {
    public String AII;

    @Override // com.tencent.mm.plugin.offline.a.h
    public final int getTenpayCgicmd() {
        return 78;
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66304);
        this.AII = jSONObject.optString("barcode");
        AppMethodBeat.o(66304);
    }

    @Override // com.tencent.mm.network.m, com.tencent.mm.plugin.offline.a.h
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66305);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        AppMethodBeat.o(66305);
    }
}
