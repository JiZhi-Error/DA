package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class te extends dop {
    public String KEq;
    public String KEr;
    public String KEs;
    public String KHq;
    public int LbA;
    public SKBuiltinBuffer_t LbB;
    public float LbC;
    public float LbD;
    public String LbE;
    public int LbF;
    public int LbG;
    public int LbH;
    public int LbI;
    public String LbJ;
    public int LbK;
    public int LbL;
    public int LbM;
    public String LbN;
    public String Lby;
    public int Lbz;
    public int Scene;
    public String jfi;
    public String xNG;
    public String xNH;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152511);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lby != null) {
                aVar.e(1, this.Lby);
            }
            if (this.xNH != null) {
                aVar.e(2, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(3, this.xNG);
            }
            aVar.aM(4, this.Lbz);
            aVar.aM(5, this.LbA);
            if (this.KHq != null) {
                aVar.e(6, this.KHq);
            }
            if (this.LbB != null) {
                aVar.ni(7, this.LbB.computeSize());
                this.LbB.writeFields(aVar);
            }
            aVar.aM(8, this.Scene);
            aVar.E(9, this.LbC);
            aVar.E(10, this.LbD);
            if (this.LbE != null) {
                aVar.e(11, this.LbE);
            }
            aVar.aM(12, this.LbF);
            aVar.aM(13, this.LbG);
            aVar.aM(14, this.LbH);
            aVar.aM(15, this.LbI);
            if (this.LbJ != null) {
                aVar.e(16, this.LbJ);
            }
            aVar.aM(17, this.LbK);
            aVar.aM(18, this.LbL);
            aVar.aM(19, this.LbM);
            aVar.aM(20, this.xub);
            if (this.jfi != null) {
                aVar.e(21, this.jfi);
            }
            if (this.KEs != null) {
                aVar.e(22, this.KEs);
            }
            if (this.KEr != null) {
                aVar.e(23, this.KEr);
            }
            if (this.KEq != null) {
                aVar.e(24, this.KEq);
            }
            if (this.LbN != null) {
                aVar.e(25, this.LbN);
            }
            AppMethodBeat.o(152511);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Lby != null ? g.a.a.b.b.a.f(1, this.Lby) + 0 : 0;
            if (this.xNH != null) {
                f2 += g.a.a.b.b.a.f(2, this.xNH);
            }
            if (this.xNG != null) {
                f2 += g.a.a.b.b.a.f(3, this.xNG);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Lbz) + g.a.a.b.b.a.bu(5, this.LbA);
            if (this.KHq != null) {
                bu += g.a.a.b.b.a.f(6, this.KHq);
            }
            if (this.LbB != null) {
                bu += g.a.a.a.nh(7, this.LbB.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Scene) + g.a.a.b.b.a.fS(9) + 4 + g.a.a.b.b.a.fS(10) + 4;
            if (this.LbE != null) {
                bu2 += g.a.a.b.b.a.f(11, this.LbE);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.LbF) + g.a.a.b.b.a.bu(13, this.LbG) + g.a.a.b.b.a.bu(14, this.LbH) + g.a.a.b.b.a.bu(15, this.LbI);
            if (this.LbJ != null) {
                bu3 += g.a.a.b.b.a.f(16, this.LbJ);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(17, this.LbK) + g.a.a.b.b.a.bu(18, this.LbL) + g.a.a.b.b.a.bu(19, this.LbM) + g.a.a.b.b.a.bu(20, this.xub);
            if (this.jfi != null) {
                bu4 += g.a.a.b.b.a.f(21, this.jfi);
            }
            if (this.KEs != null) {
                bu4 += g.a.a.b.b.a.f(22, this.KEs);
            }
            if (this.KEr != null) {
                bu4 += g.a.a.b.b.a.f(23, this.KEr);
            }
            if (this.KEq != null) {
                bu4 += g.a.a.b.b.a.f(24, this.KEq);
            }
            if (this.LbN != null) {
                bu4 += g.a.a.b.b.a.f(25, this.LbN);
            }
            AppMethodBeat.o(152511);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152511);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            te teVar = (te) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    teVar.Lby = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 2:
                    teVar.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 3:
                    teVar.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 4:
                    teVar.Lbz = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 5:
                    teVar.LbA = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 6:
                    teVar.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar4))) {
                        }
                        teVar.LbB = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152511);
                    return 0;
                case 8:
                    teVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 9:
                    teVar.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(152511);
                    return 0;
                case 10:
                    teVar.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(152511);
                    return 0;
                case 11:
                    teVar.LbE = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 12:
                    teVar.LbF = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 13:
                    teVar.LbG = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 14:
                    teVar.LbH = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 15:
                    teVar.LbI = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 16:
                    teVar.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 17:
                    teVar.LbK = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 18:
                    teVar.LbL = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 19:
                    teVar.LbM = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 20:
                    teVar.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(152511);
                    return 0;
                case 21:
                    teVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 22:
                    teVar.KEs = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 23:
                    teVar.KEr = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 24:
                    teVar.KEq = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                case 25:
                    teVar.LbN = aVar3.UbS.readString();
                    AppMethodBeat.o(152511);
                    return 0;
                default:
                    AppMethodBeat.o(152511);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152511);
            return -1;
        }
    }
}
