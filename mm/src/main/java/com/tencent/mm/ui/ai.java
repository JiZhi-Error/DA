package com.tencent.mm.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public final class ai extends LinearLayout {
    private a OKG;
    private ImageView hNZ = ((ImageView) findViewById(R.id.ei));
    private ImageButton hey;
    private String hint;
    private Context mContext;
    private EditText ooo;

    public interface a {
        void onClickBackBtn(View view);
    }

    public ai(Context context) {
        super(context);
        AppMethodBeat.i(159103);
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.be, (ViewGroup) this, true);
        this.hNZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.ai.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(159100);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/SearchBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ai.this.OKG != null) {
                    ai.this.OKG.onClickBackBtn(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/SearchBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159100);
            }
        });
        this.ooo = (EditText) findViewById(R.id.hdv);
        this.ooo.requestFocus();
        this.hey = (ImageButton) findViewById(R.id.b3g);
        this.hey.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.ai.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(159101);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/SearchBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ai.b(ai.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/SearchBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159101);
            }
        });
        this.ooo.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.ai.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(159102);
                if (editable == null || editable.length() <= 0) {
                    ai.this.hey.setVisibility(8);
                    AppMethodBeat.o(159102);
                    return;
                }
                ai.this.hey.setVisibility(0);
                AppMethodBeat.o(159102);
            }
        });
        AppMethodBeat.o(159103);
    }

    public final void setSearchViewListener(a aVar) {
        this.OKG = aVar;
    }

    public final EditText getSearchEditText() {
        return this.ooo;
    }

    public final void setHint(String str) {
        this.hint = str;
    }

    static /* synthetic */ void b(ai aiVar) {
        AppMethodBeat.i(159104);
        aiVar.ooo.setText("");
        aiVar.ooo.setHint(aiVar.hint);
        aiVar.hey.setVisibility(8);
        AppMethodBeat.o(159104);
    }
}
