package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class e {
    public String DrT;
    public float DrU;
    public String DrV;
    public String DrW;
    public String desc;
    public cnb ebR;
    private int mediaType;
    public String nickname;
    public String tag;
    public String uNR;

    public static e z(Map<String, String> map, String str) {
        AppMethodBeat.i(201855);
        if (c.isEmpty(map)) {
            AppMethodBeat.o(201855);
            return null;
        } else if (TextUtils.isEmpty(Util.nullAsNil(map.get(str + ".media.id")))) {
            AppMethodBeat.o(201855);
            return null;
        } else {
            try {
                e eVar = new e();
                eVar.uNR = Util.nullAsNil(map.get(str + ".avatar"));
                eVar.nickname = Util.nullAsNil(map.get(str + ".nickname"));
                eVar.tag = Util.nullAsNil(map.get(str + ".tag"));
                eVar.desc = Util.nullAsNil(map.get(str + ".desc"));
                eVar.DrT = Util.nullAsNil(map.get(str + ".barBgColor"));
                eVar.DrU = Util.safeParseFloat(map.get(str + ".barBgAlpha"));
                eVar.DrV = Util.nullAsNil(map.get(str + ".duration"));
                String str2 = str + ".media";
                cnb cnb = new cnb();
                cnb.Id = Util.nullAsNil(map.get(str2 + ".id"));
                cnb.isAd = true;
                cnb.oUv = Util.safeParseInt(map.get(str2 + ".type"));
                cnb.subType = Util.safeParseInt(map.get(str2 + ".subtype"));
                cnb.Url = Util.nullAsNil(map.get(str2 + ".url"));
                cnb.Mcw = Util.safeParseInt(map.get(str2 + ".url.$type"));
                cnb.MsG = Util.nullAsNil(map.get(str2 + ".url.$md5"));
                cnb.Msz = Util.nullAsNil(map.get(str2 + ".thumb"));
                cnb.MsA = Util.safeParseInt(map.get(str2 + ".thumb.$type"));
                cnb.MsB = new cnd();
                cnb.MsB.Mtp = (float) Util.safeParseInt(map.get(str2 + ".size.$height"));
                cnb.MsB.Mto = (float) Util.safeParseInt(map.get(str2 + ".size.$width"));
                cnb.MsB.Mtq = (float) Util.safeParseInt(map.get(str2 + ".size.$totalSize"));
                eVar.ebR = cnb;
                eVar.mediaType = eVar.ebR.oUv == 6 ? 1 : 0;
                eVar.DrW = Util.nullAsNil(map.get(str + ".finderType"));
                AppMethodBeat.o(201855);
                return eVar;
            } catch (Throwable th) {
                Log.e("AdFinderTopicResInfo", "parse AdFinderTopicResInfo error " + th.getMessage());
                AppMethodBeat.o(201855);
                return null;
            }
        }
    }

    public final boolean eWB() {
        return this.mediaType == 1;
    }
}
