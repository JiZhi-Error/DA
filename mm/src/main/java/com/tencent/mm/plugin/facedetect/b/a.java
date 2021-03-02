package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.ByteArrayOutputStream;

public final class a implements i {
    private int sPn = -1;
    private d sPo = null;
    private c sPp = null;
    private boolean sPq = false;
    private boolean sPr = false;
    private long sPs = 0;
    private int sPt = 0;
    private q sPu = null;
    private q sPv = null;
    private long sPw = -1;
    private int sPx = -1;
    private int sPy;
    private g.a sPz = new g.a() {
        /* class com.tencent.mm.plugin.facedetect.b.a.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(103582);
            if (i2 == -21005) {
                Log.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                AppMethodBeat.o(103582);
                return 0;
            } else if (dVar != null && dVar.field_retCode == 0) {
                Log.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                String str2 = dVar.field_fileId;
                Bundle bundle = new Bundle();
                bundle.putString("key_pic_cdn_id", str2);
                bundle.putString("key_cdn_aes_key", dVar.field_aesKey);
                h.INSTANCE.idkeyStat(917, 13, 1, false);
                AppMethodBeat.o(103582);
                return 0;
            } else if (dVar != null) {
                Log.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                h.INSTANCE.idkeyStat(917, 14, 1, false);
                a.this.s(3, 90020, "cdn ret error");
                AppMethodBeat.o(103582);
                return 0;
            } else if (i2 != 0) {
                Log.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                h.INSTANCE.idkeyStat(917, 14, 1, false);
                a.this.s(3, 90021, "cdn start error");
                AppMethodBeat.o(103582);
                return 0;
            } else {
                Log.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                if (cVar != null) {
                    Log.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", Double.valueOf(((double) cVar.field_finishedLength) / ((double) cVar.field_toltalLength)));
                }
                AppMethodBeat.o(103582);
                return 0;
            }
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    };

    public a(int i2, int i3) {
        AppMethodBeat.i(103584);
        this.sPn = i2;
        this.sPy = i3;
        AppMethodBeat.o(103584);
    }

    /* access modifiers changed from: package-private */
    public final void s(final int i2, final int i3, final String str) {
        AppMethodBeat.i(103586);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.b.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(103583);
                AppMethodBeat.o(103583);
            }
        });
        AppMethodBeat.o(103586);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = false;
        AppMethodBeat.i(103587);
        Log.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", qVar.toString(), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if ((qVar instanceof u) || (qVar instanceof v)) {
            if (i2 == 0 && i3 == 0) {
                b bVar = (b) qVar;
                this.sPs = bVar.cSK();
                e.DF(this.sPs);
                if (bVar.cSL() == null) {
                    Log.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
                    s(2, 90015, "face motion config from server is null");
                    AppMethodBeat.o(103587);
                    return;
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(bVar.cSL().length);
                if (this.sPo == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                Log.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", objArr);
                AppMethodBeat.o(103587);
                return;
            } else if (this.sPp != null) {
                AppMethodBeat.o(103587);
                return;
            }
        } else if (this.sPv != null && qVar.getType() == this.sPv.getType()) {
            this.sPx = (int) (System.currentTimeMillis() - this.sPw);
        }
        AppMethodBeat.o(103587);
    }
}
