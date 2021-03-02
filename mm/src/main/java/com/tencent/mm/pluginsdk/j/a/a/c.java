package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class c extends l {
    final long IBJ;
    volatile boolean IOp;
    volatile byte[] JYY;
    private final boolean dEU;
    final long fileSize;
    final String md5;

    private c(String str, int i2, String str2, boolean z, long j2, String str3, int i3, long j3, int i4, int i5) {
        super(str, i.aee(str), String.valueOf(i2), "CheckResUpdate", str3, "GET", i3, i4, i5);
        AppMethodBeat.i(151943);
        this.md5 = str2;
        this.IBJ = j2;
        this.dEU = z;
        this.fileSize = j3;
        AppMethodBeat.o(151943);
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.l
    public final boolean gnI() {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.l
    public final String avy() {
        return "CheckResUpdate";
    }

    static c d(s sVar) {
        AppMethodBeat.i(151945);
        c cVar = new c(sVar.field_urlKey, Util.getInt(sVar.field_fileVersion, 0), sVar.field_md5, Util.nullAsNil(sVar.field_groupId2).equals("NewXml"), sVar.field_reportId, sVar.field_url, sVar.field_maxRetryTimes, sVar.field_fileSize, sVar.field_networkType, sVar.field_priority);
        AppMethodBeat.o(151945);
        return cVar;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.l
    public final String getFilePath() {
        AppMethodBeat.i(151944);
        String aee = i.aee(this.JYs);
        AppMethodBeat.o(151944);
        return aee;
    }
}
