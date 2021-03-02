package com.tencent.mm.bp;

import android.content.Context;
import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import org.xwalk.core.Log;

public final class a {
    public static boolean glB() {
        AppMethodBeat.i(237141);
        boolean dDf = ((aj) g.ah(aj.class)).getFinderUtilApi().dDf();
        AppMethodBeat.o(237141);
        return dDf;
    }

    public static boolean glC() {
        AppMethodBeat.i(89923);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableStrangerChat");
        if (Util.isNullOrNil(value)) {
            value = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        boolean equals = "1".equals(value);
        AppMethodBeat.o(89923);
        return equals;
    }

    public static boolean Xm() {
        AppMethodBeat.i(237142);
        lu luVar = new lu();
        luVar.dRh.dJY = 7;
        EventCenter.instance.publish(luVar);
        boolean z = luVar.dRi.dFE;
        AppMethodBeat.o(237142);
        return z;
    }

    public static void au(Context context, Intent intent) {
        AppMethodBeat.i(237143);
        if (glB()) {
            Log.i("NearbyHelper", "gotoNearByUILiveFriends");
            ((aj) g.ah(aj.class)).enterFinderLbsLiveFriendsUI(context, intent);
            AppMethodBeat.o(237143);
            return;
        }
        Log.i("NearbyHelper", "gotoNearBy");
        if (!glC()) {
            g.aAf().azk();
            if (((l) g.af(l.class)).eiv().ctM() > 0) {
                c.V(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
                AppMethodBeat.o(237143);
                return;
            }
        }
        c.V(context, "nearby", ".ui.NearbyFriendsUI");
        AppMethodBeat.o(237143);
    }

    public static void ih(Context context) {
        AppMethodBeat.i(89924);
        au(context, new Intent());
        AppMethodBeat.o(89924);
    }
}
