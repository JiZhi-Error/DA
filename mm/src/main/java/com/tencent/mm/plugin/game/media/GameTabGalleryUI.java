package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class GameTabGalleryUI extends MMActivity {
    private static final int xBB = ("GameTabGalleryUI".hashCode() & 65535);
    private m xBC;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(41075);
        AppMethodBeat.o(41075);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41070);
        super.onCreate(bundle);
        if (b.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 145, getString(R.string.flp), getString(R.string.dp8))) {
            init();
        }
        AppMethodBeat.o(41070);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init() {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.media.GameTabGalleryUI.init():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(41071);
        super.onResume();
        f.e(true, true, true);
        AppMethodBeat.o(41071);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(41072);
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(41072);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(41073);
        super.onDestroy();
        AppMethodBeat.o(41073);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(41074);
        super.onActivityResult(i2, i3, intent);
        if (i2 == xBB && i3 == -1) {
            setResult(i3, intent);
            finish();
        }
        AppMethodBeat.o(41074);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(204130);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.GameTabGalleryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(204130);
            return;
        }
        Log.i("MicroMsg.GameTabGalleryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 145:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dry), getString(R.string.flp), getString(R.string.e_k), getString(R.string.dlk), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.media.GameTabGalleryUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(204127);
                            GameTabGalleryUI gameTabGalleryUI = GameTabGalleryUI.this;
                            a bl = new a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(gameTabGalleryUI, bl.axQ(), "com/tencent/mm/plugin/game/media/GameTabGalleryUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            gameTabGalleryUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(gameTabGalleryUI, "com/tencent/mm/plugin/game/media/GameTabGalleryUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            GameTabGalleryUI.this.finish();
                            AppMethodBeat.o(204127);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.media.GameTabGalleryUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(204128);
                            GameTabGalleryUI.this.finish();
                            AppMethodBeat.o(204128);
                        }
                    });
                    break;
                } else {
                    init();
                    AppMethodBeat.o(204130);
                    return;
                }
        }
        AppMethodBeat.o(204130);
    }
}
