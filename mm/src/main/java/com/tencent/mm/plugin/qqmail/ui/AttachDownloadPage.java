package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.qqmail.b.a;
import com.tencent.mm.plugin.qqmail.c;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class AttachDownloadPage extends MMActivity {
    private String BqZ;
    private MMImageView BtF;
    private ImageView BtG;
    private ImageView BtH;
    private TextView BtI;
    private LinearLayout BtJ;
    private String BtK;
    private int BtL;
    private boolean BtM = false;
    private String BtN;
    private String BtO;
    private boolean BtP = true;
    private String downloadUrl;
    private TextView gCd;
    private int jpV = 0;
    private long jqG = 0;
    private TextView nUp;
    private long oJj;
    private ProgressBar progressBar;
    private Button reX;
    private int retryCount = 0;
    private Button thJ;
    private View thM;
    private long ulj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ String a(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(122883);
        String sR = attachDownloadPage.sR(false);
        AppMethodBeat.o(122883);
        return sR;
    }

    static /* synthetic */ void d(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(122885);
        attachDownloadPage.eGx();
        AppMethodBeat.o(122885);
    }

    static /* synthetic */ void f(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(122886);
        attachDownloadPage.eGy();
        AppMethodBeat.o(122886);
    }

    static /* synthetic */ void h(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(122889);
        attachDownloadPage.eGw();
        AppMethodBeat.o(122889);
    }

    static /* synthetic */ String l(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(122891);
        String eGz = attachDownloadPage.eGz();
        AppMethodBeat.o(122891);
        return eGz;
    }

    static /* synthetic */ int n(AttachDownloadPage attachDownloadPage) {
        int i2 = attachDownloadPage.retryCount;
        attachDownloadPage.retryCount = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.h_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(122868);
        super.onCreate(bundle);
        this.BtL = getIntent().getIntExtra("is_preview", 0);
        this.BtM = getIntent().getBooleanExtra("is_compress", false);
        this.BtN = getIntent().getStringExtra("attach_name");
        this.BqZ = getIntent().getStringExtra("mail_id");
        this.BtO = getIntent().getStringExtra("attach_id");
        this.downloadUrl = v.eGq() + getIntent().getStringExtra("attach_url");
        this.oJj = (long) getIntent().getIntExtra("total_size", 0);
        ((k) g.ah(k.class)).getNormalMailAppService();
        this.BtK = v.getDownloadPath();
        setMMTitle(this.BtN);
        initView();
        AppMethodBeat.o(122868);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(122869);
        super.onResume();
        AppMethodBeat.o(122869);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(122870);
        super.onPause();
        AppMethodBeat.o(122870);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(122871);
        super.onDestroy();
        ((k) g.ah(k.class)).getNormalMailAppService().cancel(this.ulj);
        AppMethodBeat.o(122871);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(122872);
        this.BtF = (MMImageView) findViewById(R.id.buq);
        this.thM = findViewById(R.id.bue);
        this.progressBar = (ProgressBar) findViewById(R.id.buc);
        this.BtG = (ImageView) findViewById(R.id.buk);
        this.BtH = (ImageView) findViewById(R.id.bui);
        this.BtI = (TextView) findViewById(R.id.va);
        this.reX = (Button) findViewById(R.id.vc);
        this.thJ = (Button) findViewById(R.id.v_);
        this.BtJ = (LinearLayout) findViewById(R.id.v9);
        this.gCd = (TextView) findViewById(R.id.vb);
        this.nUp = (TextView) findViewById(R.id.vd);
        if (FileExplorerUI.bfr(this.BtN)) {
            this.BtF.setBackgroundResource(R.raw.download_image_icon);
        } else if (FileExplorerUI.bfs(this.BtN)) {
            this.BtF.setImageResource(R.raw.app_attach_file_icon_video);
        } else {
            int bdt = r.bdt(s.akC(this.BtN));
            if (bdt > 0) {
                this.BtF.setImageResource(bdt);
            } else {
                this.BtF.setImageResource(R.raw.app_attach_file_icon_unknow);
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(122856);
                AttachDownloadPage.this.finish();
                AppMethodBeat.o(122856);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_share, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(122858);
                h.b(AttachDownloadPage.this, "", new String[]{AttachDownloadPage.this.getString(R.string.fn9)}, "", new h.d() {
                    /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(122857);
                        switch (i2) {
                            case 0:
                                AttachDownloadPage.a(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
                                break;
                        }
                        AppMethodBeat.o(122857);
                    }
                });
                AppMethodBeat.o(122858);
                return true;
            }
        });
        enableOptionMenu(false);
        eGB();
        if (this.jpV == 1) {
            eGw();
            AppMethodBeat.o(122872);
            return;
        }
        eGx();
        AppMethodBeat.o(122872);
    }

    private void eGw() {
        AppMethodBeat.i(122873);
        this.thM.setVisibility(0);
        this.reX.setVisibility(8);
        this.thJ.setVisibility(8);
        this.BtG.setVisibility(0);
        this.BtH.setVisibility(8);
        this.BtI.setVisibility(8);
        this.gCd.setVisibility(8);
        this.nUp.setVisibility(8);
        this.BtG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(122859);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AttachDownloadPage.this.jpV = 2;
                ((k) g.ah(k.class)).getNormalMailAppService().cancel(AttachDownloadPage.this.ulj);
                AttachDownloadPage.this.ulj = 0;
                AttachDownloadPage.d(AttachDownloadPage.this);
                a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122859);
            }
        });
        this.BtH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(122860);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AttachDownloadPage.this.retryCount = 0;
                AttachDownloadPage.f(AttachDownloadPage.this);
                a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122860);
            }
        });
        AppMethodBeat.o(122873);
    }

    private void eGx() {
        AppMethodBeat.i(122874);
        if (this.BtL == 1) {
            if (FileExplorerUI.bfr(this.BtN)) {
                if (this.jpV == 3) {
                    dGU();
                    AppMethodBeat.o(122874);
                    return;
                } else if (this.jpV == 0 || this.BtP) {
                    this.retryCount = 0;
                    this.BtP = false;
                    eGy();
                    eGw();
                    AppMethodBeat.o(122874);
                    return;
                }
            }
            this.thM.setVisibility(8);
            this.gCd.setVisibility(0);
            this.BtI.setVisibility(8);
            this.reX.setVisibility(0);
            this.thJ.setVisibility(8);
            this.nUp.setVisibility(0);
            this.reX.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(122861);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    AttachDownloadPage.g(AttachDownloadPage.this);
                    a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(122861);
                }
            });
            if (this.jpV == 3) {
                this.gCd.setText(R.string.eu6);
                this.nUp.setText(R.string.eu3);
                this.nUp.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(122862);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
                        a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(122862);
                    }
                });
                enableOptionMenu(true);
                AppMethodBeat.o(122874);
                return;
            }
            this.gCd.setText(R.string.eu6);
            if (this.jpV == 2) {
                this.nUp.setText(R.string.eu5);
            } else {
                this.nUp.setText(R.string.eu4);
            }
            this.nUp.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(122863);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    AttachDownloadPage.this.retryCount = 0;
                    AttachDownloadPage.f(AttachDownloadPage.this);
                    AttachDownloadPage.h(AttachDownloadPage.this);
                    a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(122863);
                }
            });
            AppMethodBeat.o(122874);
            return;
        }
        if (this.BtL == 0) {
            this.thM.setVisibility(8);
            this.reX.setVisibility(8);
            this.thJ.setVisibility(0);
            this.BtI.setVisibility(8);
            this.gCd.setVisibility(0);
            this.nUp.setVisibility(8);
            if (this.jpV == 3) {
                this.thJ.setText(R.string.eu0);
                enableOptionMenu(true);
            } else if (this.jpV == 2) {
                this.thJ.setText(R.string.eu7);
            } else {
                this.thJ.setText(R.string.etx);
            }
            this.gCd.setText(R.string.etz);
            this.thJ.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(122864);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (AttachDownloadPage.this.jpV == 3) {
                        AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
                    } else {
                        AttachDownloadPage.h(AttachDownloadPage.this);
                        AttachDownloadPage.this.retryCount = 0;
                        AttachDownloadPage.f(AttachDownloadPage.this);
                    }
                    a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(122864);
                }
            });
        }
        AppMethodBeat.o(122874);
    }

    private void dGU() {
        AppMethodBeat.i(122875);
        Intent intent = new Intent();
        intent.putExtra("key_favorite", true);
        intent.putExtra("key_favorite_source_type", 9);
        intent.putExtra("key_image_path", sR(false));
        com.tencent.mm.plugin.qqmail.a.a.jRt.d(getContext(), intent);
        finish();
        AppMethodBeat.o(122875);
    }

    private void eGy() {
        AppMethodBeat.i(122876);
        eGB();
        if (this.jpV == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                eGy();
            } else {
                eGx();
            }
        } else if (this.jpV == 3) {
            s.bo(this.BtK, eGz() + ".temp", eGz());
            this.jpV = 3;
            eGx();
        }
        String sR = sR(true);
        c.b bVar = new c.b();
        bVar.BqL = false;
        bVar.BqM = false;
        Log.i("MicroMsg.AttachDownloadPage", "download attach url %s", this.downloadUrl);
        com.tencent.mm.plugin.qqmail.b.c.a(this.downloadUrl, sR, getIntent().getStringExtra("qqmail_cookie"), new a.AbstractC1611a() {
            /* class com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.qqmail.b.a.AbstractC1611a
            public final void onProgress(int i2) {
                AppMethodBeat.i(122865);
                Log.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(i2)));
                AttachDownloadPage.j(AttachDownloadPage.this);
                AttachDownloadPage.this.jpV = 1;
                AppMethodBeat.o(122865);
            }

            @Override // com.tencent.mm.plugin.qqmail.b.a.AbstractC1611a
            public final void onResult(Bundle bundle) {
                AppMethodBeat.i(198677);
                if (bundle != null) {
                    int i2 = bundle.getInt("result_http_code", -1);
                    Log.i("MicroMsg.AttachDownloadPage", "result http code %d", Integer.valueOf(i2));
                    if (i2 == 200) {
                        s.bo(AttachDownloadPage.this.BtK, AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
                        AttachDownloadPage.this.jpV = 3;
                        Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(R.string.boa) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
                        AttachDownloadPage.d(AttachDownloadPage.this);
                        AppMethodBeat.o(198677);
                        return;
                    }
                }
                AttachDownloadPage.this.jpV = 4;
                if (AttachDownloadPage.this.retryCount < 5) {
                    AttachDownloadPage.n(AttachDownloadPage.this);
                    AttachDownloadPage.f(AttachDownloadPage.this);
                    AppMethodBeat.o(198677);
                    return;
                }
                Toast.makeText(AttachDownloadPage.this, (int) R.string.ety, 0).show();
                AttachDownloadPage.d(AttachDownloadPage.this);
                AppMethodBeat.o(198677);
            }
        });
        AppMethodBeat.o(122876);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(122877);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) this, i2, i3, intent, true, (int) R.string.bny, (int) R.string.bnz, 3);
        AppMethodBeat.o(122877);
    }

    private String eGz() {
        String str;
        AppMethodBeat.i(122878);
        int hashCode = this.BtO.hashCode() & 65535;
        int lastIndexOf = this.BtN.lastIndexOf(".");
        String str2 = "";
        if (lastIndexOf != -1) {
            str = this.BtN.substring(0, lastIndexOf);
            String str3 = this.BtN;
            str2 = str3.substring(lastIndexOf, str3.length());
        } else {
            str = this.BtN;
        }
        String format = String.format("%s_%d%s", str, Integer.valueOf(hashCode), str2);
        AppMethodBeat.o(122878);
        return format;
    }

    private String sR(boolean z) {
        AppMethodBeat.i(122879);
        String str = this.BtK + eGz() + (!z ? "" : ".temp");
        AppMethodBeat.o(122879);
        return str;
    }

    private String eGA() {
        AppMethodBeat.i(122880);
        String str = this.BtK + this.BtN;
        AppMethodBeat.o(122880);
        return str;
    }

    private void eGB() {
        AppMethodBeat.i(122881);
        if (s.YS(sR(true))) {
            this.jqG = s.boW(sR(true));
            this.jpV = 2;
            AppMethodBeat.o(122881);
        } else if (s.YS(sR(false))) {
            this.jpV = 3;
            AppMethodBeat.o(122881);
        } else if (!s.YS(eGA())) {
            this.jqG = 0;
            this.jpV = 0;
            AppMethodBeat.o(122881);
        } else if (s.boW(eGA()) == this.oJj) {
            s.bo(this.BtK, this.BtN, eGz());
            this.jpV = 3;
            AppMethodBeat.o(122881);
        } else if (s.boW(eGA()) > this.oJj) {
            s.deleteFile(eGA());
            this.jqG = 0;
            this.jpV = 4;
            AppMethodBeat.o(122881);
        } else {
            this.jqG = 0;
            this.jpV = 0;
            AppMethodBeat.o(122881);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(122882);
        super.onConfigurationChanged(configuration);
        int i2 = getResources().getConfiguration().orientation;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.BtJ.getLayoutParams();
        if (i2 == 2) {
            layoutParams.bottomMargin = at.fromDPToPix(getContext(), 60);
        } else if (i2 == 1) {
            layoutParams.bottomMargin = at.fromDPToPix(getContext(), 120);
        }
        this.BtJ.setLayoutParams(layoutParams);
        AppMethodBeat.o(122882);
    }

    static /* synthetic */ void a(AttachDownloadPage attachDownloadPage, String str) {
        AppMethodBeat.i(122884);
        cz czVar = new cz();
        String bpb = s.bpb(str);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Qqmail.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            czVar.dFZ.dGe = R.string.c_2;
        } else {
            Log.d("MicroMsg.Qqmail.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", bpb, "", str, 9);
            if (new o(str).length() > ((long) ((af) g.ah(af.class)).getFileSizeLimit(true))) {
                czVar.dFZ.dGe = R.string.fol;
            } else {
                anb anb = new anb();
                anh anh = new anh();
                aml aml = new aml();
                aml.bgt(str);
                aml.ajd(8);
                aml.bgp(s.akC(str));
                aml.At(true);
                aml.bgf(bpb);
                aml.bgg("");
                anh.bhf(z.aTY());
                anh.bhg(z.aTY());
                anh.ajm(9);
                anh.MA(Util.nowMilliSecond());
                anb.a(anh);
                anb.ppH.add(aml);
                czVar.dFZ.title = aml.title;
                czVar.dFZ.desc = aml.title;
                czVar.dFZ.dGb = anb;
                czVar.dFZ.type = 8;
            }
        }
        czVar.dFZ.activity = attachDownloadPage;
        czVar.dFZ.dGf = 6;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(122884);
    }

    static /* synthetic */ void g(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(122887);
        if (attachDownloadPage.BtM) {
            Intent intent = new Intent(attachDownloadPage.getContext(), CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.BqZ);
            intent.putExtra("attach_id", attachDownloadPage.BtO);
            intent.putExtra("attach_size", attachDownloadPage.oJj);
            intent.putExtra("attach_name", attachDownloadPage.BtN);
            AppCompatActivity context = attachDownloadPage.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage", "previewAttach", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage", "previewAttach", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(122887);
            return;
        }
        String[] strArr = {"mailid=" + attachDownloadPage.BqZ, "attachid=" + attachDownloadPage.BtO, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra(ShareConstants.MEDIA_URI, "/cgi-bin/viewdocument");
        intent2.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, strArr);
        intent2.putExtra("baseurl", v.eGq());
        intent2.putExtra(FirebaseAnalytics.b.METHOD, "get");
        intent2.putExtra("singleColumn", FileExplorerUI.bfr(attachDownloadPage.BtN));
        intent2.putExtra("title", attachDownloadPage.BtN);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(attachDownloadPage, bl2.axQ(), "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage", "previewAttach", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        attachDownloadPage.startActivity((Intent) bl2.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(attachDownloadPage, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage", "previewAttach", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(122887);
    }

    static /* synthetic */ void b(AttachDownloadPage attachDownloadPage, String str) {
        AppMethodBeat.i(122888);
        String akC = s.akC(str);
        if (!(akC == null || akC.length() == 0)) {
            com.tencent.mm.pluginsdk.ui.tools.a.b(attachDownloadPage, str, akC, 3);
        }
        AppMethodBeat.o(122888);
    }

    static /* synthetic */ void j(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(122890);
        long boW = s.boW(attachDownloadPage.sR(true));
        Log.d("MicroMsg.AttachDownloadPage", "cur download size:".concat(String.valueOf(boW)));
        attachDownloadPage.jqG = boW;
        attachDownloadPage.progressBar.setProgress((int) ((100 * boW) / attachDownloadPage.oJj));
        attachDownloadPage.BtI.setText(attachDownloadPage.getString(R.string.eu1, new Object[]{Util.getSizeKB(boW), Util.getSizeKB(attachDownloadPage.oJj)}));
        if (attachDownloadPage.jpV != 1 || attachDownloadPage.ulj == 0) {
            attachDownloadPage.BtI.setVisibility(8);
            AppMethodBeat.o(122890);
            return;
        }
        attachDownloadPage.BtI.setVisibility(0);
        AppMethodBeat.o(122890);
    }
}
