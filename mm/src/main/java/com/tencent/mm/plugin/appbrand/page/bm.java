package com.tencent.mm.plugin.appbrand.page;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.ak;
import com.tencent.mm.plugin.appbrand.jsapi.p.al;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0019\u0010\u0012\u001a\u00020\n2\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\bJ\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u001c\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", ak.NAME, al.NAME, "luggage-wechat-full-sdk_release"})
public class bm implements com.tencent.mm.plugin.appbrand.page.a.f {
    private final String TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    private final ac cwK;
    private final aj nnb;

    public bm(ac acVar, aj ajVar) {
        p.h(acVar, "mPageView");
        p.h(ajVar, "mPullDownWrapper");
        AppMethodBeat.i(147996);
        this.cwK = acVar;
        this.nnb = ajVar;
        AppMethodBeat.o(147996);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public final void bSe() {
        AppMethodBeat.i(147987);
        Log.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.cwK.getAppId() + " url:" + this.cwK.getURL());
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147987);
            return;
        }
        this.cwK.P(new h(this, this));
        AppMethodBeat.o(147987);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class a implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;
        final /* synthetic */ boolean ntM;

        public a(bm bmVar, bm bmVar2, boolean z) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
            this.ntM = z;
        }

        public final void run() {
            AppMethodBeat.i(147978);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147978);
                return;
            }
            this.ntL.nnb.setPullDownEnabled(this.ntM);
            AppMethodBeat.o(147978);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class b implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;
        final /* synthetic */ boolean ntM;

        public b(bm bmVar, bm bmVar2, boolean z) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
            this.ntM = z;
        }

        public final void run() {
            AppMethodBeat.i(147979);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147979);
                return;
            }
            this.ntL.nnb.setPullDownEnabled(this.ntM);
            this.ntL.nnb.ij(this.ntM);
            AppMethodBeat.o(147979);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class c implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;
        final /* synthetic */ boolean ntN;

        public c(bm bmVar, bm bmVar2, boolean z) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
            this.ntN = z;
        }

        public final void run() {
            AppMethodBeat.i(147980);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147980);
                return;
            }
            this.ntL.nnb.requestDisallowInterceptTouchEvent(this.ntN);
            AppMethodBeat.o(147980);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class d implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;
        final /* synthetic */ f.a ntO;
        final /* synthetic */ int ntP;

        public d(bm bmVar, bm bmVar2, f.a aVar, int i2) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
            this.ntO = aVar;
            this.ntP = i2;
        }

        public final void run() {
            AppMethodBeat.i(147981);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147981);
                return;
            }
            this.ntL.nnb.cb(this.ntO.bSC(), this.ntP);
            AppMethodBeat.o(147981);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class e implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;
        final /* synthetic */ String ntQ;
        final /* synthetic */ String ntR;

        public e(bm bmVar, bm bmVar2, String str, String str2) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
            this.ntQ = str;
            this.ntR = str2;
        }

        public final void run() {
            AppMethodBeat.i(147982);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147982);
                return;
            }
            this.ntL.nnb.cb(this.ntQ, com.tencent.mm.plugin.appbrand.ac.g.cu(this.ntR, -1));
            AppMethodBeat.o(147982);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class f implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;
        final /* synthetic */ String ntQ;

        public f(bm bmVar, bm bmVar2, String str) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
            this.ntQ = str;
        }

        public final void run() {
            AppMethodBeat.i(147983);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147983);
                return;
            }
            this.ntL.nnb.setBackgroundTextStyle(this.ntQ);
            AppMethodBeat.o(147983);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class g implements Runnable {
        final /* synthetic */ String lzr;
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;

        public g(bm bmVar, bm bmVar2, String str) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
            this.lzr = str;
        }

        public final void run() {
            AppMethodBeat.i(147984);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147984);
                return;
            }
            this.ntL.nnb.setPullDownText(this.lzr);
            AppMethodBeat.o(147984);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class h implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;

        public h(bm bmVar, bm bmVar2) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
        }

        public final void run() {
            AppMethodBeat.i(147985);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147985);
                return;
            }
            Log.i(this.ntL.TAG, "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + this.ntL.cwK.getAppId() + " url:" + this.ntL.cwK.getURL());
            try {
                bb bRk = this.ntL.cwK.bRk();
                p.g(bRk, "mPageView.webView");
                if (bRk.getWebScrollY() != 0) {
                    this.ntL.cwK.bRk().MM();
                }
                this.ntL.nnb.ij(true);
                this.ntL.nnb.bRP();
                AppMethodBeat.o(147985);
            } catch (NullPointerException e2) {
                Log.e(this.ntL.TAG, "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + this.ntL.cwK.getAppId() + " url:" + this.ntL.cwK.getURL() + " e:" + e2);
                NullPointerException nullPointerException = e2;
                AppMethodBeat.o(147985);
                throw nullPointerException;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
    public static final class i implements Runnable {
        final /* synthetic */ bm ntK;
        final /* synthetic */ bm ntL;

        public i(bm bmVar, bm bmVar2) {
            this.ntK = bmVar;
            this.ntL = bmVar2;
        }

        public final void run() {
            AppMethodBeat.i(147986);
            if (!this.ntK.cwK.isRunning()) {
                Log.e(this.ntK.TAG, "runOnUiThread in ui-thread PageView destroyed");
                AppMethodBeat.o(147986);
                return;
            }
            this.ntL.nnb.bRT();
            AppMethodBeat.o(147986);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public final void bSf() {
        AppMethodBeat.i(147988);
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147988);
            return;
        }
        this.cwK.P(new i(this, this));
        AppMethodBeat.o(147988);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public final void ij(boolean z) {
        AppMethodBeat.i(147989);
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147989);
            return;
        }
        this.cwK.P(new b(this, this, z));
        AppMethodBeat.o(147989);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public final void il(boolean z) {
        AppMethodBeat.i(147990);
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147990);
            return;
        }
        this.cwK.P(new a(this, this, z));
        AppMethodBeat.o(147990);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public void a(f.a aVar, int i2) {
        AppMethodBeat.i(147991);
        p.h(aVar, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147991);
            return;
        }
        this.cwK.P(new d(this, this, aVar, i2));
        AppMethodBeat.o(147991);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public void eE(String str, String str2) {
        AppMethodBeat.i(147992);
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147992);
            return;
        }
        this.cwK.P(new e(this, this, str, str2));
        AppMethodBeat.o(147992);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public final void adV(String str) {
        AppMethodBeat.i(147993);
        p.h(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147993);
            return;
        }
        this.cwK.P(new f(this, this, str));
        AppMethodBeat.o(147993);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public final void setPullDownText(String str) {
        AppMethodBeat.i(147994);
        p.h(str, "text");
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147994);
            return;
        }
        this.cwK.P(new g(this, this, str));
        AppMethodBeat.o(147994);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.f
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        AppMethodBeat.i(147995);
        if (!this.cwK.isRunning()) {
            Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(147995);
            return;
        }
        this.cwK.P(new c(this, this, z));
        AppMethodBeat.o(147995);
    }
}
