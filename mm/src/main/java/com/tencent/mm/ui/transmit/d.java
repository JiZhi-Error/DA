package com.tencent.mm.ui.transmit;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class d {

    public interface a {
        void be(String str, boolean z);
    }

    public static void a(final String str, final a aVar) {
        AppMethodBeat.i(234477);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.transmit.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(234475);
                long boW = s.boW(str);
                if (boW > 1048576) {
                    Log.e("MusicVideoShareUtil", "img size is too large");
                    aVar.be(null, false);
                    AppMethodBeat.o(234475);
                } else if (boW < 1048576 || boW >= 1048576) {
                    d.b(str, aVar);
                    AppMethodBeat.o(234475);
                } else {
                    d.b(s.k(str, false), aVar);
                    AppMethodBeat.o(234475);
                }
            }
        }, "PageLongTaskReporter");
        AppMethodBeat.o(234477);
    }

    static /* synthetic */ void b(String str, final a aVar) {
        AppMethodBeat.i(234478);
        g gVar = new g();
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = c.a("musicvideoimage", currentTimeMillis, z.aUL().field_username, String.valueOf(currentTimeMillis));
        gVar.taskName = "task_AiScanImagetUploadTask";
        gVar.field_mediaId = a2;
        gVar.field_fullpath = str;
        gVar.field_appType = 202;
        gVar.field_fileType = com.tencent.mm.i.a.gpW;
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_needCompressImage = true;
        gVar.field_isStreamMedia = false;
        gVar.field_bzScene = 2;
        gVar.gqy = new g.a() {
            /* class com.tencent.mm.ui.transmit.d.AnonymousClass2 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(234476);
                if (i2 != 0) {
                    Log.e("MusicVideoShareUtil", "CDN starts fail!");
                    aVar.be(null, false);
                }
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MusicVideoShareUtil", "CDN upload task fail!");
                        aVar.be("", false);
                    } else {
                        Log.i("MusicVideoShareUtil", "retCode %d, fileId %s, url %s", Integer.valueOf(dVar.field_retCode), dVar.field_fileId, dVar.field_fileUrl);
                        aVar.be(dVar.field_fileUrl, true);
                    }
                }
                AppMethodBeat.o(234476);
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
        if (!f.baQ().f(gVar)) {
            Log.e("MusicVideoShareUtil", "hy: cdntra addSendTask failed. clientid:%s", a2);
        }
        AppMethodBeat.o(234478);
    }
}
