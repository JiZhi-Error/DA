package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.xweb.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xwalk.core.XWalkEnvironment;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010;\u001a\u00020\tH\u0007J\b\u0010<\u001a\u00020\tH\u0007J\b\u0010=\u001a\u00020>H\u0007J\b\u0010?\u001a\u00020>H\u0007J\b\u0010@\u001a\u00020\u0016H\u0007J\b\u0010A\u001a\u00020\u0016H\u0007J\b\u0010B\u001a\u00020\u0016H\u0007J\b\u0010C\u001a\u00020\tH\u0007J\b\u0010D\u001a\u00020\tH\u0007J\b\u0010E\u001a\u00020\tH\u0007J\b\u0010F\u001a\u00020\tH\u0007J\b\u0010G\u001a\u00020\tH\u0007J\b\u0010H\u001a\u00020\tH\u0007J\b\u0010I\u001a\u00020\tH\u0007J\b\u0010J\u001a\u00020\tH\u0007J\b\u0010K\u001a\u00020\tH\u0007J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020\u0016H\u0007J\u0010\u0010N\u001a\u00020>2\u0006\u0010M\u001a\u00020\u0016H\u0007J\b\u0010O\u001a\u00020\tH\u0007J\b\u0010P\u001a\u00020\tH\u0007J\b\u0010)\u001a\u00020\tH\u0007J\b\u0010/\u001a\u00020\tH\u0007J\b\u0010Q\u001a\u00020\tH\u0007J\b\u0010R\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\u00020\t8BX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\fR!\u0010\u001e\u001a\u00020\t8BX\u0002¢\u0006\u0012\n\u0004\b!\u0010\u000e\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\fR!\u0010\"\u001a\u00020\t8BX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u000e\u0012\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010\fR\u001b\u0010&\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b'\u0010\fR\u001e\u0010)\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010/\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\u001e\u00102\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b3\u0010+\"\u0004\b4\u0010-R\u001e\u00105\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b6\u0010+\"\u0004\b7\u0010-R\u001e\u00108\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b9\u0010+\"\u0004\b:\u0010-¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground", "_canHideAllPagesRenderingWhenRuntimeOnBackground$delegate", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebHideInterface", "getCanUseXWebHideInterface", "canUseXWebHideInterface$delegate", "useNewXWebCanvasToTFP", "getUseNewXWebCanvasToTFP", "()Ljava/lang/Boolean;", "setUseNewXWebCanvasToTFP", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebCanvasRaf", "getUseXWebCanvasRaf", "setUseXWebCanvasRaf", "useXWebMap", "getUseXWebMap", "setUseXWebMap", "useXWebVoipRoom", "getUseXWebVoipRoom", "setUseXWebVoipRoom", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebVoipRoom", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"})
public final class c {
    public static final c oGA = new c();
    private static Boolean oGn;
    private static Boolean oGo;
    private static Boolean oGp;
    private static final kotlin.f oGq = kotlin.g.ah(e.oGF);
    private static final kotlin.f oGr = kotlin.g.ah(g.oGH);
    private static final kotlin.f oGs = kotlin.g.ah(a.oGB);
    private static final kotlin.f oGt = kotlin.g.ah(f.oGG);
    private static Boolean oGu;
    private static Boolean oGv;
    private static final kotlin.f oGw = kotlin.g.ah(h.oGI);
    private static final kotlin.f oGx = kotlin.g.ah(b.oGC);
    private static final kotlin.f oGy = kotlin.g.ah(d.oGE);
    private static final kotlin.f oGz = kotlin.g.ah(C0828c.oGD);

    private static boolean cdp() {
        AppMethodBeat.i(51480);
        boolean booleanValue = ((Boolean) oGq.getValue()).booleanValue();
        AppMethodBeat.o(51480);
        return booleanValue;
    }

