package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class r {
    private static int liQ = -1;

    public static void a(evf evf, l lVar) {
        AppMethodBeat.i(147078);
        if (lVar != null) {
            ((b) e.N(b.class)).a(15190, Integer.valueOf((int) (System.currentTimeMillis() - lVar.lhG)), Integer.valueOf(lVar.size), Integer.valueOf(evf.computeSize()), 0, "", "", Integer.valueOf(bAW()), Integer.valueOf(bAX()));
        }
        AppMethodBeat.o(147078);
    }

    public static void a(c cVar, int i2) {
        AppMethodBeat.i(147079);
        ((b) e.N(b.class)).a(15190, Integer.valueOf((int) (System.currentTimeMillis() - cVar.lhG)), Integer.valueOf(cVar.size), Integer.valueOf(i2), 1, "", Util.nullAsNil(cVar.event), Integer.valueOf(bAW()), Integer.valueOf(bAX()));
        AppMethodBeat.o(147079);
    }

    public static void a(String str, LinkedList<String> linkedList, long j2, int i2, int i3) {
        String str2;
        AppMethodBeat.i(147080);
        if ((str.equals("invokeHandler") || str.equals("publishHandler")) && linkedList.size() > 0) {
            str2 = linkedList.get(0);
        } else {
            str2 = "";
        }
        ((b) e.N(b.class)).a(15190, Integer.valueOf((int) (System.currentTimeMillis() - j2)), Integer.valueOf(i2), Integer.valueOf(i3), 2, str, str2, Integer.valueOf(bAW()), Integer.valueOf(bAX()));
        AppMethodBeat.o(147080);
    }

    public static String XW(String str) {
        AppMethodBeat.i(147081);
        Matcher matcher = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            AppMethodBeat.o(147081);
            return group;
        }
        AppMethodBeat.o(147081);
        return "";
    }

    private static int bAW() {
        AppMethodBeat.i(147082);
        if (liQ >= 0) {
            int i2 = liQ;
            AppMethodBeat.o(147082);
            return i2;
        }
        int iSPCode = NetStatusUtil.getISPCode(MMApplicationContext.getContext());
        liQ = iSPCode;
        AppMethodBeat.o(147082);
        return iSPCode;
    }

    public static int bAX() {
        AppMethodBeat.i(147083);
        Context context = MMApplicationContext.getContext();
        int i2 = 5;
        if (!NetStatusUtil.isConnected(context)) {
            i2 = 0;
        } else if (NetStatusUtil.is2G(context)) {
            i2 = 1;
        } else if (NetStatusUtil.is3G(context)) {
            i2 = 2;
        } else if (NetStatusUtil.is4G(context)) {
            i2 = 3;
        } else if (NetStatusUtil.isWifi(context)) {
            i2 = 4;
        }
        AppMethodBeat.o(147083);
        return i2;
    }
}
