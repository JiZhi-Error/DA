package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "", "plugin-finder_release"})
public final class a implements o {
    private final String md5;
    public final String uId;
    private final String url;

    public a(String str) {
        AppMethodBeat.i(166299);
        this.url = str;
        String str2 = this.url;
        this.md5 = MD5Util.getMD5String(str2 == null ? "" : str2);
        this.uId = "finder_avatar_" + this.md5;
        AppMethodBeat.o(166299);
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final x djU() {
        return x.THUMB_IMAGE;
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

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getPath() {
        AppMethodBeat.i(166298);
        al alVar = al.waC;
        String a2 = al.a(this);
        AppMethodBeat.o(166298);
        return a2;
    }

    @Override // com.tencent.mm.loader.h.a.c
    public final String auA() {
        return this.uId;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getUrl() {
        AppMethodBeat.i(248206);
        String nullAsNil = Util.nullAsNil(this.url);
        p.g(nullAsNil, "Util.nullAsNil(url)");
        AppMethodBeat.o(248206);
        return nullAsNil;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String aBE() {
        AppMethodBeat.i(248207);
        String nullAsNil = Util.nullAsNil(this.url);
        p.g(nullAsNil, "Util.nullAsNil(url)");
        AppMethodBeat.o(248207);
        return nullAsNil;
    }
}
