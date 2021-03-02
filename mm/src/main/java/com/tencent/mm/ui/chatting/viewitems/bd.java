package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.g.b.a.ia;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.l.a;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;

public final class bd {
    private static final int PKK = R.id.awq;
    private static final int PKL = R.id.awp;

    public static class b extends c implements t.n, NeatTextView.b {
        private static final int PKJ = R.id.ih3;
        private int PHj = -1;
        private e POQ;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private CharSequence PkM;
        private int hcg = -1;

        private e gUg() {
            AppMethodBeat.i(37408);
            if (this.POQ == null) {
                this.POQ = new e(this.PhN);
            }
            e eVar = this.POQ;
            AppMethodBeat.o(37408);
            return eVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean bM(int i2, boolean z) {
            if (!z || (i2 != 1 && i2 != 11 && i2 != 21 && i2 != 31 && i2 != 36 && i2 != 301989937)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37409);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sk);
                view.setTag(new f().G(view, false));
            }
            AppMethodBeat.o(37409);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public void a(c.a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
            boolean z;
            String str2;
            SpannableString a2;
            boolean z2;
            ChattingItemTranslate.c cVar;
            String str3;
            String str4;
            AppMethodBeat.i(37410);
            this.PhN = aVar2;
            final f fVar = (f) aVar;
            fVar.POU.setTag(bd.PKK, Long.valueOf(caVar.field_msgId));
            fVar.POU.setTag(bd.PKL, Boolean.TRUE);
            fVar.POU.setMaxLines(Integer.MAX_VALUE);
            ChattingItemTranslate.a aVar3 = new ChattingItemTranslate.a(caVar, aVar2.gRM(), i2);
            aVar3.PQG = false;
            fVar.POU.setTag(aVar3);
            if (gTW()) {
                b((c.a) fVar, false);
                if (caVar.field_status == 1 || caVar.field_status == 5) {
                    if (fVar.PIn != null) {
                        fVar.PIn.setVisibility(8);
                    }
                    fVar.POU.setBackgroundResource(R.drawable.or);
                    caVar.OqF = true;
                } else {
                    fVar.POU.setBackgroundResource(R.drawable.oq);
                    if (fVar.PIn != null) {
                        if (b((k) aVar2.bh(k.class), caVar.field_msgId)) {
                            if (caVar.OqF) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                fVar.POU.startAnimation(alphaAnimation);
                                caVar.OqF = false;
                            }
                            fVar.PIn.setVisibility(0);
                        } else {
                            fVar.PIn.setVisibility(8);
                        }
                    }
                }
            } else {
                b(fVar, caVar.field_status < 2);
            }
            String str5 = caVar.field_content;
            if (Util.isNullOrNil(str5)) {
                Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
            }
            if (caVar.fqK == null || !caVar.gDV()) {
                z = false;
            } else {
                z = true;
            }
            a.C2099a aVar4 = com.tencent.mm.ui.chatting.l.a.PEV;
            a.C2099a.a(fVar.POU, caVar, aVar2.gRM(), str);
            Bundle Ao = com.tencent.mm.pluginsdk.ui.span.t.Ao(aVar2.gRM());
            Bundle cN = bd.cN(caVar);
            cN.putAll(Ao);
            if (!z) {
                a2 = l.a(fVar.POU.getContext(), str5, (int) fVar.POU.getTextSize(), 4, cN, cO(caVar), 0, l.Krf);
                am amVar = (am) aVar2.bh(am.class);
                if (amVar.Nz(caVar.field_msgId)) {
                    fVar.POU.a(com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(a2, amVar.gQU(), e.a.Background, b.C1383b.wZS)).wWu, TextView.BufferType.SPANNABLE);
                    z2 = false;
                } else {
                    z2 = true;
                }
                p[] pVarArr = (p[]) a2.getSpans(0, a2.length(), p.class);
                int length = pVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (pVarArr[i3].getType() == 44) {
                        h.INSTANCE.a(12809, 6, "");
                        break;
                    } else {
                        i3++;
                    }
                }
            } else {
                if (caVar.fqK.contains("notify@all")) {
                    str2 = "";
                } else {
                    str2 = fVar.POU.getContext().getString(R.string.g8d, "@") + "\n";
                }
                cN.putInt("geta8key_scene", 31);
                a2 = l.a(fVar.POU.getContext(), new StringBuilder().append((Object) str2).append((Object) str5).toString(), (int) fVar.POU.getTextSize(), 4, cN, cO(caVar), 0, l.Krf);
                z2 = true;
            }
            if (z2) {
                bd.a(fVar.POU.getContext(), aVar2, caVar.field_content, a2, fVar.POU, caVar, 4);
            }
            if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(caVar)) {
                fVar.tln.setText(aVar2.Pwc.getMMResources().getString(R.string.dw8));
                fVar.tln.setVisibility(0);
                fVar.tln.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.b.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(37402);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.ChattingItemTextTo", "sourceTV click msgId:%s", fVar.POU.getTag(bd.PKK));
                        s.a(aVar2, ((Long) fVar.POU.getTag(bd.PKK)).longValue(), 1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(37402);
                    }
                });
            } else {
                fVar.tln.setVisibility(8);
            }
            bd.a(caVar, fVar, aVar2);
            final Context context = fVar.POU.getContext();
            fVar.POU.setTag(PKJ, Boolean.TRUE);
            if (fVar.wnj == null) {
                fVar.wnj = new com.tencent.mm.ui.widget.b.a(context, fVar.POU);
                fVar.wnj.QwU = new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.b.AnonymousClass2 */

                    public final void onDismiss() {
                        AppMethodBeat.i(180033);
                        aVar2.setFocused(true);
                        c.a(fVar.wnj, aVar2, b.this.hcg, b.this.PHj, 1);
                        b.this.hcg = -1;
                        b.this.PHj = -1;
                        AppMethodBeat.o(180033);
                    }
                };
                fVar.wnj.QSv = true;
                fVar.wnj.QSy = false;
                fVar.wnj.QSt = new o.e() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.b.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.base.o.e
                    public final void a(m mVar, View view) {
                        int i2;
                        String str;
                        boolean z;
                        AppMethodBeat.i(233924);
                        mVar.clear();
                        mVar.a(0, 0, context.getResources().getString(R.string.t_), R.raw.icons_filled_copy);
                        CharSequence hiT = fVar.POU.hiT();
                        bq bqVar = (bq) fVar.POU.getTag();
                        if (bqVar != null) {
                            i2 = br.O(bqVar.dTX);
                        } else {
                            i2 = 0;
                        }
                        if (i2 <= 0 || i2 >= hiT.length()) {
                            mVar.a(0, 1, context.getResources().getString(R.string.f08), R.raw.icons_filled_allselect);
                        }
                        mVar.a(0, 2, context.getResources().getString(R.string.f06), R.raw.icons_filled_share);
                        mVar.a(0, 3, context.getResources().getString(R.string.c8z), R.raw.icons_filled_favorites);
                        if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) {
                            mVar.a(0, 4, context.getResources().getString(R.string.b0n), R.raw.icons_filled_search_logo);
                            if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                                String checkFirstHotWord = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(b.this.PkM.toString());
                                if (!Util.isNullOrNil(checkFirstHotWord)) {
                                    b.this.a(fVar.wnj, aVar2, checkFirstHotWord);
                                }
                                str = checkFirstHotWord;
                            } else {
                                str = "";
                            }
                            if (Util.isNullOrNil(str)) {
                                fVar.wnj.QSA = null;
                            }
                            String str2 = "65_" + cl.aWA();
                            b bVar = b.this;
                            com.tencent.mm.ui.chatting.e.a aVar = aVar2;
                            ca caVar = caVar;
                            if (!Util.isNullOrNil(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bVar.a(aVar, caVar, 1, z, b.this.PkM.toString(), true, str2);
                        }
                        AppMethodBeat.o(233924);
                    }
                };
                fVar.wnj.HLY = new o.g() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.b.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        String str;
                        anh anh;
                        bq bqVar;
                        AppMethodBeat.i(180035);
                        b.this.hcg = i2;
                        b.this.PHj = menuItem.getItemId();
                        switch (menuItem.getItemId()) {
                            case 0:
                                ClipboardHelper.setText(MMApplicationContext.getContext(), b.this.PkM, b.this.PkM);
                                if (fVar.PKE != null) {
                                    fVar.PKE.hbA();
                                    fVar.PKE.QXW = true;
                                    fVar.PKE.QXX = true;
                                    fVar.PKE.hbz();
                                }
                                Toast.makeText(context, (int) R.string.ta, 0).show();
                                try {
                                    bq bqVar2 = (bq) fVar.POU.getTag();
                                    if (bqVar2 != null) {
                                        String g2 = ((au) aVar2.bh(au.class)).g(bqVar2.dTX, false);
                                        ia iaVar = new ia();
                                        iaVar.eMJ = bqVar2.dTX.field_msgSvrId;
                                        iaVar.eML = g2.length();
                                        iaVar.eMK = b.this.PkM.length();
                                        iaVar.eMM = br.O(bqVar2.dTX);
                                        iaVar.bfK();
                                        bd.c(bqVar2.dTX, 3, b.this.PkM.length());
                                    }
                                    AppMethodBeat.o(180035);
                                    return;
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", e2.getMessage());
                                    AppMethodBeat.o(180035);
                                    return;
                                }
                            case 1:
                                if (fVar.PKE != null) {
                                    if (fVar.PKE.QXQ != null) {
                                        fVar.PKE.QXQ.gTY();
                                    }
                                    fVar.PKE.QXW = true;
                                    fVar.PKE.hbz();
                                    fVar.PKE.lE(0, fVar.POU.hiT().length());
                                    fVar.PKE.hcQ();
                                    fVar.PKE.hcT();
                                    if (fVar.PKE.QXQ != null) {
                                        fVar.PKE.QXQ.gTZ();
                                        AppMethodBeat.o(180035);
                                        return;
                                    }
                                }
                                break;
                            case 2:
                                bd.c(caVar, 4, 0);
                                Intent intent = new Intent(context, MsgRetransmitUI.class);
                                intent.putExtra("Retr_Msg_content", b.this.PkM);
                                intent.putExtra("Retr_Msg_Type", 4);
                                Context context = context;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(180035);
                                return;
                            case 3:
                                bd.c(caVar, 5, 0);
                                cz czVar = new cz();
                                com.tencent.mm.pluginsdk.model.h.b(czVar, b.this.PkM.toString(), 1);
                                czVar.dFZ.fragment = b.this.PhN.Pwc;
                                czVar.dFZ.dGf = 43;
                                if (!(czVar.dFZ.dGb == null || (anh = czVar.dFZ.dGb.Lya) == null || (bqVar = (bq) fVar.POU.getTag()) == null)) {
                                    anh.bhf(z.aTY());
                                    anh.bhg(bqVar.dTX.field_talker);
                                    EventCenter.instance.publish(czVar);
                                }
                                if (fVar.PKE != null) {
                                    fVar.PKE.hbA();
                                    fVar.PKE.QXW = true;
                                    fVar.PKE.QXX = true;
                                    fVar.PKE.hbz();
                                    AppMethodBeat.o(180035);
                                    return;
                                }
                                break;
                            case 4:
                                String str2 = "65_" + cl.aWA();
                                String charSequence = b.this.PkM.toString();
                                if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                                    str = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(charSequence);
                                } else {
                                    str = "";
                                }
                                b.this.a(aVar2, caVar, 2, !Util.isNullOrNil(str), charSequence, true, str2);
                                ag agVar = new ag();
                                agVar.context = context;
                                agVar.scene = 65;
                                agVar.query = charSequence;
                                agVar.sessionId = str2;
                                agVar.IEk = true;
                                ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(agVar);
                                break;
                        }
                        AppMethodBeat.o(180035);
                    }
                };
            }
            bd.a(aVar2, br.P(caVar), a2, fVar.POU);
            if (br.B(caVar) || br.J(caVar)) {
                fVar.POU.setTag(PKJ, Boolean.FALSE);
                fVar.POU.setOnTouchListener(fVar.PKF);
                fVar.POU.setOnLongClickListener(c(aVar2));
                fVar.POU.setOnClickListener(gUg());
            } else {
                int O = br.O(caVar);
                if (O <= 0 || O >= com.tencent.mm.ui.widget.textview.b.hB(fVar.POU).length()) {
                    O = 0;
                }
                if (fVar.PKE != null) {
                    fVar.PKE.destroy();
                }
                c.View$OnLongClickListenerC2106c c2 = c(aVar2);
                a.f a3 = a(c(aVar2));
                int[] iArr = new int[2];
                int i4 = 0;
                if (fVar.POU != null) {
                    fVar.POU.getLocationInWindow(iArr);
                    i4 = iArr[0];
                    if (i4 == 0) {
                        Rect rect = new Rect();
                        fVar.POU.getGlobalVisibleRect(rect);
                        i4 = rect.left;
                    }
                }
                a.C2147a aVar5 = new a.C2147a(fVar.POU, fVar.wnj, a3, gUg(), fVar.PKF);
                aVar5.QPi = R.color.j0;
                aVar5.QYg = 18;
                aVar5.QPj = R.color.iy;
                if (i4 != 0) {
                    aVar5.QYh = i4 + at.aH(fVar.POU.getContext(), R.dimen.c5);
                }
                fVar.PKE = aVar5.hcW();
                fVar.PKG = new d(fVar.PKE);
                fVar.PKE.QXO = new x() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.b.AnonymousClass5 */

                    @Override // com.tencent.mm.ui.widget.textview.a.d
                    public final void as(CharSequence charSequence) {
                        AppMethodBeat.i(180036);
                        b.this.PkM = charSequence;
                        AppMethodBeat.o(180036);
                    }
                };
                fVar.PGP = new a.f() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.b.AnonymousClass6 */

                    @Override // com.tencent.mm.ui.widget.textview.a.f
                    public final void dismiss() {
                        AppMethodBeat.i(180037);
                        fVar.PKE.hbA();
                        fVar.PKE.QXW = true;
                        fVar.PKE.QXX = true;
                        fVar.PKE.hbz();
                        AppMethodBeat.o(180037);
                    }
                };
                fVar.PKE.QXU = O;
                c2.PGP = fVar.PGP;
                fVar.PKE.QYc = fVar.PKG;
            }
            fVar.POU.setOnDoubleClickListener(this);
            fVar.POU.setTextListener(new MMNeat7extView.a() {
                /* class com.tencent.mm.ui.chatting.viewitems.bd.b.AnonymousClass7 */

                @Override // com.tencent.mm.ui.widget.MMNeat7extView.a
                public final void at(CharSequence charSequence) {
                    AppMethodBeat.i(180038);
                    if (((Boolean) fVar.POU.getTag(bd.PKL)).booleanValue()) {
                        com.tencent.mm.ui.chatting.m.a.a.gTK();
                        com.tencent.mm.ui.chatting.m.a.a.gTL().a(charSequence, ((Long) fVar.POU.getTag(bd.PKK)).longValue());
                    }
                    AppMethodBeat.o(180038);
                }
            });
            ChattingItemTranslate.c cVar2 = ChattingItemTranslate.c.NoTransform;
            if (com.tencent.mm.app.plugin.c.Xn()) {
                if (!caVar.gDz() || !caVar.gDI()) {
                    str3 = null;
                } else {
                    str3 = caVar.field_transContent;
                }
                cVar = ((au) aVar2.bh(au.class)).cj(caVar);
            } else {
                cVar = cVar2;
                str3 = null;
            }
            if (!Util.isNullOrNil(str3) || cVar != ChattingItemTranslate.c.NoTransform) {
                if (fVar.PKI == null) {
                    fVar.PKI = (ChattingItemTranslate) fVar.PKH.inflate();
                    fVar.PKI.init();
                }
                fVar.PKI.a(l.a(fVar.POU.getContext(), str3, (int) fVar.POU.getTextSize(), 1, cN, cO(caVar)), cVar);
                ChattingItemTranslate chattingItemTranslate = fVar.PKI;
                if (Util.isNullOrNil(caVar.field_transBrandWording)) {
                    str4 = aVar2.Pwc.getMMResources().getString(R.string.ho8);
                } else {
                    str4 = caVar.field_transBrandWording;
                }
                chattingItemTranslate.setBrandWording(str4);
                if (!Util.isNullOrNil(str3)) {
                    ChattingItemTranslate.a aVar6 = new ChattingItemTranslate.a(caVar, aVar2.gRM(), i2);
                    aVar6.qcr = 2;
                    fVar.PKI.setTag(aVar6);
                    fVar.PKI.getContentView().setTag(aVar6);
                    fVar.PKI.setOnClickListener(gUg());
                    fVar.PKI.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
                    fVar.PKI.setOnDoubleClickListener(this);
                    fVar.PKI.setOnLongClickListener(c(aVar2));
                    fVar.PKI.setVisibility(0);
                }
            } else if (fVar.PKI != null) {
                fVar.PKI.setVisibility(8);
            }
            a(i2, fVar, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(37410);
        }

        private void bK(ca caVar) {
            AppMethodBeat.i(37411);
            if (!this.PhN.getTalkerUserName().equals("medianote")) {
                bg.aVF();
                com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.f(caVar.field_talker, caVar.field_msgSvrId));
            }
            ak.bK(caVar);
            this.PhN.BN(true);
            AppMethodBeat.o(37411);
        }

        private String cO(ca caVar) {
            AppMethodBeat.i(37412);
            if (caVar != null) {
                String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                ad.b G = ad.aVe().G(JX, true);
                G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                G.l("preUsername", a(this.PhN, caVar));
                G.l("preChatName", b(this.PhN, caVar));
                AppMethodBeat.o(37412);
                return JX;
            }
            AppMethodBeat.o(37412);
            return null;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        @Deprecated
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.CharSequence] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x012d  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x01cb  */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.view.MenuItem r15, com.tencent.mm.ui.chatting.e.a r16, com.tencent.mm.ui.chatting.viewitems.bq r17) {
            /*
            // Method dump skipped, instructions count: 708
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.bd.b.a(android.view.MenuItem, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ui.chatting.viewitems.bq):boolean");
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233926);
            caVar.unsetOmittedFailResend();
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            if (caVar.isText() && caVar.field_isSend == 1) {
                bK(caVar);
            }
            AppMethodBeat.o(233926);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
        public final boolean gS(View view) {
            String g2;
            AppMethodBeat.i(37416);
            if (v.gQ(view)) {
                Log.i("MicroMsg.ChattingItemTextTo", "onDoubleTap solitaire fold double click");
                AppMethodBeat.o(37416);
            } else {
                Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
                intent.addFlags(67108864);
                if (view.getTag() instanceof ChattingItemTranslate.a) {
                    ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
                    intent.putExtra("Chat_Msg_Id", aVar.dTX.field_msgId);
                    if (((com.tencent.mm.ui.chatting.d.b.x) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.x.class)).cd(aVar.dTX)) {
                        g2 = ((MMNeat7extView) view).hiT().toString();
                    } else {
                        g2 = ((au) this.PhN.bh(au.class)).g(aVar.dTX, aVar.qcr == 2);
                    }
                    intent.putExtra("key_chat_text", g2);
                    intent.putExtra("is_group_chat", this.PhN.gRM());
                    ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(aVar.dTX.field_talker);
                    Context context = view.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.ui.base.b.kc(view.getContext());
                }
                AppMethodBeat.o(37416);
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean a(m mVar, View view, ca caVar) {
            boolean z;
            AppMethodBeat.i(233925);
            if (caVar.fqK == null || !caVar.fqK.contains("announcement@all")) {
                z = false;
            } else {
                z = true;
            }
            if (caVar.isText() || caVar.gDg()) {
                ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
                int i2 = aVar.position;
                if (aVar.qcr == 1) {
                    if (caVar.isText()) {
                        if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(caVar)) {
                            mVar.a(i2, 151, this.PhN.Pwc.getMMResources().getString(R.string.dw3), R.raw.icons_filled_continued_form);
                        }
                        if (!br.J(caVar)) {
                            mVar.a(i2, 102, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                        }
                    }
                    if (!br.J(caVar)) {
                        mVar.a(i2, 108, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                    }
                    if (caVar.field_status == 5) {
                        mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                    }
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                    }
                    if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                        mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                    }
                    if (!z && !caVar.gAt() && caVar.isText() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName()))) {
                        mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                    }
                    if (com.tencent.mm.app.plugin.c.Xn() && (!caVar.gDz() || !caVar.gDI())) {
                        mVar.a(i2, 124, view.getContext().getString(R.string.b0r), R.raw.icons_filled_translate);
                    }
                    if (caVar.isText() && com.tencent.mm.al.g.aZH()) {
                        this.PhN.gRN();
                    }
                    if (!this.PhN.gRN()) {
                        mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                    }
                    if (br.B(caVar) || br.P(caVar) == 4) {
                        mVar.clear();
                        if (!this.PhN.gRN()) {
                            mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                        }
                    }
                } else if (aVar.qcr == 2) {
                    mVar.a(i2, 141, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                    mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_3, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_4, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                    }
                    if (com.tencent.mm.app.plugin.c.Xn()) {
                        if (caVar.gDz() && caVar.gDI()) {
                            mVar.a(i2, 124, view.getContext().getString(R.string.b0p), R.raw.icons_filled_eyes_off);
                        }
                        if (caVar.gDL()) {
                            mVar.a(i2, 125, view.getContext().getString(R.string.b0h), R.raw.icons_filled_refresh);
                        }
                    }
                    AppMethodBeat.o(233925);
                    return false;
                }
                AppMethodBeat.o(233925);
                return true;
            }
            AppMethodBeat.o(233925);
            return true;
        }
    }

    public static class a extends c implements NeatTextView.b {
        private static final int PKJ = R.id.ih3;
        private static final int PKK = R.id.awq;
        private static final int PKL = R.id.awp;
        private int PHj = -1;
        private e POQ;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private CharSequence PkM;
        private int hcg = -1;

        private e gUg() {
            AppMethodBeat.i(37393);
            if (this.POQ == null) {
                this.POQ = new e(this.PhN);
            }
            e eVar = this.POQ;
            AppMethodBeat.o(37393);
            return eVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean bM(int i2, boolean z) {
            if (z || (i2 != 1 && i2 != 11 && i2 != 21 && i2 != 31 && i2 != 36 && i2 != 301989937)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37394);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.r6);
                view.setTag(new f().G(view, true));
            }
            AppMethodBeat.o(37394);
            return view;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37395);
            boolean gRM = aVar.gRM();
            AppMethodBeat.o(37395);
            return gRM;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public void a(c.a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
            ChattingItemTranslate.c cVar;
            String str2;
            String str3;
            String str4;
            String str5;
            boolean z;
            String str6;
            String str7;
            SpannableString a2;
            boolean z2;
            int Kp;
            String str8;
            AppMethodBeat.i(37396);
            this.PhN = aVar2;
            final f fVar = (f) aVar;
            String str9 = caVar.field_content;
            String talkerUserName = aVar2.getTalkerUserName();
            fVar.POU.setTag(PKK, Long.valueOf(caVar.field_msgId));
            fVar.POU.setTag(PKL, Boolean.TRUE);
            fVar.POU.setTag(new ChattingItemTranslate.a(caVar, aVar2.gRM(), i2));
            ChattingItemTranslate.c cVar2 = ChattingItemTranslate.c.NoTransform;
            if (com.tencent.mm.app.plugin.c.Xn()) {
                if (!caVar.gDz() || !caVar.gDI()) {
                    str8 = null;
                } else {
                    str8 = caVar.field_transContent;
                }
                cVar = ((au) aVar2.bh(au.class)).cj(caVar);
                str2 = str8;
            } else {
                cVar = cVar2;
                str2 = null;
            }
            if (!aVar2.gRM() || ((com.tencent.mm.ui.chatting.d.b.d) aVar2.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP() || (Kp = bp.Kp(str9)) == -1) {
                str3 = str2;
                str4 = str9;
                str5 = talkerUserName;
            } else {
                str5 = str9.substring(0, Kp).trim();
                if (str5 == null || str5.length() <= 0) {
                    str5 = talkerUserName;
                }
                str4 = str9.substring(Kp + 1).trim();
                str3 = !Util.isNullOrNil(str2) ? str2.substring(Kp + 1).trim() : str2;
            }
            a(fVar, aVar2, caVar, str5);
            a(fVar, aVar2, str5, caVar);
            if (caVar.fqK == null || !caVar.gDV()) {
                z = false;
            } else {
                z = true;
            }
            a.C2099a aVar3 = com.tencent.mm.ui.chatting.l.a.PEV;
            a.C2099a.a(fVar.POU, caVar, aVar2.gRM(), str5);
            Bundle Ao = com.tencent.mm.pluginsdk.ui.span.t.Ao(aVar2.gRM());
            Bundle cN = bd.cN(caVar);
            cN.putAll(Ao);
            SpannableString spannableString = null;
            boolean z3 = true;
            if (!z) {
                if (as.bjp(str5)) {
                    a2 = l.a(fVar.POU.getContext(), str4, (int) fVar.POU.getTextSize(), cN, cO(caVar), l.Krf);
                } else {
                    a2 = l.a(fVar.POU.getContext(), str4, (int) fVar.POU.getTextSize(), 1, cN, cO(caVar), 0, l.Krf);
                }
                am amVar = (am) aVar2.bh(am.class);
                if (amVar.Nz(caVar.field_msgId)) {
                    fVar.POU.a(com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(a2, amVar.gQU(), e.a.Background, b.C1383b.wZR)).wWu, TextView.BufferType.SPANNABLE);
                    z2 = false;
                } else {
                    z2 = true;
                }
                p[] pVarArr = (p[]) a2.getSpans(0, a2.length(), p.class);
                int length = pVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z3 = z2;
                        spannableString = a2;
                        break;
                    } else if (pVarArr[i3].getType() == 44) {
                        h.INSTANCE.a(12809, 7, "");
                        z3 = z2;
                        spannableString = a2;
                        break;
                    } else {
                        i3++;
                    }
                }
            } else if (z) {
                if (caVar.fqK.contains("notify@all")) {
                    str6 = "";
                } else {
                    str6 = fVar.POU.getContext().getString(R.string.g8d, "@") + "\n";
                }
                cN.putInt("geta8key_scene", 31);
                if (as.bjp(str5)) {
                    spannableString = l.a(fVar.POU.getContext(), new StringBuilder().append((Object) str6).append((Object) str4).toString(), (int) fVar.POU.getTextSize(), cN, cO(caVar), l.Krf);
                } else {
                    spannableString = l.a(fVar.POU.getContext(), new StringBuilder().append((Object) str6).append((Object) str4).toString(), (int) fVar.POU.getTextSize(), 1, cN, cO(caVar), 0, l.Krf);
                }
            }
            if (z3) {
                bd.a(fVar.POU.getContext(), aVar2, caVar.field_content, spannableString, fVar.POU, caVar, 1);
            }
            if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(caVar)) {
                fVar.tln.setText(aVar2.Pwc.getMMResources().getString(R.string.dw8));
                fVar.tln.setVisibility(0);
                fVar.tln.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(37383);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.ChattingItemTextFrom", "sourceTV click msgId:%s", fVar.POU.getTag(a.PKK));
                        s.a(aVar2, ((Long) fVar.POU.getTag(a.PKK)).longValue(), 1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(37383);
                    }
                });
            } else {
                fVar.tln.setVisibility(8);
            }
            bd.a(caVar, fVar, aVar2);
            final Context context = fVar.POU.getContext();
            fVar.POU.setTag(PKJ, Boolean.TRUE);
            if (fVar.wnj == null) {
                fVar.wnj = new com.tencent.mm.ui.widget.b.a(context, fVar.POU);
                fVar.wnj.QwU = new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass2 */

                    public final void onDismiss() {
                        AppMethodBeat.i(180024);
                        aVar2.setFocused(true);
                        c.a(fVar.wnj, aVar2, a.this.hcg, a.this.PHj, 1);
                        a.this.hcg = -1;
                        a.this.PHj = -1;
                        AppMethodBeat.o(180024);
                    }
                };
                fVar.wnj.QSv = true;
                fVar.wnj.QSy = false;
                fVar.wnj.QSt = new o.e() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.base.o.e
                    public final void a(m mVar, View view) {
                        int i2;
                        String str;
                        boolean z;
                        AppMethodBeat.i(233922);
                        mVar.clear();
                        mVar.a(0, 0, context.getResources().getString(R.string.t_), R.raw.icons_filled_copy);
                        CharSequence hiT = fVar.POU.hiT();
                        bq bqVar = (bq) fVar.POU.getTag();
                        if (bqVar != null) {
                            i2 = br.O(bqVar.dTX);
                        } else {
                            i2 = 0;
                        }
                        if (i2 <= 0 || i2 >= hiT.length()) {
                            mVar.a(0, 1, context.getResources().getString(R.string.f08), R.raw.icons_filled_allselect);
                        }
                        mVar.a(0, 2, context.getResources().getString(R.string.f06), R.raw.icons_filled_share);
                        mVar.a(0, 3, context.getResources().getString(R.string.c8z), R.raw.icons_filled_favorites);
                        if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) {
                            mVar.a(0, 4, context.getResources().getString(R.string.b0n), R.raw.icons_filled_search_logo);
                            if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                                String checkFirstHotWord = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(a.this.PkM.toString());
                                if (!Util.isNullOrNil(checkFirstHotWord)) {
                                    a.this.a(fVar.wnj, aVar2, checkFirstHotWord);
                                }
                                str = checkFirstHotWord;
                            } else {
                                str = "";
                            }
                            if (Util.isNullOrNil(str)) {
                                fVar.wnj.QSA = null;
                            }
                            String str2 = "65_" + cl.aWA();
                            a aVar = a.this;
                            com.tencent.mm.ui.chatting.e.a aVar2 = aVar2;
                            ca caVar = caVar;
                            if (!Util.isNullOrNil(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            aVar.a(aVar2, caVar, 1, z, a.this.PkM.toString(), true, str2);
                        }
                        AppMethodBeat.o(233922);
                    }
                };
                fVar.wnj.HLY = new o.g() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        String str;
                        anh anh;
                        bq bqVar;
                        AppMethodBeat.i(180028);
                        a.this.PHj = menuItem.getItemId();
                        a.this.hcg = i2;
                        switch (menuItem.getItemId()) {
                            case 0:
                                ClipboardHelper.setText(MMApplicationContext.getContext(), a.this.PkM, a.this.PkM);
                                if (fVar.PKE != null) {
                                    fVar.PKE.hbA();
                                    fVar.PKE.QXW = true;
                                    fVar.PKE.QXX = true;
                                    fVar.PKE.hbz();
                                }
                                Toast.makeText(context, (int) R.string.ta, 0).show();
                                try {
                                    bq bqVar2 = (bq) fVar.POU.getTag();
                                    if (bqVar2 != null) {
                                        String g2 = ((au) aVar2.bh(au.class)).g(bqVar2.dTX, false);
                                        ia iaVar = new ia();
                                        iaVar.eMJ = bqVar2.dTX.field_msgSvrId;
                                        iaVar.eML = g2.length();
                                        iaVar.eMK = a.this.PkM.length();
                                        iaVar.eMM = br.O(bqVar2.dTX);
                                        iaVar.bfK();
                                        bd.c(bqVar2.dTX, 3, a.this.PkM.length());
                                    }
                                    AppMethodBeat.o(180028);
                                    return;
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", e2.getMessage());
                                    AppMethodBeat.o(180028);
                                    return;
                                }
                            case 1:
                                if (fVar.PKE != null) {
                                    if (fVar.PKE.QXQ != null) {
                                        fVar.PKE.QXQ.gTY();
                                    }
                                    fVar.PKE.QXW = true;
                                    fVar.PKE.hbz();
                                    fVar.PKE.lE(0, fVar.POU.hiT().length());
                                    fVar.PKE.hcQ();
                                    fVar.PKE.hcT();
                                    if (fVar.PKE.QXQ != null) {
                                        fVar.PKE.QXQ.gTZ();
                                        AppMethodBeat.o(180028);
                                        return;
                                    }
                                }
                                break;
                            case 2:
                                bq bqVar3 = (bq) fVar.POU.getTag();
                                if (bqVar3 != null) {
                                    bd.c(bqVar3.dTX, 4, 0);
                                    final String N = br.N(bqVar3.dTX);
                                    if (Util.isNullOrNil(N)) {
                                        Intent intent = new Intent(context, MsgRetransmitUI.class);
                                        intent.putExtra("Retr_Msg_content", a.this.PkM);
                                        intent.putExtra("Retr_Msg_Type", 4);
                                        Context context = context;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        context.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(180028);
                                        return;
                                    }
                                    h.INSTANCE.a(17509, 4, N);
                                    com.tencent.mm.ui.base.h.a(context, (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass4.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(180026);
                                            Intent intent = new Intent();
                                            intent.putExtra("rawUrl", N);
                                            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                                            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                                            com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                            h.INSTANCE.a(17509, 1, N);
                                            AppMethodBeat.o(180026);
                                        }
                                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass4.AnonymousClass2 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(180027);
                                            Intent intent = new Intent(context, MsgRetransmitUI.class);
                                            intent.putExtra("Retr_Msg_content", a.this.PkM);
                                            intent.putExtra("Retr_Msg_Type", 4);
                                            Context context = context;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            context.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            h.INSTANCE.a(17509, 2, N);
                                            AppMethodBeat.o(180027);
                                        }
                                    });
                                    AppMethodBeat.o(180028);
                                    return;
                                }
                                break;
                            case 3:
                                cz czVar = new cz();
                                com.tencent.mm.pluginsdk.model.h.b(czVar, a.this.PkM.toString(), 1);
                                czVar.dFZ.fragment = a.this.PhN.Pwc;
                                czVar.dFZ.dGf = 43;
                                if (!(czVar.dFZ.dGb == null || (anh = czVar.dFZ.dGb.Lya) == null || (bqVar = (bq) fVar.POU.getTag()) == null)) {
                                    bd.c(bqVar.dTX, 5, 0);
                                    anh.bhf(bqVar.dTX.field_talker);
                                    anh.bhg(z.aTY());
                                    EventCenter.instance.publish(czVar);
                                }
                                if (fVar.PKE != null) {
                                    fVar.PKE.hbA();
                                    fVar.PKE.QXW = true;
                                    fVar.PKE.QXX = true;
                                    fVar.PKE.hbz();
                                    AppMethodBeat.o(180028);
                                    return;
                                }
                                break;
                            case 4:
                                String str2 = "65_" + cl.aWA();
                                String charSequence = a.this.PkM.toString();
                                if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                                    str = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(charSequence);
                                } else {
                                    str = "";
                                }
                                a.this.a(aVar2, caVar, 2, !Util.isNullOrNil(str), charSequence, true, str2);
                                ag agVar = new ag();
                                agVar.context = context;
                                agVar.scene = 65;
                                agVar.query = charSequence;
                                agVar.sessionId = str2;
                                agVar.IEk = true;
                                ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(agVar);
                                break;
                        }
                        AppMethodBeat.o(180028);
                    }
                };
            }
            bd.a(aVar2, br.P(caVar), spannableString, fVar.POU);
            if (br.B(caVar) || br.J(caVar)) {
                fVar.POU.setTag(PKJ, Boolean.FALSE);
                fVar.POU.setOnTouchListener(fVar.PKF);
                fVar.POU.setOnLongClickListener(c(aVar2));
                fVar.POU.setOnClickListener(gUg());
            } else {
                int O = br.O(caVar);
                if (O <= 0 || O >= com.tencent.mm.ui.widget.textview.b.hB(fVar.POU).length()) {
                    O = 0;
                }
                c.View$OnLongClickListenerC2106c c2 = c(aVar2);
                a.f a3 = a(c2);
                if (fVar.PKE != null) {
                    fVar.PKE.destroy();
                }
                int[] iArr = new int[2];
                int i4 = 0;
                if (fVar.POU != null) {
                    fVar.POU.getLocationInWindow(iArr);
                    i4 = iArr[0];
                    if (i4 == 0) {
                        Rect rect = new Rect();
                        fVar.POU.getGlobalVisibleRect(rect);
                        i4 = rect.left;
                    }
                }
                a.C2147a aVar4 = new a.C2147a(fVar.POU, fVar.wnj, a3, gUg(), fVar.PKF);
                aVar4.QPi = R.color.a6q;
                aVar4.QYg = 18;
                aVar4.QPj = R.color.kn;
                if (i4 != 0) {
                    aVar4.QYh = i4 + at.aH(fVar.POU.getContext(), R.dimen.cb);
                }
                fVar.PKE = aVar4.hcW();
                fVar.PKG = new d(fVar.PKE);
                fVar.PKE.QXO = new x() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass5 */

                    @Override // com.tencent.mm.ui.widget.textview.a.d
                    public final void as(CharSequence charSequence) {
                        AppMethodBeat.i(180029);
                        a.this.PkM = charSequence;
                        AppMethodBeat.o(180029);
                    }
                };
                fVar.PGP = new a.f() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass6 */

                    @Override // com.tencent.mm.ui.widget.textview.a.f
                    public final void dismiss() {
                        AppMethodBeat.i(180030);
                        fVar.PKE.hbA();
                        fVar.PKE.QXW = true;
                        fVar.PKE.QXX = true;
                        fVar.PKE.hbz();
                        AppMethodBeat.o(180030);
                    }
                };
                c2.PGP = fVar.PGP;
                fVar.PKE.QXU = O;
                fVar.PKE.QYc = fVar.PKG;
            }
            fVar.POU.setOnDoubleClickListener(this);
            fVar.POU.setTextListener(new MMNeat7extView.a() {
                /* class com.tencent.mm.ui.chatting.viewitems.bd.a.AnonymousClass7 */

                @Override // com.tencent.mm.ui.widget.MMNeat7extView.a
                public final void at(CharSequence charSequence) {
                    AppMethodBeat.i(180031);
                    if (((Boolean) fVar.POU.getTag(a.PKL)).booleanValue()) {
                        com.tencent.mm.ui.chatting.m.a.a.gTK();
                        com.tencent.mm.ui.chatting.m.a.a.gTL().a(charSequence, ((Long) fVar.POU.getTag(a.PKK)).longValue());
                    }
                    AppMethodBeat.o(180031);
                }
            });
            if (!Util.isNullOrNil(str3) || cVar != ChattingItemTranslate.c.NoTransform) {
                if (fVar.PKI == null) {
                    fVar.PKI = (ChattingItemTranslate) fVar.PKH.inflate();
                    fVar.PKI.init();
                }
                fVar.PKI.a(l.a(fVar.POU.getContext(), str3, (int) fVar.POU.getTextSize(), 1, cN, cO(caVar)), cVar);
                ChattingItemTranslate chattingItemTranslate = fVar.PKI;
                if (Util.isNullOrNil(caVar.field_transBrandWording)) {
                    str7 = aVar2.Pwc.getMMResources().getString(R.string.ho8);
                } else {
                    str7 = caVar.field_transBrandWording;
                }
                chattingItemTranslate.setBrandWording(str7);
                if (!Util.isNullOrNil(str3)) {
                    ChattingItemTranslate.a aVar5 = new ChattingItemTranslate.a(caVar, aVar2.gRM(), i2);
                    aVar5.PQG = false;
                    aVar5.qcr = 2;
                    fVar.PKI.setTag(aVar5);
                    fVar.PKI.getContentView().setTag(aVar5);
                    fVar.PKI.setOnClickListener(gUg());
                    fVar.PKI.setOnDoubleClickListener(this);
                    fVar.PKI.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
                    fVar.PKI.setOnLongClickListener(c(aVar2));
                    fVar.PKI.setVisibility(0);
                }
                AppMethodBeat.o(37396);
                return;
            }
            if (fVar.PKI != null) {
                fVar.PKI.setVisibility(8);
            }
            AppMethodBeat.o(37396);
        }

        private String cO(ca caVar) {
            AppMethodBeat.i(37397);
            if (caVar != null) {
                String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                ad.b G = ad.aVe().G(JX, true);
                G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                G.l("preUsername", a(this.PhN, caVar));
                G.l("preChatName", b(this.PhN, caVar));
                AppMethodBeat.o(37397);
                return JX;
            }
            AppMethodBeat.o(37397);
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean gTU() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233923);
            if (caVar.isText() || caVar.gDg()) {
                ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
                int i2 = aVar.position;
                if (aVar.qcr == 1) {
                    if (caVar.isText()) {
                        if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(caVar)) {
                            mVar.a(i2, 151, this.PhN.Pwc.getMMResources().getString(R.string.dw3), R.raw.icons_filled_continued_form);
                        }
                        if (!br.J(caVar)) {
                            mVar.a(i2, 102, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                        }
                    }
                    if (!br.J(caVar)) {
                        mVar.a(i2, 108, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                    }
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                    }
                    if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                        mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                    }
                    if (caVar.isText() && com.tencent.mm.al.g.aZH()) {
                        this.PhN.gRN();
                    }
                    if (!this.PhN.gRN()) {
                        mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                    }
                    if (com.tencent.mm.app.plugin.c.Xn() && (!caVar.gDz() || !caVar.gDI())) {
                        mVar.a(i2, 124, view.getContext().getString(R.string.b0r), R.raw.icons_filled_translate);
                    }
                    if (br.B(caVar) || br.P(caVar) == 4) {
                        mVar.clear();
                        if (!this.PhN.gRN()) {
                            mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                        }
                    }
                } else if (aVar.qcr == 2) {
                    mVar.a(i2, 141, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                    mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_3, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_4, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                    }
                    if (com.tencent.mm.app.plugin.c.Xn()) {
                        if (caVar.gDz() && caVar.gDI()) {
                            mVar.a(i2, 124, view.getContext().getString(R.string.b0p), R.raw.icons_filled_eyes_off);
                        }
                        if (caVar.gDL()) {
                            mVar.a(i2, 125, view.getContext().getString(R.string.b0h), R.raw.icons_filled_refresh);
                        }
                    }
                    AppMethodBeat.o(233923);
                    return false;
                }
                AppMethodBeat.o(233923);
                return true;
            }
            AppMethodBeat.o(233923);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        @Deprecated
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.CharSequence] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x019f  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0238  */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.view.MenuItem r15, final com.tencent.mm.ui.chatting.e.a r16, com.tencent.mm.ui.chatting.viewitems.bq r17) {
            /*
            // Method dump skipped, instructions count: 886
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.bd.a.a(android.view.MenuItem, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ui.chatting.viewitems.bq):boolean");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37400);
            if (view instanceof MMTextView) {
                com.tencent.mm.ui.chatting.m.a.a.gTK();
                com.tencent.mm.ui.chatting.m.a.a.a(((MMTextView) view).getText(), caVar);
            }
            AppMethodBeat.o(37400);
            return true;
        }

        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
        public final boolean gS(View view) {
            String g2;
            AppMethodBeat.i(37401);
            if (v.gQ(view)) {
                Log.i("MicroMsg.ChattingItemTextFrom", "onDoubleTap solitaire fold double click");
                AppMethodBeat.o(37401);
            } else {
                Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
                intent.addFlags(67108864);
                if (view.getTag() instanceof ChattingItemTranslate.a) {
                    ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
                    intent.putExtra("Chat_Msg_Id", aVar.dTX.field_msgId);
                    if (((com.tencent.mm.ui.chatting.d.b.x) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.x.class)).cd(aVar.dTX)) {
                        g2 = ((MMNeat7extView) view).hiT().toString();
                    } else {
                        g2 = ((au) this.PhN.bh(au.class)).g(aVar.dTX, aVar.qcr == 2);
                    }
                    intent.putExtra("key_chat_text", g2);
                    intent.putExtra("is_group_chat", this.PhN.gRM());
                    Context context = view.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.ui.base.b.kc(view.getContext());
                    ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(aVar.dTX.field_talker);
                }
                AppMethodBeat.o(37401);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f extends c.a {
        a.f PGP;
        LinearLayout PIY;
        TextView PIZ;
        ImageView PIn;
        com.tencent.mm.ui.widget.textview.a PKE;
        com.tencent.mm.pluginsdk.ui.span.h PKF;
        a.e PKG;
        ViewStub PKH;
        ChattingItemTranslate PKI;
        MMNeat7extView POU;
        View jxm;
        protected TextView tln;
        com.tencent.mm.ui.widget.b.a wnj;

        f() {
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(37420);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.POU = (MMNeat7extView) view.findViewById(R.id.auk);
            this.POU.setMaxWidth((int) (((float) com.tencent.mm.cb.a.aH(this.POU.getContext(), R.dimen.xb)) / com.tencent.mm.cc.a.gvi()));
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.jxm = view.findViewById(R.id.aui);
            this.PKH = (ViewStub) view.findViewById(R.id.iva);
            if (!z) {
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
                this.stateIV = (ImageView) view.findViewById(R.id.ayb);
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            }
            this.PKF = new com.tencent.mm.pluginsdk.ui.span.h(this.POU, new com.tencent.mm.pluginsdk.ui.span.o(this.POU.getContext()));
            this.POU.setIsOpen(gUh());
            this.POU.setTextCrashListener(new c((byte) 0));
            this.tln = (TextView) view.findViewById(R.id.atq);
            this.PIY = (LinearLayout) view.findViewById(R.id.atw);
            this.PIZ = (TextView) view.findViewById(R.id.atx);
            AppMethodBeat.o(37420);
            return this;
        }

        private static boolean gUh() {
            AppMethodBeat.i(37421);
            try {
                String value = com.tencent.mm.n.h.aqJ().getValue("CellTextViewEnable");
                int i2 = Util.getInt(value, 1);
                boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, true);
                Log.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", value, Integer.valueOf(i2), Boolean.valueOf(z));
                if (1 != i2 || !z) {
                    AppMethodBeat.o(37421);
                    return false;
                }
                AppMethodBeat.o(37421);
                return true;
            } catch (Exception e2) {
                AppMethodBeat.o(37421);
                return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.POU;
        }
    }

    public static void a(Context context, com.tencent.mm.ui.chatting.e.a aVar, String str, CharSequence charSequence, MMNeat7extView mMNeat7extView, ca caVar, int i2) {
        AppMethodBeat.i(233927);
        v.a(context, aVar, str, charSequence, mMNeat7extView, caVar, i2);
        AppMethodBeat.o(233927);
    }

    /* access modifiers changed from: package-private */
    public static class e extends t.e {
        public e(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37419);
            bq bqVar = (bq) view.getTag();
            if (caVar.gDg()) {
                if (this.PhN != null) {
                    h.INSTANCE.kvStat(10221, "1");
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "shake", ".ui.ShakeReportUI", intent);
                }
                AppMethodBeat.o(37419);
                return;
            }
            if (caVar.isText() && (view instanceof MMTextView)) {
                com.tencent.mm.ui.chatting.m.a.a.gTK();
                com.tencent.mm.ui.chatting.m.a.a.a(((MMTextView) view).getText(), bqVar.dTX);
            }
            AppMethodBeat.o(37419);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c implements MMNeat7extView.b {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.widget.MMNeat7extView.b
        public final void a(Exception exc, String str, String str2) {
            AppMethodBeat.i(37417);
            if (!com.tencent.mm.protocal.d.KyP) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("Content", str);
                hashMap.put("Exception", exc.toString());
                hashMap.put("Stack", exc.getStackTrace());
                h.INSTANCE.e("NeatTextView", str2, hashMap);
            }
            AppMethodBeat.o(37417);
        }
    }

    static class d implements a.e {
        private com.tencent.mm.ui.widget.textview.a PkL;

        d(com.tencent.mm.ui.widget.textview.a aVar) {
            this.PkL = aVar;
        }

        @Override // com.tencent.mm.ui.widget.textview.a.e
        public final void gUe() {
            AppMethodBeat.i(37418);
            Log.d("OnTouchOutside", "touchOutside");
            this.PkL.hbA();
            this.PkL.QXX = true;
            this.PkL.hcR();
            this.PkL.QXW = true;
            this.PkL.hcS();
            this.PkL.hcU();
            AppMethodBeat.o(37418);
        }
    }

    public static void a(boolean z, f fVar, com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(180039);
        if (fVar == null) {
            AppMethodBeat.o(180039);
        } else if (z) {
            fVar.PIY.setBackgroundResource(R.drawable.n9);
            fVar.PIZ.setTextColor(aVar.Pwc.getContext().getResources().getColor(R.color.BW_100_Alpha_0_8));
            fVar.PIZ.setText(R.string.dwl);
            AppMethodBeat.o(180039);
        } else {
            fVar.PIY.setBackgroundResource(R.drawable.n_);
            fVar.PIZ.setTextColor(aVar.Pwc.getContext().getResources().getColor(R.color.Brand));
            fVar.PIZ.setText(R.string.dwn);
            AppMethodBeat.o(180039);
        }
    }

    public static Bundle cN(ca caVar) {
        AppMethodBeat.i(233928);
        Bundle bundle = new Bundle();
        bundle.putLong("msgSvrId", caVar.field_msgSvrId);
        AppMethodBeat.o(233928);
        return bundle;
    }

    static /* synthetic */ void a(ca caVar, final f fVar, final com.tencent.mm.ui.chatting.e.a aVar) {
        boolean z;
        AppMethodBeat.i(180040);
        if (caVar.gDV()) {
            g.aAi();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(caVar.field_talker).fve == caVar.field_msgId) {
                if (!y.ama() || caVar == null || cl.aWz() - caVar.field_createTime >= com.tencent.mm.chatroom.storage.d.gtt.longValue() || !ab.IE(aVar.getTalkerUserName())) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    fVar.PIY.setVisibility(0);
                    boolean isNullOrNil = Util.isNullOrNil(caVar.fRe);
                    fVar.PIY.setTag(caVar);
                    fVar.PIY.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.bd.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(180023);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            e.a((ca) view.getTag(), fVar, aVar, 1);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(180023);
                        }
                    });
                    a(isNullOrNil, fVar, aVar);
                    AppMethodBeat.o(180040);
                    return;
                }
            }
        }
        fVar.PIY.setVisibility(8);
        AppMethodBeat.o(180040);
    }

    static /* synthetic */ void c(ca caVar, int i2, int i3) {
        int P;
        int i4;
        int i5 = 1;
        AppMethodBeat.i(233929);
        if (caVar != null && (P = br.P(caVar)) > 0) {
            ga gaVar = new ga();
            if (ab.Eq(caVar.field_talker) || ab.Iy(caVar.field_talker)) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            if (caVar.field_isSend != 1) {
                i5 = 0;
            }
            gaVar.eHz = caVar.field_msgSvrId;
            gaVar.erW = (long) i4;
            gaVar.eIq = (long) i5;
            gaVar.erY = (long) P;
            gaVar.ejA = (long) i2;
            gaVar.eIr = (long) i3;
            gaVar.bfK();
        }
        AppMethodBeat.o(233929);
    }

    static /* synthetic */ void a(final com.tencent.mm.ui.chatting.e.a aVar, int i2, CharSequence charSequence, MMNeat7extView mMNeat7extView) {
        com.tencent.neattextview.textview.layout.a mq;
        int hiG;
        int offsetForHorizontal;
        AppMethodBeat.i(233930);
        if (i2 == 0 || charSequence == null) {
            AppMethodBeat.o(233930);
            return;
        }
        if (charSequence.length() == mMNeat7extView.hiT().length() && (mq = mMNeat7extView.mq((int) (((((float) com.tencent.mm.cb.a.aH(mMNeat7extView.getContext(), R.dimen.xb)) / com.tencent.mm.cc.a.gvi()) - ((float) mMNeat7extView.getPaddingLeft())) - ((float) mMNeat7extView.getPaddingRight())), Integer.MAX_VALUE)) != null && (hiG = mq.hiG()) > 0) {
            if (hiG <= 2) {
                offsetForHorizontal = mq.getOffsetForHorizontal(0, (float) ((int) (((float) (com.tencent.mm.cb.a.aH(mMNeat7extView.getContext(), R.dimen.xb) / 2)) * com.tencent.mm.cc.a.gvi())));
            } else {
                offsetForHorizontal = mq.getOffsetForHorizontal(2, 0.0f);
            }
            if (offsetForHorizontal >= 0 && offsetForHorizontal < charSequence.length()) {
                String str = ((Object) charSequence.subSequence(0, offsetForHorizontal - 1)) + "..." + mMNeat7extView.getContext().getString(R.string.wp);
                SpannableString a2 = l.a(mMNeat7extView.getContext(), str, (int) mMNeat7extView.getTextSize(), 1, (Object) null, (String) null);
                AnonymousClass1 r3 = new com.tencent.mm.plugin.messenger.a.a() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bd.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.messenger.a.a
                    public final void onClickImp(View view) {
                        AppMethodBeat.i(37382);
                        Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
                        intent.addFlags(67108864);
                        ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
                        if (aVar != null) {
                            intent.putExtra("Chat_Msg_Id", aVar.dTX.field_msgId);
                            intent.putExtra("key_chat_text", ((au) aVar.bh(au.class)).g(aVar.dTX, false));
                            bd.c(aVar.dTX, 1, 0);
                        }
                        intent.putExtra("is_group_chat", aVar.gRM());
                        Context context = view.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$1", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$1", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.ui.base.b.kc(view.getContext());
                        AppMethodBeat.o(37382);
                    }
                };
                a2.setSpan(r3, offsetForHorizontal + 2, str.length(), 17);
                mMNeat7extView.a(a2, TextView.BufferType.SPANNABLE);
                ChattingItemTranslate.a aVar2 = (ChattingItemTranslate.a) mMNeat7extView.getTag();
                if (aVar2 != null) {
                    a2.removeSpan(r3);
                    aVar2.PPi = a2;
                    switch (i2) {
                        case 1:
                            AppMethodBeat.o(233930);
                            return;
                        case 2:
                            if (br.O(aVar2.dTX) == 0) {
                                br.a(aVar2.dTX, offsetForHorizontal + 2);
                                break;
                            }
                            break;
                    }
                }
            }
        }
        AppMethodBeat.o(233930);
    }
}
