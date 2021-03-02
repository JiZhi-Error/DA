package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static Orders a(Orders orders, String str, String str2, int i2, String str3) {
        AppMethodBeat.i(72086);
        if (orders == null || orders.HZd == null || orders.HZd.size() <= 0) {
            Log.d("MicroMsg.OrdersWrapper", "hy: params error");
            AppMethodBeat.o(72086);
        } else {
            for (Orders.Commodity commodity : orders.HZd) {
                commodity.AOh = i2;
                commodity.AOe = str.equals("1") ? "2" : "1";
                commodity.AOf = str2;
                commodity.AOj = str3;
            }
            AppMethodBeat.o(72086);
        }
        return orders;
    }
}
