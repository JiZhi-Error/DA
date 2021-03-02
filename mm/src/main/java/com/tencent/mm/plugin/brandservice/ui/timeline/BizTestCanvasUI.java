package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.tencent.magicbrush.aj;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getLayoutId", "", "onClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "JsEngine", "plugin-brandservice_release"})
public final class BizTestCanvasUI extends MMActivity {
    private final String TAG = "MicroMsg.BizTestCanvasUI";
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(195167);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(195167);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(195166);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(195166);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "()V", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush", "()Lcom/tencent/magicbrush/MagicBrush;", "plugin-brandservice_release"})
    public static final class a extends x {
        final e pqH;

        public a() {
            AppMethodBeat.i(195158);
            f fVar = new f();
            fVar.context = MMApplicationContext.getContext();
            fVar.ae(g.bZk());
            fVar.cLK = new C0870a(this);
            fVar.cLJ = new b(this);
            fVar.b(a.b.NativeLocker);
            String aKJ = com.tencent.mm.loader.j.b.aKJ();
            p.g(aKJ, "CConstants.DATAROOT_SDCARD_PATH()");
            fVar.dY(aKJ);
            fVar.ct(false);
            e Rm = fVar.Rm();
            if (Rm == null) {
                p.hyc();
            }
            this.pqH = Rm;
            AppMethodBeat.o(195158);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\bH\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "plugin-brandservice_release"})
        public static final class b implements com.tencent.magicbrush.handler.a {
            final /* synthetic */ a pqI;

            b(a aVar) {
                this.pqI = aVar;
            }

            @Override // com.tencent.magicbrush.handler.a
            public final String LP() {
                AppMethodBeat.i(195153);
                String LP = this.pqI.LP();
                AppMethodBeat.o(195153);
                return LP;
            }

            @Override // com.tencent.magicbrush.handler.a
            public final void a(Runnable runnable, boolean z) {
                AppMethodBeat.i(195154);
                p.h(runnable, "p0");
                this.pqI.a(runnable, z);
                AppMethodBeat.o(195154);
            }

            @Override // com.tencent.magicbrush.handler.a
            public final boolean LO() {
                AppMethodBeat.i(195155);
                IJSRuntime bMz = this.pqI.bMz();
                p.g(bMz, "this@JsEngine.jsRuntime");
                boolean Xw = bMz.Xw();
                AppMethodBeat.o(195155);
                return Xw;
            }

            @Override // com.tencent.magicbrush.handler.a
            public final void resumeLoopTasks() {
                AppMethodBeat.i(195156);
                this.pqI.resumeLoopTasks();
                AppMethodBeat.o(195156);
            }

            @Override // com.tencent.magicbrush.handler.a
            public final boolean doInnerLoopTask() {
                AppMethodBeat.i(195157);
                boolean doInnerLoopTask = this.pqI.doInnerLoopTask();
                AppMethodBeat.o(195157);
                return doInnerLoopTask;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$1"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTestCanvasUI$a$a  reason: collision with other inner class name */
        static final class C0870a extends q implements kotlin.g.a.a<aj> {
            final /* synthetic */ a pqI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0870a(a aVar) {
                super(0);
                this.pqI = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ aj invoke() {
                AppMethodBeat.i(195152);
                aj ajVar = new aj(this.pqI.getIsolatePtr(), this.pqI.XK(), this.pqI.getUVLoopPtr());
                AppMethodBeat.o(195152);
                return ajVar;
            }
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(195164);
        super.onCreate(bundle);
        setMMTitle("调试Canvas");
        a aVar = new a();
        aVar.setJsExceptionHandler(new b("TestCanvas", this));
        aVar.addJavascriptInterface(new c("TestCanvas", this), "console");
        AppCompatActivity context = getContext();
        p.g(context, "context");
        MagicBrushView magicBrushView = new MagicBrushView(context, MagicBrushView.h.TextureView);
        e eVar = aVar.pqH;
        eVar.Rc();
        magicBrushView.setMagicBrush(eVar);
        Log.i(this.TAG, "createCanvasView " + magicBrushView.getVirtualElementId());
        magicBrushView.setOpaque(false);
        magicBrushView.setClipChildren(false);
        magicBrushView.setClipToPadding(false);
        magicBrushView.setEnableTouchEvent(true);
        ((FrameLayout) findViewById(R.id.be3)).addView(magicBrushView, new FrameLayout.LayoutParams(-1, -1));
        o oVar = new o(com.tencent.mm.loader.j.b.aKJ() + "jsengine/test.js");
        if (oVar.exists()) {
            aVar.evaluateJavascript(com.tencent.mm.vfs.p.an(oVar), null);
        } else {
            Log.e(this.TAG, "can not found ".concat(String.valueOf(oVar)));
        }
        setBackBtn(new d(this, aVar));
        AppMethodBeat.o(195164);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$1"})
    static final class b implements h {
        final /* synthetic */ String pqJ;
        final /* synthetic */ BizTestCanvasUI pqK;

        b(String str, BizTestCanvasUI bizTestCanvasUI) {
            this.pqJ = str;
            this.pqK = bizTestCanvasUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.m.h
        public final void u(String str, String str2) {
            AppMethodBeat.i(195159);
            Log.e(this.pqK.TAG, "JsException[" + this.pqJ + "]:" + str + '\n' + str2);
            AppMethodBeat.o(195159);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006J!\u0010\b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$2", "", "error", "", "objects", "", "([Ljava/lang/Object;)V", "info", "log", "plugin-brandservice_release"})
    public static final class c {
        final /* synthetic */ String pqJ;
        final /* synthetic */ BizTestCanvasUI pqK;

        c(String str, BizTestCanvasUI bizTestCanvasUI) {
            this.pqJ = str;
            this.pqK = bizTestCanvasUI;
        }

        @JavascriptInterface
        public final void log(Object... objArr) {
            AppMethodBeat.i(195160);
            p.h(objArr, "objects");
            Log.d(this.pqK.TAG, "JsLog[" + this.pqJ + "]:" + kotlin.a.e.a(objArr, ",\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62));
            AppMethodBeat.o(195160);
        }

        @JavascriptInterface
        public final void info(Object... objArr) {
            AppMethodBeat.i(195161);
            p.h(objArr, "objects");
            Log.i(this.pqK.TAG, "JsInfo[" + this.pqJ + "]:" + kotlin.a.e.a(objArr, ",\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62));
            AppMethodBeat.o(195161);
        }

        @JavascriptInterface
        public final void error(Object... objArr) {
            AppMethodBeat.i(195162);
            p.h(objArr, "objects");
            Log.e(this.pqK.TAG, "JsError[" + this.pqJ + "]:" + kotlin.a.e.a(objArr, ",\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62));
            AppMethodBeat.o(195162);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ BizTestCanvasUI pqK;
        final /* synthetic */ a pqL;

        d(BizTestCanvasUI bizTestCanvasUI, a aVar) {
            this.pqK = bizTestCanvasUI;
            this.pqL = aVar;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(195163);
            this.pqL.destroy();
            this.pqK.finish();
            AppMethodBeat.o(195163);
            return true;
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(195165);
        p.h(view, "view");
        AppMethodBeat.o(195165);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.jp;
    }
}
