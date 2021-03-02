package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class c {
    public static final String KxC = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms");
    public static final String[] KxD = {"/cgi-bin/mmpay-bin/cancelqrpay", "/cgi-bin/mmpay-bin/tenpay/elementquerynew", "/cgi-bin/mmpay-bin/tenpay/payorderquery", "/cgi-bin/mmpay-bin/tenpay/datareport", "/cgi-bin/mmpay-bin/tenpay/offlinecreate", "/cgi-bin/mmpay-bin/tenpay/offlinegettoken", "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser", "/cgi-bin/mmpay-bin/tenpay/queryuserwallet", "/cgi-bin/mmpay-bin/tenpay/unbindbanner", "/cgi-bin/mmpay-bin/tenpay/unbind", "/cgi-bin/mmpay-bin/tenpay/bindquerynew", "/cgi-bin/mmpay-bin/tenpay/getbannerinfo", "/cgi-bin/mmpay-bin/tenpay/paymanage", "/cgi-bin/mmpay-bin/tenpay/timeseed", "/cgi-bin/micromsg-bin/paydeluserroll", "/cgi-bin/mmpay-bin/getrealnamewording", "/cgi-bin/mmpay-bin/bankresource", "/cgi-bin/mmpay-bin/tenpay/sns_aa_payorderquery", "/cgi-bin/mmpay-bin/tenpay/sns_payorderquery", "/cgi-bin/mmpay-bin/tenpay/sns_tf_payorderquery", "/cgi-bin/mmpay-bin/tenpay/sns_ff_payorderquery", "/cgi-bin/mmpay-bin/tenpay/ts_payorderquery", "/cgi-bin/mmpay-bin/tenpay/payorderquery"};

    static {
        AppMethodBeat.i(204068);
        AppMethodBeat.o(204068);
    }
}
