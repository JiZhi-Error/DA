package com.tencent.mm.plugin.ab;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b.i;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\fH\u0007J\b\u0010\u0015\u001a\u00020\u0006H\u0007J\b\u0010\u0016\u001a\u00020\u0006H\u0007J8\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\bH\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\bH\u0007J8\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\bH\u0007J\u0010\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0018H\u0007J\u0018\u0010(\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0007¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;)V", "canVideoAutoPlay", "", "getCacheDir", "", "getCanvas", "Lcom/eclipsesource/v8/V8Object;", "getElementId", "", "getFontSize", "", "getFps", "getHeight", "getId", "getOffsetHeight", "getOffsetTop", "getWidth", "isDarkMode", "isOnScreen", i.NAME, "", "text", "fontWeight", "fontStyle", "fontSize", "fontFamily", "restore", "canvasId", "save", "", "left", "top", "width", "height", "layout", "setHeight", "setVideo", "bottom", "Companion", "webview-sdk_release"})
public final class f extends a<g> {
    private static final kotlin.f IBb = g.ah(b.IBe);
    private static final com.tencent.magicbrush.handler.glfont.i IBc;
    public static final a IBd = new a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(g gVar) {
        super("wxCanvas", gVar);
        p.h(gVar, "context");
        AppMethodBeat.i(224801);
        AppMethodBeat.o(224801);
    }

    @JavascriptInterface
    public final Number measureText(String str, String str2, String str3, Number number, String str4) {
        AppMethodBeat.i(224788);
        p.h(str, "text");
        p.h(str2, "fontWeight");
        p.h(str3, "fontStyle");
        p.h(number, "fontSize");
        p.h(str4, "fontFamily");
        com.tencent.magicbrush.handler.glfont.i iVar = IBc;
        if (BuildInfo.DEBUG) {
            Log.d(this.TAG, "measureText text=" + str + " fontWeight=" + str2 + ", fontStyle=" + str3 + ", fontSize=" + number + ", fontFamily=" + str4);
        }
        float floatValue = number.floatValue();
        String lowerCase = str3.toLowerCase();
        p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
        boolean j2 = p.j(lowerCase, "italic");
        String lowerCase2 = str3.toLowerCase();
        p.g(lowerCase2, "(this as java.lang.String).toLowerCase()");
        iVar.useFont(str4, str2, floatValue, j2, p.j(lowerCase2, "bold"));
        Float valueOf = Float.valueOf(iVar.measureText(str));
        AppMethodBeat.o(224788);
        return valueOf;
    }

