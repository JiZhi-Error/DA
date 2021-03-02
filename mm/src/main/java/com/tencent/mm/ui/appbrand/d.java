package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;

public final class d {
    h OMV;
    public String OMW = "";
    public String appId = "";
    Context context;
    com.tencent.mm.ui.widget.a.e kHi;
    public WxaExposedParams nVO = new WxaExposedParams.a().bAv();
    public boolean oDm;
    public int scene;
    public String username;

    public interface h {
        View gKl();

        void onCreateMMMenu(m mVar);

        void onMMMenuItemSelected(MenuItem menuItem, int i2);
    }

    public d(Context context2) {
        AppMethodBeat.i(33802);
        this.context = context2;
        AppMethodBeat.o(33802);
    }

    public final void show(int i2) {
        AppMethodBeat.i(33803);
        this.kHi = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
        switch (i2) {
            case 1:
                this.OMV = new a();
                break;
            case 2:
                this.OMV = new b();
                break;
            case 3:
                this.OMV = new f();
                break;
            case 4:
                this.OMV = new g();
                break;
            case 5:
                this.OMV = new C2077d();
                break;
            case 6:
                this.OMV = new e();
                break;
            default:
                AppMethodBeat.o(33803);
                return;
        }
        if (this.OMV == null) {
            Log.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
        } else {
            View gKl = this.OMV.gKl();
            if (gKl != null) {
                this.kHi.V(gKl, false);
            }
        }
        this.kHi.HLX = new o.f() {
            /* class com.tencent.mm.ui.appbrand.d.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(232754);
                if (d.this.OMV == null) {
                    Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
                    AppMethodBeat.o(232754);
                    return;
                }
                d.this.OMV.onCreateMMMenu(mVar);
                AppMethodBeat.o(232754);
            }
        };
        this.kHi.HLY = new o.g() {
            /* class com.tencent.mm.ui.appbrand.d.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(232753);
                if (d.this.OMV == null) {
                    Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
                    AppMethodBeat.o(232753);
                    return;
                }
                d.this.OMV.onMMMenuItemSelected(menuItem, i2);
                AppMethodBeat.o(232753);
            }
        };
        this.kHi.QNO = new e.a() {
            /* class com.tencent.mm.ui.appbrand.d.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.a.e.a
            public final void onClick() {
                AppMethodBeat.i(232752);
                d.this.kHi.bMo();
                AppMethodBeat.o(232752);
            }
        };
        this.kHi.dGm();
        AppMethodBeat.o(33803);
    }

    public class c implements h {
        public c() {
        }

        @Override // com.tencent.mm.ui.appbrand.d.h
        public View gKl() {
            return null;
        }

        @Override // com.tencent.mm.ui.appbrand.d.h
        public void onCreateMMMenu(m mVar) {
        }

        @Override // com.tencent.mm.ui.appbrand.d.h
        public void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String appId;
            boolean z = false;
            AppMethodBeat.i(33791);
            switch (menuItem.getItemId()) {
                case 2:
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.ui.appbrand.d.c.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(33789);
                            d.this.show(3);
                            AppMethodBeat.o(33789);
                        }
                    }, 100);
                    z = true;
                    break;
                case 3:
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.ui.appbrand.d.c.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(33790);
                            d.this.show(4);
                            AppMethodBeat.o(33790);
                        }
                    }, 100);
                    z = true;
                    break;
                case 4:
                    d.this.kHi.bMo();
                    z = true;
                    break;
                case 5:
                    if (!Util.isNullOrNil(d.this.username)) {
                        e.l(d.this.context, d.this.username, true);
                        if (!d.this.oDm) {
                            d.this.kR(d.this.scene, 4);
                            z = true;
                            break;
                        } else {
                            d.a(d.this, 6);
                            z = true;
                            break;
                        }
                    }
                    z = true;
                    break;
                case 6:
                    if (!Util.isNullOrNil(d.this.username)) {
                        e.l(d.this.context, d.this.username, false);
                        if (!d.this.oDm) {
                            d.this.kR(d.this.scene, 2);
                            z = true;
                            break;
                        } else {
                            d.a(d.this, 1);
                            z = true;
                            break;
                        }
                    }
                    z = true;
                    break;
                case 7:
                    d dVar = d.this;
                    Context context = d.this.context;
                    WxaExposedParams wxaExposedParams = d.this.nVO;
                    if (wxaExposedParams != null) {
                        Log.i("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams : %s", wxaExposedParams.toString());
                        if (!Util.isNullOrNil(wxaExposedParams.username)) {
                            Intent intent = new Intent();
                            intent.putExtra("key_username", wxaExposedParams.username);
                            intent.putExtra("key_from_scene", 4);
                            intent.putExtra("key_scene_exposed_params", wxaExposedParams);
                            com.tencent.mm.br.c.b(context, "appbrand", ".ui.AppBrandProfileUI", intent);
                            dVar.kR(dVar.scene, 1);
                        }
                        z = true;
                        break;
                    } else {
                        Log.e("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams is null");
                        z = true;
                        break;
                    }
                case 8:
                    d dVar2 = d.this;
                    Intent intent2 = new Intent();
                    String str = dVar2.nVO.appId;
                    String str2 = dVar2.nVO.pageId;
                    if (dVar2.nVO.appId == null || !dVar2.nVO.appId.equals(dVar2.getAppId())) {
                        appId = dVar2.getAppId();
                    } else {
                        appId = "";
                    }
                    WxaExposedParams.a aVar = new WxaExposedParams.a();
                    aVar.appId = str;
                    aVar.from = 10;
                    aVar.pageId = str2;
                    aVar.lhq = appId;
                    String a2 = w.a(aVar.bAv());
                    Log.v("MicroMsg.AppBrandServiceActionSheet", "KRawUrl ".concat(String.valueOf(a2)));
                    intent2.putExtra("rawUrl", a2);
                    intent2.putExtra("forceHideShare", true);
                    com.tencent.mm.br.c.b(dVar2.context, "webview", ".ui.tools.WebViewUI", intent2);
                    z = true;
                    break;
            }
            if (z) {
                d.this.kHi.bMo();
            }
            AppMethodBeat.o(33791);
        }
    }

    public class a extends c {
        public a() {
            super();
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(33785);
            super.onCreateMMMenu(mVar);
            mVar.d(2, d.this.context.getString(R.string.rd));
            mVar.d(8, d.this.context.getString(R.string.rb));
            mVar.d(7, d.a(d.this));
            AppMethodBeat.o(33785);
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(33786);
            super.onMMMenuItemSelected(menuItem, i2);
            AppMethodBeat.o(33786);
        }
    }

    public class b extends c {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(33787);
            super.onCreateMMMenu(mVar);
            mVar.d(3, d.this.context.getString(R.string.rf));
            mVar.d(8, d.this.context.getString(R.string.rb));
            mVar.d(7, d.a(d.this));
            AppMethodBeat.o(33787);
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(33788);
            super.onMMMenuItemSelected(menuItem, i2);
            AppMethodBeat.o(33788);
        }
    }

    public class f extends c {
        public f() {
            super();
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final View gKl() {
            AppMethodBeat.i(33796);
            View inflate = aa.jQ(d.this.context).inflate(R.layout.pw, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ti)).setText(d.this.context.getString(R.string.rc));
            AppMethodBeat.o(33796);
            return inflate;
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(33797);
            super.onCreateMMMenu(mVar);
            mVar.d(5, d.this.context.getString(R.string.nj));
            AppMethodBeat.o(33797);
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(33798);
            super.onMMMenuItemSelected(menuItem, i2);
            AppMethodBeat.o(33798);
        }
    }

    public class g extends c {
        public g() {
            super();
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final View gKl() {
            AppMethodBeat.i(33799);
            View inflate = aa.jQ(d.this.context).inflate(R.layout.pw, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ti)).setText(d.this.context.getString(R.string.re));
            AppMethodBeat.o(33799);
            return inflate;
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(33800);
            super.onCreateMMMenu(mVar);
            mVar.d(6, d.this.context.getString(R.string.nl));
            AppMethodBeat.o(33800);
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(33801);
            super.onMMMenuItemSelected(menuItem, i2);
            AppMethodBeat.o(33801);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.d$d  reason: collision with other inner class name */
    public class C2077d extends c {
        public C2077d() {
            super();
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(33792);
            super.onCreateMMMenu(mVar);
            mVar.d(2, d.this.context.getString(R.string.rd));
            mVar.d(8, d.this.context.getString(R.string.rb));
            mVar.d(7, d.a(d.this));
            AppMethodBeat.o(33792);
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(33793);
            super.onMMMenuItemSelected(menuItem, i2);
            AppMethodBeat.o(33793);
        }
    }

    public class e extends c {
        public e() {
            super();
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(33794);
            super.onCreateMMMenu(mVar);
            mVar.d(3, d.this.context.getString(R.string.rf));
            mVar.d(8, d.this.context.getString(R.string.rb));
            mVar.d(7, d.a(d.this));
            AppMethodBeat.o(33794);
        }

        @Override // com.tencent.mm.ui.appbrand.d.c, com.tencent.mm.ui.appbrand.d.h
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(33795);
            super.onMMMenuItemSelected(menuItem, i2);
            AppMethodBeat.o(33795);
        }
    }

    /* access modifiers changed from: package-private */
    public final String getAppId() {
        WxaAttributes Xk;
        AppMethodBeat.i(33804);
        if (Util.isNullOrNil(this.username)) {
            AppMethodBeat.o(33804);
            return null;
        }
        if (Util.isNullOrNil(this.appId) && (Xk = ((q) com.tencent.mm.kernel.g.af(q.class)).Xk(this.username)) != null) {
            this.appId = Xk.field_appId;
        }
        String str = this.appId;
        AppMethodBeat.o(33804);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void kR(int i2, int i3) {
        AppMethodBeat.i(33805);
        if (Util.isNullOrNil(getAppId())) {
            AppMethodBeat.o(33805);
            return;
        }
        Log.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", 13918, this.appId, Integer.valueOf(i2), this.OMW, Integer.valueOf(i3));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13918, getAppId(), Integer.valueOf(i2), this.OMW, Integer.valueOf(i3), Long.valueOf(Util.nowSecond()));
        AppMethodBeat.o(33805);
    }

    static /* synthetic */ void a(d dVar, int i2) {
        AppMethodBeat.i(33807);
        if (!Util.isNullOrNil(dVar.getAppId())) {
            Log.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", 13798, Integer.valueOf(i2), dVar.appId, dVar.OMW);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13798, Integer.valueOf(i2), dVar.getAppId(), 0, dVar.OMW, Long.valueOf(Util.nowSecond()));
        }
        AppMethodBeat.o(33807);
    }

    static /* synthetic */ String a(d dVar) {
        AppMethodBeat.i(33808);
        if (dVar.nVO == null) {
            AppMethodBeat.o(33808);
            return "";
        }
        if (Util.isNullOrNil(dVar.nVO.nickname)) {
            if (!Util.isNullOrNil(dVar.nVO.username)) {
                dVar.nVO.nickname = e.blY(dVar.nVO.username);
            }
            if (Util.isNullOrNil(dVar.nVO.nickname)) {
                dVar.nVO.nickname = "";
            }
        }
        String string = dVar.context.getString(R.string.hg, dVar.nVO.nickname);
        AppMethodBeat.o(33808);
        return string;
    }
}
