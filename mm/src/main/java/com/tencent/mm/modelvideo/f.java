package com.tencent.mm.modelvideo;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class f {
    public String dHp;
    private g.b gqQ = new g.b() {
        /* class com.tencent.mm.modelvideo.f.AnonymousClass2 */

        @Override // com.tencent.mm.i.g.b
        public final void b(String str, d dVar) {
            AppMethodBeat.i(126842);
            if (dVar == null) {
                Log.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", Integer.valueOf(f.this.hashCode()));
                if (f.this.jqL != null) {
                    f.this.jqL.a(f.this, false, 0, 0);
                }
                AppMethodBeat.o(126842);
                return;
            }
            int i2 = (int) dVar.field_recvedBytes;
            int i3 = (int) dVar.field_fileLength;
            Log.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", Integer.valueOf(f.this.hashCode()), str, f.this.jqD, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(dVar.field_videoFormat));
            if (i2 > 0 && i3 > 0) {
                f.this.jqG = (long) f.e(f.this.jqD, i2, true);
            }
            if (f.this.jqL != null) {
                f.this.jqL.a(f.this, i2 > 0 && i3 > 0, i2, i3);
            }
            f.this.jqF = Util.nowSecond();
            f.this.Qe(dVar.alM());
            if (f.this.jqC) {
                h.INSTANCE.idkeyStat(354, 142, 1, false);
                if (f.this.jqH == 1) {
                    h.INSTANCE.idkeyStat(354, 123, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(354, 124, 1, false);
                }
                h.INSTANCE.idkeyStat(354, (long) (dVar.field_videoFormat + 240), 1, false);
                AppMethodBeat.o(126842);
                return;
            }
            h.INSTANCE.idkeyStat(354, 143, 1, false);
            AppMethodBeat.o(126842);
        }
    };
    String gqS;
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.modelvideo.f.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(126841);
            if (i2 != 0) {
                Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(i2));
                if (f.this.jqL != null) {
                    f.this.jqL.a(f.this, false, 0, 0);
                }
            }
            if (cVar != null) {
                Log.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", Integer.valueOf(f.this.hashCode()), Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength), str);
            }
            if (dVar != null) {
                Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(dVar.field_retCode));
                if (dVar.field_retCode == 0) {
                    Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", Integer.valueOf(f.this.hashCode()));
                    f.this.l(f.this.jqD, (int) dVar.field_fileLength, f.this.gqS);
                } else if (f.this.jqL != null) {
                    f.this.jqL.a(f.this, false, 0, 0);
                }
            }
            AppMethodBeat.o(126841);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    boolean jqC = false;
    String jqD;
    private long jqE;
    long jqF;
    long jqG;
    int jqH;
    private String jqI;
    public long jqJ;
    public boolean jqK;
    public a jqL;
    private com.tencent.mm.i.h jqr;
    private String mediaId;
    long msgId;

    public interface a {
        void a(f fVar, boolean z, int i2, int i3);
    }

    public f(long j2) {
        AppMethodBeat.i(126843);
        this.msgId = j2;
        this.jqC = true;
        AppMethodBeat.o(126843);
    }

    public f(com.tencent.mm.i.h hVar, String str) {
        AppMethodBeat.i(126844);
        this.jqr = hVar;
        this.dHp = str;
        this.jqC = false;
        AppMethodBeat.o(126844);
    }

    public final String bha() {
        AppMethodBeat.i(126845);
        if (this.jqC) {
            String sb = new StringBuilder().append(this.msgId).toString();
            AppMethodBeat.o(126845);
            return sb;
        }
        String str = this.dHp;
        AppMethodBeat.o(126845);
        return str;
    }

    public final void stop() {
        AppMethodBeat.i(126846);
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", Integer.valueOf(hashCode()), this.mediaId);
        if (!Util.isNullOrNil(this.mediaId)) {
            d dVar = new d();
            b baQ = com.tencent.mm.an.f.baQ();
            String str = this.mediaId;
            int i2 = 0;
            g remove = baQ.iRA.remove(str);
            if (remove != null) {
                com.tencent.mm.an.f.baR();
                i2 = com.tencent.mm.an.a.c(str, dVar);
                h.INSTANCE.a(10769, Integer.valueOf(com.tencent.mm.an.c.iSb), Integer.valueOf(remove.field_fileType), Long.valueOf(Util.nowMilliSecond() - remove.field_startTime));
            }
            baQ.iRz.remove(str);
            baQ.iRB.remove(str);
            Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, remove, Integer.valueOf(i2));
            this.jqF = Util.nowSecond();
            this.jqG = (long) e(this.jqD, (int) dVar.field_recvedBytes, false);
            Qe(dVar.alM());
        }
        this.jqL = null;
        AppMethodBeat.o(126846);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x029e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.modelvideo.f.a r15) {
        /*
        // Method dump skipped, instructions count: 743
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.f.a(com.tencent.mm.modelvideo.f$a):int");
    }

    static int e(String str, int i2, boolean z) {
        int i3 = 0;
        AppMethodBeat.i(126848);
        s QN = u.QN(str);
        if (QN != null) {
            int i4 = QN.dRQ;
            if (z) {
                QN.dRQ = i2;
            } else {
                QN.dRQ = i4 + i2;
            }
            Log.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(QN.dRQ), Boolean.valueOf(z));
            QN.jsm = Util.nowSecond();
            QN.cSx = TXLiteAVCode.EVT_CAMERA_CLOSE;
            u.f(QN);
            int i5 = z ? i2 - i4 : i2;
            if (i5 >= 0) {
                i3 = i5;
            }
            AppMethodBeat.o(126848);
            return i3;
        }
        AppMethodBeat.o(126848);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void l(String str, int i2, String str2) {
        AppMethodBeat.i(126849);
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), str2);
        if (u.QN(str) != null) {
            u.ay(str, i2);
            i(i2, str2, str);
        }
        AppMethodBeat.o(126849);
    }

    private static boolean i(int i2, String str, String str2) {
        AppMethodBeat.i(126850);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126850);
            return false;
        }
        o.bhj();
        String Qw = t.Qw(str2);
        if (Util.isNullOrNil(str) || i2 <= 0 || Util.isNullOrNil(Qw) || !s.YS(Qw)) {
            Log.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i2), str, Qw);
            AppMethodBeat.o(126850);
            return false;
        }
        boolean P = ((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().P(str, i2, Qw);
        AppMethodBeat.o(126850);
        return P;
    }

    /* access modifiers changed from: package-private */
    public final void Qe(String str) {
        int i2;
        AppMethodBeat.i(126851);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.jqE).append(",");
        stringBuffer.append(this.jqF).append(",");
        stringBuffer.append(this.jqG).append(",");
        stringBuffer.append(this.jqI).append(",");
        stringBuffer.append(this.jqH).append(",");
        try {
            i2 = (int) ((this.jqG / 1024) / (this.jqF - this.jqE));
        } catch (Exception e2) {
            i2 = 0;
        }
        stringBuffer.append(i2).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(this.jqr.dRL).append(",");
        stringBuffer.append(this.jqr.gqV).append(",");
        stringBuffer.append(this.jqr.dRN).append(",");
        stringBuffer.append(this.jqr.field_fileId).append(",");
        stringBuffer.append(this.jqr.url).append(",");
        stringBuffer.append(com.tencent.mm.plugin.video.c.aTR(this.jqr.dRS));
        String stringBuffer2 = stringBuffer.toString();
        Log.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer2);
        new hb(stringBuffer2).bfK();
        AppMethodBeat.o(126851);
    }
}
