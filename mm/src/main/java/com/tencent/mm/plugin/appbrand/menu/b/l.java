package com.tencent.mm.plugin.appbrand.menu.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import com.eclipsesource.v8.V8;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.a.h;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.menu.v;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.p.g;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class l implements b<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    @SuppressLint({"DefaultLocale", "RtlHardcoded"})
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        AppMethodBeat.i(47702);
        ag agVar2 = agVar;
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        StringBuilder sb = new StringBuilder("!PKG_INFO!\n");
        IPkgInfo bve = agVar2.bqZ().bve();
        sb.append("\n[lib.src    ] ");
        if (agVar2.bqZ() instanceof AssetReader) {
            sb.append(ay.bwe() ? "local(force)" : ImagesContract.LOCAL);
        } else {
            sb.append(TencentLocation.NETWORK_PROVIDER);
        }
        sb.append("\n[lib.ver_cli] ").append(bve.pkgVersion());
        sb.append("\n[lib.ver_sdk] ").append(agVar2.bqZ().bvc());
        long lastModified = bve.lastModified();
        if (lastModified > 0) {
            sb.append("  ").append(Util.formatUnixTime(TimeUnit.MILLISECONDS.toSeconds(lastModified)));
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = bsB.leE;
        sb.append('\n');
        sb.append("\n[app.version] ").append(wxaPkgWrappingInfo.pkgVersion);
        if (bsB.leE.kNW != 0) {
            sb.append("  ").append(Util.formatUnixTime(wxaPkgWrappingInfo.kNX));
        }
        boolean z = !Util.isNullOrNil(wxaPkgWrappingInfo.kNZ);
        sb.append("\n[app.module ] ").append(String.valueOf(z));
        if (z) {
            ModulePkgInfo acO = ((g) agVar2.getRuntime().kAI).acO(agVar2.lBI);
            sb.append(String.format(Locale.US, "(%s)", acO.name));
            if (acO.independent) {
                sb.append("(independent)");
            }
        }
        if (!AppBrandRuntimeWCAccessible.d(agVar2)) {
            sb.append("\n[app.page.url] ").append(agVar2.lBI);
            sb.append("\n[app.lazy_code_loading] ").append(((aa) agVar2.av(aa.class)).bRa());
            sb.append("\n[app.separated_plugins] ").append(wxaPkgWrappingInfo.kOb != null && !wxaPkgWrappingInfo.kOb.isEmpty());
            sb.append("\n[app.pkg_reader_impl] ").append(bn.O(agVar2.getRuntime()) != null ? "MERGE" : "LEGACY");
            WxaPkg UT = bg.M(agVar2.getRuntime()).UT(agVar2.lBI);
            if (UT != null) {
                sb.append("\n[app.pkg_enc_version] ").append(UT.version());
            } else {
                Log.w("MicroMsg.SecondaryMenuDelegate_ShowPkgInfo", "performItemClick try append pkg_enc_version but get NULL pkg with url:%s", agVar2.lBI);
            }
        } else {
            sb.append("\n[app.separated_plugins] ").append(wxaPkgWrappingInfo.kOb != null && !wxaPkgWrappingInfo.kOb.isEmpty());
            sb.append("\n[app.pkg_reader_impl] ").append(bn.O(agVar2.getRuntime()) != null ? "MERGE" : "LEGACY");
            if (s.YS(wxaPkgWrappingInfo.pkgPath)) {
                sb.append("\n[app.pkg_enc_version] ").append(WxaPkg.Vg(wxaPkgWrappingInfo.pkgPath));
            }
        }
        sb.append('\n');
        sb.append("\n[js_runtime] ").append(e.e(agVar2.bsE().getJsRuntime()));
        sb.append("\n[v8.version] ").append(V8.getV8Version());
        if (!AppBrandRuntimeWCAccessible.d(agVar2)) {
            sb.append("\n[webview] ").append(o.bUx());
            sb.append("\n[webview.version] ").append(agVar2.bRI().getVersionInfo());
            sb.append('\n');
            sb.append("\n[nTrans.webview] ").append(com.tencent.mm.plugin.appbrand.m.aa.f(agVar2));
            sb.append("\n[nTrans.service] ").append(com.tencent.mm.plugin.appbrand.m.aa.q(agVar2.bsE()));
            sb.append('\n');
        }
        sb.append("\n[is_use_nativebuffer] ").append((String) h.lrE.aLT());
        v vVar = v.nfC;
        v.a(sb, agVar2.bsE());
        sb.append("\n[isolate_context] ").append(agVar2.bsE().cBj.Mj());
        TextView textView = new TextView(context);
        textView.setText(sb);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(context.getResources().getColor(R.color.a2x));
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        com.tencent.mm.ui.base.h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null).setCanceledOnTouchOutside(false);
        AppMethodBeat.o(47702);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        AppMethodBeat.i(47703);
        String string = context.getString(R.string.rq);
        AppMethodBeat.o(47703);
        return string;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(47704);
        if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || p.Un(str).kDe) {
            AppMethodBeat.o(47704);
            return true;
        }
        AppMethodBeat.o(47704);
        return false;
    }
}
