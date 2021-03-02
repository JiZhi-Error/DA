package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.g;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.LinkedList;

public final class aw {

    public static class b extends c implements t.n {
        protected c POi;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 48) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37348);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.td);
                view.setTag(new d().G(view, false));
            }
            AppMethodBeat.o(37348);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37349);
            this.PhN = aVar2;
            d dVar = (d) aVar;
            if (this.POi == null) {
                this.POi = new c(aVar2);
            }
            d.a(dVar, caVar, false, i2, aVar2, this.POi, c(aVar2));
            d dVar2 = (d) aVar;
            if (gTW()) {
                if (caVar.field_status != 2 || !b((k) aVar2.bh(k.class), caVar.field_msgId)) {
                    if (dVar2.PIn != null) {
                        dVar2.PIn.setVisibility(8);
                    }
                } else if (dVar2.PIn != null) {
                    dVar2.PIn.setVisibility(0);
                }
            }
            a(i2, dVar2, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(37349);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233917);
            if (caVar.getType() == 48) {
                int i2 = ((bq) view.getTag()).position;
                if (caVar.field_status == 5) {
                    mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                }
                mVar.a(i2, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                if (g.aZK() && !this.PhN.gRN()) {
                    mVar.add(i2, 114, 0, view.getContext().getString(R.string.b02));
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = caVar.field_msgId;
                EventCenter.instance.publish(efVar);
                if (efVar.dHz.dGX || h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                    mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (!caVar.gAt() && caVar.dOS() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                }
            }
            AppMethodBeat.o(233917);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37351);
            switch (menuItem.getItemId()) {
                case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH /*{ENCODED_INT: 127}*/:
                    if (caVar.dOS()) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(caVar);
                        l.a(aVar.Pwc.getContext(), linkedList, aVar.gRM(), aVar.GUe.field_username, null);
                    }
                    AppMethodBeat.o(37351);
                    return true;
                default:
                    AppMethodBeat.o(37351);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233918);
            caVar.unsetOmittedFailResend();
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            ((ad) aVar.bh(ad.class)).bU(caVar);
            AppMethodBeat.o(233918);
        }
    }

    public static class a extends c {
        protected c POi;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 48) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37344);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s0);
                view.setTag(new d().G(view, true));
            }
            AppMethodBeat.o(37344);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37345);
            this.PhN = aVar2;
            d dVar = (d) aVar;
            if (this.POi == null) {
                this.POi = new c(aVar2);
            }
            d.a(dVar, caVar, true, i2, aVar2, this.POi, c(aVar2));
            AppMethodBeat.o(37345);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233916);
            if (caVar.getType() == 48) {
                int i2 = ((bq) view.getTag()).position;
                mVar.a(i2, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                if (g.aZK() && !this.PhN.gRN()) {
                    mVar.add(i2, 114, 0, view.getContext().getString(R.string.b02));
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = caVar.field_msgId;
                EventCenter.instance.publish(efVar);
                if (efVar.dHz.dGX || h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                    mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                }
            }
            AppMethodBeat.o(233916);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37347);
            switch (menuItem.getItemId()) {
                case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH /*{ENCODED_INT: 127}*/:
                    if (caVar.dOS()) {
                        if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(aVar.Pwc.getContext())) {
                            AppMethodBeat.o(37347);
                            return true;
                        }
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(caVar);
                        l.a(aVar.Pwc.getContext(), linkedList, aVar.gRM(), aVar.GUe.field_username, null);
                    }
                    AppMethodBeat.o(37347);
                    return true;
                case 128:
                default:
                    AppMethodBeat.o(37347);
                    return false;
                case 129:
                    Intent intent = new Intent(aVar.Pwc.getContext(), ChattingSendDataToDeviceUI.class);
                    intent.putExtra("exdevice_open_scene_type", 1);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    Activity context = aVar.Pwc.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37347);
                    return true;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    static class d extends c.a {
        ImageView PIn;
        TextView PNK;
        LinearLayout POk;
        TextView POl;
        ProgressBar POm;
        ImageView POn;
        ProgressBar POo;
        ImageView POp;

        d() {
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(37357);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PNK = (TextView) view.findViewById(R.id.awz);
            this.POl = (TextView) view.findViewById(R.id.ax1);
            this.POk = (LinearLayout) view.findViewById(R.id.ax0);
            this.POm = (ProgressBar) view.findViewById(R.id.aww);
            this.clickArea = view.findViewById(R.id.auf);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.POn = (ImageView) view.findViewById(R.id.awy);
            this.POo = (ProgressBar) view.findViewById(R.id.awx);
            this.POp = (ImageView) view.findViewById(R.id.auo);
            if (!z) {
                this.stateIV = (ImageView) view.findViewById(R.id.ayb);
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
            }
            this.POl.setTextSize(1, 16.0f);
            this.PNK.setTextSize(1, 12.0f);
            view.findViewById(R.id.f_t).setVisibility(ao.isDarkMode() ? 0 : 8);
            AppMethodBeat.o(37357);
            return this;
        }

        public static void a(d dVar, ca caVar, boolean z, int i2, com.tencent.mm.ui.chatting.e.a aVar, c cVar, View.OnLongClickListener onLongClickListener) {
            AppMethodBeat.i(37358);
            if (dVar == null) {
                AppMethodBeat.o(37358);
                return;
            }
            dVar.POk.setVisibility(8);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 236);
            int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 90);
            dVar.POl.setMaxLines(1);
            dVar.PNK.setMaxLines(1);
            dVar.PNK.setText("");
            if (com.tencent.mm.br.c.aZU(FirebaseAnalytics.b.LOCATION)) {
                Log.d("MicroMsg.LocationItemHolder", "plugin found!");
                ly lyVar = new ly();
                lyVar.dRv.dRq = 1;
                lyVar.dRv.dCM = caVar;
                EventCenter.instance.publish(lyVar);
                String str = lyVar.dRw.dNk;
                String str2 = lyVar.dRw.dRy;
                if ((str != null || b(str2, aVar)) && ((str == null || !str.equals("") || b(str2, aVar)) && (str == null || !str.equals("err_not_started")))) {
                    dVar.POo.setVisibility(8);
                    dVar.POk.setVisibility(0);
                    Log.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(str)));
                    if (b(str2, aVar)) {
                        dVar.POl.setVisibility(0);
                        dVar.POl.setText(str2);
                        if (str == null || str.equals("")) {
                            dVar.PNK.setVisibility(8);
                        } else {
                            dVar.PNK.setVisibility(0);
                            dVar.PNK.setText(str);
                        }
                    } else {
                        dVar.POl.setMaxLines(2);
                        dVar.POl.setText(String.valueOf(str));
                        dVar.PNK.setVisibility(8);
                    }
                } else {
                    Log.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
                    dVar.POo.setVisibility(8);
                    dVar.POk.setVisibility(0);
                    dVar.POl.setText(R.string.ekg);
                    dVar.PNK.setText("");
                }
            } else {
                dVar.POm.setVisibility(0);
                dVar.POk.setVisibility(8);
            }
            dVar.POn.setImageBitmap(q.bcR().m(fromDPToPix, fromDPToPix2, z));
            kg kgVar = new kg();
            kgVar.dPi.dCM = caVar;
            kgVar.dPi.w = fromDPToPix;
            kgVar.dPi.f1455h = fromDPToPix2;
            kgVar.dPi.dPn = R.drawable.cg5;
            kgVar.dPi.dPk = dVar.POn;
            kgVar.dPi.dPm = dVar.POm;
            kgVar.dPi.dPl = dVar.POp;
            EventCenter.instance.publish(kgVar);
            dVar.clickArea.setTag(new bq(caVar, aVar.gRM(), i2, (String) null, (char) 0));
            dVar.clickArea.setOnClickListener(cVar);
            dVar.clickArea.setOnLongClickListener(onLongClickListener);
            dVar.clickArea.setOnTouchListener(((k) aVar.bh(k.class)).gOC());
            AppMethodBeat.o(37358);
        }

        private static boolean b(String str, com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37359);
            if (str == null || str.equals("") || str.equals(aVar.Pwc.getMMResources().getString(R.string.el0))) {
                AppMethodBeat.o(37359);
                return false;
            }
            AppMethodBeat.o(37359);
            return true;
        }
    }

    public static class c extends t.e {
        private int scene;

        public c(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
            this.scene = 0;
        }

        public c(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            super(aVar);
            AppMethodBeat.i(37354);
            this.scene = 0;
            this.scene = 1;
            if (this.scene == 1) {
                b(new bq(caVar, this.PhN.gRM(), 0, (String) null, (char) 0));
            }
            AppMethodBeat.o(37354);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37355);
            if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(view.getContext())) {
                AppMethodBeat.o(37355);
                return;
            }
            b((bq) view.getTag());
            AppMethodBeat.o(37355);
        }

        private void b(bq bqVar) {
            String str;
            String str2;
            int Kp;
            AppMethodBeat.i(37356);
            ca caVar = bqVar.dTX;
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str3 = caVar.field_content;
            boolean z = caVar.field_isSend == 0;
            String str4 = "";
            if (z) {
                str4 = caVar.field_talker;
            }
            if (!ab.Eq(caVar.field_talker) || !z || ((com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP() || (Kp = bp.Kp(str3)) == -1) {
                str = str3;
            } else {
                str4 = str3.substring(0, Kp).trim();
                str = str3.substring(Kp + 1).trim();
            }
            bg.aVF();
            ca.b aEL = com.tencent.mm.model.c.aSQ().aEL(str);
            if (af.isNullOrNil(str4) || !ab.Eq(str4)) {
                str2 = str4;
            } else {
                str2 = "";
            }
            ly lyVar = new ly();
            lyVar.dRv.dRq = 1;
            lyVar.dRv.dCM = caVar;
            EventCenter.instance.publish(lyVar);
            String str5 = lyVar.dRw.dNk;
            if (!af.isNullOrNil(aEL.kHV) || aEL.gEb()) {
                Intent intent = new Intent();
                intent.putExtra("kMsgId", caVar.field_msgId);
                intent.putExtra("map_view_type", 1);
                intent.putExtra("kwebmap_slat", aEL.yFu);
                intent.putExtra("kwebmap_lng", aEL.yFv);
                intent.putExtra("kwebmap_scale", aEL.dRt);
                intent.putExtra("kPoiName", aEL.kHV);
                intent.putExtra("kisUsername", aa.getDisplayName(str2));
                intent.putExtra("Kwebmap_locaion", str5);
                bg.aVF();
                intent.putExtra("kimg_path", com.tencent.mm.model.c.aSY());
                intent.putExtra("map_talker_name", caVar.field_talker);
                intent.putExtra("view_type_key", 0);
                intent.putExtra("kwebmap_from_to", true);
                intent.putExtra("kPoi_url", aEL.JTr);
                intent.putExtra("kPoiid", aEL.yFB);
                intent.putExtra("soso_street_view_url", af.nullAs(caVar.field_reserved, ""));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12809, 2, "");
                com.tencent.mm.br.c.a(this.PhN.Pwa, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 2002, new c.a() {
                    /* class com.tencent.mm.ui.chatting.viewitems.aw.c.AnonymousClass1 */

                    @Override // com.tencent.mm.br.c.a
                    public final void onActivityResult(int i2, int i3, Intent intent) {
                        AppMethodBeat.i(37353);
                        switch (i2) {
                            case 2002:
                                if (intent != null) {
                                    if (intent.getBooleanExtra("kfavorite", false)) {
                                        cz czVar = new cz();
                                        com.tencent.mm.pluginsdk.model.h.a(czVar, intent);
                                        czVar.dFZ.fragment = c.this.PhN.Pwc;
                                        czVar.dFZ.dGf = 42;
                                        EventCenter.instance.publish(czVar);
                                        break;
                                    }
                                } else {
                                    Log.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", Integer.valueOf(i2), Integer.valueOf(i3));
                                    AppMethodBeat.o(37353);
                                    return;
                                }
                                break;
                        }
                        AppMethodBeat.o(37353);
                    }
                });
                AppMethodBeat.o(37356);
                return;
            }
            Log.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", aEL.kHV, Boolean.valueOf(aEL.gEb()));
            AppMethodBeat.o(37356);
        }
    }
}
