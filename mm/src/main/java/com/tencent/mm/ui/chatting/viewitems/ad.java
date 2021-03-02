package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.gz;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.ah;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.util.e;

public final class ad extends c {
    private a PLy;

    static /* synthetic */ void a(ad adVar, com.tencent.mm.ui.chatting.e.a aVar, ca caVar, czg czg, int i2) {
        AppMethodBeat.i(233789);
        adVar.a(aVar, caVar, czg, i2);
        AppMethodBeat.o(233789);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        return i2 == 889192497 || i2 == 922746929;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(233785);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.qm);
            view.setTag(new a().gY(view));
        }
        AppMethodBeat.o(233785);
        return view;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        boolean z;
        int i3;
        AppMethodBeat.i(233786);
        Log.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", Integer.valueOf(i2), Long.valueOf(caVar.field_msgId));
        this.PLy = (a) aVar;
        String str2 = caVar.field_content;
        czg aJJ = ((b) g.af(b.class)).aJJ(str2);
        int size = aJJ.yVw.size();
        Log.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", str2, aJJ.gnh, Integer.valueOf(size));
        if (size > 0) {
            ca aEx = ((l) g.af(l.class)).eiy().aEx(str);
            if (size < 5 || aEx.field_msgId == caVar.field_msgId) {
                z = false;
            } else {
                z = ((b) g.af(b.class)).HD(caVar.field_msgId);
            }
            final ah ahVar = (ah) aVar2.bh(ah.class);
            boolean z2 = ahVar != null && ahVar.Nv(caVar.field_msgId);
            Log.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", Boolean.valueOf(z), Boolean.valueOf(z2));
            boolean z3 = (!z2) & z;
            if (z3) {
                i3 = 3;
            } else {
                i3 = size;
            }
            a(aVar2, caVar, aJJ, i3);
            this.PLy.PLB.setTag(Long.valueOf(caVar.field_msgId));
            if (z3) {
                this.PLy.PLB.setVisibility(0);
                this.PLy.PLB.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ad.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(233778);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (view.getTag() != null && (view.getTag() instanceof Long)) {
                            ca Hb = ((l) g.af(l.class)).eiy().Hb(((Long) view.getTag()).longValue());
                            if (ahVar != null) {
                                ahVar.Nw(Hb.field_msgId);
                            }
                            view.setVisibility(8);
                            czg aJJ = ((b) g.af(b.class)).aJJ(Hb.field_content);
                            ad.a(ad.this, aVar2, Hb, aJJ, aJJ.yVw.size());
                            gz gzVar = new gz();
                            gzVar.eLk = gzVar.x("ChatUsername", aVar2.getTalkerUserName(), true);
                            gzVar.etW = gzVar.x("Username", aVar2.PkU, true);
                            gzVar.eLl = aJJ.yVw.size();
                            if (ab.Ix(aVar2.getTalkerUserName())) {
                                gzVar.enq = 2;
                            } else {
                                gzVar.enq = 1;
                            }
                            gzVar.bfK();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233778);
                    }
                });
                AppMethodBeat.o(233786);
                return;
            }
            this.PLy.PLB.setVisibility(8);
        }
        AppMethodBeat.o(233786);
    }

    private void a(final com.tencent.mm.ui.chatting.e.a aVar, ca caVar, czg czg, int i2) {
        AppMethodBeat.i(233787);
        Log.i("MicroMsg.ChattingItemAppMsgPat", "fll msg view contains record %d , show %d", Integer.valueOf(czg.yVw.size()), Integer.valueOf(i2));
        this.PLy.xUE.removeAllViews();
        Activity context = aVar.Pwc.getContext();
        for (int i3 = 0; i3 < i2; i3++) {
            MMNeat7extView mMNeat7extView = new MMNeat7extView(context);
            mMNeat7extView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.hc));
            mMNeat7extView.setPadding(context.getResources().getDimensionPixelSize(R.dimen.i2), context.getResources().getDimensionPixelSize(R.dimen.i2), context.getResources().getDimensionPixelSize(R.dimen.i2), context.getResources().getDimensionPixelSize(R.dimen.i2));
            mMNeat7extView.setTextGravity(1);
            mMNeat7extView.setClickable(true);
            a(aVar, czg.yVw.get(i3), mMNeat7extView);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            if (aVar.gRM()) {
                layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.i2);
                layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.i2);
            }
            layoutParams.gravity = 1;
            this.PLy.xUE.addView(mMNeat7extView, layoutParams);
            mMNeat7extView.setTag(new bq(caVar, aVar.gRM(), 0, "", (char) 0));
            mMNeat7extView.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.ad.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    bq bqVar;
                    AppMethodBeat.i(233779);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (!(!((PluginPatMsg) g.ah(PluginPatMsg.class)).isRevokePatMsgEnable() || (bqVar = (bq) view.getTag()) == null || bqVar.dTX == null)) {
                        int indexOfChild = ((ViewGroup) view.getParent()).indexOfChild(view);
                        Log.i("MicroMsg.ChattingItemAppMsgPat", "long click msg %d, index %d", Long.valueOf(bqVar.dTX.field_msgId), Integer.valueOf(indexOfChild));
                        czg boC = e.boC(bqVar.dTX.field_content);
                        if (indexOfChild < boC.yVw.size()) {
                            czh czh = boC.yVw.get(indexOfChild);
                            if (z.aTY().equals(czh.dRL)) {
                                if (cl.aWz() - czh.createTime <= 120000) {
                                    ad.a(ad.this, aVar, Pair.create(Long.valueOf(bqVar.dTX.field_msgId), Long.valueOf(czh.createTime)));
                                } else {
                                    Log.w("MicroMsg.ChattingItemAppMsgPat", "expire revoke time %d", Long.valueOf(czh.createTime));
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                                AppMethodBeat.o(233779);
                                return true;
                            }
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(233779);
                    return false;
                }
            });
        }
        AppMethodBeat.o(233787);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.tencent.mm.ui.chatting.e.a r13, com.tencent.mm.protocal.protobuf.czh r14, com.tencent.mm.ui.widget.MMNeat7extView r15) {
        /*
        // Method dump skipped, instructions count: 571
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.ad.a(com.tencent.mm.ui.chatting.e.a, com.tencent.mm.protocal.protobuf.czh, com.tencent.mm.ui.widget.MMNeat7extView):void");
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(m mVar, View view, ca caVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
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

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTV() {
        return false;
    }

    public static final class a extends c.a {
        public TextView PLB;
        public LinearLayout xUE;

        public final a gY(View view) {
            AppMethodBeat.i(233784);
            super.create(view);
            this.xUE = (LinearLayout) view.findViewById(R.id.g8z);
            this.PLB = (TextView) view.findViewById(R.id.d7f);
            this.maskView = view.findViewById(R.id.ax3);
            AppMethodBeat.o(233784);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return null;
        }
    }

    static /* synthetic */ void a(ad adVar, final com.tencent.mm.ui.chatting.e.a aVar, final Pair pair) {
        AppMethodBeat.i(233790);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) aVar.Pwc.getContext(), 1, true);
        eVar.j(aVar.Pwc.getContext().getString(R.string.g5o), 1, com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 14));
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.chatting.viewitems.ad.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(233780);
                mVar.a(291, aVar.Pwc.getMMResources().getColor(R.color.a5e), aVar.Pwc.getMMResources().getString(R.string.b0i));
                AppMethodBeat.o(233780);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.ui.chatting.viewitems.ad.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(233781);
                if (menuItem.getItemId() == 291) {
                    ((b) g.af(b.class)).a(pair, 1);
                }
                AppMethodBeat.o(233781);
            }
        };
        eVar.PGl = new e.b() {
            /* class com.tencent.mm.ui.chatting.viewitems.ad.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                int i2;
                AppMethodBeat.i(233782);
                ca Hb = ((l) g.af(l.class)).eiy().Hb(((Long) pair.first).longValue());
                czg boC = com.tencent.mm.util.e.boC(Hb.field_content);
                czh a2 = ((b) g.af(b.class)).a(boC, ((Long) pair.second).longValue());
                if (a2 != null) {
                    if (a2.oNJ == 0) {
                        hu huVar = new hu();
                        if (ab.Eq(Hb.field_talker)) {
                            huVar.vz(Hb.field_talker);
                            huVar.enq = 2;
                        } else {
                            huVar.enq = 1;
                        }
                        huVar.eMu = ((Long) pair.second).longValue() - ((b) g.af(b.class)).b(boC.gnh, pair);
                        if (((Long) pair.second).longValue() <= ((l) g.af(l.class)).eiy().aEP(boC.gnh)) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        huVar.eMw = i2;
                        huVar.vx(z.aTY());
                        huVar.vy(boC.gnh);
                        huVar.eLQ = a2.createTime;
                        huVar.vA(com.tencent.mm.plugin.patmsg.c.aJL(a2.MEA));
                        huVar.eLV = 1;
                        huVar.eLX = 2;
                        huVar.bfK();
                        com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
                        com.tencent.mm.util.b.a(huVar);
                        AppMethodBeat.o(233782);
                        return;
                    }
                    hk hkVar = new hk();
                    hkVar.eLQ = a2.createTime;
                    hkVar.eLR = System.currentTimeMillis();
                    hkVar.ve(a2.dRL);
                    hkVar.vf(a2.MEA);
                    hkVar.vg(com.tencent.mm.plugin.patmsg.c.aJL(a2.MEA));
                    if (ab.Ix(boC.gnh)) {
                        hkVar.vh(boC.gnh);
                        hkVar.enq = 2;
                    } else {
                        hkVar.enq = 1;
                    }
                    hkVar.eLV = 1;
                    hkVar.eLX = 2;
                    hkVar.eLW = 1;
                    hkVar.bfK();
                    com.tencent.mm.util.b bVar2 = com.tencent.mm.util.b.QYu;
                    com.tencent.mm.util.b.a(hkVar);
                }
                AppMethodBeat.o(233782);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(233790);
    }
}
