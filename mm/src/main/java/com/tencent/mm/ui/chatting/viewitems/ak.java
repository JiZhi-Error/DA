package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.e;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.List;

public final class ak {

    public static class j extends c {
        private static int BCA;
        private static int PMp;
        private static int PMq;
        private static int pru;
        private static int prv = 0;
        private static int prw = 0;
        private static int prx = 0;
        private static int prz;
        private boolean PMr = false;
        private int PMs = 0;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private long pxY = 0;
        private boolean pxZ = false;

        static /* synthetic */ void a(j jVar, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37171);
            jVar.e(aVar, caVar);
            AppMethodBeat.o(37171);
        }

        static /* synthetic */ void a(j jVar, c cVar, a aVar, v vVar, ca caVar, int i2) {
            AppMethodBeat.i(37170);
            jVar.a(cVar, aVar, vVar, caVar, i2, true);
            AppMethodBeat.o(37170);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (i2 == 285212721) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37150);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.qt);
                c cVar = new c();
                cVar.timeTV = (TextView) view.findViewById(R.id.ayf);
                cVar.historyMsgTip = view.findViewById(R.id.avm);
                cVar.pxI = (LinearLayout) view.findViewById(R.id.aum);
                cVar.checkBox = (CheckBox) view.findViewById(R.id.aue);
                cVar.maskView = view.findViewById(R.id.ax3);
                cVar.PHZ = (TextView) view.findViewById(R.id.at6);
                view.setTag(cVar);
            }
            km(layoutInflater.getContext());
            AppMethodBeat.o(37150);
            return view;
        }

        private static void km(Context context) {
            AppMethodBeat.i(37151);
            if (prx == 0) {
                prx = context.getResources().getDimensionPixelSize(R.dimen.k5);
                prw = context.getResources().getDimensionPixelSize(R.dimen.ib);
                prv = context.getResources().getDimensionPixelSize(R.dimen.hs);
                pru = context.getResources().getDimensionPixelSize(R.dimen.wz);
                prz = context.getResources().getDimensionPixelSize(R.dimen.wx);
                int jn = com.tencent.mm.cb.a.jn(context);
                int jo = com.tencent.mm.cb.a.jo(context);
                if (jn >= jo) {
                    jn = jo;
                }
                int density = jn - ((int) (com.tencent.mm.cb.a.getDensity(context) * 32.0f));
                BCA = (int) (((double) density) / 2.35d);
                PMp = (int) (((float) density) / 1.7777778f);
                PMq = (int) (((float) density) / 1.7777778f);
            }
            AppMethodBeat.o(37151);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTU() {
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:267:0x0b8e  */
        /* JADX WARNING: Removed duplicated region for block: B:274:0x0bd5  */
        /* JADX WARNING: Removed duplicated region for block: B:275:0x0be1  */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0c96  */
        /* JADX WARNING: Removed duplicated region for block: B:292:0x0cd1  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0291  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02cc  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x02f2  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x031a  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0329  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0357  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x03b4  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x03f3  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r27, int r28, com.tencent.mm.ui.chatting.e.a r29, final com.tencent.mm.storage.ca r30, java.lang.String r31) {
            /*
            // Method dump skipped, instructions count: 3414
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.ak.j.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        private static void c(v vVar) {
            if (vVar.type == 6) {
                vVar.type = 7;
            }
        }

        private void a(v vVar, ca caVar, int i2, u uVar, View view) {
            bq bqVar;
            AppMethodBeat.i(37153);
            String bmE = ((com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class)).bmE(vVar.url);
            if (!TextUtils.isEmpty(bmE)) {
                Log.d("MicroMsg.ChattingItemBizFrom", "productId:%s", bmE);
                bqVar = new bq(caVar, false, i2, vVar.url, false, this.PhN.gOZ(), uVar.eag, uVar.eah, vVar.title, bmE, null, false, false);
                view.setOnClickListener(i(this.PhN));
            } else {
                bqVar = new bq(caVar, false, i2, vVar.url, false, this.PhN.gOZ(), uVar.eag, uVar.eah, vVar.title);
                a(bqVar, vVar, caVar);
                view.setOnClickListener(h(this.PhN));
            }
            bqVar.IZC = caVar.field_msgSvrId;
            bqVar.IZD = 0;
            bqVar.PQJ = vVar.type;
            view.setTag(bqVar);
            if (m.HF(vVar.iAt)) {
                a(vVar, view);
            }
            a(vVar, view, caVar.field_msgId, caVar.field_msgSvrId, 0);
            view.setOnLongClickListener(c(this.PhN));
            view.setOnTouchListener(((k) this.PhN.bh(k.class)).gOC());
            AppMethodBeat.o(37153);
        }

        private static void W(View view, int i2) {
            AppMethodBeat.i(233819);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(233819);
        }

        private static void aM(View view, int i2) {
            AppMethodBeat.i(37155);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(37155);
        }

        private static void X(View view, int i2) {
            AppMethodBeat.i(37156);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = i2;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(37156);
        }

        private void a(c cVar, final a aVar, v vVar, ca caVar, int i2, boolean z) {
            AppMethodBeat.i(37157);
            if (aVar.pxs != null) {
                aVar.pxs.setVisibility(8);
            }
            if (vVar.type == 5) {
                aVar.pxu.setVisibility(0);
                aVar.pxu.setImageResource(R.drawable.ic);
                aVar.pxu.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ak.j.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(169877);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        aVar.puO.performClick();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(169877);
                    }
                });
            } else if (vVar.type == 6) {
                aVar.pxu.setVisibility(0);
                if (z) {
                    if ((caVar.field_msgId + "_" + i2 + "_msg").equals(cVar.playingMsgId)) {
                        aVar.pxu.setImageResource(R.drawable.nm);
                    } else {
                        aVar.pxu.setImageResource(R.drawable.nn);
                    }
                } else if ((caVar.field_msgId + "_" + i2 + "_msg").equals(cVar.playingMsgId)) {
                    aVar.pxu.setImageResource(R.raw.chatting_item_biz_music_pause_loading_icon);
                } else {
                    aVar.pxu.setImageResource(R.raw.chatting_item_biz_music_play_loading_icon);
                }
                a(aVar.pxu, caVar, i2);
            } else if (vVar.type == 7) {
                aVar.pxu.setVisibility(8);
                if (aVar.pxs != null) {
                    aVar.pxs.setVisibility(0);
                }
                Drawable drawable = aVar.pxt.getDrawable();
                if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                    ((AnimationDrawable) drawable).stop();
                }
                if ((caVar.field_msgId + "_" + i2 + "_msg").equals(cVar.playingMsgId)) {
                    aVar.pxt.setImageResource(R.drawable.ie);
                    if (aVar.pxt.getDrawable() instanceof AnimationDrawable) {
                        ((AnimationDrawable) aVar.pxt.getDrawable()).start();
                    }
                } else {
                    aVar.pxt.setImageResource(R.drawable.id);
                }
                a(aVar.pxt, caVar, i2);
            } else {
                aVar.pxu.setVisibility(8);
            }
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.PhN.Pwc.getContext(), 26);
            if (vVar.type == 7) {
                fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.PhN.Pwc.getContext(), 32);
            } else if (vVar.type == 5) {
                fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.PhN.Pwc.getContext(), 24);
            }
            aM(aVar.pxu, fromDPToPix);
            AppMethodBeat.o(37157);
        }

        private void a(ImageView imageView, ca caVar, int i2) {
            AppMethodBeat.i(37158);
            e.g gVar = new e.g();
            gVar.msgId = caVar.field_msgId;
            gVar.PJs = i2;
            gVar.xml = caVar.field_content;
            imageView.setTag(gVar);
            imageView.setOnClickListener(((k) this.PhN.bh(k.class)).gOD());
            AppMethodBeat.o(37158);
        }

        private static void a(View view, b bVar, boolean z) {
            AppMethodBeat.i(37159);
            if (z) {
                if (bVar.puO == null) {
                    bVar.du(view);
                }
                if (bVar.puO != null) {
                    bVar.puO.setVisibility(0);
                    AppMethodBeat.o(37159);
                    return;
                }
            } else if (bVar.puO != null) {
                bVar.puO.setVisibility(8);
            }
            AppMethodBeat.o(37159);
        }

        private static void a(c cVar, int i2, int i3) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7 = true;
            AppMethodBeat.i(37160);
            boolean z8 = i2 == 5;
            a(cVar.pxI, cVar.PMf, z8);
            if (z8) {
                z = true;
            } else {
                z = false;
            }
            if (i2 == 8) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(cVar.pxI, cVar.PMg, z2);
            if (z2) {
                z = true;
            }
            if (i2 == 7) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(cVar.pxI, cVar.PMh, z3);
            if (z3) {
                z = true;
            }
            if (i2 == 6) {
                z4 = true;
            } else {
                z4 = false;
            }
            a(cVar.pxI, cVar.PMi, z4);
            if (z4) {
                z = true;
            }
            if (i2 == 10) {
                z5 = true;
            } else {
                z5 = false;
            }
            a(cVar.pxI, cVar.PMj, z5);
            if (z5) {
                z6 = true;
            } else {
                z6 = z;
            }
            LinearLayout linearLayout = cVar.pxI;
            f fVar = cVar.PMe;
            if (z6 || i3 <= 0) {
                z7 = false;
            }
            a(linearLayout, fVar, z7);
            AppMethodBeat.o(37160);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233820);
            bq bqVar = (bq) view.getTag();
            if (bqVar == null) {
                AppMethodBeat.o(233820);
                return false;
            }
            this.PMs = bqVar.IZD;
            int i2 = bqVar.position;
            u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content);
            if (a2 == null) {
                Log.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
                AppMethodBeat.o(233820);
                return false;
            }
            this.pxZ = false;
            if (this.PMs >= 0 && this.PMs < a2.iAd.size() && m.HF(((v) a2.iAd.get(this.PMs)).iAt)) {
                this.pxZ = true;
            }
            if (!this.PhN.gRN() && !com.tencent.mm.ui.chatting.k.bq(caVar)) {
                mVar.a(i2, 111, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            if (com.tencent.mm.br.c.aZU("favorite") && !this.pxZ) {
                mVar.a(i2, 126, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
            }
            if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                mVar.a(i2, 144, view.getContext().getString(R.string.f0_), R.raw.fix_tools_entry);
            }
            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233820);
            return true;
        }

        private void a(bq bqVar, v vVar, ca caVar) {
            int i2;
            AppMethodBeat.i(37162);
            Bundle bundle = new Bundle();
            switch (ac.aJ(a(this.PhN, caVar), this.PhN.getTalkerUserName())) {
                case 1:
                    i2 = 3;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                case 4:
                case 5:
                default:
                    i2 = 0;
                    break;
                case 6:
                case 7:
                    i2 = 5;
                    break;
            }
            bundle.putString("share_report_pre_msg_url", vVar.url);
            bundle.putString("share_report_pre_msg_title", vVar.title);
            bundle.putString("share_report_pre_msg_desc", vVar.iAq);
            bundle.putString("share_report_pre_msg_icon_url", m.a(vVar));
            bundle.putString("share_report_pre_msg_appid", "");
            bundle.putInt("share_report_from_scene", i2);
            if (i2 == 5) {
                bundle.putString("share_report_biz_username", this.PhN.getTalkerUserName());
            }
            bqVar.PQH = bundle;
            AppMethodBeat.o(37162);
        }

        private static void a(String str, ImageView imageView, int i2, int i3, m.a aVar) {
            AppMethodBeat.i(37163);
            String u = com.tencent.mm.api.b.u(str, 3);
            com.tencent.mm.av.a.a bcV = q.bcV();
            c.a aVar2 = new c.a();
            aVar2.jbt = R.color.j6;
            aVar2.jbf = true;
            c.a dr = aVar2.dr(i2, i3);
            dr.jaU = new n(2);
            dr.jbC = new com.tencent.mm.pluginsdk.ui.applet.e(2);
            dr.fullPath = s.bdu(u);
            bcV.a(u, imageView, dr.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, null, aVar));
            AppMethodBeat.o(37163);
        }

        private void a(String str, ImageView imageView, boolean z, int i2, m.a aVar) {
            boolean z2;
            AppMethodBeat.i(37164);
            String u = com.tencent.mm.api.b.u(str, 3);
            int i3 = z ? R.drawable.bzg : R.drawable.bzd;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            int i4 = z ? R.drawable.h2 : R.drawable.h0;
            float dimensionPixelSize = (float) this.PhN.Pwc.getContext().getResources().getDimensionPixelSize(R.dimen.x2);
            int jn = com.tencent.mm.cb.a.jn(imageView.getContext()) - ((int) (((float) (((k) this.PhN.bh(k.class)).isInEditMode() ? 72 : 32)) * com.tencent.mm.cb.a.getDensity(imageView.getContext())));
            com.tencent.mm.av.a.a bcV = q.bcV();
            c.a aVar2 = new c.a();
            aVar2.jbt = i4;
            aVar2.jbf = true;
            aVar2.jbv = String.valueOf(i3);
            c.a dr = aVar2.dr(jn, i2);
            dr.jaU = new n(2);
            dr.jbC = new com.tencent.mm.pluginsdk.ui.applet.e(2);
            dr.fullPath = s.bdu(u);
            bcV.a(u, imageView, dr.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, jn, i2, true, z2, dimensionPixelSize, aVar));
            AppMethodBeat.o(37164);
        }

        private void e(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37165);
            if (!this.pxZ) {
                String a2 = a(caVar, aVar.Pwc.getContext(), this.PMs);
                if (Util.isNullOrNil(a2)) {
                    AppMethodBeat.o(37165);
                    return;
                }
                Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", a2);
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.PMs);
                intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                intent.putExtra("Retr_MsgFromScene", 1);
                String str = caVar.field_talker;
                String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                intent.putExtra("reportSessionId", JX);
                ad.b G = ad.aVe().G(JX, true);
                G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                G.l("preUsername", str);
                G.l("preChatName", str);
                G.l("preMsgIndex", Integer.valueOf(this.PMs));
                G.l("sendAppMsgScene", 1);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                aVar.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(37165);
            } else if (!this.pxZ) {
                Log.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
                AppMethodBeat.o(37165);
            } else {
                com.tencent.mm.ui.chatting.s.a(this.PMs, aVar.Pwc.getContext(), caVar.field_content, caVar.field_talker, caVar.field_msgId, caVar.field_msgSvrId);
                AppMethodBeat.o(37165);
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar) {
            AppMethodBeat.i(37166);
            this.pxY = Util.nowSecond();
            switch (menuItem.getItemId()) {
                case 111:
                    final String N = br.N(caVar);
                    if (!Util.isNullOrNil(N)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 3, N);
                        com.tencent.mm.ui.base.h.a((Context) aVar.Pwc.getContext(), (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ak.j.AnonymousClass9 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(37148);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", N);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 1, N);
                                AppMethodBeat.o(37148);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ak.j.AnonymousClass10 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(169878);
                                j.a(j.this, aVar, caVar);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 2, N);
                                AppMethodBeat.o(169878);
                            }
                        });
                        break;
                    } else {
                        e(aVar, caVar);
                        break;
                    }
                case 114:
                    String a2 = a(caVar, aVar.Pwc.getContext(), 0);
                    if (!Util.isNullOrNil(a2)) {
                        an.c(caVar, a2, aVar.Pwc.getContext());
                        break;
                    }
                    break;
                case 126:
                    com.tencent.mm.ui.chatting.s.a(this.pxY, this.PMs, aVar.Pwc.getContext(), aVar.Pwc, (Activity) null, caVar);
                    break;
                case 144:
                    Intent intent = new Intent();
                    intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent);
                    break;
            }
            AppMethodBeat.o(37166);
            return false;
        }

        private static String a(ca caVar, Context context, int i2) {
            AppMethodBeat.i(37167);
            if (context == null) {
                Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
                AppMethodBeat.o(37167);
                return null;
            } else if (caVar == null) {
                Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
                AppMethodBeat.o(37167);
                return null;
            } else {
                String a2 = com.tencent.mm.ag.m.a(context, i2, caVar.field_content, caVar.field_talker, caVar.field_msgId);
                AppMethodBeat.o(37167);
                return a2;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        private void a(v vVar, View view) {
            AppMethodBeat.i(37168);
            com.tencent.mm.ui.chatting.s.a(vVar, view, this.PhN.getTalkerUserName());
            AppMethodBeat.o(37168);
        }

        private void a(v vVar, View view, final long j2, final long j3, final int i2) {
            AppMethodBeat.i(37169);
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(vVar.type)) {
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ak.j.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(169876);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        int intExtra = j.this.PhN.Pwc.getIntExtra("KOpenArticleSceneFromScene", 10000);
                        Bundle bundle = new Bundle();
                        bundle.putInt(e.b.OyQ, 0);
                        bundle.putInt(e.b.OyR, intExtra);
                        bundle.putInt("geta8key_scene", 7);
                        bundle.putString("geta8key_username", j.this.PhN.getTalkerUserName());
                        l.a(j.this.PhN.Pwc.getContext(), j2, j3, i2, bundle);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(169876);
                    }
                });
            }
            AppMethodBeat.o(37169);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends c.a {
        TextView PHZ;
        f PMe = new f();
        h PMf = new h();
        e PMg = new e();
        i PMh = new i();
        d PMi = new d();
        g PMj = new g();
        LinearLayout pxI;
        List<a> pxL = new ArrayList();

        c() {
            AppMethodBeat.i(37133);
            AppMethodBeat.o(37133);
        }

        public final c.a hc(View view) {
            AppMethodBeat.i(37134);
            LinearLayout linearLayout = this.pxI;
            a aVar = new a();
            aVar.puO = view;
            aVar.jBI = view.findViewById(R.id.it2);
            aVar.pxo = view.findViewById(R.id.bf0);
            aVar.ptR = (MMNeat7extView) view.findViewById(R.id.ipm);
            aVar.pxq = (TextView) view.findViewById(R.id.ied);
            aVar.pxr = view.findViewById(R.id.bgx);
            aVar.ptE = (ImageView) view.findViewById(R.id.bgv);
            aVar.pxu = (ImageView) view.findViewById(R.id.gcf);
            aVar.pxt = (ImageView) view.findViewById(R.id.awr);
            aVar.pxs = view.findViewById(R.id.a7p);
            aVar.pyp = (ImageView) view.findViewById(R.id.gbm);
            aVar.PMd = (TextView) view.findViewById(R.id.gbt);
            linearLayout.addView(view, linearLayout.getChildCount());
            this.pxL.add(aVar);
            AppMethodBeat.o(37134);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.pxI;
        }
    }

    /* access modifiers changed from: package-private */
    public static class f extends b {
        MMNeat7extView BCK;
        ImageView BCL;
        TextView PMm;
        View kmV;
        ImageView ptE;
        MMNeat7extView ptR;
        ImageView ptS;
        View puc;

        f() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ak.b
        public final void du(View view) {
            AppMethodBeat.i(37137);
            if (this.puO != null) {
                AppMethodBeat.o(37137);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8f);
            if (viewStub == null) {
                AppMethodBeat.o(37137);
                return;
            }
            viewStub.inflate();
            this.puO = view.findViewById(R.id.isf);
            this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.ipm);
            this.ptE = (ImageView) this.puO.findViewById(R.id.bgv);
            this.puc = this.puO.findViewById(R.id.bh1);
            this.kmV = this.puO.findViewById(R.id.aah);
            this.BCK = (MMNeat7extView) this.puO.findViewById(R.id.ir0);
            this.PMm = (TextView) this.puO.findViewById(R.id.br_);
            this.ptS = (ImageView) this.puO.findViewById(R.id.ggb);
            this.BCL = (ImageView) this.puO.findViewById(R.id.bhd);
            AppMethodBeat.o(37137);
        }
    }

    /* access modifiers changed from: package-private */
    public static class h extends b {
        ImageView kc;
        ImageView ptE;
        MMNeat7extView ptR;
        ImageView ptS;
        View puc;
        TextView timeTv;

        h() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ak.b
        public final void du(View view) {
            AppMethodBeat.i(37139);
            if (this.puO != null) {
                AppMethodBeat.o(37139);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8h);
            if (viewStub == null) {
                AppMethodBeat.o(37139);
                return;
            }
            viewStub.inflate();
            this.puO = view.findViewById(R.id.avt);
            this.ptE = (ImageView) this.puO.findViewById(R.id.bgv);
            this.ptG = (ImageView) this.puO.findViewById(R.id.bh9);
            this.ptS = (ImageView) this.puO.findViewById(R.id.ggb);
            this.kc = (ImageView) this.puO.findViewById(R.id.j51);
            this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.ir3);
            this.timeTv = (TextView) this.puO.findViewById(R.id.in3);
            this.puc = this.puO.findViewById(R.id.ayp);
            AppMethodBeat.o(37139);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends b {
        ImageView ptE;
        ImageView pxu;
        TextView pyj;
        ImageView pyk;

        d() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ak.b
        public final void du(View view) {
            AppMethodBeat.i(37135);
            if (this.puO != null) {
                AppMethodBeat.o(37135);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8c);
            if (viewStub == null) {
                AppMethodBeat.o(37135);
                return;
            }
            viewStub.inflate();
            this.puO = view.findViewById(R.id.avn);
            this.ptE = (ImageView) this.puO.findViewById(R.id.bgv);
            this.hbb = (TextView) this.puO.findViewById(R.id.ipm);
            this.pyj = (TextView) this.puO.findViewById(R.id.gd2);
            this.pxu = (ImageView) this.puO.findViewById(R.id.gcf);
            this.pyk = (ImageView) this.puO.findViewById(R.id.jja);
            this.ptG = (ImageView) this.puO.findViewById(R.id.bh9);
            AppMethodBeat.o(37135);
        }
    }

    /* access modifiers changed from: package-private */
    public static class e extends b {
        TextView PMd;
        MMNeat7extView PMk;
        View PMl;
        ImageView kc;
        ImageView ptE;
        ImageView ptS;
        View puc;

        e() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ak.b
        public final void du(View view) {
            AppMethodBeat.i(37136);
            if (this.puO != null) {
                AppMethodBeat.o(37136);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8d);
            if (viewStub == null) {
                AppMethodBeat.o(37136);
                return;
            }
            viewStub.inflate();
            this.puO = view.findViewById(R.id.avp);
            this.ptE = (ImageView) this.puO.findViewById(R.id.bgv);
            this.ptG = (ImageView) this.puO.findViewById(R.id.bh9);
            this.ptS = (ImageView) this.puO.findViewById(R.id.ggb);
            this.kc = (ImageView) this.puO.findViewById(R.id.gbm);
            this.puc = this.puO.findViewById(R.id.axw);
            this.PMd = (TextView) this.puO.findViewById(R.id.gbt);
            this.PMk = (MMNeat7extView) this.puO.findViewById(R.id.hsa);
            this.PMl = this.puO.findViewById(R.id.hsd);
            AppMethodBeat.o(37136);
        }
    }

    /* access modifiers changed from: package-private */
    public static class i extends b {
        TextView pwO;
        ImageView pxu;

        i() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ak.b
        public final void du(View view) {
            AppMethodBeat.i(37140);
            if (this.puO != null) {
                AppMethodBeat.o(37140);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8i);
            if (viewStub == null) {
                AppMethodBeat.o(37140);
                return;
            }
            viewStub.inflate();
            this.puO = view.findViewById(R.id.avv);
            this.hbb = (TextView) this.puO.findViewById(R.id.ipm);
            this.pwO = (TextView) this.puO.findViewById(R.id.in3);
            this.pxu = (ImageView) this.puO.findViewById(R.id.gcf);
            AppMethodBeat.o(37140);
        }
    }

    /* access modifiers changed from: package-private */
    public static class g extends b {
        TextView PMn;
        LinearLayout PMo;
        MMNeat7extView ptR;

        g() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ak.b
        public final void du(View view) {
            AppMethodBeat.i(37138);
            if (this.puO != null) {
                AppMethodBeat.o(37138);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8g);
            if (viewStub == null) {
                AppMethodBeat.o(37138);
                return;
            }
            viewStub.inflate();
            this.puO = view.findViewById(R.id.avr);
            this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.ipm);
            this.PMn = (TextView) this.puO.findViewById(R.id.ik9);
            this.PMo = (LinearLayout) this.puO.findViewById(R.id.ikm);
            AppMethodBeat.o(37138);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        TextView hbb;
        ImageView ptG;
        View puO;

        b() {
        }

        public void du(View view) {
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        TextView PMd;
        View jBI;
        ImageView ptE;
        MMNeat7extView ptR;
        View puO;
        View pxo;
        TextView pxq;
        View pxr;
        View pxs;
        ImageView pxt;
        ImageView pxu;
        ImageView pyp;

        a() {
        }
    }
}
