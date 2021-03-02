package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.lb;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.eka;
import org.xwalk.core.Log;

public final class b {
    private static int mPayChannel = 0;

    public static void a(Context context, eka eka) {
        AppMethodBeat.i(67658);
        Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
        Intent intent = new Intent();
        intent.putExtra("key_rcvr_openid", eka.Njb);
        intent.putExtra("key_rcvr_token", eka.Njc);
        intent.putExtra("key_wx_name", eka.ClU);
        intent.putExtra("key_real_name", eka.ClV);
        intent.putExtra("key_phone", eka.pSm);
        intent.putExtra("key_img_url", eka.KRv);
        intent.putExtra("key_amount_remind_bit", eka.CpN);
        intent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.bm(eka.Njm));
        intent.putExtra("key_check_name_wording", eka.Njn);
        intent.putExtra("key_check_name_mask", eka.Njo);
        intent.putExtra("key_get_rcvr_ext", eka.Njd);
        intent.putExtra("key_timestamp_ms", eka.Njp);
        c.b(context, "remittance", ".mobile.ui.MobileRemittanceUI", intent);
        AppMethodBeat.o(67658);
    }

    public static void VY(int i2) {
        AppMethodBeat.i(67659);
        lb lbVar = new lb();
        lbVar.erW = (long) i2;
        lbVar.bfK();
        AppMethodBeat.o(67659);
    }

    public static void VZ(int i2) {
        switch (i2) {
            case 1:
                mPayChannel = 1;
                return;
            case 2:
                mPayChannel = 21;
                return;
            default:
                mPayChannel = 0;
                return;
        }
    }

    public static int eNt() {
        return mPayChannel;
    }
}
