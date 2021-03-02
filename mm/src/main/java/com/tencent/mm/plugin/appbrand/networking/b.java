package com.tencent.mm.plugin.appbrand.networking;

import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.g.b.a.mb;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0016J\u0016\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0018\u00010\u000eH\u0016J9\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "appId", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "startElapsedTime", "", "startTimestamp", "call", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "run", "plugin-appbrand-integration_release"})
public class b<T extends dpc> extends c<T> {
    final String appId;
    final long njx;
    final long njy;
    final String userName;

    public b(byte b2) {
        this();
    }

    private /* synthetic */ b() {
        this(null, null);
    }

    public b(String str, String str2) {
        AppMethodBeat.i(229066);
        this.appId = str;
        this.userName = str2;
        this.njx = System.currentTimeMillis();
        this.njy = SystemClock.elapsedRealtime();
        AppMethodBeat.o(229066);
    }

    public c.a<T> bNV() {
        AppMethodBeat.i(229063);
        c.a<T> a2 = ab.a(this);
        AppMethodBeat.o(229063);
        return a2;
    }

    @Override // com.tencent.mm.ak.c
    public void a(int i2, int i3, String str, T t, q qVar) {
        AppMethodBeat.i(229064);
        super.a(i2, i3, str, t, qVar);
        if (qVar != null) {
            h.RTc.aX(new a(this, t, i3, qVar));
        }
        AppMethodBeat.o(229064);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "run"})
    static final class a implements Runnable {
        final /* synthetic */ int $errCode;
        final /* synthetic */ q hvN;
        final /* synthetic */ dpc njA;
        final /* synthetic */ b njz;

        a(b bVar, dpc dpc, int i2, q qVar) {
            this.njz = bVar;
            this.njA = dpc;
            this.$errCode = i2;
            this.hvN = qVar;
        }

        public final void run() {
            String str;
            String str2;
            BaseResponse baseResponse;
            AppMethodBeat.i(229062);
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.njz.njy;
            mb mbVar = new mb();
            mbVar.vB(this.njz.njx);
            mbVar.vC(currentTimeMillis);
            mbVar.vD(elapsedRealtime);
            mbVar.zo(i.getNetworkType(MMApplicationContext.getContext()));
            dpc dpc = this.njA;
            mbVar.vE(dpc != null ? (long) dpc.computeSize() : -1);
            mbVar.mn(this.$errCode);
            dpc dpc2 = this.njA;
            mbVar.mo((dpc2 == null || (baseResponse = dpc2.BaseResponse) == null) ? Integer.MIN_VALUE : baseResponse.Ret);
            mbVar.mp(this.hvN.getType());
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            String str3 = this.njz.appId;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.njz.userName;
            if (str4 == null) {
                str4 = "";
            }
            p.h(mbVar, "weAppQualityCGISpeedStruct");
            try {
                QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(str3);
                str = aeU != null ? aeU.kEY : null;
            } catch (IllegalStateException e2) {
                str = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            mbVar.zm(str3);
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            mbVar.zl(str2);
            if (str4 == null) {
                str4 = "";
            }
            mbVar.zn(str4);
            mbVar.bfK();
            AppMethodBeat.o(229062);
        }
    }

    @Override // com.tencent.mm.ak.c
    public f<c.a<T>> aYI() {
        AppMethodBeat.i(229065);
        f<c.a<T>> bAe = bAe();
        if (bAe != null) {
            AppMethodBeat.o(229065);
            return bAe;
        }
        f<c.a<T>> aYI = super.aYI();
        p.g(aYI, "super.run()");
        AppMethodBeat.o(229065);
        return aYI;
    }

    public f<c.a<T>> bAe() {
        return null;
    }
}
