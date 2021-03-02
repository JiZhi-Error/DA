package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.g.a.g;
import com.tencent.mm.plugin.exdevice.g.a.i;
import com.tencent.mm.plugin.exdevice.g.a.l;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.plugin.exdevice.g.b.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public class ExdeviceProfileUI extends MMSecDataActivity implements e {
    private static int rJm = 0;
    private TextPaint ayn = new TextPaint(1);
    private int huY = 0;
    private GestureDetector jKk;
    private String mAppName;
    private boolean mIsDestroyed = false;
    private String mRa;
    private String mwj;
    private List<String> rCR;
    private List<String> rCS;
    private String rCo;
    private boolean rCz;
    private q rGN = null;
    private String rIS;
    private String rIT;
    private com.tencent.mm.plugin.exdevice.g.b.a.a rIU;
    private ArrayList<String> rIV;
    private ffn rIW;
    private ExdeviceProfileAffectedUserView rIX;
    private ImageView rIY;
    private ListView rIZ;
    private ExdeviceProfileListHeader rJa;
    private a rJb;
    private View rJc;
    private String rJd;
    private String rJe;
    private boolean rJf;
    private boolean rJg;
    private int rJh;
    private b<i> rJi = new b<i>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.exdevice.b.b
        public final /* synthetic */ void a(int i2, int i3, String str, i iVar) {
            AppMethodBeat.i(24095);
            final i iVar2 = iVar;
            if (ExdeviceProfileUI.this.isFinishing() || ExdeviceProfileUI.this.mIsDestroyed) {
                ExdeviceProfileUI.b(ExdeviceProfileUI.this);
                Log.i("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
                AppMethodBeat.o(24095);
            } else if (i2 == 0 && i3 == 0) {
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(24092);
                        if (ExdeviceProfileUI.this.rGN != null) {
                            ExdeviceProfileUI.this.rGN.dismiss();
                        }
                        ExdeviceProfileUI.this.rIV = iVar2.rCu;
                        ExdeviceProfileUI.this.rIX.setAffectedUserInfo(ExdeviceProfileUI.this.rIV);
                        AppMethodBeat.o(24092);
                    }
                });
                ExdeviceProfileUI.this.rIW = iVar2.rCt;
                ExdeviceProfileUI.this.rJd = iVar2.rCq;
                ExdeviceProfileUI.this.rJe = iVar2.msN;
                ExdeviceProfileUI.this.rJf = iVar2.rCx;
                ExdeviceProfileUI.this.rJh = iVar2.rCy;
                ExdeviceProfileUI.this.rCz = iVar2.rCz;
                ExdeviceProfileUI.this.rCo = iVar2.rCo;
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(24093);
                        ExdeviceProfileUI.f(ExdeviceProfileUI.this);
                        AppMethodBeat.o(24093);
                    }
                });
                if (!ExdeviceProfileUI.this.rJg) {
                    ExdeviceProfileUI exdeviceProfileUI = ExdeviceProfileUI.this;
                    boolean unused = ExdeviceProfileUI.this.rJf;
                    ExdeviceProfileUI.i(exdeviceProfileUI);
                }
                ExdeviceProfileUI.b(ExdeviceProfileUI.this);
                AppMethodBeat.o(24095);
            } else {
                AppMethodBeat.o(24095);
            }
        }
    };
    private o.g rJj = new o.g() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass28 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(179628);
            switch (menuItem.getItemId()) {
                case 0:
                    c.pl(26);
                    ExdeviceProfileUI.n(ExdeviceProfileUI.this);
                    AppMethodBeat.o(179628);
                    return;
                case 1:
                    c.pl(27);
                    ExdeviceProfileUI.m(ExdeviceProfileUI.this);
                    AppMethodBeat.o(179628);
                    return;
                case 2:
                    ExdeviceProfileUI.o(ExdeviceProfileUI.this);
                    AppMethodBeat.o(179628);
                    return;
                case 3:
                    h.a((Context) ExdeviceProfileUI.this.getContext(), ExdeviceProfileUI.this.getString(R.string.c2l), (String) null, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass28.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(179627);
                            bg.aVF();
                            as Kn = com.tencent.mm.model.c.aSN().Kn(ExdeviceProfileUI.this.mRa);
                            c.pl(37);
                            ab.r(Kn);
                            ExdeviceProfileUI.this.rJs.alive();
                            if (ExdeviceProfileUI.this.rGN != null) {
                                ExdeviceProfileUI.this.rGN.show();
                            }
                            AppMethodBeat.o(179627);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(179628);
                    return;
                case 4:
                    ExdeviceProfileUI.this.rCz = true;
                    c.pl(10);
                    ad.cKT();
                    com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceProfileUI.this.mAppName, ExdeviceProfileUI.this.mRa, 3);
                    AppMethodBeat.o(179628);
                    return;
                case 5:
                    c.pl(41);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ExdeviceProfileUI.this.rCo);
                    com.tencent.mm.br.c.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            AppMethodBeat.o(179628);
        }
    };
    private b<com.tencent.mm.plugin.exdevice.g.a.h> rJk = new b<com.tencent.mm.plugin.exdevice.g.a.h>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.exdevice.b.b
        public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.plugin.exdevice.g.a.h hVar) {
            AppMethodBeat.i(24096);
            Log.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i2 + "  errCode:" + i3 + "  errMsg:" + str);
            if (i2 == 0 && i3 == 0) {
                Intent intent = new Intent();
                intent.putExtra("KeyNeedUpdateRank", true);
                ExdeviceProfileUI.this.setResult(-1, intent);
                ExdeviceProfileUI.this.finish();
            }
            AppMethodBeat.o(24096);
        }
    };
    private b<g> rJl = new b<g>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass3 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.exdevice.b.b
        public final /* synthetic */ void a(int i2, int i3, String str, g gVar) {
            AppMethodBeat.i(179602);
            Log.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i2 + "  errCode:" + i3 + "  errMsg:" + str);
            if (i2 == 0 && i3 == 0) {
                Intent intent = new Intent();
                intent.putExtra("KeyNeedUpdateRank", true);
                ExdeviceProfileUI.this.setResult(-1, intent);
                ExdeviceProfileUI.this.finish();
            }
            AppMethodBeat.o(179602);
        }
    };
    private Runnable rJn = new Runnable() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass15 */

        public final void run() {
            AppMethodBeat.i(179611);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(ExdeviceProfileUI.this.rIZ);
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            if (ExdeviceProfileUI.this.rIZ.getCount() > 0) {
                BackwardSupportUtil.SmoothScrollFactory.scrollTo(ExdeviceProfileUI.this.rIZ, ExdeviceProfileUI.this.rIZ.getCount() - 1);
            }
            AppMethodBeat.o(179611);
        }
    };
    private b<g> rJo = new b<g>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass16 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.exdevice.b.b
        public final /* synthetic */ void a(int i2, int i3, String str, g gVar) {
            AppMethodBeat.i(179613);
            if (i2 == 0 && i3 == 0) {
                ExdeviceProfileUI.b(ExdeviceProfileUI.this);
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass16.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(179612);
                        if (ExdeviceProfileUI.this.rGN != null) {
                            ExdeviceProfileUI.this.rGN.dismiss();
                        }
                        AppMethodBeat.o(179612);
                    }
                });
            }
            AppMethodBeat.o(179613);
        }
    };
    private List<String> rJp;
    private b<l> rJq = new b<l>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass18 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.exdevice.b.b
        public final /* synthetic */ void a(int i2, int i3, String str, l lVar) {
            AppMethodBeat.i(179616);
            l lVar2 = lVar;
            if (i2 == 0 && i3 == 0) {
                ExdeviceProfileUI.this.rJp = lVar2.rCT;
                ExdeviceProfileUI.this.rCR = lVar2.rCR;
                ExdeviceProfileUI.this.rCS = lVar2.rCS;
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass18.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(179615);
                        if (ExdeviceProfileUI.this.rGN != null) {
                            ExdeviceProfileUI.this.rGN.dismiss();
                        }
                        AppMethodBeat.o(179615);
                    }
                });
                ExdeviceProfileUI.z(ExdeviceProfileUI.this);
            }
            AppMethodBeat.o(179616);
        }
    };
    private l rJr;
    private IListener<pd> rJs = new IListener<pd>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass21 */

        {
            AppMethodBeat.i(179619);
            this.__eventId = pd.class.getName().hashCode();
            AppMethodBeat.o(179619);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pd pdVar) {
            AppMethodBeat.i(179620);
            pd pdVar2 = pdVar;
            Log.i("MicroMsg.Sport.ExdeviceProfileUI", "count: %d ret: %s title: %s content: %s", Integer.valueOf(pdVar2.dVh.count), Integer.valueOf(pdVar2.dVh.ret), pdVar2.dVh.dVi, pdVar2.dVh.dVj);
            if (ExdeviceProfileUI.this.rGN != null && ExdeviceProfileUI.this.rGN.isShowing()) {
                ExdeviceProfileUI.this.rGN.dismiss();
            }
            ExdeviceProfileUI.this.rJs.dead();
            Intent intent = new Intent();
            intent.putExtra("KeyNeedUpdateRank", true);
            ExdeviceProfileUI.this.setResult(-1, intent);
            ExdeviceProfileUI.this.finish();
            AppMethodBeat.o(179620);
            return false;
        }
    };
    private MMPullDownView.a rJt = new MMPullDownView.a() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass23 */

        @Override // com.tencent.mm.ui.base.MMPullDownView.a
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(231698);
            GestureDetector gestureDetector = ExdeviceProfileUI.this.jKk;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$30", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$30", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(231698);
            return a2;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceProfileUI() {
        AppMethodBeat.i(24132);
        AppMethodBeat.o(24132);
    }

    static /* synthetic */ void b(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(24147);
        exdeviceProfileUI.cLO();
        AppMethodBeat.o(24147);
    }

    static /* synthetic */ void i(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(231706);
        exdeviceProfileUI.cLQ();
        AppMethodBeat.o(231706);
    }

    static /* synthetic */ void x(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(24155);
        exdeviceProfileUI.cLR();
        AppMethodBeat.o(24155);
    }

    static /* synthetic */ void y(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(231709);
        exdeviceProfileUI.cLS();
        AppMethodBeat.o(231709);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int dimensionPixelSize;
        SpannableString c2;
        CharSequence c3;
        AppMethodBeat.i(24133);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.rIS = intent.getStringExtra("rank_id");
        this.mRa = intent.getStringExtra(ch.COL_USERNAME);
        this.rIT = intent.getStringExtra("usernickname");
        String aTY = z.aTY();
        if (aTY != null) {
            this.rJg = aTY.equals(this.mRa);
        }
        this.mAppName = getIntent().getStringExtra("app_username");
        this.rJf = ad.cKN().anD(this.mRa);
        Log.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", Boolean.valueOf(this.rJf));
        Assert.assertTrue(!Util.isNullOrNil(this.mRa));
        this.rIU = ad.cKP().anF(this.mRa);
        this.rIV = getIntent().getStringArrayListExtra("key_affected_semi");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((SportProfileUIC) com.tencent.mm.ui.component.a.b(this).get(SportProfileUIC.class)).rCB = this.rIS;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((SportProfileUIC) com.tencent.mm.ui.component.a.b(this).get(SportProfileUIC.class)).appName = this.mAppName;
        getString(R.string.zb);
        this.rGN = h.b((Context) this, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(179604);
                if (ExdeviceProfileUI.this.rGN != null) {
                    ExdeviceProfileUI.this.rGN.dismiss();
                    ExdeviceProfileUI.this.rGN = null;
                }
                ExdeviceProfileUI.this.finish();
                AppMethodBeat.o(179604);
            }
        });
        this.rIX = (ExdeviceProfileAffectedUserView) findViewById(R.id.c5j);
        this.rIY = (ImageView) findViewById(R.id.c5m);
        this.rIZ = (ListView) findViewById(R.id.c67);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.id.gm4);
        this.rIX.setAffectedUserInfo(this.rIV);
        cLS();
        this.rJc = findViewById(R.id.hl3);
        this.jKk = new GestureDetector(getContext(), new a(this, (byte) 0));
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(this.rJt);
        mMPullDownView.setAtBottomCallBack(new MMPullDownView.c() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.c
            public final boolean cAl() {
                AppMethodBeat.i(179605);
                View childAt = ExdeviceProfileUI.this.rIZ.getChildAt(ExdeviceProfileUI.this.rIZ.getChildCount() - 1);
                int count = ExdeviceProfileUI.this.rIZ.getAdapter().getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceProfileUI.this.rIZ.getHeight() || ExdeviceProfileUI.this.rIZ.getLastVisiblePosition() < count - 1) {
                    AppMethodBeat.o(179605);
                    return false;
                }
                AppMethodBeat.o(179605);
                return true;
            }
        });
        mMPullDownView.setAtTopCallBack(new MMPullDownView.d() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.d
            public final boolean cAk() {
                View childAt;
                AppMethodBeat.i(179606);
                if (ExdeviceProfileUI.this.rIZ.getFirstVisiblePosition() != 0 || (childAt = ExdeviceProfileUI.this.rIZ.getChildAt(ExdeviceProfileUI.this.rIZ.getFirstVisiblePosition())) == null || childAt.getTop() < 0) {
                    AppMethodBeat.o(179606);
                    return false;
                }
                AppMethodBeat.o(179606);
                return true;
            }
        });
        mMPullDownView.setOnBottomLoadDataListener(new MMPullDownView.e() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.e
            public final boolean cAj() {
                return true;
            }
        });
        mMPullDownView.setOnScrollChangedListener(new MMPullDownView.b() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.b
            public final void cLT() {
                AppMethodBeat.i(179607);
                ExdeviceProfileUI.v(ExdeviceProfileUI.this);
                AppMethodBeat.o(179607);
            }
        });
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int D = com.tencent.mm.plugin.exdevice.k.b.D(this, getResources().getDimensionPixelSize(R.dimen.d6));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b8);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b9);
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.df);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.de);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int height = ((((defaultDisplay.getHeight() / 2) - D) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || height <= 0) {
            height = getResources().getDimensionPixelSize(R.dimen.d0);
        }
        exdeviceProfileListHeader.setMinimumHeight(height);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - D) - dimensionPixelSize));
        this.rJa = exdeviceProfileListHeader;
        this.rIZ.addHeaderView(this.rJa, null, false);
        this.rJb = new a(getContext(), this.mRa);
        this.rIZ.setAdapter((ListAdapter) this.rJb);
        this.rIZ.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass10 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(179608);
                ExdeviceProfileUI.v(ExdeviceProfileUI.this);
                AppMethodBeat.o(179608);
            }
        });
        this.rIX.setUsername(this.mRa);
        this.rJc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(24104);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceProfileUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24104);
            }
        });
        mMPullDownView.setCanOverScrool(false);
        this.rIY.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.jn(this), ((Integer) this.rJa.getTag()).intValue()));
        cLR();
        ad.cKU().a(this);
        bg.azz().a(new i(this, this.mRa, Util.nullAsNil(this.mAppName), this.rJi), 0);
        try {
            this.huY = getResources().getDimensionPixelSize(R.dimen.f11do);
            if (this.huY <= 0) {
                this.huY = 60;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", e2, "", new Object[0]);
            if (this.huY <= 0) {
                this.huY = 60;
            }
        } catch (Throwable th) {
            if (this.huY <= 0) {
                this.huY = 60;
            }
            AppMethodBeat.o(24133);
            throw th;
        }
        Log.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", Integer.valueOf(this.huY));
        if (this.rJg) {
            c3 = getString(R.string.c1e);
        } else {
            Object[] objArr = new Object[1];
            String str = this.mRa;
            int i2 = this.huY;
            String displayName = aa.getDisplayName(str);
            if (!str.equalsIgnoreCase(displayName) || Util.isNullOrNil(this.rIT)) {
                c2 = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), displayName);
            } else {
                c2 = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), this.rIT);
            }
            CharSequence ellipsize = TextUtils.ellipsize(c2, this.ayn, (float) i2, TextUtils.TruncateAt.END);
            Log.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", Integer.valueOf(i2), c2, ellipsize);
            objArr[0] = ellipsize;
            c3 = com.tencent.mm.pluginsdk.ui.span.l.c(this, getString(R.string.c1i, objArr));
        }
        setMMTitle(c3);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass27 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(179626);
                ExdeviceProfileUI.this.finish();
                AppMethodBeat.o(179626);
                return false;
            }
        });
        Log.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.mRa);
        if (z.aTY().equals(this.mRa)) {
            wp wpVar = new wp();
            wpVar.ecH.action = 3;
            EventCenter.instance.asyncPublish(wpVar, new Executor() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass12 */

                public final void execute(Runnable runnable) {
                    AppMethodBeat.i(179609);
                    com.tencent.f.h.RTc.aX(runnable);
                    AppMethodBeat.o(179609);
                }
            });
        }
        AppMethodBeat.o(24133);
    }

    private void cLO() {
        AppMethodBeat.i(24135);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass26 */

            public final void run() {
                AppMethodBeat.i(179617);
                ExdeviceProfileUI.this.rJb.notifyDataSetChanged();
                AppMethodBeat.o(179617);
            }
        });
        AppMethodBeat.o(24135);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(24136);
        super.onPause();
        AppMethodBeat.o(24136);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(24137);
        super.onResume();
        Log.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        cLO();
        if (!this.rJg) {
            ad.cKN().anD(this.mRa);
            cLQ();
        }
        AppMethodBeat.o(24137);
    }

    public final void cLP() {
        AppMethodBeat.i(231703);
        c.pl(17);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mRa);
        bg.azz().a(new g(arrayList, this.rJl), 0);
        AppMethodBeat.o(231703);
    }

    private void cLQ() {
        AppMethodBeat.i(24138);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(179603);
                ExdeviceProfileUI.f(ExdeviceProfileUI.this);
                ExdeviceProfileUI.this.rJb.notifyDataSetChanged();
                AppMethodBeat.o(179603);
            }
        });
        AppMethodBeat.o(24138);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24139);
        if (this.rJr != null) {
            bg.azz().a(this.rJr);
        }
        this.rJs.dead();
        this.mIsDestroyed = true;
        super.onDestroy();
        ad.cKU().b(this);
        AppMethodBeat.o(24139);
    }

    private void cLR() {
        AppMethodBeat.i(24140);
        String aTY = z.aTY();
        if (this.rJc != null) {
            this.rJc.setVisibility(8);
        }
        if (!Util.isNullOrNil(aTY) && aTY.equals(this.mRa)) {
            if (!(this.rIU == null || !Util.isNullOrNil(this.rIU.field_championUrl) || this.rJc == null)) {
                this.rJc.setVisibility(0);
            }
            if (this.rJa != null) {
                this.rJa.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass13 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(24107);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        c.pl(18);
                        com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceProfileUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24107);
                    }
                });
                AppMethodBeat.o(24140);
                return;
            }
        } else if (!(this.rIU == null || Util.isNullOrNil(this.rIU.field_championUrl) || this.rJa == null)) {
            this.rJa.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass14 */

                public final void onClick(View view) {
                    AppMethodBeat.i(179610);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ExdeviceProfileUI.w(ExdeviceProfileUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(179610);
                }
            });
        }
        AppMethodBeat.o(24140);
    }

    private void cLS() {
        AppMethodBeat.i(24141);
        if (this.rIU == null) {
            this.rIY.setImageResource(R.color.kw);
            this.mwj = null;
        } else if (this.mwj != this.rIU.field_championUrl && (this.mwj == null || !this.mwj.equals(this.rIU.field_championUrl))) {
            com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.rIY, this.rIU.field_championUrl);
            this.mwj = this.rIU.field_championUrl;
            AppMethodBeat.o(24141);
            return;
        }
        AppMethodBeat.o(24141);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        AppMethodBeat.i(24142);
        super.onActivityResult(i2, i3, intent);
        if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, i2, i3, intent, this.mAppName)) {
            AppMethodBeat.o(24142);
            return;
        }
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    if (intent == null) {
                        stringExtra = null;
                    } else {
                        stringExtra = intent.getStringExtra("Select_Conv_User");
                    }
                    String fb = ac.fb(this);
                    if (stringExtra == null || stringExtra.length() == 0) {
                        Log.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                        AppMethodBeat.o(24142);
                        return;
                    }
                    ac.a(this, stringExtra, fb, intent.getStringExtra("custom_send_text"), this.rJe);
                    h.cD(getContext(), getResources().getString(R.string.z0));
                    AppMethodBeat.o(24142);
                    return;
                }
                break;
            case 2:
                if (i3 == -1) {
                    Toast.makeText(this, (int) R.string.h0k, 1).show();
                    AppMethodBeat.o(24142);
                    return;
                }
                break;
            case 3:
                if (i3 == -1) {
                    ArrayList<String> stringsToList = Util.stringsToList(intent.getStringExtra("Select_Contact").split(","));
                    if (stringsToList != null) {
                        if (this.rGN != null) {
                            this.rGN.show();
                        }
                        bg.azz().a(new g(stringsToList, this.rJo), 0);
                        break;
                    } else {
                        AppMethodBeat.o(24142);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(24142);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a4y;
    }

    @Override // com.tencent.mm.plugin.exdevice.g.b.e
    public final void b(String str, d dVar) {
        AppMethodBeat.i(24143);
        if ("HardDeviceChampionInfo".equals(str) && this.mRa.equals(dVar.username)) {
            Log.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.rIU = ad.cKP().anF(this.mRa);
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(179614);
                    ExdeviceProfileUI.x(ExdeviceProfileUI.this);
                    ExdeviceProfileUI.this.rJb.notifyDataSetChanged();
                    ExdeviceProfileUI.y(ExdeviceProfileUI.this);
                    AppMethodBeat.o(179614);
                }
            });
        }
        AppMethodBeat.o(24143);
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(231702);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(231702);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(231701);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(231701);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(231700);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(231700);
        }

        private a() {
        }

        /* synthetic */ a(ExdeviceProfileUI exdeviceProfileUI, byte b2) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(24131);
            if (Math.abs(f3) < Math.abs(f2)) {
                AppMethodBeat.o(24131);
                return true;
            }
            AppMethodBeat.o(24131);
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(231699);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(231699);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(231704);
        HashSet hashSet = new HashSet(super.importUIComponents());
        hashSet.add(SportProfileUIC.class);
        AppMethodBeat.o(231704);
        return hashSet;
    }

    static /* synthetic */ void f(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(231705);
        exdeviceProfileUI.removeAllOptionMenu();
        if (z.aTY().equals(exdeviceProfileUI.mRa)) {
            exdeviceProfileUI.addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass22 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(24120);
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) ExdeviceProfileUI.this.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass22.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(24119);
                            mVar.b(0, ExdeviceProfileUI.this.getString(R.string.c10), R.raw.bottomsheet_icon_transmit);
                            mVar.b(1, ExdeviceProfileUI.this.getString(R.string.c13), R.raw.bottomsheet_icon_moment);
                            AppMethodBeat.o(24119);
                        }
                    };
                    eVar.HLY = ExdeviceProfileUI.this.rJj;
                    eVar.dGm();
                    AppMethodBeat.o(24120);
                    return true;
                }
            });
            AppMethodBeat.o(231705);
            return;
        }
        bg.aVF();
        boolean bjG = com.tencent.mm.model.c.aSN().bjG(exdeviceProfileUI.mRa);
        bg.aVF();
        boolean arz = com.tencent.mm.model.c.aSN().Kn(exdeviceProfileUI.mRa).arz();
        if (!exdeviceProfileUI.rJf || !bjG) {
            if (!arz) {
                exdeviceProfileUI.addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass25 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(179624);
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) ExdeviceProfileUI.this.getContext(), 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass25.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(179623);
                                if (!Util.isNullOrNil(ExdeviceProfileUI.this.rCo)) {
                                    mVar.d(5, ExdeviceProfileUI.this.getString(R.string.c19));
                                }
                                mVar.d(3, ExdeviceProfileUI.this.getString(R.string.c15));
                                AppMethodBeat.o(179623);
                            }
                        };
                        eVar.HLY = ExdeviceProfileUI.this.rJj;
                        eVar.dGm();
                        AppMethodBeat.o(179624);
                        return true;
                    }
                });
            }
            AppMethodBeat.o(231705);
            return;
        }
        exdeviceProfileUI.addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass24 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24124);
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) ExdeviceProfileUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass24.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(24123);
                        mVar.d(2, ExdeviceProfileUI.this.getString(R.string.c1_));
                        AppMethodBeat.o(24123);
                    }
                };
                eVar.HLY = ExdeviceProfileUI.this.rJj;
                eVar.dGm();
                AppMethodBeat.o(24124);
                return true;
            }
        });
        AppMethodBeat.o(231705);
    }

    static /* synthetic */ void m(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(24149);
        ac acVar = new ac();
        String valueOf = String.valueOf(exdeviceProfileUI.rJh);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (exdeviceProfileUI.rIW != null) {
            str = String.valueOf(exdeviceProfileUI.rIW.score);
        }
        acVar.a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.mwj, new ac.a() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass19 */

            @Override // com.tencent.mm.plugin.exdevice.model.ac.a
            public final void anx(String str) {
                AppMethodBeat.i(24116);
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", ExdeviceProfileUI.this.getString(R.string.c2n));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String JX = com.tencent.mm.model.ad.JX("wx_sport");
                com.tencent.mm.model.ad.aVe().G(JX, true).l("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", JX);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.br.c.b(ExdeviceProfileUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
                AppMethodBeat.o(24116);
            }
        });
        AppMethodBeat.o(24149);
    }

    static /* synthetic */ void n(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(231707);
        String valueOf = String.valueOf(exdeviceProfileUI.rJh);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (exdeviceProfileUI.rIW != null) {
            str = String.valueOf(exdeviceProfileUI.rIW.score);
        }
        new ac().a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.mwj, new ac.a() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass20 */

            {
                AppMethodBeat.i(161357);
                AppMethodBeat.o(161357);
            }

            @Override // com.tencent.mm.plugin.exdevice.model.ac.a
            public final void anx(String str) {
                AppMethodBeat.i(179618);
                ExdeviceProfileUI.d(ExdeviceProfileUI.this, str);
                AppMethodBeat.o(179618);
            }
        });
        AppMethodBeat.o(231707);
    }

    static /* synthetic */ void o(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(231708);
        Log.i("MicroMsg.Sport.ExdeviceProfileUI", "ap: start to del: %s", exdeviceProfileUI.mRa);
        bg.azz().a(new com.tencent.mm.plugin.exdevice.g.a.h(exdeviceProfileUI.mRa, exdeviceProfileUI.rJk), 0);
        AppMethodBeat.o(231708);
    }

    static /* synthetic */ void v(ExdeviceProfileUI exdeviceProfileUI) {
        float f2;
        AppMethodBeat.i(24153);
        if (Build.VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.rIZ.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.rIZ.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (rJm == 0) {
                    rJm = iArr[1];
                }
                int i2 = iArr[1];
                if (i2 > (-rJm) / 2) {
                    if (i2 > 0) {
                        f2 = ((float) (i2 * 2)) / (((float) rJm) * 2.0f);
                    } else {
                        f2 = ((float) i2) / ((float) rJm);
                    }
                    exdeviceProfileUI.rIX.setAlpha(f2);
                    exdeviceProfileUI.rIX.setVisibility(0);
                    AppMethodBeat.o(24153);
                    return;
                }
                exdeviceProfileUI.rIX.setAlpha(0.0f);
                exdeviceProfileUI.rIX.setVisibility(8);
            }
        }
        AppMethodBeat.o(24153);
    }

    static /* synthetic */ void w(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(24154);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) exdeviceProfileUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.AnonymousClass29 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(179629);
                if (ExdeviceProfileUI.this.rCz) {
                    mVar.d(1, ExdeviceProfileUI.this.getString(R.string.c18));
                    AppMethodBeat.o(179629);
                    return;
                }
                mVar.d(4, ExdeviceProfileUI.this.getString(R.string.c1d));
                AppMethodBeat.o(179629);
            }
        };
        eVar.HLY = exdeviceProfileUI.rJj;
        eVar.dGm();
        AppMethodBeat.o(24154);
    }

    static /* synthetic */ void z(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(231710);
        Intent intent = new Intent();
        String listToString = Util.listToString(exdeviceProfileUI.rJp, ",");
        intent.putExtra("wechat_sport_contact", Util.listToString(exdeviceProfileUI.rCR, ","));
        intent.putExtra("wechat_sport_recent_like", listToString);
        String listToString2 = Util.listToString(exdeviceProfileUI.rCS, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(R.string.byc));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(R.string.byf, new Object[]{10}));
        intent.putExtra("list_attr", u.Q(2, 4, 1, 131072, 128, 64, 16384));
        intent.putExtra("always_select_contact", listToString2);
        com.tencent.mm.br.c.c(exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
        AppMethodBeat.o(231710);
    }

    static /* synthetic */ void d(ExdeviceProfileUI exdeviceProfileUI, String str) {
        AppMethodBeat.i(231711);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.br.c.c(exdeviceProfileUI, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.o(231711);
    }
}
