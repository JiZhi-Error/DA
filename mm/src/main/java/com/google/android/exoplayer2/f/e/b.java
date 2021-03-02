package com.google.android.exoplayer2.f.e;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class b {
    private List<b> aQz;
    public final boolean bCP;
    public final d bCQ;
    public final String bCR;
    private final String[] bCS;
    private final HashMap<String, Integer> bCT;
    private final HashMap<String, Integer> bCU;
    public final long bxn;
    public final long bxo;
    public final String tag;
    public final String text;

    b(String str, String str2, long j2, long j3, d dVar, String[] strArr, String str3) {
        AppMethodBeat.i(92848);
        this.tag = str;
        this.text = str2;
        this.bCQ = dVar;
        this.bCS = strArr;
        this.bCP = str2 != null;
        this.bxn = j2;
        this.bxo = j3;
        this.bCR = (String) a.checkNotNull(str3);
        this.bCT = new HashMap<>();
        this.bCU = new HashMap<>();
        AppMethodBeat.o(92848);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(92849);
        if (this.aQz == null) {
            this.aQz = new ArrayList();
        }
        this.aQz.add(bVar);
        AppMethodBeat.o(92849);
    }

    private b eR(int i2) {
        AppMethodBeat.i(92850);
        if (this.aQz == null) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(92850);
            throw indexOutOfBoundsException;
        }
        b bVar = this.aQz.get(i2);
        AppMethodBeat.o(92850);
        return bVar;
    }

    private int getChildCount() {
        AppMethodBeat.i(92851);
        if (this.aQz == null) {
            AppMethodBeat.o(92851);
            return 0;
        }
        int size = this.aQz.size();
        AppMethodBeat.o(92851);
        return size;
    }

    public final long[] wu() {
        int i2 = 0;
        AppMethodBeat.i(92852);
        TreeSet<Long> treeSet = new TreeSet<>();
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            i2++;
            jArr[i2] = it.next().longValue();
        }
        AppMethodBeat.o(92852);
        return jArr;
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        AppMethodBeat.i(92853);
        boolean equals = "p".equals(this.tag);
        if (z || equals) {
            if (this.bxn != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.bxn));
            }
            if (this.bxo != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.bxo));
            }
        }
        if (this.aQz == null) {
            AppMethodBeat.o(92853);
            return;
        }
        for (int i2 = 0; i2 < this.aQz.size(); i2++) {
            this.aQz.get(i2).a(treeSet, z || equals);
        }
        AppMethodBeat.o(92853);
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        boolean z2;
        AppMethodBeat.i(92854);
        this.bCT.clear();
        this.bCU.clear();
        String str2 = this.bCR;
        if ("".equals(str2)) {
            str2 = str;
        }
        if (this.bCP && z) {
            c(str2, map).append((CharSequence) this.text);
            AppMethodBeat.o(92854);
        } else if (!"br".equals(this.tag) || !z) {
            if (!"metadata".equals(this.tag)) {
                if (!(this.bxn == -9223372036854775807L && this.bxo == -9223372036854775807L) && ((this.bxn > j2 || this.bxo != -9223372036854775807L) && ((this.bxn != -9223372036854775807L || j2 >= this.bxo) && (this.bxn > j2 || j2 >= this.bxo)))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    boolean equals = "p".equals(this.tag);
                    for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                        this.bCT.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
                    }
                    for (int i2 = 0; i2 < getChildCount(); i2++) {
                        eR(i2).a(j2, z || equals, str2, map);
                    }
                    if (equals) {
                        SpannableStringBuilder c2 = c(str2, map);
                        int length = c2.length() - 1;
                        while (length >= 0 && c2.charAt(length) == ' ') {
                            length--;
                        }
                        if (length >= 0 && c2.charAt(length) != '\n') {
                            c2.append('\n');
                        }
                    }
                    for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                        this.bCU.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
                    }
                }
            }
            AppMethodBeat.o(92854);
        } else {
            c(str2, map).append('\n');
            AppMethodBeat.o(92854);
        }
    }

    private static SpannableStringBuilder c(String str, Map<String, SpannableStringBuilder> map) {
        AppMethodBeat.i(92855);
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        SpannableStringBuilder spannableStringBuilder = map.get(str);
        AppMethodBeat.o(92855);
        return spannableStringBuilder;
    }

    /* access modifiers changed from: package-private */
    public final void a(Map<String, d> map, Map<String, SpannableStringBuilder> map2) {
        AppMethodBeat.i(92856);
        for (Map.Entry<String, Integer> entry : this.bCU.entrySet()) {
            String key = entry.getKey();
            int intValue = this.bCT.containsKey(key) ? this.bCT.get(key).intValue() : 0;
            SpannableStringBuilder spannableStringBuilder = map2.get(key);
            int intValue2 = entry.getValue().intValue();
            if (intValue != intValue2) {
                d dVar = this.bCQ;
                String[] strArr = this.bCS;
                if (dVar == null && strArr == null) {
                    dVar = null;
                } else if (dVar == null && strArr.length == 1) {
                    dVar = map.get(strArr[0]);
                } else if (dVar == null && strArr.length > 1) {
                    dVar = new d();
                    for (String str : strArr) {
                        dVar.b(map.get(str));
                    }
                } else if (dVar != null && strArr != null && strArr.length == 1) {
                    dVar = dVar.b(map.get(strArr[0]));
                } else if (!(dVar == null || strArr == null || strArr.length <= 1)) {
                    for (String str2 : strArr) {
                        dVar.b(map.get(str2));
                    }
                }
                if (dVar != null) {
                    if (dVar.getStyle() != -1) {
                        spannableStringBuilder.setSpan(new StyleSpan(dVar.getStyle()), intValue, intValue2, 33);
                    }
                    if (dVar.bCY == 1) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                    }
                    if (dVar.bCZ == 1) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                    }
                    if (dVar.bCW) {
                        if (!dVar.bCW) {
                            IllegalStateException illegalStateException = new IllegalStateException("Font color has not been defined.");
                            AppMethodBeat.o(92856);
                            throw illegalStateException;
                        }
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.bCV), intValue, intValue2, 33);
                    }
                    if (dVar.bCX) {
                        if (!dVar.bCX) {
                            IllegalStateException illegalStateException2 = new IllegalStateException("Background color has not been defined.");
                            AppMethodBeat.o(92856);
                            throw illegalStateException2;
                        }
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.backgroundColor), intValue, intValue2, 33);
                    }
                    if (dVar.fontFamily != null) {
                        spannableStringBuilder.setSpan(new TypefaceSpan(dVar.fontFamily), intValue, intValue2, 33);
                    }
                    if (dVar.bDe != null) {
                        spannableStringBuilder.setSpan(new AlignmentSpan.Standard(dVar.bDe), intValue, intValue2, 33);
                    }
                    switch (dVar.bDc) {
                        case 1:
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.fontSize, true), intValue, intValue2, 33);
                            break;
                        case 2:
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize), intValue, intValue2, 33);
                            break;
                        case 3:
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize / 100.0f), intValue, intValue2, 33);
                            break;
                    }
                }
            }
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                eR(i2).a(map, map2);
            }
        }
        AppMethodBeat.o(92856);
    }

    static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i2;
        AppMethodBeat.i(92857);
        int length = spannableStringBuilder.length();
        int i3 = 0;
        while (i3 < length) {
            if (spannableStringBuilder.charAt(i3) == ' ') {
                int i4 = i3 + 1;
                while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                    i4++;
                }
                int i5 = i4 - (i3 + 1);
                if (i5 > 0) {
                    spannableStringBuilder.delete(i3, i3 + i5);
                    i2 = length - i5;
                    i3++;
                    length = i2;
                }
            }
            i2 = length;
            i3++;
            length = i2;
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i6 = length;
        for (int i7 = 0; i7 < i6 - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == '\n' && spannableStringBuilder.charAt(i7 + 1) == ' ') {
                spannableStringBuilder.delete(i7 + 1, i7 + 2);
                i6--;
            }
        }
        if (i6 > 0 && spannableStringBuilder.charAt(i6 - 1) == ' ') {
            spannableStringBuilder.delete(i6 - 1, i6);
            i6--;
        }
        for (int i8 = 0; i8 < i6 - 1; i8++) {
            if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i8 + 1) == '\n') {
                spannableStringBuilder.delete(i8, i8 + 1);
                i6--;
            }
        }
        if (i6 > 0 && spannableStringBuilder.charAt(i6 - 1) == '\n') {
            spannableStringBuilder.delete(i6 - 1, i6);
        }
        AppMethodBeat.o(92857);
        return spannableStringBuilder;
    }
}
