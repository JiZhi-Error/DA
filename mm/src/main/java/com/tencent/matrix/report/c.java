package com.tencent.matrix.report;

import com.tencent.matrix.e.b;
import org.json.JSONObject;

public class c {
    public JSONObject cWe;
    public b cWf;
    public String key;
    public String tag;
    public int type;

    public c() {
    }

    public c(int i2) {
        this.type = i2;
    }

    public c(JSONObject jSONObject) {
        this.cWe = jSONObject;
    }

    public String toString() {
        String str = "";
        if (this.cWe != null) {
            str = this.cWe.toString();
        }
        return String.format("tag[%s]type[%d];key[%s];content[%s]", this.tag, Integer.valueOf(this.type), this.key, str);
    }
}
