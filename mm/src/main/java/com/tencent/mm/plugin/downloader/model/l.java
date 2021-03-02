package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public final class l extends j {
    private static final String qIb = (b.aKJ() + "WebNetFile");
    private Context mContext = MMApplicationContext.getContext();
    private HashMap<String, Long> qId = new HashMap<>();
    private g.a qJm = new g.a() {
        /* class com.tencent.mm.plugin.downloader.model.l.AnonymousClass4 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            String dVar2;
            AppMethodBeat.i(89036);
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
            Log.d("MicroMsg.FileWebNetDownloader", "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", objArr);
            if (i2 == -21006) {
                Log.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(89036);
            } else if (i2 != 0) {
                Log.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                l.a(l.this, str, 4, i2);
                AppMethodBeat.o(89036);
            } else if (cVar != null) {
                l.a(l.this, str, cVar.field_finishedLength, cVar.field_toltalLength);
                AppMethodBeat.o(89036);
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        l.a(l.this, str, 4, dVar.field_retCode);
                    } else {
                        Log.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", str);
                        l.a(l.this, str, 3, 0);
                    }
                }
                AppMethodBeat.o(89036);
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

    static {
        AppMethodBeat.i(89045);
        AppMethodBeat.o(89045);
    }

    public l(c cVar) {
        super(cVar);
        AppMethodBeat.i(89037);
        AppMethodBeat.o(89037);
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(a aVar) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(g gVar) {
        AppMethodBeat.i(89038);
        if (gVar == null || Util.isNullOrNil(gVar.kMX)) {
            Log.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
            AppMethodBeat.o(89038);
            return -1;
        }
        Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", gVar.kMX);
        String str = gVar.kMX;
        a ale = d.ale(str);
        if (ale != null) {
            FileDownloadTaskInfo Co = Co(ale.field_downloadId);
            Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + Co.status);
            if (Co.status == 1) {
                long j2 = Co.id;
                AppMethodBeat.o(89038);
                return j2;
            }
        }
        d.alc(str);
        d.ald(gVar.mAppId);
        a c2 = h.c(gVar);
        c2.field_downloadId = System.currentTimeMillis();
        c2.field_downloaderType = 4;
        c2.field_filePath = qIb + FilePathGenerator.ANDROID_DIR_SEP + MD5Util.getMD5String(str);
        if (ale != null) {
            String str2 = c2.field_filePath;
            String str3 = ale.field_filePath;
            if (!(str2 == null || str3 == null || str2.equals(str3))) {
                Log.i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", str2, str3);
                o oVar = new o(str3);
                if (oVar.exists()) {
                    Log.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", Boolean.valueOf(oVar.delete()));
                }
            }
        }
        c2.field_startTime = System.currentTimeMillis();
        o oVar2 = new o(qIb);
        if (!oVar2.exists()) {
            if (!oVar2.heq().exists()) {
                o heq = oVar2.heq();
                o oVar3 = new o(aa.z(heq.her()) + System.currentTimeMillis());
                if (oVar3.mkdirs()) {
                    oVar3.am(heq);
                } else {
                    Log.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", aa.z(heq.her()));
                }
            }
            Log.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", Boolean.valueOf(oVar2.mkdirs()));
        }
        g gVar2 = new g();
        gVar2.taskName = "task_FileWebNetDownloader";
        gVar2.gqB = gVar.kMX;
        gVar2.field_mediaId = gVar.kMX;
        if (gVar.qIG == 2) {
            gVar2.field_fileType = com.tencent.mm.i.a.gqc;
            gVar2.gqC = 20;
            if (gVar.qIV) {
                gVar2.gqD = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
            } else {
                gVar2.gqD = 90;
            }
        }
        gVar2.field_fullpath = c2.field_filePath;
        gVar2.gqy = this.qJm;
        boolean b2 = f.baQ().b(gVar2, -1);
        Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: ".concat(String.valueOf(b2)));
        if (b2) {
            c2.field_status = 1;
            d.d(c2);
            this.qIy.m(c2.field_downloadId, c2.field_filePath);
        } else {
            c2.field_status = 4;
            c2.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFm;
            d.d(c2);
            this.qIy.c(c2.field_downloadId, c2.field_errCode, false);
        }
        long j3 = c2.field_downloadId;
        AppMethodBeat.o(89038);
        return j3;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final FileDownloadTaskInfo Co(long j2) {
        AppMethodBeat.i(89039);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        a Cw = d.Cw(j2);
        if (Cw != null) {
            CdnLogic.CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(Cw.field_downloadUrl);
            if (Cw.field_status != 1 || (httpMultiSocketDownloadTaskState != null && (httpMultiSocketDownloadTaskState.taskState == 100 || httpMultiSocketDownloadTaskState.taskState == 101))) {
                fileDownloadTaskInfo.status = Cw.field_status;
            } else {
                fileDownloadTaskInfo.status = 0;
            }
            fileDownloadTaskInfo.qJe = Cw.field_downloadedSize;
            fileDownloadTaskInfo.oJj = Cw.field_totalSize;
            fileDownloadTaskInfo.id = j2;
            fileDownloadTaskInfo.dNv = Cw.field_downloaderType;
            fileDownloadTaskInfo.qJf = Cw.field_autoDownload;
            fileDownloadTaskInfo.path = Cw.field_filePath;
            fileDownloadTaskInfo.url = Cw.field_downloadUrl;
            fileDownloadTaskInfo.md5 = Cw.field_md5;
        }
        AppMethodBeat.o(89039);
        return fileDownloadTaskInfo;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final int Cn(final long j2) {
        AppMethodBeat.i(89040);
        h.RTc.ba(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.l.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(89033);
                a Cw = d.Cw(j2);
                if (Cw == null) {
                    AppMethodBeat.o(89033);
                    return;
                }
                f.baQ().Oc(Cw.field_downloadUrl);
                if (Cw.field_status != 5) {
                    Cw.field_status = 5;
                    d.e(Cw);
                    l.this.qIy.Ct(j2);
                }
                AppMethodBeat.o(89033);
            }
        });
        AppMethodBeat.o(89040);
        return 1;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cp(final long j2) {
        AppMethodBeat.i(89041);
        h.RTc.ba(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.l.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(89034);
                Log.d("MicroMsg.FileWebNetDownloader", JsApiPauseDownloadTask.NAME);
                FileDownloadTaskInfo Co = l.this.Co(j2);
                if (Co != null && Co.status == 1) {
                    CdnLogic.pauseHttpMultiSocketDownloadTask(Co.url);
                    a Cw = d.Cw(j2);
                    if (Cw != null) {
                        Cw.field_status = 2;
                        d.e(Cw);
                    }
                    l.this.qIy.Cu(j2);
                }
                AppMethodBeat.o(89034);
            }
        });
        AppMethodBeat.o(89041);
        return true;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cq(final long j2) {
        AppMethodBeat.i(89042);
        final a Cw = d.Cw(j2);
        if (Cw == null || Cw.field_status != 2) {
            AppMethodBeat.o(89042);
            return false;
        }
        h.RTc.ba(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.l.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(89035);
                int resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(Cw.field_downloadUrl);
                Log.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: ".concat(String.valueOf(resumeHttpMultiSocketDownloadTask)));
                Cw.field_startTime = System.currentTimeMillis();
                Cw.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
                Cw.field_startSize = Cw.field_downloadedSize;
                if (resumeHttpMultiSocketDownloadTask == 0) {
                    Cw.field_status = 1;
                    Cw.field_errCode = 0;
                    d.e(Cw);
                    l.this.qIy.n(j2, Cw.field_filePath);
                    AppMethodBeat.o(89035);
                    return;
                }
                Cw.field_status = 4;
                Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFn;
                d.e(Cw);
                l.this.qIy.c(j2, Cw.field_errCode, false);
                AppMethodBeat.o(89035);
            }
        });
        AppMethodBeat.o(89042);
        return true;
    }

    static /* synthetic */ void a(l lVar, String str, int i2, int i3) {
        AppMethodBeat.i(89043);
        Log.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, url = %s, state = %d, errCode= %d, errMsg = %s", str, Integer.valueOf(i2), Integer.valueOf(i3), null);
        a ale = d.ale(str);
        if (ale == null) {
            Log.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, info is null");
            AppMethodBeat.o(89043);
            return;
        }
        Log.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, url = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i2), Integer.valueOf(i3), null);
        switch (i2) {
            case 4:
                ale.field_errCode = Math.abs(i3);
                ale.field_status = 4;
                d.e(ale);
                lVar.qIy.c(ale.field_downloadId, Math.abs(i3), false);
                AppMethodBeat.o(89043);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.qJa, 1);
                intent.setClass(lVar.mContext, FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, ale.field_downloadId);
                try {
                    com.tencent.mm.br.c.startService(intent);
                    AppMethodBeat.o(89043);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.FileWebNetDownloader", e2.getMessage());
                    break;
                }
        }
        AppMethodBeat.o(89043);
    }

    static /* synthetic */ void a(l lVar, String str, long j2, long j3) {
        AppMethodBeat.i(89044);
        a ale = d.ale(str);
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(ale != null);
        objArr[1] = str;
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Long.valueOf(j3);
        Log.i("MicroMsg.FileWebNetDownloader", "updateProgressChange, info is %s %s %d %d", objArr);
        if (ale != null) {
            Long l = lVar.qId.get(ale.field_downloadUrl);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (l == null || valueOf.longValue() - l.longValue() >= 500) {
                lVar.qId.put(ale.field_downloadUrl, valueOf);
                ale.field_status = 1;
                ale.field_downloadedSize = j2;
                ale.field_totalSize = j3;
                d.e(ale);
                lVar.qIy.b(ale.field_downloadId, str, j2, j3);
            }
        }
        AppMethodBeat.o(89044);
    }
}
