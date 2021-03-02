package com.tencent.mm.emojisearch.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class EmojiSearchEditTextView extends LinearLayout {
    private String heA = "";
    private a heB;
    b heC = b.UserInput;
    protected View.OnFocusChangeListener heD = new View.OnFocusChangeListener() {
        /* class com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.AnonymousClass6 */

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(199761);
            if (EmojiSearchEditTextView.this.heB != null) {
                EmojiSearchEditTextView.this.heB.eh(z);
            }
            AppMethodBeat.o(199761);
        }
    };
    private WeImageView hex;
    ImageButton hey;
    private View hez;
    String hint;
    EditText vy;

    public interface a {
        void a(String str, String str2, b bVar);

        boolean awE();

        void eh(boolean z);

        void onClickClearTextBtn(View view);
    }

    public EmojiSearchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(199765);
        init();
        AppMethodBeat.o(199765);
    }

    public EmojiSearchEditTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(199766);
        init();
        AppMethodBeat.o(199766);
    }

    private void awB() {
        AppMethodBeat.i(199767);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), (ViewGroup) this, true);
        AppMethodBeat.o(199767);
    }

    /* access modifiers changed from: protected */
    public int getLayoutById() {
        return R.layout.a2g;
    }

    private void init() {
        AppMethodBeat.i(199768);
        awB();
        this.hez = findViewById(R.id.ih9);
        this.hex = (WeImageView) findViewById(R.id.dt5);
        this.vy = (EditText) findViewById(R.id.bxz);
        this.hey = (ImageButton) findViewById(R.id.b3g);
        this.vy.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.AnonymousClass1 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(199756);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                keyEvent.getAction();
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(199756);
                return false;
            }
        });
        this.vy.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(199757);
                String totalQuery = EmojiSearchEditTextView.this.getTotalQuery();
                if (totalQuery != EmojiSearchEditTextView.this.heA && !totalQuery.equals(EmojiSearchEditTextView.this.heA)) {
                    EmojiSearchEditTextView.this.heA = totalQuery;
                    if (totalQuery.length() > 0) {
                        EmojiSearchEditTextView.this.hey.setVisibility(0);
                    } else {
                        EmojiSearchEditTextView.this.hey.setVisibility(8);
                    }
                    EmojiSearchEditTextView.c(EmojiSearchEditTextView.this);
                }
                AppMethodBeat.o(199757);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.vy.setOnFocusChangeListener(this.heD);
        this.vy.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.AnonymousClass3 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(199758);
                if (3 != i2 || EmojiSearchEditTextView.this.heB == null) {
                    AppMethodBeat.o(199758);
                    return false;
                }
                boolean awE = EmojiSearchEditTextView.this.heB.awE();
                AppMethodBeat.o(199758);
                return awE;
            }
        });
        this.hey.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(199759);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EmojiSearchEditTextView emojiSearchEditTextView = EmojiSearchEditTextView.this;
                emojiSearchEditTextView.heC = b.ClearText;
                emojiSearchEditTextView.vy.setText("");
                emojiSearchEditTextView.vy.setHint(emojiSearchEditTextView.hint);
                emojiSearchEditTextView.hey.setVisibility(8);
                emojiSearchEditTextView.heC = b.UserInput;
                if (EmojiSearchEditTextView.this.heB != null) {
                    EmojiSearchEditTextView.this.heB.onClickClearTextBtn(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(199759);
            }
        });
        c.f(this.vy).aoq(100).a((c.a) null);
        if (ao.isDarkMode()) {
            this.hey.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(199768);
    }

    public void setEditTextDrawableLeft(int i2) {
        AppMethodBeat.i(199769);
        if (i2 == -1) {
            this.vy.setCompoundDrawablesRelative(null, null, null, null);
            AppMethodBeat.o(199769);
            return;
        }
        Drawable drawable = getContext().getResources().getDrawable(i2);
        drawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), com.tencent.mm.cb.a.fromDPToPix(getContext(), 15));
        this.vy.setCompoundDrawablesRelative(drawable, null, null, null);
        AppMethodBeat.o(199769);
    }

    public final void awC() {
        AppMethodBeat.i(199770);
        postDelayed(new Runnable() {
            /* class com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(199760);
                ((InputMethodManager) EmojiSearchEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(EmojiSearchEditTextView.this.vy, 1);
                AppMethodBeat.o(199760);
            }
        }, 128);
        AppMethodBeat.o(199770);
    }

    public int getHighlightColor() {
        AppMethodBeat.i(199771);
        int highlightColor = this.vy.getHighlightColor();
        AppMethodBeat.o(199771);
        return highlightColor;
    }

    public void setText(SpannableString spannableString) {
        AppMethodBeat.i(199772);
        b bVar = b.UserInput;
        Log.i("MicroMsg.EmojiSearch", "setText: %s", spannableString);
        this.heC = b.SetText;
        this.vy.setText(spannableString);
        Selection.setSelection(this.vy.getText(), this.vy.getText().length());
        this.heC = bVar;
        AppMethodBeat.o(199772);
    }

    public void setText(String str) {
        AppMethodBeat.i(199773);
        b bVar = b.UserInput;
        Log.i("MicroMsg.EmojiSearch", "setText: %s", str);
        this.heC = b.SetText;
        this.vy.setText(str);
        Selection.setSelection(this.vy.getText(), this.vy.getText().length());
        this.heC = bVar;
        AppMethodBeat.o(199773);
    }

    public final void awD() {
        AppMethodBeat.i(199774);
        this.vy.requestFocus();
        AppMethodBeat.o(199774);
    }

    public void setHint(String str) {
        AppMethodBeat.i(199775);
        this.vy.setHint(str);
        this.hint = str;
        AppMethodBeat.o(199775);
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

    public void setEmojiSearchEditTextListener(a aVar) {
        this.heB = aVar;
    }

    public String getInEditTextQuery() {
        AppMethodBeat.i(199776);
        String trim = this.vy.getText().toString().trim();
        AppMethodBeat.o(199776);
        return trim;
    }

    public String getTotalQuery() {
        AppMethodBeat.i(199777);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.vy.getText().toString());
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.o(199777);
        return trim;
    }

    public enum b {
        UserInput,
        ClearText,
        SetText;

        public static b valueOf(String str) {
            AppMethodBeat.i(199763);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(199763);
            return bVar;
        }

        static {
            AppMethodBeat.i(199764);
            AppMethodBeat.o(199764);
        }
    }

    public View getTagPanel() {
        return this.hez;
    }

    public b getTextChangeStatus() {
        return this.heC;
    }

    static /* synthetic */ void c(EmojiSearchEditTextView emojiSearchEditTextView) {
        AppMethodBeat.i(199778);
        String inEditTextQuery = emojiSearchEditTextView.getInEditTextQuery();
        if (emojiSearchEditTextView.heB != null) {
            emojiSearchEditTextView.heB.a(emojiSearchEditTextView.getTotalQuery(), inEditTextQuery, emojiSearchEditTextView.heC);
        }
        if (inEditTextQuery.length() == 0) {
            emojiSearchEditTextView.vy.setHint(emojiSearchEditTextView.hint);
        }
        AppMethodBeat.o(199778);
    }
}
