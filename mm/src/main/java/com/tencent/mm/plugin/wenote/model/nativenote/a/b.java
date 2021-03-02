package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public final class b {
    public static String a(Spanned spanned) {
        AppMethodBeat.i(30383);
        if (spanned == null || Util.isNullOrNil(spanned.toString())) {
            AppMethodBeat.o(30383);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        a(spanned, sb);
        String sb2 = sb.toString();
        AppMethodBeat.o(30383);
        return sb2;
    }

    private static void a(final Spanned spanned, StringBuilder sb) {
        String str;
        int i2;
        boolean z;
        AppMethodBeat.i(30384);
        ArrayList<n> arrayList = new j(spanned).qRJ;
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = arrayList.get(i3);
            Set<r> a2 = a(spanned, nVar);
            q qVar = null;
            Iterator<r> it = a2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r next = it.next();
                if (next.JIU.qTu) {
                    qVar = next.JIU;
                    break;
                }
            }
            int i4 = 0;
            q qVar2 = q.NONE;
            for (r rVar : a2) {
                if (rVar.JIU.cEw() || rVar.JIU.cEx() || rVar.JIU.cEy()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i4 += i2;
                q qVar3 = rVar.JIU;
                if (rVar.JIU.cEw()) {
                    z = ((d) rVar.qTA).qTe;
                } else if (rVar.JIU.cEx()) {
                    z = ((m) rVar.qTA).qTe;
                } else if (rVar.JIU.cEy()) {
                    z = ((k) rVar.qTA).qTe;
                } else {
                    z = true;
                }
                if (z) {
                    qVar2 = q.NONE;
                } else if (qVar3.cEw()) {
                    qVar2 = q.NOTEUL;
                } else if (qVar3.cEx()) {
                    qVar2 = q.NOTEOL;
                } else {
                    qVar2 = qVar3.cEy() ? q.NOTETODO : qVar2;
                }
            }
            a(stack, sb, new a(qVar2, i4, 0));
            if (qVar2.cEy()) {
                k[] kVarArr = (k[]) spanned.getSpans(nVar.avh, nVar.Pc, k.class);
                if (kVarArr.length > 0) {
                    qVar2.qTy = kVarArr[0].qTF;
                    int indexOf = qVar2.qTv.indexOf("\"") + 1;
                    int lastIndexOf = qVar2.qTv.lastIndexOf("\"");
                    if (indexOf < lastIndexOf) {
                        String substring = qVar2.qTv.substring(indexOf, lastIndexOf);
                        if (!Util.isNullOrNil(substring)) {
                            if (!substring.trim().equals(qVar2.qTy ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                String str2 = qVar2.qTv;
                                if (qVar2.qTy) {
                                    str = "1";
                                } else {
                                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                                qVar2.qTv = str2.replaceAll(substring, str);
                            }
                        }
                    }
                }
            }
            sb.append(qVar2.qTv);
            if (qVar != null) {
                sb.append(qVar.mStartTag);
            }
            int i5 = nVar.avh;
            int i6 = nVar.Pc;
            TreeSet treeSet = new TreeSet(new Comparator<CharacterStyle>() {
                /* class com.tencent.mm.plugin.wenote.model.nativenote.a.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
                    AppMethodBeat.i(30382);
                    CharacterStyle characterStyle3 = characterStyle;
                    CharacterStyle characterStyle4 = characterStyle2;
                    int spanStart = spanned.getSpanStart(characterStyle3);
                    int spanStart2 = spanned.getSpanStart(characterStyle4);
                    if (spanStart != spanStart2) {
                        int i2 = spanStart - spanStart2;
                        AppMethodBeat.o(30382);
                        return i2;
                    }
                    int spanEnd = spanned.getSpanEnd(characterStyle3);
                    int spanEnd2 = spanned.getSpanEnd(characterStyle4);
                    if (spanEnd != spanEnd2) {
                        int i3 = spanEnd2 - spanEnd;
                        AppMethodBeat.o(30382);
                        return i3;
                    }
                    int compareTo = characterStyle3.getClass().getName().compareTo(characterStyle4.getClass().getName());
                    AppMethodBeat.o(30382);
                    return compareTo;
                }
            });
            treeSet.addAll(Arrays.asList(spanned.getSpans(i5, i6, CharacterStyle.class)));
            a(spanned, sb, i5, i6, treeSet);
            if (qVar != null) {
                a(sb, qVar);
                sb.append(qVar.qTt);
            }
            a(sb, qVar2);
            sb.append(qVar2.qTw);
        }
        while (!stack.isEmpty()) {
            a(stack, sb);
        }
        AppMethodBeat.o(30384);
    }

    private static void a(Spanned spanned, StringBuilder sb, int i2, int i3, SortedSet<CharacterStyle> sortedSet) {
        AppMethodBeat.i(30385);
        while (i2 < i3) {
            CharacterStyle first = sortedSet.isEmpty() ? null : sortedSet.first();
            int spanStart = first == null ? Integer.MAX_VALUE : spanned.getSpanStart(first);
            int spanEnd = first == null ? Integer.MAX_VALUE : spanned.getSpanEnd(first);
            if (i2 < spanStart) {
                a(spanned, sb, i2, Math.min(i3, spanStart));
                i2 = spanStart;
            } else {
                sortedSet.remove(first);
                if (first instanceof BoldSpan) {
                    sb.append("<wx-b>");
                } else if ((first instanceof StyleSpan) && ((StyleSpan) first).getStyle() == 1) {
                    sb.append("<wx-b>");
                } else if ((first instanceof StyleSpan) && ((StyleSpan) first).getStyle() == 2) {
                    sb.append("<i>");
                } else if (first instanceof UnderlineSpan) {
                    sb.append("<u>");
                } else if (first instanceof RelativeSizeSpan) {
                    sb.append("<wx-font style=\"font-size:");
                    sb.append((float) com.tencent.mm.plugin.wenote.model.nativenote.manager.b.FA((int) (((RelativeSizeSpan) first).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
                    sb.append("px\">");
                } else if (first instanceof AbsoluteSizeSpan) {
                    sb.append("<wx-font style=\"font-size:");
                    sb.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.FA(((AbsoluteSizeSpan) first).getSize()));
                    sb.append("px\">");
                } else if (first instanceof ForegroundColorSpan) {
                    sb.append("<wx-font style=\"color:#");
                    String hexString = Integer.toHexString(((ForegroundColorSpan) first).getForegroundColor() + TPMediaCodecProfileLevel.HEVCMainTierLevel62);
                    while (hexString.length() < 6) {
                        hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
                    }
                    sb.append(hexString);
                    sb.append("\">");
                } else if (first instanceof BackgroundColorSpan) {
                    sb.append("<wx-font style=\"background-color:#");
                    String hexString2 = Integer.toHexString(((BackgroundColorSpan) first).getBackgroundColor() + TPMediaCodecProfileLevel.HEVCMainTierLevel62);
                    while (hexString2.length() < 6) {
                        hexString2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString2));
                    }
                    sb.append(hexString2);
                    sb.append("\">");
                }
                a(spanned, sb, Math.max(spanStart, i2), Math.min(spanEnd, i3), sortedSet);
                if (first instanceof ForegroundColorSpan) {
                    sb.append("</wx-font>");
                } else if (first instanceof BackgroundColorSpan) {
                    sb.append("</wx-font>");
                } else if (first instanceof AbsoluteSizeSpan) {
                    sb.append("</wx-font>");
                } else if (first instanceof UnderlineSpan) {
                    sb.append("</u>");
                } else if (first instanceof BoldSpan) {
                    sb.append("</wx-b>");
                } else if ((first instanceof StyleSpan) && ((StyleSpan) first).getStyle() == 2) {
                    sb.append("</i>");
                } else if ((first instanceof StyleSpan) && ((StyleSpan) first).getStyle() == 1) {
                    sb.append("</wx-b>");
                } else if (first instanceof RelativeSizeSpan) {
                    sb.append("</wx-font>");
                }
                i2 = spanEnd;
            }
        }
        AppMethodBeat.o(30385);
    }

    public static void a(CharSequence charSequence, StringBuilder sb, int i2, int i3) {
        AppMethodBeat.i(30386);
        int i4 = i2;
        while (i4 < i3) {
            char charAt = charSequence.charAt(i4);
            if (charAt == '\n') {
                sb.append("<br/>");
            } else if (charAt == '<') {
                sb.append("&lt;");
            } else if (charAt == '>') {
                sb.append("&gt;");
            } else if (charAt == '&') {
                sb.append("&amp;");
            } else if (charAt == ' ') {
                while (i4 + 1 < i3 && charSequence.charAt(i4 + 1) == ' ') {
                    sb.append("&nbsp;");
                    i4++;
                }
                sb.append(' ');
            } else if (charAt < ' ') {
                sb.append("&#" + ((int) charAt) + ";");
            } else {
                sb.append(charAt);
            }
            i4++;
        }
        AppMethodBeat.o(30386);
    }

    private static Set<r> a(Spanned spanned, e eVar) {
        AppMethodBeat.i(30388);
        HashSet hashSet = new HashSet();
        ParagraphStyle[] paragraphStyleArr = (ParagraphStyle[]) spanned.getSpans(eVar.avh, eVar.Pc, ParagraphStyle.class);
        for (ParagraphStyle paragraphStyle : paragraphStyleArr) {
            q b2 = q.b(paragraphStyle);
            if (b2 != null) {
                hashSet.add(new r(b2, paragraphStyle));
            }
        }
        AppMethodBeat.o(30388);
        return hashSet;
    }

    private static void a(Stack<a> stack, StringBuilder sb, a aVar) {
        AppMethodBeat.i(30389);
        while (true) {
            int i2 = 0;
            q qVar = q.NONE;
            if (!stack.isEmpty()) {
                a peek = stack.peek();
                i2 = peek.qSZ;
                qVar = peek.JIU;
            }
            if (aVar.qSZ > i2) {
                aVar.qTa = aVar.qSZ - i2;
                b(stack, sb, aVar);
                AppMethodBeat.o(30389);
                return;
            } else if (aVar.qSZ < i2) {
                a(stack, sb);
            } else {
                if (aVar.JIU != qVar) {
                    aVar.qTa = a(stack, sb);
                    b(stack, sb, aVar);
                }
                AppMethodBeat.o(30389);
                return;
            }
        }
    }

    private static int a(Stack<a> stack, StringBuilder sb) {
        AppMethodBeat.i(30390);
        if (!stack.isEmpty()) {
            a pop = stack.pop();
            String str = pop.JIU.qTt;
            int i2 = pop.qTa;
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(str);
            }
            int i4 = pop.qTa;
            AppMethodBeat.o(30390);
            return i4;
        }
        AppMethodBeat.o(30390);
        return 0;
    }

    private static void a(StringBuilder sb, q qVar) {
        AppMethodBeat.i(30387);
        if (qVar.qTx && sb.length() >= 5) {
            int length = sb.length() - 5;
            int length2 = sb.length();
            if (sb.subSequence(length, length2).equals("<br/>")) {
                sb.delete(length, length2);
            }
        }
        AppMethodBeat.o(30387);
    }

    private static void b(Stack<a> stack, StringBuilder sb, a aVar) {
        AppMethodBeat.i(30391);
        String str = aVar.JIU.mStartTag;
        int i2 = aVar.qTa;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(str);
        }
        stack.push(aVar);
        AppMethodBeat.o(30391);
    }
}
