package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.g;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.a.i;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.share.z;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.profile.model.WxaRegisterInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.emo;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.fdd;
import com.tencent.mm.protocal.protobuf.fdu;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.protocal.protobuf.fef;
import com.tencent.mm.protocal.protobuf.feg;
import com.tencent.mm.protocal.protobuf.feh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.h.d;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class AppBrandProfileUI extends MMActivity implements MStorage.IOnStorageChange {
    private static final String nUV = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/wapreportwxadevlog?action=get_page&appid=%s#wechat_redirect");
    private static final String nUW = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1n) + "/wap/guard/dist/main/index.html#/Index?source=mini_game");
    private static final int nUX = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    private static final int nUY = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
    private static final int nUZ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    private static int nVa = -1;
    private static final int nVb = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    private static final int nVc = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 44);
    private static final int nVd = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    private static final int nVe = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    private String krY = "";
    private LinearLayout mPH;
    private String mRa;
    private ae nRv;
    private LinearLayout nVA;
    private TextView nVB;
    private FrameLayout nVC;
    private TextView nVD;
    private TextView nVE;
    private LinearLayout nVF;
    private ImageView nVG;
    private LinearLayout nVH;
    private AppBrandNearbyShowcaseView nVI;
    private TextView nVJ;
    private View nVK;
    private TextView nVL;
    private int nVM;
    private e nVN;
    private WxaExposedParams nVO;
    private boolean nVP = false;
    private b.h nVQ;
    private b.h nVR;
    private b.h nVS;
    private boolean nVT;
    private boolean nVU;
    private boolean nVV;
    private String nVW = "";
    private String nVX = "";
    private String nVY = "";
    private Runnable nVZ = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass9 */

        public final void run() {
            AppMethodBeat.i(227637);
            AppBrandProfileUI.this.nVk.setHighlightColor(AppBrandProfileUI.this.getResources().getColor(17170445));
            AppBrandProfileUI.this.nVk.setText(AppBrandProfileUI.this.krY);
            AppBrandProfileUI.this.nVk.requestLayout();
            AppBrandProfileUI.this.nVk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass9.AnonymousClass1 */

                public final void onGlobalLayout() {
                    int i2;
                    String str;
                    AppMethodBeat.i(227636);
                    AppBrandProfileUI.this.nVk.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ArrayList<SpannableString> arrayList = new ArrayList();
                    if (AppBrandProfileUI.this.nVV) {
                        Pair<SpannableString, Integer> a2 = af.a(AppBrandProfileUI.this.getContext(), R.drawable.byb, 36, 20, new ClickableSpan() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(227633);
                                if (TextUtils.isEmpty(AppBrandProfileUI.this.nVY)) {
                                    AppMethodBeat.o(227633);
                                    return;
                                }
                                AppBrandProfileUI.a(AppBrandProfileUI.this, 25, 1);
                                com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.this.nVY).putExtra("forceHideShare", true));
                                Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click official icon");
                                AppMethodBeat.o(227633);
                            }
                        });
                        arrayList.add(a2.first);
                        i2 = ((Integer) a2.second).intValue() + 0;
                    } else {
                        i2 = 0;
                    }
                    if (AppBrandProfileUI.this.nVT) {
                        Pair<SpannableString, Integer> a3 = af.a(AppBrandProfileUI.this.getContext(), R.drawable.by3, 36, 20, new ClickableSpan() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass9.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(227634);
                                if (TextUtils.isEmpty(AppBrandProfileUI.this.nVW)) {
                                    AppMethodBeat.o(227634);
                                    return;
                                }
                                try {
                                    com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", w.cl(AppBrandProfileUI.this.nVW, "appid=" + AppBrandProfileUI.this.nVO.appId)).putExtra("forceHideShare", true));
                                    AppBrandProfileUI.a(AppBrandProfileUI.this, 21, 1);
                                } catch (URISyntaxException e2) {
                                    Log.printErrStackTrace("MicroMsg.AppBrand.Profile.AppBrandProfileUI", e2, "URISyntaxException with originalRedirectUrl %s", AppBrandProfileUI.this.nVW);
                                }
                                Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click original icon");
                                AppMethodBeat.o(227634);
                            }
                        });
                        arrayList.add(a3.first);
                        i2 += ((Integer) a3.second).intValue();
                    }
                    if (AppBrandProfileUI.this.nVU) {
                        Pair<SpannableString, Integer> a4 = af.a(AppBrandProfileUI.this.getContext(), R.drawable.by5, 16, 16, new ClickableSpan() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass9.AnonymousClass1.AnonymousClass3 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(227635);
                                if (TextUtils.isEmpty(AppBrandProfileUI.this.nVX)) {
                                    AppMethodBeat.o(227635);
                                    return;
                                }
                                AppBrandProfileUI.a(AppBrandProfileUI.this, 26, 1);
                                com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.this.nVX).putExtra("forceHideShare", true));
                                Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click guarantee icon");
                                AppMethodBeat.o(227635);
                            }
                        });
                        arrayList.add(a4.first);
                        i2 += ((Integer) a4.second).intValue();
                    }
                    arrayList.add(af.es(AppBrandProfileUI.this.getContext()).first);
                    int width = (AppBrandProfileUI.this.nVk.getWidth() - AppBrandProfileUI.this.nVk.getPaddingLeft()) - AppBrandProfileUI.this.nVk.getPaddingRight();
                    TextPaint paint = AppBrandProfileUI.this.nVk.getPaint();
                    if (AppBrandProfileUI.this.krY == null) {
                        str = "";
                    } else {
                        str = AppBrandProfileUI.this.krY;
                    }
                    List<Point> a5 = af.a(paint, str, width);
                    String str2 = AppBrandProfileUI.this.krY;
                    if (a5.size() >= AppBrandProfileUI.this.nVk.getMaxLines()) {
                        int min = Math.min(AppBrandProfileUI.this.nVk.getMaxLines() - 1, a5.size() - 1);
                        str2 = AppBrandProfileUI.this.krY.substring(0, a5.get(min).x) + ((Object) TextUtils.ellipsize(AppBrandProfileUI.this.krY.substring(a5.get(min).x), paint, (float) (width - i2), TextUtils.TruncateAt.END));
                    }
                    AppBrandProfileUI.this.nVk.setText(str2);
                    for (SpannableString spannableString : arrayList) {
                        AppBrandProfileUI.this.nVk.append(spannableString);
                    }
                    AppMethodBeat.o(227636);
                }
            });
            AppBrandProfileUI.this.nVk.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.o(227637);
        }
    };
    private boolean nVf = false;
    private boolean nVg = false;
    private int nVh = 0;
    private LinkedList<fdu> nVi = new LinkedList<>();
    private ImageView nVj;
    private TextView nVk;
    private TextView nVl;
    private TextView nVm;
    private RatingBar nVn;
    private TextView nVo;
    private LinearLayout nVp;
    private RecyclerView nVq;
    private LinearLayout nVr;
    private LinearLayout nVs;
    private LinearLayout nVt;
    private TextView nVu;
    private AppBrandNearbyShowcaseView nVv;
    private LinearLayout nVw;
    private LinearLayout nVx;
    private TextView nVy;
    private AppBrandNearbyShowcaseView nVz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandProfileUI() {
        AppMethodBeat.i(48738);
        AppMethodBeat.o(48738);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, int i2, int i3) {
        AppMethodBeat.i(227655);
        appBrandProfileUI.ex(i2, i3);
        AppMethodBeat.o(227655);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, int i2, long j2, z zVar) {
        AppMethodBeat.i(227658);
        appBrandProfileUI.a(i2, 1, j2, zVar);
        AppMethodBeat.o(227658);
    }

    static /* synthetic */ int u(AppBrandProfileUI appBrandProfileUI) {
        int i2 = appBrandProfileUI.nVh;
        appBrandProfileUI.nVh = i2 - 1;
        return i2;
    }

    static /* synthetic */ int v(AppBrandProfileUI appBrandProfileUI) {
        int i2 = appBrandProfileUI.nVh;
        appBrandProfileUI.nVh = i2 + 1;
        return i2;
    }

    static /* synthetic */ void w(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(227664);
        appBrandProfileUI.bXr();
        AppMethodBeat.o(227664);
    }

    static {
        AppMethodBeat.i(48769);
        AppMethodBeat.o(48769);
    }

    public static void a(Context context, String str, int i2, String str2, WxaExposedParams wxaExposedParams, Bundle bundle) {
        AppMethodBeat.i(48739);
        a(context, str, i2, str2, wxaExposedParams, bundle, null);
        AppMethodBeat.o(48739);
    }

    public static void a(Context context, String str, int i2, String str2, WxaExposedParams wxaExposedParams, Bundle bundle, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(48740);
        a(context, str, i2, str2, true, wxaExposedParams, bundle, activityStarterIpcDelegate, -1);
        AppMethodBeat.o(48740);
    }

    public static void a(Context context, String str, int i2, String str2, boolean z, WxaExposedParams wxaExposedParams, Bundle bundle, ActivityStarterIpcDelegate activityStarterIpcDelegate, int i3) {
        Context context2;
        AppMethodBeat.i(227647);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(227647);
            return;
        }
        if (context == null) {
            context2 = MMApplicationContext.getContext();
        } else {
            context2 = context;
        }
        Intent putExtra = new Intent(context2, AppBrandProfileUI.class).putExtra("key_username", str).putExtra("key_from_scene", i2).putExtra("key_scene_note", str2).putExtra("key_can_swipe_back", z).putExtra("key_scene_exposed_params", wxaExposedParams).putExtra("key_extra_bundle", bundle);
        if (wxaExposedParams != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("stat_scene", 6);
            bundle2.putString("stat_app_id", wxaExposedParams.appId);
            bundle2.putString("stat_url", wxaExposedParams.pageId);
            putExtra.putExtra("_stat_obj", bundle2);
        }
        putExtra.putExtra("KEY_DELEGATED_ACTIVITY_STARTER", activityStarterIpcDelegate);
        if (!(context2 instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (!(context2 instanceof Activity) || i3 < 0) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(227647);
            return;
        }
        ((Activity) context2).startActivityForResult(putExtra, i3);
        AppMethodBeat.o(227647);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(48741);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.mRa = stringExtra;
        if (Util.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.o(48741);
            return;
        }
        if (getIntent().getExtras() != null && !getIntent().getExtras().containsKey("key_extra_bundle")) {
            getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
        }
        getIntent().setExtrasClassLoader(getClassLoader());
        this.nVO = (WxaExposedParams) getIntent().getParcelableExtra("key_scene_exposed_params");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48704);
                AppBrandProfileUI.this.onBackPressed();
                AppMethodBeat.o(48704);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.wp, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48718);
                AppBrandProfileUI.a(AppBrandProfileUI.this);
                AppBrandProfileUI.a(AppBrandProfileUI.this, 27, 1);
                AppMethodBeat.o(48718);
                return true;
            }
        });
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getContext().getResources().getColor(R.color.f3045c));
        View inflate = LayoutInflater.from(this).inflate(R.layout.ev, (ViewGroup) this.mPH, true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        this.nVj = (ImageView) inflate.findViewById(R.id.gj3);
        this.nVk = (TextView) inflate.findViewById(R.id.gk0);
        this.nVl = (TextView) inflate.findViewById(R.id.giu);
        this.nVm = (TextView) inflate.findViewById(R.id.gko);
        this.nVn = (RatingBar) inflate.findViewById(R.id.gkl);
        this.nVo = (TextView) inflate.findViewById(R.id.gkn);
        this.nVp = (LinearLayout) inflate.findViewById(R.id.gkm);
        this.nVr = (LinearLayout) inflate.findViewById(R.id.gki);
        this.nVq = (RecyclerView) inflate.findViewById(R.id.gkj);
        this.nVq.setItemAnimator(new v());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        this.nVq.setLayoutManager(linearLayoutManager);
        this.nVq.a(new RecyclerView.h() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass22 */

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(227645);
                int aG = com.tencent.mm.cb.a.aG(AppBrandProfileUI.this, R.dimen.ra);
                int aG2 = com.tencent.mm.cb.a.aG(AppBrandProfileUI.this, R.dimen.r5);
                if (RecyclerView.bw(view) == 0) {
                    rect.left = aG;
                } else {
                    rect.left = 0;
                }
                rect.right = aG2;
                AppMethodBeat.o(227645);
            }
        });
        this.nVs = (LinearLayout) inflate.findViewById(R.id.gin);
        this.nVt = (LinearLayout) inflate.findViewById(R.id.gil);
        this.nVu = (TextView) inflate.findViewById(R.id.gip);
        this.nVv = (AppBrandNearbyShowcaseView) inflate.findViewById(R.id.giq);
        this.nVv.setIconGap(nUY);
        this.nVv.setIconSize(nUX + (nUZ * 2));
        cH(this.nVt);
        this.nVw = (LinearLayout) inflate.findViewById(R.id.gl4);
        this.nVx = (LinearLayout) inflate.findViewById(R.id.gl3);
        this.nVy = (TextView) inflate.findViewById(R.id.gl5);
        this.nVz = (AppBrandNearbyShowcaseView) inflate.findViewById(R.id.gl6);
        this.nVz.setIconGap(nUY);
        this.nVz.setIconSize(nUX + (nUZ * 2));
        cH(this.nVx);
        this.nVC = (FrameLayout) inflate.findViewById(R.id.gjd);
        this.nVD = (TextView) inflate.findViewById(R.id.gk1);
        this.nVE = (TextView) inflate.findViewById(R.id.gjh);
        this.nVG = (ImageView) inflate.findViewById(R.id.gja);
        this.nVI = (AppBrandNearbyShowcaseView) inflate.findViewById(R.id.gje);
        this.nVH = (LinearLayout) inflate.findViewById(R.id.gjb);
        this.nVF = (LinearLayout) inflate.findViewById(R.id.gji);
        this.nVA = (LinearLayout) inflate.findViewById(R.id.fkg);
        this.nVB = (TextView) inflate.findViewById(R.id.id9);
        this.nVA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(48724);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AppBrandProfileUI.this.nRv != null && !Util.isNullOrNil(AppBrandProfileUI.this.nRv.appId)) {
                    com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", w.Uq(AppBrandProfileUI.this.nRv.appId)).putExtra("forceHideShare", true));
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 16, 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(48724);
            }
        });
        this.nVJ = (TextView) inflate.findViewById(R.id.gib);
        this.nVK = inflate.findViewById(R.id.gic);
        this.nVL = (TextView) inflate.findViewById(R.id.gk6);
        View findViewById = inflate.findViewById(R.id.gj0);
        View findViewById2 = inflate.findViewById(R.id.gkk);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(48725);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandProfileUI.c(AppBrandProfileUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(48725);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass21 */

            public final void onClick(View view) {
                AppMethodBeat.i(227644);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandProfileUI.a(AppBrandProfileUI.this, view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227644);
            }
        });
        nVa = getContext().getResources().getColor(R.color.vl);
        if (this.nVQ == null) {
            this.nVQ = new com.tencent.mm.plugin.appbrand.ui.widget.a(nUX, nUZ, nVa);
        }
        iJ(true);
        bXq();
        AppMethodBeat.o(48741);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void dealContentView(View view) {
        AppMethodBeat.i(48742);
        super.dealContentView(view);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(2);
        scrollView.setBackgroundResource(R.color.kz);
        scrollView.setFillViewport(true);
        this.mPH = new LinearLayout(this);
        this.mPH.setOrientation(1);
        this.mPH.setFocusable(true);
        this.mPH.setFocusableInTouchMode(true);
        scrollView.addView(this.mPH, new FrameLayout.LayoutParams(-1, -1));
        ((FrameLayout) view).addView(scrollView);
        AppMethodBeat.o(48742);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(48743);
        super.onNewIntent(intent);
        setIntent(intent);
        if (!Util.isNullOrNil(this.mRa)) {
            y.bAj().remove(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.mRa = stringExtra;
        if (Util.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.o(48743);
            return;
        }
        iJ(true);
        bXq();
        AppMethodBeat.o(48743);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final boolean onSwipeBackFinish() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(48744);
        if (Build.VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            super.finish();
        }
        ex(6, 1);
        AppMethodBeat.o(48744);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean convertActivityFromTranslucent() {
        AppMethodBeat.i(227648);
        boolean booleanExtra = getIntent().getBooleanExtra("key_can_swipe_back", true);
        AppMethodBeat.o(227648);
        return booleanExtra;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(48745);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
        }
        z.a(this, new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ui.statusbar.b>() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass23 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(com.tencent.mm.ui.statusbar.b bVar) {
                AppMethodBeat.i(48728);
                bVar.setLayoutFrozen(false);
                Void r0 = QZL;
                AppMethodBeat.o(48728);
                return r0;
            }
        });
        AppMethodBeat.o(48745);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(48746);
        super.onPause();
        z.a(this, new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ui.statusbar.b>() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass24 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(com.tencent.mm.ui.statusbar.b bVar) {
                AppMethodBeat.i(48729);
                bVar.setLayoutFrozen(true);
                Void r0 = QZL;
                AppMethodBeat.o(48729);
                return r0;
            }
        });
        AppMethodBeat.o(48746);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(48747);
        super.onDestroy();
        y.bAj().remove(this);
        AppMethodBeat.o(48747);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(48748);
        if (mStorageEventData.eventId == 3 && (mStorageEventData.obj instanceof String) && !Util.isNullOrNil(this.mRa) && this.mRa.equals((String) mStorageEventData.obj)) {
            iJ(false);
        }
        AppMethodBeat.o(48748);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final void initActivityCloseAnimation() {
        AppMethodBeat.i(48749);
        if (this.nVP) {
            AppMethodBeat.o(48749);
            return;
        }
        super.initActivityCloseAnimation();
        AppMethodBeat.o(48749);
    }

    private void ex(int i2, int i3) {
        AppMethodBeat.i(48750);
        a(i2, i3, Util.nowSecond(), (z) null);
        AppMethodBeat.o(48750);
    }

    private void a(int i2, int i3, long j2, z zVar) {
        String str;
        int i4;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(227649);
        String str5 = this.nRv == null ? null : this.nRv.appId;
        if (Util.isNullOrNil(str5)) {
            Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
            AppMethodBeat.o(227649);
            return;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", 3);
        String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("key_scene_note"));
        int i5 = 0;
        WxaAttributes e2 = n.buC().e(str5, "appInfo", "brandIconURL", "nickname");
        if (e2 != null) {
            i5 = e2.bAn().serviceType;
        }
        int i6 = i5 + 1000;
        if (zVar == null) {
            str = "";
        } else {
            str = zVar.dCC;
        }
        if (zVar == null) {
            i4 = 0;
        } else {
            i4 = zVar.msM;
        }
        if (zVar == null) {
            str2 = "";
        } else {
            str2 = zVar.msN;
        }
        String nullAsNil2 = Util.nullAsNil(str2);
        if (zVar == null) {
            str3 = "";
        } else {
            str3 = zVar.msO;
        }
        String encode = URLEncoder.encode(Util.nullAsNil(str3));
        if (zVar == null) {
            str4 = "";
        } else {
            str4 = zVar.msP;
        }
        String encode2 = URLEncoder.encode(Util.nullAsNil(str4));
        Log.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s,shareActionId:%s, shareActionType:%d, shareTitle:%s, sharePath:%s, shareImgUrl:%s", 13919, str5, Integer.valueOf(intExtra), nullAsNil, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str, Integer.valueOf(i4), nullAsNil2, encode, encode2);
        h.INSTANCE.a(13919, str5, Integer.valueOf(intExtra), nullAsNil, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Integer.valueOf(i6), str, Integer.valueOf(i4), nullAsNil2, encode, encode2);
        this.nVM = intExtra;
        AppMethodBeat.o(227649);
    }

    private void iJ(final boolean z) {
        AppMethodBeat.i(48752);
        g.hio().a(this).h(new com.tencent.mm.vending.c.a<ae, Void>() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ ae call(Void r5) {
                AppMethodBeat.i(227631);
                ae Xr = y.Xr(AppBrandProfileUI.this.mRa);
                if (z) {
                    com.tencent.f.h.RTc.aY(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(227630);
                            aa.XE(AppBrandProfileUI.this.mRa);
                            AppMethodBeat.o(227630);
                        }
                    });
                }
                AppMethodBeat.o(227631);
                return Xr;
            }
        }).a(d.UI, new d.b<ae>() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.g.d.b
            public final /* synthetic */ void bz(ae aeVar) {
                AppMethodBeat.i(227629);
                AppBrandProfileUI.a(AppBrandProfileUI.this, aeVar);
                if (z && !AppBrandProfileUI.this.isFinishing() && !AppBrandProfileUI.this.isDestroyed()) {
                    y.bAj().add(AppBrandProfileUI.this);
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 1, 1);
                }
                AppMethodBeat.o(227629);
            }
        });
        AppMethodBeat.o(48752);
    }

    private void iK(boolean z) {
        AppMethodBeat.i(227650);
        this.nVU = z;
        bXp();
        AppMethodBeat.o(227650);
    }

    private void iL(boolean z) {
        AppMethodBeat.i(227651);
        this.nVV = z;
        bXp();
        AppMethodBeat.o(227651);
    }

    private void iM(boolean z) {
        AppMethodBeat.i(227652);
        this.nVT = z;
        bXp();
        AppMethodBeat.o(227652);
    }

    private void bXp() {
        AppMethodBeat.i(227653);
        MMHandlerThread.removeRunnable(this.nVZ);
        MMHandlerThread.postToMainThread(this.nVZ);
        AppMethodBeat.o(227653);
    }

    private void bXq() {
        AppMethodBeat.i(48753);
        if (!Util.isNullOrNil(this.mRa)) {
            Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
            bta bta = new bta();
            bta.username = this.mRa;
            d.a aVar = new d.a();
            aVar.funcId = 2921;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
            aVar.iLN = bta;
            aVar.iLO = new btb();
            IPCRunCgi.a(aVar.aXF(), new a(this));
        }
        AppMethodBeat.o(48753);
    }

    /* access modifiers changed from: package-private */
    public static class a implements IPCRunCgi.a {
        WeakReference<AppBrandProfileUI> nWl;

        public a(AppBrandProfileUI appBrandProfileUI) {
            AppMethodBeat.i(48732);
            this.nWl = new WeakReference<>(appBrandProfileUI);
            AppMethodBeat.o(48732);
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(48733);
            if (!(this.nWl == null || this.nWl.get() == null)) {
                if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof btb)) {
                    Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
                } else {
                    Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
                    final btb btb = (btb) dVar.iLL.iLR;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(48731);
                            if (!(a.this.nWl == null || a.this.nWl.get() == null)) {
                                AppBrandProfileUI.a(a.this.nWl.get(), btb);
                            }
                            AppMethodBeat.o(48731);
                        }
                    });
                    AppMethodBeat.o(48733);
                    return;
                }
            }
            AppMethodBeat.o(48733);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public final List<feh> nWp;

        public c(List<feh> list) {
            this.nWp = list;
        }

        public final int size() {
            AppMethodBeat.i(227646);
            if (this.nWp == null || this.nWp.isEmpty()) {
                AppMethodBeat.o(227646);
                return 0;
            }
            int i2 = 0;
            for (feh feh : this.nWp) {
                if (!(feh == null || feh.Nzy == null || feh.Nzy.isEmpty())) {
                    i2 = feh.Nzy.size() + i2;
                }
            }
            AppMethodBeat.o(227646);
            return i2;
        }
    }

    private void bXr() {
        AppMethodBeat.i(48754);
        if (this.nVi == null || this.nVi.size() <= 0) {
            this.nVC.setVisibility(0);
            this.nVD.setVisibility(0);
            this.nVF.setVisibility(8);
        } else {
            this.nVC.setVisibility(0);
            this.nVF.setVisibility(0);
            this.nVD.setVisibility(8);
            this.nVI.setIconGap(nVc);
            this.nVI.setIconSize(nVb);
            this.nVI.setIconLayerCount(Math.min(this.nVi.size(), 3));
            if (this.nVR == null) {
                this.nVR = new com.tencent.mm.plugin.appbrand.ui.b.a(nVd);
            }
            if (this.nVS == null) {
                this.nVS = new com.tencent.mm.plugin.appbrand.ui.b.a(nVe);
            }
            int i2 = 0;
            while (i2 < this.nVI.getChildCount()) {
                String str = this.nVi.size() > i2 ? this.nVi.get(i2).yPH : null;
                com.tencent.mm.modelappbrand.a.b.aXY().a(this.nVI.zK(i2), str, R.drawable.bca, (str == null || str.startsWith("http")) ? this.nVR : this.nVS);
                i2++;
            }
            if (this.nVh != 1) {
                this.nVE.setText(String.format(getString(R.string.pv), Integer.valueOf(this.nVh)));
            } else if (this.nVf) {
                this.nVE.setText(getString(R.string.pt));
            } else {
                this.nVE.setText(String.format(getString(R.string.pv), Integer.valueOf(this.nVh)));
            }
            if (this.nVf) {
                this.nVE.setCompoundDrawablesWithIntrinsicBounds(R.drawable.by2, 0, 0, 0);
            } else {
                this.nVE.setCompoundDrawablesWithIntrinsicBounds(R.drawable.by1, 0, 0, 0);
            }
            if (this.nVh > 3) {
                this.nVG.setVisibility(0);
                this.nVH.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass15 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(48721);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        AppBrandProfileUI.q(AppBrandProfileUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(48721);
                    }
                });
            } else {
                this.nVG.setVisibility(8);
                this.nVH.setOnClickListener(null);
            }
        }
        this.nVD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(48722);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandProfileUI.r(AppBrandProfileUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(48722);
            }
        });
        this.nVE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(227642);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandProfileUI.r(AppBrandProfileUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227642);
            }
        });
        AppMethodBeat.o(48754);
    }

    /* access modifiers changed from: package-private */
    public static class b implements IPCRunCgi.a {
        WeakReference<AppBrandProfileUI> nWl;

        public b(AppBrandProfileUI appBrandProfileUI) {
            AppMethodBeat.i(48736);
            this.nWl = new WeakReference<>(appBrandProfileUI);
            AppMethodBeat.o(48736);
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(48737);
            if (!(this.nWl == null || this.nWl.get() == null)) {
                if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof emp)) {
                    Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.b.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(48735);
                            if (!(b.this.nWl == null || b.this.nWl.get() == null)) {
                                AppBrandProfileUI appBrandProfileUI = b.this.nWl.get();
                                if (appBrandProfileUI.nVg) {
                                    Toast.makeText(appBrandProfileUI, (int) R.string.ps, 0).show();
                                    AppBrandProfileUI.a(appBrandProfileUI, 17, 2);
                                    AppMethodBeat.o(48735);
                                    return;
                                }
                                Toast.makeText(appBrandProfileUI, (int) R.string.pp, 0).show();
                                AppBrandProfileUI.a(appBrandProfileUI, 18, 2);
                            }
                            AppMethodBeat.o(48735);
                        }
                    });
                } else {
                    Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(48734);
                            if (!(b.this.nWl == null || b.this.nWl.get() == null)) {
                                AppBrandProfileUI appBrandProfileUI = b.this.nWl.get();
                                if (appBrandProfileUI.nVf) {
                                    appBrandProfileUI.nVi.removeFirst();
                                    AppBrandProfileUI.u(appBrandProfileUI);
                                } else {
                                    fdu fdu = new fdu();
                                    fdu.Nzp = true;
                                    fdu.yPH = com.tencent.mm.aj.c.Me(com.tencent.mm.model.z.aTY());
                                    fdu.nickname = com.tencent.mm.model.z.aUa();
                                    appBrandProfileUI.nVi.addFirst(fdu);
                                    AppBrandProfileUI.v(appBrandProfileUI);
                                }
                                appBrandProfileUI.nVf = !appBrandProfileUI.nVf;
                                AppBrandProfileUI.w(appBrandProfileUI);
                                if (appBrandProfileUI.nVg) {
                                    AppBrandProfileUI.a(appBrandProfileUI, 17, 1);
                                    AppMethodBeat.o(48734);
                                    return;
                                }
                                AppBrandProfileUI.a(appBrandProfileUI, 18, 1);
                            }
                            AppMethodBeat.o(48734);
                        }
                    });
                    AppMethodBeat.o(48737);
                    return;
                }
            }
            AppMethodBeat.o(48737);
        }
    }

    private static void g(View view, Runnable runnable) {
        AppMethodBeat.i(48755);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
        AppMethodBeat.o(48755);
    }

    private void cH(final View view) {
        AppMethodBeat.i(48756);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(227643);
                    view.setVisibility(8);
                    AppMethodBeat.o(227643);
                }
            }).start();
        }
        AppMethodBeat.o(48756);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(227654);
        super.onConfigurationChanged(configuration);
        bXp();
        AppMethodBeat.o(227654);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(48757);
        if (appBrandProfileUI.nVN == null || !appBrandProfileUI.nVN.isShowing()) {
            appBrandProfileUI.nVN = new e((Context) appBrandProfileUI, 1, false);
            appBrandProfileUI.nVN.HLX = new o.f() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(48705);
                    mVar.clear();
                    mVar.kV(3, ((ag) com.tencent.mm.kernel.g.af(ag.class)).bf(AppBrandProfileUI.this.mRa, 0) ? R.string.sh : R.string.sd);
                    mVar.kV(2, R.string.ix);
                    mVar.kV(4, R.string.pr);
                    AppMethodBeat.o(48705);
                }
            };
            appBrandProfileUI.nVN.HLY = new o.g() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass3 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(48706);
                    switch (menuItem.getItemId()) {
                        case 2:
                            Intent putExtra = new Intent(AppBrandProfileUI.this, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.this.mRa);
                            putExtra.putExtra("key_app_authorize_profile", true);
                            com.tencent.mm.br.c.b(AppBrandProfileUI.this, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra);
                            AppBrandProfileUI.a(AppBrandProfileUI.this, 10, 1);
                            AppMethodBeat.o(48706);
                            return;
                        case 3:
                            boolean bf = ((ag) com.tencent.mm.kernel.g.af(ag.class)).bf(AppBrandProfileUI.this.mRa, 0);
                            if (bf || com.tencent.mm.plugin.appbrand.launching.f.b.bOn()) {
                                AppBrandProfileUI.a(AppBrandProfileUI.this, bf ? 12 : 11, com.tencent.mm.plugin.appbrand.ui.collection.d.a(bf, AppBrandProfileUI.this, AppBrandProfileUI.this.mRa, 0) ? 1 : 2);
                                AppMethodBeat.o(48706);
                                return;
                            }
                            ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(AppBrandProfileUI.this.getContext());
                            com.tencent.mm.plugin.appbrand.launching.f.a.aco(AppBrandProfileUI.this.mRa);
                            AppMethodBeat.o(48706);
                            return;
                        case 4:
                            AppBrandProfileUI.e(AppBrandProfileUI.this);
                            break;
                    }
                    AppMethodBeat.o(48706);
                }
            };
        }
        appBrandProfileUI.nVN.dGm();
        AppMethodBeat.o(48757);
    }

    static /* synthetic */ void c(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(227656);
        if (appBrandProfileUI.nRv != null) {
            Bundle bundleExtra = appBrandProfileUI.getIntent().getBundleExtra("_stat_obj");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1024;
            appBrandStatObject.ecU = com.tencent.mm.plugin.appbrand.report.m.k(appBrandStatObject.scene, bundleExtra);
            appBrandStatObject.ecV = com.tencent.mm.plugin.appbrand.report.m.l(appBrandStatObject.scene, bundleExtra);
            if (appBrandProfileUI.getIntent().getIntExtra("key_from_scene", 3) == 7) {
                appBrandStatObject.ecU = 14;
                appBrandStatObject.ecV = appBrandProfileUI.getIntent().getStringExtra("key_scene_note");
                Bundle bundleExtra2 = appBrandProfileUI.getIntent().getBundleExtra("key_extra_bundle");
                if (!(bundleExtra2 == null || bundleExtra2.getParcelable("key_recommend_stat_obj") == null)) {
                    AppBrandRecommendStatObj appBrandRecommendStatObj = (AppBrandRecommendStatObj) bundleExtra2.getParcelable("key_recommend_stat_obj");
                    Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "recommendStatObj is got!");
                    if (appBrandRecommendStatObj != null) {
                        i.b(2, 0, 0, appBrandRecommendStatObj);
                    }
                }
            }
            LaunchParcel launchParcel = new LaunchParcel();
            launchParcel.username = appBrandProfileUI.nRv.username;
            launchParcel.iOo = 0;
            launchParcel.mYK = appBrandStatObject;
            launchParcel.mQC = (ActivityStarterIpcDelegate) appBrandProfileUI.getIntent().getParcelableExtra("KEY_DELEGATED_ACTIVITY_STARTER");
            f.mZp.a(appBrandProfileUI, launchParcel);
            appBrandProfileUI.ex(4, 1);
            if (appBrandStatObject.ecU == 6) {
                appBrandProfileUI.nVP = true;
                appBrandProfileUI.finish();
            }
        }
        AppMethodBeat.o(227656);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, final View view) {
        AppMethodBeat.i(227657);
        final ae Xr = y.Xr(appBrandProfileUI.mRa);
        if (Xr == null) {
            Log.w("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "shareApp, attrs is null");
            AppMethodBeat.o(227657);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("desc", "");
        hashMap.put("type", 1);
        hashMap.put("title", Xr.nickname);
        hashMap.put("img_url", Xr.dMf);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 3);
        intent.putExtra("appbrand_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        com.tencent.mm.br.c.a((MMActivity) view.getContext(), ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass25 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                int i4;
                AppMethodBeat.i(48730);
                if (i2 != 1) {
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 8, 2);
                } else if (i3 == -1) {
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
                        AppMethodBeat.o(48730);
                        return;
                    }
                    Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "result success toUser : %s ", stringExtra);
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    String str = Xr.appId;
                    ad.aVe().G(ad.JX("wxapp_".concat(String.valueOf(str))), true).l("prePublishId", "wxapp_".concat(String.valueOf(str)));
                    int i5 = 0;
                    k.b bVar = new k.b();
                    bVar.title = Xr.nickname;
                    bVar.type = 33;
                    bVar.izi = AppBrandProfileUI.this.mRa;
                    bVar.izj = str;
                    bVar.izk = 1;
                    bVar.eam = "wxapp_".concat(String.valueOf(str));
                    bVar.thumburl = Xr.dMf;
                    bVar.url = w.Ur(str);
                    bVar.eag = AppBrandProfileUI.this.mRa;
                    bVar.eah = Xr.nickname;
                    com.tencent.mm.ag.a aVar = new com.tencent.mm.ag.a();
                    aVar.ivc = Xr.leb;
                    bVar.a(aVar);
                    for (String str2 : Util.stringsToList(stringExtra.split(","))) {
                        int i6 = i5 + 1;
                        bVar.izn = com.tencent.mm.plugin.appbrand.jsapi.share.y.bN(str, i5).toString();
                        w.a.aSz().a(bVar, str, Xr.nickname, str2, null, null);
                        if (!Util.isNullOrNil(stringExtra2)) {
                            tw twVar = new tw();
                            twVar.eaq.dkV = str2;
                            twVar.eaq.content = stringExtra2;
                            twVar.eaq.type = ab.JG(str2);
                            twVar.eaq.flags = 0;
                            EventCenter.instance.publish(twVar);
                        }
                        if (str2.endsWith("@chatroom")) {
                            i4 = 9;
                        } else {
                            i4 = 8;
                        }
                        z zVar = new z();
                        zVar.dCC = bVar.izn;
                        zVar.msM = 0;
                        zVar.msN = bVar.title;
                        zVar.msP = bVar.thumburl;
                        AppBrandProfileUI.a(AppBrandProfileUI.this, i4, Util.nowSecond(), zVar);
                        i5 = i6;
                    }
                    com.tencent.mm.ui.base.h.cD(view.getContext(), view.getContext().getResources().getString(R.string.z0));
                    AppMethodBeat.o(48730);
                    return;
                }
                AppMethodBeat.o(48730);
            }
        });
        AppMethodBeat.o(227657);
    }

    static /* synthetic */ void e(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(227659);
        if (appBrandProfileUI.nVO == null) {
            Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "wxaExposedParams is null");
            AppMethodBeat.o(227659);
            return;
        }
        Intent intent = new Intent();
        String a2 = com.tencent.mm.plugin.appbrand.w.a(appBrandProfileUI.nVO);
        Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "feedbackUrl:%s, wxaExposedParams:%s", a2, appBrandProfileUI.nVO.toString());
        intent.putExtra("title", appBrandProfileUI.getContext().getString(R.string.pr));
        intent.putExtra("rawUrl", a2);
        intent.putExtra("forceHideShare", true);
        com.tencent.mm.br.c.b(appBrandProfileUI, "webview", ".ui.tools.WebViewUI", intent);
        appBrandProfileUI.ex(20, 1);
        AppMethodBeat.o(227659);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, final ae aeVar) {
        AppMethodBeat.i(227660);
        if (appBrandProfileUI.isFinishing() || appBrandProfileUI.activityHasDestroyed() || aeVar == null) {
            AppMethodBeat.o(227660);
            return;
        }
        if ((appBrandProfileUI.nRv == null || !Util.nullAsNil(appBrandProfileUI.nRv.dMf).equals(aeVar.dMf)) && appBrandProfileUI.nVj != null) {
            com.tencent.mm.modelappbrand.a.b.aXY().a(appBrandProfileUI.nVj, aeVar.dMf, com.tencent.mm.modelappbrand.a.a.aXX(), new com.tencent.mm.modelappbrand.a.g());
            appBrandProfileUI.nVj.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(48710);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    AppBrandProfileUI.a(AppBrandProfileUI.this, aeVar.dMf, aeVar.dMf, new String[]{aeVar.dMf});
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(48710);
                }
            });
        }
        if ((appBrandProfileUI.nRv == null || !Util.nullAsNil(appBrandProfileUI.nRv.nickname).equals(aeVar.nickname)) && appBrandProfileUI.nVk != null) {
            appBrandProfileUI.krY = aeVar.nickname;
            appBrandProfileUI.bXp();
        }
        if ((appBrandProfileUI.nRv == null || !Util.nullAsNil(appBrandProfileUI.nRv.signature).equals(aeVar.signature)) && appBrandProfileUI.nVl != null) {
            if (!Util.isNullOrNil(aeVar.signature)) {
                appBrandProfileUI.nVl.setText(aeVar.signature);
                appBrandProfileUI.nVl.setVisibility(0);
            } else {
                appBrandProfileUI.nVl.setText("");
                appBrandProfileUI.nVl.setVisibility(8);
            }
        }
        if (aeVar.cyo == 4) {
            if (appBrandProfileUI.nVL != null) {
                String string = appBrandProfileUI.getString(R.string.px);
                appBrandProfileUI.nVL.setVisibility(0);
                Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(string);
                newSpannable.setSpan(new ClickableSpan() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(48712);
                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                        gVar.username = "gh_32d0f14ab3c6@app";
                        gVar.scene = 1085;
                        ((r) com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), gVar);
                        AppBrandProfileUI.a(AppBrandProfileUI.this, 24, 1);
                        AppBrandProfileUI.bXs();
                        AppMethodBeat.o(48712);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(227632);
                        textPaint.setColor(AppBrandProfileUI.this.getResources().getColor(R.color.x0));
                        textPaint.setUnderlineText(false);
                        AppMethodBeat.o(227632);
                    }
                }, 0, string.length(), 33);
                appBrandProfileUI.nVL.setText(newSpannable);
                appBrandProfileUI.nVL.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (appBrandProfileUI.nRv == null || appBrandProfileUI.nRv.originalFlag != aeVar.originalFlag) {
                if (aeVar.originalFlag != 1 || appBrandProfileUI.nVJ == null) {
                    appBrandProfileUI.iM(false);
                    appBrandProfileUI.nVJ.setVisibility(8);
                    appBrandProfileUI.nVK.setVisibility(8);
                    appBrandProfileUI.nVL.setGravity(1);
                } else {
                    appBrandProfileUI.iM(true);
                    appBrandProfileUI.nVJ.setVisibility(0);
                    appBrandProfileUI.nVK.setVisibility(0);
                    appBrandProfileUI.nVJ.setMovementMethod(LinkMovementMethod.getInstance());
                    if (!Util.isNullOrNil(aeVar.ldJ)) {
                        appBrandProfileUI.nVW = aeVar.ldJ;
                        try {
                            final String cl = com.tencent.mm.plugin.appbrand.w.cl(appBrandProfileUI.nVW, "appid=" + appBrandProfileUI.nVO.appId);
                            String string2 = appBrandProfileUI.getString(R.string.pj);
                            Spannable newSpannable2 = Spannable.Factory.getInstance().newSpannable(string2);
                            newSpannable2.setSpan(new ClickableSpan() {
                                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass8 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(48713);
                                    if (!Util.isNullOrNil(cl)) {
                                        Intent intent = new Intent();
                                        intent.putExtra("rawUrl", cl);
                                        com.tencent.mm.br.c.b(AppBrandProfileUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    }
                                    AppBrandProfileUI.a(AppBrandProfileUI.this, 22, 1);
                                    AppMethodBeat.o(48713);
                                }

                                public final void updateDrawState(TextPaint textPaint) {
                                    AppMethodBeat.i(48714);
                                    textPaint.setColor(AppBrandProfileUI.this.getResources().getColor(R.color.x0));
                                    textPaint.setUnderlineText(false);
                                    AppMethodBeat.o(48714);
                                }
                            }, 0, string2.length(), 33);
                            appBrandProfileUI.nVJ.setText(newSpannable2);
                            appBrandProfileUI.nVJ.setMovementMethod(LinkMovementMethod.getInstance());
                        } catch (URISyntaxException e2) {
                            Log.printErrStackTrace("MicroMsg.AppBrand.Profile.AppBrandProfileUI", e2, "URISyntaxException with originalRedirectUrl %s", aeVar.ldJ);
                        }
                    }
                }
            }
        } else {
            appBrandProfileUI.iM(false);
            appBrandProfileUI.nVJ.setVisibility(8);
            appBrandProfileUI.nVK.setVisibility(8);
            appBrandProfileUI.nVL.setVisibility(8);
        }
        appBrandProfileUI.nRv = aeVar;
        if (!(appBrandProfileUI.nRv == null || appBrandProfileUI.nVO == null)) {
            appBrandProfileUI.nVO.appId = appBrandProfileUI.nRv.appId;
            appBrandProfileUI.nVO.username = appBrandProfileUI.nRv.username;
        }
        if (!com.tencent.luggage.sdk.config.e.hP(appBrandProfileUI.nRv.leb) || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_appbrand_profile_page, 0) != 1) {
            appBrandProfileUI.iK(false);
        } else {
            appBrandProfileUI.iK(true);
        }
        if (!com.tencent.luggage.sdk.config.e.hO(appBrandProfileUI.nRv.lec) || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_show_official_flag, 0) != 1) {
            appBrandProfileUI.iL(false);
            AppMethodBeat.o(227660);
            return;
        }
        appBrandProfileUI.iL(true);
        AppMethodBeat.o(227660);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, String str, String str2, String[] strArr) {
        AppMethodBeat.i(48763);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(48763);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", str2);
        intent.putExtra("thumbUrl", str);
        intent.putExtra("urlList", strArr);
        intent.putExtra("isFromWebView", false);
        intent.putExtra("shouldShowScanQrCodeMenu", false);
        com.tencent.mm.br.c.a((Context) appBrandProfileUI, "subapp", ".ui.gallery.GestureGalleryUI", intent, 65535 & appBrandProfileUI.hashCode(), false);
        appBrandProfileUI.ex(14, 1);
        AppMethodBeat.o(48763);
    }

    static /* synthetic */ void bXs() {
        AppMethodBeat.i(48764);
        h.INSTANCE.idkeyStat(1135, 0, 1, false);
        Log.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileIDkeyReport id:%d,key:%d", 1135, 0);
        AppMethodBeat.o(48764);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, btb btb) {
        feg feg;
        AppMethodBeat.i(227661);
        if (btb == null) {
            AppMethodBeat.o(227661);
            return;
        }
        fdd fdd = btb.LZE;
        if (fdd != null) {
            Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "refreshBasicInfo, score:%s", Double.valueOf(fdd.NyO));
            if (fdd.NyO > 0.0d) {
                appBrandProfileUI.nVo.setVisibility(8);
                appBrandProfileUI.nVp.setVisibility(0);
                appBrandProfileUI.nVm.setText(String.valueOf(fdd.NyO));
                appBrandProfileUI.nVn.setRating((float) fdd.NyO);
            } else if (fdd.NyO == 0.0d) {
                appBrandProfileUI.nVp.setVisibility(8);
                appBrandProfileUI.nVo.setVisibility(0);
            } else {
                appBrandProfileUI.nVp.setVisibility(8);
                appBrandProfileUI.nVo.setVisibility(8);
            }
        }
        fdv fdv = btb.LZF;
        appBrandProfileUI.nVf = false;
        appBrandProfileUI.nVh = 0;
        appBrandProfileUI.nVi.clear();
        if (!(fdv == null || fdv.Nzq == null)) {
            appBrandProfileUI.nVh = fdv.Nzr;
            appBrandProfileUI.nVi.addAll(fdv.Nzq);
            if (!fdv.Nzq.isEmpty()) {
                appBrandProfileUI.nVf = fdv.Nzq.getFirst().Nzp;
            }
        }
        appBrandProfileUI.bXr();
        final fef fef = btb.LZI;
        if (appBrandProfileUI.nVs != null) {
            if (fef == null || fef.Nzw == null || fef.Nzw.isEmpty()) {
                appBrandProfileUI.nVs.setVisibility(8);
            } else {
                appBrandProfileUI.nVs.setVisibility(0);
                appBrandProfileUI.nVv.setIconLayerCount(Math.min(fef.Nzw.size(), 3));
                if (appBrandProfileUI.nVQ == null) {
                    appBrandProfileUI.nVQ = new com.tencent.mm.plugin.appbrand.ui.widget.a(nUX, nUZ, nVa);
                }
                final boolean z = appBrandProfileUI.nVt.getVisibility() != 0;
                if (z) {
                    appBrandProfileUI.nVv.bZV();
                }
                for (int i2 = 0; i2 < appBrandProfileUI.nVv.getChildCount(); i2++) {
                    com.tencent.mm.modelappbrand.a.b.aXY().a(appBrandProfileUI.nVv.zK(i2), fef.Nzw.size() > i2 ? fef.Nzw.get(i2).qGB : null, com.tencent.mm.modelappbrand.a.a.aXX(), appBrandProfileUI.nVQ);
                }
                if (fef.Nzw.size() != 1) {
                    appBrandProfileUI.nVu.setVisibility(8);
                } else if (!Util.isNullOrNil(fef.Nzw.get(0).title)) {
                    appBrandProfileUI.nVu.setVisibility(0);
                    appBrandProfileUI.nVu.setText(fef.Nzw.get(0).title);
                } else {
                    appBrandProfileUI.nVu.setVisibility(8);
                }
                appBrandProfileUI.nVs.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass10 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(227638);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!fef.Nzw.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<fee> it = fef.Nzw.iterator();
                            while (it.hasNext()) {
                                fee next = it.next();
                                WxaAttributes.WxaEntryInfo wxaEntryInfo = new WxaAttributes.WxaEntryInfo();
                                wxaEntryInfo.username = next.username;
                                wxaEntryInfo.title = next.title;
                                wxaEntryInfo.lgO = next.desc;
                                wxaEntryInfo.iconUrl = next.qGB;
                                arrayList.add(wxaEntryInfo);
                            }
                            Intent intent = new Intent(AppBrandProfileUI.this.getContext(), WxaBindBizInfoUI.class);
                            intent.putExtra("register", fef.Nzv);
                            intent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList<>(arrayList));
                            AppCompatActivity context = AppBrandProfileUI.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppBrandProfileUI.a(AppBrandProfileUI.this, 3, 1);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(227638);
                    }
                });
                g(appBrandProfileUI.nVt, new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(227639);
                        if (z && AppBrandProfileUI.this.nVv != null) {
                            AppBrandProfileUI.this.nVv.bZW();
                        }
                        AppMethodBeat.o(227639);
                    }
                });
            }
        }
        if (btb.LZI != null && !TextUtils.isEmpty(btb.LZI.Nzv)) {
            final String str = btb.LZI.Nzv;
            final c cVar = new c(btb.LZM);
            if (appBrandProfileUI.nVw != null) {
                int size = cVar.size();
                if (1 >= size) {
                    appBrandProfileUI.nVw.setVisibility(8);
                } else {
                    appBrandProfileUI.nVw.setVisibility(0);
                    appBrandProfileUI.nVz.setIconLayerCount(Math.min(size, 3));
                    if (appBrandProfileUI.nVQ == null) {
                        appBrandProfileUI.nVQ = new com.tencent.mm.plugin.appbrand.ui.widget.a(nUX, nUZ, nVa);
                    }
                    final boolean z2 = appBrandProfileUI.nVx.getVisibility() != 0;
                    if (z2) {
                        appBrandProfileUI.nVz.bZV();
                    }
                    for (int i3 = 0; i3 < appBrandProfileUI.nVz.getChildCount(); i3++) {
                        if (i3 < cVar.size()) {
                            Iterator<feh> it = cVar.nWp.iterator();
                            int i4 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                feh next = it.next();
                                if (!(next == null || next.Nzy == null || next.Nzy.isEmpty())) {
                                    int i5 = i3 - i4;
                                    int size2 = next.Nzy.size();
                                    if (i5 < size2) {
                                        feg = next.Nzy.get(i5);
                                        break;
                                    }
                                    i4 += size2;
                                }
                            }
                        }
                        feg = null;
                        com.tencent.mm.modelappbrand.a.b.aXY().a(appBrandProfileUI.nVz.zK(i3), feg != null ? feg.qGB : null, com.tencent.mm.modelappbrand.a.a.aXX(), appBrandProfileUI.nVQ);
                    }
                    appBrandProfileUI.nVy.setVisibility(8);
                    appBrandProfileUI.nVw.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass13 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(227640);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                            for (feh feh : cVar.nWp) {
                                if (!(feh == null || feh.Nzy == null || feh.Nzy.isEmpty())) {
                                    arrayList.add(new WxaRegisterInfo(feh));
                                }
                            }
                            Intent intent = new Intent(AppBrandProfileUI.this.getContext(), WxaBindWxaInfoUI.class);
                            intent.putExtra("register", str);
                            intent.putParcelableArrayListExtra("wxa_register_info_list", arrayList);
                            AppCompatActivity context = AppBrandProfileUI.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppBrandProfileUI.a(AppBrandProfileUI.this, 23, 1);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(227640);
                        }
                    });
                    g(appBrandProfileUI.nVx, new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.AnonymousClass14 */

                        public final void run() {
                            AppMethodBeat.i(227641);
                            if (z2 && AppBrandProfileUI.this.nVz != null) {
                                AppBrandProfileUI.this.nVz.bZW();
                            }
                            AppMethodBeat.o(227641);
                        }
                    });
                }
            }
            appBrandProfileUI.nVB.setText(btb.LZI.Nzv);
        }
        if (!TextUtils.isEmpty(btb.LZL)) {
            appBrandProfileUI.nVX = btb.LZL;
            appBrandProfileUI.bXp();
        }
        if (!TextUtils.isEmpty(btb.LZK)) {
            appBrandProfileUI.nVY = btb.LZK;
            appBrandProfileUI.bXp();
        }
        AppMethodBeat.o(227661);
    }

    static /* synthetic */ void q(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(227662);
        if (appBrandProfileUI.nRv == null || Util.isNullOrNil(appBrandProfileUI.nRv.appId)) {
            Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "jumpToLikeWall, attrs is null or appid is null");
            AppMethodBeat.o(227662);
            return;
        }
        String format = String.format("pages/like/like.html?appid=%s", appBrandProfileUI.nRv.appId);
        Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "jumpToLikeWall, path:%s", format);
        AppCompatActivity context = appBrandProfileUI.getContext();
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1024;
        if ((context instanceof Activity) && context.getIntent() != null) {
            Bundle bundleExtra = context.getIntent().getBundleExtra("_stat_obj");
            appBrandStatObject.ecU = com.tencent.mm.plugin.appbrand.report.m.k(appBrandStatObject.scene, bundleExtra);
            appBrandStatObject.ecV = com.tencent.mm.plugin.appbrand.report.m.l(appBrandStatObject.scene, bundleExtra);
        }
        f.mZp.a(appBrandProfileUI, "gh_af145dc05189@app", "wxbfac0b7aca45dd68", format, 0, -1, appBrandStatObject, null, null);
        appBrandProfileUI.ex(19, 1);
        AppMethodBeat.o(227662);
    }

    static /* synthetic */ void r(AppBrandProfileUI appBrandProfileUI) {
        int i2 = 1;
        AppMethodBeat.i(227663);
        if (appBrandProfileUI.nRv == null || Util.isNullOrNil(appBrandProfileUI.nRv.username)) {
            AppMethodBeat.o(227663);
            return;
        }
        appBrandProfileUI.nVg = !appBrandProfileUI.nVf;
        emo emo = new emo();
        if (!appBrandProfileUI.nVg) {
            i2 = 2;
        }
        emo.NkL = i2;
        emo.username = appBrandProfileUI.nRv.username;
        d.a aVar = new d.a();
        aVar.funcId = 2521;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
        aVar.iLN = emo;
        aVar.iLO = new emp();
        IPCRunCgi.a(aVar.aXF(), new b(appBrandProfileUI));
        AppMethodBeat.o(227663);
    }
}
