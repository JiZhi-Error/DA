package com.tencent.mm.plugin.finder.event.base;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0013\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\b\u0010,\u001a\u00020\u0012H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u0004¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "getPayload", "()Ljava/lang/Object;", "setPayload", "(Ljava/lang/Object;)V", "getType", "setType", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "Companion", "plugin-finder_release"})
public final class a extends b {
    public static final C1106a tHV = new C1106a((byte) 0);
    private int type;

    static {
        AppMethodBeat.i(165539);
        AppMethodBeat.o(165539);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(165541);
        if (this == obj || ((obj instanceof a) && this.type == ((a) obj).type)) {
            AppMethodBeat.o(165541);
            return true;
        }
        AppMethodBeat.o(165541);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(165540);
        int i2 = this.type;
        AppMethodBeat.o(165540);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent$Companion;", "", "()V", "DATA_CHANGE", "", "DATA_INSERT", "DATA_LOAD_MORE", "DATA_REFRESH", "DATA_REMOVE", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.event.base.a$a  reason: collision with other inner class name */
    public static final class C1106a {
        private C1106a() {
        }

        public /* synthetic */ C1106a(byte b2) {
            this();
        }
    }

    public final String toString() {
        AppMethodBeat.i(165536);
        String str = "DataChangeEvent(type=" + this.type + ')';
        AppMethodBeat.o(165536);
        return str;
    }
}
