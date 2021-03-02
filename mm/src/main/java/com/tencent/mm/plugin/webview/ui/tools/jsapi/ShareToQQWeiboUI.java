package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;

public class ShareToQQWeiboUI extends MMActivity implements i {
    private TextView CYJ;
    private ProgressDialog gtM = null;
    private EditText nBD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0k;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(82051);
        super.onCreate(bundle);
        g.azz().a(26, this);
        initView();
        AppMethodBeat.o(82051);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(82052);
        g.azz().b(26, this);
        super.onDestroy();
        AppMethodBeat.o(82052);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(82053);
        setMMTitle(R.string.h0p);
        this.nBD = (EditText) findViewById(R.id.be9);
        this.CYJ = (TextView) findViewById(R.id.joi);
        String stringExtra = getIntent().getStringExtra("content");
        String stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.nBD.addTextChangedListener(new MMEditText.c(this.nBD, this.CYJ, 280));
        if (stringExtra.contains(stringExtra2)) {
            this.nBD.setText(stringExtra.trim());
        } else {
            this.nBD.setText(stringExtra + " " + stringExtra2);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(82048);
                ShareToQQWeiboUI.this.hideVKB();
                ShareToQQWeiboUI.this.finish();
                AppMethodBeat.o(82048);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yx), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(82050);
                final y yVar = new y(ShareToQQWeiboUI.this.getIntent().getIntExtra("type", 0), ShareToQQWeiboUI.this.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.this.nBD.getText().toString());
                g.azz().a(yVar, 0);
                ShareToQQWeiboUI shareToQQWeiboUI = ShareToQQWeiboUI.this;
                AppCompatActivity context = ShareToQQWeiboUI.this.getContext();
                ShareToQQWeiboUI.this.getString(R.string.zb);
                shareToQQWeiboUI.gtM = h.a((Context) context, ShareToQQWeiboUI.this.getString(R.string.j55), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI.AnonymousClass2.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(82049);
                        g.azz().a(yVar);
                        AppMethodBeat.o(82049);
                    }
                });
                AppMethodBeat.o(82050);
                return true;
            }
        });
        AppMethodBeat.o(82053);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(82054);
        Log.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() != 26) {
            AppMethodBeat.o(82054);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 0 && i3 == 0) {
            hideVKB();
            setResult(-1);
            finish();
            AppMethodBeat.o(82054);
            return;
        }
        setResult(1, new Intent().putExtra("err_code", i3));
        Toast.makeText(this, getString(R.string.h0j, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        AppMethodBeat.o(82054);
    }
}
