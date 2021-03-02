package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/sticker/task/GetLensInfoTaskImpl;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "plugin-sticker_release"})
public final class e extends d {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c NOn;
        final /* synthetic */ String rol;

        a(c cVar, String str) {
            this.NOn = cVar;
            this.rol = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            chz chz;
            AppMethodBeat.i(105984);
            c.a aVar = (c.a) obj;
            int i2 = aVar.errType;
            int i3 = aVar.errCode;
            Log.i(f.auD(), "GetLensInfo: " + i2 + ", " + i3 + ", " + aVar.errMsg);
            if (i2 == 0 && i3 == 0) {
                bpg bpg = (bpg) aVar.iLC;
                if (!(bpg == null || (chz = bpg.LXA) == null)) {
                    com.tencent.mm.sticker.a.a.NOa.e(chz);
                }
                c cVar = this.NOn;
                if (cVar != null) {
                    bpg bpg2 = (bpg) aVar.iLC;
                    cVar.a(0, bpg2 != null ? bpg2.LXA : null);
                    x xVar = x.SXb;
                    AppMethodBeat.o(105984);
                    return xVar;
                }
                AppMethodBeat.o(105984);
                return null;
            } else if (i2 == 4 && i3 == -436) {
                c cVar2 = this.NOn;
                if (cVar2 != null) {
                    cVar2.a(2, null);
                }
                com.tencent.mm.sticker.a.a.NOa.biA(this.rol);
                x xVar2 = x.SXb;
                AppMethodBeat.o(105984);
                return xVar2;
            } else {
                c cVar3 = this.NOn;
                if (cVar3 != null) {
                    cVar3.a(1, null);
                    x xVar3 = x.SXb;
                    AppMethodBeat.o(105984);
                    return xVar3;
                }
                AppMethodBeat.o(105984);
                return null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(b<com.tencent.mm.vending.e.a> bVar, String str, c cVar) {
        super(str);
        p.h(str, "lensId");
        AppMethodBeat.i(105985);
        Log.i(f.auD(), "GetLensInfoTaskImpl: ".concat(String.valueOf(str)));
        chz biy = com.tencent.mm.sticker.a.a.NOa.biy(str);
        if (com.tencent.mm.sticker.a.a.NOa.biz(str)) {
            if (cVar != null) {
                cVar.a(2, null);
                AppMethodBeat.o(105985);
                return;
            }
            AppMethodBeat.o(105985);
        } else if (biy == null) {
            f j2 = new a(str).aYH().aYI().j(new a(cVar, str));
            if (bVar != null) {
                j2.a(bVar);
            }
            AppMethodBeat.o(105985);
        } else if (cVar != null) {
            cVar.a(0, biy);
            AppMethodBeat.o(105985);
        } else {
            AppMethodBeat.o(105985);
        }
    }
}
