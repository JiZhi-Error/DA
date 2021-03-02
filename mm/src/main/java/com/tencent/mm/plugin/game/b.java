package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements com.tencent.mm.plugin.game.api.b {
    private boolean tMY = false;
    private boolean xtp = false;

    @Override // com.tencent.mm.plugin.game.api.b
    public final void fU(Context context) {
        AppMethodBeat.i(40819);
        e.fU(context);
        AppMethodBeat.o(40819);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final String dSF() {
        AppMethodBeat.i(40820);
        String gf = e.gf(MMApplicationContext.getContext());
        AppMethodBeat.o(40820);
        return gf;
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void pG(boolean z) {
        boolean z2;
        AppMethodBeat.i(40821);
        if (!this.xtp) {
            if (!((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.game_luggage, true) || !((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.preload_game_webcore, false)) {
                z2 = false;
            } else {
                Log.i("MicroMsg.GameDelegateImpl", "hit expt preload");
                h.INSTANCE.n(939, 4, 1);
                if (YearClass.get(MMApplicationContext.getContext()) < 2014) {
                    Log.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
                    h.INSTANCE.n(939, 5, 1);
                    z2 = false;
                } else {
                    if (System.currentTimeMillis() - e.dVd() > 21600000) {
                        Log.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
                        if (z) {
                            ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
                            o dVn = r.dVn();
                            if (dVn == null || System.currentTimeMillis() - (dVn.field_receiveTime * 1000) > 21600000) {
                                Log.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
                                h.INSTANCE.n(939, 7, 1);
                                z2 = false;
                            }
                        } else {
                            h.INSTANCE.n(939, 6, 1);
                            z2 = false;
                        }
                    }
                    if (ChannelUtil.isGPVersion()) {
                        Log.i("MicroMsg.GameDelegateImpl", "isGPVersion");
                        h.INSTANCE.n(939, 8, 1);
                        z2 = false;
                    } else if (Util.isNullOrNil(c.dWQ())) {
                        h.INSTANCE.n(939, 9, 1);
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
            }
            this.tMY = z2;
            this.xtp = true;
        }
        if (this.tMY) {
            String dWQ = c.dWQ();
            if (!Util.isNullOrNil(dWQ)) {
                Log.i("MicroMsg.GameDelegateImpl", "preload");
                nr nrVar = new nr();
                nrVar.dTO.type = 3;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", dWQ);
                nrVar.dTO.intent = intent;
                EventCenter.instance.publish(nrVar);
            }
        }
        AppMethodBeat.o(40821);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void O(long j2, int i2) {
        AppMethodBeat.i(40822);
        o GJ = ((f) g.af(f.class)).dSK().GJ(j2);
        if (GJ != null) {
            GJ.dVl();
            String a2 = com.tencent.mm.game.report.f.a("resource", String.valueOf(i2), GJ.xFX, null);
            if (GJ.field_needReport) {
                com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 1, 0, GJ.field_appId, 0, GJ.xFV, GJ.field_gameMsgId, GJ.xFW, a2);
                h.INSTANCE.idkeyStat(858, 2, 1, false);
            }
        }
        AppMethodBeat.o(40822);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void NX(int i2) {
        JSONException e2;
        JSONObject jSONObject;
        AppMethodBeat.i(204069);
        JSONObject jSONObject2 = new JSONObject();
        com.tencent.mm.plugin.gamelife.e.b dXa = ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXa();
        int i3 = dXa.msgType;
        try {
            jSONObject = new JSONObject(dXa.xEl);
            try {
                jSONObject.put("chatmsg_num", String.valueOf(i2));
            } catch (JSONException e3) {
                e2 = e3;
                Log.printErrStackTrace("MicroMsg.GameDelegateImpl", e2, "", new Object[0]);
                com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 1, 0, null, 0, i3, null, null, com.tencent.mm.game.report.f.a("resource", "4", jSONObject.toString(), null));
                AppMethodBeat.o(204069);
            }
        } catch (JSONException e4) {
            e2 = e4;
            jSONObject = jSONObject2;
            Log.printErrStackTrace("MicroMsg.GameDelegateImpl", e2, "", new Object[0]);
            com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 1, 0, null, 0, i3, null, null, com.tencent.mm.game.report.f.a("resource", "4", jSONObject.toString(), null));
            AppMethodBeat.o(204069);
        }
        com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 1, 0, null, 0, i3, null, null, com.tencent.mm.game.report.f.a("resource", "4", jSONObject.toString(), null));
        AppMethodBeat.o(204069);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void azk(String str) {
        AppMethodBeat.i(204070);
        com.tencent.mm.plugin.game.c.b bVar = com.tencent.mm.plugin.game.c.b.xvL;
        com.tencent.mm.plugin.game.c.b.azr(str);
        AppMethodBeat.o(204070);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final boolean dSE() {
        boolean equalsIgnoreCase;
        AppMethodBeat.i(40811);
        try {
            if (a.xvl != null) {
                equalsIgnoreCase = a.xvl.ShowEntrance;
            } else {
                a.dSS();
                String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
                Log.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", loadApplicationLanguage);
                String nullAs = Util.nullAs(com.tencent.mm.n.h.aqJ().getValue("HideGameCenter"), LocaleUtil.CHINA.equals(loadApplicationLanguage) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
                Log.i("MicroMsg.GameConfigManager", "hide game center:[%s]", nullAs);
                equalsIgnoreCase = nullAs.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            Log.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(equalsIgnoreCase)));
            AppMethodBeat.o(40811);
            return equalsIgnoreCase;
        } catch (Exception e2) {
            AppMethodBeat.o(40811);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void a(String str, String str2, int i2, int i3, String str3, int i4) {
        AppMethodBeat.i(40812);
        com.tencent.mm.game.report.api.a.hhr.a(str, str2, i2, i3, str3, i4);
        AppMethodBeat.o(40812);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void a(Context context, String str, String str2, String str3, int i2, String str4, int i3) {
        AppMethodBeat.i(40813);
        com.tencent.mm.game.report.api.a.hhr.a(context, str, str2, str3, i2, str4, i3);
        AppMethodBeat.o(40813);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void a(String str, String str2, int i2, int i3, String str3, long j2, String str4, int i4) {
        AppMethodBeat.i(40814);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
        if (o != null) {
            com.tencent.mm.game.report.api.a.hhr.a(str, str2, i2, i3, str3, j2, o.NA(), str4, i4);
        }
        AppMethodBeat.o(40814);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void am(String str, int i2, int i3) {
        AppMethodBeat.i(40815);
        com.tencent.mm.game.report.api.a.hhr.m(str, i2, i3);
        AppMethodBeat.o(40815);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void k(String str, String str2, String str3) {
        AppMethodBeat.i(40816);
        com.tencent.mm.game.report.api.a.hhr.k(str, str2, str3);
        AppMethodBeat.o(40816);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void k(Context context, String str, String str2) {
        AppMethodBeat.i(40817);
        com.tencent.mm.game.report.api.a.hhr.k(context, str, str2);
        AppMethodBeat.o(40817);
    }

    @Override // com.tencent.mm.plugin.game.api.b
    public final void a(Context context, String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5, String str6) {
        AppMethodBeat.i(40818);
        com.tencent.mm.game.report.api.a.hhr.a(context, str, str2, str3, i2, i3, i4, str4, 0, str5, str6);
        AppMethodBeat.o(40818);
    }
}
