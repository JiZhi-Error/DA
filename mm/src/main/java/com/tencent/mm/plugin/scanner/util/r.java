package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r {
    public static String CUD = "title";
    public static String CUE = "tip";
    public static String CUF = "buttonTitle";
    private static Boolean CUG = null;
    private static Boolean CUH = null;

    public static class a {
        public String eaP;
        public int nHh;
        public String pRX;
    }

    public static boolean Eg(int i2) {
        AppMethodBeat.i(52072);
        b bVar = (b) g.af(b.class);
        if (bVar != null) {
            boolean Eg = bVar.Eg(i2);
            AppMethodBeat.o(52072);
            return Eg;
        }
        AppMethodBeat.o(52072);
        return false;
    }

    public static a aMU(String str) {
        AppMethodBeat.i(52073);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(52073);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.pRX = jSONObject.optString("card_tp_id");
            aVar.nHh = jSONObject.optInt("card_type");
            aVar.eaP = jSONObject.optString("card_ext");
            AppMethodBeat.o(52073);
            return aVar;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ScannerUtil", e2, "", new Object[0]);
            AppMethodBeat.o(52073);
            return null;
        }
    }

    public static ArrayList<a> aMV(String str) {
        AppMethodBeat.i(52074);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(52074);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
                AppMethodBeat.o(52074);
                return null;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                a aVar = new a();
                aVar.pRX = optJSONObject.optString("card_tp_id");
                aVar.nHh = optJSONObject.optInt("card_type");
                aVar.eaP = optJSONObject.optString("card_ext");
                arrayList.add(aVar);
            }
            AppMethodBeat.o(52074);
            return arrayList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ScannerUtil", e2, "", new Object[0]);
            AppMethodBeat.o(52074);
            return null;
        }
    }

    public static boolean aO(ArrayList<a> arrayList) {
        AppMethodBeat.i(52075);
        if (arrayList == null || arrayList.size() == 0) {
            Log.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
            AppMethodBeat.o(52075);
            return false;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a aVar = arrayList.get(i2);
            if (aVar != null && Eg(aVar.nHh)) {
                AppMethodBeat.o(52075);
                return true;
            }
        }
        AppMethodBeat.o(52075);
        return false;
    }

    public static void bv(Context context, String str) {
        AppMethodBeat.i(52076);
        h.a(context, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.util.r.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(52071);
                dialogInterface.dismiss();
                AppMethodBeat.o(52071);
            }
        });
        AppMethodBeat.o(52076);
    }

    public static String jR(String str, String str2) {
        String[] split;
        AppMethodBeat.i(52077);
        String value = com.tencent.mm.n.h.aqJ().getValue("ScanBookWording");
        Log.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + Util.nullAsNil(value));
        if (!Util.isNullOrNil(value) && (split = value.split("&")) != null) {
            HashMap hashMap = new HashMap();
            for (String str3 : split) {
                String[] split2 = str3.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            String str4 = (String) hashMap.get(str);
            if (!Util.isNullOrNil(str4)) {
                str2 = str4;
            }
        }
        AppMethodBeat.o(52077);
        return str2;
    }

    public static boolean eSd() {
        String[] split;
        AppMethodBeat.i(52078);
        int i2 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("EnableNewOCRTranslation", 0);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(i2 == 1);
        objArr[1] = value;
        objArr[2] = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", objArr);
        if (i2 != 1 || Util.isNullOrNil(value) || (split = value.split(";")) == null || !Arrays.asList(split).contains(LocaleUtil.getApplicationLanguage())) {
            AppMethodBeat.o(52078);
            return false;
        }
        AppMethodBeat.o(52078);
        return true;
    }

    public static boolean Xd(int i2) {
        return i2 == 1 || i2 == 8 || i2 == 4;
    }

    public static boolean Xe(int i2) {
        return i2 == 12;
    }

    public static boolean Xf(int i2) {
        return i2 == 3;
    }

    public static void eSe() {
        AppMethodBeat.i(240829);
        eSg();
        eSi();
        AppMethodBeat.o(240829);
    }

    public static boolean eSf() {
        AppMethodBeat.i(52079);
        Log.i("MicroMsg.ScannerUtil", "alvinluo showScanGoodsTab %b", CUG);
        if (CUG == null) {
            eSg();
        }
        boolean booleanValue = CUG.booleanValue();
        AppMethodBeat.o(52079);
        return booleanValue;
    }

    private static void eSg() {
        boolean z;
        AppMethodBeat.i(52080);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_disable_scan_goods_tab, 0);
        if (a2 != 1) {
            z = true;
        } else {
            z = false;
        }
        CUG = Boolean.valueOf(z);
        Log.i("MicroMsg.ScannerUtil", "alvinluo updateShowScanGoodsTabSwitch clicfg_disable_scan_goods_tab config: %d, show: %b", Integer.valueOf(a2), CUG);
        AppMethodBeat.o(52080);
    }

    public static boolean eSh() {
        AppMethodBeat.i(240830);
        if (CUH == null) {
            eSi();
        }
        boolean booleanValue = CUH.booleanValue();
        AppMethodBeat.o(240830);
        return booleanValue;
    }

    private static void eSi() {
        boolean z;
        AppMethodBeat.i(240831);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_code_multi_code_enable, 0);
        if (a2 != 0 || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
            z = true;
        } else {
            z = false;
        }
        CUH = Boolean.valueOf(z);
        Log.i("MicroMsg.ScannerUtil", "alvinluo updateEnableMultiCode clicfg_scan_code_multi_code_enable config: %d, enable: %b", Integer.valueOf(a2), CUH);
        AppMethodBeat.o(240831);
    }
}
