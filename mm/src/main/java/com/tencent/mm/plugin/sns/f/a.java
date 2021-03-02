package com.tencent.mm.plugin.sns.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static final List<String> DFl = Collections.synchronizedList(new LinkedList());
    private static IListener<vx> gmC = new IListener<vx>() {
        /* class com.tencent.mm.plugin.sns.f.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160645);
            this.__eventId = vx.class.getName().hashCode();
            AppMethodBeat.o(160645);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vx vxVar) {
            AppMethodBeat.i(95163);
            vx vxVar2 = vxVar;
            if (vxVar2.ebX == null || !vxVar2.ebX.ebY || TextUtils.isEmpty(vxVar2.ebX.username)) {
                AppMethodBeat.o(95163);
            } else {
                if (!vxVar2.ebX.eca) {
                    a.DFl.remove(vxVar2.ebX.username);
                } else {
                    a.DFl.add(vxVar2.ebX.username);
                }
                AppMethodBeat.o(95163);
            }
            return false;
        }
    };
    private static boolean isInit = false;

    static {
        AppMethodBeat.i(95170);
        AppMethodBeat.o(95170);
    }

    public static void init() {
        AppMethodBeat.i(95164);
        gmC.alive();
        AppMethodBeat.o(95164);
    }

    public static void destroy() {
        AppMethodBeat.i(95165);
        gmC.dead();
        AppMethodBeat.o(95165);
    }

    public static boolean aOD(String str) {
        AppMethodBeat.i(95166);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(95166);
            return false;
        } else if (str.equals(g.aAh().azQ().get(2, (Object) null))) {
            AppMethodBeat.o(95166);
            return false;
        } else if (aOF(str)) {
            AppMethodBeat.o(95166);
            return false;
        } else {
            boolean isStoryUnread = ((e) g.ah(e.class)).isStoryUnread(str);
            AppMethodBeat.o(95166);
            return isStoryUnread;
        }
    }

    public static boolean aOE(String str) {
        AppMethodBeat.i(95167);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(95167);
            return false;
        } else if (aOF(str)) {
            AppMethodBeat.o(95167);
            return false;
        } else if (((e) g.ah(e.class)).isStoryExist(str) || ((e) g.ah(e.class)).isStoryUnread(str)) {
            AppMethodBeat.o(95167);
            return true;
        } else {
            AppMethodBeat.o(95167);
            return false;
        }
    }

    public static boolean aOF(String str) {
        AppMethodBeat.i(95168);
        boolean contains = eZI().contains(str);
        AppMethodBeat.o(95168);
        return contains;
    }

    public static List<String> eZI() {
        AppMethodBeat.i(95169);
        if (isInit) {
            List<String> list = DFl;
            AppMethodBeat.o(95169);
            return list;
        }
        s JL = aj.faU().JL(5);
        if (Util.isNullOrNil(JL.field_memberList)) {
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(95169);
            return linkedList;
        }
        ArrayList<String> stringsToList = Util.stringsToList(JL.field_memberList.split(","));
        if (stringsToList == null) {
            LinkedList linkedList2 = new LinkedList();
            AppMethodBeat.o(95169);
            return linkedList2;
        }
        DFl.addAll(stringsToList);
        isInit = true;
        List<String> list2 = DFl;
        AppMethodBeat.o(95169);
        return list2;
    }
}
