package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.b;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.List;

public final class r extends b {
    private a xdN = new a();

    public class a extends b.AbstractC1382b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235406);
            r rVar = (r) aVar;
            if (ab.Jx(rVar.username) && !WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(view.getContext())) {
                AppMethodBeat.o(235406);
            } else if ((as.bjp(rVar.username) || ab.Iy(rVar.username)) && !WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(view.getContext())) {
                AppMethodBeat.o(235406);
            } else {
                a(r.this.wWd.wWB, rVar.lqW);
                Intent putExtra = new Intent().putExtra("Chat_User", rVar.username).putExtra("finish_direct", true);
                putExtra.putExtra("chat_from_scene", 5);
                c.f(context, ".ui.chatting.ChattingUI", putExtra);
                ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).cV(rVar.username, 2);
                AppMethodBeat.o(235406);
            }
            return true;
        }
    }

    public r(int i2) {
        super(i2);
        AppMethodBeat.i(112120);
        AppMethodBeat.o(112120);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        boolean z;
        boolean z2;
        boolean z3;
        String substring;
        String str;
        AppMethodBeat.i(112121);
        super.a(context, aVar, objArr);
        this.username = this.lqW.wVX;
        this.contact = ((l) g.af(l.class)).aSN().Kn(this.username);
        String str2 = null;
        String str3 = null;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        String arL = d.arL(this.username);
        switch (this.lqW.wVW) {
            case 1:
                z = false;
                z2 = false;
                z4 = true;
                z6 = z;
                z5 = z2;
                z3 = false;
                break;
            case 2:
                z = false;
                z2 = true;
                z4 = true;
                z6 = z;
                z5 = z2;
                z3 = false;
                break;
            case 3:
                z = true;
                z2 = true;
                z4 = true;
                z6 = z;
                z5 = z2;
                z3 = false;
                break;
            case 4:
                z3 = true;
                str3 = this.contact.fuR;
                str2 = context.getString(R.string.gfz);
                break;
            case 5:
                z3 = true;
                str3 = this.contact.field_nickname;
                str2 = context.getString(R.string.gg4);
                break;
            case 6:
                z5 = true;
                z3 = true;
                str3 = this.contact.field_nickname;
                str2 = context.getString(R.string.gg4);
                break;
            case 7:
                z6 = true;
                z5 = true;
                z3 = true;
                str3 = this.contact.field_nickname;
                str2 = context.getString(R.string.gg4);
                break;
            case 11:
                List<String> aym = ((n) g.ah(n.class)).getFTSMainDB().aym(this.contact.field_contactLabelIds);
                StringBuffer stringBuffer = new StringBuffer();
                String[] strArr = this.wWd.wWD;
                for (String str4 : strArr) {
                    for (String str5 : aym) {
                        if (d.ayq(str5).contains(str4)) {
                            stringBuffer.append(str5);
                            stringBuffer.append(",");
                        }
                    }
                }
                stringBuffer.trimToSize();
                if (stringBuffer.length() == 0) {
                    substring = "";
                } else {
                    substring = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
                z3 = true;
                str3 = substring;
                str2 = context.getString(R.string.gg8);
                break;
            case 15:
                String ajx = this.contact.ajx();
                if (Util.isNullOrNil(ajx)) {
                    ajx = this.contact.field_username;
                }
                z3 = true;
                str3 = ajx;
                str2 = context.getString(R.string.gg9);
                break;
            case 16:
                String str6 = this.lqW.content;
                if (!Util.isNullOrNil(str6)) {
                    String[] split = str6.split(RecoveryFileLog.SPLITTER);
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            str = split[i2];
                            if (!str.startsWith(this.wWd.wWB)) {
                                i2++;
                            }
                        }
                    }
                }
                str = str6;
                z3 = true;
                str3 = str;
                str2 = context.getString(R.string.gg3);
                break;
            case 17:
                z3 = true;
                str3 = this.lqW.content;
                str2 = context.getString(R.string.gfy);
                break;
            case 18:
                z3 = true;
                str3 = this.lqW.content;
                str2 = context.getString(R.string.gg5);
                break;
            case 51:
                Pair<String, String> Y = Y(this.contact);
                if (Y != null) {
                    z3 = true;
                    str3 = (String) Y.second;
                    str2 = ((String) Y.first) + "：";
                    break;
                } else {
                    z3 = true;
                    str3 = "";
                    str2 = "";
                    break;
                }
            default:
                z3 = false;
                break;
        }
        if (z4) {
            this.pqB = com.tencent.mm.pluginsdk.ui.span.l.d(context, arL, (float) com.tencent.mm.cb.a.aG(context, R.dimen.is));
            this.pqB = f.a(e.a(this.pqB, this.wWd, z5, z6, (float) b.a.wZP, b.c.wZW)).wWu;
        } else {
            this.pqB = com.tencent.mm.pluginsdk.ui.span.l.d(context, arL, (float) com.tencent.mm.cb.a.aG(context, R.dimen.is));
        }
        if (z3) {
            this.pqC = com.tencent.mm.pluginsdk.ui.span.l.d(context, str3, (float) com.tencent.mm.cb.a.aG(context, R.dimen.is));
            this.pqC = f.a(e.a(this.pqC, this.wWd, z5, z6, (float) b.a.wZP, b.c.wZY)).wWu;
            this.pqC = TextUtils.concat(str2, this.pqC);
        }
        if (as.bjp(this.contact.field_username)) {
            this.xcu = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(this.contact.field_openImAppid, this.contact.field_descWordingId);
            AppMethodBeat.o(112121);
            return;
        }
        this.xcu = "";
        AppMethodBeat.o(112121);
    }

    private Pair<String, String> Y(as asVar) {
        AppMethodBeat.i(112122);
        com.tencent.mm.openim.a.b bVar = new com.tencent.mm.openim.a.b();
        bVar.Sa(asVar.fvb);
        for (int i2 = 0; i2 < bVar.jGV.size(); i2++) {
            b.a aVar = bVar.jGV.get(i2);
            for (b.C0498b bVar2 : aVar.jGW) {
                String Sb = bVar2.Sb(asVar.field_openImAppid);
                if (!Util.isNullOrNil(Sb)) {
                    for (String str : this.wWd.wWD) {
                        if (Sb.contains(str)) {
                            Pair<String, String> pair = new Pair<>(aVar.title, Sb);
                            AppMethodBeat.o(112122);
                            return pair;
                        }
                    }
                    continue;
                }
            }
        }
        AppMethodBeat.o(112122);
        return null;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xdN;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final String bCR() {
        AppMethodBeat.i(112123);
        if (this.contact == null || !as.bjp(this.contact.field_username)) {
            AppMethodBeat.o(112123);
            return "";
        }
        String str = "openim:" + this.contact.field_openImAppid;
        AppMethodBeat.o(112123);
        return str;
    }
}
