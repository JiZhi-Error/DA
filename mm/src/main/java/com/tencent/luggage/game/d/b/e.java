package com.tencent.luggage.game.d.b;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.p;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.g;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends d<s> {
    private static final int CTRL_INDEX = 1;
    private static final String NAME = "showKeyboard";
    final c cwt = new c();
    final a cwu = new a();
    final b cwv = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(130619);
        final s sVar2 = sVar;
        final String optString = jSONObject.optString("defaultValue");
        final int optInt = jSONObject.optInt("maxLength", 140);
        if (optInt <= 0) {
            optInt = Integer.MAX_VALUE;
        }
        final boolean optBoolean = jSONObject.optBoolean("multiple", false);
        final boolean optBoolean2 = jSONObject.optBoolean("confirmHold", false);
        final b aga = b.aga(jSONObject.optString("confirmType"));
        Log.i("MicroMsg.WAGameJsApiShowKeyboard", "defaultValue :%s,finalMaxLength(%d),multiple(%b),confirmHold(%b).", optString, Integer.valueOf(optInt), Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2));
        sVar2.P(new Runnable() {
            /* class com.tencent.luggage.game.d.b.e.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public final void run() {
                ac currentPageView;
                b bVar;
                int i2;
                boolean z;
                int i3;
                AppMethodBeat.i(130611);
                e eVar = e.this;
                s sVar = sVar2;
                String str = optString;
                int i4 = optInt;
                boolean z2 = optBoolean;
                boolean z3 = optBoolean2;
                b bVar2 = aga;
                int i5 = i2;
                if (!sVar.isRunning() || (currentPageView = sVar.getCurrentPageView()) == null) {
                    AppMethodBeat.o(130611);
                    return;
                }
                float density = a.getDensity(currentPageView.getContext());
                com.tencent.luggage.game.widget.input.a ce = com.tencent.luggage.game.widget.input.a.ce(currentPageView.getContentView());
                WAGamePanelInputEditText attachedEditText = ce.getAttachedEditText();
                attachedEditText.setSingleLine(!z2);
                attachedEditText.setMaxLength(i4);
                p.a(attachedEditText).aoq(i4).CN(false).a(f.a.MODE_CHINESE_AS_1).a(new p.a(attachedEditText, sVar) {
                    /* class com.tencent.luggage.game.d.b.e.AnonymousClass2 */
                    final /* synthetic */ s cvO;
                    final /* synthetic */ WAGamePanelInputEditText cwC;

                    {
                        this.cwC = r2;
                        this.cvO = r3;
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a, com.tencent.mm.plugin.appbrand.widget.input.p.a
                    public final void dv(String str) {
                        AppMethodBeat.i(163481);
                        e.this.cwt.a(this.cwC.getEditableText().toString(), this.cvO);
                        AppMethodBeat.o(163481);
                    }
                });
                if (!Util.isNullOrNil(str)) {
                    attachedEditText.setText(str.length() > i4 ? str.substring(0, i4) : str);
                    attachedEditText.setSelection(attachedEditText.getText().length());
                } else {
                    attachedEditText.setText("");
                }
                attachedEditText.addTextChangedListener(new g(sVar) {
                    /* class com.tencent.luggage.game.d.b.e.AnonymousClass3 */
                    final /* synthetic */ s cvO;

                    {
                        this.cvO = r2;
                    }

                    @Override // com.tencent.mm.ui.widget.g
                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.i(130613);
                        if (aj.I(editable)) {
                            AppMethodBeat.o(130613);
                            return;
                        }
                        e.this.cwt.a(editable.toString(), this.cvO);
                        AppMethodBeat.o(130613);
                    }
                });
                attachedEditText.setComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b(attachedEditText, sVar) {
                    /* class com.tencent.luggage.game.d.b.e.AnonymousClass4 */
                    final /* synthetic */ s cvO;
                    final /* synthetic */ WAGamePanelInputEditText cwC;

                    {
                        this.cwC = r2;
                        this.cvO = r3;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.c.b
                    public final void ML() {
                        AppMethodBeat.i(130614);
                        e.this.cwt.a(this.cwC.getEditableText().toString(), this.cvO);
                        AppMethodBeat.o(130614);
                    }
                });
                ce.setOnConfirmClickListener(new View.OnClickListener(attachedEditText, sVar, z3, ce) {
                    /* class com.tencent.luggage.game.d.b.e.AnonymousClass5 */
                    final /* synthetic */ s cvO;
                    final /* synthetic */ WAGamePanelInputEditText cwC;
                    final /* synthetic */ com.tencent.luggage.game.widget.input.a cwD;
                    final /* synthetic */ boolean cwz;

                    {
                        this.cwC = r2;
                        this.cvO = r3;
                        this.cwz = r4;
                        this.cwD = r5;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(130615);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/luggage/game/jsapi/keyboard/WAGameJsApiShowKeyboard$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        e.this.cwv.a(this.cwC.getEditableText().toString(), this.cvO);
                        e.this.cwt.a(this.cwC.getEditableText().toString(), this.cvO);
                        if (!this.cwz) {
                            this.cwD.hide();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/jsapi/keyboard/WAGameJsApiShowKeyboard$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(130615);
                    }
                });
                ce.setOnVisibilityChangedListener(new w.f(attachedEditText, sVar, ce, density, i5) {
                    /* class com.tencent.luggage.game.d.b.e.AnonymousClass6 */
                    final /* synthetic */ s cvO;
                    final /* synthetic */ int cvP;
                    final /* synthetic */ WAGamePanelInputEditText cwC;
                    final /* synthetic */ com.tencent.luggage.game.widget.input.a cwD;
                    final /* synthetic */ float cwE;

                    {
                        this.cwC = r2;
                        this.cvO = r3;
                        this.cwD = r4;
                        this.cwE = r5;
                        this.cvP = r6;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.w.f
                    public final void hJ(int i2) {
                        AppMethodBeat.i(130616);
                        if (2 == i2) {
                            a aVar = e.this.cwu;
                            String obj = this.cwC.getEditableText().toString();
                            s sVar = this.cvO;
                            HashMap hashMap = new HashMap(2);
                            hashMap.put("errMsg", "ok");
                            hashMap.put("value", obj);
                            aVar.L(hashMap).g(sVar).bEo();
                            AppMethodBeat.o(130616);
                            return;
                        }
                        int height = this.cwD.getHeight();
                        Log.i("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", Integer.valueOf(height), Float.valueOf(this.cwE));
                        HashMap hashMap2 = new HashMap(1);
                        hashMap2.put("height", Float.valueOf(((float) height) / this.cwE));
                        this.cvO.i(this.cvP, e.this.n("ok", hashMap2));
                        AppMethodBeat.o(130616);
                    }
                });
                if (!z2) {
                    attachedEditText.setOnEditorActionListener(new TextView.OnEditorActionListener(attachedEditText, sVar, z3) {
                        /* class com.tencent.luggage.game.d.b.e.AnonymousClass7 */
                        final /* synthetic */ s cvO;
                        final /* synthetic */ WAGamePanelInputEditText cwC;
                        final /* synthetic */ boolean cwz;

                        {
                            this.cwC = r2;
                            this.cvO = r3;
                            this.cwz = r4;
                        }

                        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                            AppMethodBeat.i(130617);
                            e.this.cwv.a(this.cwC.getEditableText().toString(), this.cvO);
                            if (this.cwz) {
                                AppMethodBeat.o(130617);
                                return true;
                            }
                            AppMethodBeat.o(130617);
                            return false;
                        }
                    });
                }
                e.b btm = sVar.kEb.getOrientationHandler().btm();
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(sVar.getRuntime().mContext);
                if (btm == e.b.LANDSCAPE_SENSOR || btm == e.b.LANDSCAPE_LOCKED || e.b.LANDSCAPE_LEFT == btm || e.b.LANDSCAPE_RIGHT == btm) {
                    if (castActivityOrNull == null) {
                        i2 = 0;
                    } else {
                        WindowManager windowManager = (WindowManager) castActivityOrNull.getSystemService("window");
                        if (windowManager == null) {
                            Log.e("Luggage.LuggageUIHelper", "getRealBottomHeight, get NULL windowManager");
                            i2 = 0;
                        } else {
                            Display defaultDisplay = windowManager.getDefaultDisplay();
                            Point point = new Point();
                            defaultDisplay.getSize(point);
                            Point az = r.az(castActivityOrNull);
                            int max = Math.max(point.y, point.x);
                            int max2 = Math.max(az.y, az.x);
                            Rect rect = new Rect();
                            if (castActivityOrNull instanceof Activity) {
                                castActivityOrNull.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                                max = Math.max(rect.bottom - rect.top, rect.right - rect.left);
                            }
                            i2 = max2 - max;
                        }
                    }
                    if (i2 > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        int i6 = 0;
                        int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
                        if (identifier > 0) {
                            i6 = Resources.getSystem().getDimensionPixelSize(identifier);
                        }
                        i3 = i6;
                    } else {
                        i3 = 0;
                    }
                    int aP = j.cDv.aP(castActivityOrNull);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ce.cxR.getLayoutParams();
                    Log.i("MicroMsg.WAGameInputPanel", "EditBar setmEditText cutoutHeight(%d),leftMargin(%d).", Integer.valueOf(aP), Integer.valueOf(layoutParams.leftMargin));
                    if (aP > 0) {
                        layoutParams.setMargins(aP, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    } else {
                        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    }
                    ce.cxR.setLayoutParams(layoutParams);
                    a.C0175a aVar = ce.cxQ;
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.cxV.getLayoutParams();
                    Log.i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", Integer.valueOf(i3), Integer.valueOf(layoutParams2.rightMargin));
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, i3 + layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    aVar.cxV.setLayoutParams(layoutParams2);
                }
                if (bVar2 == null) {
                    bVar = b.DONE;
                } else {
                    bVar = bVar2;
                }
                ce.getAttachedEditText().setImeOptions(bVar.oxA);
                ce.getAttachedEditText().setFocusable(true);
                ce.getAttachedEditText().setFocusableInTouchMode(true);
                ce.show();
                switch (bVar) {
                    case DONE:
                        ((Button) ce.cxQ.getConfirmButton()).setText(R.string.a17);
                        AppMethodBeat.o(130611);
                        return;
                    case SEARCH:
                        ((Button) ce.cxQ.getConfirmButton()).setText(R.string.a1_);
                        AppMethodBeat.o(130611);
                        return;
                    case NEXT:
                        ((Button) ce.cxQ.getConfirmButton()).setText(R.string.a19);
                        AppMethodBeat.o(130611);
                        return;
                    case GO:
                        ((Button) ce.cxQ.getConfirmButton()).setText(R.string.a18);
                        AppMethodBeat.o(130611);
                        return;
                    case SEND:
                        ((Button) ce.cxQ.getConfirmButton()).setText(R.string.a1a);
                        break;
                }
                AppMethodBeat.o(130611);
            }
        });
        AppMethodBeat.o(130619);
    }

    public e() {
        AppMethodBeat.i(130618);
        AppMethodBeat.o(130618);
    }
}
