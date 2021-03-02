package com.tencent.mm.plugin.flash.c;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static ay wID = null;
    private static long wIE = 0;
    private static az wIF = null;
    private static aw wIG = null;
    private static JSONArray wIH;
    private static String wII = "";

    public static ay dLi() {
        AppMethodBeat.i(186673);
        if (wID == null) {
            ay ayVar = new ay();
            wID = ayVar;
            ayVar.erc = wIE;
        }
        ay ayVar2 = wID;
        AppMethodBeat.o(186673);
        return ayVar2;
    }

    public static void axl(String str) {
        AppMethodBeat.i(186674);
        dLi().erk = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(str);
            MW(jSONObject.optInt("err_code", jSONObject.optInt("errorcode", 0)));
            AppMethodBeat.o(186674);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "parse face fail result error.%s", str);
            AppMethodBeat.o(186674);
        }
    }

    public static void MW(int i2) {
        AppMethodBeat.i(186675);
        ay dLi = dLi();
        dLi.eqP = (long) i2;
        if (wIH != null) {
            dLi.iE(wIH.toString().replace(',', ';'));
        }
        dLi.iD(wII);
        if (!TextUtils.isEmpty(wII)) {
            try {
                String[] split = wII.split("-");
                if (split.length > 0) {
                    dLi.eqR = (long) Integer.parseInt(split[split.length - 1]);
                }
            } catch (Exception e2) {
            }
        }
        wIE = wID.erc;
        dLi.bfK();
        wID = null;
        wII = "";
        wIH = null;
        AppMethodBeat.o(186675);
    }

    public static az dLj() {
        AppMethodBeat.i(186676);
        if (wIF == null) {
            wIF = new az();
        }
        az azVar = wIF;
        AppMethodBeat.o(186676);
        return azVar;
    }

    public static void axm(String str) {
        AppMethodBeat.i(186677);
        try {
            MX(new JSONObject(str).optInt("err_code", 0));
            AppMethodBeat.o(186677);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "parse face fail result error.%s", str);
            AppMethodBeat.o(186677);
        }
    }

    public static void MX(int i2) {
        AppMethodBeat.i(186678);
        az dLj = dLj();
        dLj.eqP = (long) i2;
        if (wIH != null) {
            dLj.iH(wIH.toString().replace(',', ';'));
        }
        dLj.iG(wII);
        if (!TextUtils.isEmpty(wII)) {
            try {
                String[] split = wII.split("-");
                if (split.length > 0) {
                    dLj.eqR = (long) Integer.parseInt(split[split.length - 1]);
                }
            } catch (Exception e2) {
            }
        }
        dLj.bfK();
        wIF = null;
        wII = "";
        wIH = null;
        AppMethodBeat.o(186678);
    }

    public static aw dLk() {
        AppMethodBeat.i(186679);
        if (wIG == null) {
            wIG = new aw();
        }
        aw awVar = wIG;
        AppMethodBeat.o(186679);
        return awVar;
    }

    public static void au(Intent intent) {
        AppMethodBeat.i(186680);
        if (intent != null) {
            dLk().eqz = System.currentTimeMillis();
            aw dLk = dLk();
            dLk.eqA = dLk.x("functionName", intent.getStringExtra("key_function_name"), true);
            dLk().eqC = (long) intent.getIntExtra("key_business_type", -1);
            aw dLk2 = dLk();
            dLk2.ekB = dLk2.x("appId", intent.getStringExtra("appId"), true);
            dLk().eqF = 1;
            dLk().eqG = intent.getLongExtra("confirm_page_timestamp", -1);
            dLk().eqH = System.currentTimeMillis();
            dLk().eqK = (long) intent.getIntExtra("check_alive_type", -1);
        }
        AppMethodBeat.o(186680);
    }

    public static void pr(boolean z) {
        long j2;
        AppMethodBeat.i(186681);
        Log.i("MicroMsg.FaceFlashManagerReport", "doReport14560 success:%s", Boolean.valueOf(z));
        aw dLk = dLk();
        if (z) {
            j2 = 1;
        } else {
            j2 = 0;
        }
        dLk.eqD = j2;
        dLk().eqE = System.currentTimeMillis() - dLk().eqz;
        dLk().eqJ = System.currentTimeMillis();
        dLk().bfK();
        wIG = null;
        AppMethodBeat.o(186681);
    }

    public static void axn(String str) {
        AppMethodBeat.i(186682);
        s(str, 0);
        AppMethodBeat.o(186682);
    }

    public static void s(String str, Object obj) {
        AppMethodBeat.i(186683);
        if (wIH == null) {
            wIH = new JSONArray();
        }
        Log.i("MicroMsg.FaceFlashManagerReport", "updateFaceFlashState key:%s value:%s", str, obj);
        if (x(wIH)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e2) {
            }
            wIH.put(jSONObject);
        }
        AppMethodBeat.o(186683);
    }

    public static void axo(String str) {
        AppMethodBeat.i(186684);
        if (wIH == null || !wIH.toString().contains(str)) {
            axn(str);
            AppMethodBeat.o(186684);
            return;
        }
        AppMethodBeat.o(186684);
    }

    private static boolean x(JSONArray jSONArray) {
        AppMethodBeat.i(186685);
        if (jSONArray.toString().length() <= 1000) {
            AppMethodBeat.o(186685);
            return true;
        }
        AppMethodBeat.o(186685);
        return false;
    }

    public static void MY(int i2) {
        AppMethodBeat.i(186686);
        if (TextUtils.isEmpty(wII)) {
            wII += String.valueOf(i2);
            AppMethodBeat.o(186686);
            return;
        }
        wII += "-" + i2;
        AppMethodBeat.o(186686);
    }

    public static void z(int i2, int i3, String str) {
        AppMethodBeat.i(186687);
        ax axVar = new ax();
        axVar.eqL = 1;
        axVar.eqM = i2;
        axVar.eqN = i3;
        axVar.iC(str);
        axVar.bfK();
        AppMethodBeat.o(186687);
    }

    public static void bq(int i2, String str) {
        AppMethodBeat.i(186688);
        ax axVar = new ax();
        axVar.eqL = 2;
        axVar.eqM = 0;
        axVar.eqN = i2;
        axVar.iC(str);
        axVar.bfK();
        AppMethodBeat.o(186688);
    }
}
