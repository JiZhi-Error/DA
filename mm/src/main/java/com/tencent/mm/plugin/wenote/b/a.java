package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends f {
    private static e lqt = new com.tencent.mm.plugin.ball.c.f() {
        /* class com.tencent.mm.plugin.wenote.b.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(30266);
            a.a(ballInfo);
            AppMethodBeat.o(30266);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
        }
    };
    private NoteEditorUI VhV;

    public a(NoteEditorUI noteEditorUI, b bVar) {
        super(bVar);
        this.VhV = noteEditorUI;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        AppMethodBeat.i(30267);
        boolean aGg = this.oXA.aGg();
        AppMethodBeat.o(30267);
        return aGg;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(30268);
        super.G(i2, str);
        ciw().hDa = 5;
        ciw().oWx = 6;
        ciw().iNV = "";
        cit();
        AppMethodBeat.o(30268);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(30269);
        super.onDestroy();
        AppMethodBeat.o(30269);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(30270);
        super.bCB();
        AppMethodBeat.o(30270);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(30271);
        super.aGi();
        this.oXA.hb(false);
        AppMethodBeat.o(30271);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        return true;
    }

    public static void a(q qVar) {
        AppMethodBeat.i(30272);
        if (qVar.JHR) {
            if (qVar.tcb) {
                h.INSTANCE.a(14789, 3);
            } else {
                h.INSTANCE.a(14789, 2);
            }
            Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
            j jVar = new j();
            jVar.JGY = b(qVar);
            jVar.JGZ = 3;
            c.gjz().JGL = jVar;
            and and = new and();
            and.scene = 8;
            jVar.a(qVar.JHV, Long.valueOf(qVar.JHT), true, MMApplicationContext.getContext(), qVar.JHW, qVar.JHX, and, null);
            AppMethodBeat.o(30272);
            return;
        }
        h.INSTANCE.a(14789, 1);
        Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
        g gVar = new g();
        gVar.JGY = b(qVar);
        gVar.JGZ = 3;
        c.gjz().JGL = gVar;
        and and2 = new and();
        and2.scene = 8;
        gVar.a(qVar.JHS, MMApplicationContext.getContext(), Boolean.TRUE, qVar.JHW, qVar.JHX, and2, null, null);
        AppMethodBeat.o(30272);
    }

    static {
        AppMethodBeat.i(30284);
        AppMethodBeat.o(30284);
    }

    public static void bCE() {
        AppMethodBeat.i(30273);
        if (com.tencent.mm.kernel.g.af(b.class) != null) {
            ((b) com.tencent.mm.kernel.g.af(b.class)).a(3, lqt);
        }
        AppMethodBeat.o(30273);
    }

    public static void bCF() {
        AppMethodBeat.i(30274);
        if (com.tencent.mm.kernel.g.af(b.class) != null) {
            ((b) com.tencent.mm.kernel.g.af(b.class)).b(3, lqt);
        }
        AppMethodBeat.o(30274);
    }

    public static String a(pa.a aVar) {
        AppMethodBeat.i(30275);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", aVar.msgId);
            jSONObject.put("noteXmlStr", aVar.dVc == null ? "" : aVar.dVc);
            jSONObject.put("showShare", aVar.dUo);
            jSONObject.put("scene", aVar.scene);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "eventToJson OpenNoteFromSessionEvent", new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(30275);
        return jSONObject2;
    }

    private static pa.a bbK(String str) {
        AppMethodBeat.i(30276);
        try {
            i iVar = new i(str);
            pa.a aVar = new pa.a();
            aVar.msgId = iVar.getLong("msgId");
            aVar.dVc = iVar.getString("noteXmlStr");
            aVar.dUo = iVar.getBoolean("showShare");
            aVar.scene = iVar.getInt("scene");
            aVar.context = MMApplicationContext.getContext();
            AppMethodBeat.o(30276);
            return aVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "parseOpenNoteFromSessionEventData", new Object[0]);
            AppMethodBeat.o(30276);
            return null;
        }
    }

    public static String a(oc.a aVar) {
        AppMethodBeat.i(30277);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", aVar.type);
            jSONObject.put("editorId", aVar.dUg == null ? "" : aVar.dUg);
            jSONObject.put("field_localId", aVar.field_localId);
            jSONObject.put("insertJsonData", aVar.dUi == null ? "" : aVar.dUi);
            jSONObject.put("exportJsonData", aVar.dUj == null ? "" : aVar.dUj);
            jSONObject.put("isInsert", aVar.dUk);
            jSONObject.put("bundleData", aVar.dUl == null ? "" : bn(aVar.dUl));
            jSONObject.put("itemType", aVar.dUm);
            jSONObject.put("path", aVar.path == null ? "" : aVar.path);
            jSONObject.put("intdata", aVar.dUn);
            jSONObject.put("showShare", aVar.dUo);
            jSONObject.put("field_favProto", aVar.field_favProto == null ? "" : Base64.encodeToString(aVar.field_favProto.toByteArray(), 0));
            jSONObject.put("reportInfo", aVar.dUp == null ? "" : Base64.encodeToString(aVar.dUp.toByteArray(), 0));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "eventToJson NotifyWNNoteOperationEvent", new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(30277);
        return jSONObject2;
    }

    private static oc.a bbL(String str) {
        AppMethodBeat.i(30278);
        try {
            JSONObject jSONObject = new JSONObject(str);
            oc.a aVar = new oc.a();
            aVar.type = jSONObject.getInt("type");
            aVar.dUg = jSONObject.getString("editorId");
            aVar.field_localId = jSONObject.getLong("field_localId");
            aVar.dUi = jSONObject.getString("insertJsonData");
            aVar.dUj = jSONObject.getString("exportJsonData");
            aVar.dUk = jSONObject.getBoolean("isInsert");
            String string = jSONObject.getString("bundleData");
            if (string.equals("")) {
                aVar.dUl = null;
            } else {
                aVar.dUl = bbM(string);
            }
            aVar.dUm = jSONObject.getInt("itemType");
            aVar.path = jSONObject.getString("path");
            aVar.dUn = jSONObject.getInt("intdata");
            aVar.dUo = jSONObject.getBoolean("showShare");
            aVar.field_favProto = new anb();
            String string2 = jSONObject.getString("field_favProto");
            if (!Util.isNullOrNil(string2)) {
                aVar.field_favProto.parseFrom(Base64.decode(string2, 0));
            }
            aVar.dUp = new and();
            String string3 = jSONObject.getString("reportInfo");
            if (!Util.isNullOrNil(string3)) {
                aVar.dUp.parseFrom(Base64.decode(string3, 0));
            }
            aVar.context = MMApplicationContext.getContext();
            AppMethodBeat.o(30278);
            return aVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "parse NotifyWNNoteOperationEvent", new Object[0]);
            AppMethodBeat.o(30278);
            return null;
        }
    }

    private static String bn(Bundle bundle) {
        AppMethodBeat.i(30279);
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
            }
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(30279);
            return jSONObject2;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "bundleToJson", new Object[0]);
            AppMethodBeat.o(30279);
            return null;
        }
    }

    private static Bundle bbM(String str) {
        AppMethodBeat.i(30280);
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
            AppMethodBeat.o(30280);
            return bundle;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "jsonToBundle", new Object[0]);
            AppMethodBeat.o(30280);
            return null;
        }
    }

    public static String b(q qVar) {
        AppMethodBeat.i(30281);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topIsOpenFromSession", qVar.JHR);
            jSONObject.put("topLocalId", qVar.JHS);
            jSONObject.put("topMsgId", qVar.JHT);
            jSONObject.put("isChatRoom", qVar.tcb);
            jSONObject.put("topTitle", qVar.JHU == null ? "" : qVar.JHU);
            jSONObject.put("topNoteXml", qVar.JHV == null ? "" : qVar.JHV);
            jSONObject.put("topLastPosition", qVar.JHW);
            jSONObject.put("topLastOffset", qVar.JHX);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "topItemToJson", new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(30281);
        return jSONObject2;
    }

    private static q bbN(String str) {
        AppMethodBeat.i(30282);
        try {
            q qVar = new q();
            JSONObject jSONObject = new JSONObject(str);
            qVar.JHR = jSONObject.getBoolean("topIsOpenFromSession");
            qVar.JHS = jSONObject.getLong("topLocalId");
            qVar.JHT = jSONObject.getLong("topMsgId");
            qVar.tcb = jSONObject.getBoolean("isChatRoom");
            qVar.JHU = jSONObject.getString("topTitle");
            qVar.JHV = jSONObject.getString("topNoteXml");
            qVar.JHW = jSONObject.getInt("topLastPosition");
            qVar.JHX = jSONObject.getInt("topLastOffset");
            AppMethodBeat.o(30282);
            return qVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", e2, "parseWNNoteKeepTopItem", new Object[0]);
            AppMethodBeat.o(30282);
            return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(BallInfo ballInfo) {
        com.tencent.mm.plugin.fav.a.g DY;
        AppMethodBeat.i(30283);
        if (!(ballInfo == null || ballInfo.jkf == null)) {
            Log.i("MicroMsg.Fav.NoteFloatBallHelper", "handleBallInfoClicked, openNote ballInfo:%s", ballInfo);
            String string = ballInfo.jkf.getString("eventData");
            switch (ballInfo.jkf.getInt("eventType")) {
                case 1:
                    oc.a bbL = bbL(string);
                    if (bbL == null) {
                        Log.e("MicroMsg.Fav.NoteFloatBallHelper", "NotifyWNNoteOperationEvent data is null");
                        AppMethodBeat.o(30283);
                        return;
                    }
                    if (bbL.type == 9 && (DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(bbL.field_localId)) != null) {
                        bbL.dUg = DY.field_xml;
                        Bundle bundle = new Bundle();
                        amv amv = DY.field_favProto.KBr;
                        if (amv != null) {
                            bundle.putString("noteauthor", amv.LxT);
                            bundle.putString("noteeditor", amv.LxU);
                        }
                        bundle.putLong("edittime", DY.field_updateTime);
                        bbL.dUl = bundle;
                        bbL.field_favProto = DY.field_favProto;
                        bbL.type = 2;
                    }
                    oc ocVar = new oc();
                    if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(bbL.field_localId) == null) {
                        u.makeText(MMApplicationContext.getContext(), (int) R.string.feb, 0).show();
                        ((b) com.tencent.mm.kernel.g.af(b.class)).l(ballInfo);
                        AppMethodBeat.o(30283);
                        return;
                    }
                    ocVar.dUe = bbL;
                    EventCenter.instance.publish(ocVar);
                    AppMethodBeat.o(30283);
                    return;
                case 2:
                    pa.a bbK = bbK(string);
                    if (bbK == null) {
                        Log.e("MicroMsg.Fav.NoteFloatBallHelper", "OpenNoteFromSessionEvent data is null");
                        AppMethodBeat.o(30283);
                        return;
                    }
                    pa paVar = new pa();
                    paVar.dVb = bbK;
                    EventCenter.instance.publish(paVar);
                    AppMethodBeat.o(30283);
                    return;
                case 3:
                    Log.i("MicroMsg.Fav.NoteFloatBallHelper", "click WNNoteBanner");
                    q bbN = bbN(string);
                    if (bbN != null) {
                        a(bbN);
                        break;
                    } else {
                        Log.e("MicroMsg.Fav.NoteFloatBallHelper", "WNNoteKeepTopItem data is null");
                        AppMethodBeat.o(30283);
                        return;
                    }
            }
        }
        AppMethodBeat.o(30283);
    }
}
