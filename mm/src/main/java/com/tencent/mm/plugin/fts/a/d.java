package com.tencent.mm.plugin.fts.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private static final HashMap<String, String> wVh = new HashMap<>();
    private static String[] wVi = {"wxid_", "wx_", "gh_"};

    public static String ayo(String str) {
        AppMethodBeat.i(131621);
        if (ab.Iw(str)) {
            AppMethodBeat.o(131621);
            return str;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(131621);
            return str;
        } else if (!Util.isNullOrNil(Kn.field_conRemarkPYFull)) {
            String str2 = Kn.field_conRemarkPYFull;
            AppMethodBeat.o(131621);
            return str2;
        } else if (!Util.isNullOrNil(Kn.ajA())) {
            String ajA = Kn.ajA();
            AppMethodBeat.o(131621);
            return ajA;
        } else if (!Util.isNullOrNil(Kn.ajx())) {
            String ajx = Kn.ajx();
            AppMethodBeat.o(131621);
            return ajx;
        } else {
            AppMethodBeat.o(131621);
            return str;
        }
    }

    static {
        AppMethodBeat.i(131643);
        AppMethodBeat.o(131643);
    }

    public static final HashMap<String, String> dOw() {
        AppMethodBeat.i(131622);
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, String> entry : wVh.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(131622);
        return hashMap;
    }

    public static final void eO(List<m> list) {
        AppMethodBeat.i(131623);
        wVh.clear();
        for (m mVar : list) {
            if (mVar.userData instanceof String) {
                wVh.put(mVar.wVX, (String) mVar.userData);
            } else {
                wVh.put(mVar.wVX, "");
            }
        }
        AppMethodBeat.o(131623);
    }

    public static String C(int[] iArr) {
        AppMethodBeat.i(131624);
        StringBuilder sb = new StringBuilder(32);
        sb.append('(');
        for (int i2 : iArr) {
            sb.append(i2).append(',');
        }
        sb.setCharAt(sb.length() - 1, ')');
        String sb2 = sb.toString();
        AppMethodBeat.o(131624);
        return sb2;
    }

    public static final String I(String[] strArr) {
        boolean z;
        AppMethodBeat.i(131625);
        StringBuilder sb = new StringBuilder(32);
        for (String str : strArr) {
            sb.append("\"");
            sb.append(str);
            char charAt = str.charAt(str.length() - 1);
            if (charAt >= '0' && charAt <= '9') {
                z = true;
            } else if (charAt >= 'A' && charAt <= 'Z') {
                z = true;
            } else if (charAt < 'a' || charAt > 'z') {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                sb.append("\"* ");
            } else {
                sb.append("\" ");
            }
        }
        String trim = sb.toString().trim();
        AppMethodBeat.o(131625);
        return trim;
    }

    public static int f(int[] iArr, int i2, int i3) {
        int i4 = Integer.MAX_VALUE;
        if (i2 == i3) {
            return 0;
        }
        int i5 = i2 >= iArr.length ? Integer.MAX_VALUE : iArr[i2];
        if (i3 < iArr.length) {
            i4 = iArr[i3];
        }
        return i5 - i4;
    }

    public static int a(Map<Integer, Integer> map, int i2, int i3) {
        int i4 = Integer.MAX_VALUE;
        AppMethodBeat.i(131626);
        if (i2 == i3) {
            AppMethodBeat.o(131626);
            return 0;
        }
        Integer num = map.get(Integer.valueOf(i2));
        int intValue = num == null ? Integer.MAX_VALUE : num.intValue();
        Integer num2 = map.get(Integer.valueOf(i3));
        if (num2 != null) {
            i4 = num2.intValue();
        }
        int i5 = intValue - i4;
        AppMethodBeat.o(131626);
        return i5;
    }

    public static List<m> a(List<m> list, final Map<Integer, Integer> map) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(131627);
        AnonymousClass1 r1 = new Comparator<m>() {
            /* class com.tencent.mm.plugin.fts.a.d.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(m mVar, m mVar2) {
                AppMethodBeat.i(131620);
                int a2 = d.a(map, mVar.type, mVar2.type);
                AppMethodBeat.o(131620);
                return a2;
            }
        };
        m mVar = new m();
        mVar.type = 131073;
        int binarySearch = Collections.binarySearch(list, mVar, r1);
        mVar.type = 131074;
        int binarySearch2 = Collections.binarySearch(list, mVar, r1);
        if (binarySearch < 0) {
            i3 = (-binarySearch) - 1;
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || list.get(i2).type != 131073) {
                    i3 = i2 + 1;
                } else {
                    binarySearch = i2;
                }
            }
            i3 = i2 + 1;
        }
        if (binarySearch2 < 0) {
            i4 = (-binarySearch2) - 1;
        } else {
            int size = list.size();
            int i5 = binarySearch2 + 1;
            while (i5 < size && list.get(i5).type == 131074) {
                i5++;
            }
            i4 = i5;
        }
        List<m> subList = list.subList(i3, i4);
        AppMethodBeat.o(131627);
        return subList;
    }

    public static final String ayp(String str) {
        AppMethodBeat.i(131628);
        if (str == null) {
            AppMethodBeat.o(131628);
            return null;
        }
        String ayw = g.ayw(((a) g.af(a.class)).fN(str.trim(), " "));
        AppMethodBeat.o(131628);
        return ayw;
    }

    public static final String ayq(String str) {
        AppMethodBeat.i(131629);
        String ayw = g.ayw(str.toLowerCase());
        AppMethodBeat.o(131629);
        return ayw;
    }

    public static final String ayr(String str) {
        AppMethodBeat.i(131630);
        if (str != null) {
            String trim = str.replace('*', ' ').trim();
            AppMethodBeat.o(131630);
            return trim;
        }
        AppMethodBeat.o(131630);
        return null;
    }

    public static String hw(String str, String str2) {
        AppMethodBeat.i(131631);
        if (str2 == null || str2.length() <= 0) {
            for (String str3 : wVi) {
                if (str.startsWith(str3)) {
                    AppMethodBeat.o(131631);
                    return null;
                }
            }
            if (str.indexOf(64) >= 0) {
                AppMethodBeat.o(131631);
                return null;
            }
            AppMethodBeat.o(131631);
            return str;
        }
        AppMethodBeat.o(131631);
        return str2;
    }

    public static String bB(String str, boolean z) {
        String str2;
        AppMethodBeat.i(131632);
        if (str == null) {
            AppMethodBeat.o(131632);
            return null;
        }
        String lowerCase = ayp(str).toLowerCase();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i2 = 0; i2 < lowerCase.length(); i2++) {
            char charAt = lowerCase.charAt(i2);
            if (g.B(charAt)) {
                String[] strArr = g.wVN.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(" ");
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        if (z) {
                            str2 = strArr[i3].substring(0, 1);
                        } else {
                            str2 = strArr[i3];
                        }
                        if (!arrayList2.contains(str2)) {
                            arrayList2.add(str2);
                        }
                    }
                    arrayList.add(Util.listToString(arrayList2, "‏"));
                    z2 = true;
                }
            } else {
                arrayList.add(" ");
            }
        }
        if (z2) {
            String listToString = Util.listToString(arrayList, "‍");
            AppMethodBeat.o(131632);
            return listToString;
        }
        AppMethodBeat.o(131632);
        return null;
    }

    public static String J(String[] strArr) {
        AppMethodBeat.i(131633);
        StringBuilder sb = new StringBuilder(256);
        sb.append('(');
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(DatabaseUtils.sqlEscapeString(strArr[i2]) + ',');
        }
        sb.setCharAt(sb.length() - 1, ')');
        String sb2 = sb.toString();
        AppMethodBeat.o(131633);
        return sb2;
    }

    public static boolean k(int[] iArr, int i2) {
        AppMethodBeat.i(131634);
        if (Arrays.binarySearch(iArr, i2) >= 0) {
            AppMethodBeat.o(131634);
            return true;
        }
        AppMethodBeat.o(131634);
        return false;
    }

    public static boolean ays(String str) {
        AppMethodBeat.i(131635);
        if (str == null) {
            AppMethodBeat.o(131635);
            return false;
        } else if (str.length() >= 20 || !str.matches("^[0-9]+$")) {
            AppMethodBeat.o(131635);
            return false;
        } else {
            AppMethodBeat.o(131635);
            return true;
        }
    }

    public static boolean ayt(String str) {
        AppMethodBeat.i(131636);
        if (str == null) {
            AppMethodBeat.o(131636);
            return false;
        } else if (str.length() >= 20 || !str.matches("^[A-Za-z][A-Za-z0-9\\-_]+$")) {
            AppMethodBeat.o(131636);
            return false;
        } else {
            AppMethodBeat.o(131636);
            return true;
        }
    }

    public static boolean f(int i2, int[] iArr) {
        for (int i3 : iArr) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameDay(long j2, long j3) {
        AppMethodBeat.i(131637);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.setTimeInMillis(j3);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        if (timeInMillis == instance.getTimeInMillis()) {
            AppMethodBeat.o(131637);
            return true;
        }
        AppMethodBeat.o(131637);
        return false;
    }

    public static String arL(String str) {
        AppMethodBeat.i(131638);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(131638);
            return str;
        } else if (!Util.isNullOrNil(Kn.field_conRemark)) {
            String str2 = Kn.field_conRemark;
            AppMethodBeat.o(131638);
            return str2;
        } else if (!Util.isNullOrNil(Kn.field_nickname)) {
            String arI = Kn.arI();
            AppMethodBeat.o(131638);
            return arI;
        } else {
            if (ab.Iw(Kn.field_username)) {
                String displayName = ((c) g.af(c.class)).aSX().getDisplayName(str);
                if (!Util.isNullOrNil(displayName)) {
                    AppMethodBeat.o(131638);
                    return displayName;
                }
            }
            String str3 = Kn.field_username;
            AppMethodBeat.o(131638);
            return str3;
        }
    }

    public static void d(Context context, String str, Intent intent) {
        AppMethodBeat.i(131639);
        try {
            String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.fts";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(MMApplicationContext.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(131639);
                return;
            }
            intent.addFlags(268435456);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(131639);
        } catch (Exception e2) {
            Log.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", e2);
            AppMethodBeat.o(131639);
        }
    }

    public static void b(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.i(131640);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e2) {
                Log.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", e2);
                AppMethodBeat.o(131640);
                return;
            }
        }
        String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.fts";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(MMApplicationContext.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            AppMethodBeat.o(131640);
            return;
        }
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        context.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(131640);
    }

    public static long Ni(int i2) {
        AppMethodBeat.i(131641);
        StringBuilder append = new StringBuilder().append(System.currentTimeMillis()).append("_");
        g.aAf();
        long ayu = ayu(append.append(com.tencent.mm.kernel.a.ayV()).append("_").append(i2).toString());
        AppMethodBeat.o(131641);
        return ayu;
    }

    public static String Nj(int i2) {
        AppMethodBeat.i(206890);
        StringBuilder append = new StringBuilder().append(System.currentTimeMillis()).append("_");
        g.aAf();
        String GD = e.GD(ayu(append.append(com.tencent.mm.kernel.a.ayV()).append("_").append(i2).toString()));
        AppMethodBeat.o(206890);
        return GD;
    }

    private static long ayu(String str) {
        AppMethodBeat.i(131642);
        try {
            char[] charArray = "0123456789ABCDEF".toCharArray();
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            char[] cArr = new char[(digest.length * 2)];
            for (int i2 = 0; i2 < digest.length; i2++) {
                int i3 = digest[i2] & 255;
                cArr[i2 * 2] = charArray[i3 >>> 4];
                cArr[(i2 * 2) + 1] = charArray[i3 & 15];
            }
            long longValue = new BigInteger(new String(cArr), 16).longValue();
            AppMethodBeat.o(131642);
            return longValue;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.FTSApiLogic", e2, "getMd5UInt", new Object[0]);
            AppMethodBeat.o(131642);
            return 0;
        }
    }
}
