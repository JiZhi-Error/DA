package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static boolean a(cz czVar, bv bvVar) {
        AppMethodBeat.i(102661);
        if (czVar == null || bvVar == null) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(102661);
            return false;
        }
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        anh.bhf("newsapp");
        anh.bhg(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(1);
        anh.MA(bvVar.iFn);
        anh.bhj(new StringBuilder().append(bvVar.iFs).toString());
        anh.bhm(bvVar.getUrl());
        anh.bhn("newsapp");
        aml.bgl(bvVar.getUrl());
        aml.bgf(bvVar.getTitle());
        aml.bgg(bvVar.getDigest());
        aml.bgo(bvVar.aWd());
        aml.As(true);
        aml.At(true);
        aml.ajd(5);
        anb.a(anh);
        anb.ppH.add(aml);
        czVar.dFZ.desc = bvVar.getTitle();
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 5;
        AppMethodBeat.o(102661);
        return true;
    }
}
