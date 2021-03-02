package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter extends LinearLayout {
    private c JAH;
    private a JAI;
    private b JAJ;
    private WebViewSmileyPanel JAK;
    private View JAL;
    private View JAM;
    private View JAN;
    MMEditText JAO;
    private LinearLayout JAP;
    public boolean JAQ;
    private int JAR = Integer.MAX_VALUE;
    private MMActivity gte;
    private ImageButton oui;
    public int state = 0;
    private boolean ziU = true;

    public interface a {
        boolean afZ(String str);
    }

    public interface b {
        void gbP();

        void gbQ();
    }

    public interface c {
        void gbU();
    }

    static /* synthetic */ int e(WebViewInputFooter webViewInputFooter) {
        AppMethodBeat.i(82326);
        int gfz = webViewInputFooter.gfz();
        AppMethodBeat.o(82326);
        return gfz;
    }

    static /* synthetic */ void h(WebViewInputFooter webViewInputFooter) {
        AppMethodBeat.i(82327);
        webViewInputFooter.cbM();
        AppMethodBeat.o(82327);
    }

    public final void setOnTextSendListener(c cVar) {
        this.JAH = cVar;
    }

    public final void setOnSmileyChosenListener(a aVar) {
        this.JAI = aVar;
    }

    public final void setOnSmileyPanelVisibilityChangedListener(b bVar) {
        this.JAJ = bVar;
    }

    public WebViewInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(82316);
        this.gte = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.gte, R.layout.cbq, this);
        this.JAP = (LinearLayout) viewGroup.findViewById(R.id.jkp);
        this.JAM = viewGroup.findViewById(R.id.jkt);
        this.JAN = viewGroup.findViewById(R.id.jks);
        this.JAL = viewGroup.findViewById(R.id.jku);
        this.JAO = (MMEditText) viewGroup.findViewById(R.id.jkq);
        this.oui = (ImageButton) viewGroup.findViewById(R.id.jkv);
        this.oui.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(82308);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WebViewInputFooter.this.state == 0) {
                    WebViewInputFooter.this.gte.hideVKB();
                    if (!WebViewInputFooter.this.JAQ) {
                        WebViewInputFooter.this.JAO.requestFocus();
                    }
                    WebViewInputFooter.e(WebViewInputFooter.this);
                    WebViewInputFooter.this.oui.setImageResource(R.raw.icons_outlined_emoji);
                    WebViewInputFooter.this.state = 1;
                    WebViewInputFooter.this.ziU = false;
                } else {
                    WebViewInputFooter.this.ziU = false;
                    WebViewInputFooter.this.JAO.requestFocus();
                    WebViewInputFooter.this.gte.showVKB();
                    WebViewInputFooter.h(WebViewInputFooter.this);
                    WebViewInputFooter.this.state = 0;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82308);
            }
        });
        this.JAO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(82309);
                WebViewInputFooter.this.ziU = false;
                WebViewInputFooter.this.JAK.setVisibility(8);
                WebViewSmileyPanel unused = WebViewInputFooter.this.JAK;
                WebViewInputFooter.this.oui.setImageResource(R.drawable.of);
                WebViewInputFooter.this.state = 0;
                AppMethodBeat.o(82309);
                return false;
            }
        });
        this.JAK = new WebViewSmileyPanel(getContext());
        this.JAK.setVisibility(8);
        this.JAK.setBackgroundResource(R.drawable.b6d);
        this.JAK.setOnTextOperationListener(new WebViewSmileyPanel.a() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a
            public final void append(String str) {
                AppMethodBeat.i(82310);
                try {
                    if (WebViewInputFooter.this.JAQ) {
                        WebViewInputFooter.this.JAI.afZ(str);
                        AppMethodBeat.o(82310);
                        return;
                    }
                    WebViewInputFooter.this.JAO.bol(str);
                    AppMethodBeat.o(82310);
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e2);
                    AppMethodBeat.o(82310);
                }
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a
            public final void aHC() {
                AppMethodBeat.i(82311);
                if (!WebViewInputFooter.this.JAQ || WebViewInputFooter.this.JAI == null) {
                    if (WebViewInputFooter.this.JAO != null) {
                        WebViewInputFooter.this.JAO.gYD();
                    }
                    AppMethodBeat.o(82311);
                    return;
                }
                WebViewInputFooter.this.JAI.afZ("[DELETE_EMOTION]");
                AppMethodBeat.o(82311);
            }
        });
        ((LinearLayout) findViewById(R.id.h8v)).addView(this.JAK, -1, 0);
        this.JAN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(82314);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.tools.b.c.f(WebViewInputFooter.this.JAO).aoq(WebViewInputFooter.this.JAR).a(f.a.MODE_CHINESE_AS_1).CN(true).a(new c.a() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tw(String str) {
                        AppMethodBeat.i(82312);
                        if (WebViewInputFooter.this.JAH != null) {
                            c cVar = WebViewInputFooter.this.JAH;
                            WebViewInputFooter.this.JAO.getText();
                            cVar.gbU();
                        }
                        WebViewInputFooter webViewInputFooter = WebViewInputFooter.this;
                        webViewInputFooter.JAO.clearComposingText();
                        webViewInputFooter.JAO.setText("");
                        AppMethodBeat.o(82312);
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tx(String str) {
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void dv(String str) {
                        AppMethodBeat.i(164038);
                        if (WebViewInputFooter.this.gte != null) {
                            Toast.makeText(WebViewInputFooter.this.gte, "exceed max-length", 0).show();
                        }
                        AppMethodBeat.o(164038);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82314);
            }
        });
        this.JAO.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.AnonymousClass5 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(82315);
                if (WebViewInputFooter.this.JAO.getText() == null) {
                    AppMethodBeat.o(82315);
                    return;
                }
                WebViewInputFooter.this.JAO.requestFocus();
                WebViewInputFooter.a(WebViewInputFooter.this, editable.length() > 0 && editable.toString().trim().length() > 0);
                AppMethodBeat.o(82315);
            }
        });
        AppMethodBeat.o(82316);
    }

    private int gfz() {
        AppMethodBeat.i(82317);
        if (this.JAJ != null) {
            this.JAJ.gbP();
        }
        if (this.JAO != null) {
            this.gte.hideVKB(this.JAO);
        }
        this.JAK.setVisibility(0);
        this.JAK.cck();
        ViewGroup.LayoutParams layoutParams = this.JAK.getLayoutParams();
        if (layoutParams != null && this.ziU) {
            layoutParams.height = i.getValidPanelHeight(getContext());
            this.JAK.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            int i2 = layoutParams.height;
            AppMethodBeat.o(82317);
            return i2;
        }
        AppMethodBeat.o(82317);
        return 0;
    }

    public final void cbM() {
        AppMethodBeat.i(82318);
        if (this.JAJ != null) {
            this.JAJ.gbQ();
        }
        this.JAK.setVisibility(8);
        this.oui.setImageResource(R.raw.icons_outlined_emoji);
        this.state = 0;
        AppMethodBeat.o(82318);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(82319);
        super.onDetachedFromWindow();
        giE();
        if (!(this.JAO == null || this.gte == null)) {
            this.gte.hideVKB(this.JAO);
        }
        this.JAO = null;
        this.JAK.onDestroy();
        removeAllViews();
        this.gte = null;
        this.JAH = null;
        AppMethodBeat.o(82319);
    }

    public final void setText(String str) {
        AppMethodBeat.i(82320);
        this.JAO.setText("");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(82320);
            return;
        }
        try {
            this.JAO.append(str);
        } catch (Exception e2) {
            Log.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e2);
        }
        Log.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", this.JAO.getText());
        AppMethodBeat.o(82320);
    }

    public final void setMaxCount(int i2) {
        if (i2 > 0) {
            this.JAR = i2;
        }
    }

    private void giE() {
        AppMethodBeat.i(82321);
        if (this.JAO != null) {
            this.JAO.clearFocus();
            this.JAO.setFocusable(false);
            this.JAO.setFocusableInTouchMode(false);
        }
        AppMethodBeat.o(82321);
    }

    public final int giF() {
        AppMethodBeat.i(82322);
        setVisibility(0);
        if (this.JAP != null) {
            this.JAP.setVisibility(8);
        }
        this.JAQ = true;
        this.state = 1;
        int gfz = gfz();
        AppMethodBeat.o(82322);
        return gfz;
    }

    public final void hide() {
        AppMethodBeat.i(82323);
        setVisibility(8);
        if (this.gte != null) {
            if (this.JAO != null) {
                this.gte.hideVKB(this.JAO);
            }
            this.gte.hideVKB();
        }
        this.state = 0;
        cbM();
        giE();
        AppMethodBeat.o(82323);
    }

    public final boolean isShown() {
        AppMethodBeat.i(82325);
        if (getVisibility() == 0) {
            AppMethodBeat.o(82325);
            return true;
        }
        AppMethodBeat.o(82325);
        return false;
    }

    static /* synthetic */ void a(WebViewInputFooter webViewInputFooter, boolean z) {
        AppMethodBeat.i(82328);
        Animation loadAnimation = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), R.anim.dd);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), R.anim.di);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (webViewInputFooter.JAM == null || webViewInputFooter.JAN == null) {
            AppMethodBeat.o(82328);
            return;
        }
        if (z) {
            if (webViewInputFooter.JAM.getVisibility() == 8 || webViewInputFooter.JAM.getVisibility() == 4) {
                AppMethodBeat.o(82328);
                return;
            }
            webViewInputFooter.JAN.startAnimation(loadAnimation);
            webViewInputFooter.JAN.setVisibility(0);
            webViewInputFooter.JAM.startAnimation(loadAnimation2);
            webViewInputFooter.JAM.setVisibility(8);
        } else if (webViewInputFooter.JAM.getVisibility() == 0 || webViewInputFooter.JAM.getVisibility() == 0) {
            AppMethodBeat.o(82328);
            return;
        } else {
            webViewInputFooter.JAM.startAnimation(loadAnimation);
            webViewInputFooter.JAM.setVisibility(0);
            webViewInputFooter.JAN.startAnimation(loadAnimation2);
            webViewInputFooter.JAN.setVisibility(8);
        }
        webViewInputFooter.JAN.getParent().requestLayout();
        AppMethodBeat.o(82328);
    }
}
