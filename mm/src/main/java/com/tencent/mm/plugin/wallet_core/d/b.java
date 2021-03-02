package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.wallet_core.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static Map<String, String> IcD = null;
    private static final String pTN = c.hgG();

    static {
        AppMethodBeat.i(70590);
        AppMethodBeat.o(70590);
    }

    public static boolean aVy(String str) {
        String optString;
        AppMethodBeat.i(70582);
        try {
            if (IcD == null) {
                IcD = new HashMap();
            }
            Log.d("MicroMsg.WalletBankLogoStorage", "bank logo:".concat(String.valueOf(str)));
            SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).edit();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("bank_urls_list");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (z.aUo()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                String jSONObject2 = jSONObject.toString();
                if (Util.isNullOrNil(optString) || Util.isNullOrNil(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                IcD.put(optString, jSONObject2);
            }
            edit.commit();
            Log.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            AppMethodBeat.o(70582);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "", new Object[0]);
            AppMethodBeat.o(70582);
            return false;
        }
    }

    public static boolean bw(LinkedList<String> linkedList) {
        String optString;
        AppMethodBeat.i(70583);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            if (IcD == null) {
                IcD = new HashMap();
            }
            SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).edit();
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                JSONObject jSONObject = new JSONObject(linkedList.get(i2));
                if (z.aUo()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                jSONObject.put(AppMeasurement.Param.TIMESTAMP, currentTimeMillis);
                String jSONObject2 = jSONObject.toString();
                if (Util.isNullOrNil(optString) || Util.isNullOrNil(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                IcD.put(optString, jSONObject2);
            }
            edit.commit();
            Log.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            AppMethodBeat.o(70583);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "", new Object[0]);
            AppMethodBeat.o(70583);
            return false;
        }
    }

    private static void fCp() {
        AppMethodBeat.i(70585);
        IcD = new HashMap();
        for (Map.Entry<String, ?> entry : MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet()) {
            IcD.put(entry.getKey(), (String) entry.getValue());
        }
        AppMethodBeat.o(70585);
    }

    public static e j(Context context, String str, boolean z) {
        AppMethodBeat.i(70586);
        if (!z) {
            e bO = bO(context, str);
            AppMethodBeat.o(70586);
            return bO;
        }
        e eVar = null;
        if ("CITIC_CREDIT".equals(str)) {
            eVar = new e();
            eVar.HWg = R.drawable.cr6;
            eVar.HWh = R.drawable.cr8;
            e bO2 = bO(context, str);
            if (bO2 != null) {
                eVar.AAU = bO2.AAU;
            }
        }
        AppMethodBeat.o(70586);
        return eVar;
    }

    private static e bO(Context context, String str) {
        String str2;
        boolean z;
        e eVar;
        boolean z2 = true;
        AppMethodBeat.i(70587);
        if (IcD == null) {
            fCp();
            str2 = IcD.get(str);
        } else {
            str2 = IcD.get(str);
            if (str2 == null) {
                Log.i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", str);
                str2 = MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).getString(str, "");
                if (str2 != null) {
                    Log.w("MicroMsg.WalletBankLogoStorage", "get from sp %s", str);
                    IcD.put(str, str2);
                }
            }
        }
        if (Util.isNullOrNil(str2)) {
            g.aAi();
            if (g.aAh().isSDCardAvailable()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(str);
                f fVar = new f(linkedList);
                g.aAi();
                g.aAg().hqi.a(fVar, 0);
            }
            aVy(bP(context, "config/bank_logo.xml"));
            if (IcD != null) {
                str2 = IcD.get(str);
                z = true;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if (!Util.isNullOrNil(str2)) {
            e eVar2 = new e();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long optLong = jSONObject.optLong(AppMeasurement.Param.TIMESTAMP, 0);
                eVar2.AAU = jSONObject.getString("logo2x_url");
                eVar2.HWc = jSONObject.getString("bg2x_url");
                eVar2.HWd = jSONObject.getString("wl2x_url");
                if (!z && (System.currentTimeMillis() / 1000) - optLong <= 7200) {
                    z2 = false;
                }
                eVar2.needUpdate = z2;
                eVar2.HWe = aKj(eVar2.AAU);
                eVar2.pinyin = jSONObject.optString("bank_name_pinyin", "");
                eVar2.timestamp = optLong;
                eVar = eVar2;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "", new Object[0]);
                AppMethodBeat.o(70587);
                return null;
            }
        } else {
            eVar = null;
        }
        AppMethodBeat.o(70587);
        return eVar;
    }

    private static String bP(Context context, String str) {
        AppMethodBeat.i(70588);
        String str2 = "";
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "close", new Object[0]);
                }
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e3, "getFromAssets", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e4, "close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e5, "close", new Object[0]);
                }
            }
            AppMethodBeat.o(70588);
            throw th;
        }
        AppMethodBeat.o(70588);
        return str2;
    }

    public static String fSn() {
        return pTN;
    }

    public static String aKj(String str) {
        AppMethodBeat.i(70589);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
            AppMethodBeat.o(70589);
            return null;
        }
        String format = String.format("%s/%s", pTN, com.tencent.mm.b.g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(70589);
        return format;
    }

    public static e aVz(String str) {
        boolean z;
        AppMethodBeat.i(70584);
        if (IcD == null) {
            fCp();
        }
        if (!Util.isNullOrNil(IcD.get(str))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(70584);
            return null;
        }
        String str2 = IcD.get(str);
        if (!Util.isNullOrNil(str2)) {
            e eVar = new e();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long optLong = jSONObject.optLong(AppMeasurement.Param.TIMESTAMP, 0);
                eVar.AAU = jSONObject.getString("logo2x_url");
                eVar.HWc = jSONObject.getString("bg2x_url");
                eVar.HWd = jSONObject.getString("wl2x_url");
                eVar.needUpdate = (System.currentTimeMillis() / 1000) - optLong > 7200;
                eVar.HWe = aKj(eVar.AAU);
                eVar.pinyin = jSONObject.optString("bank_name_pinyin", "");
                eVar.timestamp = optLong;
                AppMethodBeat.o(70584);
                return eVar;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "", new Object[0]);
                AppMethodBeat.o(70584);
                return null;
            }
        } else {
            AppMethodBeat.o(70584);
            return null;
        }
    }
}
