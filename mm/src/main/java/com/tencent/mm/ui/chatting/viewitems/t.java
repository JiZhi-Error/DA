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
import com.tencent.mm.loader.c.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.h;
import com.tencent.mm.pluginsdk.model.app.m;
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

public final class t {
    private static e Aer;
    private static String TAG = "Finder.ChattingItemAppMsgFinderTopic";

    static /* synthetic */ bcl p(k.b bVar) {
        AppMethodBeat.i(163376);
        bcl s = s(bVar);
        AppMethodBeat.o(163376);
        return s;
    }

    static {
        AppMethodBeat.i(163379);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        Aer = aVar.aJT();
        AppMethodBeat.o(163379);
    }

    private static bcl s(k.b bVar) {
        AppMethodBeat.i(233703);
        h hVar = (h) bVar.as(h.class);
        if (hVar != null) {
            bcl bcl = hVar.jld;
            AppMethodBeat.o(233703);
            return bcl;
        }
        AppMethodBeat.o(233703);
        return null;
    }

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 838860849 && i2 != 1006633009)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163370);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sw);
                view.setTag(new a().O(view, true));
            }
            AppMethodBeat.o(163370);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String str2;
            boolean z = false;
            AppMethodBeat.i(163371);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str3 = caVar.field_content;
            k.b bVar = null;
            if (str3 != null) {
                bVar = k.b.aD(str3, caVar.field_reserved);
            }
            if (bVar != null) {
                bcl p = t.p(bVar);
                if (p != null) {
                    if (p.tvC == 1) {
                        str2 = MMApplicationContext.getContext().getString(R.string.dag, p.dST);
                    } else {
                        str2 = p.dST;
                    }
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), str2));
                    com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
                    com.tencent.mm.loader.e.aJs().a(p.iconUrl, aVar3.finderIcon, t.Aer);
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
            AppMethodBeat.o(163371);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233701);
            if (caVar.dOQ()) {
                m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233701);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233702);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                com.tencent.mm.br.c.aZU("favorite");
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
            }
            AppMethodBeat.o(233702);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163374);
            switch (menuItem.getItemId()) {
                case 111:
                    t.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(163374);
                    return true;
                default:
                    AppMethodBeat.o(163374);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163375);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bcl p = t.p(bVar);
            if (p != null) {
                t.a(aVar.Pwc.getContext(), caVar, p);
            }
            AppMethodBeat.o(163375);
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
            if (z || (i2 != 838860849 && i2 != 1006633009)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163365);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.ri);
                view.setTag(new a().O(view, false));
            }
            AppMethodBeat.o(163365);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            String str2;
            AppMethodBeat.i(163366);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str3 = caVar.field_content;
            if (str3 != null) {
                bVar = k.b.aD(str3, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bcl p = t.p(bVar);
                if (p != null) {
                    if (p.tvC == 1) {
                        str2 = MMApplicationContext.getContext().getString(R.string.dag, p.dST);
                    } else {
                        str2 = p.dST;
                    }
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), str2));
                    com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
                    com.tencent.mm.loader.e.aJs().a(p.iconUrl, aVar3.finderIcon, t.Aer);
                    aVar3.finderDesc.setText(p.desc);
                }
                if (aVar3.clickArea != null) {
                    aVar3.clickArea.setOnClickListener(d(aVar2));
                    aVar3.clickArea.setOnLongClickListener(c(aVar2));
                    aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                    aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
                }
            }
            AppMethodBeat.o(163366);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233700);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && com.tencent.mm.br.c.aZU("favorite") && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            AppMethodBeat.o(233700);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163368);
            switch (menuItem.getItemId()) {
                case 111:
                    t.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(163368);
                    return true;
                default:
                    AppMethodBeat.o(163368);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163369);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bcl p = t.p(bVar);
            if (p != null) {
                t.a(aVar.Pwc.getContext(), caVar, p);
            }
            AppMethodBeat.o(163369);
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

        public final a O(View view, boolean z) {
            AppMethodBeat.i(163364);
            super.create(view);
            this.PKo = (TextView) view.findViewById(R.id.awe);
            this.finderIcon = (ImageView) view.findViewById(R.id.awg);
            this.finderDesc = (TextView) view.findViewById(R.id.awf);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            if (!(!((aj) g.ah(aj.class)).showFinderEntry())) {
                this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                this.maskView = view.findViewById(R.id.ax3);
            }
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
            }
            AppMethodBeat.o(163364);
            return this;
        }
    }

    static /* synthetic */ void b(Activity activity, ca caVar) {
        k.b HD;
        AppMethodBeat.i(163377);
        if (!Util.isNullOrNil(caVar.field_content) && (HD = k.b.HD(caVar.field_content)) != null) {
            int i2 = 21;
            if (s(HD).tvC == 4) {
                i2 = 25;
            }
            Intent intent = new Intent(activity, MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Type", i2);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderTopic", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderTopic", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(163377);
    }

    static /* synthetic */ void a(Context context, ca caVar, bcl bcl) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(233704);
        Intent intent = new Intent();
        intent.putExtra("key_topic_title", bcl.dST);
        intent.putExtra("key_topic_type", bcl.tvC);
        if (bcl.tvC == 4) {
            intent.putExtra("KEY_FOLLOW_ID", bcl.LLC);
        }
        axt axt = new axt();
        axt.LIb = bcl.LLB.LIb;
        axt.dTj = bcl.LLB.dTj;
        axt.latitude = bcl.LLB.latitude;
        try {
            intent.putExtra("key_topic_poi_location", axt.toByteArray());
        } catch (IOException e2) {
            Log.e(TAG, "location toByteArray exception");
        }
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
        intent.putExtra("key_finder_teen_mode_check", true);
        intent.putExtra("key_finder_teen_mode_user_name", "");
        intent.putExtra("key_finder_teen_mode_user_id", "");
        switch (bcl.tvC) {
            case 1:
                i3 = 22;
                break;
            case 2:
                i3 = 26;
                break;
            case 3:
            default:
                i3 = 22;
                break;
            case 4:
                i3 = 49;
                break;
        }
        aj ajVar = (aj) g.ah(aj.class);
        if (ab.Eq(caVar.field_talker)) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        ajVar.fillContextIdToIntent(i4, 2, i3, intent);
        ((aj) g.ah(aj.class)).enterFinderTopicUI(context, intent);
        AppMethodBeat.o(233704);
    }
}
