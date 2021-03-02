package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;
import java.util.HashMap;

public final class a {
    public String appUserName;
    private HashMap<String, IListener> bGH;
    public String brandName;
    public int dMe;
    public String ncY;
    public String ncZ;
    public f nda;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        AppMethodBeat.i(145817);
        this.bGH = new HashMap<>();
        AppMethodBeat.o(145817);
    }

    public final boolean es(String str, String str2) {
        f bef;
        AppMethodBeat.i(145818);
        if (str2.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
            Log.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", str, this.ncY);
            AppMethodBeat.o(145818);
            return true;
        } else if (!str.equalsIgnoreCase(this.ncY) || (bef = com.tencent.mm.ay.a.bef()) == null || !bef.jeV.equals(this.ncZ)) {
            AppMethodBeat.o(145818);
            return false;
        } else {
            AppMethodBeat.o(145818);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.music.a$a */
    public static class C0751a {
        private static a ndb = new a((byte) 0);

        static {
            AppMethodBeat.i(145816);
            AppMethodBeat.o(145816);
        }
    }

    public final void a(IListener iListener, String str) {
        AppMethodBeat.i(145819);
        if (this.bGH.get(str) != null) {
            Log.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", str);
            AppMethodBeat.o(145819);
            return;
        }
        EventCenter.instance.addListener(iListener);
        this.bGH.put(str, iListener);
        AppMethodBeat.o(145819);
    }

    public final void acD(String str) {
        AppMethodBeat.i(145820);
        if (this.bGH.get(str) == null) {
            Log.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", str);
            AppMethodBeat.o(145820);
            return;
        }
        EventCenter.instance.removeListener(this.bGH.remove(str));
        this.bGH.remove(str);
        AppMethodBeat.o(145820);
    }

    public final boolean acE(String str) {
        AppMethodBeat.i(145821);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            AppMethodBeat.o(145821);
            return false;
        } else if (!str.equalsIgnoreCase(this.ncY)) {
            Log.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            AppMethodBeat.o(145821);
            return false;
        } else if (TextUtils.isEmpty(this.ncZ)) {
            Log.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            AppMethodBeat.o(145821);
            return false;
        } else {
            f bef = com.tencent.mm.ay.a.bef();
            if (bef == null) {
                Log.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                AppMethodBeat.o(145821);
                return false;
            } else if (!this.ncZ.equalsIgnoreCase(bef.jeV)) {
                Log.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                AppMethodBeat.o(145821);
                return false;
            } else if (!com.tencent.mm.ay.a.bec()) {
                Log.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
                AppMethodBeat.o(145821);
                return false;
            } else {
                AppMethodBeat.o(145821);
                return true;
            }
        }
    }
}
