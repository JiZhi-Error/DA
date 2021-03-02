package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

public final class a {
    private static HashMap<String, String> yAa = new HashMap<>();
    private static HashMap<String, String> yAb = new HashMap<>();
    private static HashMap<String, String> yAc = new HashMap<>();
    private static HashMap<String, String> yAd = new HashMap<>();
    public static int yzU = 3;
    public static String yzV = "+";
    public static String yzW = "00";
    public static String yzX = null;
    private static PhoneFormater yzY = new PhoneFormater();
    private static HashMap<String, b> yzZ = new HashMap<>();

    static {
        AppMethodBeat.i(26089);
        AppMethodBeat.o(26089);
    }

    public static String ba(Context context, String str) {
        String str2 = null;
        AppMethodBeat.i(26063);
        if (!b.n(context, "android.permission.READ_CONTACTS")) {
            Log.e("MicroMsg.IPCallAddressUtil", "no contact permission");
            AppMethodBeat.o(26063);
        } else {
            Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"contact_id", "data1"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (true) {
                            if (query.isAfterLast()) {
                                break;
                            } else if (PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.b.Ts(str), query.getString(1))) {
                                str2 = query.getString(0);
                                break;
                            } else {
                                query.moveToNext();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", e2.getMessage());
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(26063);
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(26063);
        }
        return str2;
    }

    public static String bb(Context context, String str) {
        AppMethodBeat.i(26064);
        String ba = ba(context, str);
        if (!Util.isNullOrNil(ba)) {
            String k = com.tencent.mm.pluginsdk.b.k(ba, context);
            AppMethodBeat.o(26064);
            return k;
        }
        AppMethodBeat.o(26064);
        return null;
    }

    public static String bc(Context context, String str) {
        AppMethodBeat.i(26065);
        if (!Util.isNullOrNil(str)) {
            String k = com.tencent.mm.pluginsdk.b.k(str, context);
            AppMethodBeat.o(26065);
            return k;
        }
        AppMethodBeat.o(26065);
        return null;
    }

    public static Bitmap bd(Context context, String str) {
        AppMethodBeat.i(26066);
        Bitmap g2 = g(context, str, false);
        AppMethodBeat.o(26066);
        return g2;
    }

    public static Bitmap g(Context context, String str, boolean z) {
        AppMethodBeat.i(26067);
        if (!Util.isNullOrNil(str)) {
            Bitmap a2 = com.tencent.mm.pluginsdk.b.a(str, context, z);
            AppMethodBeat.o(26067);
            return a2;
        }
        AppMethodBeat.o(26067);
        return null;
    }

    public static Bitmap be(Context context, String str) {
        AppMethodBeat.i(26068);
        String ba = ba(context, str);
        Bitmap bitmap = null;
        if (!Util.isNullOrNil(ba)) {
            bitmap = g(context, ba, true);
        }
        if (bitmap == null && boc()) {
            String aCs = aCs(str);
            Log.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", aCs);
            if (!Util.isNullOrNil(aCs)) {
                bitmap = c.e(aCs, 320, 320, 4);
            }
        }
        AppMethodBeat.o(26068);
        return bitmap;
    }

    public static String aCs(String str) {
        AppMethodBeat.i(26069);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26069);
            return null;
        }
        String SW = com.tencent.mm.plugin.account.a.getAddrUploadStg().SW(g.getMessageDigest(c.trimPhoneNumber(str).getBytes()));
        AppMethodBeat.o(26069);
        return SW;
    }

    public static String aCt(String str) {
        AppMethodBeat.i(26070);
        if (!Util.isNullOrNil(str)) {
            String SX = com.tencent.mm.plugin.account.a.getAddrUploadStg().SX(str);
            AppMethodBeat.o(26070);
            return SX;
        }
        AppMethodBeat.o(26070);
        return null;
    }

    public static String Pq(int i2) {
        AppMethodBeat.i(26071);
        Context context = MMApplicationContext.getContext();
        switch (i2) {
            case 1:
                String string = context.getString(R.string.flw);
                AppMethodBeat.o(26071);
                return string;
            case 2:
                String string2 = context.getString(R.string.fly);
                AppMethodBeat.o(26071);
                return string2;
            case 3:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                String string3 = context.getString(R.string.flz);
                AppMethodBeat.o(26071);
                return string3;
            case 4:
                String string4 = context.getString(R.string.flv);
                AppMethodBeat.o(26071);
                return string4;
            case 5:
                String string5 = context.getString(R.string.flx);
                AppMethodBeat.o(26071);
                return string5;
            case 10:
                String string6 = context.getString(R.string.flu);
                AppMethodBeat.o(26071);
                return string6;
        }
    }

    public static HashMap<String, b> ebJ() {
        AppMethodBeat.i(26073);
        if (yzZ.size() == 0) {
            ebI();
        }
        HashMap<String, b> hashMap = yzZ;
        AppMethodBeat.o(26073);
        return hashMap;
    }

    public static String aCu(String str) {
        AppMethodBeat.i(26074);
        if (yzZ.size() == 0) {
            ebI();
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26074);
            return null;
        }
        b bVar = yzZ.get(str);
        if (bVar != null) {
            String str2 = bVar.yAg;
            AppMethodBeat.o(26074);
            return str2;
        }
        AppMethodBeat.o(26074);
        return null;
    }

    public static String aCv(String str) {
        AppMethodBeat.i(26075);
        if (yAa.size() == 0) {
            ebI();
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26075);
            return null;
        }
        String str2 = yAa.get(str);
        AppMethodBeat.o(26075);
        return str2;
    }

    public static String aCw(String str) {
        AppMethodBeat.i(26076);
        if (yAc.size() == 0) {
            ebI();
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26076);
            return null;
        }
        String str2 = yAc.get(str);
        AppMethodBeat.o(26076);
        return str2;
    }

    public static int ip(String str, String str2) {
        AppMethodBeat.i(26077);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(26077);
            return -1;
        }
        int iq = iq(str, str2);
        if (iq == -1 && str2.startsWith("+")) {
            String extractCountryCode = extractCountryCode(str2);
            if (!Util.isNullOrNil(extractCountryCode)) {
                str2 = str2.substring("+".concat(String.valueOf(extractCountryCode)).length());
            }
            iq = iq(str, str2);
        }
        AppMethodBeat.o(26077);
        return iq;
    }

    private static int iq(String str, String str2) {
        AppMethodBeat.i(26078);
        if (!b.n(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS")) {
            Log.e("MicroMsg.IPCallAddressUtil", "no contact permission");
            AppMethodBeat.o(26078);
            return -1;
        }
        Cursor query = MMApplicationContext.getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
        String trimPhoneNumber = c.trimPhoneNumber(str2);
        try {
            if (query.moveToFirst()) {
                while (!query.isAfterLast()) {
                    int i2 = query.getInt(query.getColumnIndex("data2"));
                    if (c.trimPhoneNumber(query.getString(query.getColumnIndex("data1"))).equals(trimPhoneNumber)) {
                        query.close();
                        AppMethodBeat.o(26078);
                        return i2;
                    }
                    query.moveToNext();
                }
            }
            query.close();
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallAddressUtil", "getPhoneTypeByContactIdAndPhoneNumber error: %s", e2.getMessage());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(26078);
            throw th;
        }
        AppMethodBeat.o(26078);
        return -1;
    }

    public static String extractCountryCode(String str) {
        AppMethodBeat.i(26079);
        if (yAa.size() == 0) {
            ebI();
        }
        if (aCy(str)) {
            String trimPhoneNumber = c.trimPhoneNumber(aCz(str));
            ArrayList<String> arrayList = new ArrayList(yAa.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new C1438a((byte) 0)));
            for (String str2 : arrayList) {
                if (trimPhoneNumber.startsWith(str2)) {
                    AppMethodBeat.o(26079);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(26079);
        return null;
    }

    public static boolean aCx(String str) {
        AppMethodBeat.i(26080);
        if (yAa.size() == 0) {
            ebI();
        }
        if (yAa.containsKey(str)) {
            AppMethodBeat.o(26080);
            return true;
        }
        AppMethodBeat.o(26080);
        return false;
    }

    public static boolean aCy(String str) {
        AppMethodBeat.i(26081);
        if (Util.isNullOrNil(str) || (!str.startsWith(yzV) && !str.startsWith(yzW))) {
            AppMethodBeat.o(26081);
            return false;
        }
        AppMethodBeat.o(26081);
        return true;
    }

    public static String aCz(String str) {
        AppMethodBeat.i(26082);
        if (!Util.isNullOrNil(str)) {
            if (str.startsWith(yzV)) {
                String substring = str.substring(yzV.length());
                AppMethodBeat.o(26082);
                return substring;
            } else if (str.startsWith(yzW)) {
                String substring2 = str.substring(yzW.length());
                AppMethodBeat.o(26082);
                return substring2;
            }
        }
        AppMethodBeat.o(26082);
        return str;
    }

    public static String aCA(String str) {
        String formatMobileString;
        AppMethodBeat.i(26083);
        String trimPhoneNumber = c.trimPhoneNumber(str);
        String trimPhoneNumber2 = c.trimPhoneNumber(trimPhoneNumber);
        String str2 = null;
        if (aCy(trimPhoneNumber2)) {
            str2 = extractCountryCode(trimPhoneNumber2);
        }
        if (!Util.isNullOrNil(str2)) {
            String substring = aCz(trimPhoneNumber2).substring(str2.length());
            String formatNumber = yzY.formatNumber(str2, substring);
            if (!Util.isNullOrNil(formatNumber)) {
                substring = formatNumber;
            }
            if (!substring.startsWith("+")) {
                formatMobileString = "+" + str2 + " " + substring;
            } else {
                formatMobileString = "+" + str2 + " " + substring.replace("+", "");
            }
        } else {
            formatMobileString = PhoneFormater.formatMobileString(trimPhoneNumber);
        }
        if (formatMobileString.length() > 25) {
            formatMobileString = formatMobileString.substring(0, 25) + "...";
        }
        AppMethodBeat.o(26083);
        return formatMobileString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ebK() {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.a.ebK():java.lang.String");
    }

    public static void ebL() {
        AppMethodBeat.i(26085);
        ebI();
        AppMethodBeat.o(26085);
    }

    public static String aCB(String str) {
        AppMethodBeat.i(26086);
        if (yAa.size() == 0) {
            ebI();
        }
        if (aCy(str)) {
            str = c.trimPhoneNumber(aCz(str));
            ArrayList<String> arrayList = new ArrayList(yAa.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new C1438a((byte) 0)));
            for (String str2 : arrayList) {
                if (str.startsWith(str2)) {
                    String substring = str.substring(str2.length());
                    AppMethodBeat.o(26086);
                    return substring;
                }
            }
        }
        AppMethodBeat.o(26086);
        return str;
    }

    public static boolean boc() {
        AppMethodBeat.i(26087);
        bh bhVar = new bh();
        EventCenter.instance.publish(bhVar);
        Log.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", Boolean.valueOf(bhVar.dEw.result));
        boolean z = bhVar.dEw.result;
        AppMethodBeat.o(26087);
        return z;
    }

    public static ArrayList<String> aCC(String str) {
        AppMethodBeat.i(26088);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!b.n(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS")) {
            Log.e("MicroMsg.IPCallAddressUtil", "no contact permission");
            AppMethodBeat.o(26088);
            return arrayList;
        }
        Cursor query = MMApplicationContext.getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
        try {
            if (query.moveToFirst()) {
                while (!query.isAfterLast()) {
                    arrayList.add(query.getString(query.getColumnIndex("contact_id")));
                    query.moveToNext();
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallAddressUtil", "getQueryPhoneNumberContactIdList error: %s", e2.getMessage());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(26088);
            throw th;
        }
        AppMethodBeat.o(26088);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.ipcall.a.a$a  reason: collision with other inner class name */
    public static class C1438a implements Comparator<String> {
        private C1438a() {
        }

        /* synthetic */ C1438a(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(String str, String str2) {
            AppMethodBeat.i(26062);
            int length = str.length() - str2.length();
            AppMethodBeat.o(26062);
            return length;
        }
    }

    private static void ebI() {
        String str;
        AppMethodBeat.i(26072);
        yAa.clear();
        yAb.clear();
        yAc.clear();
        yAd.clear();
        yzZ.clear();
        InputStream inputStream = null;
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("ipcall_country_code.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", Util.stackTraceToString(e2));
                }
            }
        } catch (IOException e3) {
            Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", Util.stackTraceToString(e3));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str = "";
                } catch (IOException e4) {
                    Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", Util.stackTraceToString(e4));
                    str = "";
                }
            } else {
                str = "";
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", Util.stackTraceToString(e5));
                }
            }
            AppMethodBeat.o(26072);
            throw th;
        }
        String[] split = str.trim().split("\n");
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].trim().split(" ");
            if (split2.length < 2) {
                Log.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", split[i2]);
            } else {
                b bVar = new b();
                bVar.yAe = split2[0];
                bVar.yAf = split2[1];
                RegionCodeDecoder.gEm();
                String locName = RegionCodeDecoder.getLocName(split2[0]);
                if (Util.isNullOrNil(locName)) {
                    locName = new Locale("", split2[0]).getDisplayCountry(MMApplicationContext.getResources().getConfiguration().locale);
                }
                bVar.yAg = locName;
                yAc.put(bVar.yAf, bVar.yAe);
                yAd.put(bVar.yAe, bVar.yAf);
                yAa.put(bVar.yAf, bVar.yAg);
                yAb.put(bVar.yAg, bVar.yAf);
                yzZ.put(bVar.yAe, bVar);
            }
        }
        AppMethodBeat.o(26072);
    }
}
