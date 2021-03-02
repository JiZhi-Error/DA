package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Process;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.b.a.im;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.ab;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsUIAction;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsUserUI extends MMActivity implements i.a {
    private View BdQ;
    private c.a BdS;
    private boolean DNI = false;
    private boolean ELe = false;
    private String ELj;
    private boolean ELk;
    private int ELl;
    private bh EQg;
    private SnsUIAction EQh;
    private aq.a EQi;
    private int EQj;
    private SnsUIAction.a EQk;
    private ImageView EQl = null;
    private FrameLayout EQm = null;
    private RelativeLayout EQn = null;
    private TextView EQo = null;
    private ImageView EQp = null;
    private RelativeLayout EQq = null;
    private RelativeLayout EQr = null;
    private LinearLayout EQs = null;
    private int EQt = 0;
    private int EQu = 0;
    private Long EQv = 0L;
    private int EQw = ax.DOc;
    private m EQx = new m();
    private Animation EQy = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
    private Runnable EQz = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(99629);
            if (SnsUserUI.this.EQg.isSearchMode) {
                SnsUserUI.this.EQg.ffM();
                AppMethodBeat.o(99629);
                return;
            }
            SnsUserUI.this.EQg.fiE();
            SnsUserUI.this.EQg.ffM();
            AppMethodBeat.o(99629);
        }
    };
    private boolean EqY;
    private int gsi;
    private long hlB = 0;
    private long iTC = 0;
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass14 */

        {
            AppMethodBeat.i(203798);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(203798);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(203799);
            mx mxVar2 = mxVar;
            if (mxVar2 instanceof mx) {
                switch (mxVar2.dSE.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        SnsUserUI.this.EQg.notifyDataSetChanged();
                        break;
                }
            }
            AppMethodBeat.o(203799);
            return false;
        }
    };
    private View mContentView = null;
    private String mRa;
    private MenuItem.OnMenuItemClickListener ubB = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass10 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(203796);
            SnsUserUI.this.finish();
            AppMethodBeat.o(203796);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsUserUI() {
        AppMethodBeat.i(99667);
        AppMethodBeat.o(99667);
    }

    static /* synthetic */ void q(SnsUserUI snsUserUI) {
        AppMethodBeat.i(179314);
        snsUserUI.fjS();
        AppMethodBeat.o(179314);
    }

    static /* synthetic */ void r(SnsUserUI snsUserUI) {
        AppMethodBeat.i(203813);
        snsUserUI.fjT();
        AppMethodBeat.o(203813);
    }

    static /* synthetic */ void x(SnsUserUI snsUserUI) {
        AppMethodBeat.i(203814);
        snsUserUI.fjU();
        AppMethodBeat.o(203814);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        as asVar;
        AppMethodBeat.i(99668);
        if (this.mController != null) {
            this.mController.bF(2, false);
        }
        customfixStatusbar(true);
        super.onCreate(bundle);
        if (!g.aAf().azp()) {
            finish();
            AppMethodBeat.o(99668);
            return;
        }
        this.BdQ = findViewById(R.id.c_);
        if (this.BdQ != null && c.Qow) {
            c bt = c.bt(this);
            AnonymousClass6 r1 = new c.a() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.statusbar.c.a
                public final void yf(int i2) {
                    AppMethodBeat.i(203793);
                    SnsUserUI.this.BdQ.setPadding(0, i2, 0, 0);
                    d.e(SnsUserUI.this.getWindow());
                    AppMethodBeat.o(203793);
                }
            };
            this.BdS = r1;
            bt.a(r1);
            getWindow().getDecorView().requestApplyInsets();
            d.e(getWindow());
        }
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        setActionbarColor(getContext().getResources().getColor(R.color.ac_));
        setTitleBarClickListener(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(99638);
                AppMethodBeat.o(99638);
            }
        }, new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(99642);
                AppMethodBeat.o(99642);
            }
        });
        this.EQi = aj.faE();
        this.ELl = getIntent().getIntExtra("sns_source", 0);
        this.mRa = getIntent().getStringExtra("sns_userName");
        this.EQj = getIntent().getIntExtra("sns_rpt_scene", 0);
        if (this.mRa == null) {
            this.mRa = "";
        }
        g.aAi();
        this.ELk = ((l) g.af(l.class)).aSN().bjG(this.mRa);
        this.ELj = z.aTY();
        this.EqY = this.ELj.equals(this.mRa);
        bv faC = aj.faC();
        String nullAs = Util.nullAs(getIntent().getStringExtra("sns_signature"), "");
        String nullAs2 = Util.nullAs(getIntent().getStringExtra("sns_nickName"), "");
        if (this.mRa == null || this.mRa.equals("")) {
            asVar = faC.Kn(this.ELj);
        } else {
            asVar = faC.Kn(this.mRa);
        }
        if (asVar != null && ((int) asVar.gMZ) > 0) {
            nullAs = asVar.signature;
            nullAs2 = asVar.arI();
            Log.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", asVar.field_username, Integer.valueOf((int) asVar.gMZ), nullAs2);
        }
        this.EQh = new SnsUIAction(this);
        this.EQh.a(this.ELj, this.mRa, nullAs2, nullAs, this.ELk, this.EqY, this.ELl);
        SnsUIAction snsUIAction = this.EQh;
        AnonymousClass16 r12 = new SnsUIAction.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass16 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjg() {
                AppMethodBeat.i(99643);
                if (SnsUserUI.this.EQg == null || !SnsUserUI.this.EQg.isSearchMode) {
                    if (SnsUserUI.this.EQi == null) {
                        SnsUserUI.this.EQi = aj.faE();
                    }
                    aq.a aVar = SnsUserUI.this.EQi;
                    String str = SnsUserUI.this.mRa;
                    boolean unused = SnsUserUI.this.ELk;
                    aVar.b(2, str, SnsUserUI.this.EqY, SnsUserUI.this.ELl);
                    aj.dRd().postDelayed(SnsUserUI.this.EQz, 3000);
                } else {
                    SnsUserUI.this.EQi.a(2, SnsUserUI.this.mRa, ax.DOf, SnsUserUI.this.EqY, 0, SnsUserUI.this.ELl);
                    SnsUserUI.this.EQw = ax.DOf;
                }
                if (SnsUserUI.this.EQh != null) {
                    SnsUserUI.this.EQh.fjB();
                }
                AppMethodBeat.o(99643);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final ListView getSnsListView() {
                AppMethodBeat.i(99644);
                ListView listView = (ListView) SnsUserUI.this.findViewById(R.id.hzr);
                AppMethodBeat.o(99644);
                return listView;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final View fjh() {
                AppMethodBeat.i(99645);
                View findViewById = SnsUserUI.this.findViewById(R.id.bf6);
                AppMethodBeat.o(99645);
                return findViewById;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final View getMaskView() {
                AppMethodBeat.i(99646);
                View findViewById = SnsUserUI.this.findViewById(R.id.hxi);
                AppMethodBeat.o(99646);
                return findViewById;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final MMPullDownView fji() {
                AppMethodBeat.i(99647);
                MMPullDownView mMPullDownView = (MMPullDownView) SnsUserUI.this.findViewById(R.id.i00);
                AppMethodBeat.o(99647);
                return mMPullDownView;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final int getType() {
                return 2;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void d(int i2, List<Integer> list, List<Integer> list2) {
                AppMethodBeat.i(99648);
                if (!(i2 == -1 || SnsUserUI.this.EQg == null)) {
                    bh bhVar = SnsUserUI.this.EQg;
                    if (bhVar.EHR != null) {
                        bi biVar = bhVar.EHR;
                        SnsInfo Zr = aj.faO().Zr(i2);
                        if (!(Zr == null || Zr.getTimeLine().ContentObj == null || biVar.list.size() <= 0)) {
                            biVar.list.add(1, Zr);
                            biVar.fiH();
                            biVar.fiI();
                        }
                    }
                }
                if (!(SnsUserUI.this.EQg == null || list == null || list2 == null)) {
                    bh bhVar2 = SnsUserUI.this.EQg;
                    if (bhVar2.isSearchMode) {
                        if (bhVar2.EHS != null) {
                            if (list == null || list2 == null || list.size() + list2.size() == 0) {
                                AppMethodBeat.o(99648);
                                return;
                            }
                            bj bjVar = bhVar2.EHS;
                            if (!(list == null || list.size() == 0)) {
                                Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "remove Items");
                                for (Integer num : list) {
                                    int intValue = num.intValue();
                                    int size = bjVar.list.size();
                                    int i3 = 1;
                                    while (true) {
                                        if (i3 >= size) {
                                            break;
                                        }
                                        SnsInfo snsInfo = bjVar.list.get(i3);
                                        if (snsInfo != null && snsInfo.localid == intValue) {
                                            bjVar.list.remove(i3);
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                            }
                            if (!(list2 == null || list2.size() == 0)) {
                                Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "change Items");
                                LinkedList linkedList = new LinkedList();
                                int i4 = 1;
                                while (i4 < bjVar.list.size()) {
                                    SnsInfo snsInfo2 = bjVar.list.get(i4);
                                    if (snsInfo2 != null) {
                                        Iterator<Integer> it = list2.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            int intValue2 = it.next().intValue();
                                            if (snsInfo2.localid == intValue2) {
                                                Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "update list localId ".concat(String.valueOf(intValue2)));
                                                bjVar.list.remove(i4);
                                                linkedList.add(aj.faO().Zr(intValue2));
                                                i4--;
                                                break;
                                            }
                                        }
                                    }
                                    i4++;
                                }
                                Iterator it2 = linkedList.iterator();
                                while (it2.hasNext()) {
                                    bjVar.list.add((SnsInfo) it2.next());
                                }
                            }
                            Collections.sort(bjVar.list, bjVar.DGA);
                            bjVar.g(bjVar.EIV, bjVar.list);
                            AppMethodBeat.o(99648);
                            return;
                        }
                    } else if (bhVar2.EHR != null) {
                        if (list == null || list2 == null || list.size() + list2.size() == 0) {
                            AppMethodBeat.o(99648);
                            return;
                        }
                        bi biVar2 = bhVar2.EHR;
                        biVar2.he(list);
                        biVar2.hf(list2);
                        biVar2.fiH();
                        biVar2.fiI();
                    }
                }
                AppMethodBeat.o(99648);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final boolean fjj() {
                return false;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjk() {
                AppMethodBeat.i(99649);
                if (SnsUserUI.this.EQg == null || !SnsUserUI.this.EQg.isSearchMode) {
                    aq.a aVar = SnsUserUI.this.EQi;
                    String str = SnsUserUI.this.mRa;
                    boolean unused = SnsUserUI.this.ELk;
                    aVar.a(2, str, SnsUserUI.this.EqY, SnsUserUI.this.ELl);
                    e.DUQ.DVe.ePU++;
                }
                AppMethodBeat.o(99649);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjl() {
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void fjm() {
                AppMethodBeat.i(203800);
                int firstVisiblePosition = SnsUserUI.this.EQh.list.getFirstVisiblePosition();
                View childAt = SnsUserUI.this.EQh.list.getChildAt(0);
                if (childAt != null && firstVisiblePosition == 0 && childAt.getTop() == 0 && SnsUserUI.this.EQh.EvK) {
                    Log.i("MicroMsg.SnsUserUI", "will do up fetch, %s", Boolean.valueOf(SnsUserUI.this.DNI));
                    if (SnsUserUI.this.DNI) {
                        AppMethodBeat.o(203800);
                        return;
                    }
                    SnsUserUI.this.EQh.fjA();
                    SnsUserUI.this.DNI = true;
                    SnsUserUI.this.EQi.a(2, SnsUserUI.this.mRa, ax.DOe, SnsUserUI.this.EqY, 0, SnsUserUI.this.ELl);
                    SnsUserUI.this.EQw = ax.DOe;
                }
                AppMethodBeat.o(203800);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void ZS(int i2) {
                AppMethodBeat.i(99650);
                Log.i("MicroMsg.SnsUserUI", "onListViewScoll %s", Integer.valueOf(i2));
                if (i2 == 2) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, SnsUserUI.this.gsi);
                    SnsUserUI.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, WXHardCoderJNI.hcSNSUserScrollDelay, WXHardCoderJNI.hcSNSUserScrollCPU, WXHardCoderJNI.hcSNSUserScrollIO, WXHardCoderJNI.hcSNSUserScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSUserScrollTimeout, 704, WXHardCoderJNI.hcSNSUserScrollAction, "MicroMsg.SnsUserUI");
                    Log.i("MicroMsg.SnsUserUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsUserUI.this.gsi));
                }
                AppMethodBeat.o(99650);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void aP(int i2, boolean z) {
                boolean z2 = false;
                AppMethodBeat.i(99651);
                if (SnsUserUI.this.EQg != null) {
                    bh bhVar = SnsUserUI.this.EQg;
                    if (bhVar.EHR != null) {
                        bi biVar = bhVar.EHR;
                        SnsInfo Zr = aj.faO().Zr(i2);
                        if (Zr == null || Zr.getTimeLine().ContentObj == null || biVar.list.size() <= 0) {
                            AppMethodBeat.o(99651);
                            return;
                        }
                        int i3 = 0;
                        while (true) {
                            if (i3 >= biVar.list.size()) {
                                break;
                            } else if (biVar.list.get(i3).getLocalid() == Zr.getLocalid()) {
                                z2 = true;
                                biVar.list.remove(i3);
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (z2) {
                            biVar.list.add(Zr);
                            biVar.fiH();
                            biVar.fiI();
                        }
                    }
                }
                AppMethodBeat.o(99651);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void vy(boolean z) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void iR(int i2, int i3) {
                AppMethodBeat.i(99652);
                if (i3 <= 0) {
                    SnsUserUI.k(SnsUserUI.this);
                    AppMethodBeat.o(99652);
                    return;
                }
                SnsUserUI.a(SnsUserUI.this, i2, i3);
                AppMethodBeat.o(99652);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsUIAction.a
            public final void a(m mVar) {
                AppMethodBeat.i(99653);
                SnsUserUI.this.EQx = mVar;
                SnsUserUI.l(SnsUserUI.this);
                AppMethodBeat.o(99653);
            }
        };
        this.EQk = r12;
        snsUIAction.EOI = r12;
        this.EQh.onCreate();
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        initView();
        EventCenter.instance.addListener(this.lEl);
        e.DUQ.fcx();
        iu iuVar = e.DUQ.DVe;
        iuVar.ePK = iuVar.x("OwnerUsername", this.mRa, true);
        if (this.ELk) {
            e.DUQ.DVe.ePL = 1;
        } else {
            e.DUQ.DVe.ePL = 0;
        }
        e.DUQ.DVe.eDV = (long) this.EQj;
        AppMethodBeat.o(99668);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(99669);
        super.onStart();
        e.DUQ.DVl = System.currentTimeMillis();
        AppMethodBeat.o(99669);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(99670);
        super.onStop();
        e eVar = e.DUQ;
        if (eVar.DVl != 0) {
            eVar.DVm += System.currentTimeMillis() - eVar.DVl;
            eVar.DVl = 0;
        }
        AppMethodBeat.o(99670);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99671);
        aj.dRd().removeCallbacks(this.EQz);
        this.ELe = true;
        EventCenter.instance.removeListener(this.lEl);
        k w = k.w(getIntent());
        if (w != null) {
            w.update();
            w.bfK();
        }
        if (!(this.EQh == null || this.EQh.tipDialog == null)) {
            this.EQh.tipDialog.dismiss();
            this.EQh.tipDialog = null;
        }
        g.aAi();
        if (g.aAf().azp() && this.EQi != null) {
            this.EQi.a(this, this.EQk.getType());
        }
        if (this.EQh != null) {
            this.EQh.onDestroy();
        }
        an.fbr();
        c.bt(this).b(this.BdS);
        super.onDestroy();
        e eVar = e.DUQ;
        eVar.DVe.ePQ = (long) eVar.DVf.size();
        eVar.DVe.ePR = (long) eVar.DVg.size();
        iu iuVar = eVar.DVe;
        iuVar.eQd = iuVar.x("AlbumClickFeedListStr", Util.listToString(eVar.DVg, "|"), true);
        eVar.DVe.ePT = eVar.DVm;
        eVar.DVe.ePW = (long) eVar.DVh.size();
        eVar.DVe.ePX = (long) eVar.DVi.size();
        eVar.DVe.ePY = eVar.DVo;
        eVar.DVe.ePZ = (long) eVar.DVj.size();
        eVar.DVe.eQa = (long) eVar.DVk.size();
        eVar.DVe.eQb = eVar.DVq;
        eVar.DVe.eQc = eVar.DVm + eVar.DVo + eVar.DVq;
        Log.d("MicroMsg.SnsReportHelper", "doSnsAlbumBehaviourReport:\n %s", eVar.DVe.abW());
        eVar.DVe.bfK();
        eVar.DVe = new iu();
        eVar.fcx();
        this.DNI = false;
        AppMethodBeat.o(99671);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onDrag() {
        AppMethodBeat.i(99672);
        super.onDrag();
        AppMethodBeat.o(99672);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bx2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        String str;
        com.tencent.matrix.trace.f.c cVar;
        AppMethodBeat.i(99673);
        this.iTC = Util.nowSecond();
        if (!(!b.isInstalled() || b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = (long) cVar.dcx;
        }
        if (this.EQg != null) {
            this.EQg.notifyDataSetChanged();
        }
        if (!this.EqY) {
            enableOptionMenu(false);
        } else {
            addIconOptionMenu(0, getString(R.string.h8q), R.raw.actionbar_list_icon, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass5 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(203792);
                    Intent intent = new Intent();
                    intent.setClass(SnsUserUI.this, SnsMsgUI.class);
                    intent.putExtra("sns_msg_force_show_all", true);
                    intent.putExtra("sns_msg_comment_list_scene", 2);
                    SnsUserUI.this.startActivityForResult(intent, 8);
                    AppMethodBeat.o(203792);
                    return true;
                }
            });
        }
        setBackBtn(this.ubB, R.raw.actionbar_icon_dark_back);
        if (this.EqY) {
            setMMTitle(R.string.h9h);
        } else {
            Log.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", this.mRa, this.EQh.title);
            as Kn = aj.faC().Kn(this.mRa);
            if (Kn != null) {
                Log.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
                str = Kn.arJ();
            } else {
                Log.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", this.EQh.title);
                str = this.EQh.title;
            }
            setMMTitle(r.R(str));
        }
        this.EQh.onResume();
        this.EQh.fjx();
        super.onResume();
        AppMethodBeat.o(99673);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        com.tencent.matrix.trace.f.c cVar;
        AppMethodBeat.i(99674);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, this.gsi);
        this.gsi = 0;
        this.EQh.onPause();
        super.onPause();
        if (!(!b.isInstalled() || b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = Math.max(0L, ((long) cVar.dcx) - this.hlB);
        }
        this.iTC = Util.nowSecond() > this.iTC ? Util.nowSecond() - this.iTC : 1;
        WXHardCoderJNI.reportFPS(704, WXHardCoderJNI.hcSNSUserScrollAction, 1, this.hlB, this.iTC);
        this.hlB = 0;
        this.iTC = 0;
        AppMethodBeat.o(99674);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(99675);
        this.EQm = (FrameLayout) findViewById(R.id.i1r);
        this.EQn = (RelativeLayout) findViewById(R.id.i1q);
        this.EQo = (TextView) findViewById(R.id.i1p);
        this.EQp = (ImageView) findViewById(R.id.i1i);
        this.mContentView = findViewById(R.id.i1h);
        this.EQq = (RelativeLayout) findViewById(R.id.i1m);
        this.EQr = (RelativeLayout) findViewById(R.id.i1k);
        this.EQs = (LinearLayout) findViewById(R.id.i1j);
        this.EQl = (ImageView) findViewById(R.id.i1l);
        this.EQp.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_arrow, getContext().getResources().getColor(R.color.u_)));
        this.EQr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass17 */

            {
                AppMethodBeat.i(99655);
                AppMethodBeat.o(99655);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(203801);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUserUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsUserUI.this.EQi.a(SnsUserUI.this.EQk.getType(), SnsUserUI.this.mRa, ax.DOd, SnsUserUI.this.EqY, SnsUserUI.this.EQv.longValue(), SnsUserUI.this.ELl);
                SnsUserUI.this.EQw = ax.DOd;
                SnsUserUI.o(SnsUserUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUserUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203801);
            }
        });
        this.EQm.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(203802);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = (KeyBoardUtil.isPortOrientation(SnsUserUI.this) ? SnsUserUI.this.getResources().getDimensionPixelSize(R.dimen.b9) : SnsUserUI.this.getResources().getDimensionPixelSize(R.dimen.b8)) + KeyBoardUtil.getStatusHeight(SnsUserUI.this);
                SnsUserUI.this.EQm.setLayoutParams(layoutParams);
                AppMethodBeat.o(203802);
            }
        });
        this.EQg = new bh(this, new a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass19 */

            @Override // com.tencent.mm.plugin.sns.ui.bh.g, com.tencent.mm.plugin.sns.ui.SnsUserUI.a
            public final void iN(int i2, int i3) {
                AppMethodBeat.i(203803);
                super.iN(i2, i3);
                AppMethodBeat.o(203803);
            }
        }, this.mRa, new bh.d() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass20 */

            @Override // com.tencent.mm.plugin.sns.ui.bh.d
            public final void fiG() {
                int i2;
                AppMethodBeat.i(203804);
                if (SnsUserUI.this.EQg != null && SnsUserUI.this.EQg.isSearchMode) {
                    if (SnsUserUI.this.EQg.getCount() == 0) {
                        SnsUserUI.q(SnsUserUI.this);
                    } else {
                        SnsUserUI.r(SnsUserUI.this);
                    }
                    int headerHeight = SnsUserUI.this.EQh.getHeaderHeight();
                    Log.d("MicroMsg.SnsUserUI", "onLoadDataFinish rightSnsId:%s, mCurFetchMode:%s", Long.valueOf(an.DMh), Integer.valueOf(SnsUserUI.this.EQw));
                    if (SnsUserUI.this.EQw == ax.DOd) {
                        SnsUserUI.this.EQh.getSnsListView().setSelectionFromTop(SnsUserUI.this.EQh.getSnsListView().getHeaderViewsCount(), au.getStatusBarHeight(SnsUserUI.this.getContext()) + at.fromDPToPix(SnsUserUI.this.getContext(), 90) + au.eu(SnsUserUI.this.getContext()));
                    } else if (SnsUserUI.this.EQw == ax.DOe && an.DMh != 0) {
                        ListView snsListView = SnsUserUI.this.EQh.getSnsListView();
                        bh bhVar = SnsUserUI.this.EQg;
                        long j2 = an.DMh;
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            if (i4 < bhVar.list.size()) {
                                SnsInfo snsInfo = bhVar.list.get(i4);
                                if (snsInfo != null && snsInfo.field_snsId == j2) {
                                    i3 = i4;
                                    break;
                                }
                                i4++;
                            } else {
                                break;
                            }
                        }
                        Iterator<Map.Entry<Integer, Integer>> it = bhVar.Enw.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = 0;
                                break;
                            }
                            Map.Entry<Integer, Integer> next = it.next();
                            if (next.getValue().intValue() >= i3) {
                                i2 = next.getKey().intValue();
                                break;
                            }
                        }
                        Log.i("MicroMsg.SnsphotoAdapter", "dataPos:%s, displayPos:%s", Integer.valueOf(i3), Integer.valueOf(i2));
                        snsListView.setSelectionFromTop(i2 + SnsUserUI.this.EQh.getSnsListView().getHeaderViewsCount(), an.DMi + headerHeight);
                    }
                    SnsUserUI.this.DNI = false;
                    an.DMi = 0;
                    an.DMh = 0;
                }
                AppMethodBeat.o(203804);
            }
        });
        this.EQh.list.setAdapter((ListAdapter) this.EQg);
        this.EQh.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass21 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(203805);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUserUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUserUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(203805);
            }
        });
        this.EQh.list.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(203789);
                if (SnsUserUI.this.ELe) {
                    Log.w("MicroMsg.SnsUserUI", "too fast that it finish");
                    AppMethodBeat.o(203789);
                    return;
                }
                SnsUserUI.this.EQi.a(SnsUserUI.this.EQk.getType(), SnsUserUI.this.mRa, SnsUserUI.this);
                if (SnsUserUI.this.EQk.getType() == 1 && SnsUserUI.this.EQk.fjj()) {
                    aj.faE().W(aj.faY().DMw, -1);
                }
                if (!SnsUserUI.this.EQk.fjj()) {
                    aq.a aVar = SnsUserUI.this.EQi;
                    int type = SnsUserUI.this.EQk.getType();
                    String str = SnsUserUI.this.mRa;
                    boolean unused = SnsUserUI.this.ELk;
                    aVar.a(type, str, SnsUserUI.this.EqY, SnsUserUI.this.ELl);
                }
                AppMethodBeat.o(203789);
            }
        }, 500);
        setBackBtn(this.ubB, R.raw.actionbar_icon_dark_back);
        this.EQy.setDuration(1000);
        this.EQy.setRepeatCount(-1);
        this.EQy.setInterpolator(new LinearInterpolator());
        AppMethodBeat.o(99675);
    }

    private boolean fjR() {
        AppMethodBeat.i(203806);
        if (this.EQx == null || Util.isNullOrNil(this.EQx.DEq) || Util.isNullOrNil(this.EQx.DEr)) {
            AppMethodBeat.o(203806);
            return false;
        }
        AppMethodBeat.o(203806);
        return true;
    }

    private void fjS() {
        AppMethodBeat.i(203807);
        this.EQh.fjy();
        this.EQq.setVisibility(0);
        this.EQr.setVisibility(0);
        this.EQs.setVisibility(8);
        this.EQy.cancel();
        AppMethodBeat.o(203807);
    }

    private void fjT() {
        AppMethodBeat.i(203808);
        SnsUIAction snsUIAction = this.EQh;
        if (snsUIAction.getSnsListView() != null) {
            snsUIAction.getSnsListView().setVisibility(0);
        }
        this.EQq.setVisibility(8);
        this.EQr.setVisibility(8);
        this.EQs.setVisibility(8);
        this.EQy.cancel();
        AppMethodBeat.o(203808);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(99676);
        if (this.EQg.isSearchMode) {
            Log.i("MicroMsg.SnsUserUI", "skip data callback, because this is search mode now.");
            AppMethodBeat.o(99676);
            return;
        }
        if (this.EQg != null) {
            this.EQg.EvF = str;
            String str2 = this.EQg.sNG;
            if (str.compareTo(str2) < 0) {
                Log.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", str, str2, Boolean.valueOf(bVar.eZb()));
                this.EQg.fiE();
            } else {
                Log.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", str, str2, Boolean.valueOf(bVar.eZb()));
            }
            this.EQg.fiD();
            this.EQg.ffM();
        }
        if ((z || !Util.isNullOrNil(bVar.eZg())) && !this.ELj.equals(this.mRa)) {
            this.EQh.qeT = true;
            this.EQh.aQU(bVar.eZg());
        } else {
            if (this.ELj.equals(this.mRa) && bVar.eZf() != 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(bVar.eZf()));
                this.EQg.JR(bVar.eZf());
            }
            this.EQh.qeT = bVar.eZa();
            if (bVar.eZa()) {
                this.EQh.aRh(bVar.eZg());
            } else if (bVar.eZb()) {
                this.EQi.b(this.EQk.getType(), this.mRa, this.EqY, this.ELl);
            }
        }
        if (bVar.eZe()) {
            this.EQh.DSh.fid();
        }
        this.EQh.fjx();
        AppMethodBeat.o(99676);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void b(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(99677);
        aj.dRd().removeCallbacks(this.EQz);
        if (this.EQg.isSearchMode) {
            Log.i("MicroMsg.SnsUserUI", "skip data callback, because this is search mode now.");
            AppMethodBeat.o(99677);
            return;
        }
        if (this.EQg != null) {
            this.EQg.EHQ = bVar.eZc();
            this.EQg.EvF = str;
            String str2 = this.EQg.sNG;
            if (str.compareTo(str2) < 0) {
                Log.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", str, str2);
                this.EQg.fiE();
            } else if (str.compareTo(str2) > 0) {
                this.EQi.b(this.EQk.getType(), this.mRa, this.EqY, this.ELl);
                Log.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", str, str2);
            } else {
                Log.i("MicroMsg.SnsUserUI", "onNpAddSize else passed %s %s", str, str2);
            }
            this.EQg.ffM();
        }
        if (!z || this.ELj.equals(this.mRa)) {
            if (this.ELj.equals(this.mRa) && bVar.eZf() != 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(bVar.eZf()));
                this.EQg.JR(bVar.eZf());
            }
            this.EQh.qeT = bVar.eZa();
            if (bVar.eZa()) {
                this.EQh.aRh(bVar.eZg());
                AppMethodBeat.o(99677);
                return;
            }
            this.EQh.fjw();
            AppMethodBeat.o(99677);
            return;
        }
        this.EQh.qeT = true;
        this.EQh.aQU(bVar.eZg());
        AppMethodBeat.o(99677);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, String str2, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(203809);
        aj.dRd().removeCallbacks(this.EQz);
        if (this.EQg != null && this.EQg.isSearchMode) {
            if (z || i2 == 0 || bVar.eYY() != ax.DOd) {
                fjT();
                if (((bVar instanceof ab) && bVar.eYY() == ax.DOe) || bVar.eYY() == ax.DOd) {
                    this.EQg.DJx = ((ab) bVar).DJx;
                }
                this.EQg.EHQ = bVar.eZc();
                this.EQg.ffM();
                if (bVar.eZa()) {
                    this.EQh.aRh(bVar.eZg());
                    AppMethodBeat.o(203809);
                    return;
                } else if (bVar.eYZ()) {
                    this.EQg.fiD();
                    this.EQh.vz(false);
                }
            } else {
                fjS();
                AppMethodBeat.o(203809);
                return;
            }
        }
        AppMethodBeat.o(203809);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setActionbarColor(int i2) {
        AppMethodBeat.i(99679);
        super.setActionbarColor(i2);
        if (Build.VERSION.SDK_INT >= 21 && this.BdQ != null) {
            this.BdQ.setBackgroundColor(getWindow().getStatusBarColor());
            d.e(getWindow());
        }
        AppMethodBeat.o(99679);
    }

    class a extends bh.g {
        private com.tencent.mm.ui.widget.a.e EQB = null;

        a() {
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.g
        public void iN(int i2, int i3) {
            AppMethodBeat.i(99663);
            Log.i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(SnsUserUI.this.EqY));
            if (!SnsUserUI.this.EqY || i3 != -1) {
                Intent intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
                intent.putExtra("sns_gallery_userName", SnsUserUI.this.mRa);
                intent.putExtra("sns_gallery_is_self", SnsUserUI.this.EqY);
                intent.putExtra("sns_gallery_localId", i2);
                intent.putExtra("sns_source", SnsUserUI.this.ELl);
                intent.putExtra("sns_gallery_st_time", SnsUserUI.this.EQg.EHU);
                intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.EQg.EHV);
                intent.putExtra("key_from_scene", 4);
                if (SnsUserUI.this.EQg != null) {
                    intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.EQg.sNG);
                    SnsUserUI.this.EQi.l(SnsUserUI.this.mRa, SnsUserUI.this.EQg.iM(i2, i3));
                    intent.putExtra("sns_gallery_position", SnsUserUI.this.EQg.EIb);
                }
                SnsUserUI.this.startActivityForResult(intent, 8);
            } else {
                aj.faV().vk(false);
                j aQn = aj.faV().aQn("draft_normal");
                if (aQn != null) {
                    byte[] bArr = aQn.field_draft;
                    if (!Util.isNullOrNil(bArr)) {
                        g.aAi();
                        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, "");
                        new im().ahi().wj(str).bfK();
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        try {
                            Intent intent2 = (Intent) Intent.CREATOR.createFromParcel(obtain);
                            intent2.addFlags(268435456);
                            intent2.setClass(SnsUserUI.this, SnsUploadUI.class);
                            intent2.putExtra("KSessionID", str);
                            SnsUserUI snsUserUI = SnsUserUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(snsUserUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUserUI$SnsEventListener", "selectImageOrVideo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            snsUserUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(snsUserUI, "com/tencent/mm/plugin/sns/ui/SnsUserUI$SnsEventListener", "selectImageOrVideo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        } catch (Exception e2) {
                            aj.faV().b("draft_normal", null, 0);
                            g.aAi();
                            g.aAh().azQ().set(ar.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, "");
                        }
                    }
                }
                this.EQB = new com.tencent.mm.ui.widget.a.e((Context) SnsUserUI.this, 1, false);
                this.EQB.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.a.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                        AppMethodBeat.i(99661);
                        mVar.a(0, SnsUserUI.this.getString(R.string.um), SnsUserUI.this.getContext().getString(R.string.ur), 0);
                        mVar.d(1, SnsUserUI.this.getString(R.string.uv));
                        AppMethodBeat.o(99661);
                    }
                };
                this.EQB.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.a.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(99662);
                        long aWz = cl.aWz();
                        String eZx = r.eZx();
                        switch (menuItem.getItemId()) {
                            case 0:
                                h.INSTANCE.a(13822, 1, 2, eZx, Long.valueOf(aWz));
                                SnsUserUI.x(SnsUserUI.this);
                                AppMethodBeat.o(99662);
                                return;
                            case 1:
                                h.INSTANCE.a(13822, 2, 2, eZx, Long.valueOf(aWz));
                                SnsUserUI.this.EQh.ZX(1);
                                break;
                        }
                        AppMethodBeat.o(99662);
                    }
                };
                this.EQB.dGm();
            }
            e.DUQ.O(aj.faO().Zr(i2));
            AppMethodBeat.o(99663);
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.g
        public final void iO(int i2, int i3) {
            AppMethodBeat.i(99664);
            SnsInfo Zr = aj.faO().Zr(i2);
            if (Zr == null) {
                AppMethodBeat.o(99664);
                return;
            }
            if (Zr.field_type == 15) {
                Intent intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
                intent.putExtra("sns_gallery_userName", SnsUserUI.this.mRa);
                intent.putExtra("sns_gallery_is_self", SnsUserUI.this.EqY);
                intent.putExtra("sns_gallery_localId", i2);
                intent.putExtra("sns_source", SnsUserUI.this.ELl);
                intent.putExtra("sns_gallery_st_time", SnsUserUI.this.EQg.EHU);
                intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.EQg.EHV);
                intent.putExtra("sns_video_scene", 4);
                intent.putExtra("key_from_scene", 4);
                if (SnsUserUI.this.EQg != null) {
                    intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.EQg.sNG);
                    SnsUserUI.this.EQi.l(SnsUserUI.this.mRa, SnsUserUI.this.EQg.iM(i2, i3));
                    intent.putExtra("sns_gallery_position", SnsUserUI.this.EQg.EIb);
                }
                SnsUserUI.this.startActivityForResult(intent, 8);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", Zr.getUserName());
                intent2.putExtra("INTENT_NEED_RPT_FEED", true);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", y.bq("sns_table_", (long) i2));
                SnsUserUI.this.startActivityForResult(intent2, 12);
            }
            e.DUQ.O(Zr);
            AppMethodBeat.o(99664);
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.g
        public final void ZP(int i2) {
            AppMethodBeat.i(99665);
            SnsInfo Zr = aj.faO().Zr(i2);
            if (Zr == null) {
                AppMethodBeat.o(99665);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", Zr.getUserName());
            intent.putExtra("INTENT_NEED_RPT_FEED", true);
            intent.putExtra("INTENT_SNS_LOCAL_ID", y.bq("sns_table_", (long) i2));
            SnsUserUI.this.startActivityForResult(intent, 12);
            e.DUQ.O(Zr);
            AppMethodBeat.o(99665);
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.g
        public final void iP(int i2, int i3) {
            AppMethodBeat.i(99666);
            Log.d("MicroMsg.SnsUserUI", "onFailLongClick localId:%s position:%s", Integer.valueOf(i2), Integer.valueOf(i3));
            SnsInfo Zr = aj.faO().Zr(i2);
            if (Zr != null && Zr.isInValid() && Zr.isDieItem()) {
                SnsUserUI.c(SnsUserUI.this, i2);
            }
            AppMethodBeat.o(99666);
        }
    }

    private void fjU() {
        AppMethodBeat.i(99680);
        if (com.tencent.mm.q.a.cA(this)) {
            AppMethodBeat.o(99680);
        } else if (com.tencent.mm.q.a.cE(this)) {
            AppMethodBeat.o(99680);
        } else {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
            Log.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
            if (!a2) {
                AppMethodBeat.o(99680);
                return;
            }
            SightParams sightParams = new SightParams(2, 0);
            com.tencent.mm.modelvideo.o.bhi();
            String aFj = com.tencent.mm.plugin.mmsight.d.aFj(com.tencent.mm.modelvideo.o.getAccVideoPath());
            RecordConfigProvider a3 = RecordConfigProvider.a(aFj, com.tencent.mm.plugin.mmsight.d.aFl(aFj), sightParams.irT, sightParams.irT.duration * 1000, 2);
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_ignore_remux_without_edit, false)) {
                a3.remuxType = 2;
            }
            VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
            videoCaptureReportInfo.sQn = 2;
            a3.BOE = videoCaptureReportInfo;
            CaptureDataManager.BOb.BOa = new CaptureDataManager.c() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
                    AppMethodBeat.i(203795);
                    cly cly = new cly();
                    cly.Mrn = true;
                    cly.Mrm = false;
                    SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath, s.bpb(captureVideoNormalModel.videoPath), com.tencent.xweb.util.d.getMD5(captureVideoNormalModel.videoPath), (int) (captureVideoNormalModel.BOd.longValue() / 1000), cly);
                    if (captureVideoNormalModel.BOe.booleanValue()) {
                        sightCaptureResult.zsy = true;
                        sightCaptureResult.tkD = false;
                        sightCaptureResult.zsG = captureVideoNormalModel.thumbPath;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_req_result", sightCaptureResult);
                    ((Activity) context).setResult(-1, intent);
                    ((Activity) context).finish();
                    AppMethodBeat.o(203795);
                }

                @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
                    return false;
                }
            };
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true)) {
                com.tencent.mm.plugin.recordvideo.jumper.a aVar = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, R.anim.ei, R.anim.ej, a3);
                AppMethodBeat.o(99680);
                return;
            }
            com.tencent.mm.pluginsdk.ui.tools.s.ax(getContext(), new Intent());
            AppMethodBeat.o(99680);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(99681);
        finish();
        AppMethodBeat.o(99681);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean supportNavigationSwipeBack() {
        AppMethodBeat.i(99682);
        boolean supportNavigationSwipeBack = super.supportNavigationSwipeBack();
        AppMethodBeat.o(99682);
        return supportNavigationSwipeBack;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(99683);
        Log.i("MicroMsg.SnsUserUI", "on activity result, %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (5985 == i2 && i3 == -1) {
            finish();
            AppMethodBeat.o(99683);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        this.EQh.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(99683);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(99684);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.SnsUserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(99684);
            return;
        }
        Log.i("MicroMsg.SnsUserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 18:
                if (iArr[0] != 0) {
                    int i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a((Context) this, getString(i3), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass11 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(203797);
                                dialogInterface.dismiss();
                                SnsUserUI snsUserUI = SnsUserUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                com.tencent.mm.hellhoundlib.a.a.a(snsUserUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUserUI$19", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                snsUserUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(snsUserUI, "com/tencent/mm/plugin/sns/ui/SnsUserUI$19", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(203797);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass13 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(99639);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(99639);
                            }
                        });
                        break;
                    }
                } else {
                    fjU();
                    AppMethodBeat.o(99684);
                    return;
                }
                break;
        }
        AppMethodBeat.o(99684);
    }

    static /* synthetic */ void k(SnsUserUI snsUserUI) {
        AppMethodBeat.i(203810);
        snsUserUI.EQm.setVisibility(8);
        AppMethodBeat.o(203810);
    }

    static /* synthetic */ void a(SnsUserUI snsUserUI, int i2, int i3) {
        int intValue;
        Object item;
        AppMethodBeat.i(203811);
        bh bhVar = snsUserUI.EQg;
        if (bhVar.Enw.get(Integer.valueOf(i2)) == null) {
            intValue = -1;
        } else {
            intValue = bhVar.Enw.get(Integer.valueOf(i2)).intValue();
        }
        Log.d("MicroMsg.SnsUserUI", "displayYearTip position:%d alpha:%d realPos:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(intValue));
        if (!(intValue == -1 || (item = snsUserUI.EQg.getItem(intValue)) == null || !(item instanceof SnsInfo))) {
            float f2 = ((float) i3) / 100.0f;
            if (f2 != snsUserUI.EQm.getAlpha()) {
                snsUserUI.EQm.setAlpha(f2);
            }
            snsUserUI.EQm.setVisibility(0);
            SnsInfo snsInfo = (SnsInfo) item;
            if (snsUserUI.EQt != snsInfo.getHead() / 10000) {
                snsUserUI.EQt = snsInfo.getHead() / 10000;
                snsUserUI.EQo.setText(String.format(snsUserUI.getResources().getString(R.string.hc5), Integer.valueOf(snsUserUI.EQt)));
            }
            snsUserUI.EQu = (snsInfo.getHead() / 100) % snsUserUI.EQt;
        }
        AppMethodBeat.o(203811);
    }

    static /* synthetic */ void l(SnsUserUI snsUserUI) {
        boolean z;
        AppMethodBeat.i(203812);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            z = snsUserUI.fjR();
        } else {
            z = snsUserUI.fjR();
        }
        Log.i("MicroMsg.SnsUserUI", "username:$s, datePickerEnable:%s", snsUserUI.mRa, Boolean.valueOf(z));
        if (!Util.isEqual(snsUserUI.ELj, snsUserUI.mRa) || !z) {
            snsUserUI.EQp.setVisibility(8);
            snsUserUI.EQn.setOnClickListener(null);
            AppMethodBeat.o(203812);
            return;
        }
        snsUserUI.EQp.setVisibility(0);
        snsUserUI.EQn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(203790);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUserUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsUserUI.u(SnsUserUI.this);
                if (SnsUserUI.this.EQh != null) {
                    SnsUserUI.this.EQh.fjw();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUserUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203790);
            }
        });
        AppMethodBeat.o(203812);
    }

    static /* synthetic */ void o(SnsUserUI snsUserUI) {
        AppMethodBeat.i(99689);
        snsUserUI.EQh.fjy();
        snsUserUI.EQq.setVisibility(0);
        snsUserUI.EQr.setVisibility(8);
        snsUserUI.EQs.setVisibility(0);
        snsUserUI.EQy.reset();
        snsUserUI.EQl.startAnimation(snsUserUI.EQy);
        AppMethodBeat.o(99689);
    }

    static /* synthetic */ void u(SnsUserUI snsUserUI) {
        int i2;
        AppMethodBeat.i(99691);
        if (snsUserUI.EQx == null || Util.isNullOrNil(snsUserUI.EQx.DEq) || Util.isNullOrNil(snsUserUI.EQx.DEr)) {
            Log.w("MicroMsg.SnsUserUI", "mDateInfo == null or displayYears == null or displayMonths == null, don't do anything");
            AppMethodBeat.o(99691);
            return;
        }
        snsUserUI.EQh.fjx();
        final com.tencent.mm.ui.widget.picker.c cVar = new com.tencent.mm.ui.widget.picker.c(snsUserUI, snsUserUI.EQx.DEq, snsUserUI.EQx.DEr);
        cVar.setHeaderView(View.inflate(snsUserUI.getContext(), R.layout.by9, null));
        int indexOf = snsUserUI.EQx.DEq.indexOf(String.valueOf(snsUserUI.EQt));
        if (indexOf < 0 || indexOf >= snsUserUI.EQx.DEr.size() || snsUserUI.EQx.DEr.get(indexOf) == null) {
            i2 = -1;
        } else {
            i2 = snsUserUI.EQx.DEr.get(indexOf).indexOf(String.valueOf(snsUserUI.EQu));
        }
        if (indexOf != -1 && i2 != -1) {
            cVar.lM(indexOf, i2);
        } else if (indexOf != -1) {
            cVar.app(indexOf);
        } else if (i2 != -1) {
            cVar.lM(0, i2);
        }
        cVar.QTc = new c.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.picker.c.b
            public final void onResult(boolean z, Object obj, Object obj2) {
                AppMethodBeat.i(203791);
                if ((obj instanceof String) && (obj2 instanceof String) && SnsUserUI.this.EQx.map.get(obj) != null && SnsUserUI.this.EQx.map.get(obj).get(obj2) != null) {
                    SnsUserUI.this.EQv = SnsUserUI.this.EQx.map.get(obj).get(obj2);
                    Log.i("MicroMsg.SnsUserUI", "SnsDatePicker select:[%s, %s, %s]", obj, obj2, SnsUserUI.this.EQv);
                    aj.dRd().removeCallbacks(SnsUserUI.this.EQz);
                    SnsUserUI.this.EQi.a(SnsUserUI.this.EQk.getType(), SnsUserUI.this.mRa, ax.DOd, SnsUserUI.this.EqY, SnsUserUI.this.EQv.longValue(), SnsUserUI.this.ELl);
                    SnsUserUI.this.EQw = ax.DOd;
                    bh bhVar = SnsUserUI.this.EQg;
                    bhVar.isSearchMode = true;
                    bhVar.EHY = false;
                    bhVar.EHS.EIV = false;
                    SnsUserUI.this.EQh.vz(true);
                    SnsUserUI.o(SnsUserUI.this);
                }
                cVar.hide();
                AppMethodBeat.o(203791);
            }
        };
        cVar.show();
        AppMethodBeat.o(99691);
    }

    static /* synthetic */ void c(SnsUserUI snsUserUI, final int i2) {
        AppMethodBeat.i(203815);
        com.tencent.mm.ui.base.h.a(snsUserUI, (int) R.string.th, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(203794);
                aj.faO().Zs(i2);
                SnsUserUI.this.EQg.ffM();
                AppMethodBeat.o(203794);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUserUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(99635);
                AppMethodBeat.o(99635);
            }
        });
        AppMethodBeat.o(203815);
    }
}
