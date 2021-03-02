package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q {

    public static class a extends c {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTX() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 989855793) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233673);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rf);
                view.setTag(new c(view, Boolean.TRUE));
            }
            AppMethodBeat.o(233673);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            com.tencent.mm.plugin.i.a.a aVar3;
            AppMethodBeat.i(233674);
            if (aVar instanceof c) {
                c cVar = (c) aVar;
                String str2 = caVar.field_content;
                if (str2 != null) {
                    bVar = k.b.aD(str2, caVar.field_reserved);
                } else {
                    Log.e("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "amessage, msgid:%s, user:%s", Long.valueOf(caVar.field_msgId), str);
                    bVar = null;
                }
                if (!(bVar == null || (aVar3 = (com.tencent.mm.plugin.i.a.a) bVar.as(com.tencent.mm.plugin.i.a.a.class)) == null)) {
                    axf axf = aVar3.wDV;
                    cVar.PKy.aw(l.c(aVar2.Pwc.getContext(), axf.nickName));
                    m mVar = m.uJa;
                    d<o> djY = m.djY();
                    p pVar = new p(axf.coverUrl, x.THUMB_IMAGE);
                    ImageView imageView = cVar.gyr;
                    m mVar2 = m.uJa;
                    djY.a(pVar, imageView, m.a(m.a.MSG_THUMB));
                }
                aVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
                aVar.clickArea.setOnClickListener(d(aVar2));
                aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar.clickArea.setOnLongClickListener(c(aVar2));
            }
            Log.i("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "filling");
            AppMethodBeat.o(233674);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233675);
            view.getTag();
            AppMethodBeat.o(233675);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233676);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null && bVar.type == 65) {
                try {
                    com.tencent.mm.plugin.i.a.a aVar2 = (com.tencent.mm.plugin.i.a.a) bVar.as(com.tencent.mm.plugin.i.a.a.class);
                    if (!(aVar2 == null || aVar2.wDV == null)) {
                        axf axf = aVar2.wDV;
                        String a2 = a(aVar, caVar);
                        if (a2 == null) {
                            a2 = aVar.GUe.field_username;
                        }
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = a2;
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs((long) ((int) aVar.GUe.gMZ));
                        ((aj) g.ah(aj.class)).enterFinderLiveInvitedUI(MMApplicationContext.getContext(), axf.username, axf.nickName, axf.headUrl, axf.feedId, axf.hJs);
                    }
                    AppMethodBeat.o(233676);
                    return true;
                } catch (Exception e2) {
                    Log.w("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "jump to live fail: %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(233676);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTX() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 989855793) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233677);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.st);
                view.setTag(new c(view, Boolean.TRUE));
            }
            AppMethodBeat.o(233677);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            com.tencent.mm.plugin.i.a.a aVar3;
            AppMethodBeat.i(233678);
            this.PhN = aVar2;
            if (aVar instanceof c) {
                c cVar = (c) aVar;
                String str2 = caVar.field_content;
                if (str2 != null) {
                    bVar = k.b.aD(str2, caVar.field_reserved);
                } else {
                    Log.e("MicroMsg.ChattingItemAppMsgLiveInviteTo", "amessage, msgid:%s, user:%s", Long.valueOf(caVar.field_msgId), str);
                    bVar = null;
                }
                if (!(bVar == null || (aVar3 = (com.tencent.mm.plugin.i.a.a) bVar.as(com.tencent.mm.plugin.i.a.a.class)) == null)) {
                    axf axf = aVar3.wDV;
                    cVar.PKy.aw(l.c(aVar2.Pwc.getContext(), axf.nickName));
                    m mVar = m.uJa;
                    d<o> djY = m.djY();
                    p pVar = new p(axf.coverUrl, x.THUMB_IMAGE);
                    ImageView imageView = cVar.gyr;
                    m mVar2 = m.uJa;
                    djY.a(pVar, imageView, m.a(m.a.MSG_THUMB));
                }
                aVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
                aVar.clickArea.setOnClickListener(d(aVar2));
                aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar.clickArea.setOnLongClickListener(c(aVar2));
            }
            Log.i("MicroMsg.ChattingItemAppMsgLiveInviteTo", "filling");
            AppMethodBeat.o(233678);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233679);
            int i2 = ((bq) view.getTag()).position;
            if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            AppMethodBeat.o(233679);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233680);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar == null || bVar.type != 65) {
                AppMethodBeat.o(233680);
                return false;
            }
            try {
                com.tencent.mm.plugin.i.a.a aVar2 = (com.tencent.mm.plugin.i.a.a) bVar.as(com.tencent.mm.plugin.i.a.a.class);
                if (!(aVar2 == null || aVar2.wDV == null)) {
                    axf axf = aVar2.wDV;
                    long Ga = com.tencent.mm.ac.d.Ga(axf.feedId);
                    long Ga2 = com.tencent.mm.ac.d.Ga(axf.hJs);
                    String a2 = a(aVar, caVar);
                    if (a2 == null) {
                        a2 = aVar.GUe.field_username;
                    }
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = a2;
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs((long) ((int) aVar.GUe.gMZ));
                    ((aj) g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), Ga, Long.valueOf(Ga2), axf.objectNonceId, axf.desc, "", "", "");
                }
                AppMethodBeat.o(233680);
                return true;
            } catch (Exception e2) {
                Log.w("MicroMsg.ChattingItemAppMsgLiveInviteTo", "jump to live fail: %s", e2.getMessage());
                AppMethodBeat.o(233680);
                return true;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }
    }

    static class c extends c.a {
        boolean PJV;
        MMNeat7extView PKy;
        ImageView gBZ;
        ImageView gyr;

        public c(View view, Boolean bool) {
            AppMethodBeat.i(233681);
            super.create(view);
            this.PKy = (MMNeat7extView) view.findViewById(R.id.cre);
            this.gBZ = (ImageView) view.findViewById(R.id.crd);
            this.gyr = (ImageView) view.findViewById(R.id.crb);
            this.gBZ.setImageDrawable(ar.m(this.gBZ.getContext(), R.raw.icons_outlined_finder_icon, com.tencent.mm.cb.a.n(this.gBZ.getContext(), R.color.Orange)));
            this.PJV = bool.booleanValue();
            AppMethodBeat.o(233681);
        }
    }
}
