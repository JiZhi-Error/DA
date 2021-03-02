package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper extends LinearLayout implements d {
    private View QoG;
    private ImageButton QoI;
    private ActionBarSearchView.a QoN;
    public Button Qwv;
    private a Qww;
    private EditText vy;

    public interface a {
        boolean SN(String str);

        void ahN(String str);

        void cmh();
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143262);
        init();
        AppMethodBeat.o(143262);
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        AppMethodBeat.i(143263);
        init();
        AppMethodBeat.o(143263);
    }

    private void init() {
        AppMethodBeat.i(143264);
        aa.jQ(getContext()).inflate(R.layout.bg, (ViewGroup) this, true);
        this.vy = (EditText) findViewById(R.id.bxz);
        this.QoI = (ImageButton) findViewById(R.id.i59);
        this.QoG = findViewById(R.id.ay);
        this.Qwv = (Button) findViewById(R.id.agf);
        this.Qwv.setEnabled(false);
        this.vy.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(143257);
                if (editable == null || editable.length() <= 0) {
                    SearchViewNotRealTimeHelper.this.QoI.setVisibility(8);
                    SearchViewNotRealTimeHelper.this.Qwv.setEnabled(false);
                    AppMethodBeat.o(143257);
                    return;
                }
                SearchViewNotRealTimeHelper.this.QoI.setVisibility(0);
                SearchViewNotRealTimeHelper.this.Qwv.setEnabled(true);
                AppMethodBeat.o(143257);
            }
        });
        this.vy.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(143258);
                if (3 != i2 || SearchViewNotRealTimeHelper.this.Qww == null) {
                    AppMethodBeat.o(143258);
                    return false;
                }
                boolean SN = SearchViewNotRealTimeHelper.this.Qww.SN(SearchViewNotRealTimeHelper.this.getSearchContent());
                AppMethodBeat.o(143258);
                return SN;
            }
        });
        c.f(this.vy).aoq(100).a((c.a) null);
        this.QoI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(143259);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SearchViewNotRealTimeHelper.this.vy.setText("");
                if (SearchViewNotRealTimeHelper.this.Qww != null) {
                    SearchViewNotRealTimeHelper.this.Qww.cmh();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(143259);
            }
        });
        this.QoG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(143260);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
                if (SearchViewNotRealTimeHelper.this.Qww != null) {
                    a unused = SearchViewNotRealTimeHelper.this.Qww;
                }
                if (SearchViewNotRealTimeHelper.this.QoN != null) {
                    SearchViewNotRealTimeHelper.this.QoN.gXr();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(143260);
            }
        });
        this.Qwv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(143261);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SearchViewNotRealTimeHelper.this.Qww != null) {
                    SearchViewNotRealTimeHelper.this.Qww.ahN(SearchViewNotRealTimeHelper.this.getSearchContent());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(143261);
            }
        });
        AppMethodBeat.o(143264);
    }

    public void setSearchBtnText(CharSequence charSequence) {
        AppMethodBeat.i(143265);
        this.Qwv.setText(charSequence);
        AppMethodBeat.o(143265);
    }

    public void setSearchContent(CharSequence charSequence) {
        AppMethodBeat.i(143266);
        this.vy.setText("");
        this.vy.append(charSequence);
        AppMethodBeat.o(143266);
    }

    public void setSearchColor(int i2) {
        AppMethodBeat.i(143267);
        this.vy.setTextColor(i2);
        AppMethodBeat.o(143267);
    }

    public void setSearchHint(CharSequence charSequence) {
        AppMethodBeat.i(143268);
        this.vy.setHint(charSequence);
        AppMethodBeat.o(143268);
    }

    public void setSearchHintColor(int i2) {
        AppMethodBeat.i(143269);
        this.vy.setHintTextColor(i2);
        AppMethodBeat.o(143269);
    }

    public void setSearchIcon(int i2) {
        AppMethodBeat.i(143270);
        this.vy.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        AppMethodBeat.o(143270);
    }

    public void setShowBackIcon(boolean z) {
        AppMethodBeat.i(143271);
        if (this.QoG != null) {
            if (z) {
                this.QoG.setVisibility(0);
                AppMethodBeat.o(143271);
                return;
            }
            this.QoG.setVisibility(8);
        }
        AppMethodBeat.o(143271);
    }

    @Override // com.tencent.mm.ui.tools.d
    public final void CH(boolean z) {
        AppMethodBeat.i(143272);
        this.vy.setText("");
        AppMethodBeat.o(143272);
    }

    @Override // com.tencent.mm.ui.tools.d
    public final void gXo() {
        AppMethodBeat.i(143273);
        this.vy.clearFocus();
        AppMethodBeat.o(143273);
    }

    public void setCallBack(a aVar) {
        this.Qww = aVar;
    }

    @Override // com.tencent.mm.ui.tools.d
    public String getSearchContent() {
        AppMethodBeat.i(143274);
        Editable editableText = this.vy.getEditableText();
        if (editableText == null) {
            AppMethodBeat.o(143274);
            return "";
        }
        String obj = editableText.toString();
        AppMethodBeat.o(143274);
        return obj;
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setSearchContent(String str) {
        AppMethodBeat.i(143275);
        setSearchContent((CharSequence) str);
        AppMethodBeat.o(143275);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setHint(CharSequence charSequence) {
        AppMethodBeat.i(143276);
        setSearchHint(charSequence);
        AppMethodBeat.o(143276);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setCallBack(ActionBarSearchView.b bVar) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public final void CG(boolean z) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setEditTextEnabled(boolean z) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setStatusBtnEnabled(boolean z) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setNotRealCallBack(a aVar) {
        this.Qww = aVar;
    }

    public boolean hasFocus() {
        return false;
    }

    @Override // com.tencent.mm.ui.tools.d
    public final boolean gXq() {
        return false;
    }

    @Override // com.tencent.mm.ui.tools.d
    public final boolean gXp() {
        return false;
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setBackClickCallback(ActionBarSearchView.a aVar) {
        this.QoN = aVar;
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setKeywords(ArrayList<String> arrayList) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setAutoMatchKeywords(boolean z) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setSearchTipIcon(int i2) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setSelectedTag(String str) {
    }

    public int getSelectionStart() {
        return -1;
    }

    public int getSelectionEnd() {
        return -1;
    }
}
