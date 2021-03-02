package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class cp {
    public static boolean iGd = false;
    private static cp iGg = null;
    private ArrayList<String> iGe = new ArrayList<>();
    private String iGf = "";

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cp(java.lang.String r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 572
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.cp.<init>(java.lang.String, boolean):void");
    }

    public static void KL(String str) {
        AppMethodBeat.i(132290);
        iGg = new cp(str, true);
        AppMethodBeat.o(132290);
    }

    public static String sj(int i2) {
        int size;
        AppMethodBeat.i(132291);
        if (iGg != null) {
            cp cpVar = iGg;
            String str = "";
            if (i2 >= cpVar.iGe.size()) {
                size = 0;
            } else {
                size = cpVar.iGe.size() - i2;
            }
            int i3 = size;
            while (i3 < cpVar.iGe.size()) {
                i3++;
                str = str + cpVar.iGe.get(i3) + ";";
            }
            AppMethodBeat.o(132291);
            return str;
        }
        AppMethodBeat.o(132291);
        return "";
    }
}
