package com.tencent.mm.av.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.av.a.c.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c {
    public final float alpha;
    public final int density;
    public final String fullPath;
    public final int hZA;
    private final Drawable hZC;
    public final boolean hZF;
    public final int hZz;
    public final MMHandler handler;
    public final boolean iaT;
    public final com.tencent.mm.av.a.c.c jaU;
    public final boolean jbA;
    public final q jbB;
    public final com.tencent.mm.av.a.c.a jbC;
    public final i jbD;
    public final Object[] jbE;
    public final boolean jbd;
    public final boolean jbe;
    public final boolean jbf;
    public final boolean jbg;
    public final String jbh;
    public final int jbi;
    public final boolean jbj;
    public final boolean jbk;
    public final boolean jbl;
    public final int jbm;
    public final boolean jbn;
    private final boolean jbo;
    public final boolean jbp;
    public final int jbq;
    private final int jbr;
    private final Drawable jbs;
    public final int jbt;
    private final Drawable jbu;
    public final String jbv;
    public final SFSContext jbw;
    public final float jbx;
    public final boolean jby;
    public final boolean jbz;
    public final String md5;
    public final String prefixPath;
    public final String thumbPath;

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private c(a aVar) {
        this.jbd = aVar.jbd;
        this.jbf = aVar.jbf;
        this.jbe = aVar.jbe;
        this.jbg = aVar.jbg;
        this.fullPath = aVar.fullPath;
        this.prefixPath = aVar.prefixPath;
        this.jbh = aVar.jbh;
        this.jbi = aVar.jbi;
        this.hZz = aVar.hZz;
        this.hZA = aVar.hZA;
        this.jbj = aVar.jbj;
        this.md5 = aVar.md5;
        this.density = aVar.density;
        this.alpha = aVar.alpha;
        this.jbk = aVar.jbk;
        this.jbl = aVar.jbl;
        this.jbm = aVar.jbm;
        this.thumbPath = aVar.thumbPath;
        this.jbn = aVar.jbn;
        this.jbo = aVar.jbo;
        this.jbp = aVar.jbp;
        this.jbq = aVar.jbq;
        this.hZC = aVar.hZC;
        this.jbr = aVar.jbr;
        this.jbs = aVar.jbs;
        this.jbt = aVar.jbt;
        this.jbu = aVar.jbu;
        this.hZF = aVar.hZF;
        this.iaT = aVar.iaT;
        this.jbx = aVar.jbx;
        this.jby = aVar.jby;
        this.jbz = aVar.jbz;
        this.jbA = aVar.jbA;
        this.jbw = aVar.jbw;
        this.handler = aVar.handler;
        this.jbE = aVar.jbE;
        this.jaU = aVar.jaU;
        this.jbB = aVar.jbB;
        this.jbC = aVar.jbC;
        this.jbD = aVar.jbD;
        this.jbv = aVar.jbv;
    }

    public static c bdf() {
        AppMethodBeat.i(130402);
        c bdv = new a().bdv();
        AppMethodBeat.o(130402);
        return bdv;
    }

    public final boolean bdg() {
        return this.jbq > 0 || this.hZC != null;
    }

    public final boolean bdh() {
        return this.jbt > 0 || this.jbu != null;
    }

    public final String bdi() {
        return this.fullPath;
    }

    public final int bdj() {
        return this.hZz;
    }

    public final int bdk() {
        return this.hZA;
    }

    public final Drawable g(Resources resources) {
        AppMethodBeat.i(130403);
        if (this.jbq != 0) {
            Drawable drawable = resources.getDrawable(this.jbq);
            AppMethodBeat.o(130403);
            return drawable;
        }
        Drawable drawable2 = this.hZC;
        AppMethodBeat.o(130403);
        return drawable2;
    }

    public final Drawable h(Resources resources) {
        AppMethodBeat.i(130404);
        if (this.jbt != 0) {
            Drawable drawable = resources.getDrawable(this.jbt);
            AppMethodBeat.o(130404);
            return drawable;
        }
        Drawable drawable2 = this.jbu;
        AppMethodBeat.o(130404);
        return drawable2;
    }

    public final boolean bdl() {
        return this.iaT;
    }

    public final float bdm() {
        return this.jbx;
    }

    public final String bdn() {
        return this.jbv;
    }

    public static class a {
        float alpha = 0.0f;
        int density = 0;
        public String fullPath = "";
        public int hZA = 0;
        public Drawable hZC = null;
        public boolean hZF = true;
        public int hZz = 0;
        MMHandler handler = null;
        public boolean iaT = false;
        public com.tencent.mm.av.a.c.c jaU = null;
        boolean jbA = false;
        q jbB = null;
        public com.tencent.mm.av.a.c.a jbC = null;
        public i jbD = null;
        public Object[] jbE = null;
        public boolean jbd = true;
        public boolean jbe = false;
        public boolean jbf = false;
        public boolean jbg = true;
        String jbh = "";
        public int jbi = 5;
        public boolean jbj = false;
        boolean jbk = false;
        public boolean jbl;
        public int jbm;
        boolean jbn;
        boolean jbo = false;
        public boolean jbp = false;
        public int jbq = 0;
        int jbr = 0;
        Drawable jbs = null;
        public int jbt = 0;
        public Drawable jbu = null;
        public String jbv = null;
        public SFSContext jbw = null;
        public float jbx = 0.0f;
        public boolean jby = false;
        boolean jbz = true;
        public String md5 = "";
        public String prefixPath = "";
        String thumbPath;

        public final a bdo() {
            this.jbd = true;
            return this;
        }

        public final a bdp() {
            this.jbf = true;
            return this;
        }

        public final a bdq() {
            this.jbe = true;
            return this;
        }

        public final a OS(String str) {
            this.fullPath = str;
            return this;
        }

        public final a OT(String str) {
            this.prefixPath = str;
            return this;
        }

        public final a bdr() {
            this.jbi = 1;
            return this;
        }

        public final a tw(int i2) {
            this.hZz = i2;
            return this;
        }

        public final a tx(int i2) {
            this.hZA = i2;
            return this;
        }

        public final a dr(int i2, int i3) {
            this.hZz = i2;
            this.hZA = i3;
            return this;
        }

        public final a ty(int i2) {
            this.jbq = i2;
            return this;
        }

        public final a x(Drawable drawable) {
            this.hZC = drawable;
            return this;
        }

        public final a tz(int i2) {
            this.jbt = i2;
            return this;
        }

        public final a bds() {
            this.hZF = true;
            return this;
        }

        public final a bdt() {
            this.iaT = true;
            return this;
        }

        public final a aw(float f2) {
            this.jbx = f2;
            return this;
        }

        public final a bdu() {
            this.jby = true;
            return this;
        }

        public final a a(SFSContext sFSContext) {
            this.jbw = sFSContext;
            return this;
        }

        public final a h(Object... objArr) {
            this.jbE = objArr;
            return this;
        }

        public final a a(com.tencent.mm.av.a.c.c cVar) {
            this.jaU = cVar;
            return this;
        }

        public final a a(com.tencent.mm.av.a.c.a aVar) {
            this.jbC = aVar;
            return this;
        }

        public final a OU(String str) {
            this.jbv = str;
            return this;
        }

        public final c bdv() {
            AppMethodBeat.i(130401);
            c cVar = new c(this, (byte) 0);
            AppMethodBeat.o(130401);
            return cVar;
        }
    }
}
