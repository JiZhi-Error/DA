package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bcx;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\t8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u0004\u0018\u00010\t8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001a\u00100\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R \u00103\u001a\b\u0012\u0004\u0012\u00020\u000404X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001a\u0010@\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u001a\u0010B\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010;\"\u0004\bC\u0010=R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0013\"\u0004\bX\u0010\u0015R\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0013\"\u0004\bg\u0010\u0015R\u001a\u0010h\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0013\"\u0004\bj\u0010\u0015R\u001a\u0010k\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0013\"\u0004\bm\u0010\u0015¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "", "list", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Ljava/util/List;IILjava/lang/String;)V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continue_flag", "getContinue_flag", "()I", "setContinue_flag", "(I)V", "dataBufferList", "Ljava/util/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "endWording", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "getErrCode", "setErrCode", "getErrMsg", "setErrMsg", "getErrType", "setErrType", "finderItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderItems", "()Ljava/util/List;", "setFinderItems", "(Ljava/util/List;)V", "headWording", "getHeadWording", "setHeadWording", "historySize", "getHistorySize", "setHistorySize", "incrementList", "Ljava/util/LinkedList;", "getIncrementList", "()Ljava/util/LinkedList;", "setIncrementList", "(Ljava/util/LinkedList;)V", "isFetchHistoryNow", "", "()Z", "setFetchHistoryNow", "(Z)V", "isForceChangePrefetchResult", "setForceChangePrefetchResult", "isGetHistory", "setGetHistory", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "getLayoutInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "setLayoutInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;)V", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "getPreloadInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "setPreloadInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;)V", "pullType", "getPullType", "setPullType", "recommendTags", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getRecommendTags", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setRecommendTags", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "recommendTopic", "Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "getRecommendTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "setRecommendTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;)V", "ret_flag", "getRet_flag", "setRet_flag", "streamSize", "getStreamSize", "setStreamSize", "tabType", "getTabType", "setTabType", "plugin-finder_release"})
public final class b {
    public int dLS = -1;
    public int errCode;
    public String errMsg;
    public int errType;
    public boolean isNeedClear;
    public int kxF;
    public com.tencent.mm.bw.b lastBuffer;
    public baw preloadInfo;
    public int pullType;
    public String tQU;
    public List<? extends FinderObject> tUA;
    public int tUB;
    public int tUC;
    public boolean tUD;
    public boolean tUE;
    public apa tUF;
    public ArrayList<bo> tUG;
    public bcx tUH;
    public String tUI;
    public LinkedList<bo> tUz;
    public int ttV;
    public long ttW;
    public boolean twZ;

    public b(List<? extends bo> list, int i2, int i3, String str) {
        AppMethodBeat.i(244549);
        this.errType = i2;
        this.errCode = i3;
        this.errMsg = str;
        this.tUz = new LinkedList<>(list);
        this.pullType = -1;
        this.isNeedClear = true;
        this.ttW = -1;
        AppMethodBeat.o(244549);
    }
}
