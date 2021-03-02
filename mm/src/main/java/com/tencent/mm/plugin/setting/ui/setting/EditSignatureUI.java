package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI extends MMActivity {
    private TextView CYJ;
    private MMEditText CYT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EditSignatureUI() {
        AppMethodBeat.i(73877);
        AppMethodBeat.o(73877);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0m;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73878);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(73878);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(73879);
        super.onDestroy();
        AppMethodBeat.o(73879);
    }

    /* access modifiers changed from: package-private */
    public class a implements TextWatcher {
        private int CYV;

        private a() {
            this.CYV = 60;
        }

        /* synthetic */ a(EditSignatureUI editSignatureUI, byte b2) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(73875);
            EditSignatureUI.this.enableOptionMenu(true);
            AppMethodBeat.o(73875);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(73876);
            this.CYV = f.dp(60, editable.toString());
            if (this.CYV < 0) {
                this.CYV = 0;
            }
            if (EditSignatureUI.this.CYJ != null) {
                EditSignatureUI.this.CYJ.setText(new StringBuilder().append(this.CYV).toString());
            }
            AppMethodBeat.o(73876);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73880);
        setMMTitle(R.string.gu0);
        this.CYT = (MMEditText) findViewById(R.id.be9);
        this.CYJ = (TextView) findViewById(R.id.joi);
        this.CYT.setText(l.b(this, Util.nullAsNil((String) g.aAh().azQ().get(12291, (Object) null)), this.CYT.getTextSize()));
        this.CYT.setSelection(this.CYT.getText().length());
        this.CYJ.setText(new StringBuilder().append(f.dp(60, this.CYT.getEditableText().toString())).toString());
        c.f(this.CYT).lv(0, 60).a((c.a) null);
        this.CYT.addTextChangedListener(new a(this, (byte) 0));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.AnonymousClass1 */

            {
                AppMethodBeat.i(161716);
                AppMethodBeat.o(161716);
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(182594);
                EditSignatureUI.this.hideVKB();
                EditSignatureUI.this.finish();
                AppMethodBeat.o(182594);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73873);
                String trim = EditSignatureUI.this.CYT.getText().toString().trim();
                String aqt = com.tencent.mm.n.c.aqt();
                if (Util.isNullOrNil(aqt) || !trim.matches(".*[" + aqt + "].*")) {
                    g.aAh().azQ().set(12291, trim);
                    EditSignatureUI.this.hideVKB();
                    EditSignatureUI.this.finish();
                    AppMethodBeat.o(73873);
                    return true;
                }
                h.c(EditSignatureUI.this.getContext(), EditSignatureUI.this.getString(R.string.e3v, new Object[]{aqt}), EditSignatureUI.this.getString(R.string.zb), true);
                AppMethodBeat.o(73873);
                return false;
            }
        }, null, t.b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.o(73880);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(73881);
        if (i2 == 4) {
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(73881);
        return onKeyDown;
    }
}
