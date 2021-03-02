package com.tencent.mm.av.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.b.d;
import com.tencent.mm.av.a.b.e;
import com.tencent.mm.av.a.b.i;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.av.a.c.f;
import com.tencent.mm.av.a.c.g;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.av.a.c.l;
import com.tencent.mm.av.a.c.m;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.av.a.c.p;
import java.util.concurrent.Executor;

public final class b {
    public static final int jaO = Runtime.getRuntime().availableProcessors();
    public final Resources aKy;
    public final int jaP;
    public final int jaQ;
    public final c jaR;
    public final o jaS;
    public final com.tencent.mm.av.a.c.b jaT;
    public final c jaU;
    public final g jaV;
    public final l jaW;
    public final m jaX;
    public final f jaY;
    public final j jaZ;
    public final Executor jba;
    public final p jbb;
    public final String packageName;

    static {
        AppMethodBeat.i(130400);
        AppMethodBeat.o(130400);
    }

    public b(a aVar) {
        AppMethodBeat.i(130398);
        this.packageName = aVar.context.getPackageName();
        this.aKy = aVar.context.getResources();
        this.jaP = aVar.jaP;
        this.jaQ = aVar.jaQ;
        this.jaR = aVar.jaR;
        this.jaS = aVar.jaS;
        this.jaT = aVar.jaT;
        this.jaU = aVar.jaU;
        this.jaV = aVar.jaV;
        this.jaW = aVar.jaW;
        this.jaZ = aVar.jaZ;
        this.jba = aVar.jba;
        this.jaX = aVar.jbc;
        this.jaY = aVar.jaY;
        this.jbb = aVar.jbb;
        AppMethodBeat.o(130398);
    }

    public static b db(Context context) {
        AppMethodBeat.i(130399);
        b bdd = new a(context).bdd();
        AppMethodBeat.o(130399);
        return bdd;
    }

    public static class a {
        Context context;
        int jaP = b.jaO;
        int jaQ = 5;
        c jaR = null;
        public o jaS = null;
        com.tencent.mm.av.a.c.b jaT = null;
        public c jaU = null;
        g jaV = null;
        l jaW = null;
        f jaY = null;
        public j jaZ = null;
        Executor jba;
        p jbb = null;
        m jbc = null;

        public a(Context context2) {
            AppMethodBeat.i(130395);
            this.context = context2.getApplicationContext();
            AppMethodBeat.o(130395);
        }

        public final a a(com.tencent.mm.av.a.c.b bVar) {
            this.jaT = bVar;
            return this;
        }

        public final a b(c cVar) {
            this.jaU = cVar;
            return this;
        }

        public final b bdd() {
            AppMethodBeat.i(130396);
            bde();
            b bVar = new b(this);
            AppMethodBeat.o(130396);
            return bVar;
        }

        private void bde() {
            AppMethodBeat.i(130397);
            if (this.jaR == null) {
                this.jaR = c.bdf();
            }
            if (this.jaS == null) {
                this.jaS = new com.tencent.mm.av.a.b.f();
            }
            if (this.jaT == null) {
                this.jaT = new com.tencent.mm.av.a.b.a();
            }
            if (this.jaU == null) {
                this.jaU = new com.tencent.mm.av.a.b.b();
            }
            if (this.jaV == null) {
                this.jaV = new d();
            }
            if (this.jaW == null) {
                this.jaW = new i();
            }
            if (this.jaZ == null) {
                this.jaZ = a.tv(this.jaP);
            }
            if (this.jba == null) {
                this.jba = a.bdc();
            }
            if (this.jbc == null) {
                this.jbc = new e();
            }
            if (this.jaY == null) {
                this.jaY = new com.tencent.mm.av.a.b.c();
            }
            if (this.jbb == null) {
                this.jbb = new com.tencent.mm.av.a.b.g();
            }
            AppMethodBeat.o(130397);
        }
    }
}
