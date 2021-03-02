package com.tencent.mm.plugin.appbrand.permission.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 :2\u00020\u0001:\u0004789:J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010 \u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010#\u001a\u00020\u001d2\b\b\u0001\u0010$\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020%H&J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020+H&J\u0012\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u0003H&J\u0018\u00100\u001a\u00020\u001d2\u000e\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102H&J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u000206H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "iconUrl", "getIconUrl", "setIconUrl", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "getLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "setExplainOnClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "showExplainIv", "show", "", "Factory", "FactoryInterface", "Listener", "ResultCodeEnum", "luggage-wechat-full-sdk_release"})
public interface b extends h {
    public static final d nyx = d.nyA;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.permission.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0781b extends com.tencent.luggage.a.b {
        b a(com.tencent.mm.plugin.appbrand.d dVar, c cVar);
    }

    MotionEvent getLastPointerDownTouchEvent();

    void ia(boolean z);

    void setAppBrandName(String str);

    void setApplyWording(String str);

    void setExplainOnClickListener(View.OnClickListener onClickListener);

    void setFunctionButtonOnClickListener(View.OnClickListener onClickListener);

    void setFunctionButtonText(String str);

    void setFunctionButtonTextColor(int i2);

    void setFunctionButtonVisibility(int i2);

    void setIconUrl(String str);

    void setItemCheckedListener(i.b bVar);

    void setNegativeButtonText(String str);

    void setOnListItemLongClickListener(i.d dVar);

    void setPositiveButtonText(String str);

    void setRequestDesc(String str);

    void setScope(String str);

    void setSelectListItem(List<i.a> list);

    void setSimpleDetailDesc(String str);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$ResultCodeEnum;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
    public static final class d {
        static final /* synthetic */ d nyA = new d();

        static {
            AppMethodBeat.i(230129);
            AppMethodBeat.o(230129);
        }

        private d() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
    public interface c {
        void a(int i2, ArrayList<String> arrayList, int i3);

        @l(hxD = {1, 1, 16})
        public static final class a {
            public static /* synthetic */ void a(c cVar, int i2, ArrayList arrayList) {
                AppMethodBeat.i(230128);
                cVar.a(i2, arrayList, 0);
                AppMethodBeat.o(230128);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private static final C0780a nyy = new C0780a();
        public static final a nyz = new a();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.permission.a.b$a$a  reason: collision with other inner class name */
        public static final class C0780a implements AbstractC0781b {
            C0780a() {
            }

            @Override // com.tencent.mm.plugin.appbrand.permission.a.b.AbstractC0781b
            public final b a(com.tencent.mm.plugin.appbrand.d dVar, c cVar) {
                com.tencent.mm.plugin.appbrand.platform.window.c cVar2;
                com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid;
                AppMethodBeat.i(230125);
                p.h(dVar, "component");
                p.h(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                AppBrandRuntime runtime = dVar.getRuntime();
                if (runtime == null || (windowAndroid = runtime.getWindowAndroid()) == null) {
                    cVar2 = dVar.getWindowAndroid();
                } else {
                    cVar2 = windowAndroid;
                }
                if (cVar2 == null) {
                    p.hyc();
                }
                p.g(cVar2, "(component.runtime?.wind…omponent.windowAndroid)!!");
                boolean OD = cVar2.OD();
                Context context = dVar.getContext();
                if (context == null) {
                    context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                }
                com.tencent.mm.plugin.appbrand.widget.dialog.h hVar = new com.tencent.mm.plugin.appbrand.widget.dialog.h(context, cVar, OD);
                if (!OD && cVar2.bsj()) {
                    hVar.setPosition(1);
                }
                com.tencent.mm.plugin.appbrand.widget.dialog.h hVar2 = hVar;
                AppMethodBeat.o(230125);
                return hVar2;
            }
        }

        static {
            AppMethodBeat.i(230127);
            AppMethodBeat.o(230127);
        }

        private a() {
        }

        public static final b a(com.tencent.mm.plugin.appbrand.d dVar, c cVar) {
            AppMethodBeat.i(230126);
            p.h(dVar, "component");
            p.h(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AbstractC0781b bVar = (AbstractC0781b) dVar.M(AbstractC0781b.class);
            if (bVar != null) {
                b a2 = bVar.a(dVar, cVar);
                AppMethodBeat.o(230126);
                return a2;
            }
            b a3 = nyy.a(dVar, cVar);
            AppMethodBeat.o(230126);
            return a3;
        }
    }
}
