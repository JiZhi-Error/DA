package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c {

    public static final class a {
        public amt IXu;
        public String dNI;
        public String desc;
        public String ean;
        public String thumbUrl;
        public String title;
        public String url;

        public final boolean valid() {
            AppMethodBeat.i(78836);
            if (!Util.isNullOrNil(this.url)) {
                AppMethodBeat.o(78836);
                return true;
            }
            AppMethodBeat.o(78836);
            return false;
        }
    }

    public static boolean a(cz czVar, a aVar) {
        AppMethodBeat.i(78837);
        if (!aVar.valid()) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
            czVar.dFZ.dGe = R.string.c_2;
            AppMethodBeat.o(78837);
            return false;
        }
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        aml.bgl(aVar.url);
        aml.bgf(aVar.title);
        aml.bgg(aVar.desc);
        aml.bgo(aVar.thumbUrl);
        aml.bgD(aVar.ean);
        aml.As(true);
        aml.At(true);
        aml.ajd(5);
        anq anq = new anq();
        anq.bhv(aVar.thumbUrl);
        anq.bhs(aVar.title);
        anq.bht(aVar.desc);
        anb.b(anq);
        anb.f(aVar.IXu);
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(3);
        anh.MA(Util.nowMilliSecond());
        anh.bhl(aVar.dNI);
        anh.bhm(aVar.url);
        czVar.dFZ.title = aml.title;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 5;
        anb.a(anh);
        anb.ppH.add(aml);
        AppMethodBeat.o(78837);
        return true;
    }

    public static boolean a(cz czVar, jo joVar) {
        AppMethodBeat.i(210971);
        if (joVar == null) {
            Log.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
            AppMethodBeat.o(210971);
            return false;
        }
        anb anb = new anb();
        anh anh = new anh();
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(4);
        anh.MA(Util.nowMilliSecond());
        anh.bhm(joVar.url);
        anb.a(anh);
        aml aml = new aml();
        aml.bgt("");
        aml.bgo(joVar.iAo);
        aml.bgx(MD5Util.getMD5String(joVar.KOf + joVar.KOe));
        aml.ajc(joVar.videoDuration);
        aml.bgf(joVar.title);
        aml.bgl(joVar.url);
        aml.As(true);
        aml.At(true);
        amt amt = new amt();
        amt.vid = joVar.KOf;
        amt.videoUrl = joVar.videoUrl;
        amt.KOe = joVar.KOe;
        amt.dHc = joVar.dHc;
        amt.iAg = joVar.iAg;
        amt.iAo = joVar.iAo;
        amt.videoWidth = joVar.width;
        amt.videoHeight = joVar.height;
        amt.duration = joVar.videoDuration;
        amm amm = new amm();
        amm.e(amt);
        aml.a(amm);
        LinkedList<aml> linkedList = new LinkedList<>();
        linkedList.add(aml);
        anb.bH(linkedList);
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 4;
        aml.ajd(4);
        AppMethodBeat.o(210971);
        return true;
    }
}
