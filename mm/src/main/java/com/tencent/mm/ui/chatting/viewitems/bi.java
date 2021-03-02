package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.smtt.sdk.TbsListener;

public final class bi extends c {
    private a PQg;
    private com.tencent.mm.ui.chatting.e.a PhN;
    private i onSceneEndCallback;

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == -1879048191) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37513);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.tr);
            view.setTag(new by().hk(view));
        }
        AppMethodBeat.o(37513);
        return view;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, final int i2, com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
        AppMethodBeat.i(37514);
        by byVar = (by) aVar;
        this.PhN = aVar2;
        k GL = ao.gnf().GL(caVar.field_msgId);
        String str2 = caVar.field_content;
        k.b bVar = null;
        if (!(GL == null || str2 == null)) {
            bVar = k.b.aD(str2, caVar.field_reserved);
        }
        if (bVar != null) {
            byVar.jBR.setText(bVar.description);
        }
        Log.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + caVar.field_content);
        e aSK = e.aSK(str2);
        if (aSK != null && aSK.FJZ != null && aSK.FJZ.length() > 0 && aSK.FKa > 0 && this.onSceneEndCallback == null && bVar != null && Util.isNullOrNil(caVar.field_imgPath)) {
            String Qv = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
            String cz = h.cz(Qv, false);
            caVar.Cz(Qv);
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            final String a2 = m.a(cz, caVar.field_msgId, bVar.sdkVer, bVar.appId, aSK.FJZ, aSK.FKa, bVar.type, bVar.iwM);
            if (a2 != null) {
                t azz = bg.azz();
                AnonymousClass1 r3 = new i() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bi.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(37511);
                        Log.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + i2 + " errCode " + i3 + "  scene " + qVar.getType());
                        boolean z = false;
                        if (ay.a.iDt != null) {
                            z = ay.a.iDt.Ac(caVar.field_msgId);
                        }
                        if (!z && i2 == 0 && i3 == 0 && ((f) qVar).getMediaId().equals(a2)) {
                            ((aw) bi.this.PhN.bh(aw.class)).gRx().a(i2, caVar);
                        }
                        bg.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, bi.this.onSceneEndCallback);
                        bi.this.onSceneEndCallback = null;
                        AppMethodBeat.o(37511);
                    }
                };
                this.onSceneEndCallback = r3;
                azz.a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, r3);
                f fVar = new f(a2);
                fVar.eIm();
                bg.azz().a(fVar, 0);
            }
        }
        byVar.jBR.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
        TextView textView = byVar.jBR;
        if (this.PQg == null) {
            this.PQg = new a(this.PhN);
        }
        textView.setOnClickListener(this.PQg);
        bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            byVar.jBR.setOnLongClickListener(c(aVar2));
        }
        AppMethodBeat.o(37514);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
        AppMethodBeat.i(233970);
        int i2 = ((bq) view.getTag()).position;
        if (!this.PhN.gRN()) {
            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
        }
        AppMethodBeat.o(233970);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(37516);
        menuItem.getItemId();
        AppMethodBeat.o(37516);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        return true;
    }

    class a extends t.e {
        public a(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37512);
            bq bqVar = (bq) view.getTag();
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
                AppMethodBeat.o(37512);
                return;
            }
            ((aw) this.PhN.bh(aw.class)).gRx().a(bqVar.position, bqVar.dTX);
            AppMethodBeat.o(37512);
        }
    }
}
