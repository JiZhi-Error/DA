package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.d;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI extends MMActivity implements AdapterView.OnItemSelectedListener, p, d.a, r.a, a.AbstractC1683a<String, com.tencent.mm.plugin.scanner.word.b> {
    private boolean dUo = true;
    private MMGestureGallery jUy;
    private ArrayList<i> kgc;
    private ScanCodeSheetItemLogic mHu;
    private o.g rjz = new o.g() {
        /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass11 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(106746);
            i Ib = FavImgGalleryUI.this.tey.Ib(FavImgGalleryUI.this.tex);
            if (Ib == null) {
                AppMethodBeat.o(106746);
                return;
            }
            String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
            if (!s.YS(d2)) {
                Log.w("MicroMsg.FavImgGalleryUI", "file not exists");
                AppMethodBeat.o(106746);
                return;
            }
            switch (menuItem.getItemId()) {
                case 0:
                    h.w(FavImgGalleryUI.this.teE, 1);
                    if (ImgUtil.isGif(d2)) {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        com.tencent.mm.br.c.c(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                        AppMethodBeat.o(106746);
                        return;
                    }
                    com.tencent.mm.plugin.fav.a.b.a(d2, FavImgGalleryUI.this, Ib.dKT.jsz);
                    AppMethodBeat.o(106746);
                    return;
                case 1:
                    com.tencent.mm.plugin.fav.a.b.b(d2, FavImgGalleryUI.this);
                    h.w(FavImgGalleryUI.this.teE, 0);
                    AppMethodBeat.o(106746);
                    return;
                case 2:
                    FavImgGalleryUI.a(d2, FavImgGalleryUI.this.getString(R.string.cc0), FavImgGalleryUI.this, Ib.dKT.jsz);
                    AppMethodBeat.o(106746);
                    return;
                case 4:
                    if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavImgGalleryUI.this.getContext())) {
                        FavImgGalleryUI.this.teD.cWf();
                        AppMethodBeat.o(106746);
                        return;
                    }
                    break;
                case 5:
                    FavImgGalleryUI.k(FavImgGalleryUI.this);
                    break;
            }
            AppMethodBeat.o(106746);
        }
    };
    private d teA;
    private Map<String, b> teB = new HashMap();
    private boolean teC;
    private r teD;
    private long teE;
    private IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass5 */

        {
            AppMethodBeat.i(164091);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(164091);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(164092);
            qz qzVar2 = qzVar;
            String str = qzVar2.dXz.filePath;
            b bVar = new b((byte) 0);
            bVar.teQ = qzVar2;
            FavImgGalleryUI.this.teB.put(str, bVar);
            if (FavImgGalleryUI.this.tez != null && FavImgGalleryUI.this.tez.isShowing()) {
                FavImgGalleryUI.d(FavImgGalleryUI.this);
            }
            AppMethodBeat.o(164092);
            return true;
        }
    };
    private int tex = 0;
    private a tey;
    private e tez;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.tencent.mm.plugin.scanner.word.a.AbstractC1683a
    public final /* synthetic */ void M(String str, com.tencent.mm.plugin.scanner.word.b bVar) {
        boolean z;
        AppMethodBeat.i(106772);
        com.tencent.mm.plugin.scanner.word.b bVar2 = bVar;
        String cVV = cVV();
        int gw = i.gw(bVar2.CVF);
        Log.i("MicroMsg.FavImgGalleryUI", "local translate, img %s, result %s, ratio %d", cVV, bVar2.CVF, Integer.valueOf(gw));
        if (str.equals(cVV)) {
            if (gw > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.teC = true;
                ks(false);
            }
        }
        AppMethodBeat.o(106772);
    }

    public FavImgGalleryUI() {
        AppMethodBeat.i(106757);
        AppMethodBeat.o(106757);
    }

    static /* synthetic */ void a(FavImgGalleryUI favImgGalleryUI, boolean z) {
        AppMethodBeat.i(106773);
        favImgGalleryUI.ks(z);
        AppMethodBeat.o(106773);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a7_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106758);
        super.onCreate(bundle);
        hideTitleView();
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.teD = new r(this, this, this);
        this.dUo = getIntent().getBooleanExtra("show_share", true);
        this.jUy = (MMGestureGallery) findViewById(R.id.dci);
        this.teA = new d(this.jUy, this, this);
        this.jUy.setVerticalFadingEdgeEnabled(false);
        this.jUy.setHorizontalFadingEdgeEnabled(false);
        this.jUy.setOnItemSelectedListener(this);
        this.jUy.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                AppMethodBeat.i(106737);
                if (FavImgGalleryUI.this.teD.tgN != 1) {
                    FavImgGalleryUI.this.teA.mD(true);
                }
                AppMethodBeat.o(106737);
            }
        });
        if (this.dUo) {
            this.jUy.setLongClickOverListener(new MMGestureGallery.c() {
                /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.tools.MMGestureGallery.c
                public final void bmu() {
                    AppMethodBeat.i(106741);
                    if (FavImgGalleryUI.this.teD.tgN == 1) {
                        AppMethodBeat.o(106741);
                        return;
                    }
                    if (!FavImgGalleryUI.this.isFinishing() && !FavImgGalleryUI.this.activityHasDestroyed()) {
                        ad.b G = ad.aVe().G("basescanui@datacenter", true);
                        G.l("key_basescanui_screen_position", Boolean.TRUE);
                        G.l("key_basescanui_screen_x", Float.valueOf((float) FavImgGalleryUI.this.jUy.getXDown()));
                        G.l("key_basescanui_screen_y", Float.valueOf((float) FavImgGalleryUI.this.jUy.getYDown()));
                        if (FavImgGalleryUI.this.teD.tgN == 0 || FavImgGalleryUI.this.teD.tgN == 2) {
                            FavImgGalleryUI.a(FavImgGalleryUI.this, i.eOQ());
                            AppMethodBeat.o(106741);
                            return;
                        }
                        FavImgGalleryUI.d(FavImgGalleryUI.this);
                    }
                    AppMethodBeat.o(106741);
                }
            });
        }
        fullScreenNoTitleBar(true);
        this.kgc = new ArrayList<>();
        this.tey = new a(this, (byte) 0);
        this.jUy.setAdapter((SpinnerAdapter) this.tey);
        and();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106742);
                FavImgGalleryUI.this.teA.mD(true);
                AppMethodBeat.o(106742);
                return true;
            }
        });
        this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(106743);
                FavImgGalleryUI.d(FavImgGalleryUI.this);
                AppMethodBeat.o(106743);
            }
        });
        EventCenter.instance.addListener(this.teF);
        setResult(0, getIntent());
        AppMethodBeat.o(106758);
    }

    private void ks(boolean z) {
        AppMethodBeat.i(106759);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        i Ib = this.tey.Ib(this.tex);
        if (Ib == null) {
            AppMethodBeat.o(106759);
        } else if (Ib.dKT.Lwv != 0) {
            AppMethodBeat.o(106759);
        } else {
            if (Ib.tew != null && Ib.tew.cUu()) {
                arrayList.add(0);
                arrayList2.add(getString(R.string.cc8));
            }
            if (Ib.tew != null && Ib.tew.cUv()) {
                arrayList.add(1);
                arrayList2.add(getString(R.string.cau));
            }
            arrayList.add(2);
            arrayList2.add(getString(R.string.gaq));
            String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
            if (this.teC && !Util.isNullOrNil(d2)) {
                arrayList.add(4);
                arrayList2.add(getString(R.string.az0));
            }
            arrayList.add(5);
            arrayList2.add(getString(R.string.ayz));
            final b bVar = this.teB.get(d2);
            if (bVar == null || bVar.teQ == null) {
                qx qxVar = new qx();
                qxVar.dXu.dDZ = System.currentTimeMillis();
                qxVar.dXu.filePath = d2;
                EventCenter.instance.publish(qxVar);
            } else {
                qz qzVar = bVar.teQ;
                if (!Util.isNullOrNil(qzVar.dXz.result)) {
                    arrayList.add(3);
                    arrayList2.add(this.mHu.Wp(qzVar.dXz.dFL));
                }
            }
            if (this.tez == null) {
                this.tez = new e((Context) getContext(), 1, false);
            }
            this.tez.HLX = new o.f() {
                /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(106744);
                    FavImgGalleryUI.this.tez.setFooterView(null);
                    mVar.clear();
                    mVar.setHeaderTitle("");
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((Integer) arrayList.get(i2)).intValue() == 3) {
                            FavImgGalleryUI.this.tez.setFooterView(FavImgGalleryUI.a(FavImgGalleryUI.this, bVar));
                        } else {
                            mVar.d(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                        }
                    }
                    AppMethodBeat.o(106744);
                }
            };
            this.tez.HLY = this.rjz;
            this.tez.PGl = new e.b() {
                /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass10 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(106745);
                    FavImgGalleryUI.this.tez = null;
                    FavImgGalleryUI.this.mHu.onDismiss();
                    AppMethodBeat.o(106745);
                }
            };
            if (!getContext().isFinishing()) {
                this.tez.dGm();
            }
            if (!Util.isNullOrNil(d2)) {
                g.aAi();
                if (g.aAg().hqi.aYS() != 0 && z) {
                    this.teD.scan(d2);
                }
            }
            AppMethodBeat.o(106759);
        }
    }

    public static void a(String str, final String str2, final Context context, final String str3) {
        AppMethodBeat.i(164093);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
            AppMethodBeat.o(164093);
            return;
        }
        com.tencent.mm.platformtools.p.a(context, str, new p.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass13 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, final String str2) {
                AppMethodBeat.i(235314);
                Toast.makeText(context, context.getString(R.string.bjr, AndroidMediaUtil.getFriendlySdcardPath(str2)), 1).show();
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass13.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(235313);
                        String bhK = s.bhK(str2);
                        v vVar = v.jNy;
                        v.bR(bhK, str3);
                        AppMethodBeat.o(235313);
                    }
                });
                AppMethodBeat.o(235314);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(235315);
                Toast.makeText(context, str2, 1).show();
                AppMethodBeat.o(235315);
            }
        });
        AppMethodBeat.o(164093);
    }

    private void and() {
        com.tencent.mm.plugin.fav.a.g gVar;
        int i2;
        AppMethodBeat.i(106761);
        this.teE = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.plugin.fav.a.g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(this.teE);
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.teE);
        objArr[1] = Boolean.valueOf(DY != null);
        Log.i("MicroMsg.FavImgGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", objArr);
        if (!booleanExtra || Util.isNullOrNil(stringExtra2)) {
            gVar = DY;
        } else {
            gVar = com.tencent.mm.plugin.fav.a.b.arO(stringExtra2);
        }
        if (gVar != null) {
            arrayList.add(gVar);
        }
        this.kgc.clear();
        final int i3 = -1;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            com.tencent.mm.plugin.fav.a.g gVar2 = (com.tencent.mm.plugin.fav.a.g) arrayList.get(i4);
            int size2 = gVar2.field_favProto.ppH.size();
            int i5 = 0;
            while (i5 < size2) {
                aml aml = gVar2.field_favProto.ppH.get(i5);
                if ((aml.dataType != 8 || ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(aml))) && (aml.dataType == 2 || aml.dataType == 8)) {
                    this.kgc.add(new i(gVar2, aml));
                    if (stringExtra != null && stringExtra.equals(aml.dLl)) {
                        i2 = this.kgc.size() - 1;
                        i5++;
                        i3 = i2;
                    }
                }
                i2 = i3;
                i5++;
                i3 = i2;
            }
            if (stringExtra == null && gVar2.field_localId == this.teE) {
                i3 = this.kgc.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.tey.notifyDataSetChanged();
        this.jUy.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(106738);
                if (i3 != -1) {
                    Log.d("MicroMsg.FavImgGalleryUI", "match selection %d", Integer.valueOf(i3));
                    FavImgGalleryUI.this.jUy.setSelection(i3);
                    FavImgGalleryUI.this.tex = i3;
                    AppMethodBeat.o(106738);
                } else if (FavImgGalleryUI.this.tex - 1 >= 0 && FavImgGalleryUI.this.tex - 1 < FavImgGalleryUI.this.kgc.size()) {
                    Log.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", Integer.valueOf(FavImgGalleryUI.this.tex - 1), Integer.valueOf(FavImgGalleryUI.this.kgc.size()));
                    FavImgGalleryUI.this.jUy.setSelection(FavImgGalleryUI.this.tex - 1);
                    FavImgGalleryUI.this.tex--;
                    AppMethodBeat.o(106738);
                } else if (FavImgGalleryUI.this.kgc.size() > 0) {
                    Log.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", Integer.valueOf(FavImgGalleryUI.this.kgc.size()));
                    FavImgGalleryUI.this.jUy.setSelection(0);
                    FavImgGalleryUI.this.tex = 0;
                    AppMethodBeat.o(106738);
                } else {
                    Log.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", Integer.valueOf(FavImgGalleryUI.this.kgc.size()));
                    FavImgGalleryUI.this.finish();
                    AppMethodBeat.o(106738);
                }
            }
        });
        AppMethodBeat.o(106761);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(106762);
        getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
        EventCenter.instance.removeListener(this.teF);
        if (this.teA != null) {
            this.teA.onDestroy();
        }
        if (this.teD != null) {
            this.teD.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(106762);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(106763);
        super.onResume();
        ((af) g.ah(af.class)).getFavCdnStorage().a(this);
        f.e(true, true, true);
        AppMethodBeat.o(106763);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(106764);
        super.onPause();
        ((af) g.ah(af.class)).getFavCdnStorage().b(this);
        f.e(false, true, true);
        AppMethodBeat.o(106764);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(106765);
        if (i2 == 4) {
            this.teA.mD(true);
            AppMethodBeat.o(106765);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(106765);
        return onKeyDown;
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String cVV() {
        AppMethodBeat.i(106766);
        i Ib = this.tey.Ib(this.tex);
        if (Ib == null) {
            AppMethodBeat.o(106766);
            return "";
        }
        String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
        AppMethodBeat.o(106766);
        return d2;
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String getFileId() {
        AppMethodBeat.i(235316);
        i Ib = this.tey.Ib(this.tex);
        if (Ib == null || Ib.dKT == null) {
            AppMethodBeat.o(235316);
            return null;
        }
        String str = Ib.dKT.KuR;
        AppMethodBeat.o(235316);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String getAesKey() {
        AppMethodBeat.i(235317);
        i Ib = this.tey.Ib(this.tex);
        if (Ib == null || Ib.dKT == null) {
            AppMethodBeat.o(235317);
            return null;
        }
        String str = Ib.dKT.Lvp;
        AppMethodBeat.o(235317);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.a
    public final MultiTouchImageView cVG() {
        AppMethodBeat.i(106767);
        int selectedItemPosition = this.jUy.getSelectedItemPosition();
        MMGestureGallery mMGestureGallery = this.jUy;
        View childAt = mMGestureGallery.getChildAt(selectedItemPosition - mMGestureGallery.getFirstVisiblePosition());
        if (childAt == null) {
            Log.i("MicroMsg.FavImgGalleryUI", "getCurView() pos:%s firstPos:%s", Integer.valueOf(selectedItemPosition), Integer.valueOf(this.jUy.getFirstVisiblePosition()));
            AppMethodBeat.o(106767);
            return null;
        } else if (childAt instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) childAt;
            AppMethodBeat.o(106767);
            return multiTouchImageView;
        } else {
            MultiTouchImageView multiTouchImageView2 = (MultiTouchImageView) childAt.findViewById(R.id.dup);
            AppMethodBeat.o(106767);
            return multiTouchImageView2;
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.a
    public final String cVH() {
        AppMethodBeat.i(106768);
        String str = this.tey.Ib(this.jUy.getSelectedItemPosition()).dKT.dLl;
        AppMethodBeat.o(106768);
        return str;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        SparseBooleanArray teP;

        private a() {
            AppMethodBeat.i(106749);
            this.teP = new SparseBooleanArray();
            AppMethodBeat.o(106749);
        }

        /* synthetic */ a(FavImgGalleryUI favImgGalleryUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(106756);
            i Ib = Ib(i2);
            AppMethodBeat.o(106756);
            return Ib;
        }

        public final int getCount() {
            AppMethodBeat.i(106750);
            int size = FavImgGalleryUI.this.kgc.size();
            AppMethodBeat.o(106750);
            return size;
        }

        public final i Ib(int i2) {
            AppMethodBeat.i(106751);
            if (i2 >= FavImgGalleryUI.this.kgc.size()) {
                Log.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", Integer.valueOf(i2));
                AppMethodBeat.o(106751);
                return null;
            }
            i iVar = (i) FavImgGalleryUI.this.kgc.get(i2);
            AppMethodBeat.o(106751);
            return iVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            String str;
            AppMethodBeat.i(106752);
            if (view == null) {
                cVar = new c(FavImgGalleryUI.this, (byte) 0);
                view = View.inflate(FavImgGalleryUI.this.getContext(), R.layout.a79, null);
                cVar.teS = view.findViewById(R.id.dvp);
                cVar.teT = (MultiTouchImageView) view.findViewById(R.id.dup);
                cVar.progressBar = (ProgressBar) view.findViewById(R.id.buu);
                cVar.mEx = (ImageView) view.findViewById(R.id.imb);
                cVar.teU = (TextView) view.findViewById(R.id.buv);
                cVar.teV = (LinearLayout) view.findViewById(R.id.cbv);
                cVar.teW = (TextView) view.findViewById(R.id.cbw);
                cVar.teW.setText(R.string.c9d);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            i Ib = Ib(i2);
            boolean z = this.teP.get(i2, true);
            this.teP.put(i2, false);
            Bitmap a2 = o.a(Ib.dKT, Ib.tew, z);
            if (Ib.tew != null) {
                Log.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", Integer.valueOf(i2), Integer.valueOf(Ib.tew.field_id), Long.valueOf(Ib.tew.field_localId), Integer.valueOf(Ib.tew.field_itemStatus));
            }
            if (Ib.dKT != null) {
                Log.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", Ib.dKT.dLl, Ib.dKT.KuR, Ib.dKT.Lvp, Long.valueOf(Ib.dKT.LvI), Ib.dKT.iwX, Ib.dKT.Lvk, Long.valueOf(Ib.dKT.LvT));
            }
            if (a2 == null) {
                FavImgGalleryUI.this.enableOptionMenu(false);
                Log.w("MicroMsg.FavImgGalleryUI", "get big image fail");
                q favCdnStorage = ((af) g.ah(af.class)).getFavCdnStorage();
                if (Ib.dKT != null) {
                    str = Ib.dKT.dLl;
                } else {
                    str = "";
                }
                com.tencent.mm.plugin.fav.a.c asa = favCdnStorage.asa(str);
                if (asa == null) {
                    cVar.teV.setVisibility(8);
                    if (Ib.tew == null || Ib.tew.field_id >= 0) {
                        cVar.progressBar.setVisibility(8);
                        cVar.teU.setVisibility(8);
                        cVar.mEx.setVisibility(8);
                        cVar.teS.setVisibility(0);
                        if (Ib.dKT.Lwv != 0) {
                            cVar.teV.setVisibility(0);
                        }
                        b(cVar, a(Ib), "");
                    } else {
                        cVar.progressBar.setVisibility(0);
                        cVar.teU.setVisibility(0);
                        cVar.mEx.setVisibility(0);
                        cVar.teS.setVisibility(8);
                        cVar.mEx.setImageBitmap(a(Ib));
                        cVar.progressBar.setProgress(0);
                        cVar.teU.setText("0%");
                    }
                    AppMethodBeat.o(106752);
                } else {
                    Log.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", Integer.valueOf(asa.field_status));
                    cVar.progressBar.setVisibility(0);
                    cVar.teU.setVisibility(0);
                    cVar.mEx.setVisibility(0);
                    cVar.teS.setVisibility(8);
                    cVar.mEx.setImageBitmap(a(Ib));
                    int i3 = asa.field_totalLen > 0 ? ((asa.field_offset * 100) / asa.field_totalLen) - 1 : 0;
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    cVar.progressBar.setProgress(i3);
                    cVar.teU.setText(i3 + "%");
                    AppMethodBeat.o(106752);
                }
            } else {
                FavImgGalleryUI.this.enableOptionMenu(true);
                if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(Ib.dKT))) {
                    a(cVar, a2, com.tencent.mm.plugin.fav.a.b.d(Ib.dKT));
                } else {
                    a(cVar, a2, "");
                }
                AppMethodBeat.o(106752);
            }
            return view;
        }

        private void a(c cVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(106753);
            cVar.progressBar.setVisibility(8);
            cVar.teU.setVisibility(8);
            cVar.mEx.setVisibility(8);
            cVar.teS.setVisibility(0);
            cVar.teV.setVisibility(8);
            b(cVar, bitmap, str);
            AppMethodBeat.o(106753);
        }

        private Bitmap a(i iVar) {
            Bitmap a2;
            AppMethodBeat.i(106754);
            if (iVar == null || (a2 = o.a(iVar.dKT, iVar.tew)) == null) {
                Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(FavImgGalleryUI.this.getResources(), R.raw.download_image_icon);
                AppMethodBeat.o(106754);
                return decodeResource;
            }
            AppMethodBeat.o(106754);
            return a2;
        }

        private void b(c cVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(106755);
            ForceGpuUtil.decideLayerType(cVar.teT, bitmap.getWidth(), bitmap.getHeight());
            int width = cVar.teT.getWidth();
            int height = cVar.teT.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            Log.v("MicroMsg.FavImgGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
            if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
                float width3 = ((float) bitmap.getWidth()) / ((float) width);
                float width4 = ((float) width) / ((float) bitmap.getWidth());
                if (((double) width3) > 1.0d) {
                    matrix.postScale(width4, width4);
                    bitmap.getHeight();
                    matrix.postTranslate((((float) width) - (width4 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
                }
            } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
                float width5 = ((float) width) / ((float) bitmap.getWidth());
                float height3 = ((float) height) / ((float) bitmap.getHeight());
                if (width5 >= height3) {
                    width5 = height3;
                }
                float width6 = ((float) bitmap.getWidth()) / ((float) width);
                float height4 = ((float) bitmap.getHeight()) / ((float) height);
                if (width6 <= height4) {
                    width6 = height4;
                }
                if (((double) width6) > 1.0d) {
                    matrix.postScale(width5, width5);
                } else {
                    width5 = 1.0f;
                }
                matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width5)) / 2.0f, (((float) height) - (width5 * ((float) bitmap.getHeight()))) / 2.0f);
            } else {
                float height5 = ((float) bitmap.getHeight()) / 480.0f;
                float height6 = 480.0f / ((float) bitmap.getHeight());
                if (((double) height5) > 1.0d) {
                    matrix.postScale(height5, height6);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    float height7 = (float) ((height - bitmap.getHeight()) / 2);
                    Log.d("MicroMsg.FavImgGalleryUI", " offsety ".concat(String.valueOf(height7)));
                    matrix.postTranslate(0.0f, height7);
                }
            }
            cVar.teT.setImageMatrix(matrix);
            cVar.teT.cN(bitmap.getWidth(), bitmap.getHeight());
            cVar.teT.setMaxZoomDoubleTab(true);
            if (Util.isNullOrNil(str)) {
                cVar.teT.setImageBitmap(bitmap);
                AppMethodBeat.o(106755);
                return;
            }
            try {
                com.tencent.mm.plugin.gif.d dVar = new com.tencent.mm.plugin.gif.d(str);
                cVar.teT.setGifDrawable(dVar);
                cVar.teT.kY(com.tencent.mm.cb.a.jn(FavImgGalleryUI.this.getContext()), com.tencent.mm.cb.a.jo(FavImgGalleryUI.this.getContext()));
                cVar.teT.cN(dVar.getIntrinsicWidth(), dVar.getIntrinsicHeight());
                cVar.teT.start();
                cVar.teT.gKz();
                AppMethodBeat.o(106755);
            } catch (Exception e2) {
                Log.e("MicroMsg.FavImgGalleryUI", Util.stackTraceToString(e2));
                cVar.teT.setImageBitmap(bitmap);
                AppMethodBeat.o(106755);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(106769);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        this.tex = i2;
        Log.d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(i2)));
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).gKy();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(106769);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* access modifiers changed from: package-private */
    public class c {
        ImageView mEx;
        ProgressBar progressBar;
        View teS;
        MultiTouchImageView teT;
        TextView teU;
        LinearLayout teV;
        TextView teW;

        private c() {
        }

        /* synthetic */ c(FavImgGalleryUI favImgGalleryUI, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.p
    public final void e(final com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(106770);
        if (cVar != null) {
            Log.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", Integer.valueOf(cVar.field_status));
            i Ib = this.tey.Ib(this.tex);
            if (Ib != null && Util.nullAs(cVar.field_dataId, "").equals(Ib.dKT.dLl)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass3 */

                    public final void run() {
                        int i2 = 0;
                        AppMethodBeat.i(106739);
                        View selectedView = FavImgGalleryUI.this.jUy.getSelectedView();
                        if (selectedView == null) {
                            AppMethodBeat.o(106739);
                            return;
                        }
                        c cVar = (c) selectedView.getTag();
                        int i3 = cVar.field_totalLen > 0 ? ((cVar.field_offset * 100) / cVar.field_totalLen) - 1 : 0;
                        if (i3 >= 0) {
                            i2 = i3;
                        }
                        cVar.progressBar.setProgress(i2);
                        cVar.teU.setText(i2 + "%");
                        if (i2 >= 100 || cVar.isFinished()) {
                            FavImgGalleryUI.this.tey.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(106739);
                    }
                });
            }
        }
        AppMethodBeat.o(106770);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(106771);
        if (1 == i2) {
            if (-1 != i3) {
                AppMethodBeat.o(106771);
                return;
            }
            i Ib = this.tey.Ib(this.tex);
            if (Ib == null) {
                Log.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
                AppMethodBeat.o(106771);
                return;
            }
            new k();
            if (k.v(Ib.tew)) {
                com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.f3146c));
                AppMethodBeat.o(106771);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            Log.d("MicroMsg.FavImgGalleryUI", "select %s for sending", stringExtra);
            final com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            l.a(getContext(), stringExtra, Ib.tew, Ib.dKT, new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(164090);
                    a2.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.r(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(R.string.c8o));
                    AppMethodBeat.o(164090);
                }
            });
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(106771);
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        qz teQ;
        boolean teR;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static /* synthetic */ void d(FavImgGalleryUI favImgGalleryUI) {
        AppMethodBeat.i(106774);
        favImgGalleryUI.ks(false);
        AppMethodBeat.o(106774);
    }

    static /* synthetic */ View a(FavImgGalleryUI favImgGalleryUI, b bVar) {
        AppMethodBeat.i(106775);
        final qz qzVar = bVar.teQ;
        AnonymousClass12 r1 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(106747);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavImgGalleryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.FavImgGalleryUI", "request deal QBAR string");
                if (FavImgGalleryUI.this.tez.isShowing()) {
                    FavImgGalleryUI.this.tez.bMo();
                }
                if (qzVar == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavImgGalleryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106747);
                    return;
                }
                i Ib = FavImgGalleryUI.this.tey.Ib(FavImgGalleryUI.this.tex);
                b bVar2 = (b) FavImgGalleryUI.this.teB.get(com.tencent.mm.plugin.fav.a.b.d(Ib.dKT));
                if (!(bVar2 == null || bVar2.teQ == null)) {
                    cr crVar = new cr();
                    crVar.dFK.activity = FavImgGalleryUI.this;
                    crVar.dFK.dDX = qzVar.dXz.result;
                    crVar.dFK.dFL = qzVar.dXz.dFL;
                    crVar.dFK.sourceType = 7;
                    if (!(Ib == null || Ib.dKT == null)) {
                        crVar.dFK.imagePath = Ib.dKT.KuR;
                        crVar.dFK.dFO = Ib.dKT.Lvp;
                    }
                    crVar.dFK.dFM = qzVar.dXz.dFM;
                    Bundle bundle = new Bundle(1);
                    bundle.putInt("stat_scene", 5);
                    crVar.dFK.dFP = bundle;
                    EventCenter.instance.publish(crVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavImgGalleryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(106747);
            }
        };
        if (!bVar.teR) {
            String str = bVar.teQ.dXz.result;
            favImgGalleryUI.mHu.cm(bVar.teQ.dXz.dFL, str);
            bVar.teR = true;
        }
        View a2 = favImgGalleryUI.mHu.a(r1, qzVar.dXz.dFL, qzVar.dXz.result, 3);
        AppMethodBeat.o(106775);
        return a2;
    }

    static /* synthetic */ void k(FavImgGalleryUI favImgGalleryUI) {
        AppMethodBeat.i(106776);
        String cVV = favImgGalleryUI.cVV();
        Log.i("MicroMsg.FavImgGalleryUI", "edit image path:%s msgId:%s", cVV, 0L);
        RecordConfigProvider jA = RecordConfigProvider.jA(cVV, "");
        jA.scene = 0;
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(true);
        jA.BOn = aVar.gLU;
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(favImgGalleryUI.getContext(), 4369, R.anim.ei, -1, jA, 1, 2);
        AppMethodBeat.o(106776);
    }
}
