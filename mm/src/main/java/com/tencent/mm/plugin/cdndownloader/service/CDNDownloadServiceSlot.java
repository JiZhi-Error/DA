package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mars.Mars;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.ipcinvoker.wx_extension.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.c.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.cdndownloader.a.a;
import com.tencent.mm.plugin.cdndownloader.a.b;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class CDNDownloadServiceSlot extends Service implements a {
    private static b qmE;
    private static g.a qmQ = new g.a() {
        /* class com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot.AnonymousClass2 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            String dVar2;
            AppMethodBeat.i(120800);
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
            Log.d("MicroMsg.CDNDownloadServiceSlot", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", objArr);
            if (i2 == -21006) {
                Log.i("MicroMsg.CDNDownloadServiceSlot", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(120800);
            } else if (i2 != 0) {
                Log.e("MicroMsg.CDNDownloadServiceSlot", "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                CDNDownloadServiceSlot.X(str, 4, i2);
                AppMethodBeat.o(120800);
            } else if (cVar != null) {
                CDNDownloadServiceSlot.y(str, cVar.field_finishedLength, cVar.field_toltalLength);
                AppMethodBeat.o(120800);
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.CDNDownloadServiceSlot", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        CDNDownloadServiceSlot.X(str, 4, dVar.field_retCode);
                    } else {
                        Log.i("MicroMsg.CDNDownloadServiceSlot", "cdn trans suceess, media id : %s", str);
                        CDNDownloadServiceSlot.X(str, 3, 0);
                    }
                }
                AppMethodBeat.o(120800);
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
    private final a.AbstractBinderC0919a qmP = new a.AbstractBinderC0919a() {
        /* class com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final int a(CDNTaskInfo cDNTaskInfo) {
            AppMethodBeat.i(120790);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: %s filepath:%s", cDNTaskInfo.downloadUrl, cDNTaskInfo.filePath);
            g gVar = new g();
            gVar.taskName = "task_CDNDownloadServiceSlot_1";
            gVar.gqH = cDNTaskInfo.gqH;
            gVar.field_mediaId = cDNTaskInfo.mediaId;
            gVar.field_fullpath = cDNTaskInfo.filePath;
            gVar.gqB = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.downloadUrl);
            gVar.gqI = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.qmH);
            gVar.gqy = CDNDownloadServiceSlot.qmQ;
            gVar.gqC = cDNTaskInfo.qmJ;
            gVar.gqD = cDNTaskInfo.qmK;
            gVar.allow_mobile_net_download = cDNTaskInfo.qmL;
            gVar.gqG = cDNTaskInfo.qmM;
            CDNDownloadServiceSlot.b(gVar, cDNTaskInfo.qmI);
            int h2 = com.tencent.mm.plugin.cdndownloader.c.a.cxZ().h(gVar);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: ".concat(String.valueOf(h2)));
            AppMethodBeat.o(120790);
            return h2;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final int b(CDNTaskInfo cDNTaskInfo) {
            AppMethodBeat.i(120791);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: %s", cDNTaskInfo.downloadUrl);
            g gVar = new g();
            gVar.taskName = "task_CDNDownloadServiceSlot_2";
            gVar.gqH = cDNTaskInfo.gqH;
            gVar.field_mediaId = cDNTaskInfo.mediaId;
            gVar.field_fullpath = cDNTaskInfo.filePath;
            gVar.gqB = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.downloadUrl);
            gVar.gqI = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.qmH);
            gVar.gqy = CDNDownloadServiceSlot.qmQ;
            gVar.gqC = cDNTaskInfo.qmJ;
            gVar.gqD = cDNTaskInfo.qmK;
            gVar.gqG = cDNTaskInfo.qmM;
            gVar.allow_mobile_net_download = cDNTaskInfo.qmL;
            gVar.is_resume_task = true;
            CDNDownloadServiceSlot.b(gVar, cDNTaskInfo.qmI);
            int i2 = com.tencent.mm.plugin.cdndownloader.c.a.cxZ().i(gVar);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(120791);
            return i2;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final boolean akr(String str) {
            AppMethodBeat.i(120792);
            com.tencent.mm.plugin.cdndownloader.c.a.cxZ().Oc(str);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "pauseDownloadTask: true");
            AppMethodBeat.o(120792);
            return true;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final boolean aks(String str) {
            AppMethodBeat.i(120793);
            com.tencent.mm.plugin.cdndownloader.c.a.cxZ().aku(str);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "removeDownloadTask: true");
            AppMethodBeat.o(120793);
            return true;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final CDNTaskState akt(String str) {
            AppMethodBeat.i(120794);
            CdnLogic.CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(str);
            CDNTaskState cDNTaskState = new CDNTaskState();
            if (httpMultiSocketDownloadTaskState != null) {
                cDNTaskState.taskState = httpMultiSocketDownloadTaskState.taskState;
                cDNTaskState.fileTotalSize = (long) ((int) httpMultiSocketDownloadTaskState.fileTotalSize);
                cDNTaskState.completeSize = (long) ((int) httpMultiSocketDownloadTaskState.completeSize);
            }
            AppMethodBeat.o(120794);
            return cDNTaskState;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void a(b bVar) {
            AppMethodBeat.i(120795);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "registerCallback");
            b unused = CDNDownloadServiceSlot.qmE = bVar;
            AppMethodBeat.o(120795);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void b(b bVar) {
            AppMethodBeat.i(120796);
            b unused = CDNDownloadServiceSlot.qmE = null;
            AppMethodBeat.o(120796);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void EL(int i2) {
            AppMethodBeat.i(120797);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "notifyNetworkChange: ".concat(String.valueOf(i2)));
            if (!MMApplicationContext.isPushProcess()) {
                Mars.onNetworkChange();
            }
            AppMethodBeat.o(120797);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void cxV() {
            AppMethodBeat.i(120799);
            Log.i("MicroMsg.CDNDownloadServiceSlot", "removeIPCTaskMarker");
            b.a.hnP.b(CDNDownloadServiceSlot.this);
            AppMethodBeat.o(120799);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void cxW() {
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void cxU() {
            AppMethodBeat.i(120798);
            if (!b.a.hnP.c(CDNDownloadServiceSlot.this)) {
                Log.i("MicroMsg.CDNDownloadServiceSlot", "addIPCTaskMarker");
                b.a.hnP.a(CDNDownloadServiceSlot.this);
            }
            AppMethodBeat.o(120798);
        }
    };

    public CDNDownloadServiceSlot() {
        AppMethodBeat.i(120801);
        AppMethodBeat.o(120801);
    }

    static {
        AppMethodBeat.i(120809);
        AppMethodBeat.o(120809);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(120802);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "onBind");
        a.AbstractBinderC0919a aVar = this.qmP;
        AppMethodBeat.o(120802);
        return aVar;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(120803);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(120803);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(120804);
        super.onCreate();
        Log.i("MicroMsg.CDNDownloadServiceSlot", "onCreate");
        AppMethodBeat.o(120804);
    }

    public void onDestroy() {
        AppMethodBeat.i(120805);
        super.onDestroy();
        Log.i("MicroMsg.CDNDownloadServiceSlot", "onDestroy");
        b.a.hnP.b(this);
        h.INSTANCE.idkeyStat(710, 1, 1, false);
        AppMethodBeat.o(120805);
    }

    static /* synthetic */ void b(g gVar, String str) {
        AppMethodBeat.i(120806);
        if (!Util.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                gVar.gqJ = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    gVar.gqJ.put(next, jSONObject.optString(next));
                }
                AppMethodBeat.o(120806);
                return;
            } catch (JSONException e2) {
                Log.e("MicroMsg.CDNDownloadServiceSlot", "addVerifyHeaders: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(120806);
    }

    static /* synthetic */ void X(String str, int i2, int i3) {
        AppMethodBeat.i(120807);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s", str, Integer.valueOf(i2), Integer.valueOf(i3), null);
        try {
            qmE.f(str, i2, i3, null);
            AppMethodBeat.o(120807);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.CDNDownloadServiceSlot", "updateDownloadState: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(120807);
        }
    }

    static /* synthetic */ void y(String str, long j2, long j3) {
        AppMethodBeat.i(120808);
        try {
            qmE.w(str, j2, j3);
            AppMethodBeat.o(120808);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.CDNDownloadServiceSlot", "updateProgressChange: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(120808);
        }
    }
}
