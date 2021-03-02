package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class f {

    static final class a {
        static void a(boolean z, boolean z2, s sVar, g gVar) {
            AppMethodBeat.i(151956);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (sVar.field_maxRetryTimes <= 0 || sVar.field_retryTimes > 0 || z2) {
                sVar.field_reportId = gVar.IBJ;
                sVar.field_status = 0;
                if (z2) {
                    sVar.field_maxRetryTimes = gVar.JYA;
                    sVar.field_retryTimes = gVar.JYA;
                    sVar.field_fileUpdated = true;
                    sVar.field_priority = gVar.priority;
                    if (gVar.fileSize > 0) {
                        sVar.field_fileSize = gVar.fileSize;
                    }
                    q.a.Kan.h(sVar);
                } else {
                    sVar.field_retryTimes--;
                    sVar.field_priority = gVar.priority;
                    q.a.Kan.h(sVar);
                    j.F(sVar.field_reportId, 12);
                }
                if (q.a.Kan.beh(gVar.JYs)) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", gVar.JYs);
                    if (gVar.dEU) {
                        j.F(gVar.IBJ, 9);
                        j.F(gVar.IBJ, 44);
                    }
                    AppMethodBeat.o(151956);
                    return;
                }
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", gVar.JYs);
                if (z2 && !z) {
                    b.gnC().h(sVar.field_resType, sVar.field_subType, 0, Util.nullAsNil(sVar.field_groupId2).equals("NewXml"));
                }
                c d2 = c.d(sVar);
                d2.IOp = z;
                d2.JYY = gVar.JYY;
                if (!z) {
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(i.aee(d2.JYs));
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(i.aee(d2.JYs) + ".decompressed");
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(i.aee(d2.JYs) + ".decrypted");
                }
                j.m(sVar.field_resType, sVar.field_subType, Util.getInt(sVar.field_fileVersion, 0), (int) sVar.field_reportId, 76);
                q.a.Kan.d(d2);
                AppMethodBeat.o(151956);
                return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", Integer.valueOf(sVar.field_maxRetryTimes), Integer.valueOf(sVar.field_retryTimes));
            AppMethodBeat.o(151956);
        }
    }

    static final class b {
        static void a(s sVar, boolean z, boolean z2) {
            AppMethodBeat.i(151957);
            if (sVar == null) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
                AppMethodBeat.o(151957);
                return;
            }
            String str = sVar.field_urlKey;
            String str2 = sVar.field_filePath;
            String str3 = sVar.field_md5;
            boolean z3 = sVar.field_fileCompress;
            boolean z4 = sVar.field_fileEncrypt;
            byte[] bArr = sVar.field_eccSignature;
            int i2 = Util.getInt(sVar.field_fileVersion, 0);
            int i3 = sVar.field_keyVersion;
            String str4 = sVar.field_encryptKey;
            boolean z5 = sVar.field_deleted;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z5 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + sVar.field_originalMd5 + ", fileCompress = " + z3 + ", fileEncrypt = " + z4 + ", eccSignature = " + bArr + ", fileVersion = " + i2 + ", (encrypt key == empty) = " + Util.isNullOrNil(str4));
            Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", str4);
            if (!z4) {
                if (z) {
                    j.F(sVar.field_reportId, 53);
                    j.F(sVar.field_reportId, 45);
                }
                if (!z3) {
                    Log.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                    AppMethodBeat.o(151957);
                    return;
                }
            }
            if (i3 != i2 && z4) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i3 >= 0) {
                    j.F(sVar.field_reportId, 52);
                    j.F(sVar.field_reportId, 45);
                }
                AppMethodBeat.o(151957);
            } else if (z5) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
                j.F(sVar.field_reportId, 51);
                j.F(sVar.field_reportId, 45);
                AppMethodBeat.o(151957);
            } else if (!Util.isNullOrNil(str4) || !z4) {
                if (Util.isNullOrNil(str3) || Util.isNullOrNil(str2)) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", str3, str2);
                } else if (q.a.Kan.beh(str)) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", str);
                    AppMethodBeat.o(151957);
                    return;
                } else if (!Util.nullAsNil(com.tencent.mm.vfs.s.bhK(str2)).equals(str3)) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
                    sVar.field_status = 3;
                    q.a.Kan.h(sVar);
                    j.F(sVar.field_reportId, 56);
                    j.F(sVar.field_reportId, 45);
                    AppMethodBeat.o(151957);
                    return;
                } else if (!q.a.Kan.beh(str)) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request %s", sVar.field_urlKey);
                    b.gnC().h(sVar.field_resType, sVar.field_subType, 1, Util.nullAsNil(sVar.field_groupId2).equals("NewXml"));
                    if (z2) {
                        b.gnC();
                        b.c(sVar);
                        AppMethodBeat.o(151957);
                        return;
                    }
                    b.gnC().b(sVar);
                    AppMethodBeat.o(151957);
                    return;
                }
                AppMethodBeat.o(151957);
            } else {
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
                j.F(sVar.field_reportId, 54);
                j.F(sVar.field_reportId, 45);
                AppMethodBeat.o(151957);
            }
        }
    }
}
