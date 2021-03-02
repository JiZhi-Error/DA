package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.s;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.f;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ArtistUI extends MMActivity implements i {
    private f Eoc;
    private ArtistHeader Eod;
    private q Eoe = null;
    g Eof = aj.faL();
    c Eog = aj.faJ();
    private Runnable Eoh = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.ArtistUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(97738);
            if (ArtistUI.this.Eoc == null) {
                AppMethodBeat.o(97738);
                return;
            }
            Log.d("MicroMsg.ArtistUI", "will pause ImageLoader");
            aj.faL().pause();
            AppMethodBeat.o(97738);
        }
    };
    private Runnable Eoi = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.ArtistUI.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(97739);
            if (ArtistUI.this.Eoc == null) {
                AppMethodBeat.o(97739);
                return;
            }
            Log.d("MicroMsg.ArtistUI", "will start ImageLoader");
            aj.faL().start();
            ArtistUI.this.Eoc.notifyDataSetChanged();
            AppMethodBeat.o(97739);
        }
    };
    MMHandler czp = aj.dRd();
    private ListView krb;
    private SharedPreferences sp;
    private com.tencent.mm.ui.base.q tipDialog = null;
    private String yFy = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ArtistUI() {
        AppMethodBeat.i(97746);
        AppMethodBeat.o(97746);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(97747);
        super.onCreate(bundle);
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
        Log.d("MicroMsg.ArtistUI", "filterLan temp ".concat(String.valueOf(loadApplicationLanguage)));
        if (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.ENGLISH) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN)) {
            loadApplicationLanguage = loadApplicationLanguage.equals(LocaleUtil.HONGKONG) ? LocaleUtil.TAIWAN : LocaleUtil.ENGLISH;
        }
        this.yFy = loadApplicationLanguage;
        Log.d("MicroMsg.ArtistUI", "lan " + this.yFy);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        this.sp = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        initView();
        aj.faJ().a(this.Eod);
        AppMethodBeat.o(97747);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(97748);
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog = null;
        }
        if (this.Eod != null) {
            aj.faJ().b(this.Eod);
        }
        aj.faL().aI(this);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        AppMethodBeat.o(97748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(97749);
        super.onResume();
        AppMethodBeat.o(97749);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(97750);
        super.onPause();
        AppMethodBeat.o(97750);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(97751);
        setMMTitle(R.string.gua);
        setActionbarColor(getResources().getColor(R.color.a8r));
        setNavigationbarColor(getResources().getColor(R.color.a8r));
        getString(R.string.zb);
        this.tipDialog = h.a((Context) this, getString(R.string.wd), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.krb = (ListView) findViewById(R.id.hwo);
        a.jRu.cR(false);
        this.Eoc = new f(this, this.yFy, new f.b() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sns.ui.f.b
            public final void Zt(int i2) {
                AppMethodBeat.i(97740);
                Intent intent = new Intent();
                intent.putExtra("sns_gallery_is_artist", true);
                intent.putExtra("sns_gallery_position", i2);
                intent.putExtra("sns_gallery_artist_lan", ArtistUI.this.yFy);
                intent.putExtra("sns_gallery_showtype", 2);
                intent.putExtra("key_from_scene", 6);
                intent.setClass(ArtistUI.this, ArtistBrowseUI.class);
                ArtistUI artistUI = ArtistUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(artistUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                artistUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(artistUI, "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(97740);
            }
        }, new f.a() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.sns.ui.f.a
            public final void a(he heVar) {
                AppMethodBeat.i(97741);
                if (ArtistUI.this.Eod != null) {
                    ArtistUI.this.Eod.setVisibility(0);
                    ArtistUI.this.Eod.setUserName(heVar);
                    String str = heVar.Name;
                    if (str != null && !str.equals("")) {
                        ArtistUI.this.sp.edit().putString("artist_name", str).commit();
                    }
                    if (ArtistUI.this.Eoc != null) {
                        ArtistUI.this.Eoc.notifyDataSetChanged();
                    }
                }
                ArtistUI.this.tipDialog.dismiss();
                AppMethodBeat.o(97741);
            }

            @Override // com.tencent.mm.plugin.sns.ui.f.a
            public final void b(he heVar) {
                AppMethodBeat.i(97742);
                if (ArtistUI.this.Eod != null) {
                    ArtistUI.this.Eod.setVisibility(0);
                    ArtistUI.this.Eod.setUserName(heVar);
                }
                AppMethodBeat.o(97742);
            }

            @Override // com.tencent.mm.plugin.sns.ui.f.a
            public final void ffj() {
                AppMethodBeat.i(97743);
                if (ArtistUI.this.Eoe == null && ArtistUI.this.tipDialog != null) {
                    Log.d("MicroMsg.ArtistUI", "onNothingBgGet");
                    a.jRu.cR(true);
                }
                AppMethodBeat.o(97743);
            }
        });
        this.krb.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistUI.AnonymousClass6 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(97744);
                if (i2 == 2) {
                    if (ArtistUI.this.Eof.DGJ || ArtistUI.this.Eog.DGJ) {
                        ArtistUI.this.czp.removeCallbacks(ArtistUI.this.Eoh);
                        ArtistUI.this.czp.removeCallbacks(ArtistUI.this.Eoi);
                        ArtistUI.this.czp.postDelayed(ArtistUI.this.Eoh, 0);
                        AppMethodBeat.o(97744);
                        return;
                    }
                } else if (!ArtistUI.this.Eof.DGJ || !ArtistUI.this.Eog.DGJ) {
                    ArtistUI.this.czp.removeCallbacks(ArtistUI.this.Eoh);
                    ArtistUI.this.czp.removeCallbacks(ArtistUI.this.Eoi);
                    ArtistUI.this.czp.postDelayed(ArtistUI.this.Eoi, 0);
                } else {
                    AppMethodBeat.o(97744);
                    return;
                }
                AppMethodBeat.o(97744);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.Eod = new ArtistHeader(this);
        this.krb.addHeaderView(this.Eod);
        this.krb.setAdapter((ListAdapter) this.Eoc);
        this.Eoc.notifyDataSetChanged();
        this.Eod.setVisibility(8);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(97745);
                ArtistUI.this.finish();
                AppMethodBeat.o(97745);
                return true;
            }
        });
        AppMethodBeat.o(97751);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bva;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(97752);
        if (!(qVar instanceof s) || ((s) qVar).aYR() != 4) {
            Log.d("MicroMsg.ArtistUI", "another scene");
            AppMethodBeat.o(97752);
            return;
        }
        Log.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType() + " @" + hashCode());
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case JsApiGetBackgroundAudioState.CTRL_INDEX:
                    if (this.Eoc != null) {
                        this.Eoc.anp();
                    }
                    this.Eoe = null;
                    break;
            }
            AppMethodBeat.o(97752);
            return;
        }
        if (qVar.getType() == 159 && this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(97752);
    }
}
