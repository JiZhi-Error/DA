package com.tencent.mm.plugin.expt.h;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.br;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends br {
    public static IAutoDBItem.MAutoDBInfo info;
    private HashMap<String, String> cache = null;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean TN(String str) {
        AppMethodBeat.i(156037);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(156037);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String cVar = toString();
            this.field_exptContent = str;
            this.field_exptId = jSONObject.optInt("ExptId");
            this.field_groupId = jSONObject.optInt("GroupId");
            this.field_exptSeq = jSONObject.optInt("ExptSequence");
            this.field_startTime = jSONObject.optLong("StartTime");
            this.field_endTime = jSONObject.optLong("EndTime");
            this.field_exptType = jSONObject.optInt("ExptType");
            this.field_exptCheckSum = jSONObject.optString("ExptCheckSum");
            cRH();
            if (this.cache == null || !this.cache.containsKey("jsoncfg_param_" + this.field_exptId + "_subtype")) {
                this.field_subType = 0;
            } else {
                this.field_subType = Util.getInt(this.cache.get("jsoncfg_param_" + this.field_exptId + "_subtype"), 0);
            }
            Log.v("MicroMsg.ExptItem", "convertFrom new [%s] old[%s] args[%s]", toString(), cVar, str);
            AppMethodBeat.o(156037);
            return true;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(863, 5, 1, false);
            Log.e("MicroMsg.ExptItem", "%d convertFrom [%s] error [%s]", Integer.valueOf(hashCode()), str, e2.toString());
            AppMethodBeat.o(156037);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(156038);
        String str = "{ Id: " + this.field_exptId + " group: " + this.field_groupId + " seq: " + this.field_exptSeq + " checksum: " + this.field_exptCheckSum + " startTime: " + this.field_startTime + " endTime: " + this.field_endTime + " content: " + this.field_exptContent + " type: " + this.field_exptType + " subtype: " + this.field_subType + " }";
        AppMethodBeat.o(156038);
        return str;
    }

    public final boolean isReady() {
        boolean z = false;
        AppMethodBeat.i(156039);
        if (this.field_exptSeq >= 0) {
            long nowSecond = Util.nowSecond();
            if (nowSecond >= this.field_startTime && (this.field_endTime <= 0 || nowSecond <= this.field_endTime)) {
                z = true;
            }
        }
        AppMethodBeat.o(156039);
        return z;
    }

    public final boolean cRM() {
        return this.field_exptType == 10;
    }

    public final boolean cRN() {
        return this.field_subType == 1;
    }

    public final boolean cRO() {
        return this.field_subType == 2;
    }

    public final boolean cRP() {
        return this.field_subType == 3;
    }

    public final boolean cRQ() {
        return this.field_subType == 4;
    }

    public final boolean cRR() {
        return this.field_subType == 5;
    }

    public final boolean cRS() {
        return this.field_subType == 6;
    }

    public final boolean cRT() {
        AppMethodBeat.i(215268);
        if (cRN() || cRO() || cRP() || cRQ() || cRR() || cRS()) {
            AppMethodBeat.o(215268);
            return true;
        }
        AppMethodBeat.o(215268);
        return false;
    }

    public final boolean cRU() {
        return this.field_exptType == 2;
    }

    public final boolean cRV() {
        AppMethodBeat.i(156040);
        if (this.cache == null || this.cache.size() <= 0) {
            AppMethodBeat.o(156040);
            return false;
        } else if (Util.getInt(this.cache.get("jsoncfg_param_" + this.field_exptId + "_report"), 0) > 0) {
            AppMethodBeat.o(156040);
            return true;
        } else {
            AppMethodBeat.o(156040);
            return false;
        }
    }

    public final long cRW() {
        AppMethodBeat.i(156041);
        if (this.cache == null || this.cache.size() <= 0) {
            AppMethodBeat.o(156041);
            return 0;
        }
        long j2 = Util.getLong(this.cache.get("jsoncfg_param_" + this.field_exptId + "_sessionpageid"), 0);
        AppMethodBeat.o(156041);
        return j2;
    }

    public final String cRX() {
        String str;
        AppMethodBeat.i(156042);
        if (!cRT()) {
            AppMethodBeat.o(156042);
            return "";
        }
        if (this.cache == null || this.cache.size() <= 0) {
            cRH();
        }
        HashMap<String, String> hashMap = this.cache;
        if (hashMap == null || hashMap.size() <= 0) {
            AppMethodBeat.o(156042);
            return "";
        }
        String str2 = "jsoncfg_param_" + this.field_exptId + "_";
        int i2 = Util.getInt(hashMap.get(str2 + "size"), 0);
        if (i2 <= 0) {
            AppMethodBeat.o(156042);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(hashMap.get(str2 + i3));
        }
        String sb2 = sb.toString();
        try {
            if (Util.getInt(hashMap.get(str2 + "decompress"), 0) > 0) {
                String arj = arj(sb2);
                String mD5String = MD5Util.getMD5String(arj);
                String str3 = hashMap.get(str2 + "md5");
                if (mD5String == null || !mD5String.equalsIgnoreCase(str3)) {
                    e.INSTANCE.idkeyStat(863, 12, 1, false);
                    Log.e("MicroMsg.ExptItem", "to session config but md5 not right deJson[%s] json[%s]", arj, sb2);
                    str = "";
                } else {
                    str = arj;
                }
            } else {
                str = sb.toString();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ExptItem", e2, "tosession config e[%s]", e2.toString());
            str = "";
        }
        AppMethodBeat.o(156042);
        return str;
    }

    public final HashMap<String, String> cRH() {
        HashMap<String, String> hashMap;
        Exception exc;
        AppMethodBeat.i(156043);
        if (this.cache != null) {
            HashMap<String, String> hashMap2 = this.cache;
            AppMethodBeat.o(156043);
            return hashMap2;
        }
        if (!Util.isNullOrNil(this.field_exptContent)) {
            try {
                Object obj = new JSONObject(this.field_exptContent).get("Args");
                if (obj == null) {
                    AppMethodBeat.o(156043);
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
                    Log.e("MicroMsg.ExptItem", "get expt item error [%s] exptId[%d]", exc.toString(), Integer.valueOf(this.field_exptId));
                    this.cache = hashMap;
                    HashMap<String, String> hashMap4 = this.cache;
                    AppMethodBeat.o(156043);
                    return hashMap4;
                }
            } catch (Exception e3) {
                exc = e3;
                hashMap = null;
                Log.e("MicroMsg.ExptItem", "get expt item error [%s] exptId[%d]", exc.toString(), Integer.valueOf(this.field_exptId));
                this.cache = hashMap;
                HashMap<String, String> hashMap42 = this.cache;
                AppMethodBeat.o(156043);
                return hashMap42;
            }
        } else {
            hashMap = null;
        }
        this.cache = hashMap;
        HashMap<String, String> hashMap422 = this.cache;
        AppMethodBeat.o(156043);
        return hashMap422;
    }

    private static void a(HashMap<String, String> hashMap, JSONObject jSONObject) {
        AppMethodBeat.i(156044);
        if (jSONObject == null) {
            AppMethodBeat.o(156044);
            return;
        }
        String optString = jSONObject.optString("Key");
        String optString2 = jSONObject.optString("Val");
        if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(optString2)) {
            byte[] decode = Base64.decode(optString2, 0);
            if (decode != null && decode.length > 0) {
                if (decode.length <= 1048576) {
                    try {
                        CharBuffer decode2 = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET).decode(ByteBuffer.wrap(decode));
                        optString2 = String.valueOf(decode2.array(), 0, decode2.limit());
                    } catch (Error | Exception e2) {
                    }
                } else {
                    Log.e("MicroMsg.ExptItem", "data length more 1M don't parse, reset value. key[%s]", optString);
                    optString2 = "";
                    e.INSTANCE.idkeyStat(863, 16, 1, false);
                }
            }
            hashMap.put(optString, optString2);
        }
        AppMethodBeat.o(156044);
    }

    private static String arj(String str) {
        AppMethodBeat.i(156045);
        String str2 = "";
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(156045);
        } else {
            int i2 = 0;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt != '^') {
                    str2 = str2 + charAt;
                    i2++;
                } else if (str.charAt(i2 + 1) != '^') {
                    int dq = dq(str.substring(i2 + 1, i2 + 3), 2);
                    int dq2 = dq(new StringBuilder().append(str.charAt(i2 + 3)).toString(), 1) + 5;
                    int length = (str2.length() - dq) - dq2;
                    str2 = str2 + str2.substring(length, dq2 + length);
                    i2 += 4;
                } else {
                    str2 = str2 + "^";
                    i2 += 2;
                }
            }
            AppMethodBeat.o(156045);
        }
        return str2;
    }

    private static int dq(String str, int i2) {
        AppMethodBeat.i(156046);
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 *= 64;
            char charAt = str.charAt(i4);
            if (charAt < ' ' || charAt > '_') {
                break;
            }
            i3 += charAt - ' ';
        }
        AppMethodBeat.o(156046);
        return i3;
    }

    static {
        AppMethodBeat.i(156047);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "exptId";
        mAutoDBInfo.colsMap.put("exptId", "INTEGER PRIMARY KEY ");
        sb.append(" exptId INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "exptId";
        mAutoDBInfo.columns[1] = "groupId";
        mAutoDBInfo.colsMap.put("groupId", "INTEGER");
        sb.append(" groupId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "exptSeq";
        mAutoDBInfo.colsMap.put("exptSeq", "INTEGER");
        sb.append(" exptSeq INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "exptContent";
        mAutoDBInfo.colsMap.put("exptContent", "TEXT");
        sb.append(" exptContent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "LONG");
        sb.append(" startTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "endTime";
        mAutoDBInfo.colsMap.put("endTime", "LONG");
        sb.append(" endTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "exptType";
        mAutoDBInfo.colsMap.put("exptType", "INTEGER");
        sb.append(" exptType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "subType";
        mAutoDBInfo.colsMap.put("subType", "INTEGER");
        sb.append(" subType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "exptCheckSum";
        mAutoDBInfo.colsMap.put("exptCheckSum", "TEXT");
        sb.append(" exptCheckSum TEXT");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(156047);
    }
}
