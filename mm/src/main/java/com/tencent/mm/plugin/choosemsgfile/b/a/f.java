package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.b;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public final class f extends c {
    private g qnA;
    private ca qnv;

    static /* synthetic */ void a(f fVar, b bVar) {
        AppMethodBeat.i(123251);
        fVar.a(bVar);
        AppMethodBeat.o(123251);
    }

    static /* synthetic */ void a(f fVar, String str) {
        AppMethodBeat.i(123252);
        fVar.aky(str);
        AppMethodBeat.o(123252);
    }

    public f(a aVar, a aVar2, com.tencent.mm.vending.e.b bVar) {
        super(aVar, aVar2, bVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean checkValid() {
        AppMethodBeat.i(123246);
        if (this.qno == null || this.qno.qnv == null) {
            Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
            cyp();
            AppMethodBeat.o(123246);
            return false;
        }
        this.qnv = this.qno.qnv;
        if (this.qnv.gDB()) {
            Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", this.qnv);
            AppMethodBeat.o(123246);
            return false;
        } else if (!((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).j(this.qnv)) {
            Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
            AppMethodBeat.o(123246);
            return false;
        } else if (this.qnv.getType() == 268435505) {
            AppMethodBeat.o(123246);
            return true;
        } else {
            this.qnA = ((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).k(this.qnv);
            if (this.qnA == null) {
                Log.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
                AppMethodBeat.o(123246);
                return false;
            }
            AppMethodBeat.o(123246);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean cyn() {
        AppMethodBeat.i(123247);
        if (this.qnv.getType() == 268435505) {
            if (s.YS(((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.qnv))) {
                if (this.qno instanceof b) {
                    a((b) this.qno);
                } else {
                    Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
                    cyp();
                }
                AppMethodBeat.o(123247);
                return true;
            }
        } else if (this.qnA.bcu()) {
            String a2 = ((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.qnv, this.qnA);
            if (!Util.isNullOrNil(a2)) {
                aky(a2);
                AppMethodBeat.o(123247);
                return true;
            }
        }
        AppMethodBeat.o(123247);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final void bPM() {
        AppMethodBeat.i(123248);
        if (this.qnv.getType() == 268435505) {
            ((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.qnv, new b.a() {
                /* class com.tencent.mm.plugin.choosemsgfile.b.a.f.AnonymousClass1 */

                @Override // com.tencent.mm.choosemsgfile.compat.b.a
                public final void t(int i2, String str) {
                    AppMethodBeat.i(123241);
                    Log.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
                    if (i2 != 0) {
                        Log.e("MicroMsg.MsgFileWorker_Image", "download fail");
                        f.this.cyp();
                        AppMethodBeat.o(123241);
                    } else if (f.this.qno instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b) {
                        Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
                        f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.b.b.b) f.this.qno);
                        AppMethodBeat.o(123241);
                    } else {
                        f.this.cyp();
                        AppMethodBeat.o(123241);
                    }
                }

                @Override // com.tencent.mm.choosemsgfile.compat.b.a
                public final void cs(int i2, int i3) {
                    AppMethodBeat.i(123242);
                    f.this.fl(i2, i3);
                    AppMethodBeat.o(123242);
                }
            });
            AppMethodBeat.o(123248);
            return;
        }
        Log.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", Boolean.valueOf(q.bcS().a(this.qnA.localId, this.qnv.field_msgId, 0, Long.valueOf(this.qnv.field_msgId), R.drawable.c3h, new e.a() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.a.f.AnonymousClass2 */

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(123243);
                Log.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i4), Integer.valueOf(i5));
                f.this.fl(i4, i5);
                AppMethodBeat.o(123243);
            }

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(123244);
                Log.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(i5), str);
                String a2 = ((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.this.qnv, ((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).k(f.this.qnv));
                Log.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", a2);
                if (!Util.isNullOrNil(a2)) {
                    f.a(f.this, a2);
                    AppMethodBeat.o(123244);
                    return;
                }
                f.this.cyp();
                AppMethodBeat.o(123244);
            }

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj) {
                AppMethodBeat.i(123245);
                f.this.cyp();
                AppMethodBeat.o(123245);
            }
        })));
        AppMethodBeat.o(123248);
    }

    private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b bVar) {
        AppMethodBeat.i(123249);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = bVar.cyt();
        msgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.qnv);
        msgFile.fileName = bVar.getFileName() + "." + msgFile.gCr;
        msgFile.type = "image";
        msgFile.gCr = bVar.getFileExt();
        msgFile.timeStamp = bVar.getTimeStamp();
        b(msgFile);
        AppMethodBeat.o(123249);
    }

    private void aky(String str) {
        AppMethodBeat.i(123250);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = (int) s.boW(str);
        msgFile.filePath = str;
        msgFile.fileName = this.qnA.iXm;
        msgFile.type = "image";
        msgFile.gCr = c.akC(msgFile.fileName);
        msgFile.timeStamp = (long) this.qnA.iXu;
        b(msgFile);
        AppMethodBeat.o(123250);
    }
}
