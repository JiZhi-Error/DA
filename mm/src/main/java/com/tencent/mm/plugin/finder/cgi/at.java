package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+BM\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\n\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\b\u0010 \u001a\u00020!H\u0016J>\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "realPoiInfo", "showAtWxProfile", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;IILcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class at extends ax implements m {
    private static final String TAG = TAG;
    public static final a tuM = new a((byte) 0);
    private i callback;
    public d rr;
    private final JSONObject ttQ = new JSONObject();
    private final JSONObject tuL = new JSONObject();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165204);
        AppMethodBeat.o(165204);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return b.Enable;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final JSONObject cXV() {
        return this.tuL;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final JSONObject cXW() {
        return this.ttQ;
    }

    public at(String str, String str2, String str3, app app, int i2, int i3, app app2, boolean z) {
        p.h(app, IssueStorage.COLUMN_EXT_INFO);
        p.h(app2, "realPoiInfo");
        AppMethodBeat.i(242344);
        d.a aVar = new d.a();
        aVar.sG(getType());
        aqe aqe = new aqe();
        aqe.nickname = Util.nullAsNil(str);
        aqe.signature = str2;
        aqe.iAR = str3;
        aqe.LCi = app;
        aqe.LCk = i2;
        aqe.LCj = i3;
        am amVar = am.tuw;
        aqe.uli = am.cXY();
        aqe.LCl = app2;
        aqe.LCm = z ? 1 : 2;
        aVar.c(aqe);
        aVar.d(new aqf());
        aVar.MB("/cgi-bin/micromsg-bin/findercreateuser");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        this.tuL.put("nickname", str);
        this.tuL.put("signature", aqe.LCm);
        Log.i(TAG, "NetSceneCreateFinderUser init ");
        AppMethodBeat.o(242344);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3922;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165200);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165200);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        FinderContact cYe;
        AppMethodBeat.i(242343);
        Log.i(TAG, "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0 && (cYe = cYe()) != null) {
            c.a aVar = c.tsp;
            c.a.a(cYe);
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, cYe.username);
            e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, cYe.nickname);
            e aAh3 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, cYe.headUrl);
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242343);
    }

    public final FinderContact cYe() {
        AppMethodBeat.i(165202);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
            AppMethodBeat.o(165202);
            throw tVar;
        }
        FinderContact finderContact = ((aqf) aYK).contact;
        AppMethodBeat.o(165202);
        return finderContact;
    }
}
