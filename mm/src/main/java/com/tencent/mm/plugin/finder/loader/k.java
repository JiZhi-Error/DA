package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.h.a.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0016\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "Lcom/tencent/mm/loader/model/data/ILoaderDataMatrix;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", ch.COL_USERNAME, "", "localThumbUrl", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;Ljava/lang/String;)V", "getLocalThumbUrl", "()Ljava/lang/String;", "setLocalThumbUrl", "(Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getType", "()Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "setType", "(Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "getDecodeKey", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public class k implements d, o {
    public static final a uIz = new a((byte) 0);
    cjl uIw;
    private x uIx;
    public String uIy;
    private String username;

    static {
        AppMethodBeat.i(248224);
        AppMethodBeat.o(248224);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ k(com.tencent.mm.protocal.protobuf.cjl r3, com.tencent.mm.plugin.finder.storage.x r4, java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r2 = this;
            r1 = 248223(0x3c99f, float:3.47835E-40)
            r0 = r7 & 4
            if (r0 == 0) goto L_0x0011
            java.lang.String r5 = com.tencent.mm.model.z.aTY()
            java.lang.String r0 = "ConfigStorageLogic.getUsernameFromUserInfo()"
            kotlin.g.b.p.g(r5, r0)
        L_0x0011:
            r0 = r7 & 8
            if (r0 == 0) goto L_0x0018
            java.lang.String r6 = ""
        L_0x0018:
            r2.<init>(r3, r4, r5, r6)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.loader.k.<init>(com.tencent.mm.protocal.protobuf.cjl, com.tencent.mm.plugin.finder.storage.x, java.lang.String, java.lang.String, int):void");
    }

    private k(cjl cjl, x xVar, String str, String str2) {
        p.h(cjl, "mediaObj");
        p.h(xVar, "type");
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "localThumbUrl");
        AppMethodBeat.i(248222);
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        this.username = aTY;
        this.uIw = cjl;
        this.uIx = xVar;
        this.username = str;
        this.uIy = str2;
        if (cjl.url == null) {
            b.e("FinderImage", "mediaObj.url == null " + Util.getStack());
        }
        AppMethodBeat.o(248222);
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
        AppMethodBeat.i(248217);
        if (this.uIy.length() == 0) {
            al alVar = al.waC;
            String a2 = al.a(this);
            AppMethodBeat.o(248217);
            return a2;
        }
        String str = this.uIy;
        AppMethodBeat.o(248217);
        return str;
    }

    @Override // com.tencent.mm.loader.h.a.c
    public String auA() {
        AppMethodBeat.i(248218);
        String str = "finder_image_" + this.uIx.detail + '_' + (Util.isNullOrNil(this.uIw.mediaId) ? MD5Util.getMD5String(Util.nullAs(this.uIw.url, "")) : this.uIw.mediaId);
        AppMethodBeat.o(248218);
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
    public String aBE() {
        String str;
        AppMethodBeat.i(248219);
        if (this.uIy.length() == 0) {
            str = this.uIw.thumbUrl;
            if (str == null) {
                str = "";
            }
        } else {
            str = this.uIy;
        }
        p.g(str, "if (localThumbUrl.isEmpt… ?: \"\" else localThumbUrl");
        AppMethodBeat.o(248219);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o
    public String djX() {
        String str;
        AppMethodBeat.i(248220);
        if (!(this.uIy.length() == 0) || (str = this.uIw.thumb_url_token) == null) {
            str = "";
        }
        AppMethodBeat.o(248220);
        return str;
    }

    @Override // com.tencent.mm.loader.h.a.d
    public Matrix D(float f2, float f3) {
        AppMethodBeat.i(248221);
        if (this.uIx == x.THUMB_IMAGE) {
            AppMethodBeat.o(248221);
            return null;
        }
        aty aty = this.uIw.MoU;
        if (aty != null) {
            Matrix matrix = new Matrix();
            Rect rect = new Rect((int) aty.left, (int) aty.top, (int) aty.right, (int) aty.bottom);
            float max = Math.max(f2 / ((float) rect.width()), f3 / ((float) rect.height()));
            matrix.postScale(max, max);
            matrix.postTranslate(((float) (-rect.left)) * max, max * ((float) (-rect.top)));
            AppMethodBeat.o(248221);
            return matrix;
        }
        AppMethodBeat.o(248221);
        return null;
    }
}
