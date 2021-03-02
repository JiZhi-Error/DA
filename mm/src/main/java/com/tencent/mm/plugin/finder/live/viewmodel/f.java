package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003Jq\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\tHÖ\u0001J\t\u0010?\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "objectId", "", "sessionBuffer", "", "tabType", "", "nonceId", "scene", "long", "", "lat", "commentScene", "pullMoreType", "(Lcom/tencent/mm/protobuf/ByteString;JLjava/lang/String;ILjava/lang/String;IFFII)V", "getCommentScene", "()I", "setCommentScene", "(I)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLat", "()F", "setLat", "(F)V", "getLong", "setLong", "getNonceId", "()Ljava/lang/String;", "setNonceId", "(Ljava/lang/String;)V", "getObjectId", "()J", "setObjectId", "(J)V", "getPullMoreType", "setPullMoreType", "getScene", "setScene", "getSessionBuffer", "setSessionBuffer", "getTabType", "setTabType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class f {
    public int dLS;
    public long hFK;
    public String hwg;
    public float iUY;
    public int scene;
    public String sessionBuffer;
    public int tCE;
    public b tsO;
    public float uDl;
    public int uiy;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (r5.uiy == r6.uiy) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(247946);
        b bVar = this.tsO;
        int hashCode = bVar != null ? bVar.hashCode() : 0;
        long j2 = this.hFK;
        int i3 = ((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.sessionBuffer;
        int hashCode2 = ((((str != null ? str.hashCode() : 0) + i3) * 31) + this.dLS) * 31;
        String str2 = this.hwg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int floatToIntBits = ((((((((((hashCode2 + i2) * 31) + this.scene) * 31) + Float.floatToIntBits(this.uDl)) * 31) + Float.floatToIntBits(this.iUY)) * 31) + this.tCE) * 31) + this.uiy;
        AppMethodBeat.o(247946);
        return floatToIntBits;
    }

    public final String toString() {
        AppMethodBeat.i(247945);
        String str = "FinderLiveRelatedLoaderParam(lastBuf=" + this.tsO + ", objectId=" + this.hFK + ", sessionBuffer=" + this.sessionBuffer + ", tabType=" + this.dLS + ", nonceId=" + this.hwg + ", scene=" + this.scene + ", long=" + this.uDl + ", lat=" + this.iUY + ", commentScene=" + this.tCE + ", pullMoreType=" + this.uiy + ")";
        AppMethodBeat.o(247945);
        return str;
    }

    public /* synthetic */ f() {
        this("", "");
        AppMethodBeat.i(247944);
        AppMethodBeat.o(247944);
    }

    private f(String str, String str2) {
        p.h(str2, "nonceId");
        AppMethodBeat.i(261053);
        this.tsO = null;
        this.hFK = 0;
        this.sessionBuffer = str;
        this.dLS = 3;
        this.hwg = str2;
        this.scene = 0;
        this.uDl = 0.0f;
        this.iUY = 0.0f;
        this.tCE = 0;
        this.uiy = -1;
        AppMethodBeat.o(261053);
    }

    public final void atS(String str) {
        AppMethodBeat.i(247942);
        p.h(str, "<set-?>");
        this.hwg = str;
        AppMethodBeat.o(247942);
    }
}
