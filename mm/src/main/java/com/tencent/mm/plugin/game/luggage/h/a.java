package com.tencent.mm.plugin.game.luggage.h;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements b<Bundle, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        Set<String> keySet;
        AppMethodBeat.i(83220);
        Bundle bundle2 = bundle;
        if (!(bundle2 == null || (keySet = bundle2.keySet()) == null)) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : keySet) {
                    jSONObject.put(str, bundle2.get(str));
                }
                it itVar = new it();
                itVar.dNs.EX = 4;
                itVar.dNs.param = jSONObject.toString();
                EventCenter.instance.publish(itVar);
            } catch (JSONException e2) {
                AppMethodBeat.o(83220);
                return;
            }
        }
        AppMethodBeat.o(83220);
    }
}
