package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.launching.c.h;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a {
    /* access modifiers changed from: package-private */
    public abstract void a(String str, Uri uri, EnumC0736a aVar);

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.c.a$a  reason: collision with other inner class name */
    public enum EnumC0736a {
        OK,
        ERR_URL_INVALID,
        ERR_UIN_INVALID,
        ERR_DEV_CODE_EXPIRED;

        public static EnumC0736a valueOf(String str) {
            AppMethodBeat.i(47405);
            EnumC0736a aVar = (EnumC0736a) Enum.valueOf(EnumC0736a.class, str);
            AppMethodBeat.o(47405);
            return aVar;
        }

        static {
            AppMethodBeat.i(47406);
            AppMethodBeat.o(47406);
        }
    }

    public final EnumC0736a a(final Context context, final String str, final int i2, final Bundle bundle, final Bundle bundle2) {
        boolean z;
        EnumC0736a aVar;
        Log.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", str);
        Uri uri = null;
        if (Util.isNullOrNil(str)) {
            aVar = EnumC0736a.ERR_URL_INVALID;
        } else {
            int indexOf = str.indexOf(35);
            int indexOf2 = str.indexOf(63);
            if (indexOf > 0 && indexOf2 > 0 && indexOf < indexOf2) {
                str = str.substring(0, indexOf) + str.substring(indexOf2, str.length());
                Log.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", str);
            }
            final Uri parse = Uri.parse(str);
            if (Util.getInt(parse.getQueryParameter("debug"), 0) > 0) {
                int i3 = Util.getInt(parse.getQueryParameter("ret"), 0);
                if (i3 == 1) {
                    aVar = EnumC0736a.ERR_UIN_INVALID;
                    uri = parse;
                } else if (i3 == 2) {
                    aVar = EnumC0736a.ERR_DEV_CODE_EXPIRED;
                    uri = parse;
                } else {
                    String queryParameter = parse.getQueryParameter("appid");
                    String queryParameter2 = parse.getQueryParameter(ch.COL_USERNAME);
                    String nullAsNil = Util.nullAsNil(parse.getQueryParameter("path"));
                    String queryParameter3 = parse.getQueryParameter("codeurl");
                    String queryParameter4 = parse.getQueryParameter("md5");
                    String queryParameter5 = parse.getQueryParameter("pageurl");
                    String queryParameter6 = parse.getQueryParameter("pagemd5");
                    long j2 = Util.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (Util.isNullOrNil(queryParameter) || Util.isNullOrNil(queryParameter2) || Util.isNullOrNil(queryParameter3)) {
                        Log.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", queryParameter, queryParameter2, queryParameter3);
                        aVar = EnumC0736a.ERR_URL_INVALID;
                        uri = parse;
                    } else {
                        boolean a2 = n.buL().a(queryParameter, 1, queryParameter3, queryParameter4, 0, Util.nowSecond() + j2);
                        if (!Util.isNullOrNil(queryParameter5) && !Util.isNullOrNil(queryParameter6)) {
                            n.buL().a(queryParameter, 10000, queryParameter5, queryParameter6, 0, Util.nowSecond() + j2);
                            int dV = b.dV(0, 1);
                            if (dV == 10000) {
                                Bundle bundle3 = new Bundle();
                                bundle3.putString("appId", queryParameter);
                                bundle3.putInt("debugType", dV);
                                h.a(MainProcessIPCService.dkO, bundle3, a.d.class, null);
                            }
                        }
                        if (a2) {
                            d.cd(queryParameter, 1);
                            com.tencent.mm.plugin.appbrand.task.h.bWb().cl(queryParameter, 1);
                            ((com.tencent.mm.plugin.appbrand.ui.c.a.b) n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).ct(queryParameter, 1);
                        }
                        String queryParameter7 = parse.getQueryParameter("json_extinfo");
                        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
                        launchParamsOptional.iIt = queryParameter7;
                        ((t) n.W(t.class)).A(queryParameter, 1, queryParameter7);
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        a(str, i2, appBrandStatObject, bundle, bundle2);
                        AppBrandLaunchProxyUI.a(context, queryParameter2, nullAsNil, 1, -1, appBrandStatObject, launchParamsOptional);
                    }
                }
            } else {
                final String queryParameter8 = parse.getQueryParameter(ch.COL_USERNAME);
                if (Util.isNullOrNil(queryParameter8)) {
                    Log.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", queryParameter8);
                    aVar = EnumC0736a.ERR_URL_INVALID;
                    uri = parse;
                } else {
                    final String string = bundle != null ? bundle.getString("stat_app_id") : null;
                    if (Util.isNullOrNil(string)) {
                        a(context, str, parse, i2, bundle, queryParameter8, bundle2);
                    } else {
                        AnonymousClass1 r6 = new h.a() {
                            /* class com.tencent.mm.plugin.appbrand.launching.c.a.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.launching.c.h.a
                            public final void bNY() {
                                AppMethodBeat.i(47402);
                                Log.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", string, queryParameter8);
                                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.launching.c.a.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(47401);
                                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.jb, 1).show();
                                        AppMethodBeat.o(47401);
                                    }
                                });
                                AppMethodBeat.o(47402);
                            }

                            @Override // com.tencent.mm.plugin.appbrand.launching.c.h.a
                            public final void bNZ() {
                                AppMethodBeat.i(47403);
                                Log.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", string, queryParameter8);
                                a.a(context, str, parse, i2, bundle, queryParameter8, bundle2);
                                AppMethodBeat.o(47403);
                            }
                        };
                        ap apVar = new ap();
                        apVar.field_appId = string;
                        ao buD = n.buD();
                        if (buD == null) {
                            Log.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
                            h.a(r6);
                        } else {
                            if (buD.a(apVar, "appId")) {
                                if (apVar.acg("banJumpApp") || apVar.acg("banJumpGame")) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    ((q) g.af(q.class)).a(queryParameter8, new q.a(r6, apVar) {
                                        /* class com.tencent.mm.plugin.appbrand.launching.c.h.AnonymousClass1 */
                                        final /* synthetic */ a mYx;
                                        final /* synthetic */ ap mYy;

                                        {
                                            this.mYx = r1;
                                            this.mYy = r2;
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.service.q.a
                                        public final void b(WxaAttributes wxaAttributes) {
                                            AppMethodBeat.i(47419);
                                            if (wxaAttributes == null) {
                                                Log.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, get contact info fail");
                                                h.a(this.mYx);
                                                AppMethodBeat.o(47419);
                                                return;
                                            }
                                            boolean NA = wxaAttributes.bAn().NA();
                                            if ((!this.mYy.acg("banJumpGame") || !NA) && (!this.mYy.acg("banJumpApp") || NA)) {
                                                Log.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no need to ban jump");
                                                h.a(this.mYx);
                                                AppMethodBeat.o(47419);
                                                return;
                                            }
                                            Log.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, return should ban jump");
                                            a aVar = this.mYx;
                                            if (aVar != null) {
                                                aVar.bNY();
                                            }
                                            AppMethodBeat.o(47419);
                                        }
                                    });
                                }
                            }
                            Log.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", string);
                            h.a(r6);
                        }
                    }
                }
            }
            aVar = EnumC0736a.OK;
            uri = parse;
        }
        a(str, uri, aVar);
        return aVar;
    }

    static void a(Context context, String str, Uri uri, int i2, Bundle bundle, String str2, Bundle bundle2) {
        String nullAsNil = Util.nullAsNil(uri.getQueryParameter("path"));
        int i3 = Util.getInt(uri.getQueryParameter("version"), 0);
        int i4 = Util.getInt(uri.getQueryParameter("type"), 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        a(str, i2, appBrandStatObject, bundle, bundle2);
        AppBrandLaunchProxyUI.a(context, str2, nullAsNil, i4, i3, appBrandStatObject, null);
    }

    private static void a(String str, int i2, AppBrandStatObject appBrandStatObject, Bundle bundle, Bundle bundle2) {
        appBrandStatObject.scene = i2;
        appBrandStatObject.dCw = com.tencent.mm.compatible.util.q.encode(str);
        appBrandStatObject.ecU = m.k(i2, bundle);
        appBrandStatObject.ecV = m.l(i2, bundle);
        if (bundle2 != null) {
            appBrandStatObject.nHw = bundle2.getBundle("stat_get_a8_key_cgi_speed");
        }
        if (i2 == 1037 || i2 == 1018) {
            appBrandStatObject.ecS = 0;
        } else {
            appBrandStatObject.ecS = i2;
        }
    }
}
