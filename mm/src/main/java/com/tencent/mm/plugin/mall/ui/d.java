package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d {
    public static int f(MallFunction mallFunction) {
        AppMethodBeat.i(213560);
        if (mallFunction != null) {
            c.fSg().aVv(mallFunction.kHR);
            com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(mallFunction.kHR);
            if (mallFunction.Icf != null) {
                c.fSg();
                c.i(mallFunction);
            }
            if ("wxpay://bizmall/mobile_recharge".equals(mallFunction.egX)) {
                AppMethodBeat.o(213560);
                return 0;
            } else if ("wxpay://bizmall/weixin_hongbao".equals(mallFunction.egX)) {
                AppMethodBeat.o(213560);
                return 4;
            } else if ("wxpay://bizmall/weixin_scan_qrcode".equals(mallFunction.egX)) {
                AppMethodBeat.o(213560);
                return 8;
            } else if ("wxpay://bizmall/weixin_transfer".equals(mallFunction.egX)) {
                AppMethodBeat.o(213560);
                return 5;
            } else if ("wxpay://bizmall/weixin_offline_pay".equals(mallFunction.egX)) {
                AppMethodBeat.o(213560);
                return 6;
            } else if ("wxpay://bizmall/old_mobile_recharge".equals(mallFunction.egX)) {
                AppMethodBeat.o(213560);
                return 7;
            } else if (!Util.isNullOrNil(mallFunction.h5Url)) {
                AppMethodBeat.o(213560);
                return 1;
            } else if ("wxpay://bizmall/f2f_hongbao".equals(mallFunction.egX)) {
                AppMethodBeat.o(213560);
                return 9;
            } else {
                Log.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
                AppMethodBeat.o(213560);
                return 2;
            }
        } else {
            AppMethodBeat.o(213560);
            return 3;
        }
    }
}
