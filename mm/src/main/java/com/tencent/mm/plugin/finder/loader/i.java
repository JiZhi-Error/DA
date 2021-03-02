package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderFullThumbImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", ch.COL_USERNAME, "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "uniqueValue", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getThumbUrl", "getThumbUrlToken", "plugin-finder_release"})
public final class i extends k {
    private final String uId;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i(com.tencent.mm.protocal.protobuf.cjl r4, com.tencent.mm.plugin.finder.storage.x r5) {
        /*
            r3 = this;
            r2 = 248216(0x3c998, float:3.47825E-40)
            java.lang.String r0 = com.tencent.mm.model.z.aTY()
            java.lang.String r1 = "ConfigStorageLogic.getUsernameFromUserInfo()"
            kotlin.g.b.p.g(r0, r1)
            r3.<init>(r4, r5, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.loader.i.<init>(com.tencent.mm.protocal.protobuf.cjl, com.tencent.mm.plugin.finder.storage.x):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private i(cjl cjl, x xVar, String str) {
        super(cjl, xVar, str, null, 8);
        p.h(cjl, "mediaObj");
        p.h(xVar, "type");
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(248215);
        this.uId = "finder_image_" + xVar.detail + '_' + MD5Util.getMD5String(Util.nullAs(aBE(), ""));
        AppMethodBeat.o(248215);
    }

    @Override // com.tencent.mm.loader.h.a.c, com.tencent.mm.plugin.finder.loader.k
    public final String auA() {
        return this.uId;
    }

    @Override // com.tencent.mm.loader.h.a.d, com.tencent.mm.plugin.finder.loader.k
    public final Matrix D(float f2, float f3) {
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o, com.tencent.mm.plugin.finder.loader.k
    public final String aBE() {
        boolean z;
        AppMethodBeat.i(248213);
        String str = this.uIw.MoR;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String str2 = this.uIw.MoR;
            if (str2 == null) {
                p.hyc();
            }
            p.g(str2, "mediaObj.fullThumbUrl!!");
            AppMethodBeat.o(248213);
            return str2;
        }
        String aBE = super.aBE();
        AppMethodBeat.o(248213);
        return aBE;
    }

    @Override // com.tencent.mm.plugin.finder.loader.o, com.tencent.mm.plugin.finder.loader.k
    public final String djX() {
        boolean z;
        AppMethodBeat.i(248214);
        String str = this.uIw.MoS;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String str2 = this.uIw.MoS;
            if (str2 == null) {
                p.hyc();
            }
            p.g(str2, "mediaObj.fullThumbUrlToken!!");
            AppMethodBeat.o(248214);
            return str2;
        }
        String djX = super.djX();
        AppMethodBeat.o(248214);
        return djX;
    }
}
