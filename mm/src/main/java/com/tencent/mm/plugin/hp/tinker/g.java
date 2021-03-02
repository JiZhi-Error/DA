package com.tencent.mm.plugin.hp.tinker;

import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g extends a {
    @Override // com.tinkerboots.sdk.a.a.a, com.tinkerboots.sdk.a.a.b
    public final boolean dZo() {
        AppMethodBeat.i(117494);
        boolean dZo = super.dZo();
        AppMethodBeat.o(117494);
        return dZo;
    }

    @Override // com.tinkerboots.sdk.a.a.a, com.tinkerboots.sdk.a.a.b
    public final void ao(Map<String, String> map) {
        AppMethodBeat.i(117495);
        super.ao(map);
        b.Mg(2);
        String aKw = com.tencent.mm.loader.j.a.aKw();
        String aKx = com.tencent.mm.loader.j.a.aKx();
        LinkedList linkedList = new LinkedList();
        for (String str : map.keySet()) {
            cxu cxu = new cxu();
            cxu.key = str;
            cxu.value = map.get(str);
            linkedList.add(cxu);
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cxu cxu2 = (cxu) it.next();
            sb.append(cxu2.key).append(":").append(cxu2.value).append("\n");
        }
        Log.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", aKw, aKx, sb.toString());
        com.tencent.mm.kernel.g.azz().a(new d(aKw, aKx, linkedList), 0);
        AppMethodBeat.o(117495);
    }

    @Override // com.tinkerboots.sdk.a.a.a, com.tinkerboots.sdk.a.a.b
    public final void dZp() {
        AppMethodBeat.i(117496);
        super.dZp();
        com.tinkerboots.sdk.a.hvX().ol(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(Util.MAX_32BIT_VALUE & ((long) com.tencent.mm.kernel.a.azs()))).ol(TencentLocation.NETWORK_PROVIDER, String.valueOf(NetStatusUtil.isWifi(MMApplicationContext.getContext()) ? 3 : 2)).ol("flavor-version", String.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wechat_flavor_version, 0)));
        List<com.tencent.mm.plugin.boots.a.a> ckR = ((c) com.tencent.mm.kernel.g.af(c.class)).ckR();
        if (ckR != null) {
            for (com.tencent.mm.plugin.boots.a.a aVar : ckR) {
                com.tinkerboots.sdk.a.hvX().ol(Integer.toHexString(aVar.field_key), String.valueOf(aVar.field_dau));
            }
        }
        AppMethodBeat.o(117496);
    }
}
