package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.n;
import com.tencent.mm.plugin.sns.j.o;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class be implements i, m {
    private static int DGB = 0;
    private static final String DOF;
    private t DOG = null;
    public com.tencent.mm.plugin.sns.j.m DOH = new com.tencent.mm.plugin.sns.j.m();
    public ad.a DOI = new ad.a() {
        /* class com.tencent.mm.plugin.sns.model.be.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.sns.model.ad.a
        public final void uO(boolean z) {
            AppMethodBeat.i(96007);
            if (!z) {
                be.this.eZn();
            }
            AppMethodBeat.o(96007);
        }
    };
    private String gna = "";
    private Set<a> listeners = new HashSet();

    public interface a {
        void aP(int i2, boolean z);

        void fbl();
    }

    static /* synthetic */ boolean a(be beVar, SnsInfo snsInfo) {
        AppMethodBeat.i(96033);
        boolean K = beVar.K(snsInfo);
        AppMethodBeat.o(96033);
        return K;
    }

    static /* synthetic */ boolean b(be beVar) {
        AppMethodBeat.i(96032);
        boolean fbS = beVar.fbS();
        AppMethodBeat.o(96032);
        return fbS;
    }

    static {
        AppMethodBeat.i(96034);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        DOF = sb.append(g.aAh().cachePath).append("rangeCache.data").toString();
        AppMethodBeat.o(96034);
    }

    public enum b {
        STATE_ERROR,
        STATE_OK,
        STATE_FALSE;

        public static b valueOf(String str) {
            AppMethodBeat.i(96009);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(96009);
            return bVar;
        }

        static {
            AppMethodBeat.i(96010);
            AppMethodBeat.o(96010);
        }
    }

    public be() {
        AppMethodBeat.i(96011);
        byte[] aW = s.aW(DOF, 0, -1);
        if (aW != null) {
            try {
                this.DOH = (com.tencent.mm.plugin.sns.j.m) new com.tencent.mm.plugin.sns.j.m().parseFrom(aW);
                AppMethodBeat.o(96011);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.UploadManager", e2, "", new Object[0]);
                s.deleteFile(DOF);
            }
        }
        AppMethodBeat.o(96011);
    }

    public final void m(List<n> list, boolean z) {
        boolean z2;
        AppMethodBeat.i(96012);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(96012);
            return;
        }
        this.DOH.DSg = z;
        this.DOH.DSe.clear();
        this.DOH.DSe.addAll(list);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(this.DOH.DSf)) {
            for (n nVar : list) {
                if (nVar.type == 2) {
                    arrayList.add(nVar);
                }
            }
        } else {
            for (n nVar2 : list) {
                if (nVar2.type == 2) {
                    Iterator<n> it = this.DOH.DSf.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Util.isEqual(it.next().name, nVar2.name)) {
                                z2 = true;
                                break;
                            }
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (!z2) {
                        arrayList.add(nVar2);
                    }
                }
            }
        }
        if (!Util.isNullOrNil(arrayList)) {
            this.DOH.DSf.addAll(0, arrayList);
        }
        if (this.DOH.DSf.size() > 5) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.DOH.DSf);
            this.DOH.DSf.clear();
            this.DOH.DSf.addAll(arrayList2.subList(0, 5));
        }
        try {
            byte[] byteArray = this.DOH.toByteArray();
            s.f(DOF, byteArray, byteArray.length);
            AppMethodBeat.o(96012);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.UploadManager", e2, "listToFile failed: " + DOF, new Object[0]);
            s.deleteFile(DOF);
            AppMethodBeat.o(96012);
        }
    }

    public final String fau() {
        AppMethodBeat.i(96013);
        if (this.gna == null || this.gna.equals("")) {
            g.aAi();
            this.gna = (String) g.aAh().azQ().get(2, (Object) null);
        }
        String str = this.gna;
        AppMethodBeat.o(96013);
        return str;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(202795);
        this.listeners.add(aVar);
        int i2 = DGB + 1;
        DGB = i2;
        if (i2 > 1) {
            AppMethodBeat.o(202795);
        } else {
            AppMethodBeat.o(202795);
        }
    }

    public final void b(a aVar) {
        AppMethodBeat.i(202796);
        this.listeners.remove(aVar);
        int i2 = DGB - 1;
        DGB = i2;
        if (i2 > 0) {
            AppMethodBeat.o(202796);
        } else {
            AppMethodBeat.o(202796);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.sns.storage.SnsInfo r12, int r13, int r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 292
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.be.a(com.tencent.mm.plugin.sns.storage.SnsInfo, int, int, java.lang.String):void");
    }

    private void a(SnsInfo snsInfo, int i2, String str) {
        AppMethodBeat.i(96015);
        a(snsInfo, 0, i2, str);
        AppMethodBeat.o(96015);
    }

    public static int tN(int i2) {
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                return 5;
            default:
                return -1;
        }
    }

    @Override // com.tencent.mm.plugin.sns.b.m
    public final boolean jW(String str, String str2) {
        AppMethodBeat.i(96016);
        Log.d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
        s.nw(str, str3);
        bf bfVar = new bf(1);
        bfVar.aPw(str2);
        bfVar.YK(6);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new q(str3, 2));
        bfVar.gS(linkedList);
        if (bfVar.commit() > 0) {
            AppMethodBeat.o(96016);
            return true;
        }
        AppMethodBeat.o(96016);
        return false;
    }

    public static bf c(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i2;
        AppMethodBeat.i(96017);
        Log.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        Log.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        WXMediaMessage.IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i2 = 2;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 5;
                break;
            case 5:
            case 6:
                i2 = 3;
                break;
            case 7:
                i2 = 3;
                break;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                i2 = 42;
                break;
            default:
                i2 = -1;
                break;
        }
        bf bfVar = new bf(i2);
        bfVar.aPC(Util.nullAs(str2, "")).aPD(Util.nullAs(str3, ""));
        bfVar.YK(5);
        Log.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i2)));
        if (i2 == -1) {
            Log.d("MicroMsg.UploadManager", "timeLineType is invalid");
            AppMethodBeat.o(96017);
            return null;
        }
        if (!Util.isNullOrNil(str)) {
            bfVar.aPw(str);
        }
        bfVar.aPB(Util.nullAs(wXMediaMessage.title, "")).aPz(Util.nullAs(wXMediaMessage.description, ""));
        switch (iMediaObject.type()) {
            case 1:
                bfVar.aPz("");
                bfVar.aPw(((WXTextObject) iMediaObject).text);
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                if (!Util.isNullOrNil(wXImageObject.imageData)) {
                    if (!bfVar.b(wXImageObject.imageData, "", "")) {
                        AppMethodBeat.o(96017);
                        return null;
                    }
                } else if (Util.isNullOrNil(wXImageObject.imagePath)) {
                    Log.e("MicroMsg.UploadManager", "share img but no res is exist!");
                    AppMethodBeat.o(96017);
                    return null;
                } else if (!bfVar.kn(wXImageObject.imagePath, "")) {
                    AppMethodBeat.o(96017);
                    return null;
                }
                break;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String nullAs = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String nullAs2 = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                bfVar.aPB("").aPz("");
                int tN = tN(3);
                if (tN == -1) {
                    Log.d("MicroMsg.UploadManager", "mediaType is invalid");
                    AppMethodBeat.o(96017);
                    return null;
                }
                if (!bfVar.a(wXMediaMessage.thumbData, nullAs, Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), nullAs2, tN, Util.nullAs(wXMediaMessage.title, ""), Util.nullAs(wXMediaMessage.description, ""), wXMusicObject.songAlbumUrl, wXMusicObject.songLyric)) {
                    AppMethodBeat.o(96017);
                    return null;
                }
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                bfVar.aPB("").aPz("");
                int tN2 = tN(4);
                if (tN2 == -1) {
                    Log.d("MicroMsg.UploadManager", "mediaType is invalid");
                    AppMethodBeat.o(96017);
                    return null;
                }
                if (!bfVar.a(wXMediaMessage.thumbData, Util.nullAs(!Util.isNullOrNil(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, tN2, Util.nullAs(wXMediaMessage.title, ""), Util.nullAs(wXMediaMessage.description, ""), "", "")) {
                    AppMethodBeat.o(96017);
                    return null;
                }
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
                if (!Util.isNullOrNil(wXMediaMessage.thumbData)) {
                    bfVar.b(wXMediaMessage.thumbData, Util.nullAs(wXMediaMessage.description, ""), Util.nullAs(wXMediaMessage.title, ""));
                }
                bfVar.aPz(wXWebpageObject.webpageUrl).aPA(wXWebpageObject.webpageUrl);
                bfVar.DPd.ContentObj.Url = wXWebpageObject.webpageUrl;
                bfVar.aPy(wXWebpageObject.canvasPageXml);
                break;
            case 6:
                Log.e("MicroMsg.UploadManager", "file is not support!");
                AppMethodBeat.o(96017);
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
                if (!Util.isNullOrNil(wXAppExtendObject.filePath) && wXAppExtendObject.filePath.startsWith("http")) {
                    bfVar.aPB(wXAppExtendObject.filePath);
                    bfVar.aPz(wXAppExtendObject.filePath);
                    break;
                } else {
                    Log.e("MicroMsg.UploadManager", "appdata is not support!");
                    AppMethodBeat.o(96017);
                    return null;
                }
            default:
                Log.e("MicroMsg.UploadManager", "none type not support!");
                AppMethodBeat.o(96017);
                return null;
        }
        AppMethodBeat.o(96017);
        return bfVar;
    }

    @Override // com.tencent.mm.plugin.sns.b.m
    public final boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(96018);
        bf c2 = c(wXMediaMessage, str, str2, str3);
        if (c2 == null) {
            AppMethodBeat.o(96018);
            return false;
        }
        c2.aPx(wXMediaMessage.mediaTagName);
        c2.aO(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i2 > com.tencent.mm.plugin.sns.c.a.DCT) {
            c2.YF(1);
        }
        Log.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(c2.commit())));
        AppMethodBeat.o(96018);
        return true;
    }

    private boolean I(SnsInfo snsInfo) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(96019);
        if (snsInfo == null) {
            AppMethodBeat.o(96019);
            return false;
        }
        TimeLineObject timeLine = snsInfo.getTimeLine();
        if (timeLine.ContentObj.LoU == 8) {
            AppMethodBeat.o(96019);
            return true;
        } else if (timeLine.ContentObj.LoU == 2) {
            AppMethodBeat.o(96019);
            return true;
        } else {
            if (timeLine.ContentObj.LoU == 26) {
                hb hbVar = new hb();
                hbVar.dLm.type = 30;
                hbVar.dLm.dLt = 5;
                hbVar.dLm.desc = timeLine.ContentObj.LoX;
                hbVar.dLm.dLs = String.valueOf(snsInfo.localid);
                EventCenter.instance.publish(hbVar);
                if (hbVar.dLn.ret != 1) {
                    AppMethodBeat.o(96019);
                    return false;
                }
            }
            if (timeLine == null || timeLine.ContentObj.LoV == null) {
                a(snsInfo, 1, "timeline or timelineObjList is null");
                AppMethodBeat.o(96019);
                return false;
            } else if (timeLine.ContentObj.LoV.size() == 0) {
                AppMethodBeat.o(96019);
                return true;
            } else {
                try {
                    cnc cnc = (cnc) new cnc().parseFrom(snsInfo.getPostBuf());
                    if (timeLine.ContentObj.LoU != 1) {
                        z = true;
                    } else if (cnc.MsW.size() > 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (timeLine.ContentObj.LoU == 21) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if (timeLine.ContentObj.LoU == 15) {
                        Iterator<cjs> it = cnc.MsW.iterator();
                        while (it.hasNext()) {
                            cjs next = it.next();
                            b YE = YE(next.Mpj);
                            if (YE == b.STATE_ERROR) {
                                a(snsInfo, next.Mpj, 2, "upload has set it fail");
                                AppMethodBeat.o(96019);
                                return false;
                            } else if (YE == b.STATE_FALSE) {
                                AppMethodBeat.o(96019);
                                return false;
                            }
                        }
                        AppMethodBeat.o(96019);
                        return true;
                    }
                    Iterator<cjs> it2 = cnc.MsW.iterator();
                    while (it2.hasNext()) {
                        cjs next2 = it2.next();
                        b a2 = a(next2.Mpj, z2, cnc, timeLine.ContentObj.LoU);
                        if (a2 == b.STATE_ERROR) {
                            a(snsInfo, next2.Mpj, 2, "upload has set it fail");
                            AppMethodBeat.o(96019);
                            return false;
                        } else if (a2 == b.STATE_FALSE) {
                            AppMethodBeat.o(96019);
                            return false;
                        }
                    }
                    AppMethodBeat.o(96019);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + snsInfo.getLocalid());
                    a(snsInfo, 2, "mediaPostInfo parser error " + e2.getMessage());
                    AppMethodBeat.o(96019);
                    return false;
                }
            }
        }
    }

    public final void J(SnsInfo snsInfo) {
        cnc cnc;
        AppMethodBeat.i(96020);
        if (snsInfo == null) {
            AppMethodBeat.o(96020);
            return;
        }
        Log.i("MicroMsg.UploadManager", "cancel snsinfo " + snsInfo.getLocalid());
        try {
            cnc = (cnc) new cnc().parseFrom(snsInfo.getPostBuf());
        } catch (Exception e2) {
            Log.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + snsInfo.getLocalid());
            a(snsInfo, 2, "mediaPostInfo parser error " + e2.getMessage());
            cnc = null;
        }
        if (!(cnc == null || cnc.MsW == null)) {
            Iterator<cjs> it = cnc.MsW.iterator();
            while (it.hasNext()) {
                cjs next = it.next();
                int Yz = aj.faN().Yz(next.Mpj);
                aj.faN().Yy(next.Mpj);
                Log.i("MicroMsg.UploadManager", "cancel upload %d", Integer.valueOf(Yz));
                if (snsInfo.field_type != 15 && Yz >= 0) {
                    g.aAi();
                    g.aAg().hqi.cancel(Yz);
                    aj.faN().Yx(next.Mpj);
                }
            }
        }
        if (aj.faN().Yt(snsInfo.localid) && this.DOG != null) {
            Log.i("MicroMsg.UploadManager", "cancel post");
            this.DOG.gyp = true;
            g.aAi();
            g.aAg().hqi.a(this.DOG);
            aj.faN().Yv(snsInfo.localid);
        }
        SnsInfo Zr = aj.faO().Zr(snsInfo.localid);
        if (!(Zr == null || Zr.field_snsId == 0)) {
            aj.faN().Jr(Zr.field_snsId);
            g.aAi();
            g.aAg().hqi.a(new s(Zr.field_snsId, 1), 0);
        }
        aj.faO().Zs(snsInfo.localid);
        if (snsInfo.getTypeFlag() == 21) {
            com.tencent.mm.plugin.sns.lucky.a.g.eZK().eZM();
        }
        Log.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + snsInfo.getLocalid());
        vy vyVar = new vy();
        vyVar.ecb.ecc = (long) snsInfo.localid;
        EventCenter.instance.publish(vyVar);
        AppMethodBeat.o(96020);
    }

    @Override // com.tencent.mm.plugin.sns.b.m
    public final void eZn() {
        AppMethodBeat.i(96021);
        aj.dRd().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.be.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(96002);
                be.a(be.this);
                AppMethodBeat.o(96002);
            }
        }, 1000);
        AppMethodBeat.o(96021);
    }

    private boolean fbS() {
        AppMethodBeat.i(96022);
        String str = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.n.Emz + " order by SnsInfo.rowid asc ";
        Cursor rawQuery = aj.faO().iFy.rawQuery(str, null);
        Log.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(str)));
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        SnsInfo snsInfo = new SnsInfo();
        if (rawQuery == null) {
            AppMethodBeat.o(96022);
            return false;
        }
        rawQuery.moveToFirst();
        do {
            snsInfo.convertFrom(rawQuery);
            try {
                cnc cnc = (cnc) new cnc().parseFrom(snsInfo.getPostBuf());
                if (snsInfo.isTimeLimit(cnc.ibG, cnc.MsZ)) {
                    a(cnc);
                    a(snsInfo, 6, "snsinfo is tle");
                    Log.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + snsInfo.getLocalid() + " is die ");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                a(snsInfo, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        AppMethodBeat.o(96022);
        return true;
    }

    private static TimeLineObject a(SnsInfo snsInfo, cnc cnc) {
        int i2;
        AppMethodBeat.i(96023);
        TimeLineObject timeLine = snsInfo.getTimeLine();
        cjy cjy = timeLine.Location;
        String str = timeLine.ContentDesc;
        String str2 = timeLine.sourceUserName;
        String str3 = timeLine.sourceNickName;
        String str4 = timeLine.ContentObj.Desc;
        String str5 = timeLine.ContentObj.Title;
        String str6 = timeLine.ContentObj.Url;
        String str7 = timeLine.ContentObj.LoX;
        fa faVar = timeLine.AppInfo;
        eyd eyd = timeLine.weappInfo;
        cio cio = timeLine.liteappInfo;
        int i3 = timeLine.ContentObj.LoU;
        int i4 = timeLine.ContentObj.LoW;
        TimeLineObject bfM = com.tencent.mm.modelsns.n.bfM();
        bfM.UserName = snsInfo.getUserName();
        bfM.Privated = snsInfo.getPravited();
        bfM.ContentDesc = str;
        bfM.sourceUserName = Util.nullAsNil(str2);
        bfM.sourceNickName = Util.nullAsNil(str3);
        bfM.contentDescShowType = timeLine.contentDescShowType;
        bfM.contentDescScene = timeLine.contentDescScene;
        bfM.contentattr = timeLine.contentattr;
        bfM.statisticsData = timeLine.statisticsData;
        bfM.canvasInfo = timeLine.canvasInfo;
        bfM.ContentObj.Desc = str4;
        bfM.ContentObj.Title = str5;
        bfM.ContentObj.LoU = i3;
        bfM.ContentObj.LoW = i4;
        bfM.ContentObj.Url = str6;
        bfM.ContentObj.LoX = str7;
        bfM.ContentObj.dME = timeLine.ContentObj.dME;
        bfM.ContentObj.jfy = timeLine.ContentObj.jfy;
        bfM.ContentObj.LoZ = timeLine.ContentObj.LoZ;
        bfM.ContentObj.Lpe = timeLine.ContentObj.Lpe;
        bfM.ContentObj.Lpb = timeLine.ContentObj.Lpb;
        bfM.ContentObj.Lpa = timeLine.ContentObj.Lpa;
        bfM.ContentObj.Lpc = timeLine.ContentObj.Lpc;
        bfM.ContentObj.Lpd = timeLine.ContentObj.Lpd;
        bfM.Location = cjy;
        bfM.streamvideo = timeLine.streamvideo;
        bfM.statExtStr = timeLine.statExtStr;
        if (timeLine.actionInfo != null) {
            bfM.actionInfo = timeLine.actionInfo;
        }
        if (faVar != null) {
            bfM.AppInfo = faVar;
        }
        if (eyd != null) {
            bfM.weappInfo = eyd;
        }
        if (cio != null) {
            bfM.liteappInfo = cio;
        }
        Iterator<cnb> it = timeLine.ContentObj.LoV.iterator();
        while (it.hasNext()) {
            cnb next = it.next();
            if (next.MsE == 1) {
                bfM.ContentObj.LoV.add(next);
            }
        }
        if (timeLine.webSearchInfo != null) {
            bfM.webSearchInfo = timeLine.webSearchInfo;
        }
        ad.b G = com.tencent.mm.model.ad.aVe().G(cnc.sessionId, true);
        if (G.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE") && (i2 = G.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1)) != -1) {
            bfM.ContentObj.LoY = new cli();
            bfM.ContentObj.LoY.iAb = i2;
            bfM.ContentObj.LoY.iwf = G.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
            if (i2 == 5) {
                bfM.ContentObj.LoY.vid = G.getString("_DATA_CENTER_VID", "");
                bfM.ContentObj.LoY.iwd = G.getInt("_DATA_CENTER_PUB_TIME", 0);
                bfM.ContentObj.LoY.duration = G.getInt("_DATA_CENTER__DULATION", 0);
                bfM.ContentObj.LoY.desc = G.getString("_DATA_CENTER_DESC", "");
                bfM.ContentObj.LoY.coverUrl = G.getString("_DATA_CENTER_COVER_URL", "");
                bfM.ContentObj.LoY.videoWidth = G.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
                bfM.ContentObj.LoY.videoHeight = G.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
                bfM.ContentObj.LoY.iwg = G.getInt("_DATA_CENTER_FUNC_FLAG", 0);
            }
        }
        AppMethodBeat.o(96023);
        return bfM;
    }

    private boolean K(SnsInfo snsInfo) {
        final boolean z;
        cnb cnb;
        AppMethodBeat.i(96024);
        try {
            final cnc cnc = (cnc) new cnc().parseFrom(snsInfo.getPostBuf());
            cnc.ibG++;
            snsInfo.setPostBuf(cnc.toByteArray());
            aj.faO().d(snsInfo.localid, snsInfo);
            if (snsInfo.isTimeLimit(cnc.ibG, cnc.MsZ)) {
                a(snsInfo, 6, "this item isTimeLimit");
                Log.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + snsInfo.getLocalid() + " is die ");
                AppMethodBeat.o(96024);
                return false;
            }
            Log.i("MicroMsg.UploadManager", "try start post " + snsInfo.getLocalid());
            if (I(snsInfo)) {
                final TimeLineObject timeLine = snsInfo.getTimeLine();
                TimeLineObject a2 = a(snsInfo, cnc);
                int i2 = 0;
                while (true) {
                    if (i2 >= cnc.MsW.size()) {
                        break;
                    }
                    int i3 = cnc.MsW.get(i2).Mpj;
                    com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) i3);
                    if (JK == null) {
                        a(snsInfo, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(i3)));
                        AppMethodBeat.o(96024);
                        return false;
                    }
                    try {
                        cne cne = (cne) new cne().parseFrom(JK.EmR);
                        if (cne.Mtr == null || cne.Mtt.size() <= 0) {
                            Log.e("MicroMsg.UploadManager", "item with not url" + snsInfo.field_type);
                        } else {
                            String str = cne.Mtr.Url;
                            String str2 = cne.Mtt.get(0).Url;
                            int i4 = cne.Mtr.oUv;
                            int i5 = cne.Mtt.get(0).oUv;
                            String str3 = cne.md5;
                            cnd cnd = null;
                            if (i2 < timeLine.ContentObj.LoV.size()) {
                                cnd = timeLine.ContentObj.LoV.get(i2).MsB;
                            }
                            if (timeLine.ContentObj.LoU != 4 && timeLine.ContentObj.LoU != 42 && timeLine.ContentObj.LoU != 5) {
                                cnb = com.tencent.mm.modelsns.n.a(JK.EmQ, JK.type, str, str2, i4, i5, cne.Privated, "", cnd);
                            } else if (i2 < timeLine.ContentObj.LoV.size()) {
                                cnb cnb2 = timeLine.ContentObj.LoV.get(i2);
                                cnb2.Msz = str2;
                                cnb2.MsA = i5;
                                cnb = cnb2;
                            } else {
                                cnb = null;
                            }
                            if (cnb != null && a2.ContentObj.LoU == 1) {
                                cnb.md5 = str3;
                            }
                            if (cnb != null && a2.ContentObj.LoU == 15) {
                                cnb.md5 = cne.md5;
                                cnb.MsS = cne.MsS;
                            }
                            if (i2 < timeLine.ContentObj.LoV.size()) {
                                cnb cnb3 = timeLine.ContentObj.LoV.get(i2);
                                cnb.Title = cnb3.Title;
                                cnb.Desc = cnb3.Desc;
                                cnb.subType = cnb3.subType;
                                cnb.EpK = cnb3.EpK;
                                cnb.MsT = cnb3.MsT;
                            }
                            if (cnb == null) {
                                a(snsInfo, 3, "make media error");
                                AppMethodBeat.o(96024);
                                return false;
                            }
                            a2.ContentObj.LoV.add(cnb);
                            i2++;
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        a(snsInfo, 2, "mediaUploadInfo parser error " + e2.getMessage());
                        AppMethodBeat.o(96024);
                        return false;
                    }
                }
                Log.e("MicroMsg.UploadManager", "item with not url" + snsInfo.field_type);
                if (snsInfo.field_type != 3) {
                    a(snsInfo, 4, "buf url is null");
                    AppMethodBeat.o(96024);
                    return false;
                }
                if (!aj.faN().Yu(snsInfo.localid)) {
                    Log.d("MicroMsg.UploadManager", "this snsinfo is posting");
                    AppMethodBeat.o(96024);
                    return false;
                }
                final LinkedList linkedList = new LinkedList();
                Iterator<ebm> it = cnc.MsX.iterator();
                while (it.hasNext()) {
                    linkedList.add(it.next().UserName);
                }
                final String e3 = o.e(a2);
                Log.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + a2.contentDescScene + " contentDescShowType: " + a2.contentDescShowType);
                if (snsInfo.field_pravited == 1) {
                    Log.i("MicroMsg.UploadManager", "content private xml is null ? " + Util.isNullOrNil(e3));
                } else {
                    Log.i("MicroMsg.UploadManager", "upload xmlsns: %s", e3);
                }
                if (e3 == null || e3.equals("")) {
                    a(snsInfo, 5, "content is error");
                    aj.faN().Yv(snsInfo.localid);
                    AppMethodBeat.o(96024);
                    return false;
                }
                if (cnc.Mtf == 1) {
                    z = true;
                } else {
                    z = false;
                }
                final int i6 = snsInfo.localid;
                final LinkedList<dqi> linkedList2 = cnc.GroupUser;
                final com.tencent.mm.bw.b bVar = a2.Location.Mpw;
                final String str4 = a2.ContentObj.Title;
                aj.dRd().post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.be.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(96005);
                        if (aj.isInValid()) {
                            Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                            AppMethodBeat.o(96005);
                            return;
                        }
                        int i2 = 1;
                        String str = "";
                        if (cnc.Mtn != null) {
                            i2 = cnc.Mtn.KIF;
                            str = cnc.Mtn.xuk;
                        }
                        be.this.DOG = new t(e3, cnc.Privated, cnc.MsV, linkedList, timeLine, i6, cnc.izX, cnc.Mta, cnc.Mtb, cnc.Mtc, cnc, z, linkedList2, cnc.Mtg, bVar, str4, i2, str);
                        g.aAi();
                        g.aAg().hqi.a(be.this.DOG, 0);
                        AppMethodBeat.o(96005);
                    }
                });
            }
            Log.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + snsInfo.getLocalid());
            AppMethodBeat.o(96024);
            return true;
        } catch (Exception e4) {
            Log.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            a(snsInfo, 2, "MediaPostInfo parser error:" + e4.getMessage());
            AppMethodBeat.o(96024);
            return false;
        }
    }

    private void aR(final int i2, final boolean z) {
        AppMethodBeat.i(96025);
        aj.dRd().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.be.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(96004);
                if (aj.isInValid()) {
                    Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                    AppMethodBeat.o(96004);
                    return;
                }
                for (a aVar : be.this.listeners) {
                    if (aVar != null) {
                        aVar.aP(i2, z);
                    }
                }
                AppMethodBeat.o(96004);
            }
        });
        AppMethodBeat.o(96025);
    }

    private b a(final int i2, final boolean z, final cnc cnc, final int i3) {
        AppMethodBeat.i(96026);
        if (i2 == -1) {
            Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            b bVar = b.STATE_ERROR;
            AppMethodBeat.o(96026);
            return bVar;
        }
        com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) i2);
        try {
            cne cne = (cne) new cne().parseFrom(JK.EmR);
            Log.i("MicroMsg.UploadManager", "state " + cne.Mpa + " pic isMuti: " + z);
            if (cne.Mpa == 1) {
                b bVar2 = b.STATE_ERROR;
                AppMethodBeat.o(96026);
                return bVar2;
            }
            String str = ar.ki(aj.getAccSnsPath(), JK.EmN) + r.aOj(JK.EmN);
            if (s.boW(str) == 0) {
                Log.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
                b bVar3 = b.STATE_ERROR;
                AppMethodBeat.o(96026);
                return bVar3;
            } else if (cne.Mpa == 0) {
                b bVar4 = b.STATE_OK;
                AppMethodBeat.o(96026);
                return bVar4;
            } else {
                if (aj.faN().Yw(i2)) {
                    aj.faD().a(i2, JK);
                    final String messageDigest = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + " " + System.currentTimeMillis()).getBytes());
                    aj.dRd().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.model.be.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(96006);
                            if (aj.isInValid()) {
                                Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                AppMethodBeat.o(96006);
                                return;
                            }
                            aa aaVar = new aa(i2, messageDigest, z, i3);
                            aj.faN().iv(i2, aaVar.hashCode());
                            g.aAi();
                            g.aAg().hqi.a(aaVar, 0);
                            AppMethodBeat.o(96006);
                        }
                    });
                }
                b bVar5 = b.STATE_FALSE;
                AppMethodBeat.o(96026);
                return bVar5;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.UploadManager", "parse uploadInfo error");
            b bVar6 = b.STATE_ERROR;
            AppMethodBeat.o(96026);
            return bVar6;
        }
    }

    private static void a(cnc cnc) {
        AppMethodBeat.i(96027);
        if (cnc == null) {
            AppMethodBeat.o(96027);
            return;
        }
        Iterator<cjs> it = cnc.MsW.iterator();
        while (it.hasNext()) {
            aj.faN().Yx(it.next().Mpj);
        }
        AppMethodBeat.o(96027);
    }

    private b YE(int i2) {
        AppMethodBeat.i(96028);
        if (i2 == -1) {
            Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            b bVar = b.STATE_ERROR;
            AppMethodBeat.o(96028);
            return bVar;
        }
        com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) i2);
        try {
            cne cne = (cne) new cne().parseFrom(JK.EmR);
            Log.i("MicroMsg.UploadManager", "state " + cne.Mpa + " doUploadSight, serverErr:" + cne.Mtd);
            if (cne.Mpa == 1) {
                b bVar2 = b.STATE_ERROR;
                AppMethodBeat.o(96028);
                return bVar2;
            } else if (s.boW(cne.videoPath) == 0) {
                Log.i("MicroMsg.UploadManager", "path not fileexist  " + cne.videoPath);
                b bVar3 = b.STATE_ERROR;
                AppMethodBeat.o(96028);
                return bVar3;
            } else if (s.boW(cne.Mtv) == 0) {
                Log.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + cne.Mtv);
                b bVar4 = b.STATE_ERROR;
                AppMethodBeat.o(96028);
                return bVar4;
            } else if (cne.Mpa == 0) {
                b bVar5 = b.STATE_OK;
                AppMethodBeat.o(96028);
                return bVar5;
            } else {
                if (aj.faN().Yw(i2)) {
                    aj.faD().a(i2, JK);
                    new ad(i2, JK, cne.videoPath, cne.Mtv, this.DOI).aPf(cne.dNI);
                }
                b bVar6 = b.STATE_FALSE;
                AppMethodBeat.o(96028);
                return bVar6;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            b bVar7 = b.STATE_ERROR;
            AppMethodBeat.o(96028);
            return bVar7;
        }
    }

    public final void fbT() {
        AppMethodBeat.i(96029);
        for (a aVar : this.listeners) {
            if (aVar != null) {
                aVar.fbl();
            }
        }
        AppMethodBeat.o(96029);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(96030);
        Log.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType() + " @" + hashCode());
        switch (qVar.getType()) {
            case 207:
                if (!(i2 == 0 && i3 == 0)) {
                    eZn();
                    break;
                }
            case 209:
                t tVar = (t) qVar;
                int i4 = tVar.ecf;
                if (tVar.gyp) {
                    long j2 = tVar.Dyz;
                    Log.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(j2)), Integer.valueOf(i4));
                    if (j2 != 0) {
                        aj.faN().Jr(j2);
                        g.aAi();
                        g.aAg().hqi.a(new s(j2, 1), 0);
                    }
                    aj.faO().Zs(i4);
                    if (j2 != 0) {
                        aj.faT().JI(j2);
                        com.tencent.mm.plugin.sns.storage.g.JH(j2);
                    }
                }
                if (i2 == 0 && i3 == 0) {
                    aR(tVar.ecf, true);
                    ao.report(tVar.Dyz);
                } else {
                    aR(tVar.ecf, false);
                }
                this.DOG = null;
                break;
        }
        if (i2 == 0 && i3 == 0) {
            AppMethodBeat.o(96030);
        } else {
            AppMethodBeat.o(96030);
        }
    }

    static /* synthetic */ void a(be beVar) {
        AppMethodBeat.i(96031);
        if (aj.eJP() != null) {
            if (!aj.isInValid()) {
                g.aAi();
                if (g.aAh().isSDCardAvailable()) {
                    aj.eJP().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.model.be.AnonymousClass2 */

                        public final void run() {
                            SnsInfo snsInfo = null;
                            AppMethodBeat.i(96003);
                            if (aj.isInValid()) {
                                Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                AppMethodBeat.o(96003);
                                return;
                            }
                            be.b(be.this);
                            if (aj.isInValid()) {
                                Log.e("MicroMsg.UploadManager", "is invalid after checkTLE");
                                AppMethodBeat.o(96003);
                                return;
                            }
                            com.tencent.mm.plugin.sns.storage.n faO = aj.faO();
                            SnsInfo snsInfo2 = new SnsInfo();
                            String str = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.n.Emz + " order by SnsInfo.rowid asc ";
                            Cursor rawQuery = faO.iFy.rawQuery(str, null, 2);
                            Log.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(str)));
                            if (!rawQuery.moveToFirst()) {
                                rawQuery.close();
                            } else {
                                snsInfo2.convertFrom(rawQuery);
                                rawQuery.close();
                                snsInfo = snsInfo2;
                            }
                            if (snsInfo == null) {
                                Log.d("MicroMsg.UploadManager", "All has post");
                                AppMethodBeat.o(96003);
                            } else if (aj.faN().Yt(snsInfo.localid)) {
                                Log.d("MicroMsg.UploadManager", "checking isPosting " + snsInfo.localid);
                                AppMethodBeat.o(96003);
                            } else {
                                Log.d("MicroMsg.UploadManager", "checking startPost " + snsInfo.getLocalid());
                                be.a(be.this, snsInfo);
                                AppMethodBeat.o(96003);
                            }
                        }
                    });
                }
            }
            AppMethodBeat.o(96031);
            return;
        }
        AppMethodBeat.o(96031);
    }
}