    @JavascriptInterface
    public final String getCacheDir() {
        AppMethodBeat.i(224789);
        m mVar = m.IAG;
        String fWH = m.fWH();
        AppMethodBeat.o(224789);
        return fWH;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u001a\u001a\u00020\u0015*\u00020\u001bJ\n\u0010\u001c\u001a\u00020\u0015*\u00020\u001bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI$Companion;", "", "()V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "devicePixelRatio", "", "getDevicePixelRatio", "()F", "devicePixelRatio$delegate", "Lkotlin/Lazy;", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/MBFontHandlerImpl;", "fontSize", "getFontSize", "isDarkMode", "", "()Z", "viewportHeight", "", "getViewportHeight", "()I", "viewportWidth", "getViewportWidth", "fromPixel", "", "toPixel", "webview-sdk_release"})
    public static final class a {
        public static float getDevicePixelRatio() {
            AppMethodBeat.i(224782);
            kotlin.f fVar = f.IBb;
            a aVar = f.IBd;
            float floatValue = ((Number) fVar.getValue()).floatValue();
            AppMethodBeat.o(224782);
            return floatValue;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Context getAppContext() {
            AppMethodBeat.i(224779);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Context applicationContext = context.getApplicationContext();
            p.g(applicationContext, "MMApplicationContext.get…text().applicationContext");
            AppMethodBeat.o(224779);
            return applicationContext;
        }

        public static int c(Number number) {
            AppMethodBeat.i(224780);
            p.h(number, "$this$toPixel");
            int cR = kotlin.h.a.cR(number.floatValue() * getDevicePixelRatio());
            AppMethodBeat.o(224780);
            return cR;
        }

        public static int d(Number number) {
            AppMethodBeat.i(224781);
            p.h(number, "$this$fromPixel");
            int cR = kotlin.h.a.cR(number.floatValue() / getDevicePixelRatio());
            AppMethodBeat.o(224781);
            return cR;
        }
    }

    static {
        AppMethodBeat.i(224802);
        com.tencent.magicbrush.handler.glfont.i iVar = new com.tencent.magicbrush.handler.glfont.i();
        iVar.init(1024, 1024);
        IBc = iVar;
        AppMethodBeat.o(224802);
    }

    @JavascriptInterface
    public final String getId() {
        AppMethodBeat.i(224783);
        String id = ((g) this.IBa).getId();
        AppMethodBeat.o(224783);
        return id;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Float> {
        public static final b IBe = new b();

        static {
            AppMethodBeat.i(224778);
            AppMethodBeat.o(224778);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(224777);
            Float valueOf = Float.valueOf(com.tencent.mm.plugin.appbrand.ac.g.bZk());
            AppMethodBeat.o(224777);
            return valueOf;
        }
    }

    @JavascriptInterface
    public final V8Object getCanvas() {
        AppMethodBeat.i(224784);
        V8Object canvas = ((g) this.IBa).getCanvas();
        AppMethodBeat.o(224784);
        return canvas;
    }

    @JavascriptInterface
    public final int getElementId() {
        AppMethodBeat.i(224785);
        int elementId = ((g) this.IBa).getElementId();
        AppMethodBeat.o(224785);
        return elementId;
    }

    @JavascriptInterface
    public final float getFontSize() {
        AppMethodBeat.i(224786);
        float fontSize = ((g) this.IBa).getFontSize();
        AppMethodBeat.o(224786);
        return fontSize;
    }

    @JavascriptInterface
    public final boolean isDarkMode() {
        AppMethodBeat.i(224787);
        boolean isDarkMode = ao.isDarkMode();
        AppMethodBeat.o(224787);
        return isDarkMode;
    }

    @JavascriptInterface
    public final int getFps() {
        AppMethodBeat.i(224790);
        int fps = ((g) this.IBa).getFps();
        AppMethodBeat.o(224790);
        return fps;
    }

    @JavascriptInterface
    public final boolean isOnScreen() {
        AppMethodBeat.i(224791);
        boolean isOnScreen = ((g) this.IBa).isOnScreen();
        AppMethodBeat.o(224791);
        return isOnScreen;
    }

    @JavascriptInterface
    public final int getWidth() {
        AppMethodBeat.i(224792);
        int width = ((g) this.IBa).getWidth();
        AppMethodBeat.o(224792);
        return width;
    }

    @JavascriptInterface
    public final int getHeight() {
        AppMethodBeat.i(224793);
        int height = ((g) this.IBa).getHeight();
        AppMethodBeat.o(224793);
        return height;
    }

    @JavascriptInterface
    public final int getOffsetTop() {
        AppMethodBeat.i(224794);
        int offsetTop = ((g) this.IBa).getOffsetTop();
        AppMethodBeat.o(224794);
        return offsetTop;
    }

    @JavascriptInterface
    public final int getOffsetHeight() {
        AppMethodBeat.i(224795);
        int offsetHeight = ((g) this.IBa).getOffsetHeight();
        AppMethodBeat.o(224795);
        return offsetHeight;
    }

    @JavascriptInterface
    public final void setHeight(Number number) {
        AppMethodBeat.i(224796);
        p.h(number, "height");
        ((g) this.IBa).setHeight(number);
        AppMethodBeat.o(224796);
    }

    @JavascriptInterface
    public final void setVideo(Number number, Number number2) {
        AppMethodBeat.i(224797);
        p.h(number, "top");
        p.h(number2, "bottom");
        Log.d(this.TAG, "setVideo:" + ((g) this.IBa).getId() + " to " + number + ' ' + number2);
        ((g) this.IBa).setVideo(number, number2);
        AppMethodBeat.o(224797);
    }

    @JavascriptInterface
    public final boolean canVideoAutoPlay() {
        AppMethodBeat.i(224798);
        boolean canVideoAutoPlay = ((g) this.IBa).canVideoAutoPlay();
        AppMethodBeat.o(224798);
        return canVideoAutoPlay;
    }

    @JavascriptInterface
    public final void save(String str, Number number, Number number2, Number number3, Number number4, String str2) {
        AppMethodBeat.i(224799);
        p.h(str, "canvasId");
        p.h(number, "left");
        p.h(number2, "top");
        p.h(number3, "width");
        p.h(number4, "height");
        p.h(str2, "layout");
        ((g) this.IBa).save(str, number, number2, number3, number4, str2);
        AppMethodBeat.o(224799);
    }

    @JavascriptInterface
    public final String restore(String str) {
        AppMethodBeat.i(224800);
        p.h(str, "canvasId");
        String restore = ((g) this.IBa).restore(str);
        AppMethodBeat.o(224800);
        return restore;
    }
}
