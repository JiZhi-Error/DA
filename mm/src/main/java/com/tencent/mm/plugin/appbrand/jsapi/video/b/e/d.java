package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d implements e<Map<String, List<String>>> {
    public final String mzQ;
    public final String mzR;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.e
    public final /* synthetic */ Map<String, List<String>> cI(Map<String, List<String>> map) {
        List<String> list;
        AppMethodBeat.i(234837);
        Map<String, List<String>> map2 = map;
        if (!(map2 == null || (list = map2.get("Content-Type")) == null || list.size() <= 0)) {
            String str = list.get(0);
            if (str.equals("application/octet-stream") && !TextUtils.isEmpty(this.mzR)) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, List<String>> entry : map2.entrySet()) {
                    if (entry.getKey() == null || !entry.getKey().equals("Content-Type")) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.mzR);
                        hashMap.put("Content-Type", arrayList);
                        h.log(5, this.mzQ, "fix Content-Type from " + str + " to " + this.mzR);
                    }
                }
                Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                AppMethodBeat.o(234837);
                return unmodifiableMap;
            }
        }
        AppMethodBeat.o(234837);
        return map2;
    }

    public d(String str, String str2) {
        this.mzR = str;
        this.mzQ = str2;
    }
}
