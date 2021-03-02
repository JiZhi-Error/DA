package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.logic.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010I\u001a\u00020\u0010J\u0006\u0010J\u001a\u00020\u0010J\u0006\u0010K\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001a\u0010&\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R \u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010-\"\u0004\b<\u0010/R\u001a\u0010=\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010\u000eR\u001a\u0010@\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0012\"\u0004\bB\u0010\u0014R\u001a\u0010C\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\f\"\u0004\bH\u0010\u000e¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FeedData;", "", "()V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "hasBgmInfo", "", "getHasBgmInfo", "()Z", "setHasBgmInfo", "(Z)V", "isLongVideo", "setLongVideo", "likeCount", "getLikeCount", "setLikeCount", "liveId", "getLiveId", "setLiveId", "liveStatus", "getLiveStatus", "setLiveStatus", ch.COL_LOCALID, "getLocalId", "setLocalId", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "onlineNum", "getOnlineNum", "setOnlineNum", "rvFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getRvFeedList", "setRvFeedList", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "timestamps", "getTimestamps", "setTimestamps", "urlValidDuration", "getUrlValidDuration", "setUrlValidDuration", "userName", "getUserName", "setUserName", "getExpectId", "getId", "printSimpleId", "Companion", "plugin-finder_release"})
public final class FeedData {
    public static final a Companion = new a((byte) 0);
    private int commentCount;
    private String description = "";
    private long feedId;
    private boolean hasBgmInfo;
    private boolean isLongVideo;
    private int likeCount;
    private long liveId;
    private int liveStatus;
    private long localId;
    private LinkedList<cjl> mediaList = new LinkedList<>();
    private int mediaType;
    private String nickName = "";
    private int onlineNum;
    private LinkedList<BaseFinderFeed> rvFeedList = new LinkedList<>();
    private String sessionBuffer = "";
    private long timestamps;
    private int urlValidDuration;
    private String userName = "";

    static {
        AppMethodBeat.i(251512);
        AppMethodBeat.o(251512);
    }

    public FeedData() {
        AppMethodBeat.i(251511);
        AppMethodBeat.o(251511);
    }

    public final long getFeedId() {
        return this.feedId;
    }

    public final void setFeedId(long j2) {
        this.feedId = j2;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        AppMethodBeat.i(251504);
        p.h(str, "<set-?>");
        this.userName = str;
        AppMethodBeat.o(251504);
    }

    public final String getSessionBuffer() {
        return this.sessionBuffer;
    }

    public final void setSessionBuffer(String str) {
        AppMethodBeat.i(251505);
        p.h(str, "<set-?>");
        this.sessionBuffer = str;
        AppMethodBeat.o(251505);
    }

    public final long getLocalId() {
        return this.localId;
    }

    public final void setLocalId(long j2) {
        this.localId = j2;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        AppMethodBeat.i(251506);
        p.h(str, "<set-?>");
        this.nickName = str;
        AppMethodBeat.o(251506);
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        AppMethodBeat.i(251507);
        p.h(str, "<set-?>");
        this.description = str;
        AppMethodBeat.o(251507);
    }

    public final long getTimestamps() {
        return this.timestamps;
    }

    public final void setTimestamps(long j2) {
        this.timestamps = j2;
    }

    public final int getUrlValidDuration() {
        return this.urlValidDuration;
    }

    public final void setUrlValidDuration(int i2) {
        this.urlValidDuration = i2;
    }

    public final LinkedList<cjl> getMediaList() {
        return this.mediaList;
    }

