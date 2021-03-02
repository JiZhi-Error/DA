package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ait extends a {
    public String ActivityID;
    public String AesKey;
    public String EncryptUrl;
    public String ExternMd5;
    public String ExternUrl;
    public String Lsl;
    public String Lsm;
    public String Lsn;
    public String Lso;
    public String Md5;
    public String ProductID;
    public String ThumbUrl;
    public String Url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104759);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Md5 == null) {
                b bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(104759);
                throw bVar;
            }
            if (this.Md5 != null) {
                aVar.e(1, this.Md5);
            }
            if (this.Url != null) {
                aVar.e(2, this.Url);
            }
            if (this.ThumbUrl != null) {
                aVar.e(3, this.ThumbUrl);
            }
            if (this.Lsl != null) {
                aVar.e(4, this.Lsl);
            }
            if (this.EncryptUrl != null) {
                aVar.e(5, this.EncryptUrl);
            }
            if (this.AesKey != null) {
                aVar.e(6, this.AesKey);
            }
            if (this.ProductID != null) {
                aVar.e(7, this.ProductID);
            }
            if (this.ExternUrl != null) {
                aVar.e(8, this.ExternUrl);
            }
            if (this.ExternMd5 != null) {
                aVar.e(9, this.ExternMd5);
            }
            if (this.ActivityID != null) {
                aVar.e(10, this.ActivityID);
            }
            if (this.Lsm != null) {
                aVar.e(11, this.Lsm);
            }
            if (this.Lsn != null) {
                aVar.e(12, this.Lsn);
            }
            if (this.Lso != null) {
                aVar.e(13, this.Lso);
            }
            AppMethodBeat.o(104759);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Md5 != null ? g.a.a.b.b.a.f(1, this.Md5) + 0 : 0;
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(2, this.Url);
            }
            if (this.ThumbUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.Lsl != null) {
                f2 += g.a.a.b.b.a.f(4, this.Lsl);
            }
            if (this.EncryptUrl != null) {
                f2 += g.a.a.b.b.a.f(5, this.EncryptUrl);
            }
            if (this.AesKey != null) {
                f2 += g.a.a.b.b.a.f(6, this.AesKey);
            }
            if (this.ProductID != null) {
                f2 += g.a.a.b.b.a.f(7, this.ProductID);
            }
            if (this.ExternUrl != null) {
                f2 += g.a.a.b.b.a.f(8, this.ExternUrl);
            }
            if (this.ExternMd5 != null) {
                f2 += g.a.a.b.b.a.f(9, this.ExternMd5);
            }
            if (this.ActivityID != null) {
                f2 += g.a.a.b.b.a.f(10, this.ActivityID);
            }
            if (this.Lsm != null) {
                f2 += g.a.a.b.b.a.f(11, this.Lsm);
            }
            if (this.Lsn != null) {
                f2 += g.a.a.b.b.a.f(12, this.Lsn);
            }
            if (this.Lso != null) {
                f2 += g.a.a.b.b.a.f(13, this.Lso);
            }
            AppMethodBeat.o(104759);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Md5 == null) {
                b bVar2 = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(104759);
                throw bVar2;
            }
            AppMethodBeat.o(104759);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ait ait = (ait) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ait.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 2:
                    ait.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 3:
                    ait.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 4:
                    ait.Lsl = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 5:
                    ait.EncryptUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 6:
                    ait.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 7:
                    ait.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 8:
                    ait.ExternUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 9:
                    ait.ExternMd5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 10:
                    ait.ActivityID = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 11:
                    ait.Lsm = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 12:
                    ait.Lsn = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                case 13:
                    ait.Lso = aVar3.UbS.readString();
                    AppMethodBeat.o(104759);
                    return 0;
                default:
                    AppMethodBeat.o(104759);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104759);
            return -1;
        }
    }
}
