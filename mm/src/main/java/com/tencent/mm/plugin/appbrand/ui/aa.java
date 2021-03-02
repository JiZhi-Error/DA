package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.ao;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0014R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class aa extends o {
    public static final a nYJ = new a((byte) 0);
    private q kGW;
    private final f nYI = g.ah(new b(this));

    static {
        AppMethodBeat.i(229552);
        AppMethodBeat.o(229552);
    }

    private final b.AnonymousClass1 getKeyEventInterceptor() {
        AppMethodBeat.i(229547);
        b.AnonymousClass1 r0 = (b.AnonymousClass1) this.nYI.getValue();
        AppMethodBeat.o(229547);
        return r0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aa(final Context context, Bitmap bitmap) {
        super(context, bitmap);
        p.h(context, "context");
        p.h(bitmap, "snapshot");
        AppMethodBeat.i(229551);
        setPromptVisible(false);
        final aj ajVar = new aj(context);
        final d dVar = new d(context);
        dVar.addView(ajVar);
        addView(dVar, new FrameLayout.LayoutParams(-1, -2));
        dVar.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            /* class com.tencent.mm.plugin.appbrand.ui.aa.AnonymousClass1 */
            final /* synthetic */ aa nYK;

            {
                this.nYK = r1;
            }

            public final void onViewDetachedFromWindow(View view) {
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.appbrand.ui.aa$1$a */
            static final class a implements View.OnClickListener {
                final /* synthetic */ AnonymousClass1 nYN;

                a(AnonymousClass1 r1) {
                    this.nYN = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(229541);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    q runtime = this.nYN.nYK.getRuntime();
                    if (runtime != null) {
                        runtime.finish();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(229541);
                }
            }

            public final void onViewAttachedToWindow(View view) {
                AppMethodBeat.i(229542);
                ajVar.setCloseButtonClickListener(new a(this));
                ajVar.setMainTitle(context.getString(R.string.p_));
                ajVar.setForegroundStyle(ao.isDarkMode() ? "white" : "black");
                ajVar.setBackgroundColor(android.support.v4.content.b.n(context, R.color.a2r));
                ajVar.setLoadingIconVisibility(true);
                dVar.S(ajVar.getBackgroundColor(), !ao.isDarkMode());
                AppMethodBeat.o(229542);
            }
        });
        AppMethodBeat.o(229551);
    }

    public final q getRuntime() {
        return this.kGW;
    }

    public final void setRuntime(q qVar) {
        AppMethodBeat.i(229548);
        this.kGW = qVar;
        if (qVar != null) {
            qVar.a(4, 1, getKeyEventInterceptor());
            AppMethodBeat.o(229548);
            return;
        }
        AppMethodBeat.o(229548);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab, com.tencent.mm.plugin.appbrand.ui.o
    public final void z(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(229549);
        l.a(this);
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(229549);
            return;
        }
        AppMethodBeat.o(229549);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.o
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(229550);
        super.onDetachedFromWindow();
        q qVar = this.kGW;
        if (qVar != null) {
            qVar.a(getKeyEventInterceptor());
            AppMethodBeat.o(229550);
            return;
        }
        AppMethodBeat.o(229550);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$Companion;", "", "()V", "KEY", "", "setCanShowAlphaCover", "", "can", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<AnonymousClass1> {
        final /* synthetic */ aa nYK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(aa aaVar) {
            super(0);
            this.nYK = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AnonymousClass1 invoke() {
            AppMethodBeat.i(229546);
            AnonymousClass1 r0 = new al(this) {
                /* class com.tencent.mm.plugin.appbrand.ui.aa.b.AnonymousClass1 */
                final /* synthetic */ b nYO;

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke"})
                /* renamed from: com.tencent.mm.plugin.appbrand.ui.aa$b$1$a */
                static final class a extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.luggage.sdk.g.d, x> {
                    final /* synthetic */ AnonymousClass1 nYP;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    a(AnonymousClass1 r2) {
                        super(1);
                        this.nYP = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(com.tencent.luggage.sdk.g.d dVar) {
                        AppMethodBeat.i(229544);
                        com.tencent.luggage.sdk.g.d dVar2 = dVar;
                        p.h(dVar2, "$receiver");
                        dVar2.b(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.appbrand.ui.aa.b.AnonymousClass1.a.AnonymousClass1 */
                            final /* synthetic */ a nYQ;

                            {
                                this.nYQ = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(229543);
                                this.nYQ.nYP.nYO.nYK.z(null);
                                x xVar = x.SXb;
                                AppMethodBeat.o(229543);
                                return xVar;
                            }
                        });
                        x xVar = x.SXb;
                        AppMethodBeat.o(229544);
                        return xVar;
                    }
                }

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.nYO = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.al
                public final boolean c(KeyEvent keyEvent) {
                    AppMethodBeat.i(229545);
                    q runtime = this.nYO.nYK.getRuntime();
                    if (runtime == null) {
                        AppMethodBeat.o(229545);
                        return false;
                    }
                    if (keyEvent != null && 1 == keyEvent.getAction()) {
                        if (runtime.brt()) {
                            com.tencent.luggage.sdk.g.g gVar = com.tencent.luggage.sdk.g.g.cCM;
                            com.tencent.luggage.sdk.g.g.a(runtime, new a(this));
                            runtime.close();
                        } else {
                            runtime.finish();
                        }
                    }
                    AppMethodBeat.o(229545);
                    return true;
                }
            };
            AppMethodBeat.o(229546);
            return r0;
        }
    }

    public static final void setCanShowAlphaCover(boolean z) {
        AppMethodBeat.i(229553);
        MultiProcessMMKV VQ = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
        if (VQ != null) {
            VQ.putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", z);
            AppMethodBeat.o(229553);
            return;
        }
        AppMethodBeat.o(229553);
    }
}
