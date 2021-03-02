package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.fga;
import com.tencent.mm.protocal.protobuf.fgb;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnterPersonalMsg;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderEnterPersonalMsgResponse;", "my_account_type", "", "to_username", "", "session_id", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getTo_username", "()Ljava/lang/String;", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class cy extends c<fgb> {
    public static final a UHF = new a((byte) 0);
    private final String pPz;

    static {
        AppMethodBeat.i(260172);
        AppMethodBeat.o(260172);
    }

    private cy(int i2, String str, String str2) {
        p.h(str, "to_username");
        p.h(str2, "session_id");
        AppMethodBeat.i(260171);
        this.pPz = str;
        fga fga = new fga();
        am amVar = am.tuw;
        fga.LBM = am.a((bbn) null);
        fga.Viz = i2;
        fga.pPz = this.pPz;
        fga.session_id = str2;
        d.a aVar = new d.a();
        aVar.c(fga);
        fgb fgb = new fgb();
        fgb.setBaseResponse(new BaseResponse());
        aVar.d(fgb);
        aVar.MB("/cgi-bin/micromsg-bin/finderenterpersonalmsg");
        aVar.sG(6464);
        c(aVar.aXF());
        Log.i("Cgi.FinderEnterPersonalMsg", "CgiFinderEnterPersonalMsg init my_account_type=" + i2 + " to_username=" + this.pPz + " session_id=" + str2);
        AppMethodBeat.o(260171);
    }

    public /* synthetic */ cy(int i2, String str, String str2, byte b2) {
        this(i2, str, str2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, fgb fgb, q qVar) {
        FinderContact finderContact;
        String str2;
        AppMethodBeat.i(260170);
        fgb fgb2 = fgb;
        p.h(fgb2, "resp");
        super.a(i2, i3, str, fgb2, qVar);
        Log.i("Cgi.FinderEnterPersonalMsg", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " resp=" + fgb2 + " refresh_interval=" + fgb2.pQM);
        if (i2 == 0 && i3 == 0) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_ENTER_PERSONAL_MSG_REFRESH_INTERVAL_INT_SYNC, Integer.valueOf(fgb2.pQM));
            fhj fhj = fgb2.ViA;
            if (!(fhj == null || (finderContact = fhj.contact) == null)) {
                String str3 = finderContact.username;
                String str4 = str3 == null || str3.length() == 0 ? this.pPz : finderContact.username;
                c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str4);
                if (asG == null) {
                    p.g(finderContact, LocaleUtil.ITALIAN);
                    asG = b.a(finderContact, null);
                }
                asG.field_nickname = finderContact.nickname;
                fhj fhj2 = fgb2.ViA;
                if (fhj2 != null) {
                    str2 = fhj2.Vjx;
                } else {
                    str2 = null;
                }
                asG.field_liveAlias = str2;
                fhj fhj3 = fgb2.ViA;
                asG.field_rewardTotalAmountInWecoin = fhj3 != null ? fhj3.LDU : 0;
                asG.field_personalMsgUpdateTime = cl.aWA();
                Log.i("Cgi.FinderEnterPersonalMsg", "[onCgiBack] nickname=" + finderContact.nickname + " username=" + str4 + " liveAlias=" + asG.field_liveAlias + " rewardTotalAmountInWecoin=" + asG.field_rewardTotalAmountInWecoin);
                c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                c.a.d(asG);
                AppMethodBeat.o(260170);
                return;
            }
        }
        AppMethodBeat.o(260170);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnterPersonalMsg$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
