package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.un;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
    private String DhB;
    public List<WeakReference<a>> pQG;

    public interface a {
        void eUv();
    }

    public static class b extends c {
        protected int DhC = 0;
        protected int DhD = 0;
        protected String DhE = "";
        protected int DhF = 0;
        protected int DhG = 0;
        protected int DhH = 7;
        protected String DhI = "";
    }

    public static class c {
    }

    public static class d extends c {
        protected String DhJ;
        protected String DhK;
        protected String DhL;
    }

    public f() {
        AppMethodBeat.i(28190);
        this.pQG = new ArrayList();
        this.DhB = "";
        this.DhB = com.tencent.mm.plugin.shake.c.c.a.eUH();
        AppMethodBeat.o(28190);
    }

    public final void m(String str, long j2, int i2) {
        AppMethodBeat.i(28191);
        Log.i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(j2)));
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
            AppMethodBeat.o(28191);
            return;
        }
        if (i2 == 0) {
            Log.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
            a(aNk(str));
            eUu();
        } else if (i2 == 1) {
            Log.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
            a(aNl(str));
            eUu();
        }
        com.tencent.mm.plugin.shake.c.c.a.eUg();
        AppMethodBeat.o(28191);
    }

    private static void eUu() {
        AppMethodBeat.i(28192);
        EventCenter.instance.publish(new un());
        AppMethodBeat.o(28192);
    }

    private static b aNk(String str) {
        AppMethodBeat.i(28193);
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            AppMethodBeat.o(28193);
            return null;
        }
        b bVar = new b();
        String str2 = parseXml.get(".sysmsg.begintime");
        if (TextUtils.isEmpty(str2) || !isNumeric(str2)) {
            Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str2)));
            bVar.DhC = 0;
        } else {
            bVar.DhC = Util.getInt(str2, 0);
        }
        String str3 = parseXml.get(".sysmsg.endtime");
        if (TextUtils.isEmpty(str3) || !isNumeric(str3)) {
            Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str3)));
            bVar.DhD = 0;
        } else {
            bVar.DhD = Util.getInt(str3, 0);
        }
        bVar.DhE = parseXml.get(".sysmsg.entrancename");
        String str4 = parseXml.get(".sysmsg.activitytype");
        if (TextUtils.isEmpty(str4) || !isNumeric(str4)) {
            bVar.DhF = 1;
        } else {
            bVar.DhF = Util.getInt(str4, 0);
        }
        Log.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str4)));
        String str5 = parseXml.get(".sysmsg.flowcontrollevelmin");
        if (TextUtils.isEmpty(str5) || !isNumeric(str5)) {
            Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str5)));
            bVar.DhG = 0;
        } else {
            bVar.DhG = Util.getInt(str5, 0);
        }
        bVar.DhI = parseXml.get(".sysmsg.shakecardentrancetip");
        String str6 = parseXml.get(".sysmsg.flowcontrollevelmax");
        if (TextUtils.isEmpty(str6) || !isNumeric(str6)) {
            Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(str6)));
            bVar.DhH = 0;
        } else {
            bVar.DhH = Util.getInt(str6, 0);
        }
        AppMethodBeat.o(28193);
        return bVar;
    }

    private static void a(b bVar) {
        AppMethodBeat.i(28194);
        if (bVar == null) {
            Log.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
            AppMethodBeat.o(28194);
            return;
        }
        Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
        if (!com.tencent.mm.plugin.shake.c.c.a.eUh()) {
            Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
        }
        Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + bVar.DhC + "  endtime:" + bVar.DhD + "  flowlevelmin:" + bVar.DhG + "  flowlevelmax:" + bVar.DhH + " entrancename:" + bVar.DhE + " activitytype:" + bVar.DhF);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(bVar.DhC));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(bVar.DhD));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, bVar.DhE);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(bVar.DhF));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(bVar.DhG));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(bVar.DhH));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, bVar.DhI);
        AppMethodBeat.o(28194);
    }

    private static d aNl(String str) {
        AppMethodBeat.i(28195);
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            AppMethodBeat.o(28195);
            return null;
        }
        d dVar = new d();
        dVar.DhJ = parseXml.get(".sysmsg.reddotid");
        dVar.DhK = parseXml.get(".sysmsg.reddotdesc");
        dVar.DhL = parseXml.get(".sysmsg.reddottext");
        AppMethodBeat.o(28195);
        return dVar;
    }

    private void a(d dVar) {
        AppMethodBeat.i(28196);
        if (dVar == null) {
            Log.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
            AppMethodBeat.o(28196);
            return;
        }
        Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + dVar.DhJ);
        Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.DhB);
        if (TextUtils.isEmpty(dVar.DhJ)) {
            Log.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
            AppMethodBeat.o(28196);
        } else if (TextUtils.isEmpty(this.DhB)) {
            Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
            com.tencent.mm.y.c.axV().B(262154, true);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, dVar.DhJ);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, dVar.DhK);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, dVar.DhL);
            onChange();
            AppMethodBeat.o(28196);
        } else if (!this.DhB.equals(dVar.DhJ)) {
            Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.y.c.axV().B(262154, true);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, dVar.DhJ);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, dVar.DhK);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, dVar.DhL);
            onChange();
            AppMethodBeat.o(28196);
        } else {
            if (this.DhB.equals(dVar.DhJ)) {
                Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
            }
            AppMethodBeat.o(28196);
        }
    }

    private static boolean isNumeric(String str) {
        AppMethodBeat.i(28197);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(28197);
        return matches;
    }

    private void onChange() {
        a aVar;
        AppMethodBeat.i(28198);
        if (this.pQG == null) {
            AppMethodBeat.o(28198);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.eUv();
            }
        }
        AppMethodBeat.o(28198);
    }
}
