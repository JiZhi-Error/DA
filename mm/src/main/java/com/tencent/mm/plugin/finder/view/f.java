package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderExposeInfoChangeEvent;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "callback", "", "event", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
public abstract class f extends IListener<hv> {
    public abstract FinderItem EB(long j2);

    public abstract void a(long j2, azt azt);

    public abstract String getTag();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public /* synthetic */ boolean callback(hv hvVar) {
        hv hvVar2 = hvVar;
        p.h(hvVar2, "event");
        d.h(new a(this, hvVar2));
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f wlr;
        final /* synthetic */ hv wls;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, hv hvVar) {
            super(0);
            this.wlr = fVar;
            this.wls = hvVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            LinkedList<FinderCommentInfo> linkedList;
            AppMethodBeat.i(168306);
            long j2 = this.wls.dMr.feedId;
            azt azt = this.wls.dMr.dMs;
            int i2 = this.wls.dMr.dMt;
            Log.i(this.wlr.getTag(), "[FinderExposeChangedEventListener] feedId=" + j2 + " commentList=" + ((azt == null || (linkedList = azt.commentList) == null) ? null : Integer.valueOf(linkedList.size())) + ' ' + "totalCommentCount=" + i2);
            FinderItem EB = this.wlr.EB(j2);
            if (EB != null) {
                Log.i(this.wlr.getTag(), "[FinderExposeChangedEventListener] feedObject: " + EB.getFeedObject().hashCode() + ", " + EB.getId());
                if (azt != null) {
                    LinkedList<FinderCommentInfo> linkedList2 = azt.commentList;
                    p.g(linkedList2, "exposeInfo.commentList");
                    EB.setCommentList(linkedList2);
                }
                if (i2 >= 0) {
                    EB.setCommentCount(i2);
                }
                this.wlr.a(j2, azt);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(168306);
            return xVar;
        }
    }
}
