package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.c;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.g.a;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public class FavoriteFileDetailUI extends BaseFavDetailReportUI implements p, MStorage.IOnStorageChange {
    private static final long thH = ((long) c.aqr());
    private a RbU;
    private com.tencent.mm.plugin.fav.ui.e.a RbV;
    private long dFW;
    private aml dKT;
    private boolean dUo = true;
    private MMHandler hAk;
    private TextView kgE;
    private TextView nnM;
    private int ppd;
    private int ppe;
    private com.tencent.mm.ui.widget.b.a pqr = null;
    private ProgressBar progressBar;
    private TextView progressTips;
    private j qbJ = null;
    private o.g rJj = new o.g() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass18 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            AppMethodBeat.i(107137);
            if (Util.isNullOrNil(FavoriteFileDetailUI.this.dKT.title)) {
                str = FavoriteFileDetailUI.this.getString(R.string.fiv);
            } else {
                str = FavoriteFileDetailUI.this.dKT.title;
            }
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, str);
            h.cD(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(R.string.ta));
            AppMethodBeat.o(107137);
        }
    };
    private Button reX;
    private g tbr;
    private k tfE = new k();
    private Button thI;
    private Button thJ;
    private MMImageView thK;
    private View thM;
    private View thN;
    private TextView thO;
    private ImageView thP;
    private TextView thQ;
    private boolean thR = false;
    private boolean thS = false;
    private String thT;
    private String thU;
    private boolean thV = false;
    private boolean thW = false;
    private boolean thX = false;
    private HandOffFile thY;
    private View.OnTouchListener tia = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass2 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(107115);
            switch (motionEvent.getAction()) {
                case 0:
                    FavoriteFileDetailUI.this.ppd = (int) motionEvent.getRawX();
                    FavoriteFileDetailUI.this.ppe = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(107115);
            return false;
        }
    };
    private View.OnLongClickListener tib = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass3 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(107116);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
            if (FavoriteFileDetailUI.this.pqr == null) {
                FavoriteFileDetailUI.this.pqr = new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.cWv());
            }
            FavoriteFileDetailUI.this.pqr.a(view, FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.rJj, FavoriteFileDetailUI.this.ppd, FavoriteFileDetailUI.this.ppe);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107116);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteFileDetailUI() {
        AppMethodBeat.i(107138);
        AppMethodBeat.o(107138);
    }

    static /* synthetic */ int e(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(261611);
        int type = favoriteFileDetailUI.getType();
        AppMethodBeat.o(261611);
        return type;
    }

    static /* synthetic */ void g(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(261612);
        favoriteFileDetailUI.bLd();
        AppMethodBeat.o(261612);
    }

    static /* synthetic */ void i(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(261614);
        favoriteFileDetailUI.cWx();
        AppMethodBeat.o(261614);
    }

    static /* synthetic */ void k(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(261615);
        favoriteFileDetailUI.cWy();
        AppMethodBeat.o(261615);
    }

    static /* synthetic */ void y(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(261619);
        favoriteFileDetailUI.mF(true);
        AppMethodBeat.o(261619);
    }

    static {
        AppMethodBeat.i(235332);
        AppMethodBeat.o(235332);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a89;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void cWu() {
        AppMethodBeat.i(107139);
        this.thU = getIntent().getStringExtra("key_detail_data_id");
        Iterator<aml> it = this.tbr.field_favProto.ppH.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            aml next = it.next();
            if (next.dLl.equals(this.thU)) {
                this.dKT = next;
                break;
            }
        }
        if (this.dKT == null) {
            this.dKT = com.tencent.mm.plugin.fav.a.b.c(this.tbr);
        }
        AppMethodBeat.o(107139);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        final boolean z;
        AppMethodBeat.i(107140);
        super.onCreate(bundle);
        this.hAk = new MMHandler();
        this.dFW = getIntent().getLongExtra("key_detail_info_id", -1);
        this.thS = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        this.dUo = getIntent().getBooleanExtra("show_share", true);
        this.thT = getIntent().getStringExtra("fav_note_xml");
        this.tbr = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.dFW);
        if (this.thS && !Util.isNullOrNil(this.thT)) {
            this.tbr = com.tencent.mm.plugin.fav.a.b.arO(this.thT);
        }
        if (this.tbr == null) {
            Log.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
            finish();
            AppMethodBeat.o(107140);
            return;
        }
        H(this.tbr);
        m.x(this.tbr);
        cWu();
        this.reX = (Button) findViewById(R.id.ggf);
        this.thI = (Button) findViewById(R.id.g48);
        this.thJ = (Button) findViewById(R.id.bto);
        this.thK = (MMImageView) findViewById(R.id.dtx);
        this.kgE = (TextView) findViewById(R.id.fti);
        this.nnM = (TextView) findViewById(R.id.ipe);
        this.thN = findViewById(R.id.buk);
        this.thM = findViewById(R.id.bue);
        this.progressBar = (ProgressBar) findViewById(R.id.buc);
        this.progressTips = (TextView) findViewById(R.id.bug);
        this.thO = (TextView) findViewById(R.id.hqu);
        this.thP = (ImageView) findViewById(R.id.cby);
        this.thQ = (TextView) findViewById(R.id.cbz);
        this.kgE.setOnTouchListener(this.tia);
        this.kgE.setOnLongClickListener(this.tib);
        int type = getType();
        if (4 == type) {
            setMMTitle(R.string.cd1);
        } else if (15 == type) {
            setMMTitle(R.string.cd1);
            findViewById(R.id.j44).setBackgroundResource(R.color.fm);
            this.kgE.setVisibility(8);
        } else {
            setMMTitle(R.string.c_k);
        }
        if (this.dKT.dataType == 4) {
            this.thK.setImageResource(R.raw.app_attach_file_icon_video);
        } else {
            this.thK.setImageResource(((ab) com.tencent.mm.kernel.g.af(ab.class)).asd(this.dKT.LvC));
        }
        this.kgE.setText(this.dKT.title);
        amo amo = this.dKT.Lwn;
        if (amo == null) {
            this.thO.setVisibility(8);
        } else if (Util.isNullOrNil(amo.iyZ)) {
            Log.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
            String str = amo.izc;
            final String str2 = amo.izd;
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                this.thO.setVisibility(8);
            } else {
                this.thO.setText(str);
                this.thO.setVisibility(0);
                this.thO.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(107114);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        final Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.this.dKT.ean);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("useJs", true);
                        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(107113);
                                com.tencent.mm.br.c.b(FavoriteFileDetailUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                FavoriteFileDetailUI.this.finish();
                                AppMethodBeat.o(107113);
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107114);
                    }
                });
            }
        } else {
            String string = getResources().getString(R.string.h4h);
            if (amo.LxJ / 60 > 0) {
                string = string + getResources().getString(R.string.h4j, Integer.valueOf(amo.LxJ / 60));
            }
            if (amo.LxJ % 60 > 0) {
                string = string + getResources().getString(R.string.h4k, Integer.valueOf(amo.LxJ % 60));
            }
            this.thO.setText(string + getResources().getString(R.string.h4i));
            this.thO.setVisibility(0);
            this.thO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107125);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m.a(m.a.EnterCompleteVideo, FavoriteFileDetailUI.this.tbr);
                    amo amo = FavoriteFileDetailUI.this.dKT.Lwn;
                    String a2 = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.this.dKT);
                    Intent intent = new Intent();
                    intent.putExtra("KFromTimeLine", false);
                    intent.putExtra("KStremVideoUrl", amo.iyZ);
                    intent.putExtra("StreamWording", amo.izc);
                    intent.putExtra("StremWebUrl", amo.izd);
                    intent.putExtra("KBlockFav", true);
                    intent.putExtra("KThumUrl", amo.ize);
                    intent.putExtra("KThumbPath", a2);
                    intent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.this.tbr.field_id);
                    intent.putExtra("KMediaVideoTime", amo.LxJ);
                    intent.putExtra("KMediaTitle", FavoriteFileDetailUI.this.dKT.title);
                    intent.putExtra("KSta_StremVideoAduxInfo", amo.izf);
                    intent.putExtra("KSta_StremVideoPublishId", amo.izg);
                    intent.putExtra("KSta_SourceType", 1);
                    intent.putExtra("KSta_Scene", m.b.Fav.value);
                    intent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.this.tbr.field_fromUser);
                    intent.putExtra("KSta_FavID", FavoriteFileDetailUI.this.tbr.field_id);
                    intent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.this.dKT.ean);
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0) > 0) {
                        com.tencent.mm.br.c.b(FavoriteFileDetailUI.this, "sns", ".ui.SnsAdStreamVideoPlayUI", intent);
                        Log.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
                    } else {
                        com.tencent.mm.br.c.b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107125);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107126);
                m.a(m.a.LeavelFullScreen, FavoriteFileDetailUI.this.tbr);
                if (FavoriteFileDetailUI.this.RbV != null && FavoriteFileDetailUI.this.RbV.O(1, false)) {
                    AppMethodBeat.o(107126);
                } else if (FavoriteFileDetailUI.this.RbU == null || !FavoriteFileDetailUI.this.RbU.wu(1)) {
                    FavoriteFileDetailUI.this.finish();
                    AppMethodBeat.o(107126);
                } else {
                    AppMethodBeat.o(107126);
                }
                return true;
            }
        });
        this.thI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(107127);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String d2 = com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.this.dKT);
                if (4 == FavoriteFileDetailUI.e(FavoriteFileDetailUI.this)) {
                    FavoriteFileDetailUI.this.thV = false;
                    FavoriteFileDetailUI.g(FavoriteFileDetailUI.this);
                } else {
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, d2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107127);
            }
        });
        final String str3 = this.dKT.Lvu;
        if (!Util.isNullOrNil(str3)) {
            this.reX.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass14 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107128);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", Integer.valueOf(FavoriteFileDetailUI.this.tbr.field_id), Long.valueOf(FavoriteFileDetailUI.this.tbr.field_localId));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", FavoriteFileDetailUI.this.tbr.field_localId);
                    intent.putExtra("geta8key_scene", 14);
                    intent.putExtra("geta8key_scene", 14);
                    com.tencent.mm.br.c.b(FavoriteFileDetailUI.this.cWv(), "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107128);
                }
            });
        }
        this.thJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(107129);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(FavoriteFileDetailUI.this.tbr.field_id), Long.valueOf(FavoriteFileDetailUI.this.tbr.field_localId), Integer.valueOf(FavoriteFileDetailUI.this.tbr.field_itemStatus));
                if (!e.apn()) {
                    h.n(FavoriteFileDetailUI.this.cWv(), R.string.cad, R.string.c8z);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107129);
                    return;
                }
                if (FavoriteFileDetailUI.this.tbr.cUy() || Util.isNullOrNil(FavoriteFileDetailUI.this.dKT.KuR)) {
                    com.tencent.mm.plugin.fav.a.b.l(FavoriteFileDetailUI.this.tbr);
                } else if (!FavoriteFileDetailUI.this.thS) {
                    com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.this.tbr, FavoriteFileDetailUI.this.dKT, true);
                } else {
                    FavoriteFileDetailUI.this.tbr.field_itemStatus = 7;
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.dKT, 18, -1);
                }
                FavoriteFileDetailUI.i(FavoriteFileDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107129);
            }
        });
        this.thN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(107130);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FavoriteFileDetailUI.this.tbr.isDownloading()) {
                    com.tencent.mm.plugin.fav.a.b.e(FavoriteFileDetailUI.this.dKT);
                    FavoriteFileDetailUI.this.thJ.setText(R.string.ca1);
                } else {
                    com.tencent.mm.plugin.fav.a.b.n(FavoriteFileDetailUI.this.tbr);
                    FavoriteFileDetailUI.this.thJ.setText(R.string.ca2);
                }
                FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107130);
            }
        });
        if (this.dUo) {
            final boolean booleanExtra = getIntent().getBooleanExtra("key_detail_can_delete", true);
            final int type2 = getType();
            if (type2 == 8) {
                z = this.tbr.cUu();
            } else if (type2 == 15) {
                z = this.tbr.cUu() && Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTCannotTransmitForFav")) == 0;
            } else {
                z = this.tbr.cUv() || this.tbr.cUu();
            }
            if (z || booleanExtra) {
                addIconOptionMenu(0, R.string.hp_, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass17 */

                    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
                        if (r5.tie.dKT.Lwv == 0) goto L_0x002f;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final boolean onMenuItemClick(android.view.MenuItem r6) {
                        /*
                            r5 = this;
                            r1 = 1
                            r0 = 0
                            r4 = 107136(0x1a280, float:1.5013E-40)
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                            boolean r2 = r0
                            if (r2 == 0) goto L_0x0027
                            com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI r2 = com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.this
                            com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.l(r2)
                            com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI r2 = com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.this
                            com.tencent.mm.protocal.protobuf.aml r2 = com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.a(r2)
                            boolean r2 = com.tencent.mm.plugin.fav.a.k.i(r2)
                            if (r2 != 0) goto L_0x0027
                            com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI r2 = com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.this
                            com.tencent.mm.protocal.protobuf.aml r2 = com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.a(r2)
                            int r2 = r2.Lwv
                            if (r2 == 0) goto L_0x002f
                        L_0x0027:
                            boolean r2 = r3
                            if (r2 != 0) goto L_0x002f
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                        L_0x002e:
                            return r0
                        L_0x002f:
                            com.tencent.mm.ui.widget.a.e r2 = new com.tencent.mm.ui.widget.a.e
                            com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI r3 = com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.this
                            com.tencent.mm.ui.MMActivity r3 = r3.cWv()
                            r2.<init>(r3, r1, r0)
                            com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$17$1 r0 = new com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$17$1
                            r0.<init>()
                            r2.HLX = r0
                            com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$17$2 r0 = new com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$17$2
                            r0.<init>()
                            r2.HLY = r0
                            r2.dGm()
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                            r0 = r1
                            goto L_0x002e
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass17.onMenuItemClick(android.view.MenuItem):boolean");
                    }
                });
            }
        }
        String str4 = null;
        if (this.tbr != null) {
            str4 = String.valueOf(this.tbr.field_id);
        }
        this.thY = HandOffFile.fromFavItem(this.dKT, str4, null, com.tencent.mm.plugin.fav.a.b.d(this.dKT));
        if (com.tencent.mm.plugin.fav.a.b.g(this.dKT)) {
            this.thY.setFileStatus(1);
        } else if (Util.isNullOrNil(this.dKT.KuR)) {
            this.thY.setFileStatus(3);
        } else {
            this.thY.setFileStatus(2);
        }
        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).c(this.thY);
        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.thY);
        mF(false);
        if (getType() == 8) {
            String d2 = com.tencent.mm.plugin.fav.a.b.d(this.dKT);
            boolean YS = s.YS(d2);
            if (YS) {
                this.RbU = new a(new com.tencent.mm.plugin.fav.ui.g.b((MMActivity) super.getContext()));
                this.RbU.gH(d2, this.dKT.LvC);
                a aVar = this.RbU;
                String str5 = this.dKT.LvC;
                String str6 = this.dKT.title;
                Integer agX = d.agX(str5);
                if (agX == null) {
                    agX = d.agX("unknown");
                }
                aVar.oWE.noe = agX.intValue();
                aVar.oWE.name = str6;
                aVar.cit();
                this.RbV = new com.tencent.mm.plugin.fav.ui.e.a(new com.tencent.mm.plugin.multitask.a.b((MMActivity) super.getContext()));
                this.RbV.gH(d2, this.dKT.LvC);
                com.tencent.mm.plugin.fav.ui.e.a aVar2 = this.RbV;
                String str7 = this.dKT.LvC;
                String str8 = this.dKT.title;
                MultiTaskInfo multiTaskInfo = aVar2.Abp;
                multiTaskInfo.erh().title = str8;
                multiTaskInfo.erh().gCr = str7;
                aVar2.eqX();
                this.thY.saveToMultiTaskInfo(this.RbV.Abp);
            }
            Log.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", Boolean.valueOf(YS));
        }
        AppMethodBeat.o(107140);
    }

    public final MMActivity cWv() {
        AppMethodBeat.i(261610);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.o(261610);
        return mMActivity;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(107142);
        Log.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", Integer.valueOf(i2));
        if (i2 == 4 && this.RbV != null && this.RbV.O(2, false)) {
            AppMethodBeat.o(107142);
            return true;
        } else if (i2 != 4 || this.RbU == null || !this.RbU.wu(2)) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(107142);
            return onKeyDown;
        } else {
            AppMethodBeat.o(107142);
            return true;
        }
    }

    private int getType() {
        AppMethodBeat.i(107143);
        if (this.dKT == null) {
            Log.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
            AppMethodBeat.o(107143);
            return 8;
        } else if (this.dKT.dataType == 0) {
            Log.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", Integer.valueOf(this.tbr.field_type));
            if (4 == this.tbr.field_type) {
                AppMethodBeat.o(107143);
                return 4;
            } else if (16 == this.tbr.field_type) {
                if (!(this.dKT == null || this.dKT.Lwn == null)) {
                    if (!Util.isNullOrNil(this.dKT.Lwn.iyZ)) {
                        AppMethodBeat.o(107143);
                        return 15;
                    } else if (!Util.isNullOrNil(this.dKT.Lwn.izd)) {
                        AppMethodBeat.o(107143);
                        return 15;
                    }
                }
                AppMethodBeat.o(107143);
                return 4;
            } else {
                AppMethodBeat.o(107143);
                return 8;
            }
        } else if (this.dKT.dataType == 15) {
            if (!(this.dKT == null || this.dKT.Lwn == null)) {
                if (!Util.isNullOrNil(this.dKT.Lwn.iyZ)) {
                    AppMethodBeat.o(107143);
                    return 15;
                } else if (!Util.isNullOrNil(this.dKT.Lwn.izd)) {
                    AppMethodBeat.o(107143);
                    return 15;
                }
            }
            AppMethodBeat.o(107143);
            return 4;
        } else {
            int i2 = this.dKT.dataType;
            AppMethodBeat.o(107143);
            return i2;
        }
    }

    private void mF(boolean z) {
        AppMethodBeat.i(107144);
        boolean g2 = com.tencent.mm.plugin.fav.a.b.g(this.dKT);
        Log.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", Integer.valueOf(this.tbr.field_itemStatus), Boolean.valueOf(g2), com.tencent.mm.plugin.fav.a.b.d(this.dKT));
        if (this.dKT.Lwv != 0) {
            cWw();
            AppMethodBeat.o(107144);
        } else if (!this.tbr.isDone() && !g2 && Util.isNullOrNil(this.dKT.KuR)) {
            if (this.tbr.cUz()) {
                if (Util.isNullOrNil(this.dKT.KuR)) {
                    cWw();
                    if (z) {
                        int type = getType();
                        h.cD((MMActivity) super.getContext(), getString((4 == type || 15 == type) ? R.string.cbl : R.string.cb8));
                        AppMethodBeat.o(107144);
                        return;
                    }
                } else {
                    cWy();
                    if (z) {
                        h.cD((MMActivity) super.getContext(), getString(R.string.bnp));
                        AppMethodBeat.o(107144);
                        return;
                    }
                }
            } else if (this.tbr.cUy()) {
                cWy();
                if (z) {
                    h.cD((MMActivity) super.getContext(), getString(R.string.c8y));
                    AppMethodBeat.o(107144);
                    return;
                }
            } else if (this.tbr.isDownloading() || this.tbr.cUx()) {
                cWx();
                AppMethodBeat.o(107144);
                return;
            } else {
                Log.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                cWy();
            }
            AppMethodBeat.o(107144);
        } else if (g2) {
            cWA();
            int intExtra = getIntent().getIntExtra("key_detail_open_way", 0);
            if (Util.isEqual(intExtra, 1)) {
                and and = new and();
                and.ecL = 2;
                ((y) com.tencent.mm.kernel.g.af(y.class)).a((MMActivity) super.getContext(), this.tbr, and);
                AppMethodBeat.o(107144);
                return;
            }
            if (Util.isEqual(intExtra, 2)) {
                and and2 = new and();
                and2.ecL = 2;
                if (this.dKT.dataType != 8 || !Util.isEqual(this.dKT.dLl, this.thU)) {
                    ((y) com.tencent.mm.kernel.g.af(y.class)).a((MMActivity) super.getContext(), this.tbr, and2);
                } else {
                    g cUC = this.tbr.cUC();
                    cUC.field_type = 8;
                    cUC.tad = true;
                    cUC.tae = this.tbr;
                    cUC.dLb = this.tbr.field_localId + "_" + this.thU;
                    cUC.taf = this.thU;
                    cUC.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.tbr.field_favProto);
                    cUC.field_favProto.ppH = new LinkedList<>();
                    cUC.field_favProto.ppH.add(this.dKT);
                    cUC.field_favProto.bhd(this.dKT.title);
                    ((y) com.tencent.mm.kernel.g.af(y.class)).a((MMActivity) super.getContext(), cUC, and2);
                    AppMethodBeat.o(107144);
                    return;
                }
            }
            AppMethodBeat.o(107144);
        } else if (Util.isNullOrNil(this.dKT.KuR)) {
            cWw();
            AppMethodBeat.o(107144);
        } else {
            Log.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
            cWy();
            AppMethodBeat.o(107144);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(107145);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.t_));
        AppMethodBeat.o(107145);
    }

    private void cWw() {
        AppMethodBeat.i(107146);
        this.thK.setVisibility(8);
        this.kgE.setVisibility(8);
        this.thJ.setVisibility(8);
        this.reX.setVisibility(8);
        this.thI.setVisibility(8);
        this.thM.setVisibility(8);
        this.nnM.setVisibility(8);
        this.thP.setVisibility(0);
        this.thQ.setVisibility(0);
        if (this.dKT.dataType == 4) {
            this.nnM.setGravity(17);
            this.nnM.setText(R.string.cak);
            AppMethodBeat.o(107146);
            return;
        }
        this.nnM.setGravity(17);
        this.nnM.setText(R.string.caj);
        if (this.dKT.Lwv == 2) {
            this.thQ.setText(R.string.c9b);
            AppMethodBeat.o(107146);
            return;
        }
        this.thQ.setText(R.string.c9c);
        AppMethodBeat.o(107146);
    }

    private void cWx() {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(107147);
        this.thJ.setVisibility(8);
        this.reX.setVisibility(8);
        this.thI.setVisibility(8);
        this.nnM.setVisibility(8);
        this.thM.setVisibility(0);
        com.tencent.mm.plugin.fav.a.c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
        if (asa != null) {
            i4 = (int) asa.getProgress();
            i3 = asa.field_offset;
            i2 = asa.field_totalLen;
        } else {
            i2 = (int) this.dKT.LvI;
            i3 = 0;
            i4 = 0;
        }
        if (!this.tbr.cUx() || !Util.isNullOrNil(this.dKT.KuR)) {
            b((float) i4, getString(R.string.c9p, new Object[]{com.tencent.mm.plugin.fav.a.b.getLengthStr((float) i3), com.tencent.mm.plugin.fav.a.b.getLengthStr((float) i2)}));
            AppMethodBeat.o(107147);
            return;
        }
        b((float) i4, getString(R.string.ccz, new Object[]{com.tencent.mm.plugin.fav.a.b.getLengthStr((float) i3), com.tencent.mm.plugin.fav.a.b.getLengthStr((float) i2)}));
        AppMethodBeat.o(107147);
    }

    private void cWy() {
        AppMethodBeat.i(107148);
        this.thM.setVisibility(8);
        this.thI.setVisibility(8);
        if (Util.isNullOrNil(this.dKT.Lvu)) {
            this.reX.setVisibility(8);
        } else {
            this.reX.setVisibility(0);
        }
        this.thJ.setVisibility(0);
        com.tencent.mm.plugin.fav.a.c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
        if (asa == null || asa.field_offset <= 0) {
            this.thJ.setText(this.tbr.cUy() ? R.string.ca3 : R.string.c_y);
        } else {
            this.thJ.setText(this.tbr.cUy() ? R.string.ca2 : R.string.ca1);
        }
        this.nnM.setVisibility(8);
        AppMethodBeat.o(107148);
    }

    private boolean cWz() {
        AppMethodBeat.i(107149);
        if (!com.tencent.mm.plugin.fav.a.b.g(this.dKT) || !com.tencent.mm.plugin.fav.a.b.h(this.dKT)) {
            AppMethodBeat.o(107149);
            return false;
        }
        AppMethodBeat.o(107149);
        return true;
    }

    private void cWA() {
        AppMethodBeat.i(107150);
        if (getType() == 15 && this.dKT.Lwn != null && !Util.isNullOrNil(this.dKT.Lwn.iyZ) && !Util.isNullOrNil(this.dKT.Lwn.izd)) {
            this.thW = true;
            this.thK.setVisibility(8);
            this.thM.setVisibility(8);
            this.thJ.setVisibility(8);
            this.reX.setVisibility(8);
            this.thI.setVisibility(8);
            this.nnM.setVisibility(8);
            String d2 = com.tencent.mm.plugin.fav.a.b.d(this.dKT);
            Log.d("MicroMsg.FavoriteFileDetailUI", f.app() + " initView: fullpath:" + d2);
            this.qbJ = v.iE((MMActivity) super.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) findViewById(R.id.j44)).addView((View) this.qbJ, 0, layoutParams);
            this.qbJ.setVideoCallback(new j.a() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass4 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void tf() {
                    AppMethodBeat.i(107118);
                    Log.d("MicroMsg.FavoriteFileDetailUI", f.app() + " onPrepared");
                    FavoriteFileDetailUI.this.qbJ.setLoop(true);
                    FavoriteFileDetailUI.this.qbJ.start();
                    AppMethodBeat.o(107118);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onError(int i2, int i3) {
                    AppMethodBeat.i(107119);
                    FavoriteFileDetailUI.this.qbJ.stop();
                    if (FavoriteFileDetailUI.this.thR) {
                        AppMethodBeat.o(107119);
                        return;
                    }
                    FavoriteFileDetailUI.this.thR = true;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(107117);
                            h.n(FavoriteFileDetailUI.this.cWv(), R.string.hwr, R.string.hxe);
                            Bitmap a2 = com.tencent.mm.plugin.fav.ui.o.a(FavoriteFileDetailUI.this.dKT, FavoriteFileDetailUI.this.tbr);
                            ImageView imageView = (ImageView) FavoriteFileDetailUI.this.findViewById(R.id.j73);
                            if (imageView != null) {
                                imageView.setImageBitmap(a2);
                                imageView.setVisibility(0);
                            }
                            AppMethodBeat.o(107117);
                        }
                    });
                    AppMethodBeat.o(107119);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onCompletion() {
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final int fh(int i2, int i3) {
                    return 0;
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void eo(int i2, int i3) {
                }
            });
            Log.d("MicroMsg.FavoriteFileDetailUI", f.app() + " initView :" + d2);
            if (d2 != null) {
                this.qbJ.stop();
                this.qbJ.setVideoPath(d2);
            }
            Log.d("MicroMsg.FavoriteFileDetailUI", f.app() + " initView");
            com.tencent.mm.ay.a.bea();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11444, 4);
        }
        if (getType() == 15 || getType() == 4) {
            if (!this.thW) {
                this.thM.setVisibility(8);
                this.thJ.setVisibility(8);
                this.reX.setVisibility(8);
                this.thI.setVisibility(0);
                this.thI.setText(R.string.ca0);
                this.nnM.setVisibility(8);
                bLd();
            }
        } else if (cWz()) {
            this.thM.setVisibility(8);
            this.thJ.setVisibility(8);
            this.reX.setVisibility(0);
            this.thI.setVisibility(8);
            this.nnM.setVisibility(8);
            this.reX.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107120);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FavoriteFileDetailUI.v(FavoriteFileDetailUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107120);
                }
            });
        } else {
            this.thM.setVisibility(8);
            this.thJ.setVisibility(8);
            if (Util.isNullOrNil(this.dKT.Lvu)) {
                this.reX.setVisibility(8);
            } else {
                this.reX.setVisibility(0);
            }
            this.thI.setVisibility(0);
            this.thD.tap = true;
            this.nnM.setVisibility(0);
        }
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(107121);
                com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.this.tbr);
                AppMethodBeat.o(107121);
            }
        });
        if (this.thY.getFileStatus() != 1) {
            this.thY.setFileStatus(1);
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.thY);
        }
        AppMethodBeat.o(107150);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107151);
        setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
        if (this.qbJ != null) {
            this.qbJ.setVideoCallback(null);
            this.qbJ.stop();
            this.qbJ.onDetach();
        }
        if (this.RbU != null) {
            this.RbU.onDestroy();
        }
        if (this.thY != null) {
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.thY);
        }
        super.onDestroy();
        AppMethodBeat.o(107151);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107152);
        super.onResume();
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
        if (this.qbJ != null) {
            this.qbJ.start();
        }
        if (this.RbU != null) {
            this.RbU.bCA();
        }
        if (this.RbV != null) {
            this.RbV.bCA();
        }
        AppMethodBeat.o(107152);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(107153);
        super.onPause();
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
        if (this.qbJ != null) {
            this.qbJ.stop();
        }
        if (this.RbU != null) {
            this.RbU.aGj();
        }
        if (this.RbV != null) {
            this.RbV.aGj();
        }
        AppMethodBeat.o(107153);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(107154);
        super.onActivityResult(i2, i3, intent);
        ((ab) com.tencent.mm.kernel.g.af(ab.class)).c(this, i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(107154);
            return;
        }
        if (i2 == 1) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            final q a2 = h.a((Context) ((MMActivity) super.getContext()), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            Log.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", Integer.valueOf(getType()));
            AnonymousClass7 r5 = new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(107122);
                    a2.dismiss();
                    AppMethodBeat.o(107122);
                }
            };
            int type = getType();
            if (Util.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(107154);
                return;
            }
            for (String str : Util.stringsToList(stringExtra.split(","))) {
                if (type == 4 || type == 15) {
                    l.a((MMActivity) super.getContext(), str, this.dKT, r5);
                    boolean Eq = com.tencent.mm.model.ab.Eq(str);
                    m.a(Eq ? m.c.Chatroom : m.c.Chat, this.tbr, m.d.Full, Eq ? com.tencent.mm.model.v.Ie(str) : 0);
                } else {
                    l.a((MMActivity) super.getContext(), str, this.tbr, this.dKT, r5);
                }
                if (!Util.isNullOrNil(stringExtra2)) {
                    com.tencent.mm.plugin.messenger.a.g.eir().ad(str, stringExtra2, com.tencent.mm.model.ab.JG(str));
                }
            }
            com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.c8o));
        }
        AppMethodBeat.o(107154);
    }

    @Override // com.tencent.mm.plugin.fav.a.p
    public final void e(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(107155);
        if (cVar == null || cVar.field_dataId == null) {
            Log.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
            AppMethodBeat.o(107155);
            return;
        }
        Log.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", this.dKT.dLl, cVar.field_dataId);
        if (!cVar.field_dataId.equals(this.dKT.dLl)) {
            AppMethodBeat.o(107155);
        } else if (!this.tbr.cUx() || !Util.isNullOrNil(this.dKT.KuR)) {
            b(cVar.getProgress(), getString(R.string.c9p, new Object[]{com.tencent.mm.plugin.fav.a.b.getLengthStr((float) cVar.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr((float) cVar.field_totalLen)}));
            if (this.thS && s.YS(cVar.field_path)) {
                this.tbr.field_itemStatus = 10;
                onNotifyChange("", null);
            }
            AppMethodBeat.o(107155);
        } else {
            b(cVar.getProgress(), getString(R.string.ccz, new Object[]{com.tencent.mm.plugin.fav.a.b.getLengthStr((float) cVar.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr((float) cVar.field_totalLen)}));
            AppMethodBeat.o(107155);
        }
    }

    private void b(final float f2, final String str) {
        AppMethodBeat.i(107156);
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(107123);
                FavoriteFileDetailUI.this.progressBar.setProgress((int) f2);
                FavoriteFileDetailUI.this.progressTips.setText(str);
                AppMethodBeat.o(107123);
            }
        });
        AppMethodBeat.o(107156);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        boolean z;
        AppMethodBeat.i(107157);
        Log.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", str, Long.valueOf(this.tbr.field_localId));
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tbr.field_localId);
        if (DY != null || this.thS) {
            if (!this.thS) {
                this.tbr = DY;
            }
            cWu();
            com.tencent.mm.plugin.fav.a.c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
            if (asa == null) {
                z = false;
            } else if (asa.field_status == 1) {
                z = true;
            } else if (this.dKT.dataType == 8) {
                z = false;
            } else if (this.thX) {
                z = false;
            } else {
                if (asa.field_status == 4 && ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl).field_extFlag != 0) {
                    com.tencent.mm.plugin.fav.a.b.a(this.tbr, this.dKT, true);
                    this.thX = true;
                }
                Log.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", Boolean.valueOf(this.thX));
                z = this.thX;
            }
            if (z) {
                AppMethodBeat.o(107157);
                return;
            }
            this.hAk.post(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(107124);
                    FavoriteFileDetailUI.y(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107124);
                }
            });
            AppMethodBeat.o(107157);
            return;
        }
        Log.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
        finish();
        AppMethodBeat.o(107157);
    }

    private void bLd() {
        AppMethodBeat.i(107158);
        if (this.thV) {
            AppMethodBeat.o(107158);
            return;
        }
        this.thD.taq++;
        this.thV = true;
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", this.dFW);
        intent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.dKT));
        intent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.dKT));
        intent.putExtra("key_detail_fav_video_duration", this.dKT.duration);
        intent.putExtra("key_detail_statExtStr", this.dKT.ean);
        intent.putExtra("key_detail_msg_uuid", this.dKT.jsz);
        com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", intent);
        finish();
        AppMethodBeat.o(107158);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public /* bridge */ /* synthetic */ AppCompatActivity getContext() {
        AppMethodBeat.i(107160);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.o(107160);
        return mMActivity;
    }

    static /* synthetic */ void a(FavoriteFileDetailUI favoriteFileDetailUI, String str) {
        AppMethodBeat.i(261613);
        favoriteFileDetailUI.thD.taq++;
        ((ab) com.tencent.mm.kernel.g.af(ab.class)).b(favoriteFileDetailUI, str, favoriteFileDetailUI.dKT.LvC);
        AppMethodBeat.o(261613);
    }

    static /* synthetic */ void a(FavoriteFileDetailUI favoriteFileDetailUI, g gVar) {
        int i2 = 3;
        AppMethodBeat.i(261616);
        com.tencent.mm.plugin.fav.a.h.w(gVar.field_localId, 1);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (favoriteFileDetailUI.getType() == 15) {
            i2 = 11;
            intent.putExtra("image_path", l.k(favoriteFileDetailUI.dKT));
        } else if (favoriteFileDetailUI.getType() == 4) {
            intent.putExtra("image_path", l.k(favoriteFileDetailUI.dKT));
            i2 = 1;
        } else {
            intent.putExtra("desc_title", favoriteFileDetailUI.dKT.title);
        }
        intent.putExtra("Retr_Msg_Type", i2);
        com.tencent.mm.br.c.c(favoriteFileDetailUI, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.o(261616);
    }

    static /* synthetic */ void n(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(261617);
        final String d2 = com.tencent.mm.plugin.fav.a.b.d(favoriteFileDetailUI.dKT);
        com.tencent.mm.platformtools.p.b((MMActivity) super.getContext(), d2, new p.a() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.AnonymousClass10 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(235325);
                Log.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", Integer.valueOf(hashCode()), d2, str2);
                Toast.makeText(FavoriteFileDetailUI.this.cWv(), FavoriteFileDetailUI.this.getString(R.string.hwu, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(str2, FavoriteFileDetailUI.this.cWv());
                AppMethodBeat.o(235325);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(235326);
                Log.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", Integer.valueOf(hashCode()), d2, str2);
                Toast.makeText(FavoriteFileDetailUI.this.cWv(), FavoriteFileDetailUI.this.getString(R.string.hwt), 1).show();
                AppMethodBeat.o(235326);
            }
        });
        AppMethodBeat.o(261617);
    }

    static /* synthetic */ void v(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(261618);
        if (favoriteFileDetailUI.getType() == 8 && com.tencent.mm.plugin.fav.a.b.g(favoriteFileDetailUI.dKT) && com.tencent.mm.plugin.fav.a.b.h(favoriteFileDetailUI.dKT)) {
            favoriteFileDetailUI.thD.taq++;
            g gVar = favoriteFileDetailUI.tbr;
            and and = new and();
            and.scene = favoriteFileDetailUI.thD.scene;
            and.pHw = favoriteFileDetailUI.thD.pHw;
            and.index = favoriteFileDetailUI.thD.index;
            ((y) com.tencent.mm.kernel.g.af(y.class)).a((MMActivity) super.getContext(), gVar, and);
        }
        AppMethodBeat.o(261618);
    }
}
