package com.tencent.mm.plugin.downloader_app.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.c.a.a.h;
import com.tencent.mm.plugin.downloader.c.a.a.l;
import com.tencent.mm.plugin.downloader.c.a.a.m;
import com.tencent.mm.plugin.downloader.c.a.a.o;
import com.tencent.mm.plugin.downloader.c.b.e;
import com.tencent.mm.plugin.downloader.c.b.k;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadSearchUI extends MMActivity implements s.b {
    private s gzP;
    private ProgressBar krF;
    private DownloadSearchListView qLI;
    private TextView qLJ;
    private String qLK;
    private boolean qLL;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(8944);
        super.onCreate(bundle);
        initView();
        a.a(13, 0, 0, 1, "", "", "");
        AppMethodBeat.o(8944);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(8945);
        super.initView();
        this.qLI = (DownloadSearchListView) findViewById(R.id.hex);
        this.krF = (ProgressBar) findViewById(R.id.heu);
        this.qLJ = (TextView) findViewById(R.id.fzz);
        this.gzP = new s();
        this.gzP.CK(true);
        this.gzP.Qwi = this;
        this.qLI.setOnItemClickListener(new MRecyclerView.a() {
            /* class com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
            public final void S(View view, int i2) {
                b bVar;
                AppMethodBeat.i(8942);
                ArrayList<b> arrayList = DownloadSearchUI.this.qLI.qLD.mDataList;
                if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                    bVar = null;
                } else {
                    bVar = arrayList.get(i2);
                }
                if (bVar == null) {
                    AppMethodBeat.o(8942);
                } else if (bVar.type == 2) {
                    DownloadSearchUI.this.qLI.alC(bVar.qLO);
                    DownloadSearchUI.this.gzP.setSearchContent(bVar.qLO);
                    a.a(13, 1302, bVar.position, 2, "", "", a.fH("search_key_word", bVar.qLO));
                    AppMethodBeat.o(8942);
                } else {
                    if (bVar.type == 3) {
                        DownloadSearchUI.this.qLI.alC(DownloadSearchUI.this.gzP.getSearchContent());
                        if (!Util.isNullOrNil(bVar.jumpUrl)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("rawUrl", bVar.jumpUrl);
                            ((c) g.af(c.class)).e(DownloadSearchUI.this.getContext(), bundle);
                        }
                        a.a(13, 1303, bVar.position, 40, bVar.appId, "", "");
                    }
                    AppMethodBeat.o(8942);
                }
            }
        });
        AppMethodBeat.o(8945);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(8946);
        this.gzP.a((FragmentActivity) this, menu);
        this.gzP.setHint(getString(R.string.bp0));
        AppMethodBeat.o(8946);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(8947);
        this.gzP.a((Activity) this, menu);
        AppMethodBeat.o(8947);
        return true;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
        AppMethodBeat.i(8948);
        Log.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
        AppMethodBeat.o(8948);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        AppMethodBeat.i(8949);
        Log.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
        hideVKB();
        onBackPressed();
        AppMethodBeat.o(8949);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(final String str) {
        AppMethodBeat.i(8950);
        Log.i("MicroMsg.DownloadSearchUI", "onSearchChange");
        this.qLJ.setVisibility(8);
        if (this.qLK == null || !this.qLK.equals(Util.nullAsNil(str))) {
            this.qLK = str;
            if (Util.isNullOrNil(str)) {
                this.krF.setVisibility(8);
                DownloadSearchListView downloadSearchListView = this.qLI;
                downloadSearchListView.setVisibility(0);
                if (Util.isNullOrNil(downloadSearchListView.qLE)) {
                    downloadSearchListView.qLE = b.eX(downloadSearchListView.mContext);
                }
                downloadSearchListView.setData(downloadSearchListView.qLE);
                this.qLL = true;
                AppMethodBeat.o(8950);
                return;
            }
            this.qLI.setData(null);
            this.qLL = false;
            this.qLI.setData(null);
            this.krF.setVisibility(0);
            d.a aVar = new d.a();
            l lVar = new l();
            lVar.qGc = str;
            o oVar = new o();
            oVar.offset = 0;
            oVar.limit = 5;
            lVar.qGd = oVar;
            aVar.iLN = lVar;
            aVar.iLO = new m();
            aVar.uri = "/cgi-bin/mmgame-bin/getgamesearch";
            aVar.funcId = 2688;
            aa.a(aVar.aXF(), new aa.a() {
                /* class com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI.AnonymousClass2 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    b bVar;
                    int i4;
                    AppMethodBeat.i(8943);
                    Log.i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (DownloadSearchUI.this.qLL || DownloadSearchUI.this.isFinishing()) {
                        AppMethodBeat.o(8943);
                        return 0;
                    }
                    DownloadSearchUI.this.krF.setVisibility(8);
                    if (i2 == 0 && i3 == 0) {
                        m mVar = (m) dVar.iLL.iLR;
                        if (mVar == null || mVar.qGf == null || Util.isNullOrNil(mVar.qGf.qFY)) {
                            DownloadSearchUI.this.qLI.setVisibility(8);
                            DownloadSearchUI.this.qLJ.setVisibility(0);
                            DownloadSearchUI.this.qLJ.setText(DownloadSearchUI.this.getString(R.string.boy, new Object[]{str}));
                            a.a(13, 1304, 0, 1, "", "", "");
                        } else {
                            ArrayList arrayList = new ArrayList();
                            int i5 = 0;
                            Iterator<h> it = mVar.qGf.qFY.iterator();
                            while (it.hasNext()) {
                                h next = it.next();
                                String str2 = str;
                                if (next == null) {
                                    bVar = null;
                                } else {
                                    bVar = new b();
                                    bVar.type = 3;
                                    com.tencent.mm.plugin.downloader.c.a.a.d dVar2 = next.qFW;
                                    if (dVar2 == null) {
                                        bVar = null;
                                    } else {
                                        k kVar = dVar2.qFP;
                                        com.tencent.mm.plugin.downloader.c.a.a.c cVar = dVar2.qFR;
                                        if (cVar != null) {
                                            bVar.jumpUrl = cVar.qFO;
                                        }
                                        if (kVar == null) {
                                            bVar = null;
                                        } else {
                                            com.tencent.mm.plugin.downloader.c.b.d dVar3 = kVar.qGY;
                                            e eVar = kVar.qGZ;
                                            com.tencent.mm.plugin.downloader.c.b.g gVar = kVar.qHa;
                                            if (dVar3 == null) {
                                                bVar = null;
                                            } else if (dVar3.status != 0) {
                                                bVar = null;
                                            } else {
                                                bVar.appId = dVar3.dNI;
                                                bVar.qLP = next.qFX;
                                                bVar.iconUrl = dVar3.qGB;
                                                if (eVar != null && !Util.isNullOrNil(eVar.qGH)) {
                                                    bVar.qLQ = eVar.qGH;
                                                }
                                                if (!(gVar == null || gVar.qGP == null)) {
                                                    bVar.size = gVar.qGP.qGq;
                                                }
                                                bVar.qLO = str2;
                                                bVar.state = 1;
                                                if (!(gVar == null || gVar.qGP == null)) {
                                                    PackageInfo packageInfo = b.getPackageInfo(MMApplicationContext.getContext(), gVar.qGP.qGp);
                                                    com.tencent.mm.plugin.downloader.g.a alb = com.tencent.mm.plugin.downloader.model.d.alb(bVar.appId);
                                                    if (packageInfo == null) {
                                                        if (alb != null && alb.field_status == 3 && com.tencent.mm.vfs.s.YS(alb.field_filePath)) {
                                                            bVar.state = 4;
                                                        }
                                                    } else if (packageInfo.versionCode < gVar.qGP.qGt) {
                                                        bVar.state = 3;
                                                    } else {
                                                        bVar.state = 2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (bVar != null) {
                                    i4 = i5 + 1;
                                    bVar.position = i4;
                                    arrayList.add(bVar);
                                } else {
                                    i4 = i5;
                                }
                                i5 = i4;
                            }
                            DownloadSearchUI.this.qLJ.setVisibility(8);
                            DownloadSearchListView downloadSearchListView = DownloadSearchUI.this.qLI;
                            downloadSearchListView.setVisibility(0);
                            downloadSearchListView.qLF.clear();
                            if (!Util.isNullOrNil(arrayList)) {
                                downloadSearchListView.qLF.addAll(arrayList);
                            }
                            downloadSearchListView.setData(downloadSearchListView.qLF);
                            a.a(13, 1303, 0, 1, "", "", "");
                        }
                    }
                    AppMethodBeat.o(8943);
                    return 0;
                }
            });
            a.a(13, 1301, 1, 2, "", "", a.fH("search_key_word", str));
            AppMethodBeat.o(8950);
            return;
        }
        Log.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
        AppMethodBeat.o(8950);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        AppMethodBeat.i(8951);
        Log.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(8951);
        } else {
            this.qLI.alC(str);
            AppMethodBeat.o(8951);
        }
        return true;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
        AppMethodBeat.i(8952);
        Log.i("MicroMsg.DownloadSearchUI", "onClickClearText");
        a.a(13, 1301, 2, 81, "", "", "");
        AppMethodBeat.o(8952);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
        AppMethodBeat.i(8953);
        Log.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
        AppMethodBeat.o(8953);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a06;
    }
}
