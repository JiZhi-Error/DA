package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.fts.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.LogStateTransitionState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.ui.tools.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI extends BaseSOSWebViewUI {
    private View Bnt;
    private boolean Gky = false;
    boolean IEm;
    private int IEn;
    private WebViewKeyboardLinearLayout JnT;
    private View JnU;
    private View JnV;
    private TextView JnW;
    private b JnX;
    private c JnY;
    private d JnZ;
    private float Joa = 0.0f;
    private float Job = 0.0f;
    private View Joc;
    private b Jod;
    private int Joe;
    private int Jof = 0;
    private String Jog = "";
    private int Joh = 0;
    private int Joi = 0;
    private String Joj = "";
    private boolean Jok;
    private a Jol = a.Back;
    private a.AbstractC1990a Jom = new a.AbstractC1990a() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass14 */

        @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a.AbstractC1990a
        public final void onAnimationEnd() {
            AppMethodBeat.i(80633);
            FTSSOSHomeWebViewUI.this.Jod.sendMessage(4);
            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(80633);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a.AbstractC1990a
        public final void onAnimationStart() {
            AppMethodBeat.i(80634);
            FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(80634);
        }
    };
    private a.AbstractC1990a Jon = new a.AbstractC1990a() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a.AbstractC1990a
        public final void onAnimationEnd() {
            AppMethodBeat.i(80621);
            FTSSOSHomeWebViewUI.this.Jod.sendMessage(9);
            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(80621);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a.AbstractC1990a
        public final void onAnimationStart() {
            AppMethodBeat.i(80622);
            FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(80622);
        }
    };
    private a.AbstractC1990a Joo = new a.AbstractC1990a() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a.AbstractC1990a
        public final void onAnimationEnd() {
            AppMethodBeat.i(80623);
            FTSSOSHomeWebViewUI.this.Jod.sendMessage(3);
            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(80623);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a.AbstractC1990a
        public final void onAnimationStart() {
            AppMethodBeat.i(80624);
            FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(80624);
        }
    };
    private String Jop;
    private int Joq;
    private View.OnClickListener Jor = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(211245);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(211245);
        }
    };
    private View nmd;
    private View tql;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSSOSHomeWebViewUI() {
        AppMethodBeat.i(80651);
        AppMethodBeat.o(80651);
    }

    static /* synthetic */ void a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i2, boolean z) {
        AppMethodBeat.i(211285);
        fTSSOSHomeWebViewUI.bt(i2, z);
        AppMethodBeat.o(211285);
    }

    static /* synthetic */ void b(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i2, boolean z) {
        AppMethodBeat.i(211286);
        fTSSOSHomeWebViewUI.bt(i2, z);
        AppMethodBeat.o(211286);
    }

    static /* synthetic */ void c(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i2, boolean z) {
        AppMethodBeat.i(211287);
        fTSSOSHomeWebViewUI.bt(i2, z);
        AppMethodBeat.o(211287);
    }

    static /* synthetic */ void j(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(211283);
        fTSSOSHomeWebViewUI.zm(true);
        AppMethodBeat.o(211283);
    }

    static /* synthetic */ void m(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(211284);
        fTSSOSHomeWebViewUI.agV(0);
        AppMethodBeat.o(211284);
    }

    static /* synthetic */ void v(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(211288);
        fTSSOSHomeWebViewUI.fzW();
        AppMethodBeat.o(211288);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        Back,
        cancel;

        public static a valueOf(String str) {
            AppMethodBeat.i(211254);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(211254);
            return aVar;
        }

        static {
            AppMethodBeat.i(211255);
            AppMethodBeat.o(211255);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(80652);
        super.onCreate(bundle);
        this.Jod = new b("sos_home_webview_ui", getMainLooper());
        this.tql = findViewById(R.id.iq5);
        this.Joc = findViewById(R.id.iq6);
        this.JnU = findViewById(R.id.be3);
        this.nmd = findViewById(R.id.ir6);
        this.JnT = (WebViewKeyboardLinearLayout) findViewById(R.id.jkw);
        this.JnW = (TextView) findViewById(R.id.dp_);
        this.JnV = findViewById(R.id.i2k);
        this.JnT.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.KeyboardLinearLayout.a
            public final void Ns(int i2) {
                AppMethodBeat.i(80620);
                if (i2 == -2) {
                    FTSSOSHomeWebViewUI.this.Jod.sendMessage(12);
                }
                FTSSOSHomeWebViewUI.this.JjT = i2;
                AppMethodBeat.o(80620);
            }
        });
        this.JnX = new b(this, this.Jnb, this.nmd, ggL().getIconView(), this.hNZ, this.hNZ, ggL().getEditText(), this.tql, this.Joc);
        this.JnX.a(this.Jom);
        this.JnY = new c(this, this.Jnb, this.nmd, ggL().getIconView(), this.hNZ, this.hNZ, ggL().getEditText(), this.tql, this.Joc);
        this.JnY.a(this.Joo);
        this.JnZ = new d(this, this.Jnb, this.nmd, ggL().getIconView(), this.hNZ, this.hNZ, ggL().getEditText(), this.tql, this.Joc);
        this.JnZ.a(this.Jon);
        this.Bnt = findViewById(R.id.i2l);
        findViewById(R.id.bex).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(211247);
                FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
                FTSSOSHomeWebViewUI.this.hideVKB();
                AppMethodBeat.o(211247);
                return false;
            }
        });
        this.Joe = com.tencent.mm.cb.a.fromDPToPix((Context) this, 24);
        ggL().fYP();
        ggL().gWY();
        this.Jnd = getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false);
        if (getIntent() == null || !getIntent().getBooleanExtra("hideSearchInput", false)) {
            z = false;
        } else {
            z = true;
        }
        this.IEm = z;
        this.IEn = getIntent().getIntExtra("key_back_btn_type", 0);
        if (this.Jod != null) {
            if (this.Jnd) {
                this.Jnb.setVisibility(0);
                this.Joc.setBackgroundColor(getResources().getColor(R.color.ac_));
                b bVar = this.Jod;
                bVar.setInitialState(bVar.JoA);
                if (d.oD(23) && !g.isMIUIV8()) {
                    int color = getResources().getColor(R.color.afz);
                    if (!ao.isDarkMode()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    bt(color, z2);
                }
            } else {
                this.Jod.ggX();
            }
            this.Jod.start();
        }
        if (this.IEn == 1) {
            if (ao.isDarkMode()) {
                this.hNZ.setImageDrawable(ar.m(this, R.raw.icons_outlined_close, -1));
            } else {
                this.hNZ.setImageDrawable(ar.m(this, R.raw.icons_outlined_close, WebView.NIGHT_MODE_COLOR));
            }
        } else if (this.IEn == 2) {
            this.hNZ.setVisibility(8);
            this.Joe = 0;
        }
        com.tencent.mm.plugin.websearch.api.ar.afz(getScene());
        ggV();
        this.Jnb.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(211248);
                FTSSOSHomeWebViewUI.this.Joa = FTSSOSHomeWebViewUI.this.Jnb.getX();
                FTSSOSHomeWebViewUI.this.Job = FTSSOSHomeWebViewUI.this.Jnb.getY();
                Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getSearchInputLayout originInputX=%s originInputY=%s", Float.valueOf(FTSSOSHomeWebViewUI.this.Joa), Float.valueOf(FTSSOSHomeWebViewUI.this.Job));
                AppMethodBeat.o(211248);
            }
        }, 100);
        this.Jnc.setVoiceBtnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass9 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(211249);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
                Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), FTSSOSHomeWebViewUI.this);
                if (!a2) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211249);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("sessionId", FTSSOSHomeWebViewUI.this.sessionId);
                intent.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.dVO);
                intent.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
                if (FTSSOSHomeWebViewUI.this.ggO()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                intent.putExtra("key_is_nav_voice", i2);
                c.c(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", intent, 1);
                FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(211249);
            }
        });
        this.Jnc.setCancelTextViewClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(80628);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FTSSOSHomeWebViewUI.this.ggF();
                FTSSOSHomeWebViewUI.this.ggR();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(80628);
            }
        });
        agU(getType());
        ImageButton clearBtn = ggL().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(getResources().getColor(R.color.FG_0), PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(80652);
    }

    private boolean ggU() {
        return this.scene == 36;
    }

    private void ggV() {
        AppMethodBeat.i(80654);
        if (this.pGj == null) {
            AppMethodBeat.o(80654);
            return;
        }
        final View view = this.pGj.getView();
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass11 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(211250);
                FTSSOSHomeWebViewUI.this.ggR();
                if (FTSSOSHomeWebViewUI.this.Jod != null) {
                    FTSSOSHomeWebViewUI.this.Jod.sendMessage(15, motionEvent);
                }
                boolean onTouchEvent = view.onTouchEvent(motionEvent);
                AppMethodBeat.o(211250);
                return onTouchEvent;
            }
        });
        AppMethodBeat.o(80654);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(80655);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("text");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        String baE = baE(stringExtra);
                        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", Integer.valueOf(baE.length()), baE);
                        this.Jnc.O(baE, null);
                        awE();
                        AppMethodBeat.o(80655);
                        return;
                    }
                }
                AppMethodBeat.o(80655);
                return;
            default:
                AppMethodBeat.o(80655);
                return;
        }
    }

    private static String baE(String str) {
        AppMethodBeat.i(80656);
        if (str != null) {
            try {
                if (f.bnP(str) <= 100) {
                    AppMethodBeat.o(80656);
                    return str;
                }
                if (str.length() > 200) {
                    str = str.substring(0, 200);
                }
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i2 < length) {
                    i4 += f.bnP(String.valueOf(charArray[i2]));
                    if (i4 >= 100) {
                        String str2 = str.substring(0, i3) + (char) 8230;
                        AppMethodBeat.o(80656);
                        return str2;
                    }
                    i2++;
                    i3++;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(80656);
                return str;
            }
        }
        AppMethodBeat.o(80656);
        return str;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(80657);
        super.onResume();
        com.tencent.mm.plugin.websearch.api.ar.fYm();
        AppMethodBeat.o(80657);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
    public final void bXg() {
        AppMethodBeat.i(80653);
        super.bXg();
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "searchID");
            this.Jog = this.mHh.u(6, bundle).getString("result");
        } catch (Exception e2) {
        }
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putString("key", "educationTab");
            Bundle u = this.mHh.u(2, bundle2);
            String string = u.getString("result");
            String string2 = u.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            JSONObject jSONObject = new JSONObject(string);
            final JSONArray optJSONArray = jSONObject.optJSONArray("items");
            final String optString = jSONObject.optString("title");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray("[{\"businessType\":8,\"hotword\":\"朋友圈\",\"optype\":5},{\"businessType\":2,\"hotword\":\"文章\",\"optype\":5},{\"businessType\":1,\"hotword\":\"公众号\",\"optype\":5}]");
            }
            aD(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(211252);
                    h jsapi = FTSSOSHomeWebViewUI.this.getJsapi();
                    JSONArray jSONArray = optJSONArray;
                    String str = optString;
                    if (!jsapi.GBl) {
                        Log.e("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData fail, not ready");
                        AppMethodBeat.o(211252);
                        return;
                    }
                    Log.i("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData success, ready");
                    HashMap hashMap = new HashMap();
                    hashMap.put("items", jSONArray);
                    hashMap.put("title", str);
                    MMHandlerThread.postToMainThread(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE  
                          (wrap: com.tencent.mm.plugin.webview.d.h$45 : 0x0048: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$45) = 
                          (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h)
                          (wrap: java.lang.String : 0x0042: INVOKE  (r1v3 java.lang.String) = 
                          ("onGetVertSearchEntriesData")
                          (r3v2 'hashMap' java.util.HashMap)
                          (wrap: boolean : 0x003e: IGET  (r2v1 boolean) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                          (wrap: java.lang.String : 0x0040: IGET  (r4v2 java.lang.String) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                         call: com.tencent.mm.plugin.webview.d.h.45.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.13.run():void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0048: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$45) = 
                          (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h)
                          (wrap: java.lang.String : 0x0042: INVOKE  (r1v3 java.lang.String) = 
                          ("onGetVertSearchEntriesData")
                          (r3v2 'hashMap' java.util.HashMap)
                          (wrap: boolean : 0x003e: IGET  (r2v1 boolean) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                          (wrap: java.lang.String : 0x0040: IGET  (r4v2 java.lang.String) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                         call: com.tencent.mm.plugin.webview.d.h.45.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.13.run():void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 18 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 24 more
                        */
                    /*
                        this = this;
                        r5 = 211252(0x33934, float:2.96027E-40)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                        com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.this
                        com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                        org.json.JSONArray r1 = r0
                        java.lang.String r2 = r1
                        boolean r3 = r0.GBl
                        if (r3 != 0) goto L_0x0021
                        java.lang.String r0 = "MicroMsg.JsApiHandler"
                        java.lang.String r1 = "onGetVertSearchEntriesData fail, not ready"
                        com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                    L_0x0020:
                        return
                    L_0x0021:
                        java.lang.String r3 = "MicroMsg.JsApiHandler"
                        java.lang.String r4 = "onGetVertSearchEntriesData success, ready"
                        com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                        java.util.HashMap r3 = new java.util.HashMap
                        r3.<init>()
                        java.lang.String r4 = "items"
                        r3.put(r4, r1)
                        java.lang.String r1 = "title"
                        r3.put(r1, r2)
                        java.lang.String r1 = "onGetVertSearchEntriesData"
                        boolean r2 = r0.IRj
                        java.lang.String r4 = r0.zpY
                        java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r1, r3, r2, r4)
                        com.tencent.mm.plugin.webview.d.h$45 r2 = new com.tencent.mm.plugin.webview.d.h$45
                        r2.<init>(r1)
                        com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                        goto L_0x0020
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass13.run():void");
                }
            });
        } catch (Exception e3) {
        }
        this.tql.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(211251);
                if (FTSSOSHomeWebViewUI.this.Jnb.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    FTSSOSHomeWebViewUI.this.Joh = ((RelativeLayout.LayoutParams) FTSSOSHomeWebViewUI.this.Jnb.getLayoutParams()).topMargin;
                }
                AppMethodBeat.o(211251);
            }
        });
        AppMethodBeat.o(80653);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(80658);
        super.onPause();
        com.tencent.mm.plugin.websearch.api.ar.fYn();
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
            ((com.tencent.mm.plugin.ball.c.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class)).d(105, false, false);
        }
        AppMethodBeat.o(80658);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(80659);
        super.onDestroy();
        com.tencent.mm.plugin.websearch.api.ar.fYo();
        com.tencent.mm.plugin.websearch.api.ar.fYp();
        AppMethodBeat.o(80659);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
    public final Map<String, Object> ggW() {
        AppMethodBeat.i(80660);
        HashMap hashMap = new HashMap();
        if (this.tql == null) {
            AppMethodBeat.o(80660);
            return hashMap;
        }
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getOnUiInitParams");
        hashMap.put("nativeHeight", 0);
        try {
            Bundle u = this.mHh.u(7, null);
            String string = u == null ? "" : u.getString("data");
            if (!TextUtils.isEmpty(string)) {
                hashMap.put("operationData", string);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", e2, "", new Object[0]);
        }
        String stringExtra = getIntent().getStringExtra("first_page_result");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        hashMap.put("cachePageResult", stringExtra);
        AppMethodBeat.o(80660);
        return hashMap;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final int bXh() {
        boolean z = false;
        AppMethodBeat.i(80661);
        if (getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false)) {
            z = true;
        }
        this.Jnd = z;
        if (!d.oD(23) || MIUI.isMIUIV8()) {
            int bXh = super.bXh();
            AppMethodBeat.o(80661);
            return bXh;
        } else if (this.Jnd) {
            AppMethodBeat.o(80661);
            return -1;
        } else {
            int color = getResources().getColor(R.color.afd);
            AppMethodBeat.o(80661);
            return color;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(80662);
        if (this.Jod == null) {
            AppMethodBeat.o(80662);
            return;
        }
        if (this.Jod.ggO()) {
            super.eh(z);
        }
        this.Jod.sendMessage(5);
        AppMethodBeat.o(80662);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
    public final void ggE() {
        AppMethodBeat.i(80663);
        super.ggE();
        ggL().setHint(agT(this.JnE));
        AppMethodBeat.o(80663);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(164033);
        if (bVar == FTSEditTextView.b.UserInput) {
            this.Joq = 0;
        }
        super.a(str, str2, list, bVar);
        AppMethodBeat.o(164033);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
    public final void ggD() {
        AppMethodBeat.i(80666);
        super.ggD();
        this.Jod.sendMessage(11);
        AppMethodBeat.o(80666);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
    public final int ggK() {
        return this.Joq;
    }

    private boolean a(a aVar) {
        boolean z;
        AppMethodBeat.i(211268);
        if (this.Gky) {
            fzW();
            fyl();
        }
        if (aVar != a.Back || !ggC()) {
            if (this.Jok && super.getJsapi() != null) {
                h jsapi = super.getJsapi();
                if (!jsapi.GBl) {
                    Log.e("MicroMsg.JsApiHandler", "onClientNavAction fail, not ready");
                    z = false;
                } else {
                    Log.i("MicroMsg.JsApiHandler", "onClientNavAction success, ready");
                    HashMap hashMap = new HashMap();
                    hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "willExitSearch");
                    MMHandlerThread.postToMainThread(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006c: INVOKE  
                          (wrap: com.tencent.mm.plugin.webview.d.h$42 : 0x0069: CONSTRUCTOR  (r4v3 com.tencent.mm.plugin.webview.d.h$42) = 
                          (r2v4 'jsapi' com.tencent.mm.plugin.webview.d.h)
                          (wrap: java.lang.String : 0x0063: INVOKE  (r3v2 java.lang.String) = 
                          ("onClientNavAction")
                          (r4v2 'hashMap' java.util.HashMap)
                          (wrap: boolean : 0x005f: IGET  (r5v2 boolean) = (r2v4 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                          (wrap: java.lang.String : 0x0061: IGET  (r6v0 java.lang.String) = (r2v4 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                         call: com.tencent.mm.plugin.webview.d.h.42.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a(com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a):boolean, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0069: CONSTRUCTOR  (r4v3 com.tencent.mm.plugin.webview.d.h$42) = 
                          (r2v4 'jsapi' com.tencent.mm.plugin.webview.d.h)
                          (wrap: java.lang.String : 0x0063: INVOKE  (r3v2 java.lang.String) = 
                          ("onClientNavAction")
                          (r4v2 'hashMap' java.util.HashMap)
                          (wrap: boolean : 0x005f: IGET  (r5v2 boolean) = (r2v4 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                          (wrap: java.lang.String : 0x0061: IGET  (r6v0 java.lang.String) = (r2v4 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                         call: com.tencent.mm.plugin.webview.d.h.42.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a(com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a):boolean, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 31 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 37 more
                        */
                    /*
                    // Method dump skipped, instructions count: 117
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a(com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a):boolean");
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final void fzm() {
                    AppMethodBeat.i(211269);
                    if (ggC() || !a(a.Back)) {
                        super.fzm();
                        AppMethodBeat.o(211269);
                        return;
                    }
                    AppMethodBeat.o(211269);
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final void ggF() {
                    AppMethodBeat.i(80667);
                    if (this.Jof > 0) {
                        AppMethodBeat.o(80667);
                    } else if (a(a.cancel)) {
                        AppMethodBeat.o(80667);
                    } else {
                        super.ggF();
                        this.pGj.scrollTo(0, 0);
                        agU(0);
                        ggL().gWY();
                        ggL().setHint(getHint());
                        this.Jod.sendMessage(2);
                        this.Jnb.setBackgroundResource(R.drawable.awd);
                        agV(8);
                        this.Jop = null;
                        this.Joq = 0;
                        this.JnU.setVisibility(0);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15521, Integer.valueOf(this.scene), 1, ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.JnE));
                        AppMethodBeat.o(80667);
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final void ggG() {
                    AppMethodBeat.i(211270);
                    zm(true);
                    AppMethodBeat.o(211270);
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final void ggH() {
                    AppMethodBeat.i(80668);
                    super.ggH();
                    zm(true);
                    if (getScene() == 67 || getScene() == 81) {
                        y(10, getIntent().getStringExtra("sessionId"), getScene());
                    }
                    AppMethodBeat.o(80668);
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final void ggI() {
                    AppMethodBeat.i(211271);
                    super.ggI();
                    if (getScene() == 67 || getScene() == 81) {
                        y(9, getIntent().getStringExtra("sessionId"), getScene());
                    }
                    AppMethodBeat.o(211271);
                }

                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
                public int getLayoutId() {
                    return R.layout.bye;
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final String getHint() {
                    AppMethodBeat.i(80669);
                    String agT = agT(getTabType());
                    AppMethodBeat.o(80669);
                    return agT;
                }

                private void zm(boolean z) {
                    AppMethodBeat.i(211272);
                    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateWebViewStatus isCancelling:%b visible:%s", Boolean.valueOf(this.Jnj), Boolean.valueOf(z));
                    if (this.JnT != null) {
                        if (this.Jnj || !z) {
                            this.JnT.setAlpha(0.0f);
                        } else {
                            this.JnT.setAlpha(1.0f);
                            AppMethodBeat.o(211272);
                            return;
                        }
                    }
                    AppMethodBeat.o(211272);
                }

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
                public final void m(int i2, Bundle bundle) {
                    AppMethodBeat.i(80670);
                    super.m(i2, bundle);
                    switch (i2) {
                        case 119:
                            this.Jod.sendMessage(8);
                            AppMethodBeat.o(80670);
                            return;
                        case 122:
                            this.Jod.sendMessage(10);
                            AppMethodBeat.o(80670);
                            return;
                        case r.CTRL_INDEX:
                            bundle.getString("fts_key_new_query", "");
                            this.Jod.sendMessage(13);
                            AppMethodBeat.o(80670);
                            return;
                        case 154:
                            String string = bundle.getString("fts_key_data", "exit");
                            if (TextUtils.equals("controlExit", string)) {
                                this.Jok = true;
                            } else if (TextUtils.equals("exit", string)) {
                                this.Jok = false;
                                if (this.Jol == a.cancel) {
                                    ggF();
                                } else {
                                    fzm();
                                }
                            }
                            Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "AC_ON_NAV_CONTROL mIsExitControl:%b, lastClickType:%s", Boolean.valueOf(this.Jok), this.Jol);
                            AppMethodBeat.o(80670);
                            return;
                        case 155:
                            final int i3 = bundle.getInt("fts_key_data");
                            final int i4 = bundle.getInt("fts_key_cache");
                            if (this.JnV != null) {
                                this.JnV.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass4 */

                                    public final void run() {
                                        AppMethodBeat.i(211244);
                                        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "showNavBarShadow %s %s", Integer.valueOf(i3), Integer.valueOf(i4));
                                        FTSSOSHomeWebViewUI.this.JnV.setBackgroundColor(i3 + (TPMediaCodecProfileLevel.HEVCMainTierLevel62 * i4));
                                        FTSSOSHomeWebViewUI.this.JnV.setVisibility(0);
                                        FTSSOSHomeWebViewUI.this.JnV.setOnClickListener(FTSSOSHomeWebViewUI.this.Jor);
                                        FTSSOSHomeWebViewUI.this.Gky = true;
                                        AppMethodBeat.o(211244);
                                    }
                                });
                            }
                            AppMethodBeat.o(80670);
                            return;
                        case 156:
                            fyl();
                            break;
                    }
                    AppMethodBeat.o(80670);
                }

                private String agT(int i2) {
                    AppMethodBeat.i(80671);
                    int i3 = -1;
                    switch (i2) {
                        case 1:
                            i3 = R.string.ggc;
                            break;
                        case 2:
                            i3 = R.string.ggb;
                            break;
                        case 8:
                            i3 = R.string.djv;
                            break;
                        case 16:
                            i3 = R.string.djt;
                            break;
                        case 64:
                            i3 = R.string.ko;
                            break;
                        case 128:
                            i3 = R.string.djj;
                            break;
                        case 256:
                        case 384:
                            i3 = R.string.dji;
                            break;
                        case 512:
                            i3 = R.string.djr;
                            break;
                        case 1024:
                            i3 = R.string.djs;
                            break;
                    }
                    if (ggU() || this.scene == 53) {
                        i3 = R.string.gh0;
                    }
                    if (i3 >= 0) {
                        String string = getString(R.string.gga, new Object[]{getString(i3)});
                        AppMethodBeat.o(80671);
                        return string;
                    } else if (!Util.isNullOrNil(this.Joj)) {
                        String string2 = getString(R.string.gga, new Object[]{this.Joj});
                        AppMethodBeat.o(80671);
                        return string2;
                    } else {
                        String string3 = getString(R.string.ggp);
                        AppMethodBeat.o(80671);
                        return string3;
                    }
                }

                private void agU(int i2) {
                    AppMethodBeat.i(80672);
                    ggL().getIconView().setImageDrawable(agS(i2));
                    if (i2 == 0) {
                        ggL().getIconView().setIconColor(getResources().getColor(R.color.FG_2));
                    }
                    AppMethodBeat.o(80672);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity
                public void onBackPressed() {
                    AppMethodBeat.i(80673);
                    super.onBackPressed();
                    ggL().gXf();
                    AppMethodBeat.o(80673);
                }

                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final boolean ggO() {
                    AppMethodBeat.i(80674);
                    if (this.Jod == null) {
                        AppMethodBeat.o(80674);
                        return false;
                    }
                    boolean ggO = this.Jod.ggO();
                    AppMethodBeat.o(80674);
                    return ggO;
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final boolean ggP() {
                    AppMethodBeat.i(80675);
                    if (!ggO() || this.JnX.isAnimating || this.JnY.isAnimating || this.JnZ.isAnimating) {
                        AppMethodBeat.o(80675);
                        return false;
                    }
                    AppMethodBeat.o(80675);
                    return true;
                }

                /* access modifiers changed from: package-private */
                public class b extends StateMachine {
                    State JoA = new C1988b(this, (byte) 0);
                    State JoB = new c(this, (byte) 0);
                    State Joy = new a(this, (byte) 0);
                    State Joz = new d(this, (byte) 0);

                    static /* synthetic */ void a(b bVar, IState iState) {
                        AppMethodBeat.i(211256);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211256);
                    }

                    static /* synthetic */ void b(b bVar, IState iState) {
                        AppMethodBeat.i(211257);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211257);
                    }

                    static /* synthetic */ void c(b bVar, IState iState) {
                        AppMethodBeat.i(211258);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211258);
                    }

                    static /* synthetic */ void d(b bVar, IState iState) {
                        AppMethodBeat.i(211259);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211259);
                    }

                    static /* synthetic */ void e(b bVar, IState iState) {
                        AppMethodBeat.i(211260);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211260);
                    }

                    static /* synthetic */ void f(b bVar, IState iState) {
                        AppMethodBeat.i(211261);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211261);
                    }

                    static /* synthetic */ void g(b bVar, IState iState) {
                        AppMethodBeat.i(211262);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211262);
                    }

                    static /* synthetic */ void h(b bVar, IState iState) {
                        AppMethodBeat.i(211263);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211263);
                    }

                    static /* synthetic */ void i(b bVar, IState iState) {
                        AppMethodBeat.i(211264);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211264);
                    }

                    static /* synthetic */ void j(b bVar, IState iState) {
                        AppMethodBeat.i(211265);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211265);
                    }

                    static /* synthetic */ void k(b bVar, IState iState) {
                        AppMethodBeat.i(211266);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211266);
                    }

                    static /* synthetic */ void l(b bVar, IState iState) {
                        AppMethodBeat.i(211267);
                        bVar.transitionTo(iState);
                        AppMethodBeat.o(211267);
                    }

                    protected b(String str, Looper looper) {
                        super(str, looper);
                        AppMethodBeat.i(80648);
                        addState(this.Joy);
                        addState(this.Joz);
                        addState(this.JoA);
                        addState(this.JoB);
                        setInitialState(this.Joy);
                        AppMethodBeat.o(80648);
                    }

                    public final void ggX() {
                        AppMethodBeat.i(80649);
                        FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(0);
                        setInitialState(this.Joy);
                        AppMethodBeat.o(80649);
                    }

                    public final boolean ggO() {
                        AppMethodBeat.i(80650);
                        IState currentState = getCurrentState();
                        if (currentState == this.Joz || currentState == this.JoA || currentState == this.JoB) {
                            AppMethodBeat.o(80650);
                            return true;
                        }
                        AppMethodBeat.o(80650);
                        return false;
                    }

                    class a extends LogStateTransitionState {
                        private a() {
                        }

                        /* synthetic */ a(b bVar, byte b2) {
                            this();
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void enter() {
                            AppMethodBeat.i(80636);
                            super.enter();
                            FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this);
                            AppMethodBeat.o(80636);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void exit() {
                            AppMethodBeat.i(80637);
                            super.exit();
                            FTSSOSHomeWebViewUI.this.Joc.setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(R.color.ac_));
                            AppMethodBeat.o(80637);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final boolean processMessage(Message message) {
                            AppMethodBeat.i(80638);
                            switch (message.what) {
                                case 0:
                                case 13:
                                    if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                                        FTSSOSHomeWebViewUI.this.ggL().gXf();
                                        FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
                                        FTSSOSHomeWebViewUI.this.JnX.b(a.b.Search);
                                        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Search);
                                        FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(R.color.afz);
                                        break;
                                    }
                                    break;
                                case 1:
                                    FTSSOSHomeWebViewUI.this.ggL().gXf();
                                    FTSSOSHomeWebViewUI.this.JnY.b(a.b.Search);
                                    FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Search);
                                    FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(R.color.afz);
                                    break;
                                case 3:
                                    FTSSOSHomeWebViewUI.this.Jni = true;
                                    b.b(b.this, b.this.Joz);
                                    break;
                                case 4:
                                    FTSSOSHomeWebViewUI.this.Jni = true;
                                    b.c(b.this, b.this.JoA);
                                    break;
                                case 5:
                                    if (FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus() && FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0) {
                                        FTSSOSHomeWebViewUI.this.ggL().gXf();
                                        FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(R.color.afz);
                                        FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(8);
                                        FTSSOSHomeWebViewUI.this.JnY.b(a.b.Search);
                                        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Search);
                                        FTSSOSHomeWebViewUI.this.aD(new Runnable() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(80635);
                                                h jsapi = FTSSOSHomeWebViewUI.this.getJsapi();
                                                if (!jsapi.GBl) {
                                                    Log.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
                                                    AppMethodBeat.o(80635);
                                                    return;
                                                }
                                                Log.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
                                                MMHandlerThread.postToMainThread(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003b: INVOKE  
                                                      (wrap: com.tencent.mm.plugin.webview.d.h$48 : 0x0038: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$48) = 
                                                      (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                                      (wrap: java.lang.String : 0x0032: INVOKE  (r1v3 java.lang.String) = 
                                                      ("onFocusSearchInput")
                                                      (null java.util.Map)
                                                      (wrap: boolean : 0x002e: IGET  (r3v0 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                      (wrap: java.lang.String : 0x0030: IGET  (r4v0 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                     call: com.tencent.mm.plugin.webview.d.h.48.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.1.run():void, file: classes.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0038: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$48) = 
                                                      (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                                      (wrap: java.lang.String : 0x0032: INVOKE  (r1v3 java.lang.String) = 
                                                      ("onFocusSearchInput")
                                                      (null java.util.Map)
                                                      (wrap: boolean : 0x002e: IGET  (r3v0 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                      (wrap: java.lang.String : 0x0030: IGET  (r4v0 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                     call: com.tencent.mm.plugin.webview.d.h.48.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.1.run():void, file: classes.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                    	... 18 more
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                    	... 24 more
                                                    */
                                                /*
                                                    this = this;
                                                    r5 = 80635(0x13afb, float:1.12994E-40)
                                                    com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                                    com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b$a r0 = com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.this
                                                    com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b r0 = com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.this
                                                    com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.this
                                                    com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                                    boolean r1 = r0.GBl
                                                    if (r1 != 0) goto L_0x0021
                                                    java.lang.String r0 = "MicroMsg.JsApiHandler"
                                                    java.lang.String r1 = "onFocusSearchInput fail, not ready"
                                                    com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                                    com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                L_0x0020:
                                                    return
                                                L_0x0021:
                                                    java.lang.String r1 = "MicroMsg.JsApiHandler"
                                                    java.lang.String r2 = "onFocusSearchInput success, ready"
                                                    com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
                                                    java.lang.String r1 = "onFocusSearchInput"
                                                    r2 = 0
                                                    boolean r3 = r0.IRj
                                                    java.lang.String r4 = r0.zpY
                                                    java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r1, r2, r3, r4)
                                                    com.tencent.mm.plugin.webview.d.h$48 r2 = new com.tencent.mm.plugin.webview.d.h$48
                                                    r2.<init>(r1)
                                                    com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                                                    com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                    goto L_0x0020
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.AnonymousClass1.run():void");
                                            }
                                        });
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), 3, FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE));
                                        break;
                                    }
                                case 14:
                                    FTSSOSHomeWebViewUI.this.ggL().gXf();
                                    FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
                                    FTSSOSHomeWebViewUI.this.JnX.a(a.b.Search, false);
                                    FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Search);
                                    FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(R.color.afz);
                                    b.a(b.this, b.this.JoA);
                                    FTSSOSHomeWebViewUI.this.Jni = true;
                                    break;
                            }
                            boolean processMessage = super.processMessage(message);
                            AppMethodBeat.o(80638);
                            return processMessage;
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final String getName() {
                            return "InitSate";
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b$b  reason: collision with other inner class name */
                    class C1988b extends LogStateTransitionState {
                        private C1988b() {
                        }

                        /* synthetic */ C1988b(b bVar, byte b2) {
                            this();
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void enter() {
                            AppMethodBeat.i(80639);
                            super.enter();
                            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Search);
                            FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(R.color.afz);
                            FTSSOSHomeWebViewUI.this.Jnc.vy.clearFocus();
                            FTSSOSHomeWebViewUI.this.hideVKB();
                            FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.Jnb.setPadding(FTSSOSHomeWebViewUI.this.Joe, 0, 0, 0);
                            FTSSOSHomeWebViewUI.this.ggL().gXf();
                            FTSSOSHomeWebViewUI.this.tql.setVisibility(0);
                            FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(0);
                            FTSSOSHomeWebViewUI.this.Jnc.setVoiceImageButtonVisibile(0);
                            FTSSOSHomeWebViewUI.this.Jnc.gXf();
                            FTSSOSHomeWebViewUI.this.Jnc.gXe();
                            FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
                            if (com.tencent.mm.compatible.util.d.oD(23) && !MIUI.isMIUIV8()) {
                                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.getResources().getColor(R.color.afz), !ao.isDarkMode());
                            }
                            FTSSOSHomeWebViewUI.this.nmd.setAlpha(0.0f);
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) FTSSOSHomeWebViewUI.this.Jnb.getLayoutParams();
                            layoutParams.leftMargin = 0;
                            layoutParams.rightMargin = 0;
                            if (FTSSOSHomeWebViewUI.this.Jnd) {
                                layoutParams.topMargin = 0;
                            }
                            layoutParams.width = -1;
                            FTSSOSHomeWebViewUI.this.Jnb.setLayoutParams(layoutParams);
                            FTSSOSHomeWebViewUI.this.Jnb.setY(0.0f);
                            FTSSOSHomeWebViewUI.this.Jnb.setX(0.0f);
                            if (FTSSOSHomeWebViewUI.this.Jnd) {
                                FTSSOSHomeWebViewUI.this.nmd.setTranslationX(0.0f);
                                FTSSOSHomeWebViewUI.this.nmd.setTranslationY(0.0f);
                                FTSSOSHomeWebViewUI.this.Jnb.setTranslationX(0.0f);
                                FTSSOSHomeWebViewUI.this.Jnb.setTranslationY(0.0f);
                            }
                            if (FTSSOSHomeWebViewUI.this.Jnd && FTSSOSHomeWebViewUI.this.IEm) {
                                FTSSOSHomeWebViewUI.this.Jnb.setVisibility(8);
                                FTSSOSHomeWebViewUI.this.nmd.setAlpha(1.0f);
                                FTSSOSHomeWebViewUI.this.tql.setVisibility(0);
                                FTSSOSHomeWebViewUI.this.nmd.setVisibility(8);
                                if (FTSSOSHomeWebViewUI.this.getIntent() != null && FTSSOSHomeWebViewUI.this.getIntent().hasExtra("customize_status_bar_color")) {
                                    FTSSOSHomeWebViewUI.this.Joc.setBackgroundColor(FTSSOSHomeWebViewUI.this.xPp);
                                    if (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("status_bar_style")) {
                                        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.xPp, "black".equals(FTSSOSHomeWebViewUI.this.xPq));
                                    }
                                }
                                FTSSOSHomeWebViewUI.this.JnW.setVisibility(0);
                                String stringExtra = FTSSOSHomeWebViewUI.this.getIntent().getStringExtra("title");
                                if (Util.isNullOrNil(stringExtra)) {
                                    stringExtra = FTSSOSHomeWebViewUI.this.getString(R.string.cf_);
                                }
                                FTSSOSHomeWebViewUI.this.JnW.setText(stringExtra);
                            }
                            FTSSOSHomeWebViewUI.this.ggR();
                            AppMethodBeat.o(80639);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void exit() {
                            AppMethodBeat.i(80640);
                            super.exit();
                            AppMethodBeat.o(80640);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final boolean processMessage(Message message) {
                            AppMethodBeat.i(80641);
                            switch (message.what) {
                                case 0:
                                    FTSSOSHomeWebViewUI.this.ggL().gXf();
                                    break;
                                case 2:
                                    if (FTSSOSHomeWebViewUI.this.Jnd) {
                                        FTSSOSHomeWebViewUI.this.finish();
                                        break;
                                    } else {
                                        FTSSOSHomeWebViewUI.this.JnX.b(a.b.Init);
                                        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Init);
                                        break;
                                    }
                                case 3:
                                case 4:
                                    b.d(b.this, b.this.Joy);
                                    break;
                                case 5:
                                    if (FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus()) {
                                        b.e(b.this, b.this.Joz);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), 2, FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE));
                                        break;
                                    }
                                    break;
                            }
                            boolean processMessage = super.processMessage(message);
                            AppMethodBeat.o(80641);
                            return processMessage;
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final String getName() {
                            return "SearchNoFocusState";
                        }
                    }

                    class d extends LogStateTransitionState {
                        private d() {
                        }

                        /* synthetic */ d(b bVar, byte b2) {
                            this();
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void enter() {
                            boolean z = false;
                            AppMethodBeat.i(80645);
                            super.enter();
                            FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.Jnb.setPadding(FTSSOSHomeWebViewUI.this.Joe, 0, 0, 0);
                            FTSSOSHomeWebViewUI.this.Jnb.setX(0.0f);
                            FTSSOSHomeWebViewUI.this.Jnb.setY(0.0f);
                            FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(8);
                            FTSSOSHomeWebViewUI.this.Jnc.setVoiceImageButtonVisibile(8);
                            FTSSOSHomeWebViewUI.this.Jnc.gXe();
                            FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
                            if (!FTSSOSHomeWebViewUI.this.ggL().vy.hasFocus()) {
                                FTSSOSHomeWebViewUI.this.ggL().awD();
                                FTSSOSHomeWebViewUI.this.showVKB();
                            }
                            if (com.tencent.mm.compatible.util.d.oD(23) && !MIUI.isMIUIV8()) {
                                FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
                                int color = FTSSOSHomeWebViewUI.this.getResources().getColor(R.color.afz);
                                if (!ao.isDarkMode()) {
                                    z = true;
                                }
                                FTSSOSHomeWebViewUI.c(fTSSOSHomeWebViewUI, color, z);
                            }
                            if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                                FTSSOSHomeWebViewUI.this.ggL().gXg();
                            }
                            AppMethodBeat.o(80645);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void exit() {
                            AppMethodBeat.i(80646);
                            super.exit();
                            FTSSOSHomeWebViewUI.this.hideVKB();
                            AppMethodBeat.o(80646);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final boolean processMessage(Message message) {
                            AppMethodBeat.i(80647);
                            switch (message.what) {
                                case 0:
                                case 11:
                                    if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                                        b.h(b.this, b.this.JoA);
                                        break;
                                    }
                                    break;
                                case 2:
                                    if (FTSSOSHomeWebViewUI.this.Jnd) {
                                        FTSSOSHomeWebViewUI.this.finish();
                                        break;
                                    } else {
                                        FTSSOSHomeWebViewUI.this.JnY.b(a.b.Init);
                                        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Init);
                                        break;
                                    }
                                case 3:
                                case 4:
                                    b.f(b.this, b.this.Joy);
                                    break;
                                case 5:
                                    if (FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus()) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), 2, FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE));
                                        break;
                                    } else {
                                        b.g(b.this, b.this.JoA);
                                        break;
                                    }
                            }
                            boolean processMessage = super.processMessage(message);
                            AppMethodBeat.o(80647);
                            return processMessage;
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final String getName() {
                            return "SearchWithFocusState";
                        }
                    }

                    class c extends LogStateTransitionState {
                        private c() {
                        }

                        /* synthetic */ c(b bVar, byte b2) {
                            this();
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void enter() {
                            AppMethodBeat.i(80642);
                            super.enter();
                            FTSSOSHomeWebViewUI.this.Jnb.setPadding(FTSSOSHomeWebViewUI.this.Joe, 0, 0, 0);
                            FTSSOSHomeWebViewUI.this.Jnb.setX(0.0f);
                            FTSSOSHomeWebViewUI.this.Jnb.setY(0.0f);
                            FTSSOSHomeWebViewUI.this.ggL().gXf();
                            FTSSOSHomeWebViewUI.this.tql.setVisibility(0);
                            FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(0);
                            FTSSOSHomeWebViewUI.this.Jnc.setVoiceImageButtonVisibile(0);
                            AppMethodBeat.o(80642);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
                        public final void exit() {
                            AppMethodBeat.i(80643);
                            super.exit();
                            FTSSOSHomeWebViewUI.this.hideVKB();
                            AppMethodBeat.o(80643);
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final boolean processMessage(Message message) {
                            AppMethodBeat.i(80644);
                            switch (message.what) {
                                case 0:
                                    if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                                        FTSSOSHomeWebViewUI.this.ggL().gXf();
                                        FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
                                        b.k(b.this, b.this.JoA);
                                        break;
                                    }
                                    break;
                                case 2:
                                    if (FTSSOSHomeWebViewUI.this.Jnd) {
                                        FTSSOSHomeWebViewUI.this.finish();
                                        break;
                                    } else {
                                        FTSSOSHomeWebViewUI.this.JnZ.b(a.b.Init);
                                        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Init);
                                        break;
                                    }
                                case 5:
                                    if (FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus()) {
                                        b.i(b.this, b.this.Joz);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), 2, FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE));
                                        break;
                                    }
                                    break;
                                case 9:
                                    b.l(b.this, b.this.Joy);
                                    break;
                                case 10:
                                    if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                                        b.j(b.this, b.this.JoA);
                                        break;
                                    }
                                    break;
                            }
                            boolean processMessage = super.processMessage(message);
                            AppMethodBeat.o(80644);
                            return processMessage;
                        }

                        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
                        public final String getName() {
                            return "SearchWithFocusNoResultState";
                        }
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
                public final h getJsapi() {
                    AppMethodBeat.i(259672);
                    h jsapi = super.getJsapi();
                    AppMethodBeat.o(259672);
                    return jsapi;
                }

                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.widget.MMWebView.e
                public final void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
                    AppMethodBeat.i(80677);
                    super.onWebViewScrollChanged(i2, i3, i4, i5);
                    if (this.pGj == null) {
                        AppMethodBeat.o(80677);
                        return;
                    }
                    int min = Math.min(i3, Math.max(com.tencent.mm.cb.a.fromDPToPix((Context) this, this.pGj.getContentHeight()) - this.pGj.getHeight(), 0));
                    this.JnX.agW(this.Joh - min);
                    this.JnY.agW(this.Joh - min);
                    this.JnZ.agW(this.Joh - min);
                    if (!this.Jod.ggO()) {
                        this.nmd.setTranslationY((float) (-min));
                        this.Jnb.setTranslationY((float) (-min));
                    }
                    if (i3 != 0) {
                        ggL().vy.clearFocus();
                        hideVKB();
                    }
                    AppMethodBeat.o(80677);
                }

                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                public final void agP(int i2) {
                    AppMethodBeat.i(80678);
                    if (this.pGj == null || this.pGj.getSettings() == null) {
                        AppMethodBeat.o(80678);
                        return;
                    }
                    float f2 = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.iX(getContext()));
                    if (f2 >= com.tencent.mm.cb.a.jd(getContext())) {
                        this.pGj.getSettings().setTextZoom(160);
                        AppMethodBeat.o(80678);
                    } else if (f2 >= com.tencent.mm.cb.a.jc(getContext())) {
                        this.pGj.getSettings().setTextZoom(150);
                        AppMethodBeat.o(80678);
                    } else if (f2 >= com.tencent.mm.cb.a.jb(getContext())) {
                        this.pGj.getSettings().setTextZoom(140);
                        AppMethodBeat.o(80678);
                    } else if (f2 >= com.tencent.mm.cb.a.ja(getContext())) {
                        this.pGj.getSettings().setTextZoom(130);
                        AppMethodBeat.o(80678);
                    } else if (f2 >= com.tencent.mm.cb.a.iZ(getContext())) {
                        this.pGj.getSettings().setTextZoom(120);
                        AppMethodBeat.o(80678);
                    } else if (f2 >= com.tencent.mm.cb.a.iY(getContext())) {
                        this.pGj.getSettings().setTextZoom(110);
                        AppMethodBeat.o(80678);
                    } else if (f2 >= com.tencent.mm.cb.a.iX(getContext())) {
                        this.pGj.getSettings().setTextZoom(100);
                        AppMethodBeat.o(80678);
                    } else if (f2 >= com.tencent.mm.cb.a.iW(getContext())) {
                        this.pGj.getSettings().setTextZoom(90);
                        AppMethodBeat.o(80678);
                    } else {
                        this.pGj.getSettings().setTextZoom(80);
                        AppMethodBeat.o(80678);
                    }
                }

                private void agV(int i2) {
                    AppMethodBeat.i(211274);
                    if (getIntent().getBooleanExtra("key_hide_shadow_view", false)) {
                        this.Bnt.setVisibility(8);
                        AppMethodBeat.o(211274);
                        return;
                    }
                    this.Bnt.setVisibility(i2);
                    AppMethodBeat.o(211274);
                }

                private void fyl() {
                    AppMethodBeat.i(211276);
                    if (this.JnV != null) {
                        this.JnV.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(211246);
                                Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "hideNavBarShadow");
                                FTSSOSHomeWebViewUI.this.JnV.setVisibility(8);
                                FTSSOSHomeWebViewUI.this.Gky = false;
                                AppMethodBeat.o(211246);
                            }
                        });
                    }
                    AppMethodBeat.o(211276);
                }

                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
                public void finish() {
                    AppMethodBeat.i(211277);
                    super.finish();
                    if (getScene() == 67 || getScene() == 81) {
                        y(11, getIntent().getStringExtra("sessionId"), getScene());
                    }
                    AppMethodBeat.o(211277);
                }

                private static void y(int i2, String str, int i3) {
                    AppMethodBeat.i(211278);
                    ab abVar = new ab();
                    abVar.eki = i2;
                    abVar.enp = 0;
                    abVar.ie(str);
                    abVar.enq = i3;
                    abVar.enx = System.currentTimeMillis();
                    abVar.bfK();
                    AppMethodBeat.o(211278);
                }

                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
                public final boolean awE() {
                    AppMethodBeat.i(80665);
                    if (!this.Jnk) {
                        AppMethodBeat.o(80665);
                    } else {
                        this.Jod.sendMessage(0);
                        super.awE();
                        AppMethodBeat.o(80665);
                    }
                    return true;
                }

                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
                public final String ggJ() {
                    if (this.Joq == 0) {
                        return "";
                    }
                    return this.Jop;
                }

                private void fzW() {
                    AppMethodBeat.i(211275);
                    if (super.getJsapi() != null) {
                        super.getJsapi().gbd();
                    }
                    AppMethodBeat.o(211275);
                }

                static /* synthetic */ void d(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
                    AppMethodBeat.i(211279);
                    fTSSOSHomeWebViewUI.Jof--;
                    fTSSOSHomeWebViewUI.zm(true);
                    AppMethodBeat.o(211279);
                }

                static /* synthetic */ void e(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
                    AppMethodBeat.i(211280);
                    fTSSOSHomeWebViewUI.Jof++;
                    fTSSOSHomeWebViewUI.zm(false);
                    AppMethodBeat.o(211280);
                }

                static /* synthetic */ void f(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
                    AppMethodBeat.i(211281);
                    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "setInitStatus originInputX:%f, currentInputX:%f isPageLoadFinish:%b isWebViewPreloaded:%b", Float.valueOf(fTSSOSHomeWebViewUI.Joa), Float.valueOf(fTSSOSHomeWebViewUI.Jnb.getX()), Boolean.valueOf(fTSSOSHomeWebViewUI.Jnk), Boolean.valueOf(fTSSOSHomeWebViewUI.IRT));
                    if (fTSSOSHomeWebViewUI.Joa > 0.0f) {
                        fTSSOSHomeWebViewUI.Jnb.setX(fTSSOSHomeWebViewUI.Joa);
                    }
                    if (fTSSOSHomeWebViewUI.Job > 0.0f) {
                        fTSSOSHomeWebViewUI.Jnb.setY(fTSSOSHomeWebViewUI.Job);
                    }
                    fTSSOSHomeWebViewUI.Jnb.setVisibility(0);
                    fTSSOSHomeWebViewUI.Joc.setBackgroundColor(fTSSOSHomeWebViewUI.getResources().getColor(R.color.afd));
                    fTSSOSHomeWebViewUI.nmd.setVisibility(0);
                    fTSSOSHomeWebViewUI.agV(8);
                    if (d.oD(23) && !MIUI.isMIUIV8()) {
                        fTSSOSHomeWebViewUI.bt(fTSSOSHomeWebViewUI.getResources().getColor(R.color.afd), !ao.isDarkMode());
                    }
                    fTSSOSHomeWebViewUI.ggL().gXf();
                    fTSSOSHomeWebViewUI.ggL().gWY();
                    fTSSOSHomeWebViewUI.Jnb.setPadding(0, 0, 0, 0);
                    fTSSOSHomeWebViewUI.JnE = 0;
                    fTSSOSHomeWebViewUI.Joj = "";
                    fTSSOSHomeWebViewUI.ggE();
                    fTSSOSHomeWebViewUI.ggL().vy.clearFocus();
                    fTSSOSHomeWebViewUI.ggL().setHint(fTSSOSHomeWebViewUI.getHint());
                    fTSSOSHomeWebViewUI.Jnc.setSearchBarCancelTextContainerVisibile(8);
                    fTSSOSHomeWebViewUI.Jnc.setVoiceImageButtonVisibile(0);
                    fTSSOSHomeWebViewUI.ggV();
                    fTSSOSHomeWebViewUI.zm(true);
                    AppMethodBeat.o(211281);
                }

                static /* synthetic */ void a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, a.b bVar) {
                    AppMethodBeat.i(211282);
                    fTSSOSHomeWebViewUI.JnZ.a(bVar);
                    fTSSOSHomeWebViewUI.JnY.a(bVar);
                    fTSSOSHomeWebViewUI.JnX.a(bVar);
                    AppMethodBeat.o(211282);
                }
            }
