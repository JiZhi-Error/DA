package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "id", "name", "isPreviewPag", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public final class l implements o {
    private final String id;
    private final String name;
    private final boolean uIA;
    private final String url;

    public l(String str, String str2, String str3, boolean z) {
        p.h(str, "url");
        p.h(str2, "id");
        p.h(str3, "name");
        AppMethodBeat.i(248226);
        this.url = str;
        this.id = str2;
        this.name = str3;
        this.uIA = z;
        AppMethodBeat.o(248226);
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final x djU() {
        if (this.uIA) {
            return x.PREVIEW_PAG;
        }
        return x.FULL_PAG;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djV() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getUrl() {
        return this.url;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djW() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String aBE() {
        return this.url;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djX() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getPath() {
        return "";
    }

    @Override // com.tencent.mm.loader.h.a.c
    public final String auA() {
        AppMethodBeat.i(248225);
        String str = this.id + '_' + djU();
        AppMethodBeat.o(248225);
        return str;
    }
}
