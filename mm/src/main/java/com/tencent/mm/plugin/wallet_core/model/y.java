package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hf;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y extends hf {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public static void bN(JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(70414);
        e fQM = t.fQM();
        if (jSONObject == null || fQM == null) {
            StringBuilder append = new StringBuilder("json==null?").append(jSONObject == null).append("  stg==null?");
            if (fQM != null) {
                z = false;
            }
            Log.e("MicroMsg.WalletBulletin", append.append(z).toString());
            AppMethodBeat.o(70414);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banner_map");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_content_array");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (optJSONArray == null || optJSONArray2 == null) {
            StringBuilder append2 = new StringBuilder("scenes==null?").append(optJSONArray == null).append("  contents==null?");
            if (optJSONArray2 != null) {
                z = false;
            }
            Log.e("MicroMsg.WalletBulletin", append2.append(z).toString());
            AppMethodBeat.o(70414);
            return;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("banner_type");
                String optString2 = optJSONObject.optString("banner_template_id");
                Log.i("MicroMsg.WalletBulletin", "sceneid=" + optString + "; contentid=" + optString2);
                if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(optString2)) {
                    hashMap.put(optString, optString2);
                    Log.i("MicroMsg.WalletBulletin", "sceneid:" + optString + " map contentid:" + optString2);
                }
            }
        }
        int length2 = optJSONArray2.length();
        for (int i3 = 0; i3 < length2; i3++) {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
            if (optJSONObject2 != null) {
                hashMap2.put(optJSONObject2.optString("banner_template_id"), Integer.valueOf(i3));
            }
        }
        if (hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                String str2 = (String) hashMap.get(str);
                if (hashMap2.containsKey(str2)) {
                    Log.i("MicroMsg.WalletBulletin", "find contentid:" + str2 + "in contentMap");
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(((Integer) hashMap2.get(str2)).intValue());
                    y yVar = new y();
                    yVar.field_bulletin_scene = str;
                    yVar.field_bulletin_content = optJSONObject3.optString("content");
                    yVar.field_bulletin_url = optJSONObject3.optString("url");
                    fQM.insert(yVar);
                } else {
                    Log.e("MicroMsg.WalletBulletin", "can not find contentid:" + str2 + "in contentMap");
                }
            }
        }
        AppMethodBeat.o(70414);
    }

    static {
        AppMethodBeat.i(70415);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "bulletin_scene";
        mAutoDBInfo.colsMap.put("bulletin_scene", "TEXT PRIMARY KEY ");
        sb.append(" bulletin_scene TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "bulletin_scene";
        mAutoDBInfo.columns[1] = "bulletin_content";
        mAutoDBInfo.colsMap.put("bulletin_content", "TEXT");
        sb.append(" bulletin_content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "bulletin_url";
        mAutoDBInfo.colsMap.put("bulletin_url", "TEXT");
        sb.append(" bulletin_url TEXT");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70415);
    }
}
