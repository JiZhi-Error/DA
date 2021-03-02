package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI extends MMActivity {
    private a KsA;
    private Intent KsB = null;
    private String KsC = null;
    private Bundle KsD = null;
    private t KsE = null;
    private ArrayList<String> KsF = null;
    private c KsG = null;
    private c KsH = new c();
    private List<c> KsI;
    private boolean KsJ = false;
    private String KsK;
    private int KsL;
    private int KsM;
    private boolean KsN = false;
    private boolean KsO = false;
    private boolean KsP = false;
    private long KsQ;
    private e KsR;
    private AdapterView.OnItemClickListener KsS = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(109507);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (AppChooserUI.this.KsA != null) {
                AppChooserUI.this.KsG = AppChooserUI.this.KsA.aiN(i2);
                AppChooserUI.this.KsA.notifyDataSetChanged();
                if (AppChooserUI.this.KsR != null && AppChooserUI.this.KsR.kvo.isShowing()) {
                    if (AppChooserUI.this.KsG == null || !AppChooserUI.this.KsG.Kte || (AppChooserUI.this.KsG.ynm && (AppChooserUI.this.KsG.GwV || AppChooserUI.this.KsL >= AppChooserUI.this.KsM))) {
                        AppChooserUI.this.KsR.Ap(true);
                    } else {
                        AppChooserUI.this.KsR.Ap(false);
                    }
                }
                if (!((AppChooserUI.this.scene != 6 && AppChooserUI.this.cxE != 2) || AppChooserUI.this.KsG == null || AppChooserUI.this.KsG.Ktb == null)) {
                    AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.KsG.Ktb.activityInfo.packageName, false);
                    h.INSTANCE.a(12809, 4, AppChooserUI.this.KsG.Ktb.activityInfo.packageName);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(109507);
        }
    };
    private DialogInterface.OnClickListener KsT = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.AnonymousClass2 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(109508);
            if (!(AppChooserUI.this.KsG == null || AppChooserUI.this.KsG.Ktb == null)) {
                g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.this.KsG.Ktb.activityInfo.packageName);
                AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.KsG.Ktb.activityInfo.packageName, true);
            }
            AppMethodBeat.o(109508);
        }
    };
    private DialogInterface.OnClickListener KsU = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.AnonymousClass3 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(109509);
            if (!(AppChooserUI.this.KsG == null || AppChooserUI.this.KsG.Ktb == null)) {
                AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.KsG.Ktb.activityInfo.packageName, false);
            }
            AppMethodBeat.o(109509);
        }
    };
    private View.OnClickListener KsV = new View.OnClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(109510);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
            if (AppChooserUI.this.KsA != null) {
                f fVar = AppChooserUI.this.KsA.KsY;
                if (fVar == f.UNINSTALL) {
                    if (AppChooserUI.this.KsR != null && AppChooserUI.this.KsR.kvo.isShowing()) {
                        AppChooserUI.this.KsA.KsY = f.DOWNLOADING;
                        AppChooserUI.this.KsA.notifyDataSetChanged();
                    }
                    g.a aVar = new g.a();
                    if (AppChooserUI.this.scene == 1) {
                        aVar.alj("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
                    } else {
                        aVar.alj(AppChooserUI.this.KsE.blB());
                    }
                    aVar.all(AppChooserUI.this.KsE.gmq());
                    aVar.Fl(1);
                    aVar.kS(true);
                    com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar.qIY);
                    u.gmF();
                    u.ahI(AppChooserUI.this.cxE);
                    if (AppChooserUI.this.cxE == 0) {
                        if (AppChooserUI.this.KsO) {
                            h.INSTANCE.a(11168, 4, Integer.valueOf(AppChooserUI.this.scene));
                        } else {
                            h.INSTANCE.a(11168, 3, Integer.valueOf(AppChooserUI.this.scene));
                        }
                    }
                    if (AppChooserUI.this.cxE == 1) {
                        h.INSTANCE.a(12809, 5, "");
                    }
                } else if (fVar == f.DOWNLOADED) {
                    AppChooserUI appChooserUI = AppChooserUI.this;
                    long j2 = AppChooserUI.this.KsQ;
                    Log.i("MicroMsg.AppChooserUI", "installRecommendApp");
                    String str = com.tencent.mm.plugin.downloader.model.f.cBv().Co(j2).path;
                    Log.d("MicroMsg.AppChooserUI", "filepath:%s", String.valueOf(str));
                    r.b(appChooserUI.getContext(), str, new com.tencent.mm.pluginsdk.permission.a() {
                        /* class com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.AnonymousClass7 */

                        @Override // com.tencent.mm.pluginsdk.permission.a
                        public final void hk(boolean z) {
                            AppMethodBeat.i(109517);
                            if (!z) {
                                com.tencent.mm.kernel.g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), (Object) 0L);
                                if (AppChooserUI.this.KsA != null) {
                                    AppChooserUI.this.KsA.KsY = f.UNINSTALL;
                                    AppChooserUI.this.KsA.notifyDataSetChanged();
                                }
                            } else if (AppChooserUI.this.KsA != null) {
                                AppChooserUI.this.KsA.KsY = f.DOWNLOADED;
                                AppChooserUI.this.KsA.notifyDataSetChanged();
                                AppMethodBeat.o(109517);
                                return;
                            }
                            AppMethodBeat.o(109517);
                        }
                    }, false);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109510);
        }
    };
    private m KsW = new m() {
        /* class com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void k(long j2, String str) {
            AppMethodBeat.i(109512);
            AppChooserUI.this.KsQ = j2;
            com.tencent.mm.kernel.g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.this.KsQ));
            Log.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", String.valueOf(j2), str);
            AppMethodBeat.o(109512);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Bd(long j2) {
            AppMethodBeat.i(109513);
            Log.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", Long.valueOf(j2));
            AppMethodBeat.o(109513);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void b(long j2, String str, boolean z) {
            AppMethodBeat.i(109514);
            Log.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", Long.valueOf(j2), str);
            if (!Util.isNullOrNil(str) && s.YS(str)) {
                com.tencent.mm.kernel.g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.this.KsQ));
                if (AppChooserUI.this.KsA != null && AppChooserUI.this.KsQ == j2) {
                    AppChooserUI.this.KsA.KsY = f.DOWNLOADED;
                    AppChooserUI.this.KsA.notifyDataSetChanged();
                }
            }
            AppMethodBeat.o(109514);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void b(long j2, int i2, boolean z) {
            AppMethodBeat.i(109515);
            Log.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", Long.valueOf(j2));
            com.tencent.mm.kernel.g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), (Object) 0L);
            if (AppChooserUI.this.KsA != null) {
                AppChooserUI.this.KsA.KsY = f.UNINSTALL;
                AppChooserUI.this.KsA.notifyDataSetChanged();
            }
            AppMethodBeat.o(109515);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Be(long j2) {
            AppMethodBeat.i(109516);
            Log.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", Long.valueOf(j2));
            com.tencent.mm.kernel.g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), (Object) 0L);
            if (AppChooserUI.this.KsA != null) {
                AppChooserUI.this.KsA.KsY = f.UNINSTALL;
                AppChooserUI.this.KsA.notifyDataSetChanged();
            }
            AppMethodBeat.o(109516);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void a(long j2, String str, long j3, long j4) {
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void l(long j2, String str) {
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Bf(long j2) {
        }
    };
    private DialogInterface.OnDismissListener XZ = new DialogInterface.OnDismissListener() {
        /* class com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.AnonymousClass5 */

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(109511);
            AppChooserUI.this.finish();
            AppMethodBeat.o(109511);
        }
    };
    private PackageManager chE;
    private int cxE;
    private String mimeType = null;
    private int scene = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppChooserUI() {
        AppMethodBeat.i(109532);
        AppMethodBeat.o(109532);
    }

    static /* synthetic */ int a(AppChooserUI appChooserUI, int i2) {
        AppMethodBeat.i(109545);
        int aiM = appChooserUI.aiM(i2);
        AppMethodBeat.o(109545);
        return aiM;
    }

    static /* synthetic */ Drawable a(AppChooserUI appChooserUI, ResolveInfo resolveInfo) {
        AppMethodBeat.i(109546);
        Drawable c2 = appChooserUI.c(resolveInfo);
        AppMethodBeat.o(109546);
        return c2;
    }

    static /* synthetic */ void a(AppChooserUI appChooserUI, String str, boolean z) {
        AppMethodBeat.i(109544);
        appChooserUI.m(-1, str, z);
        AppMethodBeat.o(109544);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(109533);
        super.onCreate(bundle);
        u.gmF();
        u.ahF(this.cxE);
        ao.e(getWindow());
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra("targetintent");
        if (!(parcelableExtra instanceof Intent)) {
            Log.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(parcelableExtra)));
            m(0, null, false);
            AppMethodBeat.o(109533);
            return;
        }
        this.KsB = (Intent) parcelableExtra;
        String stringExtra = intent.getStringExtra("title");
        this.cxE = intent.getIntExtra("type", 0);
        this.KsJ = intent.getBooleanExtra("openWay", false);
        this.KsD = intent.getBundleExtra("transferback");
        this.KsF = intent.getStringArrayListExtra("targetwhitelist");
        this.KsO = intent.getBooleanExtra("needupate", false);
        this.mimeType = intent.getStringExtra("mimetype");
        this.scene = intent.getIntExtra("scene", 0);
        if (com.tencent.mm.kernel.g.aAc()) {
            this.KsK = (String) com.tencent.mm.kernel.g.aAh().azQ().get(aiM(274528), "");
            if (TextUtils.isEmpty(this.KsK) || !q.s(getContext(), this.KsK) || ((this.KsF != null && !this.KsF.isEmpty() && !this.KsF.contains(this.KsK)) || this.KsJ)) {
                z = false;
            } else {
                Intent intent2 = new Intent(this.KsB);
                intent2.setPackage(this.KsK);
                if (Util.isIntentAvailable(this, intent2)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            Log.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", Boolean.valueOf(z), Integer.valueOf(this.scene), this.KsK, this.mimeType, Boolean.valueOf(this.KsJ));
            if (!z || this.scene == 6) {
                this.chE = getPackageManager();
                this.KsA = new a();
                u.gmF();
                this.KsE = u.A(this.cxE, intent.getBundleExtra("key_recommend_params"));
                this.KsN = this.KsE.in(getContext());
                this.KsL = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(gsa(), (Object) 0)).intValue();
                u.gmF();
                this.KsM = u.ahE(this.cxE);
                Log.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", String.valueOf(this.KsN), Integer.valueOf(this.KsL));
                this.KsP = !intent.getBooleanExtra("not_show_recommend_app", false);
                if (this.KsL >= this.KsM) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.KsI = a(this.KsB, gsc(), this.KsF);
                if (!z2 && !this.KsN) {
                    com.tencent.mm.kernel.g.aAh().azQ().set(gsa(), Integer.valueOf(this.KsL + 1));
                }
                if (this.KsN) {
                    u.gmF();
                    u.ahH(this.cxE);
                } else if (!z2) {
                    u.gmF();
                    u.ahG(this.cxE);
                }
                Object[] objArr = new Object[1];
                if (this.KsI != null) {
                    i2 = this.KsI.size();
                } else {
                    i2 = 0;
                }
                objArr[0] = Integer.valueOf(i2);
                Log.i("MicroMsg.AppChooserUI", "mResolveListData size %d", objArr);
                if (this.KsI == null || this.KsI.size() != 1 || (gsc() && !this.KsN)) {
                    setTitleVisibility(8);
                    if (this.KsI == null || this.KsI.isEmpty()) {
                        m(4097, null, false);
                        AppMethodBeat.o(109533);
                        return;
                    }
                    this.KsA.qXp = this.KsI;
                    this.KsQ = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(aiM(274560), (Object) 0L)).longValue();
                    FileDownloadTaskInfo Co = com.tencent.mm.plugin.downloader.model.f.cBv().Co(this.KsQ);
                    Log.d("MicroMsg.AppChooserUI", "downloadId:" + this.KsQ + ", status:" + Co.status);
                    if (3 == Co.status && s.YS(Co.path) && this.KsA != null) {
                        this.KsA.KsY = f.DOWNLOADED;
                        this.KsA.notifyDataSetChanged();
                    }
                    this.KsR = new e(getContext());
                    e eVar = this.KsR;
                    if (stringExtra != null) {
                        eVar.mTitle = stringExtra.toString();
                    } else {
                        eVar.mTitle = null;
                    }
                    this.KsR.Kth = this.KsS;
                    this.KsR.KsU = this.KsU;
                    this.KsR.Kti = this.KsT;
                    this.KsR.pXY = this.KsA;
                    this.KsR.XZ = this.XZ;
                    e eVar2 = this.KsR;
                    if (eVar2.Kth != null) {
                        eVar2.Ktg.setOnItemClickListener(eVar2.Kth);
                    }
                    if (eVar2.pXY != null) {
                        eVar2.Ktg.setAdapter((ListAdapter) eVar2.pXY);
                    }
                    eVar2.kvo = com.tencent.mm.ui.base.h.a(eVar2.mContext, true, eVar2.mTitle, (View) eVar2.Ktg, eVar2.mContext.getString(R.string.zr), eVar2.mContext.getString(R.string.zq), eVar2.KsU, eVar2.Kti, (int) R.color.ts);
                    eVar2.kvo.setOnDismissListener(eVar2.XZ);
                    eVar2.kvo.show();
                    if (!this.KsO && this.KsN && !z2) {
                        this.KsG = this.KsH;
                        this.KsR.Ap(true);
                    }
                    com.tencent.mm.plugin.downloader.model.f.cBv();
                    com.tencent.mm.plugin.downloader.model.c.a(this.KsW);
                    AppMethodBeat.o(109533);
                    return;
                }
                c cVar = this.KsI.get(0);
                if (cVar == null) {
                    m(4097, null, false);
                    AppMethodBeat.o(109533);
                } else if (cVar.Ktb != null) {
                    m(-1, cVar.Ktb.activityInfo.packageName, false);
                    AppMethodBeat.o(109533);
                } else {
                    m(4098, null, false);
                    AppMethodBeat.o(109533);
                }
            } else {
                m(-1, this.KsK, true);
                AppMethodBeat.o(109533);
            }
        } else {
            Log.e("MicroMsg.AppChooserUI", "acc not ready");
            m(4097, null, false);
            AppMethodBeat.o(109533);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109534);
        super.onResume();
        if (this.KsO && this.KsB != null && this.KsE.aw(this, this.KsB)) {
            Log.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.KsO = false;
            this.KsH.Ktf = false;
        }
        this.KsN = this.KsE.in(getContext());
        this.KsI = a(this.KsB, gsc(), this.KsF);
        if (this.KsN && this.KsG == null && !this.KsJ) {
            this.KsG = this.KsH;
            this.KsR.Ap(true);
        }
        if (this.KsA != null) {
            this.KsA.qXp = this.KsI;
            this.KsA.notifyDataSetChanged();
        }
        AppMethodBeat.o(109534);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109535);
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.f.cBv();
        com.tencent.mm.plugin.downloader.model.c.b(this.KsW);
        if (this.KsR != null) {
            this.KsR.kvo.dismiss();
        }
        AppMethodBeat.o(109535);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(109536);
        super.onBackPressed();
        m(0, null, false);
        AppMethodBeat.o(109536);
    }

    private int aiM(int i2) {
        AppMethodBeat.i(109537);
        if (this.mimeType != null) {
            int hashCode = this.cxE + i2 + this.mimeType.hashCode();
            AppMethodBeat.o(109537);
            return hashCode;
        }
        int i3 = this.cxE + i2;
        AppMethodBeat.o(109537);
        return i3;
    }

    private int gsa() {
        return 274496 + this.cxE;
    }

    private void m(int i2, String str, boolean z) {
        AppMethodBeat.i(109538);
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.KsD);
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(109538);
    }

    private void gsb() {
        AppMethodBeat.i(109539);
        u.a gmr = this.KsE.gmr();
        if (!Util.isNullOrNil(gmr.JVC)) {
            this.KsC = gmr.JVC;
        } else if (gmr.JVB > 0) {
            this.KsC = getResources().getString(gmr.JVB);
        }
        if (gmr.JVA > 0) {
            this.KsH.Ktd = getResources().getDrawable(gmr.JVA);
        }
        if (gmr.JVD > 0) {
            this.KsH.Ktc = getResources().getString(gmr.JVD);
        } else {
            this.KsH.Ktc = gmr.JVE;
        }
        this.KsH.Kte = true;
        this.KsH.GwV = this.KsN;
        if (this.KsN) {
            this.KsH.ynm = true;
        }
        if (this.KsO) {
            this.KsH.Ktf = true;
        }
        AppMethodBeat.o(109539);
    }

    private boolean gsc() {
        AppMethodBeat.i(109540);
        Log.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", Boolean.valueOf(this.KsP), Integer.valueOf(this.KsL), Integer.valueOf(this.KsM), Boolean.valueOf(Util.isOverseasUser(this)));
        if (!this.KsP || this.KsL >= this.KsM || Util.isOverseasUser(this) || ChannelUtil.channelId == 1) {
            AppMethodBeat.o(109540);
            return false;
        }
        AppMethodBeat.o(109540);
        return true;
    }

    private List<c> a(Intent intent, boolean z, ArrayList<String> arrayList) {
        boolean z2;
        AppMethodBeat.i(109541);
        ArrayList arrayList2 = new ArrayList();
        List<ResolveInfo> queryIntentActivities = this.chE.queryIntentActivities(intent, 65536);
        gsb();
        boolean z3 = false;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i2 = 0;
            while (i2 < size) {
                Log.i("MicroMsg.AppChooserUI", "cpan name:%s", queryIntentActivities.get(i2).activityInfo.name);
                ResolveInfo resolveInfo = queryIntentActivities.get(i2);
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (arrayList == null || arrayList.isEmpty() || arrayList.contains(str)) {
                        if (this.KsE.bdn(str)) {
                            this.KsH.Ktb = resolveInfo;
                            this.KsH.ynm = true;
                            if ((!z && this.KsN) || (!z && this.KsH.ynm)) {
                                arrayList2.add(0, this.KsH);
                                z2 = true;
                                i2++;
                                z3 = z2;
                            }
                        } else {
                            arrayList2.add(new c(resolveInfo, this.KsE.c(getContext(), resolveInfo)));
                        }
                    }
                }
                z2 = z3;
                i2++;
                z3 = z2;
            }
        }
        if (z && !z3) {
            if (this.cxE != 0 || this.mimeType == null) {
                arrayList2.add(0, this.KsH);
            } else {
                arrayList2.add(0, this.KsH);
                if (this.KsO) {
                    h.INSTANCE.a(11168, 2, Integer.valueOf(this.scene));
                } else {
                    h.INSTANCE.a(11168, 1, Integer.valueOf(this.scene));
                }
            }
        }
        if ((this.scene == 4 || this.scene == 8) && this.KsH.Ktb == null) {
            this.KsH.Ktb = new ResolveInfo();
            this.KsH.Ktb.activityInfo = new ActivityInfo();
            this.KsH.Ktb.activityInfo.packageName = TbsConfig.APP_QB;
        }
        HashSet hashSet = new HashSet();
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList2.get(size2);
            if (cVar.Ktb != null) {
                String str2 = cVar.Ktb.activityInfo.packageName;
                if (!Util.isNullOrNil(str2) && !hashSet.add(str2)) {
                    arrayList2.remove(size2);
                }
            }
        }
        AppMethodBeat.o(109541);
        return arrayList2;
    }

    private static Drawable e(Resources resources, int i2) {
        Drawable drawable;
        AppMethodBeat.i(109542);
        try {
            drawable = com.tencent.mm.cc.b.f(resources, i2);
        } catch (Resources.NotFoundException e2) {
            drawable = null;
        }
        AppMethodBeat.o(109542);
        return drawable;
    }

    private Drawable c(ResolveInfo resolveInfo) {
        Drawable e2;
        Drawable e3;
        AppMethodBeat.i(109543);
        try {
            if (resolveInfo.resolvePackageName == null || resolveInfo.icon == 0 || (e3 = e(this.chE.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon)) == null) {
                int iconResource = resolveInfo.getIconResource();
                if (!(iconResource == 0 || (e2 = e(this.chE.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource)) == null)) {
                    Log.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", Integer.valueOf(iconResource));
                    AppMethodBeat.o(109543);
                    return e2;
                }
                Drawable loadIcon = resolveInfo.loadIcon(this.chE);
                AppMethodBeat.o(109543);
                return loadIcon;
            }
            AppMethodBeat.o(109543);
            return e3;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", e4);
        }
    }

    /* access modifiers changed from: package-private */
    public class e {
        DialogInterface.OnClickListener KsU;
        ListViewInScrollView Ktg = ((ListViewInScrollView) View.inflate(this.mContext, R.layout.g9, null));
        AdapterView.OnItemClickListener Kth;
        DialogInterface.OnClickListener Kti;
        DialogInterface.OnDismissListener XZ;
        public com.tencent.mm.ui.widget.a.d kvo;
        Context mContext;
        String mTitle;
        BaseAdapter pXY;

        public e(Context context) {
            AppMethodBeat.i(109527);
            this.mContext = context;
            AppMethodBeat.o(109527);
        }

        public final void Ap(boolean z) {
            AppMethodBeat.i(109528);
            if (this.kvo != null) {
                if (!z) {
                    this.kvo.a(R.string.zr, (DialogInterface.OnClickListener) null);
                    this.kvo.b(R.string.zq, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(109528);
                    return;
                }
                this.kvo.a(R.string.zr, this.KsU);
                this.kvo.b(R.string.zq, this.Kti);
            }
            AppMethodBeat.o(109528);
        }
    }

    class d extends AsyncTask<c, Void, c> {
        d() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ c doInBackground(c[] cVarArr) {
            AppMethodBeat.i(109526);
            c cVar = cVarArr[0];
            if (cVar.Ktd == null) {
                cVar.Ktd = AppChooserUI.a(AppChooserUI.this, cVar.Ktb);
            }
            AppMethodBeat.o(109526);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(c cVar) {
            AppMethodBeat.i(109525);
            AppChooserUI.this.KsA.notifyDataSetChanged();
            AppMethodBeat.o(109525);
        }
    }

    public enum f {
        UNINSTALL,
        DOWNLOADING,
        DOWNLOADED;

        public static f valueOf(String str) {
            AppMethodBeat.i(109530);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(109530);
            return fVar;
        }

        static {
            AppMethodBeat.i(109531);
            AppMethodBeat.o(109531);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        f KsY = f.UNINSTALL;
        List<c> qXp = new ArrayList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(109523);
            c aiN = aiN(i2);
            AppMethodBeat.o(109523);
            return aiN;
        }

        public a() {
            AppMethodBeat.i(109518);
            AppChooserUI.this.chE = AppChooserUI.this.getPackageManager();
            AppMethodBeat.o(109518);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            boolean z;
            int i3 = 0;
            AppMethodBeat.i(109519);
            c aiN = aiN(i2);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(AppChooserUI.this.getContext()).inflate(aiN.Kte ? R.layout.ga : R.layout.g_, (ViewGroup) null);
                b bVar2 = new b(view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (aiN.Ktd == null) {
                new d().execute(aiN);
            }
            bVar.vs.setImageDrawable(aiN.Ktd);
            CharSequence charSequence = aiN.Ktc;
            if (AppChooserUI.this.KsJ && aiN.Ktb != null && aiN.Ktb.activityInfo.packageName.equals(AppChooserUI.this.KsK)) {
                charSequence = TextUtils.concat(charSequence, AppChooserUI.this.getString(R.string.te));
                if (AppChooserUI.this.KsG == null) {
                    AppChooserUI.this.KsG = aiN;
                }
            }
            bVar.xVW.setText(charSequence);
            if (aiN == null || ((aiN.Kte && !aiN.GwV && (!aiN.Kte || !aiN.ynm || AppChooserUI.this.KsL < AppChooserUI.this.KsM)) || aiN.Ktf)) {
                bVar.KsZ.setVisibility(0);
                bVar.Kta.setVisibility(8);
                bVar.KsZ.setOnClickListener(AppChooserUI.this.KsV);
                if (this.KsY == f.UNINSTALL) {
                    if (aiN.Ktf) {
                        bVar.KsZ.setText(R.string.x2);
                    } else {
                        bVar.KsZ.setText(R.string.tm);
                    }
                    bVar.KsZ.setEnabled(true);
                } else if (this.KsY == f.DOWNLOADING) {
                    bVar.KsZ.setText(R.string.ts);
                    bVar.KsZ.setEnabled(false);
                } else if (this.KsY == f.DOWNLOADED) {
                    if (aiN.Ktf) {
                        bVar.KsZ.setText(R.string.zd);
                    } else {
                        bVar.KsZ.setText(R.string.zc);
                    }
                    bVar.KsZ.setEnabled(true);
                }
            } else {
                bVar.KsZ.setVisibility(8);
                bVar.Kta.setVisibility(0);
                RadioButton radioButton = bVar.Kta;
                c cVar = AppChooserUI.this.KsG;
                if (cVar instanceof c) {
                    c cVar2 = cVar;
                    if (!(cVar2.Ktb == null || aiN.Ktb == null || !cVar2.Ktb.activityInfo.packageName.equals(aiN.Ktb.activityInfo.packageName)) || (cVar2.Kte && aiN.Kte)) {
                        z = true;
                        radioButton.setChecked(z);
                    }
                }
                z = false;
                radioButton.setChecked(z);
            }
            if (aiN.Kte) {
                if (AppChooserUI.this.scene == 4) {
                    bVar.xVY.setText(R.string.fr0);
                } else {
                    bVar.xVY.setText(Util.nullAsNil(AppChooserUI.this.KsC));
                }
                TextView textView = bVar.xVY;
                if (Util.isNullOrNil(AppChooserUI.this.KsC)) {
                    i3 = 8;
                }
                textView.setVisibility(i3);
            } else {
                bVar.xVY.setVisibility(8);
            }
            if (!(AppChooserUI.this.scene == 6 || AppChooserUI.this.KsG == null || !AppChooserUI.this.KsG.equals(aiN))) {
                bVar.Kta.setChecked(true);
            }
            AppMethodBeat.o(109519);
            return view;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final c aiN(int i2) {
            AppMethodBeat.i(109520);
            if (this.qXp == null) {
                AppMethodBeat.o(109520);
                return null;
            }
            c cVar = this.qXp.get(i2);
            AppMethodBeat.o(109520);
            return cVar;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(109521);
            if (aiN(i2).Kte) {
                AppMethodBeat.o(109521);
                return 1;
            }
            AppMethodBeat.o(109521);
            return 0;
        }

        public final int getCount() {
            AppMethodBeat.i(109522);
            if (this.qXp == null) {
                AppMethodBeat.o(109522);
                return 0;
            }
            int size = this.qXp.size();
            AppMethodBeat.o(109522);
            return size;
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        boolean GwV;
        ResolveInfo Ktb;
        CharSequence Ktc;
        Drawable Ktd;
        boolean Kte;
        boolean Ktf;
        boolean ynm;

        public c() {
        }

        public c(ResolveInfo resolveInfo, CharSequence charSequence) {
            this.Ktb = resolveInfo;
            this.Ktc = charSequence;
            this.Kte = false;
            this.GwV = true;
            this.Ktf = false;
        }
    }

    class b {
        TextView KsZ;
        RadioButton Kta;
        ImageView vs;
        TextView xVW;
        TextView xVY;

        public b(View view) {
            AppMethodBeat.i(109524);
            this.vs = (ImageView) view.findViewById(R.id.rw);
            this.xVW = (TextView) view.findViewById(R.id.s_);
            this.xVY = (TextView) view.findViewById(R.id.rn);
            this.KsZ = (TextView) view.findViewById(R.id.sj);
            this.Kta = (RadioButton) view.findViewById(R.id.sf);
            AppMethodBeat.o(109524);
        }
    }
}
