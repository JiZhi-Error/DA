package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.j;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLiteAppObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.record.b.d;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.g.c;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class m {
    private static f BGq;

    public interface a {
        void kA(int i2, int i3);
    }

    public static boolean bdH(String str) {
        AppMethodBeat.i(31017);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(31017);
            return false;
        } else if (str.equals("0:0")) {
            AppMethodBeat.o(31017);
            return false;
        } else {
            AppMethodBeat.o(31017);
            return true;
        }
    }

    public static void HS(long j2) {
        AppMethodBeat.i(31018);
        ao.cgO().Mo(j2);
        c cVar = new c();
        ao.cgO().get(j2, cVar);
        if (cVar.field_msgInfoId <= 0) {
            AppMethodBeat.o(31018);
            return;
        }
        bg.aVF();
        ca Hb = c.aSQ().Hb(cVar.field_msgInfoId);
        if (Hb.field_msgId != cVar.field_msgInfoId) {
            AppMethodBeat.o(31018);
            return;
        }
        Hb.setStatus(5);
        bg.aVF();
        c.aSQ().a(Hb.field_msgId, Hb);
        AppMethodBeat.o(31018);
    }

    public static int bdI(String str) {
        AppMethodBeat.i(31019);
        k.b HD = k.b.HD(str);
        if (HD == null) {
            AppMethodBeat.o(31019);
            return -1;
        } else if (!bdH(HD.dCK)) {
            AppMethodBeat.o(31019);
            return -1;
        } else {
            c cVar = new c();
            long j2 = Util.getLong(HD.dCK, -1);
            if (j2 != -1) {
                ao.cgO().get(j2, cVar);
                if (cVar.systemRowid != j2 && ((cVar = ao.cgO().bdx(HD.dCK)) == null || !cVar.field_mediaSvrId.equals(HD.dCK))) {
                    AppMethodBeat.o(31019);
                    return -1;
                }
            } else {
                cVar = ao.cgO().bdx(HD.dCK);
                if (cVar == null || !cVar.field_mediaSvrId.equals(HD.dCK)) {
                    AppMethodBeat.o(31019);
                    return -1;
                }
            }
            if (cVar.field_totalLen == 0) {
                AppMethodBeat.o(31019);
                return -1;
            }
            int i2 = (int) ((cVar.field_offset * 100) / cVar.field_totalLen);
            AppMethodBeat.o(31019);
            return i2;
        }
    }

    public static String E(long j2, String str) {
        AppMethodBeat.i(31020);
        Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j2), str, null);
        k.b HD = k.b.HD(str);
        if (HD == null) {
            AppMethodBeat.o(31020);
            return null;
        }
        String aB = aB(b.aKM(), HD.title, HD.iwJ);
        if (Util.isNullOrNil(HD.dCK) && !Util.isNullOrNil(HD.iwW)) {
            HD.dCK = new StringBuilder().append(HD.iwW.hashCode()).toString();
        }
        String a2 = a(aB, j2, HD.sdkVer, HD.appId, HD.dCK, HD.iwI, HD.type, HD.iwM);
        AppMethodBeat.o(31020);
        return a2;
    }

    public static boolean a(ca caVar, c cVar) {
        AppMethodBeat.i(31022);
        if (cVar == null || !s.YS(cVar.field_fileFullPath)) {
            AppMethodBeat.o(31022);
            return false;
        } else if (cVar.deQ() || (caVar.field_isSend == 1 && cVar.field_isUpload)) {
            AppMethodBeat.o(31022);
            return true;
        } else {
            AppMethodBeat.o(31022);
            return false;
        }
    }

    public static boolean e(String str, ca caVar) {
        int length;
        AppMethodBeat.i(31023);
        if (caVar == null) {
            AppMethodBeat.o(31023);
            return false;
        }
        boolean z = true;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        c s = s(str, caVar.field_msgId);
        k.b HD = k.b.HD(caVar.field_content);
        if (HD != null) {
            str2 = af.nullAsNil(HD.title);
            str3 = af.nullAsNil(HD.iwJ).toLowerCase();
            str4 = af.nullAsNil(HD.filemd5);
            str5 = af.nullAsNil(HD.dRL);
            str6 = af.nullAsNil(HD.aesKey);
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
                if (HD != null && (HD.iwM != 0 || HD.iwI > 26214400)) {
                    z = false;
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
        if (!z) {
            bg.azz().a(new d(s, str6, str4, str2, str3, str5), 0);
        }
        AppMethodBeat.o(31023);
        return z;
    }

    public static c s(String str, long j2) {
        AppMethodBeat.i(31024);
        c bdJ = bdJ(str);
        if (bdJ == null) {
            bdJ = ao.cgO().Mp(j2);
        }
        if (bdJ != null) {
            Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", bdJ, Long.valueOf(bdJ.systemRowid), Boolean.valueOf(bdJ.field_isUpload), bdJ.field_fileFullPath, Long.valueOf(bdJ.field_totalLen), Long.valueOf(bdJ.field_offset), bdJ.field_mediaSvrId, bdJ.field_mediaId, Long.valueOf(bdJ.field_msgInfoId), Long.valueOf(bdJ.field_type), Util.getStack());
        } else {
            Log.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", Util.getStack());
        }
        AppMethodBeat.o(31024);
        return bdJ;
    }

    public static String a(String str, long j2, int i2, String str2, String str3, int i3, int i4, int i5) {
        AppMethodBeat.i(31025);
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
        Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(ao.cgO().insert(cVar)), Long.valueOf(cVar.systemRowid), Long.valueOf(cVar.field_totalLen), Long.valueOf(cVar.field_type), Integer.valueOf(i5), str, Util.getStack());
        AppMethodBeat.o(31025);
        return str3;
    }

    public static c a(String str, long j2, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(31026);
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
        AppMethodBeat.o(31026);
        return cVar;
    }

    public static c a(String str, k.b bVar, String str2) {
        AppMethodBeat.i(31027);
        Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        String replace = str2.replace("//", FilePathGenerator.ANDROID_DIR_SEP);
        if (replace.startsWith(b.aKA())) {
            Log.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", replace);
            AppMethodBeat.o(31027);
            return null;
        }
        c cVar = new c();
        cVar.field_totalLen = (long) bVar.iwI;
        cVar.field_fileFullPath = str2;
        cVar.field_sdkVer = (long) bVar.sdkVer;
        cVar.field_appId = bVar.appId;
        cVar.field_clientAppDataId = str;
        cVar.field_type = (long) bVar.type;
        cVar.field_status = 200;
        cVar.field_isUpload = true;
        cVar.field_createTime = Util.nowMilliSecond();
        cVar.field_lastModifyTime = Util.nowSecond();
        cVar.field_mediaSvrId = new StringBuilder().append(Util.nowMilliSecond()).toString();
        cVar.field_isUseCdn = 0;
        ao.cgO().insert(cVar);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig buildUploadAttachInfo file:" + cVar.field_fileFullPath + " rowid:" + cVar.systemRowid + " clientAppDataId:" + cVar.field_clientAppDataId);
        if (cVar.systemRowid < 0) {
            Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig uploadAttach insert appattach info failed :" + cVar.systemRowid);
            AppMethodBeat.o(31027);
            return null;
        }
        AppMethodBeat.o(31027);
        return cVar;
    }

    public static int a(long j2, String str, com.tencent.mm.i.d dVar, boolean z) {
        AppMethodBeat.i(31028);
        bg.aVF();
        ca Hb = c.aSQ().Hb(j2);
        if (Hb.field_msgId != j2) {
            Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " getmsgFailed id:" + j2);
            int line = 0 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(31028);
            return line;
        }
        k.b HD = k.b.HD(Hb.field_content);
        if (HD == null) {
            Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " getmsgFailed id:" + j2);
            int line2 = 0 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(31028);
            return line2;
        }
        HD.dCK = str;
        if (z && dVar != null) {
            HD.aesKey = dVar.field_aesKey.equals("") ? HD.aesKey : dVar.field_aesKey;
            HD.iwW = dVar.field_fileId.equals("") ? HD.iwW : dVar.field_fileId;
            HD.filemd5 = dVar.field_filemd5.equals("") ? HD.filemd5 : dVar.field_filemd5;
            HD.iwI = dVar.field_fileLength == 0 ? HD.iwI : (int) dVar.field_fileLength;
            HD.iwX = dVar.field_thumbUrl.equals("") ? HD.iwX : dVar.field_thumbUrl;
        }
        Hb.setContent(k.b.a(HD, HD.dCK, dVar));
        bg.aVF();
        c.aSQ().a(Hb.field_msgId, Hb);
        k GL = ao.gnf().GL(j2);
        if (GL != null) {
            GL.field_xml = Hb.field_content;
            ao.gnf().update(GL, "msgId");
        }
        if (z) {
            c Mp = ao.cgO().Mp(j2);
            Mp.field_mediaSvrId = str;
            Mp.field_offset = Mp.field_totalLen;
            ao.cgO().a(Mp, new String[0]);
        }
        AppMethodBeat.o(31028);
        return 0;
    }

    public static Pair<Integer, Long> a(k.b bVar, String str, String str2, String str3, String str4, byte[] bArr) {
        AppMethodBeat.i(31029);
        Pair<Integer, Long> a2 = a(bVar, str, str2, str3, str4, bArr, (String) null);
        AppMethodBeat.o(31029);
        return a2;
    }

    public static Pair<Integer, Long> a(k.b bVar, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        AppMethodBeat.i(31030);
        Pair<Integer, Long> a2 = a(bVar, str, str2, str3, str4, bArr, str5, "");
        AppMethodBeat.o(31030);
        return a2;
    }

    public static String aB(String str, String str2, String str3) {
        String str4;
        int i2 = 1;
        AppMethodBeat.i(31031);
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
                if (!Util.isNullOrNil(str2)) {
                    str4 = str4 + str2;
                }
                if (!Util.isNullOrNil(str3)) {
                    str4 = str4 + "." + str3;
                }
                Log.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", str4);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppMsgLogic", e2, "", new Object[0]);
            str4 = str + "da_" + Util.nowMilliSecond();
            if (!Util.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        }
        AppMethodBeat.o(31031);
        return str4;
    }

    public static Pair<Integer, Long> a(k.b bVar, String str, String str2, String str3, String str4, byte[] bArr, final String str5, String str6) {
        c cVar;
        String str7;
        int i2;
        int i3;
        AppMethodBeat.i(31032);
        Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", str4, bVar);
        String sb = new StringBuilder().append(System.currentTimeMillis()).toString();
        if (!Util.isNullOrNil(str4)) {
            c a2 = a(sb, bVar, str4);
            if (a2 == null) {
                Pair<Integer, Long> pair = new Pair<>(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), -1L);
                AppMethodBeat.o(31032);
                return pair;
            }
            cVar = a2;
        } else {
            cVar = null;
        }
        final ca caVar = new ca();
        if (bArr != null && bArr.length > 0) {
            if (bVar.type == 33 || bVar.type == 36 || bVar.type == 44 || bVar.type == 48) {
                if (bVar.type == 48) {
                    i2 = 0;
                    i3 = 0;
                } else {
                    i2 = (int) (BitmapUtil.getDefaultDisplayMetrics().density * 240.0f);
                    i3 = (int) (BitmapUtil.getDefaultDisplayMetrics().density * 240.0f);
                }
                com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                String str8 = aVar != null ? aVar.imageUrl : "";
                boolean z = aVar != null ? aVar.ivh : false;
                if (bVar.type == 44 || bVar.type == 48) {
                    str7 = q.bcR().a(bArr, Bitmap.CompressFormat.JPEG, i2, i3, str8, z);
                } else {
                    str7 = q.bcR().a(bArr, Bitmap.CompressFormat.JPEG, str8, z);
                }
            } else if (bVar.type == 46) {
                str7 = q.bcR().a(bArr, Bitmap.CompressFormat.JPEG);
            } else {
                str7 = q.bcR().a(bArr, bVar.type == 2, Bitmap.CompressFormat.PNG);
            }
            Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + str7);
            if (!Util.isNullOrNil(str7)) {
                caVar.Cz(str7);
                Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(str7)));
            }
        }
        if (cVar != null) {
            bVar.dCK = new StringBuilder().append(cVar.systemRowid).toString();
        }
        caVar.setContent(k.b.a(bVar, null, null));
        caVar.setStatus(1);
        caVar.Cy(str3);
        caVar.setCreateTime(bp.Kw(str3));
        caVar.nv(1);
        caVar.setType(g(bVar));
        String Z = ((w) g.af(w.class)).Z(caVar);
        if (!Util.isNullOrNil(Z)) {
            caVar.BB(Z);
            Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", caVar.fqK);
        }
        if (bVar.type == 53) {
            caVar.CJ((String) bVar.izx.first);
        }
        bg.aVF();
        final long aC = c.aSQ().aC(caVar);
        if (bVar.type == 53) {
            ns nsVar = new ns();
            nsVar.dTP.type = 0;
            nsVar.dTP.key = caVar.fRd;
            nsVar.dTP.username = caVar.field_talker;
            nsVar.dTQ.msgId = aC;
            EventCenter.instance.publish(nsVar);
        }
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + aC);
        if (aC < 0) {
            Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + aC);
            Pair<Integer, Long> pair2 = new Pair<>(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(aC));
            AppMethodBeat.o(31032);
            return pair2;
        }
        Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + aC);
        caVar.setMsgId(aC);
        k kVar = new k();
        kVar.field_xml = caVar.field_content;
        kVar.field_appId = str;
        kVar.field_title = bVar.title;
        kVar.field_type = bVar.type;
        kVar.field_description = bVar.description;
        kVar.field_msgId = aC;
        kVar.field_source = str2;
        ao.gnf().insert(kVar);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(cVar == null);
        Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", objArr);
        if (cVar != null) {
            cVar.field_msgInfoId = aC;
            cVar.field_status = 101;
            ao.cgO().a(cVar, new String[0]);
            if (bVar.type == 2 || !Util.isNullOrNil(str5)) {
                ao.gnh().P(aC, str5);
            }
            ao.gnh().run();
        } else if (bVar.iwM != 0 || bVar.iwI > 26214400) {
            bg.azz().a(new com.tencent.mm.pluginsdk.g.c(bVar, str4, str3, new c.a() {
                /* class com.tencent.mm.pluginsdk.model.app.m.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.g.c.a
                public final void a(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
                    AppMethodBeat.i(232150);
                    if (Util.isNullOrNil(str4)) {
                        caVar.setStatus(5);
                        bg.aVF();
                        com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                        ca caVar = new ca();
                        caVar.setCreateTime(bp.Kw(caVar.field_talker));
                        caVar.Cy(caVar.field_talker);
                        caVar.setContent(str);
                        caVar.setType(10000);
                        caVar.setStatus(6);
                        caVar.nv(0);
                        bg.aVF();
                        com.tencent.mm.model.c.aSQ().aC(caVar);
                        AppMethodBeat.o(232150);
                        return;
                    }
                    ao.gnh();
                    an.a.f(aC, str5, str4);
                    AppMethodBeat.o(232150);
                }
            }), 0);
        } else {
            ao.gnh();
            an.a.f(aC, str5, str6);
        }
        Pair<Integer, Long> pair3 = new Pair<>(0, Long.valueOf(aC));
        AppMethodBeat.o(31032);
        return pair3;
    }

    private static List<a.b> a(long j2, String str, anb anb) {
        String str2;
        AppMethodBeat.i(232152);
        List<a.b> synchronizedList = Collections.synchronizedList(new ArrayList());
        Iterator<aml> it = anb.ppH.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.LvI > 26214400) {
                a.b bVar = new a.b();
                String c2 = p.c(next, j2);
                String bhK = s.bhK(c2);
                bVar.toUser = str;
                bVar.fileSize = next.LvI;
                bVar.gCr = next.LvC;
                if (!Util.isNullOrNil(next.LvE)) {
                    bhK = next.LvE;
                }
                bVar.pkL = bhK;
                bVar.aesKey = next.Lvp;
                bVar.fileName = next.title;
                if (Util.isNullOrNil(next.LvL)) {
                    str2 = c2;
                } else {
                    str2 = next.LvL;
                }
                bVar.filePath = str2;
                synchronizedList.add(bVar);
            }
        }
        AppMethodBeat.o(232152);
        return synchronizedList;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(31033);
        int a2 = a(wXMediaMessage, str, str2, str3, i2, str4, null, 0, null);
        AppMethodBeat.o(31033);
        return a2;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i2, String str4, String str5, int i3, a aVar) {
        AppMethodBeat.i(31034);
        k.b bVar = new k.b();
        bVar.appId = str;
        bVar.appName = str2;
        bVar.iwL = i2;
        int a2 = a(bVar, wXMediaMessage, str3, str4, str5, i3, aVar);
        AppMethodBeat.o(31034);
        return a2;
    }

    public static int a(k.b bVar, WXMediaMessage wXMediaMessage, String str, int i2, a aVar) {
        AppMethodBeat.i(31035);
        int a2 = a(bVar, wXMediaMessage, str, (String) null, (String) null, i2, aVar);
        AppMethodBeat.o(31035);
        return a2;
    }

    private static int a(k.b bVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i2, a aVar) {
        String ap;
        AppMethodBeat.i(31036);
        if (i2 == 1) {
            com.tencent.mm.pluginsdk.ui.tools.c cVar = new com.tencent.mm.pluginsdk.ui.tools.c();
            cVar.dYz = 1;
            bVar.a(cVar);
        }
        c cVar2 = null;
        String str4 = "";
        if (aVar != null) {
            str4 = aVar.pkK;
        }
        String a2 = a(bVar, wXMediaMessage, str2, str4);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + "summerbig content url:" + bVar.url + " lowUrl:" + bVar.iwH + " attachlen:" + bVar.iwI + " attachid:" + bVar.dCK + " attach file:" + a2);
        String sb = new StringBuilder().append(System.currentTimeMillis()).toString();
        if (!Util.isNullOrNil(a2)) {
            c a3 = a(sb, bVar, a2);
            if (a3 == null) {
                int line = 0 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(31036);
                return line;
            }
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(a2);
            if (imageOptions != null) {
                bVar.thumbWidth = imageOptions.outWidth;
                bVar.thumbHeight = imageOptions.outHeight;
            }
            cVar2 = a3;
        }
        ca caVar = new ca();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            if (wXMediaMessage.thumbData.length <= 65536 || wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46) {
                ap = q.bcR().ap(wXMediaMessage.thumbData);
            } else {
                ap = q.bcR().a(wXMediaMessage.thumbData, bVar.type == 2, Bitmap.CompressFormat.JPEG);
            }
            Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig thumbData MsgInfo path:" + ap);
            if (!Util.isNullOrNil(ap)) {
                caVar.Cz(ap);
            }
        }
        if (cVar2 != null) {
            bVar.dCK = new StringBuilder().append(cVar2.systemRowid).toString();
        }
        for (String str5 : Util.stringsToList(str.split(","))) {
            bVar.iwK = str2;
            caVar.setContent(k.b.a(bVar, null, null));
            caVar.setStatus(1);
            caVar.Cy(str5);
            caVar.setCreateTime(bp.Kw(str5));
            caVar.nv(1);
            caVar.setType(g(bVar));
            String Z = ((w) g.af(w.class)).Z(caVar);
            if (!Util.isNullOrNil(Z)) {
                caVar.BB(Z);
            }
            bg.aVF();
            long aC = com.tencent.mm.model.c.aSQ().aC(caVar);
            if (aC < 0) {
                Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig insert msg failed :" + aC);
                int line2 = 0 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(31036);
                return line2;
            }
            Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + aC);
            caVar.setMsgId(aC);
            k kVar = new k();
            kVar.field_xml = caVar.field_content;
            kVar.field_title = wXMediaMessage.title;
            kVar.field_type = wXMediaMessage.mediaObject.type();
            kVar.field_description = wXMediaMessage.description;
            kVar.field_msgId = aC;
            kVar.field_source = bVar.appName;
            ao.gnf().insert(kVar);
            if (cVar2 != null) {
                cVar2.field_msgInfoId = aC;
                cVar2.field_status = 101;
                Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", Long.valueOf(cVar2.field_msgInfoId), Long.valueOf(cVar2.field_status), Long.valueOf(cVar2.systemRowid), Integer.valueOf(kVar.field_type));
                ao.cgO().a(cVar2, new String[0]);
                if (!Util.isNullOrNil(str3)) {
                    ao.gnh().P(cVar2.field_msgInfoId, str3);
                }
                ao.gnh().run();
            } else {
                Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", cVar2, Long.valueOf(aC), str3, Integer.valueOf(kVar.field_type));
                ao.gnh();
                an.a.a(aC, str3, i2, aVar);
            }
        }
        AppMethodBeat.o(31036);
        return 0;
    }

    public static String cC(byte[] bArr) {
        AppMethodBeat.i(31037);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " attachBuf is null");
            AppMethodBeat.o(31037);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(com.tencent.mm.model.c.aTg()).append("ua_").append(Util.nowMilliSecond()).toString();
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " buildUploadAttachInfo file:" + sb2);
        if (s.f(sb2, bArr, bArr.length) != 0) {
            Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " writeFile error file:" + sb2);
            AppMethodBeat.o(31037);
            return null;
        }
        AppMethodBeat.o(31037);
        return sb2;
    }

    public static String a(k.b bVar, WXMediaMessage wXMediaMessage, String str, String str2) {
        boolean z;
        AppMethodBeat.i(232153);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        bVar.sdkVer = wXMediaMessage.sdkVer;
        bVar.title = wXMediaMessage.title;
        bVar.description = wXMediaMessage.description;
        bVar.mediaTagName = wXMediaMessage.mediaTagName;
        bVar.messageAction = wXMediaMessage.messageAction;
        bVar.messageExt = wXMediaMessage.messageExt;
        WXMediaMessage.IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        bVar.type = iMediaObject.type();
        if (bVar.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
            bVar.extInfo = wXAppExtendObject.extInfo;
            if (!Util.isNullOrNil(wXAppExtendObject.fileData)) {
                Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + wXAppExtendObject.fileData.length);
                bVar.iwI = wXAppExtendObject.fileData.length;
                String cC = cC(wXAppExtendObject.fileData);
                AppMethodBeat.o(232153);
                return cC;
            }
            bVar.iwI = (int) s.boW(wXAppExtendObject.filePath);
            Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + wXAppExtendObject.filePath + " len:" + bVar.iwI);
            if (bVar.iwI > 0) {
                bVar.iwJ = s.akC(wXAppExtendObject.filePath);
                String str3 = wXAppExtendObject.filePath;
                AppMethodBeat.o(232153);
                return str3;
            }
            AppMethodBeat.o(232153);
            return null;
        } else if (bVar.type == 49) {
            bVar.type = h.ahL(((WXWeWorkObject) iMediaObject).subType);
            AppMethodBeat.o(232153);
            return null;
        } else if (bVar.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) iMediaObject;
            if (!Util.isNullOrNil(wXFileObject.fileData)) {
                Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + wXFileObject.fileData.length);
                bVar.iwI = wXFileObject.fileData.length;
                String cC2 = cC(wXFileObject.fileData);
                AppMethodBeat.o(232153);
                return cC2;
            }
            bVar.iwI = (int) s.boW(wXFileObject.filePath);
            Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + wXFileObject.filePath + " len:" + bVar.iwI);
            if (bVar.iwI > 0) {
                bVar.iwJ = s.akC(wXFileObject.filePath);
                String str4 = wXFileObject.filePath;
                AppMethodBeat.o(232153);
                return str4;
            }
            AppMethodBeat.o(232153);
            return null;
        } else if (bVar.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) iMediaObject;
            if (!Util.isNullOrNil(wXImageObject.imageData)) {
                Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + wXImageObject.imageData.length);
                bVar.iwI = wXImageObject.imageData.length;
                String cC3 = cC(wXImageObject.imageData);
                AppMethodBeat.o(232153);
                return cC3;
            } else if (!Util.isNullOrNil(wXImageObject.imagePath)) {
                bVar.iwI = (int) s.boW(wXImageObject.imagePath);
                Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + wXImageObject.imagePath + " len:" + bVar.iwI);
                if (bVar.iwI > 0) {
                    bVar.iwJ = s.akC(wXImageObject.imagePath);
                    bg.aVF();
                    String z2 = aa.z(new o(com.tencent.mm.model.c.aTg(), "appmsg_img_" + System.currentTimeMillis()).her());
                    BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(wXImageObject.imagePath);
                    if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
                        Object[] objArr = new Object[3];
                        if (imageOptions == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        objArr[1] = Integer.valueOf(imageOptions == null ? -1 : imageOptions.outWidth);
                        objArr[2] = Integer.valueOf(imageOptions == null ? -1 : imageOptions.outHeight);
                        Log.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", objArr);
                        AppMethodBeat.o(232153);
                        return null;
                    } else if (z.f(wXImageObject.imagePath, "", true)) {
                        Log.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", wXImageObject.imagePath, z2);
                        if (s.nw(wXImageObject.imagePath, z2) < 0) {
                            Log.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", wXImageObject.imagePath, z2);
                            AppMethodBeat.o(232153);
                            return null;
                        }
                        AppMethodBeat.o(232153);
                        return z2;
                    } else {
                        if (imageOptions.outWidth > 960 || imageOptions.outHeight > 960) {
                            Bitmap extractThumbNail = BitmapUtil.extractThumbNail(wXImageObject.imagePath, 960, 960, false);
                            if (extractThumbNail != null) {
                                try {
                                    BitmapUtil.saveBitmapToImage(extractThumbNail, 100, Bitmap.CompressFormat.JPEG, z2, true);
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.AppMsgLogic", e2, "", new Object[0]);
                                    AppMethodBeat.o(232153);
                                    return null;
                                }
                            } else {
                                AppMethodBeat.o(232153);
                                return null;
                            }
                        } else if (s.nw(wXImageObject.imagePath, z2) < 0) {
                            AppMethodBeat.o(232153);
                            return null;
                        }
                        AppMethodBeat.o(232153);
                        return z2;
                    }
                } else {
                    AppMethodBeat.o(232153);
                    return null;
                }
            } else {
                AppMethodBeat.o(232153);
                return null;
            }
        } else if (bVar.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            bVar.url = wXMusicObject.musicUrl;
            bVar.iwH = wXMusicObject.musicLowBandUrl;
            bVar.ixd = wXMusicObject.musicDataUrl;
            bVar.ixe = wXMusicObject.musicLowBandDataUrl;
            com.tencent.mm.pluginsdk.ui.tools.b bVar2 = new com.tencent.mm.pluginsdk.ui.tools.b();
            bVar2.songAlbumUrl = wXMusicObject.songAlbumUrl;
            bVar2.songLyric = wXMusicObject.songLyric;
            bVar.a(bVar2);
            AppMethodBeat.o(232153);
            return null;
        } else if (bVar.type == 76) {
            WXMusicVideoObject wXMusicVideoObject = (WXMusicVideoObject) iMediaObject;
            bVar.url = wXMusicVideoObject.musicUrl;
            bVar.ixd = wXMusicVideoObject.musicDataUrl;
            com.tencent.mm.pluginsdk.ui.tools.b bVar3 = new com.tencent.mm.pluginsdk.ui.tools.b();
            bVar3.songAlbumUrl = str2;
            bVar3.Ktr = wXMusicVideoObject.singerName;
            bVar3.Kts = wXMusicVideoObject.albumName;
            bVar3.songLyric = wXMusicVideoObject.songLyric;
            bVar3.Ktt = wXMusicVideoObject.musicGenre;
            bVar3.Ktu = String.valueOf(wXMusicVideoObject.issueDate);
            bVar3.Ktv = wXMusicVideoObject.identification;
            bVar3.Alz = wXMusicVideoObject.duration;
            bVar3.Ktw = bVar.messageExt;
            bVar.a(bVar3);
            AppMethodBeat.o(232153);
            return null;
        } else if (bVar.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
            bVar.url = wXVideoObject.videoUrl;
            bVar.iwH = wXVideoObject.videoLowBandUrl;
            AppMethodBeat.o(232153);
            return null;
        } else if (bVar.type == 5 || bVar.type == 54 || bVar.type == 69) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
            bVar.url = wXWebpageObject.webpageUrl;
            if (!Util.isNullOrNil(wXWebpageObject.extInfo)) {
                bVar.extInfo = wXWebpageObject.extInfo;
            }
            if (!Util.isNullOrNil(wXWebpageObject.canvasPageXml)) {
                bVar.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            if (bVar.type == 69 && (wXWebpageObject instanceof com.tencent.mm.plugin.game.luggage.f.b)) {
                com.tencent.mm.plugin.game.luggage.f.b bVar4 = (com.tencent.mm.plugin.game.luggage.f.b) wXWebpageObject;
                com.tencent.mm.plugin.game.luggage.f.a aVar = new com.tencent.mm.plugin.game.luggage.f.a();
                aVar.iconUrl = bVar4.iconUrl;
                aVar.nickName = bVar4.nickName;
                aVar.desc = bVar4.desc;
                aVar.xxN = bVar4.xxN;
                aVar.jumpUrl = bVar4.jumpUrl;
                bVar.a(aVar);
            }
            AppMethodBeat.o(232153);
            return null;
        } else {
            if (bVar.type == 36 || bVar.type == 46 || bVar.type == 48) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) iMediaObject;
                bVar.izi = wXMiniProgramObject.userName;
                bVar.izh = wXMiniProgramObject.path;
                bVar.url = wXMiniProgramObject.webpageUrl;
                WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(wXMiniProgramObject.userName);
                if (Xk != null) {
                    if (Xk.bAp() != null) {
                        bVar.izA = Xk.bAp().appVersion;
                    }
                    bVar.izB = Xk.field_brandIconURL;
                    Log.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", Integer.valueOf(bVar.izA), bVar.izB);
                }
            } else if (bVar.type == 1) {
                bVar.title = ((WXTextObject) iMediaObject).text;
                AppMethodBeat.o(232153);
                return null;
            } else if (bVar.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) iMediaObject;
                if (!Util.isNullOrNil(wXEmojiObject.emojiData)) {
                    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + wXEmojiObject.emojiData.length);
                    bVar.iwI = wXEmojiObject.emojiData.length;
                    String cC4 = cC(wXEmojiObject.emojiData);
                    AppMethodBeat.o(232153);
                    return cC4;
                } else if (!Util.isNullOrNil(wXEmojiObject.emojiPath)) {
                    bVar.iwI = (int) s.boW(wXEmojiObject.emojiPath);
                    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + wXEmojiObject.emojiPath + " len:" + bVar.iwI);
                    if (bVar.iwI > 0) {
                        bVar.iwJ = s.akC(wXEmojiObject.emojiPath);
                        String str5 = wXEmojiObject.emojiPath;
                        AppMethodBeat.o(232153);
                        return str5;
                    }
                    AppMethodBeat.o(232153);
                    return null;
                } else {
                    bVar.iwK = str;
                }
            } else if (bVar.type == 15) {
                WXEmojiSharedObject wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                bVar.thumburl = wXEmojiSharedObject.thumburl;
                bVar.ixp = wXEmojiSharedObject.packageflag;
                bVar.ixo = wXEmojiSharedObject.packageid;
                bVar.dDG = 8;
                bVar.url = wXEmojiSharedObject.url;
                AppMethodBeat.o(232153);
                return null;
            } else if (bVar.type == 13) {
                WXEmojiSharedObject wXEmojiSharedObject2 = (WXEmojiSharedObject) iMediaObject;
                bVar.thumburl = wXEmojiSharedObject2.thumburl;
                bVar.ixp = wXEmojiSharedObject2.packageflag;
                bVar.ixo = wXEmojiSharedObject2.packageid;
                bVar.dDG = 8;
                bVar.url = wXEmojiSharedObject2.url;
                AppMethodBeat.o(232153);
                return null;
            } else if (bVar.type == 68) {
                WXLiteAppObject wXLiteAppObject = (WXLiteAppObject) iMediaObject;
                bVar.url = wXLiteAppObject.webpageUrl;
                bVar.izu = wXLiteAppObject.userName;
                bVar.izv = wXLiteAppObject.path;
                bVar.izw = wXLiteAppObject.query;
                bVar.dDG = 0;
                AppMethodBeat.o(232153);
                return null;
            } else if (bVar.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) iMediaObject;
                bVar.thumburl = wXDesignerSharedObject.thumburl;
                bVar.url = wXDesignerSharedObject.url;
                bVar.iyV = wXDesignerSharedObject.designerUIN;
                bVar.designerName = wXDesignerSharedObject.designerName;
                bVar.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                bVar.dDG = 18;
                AppMethodBeat.o(232153);
                return null;
            } else if (bVar.type == 27 || bVar.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) iMediaObject;
                bVar.thumburl = wXEmojiPageSharedObject.iconUrl;
                bVar.url = wXEmojiPageSharedObject.url;
                bVar.tid = wXEmojiPageSharedObject.tid;
                bVar.iyW = wXEmojiPageSharedObject.title;
                bVar.desc = wXEmojiPageSharedObject.desc;
                bVar.iconUrl = wXEmojiPageSharedObject.iconUrl;
                bVar.secondUrl = wXEmojiPageSharedObject.secondUrl;
                bVar.pageType = wXEmojiPageSharedObject.pageType;
                bVar.dDG = 20;
                AppMethodBeat.o(232153);
                return null;
            }
            AppMethodBeat.o(232153);
            return null;
        }
    }

    public static c c(ca caVar, String str) {
        AppMethodBeat.i(31039);
        c bdJ = bdJ(str);
        if (bdJ == null) {
            E(caVar.field_msgId, caVar.field_content);
            c bdJ2 = bdJ(str);
            AppMethodBeat.o(31039);
            return bdJ2;
        }
        AppMethodBeat.o(31039);
        return bdJ;
    }

    public static c bdJ(String str) {
        AppMethodBeat.i(31040);
        c cVar = new c();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(31040);
            return null;
        }
        Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
        long j2 = Util.getLong(str, -1);
        if (j2 != -1) {
            ao.cgO().get(j2, cVar);
            if (cVar.systemRowid != j2 && ((cVar = ao.cgO().bdx(str)) == null || !cVar.field_mediaSvrId.equals(str))) {
                Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                cVar = null;
            }
        } else {
            cVar = ao.cgO().bdx(str);
            if (cVar == null || !cVar.field_mediaSvrId.equals(str)) {
                Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                cVar = null;
            }
        }
        Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j2));
        AppMethodBeat.o(31040);
        return cVar;
    }

    public static int g(k.b bVar) {
        AppMethodBeat.i(31042);
        if (bVar == null) {
            AppMethodBeat.o(31042);
            return 49;
        }
        int i2 = bVar.type;
        int i3 = bVar.dDG;
        int i4 = bVar.iwc;
        int i5 = bVar.ixf;
        int i6 = bVar.iyA;
        Log.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i3 + " atype " + i2 + ", itemShowType = " + i4 + ", c2cNewAAType = " + i6);
        if (i2 == 76) {
            AppMethodBeat.o(31042);
            return 1040187441;
        } else if (i2 == 3 && com.tencent.mm.plugin.music.model.m.akQ(bVar.appId)) {
            AppMethodBeat.o(31042);
            return 1040187441;
        } else if (i4 == 4 || i5 != 0) {
            AppMethodBeat.o(31042);
            return 318767153;
        } else if (i2 == 2001) {
            if (i3 == 1) {
                AppMethodBeat.o(31042);
                return 469762097;
            } else if (i6 == 4) {
                AppMethodBeat.o(31042);
                return 503316529;
            } else {
                AppMethodBeat.o(31042);
                return 436207665;
            }
        } else if (i2 == 2002) {
            AppMethodBeat.o(31042);
            return 536870961;
        } else if (i2 == 2003) {
            AppMethodBeat.o(31042);
            return 536936497;
        } else if (i2 == 66) {
            AppMethodBeat.o(31042);
            return 905969713;
        } else {
            switch (i3) {
                case 1:
                    if (i2 == 21) {
                        AppMethodBeat.o(31042);
                        return -1879048185;
                    }
                    AppMethodBeat.o(31042);
                    return 285212721;
                case 2:
                    if (i2 == 21) {
                        AppMethodBeat.o(31042);
                        return -1879048183;
                    }
                    AppMethodBeat.o(31042);
                    return 301989937;
                case 3:
                    if (i2 == 21) {
                        AppMethodBeat.o(31042);
                        return -1879048176;
                    }
                    AppMethodBeat.o(31042);
                    return -1879048189;
                case 4:
                    if (i2 == 21) {
                        AppMethodBeat.o(31042);
                        return -1879048183;
                    }
                    AppMethodBeat.o(31042);
                    return -1879048190;
                case 5:
                    AppMethodBeat.o(31042);
                    return -1879048191;
                case 17:
                    AppMethodBeat.o(31042);
                    return -1879048186;
                default:
                    switch (i2) {
                        case 1:
                            AppMethodBeat.o(31042);
                            return 16777265;
                        case 2:
                            AppMethodBeat.o(31042);
                            return 268435505;
                        case 8:
                            AppMethodBeat.o(31042);
                            return 1048625;
                        case 10:
                            AppMethodBeat.o(31042);
                            return 335544369;
                        case 13:
                            AppMethodBeat.o(31042);
                            return 369098801;
                        case 16:
                            AppMethodBeat.o(31042);
                            return 452984881;
                        case 17:
                            AppMethodBeat.o(31042);
                            return -1879048186;
                        case 20:
                            AppMethodBeat.o(31042);
                            return 402653233;
                        case 33:
                        case 36:
                            com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                            if (aVar != null && aVar.iuQ && (bVar.izk == 2 || bVar.izk == 3)) {
                                AppMethodBeat.o(31042);
                                return 553648177;
                            } else if (aVar == null || !aVar.iuT || bVar.izk != 3) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 587202609;
                            }
                        case 34:
                            AppMethodBeat.o(31042);
                            return 520093745;
                        case 46:
                            AppMethodBeat.o(31042);
                            return 687865905;
                        case 47:
                            AppMethodBeat.o(31042);
                            return 704643121;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            AppMethodBeat.o(31042);
                            return 738197553;
                        case 50:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 771751985;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 771751985;
                            }
                        case 51:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 754974769;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 754974769;
                            }
                        case 52:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 788529201;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 788529201;
                            }
                        case 53:
                            AppMethodBeat.o(31042);
                            return 805306417;
                        case 54:
                            e eVar = (e) bVar.as(e.class);
                            if (eVar == null || eVar.iwi == null) {
                                AppMethodBeat.o(31042);
                                return 49;
                            }
                            AppMethodBeat.o(31042);
                            return 486539313;
                        case n.CTRL_INDEX:
                            AppMethodBeat.o(31042);
                            return 822083633;
                        case bv.CTRL_INDEX:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 838860849;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 838860849;
                            }
                        case 60:
                            AppMethodBeat.o(31042);
                            return 855638065;
                        case 62:
                            AppMethodBeat.o(31042);
                            return 922746929;
                        case 63:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 973078577;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 973078577;
                            }
                        case 65:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 989855793;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 989855793;
                            }
                        case 69:
                            AppMethodBeat.o(31042);
                            return 939524145;
                        case 71:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 1023410225;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 1023410225;
                            }
                        case 72:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 1006633009;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 1006633009;
                            }
                        case com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX:
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 956301361;
                            } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 1) {
                                AppMethodBeat.o(31042);
                                return 49;
                            } else {
                                AppMethodBeat.o(31042);
                                return 956301361;
                            }
                        case 75:
                            switch (l.d(bVar.izF, bVar.izD)) {
                                case 2:
                                    AppMethodBeat.o(31042);
                                    return 1057030193;
                                case 3:
                                    AppMethodBeat.o(31042);
                                    return 1023541297;
                                case XWalkEnvironment.TEST_APK_START_VERSION /*{ENCODED_INT: 100000000}*/:
                                    AppMethodBeat.o(31042);
                                    return 1023475761;
                                default:
                                    AppMethodBeat.o(31042);
                                    return 49;
                            }
                        case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                            AppMethodBeat.o(31042);
                            return 1074790449;
                        case 2000:
                            AppMethodBeat.o(31042);
                            return 419430449;
                        case 671088689:
                            AppMethodBeat.o(31042);
                            return 671088689;
                        default:
                            AppMethodBeat.o(31042);
                            return 49;
                    }
            }
        }
    }

    public static int ahM(int i2) {
        switch (i2) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
            case -1879048186:
            case -1879048185:
            case -1879048183:
            case -1879048176:
            case 1048625:
            case 16777265:
            case 268435505:
            case 285212721:
            case 301989937:
            case 318767153:
            case 335544369:
            case 352321585:
            case 369098801:
            case 385876017:
            case 402653233:
            case 419430449:
            case 436207665:
            case 452984881:
            case 469762097:
            case 486539313:
            case 503316529:
            case 520093745:
            case 536870961:
            case 536936497:
            case 553648177:
            case 587202609:
            case 603979825:
            case 687865905:
            case 704643121:
            case 738197553:
            case 805306417:
            case 822083633:
            case 905969713:
            case 922746929:
            case 1040187441:
                return 49;
            default:
                return i2;
        }
    }

    public static void a(ca caVar, final a aVar) {
        AppMethodBeat.i(31021);
        k.b HD = k.b.HD(caVar.field_content);
        if (HD == null) {
            Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", caVar.field_content);
            AppMethodBeat.o(31021);
            return;
        }
        if (Util.isNullOrNil(HD.dCK) && !Util.isNullOrNil(HD.iwW)) {
            Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", caVar.field_content);
            HD.dCK = new StringBuilder().append(HD.iwW.hashCode()).toString();
        }
        String str = HD.dCK;
        if (!a(caVar, s(str, caVar.field_msgId)) && e(str, caVar)) {
            BGq = new f(caVar.field_msgId, str, new j() {
                /* class com.tencent.mm.pluginsdk.model.app.m.AnonymousClass1 */

                @Override // com.tencent.mm.ak.j
                public final void a(int i2, int i3, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(31016);
                    if (aVar != null) {
                        aVar.kA(i2, i3);
                    }
                    AppMethodBeat.o(31016);
                }
            });
            bg.azz().a(BGq, 0);
        }
        AppMethodBeat.o(31021);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Long> aS(final com.tencent.mm.storage.ca r15) {
        /*
        // Method dump skipped, instructions count: 733
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.app.m.aS(com.tencent.mm.storage.ca):android.util.Pair");
    }
}
