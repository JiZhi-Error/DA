package com.tencent.tinker.c.a;

import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.c.a.a.a.i;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class a {
    private i<r> ShA;
    private i<Integer> ShB;
    private i<q> ShC;
    private i<n> ShD;
    private i<p> ShE;
    private i<f> ShF;
    private i<t> ShG;
    private i<c> ShH;
    private i<b> ShI;
    private i<e> ShJ;
    private i<g> ShK;
    private i<h> ShL;
    private i<com.tencent.tinker.a.a.a> ShM;
    private i<k> ShN;
    private i<d> ShO;
    private final com.tencent.tinker.a.a.i Shw;
    private final com.tencent.tinker.a.a.i Shx;
    private final com.tencent.tinker.c.a.b.a Shy;
    private final com.tencent.tinker.c.a.c.c Shz;

    public a(InputStream inputStream, InputStream inputStream2) {
        this(new com.tencent.tinker.a.a.i(inputStream), new com.tencent.tinker.c.a.b.a(inputStream2));
    }

    private a(com.tencent.tinker.a.a.i iVar, com.tencent.tinker.c.a.b.a aVar) {
        this.Shw = iVar;
        this.Shy = aVar;
        this.Shx = new com.tencent.tinker.a.a.i(aVar.Six);
        this.Shz = new com.tencent.tinker.c.a.c.c();
    }

    public final void c(OutputStream outputStream) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        byte[] Ea = this.Shw.Ea(false);
        if (Ea == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.Shy == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            byte[] bArr = this.Shy.SiQ;
            if (com.tencent.tinker.a.a.b.c.p(Ea, bArr) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", Arrays.toString(Ea), Arrays.toString(bArr)));
            }
            s sVar = this.Shx.Sgk;
            sVar.SgE.off = 0;
            sVar.SgE.size = 1;
            sVar.SgL.size = 1;
            sVar.SgF.off = this.Shy.Siz;
            sVar.SgG.off = this.Shy.SiA;
            sVar.SgM.off = this.Shy.SiG;
            sVar.SgH.off = this.Shy.SiB;
            sVar.SgI.off = this.Shy.SiC;
            sVar.SgJ.off = this.Shy.SiD;
            sVar.SgK.off = this.Shy.SiE;
            sVar.SgL.off = this.Shy.SiF;
            sVar.SgR.off = this.Shy.SiL;
            sVar.SgT.off = this.Shy.SiN;
            sVar.SgO.off = this.Shy.SiI;
            sVar.SgN.off = this.Shy.SiH;
            sVar.SgV.off = this.Shy.SiP;
            sVar.SgU.off = this.Shy.SiO;
            sVar.SgS.off = this.Shy.SiM;
            sVar.SgQ.off = this.Shy.SiK;
            sVar.SgP.off = this.Shy.SiJ;
            sVar.fileSize = this.Shy.Six;
            Arrays.sort(sVar.SgW);
            sVar.hoR();
            this.ShA = new com.tencent.tinker.c.a.a.a.n(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShB = new o(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShC = new l(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShD = new j(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShE = new com.tencent.tinker.c.a.a.a.k(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShF = new com.tencent.tinker.c.a.a.a.f(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShG = new com.tencent.tinker.c.a.a.a.p(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShH = new com.tencent.tinker.c.a.a.a.b(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShI = new com.tencent.tinker.c.a.a.a.c(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShJ = new com.tencent.tinker.c.a.a.a.e(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShK = new com.tencent.tinker.c.a.a.a.g(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShL = new com.tencent.tinker.c.a.a.a.h(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShM = new com.tencent.tinker.c.a.a.a.a(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShN = new m(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShO = new com.tencent.tinker.c.a.a.a.d(this.Shy, this.Shw, this.Shx, this.Shz);
            this.ShA.execute();
            this.ShB.execute();
            this.ShG.execute();
            this.ShC.execute();
            this.ShD.execute();
            this.ShE.execute();
            this.ShM.execute();
            this.ShI.execute();
            this.ShH.execute();
            this.ShO.execute();
            this.ShL.execute();
            this.ShK.execute();
            this.ShJ.execute();
            this.ShN.execute();
            this.ShF.execute();
            i.e arH = this.Shx.arH(sVar.SgE.off);
            arH.write(("dex\n" + "035" + "\u0000").getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            arH.writeInt(sVar.jvw);
            arH.write(sVar.yRs);
            arH.writeInt(sVar.fileSize);
            arH.writeInt(112);
            arH.writeInt(305419896);
            arH.writeInt(sVar.SgX);
            arH.writeInt(sVar.SgY);
            arH.writeInt(sVar.SgL.off);
            arH.writeInt(sVar.SgF.size);
            arH.writeInt(sVar.SgF.exists() ? sVar.SgF.off : 0);
            arH.writeInt(sVar.SgG.size);
            if (sVar.SgG.exists()) {
                i2 = sVar.SgG.off;
            } else {
                i2 = 0;
            }
            arH.writeInt(i2);
            arH.writeInt(sVar.SgH.size);
            if (sVar.SgH.exists()) {
                i3 = sVar.SgH.off;
            } else {
                i3 = 0;
            }
            arH.writeInt(i3);
            arH.writeInt(sVar.SgI.size);
            if (sVar.SgI.exists()) {
                i4 = sVar.SgI.off;
            } else {
                i4 = 0;
            }
            arH.writeInt(i4);
            arH.writeInt(sVar.SgJ.size);
            if (sVar.SgJ.exists()) {
                i5 = sVar.SgJ.off;
            } else {
                i5 = 0;
            }
            arH.writeInt(i5);
            arH.writeInt(sVar.SgK.size);
            if (sVar.SgK.exists()) {
                i6 = sVar.SgK.off;
            }
            arH.writeInt(i6);
            arH.writeInt(sVar.dataSize);
            arH.writeInt(sVar.SgZ);
            sVar.b(this.Shx.arH(sVar.SgL.off));
            this.Shx.hot();
            outputStream.write(this.Shx.aKP.array());
            outputStream.flush();
        }
    }
}
