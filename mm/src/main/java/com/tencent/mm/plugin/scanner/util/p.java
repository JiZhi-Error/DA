package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class p {
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.scanner.util.p.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            String dVar2;
            AppMethodBeat.i(91078);
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = cVar == null ? BuildConfig.COMMAND : cVar.toString();
            if (dVar == null) {
                dVar2 = BuildConfig.COMMAND;
            } else {
                dVar2 = dVar.toString();
            }
            objArr[3] = dVar2;
            Log.i("MicroMsg.ScannerCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", objArr);
            b bVar = new b();
            if (i2 != 0) {
                Log.e("MicroMsg.ScannerCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                bVar.errCode = i2;
                p.a(p.this, str, bVar);
                AppMethodBeat.o(91078);
            } else {
                if (dVar != null) {
                    bVar.errCode = dVar.field_retCode;
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.ScannerCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                    } else {
                        Log.i("MicroMsg.ScannerCdnService", "cdn trans suceess, media id : %s", str);
                        bVar.fileId = dVar.field_fileId;
                        bVar.aeskey = dVar.field_aesKey;
                    }
                    p.a(p.this, str, bVar);
                }
                AppMethodBeat.o(91078);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(91079);
            Log.i("MicroMsg.ScannerCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.o(91079);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(91080);
            Log.i("MicroMsg.ScannerCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.o(91080);
            return null;
        }
    };
    private Map<String, a> oPn = new HashMap();

    public interface a {
        void a(String str, b bVar);
    }

    public class b {
        public String aeskey;
        public int errCode;
        public String fileId;

        public b() {
        }
    }

    public p() {
        AppMethodBeat.i(91081);
        AppMethodBeat.o(91081);
    }

    public static String aMv(String str) {
        AppMethodBeat.i(91082);
        String str2 = z.aTY() + "_" + str + "_" + System.currentTimeMillis();
        AppMethodBeat.o(91082);
        return str2;
    }

    public final void a(String str, String str2, int i2, a aVar) {
        AppMethodBeat.i(91083);
        g gVar = new g();
        gVar.taskName = "task_ScannerCdnService";
        gVar.gqy = this.iZc;
        gVar.field_mediaId = str;
        gVar.field_fullpath = str2;
        gVar.field_fileType = i2;
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_needCompressImage = true;
        gVar.field_isStreamMedia = false;
        gVar.field_force_aeskeycdn = true;
        gVar.field_trysafecdn = false;
        this.oPn.put(str, aVar);
        f.baQ().f(gVar);
        AppMethodBeat.o(91083);
    }

    static /* synthetic */ void a(p pVar, String str, b bVar) {
        AppMethodBeat.i(91084);
        if (pVar.oPn.containsKey(str)) {
            pVar.oPn.remove(str).a(str, bVar);
        }
        AppMethodBeat.o(91084);
    }
}
