package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.s;
import com.tencent.mm.bb.m;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c implements i {
    private static c iIk;
    private volatile boolean gYQ = false;
    private final int iIh = 21;
    private final String iIi = "trace_config_last_update_time";
    private final long iIj = Util.MILLSECONDS_OF_DAY;
    private ArrayList<a> listeners = new ArrayList<>();
    private SharedPreferences sp = MMApplicationContext.getDefaultPreference();

    public interface a {
        void aXz();
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(20470);
        cVar.release();
        AppMethodBeat.o(20470);
    }

    private c() {
        AppMethodBeat.i(20464);
        AppMethodBeat.o(20464);
    }

    public static c aXD() {
        AppMethodBeat.i(20465);
        if (iIk == null) {
            synchronized (c.class) {
                try {
                    if (iIk == null) {
                        iIk = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(20465);
                    throw th;
                }
            }
        }
        c cVar = iIk;
        AppMethodBeat.o(20465);
        return cVar;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(20466);
        int type = qVar.getType();
        Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(type));
        if (!(qVar instanceof s) || ((s) qVar).aYR() != 21) {
            Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
            AppMethodBeat.o(20466);
        } else if (type != 159) {
            if (type == 160) {
                if (i2 == 0 && i3 == 0) {
                    sC(((m) qVar).jho);
                }
                release();
            }
            AppMethodBeat.o(20466);
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.bb.q[] tJ = v.bev().tJ(21);
            if (tJ == null || tJ.length == 0) {
                Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                release();
                AppMethodBeat.o(20466);
                return;
            }
            com.tencent.mm.bb.q qVar2 = tJ[0];
            Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + qVar2.id + " version:" + qVar2.version + " status:" + qVar2.status + " type:" + qVar2.dMe);
            if (5 == qVar2.status) {
                bg.azz().a(new m(qVar2.id, 21), 0);
                AppMethodBeat.o(20466);
                return;
            }
            Log.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
            this.sp.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            release();
            AppMethodBeat.o(20466);
        } else {
            release();
            AppMethodBeat.o(20466);
        }
    }

    private void sC(int i2) {
        AppMethodBeat.i(20467);
        v.bev();
        try {
            Map<String, String> parseXml = XmlParser.parseXml(com.tencent.mm.vfs.s.boY(aa.z(new o(r.bes(), v.bev().dv(i2, 21)).mUri)), "TraceConfig", null);
            if (parseXml == null) {
                Log.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                AppMethodBeat.o(20467);
                return;
            }
            HashMap hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                String str = ".TraceConfig.Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                String str2 = parseXml.get(str + ".$key");
                if (str2 == null) {
                    break;
                }
                int i4 = i3 + 1;
                long j2 = Util.getLong(parseXml.get(str), -1);
                if (j2 >= 0) {
                    Log.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i4 + " key: " + str2 + "|value: " + j2);
                    hashMap.put(str2, Long.valueOf(j2));
                    i3 = i4;
                } else {
                    i3 = i4;
                }
            }
            SharedPreferences.Editor edit = this.sp.edit();
            for (Map.Entry entry : hashMap.entrySet()) {
                edit.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            edit.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            Log.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            int size = this.listeners.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.listeners.get(i5).aXz();
            }
            com.tencent.mm.bb.q dt = v.bev().dt(i2, 21);
            dt.status = 2;
            v.bev().b(dt);
            AppMethodBeat.o(20467);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.TraceConfigUpdater", e2, "", new Object[0]);
        }
    }

    private void release() {
        AppMethodBeat.i(20468);
        Log.i("MicroMsg.TraceConfigUpdater", "summer release");
        this.gYQ = false;
        bg.azz().b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        bg.azz().b(160, this);
        AppMethodBeat.o(20468);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(20469);
        if (aVar == null || this.listeners.contains(aVar)) {
            AppMethodBeat.o(20469);
            return false;
        }
        boolean add = this.listeners.add(aVar);
        AppMethodBeat.o(20469);
        return add;
    }
}
