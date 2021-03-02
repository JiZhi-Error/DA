package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.ce;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0014J\b\u0010!\u001a\u00020\u0018H\u0014J\u0012\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0014J,\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", ch.COL_USERNAME, "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderSelfQRCodeUI extends MMFinderUI implements i {
    private final String TAG = "Finder.FinderSelfQRCodeUI";
    private HashMap _$_findViewCache;
    private ImageView gyr;
    private TextView kib;
    private ProgressBar mEz;
    private View pWr;
    private final int tzX = TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND;
    private ImageView vMF;
    private TextView vMG;
    private ImageView vNU;
    private View vNV;
    private ImageView vNW;
    private final int vNX = TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND;
    private final int vNY = 100003;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252660);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252660);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252659);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252659);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void a(FinderSelfQRCodeUI finderSelfQRCodeUI, String str) {
        AppMethodBeat.i(167580);
        finderSelfQRCodeUI.avS(str);
        AppMethodBeat.o(167580);
    }

    public static final /* synthetic */ View c(FinderSelfQRCodeUI finderSelfQRCodeUI) {
        AppMethodBeat.i(167581);
        View view = finderSelfQRCodeUI.pWr;
        if (view == null) {
            p.btv("qrcodeContainer");
        }
        AppMethodBeat.o(167581);
        return view;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167575);
        super.onCreate(bundle);
        setMMTitle("");
        initView();
        setBackBtn(new g(this));
        AppMethodBeat.o(167575);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSelfQRCodeUI vNZ;

        g(FinderSelfQRCodeUI finderSelfQRCodeUI) {
            this.vNZ = finderSelfQRCodeUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167574);
            this.vNZ.finish();
            AppMethodBeat.o(167574);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        String str;
        AppMethodBeat.i(167576);
        View findViewById = findViewById(R.id.cka);
        p.g(findViewById, "findViewById(R.id.finder_avatar)");
        this.gyr = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.d0q);
        p.g(findViewById2, "findViewById(R.id.finder_nickname)");
        this.kib = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.w0);
        p.g(findViewById3, "findViewById(R.id.auth_icon)");
        this.vMF = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.w2);
        p.g(findViewById4, "findViewById(R.id.auth_job)");
        this.vMG = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.d2w);
        p.g(findViewById5, "findViewById(R.id.finder_qrcode)");
        this.vNU = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.go8);
        p.g(findViewById6, "findViewById(R.id.qrcode_container)");
        this.pWr = findViewById6;
        View findViewById7 = findViewById(R.id.epr);
        p.g(findViewById7, "findViewById(R.id.loading_progress_bar)");
        this.mEz = (ProgressBar) findViewById7;
        View findViewById8 = findViewById(R.id.d2z);
        p.g(findViewById8, "findViewById(R.id.finder_refresh_qrcode)");
        this.vNV = findViewById8;
        View findViewById9 = findViewById(R.id.d30);
        p.g(findViewById9, "findViewById(R.id.finder_refresh_qrcode_icon)");
        this.vNW = (ImageView) findViewById9;
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
        if (asG != null) {
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> dka = m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(asG.cXH());
            ImageView imageView = this.gyr;
            if (imageView == null) {
                p.btv("avatarIv");
            }
            m mVar2 = m.uJa;
            dka.a(aVar2, imageView, m.a(m.a.AVATAR));
            TextView textView = this.kib;
            if (textView == null) {
                p.btv("nickTv");
            }
            textView.setText(asG.getNickname());
            FinderAuthInfo finderAuthInfo = asG.field_authInfo;
            int i2 = finderAuthInfo != null ? finderAuthInfo.authIconType : 0;
            TextView textView2 = this.vMG;
            if (textView2 == null) {
                p.btv("authJob");
            }
            textView2.setVisibility(8);
            y yVar = y.vXH;
            ImageView imageView2 = this.vMF;
            if (imageView2 == null) {
                p.btv("authIcon");
            }
            y.a(imageView2, asG.field_authInfo);
            if (i2 > 0) {
                switch (i2) {
                    case 1:
                        ImageView imageView3 = this.vMF;
                        if (imageView3 == null) {
                            p.btv("authIcon");
                        }
                        imageView3.setVisibility(0);
                        TextView textView3 = this.vMG;
                        if (textView3 == null) {
                            p.btv("authJob");
                        }
                        textView3.setVisibility(0);
                        TextView textView4 = this.vMG;
                        if (textView4 == null) {
                            p.btv("authJob");
                        }
                        FinderAuthInfo finderAuthInfo2 = asG.field_authInfo;
                        textView4.setText((finderAuthInfo2 == null || (str = finderAuthInfo2.authProfession) == null) ? "" : str);
                        break;
                    case 100:
                        TextView textView5 = this.vMG;
                        if (textView5 == null) {
                            p.btv("authJob");
                        }
                        textView5.setVisibility(8);
                        break;
                }
            } else {
                TextView textView6 = this.vMG;
                if (textView6 == null) {
                    p.btv("authJob");
                }
                textView6.setVisibility(8);
            }
            com.tencent.mm.kernel.g.azz().a(CdnLogic.kAppTypeFestivalVideo, this);
            avS(asG.getUsername());
            ImageView imageView4 = this.vNW;
            if (imageView4 == null) {
                p.btv("refreshIcon");
            }
            imageView4.setOnClickListener(new b(this, asG));
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this, 1, false);
            eVar.a(new c(this, asG));
            eVar.a(new d(this, asG));
            eVar.b(e.vOb);
            addIconOptionMenu(this.vNX, R.drawable.bw_, new f(eVar));
            AppMethodBeat.o(167576);
            return;
        }
        AppMethodBeat.o(167576);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$1"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FinderSelfQRCodeUI vNZ;
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g vOa;

        b(FinderSelfQRCodeUI finderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g gVar) {
            this.vNZ = finderSelfQRCodeUI;
            this.vOa = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167569);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderSelfQRCodeUI.a(this.vNZ, this.vOa.getUsername());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167569);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$2"})
    public static final class c implements o.f {
        final /* synthetic */ FinderSelfQRCodeUI vNZ;
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g vOa;

        c(FinderSelfQRCodeUI finderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g gVar) {
            this.vNZ = finderSelfQRCodeUI;
            this.vOa = gVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(167570);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(this.vNZ.tzX, R.string.d79);
                mVar.kV(this.vNZ.vNY, R.string.d8_);
            }
            AppMethodBeat.o(167570);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$3"})
    public static final class d implements o.g {
        final /* synthetic */ FinderSelfQRCodeUI vNZ;
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g vOa;

        d(FinderSelfQRCodeUI finderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g gVar) {
            this.vNZ = finderSelfQRCodeUI;
            this.vOa = gVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            Bitmap bitmapFromView;
            AppMethodBeat.i(167571);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == this.vNZ.tzX) {
                s.a.a(s.vWt, this.vNZ, this.vOa);
                AppMethodBeat.o(167571);
                return;
            }
            if (itemId == this.vNZ.vNY && (bitmapFromView = BitmapUtil.getBitmapFromView(FinderSelfQRCodeUI.c(this.vNZ))) != null) {
                al alVar = al.waC;
                String dED = al.dED();
                BitmapUtil.saveBitmapToImage(bitmapFromView, 80, Bitmap.CompressFormat.JPEG, dED, true);
                FinderSelfQRCodeUI.b(this.vNZ, dED);
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1278, 7, 1, false);
                k kVar = k.vfA;
                String aUg = z.aUg();
                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                k.auK(aUg);
            }
            AppMethodBeat.o(167571);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class e implements e.b {
        public static final e vOb = new e();

        static {
            AppMethodBeat.i(167572);
            AppMethodBeat.o(167572);
        }

        e() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class f implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ com.tencent.mm.ui.widget.a.e nkZ;

        f(com.tencent.mm.ui.widget.a.e eVar) {
            this.nkZ = eVar;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167573);
            this.nkZ.dGm();
            AppMethodBeat.o(167573);
            return true;
        }
    }

    private final void avS(String str) {
        AppMethodBeat.i(167577);
        ProgressBar progressBar = this.mEz;
        if (progressBar == null) {
            p.btv("loading");
        }
        progressBar.setVisibility(0);
        View view = this.vNV;
        if (view == null) {
            p.btv("refreshArea");
        }
        view.setVisibility(8);
        com.tencent.mm.kernel.g.azz().b(new ce(str));
        AppMethodBeat.o(167577);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
    public static final class a implements p.a {
        final /* synthetic */ FinderSelfQRCodeUI vNZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderSelfQRCodeUI finderSelfQRCodeUI) {
            this.vNZ = finderSelfQRCodeUI;
        }

        @Override // com.tencent.mm.platformtools.p.a
        public final void bP(String str, String str2) {
            AppMethodBeat.i(252657);
            kotlin.g.b.p.h(str, "srcPath");
            kotlin.g.b.p.h(str2, "destPath");
            Toast.makeText(this.vNZ, this.vNZ.getString(R.string.e2z, new Object[]{str2}), 1).show();
            AppMethodBeat.o(252657);
        }

        @Override // com.tencent.mm.platformtools.p.a
        public final void bQ(String str, String str2) {
            AppMethodBeat.i(252658);
            kotlin.g.b.p.h(str, "srcPath");
            kotlin.g.b.p.h(str2, "destPath");
            Toast.makeText(this.vNZ, this.vNZ.getString(R.string.gao), 1).show();
            AppMethodBeat.o(252658);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajt;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167578);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(CdnLogic.kAppTypeFestivalVideo, this);
        AppMethodBeat.o(167578);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        byte[] bArr;
        Bitmap bitmap;
        AppMethodBeat.i(167579);
        Log.i(this.TAG, "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        ProgressBar progressBar = this.mEz;
        if (progressBar == null) {
            kotlin.g.b.p.btv("loading");
        }
        progressBar.setVisibility(8);
        if (i2 != 0 || i3 != 0) {
            View view = this.vNV;
            if (view == null) {
                kotlin.g.b.p.btv("refreshArea");
            }
            view.setVisibility(0);
            if (Util.isNullOrNil(str)) {
                str2 = getString(R.string.eka);
            } else {
                str2 = str;
            }
            u.makeText(this, str2, 1).show();
            AppMethodBeat.o(167579);
        } else if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderQRCode");
            AppMethodBeat.o(167579);
            throw tVar;
        } else {
            com.tencent.mm.ak.d dVar = ((ce) qVar).tvD;
            com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
            if (aYK == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
                AppMethodBeat.o(167579);
                throw tVar2;
            }
            com.tencent.mm.bw.b bVar = ((baz) aYK).LKD;
            if (bVar != null) {
                bArr = bVar.zy;
            } else {
                bArr = null;
            }
            Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
            Log.i(this.TAG, "qrcode url " + ((ce) qVar).cZd());
            if (decodeByteArray == null) {
                if (!Util.isNullOrNil(((ce) qVar).cZd())) {
                    String cZd = ((ce) qVar).cZd();
                    if (cZd == null) {
                        kotlin.g.b.p.hyc();
                    }
                    Bitmap Mc = com.tencent.mm.aj.c.Mc(z.aUg());
                    kotlin.g.b.p.g(Mc, "avatarBitmap");
                    Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(Mc, false, 0.5f * ((float) Mc.getWidth()));
                    kotlin.g.b.p.g(roundedCornerBitmap, "tempBitmap");
                    float aH = (((float) at.aH(this, R.dimen.cp)) * 1.0f) / ((float) roundedCornerBitmap.getWidth());
                    bitmap = com.tencent.mm.by.a.a.b(this, BitmapUtil.createLayerBitmap(BitmapUtil.rotateAndScale(roundedCornerBitmap, 0.0f, aH, aH), BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.drawable.a3l)), true), cZd);
                } else {
                    bitmap = decodeByteArray;
                }
                x xVar = x.SXb;
            } else {
                bitmap = decodeByteArray;
            }
            if (bitmap != null) {
                ImageView imageView = this.vNU;
                if (imageView == null) {
                    kotlin.g.b.p.btv("qrcode");
                }
                imageView.setImageBitmap(bitmap);
                AppMethodBeat.o(167579);
                return;
            }
            AppMethodBeat.o(167579);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 10;
    }

    public static final /* synthetic */ void b(FinderSelfQRCodeUI finderSelfQRCodeUI, String str) {
        AppMethodBeat.i(167582);
        com.tencent.mm.platformtools.p.a(finderSelfQRCodeUI, str, new a(finderSelfQRCodeUI));
        AppMethodBeat.o(167582);
    }
}
