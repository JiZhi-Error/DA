package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.protocal.protobuf.of;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

public final class n extends WebViewKeyboardLinearLayout {
    public static final a JzB = new a((byte) 0);
    private static final String TAG = TAG;
    private final WebViewKeyboardLinearLayout Jic;
    public int JjT;
    public final WebViewUI JzA;
    private final kotlin.f Jzh;
    private final WeImageView Jzi;
    private final Button Jzj;
    public final MMEditText Jzk;
    private final ListView Jzl;
    private final View Jzm;
    private final TextView Jzn;
    private final TextView Jzo;
    private final TextView Jzp;
    private b Jzq;
    private boolean Jzr;
    private int Jzs;
    private int Jzt;
    private int Jzu;
    private c Jzv;
    private boolean Jzw;
    private int Jzx;
    private boolean Jzy;
    private boolean Jzz;
    private final boolean dZO = false;
    private final View gvQ;
    private long iAH;
    int iwc;
    private final View kcT;
    int pHu;
    int pHw;
    int pHx;
    private WeakReference<n> peA;
    int scene;
    private String title;
    String url;

    public interface c {
        void onHide();

        void onShow();
    }

    public final MPSmileyFooter getSayFooter() {
        AppMethodBeat.i(82721);
        MPSmileyFooter mPSmileyFooter = (MPSmileyFooter) this.Jzh.getValue();
        AppMethodBeat.o(82721);
        return mPSmileyFooter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(WebViewUI webViewUI, Context context) {
        super(context, null);
        p.h(webViewUI, "webView");
        p.h(context, "context");
        AppMethodBeat.i(175710);
        this.JzA = webViewUI;
        View inflate = View.inflate(context, R.layout.bbz, this);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
            AppMethodBeat.o(175710);
            throw tVar;
        }
        this.Jic = (WebViewKeyboardLinearLayout) inflate;
        View findViewById = findViewById(R.id.fln);
        p.g(findViewById, "findViewById(R.id.mp_video_comment_action_layout)");
        this.kcT = findViewById;
        this.Jzh = kotlin.g.ah(new j(this));
        View findViewById2 = findViewById(R.id.flo);
        p.g(findViewById2, "findViewById(R.id.mp_video_comment_cancel)");
        this.Jzi = (WeImageView) findViewById2;
        View findViewById3 = findViewById(R.id.flq);
        p.g(findViewById3, "findViewById(R.id.mp_video_comment_ok)");
        this.Jzj = (Button) findViewById3;
        View findViewById4 = findViewById(R.id.flp);
        p.g(findViewById4, "findViewById(R.id.mp_video_comment_et)");
        this.Jzk = (MMEditText) findViewById4;
        View findViewById5 = findViewById(R.id.a9u);
        p.g(findViewById5, "findViewById(R.id.biz_video_my_comment_list)");
        this.Jzl = (ListView) findViewById5;
        View findViewById6 = findViewById(R.id.fm4);
        p.g(findViewById6, "findViewById(R.id.mp_write_comment_root)");
        this.gvQ = findViewById6;
        View findViewById7 = findViewById(R.id.fm3);
        p.g(findViewById7, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
        this.Jzm = findViewById7;
        View findViewById8 = findViewById(R.id.a9v);
        p.g(findViewById8, "findViewById(R.id.biz_video_my_comment_tv)");
        this.Jzn = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.flt);
        p.g(findViewById9, "findViewById(R.id.mp_video_my_comment_title)");
        this.Jzo = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.a_1);
        p.g(findViewById10, "findViewById(R.id.biz_video_reply_tip)");
        this.Jzp = (TextView) findViewById10;
        this.JjT = -1;
        this.url = "";
        this.title = "";
        this.peA = new WeakReference<>(this);
        getSayFooter().setMMEditText(this.Jzk);
        getSayFooter().setVisibility(8);
        this.Jzk.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.AnonymousClass1 */
            final /* synthetic */ n JzC;

