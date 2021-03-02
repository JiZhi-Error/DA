package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.Arrays;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.ae;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "Lcom/tencent/mm/plugin/appbrand/util/UserAgentUtil$Info;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "version", "", "identity", "Companion", "webview-sdk_release"})
public final class e implements p.a {
    public static final a JBw = new a((byte) 0);
    private static final f iBW = g.ah(b.JBx);
    private final Context mContext;
    private String version = "";

    public e(Context context) {
        kotlin.g.b.p.h(context, "mContext");
        AppMethodBeat.i(225171);
        this.mContext = context;
        AppMethodBeat.o(225171);
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.p.a
    public final String Nv() {
        return " MicroMessenger/";
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.p.a
    public final String version() {
        PackageInfo packageInfo;
        AppMethodBeat.i(225170);
        if (!TextUtils.isEmpty(this.version)) {
            String str = this.version;
            AppMethodBeat.o(225170);
            return str;
        }
        try {
            packageInfo = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(this.mContext, MMApplicationContext.getPackageName());
        } catch (Exception e2) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            this.version += ChannelUtil.formatVersion(null, d.KyO);
            this.version += "." + packageInfo.versionCode;
            StringBuilder append = new StringBuilder().append(this.version).append("(");
            ae aeVar = ae.SYK;
            String format = String.format("0x%08X", Arrays.copyOf(new Object[]{Integer.valueOf(d.KyO)}, 1));
            kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
            this.version = append.append(format).append("; MicroMessenger/Prefetcher 2.0)").toString();
            this.version += " Process/mm";
            this.version += " WeChat/" + (q.is64BitRuntime() ? "arm64" : "arm32");
            StringBuilder append2 = new StringBuilder().append(this.version).append(" ");
            WeChatBrands.AppInfo.WhichApp current = WeChatBrands.AppInfo.current();
            kotlin.g.b.p.g(current, "WeChatBrands.AppInfo.current()");
            this.version = append2.append(current.getUserAgent()).toString();
            if (ChannelUtil.isGPVersion()) {
                this.version += " GPVersion/1";
            }
        }
        String acq = com.tencent.mm.plugin.appbrand.luggage.b.f.acq(this.version);
        kotlin.g.b.p.g(acq, "WeChatXWebUAInfo.appendTabletTag(version)");
        this.version = acq;
        String str2 = this.version;
        AppMethodBeat.o(225170);
        return str2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo$Companion;", "", "()V", "APPEND_USER_AGENT", "", "DEFAULT_UA_PREFIX", "WEB_PRE_FETCHER_VERSION", "WEB_PRE_KEY_USER_AGENT", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "updateUserAgentPrefix", "", "prefix", "webPrefetchUserAgentPrefix", "webview-sdk_release"})
    public static final class a {
        public static MultiProcessMMKV aTI() {
            AppMethodBeat.i(225168);
            f fVar = e.iBW;
            a aVar = e.JBw;
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) fVar.getValue();
            AppMethodBeat.o(225168);
            return multiProcessMMKV;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String giH() {
            AppMethodBeat.i(225169);
            String string = aTI().getString("key_web_prefetch_ua", "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ");
            String str = string;
            if (!(str == null || n.aL(str))) {
                AppMethodBeat.o(225169);
                return string;
            }
            AppMethodBeat.o(225169);
            return "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ";
        }
    }

    static {
        AppMethodBeat.i(225172);
        AppMethodBeat.o(225172);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final b JBx = new b();

        static {
            AppMethodBeat.i(225167);
            AppMethodBeat.o(225167);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(225166);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WebPrefetchUserAgent");
            AppMethodBeat.o(225166);
            return mmkv;
        }
    }
}
