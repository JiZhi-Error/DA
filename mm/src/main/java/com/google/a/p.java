package com.google.a;

import com.google.a.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class p extends r {
    static final p bUc = new p((byte) 0);
    private final Map<String, b> bTY;
    private final Map<String, b> bTZ;
    private final Map<a, b> bUa;
    private final Map<a, b> bUb;

    public static final class b {
        public final l.f bUd;
        public final at bUe;
    }

    public static p FY() {
        return bUc;
    }

    public final b a(l.a aVar, int i2) {
        return this.bUa.get(new a(aVar, i2));
    }

    private p() {
        this.bTY = new HashMap();
        this.bTZ = new HashMap();
        this.bUa = new HashMap();
        this.bUb = new HashMap();
    }

    private p(byte b2) {
        super(bUj);
        this.bTY = Collections.emptyMap();
        this.bTZ = Collections.emptyMap();
        this.bUa = Collections.emptyMap();
        this.bUb = Collections.emptyMap();
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private final l.a bNK;
        private final int number;

        a(l.a aVar, int i2) {
            this.bNK = aVar;
            this.number = i2;
        }

        public final int hashCode() {
            return (this.bNK.hashCode() * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.bNK == aVar.bNK && this.number == aVar.number) {
                return true;
            }
            return false;
        }
    }
}
