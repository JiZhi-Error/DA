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

public class CDNDownloadService extends Service implements a {
    private static b qmE;
    private static g.a qmQ = new g.a() {
        /* class com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService.AnonymousClass2 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            String dVar2;
            AppMethodBeat.i(120780);
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
            Log.d("MicroMsg.CDNDownloadService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", objArr);
            if (i2 == -21006) {
                Log.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(120780);
            } else if (i2 != 0) {
                Log.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                CDNDownloadService.X(str, 4, i2);
                AppMethodBeat.o(120780);
            } else if (cVar != null) {
                CDNDownloadService.y(str, cVar.field_finishedLength, cVar.field_toltalLength);
                AppMethodBeat.o(120780);
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        CDNDownloadService.X(str, 4, dVar.field_retCode);
                    } else {
                        Log.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", str);
                        CDNDownloadService.X(str, 3, 0);
                    }
                }
                AppMethodBeat.o(120780);
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
        /* class com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final int a(CDNTaskInfo cDNTaskInfo) {
            AppMethodBeat.i(120770);
            Log.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", cDNTaskInfo.downloadUrl, cDNTaskInfo.filePath);
            g gVar = new g();
            gVar.taskName = "task_CDNDownloadService_1";
            gVar.gqH = cDNTaskInfo.gqH;
            gVar.field_mediaId = cDNTaskInfo.mediaId;
            gVar.field_fullpath = cDNTaskInfo.filePath;
            gVar.gqB = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.downloadUrl);
            gVar.gqI = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.qmH);
            gVar.gqy = CDNDownloadService.qmQ;
            gVar.gqC = cDNTaskInfo.qmJ;
            gVar.gqD = cDNTaskInfo.qmK;
            gVar.allow_mobile_net_download = cDNTaskInfo.qmL;
            gVar.gqG = cDNTaskInfo.qmM;
            CDNDownloadService.a(gVar, cDNTaskInfo.qmI);
            int h2 = com.tencent.mm.plugin.cdndownloader.c.a.cxZ().h(gVar);
            Log.i("MicroMsg.CDNDownloadService", "addDownloadTask: ".concat(String.valueOf(h2)));
            AppMethodBeat.o(120770);
            return h2;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final int b(CDNTaskInfo cDNTaskInfo) {
            AppMethodBeat.i(120771);
            Log.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", cDNTaskInfo.downloadUrl);
            g gVar = new g();
            gVar.taskName = "task_CDNDownloadService_2";
            gVar.gqH = cDNTaskInfo.gqH;
            gVar.field_mediaId = cDNTaskInfo.mediaId;
            gVar.field_fullpath = cDNTaskInfo.filePath;
            gVar.gqB = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.downloadUrl);
            gVar.gqI = com.tencent.mm.plugin.downloader.a.c.akX(cDNTaskInfo.qmH);
            gVar.gqy = CDNDownloadService.qmQ;
            gVar.gqC = cDNTaskInfo.qmJ;
            gVar.gqD = cDNTaskInfo.qmK;
            gVar.gqG = cDNTaskInfo.qmM;
            gVar.allow_mobile_net_download = cDNTaskInfo.qmL;
            gVar.is_resume_task = true;
            CDNDownloadService.a(gVar, cDNTaskInfo.qmI);
            int i2 = com.tencent.mm.plugin.cdndownloader.c.a.cxZ().i(gVar);
            Log.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(120771);
            return i2;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final boolean akr(String str) {
            AppMethodBeat.i(120772);
            com.tencent.mm.plugin.cdndownloader.c.a.cxZ().Oc(str);
            Log.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: true");
            AppMethodBeat.o(120772);
            return true;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final boolean aks(String str) {
            AppMethodBeat.i(120773);
            com.tencent.mm.plugin.cdndownloader.c.a.cxZ().aku(str);
            Log.i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
            AppMethodBeat.o(120773);
            return true;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final CDNTaskState akt(String str) {
            AppMethodBeat.i(120774);
            CdnLogic.CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(str);
            CDNTaskState cDNTaskState = new CDNTaskState();
            if (httpMultiSocketDownloadTaskState != null) {
                cDNTaskState.taskState = httpMultiSocketDownloadTaskState.taskState;
                cDNTaskState.fileTotalSize = (long) ((int) httpMultiSocketDownloadTaskState.fileTotalSize);
                cDNTaskState.completeSize = (long) ((int) httpMultiSocketDownloadTaskState.completeSize);
            }
            AppMethodBeat.o(120774);
            return cDNTaskState;
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void a(b bVar) {
            AppMethodBeat.i(120775);
            Log.i("MicroMsg.CDNDownloadService", "registerCallback");
            b unused = CDNDownloadService.qmE = bVar;
            AppMethodBeat.o(120775);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void b(b bVar) {
            AppMethodBeat.i(120776);
            b unused = CDNDownloadService.qmE = null;
            AppMethodBeat.o(120776);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void EL(int i2) {
            AppMethodBeat.i(120777);
            Log.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: ".concat(String.valueOf(i2)));
            if (!MMApplicationContext.isPushProcess()) {
                Mars.onNetworkChange();
            }
            AppMethodBeat.o(120777);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void cxV() {
            AppMethodBeat.i(120779);
            Log.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
            b.a.hnP.b(CDNDownloadService.this);
            AppMethodBeat.o(120779);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void cxW() {
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.a
        public final void cxU() {
            AppMethodBeat.i(120778);
            if (!b.a.hnP.c(CDNDownloadService.this)) {
                Log.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
                b.a.hnP.a(CDNDownloadService.this);
            }
            AppMethodBeat.o(120778);
        }
    };

    public CDNDownloadService() {
        AppMethodBeat.i(120781);
        AppMethodBeat.o(120781);
    }

    static {
        AppMethodBeat.i(120789);
        AppMethodBeat.o(120789);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(120782);
        Log.i("MicroMsg.CDNDownloadService", "onBind");
        a.AbstractBinderC0919a aVar = this.qmP;
        AppMethodBeat.o(120782);
        return aVar;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(120783);
        Log.i("MicroMsg.CDNDownloadService", "onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(120783);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(120784);
        super.onCreate();
        Log.i("MicroMsg.CDNDownloadService", "onCreate");
        AppMethodBeat.o(120784);
    }

    public void onDestroy() {
        AppMethodBeat.i(120785);
        super.onDestroy();
        Log.i("MicroMsg.CDNDownloadService", "onDestroy");
        b.a.hnP.b(this);
        h.INSTANCE.idkeyStat(710, 1, 1, false);
        AppMethodBeat.o(120785);
    }

    static /* synthetic */ void a(g gVar, String str) {
        AppMethodBeat.i(120786);
        if (!Util.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                gVar.gqJ = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    gVar.gqJ.put(next, jSONObject.optString(next));
                }
                AppMethodBeat.o(120786);
                return;
            } catch (JSONException e2) {
                Log.e("MicroMsg.CDNDownloadService", "addVerifyHeaders: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(120786);
    }

    static /* synthetic */ void X(String str, int i2, int i3) {
        AppMethodBeat.i(120787);
        Log.i("MicroMsg.CDNDownloadService", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s", str, Integer.valueOf(i2), Integer.valueOf(i3), null);
        try {
            qmE.f(str, i2, i3, null);
            AppMethodBeat.o(120787);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.CDNDownloadService", "updateDownloadState: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(120787);
        }
    }

    static /* synthetic */ void y(String str, long j2, long j3) {
        AppMethodBeat.i(120788);
        try {
            qmE.w(str, j2, j3);
            AppMethodBeat.o(120788);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.CDNDownloadService", "updateProgressChange: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(120788);
        }
    }
}
