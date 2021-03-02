package com.tencent.mm.plugin.cdndownloader.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.downloader.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements com.tencent.xweb.downloader.a {
    private static a qmY = null;
    private g.a qmQ = new g.a() {
        /* class com.tencent.mm.plugin.cdndownloader.i.a.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            String dVar2;
            AppMethodBeat.i(120824);
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
            Log.d("FileDownloaderXWEBProxy", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", objArr);
            if (i2 == -21006) {
                Log.i("FileDownloaderXWEBProxy", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(120824);
            } else if (i2 != 0) {
                Log.e("FileDownloaderXWEBProxy", "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                a.a(a.this, str, 4, i2, false);
                AppMethodBeat.o(120824);
            } else if (cVar != null) {
                a.a(a.this, str, cVar.field_finishedLength, cVar.field_toltalLength);
                AppMethodBeat.o(120824);
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("FileDownloaderXWEBProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        a.a(a.this, str, 4, dVar.field_retCode, dVar.field_isResume);
                    } else {
                        Log.i("FileDownloaderXWEBProxy", "cdn trans suceess, media id : %s", str);
                        a.a(a.this, str, 3, 0, dVar.field_isResume);
                    }
                }
                AppMethodBeat.o(120824);
            }
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
    private Map<String, C0923a> qmU = new ConcurrentHashMap();

    public a() {
        AppMethodBeat.i(120825);
        AppMethodBeat.o(120825);
    }

    public static synchronized a cyj() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(120826);
            if (qmY == null) {
                qmY = new a();
            }
            com.tencent.mm.plugin.cdndownloader.c.a.cxZ();
            aVar = qmY;
            AppMethodBeat.o(120826);
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.cdndownloader.i.a$a  reason: collision with other inner class name */
    public class C0923a {
        public String qmX;
        public b qna;

        private C0923a() {
            this.qna = null;
            this.qmX = null;
        }

        /* synthetic */ C0923a(a aVar, byte b2) {
            this();
        }
    }

    @Override // com.tencent.xweb.downloader.a
    public final int a(String str, String str2, b bVar) {
        AppMethodBeat.i(120827);
        Log.i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", str, str2);
        g gVar = new g();
        gVar.taskName = "task_FileDownloaderXWEBProxy";
        gVar.field_mediaId = str;
        gVar.field_fullpath = str2;
        gVar.gqB = str;
        gVar.field_fileType = com.tencent.mm.i.a.gqd;
        gVar.gqy = this.qmQ;
        gVar.gqC = 60;
        gVar.gqD = 600;
        gVar.gqF = false;
        C0923a aVar = new C0923a(this, (byte) 0);
        aVar.qna = bVar;
        aVar.qmX = str2;
        this.qmU.put(str, aVar);
        int h2 = com.tencent.mm.plugin.cdndownloader.c.a.cxZ().h(gVar);
        Log.i("FileDownloaderXWEBProxy", "addDownloadTask: ".concat(String.valueOf(h2)));
        AppMethodBeat.o(120827);
        return h2;
    }

    static /* synthetic */ void a(a aVar, String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(120828);
        Log.i("FileDownloaderXWEBProxy", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s, containCallback = %b", str, Integer.valueOf(i2), Integer.valueOf(i3), null, Boolean.valueOf(aVar.qmU.containsKey(str)));
        if (aVar.qmU.containsKey(str)) {
            b bVar = aVar.qmU.get(str).qna;
            if (bVar == null) {
                Log.e("FileDownloaderXWEBProxy", "error proxy_callback null");
                AppMethodBeat.o(120828);
                return;
            } else if (i2 == 3) {
                bVar.c(str, aVar.qmU.get(str).qmX, z);
                AppMethodBeat.o(120828);
                return;
            } else {
                bVar.d(str, i3, z);
            }
        }
        AppMethodBeat.o(120828);
    }

    static /* synthetic */ void a(a aVar, String str, long j2, long j3) {
        AppMethodBeat.i(120829);
        Log.d("FileDownloaderXWEBProxy", "updateProgressChange, mediaId = %s, recvLen = %d, totalLen= %d, containCallback = %b", str, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(aVar.qmU.containsKey(str)));
        if (aVar.qmU.containsKey(str)) {
            b bVar = aVar.qmU.get(str).qna;
            if (bVar == null) {
                Log.e("FileDownloaderXWEBProxy", "error proxy_callback null");
                AppMethodBeat.o(120829);
                return;
            }
            bVar.j(str, j2, j3);
        }
        AppMethodBeat.o(120829);
    }
}
