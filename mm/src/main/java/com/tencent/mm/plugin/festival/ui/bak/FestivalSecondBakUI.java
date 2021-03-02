package com.tencent.mm.plugin.festival.ui.bak;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.festival.ui.FestivalActivityBase;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI;", "Lcom/tencent/mm/plugin/festival/ui/FestivalActivityBase;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "anchorUserName", "", "getContentLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAuthInfo", "authProfession", "setFriendFollowCnt", "friendFollowCount", "showLiveEnd", "showLiveNotStart", "Companion", "plugin-festival_release"})
public final class FestivalSecondBakUI extends FestivalActivityBase implements i {
    public static final a UEC = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String hIw;

    static {
        AppMethodBeat.i(263344);
        AppMethodBeat.o(263344);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.festival.ui.FestivalActivityBase
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229780);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229780);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.festival.ui.FestivalActivityBase
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229779);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229779);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.festival.ui.FestivalActivityBase, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI$Companion;", "", "()V", "BakAnchorUserName", "", "IntentKeyAnchorUsrName", "IntentKeyFriendFollowCnt", "IntentKeyStatusErrorType", "StatusErrorTypeLiveEnd", "", "StatusErrorTypeLiveNotStart", "TAG", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.festival.ui.FestivalActivityBase, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(263341);
        super.onCreate(bundle);
        switch (getIntent().getIntExtra("IntentKeyStatusErrorType", 1)) {
            case 1:
                RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.k04);
                p.g(relativeLayout, "liveStatusEndRoot");
                relativeLayout.setVisibility(0);
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.k05);
                p.g(linearLayout, "liveStatusNotStartRoot");
                linearLayout.setVisibility(8);
                RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(R.id.jth);
                p.g(relativeLayout2, "bgRoot");
                Drawable[] drawableArr = new Drawable[1];
                com.tencent.mm.plugin.festival.ui.b bVar = com.tencent.mm.plugin.festival.ui.b.UBn;
                Drawable mj = com.tencent.mm.plugin.festival.ui.b.mj(this);
                if (mj == null) {
                    p.hyc();
                }
                drawableArr[0] = mj;
                relativeLayout2.setBackground(new LayerDrawable(drawableArr));
                this.hIw = getIntent().getStringExtra("IntentKeyAnchorUsrName");
                String str = this.hIw;
                if (str == null || str.length() == 0) {
                    this.hIw = "v2_060000231003b20faec8cae38c11c0d5c60de432b07725973fcf0b69006c0940e35c83f58db4@finder";
                }
                String str2 = this.hIw;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    ((TextView) _$_findCachedViewById(R.id.j8n)).setOnClickListener(new b(this));
                    WeImageView weImageView = (WeImageView) _$_findCachedViewById(R.id.j8o);
                    p.g(weImageView, "visit_anchor_profile_icon");
                    weImageView.setVisibility(0);
                    TextView textView = (TextView) _$_findCachedViewById(R.id.j8n);
                    p.g(textView, "visit_anchor_profile");
                    textView.setVisibility(0);
                } else {
                    WeImageView weImageView2 = (WeImageView) _$_findCachedViewById(R.id.j8o);
                    p.g(weImageView2, "visit_anchor_profile_icon");
                    weImageView2.setVisibility(8);
                    TextView textView2 = (TextView) _$_findCachedViewById(R.id.j8n);
                    p.g(textView2, "visit_anchor_profile");
                    textView2.setVisibility(8);
                }
                ((ImageView) _$_findCachedViewById(R.id.mj)).setImageResource(R.drawable.cvu);
                int intExtra = getIntent().getIntExtra("IntentKeyFriendFollowCnt", 0);
                String str3 = this.hIw;
                if (str3 == null || str3.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || intExtra > 0) {
                    awI(intExtra);
                    AppMethodBeat.o(263341);
                    return;
                }
                com.tencent.mm.kernel.b aAg = g.aAg();
                p.g(aAg, "MMKernel.network()");
                aAg.azz().a(3736, this);
                String str4 = this.hIw;
                if (str4 == null) {
                    str4 = "";
                }
                cn cnVar = new cn(str4, 0, null, 0, null, 0, 0, 104);
                cnVar.twC = true;
                g.azz().b(cnVar);
                AppMethodBeat.o(263341);
                return;
            case 2:
                RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(R.id.jth);
                p.g(relativeLayout3, "bgRoot");
                relativeLayout3.setBackground(getResources().getDrawable(R.drawable.ctx));
                RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(R.id.k04);
                p.g(relativeLayout4, "liveStatusEndRoot");
                relativeLayout4.setVisibility(8);
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.k05);
                p.g(linearLayout2, "liveStatusNotStartRoot");
                linearLayout2.setVisibility(0);
                AppMethodBeat.o(263341);
                return;
            default:
                finish();
                AppMethodBeat.o(263341);
                return;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FestivalSecondBakUI UED;

        b(FestivalSecondBakUI festivalSecondBakUI) {
            this.UED = festivalSecondBakUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(263340);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI$showLiveEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String str = this.UED.hIw;
            if (str != null) {
                Intent intent = new Intent();
                intent.putExtra("finder_username", str);
                intent.putExtra("key_enter_profile_type", 11);
                ((aj) g.ah(aj.class)).enterFinderProfileUI(this.UED.getContext(), intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI$showLiveEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(263340);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        FinderAuthInfo finderAuthInfo;
        AppMethodBeat.i(263342);
        Log.i("FestivalSecondBakUI", "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        if (qVar instanceof cn) {
            FinderContact cZk = ((cn) qVar).cZk();
            if (((cn) qVar).twC && p.j(((cn) qVar).tuH, this.hIw)) {
                com.tencent.mm.kernel.b aAg = g.aAg();
                p.g(aAg, "MMKernel.network()");
                aAg.azz().b(3736, this);
                awI(cZk != null ? cZk.friend_follow_count : 0);
                if (cZk == null || (finderAuthInfo = cZk.authInfo) == null) {
                    str2 = null;
                } else {
                    str2 = finderAuthInfo.authProfession;
                }
                if (!Util.isNullOrNil(str2)) {
                    AppCompatActivity context = getContext();
                    p.g(context, "context");
                    String string = context.getResources().getString(R.string.cjs, str2);
                    p.g(string, "context.resources.getStr…act_auth, authProfession)");
                    TextView textView = (TextView) _$_findCachedViewById(R.id.mm);
                    p.g(textView, "anchor_ext_info_auth");
                    textView.setText(string);
                    TextView textView2 = (TextView) _$_findCachedViewById(R.id.mm);
                    p.g(textView2, "anchor_ext_info_auth");
                    textView2.setVisibility(0);
                    AppMethodBeat.o(263342);
                    return;
                }
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.mm);
                p.g(textView3, "anchor_ext_info_auth");
                textView3.setVisibility(8);
            }
        }
        AppMethodBeat.o(263342);
    }

    private final void awI(int i2) {
        AppMethodBeat.i(263343);
        TextView textView = (TextView) _$_findCachedViewById(R.id.mn);
        p.g(textView, "anchor_ext_info_friend_floow_count");
        AppCompatActivity context = getContext();
        p.g(context, "context");
        textView.setText(context.getResources().getString(R.string.cov, k.Lv(i2)));
        int i3 = i2 > 0 ? 0 : 8;
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.mn);
        p.g(textView2, "anchor_ext_info_friend_floow_count");
        textView2.setVisibility(i3);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.mo);
        p.g(linearLayout, "anchor_ext_info_layout");
        linearLayout.setVisibility(i3);
        AppMethodBeat.o(263343);
    }
}
