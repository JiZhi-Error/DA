package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class j extends d {
    private static HashMap<String, m> JHD = new HashMap<>();
    private c BHZ = null;
    private Long JHB;
    private boolean JHC = false;
    private int JHd = 0;
    private String JHe;
    private byte[] JHj = null;
    private and dLx = new and();
    private int dUh = 0;
    private boolean dUo;
    private String dVc;

    static {
        AppMethodBeat.i(30356);
        AppMethodBeat.o(30356);
    }

    public j() {
        AppMethodBeat.i(30344);
        this.JGQ.clear();
        e.cVJ();
        AppMethodBeat.o(30344);
    }

    public final void a(String str, Long l, boolean z, Context context, int i2, int i3, and and, Bundle bundle) {
        AppMethodBeat.i(232132);
        this.dVc = str;
        this.JHB = l;
        this.dUo = z;
        this.dUh = i2;
        this.JHd = i3;
        this.dLx = and;
        if (bundle != null) {
            this.JHj = bundle.getByteArray("key_multi_task_common_info");
        }
        this.BHZ = aKY(str);
        if (!(this.BHZ == null || this.BHZ.iAd == null || this.BHZ.iAd.size() <= 1)) {
            rc rcVar = new rc();
            rcVar.dXF.type = 9;
            rcVar.dXF.dKT = this.BHZ.iAd.get(0);
            rcVar.dXF.msgId = this.JHB.longValue();
            EventCenter.instance.publish(rcVar);
            this.JHC = rcVar.dXG.dXQ;
        }
        if (this.BHZ == null || this.BHZ.KBr == null) {
            this.JHe = null;
        } else {
            this.JHe = this.BHZ.KBr.LxT + ";" + this.BHZ.KBr.LxU + ";" + this.BHZ.rnM;
        }
        ig(context);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.wenote.model.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(30342);
                j.a(j.this);
                j.this.iq(j.this.JGO.BHs);
                if (k.gjR() != null) {
                    k.gjV();
                }
                AppMethodBeat.o(30342);
            }

            public final String toString() {
                AppMethodBeat.i(30343);
                String str = super.toString() + "|dealWNoteInfo";
                AppMethodBeat.o(30343);
                return str;
            }
        });
        AppMethodBeat.o(232132);
    }

    private void ig(Context context) {
        AppMethodBeat.i(30346);
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", 1);
        intent.putExtra("edit_status", this.JGV);
        intent.putExtra("note_msgid", this.JHB);
        intent.putExtra("record_show_share", this.dUo);
        intent.putExtra("fav_note_xml", this.dVc);
        intent.putExtra("fav_note_out_of_date", this.JHC);
        intent.putExtra("fav_note_scroll_to_position", this.dUh);
        intent.putExtra("fav_note_scroll_to_offset", this.JHd);
        intent.putExtra("fav_note_scroll_to_offset", this.JHd);
        if (!Util.isNullOrNil(this.JHe)) {
            intent.putExtra("fav_note_link_source_info", this.JHe);
        }
        intent.putExtra("key_detail_fav_scene", this.dLx.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
        intent.putExtra("key_detail_fav_index", this.dLx.index);
        intent.putExtra("key_multi_task_common_info", this.JHj);
        com.tencent.mm.br.c.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        AppMethodBeat.o(30346);
    }

    private static c aKY(String str) {
        AppMethodBeat.i(30347);
        rc rcVar = new rc();
        rcVar.dXF.type = 0;
        rcVar.dXF.dXH = str;
        EventCenter.instance.publish(rcVar);
        c cVar = rcVar.dXG.dXP;
        AppMethodBeat.o(30347);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final String d(aml aml) {
        AppMethodBeat.i(30348);
        rc rcVar = new rc();
        rcVar.dXF.type = 1;
        rcVar.dXF.dKT = aml;
        rcVar.dXF.msgId = this.JHB.longValue();
        EventCenter.instance.publish(rcVar);
        String str = rcVar.dXG.dataPath;
        AppMethodBeat.o(30348);
        return str;
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final String a(aml aml) {
        AppMethodBeat.i(30349);
        rc rcVar = new rc();
        rcVar.dXF.type = 1;
        rcVar.dXF.dKT = aml;
        rcVar.dXF.msgId = this.JHB.longValue();
        EventCenter.instance.publish(rcVar);
        String str = rcVar.dXG.thumbPath;
        AppMethodBeat.o(30349);
        return str;
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void p(aml aml) {
        AppMethodBeat.i(30350);
        rc rcVar = new rc();
        rcVar.dXF.type = 8;
        rcVar.dXF.dKT = aml;
        rcVar.dXF.msgId = this.JHB.longValue();
        rcVar.dXF.thumbPath = "";
        EventCenter.instance.publish(rcVar);
        AppMethodBeat.o(30350);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void a(aml aml, String str) {
        AppMethodBeat.i(30351);
        rc rcVar = new rc();
        rcVar.dXF.type = 8;
        rcVar.dXF.dKT = aml;
        rcVar.dXF.msgId = this.JHB.longValue();
        rcVar.dXF.thumbPath = str;
        EventCenter.instance.publish(rcVar);
        AppMethodBeat.o(30351);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void bX(Context context, String str) {
        AppMethodBeat.i(30352);
        Intent intent = new Intent();
        intent.putExtra("message_id", this.JHB);
        intent.putExtra("record_xml", this.dVc);
        intent.putExtra("record_data_id", ((o) this.JGS.get(str)).dLl);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgFileUI", intent);
        AppMethodBeat.o(30352);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void bZ(Context context, String str) {
        AppMethodBeat.i(30353);
        Intent intent = new Intent();
        intent.putExtra("message_id", this.JHB);
        intent.putExtra("record_data_id", ((o) this.JGS.get(str)).dLl);
        intent.putExtra("record_xml", this.dVc);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgImageUI", intent);
        AppMethodBeat.o(30353);
    }

    @Override // com.tencent.mm.plugin.wenote.model.d
    public final void bY(Context context, String str) {
        amn amn;
        String str2 = null;
        AppMethodBeat.i(30354);
        aml aml = ((o) this.JGS.get(str)).qPM;
        if (aml.Lwh != null) {
            amn = aml.Lwh.LwO;
        } else {
            amn = null;
        }
        if (amn != null) {
            if (!Util.isNullOrNil(amn.LxA)) {
                str2 = aa.getDisplayName(amn.LxA);
            } else {
                str2 = aa.getDisplayName(amn.dRL);
            }
        }
        s sVar = (s) this.JGS.get(str);
        if (sVar == null) {
            h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.cbb));
            AppMethodBeat.o(30354);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", sVar.lat);
        intent.putExtra("kwebmap_lng", sVar.lng);
        intent.putExtra("kPoiName", sVar.kHV);
        intent.putExtra("Kwebmap_locaion", sVar.iUO);
        if (sVar.JIb >= 0.0d) {
            intent.putExtra("kwebmap_scale", sVar.JIb);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(30354);
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(30355);
        if (JHD.containsKey(jVar.dVc)) {
            jVar.JGO = JHD.get(jVar.dVc);
            AppMethodBeat.o(30355);
            return;
        }
        jVar.JGO = new m();
        jVar.JGO.msgId = jVar.JHB.longValue();
        jVar.JGO.JHN = jVar.dVc;
        if (jVar.BHZ == null || jVar.BHZ.iAd == null) {
            AppMethodBeat.o(30355);
            return;
        }
        if (jVar.BHZ.KBr != null) {
            jVar.JGO.JHP = jVar.BHZ.KBr.LxU;
            jVar.JGO.JHO = jVar.BHZ.KBr.LxT;
            jVar.JGO.JHQ = jVar.BHZ.rnM;
        }
        jVar.JGO.BHs = jVar.BHZ.iAd;
        jVar.JGO.dataType = 0;
        JHD.put(jVar.dVc, jVar.JGO);
        AppMethodBeat.o(30355);
    }
}
