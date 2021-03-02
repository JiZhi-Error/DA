package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class o {
    private static c jdH = null;

    public static class a {
        public q dGJ;
        public long jdI;
    }

    public interface c {
        a a(e eVar);
    }

    public enum d {
        TEXT,
        jdL,
        jdM,
        CDN_IMAGE,
        EMOJI;

        public static d valueOf(String str) {
            AppMethodBeat.i(225963);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(225963);
            return dVar;
        }

        static {
            AppMethodBeat.i(225964);
            AppMethodBeat.o(225964);
        }
    }

    static void a(c cVar) {
        jdH = cVar;
    }

    public static e Pl(String str) {
        AppMethodBeat.i(225966);
        d dVar = d.TEXT;
        e eVar = new e();
        eVar.toUser = str;
        eVar.jec = dVar;
        AppMethodBeat.o(225966);
        return eVar;
    }

    public static e a(d dVar) {
        AppMethodBeat.i(225967);
        e eVar = new e();
        eVar.jec = dVar;
        AppMethodBeat.o(225967);
        return eVar;
    }

    public static class e {
        public int cSx;
        public String content;
        public int dQd;
        public String dRL;
        public float dTj;
        public int hmk;
        public boolean hmr;
        public int iXp;
        public String iXy = "";
        public String iZr;
        public String iZt = "";
        public Object jdQ;
        public int jdR;
        public j jdS;
        public n jdT;
        public int jdU;
        public boolean jdV;
        public long jdW;
        public long jdX;
        public String jdY;
        public int jdZ;
        public boolean jea;
        public int jeb;
        public d jec;
        public float latitude;
        public long msgId;
        public String thumbPath = "";
        public String toUser;
        public int type;

        public e tc(int i2) {
            this.hmk = i2;
            return this;
        }

        public e tD(int i2) {
            this.type = i2;
            return this;
        }

        public final <T extends q> b<T> bdQ() {
            AppMethodBeat.i(225965);
            b<T> bVar = new b<>();
            if (o.jdH != null) {
                a a2 = o.jdH.a(this);
                bVar.jdJ = (T) a2.dGJ;
                bVar.jdI = a2.jdI;
            }
            AppMethodBeat.o(225965);
            return bVar;
        }
    }

    public static class b<T extends q> {
        public long jdI;
        public T jdJ;

        public final boolean execute() {
            AppMethodBeat.i(225961);
            if (this.jdJ == null) {
                Log.e("SendMsgCgiFactory", "[execute] cgi is null. %s", Util.getStack());
            }
            Objects.requireNonNull(this.jdJ);
            boolean a2 = aa.iNn.azA().a(this.jdJ, 0);
            AppMethodBeat.o(225961);
            return a2;
        }
    }
}
