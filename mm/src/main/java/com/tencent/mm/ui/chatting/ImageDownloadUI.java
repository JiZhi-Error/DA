package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.av.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.m;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.vfs.s;

public class ImageDownloadUI extends MMActivity implements i, j {
    private ProgressBar Bwt;
    private TextView Bwu;
    private TextView Bwv;
    private TextView Bww;
    private g Bwy;
    private m Bwz;
    private ImageView PjS;
    private long dTS = 0;
    private int iXp;
    private long msgId = 0;
    private TextView qLz;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34826);
        super.onCreate(bundle);
        this.msgId = getIntent().getLongExtra("img_msg_id", 0);
        this.dTS = getIntent().getLongExtra("img_server_id", 0);
        this.iXp = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        initView();
        if (this.msgId > 0) {
            this.Bwy = q.bcR().H(this.username, this.msgId);
        }
        if ((this.Bwy == null || this.Bwy.localId <= 0) && this.dTS > 0) {
            this.Bwy = q.bcR().G(this.username, this.dTS);
        }
        if (this.Bwy == null || this.Bwy.localId <= 0) {
            Log.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dTS);
            AppMethodBeat.o(34826);
            return;
        }
        if (this.msgId <= 0 && this.dTS > 0) {
            bg.aVF();
            this.msgId = c.aSQ().aJ(this.username, this.dTS).field_msgId;
        }
        this.Bwz = new m(this.Bwy.localId, this.msgId, this.iXp, this);
        bg.azz().a(this.Bwz, 0);
        AppMethodBeat.o(34826);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c59;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(34827);
        super.onPause();
        bg.azz().b(109, this);
        AppMethodBeat.o(34827);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(34828);
        super.onResume();
        bg.azz().a(109, this);
        AppMethodBeat.o(34828);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(34829);
        this.Bwu = (TextView) findViewById(R.id.dvg);
        this.Bwv = (TextView) findViewById(R.id.j4i);
        this.qLz = (TextView) findViewById(R.id.j4j);
        this.Bww = (TextView) findViewById(R.id.j4g);
        this.PjS = (ImageView) findViewById(R.id.btd);
        this.PjS.setImageResource(R.raw.download_image_icon);
        this.Bwu.setVisibility(0);
        this.Bwv.setVisibility(8);
        this.qLz.setVisibility(8);
        this.Bww.setVisibility(8);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.ImageDownloadUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34825);
                bg.azz().a(ImageDownloadUI.this.Bwz);
                ImageDownloadUI.this.finish();
                AppMethodBeat.o(34825);
                return true;
            }
        });
        this.Bwt = (ProgressBar) findViewById(R.id.j4h);
        AppMethodBeat.o(34829);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, com.tencent.mm.ak.q qVar) {
        int i4;
        AppMethodBeat.i(34830);
        Log.d("ImageDownloadUI", "offset " + i2 + "totaolLen  " + i3);
        if (qVar.getType() == 109) {
            if (i3 != 0) {
                i4 = ((i2 * 100) / i3) - 1;
            } else {
                i4 = 0;
            }
            Vj(Math.max(0, i4));
        }
        AppMethodBeat.o(34830);
    }

    private void Vj(int i2) {
        AppMethodBeat.i(34831);
        this.Bwt.setProgress(i2);
        this.Bwu.setText(getString(R.string.df9, new Object[]{Integer.valueOf(i2)}));
        if (i2 < this.Bwt.getMax()) {
            AppMethodBeat.o(34831);
            return;
        }
        g c2 = q.bcR().c(Long.valueOf(this.Bwz.iYP));
        String str = c2.iXm;
        if (this.iXp == 1) {
            str = h.c(c2);
        }
        bmA(q.bcR().o(str, null, null));
        AppMethodBeat.o(34831);
    }

    private void bmA(String str) {
        AppMethodBeat.i(34832);
        if (str == null || str.equals("") || !s.YS(str)) {
            Log.d("ImageDownloadUI", "showImg : imgPath is null");
            AppMethodBeat.o(34832);
            return;
        }
        Log.i("ImageDownloadUI", "[ImageGalleryUI] showImg");
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("key_message_id", this.msgId);
        intent.putExtra("key_image_path", str);
        intent.putExtra("key_compress_type", this.iXp);
        intent.putExtra("key_favorite", true);
        intent.putExtra("img_gallery_msg_id", this.msgId);
        intent.putExtra("img_gallery_talker", this.username);
        finish();
        AppMethodBeat.o(34832);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(34833);
        if (qVar.getType() != 109) {
            AppMethodBeat.o(34833);
        } else if (i2 == 0 && i3 == 0) {
            Vj(this.Bwt.getMax());
            AppMethodBeat.o(34833);
        } else {
            Log.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i2 + ", errCode = " + i3);
            Toast.makeText(this, (int) R.string.e34, 1).show();
            AppMethodBeat.o(34833);
        }
    }
}
