package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.d.b;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public class FileDownloadService extends MMIntentService {
    public static final String EXTRA_ID = (qIZ + "id");
    public static final String EXTRA_PACKAGE_NAME = (qIZ + "package_name");
    private static final String qIZ = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String qJa = (qIZ + ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
    public static final String qJb = (qIZ + "file_path");
    public static final String qJc = (qIZ + "md5");
    public static final String qJd = (qIZ + "change_url");

    static {
        AppMethodBeat.i(89010);
        AppMethodBeat.o(89010);
    }

    public FileDownloadService() {
        super("FileDownloadService");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.service.MMIntentService
    public final void onHandleIntent(Intent intent) {
        boolean z;
        String str;
        boolean z2;
        long j2;
        String str2;
        AppMethodBeat.i(89008);
        if (intent == null) {
            AppMethodBeat.o(89008);
            return;
        }
        int intExtra = intent.getIntExtra(qJa, 0);
        Log.i("MicroMsg.FileDownloadService", "handle intent type : %d", Integer.valueOf(intExtra));
        switch (intExtra) {
            case 1:
                long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                if (longExtra < 0) {
                    Log.e("MicroMsg.FileDownloadService", "Invalid id");
                    AppMethodBeat.o(89008);
                    return;
                }
                if (g.aAf().azp()) {
                    g.aAf();
                    if (!a.azj()) {
                        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(longExtra);
                        if (Cw != null) {
                            if (intent.getBooleanExtra(qJd, false) || Cw.field_isSecondDownload) {
                                z = true;
                            } else {
                                z = false;
                            }
                            Log.i("MicroMsg.FileDownloadService", "filePath = " + Cw.field_filePath);
                            if (Util.isNullOrNil(Cw.field_filePath) || !s.YS(Cw.field_filePath)) {
                                h.INSTANCE.idkeyStat(710, 5, 1, false);
                                Cw.field_status = 4;
                                Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFw;
                                d.e(Cw);
                                f cBv = f.cBv();
                                int i2 = com.tencent.mm.plugin.downloader.a.a.qFw;
                                Log.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", Long.valueOf(longExtra), Integer.valueOf(i2));
                                if (cBv.qIy != null) {
                                    cBv.qIy.c(longExtra, i2, z);
                                }
                                Log.i("MicroMsg.FileDownloadService", "file not exists, appid = " + Cw.field_appId);
                                AppMethodBeat.o(89008);
                                return;
                            } else if (Util.isNullOrNil(Cw.field_md5)) {
                                Log.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                                Cw.field_status = 3;
                                d.e(Cw);
                                f.cBv().o(longExtra, z);
                                AppMethodBeat.o(89008);
                                return;
                            } else {
                                long j3 = 0;
                                if (!Util.isNullOrNil(Cw.field_appId)) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    try {
                                        o oVar = new o(Cw.field_filePath);
                                        String z3 = aa.z(oVar.her());
                                        boolean akZ = b.akZ(z3);
                                        Object[] objArr = new Object[2];
                                        objArr[0] = z3;
                                        objArr[1] = akZ ? "v2" : "v1";
                                        Log.i("MicroMsg.Channel.GameChannelUtil", "apkPath:%s, this is %s signature", objArr);
                                        str2 = null;
                                        if (akZ) {
                                            str2 = b.J(oVar);
                                        }
                                        if (str2 == null) {
                                            str2 = b.I(oVar);
                                            if (akZ && str2 != null) {
                                                Log.i("MicroMsg.Channel.GameChannelUtil", "you are use v2 signature but use v1 channel modle, this apk will can't install in 7.0system");
                                            }
                                        }
                                        Log.i("MicroMsg.Channel.GameChannelUtil", "readChannel, channelId = %s", str2);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.FileDownloadService", "readChannelId exception : " + e2.getMessage());
                                        str2 = "";
                                    }
                                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                    j3 = 0 + currentTimeMillis2;
                                    Log.i("MicroMsg.FileDownloadService", "readChannelId, channelId:%s, cost time: %d", str2, Long.valueOf(currentTimeMillis2));
                                    str = str2;
                                } else {
                                    str = "";
                                }
                                com.tencent.mm.plugin.downloader.f.b bVar = new com.tencent.mm.plugin.downloader.f.b(Cw.field_appId, Cw.field_downloadId, str, j3, Cw.field_reserveInWifi ? 1 : 0);
                                boolean f2 = e.f(Cw);
                                if (z) {
                                    if (f2) {
                                        com.tencent.mm.plugin.downloader.f.a.aa(Cw.field_appId, 21);
                                        com.tencent.mm.plugin.downloader.f.a.a(108, bVar);
                                    } else {
                                        com.tencent.mm.plugin.downloader.f.a.aa(Cw.field_appId, 22);
                                        com.tencent.mm.plugin.downloader.f.a.a(109, bVar);
                                    }
                                }
                                if (!f2) {
                                    if (Cw.field_downloadUrl.startsWith("https")) {
                                        com.tencent.mm.plugin.downloader.f.a.aa(Cw.field_appId, 32);
                                    } else {
                                        com.tencent.mm.plugin.downloader.f.a.aa(Cw.field_appId, 31);
                                    }
                                }
                                if (f2) {
                                    Cw.field_status = 3;
                                    Cw.field_channelId = str;
                                    d.e(Cw);
                                    d.cW(Cw.field_downloadUrl, 3);
                                    f.cBv().o(longExtra, z);
                                    AppMethodBeat.o(89008);
                                    return;
                                }
                                if (Cw.field_downloaderType == 3) {
                                    if (Cw.field_downloadUrl.startsWith("https")) {
                                        h.INSTANCE.idkeyStat(710, 10, 1, false);
                                    } else {
                                        h.INSTANCE.idkeyStat(710, 9, 1, false);
                                    }
                                } else if (Cw.field_downloadUrl.startsWith("https")) {
                                    h.INSTANCE.idkeyStat(710, 7, 1, false);
                                } else {
                                    h.INSTANCE.idkeyStat(710, 6, 1, false);
                                }
                                Cw.field_status = 4;
                                Cw.field_channelId = str;
                                Cw.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFs;
                                Cw.field_downloadedSize = s.boW(Cw.field_filePath);
                                d.e(Cw);
                                Log.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", str, Long.valueOf(Cw.field_downloadedSize), Long.valueOf(s.boW(Cw.field_filePath)));
                                Log.i("MicroMsg.FileDownloadService", "delete file: %s", Cw.field_filePath);
                                s.deleteFile(Cw.field_filePath);
                                Object[] objArr2 = new Object[3];
                                objArr2[0] = Boolean.valueOf(NetStatusUtil.isWifi(MMApplicationContext.getContext()));
                                objArr2[1] = Boolean.valueOf(z);
                                objArr2[2] = Boolean.valueOf(!Util.isNullOrNil(Cw.field_secondaryUrl));
                                Log.i("MicroMsg.FileDownloadService", "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b", objArr2);
                                String str3 = Cw.field_secondaryUrl;
                                if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()) || z || Util.isNullOrNil(str3)) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    g.a aVar = new g.a();
                                    aVar.alj(Cw.field_secondaryUrl);
                                    aVar.setFileSize(Cw.field_fileSize);
                                    aVar.all(Cw.field_fileName);
                                    aVar.alo(Cw.field_notificationTitle);
                                    aVar.setAppId(Cw.field_appId);
                                    aVar.setFileMD5(Cw.field_md5);
                                    aVar.setScene(Cw.field_scene);
                                    aVar.Rv(Cw.field_extInfo);
                                    aVar.qIY.qIL = true;
                                    aVar.kS(true);
                                    aVar.Fl(1);
                                    aVar.gm(Cw.field_packageName);
                                    aVar.qIY.qIN = true;
                                    if (Cw.field_sectionMd5Byte != null) {
                                        q qVar = new q();
                                        try {
                                            qVar.parseFrom(Cw.field_sectionMd5Byte);
                                            aVar.V(qVar.qGz);
                                        } catch (IOException e3) {
                                        }
                                    }
                                    if (Cw.field_downloaderType != 3) {
                                        long a2 = f.cBv().a(aVar.qIY);
                                        h.INSTANCE.idkeyStat(710, 8, 1, false);
                                        j2 = a2;
                                    } else {
                                        long b2 = f.cBv().b(aVar.qIY);
                                        h.INSTANCE.idkeyStat(710, 11, 1, false);
                                        j2 = b2;
                                    }
                                    Log.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = ".concat(String.valueOf(j2)));
                                    com.tencent.mm.plugin.downloader.f.a.a(110, bVar);
                                    com.tencent.mm.plugin.downloader.f.a.aa(Cw.field_appId, 30);
                                    AppMethodBeat.o(89008);
                                    return;
                                }
                                f cBv2 = f.cBv();
                                com.tencent.mm.plugin.downloader.g.a Cw2 = d.Cw(longExtra);
                                if (Cw2 != null) {
                                    Context context = MMApplicationContext.getContext();
                                    if (Cw2.field_showNotification && !Util.isNullOrNil(Cw2.field_notificationTitle)) {
                                        f.a(Cw2.field_appId, Cw2.field_notificationTitle, context.getString(R.string.cdp), null);
                                    } else if (Cw2.field_showNotification && Util.isNullOrNil(Cw2.field_fileName)) {
                                        f.a(Cw2.field_appId, context.getString(R.string.cdp), "", null);
                                    } else if (Cw2.field_showNotification && !Util.isNullOrNil(Cw2.field_fileName)) {
                                        f.a(Cw2.field_appId, Cw2.field_fileName, context.getString(R.string.cdp), null);
                                    }
                                    cBv2.qIy.c(longExtra, com.tencent.mm.plugin.downloader.a.a.qFs, z);
                                }
                            }
                        }
                        AppMethodBeat.o(89008);
                        return;
                    }
                }
                Log.d("MicroMsg.FileDownloadService", "no user login");
                AppMethodBeat.o(89008);
                return;
            case 3:
                String stringExtra = intent.getStringExtra(qJb);
                long longExtra2 = intent.getLongExtra("downloadId", -1);
                if (!Util.isNullOrNil(stringExtra) && s.YS(stringExtra)) {
                    com.tencent.mm.plugin.downloader.g.a Cw3 = d.Cw(longExtra2);
                    if (Cw3 == null) {
                        com.tencent.mm.plugin.downloader.i.a.a(stringExtra, null);
                        break;
                    } else {
                        com.tencent.mm.plugin.downloader.i.a.a(Cw3.field_downloadId, false, null);
                        AppMethodBeat.o(89008);
                        return;
                    }
                } else {
                    Log.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                    AppMethodBeat.o(89008);
                    return;
                }
        }
        AppMethodBeat.o(89008);
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.FileDownloadService";
    }
}