    public final void setMediaList(LinkedList<cjl> linkedList) {
        AppMethodBeat.i(251508);
        p.h(linkedList, "<set-?>");
        this.mediaList = linkedList;
        AppMethodBeat.o(251508);
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType(int i2) {
        this.mediaType = i2;
    }

    public final boolean getHasBgmInfo() {
        return this.hasBgmInfo;
    }

    public final void setHasBgmInfo(boolean z) {
        this.hasBgmInfo = z;
    }

    public final LinkedList<BaseFinderFeed> getRvFeedList() {
        return this.rvFeedList;
    }

    public final void setRvFeedList(LinkedList<BaseFinderFeed> linkedList) {
        AppMethodBeat.i(251509);
        p.h(linkedList, "<set-?>");
        this.rvFeedList = linkedList;
        AppMethodBeat.o(251509);
    }

    public final boolean isLongVideo() {
        return this.isLongVideo;
    }

    public final void setLongVideo(boolean z) {
        this.isLongVideo = z;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final void setLikeCount(int i2) {
        this.likeCount = i2;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final void setCommentCount(int i2) {
        this.commentCount = i2;
    }

    public final long getLiveId() {
        return this.liveId;
    }

    public final void setLiveId(long j2) {
        this.liveId = j2;
    }

    public final int getLiveStatus() {
        return this.liveStatus;
    }

    public final void setLiveStatus(int i2) {
        this.liveStatus = i2;
    }

    public final int getOnlineNum() {
        return this.onlineNum;
    }

    public final void setOnlineNum(int i2) {
        this.onlineNum = i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FeedData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "feed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static FeedData i(FinderItem finderItem) {
            Long valueOf;
            Integer valueOf2;
            Integer valueOf3;
            int i2 = 0;
            AppMethodBeat.i(251502);
            p.h(finderItem, "finderItem");
            FeedData feedData = new FeedData();
            feedData.setFeedId(finderItem.getId());
            feedData.setUserName(finderItem.getUserName());
            String str = finderItem.getFeedObject().sessionBuffer;
            if (str == null) {
                str = "";
            }
            feedData.setSessionBuffer(str);
            feedData.setLocalId(finderItem.getLocalId());
            feedData.setNickName(finderItem.getNickName());
            feedData.setDescription(finderItem.getDescription());
            feedData.setTimestamps(finderItem.getTimestamps());
            feedData.setUrlValidDuration(finderItem.getFeedObject().urlValidDuration);
            b bVar = b.tUw;
            feedData.setMediaList(b.b(finderItem));
            feedData.setMediaType(finderItem.getMediaType());
            FinderObjectDesc finderObjectDesc = finderItem.getFeedObject().objectDesc;
            feedData.setHasBgmInfo((finderObjectDesc != null ? finderObjectDesc.feedBgmInfo : null) != null);
            feedData.setLikeCount(finderItem.getLikeCount());
            feedData.setCommentCount(finderItem.getCommentCount());
            awe awe = finderItem.getFeedObject().liveInfo;
            if (awe != null) {
                valueOf = Long.valueOf(awe.liveId);
            } else {
                awe liveInfo = finderItem.getLiveInfo();
                valueOf = liveInfo != null ? Long.valueOf(liveInfo.liveId) : null;
            }
            feedData.setLiveId(valueOf != null ? valueOf.longValue() : 0);
            FinderContact finderContact = finderItem.getFeedObject().contact;
            if (finderContact != null) {
                valueOf2 = Integer.valueOf(finderContact.liveStatus);
            } else {
                awe awe2 = finderItem.getFeedObject().liveInfo;
                valueOf2 = awe2 != null ? Integer.valueOf(awe2.liveStatus) : null;
            }
            if (valueOf2 == null) {
                awe liveInfo2 = finderItem.getLiveInfo();
                if (liveInfo2 != null) {
                    valueOf2 = Integer.valueOf(liveInfo2.liveStatus);
                } else {
                    valueOf2 = null;
                }
            }
            feedData.setLiveStatus(valueOf2 != null ? valueOf2.intValue() : 0);
            awe awe3 = finderItem.getFeedObject().liveInfo;
            if (awe3 != null) {
                valueOf3 = Integer.valueOf(awe3.uBn);
            } else {
                awe liveInfo3 = finderItem.getLiveInfo();
                valueOf3 = liveInfo3 != null ? Integer.valueOf(liveInfo3.uBn) : null;
            }
            if (valueOf3 != null) {
                i2 = valueOf3.intValue();
            }
            feedData.setOnlineNum(i2);
            AppMethodBeat.o(251502);
            return feedData;
        }

        public static FeedData a(bm bmVar) {
            long j2;
            String str;
            String str2;
            String str3;
            String str4;
            int i2;
            Integer valueOf;
            cnl cnl;
            long j3 = 0;
            int i3 = 0;
            AppMethodBeat.i(251503);
            p.h(bmVar, "megaVideoFeed");
            FeedData feedData = new FeedData();
            cng cng = bmVar.tuP;
            if (cng != null) {
                j2 = cng.id;
            } else {
                j2 = 0;
            }
            feedData.setFeedId(j2);
            FinderContact finderContact = bmVar.contact;
            if (finderContact == null || (str = finderContact.username) == null) {
                str = "";
            }
            feedData.setUserName(str);
            cng cng2 = bmVar.tuP;
            if (cng2 == null || (str2 = cng2.sessionBuffer) == null) {
                str2 = "";
            }
            feedData.setSessionBuffer(str2);
            FinderContact finderContact2 = bmVar.contact;
            if (finderContact2 == null || (str3 = finderContact2.nickname) == null) {
                str3 = "";
            }
            feedData.setNickName(str3);
            cng cng3 = bmVar.tuP;
            if (cng3 == null || (cnl = cng3.MtG) == null || (str4 = cnl.description) == null) {
                str4 = "";
            }
            feedData.setDescription(str4);
            feedData.setTimestamps(bmVar.timestamps);
            cng cng4 = bmVar.tuP;
            if (cng4 != null) {
                i2 = cng4.urlValidDuration;
            } else {
                i2 = 0;
            }
            feedData.setUrlValidDuration(i2);
            feedData.setMediaList(bmVar.dkV());
            feedData.setMediaType(4);
            feedData.setLongVideo(true);
            feedData.setLikeCount(bmVar.getFeedObject().likeCount);
            feedData.setCommentCount(bmVar.getFeedObject().commentCount);
            awe awe = bmVar.getFeedObject().liveInfo;
            if (awe != null) {
                j3 = awe.liveId;
            }
            feedData.setLiveId(j3);
            FinderContact finderContact3 = bmVar.getFeedObject().contact;
            if (finderContact3 != null) {
                valueOf = Integer.valueOf(finderContact3.liveStatus);
            } else {
                awe awe2 = bmVar.getFeedObject().liveInfo;
                valueOf = awe2 != null ? Integer.valueOf(awe2.liveStatus) : null;
            }
            feedData.setLiveStatus(valueOf != null ? valueOf.intValue() : 0);
            awe awe3 = bmVar.getFeedObject().liveInfo;
            if (awe3 != null) {
                i3 = awe3.uBn;
            }
            feedData.setOnlineNum(i3);
            AppMethodBeat.o(251503);
            return feedData;
        }

        public static FeedData s(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(251501);
            p.h(baseFinderFeed, "baseFinderFeed");
            FeedData i2 = i(baseFinderFeed.feedObject);
            AppMethodBeat.o(251501);
            return i2;
        }
    }

    public final long getId() {
        return this.feedId;
    }

    public final long getExpectId() {
        if (this.feedId == 0) {
            return this.localId;
        }
        return this.feedId;
    }

    public final String printSimpleId() {
        AppMethodBeat.i(251510);
        String valueOf = String.valueOf(getId());
        int min = Math.min(valueOf.length(), 8);
        if (valueOf == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(251510);
            throw tVar;
        }
        String substring = valueOf.substring(0, min);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(251510);
        return substring;
    }
}
