package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0001\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_NEARBY_LIVE", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder_release"})
public enum e {
    FEED_DEFAULT(-1),
    FEED_TIMELINE_ALL(0),
    FEED_TIMELINE_FRIEND(1),
    FEED_TIMELINE_LBS(2),
    FEED_NEARBY_LIVE(1001),
    FEED_TIMELINE_FOLLOW(3),
    FEED_TIMELINE_MACHINE(4),
    FEED_PROFILE(100),
    FEED_PROFILE_TIMELINE(101),
    FEED_LIKED_TIMELINE(102),
    FEED_RETRANSMIT_SOURCE(103),
    FEED_TOPIC_TIMELINE(104),
    FEED_FAV_LIST(105),
    FEED_FOLDED_LIST(106),
    FEED_FRIEND_LIKE_LIST(107),
    FEED_REL_RECOMMEND(17),
    FEED_AT_TIMELINE(18);
    
    public static final a tYB = new a((byte) 0);
    public final int value;

    public static e valueOf(String str) {
        AppMethodBeat.i(245024);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(245024);
        return eVar;
    }

    private e(int i2) {
        this.value = i2;
    }

    static {
        AppMethodBeat.i(245022);
        AppMethodBeat.o(245022);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e IO(int i2) {
            if (i2 == e.FEED_TIMELINE_ALL.value) {
                return e.FEED_TIMELINE_ALL;
            }
            if (i2 == e.FEED_TIMELINE_MACHINE.value) {
                return e.FEED_TIMELINE_MACHINE;
            }
            if (i2 == e.FEED_TIMELINE_LBS.value) {
                return e.FEED_TIMELINE_LBS;
            }
            if (i2 == e.FEED_TIMELINE_FOLLOW.value) {
                return e.FEED_TIMELINE_FOLLOW;
            }
            if (i2 == e.FEED_TIMELINE_FRIEND.value) {
                return e.FEED_TIMELINE_FRIEND;
            }
            if (i2 == e.FEED_NEARBY_LIVE.value) {
                return e.FEED_NEARBY_LIVE;
            }
            if (i2 == e.FEED_PROFILE.value) {
                return e.FEED_PROFILE;
            }
            if (i2 == e.FEED_PROFILE_TIMELINE.value) {
                return e.FEED_PROFILE_TIMELINE;
            }
            if (i2 == e.FEED_LIKED_TIMELINE.value) {
                return e.FEED_LIKED_TIMELINE;
            }
            if (i2 == e.FEED_RETRANSMIT_SOURCE.value) {
                return e.FEED_RETRANSMIT_SOURCE;
            }
            if (i2 == e.FEED_TOPIC_TIMELINE.value) {
                return e.FEED_TOPIC_TIMELINE;
            }
            if (i2 == e.FEED_FAV_LIST.value) {
                return e.FEED_FAV_LIST;
            }
            if (i2 == e.FEED_FOLDED_LIST.value) {
                return e.FEED_FOLDED_LIST;
            }
            if (i2 == e.FEED_FRIEND_LIKE_LIST.value) {
                return e.FEED_FRIEND_LIKE_LIST;
            }
            if (i2 == e.FEED_REL_RECOMMEND.value) {
                return e.FEED_REL_RECOMMEND;
            }
            if (i2 == e.FEED_AT_TIMELINE.value) {
                return e.FEED_AT_TIMELINE;
            }
            return e.FEED_DEFAULT;
        }
    }
}
