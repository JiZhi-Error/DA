package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.emb;
import com.tencent.mm.protocal.protobuf.emc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b extends c<emc> {
    public static final a naq = new a((byte) 0);

    static {
        AppMethodBeat.i(50857);
        AppMethodBeat.o(50857);
    }

    private /* synthetic */ b(String str, int i2) {
        this(str, i2, null);
    }

    private b(String str, int i2, String str2) {
        AppMethodBeat.i(50856);
        d.a aVar = new d.a();
        emb emb = new emb();
        emb.uuid = str;
        emb.status = i2;
        emb.NkH = str2;
        aVar.c(emb);
        aVar.d(new emc());
        aVar.sG(2578);
        aVar.MB("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
        c(aVar.aXF());
        AppMethodBeat.o(50856);
    }

    private /* synthetic */ b(String str, String str2) {
        this(str, 5, str2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, emc emc, q qVar) {
        AppMethodBeat.i(50855);
        Log.i("MicroMsg.CgiUpdateRuntimeQrcode", "onCgiBack errType[" + i2 + "] errCode[" + i3 + "] errMsg[" + str + ']');
        AppMethodBeat.o(50855);
    }

    public static final b acs(String str) {
        AppMethodBeat.i(50858);
        p.h(str, "uuid");
        b bVar = new b(str, 4);
        AppMethodBeat.o(50858);
        return bVar;
    }

    public static final b act(String str) {
        AppMethodBeat.i(50859);
        p.h(str, "uuid");
        b bVar = new b(str, 1);
        AppMethodBeat.o(50859);
        return bVar;
    }

    public static final b em(String str, String str2) {
        AppMethodBeat.i(50860);
        p.h(str, "uuid");
        p.h(str2, "respData");
        b bVar = new b(str, str2);
        AppMethodBeat.o(50860);
        return bVar;
    }
}
