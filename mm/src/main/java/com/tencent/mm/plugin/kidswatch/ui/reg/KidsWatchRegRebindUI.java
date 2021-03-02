package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0014J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J,\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", Scopes.OPEN_ID, "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "finish", "", "getForceOrientation", "", "getLayoutId", "goBackRegUI", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startExtReg", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegRebindUI extends MMActivity implements i {
    public static final a yBH = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String dSf;
    private String dZW;
    private q kdn;
    private String knu;
    private boolean kpI;
    private String nickName;
    private String openid;
    private String yBA;
    private String yBB;

    static {
        AppMethodBeat.i(256368);
        AppMethodBeat.o(256368);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256372);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256372);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256371);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256371);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256364);
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            p.hyc();
        }
        supportActionBar.hide();
        setSelfNavigationBarVisible(8);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        setActionbarColor(context.getResources().getColor(R.color.YellowK));
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        setNavigationbarColor(context2.getResources().getColor(R.color.YellowK));
        initView();
        overridePendingTransition(R.anim.dq, R.anim.s);
        AppMethodBeat.o(256364);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.axr;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256365);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(256365);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(256366);
        setMMTitle("");
        String string = getString(R.string.eaa);
        p.g(string, "getString(R.string.kids_…ogin_enter_loading_title)");
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setTitle(string);
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseBtnCallBack(new b(this));
        String stringExtra = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
        p.g(stringExtra, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_FILE_ID)");
        this.yBA = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
        p.g(stringExtra2, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_AES_KEY)");
        this.yBB = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("intent.key.login.url");
        p.g(stringExtra3, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
        this.dZW = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("intent.key.reg.mobile");
        p.g(stringExtra4, "intent.getStringExtra(Co…ch.INTENT_KEY_REG_MOBILE)");
        this.dSf = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra("intent.key.reg.nickname");
        p.g(stringExtra5, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
        this.nickName = stringExtra5;
        this.knu = getIntent().getStringExtra("intent.key.reg.session.id");
        this.kpI = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
        String stringExtra6 = getIntent().getStringExtra("intent.key.reg.last.nickname");
        String stringExtra7 = getIntent().getStringExtra("intent.key.reg.last.head.img.url");
        TextView textView = (TextView) _$_findCachedViewById(R.id.e7r);
        p.g(textView, "lastNicknameTV");
        textView.setText(Util.isNullOrNil(stringExtra6) ? "" : stringExtra6);
        if (!Util.isNullOrNil(stringExtra7)) {
            int fromDPToPix = at.fromDPToPix(getContext(), 16);
            c.a aVar = new c.a();
            aVar.ty(R.drawable.bca);
            aVar.aw((float) fromDPToPix).bdt();
            com.tencent.mm.av.q.bcV().a(stringExtra7, (RoundCornerImageView) _$_findCachedViewById(R.id.e7q), aVar.bdv());
        }
        StringBuilder sb = new StringBuilder("fileID:");
        String str = this.yBA;
        if (str == null) {
            p.btv("headImgFileID");
        }
        StringBuilder append = sb.append(str).append(", aeskey:");
        String str2 = this.yBB;
        if (str2 == null) {
            p.btv("headImgAesKey");
        }
        StringBuilder append2 = append.append(str2).append(", loginUrl:");
        String str3 = this.dZW;
        if (str3 == null) {
            p.btv("loginUrl");
        }
        StringBuilder append3 = append2.append(str3).append(", nickName:");
        String str4 = this.nickName;
        if (str4 == null) {
            p.btv("nickName");
        }
        Log.i("MicroMsg.KidsWatchRegRebindUI", append3.append(str4).append(", regSessionId:").append(this.knu).append(", hasSetAvatar:").append(this.kpI).append(", lastNickName:").append(stringExtra6).append(", lastImgUrl:").append(stringExtra7).toString());
        ((Button) _$_findCachedViewById(R.id.gts)).setOnClickListener(new c(this));
        ((Button) _$_findCachedViewById(R.id.aqt)).setOnClickListener(new d(this));
        com.tencent.mm.plugin.kidswatch.b.a aVar2 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.kidswatch.b.a.a(context, (LinearLayout) _$_findCachedViewById(R.id.ajo), (LinearLayout) _$_findCachedViewById(R.id.a_z));
        AppMethodBeat.o(256366);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ KidsWatchRegRebindUI yBI;

        c(KidsWatchRegRebindUI kidsWatchRegRebindUI) {
            this.yBI = kidsWatchRegRebindUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256361);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            KidsWatchRegRebindUI.a(this.yBI);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256361);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ KidsWatchRegRebindUI yBI;

        d(KidsWatchRegRebindUI kidsWatchRegRebindUI) {
            this.yBI = kidsWatchRegRebindUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256362);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            KidsWatchRegRebindUI.b(this.yBI);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256362);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class e implements DialogInterface.OnCancelListener {
        final /* synthetic */ com.tencent.mm.plugin.kidswatch.model.d yBG;
        final /* synthetic */ KidsWatchRegRebindUI yBI;

        e(KidsWatchRegRebindUI kidsWatchRegRebindUI, com.tencent.mm.plugin.kidswatch.model.d dVar) {
            this.yBI = kidsWatchRegRebindUI;
            this.yBG = dVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(256363);
            g.azz().a(this.yBG);
            g.azz().b(5888, this.yBI);
            AppMethodBeat.o(256363);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(256367);
        if (qVar instanceof com.tencent.mm.plugin.kidswatch.model.d) {
            Log.i("MicroMsg.KidsWatchRegRebindUI", "errType:" + i2 + ", errCode:" + i3 + ", errMsg:" + str);
            q qVar2 = this.kdn;
            if (qVar2 != null) {
                qVar2.dismiss();
            }
            g.azz().b(5888, this);
            if (i2 == 0 && i3 == 0) {
                String username = ((com.tencent.mm.plugin.kidswatch.model.d) qVar).getUsername();
                this.openid = ((com.tencent.mm.plugin.kidswatch.model.d) qVar).getOpenId();
                com.tencent.mm.plugin.kidswatch.model.c cVar = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                if (username == null) {
                    username = "";
                }
                com.tencent.mm.plugin.kidswatch.model.c.a(username, c.d.REG_RESULT_SUCCESS, 0);
                StringBuilder sb = new StringBuilder("gotoRegSuccessUI, nickName:");
                String str2 = this.nickName;
                if (str2 == null) {
                    p.btv("nickName");
                }
                Log.i("MicroMsg.KidsWatchRegRebindUI", sb.append(str2).append(", openId:").append(this.openid).toString());
                Intent intent = new Intent(this, KidsWatchRegSuccessUI.class);
                String str3 = this.dZW;
                if (str3 == null) {
                    p.btv("loginUrl");
                }
                intent.putExtra("intent.key.login.url", str3);
                String str4 = this.nickName;
                if (str4 == null) {
                    p.btv("nickName");
                }
                intent.putExtra("intent.key.reg.nickname", str4);
                intent.putExtra("intent.key.reg.openid", this.openid);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(256367);
                return;
            }
            com.tencent.mm.plugin.kidswatch.model.c cVar2 = com.tencent.mm.plugin.kidswatch.model.c.yAF;
            com.tencent.mm.plugin.kidswatch.model.c.a("", c.d.REG_RESULT_FAIL, i3);
            if (new com.tencent.mm.platformtools.b().a(this, new ae(i2, i3, str))) {
                AppMethodBeat.o(256367);
                return;
            }
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(this, null, null);
                AppMethodBeat.o(256367);
                return;
            }
            String string = getString(R.string.eaq, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            p.g(string, "getString(R.string.kids_…or_tip, errType, errCode)");
            h.X(getContext(), string, "");
        }
        AppMethodBeat.o(256367);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ KidsWatchRegRebindUI yBI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(KidsWatchRegRebindUI kidsWatchRegRebindUI) {
            super(0);
            this.yBI = kidsWatchRegRebindUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256360);
            this.yBI.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(256360);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(KidsWatchRegRebindUI kidsWatchRegRebindUI) {
        AppMethodBeat.i(256369);
        StringBuilder sb = new StringBuilder("startExtReg, ");
        String str = kidsWatchRegRebindUI.nickName;
        if (str == null) {
            p.btv("nickName");
        }
        Log.i("MicroMsg.KidsWatchRegRebindUI", sb.append(str).append(", ").append(kidsWatchRegRebindUI.kpI).append(", ").append(kidsWatchRegRebindUI.knu).append(", 4").toString());
        g.azz().a(5888, kidsWatchRegRebindUI);
        String str2 = kidsWatchRegRebindUI.nickName;
        if (str2 == null) {
            p.btv("nickName");
        }
        String str3 = kidsWatchRegRebindUI.dSf;
        if (str3 == null) {
            p.btv("mobile");
        }
        boolean z = kidsWatchRegRebindUI.kpI;
        String str4 = kidsWatchRegRebindUI.dZW;
        if (str4 == null) {
            p.btv("loginUrl");
        }
        String str5 = kidsWatchRegRebindUI.yBA;
        if (str5 == null) {
            p.btv("headImgFileID");
        }
        String str6 = kidsWatchRegRebindUI.yBB;
        if (str6 == null) {
            p.btv("headImgAesKey");
        }
        com.tencent.mm.plugin.kidswatch.model.d dVar = new com.tencent.mm.plugin.kidswatch.model.d(str2, str3, z, str4, str5, str6);
        dVar.PB(kidsWatchRegRebindUI.knu);
        g.azz().b(dVar);
        kidsWatchRegRebindUI.getString(R.string.zb);
        kidsWatchRegRebindUI.kdn = h.a((Context) kidsWatchRegRebindUI, kidsWatchRegRebindUI.getString(R.string.eb7), true, (DialogInterface.OnCancelListener) new e(kidsWatchRegRebindUI, dVar));
        AppMethodBeat.o(256369);
    }

    public static final /* synthetic */ void b(KidsWatchRegRebindUI kidsWatchRegRebindUI) {
        AppMethodBeat.i(256370);
        Intent intent = new Intent(kidsWatchRegRebindUI, KidsWatchRegGetInfoUI.class);
        String str = kidsWatchRegRebindUI.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        intent.putExtra("intent.key.login.url", str);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(kidsWatchRegRebindUI, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "goBackRegUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        kidsWatchRegRebindUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(kidsWatchRegRebindUI, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "goBackRegUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(256370);
    }
}
