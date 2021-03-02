package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    public String DQS = "";
    public String DQT = "";
    public String DRG = "";
    public int[] DRH;
    public int DRt = 0;
    public List<a> DRu = new ArrayList();
    public boolean dGX = true;
    public String yFy = "";

    public h() {
        AppMethodBeat.i(96140);
        AppMethodBeat.o(96140);
    }

    public final boolean fcq() {
        AppMethodBeat.i(96141);
        if (!this.dGX || this.DRu == null || this.DRu.size() <= 0) {
            AppMethodBeat.o(96141);
            return false;
        }
        AppMethodBeat.o(96141);
        return true;
    }

    public final boolean f(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(96142);
        this.DQT = str;
        this.DQS = str2;
        if (map == null) {
            AppMethodBeat.o(96142);
        } else {
            try {
                this.DRu.clear();
                this.yFy = Util.nullAs(map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                this.DRG = Util.nullAs(map.get("first_step_order"), "");
                String[] split = this.DRG.split("\\|");
                this.DRH = new int[split.length];
                if (this.DRH.length == 0) {
                    this.dGX = false;
                }
                for (int i2 = 0; i2 < split.length; i2++) {
                    this.DRH[i2] = Util.safeParseInt(split[i2]);
                    if (this.DRH[i2] <= 0 || this.DRH[i2] > 3) {
                        this.dGX = false;
                    }
                }
                int safeParseInt = Util.safeParseInt(map.get("wording_count"));
                int safeParseInt2 = Util.safeParseInt(map.get("expertype"));
                for (int i3 = 0; i3 < safeParseInt; i3++) {
                    a aVar = new a();
                    aVar.DQm = Util.safeParseInt(map.get(String.format("wording_%d_id", Integer.valueOf(i3 + 1))));
                    aVar.DQn = Util.nullAs(map.get(String.format("wording_%d_zh_CN", Integer.valueOf(i3 + 1))), "");
                    aVar.DQo = Util.nullAs(map.get(String.format("wording_%d_zh_TW", Integer.valueOf(i3 + 1))), "");
                    aVar.DQp = Util.nullAs(map.get(String.format("wording_%d_en", Integer.valueOf(i3 + 1))), "");
                    aVar.DQq = Util.safeParseInt(map.get(String.format("wording_%d_action_type", Integer.valueOf(i3 + 1))));
                    this.DRu.add(aVar);
                }
                Log.i("MicroMsg.SnsAdAbTestInfo", "expertType " + safeParseInt2 + " " + str + " " + this.DRG);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", e2, "feed xml error ", new Object[0]);
            }
            AppMethodBeat.o(96142);
        }
        return false;
    }
}
