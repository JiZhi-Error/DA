package com.tencent.mm.plugin.webview.stub;

import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.np;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebviewScanImageActivity extends HellActivity {
    private String Eqn = null;
    private IListener Eqy = new IListener<np>() {
        /* class com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity.AnonymousClass1 */

        {
            AppMethodBeat.i(160440);
            this.__eventId = np.class.getName().hashCode();
            AppMethodBeat.o(160440);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(np npVar) {
            AppMethodBeat.i(79529);
            np npVar2 = npVar;
            if (npVar2 != null && (npVar2 instanceof np)) {
                Log.i("MicroMsg.WebviewScanImageActivity", "notify Event: %d", Integer.valueOf(npVar2.dTL.dTJ));
                Log.d("MicroMsg.WebviewScanImageActivity", "%s, %s", npVar2.dTL.activity, WebviewScanImageActivity.this);
                if (npVar2.dTL.activity == WebviewScanImageActivity.this && npVar2.dTL.dDX.equals(WebviewScanImageActivity.this.Eqn)) {
                    switch (npVar2.dTL.dTJ) {
                        case 0:
                        case 1:
                        case 2:
                            EventCenter.instance.removeListener(WebviewScanImageActivity.this.Eqy);
                            WebviewScanImageActivity.this.finish();
                            break;
                        case 3:
                            EventCenter.instance.removeListener(WebviewScanImageActivity.this.Eqy);
                            WebviewScanImageActivity.this.finish();
                            break;
                    }
                } else {
                    Log.e("MicroMsg.WebviewScanImageActivity", "not the same, eventStr: %s, origin: %s", npVar2.dTL.dDX, WebviewScanImageActivity.this.Eqn);
                }
            } else {
                Log.e("MicroMsg.WebviewScanImageActivity", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            AppMethodBeat.o(79529);
            return false;
        }
    };
    private String IRp;
    private boolean JdK = false;
    private int dFL;
    private int dFM;
    private String imageUrl;
    private String url;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebviewScanImageActivity() {
        AppMethodBeat.i(79530);
        AppMethodBeat.o(79530);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(79531);
        super.onCreate(bundle);
        Log.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        if (Util.isNullOrNil(getIntent().getStringExtra("img_gallery_session_id"))) {
            String stringExtra = getIntent().getStringExtra("key_string_for_url");
            if (!Util.isNullOrNil(stringExtra)) {
                String JX = ad.JX("WebviewQrCode");
                ad.b G = ad.aVe().G(JX, true);
                G.l("url", stringExtra);
                if (!((b) g.af(b.class)).isMpUrl(stringExtra)) {
                    i2 = 6;
                } else {
                    i2 = 1;
                }
                G.l("Contact_Sub_Scene", Integer.valueOf(i2));
                G.l("Contact_Scene_Note", stringExtra);
                getIntent().putExtra("img_gallery_session_id", JX);
            }
        }
        setContentView(R.layout.aym);
        AppMethodBeat.o(79531);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(79532);
        super.onStart();
        Log.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
        if (!this.JdK && getIntent() != null) {
            this.Eqn = getIntent().getStringExtra("key_string_for_scan");
            this.dFL = getIntent().getIntExtra("key_codetype_for_scan", 0);
            this.dFM = getIntent().getIntExtra("key_codeversion_for_scan", 0);
            this.url = getIntent().getStringExtra("key_string_for_url");
            this.imageUrl = getIntent().getStringExtra("key_string_for_image_url");
            this.IRp = getIntent().getStringExtra("key_string_for_wxapp_id");
            if (this.Eqn != null) {
                EventCenter.instance.addListener(this.Eqy);
                cr crVar = new cr();
                crVar.dFK.activity = this;
                crVar.dFK.dDX = this.Eqn;
                crVar.dFK.dFM = this.dFM;
                crVar.dFK.dFL = this.dFL;
                crVar.dFK.sourceType = 6;
                crVar.dFK.imagePath = this.imageUrl;
                crVar.dFK.scene = 40;
                Bundle bundle = new Bundle();
                bundle.putString("stat_app_id", this.IRp);
                bundle.putString("stat_url", this.url);
                bundle.putInt("stat_scene", 4);
                bundle.putString("stat_send_msg_user", getIntent().getStringExtra("key_string_for_from_username"));
                crVar.dFK.dFP = bundle;
                EventCenter.instance.publish(crVar);
            }
        }
        this.JdK = true;
        AppMethodBeat.o(79532);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(79533);
        super.onPause();
        Log.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
        aw awVar = new aw();
        awVar.dDW.activity = this;
        awVar.dDW.dDX = this.Eqn;
        EventCenter.instance.publish(awVar);
        EventCenter.instance.removeListener(this.Eqy);
        finish();
        AppMethodBeat.o(79533);
    }
}
