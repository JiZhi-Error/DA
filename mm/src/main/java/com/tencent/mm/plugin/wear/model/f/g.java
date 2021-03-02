package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.io.IOException;

public final class g extends b {
    private ca dTX;

    public g(ca caVar) {
        this.dTX = caVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30127);
        eyu eyu = new eyu();
        String str = this.dTX.field_content;
        if (str != null) {
            k.b aD = k.b.aD(str, this.dTX.field_reserved);
            if (aD == null || !aD.iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                Log.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
                AppMethodBeat.o(30127);
                return;
            }
            eyu.KMm = this.dTX.field_msgId;
            eyu.MRZ = this.dTX.field_talker;
            String str2 = this.dTX.field_isSend == 1 ? aD.iyl : aD.iyk;
            eyu.Title = h.aWo(this.dTX.field_talker);
            if (ab.Eq(this.dTX.field_talker)) {
                eyu.iAc = String.format(MMApplicationContext.getContext().getString(R.string.ffw), h.aWo(d(this.dTX.field_talker, this.dTX)), (char) 8203, str2);
            } else {
                eyu.iAc = str2;
            }
            try {
                a.fVQ();
                r.a(20014, eyu.toByteArray(), true);
                com.tencent.mm.plugin.wear.model.c.a.jZ(10, 0);
                com.tencent.mm.plugin.wear.model.c.a.aff(10);
                AppMethodBeat.o(30127);
            } catch (IOException e2) {
                AppMethodBeat.o(30127);
            }
        } else {
            Log.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
            AppMethodBeat.o(30127);
        }
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
