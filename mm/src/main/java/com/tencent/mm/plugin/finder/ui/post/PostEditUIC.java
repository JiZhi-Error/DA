package com.tencent.mm.plugin.finder.ui.post;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020:H\u0003J\u0006\u0010<\u001a\u00020:J\b\u0010=\u001a\u00020:H\u0016J\u0018\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020\u001b2\b\u0010@\u001a\u0004\u0018\u00010AJ\b\u0010B\u001a\u00020:H\u0016J\u0006\u0010C\u001a\u00020:R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001a\u0010+\u001a\u00020,X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X.¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/post/PostEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "setDescTv", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;)V", "footerContainer", "Landroid/view/View;", "getFooterContainer", "()Landroid/view/View;", "setFooterContainer", "(Landroid/view/View;)V", "oldFooterHeight", "", "getOldFooterHeight", "()I", "setOldFooterHeight", "(I)V", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "scrollView$delegate", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "getStyleManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "setStyleManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;)V", "textCountTv", "Landroid/widget/TextView;", "textOk", "", "getTextOk", "()Z", "setTextOk", "(Z)V", "checkNextEnable", "", "initDescText", "initView", "onDestroy", "onSelectContact", "resultCode", "data", "Landroid/content/Intent;", "onTopicClick", "saveDescData", "plugin-finder_release"})
public final class PostEditUIC extends UIComponent implements FinderPostFooter.b {
    final String TAG = "Finder.FinderPostUI";
    public View uGQ;
    TextView uGS;
    public FinderPostEditText vQR;
    public FinderPostFooter vQS;
    boolean vQT = true;
    int vQU;
    public com.tencent.mm.plugin.finder.view.manager.d vQV;
    final f vQW;
    private final f vQX;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostEditUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(252951);
        this.vQW = g.ah(new d(appCompatActivity));
        this.vQX = g.ah(new e(appCompatActivity));
        AppMethodBeat.o(252951);
    }

    public static final /* synthetic */ TextView a(PostEditUIC postEditUIC) {
        AppMethodBeat.i(252952);
        TextView textView = postEditUIC.uGS;
        if (textView == null) {
            p.btv("textCountTv");
        }
        AppMethodBeat.o(252952);
        return textView;
    }

    public final FinderPostEditText dAx() {
        AppMethodBeat.i(252944);
        FinderPostEditText finderPostEditText = this.vQR;
        if (finderPostEditText == null) {
            p.btv("descTv");
        }
        AppMethodBeat.o(252944);
        return finderPostEditText;
    }

    public final FinderPostFooter dAy() {
        AppMethodBeat.i(252945);
        FinderPostFooter finderPostFooter = this.vQS;
        if (finderPostFooter == null) {
            p.btv("footer");
        }
        AppMethodBeat.o(252945);
        return finderPostFooter;
    }

    public final View dAz() {
        AppMethodBeat.i(252946);
        View view = this.uGQ;
        if (view == null) {
            p.btv("footerContainer");
        }
        AppMethodBeat.o(252946);
        return view;
    }

    public final com.tencent.mm.plugin.finder.view.manager.d dAA() {
        AppMethodBeat.i(252947);
        com.tencent.mm.plugin.finder.view.manager.d dVar = this.vQV;
        if (dVar == null) {
            p.btv("styleManager");
        }
        AppMethodBeat.o(252947);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/ui/post/PostEditUIC$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
    public static final class c implements TextWatcher {
        final /* synthetic */ PostEditUIC vQY;
        final /* synthetic */ int vQZ;

        c(PostEditUIC postEditUIC, int i2) {
            this.vQY = postEditUIC;
            this.vQZ = i2;
        }

        @SuppressLint({"SetTextI18n"})
        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(252941);
            int dp = this.vQZ - (com.tencent.mm.ui.tools.f.dp(this.vQZ * 2, String.valueOf(editable)) / 2);
            this.vQY.vQT = true;
            if (((double) (((float) dp) / ((float) this.vQZ))) >= 0.95d) {
                PostEditUIC.a(this.vQY).setText(new StringBuilder().append(dp).append('/').append(this.vQZ).toString());
                if (dp > this.vQZ) {
                    PostEditUIC.a(this.vQY).setTextColor(this.vQY.getResources().getColor(R.color.Red_100));
                    this.vQY.vQT = false;
                } else {
                    PostEditUIC.a(this.vQY).setTextColor(this.vQY.getResources().getColor(R.color.FG_1));
                }
                PostEditUIC.a(this.vQY).setVisibility(0);
            } else {
                PostEditUIC.a(this.vQY).setText("");
                PostEditUIC.a(this.vQY).setVisibility(8);
            }
            PostEditUIC postEditUIC = this.vQY;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((PostMainUIC) com.tencent.mm.ui.component.a.b(postEditUIC.getActivity()).get(PostMainUIC.class)).dAJ();
            com.tencent.mm.plugin.finder.view.manager.d dAA = this.vQY.dAA();
            String valueOf = String.valueOf(editable);
            if (editable == null) {
                p.hyc();
            }
            dAA.a(valueOf, editable);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drN()) {
                com.tencent.mm.plugin.finder.view.manager.e eVar = this.vQY.dAA().wtp;
                if (eVar == null) {
                    p.btv("topicSuggestManager");
                }
                int size = eVar.wtt.size();
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (size > com.tencent.mm.plugin.finder.storage.c.dsC().value().intValue()) {
                    this.vQY.dAy().oX(false);
                } else {
                    this.vQY.dAy().oX(true);
                }
            }
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drO()) {
                com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dsT().value().intValue() != 1000) {
                    int size2 = this.vQY.dAA().dHI().vTC.size();
                    com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (size2 >= com.tencent.mm.plugin.finder.storage.c.dsT().value().intValue()) {
                        this.vQY.dAy().oY(false);
                        AppMethodBeat.o(252941);
                        return;
                    }
                }
                this.vQY.dAy().oY(true);
            }
            AppMethodBeat.o(252941);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/ui/post/PostEditUIC$initDescText$1", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-finder_release"})
    public static final class a implements InputFilter {
        a() {
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            AppMethodBeat.i(252939);
            if (charSequence != null) {
                String obj = charSequence.toString();
                if (n.a((CharSequence) obj, (CharSequence) "\n", false)) {
                    String j2 = n.j(obj, "\n", "", false);
                    AppMethodBeat.o(252939);
                    return j2;
                }
            }
            AppMethodBeat.o(252939);
            return charSequence;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class b implements View.OnTouchListener {
        final /* synthetic */ PostEditUIC vQY;

        b(PostEditUIC postEditUIC) {
            this.vQY = postEditUIC;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(252940);
            if (p.j(view, this.vQY.dAx())) {
                p.g(motionEvent, "event");
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        PostEditUIC.b(this.vQY).requestDisallowInterceptTouchEvent(true);
                        break;
                    case 1:
                    case 3:
                        PostEditUIC.b(this.vQY).requestDisallowInterceptTouchEvent(false);
                        break;
                }
            }
            AppMethodBeat.o(252940);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(252948);
        super.onDestroy();
        if (this.vQV == null) {
            p.btv("styleManager");
        }
        AppMethodBeat.o(252948);
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderPostFooter.b
    public final void dAB() {
        String sb;
        AppMethodBeat.i(252949);
        FinderPostEditText finderPostEditText = this.vQR;
        if (finderPostEditText == null) {
            p.btv("descTv");
        }
        int selectionStart = finderPostEditText.getSelectionStart();
        FinderPostEditText finderPostEditText2 = this.vQR;
        if (finderPostEditText2 == null) {
            p.btv("descTv");
        }
        String obj = finderPostEditText2.getText().toString();
        StringBuilder sb2 = new StringBuilder();
        w wVar = w.vXp;
        String sb3 = sb2.append(w.dCx()).toString();
        if (selectionStart == 0) {
            sb = sb3 + obj;
        } else if (selectionStart == obj.length()) {
            sb = obj + sb3;
        } else {
            StringBuilder sb4 = new StringBuilder();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(252949);
                throw tVar;
            }
            String substring = obj.substring(0, selectionStart);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            StringBuilder append = sb4.append(substring).append(sb3);
            int length = obj.length();
            if (obj == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(252949);
                throw tVar2;
            }
            String substring2 = obj.substring(selectionStart, length);
            p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb = append.append(substring2).toString();
        }
        FinderPostEditText finderPostEditText3 = this.vQR;
        if (finderPostEditText3 == null) {
            p.btv("descTv");
        }
        finderPostEditText3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), sb));
        FinderPostEditText finderPostEditText4 = this.vQR;
        if (finderPostEditText4 == null) {
            p.btv("descTv");
        }
        finderPostEditText4.requestFocus();
        FinderPostEditText finderPostEditText5 = this.vQR;
        if (finderPostEditText5 == null) {
            p.btv("descTv");
        }
        finderPostEditText5.setSelection(selectionStart + 1);
        View view = this.uGQ;
        if (view == null) {
            p.btv("footerContainer");
        }
        if (view.getVisibility() == 8) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(252949);
                throw tVar3;
            }
            ((MMActivity) activity).showVKB();
        }
        AppMethodBeat.o(252949);
    }

    public final void dAC() {
        AppMethodBeat.i(252950);
        FinderPostEditText finderPostEditText = this.vQR;
        if (finderPostEditText == null) {
            p.btv("descTv");
        }
        getIntent().putExtra("saveDesc", finderPostEditText.getText().toString());
        Intent intent = getIntent();
        com.tencent.mm.plugin.finder.view.manager.d dVar = this.vQV;
        if (dVar == null) {
            p.btv("styleManager");
        }
        com.tencent.mm.plugin.finder.view.manager.b dHI = dVar.dHI();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, cjj> entry : dHI.wsG.entrySet()) {
            entry.getKey();
            com.tencent.mm.plugin.finder.utils.d dVar2 = com.tencent.mm.plugin.finder.utils.d.vVg;
            arrayList.add(com.tencent.mm.plugin.finder.utils.d.c(entry.getValue()));
        }
        intent.putExtra("saveDescAt", arrayList);
        AppMethodBeat.o(252950);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.widget.post.c> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.widget.post.c invoke() {
            AppMethodBeat.i(252942);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.widget.post.c dAD = ((PostMainUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(PostMainUIC.class)).dAD();
            AppMethodBeat.o(252942);
            return dAD;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/ScrollView;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<ScrollView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ScrollView invoke() {
            AppMethodBeat.i(252943);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ScrollView dAE = ((PostMainUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(PostMainUIC.class)).dAE();
            AppMethodBeat.o(252943);
            return dAE;
        }
    }

    public static final /* synthetic */ ScrollView b(PostEditUIC postEditUIC) {
        AppMethodBeat.i(252953);
        ScrollView scrollView = (ScrollView) postEditUIC.vQX.getValue();
        AppMethodBeat.o(252953);
        return scrollView;
    }
}
