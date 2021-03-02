package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.Iterator;

public final class g extends d implements i {
    private static HashMap<com.tencent.mm.plugin.fav.a.g, m> JHc = new HashMap<>();
    public String JHa;
    public String JHb = "";
    private int JHd = 0;
    public String JHe;
    public int JHf = 0;
    public long JHg = 0;
    public String JHh;
    public String JHi;
    public byte[] JHj = null;
    public boolean JHk = false;
    private and dLx = new and();
    private int dUh = 0;
    public boolean dUo = true;
    public long dUt = -1;
    private com.tencent.mm.plugin.fav.a.g tfP;

    static {
        AppMethodBeat.i(30327);
        AppMethodBeat.o(30327);
    }

    public g() {
        AppMethodBeat.i(30313);
        this.JGQ.clear();
        this.JGP = null;
        qPd = "";
        this.JGV = false;
        e.cVJ();
        bg.azz().a(v2helper.EMethodSetAgcRxOn, this);
        AppMethodBeat.o(30313);
    }

    public final void a(long j2, Context context, Boolean bool, int i2, int i3, and and, final anb anb, byte[] bArr) {
        AppMethodBeat.i(232131);
        this.dUt = j2;
        this.dUo = bool.booleanValue();
        this.dUh = i2;
        this.JHd = i3;
        this.dLx = and;
        this.JHj = bArr;
        gjC();
        if (this.JHf == 0 && this.JGW.Lya != null) {
            this.JHf = this.JGW.Lya.sourceType;
        }
        aw(context, 2);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.wenote.model.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(30311);
                if (anb != null) {
                    com.tencent.mm.plugin.fav.a.g gVar = new com.tencent.mm.plugin.fav.a.g();
                    gVar.field_localId = g.this.dUt;
                    gVar.field_favProto = anb;
                    g.this.JGW = gVar.field_favProto;
                    g.this.JGP = gVar;
                    g.this.tfP = gVar;
                }
                if (g.JHc.containsKey(g.this.tfP)) {
                    g.this.JGO = (m) g.JHc.get(g.this.tfP);
                } else {
                    g.c(g.this);
                }
                g.this.iq(g.this.JGO.BHs);
                if (k.gjR() != null) {
                    k.gjV();
                }
                AppMethodBeat.o(30311);
            }

