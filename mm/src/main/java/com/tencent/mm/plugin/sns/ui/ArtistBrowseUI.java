package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.v;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.List;

public class ArtistBrowseUI extends SnsBaseGalleryUI implements w.a {
    private String EnT = "";
    private String yFy = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(97718);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(97718);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(97719);
        aj.faL().aI(this);
        super.onDestroy();
        AppMethodBeat.o(97719);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(97720);
        super.onResume();
        if (this.EAi != null) {
            this.EAi.vu(false);
        }
        AppMethodBeat.o(97720);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public int getLayoutId() {
        return R.layout.bvx;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(97721);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.EAf.EqW);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(97721);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(97721);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(97722);
        setActionbarColor(getResources().getColor(R.color.fm));
        setNavigationbarColor(getResources().getColor(R.color.fm));
        this.yFy = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        v.bev();
        this.EnT = r.bes();
        X(false, 2);
        this.EAi = new SnsInfoFlip(this);
        List<b> kg = an.kg(this.yFy, this.EnT);
        this.EAi.setShowTitle(true);
        this.EAi.a(kg, "", intExtra, this.EAd, this);
        this.EAi.setOnPageSelectListener(this);
        addView(this.EAi);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistBrowseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(97716);
                ArtistBrowseUI.this.EAf.ffJ();
                AppMethodBeat.o(97716);
                return true;
            }
        });
        setMMTitle(R.string.hbq);
        showOptionMenu(false);
        this.EAd.setCallBack(new v.a() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistBrowseUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.sns.ui.v.a
            public final void ffk() {
                AppMethodBeat.i(97717);
                cnb cntMedia = ArtistBrowseUI.this.EAi.getCntMedia();
                if (cntMedia == null) {
                    AppMethodBeat.o(97717);
                    return;
                }
                Log.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + cntMedia.Id);
                k tO = k.tO(723);
                tO.PH(cntMedia.Url);
                tO.bfK();
                if (!s.YS(ar.ki(aj.getAccSnsPath(), cntMedia.Id) + com.tencent.mm.plugin.sns.data.r.l(cntMedia))) {
                    AppMethodBeat.o(97717);
                    return;
                }
                be faK = aj.faK();
                if (faK.fau() != null && !faK.fau().equals("")) {
                    String str = ar.ki(aj.getAccSnsPath(), cntMedia.Id) + com.tencent.mm.plugin.sns.data.r.l(cntMedia);
                    String ki = ar.ki(aj.getAccSnsPath(), faK.fau());
                    if (s.YS(str)) {
                        Log.d("MicroMsg.UploadManager", "bg file is exist!'");
                        s.boN(ki);
                        s.deleteFile(ki + faK.fau() + "bg_");
                        s.deleteFile(ki + faK.fau() + "tbg_");
                        s.nw(str, ki + faK.fau() + "bg_");
                    } else {
                        s.deleteFile(ki + faK.fau() + "bg_");
                        s.deleteFile(ki + faK.fau() + "tbg_");
                        Log.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                    }
                    m faS = aj.faS();
                    String fau = faK.fau();
                    String str2 = cntMedia.Id;
                    l aQr = faS.aQr(fau);
                    aQr.field_bgId = str2;
                    faS.c(aQr);
                }
                faK.fbT();
                bf bfVar = new bf(7);
                cntMedia.MsE = 1;
                bfVar.DPd.ContentObj.LoV.add(cntMedia);
                bfVar.YH(2);
                bfVar.commit();
                Intent intent = new Intent();
                intent.setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
                intent.setFlags(536870912);
                intent.addFlags(67108864);
                ArtistBrowseUI artistBrowseUI = ArtistBrowseUI.this;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(artistBrowseUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                artistBrowseUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(artistBrowseUI, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ArtistBrowseUI.this.finish();
                AppMethodBeat.o(97717);
            }
        });
        AppMethodBeat.o(97722);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(97723);
        if (this.EAi != null) {
            this.EAi.onPause();
        }
        super.onPause();
        AppMethodBeat.o(97723);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fH(String str, int i2) {
        AppMethodBeat.i(97724);
        if (this.EAi != null) {
            this.EAi.vu(true);
        }
        AppMethodBeat.o(97724);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(97725);
        Log.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(97725);
            return;
        }
        this.EAf.Zu(intent.getIntExtra("sns_gallery_op_id", 0));
        AppMethodBeat.o(97725);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fI(String str, int i2) {
    }
}
