package com.tencent.mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.exf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int Ici = -256;
    public static int Icj = 621019136;
    public static int Ick = 637534720;

    public static ArrayList<MallNews> O(JSONArray jSONArray) {
        AppMethodBeat.i(70539);
        try {
            ArrayList<MallNews> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                MallNews mallNews = new MallNews(jSONObject.optString("activity_jump_funcid"));
                mallNews.Icp = jSONObject.optString("activity_icon_link");
                mallNews.Icn = jSONObject.optString("activity_msg_content");
                mallNews.Icq = jSONObject.optString("activity_tips");
                arrayList.add(mallNews);
            }
            AppMethodBeat.o(70539);
            return arrayList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.MallLogic", e2, "", new Object[0]);
            AppMethodBeat.o(70539);
            return null;
        }
    }

    public static ArrayList<a> P(JSONArray jSONArray) {
        AppMethodBeat.i(70540);
        try {
            ArrayList<a> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                a aVar = new a();
                aVar.Ica = jSONObject.optInt("banner_id");
                aVar.Icb = jSONObject.optString("banner_title");
                aVar.Icc = jSONObject.optString("banner_link");
                arrayList.add(aVar);
            }
            AppMethodBeat.o(70540);
            return arrayList;
        } catch (JSONException e2) {
            Log.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e2.getMessage());
            AppMethodBeat.o(70540);
            return null;
        }
    }

    public static SparseArray<String> Q(JSONArray jSONArray) {
        AppMethodBeat.i(70541);
        try {
            SparseArray<String> sparseArray = new SparseArray<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            AppMethodBeat.o(70541);
            return sparseArray;
        } catch (JSONException e2) {
            Log.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e2.getMessage());
            AppMethodBeat.o(70541);
            return null;
        }
    }

    public static boolean hZ(List<a> list) {
        AppMethodBeat.i(70542);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(270342, (Object) 0)).intValue();
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                Log.d("MicroMsg.MallLogic", "i:" + size + ", lastClickedListMaxId:" + intValue + ", actId:" + list.get(size).Ica);
                if (list.get(size).Ica > intValue) {
                    AppMethodBeat.o(70542);
                    return true;
                }
            }
        }
        AppMethodBeat.o(70542);
        return false;
    }

    public static void ia(List<a> list) {
        AppMethodBeat.i(70543);
        if (list == null || list.size() <= 0) {
            Log.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            AppMethodBeat.o(70543);
            return;
        }
        int i2 = list.get(0).Ica;
        Log.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i2)));
        g.aAi();
        g.aAh().azQ().set(270342, Integer.valueOf(i2));
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(70543);
    }

    public static ArrayList<MallFunction> R(JSONArray jSONArray) {
        ArrayList<MallFunction> arrayList;
        AppMethodBeat.i(70544);
        try {
            arrayList = new ArrayList<>();
            int length = jSONArray.length();
            Log.d("MicroMsg.MallLogic", "functions.jsonArray.length : ".concat(String.valueOf(length)));
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                MallFunction mallFunction = new MallFunction();
                mallFunction.kHR = jSONObject.getString("func_id");
                mallFunction.edq = jSONObject.getString("func_name");
                mallFunction.Icd = jSONObject.optString("func_icon_url");
                mallFunction.zkt = jSONObject.optString("hd_icon_url");
                mallFunction.zku = jSONObject.optString("func_foregroud_icon_url");
                mallFunction.egX = jSONObject.optString("native_url");
                mallFunction.h5Url = jSONObject.optString("h5_url");
                mallFunction.type = jSONObject.optInt("property_type", 0);
                mallFunction.Icg = jSONObject.optString("third_party_disclaimer");
                mallFunction.Ich = jSONObject.optInt("download_restrict", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("remark_name_list");
                if (optJSONArray != null) {
                    mallFunction.Ice = new ArrayList<>();
                    int length2 = optJSONArray.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        mallFunction.Ice.add(optJSONArray.getString(i3));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_list");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    String str = mallFunction.kHR;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(0);
                    MallNews mallNews = new MallNews(str);
                    mallNews.FJm = jSONObject2.optString("activity_id");
                    mallNews.dHx = jSONObject2.optString("activity_ticket");
                    mallNews.Icn = jSONObject2.optString("activity_msg_content");
                    mallNews.Ico = jSONObject2.optString("activity_link");
                    mallNews.Icp = jSONObject2.optString("activity_icon_link");
                    mallNews.DrO = jSONObject2.optInt("activity_expired_time");
                    mallNews.Icq = jSONObject2.optString("activity_tips");
                    mallNews.trD = jSONObject2.optInt("activity_type");
                    mallNews.Ict = jSONObject2.optString("activity_url");
                    mallNews.Icr = jSONObject2.optInt("is_msg_reserved");
                    mallFunction.Icf = mallNews;
                }
                arrayList.add(mallFunction);
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.MallLogic", e2, "", new Object[0]);
            arrayList = null;
        }
        AppMethodBeat.o(70544);
        return arrayList;
    }

    public static String fRY() {
        String str;
        AppMethodBeat.i(70545);
        TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkCountryIso();
        } else {
            str = "";
        }
        AppMethodBeat.o(70545);
        return str;
    }

    public static void a(bhw bhw) {
        AppMethodBeat.i(214206);
        try {
            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.WALLET_MALL_FUNCTION_LIST_RESPONE_NEW_STRING_SYNC, e.bytesToHexString(bhw.toByteArray()));
            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().gBI();
            AppMethodBeat.o(214206);
        } catch (IOException e2) {
            Log.e("MicroMsg.MallLogic", "save config exp, " + e2.getLocalizedMessage());
            AppMethodBeat.o(214206);
        }
    }

    private static bhw fRZ() {
        AppMethodBeat.i(214207);
        bhw bhw = new bhw();
        String str = (String) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.WALLET_MALL_FUNCTION_LIST_RESPONE_NEW_STRING_SYNC, (Object) null);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone is null");
        } else {
            try {
                bhw.parseFrom(e.bqe(str));
                Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone success");
            } catch (Exception e2) {
                Log.e("MicroMsg.MallLogic", "getMallNewFunctionListRespone fail, " + e2.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(214207);
        return bhw;
    }

    public static SparseArray<String> fSa() {
        AppMethodBeat.i(214208);
        SparseArray<String> sparseArray = new SparseArray<>();
        bhw fRZ = fRZ();
        if (fRZ.GroupList != null) {
            Iterator<bfw> it = fRZ.GroupList.iterator();
            while (it.hasNext()) {
                bfw next = it.next();
                if (!(next == null || next.LPz == null)) {
                    exf exf = next.LPz;
                    sparseArray.put(exf.LPy, exf.LPg);
                }
            }
        }
        AppMethodBeat.o(214208);
        return sparseArray;
    }

    public static SparseArray<Integer> fSb() {
        AppMethodBeat.i(214209);
        SparseArray<Integer> sparseArray = new SparseArray<>();
        bhw fRZ = fRZ();
        if (fRZ.GroupList != null) {
            for (int i2 = 0; i2 < fRZ.GroupList.size(); i2++) {
                bfw bfw = fRZ.GroupList.get(i2);
                if (!(bfw == null || bfw.LPz == null)) {
                    sparseArray.put(bfw.LPz.LPy, Integer.valueOf(i2 + 1));
                }
            }
        }
        AppMethodBeat.o(214209);
        return sparseArray;
    }

    public static ArrayList<Integer> fSc() {
        AppMethodBeat.i(214210);
        ArrayList<Integer> arrayList = new ArrayList<>();
        bhw fRZ = fRZ();
        if (fRZ.GroupList != null) {
            for (int i2 = 0; i2 < fRZ.GroupList.size(); i2++) {
                bfw bfw = fRZ.GroupList.get(i2);
                if (!(bfw == null || bfw.LPz == null)) {
                    arrayList.add(Integer.valueOf(bfw.LPz.LPy));
                }
            }
        }
        AppMethodBeat.o(214210);
        return arrayList;
    }

    public static ArrayList<bfv> fSd() {
        AppMethodBeat.i(214211);
        ArrayList<bfv> arrayList = new ArrayList<>();
        bhw fRZ = fRZ();
        if (fRZ.GroupList != null) {
            Iterator<bfw> it = fRZ.GroupList.iterator();
            while (it.hasNext()) {
                bfw next = it.next();
                if (next != null) {
                    Iterator<bfv> it2 = next.LPA.iterator();
                    while (it2.hasNext()) {
                        bfv next2 = it2.next();
                        if (next2 != null) {
                            next2.LPy = next.LPz.LPy;
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(214211);
        return arrayList;
    }

    public static SparseArray<ArrayList<Integer>> fSe() {
        AppMethodBeat.i(214212);
        SparseArray<ArrayList<Integer>> sparseArray = new SparseArray<>();
        bhw fRZ = fRZ();
        if (fRZ.GroupList != null) {
            Iterator<bfw> it = fRZ.GroupList.iterator();
            while (it.hasNext()) {
                bfw next = it.next();
                if (next != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    Iterator<bfv> it2 = next.LPA.iterator();
                    while (it2.hasNext()) {
                        bfv next2 = it2.next();
                        if (next2 != null) {
                            arrayList.add(Integer.valueOf(next2.LPr.Nuz));
                        }
                    }
                    sparseArray.put(next.LPz.LPy, arrayList);
                }
            }
        }
        AppMethodBeat.o(214212);
        return sparseArray;
    }

    public static String fSf() {
        AppMethodBeat.i(214213);
        String str = fRZ().LSh;
        AppMethodBeat.o(214213);
        return str;
    }

    public static final class a {
        public static void aVr(String str) {
            String[] split;
            boolean z = false;
            AppMethodBeat.i(214204);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(214204);
                return;
            }
            g.aAi();
            String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, (Object) null);
            if (!(Util.isNullOrNil(str2) || (split = str2.split(",")) == null || split.length == 0)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= split.length) {
                        break;
                    } else if (split[i2].equals(str)) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                str = !z ? str2 + "," + str : str2;
            }
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, str);
            AppMethodBeat.o(214204);
        }

        public static boolean aVs(String str) {
            boolean z = false;
            AppMethodBeat.i(214205);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(214205);
                return true;
            }
            g.aAi();
            String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, (Object) null);
            if (Util.isNullOrNil(str2)) {
                AppMethodBeat.o(214205);
                return false;
            }
            String[] split = str2.split(",");
            if (split == null || split.length == 0) {
                AppMethodBeat.o(214205);
                return false;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= split.length) {
                    break;
                } else if (split[i2].equals(str)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            AppMethodBeat.o(214205);
            return z;
        }
    }

    public static void aeM(int i2) {
        boolean z;
        AppMethodBeat.i(70546);
        if ((d.KyO & Ici) == i2) {
            g.aAi();
            int intValue = ((Integer) g.aAh().azQ().get(270343, (Object) 0)).intValue();
            if (i2 != intValue) {
                Log.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i2 + ", clickedV=" + intValue);
                z = true;
                if (z && z.aUj()) {
                    Log.d("MicroMsg.MallLogic", "Show mall entry redot");
                    c.axV().A(262156, true);
                    g.aAi();
                    g.aAh().azQ().set(270343, Integer.valueOf(i2));
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(70546);
            }
        }
        z = false;
        Log.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.axV().A(262156, true);
        g.aAi();
        g.aAh().azQ().set(270343, Integer.valueOf(i2));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(70546);
    }
}
