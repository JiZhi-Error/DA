package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\r¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "scene", "(Ljava/lang/String;JDDII)V", "Companion", "plugin-card_release"})
public final class f extends j<bko> {
    private static final String TAG = TAG;
    public static final a pVt = new a((byte) 0);

    public /* synthetic */ f(String str, long j2, double d2, double d3, int i2) {
        this(str, j2, d2, d3, i2, 0);
        AppMethodBeat.i(112393);
        AppMethodBeat.o(112393);
    }

    public f(String str, long j2, double d2, double d3, int i2, int i3) {
        p.h(str, "marchantId");
        AppMethodBeat.i(201371);
        bkn bkn = new bkn();
        bko bko = new bko();
        bkn.Ldn = str;
        bkn.LdA = j2;
        bkn.latitude = d2;
        bkn.longitude = d3;
        bkn.Leq = i2;
        bkn.scene = i3;
        a(bkn, bko, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
        Log.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", str, Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3));
        AppMethodBeat.o(201371);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(112394);
        AppMethodBeat.o(112394);
    }
}
