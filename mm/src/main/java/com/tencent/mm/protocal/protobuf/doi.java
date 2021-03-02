package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class doi extends a {
    public String AesKey;
    public String LxW;
    public String MD5;
    public String MEd;
    public String MEe;
    public String MQG;
    public String MRB;
    public float MRC;
    public String MRD;
    public String MRE;
    public String MRF;
    public String MRG;
    public String MRH;
    public float MRI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115967);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LxW == null) {
                b bVar = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(115967);
                throw bVar;
            } else if (this.AesKey == null) {
                b bVar2 = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(115967);
                throw bVar2;
            } else if (this.MEd == null) {
                b bVar3 = new b("Not all required fields were included: ThumbFileID");
                AppMethodBeat.o(115967);
                throw bVar3;
            } else if (this.MEe == null) {
                b bVar4 = new b("Not all required fields were included: ThumbAesKey");
                AppMethodBeat.o(115967);
                throw bVar4;
            } else if (this.MRD == null) {
                b bVar5 = new b("Not all required fields were included: ThumbMD5");
                AppMethodBeat.o(115967);
                throw bVar5;
            } else if (this.MRF == null) {
                b bVar6 = new b("Not all required fields were included: OriginThumbFileID");
                AppMethodBeat.o(115967);
                throw bVar6;
            } else if (this.MRG == null) {
                b bVar7 = new b("Not all required fields were included: OriginThumbAesKey");
                AppMethodBeat.o(115967);
                throw bVar7;
            } else if (this.MRH == null) {
                b bVar8 = new b("Not all required fields were included: OriginThumbMD5");
                AppMethodBeat.o(115967);
                throw bVar8;
            } else {
                if (this.LxW != null) {
                    aVar.e(1, this.LxW);
                }
                if (this.AesKey != null) {
                    aVar.e(2, this.AesKey);
                }
                if (this.MD5 != null) {
                    aVar.e(3, this.MD5);
                }
                if (this.MRB != null) {
                    aVar.e(4, this.MRB);
                }
                aVar.E(5, this.MRC);
                if (this.MEd != null) {
                    aVar.e(6, this.MEd);
                }
                if (this.MEe != null) {
                    aVar.e(7, this.MEe);
                }
                if (this.MRD != null) {
                    aVar.e(8, this.MRD);
                }
                if (this.MQG != null) {
                    aVar.e(9, this.MQG);
                }
                if (this.MRE != null) {
                    aVar.e(10, this.MRE);
                }
                if (this.MRF != null) {
                    aVar.e(11, this.MRF);
                }
                if (this.MRG != null) {
                    aVar.e(12, this.MRG);
                }
                if (this.MRH != null) {
                    aVar.e(13, this.MRH);
                }
                aVar.E(14, this.MRI);
                AppMethodBeat.o(115967);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.LxW != null ? g.a.a.b.b.a.f(1, this.LxW) + 0 : 0;
            if (this.AesKey != null) {
                f2 += g.a.a.b.b.a.f(2, this.AesKey);
            }
            if (this.MD5 != null) {
                f2 += g.a.a.b.b.a.f(3, this.MD5);
            }
            if (this.MRB != null) {
                f2 += g.a.a.b.b.a.f(4, this.MRB);
            }
            int fS = f2 + g.a.a.b.b.a.fS(5) + 4;
            if (this.MEd != null) {
                fS += g.a.a.b.b.a.f(6, this.MEd);
            }
            if (this.MEe != null) {
                fS += g.a.a.b.b.a.f(7, this.MEe);
            }
            if (this.MRD != null) {
                fS += g.a.a.b.b.a.f(8, this.MRD);
            }
            if (this.MQG != null) {
                fS += g.a.a.b.b.a.f(9, this.MQG);
            }
            if (this.MRE != null) {
                fS += g.a.a.b.b.a.f(10, this.MRE);
            }
            if (this.MRF != null) {
                fS += g.a.a.b.b.a.f(11, this.MRF);
            }
            if (this.MRG != null) {
                fS += g.a.a.b.b.a.f(12, this.MRG);
            }
            if (this.MRH != null) {
                fS += g.a.a.b.b.a.f(13, this.MRH);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(14) + 4;
            AppMethodBeat.o(115967);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LxW == null) {
                b bVar9 = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(115967);
                throw bVar9;
            } else if (this.AesKey == null) {
                b bVar10 = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(115967);
                throw bVar10;
            } else if (this.MEd == null) {
                b bVar11 = new b("Not all required fields were included: ThumbFileID");
                AppMethodBeat.o(115967);
                throw bVar11;
            } else if (this.MEe == null) {
                b bVar12 = new b("Not all required fields were included: ThumbAesKey");
                AppMethodBeat.o(115967);
                throw bVar12;
            } else if (this.MRD == null) {
                b bVar13 = new b("Not all required fields were included: ThumbMD5");
                AppMethodBeat.o(115967);
                throw bVar13;
            } else if (this.MRF == null) {
                b bVar14 = new b("Not all required fields were included: OriginThumbFileID");
                AppMethodBeat.o(115967);
                throw bVar14;
            } else if (this.MRG == null) {
                b bVar15 = new b("Not all required fields were included: OriginThumbAesKey");
                AppMethodBeat.o(115967);
                throw bVar15;
            } else if (this.MRH == null) {
                b bVar16 = new b("Not all required fields were included: OriginThumbMD5");
                AppMethodBeat.o(115967);
                throw bVar16;
            } else {
                AppMethodBeat.o(115967);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doi doi = (doi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doi.LxW = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 2:
                    doi.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 3:
                    doi.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 4:
                    doi.MRB = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 5:
                    doi.MRC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(115967);
                    return 0;
                case 6:
                    doi.MEd = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 7:
                    doi.MEe = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 8:
                    doi.MRD = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 9:
                    doi.MQG = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 10:
                    doi.MRE = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 11:
                    doi.MRF = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 12:
                    doi.MRG = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 13:
                    doi.MRH = aVar3.UbS.readString();
                    AppMethodBeat.o(115967);
                    return 0;
                case 14:
                    doi.MRI = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(115967);
                    return 0;
                default:
                    AppMethodBeat.o(115967);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115967);
            return -1;
        }
    }
}
