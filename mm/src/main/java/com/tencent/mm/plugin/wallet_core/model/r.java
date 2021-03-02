package com.tencent.mm.plugin.wallet_core.model;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {
    public String HWN;
    public String HWO;
    public int HYx;
    public List<a> HYy = new ArrayList();
    public int pTI;
    public boolean pTt;
    public String url;

    public static class a {
        public String HYt;
        public String HYu;
        public String HYz;
        public String language;
    }

    public r() {
        AppMethodBeat.i(214194);
        AppMethodBeat.o(214194);
    }

    public static r bJ(JSONObject jSONObject) {
        JSONArray optJSONArray;
        AppMethodBeat.i(214195);
        if (jSONObject != null) {
            r rVar = new r();
            rVar.HYx = jSONObject.optInt("block_layer_report_id");
            rVar.pTt = jSONObject.optBoolean("is_show");
            rVar.pTI = jSONObject.optInt(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
            rVar.HWN = jSONObject.optString("tiny_app_username");
            rVar.HWO = jSONObject.optString("tiny_app_path");
            rVar.url = jSONObject.optString("url");
            if (jSONObject.has("text_info_array") && (optJSONArray = jSONObject.optJSONArray("text_info_array")) != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    a aVar = new a();
                    aVar.HYt = optJSONObject.optString("main_wording");
                    aVar.HYu = optJSONObject.optString("reminder_content");
                    aVar.HYz = optJSONObject.optString("action_btn_text");
                    aVar.language = optJSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                    rVar.HYy.add(aVar);
                }
            }
            AppMethodBeat.o(214195);
            return rVar;
        }
        AppMethodBeat.o(214195);
        return null;
    }
}
