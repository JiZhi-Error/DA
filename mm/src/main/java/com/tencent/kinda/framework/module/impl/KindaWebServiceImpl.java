package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KindaWebService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;

public class KindaWebServiceImpl implements KindaWebService {
    private static final String TAG = "MicroMsg.KindaWebServiceImpl";

    @Override // com.tencent.kinda.gen.KindaWebService
    public void preLoad(String str) {
        AppMethodBeat.i(214452);
        Log.i(TAG, "preload Url:".concat(String.valueOf(str)));
        if (str.length() == 0) {
            AppMethodBeat.o(214452);
            return;
        }
        e.a aVar = new e.a();
        aVar.url = str;
        aVar.pmM = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        ((e) g.af(e.class)).cu(arrayList);
        AppMethodBeat.o(214452);
    }
}
