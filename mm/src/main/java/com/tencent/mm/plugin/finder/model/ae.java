package com.tencent.mm.plugin.finder.model;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFoldedFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "id", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;J)V", "getFeedObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ae implements bo {
    public final FinderItem feedObject;
    private final long id;

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.id;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248752);
        p.h(iVar, "obj");
        if (!(iVar instanceof ae) || this.id != ((ae) iVar).id) {
            AppMethodBeat.o(248752);
            return -1;
        }
        AppMethodBeat.o(248752);
        return 0;
    }
}
