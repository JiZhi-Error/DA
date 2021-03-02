package com.tencent.mm.plugin.appbrand.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a {
    public static final C0803a nZe = new C0803a((byte) 0);

    static {
        AppMethodBeat.i(180690);
        AppMethodBeat.o(180690);
    }

    public static final void a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(180691);
        C0803a.a(context, onClickListener, onClickListener2, onCancelListener);
        AppMethodBeat.o(180691);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper$Companion;", "", "()V", "showCloseAuthorizeAlert", "", "cxt", "Landroid/content/Context;", "onPositiveClick", "Landroid/content/DialogInterface$OnClickListener;", "onNegativeCLick", "onCancelCLick", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.a.a$a  reason: collision with other inner class name */
    public static final class C0803a {
        private C0803a() {
        }

        public /* synthetic */ C0803a(byte b2) {
            this();
        }

        public static void a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
            AppMethodBeat.i(180689);
            p.h(context, "cxt");
            p.h(onClickListener, "onPositiveClick");
            p.h(onClickListener2, "onNegativeCLick");
            p.h(onCancelListener, "onCancelCLick");
            d.a aVar = new d.a(context);
            aVar.boo(context.getString(R.string.ii));
            aVar.bou(context.getString(R.string.ih));
            aVar.c(onClickListener);
            aVar.bov(context.getString(R.string.sz));
            aVar.d(onClickListener2);
            aVar.f(onCancelListener);
            d hbn = aVar.hbn();
            hbn.setCanceledOnTouchOutside(false);
            hbn.show();
            AppMethodBeat.o(180689);
        }
    }
}
