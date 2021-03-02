package com.tencent.luggage.xweb_ext.extendplugin.c;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class a extends XWalkExtendTextAreaClient {
    private final String TAG = "WebViewExtendTextAreaClient";
    public au cKd;
    private u cKe;
    private w cKf;
    private EditText cKg;
    private int cKh = 0;
    private int cKi = 0;
    private boolean cKj = false;
    private final u.c cKk = new u.c() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.c.a.AnonymousClass2 */
        private final af cAj = new af();
        private int crC = 0;

        {
            AppMethodBeat.i(215752);
            AppMethodBeat.o(215752);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final void hF(int i2) {
            AppMethodBeat.i(215753);
            this.crC = i2;
            w d2 = a.d(a.this);
            if (d2 != null) {
                d2.hF(i2);
            }
            AppMethodBeat.o(215753);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final void bQ(boolean z) {
            int i2;
            int i3;
            int i4;
            AppMethodBeat.i(215754);
            h bRH = a.this.cKd.bRH();
            f bxr = a.this.cKd.bxr();
            if (bRH != null) {
                af afVar = this.cAj;
                if (z) {
                    i4 = a.this.getToolBarHeight(this.crC);
                } else {
                    i4 = 0;
                }
                p.h(bxr, "service");
                p.h(bRH, "page");
                afVar.p("height", Integer.valueOf(g.zB(i4)));
                afVar.g(bxr).bEo();
                afVar.g(bRH).bEo();
            }
            w d2 = a.d(a.this);
            if (d2 != null) {
                if (a.this.cKg != null) {
                    if (z) {
                        d2.oum = a.this.cKg;
                    } else {
                        d2.b(a.this.cKg);
                    }
                }
                if (z) {
                    i3 = this.crC;
                } else {
                    i3 = 0;
                }
                d2.hF(i3);
            }
            a aVar = a.this;
            if (z) {
                i2 = this.crC;
            } else {
                i2 = 0;
            }
            aVar.onKeyboardHeightChanged(z, i2, false);
            AppMethodBeat.o(215754);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final int getHeight() {
            return this.crC;
        }
    };

    static /* synthetic */ w a(a aVar) {
        AppMethodBeat.i(139372);
        w wVar = aVar.cKf;
        AppMethodBeat.o(139372);
        return wVar;
    }

    static /* synthetic */ w d(a aVar) {
        AppMethodBeat.i(215759);
        w QN = aVar.QN();
        AppMethodBeat.o(215759);
        return QN;
    }

    static /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(215760);
        aVar.cl(false);
        AppMethodBeat.o(215760);
    }

    public a(XWalkView xWalkView) {
        super(xWalkView);
        AppMethodBeat.i(139367);
        AppMethodBeat.o(139367);
    }

    private w QN() {
        com.tencent.mm.plugin.appbrand.n.a aVar = null;
        AppMethodBeat.i(139368);
        if (this.cKf != null) {
            w wVar = this.cKf;
            AppMethodBeat.o(139368);
            return wVar;
        } else if (this.cKd == null || this.cKd.bRH() == null) {
            AppMethodBeat.o(139368);
            return null;
        } else {
            View contentView = this.cKd.bRH().getContentView();
            if (this.cKd.bRH() != null && (this.cKd.bRH() instanceof ac)) {
                aVar = ((ac) this.cKd.bRH()).bRo();
            }
            this.cKf = w.b(contentView, aVar);
            if (this.cKf != null) {
                this.cKg = new EditText(this.cKf.getContext());
                this.cKf.a(new w.d() {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.c.a.AnonymousClass1 */

                    {
                        AppMethodBeat.i(139362);
                        AppMethodBeat.o(139362);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.w.d
                    public final void ig(int i2) {
                        boolean z = true;
                        AppMethodBeat.i(215750);
                        int minimumHeight = a.a(a.this).getMinimumHeight();
                        int i3 = i2 - minimumHeight;
                        Log.i("WebViewExtendTextAreaClient", "OnHeightChangedListener, totalHeight: %d, lateSavedKeyboardPanelHeight: %d, currentKeyboardPanelHeight: %d", Integer.valueOf(i2), Integer.valueOf(a.this.cKh), Integer.valueOf(minimumHeight));
                        if (a.this.cKh != minimumHeight) {
                            a.this.cKh = minimumHeight;
                            a aVar = a.this;
                            if (i3 <= 0) {
                                z = false;
                            }
                            aVar.onKeyboardHeightChanged(z, i3, false);
                        }
                        AppMethodBeat.o(215750);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.w.d
                    public final EditText getEditText() {
                        AppMethodBeat.i(215751);
                        EditText editText = a.this.cKg;
                        AppMethodBeat.o(215751);
                        return editText;
                    }
                });
            }
            w wVar2 = this.cKf;
            AppMethodBeat.o(139368);
            return wVar2;
        }
    }

    @Override // org.xwalk.core.XWalkExtendTextAreaClient
    public final boolean onShowKeyboard(String str, InputConnection inputConnection, ResultReceiver resultReceiver) {
        w QN;
        AppMethodBeat.i(139369);
        if (this.cKe == null) {
            this.cKe = n.cY(this.cKd.bRH().getContentView());
        }
        if (this.cKe != null) {
            this.cKe.a(this.cKk);
        }
        C0189a aVar = new C0189a(str);
        this.cKj = aVar.cKt;
        if (!(this.cKd == null || (QN = QN()) == null)) {
            if (aVar.cKq) {
                QN.setComponentView(aVar.cKs);
                QN.cbN();
                QN.setCanSmileyInput(!aVar.cKr && "emoji".equals(aVar.cKo));
                QN.setShowDoneButton(aVar.cKq);
                QN.setOnDoneListener(new w.c() {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.c.a.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.w.c
                    public final void cm(boolean z) {
                        AppMethodBeat.i(215755);
                        Log.i("WebViewExtendTextAreaClient", "onInputDone#onShowKeyboard, fromDoneButton: %b, confirmHold: %b", Boolean.valueOf(z), Boolean.valueOf(a.this.cKj));
                        a.g(a.this);
                        AppMethodBeat.o(215755);
                    }
                });
            }
            QN.bQ(aVar.cKq);
        }
        AppMethodBeat.o(139369);
        return false;
    }

    @Override // org.xwalk.core.XWalkExtendTextAreaClient
    public final boolean onHideKeyboard(String str, InputConnection inputConnection) {
        w QN;
        AppMethodBeat.i(139370);
        if (!(this.cKd == null || (QN = QN()) == null)) {
            QN.bQ(false);
        }
        if (this.cKe != null) {
            this.cKe.b(this.cKk);
        }
        AppMethodBeat.o(139370);
        return false;
    }

    @Override // org.xwalk.core.XWalkExtendTextAreaClient
    public final boolean onShowKeyboardConfig(int i2, int i3, String str, int i4, int i5, EditorInfo editorInfo) {
        b bVar = null;
        AppMethodBeat.i(215756);
        Log.d("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
        try {
            bVar = b.aga(new JSONObject(str).optString("confirm-type", null));
        } catch (Exception e2) {
            Log.w("WebViewExtendTextAreaClient", "onShowKeyboardConfig, get confirm-type error");
        }
        if (bVar != null) {
            Log.i("WebViewExtendTextAreaClient", "onShowKeyboardConfig, confirmType: ".concat(String.valueOf(bVar)));
            if (b.RETURN != bVar) {
                editorInfo.imeOptions &= -1073741825;
            }
            editorInfo.imeOptions |= bVar.oxA;
            this.cKi = bVar.oxA;
        }
        AppMethodBeat.o(215756);
        return false;
    }

    @Override // org.xwalk.core.XWalkExtendTextAreaClient
    public final boolean performEditorAction(int i2) {
        AppMethodBeat.i(215757);
        Log.d("WebViewExtendTextAreaClient", "performEditorAction, actionCode: ".concat(String.valueOf(i2)));
        if (i2 == 0 || i2 != this.cKi) {
            AppMethodBeat.o(215757);
            return true;
        }
        Log.i("WebViewExtendTextAreaClient", "performEditorAction, confirmHold: " + this.cKj);
        cl(this.cKj);
        AppMethodBeat.o(215757);
        return false;
    }

    @Override // org.xwalk.core.XWalkExtendTextAreaClient
    public final int getToolBarHeight(int i2) {
        AppMethodBeat.i(139371);
        w QN = QN();
        if (QN != null) {
            this.cKh = QN.getMinimumHeight();
            int i3 = i2 + this.cKh;
            AppMethodBeat.o(139371);
            return i3;
        }
        AppMethodBeat.o(139371);
        return i2;
    }

    private void cl(boolean z) {
        String str;
        AppMethodBeat.i(215758);
        StringBuilder sb = new StringBuilder("(function(){    var focusElement = document.activeElement;    if(focusElement){        if(focusElement.onkeyboardconfirm){            focusElement.onkeyboardconfirm();        }");
        if (!z) {
            str = "        focusElement.blur();";
        } else {
            str = "";
        }
        getXWalkView().evaluateJavascript(sb.append(str).append("    }})();").toString(), new ValueCallback<String>() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.c.a.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            }
        });
        AppMethodBeat.o(215758);
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.c.a$a  reason: collision with other inner class name */
    public class C0189a {
        public String cKm = "";
        public String cKn = "";
        public String cKo = "";
        public Integer cKp = null;
        public boolean cKq = false;
        public boolean cKr = false;
        public boolean cKs = false;
        public boolean cKt = false;

        public C0189a(String str) {
            JSONObject jSONObject;
            AppMethodBeat.i(139366);
            Log.i("TextAreaInfo", "totalInfo:".concat(String.valueOf(str)));
            this.cKm = str;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception e2) {
                Log.e("TextAreaInfo", "TextAreaInfo convert to json error");
                jSONObject = new JSONObject();
            }
            try {
                if (jSONObject.has("element-tag")) {
                    this.cKn = jSONObject.getString("element-tag");
                }
            } catch (JSONException e3) {
                Log.e("TextAreaInfo", "TextAreaInfo add elementTag error");
            }
            try {
                if (jSONObject.has("keyboard-type")) {
                    this.cKo = jSONObject.getString("keyboard-type");
                }
            } catch (JSONException e4) {
                Log.e("TextAreaInfo", "TextAreaInfo add keyboardType error");
            }
            try {
                if (jSONObject.has("cursor-spacing")) {
                    this.cKp = Integer.valueOf(Util.getInt(jSONObject.getString("cursor-spacing"), 0));
                }
            } catch (JSONException e5) {
                Log.e("TextAreaInfo", "TextAreaInfo get cursor-spacing error");
            } catch (NumberFormatException e6) {
                Log.e("TextAreaInfo", "TextAreaInfo get cursor-spacing parseInt error");
            } catch (Exception e7) {
                Log.e("TextAreaInfo", "TextAreaInfo get cursor-spacing parseInt error");
            }
            try {
                if (jSONObject.has("show-confirm-bar")) {
                    this.cKq = Util.getBoolean(jSONObject.getString("show-confirm-bar"), false);
                }
            } catch (JSONException e8) {
                Log.e("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
            } catch (Exception e9) {
                Log.e("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
            }
            try {
                if (jSONObject.has("password")) {
                    this.cKr = Util.getBoolean(jSONObject.getString("password"), false);
                }
            } catch (JSONException e10) {
                Log.e("TextAreaInfo", "TextAreaInfo get password error");
            } catch (Exception e11) {
                Log.e("TextAreaInfo", "TextAreaInfo get password error");
            }
            try {
                if (jSONObject.has("show-cover-view")) {
                    this.cKs = Util.getBoolean(jSONObject.getString("show-cover-view"), false);
                }
            } catch (JSONException e12) {
                Log.e("TextAreaInfo", "TextAreaInfo get show-cover-view error");
            } catch (Exception e13) {
                Log.e("TextAreaInfo", "TextAreaInfo get show-cover-view error");
            }
            try {
                if (jSONObject.has("confirm-hold")) {
                    this.cKt = Util.getBoolean(jSONObject.getString("confirm-hold"), false);
                }
                AppMethodBeat.o(139366);
            } catch (JSONException e14) {
                Log.e("TextAreaInfo", "TextAreaInfo get confirm-hold error");
                AppMethodBeat.o(139366);
            } catch (Exception e15) {
                Log.e("TextAreaInfo", "TextAreaInfo get confirm-hold error");
                AppMethodBeat.o(139366);
            }
        }
    }
}
