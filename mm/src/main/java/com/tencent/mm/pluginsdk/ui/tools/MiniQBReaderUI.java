package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.xweb.f;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI extends MMSecDataActivity {
    private HandOffFile BIm;
    private AppBrandOpenMaterialCollection Jgy = null;
    private h Jgz = null;
    private boolean KvU;
    private boolean KvV = false;
    private String KvW = null;
    private g KvX = null;
    private boolean KvY = false;
    private com.tencent.mm.ui.chatting.g.a Vil;
    private com.tencent.mm.ui.chatting.multitask.b Vim;
    private com.tencent.mm.ui.chatting.multitask.a Vin;
    private String fileName = "";
    private String filePath = "";
    private String gCr = "";
    private MiniReaderLogic.a<Integer> lVE = null;
    private boolean lwG = true;
    private boolean lwH = false;
    private ValueCallback<String> lwJ = new ValueCallback<String>() {
        /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass6 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(31969);
            String str2 = str;
            Log.i("MicroMsg.MiniQBReaderUI", "openReadFile, receiveValue = %s %s", str2, MiniQBReaderUI.this.toString());
            if ("query for feature_wx_float_window successfully".equals(str2)) {
                MiniQBReaderUI.this.lwH = true;
                MiniReaderLogic.a(MiniQBReaderUI.this.Vim.eqW(), MiniQBReaderUI.this.Vim.eqZ(), true, MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, MiniQBReaderUI.this.fileName, MiniQBReaderUI.this.gCr, MiniQBReaderUI.this.token, MiniQBReaderUI.this.lwJ, MiniQBReaderUI.b(MiniQBReaderUI.this, true), MiniQBReaderUI.this.qoX, false);
                AppMethodBeat.o(31969);
            } else if ("xwebFileReaderReachEnd".equals(str2)) {
                Log.i("MicroMsg.MiniQBReaderUI", "xweb file reader reach end");
                if (MiniQBReaderUI.this.Vim != null) {
                    MiniQBReaderUI.this.Vim.gTD();
                    AppMethodBeat.o(31969);
                    return;
                }
                Log.e("MicroMsg.MiniQBReaderUI", "mFloatBallHelper null");
                AppMethodBeat.o(31969);
            } else if ("xwebFileReaderUserOperated".equals(str2)) {
                Log.i("MicroMsg.MiniQBReaderUI", "xweb file reader user operated");
                if (MiniQBReaderUI.this.Vim != null) {
                    MiniQBReaderUI.this.Vim.gTE();
                    AppMethodBeat.o(31969);
                    return;
                }
                Log.e("MicroMsg.MiniQBReaderUI", "mFloatBallHelper null");
                AppMethodBeat.o(31969);
            } else {
                if ("fileReaderClosed".equals(str2)) {
                    if (MiniQBReaderUI.this.Vim != null && !MiniQBReaderUI.this.Vim.wu(1)) {
                        if (MiniQBReaderUI.this.lwG) {
                            MiniQBReaderUI.this.finish();
                            AppMethodBeat.o(31969);
                            return;
                        }
                        Log.i("MicroMsg.MiniQBReaderUI", "opCallback isFinishCurPage:%s", Boolean.valueOf(MiniQBReaderUI.this.lwG));
                        MiniQBReaderUI.this.lwG = true;
                        AppMethodBeat.o(31969);
                        return;
                    }
                } else if ("fileReaderMenuClicked".equals(str2)) {
                    e eVar = new e((Context) MiniQBReaderUI.this, 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass6.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(31967);
                            mVar.d(0, MiniQBReaderUI.this.getString(R.string.g5c));
                            mVar.d(3, MiniQBReaderUI.this.getString(R.string.cei));
                            mVar.d(1, MiniQBReaderUI.this.getString(R.string.b3m));
                            mVar.d(4, MiniQBReaderUI.this.getString(R.string.c2x));
                            if (((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl() && MiniQBReaderUI.this.BIm != null && HandOffFile.isSupportOpenFile(MiniQBReaderUI.this.gCr)) {
                                mVar.d(5, MiniQBReaderUI.this.getString(R.string.cek));
                            }
                            AppMethodBeat.o(31967);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass6.AnonymousClass2 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(31968);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    com.tencent.xweb.util.h.bsL(MiniQBReaderUI.this.gCr);
                                    com.tencent.mm.cr.a.a(MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, MiniQBReaderUI.this.fileName, MiniQBReaderUI.this.gCr);
                                    AppMethodBeat.o(31968);
                                    return;
                                case 1:
                                    com.tencent.xweb.util.h.bsM(MiniQBReaderUI.this.gCr);
                                    a.b(MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, MiniQBReaderUI.this.gCr);
                                    AppMethodBeat.o(31968);
                                    return;
                                case 2:
                                    MiniQBReaderUI.this.Vim.ic(false);
                                    AppMethodBeat.o(31968);
                                    return;
                                case 3:
                                    MiniQBReaderUI.this.Vim.ic(true);
                                    AppMethodBeat.o(31968);
                                    return;
                                case 4:
                                    p.c(MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, new p.a() {
                                        /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass6.AnonymousClass2.AnonymousClass1 */

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bP(String str, String str2) {
                                            AppMethodBeat.i(232352);
                                            Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.string.hp6, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                                            AppMethodBeat.o(232352);
                                        }

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bQ(String str, String str2) {
                                            AppMethodBeat.i(232353);
                                            Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.string.hp5), 1).show();
                                            AppMethodBeat.o(232353);
                                        }
                                    });
                                    AppMethodBeat.o(31968);
                                    return;
                                case 5:
                                    if (MiniQBReaderUI.this.BIm != null) {
                                        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(MiniQBReaderUI.this.BIm);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(31968);
                        }
                    };
                    MiniQBReaderUI.a(MiniQBReaderUI.this, eVar);
                    eVar.dGm();
                }
                AppMethodBeat.o(31969);
            }
        }
    };
    private ValueCallback<Integer> lwK = new ValueCallback<Integer>() {
        /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass4 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Integer num) {
            AppMethodBeat.i(31965);
            Log.i("MicroMsg.MiniQBReaderUI", "updateRetCallback onReceiveValue ret = %d", num);
            AppMethodBeat.o(31965);
        }
    };
    private int qoX;
    private IListener<mn> qoZ = new IListener<mn>() {
        /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161484);
            this.__eventId = mn.class.getName().hashCode();
            AppMethodBeat.o(161484);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mn mnVar) {
            AppMethodBeat.i(31962);
            boolean a2 = a(mnVar);
            AppMethodBeat.o(31962);
            return a2;
        }

        private boolean a(mn mnVar) {
            AppMethodBeat.i(31961);
            if (mnVar != null && mnVar.dSa != null && MiniQBReaderUI.this.Vim != null) {
                if (Util.isEqual(mnVar.dSa.filePath, MiniQBReaderUI.this.filePath)) {
                    Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", Integer.valueOf(mnVar.dSa.action));
                    switch (mnVar.dSa.action) {
                        case 1:
                        case 8:
                            MiniQBReaderUI.this.Vim.ic(true);
                            break;
                        case 2:
                            MiniQBReaderUI.this.Vim.ic(false);
                            if (!MiniQBReaderUI.this.lwH) {
                                MiniQBReaderUI.this.lwG = false;
                                com.tencent.mm.cr.a.Z(MiniQBReaderUI.this, MiniQBReaderUI.this.token, MiniQBReaderUI.this.filePath);
                                MiniReaderLogic.a(false, false, MiniQBReaderUI.this.KvU, MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, MiniQBReaderUI.this.fileName, MiniQBReaderUI.this.gCr, MiniQBReaderUI.this.token, MiniQBReaderUI.this.lwJ, MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.this.qoX, MiniQBReaderUI.this.KvV);
                                break;
                            } else {
                                MiniReaderLogic.a(MiniQBReaderUI.this.KvU, (Context) MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, MiniQBReaderUI.this.fileName, MiniQBReaderUI.this.gCr, MiniQBReaderUI.this.token, (ValueCallback<String>) MiniQBReaderUI.this.lwJ, (ValueCallback<Integer>) MiniQBReaderUI.this.lwK, false, "", MiniQBReaderUI.this.KvV);
                                break;
                            }
                        case 4:
                            p.c(MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, new p.a() {
                                /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.platformtools.p.a
                                public final void bP(String str, String str2) {
                                    AppMethodBeat.i(232350);
                                    Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.string.hp6, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                                    AppMethodBeat.o(232350);
                                }

                                @Override // com.tencent.mm.platformtools.p.a
                                public final void bQ(String str, String str2) {
                                    AppMethodBeat.i(232351);
                                    Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.string.hp5), 1).show();
                                    AppMethodBeat.o(232351);
                                }
                            });
                            break;
                        case 5:
                            if (MiniQBReaderUI.this.BIm != null) {
                                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(MiniQBReaderUI.this.BIm);
                                break;
                            }
                            break;
                        case 6:
                            Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS readState:%d", Integer.valueOf(mnVar.dSa.dSc));
                            if (MiniQBReaderUI.this.Vim == null) {
                                Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS mFloatBallHelper==null");
                            }
                            if (mnVar.dSa.dSc != 0) {
                                if (mnVar.dSa.dSc == 1) {
                                    MiniQBReaderUI.this.Vim.gTD();
                                    break;
                                }
                            } else {
                                MiniQBReaderUI.this.Vim.gTE();
                                break;
                            }
                            break;
                        case 7:
                            MiniQBReaderUI.n(MiniQBReaderUI.this);
                            break;
                    }
                } else {
                    Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", Integer.valueOf(mnVar.dSa.action), mnVar.dSa.filePath, MiniQBReaderUI.this.filePath);
                    if (mnVar.dSa.action == 3) {
                        com.tencent.mm.cr.a.Z(MiniQBReaderUI.this, MiniQBReaderUI.this.token, MiniQBReaderUI.this.filePath);
                        if (MiniQBReaderUI.this.Vim != null) {
                            MiniQBReaderUI.this.Vim.aGj();
                        }
                        if (MiniQBReaderUI.this.Vil != null) {
                            MiniQBReaderUI.this.Vil.aGj();
                        }
                    }
                }
            } else {
                Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
            }
            AppMethodBeat.o(31961);
            return false;
        }
    };
    private String token = Integer.toString(hashCode());

    /* access modifiers changed from: package-private */
    public interface b {
        void a(MiniQBReaderUI miniQBReaderUI, i iVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MiniQBReaderUI() {
        AppMethodBeat.i(31970);
        AppMethodBeat.o(31970);
    }

    static /* synthetic */ void o(MiniQBReaderUI miniQBReaderUI) {
        AppMethodBeat.i(258867);
        miniQBReaderUI.init();
        AppMethodBeat.o(258867);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(31971);
        super.onCreate(bundle);
        this.filePath = getIntent().getStringExtra("file_path");
        gsB();
        Log.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", this.filePath, toString());
        mn mnVar = new mn();
        mnVar.dSa.action = 3;
        mnVar.dSa.filePath = getIntent().getStringExtra("file_path");
        EventCenter.instance.asyncPublish(mnVar, Looper.getMainLooper());
        com.tencent.f.h.RTc.o(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(31963);
                MiniQBReaderUI.o(MiniQBReaderUI.this);
                AppMethodBeat.o(31963);
            }
        }, 300);
        AppMethodBeat.o(31971);
    }

    private void init() {
        AppMethodBeat.i(31972);
        this.filePath = getIntent().getStringExtra("file_path");
        this.gCr = getIntent().getStringExtra("file_ext");
        this.fileName = getIntent().getStringExtra("file_name");
        this.qoX = getIntent().getIntExtra("sence", 0);
        Log.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", this.filePath, this.gCr, this.fileName, Integer.valueOf(this.qoX));
        if (Util.isNullOrNil(this.fileName)) {
            try {
                int lastIndexOf = this.filePath.lastIndexOf(47) + 1;
                if (lastIndexOf < 0 || lastIndexOf == this.filePath.length()) {
                    lastIndexOf = 0;
                }
                this.fileName = this.filePath.substring(lastIndexOf, this.filePath.length());
            } catch (Exception e2) {
                Log.e("MicroMsg.MiniQBReaderUI", "get file name error " + e2.getMessage());
                this.fileName = " ";
            }
        }
        this.Vil = new com.tencent.mm.ui.chatting.g.a(new com.tencent.mm.plugin.ball.a.e(getContext()));
        this.Vil.aC(this.filePath, this.gCr, this.qoX);
        com.tencent.mm.ui.chatting.g.a aVar = this.Vil;
        String str = this.gCr;
        String str2 = this.fileName;
        Integer agX = d.agX(str);
        if (agX == null) {
            agX = d.agX("unknown");
        }
        aVar.oWE.noe = agX.intValue();
        if (Util.isNullOrNil(aVar.oWE.name)) {
            aVar.oWE.name = str2;
        }
        aVar.cit();
        this.Vin = new com.tencent.mm.ui.chatting.multitask.a(getContext());
        this.Vim = new com.tencent.mm.ui.chatting.multitask.b(this.Vin);
        this.Vim.g(this.filePath, this.gCr, this.qoX, false);
        this.Vim.ni(this.gCr, this.fileName);
        if (this.qoZ != null) {
            this.qoZ.alive();
        }
        if (this.KvY) {
            this.Vim.bCA();
            this.Vil.bCA();
        }
        MultiTaskInfo multiTaskInfo = this.Vim.Abp;
        HandOff handOff = null;
        if (multiTaskInfo != null) {
            handOff = ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBx(multiTaskInfo.field_id);
        }
        if (handOff == null) {
            handOff = ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYm();
        }
        if (handOff instanceof HandOffFile) {
            this.BIm = (HandOffFile) handOff;
            this.BIm.setHandOffType(1);
            this.BIm.setKey(HandOff.generateKey(this.BIm.getDataType(), this.BIm.getHandOffType()));
            this.BIm.saveToMultiTaskInfo(this.Vim.Abp);
            Log.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + handOff.getKey());
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).c(handOff);
        }
        this.KvU = ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl() && this.BIm != null && HandOffFile.isSupportOpenFile(this.gCr);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(31964);
                MiniReaderLogic.a(MiniQBReaderUI.this.Vim.eqW(), MiniQBReaderUI.this.Vim.eqZ(), MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, MiniQBReaderUI.this.fileName, MiniQBReaderUI.this.gCr, MiniQBReaderUI.this.token, MiniQBReaderUI.this.lwJ, MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "", true, MiniQBReaderUI.this.KvV);
                AppMethodBeat.o(31964);
            }
        });
        f.a a2 = f.a(this.gCr, f.a.NONE, false, new Intent());
        if (a2 == f.a.X5) {
            if (this.Vim != null) {
                this.Vim.PDX = true;
            }
            if (this.Vin != null) {
                this.Vin.e(true, false, this.Vim.Abp.field_id);
                AppMethodBeat.o(31972);
                return;
            }
        } else if (a2 == f.a.XWEB && this.Vin != null) {
            this.Vin.e(false, true, this.Vim.Abp.field_id);
        }
        AppMethodBeat.o(31972);
    }

    private Pair<i, MaterialModel> gsA() {
        AppMethodBeat.i(232359);
        Log.d("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel");
        i iVar = (i) com.tencent.mm.kernel.g.af(i.class);
        if (iVar == null) {
            Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is null");
            AppMethodBeat.o(232359);
            return null;
        } else if (!iVar.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH)) {
            Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is not enabled");
            AppMethodBeat.o(232359);
            return null;
        } else if (Util.isNullOrNil(this.filePath)) {
            Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, filePath is empty");
            AppMethodBeat.o(232359);
            return null;
        } else {
            MaterialModel eC = MaterialModel.eC(this.filePath, this.gCr);
            if (eC == null) {
                Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, materialModel is null");
                AppMethodBeat.o(232359);
                return null;
            } else if (!iVar.adl(eC.mimeType)) {
                Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is not support " + eC.mimeType);
                AppMethodBeat.o(232359);
                return null;
            } else {
                Pair<i, MaterialModel> pair = new Pair<>(iVar, eC);
                AppMethodBeat.o(232359);
                return pair;
            }
        }
    }

    private void gsB() {
        AppMethodBeat.i(232360);
        Log.d("MicroMsg.MiniQBReaderUI", "updateIsFileCanOpenByAppBrand");
        a(new b() {
            /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass7 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.b
            public final void a(MiniQBReaderUI miniQBReaderUI, i iVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
                AppMethodBeat.i(232354);
                miniQBReaderUI.KvV = !appBrandOpenMaterialCollection.nlF.isEmpty();
                AppMethodBeat.o(232354);
            }
        });
        AppMethodBeat.o(232360);
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.plugin.appbrand.openmaterial.i {
        private final WeakReference<MiniQBReaderUI> Kwe;
        private final i Kwf;
        private final b Kwg;
        private final MaterialModel nlD;

        public a(MiniQBReaderUI miniQBReaderUI, MaterialModel materialModel, i iVar, b bVar) {
            AppMethodBeat.i(232357);
            this.Kwe = new WeakReference<>(miniQBReaderUI);
            this.nlD = materialModel;
            this.Kwf = iVar;
            this.Kwg = bVar;
            AppMethodBeat.o(232357);
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.i
        public final void a(boolean z, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
            AppMethodBeat.i(232358);
            MiniQBReaderUI miniQBReaderUI = this.Kwe.get();
            if (miniQBReaderUI == null) {
                Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGo, ui is null");
                AppMethodBeat.o(232358);
            } else if (!z) {
                Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGot, fail");
                AppMethodBeat.o(232358);
            } else {
                miniQBReaderUI.KvW = this.nlD.nlI;
                miniQBReaderUI.Jgy = appBrandOpenMaterialCollection;
                this.Kwg.a(miniQBReaderUI, this.Kwf, appBrandOpenMaterialCollection);
                AppMethodBeat.o(232358);
            }
        }
    }

    private void a(b bVar) {
        AppMethodBeat.i(232361);
        Log.d("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask");
        Pair<i, MaterialModel> gsA = gsA();
        if (gsA == null) {
            Log.w("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, serviceAndMaterialModel is null");
            AppMethodBeat.o(232361);
            return;
        }
        i iVar = (i) gsA.first;
        MaterialModel materialModel = (MaterialModel) gsA.second;
        if (this.filePath == null || !this.filePath.equals(this.KvW) || this.Jgy == null) {
            iVar.a(materialModel, new a(this, materialModel, iVar, bVar));
            AppMethodBeat.o(232361);
            return;
        }
        Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, already fetchOpenMaterials");
        bVar.a(this, iVar, this.Jgy);
        AppMethodBeat.o(232361);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(31973);
        super.onNewIntent(intent);
        Log.i("MicroMsg.MiniQBReaderUI", "onNewIntent %s", toString());
        setIntent(intent);
        String stringExtra = getIntent().getStringExtra("file_path");
        Log.i("MicroMsg.MiniQBReaderUI", "onNewIntent() newFilePath:%s filePath:%s", stringExtra, this.filePath);
        if (!Util.isEqual(stringExtra, this.filePath)) {
            this.lwG = false;
            com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
            if (this.Vim != null) {
                this.Vim.aGj();
            }
            if (this.Vil != null) {
                this.Vil.aGj();
                this.Vil.onDestroy();
            }
            init();
            gsB();
        }
        AppMethodBeat.o(31973);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(232362);
        if (i2 != 4 || this.Vim == null || !this.Vim.wu(2)) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(232362);
            return onKeyDown;
        }
        AppMethodBeat.o(232362);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(31974);
        Log.i("MicroMsg.MiniQBReaderUI", "onResume %s", toString());
        super.onResume();
        if (this.Vil != null) {
            this.Vil.bCA();
        }
        if (this.Vim != null) {
            this.Vim.bCA();
            AppMethodBeat.o(31974);
            return;
        }
        this.KvY = true;
        AppMethodBeat.o(31974);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(31975);
        Log.i("MicroMsg.MiniQBReaderUI", "onPause %s", toString());
        super.onPause();
        if (this.Vim != null) {
            this.KvY = false;
            this.Vim.aGj();
        }
        if (this.Vil != null) {
            this.Vil.aGj();
        }
        AppMethodBeat.o(31975);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(31976);
        Log.i("MicroMsg.MiniQBReaderUI", "onDestroy %s", toString());
        com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
        super.onDestroy();
        if (this.qoZ != null) {
            this.qoZ.dead();
        }
        if (this.Vil != null) {
            this.Vil.onDestroy();
        }
        if (this.BIm != null) {
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.BIm);
        }
        AppMethodBeat.o(31976);
    }

    static /* synthetic */ MiniReaderLogic.a b(MiniQBReaderUI miniQBReaderUI, boolean z) {
        AppMethodBeat.i(258866);
        if (z || miniQBReaderUI.lVE == null) {
            if (miniQBReaderUI.lVE != null) {
                miniQBReaderUI.lVE.iBj = true;
            }
            miniQBReaderUI.lVE = new MiniReaderLogic.a<Integer>() {
                /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass5 */

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(31966);
                    Integer num = (Integer) obj;
                    if (this.iBj) {
                        Log.i("MicroMsg.MiniQBReaderUI", "openReadFile, ignore ret = %d", num);
                        AppMethodBeat.o(31966);
                        return;
                    }
                    Log.i("MicroMsg.MiniQBReaderUI", "openReadFile, ret = %d", num);
                    com.tencent.mm.cr.a.e(MiniQBReaderUI.this, MiniQBReaderUI.this.filePath, MiniQBReaderUI.this.gCr, num.intValue());
                    if (num.intValue() != 0) {
                        MiniQBReaderUI.this.finish();
                    }
                    AppMethodBeat.o(31966);
                }
            };
            MiniReaderLogic.a<Integer> aVar = miniQBReaderUI.lVE;
            AppMethodBeat.o(258866);
            return aVar;
        }
        MiniReaderLogic.a<Integer> aVar2 = miniQBReaderUI.lVE;
        AppMethodBeat.o(258866);
        return aVar2;
    }

    static /* synthetic */ void n(MiniQBReaderUI miniQBReaderUI) {
        AppMethodBeat.i(232365);
        Log.d("MicroMsg.MiniQBReaderUI", "tryShowOpenMaterialBottomSheet");
        miniQBReaderUI.a(new b() {
            /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass8 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.b
            public final void a(MiniQBReaderUI miniQBReaderUI, i iVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
                AppMethodBeat.i(232355);
                if (miniQBReaderUI.KvX != null) {
                    miniQBReaderUI.KvX.dead();
                }
                miniQBReaderUI.KvX = iVar.bQa().b(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH).a(miniQBReaderUI, null, appBrandOpenMaterialCollection);
                miniQBReaderUI.KvX.show();
                AppMethodBeat.o(232355);
            }
        });
        AppMethodBeat.o(232365);
    }

    static /* synthetic */ void a(MiniQBReaderUI miniQBReaderUI, e eVar) {
        AppMethodBeat.i(258868);
        Log.d("MicroMsg.MiniQBReaderUI", "tryEnhanceBottomSheet");
        final WeakReference weakReference = new WeakReference(eVar);
        miniQBReaderUI.a(new b() {
            /* class com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.AnonymousClass9 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.b
            public final void a(MiniQBReaderUI miniQBReaderUI, i iVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
                AppMethodBeat.i(232356);
                e eVar = (e) weakReference.get();
                if (eVar == null) {
                    Log.i("MicroMsg.MiniQBReaderUI", "tryEnhanceBottomSheet#run, bottomSheet is null");
                    AppMethodBeat.o(232356);
                    return;
                }
                if (miniQBReaderUI.Jgz != null) {
                    miniQBReaderUI.Jgz.dead();
                }
                miniQBReaderUI.Jgz = iVar.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH, miniQBReaderUI, eVar, appBrandOpenMaterialCollection, null, null);
                AppMethodBeat.o(232356);
            }
        });
        AppMethodBeat.o(258868);
    }
}
