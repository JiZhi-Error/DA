package com.tencent.mm.plugin.expt.h;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public int adT;
    public HashMap<String, String> cache = null;
    public long endTime;
    public int sLf;
    public int sLg;
    public String sLh;
    public int sLi;
    public int sLj;
    public String sLk;
    public long startTime;

    public final boolean TN(String str) {
        AppMethodBeat.i(215254);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(215254);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.sLf = jSONObject.optInt("ExptId");
            this.adT = jSONObject.optInt("GroupId");
            this.sLg = jSONObject.optInt("ExptSequence");
            this.sLh = str;
            this.startTime = jSONObject.optLong("StartTime");
            this.endTime = jSONObject.optLong("EndTime");
            this.sLi = jSONObject.optInt("ExptType");
            this.sLj = jSONObject.optInt("SvrType");
            this.sLk = jSONObject.optString("ExptCheckSum");
            cRH();
            Log.v("MicroMsg.ExptAppItem", "convertFrom new [%s] args[%s]", toString(), str);
            AppMethodBeat.o(215254);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.ExptAppItem", "%d convertFrom [%s] error [%s]", Integer.valueOf(hashCode()), str, e2.toString());
            AppMethodBeat.o(215254);
            return false;
        }
    }

    public final HashMap<String, String> cRH() {
        HashMap<String, String> hashMap;
        Exception exc;
        AppMethodBeat.i(215255);
        if (this.cache != null) {
            HashMap<String, String> hashMap2 = this.cache;
            AppMethodBeat.o(215255);
            return hashMap2;
        }
        if (!Util.isNullOrNil(this.sLh)) {
            try {
                Object obj = new JSONObject(this.sLh).get("Args");
                if (obj == null) {
                    AppMethodBeat.o(215255);
                    return null;
                }
                HashMap<String, String> hashMap3 = new HashMap<>();
                try {
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray != null) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                a(hashMap3, jSONArray.getJSONObject(i2));
                            }
                        }
                        hashMap = hashMap3;
                    } else {
                        if (obj instanceof JSONObject) {
                            a(hashMap3, (JSONObject) obj);
                        }
                        hashMap = hashMap3;
                    }
                } catch (Exception e2) {
                    exc = e2;
                    hashMap = hashMap3;
                    Log.e("MicroMsg.ExptAppItem", "get expt item error [%s] exptId[%d]", exc.toString(), Integer.valueOf(this.sLf));
                    this.cache = hashMap;
                    HashMap<String, String> hashMap4 = this.cache;
                    AppMethodBeat.o(215255);
                    return hashMap4;
                }
            } catch (Exception e3) {
                exc = e3;
                hashMap = null;
                Log.e("MicroMsg.ExptAppItem", "get expt item error [%s] exptId[%d]", exc.toString(), Integer.valueOf(this.sLf));
                this.cache = hashMap;
                HashMap<String, String> hashMap42 = this.cache;
                AppMethodBeat.o(215255);
                return hashMap42;
            }
        } else {
            hashMap = null;
        }
        this.cache = hashMap;
        HashMap<String, String> hashMap422 = this.cache;
        AppMethodBeat.o(215255);
        return hashMap422;
    }

    private static void a(HashMap<String, String> hashMap, JSONObject jSONObject) {
        String str;
        AppMethodBeat.i(215256);
        if (jSONObject == null) {
            AppMethodBeat.o(215256);
            return;
        }
        String optString = jSONObject.optString("Key");
        String optString2 = jSONObject.optString("Val");
        if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(optString2)) {
            byte[] decode = Base64.decode(optString2, 0);
            if (decode == null || decode.length <= 0) {
                str = optString2;
            } else if (decode.length <= 1048576) {
                try {
                    str = new String(decode, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (Exception e2) {
                    str = optString2;
                } catch (Error e3) {
                    str = optString2;
                }
            } else {
                Log.e("MicroMsg.ExptAppItem", "data length more 1M don't parse, reset value. key[%s]", optString);
                str = "";
            }
            hashMap.put(optString, str);
        }
        AppMethodBeat.o(215256);
    }

    public final String toString() {
        AppMethodBeat.i(215257);
        String str = "ExptAppItem{exptId=" + this.sLf + ", groupId=" + this.adT + ", exptSeq=" + this.sLg + ", exptContent='" + this.sLh + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", exptType=" + this.sLi + ", svrType=" + this.sLj + ", exptCheckSum='" + this.sLk + '\'' + '}';
        AppMethodBeat.o(215257);
        return str;
    }

    public final boolean isReady() {
        boolean z = false;
        AppMethodBeat.i(215258);
        if (this.sLg >= 0) {
            long nowSecond = Util.nowSecond();
            if (nowSecond >= this.startTime && (this.endTime <= 0 || nowSecond <= this.endTime)) {
                z = true;
            }
        }
        AppMethodBeat.o(215258);
        return z;
    }
}
