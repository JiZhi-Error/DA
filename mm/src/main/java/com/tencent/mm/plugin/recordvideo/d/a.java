package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-recordvideo_release"})
public final class a {
    private JSONArray BXw = new JSONArray();
    private final Object lock = new Object();

    public a() {
        AppMethodBeat.i(75830);
        AppMethodBeat.o(75830);
    }

    public final void VG(int i2) {
        boolean z;
        AppMethodBeat.i(75828);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", i2);
        jSONObject.put("td", this.BXw.length() + 1);
        if (this.BXw.toString().length() + jSONObject.toString().length() > 1000) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            synchronized (this.lock) {
                try {
                    this.BXw.put(jSONObject);
                } finally {
                    AppMethodBeat.o(75828);
                }
            }
            return;
        }
        AppMethodBeat.o(75828);
    }

    public final String eKV() {
        String j2;
        AppMethodBeat.i(75829);
        synchronized (this.lock) {
            try {
                String jSONArray = this.BXw.toString();
                p.g(jSONArray, "traceJsonArray.toString()");
                j2 = n.j(jSONArray, ",", ";", false);
            } finally {
                AppMethodBeat.o(75829);
            }
        }
        return j2;
    }
}
