package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.n;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.s;

public final class b implements CaptureDataManager.b {
    String BMG;

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(final Context context, final CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        AppMethodBeat.i(75020);
        l lVar = new l(context);
        lVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.recordvideo.a.b.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(75018);
                mVar.d(0, context.getResources().getString(R.string.g5j));
                mVar.d(1, context.getResources().getString(R.string.fn9));
                mVar.d(2, context.getResources().getString(R.string.gaq));
                AppMethodBeat.o(75018);
            }
        };
        lVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.recordvideo.a.b.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(75019);
                if (i2 == 0) {
                    b bVar = b.this;
                    Context context = context;
                    String str = captureVideoNormalModel.thumbPath;
                    bVar.BMG = str;
                    Intent intent = new Intent();
                    intent.putExtra("scene", 8);
                    intent.putExtra("select_is_ret", true);
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("image_path", str);
                    intent.putExtra("Retr_Msg_Type", 0);
                    c.c(context, ".ui.transmit.SelectConversationUI", intent, 1);
                    AppMethodBeat.o(75019);
                } else if (i2 == 1) {
                    String str2 = captureVideoNormalModel.thumbPath;
                    cz czVar = new cz();
                    ((ad) g.af(ad.class)).a(czVar, 2, str2);
                    czVar.dFZ.dGf = 44;
                    EventCenter.instance.publish(czVar);
                    Log.i("MicroMsg.MMRecordUI", "[doFavInMM] path:%s", str2);
                    Toast.makeText(MMApplicationContext.getContext(), context.getResources().getString(R.string.c8j), 1).show();
                    ((Activity) context).finish();
                    AppMethodBeat.o(75019);
                } else {
                    if (i2 == 2) {
                        p.a(context, new Runnable() {
                            /* class com.tencent.mm.plugin.recordvideo.a.b.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(237200);
                                Boolean valueOf = Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true));
                                Log.i("MicroMsg.MMRecordUI", "save pic ,imageState : %s", valueOf);
                                Boolean bool = (Boolean) captureVideoNormalModel.eJJ().y("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.TRUE);
                                if (!valueOf.booleanValue() || !bool.booleanValue()) {
                                    h.RTc.aX(new Runnable() {
                                        /* class com.tencent.mm.plugin.recordvideo.a.b.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(237199);
                                            String exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
                                            s.nw(captureVideoNormalModel.thumbPath, exportImagePath);
                                            s.deleteFile(captureVideoNormalModel.thumbPath);
                                            AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
                                            AppMethodBeat.o(237199);
                                        }
                                    });
                                }
                                Toast.makeText(MMApplicationContext.getContext(), context.getResources().getString(R.string.c30, AndroidMediaUtil.getSysCameraDirPath()), 1).show();
                                ((Activity) context).finish();
                                AppMethodBeat.o(237200);
                            }
                        }, new Runnable() {
                            /* class com.tencent.mm.plugin.recordvideo.a.b.AnonymousClass2.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(237201);
                                Toast.makeText(MMApplicationContext.getContext(), context.getResources().getString(R.string.gao), 1).show();
                                AppMethodBeat.o(237201);
                            }
                        });
                    }
                    AppMethodBeat.o(75019);
                }
            }
        };
        com.tencent.mm.ui.base.h.a(context, lVar.gXI());
        AppMethodBeat.o(75020);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
    }

    public final void an(Context context, Intent intent) {
        AppMethodBeat.i(75021);
        String stringExtra = intent.getStringExtra("Select_Conv_User");
        Log.d("MicroMsg.MMRecordUI", "select %s for sending imagePath:%s", stringExtra, this.BMG);
        q a2 = com.tencent.mm.ui.base.h.a(context, context.getResources().getString(R.string.fm0), false, (DialogInterface.OnCancelListener) null);
        String stringExtra2 = intent.getStringExtra("custom_send_text");
        o.e tc = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(4);
        tc.dRL = z.aTY();
        tc.toUser = stringExtra;
        tc.iZt = this.BMG;
        tc.iXp = 0;
        tc.jdS = null;
        tc.dQd = 0;
        tc.iXy = "";
        tc.thumbPath = "";
        tc.jdV = true;
        tc.jdU = R.drawable.c3h;
        tc.jdR = 11;
        o.b bdQ = tc.bdQ();
        n nVar = (n) bdQ.jdJ;
        bdQ.execute();
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clear_c2c_tmp_file, true)) {
            com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            com.tencent.mm.plugin.recordvideo.e.c.jD(String.valueOf(nVar.bcD().field_msgId), this.BMG);
        }
        com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, stringExtra);
        if (a2 != null) {
            a2.dismiss();
        }
        ((Activity) context).finish();
        AppMethodBeat.o(75021);
    }
}