            {
                this.JzC = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82691);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n.g(this.JzC);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82691);
            }
        });
        this.Jzk.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.AnonymousClass2 */
            final /* synthetic */ n JzC;

            {
                this.JzC = r1;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(82692);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                n.g(this.JzC);
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(82692);
                return false;
            }
        });
        this.Jic.setOnTouchListener(new View.OnTouchListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.AnonymousClass3 */
            final /* synthetic */ n JzC;

            {
                this.JzC = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(82693);
                p.g(motionEvent, "event");
                if (motionEvent.getAction() == 0) {
                    n nVar = this.JzC;
                    if (nVar.JjT == -3) {
                        nVar.JzA.hideVKB();
                    } else if (!nVar.getSayFooter().giw() || !nVar.bJw()) {
                        nVar.hide();
                    } else {
                        nVar.getSayFooter().fjJ();
                    }
                }
                AppMethodBeat.o(82693);
                return true;
            }
        });
        this.gvQ.setOnClickListener(AnonymousClass4.JzD);
        int rootHeight = getRootHeight();
        if (rootHeight > 0) {
            ViewGroup.LayoutParams layoutParams = this.gvQ.getLayoutParams();
            if (layoutParams == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                AppMethodBeat.o(175710);
                throw tVar2;
            }
            layoutParams.height = rootHeight;
            this.gvQ.setLayoutParams(layoutParams);
        }
        if (!KeyBoardUtil.isPortOrientation(context)) {
            ahg(2);
        }
        this.Jzi.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.AnonymousClass5 */
            final /* synthetic */ n JzC;

            {
                this.JzC = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82696);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.JzC.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82696);
            }
        });
        this.Jzj.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.AnonymousClass6 */
            final /* synthetic */ n JzC;

            {
                this.JzC = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82697);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.JzC.Jzr) {
                    String obj = this.JzC.Jzk.getText().toString();
                    com.tencent.mm.plugin.webview.d.h hVar = this.JzC.getWebView().IBw;
                    if (hVar != null) {
                        hVar.w(1, obj, 1);
                    }
                } else {
                    this.JzC.getWebView().hideVKB();
                    if (n.d(this.JzC).fjI()) {
                        n.d(this.JzC).fjJ();
                    }
                    fy fyVar = new fy();
                    fyVar.content = this.JzC.Jzk.getText().toString();
                    fyVar.pTI = 1;
                    if (this.JzC.Jzt != 0) {
                        fyVar.pTI = 3;
                        fyVar.KJJ = this.JzC.Jzt;
                    }
                    this.JzC.a(fyVar);
                    com.tencent.mm.plugin.webview.i.a.agn(10);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82697);
            }
        });
        this.Jzk.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.AnonymousClass7 */
            final /* synthetic */ n JzC;

            {
                this.JzC = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(82698);
                Button button = this.JzC.Jzj;
                Editable text = this.JzC.Jzk.getText();
                p.g(text, "contentEt.text");
                button.setEnabled(text.length() > 0);
                AppMethodBeat.o(82698);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        Button button = this.Jzj;
        Editable text = this.Jzk.getText();
        p.g(text, "contentEt.text");
        button.setEnabled(text.length() > 0);
        this.Jzk.setOnTouchListener(new View.OnTouchListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.AnonymousClass8 */
            final /* synthetic */ n JzC;

            {
                this.JzC = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(175690);
                p.h(view, "view");
                p.h(motionEvent, "event");
                if (view.getId() == R.id.flp && this.JzC.Jzk.getLineCount() >= 5) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                AppMethodBeat.o(175690);
                return false;
            }
        });
        this.Jzp.setVisibility(8);
        AppMethodBeat.o(175710);
    }

    public static final /* synthetic */ boolean a(n nVar) {
        AppMethodBeat.i(175711);
        boolean giC = nVar.giC();
        AppMethodBeat.o(175711);
        return giC;
    }

    public static final /* synthetic */ MPSmileyFooter d(n nVar) {
        AppMethodBeat.i(82744);
        MPSmileyFooter sayFooter = nVar.getSayFooter();
        AppMethodBeat.o(82744);
        return sayFooter;
    }

    public static final /* synthetic */ int h(n nVar) {
        AppMethodBeat.i(82748);
        int navHeightByDisplay = nVar.getNavHeightByDisplay();
        AppMethodBeat.o(82748);
        return navHeightByDisplay;
    }

    public final WebViewUI getWebView() {
        return this.JzA;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(82720);
        AppMethodBeat.o(82720);
    }

    public final int getMinHeaderHeight() {
        return this.Jzu;
    }

    public final void setMinHeaderHeight(int i2) {
        this.Jzu = i2;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final int getScene() {
        return this.scene;
    }

    public final void setScene(int i2) {
        this.scene = i2;
    }

    public final int getSubScene() {
        return this.pHw;
    }

    public final void setSubScene(int i2) {
        this.pHw = i2;
    }

    public final int getItemShowType() {
        return this.iwc;
    }

    public final void setItemShowType(int i2) {
        this.iwc = i2;
    }

    public final int getEnterId() {
        return this.pHu;
    }

    public final void setEnterId(int i2) {
        this.pHu = i2;
    }

    public final long getCommentTopicId() {
        return this.iAH;
    }

    public final void setCommentTopicId(long j2) {
        this.iAH = j2;
    }

    public final int getTimeLineSessionId() {
        return this.pHx;
    }

    public final void setTimeLineSessionId(int i2) {
        this.pHx = i2;
    }

    public final c getCallback() {
        return this.Jzv;
    }

    public final void setCallback(c cVar) {
        this.Jzv = cVar;
    }

    public final WeakReference<n> getWeakThis$plugin_webview_release() {
        return this.peA;
    }

    public final void setWeakThis$plugin_webview_release(WeakReference<n> weakReference) {
        AppMethodBeat.i(82722);
        p.h(weakReference, "<set-?>");
        this.peA = weakReference;
        AppMethodBeat.o(82722);
    }

    public final void a(int i2, int i3, int i4, int i5, String str, String str2) {
        this.scene = i2;
        this.pHw = i3;
        this.iwc = i4;
        this.pHu = i5;
        this.url = str;
        this.title = str2;
    }

    private final void gix() {
        AppMethodBeat.i(82723);
        View view = this.Jzm;
        Context context = getContext();
        p.g(context, "context");
        view.setBackgroundColor(o.e(R.attr.gw, context));
        this.Jzn.setVisibility(8);
        AppMethodBeat.o(82723);
    }

    public static final class h implements KeyboardLinearLayout.a {
        final /* synthetic */ n JzC;

        h(n nVar) {
            this.JzC = nVar;
        }

        @Override // com.tencent.mm.ui.KeyboardLinearLayout.a
        public final void Ns(int i2) {
            AppMethodBeat.i(82717);
            a aVar = n.JzB;
            Log.i(n.TAG, "onKeyBoardStateChange, state = ".concat(String.valueOf(i2)));
            if (i2 == -3) {
                int keyBoardHeight = this.JzC.Jic.getKeyBoardHeight();
                if (keyBoardHeight > 0) {
                    n.a(this.JzC, keyBoardHeight);
                    n.a(this.JzC, keyBoardHeight);
                }
                new MMHandler().postDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.h.AnonymousClass1 */
                    final /* synthetic */ h JAf;

                    {
                        this.JAf = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(82715);
                        n.d(this.JAf.JzC).fjH();
                        n.d(this.JAf.JzC).postInvalidate();
                        this.JAf.JzC.gvQ.postInvalidate();
                        AppMethodBeat.o(82715);
                    }
                }, 10);
            } else {
                n.a(this.JzC, 0);
                n.a(this.JzC, 0);
                new MMHandler().postDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.h.AnonymousClass2 */
                    final /* synthetic */ h JAf;

                    {
                        this.JAf = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(82716);
                        n.d(this.JAf.JzC).giv();
                        n.d(this.JAf.JzC).postInvalidate();
                        this.JAf.JzC.gvQ.postInvalidate();
                        AppMethodBeat.o(82716);
                    }
                }, 10);
            }
            this.JzC.JjT = i2;
            AppMethodBeat.o(82717);
        }
    }

    public final void giy() {
        AppMethodBeat.i(82724);
        this.Jic.setOnkbdStateListener(new h(this));
        AppMethodBeat.o(82724);
    }

    public final void bbn(String str) {
        AppMethodBeat.i(175701);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(175701);
            return;
        }
        this.url = str;
        AppMethodBeat.o(175701);
    }

    public final void zw(boolean z) {
        AppMethodBeat.i(82725);
        xV(1);
        zy(false);
        zx(z);
        AppMethodBeat.o(82725);
    }

    public final void zx(boolean z) {
        AppMethodBeat.i(175702);
        this.Jzr = z;
        show();
        if (z) {
            this.Jzn.setVisibility(8);
            this.Jzo.setText(getContext().getString(R.string.ajh));
            this.Jzk.setHint(R.string.ajj);
            this.Jzj.setText(R.string.yq);
            Button button = this.Jzj;
            Context context = getContext();
            p.g(context, "context");
            button.setBackground(context.getResources().getDrawable(R.drawable.j0));
            this.Jzk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
            AppMethodBeat.o(175702);
            return;
        }
        getAppMsgCommentList();
        this.Jzj.setText(R.string.aj_);
        Button button2 = this.Jzj;
        Context context2 = getContext();
        p.g(context2, "context");
        button2.setBackground(o.ia(context2));
        AppMethodBeat.o(175702);
    }

    private void giz() {
        AppMethodBeat.i(175703);
        this.Jzk.setText("");
        this.Jzx = 0;
        getAppMsgCommentList();
        AppMethodBeat.o(175703);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(82728);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        ahg(configuration.orientation);
        if (getSayFooter().fjI()) {
            getSayFooter().fjJ();
        }
        AppMethodBeat.o(82728);
    }

    private final void ahg(int i2) {
        AppMethodBeat.i(82729);
        switch (i2) {
            case 2:
                setRootHeight(au.az(getContext()).y - au.getStatusBarHeight(getContext()));
                this.Jzk.setMinLines(3);
                AppMethodBeat.o(82729);
                return;
            default:
                if (this.Jic.geD()) {
                    ahh(this.Jic.getKeyBoardHeight());
                } else if (this.Jzs != 0) {
                    setRootHeight(this.Jzs);
                } else {
                    ahh(0);
                }
                this.Jzk.setMinLines(5);
                AppMethodBeat.o(82729);
                return;
        }
    }

    private final void ahh(int i2) {
        AppMethodBeat.i(82730);
        ViewGroup.LayoutParams layoutParams = this.gvQ.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(82730);
            throw tVar;
        }
        layoutParams.height = this.Jzk.getHeight() + this.kcT.getHeight() + getNavHeightByDisplay() + com.tencent.mm.cb.a.fromDPToPix(getContext(), com.tencent.mm.cb.a.E(getContext(), 60) + 16) + getReplyHeight() + i2;
        layoutParams.height = ahi(layoutParams.height);
        this.gvQ.setLayoutParams(layoutParams);
        ahj(layoutParams.height);
        AppMethodBeat.o(82730);
    }

    private final void setRootHeight(int i2) {
        AppMethodBeat.i(82731);
        ViewGroup.LayoutParams layoutParams = this.gvQ.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(82731);
            throw tVar;
        }
        layoutParams.height = ahi(i2);
        this.gvQ.setLayoutParams(layoutParams);
        ahj(layoutParams.height);
        AppMethodBeat.o(82731);
    }

    private final int ahi(int i2) {
        AppMethodBeat.i(82732);
        int statusBarHeight = au.getStatusBarHeight(getContext());
        int i3 = au.az(getContext()).y;
        int i4 = i3 - statusBarHeight;
        if (i2 > i4) {
            i2 = i4;
        } else if (this.Jzu > 0) {
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 20);
            if (i2 < ((i3 - this.Jzu) - statusBarHeight) + fromDPToPix) {
                i2 = ((i3 - statusBarHeight) - this.Jzu) + fromDPToPix;
            }
        }
        AppMethodBeat.o(82732);
        return i2;
    }

    private final void ahj(int i2) {
        AppMethodBeat.i(82733);
        if (KeyBoardUtil.isPortOrientation(getContext())) {
            this.Jzs = i2;
        }
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("MPWriteCommentLayout");
        singleMMKV.encode("MPWriteCommentRootHeight", i2);
        singleMMKV.apply();
        AppMethodBeat.o(82733);
    }

    private final int getRootHeight() {
        AppMethodBeat.i(82734);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), (int) com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX);
        AppMethodBeat.o(82734);
        return fromDPToPix;
    }

    private final void show() {
        AppMethodBeat.i(82735);
        this.gvQ.clearAnimation();
        setVisibility(0);
        giA();
        c cVar = this.Jzv;
        if (cVar != null) {
            cVar.onShow();
            AppMethodBeat.o(82735);
            return;
        }
        AppMethodBeat.o(82735);
    }

    public final void hide() {
        AppMethodBeat.i(82736);
        if (!bJw()) {
            AppMethodBeat.o(82736);
            return;
        }
        if (getSayFooter().fjI()) {
            getSayFooter().fjJ();
        }
        giB();
        this.JzA.hideVKB();
        this.Jzx = 0;
        b bVar = this.Jzq;
        if (bVar != null) {
            bVar.clear();
        }
        c cVar = this.Jzv;
        if (cVar != null) {
            cVar.onHide();
            AppMethodBeat.o(82736);
            return;
        }
        AppMethodBeat.o(82736);
    }

    private final void giA() {
        AppMethodBeat.i(182680);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(250);
        translateAnimation.setFillAfter(false);
        this.gvQ.clearAnimation();
        this.gvQ.startAnimation(translateAnimation);
        AppMethodBeat.o(182680);
    }

    private final void giB() {
        AppMethodBeat.i(82737);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(150);
        translateAnimation.setFillAfter(false);
        translateAnimation.setAnimationListener(new g(this));
        this.gvQ.clearAnimation();
        this.gvQ.startAnimation(translateAnimation);
        AppMethodBeat.o(82737);
    }

    public static final class g implements Animation.AnimationListener {
        final /* synthetic */ n JzC;

        g(n nVar) {
            this.JzC = nVar;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(82714);
            p.h(animation, "ani");
            n nVar = this.JzC.getWeakThis$plugin_webview_release().get();
            if (nVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
                AppMethodBeat.o(82714);
                throw tVar;
            }
            nVar.setVisibility(8);
            this.JzC.gvQ.clearAnimation();
            AppMethodBeat.o(82714);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public final boolean bJw() {
        AppMethodBeat.i(82738);
        if (getVisibility() == 0) {
            AppMethodBeat.o(82738);
            return true;
        }
        AppMethodBeat.o(82738);
        return false;
    }

    private final int getNavHeightByDisplay() {
        AppMethodBeat.i(82739);
        Point az = au.az(getContext());
        Window window = this.JzA.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        Rect rect = new Rect();
        if (decorView != null) {
            decorView.getWindowVisibleDisplayFrame(rect);
        }
        int i2 = rect.bottom;
        int keyBoardHeight = (az.y - i2) - this.Jic.getKeyBoardHeight();
        Log.v(TAG, "getNavHeightByDisplay screenHeight = " + i2 + ", realSize = " + az.y);
        if (keyBoardHeight < 0) {
            keyBoardHeight = au.aD(getContext());
            Log.v(TAG, "getNavHeightByDisplay error");
        }
        Log.v(TAG, "getNavHeightByDisplay h = %s", Integer.valueOf(keyBoardHeight));
        AppMethodBeat.o(82739);
        return keyBoardHeight;
    }

    public final int getMyCommentOffset() {
        return this.Jzx;
    }

    public final void setMyCommentOffset(int i2) {
        this.Jzx = i2;
    }

    public final void getAppMsgCommentList() {
        AppMethodBeat.i(82740);
        fl flVar = new fl();
        flVar.url = this.url;
        if (this.Jzw) {
            AppMethodBeat.o(82740);
            return;
        }
        flVar.offset = this.Jzx;
        if (this.Jzx == -1) {
            Log.i(TAG, "no more my comment");
            AppMethodBeat.o(82740);
            return;
        }
        this.Jzw = true;
        flVar.pTI = 2;
        flVar.scene = this.scene;
        flVar.KIL = this.pHw;
        flVar.KIJ = this.iwc;
        flVar.session_id = new StringBuilder().append(this.pHx).toString();
        flVar.KIK = this.pHu;
        flVar.KIM = this.iAH;
        d.a aVar = new d.a();
        aVar.c(flVar);
        aVar.d(new fm());
        aVar.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
        aVar.sG(2866);
        aVar.sI(0);
        aVar.sJ(0);
        IPCRunCgi.a(aVar.aXF(), new f(this));
        com.tencent.mm.plugin.webview.i.a.agn(7);
        AppMethodBeat.o(82740);
    }

    public static final class f implements IPCRunCgi.a {
        final /* synthetic */ n JzC;

        f(n nVar) {
            this.JzC = nVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(82713);
            this.JzC.Jzw = false;
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.f.AnonymousClass1 */
                final /* synthetic */ f JAe;

                {
                    this.JAe = r1;
                }

                public final void run() {
                    AppMethodBeat.i(82712);
                    p pVar = p.JAu;
                    p.b(this.JAe.JzC.getWebView().gfk());
                    if (this.JAe.JzC.getWeakThis$plugin_webview_release().get() != null) {
                        n nVar = this.JAe.JzC.getWeakThis$plugin_webview_release().get();
                        if (nVar == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
                            AppMethodBeat.o(82712);
                            throw tVar;
                        }
                        com.tencent.mm.ak.d dVar = dVar;
                        p.g(dVar, "rr");
                        n.a(nVar, dVar);
                    }
                    AppMethodBeat.o(82712);
                }
            });
            if (i2 == 2) {
                com.tencent.mm.plugin.webview.i.a.agn(8);
                AppMethodBeat.o(82713);
                return;
            }
            if (i2 != 0) {
                com.tencent.mm.plugin.webview.i.a.agn(9);
            }
            AppMethodBeat.o(82713);
        }
    }

    public static final class i implements Runnable {
        final /* synthetic */ n JzC;

        i(n nVar) {
            this.JzC = nVar;
        }

        public final void run() {
            AppMethodBeat.i(182679);
            n.g(this.JzC);
            Object systemService = this.JzC.getContext().getSystemService("input_method");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                AppMethodBeat.o(182679);
                throw tVar;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.JzC.Jzk, 0);
                AppMethodBeat.o(182679);
                return;
            }
            AppMethodBeat.o(182679);
        }
    }

    public final void a(fy fyVar) {
        AppMethodBeat.i(82741);
        p.h(fyVar, "req");
        fyVar.scene = this.scene;
        fyVar.KIL = this.pHw;
        fyVar.url = this.url;
        fyVar.title = this.title;
        fyVar.KJO = System.currentTimeMillis();
        fyVar.KIJ = this.iwc;
        fyVar.session_id = new StringBuilder().append(this.pHx).toString();
        fyVar.KIK = this.pHu;
        fyVar.KIM = this.iAH;
        d.a aVar = new d.a();
        aVar.c(fyVar);
        aVar.d(new fz());
        aVar.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
        aVar.sG(2617);
        aVar.sI(0);
        aVar.sJ(0);
        IPCRunCgi.a(aVar.aXF(), new e(this));
        WebViewUI webViewUI = this.JzA;
        p pVar = p.JAu;
        String string = getContext().getString(R.string.a06);
        p.g(string, "context.getString(R.string.app_waiting)");
        Context context = getContext();
        p.g(context, "context");
        webViewUI.a(p.a(string, context, this.JzA.gfk()));
        AppMethodBeat.o(82741);
    }

    public static final class e implements IPCRunCgi.a {
        final /* synthetic */ n JzC;

        e(n nVar) {
            this.JzC = nVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, final String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(82711);
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.e.AnonymousClass1 */
                final /* synthetic */ e JAd;

                {
                    this.JAd = r1;
                }

                public final void run() {
                    AppMethodBeat.i(82710);
                    p pVar = p.JAu;
                    p.b(this.JAd.JzC.getWebView().gfk());
                    if (this.JAd.JzC.getWeakThis$plugin_webview_release().get() != null) {
                        n nVar = this.JAd.JzC.getWeakThis$plugin_webview_release().get();
                        if (nVar == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
                            AppMethodBeat.o(82710);
                            throw tVar;
                        }
                        int i2 = i2;
                        int i3 = i3;
                        String str = str;
                        com.tencent.mm.ak.d dVar = dVar;
                        p.g(dVar, "rr");
                        n.a(nVar, i2, i3, str, dVar);
                    }
                    AppMethodBeat.o(82710);
                }
            });
            AppMethodBeat.o(82711);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d implements IPCRunCgi.a {
        final /* synthetic */ n JzC;

        d(n nVar) {
            this.JzC = nVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, final String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(175699);
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.n.d.AnonymousClass1 */
                final /* synthetic */ d JAc;

                {
                    this.JAc = r1;
                }

                public final void run() {
                    AppMethodBeat.i(175698);
                    p pVar = p.JAu;
                    p.b(this.JAc.JzC.getWebView().gfk());
                    if (this.JAc.JzC.getWeakThis$plugin_webview_release().get() != null) {
                        n nVar = this.JAc.JzC.getWeakThis$plugin_webview_release().get();
                        if (nVar == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
                            AppMethodBeat.o(175698);
                            throw tVar;
                        }
                        int i2 = i2;
                        int i3 = i3;
                        String str = str;
                        com.tencent.mm.ak.d dVar = dVar;
                        p.g(dVar, "rr");
                        n.b(nVar, i2, i3, str, dVar);
                    }
                    AppMethodBeat.o(175698);
                }
            });
            AppMethodBeat.o(175699);
        }
    }

    public static /* synthetic */ void a(n nVar, String str, int i2) {
        AppMethodBeat.i(175706);
        nVar.x(str, i2, false);
        AppMethodBeat.o(175706);
    }

    public final void x(String str, int i2, boolean z) {
        AppMethodBeat.i(175705);
        p.h(str, "replyContent");
        this.Jzt = i2;
        this.Jzo.setText(getContext().getString(R.string.agw));
        this.Jzp.setVisibility(0);
        TextView textView = this.Jzp;
        Context context = getContext();
        Object[] objArr = new Object[1];
        if (Util.isNullOrNil(str)) {
            str = "";
        }
        objArr[0] = str;
        textView.setText(context.getString(R.string.agv, objArr));
        this.Jzk.setHint(getContext().getString(R.string.agu));
        if (z) {
            this.Jzm.scrollTo(0, 0);
            this.Jzk.requestFocus();
            Object systemService = getContext().getSystemService("input_method");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                AppMethodBeat.o(175705);
                throw tVar;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.Jzk, 0);
                AppMethodBeat.o(175705);
                return;
            }
        }
        AppMethodBeat.o(175705);
    }

    public final void zy(boolean z) {
        AppMethodBeat.i(175707);
        if (this.Jzt != 0) {
            this.Jzt = 0;
            if (z) {
                ahg(KeyBoardUtil.getScreenOrientation(getContext()));
            }
        }
        this.Jzp.setText("");
        this.Jzp.setVisibility(8);
        this.Jzk.setHint(getContext().getString(R.string.ajt));
        this.Jzo.setText(getContext().getString(R.string.ajr));
        AppMethodBeat.o(175707);
    }

    private final int getReplyHeight() {
        AppMethodBeat.i(182681);
        if (this.Jzt != 0) {
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 38);
            AppMethodBeat.o(182681);
            return fromDPToPix;
        }
        AppMethodBeat.o(182681);
        return 0;
    }

    public final boolean giC() {
        boolean z;
        AppMethodBeat.i(175708);
        if (!this.Jzy) {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_comment_reply, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.Jzz = z;
            this.Jzy = true;
            Log.v(TAG, "isReplyOpen = " + this.Jzz);
        }
        boolean z2 = this.Jzz;
        AppMethodBeat.o(175708);
        return z2;
    }

    public static final class b extends BaseAdapter {
        private static com.tencent.mm.av.a.a.c JzH = new c.a().tz(R.color.j6).bdp().dr(120, 120).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).bdt().aw((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3)).bdv();
        public static final c JzI = new c((byte) 0);
        static final String TAG = TAG;
        final ArrayList<View> JzE = new ArrayList<>();
        n JzF;
        private boolean JzG;
        private final Context context;
        final LinkedList<of> gCs;

        static final class g extends q implements kotlin.g.a.b<Integer, Boolean> {
            final /* synthetic */ b JzR;
            final /* synthetic */ of JzX;
            final /* synthetic */ a JzZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(b bVar, a aVar, of ofVar) {
                super(1);
                this.JzR = bVar;
                this.JzZ = aVar;
                this.JzX = ofVar;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(Integer num) {
                boolean z;
                AppMethodBeat.i(175695);
                if (num.intValue() != 0) {
                    NeatTextView neatTextView = this.JzZ.JzJ;
                    p.g(neatTextView, "itemView.desc");
                    neatTextView.setVisibility(8);
                    WeImageView weImageView = this.JzZ.JzK;
                    p.g(weImageView, "itemView.deleteIv");
                    weImageView.setVisibility(8);
                    ImageView imageView = this.JzZ.JzL;
                    p.g(imageView, "itemView.deleteSplit");
                    imageView.setVisibility(8);
                    TextView textView = this.JzZ.hPG;
                    p.g(textView, "itemView.likeTv");
                    textView.setVisibility(8);
                    TextView textView2 = this.JzZ.qbF;
                    p.g(textView2, "itemView.nickName");
                    TextView textView3 = this.JzZ.qbF;
                    p.g(textView3, "itemView.nickName");
                    textView2.setText(l.b(this.JzR.context, this.JzX.qFU, textView3.getTextSize()));
                    TextView textView4 = this.JzZ.JzN;
                    p.g(textView4, "itemView.replyDelete");
                    textView4.setVisibility(0);
                    TextView textView5 = this.JzZ.JzO;
                    p.g(textView5, "itemView.notChosen");
                    textView5.setVisibility(8);
                    ImageView imageView2 = this.JzZ.JzM;
                    p.g(imageView2, "itemView.likeThumb");
                    imageView2.setVisibility(8);
                    z = true;
                } else {
                    NeatTextView neatTextView2 = this.JzZ.JzJ;
                    p.g(neatTextView2, "itemView.desc");
                    neatTextView2.setVisibility(0);
                    TextView textView6 = this.JzZ.JzN;
                    p.g(textView6, "itemView.replyDelete");
                    textView6.setVisibility(8);
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(175695);
                return valueOf;
            }
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(82705);
            of ahk = ahk(i2);
            AppMethodBeat.o(82705);
            return ahk;
        }

        public b(Context context2, LinkedList<of> linkedList, n nVar, boolean z) {
            p.h(context2, "context");
            p.h(linkedList, "list");
            p.h(nVar, "controller");
            AppMethodBeat.i(162324);
            this.context = context2;
            this.gCs = linkedList;
            this.JzF = nVar;
            this.JzG = z;
            AppMethodBeat.o(162324);
        }

        public static final class c {
            private c() {
            }

            public /* synthetic */ c(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(82709);
            AppMethodBeat.o(82709);
        }

        public final void clear() {
            AppMethodBeat.i(82703);
            this.gCs.clear();
            notifyDataSetChanged();
            AppMethodBeat.o(82703);
        }

        private of ahk(int i2) {
            AppMethodBeat.i(82704);
            of ofVar = (of) kotlin.a.j.L(this.gCs, i2);
            AppMethodBeat.o(82704);
            return ofVar;
        }

        public final int getCount() {
            AppMethodBeat.i(82706);
            int size = this.gCs.size();
            AppMethodBeat.o(82706);
            return size;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2004b bVar;
            View inflate;
            int i3;
            AppMethodBeat.i(82707);
            p.h(viewGroup, "viewGroup");
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.layout.bbn, (ViewGroup) null, false);
                p.g(view, "convertView");
                C2004b bVar2 = new C2004b(this, view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout.MPMyCommentItemAdapter.BizCommentViewHolder");
                    AppMethodBeat.o(82707);
                    throw tVar;
                }
                bVar = (C2004b) tag;
            }
            of ahk = ahk(i2);
            if (ahk != null) {
                p.h(ahk, "info");
                com.tencent.mm.av.a.a.bdb().a(ahk.iwv, bVar.keC, JzH);
                b bVar3 = bVar.JzR;
                a aVar = bVar.JzU;
                p.h(aVar, "itemView");
                if (ahk != null) {
                    TextView textView = aVar.qbF;
                    p.g(textView, "itemView.nickName");
                    SpannableString b2 = l.b(bVar3.context, ahk.qFU, textView.getTextSize());
                    TextView textView2 = aVar.qbF;
                    p.g(textView2, "itemView.nickName");
                    textView2.setText(b2);
                    NeatTextView neatTextView = aVar.JzJ;
                    p.g(neatTextView, "itemView.desc");
                    aVar.JzJ.aw(l.b(bVar3.context, ahk.content, neatTextView.getTextSize()));
                    aVar.JzK.setIconColor(bVar3.context.getResources().getColor(R.color.Link));
                    WeImageView weImageView = aVar.JzK;
                    p.g(weImageView, "itemView.deleteIv");
                    weImageView.setVisibility(0);
                    ImageView imageView = aVar.JzL;
                    p.g(imageView, "itemView.deleteSplit");
                    imageView.setVisibility(0);
                    aVar.JzK.setOnClickListener(new e(bVar3, ahk));
                    bVar3.a(aVar, ahk, null, false);
                    ImageView imageView2 = aVar.JzP;
                    p.g(imageView2, "itemView.replyPrefix");
                    imageView2.setVisibility(8);
                    ImageView imageView3 = aVar.JzQ;
                    p.g(imageView3, "itemView.sameReplyPrefix");
                    imageView3.setVisibility(4);
                }
                TextView textView3 = bVar.JzV;
                p.g(textView3, "txtReply");
                textView3.setVisibility(8);
                if (n.a(bVar.JzR.JzF)) {
                    TextView textView4 = bVar.JzV;
                    p.g(textView4, "txtReply");
                    textView4.setVisibility(0);
                    bVar.JzV.setOnClickListener(new C2004b.a(bVar, ahk));
                    for (T t : bVar.hXy) {
                        if (t != null) {
                            bVar.EAe.removeView(t);
                            bVar.JzR.JzE.add(t);
                        }
                    }
                    bVar.hXy.clear();
                    if (!(ahk.KTJ == null || ahk.KTJ.LmP == null || ahk.KTJ.LmP.size() <= 0)) {
                        LinkedList<ace> linkedList = ahk.KTJ.LmP;
                        p.g(linkedList, "replyList");
                        int i4 = 0;
                        for (T t2 : linkedList) {
                            int i5 = i4 + 1;
                            if (i4 < 0) {
                                kotlin.a.j.hxH();
                            }
                            T t3 = t2;
                            b bVar4 = bVar.JzR;
                            if (bVar4.JzE.size() > 0) {
                                View remove = bVar4.JzE.remove(0);
                                p.g(remove, "viewPool.removeAt(0)");
                                inflate = remove;
                            } else {
                                inflate = View.inflate(bVar4.context, R.layout.bbm, null);
                                p.g(inflate, "View.inflate(context, R.…mment_content_item, null)");
                            }
                            bVar.hXy.add(inflate);
                            bVar.EAe.addView(inflate);
                            b bVar5 = bVar.JzR;
                            p.g(t3, "reply");
                            a aVar2 = new a(bVar.JzR, inflate);
                            p.h(t3, "reply");
                            p.h(aVar2, "itemView");
                            if (ahk != null) {
                                g gVar = new g(bVar5, aVar2, ahk);
                                if (p.j(ahk.openid, t3.openid)) {
                                    if (!((Boolean) gVar.invoke(Integer.valueOf(t3.LmO))).booleanValue()) {
                                        TextView textView5 = aVar2.qbF;
                                        p.g(textView5, "itemView.nickName");
                                        TextView textView6 = aVar2.qbF;
                                        p.g(textView6, "itemView.nickName");
                                        textView5.setText(l.b(bVar5.context, ahk.qFU, textView6.getTextSize()));
                                        NeatTextView neatTextView2 = aVar2.JzJ;
                                        NeatTextView neatTextView3 = aVar2.JzJ;
                                        p.g(neatTextView3, "itemView.desc");
                                        neatTextView2.aw(l.b(bVar5.context, t3.content, neatTextView3.getTextSize()));
                                        aVar2.JzK.setIconColor(bVar5.context.getResources().getColor(R.color.Link));
                                        WeImageView weImageView2 = aVar2.JzK;
                                        p.g(weImageView2, "itemView.deleteIv");
                                        weImageView2.setVisibility(0);
                                        ImageView imageView4 = aVar2.JzL;
                                        p.g(imageView4, "itemView.deleteSplit");
                                        imageView4.setVisibility(0);
                                        bVar5.a(aVar2, ahk, t3, true);
                                        aVar2.JzK.setOnClickListener(new f(bVar5, ahk, t3));
                                    }
                                } else if (!((Boolean) gVar.invoke(Integer.valueOf(t3.LmO))).booleanValue()) {
                                    TextView textView7 = aVar2.qbF;
                                    p.g(textView7, "itemView.nickName");
                                    TextView textView8 = aVar2.qbF;
                                    p.g(textView8, "itemView.nickName");
                                    textView7.setText(l.b(bVar5.context, bVar5.context.getResources().getString(R.string.f3n), textView8.getTextSize()));
                                    NeatTextView neatTextView4 = aVar2.JzJ;
                                    NeatTextView neatTextView5 = aVar2.JzJ;
                                    p.g(neatTextView5, "itemView.desc");
                                    neatTextView4.aw(l.b(bVar5.context, t3.content, neatTextView5.getTextSize()));
                                    WeImageView weImageView3 = aVar2.JzK;
                                    p.g(weImageView3, "itemView.deleteIv");
                                    weImageView3.setVisibility(8);
                                    ImageView imageView5 = aVar2.JzL;
                                    p.g(imageView5, "itemView.deleteSplit");
                                    imageView5.setVisibility(8);
                                    bVar5.a(aVar2, ahk, t3, true);
                                }
                                ImageView imageView6 = aVar2.JzP;
                                p.g(imageView6, "itemView.replyPrefix");
                                imageView6.setVisibility(0);
                                ImageView imageView7 = aVar2.JzQ;
                                p.g(imageView7, "itemView.sameReplyPrefix");
                                imageView7.setVisibility(4);
                                if (i4 + 1 < ahk.KTJ.LmP.size()) {
                                    ImageView imageView8 = aVar2.JzQ;
                                    p.g(imageView8, "itemView.sameReplyPrefix");
                                    if (p.j(t3.openid, ahk.KTJ.LmP.get(i4 + 1).openid)) {
                                        i3 = 0;
                                    } else {
                                        i3 = 4;
                                    }
                                    imageView8.setVisibility(i3);
                                }
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                    }
                }
            }
            if (i2 == getCount() - 1) {
                LinearLayout linearLayout = bVar.JzT;
                p.g(linearLayout, "holder.endlineLayout");
                linearLayout.setVisibility(0);
                this.JzF.getAppMsgCommentList();
            } else {
                LinearLayout linearLayout2 = bVar.JzT;
                p.g(linearLayout2, "holder.endlineLayout");
                linearLayout2.setVisibility(8);
            }
            AppMethodBeat.o(82707);
            return view;
        }

        public final class a {
            NeatTextView JzJ;
            WeImageView JzK;
            final ImageView JzL;
            final ImageView JzM;
            final TextView JzN;
            final TextView JzO;
            final ImageView JzP;
            final ImageView JzQ;
            final /* synthetic */ b JzR;
            TextView hPG;
            TextView qbF;

            public a(b bVar, View view) {
                p.h(view, "itemView");
                this.JzR = bVar;
                AppMethodBeat.i(82699);
                this.qbF = (TextView) view.findViewById(R.id.a9i);
                this.hPG = (TextView) view.findViewById(R.id.a9h);
                this.JzJ = (NeatTextView) view.findViewById(R.id.a9e);
                this.JzK = (WeImageView) view.findViewById(R.id.a9f);
                this.JzL = (ImageView) view.findViewById(R.id.a55);
                this.JzM = (ImageView) view.findViewById(R.id.a57);
                this.JzN = (TextView) view.findViewById(R.id.a5_);
                this.JzO = (TextView) view.findViewById(R.id.a58);
                this.JzP = (ImageView) view.findViewById(R.id.a70);
                this.JzQ = (ImageView) view.findViewById(R.id.a71);
                Context context = view.getContext();
                NeatTextView neatTextView = this.JzJ;
                p.g(context, "context");
                neatTextView.setTextColor(o.e(R.attr.h4, context));
                AppMethodBeat.o(82699);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.n$b$b */
        public final class C2004b {
            final LinearLayout EAe;
            final /* synthetic */ b JzR;
            private LinearLayout JzS;
            LinearLayout JzT;
            a JzU;
            final TextView JzV;
            final ArrayList<View> hXy = new ArrayList<>();
            final ImageView keC;

            public C2004b(b bVar, View view) {
                p.h(view, "itemView");
                this.JzR = bVar;
                AppMethodBeat.i(82700);
                this.keC = (ImageView) view.findViewById(R.id.a9a);
                this.EAe = (LinearLayout) view.findViewById(R.id.a9d);
                this.JzS = (LinearLayout) view.findViewById(R.id.a9p);
                this.JzT = (LinearLayout) view.findViewById(R.id.c3r);
                LinearLayout linearLayout = this.JzS;
                p.g(linearLayout, "fansLayout");
                this.JzU = new a(bVar, linearLayout);
                this.JzV = (TextView) view.findViewById(R.id.a59);
                AppMethodBeat.o(82700);
            }

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.n$b$b$a */
            static final class a implements View.OnClickListener {
                final /* synthetic */ C2004b JzW;
                final /* synthetic */ of JzX;

                a(C2004b bVar, of ofVar) {
                    this.JzW = bVar;
                    this.JzX = ofVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(175691);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.JzW.JzR.JzF.xV(3);
                    this.JzW.JzR.JzF.x(b.a(this.JzX), this.JzX.KJJ, true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(175691);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public static final class e implements View.OnClickListener {
            final /* synthetic */ b JzR;
            final /* synthetic */ of JzX;

            e(b bVar, of ofVar) {
                this.JzR = bVar;
                this.JzX = ofVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82702);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                new d.a(this.JzR.context).bon(this.JzR.context.getString(R.string.aja)).boo("").aoX(this.JzR.context.getResources().getColor(R.color.Red_100)).aoV(R.string.tf).c(new a(this)).aoW(R.string.amc).hbn().show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82702);
            }

            static final class a implements DialogInterface.OnClickListener {
                final /* synthetic */ e JAa;

                a(e eVar) {
                    this.JAa = eVar;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(82701);
                    fy fyVar = new fy();
                    fyVar.KJJ = this.JAa.JzX.KJJ;
                    fyVar.pTI = 2;
                    this.JAa.JzR.JzF.a(fyVar);
                    com.tencent.mm.plugin.webview.i.a.agn(13);
                    AppMethodBeat.o(82701);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public static final class f implements View.OnClickListener {
            final /* synthetic */ b JzR;
            final /* synthetic */ of JzX;
            final /* synthetic */ ace JzY;

            f(b bVar, of ofVar, ace ace) {
                this.JzR = bVar;
                this.JzX = ofVar;
                this.JzY = ace;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(175694);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                new d.a(this.JzR.context).bon(this.JzR.context.getString(R.string.ags)).boo("").aoX(this.JzR.context.getResources().getColor(R.color.Red_100)).aoV(R.string.tf).c(new a(this)).aoW(R.string.amc).hbn().show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(175694);
            }

            static final class a implements DialogInterface.OnClickListener {
                final /* synthetic */ f JAb;

                a(f fVar) {
                    this.JAb = fVar;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(175693);
                    fy fyVar = new fy();
                    fyVar.KJJ = this.JAb.JzX.KJJ;
                    fyVar.KJL = this.JAb.JzY.KJL;
                    fyVar.pTI = 4;
                    this.JAb.JzR.JzF.a(fyVar);
                    com.tencent.mm.plugin.webview.i.a.agn(13);
                    AppMethodBeat.o(175693);
                }
            }
        }

        private void a(a aVar, of ofVar, ace ace, boolean z) {
            String str;
            int i2;
            AppMethodBeat.i(175697);
            p.h(aVar, "itemView");
            p.h(ofVar, "info");
            Integer valueOf = z ? ace != null ? Integer.valueOf(ace.LmN) : null : Integer.valueOf(ofVar.KTI);
            Integer valueOf2 = z ? ace != null ? Integer.valueOf(ace.LmL) : null : Integer.valueOf(ofVar.KSR);
            Integer valueOf3 = z ? ace != null ? Integer.valueOf(ace.LmM) : null : Integer.valueOf(ofVar.KSS);
            String str2 = TAG;
            StringBuilder sb = new StringBuilder("showLikeStatus content = ");
            if (!z) {
                str = ofVar.content;
            } else if (ace != null) {
                str = ace.content;
            } else {
                str = null;
            }
            Log.v(str2, sb.append(str).append(", isElected = ").append(valueOf).append(", likeNum = ").append(valueOf2).append(", likeStatus = ").append(valueOf3).toString());
            aVar.JzM.setOnClickListener(null);
            if (valueOf != null && valueOf.intValue() == 0) {
                TextView textView = aVar.JzO;
                p.g(textView, "itemView.notChosen");
                textView.setVisibility(0);
                ImageView imageView = aVar.JzM;
                p.g(imageView, "itemView.likeThumb");
                imageView.setVisibility(8);
                TextView textView2 = aVar.hPG;
                p.g(textView2, "itemView.likeTv");
                textView2.setVisibility(8);
                AppMethodBeat.o(175697);
                return;
            }
            TextView textView3 = aVar.JzO;
            p.g(textView3, "itemView.notChosen");
            textView3.setVisibility(8);
            ImageView imageView2 = aVar.JzM;
            p.g(imageView2, "itemView.likeThumb");
            imageView2.setVisibility(0);
            TextView textView4 = aVar.hPG;
            p.g(textView4, "itemView.likeTv");
            textView4.setVisibility(8);
            if (valueOf2 != null) {
                TextView textView5 = aVar.hPG;
                p.g(textView5, "itemView.likeTv");
                if (valueOf2.intValue() > 0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                textView5.setVisibility(i2);
                aVar.hPG.setText(String.valueOf(valueOf2.intValue()));
            }
            if (valueOf3 != null && valueOf3.intValue() == 0) {
                aVar.JzM.setImageResource(R.raw.approve_default);
            } else {
                aVar.JzM.setImageResource(R.raw.approve_highlight);
            }
            aVar.JzM.setOnClickListener(new d(this, z, ace, ofVar, aVar));
            AppMethodBeat.o(175697);
        }

        public static final class d implements View.OnClickListener {
            final /* synthetic */ boolean FDi;
            final /* synthetic */ b JzR;
            final /* synthetic */ of JzX;
            final /* synthetic */ ace JzY;
            final /* synthetic */ a JzZ;

            d(b bVar, boolean z, ace ace, of ofVar, a aVar) {
                this.JzR = bVar;
                this.FDi = z;
                this.JzY = ace;
                this.JzX = ofVar;
                this.JzZ = aVar;
            }

            public final void onClick(View view) {
                int i2;
                Integer valueOf;
                int i3;
                int i4;
                Integer num;
                AppMethodBeat.i(175692);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.JzR.JzF.Jzk.clearFocus();
                if (this.FDi) {
                    ace ace = this.JzY;
                    Integer valueOf2 = ace != null ? Integer.valueOf(ace.LmL) : null;
                    if (valueOf2 == null) {
                        p.hyc();
                    }
                    i2 = valueOf2.intValue();
                } else {
                    i2 = this.JzX.KSR;
                }
                if (this.FDi) {
                    ace ace2 = this.JzY;
                    valueOf = ace2 != null ? Integer.valueOf(ace2.LmM) : null;
                } else {
                    valueOf = Integer.valueOf(this.JzX.KSS);
                }
                if (valueOf != null && valueOf.intValue() == 0) {
                    this.JzZ.JzM.setImageResource(R.raw.approve_highlight);
                    i3 = i2 + 1;
                } else {
                    this.JzZ.JzM.setImageResource(R.raw.approve_default);
                    i3 = i2 - 1;
                }
                if (i3 < 0) {
                    i4 = 0;
                } else {
                    i4 = i3;
                }
                this.JzZ.hPG.setText(String.valueOf(i4));
                TextView textView = this.JzZ.hPG;
                p.g(textView, "itemView.likeTv");
                textView.setVisibility(i4 > 0 ? 0 : 8);
                fu fuVar = new fu();
                fuVar.KJJ = this.JzX.KJJ;
                fuVar.openid = this.JzX.openid;
                fuVar.pTI = 1;
                if (this.FDi) {
                    ace ace3 = this.JzY;
                    if (ace3 != null) {
                        num = Integer.valueOf(ace3.KJL);
                    } else {
                        num = null;
                    }
                    if (num == null) {
                        p.hyc();
                    }
                    fuVar.KJL = num.intValue();
                    fuVar.pTI = 2;
                }
                fuVar.KJK = (valueOf != null && valueOf.intValue() == 0) ? 1 : 0;
                n nVar = this.JzR.JzF;
                p.h(fuVar, "req");
                fuVar.scene = nVar.scene;
                fuVar.KIL = nVar.pHw;
                fuVar.url = nVar.url;
                fuVar.KIJ = nVar.iwc;
                fuVar.session_id = new StringBuilder().append(nVar.pHx).toString();
                fuVar.KIK = nVar.pHu;
                d.a aVar = new d.a();
                aVar.c(fuVar);
                aVar.d(new fv());
                aVar.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
                aVar.sG(2759);
                aVar.sI(0);
                aVar.sJ(0);
                IPCRunCgi.a(aVar.aXF(), new d(nVar));
                Integer num2 = (valueOf != null && valueOf.intValue() == 0) ? 1 : 0;
                if (this.FDi) {
                    ace ace4 = this.JzY;
                    if (ace4 != null) {
                        ace4.LmM = num2.intValue();
                    }
                    ace ace5 = this.JzY;
                    if (ace5 != null) {
                        ace5.LmL = i4;
                    }
                } else {
                    this.JzX.KSS = num2.intValue();
                    this.JzX.KSR = i4;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(175692);
            }
        }

        public static String a(of ofVar) {
            String str;
            AppMethodBeat.i(182678);
            p.h(ofVar, "info");
            String str2 = ofVar.content;
            if (ofVar.KTJ != null && !Util.isNullOrNil(ofVar.KTJ.LmP)) {
                int size = ofVar.KTJ.LmP.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (ofVar.KTJ.LmP.get(size).LmO == 0) {
                        str = ofVar.KTJ.LmP.get(size).content;
                        break;
                    } else {
                        size--;
                    }
                }
            }
            str = str2;
            p.g(str, "reply");
            AppMethodBeat.o(182678);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j extends q implements kotlin.g.a.a<MPSmileyFooter> {
        final /* synthetic */ n JzC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(n nVar) {
            super(0);
            this.JzC = nVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ MPSmileyFooter invoke() {
            AppMethodBeat.i(82718);
            View findViewById = this.JzC.findViewById(R.id.fli);
            MPSmileyFooter mPSmileyFooter = (MPSmileyFooter) findViewById;
            mPSmileyFooter.setExtraAddHeight(n.h(this.JzC));
            mPSmileyFooter.setFobbidenWhenLandscape(true);
            mPSmileyFooter.init(this.JzC.dZO);
            MPSmileyFooter mPSmileyFooter2 = (MPSmileyFooter) findViewById;
            AppMethodBeat.o(82718);
            return mPSmileyFooter2;
        }
    }

    public final void xV(int i2) {
        AppMethodBeat.i(175709);
        String queryParameter = Uri.parse(this.url).getQueryParameter("clicktime");
        StringBuilder sb = new StringBuilder();
        sb.append(this.url);
        sb.append(",");
        sb.append(this.scene);
        sb.append(",");
        if (Util.isNullOrNil(queryParameter)) {
            queryParameter = "";
        }
        sb.append(queryParameter);
        sb.append(",");
        sb.append(i2);
        sb.append(",");
        sb.append(System.currentTimeMillis());
        String sb2 = sb.toString();
        Log.v(TAG, sb2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(19265, sb2);
        AppMethodBeat.o(175709);
    }

    public static final /* synthetic */ void a(n nVar, int i2) {
        AppMethodBeat.i(82743);
        if (i2 > 0 && KeyBoardUtil.getScreenOrientation(nVar.getContext()) != 2) {
            nVar.ahh(i2);
        }
        AppMethodBeat.o(82743);
    }

    public static final /* synthetic */ void a(n nVar, com.tencent.mm.ak.d dVar) {
        int i2;
        boolean z;
        AppMethodBeat.i(82746);
        if (!(dVar.aYJ() instanceof fl) || !(dVar.aYK() instanceof fm)) {
            AppMethodBeat.o(82746);
            return;
        }
        com.tencent.mm.bw.a aYJ = dVar.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListReq");
            AppMethodBeat.o(82746);
            throw tVar;
        }
        fl flVar = (fl) aYJ;
        com.tencent.mm.bw.a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListResp");
            AppMethodBeat.o(82746);
            throw tVar2;
        }
        fm fmVar = (fm) aYK;
        String str = TAG;
        StringBuilder sb = new StringBuilder("url_info size is ");
        if (fmVar.KIN != null) {
            LinkedList<of> linkedList = fmVar.KIN;
            if (linkedList == null) {
                p.hyc();
            }
            i2 = linkedList.size();
        } else {
            i2 = 0;
        }
        Log.i(str, sb.append(i2).toString());
        if (flVar.pTI == 2) {
            int i3 = nVar.Jzx;
            nVar.Jzx = fmVar.qGg;
            if (i3 == 0) {
                z = true;
            } else {
                z = false;
            }
            p.h(fmVar, "resp");
            if (!nVar.Jzr) {
                if (Util.isNullOrNil(fmVar.KIN)) {
                    nVar.gix();
                } else {
                    nVar.Jzm.setBackgroundColor(nVar.getResources().getColor(R.color.BW_97));
                    nVar.Jzn.setVisibility(0);
                    if (nVar.Jzq == null) {
                        Context context = nVar.getContext();
                        p.g(context, "context");
                        LinkedList<of> linkedList2 = fmVar.KIN;
                        p.g(linkedList2, "resp.comment");
                        nVar.Jzq = new b(context, linkedList2, nVar, nVar.dZO);
                        nVar.Jzl.setAdapter((ListAdapter) nVar.Jzq);
                    } else {
                        b bVar = nVar.Jzq;
                        if (bVar != null) {
                            LinkedList<of> linkedList3 = fmVar.KIN;
                            p.g(linkedList3, "resp.comment");
                            LinkedList<of> linkedList4 = linkedList3;
                            p.h(linkedList4, "items");
                            Log.i(b.TAG, "update: " + linkedList4.size());
                            if (z) {
                                bVar.gCs.clear();
                                bVar.gCs.addAll(linkedList4);
                            } else {
                                bVar.gCs.addAll(linkedList4);
                            }
                            bVar.notifyDataSetChanged();
                        }
                    }
                }
            }
            if (fmVar.KIN == null || fmVar.KIN.size() <= 0 || nVar.Jzt != 0) {
                nVar.postDelayed(new i(nVar), 10);
            }
        }
        AppMethodBeat.o(82746);
    }

    public static final /* synthetic */ void g(n nVar) {
        AppMethodBeat.i(82745);
        nVar.Jzk.requestFocus();
        Log.d(TAG, "request fouces");
        if (nVar.getSayFooter().fjI()) {
            nVar.getSayFooter().fjJ();
        }
        if (!KeyBoardUtil.isPortOrientation(nVar.getContext())) {
            nVar.getSayFooter().giv();
        }
        nVar.gvQ.postInvalidate();
        AppMethodBeat.o(82745);
    }

    public static final /* synthetic */ void a(n nVar, int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        boolean z = false;
        AppMethodBeat.i(82747);
        if (i3 == 0 || Util.isNullOrNil(str)) {
            com.tencent.mm.bw.a aYJ = dVar.aYJ();
            if (aYJ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgOperateCommentReq");
                AppMethodBeat.o(82747);
                throw tVar;
            }
            fy fyVar = (fy) aYJ;
            if (i2 == 0 && i3 == 0) {
                switch (fyVar.pTI) {
                    case 1:
                        u.cG(nVar.getContext(), nVar.getContext().getString(R.string.aju));
                        nVar.giz();
                        break;
                    case 2:
                    default:
                        p.h(fyVar, "req");
                        b bVar = nVar.Jzq;
                        if (bVar != null) {
                            p.h(fyVar, "req");
                            Iterator<of> it = bVar.gCs.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    of next = it.next();
                                    if (fyVar.KJJ == next.KJJ) {
                                        str5 = next.openid;
                                        bVar.gCs.remove(next);
                                        bVar.notifyDataSetChanged();
                                    }
                                }
                            }
                            str4 = str5;
                        } else {
                            str4 = null;
                        }
                        b bVar2 = nVar.Jzq;
                        if (bVar2 != null && bVar2.getCount() == 0) {
                            nVar.gix();
                        }
                        com.tencent.mm.plugin.webview.d.h hVar = nVar.JzA.IBw;
                        if (hVar != null) {
                            hVar.a("deleteComment", fyVar.KJJ, str4, 0, 0);
                        }
                        nVar.zy(true);
                        break;
                    case 3:
                        u.cG(nVar.getContext(), nVar.getContext().getString(R.string.ajv));
                        nVar.zy(true);
                        nVar.giz();
                        break;
                    case 4:
                        p.h(fyVar, "req");
                        b bVar3 = nVar.Jzq;
                        if (bVar3 != null) {
                            p.h(fyVar, "req");
                            Iterator<of> it2 = bVar3.gCs.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    of next2 = it2.next();
                                    if (fyVar.KJJ == next2.KJJ) {
                                        String str6 = next2.openid;
                                        LinkedList<ace> linkedList = next2.KTJ.LmP;
                                        p.g(linkedList, "comment.reply.reply_list");
                                        for (T t : linkedList) {
                                            if (t.KJL == fyVar.KJL) {
                                                t.LmO = 1;
                                            }
                                        }
                                        str3 = str6;
                                    }
                                } else {
                                    str3 = null;
                                }
                            }
                            bVar3.notifyDataSetChanged();
                            str2 = str3;
                        } else {
                            str2 = null;
                        }
                        b bVar4 = nVar.Jzq;
                        if (bVar4 != null && bVar4.getCount() == 0) {
                            nVar.gix();
                        }
                        com.tencent.mm.plugin.webview.d.h hVar2 = nVar.JzA.IBw;
                        if (hVar2 != null) {
                            hVar2.a("deleteCommentReply", fyVar.KJJ, str2, fyVar.KJL, 0);
                        }
                        nVar.zy(true);
                        break;
                }
                nVar.Jzk.clearFocus();
                AppMethodBeat.o(82747);
            } else if (fyVar.pTI == 1) {
                com.tencent.mm.ui.base.h.cA(nVar.getContext(), nVar.getContext().getString(R.string.ajs, Integer.valueOf(i3)));
                if (i2 == 2) {
                    com.tencent.mm.plugin.webview.i.a.agn(11);
                    AppMethodBeat.o(82747);
                    return;
                }
                com.tencent.mm.plugin.webview.i.a.agn(12);
                AppMethodBeat.o(82747);
            } else {
                com.tencent.mm.ui.base.h.cA(nVar.getContext(), nVar.getContext().getString(R.string.ajb, Integer.valueOf(i3)));
                if (i2 == 2) {
                    com.tencent.mm.plugin.webview.i.a.agn(14);
                    AppMethodBeat.o(82747);
                    return;
                }
                com.tencent.mm.plugin.webview.i.a.agn(15);
                AppMethodBeat.o(82747);
            }
        } else {
            com.tencent.mm.ui.base.h.a(nVar.getContext(), str, "", nVar.getContext().getString(R.string.x_), (DialogInterface.OnClickListener) null);
            Button button = nVar.Jzj;
            if (i3 != 60005) {
                z = true;
            }
            button.setEnabled(z);
            AppMethodBeat.o(82747);
        }
    }

    public static final /* synthetic */ void b(n nVar, int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
        AppMethodBeat.i(177712);
        if (i3 == 0 || Util.isNullOrNil(str)) {
            com.tencent.mm.bw.a aYJ = dVar.aYJ();
            if (aYJ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgLikeCommentReq");
                AppMethodBeat.o(177712);
                throw tVar;
            }
            fu fuVar = (fu) aYJ;
            if (i2 == 0 && i3 == 0) {
                switch (fuVar.pTI) {
                    case 1:
                        com.tencent.mm.plugin.webview.d.h hVar = nVar.JzA.IBw;
                        if (hVar != null) {
                            hVar.a("praiseComment", fuVar.KJJ, "", 0, fuVar.KJK);
                            AppMethodBeat.o(177712);
                            return;
                        }
                        AppMethodBeat.o(177712);
                        return;
                    case 2:
                        com.tencent.mm.plugin.webview.d.h hVar2 = nVar.JzA.IBw;
                        if (hVar2 != null) {
                            hVar2.a("praiseComment", fuVar.KJJ, "", fuVar.KJL, fuVar.KJK);
                            AppMethodBeat.o(177712);
                            return;
                        }
                        break;
                }
            }
            AppMethodBeat.o(177712);
            return;
        }
        com.tencent.mm.ui.base.h.a(nVar.getContext(), str, "", nVar.getContext().getString(R.string.x_), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(177712);
    }
}
