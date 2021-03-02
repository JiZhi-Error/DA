package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.w;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public class PhotoEditProxy extends a {
    public PhotoEditProxy(d dVar) {
        super(dVar);
    }

    public int doFav(String str) {
        AppMethodBeat.i(103236);
        int intValue = ((Integer) REMOTE_CALL("doFavInMM", str)).intValue();
        AppMethodBeat.o(103236);
        return intValue;
    }

    public void sendImage(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(103237);
        REMOTE_CALL("sendImageInMM", str, str2, str3, str4);
        AppMethodBeat.o(103237);
    }

    public boolean isAutoSave() {
        AppMethodBeat.i(103238);
        boolean booleanValue = ((Boolean) REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
        AppMethodBeat.o(103238);
        return booleanValue;
    }

    public String getSelfUsername() {
        AppMethodBeat.i(103239);
        String str = (String) REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
        AppMethodBeat.o(103239);
        return str;
    }

    public String getFullPath(String str) {
        AppMethodBeat.i(103240);
        String str2 = (String) REMOTE_CALL("getFullPathInMM", str);
        AppMethodBeat.o(103240);
        return str2;
    }

    public void recordImage(String str, String str2, long j2, String str3, String str4) {
        AppMethodBeat.i(103241);
        REMOTE_CALL("recordImageInMM", str, str2, Long.valueOf(j2), str3, str4);
        AppMethodBeat.o(103241);
    }

    public void recordVideo(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(103242);
        REMOTE_CALL("recordVideoInMM", str, str2, str3, str4);
        AppMethodBeat.o(103242);
    }

    @f
    public void sendImageInMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(103243);
        o.e tc = o.a(o.d.jdL).tc(4);
        tc.dRL = z.aTY();
        tc.toUser = str4;
        tc.iZt = str2;
        tc.iXp = 0;
        tc.jdS = null;
        tc.dQd = 0;
        tc.iXy = "";
        tc.thumbPath = "";
        tc.jdV = true;
        tc.jdU = R.drawable.c3h;
        tc.jdR = 11;
        tc.bdQ().execute();
        g.eir().iF(str, str4);
        AppMethodBeat.o(103243);
    }

    @f
    public String getSelfUsernameInMM() {
        AppMethodBeat.i(103244);
        String aTY = z.aTY();
        AppMethodBeat.o(103244);
        return aTY;
    }

    @f
    public boolean isAutoSavePhotoInMM() {
        AppMethodBeat.i(103245);
        boolean z = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        AppMethodBeat.o(103245);
        return z;
    }

    @f
    public int doFavInMM(String str) {
        AppMethodBeat.i(103246);
        cz czVar = new cz();
        ((ad) com.tencent.mm.kernel.g.af(ad.class)).a(czVar, 2, str);
        czVar.dFZ.dGf = 44;
        EventCenter.instance.publish(czVar);
        Log.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", str);
        int i2 = czVar.dGa.ret;
        AppMethodBeat.o(103246);
        return i2;
    }

    @f
    public String getFullPathInMM(String str) {
        AppMethodBeat.i(103247);
        String fullPath = q.bcR().getFullPath(str);
        AppMethodBeat.o(103247);
        return fullPath;
    }

    @f
    public void recordImageInMM(String str, String str2, long j2, String str3, String str4) {
        AppMethodBeat.i(103248);
        ((w) com.tencent.mm.kernel.g.af(w.class)).recordImage(str, str2, j2, str3, str4);
        AppMethodBeat.o(103248);
    }

    @f
    public void recordVideoInMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(103249);
        ((w) com.tencent.mm.kernel.g.af(w.class)).recordVideo(str, str2, str3, str4);
        AppMethodBeat.o(103249);
    }
}
