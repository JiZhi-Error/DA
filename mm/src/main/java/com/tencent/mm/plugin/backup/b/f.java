package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {

    public static class b implements Cloneable, Comparable<b> {
        public String oJq;
        public long oJr = 0;
        public long oJs = 0;
        public long oJt = -1;
        public long oJu = -1;

        @Override // java.lang.Object
        public final /* synthetic */ Object clone() {
            AppMethodBeat.i(21167);
            b ceW = ceW();
            AppMethodBeat.o(21167);
            return ceW;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            if (this.oJt < bVar2.oJt) {
                return 1;
            }
            if (this.oJt > bVar2.oJt) {
                return -1;
            }
            return 0;
        }

        public final b ceW() {
            AppMethodBeat.i(21166);
            b bVar = new b();
            bVar.oJq = this.oJq;
            bVar.oJr = this.oJr;
            bVar.oJs = this.oJs;
            bVar.oJt = this.oJt;
            bVar.oJu = this.oJu;
            AppMethodBeat.o(21166);
            return bVar;
        }
    }

    public static class a {
        public long endTime;
        public String oJo;
        public int oJp;
        public long startTime;

        public a(int i2, String str, long j2, long j3) {
            this.oJp = i2;
            this.oJo = str;
            this.startTime = j2;
            this.endTime = j3;
        }
    }
}