    private static boolean cdt() {
        AppMethodBeat.i(229702);
        boolean booleanValue = ((Boolean) oGs.getValue()).booleanValue();
        AppMethodBeat.o(229702);
        return booleanValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Boolean> {
        public static final a oGB = new a();

        static {
            AppMethodBeat.i(229697);
            AppMethodBeat.o(229697);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(229695);
            Boolean valueOf = Boolean.valueOf(ij());
            AppMethodBeat.o(229695);
            return valueOf;
        }

        private static boolean ij() {
            boolean z;
            AppMethodBeat.i(229696);
            try {
                z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wxa_use_xweb_camera, 0) == 1;
            } catch (Throwable th) {
                z = false;
            }
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "abtestXWebCameraEnable: ".concat(String.valueOf(z)));
            AppMethodBeat.o(229696);
            return z;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<Boolean> {
        public static final g oGH = new g();

        static {
            AppMethodBeat.i(51470);
            AppMethodBeat.o(51470);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(51468);
            Boolean valueOf = Boolean.valueOf(ij());
            AppMethodBeat.o(51468);
            return valueOf;
        }

        private static boolean ij() {
            boolean z;
            AppMethodBeat.i(51469);
            try {
                z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wxa_use_xweb_textarea, 0) == 1;
            } catch (Throwable th) {
                z = false;
            }
            StringBuilder append = new StringBuilder("useXWebTextArea: abtest[").append(z).append("], isXWeb[").append(WebView.isXWalk()).append("], supper[");
            c cVar = c.oGA;
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", append.append(c.cdE()).append(']').toString());
            if (z) {
                c cVar2 = c.oGA;
                if (c.cdE()) {
                    AppMethodBeat.o(51469);
                    return true;
                }
            }
            AppMethodBeat.o(51469);
            return false;
        }
    }

    static {
        AppMethodBeat.i(51473);
        AppMethodBeat.o(51473);
    }

    private c() {
    }

    public static final /* synthetic */ boolean cdE() {
        AppMethodBeat.i(51492);
        boolean cdp = cdp();
        AppMethodBeat.o(51492);
        return cdp;
    }

    public static final /* synthetic */ boolean cdF() {
        AppMethodBeat.i(229706);
        boolean cdt = cdt();
        AppMethodBeat.o(229706);
        return cdt;
    }

    public static final void cdj() {
        AppMethodBeat.i(51474);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
        AppMethodBeat.o(51474);
    }

    public static final void AL(int i2) {
        AppMethodBeat.i(51475);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_command_value", i2);
        AppMethodBeat.o(51475);
    }

