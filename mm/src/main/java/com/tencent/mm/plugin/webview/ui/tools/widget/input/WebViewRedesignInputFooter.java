package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class WebViewRedesignInputFooter extends LinearLayout {
    private WebViewInputFooter.b JAJ;
    public WebViewSmileyPanel JAK;
    public View JAL;
    private View JAM;
    private View JAN;
    public MMEditText JAO;
    public LinearLayout JAP;
    public boolean JAQ;
    private int JAR = Integer.MAX_VALUE;
    public b JAU;
    private a JAV;
    private TextView JAW;
    private int JAX = Integer.MAX_VALUE;
    public View VhR;
    public MMActivity gte;
    private ImageButton oui;
    public int state = 0;
    private boolean ziU = true;

    public interface a {
        boolean afZ(String str);
    }

    public interface b {
        void bau(String str);

        void bav(String str);
    }

    static /* synthetic */ int e(WebViewRedesignInputFooter webViewRedesignInputFooter) {
        AppMethodBeat.i(212140);
        int gfz = webViewRedesignInputFooter.gfz();
        AppMethodBeat.o(212140);
        return gfz;
    }

    static /* synthetic */ void h(WebViewRedesignInputFooter webViewRedesignInputFooter) {
        AppMethodBeat.i(212141);
        webViewRedesignInputFooter.cbM();
        AppMethodBeat.o(212141);
    }

    public void setOnTextSendListener(b bVar) {
        this.JAU = bVar;
    }

    public void setOnSmileyChosenListener(a aVar) {
        this.JAV = aVar;
    }

    public void setOnSmileyPanelVisibilityChangedListener(WebViewInputFooter.b bVar) {
        this.JAJ = bVar;
    }

    public WebViewRedesignInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(212130);
        this.gte = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.gte, R.layout.cbv, this);
        this.JAP = (LinearLayout) viewGroup.findViewById(R.id.jkp);
        this.JAM = viewGroup.findViewById(R.id.jkt);
        this.JAN = viewGroup.findViewById(R.id.jks);
        this.JAL = viewGroup.findViewById(R.id.jku);
        this.JAO = (MMEditText) viewGroup.findViewById(R.id.jkq);
        this.JAW = (TextView) viewGroup.findViewById(R.id.jl4);
        this.oui = (ImageButton) viewGroup.findViewById(R.id.jkv);
        this.oui.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass2 */

            @SuppressLint({"ResourceType"})
            public final void onClick(View view) {
                AppMethodBeat.i(259803);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WebViewRedesignInputFooter.this.state == 0) {
                    WebViewRedesignInputFooter.this.state = 1;
                    WebViewRedesignInputFooter.this.gte.hideVKB();
                    if (!WebViewRedesignInputFooter.this.JAQ) {
                        WebViewRedesignInputFooter.this.JAO.requestFocus();
                    }
                    WebViewRedesignInputFooter.e(WebViewRedesignInputFooter.this);
                    WebViewRedesignInputFooter.this.oui.setImageResource(R.raw.icons_outlined_emoji);
                    WebViewRedesignInputFooter.this.ziU = false;
                } else {
                    WebViewRedesignInputFooter.this.state = 0;
                    WebViewRedesignInputFooter.this.ziU = false;
                    WebViewRedesignInputFooter.this.JAO.requestFocus();
                    WebViewRedesignInputFooter.this.gte.showVKB();
                    WebViewRedesignInputFooter.h(WebViewRedesignInputFooter.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(259803);
            }
        });
        this.JAO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(259804);
                WebViewRedesignInputFooter.this.ziU = false;
                WebViewRedesignInputFooter.this.JAK.setVisibility(8);
                WebViewSmileyPanel unused = WebViewRedesignInputFooter.this.JAK;
                WebViewRedesignInputFooter.this.oui.setImageResource(R.drawable.of);
                WebViewRedesignInputFooter.this.state = 0;
                AppMethodBeat.o(259804);
                return false;
            }
        });
        this.JAK = new WebViewSmileyPanel(getContext());
        this.JAK.setVisibility(8);
        this.JAK.setBackgroundResource(R.drawable.b6d);
        this.JAK.setOnTextOperationListener(new WebViewSmileyPanel.a() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a
            public final void append(String str) {
                AppMethodBeat.i(259805);
                try {
                    if (WebViewRedesignInputFooter.this.JAQ) {
                        WebViewRedesignInputFooter.this.JAV.afZ(str);
                        AppMethodBeat.o(259805);
                        return;
                    }
                    WebViewRedesignInputFooter.this.JAO.bol(str);
                    AppMethodBeat.o(259805);
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e2);
                    AppMethodBeat.o(259805);
                }
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a
            public final void aHC() {
                AppMethodBeat.i(259806);
                if (!WebViewRedesignInputFooter.this.JAQ || WebViewRedesignInputFooter.this.JAV == null) {
                    if (WebViewRedesignInputFooter.this.JAO != null) {
                        WebViewRedesignInputFooter.this.JAO.gYD();
                    }
                    AppMethodBeat.o(259806);
                    return;
                }
                WebViewRedesignInputFooter.this.JAV.afZ("[DELETE_EMOTION]");
                AppMethodBeat.o(259806);
            }
        });
        ((LinearLayout) findViewById(R.id.h8v)).addView(this.JAK, -1, 0);
        this.JAN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(259808);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.f(WebViewRedesignInputFooter.this.JAO).aoq(WebViewRedesignInputFooter.this.JAR <= 0 ? Integer.MAX_VALUE : WebViewRedesignInputFooter.this.JAR * 2).a(f.a.MODE_CHINESE_AS_2).CN(true).a(new c.a() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tw(String str) {
                        AppMethodBeat.i(259807);
                        if (WebViewRedesignInputFooter.this.JAU != null) {
                            WebViewRedesignInputFooter.this.JAU.bau(WebViewRedesignInputFooter.this.JAO.getText().toString());
                        }
                        WebViewRedesignInputFooter.this.clearText();
                        AppMethodBeat.o(259807);
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tx(String str) {
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void dv(String str) {
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(259808);
            }
        });
        this.JAO.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass6 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(259809);
                if (WebViewRedesignInputFooter.this.JAO.getText() == null) {
                    AppMethodBeat.o(259809);
                    return;
                }
                WebViewRedesignInputFooter.this.JAO.requestFocus();
                WebViewRedesignInputFooter.a(WebViewRedesignInputFooter.this, editable.length() > 0 && editable.toString().trim().length() > 0);
                AppMethodBeat.o(259809);
            }
        });
        AppMethodBeat.o(212130);
    }

    public void setInputShadowView(View view) {
        AppMethodBeat.i(259811);
        this.VhR = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(212122);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WebViewRedesignInputFooter.this.hide();
                    WebViewRedesignInputFooter.this.clearText();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(212122);
                }
            });
        }
        AppMethodBeat.o(259811);
    }

    public final int gfz() {
        AppMethodBeat.i(212131);
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
            AppMethodBeat.o(212131);
            return i2;
        }
        AppMethodBeat.o(212131);
        return 0;
    }

    @SuppressLint({"ResourceType"})
    public final void cbM() {
        AppMethodBeat.i(212132);
        if (this.JAJ != null) {
            this.JAJ.gbQ();
        }
        this.JAK.setVisibility(8);
        this.oui.setImageResource(R.raw.icons_outlined_emoji);
        this.state = 0;
        AppMethodBeat.o(212132);
    }

    public final void clearText() {
        AppMethodBeat.i(212134);
        this.JAO.clearComposingText();
        this.JAO.setText("");
        AppMethodBeat.o(212134);
    }

    public void setText(String str) {
        AppMethodBeat.i(212135);
        if (this.JAO == null) {
            Log.e("MicroMsg.WebViewInputFooter", "contentEditText is null!");
            AppMethodBeat.o(212135);
            return;
        }
        this.JAO.setHint("");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(212135);
            return;
        }
        try {
            this.JAO.setHint(str);
            AppMethodBeat.o(212135);
        } catch (Exception e2) {
            Log.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e2);
            AppMethodBeat.o(212135);
        }
    }

    public void setShowRemindWordCount(int i2) {
        this.JAX = i2;
    }

    public void setMaxCount(int i2) {
        AppMethodBeat.i(212136);
        this.JAR = 0;
        if (i2 <= 0) {
            this.JAO.setFilters(new InputFilter[0]);
            AppMethodBeat.o(212136);
            return;
        }
        this.JAR = i2;
        this.JAO.setFilters(new InputFilter[]{new f(this.JAR * 2, f.a.MODE_CHINESE_AS_2) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.AnonymousClass7 */

            @Override // com.tencent.mm.ui.tools.f
            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                AppMethodBeat.i(259810);
                int a2 = a(spanned.toString(), f.a.MODE_CHINESE_AS_2) + a(charSequence.toString(), f.a.MODE_CHINESE_AS_2);
                int i6 = WebViewRedesignInputFooter.this.JAR * 2;
                int i7 = (WebViewRedesignInputFooter.this.JAR * 2) - (WebViewRedesignInputFooter.this.JAX * 2);
                if (i7 > i6 || i7 <= 0) {
                    i7 = i6;
                }
                if (a2 >= i6) {
                    String safeFormatString = Util.safeFormatString(WebViewRedesignInputFooter.this.gte.getString(R.string.iz4), Integer.valueOf(WebViewRedesignInputFooter.this.JAR));
                    WebViewRedesignInputFooter.this.JAW.setVisibility(0);
                    WebViewRedesignInputFooter.this.JAW.setText(safeFormatString);
                    AppMethodBeat.o(259810);
                    return "";
                } else if (a2 > i7) {
                    WebViewRedesignInputFooter.this.JAW.setVisibility(0);
                    WebViewRedesignInputFooter.this.JAW.setText(Util.safeFormatString(WebViewRedesignInputFooter.this.gte.getString(R.string.iz3), Integer.valueOf((i6 - a2) / 2)));
                    AppMethodBeat.o(259810);
                    return charSequence;
                } else {
                    WebViewRedesignInputFooter.this.JAW.setVisibility(8);
                    AppMethodBeat.o(259810);
                    return charSequence;
                }
            }
        }});
        AppMethodBeat.o(212136);
    }

    public final void giE() {
        AppMethodBeat.i(212137);
        if (this.JAO != null) {
            this.JAO.clearFocus();
            this.JAO.setFocusable(false);
            this.JAO.setFocusableInTouchMode(false);
        }
        AppMethodBeat.o(212137);
    }

    public final void hide() {
        AppMethodBeat.i(212138);
        if (this.VhR != null) {
            this.VhR.setVisibility(8);
        }
        setVisibility(8);
        String str = "";
        if (this.gte != null) {
            if (this.JAO != null) {
                this.gte.hideVKB(this.JAO);
                str = this.JAO.getText().toString();
            }
            this.gte.hideVKB();
        }
        this.state = 0;
        cbM();
        giE();
        if (this.JAU != null) {
            this.JAU.bav(str);
        }
        AppMethodBeat.o(212138);
    }

    public boolean isShown() {
        AppMethodBeat.i(212139);
        if (getVisibility() == 0) {
            AppMethodBeat.o(212139);
            return true;
        }
        AppMethodBeat.o(212139);
        return false;
    }

    static /* synthetic */ void a(WebViewRedesignInputFooter webViewRedesignInputFooter, boolean z) {
        AppMethodBeat.i(212142);
        Animation loadAnimation = AnimationUtils.loadAnimation(webViewRedesignInputFooter.getContext(), R.anim.dd);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(webViewRedesignInputFooter.getContext(), R.anim.di);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (webViewRedesignInputFooter.JAM == null || webViewRedesignInputFooter.JAN == null) {
            AppMethodBeat.o(212142);
            return;
        }
        if (z) {
            if (webViewRedesignInputFooter.JAM.getVisibility() == 8 || webViewRedesignInputFooter.JAM.getVisibility() == 4) {
                AppMethodBeat.o(212142);
                return;
            }
            webViewRedesignInputFooter.JAN.startAnimation(loadAnimation);
            webViewRedesignInputFooter.JAN.setVisibility(0);
            webViewRedesignInputFooter.JAM.startAnimation(loadAnimation2);
            webViewRedesignInputFooter.JAM.setVisibility(8);
        } else if (webViewRedesignInputFooter.JAM.getVisibility() == 0 || webViewRedesignInputFooter.JAM.getVisibility() == 0) {
            AppMethodBeat.o(212142);
            return;
        } else {
            webViewRedesignInputFooter.JAM.startAnimation(loadAnimation);
            webViewRedesignInputFooter.JAM.setVisibility(0);
            webViewRedesignInputFooter.JAN.startAnimation(loadAnimation2);
            webViewRedesignInputFooter.JAN.setVisibility(8);
        }
        webViewRedesignInputFooter.JAN.getParent().requestLayout();
        AppMethodBeat.o(212142);
    }
}
