package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo;
import com.tencent.mm.plugin.aa.model.e;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.tavkit.component.TAVExporter;

public class LaunchAABeforeUI extends AppCompatActivity {
    private String appId;
    private String jWm;
    private i jWn = new i() {
        /* class com.tencent.mm.plugin.aa.ui.LaunchAABeforeUI.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            dia dia;
            AppMethodBeat.i(63573);
            Log.i("MicroMsg.Aa.LaunchAABeforeUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
            if (qVar instanceof NetSceneNewAAQueryPFInfo) {
                if (LaunchAABeforeUI.this.tipDialog != null) {
                    LaunchAABeforeUI.this.tipDialog.dismiss();
                }
                if (i2 == 0 && i3 == 0) {
                    NetSceneNewAAQueryPFInfo netSceneNewAAQueryPFInfo = (NetSceneNewAAQueryPFInfo) qVar;
                    if (netSceneNewAAQueryPFInfo.jTr == null) {
                        dia = null;
                    } else {
                        dia = netSceneNewAAQueryPFInfo.jTr;
                    }
                    Log.i("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo retcode:%s retmsg:%s", Integer.valueOf(dia.dDN), dia.qwn);
                    if (dia.dDN == 0) {
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", 6);
                        intent.putExtra("pfInfo", NetSceneNewAAQueryPFInfo.a(dia));
                        intent.putExtra("pfOrderNo", LaunchAABeforeUI.this.jWm);
                        e.a(dia.MMI);
                        if (BuildInfo.DEBUG) {
                            Log.d("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo PfInfoParcel:%s", NetSceneNewAAQueryPFInfo.a(dia));
                        }
                        c.b(LaunchAABeforeUI.this, "aa", ".ui.LaunchAAUI", intent);
                        LaunchAABeforeUI.a(LaunchAABeforeUI.this, false);
                        LaunchAABeforeUI.this.finish();
                        AppMethodBeat.o(63573);
                        return;
                    }
                    h.a(LaunchAABeforeUI.this, Util.isNullOrNil(dia.qwn) ? LaunchAABeforeUI.this.getString(R.string.ed2) : dia.qwn, "", LaunchAABeforeUI.this.getString(R.string.ed6), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAABeforeUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(63572);
                            LaunchAABeforeUI.a(LaunchAABeforeUI.this, true);
                            LaunchAABeforeUI.this.finish();
                            AppMethodBeat.o(63572);
                        }
                    });
                    AppMethodBeat.o(63573);
                    return;
                }
                LaunchAABeforeUI.a(LaunchAABeforeUI.this, false);
                h.cD(LaunchAABeforeUI.this, str);
                LaunchAABeforeUI.this.finish();
            }
            AppMethodBeat.o(63573);
        }
    };
    private Dialog tipDialog;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LaunchAABeforeUI() {
        AppMethodBeat.i(63575);
        AppMethodBeat.o(63575);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(213014);
        Resources resources = MMApplicationContext.getResources();
        AppMethodBeat.o(213014);
        return resources;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63576);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        ao.q(this, getResources().getColor(R.color.ac_));
        g.aAi();
        g.aAg().hqi.a(1809, this.jWn);
        this.jWm = getIntent().getStringExtra("pfOrderNo");
        this.appId = getIntent().getStringExtra("appid");
        this.tipDialog = h.a((Context) this, 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAABeforeUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(63574);
                if (LaunchAABeforeUI.this.tipDialog != null && LaunchAABeforeUI.this.tipDialog.isShowing()) {
                    LaunchAABeforeUI.this.tipDialog.dismiss();
                }
                LaunchAABeforeUI.this.finish();
                AppMethodBeat.o(63574);
            }
        });
        NetSceneNewAAQueryPFInfo netSceneNewAAQueryPFInfo = new NetSceneNewAAQueryPFInfo(this.jWm, this.appId);
        g.aAi();
        g.aAg().hqi.a(netSceneNewAAQueryPFInfo, 0);
        setResult(0);
        AppMethodBeat.o(63576);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(63577);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(63577);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(63578);
        g.aAi();
        g.aAg().hqi.b(1809, this.jWn);
        super.onDestroy();
        AppMethodBeat.o(63578);
    }

    static /* synthetic */ void a(LaunchAABeforeUI launchAABeforeUI, boolean z) {
        AppMethodBeat.i(63579);
        Intent intent = new Intent();
        intent.putExtra("cancel", z);
        launchAABeforeUI.setResult(-1, intent);
        AppMethodBeat.o(63579);
    }
}
