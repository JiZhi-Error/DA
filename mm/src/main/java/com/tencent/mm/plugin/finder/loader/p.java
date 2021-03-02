package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0019\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public class p implements o {
    final String md5;
    private final x uJn;
    private final String url;

    public p(String str, x xVar) {
        kotlin.g.b.p.h(xVar, "mediaType");
        AppMethodBeat.i(166332);
        this.url = str;
        this.uJn = xVar;
        String str2 = this.url;
        this.md5 = MD5Util.getMD5String(str2 == null ? "" : str2);
        AppMethodBeat.o(166332);
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final x djU() {
        return this.uJn;
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
    public final String getUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String aBE() {
        String str = this.url;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getPath() {
        AppMethodBeat.i(166330);
        al alVar = al.waC;
        String a2 = al.a(this);
        AppMethodBeat.o(166330);
        return a2;
    }

    @Override // com.tencent.mm.loader.h.a.c
    public String auA() {
        AppMethodBeat.i(166331);
        String str = this.uJn.detail + "_finder_" + this.md5;
        AppMethodBeat.o(166331);
        return str;
    }
}
