package com.tencent.mm.plugin.webview.luggage.a;

import android.os.Bundle;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.webview.luggage.j;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class a implements b<Bundle, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(78672);
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            String string = bundle2.getString("name");
            String string2 = bundle2.getString("data");
            LinkedList<s> gbV = j.gbV();
            b bVar = new b();
            bVar.mName = string;
            try {
                bVar.csi = new JSONObject(string2);
                Iterator<s> it = gbV.iterator();
                while (it.hasNext()) {
                    it.next().ctS.a(bVar);
                }
                AppMethodBeat.o(78672);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(78672);
    }
}
