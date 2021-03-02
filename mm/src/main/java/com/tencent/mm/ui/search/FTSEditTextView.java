package com.tencent.mm.ui.search;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class FTSEditTextView extends LinearLayout {
    private TextView GoP;
    private TextView GoQ;
    private TextView GpX;
    private boolean QnL = true;
    private View.OnClickListener QnM = new View.OnClickListener() {
        /* class com.tencent.mm.ui.search.FTSEditTextView.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(164178);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int i2 = -1;
            if (view.getId() == R.id.ign) {
                i2 = 0;
            } else if (view.getId() == R.id.igr) {
                i2 = 1;
            } else if (view.getId() == R.id.igv) {
                i2 = 2;
            }
            if (FTSEditTextView.this.QnN != null && i2 >= 0) {
                a aVar = FTSEditTextView.this.QnN;
                FTSEditTextView.this.qLQ.get(i2);
                aVar.dpw();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164178);
        }
    };
    private a QnN;
    private b QnO = b.UserInput;
    private String heA = "";
    protected View.OnFocusChangeListener heD = new View.OnFocusChangeListener() {
        /* class com.tencent.mm.ui.search.FTSEditTextView.AnonymousClass7 */

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(164179);
            if (FTSEditTextView.this.QnN != null) {
                FTSEditTextView.this.QnN.eh(z);
            }
            AppMethodBeat.o(164179);
        }
    };
    private WeImageView hex;
    private ImageButton hey;
    private View hez;
    private String hint;
    private List<a.c> qLQ;
    public EditText vy;

    public interface a {
        void a(String str, String str2, List<a.c> list, b bVar);

        boolean awE();

        void dpw();

        void eh(boolean z);

        void onClickClearTextBtn(View view);
    }

    static /* synthetic */ void d(FTSEditTextView fTSEditTextView) {
        AppMethodBeat.i(164202);
        fTSEditTextView.gXd();
        AppMethodBeat.o(164202);
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164183);
        init();
        AppMethodBeat.o(164183);
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164184);
        init();
        AppMethodBeat.o(164184);
    }

    /* access modifiers changed from: protected */
    public int getLayoutById() {
        return R.layout.an9;
    }

    /* access modifiers changed from: protected */
    public int getLimitInputLength() {
        return 100;
    }

    public final void clearText() {
        AppMethodBeat.i(164186);
        this.QnO = b.ClearText;
        if (this.QnL) {
            this.qLQ.clear();
        }
        this.vy.setText("");
        this.vy.setHint(this.hint);
        this.hey.setVisibility(8);
        gXd();
        this.QnO = b.UserInput;
        AppMethodBeat.o(164186);
    }

    public void setEditTextDrawableLeft(int i2) {
        AppMethodBeat.i(164187);
        if (i2 == -1) {
            this.vy.setCompoundDrawablesRelative(null, null, null, null);
            AppMethodBeat.o(164187);
            return;
        }
        Drawable drawable = getContext().getResources().getDrawable(i2);
        drawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), com.tencent.mm.cb.a.fromDPToPix(getContext(), 15));
        this.vy.setCompoundDrawablesRelative(drawable, null, null, null);
        AppMethodBeat.o(164187);
    }

    public final void awC() {
        AppMethodBeat.i(164188);
        postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.search.FTSEditTextView.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(164177);
                ((InputMethodManager) FTSEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.this.vy, 0);
                AppMethodBeat.o(164177);
            }
        }, 128);
        AppMethodBeat.o(164188);
    }

    public final void showVKB() {
        AppMethodBeat.i(205351);
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.vy, 0);
        AppMethodBeat.o(205351);
    }

    public final void hideVKB() {
        AppMethodBeat.i(205352);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.vy.getWindowToken(), 0);
        AppMethodBeat.o(205352);
    }

    public int getHighlightColor() {
        AppMethodBeat.i(164189);
        int highlightColor = this.vy.getHighlightColor();
        AppMethodBeat.o(164189);
        return highlightColor;
    }

    public final void O(String str, List<a.c> list) {
        AppMethodBeat.i(164190);
        a(str, list, b.UserInput);
        AppMethodBeat.o(164190);
    }

    private void a(String str, List<a.c> list, b bVar) {
        AppMethodBeat.i(164191);
        String trim = Util.nullAs(str, "").trim();
        if (trim.length() > getLimitInputLength()) {
            trim = trim.substring(0, getLimitInputLength()).replace("\n", " ");
        }
        this.qLQ.clear();
        if (list != null) {
            this.qLQ.addAll(list);
        }
        Log.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", trim, Integer.valueOf(this.qLQ.size()));
        this.QnO = b.SetText;
        this.vy.setText(trim);
        Selection.setSelection(this.vy.getText(), this.vy.getText().length());
        gXd();
        this.QnO = bVar;
        AppMethodBeat.o(164191);
    }

    public void setHintColor(int i2) {
        AppMethodBeat.i(205353);
        this.vy.setHintTextColor(i2);
        AppMethodBeat.o(205353);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(205354);
        this.vy.setTextColor(i2);
        AppMethodBeat.o(205354);
    }

    public final void awD() {
        AppMethodBeat.i(164192);
        this.vy.requestFocus();
        AppMethodBeat.o(164192);
    }

    public final void gUA() {
        AppMethodBeat.i(259385);
        this.vy.clearFocus();
        AppMethodBeat.o(259385);
    }

    public List<a.c> getTagList() {
        return this.qLQ;
    }

    public void setHint(String str) {
        AppMethodBeat.i(164194);
        this.vy.setHint(str);
        this.hint = str;
        AppMethodBeat.o(164194);
    }

    private void gXd() {
        AppMethodBeat.i(164195);
        Log.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", Integer.valueOf(this.qLQ.size()));
        float aG = (float) com.tencent.mm.cb.a.aG(getContext(), R.dimen.is);
        if (this.qLQ.size() > 0) {
            this.GoP.setVisibility(0);
            this.GoP.setText(com.tencent.mm.ui.g.c.b.c(getContext(), this.qLQ.get(0).getTagName(), aG));
        } else {
            this.GoP.setVisibility(8);
        }
        if (this.qLQ.size() >= 2) {
            this.GoQ.setVisibility(0);
            this.GoQ.setText(com.tencent.mm.ui.g.c.b.c(getContext(), this.qLQ.get(1).getTagName(), aG));
        } else {
            this.GoQ.setVisibility(8);
        }
        if (this.qLQ.size() >= 3) {
            this.GpX.setVisibility(0);
            this.GpX.setText(com.tencent.mm.ui.g.c.b.c(getContext(), this.qLQ.get(2).getTagName(), aG));
            AppMethodBeat.o(164195);
            return;
        }
        this.GpX.setVisibility(8);
        AppMethodBeat.o(164195);
    }

    public WeImageView getIconView() {
        return this.hex;
    }

    public EditText getEditText() {
        return this.vy;
    }

    public ImageButton getClearBtn() {
        return this.hey;
    }

    public void setFtsEditTextListener(a aVar) {
        this.QnN = aVar;
    }

    public String getInEditTextQuery() {
        AppMethodBeat.i(164196);
        String trim = this.vy.getText().toString().trim();
        AppMethodBeat.o(164196);
        return trim;
    }

    public String getTotalQuery() {
        AppMethodBeat.i(164197);
        StringBuffer stringBuffer = new StringBuffer();
        for (a.c cVar : this.qLQ) {
            stringBuffer.append(cVar.getTagName());
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.vy.getText().toString());
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.o(164197);
        return trim;
    }

    public enum b {
        UserInput,
        ClearText,
        SetText;

        public static b valueOf(String str) {
            AppMethodBeat.i(164181);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(164181);
            return bVar;
        }

        static {
            AppMethodBeat.i(164182);
            AppMethodBeat.o(164182);
        }
    }

    public final void gWY() {
        AppMethodBeat.i(164198);
        this.hex.setVisibility(8);
        AppMethodBeat.o(164198);
    }

    public final void gXe() {
        AppMethodBeat.i(164199);
        this.hex.setVisibility(0);
        AppMethodBeat.o(164199);
    }

    public final void gXf() {
        AppMethodBeat.i(164200);
        this.hey.setVisibility(8);
        AppMethodBeat.o(164200);
    }

    public final void gXg() {
        AppMethodBeat.i(164201);
        this.hey.setVisibility(0);
        AppMethodBeat.o(164201);
    }

    public View getTagPanel() {
        return this.hez;
    }

    public b getTextChangeStatus() {
        return this.QnO;
    }

    public void setCanDeleteTag(boolean z) {
        this.QnL = z;
    }

    /* access modifiers changed from: protected */
    public void init() {
        AppMethodBeat.i(164185);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), (ViewGroup) this, true);
        this.hez = findViewById(R.id.ih9);
        this.hex = (WeImageView) findViewById(R.id.dt5);
        this.vy = (EditText) findViewById(R.id.bxz);
        this.hey = (ImageButton) findViewById(R.id.b3g);
        this.GoP = (TextView) findViewById(R.id.ign);
        this.GoQ = (TextView) findViewById(R.id.igr);
        this.GpX = (TextView) findViewById(R.id.igv);
        this.qLQ = new ArrayList();
        this.vy.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.ui.search.FTSEditTextView.AnonymousClass1 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(164173);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (keyEvent.getAction() == 0 && 67 == i2) {
                    int selectionStart = FTSEditTextView.this.vy.getSelectionStart();
                    int selectionEnd = FTSEditTextView.this.vy.getSelectionEnd();
                    if (selectionStart == 0 && selectionEnd == 0 && FTSEditTextView.this.qLQ.size() > 0 && FTSEditTextView.this.QnL) {
                        FTSEditTextView.this.qLQ.remove(FTSEditTextView.this.qLQ.size() - 1);
                        FTSEditTextView.d(FTSEditTextView.this);
                        FTSEditTextView.e(FTSEditTextView.this);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(164173);
                return false;
            }
        });
        this.vy.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.search.FTSEditTextView.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(164174);
                String totalQuery = FTSEditTextView.this.getTotalQuery();
                if (totalQuery != FTSEditTextView.this.heA && !totalQuery.equals(FTSEditTextView.this.heA)) {
                    FTSEditTextView.this.heA = totalQuery;
                    if (totalQuery.length() > 0) {
                        FTSEditTextView.this.hey.setVisibility(0);
                    } else {
                        FTSEditTextView.this.hey.setVisibility(8);
                    }
                    FTSEditTextView.e(FTSEditTextView.this);
                }
                AppMethodBeat.o(164174);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.vy.setOnFocusChangeListener(this.heD);
        this.vy.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.ui.search.FTSEditTextView.AnonymousClass3 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(164175);
                if (3 != i2 || FTSEditTextView.this.QnN == null) {
                    AppMethodBeat.o(164175);
                    return false;
                }
                boolean awE = FTSEditTextView.this.QnN.awE();
                AppMethodBeat.o(164175);
                return awE;
            }
        });
        this.GoP.setOnClickListener(this.QnM);
        this.GoQ.setOnClickListener(this.QnM);
        this.GpX.setOnClickListener(this.QnM);
        this.hey.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.search.FTSEditTextView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(164176);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FTSEditTextView.this.clearText();
                if (FTSEditTextView.this.QnN != null) {
                    FTSEditTextView.this.QnN.onClickClearTextBtn(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(164176);
            }
        });
        c.f(this.vy).aoq(getLimitInputLength()).a(f.a.MODE_CHINESE_AS_1).a((c.a) null);
        if (ao.isDarkMode()) {
            this.hey.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(164185);
    }

    static /* synthetic */ void e(FTSEditTextView fTSEditTextView) {
        AppMethodBeat.i(164203);
        String inEditTextQuery = fTSEditTextView.getInEditTextQuery();
        if (fTSEditTextView.QnN != null) {
            fTSEditTextView.QnN.a(fTSEditTextView.getTotalQuery(), inEditTextQuery, fTSEditTextView.qLQ, fTSEditTextView.QnO);
        }
        if (inEditTextQuery.length() == 0) {
            fTSEditTextView.vy.setHint(fTSEditTextView.hint);
        }
        AppMethodBeat.o(164203);
    }
}
