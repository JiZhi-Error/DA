package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bh.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class c {
    public static esr bc(LinkedList<dfe> linkedList) {
        AppMethodBeat.i(26091);
        if (linkedList == null || linkedList.size() <= 0) {
            AppMethodBeat.o(26091);
            return null;
        }
        esr esr = new esr();
        esr.NpY = linkedList.size();
        esr.NpZ = new LinkedList<>();
        Iterator<dfe> it = linkedList.iterator();
        while (it.hasNext()) {
            dfe next = it.next();
            esq esq = new esq();
            esq.NgB = aCD(next.MpA);
            esq.MKe = next.MKe;
            esq.NgC = next.MpA;
            esr.NpZ.add(esq);
        }
        AppMethodBeat.o(26091);
        return esr;
    }

    private static int aCD(String str) {
        AppMethodBeat.i(26092);
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i2 = 0;
                for (byte b2 : address) {
                    i2 = (i2 << 8) | (b2 & 255);
                }
                Log.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i2));
                AppMethodBeat.o(26092);
                return i2;
            }
        } catch (UnknownHostException e2) {
            Log.printErrStackTrace("MicroMsg.IPCallUtil", e2, "", new Object[0]);
        }
        AppMethodBeat.o(26092);
        return 0;
    }

    public static int ebM() {
        AppMethodBeat.i(26093);
        Context context = MMApplicationContext.getContext();
        if (NetStatusUtil.is2G(context)) {
            AppMethodBeat.o(26093);
            return 1;
        } else if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(26093);
            return 3;
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(26093);
            return 5;
        } else if (NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(26093);
            return 4;
        } else {
            AppMethodBeat.o(26093);
            return 0;
        }
    }

    public static String trimPhoneNumber(String str) {
        AppMethodBeat.i(26094);
        String trim = str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
        AppMethodBeat.o(26094);
        return trim;
    }

    public static String Pr(int i2) {
        AppMethodBeat.i(26095);
        Context context = MMApplicationContext.getContext();
        switch (i2) {
            case 1:
                String string = context.getString(R.string.e7v);
                AppMethodBeat.o(26095);
                return string;
            case 2:
                String string2 = context.getString(R.string.e7v);
                AppMethodBeat.o(26095);
                return string2;
            case 3:
            case 4:
            case 5:
            default:
                String string3 = context.getString(R.string.e7v);
                AppMethodBeat.o(26095);
                return string3;
            case 6:
                String string4 = context.getString(R.string.e7r);
                AppMethodBeat.o(26095);
                return string4;
            case 7:
                String string5 = context.getString(R.string.e7s);
                AppMethodBeat.o(26095);
                return string5;
        }
    }

    public static CharSequence j(Context context, long j2) {
        AppMethodBeat.i(26096);
        CharSequence format = DateFormat.format(context.getString(R.string.df7), j2);
        AppMethodBeat.o(26096);
        return format;
    }

    public static String bf(Context context, String str) {
        int i2 = 0;
        AppMethodBeat.i(26097);
        String[] stringArray = context.getResources().getStringArray(R.array.as);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (String str2 : stringArray) {
            arrayList.add(str2);
        }
        try {
            i2 = Util.getInt(str, 0);
        } catch (Exception e2) {
        }
        if (i2 >= arrayList.size()) {
            AppMethodBeat.o(26097);
            return "";
        }
        String str3 = (String) arrayList.get(i2);
        AppMethodBeat.o(26097);
        return str3;
    }

    public static String GU(long j2) {
        AppMethodBeat.i(26098);
        Context context = MMApplicationContext.getContext();
        if (GV(j2)) {
            String format = new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j2));
            AppMethodBeat.o(26098);
            return format;
        } else if (GW(j2)) {
            String string = context.getString(R.string.e66);
            AppMethodBeat.o(26098);
            return string;
        } else {
            String format2 = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j2));
            AppMethodBeat.o(26098);
            return format2;
        }
    }

    private static boolean GV(long j2) {
        AppMethodBeat.i(26099);
        if (GX(j2) == 0) {
            AppMethodBeat.o(26099);
            return true;
        }
        AppMethodBeat.o(26099);
        return false;
    }

    private static boolean GW(long j2) {
        AppMethodBeat.i(26100);
        if (GX(j2) == -1) {
            AppMethodBeat.o(26100);
            return true;
        }
        AppMethodBeat.o(26100);
        return false;
    }

    private static long ebN() {
        AppMethodBeat.i(26101);
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        AppMethodBeat.o(26101);
        return timeInMillis2;
    }

    private static long GX(long j2) {
        AppMethodBeat.i(26102);
        long ebN = ebN();
        long timeInMillis = (j2 / ebN) - (Calendar.getInstance().getTimeInMillis() / ebN);
        AppMethodBeat.o(26102);
        return timeInMillis;
    }

    public static String GY(long j2) {
        AppMethodBeat.i(26103);
        Context context = MMApplicationContext.getContext();
        if (((double) j2) <= 60.0d) {
            String string = context.getString(R.string.e6e, String.valueOf(j2));
            AppMethodBeat.o(26103);
            return string;
        }
        int i2 = (int) (((double) j2) / 60.0d);
        if ((((double) j2) / 60.0d) - ((double) i2) > 0.0d) {
            i2++;
        }
        String string2 = context.getString(R.string.e6d, String.valueOf(i2));
        AppMethodBeat.o(26103);
        return string2;
    }

    public static boolean gq(Context context) {
        int i2 = R.string.e3g;
        AppMethodBeat.i(26104);
        if (m.isVoipStarted()) {
            i2 = R.string.e3h;
        } else if (!m.fKI()) {
            if (e.bgH()) {
                i2 = R.string.e3f;
            } else if (a.att()) {
                i2 = R.string.e3c;
            } else if (e.bgG()) {
                i2 = R.string.e3f;
            } else if (!a.atx()) {
                i2 = a.atw() ? R.string.e3c : 0;
            }
        }
        if (i2 == 0) {
            AppMethodBeat.o(26104);
            return true;
        }
        h.n(context, i2, R.string.zb);
        AppMethodBeat.o(26104);
        return false;
    }

    public static void aCE(String str) {
        AppMethodBeat.i(26105);
        ClipboardHelper.setText(MMApplicationContext.getContext(), null, str);
        AppMethodBeat.o(26105);
    }

    public static String ebO() {
        AppMethodBeat.i(26106);
        String string = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (!Util.isNullOrNil(string)) {
            String replace = string.replace("+", "");
            AppMethodBeat.o(26106);
            return replace;
        }
        String ebK = a.ebK();
        AppMethodBeat.o(26106);
        return ebK;
    }

    public static boolean ebP() {
        AppMethodBeat.i(26107);
        if (com.tencent.mm.n.h.aqJ().getInt("WCOSecondPurchaseSwitch", 0) > 0) {
            AppMethodBeat.o(26107);
            return true;
        }
        AppMethodBeat.o(26107);
        return false;
    }

    public static boolean ebQ() {
        AppMethodBeat.i(26108);
        if (com.tencent.mm.n.h.aqJ().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0) {
            AppMethodBeat.o(26108);
            return true;
        }
        AppMethodBeat.o(26108);
        return false;
    }

    public static byf ebR() {
        AppMethodBeat.i(26109);
        bg.aVF();
        Object obj = com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, (Object) null);
        if (obj != null) {
            byf byf = new byf();
            try {
                byf.parseFrom(Util.decodeHexString(obj.toString()));
                Log.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", byf.MdG, byf.xJH, byf.Title, byf.Desc, byf.MdH, byf.MdI, byf.MdJ, byf.MdK, byf.MdR);
                AppMethodBeat.o(26109);
                return byf;
            } catch (IOException e2) {
                Log.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", e2.getMessage());
            }
        }
        AppMethodBeat.o(26109);
        return null;
    }

    public static String Ps(int i2) {
        AppMethodBeat.i(26110);
        Context context = MMApplicationContext.getContext();
        if ((i2 & 1) > 0 && (i2 & 2) <= 0) {
            String str = context.getString(R.string.e9o) + " ";
            AppMethodBeat.o(26110);
            return str;
        } else if ((i2 & 8) > 0) {
            String str2 = context.getString(R.string.e9p) + " ";
            AppMethodBeat.o(26110);
            return str2;
        } else {
            AppMethodBeat.o(26110);
            return "";
        }
    }
}
