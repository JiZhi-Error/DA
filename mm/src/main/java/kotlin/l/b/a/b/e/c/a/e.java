package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public abstract class e {
    public abstract String getDesc();

    public abstract String getName();

    public abstract String sG();

    private e() {
    }

    public /* synthetic */ e(byte b2) {
        this();
    }

    public static final class b extends e {
        public final String desc;
        public final String name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super((byte) 0);
            p.h(str, "name");
            p.h(str2, "desc");
            AppMethodBeat.i(59238);
            this.name = str;
            this.desc = str2;
            AppMethodBeat.o(59238);
        }

        @Override // kotlin.l.b.a.b.e.c.a.e
        public final String getDesc() {
            return this.desc;
        }

        @Override // kotlin.l.b.a.b.e.c.a.e
        public final String getName() {
            return this.name;
        }

        @Override // kotlin.l.b.a.b.e.c.a.e
        public final String sG() {
            AppMethodBeat.i(59237);
            String str = this.name + this.desc;
            AppMethodBeat.o(59237);
            return str;
        }

        public final int hashCode() {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(59239);
            String str = this.name;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i4 = i2 * 31;
            String str2 = this.desc;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            int i5 = i4 + i3;
            AppMethodBeat.o(59239);
            return i5;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.desc, r4.desc) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 59240(0xe768, float:8.3013E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof kotlin.l.b.a.b.e.c.a.e.b
                if (r0 == 0) goto L_0x0027
                kotlin.l.b.a.b.e.c.a.e$b r4 = (kotlin.l.b.a.b.e.c.a.e.b) r4
                java.lang.String r0 = r3.name
                java.lang.String r1 = r4.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.desc
                java.lang.String r1 = r4.desc
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.e.b.equals(java.lang.Object):boolean");
        }
    }

    public static final class a extends e {
        public final String desc;
        public final String name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super((byte) 0);
            p.h(str, "name");
            p.h(str2, "desc");
            AppMethodBeat.i(59234);
            this.name = str;
            this.desc = str2;
            AppMethodBeat.o(59234);
        }

        @Override // kotlin.l.b.a.b.e.c.a.e
        public final String getDesc() {
            return this.desc;
        }

        @Override // kotlin.l.b.a.b.e.c.a.e
        public final String getName() {
            return this.name;
        }

        @Override // kotlin.l.b.a.b.e.c.a.e
        public final String sG() {
            AppMethodBeat.i(59233);
            String str = this.name + ':' + this.desc;
            AppMethodBeat.o(59233);
            return str;
        }

        public final int hashCode() {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(59235);
            String str = this.name;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i4 = i2 * 31;
            String str2 = this.desc;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            int i5 = i4 + i3;
            AppMethodBeat.o(59235);
            return i5;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.desc, r4.desc) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 59236(0xe764, float:8.3007E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof kotlin.l.b.a.b.e.c.a.e.a
                if (r0 == 0) goto L_0x0027
                kotlin.l.b.a.b.e.c.a.e$a r4 = (kotlin.l.b.a.b.e.c.a.e.a) r4
                java.lang.String r0 = r3.name
                java.lang.String r1 = r4.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.desc
                java.lang.String r1 = r4.desc
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.e.a.equals(java.lang.Object):boolean");
        }
    }

    public final String toString() {
        return sG();
    }
}
