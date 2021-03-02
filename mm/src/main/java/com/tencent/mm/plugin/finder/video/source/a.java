package com.tencent.mm.plugin.finder.video.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.protocal.protobuf.cjl;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/source/LocalMediaSource;", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "downloadUrl", "", "path", "mediaId", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "plugin-finder_release"})
public final class a extends s {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, String str2, String str3, cjl cjl, com.tencent.mm.plugin.finder.loader.s sVar, FeedData feedData) {
        super(str, str2, str3, cjl, sVar, feedData);
        p.h(str2, "path");
        p.h(str3, "mediaId");
        p.h(sVar, "video");
        p.h(feedData, "feedData");
        AppMethodBeat.i(254544);
        AppMethodBeat.o(254544);
    }
}
