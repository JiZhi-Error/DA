package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.DialogInterface;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends d<ac> {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";
    j lID;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147159);
        final ac acVar2 = acVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            acVar2.i(i2, h("fail:data is invalid", null));
            AppMethodBeat.o(147159);
            return;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray(GraphRequest.FIELDS_PARAM);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                linkedList.add(optJSONArray.optString(i3));
            }
        }
        final String optString = jSONObject.optString("wording");
        final int optInt = jSONObject.optInt("authStatus", 2);
        int optInt2 = jSONObject.optInt("clientVersion", 0);
        String appId = acVar2.getAppId();
        Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s, clientVersion:%s", appId, Integer.valueOf(optInt2));
        Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording:%s, authStatus:%d, fieldIds:%s", optString, Integer.valueOf(optInt), optJSONArray);
        final hl hlVar = new hl();
        hlVar.KLt = linkedList;
        hlVar.dNI = appId;
        hlVar.KLv = optInt;
        hlVar.KFC = optInt2;
        if (optInt2 == 1) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(147154);
                    g gVar = g.this;
                    ac acVar = acVar2;
                    int i2 = i2;
                    hl hlVar = hlVar;
                    String str = optString;
                    View inflate = ((LayoutInflater) acVar.getContext().getSystemService("layout_inflater")).inflate(R.layout.d9, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.wf);
                    Button button = (Button) inflate.findViewById(R.id.we);
                    Button button2 = (Button) inflate.findViewById(R.id.wg);
                    textView.setText(Html.fromHtml(str));
                    SpannableString spannableString = new SpannableString(textView.getText());
                    URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
                    for (URLSpan uRLSpan : uRLSpanArr) {
                        int spanStart = spannableString.getSpanStart(uRLSpan);
                        int spanEnd = spannableString.getSpanEnd(uRLSpan);
                        spannableString.removeSpan(uRLSpan);
                        spannableString.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, 0);
                    }
                    textView.setText(spannableString);
                    textView.setMovementMethod(new k(acVar) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass3 */
                        final /* synthetic */ ac lIf;

                        {
                            this.lIf = r2;
                        }

                        @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.k
                        public final void Zr(String str) {
                            AppMethodBeat.i(229892);
                            Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, onLinkClick url:%s", str);
                            c cVar = new c();
                            cVar.url = str;
                            ac acVar = this.lIf;
                            HashMap hashMap = new HashMap();
                            hashMap.put("url", cVar.url);
                            Log.i("MicroMsg.JsApiEventTextViewLinkClick", "onTextViewLinkClick, url:%s", cVar.url);
                            cVar.L(hashMap).h(acVar).bEo();
                            AppMethodBeat.o(229892);
                        }
                    });
                    button.setOnClickListener(new View.OnClickListener(hlVar, acVar, i2) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass4 */
                        final /* synthetic */ int cvP;
                        final /* synthetic */ hl lIE;
                        final /* synthetic */ ac lIf;

                        {
                            this.lIE = r2;
                            this.lIf = r3;
                            this.cvP = r4;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(229893);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, acceptButton");
                            this.lIE.KLu = true;
                            this.lIf.i(this.cvP, g.this.h("ok", null));
                            g.a(g.this, this.lIf, this.lIE);
                            g.a(g.this);
                            a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(229893);
                        }
                    });
                    button2.setOnClickListener(new View.OnClickListener(hlVar, acVar, i2) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass5 */
                        final /* synthetic */ int cvP;
                        final /* synthetic */ hl lIE;
                        final /* synthetic */ ac lIf;

                        {
                            this.lIE = r2;
                            this.lIf = r3;
                            this.cvP = r4;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(229894);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, rejectButton");
                            this.lIE.KLu = false;
                            this.lIf.i(this.cvP, g.this.h("cancel", null));
                            g.a(g.this, this.lIf, this.lIE);
                            g.a(g.this);
                            a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(229894);
                        }
                    });
                    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, show the new bottom dialog!");
                    gVar.lID = new j(acVar.getContext());
                    gVar.lID.setContentView(inflate);
                    gVar.lID.setCancelable(false);
                    gVar.lID.setCanceledOnTouchOutside(false);
                    e eVar = acVar.getRuntime().kAv;
                    if (eVar != null) {
                        eVar.b(gVar.lID);
                    }
                    AppMethodBeat.o(147154);
                }
            });
            AppMethodBeat.o(147159);
            return;
        }
        final LinkedList linkedList2 = new LinkedList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("authGroupList");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                linkedList2.add("  " + optJSONArray2.optString(i4));
            }
        }
        if (linkedList.size() == 0) {
            Log.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            acVar2.i(i2, h("fail:fields is empty", null));
            AppMethodBeat.o(147159);
        } else if (TextUtils.isEmpty(optString)) {
            Log.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            acVar2.i(i2, h("fail:wording is empty", null));
            AppMethodBeat.o(147159);
        } else {
            if (jSONObject.optJSONArray("authGroupList") != null) {
                Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", jSONObject.optJSONArray("authGroupList").toString());
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass2 */

                public final void run() {
                    String string;
                    AppMethodBeat.i(229891);
                    g gVar = g.this;
                    ac acVar = acVar2;
                    int i2 = i2;
                    hl hlVar = hlVar;
                    int i3 = optInt;
                    String str = optString;
                    LinkedList linkedList = linkedList2;
                    if (i3 == 2) {
                        string = acVar.getContext().getString(R.string.in);
                    } else {
                        string = acVar.getContext().getString(R.string.f3154io);
                    }
                    String string2 = acVar.getContext().getString(R.string.ip);
                    String string3 = acVar.getContext().getString(R.string.im);
                    String string4 = acVar.getContext().getString(R.string.il);
                    LayoutInflater layoutInflater = (LayoutInflater) acVar.getContext().getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(R.layout.db, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.ne);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.nf);
                    ((TextView) inflate.findViewById(R.id.nd)).setText(str);
                    textView.setText(string4);
                    textView.setOnClickListener(new View.OnClickListener(acVar) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass6 */
                        final /* synthetic */ ac lIf;

                        {
                            this.lIf = r2;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(229895);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
                            String str = this.lIf.getContext().getString(R.string.iq) + LocaleUtil.getApplicationLanguage();
                            Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(str)));
                            ((ag) this.lIf.M(ag.class)).a(this.lIf.getContext(), str, null);
                            a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(229895);
                        }
                    });
                    linearLayout.removeAllViews();
                    if (linkedList == null || linkedList.size() <= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                        layoutParams.leftMargin = 0;
                        textView.setLayoutParams(layoutParams);
                        linearLayout.setVisibility(8);
                    } else {
                        linearLayout.setVisibility(0);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.d6, (ViewGroup) null);
                            textView2.setText((String) it.next());
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams2.bottomMargin = acVar.getContentView().getResources().getDimensionPixelOffset(R.dimen.p1);
                            textView2.setLayoutParams(layoutParams2);
                            linearLayout.addView(textView2);
                        }
                    }
                    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
                    new d.a(acVar.getContext()).bon(string).hs(inflate).Dl(false).Dk(false).bou(string2).c(new DialogInterface.OnClickListener(hlVar, acVar, i2) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass8 */
                        final /* synthetic */ int cvP;
                        final /* synthetic */ hl lIE;
                        final /* synthetic */ ac lIf;

                        {
                            this.lIE = r2;
                            this.lIf = r3;
                            this.cvP = r4;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(229897);
                            Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
                            this.lIE.KLu = true;
                            this.lIf.i(this.cvP, g.this.h("ok", null));
                            g.a(g.this, this.lIf, this.lIE);
                            AppMethodBeat.o(229897);
                        }
                    }).bov(string3).d(new DialogInterface.OnClickListener(hlVar, acVar, i2) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass7 */
                        final /* synthetic */ int cvP;
                        final /* synthetic */ hl lIE;
                        final /* synthetic */ ac lIf;

                        {
                            this.lIE = r2;
                            this.lIf = r3;
                            this.cvP = r4;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(229896);
                            Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
                            this.lIE.KLu = false;
                            this.lIf.i(this.cvP, g.this.h("cancel", null));
                            g.a(g.this, this.lIf, this.lIE);
                            AppMethodBeat.o(229896);
                        }
                    }).hbn().show();
                    AppMethodBeat.o(229891);
                }
            });
            AppMethodBeat.o(147159);
        }
    }

    static /* synthetic */ void a(g gVar, ac acVar, hl hlVar) {
        AppMethodBeat.i(229899);
        acVar.getAppId();
        ((c) acVar.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", hlVar, hm.class).c(new com.tencent.mm.vending.c.a<Object, hm>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.g.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(hm hmVar) {
                AppMethodBeat.i(229898);
                hm hmVar2 = hmVar;
                if (hmVar2 == null) {
                    Log.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, null response");
                    AppMethodBeat.o(229898);
                } else if (hmVar2.BaseResponse.Ret != 0) {
                    Log.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(hmVar2.BaseResponse.Ret), hmVar2.BaseResponse.ErrMsg);
                    AppMethodBeat.o(229898);
                } else {
                    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                    AppMethodBeat.o(229898);
                }
                return null;
            }
        });
        AppMethodBeat.o(229899);
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(229900);
        if (gVar.lID != null) {
            gVar.lID.dismiss();
            gVar.lID = null;
        }
        AppMethodBeat.o(229900);
    }
}
