package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J>\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", ch.COL_USERNAME, "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class by extends ax implements m {
    private static final String TAG = TAG;
    public static final a tvZ = new a((byte) 0);
    private i callback;
    private d rr;
    private final boolean tvX;
    private final boolean tvY;
    private final String username;

    private by(String str) {
        int i2 = 1;
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(242485);
        this.username = str;
        this.tvX = true;
        this.tvY = false;
        d.a aVar = new d.a();
        aVar.sG(getType());
        aon aon = new aon();
        aon.finderUsername = this.username;
        am amVar = am.tuw;
        aon.LAI = am.cXY();
        if (this.tvY) {
            i2 = 3;
        } else if (!this.tvX) {
            i2 = 2;
        }
        aon.dYx = i2;
        aVar.c(aon);
        aoo aoo = new aoo();
        aoo.setBaseResponse(new BaseResponse());
        aVar.d(aoo);
        aVar.MB("/cgi-bin/micromsg-bin/finderapplyoriginal");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(TAG, "NetSceneFinderOriginal init " + this.tvX);
        AppMethodBeat.o(242485);
    }

    public /* synthetic */ by(String str, byte b2) {
        this(str);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242486);
        AppMethodBeat.o(242486);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3785;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242483);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242483);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        FinderContact finderContact;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4 = null;
        AppMethodBeat.i(242484);
        Log.i(TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
                AppMethodBeat.o(242484);
                throw tVar;
            }
            aoo aoo = (aoo) aYK;
            if (!this.tvY && (finderContact = aoo.LAJ) != null && Util.isEqual(finderContact.username, z.aUg())) {
                e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC, Integer.valueOf(finderContact.originalFlag));
                e aAh2 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC, Integer.valueOf(finderContact.originalEntranceFlag));
                if (finderContact.originalInfo != null) {
                    e aAh3 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh3, "MMKernel.storage()");
                    ao azQ = aAh3.azQ();
                    ar.a aVar = ar.a.USERINFO_MY_FINDER_ORIGINAL_REPOST_COUNT_INT_SYNC;
                    bac bac = finderContact.originalInfo;
                    azQ.set(aVar, bac != null ? Integer.valueOf(bac.LJQ) : null);
                    e aAh4 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh4, "MMKernel.storage()");
                    ao azQ2 = aAh4.azQ();
                    ar.a aVar2 = ar.a.USERINFO_MY_FINDER_ORIGINAL_APPLY_COUNT_INT_SYNC;
                    bac bac2 = finderContact.originalInfo;
                    if (bac2 != null) {
                        num = Integer.valueOf(bac2.LJR);
                    } else {
                        num = null;
                    }
                    azQ2.set(aVar2, num);
                    e aAh5 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh5, "MMKernel.storage()");
                    ao azQ3 = aAh5.azQ();
                    ar.a aVar3 = ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_INT_SYNC;
                    bac bac3 = finderContact.originalInfo;
                    if (bac3 != null) {
                        num2 = Integer.valueOf(bac3.LJS);
                    } else {
                        num2 = null;
                    }
                    azQ3.set(aVar3, num2);
                    e aAh6 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh6, "MMKernel.storage()");
                    ao azQ4 = aAh6.azQ();
                    ar.a aVar4 = ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_YEAR_FLAG_INT_SYNC;
                    bac bac4 = finderContact.originalInfo;
                    if (bac4 != null) {
                        num3 = Integer.valueOf(bac4.LJT);
                    } else {
                        num3 = null;
                    }
                    azQ4.set(aVar4, num3);
                    e aAh7 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh7, "MMKernel.storage()");
                    ao azQ5 = aAh7.azQ();
                    ar.a aVar5 = ar.a.USERINFO_MY_FINDER_ORIGINAL_NEED_CHECK_FLAG_INT_SYNC;
                    bac bac5 = finderContact.originalInfo;
                    if (bac5 != null) {
                        num4 = Integer.valueOf(bac5.LJU);
                    }
                    azQ5.set(aVar5, num4);
                }
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242484);
    }
}
