package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.aj;
import com.tencent.mm.plugin.game.protobuf.an;
import com.tencent.mm.plugin.game.protobuf.bb;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.protobuf.d;
import com.tencent.mm.plugin.game.protobuf.dj;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.mm.plugin.game.protobuf.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static GetGameCenterGlobalSettingResponse xvl;

    public static String dSR() {
        AppMethodBeat.i(256607);
        String str = b.dTg() + "globalconfig";
        AppMethodBeat.o(256607);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e A[SYNTHETIC, Splitter:B:15:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void dSS() {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.commlib.a.dSS():void");
    }

    public static an dST() {
        AppMethodBeat.i(149392);
        an anVar = null;
        if (xvl != null) {
            anVar = xvl.GameDetailSetting;
            if (anVar != null) {
                Log.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(anVar.xJa), anVar.xIy);
            }
        } else {
            dSS();
        }
        AppMethodBeat.o(149392);
        return anVar;
    }

    public static dv dSU() {
        AppMethodBeat.i(149393);
        if (xvl != null) {
            if (xvl.StatusBarStyle != null) {
                Log.i("MicroMsg.GameConfigManager", "getStatusBarStyle color:%s, darkModeColor:%s, style:%s", xvl.StatusBarStyle.ixw, xvl.StatusBarStyle.xNo, xvl.StatusBarStyle.xHA);
            }
            dv dvVar = xvl.StatusBarStyle;
            AppMethodBeat.o(149393);
            return dvVar;
        }
        dSS();
        AppMethodBeat.o(149393);
        return null;
    }

    public static boolean dSV() {
        AppMethodBeat.i(149394);
        if (xvl == null) {
            dSS();
        } else if (xvl.WepkgControl != null) {
            boolean z = xvl.WepkgControl.xNL;
            AppMethodBeat.o(149394);
            return z;
        }
        AppMethodBeat.o(149394);
        return false;
    }

    public static List<String> dSW() {
        AppMethodBeat.i(149397);
        if (xvl == null) {
            dSS();
        } else if (xvl.WepkgControl != null) {
            LinkedList<dj> linkedList = xvl.WepkgControl.xNN;
            if (!Util.isNullOrNil(linkedList)) {
                ArrayList arrayList = new ArrayList();
                for (dj djVar : linkedList) {
                    if (djVar != null && !Util.isNullOrNil(djVar.xJD)) {
                        arrayList.add(djVar.xJD);
                    }
                }
                AppMethodBeat.o(149397);
                return arrayList;
            }
        }
        AppMethodBeat.o(149397);
        return null;
    }

    public static int dSX() {
        AppMethodBeat.i(149398);
        if (xvl == null) {
            dSS();
            AppMethodBeat.o(149398);
            return LocalCache.TIME_HOUR;
        } else if (xvl.WebViewControl != null) {
            int i2 = xvl.WebViewControl.xNK;
            AppMethodBeat.o(149398);
            return i2;
        } else {
            AppMethodBeat.o(149398);
            return LocalCache.TIME_HOUR;
        }
    }

    public static bb dSY() {
        AppMethodBeat.i(256608);
        if (xvl == null) {
            dSS();
        } else if (xvl.GameLifeSetting != null) {
            bb bbVar = xvl.GameLifeSetting;
            AppMethodBeat.o(256608);
            return bbVar;
        }
        AppMethodBeat.o(256608);
        return null;
    }

    public static k dSZ() {
        AppMethodBeat.i(256609);
        if (xvl == null) {
            dSS();
        } else if (xvl.GameLifeSetting != null) {
            k kVar = xvl.GameLifeSetting.xLc;
            AppMethodBeat.o(256609);
            return kVar;
        }
        AppMethodBeat.o(256609);
        return null;
    }

    public static z dTa() {
        AppMethodBeat.i(256610);
        if (xvl == null) {
            dSS();
        } else if (xvl.GameLifeSetting != null) {
            z zVar = xvl.GameLifeSetting.xLd;
            AppMethodBeat.o(256610);
            return zVar;
        }
        AppMethodBeat.o(256610);
        return null;
    }

    public static bh dTb() {
        AppMethodBeat.i(256611);
        if (xvl != null) {
            bh bhVar = xvl.GeneralJumpInfo;
            AppMethodBeat.o(256611);
            return bhVar;
        }
        dSS();
        AppMethodBeat.o(256611);
        return null;
    }

    public static JSONArray dTc() {
        aj ajVar;
        AppMethodBeat.i(256612);
        JSONArray jSONArray = new JSONArray();
        if (xvl != null) {
            ajVar = xvl.GameCommunityInfo;
        } else {
            dSS();
            ajVar = null;
        }
        if (!(ajVar == null || ajVar.xKi == null)) {
            Iterator<d> it = ajVar.xKi.iterator();
            while (it.hasNext()) {
                d next = it.next();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appId", next.jfi);
                    jSONObject.put("gameName", next.xIC);
                    jSONObject.put("albumName", next.xID);
                    jSONObject.put("defaultTitle", next.xIE);
                } catch (JSONException e2) {
                }
                jSONArray.put(jSONObject);
            }
        }
        AppMethodBeat.o(256612);
        return jSONArray;
    }
}
