package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", ch.COL_USERNAME, "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class q implements o {
    public static final a uJo = new a((byte) 0);
    private cjl uIw;
    private x uIx;
    private String username;

    static {
        AppMethodBeat.i(248232);
        AppMethodBeat.o(248232);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ q(com.tencent.mm.protocal.protobuf.cjl r4, com.tencent.mm.plugin.finder.storage.x r5) {
        /*
            r3 = this;
            r2 = 248231(0x3c9a7, float:3.47846E-40)
            java.lang.String r0 = com.tencent.mm.model.z.aTY()
            java.lang.String r1 = "ConfigStorageLogic.getUsernameFromUserInfo()"
            kotlin.g.b.p.g(r0, r1)
            r3.<init>(r4, r5, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.loader.q.<init>(com.tencent.mm.protocal.protobuf.cjl, com.tencent.mm.plugin.finder.storage.x):void");
    }

    private q(cjl cjl, x xVar, String str) {
        p.h(cjl, "mediaObj");
        p.h(xVar, "type");
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(248230);
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        this.username = aTY;
        this.uIw = cjl;
        this.uIx = xVar;
        this.username = str;
        if (cjl.url == null) {
            b.e("FinderVideoCover", "mediaObj.url == null " + Util.getStack());
        }
        AppMethodBeat.o(248230);
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final x djU() {
        return this.uIx;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djV() {
        String str = this.uIw.decodeKey;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getPath() {
        AppMethodBeat.i(248227);
        al alVar = al.waC;
        String a2 = al.a(this);
        AppMethodBeat.o(248227);
        return a2;
    }

    @Override // com.tencent.mm.loader.h.a.c
    public final String auA() {
        AppMethodBeat.i(248228);
        String str = "finder_video_cover_" + this.uIx.detail + '_' + (Util.isNullOrNil(this.uIw.mediaId) ? MD5Util.getMD5String(Util.nullAs(this.uIw.url, "")) : this.uIw.mediaId);
        AppMethodBeat.o(248228);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String getUrl() {
        String str = this.uIw.coverUrl;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djW() {
        String str = this.uIw.cover_url_token;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String aBE() {
        AppMethodBeat.i(248229);
        String str = this.uIw.coverUrl;
        if (str == null) {
            str = "";
        }
        p.g(str, "mediaObj.coverUrl ?: \"\"");
        AppMethodBeat.o(248229);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public final String djX() {
        String str = this.uIw.cover_url_token;
        return str == null ? "" : str;
    }
}
