package com.tencent.mm.plugin.welab.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b JGB = new b();
    public Map<String, Integer> JFW = new HashMap();
    public String tag = "";

    static {
        AppMethodBeat.i(146307);
        AppMethodBeat.o(146307);
    }

    public static b gju() {
        return JGB;
    }

    private b() {
        AppMethodBeat.i(146299);
        gjv();
        AppMethodBeat.o(146299);
    }

    private void gjv() {
        String[] split;
        AppMethodBeat.i(146300);
        this.tag = (String) g.aAh().azQ().get(ar.a.USERINFO_WELAB_REDPOINT_STRING, (Object) null);
        Log.i("WeLabRedPointMgr", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            String[] split2 = this.tag.split("&");
            for (String str : split2) {
                if (!TextUtils.isEmpty(str) && (split = str.split("=")) != null && split.length == 2) {
                    this.JFW.put(split[0], Integer.valueOf(Util.safeParseInt(split[1])));
                }
            }
        }
        AppMethodBeat.o(146300);
    }

    public final boolean e(a aVar) {
        AppMethodBeat.i(146301);
        if (aVar.field_RedPoint != 1 || aVar.isOffline()) {
            AppMethodBeat.o(146301);
            return false;
        } else if (bbJ(aVar.field_LabsAppId)) {
            AppMethodBeat.o(146301);
            return false;
        } else {
            AppMethodBeat.o(146301);
            return true;
        }
    }

    private boolean bbJ(String str) {
        AppMethodBeat.i(146302);
        if (!this.JFW.containsKey(str) || this.JFW.get(str).intValue() != 1) {
            AppMethodBeat.o(146302);
            return false;
        }
        AppMethodBeat.o(146302);
        return true;
    }

    public final void f(a aVar) {
        AppMethodBeat.i(146303);
        if (aVar.field_RedPoint == 1 && !bbJ(aVar.field_LabsAppId) && aVar.gjo()) {
            c.axV().B(266267, true);
        }
        AppMethodBeat.o(146303);
    }

    public static void gjw() {
        boolean z;
        AppMethodBeat.i(146304);
        List<a> gjh = com.tencent.mm.plugin.welab.a.gjg().gjh();
        if (gjh == null || gjh.isEmpty()) {
        }
        Iterator<a> it = gjh.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            a next = it.next();
            if (next != null && JGB.e(next)) {
                z = false;
                break;
            }
        }
        if (z) {
            c.axV().cQ(266267, 266241);
        }
        AppMethodBeat.o(146304);
    }

    public static boolean gjx() {
        AppMethodBeat.i(146305);
        boolean cP = c.axV().cP(266267, 266241);
        AppMethodBeat.o(146305);
        return cP;
    }

    public static boolean gjy() {
        AppMethodBeat.i(146306);
        boolean z = MMApplicationContext.getDefaultPreference().getBoolean("key_has_enter_welab", false);
        AppMethodBeat.o(146306);
        return z;
    }
}
