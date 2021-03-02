package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class h implements com.tencent.mm.pluginsdk.j.a.c.h {
    h() {
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.h
    public final void a(s sVar, int i2) {
        AppMethodBeat.i(151963);
        if (sVar.field_expireTime != 0 && sVar.field_expireTime <= Util.nowSecond()) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", sVar.field_urlKey, Long.valueOf(sVar.field_expireTime));
            q qVar = q.a.Kan;
            String str = sVar.field_urlKey;
            if (qVar.lsb) {
                qVar.Kak.gC(str);
            }
            a.bej(sVar.field_filePath);
            a.bej(sVar.field_filePath + ".decompressed");
            a.bej(sVar.field_filePath + ".decrypted");
            q.a.Kan.Zb(sVar.field_urlKey);
            AppMethodBeat.o(151963);
        } else if (i2 == 0) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
            AppMethodBeat.o(151963);
        } else if (2 == i2 && 1 == sVar.field_networkType) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
            AppMethodBeat.o(151963);
        } else if (sVar.field_deleted) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", sVar.field_urlKey);
            a.bej(sVar.field_filePath);
            a.bej(sVar.field_filePath + ".decompressed");
            a.bej(sVar.field_filePath + ".decrypted");
            AppMethodBeat.o(151963);
        } else if (!sVar.field_needRetry) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion);
            AppMethodBeat.o(151963);
        } else if (sVar.field_status == 2) {
            long hv = a.hv(sVar.field_filePath);
            if (sVar.field_contentLength > hv) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == hv) {
                    if (!sVar.field_needRetry) {
                        Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion);
                        AppMethodBeat.o(151963);
                        return;
                    } else if (1 != i2) {
                        Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        AppMethodBeat.o(151963);
                        return;
                    } else {
                        for (b.AbstractC2018b bVar : b.gnC().gnB()) {
                            Util.getInt(sVar.field_fileVersion, 0);
                            if (bVar.gnG()) {
                                Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", bVar.getClass().getName(), Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion);
                                AppMethodBeat.o(151963);
                                return;
                            }
                        }
                        sVar.field_fileUpdated = true;
                        b.gnC().h(sVar.field_resType, sVar.field_subType, 0, Util.nullAsNil(sVar.field_groupId2).equals("NewXml"));
                        q.a.Kan.h(sVar);
                    }
                }
                j.m(sVar.field_resType, sVar.field_subType, Util.getInt(sVar.field_fileVersion, 0), (int) sVar.field_reportId, 76);
                q.a.Kan.d(c.d(sVar));
                AppMethodBeat.o(151963);
            } else if (!e(sVar)) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                a(sVar, 1 == i2);
                AppMethodBeat.o(151963);
            } else {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                f(sVar);
                AppMethodBeat.o(151963);
            }
        } else if (sVar.field_status == 1 || sVar.field_status == 0) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", Long.valueOf(sVar.field_contentLength));
            if (!q.a.Kan.beh(sVar.field_urlKey)) {
                Log.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
                if (e(sVar)) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                    sVar.field_status = 2;
                    sVar.field_contentLength = a.hv(sVar.field_filePath);
                    q.a.Kan.h(sVar);
                    f(sVar);
                    AppMethodBeat.o(151963);
                    return;
                }
                if (0 == a.hv(sVar.field_filePath)) {
                    sVar.field_fileUpdated = true;
                    q.a.Kan.h(sVar);
                    b.gnC().h(sVar.field_resType, sVar.field_subType, 0, Util.nullAsNil(sVar.field_groupId2).equals("NewXml"));
                }
                Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
                j.m(sVar.field_resType, sVar.field_subType, Util.getInt(sVar.field_fileVersion, 0), (int) sVar.field_reportId, 76);
                q.a.Kan.d(c.d(sVar));
                AppMethodBeat.o(151963);
                return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
            AppMethodBeat.o(151963);
        } else {
            if (sVar.field_status == 4 || sVar.field_status == 3) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                sVar.field_status = 0;
                a(sVar, true);
            }
            AppMethodBeat.o(151963);
        }
    }

    private static boolean e(s sVar) {
        AppMethodBeat.i(151964);
        boolean equals = Util.nullAsNil(com.tencent.mm.vfs.s.bhK(sVar.field_filePath)).equals(sVar.field_md5);
        AppMethodBeat.o(151964);
        return equals;
    }

    private static void f(s sVar) {
        AppMethodBeat.i(151966);
        if (sVar.field_fileCompress || sVar.field_fileEncrypt) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            b.gnC().b(sVar);
            AppMethodBeat.o(151966);
            return;
        }
        b.gnC().a(sVar.field_resType, sVar.field_subType, sVar.field_filePath, Util.getInt(sVar.field_fileVersion, 0), sVar.field_originalMd5);
        AppMethodBeat.o(151966);
    }

    private static void a(s sVar, boolean z) {
        AppMethodBeat.i(151965);
        q.a.Kan.Zb(sVar.field_urlKey);
        a.bej(sVar.field_filePath);
        a.bej(sVar.field_filePath + ".decompressed");
        a.bej(sVar.field_filePath + ".decrypted");
        if (2 == sVar.field_status && !z) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
            AppMethodBeat.o(151965);
        } else if (sVar.field_maxRetryTimes <= 0 || sVar.field_retryTimes > 0) {
            sVar.field_retryTimes--;
            sVar.field_fileUpdated = true;
            q.a.Kan.h(sVar);
            j.F(sVar.field_reportId, 12);
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            c d2 = c.d(sVar);
            d2.IOp = false;
            j.m(sVar.field_resType, sVar.field_subType, Util.getInt(sVar.field_fileVersion, 0), (int) sVar.field_reportId, 76);
            q.a.Kan.d(d2);
            AppMethodBeat.o(151965);
        } else {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", Integer.valueOf(sVar.field_maxRetryTimes), Integer.valueOf(sVar.field_retryTimes));
            AppMethodBeat.o(151965);
        }
    }
}
