package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.List;

public final class ad {
    public static String bnD(String str) {
        String escapeStringForXml;
        AppMethodBeat.i(38044);
        i Mx = p.aYB().Mx(str);
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(38044);
            return null;
        } else if (as.bjp(str)) {
            String format = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", Util.escapeStringForXml(Mx.aYt()), Util.escapeStringForXml(Mx.aYu()), Util.escapeStringForXml(Kn.field_username), Util.escapeStringForXml(Kn.arI()), Integer.valueOf(Kn.fuA), Kn.field_openImAppid, Util.escapeStringForXml(((a) g.af(a.class)).bN(Kn.field_openImAppid, Kn.field_descWordingId)), Util.escapeStringForXml(((a) g.af(a.class)).c(Kn.field_openImAppid, "openim_desc_icon", a.EnumC0497a.TYPE_URL)));
            AppMethodBeat.o(38044);
            return format;
        } else {
            int i2 = Kn.fuz;
            if (Mx != null) {
                i2 = Mx.fuz;
            }
            com.tencent.mm.api.c fJ = Kn.gBM() ? com.tencent.mm.al.g.fJ(Kn.field_username) : null;
            Object[] objArr = new Object[15];
            objArr[0] = Util.escapeStringForXml(Kn.field_username);
            objArr[1] = Util.escapeStringForXml(Kn.arI());
            objArr[2] = Util.escapeStringForXml(Kn.ajx());
            objArr[3] = Util.escapeStringForXml(Kn.arI());
            objArr[4] = Util.escapeStringForXml(Kn.ajz());
            objArr[5] = Integer.valueOf(i2);
            objArr[6] = Util.escapeStringForXml(Kn.getProvince());
            objArr[7] = Util.escapeStringForXml(Kn.getCity());
            objArr[8] = Util.escapeStringForXml(Kn.signature);
            objArr[9] = Integer.valueOf(Kn.fuI);
            objArr[10] = Integer.valueOf(Kn.fuA);
            objArr[11] = Integer.valueOf(Kn.field_verifyFlag);
            objArr[12] = Util.escapeStringForXml(Kn.fuN);
            if (fJ == null) {
                escapeStringForXml = "";
            } else {
                escapeStringForXml = Util.escapeStringForXml(fJ.field_brandIconURL);
            }
            objArr[13] = escapeStringForXml;
            objArr[14] = Util.escapeStringForXml(Kn.fuO);
            String format2 = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", objArr);
            AppMethodBeat.o(38044);
            return format2;
        }
    }

    public static void a(final Activity activity, String str, List<String> list) {
        int i2;
        AppMethodBeat.i(38045);
        for (String str2 : list) {
            String bnD = bnD(str2);
            o.e Pl = o.Pl(str);
            Pl.toUser = str;
            Pl.content = bnD;
            if (as.bjp(str2)) {
                i2 = 66;
            } else {
                i2 = 42;
            }
            o.e tD = Pl.tD(i2);
            tD.cSx = 0;
            tD.jdR = 4;
            tD.bdQ().execute();
        }
        b.r(activity, activity.getString(R.string.dzo));
        h.INSTANCE.a(11003, str, 3, Integer.valueOf(list.size()));
        activity.setResult(-1);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.contact.ad.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(38043);
                activity.finish();
                AppMethodBeat.o(38043);
            }
        }, 1800);
        AppMethodBeat.o(38045);
    }
}
