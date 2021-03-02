package com.tencent.mm.plugin.luckymoney.story;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.a.c;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;

public class EnvelopeAppBarLayout extends AppBarLayout implements LifecycleObserver {
    private ViewGroup UXC;
    private boolean UXD = false;
    private boolean UXE = false;
    private boolean UXF = false;
    private boolean UXG = false;
    private boolean UXH = false;
    private int apZ = 0;
    private boolean isPreview = false;
    private int xiP;
    private View yYW;
    private ImageView yYX;
    private RecyclerHorizontalViewPager yYY;
    private RecyclerView yYZ;
    private int yZA = (this.yZz - this.yZy);
    private EnvelopeStoryBehavior yZB;
    private ArrayList<b> yZC = new ArrayList<>();
    private EnvelopeStoryVideoManager yZD;
    private dlt yZE;
    private String yZF;
    private String yZG;
    private String yZH;
    public int yZI;
    private boolean yZJ = true;
    public boolean yZK = false;
    private boolean yZL = false;
    private ValueAnimator yZM;
    private ObjectAnimator yZN;
    private ValueAnimator yZO;
    private AnimatorSet yZP;
    private AppBarLayout.b yZQ;
    private final float yZR = 1.335f;
    private final float yZS = 1.0f;
    private final float yZT = 0.6f;
    private boolean yZU = false;
    private boolean yZV = false;
    private int yZW;
    private boolean yZX = false;
    private boolean yZY = false;
    private boolean yZZ = false;
    private TouchCoordinatorLayout yZa;
    private ViewGroup yZb;
    private ViewGroup yZc;
    private MediaBannerIndicator yZd;
    private TextView yZe;
    private RoundCornerImageView yZf;
    private TextView yZg;
    private TextView yZh;
    private TextView yZi;
    private TextView yZj;
    private TextView yZk;
    private ViewGroup yZl;
    private View yZm;
    private ImageView yZn;
    private ImageView yZo;
    private ImageView yZp;
    private ViewGroup yZq;
    private ViewGroup yZr;
    private ProgressBar yZs;
    public LuckyMoneyDetailUI yZt;
    private int yZu;
    private int yZv;
    private int yZw;
    private int yZx = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    private int yZy = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 120);
    private int yZz = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) v2helper.EMethodSetPlayerPreCorrectCofOn);
    private boolean zaa = false;
    private boolean zab = false;
    private View.OnClickListener zac = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(163578);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!EnvelopeAppBarLayout.this.yZL && EnvelopeAppBarLayout.this.yZI == 2) {
                EnvelopeAppBarLayout.this.b(true, true, true);
                EnvelopeAppBarLayout.this.yZU = true;
                d.xV(5);
                c.bC(6, EnvelopeAppBarLayout.this.yZG);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163578);
        }
    };
    private int zad = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.aat);

    static /* synthetic */ void j(EnvelopeAppBarLayout envelopeAppBarLayout) {
        AppMethodBeat.i(258605);
        envelopeAppBarLayout.efG();
        AppMethodBeat.o(258605);
    }

    static /* synthetic */ boolean y(EnvelopeAppBarLayout envelopeAppBarLayout) {
        AppMethodBeat.i(258608);
        boolean efI = envelopeAppBarLayout.efI();
        AppMethodBeat.o(258608);
        return efI;
    }

    public EnvelopeAppBarLayout(Context context) {
        super(context);
        AppMethodBeat.i(163595);
        init();
        AppMethodBeat.o(163595);
    }

    public EnvelopeAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(163596);
        init();
        AppMethodBeat.o(163596);
    }

    private void init() {
        AppMethodBeat.i(163597);
        inflate(getContext(), R.layout.b3q, this);
        setExpanded(false);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(163584);
                EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
                EnvelopeAppBarLayout.this.yZB = (EnvelopeStoryBehavior) ((CoordinatorLayout.d) EnvelopeAppBarLayout.this.getLayoutParams()).qC;
                EnvelopeAppBarLayout.this.yZB.yZK = EnvelopeAppBarLayout.this.yZK;
                EnvelopeAppBarLayout.this.yZB.zaz = EnvelopeAppBarLayout.this.yZI == 1 || EnvelopeAppBarLayout.this.yZI == 2;
                EnvelopeAppBarLayout.this.yZB.zaA = EnvelopeAppBarLayout.this.yZQ;
                EnvelopeAppBarLayout.this.yZa = (TouchCoordinatorLayout) EnvelopeAppBarLayout.this.getParent();
                EnvelopeAppBarLayout.this.yZm = EnvelopeAppBarLayout.this.yZa.findViewById(R.id.ez4);
                EnvelopeAppBarLayout.this.yYZ = (RecyclerView) EnvelopeAppBarLayout.this.yZa.findViewById(R.id.ezi);
                EnvelopeAppBarLayout.this.yZa.b(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass12.AnonymousClass1 */
                    float aTD;
                    float aTE;
                    long zaf;
                    boolean zag = false;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(163583);
                        if (EnvelopeAppBarLayout.this.yZL) {
                            if (motionEvent.getActionMasked() == 0) {
                                Rect rect = new Rect();
                                EnvelopeAppBarLayout.this.yZm.getGlobalVisibleRect(rect);
                                if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                    this.aTD = motionEvent.getRawX();
                                    this.aTE = motionEvent.getRawY();
                                    this.zaf = Util.currentTicks();
                                    this.zag = true;
                                } else {
                                    this.zag = false;
                                }
                            } else if (motionEvent.getActionMasked() == 1 && this.zag && Util.ticksToNow(this.zaf) < 500) {
                                Rect rect2 = new Rect();
                                EnvelopeAppBarLayout.this.yZm.getGlobalVisibleRect(rect2);
                                int rawX = (int) motionEvent.getRawX();
                                int rawY = (int) motionEvent.getRawY();
                                if (Math.abs(((float) rawX) - this.aTD) <= 20.0f && Math.abs(((float) rawY) - this.aTE) <= 20.0f && rect2.contains(rawX, rawY)) {
                                    Log.i("MicroMsg.EnvelopeAppBarLayout", "click collapse view");
                                    EnvelopeAppBarLayout.this.yZV = true;
                                    EnvelopeAppBarLayout.this.postDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass12.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(163582);
                                            EnvelopeAppBarLayout.this.b(false, true, true);
                                            AppMethodBeat.o(163582);
                                        }
                                    }, 30);
                                }
                            }
                        }
                        AppMethodBeat.o(163583);
                        return false;
                    }
                });
                EnvelopeAppBarLayout.this.yZm.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass12.AnonymousClass2 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return false;
                    }
                });
                EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this);
                AppMethodBeat.o(163584);
            }
        });
        this.yZD = new EnvelopeStoryVideoManager();
        initView();
        this.yZQ = new AppBarLayout.b() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass13 */
            private int zaj = 0;

            @Override // android.support.design.widget.AppBarLayout.a, android.support.design.widget.AppBarLayout.b
            public final void c(AppBarLayout appBarLayout, int i2) {
                AppMethodBeat.i(163585);
                Log.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s", Integer.valueOf(i2));
                int abs = Math.abs(i2);
                float totalScrollRange = ((float) ((appBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.this.yZA) - abs)) / (((float) (appBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.this.yZA)) * 1.0f);
                float f2 = 1.0f - totalScrollRange;
                if (!EnvelopeAppBarLayout.this.yZJ) {
                    EnvelopeAppBarLayout.this.yZc.setAlpha(1.0f - f2);
                    if (abs <= EnvelopeAppBarLayout.this.yZw) {
                        EnvelopeAppBarLayout.this.yYX.setAlpha(0.0f);
                    } else {
                        EnvelopeAppBarLayout.this.yYX.setAlpha(((float) (abs - EnvelopeAppBarLayout.this.yZw)) / (((float) ((appBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.this.yZA) - EnvelopeAppBarLayout.this.yZw)) * 1.0f));
                    }
                    EnvelopeAppBarLayout.this.yZp.setAlpha(1.0f - f2);
                }
                if (EnvelopeAppBarLayout.this.yZb != null) {
                    if (EnvelopeAppBarLayout.this.yZI == 2) {
                        EnvelopeAppBarLayout.this.yZb.setAlpha(f2);
                    } else if (EnvelopeAppBarLayout.this.yZI == 1) {
                        int totalScrollRange2 = appBarLayout.getTotalScrollRange() - abs;
                        Log.d("MicroMsg.EnvelopeAppBarLayout", "distance: %s", Integer.valueOf(totalScrollRange2));
                        if (totalScrollRange2 <= EnvelopeAppBarLayout.this.yZA) {
                            EnvelopeAppBarLayout.this.yZb.setAlpha(((float) totalScrollRange2) / (((float) EnvelopeAppBarLayout.this.yZA) * 1.0f));
                        } else {
                            EnvelopeAppBarLayout.this.yZb.setAlpha(1.0f);
                        }
                    }
                }
                if (appBarLayout.getTotalScrollRange() - abs == 0 && this.zaj != abs) {
                    EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this);
                } else if (abs == 0 && this.zaj != abs) {
                    EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this);
                } else if (appBarLayout.getTotalScrollRange() - abs == com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 300) && this.zaj != abs) {
                    EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this);
                }
                if (EnvelopeAppBarLayout.this.yZm != null) {
                    EnvelopeAppBarLayout.this.yZm.setAlpha((float) (0.7d * ((double) totalScrollRange)));
                }
                this.zaj = abs;
                AppMethodBeat.o(163585);
            }
        };
        a(this.yZQ);
        AppMethodBeat.o(163597);
    }

    private void initView() {
        AppMethodBeat.i(163598);
        this.yYW = findViewById(R.id.i96);
        this.yZb = (ViewGroup) findViewById(R.id.ezo);
        this.yZc = (ViewGroup) findViewById(R.id.ezt);
        this.yYX = (ImageView) findViewById(R.id.iad);
        this.yZs = (ProgressBar) findViewById(R.id.iae);
        this.yYY = (RecyclerHorizontalViewPager) findViewById(R.id.ic9);
        this.yZd = (MediaBannerIndicator) findViewById(R.id.i97);
        this.yZe = (TextView) findViewById(R.id.i9i);
        this.yZf = (RoundCornerImageView) findViewById(R.id.ibp);
        this.yZg = (TextView) findViewById(R.id.icu);
        this.yZh = (TextView) findViewById(R.id.ict);
        this.yZq = (ViewGroup) findViewById(R.id.icg);
        this.UXC = (ViewGroup) findViewById(R.id.ich);
        this.yZi = (TextView) findViewById(R.id.ezr);
        this.yZj = (TextView) findViewById(R.id.ezp);
        this.yZl = (ViewGroup) findViewById(R.id.ezq);
        this.yZk = (TextView) findViewById(R.id.icf);
        this.yZn = (ImageView) findViewById(R.id.ezn);
        this.yZo = (ImageView) findViewById(R.id.iab);
        this.yZp = (ImageView) findViewById(R.id.iac);
        this.yZf.shadowRadius = 4;
        this.yZf.shadowColor = getResources().getColor(R.color.BW_100_Alpha_0_3);
        this.yZd.setSelectDrawable(getResources().getDrawable(R.drawable.afw));
        this.yZd.setUnSelectDrawable(getResources().getDrawable(R.drawable.afx));
        this.yZd.setIndicatorWidth(getResources().getDimensionPixelSize(R.dimen.ct));
        getContext();
        final HorizontalLayoutManager horizontalLayoutManager = new HorizontalLayoutManager();
        this.yYY.setHasFixedSize(true);
        this.yYY.setItemViewCacheSize(4);
        final com.tencent.mm.plugin.luckymoney.scaledLayout.a aVar = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
        aVar.context = getContext();
        aVar.yYe = true;
        this.yYY.setSnapHelper(aVar);
        this.yYY.setOnInterceptTouchEvent(new RecyclerHorizontalViewPager.c() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass17 */

            @Override // com.tencent.mm.view.RecyclerHorizontalViewPager.c
            public final boolean b(MotionEvent motionEvent, boolean z) {
                AppMethodBeat.i(163589);
                if (motionEvent.getAction() == 0) {
                    aVar.yYd = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(horizontalLayoutManager);
                }
                AppMethodBeat.o(163589);
                return z;
            }

            @Override // com.tencent.mm.view.RecyclerHorizontalViewPager.c
            public final void n(MotionEvent motionEvent) {
            }
        });
        horizontalLayoutManager.qOi = 1;
        horizontalLayoutManager.setItemPrefetchEnabled(true);
        horizontalLayoutManager.aqE = 3;
        horizontalLayoutManager.setOrientation(0);
        this.yYY.setLayoutManager(horizontalLayoutManager);
        this.yYY.setAdapter(new WxRecyclerAdapter(new f() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass18 */

            @Override // com.tencent.mm.view.recyclerview.f
            public final e<?> EC(int i2) {
                AppMethodBeat.i(163590);
                a aVar = new a();
                AppMethodBeat.o(163590);
                return aVar;
            }
        }, this.yZC, false));
        this.yYY.setPageChangeListener(new RecyclerHorizontalViewPager.b() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass19 */

            @Override // com.tencent.mm.view.RecyclerHorizontalViewPager.b
            public final void aC(int i2, boolean z) {
                String str;
                boolean z2 = true;
                AppMethodBeat.i(213344);
                Log.i("MicroMsg.EnvelopeAppBarLayout", "on page change: %s, %s", Integer.valueOf(i2), Boolean.valueOf(z));
                if (z) {
                    if (EnvelopeAppBarLayout.this.apZ == i2) {
                        AppMethodBeat.o(213344);
                        return;
                    }
                    EnvelopeAppBarLayout.this.efF();
                    EnvelopeAppBarLayout.this.apZ = i2;
                    h hVar = (h) EnvelopeAppBarLayout.this.yYY.ch(i2);
                    if (hVar != null) {
                        boolean y = EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this);
                        b bVar = (b) hVar.Rra;
                        if (y) {
                            bVar.efJ();
                        } else {
                            b.zbh++;
                        }
                        if (EnvelopeStoryVideoManager.dD(bVar.UXI, bVar.UXK)) {
                            str = bVar.UXK;
                        } else {
                            str = bVar.zaq.Gav;
                            z2 = false;
                        }
                        EnvelopeAppBarLayout.this.yZD.a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout) hVar.Mn(R.id.ezx), (ImageView) hVar.Mn(R.id.ezu), (ProgressBar) hVar.Mn(R.id.ezv), str, bVar.videoWidth, bVar.videoHeight, i2, y, z2);
                        d.xV(6);
                    }
                    b.zbe++;
                }
                EnvelopeAppBarLayout.this.yZd.setCurrentIndex(i2);
                AppMethodBeat.o(213344);
            }
        });
        AppMethodBeat.o(163598);
    }

    public final void efF() {
        int i2;
        AppMethodBeat.i(182455);
        if (this.apZ >= 0) {
            if (Util.isNullOrNil(b.sessionId)) {
                AppMethodBeat.o(182455);
                return;
            }
            h hVar = (h) this.yYY.ch(this.apZ);
            if (hVar != null) {
                boolean efI = efI();
                b bVar = (b) hVar.Rra;
                if (efI) {
                    EnvelopeStoryVideoManager.c cVar = this.yZD.zaE.get(Integer.valueOf(this.apZ));
                    if (cVar == null) {
                        AppMethodBeat.o(182455);
                        return;
                    }
                    cVar.zaT = (long) cVar.zaV.getCurrPosSec();
                    if (cVar.zaU.get() == 1) {
                        i2 = (int) (cVar.zaT - cVar.zaS);
                    } else if (cVar.zaU.get() > 1) {
                        i2 = (int) ((((long) cVar.zaP) - cVar.zaS) + cVar.zaT + ((long) ((cVar.zaU.get() - 1) * cVar.zaP)));
                    } else {
                        i2 = 0;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19270, 2, this.yZF, cVar.zaU, "", bVar.zaq.Gav, Integer.valueOf(i2), b.sessionId);
                    AppMethodBeat.o(182455);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19270, 1, this.yZF, 0, bVar.zaq.Gav, "", 0, b.sessionId);
            }
        }
        AppMethodBeat.o(182455);
    }

    private void efG() {
        AppMethodBeat.i(163599);
        this.yZb.setOnClickListener(this.zac);
        this.yYX.setOnClickListener(this.zac);
        AppMethodBeat.o(163599);
    }

    private void efH() {
        AppMethodBeat.i(163600);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        this.yZu = rect.right - rect.left;
        this.yZv = (int) (((float) this.yZu) * 1.335f);
        this.yYX.setMinimumHeight(this.yZv);
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(this.yZv);
        layoutParams.nu = 3;
        this.yYW.setLayoutParams(layoutParams);
        this.yYW.setMinimumHeight(this.yZy);
        postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(174331);
                EnvelopeAppBarLayout.this.yZB.G(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.this.yZA));
                EnvelopeAppBarLayout.this.yZb.setAlpha(1.0f);
                AppMethodBeat.o(174331);
            }
        }, 50);
        AppMethodBeat.o(163600);
    }

    private boolean efI() {
        AppMethodBeat.i(163601);
        h hVar = (h) this.yYY.ch(this.apZ);
        if (hVar == null) {
            AppMethodBeat.o(163601);
            return false;
        } else if (((b) hVar.Rra).zaq.Gat == 2) {
            AppMethodBeat.o(163601);
            return true;
        } else {
            AppMethodBeat.o(163601);
            return false;
        }
    }

    public void setActivityLifeCycle(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(213345);
        luckyMoneyDetailUI.getLifecycle().addObserver(this.yZD);
        luckyMoneyDetailUI.getLifecycle().addObserver(this);
        this.yZt = luckyMoneyDetailUI;
        EnvelopeStoryVideoManager envelopeStoryVideoManager = this.yZD;
        envelopeStoryVideoManager.pRg = luckyMoneyDetailUI;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(174344);
                EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this);
                AppMethodBeat.o(174344);
            }
        });
        AppMethodBeat.o(213345);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onUIPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onUIDestroy() {
        AppMethodBeat.i(163604);
        efF();
        this.yZD.efP();
        if (this.yZI == 1 || this.yZI == 2) {
            b.xV(3);
        }
        d.xV(11);
        AppMethodBeat.o(163604);
    }

    public final void a(dlt dlt, String str, String str2, int i2, boolean z) {
        int intValue;
        AppMethodBeat.i(213346);
        if (Util.isNullOrNil(this.yZG)) {
            xN(0);
            this.yZv = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 502);
            AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(this.yZv);
            layoutParams.nu = 3;
            this.yYW.setMinimumHeight(this.yZy);
            this.yYW.setLayoutParams(layoutParams);
        } else if (dlt == null) {
            xN(1);
            efH();
            this.yZi.setText(str2);
            a.zbc = str2;
        } else {
            this.yZE = dlt;
            this.yZF = str;
            this.isPreview = z;
            this.yZe.setText(this.yZE.description);
            this.yZg.setText(this.yZE.MPn);
            this.yZi.setText(this.yZE.title);
            a.zbc = this.yZE.MPn;
            if (dlt.MPq != null) {
                i2 = dlt.MPq.iwy;
            }
            if (i2 == 2) {
                this.yZj.setVisibility(0);
                this.yZh.setVisibility(0);
            } else {
                this.yZj.setVisibility(8);
                this.yZh.setVisibility(8);
            }
            if (this.yZE.pTI == 1) {
                if (!this.yZY) {
                    c.bC(8, this.yZG);
                    this.yZY = true;
                }
                this.yZq.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213336);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.d("MicroMsg.EnvelopeAppBarLayout", "go to h5");
                        if (EnvelopeAppBarLayout.this.yZL) {
                            com.tencent.mm.wallet_core.ui.f.bn(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.this.yZE.yUK);
                            d.xV(7);
                            c.bC(9, EnvelopeAppBarLayout.this.yZG);
                            b.zbm++;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213336);
                    }
                });
                this.yZk.setText(R.string.w9);
            } else if (this.yZE.pTI == 2) {
                if (!Util.isNullOrNil(this.yZE.yUL)) {
                    if (!this.yZZ) {
                        c.bC(11, this.yZG);
                        this.yZZ = true;
                    }
                    com.tencent.mm.wallet_core.ui.f.aZ(this.yZq, 100);
                    b.zbl = 1;
                    this.yZq.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213337);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
                            if (EnvelopeAppBarLayout.this.yZL) {
                                com.tencent.mm.wallet_core.ui.f.cL(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.this.yZE.yUL);
                                d.xV(7);
                                c.bC(13, EnvelopeAppBarLayout.this.yZG);
                                b.zbm++;
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213337);
                        }
                    });
                    this.yZk.setText(R.string.eou);
                }
            } else if (this.yZE.pTI == 3) {
                if (!this.zaa) {
                    c.bC(12, this.yZG);
                    this.zaa = true;
                }
                this.yZq.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213338);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
                        if (EnvelopeAppBarLayout.this.yZL) {
                            com.tencent.mm.wallet_core.ui.f.u(EnvelopeAppBarLayout.this.yZE.yUL, EnvelopeAppBarLayout.this.yZE.yUK, 0, 1100);
                            d.xV(7);
                            c.bC(14, EnvelopeAppBarLayout.this.yZG);
                            b.zbm++;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213338);
                    }
                });
                this.yZk.setText(R.string.eoy);
            } else if (this.yZE.pTI == 4) {
                if (!this.UXF) {
                    c.bC(19, this.yZG);
                    this.UXF = true;
                }
                this.yZq.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213339);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
                        if (EnvelopeAppBarLayout.this.yZL) {
                            Intent intent = new Intent();
                            ((aj) g.ah(aj.class)).fillContextIdToIntent(10, 2, 32, intent);
                            intent.putExtra("finder_username", EnvelopeAppBarLayout.this.yZE.yUL);
                            ((aj) g.ah(aj.class)).enterFinderProfileUI(EnvelopeAppBarLayout.this.yZt, intent);
                            d.xV(7);
                            c.bC(19, EnvelopeAppBarLayout.this.yZG);
                            b.zbm++;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213339);
                    }
                });
                this.yZk.setText(R.string.eox);
            } else if (this.yZE.pTI == 5) {
                if (!this.UXE) {
                    c.bC(17, this.yZG);
                    this.UXE = true;
                }
                this.yZq.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213340);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, EnvelopeAppBarLayout.this.yZE.MPs);
                        intent.putExtra("name", EnvelopeAppBarLayout.this.yZE.yUL);
                        intent.putExtra("headurl", EnvelopeAppBarLayout.this.yZE.yUK);
                        intent.putExtra("extra_scence", 30);
                        com.tencent.mm.br.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
                        d.xV(7);
                        c.bC(18, EnvelopeAppBarLayout.this.yZG);
                        b.zbm++;
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213340);
                    }
                });
                this.yZk.setText(R.string.eow);
            } else if (this.yZE.pTI == 6) {
                if (!this.UXD) {
                    c.bC(15, this.yZG);
                    this.UXD = true;
                }
                this.yZq.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213341);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("extra_id", EnvelopeAppBarLayout.this.yZE.yUL);
                        intent.putExtra("preceding_scence", 21);
                        com.tencent.mm.br.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                        d.xV(7);
                        c.bC(16, EnvelopeAppBarLayout.this.yZG);
                        b.zbm++;
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213341);
                    }
                });
                this.yZk.setText(R.string.eov);
            } else {
                this.yZq.setVisibility(8);
                b.zbl = 0;
            }
            if (!Util.isNullOrNil(this.yZE.MPr)) {
                this.yZk.setText(this.yZE.MPr);
            }
            if (!Util.isNullOrNil(dlt.iwv)) {
                ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.yZf, dlt.iwv, dlt.iww, str);
                this.yZf.setVisibility(0);
            } else {
                this.yZf.setVisibility(8);
            }
            this.yZC.clear();
            if (!dlt.MPo.isEmpty()) {
                b.zbk = 1;
                a.zbd = 2;
                for (int i3 = 0; i3 < dlt.MPo.size(); i3++) {
                    edn edn = dlt.MPo.get(i3);
                    b bVar = new b();
                    bVar.zaq = edn;
                    bVar.UXJ = i3;
                    bVar.UXI = dlt.VjK;
                    String nk = t.nk(bVar.UXI, bVar.UXJ);
                    if (bVar.UXI > 0 && s.YS(nk)) {
                        Log.i("MicroMsg.EnvelopeAppBarLayout", "[static luckymoney resource] has local video,add path");
                        bVar.UXK = nk;
                    }
                    this.yZC.add(bVar);
                    if (edn.Gat == 2) {
                        this.xiP++;
                    } else {
                        this.yZW++;
                    }
                }
                this.yZd.setCount(this.yZC.size());
                xN(2);
                Rect rect = new Rect();
                getWindowVisibleDisplayFrame(rect);
                this.yZu = rect.right - rect.left;
                this.yZv = (int) (((float) this.yZu) * 1.667f);
                int i4 = (int) (((float) this.yZu) * 1.335f);
                this.yZw = this.yZv - i4;
                this.yYX.setMinimumHeight(i4);
                AppBarLayout.LayoutParams layoutParams2 = new AppBarLayout.LayoutParams(this.yZv);
                layoutParams2.nu = 3;
                this.yYW.setLayoutParams(layoutParams2);
                this.yZz = (int) (((float) this.yZu) * 1.0f);
                this.yYW.setMinimumHeight(this.yZy);
                postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(163580);
                        EnvelopeAppBarLayout.this.yZB.G(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.this.yZA));
                        EnvelopeAppBarLayout.this.yZb.setAlpha(1.0f);
                        AppMethodBeat.o(163580);
                    }
                }, 50);
                if (this.isPreview) {
                    intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_STORY_PREVIEW_GUIDE_TIME_INT_SYNC, (Object) 0)).intValue();
                } else {
                    intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_STORY_GUIDE_TIME_INT_SYNC, (Object) 0)).intValue();
                }
                Log.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", Integer.valueOf(intValue));
                if (intValue < 3 && this.yZI == 2) {
                    this.zab = true;
                    this.yZr = (ViewGroup) findViewById(R.id.ezs);
                    this.yZr.setVisibility(0);
                    this.yZb.setVisibility(4);
                    this.yZM = new ValueAnimator();
                    this.yZM.setDuration(700L);
                    this.yZM.setInterpolator(new AccelerateDecelerateInterpolator());
                    this.yZM.setIntValues(0, this.yZx);
                    this.yZN = new ObjectAnimator();
                    this.yZN.setPropertyName("alpha");
                    this.yZN.setFloatValues(1.0f, 0.0f);
                    this.yZN.setTarget(this.yZr);
                    this.yZN.setDuration(300L);
                    this.yZN.setStartDelay(200);
                    this.yZN.addListener(new Animator.AnimatorListener() {
                        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass14 */

                        public final void onAnimationStart(Animator animator) {
                            AppMethodBeat.i(163586);
                            EnvelopeAppBarLayout.this.UXG = false;
                            EnvelopeAppBarLayout.this.yZb.setVisibility(0);
                            EnvelopeAppBarLayout.this.yZb.setAlpha(0.0f);
                            AppMethodBeat.o(163586);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(258602);
                            EnvelopeAppBarLayout.this.UXG = true;
                            AppMethodBeat.o(258602);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    this.yZO = new ValueAnimator();
                    this.yZO.setInterpolator(android.support.design.a.a.gO);
                    this.yZO.setStartDelay(200);
                    this.yZO.setDuration(300L);
                    this.yZO.setIntValues(this.yZx, 0);
                    AnonymousClass15 r0 = new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass15 */
                        int zak = 0;

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(163587);
                            Log.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + valueAnimator.getAnimatedValue());
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            int i2 = intValue - this.zak;
                            this.zak = intValue;
                            float f2 = ((float) (EnvelopeAppBarLayout.this.yZx - intValue)) / (((float) EnvelopeAppBarLayout.this.yZx) * 1.0f);
                            if (EnvelopeAppBarLayout.this.yZI == 2) {
                                EnvelopeAppBarLayout.this.yYX.setAlpha(f2);
                            }
                            EnvelopeAppBarLayout.this.offsetTopAndBottom(i2);
                            if (i2 > 0) {
                                EnvelopeAppBarLayout.this.yZr.offsetTopAndBottom((int) (((float) i2) * 0.123f));
                                AppMethodBeat.o(163587);
                                return;
                            }
                            EnvelopeAppBarLayout.this.yZb.setAlpha(f2);
                            AppMethodBeat.o(163587);
                        }
                    };
                    this.yZM.addUpdateListener(r0);
                    this.yZO.addUpdateListener(r0);
                    this.yZP = new AnimatorSet();
                    this.yZP.playSequentially(this.yZM, this.yZN, this.yZO);
                    this.yZP.addListener(new Animator.AnimatorListener() {
                        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass16 */

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(163588);
                            EnvelopeAppBarLayout.this.yZr.setVisibility(8);
                            if (EnvelopeAppBarLayout.this.yZa != null) {
                                EnvelopeAppBarLayout.this.yZa.zbo = false;
                            }
                            AppMethodBeat.o(163588);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    post(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass10 */

                        public final void run() {
                            AppMethodBeat.i(213342);
                            if (EnvelopeAppBarLayout.this.yZa != null) {
                                EnvelopeAppBarLayout.this.yZa.zbo = true;
                            }
                            EnvelopeAppBarLayout.this.yZP.setStartDelay(700);
                            EnvelopeAppBarLayout.this.yZP.start();
                            AppMethodBeat.o(213342);
                        }
                    });
                    if (this.isPreview) {
                        g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_STORY_PREVIEW_GUIDE_TIME_INT_SYNC, Integer.valueOf(((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_STORY_PREVIEW_GUIDE_TIME_INT_SYNC, (Object) 0)).intValue() + 1));
                    } else {
                        g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_STORY_GUIDE_TIME_INT_SYNC, Integer.valueOf(((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_STORY_GUIDE_TIME_INT_SYNC, (Object) 0)).intValue() + 1));
                    }
                }
            } else {
                xN(1);
                efH();
            }
            this.yYY.getAdapter().atj.notifyChanged();
        }
        Log.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", Integer.valueOf(this.yZI));
        AppMethodBeat.o(213346);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(163606);
        super.onFinishInflate();
        AppMethodBeat.o(163606);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void xN(int i2) {
        AppMethodBeat.i(163607);
        this.yZI = i2;
        switch (this.yZI) {
            case 0:
                this.yZJ = true;
                this.yZK = true;
                this.yZb.setVisibility(8);
                this.yZp.setVisibility(8);
                if (ao.isDarkMode()) {
                    this.yZo.setImageResource(R.raw.icons_filled_detail_skin_hb_mask_dark);
                    AppMethodBeat.o(163607);
                    return;
                }
                this.yZo.setImageResource(R.raw.icons_filled_detail_skin_hb_mask);
                AppMethodBeat.o(163607);
                return;
            case 1:
                this.yZJ = true;
                this.yZK = true;
                this.yZb.setVisibility(0);
                this.yZn.setVisibility(8);
                this.yZb.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 12), com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), com.tencent.mm.cb.a.fromDPToPix(getContext(), 12), com.tencent.mm.cb.a.fromDPToPix(getContext(), 4));
                this.yYX.setVisibility(0);
                this.yZp.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 15);
                this.yZl.setLayoutParams(layoutParams);
                if (ao.isDarkMode()) {
                    this.yZo.setImageResource(R.raw.icons_filled_detail_skin_hb_mask_dark);
                    AppMethodBeat.o(163607);
                    return;
                }
                this.yZo.setImageResource(R.raw.icons_filled_detail_skin_hb_mask);
                AppMethodBeat.o(163607);
                return;
            case 2:
                this.yZJ = false;
                this.yZK = false;
                this.yZb.setVisibility(0);
                this.yZn.setVisibility(0);
                this.yZb.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 12), com.tencent.mm.cb.a.fromDPToPix(getContext(), 4), com.tencent.mm.cb.a.fromDPToPix(getContext(), 12), com.tencent.mm.cb.a.fromDPToPix(getContext(), 4));
                this.yZp.setVisibility(0);
                this.yZp.setAlpha(0.0f);
                if (ao.isDarkMode()) {
                    this.yZo.setImageResource(R.raw.icons_filled_detail_skin_hb_mask_dark);
                } else {
                    this.yZo.setImageResource(R.raw.icons_filled_detail_skin_hb_mask);
                }
                c.bC(4, this.yZG);
                break;
        }
        AppMethodBeat.o(163607);
    }

    public final void aA(String str, String str2, int i2) {
        AppMethodBeat.i(258603);
        if (Util.isNullOrNil(this.yZG) && !Util.isNullOrNil(str)) {
            this.yZG = str;
            this.yZH = str2;
            this.yZs.setVisibility(0);
            ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.yYX, this.yZG, this.yZH, this.yZF, this.yZv, this.yZu, 0, new a.AbstractC1465a() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass11 */

                @Override // com.tencent.mm.plugin.luckymoney.a.a.AbstractC1465a
                public final void ei(boolean z) {
                    AppMethodBeat.i(213343);
                    if (z) {
                        EnvelopeAppBarLayout.this.yZs.setVisibility(8);
                    }
                    AppMethodBeat.o(213343);
                }
            }, i2, 2, 0);
        }
        AppMethodBeat.o(258603);
    }

    class a extends e<b> {
        a() {
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.b3p;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, h hVar, int i2) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(final h hVar, b bVar, int i2, int i3, boolean z, List list) {
            AppMethodBeat.i(163593);
            Log.d("MicroMsg.EnvelopeAppBarLayout", "bind view holder: %s", Integer.valueOf(i2));
            b bVar2 = (b) hVar.Rra;
            final edn edn = bVar2.zaq;
            if (edn.Gat == 1) {
                ImageView imageView = (ImageView) hVar.Mn(R.id.ezu);
                imageView.setImageBitmap(null);
                hVar.Mn(R.id.ezv).setVisibility(0);
                hVar.Mn(R.id.ezv).setTag(R.id.f0n, edn.Gav);
                ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(imageView, edn.Gav, edn.NdO, EnvelopeAppBarLayout.this.yZF, EnvelopeAppBarLayout.this.yZv, EnvelopeAppBarLayout.this.yZu, 40, new a.AbstractC1465a() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.a.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.luckymoney.a.a.AbstractC1465a
                    public final void ei(boolean z) {
                        AppMethodBeat.i(163592);
                        if (!z) {
                            AppMethodBeat.o(163592);
                            return;
                        }
                        String str = (String) hVar.Mn(R.id.ezv).getTag(R.id.f0n);
                        if (!Util.isNullOrNil(str) && str.equals(edn.Gav)) {
                            hVar.Mn(R.id.ezv).setVisibility(8);
                        }
                        AppMethodBeat.o(163592);
                    }
                }, bVar2.UXI, 4, bVar2.UXJ);
                hVar.mf(R.id.ezx, 8);
                AppMethodBeat.o(163593);
                return;
            }
            hVar.Mn(R.id.ezv).setVisibility(8);
            bVar2.efJ();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar2.videoWidth, bVar2.videoHeight);
            layoutParams.gravity = 17;
            ((ViewGroup) hVar.Mn(R.id.f5f)).setLayoutParams(layoutParams);
            hVar.mf(R.id.f5g, 4);
            hVar.mf(R.id.ezy, 8);
            ImageView imageView2 = (ImageView) hVar.Mn(R.id.ezu);
            imageView2.setImageBitmap(null);
            ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(imageView2, edn.NdP, edn.NdQ, EnvelopeAppBarLayout.this.yZF, EnvelopeAppBarLayout.this.yZv, EnvelopeAppBarLayout.this.yZu, bVar2.UXI, bVar2.UXJ);
            hVar.mf(R.id.ezx, 0);
            String aDA = EnvelopeStoryVideoManager.aDA(edn.Gav);
            String aDz = EnvelopeStoryVideoManager.aDz(edn.Gav);
            boolean z2 = EnvelopeStoryVideoManager.VQ().getInt(aDz, 0) == 1;
            if (!s.YS(aDA) && !z2) {
                if (EnvelopeStoryVideoManager.dD(bVar2.UXI, bVar2.UXK)) {
                    Log.i("MicroMsg.EnvelopeAppBarLayout", "[static luckymoney resource] has local video");
                    AppMethodBeat.o(163593);
                    return;
                }
                Log.i("MicroMsg.EnvelopeAppBarLayout", "preload video");
                EnvelopeStoryVideoManager.a(aDz, aDA, edn.Gav, edn.NdO, true, null, new h.a() {
                    /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.a.AnonymousClass2 */

                    @Override // com.tencent.mm.i.h.a
                    public final void Ds(String str) {
                    }

                    @Override // com.tencent.mm.i.h.a
                    public final void a(String str, long j2, long j3, String str2) {
                    }

                    @Override // com.tencent.mm.i.h.a
                    public final void onDataAvailable(String str, long j2, long j3) {
                    }

                    @Override // com.tencent.mm.i.h.a
                    public final void i(String str, long j2, long j3) {
                    }

                    @Override // com.tencent.mm.i.h.a
                    public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
                    }
                });
            }
            AppMethodBeat.o(163593);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements com.tencent.mm.view.recyclerview.a {
        public int UXI = -1;
        public int UXJ = -1;
        public String UXK = "";
        public int videoHeight = -1;
        public int videoWidth = -1;
        public edn zaq;

        b() {
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            return 0;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 0;
        }

        public final void efJ() {
            AppMethodBeat.i(163594);
            if (this.videoHeight <= 0 || this.videoWidth <= 0) {
                float f2 = ((float) this.zaq.height) / (((float) this.zaq.width) * 1.0f);
                if (f2 > 1.667f) {
                    this.videoHeight = EnvelopeAppBarLayout.this.yZv;
                    this.videoWidth = (int) (((float) EnvelopeAppBarLayout.this.yZv) / f2);
                } else if (f2 < 1.667f) {
                    this.videoWidth = EnvelopeAppBarLayout.this.yZu;
                    this.videoHeight = (int) (f2 * ((float) EnvelopeAppBarLayout.this.yZu));
                } else {
                    this.videoHeight = EnvelopeAppBarLayout.this.yZv;
                    this.videoWidth = EnvelopeAppBarLayout.this.yZu;
                }
                Log.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight));
                AppMethodBeat.o(163594);
                return;
            }
            AppMethodBeat.o(163594);
        }
    }

    static /* synthetic */ void d(EnvelopeAppBarLayout envelopeAppBarLayout) {
        AppMethodBeat.i(258604);
        if (envelopeAppBarLayout.yZt.getSupportActionBar().getCustomView() != null) {
            envelopeAppBarLayout.yZt.getSupportActionBar().getCustomView().setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.AnonymousClass20 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    FrameLayout frameLayout;
                    AppMethodBeat.i(258601);
                    if (motionEvent.getAction() == 0) {
                        Rect rect = new Rect();
                        EnvelopeAppBarLayout.this.yZb.getGlobalVisibleRect(rect);
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        Log.d("MicroMsg.EnvelopeAppBarLayout", "rect: %s", rect.toString());
                        if (rect.contains(rawX, rawY)) {
                            Log.i("MicroMsg.EnvelopeAppBarLayout", "touch mCollespLayout");
                            if (!EnvelopeAppBarLayout.this.yZL && EnvelopeAppBarLayout.this.yZI == 2) {
                                EnvelopeAppBarLayout.this.b(true, true, true);
                                EnvelopeAppBarLayout.this.yZU = true;
                                d.xV(5);
                                c.bC(6, EnvelopeAppBarLayout.this.yZG);
                            }
                        }
                        Rect rect2 = new Rect();
                        com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) EnvelopeAppBarLayout.this.yYY.ch(EnvelopeAppBarLayout.this.apZ);
                        if (!(hVar == null || (frameLayout = (FrameLayout) hVar.Mn(R.id.ezx)) == null)) {
                            ((ViewGroup) frameLayout.findViewById(R.id.f5f)).getGlobalVisibleRect(rect2);
                            if (rect2.contains(rawX, rawY)) {
                                Log.i("MicroMsg.EnvelopeAppBarLayout", "touch mutBtn");
                                EnvelopeStoryVideoManager envelopeStoryVideoManager = EnvelopeAppBarLayout.this.yZD;
                                Log.i("MicroMsg.EnvelopeStoryVideoManager", "ClickMutBtnLl");
                                if (!(envelopeStoryVideoManager.zaD == -1 || envelopeStoryVideoManager.UXL.zaV == null)) {
                                    boolean z = envelopeStoryVideoManager.UXL.zaV.zaZ;
                                    envelopeStoryVideoManager.guh = !z;
                                    if (z) {
                                        envelopeStoryVideoManager.jvG.requestFocus();
                                        envelopeStoryVideoManager.dtC = true;
                                        envelopeStoryVideoManager.UXL.zaV.setMute(false);
                                    } else {
                                        if (envelopeStoryVideoManager.dtC) {
                                            envelopeStoryVideoManager.jvG.apm();
                                            envelopeStoryVideoManager.dtC = false;
                                        }
                                        envelopeStoryVideoManager.UXL.zaV.setMute(true);
                                    }
                                    EnvelopeStoryVideoManager.a(envelopeStoryVideoManager.UXL);
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(258601);
                    return false;
                }
            });
        }
        AppMethodBeat.o(258604);
    }

    static /* synthetic */ void r(EnvelopeAppBarLayout envelopeAppBarLayout) {
        AppMethodBeat.i(174337);
        Log.i("MicroMsg.EnvelopeAppBarLayout", "story view collapse");
        envelopeAppBarLayout.yZq.setClickable(false);
        if (envelopeAppBarLayout.UXH || envelopeAppBarLayout.yZL) {
            envelopeAppBarLayout.yZL = false;
            envelopeAppBarLayout.UXH = false;
            envelopeAppBarLayout.efF();
            envelopeAppBarLayout.yZD.efP();
            if (envelopeAppBarLayout.yZI == 2) {
                envelopeAppBarLayout.yZt.showOptionMenu(true);
            }
            envelopeAppBarLayout.efG();
            if (envelopeAppBarLayout.yZV) {
                envelopeAppBarLayout.yZV = false;
                if (envelopeAppBarLayout.yZI == 1 || envelopeAppBarLayout.yZI == 2) {
                    b.xV(2);
                }
                d.xV(10);
                AppMethodBeat.o(174337);
                return;
            }
            if (envelopeAppBarLayout.yZI == 1 || envelopeAppBarLayout.yZI == 2) {
                b.xV(1);
            }
            d.xV(9);
            AppMethodBeat.o(174337);
            return;
        }
        Log.d("MicroMsg.EnvelopeAppBarLayout", "has collapsed");
        AppMethodBeat.o(174337);
    }

    static /* synthetic */ void s(EnvelopeAppBarLayout envelopeAppBarLayout) {
        com.tencent.mm.view.recyclerview.h hVar;
        String str;
        boolean z;
        AppMethodBeat.i(258606);
        Log.i("MicroMsg.EnvelopeAppBarLayout", "story view expand");
        envelopeAppBarLayout.yZq.setClickable(true);
        if (envelopeAppBarLayout.yZL) {
            Log.d("MicroMsg.EnvelopeAppBarLayout", "has expanded");
            AppMethodBeat.o(258606);
            return;
        }
        envelopeAppBarLayout.yZL = true;
        envelopeAppBarLayout.UXH = false;
        if (envelopeAppBarLayout.efI() && (hVar = (com.tencent.mm.view.recyclerview.h) envelopeAppBarLayout.yYY.ch(envelopeAppBarLayout.apZ)) != null) {
            int i2 = envelopeAppBarLayout.apZ;
            b bVar = (b) hVar.Rra;
            bVar.efJ();
            if (EnvelopeStoryVideoManager.dD(bVar.UXI, bVar.UXK)) {
                str = bVar.UXK;
                z = true;
            } else {
                str = bVar.zaq.Gav;
                z = false;
            }
            envelopeAppBarLayout.yZD.a(envelopeAppBarLayout.getContext(), (FrameLayout) hVar.Mn(R.id.ezx), (ImageView) hVar.Mn(R.id.ezu), (ProgressBar) hVar.Mn(R.id.ezv), str, bVar.videoWidth, bVar.videoHeight, i2, true, z);
        }
        d.yPa = true;
        if (envelopeAppBarLayout.yZU) {
            envelopeAppBarLayout.yZU = false;
            b.vkj = 1;
        } else {
            d.xV(4);
            c.bC(7, envelopeAppBarLayout.yZG);
            b.vkj = 2;
        }
        if (envelopeAppBarLayout.yZI == 2 || envelopeAppBarLayout.yZI == 1) {
            b.k(c.openId, envelopeAppBarLayout.yZF, envelopeAppBarLayout.xiP, envelopeAppBarLayout.yZW);
            if (envelopeAppBarLayout.yZI == 2) {
                envelopeAppBarLayout.yZt.showOptionMenu(false);
                if (!envelopeAppBarLayout.yZX) {
                    c.bC(5, envelopeAppBarLayout.yZG);
                    envelopeAppBarLayout.yZX = true;
                }
                a.xV(2);
            }
        }
        envelopeAppBarLayout.yZb.setOnClickListener(null);
        envelopeAppBarLayout.yZb.setClickable(false);
        envelopeAppBarLayout.yYX.setOnClickListener(null);
        envelopeAppBarLayout.yYX.setClickable(false);
        if (envelopeAppBarLayout.zab) {
            if (envelopeAppBarLayout.isPreview) {
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_STORY_PREVIEW_GUIDE_TIME_INT_SYNC, (Object) 3);
                AppMethodBeat.o(258606);
                return;
            }
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_STORY_GUIDE_TIME_INT_SYNC, (Object) 3);
        }
        AppMethodBeat.o(258606);
    }

    static /* synthetic */ void t(EnvelopeAppBarLayout envelopeAppBarLayout) {
        AppMethodBeat.i(258607);
        envelopeAppBarLayout.UXH = true;
        if (envelopeAppBarLayout.yZE != null) {
            envelopeAppBarLayout.efG();
            envelopeAppBarLayout.yZq.setClickable(false);
            if (envelopeAppBarLayout.yZE.pTI != 0) {
                envelopeAppBarLayout.yZq.setVisibility(0);
            }
            envelopeAppBarLayout.UXC.setVisibility(0);
            if (envelopeAppBarLayout.yZI == 2) {
                envelopeAppBarLayout.yZD.efP();
                envelopeAppBarLayout.yZL = false;
                envelopeAppBarLayout.yZt.showOptionMenu(true);
            }
        }
        AppMethodBeat.o(258607);
    }
}
