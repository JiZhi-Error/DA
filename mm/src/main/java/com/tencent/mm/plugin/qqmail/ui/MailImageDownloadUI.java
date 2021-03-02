package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;

public class MailImageDownloadUI extends MMActivity implements i, j {
    private ImageView BwA;
    private LinearLayout BwB;
    private ProgressBar Bwt;
    private TextView Bwu;
    private TextView Bwv;
    private TextView Bww;
    private RelativeLayout Bwx;
    private g Bwy;
    private m Bwz;
    private long dTS = 0;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private int iXp;
    private long msgId = 0;
    private TextView qLz;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MailImageDownloadUI() {
        AppMethodBeat.i(123110);
        AppMethodBeat.o(123110);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123111);
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
            Log.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dTS);
            AppMethodBeat.o(123111);
            return;
        }
        if (this.msgId <= 0 && this.dTS > 0) {
            this.msgId = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(this.username, this.dTS).field_msgId;
        }
        String str = this.Bwy.iXm;
        String o = q.bcR().o(str, null, null);
        if (Util.isNullOrNil(str) || !s.YS(o)) {
            this.Bwz = new m(this.Bwy.localId, this.msgId, this.iXp, this);
            com.tencent.mm.kernel.g.aAg().hqi.a(this.Bwz, 0);
            AppMethodBeat.o(123111);
            return;
        }
        Log.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", str, Boolean.valueOf(this.Bwy.bcv()), o);
        if (o == null || o.equals("") || !s.YS(o)) {
            Log.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            AppMethodBeat.o(123111);
            return;
        }
        this.BwB.setVisibility(8);
        this.Bwt.setVisibility(8);
        this.BwA.setVisibility(0);
        this.BwA.setImageBitmap(BitmapUtil.getBitmapNative(o));
        this.Bwx.invalidate();
        AppMethodBeat.o(123111);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b4y;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(123112);
        super.onPause();
        com.tencent.mm.kernel.g.aAg().hqi.b(109, this);
        AppMethodBeat.o(123112);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(123113);
        super.onResume();
        com.tencent.mm.kernel.g.aAg().hqi.a(109, this);
        AppMethodBeat.o(123113);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(123114);
        this.Bwu = (TextView) findViewById(R.id.dvg);
        this.Bwv = (TextView) findViewById(R.id.dvg);
        this.qLz = (TextView) findViewById(R.id.dvh);
        this.Bww = (TextView) findViewById(R.id.dve);
        this.BwA = (ImageView) findViewById(R.id.f61);
        this.Bwu.setVisibility(0);
        this.BwB = (LinearLayout) findViewById(R.id.dv2);
        this.Bwx = (RelativeLayout) findViewById(R.id.f62);
        this.Bwv.setVisibility(8);
        this.qLz.setVisibility(8);
        this.Bww.setVisibility(8);
        setTitleVisibility(8);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(123109);
                com.tencent.mm.kernel.g.aAg().hqi.a(MailImageDownloadUI.this.Bwz);
                MailImageDownloadUI.this.finish();
                AppMethodBeat.o(123109);
                return true;
            }
        });
        this.Bwt = (ProgressBar) findViewById(R.id.dvf);
        AppMethodBeat.o(123114);
    }

    private void Vj(int i2) {
        AppMethodBeat.i(123115);
        this.Bwu.setText(getString(R.string.df9, new Object[]{Integer.valueOf(i2)}));
        if (i2 < this.Bwt.getMax()) {
            AppMethodBeat.o(123115);
            return;
        }
        g c2 = q.bcR().c(Long.valueOf(this.Bwz.iYP));
        if (this.iXp == 1) {
            h.c(c2);
        }
        finish();
        a bl = new a().bl(getIntent());
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(123115);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(123116);
        Log.d("MicroMsg.MailImageDownloadUI", "offset " + i2 + "totaolLen  " + i3);
        if (qVar.getType() == 109) {
            Vj(Math.max(0, i3 != 0 ? ((i2 * 100) / i3) - 1 : 0));
        }
        AppMethodBeat.o(123116);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(123117);
        if (qVar.getType() != 109) {
            AppMethodBeat.o(123117);
        } else if (i2 == 0 && i3 == 0) {
            Vj(this.Bwt.getMax());
            AppMethodBeat.o(123117);
        } else {
            Log.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i2 + ", errCode = " + i3);
            Toast.makeText(this, (int) R.string.e34, 1).show();
            AppMethodBeat.o(123117);
        }
    }
}
