package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public String DQS = "";
    public String DQT = "";
    public int DRt = 0;
    public List<b> DRu = new ArrayList();
    public boolean dGX = true;
    public String yFy = "";

    public d() {
        AppMethodBeat.i(96130);
        AppMethodBeat.o(96130);
    }

    public final boolean f(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(96131);
        this.DQT = str;
        this.DQS = str2;
        if (map == null) {
            AppMethodBeat.o(96131);
            return false;
        }
        try {
            this.DRu.clear();
            this.yFy = Util.nullAs(map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
            if (!this.yFy.equals("zh_cn")) {
                this.dGX = false;
            }
            int safeParseInt = Util.safeParseInt(map.get("tipcount"));
            int safeParseInt2 = Util.safeParseInt(map.get("expertype"));
            for (int i2 = 0; i2 < safeParseInt; i2++) {
                b bVar = new b();
                bVar.title = Util.nullAs(map.get(String.format("tip_%d_basetextformat", Integer.valueOf(i2))), "");
                bVar.DRy = Util.safeParseInt(map.get(String.format("tip_%d_id", Integer.valueOf(i2))));
                bVar.dDG = Util.safeParseInt(map.get(String.format("tip_%d_showtype", Integer.valueOf(i2))));
                int safeParseInt3 = Util.safeParseInt(map.get(String.format("tip_%d_button_count", Integer.valueOf(i2))));
                if (bVar.dDG >= 6) {
                    this.dGX = false;
                }
                for (int i3 = 0; i3 < safeParseInt3; i3++) {
                    a aVar = new a();
                    aVar.index = Util.safeParseInt(map.get(String.format("tip_%d_button_%d_index", Integer.valueOf(i2), Integer.valueOf(i3))));
                    aVar.actionType = Util.safeParseInt(map.get(String.format("tip_%d_button_%d_actiontype", Integer.valueOf(i2), Integer.valueOf(i3))));
                    aVar.DRv = Util.nullAs(map.get(String.format("tip_%d_button_%d_basetextformat", Integer.valueOf(i2), Integer.valueOf(i3))), "");
                    aVar.jumpUrl = Util.nullAs(map.get(String.format("tip_%d_button_%d_jumpurl", Integer.valueOf(i2), Integer.valueOf(i3))), "");
                    aVar.DRw = Util.nullAs(map.get(String.format("tip_%d_button_%d_priortextformat", Integer.valueOf(i2), Integer.valueOf(i3))), "");
                    aVar.DRx = Util.safeParseInt(map.get(String.format("tip_%d_button_%d_nexttipviewid", Integer.valueOf(i2), Integer.valueOf(i3))));
                    if (aVar.actionType >= 9) {
                        this.dGX = false;
                    }
                    bVar.lgB.add(aVar);
                }
                this.DRu.add(bVar);
            }
            Log.i("Micromsg.SnsABTestInfo", "expertType " + safeParseInt2 + " " + str);
        } catch (Exception e2) {
            Log.printErrStackTrace("Micromsg.SnsABTestInfo", e2, "feed xml error ", new Object[0]);
        }
        AppMethodBeat.o(96131);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public int DRy;
        public int dDG;
        public List<a> lgB = new ArrayList();
        public String title;

        b() {
            AppMethodBeat.i(96129);
            AppMethodBeat.o(96129);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public String DRv;
        public String DRw;
        public int DRx;
        public int actionType;
        public int index;
        public String jumpUrl;

        a() {
        }
    }
}