    public static final boolean cdl() {
        AppMethodBeat.i(51478);
        boolean isCurrentVersionSupportMapExtendPluginForAppbrand = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
        boolean isXWalk = WebView.isXWalk();
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "supportXWebCanvasSameLayer supportXWeb:" + isCurrentVersionSupportMapExtendPluginForAppbrand + " isXWeb:" + isXWalk);
        if (!isCurrentVersionSupportMapExtendPluginForAppbrand || !isXWalk) {
            AppMethodBeat.o(51478);
            return false;
        }
        AppMethodBeat.o(51478);
        return true;
    }

    public static final boolean cdm() {
        boolean z;
        AppMethodBeat.i(229700);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(229700);
            return true;
        } else if (oGn != null) {
            Boolean bool = oGn;
            if (bool == null) {
                p.hyc();
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(229700);
            return booleanValue;
        } else {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wxa_use_xweb_canvas_raf, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            oGn = Boolean.valueOf(z);
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebCanvasRaf:" + oGn);
            Boolean bool2 = oGn;
            if (bool2 == null) {
                p.hyc();
            }
            boolean booleanValue2 = bool2.booleanValue();
            AppMethodBeat.o(229700);
            return booleanValue2;
        }
    }

    public static final boolean cdn() {
        boolean z;
        AppMethodBeat.i(229701);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(229701);
            return true;
        } else if (oGo != null) {
            Boolean bool = oGo;
            if (bool == null) {
                p.hyc();
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(229701);
            return booleanValue;
        } else {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wxa_canvas_to_temp_file_path_use_new, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            oGo = Boolean.valueOf(z);
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useNewXWebCanvasToTFP:" + oGo);
            Boolean bool2 = oGo;
            if (bool2 == null) {
                p.hyc();
            }
            boolean booleanValue2 = bool2.booleanValue();
            AppMethodBeat.o(229701);
            return booleanValue2;
        }
    }

    public static final boolean cdo() {
        AppMethodBeat.i(51479);
        if (oGp != null) {
            Boolean bool = oGp;
            if (bool == null) {
                p.hyc();
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(51479);
            return booleanValue;
        }
        boolean isCurrentVersionSupportMapExtendPluginForAppbrand = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
        boolean isXWalk = WebView.isXWalk();
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebMap: " + isCurrentVersionSupportMapExtendPluginForAppbrand + ", " + isXWalk);
        Boolean valueOf = Boolean.valueOf(isCurrentVersionSupportMapExtendPluginForAppbrand && isXWalk);
        oGp = valueOf;
        if (valueOf == null) {
            p.hyc();
        }
        boolean booleanValue2 = valueOf.booleanValue();
        AppMethodBeat.o(51479);
        return booleanValue2;
    }

    public static final boolean cdq() {
        AppMethodBeat.i(51481);
        boolean cdp = cdp();
        AppMethodBeat.o(51481);
        return cdp;
    }

    public static final boolean cds() {
        AppMethodBeat.i(51483);
        boolean isCurrentVersionSupportMapExtendPluginForAppbrand = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
        AppMethodBeat.o(51483);
        return isCurrentVersionSupportMapExtendPluginForAppbrand;
    }

    public static final boolean cdu() {
        AppMethodBeat.i(229703);
        boolean cdt = cdt();
        AppMethodBeat.o(229703);
        return cdt;
    }

    public static final boolean cdw() {
        boolean z = true;
        AppMethodBeat.i(229704);
        Boolean bool = oGu;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(229704);
            return booleanValue;
        }
        boolean z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wxa_use_xweb_webgl_canvas, 0) == 1;
        boolean isCurrentVersionSupportMapExtendPluginForAppbrand = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
        boolean isXWalk = WebView.isXWalk();
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebWebGLCanvas: " + z2 + ", " + isCurrentVersionSupportMapExtendPluginForAppbrand + ", " + isXWalk);
        if (!z2 || !isCurrentVersionSupportMapExtendPluginForAppbrand || !isXWalk) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        oGu = valueOf;
        if (valueOf == null) {
            p.hyc();
        }
        boolean booleanValue2 = valueOf.booleanValue();
        AppMethodBeat.o(229704);
        return booleanValue2;
    }

    public static final boolean cdx() {
        boolean z = true;
        AppMethodBeat.i(229705);
        Boolean bool = oGv;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(229705);
            return booleanValue;
        }
        boolean z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wxa_use_xweb_voip, 0) == 1;
        boolean isCurrentVersionSupportMapExtendPluginForAppbrand = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
        boolean isXWalk = WebView.isXWalk();
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebVoipRoom: " + z2 + ", " + isCurrentVersionSupportMapExtendPluginForAppbrand + ", " + isXWalk);
        if (!z2 || !isCurrentVersionSupportMapExtendPluginForAppbrand || !isXWalk) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        oGv = valueOf;
        if (valueOf == null) {
            p.hyc();
        }
        boolean booleanValue2 = valueOf.booleanValue();
        AppMethodBeat.o(229705);
        return booleanValue2;
    }

    public static final void cdy() {
        AppMethodBeat.i(51485);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
        AppMethodBeat.o(51485);
    }

    public static final void AM(int i2) {
        AppMethodBeat.i(51486);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_live_command_value", i2);
        AppMethodBeat.o(51486);
    }

    public static final boolean cdk() {
        AppMethodBeat.i(51476);
        int decodeInt = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
        if (decodeInt >= 0) {
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for video, commandValue:%s", Integer.valueOf(decodeInt));
            if (decodeInt == 1) {
                AppMethodBeat.o(51476);
                return true;
            }
            AppMethodBeat.o(51476);
            return false;
        }
        AppMethodBeat.o(51476);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Boolean> {
        public static final e oGF = new e();

        static {
            AppMethodBeat.i(51467);
            AppMethodBeat.o(51467);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(51466);
            boolean z = XWalkEnvironment.isCurrentVersionSupportCustomTextAreaForAppbrand() && WebView.isXWalk();
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "xwebSupportTextAreaSameLayer: ".concat(String.valueOf(z)));
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(51466);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<Boolean> {
        public static final f oGG = new f();

        static {
            AppMethodBeat.i(229699);
            AppMethodBeat.o(229699);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0059, code lost:
            if (com.tencent.mm.plugin.appbrand.xweb_ext.c.cdF() != false) goto L_0x005b;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
            // Method dump skipped, instructions count: 103
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.xweb_ext.c.f.invoke():java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<Boolean> {
        public static final h oGI = new h();

        static {
            AppMethodBeat.i(51472);
            AppMethodBeat.o(51472);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(51471);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_xweb_hide_render_when_page_pause, !com.tencent.mm.protocal.d.KyP);
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebHideInterfaceSwitch = ".concat(String.valueOf(a2)));
            Boolean valueOf = Boolean.valueOf(a2);
            AppMethodBeat.o(51471);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        public static final b oGC = new b();

        static {
            AppMethodBeat.i(51461);
            AppMethodBeat.o(51461);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(51460);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_xweb_hide_all_page_render_when_app_pause, true);
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "canHideAllPagesRenderingWhenRuntimeOnBackground = ".concat(String.valueOf(a2)));
            Boolean valueOf = Boolean.valueOf(a2);
            AppMethodBeat.o(51460);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Integer> {
        public static final d oGE = new d();

        static {
            AppMethodBeat.i(51465);
            AppMethodBeat.o(51465);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(51464);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_xweb_keep_show_page_render_top_count, 2);
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "keepPagesNoHideRenderingTopCount = ".concat(String.valueOf(a2)));
            Integer valueOf = Integer.valueOf(a2);
            AppMethodBeat.o(51464);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.xweb_ext.c$c  reason: collision with other inner class name */
    static final class C0828c extends q implements kotlin.g.a.a<Boolean> {
        public static final C0828c oGD = new C0828c();

        static {
            AppMethodBeat.i(51463);
            AppMethodBeat.o(51463);
        }

        C0828c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(51462);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_xweb_hide_page_render_when_tabbar_switch, false);
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "canHideInvisibleTabPageWhenSwitchTab = ".concat(String.valueOf(a2)));
            Boolean valueOf = Boolean.valueOf(a2);
            AppMethodBeat.o(51462);
            return valueOf;
        }
    }

    public static final boolean cdr() {
        AppMethodBeat.i(51482);
        boolean booleanValue = ((Boolean) oGr.getValue()).booleanValue();
        AppMethodBeat.o(51482);
        return booleanValue;
    }

    public static final boolean cdv() {
        AppMethodBeat.i(51484);
        boolean booleanValue = ((Boolean) oGt.getValue()).booleanValue();
        AppMethodBeat.o(51484);
        return booleanValue;
    }

    public static final boolean cdz() {
        AppMethodBeat.i(51487);
        int decodeInt = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_live_command_value", -1);
        if (decodeInt >= 0) {
            Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live, commandValue:%s", Integer.valueOf(decodeInt));
            if (decodeInt == 1) {
                AppMethodBeat.o(51487);
                return true;
            }
            AppMethodBeat.o(51487);
            return false;
        }
        boolean isCurrentVersionSupportMapExtendPluginForAppbrand = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live:%b", Boolean.valueOf(isCurrentVersionSupportMapExtendPluginForAppbrand));
        AppMethodBeat.o(51487);
        return isCurrentVersionSupportMapExtendPluginForAppbrand;
    }

    public static final boolean cdA() {
        AppMethodBeat.i(51488);
        boolean booleanValue = ((Boolean) oGw.getValue()).booleanValue();
        AppMethodBeat.o(51488);
        return booleanValue;
    }

    public static final boolean cdB() {
        AppMethodBeat.i(51489);
        boolean booleanValue = ((Boolean) oGx.getValue()).booleanValue();
        AppMethodBeat.o(51489);
        return booleanValue;
    }

    public static final int cdC() {
        AppMethodBeat.i(51490);
        int intValue = ((Number) oGy.getValue()).intValue();
        AppMethodBeat.o(51490);
        return intValue;
    }

    public static final boolean cdD() {
        AppMethodBeat.i(51491);
        boolean booleanValue = ((Boolean) oGz.getValue()).booleanValue();
        AppMethodBeat.o(51491);
        return booleanValue;
    }
}
