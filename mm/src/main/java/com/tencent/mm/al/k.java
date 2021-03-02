package com.tencent.mm.al;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    public static String iOp = "menu_click";
    public static String iOq = "menu_action_start";
    public static String iOr = "menu_action_success";
    public String content;
    public String egX;
    public List<k> iOs = null;
    public int iOt;
    public int id;
    public String key;
    public String name;
    public String state;
    public int type;
    public String value;

    public final void bf(String str, String str2) {
        AppMethodBeat.i(116427);
        Log.v("MicroMsg.BizMenuItem", "type is %s , result is %s", str, str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scan_type", str);
            jSONObject.put("scan_result", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scan_code", jSONObject);
            this.content = jSONObject2.toString();
            Log.v("MicroMsg.BizMenuItem", "content: %s", this.content);
            AppMethodBeat.o(116427);
        } catch (JSONException e2) {
            Log.e("MicroMsg.BizMenuItem", e2.toString());
            AppMethodBeat.o(116427);
        }
    }

    public final void u(ArrayList<String> arrayList) {
        AppMethodBeat.i(116428);
        if (arrayList.size() == 0) {
            Log.e("MicroMsg.BizMenuItem", "value null!");
            AppMethodBeat.o(116428);
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pic_md5", it.next());
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pics", jSONArray);
            this.content = jSONObject2.toString();
            Log.v("MicroMsg.BizMenuItem", this.content);
            AppMethodBeat.o(116428);
        } catch (JSONException e2) {
            Log.e("MicroMsg.BizMenuItem", e2.toString());
            AppMethodBeat.o(116428);
        }
    }

    public final void a(double d2, double d3, int i2, String str, String str2) {
        AppMethodBeat.i(116429);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", String.valueOf(d2));
            jSONObject.put("y", String.valueOf(d3));
            jSONObject.put("scale", i2);
            jSONObject.put("label", str);
            jSONObject.put("poiname", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FirebaseAnalytics.b.LOCATION, jSONObject);
            this.content = jSONObject2.toString();
            Log.v("MicroMsg.BizMenuItem", this.content);
            AppMethodBeat.o(116429);
        } catch (JSONException e2) {
            Log.e("MicroMsg.BizMenuItem", e2.toString());
            AppMethodBeat.o(116429);
        }
    }

    public final String getInfo() {
        AppMethodBeat.i(116430);
        if (this.content == null) {
            this.content = "";
        }
        if (this.state == null) {
            if (this.type == 4) {
                this.state = iOq;
            } else {
                this.state = iOp;
            }
        }
        String format = String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", "#bizmenu#", Integer.valueOf(this.id), this.key, this.state, this.content);
        AppMethodBeat.o(116430);
        return format;
    }

    public final String toString() {
        AppMethodBeat.i(116431);
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.id);
        objArr[1] = Integer.valueOf(this.iOt);
        objArr[2] = Integer.valueOf(this.type);
        objArr[3] = this.name == null ? "" : this.name;
        objArr[4] = this.key == null ? "" : this.key;
        objArr[5] = this.value == null ? "" : this.value;
        objArr[6] = this.content == null ? "" : this.content;
        String format = String.format("id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s", objArr);
        AppMethodBeat.o(116431);
        return format;
    }

    public static List<k> e(JSONArray jSONArray) {
        ArrayList arrayList;
        AppMethodBeat.i(116432);
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    k kVar = new k();
                    kVar.id = jSONObject.getInt("id");
                    kVar.type = jSONObject.getInt("type");
                    kVar.name = jSONObject.getString("name");
                    kVar.key = jSONObject.getString("key");
                    kVar.value = jSONObject.optString("value");
                    kVar.egX = jSONObject.optString("native_url");
                    Log.d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + kVar.egX);
                    kVar.iOs = e(jSONObject.optJSONArray("sub_button_list"));
                    kVar.iOt = jSONObject.optInt("acttype");
                    arrayList.add(kVar);
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.BizMenuItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(116432);
                return null;
            }
        } else {
            arrayList = null;
        }
        AppMethodBeat.o(116432);
        return arrayList;
    }

    public static LinkedList<k> E(Map<String, String> map) {
        AppMethodBeat.i(116433);
        if (map == null) {
            AppMethodBeat.o(116433);
            return null;
        }
        int i2 = Util.getInt(map.get(".msg.appmsg.buttonlist.$count"), 0);
        if (i2 > 0) {
            try {
                LinkedList<k> linkedList = new LinkedList<>();
                Log.v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : ".concat(String.valueOf(i2)));
                int i3 = 0;
                while (i3 < i2) {
                    k kVar = new k();
                    String str = ".msg.appmsg.buttonlist.button" + (i3 == 0 ? "" : String.valueOf(i3));
                    kVar.id = Util.getInt(map.get(str + ".id"), 0);
                    kVar.type = Util.getInt(map.get(str + ".type"), 0);
                    kVar.name = map.get(str + ".name");
                    kVar.key = map.get(str + ".key");
                    kVar.value = map.get(str + ".value");
                    kVar.iOt = Util.getInt(map.get(str + ".acttype"), 0);
                    linkedList.add(kVar);
                    i3++;
                }
                AppMethodBeat.o(116433);
                return linkedList;
            } catch (Exception e2) {
                Log.e("MicroMsg.BizMenuItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(116433);
                return null;
            }
        } else {
            AppMethodBeat.o(116433);
            return null;
        }
    }
}
