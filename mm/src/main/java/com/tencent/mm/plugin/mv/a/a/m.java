package com.tencent.mm.plugin.mv.a.a;

import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b&\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0014J>\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "pageHashCode", "", "(I)V", "callbackNetSceneTimestamp", "", "createNetSceneTimestamp", "dispatchNetSceneTimestamp", "getPageHashCode", "()I", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "cookie", "", "Companion", "plugin-mv_release"})
public abstract class m extends q implements com.tencent.mm.network.m {
    private static final HashMap<Integer, n> UZB = new HashMap<>();
    public static final a UZC = new a((byte) 0);
    public final int NoN;
    private long UZA;
    private long UZy;
    private long UZz;

    public /* synthetic */ m() {
        this(0);
    }

    public m(int i2) {
        this.NoN = i2;
        this.UZy = cl.aWA();
        this.UZz = cl.aWA();
        this.UZA = cl.aWA();
    }

    @Override // com.tencent.mm.ak.q
    public int dispatch(g gVar, s sVar, com.tencent.mm.network.m mVar) {
        this.UZz = cl.aWA();
        return super.dispatch(gVar, sVar, mVar);
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        this.UZA = cl.aWA();
        UZB.put(Integer.valueOf(getType()), new n(getType(), this.UZy, this.UZz, this.UZA));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene$Companion;", "", "()V", "costObjList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneCostObj;", "Lkotlin/collections/HashMap;", "getCostObjList", "()Ljava/util/HashMap;", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
