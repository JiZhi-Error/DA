package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.view.d;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J%\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "getEditText", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "showEditTextDialog", "text", "", "Companion", "plugin-appbrand-integration_release"})
public final class bb extends d<k> {
    public static final int CTRL_INDEX = 906;
    public static final String NAME = "editTextWithPopForm";
    public static final a lzn = new a((byte) 0);

    static {
        AppMethodBeat.i(228280);
        AppMethodBeat.o(228280);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        public static final b lzo = new b();

        static {
            AppMethodBeat.i(228276);
            AppMethodBeat.o(228276);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228279);
        k kVar2 = kVar;
        if (kVar2 == null) {
            AppMethodBeat.o(228279);
        } else if (jSONObject == null) {
            kVar2.i(i2, "fail:invalid data");
            AppMethodBeat.o(228279);
        } else {
            Log.i("JsApiEditTextWithPopForm", "invoke data:".concat(String.valueOf(jSONObject)));
            String optString = jSONObject.optString("text", "");
            p.g(optString, "text");
            AppBrandRuntime runtime = kVar2.getRuntime();
            p.g(runtime, "env.runtime");
            Activity context = runtime.getContext();
            if (context != null) {
                h.RTc.aV(new c(this, context, optString, kVar2, i2));
            }
            AppMethodBeat.o(228279);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm$showEditTextDialog$1$1"})
    static final class c implements Runnable {
        final /* synthetic */ bb lzp;
        final /* synthetic */ Activity lzq;
        final /* synthetic */ String lzr;
        final /* synthetic */ k lzs;
        final /* synthetic */ int lzt;

        c(bb bbVar, Activity activity, String str, k kVar, int i2) {
            this.lzp = bbVar;
            this.lzq = activity;
            this.lzr = str;
            this.lzs = kVar;
            this.lzt = i2;
        }

        public final void run() {
            AppMethodBeat.i(228278);
            final EditText dK = bb.dK(this.lzq);
            dK.setText(this.lzr);
            f.a aVar = new f.a(this.lzq);
            aVar.aC(this.lzq.getResources().getString(R.string.a1v)).hu(dK);
            aVar.c(new f.c(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bb.c.AnonymousClass1 */
                final /* synthetic */ c lzu;

                {
                    this.lzu = r1;
                }

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(228277);
                    Object systemService = this.lzu.lzq.getSystemService("input_method");
                    if (systemService == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        AppMethodBeat.o(228277);
                        throw tVar;
                    }
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(dK.getWindowToken(), 0);
                    if (z) {
                        this.lzu.lzs.i(this.lzu.lzt, this.lzu.lzp.n("ok", ae.g(s.U("text", dK.getText().toString()))));
                    }
                    Log.i("JsApiEditTextWithPopForm", "dialog click is ok:".concat(String.valueOf(z)));
                    AppMethodBeat.o(228277);
                }
            }).show();
            Log.i("JsApiEditTextWithPopForm", "showEditTextDialog");
            AppMethodBeat.o(228278);
        }
    }

    public static final /* synthetic */ EditText dK(Context context) {
        AppMethodBeat.i(228281);
        EditText editText = new EditText(context);
        editText.setHint(context.getResources().getString(R.string.a1u));
        editText.setGravity(51);
        editText.setTextSize(0, (float) d.e(context, 15.0f));
        editText.setMaxEms(80);
        editText.setMaxLines(2);
        editText.setEllipsize(TextUtils.TruncateAt.END);
        m mVar = m.vVH;
        m.a(editText, null, 80, 40, b.lzo);
        editText.setPadding(editText.getPaddingLeft(), context.getResources().getDimensionPixelOffset(R.dimen.bt), editText.getPaddingRight(), context.getResources().getDimensionPixelOffset(R.dimen.bt));
        editText.setBackgroundColor(context.getResources().getColor(R.color.cq));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        editText.setHeight(d.e(context, 100.0f));
        editText.setLayoutParams(layoutParams);
        AppMethodBeat.o(228281);
        return editText;
    }
}
