package com.tencent.mm.ui.contact;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class w {
    static int PXE;
    private static List<String> PXF;
    private static List<String> PXG;

    public static void jL(List<String> list) {
        AppMethodBeat.i(102917);
        LinkedList linkedList = new LinkedList();
        PXF = linkedList;
        linkedList.addAll(list);
        Log.d("MicroMsg.NewGroupRecommendDetailReporter", "preCommend: %s", PXF);
        AppMethodBeat.o(102917);
    }

    public static void jM(List<String> list) {
        AppMethodBeat.i(102918);
        PXG = list;
        Log.d("MicroMsg.NewGroupRecommendDetailReporter", "recommend: %s", PXG);
        AppMethodBeat.o(102918);
    }

    public static void jN(List<String> list) {
        AppMethodBeat.i(102919);
        if (!(PXF == null || PXG == null || PXG.size() <= 0 || list == null || list.size() <= 0)) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            for (String str : list) {
                if (!PXF.contains(str)) {
                    if (PXG.contains(str)) {
                        linkedList.add(str);
                    } else {
                        linkedList2.add(str);
                    }
                }
            }
            for (int i2 = 0; i2 < PXG.size(); i2++) {
                if (linkedList.contains(PXG.get(i2))) {
                    linkedList3.add(String.valueOf(i2));
                }
            }
            if (linkedList.size() > 0 || linkedList2.size() > 0) {
                h.INSTANCE.a(18637, Integer.valueOf(PXE), TextUtils.join(";", PXF), TextUtils.join(";", PXG), TextUtils.join(";", linkedList), TextUtils.join(";", linkedList2), TextUtils.join(";", linkedList3));
                Log.d("MicroMsg.NewGroupRecommendDetailReporter", "report, selectFromRecommend: %s, selectNotFromRecommendList: %s", linkedList, linkedList2);
            }
        }
        reset();
        AppMethodBeat.o(102919);
    }

    public static void reset() {
        AppMethodBeat.i(102920);
        PXF = null;
        PXG = null;
        Log.d("MicroMsg.NewGroupRecommendDetailReporter", "reset");
        AppMethodBeat.o(102920);
    }
}
