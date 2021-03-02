package com.tencent.mm.n;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.df;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f {
    private HashMap<String, String> gMk = new HashMap<>();
    private final HashMap<String, MutableLiveData> gMl = new HashMap<>();
    protected boolean gMm = false;

    public f() {
        AppMethodBeat.i(131992);
        AppMethodBeat.o(131992);
    }

    public final synchronized String getValue(String str) {
        String str2;
        AppMethodBeat.i(131993);
        if (!this.gMm) {
            Log.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            vC();
        }
        Log.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.gMk.get(str));
        str2 = this.gMk.get(str);
        AppMethodBeat.o(131993);
        return str2;
    }

    public final int getInt(String str, int i2) {
        AppMethodBeat.i(131994);
        try {
            i2 = Integer.parseInt(getValue(str));
        } catch (Exception e2) {
            Log.e("MicroMsg.DynamicConfig", "parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(131994);
        return i2;
    }

    public final synchronized List<String> El(String str) {
        ArrayList arrayList;
        AppMethodBeat.i(131995);
        if (!this.gMm) {
            Log.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            vC();
        }
        arrayList = new ArrayList();
        if (!Util.isNullOrNil(str)) {
            for (String str2 : this.gMk.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.gMk.get(str2));
                }
            }
        }
        Log.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(131995);
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        AppMethodBeat.i(131996);
        if (!(str == null || str2 == null)) {
            Log.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.gMk.put(str, str2);
            ck ckVar = new ck();
            ckVar.dFF.dFG = str.trim();
            EventCenter.instance.publish(ckVar);
        }
        AppMethodBeat.o(131996);
    }

    public synchronized void vC() {
        AppMethodBeat.i(131997);
        g.aAi();
        if (g.aAh() != null) {
            g.aAi();
            if (g.aAh().azQ() != null) {
                this.gMm = true;
                g.aAi();
                r((String) g.aAh().azQ().get(278529, (Object) null), false);
            }
        }
        g.aAi();
        if (g.aAh() != null) {
            g.aAi();
            if (g.aAh().azQ() != null) {
                this.gMm = true;
                g.aAi();
                r((String) g.aAh().azQ().get(278530, (Object) null), true);
            }
        }
        AppMethodBeat.o(131997);
    }

    public final synchronized void a(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.i(131998);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(131998);
        } else {
            Log.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), s.bhK(str));
            if (z) {
                g.aAi();
                g.aAh().azQ().set(278530, str);
            } else {
                g.aAi();
                g.aAh().azQ().set(278529, str);
                g.aAi();
                g.aAh().azQ().set(278530, "");
            }
            if (map != null) {
                a(map, z);
            } else {
                r(str, z);
            }
            EventCenter.instance.publish(new df());
            AppMethodBeat.o(131998);
        }
    }

    /* access modifiers changed from: protected */
    public final void r(String str, boolean z) {
        AppMethodBeat.i(131999);
        a(XmlParser.parseXml(str, "sysmsg", null), z);
        AppMethodBeat.o(131999);
    }

    private void a(Map<String, String> map, boolean z) {
        String str;
        AppMethodBeat.i(132000);
        if (map == null) {
            AppMethodBeat.o(132000);
            return;
        }
        if (!z) {
            this.gMk.clear();
        }
        int i2 = 0;
        while (i2 < 10000) {
            if (z) {
                str = ".sysmsg.dynacfg_split.Item" + (i2 == 0 ? "" : Integer.valueOf(i2));
            } else {
                str = ".sysmsg.dynacfg.Item" + (i2 == 0 ? "" : Integer.valueOf(i2));
            }
            String str2 = str + ".$key";
            String str3 = map.get(str);
            String str4 = map.get(str2);
            if (str4 == null || Util.isNullOrNil(str4.trim())) {
                break;
            }
            this.gMk.put(str4.trim(), str3 != null ? str3 : "");
            ck ckVar = new ck();
            ckVar.dFF.dFG = str4.trim();
            EventCenter.instance.publish(ckVar);
            Log.d("MicroMsg.DynamicConfig", "put %s %s", str4.trim(), str3);
            i2++;
        }
        Log.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.gMk.toString());
        AppMethodBeat.o(132000);
    }
}
