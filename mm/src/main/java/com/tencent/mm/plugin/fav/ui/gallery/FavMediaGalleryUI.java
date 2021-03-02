package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.SparseBooleanArray;
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
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
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
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavMediaGalleryUI extends MMActivity implements AdapterView.OnItemSelectedListener, p, r.a, a.AbstractC1683a<String, com.tencent.mm.plugin.scanner.word.b> {
    private boolean dUo = true;
    private MMGestureGallery jUy;
    private ArrayList<i> kgc;
    private o.g rjz = new o.g() {
        /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass10 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(107327);
            i Ib = FavMediaGalleryUI.this.tjT.Ib(FavMediaGalleryUI.this.tex);
            if (Ib == null) {
                AppMethodBeat.o(107327);
                return;
            }
            String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
            if (s.YS(d2) || menuItem.getItemId() == 4) {
                switch (menuItem.getItemId()) {
                    case 0:
                        h.w(FavMediaGalleryUI.this.teE, 1);
                        if (Ib.dKT.dataType != 2) {
                            String a2 = com.tencent.mm.plugin.fav.a.b.a(Ib.dKT);
                            String d3 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            intent.putExtra("mutil_select_is_ret", true);
                            if (s.YS(a2)) {
                                intent.putExtra("image_path", a2);
                            } else {
                                intent.putExtra("image_path", d3);
                            }
                            intent.putExtra("Retr_Msg_Type", 1);
                            c.c(FavMediaGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", intent, 1);
                            AppMethodBeat.o(107327);
                            return;
                        } else if (ImgUtil.isGif(d2)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Conv_Type", 3);
                            intent2.putExtra("select_is_ret", true);
                            c.c(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", intent2, 1);
                            AppMethodBeat.o(107327);
                            return;
                        } else {
                            com.tencent.mm.plugin.fav.a.b.a(d2, FavMediaGalleryUI.this, Ib.dKT.jsz);
                            AppMethodBeat.o(107327);
                            return;
                        }
                    case 1:
                        com.tencent.mm.plugin.fav.a.b.b(d2, FavMediaGalleryUI.this);
                        h.w(FavMediaGalleryUI.this.teE, 0);
                        AppMethodBeat.o(107327);
                        return;
                    case 2:
                        if (Ib.dKT.dataType == 2) {
                            FavMediaGalleryUI.a(FavMediaGalleryUI.this, d2);
                            AppMethodBeat.o(107327);
                            return;
                        }
                        FavMediaGalleryUI.b(FavMediaGalleryUI.this, d2);
                        AppMethodBeat.o(107327);
                        return;
                    case 3:
                        qz qzVar = (qz) FavMediaGalleryUI.this.teB.get(d2);
                        if (qzVar != null) {
                            cr crVar = new cr();
                            crVar.dFK.activity = FavMediaGalleryUI.this;
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
                            AppMethodBeat.o(107327);
                            return;
                        }
                        break;
                    case 4:
                        FavMediaGalleryUI.this.tfo.index = FavMediaGalleryUI.this.tjT.getCount() - FavMediaGalleryUI.this.tex;
                        ((y) g.af(y.class)).a(FavMediaGalleryUI.this.getContext(), Ib.tew, FavMediaGalleryUI.this.tfo);
                        FavMediaGalleryUI.this.finish();
                        AppMethodBeat.o(107327);
                        return;
                    case 5:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavMediaGalleryUI.this.getContext())) {
                            FavMediaGalleryUI.this.teD.cWf();
                            AppMethodBeat.o(107327);
                            return;
                        }
                        break;
                    case 6:
                        FavMediaGalleryUI.j(FavMediaGalleryUI.this);
                        break;
                }
                AppMethodBeat.o(107327);
                return;
            }
            Log.w("MicroMsg.FavMediaGalleryUI", "file not exists");
            AppMethodBeat.o(107327);
        }
    };
    private Map<String, qz> teB = new HashMap();
    private boolean teC;
    private r teD;
    private long teE;
    private IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass5 */

        {
            AppMethodBeat.i(235343);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(235343);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(235344);
            qz qzVar2 = qzVar;
            FavMediaGalleryUI.this.teB.put(qzVar2.dXz.filePath, qzVar2);
            if (FavMediaGalleryUI.this.tjU != null && FavMediaGalleryUI.this.tjU.isShowing()) {
                FavMediaGalleryUI.f(FavMediaGalleryUI.this);
            }
            AppMethodBeat.o(235344);
            return true;
        }
    };
    private int tex = 0;
    and tfo = new and();
    private int tjR = -1;
    private FavVideoView tjS = null;
    private a tjT;
    private e tjU;
    private List<FavVideoView> tjV = new ArrayList();
    private HashMap<String, List<View>> tjW = new HashMap<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.tencent.mm.plugin.scanner.word.a.AbstractC1683a
    public final /* synthetic */ void M(String str, com.tencent.mm.plugin.scanner.word.b bVar) {
        boolean z;
        AppMethodBeat.i(107352);
        com.tencent.mm.plugin.scanner.word.b bVar2 = bVar;
        String cVV = cVV();
        int gw = com.tencent.mm.plugin.scanner.i.gw(bVar2.CVF);
        Log.i("MicroMsg.FavMediaGalleryUI", "local translate, img %s, result %s, ratio %d", cVV, bVar2.CVF, Integer.valueOf(gw));
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
        AppMethodBeat.o(107352);
    }

    public FavMediaGalleryUI() {
        AppMethodBeat.i(107341);
        AppMethodBeat.o(107341);
    }

    static /* synthetic */ void a(FavMediaGalleryUI favMediaGalleryUI, boolean z) {
        AppMethodBeat.i(107354);
        favMediaGalleryUI.ks(z);
        AppMethodBeat.o(107354);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a7_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(107342);
        super.onCreate(bundle);
        if (d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.teD = new r(this, this, this);
        this.dUo = getIntent().getBooleanExtra("show_share", true);
        this.jUy = (MMGestureGallery) findViewById(R.id.dci);
        this.jUy.setVerticalFadingEdgeEnabled(false);
        this.jUy.setHorizontalFadingEdgeEnabled(false);
        this.jUy.setOnItemSelectedListener(this);
        this.jUy.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                AppMethodBeat.i(107320);
                i Ib = FavMediaGalleryUI.this.tjT.Ib(FavMediaGalleryUI.this.tex);
                if (Ib != null && Ib.dKT.Lwv == 0 && Ib.dKT.dataType != 2 && s.YS(com.tencent.mm.plugin.fav.a.b.d(Ib.dKT))) {
                    List<View> list = (List) FavMediaGalleryUI.this.tjW.get(com.tencent.mm.plugin.fav.a.b.d(Ib.dKT));
                    if (list != null && list.size() > 0) {
                        for (View view : list) {
                            if (view instanceof FavVideoView) {
                                ((FavVideoView) view).cWU();
                            }
                        }
                        AppMethodBeat.o(107320);
                        return;
                    }
                }
                if (FavMediaGalleryUI.d(FavMediaGalleryUI.this) && FavMediaGalleryUI.this.teD.tgN != 1) {
                    FavMediaGalleryUI.this.finish();
                }
                AppMethodBeat.o(107320);
            }
        });
        if (this.dUo) {
            this.jUy.setLongClickOverListener(new MMGestureGallery.c() {
                /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.tools.MMGestureGallery.c
                public final void bmu() {
                    AppMethodBeat.i(107323);
                    if (!FavMediaGalleryUI.this.isFinishing() && !FavMediaGalleryUI.this.activityHasDestroyed()) {
                        if (!FavMediaGalleryUI.d(FavMediaGalleryUI.this)) {
                            FavMediaGalleryUI.f(FavMediaGalleryUI.this);
                        } else if (FavMediaGalleryUI.this.teD.tgN == 1) {
                            AppMethodBeat.o(107323);
                            return;
                        } else if (FavMediaGalleryUI.this.teD.tgN == 0 || FavMediaGalleryUI.this.teD.tgN == 2) {
                            FavMediaGalleryUI.a(FavMediaGalleryUI.this, com.tencent.mm.plugin.scanner.i.eOQ());
                            AppMethodBeat.o(107323);
                            return;
                        } else {
                            FavMediaGalleryUI.f(FavMediaGalleryUI.this);
                            AppMethodBeat.o(107323);
                            return;
                        }
                    }
                    AppMethodBeat.o(107323);
                }
            });
        }
        fullScreenNoTitleBar(true);
        this.kgc = new ArrayList<>();
        this.tjT = new a(this, (byte) 0);
        this.jUy.setAdapter((SpinnerAdapter) this.tjT);
        and();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107324);
                FavMediaGalleryUI.this.finish();
                AppMethodBeat.o(107324);
                return true;
            }
        });
        EventCenter.instance.addListener(this.teF);
        setResult(0, getIntent());
        this.tfo.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
        this.tfo.pHw = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
        this.tfo.index = getIntent().getIntExtra("key_detail_fav_index", 0);
        this.tfo.query = getIntent().getStringExtra("key_detail_fav_query");
        this.tfo.sessionId = getIntent().getStringExtra("key_detail_fav_sessionid");
        this.tfo.tay = getIntent().getStringExtra("key_detail_fav_tags");
        this.tfo.query = this.tfo.query == null ? "" : this.tfo.query;
        this.tfo.sessionId = this.tfo.sessionId == null ? "" : this.tfo.sessionId;
        and and = this.tfo;
        if (this.tfo.tay == null) {
            str = "";
        } else {
            str = this.tfo.tay;
        }
        and.tay = str;
        AppMethodBeat.o(107342);
    }

    private void ks(boolean z) {
        AppMethodBeat.i(107343);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        i Ib = this.tjT.Ib(this.tex);
        if (Ib == null) {
            AppMethodBeat.o(107343);
            return;
        }
        if (Ib.dKT.Lwv != 0) {
            Log.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
        } else if (Ib.dKT.dataType == 2) {
            if (Ib.tew != null && Ib.tew.cUu()) {
                arrayList.add(0);
                arrayList2.add(getString(R.string.cc8));
            }
            if (Ib.tew != null && Ib.tew.cUv()) {
                arrayList.add(1);
                arrayList2.add(getString(R.string.cau));
            }
            arrayList.add(2);
            arrayList2.add(getString(R.string.cc1));
            String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
            qz qzVar = this.teB.get(d2);
            if (qzVar == null) {
                qx qxVar = new qx();
                qxVar.dXu.dDZ = System.currentTimeMillis();
                qxVar.dXu.filePath = d2;
                EventCenter.instance.publish(qxVar);
            } else if (!Util.isNullOrNil(qzVar.dXz.result)) {
                arrayList.add(3);
                if (com.tencent.mm.plugin.scanner.g.ca(qzVar.dXz.dFL, qzVar.dXz.result)) {
                    arrayList2.add(getString(R.string.cb4));
                } else if (com.tencent.mm.plugin.scanner.g.cb(qzVar.dXz.dFL, qzVar.dXz.result)) {
                    arrayList2.add(getString(R.string.cb1));
                } else {
                    arrayList2.add(getString(R.string.cb3));
                }
            }
            if (this.teC && !Util.isNullOrNil(d2)) {
                arrayList.add(5);
                arrayList2.add(getString(R.string.az0));
            }
            arrayList.add(6);
            arrayList2.add(getString(R.string.ayz));
            if (!Util.isNullOrNil(d2)) {
                g.aAi();
                if (g.aAg().hqi.aYS() != 0 && z) {
                    this.teD.scan(d2);
                }
            }
        } else if (s.YS(com.tencent.mm.plugin.fav.a.b.d(Ib.dKT))) {
            if (Ib.tew != null && Ib.tew.cUu()) {
                arrayList.add(0);
                arrayList2.add(getString(R.string.cc8));
            }
            arrayList.add(2);
            arrayList2.add(getString(R.string.gav));
        }
        arrayList.add(4);
        arrayList2.add(getString(R.string.c_q));
        if (this.tjU == null) {
            this.tjU = new e((Context) getContext(), 1, false);
        }
        this.tjU.HLX = new o.f() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(107325);
                mVar.clear();
                mVar.setHeaderTitle("");
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    mVar.d(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                }
                AppMethodBeat.o(107325);
            }
        };
        this.tjU.HLY = this.rjz;
        this.tjU.PGl = new e.b() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(107326);
                FavMediaGalleryUI.this.tjU = null;
                AppMethodBeat.o(107326);
            }
        };
        this.tjU.dGm();
        AppMethodBeat.o(107343);
    }

    private void and() {
        int i2;
        com.tencent.mm.plugin.fav.a.g gVar;
        AppMethodBeat.i(107344);
        long[] longArrayExtra = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
        ArrayList arrayList = new ArrayList();
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        this.teE = getIntent().getLongExtra("key_detail_info_id", -1);
        if (longArrayExtra == null) {
            boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
            String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
            com.tencent.mm.plugin.fav.a.g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(this.teE);
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.teE);
            objArr[1] = Boolean.valueOf(DY != null);
            Log.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", objArr);
            if (!booleanExtra || Util.isNullOrNil(stringExtra2)) {
                gVar = DY;
            } else {
                gVar = com.tencent.mm.plugin.fav.a.b.arO(stringExtra2);
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
        } else {
            for (long j2 : longArrayExtra) {
                com.tencent.mm.plugin.fav.a.g DY2 = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(j2);
                if (DY2 != null && !arrayList.contains(DY2)) {
                    arrayList.add(DY2);
                }
            }
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
                if ((aml.dataType != 8 || ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(aml))) && (aml.dataType == 2 || aml.dataType == 4 || aml.dataType == 15 || aml.dataType == 8)) {
                    this.kgc.add(new i(gVar2, aml));
                    if (stringExtra != null && stringExtra.equals(aml.dLl) && gVar2.field_localId == this.teE) {
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
        this.tjT.notifyDataSetChanged();
        if (i3 >= 0) {
            Log.i("MicroMsg.FavMediaGalleryUI", "pre match selection %d", Integer.valueOf(i3));
            this.jUy.setSelection(i3);
            this.tex = i3;
        }
        this.jUy.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(107330);
                if (i3 != -1) {
                    Log.d("MicroMsg.FavMediaGalleryUI", "match selection %d", Integer.valueOf(i3));
                    FavMediaGalleryUI.this.jUy.setSelection(i3);
                    FavMediaGalleryUI.this.tex = i3;
                    AppMethodBeat.o(107330);
                } else if (FavMediaGalleryUI.this.tex - 1 >= 0 && FavMediaGalleryUI.this.tex - 1 < FavMediaGalleryUI.this.kgc.size()) {
                    Log.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", Integer.valueOf(FavMediaGalleryUI.this.tex - 1), Integer.valueOf(FavMediaGalleryUI.this.kgc.size()));
                    FavMediaGalleryUI.this.jUy.setSelection(FavMediaGalleryUI.this.tex - 1);
                    FavMediaGalleryUI.this.tex--;
                    AppMethodBeat.o(107330);
                } else if (FavMediaGalleryUI.this.kgc.size() > 0) {
                    Log.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", Integer.valueOf(FavMediaGalleryUI.this.kgc.size()));
                    FavMediaGalleryUI.this.jUy.setSelection(0);
                    FavMediaGalleryUI.this.tex = 0;
                    AppMethodBeat.o(107330);
                } else {
                    Log.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", Integer.valueOf(FavMediaGalleryUI.this.kgc.size()));
                    FavMediaGalleryUI.this.finish();
                    AppMethodBeat.o(107330);
                }
            }
        });
        AppMethodBeat.o(107344);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107345);
        getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
        EventCenter.instance.removeListener(this.teF);
        for (FavVideoView favVideoView : this.tjV) {
            if (favVideoView != null) {
                favVideoView.onDestroy();
            }
        }
        if (this.teD != null) {
            this.teD.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(107345);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107346);
        super.onResume();
        ((af) g.ah(af.class)).getFavCdnStorage().a(this);
        f.e(true, true, true);
        AppMethodBeat.o(107346);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(107347);
        super.onPause();
        ((af) g.ah(af.class)).getFavCdnStorage().b(this);
        f.e(false, true, true);
        AppMethodBeat.o(107347);
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String cVV() {
        AppMethodBeat.i(107348);
        i Ib = this.tjT.Ib(this.tex);
        if (Ib == null) {
            AppMethodBeat.o(107348);
            return "";
        } else if (Ib.dKT.dataType == 2) {
            String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
            AppMethodBeat.o(107348);
            return d2;
        } else {
            AppMethodBeat.o(107348);
            return "";
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String getFileId() {
        AppMethodBeat.i(235349);
        i Ib = this.tjT.Ib(this.tex);
        if (Ib == null || Ib.dKT == null) {
            AppMethodBeat.o(235349);
            return null;
        }
        String str = Ib.dKT.KuR;
        AppMethodBeat.o(235349);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String getAesKey() {
        AppMethodBeat.i(235350);
        i Ib = this.tjT.Ib(this.tex);
        if (Ib == null || Ib.dKT == null) {
            AppMethodBeat.o(235350);
            return null;
        }
        String str = Ib.dKT.Lvp;
        AppMethodBeat.o(235350);
        return str;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        SparseBooleanArray teP;

        private a() {
            AppMethodBeat.i(107332);
            this.teP = new SparseBooleanArray();
            AppMethodBeat.o(107332);
        }

        /* synthetic */ a(FavMediaGalleryUI favMediaGalleryUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(107340);
            i Ib = Ib(i2);
            AppMethodBeat.o(107340);
            return Ib;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(107333);
            if (i2 > FavMediaGalleryUI.this.kgc.size()) {
                AppMethodBeat.o(107333);
                return 2;
            }
            int i3 = ((i) FavMediaGalleryUI.this.kgc.get(i2)).dKT.dataType;
            AppMethodBeat.o(107333);
            return i3;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getCount() {
            AppMethodBeat.i(107334);
            int size = FavMediaGalleryUI.this.kgc.size();
            AppMethodBeat.o(107334);
            return size;
        }

        public final i Ib(int i2) {
            AppMethodBeat.i(107335);
            if (i2 >= FavMediaGalleryUI.this.kgc.size()) {
                Log.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", Integer.valueOf(i2));
                AppMethodBeat.o(107335);
                return null;
            }
            i iVar = (i) FavMediaGalleryUI.this.kgc.get(i2);
            AppMethodBeat.o(107335);
            return iVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            ArrayList arrayList;
            b bVar;
            String str;
            AppMethodBeat.i(107336);
            i Ib = Ib(i2);
            if (FavMediaGalleryUI.this.tex != i2 && Math.abs(FavMediaGalleryUI.this.tex - i2) > 1) {
                Log.i("MicroMsg.FavMediaGalleryUI", "getView not selected, " + FavMediaGalleryUI.this.tex + ", " + i2);
                if (view == null) {
                    if (Ib.dKT.dataType == 15 || Ib.dKT.dataType == 4) {
                        view = new FavVideoView(FavMediaGalleryUI.this.getContext());
                    } else {
                        b bVar2 = new b(FavMediaGalleryUI.this, (byte) 0);
                        view = View.inflate(FavMediaGalleryUI.this.getContext(), R.layout.a79, null);
                        bVar2.teS = view.findViewById(R.id.dvp);
                        bVar2.teT = (MultiTouchImageView) view.findViewById(R.id.dup);
                        bVar2.progressBar = (ProgressBar) view.findViewById(R.id.buu);
                        bVar2.mEx = (ImageView) view.findViewById(R.id.imb);
                        bVar2.teU = (TextView) view.findViewById(R.id.buv);
                        bVar2.teV = (LinearLayout) view.findViewById(R.id.cbv);
                        bVar2.teW = (TextView) view.findViewById(R.id.cbw);
                        bVar2.teW.setText(R.string.c9d);
                        view.setTag(bVar2);
                    }
                }
                AppMethodBeat.o(107336);
                return view;
            } else if (Ib.dKT.dataType == 15 || Ib.dKT.dataType == 4) {
                if (view == null) {
                    view2 = new FavVideoView(FavMediaGalleryUI.this.getContext());
                    FavMediaGalleryUI.this.tjV.add((FavVideoView) view2);
                } else {
                    view2 = view;
                }
                String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
                List list = (List) FavMediaGalleryUI.this.tjW.get(d2);
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = list;
                }
                arrayList.add((FavVideoView) view2);
                FavMediaGalleryUI.this.tjW.put(d2, arrayList);
                FavVideoView favVideoView = (FavVideoView) view2;
                favVideoView.tjm.setVisibility(8);
                favVideoView.setCallback(new FavVideoView.b() {
                    /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.a.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b
                    public final void finish() {
                        AppMethodBeat.i(107331);
                        FavMediaGalleryUI.this.finish();
                        AppMethodBeat.o(107331);
                    }
                });
                if (s.YS(d2)) {
                    favVideoView.setVideoData(d2);
                } else {
                    String str2 = Ib.dKT.dLl;
                    com.tencent.mm.plugin.fav.a.c asa = ((af) g.ah(af.class)).getFavCdnStorage().asa(str2);
                    if (asa == null || asa.field_status != 1) {
                        if (Util.isNullOrNil(Ib.dKT.KuR) || Util.isNullOrNil(Ib.dKT.Lvp)) {
                            Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
                            favVideoView.c(d2, false, str2);
                            favVideoView.tjm.setVisibility(0);
                        } else {
                            Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", str2);
                            com.tencent.mm.plugin.fav.a.b.a(Ib.tew, Ib.dKT, true);
                            favVideoView.c(d2, true, str2);
                        }
                    }
                }
                String a2 = com.tencent.mm.plugin.fav.a.b.a(Ib.dKT);
                if (s.YS(a2)) {
                    favVideoView.setThumbView(a2);
                } else {
                    Log.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", a2);
                    com.tencent.mm.plugin.fav.a.b.a(Ib.tew, Ib.dKT);
                }
                AppMethodBeat.o(107336);
                return view2;
            } else {
                if (view == null) {
                    bVar = new b(FavMediaGalleryUI.this, (byte) 0);
                    view = View.inflate(FavMediaGalleryUI.this.getContext(), R.layout.a79, null);
                    bVar.teS = view.findViewById(R.id.dvp);
                    bVar.teT = (MultiTouchImageView) view.findViewById(R.id.dup);
                    bVar.progressBar = (ProgressBar) view.findViewById(R.id.buu);
                    bVar.mEx = (ImageView) view.findViewById(R.id.imb);
                    bVar.teU = (TextView) view.findViewById(R.id.buv);
                    bVar.teV = (LinearLayout) view.findViewById(R.id.cbv);
                    bVar.teW = (TextView) view.findViewById(R.id.cbw);
                    bVar.teW.setText(R.string.c9d);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                boolean z = this.teP.get(i2, true);
                this.teP.put(i2, false);
                Bitmap a3 = com.tencent.mm.plugin.fav.ui.o.a(Ib.dKT, Ib.tew, z);
                if (Ib.tew != null) {
                    Log.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", Integer.valueOf(i2), Integer.valueOf(Ib.tew.field_id), Long.valueOf(Ib.tew.field_localId), Integer.valueOf(Ib.tew.field_itemStatus));
                }
                if (Ib.dKT != null) {
                    Log.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", Ib.dKT.dLl, Ib.dKT.KuR, Ib.dKT.Lvp, Long.valueOf(Ib.dKT.LvI), Ib.dKT.iwX, Ib.dKT.Lvk, Long.valueOf(Ib.dKT.LvT));
                }
                if (a3 == null) {
                    FavMediaGalleryUI.this.enableOptionMenu(false);
                    Log.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
                    q favCdnStorage = ((af) g.ah(af.class)).getFavCdnStorage();
                    if (Ib.dKT != null) {
                        str = Ib.dKT.dLl;
                    } else {
                        str = "";
                    }
                    com.tencent.mm.plugin.fav.a.c asa2 = favCdnStorage.asa(str);
                    if (asa2 == null) {
                        bVar.teV.setVisibility(8);
                        if (Ib.tew == null || Ib.tew.field_id >= 0) {
                            bVar.progressBar.setVisibility(8);
                            bVar.teU.setVisibility(8);
                            bVar.mEx.setVisibility(8);
                            bVar.teS.setVisibility(0);
                            if (Ib.dKT.Lwv != 0) {
                                bVar.teV.setVisibility(0);
                            }
                            b(bVar, a(Ib), "");
                        } else {
                            bVar.progressBar.setVisibility(0);
                            bVar.teU.setVisibility(0);
                            bVar.mEx.setVisibility(0);
                            bVar.teS.setVisibility(8);
                            bVar.mEx.setImageBitmap(a(Ib));
                            bVar.progressBar.setProgress(0);
                            bVar.teU.setText("0%");
                        }
                        AppMethodBeat.o(107336);
                        return view;
                    }
                    Log.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", Integer.valueOf(asa2.field_status));
                    bVar.progressBar.setVisibility(0);
                    bVar.teU.setVisibility(0);
                    bVar.mEx.setVisibility(0);
                    bVar.teS.setVisibility(8);
                    bVar.mEx.setImageBitmap(a(Ib));
                    int i3 = asa2.field_totalLen > 0 ? ((asa2.field_offset * 100) / asa2.field_totalLen) - 1 : 0;
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    bVar.progressBar.setProgress(i3);
                    bVar.teU.setText(i3 + "%");
                    AppMethodBeat.o(107336);
                    return view;
                }
                FavMediaGalleryUI.this.enableOptionMenu(true);
                if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(Ib.dKT))) {
                    a(bVar, a3, com.tencent.mm.plugin.fav.a.b.d(Ib.dKT));
                } else {
                    a(bVar, a3, "");
                }
                AppMethodBeat.o(107336);
                return view;
            }
        }

        private void a(b bVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(107337);
            bVar.progressBar.setVisibility(8);
            bVar.teU.setVisibility(8);
            bVar.mEx.setVisibility(8);
            bVar.teS.setVisibility(0);
            bVar.teV.setVisibility(8);
            b(bVar, bitmap, str);
            AppMethodBeat.o(107337);
        }

        private Bitmap a(i iVar) {
            Bitmap a2;
            AppMethodBeat.i(107338);
            if (iVar == null || (a2 = com.tencent.mm.plugin.fav.ui.o.a(iVar.dKT, iVar.tew)) == null) {
                Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(FavMediaGalleryUI.this.getResources(), R.raw.download_image_icon);
                AppMethodBeat.o(107338);
                return decodeResource;
            }
            AppMethodBeat.o(107338);
            return a2;
        }

        private void b(b bVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(107339);
            ForceGpuUtil.decideLayerType(bVar.teT, bitmap.getWidth(), bitmap.getHeight());
            int width = bVar.teT.getWidth();
            int height = bVar.teT.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            Log.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
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
                    Log.d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(height7)));
                    matrix.postTranslate(0.0f, height7);
                }
            }
            bVar.teT.setImageMatrix(matrix);
            bVar.teT.cN(bitmap.getWidth(), bitmap.getHeight());
            bVar.teT.setMaxZoomDoubleTab(true);
            if (Util.isNullOrNil(str)) {
                bVar.teT.setImageBitmap(bitmap);
                AppMethodBeat.o(107339);
                return;
            }
            try {
                com.tencent.mm.plugin.gif.d dVar = new com.tencent.mm.plugin.gif.d(str);
                bVar.teT.setGifDrawable(dVar);
                bVar.teT.kY(com.tencent.mm.cb.a.jn(FavMediaGalleryUI.this.getContext()), com.tencent.mm.cb.a.jo(FavMediaGalleryUI.this.getContext()));
                bVar.teT.cN(dVar.getIntrinsicWidth(), dVar.getIntrinsicHeight());
                bVar.teT.start();
                bVar.teT.gKz();
                AppMethodBeat.o(107339);
            } catch (Exception e2) {
                Log.e("MicroMsg.FavMediaGalleryUI", Util.stackTraceToString(e2));
                bVar.teT.setImageBitmap(bitmap);
                AppMethodBeat.o(107339);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(107349);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        this.tex = i2;
        Log.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(i2)));
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).gKy();
        }
        if (this.tjS != null) {
            this.tjS.onDestroy();
        }
        if (view instanceof FavVideoView) {
            FavVideoView favVideoView = (FavVideoView) view;
            if ((this.tjT.getItemViewType(i2) == 15 || this.tjT.getItemViewType(i2) == 4) && favVideoView != null && !favVideoView.isPlaying()) {
                favVideoView.onResume();
                this.tjS = favVideoView;
                this.tjR = i2;
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(107349);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* access modifiers changed from: package-private */
    public class b {
        ImageView mEx;
        ProgressBar progressBar;
        View teS;
        MultiTouchImageView teT;
        TextView teU;
        LinearLayout teV;
        TextView teW;

        private b() {
        }

        /* synthetic */ b(FavMediaGalleryUI favMediaGalleryUI, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.p
    public final void e(final com.tencent.mm.plugin.fav.a.c cVar) {
        i Ib;
        AppMethodBeat.i(107350);
        if (cVar != null && (Ib = this.tjT.Ib(this.tex)) != null && Util.nullAs(cVar.field_dataId, "").equals(Ib.dKT.dLl) && Ib.dKT.dataType == 2) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass2 */

                public final void run() {
                    int i2 = 0;
                    AppMethodBeat.i(107321);
                    View selectedView = FavMediaGalleryUI.this.jUy.getSelectedView();
                    if (selectedView == null) {
                        AppMethodBeat.o(107321);
                    } else if (selectedView.getTag() == null || !(selectedView.getTag() instanceof b)) {
                        AppMethodBeat.o(107321);
                    } else {
                        b bVar = (b) selectedView.getTag();
                        int i3 = cVar.field_totalLen > 0 ? ((cVar.field_offset * 100) / cVar.field_totalLen) - 1 : 0;
                        if (i3 >= 0) {
                            i2 = i3;
                        }
                        bVar.progressBar.setProgress(i2);
                        bVar.teU.setText(i2 + "%");
                        if (i2 >= 100 || cVar.isFinished()) {
                            FavMediaGalleryUI.this.tjT.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(107321);
                    }
                }
            });
        }
        AppMethodBeat.o(107350);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(107351);
        if (1 == i2) {
            if (-1 != i3) {
                AppMethodBeat.o(107351);
                return;
            }
            i Ib = this.tjT.Ib(this.tex);
            if (Ib == null) {
                Log.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
                AppMethodBeat.o(107351);
                return;
            }
            String d2 = com.tencent.mm.plugin.fav.a.b.d(Ib.dKT);
            new k();
            if (k.v(Ib.tew)) {
                com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.f3146c));
                AppMethodBeat.o(107351);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
            Log.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", stringExtra);
            final com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            if (ImgUtil.isGif(d2)) {
                for (String str : stringsToList) {
                    l.a(getContext(), str, Ib.tew, Ib.dKT, new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(235341);
                            a2.dismiss();
                            AppMethodBeat.o(235341);
                        }
                    });
                }
            } else {
                AnonymousClass4 r4 = new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(235342);
                        a2.dismiss();
                        AppMethodBeat.o(235342);
                    }
                };
                for (String str2 : stringsToList) {
                    l.a(this, str2, Ib.dKT, r4);
                }
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(107351);
    }

    static /* synthetic */ boolean d(FavMediaGalleryUI favMediaGalleryUI) {
        AppMethodBeat.i(107353);
        i Ib = favMediaGalleryUI.tjT.Ib(favMediaGalleryUI.tex);
        if (Ib == null || Ib.dKT.dataType != 2) {
            AppMethodBeat.o(107353);
            return false;
        }
        AppMethodBeat.o(107353);
        return true;
    }

    static /* synthetic */ void f(FavMediaGalleryUI favMediaGalleryUI) {
        AppMethodBeat.i(107355);
        favMediaGalleryUI.ks(false);
        AppMethodBeat.o(107355);
    }

    static /* synthetic */ void a(FavMediaGalleryUI favMediaGalleryUI, String str) {
        AppMethodBeat.i(107356);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FavMediaGalleryUI", "save image fail, path is null");
            AppMethodBeat.o(107356);
            return;
        }
        com.tencent.mm.platformtools.p.a(favMediaGalleryUI, str, new p.a() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass12 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(235347);
                Toast.makeText(FavMediaGalleryUI.this, FavMediaGalleryUI.this.getString(R.string.bjr, new Object[]{AndroidMediaUtil.getToastSysCameraPath()}), 1).show();
                AppMethodBeat.o(235347);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(235348);
                Toast.makeText(FavMediaGalleryUI.this, FavMediaGalleryUI.this.getString(R.string.cc0), 1).show();
                AppMethodBeat.o(235348);
            }
        });
        AppMethodBeat.o(107356);
    }

    static /* synthetic */ void b(FavMediaGalleryUI favMediaGalleryUI, final String str) {
        AppMethodBeat.i(107357);
        com.tencent.mm.platformtools.p.b(favMediaGalleryUI.getContext(), str, new p.a() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.AnonymousClass11 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(235345);
                Log.i("MicroMsg.FavMediaGalleryUI", "save video now video path %s out path %s", str, str2);
                Toast.makeText(FavMediaGalleryUI.this.getContext(), FavMediaGalleryUI.this.getString(R.string.hwu, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(str2, FavMediaGalleryUI.this.getContext());
                AppMethodBeat.o(235345);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(235346);
                Log.i("MicroMsg.FavMediaGalleryUI", "save video now video path %s out path %s", str, str2);
                Toast.makeText(FavMediaGalleryUI.this.getContext(), FavMediaGalleryUI.this.getString(R.string.hwt), 1).show();
                AppMethodBeat.o(235346);
            }
        });
        AppMethodBeat.o(107357);
    }

    static /* synthetic */ void j(FavMediaGalleryUI favMediaGalleryUI) {
        AppMethodBeat.i(107358);
        String cVV = favMediaGalleryUI.cVV();
        Log.i("MicroMsg.FavMediaGalleryUI", "edit image path:%s msgId:%s", cVV, 0L);
        RecordConfigProvider jA = RecordConfigProvider.jA(cVV, "");
        jA.scene = 0;
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(true);
        jA.BOn = aVar.gLU;
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(favMediaGalleryUI.getContext(), 4369, R.anim.ei, -1, jA, 1, 2);
        AppMethodBeat.o(107358);
    }
}
