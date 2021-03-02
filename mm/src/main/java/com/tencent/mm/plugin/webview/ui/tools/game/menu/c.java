package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {

    public enum a {
        HVGAME_MENU_ACTION_DEFAULT(0),
        HVGAME_MENU_ACTION_JUMP_H5(1),
        HVGAME_MENU_ACTION_EXIT(2),
        HVGAME_MENU_ACTION_SHARE_TO_FRIEND(3),
        HVGAME_MENU_ACTION_COLLECT(4),
        HVGAME_MENU_ACTION_REFRESH(7),
        HVGAME_MENU_ACTION_ADD_TO_DESKTOP(8),
        HVGAME_MENU_ACTION_COMPLAINT(9),
        HVGAME_MENU_ACTION_CUSTOM(10);
        
        private static EnumMap<a, Integer> JrX = new EnumMap<>(a.class);
        int code;

        public static a valueOf(String str) {
            AppMethodBeat.i(80965);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(80965);
            return aVar;
        }

        static {
            AppMethodBeat.i(80968);
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                JrX.put(aVar, Integer.valueOf(aVar.code));
            }
            AppMethodBeat.o(80968);
        }

        private a(int i2) {
            this.code = i2;
        }

        public static boolean agY(int i2) {
            AppMethodBeat.i(80966);
            boolean containsValue = JrX.containsValue(Integer.valueOf(i2));
            AppMethodBeat.o(80966);
            return containsValue;
        }

        public static a agZ(int i2) {
            AppMethodBeat.i(80967);
            for (Map.Entry<a, Integer> entry : JrX.entrySet()) {
                if (entry.getValue().intValue() == i2) {
                    a key = entry.getKey();
                    AppMethodBeat.o(80967);
                    return key;
                }
            }
            a aVar = HVGAME_MENU_ACTION_DEFAULT;
            AppMethodBeat.o(80967);
            return aVar;
        }
    }

    public static m c(Context context, List<coq> list) {
        AppMethodBeat.i(80969);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(80969);
            return null;
        }
        ArrayList<coq> arrayList = new ArrayList();
        for (coq coq : list) {
            if (coq != null && a.agY(coq.KWb)) {
                arrayList.add(coq);
            }
        }
        if (Util.isNullOrNil(arrayList)) {
            AppMethodBeat.o(80969);
            return null;
        }
        Collections.sort(arrayList, new Comparator<coq>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.game.menu.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(coq coq, coq coq2) {
                return coq.MuP - coq2.MuP;
            }
        });
        int i2 = ((coq) arrayList.get(arrayList.size() - 1)).MuP;
        ArrayList<coq> arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(null);
        }
        for (coq coq2 : arrayList) {
            if (coq2.MuP > 0 && coq2.MuP <= arrayList2.size()) {
                arrayList2.set(coq2.MuP - 1, coq2);
            }
        }
        m mVar = new m(context);
        for (coq coq3 : arrayList2) {
            if (coq3 == null) {
                mVar.d(-1, "");
            } else {
                mVar.d(coq3.MuO, coq3.Title + "__" + coq3.ThumbUrl);
            }
        }
        AppMethodBeat.o(80969);
        return mVar;
    }
}
