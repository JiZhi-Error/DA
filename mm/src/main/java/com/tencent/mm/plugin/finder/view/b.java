package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "", "event", "Companion", "plugin-finder_release"})
public final class b extends IListener<ii> {
    public static final a wjJ = new a((byte) 0);
    private final BaseFinderFeedLoader tFM;

    static {
        AppMethodBeat.i(254621);
        AppMethodBeat.o(254621);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(BaseFinderFeedLoader baseFinderFeedLoader) {
        p.h(baseFinderFeedLoader, "feedLoader");
        AppMethodBeat.i(254620);
        this.tFM = baseFinderFeedLoader;
        AppMethodBeat.o(254620);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ii iiVar) {
        AppMethodBeat.i(254619);
        ii iiVar2 = iiVar;
        p.h(iiVar2, "event");
        ArrayList<BaseFinderFeed> arrayList = new ArrayList();
        arrayList.addAll(this.tFM.getListOfType(BaseFinderFeed.class));
        for (BaseFinderFeed baseFinderFeed : arrayList) {
            j.a aVar = j.vUw;
            LinkedList<FinderCommentInfo> p = j.vUv.p(baseFinderFeed.feedObject.getFeedObject());
            T t = null;
            for (T t2 : p) {
                if (p.j(t2.username, iiVar2.dMV.dMW)) {
                    t = t2;
                }
            }
            if (t != null) {
                p.remove(t);
                FinderItem finderItem = baseFinderFeed.feedObject;
                finderItem.setFriendLikeCount(finderItem.getFriendLikeCount() - 1);
                if (baseFinderFeed.feedObject.getFeedObject().msgEventFlag == 1 && t.unreadFlag == 1 && baseFinderFeed.feedObject.getFeedObject().incFriendLikeCount > 0) {
                    FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                    feedObject.incFriendLikeCount--;
                    Log.i("Finder.ContactUninterestEventListener", "FinderUninterestEvent " + iiVar2.dMV.dMW + ", " + baseFinderFeed.feedObject.getFeedObject().incFriendLikeCount);
                }
                hn hnVar = new hn();
                hnVar.dLW.type = 4;
                hnVar.dLW.id = baseFinderFeed.lT();
                EventCenter.instance.publish(hnVar);
            }
        }
        AppMethodBeat.o(254619);
        return true;
    }
}
