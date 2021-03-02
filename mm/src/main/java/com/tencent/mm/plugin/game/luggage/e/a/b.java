package com.tencent.mm.plugin.game.luggage.e.a;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.a;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private String mAppId;
    List<coq> xxx;
    Map<Integer, a> xxy = new HashMap();

    public b(String str) {
        AppMethodBeat.i(83096);
        this.mAppId = str;
        dTz();
        a(new h());
        a(new f());
        a(new j());
        a(new g());
        a(new i());
        a(new d());
        a(new e());
        AppMethodBeat.o(83096);
    }

    private void a(a aVar) {
        AppMethodBeat.i(83097);
        this.xxy.put(Integer.valueOf(aVar.id), aVar);
        AppMethodBeat.o(83097);
    }

    private void dTz() {
        AppMethodBeat.i(83098);
        this.xxx = a.JrL;
        try {
            CommonLogicTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 9;
            commonLogicTask.dQL.putString("game_hv_menu_appid", this.mAppId);
            AppBrandMainProcessService.b(commonLogicTask);
            String string = commonLogicTask.dQL.getString("game_hv_menu_pbcache");
            if (!Util.isNullOrNil(string)) {
                byte[] bytes = string.getBytes(KindaConfigCacheStg.SAVE_CHARSET);
                can can = new can();
                can.parseFrom(bytes);
                if (!Util.isNullOrNil(can.MfF)) {
                    this.xxx = can.MfF;
                    Log.i("MicroMsg.H5GameMenuHelp", "use net menu data");
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", e2.getMessage());
        }
        Collections.sort(this.xxx, new Comparator<coq>() {
            /* class com.tencent.mm.plugin.game.luggage.e.a.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(coq coq, coq coq2) {
                return coq.MuP - coq2.MuP;
            }
        });
        int i2 = this.xxx.get(this.xxx.size() - 1).MuP;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(null);
        }
        for (coq coq : this.xxx) {
            if (coq.MuP > 0 && coq.MuP <= arrayList.size()) {
                arrayList.set(coq.MuP - 1, coq);
            }
        }
        this.xxx = arrayList;
        AppMethodBeat.o(83098);
    }
}
