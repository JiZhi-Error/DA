package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a {
    public static final byte[] oJy = {68, 88, 68, 73, 70, 70};
    public int SiA;
    public int SiB;
    public int SiC;
    public int SiD;
    public int SiE;
    public int SiF;
    public int SiG;
    public int SiH;
    public int SiI;
    public int SiJ;
    public int SiK;
    public int SiL;
    public int SiM;
    public int SiN;
    public int SiO;
    public int SiP;
    public byte[] SiQ;
    public final com.tencent.tinker.a.a.a.a Siv;
    private short Siw;
    public int Six;
    private int Siy;
    public int Siz;

    public a(InputStream inputStream) {
        this.Siv = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.r(inputStream)));
        byte[] arM = this.Siv.arM(oJy.length);
        if (c.p(arM, oJy) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(arM));
        }
        this.Siw = this.Siv.aKP.getShort();
        if (c.a(this.Siw, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + ((int) this.Siw) + ", expected: 2");
        }
        this.Six = this.Siv.aKP.getInt();
        this.Siy = this.Siv.aKP.getInt();
        this.Siz = this.Siv.aKP.getInt();
        this.SiA = this.Siv.aKP.getInt();
        this.SiB = this.Siv.aKP.getInt();
        this.SiC = this.Siv.aKP.getInt();
        this.SiD = this.Siv.aKP.getInt();
        this.SiE = this.Siv.aKP.getInt();
        this.SiF = this.Siv.aKP.getInt();
        this.SiG = this.Siv.aKP.getInt();
        this.SiH = this.Siv.aKP.getInt();
        this.SiI = this.Siv.aKP.getInt();
        this.SiJ = this.Siv.aKP.getInt();
        this.SiK = this.Siv.aKP.getInt();
        this.SiL = this.Siv.aKP.getInt();
        this.SiM = this.Siv.aKP.getInt();
        this.SiN = this.Siv.aKP.getInt();
        this.SiO = this.Siv.aKP.getInt();
        this.SiP = this.Siv.aKP.getInt();
        this.SiQ = this.Siv.arM(20);
        com.tencent.tinker.a.a.a.a aVar = this.Siv;
        aVar.aKP.position(this.Siy);
    }
}
