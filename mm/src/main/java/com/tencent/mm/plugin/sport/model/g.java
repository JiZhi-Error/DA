package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    private static long FjC;
    private static JSONObject FjD;
    private static a FjE;
    private static i gNh = new i() {
        /* class com.tencent.mm.plugin.sport.model.g.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            int i4 = 1;
            AppMethodBeat.i(149318);
            if (qVar instanceof d) {
                com.tencent.mm.kernel.g.azz().b(1947, g.gNh);
                if (i2 == 0 && i3 == 0) {
                    eyc eyc = ((d) qVar).Fjq;
                    Log.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", eyc.KIn);
                    g.aRD(eyc.KIn);
                    try {
                        JSONObject fmy = g.fmy();
                        if (!k.fmg()) {
                            i4 = 0;
                        }
                        fmy.put("checkWeSportInstall", i4);
                    } catch (Exception e2) {
                    }
                    String jSONObject = g.fmy().toString();
                    j.aRE(jSONObject);
                    ((PluginSport) com.tencent.mm.kernel.g.ah(PluginSport.class)).getDeviceStepManager().aRC(jSONObject);
                    if (g.FjE != null) {
                        g.FjE.awp();
                    }
                }
            }
            AppMethodBeat.o(149318);
        }
    };

    public interface a {
        void awp();
    }

    public static boolean fmx() {
        AppMethodBeat.i(149319);
        if (FjC == 0) {
            FjC = j.aJ(1, 0);
        }
        if (System.currentTimeMillis() - FjC > Util.MILLSECONDS_OF_DAY) {
            FjC = System.currentTimeMillis();
            j.aK(1, FjC);
            Log.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
            com.tencent.mm.kernel.g.azz().a(1947, gNh);
            com.tencent.mm.kernel.g.azz().a(new d(), 0);
            AppMethodBeat.o(149319);
            return true;
        }
        Log.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", k.AF(FjC));
        AppMethodBeat.o(149319);
        return false;
    }

    static {
        AppMethodBeat.i(149325);
        AppMethodBeat.o(149325);
    }

    public static void vH(boolean z) {
        AppMethodBeat.i(149320);
        JSONObject fmy = fmy();
        try {
            fmy.put("checkWeSportInstall", z ? 1 : 0);
        } catch (JSONException e2) {
        }
        String jSONObject = fmy.toString();
        j.aRE(jSONObject);
        ((PluginSport) com.tencent.mm.kernel.g.ah(PluginSport.class)).getDeviceStepManager().aRC(jSONObject);
        if (FjE != null) {
            FjE.awp();
        }
        AppMethodBeat.o(149320);
    }

    public static void aRD(String str) {
        AppMethodBeat.i(149321);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(149321);
            return;
        }
        try {
            FjD = new JSONObject(str);
            AppMethodBeat.o(149321);
        } catch (Exception e2) {
            FjD = null;
            AppMethodBeat.o(149321);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject fmy() {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sport.model.g.fmy():org.json.JSONObject");
    }

    private static void bq(JSONObject jSONObject) {
        int i2 = 1;
        AppMethodBeat.i(149323);
        try {
            if (MMApplicationContext.isMainProcess()) {
                if (jSONObject.optInt("checkWeSportInstall", 0) != (k.fmg() ? 1 : 0)) {
                    if (!k.fmg()) {
                        i2 = 0;
                    }
                    jSONObject.put("checkWeSportInstall", i2);
                    j.aRE(jSONObject.toString());
                    e.INSTANCE.idkeyStat(323, 5, 1, false);
                }
            }
            AppMethodBeat.o(149323);
        } catch (Exception e2) {
            AppMethodBeat.o(149323);
        }
    }

    private static JSONObject fmz() {
        JSONObject jSONObject;
        AppMethodBeat.i(149324);
        InputStream inputStream = null;
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("sport_config.json");
            jSONObject = new JSONObject(new String(com.tencent.mm.b.e.readFromStream(inputStream)));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", e3, "get assets sport config json", new Object[0]);
            jSONObject = new JSONObject();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(149324);
            throw th;
        }
        AppMethodBeat.o(149324);
        return jSONObject;
    }

    public static void a(a aVar) {
        FjE = aVar;
    }
}
