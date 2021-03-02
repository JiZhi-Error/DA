package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import com.tencent.mm.loader.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class r {

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 771751985) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163357);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.su);
                view.setTag(new a().M(view, true));
            }
            AppMethodBeat.o(163357);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(163358);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            k.b bVar = null;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar != null) {
                e eVar = (e) bVar.as(e.class);
                if (eVar != null) {
                    m mVar = m.uJa;
                    d<o> dka = m.dka();
                    p pVar = new p(eVar.uNR, x.THUMB_IMAGE);
                    ImageView imageView = aVar3.gyr;
                    m mVar2 = m.uJa;
                    dka.a(pVar, imageView, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    aVar3.gvw.setText(l.c(aVar2.Pwc.getContext(), eVar.nickname));
                    int i3 = eVar.wDY;
                    if (i3 > 0) {
                        aVar3.vMF.setVisibility(0);
                        switch (i3) {
                            case 1:
                                if (eVar.authIconUrl.isEmpty()) {
                                    aVar3.vMF.setImageDrawable(ar.m(aVar2.Pwc.getContext(), R.raw.icons_filled_star_identify, aVar2.Pwc.getMMResources().getColor(R.color.Orange)));
                                    break;
                                } else {
                                    m mVar3 = m.uJa;
                                    d<o> djY = m.djY();
                                    p pVar2 = new p(eVar.authIconUrl, x.FULL_IMAGE);
                                    ImageView imageView2 = aVar3.vMF;
                                    m mVar4 = m.uJa;
                                    djY.a(pVar2, imageView2, m.a(m.a.TIMELINE));
                                    break;
                                }
                            case 2:
                                aVar3.vMF.setImageResource(R.raw.icons_filled_star_identify_enterprise);
                                break;
                            case 100:
                                aVar3.vMF.setVisibility(8);
                                break;
                        }
                    } else {
                        aVar3.vMF.setVisibility(8);
                    }
                    if (i3 != 1 || Util.isNullOrNil(eVar.wDX)) {
                        aVar3.vMG.setVisibility(8);
                    } else {
                        aVar3.vMG.setVisibility(0);
                        aVar3.vMG.setText(eVar.wDX);
                    }
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
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
                b(aVar3, caVar.field_status < 2);
            }
            a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(163358);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233683);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233683);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233684);
            int i2 = ((bq) view.getTag()).position;
            if (caVar != null) {
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
                mVar.a(i2, 111, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            AppMethodBeat.o(233684);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163361);
            switch (menuItem.getItemId()) {
                case 111:
                    r.d(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(163361);
                    return true;
                default:
                    AppMethodBeat.o(163361);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            e eVar;
            int i2 = 2;
            AppMethodBeat.i(163362);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (eVar = (e) bVar.as(e.class)) == null || Util.isNullOrNil(eVar.username))) {
                Intent intent = new Intent();
                if (ab.Eq(caVar.field_talker)) {
                    intent.putExtra("key_finder_teen_mode_scene", 2);
                    intent.putExtra("key_from_profile_share_scene", 2);
                } else {
                    intent.putExtra("key_finder_teen_mode_scene", 1);
                    intent.putExtra("key_from_profile_share_scene", 1);
                }
                aj ajVar = (aj) g.ah(aj.class);
                if (ab.Eq(caVar.field_talker)) {
                    i2 = 3;
                }
                ajVar.fillContextIdToIntent(i2, 3, 32, intent);
                intent.putExtra("key_enter_profile_type", 4);
                intent.putExtra("key_comment_scene", 11);
                intent.putExtra("from_user", caVar.field_talker);
                intent.putExtra("finder_username", eVar.username);
                intent.putExtra("key_finder_teen_mode_check", true);
                intent.putExtra("key_finder_teen_mode_user_name", eVar.nickname);
                intent.putExtra("key_finder_teen_mode_user_id", eVar.username);
                ((aj) g.ah(aj.class)).enterFinderProfileUI(aVar.Pwc.getContext(), intent);
            }
            AppMethodBeat.o(163362);
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
            if (z || i2 != 771751985) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163353);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rg);
                view.setTag(new a().M(view, false));
            }
            AppMethodBeat.o(163353);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(163354);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            k.b bVar = null;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar != null) {
                e eVar = (e) bVar.as(e.class);
                if (eVar != null) {
                    m mVar = m.uJa;
                    d<o> dka = m.dka();
                    p pVar = new p(eVar.uNR, x.THUMB_IMAGE);
                    ImageView imageView = aVar3.gyr;
                    m mVar2 = m.uJa;
                    dka.a(pVar, imageView, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    aVar3.gvw.setText(l.c(aVar2.Pwc.getContext(), eVar.nickname));
                    int i3 = eVar.wDY;
                    if (i3 > 0) {
                        aVar3.vMF.setVisibility(0);
                        switch (i3) {
                            case 1:
                                if (eVar.authIconUrl.isEmpty()) {
                                    aVar3.vMF.setImageDrawable(ar.m(aVar2.Pwc.getContext(), R.raw.icons_filled_star_identify, aVar2.Pwc.getMMResources().getColor(R.color.Orange)));
                                    break;
                                } else {
                                    m mVar3 = m.uJa;
                                    d<o> djY = m.djY();
                                    p pVar2 = new p(eVar.authIconUrl, x.FULL_IMAGE);
                                    ImageView imageView2 = aVar3.vMF;
                                    m mVar4 = m.uJa;
                                    djY.a(pVar2, imageView2, m.a(m.a.TIMELINE));
                                    break;
                                }
                            case 2:
                                aVar3.vMF.setImageResource(R.raw.icons_filled_star_identify_enterprise);
                                break;
                            case 100:
                                aVar3.vMF.setVisibility(8);
                                break;
                        }
                    } else {
                        aVar3.vMF.setVisibility(8);
                    }
                    if (i3 != 1 || Util.isNullOrNil(eVar.wDX)) {
                        aVar3.vMG.setVisibility(8);
                    } else {
                        aVar3.vMG.setVisibility(0);
                        aVar3.vMG.setText(eVar.wDX);
                    }
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            AppMethodBeat.o(163354);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233682);
            mVar.a(0, 111, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
            AppMethodBeat.o(233682);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163355);
            switch (menuItem.getItemId()) {
                case 111:
                    r.d(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(163355);
                    return true;
                default:
                    AppMethodBeat.o(163355);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            e eVar;
            int i2 = 2;
            AppMethodBeat.i(163356);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (eVar = (e) bVar.as(e.class)) == null || Util.isNullOrNil(eVar.username))) {
                Intent intent = new Intent();
                if (ab.Eq(caVar.field_talker)) {
                    intent.putExtra("key_finder_teen_mode_scene", 2);
                    intent.putExtra("key_from_profile_share_scene", 2);
                } else {
                    intent.putExtra("key_finder_teen_mode_scene", 1);
                    intent.putExtra("key_from_profile_share_scene", 1);
                }
                aj ajVar = (aj) g.ah(aj.class);
                if (ab.Eq(caVar.field_talker)) {
                    i2 = 3;
                }
                ajVar.fillContextIdToIntent(i2, 3, 32, intent);
                intent.putExtra("key_enter_profile_type", 4);
                intent.putExtra("key_comment_scene", 11);
                intent.putExtra("from_user", caVar.field_talker);
                intent.putExtra("finder_username", eVar.username);
                intent.putExtra("key_finder_teen_mode_check", true);
                intent.putExtra("key_finder_teen_mode_user_name", eVar.nickname);
                intent.putExtra("key_finder_teen_mode_user_id", eVar.username);
                ((aj) g.ah(aj.class)).enterFinderProfileUI(aVar.Pwc.getContext(), intent);
            }
            AppMethodBeat.o(163356);
            return false;
        }
    }

    static class a extends c.a {
        TextView gvw;
        ImageView gyr;
        public ImageView tickIV;
        ImageView vMF;
        TextView vMG;

        a() {
        }

        public final a M(View view, boolean z) {
            AppMethodBeat.i(163352);
            super.create(view);
            this.gyr = (ImageView) view.findViewById(R.id.ckb);
            this.gvw = (TextView) view.findViewById(R.id.d0s);
            this.vMF = (ImageView) view.findViewById(R.id.cmi);
            this.vMG = (TextView) view.findViewById(R.id.cmj);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            if (!(!((aj) g.ah(aj.class)).showFinderEntry())) {
                this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                this.maskView = view.findViewById(R.id.ax3);
            }
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
            }
            AppMethodBeat.o(163352);
            return this;
        }
    }

    static /* synthetic */ void d(Activity activity, ca caVar) {
        k.b HD;
        AppMethodBeat.i(163363);
        if (!Util.isNullOrNil(caVar.field_content) && (HD = k.b.HD(caVar.field_content)) != null) {
            Intent intent = new Intent(activity, MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Type", 20);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderNameCard", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderNameCard", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(163363);
    }
}
