package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.ui.view.e;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.thumbplayer.view.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0016J \u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R9\u0010\r\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000ej\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "mvListDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "refVideoNickNameTvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "Lkotlin/collections/HashMap;", "getRefVideoNickNameTvMap", "()Ljava/util/HashMap;", "addRefVideoNickNameTv", "", "refVideoNickNameTv", "enterFinderProfile", ch.COL_USERNAME, "", "isMvListDialogShow", "", "makeSureDrawerInit", "onBackPressed", "onCommentClicked", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "refCommentId", "", "closeCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showMvListDialog", "Companion", "plugin-mv_release"})
public final class MusicMvInfoUIC extends UIComponent {
    public static final a AtB = new a((byte) 0);
    public final HashMap<Integer, WeakReference<TextView>> AtA;
    final e Aty = new e(getContext());
    final d Atz;
    private com.tencent.mm.plugin.finder.view.e tLT;

    static {
        AppMethodBeat.i(257132);
        AppMethodBeat.o(257132);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvInfoUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257131);
        this.Atz = new b(this, appCompatActivity);
        this.AtA = new HashMap<>();
        AppMethodBeat.o(257131);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257123);
        super.onCreate(bundle);
        evP();
        AppMethodBeat.o(257123);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(257124);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar != null) {
            eVar.dGr();
        }
        super.onDestroy();
        AppMethodBeat.o(257124);
    }

    private final void evP() {
        AppMethodBeat.i(257125);
        if (this.tLT == null) {
            e.a aVar = com.tencent.mm.plugin.finder.view.e.wky;
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(257125);
                throw tVar;
            }
            Window window = getActivity().getWindow();
            p.g(window, "activity.window");
            View decorView = window.getDecorView();
            p.g(decorView, "activity.window.decorView");
            this.tLT = e.a.a((MMActivity) activity, decorView, 2, false, 70);
        }
        AppMethodBeat.o(257125);
    }

    public static /* synthetic */ void a(MusicMvInfoUIC musicMvInfoUIC, com.tencent.mm.plugin.mv.a.e eVar, CommentDrawerContract.CloseDrawerCallback closeDrawerCallback) {
        AppMethodBeat.i(257127);
        musicMvInfoUIC.a(eVar, 0, closeDrawerCallback);
        AppMethodBeat.o(257127);
    }

    public final void a(com.tencent.mm.plugin.mv.a.e eVar, long j2, CommentDrawerContract.CloseDrawerCallback closeDrawerCallback) {
        AppMethodBeat.i(257126);
        p.h(eVar, "musicMv");
        p.h(closeDrawerCallback, "closeCallback");
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(getContext(), 7, cst.class);
        if (cst != null) {
            cst.Vkg = 1;
        }
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        cst cst2 = (cst) SecDataUIC.a.a(getContext(), 7, cst.class);
        if (cst2 != null) {
            cst2.MxP = 1;
        }
        e.a aVar3 = com.tencent.mm.plugin.mv.a.e.ApR;
        FinderObject a2 = e.a.a(eVar);
        if (a2 != null) {
            Log.i("MicroMsg.Mv.MusicMvInfoUIC", "onCommentClicked id:" + a2.id + " nonceId:" + a2.objectNonceId);
            FinderItem.a aVar4 = FinderItem.Companion;
            FinderItem a3 = FinderItem.a.a(a2, 65536);
            evP();
            com.tencent.mm.plugin.finder.view.e eVar2 = this.tLT;
            if (eVar2 != null) {
                com.tencent.mm.plugin.finder.view.e.a(eVar2, a3, j2, false, true, false, closeDrawerCallback, 128);
                AppMethodBeat.o(257126);
                return;
            }
            AppMethodBeat.o(257126);
            return;
        }
        AppMethodBeat.o(257126);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(257128);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null || !eVar.dGs()) {
            AppMethodBeat.o(257128);
            return false;
        }
        com.tencent.mm.plugin.finder.view.e eVar2 = this.tLT;
        if (eVar2 != null) {
            eVar2.dGr();
        }
        AppMethodBeat.o(257128);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", FirebaseAnalytics.b.INDEX, "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
    public static final class b implements d {
        final /* synthetic */ MusicMvInfoUIC AtC;
        final /* synthetic */ AppCompatActivity uQi;

        b(MusicMvInfoUIC musicMvInfoUIC, AppCompatActivity appCompatActivity) {
            this.AtC = musicMvInfoUIC;
            this.uQi = appCompatActivity;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.view.d
        public final void a(int i2, com.tencent.mm.plugin.thumbplayer.d.a aVar) {
            AppMethodBeat.i(257122);
            p.h(aVar, "targetMedia");
            com.tencent.mm.ac.d.h(new a(this, aVar));
            AppMethodBeat.o(257122);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b AtD;
            final /* synthetic */ com.tencent.mm.plugin.thumbplayer.d.a AtE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, com.tencent.mm.plugin.thumbplayer.d.a aVar) {
                super(0);
                this.AtD = bVar;
                this.AtE = aVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\b"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$1$1$2$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$let$lambda$2"})
            /* renamed from: com.tencent.mm.plugin.mv.ui.uic.MusicMvInfoUIC$b$a$a  reason: collision with other inner class name */
            static final class View$OnClickListenerC1555a implements View.OnClickListener {
                final /* synthetic */ TextView AtF;
                final /* synthetic */ Object AtG;
                final /* synthetic */ a AtH;

                View$OnClickListenerC1555a(TextView textView, Object obj, a aVar) {
                    this.AtF = textView;
                    this.AtG = obj;
                    this.AtH = aVar;
                }

                public final void onClick(View view) {
                    String str;
                    AppMethodBeat.i(257120);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FinderContact finderContact = ((FinderObject) this.AtG).contact;
                    if (!(finderContact == null || (str = finderContact.username) == null)) {
                        MusicMvInfoUIC musicMvInfoUIC = this.AtH.AtD.AtC;
                        p.g(str, LocaleUtil.ITALIAN);
                        musicMvInfoUIC.aIr(str);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(257120);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                FinderContact finderContact;
                String str;
                String str2;
                AppMethodBeat.i(257121);
                Collection<WeakReference<TextView>> values = this.AtD.AtC.AtA.values();
                p.g(values, "refVideoNickNameTvMap.values");
                Iterator<T> it = values.iterator();
                while (it.hasNext()) {
                    TextView textView = (TextView) it.next().get();
                    if (textView != null) {
                        Object obj = this.AtE.Ghx;
                        if (!(!(obj instanceof FinderObject) || (finderContact = ((FinderObject) obj).contact) == null || (str = finderContact.nickname) == null)) {
                            p.g(str, LocaleUtil.ITALIAN);
                            String str3 = str.length() > 0 ? str : null;
                            if (str3 != null) {
                                p.g(textView, "tv");
                                Object tag = textView.getTag();
                                FinderContact finderContact2 = ((FinderObject) obj).contact;
                                if (finderContact2 != null) {
                                    str2 = finderContact2.username;
                                } else {
                                    str2 = null;
                                }
                                if (!p.j(tag, str2)) {
                                    SpannableString spannableString = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.c(this.AtD.uQi, str3));
                                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF7D90A9")), 0, str3.length(), 33);
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                                    spannableStringBuilder.append((CharSequence) this.AtD.uQi.getString(R.string.f9v));
                                    spannableStringBuilder.append((CharSequence) spannableString);
                                    spannableStringBuilder.append((CharSequence) this.AtD.uQi.getString(R.string.f9u));
                                    textView.setText(spannableStringBuilder);
                                    textView.setVisibility(0);
                                    textView.setOnClickListener(new View$OnClickListenerC1555a(textView, obj, this));
                                } else {
                                    textView.setVisibility(8);
                                }
                            }
                        }
                        p.g(textView, "tv");
                        textView.setVisibility(8);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(257121);
                return xVar;
            }
        }
    }

    public final void aIr(String str) {
        AppMethodBeat.i(257129);
        p.h(str, ch.COL_USERNAME);
        Intent intent = new Intent();
        intent.putExtra("finder_username", str);
        intent.putExtra("key_from_profile_share_scene", 19);
        intent.putExtra("key_enter_profile_type", 1);
        intent.putExtra("key_not_request_focus", true);
        intent.putExtra("key_hide_float_ball", true);
        ((aj) g.ah(aj.class)).fillContextIdToIntent(7, 2, 32, intent);
        c cVar = c.Akc;
        c.sm(true);
        ((aj) g.ah(aj.class)).enterFinderProfileUI(getActivity(), intent);
        AppMethodBeat.o(257129);
    }

    public final void f(com.tencent.mm.plugin.mv.a.e eVar) {
        AppMethodBeat.i(257130);
        p.h(eVar, "musicMv");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvMainUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMainUIC.class)).evT();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMainUIC.class);
        p.g(viewModel, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
        com.tencent.mm.plugin.mv.ui.view.e eVar2 = this.Aty;
        ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList = ((MusicMvMainUIC) viewModel).kgc;
        ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().ArY);
        }
        eVar2.a(eVar, arrayList2);
        this.Aty.show();
        AppMethodBeat.o(257130);
    }
}
