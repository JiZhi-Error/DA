package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.List;

public final class e {
    public TextPaint iW;
    public CharSequence wWc;
    public h wWd;
    public boolean wWe;
    public boolean wWf;
    public a wWg = a.Foreground;
    public int wWh = Color.parseColor("#07C160");
    public float wWi;
    public CharSequence wWj = "";
    public CharSequence wWk = "";
    public String wWl = "";
    public String wWm = "";

    public e() {
        AppMethodBeat.i(131679);
        AppMethodBeat.o(131679);
    }

    public enum a {
        Foreground,
        Background,
        CustomTag;

        public static a valueOf(String str) {
            AppMethodBeat.i(131675);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(131675);
            return aVar;
        }

        static {
            AppMethodBeat.i(131676);
            AppMethodBeat.o(131676);
        }
    }

    public static class b implements Comparable<b> {
        public h.c wWr;
        public int wWs = -1;
        public int wWt = -1;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
            return this.wWs - bVar.wWs;
        }

        public final boolean isAvailable() {
            return (this.wWs == -1 || this.wWt == -1) ? false : true;
        }

        public final String getKeyword() {
            AppMethodBeat.i(131677);
            if (this.wWr != null && this.wWr.wWJ.size() > 0) {
                for (h.b bVar : this.wWr.wWJ) {
                    if (bVar.wWH == h.d.OTHER) {
                        String str = bVar.content;
                        AppMethodBeat.o(131677);
                        return str;
                    }
                }
            }
            AppMethodBeat.o(131677);
            return null;
        }

        public final String toString() {
            AppMethodBeat.i(131678);
            Object[] objArr = new Object[3];
            objArr[0] = this.wWr == null ? "" : this.wWr.dOB().replaceAll(RecoveryFileLog.SPLITTER, ",");
            objArr[1] = Integer.valueOf(this.wWs);
            objArr[2] = Integer.valueOf(this.wWt);
            String format = String.format("FTSQueryHLRequest.Item %s %d %d", objArr);
            AppMethodBeat.o(131678);
            return format;
        }
    }

    public static final e a(CharSequence charSequence, List<String> list) {
        AppMethodBeat.i(131680);
        e c2 = c(charSequence, Util.listToString(list, " "));
        AppMethodBeat.o(131680);
        return c2;
    }

    public static final e c(CharSequence charSequence, String str) {
        AppMethodBeat.i(131681);
        e eVar = new e();
        eVar.wWc = charSequence;
        eVar.wWd = h.bE(str, false);
        eVar.wWe = false;
        eVar.wWf = false;
        AppMethodBeat.o(131681);
        return eVar;
    }

    public static final e a(CharSequence charSequence, h hVar) {
        AppMethodBeat.i(131682);
        e eVar = new e();
        eVar.wWc = charSequence;
        eVar.wWd = hVar;
        AppMethodBeat.o(131682);
        return eVar;
    }

    public static final e a(CharSequence charSequence, h hVar, boolean z, boolean z2) {
        AppMethodBeat.i(131683);
        e a2 = a(charSequence, hVar, z, z2, 0.0f, null);
        AppMethodBeat.o(131683);
        return a2;
    }

    public static final e a(CharSequence charSequence, h hVar, float f2, TextPaint textPaint) {
        AppMethodBeat.i(131684);
        e a2 = a(charSequence, hVar, false, false, f2, textPaint);
        AppMethodBeat.o(131684);
        return a2;
    }

    public static final e a(CharSequence charSequence, h hVar, boolean z, boolean z2, float f2, TextPaint textPaint) {
        AppMethodBeat.i(131685);
        e eVar = new e();
        eVar.wWc = charSequence;
        eVar.wWd = hVar;
        eVar.wWe = z;
        eVar.wWf = z2;
        eVar.wWi = f2;
        eVar.iW = textPaint;
        AppMethodBeat.o(131685);
        return eVar;
    }

    public static final e a(CharSequence charSequence, h hVar, boolean z, boolean z2, TextPaint textPaint, CharSequence charSequence2, CharSequence charSequence3) {
        AppMethodBeat.i(131686);
        e eVar = new e();
        eVar.wWc = charSequence;
        eVar.wWd = hVar;
        eVar.wWe = z;
        eVar.wWf = z2;
        eVar.wWi = 400.0f;
        eVar.iW = textPaint;
        eVar.wWj = charSequence2;
        eVar.wWk = charSequence3;
        AppMethodBeat.o(131686);
        return eVar;
    }

    public static final e a(CharSequence charSequence, List<String> list, a aVar, int i2) {
        AppMethodBeat.i(131687);
        e a2 = a(charSequence, list);
        a2.wWg = aVar;
        a2.wWh = i2;
        AppMethodBeat.o(131687);
        return a2;
    }
}
