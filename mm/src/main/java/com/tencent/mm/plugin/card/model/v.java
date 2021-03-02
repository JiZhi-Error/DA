package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.d.u;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class v extends q implements m {
    private i callback;
    public String pUf;
    public ArrayList<us> pUg;
    private final d rr;

    public v(String str, float f2, float f3, String str2) {
        AppMethodBeat.i(112821);
        this.pUf = str;
        d.a aVar = new d.a();
        aVar.iLN = new ut();
        aVar.iLO = new uu();
        aVar.uri = "/cgi-bin/micromsg-bin/cardshoplbs";
        aVar.funcId = 1058;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ut utVar = (ut) this.rr.iLK.iLR;
        utVar.pRX = str;
        utVar.dTj = f2;
        utVar.latitude = f3;
        utVar.eaO = str2;
        Log.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", str, Float.valueOf(f2), Float.valueOf(f3), str2);
        AppMethodBeat.o(112821);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1058;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112822);
        if (Util.isNullOrNil(((ut) this.rr.iLK.iLR).pRX)) {
            Log.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
            AppMethodBeat.o(112822);
            return -1;
        }
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112822);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112823);
        Log.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            String str2 = ((uu) this.rr.iLL.iLR).pTY;
            if (TextUtils.isEmpty(str2)) {
                Log.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
            }
            this.pUg = u.akq(str2);
            if (this.pUg != null) {
                Log.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", Integer.valueOf(this.pUg.size()));
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112823);
    }
}
