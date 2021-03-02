package com.tencent.mm.plugin.appbrand.jsapi.autofill.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u000223J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u000201H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R$\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\r0\"X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\u0012\u0012\u0004\u0012\u00020#0)j\b\u0012\u0004\u0012\u00020#`*X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "phoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showPrivacyExplainEntry", "show", "", "Factory", "FactoryInterface", "luggage-wechat-full-sdk_release"})
public interface a extends h {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
    public interface b extends com.tencent.luggage.a.b {
        a e(d dVar);
    }

    void hm(boolean z);

    void setAppBrandName(String str);

    void setIconUrl(String str);

    void setOnAddPhoneNumber(kotlin.g.a.a<x> aVar);

    void setOnCancel(kotlin.g.a.a<x> aVar);

    void setOnDeny(kotlin.g.a.a<x> aVar);

    void setOnExplain(kotlin.g.a.a<x> aVar);

    void setOnManagePhoneNumber(kotlin.g.a.a<x> aVar);

    void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, x> bVar);

    void setPhoneItems(ArrayList<PhoneItem> arrayList);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a$a  reason: collision with other inner class name */
    public static final class C0643a {
        private static final C0644a lJN = new C0644a();
        public static final C0643a lJO = new C0643a();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a$a$a  reason: collision with other inner class name */
        public static final class C0644a implements b {
            C0644a() {
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.b
            public final a e(d dVar) {
                c cVar;
                AppMethodBeat.i(230079);
                p.h(dVar, "component");
                Context context = dVar.getContext();
                if (context == null) {
                    context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                }
                String appId = dVar.getAppId();
                p.g(appId, "component.appId");
                v vVar = new v(context, appId);
                AppBrandRuntime runtime = dVar.getRuntime();
                if (runtime == null || (cVar = runtime.getWindowAndroid()) == null) {
                    cVar = dVar.getWindowAndroid();
                }
                if (cVar == null) {
                    p.hyc();
                }
                p.g(cVar, "(component.runtime?.wind…omponent.windowAndroid)!!");
                if (!cVar.OD() && cVar.bsj()) {
                    vVar.setPosition(1);
                }
                v vVar2 = vVar;
                AppMethodBeat.o(230079);
                return vVar2;
            }
        }

        static {
            AppMethodBeat.i(230081);
            AppMethodBeat.o(230081);
        }

        private C0643a() {
        }

        public static final a e(d dVar) {
            AppMethodBeat.i(230080);
            p.h(dVar, "component");
            b bVar = (b) dVar.M(b.class);
            if (bVar != null) {
                a e2 = bVar.e(dVar);
                AppMethodBeat.o(230080);
                return e2;
            }
            a e3 = lJN.e(dVar);
            AppMethodBeat.o(230080);
            return e3;
        }
    }
}
