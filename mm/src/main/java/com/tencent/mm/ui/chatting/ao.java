package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.z;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.selectrecord.b.b;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage;
import com.tencent.wework.api.model.WWMediaMiniProgram;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public final class ao {
    private static String PkD = null;

    static /* synthetic */ void c(Context context, as asVar, List list, boolean z, IWWAPI.WWAppType wWAppType) {
        AppMethodBeat.i(232922);
        b(context, asVar, list, z, wWAppType);
        AppMethodBeat.o(232922);
    }

    public static boolean a(Context context, IWWAPI.WWAppType wWAppType) {
        AppMethodBeat.i(232915);
        boolean a2 = WWAPIFactory.ly(context).a(wWAppType);
        AppMethodBeat.o(232915);
        return a2;
    }

    public static String b(Context context, IWWAPI.WWAppType wWAppType) {
        AppMethodBeat.i(232916);
        IWWAPI ly = WWAPIFactory.ly(context);
        if (!WeChatBrands.AppInfo.current().isMainland()) {
            String string = context.getString(R.string.j2v);
            AppMethodBeat.o(232916);
            return string;
        }
        String b2 = ly.b(wWAppType);
        AppMethodBeat.o(232916);
        return b2;
    }

    public static boolean a(final Context context, final as asVar, final List<ca> list, final boolean z, final IWWAPI.WWAppType wWAppType) {
        AppMethodBeat.i(232917);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(232917);
            return false;
        } else if (k.ji(list)) {
            Log.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
            h.a(context, context.getString(R.string.bir), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.ao.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(232917);
            return false;
        } else {
            for (ca caVar : list) {
                if (!ac.bB(caVar)) {
                    h.a(context, context.getString(R.string.c89), "", context.getString(R.string.j34), (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(232917);
                    return false;
                }
            }
            if (!k.a(true, list, asVar.field_username, (z) null)) {
                Log.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                h.c(context, context.getString(R.string.e3u), "", context.getString(R.string.g5c), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.ao.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(34920);
                        ao.c(context, asVar, list, z, wWAppType);
                        AppMethodBeat.o(34920);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.ao.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(232914);
                        b.eSz().eSB();
                        AppMethodBeat.o(232914);
                    }
                });
                AppMethodBeat.o(232917);
                return true;
            }
            b(context, asVar, list, z, wWAppType);
            AppMethodBeat.o(232917);
            return true;
        }
    }

    private static void b(Context context, as asVar, List<ca> list, boolean z, IWWAPI.WWAppType wWAppType) {
        WWMediaMessage.WWMediaObject a2;
        AppMethodBeat.i(232918);
        IWWAPI ly = WWAPIFactory.ly(context);
        try {
            if (list.size() == 1) {
                a2 = a(context, asVar, list.get(0), z);
            } else {
                a2 = a(context, asVar, list, z);
            }
            ly.a(a2, wWAppType);
            b.eSz().Xk(1);
        } catch (a e2) {
            h.c(context, context.getResources().getString(R.string.gkl, Integer.valueOf(c.aqr() / 1048576)), context.getResources().getString(R.string.zb), true);
            b.eSz().Xk(2);
        }
        b.eSz().bfK();
        AppMethodBeat.o(232918);
    }

    private static WWMediaMessage.WWMediaObject a(Context context, as asVar, ca caVar, boolean z) {
        AppMethodBeat.i(232919);
        int type = caVar.getType();
        if (br.Q(caVar)) {
            WWMediaText wWMediaText = new WWMediaText(context.getString(R.string.wr));
            AppMethodBeat.o(232919);
            return wWMediaText;
        } else if (type == 1) {
            WWMediaText wWMediaText2 = new WWMediaText(k.A(caVar.field_content, caVar.field_isSend, z));
            AppMethodBeat.o(232919);
            return wWMediaText2;
        } else if (type == 3) {
            WWMediaMessage.WWMediaObject bP = bP(caVar);
            AppMethodBeat.o(232919);
            return bP;
        } else if (type == 43) {
            WWMediaVideo wWMediaVideo = new WWMediaVideo();
            s QN = u.QN(caVar.field_imgPath);
            o.bhj();
            wWMediaVideo.filePath = bmB(t.Qw(QN.getFileName()));
            Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", wWMediaVideo.filePath);
            AppMethodBeat.o(232919);
            return wWMediaVideo;
        } else if (type == 48) {
            WWMediaLocation wWMediaLocation = new WWMediaLocation();
            String A = k.A(caVar.field_content, caVar.field_isSend, z);
            bg.aVF();
            ca.b aEL = com.tencent.mm.model.c.aSQ().aEL(A);
            wWMediaLocation.title = aEL.kHV;
            wWMediaLocation.iUO = aEL.label;
            wWMediaLocation.longitude = aEL.yFv;
            wWMediaLocation.latitude = aEL.yFu;
            wWMediaLocation.Sxv = (double) aEL.dRt;
            AppMethodBeat.o(232919);
            return wWMediaLocation;
        } else if (type == 49 || type == 268435505) {
            WWMediaMessage.WWMediaObject a2 = a(asVar, caVar, z);
            AppMethodBeat.o(232919);
            return a2;
        } else {
            Log.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(type));
            AppMethodBeat.o(232919);
            return null;
        }
    }

    private static WWMediaMessage.WWMediaObject a(Context context, as asVar, List<ca> list, boolean z) {
        String string;
        String Ks;
        AppMethodBeat.i(232920);
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        String str = asVar.field_username;
        Context context2 = MMApplicationContext.getContext();
        if (z) {
            string = context2.getString(R.string.fvq);
        } else {
            String aUa = com.tencent.mm.model.z.aUa();
            String Ir = aa.Ir(str);
            if (aUa.equals(Ir)) {
                string = context2.getString(R.string.cb7, aUa);
            } else {
                string = context2.getString(R.string.cb6, aUa, Ir);
            }
        }
        wWMediaMergedConvs.title = string;
        for (ca caVar : list) {
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            if (caVar.field_isSend == 1) {
                Ks = com.tencent.mm.model.z.aTY();
            } else if (!z) {
                Ks = caVar.field_talker;
            } else {
                Ks = bp.Ks(caVar.field_content);
            }
            wWMediaConversation.name = aa.Ir(Ks) + Util.nullAsNil(com.tencent.mm.openim.room.a.a.O(((l) g.af(l.class)).aSN().Kn(Ks)));
            try {
                Bitmap a2 = com.tencent.mm.aj.c.a(Ks, false, -1, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a2.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                wWMediaConversation.Sxt = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            wWMediaConversation.sJT = caVar.field_createTime;
            wWMediaConversation.Sxu = a(context, asVar, caVar, z);
            wWMediaMergedConvs.a(wWMediaConversation);
        }
        AppMethodBeat.o(232920);
        return wWMediaMergedConvs;
    }

    private static WWMediaMergedConvs a(aml aml, ca caVar, as asVar, boolean z) {
        String str;
        AppMethodBeat.i(34927);
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        if (aml == null) {
            AppMethodBeat.o(34927);
            return wWMediaMergedConvs;
        }
        com.tencent.mm.protocal.b.a.c aKY = p.aKY(aml.Lwx);
        if (aKY == null) {
            AppMethodBeat.o(34927);
            return wWMediaMergedConvs;
        }
        wWMediaMergedConvs.title = aKY.title;
        Iterator<aml> it = aKY.iAd.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String str2 = next.Lwj;
            if (Util.isNullOrNil(next.LwI)) {
                wWMediaConversation.name = str2;
            } else {
                wWMediaConversation.name = str2 + next.LwI;
            }
            try {
                amn amn = next.Lwh.LwO;
                if (amn.Lxx) {
                    str = amn.dRL;
                } else if (amn.LxB) {
                    str = amn.LxA;
                } else {
                    str = "";
                }
                Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a2.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                wWMediaConversation.Sxt = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            long j2 = 0;
            try {
                j2 = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).parse(next.Lwl).getTime();
            } catch (ParseException e3) {
            }
            wWMediaConversation.sJT = j2;
            wWMediaConversation.Sxu = a(asVar, next, caVar, z);
            wWMediaMergedConvs.a(wWMediaConversation);
        }
        AppMethodBeat.o(34927);
        return wWMediaMergedConvs;
    }

    private static String bmB(String str) {
        AppMethodBeat.i(232921);
        if (!Util.isNullOrNil(str) && str.contains("image2")) {
            try {
                StringBuilder sb = new StringBuilder();
                if (PkD == null) {
                    PkD = new File(com.tencent.mm.loader.j.b.aKE()).getPath() + "/Tencent/WeixinWork/share";
                }
                String sb2 = sb.append(PkD).append(str.substring(str.indexOf("image2") + 6)).toString();
                String absolutePath = new File(sb2).getParentFile().getAbsolutePath();
                if (com.tencent.mm.vfs.s.YS(sb2)) {
                    com.tencent.mm.vfs.s.deleteFile(sb2);
                }
                if (!com.tencent.mm.vfs.s.YS(absolutePath)) {
                    com.tencent.mm.vfs.s.boN(absolutePath);
                }
                FilesCopy.copy(str, sb2, false);
                Log.i("MicroMsg.SendToWeWorkHelper", "getTempFilePath org:%s new:%s %s", str, sb2, Util.getStack().toString());
                AppMethodBeat.o(232921);
                return sb2;
            } catch (Exception e2) {
                Log.e("MicroMsg.SendToWeWorkHelper", "getTempFilePath(%s) Exception:%s %s", str, e2.getClass().getSimpleName(), e2.getMessage());
            }
        }
        AppMethodBeat.o(232921);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static class a extends Exception {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static WWMediaMessage.WWMediaObject a(as asVar, aml aml, ca caVar, boolean z) {
        String c2;
        AppMethodBeat.i(34923);
        int i2 = aml.dataType;
        if (i2 == 1) {
            WWMediaText wWMediaText = new WWMediaText(aml.desc);
            AppMethodBeat.o(34923);
            return wWMediaText;
        } else if (i2 == 2) {
            long j2 = caVar.field_msgId;
            if (!e.apn()) {
                c2 = null;
            } else {
                c2 = p.c(aml, j2);
                if (Util.isNullOrNil(c2)) {
                    c2 = p.f(aml, j2);
                }
                if (Util.isNullOrNil(c2) || !com.tencent.mm.vfs.s.YS(c2)) {
                    Log.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", c2);
                    c2 = null;
                }
            }
            if (Util.isNullOrNil(c2)) {
                Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
                AppMethodBeat.o(34923);
                return null;
            }
            WWMediaImage wWMediaImage = new WWMediaImage();
            wWMediaImage.filePath = bmB(c2);
            Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
            AppMethodBeat.o(34923);
            return wWMediaImage;
        } else if (i2 == 4) {
            String c3 = p.c(aml, caVar.field_msgId);
            if (Util.isNullOrNil(c3) || !com.tencent.mm.pluginsdk.j.a.d.a.YS(c3)) {
                Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
                AppMethodBeat.o(34923);
                return null;
            }
            WWMediaVideo wWMediaVideo = new WWMediaVideo();
            wWMediaVideo.filePath = bmB(c3);
            Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", wWMediaVideo.filePath);
            AppMethodBeat.o(34923);
            return wWMediaVideo;
        } else if (i2 == 6) {
            WWMediaLocation wWMediaLocation = new WWMediaLocation();
            if (aml.Lwh == null) {
                Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
                AppMethodBeat.o(34923);
                return null;
            }
            ams ams = aml.Lwh.LwQ;
            if (ams == null) {
                Log.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", aml.dLl);
                AppMethodBeat.o(34923);
                return null;
            }
            wWMediaLocation.title = ams.dWi;
            wWMediaLocation.iUO = ams.label;
            wWMediaLocation.longitude = ams.lng;
            wWMediaLocation.latitude = ams.lat;
            wWMediaLocation.Sxv = (double) ams.dRt;
            AppMethodBeat.o(34923);
            return wWMediaLocation;
        } else if (i2 == 8) {
            String c4 = p.c(aml, caVar.field_msgId);
            if (Util.isNullOrNil(c4)) {
                Log.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", aml.dLl);
                AppMethodBeat.o(34923);
                return null;
            }
            int aqr = c.aqr();
            if (com.tencent.mm.pluginsdk.j.a.d.a.hv(c4) > ((long) aqr)) {
                a aVar = new a((byte) 0);
                AppMethodBeat.o(34923);
                throw aVar;
            }
            WWMediaFile wWMediaFile = new WWMediaFile();
            wWMediaFile.fileName = aml.title;
            wWMediaFile.filePath = bmB(c4);
            wWMediaFile.setContentLengthLimit(aqr);
            AppMethodBeat.o(34923);
            return wWMediaFile;
        } else if (i2 == 17) {
            WWMediaMergedConvs a2 = a(aml, caVar, asVar, z);
            AppMethodBeat.o(34923);
            return a2;
        } else if (i2 == 19) {
            amj amj = aml.Lwh.Lxf;
            WWMediaMiniProgram wWMediaMiniProgram = new WWMediaMiniProgram();
            wWMediaMiniProgram.username = amj.username;
            wWMediaMiniProgram.path = amj.dCx;
            wWMediaMiniProgram.iconUrl = amj.iconUrl;
            wWMediaMiniProgram.Sxw = new byte[1];
            wWMediaMiniProgram.name = amj.Lve;
            wWMediaMiniProgram.title = "";
            wWMediaMiniProgram.type = amj.type;
            Log.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", wWMediaMiniProgram.username, wWMediaMiniProgram.path, wWMediaMiniProgram.iconUrl, Integer.valueOf(wWMediaMiniProgram.Sxw.length), wWMediaMiniProgram.name, wWMediaMiniProgram.title);
            AppMethodBeat.o(34923);
            return wWMediaMiniProgram;
        } else {
            Log.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(i2));
            AppMethodBeat.o(34923);
            return null;
        }
    }

    private static WWMediaMessage.WWMediaObject bP(ca caVar) {
        com.tencent.mm.av.g gVar;
        AppMethodBeat.i(34925);
        if (caVar.field_msgId > 0) {
            gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
        } else {
            gVar = null;
        }
        if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
            gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
        }
        if (gVar == null) {
            AppMethodBeat.o(34925);
            return null;
        }
        String o = q.bcR().o(com.tencent.mm.av.h.c(gVar), "", "");
        WWMediaImage wWMediaImage = new WWMediaImage();
        wWMediaImage.filePath = bmB(o);
        Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
        AppMethodBeat.o(34925);
        return wWMediaImage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.wework.api.model.WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.as r11, com.tencent.mm.storage.ca r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 514
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ao.a(com.tencent.mm.storage.as, com.tencent.mm.storage.ca, boolean):com.tencent.wework.api.model.WWMediaMessage$WWMediaObject");
    }

    private static WWMediaMergedConvs a(ca caVar, as asVar, boolean z) {
        com.tencent.mm.protocal.b.a.c cVar;
        String str;
        AppMethodBeat.i(34928);
        String str2 = caVar.field_content;
        if (ab.Eq(caVar.field_talker)) {
            str2 = bp.Kt(caVar.field_content);
        }
        k.b HD = k.b.HD(str2);
        if (HD != null) {
            cVar = p.aKY(HD.ixl);
        } else {
            cVar = null;
        }
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        if (cVar == null) {
            AppMethodBeat.o(34928);
            return wWMediaMergedConvs;
        }
        wWMediaMergedConvs.title = cVar.title;
        Iterator<aml> it = cVar.iAd.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String str3 = next.Lwj;
            if (Util.isNullOrNil(next.LwI)) {
                wWMediaConversation.name = str3;
            } else {
                wWMediaConversation.name = str3 + next.LwI;
            }
            try {
                amn amn = next.Lwh.LwO;
                if (amn.Lxx) {
                    str = amn.dRL;
                } else if (amn.LxB) {
                    str = amn.LxA;
                } else {
                    str = "";
                }
                Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a2.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                wWMediaConversation.Sxt = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            long j2 = 0;
            try {
                j2 = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).parse(next.Lwl).getTime();
            } catch (ParseException e3) {
            }
            wWMediaConversation.sJT = j2;
            wWMediaConversation.Sxu = a(asVar, next, caVar, z);
            wWMediaMergedConvs.a(wWMediaConversation);
        }
        AppMethodBeat.o(34928);
        return wWMediaMergedConvs;
    }
}
