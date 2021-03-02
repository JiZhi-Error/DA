package com.tencent.mm.plugin.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.protobuf.bb;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    static o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass13 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(204082);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    Long valueOf = Long.valueOf(Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_GAME_PULL_GLOBAL_CONFIG_TIME_LONG, (Object) 0L)));
                    if (valueOf.longValue() != 0 && Util.nowSecond() > valueOf.longValue()) {
                        b.dTd().I(true, 1);
                    }
                    int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_GAME_LAST_SAVED_VERSION_CODE_INT, (Object) 0)).intValue();
                    if (1 != intValue) {
                        Log.i("MicroMsg.GameEventListener", "checkVersionChange lastVersion:%d, currentVersion:%d", Integer.valueOf(intValue), 1);
                        g.aAh().azQ().set(ar.a.USERINFO_GAME_LAST_SAVED_VERSION_CODE_INT, (Object) 1);
                        it itVar = new it();
                        itVar.dNs.EX = 5;
                        itVar.dNs.param = "5";
                        EventCenter.instance.publish(itVar);
                    }
                }
            }
            AppMethodBeat.o(204082);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(204083);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                a.azj();
            }
            AppMethodBeat.o(204083);
        }
    };
    IListener grk = new IListener<xi>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass5 */

        {
            AppMethodBeat.i(161116);
            this.__eventId = xi.class.getName().hashCode();
            AppMethodBeat.o(161116);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xi xiVar) {
            AppMethodBeat.i(204077);
            xi xiVar2 = xiVar;
            if (xiVar2.edC.edD.equals(iy.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    c.this.xtB.LW();
                } else {
                    c.this.xtB.unregister();
                }
            } else if (xiVar2.edC.edD.equals(ix.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    c.this.xtC.LW();
                } else {
                    c.this.xtC.unregister();
                }
            }
            AppMethodBeat.o(204077);
            return false;
        }
    };
    cj.a rBq = new cj.a() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:180:0x08c0  */
        /* JADX WARNING: Removed duplicated region for block: B:185:0x08e6  */
        /* JADX WARNING: Removed duplicated region for block: B:248:0x0a67 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:260:0x0ab5  */
        /* JADX WARNING: Removed duplicated region for block: B:266:0x0ada  */
        /* JADX WARNING: Removed duplicated region for block: B:276:0x0b23 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:279:0x0b35  */
        @Override // com.tencent.mm.model.cj.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ak.h.a r20) {
            /*
            // Method dump skipped, instructions count: 2888
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.c.AnonymousClass1.a(com.tencent.mm.ak.h$a):void");
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
            AppMethodBeat.i(40824);
            if (cVar == null || Util.isNullOrNil(cVar.iMe) || Util.isNullOrNil(cVar.iMf)) {
                AppMethodBeat.o(40824);
                return;
            }
            Log.i("MicroMsg.GameEventListener", "delete msgType:%s, msgId:%s", cVar.iMe, cVar.iMf);
            if (!"gamecenter".equalsIgnoreCase(cVar.iMe)) {
                AppMethodBeat.o(40824);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar.iMf);
            com.tencent.mm.plugin.game.model.g.g(arrayList, false);
            AppMethodBeat.o(40824);
        }
    };
    IListener sKr = new IListener<mi>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass10 */

        {
            AppMethodBeat.i(204079);
            this.__eventId = mi.class.getName().hashCode();
            AppMethodBeat.o(204079);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(mi miVar) {
            return false;
        }
    };
    IListener xtA = new IListener<it>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass2 */

        {
            AppMethodBeat.i(204071);
            this.__eventId = it.class.getName().hashCode();
            AppMethodBeat.o(204071);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(it itVar) {
            AppMethodBeat.i(204072);
            f.a(itVar);
            AppMethodBeat.o(204072);
            return false;
        }
    };
    d xtB = new d() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass3 */

        {
            AppMethodBeat.i(161114);
            AppMethodBeat.o(161114);
        }

        @Override // com.tencent.mm.pluginsdk.c.d
        public final IEvent azl(String str) {
            AppMethodBeat.i(204073);
            iy iyVar = new iy();
            iyVar.dNC.event = str;
            AppMethodBeat.o(204073);
            return iyVar;
        }

        @Override // com.tencent.mm.pluginsdk.c.d
        public final MStorage dSG() {
            AppMethodBeat.i(204074);
            s dSK = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK();
            AppMethodBeat.o(204074);
            return dSK;
        }
    };
    d xtC = new d() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass4 */

        {
            AppMethodBeat.i(161115);
            AppMethodBeat.o(161115);
        }

        @Override // com.tencent.mm.pluginsdk.c.d
        public final IEvent azl(String str) {
            AppMethodBeat.i(204075);
            ix ixVar = new ix();
            ixVar.dNB.event = str;
            AppMethodBeat.o(204075);
            return ixVar;
        }

        @Override // com.tencent.mm.pluginsdk.c.d
        public final MStorage dSG() {
            AppMethodBeat.i(204076);
            e dXb = ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXb();
            AppMethodBeat.o(204076);
            return dXb;
        }
    };
    IListener xtD = new IListener<iu>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass6 */

        {
            AppMethodBeat.i(161117);
            this.__eventId = iu.class.getName().hashCode();
            AppMethodBeat.o(161117);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(iu iuVar) {
            AppMethodBeat.i(40828);
            iu iuVar2 = iuVar;
            j.dNv = iuVar2.dNu.dNv;
            j.countryCode = iuVar2.dNu.countryCode;
            AppMethodBeat.o(40828);
            return false;
        }
    };
    IListener xtE = new IListener<jr>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass7 */

        {
            AppMethodBeat.i(161118);
            this.__eventId = jr.class.getName().hashCode();
            AppMethodBeat.o(161118);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(jr jrVar) {
            AppMethodBeat.i(40829);
            jrVar.dOB.dNv = j.dNv;
            AppMethodBeat.o(40829);
            return false;
        }
    };
    IListener xtF = new IListener<jc>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass8 */

        {
            AppMethodBeat.i(161119);
            this.__eventId = jc.class.getName().hashCode();
            AppMethodBeat.o(161119);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jc jcVar) {
            AppMethodBeat.i(204078);
            jc jcVar2 = jcVar;
            Log.i("MicroMsg.GameEventListener", "opType = %d, opStatus = %d, appId = %s", Integer.valueOf(jcVar2.dNK.opType), Integer.valueOf(jcVar2.dNK.dNL), jcVar2.dNK.appId);
            if (jcVar2.dNK.opType != 0) {
                switch (jcVar2.dNK.opType) {
                    case 2:
                        k.dVi();
                        k.a(jcVar2.dNK.appId, jcVar2.dNK.dNL, false, jcVar2.dNK.dFN);
                        break;
                    case 6:
                        k.dVi();
                        k.hK(jcVar2.dNK.appId, jcVar2.dNK.dFN);
                        break;
                    default:
                        com.tencent.mm.game.report.api.a.hhr.c(jcVar2.dNK.appId, jcVar2.dNK.opType, jcVar2.dNK.dNL, jcVar2.dNK.openId, jcVar2.dNK.dFN);
                        break;
                }
            }
            AppMethodBeat.o(204078);
            return false;
        }
    };
    IListener xtG = new IListener<ps>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass9 */

        {
            AppMethodBeat.i(161120);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(161120);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            AppMethodBeat.i(40830);
            b.dTd().I(false, 2);
            AppMethodBeat.o(40830);
            return false;
        }
    };
    IListener xtH = new IListener<iz>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass11 */

        {
            AppMethodBeat.i(204080);
            this.__eventId = iz.class.getName().hashCode();
            AppMethodBeat.o(204080);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(iz izVar) {
            AppMethodBeat.i(204081);
            iz izVar2 = izVar;
            String str = izVar2.dND.url;
            izVar2.dNE.dNF = a.xto;
            switch (izVar2.dND.EX) {
                case 1:
                    izVar2.dNE.dNG = a.C1396a.dWO().aAF(str);
                    break;
                case 2:
                    a.C1396a.dWO().aAG(str);
                    break;
            }
            AppMethodBeat.o(204081);
            return false;
        }
    };
    av xtq = new av();
    com.tencent.mm.plugin.game.media.background.b xtr = new com.tencent.mm.plugin.game.media.background.b();
    IListener xts = new IListener<iv>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass12 */

        {
            AppMethodBeat.i(161121);
            this.__eventId = iv.class.getName().hashCode();
            AppMethodBeat.o(161121);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(iv ivVar) {
            AppMethodBeat.i(40831);
            iv ivVar2 = ivVar;
            k.a(ivVar2.dNx.url, ivVar2.dNx.md5, ivVar2.dNx.scene != 0 ? ivVar2.dNx.scene : 1000, ivVar2.dNx.appId, ivVar2.dNx.extInfo);
            AppMethodBeat.o(40831);
            return false;
        }
    };
    IListener xtt = new IListener<qe>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass14 */

        {
            AppMethodBeat.i(161122);
            this.__eventId = qe.class.getName().hashCode();
            AppMethodBeat.o(161122);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qe qeVar) {
            AppMethodBeat.i(40832);
            qe qeVar2 = qeVar;
            int dWZ = ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dWZ();
            if (dWZ == 0) {
                qeVar2.dWv.dEF = false;
            } else {
                long nullAsNil = Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_GAME_LIFE_LATEST_MSG_ID_LONG, (Object) 0L));
                long j2 = ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXa().msgId;
                if (nullAsNil == j2) {
                    qeVar2.dWv.dEF = false;
                } else {
                    qeVar2.dWv.dEF = true;
                    String string = MMApplicationContext.getContext().getResources().getString(R.string.dp0);
                    qeVar2.dWv.dQx = string.replace("{unread_msg_count}", String.valueOf(dWZ));
                    qeVar2.dWv.dWw = Util.nullAsNil(((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXa().talker);
                    qeVar2.dWv.dCm = dWZ;
                    qeVar2.dWv.dWx = j2;
                    bb dSY = com.tencent.mm.plugin.game.commlib.a.dSY();
                    if (!(dSY == null || dSY.xKX == null)) {
                        if (dSY.xKX.xJX && dSY.xKX.xJY) {
                            qeVar2.dWv.dEF = false;
                        } else if (dSY.xKX.xJY) {
                            qeVar2.dWv.dWw = "";
                        } else if (dSY.xKX.xJW != null && dSY.xKX.xJW.oUv == 1 && !Util.isNullOrNil(dSY.xKX.xJW.xNO)) {
                            qeVar2.dWv.dQx = dSY.xKX.xJW.xNO.replace("{unread_msg_count}", String.valueOf(dWZ));
                        }
                    }
                }
            }
            AppMethodBeat.o(40832);
            return false;
        }
    };
    IListener xtu = new IListener<qf>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass15 */

        {
            AppMethodBeat.i(161123);
            this.__eventId = qf.class.getName().hashCode();
            AppMethodBeat.o(161123);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x018c, code lost:
            if (r3 <= r5) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01da, code lost:
            if (r3 <= r5) goto L_0x0058;
         */
        @Override // com.tencent.mm.sdk.event.IListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.qf r15) {
            /*
            // Method dump skipped, instructions count: 660
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.c.AnonymousClass15.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    };
    IListener xtv = new IListener<is>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass16 */

        {
            AppMethodBeat.i(161124);
            this.__eventId = is.class.getName().hashCode();
            AppMethodBeat.o(161124);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(is isVar) {
            AppMethodBeat.i(40834);
            is isVar2 = isVar;
            switch (isVar2.dNr.actionCode) {
                case 1:
                    com.tencent.mm.plugin.game.model.e.a(isVar2.dNr.context, isVar2.dNr.appId, isVar2.dNr.messageAction, isVar2.dNr.messageExt, (al) null);
                    com.tencent.mm.game.report.f.a(isVar2.dNr.context, isVar2.dNr.scene, isVar2.dNr.scene, 1, 3, isVar2.dNr.appId, 0, null);
                    break;
                case 2:
                    int i2 = isVar2.dNr.scene;
                    String str = isVar2.dNr.extMsg;
                    Log.i("MicroMsg.GameEventListener", "scene = %d, extinfo = %s", Integer.valueOf(i2), str);
                    Bundle bundle = new Bundle();
                    bundle.putInt("game_report_from_scene", i2);
                    bundle.putCharSequence("game_app_id", isVar2.dNr.appId);
                    bundle.putCharSequence("game_report_extra_click_extinfo", str);
                    com.tencent.mm.game.report.f.a(isVar2.dNr.context, isVar2.dNr.scene, isVar2.dNr.scene, 1, com.tencent.mm.plugin.game.e.c.a(isVar2.dNr.context, isVar2.dNr.appId, null, bundle, isVar2.dNr.scene), isVar2.dNr.appId, 0, null);
                    break;
                case 3:
                    n.update();
                    break;
                case 5:
                    int i3 = isVar2.dNr.scene;
                    ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                    m.a(r.dVq(), i3, 2);
                    break;
            }
            AppMethodBeat.o(40834);
            return false;
        }
    };
    IListener xtw = new IListener<iw>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass17 */

        {
            AppMethodBeat.i(161125);
            this.__eventId = iw.class.getName().hashCode();
            AppMethodBeat.o(161125);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(iw iwVar) {
            AppMethodBeat.i(40836);
            iw iwVar2 = iwVar;
            switch (iwVar2.dNy.EX) {
                case 1:
                    String str = iwVar2.dNy.param;
                    new LinkedList();
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int i2 = Util.getInt(jSONObject.optString("type"), 0);
                            int i3 = Util.getInt(jSONObject.optString("limit"), 0);
                            long j2 = Util.getLong(jSONObject.optString("lastLocalId"), -1);
                            int i4 = Util.getInt(jSONObject.optString("isUnread"), -1);
                            if (i3 > 0 && i3 <= 10000 && j2 >= 0 && i4 >= 0) {
                                LinkedList<com.tencent.mm.plugin.game.model.o> b2 = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().b(i2, j2, i4, i3);
                                if (!Util.isNullOrNil(b2)) {
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator<com.tencent.mm.plugin.game.model.o> it = b2.iterator();
                                    while (it.hasNext()) {
                                        com.tencent.mm.plugin.game.model.o next = it.next();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(ch.COL_LOCALID, next.field_msgId);
                                        jSONObject2.put("content", next.field_rawXML);
                                        jSONArray.put(jSONObject2);
                                    }
                                    iwVar2.dNz.dNA = jSONArray.toString();
                                    break;
                                }
                            }
                        } catch (JSONException e2) {
                            Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e2.getMessage());
                            break;
                        }
                    }
                    break;
                case 2:
                    t.a(iwVar2);
                    break;
                case 3:
                    ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                    com.tencent.mm.plugin.game.model.o dVs = r.dVs();
                    if (dVs != null) {
                        iwVar2.dNz.dNA = dVs.field_rawXML;
                        break;
                    }
                    break;
                case 4:
                    ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                    r.dVt();
                    break;
                case 5:
                    ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                    com.tencent.mm.plugin.game.model.o GJ = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().GJ(((Long) g.aAh().azQ().get(ar.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L)).longValue());
                    if (GJ == null || GJ.field_isHidden) {
                        GJ = null;
                    }
                    if (GJ != null) {
                        iwVar2.dNz.dNA = GJ.field_rawXML;
                        break;
                    }
                    break;
                case 6:
                    ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                    com.tencent.mm.plugin.game.model.o GJ2 = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().GJ(((Long) g.aAh().azQ().get(ar.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L)).longValue());
                    if (GJ2 != null && !GJ2.field_isHidden) {
                        g.aAh().azQ().set(ar.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L);
                        break;
                    }
                case 9:
                    ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                    com.tencent.mm.plugin.game.model.o GJ3 = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().GJ(((Long) g.aAh().azQ().get(ar.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L)).longValue());
                    if (GJ3 != null) {
                        iwVar2.dNz.dNA = GJ3.field_rawXML;
                        break;
                    }
                    break;
                case 10:
                    ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                    if (((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().GJ(((Long) g.aAh().azQ().get(ar.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L)).longValue()) != null) {
                        g.aAh().azQ().set(ar.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L);
                        break;
                    }
                    break;
                case 12:
                    t.b(iwVar2);
                    break;
                case 13:
                    t.c(iwVar2);
                    break;
            }
            AppMethodBeat.o(40836);
            return false;
        }
    };
    IListener xtx = new IListener<ox>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass18 */

        {
            AppMethodBeat.i(161126);
            this.__eventId = ox.class.getName().hashCode();
            AppMethodBeat.o(161126);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ox oxVar) {
            AppMethodBeat.i(40837);
            boolean a2 = a(oxVar);
            AppMethodBeat.o(40837);
            return a2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00f2  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0163  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x01e0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean a(com.tencent.mm.g.a.ox r15) {
            /*
            // Method dump skipped, instructions count: 642
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.c.AnonymousClass18.a(com.tencent.mm.g.a.ox):boolean");
        }
    };
    IListener xty = new IListener<rx>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass19 */

        {
            AppMethodBeat.i(161127);
            this.__eventId = rx.class.getName().hashCode();
            AppMethodBeat.o(161127);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rx rxVar) {
            AppMethodBeat.i(40838);
            rx rxVar2 = rxVar;
            com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), rxVar2.dYt.scene, rxVar2.dYt.dYu, 1, rxVar2.dYt.action, 0, rxVar2.dYt.appId, 0, rxVar2.dYt.msgType, rxVar2.dYt.msgId, rxVar2.dYt.dDJ, rxVar2.dYt.dYv);
            AppMethodBeat.o(40838);
            return false;
        }
    };
    IListener xtz = new IListener<ry>() {
        /* class com.tencent.mm.plugin.game.c.AnonymousClass20 */

        {
            AppMethodBeat.i(161128);
            this.__eventId = ry.class.getName().hashCode();
            AppMethodBeat.o(161128);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ry ryVar) {
            AppMethodBeat.i(40839);
            ry ryVar2 = ryVar;
            com.tencent.mm.game.report.api.a.hhr.a(ryVar2.dYw.context, ryVar2.dYw.dNI, ryVar2.dYw.packageName, ryVar2.dYw.dRL, ryVar2.dYw.msgType, ryVar2.dYw.scene, ryVar2.dYw.dYx, ryVar2.dYw.mediaTagName, ryVar2.dYw.dTS, ryVar2.dYw.dYy, ryVar2.dYw.dCw, ryVar2.dYw.dYz);
            AppMethodBeat.o(40839);
            return false;
        }
    };

    public c() {
        AppMethodBeat.i(40840);
        AppMethodBeat.o(40840);
    }

    static {
        AppMethodBeat.i(204085);
        AppMethodBeat.o(204085);
    }
}
