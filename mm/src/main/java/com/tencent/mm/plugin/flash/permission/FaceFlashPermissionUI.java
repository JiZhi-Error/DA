package com.tencent.mm.plugin.flash.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.flash.action.FaceFlashActionUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;

@a(3)
public class FaceFlashPermissionUI extends MMActivity {
    private d jzT;
    private boolean wIB = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ Intent bp(int i2, String str) {
        AppMethodBeat.i(186665);
        Intent bo = bo(i2, str);
        AppMethodBeat.o(186665);
        return bo;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(186659);
        super.onCreate(bundle);
        AppMethodBeat.o(186659);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(186660);
        super.onResume();
        if (this.wIB) {
            Log.i("MicroMsg.FaceFlashManagerPermission", "has check permission success");
            AppMethodBeat.o(186660);
            return;
        }
        if (this.jzT == null || !this.jzT.isShowing()) {
            Log.i("MicroMsg.FaceFlashManagerPermission", "onResume goFaceFlash");
            dLg();
        }
        AppMethodBeat.o(186660);
    }

    private void dLg() {
        AppMethodBeat.i(186661);
        if (!p.ai(this)) {
            Log.i("MicroMsg.FaceFlashManagerPermission", "no camera  or audio permission. check permission");
            AppMethodBeat.o(186661);
            return;
        }
        Log.i("MicroMsg.FaceFlashManagerPermission", "check permission all success");
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_use_flash_action, false);
        Log.i("MicroMsg.FaceFlashManagerPermission", "use new face action  %s", Boolean.valueOf(a2));
        if (a2) {
            FaceFlashActionUI.d(this, getIntent().getExtras());
            AppMethodBeat.o(186661);
            return;
        }
        Intent intent = new Intent(this, FaceActionUI.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivityForResult(intent, 1);
        AppMethodBeat.o(186661);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(186662);
        Log.i("MicroMsg.FaceFlashManagerPermission", "onRequestPermissionsResult:%s", Integer.valueOf(i2));
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FaceFlashManagerPermission", "dont have any permission");
            setResult(1, bo(90010, "fail"));
            finish();
            AppMethodBeat.o(186662);
            return;
        }
        switch (i2) {
            case 16:
                if (iArr[0] == 0) {
                    this.wIB = true;
                    dLg();
                    AppMethodBeat.o(186662);
                    return;
                }
                this.wIB = false;
                this.jzT = h.a((Context) this, getString(R.string.c6b), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(186655);
                        Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting", Integer.valueOf(hashCode()));
                        dialogInterface.dismiss();
                        FaceFlashPermissionUI faceFlashPermissionUI = FaceFlashPermissionUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(faceFlashPermissionUI, bl.axQ(), "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        faceFlashPermissionUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(faceFlashPermissionUI, "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(186655);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(186656);
                        dialogInterface.dismiss();
                        Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", Integer.valueOf(hashCode()));
                        FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.bp(90008, "fail"));
                        FaceFlashPermissionUI.this.finish();
                        AppMethodBeat.o(186656);
                    }
                });
                AppMethodBeat.o(186662);
                return;
            case 18:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] != 0) {
                    this.wIB = false;
                    this.jzT = h.a((Context) this, getString(R.string.c6c), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(186657);
                            Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting ", Integer.valueOf(hashCode()));
                            dialogInterface.dismiss();
                            FaceFlashPermissionUI faceFlashPermissionUI = FaceFlashPermissionUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(faceFlashPermissionUI, bl.axQ(), "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            faceFlashPermissionUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(faceFlashPermissionUI, "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(186657);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(186658);
                            dialogInterface.dismiss();
                            Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", Integer.valueOf(hashCode()));
                            FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.bp(90009, "fail"));
                            FaceFlashPermissionUI.this.finish();
                            AppMethodBeat.o(186658);
                        }
                    });
                    break;
                } else {
                    this.wIB = true;
                    dLg();
                    AppMethodBeat.o(186662);
                    return;
                }
        }
        AppMethodBeat.o(186662);
    }

    private static Intent bo(int i2, String str) {
        AppMethodBeat.i(186663);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("err_type", 4);
        bundle.putInt("err_code", i2);
        bundle.putString("err_msg", str);
        Log.i("MicroMsg.FaceFlashManagerPermission", "face result errorType:%s errorCode:%s errorMsg:%s", 4, Integer.valueOf(i2), str);
        intent.putExtras(bundle);
        AppMethodBeat.o(186663);
        return intent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(186664);
        super.onActivityResult(i2, i3, intent);
        setResult(i3, intent);
        finish();
        AppMethodBeat.o(186664);
    }
}
