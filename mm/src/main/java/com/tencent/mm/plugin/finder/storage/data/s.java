package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.aqq;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\t\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "", "()V", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "getSource", "()Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "setSource", "extract", "targetDataType", "", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public abstract class s {
    aqq vGD;

    public abstract bo dyH();

    public s() {
        this.vGD = new aqq();
    }

    public s(aqq aqq) {
        p.h(aqq, "source");
        this.vGD = aqq;
    }
}
