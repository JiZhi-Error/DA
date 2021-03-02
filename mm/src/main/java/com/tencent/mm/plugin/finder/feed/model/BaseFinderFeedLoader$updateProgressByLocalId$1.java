package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class BaseFinderFeedLoader$updateProgressByLocalId$1 extends q implements a<x> {
    final /* synthetic */ long $localId;
    final /* synthetic */ BaseFinderFeedLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseFinderFeedLoader$updateProgressByLocalId$1(BaseFinderFeedLoader baseFinderFeedLoader, long j2) {
        super(0);
        this.this$0 = baseFinderFeedLoader;
        this.$localId = j2;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(244548);
        int i2 = 0;
        for (Object obj : this.this$0.getDataList()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            bo boVar = (bo) obj;
            if ((boVar instanceof BaseFinderFeed) && ((BaseFinderFeed) boVar).feedObject.getLocalId() == this.$localId) {
                c.a aVar = c.vGN;
                FinderItem FS = c.a.FS(this.$localId);
                if (FS != null) {
                    boolean z = ((BaseFinderFeed) boVar).showLikeTips;
                    DataBuffer dataList = this.this$0.getDataList();
                    BaseFinderFeed transformFinderObj = this.this$0.transformFinderObj(FS);
                    transformFinderObj.showLikeTips = z;
                    transformFinderObj.showShareSns = ((BaseFinderFeed) boVar).showShareSns;
                    dataList.set(i2, transformFinderObj);
                }
                Log.i(this.this$0.getTAG(), "updateProgressByLoalId " + ((BaseFinderFeed) boVar).feedObject.getLocalId());
                this.this$0.dispatcher().onItemRangeChanged(i2, 1, new o(2, 1));
            }
            i2 = i3;
        }
        AppMethodBeat.o(244548);
    }
}
