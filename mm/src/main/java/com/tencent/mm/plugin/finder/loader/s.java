package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.cjl;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", ch.COL_USERNAME, "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "toString", "plugin-finder_release"})
public final class s implements o {
    private String uId;
    public final cjl uIw;
    public final x uIx;
    public final int uJN;
    private final String username;

    private s(cjl cjl, x xVar, int i2, String str) {
        p.h(cjl, "mediaObj");
        p.h(xVar, "type");
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(248244);
        this.uIw = cjl;
        this.uIx = xVar;
        this.uJN = i2;
        this.username = str;
        AppMethodBeat.o(248244);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ s(com.tencent.mm.protocal.protobuf.cjl r4, com.tencent.mm.plugin.finder.storage.x r5, int r6, java.lang.String r7, int r8) {
        /*
            r3 = this;
            r2 = 248245(0x3c9b5, float:3.47865E-40)
            r0 = r8 & 4
            if (r0 == 0) goto L_0x0029
            r0 = 4
            boolean r0 = com.tencent.mm.modelcontrol.e.sX(r0)
            if (r0 == 0) goto L_0x0027
            r0 = 2
        L_0x000f:
            r1 = r8 & 8
            if (r1 == 0) goto L_0x001d
            java.lang.String r7 = com.tencent.mm.model.z.aUg()
            java.lang.String r1 = "ConfigStorageLogic.getMyFinderUsername()"
            kotlin.g.b.p.g(r7, r1)
        L_0x001d:
            r3.<init>(r4, r5, r0, r7)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x0027:
            r0 = 1
            goto L_0x000f
        L_0x0029:
            r0 = r6
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.loader.s.<init>(com.tencent.mm.protocal.protobuf.cjl, com.tencent.mm.plugin.finder.storage.x, int, java.lang.String, int):void");
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final x djU() {
        return this.uIx;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getPath() {
        AppMethodBeat.i(248240);
        al alVar = al.waC;
        String c2 = al.c(this);
        AppMethodBeat.o(248240);
        return c2;
    }

    @Override // com.tencent.mm.loader.h.a.c
    public final String auA() {
        AppMethodBeat.i(248241);
        String str = this.uId;
        if (str == null) {
            s sVar = this;
            al alVar = al.waC;
            str = al.an(sVar.uIx.detail, sVar.uIw.mediaId, sVar.uIw.url);
            sVar.uId = str;
        }
        AppMethodBeat.o(248241);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getUrl() {
        String str = this.uIw.url;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djW() {
        String str = this.uIw.url_token;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String aBE() {
        AppMethodBeat.i(248242);
        String str = this.uIw.thumbUrl;
        if (str == null) {
            str = "";
        }
        p.g(str, "mediaObj.thumbUrl ?: \"\"");
        AppMethodBeat.o(248242);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djX() {
        String str = this.uIw.thumb_url_token;
        return str == null ? "" : str;
    }

    public final String toString() {
        AppMethodBeat.i(248243);
        String str = this.uIw.mediaId + " url=" + this.uIw.url;
        AppMethodBeat.o(248243);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djV() {
        String str = this.uIw.decodeKey;
        return str == null ? "" : str;
    }
}
