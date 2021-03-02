package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;

public class ModSafeDeviceNameUI extends MMActivity implements i {
    private long createTime;
    private String dGP;
    private ProgressDialog gtM = null;
    private EditText kiW;
    private String kiX;
    private String kiY;
    private String kiZ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125549);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(125549);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(125550);
        g.azz().a(361, this);
        super.onResume();
        AppMethodBeat.o(125550);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(125551);
        g.azz().b(361, this);
        super.onPause();
        AppMethodBeat.o(125551);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(125552);
        this.kiX = getIntent().getStringExtra("safe_device_name");
        this.kiZ = getIntent().getStringExtra("safe_device_uid");
        this.dGP = getIntent().getStringExtra("safe_device_type");
        setMMTitle(a.aI(this, R.string.ga5));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125544);
                ModSafeDeviceNameUI.this.finish();
                AppMethodBeat.o(125544);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125546);
                ModSafeDeviceNameUI.this.kiY = ModSafeDeviceNameUI.this.kiW.getText().toString();
                if (Util.isNullOrNil(ModSafeDeviceNameUI.this.kiY)) {
                    AppMethodBeat.o(125546);
                } else {
                    ModSafeDeviceNameUI.this.hideVKB();
                    final c cVar = new c(ModSafeDeviceNameUI.this.kiZ, ModSafeDeviceNameUI.this.kiY, ModSafeDeviceNameUI.this.dGP);
                    g.azz().a(cVar, 0);
                    ModSafeDeviceNameUI.this.gtM = h.a((Context) ModSafeDeviceNameUI.this, a.aI(ModSafeDeviceNameUI.this, R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.AnonymousClass2.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125545);
                            g.azz().a(cVar);
                            AppMethodBeat.o(125545);
                        }
                    });
                    AppMethodBeat.o(125546);
                }
                return true;
            }
        });
        AnonymousClass3 r1 = new MMEditText.b() {
            /* class com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.MMEditText.b
            public final void boS() {
                AppMethodBeat.i(125547);
                if (ModSafeDeviceNameUI.this.kiW.getText().toString().trim().length() > 0) {
                    ModSafeDeviceNameUI.this.enableOptionMenu(true);
                    AppMethodBeat.o(125547);
                    return;
                }
                ModSafeDeviceNameUI.this.enableOptionMenu(false);
                AppMethodBeat.o(125547);
            }
        };
        this.kiW = (EditText) findViewById(R.id.fip);
        MMEditText.c cVar = new MMEditText.c(this.kiW, null, 32);
        cVar.QCQ = r1;
        this.kiW.addTextChangedListener(cVar);
        if (!Util.isNullOrNil(this.kiX)) {
            this.kiW.setText(this.kiX);
            AppMethodBeat.o(125552);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(125552);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bbf;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(125553);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 0 && i3 == 0) {
            d dVar = new d();
            dVar.field_devicetype = this.dGP;
            dVar.field_name = this.kiY;
            dVar.field_uid = this.kiZ;
            dVar.field_createtime = this.createTime;
            com.tencent.mm.plugin.account.security.a.g.boR().update(dVar, new String[0]);
            h.cD(this, a.aI(this, R.string.ga9));
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(125548);
                    ModSafeDeviceNameUI.this.finish();
                    AppMethodBeat.o(125548);
                }
            }, 1000);
            AppMethodBeat.o(125553);
        } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
            AppMethodBeat.o(125553);
        } else {
            AppMethodBeat.o(125553);
        }
    }
}
