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
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.adapter.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.IOException;
import java.util.LinkedList;

public final class n {
    private static e Aer;
    private static String TAG = "Finder.ChattingItemAppMsgFinderAlbum";

    static {
        AppMethodBeat.i(233663);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        Aer = aVar.aJT();
        AppMethodBeat.o(233663);
    }

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 956301361) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233654);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sp);
                view.setTag(new a().J(view, true));
            }
            AppMethodBeat.o(233654);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
            k.b bVar;
            boolean z = false;
            AppMethodBeat.i(233655);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                final bcf q = n.q(bVar);
                if (q != null) {
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), q.title));
                    LinkedList linkedList = new LinkedList();
                    int i3 = 0;
                    while (i3 < q.LLt.size() && i3 < 4) {
                        cjl cjl = new cjl();
                        cjl.url = q.LLt.get(i3);
                        cjl.url_token = q.LLu.get(i3);
                        cjl.thumb_url_token = cjl.url_token;
                        cjl.thumbUrl = cjl.url;
                        linkedList.add(cjl);
                        i3++;
                    }
                    com.tencent.mm.plugin.finder.view.adapter.b bVar2 = new com.tencent.mm.plugin.finder.view.adapter.b(linkedList, false);
                    aVar3.PKp.setAdapter(bVar2);
                    bVar2.wrh = new b.c() {
                        /* class com.tencent.mm.ui.chatting.viewitems.n.c.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.finder.view.adapter.b.c
                        public final void f(int i2, View view) {
                            AppMethodBeat.i(233653);
                            n.a(view.getContext(), caVar, q);
                            AppMethodBeat.o(233653);
                        }
                    };
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
            AppMethodBeat.o(233655);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233656);
            if (caVar.dOQ()) {
                m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233656);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233657);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                com.tencent.mm.br.c.aZU("favorite");
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
            }
            AppMethodBeat.o(233657);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233658);
            switch (menuItem.getItemId()) {
                case 111:
                    n.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233658);
                    return true;
                default:
                    AppMethodBeat.o(233658);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233659);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bcf q = n.q(bVar);
            if (q != null) {
                n.a(aVar.Pwc.getContext(), caVar, q);
            }
            AppMethodBeat.o(233659);
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
            if (z || i2 != 956301361) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233648);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rb);
                view.setTag(new a().J(view, false));
            }
            AppMethodBeat.o(233648);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(233649);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                final bcf q = n.q(bVar);
                if (q != null) {
                    aVar3.PKo.setText(l.c(aVar2.Pwc.getContext(), q.title));
                    LinkedList linkedList = new LinkedList();
                    int i3 = 0;
                    while (i3 < q.LLt.size() && i3 < 4) {
                        cjl cjl = new cjl();
                        cjl.url = q.LLt.get(i3);
                        cjl.url_token = q.LLu.get(i3);
                        cjl.thumb_url_token = cjl.url_token;
                        cjl.thumbUrl = cjl.url;
                        linkedList.add(cjl);
                        i3++;
                    }
                    com.tencent.mm.plugin.finder.view.adapter.b bVar2 = new com.tencent.mm.plugin.finder.view.adapter.b(linkedList, false);
                    aVar3.PKp.setAdapter(bVar2);
                    bVar2.wrh = new b.c() {
                        /* class com.tencent.mm.ui.chatting.viewitems.n.b.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.finder.view.adapter.b.c
                        public final void f(int i2, View view) {
                            AppMethodBeat.i(233647);
                            n.a(view.getContext(), caVar, q);
                            AppMethodBeat.o(233647);
                        }
                    };
                }
                if (aVar3.clickArea != null) {
                    aVar3.clickArea.setOnClickListener(d(aVar2));
                    aVar3.clickArea.setOnLongClickListener(c(aVar2));
                    aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                    aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
                }
            }
            AppMethodBeat.o(233649);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233650);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && com.tencent.mm.br.c.aZU("favorite") && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            AppMethodBeat.o(233650);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233651);
            switch (menuItem.getItemId()) {
                case 111:
                    n.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233651);
                    return true;
                default:
                    AppMethodBeat.o(233651);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233652);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            bcf q = n.q(bVar);
            if (q != null) {
                n.a(aVar.Pwc.getContext(), caVar, q);
            }
            AppMethodBeat.o(233652);
            return false;
        }
    }

    static class a extends c.a {
        public TextView PKo;
        public FinderFeedAlbumView PKp;
        public ImageView tickIV;

        a() {
        }

        public final a J(View view, boolean z) {
            AppMethodBeat.i(233646);
            super.create(view);
            this.PKo = (TextView) view.findViewById(R.id.awe);
            this.PKp = (FinderFeedAlbumView) view.findViewById(R.id.cef);
            this.PKp.setItemViewWidth(com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 98));
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            if (!(!((aj) g.ah(aj.class)).showFinderEntry())) {
                this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                this.maskView = view.findViewById(R.id.ax3);
            }
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
            }
            AppMethodBeat.o(233646);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKp;
        }
    }

    static /* synthetic */ bcf q(k.b bVar) {
        AppMethodBeat.i(233660);
        d dVar = (d) bVar.as(d.class);
        if (dVar != null) {
            bcf bcf = dVar.jle;
            AppMethodBeat.o(233660);
            return bcf;
        }
        AppMethodBeat.o(233660);
        return null;
    }

    static /* synthetic */ void a(Context context, ca caVar, bcf bcf) {
        int i2 = 1;
        AppMethodBeat.i(233661);
        Intent intent = new Intent();
        intent.putExtra("TITLE_WORDING", bcf.title);
        intent.putExtra("AUTO_REFRESH", true);
        try {
            intent.putExtra("FINDER_SHARE_ALBUM", bcf.toByteArray());
        } catch (IOException e2) {
        }
        intent.putExtra("GET_REL_SCENE", 14);
        intent.putExtra("STREAM_CARD_BUFFER", bcf.tVe.toByteArray());
        intent.putExtra("COMMENT_SCENE", 51);
        intent.putExtra("CARD_ID", r.aOw(bcf.cardId));
        intent.putExtra("SHARED_USERNAME", caVar.field_talker);
        if (ab.Eq(caVar.field_talker)) {
            i2 = 2;
        }
        intent.putExtra("FROM_SHARE_SCENE", i2);
        ((aj) g.ah(aj.class)).enterAlbumRelatedTimelineUI(context, intent);
        AppMethodBeat.o(233661);
    }

    static /* synthetic */ void b(Activity activity, ca caVar) {
        k.b HD;
        AppMethodBeat.i(233662);
        if (!Util.isNullOrNil(caVar.field_content) && (HD = k.b.HD(caVar.field_content)) != null) {
            Intent intent = new Intent(activity, MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Type", 22);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderAlbum", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderAlbum", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(233662);
    }
}
