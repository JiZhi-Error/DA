package com.google.b.c.a;

import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.smtt.sdk.TbsListener;

public class k {
    static final k[] cdM;
    private static k[] cdN;
    private final boolean cdO;
    final int cdP;
    final int cdQ;
    public final int cdR;
    public final int cdS;
    private final int cdT;
    private final int cdU;
    final int cdV;

    static {
        AppMethodBeat.i(12377);
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 68), new k(false, 816, 336, 24, 24, 16, r.CTRL_INDEX, 56), new k(false, 1050, 408, 18, 18, 36, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 68), new k(false, 1304, m.CTRL_INDEX, 20, 20, 36, TbsListener.ErrorCode.STARTDOWNLOAD_4, 62), new d()};
        cdM = kVarArr;
        cdN = kVarArr;
        AppMethodBeat.o(12377);
    }

    private k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.cdO = z;
        this.cdP = i2;
        this.cdQ = i3;
        this.cdR = i4;
        this.cdS = i5;
        this.cdT = i6;
        this.cdU = i7;
        this.cdV = i8;
    }

    public static k a(int i2, l lVar, b bVar, b bVar2) {
        AppMethodBeat.i(12369);
        k[] kVarArr = cdN;
        for (k kVar : kVarArr) {
            if ((lVar != l.FORCE_SQUARE || !kVar.cdO) && ((lVar != l.FORCE_RECTANGLE || kVar.cdO) && ((bVar == null || (kVar.Iv() >= bVar.width && kVar.Iw() >= bVar.height)) && ((bVar2 == null || (kVar.Iv() <= bVar2.width && kVar.Iw() <= bVar2.height)) && i2 <= kVar.cdP)))) {
                AppMethodBeat.o(12369);
                return kVar;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(12369);
        throw illegalArgumentException;
    }

    private int Ir() {
        AppMethodBeat.i(12370);
        switch (this.cdT) {
            case 1:
                AppMethodBeat.o(12370);
                return 1;
            case 2:
            case 4:
                AppMethodBeat.o(12370);
                return 2;
            case 16:
                AppMethodBeat.o(12370);
                return 4;
            case 36:
                AppMethodBeat.o(12370);
                return 6;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                AppMethodBeat.o(12370);
                throw illegalStateException;
        }
    }

    private int Is() {
        AppMethodBeat.i(12371);
        switch (this.cdT) {
            case 1:
            case 2:
                AppMethodBeat.o(12371);
                return 1;
            case 4:
                AppMethodBeat.o(12371);
                return 2;
            case 16:
                AppMethodBeat.o(12371);
                return 4;
            case 36:
                AppMethodBeat.o(12371);
                return 6;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                AppMethodBeat.o(12371);
                throw illegalStateException;
        }
    }

    public final int It() {
        AppMethodBeat.i(12372);
        int Ir = Ir() * this.cdR;
        AppMethodBeat.o(12372);
        return Ir;
    }

    public final int Iu() {
        AppMethodBeat.i(12373);
        int Is = Is() * this.cdS;
        AppMethodBeat.o(12373);
        return Is;
    }

    public final int Iv() {
        AppMethodBeat.i(12374);
        int It = It() + (Ir() << 1);
        AppMethodBeat.o(12374);
        return It;
    }

    public final int Iw() {
        AppMethodBeat.i(12375);
        int Iu = Iu() + (Is() << 1);
        AppMethodBeat.o(12375);
        return Iu;
    }

    public int Ik() {
        return this.cdP / this.cdU;
    }

    public int hh(int i2) {
        return this.cdU;
    }

    public final String toString() {
        AppMethodBeat.i(12376);
        String str = (this.cdO ? "Rectangular Symbol:" : "Square Symbol:") + " data region " + this.cdR + 'x' + this.cdS + ", symbol size " + Iv() + 'x' + Iw() + ", symbol data size " + It() + 'x' + Iu() + ", codewords " + this.cdP + '+' + this.cdQ;
        AppMethodBeat.o(12376);
        return str;
    }
}
