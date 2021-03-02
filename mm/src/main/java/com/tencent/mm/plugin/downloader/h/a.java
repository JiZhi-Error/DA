package com.tencent.mm.plugin.downloader.h;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.support.v4.app.s;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.plugin.downloader.i.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.j;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends j {
    private byte[] lock = new byte[0];
    private TMAssistantDownloadSDKClient mClient = null;
    Context mContext = MMApplicationContext.getContext();
    HashMap<String, Long> qIf = new HashMap<>();
    HashMap<String, Long> qIg = new HashMap<>();
    private HashMap<String, Long> qJK = new HashMap<>();
    HashMap<String, Long> qJL = new HashMap<>();
    private ConcurrentHashMap<String, Integer> qJM = new ConcurrentHashMap<>();
    HashSet<Long> qJN = new HashSet<>();
    Map<String, String> qJO = null;
    MTimerHandler qJP = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.downloader.h.a.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(89102);
            if (!a.this.cBM()) {
                a.this.qJP.startTimer(240000);
            }
            AppMethodBeat.o(89102);
            return true;
        }
    }, false);
    private ITMAssistantDownloadSDKClientListener qJQ = new ITMAssistantDownloadSDKClientListener() {
        /* class com.tencent.mm.plugin.downloader.h.a.AnonymousClass5 */

        @Override // com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener
        public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
            AppMethodBeat.i(89103);
            Log.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
            Iterator<Long> it = a.this.qJN.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(it.next().longValue());
                if (Cw != null) {
                    Cw.field_finishTime = System.currentTimeMillis();
                    Cw.field_status = 4;
                    Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFi;
                    d.e(Cw);
                    a.this.qIy.c(Cw.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFi, false);
                    a.a(a.this, Cw.field_downloadUrl, 5, 0, false);
                }
            }
            a.this.qJN.clear();
            AppMethodBeat.o(89103);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener
        public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i2, int i3, String str2, boolean z, boolean z2) {
            AppMethodBeat.i(89104);
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + i2 + " | ErrorCode: " + i3 + " | ErrorMsg: " + str2);
            com.tencent.mm.plugin.downloader.g.a ale = d.ale(str);
            if (ale == null) {
                Log.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                AppMethodBeat.o(89104);
                return;
            }
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", Integer.valueOf(i2), Long.valueOf(ale.field_downloadId), ale.field_filePath, Boolean.valueOf(s.YS(ale.field_filePath)), str);
            if (!(i2 == 1 || i2 == 2)) {
                FileDownloadTaskInfo Co = a.this.Co(ale.field_downloadId);
                long nullAs = Util.nullAs(a.this.qIg.get(ale.field_downloadUrl), ale.field_startTime);
                float nullAs2 = ((((float) (Co.qJe - Util.nullAs(a.this.qIf.get(ale.field_downloadUrl), ale.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - nullAs))) / 1048576.0f;
                b.a(ale.field_downloadId, nullAs2, (int) ((((float) Co.qJe) / ((float) Co.oJj)) * 100.0f));
                a.this.qIf.remove(ale.field_downloadUrl);
                a.this.qIg.remove(ale.field_downloadUrl);
            }
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
            try {
                tMAssistantDownloadTaskInfo = a.this.getClient().getDownloadTaskState(ale.field_downloadUrl);
            } catch (Exception e2) {
            }
            switch (i2) {
                case 1:
                    AppMethodBeat.o(89104);
                    return;
                case 2:
                    ale.field_status = 1;
                    if (tMAssistantDownloadTaskInfo != null) {
                        ale.field_filePath = tMAssistantDownloadTaskInfo.mSavePath;
                    }
                    d.e(ale);
                    AppMethodBeat.o(89104);
                    return;
                case 3:
                    ale.field_finishTime = System.currentTimeMillis();
                    ale.field_status = 2;
                    d.e(ale);
                    a.this.cancelNotification(str);
                    a.this.qJN.remove(Long.valueOf(ale.field_downloadId));
                    a.this.qIy.Cu(ale.field_downloadId);
                    AppMethodBeat.o(89104);
                    return;
                case 4:
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
                    ale.field_status = 6;
                    ale.field_finishTime = System.currentTimeMillis();
                    ale.field_downloadedSize = ale.field_totalSize;
                    if (tMAssistantDownloadTaskInfo != null) {
                        ale.field_filePath = tMAssistantDownloadTaskInfo.mSavePath;
                    }
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(ale.field_downloadedSize), Long.valueOf(ale.field_startSize));
                    d.e(ale);
                    a.this.qIy.Cv(ale.field_downloadId);
                    if (z2) {
                        jc jcVar = new jc();
                        jcVar.dNK.appId = ale.field_appId;
                        jcVar.dNK.opType = 6;
                        EventCenter.instance.publish(jcVar);
                    }
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.qJa, 1);
                    intent.setClass(a.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, ale.field_downloadId);
                    intent.putExtra(FileDownloadService.qJd, z);
                    try {
                        c.startService(intent);
                    } catch (Exception e3) {
                        Log.e("MicroMsg.FileDownloaderImplTMAssistant", e3.getMessage());
                    }
                    a.this.cancelNotification(str);
                    a.this.qJN.remove(Long.valueOf(ale.field_downloadId));
                    AppMethodBeat.o(89104);
                    return;
                case 5:
                    if (i3 == 601 || i3 == 602 || i3 == 603 || i3 == 605 || i3 == 606) {
                        Log.d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
                        a.this.qJP.startTimer(240000);
                    }
                    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) && ale.field_downloadInWifi) {
                        ale.field_downloadInWifi = false;
                        ale.field_reserveInWifi = false;
                    }
                    a.a(a.this, str, i2, 0, false);
                    a.this.qJN.remove(Long.valueOf(ale.field_downloadId));
                    ale.field_finishTime = System.currentTimeMillis();
                    ale.field_errCode = i3;
                    ale.field_status = 4;
                    d.e(ale);
                    a.this.qIy.c(ale.field_downloadId, i3, z);
                    break;
            }
            AppMethodBeat.o(89104);
        }

        @Override // com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener
        public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j2, long j3) {
            AppMethodBeat.i(89105);
            com.tencent.mm.plugin.downloader.g.a ale = d.ale(str);
            if (ale == null) {
                Log.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                AppMethodBeat.o(89105);
                return;
            }
            Long valueOf = Long.valueOf(Util.nullAsNil(a.this.qIf.get(ale.field_downloadUrl)));
            if (valueOf.longValue() == 0) {
                valueOf = Long.valueOf(j2);
                a.this.qIf.put(ale.field_downloadUrl, Long.valueOf(j2));
            }
            long longValue = j2 - valueOf.longValue();
            if (j3 == 0) {
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "onDownloadTaskProgressChanged, totalDataLen = 0");
            } else {
                int i2 = (int) ((((float) j2) / ((float) j3)) * 100.0f);
                if ((100 * longValue) / j3 >= 1) {
                    long nullAs = Util.nullAs(a.this.qIg.get(ale.field_downloadUrl), ale.field_startTime);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = currentTimeMillis - nullAs;
                    float f2 = ((((float) longValue) * 1000.0f) / ((float) j4)) / 1048576.0f;
                    Log.d("MicroMsg.FileDownloaderImplTMAssistant", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d", ale.field_appId, Float.valueOf(f2), Long.valueOf(j4), Long.valueOf(longValue), Long.valueOf(j3));
                    b.a(ale.field_downloadId, f2, i2);
                    a.this.qIg.put(ale.field_downloadUrl, Long.valueOf(currentTimeMillis));
                    a.this.qIf.put(ale.field_downloadUrl, Long.valueOf(j2));
                }
            }
            Long l = a.this.qJL.get(str);
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (l != null) {
                long longValue2 = valueOf2.longValue() - l.longValue();
                if (longValue2 > 0 && longValue2 < 500) {
                    AppMethodBeat.o(89105);
                    return;
                }
            }
            a.this.qJL.put(str, valueOf2);
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
            a.a(a.this, str, 2, (int) ((100 * j2) / j3), false);
            long j5 = ale.field_downloadId;
            com.tencent.mm.plugin.downloader.g.b aSU = d.aSU();
            if (aSU != null) {
                aSU.execSQL("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + j2 + ",totalSize= " + j3 + " where downloadId = " + j5);
            }
            a.this.qIy.b(ale.field_downloadId, str, j2, j3);
            AppMethodBeat.o(89105);
        }
    };

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(89123);
        aVar.cancelNotification(str);
        AppMethodBeat.o(89123);
    }

    public a(com.tencent.mm.plugin.downloader.model.c cVar) {
        super(cVar);
        AppMethodBeat.i(89108);
        HashMap hashMap = new HashMap();
        String property = System.getProperty("http.agent");
        Log.i("MicroMsg.FileDownloaderImplTMAssistant", property);
        String str = (Util.isNullOrNil(property) ? "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)" : property) + " MicroMessenger";
        PackageInfo packageInfo = getPackageInfo(this.mContext, MMApplicationContext.getPackageName());
        String str2 = (packageInfo != null ? ((str + FilePathGenerator.ANDROID_DIR_SEP) + packageInfo.versionName) + packageInfo.versionCode : str) + " NetType/" + NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", str2);
        hashMap.put("User-Agent", str2);
        this.qJO = hashMap;
        AppMethodBeat.o(89108);
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(final com.tencent.mm.plugin.downloader.g.a aVar) {
        AppMethodBeat.i(89109);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.h.a.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public final void run() {
                int i2;
                AppMethodBeat.i(89098);
                try {
                    com.tencent.mm.plugin.downloader.a.c.h(aVar.field_appId, aVar.field_downloadUrl, aVar.field_secondaryUrl);
                    com.tencent.mm.plugin.r.a.eAU();
                    n.bdK(aVar.field_appId);
                    i2 = a.this.getClient().startDownloadTask(aVar.field_downloadUrl, aVar.field_secondaryUrl, aVar.field_fileSize, 0, "resource/tm.android.unknown", MD5Util.getMD5String(aVar.field_downloadUrl), aVar.field_autoDownload, a.this.qJO);
                    switch (i2) {
                        case 0:
                            try {
                                TMAssistantDownloadTaskInfo downloadTaskState = a.this.getClient().getDownloadTaskState(aVar.field_downloadUrl);
                                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s, fileLen: %d, receiveLen: %d", aVar.field_downloadUrl, downloadTaskState.mSavePath, Long.valueOf(s.boW(downloadTaskState.mSavePath)), Long.valueOf(downloadTaskState.mReceiveDataLen));
                                aVar.field_status = 1;
                                aVar.field_startTime = System.currentTimeMillis();
                                aVar.field_startSize = downloadTaskState.mReceiveDataLen;
                                aVar.field_filePath = downloadTaskState.mSavePath;
                                aVar.field_downloadedSize = downloadTaskState.mReceiveDataLen;
                                aVar.field_totalSize = downloadTaskState.mTotalDataLen;
                                d.e(aVar);
                                a.this.qJN.add(Long.valueOf(aVar.field_downloadId));
                                a.a(a.this, aVar.field_downloadUrl, downloadTaskState.mState, 0, true);
                                a.this.qIy.m(aVar.field_downloadId, downloadTaskState.mSavePath);
                                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(aVar.field_downloadId), aVar.field_downloadUrl, aVar.field_filePath);
                                AppMethodBeat.o(89098);
                                return;
                            } catch (Exception e2) {
                                e = e2;
                                break;
                            }
                        case 1:
                            aVar.field_status = 4;
                            aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFt;
                            d.e(aVar);
                            a.this.qIy.c(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFt, false);
                            AppMethodBeat.o(89098);
                            return;
                        case 2:
                            aVar.field_status = 4;
                            aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFl;
                            d.e(aVar);
                            a.this.qIy.c(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFl, false);
                            AppMethodBeat.o(89098);
                            return;
                        case 3:
                            aVar.field_status = 4;
                            aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
                            d.e(aVar);
                            d.e(aVar);
                            a.this.qIy.c(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
                            AppMethodBeat.o(89098);
                            return;
                        case 4:
                            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                            TMAssistantDownloadTaskInfo downloadTaskState2 = a.this.getClient().getDownloadTaskState(aVar.field_downloadUrl);
                            com.tencent.mm.plugin.downloader.g.a aVar = aVar;
                            com.tencent.mm.plugin.downloader.g.a aVar2 = aVar;
                            long currentTimeMillis = System.currentTimeMillis();
                            aVar2.field_finishTime = currentTimeMillis;
                            aVar.field_startTime = currentTimeMillis;
                            aVar.field_status = 6;
                            aVar.field_filePath = downloadTaskState2.mSavePath;
                            aVar.field_startSize = downloadTaskState2.mReceiveDataLen;
                            aVar.field_downloadedSize = downloadTaskState2.mReceiveDataLen;
                            aVar.field_totalSize = downloadTaskState2.mTotalDataLen;
                            d.e(aVar);
                            a.this.qIy.Cv(aVar.field_downloadId);
                            Intent intent = new Intent();
                            intent.putExtra(FileDownloadService.qJa, 1);
                            intent.setClass(a.this.mContext, FileDownloadService.class);
                            intent.putExtra(FileDownloadService.EXTRA_ID, aVar.field_downloadId);
                            try {
                                c.startService(intent);
                            } catch (Exception e3) {
                                Log.e("MicroMsg.FileDownloaderImplTMAssistant", e3.getMessage());
                            }
                            a.this.qJN.remove(Long.valueOf(aVar.field_downloadId));
                            AppMethodBeat.o(89098);
                            return;
                        case 5:
                            aVar.field_startTime = System.currentTimeMillis();
                            aVar.field_status = 1;
                            d.e(aVar);
                            a.this.qJN.add(Long.valueOf(aVar.field_downloadId));
                            a.a(a.this, aVar.field_downloadUrl, 2, 0, true);
                            break;
                    }
                    AppMethodBeat.o(89098);
                } catch (Exception e4) {
                    e = e4;
                    i2 = -1;
                    Log.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", e.getMessage());
                    aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFj;
                    aVar.field_status = 4;
                    d.e(aVar);
                    Log.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", Integer.valueOf(i2), aVar.field_downloadUrl);
                    a.this.qIy.c(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFj, false);
                    AppMethodBeat.o(89098);
                }
            }
        }, "MicroMsg.FileDownloaderImplTMAssistant");
        long j2 = aVar.field_downloadId;
        AppMethodBeat.o(89109);
        return j2;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(g gVar) {
        AppMethodBeat.i(89110);
        if (gVar == null || Util.isNullOrNil(gVar.kMX)) {
            Log.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
            AppMethodBeat.o(89110);
            return -1;
        }
        String str = gVar.kMX;
        String str2 = gVar.mAppId;
        com.tencent.mm.plugin.downloader.g.a ale = d.ale(str);
        if (ale != null) {
            FileDownloadTaskInfo Co = Co(ale.field_downloadId);
            if (Co.status == 1) {
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, running, return");
                long j2 = Co.id;
                AppMethodBeat.o(89110);
                return j2;
            } else if (Co.status == 6) {
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, md5 checking, return");
                long j3 = Co.id;
                AppMethodBeat.o(89110);
                return j3;
            } else if (Co.status == 3) {
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, has download finished, install");
                if (gVar.qIH) {
                    com.tencent.mm.plugin.downloader.i.a.a(Co.id, false, null);
                }
                long j4 = Co.id;
                AppMethodBeat.o(89110);
                return j4;
            }
        }
        if (ale == null) {
            ale = d.alb(str2);
        }
        cBN();
        d.alc(str);
        d.ald(str2);
        d.ald(gVar.qIU);
        com.tencent.mm.plugin.downloader.g.a c2 = com.tencent.mm.plugin.downloader.model.h.c(gVar);
        if (!gVar.qIL || ale == null) {
            c2.field_downloadId = System.currentTimeMillis();
        } else {
            c2.field_downloadId = ale.field_downloadId;
        }
        c2.field_status = 0;
        c2.field_downloaderType = 2;
        if (ale == null) {
            c2.field_startState = 0;
        } else if (ale.field_status == 2) {
            c2.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
        } else if (ale.field_status == 4) {
            c2.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
        } else {
            c2.field_startState = com.tencent.mm.plugin.downloader.a.b.qFy;
        }
        if (gVar.qII) {
            c2.field_md5 = com.tencent.mm.plugin.downloader.model.h.alp(c2.field_downloadUrl);
        }
        if (!gVar.lBG || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                c2.field_downloadInWifi = true;
            }
            d.d(c2);
            long a2 = a(c2);
            AppMethodBeat.o(89110);
            return a2;
        }
        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "downloadInWifi, not wifi");
        c2.field_status = 0;
        c2.field_downloadInWifi = true;
        d.d(c2);
        long j5 = c2.field_downloadId;
        AppMethodBeat.o(89110);
        return j5;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final int Cn(final long j2) {
        AppMethodBeat.i(89111);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.h.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(89099);
                com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
                if (Cw == null) {
                    AppMethodBeat.o(89099);
                    return;
                }
                try {
                    a.this.getClient().cancelDownloadTask(Cw.field_downloadUrl);
                    s.deleteFile(Cw.field_filePath);
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask, delete file, path: %s", Cw.field_filePath);
                    a.this.qJN.remove(Long.valueOf(Cw.field_downloadId));
                    a.a(a.this, Cw.field_downloadUrl);
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: status = " + Cw.field_status);
                    if (Cw.field_status == 5) {
                        AppMethodBeat.o(89099);
                        return;
                    }
                    Cw.field_status = 5;
                    Cw.field_finishTime = System.currentTimeMillis();
                    d.e(Cw);
                    long nullAs = Util.nullAs(a.this.qIg.get(Cw.field_downloadUrl), Cw.field_startTime);
                    float nullAs2 = ((((float) (Cw.field_downloadedSize - Util.nullAs(a.this.qIf.get(Cw.field_downloadUrl), Cw.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - nullAs))) / 1048576.0f;
                    b.a(Cw.field_downloadId, nullAs2, (int) ((((float) Cw.field_downloadedSize) / ((float) Cw.field_totalSize)) * 100.0f));
                    a.this.qIy.Ct(Cw.field_downloadId);
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", Long.valueOf(j2), Cw.field_filePath);
                    AppMethodBeat.o(89099);
                } catch (Exception e2) {
                    Log.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + e2.toString());
                    AppMethodBeat.o(89099);
                }
            }
        }, "MicroMsg.FileDownloaderImplTMAssistant");
        AppMethodBeat.o(89111);
        return 1;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final FileDownloadTaskInfo Co(long j2) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        AppMethodBeat.i(89112);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j2;
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null || Util.isNullOrNil(Cw.field_downloadUrl)) {
            AppMethodBeat.o(89112);
            return fileDownloadTaskInfo;
        }
        fileDownloadTaskInfo.url = Cw.field_downloadUrl;
        fileDownloadTaskInfo.status = Cw.field_status;
        fileDownloadTaskInfo.path = Cw.field_filePath;
        if (!s.YS(Cw.field_filePath)) {
            fileDownloadTaskInfo.qJe = 0;
            fileDownloadTaskInfo.oJj = 0;
        } else {
            fileDownloadTaskInfo.qJe = Cw.field_downloadedSize;
            fileDownloadTaskInfo.oJj = Cw.field_totalSize;
        }
        fileDownloadTaskInfo.md5 = Cw.field_md5;
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            final String str = fileDownloadTaskInfo.url;
            tMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo) new SyncTask<TMAssistantDownloadTaskInfo>() {
                /* class com.tencent.mm.plugin.downloader.h.a.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final /* synthetic */ TMAssistantDownloadTaskInfo run() {
                    AppMethodBeat.i(89101);
                    TMAssistantDownloadTaskInfo cBO = cBO();
                    AppMethodBeat.o(89101);
                    return cBO;
                }

                private TMAssistantDownloadTaskInfo cBO() {
                    AppMethodBeat.i(89100);
                    TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
                    try {
                        tMAssistantDownloadTaskInfo = a.this.getClient().getDownloadTaskState(str);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadStateSync faile: " + e2.toString());
                    }
                    AppMethodBeat.o(89100);
                    return tMAssistantDownloadTaskInfo;
                }
            }.exec(com.tencent.mm.kernel.g.aAk().getWorkerHandler());
        } else {
            try {
                tMAssistantDownloadTaskInfo = getClient().getDownloadTaskState(fileDownloadTaskInfo.url);
            } catch (Exception e2) {
                Log.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + e2.toString());
                tMAssistantDownloadTaskInfo = null;
            }
        }
        if (tMAssistantDownloadTaskInfo != null) {
            switch (tMAssistantDownloadTaskInfo.mState) {
                case 1:
                case 2:
                    fileDownloadTaskInfo.status = 1;
                    break;
                case 3:
                    fileDownloadTaskInfo.status = 2;
                    break;
                case 4:
                    if (fileDownloadTaskInfo.status != 6) {
                        fileDownloadTaskInfo.status = 3;
                        break;
                    } else {
                        fileDownloadTaskInfo.status = 6;
                        break;
                    }
                default:
                    if (fileDownloadTaskInfo.status == 1) {
                        fileDownloadTaskInfo.status = 0;
                        break;
                    }
                    break;
            }
            fileDownloadTaskInfo.path = tMAssistantDownloadTaskInfo.mSavePath;
            fileDownloadTaskInfo.qJe = tMAssistantDownloadTaskInfo.mReceiveDataLen;
            fileDownloadTaskInfo.oJj = tMAssistantDownloadTaskInfo.mTotalDataLen;
        } else if (fileDownloadTaskInfo.status == 1) {
            fileDownloadTaskInfo.status = 0;
        }
        if ((fileDownloadTaskInfo.status == 6 || fileDownloadTaskInfo.status == 3) && !s.YS(fileDownloadTaskInfo.path)) {
            fileDownloadTaskInfo.status = 0;
        }
        if (fileDownloadTaskInfo.status == 6 && !e.CA(fileDownloadTaskInfo.id)) {
            fileDownloadTaskInfo.status = 3;
        }
        if (Util.isNullOrNil(Cw.field_filePath)) {
            Cw.field_filePath = fileDownloadTaskInfo.path;
            d.e(Cw);
        }
        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: appId: %s, status: %d, url: %s, path: %s", Cw.field_appId, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
        AppMethodBeat.o(89112);
        return fileDownloadTaskInfo;
    }

    /* access modifiers changed from: package-private */
    public final boolean cBM() {
        AppMethodBeat.i(89113);
        if (this.qJN == null || this.qJN.size() == 0) {
            TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
            if (this.mClient != null) {
                this.mClient.unRegisterDownloadTaskListener(this.qJQ);
            }
            this.mClient = null;
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
            try {
                this.mContext.stopService(new Intent(this.mContext, TMAssistantDownloadSDKService.class));
            } catch (Exception e2) {
                Log.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + e2.toString());
            }
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
            AppMethodBeat.o(89113);
            return true;
        }
        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
        AppMethodBeat.o(89113);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final TMAssistantDownloadSDKClient getClient() {
        AppMethodBeat.i(89114);
        if (this.mClient == null) {
            this.mClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient("WechatDownloadClient");
            this.mClient.registerDownloadTaskListener(this.qJQ);
        }
        this.qJP.startTimer(240000);
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient = this.mClient;
        AppMethodBeat.o(89114);
        return tMAssistantDownloadSDKClient;
    }

    /* access modifiers changed from: package-private */
    public final void cancelNotification(String str) {
        AppMethodBeat.i(89115);
        synchronized (this.lock) {
            try {
                Integer num = this.qJM.get(str);
                if (num == null) {
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
                    return;
                }
                ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = ".concat(String.valueOf(num)));
                this.qJM.remove(str);
                AppMethodBeat.o(89115);
            } finally {
                AppMethodBeat.o(89115);
            }
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(89116);
        if (str == null) {
            Log.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
            AppMethodBeat.o(89116);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.o(89116);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e2, "", new Object[0]);
                AppMethodBeat.o(89116);
            }
        }
        return packageInfo;
    }

    private static void cBN() {
        AppMethodBeat.i(89117);
        o oVar = new o(TMAssistantFile.getSavePathRootDir() + "/.tmp/");
        if (!oVar.exists()) {
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", Boolean.valueOf(oVar.mkdirs()));
        }
        AppMethodBeat.o(89117);
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cp(final long j2) {
        AppMethodBeat.i(89118);
        final com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null || Util.isNullOrNil(Cw.field_downloadUrl)) {
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", Long.valueOf(j2));
            AppMethodBeat.o(89118);
            return false;
        } else if (Cw.field_downloaderType != 2) {
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", Long.valueOf(j2));
            s.deleteFile(Cw.field_filePath);
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask, delete file: %s", Cw.field_filePath);
            d.Cx(j2);
            AppMethodBeat.o(89118);
            return false;
        } else {
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.h.a.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(89106);
                    try {
                        TMAssistantDownloadTaskInfo downloadTaskState = a.this.getClient().getDownloadTaskState(Cw.field_downloadUrl);
                        if (downloadTaskState.mState == 1 || downloadTaskState.mState == 2) {
                            a.this.getClient().pauseDownloadTask(Cw.field_downloadUrl);
                            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", Long.valueOf(j2));
                            AppMethodBeat.o(89106);
                            return;
                        }
                        AppMethodBeat.o(89106);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", e2.toString());
                        Log.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e2, "", new Object[0]);
                        AppMethodBeat.o(89106);
                    }
                }
            }, "MicroMsg.FileDownloaderImplTMAssistant");
            AppMethodBeat.o(89118);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cq(long j2) {
        AppMethodBeat.i(261892);
        boolean n = n(j2, true);
        AppMethodBeat.o(261892);
        return n;
    }

    public final boolean Cr(long j2) {
        AppMethodBeat.i(89120);
        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(j2)));
        boolean n = n(j2, false);
        AppMethodBeat.o(89120);
        return n;
    }

    public final boolean n(final long j2, final boolean z) {
        AppMethodBeat.i(89121);
        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: id = ".concat(String.valueOf(j2)));
        final com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null || Util.isNullOrNil(Cw.field_downloadUrl)) {
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", Long.valueOf(j2));
            AppMethodBeat.o(89121);
            return false;
        } else if (Cw.field_downloaderType != 2) {
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", Long.valueOf(j2));
            s.deleteFile(Cw.field_filePath);
            Log.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, delete file: " + Cw.field_filePath);
            d.Cx(j2);
            AppMethodBeat.o(89121);
            return false;
        } else {
            FileDownloadTaskInfo Co = Co(Cw.field_downloadId);
            if (Co.status == 1) {
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "download runing, return");
                AppMethodBeat.o(89121);
                return true;
            } else if (Co.status == 6) {
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "md5 checking ,return");
                AppMethodBeat.o(89121);
                return true;
            } else if (Co.status == 3) {
                Log.i("MicroMsg.FileDownloaderImplTMAssistant", "has download finished, install");
                if (Cw.field_autoInstall) {
                    com.tencent.mm.plugin.downloader.i.a.a(Co.id, false, null);
                }
                AppMethodBeat.o(89121);
                return true;
            } else {
                if (Cw.field_status == 2) {
                    Cw.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
                } else if (Cw.field_status == 4) {
                    Cw.field_startState = com.tencent.mm.plugin.downloader.a.b.qFA;
                } else {
                    Cw.field_startState = com.tencent.mm.plugin.downloader.a.b.qFy;
                }
                Cw.field_startSize = Cw.field_downloadedSize;
                Cw.field_errCode = 0;
                cBN();
                if ((Cw.field_reserveInWifi || Cw.field_downloadInWifi) && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask downloadInWifi, not wifi");
                    AppMethodBeat.o(89121);
                    return true;
                }
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                    Cw.field_downloadInWifi = true;
                }
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader.h.a.AnonymousClass7 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    public final void run() {
                        AppMethodBeat.i(89107);
                        try {
                            com.tencent.mm.plugin.downloader.a.c.h(Cw.field_appId, Cw.field_downloadUrl, Cw.field_secondaryUrl);
                            com.tencent.mm.plugin.r.a.eAU();
                            n.bdK(Cw.field_appId);
                            TMAssistantDownloadTaskInfo downloadTaskState = a.this.getClient().getDownloadTaskState(Cw.field_downloadUrl);
                            if (downloadTaskState == null || !(downloadTaskState.mState == 1 || downloadTaskState.mState == 2)) {
                                int startDownloadTask = a.this.getClient().startDownloadTask(Cw.field_downloadUrl, Cw.field_secondaryUrl, Cw.field_fileSize, 0, "resource/tm.android.unknown", MD5Util.getMD5String(Cw.field_downloadUrl), Cw.field_autoDownload, a.this.qJO);
                                TMAssistantDownloadTaskInfo downloadTaskState2 = a.this.getClient().getDownloadTaskState(Cw.field_downloadUrl);
                                switch (startDownloadTask) {
                                    case 0:
                                        Cw.field_status = 1;
                                        Cw.field_startTime = System.currentTimeMillis();
                                        Cw.field_filePath = downloadTaskState2.mSavePath;
                                        Cw.field_totalSize = downloadTaskState2.mTotalDataLen;
                                        Cw.field_status = 1;
                                        d.e(Cw);
                                        a.this.qJN.add(Long.valueOf(Cw.field_downloadId));
                                        a.a(a.this, Cw.field_downloadUrl, 2, 0, true);
                                        if (z) {
                                            a.this.qIy.n(Cw.field_downloadId, Cw.field_filePath);
                                        }
                                        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", Long.valueOf(j2));
                                        AppMethodBeat.o(89107);
                                        return;
                                    case 1:
                                        Cw.field_status = 4;
                                        Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFt;
                                        d.e(Cw);
                                        a.this.qIy.c(Cw.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFt, false);
                                        AppMethodBeat.o(89107);
                                        return;
                                    case 2:
                                        Cw.field_status = 4;
                                        Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFl;
                                        d.e(Cw);
                                        a.this.qIy.c(Cw.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFl, false);
                                        AppMethodBeat.o(89107);
                                        return;
                                    case 3:
                                        Cw.field_status = 4;
                                        Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
                                        d.e(Cw);
                                        a.this.qIy.c(Cw.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
                                        AppMethodBeat.o(89107);
                                        return;
                                    case 4:
                                        Log.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                                        com.tencent.mm.plugin.downloader.g.a aVar = Cw;
                                        com.tencent.mm.plugin.downloader.g.a aVar2 = Cw;
                                        long currentTimeMillis = System.currentTimeMillis();
                                        aVar2.field_finishTime = currentTimeMillis;
                                        aVar.field_startTime = currentTimeMillis;
                                        Cw.field_status = 6;
                                        Cw.field_filePath = downloadTaskState2.mSavePath;
                                        Cw.field_startSize = downloadTaskState2.mReceiveDataLen;
                                        Cw.field_downloadedSize = downloadTaskState2.mReceiveDataLen;
                                        Cw.field_totalSize = downloadTaskState2.mTotalDataLen;
                                        d.e(Cw);
                                        a.this.qIy.Cv(Cw.field_downloadId);
                                        Intent intent = new Intent();
                                        intent.putExtra(FileDownloadService.qJa, 1);
                                        intent.setClass(a.this.mContext, FileDownloadService.class);
                                        intent.putExtra(FileDownloadService.EXTRA_ID, Cw.field_downloadId);
                                        try {
                                            c.startService(intent);
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.FileDownloaderImplTMAssistant", e2.getMessage());
                                        }
                                        a.this.qJN.remove(Long.valueOf(Cw.field_downloadId));
                                        AppMethodBeat.o(89107);
                                        return;
                                    case 5:
                                        Cw.field_startTime = System.currentTimeMillis();
                                        Cw.field_status = 1;
                                        d.e(Cw);
                                        a.this.qJN.add(Long.valueOf(Cw.field_downloadId));
                                        a.a(a.this, Cw.field_downloadUrl, 2, 0, true);
                                        break;
                                }
                                AppMethodBeat.o(89107);
                                return;
                            }
                            Log.w("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, is running");
                            AppMethodBeat.o(89107);
                        } catch (Exception e3) {
                            Log.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", e3.toString());
                            Log.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e3, "", new Object[0]);
                            Cw.field_status = 4;
                            Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFk;
                            d.e(Cw);
                            a.this.qIy.c(Cw.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFk, false);
                            AppMethodBeat.o(89107);
                        }
                    }
                }, "MicroMsg.FileDownloaderImplTMAssistant");
                AppMethodBeat.o(89121);
                return true;
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(89122);
        com.tencent.mm.plugin.downloader.g.a ale = d.ale(str);
        if (ale == null) {
            Log.e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification failed: null task info");
            AppMethodBeat.o(89122);
        } else if (ale.field_showNotification) {
            s.c cd = com.tencent.mm.bq.a.cd(aVar.mContext, "reminder_channel_id");
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.qJK.put(str, Long.valueOf(currentTimeMillis));
                cd.i(currentTimeMillis);
            } else {
                Long l = aVar.qJK.get(str);
                if (l != null) {
                    cd.i(l.longValue());
                } else {
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    aVar.qJK.put(str, valueOf);
                    cd.i(valueOf.longValue());
                }
            }
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(ale.field_appId, false, false);
            if (!TextUtils.isEmpty(ale.field_fileName)) {
                if (i3 == 0) {
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification, FileDownloadInfo.appName=" + ale.field_fileName + ", appId=" + ale.field_appId);
                }
                cd.f(ale.field_fileName);
            } else if (o == null || Util.isNullOrNil(o.field_appName)) {
                Log.e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification, appName is empty");
            } else {
                if (i3 == 0) {
                    Log.i("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification, AppInfo.appName=" + o.field_appName + ", appId=" + ale.field_appId);
                }
                cd.f(o.field_appName);
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    cd.as(17301633);
                    if (i3 == 0) {
                        i3 = 1;
                    }
                    cd.b(100, i3, i3 == 0);
                    cd.g(aVar.mContext.getString(R.string.cdo));
                    if (ale.field_reserveInWifi) {
                        cd.h(aVar.mContext.getString(R.string.cdq));
                    }
                    cd.g(2, true);
                    long j2 = ale.field_downloadId;
                    Intent intent = new Intent(aVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j2);
                    cd.Hv = PendingIntent.getActivity(aVar.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                case 6:
                    aVar.cancelNotification(str);
                    AppMethodBeat.o(89122);
                    return;
                case 5:
                    cd.as(17301634);
                    cd.E(true);
                    cd.Hv = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, new Intent(), 0);
                    cd.g(aVar.mContext.getString(R.string.cdl));
                    break;
            }
            synchronized (aVar.lock) {
                try {
                    Integer num = aVar.qJM.get(str);
                    if (num == null) {
                        aVar.qJM.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(cd.build())));
                    } else {
                        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), cd.build());
                    }
                    if (i2 == 4) {
                        aVar.qJM.remove(str);
                    }
                } finally {
                    AppMethodBeat.o(89122);
                }
            }
        } else {
            AppMethodBeat.o(89122);
        }
    }
}
