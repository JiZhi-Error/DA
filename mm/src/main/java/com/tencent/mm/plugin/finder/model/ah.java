package com.tencent.mm.plugin.finder.model;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "privateMsgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "commentFailedNotifyDataList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "getCommentFailedNotifyDataList", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "getMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "getPrivateMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "compare", "", "obj", "getItemId", "", "getItemType", "isEmpty", "", "plugin-finder_release"})
public final class ah extends g.b implements i {
    public final h msgNotifyData;
    public final bh tSf;
    public final ConcurrentLinkedQueue<f> tSj;

    public ah(h hVar, bh bhVar, ConcurrentLinkedQueue<f> concurrentLinkedQueue) {
        p.h(hVar, "msgNotifyData");
        p.h(bhVar, "privateMsgNotifyData");
        p.h(concurrentLinkedQueue, "commentFailedNotifyDataList");
        AppMethodBeat.i(248761);
        this.msgNotifyData = hVar;
        this.tSf = bhVar;
        this.tSj = concurrentLinkedQueue;
        AppMethodBeat.o(248761);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248758);
        p.h(iVar, "obj");
        AppMethodBeat.o(248758);
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248759);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248759);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE;
    }

    public final boolean isEmpty() {
        T t;
        boolean z;
        AppMethodBeat.i(248760);
        Iterator<T> it = this.tSj.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.uNO != 1) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (t == null && this.msgNotifyData.count <= 0) {
            h hVar = h.tKR;
            h.a value = h.daX().getValue();
            if (value == null || !value.dEF) {
                AppMethodBeat.o(248760);
                return true;
            }
        }
        AppMethodBeat.o(248760);
        return false;
    }
}
