package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class PackThumbExt extends a {
    public String ActivityID;
    public String AesKey;
    public String CDNUrl;
    public String Desc;
    public String EncryptUrl;
    public String ExternMd5;
    public String ExternUrl;
    public String Md5;
    public String PreviewUrl;
    public String ThumbUrl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104824);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.PreviewUrl != null) {
                aVar.e(1, this.PreviewUrl);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            if (this.Md5 != null) {
                aVar.e(3, this.Md5);
            }
            if (this.AesKey != null) {
                aVar.e(4, this.AesKey);
            }
            if (this.CDNUrl != null) {
                aVar.e(5, this.CDNUrl);
            }
            if (this.ThumbUrl != null) {
                aVar.e(6, this.ThumbUrl);
            }
            if (this.EncryptUrl != null) {
                aVar.e(7, this.EncryptUrl);
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
            AppMethodBeat.o(104824);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.PreviewUrl != null ? g.a.a.b.b.a.f(1, this.PreviewUrl) + 0 : 0;
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.Md5 != null) {
                f2 += g.a.a.b.b.a.f(3, this.Md5);
            }
            if (this.AesKey != null) {
                f2 += g.a.a.b.b.a.f(4, this.AesKey);
            }
            if (this.CDNUrl != null) {
                f2 += g.a.a.b.b.a.f(5, this.CDNUrl);
            }
            if (this.ThumbUrl != null) {
                f2 += g.a.a.b.b.a.f(6, this.ThumbUrl);
            }
            if (this.EncryptUrl != null) {
                f2 += g.a.a.b.b.a.f(7, this.EncryptUrl);
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
            AppMethodBeat.o(104824);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104824);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            PackThumbExt packThumbExt = (PackThumbExt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    packThumbExt.PreviewUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 2:
                    packThumbExt.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 3:
                    packThumbExt.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 4:
                    packThumbExt.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 5:
                    packThumbExt.CDNUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 6:
                    packThumbExt.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 7:
                    packThumbExt.EncryptUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 8:
                    packThumbExt.ExternUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 9:
                    packThumbExt.ExternMd5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                case 10:
                    packThumbExt.ActivityID = aVar3.UbS.readString();
                    AppMethodBeat.o(104824);
                    return 0;
                default:
                    AppMethodBeat.o(104824);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104824);
            return -1;
        }
    }
}
