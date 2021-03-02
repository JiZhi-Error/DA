package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;

public final class f {
    public static long IoT = 0;
    public static int IoU = 2;
    public static int IoV = 1;
    public static int IoW = 2;

    public static void fUi() {
        AppMethodBeat.i(71645);
        IoT = System.currentTimeMillis();
        AppMethodBeat.o(71645);
    }

    public static int fUj() {
        AppMethodBeat.i(71646);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - IoT) / 1000);
        AppMethodBeat.o(71646);
        return currentTimeMillis;
    }

    public static void b(Activity activity, Bundle bundle, int i2) {
        AppMethodBeat.i(71647);
        d by = a.by(activity);
        if (t.fQI().fRk() || by == null || !by.hgK()) {
            if (!t.fQI().fRk() && bundle != null && bundle.getBoolean("key_is_bind_reg_process", false)) {
                h.INSTANCE.a(10932, Integer.valueOf(i2), Integer.valueOf(bundle.getInt("key_bind_scene", 0)));
            }
            AppMethodBeat.o(71647);
            return;
        }
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        Orders orders = (Orders) bundle.getParcelable("key_orders");
        if (!(payInfo == null || orders == null)) {
            h.INSTANCE.a(10725, Integer.valueOf(i2), Integer.valueOf(payInfo.dVv), Integer.valueOf((int) (orders.dDO * 100.0d)), orders.AOl);
        }
        AppMethodBeat.o(71647);
    }

    public static void jV(int i2, int i3) {
        AppMethodBeat.i(71648);
        h.INSTANCE.a(10932, Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(71648);
    }

    public static void a(PayInfo payInfo, Orders orders) {
        AppMethodBeat.i(71649);
        if (!(t.fQI().fRk() || payInfo == null || orders == null)) {
            h.INSTANCE.a(10725, 1, Integer.valueOf(payInfo.dVv), Integer.valueOf((int) (orders.dDO * 100.0d)), orders.AOl);
        }
        AppMethodBeat.o(71649);
    }
}
