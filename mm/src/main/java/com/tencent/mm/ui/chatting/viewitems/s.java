package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.IOException;

public final class s {
    private static String TAG = "Finder.ChattingItemAppMsgFinderPoi";

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 1057030193) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233691);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sv);
                view.setTag(new a().N(view, true));
            }
            AppMethodBeat.o(233691);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            boolean z = false;
            AppMethodBeat.i(233692);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bck r = s.r(bVar);
                if (r != null) {
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), r.kHV));
                    aVar3.finderDesc.setText(r.tPa);
                }
                if (aVar3.clickArea != null) {
                    aVar3.clickArea.setOnClickListener(d(aVar2));
                    aVar3.clickArea.setOnLongClickListener(c(aVar2));
                    aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                    aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
                }
            }
            if (gTW()) {
                b((c.a) aVar3, false);
                if (caVar.field_status != 2 || !b((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class), caVar.field_msgId)) {
                    if (aVar3.tickIV != null) {
                        aVar3.tickIV.setVisibility(8);
                    }
                } else if (aVar3.tickIV != null) {
                    aVar3.tickIV.setVisibility(0);
                }
            } else {
                if (aVar3.tickIV != null) {
                    aVar3.tickIV.setVisibility(8);
                }
                if (caVar.field_status < 2) {
                    z = true;
                }
                b(aVar3, z);
            }
            a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(233692);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233693);
            if (caVar.dOQ()) {
                m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233693);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233694);
            int i2 = ((bq) view.getTag()).position;
            if (caVar != null) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                com.tencent.mm.br.c.aZU("favorite");
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
            }
            AppMethodBeat.o(233694);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233695);
            switch (menuItem.getItemId()) {
                case 111:
                    s.c(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233695);
                    return true;
                default:
                    AppMethodBeat.o(233695);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233696);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bck r = s.r(bVar);
            if (r != null) {
                s.a(aVar.Pwc.getContext(), caVar, r);
            }
            AppMethodBeat.o(233696);
            return false;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 1057030193) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233686);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rh);
                view.setTag(new a().N(view, false));
            }
            AppMethodBeat.o(233686);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(233687);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bck r = s.r(bVar);
                if (r != null) {
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), r.kHV));
                    aVar3.finderDesc.setText(r.tPa);
                }
                if (aVar3.clickArea != null) {
                    aVar3.clickArea.setOnClickListener(d(aVar2));
                    aVar3.clickArea.setOnLongClickListener(c(aVar2));
                    aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                    aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
                }
            }
            AppMethodBeat.o(233687);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233688);
            int i2 = ((bq) view.getTag()).position;
            if (caVar != null && com.tencent.mm.br.c.aZU("favorite")) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            AppMethodBeat.o(233688);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233689);
            switch (menuItem.getItemId()) {
                case 111:
                    s.c(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233689);
                    return true;
                default:
                    AppMethodBeat.o(233689);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233690);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bck r = s.r(bVar);
            if (r != null) {
                s.a(aVar.Pwc.getContext(), caVar, r);
            }
            AppMethodBeat.o(233690);
            return false;
        }
    }

    static class a extends c.a {
        public TextView PKo;
        public TextView finderDesc;
        public ImageView finderIcon;
        public ImageView tickIV;

        a() {
        }

        public final a N(View view, boolean z) {
            AppMethodBeat.i(233685);
            super.create(view);
            this.PKo = (TextView) view.findViewById(R.id.awe);
            this.finderIcon = (ImageView) view.findViewById(R.id.awa);
            this.finderDesc = (TextView) view.findViewById(R.id.aw_);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            if (!(!((aj) g.ah(aj.class)).showFinderEntry())) {
                this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                this.maskView = view.findViewById(R.id.ax3);
            }
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
            }
            AppMethodBeat.o(233685);
            return this;
        }
    }

    static /* synthetic */ bck r(k.b bVar) {
        AppMethodBeat.i(233697);
        com.tencent.mm.plugin.i.a.g gVar = (com.tencent.mm.plugin.i.a.g) bVar.as(com.tencent.mm.plugin.i.a.g.class);
        if (gVar != null) {
            bck bck = gVar.wDZ;
            AppMethodBeat.o(233697);
            return bck;
        }
        AppMethodBeat.o(233697);
        return null;
    }

    static /* synthetic */ void c(Activity activity, ca caVar) {
        k.b HD;
        AppMethodBeat.i(233698);
        if (!Util.isNullOrNil(caVar.field_content) && (HD = k.b.HD(caVar.field_content)) != null) {
            Intent intent = new Intent(activity, MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Type", 28);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderPoi", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderPoi", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(233698);
    }

    static /* synthetic */ void a(Context context, ca caVar, bck bck) {
        AppMethodBeat.i(233699);
        if (context == null) {
            AppMethodBeat.o(233699);
            return;
        }
        Intent intent = new Intent();
        eaa eaa = new eaa();
        eaa.LIb = bck.LIb;
        eaa.LbC = Util.safeParseFloat(bck.LLz);
        eaa.LbD = Util.safeParseFloat(bck.LLy);
        eaa.kHV = bck.kHV;
        eaa.Mpt = bck.JTr;
        eaa.ErZ = bck.iUO;
        eaa.Mpu = Util.safeParseInt(bck.LLA);
        eaa.Esb = Util.safeParseInt(bck.tPa);
        try {
            intent.putExtra("key_location", eaa.toByteArray());
        } catch (IOException e2) {
            Log.e(TAG, "location toByteArray exception");
        }
        intent.putExtra("key_from_type", y.a.FINDER_POI_FROM_TYPE_SNS);
        ((aj) g.ah(aj.class)).fillContextIdToIntent(ab.Eq(caVar.field_talker) ? 3 : 2, 11, 81, intent);
        ((aj) g.ah(aj.class)).enterFinderPoiFeedUI(context, intent);
        AppMethodBeat.o(233699);
    }
}
