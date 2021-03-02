package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;

public final class d {
    public static int jSm = 20301;
    private String dRr;
    private g.a iZc;
    private a jSn;
    private long jSo;
    private String mediaId;

    public interface a {
        void bU(String str, String str2);

        void bme();
    }

    public d(String str, a aVar) {
        String messageDigest;
        AppMethodBeat.i(63324);
        this.jSo = 0;
        this.iZc = new g.a() {
            /* class com.tencent.mm.plugin.aa.model.d.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(63323);
                if (i2 == -21005) {
                    Log.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                    AppMethodBeat.o(63323);
                    return 0;
                } else if (dVar != null && dVar.field_retCode == 0) {
                    Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                    d.this.jSn.bU(dVar.field_fileUrl, dVar.field_thumbUrl);
                    Log.i("MicroMsg.Aa.AAImagUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - d.this.jSo) + " " + dVar.field_filemd5);
                    new y(com.tencent.mm.plugin.report.a.t(0, 1, Long.valueOf(d.this.jSo), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.jSm), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                    AppMethodBeat.o(63323);
                    return 0;
                } else if (dVar != null && dVar.field_retCode != 0) {
                    Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                    String t = com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(d.this.jSo), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.jSm), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                    new y(t).bfK();
                    new w(t).bfK();
                    d.this.jSn.bme();
                    AppMethodBeat.o(63323);
                    return 0;
                } else if (i2 != 0) {
                    Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                    if (dVar != null) {
                        new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 1, Long.valueOf(d.this.jSo), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.jSm), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                    }
                    d.this.jSn.bme();
                    AppMethodBeat.o(63323);
                    return 0;
                } else {
                    Log.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                    AppMethodBeat.o(63323);
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
        this.jSo = System.currentTimeMillis();
        this.dRr = str;
        this.jSn = aVar;
        if (Util.isNullOrNil(this.dRr)) {
            messageDigest = "";
        } else {
            messageDigest = com.tencent.mm.b.g.getMessageDigest(this.dRr.getBytes());
        }
        this.mediaId = messageDigest;
        Log.i("MicroMsg.Aa.AAImagUpload", "AAImagUpload imgPath:%s mediaId:%s", str, this.mediaId);
        AppMethodBeat.o(63324);
    }

    public final boolean bmd() {
        AppMethodBeat.i(63325);
        g gVar = new g();
        gVar.taskName = "task_AAImagUpload";
        gVar.gqy = this.iZc;
        gVar.field_mediaId = this.mediaId;
        gVar.field_fullpath = this.dRr;
        gVar.field_thumbpath = "";
        gVar.field_fileType = 20301;
        gVar.field_talker = "";
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = true;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = cr.CTRL_INDEX;
        gVar.field_bzScene = 2;
        if (!f.baQ().f(gVar)) {
            Log.e("MicroMsg.Aa.AAImagUpload", "cdntra addSendTask failed. mediaId:%s", this.mediaId);
            AppMethodBeat.o(63325);
            return false;
        }
        AppMethodBeat.o(63325);
        return true;
    }
}
