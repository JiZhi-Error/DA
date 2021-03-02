package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "androidOrientation2Orientation", "androidOrientation", "", "Companion", "luggage-commons-jsapi-default-impl_release"})
public final class a implements q {
    public static final C0812a ogC = new C0812a((byte) 0);
    private final Context context;

    static {
        AppMethodBeat.i(193748);
        AppMethodBeat.o(193748);
    }

    public a(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(193747);
        this.context = context2;
        AppMethodBeat.o(193747);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-commons-jsapi-default-impl_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.utils.a$a  reason: collision with other inner class name */
    public static final class C0812a implements q.a {
        private C0812a() {
        }

        public /* synthetic */ C0812a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.q.a
        public final /* synthetic */ q a(h hVar) {
            AppMethodBeat.i(193745);
            a b2 = b(hVar);
            AppMethodBeat.o(193745);
            return b2;
        }

        public static a b(h hVar) {
            Context context;
            AppMethodBeat.i(193744);
            if (hVar == null || (context = hVar.getContext()) == null) {
                context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
            }
            a aVar = new a(context);
            AppMethodBeat.o(193744);
            return aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.q
    public final String getName() {
        return "AndroidOrientationGetter";
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.q
    public final ac bTN() {
        AppMethodBeat.i(193746);
        Resources resources = this.context.getResources();
        p.g(resources, "context.resources");
        switch (resources.getConfiguration().orientation) {
            case 1:
                ac acVar = ac.PORTRAIT;
                AppMethodBeat.o(193746);
                return acVar;
            case 2:
                ac acVar2 = ac.LANDSCAPE;
                AppMethodBeat.o(193746);
                return acVar2;
            default:
                ac acVar3 = ac.UNSPECIFIED;
                AppMethodBeat.o(193746);
                return acVar3;
        }
    }
}