            public final String toString() {
                AppMethodBeat.i(30312);
                String str = super.toString() + "|dealWNoteInfo";
                AppMethodBeat.o(30312);
                return str;
            }
        });
        AppMethodBeat.o(232131);
    }

    public final void aw(Context context, int i2) {
        AppMethodBeat.i(30315);
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", i2);
        if (i2 == 4) {
            intent.putExtra("fav_note_thumbpath", this.JHh);
            intent.putExtra("fav_note_link_sns_xml", this.JHi);
        }
        intent.putExtra("edit_status", this.JGV);
        intent.putExtra("need_save", this.JHk);
        intent.putExtra("show_share", this.dUo);
        intent.putExtra("note_fav_localid", this.dUt);
        intent.putExtra("note_link_sns_localid", this.JHa);
        intent.putExtra("fav_note_xml", this.JHb);
        intent.putExtra("fav_note_scroll_to_position", this.dUh);
        intent.putExtra("fav_note_scroll_to_offset", this.JHd);
        intent.putExtra("fav_note_link_source_info", this.JHe);
        intent.putExtra("note_fav_post_scene", this.JHf);
        intent.putExtra("key_detail_fav_scene", this.dLx.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
        intent.putExtra("key_detail_fav_index", this.dLx.index);
        intent.putExtra("key_detail_fav_query", this.dLx.query);
        intent.putExtra("key_detail_fav_sessionid", this.dLx.sessionId);
        intent.putExtra("key_detail_fav_tags", this.dLx.tay);
        intent.putExtra("key_multi_task_common_info", this.JHj);
        c.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        AppMethodBeat.o(30315);
    }

    private void gjC() {
        AppMethodBeat.i(30316);
        this.tfP = f.HT(this.dUt);
        if (this.tfP == null) {
            AppMethodBeat.o(30316);
            return;
        }
        if (this.JHg <= 0) {
            this.JHg = this.tfP.field_updateTime;
        }
        this.JGW = this.tfP.field_favProto;
        this.JGP = this.tfP;
        AppMethodBeat.o(30316);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final String d(aml aml) {
        AppMethodBeat.i(30317);
        String b2 = f.b(aml);
        AppMethodBeat.o(30317);
        return b2;
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final String a(aml aml) {
        AppMethodBeat.i(30318);
        String a2 = f.a(aml);
        AppMethodBeat.o(30318);
        return a2;
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void p(aml aml) {
        AppMethodBeat.i(30319);
        m mVar = this.JGO;
        hb hbVar = new hb();
        hbVar.dLm.type = 28;
        hbVar.dLm.dFW = mVar.qNT.field_localId;
        hbVar.dLm.dLo = aml;
        hbVar.dLm.path = "";
        hbVar.dLm.dLt = 18;
        EventCenter.instance.publish(hbVar);
        AppMethodBeat.o(30319);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void a(aml aml, String str) {
        AppMethodBeat.i(30320);
        m mVar = this.JGO;
        hb hbVar = new hb();
        hbVar.dLm.type = 28;
        hbVar.dLm.dFW = mVar.qNT.field_localId;
        hbVar.dLm.dLo = aml;
        hbVar.dLm.path = str;
        hbVar.dLm.dLt = 18;
        EventCenter.instance.publish(hbVar);
        AppMethodBeat.o(30320);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void bX(Context context, String str) {
        AppMethodBeat.i(30321);
        u uVar = (u) this.JGS.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.JHb);
        if (uVar != null) {
            intent.putExtra("key_detail_data_id", bbQ(str));
        }
        intent.putExtra("key_detail_can_delete", false);
        intent.putExtra("key_detail_info_id", this.dUt);
        intent.putExtra("key_detail_fav_scene", this.dLx.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
        intent.putExtra("key_detail_fav_index", this.dLx.index);
        b.a(context, ".ui.detail.FavoriteFileDetailUI", intent, 1);
        AppMethodBeat.o(30321);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void bZ(Context context, String str) {
        AppMethodBeat.i(30322);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.JHb);
        if (this.JGS.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((o) this.JGS.get(str)).dLl);
        }
        intent.putExtra("key_detail_info_id", this.dUt);
        intent.putExtra("key_detail_fav_scene", this.dLx.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
        intent.putExtra("key_detail_fav_index", this.dLx.index);
        b.a(context, ".ui.FavImgGalleryUI", intent, 1);
        AppMethodBeat.o(30322);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void bY(Context context, String str) {
        AppMethodBeat.i(30323);
        s sVar = (s) this.JGS.get(str);
        if (sVar == null) {
            com.tencent.mm.ui.base.h.cD(context, MMApplicationContext.getContext().getString(R.string.cbb));
            AppMethodBeat.o(30323);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kwebmap_slat", sVar.lat);
        intent.putExtra("kwebmap_lng", sVar.lng);
        intent.putExtra("kPoiName", sVar.kHV);
        intent.putExtra("Kwebmap_locaion", sVar.iUO);
        if (sVar.JIb >= 0.0d) {
            intent.putExtra("kwebmap_scale", sVar.JIb);
        }
        intent.putExtra("kisUsername", "");
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.dUt);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        c.b(context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 1);
        AppMethodBeat.o(30323);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(30324);
        if (qVar.getType() == 426) {
            hb hbVar = new hb();
            hbVar.dLm.dGJ = qVar;
            hbVar.dLm.type = 31;
            EventCenter.instance.publish(hbVar);
            if (!Util.isNullOrNil(hbVar.dLn.path) && i3 == -435) {
                Log.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            bg.azz().b(v2helper.EMethodSetAgcRxOn, this);
            AppMethodBeat.o(30324);
            return;
        }
        AppMethodBeat.o(30324);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void bbO(String str) {
        this.JHb = str;
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final String gjA() {
        return this.JHb;
    }

    private String bbQ(String str) {
        AppMethodBeat.i(30325);
        com.tencent.mm.plugin.fav.a.g HT = f.HT(this.dUt);
        if (HT == null) {
            String str2 = ((o) this.JGS.get(str)).dLl;
            AppMethodBeat.o(30325);
            return str2;
        }
        Iterator<aml> it = HT.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (!Util.isNullOrNil(next.Lwp) && next.Lwp.equals(str)) {
                String str3 = next.dLl;
                AppMethodBeat.o(30325);
                return str3;
            }
        }
        String str4 = ((o) this.JGS.get(str)).dLl;
        AppMethodBeat.o(30325);
        return str4;
    }

    static /* synthetic */ void c(g gVar) {
        AppMethodBeat.i(30326);
        gVar.JGO = new m();
        gVar.JGO.qNT = gVar.tfP;
        gVar.JGO.dUt = gVar.dUt;
        gVar.JGO.dataType = 1;
        if (gVar.tfP == null || gVar.tfP.field_favProto == null) {
            AppMethodBeat.o(30326);
            return;
        }
        gVar.JGO.JHQ = gVar.JHg;
        gVar.JGO.BHs = gVar.tfP.field_favProto.ppH;
        JHc.put(gVar.tfP, gVar.JGO);
        AppMethodBeat.o(30326);
    }
}
