package com.tencent.mm.plugin.fts.a;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public static final com.tencent.mm.plugin.fts.a.a.f a(String str, String str2, e eVar) {
        AppMethodBeat.i(131652);
        com.tencent.mm.plugin.fts.a.a.f a2 = a(eVar);
        a2.wWu = TextUtils.concat(str, a2.wWu, str2);
        AppMethodBeat.o(131652);
        return a2;
    }

    public static final SpannableString a(String str, String str2, CharSequence charSequence) {
        AppMethodBeat.i(206893);
        SpannableString f2 = f(str + ((Object) charSequence) + str2, str.length(), str.length() + charSequence.length());
        AppMethodBeat.o(206893);
        return f2;
    }

    public static final SpannableString f(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(131653);
        SpannableString spannableString = new SpannableString(charSequence);
        e.b bVar = new e.b();
        bVar.wWs = i2;
        bVar.wWt = i3;
        b(spannableString, bVar, new e());
        AppMethodBeat.o(131653);
        return spannableString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v39. Raw type applied. Possible types: java.util.List<java.util.List<java.lang.String>> */
    /* JADX DEBUG: Type inference failed for r0v67. Raw type applied. Possible types: java.util.List<java.util.List<java.lang.String>> */
    public static final com.tencent.mm.plugin.fts.a.a.f a(e eVar) {
        List list;
        List list2;
        com.tencent.mm.plugin.fts.a.a.f fVar;
        AppMethodBeat.i(131654);
        com.tencent.mm.plugin.fts.a.a.f fVar2 = new com.tencent.mm.plugin.fts.a.a.f();
        SpannableString spannableString = new SpannableString(TextUtils.concat(eVar.wWj, eVar.wWc, eVar.wWk));
        fVar2.resultCode = -1;
        fVar2.wWu = spannableString;
        if (!(!Util.isNullOrNil(eVar.wWc) && eVar.wWd != null)) {
            AppMethodBeat.o(131654);
            return fVar2;
        }
        String ayq = d.ayq(eVar.wWc.toString());
        List arrayList = new ArrayList();
        if (eVar.wWe) {
            list = bC(ayq, eVar.wWf);
        } else {
            list = arrayList;
        }
        if (eVar.wWd.wWF.size() == 1 || a(spannableString, eVar)) {
            e.b bVar = new e.b();
            if (eVar.wWd.wWF.size() == 1) {
                bVar.wWr = eVar.wWd.wWF.get(0);
                if (eVar.wWe) {
                    a(list, bVar, eVar);
                } else {
                    a(ayq, bVar, eVar);
                }
                if (bVar.isAvailable()) {
                    try {
                        fVar = b(spannableString, bVar, eVar);
                    } catch (Exception e2) {
                        fVar2.wWu = spannableString;
                        fVar = fVar2;
                    }
                    AppMethodBeat.o(131654);
                    return fVar;
                }
                AppMethodBeat.o(131654);
                return fVar2;
            }
            bVar.wWr = eVar.wWd.wWF.get(0);
            if (eVar.wWe) {
                a(list, bVar, eVar);
            } else {
                a(ayq, bVar, eVar);
            }
            if (bVar.isAvailable()) {
                try {
                    fVar2 = b(spannableString, bVar, eVar);
                } catch (Exception e3) {
                    fVar2.wWu = spannableString;
                }
            }
            String charSequence = fVar2.wWu.toString();
            List arrayList2 = new ArrayList();
            if (eVar.wWe) {
                list2 = bC(charSequence, eVar.wWf);
            } else {
                list2 = arrayList2;
            }
            for (int i2 = 1; i2 < eVar.wWd.wWF.size(); i2++) {
                bVar.wWr = eVar.wWd.wWF.get(i2);
                if (eVar.wWe) {
                    a(list2, bVar, eVar);
                } else {
                    a(charSequence, bVar, eVar);
                }
                if (bVar.isAvailable()) {
                    try {
                        fVar2 = b((Spannable) fVar2.wWu, bVar, eVar);
                    } catch (Exception e4) {
                        fVar2.wWu = spannableString;
                    }
                }
            }
            AppMethodBeat.o(131654);
            return fVar2;
        }
        e.b bVar2 = new e.b();
        bVar2.wWr = new h.c();
        h.b bVar3 = new h.b();
        bVar3.wWH = h.d.OTHER;
        bVar3.content = eVar.wWd.wWC;
        bVar2.wWr.wWJ.add(bVar3);
        if (eVar.wWe) {
            a(list, bVar2, eVar);
        } else {
            a(ayq, bVar2, eVar);
        }
        if (bVar2.isAvailable()) {
            try {
                fVar2 = b(spannableString, bVar2, eVar);
            } catch (Exception e5) {
                fVar2.wWu = spannableString;
            }
            AppMethodBeat.o(131654);
            return fVar2;
        }
        ArrayList<e.b> arrayList3 = new ArrayList();
        for (h.c cVar : eVar.wWd.wWF) {
            e.b bVar4 = new e.b();
            bVar4.wWr = cVar;
            arrayList3.add(bVar4);
        }
        for (e.b bVar5 : arrayList3) {
            if (eVar.wWe) {
                a(list, bVar5, eVar);
            } else {
                a(ayq, bVar5, eVar);
            }
        }
        for (e.b bVar6 : arrayList3) {
            if (bVar6.isAvailable()) {
                com.tencent.mm.plugin.fts.a.a.f b2 = b(spannableString, bVar6, eVar);
                if (b2.resultCode == 0) {
                    fVar2 = b2;
                }
            }
        }
        AppMethodBeat.o(131654);
        return fVar2;
    }

    private static boolean a(Spannable spannable, e eVar) {
        AppMethodBeat.i(131655);
        if (eVar.wWi <= 0.0f || eVar.iW == null) {
            AppMethodBeat.o(131655);
            return false;
        } else if (eVar.wWi - (eVar.iW.getTextSize() * 2.0f) < eVar.iW.measureText(spannable.toString())) {
            AppMethodBeat.o(131655);
            return true;
        } else {
            AppMethodBeat.o(131655);
            return false;
        }
    }

    private static com.tencent.mm.plugin.fts.a.a.f a(Spannable spannable, e.b bVar, e eVar) {
        Object foregroundColorSpan;
        SpannableString spannableString;
        AppMethodBeat.i(131656);
        com.tencent.mm.plugin.fts.a.a.f fVar = new com.tencent.mm.plugin.fts.a.a.f();
        float textSize = eVar.wWi - (eVar.iW.getTextSize() * 2.0f);
        float measureText = eVar.iW.measureText("…");
        float measureText2 = eVar.iW.measureText(spannable, 0, bVar.wWs);
        float measureText3 = eVar.iW.measureText(spannable, bVar.wWs, bVar.wWt);
        float measureText4 = eVar.iW.measureText(spannable, bVar.wWt, spannable.length());
        if (measureText2 + measureText3 + measureText4 < textSize) {
            com.tencent.mm.plugin.fts.a.a.f c2 = c(spannable, bVar, eVar);
            AppMethodBeat.o(131656);
            return c2;
        }
        CharSequence subSequence = spannable.subSequence(bVar.wWs, bVar.wWt);
        if (eVar.wWg == e.a.CustomTag) {
            spannableString = new SpannableString(TextUtils.concat(eVar.wWl, subSequence, eVar.wWm));
        } else {
            if (eVar.wWg == e.a.Background) {
                foregroundColorSpan = new BackgroundColorSpan(eVar.wWh);
            } else {
                foregroundColorSpan = new ForegroundColorSpan(eVar.wWh);
            }
            SpannableString spannableString2 = new SpannableString(subSequence);
            try {
                spannableString2.setSpan(foregroundColorSpan, 0, spannableString2.length(), 33);
                spannableString = spannableString2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e2, "setSpan %s", bVar.toString());
                fVar.resultCode = -1;
                fVar.wWu = spannable;
                AppMethodBeat.o(131656);
                return fVar;
            }
        }
        if (measureText2 + measureText3 + measureText < textSize) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable, 0, bVar.wWs);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(bVar.wWt, spannable.length()), eVar.iW, (textSize - measureText2) - measureText3, TextUtils.TruncateAt.END));
            fVar.wWu = spannableStringBuilder;
        } else if (measureText + measureText3 + measureText4 < textSize) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append(TextUtils.ellipsize(spannable.subSequence(0, bVar.wWs), eVar.iW, (textSize - measureText3) - measureText4, TextUtils.TruncateAt.START));
            spannableStringBuilder2.append((CharSequence) spannableString);
            spannableStringBuilder2.append((CharSequence) spannable, bVar.wWt, spannable.length());
            fVar.wWu = spannableStringBuilder2;
        } else if (measureText + measureText3 + measureText >= textSize) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
            spannableStringBuilder3.append(TextUtils.ellipsize(spannableString, eVar.iW, textSize, TextUtils.TruncateAt.END));
            fVar.wWu = spannableStringBuilder3;
        } else {
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder();
            float f2 = (textSize - measureText3) / 2.0f;
            CharSequence subSequence2 = spannable.subSequence(0, bVar.wWs);
            CharSequence subSequence3 = spannable.subSequence(bVar.wWt, spannable.length());
            spannableStringBuilder4.append(TextUtils.ellipsize(subSequence2, eVar.iW, f2, TextUtils.TruncateAt.START));
            spannableStringBuilder4.append((CharSequence) spannableString);
            spannableStringBuilder4.append(TextUtils.ellipsize(subSequence3, eVar.iW, f2, TextUtils.TruncateAt.END));
            fVar.wWu = spannableStringBuilder4;
        }
        fVar.resultCode = 0;
        AppMethodBeat.o(131656);
        return fVar;
    }

    private static com.tencent.mm.plugin.fts.a.a.f b(Spannable spannable, e.b bVar, e eVar) {
        AppMethodBeat.i(131657);
        if (a(spannable, eVar)) {
            com.tencent.mm.plugin.fts.a.a.f a2 = a(spannable, bVar, eVar);
            AppMethodBeat.o(131657);
            return a2;
        }
        com.tencent.mm.plugin.fts.a.a.f c2 = c(spannable, bVar, eVar);
        AppMethodBeat.o(131657);
        return c2;
    }

    private static com.tencent.mm.plugin.fts.a.a.f c(Spannable spannable, e.b bVar, e eVar) {
        Object foregroundColorSpan;
        AppMethodBeat.i(131658);
        com.tencent.mm.plugin.fts.a.a.f fVar = new com.tencent.mm.plugin.fts.a.a.f();
        if (eVar.wWg == e.a.CustomTag) {
            String obj = spannable.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.substring(0, bVar.wWs));
            stringBuffer.append(eVar.wWl);
            stringBuffer.append(obj.substring(bVar.wWs, bVar.wWt));
            stringBuffer.append(eVar.wWm);
            if (bVar.wWt < obj.length()) {
                stringBuffer.append(obj.substring(bVar.wWt, obj.length()));
            }
            fVar.wWu = stringBuffer.toString();
            fVar.resultCode = 0;
        } else {
            if (eVar.wWg == e.a.Background) {
                foregroundColorSpan = new BackgroundColorSpan(eVar.wWh);
            } else {
                foregroundColorSpan = new ForegroundColorSpan(eVar.wWh);
            }
            try {
                spannable.setSpan(foregroundColorSpan, bVar.wWs, bVar.wWt, 33);
                fVar.wWu = spannable;
                fVar.resultCode = 0;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e2, "setSpan %s", bVar.toString());
                fVar.wWu = spannable;
                fVar.resultCode = -1;
            }
        }
        AppMethodBeat.o(131658);
        return fVar;
    }

    private static void a(String str, e.b bVar, e eVar) {
        AppMethodBeat.i(131659);
        String keyword = bVar.getKeyword();
        if (Util.isNullOrNil(keyword)) {
            AppMethodBeat.o(131659);
            return;
        }
        int indexOf = str.indexOf(keyword);
        if (indexOf >= 0) {
            bVar.wWs = indexOf;
            bVar.wWt = keyword.length() + indexOf;
        }
        if (bVar.isAvailable() && eVar.wWj != null) {
            bVar.wWs += eVar.wWj.length();
            bVar.wWt += eVar.wWj.length();
        }
        AppMethodBeat.o(131659);
    }

    private static void a(List<List<String>> list, e.b bVar, e eVar) {
        int o;
        h.b bVar2;
        AppMethodBeat.i(131660);
        if (!eVar.wWf) {
            Iterator<h.b> it = bVar.wWr.wWJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h.b next = it.next();
                if (next.wWH == h.d.FullPY && (o = o(list, next.wWI)) >= 0) {
                    bVar.wWs = o;
                    bVar.wWt = next.wWI.size() + o;
                    break;
                }
            }
        } else {
            Iterator<h.b> it2 = bVar.wWr.wWJ.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it2.next();
                if (bVar2.wWH == h.d.ShortPY) {
                    break;
                }
            }
            if (bVar2 == null) {
                AppMethodBeat.o(131660);
                return;
            }
            int o2 = o(list, bVar2.wWI);
            if (o2 >= 0) {
                bVar.wWs = o2;
                bVar.wWt = bVar2.wWI.size() + o2;
            }
        }
        if (bVar.isAvailable() && eVar.wWj != null) {
            bVar.wWs += eVar.wWj.length();
            bVar.wWt += eVar.wWj.length();
        }
        AppMethodBeat.o(131660);
    }

    private static int o(List<List<String>> list, List<String> list2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(131661);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= (list.size() - list2.size()) + 1) {
                i2 = -1;
                break;
            }
            while (true) {
                if (i3 >= list2.size()) {
                    z = true;
                    i3 = i3;
                    break;
                }
                List<String> list3 = list.get(i2 + i3);
                String str = list2.get(i3);
                if (!list3.contains(str)) {
                    if (i3 != list2.size() - 1) {
                        z = false;
                        i3 = 0;
                        break;
                    }
                    Iterator<String> it = list3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().startsWith(str)) {
                                z2 = true;
                                break;
                            }
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (!z2) {
                        z = false;
                        i3 = 0;
                        break;
                    }
                    i3++;
                } else {
                    i3++;
                }
            }
            if (z) {
                break;
            }
            i2++;
        }
        AppMethodBeat.o(131661);
        return i2;
    }

    private static List<List<String>> bC(String str, boolean z) {
        AppMethodBeat.i(131662);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            ArrayList arrayList2 = new ArrayList(2);
            if (g.B(charAt)) {
                String[] strArr = g.wVN.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(arrayList2);
                } else {
                    int length = strArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        String str2 = strArr[i3];
                        if (z) {
                            str2 = str2.substring(0, 1);
                        }
                        if (!arrayList2.contains(str2)) {
                            arrayList2.add(str2);
                        }
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                arrayList.add(arrayList2);
            }
        }
        AppMethodBeat.o(131662);
        return arrayList;
    }

    public static CharSequence ayv(String str) {
        AppMethodBeat.i(131664);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(131664);
            return "";
        }
        Spanned fromHtml = Html.fromHtml(str.replaceAll("<em class=\"highlight\">", "<font color=\"#06AD56\">").replaceAll("</em>", "</font>"));
        AppMethodBeat.o(131664);
        return fromHtml;
    }

    @Deprecated
    public static Spannable b(CharSequence charSequence, String str) {
        AppMethodBeat.i(131663);
        com.tencent.mm.plugin.fts.a.a.f a2 = a(e.c(charSequence, str));
        if (a2.wWu instanceof Spannable) {
            Spannable spannable = (Spannable) a2.wWu;
            AppMethodBeat.o(131663);
            return spannable;
        }
        SpannableString spannableString = new SpannableString(a2.wWu);
        AppMethodBeat.o(131663);
        return spannableString;
    }
}
