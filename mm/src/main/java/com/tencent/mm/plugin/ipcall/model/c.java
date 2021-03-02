package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static c yox;
    boolean isInit = false;
    private ArrayList<Integer> yoy = new ArrayList<>();
    ArrayList<Integer> yoz = new ArrayList<>();

    private c() {
        AppMethodBeat.i(25338);
        AppMethodBeat.o(25338);
    }

    public static c ead() {
        AppMethodBeat.i(25339);
        if (yox == null) {
            yox = new c();
        }
        c cVar = yox;
        AppMethodBeat.o(25339);
        return cVar;
    }

    public final void qn(boolean z) {
        AppMethodBeat.i(25340);
        if (!this.isInit || z) {
            eaf();
            String str = b.aKB() + "ipcallCountryCodeConfig.cfg";
            try {
                o oVar = new o(str);
                if (!oVar.exists()) {
                    Log.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", str);
                    this.isInit = true;
                    return;
                }
                InputStream ao = s.ao(oVar);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ao));
                String str2 = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str2 = str2 + readLine;
                    } else {
                        Log.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", str2);
                        aBR(str2);
                        this.isInit = true;
                        aa.closeQuietly(ao);
                        AppMethodBeat.o(25340);
                        return;
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e2, "", new Object[0]);
                Log.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", e2.getMessage());
            } finally {
                aa.closeQuietly(null);
                AppMethodBeat.o(25340);
            }
        } else {
            AppMethodBeat.o(25340);
        }
    }

    private void aBR(String str) {
        AppMethodBeat.i(25341);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(25341);
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("restriction");
            Log.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", Integer.valueOf(jSONArray.length()));
            this.yoz.clear();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.yoz.add(Integer.valueOf(jSONArray.getInt(i2)));
            }
            AppMethodBeat.o(25341);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e2, "", new Object[0]);
            Log.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", e2.getMessage());
            AppMethodBeat.o(25341);
        }
    }

    private void eae() {
        AppMethodBeat.i(25342);
        this.yoy.clear();
        String value = h.aqJ().getValue("WeChatOutTopCountryCode");
        Log.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", value);
        if (!Util.isNullOrNil(value)) {
            String[] split = value.trim().split(",");
            int length = split.length;
            try {
                for (String str : split) {
                    Integer valueOf = Integer.valueOf(Util.getInt(str, 0));
                    this.yoy.add(valueOf);
                    i.eaA().ar(valueOf.intValue(), (long) length);
                    length--;
                }
                AppMethodBeat.o(25342);
                return;
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(25342);
    }

    private void eaf() {
        AppMethodBeat.i(25343);
        ArrayList<Integer> eba = i.eaA().eba();
        if (eba.size() > 0) {
            this.yoy = eba;
            AppMethodBeat.o(25343);
            return;
        }
        eae();
        AppMethodBeat.o(25343);
    }

    public final void aBS(String str) {
        AppMethodBeat.i(25344);
        if (!this.isInit) {
            qn(false);
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(25344);
            return;
        }
        i.eaA().ar(Util.getInt(str.replace("+", ""), 0), Util.nowMilliSecond());
        eaf();
        AppMethodBeat.o(25344);
    }

    public final List<Integer> eag() {
        AppMethodBeat.i(25345);
        if (!this.isInit) {
            qn(false);
        }
        ArrayList<Integer> arrayList = this.yoy;
        AppMethodBeat.o(25345);
        return arrayList;
    }

    public final boolean OY(int i2) {
        AppMethodBeat.i(25346);
        if (!this.isInit) {
            qn(false);
        }
        if (this.yoz == null || this.yoz.size() <= 0) {
            AppMethodBeat.o(25346);
            return false;
        }
        boolean contains = this.yoz.contains(Integer.valueOf(i2));
        AppMethodBeat.o(25346);
        return contains;
    }
}
