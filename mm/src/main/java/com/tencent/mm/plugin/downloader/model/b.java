package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends j {
    public static final String qIb = (com.tencent.mm.loader.j.b.aKJ() + "BigFile/");
    private byte[] lock = new byte[0];
    private Context mContext = MMApplicationContext.getContext();
    private HashMap<String, Long> qIc = new HashMap<>();
    private HashMap<String, Long> qId = new HashMap<>();
    private ConcurrentHashMap<String, Integer> qIe = new ConcurrentHashMap<>();
    private HashMap<String, Long> qIf = new HashMap<>();
    private HashMap<String, Long> qIg = new HashMap<>();
    private com.tencent.mm.plugin.cdndownloader.d.b qmB = new com.tencent.mm.plugin.cdndownloader.d.b() {
        /* class com.tencent.mm.plugin.downloader.model.b.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.cdndownloader.d.b
        public final void g(String str, int i2, int i3, String str2) {
            boolean z = true;
            AppMethodBeat.i(88907);
            a ale = d.ale(str);
            if (ale == null) {
                h.INSTANCE.idkeyStat(710, 18, 1, false);
                Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
                AppMethodBeat.o(88907);
                return;
            }
            Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
            switch (i2) {
                case 1:
                    d.cW(ale.field_downloadUrl, 1);
                    AppMethodBeat.o(88907);
                    return;
                case 3:
                    ale.field_finishTime = System.currentTimeMillis();
                    ale.field_downloadedSize = ale.field_totalSize;
                    ale.field_status = 6;
                    Log.i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(ale.field_downloadedSize), Long.valueOf(ale.field_startSize));
                    d.e(ale);
                    d.cW(ale.field_downloadUrl, 6);
                    b.this.qIy.Cv(ale.field_downloadId);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.qJa, 1);
                    intent.setClass(b.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, ale.field_downloadId);
                    try {
                        c.startService(intent);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FileCDNDownloader", e2.getMessage());
                    }
                    b.a(b.this, ale.field_downloadUrl);
                    b.this.qIf.remove(ale.field_downloadUrl);
                    b.this.qIg.remove(ale.field_downloadUrl);
                    break;
                case 4:
                    if ((i3 != 21009 && i3 != 21020) || h.CF(ale.field_totalSize)) {
                        z = false;
                    } else if (h.CE(ale.field_totalSize)) {
                        b.this.a(ale);
                        AppMethodBeat.o(88907);
                        return;
                    }
                    ale.field_finishTime = System.currentTimeMillis();
                    ale.field_errCode = Math.abs(i3);
                    ale.field_status = 4;
                    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) && ale.field_downloadInWifi) {
                        ale.field_downloadInWifi = false;
                        ale.field_reserveInWifi = false;
                    }
                    d.e(ale);
                    b.this.qIy.c(ale.field_downloadId, Math.abs(i3), false);
                    b.a(b.this, ale.field_downloadUrl, z);
                    b.this.qIf.remove(ale.field_downloadUrl);
                    b.this.qIg.remove(ale.field_downloadUrl);
                    AppMethodBeat.o(88907);
                    return;
            }
            AppMethodBeat.o(88907);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.d.b
        public final void x(String str, long j2, long j3) {
            AppMethodBeat.i(88908);
            Log.d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", Long.valueOf(j3), Long.valueOf(j2));
            a ale = d.ale(str);
            if (ale == null) {
                Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
                AppMethodBeat.o(88908);
                return;
            }
            if (ale.field_downloadInWifi && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                b.this.Cs(ale.field_downloadId);
            }
            Long valueOf = Long.valueOf(Util.nullAsNil((Long) b.this.qIf.get(ale.field_downloadUrl)));
            if (valueOf.longValue() == 0) {
                valueOf = Long.valueOf(j2);
                b.this.qIf.put(ale.field_downloadUrl, Long.valueOf(j2));
            }
            long longValue = j2 - valueOf.longValue();
            if (j3 == 0) {
                Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
            } else {
                int i2 = (int) ((((float) j2) / ((float) j3)) * 100.0f);
                if ((100 * longValue) / j3 >= 1) {
                    long nullAs = Util.nullAs((Long) b.this.qIg.get(ale.field_downloadUrl), ale.field_startTime);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = currentTimeMillis - nullAs;
                    float f2 = ((((float) longValue) * 1000.0f) / ((float) j4)) / 1048576.0f;
                    Log.d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", ale.field_appId, Float.valueOf(f2), Long.valueOf(j4), Long.valueOf(longValue), Long.valueOf(j3), Integer.valueOf(i2));
                    com.tencent.mm.plugin.downloader.i.b.a(ale.field_downloadId, f2, i2);
                    b.this.qIg.put(ale.field_downloadUrl, Long.valueOf(currentTimeMillis));
                    b.this.qIf.put(ale.field_downloadUrl, Long.valueOf(j2));
                }
            }
            Long valueOf2 = Long.valueOf(Util.nullAsNil((Long) b.this.qId.get(ale.field_downloadUrl)));
            Long valueOf3 = Long.valueOf(System.currentTimeMillis());
            long longValue2 = valueOf3.longValue() - valueOf2.longValue();
            if (valueOf2 == null || longValue2 <= 0 || longValue2 >= 500) {
                b.this.qId.put(ale.field_downloadUrl, valueOf3);
                ale.field_downloadedSize = j2;
                ale.field_totalSize = j3;
                d.e(ale);
                b.this.qIy.b(ale.field_downloadId, str, j2, j3);
                int i3 = 0;
                if (j3 > 0) {
                    i3 = (int) ((((float) j2) / ((float) j3)) * 100.0f);
                }
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 > 100) {
                    i3 = 100;
                }
                b.a(b.this, ale.field_downloadUrl, i3, false);
                AppMethodBeat.o(88908);
                return;
            }
            AppMethodBeat.o(88908);
        }
    };

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(88927);
        bVar.cancelNotification(str);
        AppMethodBeat.o(88927);
    }

    static /* synthetic */ void a(b bVar, String str, boolean z) {
        AppMethodBeat.i(88926);
        bVar.a(str, 4, 0, false, z);
        AppMethodBeat.o(88926);
    }

    static /* synthetic */ CDNTaskInfo c(a aVar) {
        AppMethodBeat.i(88929);
        CDNTaskInfo b2 = b(aVar);
        AppMethodBeat.o(88929);
        return b2;
    }

    static {
        AppMethodBeat.i(88930);
        AppMethodBeat.o(88930);
    }

    public b(c cVar) {
        super(cVar);
        AppMethodBeat.i(88913);
        com.tencent.mm.plugin.cdndownloader.d.a.cya().qmB = this.qmB;
        AppMethodBeat.o(88913);
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(final a aVar) {
        AppMethodBeat.i(88914);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(88909);
                com.tencent.mm.plugin.downloader.a.c.h(aVar.field_appId, aVar.field_downloadUrl, aVar.field_secondaryUrl);
                com.tencent.mm.plugin.r.a.eAU();
                n.bdK(aVar.field_appId);
                int a2 = com.tencent.mm.plugin.cdndownloader.d.a.cya().a(b.c(aVar));
                Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", Integer.valueOf(a2), Long.valueOf(aVar.field_downloadId));
                if (a2 == 0) {
                    aVar.field_status = 1;
                    aVar.field_startTime = System.currentTimeMillis();
                    d.d(aVar);
                    b.this.qIy.m(aVar.field_downloadId, aVar.field_filePath);
                    b.a(b.this, aVar.field_downloadUrl, 0, true);
                    AppMethodBeat.o(88909);
                } else if (a2 == -2) {
                    aVar.field_status = 1;
                    aVar.field_startTime = System.currentTimeMillis();
                    d.d(aVar);
                    AppMethodBeat.o(88909);
                } else if (a2 == 1) {
                    aVar.field_status = 6;
                    a aVar = aVar;
                    a aVar2 = aVar;
                    a aVar3 = aVar;
                    long boW = s.boW(aVar.field_filePath);
                    aVar3.field_totalSize = boW;
                    aVar2.field_downloadedSize = boW;
                    aVar.field_startSize = boW;
                    a aVar4 = aVar;
                    a aVar5 = aVar;
                    long currentTimeMillis = System.currentTimeMillis();
                    aVar5.field_finishTime = currentTimeMillis;
                    aVar4.field_startTime = currentTimeMillis;
                    d.d(aVar);
                    b.this.qIy.Cv(aVar.field_downloadId);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.qJa, 1);
                    intent.setClass(b.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, aVar.field_downloadId);
                    try {
                        c.startService(intent);
                        AppMethodBeat.o(88909);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FileCDNDownloader", e2.getMessage());
                        AppMethodBeat.o(88909);
                    }
                } else {
                    aVar.field_status = 4;
                    aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFm;
                    d.d(aVar);
                    b.this.qIy.c(aVar.field_downloadId, aVar.field_errCode, false);
                    AppMethodBeat.o(88909);
                }
            }
        });
        long j2 = aVar.field_downloadId;
        AppMethodBeat.o(88914);
        return j2;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(g gVar) {
        a aVar;
        AppMethodBeat.i(88915);
        if (gVar == null || Util.isNullOrNil(gVar.kMX)) {
            Log.e("MicroMsg.FileCDNDownloader", "Invalid Request");
            AppMethodBeat.o(88915);
            return -1;
        }
        Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, appId : %s", gVar.mAppId);
        String str = gVar.kMX;
        a ale = d.ale(str);
        if (ale == null) {
            aVar = d.alb(gVar.mAppId);
        } else {
            aVar = ale;
        }
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        if (!(aVar == null || (fileDownloadTaskInfo = Co(aVar.field_downloadId)) == null)) {
            Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + fileDownloadTaskInfo.status);
            if (fileDownloadTaskInfo.status == 1 || fileDownloadTaskInfo.status == 6) {
                long j2 = fileDownloadTaskInfo.id;
                AppMethodBeat.o(88915);
                return j2;
            } else if (fileDownloadTaskInfo.status == 3) {
                if (aVar.field_autoInstall) {
                    com.tencent.mm.plugin.downloader.i.a.a(fileDownloadTaskInfo.id, false, null);
                }
                long j3 = fileDownloadTaskInfo.id;
                AppMethodBeat.o(88915);
                return j3;
            }
        }
        if (aVar != null) {
            d.Cx(aVar.field_downloadId);
        }
        a c2 = h.c(gVar);
        if (!gVar.qIL || aVar == null) {
            c2.field_downloadId = System.currentTimeMillis();
        } else {
            c2.field_downloadId = aVar.field_downloadId;
        }
        c2.field_downloaderType = 3;
        if (!Util.isNullOrNil(gVar.qIW)) {
            c2.field_filePath = gVar.qIW;
        } else {
            c2.field_filePath = qIb + MD5Util.getMD5String(str);
        }
        String str2 = c2.field_filePath;
        o oVar = new o(str2.substring(0, str2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP) + 1));
        if (!oVar.exists()) {
            if (!oVar.heq().exists()) {
                o heq = oVar.heq();
                o oVar2 = new o(aa.z(heq.her()) + System.currentTimeMillis());
                if (oVar2.mkdirs()) {
                    oVar2.am(heq);
                } else {
                    Log.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", aa.z(heq.her()));
                }
            }
            Log.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", Boolean.valueOf(oVar.mkdirs()));
        }
        if (fileDownloadTaskInfo != null) {
            String str3 = c2.field_filePath;
            String str4 = fileDownloadTaskInfo.path;
            if (!(str3 == null || str4 == null || str3.equals(str4))) {
                Log.i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", str3, str4);
                o oVar3 = new o(str4);
                if (oVar3.exists()) {
                    Log.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", Boolean.valueOf(oVar3.delete()));
                }
            }
            if (fileDownloadTaskInfo.status == 2) {
                c2.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
            } else if (fileDownloadTaskInfo.status == 4) {
                c2.field_startState = com.tencent.mm.plugin.downloader.a.b.qFA;
            } else {
                c2.field_startState = com.tencent.mm.plugin.downloader.a.b.qFy;
            }
            c2.field_startSize = fileDownloadTaskInfo.qJe;
            Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + fileDownloadTaskInfo.qJe);
        } else {
            c2.field_startState = com.tencent.mm.plugin.downloader.a.b.qFy;
        }
        if (!gVar.lBG || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                c2.field_downloadInWifi = true;
            }
            long a2 = a(c2);
            AppMethodBeat.o(88915);
            return a2;
        }
        Log.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        c2.field_status = 0;
        c2.field_downloadInWifi = true;
        d.d(c2);
        long j4 = c2.field_downloadId;
        AppMethodBeat.o(88915);
        return j4;
    }

    private static CDNTaskInfo b(a aVar) {
        AppMethodBeat.i(88916);
        CDNTaskInfo cDNTaskInfo = new CDNTaskInfo();
        cDNTaskInfo.gqH = true;
        cDNTaskInfo.mediaId = aVar.field_downloadUrl;
        cDNTaskInfo.downloadUrl = aVar.field_downloadUrl;
        cDNTaskInfo.filePath = aVar.field_filePath;
        cDNTaskInfo.qmH = aVar.field_secondaryUrl;
        cDNTaskInfo.qmJ = 15;
        cDNTaskInfo.qmK = LocalCache.TIME_HOUR;
        cDNTaskInfo.qmL = true;
        cDNTaskInfo.qmM = aVar.field_downloadInWifi;
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar.field_fileSize > 0) {
                jSONObject.put("Content-Length", aVar.field_fileSize);
            }
            cDNTaskInfo.qmI = jSONObject.toString();
        } catch (JSONException e2) {
            Log.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + e2.getMessage());
        }
        AppMethodBeat.o(88916);
        return cDNTaskInfo;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final int Cn(final long j2) {
        AppMethodBeat.i(88917);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(88910);
                FileDownloadTaskInfo Co = b.this.Co(j2);
                if (Co == null) {
                    AppMethodBeat.o(88910);
                    return;
                }
                com.tencent.mm.plugin.cdndownloader.d.a.cya().aks(Co.url);
                b.a(b.this, Co.url);
                s.deleteFile(Co.path);
                Log.i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", Co.path);
                if (Co.status != 5) {
                    a Cw = d.Cw(j2);
                    if (Cw == null) {
                        AppMethodBeat.o(88910);
                        return;
                    }
                    Cw.field_finishTime = System.currentTimeMillis();
                    Cw.field_downloadedSize = Co.qJe;
                    Cw.field_status = 5;
                    d.e(Cw);
                    d.cW(Cw.field_downloadUrl, 5);
                    Long valueOf = Long.valueOf(Util.nullAs((Long) b.this.qIg.get(Co.url), Cw.field_startTime));
                    if (valueOf != null) {
                        Long valueOf2 = Long.valueOf(Util.nullAs((Long) b.this.qIf.get(Co.url), Cw.field_startSize));
                        long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                        com.tencent.mm.plugin.downloader.i.b.a(j2, ((((float) (Co.qJe - valueOf2.longValue())) * 1000.0f) / ((float) currentTimeMillis)) / 1048576.0f, (int) ((((float) Co.qJe) / ((float) Co.oJj)) * 100.0f));
                    }
                    b.this.qIf.remove(Co.url);
                    b.this.qIg.remove(Co.url);
                    b.this.qIy.Ct(j2);
                }
                AppMethodBeat.o(88910);
            }
        });
        AppMethodBeat.o(88917);
        return 1;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final FileDownloadTaskInfo Co(long j2) {
        AppMethodBeat.i(88918);
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        a Cw = d.Cw(j2);
        if (Cw != null) {
            Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, downloadid ; %d, appId : %s, status : %d", Long.valueOf(Cw.field_downloadId), Cw.field_appId, Integer.valueOf(Cw.field_status));
            FileDownloadTaskInfo fileDownloadTaskInfo2 = new FileDownloadTaskInfo();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            CDNTaskState akt = com.tencent.mm.plugin.cdndownloader.d.a.cya().akt(Cw.field_downloadUrl);
            if (akt != null) {
                Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, cdntaskstate: %d", Integer.valueOf(akt.taskState));
                switch (akt.taskState) {
                    case 100:
                        fileDownloadTaskInfo2.status = 1;
                        fileDownloadTaskInfo2.qJe = akt.completeSize;
                        fileDownloadTaskInfo2.oJj = akt.fileTotalSize;
                        break;
                    case 101:
                        fileDownloadTaskInfo2.status = 1;
                        fileDownloadTaskInfo2.qJe = Cw.field_downloadedSize;
                        fileDownloadTaskInfo2.oJj = Cw.field_totalSize;
                        break;
                    case 102:
                        fileDownloadTaskInfo2.status = 2;
                        fileDownloadTaskInfo2.qJe = akt.completeSize;
                        fileDownloadTaskInfo2.oJj = akt.fileTotalSize;
                        break;
                    case 103:
                    default:
                        if (Cw.field_status == 1) {
                            fileDownloadTaskInfo2.status = 0;
                        } else {
                            fileDownloadTaskInfo2.status = Cw.field_status;
                        }
                        fileDownloadTaskInfo2.qJe = Cw.field_downloadedSize;
                        fileDownloadTaskInfo2.oJj = Cw.field_totalSize;
                        break;
                    case 104:
                        if (s.YS(Cw.field_filePath)) {
                            if (Cw.field_status != 6) {
                                fileDownloadTaskInfo2.status = 3;
                                break;
                            } else {
                                fileDownloadTaskInfo2.status = 6;
                                break;
                            }
                        } else {
                            fileDownloadTaskInfo2.status = 0;
                            break;
                        }
                }
                fileDownloadTaskInfo2.qJe = fileDownloadTaskInfo2.qJe > fileDownloadTaskInfo2.oJj ? fileDownloadTaskInfo2.oJj : fileDownloadTaskInfo2.qJe;
                Cw.field_downloadedSize = fileDownloadTaskInfo2.qJe;
                Cw.field_totalSize = fileDownloadTaskInfo2.oJj;
            } else {
                if (Cw.field_status == 1) {
                    fileDownloadTaskInfo2.status = 0;
                } else {
                    fileDownloadTaskInfo2.status = Cw.field_status;
                }
                if (!s.YS(Cw.field_filePath)) {
                    fileDownloadTaskInfo2.qJe = 0;
                    fileDownloadTaskInfo2.oJj = 0;
                } else {
                    fileDownloadTaskInfo2.qJe = Cw.field_downloadedSize;
                    fileDownloadTaskInfo2.oJj = Cw.field_totalSize;
                }
            }
            if ((fileDownloadTaskInfo2.status == 6 || fileDownloadTaskInfo2.status == 3) && !s.YS(Cw.field_filePath)) {
                fileDownloadTaskInfo2.status = 0;
            }
            if (fileDownloadTaskInfo2.status == 6 && !e.CA(fileDownloadTaskInfo2.id)) {
                fileDownloadTaskInfo2.status = 3;
            }
            fileDownloadTaskInfo2.id = j2;
            fileDownloadTaskInfo2.dNv = Cw.field_downloaderType;
            fileDownloadTaskInfo2.qJf = Cw.field_autoDownload;
            fileDownloadTaskInfo2.path = Cw.field_filePath;
            fileDownloadTaskInfo2.url = Cw.field_downloadUrl;
            fileDownloadTaskInfo2.md5 = Cw.field_md5;
            if (Cw.field_status != fileDownloadTaskInfo2.status && (fileDownloadTaskInfo2.status == 1 || Cw.field_status == 1)) {
                Cw.field_status = fileDownloadTaskInfo2.status;
                d.e(Cw);
            }
            Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", fileDownloadTaskInfo2.url, Integer.valueOf(fileDownloadTaskInfo2.status), Long.valueOf(fileDownloadTaskInfo2.qJe), Long.valueOf(fileDownloadTaskInfo2.oJj));
            fileDownloadTaskInfo = fileDownloadTaskInfo2;
        }
        AppMethodBeat.o(88918);
        return fileDownloadTaskInfo;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cp(final long j2) {
        AppMethodBeat.i(88919);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(88911);
                Log.i("MicroMsg.FileCDNDownloader", JsApiPauseDownloadTask.NAME);
                FileDownloadTaskInfo Co = b.this.Co(j2);
                if (Co != null && Co.status == 1) {
                    com.tencent.mm.plugin.cdndownloader.d.a.cya().akr(Co.url);
                    b.a(b.this, Co.url);
                    a Cw = d.Cw(j2);
                    if (Cw != null) {
                        Cw.field_finishTime = System.currentTimeMillis();
                        Cw.field_status = 2;
                        Cw.field_downloadedSize = Co.qJe;
                        d.e(Cw);
                        Long valueOf = Long.valueOf(Util.nullAs((Long) b.this.qIg.get(Co.url), Cw.field_startTime));
                        if (valueOf != null) {
                            Long valueOf2 = Long.valueOf(Util.nullAs((Long) b.this.qIf.get(Co.url), Cw.field_startSize));
                            long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                            com.tencent.mm.plugin.downloader.i.b.a(Cw.field_downloadId, ((((float) (Cw.field_downloadedSize - valueOf2.longValue())) * 1000.0f) / ((float) currentTimeMillis)) / 1048576.0f, (int) ((((float) Cw.field_downloadedSize) / ((float) Cw.field_totalSize)) * 100.0f));
                        }
                    }
                    b.this.qIf.remove(Co.url);
                    b.this.qIg.remove(Co.url);
                    b.this.qIy.Cu(j2);
                }
                AppMethodBeat.o(88911);
            }
        });
        AppMethodBeat.o(88919);
        return true;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cq(long j2) {
        AppMethodBeat.i(88920);
        boolean n = n(j2, true);
        AppMethodBeat.o(88920);
        return n;
    }

    public final boolean n(final long j2, final boolean z) {
        AppMethodBeat.i(88921);
        final a Cw = d.Cw(j2);
        if (Cw != null) {
            FileDownloadTaskInfo Co = Co(Cw.field_downloadId);
            if (Co == null) {
                AppMethodBeat.o(88921);
                return false;
            } else if (Co.status == 1 || Co.status == 6) {
                AppMethodBeat.o(88921);
                return true;
            } else if (Co.status == 3) {
                if (Cw.field_autoInstall) {
                    com.tencent.mm.plugin.downloader.i.a.a(Co.id, false, null);
                }
                AppMethodBeat.o(88921);
                return true;
            } else if ((Cw.field_reserveInWifi || Cw.field_downloadInWifi) && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
                AppMethodBeat.o(88921);
                return true;
            } else {
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                    Cw.field_downloadInWifi = true;
                }
                com.tencent.mm.ch.a.post(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader.model.b.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(88912);
                        com.tencent.mm.plugin.downloader.a.c.h(Cw.field_appId, Cw.field_downloadUrl, Cw.field_secondaryUrl);
                        com.tencent.mm.plugin.r.a.eAU();
                        n.bdK(Cw.field_appId);
                        int b2 = com.tencent.mm.plugin.cdndownloader.d.a.cya().b(b.c(Cw));
                        Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: ".concat(String.valueOf(b2)));
                        Cw.field_startTime = System.currentTimeMillis();
                        Cw.field_startSize = Cw.field_downloadedSize;
                        Cw.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
                        if (b2 == 0) {
                            Cw.field_status = 1;
                            Cw.field_errCode = 0;
                            d.e(Cw);
                            if (z) {
                                b.this.qIy.n(j2, Cw.field_filePath);
                            }
                            long j2 = 0;
                            if (Cw.field_totalSize != 0) {
                                j2 = (Cw.field_downloadedSize * 100) / Cw.field_totalSize;
                            }
                            Log.d("MicroMsg.FileCDNDownloader", "resumeDownloadTask, progress = %d, downloadedSize = %d, totalSize = %d", Long.valueOf(j2), Long.valueOf(Cw.field_downloadedSize), Long.valueOf(Cw.field_totalSize));
                            b.a(b.this, Cw.field_downloadUrl, (int) j2, true);
                            AppMethodBeat.o(88912);
                        } else if (b2 == -2) {
                            Cw.field_status = 1;
                            Cw.field_errCode = 0;
                            d.e(Cw);
                            AppMethodBeat.o(88912);
                        } else if (b2 != 1) {
                            Cw.field_status = 4;
                            Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFn;
                            d.e(Cw);
                            b.this.qIy.c(j2, Cw.field_errCode, false);
                            AppMethodBeat.o(88912);
                        } else if (Cw.field_status == 6 || Cw.field_status == 3) {
                            AppMethodBeat.o(88912);
                        } else {
                            Cw.field_status = 6;
                            a aVar = Cw;
                            a aVar2 = Cw;
                            long j3 = Cw.field_totalSize;
                            aVar2.field_downloadedSize = j3;
                            aVar.field_startSize = j3;
                            a aVar3 = Cw;
                            a aVar4 = Cw;
                            long currentTimeMillis = System.currentTimeMillis();
                            aVar4.field_finishTime = currentTimeMillis;
                            aVar3.field_startTime = currentTimeMillis;
                            d.e(Cw);
                            b.this.qIy.Cv(Cw.field_downloadId);
                            Intent intent = new Intent();
                            intent.putExtra(FileDownloadService.qJa, 1);
                            intent.setClass(b.this.mContext, FileDownloadService.class);
                            intent.putExtra(FileDownloadService.EXTRA_ID, Cw.field_downloadId);
                            try {
                                c.startService(intent);
                                AppMethodBeat.o(88912);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.FileCDNDownloader", e2.getMessage());
                                AppMethodBeat.o(88912);
                            }
                        }
                    }
                });
                AppMethodBeat.o(88921);
                return true;
            }
        } else {
            AppMethodBeat.o(88921);
            return false;
        }
    }

    public final boolean Cr(long j2) {
        AppMethodBeat.i(88922);
        Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(j2)));
        boolean n = n(j2, false);
        AppMethodBeat.o(88922);
        return n;
    }

    private void a(String str, int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(88923);
        Log.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
        a ale = d.ale(str);
        if (ale == null) {
            Log.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
            AppMethodBeat.o(88923);
        } else if (!ale.field_showNotification) {
            AppMethodBeat.o(88923);
        } else {
            s.c cd = com.tencent.mm.bq.a.cd(this.mContext, "reminder_channel_id");
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                this.qIc.put(str, Long.valueOf(currentTimeMillis));
                cd.i(currentTimeMillis);
            } else {
                Long l = this.qIc.get(str);
                if (l != null) {
                    cd.i(l.longValue());
                } else {
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    this.qIc.put(str, valueOf);
                    cd.i(valueOf.longValue());
                }
            }
            if (!Util.isNullOrNil(ale.field_notificationTitle)) {
                cd.f(ale.field_notificationTitle + " · " + MMApplicationContext.getContext().getString(R.string.cdj));
            } else {
                g o = com.tencent.mm.pluginsdk.model.app.h.o(ale.field_appId, false, false);
                if (o == null || Util.isNullOrNil(o.field_appName)) {
                    cd.f(ale.field_fileName);
                } else {
                    cd.f(o.field_appName);
                }
            }
            switch (i2) {
                case 1:
                    cd.as(17301633);
                    if (i3 == 0) {
                        i3 = 1;
                    }
                    cd.b(100, i3, i3 == 0);
                    if (ale.field_reserveInWifi) {
                        cd.g(this.mContext.getString(R.string.cdq) + "·" + this.mContext.getString(R.string.cdo));
                    } else {
                        cd.g(this.mContext.getString(R.string.cdo));
                    }
                    cd.g(2, true);
                    Intent intent = new Intent(this.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", ale.field_downloadId);
                    cd.Hv = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 2:
                case 3:
                default:
                    cancelNotification(str);
                    AppMethodBeat.o(88923);
                    return;
                case 4:
                    cd.as(17301634);
                    cd.E(true);
                    cd.Hv = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, new Intent(), 0);
                    if (!z2) {
                        cd.g(this.mContext.getString(R.string.cdl));
                        break;
                    } else {
                        cd.g(this.mContext.getString(R.string.cdm));
                        break;
                    }
            }
            synchronized (this.lock) {
                try {
                    Integer num = this.qIe.get(str);
                    if (num == null) {
                        this.qIe.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(cd.build())));
                    } else {
                        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), cd.build());
                    }
                    if (i2 == 4) {
                        this.qIe.remove(str);
                    }
                } finally {
                    AppMethodBeat.o(88923);
                }
            }
        }
    }

    private void cancelNotification(String str) {
        AppMethodBeat.i(88924);
        synchronized (this.lock) {
            try {
                Integer num = this.qIe.get(str);
                if (num == null) {
                    Log.i("MicroMsg.FileCDNDownloader", "No notification id found");
                    return;
                }
                ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
                Log.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = ".concat(String.valueOf(num)));
                this.qIe.remove(str);
                AppMethodBeat.o(88924);
            } finally {
                AppMethodBeat.o(88924);
            }
        }
    }

    public final boolean Cs(long j2) {
        AppMethodBeat.i(88925);
        a Cw = d.Cw(j2);
        if (Cw != null) {
            Cw.field_downloadType = 2;
            d.e(Cw);
        }
        com.tencent.mm.plugin.downloader.f.a.p(j2, 13);
        boolean Cp = Cp(j2);
        AppMethodBeat.o(88925);
        return Cp;
    }

    static /* synthetic */ void a(b bVar, String str, int i2, boolean z) {
        AppMethodBeat.i(88928);
        bVar.a(str, 1, i2, z, false);
        AppMethodBeat.o(88928);
    }
}
