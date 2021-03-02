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
import com.tencent.mm.ac.d;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.IOException;

public final class m {
    private static e Aer;
    private static String TAG = "Finder.ChattingItemAppMsgFinderTopic";

    static {
        AppMethodBeat.i(233645);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        Aer = aVar.aJT();
        AppMethodBeat.o(233645);
    }

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 1023475761 && i2 != 1023541297)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233636);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sw);
                view.setTag(new a().I(view, true));
            }
            AppMethodBeat.o(233636);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String str2;
            boolean z = false;
            AppMethodBeat.i(233637);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str3 = caVar.field_content;
            k.b bVar = null;
            if (str3 != null) {
                bVar = k.b.aD(str3, caVar.field_reserved);
            }
            if (bVar != null) {
                bcl p = m.p(bVar);
                if (!(p == null || p.LLD == null)) {
                    if (p.tvC == 7) {
                        str2 = MMApplicationContext.getContext().getString(R.string.chi, p.LLD.LAr, p.LLD.LAq);
                        aVar3.VlK.setText(MMApplicationContext.getContext().getText(R.string.j_6));
                    } else {
                        str2 = p.dST;
                    }
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), str2));
                    if (Util.isNullOrNil(p.iconUrl)) {
                        aVar3.finderIcon.setVisibility(4);
                    } else {
                        aVar3.finderIcon.setVisibility(0);
                        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
                        com.tencent.mm.loader.e.aJs().a(p.iconUrl, aVar3.finderIcon, m.Aer);
                    }
                    aVar3.finderDesc.setText(p.desc);
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
            AppMethodBeat.o(233637);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233638);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233638);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233639);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                com.tencent.mm.br.c.aZU("favorite");
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
            }
            AppMethodBeat.o(233639);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233640);
            switch (menuItem.getItemId()) {
                case 111:
                    m.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233640);
                    return true;
                default:
                    AppMethodBeat.o(233640);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233641);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bcl p = m.p(bVar);
            if (p != null) {
                m.a(aVar.Pwc.getContext(), caVar, p);
            }
            AppMethodBeat.o(233641);
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
            if (z || (i2 != 1023475761 && i2 != 1023541297)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233631);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.ri);
                view.setTag(new a().I(view, false));
            }
            AppMethodBeat.o(233631);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            String str2;
            AppMethodBeat.i(233632);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str3 = caVar.field_content;
            if (str3 != null) {
                bVar = k.b.aD(str3, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bcl p = m.p(bVar);
                if (!(p == null || p.LLD == null)) {
                    if (p.tvC == 7) {
                        str2 = MMApplicationContext.getContext().getString(R.string.chi, p.LLD.LAr, p.LLD.LAq);
                        aVar3.VlK.setText(MMApplicationContext.getContext().getText(R.string.j_6));
                    } else {
                        str2 = p.dST;
                    }
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), str2));
                    if (Util.isNullOrNil(p.iconUrl)) {
                        aVar3.finderIcon.setVisibility(4);
                    } else {
                        aVar3.finderIcon.setVisibility(0);
                        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
                        com.tencent.mm.loader.e.aJs().a(p.iconUrl, aVar3.finderIcon, m.Aer);
                    }
                    aVar3.finderDesc.setText(p.desc);
                }
                if (aVar3.clickArea != null) {
                    aVar3.clickArea.setOnClickListener(d(aVar2));
                    aVar3.clickArea.setOnLongClickListener(c(aVar2));
                    aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                    aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
                }
            }
            AppMethodBeat.o(233632);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233633);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && com.tencent.mm.br.c.aZU("favorite") && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            AppMethodBeat.o(233633);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233634);
            switch (menuItem.getItemId()) {
                case 111:
                    m.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233634);
                    return true;
                default:
                    AppMethodBeat.o(233634);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233635);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bcl p = m.p(bVar);
            if (p != null) {
                m.a(aVar.Pwc.getContext(), caVar, p);
            }
            AppMethodBeat.o(233635);
            return false;
        }
    }

    static class a extends c.a {
        public TextView PKo;
        public TextView VlK;
        public TextView finderDesc;
        public ImageView finderIcon;
        public ImageView tickIV;

        a() {
        }

        public final a I(View view, boolean z) {
            AppMethodBeat.i(233630);
            super.create(view);
            this.PKo = (TextView) view.findViewById(R.id.awe);
            this.finderIcon = (ImageView) view.findViewById(R.id.awg);
            this.finderDesc = (TextView) view.findViewById(R.id.awf);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.VlK = (TextView) view.findViewById(R.id.jts);
            if (!(!((aj) g.ah(aj.class)).showFinderEntry())) {
                this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                this.maskView = view.findViewById(R.id.ax3);
            }
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
            }
            AppMethodBeat.o(233630);
            return this;
        }
    }

    static /* synthetic */ bcl p(k.b bVar) {
        AppMethodBeat.i(233642);
        com.tencent.mm.plugin.i.a.c cVar = (com.tencent.mm.plugin.i.a.c) bVar.as(com.tencent.mm.plugin.i.a.c.class);
        if (cVar != null) {
            bcl bcl = cVar.jld;
            AppMethodBeat.o(233642);
            return bcl;
        }
        AppMethodBeat.o(233642);
        return null;
    }

    static /* synthetic */ void b(Activity activity, ca caVar) {
        k.b HD;
        AppMethodBeat.i(233643);
        if (!Util.isNullOrNil(caVar.field_content) && (HD = k.b.HD(caVar.field_content)) != null) {
            Intent intent = new Intent(activity, MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Type", 27);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderActivity", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderActivity", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(233643);
    }

    static /* synthetic */ void a(Context context, ca caVar, bcl bcl) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(233644);
        Intent intent = new Intent();
        intent.putExtra("key_topic_title", bcl.dST);
        intent.putExtra("key_topic_type", bcl.tvC);
        if (bcl.tvC == 4) {
            intent.putExtra("KEY_FOLLOW_ID", bcl.LLC);
        } else if (bcl.tvC == 7 && bcl.LLD != null) {
            intent.putExtra("key_activity_name", bcl.LLD.LAq);
            intent.putExtra("key_activity_id", d.Ga(bcl.LLD.LAp));
            intent.putExtra("key_nick_name", bcl.LLD.LAr);
            intent.putExtra("key_cover_url", bcl.iconUrl);
        }
        axt axt = new axt();
        if (bcl.LLB != null) {
            axt.LIb = bcl.LLB.LIb;
            axt.dTj = bcl.LLB.dTj;
            axt.latitude = bcl.LLB.latitude;
            try {
                intent.putExtra("key_topic_poi_location", axt.toByteArray());
            } catch (IOException e2) {
                Log.e(TAG, "location toByteArray exception");
            }
        }
        intent.putExtra("key_finder_teen_mode_check", true);
        intent.putExtra("key_from_user", caVar.field_talker);
        if (ab.Eq(caVar.field_talker)) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        intent.putExtra("key_report_scene", i2);
        intent.putExtra("KEY_TAB_TYPE", 6);
        if (ab.Eq(caVar.field_talker)) {
            intent.putExtra("key_finder_teen_mode_scene", 2);
        } else {
            intent.putExtra("key_finder_teen_mode_scene", 1);
        }
        intent.putExtra("key_finder_teen_mode_user_name", "");
        intent.putExtra("key_finder_teen_mode_user_id", "");
        switch (bcl.tvC) {
            case 7:
                i3 = 59;
                break;
            default:
                i3 = 22;
                break;
        }
        aj ajVar = (aj) g.ah(aj.class);
        if (ab.Eq(caVar.field_talker)) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        ajVar.fillContextIdToIntent(i4, 2, i3, intent);
        ((aj) g.ah(aj.class)).enterFinderActivityProfileUI(context, intent);
        AppMethodBeat.o(233644);
    }
}
