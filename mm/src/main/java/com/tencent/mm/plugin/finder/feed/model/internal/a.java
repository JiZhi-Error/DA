package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.bo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J2\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007H&J \u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u0019\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u001b\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u001c\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0007H&J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100 H&J*\u0010!\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "onSceneEnd", "plugin-finder_release"})
public abstract class a extends g<bo> implements i {
    private final Map<q, f<bo>> map = new LinkedHashMap();

    public abstract IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar);

    public abstract q genLoadMoreNetScene();

    public abstract q genRefreshNetScene();

    public abstract List<Integer> getCmdIds();

    public IResponse<bo> callInit() {
        return new c();
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
    public void fetchInit(f<bo> fVar) {
        p.h(fVar, "callback");
        IResponse<bo> callInit = callInit();
        callInit.setPullType(1000);
        fVar.onFetchDone(callInit);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
    public void fetchRefresh(f<bo> fVar) {
        p.h(fVar, "callback");
        fetch(genRefreshNetScene(), fVar);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
    public void fetchPreload(f<bo> fVar) {
        p.h(fVar, "callback");
        super.fetchPreload(fVar);
        fetch(genRefreshNetScene(), fVar);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
    public void fetchLoadMore(f<bo> fVar) {
        p.h(fVar, "callback");
        fetch(genLoadMoreNetScene(), fVar);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        p.h(qVar, "scene");
        f<bo> fVar = this.map.get(qVar);
        if (fVar != null) {
            this.map.remove(qVar);
            IResponse<bo> dealOnSceneEnd = dealOnSceneEnd(i2, i3, str, qVar);
            if (dealOnSceneEnd != null) {
                fVar.onFetchDone(dealOnSceneEnd);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
    public void fetch(Object obj, f<bo> fVar) {
        p.h(fVar, "callback");
        if (obj != null && (obj instanceof q)) {
            this.map.put(obj, fVar);
            g.azz().b((q) obj);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
    public void alive() {
        super.alive();
        Iterator<T> it = getCmdIds().iterator();
        while (it.hasNext()) {
            g.azz().a(it.next().intValue(), this);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
    public void dead() {
        super.dead();
        Iterator<T> it = getCmdIds().iterator();
        while (it.hasNext()) {
            g.azz().b(it.next().intValue(), this);
        }
    }
}
