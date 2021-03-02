package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public enum e {
    INSTANCE;
    
    private Map<String, WeakReference<d>> IcU = new HashMap();

    private e(String str) {
        AppMethodBeat.i(70671);
        AppMethodBeat.o(70671);
    }

    public static e valueOf(String str) {
        AppMethodBeat.i(70670);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(70670);
        return eVar;
    }

    static {
        AppMethodBeat.i(70674);
        AppMethodBeat.o(70674);
    }

    public final d a(Orders orders) {
        AppMethodBeat.i(70672);
        String b2 = b(orders);
        if (Util.isNullOrNil(b2)) {
            Log.w("MicroMsg.FavorLogicHelperPool", "get key null");
            AppMethodBeat.o(70672);
            return null;
        }
        if (this.IcU.containsKey(b2)) {
            Log.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(b2)));
            WeakReference<d> weakReference = this.IcU.get(b2);
            if (weakReference != null) {
                d dVar = weakReference.get();
                if (dVar != null) {
                    AppMethodBeat.o(70672);
                    return dVar;
                }
                Log.i("MicroMsg.FavorLogicHelperPool", "helper null");
            } else {
                Log.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
            }
        }
        if (orders == null || orders.HZe == null) {
            AppMethodBeat.o(70672);
            return null;
        }
        d dVar2 = new d(orders.HZe);
        this.IcU.put(b2, new WeakReference<>(dVar2));
        AppMethodBeat.o(70672);
        return dVar2;
    }

    private static String b(Orders orders) {
        AppMethodBeat.i(70673);
        if (orders == null || orders.HZd == null) {
            AppMethodBeat.o(70673);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < orders.HZd.size(); i2++) {
            sb.append(orders.HZd.get(i2).dDM);
        }
        sb.append("@");
        sb.append(orders.HYL);
        String sb2 = sb.toString();
        AppMethodBeat.o(70673);
        return sb2;
    }
}
