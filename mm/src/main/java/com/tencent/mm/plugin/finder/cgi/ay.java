package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J>\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ay extends ax implements m {
    private static final String TAG = TAG;
    private static final int tuU = 1;
    private static final int tuV = 2;
    public static final a tuW = new a((byte) 0);
    private i callback;
    private final String dMW;
    private final int opType;
    private d rr;
    private final int scene;
    public aul ttq;

    public ay(String str, int i2, int i3) {
        AppMethodBeat.i(242362);
        this.dMW = str;
        this.opType = i2;
        this.scene = i3;
        d.a aVar = new d.a();
        aVar.sG(getType());
        apv apv = new apv();
        String str2 = this.dMW;
        apv.dMW = str2 == null ? "" : str2;
        apv.LBE = this.opType;
        am amVar = am.tuw;
        apv.LAI = am.cXY();
        aov aov = apv.LAI;
        if (aov != null) {
            aov.scene = this.scene;
        }
        aVar.c(apv);
        apw apw = new apw();
        apw.setBaseResponse(new BaseResponse());
        aVar.d(apw);
        aVar.MB("/cgi-bin/micromsg-bin/findercontacttagoption");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(TAG, "NetSceneFinderContactTag init " + this.dMW + " opType " + this.opType + " scene " + this.scene + ' ');
        AppMethodBeat.o(242362);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242363);
        AppMethodBeat.o(242363);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3638;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242360);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242360);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242361);
        Log.i(TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.dMW);
            if (this.opType == tuU) {
                Kn.arj();
            } else {
                Kn.ark();
            }
            com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
            bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN();
            p.g(Kn, "contact");
            aSN.c(Kn.getUsername(), Kn);
            d.a aVar = com.tencent.mm.plugin.finder.storage.data.d.vFS;
            d.a.dyw().onAlive();
            d.a aVar2 = com.tencent.mm.plugin.finder.storage.data.d.vFS;
            d.a.dyw();
            com.tencent.mm.plugin.finder.storage.data.d.dyu();
        } else if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            u.makeText(MMApplicationContext.getContext(), "is debug info findercontacttagoption: " + i3 + ' ' + i4, 1).show();
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242361);
    }
}
