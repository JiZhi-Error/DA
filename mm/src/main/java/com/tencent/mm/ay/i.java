package com.tencent.mm.ay;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.i.a.al;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Util;

public final class i extends g {
    public static f a(String str, TimeLineObject timeLineObject, int i2, h hVar) {
        String str2 = null;
        AppMethodBeat.i(192717);
        if (timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV == null || timeLineObject.ContentObj.LoV.size() <= 0) {
            AppMethodBeat.o(192717);
            return null;
        }
        cnb cnb = timeLineObject.ContentObj.LoV.get(0);
        if (cnb == null) {
            AppMethodBeat.o(192717);
            return null;
        }
        f fVar = new f();
        fVar.jeT = i2;
        fVar.jeV = timeLineObject.Id;
        fVar.jeW = 0.0f;
        fVar.jeZ = "";
        if (!TextUtils.isEmpty(cnb.songAlbumUrl)) {
            fVar.jfm = cnb.songAlbumUrl;
        }
        fVar.jfa = cnb.Msz;
        fVar.jff = null;
        fVar.jeU = 1;
        fVar.jfe = cnb.songLyric;
        fVar.jeX = cnb.Title;
        if (timeLineObject.ContentObj.jfy == null || Util.isNullOrNil(timeLineObject.ContentObj.jfy.singerName)) {
            fVar.jeY = cnb.Desc;
        } else {
            fVar.jeY = timeLineObject.ContentObj.jfy.singerName;
        }
        if (timeLineObject.ContentObj != null) {
            str2 = timeLineObject.ContentObj.Url;
        }
        fVar.jfd = str2;
        fVar.jfc = cnb.MsC;
        fVar.jfb = cnb.Url;
        fVar.jfj = cnb.MsA;
        fVar.jfl = cnb.Id;
        fVar.jfg = str;
        fVar.jfi = timeLineObject.AppInfo.Id;
        fVar.jfp = timeLineObject.UserName;
        fVar.jfw = timeLineObject.Id;
        fVar.jfx = true;
        a(fVar, hVar);
        AppMethodBeat.o(192717);
        return fVar;
    }

    public static f a(k.b bVar, String str, String str2, String str3, String str4, h hVar) {
        AppMethodBeat.i(192718);
        if (bVar == null) {
            AppMethodBeat.o(192718);
            return null;
        }
        f fVar = new f();
        fVar.jeT = 0;
        fVar.jeV = str;
        fVar.jeW = 0.0f;
        fVar.jeZ = "";
        fVar.jfa = str2;
        fVar.jff = str4;
        fVar.jeU = 1;
        b bVar2 = (b) bVar.as(b.class);
        if (bVar2 == null || TextUtils.isEmpty(bVar2.songLyric)) {
            fVar.jfe = null;
        } else {
            fVar.jfe = bVar2.songLyric;
            fVar.jfm = bVar2.songAlbumUrl;
        }
        if (bVar2 == null || Util.isNullOrNil(bVar2.Ktr)) {
            fVar.jeY = bVar.description;
        } else {
            fVar.jeY = bVar2.Ktr;
        }
        fVar.jeX = bVar.title;
        fVar.jfd = bVar.url;
        fVar.jfc = !Util.isNullOrNil(bVar.ixe) ? bVar.ixe : bVar.iwH;
        fVar.jfb = bVar.ixd;
        fVar.jfi = bVar.appId;
        fVar.jfg = str3;
        a(fVar, hVar);
        AppMethodBeat.o(192718);
        return fVar;
    }

    public static f a(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, h hVar) {
        String str12;
        AppMethodBeat.i(192719);
        if (hVar == null || hVar.jfy == null || Util.isNullOrNil(hVar.jfy.singerName)) {
            str12 = str3;
        } else {
            str12 = hVar.jfy.singerName;
        }
        f a2 = a(i2, str, str2, str12, str4, str5, str6, str7, str8, str9, str10, str11);
        a(a2, hVar);
        AppMethodBeat.o(192719);
        return a2;
    }

    private static void a(f fVar, h hVar) {
        boolean z = true;
        AppMethodBeat.i(192720);
        a aVar = a.qCo;
        if (a.akQ(fVar.jfi)) {
            fVar.jfx = true;
        } else if (hVar != null) {
            if (al.b(hVar.jfy)) {
                z = false;
            }
            fVar.jfx = z;
        } else {
            fVar.jfx = false;
        }
        ((com.tencent.mm.ay.a.b) g.af(com.tencent.mm.ay.a.b.class)).a(fVar, hVar);
        AppMethodBeat.o(192720);
    }
}
