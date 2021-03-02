package com.tencent.mm.plugin.finder.megavideo.loader;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ct;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011J\u001e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u001aJ*\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020\u001aR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "context", "Landroid/content/Context;", "hasMore", "", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "maxBulletTime", "", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setMegaVideoFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "minBulletTime", "checkLoadMore", "", "time", "onAttach", "feed", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestEnter", "requestLoadMore", "BulletLoadListener", "Companion", "plugin-finder_release"})
public final class a implements i {
    public static final b uLm = new b((byte) 0);
    public Context context;
    private boolean hasMore;
    private boolean isLoading;
    com.tencent.mm.bw.b lastBuffer;
    public bm uJO;
    public AbstractC1219a uLj;
    private long uLk;
    long uLl;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "", "onBulletIncrease", "", "increaseList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.megavideo.loader.a$a  reason: collision with other inner class name */
    public interface AbstractC1219a {
        void eh(List<? extends cni> list);
    }

    static {
        AppMethodBeat.i(248432);
        AppMethodBeat.o(248432);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(248431);
        p.h(qVar, "scene");
        if (qVar instanceof ct) {
            if (i2 == 0 && i3 == 0) {
                long j2 = ((ct) qVar).twG;
                bm bmVar = this.uJO;
                if (bmVar == null) {
                    p.btv("megaVideoFeed");
                }
                if (j2 != bmVar.lT()) {
                    AppMethodBeat.o(248431);
                    return;
                } else if (this.uLk == ((ct) qVar).cZp() && this.uLl == ((ct) qVar).cZq()) {
                    StringBuilder sb = new StringBuilder("onSceneEnd: hasMore = false, id=");
                    bm bmVar2 = this.uJO;
                    if (bmVar2 == null) {
                        p.btv("megaVideoFeed");
                    }
                    Log.i("Finder.MegaVideoBulletLoader", sb.append(bmVar2.lT()).append(", pullType=").append(((ct) qVar).pullType).append(',').append(" minBulletTime = ").append(this.uLk).append(", maxBulletTime = ").append(this.uLl).toString());
                    this.hasMore = false;
                    AppMethodBeat.o(248431);
                    return;
                } else {
                    this.uLk = ((ct) qVar).cZp();
                    this.uLl = ((ct) qVar).cZq();
                    this.lastBuffer = ((ct) qVar).cYz();
                    List<cni> cZo = ((ct) qVar).cZo();
                    if (!cZo.isEmpty()) {
                        StringBuilder append = new StringBuilder("onSceneEnd: size = ").append(cZo.size()).append(", id=");
                        bm bmVar3 = this.uJO;
                        if (bmVar3 == null) {
                            p.btv("megaVideoFeed");
                        }
                        Log.i("Finder.MegaVideoBulletLoader", append.append(bmVar3.lT()).append(", pullType=").append(((ct) qVar).pullType).append(',').append(" minBulletTime = ").append(this.uLk).append(", maxBulletTime = ").append(this.uLl).toString());
                        AbstractC1219a aVar = this.uLj;
                        if (aVar != null) {
                            aVar.eh(cZo);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    this.hasMore = z;
                }
            } else {
                Log.e("Finder.MegaVideoBulletLoader", "NetSceneMegaVideoGetBullet: errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
            }
        }
        this.isLoading = false;
        AppMethodBeat.o(248431);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ a uLn;
        final /* synthetic */ long uLo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, long j2) {
            super(0);
            this.uLn = aVar;
            this.uLo = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            String str2;
            long j2;
            bbn bbn = null;
            AppMethodBeat.i(248430);
            if (this.uLn.hasMore && !this.uLn.isLoading && this.uLo - this.uLn.uLl > -3000 && this.uLn.uLl > 0) {
                this.uLn.isLoading = true;
                a aVar = this.uLn;
                bm bmVar = aVar.uJO;
                if (bmVar == null) {
                    p.btv("megaVideoFeed");
                }
                long lT = bmVar.lT();
                bm bmVar2 = aVar.uJO;
                if (bmVar2 == null) {
                    p.btv("megaVideoFeed");
                }
                cng cng = bmVar2.tuP;
                if (cng == null || (str = cng.LOd) == null) {
                    str = "";
                }
                long j3 = aVar.uLl;
                com.tencent.mm.bw.b bVar = aVar.lastBuffer;
                Context context = aVar.context;
                if (context != null) {
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                    if (fH != null) {
                        bbn = fH.dIx();
                    }
                    str2 = str;
                    j2 = lT;
                } else {
                    str2 = str;
                    j2 = lT;
                }
                ct ctVar = new ct(j2, str2, j3, bVar, bbn);
                ctVar.pullType = 2;
                g.azz().b(ctVar);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248430);
            return xVar;
        }
    }
}
