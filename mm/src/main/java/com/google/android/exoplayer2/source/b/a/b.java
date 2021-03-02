package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b extends c {
    public final long bdJ;
    public final long bxn;
    public final int byQ;
    public final long byR;
    public final boolean byS;
    public final int byT;
    public final int byU;
    public final long byV;
    public final boolean byW;
    public final boolean byX;
    public final boolean byY;
    public final a byZ;
    public final List<a> segments;
    public final int version;

    public static final class a implements Comparable<Long> {
        public final long bdJ;
        public final boolean bou;
        public final int bza;
        public final long bzb;
        public final String bzc;
        public final String bzd;
        public final long bze;
        public final long bzf;
        public final String url;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Long l) {
            AppMethodBeat.i(62887);
            Long l2 = l;
            if (this.bzb > l2.longValue()) {
                AppMethodBeat.o(62887);
                return 1;
            } else if (this.bzb < l2.longValue()) {
                AppMethodBeat.o(62887);
                return -1;
            } else {
                AppMethodBeat.o(62887);
                return 0;
            }
        }

        public a(String str, long j2, long j3) {
            this(str, 0, -1, -9223372036854775807L, false, null, null, j2, j3);
        }

        public a(String str, long j2, int i2, long j3, boolean z, String str2, String str3, long j4, long j5) {
            this.url = str;
            this.bdJ = j2;
            this.bza = i2;
            this.bzb = j3;
            this.bou = z;
            this.bzc = str2;
            this.bzd = str3;
            this.bze = j4;
            this.bzf = j5;
        }
    }

    public b(int i2, String str, List<String> list, long j2, long j3, boolean z, int i3, int i4, int i5, long j4, boolean z2, boolean z3, boolean z4, a aVar, List<a> list2) {
        super(str, list);
        AppMethodBeat.i(62888);
        this.byQ = i2;
        this.bxn = j3;
        this.byS = z;
        this.byT = i3;
        this.byU = i4;
        this.version = i5;
        this.byV = j4;
        this.byW = z2;
        this.byX = z3;
        this.byY = z4;
        this.byZ = aVar;
        this.segments = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.bdJ = aVar2.bdJ + aVar2.bzb;
        } else {
            this.bdJ = 0;
        }
        if (j2 == -9223372036854775807L) {
            j2 = -9223372036854775807L;
        } else if (j2 < 0) {
            j2 += this.bdJ;
        }
        this.byR = j2;
        AppMethodBeat.o(62888);
    }

    public final long vW() {
        return this.bxn + this.bdJ;
    }
}
