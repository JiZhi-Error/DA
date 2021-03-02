package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.KeyEvent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.Formatter;
import java.util.Locale;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007*\u0002;@\u0018\u0000 P2\u00020\u0001:\u0001PB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010B\u001a\u00020CH\u0016J\u0006\u0010D\u001a\u00020.J\u0006\u0010E\u001a\u00020.J\u0018\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010I\u001a\u00020J2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010K\u001a\u00020CH\u0002J\b\u0010L\u001a\u00020CH\u0002J\b\u0010M\u001a\u00020CH\u0002J\b\u0010N\u001a\u00020CH\u0002J\u000e\u0010O\u001a\u00020C2\u0006\u0010O\u001a\u000204R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u001e\u001a\u00020\u00148FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00105\u001a\u0002042\u0006\u00103\u001a\u000204@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u00020;X\u0004¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020@X\u0004¢\u0006\u0004\n\u0002\u0010A¨\u0006Q"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"})
public final class b {
    public static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(b.class), "isForeground", "isForeground()Z")), aa.a(new v(aa.bp(b.class), "isCastMediaPresent", "isCastMediaPresent()Z"))};
    public static final c mKS = new c((byte) 0);
    private final com.tencent.mm.plugin.appbrand.jsapi.f lqg;
    public int mKG;
    private final i mKH;
    private final kotlin.f mKI = kotlin.g.ah(new d(this));
    public final com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c mKJ = ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c.class));
    final kotlin.i.c mKK;
    public boolean mKL;
    public boolean mKM;
    public final kotlin.i.c mKN;
    private final h mKO;
    private final i mKP;
    private final kotlin.f mKQ;
    private final com.tencent.luggage.xweb_ext.extendplugin.a mKR;
    public String videoPath;

    static {
        AppMethodBeat.i(139663);
        AppMethodBeat.o(139663);
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h bMi() {
        AppMethodBeat.i(139668);
        com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h hVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h) this.mKQ.getValue();
        AppMethodBeat.o(139668);
        return hVar;
    }

    public final void hV(boolean z) {
        AppMethodBeat.i(139665);
        this.mKN.a(cLI[1], Boolean.valueOf(z));
        AppMethodBeat.o(139665);
    }

    public final void setForeground(boolean z) {
        AppMethodBeat.i(139666);
        this.mKK.a(cLI[0], Boolean.valueOf(z));
        AppMethodBeat.o(139666);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "stopSuccess", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ b mKU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(b bVar) {
            super(1);
            this.mKU = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(184880);
            boolean booleanValue = bool.booleanValue();
            com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.b(b.a(this.mKU));
            if (!booleanValue) {
                this.mKU.hV(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(184880);
            return xVar;
        }
    }

    public b(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a aVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar2) {
        String str;
        ac pageView;
        p.h(aVar, "eventHandler");
        p.h(aVar2, "invokeContext");
        AppMethodBeat.i(139670);
        this.mKR = aVar2;
        com.tencent.mm.plugin.appbrand.jsapi.f NN = this.mKR.NN();
        p.g(NN, "invokeContext.component");
        this.lqg = NN;
        Context context = this.mKR.getContext();
        p.g(context, "invokeContext.context");
        this.mKH = new i(context);
        kotlin.i.a aVar3 = kotlin.i.a.SYL;
        Boolean bool = Boolean.TRUE;
        this.mKK = new a(bool, bool, this);
        AppBrandRuntime A = com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.d.A(this.mKR);
        if (this.mKJ != null) {
            com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c cVar = this.mKJ;
            String appId = A.getAppId();
            p.g(appId, "appBrandRuntime.appId");
            cVar.setAppId(appId);
            w brh = A.brh();
            this.mKJ.abO((brh == null || (pageView = brh.getPageView()) == null || (str = pageView.getURL()) == null) ? "" : str);
        }
        if (this.lqg instanceof com.tencent.mm.plugin.appbrand.jsapi.h) {
            ((com.tencent.mm.plugin.appbrand.jsapi.h) this.lqg).a(new i.d(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.AnonymousClass1 */
                final /* synthetic */ b mKU;

                {
                    this.mKU = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
                public final void onForeground() {
                    AppMethodBeat.i(139653);
                    this.mKU.setForeground(true);
                    AppMethodBeat.o(139653);
                }
            });
            ((com.tencent.mm.plugin.appbrand.jsapi.h) this.lqg).a(new i.b(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.AnonymousClass2 */
                final /* synthetic */ b mKU;

                {
                    this.mKU = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                public final void onBackground() {
                    AppMethodBeat.i(139654);
                    this.mKU.setForeground(false);
                    AppMethodBeat.o(139654);
                }
            });
        }
        this.videoPath = "";
        kotlin.i.a aVar4 = kotlin.i.a.SYL;
        Boolean bool2 = Boolean.FALSE;
        this.mKN = new C0622b(bool2, bool2, this);
        this.mKO = new h(this);
        this.mKP = new i(this);
        this.mKQ = kotlin.g.ah(new g(this, aVar));
        AppMethodBeat.o(139670);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h a(b bVar) {
        AppMethodBeat.i(139675);
        com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h bMi = bVar.bMi();
        AppMethodBeat.o(139675);
        return bMi;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class a extends kotlin.i.b<Boolean> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ b mKU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, b bVar) {
            super(obj2);
            this.mKT = obj;
            this.mKU = bVar;
        }

        @Override // kotlin.i.b
        public final void a(k<?> kVar, Boolean bool, Boolean bool2) {
            AppMethodBeat.i(139651);
            p.h(kVar, "property");
            boolean booleanValue = bool2.booleanValue();
            boolean booleanValue2 = bool.booleanValue();
            Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "isForeground = " + booleanValue + ' ');
            if (booleanValue && !booleanValue2) {
                b.a(this.mKU).bMr();
            }
            if (!booleanValue && !booleanValue2) {
                b.a(this.mKU).bMq();
            }
            AppMethodBeat.o(139651);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.b$b  reason: collision with other inner class name */
    public static final class C0622b extends kotlin.i.b<Boolean> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ b mKU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0622b(Object obj, Object obj2, b bVar) {
            super(obj2);
            this.mKT = obj;
            this.mKU = bVar;
        }

        @Override // kotlin.i.b
        public final void a(k<?> kVar, Boolean bool, Boolean bool2) {
            AppMethodBeat.i(139652);
            p.h(kVar, "property");
            boolean booleanValue = bool2.booleanValue();
            bool.booleanValue();
            if (!booleanValue || !((Boolean) this.mKU.mKK.a(b.cLI[0])).booleanValue()) {
                b.e(this.mKU);
                b.f(this.mKU);
                AppMethodBeat.o(139652);
                return;
            }
            b.c(this.mKU);
            b.d(this.mKU);
            AppMethodBeat.o(139652);
        }
    }

    public final void setVideoPath(String str) {
        AppMethodBeat.i(139664);
        p.h(str, "path");
        com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c cVar = this.mKJ;
        if (cVar != null) {
            cVar.setVideoPath(str);
        }
        this.videoPath = str;
        AppMethodBeat.o(139664);
    }

    public final boolean bMh() {
        if (!this.mKL) {
            return false;
        }
        return this.mKM;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
    public static final class h extends al {
        final /* synthetic */ b mKU;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
        static final class a extends q implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer>, x> {
            final /* synthetic */ h mKW;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(h hVar) {
                super(1);
                this.mKW = hVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer> fVar) {
                AppMethodBeat.i(139659);
                com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer> fVar2 = fVar;
                p.h(fVar2, LocaleUtil.ITALIAN);
                Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume now:" + ((Object) fVar2.value));
                com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h a2 = b.a(this.mKW.mKU);
                T t = fVar2.value;
                if (t == null) {
                    p.hyc();
                }
                a2.setVolume(t.intValue() - 1);
                x xVar = x.SXb;
                AppMethodBeat.o(139659);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(b bVar) {
            this.mKU = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.al
        public final boolean c(KeyEvent keyEvent) {
            AppMethodBeat.i(139660);
            p.h(keyEvent, "event");
            Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
            b.a(this.mKU).u(new a(this));
            AppMethodBeat.o(139660);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
    public static final class i extends al {
        final /* synthetic */ b mKU;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
        static final class a extends q implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer>, x> {
            final /* synthetic */ i mKX;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(i iVar) {
                super(1);
                this.mKX = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer> fVar) {
                AppMethodBeat.i(139661);
                com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer> fVar2 = fVar;
                p.h(fVar2, LocaleUtil.ITALIAN);
                Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume now:" + ((Object) fVar2.value));
                com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h a2 = b.a(this.mKX.mKU);
                T t = fVar2.value;
                if (t == null) {
                    p.hyc();
                }
                a2.setVolume(t.intValue() + 1);
                x xVar = x.SXb;
                AppMethodBeat.o(139661);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(b bVar) {
            this.mKU = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.al
        public final boolean c(KeyEvent keyEvent) {
            AppMethodBeat.i(139662);
            p.h(keyEvent, "event");
            Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume up");
            b.a(this.mKU).u(new a(this));
            AppMethodBeat.o(139662);
            return true;
        }
    }

    public final AppBrandRuntime getRuntime() {
        AppMethodBeat.i(139667);
        if (!(this.mKR instanceof com.tencent.mm.plugin.appbrand.h.b)) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(139667);
            throw illegalStateException;
        }
        com.tencent.mm.plugin.appbrand.jsapi.f NN = ((com.tencent.mm.plugin.appbrand.h.b) this.mKR).NN();
        if (!(NN instanceof com.tencent.mm.plugin.appbrand.d)) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(139667);
            throw illegalStateException2;
        }
        AppBrandRuntime runtime = ((com.tencent.mm.plugin.appbrand.d) NN).getRuntime();
        p.g(runtime, "component.runtime");
        AppMethodBeat.o(139667);
        return runtime;
    }

    public static long al(JSONObject jSONObject) {
        AppMethodBeat.i(139669);
        if (jSONObject == null || !jSONObject.has("data")) {
            AppMethodBeat.o(139669);
            return -1;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            Log.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, data array is null");
            AppMethodBeat.o(139669);
            return -1;
        }
        double optDouble = optJSONArray.optDouble(0, -1.0d);
        if (optDouble < 0.0d) {
            Log.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, invalid position:%s", Double.valueOf(optDouble));
            AppMethodBeat.o(139669);
            return -1;
        }
        Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, position:%s", Double.valueOf(optDouble));
        long j2 = (long) (1000.0d * optDouble);
        AppMethodBeat.o(139669);
        return j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$Companion;", "", "()V", "TAG", "", "getFormatTime", "timeMs", "", "getMsTime", "", "formatTime", "luggage-xweb-ext_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public static String xU(int i2) {
            AppMethodBeat.i(139655);
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            int i3 = i2 / 1000;
            int i4 = i3 % 60;
            int i5 = i3 / LocalCache.TIME_HOUR;
            sb.setLength(0);
            String formatter2 = formatter.format("%02d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf((i3 / 60) % 60), Integer.valueOf(i4)).toString();
            p.g(formatter2, "formatter.format(\"%02d:%…utes, seconds).toString()");
            AppMethodBeat.o(139655);
            return formatter2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static long abN(java.lang.String r9) {
            /*
            // Method dump skipped, instructions count: 224
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.c.abN(java.lang.String):long");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<AudioManager> {
        final /* synthetic */ b mKU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.mKU = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AudioManager invoke() {
            AppMethodBeat.i(139657);
            AudioManager audioManager = (AudioManager) this.mKU.mKR.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            AppMethodBeat.o(139657);
            return audioManager;
        }
    }

    public static final /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(139671);
        bVar.getRuntime().a(25, -1, bVar.mKO);
        bVar.getRuntime().a(24, -1, bVar.mKP);
        AppMethodBeat.o(139671);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h> {
        final /* synthetic */ b mKU;
        final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a mKV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar, com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a aVar) {
            super(0);
            this.mKU = bVar;
            this.mKV = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h invoke() {
            AppMethodBeat.i(139658);
            com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h hVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h(this.mKU.mKR, this.mKV, this.mKU);
            AppMethodBeat.o(139658);
            return hVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b mKU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar) {
            super(0);
            this.mKU = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            this.mKU.mKM = true;
            return x.SXb;
        }
    }

    public static final /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(139672);
        Context context = bVar.mKR.getContext();
        p.g(context, "invokeContext.context");
        context.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, bVar.mKH);
        AppMethodBeat.o(139672);
    }

    public static final /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(139673);
        bVar.getRuntime().a(bVar.mKO);
        bVar.getRuntime().a(bVar.mKP);
        AppMethodBeat.o(139673);
    }

    public static final /* synthetic */ void f(b bVar) {
        AppMethodBeat.i(139674);
        Context context = bVar.mKR.getContext();
        p.g(context, "invokeContext.context");
        context.getContentResolver().unregisterContentObserver(bVar.mKH);
        AppMethodBeat.o(139674);
    }
}
