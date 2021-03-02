package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class ContactSearchUI extends MMActivity implements i {
    private EditText FNd;
    private ProgressDialog gtM = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(ContactSearchUI contactSearchUI) {
        AppMethodBeat.i(29227);
        contactSearchUI.ftt();
        AppMethodBeat.o(29227);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.y_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29220);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(29220);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(29221);
        bg.azz().a(106, this);
        super.onResume();
        AppMethodBeat.o(29221);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29222);
        bg.azz().b(106, this);
        super.onPause();
        AppMethodBeat.o(29222);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29223);
        setMMTitle(R.string.bia);
        this.FNd = (EditText) findViewById(R.id.bdf);
        this.FNd.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(29215);
                ContactSearchUI.this.enableOptionMenu(editable.length() > 0);
                AppMethodBeat.o(29215);
            }
        });
        this.FNd.setImeOptions(3);
        this.FNd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(29216);
                if (keyEvent != null && keyEvent.getKeyCode() == 66 && !Util.isNullOrNil(ContactSearchUI.this.FNd.getText().toString().trim())) {
                    ContactSearchUI.b(ContactSearchUI.this);
                }
                AppMethodBeat.o(29216);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.vf), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29217);
                ContactSearchUI.b(ContactSearchUI.this);
                AppMethodBeat.o(29217);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29218);
                ContactSearchUI.this.hideVKB();
                ContactSearchUI.this.finish();
                AppMethodBeat.o(29218);
                return true;
            }
        });
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.FNd.setText(getIntent().getStringExtra("userName"));
            ftt();
        }
        AppMethodBeat.o(29223);
    }

    private void ftt() {
        AppMethodBeat.i(29224);
        String trim = this.FNd.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.n(getContext(), R.string.hvi, R.string.zb);
            AppMethodBeat.o(29224);
            return;
        }
        Log.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        final f fVar = new f(trim, 1);
        bg.azz().a(fVar, 0);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.ft), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(29219);
                bg.azz().a(fVar);
                AppMethodBeat.o(29219);
            }
        });
        AppMethodBeat.o(29224);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(29225);
        Log.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (b.jRu.b(getContext(), i2, i3, str)) {
            AppMethodBeat.o(29225);
        } else if (i2 == 4 && i3 == -4) {
            h.n(getContext(), R.string.fn, R.string.zb);
            AppMethodBeat.o(29225);
        } else if (i2 == 0 && i3 == 0) {
            drt eiq = ((f) qVar).eiq();
            if (eiq.LUB > 0) {
                Intent intent = new Intent();
                intent.setClass(this, ContactSearchResultUI.class);
                try {
                    intent.putExtra("result", eiq.toByteArray());
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(29225);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.ContactSearchUI", e2, "", new Object[0]);
                    AppMethodBeat.o(29225);
                }
            } else {
                String a2 = z.a(eiq.Lqk);
                Intent intent2 = new Intent();
                ((k) g.af(k.class)).a(intent2, eiq, aSQ(this.FNd.getText().toString().trim()));
                if (Util.nullAsNil(a2).length() > 0) {
                    if ((eiq.MmK & 8) > 0) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, a2 + "," + aSQ(this.FNd.getText().toString().trim()));
                    }
                    c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                }
                AppMethodBeat.o(29225);
            }
        } else {
            Toast.makeText(this, getString(R.string.dg4), 0).show();
            Log.w("MicroMsg.ContactSearchUI", getString(R.string.dg3, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            AppMethodBeat.o(29225);
        }
    }

    private static int aSQ(String str) {
        AppMethodBeat.i(29226);
        if (Util.isValidQQNum(str)) {
            AppMethodBeat.o(29226);
            return 1;
        } else if (Util.isValidEmail(str)) {
            AppMethodBeat.o(29226);
            return 2;
        } else if (Util.isValidAccount(str)) {
            AppMethodBeat.o(29226);
            return 3;
        } else {
            AppMethodBeat.o(29226);
            return 3;
        }
    }
}
