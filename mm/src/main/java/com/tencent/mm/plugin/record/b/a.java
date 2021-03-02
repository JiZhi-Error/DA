package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class a {
    private static f BGq;

    /* renamed from: com.tencent.mm.plugin.record.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1630a {
    }

    public static void HS(long j2) {
        AppMethodBeat.i(9439);
        com.tencent.mm.plugin.r.a.cgO().Mo(j2);
        c cVar = new c();
        com.tencent.mm.plugin.r.a.cgO().get(j2, cVar);
        if (cVar.field_msgInfoId <= 0) {
            AppMethodBeat.o(9439);
            return;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb(cVar.field_msgInfoId);
        if (Hb.field_msgId != cVar.field_msgInfoId) {
            AppMethodBeat.o(9439);
            return;
        }
        Hb.setStatus(5);
        ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
        AppMethodBeat.o(9439);
    }

    public static boolean a(ca caVar, c cVar) {
        AppMethodBeat.i(9440);
        if (cVar == null || !s.YS(cVar.field_fileFullPath)) {
            AppMethodBeat.o(9440);
            return false;
        } else if (cVar.deQ() || (caVar.field_isSend == 1 && cVar.field_isUpload)) {
            AppMethodBeat.o(9440);
            return true;
        } else {
            AppMethodBeat.o(9440);
            return false;
        }
    }

    private static String aB(String str, String str2, String str3) {
        String str4;
        int i2 = 1;
        AppMethodBeat.i(9442);
        o oVar = new o(str);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        if (Util.isNullOrNil(str2)) {
            str4 = str + "da_" + Util.nowMilliSecond();
            if (!Util.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        } else {
            if (!Util.isNullOrNil(str3) && !str2.endsWith(str3)) {
                str2 = str2 + "." + str3;
            }
            str4 = str + str2;
            if (s.YS(str4)) {
                while (true) {
                    if (i2 >= 20) {
                        break;
                    } else if (!s.YS(str + i2 + "_" + str2)) {
                        str4 = str + i2 + "_" + str2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 20) {
                    str4 = str + "da_" + Util.nowMilliSecond();
                    if (!Util.isNullOrNil(str3)) {
                        str4 = str4 + "." + str3;
                    }
                }
            }
        }
        try {
            if (!aa.z(new o(str4).heq().her()).equalsIgnoreCase(aa.z(new o(str).her()))) {
                str4 = str + "da_" + Util.nowMilliSecond();
                Log.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", str4);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppMsgLogic", e2, "", new Object[0]);
            str4 = str + "da_" + Util.nowMilliSecond();
            if (!Util.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        }
        AppMethodBeat.o(9442);
        return str4;
    }

    private static String a(String str, long j2, int i2, String str2, String str3, int i3, int i4, int i5) {
        AppMethodBeat.i(9443);
        c cVar = new c();
        cVar.field_fileFullPath = str;
        cVar.field_appId = str2;
        cVar.field_sdkVer = (long) i2;
        cVar.field_mediaSvrId = str3;
        cVar.field_totalLen = (long) i3;
        cVar.field_status = 101;
        cVar.field_isUpload = false;
        cVar.field_createTime = Util.nowMilliSecond();
        cVar.field_lastModifyTime = Util.nowSecond();
        cVar.field_msgInfoId = j2;
        cVar.field_netTimes = 0;
        cVar.field_type = (long) i4;
        Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(com.tencent.mm.plugin.r.a.cgO().insert(cVar)), Long.valueOf(cVar.systemRowid), Long.valueOf(cVar.field_totalLen), Long.valueOf(cVar.field_type), Integer.valueOf(i5), str, Util.getStack());
        AppMethodBeat.o(9443);
        return str3;
    }

    private static String E(long j2, String str) {
        AppMethodBeat.i(9444);
        Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j2), str, null);
        k.b HD = k.b.HD(str);
        if (HD == null) {
            AppMethodBeat.o(9444);
            return null;
        }
        String aB = aB(b.aKM(), HD.title, HD.iwJ);
        if (Util.isNullOrNil(HD.dCK) && !Util.isNullOrNil(HD.iwW)) {
            HD.dCK = new StringBuilder().append(HD.iwW.hashCode()).toString();
        }
        String a2 = a(aB, j2, HD.sdkVer, HD.appId, HD.dCK, HD.iwI, HD.type, HD.iwM);
        AppMethodBeat.o(9444);
        return a2;
    }

    public static c s(String str, long j2) {
        AppMethodBeat.i(9438);
        c cVar = new c();
        if (Util.isNullOrNil(str)) {
            cVar = null;
        } else {
            Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
            long j3 = Util.getLong(str, -1);
            if (j3 != -1) {
                com.tencent.mm.plugin.r.a.cgO().get(j3, cVar);
                if (cVar.systemRowid != j3 && ((cVar = com.tencent.mm.plugin.r.a.cgO().bdx(str)) == null || !cVar.field_mediaSvrId.equals(str))) {
                    Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    cVar = null;
                }
            } else {
                cVar = com.tencent.mm.plugin.r.a.cgO().bdx(str);
                if (cVar == null || !cVar.field_mediaSvrId.equals(str)) {
                    Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                    cVar = null;
                }
            }
            Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j3));
        }
        if (cVar == null) {
            cVar = com.tencent.mm.plugin.r.a.cgO().Mp(j2);
        }
        if (cVar != null) {
            Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", cVar, Long.valueOf(cVar.systemRowid), Boolean.valueOf(cVar.field_isUpload), cVar.field_fileFullPath, Long.valueOf(cVar.field_totalLen), Long.valueOf(cVar.field_offset), cVar.field_mediaSvrId, cVar.field_mediaId, Long.valueOf(cVar.field_msgInfoId), Long.valueOf(cVar.field_type), Util.getStack());
        } else {
            Log.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", Util.getStack());
        }
        AppMethodBeat.o(9438);
        return cVar;
    }

    public static void aK(ca caVar) {
        boolean z;
        int length;
        AppMethodBeat.i(9441);
        k.b HD = k.b.HD(caVar.field_content);
        if (HD == null) {
            Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", caVar.field_content);
            AppMethodBeat.o(9441);
            return;
        }
        if (Util.isNullOrNil(HD.dCK) && !Util.isNullOrNil(HD.iwW)) {
            Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", caVar.field_content);
            HD.dCK = new StringBuilder().append(HD.iwW.hashCode()).toString();
        }
        String str = HD.dCK;
        if (!a(caVar, s(str, caVar.field_msgId))) {
            if (caVar == null) {
                z = false;
            } else {
                boolean z2 = true;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                c s = s(str, caVar.field_msgId);
                k.b HD2 = k.b.HD(caVar.field_content);
                if (HD2 != null) {
                    str2 = Util.nullAsNil(HD2.title);
                    str3 = Util.nullAsNil(HD2.iwJ).toLowerCase();
                    str4 = Util.nullAsNil(HD2.filemd5);
                    str5 = Util.nullAsNil(HD2.dRL);
                    str6 = Util.nullAsNil(HD2.aesKey);
                }
                if (s == null) {
                    E(caVar.field_msgId, caVar.field_content);
                    s = s(str, caVar.field_msgId);
                    if (s != null) {
                        Object[] objArr = new Object[8];
                        objArr[0] = Long.valueOf(s.systemRowid);
                        objArr[1] = Long.valueOf(s.field_totalLen);
                        objArr[2] = s.field_fileFullPath;
                        objArr[3] = Long.valueOf(s.field_type);
                        objArr[4] = s.field_mediaId;
                        objArr[5] = Long.valueOf(s.field_msgInfoId);
                        objArr[6] = Boolean.valueOf(s.field_isUpload);
                        if (s.field_signature == null) {
                            length = -1;
                        } else {
                            length = s.field_signature.length();
                        }
                        objArr[7] = Integer.valueOf(length);
                        Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", objArr);
                        if (HD2 != null && (HD2.iwM != 0 || HD2.iwI > 26214400)) {
                            z2 = false;
                        }
                    }
                } else {
                    o oVar = new o(s.field_fileFullPath);
                    if (s.field_status == 199 && !oVar.exists()) {
                        Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                        E(caVar.field_msgId, caVar.field_content);
                    }
                    Object[] objArr2 = new Object[10];
                    objArr2[0] = Long.valueOf(s.systemRowid);
                    objArr2[1] = Long.valueOf(s.field_totalLen);
                    objArr2[2] = s.field_fileFullPath;
                    objArr2[3] = Long.valueOf(s.field_type);
                    objArr2[4] = s.field_mediaId;
                    objArr2[5] = Long.valueOf(s.field_msgInfoId);
                    objArr2[6] = Boolean.valueOf(s.field_isUpload);
                    objArr2[7] = Boolean.valueOf(oVar.exists());
                    objArr2[8] = Long.valueOf(s.field_status);
                    objArr2[9] = Integer.valueOf(s.field_signature == null ? -1 : s.field_signature.length());
                    Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", objArr2);
                }
                if (!z2) {
                    g.aAg().hqi.a(new d(s, str6, str4, str2, str3, str5), 0);
                }
                z = z2;
            }
            if (z) {
                BGq = new f(caVar.field_msgId, str, new j() {
                    /* class com.tencent.mm.plugin.record.b.a.AnonymousClass1 */
                    final /* synthetic */ AbstractC1630a BGr = null;

                    @Override // com.tencent.mm.ak.j
                    public final void a(int i2, int i3, q qVar) {
                    }
                });
                g.aAg().hqi.a(BGq, 0);
            }
        }
        AppMethodBeat.o(9441);
    }
}
