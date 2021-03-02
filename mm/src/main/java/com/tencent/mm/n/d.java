package com.tencent.mm.n;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public static final String gMf = (ar.NSe + "configlist/");
    public SparseArray<e> gMe = new SparseArray<>();

    public d() {
        AppMethodBeat.i(131970);
        AppMethodBeat.o(131970);
    }

    static {
        AppMethodBeat.i(131986);
        AppMethodBeat.o(131986);
    }

    public static String oH(int i2) {
        AppMethodBeat.i(131971);
        String str = gMf + "config_" + i2 + ".xml";
        AppMethodBeat.o(131971);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[SYNTHETIC, Splitter:B:30:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A[SYNTHETIC, Splitter:B:33:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea A[SYNTHETIC, Splitter:B:55:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ef A[SYNTHETIC, Splitter:B:58:0x00ef] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.vfs.o r11, com.tencent.mm.vfs.o r12) {
        /*
        // Method dump skipped, instructions count: 303
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.n.d.a(com.tencent.mm.vfs.o, com.tencent.mm.vfs.o):boolean");
    }

    public final void init() {
        AppMethodBeat.i(131973);
        for (int i2 = 0; i2 < e.gMg.length; i2++) {
            load(e.gMg[i2]);
        }
        AppMethodBeat.o(131973);
    }

    public final void y(int i2, String str) {
        AppMethodBeat.i(131974);
        e eVar = new e(i2);
        eVar.gMi = XmlParser.parseXml(str, "ConfigList", null);
        if (eVar.gMi.containsKey(".ConfigList.$version")) {
            eVar.version = Util.getInt(eVar.gMi.get(".ConfigList.$version"), 0);
        }
        int i3 = 0;
        while (true) {
            String str2 = ".ConfigList.Config" + (i3 == 0 ? "" : Integer.valueOf(i3));
            if (eVar.gMi.get(str2 + ".$name") != null) {
                String str3 = eVar.gMi.get(str2 + ".$name");
                if (!str3.equalsIgnoreCase("JDWebViewMenu")) {
                    int i4 = 0;
                    while (true) {
                        String str4 = str2 + ".Item" + (i4 == 0 ? "" : Integer.valueOf(i4));
                        String str5 = str2 + ".Item" + (i4 == 0 ? "" : Integer.valueOf(i4)) + ".$key";
                        String str6 = str2 + ".Item" + (i4 == 0 ? "" : Integer.valueOf(i4)) + ".$lang";
                        if (!eVar.gMi.containsKey(str4)) {
                            break;
                        }
                        String str7 = eVar.gMi.get(str5);
                        String str8 = eVar.gMi.get(str4);
                        String str9 = eVar.gMi.get(str6);
                        Log.d("MicroMsg.ConfigListInfo", "itemKey " + str7 + " itemValue " + str8 + " itemLang " + str9);
                        if (str9 == null || e.Ek(str9)) {
                            if (!eVar.gMh.containsKey(str3)) {
                                eVar.gMh.put(str3, new HashMap<>());
                            }
                            eVar.gMh.get(str3).put(str7, str8);
                        }
                        i4++;
                    }
                }
                i3++;
            } else {
                this.gMe.put(i2, eVar);
                AppMethodBeat.o(131974);
                return;
            }
        }
    }

    public final String aj(String str, String str2) {
        AppMethodBeat.i(131975);
        e aqv = aqv();
        if (aqv == null) {
            AppMethodBeat.o(131975);
            return null;
        } else if (aqv.gMh.containsKey(str)) {
            String str3 = aqv.gMh.get(str).get(str2);
            AppMethodBeat.o(131975);
            return str3;
        } else {
            AppMethodBeat.o(131975);
            return null;
        }
    }

    public final e aqv() {
        AppMethodBeat.i(131976);
        if (this.gMe.get(1) == null) {
            load(1);
        }
        e eVar = this.gMe.get(1);
        AppMethodBeat.o(131976);
        return eVar;
    }

    private void load(int i2) {
        AppMethodBeat.i(131977);
        InputStream inputStream = null;
        try {
            o oVar = new o(oH(i2));
            if (oVar.exists()) {
                inputStream = s.ao(oVar);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, ProtocolPackage.ServerEncoding);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                y(i2, stringBuffer.toString());
                inputStreamReader.close();
                bufferedReader.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(131977);
                    return;
                } catch (IOException e2) {
                    Log.e("MicroMsg.ConfigListDecoder", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(131977);
                    return;
                }
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.ConfigListDecoder", "exception:%s", Util.stackTraceToString(e3));
            if (0 != 0) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(131977);
                    return;
                } catch (IOException e4) {
                    Log.e("MicroMsg.ConfigListDecoder", "exception:%s", Util.stackTraceToString(e4));
                    AppMethodBeat.o(131977);
                    return;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.e("MicroMsg.ConfigListDecoder", "exception:%s", Util.stackTraceToString(e5));
                }
            }
            AppMethodBeat.o(131977);
            throw th;
        }
        AppMethodBeat.o(131977);
    }

    public static int aqw() {
        int i2;
        AppMethodBeat.i(131978);
        String value = ((a) g.af(a.class)).aqJ().getValue("VoiceVOIPSwitch");
        Log.d("MicroMsg.ConfigListDecoder", "voip is ".concat(String.valueOf(value)));
        try {
            i2 = Util.getInt(value, 0);
        } catch (Exception e2) {
            Log.e("MicroMsg.ConfigListDecoder", "exception:%s", Util.stackTraceToString(e2));
            i2 = 0;
        }
        Log.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is ".concat(String.valueOf(i2)));
        AppMethodBeat.o(131978);
        return i2;
    }

    public final boolean aqx() {
        boolean z = true;
        AppMethodBeat.i(131979);
        if (Util.getInt(aj("ShowConfig", "hidePoiOversea"), 1) != 1) {
            z = false;
        }
        Log.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : ".concat(String.valueOf(z)));
        AppMethodBeat.o(131979);
        return z;
    }

    public final String aqy() {
        AppMethodBeat.i(131981);
        String aj = aj("FreeWiFiConfig", "CheckURL");
        Log.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", aj);
        AppMethodBeat.o(131981);
        return aj;
    }

    public final boolean aqz() {
        boolean z = true;
        AppMethodBeat.i(131982);
        if (Util.getInt(aj("ShowConfig", "showRecvTmpMsgBtn"), 0) != 1) {
            z = false;
        }
        Log.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : ".concat(String.valueOf(z)));
        AppMethodBeat.o(131982);
        return z;
    }

    public final List<String> aqA() {
        AppMethodBeat.i(131983);
        ArrayList arrayList = null;
        String aj = aj("IBeacon", "Content");
        if (!Util.isNullOrNil(aj)) {
            arrayList = new ArrayList();
            try {
                Iterator<String> keys = new JSONObject(aj.replace(",}", "}")).keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        arrayList.add(next.toString());
                    }
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(131983);
        return arrayList;
    }

    public final int aqB() {
        AppMethodBeat.i(196984);
        int i2 = Util.getInt(aj("MailApp", "ShowMailAppRecommend"), 0);
        AppMethodBeat.o(196984);
        return i2;
    }

    public final String aqC() {
        AppMethodBeat.i(131984);
        String aj = aj("MailApp", "MailAppRedirectUrAndroid");
        AppMethodBeat.o(131984);
        return aj;
    }

    public final String getMailAppEnterUlAndroid() {
        AppMethodBeat.i(131985);
        String aj = aj("MailApp", "MailAppEnterMailAppUrlAndroid");
        AppMethodBeat.o(131985);
        return aj;
    }
}
