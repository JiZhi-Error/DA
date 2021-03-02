package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.ui.d;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI extends MMActivity implements d.a, r.a, com.tencent.mm.plugin.record.a.d, a.AbstractC1683a<String, com.tencent.mm.plugin.scanner.word.b> {
    private n BIn;
    private a BIv;
    private String BIw = null;
    private List<aml> gzD = new LinkedList();
    private MMGestureGallery jUy;
    private ScanCodeSheetItemLogic mHu;
    private long msgId = -1;
    private o.g rjz = new o.g() {
        /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass13 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(27953);
            switch (menuItem.getItemId()) {
                case 0:
                    RecordMsgImageUI.k(RecordMsgImageUI.this);
                    AppMethodBeat.o(27953);
                    return;
                case 1:
                    RecordMsgImageUI recordMsgImageUI = RecordMsgImageUI.this;
                    cz czVar = new cz();
                    h.a(czVar, recordMsgImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), recordMsgImageUI.eIC());
                    czVar.dFZ.dGf = 10;
                    czVar.dFZ.activity = recordMsgImageUI;
                    EventCenter.instance.publish(czVar);
                    AppMethodBeat.o(27953);
                    return;
                case 2:
                    RecordMsgImageUI.l(RecordMsgImageUI.this);
                    AppMethodBeat.o(27953);
                    return;
                case 4:
                    if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(RecordMsgImageUI.this.getContext())) {
                        ep epVar = new ep();
                        epVar.ejA = 3;
                        epVar.eDV = 5;
                        int selectedItemPosition = RecordMsgImageUI.this.jUy.getSelectedItemPosition();
                        if (-1 != selectedItemPosition) {
                            aml Vw = RecordMsgImageUI.this.BIv.Vw(selectedItemPosition);
                            epVar.rK(Vw.KuR);
                            epVar.rL(Vw.Lvp);
                        }
                        epVar.bfK();
                        RecordMsgImageUI.this.teD.cWf();
                        AppMethodBeat.o(27953);
                        return;
                    }
                    break;
                case 5:
                    RecordMsgImageUI.m(RecordMsgImageUI.this);
                    break;
            }
            AppMethodBeat.o(27953);
        }
    };
    private int selection = 0;
    private Runnable tdl = new Runnable() {
        /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(27944);
            RecordMsgImageUI.this.BIv.notifyDataSetChanged();
            AppMethodBeat.o(27944);
        }
    };
    private d teA;
    private Map<String, b> teB = new HashMap();
    private boolean teC;
    private r teD;
    private IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass5 */

        {
            AppMethodBeat.i(161427);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(161427);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(27945);
            qz qzVar2 = qzVar;
            String str = qzVar2.dXz.filePath;
            b bVar = new b((byte) 0);
            bVar.teQ = qzVar2;
            RecordMsgImageUI.this.teB.put(str, bVar);
            if (RecordMsgImageUI.this.tez != null && RecordMsgImageUI.this.tez.isShowing()) {
                RecordMsgImageUI.g(RecordMsgImageUI.this);
            }
            AppMethodBeat.o(27945);
            return true;
        }
    };
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
        AppMethodBeat.i(27973);
        com.tencent.mm.plugin.scanner.word.b bVar2 = bVar;
        String eIC = eIC();
        int gw = i.gw(bVar2.CVF);
        Log.i("MicroMsg.ShowImageUI", "local translate, img %s, result %s, ratio %d", eIC, bVar2.CVF, Integer.valueOf(gw));
        if (str.equals(eIC)) {
            if (gw > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.teC = true;
                ep epVar = new ep();
                epVar.ejA = 2;
                epVar.eDV = 5;
                int selectedItemPosition = this.jUy.getSelectedItemPosition();
                if (-1 != selectedItemPosition) {
                    aml Vw = this.BIv.Vw(selectedItemPosition);
                    epVar.rK(Vw.KuR);
                    epVar.rL(Vw.Lvp);
                }
                epVar.bfK();
                ks(false);
            }
        }
        AppMethodBeat.o(27973);
    }

    public RecordMsgImageUI() {
        AppMethodBeat.i(27959);
        AppMethodBeat.o(27959);
    }

    static /* synthetic */ void a(RecordMsgImageUI recordMsgImageUI, boolean z) {
        AppMethodBeat.i(27974);
        recordMsgImageUI.ks(z);
        AppMethodBeat.o(27974);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bsh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27960);
        super.onCreate(bundle);
        hideTitleView();
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.teD = new r(this, this, this);
        this.BIn = new n();
        this.msgId = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        c aKY = p.aKY(getIntent().getStringExtra("record_xml"));
        if (aKY == null) {
            Log.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            AppMethodBeat.o(27960);
            return;
        }
        Iterator<aml> it = aKY.iAd.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.dataType == 2) {
                this.gzD.add(next);
                if (next.dLl.equals(stringExtra)) {
                    this.selection = this.gzD.size() - 1;
                }
            }
        }
        if (this.gzD.isEmpty()) {
            Log.w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            AppMethodBeat.o(27960);
            return;
        }
        this.jUy = (MMGestureGallery) findViewById(R.id.dci);
        this.teA = new d(this.jUy, this, this);
        this.jUy.setVerticalFadingEdgeEnabled(false);
        this.jUy.setHorizontalFadingEdgeEnabled(false);
        this.BIv = new a((byte) 0);
        this.BIv.gzD = this.gzD;
        this.BIv.msgId = this.msgId;
        this.BIv.BIn = this.BIn;
        this.jUy.setAdapter((SpinnerAdapter) this.BIv);
        this.jUy.setSelection(this.selection);
        this.jUy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(27940);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgImageUI$1", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (p.d(RecordMsgImageUI.this.BIv.Vw(i2), RecordMsgImageUI.this.msgId)) {
                    RecordMsgImageUI.this.setMMTitle(String.format("%d/%d", Integer.valueOf(i2 + 1), Integer.valueOf(RecordMsgImageUI.this.gzD.size())));
                    RecordMsgImageUI.this.enableOptionMenu(true);
                } else {
                    RecordMsgImageUI.this.enableOptionMenu(false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgImageUI$1", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(27940);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.jUy.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                AppMethodBeat.i(27946);
                if (RecordMsgImageUI.this.teD.tgN != 1) {
                    RecordMsgImageUI.this.teA.mD(false);
                }
                AppMethodBeat.o(27946);
            }
        });
        this.jUy.setLongClickOverListener(new MMGestureGallery.c() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.c
            public final void bmu() {
                AppMethodBeat.i(27947);
                if (RecordMsgImageUI.this.teD.tgN == 1) {
                    AppMethodBeat.o(27947);
                    return;
                }
                ad.b G = ad.aVe().G("basescanui@datacenter", true);
                G.l("key_basescanui_screen_position", Boolean.TRUE);
                G.l("key_basescanui_screen_x", Float.valueOf((float) RecordMsgImageUI.this.jUy.getXDown()));
                G.l("key_basescanui_screen_y", Float.valueOf((float) RecordMsgImageUI.this.jUy.getYDown()));
                ep epVar = new ep();
                epVar.ejA = 1;
                epVar.eDV = 5;
                int selectedItemPosition = RecordMsgImageUI.this.jUy.getSelectedItemPosition();
                if (-1 != selectedItemPosition) {
                    aml Vw = RecordMsgImageUI.this.BIv.Vw(selectedItemPosition);
                    epVar.rK(Vw.KuR);
                    epVar.rL(Vw.Lvp);
                }
                epVar.bfK();
                if (RecordMsgImageUI.this.teD.tgN == 0 || RecordMsgImageUI.this.teD.tgN == 2) {
                    RecordMsgImageUI.a(RecordMsgImageUI.this, i.eOQ());
                    AppMethodBeat.o(27947);
                    return;
                }
                RecordMsgImageUI.g(RecordMsgImageUI.this);
                AppMethodBeat.o(27947);
            }
        });
        fullScreenNoTitleBar(true);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27948);
                RecordMsgImageUI.this.teA.mD(false);
                AppMethodBeat.o(27948);
                return true;
            }
        });
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
        EventCenter.instance.addListener(this.teF);
        this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(27949);
                if (RecordMsgImageUI.this.tez != null && RecordMsgImageUI.this.tez.isShowing()) {
                    RecordMsgImageUI.g(RecordMsgImageUI.this);
                }
                AppMethodBeat.o(27949);
            }
        });
        AppMethodBeat.o(27960);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(27961);
        if (i2 == 4) {
            this.teA.mD(false);
            AppMethodBeat.o(27961);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(27961);
        return onKeyDown;
    }

    private void ks(boolean z) {
        AppMethodBeat.i(27962);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        arrayList.add(0);
        arrayList2.add(getString(R.string.g5j));
        arrayList.add(1);
        arrayList2.add(getString(R.string.fn9));
        arrayList.add(2);
        arrayList2.add(getString(R.string.gaq));
        String eIC = eIC();
        if (this.teC && !Util.isNullOrNil(eIC)) {
            arrayList.add(4);
            arrayList2.add(getString(R.string.az0));
        }
        arrayList.add(5);
        arrayList2.add(getString(R.string.ayz));
        final b bVar = this.teB.get(eIC);
        if (bVar == null || bVar.teQ == null) {
            qx qxVar = new qx();
            qxVar.dXu.dDZ = System.currentTimeMillis();
            qxVar.dXu.filePath = eIC;
            EventCenter.instance.publish(qxVar);
        } else if (!Util.isNullOrNil(bVar.teQ.dXz.result)) {
            arrayList.add(3);
            arrayList2.add("");
        }
        if (!isFinishing()) {
            if (this.tez == null) {
                this.tez = new e((Context) getContext(), 1, false);
            }
            this.tez.HLX = new o.f() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass10 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(27950);
                    RecordMsgImageUI.this.tez.setFooterView(null);
                    mVar.clear();
                    mVar.setHeaderTitle("");
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((Integer) arrayList.get(i2)).intValue() == 3) {
                            RecordMsgImageUI.this.tez.setFooterView(RecordMsgImageUI.a(RecordMsgImageUI.this, bVar));
                        } else {
                            mVar.d(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                        }
                    }
                    AppMethodBeat.o(27950);
                }
            };
            this.tez.HLY = this.rjz;
            this.tez.PGl = new e.b() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass11 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(27951);
                    RecordMsgImageUI.this.tez = null;
                    RecordMsgImageUI.this.mHu.onDismiss();
                    AppMethodBeat.o(27951);
                }
            };
            if (!getContext().isFinishing()) {
                this.tez.dGm();
            }
        }
        if (!Util.isNullOrNil(eIC)) {
            g.aAi();
            if (g.aAg().hqi.aYS() != 0 && z) {
                this.teD.scan(eIC);
            }
        }
        AppMethodBeat.o(27962);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(27963);
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(27963);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(27964);
        super.onResume();
        f.e(true, true, true);
        AppMethodBeat.o(27964);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27965);
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
        this.BIn.destory();
        if (this.teD != null) {
            this.teD.onDestroy();
        }
        if (this.teA != null) {
            this.teA.onDestroy();
        }
        EventCenter.instance.removeListener(this.teF);
        super.onDestroy();
        AppMethodBeat.o(27965);
    }

    /* access modifiers changed from: package-private */
    public final String eIC() {
        AppMethodBeat.i(27966);
        int selectedItemPosition = this.jUy.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            Log.w("MicroMsg.ShowImageUI", "error position");
            AppMethodBeat.o(27966);
            return null;
        }
        String c2 = p.c(this.BIv.Vw(selectedItemPosition), this.msgId);
        Log.d("MicroMsg.ShowImageUI", "cur pos %d path %s", Integer.valueOf(selectedItemPosition), c2);
        AppMethodBeat.o(27966);
        return c2;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.a
    public final MultiTouchImageView cVG() {
        AppMethodBeat.i(27967);
        int selectedItemPosition = this.jUy.getSelectedItemPosition();
        MMGestureGallery mMGestureGallery = this.jUy;
        View childAt = mMGestureGallery.getChildAt(selectedItemPosition - mMGestureGallery.getFirstVisiblePosition());
        if (childAt == null) {
            Log.i("MicroMsg.ShowImageUI", "getCurView() pos:%s firstPos:%s", Integer.valueOf(selectedItemPosition), Integer.valueOf(this.jUy.getFirstVisiblePosition()));
            AppMethodBeat.o(27967);
            return null;
        } else if (childAt instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) childAt;
            AppMethodBeat.o(27967);
            return multiTouchImageView;
        } else {
            MultiTouchImageView multiTouchImageView2 = (MultiTouchImageView) childAt.findViewById(R.id.dvz);
            AppMethodBeat.o(27967);
            return multiTouchImageView2;
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.a
    public final String cVH() {
        AppMethodBeat.i(27968);
        String str = this.BIv.Vw(this.jUy.getSelectedItemPosition()).dLl;
        AppMethodBeat.o(27968);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String cVV() {
        AppMethodBeat.i(27969);
        String eIC = eIC();
        AppMethodBeat.o(27969);
        return eIC;
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String getFileId() {
        AppMethodBeat.i(232044);
        int selectedItemPosition = this.jUy.getSelectedItemPosition();
        if (-1 != selectedItemPosition) {
            String str = this.BIv.Vw(selectedItemPosition).KuR;
            AppMethodBeat.o(232044);
            return str;
        }
        AppMethodBeat.o(232044);
        return null;
    }

    @Override // com.tencent.mm.plugin.fav.ui.r.a
    public final String getAesKey() {
        AppMethodBeat.i(232045);
        int selectedItemPosition = this.jUy.getSelectedItemPosition();
        if (-1 != selectedItemPosition) {
            String str = this.BIv.Vw(selectedItemPosition).Lvp;
            AppMethodBeat.o(232045);
            return str;
        }
        AppMethodBeat.o(232045);
        return null;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        AppMethodBeat.i(27970);
        ao.p(ao.a(getWindow(), (View) null), getBodyView());
        ((ViewGroup) getBodyView().getParent()).removeView(getBodyView());
        ((ViewGroup) getWindow().getDecorView()).addView(getBodyView(), 0);
        AppMethodBeat.o(27970);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27971);
        if (1001 == i2 && -1 == i3) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (Util.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(27971);
                return;
            }
            final ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
            if (Util.isNullOrNil(stringsToList)) {
                Log.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                AppMethodBeat.o(27971);
                return;
            }
            final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            final AnonymousClass2 r3 = new Runnable() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(27941);
                    a2.dismiss();
                    AppMethodBeat.o(27941);
                }
            };
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(27942);
                    for (String str : stringsToList) {
                        com.tencent.mm.plugin.messenger.a.g.eir().a(RecordMsgImageUI.this.getContext(), str, RecordMsgImageUI.this.BIw, 0, "", "", 0, RecordMsgImageUI.o(RecordMsgImageUI.this));
                        com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, str);
                    }
                    MMHandlerThread.postToMainThread(r3);
                    AppMethodBeat.o(27942);
                }

                public final String toString() {
                    AppMethodBeat.i(27943);
                    String str = super.toString() + "|onActivityResult";
                    AppMethodBeat.o(27943);
                    return str;
                }
            });
            AppMethodBeat.o(27971);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(27971);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        n BIn;
        List<aml> gzD;
        long msgId;

        private a() {
            AppMethodBeat.i(27954);
            this.gzD = new LinkedList();
            this.msgId = -1;
            AppMethodBeat.o(27954);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(27958);
            aml Vw = Vw(i2);
            AppMethodBeat.o(27958);
            return Vw;
        }

        public final int getCount() {
            AppMethodBeat.i(27955);
            int size = this.gzD.size();
            AppMethodBeat.o(27955);
            return size;
        }

        public final aml Vw(int i2) {
            AppMethodBeat.i(27956);
            aml aml = this.gzD.get(i2);
            AppMethodBeat.o(27956);
            return aml;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
            if (r0 != false) goto L_0x0041;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
            /*
            // Method dump skipped, instructions count: 184
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.ui.RecordMsgImageUI.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    @Override // com.tencent.mm.plugin.record.a.d
    public final void a(int i2, j jVar) {
        AppMethodBeat.i(27972);
        for (aml aml : this.gzD) {
            if (aml.dLl.equals(jVar.field_dataId)) {
                MMHandlerThread.postToMainThread(this.tdl);
                AppMethodBeat.o(27972);
                return;
            }
        }
        AppMethodBeat.o(27972);
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        qz teQ;
        boolean tiJ;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static /* synthetic */ void g(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(27975);
        recordMsgImageUI.ks(false);
        AppMethodBeat.o(27975);
    }

    static /* synthetic */ View a(RecordMsgImageUI recordMsgImageUI, b bVar) {
        AppMethodBeat.i(27976);
        final qz qzVar = bVar.teQ;
        AnonymousClass12 r1 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgImageUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(27952);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgImageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.ShowImageUI", "request deal QBAR string");
                if (RecordMsgImageUI.this.tez.isShowing()) {
                    RecordMsgImageUI.this.tez.bMo();
                }
                if (qzVar == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgImageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27952);
                    return;
                }
                cr crVar = new cr();
                crVar.dFK.activity = RecordMsgImageUI.this;
                crVar.dFK.dDX = qzVar.dXz.result;
                crVar.dFK.dFL = qzVar.dXz.dFL;
                crVar.dFK.sourceType = 8;
                RecordMsgImageUI.a(RecordMsgImageUI.this, crVar);
                crVar.dFK.dFM = qzVar.dXz.dFM;
                if (RecordMsgImageUI.this.getIntent() != null) {
                    crVar.dFK.dFP = RecordMsgImageUI.this.getIntent().getBundleExtra("_stat_obj");
                }
                EventCenter.instance.publish(crVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgImageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27952);
            }
        };
        if (!bVar.tiJ) {
            bVar.tiJ = true;
            recordMsgImageUI.mHu.cm(qzVar.dXz.dFL, qzVar.dXz.result);
        }
        View a2 = recordMsgImageUI.mHu.a(r1, qzVar.dXz.dFL, qzVar.dXz.result, 5);
        AppMethodBeat.o(27976);
        return a2;
    }

    static /* synthetic */ void a(RecordMsgImageUI recordMsgImageUI, cr crVar) {
        AppMethodBeat.i(27977);
        int selectedItemPosition = recordMsgImageUI.jUy.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            Log.w("MicroMsg.ShowImageUI", "error position");
            AppMethodBeat.o(27977);
            return;
        }
        aml Vw = recordMsgImageUI.BIv.Vw(selectedItemPosition);
        if (Vw != null) {
            crVar.dFK.imagePath = Vw.KuR;
            crVar.dFK.dFO = Vw.Lvp;
        }
        AppMethodBeat.o(27977);
    }

    static /* synthetic */ void k(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(27978);
        recordMsgImageUI.BIw = recordMsgImageUI.eIC();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.BIw);
        com.tencent.mm.br.c.c(recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, 1001);
        AppMethodBeat.o(27978);
    }

    static /* synthetic */ void l(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(27979);
        s.l(recordMsgImageUI.eIC(), recordMsgImageUI.getContext());
        AppMethodBeat.o(27979);
    }

    static /* synthetic */ void m(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(27980);
        String eIC = recordMsgImageUI.eIC();
        Log.i("MicroMsg.ShowImageUI", "edit image path:%s msgId:%s", eIC, Long.valueOf(recordMsgImageUI.msgId));
        RecordConfigProvider jA = RecordConfigProvider.jA(eIC, "");
        jA.scene = 0;
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(true);
        jA.BOn = aVar.gLU;
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(recordMsgImageUI.getContext(), 4369, R.anim.ei, -1, jA, 1, 2);
        AppMethodBeat.o(27980);
    }

    static /* synthetic */ String o(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(163199);
        int selectedItemPosition = recordMsgImageUI.jUy.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            Log.w("MicroMsg.ShowImageUI", "error position");
            AppMethodBeat.o(163199);
            return null;
        }
        String str = recordMsgImageUI.BIv.Vw(selectedItemPosition).jsz;
        AppMethodBeat.o(163199);
        return str;
    }
}
