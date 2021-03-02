package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* access modifiers changed from: package-private */
public final class i extends j {
    MTimerHandler cve = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.downloader.model.i.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean z;
            AppMethodBeat.i(89021);
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.model.i.AnonymousClass3 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                public final void run() {
                    AppMethodBeat.i(89022);
                    try {
                        Iterator<Long> it = i.this.qJj.iterator();
                        while (it.hasNext()) {
                            long longValue = it.next().longValue();
                            i iVar = i.this;
                            Long valueOf = Long.valueOf(longValue);
                            Log.d("MicroMsg.FileDownloaderImpl23", "updateDownloadStatus");
                            a Cw = d.Cw(valueOf.longValue());
                            if (Cw != null) {
                                DownloadManager.Query query = new DownloadManager.Query();
                                query.setFilterById(Cw.field_sysDownloadId);
                                try {
                                    Cursor query2 = iVar.qJi.query(query);
                                    if (query2 == null) {
                                        Log.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
                                        iVar.qJj.remove(valueOf);
                                        Cw.field_status = 4;
                                        d.e(Cw);
                                    } else {
                                        if (query2.moveToFirst()) {
                                            int columnIndex = query2.getColumnIndex("status");
                                            int columnIndex2 = query2.getColumnIndex("local_uri");
                                            int columnIndex3 = query2.getColumnIndex("bytes_so_far");
                                            int columnIndex4 = query2.getColumnIndex("total_size");
                                            if (columnIndex != -1) {
                                                try {
                                                    int i2 = query2.getInt(columnIndex);
                                                    Log.d("MicroMsg.FileDownloaderImpl23", "status = %d", Integer.valueOf(i2));
                                                    switch (i2) {
                                                        case 1:
                                                        case 2:
                                                            if (columnIndex3 != -1) {
                                                                Cw.field_downloadedSize = query2.getLong(columnIndex3);
                                                            }
                                                            if (columnIndex4 != -1) {
                                                                Cw.field_totalSize = query2.getLong(columnIndex4);
                                                            }
                                                            Cw.field_status = 1;
                                                            d.e(Cw);
                                                            iVar.qIy.b(valueOf.longValue(), "", 0, 0);
                                                            break;
                                                        case 4:
                                                            iVar.qJj.remove(valueOf);
                                                            Cw.field_status = 2;
                                                            d.e(Cw);
                                                            iVar.qIy.Cu(valueOf.longValue());
                                                            break;
                                                        case 8:
                                                            iVar.qJj.remove(valueOf);
                                                            if (columnIndex2 != -1) {
                                                                if (!Util.isNullOrNil(Cw.field_filePath) && s.YS(Cw.field_filePath)) {
                                                                    Intent intent = new Intent();
                                                                    intent.setClass(MMApplicationContext.getContext(), FileDownloadService.class);
                                                                    intent.putExtra(FileDownloadService.EXTRA_ID, Cw.field_downloadId);
                                                                    intent.putExtra(FileDownloadService.qJa, 1);
                                                                    c.startService(intent);
                                                                    break;
                                                                } else {
                                                                    Log.e("MicroMsg.FileDownloaderImpl23", "path not exists, path = %s", Cw.field_filePath);
                                                                    Cw.field_status = 4;
                                                                    d.e(Cw);
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case 16:
                                                            iVar.qJj.remove(valueOf);
                                                            int i3 = com.tencent.mm.plugin.downloader.a.a.qFx;
                                                            Cw.field_status = 4;
                                                            d.e(Cw);
                                                            iVar.qIy.c(valueOf.longValue(), i3, false);
                                                            break;
                                                    }
                                                } catch (Exception e2) {
                                                    iVar.qJj.remove(valueOf);
                                                    Cw.field_status = 4;
                                                    d.e(Cw);
                                                    Log.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e2.toString());
                                                }
                                            }
                                        }
                                        query2.close();
                                    }
                                } catch (Exception e3) {
                                    Log.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e3.toString(), valueOf);
                                    iVar.qJj.remove(valueOf);
                                    Cw.field_status = 4;
                                    d.e(Cw);
                                }
                            }
                        }
                        AppMethodBeat.o(89022);
                    } catch (Exception e4) {
                        Log.e("MicroMsg.FileDownloaderImpl23", e4.getMessage());
                        AppMethodBeat.o(89022);
                    }
                }
            });
            i iVar = i.this;
            if (iVar.qJj == null || iVar.qJj.size() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i.this.cve.startTimer(1000);
                AppMethodBeat.o(89021);
            } else {
                Log.d("MicroMsg.FileDownloaderImpl23", "timer stop");
                AppMethodBeat.o(89021);
            }
            return false;
        }
    }, false);
    private Context mContext = MMApplicationContext.getContext();
    DownloadManager qJi = ((DownloadManager) this.mContext.getSystemService("download"));
    CopyOnWriteArraySet<Long> qJj = new CopyOnWriteArraySet<>();

    public i(c cVar) {
        super(cVar);
        AppMethodBeat.i(89023);
        AppMethodBeat.o(89023);
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(a aVar) {
        return aVar.field_downloadId;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(final g gVar) {
        AppMethodBeat.i(89024);
        if (gVar == null || Util.isNullOrNil(gVar.kMX)) {
            Log.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            AppMethodBeat.o(89024);
            return -1;
        } else if (gVar.qIJ) {
            Log.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", gVar.mAppId);
            AppMethodBeat.o(89024);
            return -1;
        } else {
            String str = gVar.kMX;
            String str2 = "";
            a ale = d.ale(str);
            if (ale != null) {
                FileDownloadTaskInfo CG = CG(ale.field_sysDownloadId);
                if (CG.status == 1) {
                    long j2 = CG.id;
                    AppMethodBeat.o(89024);
                    return j2;
                }
                str2 = ale.field_filePath;
                this.qJi.remove(ale.field_sysDownloadId);
            }
            String absolutePath = com.tencent.mm.compatible.util.g.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!Util.isNullOrNil(absolutePath)) {
                o oVar = new o(absolutePath);
                if (!oVar.exists()) {
                    Log.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", Boolean.valueOf(oVar.mkdirs()));
                }
            }
            if (!Util.isNullOrNil(str2)) {
                o oVar2 = new o(str2);
                if (oVar2.exists()) {
                    Log.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", Boolean.valueOf(oVar2.delete()));
                }
            }
            d.alc(str);
            d.ald(gVar.mAppId);
            final a c2 = h.c(gVar);
            c2.field_downloadId = System.currentTimeMillis();
            c2.field_status = 0;
            c2.field_downloaderType = 1;
            c2.field_filePath = com.tencent.mm.compatible.util.g.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP + MD5Util.getMD5String(str);
            c2.field_startTime = System.currentTimeMillis();
            d.d(c2);
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.model.i.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(89020);
                    if (gVar.qII) {
                        c2.field_md5 = h.alp(c2.field_downloadUrl);
                    }
                    long j2 = i.this.j(c2);
                    if (j2 > 0) {
                        c2.field_sysDownloadId = j2;
                        c2.field_status = 1;
                        d.e(c2);
                        i.this.qIy.m(c2.field_downloadId, c2.field_filePath);
                        f.cBv();
                        if (f.CB(c2.field_downloadId)) {
                            f.cBv();
                            f.N(c2.field_downloadId, j2);
                        }
                        i.this.qJj.add(Long.valueOf(c2.field_downloadId));
                        if (i.this.cve.stopped()) {
                            i.this.cve.startTimer(100);
                        }
                        Log.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(c2.field_downloadId), c2.field_downloadUrl, c2.field_filePath);
                        AppMethodBeat.o(89020);
                        return;
                    }
                    c2.field_status = 4;
                    d.e(c2);
                    i.this.qIy.c(c2.field_downloadId, com.tencent.mm.plugin.downloader.a.a.qFx, false);
                    Log.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
                    AppMethodBeat.o(89020);
                }
            });
            long j3 = c2.field_downloadId;
            AppMethodBeat.o(89024);
            return j3;
        }
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final int Cn(long j2) {
        Exception e2;
        int i2;
        AppMethodBeat.i(89025);
        f.cBv();
        if (f.CB(j2)) {
            f.cBv();
            int remove = this.qJi.remove(f.CC(j2));
            AppMethodBeat.o(89025);
            return remove;
        }
        a Cw = d.Cw(j2);
        if (Cw == null) {
            Log.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            AppMethodBeat.o(89025);
            return 0;
        }
        try {
            i2 = this.qJi.remove(Cw.field_sysDownloadId);
            try {
                Log.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", Long.valueOf(j2));
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j2), e2.toString());
                s.deleteFile(Cw.field_filePath);
                Log.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", Cw.field_filePath);
                Cw.field_status = 5;
                d.e(Cw);
                this.qIy.Ct(j2);
                this.qJj.remove(Long.valueOf(j2));
                AppMethodBeat.o(89025);
                return i2;
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            Log.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j2), e2.toString());
            s.deleteFile(Cw.field_filePath);
            Log.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", Cw.field_filePath);
            Cw.field_status = 5;
            d.e(Cw);
            this.qIy.Ct(j2);
            this.qJj.remove(Long.valueOf(j2));
            AppMethodBeat.o(89025);
            return i2;
        }
        s.deleteFile(Cw.field_filePath);
        Log.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", Cw.field_filePath);
        Cw.field_status = 5;
        d.e(Cw);
        this.qIy.Ct(j2);
        this.qJj.remove(Long.valueOf(j2));
        AppMethodBeat.o(89025);
        return i2;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final FileDownloadTaskInfo Co(long j2) {
        AppMethodBeat.i(89026);
        f.cBv();
        if (f.CB(j2)) {
            f.cBv();
            FileDownloadTaskInfo CG = CG(f.CC(j2));
            CG.id = j2;
            CG.dNv = 1;
            AppMethodBeat.o(89026);
            return CG;
        }
        a Cw = d.Cw(j2);
        if (Cw == null) {
            FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
            AppMethodBeat.o(89026);
            return fileDownloadTaskInfo;
        }
        if (Cw.field_status == 4 || Cw.field_status == 2 || Cw.field_status == 5 || Cw.field_status == 3) {
            this.qJj.remove(Long.valueOf(j2));
        }
        FileDownloadTaskInfo fileDownloadTaskInfo2 = new FileDownloadTaskInfo();
        fileDownloadTaskInfo2.id = Cw.field_downloadId;
        fileDownloadTaskInfo2.url = Cw.field_downloadUrl;
        fileDownloadTaskInfo2.status = Cw.field_status;
        fileDownloadTaskInfo2.path = Cw.field_filePath;
        fileDownloadTaskInfo2.md5 = Cw.field_md5;
        fileDownloadTaskInfo2.qJf = Cw.field_autoDownload;
        fileDownloadTaskInfo2.dNv = Cw.field_downloaderType;
        fileDownloadTaskInfo2.qJe = Cw.field_downloadedSize;
        fileDownloadTaskInfo2.oJj = Cw.field_totalSize;
        AppMethodBeat.o(89026);
        return fileDownloadTaskInfo2;
    }

    /* access modifiers changed from: package-private */
    public final long j(a aVar) {
        AppMethodBeat.i(89027);
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(aVar.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(aVar.field_showNotification);
            request.setVisibleInDownloadsUi(aVar.field_showNotification);
            if (!Util.isNullOrNil(aVar.field_fileName)) {
                request.setTitle(aVar.field_fileName);
            }
            request.setDestinationUri(FileProviderHelper.getUriForFile(this.mContext, new o(s.k(aVar.field_filePath, true))));
            long enqueue = this.qJi.enqueue(request);
            if (enqueue > 0) {
                AppMethodBeat.o(89027);
                return enqueue;
            }
            Log.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            AppMethodBeat.o(89027);
            return -1;
        } catch (Exception e2) {
            Log.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", e2.toString(), aVar.field_downloadUrl);
            AppMethodBeat.o(89027);
            return -1;
        }
    }

    private FileDownloadTaskInfo CG(long j2) {
        AppMethodBeat.i(89028);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(j2);
        try {
            Cursor query2 = this.qJi.query(query);
            if (query2 == null) {
                Log.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
                AppMethodBeat.o(89028);
            } else {
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex("status");
                    int columnIndex2 = query2.getColumnIndex(ShareConstants.MEDIA_URI);
                    int columnIndex3 = query2.getColumnIndex("local_uri");
                    int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex5 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    fileDownloadTaskInfo.status = 1;
                                    break;
                                case 4:
                                    fileDownloadTaskInfo.status = 2;
                                    break;
                                case 8:
                                    fileDownloadTaskInfo.status = 3;
                                    break;
                                case 16:
                                    fileDownloadTaskInfo.status = 4;
                                    break;
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e2.toString());
                            fileDownloadTaskInfo.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fileDownloadTaskInfo.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (!Util.isNullOrNil(string)) {
                            Log.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", string);
                            fileDownloadTaskInfo.path = Uri.parse(string).getPath();
                            Log.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", fileDownloadTaskInfo.path);
                        } else {
                            Log.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        }
                    }
                    if (columnIndex4 != -1) {
                        fileDownloadTaskInfo.qJe = query2.getLong(columnIndex4);
                    }
                    if (columnIndex5 != -1) {
                        fileDownloadTaskInfo.oJj = query2.getLong(columnIndex5);
                    }
                }
                query2.close();
                Log.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", Long.valueOf(j2), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
                AppMethodBeat.o(89028);
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e3.toString(), Long.valueOf(j2));
            AppMethodBeat.o(89028);
        }
        return fileDownloadTaskInfo;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cp(long j2) {
        AppMethodBeat.i(89029);
        FileDownloadTaskInfo Co = Co(j2);
        if (Co == null) {
            Log.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", Long.valueOf(j2));
            AppMethodBeat.o(89029);
            return false;
        }
        this.qJj.remove(Long.valueOf(j2));
        if (Co.status != 1) {
            Log.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", Long.valueOf(j2));
            AppMethodBeat.o(89029);
            return true;
        }
        int Cn = Cn(j2);
        Log.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", Long.valueOf(j2), Integer.valueOf(Cn));
        if (Cn > 0) {
            AppMethodBeat.o(89029);
            return true;
        }
        AppMethodBeat.o(89029);
        return false;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cq(long j2) {
        AppMethodBeat.i(89030);
        a Cw = d.Cw(j2);
        if (Cw == null) {
            Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", Long.valueOf(j2));
            AppMethodBeat.o(89030);
            return false;
        } else if (Cw.field_downloaderType != 1) {
            Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", Long.valueOf(j2));
            s.deleteFile(Cw.field_filePath);
            Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask, delete file: %s", Cw.field_filePath);
            d.Cx(j2);
            AppMethodBeat.o(89030);
            return false;
        } else if (Cw.field_status == 1) {
            Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", Long.valueOf(j2));
            AppMethodBeat.o(89030);
            return false;
        } else {
            this.qJi.remove(Cw.field_sysDownloadId);
            long j3 = j(Cw);
            if (j3 > 0) {
                this.qJj.add(Long.valueOf(Cw.field_downloadId));
                if (this.cve.stopped()) {
                    this.cve.startTimer(100);
                }
                Cw.field_sysDownloadId = j3;
                Cw.field_status = 1;
                d.e(Cw);
                AppMethodBeat.o(89030);
                return true;
            }
            Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            AppMethodBeat.o(89030);
            return false;
        }
    }
}
