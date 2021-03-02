package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.plugin.downloader_app.a.g;
import com.tencent.mm.plugin.downloader_app.a.h;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadMainUI extends MMActivity {
    private View gAy;
    private int gwE;
    private String mAppId;
    private f qLb;
    TaskListView qMg;
    private DeleteTaskFooterView qMh;
    private TaskManagerHeaderView qMi;
    private View qMj;
    private boolean qMk;
    private boolean qMl;
    private g qMm;
    private boolean qMn = false;
    private com.tencent.mm.plugin.downloader_app.a.f qMo;

    public interface a {
        void lf(boolean z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(DownloadMainUI downloadMainUI, g gVar, boolean z) {
        AppMethodBeat.i(183811);
        downloadMainUI.a(gVar, z);
        AppMethodBeat.o(183811);
    }

    static /* synthetic */ boolean a(DownloadMainUI downloadMainUI) {
        AppMethodBeat.i(183810);
        boolean cCm = downloadMainUI.cCm();
        AppMethodBeat.o(183810);
        return cCm;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(9001);
        super.onCreate(bundle);
        this.gwE = getIntent().getIntExtra("from_scene", 0);
        if (this.gwE == 3) {
            overridePendingTransition(R.anim.fa, R.anim.ad);
        }
        Log.i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
        this.qMl = true;
        setActionbarColor(getResources().getColor(R.color.mf));
        showActionbarLine();
        setMMTitle(R.string.j1n);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(8988);
                if (!DownloadMainUI.a(DownloadMainUI.this) || DownloadMainUI.this.qMo == null || !DownloadMainUI.this.qMo.wu(1)) {
                    DownloadMainUI.this.finish();
                    AppMethodBeat.o(8988);
                } else {
                    AppMethodBeat.o(8988);
                }
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(8989);
                DownloadMainUI downloadMainUI = DownloadMainUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(DownloadMainUI.this, DownloadSearchUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(downloadMainUI, bl.axQ(), "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                downloadMainUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(downloadMainUI, "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.downloader_app.b.a.a(10, 1001, 1, 2, "", "", "");
                AppMethodBeat.o(8989);
                return true;
            }
        });
        this.qMg = (TaskListView) findViewById(R.id.ecm);
        this.qMh = (DeleteTaskFooterView) findViewById(R.id.bmh);
        this.qMg.qNg = new a() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.a
            public final void lf(boolean z) {
                AppMethodBeat.i(8990);
                if (z) {
                    DownloadMainUI.this.qMh.setVisibility(0);
                    DownloadMainUI.this.qMh.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.ak));
                    DownloadMainUI.this.qMi.setVisibility(0);
                    DownloadMainUI.this.qMi.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.fe));
                    AppMethodBeat.o(8990);
                    return;
                }
                DownloadMainUI.this.qMh.setVisibility(8);
                DownloadMainUI.this.qMh.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.al));
                DownloadMainUI.this.qMi.setVisibility(8);
                DownloadMainUI.this.qMi.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.ff));
                AppMethodBeat.o(8990);
            }
        };
        this.qMi = (TaskManagerHeaderView) findViewById(R.id.dp1);
        this.qMj = findViewById(R.id.g05);
        amZ();
        com.tencent.mm.plugin.downloader_app.b.a.a(10, 0, 0, 1, "", "", cCl());
        this.qMo = new com.tencent.mm.plugin.downloader_app.a.f(new e(this));
        this.qMo.G(16, "GameDownloadFloatBall");
        com.tencent.mm.plugin.downloader_app.a.e.cBX();
        com.tencent.mm.plugin.downloader_app.a.e.lb(false);
        AppMethodBeat.o(9001);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(9002);
        super.onResume();
        this.qMk = true;
        if (!this.qMl) {
            this.qMm = h.cCc();
            a(this.qMm, true);
        }
        this.qMl = false;
        if (this.qMo != null) {
            this.qMo.bCA();
        }
        AppMethodBeat.o(9002);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(9003);
        super.onPause();
        if (this.qMm != null) {
            ((com.tencent.mm.plugin.game.commlib.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).a("pb_appinfo", this.qMm.qKY);
        }
        this.qMk = false;
        if (this.qMo != null) {
            this.qMo.aGj();
        }
        AppMethodBeat.o(9003);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(9004);
        setIntent(intent);
        this.qMg.cCr();
        amZ();
        AppMethodBeat.o(9004);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(175276);
        super.finish();
        if (this.gwE == 3) {
            overridePendingTransition(R.anim.ab, R.anim.am);
        }
        AppMethodBeat.o(175276);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(9005);
        super.onDestroy();
        h.qLd = null;
        if (this.qMo != null) {
            this.qMo.onDestroy();
        }
        AppMethodBeat.o(9005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        boolean z;
        AppMethodBeat.i(9006);
        if (this.qMg != null) {
            TaskListView taskListView = this.qMg;
            if (taskListView.qNh) {
                taskListView.cCr();
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(9006);
                return;
            }
        }
        if (!cCm() || this.qMo == null || !this.qMo.wu(2)) {
            super.onBackPressed();
            AppMethodBeat.o(9006);
            return;
        }
        AppMethodBeat.o(9006);
    }

    private void amZ() {
        AppMethodBeat.i(9007);
        this.mAppId = getIntent().getStringExtra("appId");
        this.qMn = getIntent().getBooleanExtra("view_task", false);
        Log.i("MicroMsg.DownloadMainUI", "initData, appId : %s, viewTask : %b", this.mAppId, Boolean.valueOf(this.qMn));
        com.tencent.mm.pluginsdk.model.app.h.o(this.mAppId, true, false);
        cCk();
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(8993);
                DownloadMainUI.this.qMm = h.cCc();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(8991);
                        DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.this.qMm, false);
                        AppMethodBeat.o(8991);
                    }
                });
                if (DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.this.mAppId)) {
                    DownloadMainUI.this.d(j.cCg(), null);
                    AppMethodBeat.o(8993);
                    return;
                }
                LinkedList<String> cCg = j.cCg();
                if (!cCg.contains(DownloadMainUI.this.mAppId)) {
                    cCg.add(DownloadMainUI.this.mAppId);
                }
                DownloadMainUI.this.d(cCg, DownloadMainUI.this.mAppId);
                p.y(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass4.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(8992);
                        DownloadMainUI.g(DownloadMainUI.this);
                        AppMethodBeat.o(8992);
                    }
                });
                AppMethodBeat.o(8993);
            }
        });
        AppMethodBeat.o(9007);
    }

    private void cCk() {
        com.tencent.mm.plugin.downloader.g.a alb;
        AppMethodBeat.i(9008);
        if (this.gwE == 1 && (alb = d.alb(this.mAppId)) != null) {
            b bVar = new b();
            bVar.k(alb);
            bVar.costTime = 0;
            com.tencent.mm.plugin.downloader.f.a.a(19, bVar);
        }
        AppMethodBeat.o(9008);
    }

    public final void d(LinkedList<String> linkedList, final String str) {
        AppMethodBeat.i(9009);
        h.a(linkedList, new h.a() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.downloader_app.a.h.a
            public final void kW(boolean z) {
                AppMethodBeat.i(9000);
                p.y(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass8.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(8997);
                        DownloadMainUI.j(DownloadMainUI.this);
                        AppMethodBeat.o(8997);
                    }
                });
                if (z) {
                    DownloadMainUI.this.qMm = h.cCc();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass8.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(8999);
                            if (!Util.isNullOrNil(str)) {
                                final i alz = DownloadMainUI.this.qMm.alz(str);
                                if (alz != null) {
                                    j.alB(str);
                                    p.postDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.AnonymousClass8.AnonymousClass2.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(8998);
                                            c.a((Context) DownloadMainUI.this, alz, true);
                                            AppMethodBeat.o(8998);
                                        }
                                    }, 200);
                                } else {
                                    com.tencent.mm.ui.base.h.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(R.string.fdo), true);
                                }
                            }
                            DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.this.qMm, true);
                            AppMethodBeat.o(8999);
                        }
                    });
                    AppMethodBeat.o(9000);
                    return;
                }
                if (!Util.isNullOrNil(str)) {
                    com.tencent.mm.ui.base.h.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(R.string.au2), true);
                }
                AppMethodBeat.o(9000);
            }
        });
        AppMethodBeat.o(9009);
    }

    private void a(g gVar, boolean z) {
        f fVar;
        AppMethodBeat.i(9010);
        if (gVar != null) {
            fVar = gVar.qLb;
        } else {
            fVar = null;
        }
        this.qLb = fVar;
        if (gVar == null || gVar.cCb()) {
            if (z) {
                le(true);
            }
            AppMethodBeat.o(9010);
            return;
        }
        LinkedList<i> X = gVar.X(j.cCg());
        if (Util.isNullOrNil(X)) {
            le(true);
            AppMethodBeat.o(9010);
            return;
        }
        le(false);
        this.qMg.setData(X);
        AppMethodBeat.o(9010);
    }

    public final void ld(boolean z) {
        AppMethodBeat.i(9011);
        DeleteTaskFooterView deleteTaskFooterView = this.qMh;
        deleteTaskFooterView.qMd = z;
        if (deleteTaskFooterView.qMd) {
            com.tencent.mm.plugin.downloader_app.b.e(deleteTaskFooterView.qLZ, "checkbox_cell_on");
            AppMethodBeat.o(9011);
            return;
        }
        com.tencent.mm.plugin.downloader_app.b.e(deleteTaskFooterView.qLZ, "checkbox_cell_off");
        AppMethodBeat.o(9011);
    }

    /* access modifiers changed from: package-private */
    public final void le(boolean z) {
        AppMethodBeat.i(9012);
        if (z) {
            if (this.qMj instanceof ViewStub) {
                this.qMj = ((ViewStub) this.qMj).inflate();
                this.qMj.setVisibility(0);
            }
        } else if (!(this.qMj instanceof ViewStub)) {
            this.qMj.setVisibility(8);
        }
        if (z) {
            this.qMj.setVisibility(0);
            ((NoTaskLayout) this.qMj).setData(this.qLb);
        }
        AppMethodBeat.o(9012);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a04;
    }

    private String cCl() {
        AppMethodBeat.i(175277);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", this.gwE);
        } catch (JSONException e2) {
        }
        try {
            String encode = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(175277);
            return encode;
        } catch (UnsupportedEncodingException e3) {
            AppMethodBeat.o(175277);
            return "";
        }
    }

    private boolean cCm() {
        return this.gwE == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r1 = r8.qMm.alz(r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean a(com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.a(com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI, java.lang.String):boolean");
    }

    static /* synthetic */ void g(DownloadMainUI downloadMainUI) {
        AppMethodBeat.i(183813);
        if (downloadMainUI.gAy == null) {
            downloadMainUI.gAy = downloadMainUI.findViewById(R.id.epy);
            downloadMainUI.gAy = ((ViewStub) downloadMainUI.gAy).inflate();
        }
        downloadMainUI.gAy.setVisibility(0);
        AppMethodBeat.o(183813);
    }

    static /* synthetic */ void j(DownloadMainUI downloadMainUI) {
        AppMethodBeat.i(183814);
        if (downloadMainUI.gAy != null) {
            downloadMainUI.gAy.setVisibility(8);
        }
        AppMethodBeat.o(183814);
    }
}
