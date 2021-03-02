package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import org.json.JSONObject;

public final class o {
    public static final void a(bml bml) {
        AppMethodBeat.i(180523);
        p.h(bml, "$this$fillDevUinIfNeed");
        if (j.a.sE(bml.LVf.KXC)) {
            try {
                String bU = ((t) n.W(t.class)).bU(bml.LVf.dNI, bml.LVf.KXC);
                if (bU == null) {
                    bU = "";
                }
                bml.LVk = new com.tencent.mm.b.p(new JSONObject(bU).optLong("dev_key")).intValue();
                AppMethodBeat.o(180523);
                return;
            } catch (Throwable th) {
                Log.e("MicroMsg.AppBrand.CommonPkgFetcherUtils", "GetDownloadUrlReqItem.fillDevUin(" + bml.LVf.dNI + ", " + bml.LVf.KXC + "), throwable=" + th);
            }
        }
        AppMethodBeat.o(180523);
    }

    private static final int a(doo doo, Object obj) {
        boolean z;
        AppMethodBeat.i(180524);
        if (!(obj instanceof y.b)) {
            AppMethodBeat.o(180524);
            return -1;
        } else if (!p.j(doo.dNI, ((y.b) obj).appId) || doo.MbZ != ((y.b) obj).packageType || doo.KXC != ((y.b) obj).iOo) {
            AppMethodBeat.o(180524);
            return 1;
        } else if (p.j(Util.nullAsNil(doo.MbW), Util.nullAsNil(((y.b) obj).cBp))) {
            AppMethodBeat.o(180524);
            return 0;
        } else {
            String str = doo.MbW;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || !p.j(ModulePkgInfo.MAIN_MODULE_NAME, ((y.b) obj).cBp)) {
                AppMethodBeat.o(180524);
                return 1;
            }
            AppMethodBeat.o(180524);
            return 0;
        }
    }

    public static final /* synthetic */ bmm[] a(kn knVar, y.b bVar) {
        LinkedList<bmm> linkedList;
        AppMethodBeat.i(180525);
        p.h(bVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (((knVar == null || (linkedList = knVar.KOG) == null) ? -1 : linkedList.size()) <= 0) {
            AppMethodBeat.o(180525);
            return null;
        }
        bmm[] bmmArr = new bmm[3];
        if (knVar == null) {
            p.hyc();
        }
        Iterator<bmm> it = knVar.KOG.iterator();
        p.g(it, "this!!.resp_list.iterator()");
        while (it.hasNext()) {
            bmm next = it.next();
            if (next == null) {
                it.remove();
            } else {
                doo doo = next.LVf;
                p.g(doo, "item.req_package_info");
                if (a(doo, bVar) == 0) {
                    it.remove();
                    if (next.LVl) {
                        bmmArr[2] = next;
                    } else if (next.LVm) {
                        bmmArr[1] = next;
                    } else {
                        bmmArr[0] = next;
                    }
                }
            }
        }
        AppMethodBeat.o(180525);
        return bmmArr;
    }

    public static final /* synthetic */ x.d a(WxaAttributes.WxaPluginCodeInfo wxaPluginCodeInfo) {
        x.g.b bVar;
        AppMethodBeat.i(228647);
        p.h(wxaPluginCodeInfo, "$this$toRequestInfo");
        String str = wxaPluginCodeInfo.provider;
        p.g(str, "this.provider");
        if (wxaPluginCodeInfo.lgP) {
            bVar = new x.g.a(wxaPluginCodeInfo.version, false, 2);
        } else {
            bVar = new x.g.b(wxaPluginCodeInfo.version);
        }
        x.d dVar = new x.d(str, "", 6, 0, bVar, false);
        AppMethodBeat.o(228647);
        return dVar;
    }

    public static final <K, V> K e(Map.Entry<? extends K, ? extends V> entry) {
        AppMethodBeat.i(180526);
        p.h(entry, "$this$component1");
        K k = (K) entry.getKey();
        AppMethodBeat.o(180526);
        return k;
    }

    public static final <K, V> V f(Map.Entry<? extends K, ? extends V> entry) {
        AppMethodBeat.i(180527);
        p.h(entry, "$this$component2");
        V v = (V) entry.getValue();
        AppMethodBeat.o(180527);
        return v;
    }
}
