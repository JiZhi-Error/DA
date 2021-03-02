package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class e {
    int orientation;
    String personId;
    float sXC;
    int sXF;
    int sXG;
    a sXM;
    byte[] sXN;
    public String sXO = "";
    long sXP = System.currentTimeMillis();

    public interface a {
        void a(String str, String str2, String str3, byte[] bArr);

        void onError();
    }

    public e(String str, float f2, int i2, int i3, int i4) {
        AppMethodBeat.i(104227);
        this.personId = str;
        this.sXC = f2;
        this.orientation = i2;
        this.sXF = i3;
        this.sXG = i4;
        Log.i("MicroMsg.FaceCheckVideoRecordMgr", "create FaceCheckVideoRecordMgr, reductionRatio: %s, orientation: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(104227);
    }

    class b implements g.a {
        private String fileName;
        private String personId;

        /* synthetic */ b(e eVar, String str, String str2, byte b2) {
            this(str, str2);
        }

        private b(String str, String str2) {
            this.personId = str2;
            this.fileName = str;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(104226);
            Log.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            int i3 = dVar == null ? -1 : dVar.field_retCode;
            com.tencent.mm.plugin.flash.c.b.dLj().eqU = i3;
            com.tencent.mm.plugin.flash.c.b.dLj().eqW = System.currentTimeMillis() - e.this.sXP;
            com.tencent.mm.plugin.flash.c.b.s("rspCdn", Integer.valueOf(i3));
            if (dVar != null && dVar.field_retCode == 0) {
                Log.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
                e eVar = e.this;
                String str2 = this.fileName;
                String str3 = dVar.field_fileId;
                String str4 = dVar.field_aesKey;
                if (eVar.sXM != null) {
                    eVar.sXM.a(str2, str3, str4, eVar.sXN);
                }
            } else if (dVar != null) {
                Log.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                s.deleteFile(this.fileName);
                h.INSTANCE.idkeyStat(917, 51, 1, false);
                if (e.this.sXM != null) {
                    e.this.sXM.onError();
                }
                AppMethodBeat.o(104226);
                return 0;
            } else if (i2 != 0) {
                Log.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                h.INSTANCE.idkeyStat(917, 51, 1, false);
                s.deleteFile(this.fileName);
                if (e.this.sXM != null) {
                    e.this.sXM.onError();
                }
                AppMethodBeat.o(104226);
                return 0;
            }
            AppMethodBeat.o(104226);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void ae(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetectaction.b.e.ae(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
