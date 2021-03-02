package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

public final class e extends c {
    private String Mc;
    private long gof;
    private ca qnv;
    private a qnw;

    public e(com.tencent.mm.plugin.choosemsgfile.b.b.a aVar, a aVar2, b bVar) {
        super(aVar, aVar2, bVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean checkValid() {
        AppMethodBeat.i(123237);
        Log.i("MicroMsg.MsgFileWorker_File", "start %s", this);
        if (this.qno == null || this.qno.qnv == null) {
            Log.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
            AppMethodBeat.o(123237);
            return false;
        }
        this.qnv = this.qno.qnv;
        this.gof = this.qno.qnv.field_msgId;
        k.b HD = k.b.HD(this.qnv.field_content);
        if (HD == null) {
            Log.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", this.qnv.field_content);
            AppMethodBeat.o(123237);
            return false;
        }
        if (Util.isNullOrNil(HD.dCK) && !Util.isNullOrNil(HD.iwW)) {
            Log.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", this.qnv.field_content);
            HD.dCK = new StringBuilder().append(HD.iwW.hashCode()).toString();
        }
        this.Mc = HD.dCK;
        if (Util.isNullOrNil(this.Mc)) {
            Log.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
            AppMethodBeat.o(123237);
            return false;
        }
        AppMethodBeat.o(123237);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean cyn() {
        AppMethodBeat.i(123238);
        c s = ((com.tencent.mm.choosemsgfile.compat.b) g.af(com.tencent.mm.choosemsgfile.compat.b.class)).s(this.Mc, this.gof);
        if (((com.tencent.mm.choosemsgfile.compat.b) g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.qnv, s)) {
            MsgFile msgFile = new MsgFile();
            msgFile.fileSize = this.qno.cyt();
            msgFile.filePath = s.field_fileFullPath;
            msgFile.fileName = this.qno.getFileName();
            msgFile.type = "file";
            msgFile.gCr = this.qno.getFileExt();
            msgFile.timeStamp = this.qno.getTimeStamp() / 1000;
            b(msgFile);
            AppMethodBeat.o(123238);
            return true;
        }
        AppMethodBeat.o(123238);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final void bPM() {
        AppMethodBeat.i(123239);
        boolean a2 = ((com.tencent.mm.choosemsgfile.compat.b) g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.Mc, this.qnv, new b.AbstractC0294b() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.a.e.AnonymousClass1 */

            @Override // com.tencent.mm.choosemsgfile.compat.b.AbstractC0294b
            public final void u(int i2, String str) {
                AppMethodBeat.i(123236);
                Log.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
                if (i2 == 0) {
                    final c s = ((com.tencent.mm.choosemsgfile.compat.b) g.af(com.tencent.mm.choosemsgfile.compat.b.class)).s(e.this.Mc, e.this.gof);
                    ((com.tencent.mm.choosemsgfile.compat.b) g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(s);
                    e.this.qnw = ((com.tencent.mm.choosemsgfile.compat.b) g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(e.this.gof, e.this.Mc, new b.a() {
                        /* class com.tencent.mm.plugin.choosemsgfile.b.a.e.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.choosemsgfile.compat.b.a
                        public final void t(int i2, String str) {
                            AppMethodBeat.i(123234);
                            Log.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
                            if (i2 == 0) {
                                MsgFile msgFile = new MsgFile();
                                msgFile.fileSize = e.this.qno.cyt();
                                msgFile.filePath = s.field_fileFullPath;
                                msgFile.fileName = e.this.qno.getFileName();
                                msgFile.type = "file";
                                msgFile.gCr = e.this.qno.getFileExt();
                                msgFile.timeStamp = e.this.qno.getTimeStamp() / 1000;
                                e.this.b(msgFile);
                                AppMethodBeat.o(123234);
                            } else if (i2 == 1) {
                                e.this.cyo();
                                AppMethodBeat.o(123234);
                            } else {
                                Log.e("MicroMsg.MsgFileWorker_File", "download %s fail", e.this.qno);
                                e.this.cyp();
                                AppMethodBeat.o(123234);
                            }
                        }

                        @Override // com.tencent.mm.choosemsgfile.compat.b.a
                        public final void cs(int i2, int i3) {
                            AppMethodBeat.i(123235);
                            e.this.fl(i2, i3);
                            AppMethodBeat.o(123235);
                        }
                    });
                    AppMethodBeat.o(123236);
                    return;
                }
                Log.e("MicroMsg.MsgFileWorker_File", "init %s fail", e.this.qno);
                e.this.cyp();
                AppMethodBeat.o(123236);
            }
        });
        Log.i("MicroMsg.MsgFileWorker_File", "initOk:%b", Boolean.valueOf(a2));
        if (!a2) {
            Log.i("MicroMsg.MsgFileWorker_File", "initOk fail");
            cyp();
        }
        AppMethodBeat.o(123239);
    }

    @Override // com.tencent.mm.vending.e.a, com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final void dead() {
        AppMethodBeat.i(123240);
        Log.i("MicroMsg.MsgFileWorker_File", "dead");
        if (this.qnw != null) {
            this.qnw.dead();
        }
        AppMethodBeat.o(123240);
    }
}
