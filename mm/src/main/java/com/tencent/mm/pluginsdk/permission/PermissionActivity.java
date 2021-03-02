package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public class PermissionActivity extends AppCompatActivity {
    private String[] JXG;
    private boolean JXH;
    private String JXI;
    private String JXJ;
    private Intent intent;
    private String key;
    private int requestCode;
    private int scene;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(223777);
        Resources resources = MMApplicationContext.getResources();
        AppMethodBeat.o(223777);
        return resources;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(151871);
        super.onCreate(bundle);
        if (getIntent() == null || !getIntent().hasExtra("scene")) {
            finish();
            AppMethodBeat.o(151871);
            return;
        }
        getWindow().addFlags(67108864);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        this.JXH = true;
        this.scene = getIntent().getIntExtra("scene", 1);
        this.key = getIntent().getStringExtra("key");
        if (this.scene == 1) {
            this.JXG = getIntent().getStringArrayExtra("permission");
            this.requestCode = getIntent().getIntExtra("requestCode", 0);
            if (!Util.isNullOrNil(this.JXG)) {
                Log.i("MicroMsg.PermissionActivity", "scene: %d, permission: %s, requestCode: %d", Integer.valueOf(this.scene), this.JXG.toString(), Integer.valueOf(this.requestCode));
                AppMethodBeat.o(151871);
                return;
            }
        } else if (this.scene == 2) {
            this.intent = getIntent().getSelector();
            this.JXI = getIntent().getStringExtra("reasonTitle");
            this.JXJ = getIntent().getStringExtra("reasonMsg");
            if (!Util.isNullOrNil(this.JXI) && !Util.isNullOrNil(this.JXJ)) {
                Log.i("MicroMsg.PermissionActivity", "scene: %d, reasonTitle: %s, reasonMsg: %s", Integer.valueOf(this.scene), this.JXI, this.JXJ);
                AppMethodBeat.o(151871);
                return;
            }
        } else if (this.scene == 3) {
            this.intent = getIntent().getSelector();
            if (this.intent != null) {
                Log.i("MicroMsg.PermissionActivity", "scene: %d, intent: %s", Integer.valueOf(this.scene), this.intent.toString());
                AppMethodBeat.o(151871);
                return;
            }
        } else if (this.scene == 4) {
            Log.i("MicroMsg.PermissionActivity", "scene: %d", Integer.valueOf(this.scene));
        }
        AppMethodBeat.o(151871);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(151872);
        Log.i("MicroMsg.PermissionActivity", "onResume(), scene=%d", Integer.valueOf(this.scene));
        super.onResume();
        if (this.JXH) {
            if (this.scene == 1) {
                b.a(this, this.JXG, this.requestCode);
            } else if (this.scene == 2) {
                if (!Util.isNullOrNil(this.JXJ) || !Util.isNullOrNil(this.JXI)) {
                    h.a((Context) this, false, this.JXJ, this.JXI, MMApplicationContext.getContext().getString(R.string.e_k), MMApplicationContext.getContext().getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.pluginsdk.permission.PermissionActivity.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(151867);
                            try {
                                Log.i("MicroMsg.PermissionActivity", "START_SETTINGS_REQUEST click ok");
                                PermissionActivity.this.startActivityForResult(PermissionActivity.this.intent, 1);
                                AppMethodBeat.o(151867);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(PermissionActivity.this.scene), e2.getMessage());
                                AppMethodBeat.o(151867);
                            }
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.pluginsdk.permission.PermissionActivity.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(151868);
                            PermissionActivity.this.finish();
                            AppMethodBeat.o(151868);
                        }
                    });
                } else {
                    try {
                        startActivityForResult(this.intent, 1);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(this.scene), e2.getMessage());
                    }
                }
            } else if (this.scene == 3) {
                if (Build.VERSION.SDK_INT < 26) {
                    a bl = new a().bl(this.intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else if (!getPackageManager().canRequestPackageInstalls()) {
                    try {
                        startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 1);
                    } catch (Exception e3) {
                        Log.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(this.scene), e3.getMessage());
                    }
                } else {
                    a bl2 = new a().bl(this.intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            } else if (this.scene == 4) {
                if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("954_95_first", true)) {
                    e.INSTANCE.idkeyStat(954, 95, 1, false);
                    MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("954_95_first", false);
                }
                e.INSTANCE.idkeyStat(954, 96, 1, false);
                h.a((Context) this, false, MMApplicationContext.getContext().getString(R.string.fl7), MMApplicationContext.getContext().getString(R.string.flp), MMApplicationContext.getContext().getString(R.string.e_k), MMApplicationContext.getContext().getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.permission.PermissionActivity.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(151869);
                        Log.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations ");
                        PermissionActivity.c(PermissionActivity.this);
                        AppMethodBeat.o(151869);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.permission.PermissionActivity.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(151870);
                        Log.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations app_cancel");
                        PermissionActivity.this.finish();
                        AppMethodBeat.o(151870);
                    }
                });
            }
            this.JXH = false;
            AppMethodBeat.o(151872);
            return;
        }
        this.JXH = true;
        AppMethodBeat.o(151872);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        c bdP;
        AppMethodBeat.i(151873);
        Log.i("MicroMsg.PermissionActivity", "onRequestPermissionsResult(),  scene=%d, requestCode=%d, permissions=%s, grantResults=%s", Integer.valueOf(this.scene), Integer.valueOf(i2), strArr.toString(), iArr.toString());
        if (this.scene == 1 && (bdP = b.bdP(this.key)) != null) {
            bdP.b(i2, iArr);
        }
        finish();
        AppMethodBeat.o(151873);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent2) {
        AppMethodBeat.i(151874);
        Log.i("MicroMsg.PermissionActivity", "onActivityResult(),  scene=%d, requestCode=%d, resultCode=%d", Integer.valueOf(this.scene), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.scene == 2) {
            d bdQ = b.bdQ(this.key);
            if (bdQ != null) {
                bdQ.Xq(i3);
            }
            finish();
            AppMethodBeat.o(151874);
        } else if (this.scene == 3) {
            if (i3 == -1) {
                a bl = new a().bl(this.intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                Toast.makeText(MMApplicationContext.getContext(), (int) R.string.fdq, 1).show();
            }
            finish();
            AppMethodBeat.o(151874);
        } else {
            if (this.scene == 4) {
                if (Build.VERSION.SDK_INT >= 23) {
                    boolean cf = c.cf(this);
                    if (cf) {
                        if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("954_84_first", true)) {
                            e.INSTANCE.idkeyStat(954, 84, 1, false);
                            MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("954_84_first", false);
                        }
                        c.dg(true);
                    }
                    Log.i("MicroMsg.PermissionActivity", "onActivityResult ADD_IGNORING_BATTERY_OPTIMIZATIONS result=%s", Boolean.valueOf(cf));
                }
                AppMethodBeat.o(151874);
            }
            finish();
            AppMethodBeat.o(151874);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(151875);
        Log.i("MicroMsg.PermissionActivity", "onDestroy(), scene=%d", Integer.valueOf(this.scene));
        if (this.scene == 1) {
            b.bdP(this.key);
        } else if (this.scene == 2) {
            b.bdQ(this.key);
        }
        super.onDestroy();
        AppMethodBeat.o(151875);
    }

    static /* synthetic */ void c(PermissionActivity permissionActivity) {
        AppMethodBeat.i(151876);
        Log.i("MicroMsg.PermissionActivity", "goIgnoreBatteryOptimizations()");
        try {
            permissionActivity.startActivityForResult(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + permissionActivity.getPackageName())), 1);
            if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("954_93_first", true)) {
                e.INSTANCE.idkeyStat(954, 93, 1, false);
                MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("954_93_first", false);
            }
            e.INSTANCE.idkeyStat(954, 94, 1, false);
            AppMethodBeat.o(151876);
        } catch (Exception e2) {
            Log.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(permissionActivity.scene), e2.getMessage());
            AppMethodBeat.o(151876);
        }
    }
}
