package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a implements c {
    public as contact;
    public String iconUrl;
    public m lqW;
    public CharSequence pqB;
    public CharSequence pqC;
    private b pqD = new b();
    C0869a pqE = new C0869a();
    public String username;

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(5818);
            View inflate = LayoutInflater.from(context).inflate(R.layout.amz, viewGroup, false);
            C0869a aVar = a.this.pqE;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.lrc = inflate.findViewById(R.id.brt);
            aVar.hex = (WeImageView) inflate.findViewById(R.id.dtx);
            inflate.setTag(aVar);
            AppMethodBeat.o(5818);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            boolean z = true;
            AppMethodBeat.i(5819);
            a aVar3 = (a) aVar2;
            C0869a aVar4 = (C0869a) aVar;
            n.q(aVar4.lrc, a.this.wXK);
            n.a(context, aVar4.gvv, aVar3.iconUrl, null, R.drawable.bar, true);
            if (ab.Iz(aVar3.username)) {
                n.a(((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(context, aVar3.pqB), aVar4.jVO);
            } else {
                n.a(aVar3.pqB, aVar4.jVO);
            }
            n.a(aVar3.pqC, aVar4.jBR);
            if (aVar3.contact.gBN()) {
                aVar4.hex.setImageDrawable(ar.m(context, R.raw.icons_filled_star_identify, com.tencent.mm.cb.a.n(context, R.color.a3b)));
                aVar4.hex.setVisibility(0);
                AppMethodBeat.o(5819);
                return;
            }
            if ((aVar3.contact.field_verifyFlag & 16) <= 0) {
                z = false;
            }
            if (z) {
                aVar4.hex.setImageDrawable(ar.m(context, R.raw.icons_filled_star_identify, com.tencent.mm.cb.a.n(context, R.color.Indigo)));
                aVar4.hex.setVisibility(0);
                AppMethodBeat.o(5819);
                return;
            }
            aVar4.hex.setVisibility(8);
            AppMethodBeat.o(5819);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(194914);
            a aVar2 = (a) aVar;
            if (WeChatBrands.Business.Entries.SessionOa.checkAvailable(view.getContext()) || ab.Iv(String.valueOf(aVar2.username))) {
                a(a.this.wWd.wWB, aVar2.lqW);
                if (com.tencent.mm.al.g.Ng(aVar2.username)) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", aVar2.username);
                    intent.putExtra("enterprise_biz_display_name", aa.getDisplayName(aVar2.username));
                    intent.putExtra("enterprise_from_scene", 3);
                    com.tencent.mm.br.c.f(context, ".ui.conversation.EnterpriseConversationUI", intent);
                } else if (com.tencent.mm.al.g.DQ(aVar2.username)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", aVar2.username);
                    intent2.addFlags(67108864);
                    intent2.putExtra("biz_chat_from_scene", 5);
                    com.tencent.mm.br.c.f(context, ".ui.bizchat.BizChatConversationUI", intent2);
                } else if (com.tencent.mm.al.g.Nh(aVar2.username)) {
                    com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(aVar2.username);
                    String UJ = fJ == null ? null : fJ.UJ();
                    if (UJ == null) {
                        UJ = "";
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("rawUrl", UJ);
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("srcUsername", aVar2.username);
                    intent3.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent3.addFlags(67108864);
                    com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent3);
                } else {
                    Intent intent4 = new Intent();
                    intent4.putExtra("Chat_User", aVar2.username);
                    intent4.putExtra("finish_direct", true);
                    intent4.putExtra("specific_chat_from_scene", 3);
                    intent4.putExtra("preChatTYPE", 9);
                    intent4.putExtra("chat_from_scene", 5);
                    com.tencent.mm.br.c.f(context, ".ui.chatting.ChattingUI", intent4);
                }
                am.aXh(aVar2.username);
                AppMethodBeat.o(194914);
            } else {
                AppMethodBeat.o(194914);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.a.a$a  reason: collision with other inner class name */
    public class C0869a extends a.AbstractC1374a {
        public ImageView gvv;
        public WeImageView hex;
        public TextView jBR;
        public TextView jVO;
        public View lrc;

        public C0869a() {
            super();
        }
    }

    public a(int i2) {
        super(4, i2);
        AppMethodBeat.i(5821);
        AppMethodBeat.o(5821);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.c
    public final String getUserName() {
        return this.username;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x011d A[SYNTHETIC] */
    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, com.tencent.mm.plugin.fts.a.d.a.a.AbstractC1374a r14, java.lang.Object... r15) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.a.a.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.pqD;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int bCS() {
        return this.lqW.wXn;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final String bCR() {
        AppMethodBeat.i(5823);
        if (this.pqB != null) {
            String charSequence = this.pqB.toString();
            AppMethodBeat.o(5823);
            return charSequence;
        }
        AppMethodBeat.o(5823);
        return "";
    }
}
