package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import com.facebook.device.yearclass.DeviceInfo;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public class y extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getSystemInfo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78560);
        HashMap hashMap = new HashMap();
        hashMap.put("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("cpuCores", Integer.valueOf(DeviceInfo.getNumberOfCPUCores()));
        hashMap.put("cpuFreqHz", Integer.valueOf(DeviceInfo.getCPUMaxFreqKHz()));
        hashMap.put("memory", Long.valueOf(DeviceInfo.getTotalMemory(MMApplicationContext.getContext())));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        aVar.e("", hashMap);
        AppMethodBeat.o(78560);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
