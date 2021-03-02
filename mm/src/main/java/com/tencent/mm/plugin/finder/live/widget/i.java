package com.tencent.mm.plugin.finder.live.widget;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.u;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\u0016\u00109\u001a\u0002072\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u000207H\u0002J\b\u0010>\u001a\u000207H\u0002J\b\u0010?\u001a\u000207H\u0002R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\n\"\u0004\b2\u00103¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "MAX_INPUT_LENGTH", "", "getMAX_INPUT_LENGTH", "()I", "MAX_INPUT_SIZE", "getMAX_INPUT_SIZE", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "descContainer", "getDescContainer", "()Landroid/view/View;", "setDescContainer", "(Landroid/view/View;)V", "descTv", "Lcom/tencent/mm/ui/widget/MMEditText;", "getDescTv", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setDescTv", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "emptyArea", "getEmptyArea", "setEmptyArea", "footerContainer", "getFooterContainer", "setFooterContainer", "hintContainer", "Landroid/widget/FrameLayout;", "getHintContainer", "()Landroid/widget/FrameLayout;", "setHintContainer", "(Landroid/widget/FrameLayout;)V", "inputContainer", "getInputContainer", "setInputContainer", "getRoot", "textCountTv", "Landroid/widget/TextView;", "getTextCountTv", "()Landroid/widget/TextView;", "setTextCountTv", "(Landroid/widget/TextView;)V", "textLeft", "getTextLeft", "setTextLeft", "(I)V", "getDesc", "", "hideInput", "", "hideInputAction", "onKeyboardHeightChanged", "height", "show", "", "setInputConfig", "showInput", "showInputAction", "plugin-finder_release"})
public final class i {
    public final int MAX_INPUT_SIZE = 60;
    public final MMActivity activity;
    final View gvQ;
    public FrameLayout uGO;
    public MMEditText uGP;
    public View uGQ;
    public FrameLayout uGR;
    public TextView uGS;
    private View uGT;
    final int uGU = (this.MAX_INPUT_SIZE * 2);
    public int uGV = this.MAX_INPUT_SIZE;
    public View uhh;

    public i(MMActivity mMActivity, View view) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(view, "root");
        AppMethodBeat.i(248114);
        this.activity = mMActivity;
        this.gvQ = view;
        View findViewById = this.gvQ.findViewById(R.id.cwe);
        p.g(findViewById, "root.findViewById(R.id.finder_live_post_container)");
        this.uhh = findViewById;
        View findViewById2 = this.gvQ.findViewById(R.id.cwm);
        p.g(findViewById2, "root.findViewById(R.id.f…ost_input_hint_container)");
        this.uGO = (FrameLayout) findViewById2;
        View findViewById3 = this.gvQ.findViewById(R.id.ek4);
        p.g(findViewById3, "root.findViewById(R.id.live_post_desc_et)");
        this.uGP = (MMEditText) findViewById3;
        this.uGP.setSingleLine(false);
        View findViewById4 = this.gvQ.findViewById(R.id.dym);
        p.g(findViewById4, "root.findViewById(R.id.input_container)");
        this.uGQ = findViewById4;
        View findViewById5 = this.gvQ.findViewById(R.id.cwl);
        p.g(findViewById5, "root.findViewById(R.id.f…ive_post_input_container)");
        this.uGR = (FrameLayout) findViewById5;
        View findViewById6 = this.gvQ.findViewById(R.id.ikw);
        p.g(findViewById6, "root.findViewById(R.id.textcount_hint)");
        this.uGS = (TextView) findViewById6;
        View findViewById7 = this.gvQ.findViewById(R.id.dyn);
        p.g(findViewById7, "root.findViewById(R.id.input_empty_area)");
        this.uGT = findViewById7;
        this.uGT.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.i.AnonymousClass1 */
            final /* synthetic */ i uGW;

