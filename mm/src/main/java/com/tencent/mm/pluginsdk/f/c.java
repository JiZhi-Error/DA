package com.tencent.mm.pluginsdk.f;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c implements g {
    String JTA;
    public String JTD;
    public String JTE;
    private a JTM;
    d JTN;
    private int JTO;
    String JTP;
    public boolean JTQ = false;
    String JTz;
    String ixb;
    private float progress;

    public final boolean a(final d dVar) {
        AppMethodBeat.i(223733);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.pluginsdk.f.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(223731);
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 0);
                switch (dVar.scene) {
                    case 1:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 3);
                        break;
                    case 2:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 6);
                        break;
                    case 3:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 9);
                        break;
                }
                c.this.JTN = dVar;
                c.this.JTN.startTime = Util.nowMilliSecond();
                c.this.ahA(3);
                AppMethodBeat.o(223731);
            }

            public final String toString() {
                AppMethodBeat.i(223732);
                String str = super.toString() + "|addUploadTask";
                AppMethodBeat.o(223732);
                return str;
            }
        }, "MicroMsg.ParallelUpload.ThreadName");
        AppMethodBeat.o(223733);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ahA(int r15) {
        /*
        // Method dump skipped, instructions count: 828
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.f.c.ahA(int):void");
    }

    @Override // com.tencent.mm.pluginsdk.f.g
    public final void a(a aVar, g.a aVar2) {
        AppMethodBeat.i(223735);
        Log.i("MicroMsg.CGIParallelUploadMgr", "upload file success, type = %s, path = %s", Integer.valueOf(aVar.fileType), aVar.GaX);
        this.JTN.JTW += aVar2.jPY;
        if (this.JTN.fileType == aVar.fileType) {
            aVar2.pkL = aVar.JTF;
            this.JTN.endTime = Util.nowMilliSecond();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20470, true, true, true, Integer.valueOf(this.JTN.scene), Long.valueOf(this.JTN.totalFileSize), Long.valueOf(this.JTN.endTime - this.JTN.startTime), 0, Long.valueOf(this.JTN.JTW));
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 1);
            switch (this.JTN.scene) {
                case 1:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 4);
                    break;
                case 2:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 7);
                    break;
                case 3:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 10);
                    if (this.JTN.totalFileSize > 26214400) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 13);
                        break;
                    }
                    break;
            }
            if (this.JTN.JTT != null) {
                this.JTN.JTT.a(aVar2);
            }
            AppMethodBeat.o(223735);
            return;
        }
        switch (aVar.fileType) {
            case 3:
                this.JTz = aVar2.fileId;
                this.ixb = aVar2.aesKey;
                if (this.JTN.fileType == 1) {
                    ahA(2);
                    AppMethodBeat.o(223735);
                    return;
                }
                ahA(this.JTN.fileType);
                AppMethodBeat.o(223735);
                return;
            case 2:
                this.JTA = aVar2.fileId;
                this.JTP = aVar2.aesKey;
                break;
        }
        ahA(this.JTN.fileType);
        AppMethodBeat.o(223735);
    }

    private void dc(int i2, String str) {
        AppMethodBeat.i(223736);
        ahB(i2);
        if (this.JTN.JTT != null) {
            this.JTN.JTT.M(i2, str);
        }
        AppMethodBeat.o(223736);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void ahB(int i2) {
        AppMethodBeat.i(223737);
        this.JTN.endTime = Util.nowMilliSecond();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20470, true, true, false, Integer.valueOf(this.JTN.scene), Long.valueOf(this.JTN.totalFileSize), Long.valueOf(this.JTN.endTime - this.JTN.startTime), Integer.valueOf(i2), Long.valueOf(this.JTN.JTW));
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 2);
        switch (this.JTN.scene) {
            case 1:
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 5);
                AppMethodBeat.o(223737);
                return;
            case 2:
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 8);
                AppMethodBeat.o(223737);
                return;
            case 3:
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 11);
                if (this.JTN.totalFileSize > 26214400) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1431, 14);
                    break;
                }
                break;
        }
        AppMethodBeat.o(223737);
    }

    @Override // com.tencent.mm.pluginsdk.f.g
    public final void a(a aVar, String str, int i2) {
        AppMethodBeat.i(223738);
        if (aVar.fileType == 2 && i2 == -100003 && this.JTQ) {
            this.JTQ = false;
            ahA(2);
            AppMethodBeat.o(223738);
            return;
        }
        dc(i2, str);
        AppMethodBeat.o(223738);
    }

    @Override // com.tencent.mm.pluginsdk.f.g
    public final void a(a aVar, float f2, long j2) {
        AppMethodBeat.i(223739);
        if (aVar.fileType == this.JTN.fileType) {
            this.progress = f2;
            if (this.JTN.JTT != null) {
                this.JTN.JTT.a(this.progress, j2);
            }
        }
        AppMethodBeat.o(223739);
    }
}
