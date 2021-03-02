package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import java.util.List;

public final class q extends com.tencent.mm.plugin.fts.a.d.a.a {
    public as contact;
    public m lqW;
    public CharSequence pqC;
    public String username;
    public CharSequence xdI;
    public CharSequence xdJ;
    private b xdK = new b();
    a xdL = new a();

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112113);
            View inflate = LayoutInflater.from(context).inflate(R.layout.an2, viewGroup, false);
            a aVar = q.this.xdL;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.lrc = inflate.findViewById(R.id.brt);
            inflate.setTag(aVar);
            AppMethodBeat.o(112113);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112114);
            a aVar3 = (a) aVar;
            q qVar = (q) aVar2;
            n.q(aVar3.lrc, q.this.wXK);
            if (qVar.username == null || qVar.username.length() <= 0) {
                aVar3.gvv.setImageResource(R.drawable.bca);
            } else {
                a.b.c(aVar3.gvv, qVar.username);
            }
            if (ab.Iz(qVar.username)) {
                n.a(((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(context, qVar.xdI), aVar3.jVO);
            } else {
                n.a(qVar.xdI, aVar3.jVO);
            }
            aVar3.jVO.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(context, 200));
            n.a(qVar.pqC, aVar3.jBR);
            AppMethodBeat.o(112114);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235405);
            q qVar = (q) aVar;
            a(q.this.wWd.wWB, qVar.lqW);
            Intent putExtra = new Intent().putExtra("Chat_User", qVar.username).putExtra("finish_direct", true);
            putExtra.putExtra("chat_from_scene", 5);
            if ((as.bjp(qVar.username) || as.bjq(qVar.username)) && !WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(view.getContext())) {
                AppMethodBeat.o(235405);
            } else {
                if (ab.Iy(qVar.username)) {
                    gq gqVar = new gq();
                    gqVar.us(qVar.username);
                    gqVar.erw = 3;
                    gqVar.bfK();
                }
                c.f(context, ".ui.chatting.ChattingUI", putExtra);
                ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).cV(qVar.username, 2);
                AppMethodBeat.o(235405);
            }
            return true;
        }
    }

    public class a extends a.AbstractC1374a {
        public ImageView gvv;
        public TextView jBR;
        public TextView jVO;
        public View lrc;

        public a() {
            super();
        }
    }

    public q(int i2) {
        super(2, i2);
        AppMethodBeat.i(112116);
        AppMethodBeat.o(112116);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0198  */
    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.plugin.fts.a.d.a.a.AbstractC1374a r12, java.lang.Object... r13) {
        /*
        // Method dump skipped, instructions count: 456
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.a.q.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xdK;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int bCS() {
        return this.lqW.wXn;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int dOK() {
        List<com.tencent.mm.plugin.fts.a.a.g> list;
        AppMethodBeat.i(112118);
        if (this.lqW.wVW != 38 || (list = this.lqW.wXl) == null || list.size() <= 0) {
            int dOK = super.dOK();
            AppMethodBeat.o(112118);
            return dOK;
        }
        int i2 = list.get(0).wVW;
        AppMethodBeat.o(112118);
        return i2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final boolean dOL() {
        return this.lqW.wXo;
    }
}
