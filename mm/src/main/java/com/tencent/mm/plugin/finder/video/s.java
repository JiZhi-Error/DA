package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.cjl;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "", "downloadUrl", "", "path", "mediaId", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getDownloadUrl", "()Ljava/lang/String;", "getFeedData", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getLocalFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaId", "getPath", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "toString", "plugin-finder_release"})
public class s {
    final String downloadUrl;
    public final String mediaId;
    public final String path;
    public final com.tencent.mm.plugin.finder.loader.s tHN;
    final cjl wgl;
    public final FeedData wgm;

    public s(String str, String str2, String str3, cjl cjl, com.tencent.mm.plugin.finder.loader.s sVar, FeedData feedData) {
        p.h(str2, "path");
        p.h(str3, "mediaId");
        p.h(sVar, "video");
        p.h(feedData, "feedData");
        AppMethodBeat.i(254405);
        this.downloadUrl = str;
        this.path = str2;
        this.mediaId = str3;
        this.wgl = cjl;
        this.tHN = sVar;
        this.wgm = feedData;
        AppMethodBeat.o(254405);
    }

    public String toString() {
        AppMethodBeat.i(254404);
        String str = " downloadUrl='" + this.downloadUrl + "', path='" + this.path + "', mediaId='" + this.mediaId + "' localFinderMedia is null? " + (this.wgl == null) + ' ';
        AppMethodBeat.o(254404);
        return str;
    }
}
