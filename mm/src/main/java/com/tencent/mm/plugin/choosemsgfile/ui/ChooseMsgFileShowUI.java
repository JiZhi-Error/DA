package com.tencent.mm.plugin.choosemsgfile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.xweb.util.h;

@a(3)
public class ChooseMsgFileShowUI extends MMSecDataActivity {
    private d JRP;
    private a JRQ;
    private String fileName = "";
    private String filePath = "";
    private String gCr = "";
    private MiniReaderLogic.a<Integer> lVE = null;
    private boolean lwG = true;
    private boolean lwH = false;
    private ValueCallback<String> lwJ = new ValueCallback<String>() {
        /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass4 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(123409);
            String str2 = str;
            Log.i("MicroMsg.ChooseMsgFileShowUI", "openReadFile, receiveValue = %s", str2);
            if ("query for feature_wx_float_window successfully".equals(str2)) {
                ChooseMsgFileShowUI.this.lwH = true;
                MiniReaderLogic.a(ChooseMsgFileShowUI.this.JRQ.eqW(), ChooseMsgFileShowUI.this.JRQ.eqZ(), ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, ChooseMsgFileShowUI.this.fileName, ChooseMsgFileShowUI.this.gCr, ChooseMsgFileShowUI.this.token, ChooseMsgFileShowUI.this.lwJ, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, true));
                AppMethodBeat.o(123409);
            } else if ("xwebFileReaderReachEnd".equals(str2)) {
                Log.d("MicroMsg.ChooseMsgFileShowUI", "xweb file reader reach end");
                AppMethodBeat.o(123409);
            } else if ("xwebFileReaderUserOperated".equals(str2)) {
                Log.d("MicroMsg.ChooseMsgFileShowUI", "xweb file reader user operated");
                AppMethodBeat.o(123409);
            } else if (!"fileReaderClosed".equals(str2)) {
                if ("fileReaderMenuClicked".equals(str2)) {
                    e eVar = new e((Context) ChooseMsgFileShowUI.this, 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(123407);
                            mVar.d(0, ChooseMsgFileShowUI.this.getString(R.string.g5c));
                            mVar.d(3, ChooseMsgFileShowUI.this.getString(R.string.cei));
                            mVar.d(1, ChooseMsgFileShowUI.this.getString(R.string.b3m));
                            mVar.d(4, ChooseMsgFileShowUI.this.getString(R.string.c2x));
                            AppMethodBeat.o(123407);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass4.AnonymousClass2 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(123408);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    h.bsL(ChooseMsgFileShowUI.this.gCr);
                                    com.tencent.mm.cr.a.a(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, ChooseMsgFileShowUI.this.fileName, ChooseMsgFileShowUI.this.gCr);
                                    AppMethodBeat.o(123408);
                                    return;
                                case 1:
                                    h.bsM(ChooseMsgFileShowUI.this.gCr);
                                    com.tencent.mm.pluginsdk.ui.tools.a.b(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, ChooseMsgFileShowUI.this.gCr);
                                    AppMethodBeat.o(123408);
                                    return;
                                case 2:
                                    ChooseMsgFileShowUI.this.JRQ.ic(false);
                                    AppMethodBeat.o(123408);
                                    return;
                                case 3:
                                    ChooseMsgFileShowUI.this.JRQ.ic(true);
                                    AppMethodBeat.o(123408);
                                    return;
                                case 4:
                                    p.c(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, new p.a() {
                                        /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass4.AnonymousClass2.AnonymousClass1 */

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bP(String str, String str2) {
                                            AppMethodBeat.i(237147);
                                            Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(R.string.hp6, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                                            AppMethodBeat.o(237147);
                                        }

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bQ(String str, String str2) {
                                            AppMethodBeat.i(237148);
                                            Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(R.string.hp5), 1).show();
                                            AppMethodBeat.o(237148);
                                        }
                                    });
                                    break;
                            }
                            AppMethodBeat.o(123408);
                        }
                    };
                    eVar.dGm();
                }
                AppMethodBeat.o(123409);
            } else if (ChooseMsgFileShowUI.this.lwG) {
                ChooseMsgFileShowUI.this.finish();
                AppMethodBeat.o(123409);
            } else {
                Log.i("MicroMsg.ChooseMsgFileShowUI", "opCallback isFinishCurPage:%s", Boolean.valueOf(ChooseMsgFileShowUI.this.lwG));
                ChooseMsgFileShowUI.this.lwG = true;
                AppMethodBeat.o(123409);
            }
        }
    };
    private ValueCallback<Integer> lwK = new ValueCallback<Integer>() {
        /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Integer num) {
            AppMethodBeat.i(123405);
            Log.i("MicroMsg.ChooseMsgFileShowUI", "updateRetCallback onReceiveValue ret = %d", num);
            AppMethodBeat.o(123405);
        }
    };
    private int qoX;
    private IListener<mn> qoZ = new IListener<mn>() {
        /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161583);
            this.__eventId = mn.class.getName().hashCode();
            AppMethodBeat.o(161583);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mn mnVar) {
            AppMethodBeat.i(123404);
            boolean a2 = a(mnVar);
            AppMethodBeat.o(123404);
            return a2;
        }

        private boolean a(mn mnVar) {
            AppMethodBeat.i(123403);
            if (mnVar != null && mnVar.dSa != null && ChooseMsgFileShowUI.this.JRQ != null) {
                if (Util.isEqual(mnVar.dSa.filePath, ChooseMsgFileShowUI.this.filePath)) {
                    Log.i("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", Integer.valueOf(mnVar.dSa.action));
                    switch (mnVar.dSa.action) {
                        case 1:
                        case 8:
                            ChooseMsgFileShowUI.this.JRQ.ic(true);
                            break;
                        case 2:
                            ChooseMsgFileShowUI.this.JRQ.ic(false);
                            if (!ChooseMsgFileShowUI.this.lwH) {
                                ChooseMsgFileShowUI.this.lwG = false;
                                com.tencent.mm.cr.a.Z(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.token, ChooseMsgFileShowUI.this.filePath);
                                MiniReaderLogic.a(false, false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, ChooseMsgFileShowUI.this.fileName, ChooseMsgFileShowUI.this.gCr, ChooseMsgFileShowUI.this.token, ChooseMsgFileShowUI.this.lwJ, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, false));
                                break;
                            } else {
                                MiniReaderLogic.a(false, (Context) ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, ChooseMsgFileShowUI.this.fileName, ChooseMsgFileShowUI.this.gCr, ChooseMsgFileShowUI.this.token, (ValueCallback<String>) ChooseMsgFileShowUI.this.lwJ, (ValueCallback<Integer>) ChooseMsgFileShowUI.this.lwK, true, "", false);
                                break;
                            }
                        case 4:
                            p.c(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, new p.a() {
                                /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.platformtools.p.a
                                public final void bP(String str, String str2) {
                                    AppMethodBeat.i(237145);
                                    Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(R.string.hp6, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                                    AppMethodBeat.o(237145);
                                }

                                @Override // com.tencent.mm.platformtools.p.a
                                public final void bQ(String str, String str2) {
                                    AppMethodBeat.i(237146);
                                    Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(R.string.hp5), 1).show();
                                    AppMethodBeat.o(237146);
                                }
                            });
                            break;
                    }
                } else {
                    Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.filePath:%s filePath:%s", mnVar.dSa.filePath, ChooseMsgFileShowUI.this.filePath);
                }
            } else {
                Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent fail");
            }
            AppMethodBeat.o(123403);
            return false;
        }
    };
    private String token = Integer.toString(hashCode());

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChooseMsgFileShowUI() {
        AppMethodBeat.i(123410);
        AppMethodBeat.o(123410);
    }

    static /* synthetic */ MiniReaderLogic.a b(ChooseMsgFileShowUI chooseMsgFileShowUI, boolean z) {
        AppMethodBeat.i(123417);
        MiniReaderLogic.a<Integer> kG = chooseMsgFileShowUI.kG(z);
        AppMethodBeat.o(123417);
        return kG;
    }

    private MiniReaderLogic.a<Integer> kG(boolean z) {
        AppMethodBeat.i(123411);
        if (z || this.lVE == null) {
            if (this.lVE != null) {
                this.lVE.iBj = true;
            }
            this.lVE = new MiniReaderLogic.a<Integer>() {
                /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.AnonymousClass3 */

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(123406);
                    Integer num = (Integer) obj;
                    if (this.iBj) {
                        Log.i("MicroMsg.ChooseMsgFileShowUI", "openReadFile, ignore ret = %d", num);
                        AppMethodBeat.o(123406);
                        return;
                    }
                    Log.i("MicroMsg.ChooseMsgFileShowUI", "openReadFile, ret = %d", num);
                    com.tencent.mm.cr.a.e(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.filePath, ChooseMsgFileShowUI.this.gCr, num.intValue());
                    if (num.intValue() != 0) {
                        ChooseMsgFileShowUI.this.finish();
                    }
                    AppMethodBeat.o(123406);
                }
            };
            MiniReaderLogic.a<Integer> aVar = this.lVE;
            AppMethodBeat.o(123411);
            return aVar;
        }
        MiniReaderLogic.a<Integer> aVar2 = this.lVE;
        AppMethodBeat.o(123411);
        return aVar2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123412);
        super.onCreate(bundle);
        this.filePath = getIntent().getStringExtra("key_filepath");
        this.gCr = getIntent().getStringExtra("key_fileext");
        this.qoX = getIntent().getIntExtra("sence", 0);
        try {
            int lastIndexOf = this.filePath.lastIndexOf(47) + 1;
            if (lastIndexOf < 0 || lastIndexOf == this.filePath.length()) {
                lastIndexOf = 0;
            }
            this.fileName = this.filePath.substring(lastIndexOf, this.filePath.length());
        } catch (Exception e2) {
            Log.e("MicroMsg.ChooseMsgFileShowUI", "get file name error " + e2.getMessage());
            this.fileName = "";
        }
        this.JRP = new d(new e(getContext()));
        this.JRP.I(this.filePath, this.gCr, this.qoX);
        d dVar = this.JRP;
        String str = this.gCr;
        String str2 = this.fileName;
        Integer agX = d.agX(str);
        if (agX == null) {
            agX = d.agX("unknown");
        }
        dVar.oWE.noe = agX.intValue();
        dVar.oWE.name = str2;
        dVar.cit();
        this.JRQ = new a(new b(getContext()));
        this.JRQ.I(this.filePath, this.gCr, this.qoX);
        a aVar = this.JRQ;
        String str3 = this.gCr;
        String str4 = this.fileName;
        MultiTaskInfo multiTaskInfo = aVar.Abp;
        multiTaskInfo.erh().title = str4;
        multiTaskInfo.erh().gCr = str3;
        aVar.eqX();
        if (this.qoZ != null) {
            this.qoZ.alive();
        }
        MiniReaderLogic.a(this.JRQ.eqW(), this.JRQ.eqZ(), this, this.filePath, this.fileName, this.gCr, this.token, this.lwJ, kG(true), true, "", true, false);
        AppMethodBeat.o(123412);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(123413);
        super.onResume();
        if (this.JRP != null) {
            this.JRP.bCA();
        }
        if (this.JRQ != null) {
            this.JRQ.bCA();
        }
        AppMethodBeat.o(123413);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(123414);
        super.onPause();
        if (this.JRP != null) {
            this.JRP.aGj();
        }
        if (this.JRQ != null) {
            this.JRQ.aGj();
        }
        AppMethodBeat.o(123414);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(123415);
        com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
        super.onDestroy();
        if (this.qoZ != null) {
            this.qoZ.dead();
        }
        if (this.JRP != null) {
            this.JRP.onDestroy();
        }
        AppMethodBeat.o(123415);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    public static void t(Context context, String str, String str2) {
        AppMethodBeat.i(123416);
        Intent intent = new Intent(context, ChooseMsgFileShowUI.class);
        intent.putExtra("key_filepath", str);
        intent.putExtra("key_fileext", str2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(123416);
    }
}
