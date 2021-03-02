package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.av;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends d<s> {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* bridge */ /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138263);
        a(sVar, jSONObject, i2);
        AppMethodBeat.o(138263);
    }

    public final void a(final s sVar, final JSONObject jSONObject, final int i2) {
        final int cu;
        final int cu2;
        AppMethodBeat.i(177329);
        final ac currentPageView = sVar.getCurrentPageView();
        if (currentPageView != null) {
            final String optString = jSONObject.optString("title");
            final String optString2 = jSONObject.optString("confirmText", sVar.getContext().getString(R.string.ets));
            final String optString3 = jSONObject.optString("cancelText", sVar.getContext().getString(R.string.etq));
            final boolean optBoolean = jSONObject.optBoolean("showCancel", true);
            final boolean optBoolean2 = jSONObject.optBoolean("editable", false);
            if (j.cDv.isDarkMode()) {
                cu = g.cu(jSONObject.optString("confirmColorDark", ""), MMApplicationContext.getContext().getResources().getColor(R.color.g7));
                cu2 = g.cu(jSONObject.optString("cancelColorDark", ""), MMApplicationContext.getContext().getResources().getColor(R.color.fo));
            } else {
                cu = g.cu(jSONObject.optString("confirmColor", ""), MMApplicationContext.getContext().getResources().getColor(R.color.g7));
                cu2 = g.cu(jSONObject.optString("cancelColor", ""), MMApplicationContext.getContext().getResources().getColor(R.color.fo));
            }
            final String optString4 = jSONObject.optString("content");
            Log.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", sVar.getAppId(), optString, optString4);
            sVar.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.t.c.AnonymousClass2 */

                public final void run() {
                    View currentFocus;
                    AppMethodBeat.i(177328);
                    if (!sVar.isRunning()) {
                        AppMethodBeat.o(177328);
                        return;
                    }
                    currentPageView.nqO.a(az.MODAL);
                    final b bVar = new b(sVar.getContext());
                    if (!Util.isNullOrNil(optString)) {
                        if (!Util.isNullOrNil(optString4) || optBoolean2) {
                            bVar.setTitle(optString);
                        } else {
                            bVar.setMessage(optString);
                        }
                    }
                    if (!Util.isNullOrNil(optString4) && !optBoolean2) {
                        bVar.setMessage(optString4);
                    }
                    bVar.a(optString2, true, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.t.c.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(177325);
                            HashMap hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.TRUE);
                            hashMap.put("cancel", Boolean.FALSE);
                            if (optBoolean2) {
                                hashMap.put("content", bVar.hbk());
                            }
                            sVar.i(i2, c.this.n("ok", hashMap));
                            AppMethodBeat.o(177325);
                        }
                    });
                    if (optBoolean) {
                        bVar.b(optString3, false, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.t.c.AnonymousClass2.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(177326);
                                HashMap hashMap = new HashMap();
                                hashMap.put("confirm", Boolean.FALSE);
                                hashMap.put("cancel", Boolean.TRUE);
                                dialogInterface.dismiss();
                                sVar.i(i2, c.this.n("ok", hashMap));
                                AppMethodBeat.o(177326);
                            }
                        });
                    }
                    bVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.t.c.AnonymousClass2.AnonymousClass3 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(177327);
                            HashMap hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.FALSE);
                            hashMap.put("cancel", Boolean.TRUE);
                            sVar.i(i2, c.this.n("ok", hashMap));
                            AppMethodBeat.o(177327);
                        }
                    });
                    bVar.ajL(cu);
                    if (optBoolean) {
                        bVar.ajM(cu2);
                    }
                    if (optBoolean2) {
                        bVar.Dg(true);
                        if (!Util.isNullOrNil(optString4)) {
                            String str = optString4;
                            bVar.mEditText.setVisibility(0);
                            bVar.mEditText.setText(str);
                        } else {
                            String optString = jSONObject.optString("placeholderText");
                            if (!Util.isNullOrNil(optString)) {
                                bVar.ay(optString);
                            }
                        }
                        final u cY = n.cY(currentPageView.getContentView());
                        final a aVar = new a(bVar, currentPageView, (byte) 0);
                        cY.a(aVar);
                        bVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.t.c.AnonymousClass2.AnonymousClass4 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(240899);
                                com.tencent.luggage.h.g.aM(currentPageView.getContext());
                                if (cY != null) {
                                    cY.b(aVar);
                                }
                                AppMethodBeat.o(240899);
                            }
                        });
                    }
                    sVar.getRuntime().jCK.b(bVar);
                    if (optBoolean2) {
                        bVar.mEditText.requestFocus();
                        Context context = currentPageView.getContext();
                        Activity activity = context instanceof Activity ? (Activity) context : null;
                        if (activity == null) {
                            AppMethodBeat.o(177328);
                            return;
                        }
                        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                        if (!(inputMethodManager == null || (currentFocus = activity.getCurrentFocus()) == null || currentFocus.getWindowToken() == null)) {
                            inputMethodManager.toggleSoftInput(0, 2);
                        }
                    }
                    AppMethodBeat.o(177328);
                }
            });
            AppMethodBeat.o(177329);
        } else if (sVar.getRuntime() == null || sVar.getRuntime().isDestroyed() || sVar.getRuntime().mInitialized) {
            Log.w("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", sVar.getAppId(), Integer.valueOf(i2));
            sVar.i(i2, h("fail:page don't exist", null));
            AppMethodBeat.o(177329);
        } else {
            Log.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", sVar.getAppId(), Integer.valueOf(i2));
            sVar.getRuntime().O(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.t.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(138262);
                    Log.i("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", sVar.getAppId(), Integer.valueOf(i2));
                    c.this.a(sVar, jSONObject, i2);
                    AppMethodBeat.o(138262);
                }
            });
            AppMethodBeat.o(177329);
        }
    }

    static final class a implements u.c {
        private boolean crD;
        private final ac cwK;
        private final b mod;
        private int moe;
        private int mof;

        /* synthetic */ a(b bVar, ac acVar, byte b2) {
            this(bVar, acVar);
        }

        private a(b bVar, ac acVar) {
            this.crD = false;
            this.mof = -1;
            this.mod = bVar;
            this.cwK = acVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final void hF(int i2) {
            AppMethodBeat.i(240900);
            Log.d("MicroMsg.JsApiShowModal", "refreshHeight height:%d", Integer.valueOf(i2));
            if (this.moe != i2 && this.crD) {
                o(true, i2);
            }
            this.moe = i2;
            AppMethodBeat.o(240900);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final void bQ(boolean z) {
            AppMethodBeat.i(240901);
            Log.d("MicroMsg.JsApiShowModal", "onKeyboardStateChanged shown:%b, keyboardHeight:%d", Boolean.valueOf(z), Integer.valueOf(this.moe));
            if (z == this.crD) {
                AppMethodBeat.o(240901);
                return;
            }
            this.crD = z;
            o(z, this.moe);
            AppMethodBeat.o(240901);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final int getHeight() {
            return this.moe;
        }

        private void o(boolean z, int i2) {
            AppMethodBeat.i(240902);
            if (!z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mod.getContentView().getLayoutParams();
                layoutParams.addRule(14);
                layoutParams.removeRule(12);
                layoutParams.addRule(13);
                layoutParams.bottomMargin = 0;
                this.mod.getContentView().setLayoutParams(layoutParams);
                AppMethodBeat.o(240902);
                return;
            }
            if (i2 > 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mod.getContentView().getLayoutParams();
                layoutParams2.removeRule(13);
                layoutParams2.addRule(12);
                layoutParams2.addRule(14);
                layoutParams2.bottomMargin = xm(i2);
                this.mod.getContentView().setLayoutParams(layoutParams2);
            }
            AppMethodBeat.o(240902);
        }

        private int xm(int i2) {
            AppMethodBeat.i(240903);
            if (this.mof > 0) {
                int i3 = this.mof;
                AppMethodBeat.o(240903);
                return i3;
            }
            this.mof = ((((ai.f(this.cwK)[1] + i2) - this.cwK.bRi().getHeight()) - av.aD(this.cwK.getContext())) - this.mod.getContentView().getHeight()) / 2;
            if (this.mof <= i2) {
                this.mof = i2 + 12;
            }
            int i4 = this.mof;
            AppMethodBeat.o(240903);
            return i4;
        }
    }
}
