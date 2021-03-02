package com.tencent.mm.plugin.finder.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mm.ac.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bcw;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010q\u001a\u00020<2\u0006\u0010r\u001a\u00020sH\u0016J\u0013\u0010t\u001a\u00020\u001a2\b\u0010u\u001a\u0004\u0018\u00010vH\u0002J\b\u0010w\u001a\u00020xH\u0016J\b\u0010y\u001a\u00020<H\u0016J\b\u0010z\u001a\u00020#H\u0016J\b\u0010{\u001a\u00020<H\u0016J\u0006\u0010|\u001a\u00020}J\u0006\u0010~\u001a\u00020#J\b\u0010\u001a\u00020#H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0005R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001a\u0010-\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010/\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u00101\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001a\u00103\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u00105\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001a\u00107\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001a\u00109\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001c\"\u0004\bJ\u0010\u001eR\u001a\u0010K\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010=\"\u0004\bM\u0010?R\u001a\u0010N\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010=\"\u0004\bP\u0010?R \u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0013\u0010X\u001a\u0004\u0018\u00010Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u001c\"\u0004\b^\u0010\u001eR\u001a\u0010_\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u001c\"\u0004\ba\u0010\u001eR\u001a\u0010b\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u001c\"\u0004\bd\u0010\u001eR\u001c\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020lX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/model/IFeedSessionBuffer;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "attachFavInfo", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "getAttachFavInfo", "()Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "setAttachFavInfo", "(Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;)V", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "doingRelReq", "", "getDoingRelReq", "()Z", "setDoingRelReq", "(Z)V", "getFeedObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObject", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "headerWording", "getHeaderWording", "setHeaderWording", "isContentCollapsed", "setContentCollapsed", "isDeepEnjoy", "setDeepEnjoy", "isFinishPostSoon", "setFinishPostSoon", "isHasLongVideoTimeBack", "setHasLongVideoTimeBack", "isNeedShowUnFollow", "setNeedShowUnFollow", "isOriginFeed", "setOriginFeed", "isPreview", "setPreview", "isShowFooterMask", "setShowFooterMask", "isShowGuideTips", "", "()I", "setShowGuideTips", "(I)V", "isShowHistoryTips", "setShowHistoryTips", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "markRead", "getMarkRead", "setMarkRead", "msgEventFriendLikeCount", "getMsgEventFriendLikeCount", "setMsgEventFriendLikeCount", "msgEventIncCount", "getMsgEventIncCount", "setMsgEventIncCount", "msgEventLikeList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getMsgEventLikeList", "()Ljava/util/List;", "setMsgEventLikeList", "(Ljava/util/List;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "showCommentEdu", "getShowCommentEdu", "setShowCommentEdu", "showLikeTips", "getShowLikeTips", "setShowLikeTips", "showShareSns", "getShowShareSns", "setShowShareSns", "streamDivider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "getStreamDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "setStreamDivider", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "triggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getTriggerConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setTriggerConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;)V", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "getItemId", "", "getItemType", "getSessionBuffer", "hashCode", "onStore", "", "printSimpleId", "toString", "plugin-finder_release"})
public abstract class BaseFinderFeed implements bo {
    public k attachFavInfo;
    private LinkedList<s> commentList = new LinkedList<>();
    public g contact;
    public boolean doingRelReq;
    public FinderItem feedObject;
    public String footerWording = "";
    public String headerWording = "";
    public boolean isContentCollapsed = true;
    public boolean isDeepEnjoy;
    public boolean isFinishPostSoon;
    public boolean isHasLongVideoTimeBack;
    private boolean isNeedShowUnFollow;
    public boolean isOriginFeed;
    public boolean isPreview;
    private boolean isShowFooterMask;
    public int isShowGuideTips;
    private int isShowHistoryTips;
    public b likeBuffer;
    public boolean markRead;
    public int msgEventFriendLikeCount;
    public int msgEventIncCount;
    public List<? extends FinderCommentInfo> msgEventLikeList;
    public final azk musicInfo;
    public boolean showCommentEdu;
    public boolean showLikeTips;
    public boolean showShareSns;
    public bcw streamDivider;
    public FinderItem.b triggerConfig;

    public BaseFinderFeed(FinderItem finderItem) {
        azr azr;
        p.h(finderItem, "feedObject");
        this.feedObject = finderItem;
        this.msgEventFriendLikeCount = finderItem.getFriendLikeCount();
        this.msgEventIncCount = finderItem.getFeedObject().incFriendLikeCount;
        ArrayList arrayList = new ArrayList();
        for (T t : finderItem.getLikeList()) {
            if (t.unreadFlag == 1) {
                arrayList.add(t);
            }
        }
        this.msgEventLikeList = arrayList;
        this.triggerConfig = finderItem.parseJsonOfPosTriggerConfig();
        this.likeBuffer = finderItem.getFeedObject().likeBuffer;
        this.isPreview = finderItem.isPreview();
        FinderObjectDesc finderObjectDesc = finderItem.getFeedObject().objectDesc;
        this.musicInfo = (finderObjectDesc == null || (azr = finderObjectDesc.feedBgmInfo) == null) ? null : azr.musicInfo;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public int a(i iVar) {
        i iVar2;
        p.h(iVar, "obj");
        if (!(iVar instanceof BaseFinderFeed)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) iVar2;
        if (baseFinderFeed == null) {
            return -1;
        }
        if (baseFinderFeed.feedObject.field_id != 0 && this.feedObject.field_id != 0 && baseFinderFeed.feedObject.field_id == this.feedObject.field_id) {
            return 0;
        }
        if (baseFinderFeed.feedObject.getLocalId() > 0 && this.feedObject.getLocalId() > 0 && baseFinderFeed.feedObject.getLocalId() == this.feedObject.getLocalId()) {
            return 0;
        }
        if (this.feedObject.getCreateTime() > baseFinderFeed.feedObject.getCreateTime()) {
            return 1;
        }
        return -1;
    }

    public final String getSessionBuffer() {
        String str = this.feedObject.getFeedObject().sessionBuffer;
        return str == null ? "" : str;
    }

    public String toString() {
        String str;
        String str2;
        if ("".length() > 3) {
            String substring = "".substring(0, 3);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str = substring;
        } else {
            str = "";
        }
        Integer valueOf = Integer.valueOf(this.feedObject.getCreateTime());
        if (this.feedObject.getMediaList().size() > 0) {
            str2 = this.feedObject.getMediaList().get(0).url;
        } else {
            str2 = "";
        }
        return "id=[" + this.feedObject.field_id + ',' + d.zs(this.feedObject.field_id) + "] type=" + this.feedObject.getMediaType() + " localId=" + this.feedObject.getLocalId() + " time:" + valueOf + " url:" + str2 + ' ' + str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseFinderFeed) {
            return lT() == ((BaseFinderFeed) obj).lT();
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return (int) lT();
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public long lT() {
        return this.feedObject.field_id == 0 ? this.feedObject.getLocalId() : this.feedObject.field_id;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public int cxn() {
        return this.feedObject.getMediaType();
    }

    public final void dku() {
        this.showLikeTips = false;
        this.showShareSns = false;
    }
}
