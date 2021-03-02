package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Util;

public final class i implements ad {
    @Override // com.tencent.mm.plugin.fav.a.ad
    public final boolean a(cz czVar, Intent intent) {
        AppMethodBeat.i(30965);
        boolean a2 = h.a(czVar, intent);
        AppMethodBeat.o(30965);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.ad
    public final boolean a(cz czVar, String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(232143);
        boolean a2 = h.a(czVar, 6, str, str2, i2, str3, str4, true);
        AppMethodBeat.o(232143);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.ad
    public final boolean a(cz czVar, int i2, String str, String str2, String str3) {
        AppMethodBeat.i(232144);
        boolean a2 = h.a(czVar, i2, str, str2, str3, true);
        AppMethodBeat.o(232144);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.ad
    public final boolean a(cz czVar, int i2, String str) {
        AppMethodBeat.i(30966);
        boolean a2 = h.a(czVar, i2, str);
        AppMethodBeat.o(30966);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.ad
    public final boolean a(cz czVar, long j2) {
        AppMethodBeat.i(30967);
        boolean a2 = h.a(czVar, j2);
        AppMethodBeat.o(30967);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.ad
    public final boolean a(cz czVar, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        AppMethodBeat.i(30964);
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        aml.ajd(5);
        aml.bgu(str7);
        aml.bgl(str3);
        aml.ajc(i2);
        aml.bgf(str);
        aml.bgg(str2);
        aml.bgD(str11);
        amo amo = new amo();
        amo.izb = str;
        amo.LxJ = i2;
        amo.iyZ = str3;
        amo.izd = str5;
        amo.izc = str4;
        amo.ize = str6;
        amo.izf = str9;
        amo.izg = str10;
        aml.a(amo);
        anh.bhf(str8);
        anh.bhg(z.aTY());
        anh.ajm(0);
        anh.MA(Util.nowMilliSecond());
        anb.a(anh);
        anb.ppH.add(aml);
        czVar.dFZ.title = aml.title;
        czVar.dFZ.desc = aml.title;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 4;
        AppMethodBeat.o(30964);
        return true;
    }

    @Override // com.tencent.mm.plugin.fav.a.ad
    public final boolean a(cz czVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(30968);
        String format = String.format("%s#%s", str, "");
        anb anb = new anb();
        anh anh = new anh();
        anh.bhf(str2);
        anh.ajm(2);
        anh.MA(System.currentTimeMillis());
        anh.bhk(String.valueOf(str));
        anh.bhh(format);
        aml aml = new aml();
        aml.bgx(format);
        aml.At(true);
        aml.ajd(5);
        aml.bgf(str3);
        aml.bgg(str4);
        aml.bgE(str5);
        aml.As(true);
        anb.ppH.add(aml);
        anq anq = new anq();
        anq.bhv(str6);
        anq.bhu(str7);
        anb.b(anq);
        anb.a(anh);
        czVar.dFZ.dGb = anb;
        czVar.dFZ.desc = str3;
        czVar.dFZ.type = 5;
        AppMethodBeat.o(30968);
        return true;
    }
}
