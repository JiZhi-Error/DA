package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.y;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class af {

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
            if (z || i2 != 855638065) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233794);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s3);
                view.setTag(new c(view, Boolean.TRUE));
            }
            AppMethodBeat.o(233794);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(final c.a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(233795);
            if (aVar instanceof c) {
                String str2 = caVar.field_content;
                if (str2 != null) {
                    bVar = k.b.aD(str2, caVar.field_reserved);
                } else {
                    Log.e("MicroMsg.ChattingItemAppMsgShareLiveFrom", "amessage, msgid:%s, user:%s", Long.valueOf(caVar.field_msgId), str);
                    bVar = null;
                }
                if (bVar != null) {
                    ((c) aVar).PLK.aw(l.c(MMApplicationContext.getContext(), bVar.getTitle()));
                    final long parseLong = Long.parseLong(((y) bVar.as(y.class)).hJs);
                    ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).refreshLiveStatus(parseLong, aVar2.getTalkerUserName(), new a.AbstractC0368a() {
                        /* class com.tencent.mm.ui.chatting.viewitems.af.a.AnonymousClass1 */

                        @Override // com.tencent.mm.live.a.AbstractC0368a
                        public final void c(long j2, int i2) {
                            AppMethodBeat.i(233793);
                            if (parseLong == j2) {
                                if (i2 == 1) {
                                    ((c) aVar).PLL.setText(aVar2.Pwc.getContext().getResources().getString(R.string.g6e));
                                    AppMethodBeat.o(233793);
                                    return;
                                }
                                ((c) aVar).PLL.setText(aVar2.Pwc.getContext().getResources().getString(R.string.g6g));
                            }
                            AppMethodBeat.o(233793);
                        }
                    });
                }
                ((c) aVar).PLM.setImageDrawable(ar.m(((c) aVar).PLM.getContext(), R.raw.room_live_icon, ((c) aVar).PLM.getContext().getResources().getColor(R.color.a5r)));
                aVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
                aVar.clickArea.setOnClickListener(d(aVar2));
                aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar.clickArea.setOnLongClickListener(c(aVar2));
            }
            Log.i("MicroMsg.ChattingItemAppMsgShareLiveFrom", "filling");
            AppMethodBeat.o(233795);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233796);
            view.getTag();
            AppMethodBeat.o(233796);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            k.b bVar;
            AppMethodBeat.i(233797);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null && bVar.type == 60) {
                if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(view.getContext())) {
                    AppMethodBeat.o(233797);
                    return true;
                }
                try {
                    if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isAnchorLiving() || ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isVisitorLiving() || (!com.tencent.mm.q.a.o(aVar.Pwc.getContext(), true) && !com.tencent.mm.q.a.cC(aVar.Pwc.getContext()) && !com.tencent.mm.q.a.cA(aVar.Pwc.getContext()) && !com.tencent.mm.q.a.cE(aVar.Pwc.getContext()))) {
                        y yVar = (y) bVar.as(y.class);
                        long parseLong = Long.parseLong(yVar.hJs);
                        String str2 = yVar.hwb;
                        String str3 = yVar.thumbUrl;
                        String a2 = a(aVar, caVar);
                        LiveConfig.a aVar2 = new LiveConfig.a();
                        aVar2.hvZ = LiveConfig.hvU;
                        aVar2.thumbUrl = str3;
                        aVar2.hwa = aVar.getTalkerUserName();
                        aVar2.liveId = parseLong;
                        aVar2.hwb = str2;
                        aVar2.fromScene = LiveConfig.hvX;
                        aVar2.hwd = a2;
                        LiveConfig aBR = aVar2.aBR();
                        if (a2 == null) {
                            a2 = aVar.GUe.field_username;
                        }
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = a2;
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs((long) ((int) aVar.GUe.gMZ));
                        ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().b(aVar.Pwc.getContext(), aBR);
                        f.aIL();
                    }
                    AppMethodBeat.o(233797);
                    return true;
                } catch (Exception e2) {
                    Log.w("MicroMsg.ChattingItemAppMsgShareLiveFrom", "jump to live fail: %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(233797);
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
            if (!z || i2 != 855638065) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233799);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.tf);
                view.setTag(new c(view, Boolean.TRUE));
            }
            AppMethodBeat.o(233799);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(final c.a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(233800);
            this.PhN = aVar2;
            if (aVar instanceof c) {
                String str2 = caVar.field_content;
                if (str2 != null) {
                    bVar = k.b.aD(str2, caVar.field_reserved);
                } else {
                    Log.e("MicroMsg.ChattingItemAppMsgShareLiveTo", "amessage, msgid:%s, user:%s", Long.valueOf(caVar.field_msgId), str);
                    bVar = null;
                }
                if (bVar != null) {
                    ((c) aVar).PLK.aw(l.c(MMApplicationContext.getContext(), bVar.getTitle()));
                    final long parseLong = Long.parseLong(((y) bVar.as(y.class)).hJs);
                    ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).refreshLiveStatus(parseLong, aVar2.getTalkerUserName(), new a.AbstractC0368a() {
                        /* class com.tencent.mm.ui.chatting.viewitems.af.b.AnonymousClass1 */

                        @Override // com.tencent.mm.live.a.AbstractC0368a
                        public final void c(long j2, int i2) {
                            AppMethodBeat.i(233798);
                            if (parseLong == j2) {
                                if (i2 == 1) {
                                    ((c) aVar).PLL.setText(aVar2.Pwc.getContext().getResources().getString(R.string.g6e));
                                    AppMethodBeat.o(233798);
                                    return;
                                }
                                ((c) aVar).PLL.setText(aVar2.Pwc.getContext().getResources().getString(R.string.g6g));
                            }
                            AppMethodBeat.o(233798);
                        }
                    });
                }
                ((c) aVar).PLM.setImageDrawable(ar.m(((c) aVar).PLM.getContext(), R.raw.room_live_icon, ((c) aVar).PLM.getContext().getResources().getColor(R.color.a5r)));
                aVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
                aVar.clickArea.setOnClickListener(d(aVar2));
                aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar.clickArea.setOnLongClickListener(c(aVar2));
            }
            Log.i("MicroMsg.ChattingItemAppMsgShareLiveTo", "filling");
            AppMethodBeat.o(233800);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233801);
            int i2 = ((bq) view.getTag()).position;
            if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            AppMethodBeat.o(233801);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            k.b bVar;
            AppMethodBeat.i(233802);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar == null || bVar.type != 60) {
                AppMethodBeat.o(233802);
                return false;
            }
            try {
                if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isAnchorLiving() || ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isVisitorLiving() || (!com.tencent.mm.q.a.o(aVar.Pwc.getContext(), true) && !com.tencent.mm.q.a.cC(aVar.Pwc.getContext()) && !com.tencent.mm.q.a.cA(aVar.Pwc.getContext()) && !com.tencent.mm.q.a.cE(aVar.Pwc.getContext()))) {
                    y yVar = (y) bVar.as(y.class);
                    long parseLong = Long.parseLong(yVar.hJs);
                    String str2 = yVar.hwb;
                    String str3 = yVar.thumbUrl;
                    String a2 = a(aVar, caVar);
                    LiveConfig.a aVar2 = new LiveConfig.a();
                    aVar2.hvZ = LiveConfig.hvT;
                    aVar2.thumbUrl = str3;
                    aVar2.hwa = aVar.getTalkerUserName();
                    aVar2.liveId = parseLong;
                    aVar2.hwb = str2;
                    aVar2.hwd = a2;
                    LiveConfig aBR = aVar2.aBR();
                    if (a2 == null) {
                        a2 = aVar.GUe.field_username;
                    }
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = a2;
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs((long) ((int) aVar.GUe.gMZ));
                    ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(aVar.Pwc.getContext(), aBR);
                }
                AppMethodBeat.o(233802);
                return true;
            } catch (Exception e2) {
                Log.w("MicroMsg.ChattingItemAppMsgShareLiveTo", "jump to live fail: %s", e2.getMessage());
                AppMethodBeat.o(233802);
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
        MMNeat7extView PLK;
        MMTextView PLL;
        ImageView PLM;

        public c(View view, Boolean bool) {
            AppMethodBeat.i(233803);
            super.create(view);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PLK = (MMNeat7extView) view.findViewById(R.id.hpn);
            this.PLL = (MMTextView) view.findViewById(R.id.hpo);
            this.PLM = (ImageView) view.findViewById(R.id.hpm);
            this.PJV = bool.booleanValue();
            AppMethodBeat.o(233803);
        }
    }
}
