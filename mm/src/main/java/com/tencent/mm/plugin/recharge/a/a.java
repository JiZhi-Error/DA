package com.tencent.mm.plugin.recharge.a;

import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class a implements bd {
    private List<com.tencent.mm.plugin.recharge.model.a> BCU = null;

    public static a eHL() {
        AppMethodBeat.i(67084);
        a aVar = (a) y.at(a.class);
        AppMethodBeat.o(67084);
        return aVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
    }

    public final boolean a(com.tencent.mm.plugin.recharge.model.a aVar) {
        AppMethodBeat.i(67085);
        if (aVar == null || !PhoneNumberUtils.isGlobalPhoneNumber(aVar.BCX)) {
            AppMethodBeat.o(67085);
            return false;
        }
        List<com.tencent.mm.plugin.recharge.model.a> eHM = eHM();
        Iterator<com.tencent.mm.plugin.recharge.model.a> it = eHM.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mm.plugin.recharge.model.a next = it.next();
            if (aVar.BCX.equals(next.BCX)) {
                if (Util.isNullOrNil(aVar.name)) {
                    aVar.name = next.name;
                }
                eHM.remove(next);
            }
        }
        eHM.add(0, aVar);
        ga(eHM);
        AppMethodBeat.o(67085);
        return true;
    }

    public final void ga(List<com.tencent.mm.plugin.recharge.model.a> list) {
        AppMethodBeat.i(67086);
        this.BCU = list;
        if (list == null || list.size() == 0) {
            this.BCU = new LinkedList();
        } else if (list.size() > 10) {
            for (int size = list.size() - 1; size >= 10; size--) {
                list.remove(size);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.plugin.recharge.model.a aVar : this.BCU) {
            jSONArray.put(aVar.toJson());
            Log.i("MicroMsg.SubCoreRecharge", "number: %s", aVar.name);
        }
        Log.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + jSONArray.toString());
        g.aAh().azQ().set(270337, jSONArray.toString());
        g.aAh().azQ().gBI();
        AppMethodBeat.o(67086);
    }

    public final List<com.tencent.mm.plugin.recharge.model.a> eHM() {
        AppMethodBeat.i(67087);
        if (this.BCU != null) {
            List<com.tencent.mm.plugin.recharge.model.a> list = this.BCU;
            AppMethodBeat.o(67087);
            return list;
        }
        this.BCU = new LinkedList();
        String str = (String) g.aAh().azQ().get(270337, (Object) null);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.SubCoreRecharge", "empty history");
            List<com.tencent.mm.plugin.recharge.model.a> list2 = this.BCU;
            AppMethodBeat.o(67087);
            return list2;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < Math.min(jSONArray.length(), 100); i2++) {
                com.tencent.mm.plugin.recharge.model.a bj = com.tencent.mm.plugin.recharge.model.a.bj(jSONArray.getJSONObject(i2));
                if (bj != null) {
                    this.BCU.add(bj);
                }
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.SubCoreRecharge", e2, "", new Object[0]);
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (int i3 = 0; i3 < Math.min(split.length, 100); i3++) {
                    String[] split2 = split[i3].split("=");
                    if (split2.length == 2) {
                        this.BCU.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], split2[1], 2));
                    } else if (split2.length == 1) {
                        this.BCU.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], "", 2));
                    }
                }
            }
        }
        Log.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.BCU.size());
        List<com.tencent.mm.plugin.recharge.model.a> list3 = this.BCU;
        AppMethodBeat.o(67087);
        return list3;
    }

    public static com.tencent.mm.plugin.recharge.model.a eHN() {
        AppMethodBeat.i(67088);
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.recharge.model.a aVar = new com.tencent.mm.plugin.recharge.model.a(str, MMApplicationContext.getContext().getString(R.string.iqd), 3);
            AppMethodBeat.o(67088);
            return aVar;
        }
        AppMethodBeat.o(67088);
        return null;
    }
}
