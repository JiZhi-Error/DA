package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.q.a;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public class AppBrandTaskProxyUI extends AppBrandProcessProxyUI {
    public String appId = "";
    private String fileName = "";
    private String filePath = "";
    private String gCr = "";
    public a lwE;
    private boolean lwF;
    public boolean lwG = true;
    public boolean lwH = false;
    public ValueCallback<Integer> lwI = null;
    public ValueCallback<String> lwJ = null;
    private ValueCallback<Integer> lwK = new ValueCallback<Integer>() {
        /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Integer num) {
            AppMethodBeat.i(45414);
            Log.i("MicroMsg.AppBrandTaskProxyUI", "updateRetCallback onReceiveValue ret = %d", num);
            AppMethodBeat.o(45414);
        }
    };
    private MMToClientEvent.c lwL = new MMToClientEvent.c() {
        /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
        public final void cq(Object obj) {
            AppMethodBeat.i(45415);
            if (obj instanceof MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent) {
                MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent miniQbFloatBallMenuActionBrandEvent = (MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent) obj;
                if (miniQbFloatBallMenuActionBrandEvent == null || AppBrandTaskProxyUI.this.lwE == null) {
                    Log.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent fail");
                } else if (!Util.isEqual(miniQbFloatBallMenuActionBrandEvent.filePath, AppBrandTaskProxyUI.this.filePath)) {
                    Log.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.filePath:%s filePath:%s", miniQbFloatBallMenuActionBrandEvent.filePath, AppBrandTaskProxyUI.this.filePath);
                    AppMethodBeat.o(45415);
                    return;
                } else {
                    Log.i("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.action:%s", Integer.valueOf(miniQbFloatBallMenuActionBrandEvent.action));
                    switch (miniQbFloatBallMenuActionBrandEvent.action) {
                        case 1:
                        case 8:
                            AppBrandTaskProxyUI.this.lwE.ic(true);
                            AppMethodBeat.o(45415);
                            return;
                        case 2:
                            AppBrandTaskProxyUI.this.lwE.ic(false);
                            if (AppBrandTaskProxyUI.this.lwH) {
                                MiniReaderLogic.a(false, (Context) AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.filePath, AppBrandTaskProxyUI.this.fileName, AppBrandTaskProxyUI.this.gCr, AppBrandTaskProxyUI.this.token, (ValueCallback<String>) AppBrandTaskProxyUI.this.lwJ, (ValueCallback<Integer>) AppBrandTaskProxyUI.this.lwK, true, AppBrandTaskProxyUI.this.appId, false);
                                AppMethodBeat.o(45415);
                                return;
                            }
                            AppBrandTaskProxyUI.this.lwG = false;
                            com.tencent.mm.cr.a.Z(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.token, AppBrandTaskProxyUI.this.filePath);
                            MiniReaderLogic.a(false, false, (Context) AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.filePath, AppBrandTaskProxyUI.this.fileName, AppBrandTaskProxyUI.this.gCr, AppBrandTaskProxyUI.this.token, (ValueCallback<String>) AppBrandTaskProxyUI.this.lwJ, (ValueCallback<Integer>) AppBrandTaskProxyUI.this.lwI, AppBrandTaskProxyUI.this.appId, AppBrandTaskProxyUI.this.lwF);
                            AppMethodBeat.o(45415);
                            return;
                        case 3:
                        case 5:
                        case 6:
                        case 7:
                        default:
                            AppMethodBeat.o(45415);
                            return;
                        case 4:
                            p.c(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.filePath, new p.a() {
                                /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.platformtools.p.a
                                public final void bP(String str, String str2) {
                                    AppMethodBeat.i(226646);
                                    Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(R.string.hp6, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                                    AppMethodBeat.o(226646);
                                }

                                @Override // com.tencent.mm.platformtools.p.a
                                public final void bQ(String str, String str2) {
                                    AppMethodBeat.i(226647);
                                    Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(R.string.hp5), 1).show();
                                    AppMethodBeat.o(226647);
                                }
                            });
                            AppMethodBeat.o(45415);
                            return;
                    }
                }
            }
            AppMethodBeat.o(45415);
        }
    };
    private String token = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandTaskProxyUI() {
        AppMethodBeat.i(45416);
        AppMethodBeat.o(45416);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(45417);
        super.onResume();
        if (this.lwE != null) {
            this.lwE.bCA();
        }
        AppMethodBeat.o(45417);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(45418);
        super.onPause();
        if (this.lwE != null) {
            this.lwE.aGj();
        }
        AppMethodBeat.o(45418);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(45419);
        super.onDestroy();
        if (this.lwE != null) {
            com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
        }
        MMToClientEvent.b(this.appId, this.lwL);
        AppMethodBeat.o(45419);
    }

    public final void bDR() {
        AppMethodBeat.i(226648);
        Log.i("MicroMsg.AppBrandTaskProxyUI", "creatFilesFloatball() processName:%s", MMApplicationContext.getProcessName());
        this.lwE = new a(new b(getContext()));
        this.lwE.a(this.filePath, this.gCr, this.appId, MMApplicationContext.getProcessName(), this.lwF, this);
        a aVar = this.lwE;
        String str = this.gCr;
        String str2 = this.fileName;
        MultiTaskInfo multiTaskInfo = aVar.Abp;
        multiTaskInfo.erh().title = str2;
        multiTaskInfo.erh().gCr = str;
        aVar.eqX();
        MMToClientEvent.a(this.appId, this.lwL);
        AppMethodBeat.o(226648);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z) {
        this.filePath = str;
        this.gCr = str2;
        this.token = str3;
        this.fileName = str4;
        this.lwF = z;
    }
}
