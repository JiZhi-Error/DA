package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePublishGalleryUI extends MMActivity {
    private ViewPager riH;
    private int xAD;
    private TextViewWithBottomLine xBk;
    private TextViewWithBottomLine xBl;
    private TextView xBm;
    private GameLocalGalleryView xBn;
    private k xBo;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41038);
        super.onCreate(bundle);
        if (b.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 145, getString(R.string.flp), getString(R.string.dp8))) {
            init();
        }
        AppMethodBeat.o(41038);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(41039);
        super.onResume();
        f.e(true, true, true);
        AppMethodBeat.o(41039);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(41040);
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(41040);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init() {
        /*
        // Method dump skipped, instructions count: 379
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.media.GamePublishGalleryUI.init():void");
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aqr;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean noActionBar() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(41041);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        AppMethodBeat.o(41041);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        boolean z2;
        ArrayList<String> stringArrayListExtra;
        Intent intent2;
        AppMethodBeat.i(41042);
        if (this.xBn != null) {
            GameLocalGalleryView gameLocalGalleryView = this.xBn;
            if (i2 == GameLocalGalleryView.xAV) {
                if (i3 == -1) {
                    GameLocalGalleryView.dUn();
                    ((Activity) gameLocalGalleryView.getContext()).setResult(-1, intent);
                    ((Activity) gameLocalGalleryView.getContext()).finish();
                }
                z2 = true;
            } else if (i2 == GameLocalGalleryView.xAW) {
                switch (i3) {
                    case -2:
                        Log.e("MicroMsg.GameLocalMediaView", "WTF!!!");
                        ((Activity) gameLocalGalleryView.getContext()).finish();
                        break;
                    case -1:
                        GameLocalGalleryView.dUn();
                        if (intent == null) {
                            Intent intent3 = new Intent();
                            intent3.putStringArrayListExtra("CropImage_OutputPath_List", gameLocalGalleryView.xAY.dRL());
                            intent2 = intent3;
                        } else {
                            intent2 = intent;
                        }
                        Log.i("MicroMsg.GameLocalMediaView", "onActivity Result ok");
                        ((Activity) gameLocalGalleryView.getContext()).setResult(-1, intent2);
                        ((Activity) gameLocalGalleryView.getContext()).finish();
                        break;
                    case 0:
                        if (!(intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list")) == null || gameLocalGalleryView.xAY == null)) {
                            gameLocalGalleryView.xAY.aq(stringArrayListExtra);
                            break;
                        }
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                AppMethodBeat.o(41042);
                return;
            }
        }
        if (this.xBo != null) {
            k kVar = this.xBo;
            if (i2 == (kVar.hashCode() & 65535)) {
                if (i3 == -1) {
                    k.dUn();
                    if (kVar.xBv != null) {
                        if (intent.hasExtra("key_game_video_appid")) {
                            intent.putExtra("key_game_video_appid", kVar.xBv.appId);
                        }
                        if (intent.hasExtra("key_game_video_appname")) {
                            intent.putExtra("key_game_video_appid", kVar.xBv.appName);
                        }
                        intent.putExtra("key_game_trans_info", kVar.xBv.xuP);
                    }
                    ((Activity) kVar.getContext()).setResult(-1, intent);
                    ((Activity) kVar.getContext()).finish();
                }
                kVar.xBv = null;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(41042);
                return;
            }
        }
        AppMethodBeat.o(41042);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(204119);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(204119);
            return;
        }
        Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 145:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dry), getString(R.string.flp), getString(R.string.e_k), getString(R.string.dlk), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.media.GamePublishGalleryUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(204116);
                            GamePublishGalleryUI gamePublishGalleryUI = GamePublishGalleryUI.this;
                            a bl = new a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(gamePublishGalleryUI, bl.axQ(), "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            gamePublishGalleryUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(gamePublishGalleryUI, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            GamePublishGalleryUI.this.finish();
                            AppMethodBeat.o(204116);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.media.GamePublishGalleryUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(204117);
                            GamePublishGalleryUI.this.finish();
                            AppMethodBeat.o(204117);
                        }
                    });
                    break;
                } else {
                    init();
                    AppMethodBeat.o(204119);
                    return;
                }
        }
        AppMethodBeat.o(204119);
    }

    public final void setCurrentItem(int i2, boolean z) {
        AppMethodBeat.i(41043);
        if (i2 % 2 != 0 || this.xBo == null) {
            this.xBn.dUl();
        } else {
            this.xBo.dUl();
        }
        this.riH.setCurrentItem(i2);
        if (z) {
            com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), i2 % 2 == 0 ? 8762 : 8767, 0, 2, this.xAD, com.tencent.mm.game.report.b.a.c(7, new HashMap()));
        }
        AppMethodBeat.o(41043);
    }

    public final void dUs() {
        AppMethodBeat.i(41044);
        if (a.dUd() == 0 && this.riH.getCurrentItem() % 2 == 0) {
            setCurrentItem(1, false);
        }
        AppMethodBeat.o(41044);
    }
}
