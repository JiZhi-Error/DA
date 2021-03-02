package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.g;
import com.tencent.mm.ce.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.lang.ref.WeakReference;

public final class h {
    private static WeakReference<TextPaint> goY;
    private static int goZ = 0;
    private static int gpa = 0;
    public String goX = "";
    public String mDesc = "";
    public String mTitle = "";

    public static boolean b(String str, ca caVar) {
        AppMethodBeat.i(20070);
        if (caVar == null || caVar.field_bizChatId == -1 || !g.DQ(str)) {
            AppMethodBeat.o(20070);
            return false;
        }
        AppMethodBeat.o(20070);
        return true;
    }

    public static String a(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(20071);
        String bfh = l.bfh(b.gxI().bib(a(0, str2, str, i2, context)));
        AppMethodBeat.o(20071);
        return bfh;
    }

    public static String f(Context context, String str, String str2) {
        String displayName;
        AppMethodBeat.i(20072);
        if (ab.Eq(str)) {
            String Ks = bp.Ks(str2);
            if (Ks != null) {
                displayName = aa.getDisplayName(Ks.trim());
            } else {
                displayName = aa.getDisplayName(str);
            }
        } else {
            displayName = aa.getDisplayName(str);
        }
        if (str.contains("@bottle")) {
            String quantityString = context.getResources().getQuantityString(R.plurals.x, 1, 1);
            AppMethodBeat.o(20072);
            return quantityString;
        }
        if (Util.isNullOrNil(displayName) && ab.Eq(str)) {
            displayName = context.getString(R.string.b25);
        }
        String bib = b.gxI().bib(displayName);
        AppMethodBeat.o(20072);
        return bib;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0100, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0) != false) goto L_0x0102;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7, java.lang.String r8, java.lang.String r9, int r10, com.tencent.mm.storage.ca r11) {
        /*
        // Method dump skipped, instructions count: 355
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.h.a(android.content.Context, java.lang.String, java.lang.String, int, com.tencent.mm.storage.ca):java.lang.String");
    }

    public static String b(ca caVar, PString pString, PString pString2, PInt pInt, boolean z) {
        String str;
        String a2;
        AppMethodBeat.i(20074);
        if (caVar.gDk()) {
            str = caVar.gDW();
        } else {
            str = caVar.field_content;
        }
        if (caVar.gAt()) {
            a2 = l.bfh(a(caVar.field_imgPath, caVar.field_isSend, caVar.field_talker, str, caVar.getType(), MMApplicationContext.getContext(), pString, pString2, pInt, true, z, caVar.fQZ, caVar.fRf));
        } else {
            a2 = a(caVar.field_imgPath, caVar.field_isSend, caVar.field_talker, l.bfh(str), caVar.getType(), MMApplicationContext.getContext(), pString, pString2, pInt, true, z, caVar.fQZ, caVar.fRf);
        }
        String nullAsNil = Util.nullAsNil(a2);
        AppMethodBeat.o(20074);
        return nullAsNil;
    }

    public static String a(int i2, String str, String str2, int i3, Context context) {
        AppMethodBeat.i(20075);
        String nullAsNil = Util.nullAsNil(a(null, i2, str, str2, i3, context, new PString(), new PString(), new PInt(), false, false, "", 0));
        AppMethodBeat.o(20075);
        return nullAsNil;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x04a8, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x04aa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:949:0x1e47  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, int r22, android.content.Context r23, com.tencent.mm.pointers.PString r24, com.tencent.mm.pointers.PString r25, com.tencent.mm.pointers.PInt r26, boolean r27, boolean r28, java.lang.String r29, int r30) {
        /*
        // Method dump skipped, instructions count: 8788
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.h.a(java.lang.String, int, java.lang.String, java.lang.String, int, android.content.Context, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PInt, boolean, boolean, java.lang.String, int):java.lang.String");
    }

    private static String a(Context context, int i2, String str, String str2, String str3, PString pString, PString pString2) {
        int indexOf;
        int i3 = R.string.dfz;
        AppMethodBeat.i(20077);
        String str4 = "";
        if (ab.IY(str) || ab.Ja(str)) {
            if (str2 != null && (indexOf = str2.indexOf(":")) >= 0 && indexOf < str2.length()) {
                String substring = str2.substring(0, indexOf);
                if (as.bjm(substring) || as.bjo(substring)) {
                    str4 = aa.getDisplayName(substring);
                    pString2.value = substring;
                    str2 = str2.substring(indexOf + 1);
                }
            }
        } else if (as.bjm(str) || as.bjo(str)) {
            aa.getDisplayName(str);
            pString2.value = str;
            if (i2 == 1) {
                StringBuilder append = new StringBuilder().append(context.getString(R.string.dfz, ""));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = "";
                String str5 = pString.value;
                AppMethodBeat.o(20077);
                return str5;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = "";
            String str6 = pString.value;
            AppMethodBeat.o(20077);
            return str6;
        }
        if (Util.nullAsNil(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            String str7 = pString.value;
            AppMethodBeat.o(20077);
            return str7;
        }
        pString.value = context.getString(i2 == 1 ? R.string.dfz : R.string.dg9) + (str3 == null ? str2 : str3);
        StringBuilder sb = new StringBuilder();
        if (i2 != 1) {
            i3 = R.string.dg9;
        }
        StringBuilder append2 = sb.append(context.getString(i3, str4));
        if (str3 != null) {
            str2 = str3;
        }
        String sb2 = append2.append(str2).toString();
        AppMethodBeat.o(20077);
        return sb2;
    }

    private static String cp(Context context) {
        AppMethodBeat.i(20078);
        boolean aUy = z.aUy();
        bg.aVF();
        long nullAs = Util.nullAs((Long) c.azQ().get(65793, (Object) null), 0);
        if (!aUy) {
            String string = context.getString(R.string.gso);
            AppMethodBeat.o(20078);
            return string;
        } else if (nullAs == 0) {
            String string2 = context.getString(R.string.dfx);
            AppMethodBeat.o(20078);
            return string2;
        } else if (Util.secondsToNow(nullAs) * 1000 > 1209600000) {
            String string3 = context.getString(R.string.dfw, Long.valueOf((Util.secondsToNow(nullAs) * 1000) / Util.MILLSECONDS_OF_DAY));
            AppMethodBeat.o(20078);
            return string3;
        } else {
            AppMethodBeat.o(20078);
            return "";
        }
    }

    private static String Dg(String str) {
        AppMethodBeat.i(20079);
        if (str != null) {
            String replaceAll = str.replaceAll("%", "%%");
            AppMethodBeat.o(20079);
            return replaceAll;
        }
        AppMethodBeat.o(20079);
        return str;
    }

    private static String f(String str, String str2, String str3) {
        AppMethodBeat.i(20080);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            AppMethodBeat.o(20080);
            return str;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            AppMethodBeat.o(20080);
            return str;
        }
        String str4 = str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length());
        AppMethodBeat.o(20080);
        return str4;
    }

    private static boolean a(int i2, PString pString, String str) {
        AppMethodBeat.i(20081);
        if (pString.value.length() == 32 && (i2 == 47 || i2 == 1048625)) {
            pString.value = str;
            AppMethodBeat.o(20081);
            return true;
        }
        AppMethodBeat.o(20081);
        return false;
    }

    private static String Dh(String str) {
        AppMethodBeat.i(20082);
        if (str != null) {
            String replaceAll = str.replaceAll("%%", "%");
            AppMethodBeat.o(20082);
            return replaceAll;
        }
        AppMethodBeat.o(20082);
        return str;
    }

    private static boolean Di(String str) {
        AppMethodBeat.i(20083);
        if (ab.IY(str) && !z.aUv()) {
            AppMethodBeat.o(20083);
            return true;
        } else if (ab.Ja(str) && !z.aUm()) {
            AppMethodBeat.o(20083);
            return true;
        } else if (!ab.Je(str) || z.aUy()) {
            AppMethodBeat.o(20083);
            return false;
        } else {
            AppMethodBeat.o(20083);
            return true;
        }
    }

    public static String Dj(String str) {
        AppMethodBeat.i(20084);
        if (str == null) {
            AppMethodBeat.o(20084);
            return "";
        } else if (str.length() < 150) {
            AppMethodBeat.o(20084);
            return str;
        } else {
            String str2 = str.substring(0, 150) + "...";
            AppMethodBeat.o(20084);
            return str2;
        }
    }

    private static void a(int i2, PString pString, PString pString2, PInt pInt) {
        String str;
        AppMethodBeat.i(20085);
        if (pString.value.length() == 32 && (i2 == 47 || i2 == 1048625)) {
            AppMethodBeat.o(20085);
            return;
        }
        if (pString.value.length() >= 150) {
            pString.value = pString.value.substring(0, G(pString.value, 150));
        }
        TextPaint textPaint = getTextPaint();
        if (pString.value.replace("%%", "").contains("%s") || textPaint == null) {
            pInt.value = 0;
            AppMethodBeat.o(20085);
            return;
        }
        try {
            str = String.format(pString.value, pString2.value);
        } catch (Exception e2) {
            str = pString.value;
        }
        pString.value = a(str, textPaint).toString();
        pInt.value = 1;
        AppMethodBeat.o(20085);
    }

    private static CharSequence a(String str, TextPaint textPaint) {
        AppMethodBeat.i(20086);
        CharSequence ellipsize = TextUtils.ellipsize(l.e(MMApplicationContext.getContext(), (CharSequence) str, alx()), textPaint, (float) aly(), TextUtils.TruncateAt.END);
        AppMethodBeat.o(20086);
        return ellipsize;
    }

    private static int alx() {
        AppMethodBeat.i(169682);
        if (gpa > 0) {
            int i2 = gpa;
            AppMethodBeat.o(169682);
            return i2;
        }
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 14.0f);
        AppMethodBeat.o(169682);
        return fromDPToPix;
    }

    private static int aly() {
        AppMethodBeat.i(20087);
        if (goZ > 0) {
            int i2 = goZ;
            AppMethodBeat.o(20087);
            return i2;
        }
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 200.0f);
        AppMethodBeat.o(20087);
        return fromDPToPix;
    }

    private static int G(String str, int i2) {
        AppMethodBeat.i(20088);
        while (i2 < str.length()) {
            if (str.charAt(i2) != '%') {
                AppMethodBeat.o(20088);
                return i2;
            }
            i2++;
        }
        int length = str.length();
        AppMethodBeat.o(20088);
        return length;
    }

    private static TextPaint getTextPaint() {
        AppMethodBeat.i(20089);
        if (goY == null) {
            AppMethodBeat.o(20089);
            return null;
        }
        TextPaint textPaint = goY.get();
        AppMethodBeat.o(20089);
        return textPaint;
    }

    public static void oc(int i2) {
        goZ = i2;
    }

    public static void od(int i2) {
        gpa = i2;
    }

    public static void b(TextPaint textPaint) {
        AppMethodBeat.i(20090);
        if (goY == null || goY.get() == null) {
            goY = new WeakReference<>(textPaint);
        }
        AppMethodBeat.o(20090);
    }

    public static String d(Context context, String str, boolean z) {
        AppMethodBeat.i(20091);
        String bib = b.gxI().bib(str);
        if (z) {
            AppMethodBeat.o(20091);
            return bib;
        }
        String string = context.getString(R.string.e3s);
        AppMethodBeat.o(20091);
        return string;
    }

    public static String a(Context context, String str, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(20092);
        if (z) {
            String bib = b.gxI().bib(str);
            if (i4 > 1) {
                bib = context.getResources().getQuantityString(R.plurals.y, i4, Integer.valueOf(i4)) + bib;
            }
            AppMethodBeat.o(20092);
            return bib;
        }
        String quantityString = context.getResources().getQuantityString(R.plurals.z, i2, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(20092);
        return quantityString;
    }

    public static String e(Context context, String str, boolean z) {
        AppMethodBeat.i(20093);
        if (z) {
            String bib = b.gxI().bib(str);
            AppMethodBeat.o(20093);
            return bib;
        }
        String string = context.getString(R.string.fgc);
        AppMethodBeat.o(20093);
        return string;
    }
}
