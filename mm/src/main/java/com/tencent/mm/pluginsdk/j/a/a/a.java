package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.f;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Util;

public final class a implements f.b {
    final long IBJ;
    final int JYA;
    final int JYB;
    final String JYs;
    final boolean JYt;
    final boolean JYu;
    final String JYv;
    final int JYw;
    final byte[] JYx;
    final boolean JYy;
    final String JYz;
    final int dEO;
    final int dEP;
    final boolean dEQ;
    final String dER;
    final String filePath;
    final int subType;
    final String url;

    private a(String str, int i2, int i3, int i4, boolean z, String str2, boolean z2, boolean z3, String str3, int i5, byte[] bArr, String str4, boolean z4, long j2, String str5, String str6, int i6, int i7) {
        this.JYs = str;
        this.dEO = i2;
        this.subType = i3;
        this.dEP = i4;
        this.dEQ = z;
        this.filePath = str2;
        this.JYt = z2;
        this.JYu = z3;
        this.JYv = str3;
        this.JYw = i5;
        this.JYx = bArr;
        this.dER = str4;
        this.JYy = z4;
        this.IBJ = j2;
        this.JYz = str5;
        this.url = str6;
        this.JYA = i6;
        this.JYB = i7;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.f.b
    public final String gnA() {
        return this.JYs;
    }

    public static a a(s sVar) {
        AppMethodBeat.i(151909);
        a aVar = new a(sVar.field_urlKey, sVar.field_resType, sVar.field_subType, Util.getInt(sVar.field_fileVersion, 0), sVar.field_fileUpdated, sVar.field_filePath, sVar.field_fileEncrypt, sVar.field_fileCompress, sVar.field_encryptKey, sVar.field_keyVersion, sVar.field_eccSignature, sVar.field_originalMd5, Util.nullAsNil(sVar.field_groupId2).equals("NewXml"), sVar.field_reportId, sVar.field_sampleId, sVar.field_url, sVar.field_maxRetryTimes, sVar.field_retryTimes);
        AppMethodBeat.o(151909);
        return aVar;
    }
}
