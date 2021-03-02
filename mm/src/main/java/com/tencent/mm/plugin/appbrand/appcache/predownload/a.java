package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.protocal.protobuf.byy;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiAdGetPkgCDNDownloadURL;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;)V", "TAG", "", "plugin-appbrand-integration_release"})
public final class a extends h {
    private final String TAG = "MicroMsg.AppBrand.CgiAdGetPkgCDNDownloadURL";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(byy byy) {
        super(byy, 1996, "/cgi-bin/mmbiz-bin/wxaapp/getadwxacdndownloadurl");
        p.h(byy, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        AppMethodBeat.i(50183);
        AppMethodBeat.o(50183);
    }
}
