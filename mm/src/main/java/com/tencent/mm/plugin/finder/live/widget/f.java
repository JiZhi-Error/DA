package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

public final class f {
    private static final String TAG = TAG;
    private static final int WARNING = 4;
    private static final String uGq = uGq;
    private static final int uGr = 1;
    private static final int uGs = 2;
    private static final int uGt = 3;
    private static final int uGu = 5;
    private static final int uGv = 6;
    private static final int uGw = 7;
    public static final c uGx = new c((byte) 0);
    private int errCode;
    private final View gvQ;
    private final Button hPX;
    private final TextView hbb;
    private String hwd;
    private int type;
    private String uEu;
    private kotlin.g.a.b<? super Boolean, x> uGk;
    public kotlin.g.a.b<? super String, x> uGl;
    private final WeImageView uGm;
    private final WeImageView uGn;
    private final TextView uGo;
    private avr uGp;

    public /* synthetic */ f(View view) {
        this(view, "", "");
        AppMethodBeat.i(248092);
        AppMethodBeat.o(248092);
    }

    public f(View view, String str, String str2) {
        p.h(view, "root");
        p.h(str, "anchorUsername");
        p.h(str2, "liveCoverUrl");
        AppMethodBeat.i(248091);
        this.gvQ = view;
        this.hwd = str;
        this.uEu = str2;
        View findViewById = this.gvQ.findViewById(R.id.c5b);
        p.g(findViewById, "root.findViewById(R.id.exception_icon)");
        this.uGm = (WeImageView) findViewById;
        View findViewById2 = this.gvQ.findViewById(R.id.c5c);
        p.g(findViewById2, "root.findViewById(R.id.exception_ok_btn)");
        this.hPX = (Button) findViewById2;
        View findViewById3 = this.gvQ.findViewById(R.id.c5f);
        p.g(findViewById3, "root.findViewById(R.id.exception_top_back)");
        this.uGn = (WeImageView) findViewById3;
        View findViewById4 = this.gvQ.findViewById(R.id.c5d);
        p.g(findViewById4, "root.findViewById(R.id.exception_tip)");
        this.uGo = (TextView) findViewById4;
        View findViewById5 = this.gvQ.findViewById(R.id.c5e);
        p.g(findViewById5, "root.findViewById(R.id.exception_title)");
        this.hbb = (TextView) findViewById5;
        this.type = uGr;
        this.hPX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.f.AnonymousClass1 */
            final /* synthetic */ f uGy;

            {
                this.uGy = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248078);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uGy.hide();
                kotlin.g.a.b bVar2 = this.uGy.uGk;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.TRUE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248078);
            }
        });
        WeImageView weImageView = this.uGn;
        ViewGroup.LayoutParams layoutParams = weImageView.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(248091);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += au.getStatusBarHeight(this.gvQ.getContext());
        weImageView.setOnClickListener(new a(this));
        weImageView.post(new b(weImageView));
        ao.a(this.hbb.getPaint(), 0.8f);
        ao.a(this.hPX.getPaint(), 0.8f);
        AppMethodBeat.o(248091);
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(248093);
        AppMethodBeat.o(248093);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements View.OnClickListener {
        final /* synthetic */ f uGy;

        a(f fVar) {
            this.uGy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248077);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uGy.hide();
            kotlin.g.a.b bVar2 = this.uGy.uGk;
            if (bVar2 != null) {
                bVar2.invoke(Boolean.FALSE);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248077);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements Runnable {
        final /* synthetic */ WeImageView uGz;

        b(WeImageView weImageView) {
            this.uGz = weImageView;
        }

        public final void run() {
            AppMethodBeat.i(248079);
            Rect rect = new Rect();
            this.uGz.getHitRect(rect);
            rect.inset(-rect.width(), -rect.width());
            ViewParent parent = this.uGz.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(248079);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.uGz));
            AppMethodBeat.o(248079);
        }
    }

    private final SpannableString gN(String str, String str2) {
        int i2;
        AppMethodBeat.i(248084);
        int a2 = n.a((CharSequence) str, str2, 0, false, 6);
        int length = a2 + str2.length();
        SpannableString spannableString = new SpannableString(str);
        if (a2 <= 0 || length > str.length()) {
            i2 = str.length();
            Log.e(TAG, "license text err,all string:" + str + ",license:" + str2);
            a2 = 0;
        } else {
            i2 = length;
        }
        spannableString.setSpan(new d(this), a2, i2, 33);
        AppMethodBeat.o(248084);
        return spannableString;
    }

    public static final class d extends ClickableSpan {
        final /* synthetic */ f uGy;

        d(f fVar) {
            this.uGy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248080);
            p.h(view, "widget");
            c cVar = f.uGx;
            Log.i(f.TAG, "license click,licenseClickCallback is null:" + (this.uGy.uGl == null));
            if (this.uGy.uGl != null) {
                kotlin.g.a.b bVar = this.uGy.uGl;
                if (bVar != null) {
                    c cVar2 = f.uGx;
                    bVar.invoke(f.uGq);
                    AppMethodBeat.o(248080);
                    return;
                }
                AppMethodBeat.o(248080);
                return;
            }
            Intent intent = new Intent();
            c cVar3 = f.uGx;
            intent.putExtra("rawUrl", f.uGq);
            com.tencent.mm.br.c.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(248080);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(248081);
            p.h(textPaint, "ds");
            Context context = this.uGy.gvQ.getContext();
            p.g(context, "root.context");
            textPaint.setColor(context.getResources().getColor(R.color.Link_80));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(248081);
        }
    }

    private final SpannableString a(avr avr, int i2) {
        String str;
        AppMethodBeat.i(248085);
        if (avr != null) {
            String str2 = avr.dQx;
            if (!(str2 == null || str2.length() == 0)) {
                SpannableString g2 = l.g(this.gvQ.getContext(), avr.dQx, i2);
                p.g(g2, "MMSpanManager.spanForSmi…ckSpanStyle.NORMAL, null)");
                AppMethodBeat.o(248085);
                return g2;
            }
        }
        Log.i(TAG, "getLicenseText: error page is null, wording = " + (avr != null ? avr.dQx : null));
        SpannableString spannableString = new SpannableString((avr == null || (str = avr.dQx) == null) ? "" : str);
        AppMethodBeat.o(248085);
        return spannableString;
    }

    private final void djC() {
        AppMethodBeat.i(248086);
        View view = this.gvQ;
        Context context = this.gvQ.getContext();
        p.g(context, "root.context");
        view.setBackgroundColor(context.getResources().getColor(R.color.f3045c));
        AppMethodBeat.o(248086);
    }

    private final void showBlurBg() {
        AppMethodBeat.i(248087);
        g gVar = g.uwd;
        g.a(this.hwd, this.uEu, this.gvQ);
        AppMethodBeat.o(248087);
    }

    public static /* synthetic */ void a(f fVar, int i2, avr avr, kotlin.g.a.b bVar, int i3) {
        AppMethodBeat.i(248089);
        if ((i3 & 2) != 0) {
            avr = null;
        }
        fVar.a(i2, avr, 0, bVar);
        AppMethodBeat.o(248089);
    }

    public final void a(int i2, avr avr, int i3, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(248088);
        com.tencent.mm.ac.d.h(new C1208f(this, i2, avr, i3, bVar));
        AppMethodBeat.o(248088);
    }

    public final void hide() {
        AppMethodBeat.i(248090);
        com.tencent.mm.ac.d.h(new e(this));
        AppMethodBeat.o(248090);
    }

    public static final /* synthetic */ void d(f fVar) {
        int i2;
        String string;
        String string2;
        SpannableString a2;
        String str;
        AppMethodBeat.i(248094);
        Log.i(TAG, "show content type:" + fVar.type);
        fVar.uGn.setVisibility(8);
        int i3 = fVar.type;
        if (i3 == uGr) {
            TextView textView = fVar.hbb;
            Context context = fVar.gvQ.getContext();
            p.g(context, "root.context");
            textView.setText(context.getResources().getString(R.string.csi));
            fVar.uGm.setImageResource(R.raw.icons_filled_error);
            WeImageView weImageView = fVar.uGm;
            Context context2 = fVar.gvQ.getContext();
            p.g(context2, "root.context");
            weImageView.setIconColor(context2.getResources().getColor(R.color.Red_90));
            TextView textView2 = fVar.uGo;
            Context context3 = fVar.gvQ.getContext();
            p.g(context3, "root.context");
            textView2.setHighlightColor(context3.getResources().getColor(17170445));
            fVar.uGo.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView3 = fVar.uGo;
            Context context4 = fVar.gvQ.getContext();
            p.g(context4, "root.context");
            String string3 = context4.getResources().getString(R.string.cyf);
            p.g(string3, "root.context.resources.g…_live_post_forbidden_tip)");
            Context context5 = fVar.gvQ.getContext();
            p.g(context5, "root.context");
            String string4 = context5.getResources().getString(R.string.cye);
            p.g(string4, "root.context.resources.g…e_post_forbidden_license)");
            textView3.setText(fVar.gN(string3, string4));
            Button button = fVar.hPX;
            Context context6 = fVar.gvQ.getContext();
            p.g(context6, "root.context");
            button.setText(context6.getResources().getString(R.string.cyd));
            fVar.djC();
            AppMethodBeat.o(248094);
        } else if (i3 == WARNING) {
            TextView textView4 = fVar.hbb;
            Context context7 = fVar.gvQ.getContext();
            p.g(context7, "root.context");
            textView4.setText(context7.getResources().getString(R.string.csi));
            fVar.uGm.setImageResource(R.raw.icons_filled_error);
            WeImageView weImageView2 = fVar.uGm;
            Context context8 = fVar.gvQ.getContext();
            p.g(context8, "root.context");
            weImageView2.setIconColor(context8.getResources().getColor(R.color.Yellow));
            TextView textView5 = fVar.uGo;
            Context context9 = fVar.gvQ.getContext();
            p.g(context9, "root.context");
            textView5.setHighlightColor(context9.getResources().getColor(17170445));
            fVar.uGo.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView6 = fVar.uGo;
            Context context10 = fVar.gvQ.getContext();
            p.g(context10, "root.context");
            String string5 = context10.getResources().getString(R.string.cyf);
            p.g(string5, "root.context.resources.g…_live_post_forbidden_tip)");
            Context context11 = fVar.gvQ.getContext();
            p.g(context11, "root.context");
            String string6 = context11.getResources().getString(R.string.cye);
            p.g(string6, "root.context.resources.g…e_post_forbidden_license)");
            textView6.setText(fVar.gN(string5, string6));
            Button button2 = fVar.hPX;
            Context context12 = fVar.gvQ.getContext();
            p.g(context12, "root.context");
            button2.setText(context12.getResources().getString(R.string.cyd));
            fVar.djC();
            AppMethodBeat.o(248094);
        } else if (i3 == uGs) {
            fVar.uGn.setVisibility(0);
            TextView textView7 = fVar.hbb;
            avr avr = fVar.uGp;
            if (avr == null || (str = avr.title) == null) {
                Context context13 = fVar.gvQ.getContext();
                p.g(context13, "root.context");
                string = context13.getResources().getString(R.string.cyu);
            } else {
                string = str;
            }
            textView7.setText(string);
            fVar.uGm.setImageResource(R.raw.icons_outlined_real_name);
            WeImageView weImageView3 = fVar.uGm;
            Context context14 = fVar.gvQ.getContext();
            p.g(context14, "root.context");
            weImageView3.setIconColor(context14.getResources().getColor(R.color.ai));
            TextView textView8 = fVar.uGo;
            avr avr2 = fVar.uGp;
            if (avr2 == null || (a2 = fVar.a(avr2, (int) fVar.uGo.getTextSize())) == null) {
                Context context15 = fVar.gvQ.getContext();
                p.g(context15, "root.context");
                string2 = context15.getResources().getString(R.string.cyh);
            } else {
                string2 = a2;
            }
            textView8.setText(string2);
            Button button3 = fVar.hPX;
            Context context16 = fVar.gvQ.getContext();
            p.g(context16, "root.context");
            button3.setText(context16.getResources().getString(R.string.cyv));
            fVar.djC();
            AppMethodBeat.o(248094);
        } else if (i3 == uGt) {
            TextView textView9 = fVar.hbb;
            Context context17 = fVar.gvQ.getContext();
            p.g(context17, "root.context");
            textView9.setText(context17.getResources().getString(R.string.j_q));
            TextView textView10 = fVar.hbb;
            Context context18 = fVar.gvQ.getContext();
            p.g(context18, "root.context");
            textView10.setTextColor(context18.getResources().getColor(R.color.BW_100_Alpha_0_8));
            fVar.uGm.setImageResource(R.raw.icons_filled_error);
            WeImageView weImageView4 = fVar.uGm;
            Context context19 = fVar.gvQ.getContext();
            p.g(context19, "root.context");
            weImageView4.setIconColor(context19.getResources().getColor(R.color.Red_90));
            TextView textView11 = fVar.uGo;
            Context context20 = fVar.gvQ.getContext();
            p.g(context20, "root.context");
            textView11.setHighlightColor(context20.getResources().getColor(17170445));
            fVar.uGo.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView12 = fVar.uGo;
            Context context21 = fVar.gvQ.getContext();
            p.g(context21, "root.context");
            String string7 = context21.getResources().getString(R.string.j_p);
            p.g(string7, "root.context.resources.g…e_forbidden_curlive_tips)");
            Context context22 = fVar.gvQ.getContext();
            p.g(context22, "root.context");
            String string8 = context22.getResources().getString(R.string.j_o);
            p.g(string8, "root.context.resources.g…orbidden_curlive_license)");
            textView12.setText(fVar.gN(string7, string8));
            TextView textView13 = fVar.uGo;
            Context context23 = fVar.gvQ.getContext();
            p.g(context23, "root.context");
            textView13.setTextColor(context23.getResources().getColor(R.color.BW_100_Alpha_0_8));
            Button button4 = fVar.hPX;
            Context context24 = fVar.gvQ.getContext();
            p.g(context24, "root.context");
            button4.setText(context24.getResources().getString(R.string.cyd));
            fVar.hPX.setBackgroundResource(R.drawable.a03);
            Button button5 = fVar.hPX;
            Context context25 = fVar.gvQ.getContext();
            p.g(context25, "root.context");
            button5.setTextColor(context25.getResources().getColor(R.color.ae));
            fVar.showBlurBg();
            AppMethodBeat.o(248094);
        } else if (i3 == uGw) {
            TextView textView14 = fVar.hbb;
            avr avr3 = fVar.uGp;
            textView14.setText(avr3 != null ? avr3.title : null);
            fVar.uGm.setImageResource(R.raw.icons_filled_error);
            if (fVar.errCode == -200012) {
                i2 = R.color.Red_90;
            } else {
                i2 = R.color.Yellow;
            }
            WeImageView weImageView5 = fVar.uGm;
            Context context26 = fVar.gvQ.getContext();
            p.g(context26, "root.context");
            weImageView5.setIconColor(context26.getResources().getColor(i2));
            TextView textView15 = fVar.uGo;
            Context context27 = fVar.gvQ.getContext();
            p.g(context27, "root.context");
            textView15.setHighlightColor(context27.getResources().getColor(17170445));
            fVar.uGo.setMovementMethod(LinkMovementMethod.getInstance());
            fVar.uGo.setText(fVar.a(fVar.uGp, (int) fVar.uGo.getTextSize()));
            Button button6 = fVar.hPX;
            Context context28 = fVar.gvQ.getContext();
            p.g(context28, "root.context");
            button6.setText(context28.getResources().getString(R.string.cyd));
            fVar.djC();
            AppMethodBeat.o(248094);
        } else if (i3 == uGu) {
            TextView textView16 = fVar.hbb;
            Context context29 = fVar.gvQ.getContext();
            p.g(context29, "root.context");
            textView16.setText(context29.getResources().getString(R.string.cya));
            TextView textView17 = fVar.hbb;
            Context context30 = fVar.gvQ.getContext();
            p.g(context30, "root.context");
            textView17.setTextColor(context30.getResources().getColor(R.color.BW_100_Alpha_0_8));
            fVar.uGm.setImageResource(R.raw.icons_filled_error);
            WeImageView weImageView6 = fVar.uGm;
            Context context31 = fVar.gvQ.getContext();
            p.g(context31, "root.context");
            weImageView6.setIconColor(context31.getResources().getColor(R.color.BW_100_Alpha_0_8));
            fVar.uGo.setText(fVar.gvQ.getContext().getString(R.string.d63));
            TextView textView18 = fVar.uGo;
            Context context32 = fVar.gvQ.getContext();
            p.g(context32, "root.context");
            textView18.setTextColor(context32.getResources().getColor(R.color.BW_100_Alpha_0_8));
            Button button7 = fVar.hPX;
            Context context33 = fVar.gvQ.getContext();
            p.g(context33, "root.context");
            button7.setText(context33.getResources().getString(R.string.cyd));
            fVar.hPX.setBackgroundResource(R.drawable.a03);
            Button button8 = fVar.hPX;
            Context context34 = fVar.gvQ.getContext();
            p.g(context34, "root.context");
            button8.setTextColor(context34.getResources().getColor(R.color.ae));
            fVar.showBlurBg();
            AppMethodBeat.o(248094);
        } else {
            if (i3 == uGv) {
                TextView textView19 = fVar.hbb;
                Context context35 = fVar.gvQ.getContext();
                p.g(context35, "root.context");
                textView19.setText(context35.getResources().getString(R.string.egj));
                TextView textView20 = fVar.hbb;
                Context context36 = fVar.gvQ.getContext();
                p.g(context36, "root.context");
                textView20.setTextColor(context36.getResources().getColor(R.color.BW_100_Alpha_0_8));
                fVar.uGm.setImageResource(R.raw.icons_filled_error);
                WeImageView weImageView7 = fVar.uGm;
                Context context37 = fVar.gvQ.getContext();
                p.g(context37, "root.context");
                weImageView7.setIconColor(context37.getResources().getColor(R.color.BW_100_Alpha_0_8));
                fVar.uGo.setVisibility(8);
                Button button9 = fVar.hPX;
                Context context38 = fVar.gvQ.getContext();
                p.g(context38, "root.context");
                button9.setText(context38.getResources().getString(R.string.cyd));
                fVar.hPX.setBackgroundResource(R.drawable.a03);
                Button button10 = fVar.hPX;
                Context context39 = fVar.gvQ.getContext();
                p.g(context39, "root.context");
                button10.setTextColor(context39.getResources().getColor(R.color.ae));
                fVar.showBlurBg();
            }
            AppMethodBeat.o(248094);
        }
    }

    /* renamed from: com.tencent.mm.plugin.finder.live.widget.f$f */
    public static final class C1208f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ int $type;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ avr uGA;
        final /* synthetic */ f uGy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1208f(f fVar, int i2, avr avr, int i3, kotlin.g.a.b bVar) {
            super(0);
            this.uGy = fVar;
            this.$type = i2;
            this.uGA = avr;
            this.$errCode = i3;
            this.gWe = bVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248083);
            this.uGy.type = this.$type;
            this.uGy.uGp = this.uGA;
            this.uGy.errCode = this.$errCode;
            this.uGy.gvQ.setVisibility(0);
            this.uGy.uGk = this.gWe;
            f.d(this.uGy);
            x xVar = x.SXb;
            AppMethodBeat.o(248083);
            return xVar;
        }
    }

    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f uGy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar) {
            super(0);
            this.uGy = fVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248082);
            this.uGy.gvQ.setVisibility(8);
            x xVar = x.SXb;
            AppMethodBeat.o(248082);
            return xVar;
        }
    }
}
