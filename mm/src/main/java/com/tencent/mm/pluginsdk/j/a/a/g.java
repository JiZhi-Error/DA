package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.pluginsdk.j.a.c.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class g extends com.tencent.mm.pluginsdk.j.a.c.a {
    final long IBJ;
    final byte[] JYY;
    final boolean JYZ;
    private final String JYv;
    final int JYw;
    private final byte[] JYx;
    private final String JYz;
    final boolean JZa;
    private final int JZb;
    final int dEO;
    private final boolean dEQ;
    final String dER;
    final boolean dEU;
    final long fileSize;
    final int subType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, int i2, int i3, int i4, long j2, String str3, int i5, int i6, long j3, String str4, byte[] bArr, String str5, boolean z, boolean z2, String str6, int i7, int i8, byte[] bArr2, long j4, boolean z3, boolean z4, int i9) {
        super(str, str2, String.valueOf(i2), i3, i4, i.aee(str2), j2, str3, "CheckResUpdate", z3 ? "NewXml" : "CGI", i9);
        AppMethodBeat.i(151959);
        this.dEO = i5;
        this.subType = i6;
        this.IBJ = j3;
        this.JYz = str4;
        this.JYx = bArr;
        this.dER = str5;
        this.JYZ = z;
        this.JZa = z2;
        this.JYv = str6;
        this.JYw = i7;
        this.JZb = i8;
        this.JYY = bArr2;
        this.fileSize = j4;
        this.dEU = z3;
        this.dEQ = z4;
        AppMethodBeat.o(151959);
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.a
    public final String toString() {
        AppMethodBeat.i(151960);
        String str = "CheckResUpdateRequest | fileUpdated=" + this.dEQ + ", resType=" + this.dEO + ", subType=" + this.subType + ", reportId=" + this.IBJ + ", sampleId='" + this.JYz + '\'' + ", originalMd5='" + this.dER + '\'' + ", fileCompress=" + this.JYZ + ", fileEncrypt=" + this.JZa + ", encryptKey='" + this.JYv + '\'' + ", keyVersion=" + this.JYw + ", EID=" + this.JZb + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.dEU + APLogFileUtil.SEPARATOR_LOG + super.toString();
        AppMethodBeat.o(151960);
        return str;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.a
    public final s gnJ() {
        AppMethodBeat.i(151961);
        s gnJ = super.gnJ();
        gnJ.field_fileUpdated = this.dEQ;
        gnJ.field_resType = this.dEO;
        gnJ.field_subType = this.subType;
        gnJ.field_reportId = this.IBJ;
        gnJ.field_sampleId = this.JYz;
        gnJ.field_eccSignature = this.JYx;
        gnJ.field_originalMd5 = this.dER;
        gnJ.field_fileCompress = this.JYZ;
        gnJ.field_fileEncrypt = this.JZa;
        gnJ.field_encryptKey = this.JYv;
        gnJ.field_keyVersion = this.JYw;
        gnJ.field_fileSize = this.fileSize;
        gnJ.field_EID = this.JZb;
        AppMethodBeat.o(151961);
        return gnJ;
    }

    public static final class a extends a.AbstractC2019a<g> {
        long IBJ;
        byte[] JYY;
        boolean JYZ;
        String JYv;
        int JYw;
        byte[] JYx;
        String JYz;
        boolean JZa;
        int JZb;
        int dEO;
        int dEP;
        private boolean dEQ;
        String dER;
        boolean dEU;
        long fileSize = 0;
        int subType;

        public a(String str) {
            super(str);
        }

        public final g gnK() {
            AppMethodBeat.i(151958);
            g gVar = new g(this.url, this.JYs, this.dEP, this.networkType, this.JYA, this.jmW, this.md5, this.dEO, this.subType, this.IBJ, this.JYz, this.JYx, this.dER, this.JYZ, this.JZa, this.JYv, this.JYw, this.JZb, this.JYY, this.fileSize, this.dEU, this.dEQ, this.priority);
            AppMethodBeat.o(151958);
            return gVar;
        }
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.a
    public final int bdX(String str) {
        AppMethodBeat.i(151962);
        int i2 = Util.getInt(this.JZK, 0) - Util.getInt(str, 0);
        AppMethodBeat.o(151962);
        return i2;
    }
}
