package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements w.a {
    private int EAu = 0;
    private ArrayList<String> EPf = new ArrayList<>();
    private HashMap<Integer, Boolean> EPg = new HashMap<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsUploadBrowseUI() {
        AppMethodBeat.i(99509);
        AppMethodBeat.o(99509);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99510);
        ao.bm(this);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(99510);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99511);
        aj.faL().aI(this);
        super.onDestroy();
        AppMethodBeat.o(99511);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(99512);
        super.onResume();
        if (this.EAi != null) {
            this.EAi.vu(false);
        }
        AppMethodBeat.o(99512);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(99513);
        if (this.EAi != null) {
            this.EAi.onPause();
        }
        super.onPause();
        AppMethodBeat.o(99513);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public int getLayoutId() {
        return R.layout.bvc;
    }

    public final void fjC() {
        String str;
        AppMethodBeat.i(99514);
        Intent intent = new Intent();
        List<b> flipList = this.EAi.getFlipList();
        if (flipList == null) {
            AppMethodBeat.o(99514);
            return;
        }
        this.EPf.clear();
        for (b bVar : flipList) {
            String str2 = aj.getAccSnsTmpPath() + bVar.ebR.Id;
            if (bVar.ebR.Id.startsWith("pre_temp_extend_pic")) {
                str = bVar.ebR.Id.substring(19);
            } else {
                str = str2;
            }
            this.EPf.add(str);
        }
        intent.putExtra("sns_gallery_temp_paths", this.EPf);
        intent.putExtra("sns_update_preview_image_count", this.EPg.size());
        this.EPg.clear();
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(99514);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(99515);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
            fjC();
            AppMethodBeat.o(99515);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(99515);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(99516);
        boolean booleanExtra = getIntent().getBooleanExtra("k_need_delete", true);
        String nullAs = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.EPf = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.EPf == null) {
            AppMethodBeat.o(99516);
            return;
        }
        this.EAu = getIntent().getIntExtra("sns_gallery_position", 0);
        this.EAi = new SnsInfoFlip(this);
        this.EAi.setEnableHorLongBmpMode(false);
        this.EAi.setShowTitle(true);
        aj.getAccSnsTmpPath();
        this.EAi.a(an.gQ(this.EPf), nullAs, this.EAu, this.EAd, this);
        this.EAi.setOnPageSelectListener(this);
        addView(this.EAi);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99506);
                SnsUploadBrowseUI.this.fjC();
                AppMethodBeat.o(99506);
                return true;
            }
        });
        if (booleanExtra) {
            addIconOptionMenu(0, R.string.tf, R.raw.icons_outlined_delete, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(99508);
                    h.a(SnsUploadBrowseUI.this, (int) R.string.h6m, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(99507);
                            if (SnsUploadBrowseUI.this.EAi.fih() == 0) {
                                SnsUploadBrowseUI.this.fjC();
                            }
                            AppMethodBeat.o(99507);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI.AnonymousClass2.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(99508);
                    return true;
                }
            });
        }
        AppMethodBeat.o(99516);
    }

    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.plugin.sns.ui.SnsInfoFlip.b
    public final void a(cnb cnb, int i2, String str) {
        AppMethodBeat.i(99517);
        super.a(cnb, i2, str);
        this.EPg.put(Integer.valueOf(i2), Boolean.TRUE);
        AppMethodBeat.o(99517);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fH(String str, int i2) {
        AppMethodBeat.i(99518);
        if (this.EAi != null) {
            this.EAi.vu(true);
        }
        AppMethodBeat.o(99518);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(99519);
        Log.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(99519);
        } else {
            AppMethodBeat.o(99519);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fI(String str, int i2) {
    }
}
