package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.BaseActivity;
import java.util.Arrays;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\nH\u0016J3\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u0012H\u0016J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0016J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\\\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016Jv\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020&2B\u0010\t\u001a>\u0012\u0013\u0012\u00110!¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b('\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0(¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00040\nH\u0016¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "()V", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "Companion", "luggage-wechat-full-sdk_release"})
public class i implements n {
    @Deprecated
    public static final a nzc = new a((byte) 0);

    static {
        AppMethodBeat.i(183076);
        AppMethodBeat.o(183076);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public final void a(Context context, String str, String str2, y yVar, PhoneItem phoneItem, m<? super Boolean, ? super Map<String, String>, x> mVar) {
        AppMethodBeat.i(230137);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(str2, "extDesc");
        p.h(phoneItem, "phoneItem");
        p.h(mVar, "callback");
        new aa(context, str, yVar, str2, phoneItem, new d(mVar)).iv(true);
        AppMethodBeat.o(230137);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$verifyPhoneNumber$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"})
    public static final class d implements aa.b {
        final /* synthetic */ m nzd;

        d(m mVar) {
            this.nzd = mVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.phonenumber.aa.b
        public final void a(boolean z, Map<String, String> map) {
            AppMethodBeat.i(230136);
            p.h(map, "result");
            this.nzd.invoke(Boolean.valueOf(z), map);
            AppMethodBeat.o(230136);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public SpannableString n(Context context, String str, String str2) {
        AppMethodBeat.i(148045);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(str2, "pagePath");
        String string = context.getString(R.string.a2n);
        p.g(string, "context.getString(R.stri…number_expose_slogan_end)");
        ae aeVar = ae.SYK;
        String string2 = context.getString(R.string.a2o);
        p.g(string2, "context.getString(R.stri…mber_expose_slogan_start)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{string}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        SpannableString spannableString = new SpannableString(format);
        AppMethodBeat.o(148045);
        return spannableString;
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public void a(y yVar) {
        AppMethodBeat.i(169644);
        p.h(yVar, "report");
        Log.i("Luggage.FULL.DefaultPhoneNumberLogic", "report:".concat(String.valueOf(yVar)));
        AppMethodBeat.o(169644);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public void dL(Context context) {
        AppMethodBeat.i(148047);
        p.h(context, "context");
        if (context instanceof BaseActivity) {
            AppMethodBeat.o(148047);
        } else {
            AppMethodBeat.o(148047);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public void dM(Context context) {
        AppMethodBeat.i(148048);
        p.h(context, "context");
        if (context instanceof BaseActivity) {
            BaseActivity.showVKB((Activity) context);
            AppMethodBeat.o(148048);
            return;
        }
        AppMethodBeat.o(148048);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public final l a(Context context, String str, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(148049);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(aVar, "onDone");
        s sVar = new s(context, str, aVar);
        AppMethodBeat.o(148049);
        return sVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public final o s(Context context, String str, String str2) {
        AppMethodBeat.i(148050);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(str2, "pagePath");
        w wVar = new w(context, str, str2);
        AppMethodBeat.o(148050);
        return wVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public final void a(Context context, String str, m<? super Integer, ? super Intent, x> mVar) {
        AppMethodBeat.i(148051);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(mVar, "callback");
        f aK = f.aK(context);
        Intent intent = new Intent(context, PhoneNumberAddUI.class);
        intent.putExtra("APPID", str);
        aK.a(intent, new b(mVar));
        AppMethodBeat.o(148051);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    static final class b implements f.b {
        final /* synthetic */ m nzd;

        b(m mVar) {
            this.nzd = mVar;
        }

        @Override // com.tencent.luggage.h.f.b
        public final void a(int i2, Intent intent) {
            AppMethodBeat.i(148043);
            this.nzd.invoke(Integer.valueOf(i2), intent);
            AppMethodBeat.o(148043);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public final void a(Context context, String str, String str2, m<? super Integer, ? super Intent, x> mVar) {
        AppMethodBeat.i(148052);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(str2, "pagePath");
        p.h(mVar, "callback");
        f aK = f.aK(context);
        Intent intent = new Intent(context, PhoneNumberManagerUI.class);
        intent.putExtra("APPID", str);
        intent.putExtra("PAGEPATH", str2);
        aK.a(intent, new c(mVar));
        AppMethodBeat.o(148052);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    static final class c implements f.b {
        final /* synthetic */ m nzd;

        c(m mVar) {
            this.nzd = mVar;
        }

        @Override // com.tencent.luggage.h.f.b
        public final void a(int i2, Intent intent) {
            AppMethodBeat.i(148044);
            this.nzd.invoke(Integer.valueOf(i2), intent);
            AppMethodBeat.o(148044);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.n
    public void a(Context context, kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(148053);
        p.h(context, "context");
        p.h(bVar, "callback");
        bVar.invoke(0);
        AppMethodBeat.o(148053);
    }
}
