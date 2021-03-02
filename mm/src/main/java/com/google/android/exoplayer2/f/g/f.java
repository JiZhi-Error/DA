package com.google.android.exoplayer2.f.g;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.g.e;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
public final class f {
    public static final Pattern bDF = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern bDG = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder bCG = new StringBuilder();

    static {
        AppMethodBeat.i(92907);
        AppMethodBeat.o(92907);
    }

    public f() {
        AppMethodBeat.i(92899);
        AppMethodBeat.o(92899);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(m mVar, e.a aVar, List<d> list) {
        AppMethodBeat.i(92900);
        String readLine = mVar.readLine();
        if (readLine == null) {
            AppMethodBeat.o(92900);
            return false;
        }
        Matcher matcher = bDF.matcher(readLine);
        if (matcher.matches()) {
            boolean a2 = a(null, matcher, mVar, aVar, this.bCG, list);
            AppMethodBeat.o(92900);
            return a2;
        }
        String readLine2 = mVar.readLine();
        if (readLine2 == null) {
            AppMethodBeat.o(92900);
            return false;
        }
        Matcher matcher2 = bDF.matcher(readLine2);
        if (matcher2.matches()) {
            boolean a3 = a(readLine.trim(), matcher2, mVar, aVar, this.bCG, list);
            AppMethodBeat.o(92900);
            return a3;
        }
        AppMethodBeat.o(92900);
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static void a(String str, e.a aVar) {
        char c2;
        Layout.Alignment alignment;
        AppMethodBeat.i(92901);
        Matcher matcher = bDG.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    int indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        aVar.bAd = bm(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        aVar.bAd = Integer.MIN_VALUE;
                    }
                    if (group2.endsWith("%")) {
                        aVar.bAc = h.bo(group2);
                        aVar.lineType = 0;
                    } else {
                        int parseInt = Integer.parseInt(group2);
                        if (parseInt < 0) {
                            parseInt--;
                        }
                        aVar.bAc = (float) parseInt;
                        aVar.lineType = 1;
                    }
                } else if ("align".equals(group)) {
                    switch (group2.hashCode()) {
                        case -1364013995:
                            if (group2.equals("center")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1074341483:
                            if (group2.equals("middle")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 100571:
                            if (group2.equals("end")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3317767:
                            if (group2.equals("left")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 108511772:
                            if (group2.equals("right")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 109757538:
                            if (group2.equals("start")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            break;
                        case 2:
                        case 3:
                            alignment = Layout.Alignment.ALIGN_CENTER;
                            break;
                        case 4:
                        case 5:
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        default:
                            alignment = null;
                            break;
                    }
                    aVar.bAb = alignment;
                } else if ("position".equals(group)) {
                    int indexOf2 = group2.indexOf(44);
                    if (indexOf2 != -1) {
                        aVar.bAf = bm(group2.substring(indexOf2 + 1));
                        group2 = group2.substring(0, indexOf2);
                    } else {
                        aVar.bAf = Integer.MIN_VALUE;
                    }
                    aVar.bAe = h.bo(group2);
                } else if ("size".equals(group)) {
                    aVar.width = h.bo(group2);
                } else {
                    new StringBuilder("Unknown cue setting ").append(group).append(":").append(group2);
                }
            } catch (NumberFormatException e2) {
                new StringBuilder("Skipping bad cue setting: ").append(matcher.group());
            }
        }
        AppMethodBeat.o(92901);
    }

    static void a(String str, String str2, e.a aVar, List<d> list) {
        boolean z;
        int i2;
        int i3;
        int i4;
        String str3;
        boolean z2;
        AppMethodBeat.i(92902);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 < str2.length()) {
            char charAt = str2.charAt(i5);
            switch (charAt) {
                case '&':
                    int indexOf = str2.indexOf(59, i5 + 1);
                    int indexOf2 = str2.indexOf(32, i5 + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i5++;
                        break;
                    } else {
                        String substring = str2.substring(i5 + 1, indexOf);
                        char c2 = 65535;
                        switch (substring.hashCode()) {
                            case 3309:
                                if (substring.equals("gt")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3464:
                                if (substring.equals("lt")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 96708:
                                if (substring.equals("amp")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 3374865:
                                if (substring.equals("nbsp")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                spannableStringBuilder.append('<');
                                break;
                            case 1:
                                spannableStringBuilder.append('>');
                                break;
                            case 2:
                                spannableStringBuilder.append(' ');
                                break;
                            case 3:
                                spannableStringBuilder.append('&');
                                break;
                            default:
                                new StringBuilder("ignoring unsupported entity: '&").append(substring).append(";'");
                                break;
                        }
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        i5 = indexOf + 1;
                        break;
                    }
                case '<':
                    if (i5 + 1 < str2.length()) {
                        if (str2.charAt(i5 + 1) == '/') {
                            z = true;
                        } else {
                            z = false;
                        }
                        int indexOf3 = str2.indexOf(62, i5 + 1);
                        if (indexOf3 == -1) {
                            i2 = str2.length();
                        } else {
                            i2 = indexOf3 + 1;
                        }
                        boolean z3 = str2.charAt(i2 + -2) == '/';
                        if (z) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        int i6 = i3 + i5;
                        if (z3) {
                            i4 = i2 - 2;
                        } else {
                            i4 = i2 - 1;
                        }
                        String substring2 = str2.substring(i6, i4);
                        String trim = substring2.trim();
                        if (trim.isEmpty()) {
                            str3 = null;
                        } else {
                            str3 = trim.split("[ \\.]")[0];
                        }
                        if (str3 != null) {
                            char c3 = 65535;
                            switch (str3.hashCode()) {
                                case 98:
                                    if (str3.equals("b")) {
                                        c3 = 0;
                                        break;
                                    }
                                    break;
                                case 99:
                                    if (str3.equals("c")) {
                                        c3 = 1;
                                        break;
                                    }
                                    break;
                                case 105:
                                    if (str3.equals("i")) {
                                        c3 = 2;
                                        break;
                                    }
                                    break;
                                case 117:
                                    if (str3.equals("u")) {
                                        c3 = 4;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (str3.equals("v")) {
                                        c3 = 5;
                                        break;
                                    }
                                    break;
                                case 3314158:
                                    if (str3.equals("lang")) {
                                        c3 = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (c3) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    z2 = true;
                                    break;
                                default:
                                    z2 = false;
                                    break;
                            }
                            if (z2) {
                                if (!z) {
                                    if (!z3) {
                                        stack.push(a.k(substring2, spannableStringBuilder.length()));
                                        i5 = i2;
                                        break;
                                    }
                                } else {
                                    while (!stack.isEmpty()) {
                                        a aVar2 = (a) stack.pop();
                                        a(str, aVar2, spannableStringBuilder, list, arrayList);
                                        if (aVar2.name.equals(str3)) {
                                            i5 = i2;
                                            break;
                                        }
                                    }
                                    i5 = i2;
                                }
                            }
                        }
                        i5 = i2;
                        break;
                    } else {
                        i5++;
                        break;
                    }
                default:
                    spannableStringBuilder.append(charAt);
                    i5++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.wx(), spannableStringBuilder, list, arrayList);
        aVar.bDE = spannableStringBuilder;
        AppMethodBeat.o(92902);
    }

    private static boolean a(String str, Matcher matcher, m mVar, e.a aVar, StringBuilder sb, List<d> list) {
        AppMethodBeat.i(92903);
        try {
            aVar.startTime = h.bn(matcher.group(1));
            aVar.endTime = h.bn(matcher.group(2));
            a(matcher.group(3), aVar);
            sb.setLength(0);
            while (true) {
                String readLine = mVar.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (sb.length() > 0) {
                        sb.append("\n");
                    }
                    sb.append(readLine.trim());
                } else {
                    a(str, sb.toString(), aVar, list);
                    AppMethodBeat.o(92903);
                    return true;
                }
            }
        } catch (NumberFormatException e2) {
            new StringBuilder("Skipping cue with bad header: ").append(matcher.group());
            AppMethodBeat.o(92903);
            return false;
        }
    }

    private static int bm(String str) {
        AppMethodBeat.i(92904);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                AppMethodBeat.o(92904);
                return 0;
            case 1:
            case 2:
                AppMethodBeat.o(92904);
                return 1;
            case 3:
                AppMethodBeat.o(92904);
                return 2;
            default:
                AppMethodBeat.o(92904);
                return Integer.MIN_VALUE;
        }
    }

    private static void a(String str, a aVar, SpannableStringBuilder spannableStringBuilder, List<d> list, List<b> list2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(92905);
        int i2 = aVar.position;
        int length = spannableStringBuilder.length();
        String str2 = aVar.name;
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c2 = 6;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c2 = 0;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    c2 = 3;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    c2 = 1;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    c2 = 2;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                AppMethodBeat.o(92905);
                return;
        }
        list2.clear();
        a(list, str, aVar, list2);
        int size = list2.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = list2.get(i3).bDJ;
            if (dVar != null) {
                if (dVar.getStyle() != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(dVar.getStyle()), i2, length, 33);
                }
                if (dVar.bCY == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, length, 33);
                }
                if (dVar.bCZ == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                }
                if (dVar.bCW) {
                    if (!dVar.bCW) {
                        IllegalStateException illegalStateException = new IllegalStateException("Font color not defined");
                        AppMethodBeat.o(92905);
                        throw illegalStateException;
                    }
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.bCV), i2, length, 33);
                }
                if (dVar.bCX) {
                    if (!dVar.bCX) {
                        IllegalStateException illegalStateException2 = new IllegalStateException("Background color not defined.");
                        AppMethodBeat.o(92905);
                        throw illegalStateException2;
                    }
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.backgroundColor), i2, length, 33);
                }
                if (dVar.fontFamily != null) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(dVar.fontFamily), i2, length, 33);
                }
                if (dVar.bDe != null) {
                    spannableStringBuilder.setSpan(new AlignmentSpan.Standard(dVar.bDe), i2, length, 33);
                }
                switch (dVar.bDc) {
                    case 1:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.fontSize, true), i2, length, 33);
                        continue;
                    case 2:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize), i2, length, 33);
                        continue;
                    case 3:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize / 100.0f), i2, length, 33);
                        continue;
                }
            }
        }
        AppMethodBeat.o(92905);
    }

    private static void a(List<d> list, String str, a aVar, List<b> list2) {
        int size;
        AppMethodBeat.i(92906);
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            d dVar = list.get(i2);
            String str2 = aVar.name;
            String[] strArr = aVar.bDI;
            String str3 = aVar.voice;
            if (!dVar.aQa.isEmpty() || !dVar.bDA.isEmpty() || !dVar.bDB.isEmpty() || !dVar.bDC.isEmpty()) {
                int b2 = d.b(d.b(d.b(0, dVar.aQa, str, 1073741824), dVar.bDA, str2, 2), dVar.bDC, str3, 4);
                size = (b2 == -1 || !Arrays.asList(strArr).containsAll(dVar.bDB)) ? 0 : b2 + (dVar.bDB.size() * 4);
            } else if (str2.isEmpty()) {
                size = 1;
            } else {
                size = 0;
            }
            if (size > 0) {
                list2.add(new b(size, dVar));
            }
        }
        Collections.sort(list2);
        AppMethodBeat.o(92906);
    }

    /* access modifiers changed from: package-private */
    public static final class b implements Comparable<b> {
        public final d bDJ;
        public final int score;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
            return this.score - bVar.score;
        }

        public b(int i2, d dVar) {
            this.score = i2;
            this.bDJ = dVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private static final String[] bDH = new String[0];
        public final String[] bDI;
        public final String name;
        public final int position;
        public final String voice;

        private a(String str, int i2, String str2, String[] strArr) {
            this.position = i2;
            this.name = str;
            this.voice = str2;
            this.bDI = strArr;
        }

        public static a k(String str, int i2) {
            String str2;
            String[] strArr;
            AppMethodBeat.i(92897);
            String trim = str.trim();
            if (trim.isEmpty()) {
                AppMethodBeat.o(92897);
                return null;
            }
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = trim.split("\\.");
            String str3 = split[0];
            if (split.length > 1) {
                strArr = (String[]) Arrays.copyOfRange(split, 1, split.length);
            } else {
                strArr = bDH;
            }
            a aVar = new a(str3, i2, str2, strArr);
            AppMethodBeat.o(92897);
            return aVar;
        }

        public static a wx() {
            AppMethodBeat.i(92898);
            a aVar = new a("", 0, "", new String[0]);
            AppMethodBeat.o(92898);
            return aVar;
        }
    }
}
