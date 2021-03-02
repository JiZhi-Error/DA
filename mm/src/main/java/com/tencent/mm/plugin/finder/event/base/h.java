package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FeedData;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010/\u001a\u00020\u0016H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0004R\u001a\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0004R\u001a\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0004R\u001a\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0004R\u001a\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0004¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerFeedPosition", "getCenterFeedPosition", "()I", "setCenterFeedPosition", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstCompletelyVisibleItemPosition", "getFirstCompletelyVisibleItemPosition", "setFirstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "setFirstVisibleItemPosition", "itemCount", "getItemCount", "setItemCount", "lastCompletelyVisibleItemPosition", "getLastCompletelyVisibleItemPosition", "setLastCompletelyVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "newState", "getNewState", "setNewState", "getType", "setType", "toString", "Companion", "plugin-finder_release"})
public class h extends b {
    public static final a tIG = new a((byte) 0);
    int akb;
    public int tIA = -1;
    int tIB;
    public long tIC = -1;
    public int tID = -1;
    String tIE = "";
    public FeedData tIF;
    int tIx = -1;
    public int tIy = -1;
    int tIz = -1;
    public int type;

    static {
        AppMethodBeat.i(165569);
        AppMethodBeat.o(165569);
    }

    public h(int i2) {
        this.type = i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent$Companion;", "", "()V", "SCROLL_STATE_ATTACHED", "", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_DRAGGING_DISTANCE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ITEM_UPDATE", "SCROLL_STATE_LOW_SPEED_FLING", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_TAB_INVISIBLE", "SCROLL_STATE_ON_TAB_VISIBLE", "SCROLL_STATE_SETTLING", "SCROLL_STATE_UNKNOWN", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public String toString() {
        AppMethodBeat.i(165568);
        String str = "ScrollEvent(type=" + this.type + ", firstCompletelyVisibleItemPosition=" + this.tIx + ", firstVisibleItemPosition=" + this.tIy + ", lastCompletelyVisibleItemPosition=" + this.tIz + ", lastVisibleItemPosition=" + this.tIA + ", itemCount=" + this.akb + ", newState=" + this.tIB + ')';
        AppMethodBeat.o(165568);
        return str;
    }
}
