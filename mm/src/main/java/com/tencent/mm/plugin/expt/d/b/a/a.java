package com.tencent.mm.plugin.expt.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.g;

public final class a {
    public Map<String, Long> sxY = new HashMap();
    private Map<String, Long> sxZ = new HashMap();
    public Map<String, Long> sya = new HashMap();
    public Map<String, Long> syb = new HashMap();

    public a() {
        AppMethodBeat.i(220313);
        bqI();
        AppMethodBeat.o(220313);
    }

    private void bqI() {
        String[] split;
        String[] split2;
        String[] split3;
        String[] split4;
        AppMethodBeat.i(220314);
        MultiProcessMMKV cMQ = b.cMQ();
        if (cMQ == null) {
            AppMethodBeat.o(220314);
            return;
        }
        HashMap hashMap = new HashMap();
        String string = cMQ.getString("mmkv_key_script_config_recorder", "");
        if (!g.eP(string) && (split3 = string.split(";")) != null && split3.length > 0) {
            for (String str : split3) {
                try {
                    if (!g.eP(str) && (split4 = str.split(",")) != null && split4.length > 0) {
                        hashMap.put(split4[0], Long.valueOf(Long.parseLong(split4[1])));
                    }
                } catch (Exception e2) {
                    Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder scriptConfigRecorder throw Exception : " + e2.getMessage() + ", record : " + str);
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        String string2 = cMQ.getString("mmkv_key_sql_config_recorder", "");
        if (!g.eP(string2) && (split = string2.split(";")) != null && split.length > 0) {
            for (String str2 : split) {
                try {
                    if (!g.eP(str2) && (split2 = str2.split(",")) != null && split2.length > 0) {
                        hashMap2.put(split2[0], Long.valueOf(Long.parseLong(split2[1])));
                    }
                } catch (Exception e3) {
                    Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder sqlConfigRecorder throw Exception : " + e3.getMessage() + ", record : " + str2);
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (String str3 : hashMap.keySet()) {
            if (currentTimeMillis - ((Long) hashMap.get(str3)).longValue() < 129600000) {
                this.sxY.put(str3, Long.valueOf(currentTimeMillis));
                this.sya.put(str3, Long.valueOf(currentTimeMillis));
                Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorScriptConfigRecord : " + str3 + ", time : " + currentTimeMillis);
            }
        }
        for (String str4 : hashMap2.keySet()) {
            if (currentTimeMillis - ((Long) hashMap2.get(str4)).longValue() < 129600000) {
                this.sxZ.put(str4, Long.valueOf(currentTimeMillis));
                this.syb.put(str4, Long.valueOf(currentTimeMillis));
                Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorSqlConfigRecord : " + str4 + ", time : " + currentTimeMillis);
            }
        }
        cMX();
        AppMethodBeat.o(220314);
    }

    public final void cMX() {
        AppMethodBeat.i(220315);
        MultiProcessMMKV cMQ = b.cMQ();
        if (cMQ == null) {
            AppMethodBeat.o(220315);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.sya.keySet()) {
            sb.append(str).append(",").append(this.sya.get(str)).append(";");
        }
        cMQ.putString("mmkv_key_script_config_recorder", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : this.syb.keySet()) {
            sb2.append(str2).append(",").append(this.syb.get(str2)).append(";");
        }
        cMQ.putString("mmkv_key_sql_config_recorder", sb2.toString());
        AppMethodBeat.o(220315);
    }
}
