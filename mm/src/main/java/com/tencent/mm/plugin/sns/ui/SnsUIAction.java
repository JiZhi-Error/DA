package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Looper;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ci.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUIAction implements be.a, c.b {
    private static int EOK = 0;
    private static int EOL = 1;
    private static int EOM = 2;
    private boolean DEF = false;
    protected SnsHeader DSh;
    String DTT;
    public int DuA = 0;
    private int ELa = 800;
    private String ELj;
    private boolean ELk;
    private int ELl;
    protected LoadingMoreView EOC;
    private int EOD = 0;
    private int EOE = 0;
    private boolean EOG = false;
    public int EOH = 0;
    a EOI;
    private Toolbar.LayoutParams EOJ;
    private int EON;
    int EOO = 0;
    float EOP = 1.0f;
    float EOQ = 1.0f;
    float EOR = 1.0f;
    int EOS = EOK;
    int EOT = EOK;
    int EOU = 0;
    boolean EOV = false;
    private b EOW = new b() {
        /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass15 */

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "SnsUIAction#preloadRunnable";
        }

        public final void run() {
            AppMethodBeat.i(99475);
            az faM = aj.faM();
            synchronized (faM.DOk) {
                try {
                    faM.DOk.clear();
                } finally {
                    AppMethodBeat.o(99475);
                }
            }
            Iterator it = new ArrayList(SnsUIAction.this.xjs).iterator();
            while (it.hasNext()) {
                aj.faM().H((SnsInfo) it.next());
            }
        }
    };
    ArrayList<n.a> EOX = null;
    k EOY = null;
    private com.tencent.mm.plugin.expt.hellhound.a.a.b.c EOZ;
    private final e EPa = new e() {
        /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.e
        public final void b(AbsListView absListView, int i2, int i3) {
            AppMethodBeat.i(203750);
            if (absListView == null) {
                AppMethodBeat.o(203750);
            } else if (i2 < 0 || i3 <= 0) {
                AppMethodBeat.o(203750);
            } else {
                BaseAdapter l = SnsUIAction.l(SnsUIAction.this);
                if (l == null) {
                    AppMethodBeat.o(203750);
                    return;
                }
                SnsUIAction.a(SnsUIAction.this, absListView, l, i2, i3);
                AppMethodBeat.o(203750);
            }
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.e
        public final void c(AbsListView absListView, int i2, int i3) {
            AppMethodBeat.i(203751);
            if (absListView == null) {
                AppMethodBeat.o(203751);
                return;
            }
            BaseAdapter l = SnsUIAction.l(SnsUIAction.this);
            if (l == null) {
                AppMethodBeat.o(203751);
                return;
            }
            SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.getSnsListView(), l, i2, i3);
            AppMethodBeat.o(203751);
        }
    };
    private boolean EqY;
    boolean EvK = false;
    View actionbarView;
    protected View cBH;
    protected String filePath;
    int gRE = 0;
    private String krY;
    private int lastIndex;
    protected ListView list;
    private Activity mActivity;
    private String mRa;
    private String mSignature;
    protected View maskView;
    protected boolean qeT = false;
    private String sessionId;
    int start = 0;
    protected q tipDialog = null;
    protected String title;
    private ArrayList<SnsInfo> xjs = new ArrayList<>();
    int zlN = 0;
    protected MMPullDownView zog;

    public interface a {
        void ZS(int i2);

        void a(m mVar);

        void aP(int i2, boolean z);

        void d(int i2, List<Integer> list, List<Integer> list2);

        void fjg();

        View fjh();

        MMPullDownView fji();

        boolean fjj();

        void fjk();

        void fjl();

        void fjm();

        View getMaskView();

        ListView getSnsListView();

        int getType();

        void iR(int i2, int i3);

        void vy(boolean z);
    }

    static /* synthetic */ BaseAdapter l(SnsUIAction snsUIAction) {
        AppMethodBeat.i(203757);
        BaseAdapter anl = snsUIAction.anl();
        AppMethodBeat.o(203757);
        return anl;
    }

    public SnsUIAction(Activity activity) {
        AppMethodBeat.i(176361);
        this.mActivity = activity;
        AppMethodBeat.o(176361);
    }

    public final void onCreate() {
        String str;
        String R;
        AppMethodBeat.i(99477);
        this.DuA = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
        this.ELa = (int) (((double) this.DuA) * 0.4d);
        aj.faL().start();
        if (this.actionbarView != null) {
            this.EOJ = (Toolbar.LayoutParams) this.actionbarView.getLayoutParams();
        }
        this.EOZ = new com.tencent.mm.plugin.expt.hellhound.a.a.b.c(this.EPa, "SnsTimelineUI", c.a.STRATEGY_SAMPLING);
        this.list = this.EOI.getSnsListView();
        this.list.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(99459);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                SnsUIAction.this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                aj.faD();
                r.iI(displayMetrics.widthPixels, displayMetrics.heightPixels);
                AppMethodBeat.o(99459);
            }
        });
        Log.i("MicroMsg.SnsActivity", "list is null ? " + (this.list != null));
        this.list.setScrollingCacheEnabled(false);
        this.DSh = new SnsHeader(this.mActivity);
        this.DSh.setSessionId(this.sessionId);
        this.DSh.setEnterObjectId(this.DTT);
        this.DSh.setBackClickListener(new SnsHeader.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsHeader.a
            public final boolean JQ(long j2) {
                AppMethodBeat.i(99467);
                if (SnsUIAction.this.EqY || SnsUIAction.this.EOI.getType() == 1) {
                    SnsUIAction.this.ZX(2);
                } else {
                    SnsInfo snsInfo = new SnsInfo();
                    snsInfo.field_snsId = j2;
                    snsInfo.field_userName = SnsUIAction.this.mRa;
                    TimeLineObject bfM = com.tencent.mm.modelsns.n.bfM();
                    bfM.UserName = SnsUIAction.this.mRa;
                    snsInfo.setTimeLine(bfM);
                    SnsInfo aPk = an.aPk(SnsUIAction.this.mRa);
                    Log.d("MicroMsg.SnsActivity", "friend like %s", SnsUIAction.this.mRa);
                    if (aPk == null) {
                        aq.a.a(snsInfo, 1, "", 0);
                    } else if (aPk.isExtFlag()) {
                        aq.a.a(snsInfo, 1, "", 0);
                    } else {
                        aq.a.a(snsInfo, 5, "", 0);
                    }
                    l aQr = aj.faS().aQr(SnsUIAction.this.mRa);
                    aQr.field_local_flag |= 2;
                    aj.faS().c(aQr);
                    SnsUIAction.e(SnsUIAction.this);
                    com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePV = 1;
                }
                AppMethodBeat.o(99467);
                return false;
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsHeader.a
            public final boolean fif() {
                AppMethodBeat.i(99468);
                SnsUIAction.this.EOI.fjl();
                AppMethodBeat.o(99468);
                return false;
            }
        });
        this.cBH = this.EOI.fjh();
        this.maskView = this.EOI.getMaskView();
        this.EOC = new LoadingMoreView(this.mActivity);
        this.list.addHeaderView(this.DSh);
        this.list.addFooterView(this.EOC);
        this.list.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass10 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                int i3;
                int i4;
                int i5;
                AppMethodBeat.i(99469);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(absListView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V", this, bVar.axR());
                SnsUIAction.this.EOI.ZS(i2);
                if (i2 == 0) {
                    if ((SnsUIAction.this.mActivity instanceof SnsTimeLineUI) && ((SnsTimeLineUI) SnsUIAction.this.mActivity).EBv != null) {
                        ((SnsTimeLineUI) SnsUIAction.this.mActivity).EBv.uM(true);
                    }
                    if (SnsUIAction.this.DSh != null) {
                        SnsHeader snsHeader = SnsUIAction.this.DSh;
                        if (!(snsHeader.EDy == null || snsHeader.EDy.EDQ == null || snsHeader.EDF)) {
                            snsHeader.EDy.EDQ.fkW();
                        }
                    }
                    if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                        SnsUIAction snsUIAction = SnsUIAction.this;
                        ListView listView = SnsUIAction.this.list;
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (snsUIAction.EOX != null) {
                                snsUIAction.EOX.clear();
                            }
                            int i6 = -1;
                            int i7 = -1;
                            int height = listView.getHeight();
                            Rect rect = new Rect();
                            if (snsUIAction.actionbarView != null) {
                                snsUIAction.actionbarView.getGlobalVisibleRect(rect);
                                i3 = rect.bottom;
                            } else {
                                i3 = 0;
                            }
                            int childCount = listView.getChildCount();
                            int i8 = 0;
                            while (i8 < childCount) {
                                Object tag = listView.getChildAt(i8).getTag();
                                if (tag instanceof n.a) {
                                    n.a aVar = (n.a) tag;
                                    if (aVar.EXx instanceof n) {
                                        if (snsUIAction.EOX == null) {
                                            snsUIAction.EOX = new ArrayList<>();
                                        }
                                        snsUIAction.EOX.add(aVar);
                                        aVar.EZp.getGlobalVisibleRect(rect);
                                        if (rect.top < i3) {
                                            rect.top = i3;
                                        }
                                        if (rect.top > height) {
                                            rect.top = height;
                                        }
                                        if (rect.bottom < i3) {
                                            rect.bottom = i3;
                                        }
                                        if (rect.bottom > height) {
                                            rect.bottom = height;
                                        }
                                        i5 = Math.abs(rect.bottom - rect.top);
                                        if (i5 >= i6) {
                                            i4 = snsUIAction.EOX.size() - 1;
                                            i8++;
                                            i7 = i4;
                                            i6 = i5;
                                        }
                                    }
                                }
                                i4 = i7;
                                i5 = i6;
                                i8++;
                                i7 = i4;
                                i6 = i5;
                            }
                            if (snsUIAction.EOX != null && snsUIAction.EOX.size() > 0 && i7 >= 0) {
                                for (int i9 = 0; i9 < snsUIAction.EOX.size(); i9++) {
                                    n.a aVar2 = snsUIAction.EOX.get(i9);
                                    n nVar = (n) aVar2.EXx;
                                    if (i9 == i7) {
                                        nVar.a(aVar2.EZp, false);
                                    } else {
                                        nVar.a(aVar2.EZp, true);
                                    }
                                }
                                Log.d("MicroMsg.SnsActivitySphereImageView", "checkSphereImageCompItem cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", maxVisiableItemIdx=" + i7 + ", size=" + (snsUIAction.EOX != null ? snsUIAction.EOX.size() : 0));
                            }
                        } catch (Throwable th) {
                            Log.e("MicroMsg.SnsActivitySphereImageView", "checkSphereImageCompItem exp=" + th.toString());
                        }
                    }
                    SnsUIAction.this.bIW();
                }
                if (i2 == 2) {
                    d.gGm().gV(SnsUIAction.class.getName() + SnsUIAction.this.EOI.getType() + ".Listview", 4);
                    SnsUIAction.this.vy(true);
                } else {
                    SnsUIAction.this.vy(false);
                }
                SnsUIAction.a(SnsUIAction.this, absListView, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V");
                AppMethodBeat.o(99469);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                int i5;
                float f2;
                float f3;
                MMActivity mMActivity;
                float f4;
                AppMethodBeat.i(99470);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(absListView);
                bVar.pH(i2);
                bVar.pH(i3);
                bVar.pH(i4);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V", this, bVar.axR());
                System.currentTimeMillis();
                SnsHeader snsHeader = SnsUIAction.this.DSh;
                if (!(snsHeader.EDy == null || snsHeader.EDy.EDP == null || !snsHeader.EDF)) {
                    snsHeader.EDy.EDP.fmU();
                }
                SnsUIAction.this.EOI.fjm();
                SnsUIAction.this.EOH = (i2 + i3) - 1;
                if (SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getCount() - 3 && SnsUIAction.this.list.getCount() != SnsUIAction.this.EOD) {
                    Log.d("MicroMsg.SnsActivity", "now refresh count: %s", Integer.valueOf(SnsUIAction.this.list.getCount()));
                    SnsUIAction.this.EOD = SnsUIAction.this.list.getCount();
                    SnsUIAction.g(SnsUIAction.this);
                }
                if (absListView.getChildCount() == 0) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
                    AppMethodBeat.o(99470);
                    return;
                }
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) SnsUIAction.this.mActivity, 20);
                int i6 = 0;
                float f5 = 1.0f;
                float f6 = 1.0f;
                boolean z = true;
                int i7 = 0;
                if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                    i7 = com.tencent.mm.cb.a.fromDPToPix((Context) SnsUIAction.this.mActivity, 245);
                } else if (SnsUIAction.this.mActivity instanceof SnsUserUI) {
                    i7 = com.tencent.mm.cb.a.fromDPToPix((Context) SnsUIAction.this.mActivity, 199);
                }
                int fromDPToPix2 = i7 - com.tencent.mm.cb.a.fromDPToPix((Context) SnsUIAction.this.mActivity, 30);
                int fromDPToPix3 = i7 - com.tencent.mm.cb.a.fromDPToPix((Context) SnsUIAction.this.mActivity, 10);
                View childAt = absListView.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                if (i2 > SnsUIAction.this.lastIndex) {
                    SnsUIAction.this.EOS = SnsUIAction.EOL;
                    if (childAt != null) {
                        SnsUIAction.this.gRE += childAt.getHeight();
                    }
                } else if (i2 < SnsUIAction.this.lastIndex) {
                    SnsUIAction.this.EOS = SnsUIAction.EOM;
                    if (SnsUIAction.this.gRE >= childAt.getHeight()) {
                        SnsUIAction.this.gRE -= childAt.getHeight();
                    }
                } else if (Math.abs(top - SnsUIAction.this.EON) > 1) {
                    if (top < SnsUIAction.this.EON) {
                        SnsUIAction.this.EOS = SnsUIAction.EOL;
                    } else if (top > SnsUIAction.this.EON) {
                        SnsUIAction.this.EOS = SnsUIAction.EOM;
                    }
                }
                SnsUIAction.this.EOU = (-top) + SnsUIAction.this.gRE;
                SnsUIAction.this.lastIndex = i2;
                SnsUIAction.this.EON = top;
                if (SnsUIAction.this.EOT != SnsUIAction.this.EOS) {
                    SnsUIAction.this.start = SnsUIAction.this.EOU;
                    SnsUIAction.this.EOV = false;
                }
                if (i2 == 0) {
                    int i8 = -childAt.getTop();
                    SnsUIAction.this.EOU = i8;
                    if (i8 >= 0 && i8 <= fromDPToPix2) {
                        f3 = 1.0f;
                        f2 = 1.0f;
                    } else if (i8 <= fromDPToPix3) {
                        f3 = 1.0f - (((float) (i8 - fromDPToPix2)) / ((float) (fromDPToPix3 - fromDPToPix2)));
                        f2 = 1.0f - (((float) (i8 - fromDPToPix2)) / ((float) (fromDPToPix3 - fromDPToPix2)));
                    } else {
                        if (i8 <= i7 + fromDPToPix) {
                            f5 = (((float) (i8 - i7)) * 1.0f) / ((float) fromDPToPix);
                        }
                        f2 = 0.0f;
                        f3 = f5;
                    }
                    if (i8 >= 0 && i8 <= i7) {
                        f6 = 0.0f;
                        z = false;
                        i5 = 0;
                    } else if (i8 <= i7 + fromDPToPix) {
                        f6 = (((float) (i8 - i7)) * 1.0f) / ((float) fromDPToPix);
                        i5 = ((i8 - i7) * 100) / fromDPToPix;
                    } else {
                        if (i8 > i7 + fromDPToPix) {
                            f4 = 1.0f;
                            i6 = 100;
                        } else {
                            f4 = 1.0f;
                        }
                        f6 = f4;
                        i5 = i6;
                    }
                } else {
                    i5 = 100;
                    f2 = 0.0f;
                    f3 = 1.0f;
                }
                if (SnsUIAction.this.maskView != null) {
                    Log.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", Integer.valueOf(SnsUIAction.this.EOU), Integer.valueOf(top), Integer.valueOf(SnsUIAction.this.gRE));
                    if (SnsUIAction.this.EOU > i7 || SnsUIAction.this.EvK) {
                        SnsUIAction.this.maskView.setVisibility(8);
                    } else {
                        SnsUIAction.this.maskView.setVisibility(0);
                    }
                }
                SnsUIAction.this.EOO = SnsUIAction.this.EOU;
                SnsUIAction.this.EOT = SnsUIAction.this.EOS;
                if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                    mMActivity = (SnsTimeLineUI) SnsUIAction.this.mActivity;
                } else if (SnsUIAction.this.mActivity instanceof SnsUserUI) {
                    mMActivity = (SnsUserUI) SnsUIAction.this.mActivity;
                } else {
                    mMActivity = null;
                }
                if (mMActivity != null) {
                    if (SnsUIAction.this.EvK) {
                        i5 = 100;
                        f3 = 1.0f;
                        f6 = 1.0f;
                    }
                    if (SnsUIAction.this.zlN != i5) {
                        if (i5 <= 0) {
                            mMActivity.setActionbarColor(SnsUIAction.this.mActivity.getResources().getColor(R.color.ac_));
                        } else {
                            mMActivity.setActionbarColor(ar.fj(SnsUIAction.this.mActivity.getResources().getColor(R.color.a2r), i5));
                        }
                        if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                            if (z) {
                                mMActivity.updateOptionMenuIcon(0, R.raw.icons_outlined_camera);
                            } else {
                                mMActivity.updateOptionMenuIcon(0, R.raw.icons_filled_camera);
                            }
                        }
                    }
                    SnsUIAction.this.EOI.iR(i2, i5);
                    if (SnsUIAction.this.EOQ != f6) {
                        mMActivity.setTitleAlpha(f6);
                    }
                    if (SnsUIAction.this.EOP != f3) {
                        mMActivity.setIconAlpha(f3);
                    }
                }
                SnsUIAction.this.zlN = i5;
                SnsUIAction.this.EOP = f3;
                SnsUIAction.this.EOQ = f6;
                SnsUIAction.this.EOR = f2;
                SnsUIAction.a(SnsUIAction.this, absListView, i2, i3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
                AppMethodBeat.o(99470);
            }
        });
        this.zog = this.EOI.fji();
        Log.i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.zog != null));
        this.zog.setOnTopLoadDataListener(new MMPullDownView.g() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.g
            public final boolean cAm() {
                AppMethodBeat.i(99471);
                SnsUIAction.this.EOI.fjk();
                AppMethodBeat.o(99471);
                return true;
            }
        });
        this.zog.setTopViewVisible(false);
        this.zog.setIsTopShowAll(false);
        this.zog.setAtBottomCallBack(new MMPullDownView.c() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.c
            public final boolean cAl() {
                AppMethodBeat.i(99472);
                View childAt = SnsUIAction.this.list.getChildAt(SnsUIAction.this.list.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > SnsUIAction.this.list.getHeight() || SnsUIAction.this.list.getLastVisiblePosition() != SnsUIAction.this.list.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(99472);
                    return false;
                }
                AppMethodBeat.o(99472);
                return true;
            }
        });
        this.zog.setAtTopCallBack(new MMPullDownView.d() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass13 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.d
            public final boolean cAk() {
                AppMethodBeat.i(99473);
                View childAt = SnsUIAction.this.list.getChildAt(SnsUIAction.this.list.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    AppMethodBeat.o(99473);
                    return false;
                }
                AppMethodBeat.o(99473);
                return true;
            }
        });
        this.zog.setIsBottomShowAll(false);
        this.zog.setOnBottomLoadDataListener(new MMPullDownView.e() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass14 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.e
            public final boolean cAj() {
                AppMethodBeat.i(99474);
                Log.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + SnsUIAction.this.qeT);
                if (!SnsUIAction.this.qeT) {
                    SnsUIAction.g(SnsUIAction.this);
                }
                AppMethodBeat.o(99474);
                return true;
            }
        });
        this.zog.setShowBackground(true);
        this.zog.setBgColor(MMApplicationContext.getContext().getResources().getColor(R.color.f3045c));
        this.title = this.mActivity.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.DSh;
        if (Util.isNullOrNil(this.mRa)) {
            str = this.ELj;
        } else {
            str = this.mRa;
        }
        String str2 = this.ELj;
        String str3 = this.krY;
        String str4 = this.mSignature;
        if (str == null || str2 == null) {
            Log.e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = str.trim();
            snsHeader.gna = str2.trim();
            snsHeader.dJM = str2.equals(str);
            Log.d("MicroMsg.SnsHeader", "userNamelen " + str.length() + "  " + str);
            snsHeader.EDy.oSN.setText(str);
            if (!(snsHeader.EDy == null || snsHeader.EDy.gyr == null)) {
                a.b.A(snsHeader.EDy.gyr, snsHeader.userName);
            }
            if (str != null && str.length() > 0) {
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                if (Kn == null || Util.isNullOrNil(Kn.arJ())) {
                    R = com.tencent.mm.plugin.sns.data.r.R(str3);
                } else {
                    R = Kn.arJ();
                }
                snsHeader.EDy.oSN.setText(com.tencent.mm.pluginsdk.ui.span.l.c(snsHeader.context, R));
                snsHeader.EDy.Eob.setText(com.tencent.mm.pluginsdk.ui.span.l.b(snsHeader.context, str4, snsHeader.EDy.Eob.getTextSize()));
            }
            snsHeader.EDy.gyr.setContentDescription(snsHeader.context.getString(R.string.h55, snsHeader.EDy.oSN.getText()));
        }
        SnsHeader snsHeader2 = this.DSh;
        int type = this.EOI.getType();
        snsHeader2.type = type;
        if (type == 1 && snsHeader2.EDy.Eob != null) {
            snsHeader2.EDy.Eob.setVisibility(8);
        }
        if (snsHeader2.EDy != null) {
            if (snsHeader2.EDy.EDP != null && snsHeader2.EDF) {
                snsHeader2.EDy.EDP.setSnsType(type);
            }
            if (snsHeader2.EDy.EDQ != null && !snsHeader2.EDF) {
                snsHeader2.EDy.EDQ.setSnsType(type);
            }
        }
        if (type != 1) {
            if (!(snsHeader2.EDy.EDP == null || snsHeader2.EDy.EDP.getParent() == null || !(snsHeader2.EDy.EDP.getParent() instanceof ViewGroup))) {
                ((ViewGroup) snsHeader2.EDy.EDP.getParent()).removeView(snsHeader2.EDy.EDP);
            }
            if (!(snsHeader2.EDy.EDQ == null || snsHeader2.EDy.EDQ.getParent() == null || !(snsHeader2.EDy.EDQ.getParent() instanceof ViewGroup))) {
                ((ViewGroup) snsHeader2.EDy.EDQ.getParent()).removeView(snsHeader2.EDy.EDQ);
            }
        }
        if (type == 1) {
            snsHeader2.EDy.EDS.setPadding(0, (au.eu(snsHeader2.context) + au.aD(snsHeader2.context)) - snsHeader2.getResources().getDimensionPixelSize(R.dimen.ak_), 0, at.fromDPToPix(snsHeader2.context, 10));
        } else if (type == 2) {
            snsHeader2.EDy.EDS.setPadding(0, au.eu(snsHeader2.context) + au.aD(snsHeader2.context) + at.fromDPToPix(snsHeader2.getContext(), 90) + at.fromDPToPix(snsHeader2.getContext(), 48), 0, 0);
        }
        if (!(type != 1 || snsHeader2.EDy == null || snsHeader2.EDy.EDV == null)) {
            if (SnsHeader.fic()) {
                snsHeader2.EDy.EDU = ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).getFinderUtilApi().ao((Activity) snsHeader2.context);
                snsHeader2.EDy.EDV.addView(snsHeader2.EDy.EDU.dHb(), new FrameLayout.LayoutParams(-1, -2));
                snsHeader2.EDy.EDU.a(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x027d: INVOKE  
                      (wrap: com.tencent.mm.plugin.i.a.ab : 0x0276: IGET  (r0v87 com.tencent.mm.plugin.i.a.ab) = 
                      (wrap: com.tencent.mm.plugin.sns.ui.SnsHeader$c : 0x0274: IGET  (r0v86 com.tencent.mm.plugin.sns.ui.SnsHeader$c) = (r3v22 'snsHeader2' com.tencent.mm.plugin.sns.ui.SnsHeader) com.tencent.mm.plugin.sns.ui.SnsHeader.EDy com.tencent.mm.plugin.sns.ui.SnsHeader$c)
                     com.tencent.mm.plugin.sns.ui.SnsHeader.c.EDU com.tencent.mm.plugin.i.a.ab)
                      (wrap: com.tencent.mm.plugin.sns.ui.SnsHeader$1 : 0x027a: CONSTRUCTOR  (r1v11 com.tencent.mm.plugin.sns.ui.SnsHeader$1) = 
                      (r3v22 'snsHeader2' com.tencent.mm.plugin.sns.ui.SnsHeader)
                      (r10v0 'this' com.tencent.mm.plugin.sns.ui.SnsUIAction A[IMMUTABLE_TYPE, THIS])
                     call: com.tencent.mm.plugin.sns.ui.SnsHeader.1.<init>(com.tencent.mm.plugin.sns.ui.SnsHeader, com.tencent.mm.plugin.sns.ui.SnsUIAction):void type: CONSTRUCTOR)
                     type: INTERFACE call: com.tencent.mm.plugin.i.a.ab.a(com.tencent.mm.plugin.i.a.ab$a):void in method: com.tencent.mm.plugin.sns.ui.SnsUIAction.onCreate():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x027a: CONSTRUCTOR  (r1v11 com.tencent.mm.plugin.sns.ui.SnsHeader$1) = 
                      (r3v22 'snsHeader2' com.tencent.mm.plugin.sns.ui.SnsHeader)
                      (r10v0 'this' com.tencent.mm.plugin.sns.ui.SnsUIAction A[IMMUTABLE_TYPE, THIS])
                     call: com.tencent.mm.plugin.sns.ui.SnsHeader.1.<init>(com.tencent.mm.plugin.sns.ui.SnsHeader, com.tencent.mm.plugin.sns.ui.SnsUIAction):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.SnsUIAction.onCreate():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 24 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.ui.SnsHeader, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 30 more
                    */
                /*
                // Method dump skipped, instructions count: 998
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsUIAction.onCreate():void");
            }

            public final void bIW() {
                int i2;
                int i3;
                AppMethodBeat.i(99478);
                this.EOW.cancel();
                this.xjs.clear();
                int lastVisiblePosition = this.list.getLastVisiblePosition();
                Log.i("MicroMsg.SnsVideoService", "currentPosition :%d count:%d", Integer.valueOf(lastVisiblePosition), Integer.valueOf(this.list.getCount()));
                int count = this.list.getCount();
                if (count - lastVisiblePosition > 15) {
                    i3 = lastVisiblePosition + 15;
                    i2 = lastVisiblePosition;
                } else {
                    i3 = count;
                    i2 = lastVisiblePosition;
                }
                while (i2 < i3) {
                    Object itemAtPosition = this.list.getItemAtPosition(i2);
                    if ((itemAtPosition instanceof SnsInfo) && ((SnsInfo) itemAtPosition).getTypeFlag() == 15 && (!((SnsInfo) itemAtPosition).isAd() || com.tencent.mm.plugin.sns.ad.timeline.b.a.n((SnsInfo) itemAtPosition))) {
                        this.xjs.add((SnsInfo) itemAtPosition);
                    }
                    i2++;
                }
                h.RTc.aX(this.EOW);
                AppMethodBeat.o(99478);
            }

            public final void vy(boolean z) {
                AppMethodBeat.i(99479);
                this.EOI.vy(z);
                AppMethodBeat.o(99479);
            }

            public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i2) {
                this.ELj = str;
                this.mRa = str2;
                this.krY = str3;
                this.mSignature = str4;
                this.ELk = z;
                this.EqY = z2;
                this.ELl = i2;
            }

            public final void onResume() {
                AppMethodBeat.i(99480);
                aj.faJ().aO(2, false);
                com.tencent.mm.pluginsdk.wallet.h.setPayChannel(7);
                pg pgVar = new pg();
                pgVar.dVo.pause = true;
                EventCenter.instance.asyncPublish(pgVar, Looper.getMainLooper());
                Log.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
                if (this.DSh != null) {
                    this.DSh.onResume();
                    BaseAdapter anl = anl();
                    if (anl != null) {
                        boolean fx = this.DSh.fx(this.actionbarView);
                        if (!fx) {
                            fx = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt;
                        }
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053(this.list, anl, c.e.VISIABLE_ON_RESUME.state, -1, -1, 1, "61", 2, fx);
                    }
                }
                AppMethodBeat.o(99480);
            }

            public final void onPause() {
                AppMethodBeat.i(99481);
                pg pgVar = new pg();
                pgVar.dVo.pause = false;
                EventCenter.instance.asyncPublish(pgVar, Looper.getMainLooper());
                Log.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
                if (this.DSh != null) {
                    SnsHeader snsHeader = this.DSh;
                    if (!(snsHeader.EDy == null || snsHeader.EDy.EDQ == null || snsHeader.EDF)) {
                        SnsStoryHeaderView snsStoryHeaderView = snsHeader.EDy.EDQ;
                        snsStoryHeaderView.FdC = false;
                        snsStoryHeaderView.dLD = true;
                    }
                    BaseAdapter anl = anl();
                    if (anl != null) {
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt = this.DSh.fx(this.actionbarView);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053(this.list, anl, c.e.INVISIABLE_ON_PAUSE.state, -1, -1, 1, "61", 3, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt);
                    }
                }
                AppMethodBeat.o(99481);
            }

            public final void setSessionId(String str) {
                AppMethodBeat.i(99482);
                this.sessionId = str;
                if (this.DSh != null) {
                    this.DSh.setSessionId(str);
                }
                AppMethodBeat.o(99482);
            }

            /* access modifiers changed from: protected */
            public final void onActivityResult(int i2, int i3, Intent intent) {
                String stringExtra;
                AppMethodBeat.i(99483);
                Log.i("MicroMsg.SnsActivity", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
                if (i3 != -1) {
                    if (i2 == 5 || i2 == 2 || i2 == 4) {
                        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass16 */

                            public final void run() {
                                AppMethodBeat.i(176360);
                                com.tencent.mm.plugin.sns.c.a.jRu.Xb();
                                AppMethodBeat.o(176360);
                            }
                        });
                    }
                    com.tencent.mm.plugin.sns.data.r.eZy();
                    AppMethodBeat.o(99483);
                    return;
                }
                switch (i2) {
                    case 2:
                        if (intent == null) {
                            AppMethodBeat.o(99483);
                            return;
                        }
                        g.aAi();
                        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(68393, (Object) null), 0);
                        g.aAi();
                        g.aAh().azQ().set(68393, Integer.valueOf(nullAs + 1));
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                        com.tencent.mm.plugin.sns.c.a.jRt.a(this.mActivity, intent, intent2, aj.getAccSnsTmpPath(), 4, new a.AbstractC2129a() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.tools.a.AbstractC2129a
                            public final String aQX(String str) {
                                AppMethodBeat.i(176354);
                                String str2 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest((SnsUIAction.this.filePath + System.currentTimeMillis()).getBytes());
                                AppMethodBeat.o(176354);
                                return str2;
                            }
                        });
                        AppMethodBeat.o(99483);
                        return;
                    case 3:
                    case 11:
                    case 16:
                    default:
                        Log.e("MicroMsg.SnsActivity", "onActivityResult: not found this requestCode");
                        AppMethodBeat.o(99483);
                        return;
                    case 4:
                        if (intent == null) {
                            AppMethodBeat.o(99483);
                            return;
                        }
                        this.filePath = intent.getStringExtra("CropImage_OutputPath");
                        ba(intent);
                        AppMethodBeat.o(99483);
                        return;
                    case 5:
                        this.filePath = s.h(this.mActivity.getApplicationContext(), intent, aj.getAccSnsTmpPath());
                        Log.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_TAKE_PHOTO  filePath" + this.filePath);
                        if (this.filePath == null) {
                            AppMethodBeat.o(99483);
                            return;
                        }
                        g.aAi();
                        int nullAs2 = Util.nullAs((Integer) g.aAh().azQ().get(68392, (Object) null), 0);
                        g.aAi();
                        g.aAh().azQ().set(68392, Integer.valueOf(nullAs2 + 1));
                        this.DEF = true;
                        ba(intent);
                        AppMethodBeat.o(99483);
                        return;
                    case 6:
                        Log.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_UPLOAD_MEDIA");
                        if (intent == null) {
                            AppMethodBeat.o(99483);
                            return;
                        }
                        this.EOI.d(intent.getIntExtra("sns_local_id", -1), null, null);
                        aj.faK().eZn();
                        AppMethodBeat.o(99483);
                        return;
                    case 7:
                        Log.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHANGE_BG");
                        this.DSh.fid();
                        aj.faK().eZn();
                        AppMethodBeat.o(99483);
                        return;
                    case 8:
                        if (intent == null) {
                            AppMethodBeat.o(99483);
                            return;
                        }
                        Log.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_GALLERY_OP");
                        SnsCmdList snsCmdList = (SnsCmdList) intent.getParcelableExtra("sns_cmd_list");
                        if (snsCmdList != null) {
                            this.EOI.d(-1, snsCmdList.DEl, snsCmdList.DEm);
                            AppMethodBeat.o(99483);
                            return;
                        }
                        break;
                    case 9:
                        aj.faK().eZn();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.list);
                        Object obj = new Object();
                        com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUIAction", "onActivityResult", "(IILandroid/content/Intent;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/sns/ui/SnsUIAction", "onActivityResult", "(IILandroid/content/Intent;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                        AppMethodBeat.o(99483);
                        return;
                    case 10:
                        if (intent == null) {
                            AppMethodBeat.o(99483);
                            return;
                        } else if (i3 == -1) {
                            Cursor managedQuery = this.mActivity.managedQuery(intent.getData(), null, null, null, null);
                            if (managedQuery.moveToFirst()) {
                                Intent intent3 = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id"))))));
                                Activity activity = this.mActivity;
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                                com.tencent.mm.hellhoundlib.a.a.a(activity, bl2.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUIAction", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                activity.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/SnsUIAction", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            AppMethodBeat.o(99483);
                            return;
                        }
                        break;
                    case 12:
                        int intExtra = intent.getIntExtra("sns_gallery_op_id", -1);
                        if (intExtra > 0) {
                            Log.d("MicroMsg.SnsActivity", "notify cause by del item");
                            SnsCmdList snsCmdList2 = new SnsCmdList();
                            snsCmdList2.Yj(intExtra);
                            this.EOI.d(-1, snsCmdList2.DEl, snsCmdList2.DEm);
                            AppMethodBeat.o(99483);
                            return;
                        }
                        break;
                    case 13:
                        aj.faT().ctN();
                        AppMethodBeat.o(99483);
                        return;
                    case 14:
                        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(99461);
                                com.tencent.mm.plugin.sns.c.a.jRu.Xb();
                                AppMethodBeat.o(99461);
                            }
                        });
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        com.tencent.mm.plugin.sns.data.r.aOz(intent.getStringExtra("KSEGMENTMEDIAEDITID"));
                        if ((stringArrayListExtra != null && stringArrayListExtra.size() > 0) || !Util.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                                stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                            } else {
                                stringExtra = stringArrayListExtra.get(0);
                            }
                            String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                            if (Util.isNullOrNil(stringExtra2) || !com.tencent.mm.vfs.s.YS(stringExtra2)) {
                                stringExtra2 = aj.getAccSnsTmpPath() + com.tencent.mm.vfs.s.bhK(stringExtra);
                                com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
                                try {
                                    dVar.setDataSource(stringExtra);
                                    Bitmap frameAtTime = dVar.getFrameAtTime(0);
                                    if (frameAtTime == null) {
                                        Log.e("MicroMsg.SnsActivity", "get bitmap error");
                                        try {
                                            dVar.release();
                                            AppMethodBeat.o(99483);
                                            return;
                                        } catch (Exception e2) {
                                            AppMethodBeat.o(99483);
                                            return;
                                        }
                                    } else {
                                        Log.i("MicroMsg.SnsActivity", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                                        BitmapUtil.saveBitmapToImage(frameAtTime, 80, Bitmap.CompressFormat.JPEG, stringExtra2, true);
                                        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(stringExtra2);
                                        Log.i("MicroMsg.SnsActivity", "getBitmap2 %d %d", Integer.valueOf(imageOptions.outWidth), Integer.valueOf(imageOptions.outHeight));
                                        try {
                                            dVar.release();
                                        } catch (Exception e3) {
                                        }
                                    }
                                } catch (Exception e4) {
                                    Log.e("MicroMsg.SnsActivity", "savebitmap error %s", e4.getMessage());
                                    try {
                                        dVar.release();
                                    } catch (Exception e5) {
                                    }
                                } catch (Throwable th) {
                                    try {
                                        dVar.release();
                                    } catch (Exception e6) {
                                    }
                                    AppMethodBeat.o(99483);
                                    throw th;
                                }
                            }
                            Log.i("MicroMsg.SnsActivity", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(com.tencent.mm.vfs.s.boW(stringExtra)), Long.valueOf(com.tencent.mm.vfs.s.boW(stringExtra2)));
                            Intent intent4 = new Intent();
                            intent4.putExtra("KSightPath", stringExtra);
                            intent4.putExtra("KSightThumbPath", stringExtra2);
                            intent4.putExtra("sight_md5", com.tencent.mm.vfs.s.bhK(stringExtra));
                            intent4.putExtra("KSnsPostManu", true);
                            intent4.putExtra("KTouchCameraTime", Util.nowSecond());
                            intent4.putExtra("Ksnsupload_type", 14);
                            intent4.putExtra("Kis_take_photo", false);
                            com.tencent.mm.br.c.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent4);
                            AppMethodBeat.o(99483);
                            return;
                        } else if (intent.getBundleExtra("key_extra_data") != null) {
                            Log.i("MicroMsg.SnsActivity", "goto vlog mode");
                            Intent intent5 = new Intent();
                            intent5.putExtra("Kis_take_photo", false);
                            intent5.putExtra("KSnsPostManu", true);
                            intent5.putExtra("Ksnsupload_type", 14);
                            intent5.putExtra("key_extra_data", intent.getBundleExtra("key_extra_data"));
                            com.tencent.mm.br.c.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent5);
                            AppMethodBeat.o(99483);
                            return;
                        } else {
                            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                            if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                                Log.i("MicroMsg.SnsActivity", "no image selected");
                                AppMethodBeat.o(99483);
                                return;
                            }
                            ArrayList<String> arrayList = new ArrayList<>();
                            Iterator<String> it = stringArrayListExtra2.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                Exif.a location = Exif.fromFile(next).getLocation();
                                if (location != null) {
                                    arrayList.add(String.format("%s\n%f\n%f", next, Double.valueOf(location.latitude), Double.valueOf(location.longitude)));
                                }
                            }
                            this.DEF = intent.getBooleanExtra("isTakePhoto", false);
                            Intent intent6 = new Intent(this.mActivity, SnsUploadUI.class);
                            intent6.putExtra("KSnsPostManu", true);
                            intent6.putExtra("KTouchCameraTime", Util.nowSecond());
                            if (this.EOY != null) {
                                this.EOY.b(intent6, "intent_key_StatisticsOplog");
                                this.EOY = null;
                            }
                            if (this.EqY) {
                                intent6.putExtra("Ksnsupload_source", 11);
                            }
                            int intExtra2 = intent.getIntExtra("CropImage_filterId", 0);
                            intent6.putExtra("sns_kemdia_path_list", stringArrayListExtra2);
                            intent6.putExtra("KFilterId", intExtra2);
                            if (this.DEF) {
                                intent6.putExtra("Kis_take_photo", true);
                            }
                            intent6.putStringArrayListExtra("sns_media_latlong_list", arrayList);
                            Log.d("MicroMsg.SnsActivity", "shared type %d", Integer.valueOf(intent6.getIntExtra("Ksnsupload_type", -1)));
                            this.mActivity.startActivityForResult(intent6, 6);
                            AppMethodBeat.o(99483);
                            return;
                        }
                    case 15:
                        AppMethodBeat.o(99483);
                        return;
                    case 17:
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        if (sightCaptureResult != null) {
                            if (sightCaptureResult.zsy) {
                                this.filePath = sightCaptureResult.zsG;
                                if (!Util.isNullOrNil(this.filePath)) {
                                    this.DEF = true;
                                    ba(intent);
                                    AppMethodBeat.o(99483);
                                    return;
                                }
                            } else {
                                Log.i("MicroMsg.SnsActivity", "video path %s thumb path ", sightCaptureResult.zsA, sightCaptureResult.zsB);
                                Intent intent7 = new Intent();
                                intent7.putExtra("KSightPath", sightCaptureResult.zsA);
                                intent7.putExtra("KSightThumbPath", sightCaptureResult.zsB);
                                if (!Util.isNullOrNil(sightCaptureResult.zsD)) {
                                    intent7.putExtra("sight_md5", sightCaptureResult.zsD);
                                } else {
                                    intent7.putExtra("sight_md5", com.tencent.mm.vfs.s.bhK(sightCaptureResult.zsA));
                                }
                                intent7.putExtra("KSnsPostManu", true);
                                intent7.putExtra("KTouchCameraTime", Util.nowSecond());
                                intent7.putExtra("Ksnsupload_type", 14);
                                intent7.putExtra("Kis_take_photo", false);
                                intent7.putExtra("KSessionID", intent.getStringExtra("KSessionID"));
                                try {
                                    byte[] byteArray = sightCaptureResult.zsF.toByteArray();
                                    if (byteArray != null) {
                                        intent7.putExtra("KMMSightExtInfo", byteArray);
                                    }
                                } catch (Exception e7) {
                                    Log.i("MicroMsg.SnsActivity", "put sight extinfo to snsuploadui error: %s", e7.getMessage());
                                }
                                com.tencent.mm.br.c.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent7);
                                AppMethodBeat.o(99483);
                                return;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(99483);
            }

            private void ba(Intent intent) {
                int i2;
                AppMethodBeat.i(99484);
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(176355);
                        com.tencent.mm.plugin.sns.c.a.jRu.Xb();
                        AppMethodBeat.o(176355);
                    }
                });
                Log.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
                Log.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
                if (this.filePath == null) {
                    AppMethodBeat.o(99484);
                    return;
                }
                com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.aLH(this.filePath);
                String str = "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest((this.filePath + System.currentTimeMillis()).getBytes());
                r.aR(aj.getAccSnsTmpPath(), this.filePath, str);
                com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.aLF(this.filePath);
                this.filePath = aj.getAccSnsTmpPath() + str;
                Log.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
                if (intent != null) {
                    i2 = intent.getIntExtra("CropImage_filterId", 0);
                } else {
                    i2 = 0;
                }
                Intent intent2 = new Intent(this.mActivity, SnsUploadUI.class);
                intent2.putExtra("KSnsPostManu", true);
                intent2.putExtra("KTouchCameraTime", Util.nowSecond());
                if (this.EOY != null) {
                    this.EOY.b(intent2, "intent_key_StatisticsOplog");
                    this.EOY = null;
                }
                intent2.putExtra("sns_kemdia_path", this.filePath);
                intent2.putExtra("KFilterId", i2);
                if (this.DEF) {
                    intent2.putExtra("Kis_take_photo", true);
                }
                if (this.EqY) {
                    intent2.putExtra("Ksnsupload_source", 11);
                }
                intent2.putExtra("KSessionID", intent.getStringExtra("KSessionID"));
                this.mActivity.startActivityForResult(intent2, 6);
                this.DEF = false;
                AppMethodBeat.o(99484);
            }

            /* access modifiers changed from: protected */
            public final boolean ZX(final int i2) {
                boolean z;
                int i3 = 3;
                boolean z2 = false;
                AppMethodBeat.i(99485);
                g.aAi();
                if (!g.aAh().isSDCardAvailable()) {
                    u.g(this.mActivity, null);
                    AppMethodBeat.o(99485);
                    return false;
                }
                Log.d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(i2)));
                if (i2 == 2) {
                    Intent intent = new Intent();
                    intent.putExtra(ch.COL_USERNAME, this.ELj);
                    intent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
                    this.mActivity.startActivityForResult(intent, 7);
                    AppMethodBeat.o(99485);
                    return true;
                }
                if (i2 == 1) {
                    g.aAi();
                    int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(68385, (Object) null), 0);
                    g.aAi();
                    int nullAs2 = Util.nullAs((Integer) g.aAh().azQ().get(68386, (Object) null), 0);
                    if (!this.EOG && nullAs < 3 && nullAs2 == 0) {
                        this.EOG = true;
                        bn.g(this.mActivity, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(176356);
                                g.aAi();
                                g.aAi();
                                g.aAh().azQ().set(68386, Integer.valueOf(Util.nullAs((Integer) g.aAh().azQ().get(68386, (Object) null), 0) + 1));
                                SnsUIAction.this.ZX(i2);
                                AppMethodBeat.o(176356);
                            }
                        });
                        AppMethodBeat.o(99485);
                        return true;
                    } else if (this.mActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1").equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        s.c(this.mActivity, 2, null);
                    } else {
                        int i4 = com.tencent.mm.n.h.aqJ().getInt("SnsCanPickVideoFromAlbum", 1);
                        Log.i("MicroMsg.SnsActivity", "takeVideo %d", Integer.valueOf(i4));
                        if (ac.jPB) {
                            i4 = 0;
                        }
                        if (i4 != 1 && i4 == 0) {
                            i3 = 1;
                        }
                        Intent intent2 = new Intent();
                        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_enable_vlog, false);
                        if (g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0) == 1 || a2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            z2 = true;
                        }
                        intent2.putExtra("key_can_select_video_and_pic", z2);
                        intent2.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.baZ().bbc().duration);
                        if (this.mActivity instanceof SnsUserUI) {
                            intent2.putExtra("gallery_report_tag", 17);
                        } else {
                            intent2.putExtra("gallery_report_tag", 4);
                        }
                        s.a(this.mActivity, 14, 9, 4, i3, intent2);
                    }
                }
                AppMethodBeat.o(99485);
                return true;
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void aOG(String str) {
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void cj(String str, boolean z) {
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void eZJ() {
                AppMethodBeat.i(99487);
                this.DSh.fid();
                AppMethodBeat.o(99487);
            }

            /* access modifiers changed from: protected */
            public final void fjw() {
                AppMethodBeat.i(160742);
                this.EOC.PL();
                AppMethodBeat.o(160742);
            }

            /* access modifiers changed from: protected */
            public final void aRh(String str) {
                AppMethodBeat.i(99488);
                Log.d("MicroMsg.SnsActivity", "snsactivty onIsDownAll ");
                this.EOC.aQU(str);
                AppMethodBeat.o(99488);
            }

            /* access modifiers changed from: protected */
            public final void aQU(String str) {
                AppMethodBeat.i(99490);
                Log.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
                this.EOC.aQU(str);
                AppMethodBeat.o(99490);
            }

            public final void fjx() {
                AppMethodBeat.i(99491);
                if (this.EOI != null && this.EOI.getType() == 2) {
                    aj.eJP().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass6 */

                        public final void run() {
                            String str;
                            AppMethodBeat.i(99466);
                            List<ebo> aQs = aj.faS().aQs(SnsUIAction.this.mRa);
                            final m mVar = new m();
                            if (!Util.isNullOrNil(aQs)) {
                                ArrayList arrayList = new ArrayList();
                                HashMap hashMap = new HashMap();
                                String str2 = "";
                                for (ebo ebo : aQs) {
                                    String valueOf = String.valueOf(ebo.Nbm);
                                    String valueOf2 = String.valueOf(ebo.Nbn);
                                    Long valueOf3 = Long.valueOf(ebo.Nbo);
                                    if (!Util.isEqual(str2, valueOf)) {
                                        arrayList = new ArrayList();
                                        HashMap hashMap2 = new HashMap();
                                        mVar.DEq.add(valueOf);
                                        mVar.DEr.add(arrayList);
                                        mVar.map.put(valueOf, hashMap2);
                                        str = valueOf;
                                        hashMap = hashMap2;
                                    } else {
                                        str = str2;
                                    }
                                    arrayList.add(valueOf2);
                                    hashMap.put(valueOf2, valueOf3);
                                    str2 = str;
                                }
                            }
                            Collections.reverse(mVar.DEq);
                            Collections.reverse(mVar.DEr);
                            Iterator<List<String>> it = mVar.DEr.iterator();
                            while (it.hasNext()) {
                                Collections.reverse(it.next());
                            }
                            aj.dRd().post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsUIAction.AnonymousClass6.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(176357);
                                    SnsUIAction.this.EOI.a(mVar);
                                    AppMethodBeat.o(176357);
                                }
                            });
                            AppMethodBeat.o(99466);
                        }
                    });
                }
                AppMethodBeat.o(99491);
            }

            public final void vz(boolean z) {
                AppMethodBeat.i(179310);
                this.EvK = z;
                if (z) {
                    if (this.zog != null) {
                        this.zog.setEnableGesture(false);
                    }
                    SnsHeader snsHeader = this.DSh;
                    if (!(snsHeader.EDy == null || snsHeader.EDy.EDS == null || snsHeader.EDy.EDR == null)) {
                        snsHeader.EDy.EDS.setVisibility(0);
                        snsHeader.EDy.EDR.setVisibility(8);
                    }
                    AppMethodBeat.o(179310);
                    return;
                }
                if (this.zog != null) {
                    this.zog.setEnableGesture(true);
                }
                SnsHeader snsHeader2 = this.DSh;
                if (!(snsHeader2.EDy == null || snsHeader2.EDy.EDS == null || snsHeader2.EDy.EDR == null)) {
                    snsHeader2.EDy.EDS.setVisibility(4);
                    snsHeader2.EDy.EDR.setVisibility(0);
                }
                AppMethodBeat.o(179310);
            }

            public final void fjy() {
                AppMethodBeat.i(99493);
                if (getSnsListView() != null) {
                    getSnsListView().setVisibility(8);
                }
                AppMethodBeat.o(99493);
            }

            public final void fjz() {
                AppMethodBeat.i(99494);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V", this);
                if (this.DSh != null) {
                    SnsHeader snsHeader = this.DSh;
                    if (!(snsHeader.EDy == null || snsHeader.EDy.EDP == null || !snsHeader.EDF)) {
                        snsHeader.EDy.EDP.fjz();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V");
                AppMethodBeat.o(99494);
            }

            public final int getHeaderHeight() {
                AppMethodBeat.i(179311);
                if (this.DSh != null) {
                    int measuredHeight = this.DSh.getMeasuredHeight();
                    AppMethodBeat.o(179311);
                    return measuredHeight;
                }
                AppMethodBeat.o(179311);
                return 0;
            }

            public final void fjA() {
                AppMethodBeat.i(203752);
                if (this.DSh != null) {
                    SnsHeader snsHeader = this.DSh;
                    if (!(snsHeader.EDy == null || snsHeader.EDy.EDT == null || snsHeader.ErS == null)) {
                        snsHeader.ErS.cancel();
                        snsHeader.ErS.reset();
                        snsHeader.EDy.EDT.startAnimation(snsHeader.ErS);
                    }
                }
                AppMethodBeat.o(203752);
            }

            public final void fjB() {
                AppMethodBeat.i(203753);
                if (this.EOC != null) {
                    LoadingMoreView loadingMoreView = this.EOC;
                    loadingMoreView.ErS.cancel();
                    loadingMoreView.ErS.reset();
                    loadingMoreView.dPk.startAnimation(loadingMoreView.ErS);
                }
                AppMethodBeat.o(203753);
            }

            @Override // com.tencent.mm.plugin.sns.model.be.a
            public final void aP(int i2, boolean z) {
                AppMethodBeat.i(99495);
                this.EOI.aP(i2, z);
                AppMethodBeat.o(99495);
            }

            @Override // com.tencent.mm.plugin.sns.model.be.a
            public final void fbl() {
                AppMethodBeat.i(99496);
                if (this.DSh != null) {
                    this.DSh.fid();
                }
                AppMethodBeat.o(99496);
            }

            @Override // com.tencent.mm.plugin.sns.model.c.b
            public final void ci(String str, boolean z) {
                AppMethodBeat.i(99497);
                if (this.EOI.getType() == 1 && this.list != null && this.list.getAdapter() != null && (this.list.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.a.c)) {
                    ((com.tencent.mm.plugin.sns.ui.a.c) this.list.getAdapter()).notifyDataSetChanged();
                }
                AppMethodBeat.o(99497);
            }

            public ListView getSnsListView() {
                AppMethodBeat.i(99498);
                ListView snsListView = this.EOI.getSnsListView();
                AppMethodBeat.o(99498);
                return snsListView;
            }

            private BaseAdapter anl() {
                if (this.mActivity == null || this.DSh == null || this.actionbarView == null || !(this.mActivity instanceof SnsTimeLineUI)) {
                    return null;
                }
                return ((SnsTimeLineUI) this.mActivity).EKT;
            }

            public final void onDestroy() {
                AppMethodBeat.i(99486);
                if (this.mActivity != null && (this.mActivity instanceof SnsTimeLineUI)) {
                    ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053(null, null, c.e.EVENT_ON_DESTROY.state, -1, -1, 1, "61", 8, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt);
                }
                if (this.DSh != null) {
                    SnsHeader snsHeader = this.DSh;
                    if (snsHeader.EDE != null && !snsHeader.EDE.isRecycled()) {
                        snsHeader.EDE.recycle();
                    }
                    if (!(snsHeader.EDy == null || snsHeader.EDy.EDP == null || !snsHeader.EDF)) {
                        snsHeader.EDy.EDP.onDestroyView();
                    }
                    if (!(snsHeader.EDy == null || snsHeader.EDy.EDQ == null || snsHeader.EDF)) {
                        SnsStoryHeaderView snsStoryHeaderView = snsHeader.EDy.EDQ;
                        Log.i("MicroMsg.SnsStoryHeaderView", "destroy: ");
                        snsStoryHeaderView.aMn = true;
                        ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().b(snsStoryHeaderView);
                    }
                    if (!(snsHeader.EDy == null || snsHeader.EDy.EDU == null)) {
                        snsHeader.EDy.EDU.release();
                    }
                }
                g.aAi();
                if (g.aAf().azp()) {
                    aj.faL().aI(this.mActivity);
                    aj.faJ().b(this);
                }
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                g.aAi();
                if (g.aAf().azp()) {
                    aj.faK().b(this);
                }
                this.EOC.setVisibility(8);
                af.ffX();
                g.aAi();
                if (g.aAf().azp()) {
                    aj.faL().start();
                }
                this.list.setAdapter((ListAdapter) null);
                com.tencent.mm.plugin.sns.data.r.aOz("");
                AppMethodBeat.o(99486);
            }

            static /* synthetic */ void e(SnsUIAction snsUIAction) {
                AppMethodBeat.i(99499);
                View inflate = LayoutInflater.from(snsUIAction.mActivity).inflate(R.layout.bwp, (ViewGroup) snsUIAction.mActivity.findViewById(R.id.hzm));
                u uVar = new u(snsUIAction.mActivity);
                uVar.setGravity(48, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(snsUIAction.mActivity, 200.0f));
                uVar.duration = 1000;
                uVar.setView(inflate);
                uVar.gLj();
                AppMethodBeat.o(99499);
            }

            static /* synthetic */ void a(SnsUIAction snsUIAction, AbsListView absListView, int i2) {
                AppMethodBeat.i(203754);
                if (snsUIAction.EOZ != null) {
                    snsUIAction.EOZ.a(absListView, i2);
                }
                AppMethodBeat.o(203754);
            }

            static /* synthetic */ void g(SnsUIAction snsUIAction) {
                AppMethodBeat.i(203755);
                snsUIAction.EOI.fjg();
                AppMethodBeat.o(203755);
            }

            static /* synthetic */ void a(SnsUIAction snsUIAction, AbsListView absListView, int i2, int i3) {
                AppMethodBeat.i(203756);
                if (snsUIAction.EOZ != null) {
                    snsUIAction.EOZ.a(absListView, i2, i3);
                }
                AppMethodBeat.o(203756);
            }

            static /* synthetic */ void a(SnsUIAction snsUIAction, AbsListView absListView, BaseAdapter baseAdapter, int i2, int i3) {
                int i4;
                AppMethodBeat.i(203758);
                boolean fx = snsUIAction.DSh.fx(snsUIAction.actionbarView);
                if (fx && i2 > 0) {
                    fx = false;
                }
                com.tencent.mm.plugin.i.a.aj ajVar = (com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class);
                if (fx) {
                    i4 = c.e.VISIABLE_ON_SCROLL.state;
                } else {
                    i4 = c.e.INVISIABLE_ON_SCROLL.state;
                }
                ajVar.report21053(absListView, baseAdapter, i4, i2, i3, 1, "61", 1, fx);
                AppMethodBeat.o(203758);
            }
        }
