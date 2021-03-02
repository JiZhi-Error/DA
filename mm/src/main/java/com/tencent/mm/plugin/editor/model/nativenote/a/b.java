package com.tencent.mm.plugin.editor.model.nativenote.a;

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
import com.tencent.mm.plugin.editor.model.nativenote.manager.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import com.tencent.mm.plugin.editor.model.nativenote.manager.i;
import com.tencent.mm.plugin.editor.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.editor.model.nativenote.spans.a;
import com.tencent.mm.plugin.editor.model.nativenote.spans.d;
import com.tencent.mm.plugin.editor.model.nativenote.spans.k;
import com.tencent.mm.plugin.editor.model.nativenote.spans.l;
import com.tencent.mm.plugin.editor.model.nativenote.spans.o;
import com.tencent.mm.plugin.editor.model.nativenote.spans.p;
import com.tencent.mm.plugin.editor.model.nativenote.spans.s;
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
        AppMethodBeat.i(181695);
        if (spanned == null || Util.isNullOrNil(spanned.toString())) {
            AppMethodBeat.o(181695);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        a(spanned, sb);
        String sb2 = sb.toString();
        AppMethodBeat.o(181695);
        return sb2;
    }

    private static void a(final Spanned spanned, StringBuilder sb) {
        String str;
        int i2;
        boolean z;
        AppMethodBeat.i(181696);
        ArrayList<l> arrayList = new i(spanned).qRJ;
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            l lVar = arrayList.get(i3);
            Set<p> a2 = a(spanned, lVar);
            o oVar = null;
            Iterator<p> it = a2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.qSY.qTu) {
                    oVar = next.qSY;
                    break;
                }
            }
            int i4 = 0;
            o oVar2 = o.NONE;
            for (p pVar : a2) {
                if (pVar.qSY.cEw() || pVar.qSY.cEx() || pVar.qSY.cEy()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i4 += i2;
                o oVar3 = pVar.qSY;
                if (pVar.qSY.cEw()) {
                    z = ((d) pVar.qTA).qTe;
                } else if (pVar.qSY.cEx()) {
                    z = ((k) pVar.qTA).qTe;
                } else if (pVar.qSY.cEy()) {
                    z = ((s) pVar.qTA).qTe;
                } else {
                    z = true;
                }
                if (z) {
                    oVar2 = o.NONE;
                } else if (oVar3.cEw()) {
                    oVar2 = o.NOTEUL;
                } else if (oVar3.cEx()) {
                    oVar2 = o.NOTEOL;
                } else {
                    oVar2 = oVar3.cEy() ? o.NOTETODO : oVar2;
                }
            }
            a(stack, sb, new a(oVar2, i4, 0));
            if (oVar2.cEy()) {
                s[] sVarArr = (s[]) spanned.getSpans(lVar.avh, lVar.Pc, s.class);
                if (sVarArr.length > 0) {
                    oVar2.qTy = sVarArr[0].qTF;
                    int indexOf = oVar2.qTv.indexOf("\"") + 1;
                    int lastIndexOf = oVar2.qTv.lastIndexOf("\"");
                    if (indexOf < lastIndexOf) {
                        String substring = oVar2.qTv.substring(indexOf, lastIndexOf);
                        if (!Util.isNullOrNil(substring)) {
                            if (!substring.trim().equals(oVar2.qTy ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                String str2 = oVar2.qTv;
                                if (oVar2.qTy) {
                                    str = "1";
                                } else {
                                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                                oVar2.qTv = str2.replaceAll(substring, str);
                            }
                        }
                    }
                }
            }
            sb.append(oVar2.qTv);
            if (oVar != null) {
                sb.append(oVar.mStartTag);
            }
            int i5 = lVar.avh;
            int i6 = lVar.Pc;
            TreeSet treeSet = new TreeSet(new Comparator<CharacterStyle>() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.a.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
                    AppMethodBeat.i(181694);
                    CharacterStyle characterStyle3 = characterStyle;
                    CharacterStyle characterStyle4 = characterStyle2;
                    int spanStart = spanned.getSpanStart(characterStyle3);
                    int spanStart2 = spanned.getSpanStart(characterStyle4);
                    if (spanStart != spanStart2) {
                        int i2 = spanStart - spanStart2;
                        AppMethodBeat.o(181694);
                        return i2;
                    }
                    int spanEnd = spanned.getSpanEnd(characterStyle3);
                    int spanEnd2 = spanned.getSpanEnd(characterStyle4);
                    if (spanEnd != spanEnd2) {
                        int i3 = spanEnd2 - spanEnd;
                        AppMethodBeat.o(181694);
                        return i3;
                    }
                    int compareTo = characterStyle3.getClass().getName().compareTo(characterStyle4.getClass().getName());
                    AppMethodBeat.o(181694);
                    return compareTo;
                }
            });
            treeSet.addAll(Arrays.asList(spanned.getSpans(i5, i6, CharacterStyle.class)));
            a(spanned, sb, i5, i6, treeSet);
            if (oVar != null) {
                a(sb, oVar);
                sb.append(oVar.qTt);
            }
            a(sb, oVar2);
            sb.append(oVar2.qTw);
        }
        while (!stack.isEmpty()) {
            a(stack, sb);
        }
        AppMethodBeat.o(181696);
    }

    private static void a(Spanned spanned, StringBuilder sb, int i2, int i3, SortedSet<CharacterStyle> sortedSet) {
        AppMethodBeat.i(181697);
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
                    sb.append((float) f.FA((int) (((RelativeSizeSpan) first).getSizeChange() * f.getTextSize())));
                    sb.append("px\">");
                } else if (first instanceof AbsoluteSizeSpan) {
                    sb.append("<wx-font style=\"font-size:");
                    sb.append(f.FA(((AbsoluteSizeSpan) first).getSize()));
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
        AppMethodBeat.o(181697);
    }

    public static void a(CharSequence charSequence, StringBuilder sb, int i2, int i3) {
        AppMethodBeat.i(181698);
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
        AppMethodBeat.o(181698);
    }

    private static Set<p> a(Spanned spanned, g gVar) {
        AppMethodBeat.i(181700);
        HashSet hashSet = new HashSet();
        ParagraphStyle[] paragraphStyleArr = (ParagraphStyle[]) spanned.getSpans(gVar.avh, gVar.Pc, ParagraphStyle.class);
        for (ParagraphStyle paragraphStyle : paragraphStyleArr) {
            o a2 = o.a(paragraphStyle);
            if (a2 != null) {
                hashSet.add(new p(a2, paragraphStyle));
            }
        }
        AppMethodBeat.o(181700);
        return hashSet;
    }

    private static void a(Stack<a> stack, StringBuilder sb, a aVar) {
        AppMethodBeat.i(181701);
        while (true) {
            int i2 = 0;
            o oVar = o.NONE;
            if (!stack.isEmpty()) {
                a peek = stack.peek();
                i2 = peek.qSZ;
                oVar = peek.qSY;
            }
            if (aVar.qSZ > i2) {
                aVar.qTa = aVar.qSZ - i2;
                b(stack, sb, aVar);
                AppMethodBeat.o(181701);
                return;
            } else if (aVar.qSZ < i2) {
                a(stack, sb);
            } else {
                if (aVar.qSY != oVar) {
                    aVar.qTa = a(stack, sb);
                    b(stack, sb, aVar);
                }
                AppMethodBeat.o(181701);
                return;
            }
        }
    }

    private static int a(Stack<a> stack, StringBuilder sb) {
        AppMethodBeat.i(181702);
        if (!stack.isEmpty()) {
            a pop = stack.pop();
            String str = pop.qSY.qTt;
            int i2 = pop.qTa;
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(str);
            }
            int i4 = pop.qTa;
            AppMethodBeat.o(181702);
            return i4;
        }
        AppMethodBeat.o(181702);
        return 0;
    }

    private static void a(StringBuilder sb, o oVar) {
        AppMethodBeat.i(181699);
        if (oVar.qTx && sb.length() >= 5) {
            int length = sb.length() - 5;
            int length2 = sb.length();
            if (sb.subSequence(length, length2).equals("<br/>")) {
                sb.delete(length, length2);
            }
        }
        AppMethodBeat.o(181699);
    }

    private static void b(Stack<a> stack, StringBuilder sb, a aVar) {
        AppMethodBeat.i(181703);
        String str = aVar.qSY.mStartTag;
        int i2 = aVar.qTa;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(str);
        }
        stack.push(aVar);
        AppMethodBeat.o(181703);
    }
}
