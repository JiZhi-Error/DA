package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter extends LinearLayout {
    private View JAA;
    private EditText JAB;
    private View JAC;
    private View JAD;
    private TextView JAE;
    private a JAF;
    private View okM;

    public interface a {
        void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        boolean c(int i2, KeyEvent keyEvent);

        void gbR();

        void gbS();

        void gbT();
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(82297);
        init();
        AppMethodBeat.o(82297);
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(82298);
        init();
        AppMethodBeat.o(82298);
    }

    private void init() {
        AppMethodBeat.i(82299);
        View inflate = inflate(getContext(), R.layout.cbw, this);
        this.JAB = (EditText) inflate.findViewById(R.id.bxz);
        this.okM = inflate.findViewById(R.id.b46);
        this.JAC = inflate.findViewById(R.id.gfy);
        this.JAD = inflate.findViewById(R.id.fz4);
        this.JAE = (TextView) inflate.findViewById(R.id.dxt);
        this.JAA = inflate.findViewById(R.id.dyt);
        this.okM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(82290);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WebViewSearchContentInputFooter.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82290);
            }
        });
        this.JAC.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(82291);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WebViewSearchContentInputFooter.this.JAF != null) {
                    WebViewSearchContentInputFooter.this.JAF.gbS();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82291);
            }
        });
        this.JAD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(82292);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WebViewSearchContentInputFooter.this.JAF != null) {
                    WebViewSearchContentInputFooter.this.JAF.gbT();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82292);
            }
        });
        this.JAB.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.AnonymousClass4 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(82293);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (WebViewSearchContentInputFooter.this.JAF != null) {
                    WebViewSearchContentInputFooter.this.JAF.c(i2, keyEvent);
                }
                if (i2 != 66 || WebViewSearchContentInputFooter.this.JAF == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(82293);
                    return false;
                }
                Context context = view.getContext();
                if (context instanceof MMActivity) {
                    ((MMActivity) context).hideVKB(WebViewSearchContentInputFooter.this.JAB);
                }
                WebViewSearchContentInputFooter.this.JAF.b(WebViewSearchContentInputFooter.this);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(82293);
                return true;
            }
        });
        this.JAB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.AnonymousClass5 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(82294);
                if (!z && WebViewSearchContentInputFooter.this.JAF != null) {
                    Context context = view.getContext();
                    if (context instanceof MMActivity) {
                        ((MMActivity) context).hideVKB(WebViewSearchContentInputFooter.this.JAB);
                    }
                }
                WebViewSearchContentInputFooter.this.JAA.setSelected(z);
                AppMethodBeat.o(82294);
            }
        });
        this.JAB.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.AnonymousClass6 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(82295);
                if (WebViewSearchContentInputFooter.this.JAF != null) {
                    a aVar = WebViewSearchContentInputFooter.this.JAF;
                    WebViewSearchContentInputFooter webViewSearchContentInputFooter = WebViewSearchContentInputFooter.this;
                    if (charSequence != null) {
                        charSequence.toString();
                    }
                    aVar.a(webViewSearchContentInputFooter);
                }
                AppMethodBeat.o(82295);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.JAB.setSelectAllOnFocus(true);
        reset();
        AppMethodBeat.o(82299);
    }

    public final void reset() {
        AppMethodBeat.i(82300);
        this.JAE.setText("");
        this.JAC.setEnabled(false);
        this.JAD.setEnabled(false);
        AppMethodBeat.o(82300);
    }

    public final void giD() {
        AppMethodBeat.i(82301);
        this.JAB.setText("");
        AppMethodBeat.o(82301);
    }

    public boolean isShown() {
        AppMethodBeat.i(82302);
        if (getVisibility() == 0) {
            AppMethodBeat.o(82302);
            return true;
        }
        AppMethodBeat.o(82302);
        return false;
    }

    public final void show() {
        AppMethodBeat.i(82303);
        setVisibility(0);
        this.JAB.requestFocus();
        postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(82296);
                MMActivity.showVKB((Activity) WebViewSearchContentInputFooter.this.getContext());
                AppMethodBeat.o(82296);
            }
        }, 100);
        AppMethodBeat.o(82303);
    }

    public final void hide() {
        AppMethodBeat.i(82304);
        Context context = this.JAB.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).hideVKB(this.JAB);
        }
        this.JAB.clearFocus();
        setVisibility(8);
        if (this.JAF != null) {
            this.JAF.gbR();
        }
        AppMethodBeat.o(82304);
    }

    public final void H(int i2, int i3, boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(82305);
        if (!z) {
            AppMethodBeat.o(82305);
            return;
        }
        TextView textView = this.JAE;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i3 == 0 ? 0 : i2 + 1);
        objArr[1] = Integer.valueOf(i3);
        textView.setText(String.format("%d/%d", objArr));
        View view = this.JAD;
        if (i3 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        view.setEnabled(z2);
        View view2 = this.JAC;
        if (i3 <= 0) {
            z3 = false;
        }
        view2.setEnabled(z3);
        AppMethodBeat.o(82305);
    }

    public void setActionDelegate(a aVar) {
        this.JAF = aVar;
    }

    public String getSearchContent() {
        AppMethodBeat.i(82306);
        String obj = this.JAB.getText().toString();
        AppMethodBeat.o(82306);
        return obj;
    }
}
