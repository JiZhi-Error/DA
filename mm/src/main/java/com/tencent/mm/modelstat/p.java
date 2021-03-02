package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ca;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p {

    public enum a {
        Chat(1),
        TalkChat(2),
        Sns(3);
        
        public int value = 0;

        public static a valueOf(String str) {
            AppMethodBeat.i(94875);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(94875);
            return aVar;
        }

        static {
            AppMethodBeat.i(94876);
            AppMethodBeat.o(94876);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public static void a(String str, m mVar) {
        AppMethodBeat.i(94877);
        if (mVar == null) {
            AppMethodBeat.o(94877);
            return;
        }
        b(str, mVar);
        AppMethodBeat.o(94877);
    }

    public static void b(String str, m mVar) {
        AppMethodBeat.i(94878);
        if (Util.isNullOrNil(str) || mVar == null) {
            AppMethodBeat.o(94878);
            return;
        }
        ecp PU = PU(str);
        mVar.n("Source", (PU == null ? -1 : PU.source) + ",");
        mVar.n("SnsStatExt", a(PU));
        AppMethodBeat.o(94878);
    }

    public static void a(String str, StringBuilder sb) {
        AppMethodBeat.i(94879);
        if (sb == null) {
            AppMethodBeat.o(94879);
            return;
        }
        ecp PU = PU(str);
        sb.append(",").append(PU == null ? -1 : PU.source);
        sb.append(",").append(a(PU));
        AppMethodBeat.o(94879);
    }

    public static ecp PU(String str) {
        AppMethodBeat.i(94880);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(94880);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        eco eco = new eco();
        try {
            eco.parseFrom(decode);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsStatExtUtil", "", e2);
        }
        ecp ecp = eco.NcH;
        AppMethodBeat.o(94880);
        return ecp;
    }

    public static String a(String str, PString pString) {
        AppMethodBeat.i(94881);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(94881);
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        eco eco = new eco();
        try {
            eco.parseFrom(decode);
            String format = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", URLEncoder.encode(eco.NcH.KxO, MimeTypeUtil.ContentType.DEFAULT_CHARSET), URLEncoder.encode(eco.NcH.NcK, MimeTypeUtil.ContentType.DEFAULT_CHARSET), Integer.valueOf(eco.NcH.source), URLEncoder.encode(a(eco.NcH), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            pString.value = eco.NcJ == null ? "" : eco.NcJ.xEN;
            AppMethodBeat.o(94881);
            return format;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
            AppMethodBeat.o(94881);
            return "";
        }
    }

    public static String a(ecp ecp) {
        String[] split;
        AppMethodBeat.i(94882);
        if (ecp != null) {
            String str = ecp.KxO;
            String str2 = "";
            if (!Util.isNullOrNil(str) && (split = str.split("\\|")) != null && split.length > 0) {
                str2 = split[0];
            }
            try {
                String format = String.format("expId=%d&adgroup_id=%s&snsId=%s", Integer.valueOf(ecp.NcL), URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET), ecp.NcK);
                AppMethodBeat.o(94882);
                return format;
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.SnsStatExtUtil", "", e2);
            }
        }
        AppMethodBeat.o(94882);
        return "";
    }

    public static String ag(ca caVar) {
        AppMethodBeat.i(94883);
        if (caVar == null) {
            AppMethodBeat.o(94883);
            return "";
        }
        String str = null;
        if (caVar.dOQ()) {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null || Util.isNullOrNil(HD.ean)) {
                AppMethodBeat.o(94883);
                return "";
            }
            str = HD.ean;
        }
        if (caVar.cWL()) {
            s QN = u.QN(caVar.field_imgPath);
            if (QN == null || Util.isNullOrNil(QN.ean)) {
                AppMethodBeat.o(94883);
                return "";
            }
            str = QN.ean;
        }
        AppMethodBeat.o(94883);
        return str;
    }
}
