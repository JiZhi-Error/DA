package oicq.wlogin_sdk.request;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d {
    protected static int Uct = 0;
    protected i UcA;
    int Ucl = 4096;
    int Ucm = 0;
    int Ucn = 27;
    int Uco = 0;
    public int Ucp = 15;
    protected int Ucq = 0;
    protected byte[] Ucr = new byte[this.Ucl];
    protected int Ucs = TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC;
    protected int Ucu = 0;
    protected int Ucv = 0;
    protected int Ucw = 0;
    protected int Ucx = 0;
    protected int Ucy = 0;
    byte Ucz;

    public d() {
        AppMethodBeat.i(88066);
        AppMethodBeat.o(88066);
    }

    public final void a(int i2, int i3, long j2, int i4, int i5, int i6, int i7, byte[] bArr) {
        AppMethodBeat.i(88067);
        int length = bArr.length;
        int i8 = Uct + 1;
        Uct = i8;
        this.Ucm = 0;
        util.ag(this.Ucr, this.Ucm, 2);
        this.Ucm++;
        util.ah(this.Ucr, this.Ucm, this.Ucn + 2 + length);
        this.Ucm += 2;
        util.ah(this.Ucr, this.Ucm, i2);
        this.Ucm += 2;
        util.ah(this.Ucr, this.Ucm, i3);
        this.Ucm += 2;
        util.ah(this.Ucr, this.Ucm, i8);
        this.Ucm += 2;
        util.ai(this.Ucr, this.Ucm, (int) j2);
        this.Ucm += 4;
        util.ag(this.Ucr, this.Ucm, 3);
        this.Ucm++;
        util.ag(this.Ucr, this.Ucm, 0);
        this.Ucm++;
        util.ag(this.Ucr, this.Ucm, i4);
        this.Ucm++;
        util.ai(this.Ucr, this.Ucm, i5);
        this.Ucm += 4;
        util.ai(this.Ucr, this.Ucm, i6);
        this.Ucm += 4;
        util.ai(this.Ucr, this.Ucm, i7);
        this.Ucm += 4;
        if (this.Ucm + length + 1 > this.Ucl) {
            this.Ucl = this.Ucm + length + 1 + 128;
            byte[] bArr2 = new byte[this.Ucl];
            System.arraycopy(this.Ucr, 0, bArr2, 0, this.Ucm);
            this.Ucr = bArr2;
        }
        System.arraycopy(bArr, 0, this.Ucr, this.Ucm, length);
        this.Ucm = length + this.Ucm;
        util.ag(this.Ucr, this.Ucm, 3);
        this.Ucm++;
        AppMethodBeat.o(88067);
    }

    public final int ai(byte[] bArr, int i2) {
        char c2 = 0;
        AppMethodBeat.i(88068);
        if (i2 <= this.Ucp + 2) {
            AppMethodBeat.o(88068);
            return -1009;
        }
        this.Ucq = (i2 - this.Ucp) - 2;
        if (i2 > this.Ucl) {
            this.Ucl = i2 + 128;
            this.Ucr = new byte[this.Ucl];
        }
        this.Ucm = i2;
        System.arraycopy(bArr, 0, this.Ucr, 0, i2);
        byte[] bArr2 = this.Ucr;
        int i3 = this.Ucp + 1;
        byte[] decrypt = oicq.wlogin_sdk.tools.d.decrypt(bArr2, i3, this.Ucq, this.UcA.UcE);
        if (decrypt == null) {
            c2 = 64534;
        } else {
            this.Ucq = decrypt.length;
            if (decrypt.length + this.Ucp + 2 > this.Ucl) {
                this.Ucl = decrypt.length + this.Ucp + 2;
                byte[] bArr3 = new byte[this.Ucl];
                System.arraycopy(this.Ucr, 0, bArr3, 0, this.Ucm);
                this.Ucr = bArr3;
            }
            this.Ucm = 0;
            System.arraycopy(decrypt, 0, this.Ucr, i3, decrypt.length);
            this.Ucm = decrypt.length + this.Ucp + 2 + this.Ucm;
        }
        if (c2 < 0) {
            AppMethodBeat.o(88068);
            return -1002;
        }
        int ac = ac(this.Ucr, this.Ucp + 1, this.Ucq);
        AppMethodBeat.o(88068);
        return ac;
    }

    public final byte[] hPx() {
        AppMethodBeat.i(88069);
        byte[] bArr = new byte[this.Ucm];
        System.arraycopy(this.Ucr, 0, bArr, 0, this.Ucm);
        AppMethodBeat.o(88069);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final byte[] aa(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(88070);
        byte[] bArr2 = new byte[(bArr.length + 4)];
        util.ah(bArr2, 0, i2);
        util.ah(bArr2, 2, i3);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        byte[] a2 = oicq.wlogin_sdk.tools.d.a(bArr2, bArr2.length, this.UcA.UcE);
        byte[] bArr3 = new byte[(a2.length + this.UcA.UcE.length)];
        System.arraycopy(this.UcA.UcE, 0, bArr3, 0, this.UcA.UcE.length);
        System.arraycopy(a2, 0, bArr3, this.UcA.UcE.length, a2.length);
        AppMethodBeat.o(88070);
        return bArr3;
    }

    public final int aj(byte[] bArr, int i2) {
        this.Ucz = bArr[i2];
        return bArr[i2] & 255;
    }

    public final void ab(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(88071);
        ai aiVar = new ai();
        if (aiVar.af(bArr, i2, i3) >= 0) {
            ErrMsg errMsg = this.UcA.Uda;
            byte[] bArr2 = new byte[aiVar.UdP];
            System.arraycopy(aiVar.Ucr, aiVar.Udg + 6, bArr2, 0, aiVar.UdP);
            errMsg.title = new String(bArr2);
            ErrMsg errMsg2 = this.UcA.Uda;
            byte[] bArr3 = new byte[aiVar.UdQ];
            System.arraycopy(aiVar.Ucr, aiVar.Udg + 8 + aiVar.UdP, bArr3, 0, aiVar.UdQ);
            errMsg2.message = new String(bArr3);
            ErrMsg errMsg3 = this.UcA.Uda;
            byte[] bArr4 = new byte[aiVar.UdR];
            System.arraycopy(aiVar.Ucr, aiVar.Udg + 12 + aiVar.UdP + aiVar.UdQ, bArr4, 0, aiVar.UdR);
            errMsg3.UdY = new String(bArr4);
            AppMethodBeat.o(88071);
            return;
        }
        this.UcA.Uda.hPF();
        AppMethodBeat.o(88071);
    }

    public final void hPy() {
        AppMethodBeat.i(88072);
        this.UcA.Uda.hPF();
        AppMethodBeat.o(88072);
    }

    public final byte[] dl(byte[] bArr) {
        AppMethodBeat.i(88073);
        if (bArr == null) {
            AppMethodBeat.o(88073);
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.UcA.UcC.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.UcA.UcC, 0, bArr2, bArr.length, this.UcA.UcC.length);
        AppMethodBeat.o(88073);
        return bArr2;
    }

    public final byte[] dm(byte[] bArr) {
        AppMethodBeat.i(88074);
        if (bArr == null || bArr.length < 16) {
            AppMethodBeat.o(88074);
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        this.UcA.UcC = new byte[16];
        System.arraycopy(bArr2, length, this.UcA.UcC, 0, 16);
        AppMethodBeat.o(88074);
        return bArr3;
    }

    public int ac(byte[] bArr, int i2, int i3) {
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        byte[] bArr2;
        AppMethodBeat.i(88075);
        f fVar = new f();
        g gVar = new g();
        s sVar = new s();
        if (this.Ucx == 2064 && this.Ucy == 9) {
            z = false;
        } else if (this.Ucx == 2064 && this.Ucy == 10) {
            z = true;
        } else if (this.Ucx == 2064 && this.Ucy == 2) {
            z = true;
        } else if (this.Ucx == 2064 && this.Ucy == 13) {
            z = true;
        } else {
            AppMethodBeat.o(88075);
            return -1012;
        }
        if (i3 < 5) {
            AppMethodBeat.o(88075);
            return -1009;
        }
        int aj = aj(bArr, i2 + 2);
        hPy();
        int i4 = i2 + 5;
        switch (aj) {
            case 0:
                if (!z) {
                    aj = sVar.c(bArr, i4, (this.Ucm - i4) - 1, this.UcA.UcC);
                } else if (this.UcA.UcD == null) {
                    AppMethodBeat.o(88075);
                    return -1006;
                } else {
                    aj = sVar.c(bArr, i4, (this.Ucm - i4) - 1, this.UcA.UcD);
                }
                if (aj >= 0) {
                    long j6 = Util.MAX_32BIT_VALUE;
                    o oVar = new o();
                    p pVar = new p();
                    l lVar = new l();
                    q qVar = new q();
                    e eVar = new e();
                    t tVar = new t();
                    oicq.wlogin_sdk.a.d dVar = new oicq.wlogin_sdk.a.d();
                    m mVar = new m();
                    u uVar = new u();
                    w wVar = new w();
                    x xVar = new x();
                    j jVar = new j();
                    h hVar = new h();
                    n nVar = new n();
                    z zVar = new z();
                    v vVar = new v();
                    ad adVar = new ad();
                    ab abVar = new ab();
                    af afVar = new af();
                    ap apVar = new ap();
                    ak akVar = new ak();
                    al alVar = new al();
                    am amVar = new am();
                    byte[] bArr3 = null;
                    byte[] bArr4 = null;
                    byte[] bArr5 = null;
                    byte[] bArr6 = null;
                    byte[] bArr7 = null;
                    byte[] bArr8 = null;
                    byte[] bArr9 = null;
                    byte[] bArr10 = null;
                    ac acVar = new ac();
                    byte[] hPA = sVar.hPA();
                    int length = hPA.length;
                    oVar.af(hPA, 2, length);
                    pVar.af(hPA, 2, length);
                    lVar.af(hPA, 2, length);
                    qVar.af(hPA, 2, length);
                    aj = tVar.af(hPA, 2, length);
                    if (aj >= 0) {
                        if (eVar.af(hPA, 2, length) >= 0) {
                            bArr8 = eVar.hPA();
                        }
                        if (jVar.af(hPA, 2, length) >= 0) {
                            util.a(this.UcA._context, jVar.hPA());
                        }
                        if (dVar.af(hPA, 2, length) >= 0) {
                            bArr3 = dVar.hPA();
                        }
                        if (mVar.af(hPA, 2, length) >= 0) {
                            bArr4 = mVar.hPA();
                        }
                        if (uVar.af(hPA, 2, length) >= 0) {
                            bArr5 = uVar.hPA();
                        }
                        if (wVar.af(hPA, 2, length) >= 0) {
                            bArr6 = wVar.hPA();
                        }
                        if (xVar.af(hPA, 2, length) >= 0) {
                            bArr7 = xVar.hPA();
                        }
                        if (zVar.af(hPA, 2, length) >= 0) {
                            bArr9 = new byte[zVar.UdF];
                            System.arraycopy(zVar.Ucr, zVar.Udg + 2, bArr9, 0, bArr9.length);
                            bArr10 = new byte[zVar.UdG];
                            System.arraycopy(zVar.Ucr, zVar.Udg + 2 + zVar.UdF + 2, bArr10, 0, bArr10.length);
                        }
                        if (alVar.af(hPA, 2, length) >= 0) {
                            h hVar2 = new h();
                            n nVar2 = new n();
                            am amVar2 = new am();
                            ah ahVar = new ah();
                            byte[] hPA2 = alVar.hPA();
                            int length2 = hPA2.length;
                            if (hVar2.af(hPA2, 2, length2) < 0) {
                                bArr2 = null;
                            } else if (nVar2.af(hPA2, 2, length2) < 0) {
                                bArr2 = null;
                            } else if (amVar2.af(hPA2, 2, length2) < 0) {
                                bArr2 = null;
                            } else {
                                byte[] hPx = hVar2.hPx();
                                byte[] hPx2 = nVar2.hPx();
                                byte[] hPx3 = amVar2.hPx();
                                byte[] ds = ahVar.ds(this.UcA.UcL);
                                byte[] bArr11 = new byte[(hPx.length + 3 + hPx2.length + hPx3.length + ds.length)];
                                bArr11[0] = 64;
                                util.ah(bArr11, 1, 4);
                                System.arraycopy(hPx, 0, bArr11, 3, hPx.length);
                                int length3 = hPx.length + 3;
                                System.arraycopy(hPx2, 0, bArr11, length3, hPx2.length);
                                int length4 = hPx2.length + length3;
                                System.arraycopy(hPx3, 0, bArr11, length4, hPx3.length);
                                System.arraycopy(ds, 0, bArr11, length4 + hPx3.length, ds.length);
                                bArr2 = bArr11;
                            }
                            if (bArr2 == null || bArr2.length <= 0) {
                                this.UcA.Udd = new byte[0];
                            } else {
                                this.UcA.Udd = (byte[]) bArr2.clone();
                                util.oF("fast data:", util.dw(bArr2));
                            }
                        }
                        byte[][] bArr12 = (byte[][]) Array.newInstance(Byte.TYPE, 7, 0);
                        if (acVar.af(hPA, 2, length) >= 0) {
                            bArr12[0] = acVar.hPA();
                        }
                        int af = nVar.af(hPA, 2, length);
                        if (hVar.af(hPA, 2, length) >= 0 && af >= 0) {
                            this.UcA.UcC = nVar.hPA();
                            this.UcA.Udb = dl(hVar.hPA());
                            bArr12[1] = (byte[]) this.UcA.Udb.clone();
                        }
                        if (abVar.af(hPA, 2, length) >= 0) {
                            byte[] bArr13 = new byte[abVar.UdI];
                            System.arraycopy(abVar.Ucr, abVar.Udg + 2, bArr13, 0, bArr13.length);
                            bArr12[2] = bArr13;
                        }
                        if (afVar.af(hPA, 2, length) >= 0) {
                            bArr12[3] = afVar.hPA();
                        }
                        if (apVar.af(hPA, 2, length) >= 0) {
                            bArr12[4] = apVar.hPA();
                        }
                        if (akVar.af(hPA, 2, length) >= 0) {
                            bArr12[5] = akVar.hPA();
                        }
                        if (amVar.af(hPA, 2, length) >= 0) {
                            bArr12[6] = amVar.hPA();
                        }
                        if (vVar.af(hPA, 2, length) >= 0) {
                            if (this.UcA.UcJ == -1) {
                                j5 = (long) util.ao(vVar.Ucr, vVar.Udg);
                            } else {
                                j5 = this.UcA.UcJ;
                            }
                            j6 = Util.MAX_32BIT_VALUE & ((long) util.ao(vVar.Ucr, vVar.Udg + 4));
                            j2 = j5;
                        } else {
                            j2 = 3600;
                        }
                        if (adVar.af(hPA, 2, length) < 0 || adVar.hPE() == 0) {
                            j3 = 2160000;
                        } else {
                            j3 = (long) adVar.hPE();
                        }
                        if (j3 < j2) {
                            j4 = j2;
                        } else {
                            j4 = j3;
                        }
                        byte[] bArr14 = new byte[2];
                        System.arraycopy(tVar.Ucr, tVar.Udg, bArr14, 0, 2);
                        byte[] bArr15 = new byte[1];
                        System.arraycopy(tVar.Ucr, tVar.Udg + 2, bArr15, 0, 1);
                        byte[] bArr16 = new byte[1];
                        System.arraycopy(tVar.Ucr, tVar.Udg + 2 + 1, bArr16, 0, 1);
                        byte[] bArr17 = new byte[tVar.UdD];
                        System.arraycopy(tVar.Ucr, tVar.Udg + 2 + 1 + 1 + 1, bArr17, 0, tVar.UdD);
                        this.UcA.a(this.UcA._uin, this.UcA.UcH, j6, i.hPz(), j2 + i.hPz(), j4 + i.hPz(), bArr14, bArr15, bArr16, bArr17, lVar.hPA(), oVar.hPA(), qVar.hPA(), pVar.hPA(), bArr8, bArr4, bArr3, bArr5, bArr6, bArr7, bArr9, bArr10, bArr12);
                        aj = 0;
                    }
                    if (aj >= 0) {
                        aj = 0;
                        break;
                    } else {
                        util.buY("parse 119 failed, ret=".concat(String.valueOf(aj)));
                        break;
                    }
                } else {
                    util.buY("119 can not decrypt, ret=".concat(String.valueOf(aj)));
                    break;
                }
                break;
            case 1:
                ab(bArr, i4, (this.Ucm - i4) - 1);
                break;
            case 2:
                int af2 = fVar.af(bArr, i4, (this.Ucm - i4) - 1);
                if (af2 >= 0) {
                    this.UcA.UcF = fVar;
                    af2 = gVar.af(bArr, i4, (this.Ucm - i4) - 1);
                    if (af2 >= 0) {
                        this.UcA.UcG = gVar;
                        break;
                    }
                }
                aj = af2;
                break;
            default:
                ab(bArr, i4, (this.Ucm - i4) - 1);
                break;
        }
        AppMethodBeat.o(88075);
        return aj;
    }
}
