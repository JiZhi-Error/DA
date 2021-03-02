package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import java.util.ArrayList;

@a(7)
public class ShareImageRedirectUI extends MMBaseActivity {
    private String imagePath;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39127);
        super.onCreate(bundle);
        boolean a2 = b.a(this, "android.permission.CAMERA", 16, "", "");
        Log.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
        if (!a2) {
            AppMethodBeat.o(39127);
            return;
        }
        dRW();
        AppMethodBeat.o(39127);
    }

    private void dRW() {
        AppMethodBeat.i(39128);
        s.d(this, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 0);
        getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.ShareImageRedirectUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39124);
                Toast.makeText(ShareImageRedirectUI.this, (int) R.string.h0y, 1).show();
                ShareImageRedirectUI.this.finish();
                AppMethodBeat.o(39124);
                return false;
            }
        });
        AppMethodBeat.o(39128);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(39129);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(39129);
            return;
        }
        Log.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.tools.ShareImageRedirectUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(39125);
                            ShareImageRedirectUI shareImageRedirectUI = ShareImageRedirectUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(shareImageRedirectUI, bl.axQ(), "com/tencent/mm/ui/tools/ShareImageRedirectUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            shareImageRedirectUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(shareImageRedirectUI, "com/tencent/mm/ui/tools/ShareImageRedirectUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ShareImageRedirectUI.this.finish();
                            AppMethodBeat.o(39125);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.tools.ShareImageRedirectUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(39126);
                            ShareImageRedirectUI.this.finish();
                            AppMethodBeat.o(39126);
                        }
                    });
                    break;
                } else {
                    dRW();
                    AppMethodBeat.o(39129);
                    return;
                }
        }
        AppMethodBeat.o(39129);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(39130);
        getWindow().getDecorView().setOnTouchListener(null);
        if (i3 != -1) {
            finish();
            AppMethodBeat.o(39130);
            return;
        }
        switch (i2) {
            case 0:
                Context applicationContext = getApplicationContext();
                bg.aVF();
                this.imagePath = s.h(applicationContext, intent, c.aSY());
                if (this.imagePath == null) {
                    AppMethodBeat.o(39130);
                    return;
                }
                Intent intent2 = new Intent(this, ShareImageSelectorUI.class);
                intent2.putExtra("intent_extra_image_path", this.imagePath);
                startActivityForResult(intent2, 2);
                AppMethodBeat.o(39130);
                return;
            case 1:
            default:
                AppMethodBeat.o(39130);
                return;
            case 2:
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("Select_Contact");
                }
                if (arrayList != null && arrayList.size() == 1) {
                    Intent intent3 = new Intent(this, ChattingUI.class);
                    intent3.putExtra("Chat_User", arrayList.get(0));
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/tools/ShareImageRedirectUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareImageRedirectUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                    AppMethodBeat.o(39130);
                    return;
                } else if (arrayList == null || arrayList.size() <= 1) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("Ksnsupload_type", 0);
                    intent4.putExtra("sns_kemdia_path", this.imagePath);
                    com.tencent.mm.br.c.b(this, "sns", ".ui.SnsUploadUI", intent4);
                    finish();
                    AppMethodBeat.o(39130);
                    return;
                } else {
                    finish();
                    AppMethodBeat.o(39130);
                    return;
                }
        }
    }
}
