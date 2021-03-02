package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "scene", "sortRule", "(IIDDII)V", "Companion", "plugin-card_release"})
public final class a extends j<bma> {
    private static final String TAG = TAG;
    public static final C0905a pVy = new C0905a((byte) 0);

    public a(int i2, int i3, double d2, double d3, int i4) {
        AppMethodBeat.i(201372);
        blz blz = new blz();
        bma bma = new bma();
        blz.offset = i2;
        blz.Ler = i3;
        blz.latitude = d2;
        blz.longitude = d3;
        blz.Leq = i4;
        blz.scene = 1;
        a(blz, bma, 2619, "/cgi-bin/mmpay-bin/mktgetcouponhomepage");
        Log.i(TAG, "offset: " + i2 + ", reqnum: " + i3);
        Log.d(TAG, "latitude: " + d2 + ", longitude: " + d3);
        AppMethodBeat.o(201372);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.b.a$a  reason: collision with other inner class name */
    public static final class C0905a {
        private C0905a() {
        }

        public /* synthetic */ C0905a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(201373);
        AppMethodBeat.o(201373);
    }
}
