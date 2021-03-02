package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.vfs.o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f implements Comparable<f> {
    private static final Pattern mxI = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    public final boolean bGq;
    public final long bGr;
    public final o file;
    public final long kNt;
    public final String key;
    public final long length;
    public final c mxv;
    public final long position;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(f fVar) {
        AppMethodBeat.i(234686);
        int d2 = d(fVar);
        AppMethodBeat.o(234686);
        return d2;
    }

    static {
        AppMethodBeat.i(234687);
        AppMethodBeat.o(234687);
    }

    public static o a(o oVar, String str, long j2, long j3, c cVar, long j4) {
        AppMethodBeat.i(234680);
        StringBuilder append = new StringBuilder().append(str).append(".").append(j2).append(".").append(j3).append(".");
        if (TextUtils.isEmpty(cVar.myz)) {
            cVar.myz = c.abb(cVar.myy);
        }
        o oVar2 = new o(oVar, append.append(cVar.myz).append(".").append(j4).append(".v1.dat").toString());
        AppMethodBeat.o(234680);
        return oVar2;
    }

    public static f S(String str, long j2) {
        AppMethodBeat.i(234681);
        f fVar = new f(str, j2, -1, -1, c.myu, false, -1, null);
        AppMethodBeat.o(234681);
        return fVar;
    }

    public static f T(String str, long j2) {
        AppMethodBeat.i(234682);
        f fVar = new f(str, j2, -1, -1, c.myu, false, -1, null);
        AppMethodBeat.o(234682);
        return fVar;
    }

    public static f p(String str, long j2, long j3) {
        AppMethodBeat.i(234683);
        f fVar = new f(str, j2, j3, -1, c.myu, false, -1, null);
        AppMethodBeat.o(234683);
        return fVar;
    }

    public static f B(o oVar) {
        AppMethodBeat.i(234684);
        Matcher matcher = mxI.matcher(oVar.getName());
        if (!matcher.matches()) {
            AppMethodBeat.o(234684);
            return null;
        }
        f fVar = new f(matcher.group(1), Long.parseLong(matcher.group(2)), oVar.length(), Long.parseLong(matcher.group(3)), c.abe(matcher.group(4)), true, Long.parseLong(matcher.group(5)), oVar);
        AppMethodBeat.o(234684);
        return fVar;
    }

    private f(String str, long j2, long j3, long j4, c cVar, boolean z, long j5, o oVar) {
        this.key = str;
        this.position = j2;
        this.length = j3;
        this.kNt = j4;
        this.mxv = cVar;
        this.bGq = z;
        this.file = oVar;
        this.bGr = j5;
    }

    public final int d(f fVar) {
        AppMethodBeat.i(234685);
        if (!this.key.equals(fVar.key)) {
            int compareTo = this.key.compareTo(fVar.key);
            AppMethodBeat.o(234685);
            return compareTo;
        }
        long j2 = this.position - fVar.position;
        if (j2 == 0) {
            AppMethodBeat.o(234685);
            return 0;
        } else if (j2 < 0) {
            AppMethodBeat.o(234685);
            return -1;
        } else {
            AppMethodBeat.o(234685);
            return 1;
        }
    }
}
