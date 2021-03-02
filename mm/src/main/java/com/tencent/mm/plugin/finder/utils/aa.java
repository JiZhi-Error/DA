package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ac;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.x;

public final class aa {
    private static int ufh;
    private static final HashMap<String, Integer> vXj = new HashMap<>();
    private static final HashMap<String, eoy> vYh = new HashMap<>();
    public static final aa vYi = new aa();

    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ af.a tpa;
        final /* synthetic */ af.a vXm;
        final /* synthetic */ String vYj;

        a(String str, af.a aVar, af.a aVar2) {
            this.vYj = str;
            this.tpa = aVar;
            this.vXm = aVar2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            aso aso;
            BaseResponse baseResponse;
            BaseResponse baseResponse2;
            AppMethodBeat.i(253729);
            c.a aVar = (c.a) obj;
            if ((aVar.errType == 0 && aVar.errCode == 0) || aVar.errCode == -5700 || aVar.errCode == -5701) {
                eoy eoy = new eoy();
                eoy.contact = ((bea) aVar.iLC).contact;
                eoy.LNG = ((bea) aVar.iLC).LNG;
                eoy.LCW = ((bea) aVar.iLC).LCW;
                eoy.LNI = ((bea) aVar.iLC).LNI;
                eoy.LNJ = ((bea) aVar.iLC).LNJ;
                aso aso2 = eoy.LNJ;
                if (!(((aso2 == null || (baseResponse2 = aso2.BaseResponse) == null) ? null : baseResponse2.ErrMsg) != null || (aso = eoy.LNJ) == null || (baseResponse = aso.BaseResponse) == null)) {
                    dqi dqi = new dqi();
                    dqi.bhy("");
                    baseResponse.ErrMsg = dqi;
                }
                aa aaVar = aa.vYi;
                aa.vYh.put(this.vYj, eoy);
                aa aaVar2 = aa.vYi;
                aa.IV(((bea) aVar.iLC).LNH);
                af.a aVar2 = this.tpa;
                if (aVar2 != null) {
                    aVar2.bn(eoy);
                }
            } else {
                af.a aVar3 = this.vXm;
                if (aVar3 != null) {
                    aVar3.bn(Integer.valueOf(aVar.errCode));
                }
            }
            if ((aVar.errType == 0 && aVar.errCode == 0) || aVar.errCode == -5700 || aVar.errCode == -5701) {
                aa aaVar3 = aa.vYi;
                aa.vXj.put(this.vYj, Integer.valueOf(cl.aWB()));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253729);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(253733);
        AppMethodBeat.o(253733);
    }

    private aa() {
    }

    public static void IV(int i2) {
        ufh = i2;
    }

    public static /* synthetic */ eoy b(String str, b bVar, af.a aVar, af.a aVar2) {
        AppMethodBeat.i(261491);
        eoy a2 = a(str, bVar, aVar, aVar2, false, 0);
        AppMethodBeat.o(261491);
        return a2;
    }

    public static eoy a(String str, b<com.tencent.mm.vending.e.a> bVar, af.a<Object> aVar, af.a<Integer> aVar2, boolean z, int i2) {
        Integer num;
        f aYI;
        AppMethodBeat.i(261490);
        if (str == null || Util.isNullOrNil(str)) {
            if (aVar2 != null) {
                aVar2.bn(-1000);
            }
            AppMethodBeat.o(261490);
            return null;
        }
        if (p.j(str, z.aTY())) {
            num = 0;
        } else {
            num = vXj.get(str);
            if (num == null) {
                num = 0;
            }
        }
        p.g(num, "if (wxUsername == Config…tTimeMap[wxUsername] ?: 0");
        int intValue = num.intValue();
        if (z) {
            intValue = 0;
        }
        if (cl.aWB() - intValue > ufh) {
            if (bVar != null) {
                aYI = new ac(str, i2).aYI().a(bVar);
            } else {
                aYI = new ac(str, i2).aYI();
            }
            aYI.g(new a(str, aVar, aVar2));
        }
        eoy eoy = vYh.get(str);
        AppMethodBeat.o(261490);
        return eoy;
    }

    public static void awv(String str) {
        AppMethodBeat.i(253731);
        if (str == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(253731);
            return;
        }
        vXj.put(str, 0);
        AppMethodBeat.o(253731);
    }

    public static void aww(String str) {
        AppMethodBeat.i(253732);
        p.h(str, "wxUsername");
        eoy eoy = vYh.get(str);
        if (eoy != null) {
            eoy.LNI = 0;
            AppMethodBeat.o(253732);
            return;
        }
        AppMethodBeat.o(253732);
    }
}
