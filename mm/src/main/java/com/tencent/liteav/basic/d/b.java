package com.tencent.liteav.basic.d;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f347a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f348b = null;

    public b() {
        AppMethodBeat.i(14554);
        AppMethodBeat.o(14554);
    }

    public synchronized void a(JSONArray jSONArray) {
        AppMethodBeat.i(222038);
        this.f347a.clear();
        this.f348b = b(jSONArray);
        if (this.f348b == null) {
            TXCLog.i("CompatibleConfig", "can't find best match value");
            AppMethodBeat.o(222038);
        } else {
            a(this.f347a, "", this.f348b);
            b();
            AppMethodBeat.o(222038);
        }
    }

    public synchronized void a(String str) {
        AppMethodBeat.i(222039);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(222039);
        } else {
            try {
                this.f347a.clear();
                this.f348b = new JSONObject(str);
                a(this.f347a, "", this.f348b);
                b();
                AppMethodBeat.o(222039);
            } catch (JSONException e2) {
                TXCLog.e("CompatibleConfig", "parse best match value failed.", e2);
                AppMethodBeat.o(222039);
            }
        }
    }

    public synchronized JSONObject a() {
        return this.f348b;
    }

    public synchronized long a(String str, long j2) {
        AppMethodBeat.i(222040);
        String str2 = this.f347a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            try {
                j2 = Long.parseLong(str2);
                AppMethodBeat.o(222040);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(222040);
            }
        } else {
            AppMethodBeat.o(222040);
        }
        return j2;
    }

    private void b() {
        AppMethodBeat.i(14557);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f347a.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        TXCLog.i("CompatibleConfig", sb.toString());
        AppMethodBeat.o(14557);
    }

    private JSONObject b(JSONArray jSONArray) {
        AppMethodBeat.i(222041);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(222041);
            return null;
        }
        int i2 = 0;
        JSONObject jSONObject = null;
        int i3 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                int a2 = a(jSONObject2.optJSONObject("deviceinfo"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("deviceconfig");
                if (a2 <= i3 || optJSONObject == null) {
                    optJSONObject = jSONObject;
                    a2 = i3;
                }
                i2++;
                jSONObject = optJSONObject;
                i3 = a2;
            } catch (JSONException e2) {
                TXCLog.e("CompatibleConfig", "Find best match value failed.", e2);
            }
        }
        TXCLog.i("CompatibleConfig", "bestMatchLevel: %d", Integer.valueOf(i3));
        if (i3 > 0) {
            AppMethodBeat.o(222041);
            return jSONObject;
        }
        AppMethodBeat.o(222041);
        return null;
    }

    private int a(JSONObject jSONObject) {
        AppMethodBeat.i(222042);
        if (jSONObject == null) {
            AppMethodBeat.o(222042);
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(Build.MANUFACTURER, jSONObject.optString("MANUFACTURER")));
        arrayList.add(new Pair(Build.MODEL, jSONObject.optString("MODEL")));
        arrayList.add(new Pair(String.valueOf(Build.VERSION.SDK_INT), jSONObject.optString("VERSION")));
        arrayList.add(new Pair(Build.VERSION.INCREMENTAL, jSONObject.optString("VERSION_INCREMENTAL")));
        arrayList.add(new Pair(Build.DISPLAY, jSONObject.optString("DISPLAY")));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Pair pair = (Pair) arrayList.get(i2);
            if (TextUtils.isEmpty((CharSequence) pair.second)) {
                AppMethodBeat.o(222042);
                return i2;
            } else if (!((String) pair.first).equalsIgnoreCase((String) pair.second)) {
                AppMethodBeat.o(222042);
                return 0;
            }
        }
        int size = arrayList.size();
        AppMethodBeat.o(222042);
        return size;
    }

    private void a(Map<String, String> map, String str, JSONObject jSONObject) {
        AppMethodBeat.i(222043);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof JSONObject) {
                a(map, str + "." + next, (JSONObject) opt);
            } else if (opt != null) {
                map.put(str + "." + next, opt.toString());
            }
        }
        AppMethodBeat.o(222043);
    }
}
