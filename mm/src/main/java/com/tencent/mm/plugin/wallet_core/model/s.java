package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s {
    public long HYA;
    public long HYB;
    public int HYC;
    public int HYD;
    public long HYE;
    public long crw;

    public final void bK(JSONObject jSONObject) {
        AppMethodBeat.i(70311);
        this.crw = jSONObject.optLong("activity_id");
        this.HYA = jSONObject.optLong("activity_type", 0);
        this.HYB = jSONObject.optLong("award_id");
        this.HYC = jSONObject.optInt("send_record_id");
        this.HYD = jSONObject.optInt("user_record_id");
        this.HYE = jSONObject.optLong("activity_mch_id", 0);
        AppMethodBeat.o(70311);
    }

    public static class a {
        public String Bah;
        public String HYF;
        public String HYG;
        public String name;
        public String title;
        public int type;
        public String url;

        public final void bK(JSONObject jSONObject) {
            AppMethodBeat.i(70309);
            this.url = jSONObject.optString("url");
            this.name = jSONObject.optString("wording");
            this.Bah = jSONObject.optString("icon");
            this.HYF = jSONObject.optString("btn_text");
            this.type = jSONObject.optInt("type");
            this.title = jSONObject.optString("title");
            this.HYG = jSONObject.optString("small_title");
            AppMethodBeat.o(70309);
        }
    }

    public static class b {
        public String HLz;
        public String HYH;
        public String HYI;
        public String HYJ;
        public int HYK;
        public String Hwr;
        public String Hws;

        public final void bK(JSONObject jSONObject) {
            AppMethodBeat.i(70310);
            this.HLz = jSONObject.optString("tinyapp_name");
            this.HYH = jSONObject.optString("tinyapp_logo");
            this.HYI = jSONObject.optString("tinyapp_desc");
            this.Hwr = jSONObject.optString("tinyapp_username");
            this.Hws = jSONObject.optString("tinyapp_path");
            this.HYJ = jSONObject.optString("activity_tinyapp_btn_text");
            this.HYK = jSONObject.optInt("tinyapp_version", 0);
            AppMethodBeat.o(70310);
        }
    }
}
