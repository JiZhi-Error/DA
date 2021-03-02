package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ContentFragment extends Fragment {
    private final Map<String, Bitmap> Eer = new WeakHashMap();
    protected boolean EiA = false;
    protected boolean EiB = false;
    private BroadcastReceiver EiC = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass10 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(97091);
            String action = intent.getAction();
            Log.i("ContentFragmentSphereImageView", "onReceive, action=" + action + ", isSphereCom=" + ContentFragment.this.EiA + ", isFullScreen=" + ContentFragment.this.EiB);
            if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(action)) {
                FragmentActivity activity = ContentFragment.this.getActivity();
                if (activity instanceof SnsAdNativeLandingPagesUI) {
                    boolean fhs = ((SnsAdNativeLandingPagesUI) activity).fhs();
                    Log.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(fhs)));
                    if (fhs) {
                        ContentFragment.this.Eiw.EiO.setVisibility(0);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(500);
                        ContentFragment.this.Eiw.EiO.startAnimation(alphaAnimation);
                    }
                }
                AppMethodBeat.o(97091);
                return;
            }
            if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(action)) {
                if (ContentFragment.this.Eiw.EiO.getVisibility() == 0) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ContentFragment.this.Eiw.EiO, "alpha", 0.5f, 1.0f);
                    ofFloat.setDuration(300L);
                    ofFloat.start();
                    AppMethodBeat.o(97091);
                    return;
                }
            } else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(action)) {
                if (ContentFragment.this.Eiw.EiO.getVisibility() == 0) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ContentFragment.this.Eiw.EiO, "alpha", 1.0f, 0.5f);
                    ofFloat2.setDuration(300L);
                    ofFloat2.start();
                    AppMethodBeat.o(97091);
                    return;
                }
            } else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(action) && ContentFragment.this.Eiw.EiO.getVisibility() == 0) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setDuration(250);
                alphaAnimation2.setFillAfter(true);
                ContentFragment.this.Eiw.EiO.startAnimation(alphaAnimation2);
            }
            AppMethodBeat.o(97091);
        }
    };
    protected View.OnClickListener EiD = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass11 */

        public final void onClick(View view) {
            AppMethodBeat.i(97092);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FragmentActivity activity = ContentFragment.this.getActivity();
            if (activity instanceof SnsAdNativeLandingPagesUI) {
                Log.i("ContentFragmentSphereImageView", "jumpNextPage");
                ((SnsAdNativeLandingPagesUI) activity).fhr();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97092);
        }
    };
    private View.OnClickListener EiE = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(203123);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            try {
                RecyclerView recyclerView = ContentFragment.this.getRecyclerView();
                if (recyclerView == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203123);
                    return;
                }
                FragmentActivity activity = ContentFragment.this.getActivity();
                if (activity instanceof SnsAdNativeLandingPagesUI) {
                    SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) activity;
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (linearLayoutManager == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203123);
                        return;
                    }
                    int ku = linearLayoutManager.ku();
                    int itemCount = linearLayoutManager.getItemCount();
                    if (ku < 0 || itemCount <= 0) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203123);
                        return;
                    }
                    if (ku != itemCount - 1) {
                        Log.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
                        recyclerView.a(0, ContentFragment.this.mEY, (Interpolator) null);
                    } else {
                        Log.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
                        if (snsAdNativeLandingPagesUI.fhs()) {
                            Log.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
                            snsAdNativeLandingPagesUI.fhr();
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203123);
                    return;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203123);
            } catch (Throwable th) {
                Log.e("ContentFragment.VideoPlay", th.toString());
            }
        }
    };
    private boolean EiF = false;
    private OverScrollLinearout.a EiG = new OverScrollLinearout.a() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a
        public final void bV(float f2) {
            AppMethodBeat.i(203124);
            int i2 = (int) (((double) f2) * 0.8d);
            if (ContentFragment.this.Eiw == null || ContentFragment.this.Eiw.EiM == null || ContentFragment.this.Eiw.EiM.getScrollY() + i2 <= 0) {
                AppMethodBeat.o(203124);
                return;
            }
            int fek = ContentFragment.this.fek();
            if (fek > 0) {
                int scrollY = ContentFragment.this.Eiw.EiM.getScrollY();
                if (scrollY < fek) {
                    ContentFragment.this.Eiw.EiM.scrollBy(0, Math.min(i2, fek - scrollY));
                }
                AppMethodBeat.o(203124);
                return;
            }
            m fdW = ContentFragment.this.Eix.fdW();
            if (!(fdW instanceof o)) {
                AppMethodBeat.o(203124);
                return;
            }
            o oVar = (o) fdW;
            if (ContentFragment.this.Eiw.EiM.getScrollY() + i2 < oVar.Edl) {
                ContentFragment.this.Eiw.EiM.scrollBy(0, i2);
                AppMethodBeat.o(203124);
                return;
            }
            if (!ContentFragment.this.EiF) {
                ContentFragment.this.EiF = true;
                oVar.fdv();
            }
            AppMethodBeat.o(203124);
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a
        public final boolean fel() {
            AppMethodBeat.i(203125);
            int fek = ContentFragment.this.fek();
            int ku = ContentFragment.this.vKp.ku();
            boolean canScrollVertically = ContentFragment.this.getRecyclerView().canScrollVertically(1);
            m fdW = ContentFragment.this.Eix.fdW();
            if (!ContentFragment.this.jUX || canScrollVertically || ku != ContentFragment.this.Eix.getItemCount() - 1 || (fek <= 0 && !(fdW instanceof o))) {
                AppMethodBeat.o(203125);
                return false;
            }
            AppMethodBeat.o(203125);
            return true;
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a
        public final void fdL() {
            AppMethodBeat.i(203126);
            ContentFragment.this.EiF = false;
            AppMethodBeat.o(203126);
        }
    };
    public g Eig;
    private int Eii;
    public c Eik;
    private int Eil = 1000;
    private aq Eim;
    public boolean Ein;
    private boolean Eio;
    private boolean Eip;
    public boolean Eiq;
    private boolean Eir = false;
    private ValueAnimator Eis;
    private int Eit;
    public int Eiu;
    public a Eiv;
    private b Eiw;
    private a Eix;
    private boolean Eiy;
    protected final String Eiz = "ContentFragmentSphereImageView";
    private int bgColor;
    public boolean cQp;
    public boolean jUX;
    private int kcc;
    private int mEX;
    private int mEY;
    private MMHandler ndA;
    public Map<String, Object> params;
    private LinearLayoutManager vKp;

    public interface a extends Serializable {
        void q(ContentFragment contentFragment);
    }

    static /* synthetic */ void a(ContentFragment contentFragment, Bitmap bitmap) {
        AppMethodBeat.i(97122);
        contentFragment.az(bitmap);
        AppMethodBeat.o(97122);
    }

    static /* synthetic */ boolean b(ContentFragment contentFragment) {
        AppMethodBeat.i(97117);
        boolean fef = contentFragment.fef();
        AppMethodBeat.o(97117);
        return fef;
    }

    static /* synthetic */ void c(ContentFragment contentFragment) {
        AppMethodBeat.i(97118);
        contentFragment.fec();
        AppMethodBeat.o(97118);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public ImageView EiL;
        public OverScrollLinearout EiM;
        public ImageView EiN;
        public View EiO;
        public boolean EiP;
        LinearLayout EiQ;
        public View gvQ;
        public RecyclerView hak;

        private b() {
            this.EiL = null;
            this.EiM = null;
            this.EiN = null;
            this.EiO = null;
            this.EiP = false;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public ContentFragment() {
        AppMethodBeat.i(97093);
        AppMethodBeat.o(97093);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(97094);
        super.onCreate(bundle);
        Map<String, Object> map = this.params;
        int[] ha = ap.ha(getContext());
        this.mEX = ha[0];
        this.mEY = ha[1];
        if (this.Eig == null) {
            this.Eig = (g) map.get("pageInfo");
            b(this.Eig);
        }
        this.Eim = (aq) map.get("pageDownIconInfo");
        this.Ein = Util.nullAsFalse((Boolean) map.get("is_first_show_page"));
        this.jUX = Util.nullAsFalse((Boolean) map.get("is_last_shown_page"));
        this.Eio = Util.nullAsFalse((Boolean) map.get("needEnterAnimation"));
        this.Eip = Util.nullAsFalse((Boolean) map.get("needDirectionAnimation"));
        this.Eii = Util.nullAsInt(map.get("groupListCompShowIndex"), 0);
        AppMethodBeat.o(97094);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(97095);
        View inflate = layoutInflater.inflate(R.layout.c6, viewGroup, false);
        this.Eiw = new b((byte) 0);
        this.Eiw.gvQ = inflate;
        this.Eiw.EiL = (ImageView) inflate.findViewById(R.id.hvm);
        this.Eiw.EiM = (OverScrollLinearout) inflate.findViewById(R.id.hw9);
        if (this.jUX) {
            this.Eiw.EiM.setOnScrollActionListener(this.EiG);
        }
        this.Eiw.EiN = (ImageView) inflate.findViewById(R.id.hz_);
        this.Eiw.EiO = inflate.findViewById(R.id.hza);
        this.Eiw.EiO.setOnClickListener(this.EiD);
        this.Eiw.EiN.setOnClickListener(this.EiE);
        this.Eiw.hak = (RecyclerView) inflate.findViewById(R.id.bez);
        this.Eiw.EiQ = (LinearLayout) inflate.findViewById(R.id.cas);
        RecyclerView recyclerView = this.Eiw.hak;
        recyclerView.setOverScrollMode(0);
        int nullAsInt = Util.nullAsInt(this.params.get("pageCount"), 0);
        Log.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(nullAsInt)));
        if (nullAsInt > 1) {
            recyclerView.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager) this.params.get("viewPager")));
        } else {
            recyclerView.setOnTouchListener(null);
        }
        getActivity();
        this.vKp = new LinearLayoutManager();
        recyclerView.setLayoutManager(this.vKp);
        this.Eix = new a(this.Eig, this.bgColor, getActivity(), this.vKp);
        if (this.Ein) {
            this.Eix.Eii = this.Eii;
        }
        recyclerView.setAdapter(this.Eix);
        recyclerView.setDescendantFocusability(131072);
        this.Eik = new c(recyclerView);
        recyclerView.a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(97078);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                if (ContentFragment.this.Eiw.EiL != null && ContentFragment.this.Eiw.EiL.getVisibility() == 0) {
                    ContentFragment.this.Eiw.EiL.scrollBy(i2, i3);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(97078);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(97079);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                ContentFragment.this.Eit = i2;
                if (i2 == 0) {
                    ContentFragment.this.JC(50);
                    if (ContentFragment.b(ContentFragment.this)) {
                        ContentFragment.this.fed();
                    }
                } else if (i2 == 1) {
                    ContentFragment.this.fee();
                    ap.hb(ContentFragment.this.getContext());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(97079);
            }
        });
        inflate.setTag(this.Eiw);
        aED();
        this.Eis = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.Eis.setDuration((long) this.Eil);
        this.Eis.setInterpolator(new AccelerateDecelerateInterpolator());
        this.Eis.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass6 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(97084);
                ContentFragment.this.Eiw.EiN.setTranslationY((float) ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) (-com.tencent.mm.cb.a.fromDPToPix(ContentFragment.this.getContext(), 20))))));
                AppMethodBeat.o(97084);
            }
        });
        this.Eis.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass7 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(97085);
                Log.d("ContentFragment", "onAnimationStart show nextBtn");
                ContentFragment.this.Eiw.EiP = true;
                AppMethodBeat.o(97085);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(97086);
                Log.d("ContentFragment", "onAnimationEnd show nextBtn");
                ContentFragment.this.Eiw.EiP = false;
                AppMethodBeat.o(97086);
            }
        });
        this.Eis.setRepeatCount(-1);
        this.Eis.setRepeatMode(2);
        if (this.Eim != null && !this.Eim.equals(this.Eiw.EiN.getTag())) {
            this.Eiw.EiN.setTag(this.Eim);
            this.Eiw.EiN.setVisibility(8);
            h.a(this.Eim.iconUrl, 1000000001, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(97087);
                    Log.d("ContentFragment", "onDownloadError nextBtn");
                    AppMethodBeat.o(97087);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(97088);
                    Log.d("ContentFragment", "onDownloaded nextBtn");
                    ContentFragment.a(ContentFragment.this, str, ContentFragment.this.Eiw.EiN);
                    ContentFragment.this.fed();
                    AppMethodBeat.o(97088);
                }
            });
        }
        if (this.Eiv != null) {
            this.Eiv.q(this);
        }
        AppMethodBeat.o(97095);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(97096);
        super.onResume();
        Log.i("ContentFragment", this + " onResume " + getUserVisibleHint());
        this.cQp = true;
        if (!(this.Eiw == null || this.Eiw.gvQ == null)) {
            ViewGroup viewGroup = (ViewGroup) this.Eiw.gvQ.getParent();
            while (viewGroup != null && (viewGroup == null || viewGroup.getId() != R.id.h8v)) {
                viewGroup = (ViewGroup) viewGroup.getParent();
            }
            if (viewGroup instanceof FrameLayout) {
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (viewGroup.getChildAt(i2) instanceof SnsAdLandingPageFloatView) {
                        this.cQp = false;
                    }
                }
            }
        }
        this.Eik.cQp = this.cQp;
        if (this.Eik != null && getUserVisibleHint()) {
            this.Eik.fcS();
        }
        if (this.EiA) {
            try {
                Log.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
                intentFilter.addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
                intentFilter.addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
                intentFilter.addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
                d.W(getContext()).a(this.EiC, intentFilter);
                AppMethodBeat.o(97096);
                return;
            } catch (Exception e2) {
                Log.e("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, exp:" + e2.toString());
            }
        }
        AppMethodBeat.o(97096);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        AppMethodBeat.i(97097);
        super.onPause();
        Log.i("ContentFragment", this + " onPause " + getUserVisibleHint());
        this.cQp = false;
        this.Eik.cQp = this.cQp;
        if (this.Eik != null && getUserVisibleHint()) {
            this.Eik.fdU();
        }
        if (this.EiA) {
            try {
                Log.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
                d.W(getContext()).unregisterReceiver(this.EiC);
                AppMethodBeat.o(97097);
                return;
            } catch (Exception e2) {
                Log.e("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, exp:" + e2.toString());
            }
        }
        AppMethodBeat.o(97097);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(97098);
        super.onDestroy();
        if (this.Eik != null) {
            this.Eik.EhP.onDestroy();
        }
        fee();
        AppMethodBeat.o(97098);
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(97099);
        super.setUserVisibleHint(z);
        if (z) {
            if (this.Eik != null) {
                this.Eik.fcS();
                AppMethodBeat.o(97099);
                return;
            }
        } else if (this.Eik != null) {
            this.Eik.fdU();
        }
        AppMethodBeat.o(97099);
    }

    public final void fdZ() {
        AppMethodBeat.i(97100);
        if (this.cQp && this.Eik != null) {
            this.Eik.fdT();
        }
        AppMethodBeat.o(97100);
    }

    public final boolean fea() {
        View view;
        AppMethodBeat.i(97101);
        try {
            m fdW = this.Eix.fdW();
            if (fdW == null || !(fdW.fdk().type == 62 || fdW.fdk().type == 61)) {
                m fdX = this.Eix.fdX();
                if (!(fdX == null || ((fdX.fdk().type != 62 && fdX.fdk().type != 61) || fdW == null || (view = fdW.contentView) == null))) {
                    Rect rect = new Rect();
                    view.getLocalVisibleRect(rect);
                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 88);
                    if (rect.bottom >= 0 && rect.bottom < fromDPToPix) {
                        Log.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp.rect=" + rect.toShortString());
                        AppMethodBeat.o(97101);
                        return true;
                    }
                }
                Log.i("ContentFragment", "isFloatBarCoverVideo, ret=false");
                AppMethodBeat.o(97101);
                return false;
            }
            Log.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
            AppMethodBeat.o(97101);
            return true;
        } catch (Exception e2) {
            Log.e("ContentFragment", "isFloatBarCoverVideo, exp=" + e2.toString());
        }
    }

    public final boolean feb() {
        return this.Eig != null && this.Eig.Elm;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(97102);
        if (this.Eig != gVar) {
            this.Eig = gVar;
            b(gVar);
            aED();
        }
        AppMethodBeat.o(97102);
    }

    private void aED() {
        AppMethodBeat.i(97103);
        if (this.Eiw == null) {
            AppMethodBeat.o(97103);
            return;
        }
        fec();
        if (this.Eig.Elg == null || this.Eig.Elg.length() <= 0) {
            fec();
        } else {
            final String str = this.Eig.Elg;
            Log.i("ContentFragment", "bg need blur %b, url %s", Boolean.valueOf(this.Eig.Elh), str);
            if (this.Eer.containsKey(str)) {
                Log.i("ContentFragment", "bg has cache bitmap");
                az(this.Eer.get(str));
            } else {
                h.a("adId", str, false, 1000000001, new f.a() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWN() {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWO() {
                        AppMethodBeat.i(97080);
                        Log.i("ContentFragment", "download img fail %s", str);
                        ContentFragment.c(ContentFragment.this);
                        AppMethodBeat.o(97080);
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void aNH(String str) {
                        AppMethodBeat.i(97081);
                        ContentFragment.a(ContentFragment.this, str, "adId", str);
                        AppMethodBeat.o(97081);
                    }
                });
            }
        }
        if (this.Eix != null) {
            if (this.Eig.Elg == null || this.Eig.Elg.length() <= 0) {
                this.Eix.bgColor = this.bgColor;
            } else {
                this.Eix.bgColor = 0;
            }
            this.Eix.a(this.Eig);
        }
        AppMethodBeat.o(97103);
    }

    private void fec() {
        AppMethodBeat.i(97104);
        if (this.Eig.lco != null && this.Eig.lco.length() > 0) {
            Log.i("ContentFragment", "setting bg color %s", this.Eig.lco);
            try {
                this.bgColor = Color.parseColor(this.Eig.lco);
            } catch (Exception e2) {
                Log.e("ContentFragment", "the color is error : " + this.Eig.lco);
            }
            this.Eiw.gvQ.setBackgroundColor(this.bgColor);
            this.Eiw.EiL.setBackgroundColor(this.bgColor);
            this.Eiw.EiM.setBackgroundColor(this.bgColor);
        }
        AppMethodBeat.o(97104);
    }

    private void az(Bitmap bitmap) {
        AppMethodBeat.i(97105);
        if (bitmap != null) {
            this.Eiw.gvQ.setBackgroundColor(0);
            this.Eiw.EiL.setBackgroundColor(0);
            this.Eiw.EiM.setBackgroundColor(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Eiw.EiL.getLayoutParams();
            layoutParams.height = layoutParams.height >= this.mEY ? layoutParams.height : this.mEY;
            this.Eiw.EiL.setLayoutParams(layoutParams);
            this.Eiw.EiL.setImageBitmap(bitmap);
            AppMethodBeat.o(97105);
            return;
        }
        fec();
        AppMethodBeat.o(97105);
    }

    public final RecyclerView getRecyclerView() {
        if (this.Eiw != null) {
            return this.Eiw.hak;
        }
        return null;
    }

    public final Collection<m> fdY() {
        AppMethodBeat.i(97106);
        if (this.Eix == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(97106);
            return list;
        }
        Collection<m> fdY = this.Eix.fdY();
        AppMethodBeat.o(97106);
        return fdY;
    }

    public final void fed() {
        AppMethodBeat.i(97107);
        try {
            if (!fef() || this.Eir || this.Eiw.EiP) {
                AppMethodBeat.o(97107);
                return;
            }
            this.Eiw.EiN.setVisibility(0);
            this.Eiw.EiN.setTranslationY((float) (-com.tencent.mm.cb.a.fromDPToPix(getContext(), 20)));
            this.Eis.setRepeatMode(2);
            this.Eis.setRepeatCount(-1);
            this.Eis.start();
            AppMethodBeat.o(97107);
        } catch (Exception e2) {
            Log.e("ContentFragment", "startDownAnimation, exp=" + e2.toString());
            AppMethodBeat.o(97107);
        }
    }

    public final void fee() {
        AppMethodBeat.i(97108);
        try {
            this.Eiw.EiN.setVisibility(4);
            this.Eiw.EiN.setTranslationY((float) (-com.tencent.mm.cb.a.fromDPToPix(getContext(), 20)));
            this.Eis.setRepeatMode(2);
            this.Eis.setRepeatCount(0);
            this.Eis.end();
            AppMethodBeat.o(97108);
        } catch (Exception e2) {
            Log.e("ContentFragment", "stopDownAnimation, exp=" + e2.toString());
            AppMethodBeat.o(97108);
        }
    }

    private boolean fef() {
        boolean z = true;
        AppMethodBeat.i(97109);
        if (!this.Eip) {
            AppMethodBeat.o(97109);
            return false;
        } else if (this.Eit != 0) {
            AppMethodBeat.o(97109);
            return false;
        } else if (this.Eiu != 0) {
            AppMethodBeat.o(97109);
            return false;
        } else if (this.EiA) {
            AppMethodBeat.o(97109);
            return false;
        } else {
            SnsAdNativeLandingPagesUI fei = fei();
            if (fei == null || (!fei.fhv() && !fei.Eyj)) {
                int ks = this.vKp.ks();
                if (ks == this.vKp.ku() && ks == -1) {
                    AppMethodBeat.o(97109);
                    return false;
                }
                if (this.jUX && this.vKp.ku() == this.Eix.getItemCount() - 1) {
                    z = false;
                }
                AppMethodBeat.o(97109);
                return z;
            }
            AppMethodBeat.o(97109);
            return false;
        }
    }

    public final void vj(boolean z) {
        AppMethodBeat.i(97110);
        this.Eir = z;
        if (!fef() || z) {
            fee();
            AppMethodBeat.o(97110);
            return;
        }
        fed();
        AppMethodBeat.o(97110);
    }

    private void b(g gVar) {
        AppMethodBeat.i(97111);
        this.EiA = false;
        this.EiB = false;
        if (gVar != null && gVar.Eli != null) {
            Iterator<z> it = gVar.Eli.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                z next = it.next();
                if (next instanceof u) {
                    u uVar = (u) next;
                    if (uVar.DYJ || uVar.width == 0.0f || uVar.height == 0.0f) {
                        this.EiB = true;
                    }
                    this.EiA = true;
                }
            }
        }
        Log.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.EiA + ", isFullScreen=" + this.EiB);
        AppMethodBeat.o(97111);
    }

    public final boolean feg() {
        AppMethodBeat.i(97112);
        try {
            ad fej = fej();
            if (!this.jUX || fej == null) {
                AppMethodBeat.o(97112);
                return true;
            }
            if (this.Eiw.hak != null) {
                int computeVerticalScrollOffset = this.Eiw.hak.computeVerticalScrollOffset();
                int computeVerticalScrollRange = (this.Eiw.hak.computeVerticalScrollRange() - computeVerticalScrollOffset) - this.Eiw.hak.computeVerticalScrollExtent();
                Log.d("ContentFragment", "bottomDis=" + computeVerticalScrollRange + ", appearBottom=" + fej.DZF + ", topDis=" + computeVerticalScrollOffset + ", appearTop=" + fej.DZE + ", height=" + com.tencent.mm.cb.a.jo(getContext()));
                if (fej.DZF > 0 && computeVerticalScrollRange < fej.DZF) {
                    AppMethodBeat.o(97112);
                    return false;
                }
            }
            AppMethodBeat.o(97112);
            return true;
        } catch (Exception e2) {
        }
    }

    public final boolean feh() {
        AppMethodBeat.i(97113);
        try {
            ad fej = fej();
            int computeVerticalScrollOffset = this.Eiw.hak.computeVerticalScrollOffset();
            if (this.Ein && fej != null) {
                if (fej.DZE == 0 || (fej.DZE > 0 && computeVerticalScrollOffset >= fej.DZE)) {
                    AppMethodBeat.o(97113);
                    return true;
                }
                AppMethodBeat.o(97113);
                return false;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(97113);
        return true;
    }

    private SnsAdNativeLandingPagesUI fei() {
        AppMethodBeat.i(97114);
        FragmentActivity activity = getActivity();
        if (activity instanceof SnsAdNativeLandingPagesUI) {
            SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) activity;
            AppMethodBeat.o(97114);
            return snsAdNativeLandingPagesUI;
        }
        AppMethodBeat.o(97114);
        return null;
    }

    private ad fej() {
        AppMethodBeat.i(97115);
        SnsAdNativeLandingPagesUI fei = fei();
        if (fei != null) {
            ad adVar = fei.Exu;
            AppMethodBeat.o(97115);
            return adVar;
        }
        AppMethodBeat.o(97115);
        return null;
    }

    public final void JC(long j2) {
        AppMethodBeat.i(97116);
        SnsAdNativeLandingPagesUI fei = fei();
        if (fei != null) {
            fei.JC(j2);
        }
        AppMethodBeat.o(97116);
    }

    /* access modifiers changed from: protected */
    public final int fek() {
        AppMethodBeat.i(203127);
        FragmentActivity activity = getActivity();
        if (activity instanceof SnsAdNativeLandingPagesUI) {
            FloatJumpCompHelper floatJumpCompHelper = ((SnsAdNativeLandingPagesUI) activity).EyS;
            if (floatJumpCompHelper != null) {
                int i2 = floatJumpCompHelper.Duc;
                AppMethodBeat.o(203127);
                return i2;
            }
            AppMethodBeat.o(203127);
            return -1;
        }
        AppMethodBeat.o(203127);
        return -1;
    }

    static /* synthetic */ void a(ContentFragment contentFragment, final String str, final String str2, final String str3) {
        AppMethodBeat.i(97119);
        if (contentFragment.ndA == null) {
            contentFragment.ndA = new MMHandler("ContentFragment");
        }
        contentFragment.ndA.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass5 */

            public final void run() {
                Bitmap bitmap;
                n nVar;
                float f2 = 1.0f;
                final Bitmap bitmap2 = null;
                AppMethodBeat.i(97083);
                Log.i("ContentFragment", "download bg ok path %s ", str);
                try {
                    if (ContentFragment.this.Eig.Elh) {
                        ContentFragment.e(ContentFragment.this);
                        String kz = h.kz(str2, str3 + "_blurimg");
                        if (!s.YS(kz)) {
                            Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
                            if (decodeFile != null) {
                                if (decodeFile.getHeight() < ContentFragment.this.mEY || decodeFile.getWidth() < ContentFragment.this.mEX) {
                                    f2 = Math.max((((float) ContentFragment.this.mEX) * 1.0f) / ((float) decodeFile.getWidth()), (1.0f * ((float) ContentFragment.this.mEY)) / ((float) decodeFile.getHeight()));
                                }
                                Bitmap rotateAndScale = BitmapUtil.rotateAndScale(decodeFile, 0.0f, f2, f2);
                                try {
                                    bitmap = Bitmap.createBitmap(rotateAndScale, (rotateAndScale.getWidth() - ContentFragment.this.mEX) >>> 1, (rotateAndScale.getHeight() - ContentFragment.this.mEY) >>> 1, ContentFragment.this.mEX, ContentFragment.this.mEY);
                                } catch (OutOfMemoryError e2) {
                                    Log.printErrStackTrace("ContentFragment", e2, "", new Object[0]);
                                    bitmap = null;
                                }
                                if (bitmap != null) {
                                    nVar = com.tencent.mm.plugin.sns.lucky.a.a.a(bitmap, kz, Color.argb(140, 0, 0, 0), TXLiveConstants.RENDER_ROTATION_180);
                                } else {
                                    nVar = null;
                                }
                                if (nVar != null) {
                                    bitmap2 = nVar.aSb();
                                }
                            }
                        } else {
                            bitmap2 = BitmapUtil.decodeFile(kz);
                        }
                    } else {
                        bitmap2 = BitmapUtil.decodeFile(str, null);
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(97082);
                            if (bitmap2 == null) {
                                Log.i("ContentFragment", "decode img fail, set bg color %s", str3);
                                ContentFragment.h(ContentFragment.this);
                                AppMethodBeat.o(97082);
                                return;
                            }
                            Log.i("ContentFragment", "set bg with bitmap");
                            ContentFragment.this.Eer.put(str3, bitmap2);
                            ContentFragment.a(ContentFragment.this, bitmap2);
                            AppMethodBeat.o(97082);
                        }
                    });
                    AppMethodBeat.o(97083);
                } catch (Exception e3) {
                    Log.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + e3.toString());
                    AppMethodBeat.o(97083);
                }
            }
        });
        AppMethodBeat.o(97119);
    }

    static /* synthetic */ void e(ContentFragment contentFragment) {
        AppMethodBeat.i(97120);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(97090);
                if (ContentFragment.this.Eiw == null) {
                    AppMethodBeat.o(97090);
                    return;
                }
                if ((ContentFragment.this.Eig.Elh || !TextUtils.isEmpty(ContentFragment.this.Eig.Elg)) && !ContentFragment.this.Eiy) {
                    ContentFragment.this.Eiy = true;
                    ContentFragment.this.Eiw.EiQ.setVisibility(0);
                    ContentFragment.this.Eiw.EiL.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ContentFragment.this.Eiw.EiQ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.AnonymousClass9.AnonymousClass1 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(97089);
                            if (ContentFragment.this.Eiw.EiQ.getHeight() > 0) {
                                ContentFragment.this.Eiw.EiQ.getViewTreeObserver().removeOnPreDrawListener(this);
                                ContentFragment.this.kcc = ContentFragment.this.Eiw.EiQ.getHeight();
                                if (ContentFragment.this.kcc < ContentFragment.this.mEY) {
                                    ContentFragment.this.kcc = ContentFragment.this.mEY;
                                }
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ContentFragment.this.Eiw.EiL.getLayoutParams();
                                layoutParams.height = ContentFragment.this.kcc;
                                ContentFragment.this.Eiw.EiL.setLayoutParams(layoutParams);
                                Log.i("ContentFragment", "set bgIV height " + ContentFragment.this.Eiw.EiQ.getHeight() + ", count " + ContentFragment.this.Eiw.EiQ.getChildCount());
                                for (int i2 = 0; i2 < ContentFragment.this.Eiw.EiQ.getChildCount(); i2++) {
                                    Object tag = ContentFragment.this.Eiw.EiQ.getChildAt(i2).getTag();
                                    if (tag instanceof m) {
                                        ((m) tag).eXd();
                                    }
                                }
                                ContentFragment.this.Eiw.EiQ.removeAllViews();
                                ContentFragment.this.Eiw.EiQ.setVisibility(8);
                            }
                            AppMethodBeat.o(97089);
                            return true;
                        }
                    });
                    a aVar = ContentFragment.this.Eix;
                    LinearLayout linearLayout = ContentFragment.this.Eiw.EiQ;
                    for (int i2 = 0; i2 < aVar.Eig.Eli.size(); i2++) {
                        m a2 = ay.a(linearLayout.getContext(), aVar.Eig.Eli.get(i2), linearLayout, aVar.bgColor);
                        if (a2 != null) {
                            if (a2.getView().getParent() != null && (a2.getView().getParent() instanceof ViewGroup)) {
                                ((ViewGroup) a2.getView().getParent()).removeView(a2.getView());
                            }
                            a2.getView().setTag(a2);
                            linearLayout.addView(a2.getView());
                        }
                    }
                }
                AppMethodBeat.o(97090);
            }
        }, 1000);
        AppMethodBeat.o(97120);
    }

    static /* synthetic */ void h(ContentFragment contentFragment) {
        AppMethodBeat.i(97121);
        contentFragment.fec();
        AppMethodBeat.o(97121);
    }

    static /* synthetic */ void a(ContentFragment contentFragment, String str, ImageView imageView) {
        AppMethodBeat.i(97123);
        Bitmap decodeFile = BitmapUtil.decodeFile(str);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (Float.compare(contentFragment.Eim.width, 0.0f) > 0) {
            layoutParams.width = (int) contentFragment.Eim.width;
        } else {
            layoutParams.width = -1;
        }
        if (Float.compare(contentFragment.Eim.height, 0.0f) > 0) {
            layoutParams.height = (int) contentFragment.Eim.height;
        } else {
            layoutParams.height = -2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) contentFragment.Eim.paddingBottom;
        }
        imageView.setImageBitmap(decodeFile);
        AppMethodBeat.o(97123);
    }
}
