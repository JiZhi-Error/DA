package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder_release"})
public final class g implements o {
    public final String uId = ("finder_cover_" + MD5Util.getMD5String(this.url));
    private final String url;

    public g(String str) {
        p.h(str, "url");
        AppMethodBeat.i(166310);
        this.url = str;
        AppMethodBeat.o(166310);
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final x djU() {
        return x.FULL_IMAGE;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getPath() {
        AppMethodBeat.i(166309);
        al alVar = al.waC;
        String a2 = al.a(this);
        AppMethodBeat.o(166309);
        return a2;
    }

    @Override // com.tencent.mm.loader.h.a.c
    public final String auA() {
        return this.uId;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getUrl() {
        return this.url;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String aBE() {
        return this.url;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djV() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djW() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djX() {
        return "";
    }
}