            {
                this.uGW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248109);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i iVar = this.uGW;
                Object systemService = iVar.gvQ.getContext().getSystemService("input_method");
                if (systemService == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    AppMethodBeat.o(248109);
                    throw tVar;
                }
                ((InputMethodManager) systemService).hideSoftInputFromWindow(iVar.uGP.getWindowToken(), 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248109);
            }
        });
        this.uGP.setFilters(new InputFilter[]{new a(this), new b(this, this.uGU, f.a.MODE_CHINESE_AS_2)});
        this.uGP.addTextChangedListener(new c(this));
        getDesc();
        AppMethodBeat.o(248114);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ i uGW;

        public d(i iVar) {
            this.uGW = iVar;
        }

        public final void run() {
            AppMethodBeat.i(261221);
            this.uGW.uGP.requestFocus();
            AppMethodBeat.o(261221);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
    static final class a implements InputFilter {
        final /* synthetic */ i uGW;

        a(i iVar) {
            this.uGW = iVar;
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            AppMethodBeat.i(248110);
            this.uGW.uGP.getText();
            String obj = charSequence.toString();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(248110);
                throw tVar;
            } else if (obj.contentEquals(r0)) {
                AppMethodBeat.o(248110);
                return r0;
            } else {
                AppMethodBeat.o(248110);
                return null;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$setInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
    public static final class b extends f {
        final /* synthetic */ i uGW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar, int i2, f.a aVar) {
            super(i2, aVar);
            this.uGW = iVar;
        }

        @Override // com.tencent.mm.ui.tools.f
        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            int a2;
            int i6;
            AppMethodBeat.i(248111);
            if ((spanned != null ? spanned.length() : 0) > i4) {
                a2 = f.a(String.valueOf(spanned != null ? spanned.subSequence(0, i4) : null), f.a.MODE_CHINESE_AS_2);
            } else {
                a2 = f.a(String.valueOf(spanned), f.a.MODE_CHINESE_AS_2);
            }
            if (spanned == null || spanned.length() <= i5) {
                i6 = 0;
            } else {
                i6 = f.a(spanned.subSequence(i5, spanned.length()).toString(), f.a.MODE_CHINESE_AS_2);
            }
            int a3 = f.a(String.valueOf(charSequence), f.a.MODE_CHINESE_AS_2);
            int i7 = (this.uGW.uGU - a2) - i6;
            int bnR = f.bnR(String.valueOf(charSequence));
            if (i6 + a2 + a3 > this.uGW.uGU) {
                int mZ = j.mZ(i7 - bnR, 0);
                if (charSequence == null || i2 < 0 || charSequence.length() < i2 + mZ) {
                    AppMethodBeat.o(248111);
                    return r0;
                }
                CharSequence subSequence = charSequence.subSequence(i2, mZ + i2);
                AppMethodBeat.o(248111);
                return subSequence;
            }
            String str = charSequence == null ? "" : charSequence;
            AppMethodBeat.o(248111);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$setInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
    public static final class c implements TextWatcher {
        final /* synthetic */ i uGW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(i iVar) {
            this.uGW = iVar;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(248112);
            this.uGW.uGV = f.dp(this.uGW.uGU, String.valueOf(editable)) / 2;
            this.uGW.uGS.setText(this.uGW.uGV >= 0 ? new StringBuilder().append(this.uGW.uGV).append('/').append(this.uGW.MAX_INPUT_SIZE).toString() : "0/" + this.uGW.MAX_INPUT_SIZE);
            AppMethodBeat.o(248112);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public final String getDesc() {
        String str;
        AppMethodBeat.i(248113);
        Editable text = this.uGP.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        String encode = q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", encode);
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "jsobject.toString()");
        k kVar = k.vkd;
        k.setDesc(jSONObject2);
        k kVar2 = k.vkd;
        u uVar = k.dpl().vmj;
        p.g(encode, "text");
        uVar.setDescription(encode);
        AppMethodBeat.o(248113);
        return jSONObject2;
    }
}
