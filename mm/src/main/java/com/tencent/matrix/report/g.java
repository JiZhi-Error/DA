package com.tencent.matrix.report;

import android.os.SystemClock;
import com.tencent.matrix.report.h;
import com.tencent.matrix.trace.b.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class g implements h.b {
    private final ConcurrentHashMap<String, a> cWn = new ConcurrentHashMap<>();

    @Override // com.tencent.matrix.report.h.b
    public final boolean c(c cVar) {
        boolean z;
        if (!cVar.cWf.getTag().equals("Trace")) {
            return false;
        }
        JSONObject jSONObject = cVar.cWe;
        String str = cVar.tag;
        if (str.equalsIgnoreCase("Trace_EvilMethod")) {
            String string = jSONObject.getString("detail");
            if (!string.equalsIgnoreCase(a.EnumC0233a.ANR.toString())) {
                return string.equalsIgnoreCase(a.EnumC0233a.NORMAL.toString()) && !MultiProcessMMKV.getDefault().decodeBool("clicfg_normal_report", false);
            }
            if (!MultiProcessMMKV.getDefault().decodeBool("clicfg_anr_report_all", true)) {
                z = Util.isNullOrNil(jSONObject.getString("stackKey"));
            } else {
                z = false;
            }
            return z;
        } else if (!str.equalsIgnoreCase("Trace_FPS")) {
            return str.equalsIgnoreCase("Trace_StartUp") && !((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_matrix_startup_report, false);
        } else {
            String string2 = jSONObject.getString("scene");
            a aVar = this.cWn.get(string2);
            if (aVar == null) {
                aVar = new a((byte) 0);
                this.cWn.put(string2, aVar);
            }
            long uptimeMillis = SystemClock.uptimeMillis() - aVar.time;
            aVar.count++;
            if (aVar.count <= 12 || uptimeMillis > 2400000) {
                return false;
            }
            this.cWn.put(string2, new a((byte) 0));
            return true;
        }
    }

    static final class a {
        int count;
        long time;

        private a() {
            this.count = 0;
            this.time = SystemClock.uptimeMillis();
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
