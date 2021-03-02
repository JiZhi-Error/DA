package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.fcw;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class o extends b<lm> {

    public enum a {
        DEFAULT(100),
        RECENTS_LIST(101),
        TASK_BAR(102),
        STAR_LIST(103),
        MP_PRELOAD(104),
        BIZ_BIND_WXA(105),
        WXA_CUSTOMER_SERVICE(106),
        WXA_PLUGIN_JSAPI(107),
        WXA_RECOMMEND_LIST(108),
        WXA_RECOMMEND_CARD_LIST(109),
        WALLET_MALL_INDEX(110),
        CHATTING(111),
        QRCODE(112),
        QRCODE_PRE(113);
        
        final int intValue;

        public static a valueOf(String str) {
            AppMethodBeat.i(44850);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44850);
            return aVar;
        }

        static {
            AppMethodBeat.i(44851);
            AppMethodBeat.o(44851);
        }

        private a(int i2) {
            this.intValue = i2;
        }
    }

    o(List<String> list, a aVar) {
        super((byte) 0);
        AppMethodBeat.i(44852);
        Log.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.intValue));
        ll llVar = new ll();
        llVar.Scene = aVar.intValue;
        for (String str : list) {
            if (!Util.isNullOrNil(str)) {
                fcw fcw = new fcw();
                fcw.Mmv = str;
                fcw.KSW = n.buC().Xp(str);
                llVar.KOw.add(fcw);
            }
        }
        a(llVar);
        AppMethodBeat.o(44852);
    }

    public o(String str) {
        super((byte) 0);
        AppMethodBeat.i(226461);
        ll llVar = new ll();
        llVar.Scene = a.QRCODE_PRE.intValue;
        fcw fcw = new fcw();
        fcw.qwo = str;
        llVar.KOw.add(fcw);
        a(llVar);
        AppMethodBeat.o(226461);
    }

    private void a(ll llVar) {
        AppMethodBeat.i(226462);
        d.a aVar = new d.a();
        aVar.iLN = llVar;
        aVar.iLO = new lm();
        aVar.funcId = 1192;
        aVar.uri = at.lyN;
        c(aVar.aXF());
        AppMethodBeat.o(226462);
    }
}
