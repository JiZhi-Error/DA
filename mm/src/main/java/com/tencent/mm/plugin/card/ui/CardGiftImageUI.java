package com.tencent.mm.plugin.card.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.card.d.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.l;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI extends MMActivity implements a.AbstractC0901a {
    private String dRr;
    private boolean isAnimated = false;
    private MMGestureGallery jUy;
    private l mHj;
    private RelativeLayout qaA;
    private ProgressBar qaB;
    private MMHandler qaC = new MMHandler(Looper.getMainLooper());
    private Bundle qaD;
    private e qaE;
    private int qaF = 0;
    private int qaG = 0;
    private int qaH = 0;
    private int qaI = 0;
    private a qaJ;
    private CardGiftInfo qay;
    private ImageView qaz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardGiftImageUI() {
        AppMethodBeat.i(113328);
        AppMethodBeat.o(113328);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String cardGiftInfo;
        AppMethodBeat.i(113329);
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        hideTitleView();
        this.qaD = bundle;
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        this.qay = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        Object[] objArr = new Object[1];
        if (this.qay == null) {
            cardGiftInfo = BuildConfig.COMMAND;
        } else {
            cardGiftInfo = this.qay.toString();
        }
        objArr[0] = cardGiftInfo;
        Log.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", objArr);
        Log.i("MicroMsg.CardGiftImageUI", "imgPath:%s", this.dRr);
        initView();
        com.tencent.mm.plugin.card.d.a.a(this);
        if (this.qay == null || Util.isNullOrNil(this.qay.pSp)) {
            Log.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
            AppMethodBeat.o(113329);
            return;
        }
        com.tencent.mm.plugin.card.d.a.g(this.qay.pSp, this.qay.pSs, this.qay.pSA, 2);
        AppMethodBeat.o(113329);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113330);
        this.qaz = (ImageView) findViewById(R.id.dcj);
        this.qaB = (ProgressBar) findViewById(R.id.dw9);
        this.qaA = (RelativeLayout) findViewById(R.id.dwl);
        this.jUy = (MMGestureGallery) findViewById(R.id.dci);
        this.jUy.setVerticalFadingEdgeEnabled(false);
        this.jUy.setHorizontalFadingEdgeEnabled(false);
        this.qaJ = new a(this, (byte) 0);
        this.jUy.setAdapter((SpinnerAdapter) this.qaJ);
        this.jUy.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                AppMethodBeat.i(113318);
                CardGiftImageUI.this.cvQ();
                AppMethodBeat.o(113318);
            }
        });
        this.jUy.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(113319);
                h.a(CardGiftImageUI.this, CardGiftImageUI.this.mHj.gXI());
                AppMethodBeat.o(113319);
                return true;
            }
        });
        this.qaE = new e(this);
        AppMethodBeat.o(113330);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(113331);
        Bundle bundle = this.qaD;
        if (!this.isAnimated) {
            this.isAnimated = true;
            if (Build.VERSION.SDK_INT < 12) {
                Log.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", Integer.valueOf(Build.VERSION.SDK_INT));
            } else {
                this.qaF = getIntent().getIntExtra("img_top", 0);
                this.qaG = getIntent().getIntExtra("img_left", 0);
                this.qaH = getIntent().getIntExtra("img_width", 0);
                this.qaI = getIntent().getIntExtra("img_height", 0);
                this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
                if (bundle == null) {
                    this.qaA.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass5 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(113322);
                            CardGiftImageUI.this.qaA.getViewTreeObserver().removeOnPreDrawListener(this);
                            CardGiftImageUI.this.qaE.a(CardGiftImageUI.this.qaA, CardGiftImageUI.this.qaz, null);
                            AppMethodBeat.o(113322);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(113331);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(113332);
        super.onResume();
        if (this.qaJ != null) {
            this.qaJ.notifyDataSetChanged();
        }
        AppMethodBeat.o(113332);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(113333);
        super.onPause();
        AppMethodBeat.o(113333);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113334);
        super.onDestroy();
        com.tencent.mm.plugin.card.d.a.b(this);
        AppMethodBeat.o(113334);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(113335);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
            cvQ();
            AppMethodBeat.o(113335);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(113335);
        return dispatchKeyEvent;
    }

    public final void cvQ() {
        AppMethodBeat.i(113336);
        this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
        this.qaE.a(this.qaA, this.qaz, new e.c() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationStart() {
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationEnd() {
                AppMethodBeat.i(113324);
                new MMHandler().post(new Runnable() {
                    /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(113323);
                        CardGiftImageUI.this.finish();
                        CardGiftImageUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(113323);
                    }
                });
                AppMethodBeat.o(113324);
            }
        }, null);
        AppMethodBeat.o(113336);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.my;
    }

    @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
    public final void cP(String str, int i2) {
        AppMethodBeat.i(113337);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(113325);
                if (CardGiftImageUI.this.qaB.getVisibility() != 0) {
                    CardGiftImageUI.this.qaB.setVisibility(0);
                }
                AppMethodBeat.o(113325);
            }
        });
        AppMethodBeat.o(113337);
    }

    @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
    public final void ajH(String str) {
    }

    @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
    public final void fw(String str, final String str2) {
        AppMethodBeat.i(113338);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(113326);
                if (CardGiftImageUI.this.qaB.getVisibility() != 8) {
                    CardGiftImageUI.this.qaB.setVisibility(8);
                }
                CardGiftImageUI.this.dRr = str2;
                CardGiftImageUI.g(CardGiftImageUI.this);
                CardGiftImageUI.this.qaJ.notifyDataSetChanged();
                AppMethodBeat.o(113326);
            }
        });
        AppMethodBeat.o(113338);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(CardGiftImageUI cardGiftImageUI, byte b2) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
            if (r0 != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
            /*
            // Method dump skipped, instructions count: 130
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.CardGiftImageUI.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    static /* synthetic */ void g(CardGiftImageUI cardGiftImageUI) {
        AppMethodBeat.i(113339);
        cardGiftImageUI.mHj = new l(cardGiftImageUI);
        cardGiftImageUI.mHj.HLX = new o.f() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(113320);
                mVar.d(0, CardGiftImageUI.this.getString(R.string.gau));
                AppMethodBeat.o(113320);
            }
        };
        cardGiftImageUI.mHj.HLY = new o.g() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftImageUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(113321);
                switch (menuItem.getItemId()) {
                    case 0:
                        s.l(CardGiftImageUI.this.dRr, CardGiftImageUI.this);
                        break;
                }
                AppMethodBeat.o(113321);
            }
        };
        AppMethodBeat.o(113339);
    }
}
