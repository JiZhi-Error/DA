package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class e {
    private static final String[] kwz = {"7day_clk_rate_h", "7day_impr_h", "last_stay_secs", "snsunread", "friendstabredunread", "7day_clk_h", "from_last_hours", "wechatdurationnminute_10", "wechatdurationnminute_30", "wechatdurationnminute_90", "findfrienduiexposure_10", "findfrienduiexposure_30", "findfrienduiexposure_90", "lastsessionduration", "wechatduration7dayhour"};
    private String filePath;
    boolean jCx = true;
    HashMap<String, float[]> kwA = new HashMap<>();

    public e(String str) {
        AppMethodBeat.i(238883);
        this.filePath = str;
        AppMethodBeat.o(238883);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[SYNTHETIC, Splitter:B:14:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A[SYNTHETIC, Splitter:B:17:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c A[SYNTHETIC, Splitter:B:31:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081 A[SYNTHETIC, Splitter:B:34:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c A[SYNTHETIC, Splitter:B:40:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091 A[SYNTHETIC, Splitter:B:43:0x0091] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean wW() {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ai.b.a.a.e.wW():boolean");
    }

    private boolean d(HashMap<String, String[]> hashMap) {
        AppMethodBeat.i(238885);
        if (hashMap.isEmpty()) {
            AppMethodBeat.o(238885);
            return false;
        }
        String[] strArr = kwz;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str = strArr[i2];
            if (!hashMap.containsKey(str)) {
                this.jCx = false;
                break;
            }
            String[] remove = hashMap.remove(str);
            if (remove == null || remove.length <= 0) {
                this.jCx = false;
            } else {
                float[] fArr = new float[(remove.length - 1)];
                for (int i3 = 1; i3 < remove.length; i3++) {
                    fArr[i3 - 1] = Util.getFloat(remove[i3], 0.0f);
                }
                this.kwA.put(str, fArr);
                i2++;
            }
        }
        boolean z = this.jCx;
        AppMethodBeat.o(238885);
        return z;
    }
}
