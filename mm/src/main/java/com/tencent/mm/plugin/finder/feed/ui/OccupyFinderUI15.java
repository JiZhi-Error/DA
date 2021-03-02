package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.da;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashMap;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0004H\u0014J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\"\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0012\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020#H\u0014J\b\u00104\u001a\u00020#H\u0014J\b\u00105\u001a\u00020#H\u0002J\u0012\u00106\u001a\u00020#2\b\u00107\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u0017H\u0002J&\u0010:\u001a\u00020#2\b\u0010;\u001a\u0004\u0018\u00010\u00072\b\u0010<\u001a\u0004\u0018\u00010\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "TAG", "", "getTAG", "()Ljava/lang/String;", "avatarChoose", "Landroid/widget/ImageView;", "avatarGroup", "Landroid/view/View;", "avatarIv", "avatarPath", "avatarUrl", "confirmBtn", "Landroid/widget/Button;", "confirmBtnBottomMargin", "curAvatarUrl", "curNickname", "filterMyAvatarUrl", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "maxNickNameLength", "mySelfAvatarUrl", "nickNameStr", "nicknameClear", "nicknameEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "sourceType", "splitLine3", "adjustConfirmBtn", "", "show", "height", "continuePost", "getLayoutId", "initConfigValue", "initConfirmBtnConfig", "initLayout", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "parseIntent", "setAvatar", "path", "setConfirmBtnStatus", "enable", "showAlertDialog", "title", "content", "buttonTitle", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI15 extends MMFinderUI {
    private static final String UIZ = UIZ;
    private static final String UJa = UJa;
    private static final String UJb = UJb;
    public static final a UJc = new a((byte) 0);
    final String TAG = "FinderLiveCreateVisitorModeUI";
    private View UIN;
    private ImageView UIO;
    private MMEditText UIP;
    private ImageView UIQ;
    private View UIR;
    private boolean UIS = true;
    private String UIT;
    private String UIU;
    private String UIV;
    private String UIW;
    private int UIX = 28;
    private int UIY;
    private HashMap _$_findViewCache;
    private com.tencent.mm.ui.tools.h gyh;
    private ImageView gyr;
    private String kog;
    private Button nZi;
    private int sourceType;
    private String tjJ;
    private final int vIw = 1000;
    private final int vIx = 1001;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(260297);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(260297);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(260296);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(260296);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void a(OccupyFinderUI15 occupyFinderUI15, boolean z) {
        AppMethodBeat.i(260293);
        occupyFinderUI15.Ft(z);
        AppMethodBeat.o(260293);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$Companion;", "", "()V", "FILTER_SUFFIX", "", "getFILTER_SUFFIX", "()Ljava/lang/String;", OccupyFinderUI15.UJa, "getKEY_ALIAS_VISITOR_AVATAR", OccupyFinderUI15.UIZ, "getKEY_ALIAS_VISITOR_NICKNAME", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260291);
        AppMethodBeat.o(260291);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        int i2;
        String str2;
        int i3;
        boolean z = true;
        int i4 = 0;
        AppMethodBeat.i(260286);
        super.onCreate(bundle);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.hUY().value().intValue();
        if (intValue > 0 && intValue < Integer.MAX_VALUE) {
            this.UIX = intValue;
        }
        setBackBtn(new g(this), R.raw.icons_filled_back);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.UIS = com.tencent.mm.plugin.finder.storage.c.hUZ().value().intValue() == 0;
        Log.i(this.TAG, "initConfigValue filterMyAvatarUrl:" + this.UIS);
        Intent intent = getIntent();
        this.UIU = intent != null ? intent.getStringExtra(UIZ) : null;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra(UJa);
        } else {
            str = null;
        }
        this.UIT = str;
        Intent intent3 = getIntent();
        if (intent3 != null) {
            i2 = intent3.getIntExtra("KEY_SOURCE", 0);
        } else {
            i2 = 0;
        }
        this.sourceType = i2;
        this.UIN = findViewById(R.id.jtc);
        this.gyr = (ImageView) findViewById(R.id.x1);
        this.UIO = (ImageView) findViewById(R.id.k37);
        this.UIP = (MMEditText) findViewById(R.id.k17);
        MMEditText mMEditText = this.UIP;
        if (mMEditText != null) {
            String str3 = this.UIU;
            mMEditText.setText(str3 != null ? str3 : "");
        }
        this.UIQ = (ImageView) findViewById(R.id.k15);
        ImageView imageView = this.UIQ;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        this.nZi = (Button) findViewById(R.id.b_4);
        com.tencent.mm.aj.i Mx = p.aYB().Mx(z.aTY());
        kotlin.g.b.p.g(Mx, "SubCoreAvatar.getImgFlag…etUsernameFromUserInfo())");
        this.UIV = Mx.aYu();
        String str4 = this.UIT;
        if (!(str4 == null || str4.length() == 0)) {
            z = false;
        }
        if (z) {
            str2 = this.UIV;
        } else {
            str2 = this.UIT;
        }
        this.kog = str2;
        ImageView imageView2 = this.gyr;
        if (imageView2 != null) {
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> dkb = m.dkb();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(this.kog);
            m mVar2 = m.uJa;
            dkb.a(aVar, imageView2, m.a(m.a.WX_AVATAR));
        }
        View view = this.UIN;
        if (view != null) {
            view.setOnClickListener(new d(this));
        }
        int i5 = this.UIX / 2;
        if (i5 <= 0) {
            i3 = this.UIX;
        } else {
            i3 = i5;
        }
        com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(this.UIP, null, this.UIX, i3, new e(this));
        this.UIR = findViewById(R.id.k2l);
        Ft(false);
        Button button = this.nZi;
        if (button != null) {
            button.setOnClickListener(new f(this));
        }
        Button button2 = this.nZi;
        ViewGroup.LayoutParams layoutParams = button2 != null ? button2.getLayoutParams() : null;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            i4 = marginLayoutParams.bottomMargin;
        }
        this.UIY = i4;
        if (this.UIY <= 0) {
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            this.UIY = context.getResources().getDimensionPixelOffset(R.dimen.cr);
        }
        switch (this.sourceType) {
            case 1:
                Button button3 = this.nZi;
                if (button3 != null) {
                    button3.setBackgroundResource(R.drawable.a16);
                    break;
                }
                break;
            default:
                Button button4 = this.nZi;
                if (button4 != null) {
                    button4.setBackgroundResource(R.drawable.cuo);
                    break;
                }
                break;
        }
        Log.i(this.TAG, "initConfirmBtnConfig:" + this.UIY + ", sourceType:" + this.sourceType);
        Log.i(this.TAG, "maxNickNameLength:" + this.UIX);
        AppMethodBeat.o(260286);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ OccupyFinderUI15 UJd;

        g(OccupyFinderUI15 occupyFinderUI15) {
            this.UJd = occupyFinderUI15;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(260282);
            this.UJd.hideVKB();
            this.UJd.finish();
            AppMethodBeat.o(260282);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        View decorView;
        AppMethodBeat.i(260287);
        super.onResume();
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            AppMethodBeat.o(260287);
            return;
        }
        decorView.post(new h(this));
        AppMethodBeat.o(260287);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ OccupyFinderUI15 UJd;

        h(OccupyFinderUI15 occupyFinderUI15) {
            this.UJd = occupyFinderUI15;
        }

        public final void run() {
            AppMethodBeat.i(260284);
            if (this.UJd.gyh == null) {
                this.UJd.gyh = new com.tencent.mm.ui.tools.h(this.UJd);
                com.tencent.mm.ui.tools.h hVar = this.UJd.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new com.tencent.mm.ui.tools.g(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15.h.AnonymousClass1 */
                        final /* synthetic */ h UJh;

                        {
                            this.UJh = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            AppMethodBeat.i(260283);
                            Log.i(this.UJh.UJd.TAG, "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            OccupyFinderUI15.a(this.UJh.UJd, i2 > 0, i2);
                            AppMethodBeat.o(260283);
                        }
                    });
                }
            }
            com.tencent.mm.ui.tools.h hVar2 = this.UJd.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(260284);
                return;
            }
            AppMethodBeat.o(260284);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(260288);
        super.onPause();
        com.tencent.mm.ui.tools.h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
            AppMethodBeat.o(260288);
            return;
        }
        AppMethodBeat.o(260288);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ OccupyFinderUI15 UJd;

        c(OccupyFinderUI15 occupyFinderUI15) {
            this.UJd = occupyFinderUI15;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260276);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$initLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MMEditText mMEditText = this.UJd.UIP;
            if (mMEditText != null) {
                mMEditText.setText("");
            }
            ImageView imageView = this.UJd.UIQ;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$initLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260276);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ OccupyFinderUI15 UJd;

        d(OccupyFinderUI15 occupyFinderUI15) {
            this.UJd = occupyFinderUI15;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260277);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$initLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            s.a((Activity) this.UJd, this.UJd.vIw, 1, 5, (Intent) null, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$initLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260277);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ OccupyFinderUI15 UJd;

        f(OccupyFinderUI15 occupyFinderUI15) {
            this.UJd = occupyFinderUI15;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260281);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$initLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            OccupyFinderUI15.a(this.UJd, false);
            String str = this.UJd.tjJ;
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
                com.tencent.mm.plugin.finder.upload.g gVar = com.tencent.mm.plugin.finder.upload.g.vSH;
                String aUg = z.aUg();
                kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                gVar.a(str, aUg, new com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15.f.AnonymousClass1 */
                    final /* synthetic */ f UJf;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.UJf = r1;
                    }

                    @Override // com.tencent.mm.loader.g.f
                    public final void a(com.tencent.mm.loader.g.c cVar, j jVar) {
                        AppMethodBeat.i(260280);
                        kotlin.g.b.p.h(cVar, "task");
                        kotlin.g.b.p.h(jVar, "status");
                        if (jVar != j.OK || Util.isNullOrNil(((com.tencent.mm.plugin.finder.upload.m) cVar).resultUrl)) {
                            Log.e(this.UJf.UJd.TAG, "upload avatar fail,status:".concat(String.valueOf(jVar)));
                            OccupyFinderUI15.a(this.UJf.UJd, true);
                            com.tencent.mm.ac.d.h(new a(this));
                            AppMethodBeat.o(260280);
                            return;
                        }
                        this.UJf.UJd.kog = ((com.tencent.mm.plugin.finder.upload.m) cVar).resultUrl;
                        OccupyFinderUI15.h(this.UJf.UJd);
                        AppMethodBeat.o(260280);
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                    /* renamed from: com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15$f$1$a */
                    static final class a extends q implements kotlin.g.a.a<x> {
                        final /* synthetic */ AnonymousClass1 UJg;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        a(AnonymousClass1 r2) {
                            super(0);
                            this.UJg = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(260279);
                            Context context = MMApplicationContext.getContext();
                            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                            u.makeText(this.UJg.UJf.UJd, context.getResources().getString(R.string.j_i), 0).show();
                            x xVar = x.SXb;
                            AppMethodBeat.o(260279);
                            return xVar;
                        }
                    }
                });
            } else {
                OccupyFinderUI15.h(this.UJd);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$initLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260281);
        }
    }

    private final void Ft(boolean z) {
        AppMethodBeat.i(260289);
        Button button = this.nZi;
        if (button != null) {
            button.setEnabled(z);
        }
        if (z) {
            if (ao.isDarkMode()) {
                Button button2 = this.nZi;
                if (button2 != null) {
                    AppCompatActivity context = getContext();
                    kotlin.g.b.p.g(context, "context");
                    button2.setTextColor(context.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    AppMethodBeat.o(260289);
                    return;
                }
                AppMethodBeat.o(260289);
                return;
            }
            Button button3 = this.nZi;
            if (button3 != null) {
                AppCompatActivity context2 = getContext();
                kotlin.g.b.p.g(context2, "context");
                button3.setTextColor(context2.getResources().getColor(R.color.am));
                AppMethodBeat.o(260289);
                return;
            }
            AppMethodBeat.o(260289);
        } else if (ao.isDarkMode()) {
            Button button4 = this.nZi;
            if (button4 != null) {
                AppCompatActivity context3 = getContext();
                kotlin.g.b.p.g(context3, "context");
                button4.setTextColor(context3.getResources().getColor(R.color.BW_100_Alpha_0_2));
                AppMethodBeat.o(260289);
                return;
            }
            AppMethodBeat.o(260289);
        } else {
            Button button5 = this.nZi;
            if (button5 != null) {
                AppCompatActivity context4 = getContext();
                kotlin.g.b.p.g(context4, "context");
                button5.setTextColor(context4.getResources().getColor(R.color.BW_0_Alpha_0_2));
                AppMethodBeat.o(260289);
                return;
            }
            AppMethodBeat.o(260289);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class i implements f.c {
        final /* synthetic */ OccupyFinderUI15 UJd;

        i(OccupyFinderUI15 occupyFinderUI15) {
            this.UJd = occupyFinderUI15;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(260285);
            Log.i(this.UJd.TAG, "showAlertDialog click bOk:".concat(String.valueOf(z)));
            AppMethodBeat.o(260285);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$continuePost$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "plugin-finder_release"})
    public static final class b implements da.a {
        final /* synthetic */ OccupyFinderUI15 UJd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(OccupyFinderUI15 occupyFinderUI15) {
            this.UJd = occupyFinderUI15;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.da.a
        public final void a(fhc fhc) {
            AppMethodBeat.i(260274);
            kotlin.g.b.p.h(fhc, "resp");
            Log.i(this.UJd.TAG, "save alias nickName:" + this.UJd.UIW + ",avatar:" + this.UJd.kog);
            OccupyFinderUI15 occupyFinderUI15 = this.UJd;
            Intent intent = new Intent();
            a aVar = OccupyFinderUI15.UJc;
            intent.putExtra(OccupyFinderUI15.UIZ, this.UJd.UIW);
            a aVar2 = OccupyFinderUI15.UJc;
            intent.putExtra(OccupyFinderUI15.UJa, this.UJd.kog);
            occupyFinderUI15.setResult(-1, intent);
            com.tencent.mm.ac.d.h(new C1169b(this));
            this.UJd.finish();
            AppMethodBeat.o(260274);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.da.a
        public final void cZ(int i2, String str) {
            AppMethodBeat.i(260275);
            com.tencent.mm.ac.d.h(new a(this, i2, str));
            AppMethodBeat.o(260275);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15$b$b  reason: collision with other inner class name */
        static final class C1169b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b UJe;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1169b(b bVar) {
                super(0);
                this.UJe = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(260273);
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.bD(this.UJe.UJd);
                x xVar = x.SXb;
                AppMethodBeat.o(260273);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ b UJe;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, int i2, String str) {
                super(0);
                this.UJe = bVar;
                this.$errCode = i2;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(260272);
                OccupyFinderUI15.a(this.UJe.UJd, true);
                if (this.$errCode == -200066) {
                    String str = this.$errMsg;
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        Context context = MMApplicationContext.getContext();
                        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                        str = context.getResources().getString(R.string.j_i);
                    }
                    OccupyFinderUI15.a(this.UJe.UJd, "", str, "");
                } else {
                    Context context2 = MMApplicationContext.getContext();
                    kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                    u.makeText(this.UJe.UJd, context2.getResources().getString(R.string.j_i), 0).show();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260272);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cew;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        Bitmap extractThumbNail;
        AppMethodBeat.i(260290);
        if (i2 == this.vIw) {
            if (intent != null && i3 == -1) {
                setIntent(new Intent());
                getIntent().putExtra("key_source_img_path", com.tencent.mm.ui.tools.a.i(getContext(), intent, com.tencent.mm.plugin.image.d.aSY()));
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.b((Activity) this, getIntent(), this.vIx);
                AppMethodBeat.o(260290);
                return;
            }
        } else if (i2 == this.vIx && intent != null && i3 == -1) {
            this.tjJ = intent.getStringExtra("key_result_img_path");
            Log.i(this.TAG, "avatar path %s file length %d KB", this.tjJ, Long.valueOf(com.tencent.mm.vfs.s.boW(this.tjJ) / 1024));
            String str = this.tjJ;
            if (!Util.isNullOrNil(str) && (extractThumbNail = BitmapUtil.extractThumbNail(str, 256, 256, false)) != null) {
                ImageView imageView = this.gyr;
                if (imageView != null) {
                    imageView.setImageBitmap(extractThumbNail);
                    AppMethodBeat.o(260290);
                    return;
                }
                AppMethodBeat.o(260290);
                return;
            }
        }
        AppMethodBeat.o(260290);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI15 UJd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(OccupyFinderUI15 occupyFinderUI15) {
            super(0);
            this.UJd = occupyFinderUI15;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            Editable text;
            AppMethodBeat.i(260278);
            OccupyFinderUI15 occupyFinderUI15 = this.UJd;
            MMEditText mMEditText = this.UJd.UIP;
            occupyFinderUI15.UIW = (mMEditText == null || (text = mMEditText.getText()) == null) ? null : text.toString();
            String str = this.UJd.UIW;
            if (str != null) {
                i2 = str.length();
            } else {
                i2 = 0;
            }
            boolean z = i2 > 0;
            OccupyFinderUI15.a(this.UJd, z);
            if (z) {
                ImageView imageView = this.UJd.UIQ;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else {
                ImageView imageView2 = this.UJd.UIQ;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260278);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(OccupyFinderUI15 occupyFinderUI15, boolean z, int i2) {
        AppMethodBeat.i(260292);
        Button button = occupyFinderUI15.nZi;
        ViewGroup.LayoutParams layoutParams = button != null ? button.getLayoutParams() : null;
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.cr);
        if (layoutParams2 != null) {
            if (z) {
                int i3 = au.az(MMApplicationContext.getContext()).y;
                Button button2 = occupyFinderUI15.nZi;
                int height = button2 != null ? button2.getHeight() : 0;
                int[] iArr = new int[2];
                View view = occupyFinderUI15.UIR;
                if (view != null) {
                    view.getLocationOnScreen(iArr);
                }
                int i4 = iArr[1];
                View view2 = occupyFinderUI15.UIR;
                int height2 = view2 != null ? view2.getHeight() : 1;
                Log.i(occupyFinderUI15.TAG, "adjustConfirmBtn screenHeight:" + i3 + ",confirmBtnContainerH:" + height + ",descContainerY:" + i4 + ",itemHeight:" + height2 + ",height:" + i2);
                if (height == 0 || i4 == 0 || ((i3 - dimensionPixelOffset) - height) - (height2 + i4) <= i2) {
                    View view3 = occupyFinderUI15.UIR;
                    if (view3 != null) {
                        int id = view3.getId();
                        layoutParams2.removeRule(12);
                        layoutParams2.addRule(3, id);
                        layoutParams2.bottomMargin = 0;
                    }
                } else {
                    layoutParams2.removeRule(3);
                    layoutParams2.addRule(12);
                    layoutParams2.bottomMargin = i2;
                }
            } else {
                layoutParams2.removeRule(3);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = occupyFinderUI15.UIY;
            }
            Button button3 = occupyFinderUI15.nZi;
            ViewParent parent = button3 != null ? button3.getParent() : null;
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.updateViewLayout(occupyFinderUI15.nZi, layoutParams2);
                AppMethodBeat.o(260292);
                return;
            }
        }
        AppMethodBeat.o(260292);
    }

    public static final /* synthetic */ void h(OccupyFinderUI15 occupyFinderUI15) {
        boolean z;
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(260294);
        String str4 = occupyFinderUI15.UIW;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i(occupyFinderUI15.TAG, "continuePost nickNameStr:" + occupyFinderUI15.UIW + " is empty!");
            occupyFinderUI15.Ft(true);
            AppMethodBeat.o(260294);
            return;
        }
        String str5 = occupyFinderUI15.kog;
        String str6 = occupyFinderUI15.kog;
        if ((str6 == null || str6.length() == 0) || !kotlin.g.b.p.j(occupyFinderUI15.kog, occupyFinderUI15.UIV) || !occupyFinderUI15.UIS) {
            str = str5;
        } else {
            String str7 = occupyFinderUI15.kog;
            str = str7 != null ? n.c(str7, (CharSequence) UJb) : null;
        }
        String str8 = occupyFinderUI15.UIW;
        if (str8 == null) {
            str2 = "";
        } else {
            str2 = str8;
        }
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        new da(str2, str3, new b(occupyFinderUI15)).aYI();
        AppMethodBeat.o(260294);
    }

    public static final /* synthetic */ void a(OccupyFinderUI15 occupyFinderUI15, String str, String str2, String str3) {
        boolean z;
        AppMethodBeat.i(260295);
        f.a aVar = new f.a(occupyFinderUI15.getContext());
        if (str.length() == 0) {
            aVar.bow(str2);
        } else {
            aVar.aC(str).bow(str2);
        }
        aVar.hbu();
        AppCompatActivity context = occupyFinderUI15.getContext();
        kotlin.g.b.p.g(context, "context");
        String string = context.getResources().getString(R.string.cqo);
        kotlin.g.b.p.g(string, "context.resources.getStr…ive_alert_dialog_btn_txt)");
        if (str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str3 = string;
        }
        aVar.boA(str3);
        aVar.b(new i(occupyFinderUI15)).show();
        AppMethodBeat.o(260295);
    }
}
