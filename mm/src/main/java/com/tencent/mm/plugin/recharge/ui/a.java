package com.tencent.mm.plugin.recharge.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class a {
    public static MallRechargeProduct gb(List<MallRechargeProduct> list) {
        AppMethodBeat.i(67155);
        for (MallRechargeProduct mallRechargeProduct : list) {
            if (mallRechargeProduct.isDefault && mallRechargeProduct.isValid()) {
                Log.d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
                AppMethodBeat.o(67155);
                return mallRechargeProduct;
            }
        }
        Log.d("MicroMsg.MallRechargeLogic", "products.get(0)");
        MallRechargeProduct mallRechargeProduct2 = list.get(0);
        AppMethodBeat.o(67155);
        return mallRechargeProduct2;
    }
}
