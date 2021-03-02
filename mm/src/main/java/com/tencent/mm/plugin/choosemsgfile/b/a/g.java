package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vending.e.b;

public final class g extends c {
    private s qnC;
    private ca qnv;

    static /* synthetic */ void a(g gVar, s sVar, String str) {
        AppMethodBeat.i(123258);
        gVar.a(sVar, str);
        AppMethodBeat.o(123258);
    }

    public g(a aVar, a aVar2, b bVar) {
        super(aVar, aVar2, bVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean checkValid() {
        AppMethodBeat.i(123254);
        if (this.qno == null || this.qno.qnv == null) {
            Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
            AppMethodBeat.o(123254);
            return false;
        }
        this.qnv = this.qno.qnv;
        if (this.qnv.gDB()) {
            Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", this.qnv);
            AppMethodBeat.o(123254);
            return false;
        } else if (!((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.qnv)) {
            Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", this.qnv);
            AppMethodBeat.o(123254);
            return false;
        } else {
            this.qnC = u.QN(this.qnv.field_imgPath);
            if (this.qnC == null) {
                Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", this.qnv);
                AppMethodBeat.o(123254);
                return false;
            } else if (this.qnC.status == 198) {
                Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", this.qnv);
                AppMethodBeat.o(123254);
                return false;
            } else {
                AppMethodBeat.o(123254);
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean cyn() {
        AppMethodBeat.i(123255);
        if (this.qnC.bhy()) {
            o.bhj();
            String Qw = t.Qw(this.qnv.field_imgPath);
            if (com.tencent.mm.vfs.s.YS(Qw)) {
                a(this.qnC, Qw);
                AppMethodBeat.o(123255);
                return true;
            }
        }
        AppMethodBeat.o(123255);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final void bPM() {
        AppMethodBeat.i(123256);
        o.bhj().a(new t.a() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.a.g.AnonymousClass1 */

            @Override // com.tencent.mm.modelvideo.t.a
            public final void a(t.a.C0460a aVar) {
                AppMethodBeat.i(123253);
                s QN = u.QN(aVar.fileName);
                if (QN != null) {
                    g.this.fl(QN.jsj, QN.iKP);
                    if (QN.bhy()) {
                        o.bhj();
                        String Qw = t.Qw(g.this.qnv.field_imgPath);
                        if (com.tencent.mm.vfs.s.YS(Qw)) {
                            g.a(g.this, QN, Qw);
                            AppMethodBeat.o(123253);
                            return;
                        }
                        Log.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
                        g.this.cyp();
                    }
                }
                AppMethodBeat.o(123253);
            }
        }, Looper.getMainLooper());
        if (this.qnC.bhx()) {
            Log.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
            u.QT(this.qnv.field_imgPath);
            AppMethodBeat.o(123256);
            return;
        }
        Log.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
        u.aA(this.qnv.field_imgPath, 10);
        u.QI(this.qnv.field_imgPath);
        AppMethodBeat.o(123256);
    }

    private void a(s sVar, String str) {
        AppMethodBeat.i(123257);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = sVar.iKP;
        msgFile.filePath = str;
        msgFile.gCr = c.akC(msgFile.filePath);
        msgFile.type = "video";
        msgFile.fileName = sVar.getFileName() + "." + msgFile.gCr;
        msgFile.timeStamp = sVar.createTime;
        b(msgFile);
        AppMethodBeat.o(123257);
    }
}
