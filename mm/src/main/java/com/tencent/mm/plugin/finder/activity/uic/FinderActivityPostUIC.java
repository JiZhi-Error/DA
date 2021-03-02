package com.tencent.mm.plugin.finder.activity.uic;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.cgi.cc;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020?H\u0002J\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020?H\u0002J\u0014\u0010D\u001a\u00020?2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0002J\b\u0010G\u001a\u00020\bH\u0002J\u0010\u0010H\u001a\u00020?2\u0006\u0010,\u001a\u00020\bH\u0003J\b\u0010I\u001a\u00020?H\u0002J\b\u0010J\u001a\u00020?H\u0002J\u0012\u0010K\u001a\u00020?2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020?H\u0016J\u0010\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\u0018H\u0002J\u0018\u0010Q\u001a\u00020?2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020&H\u0016J\b\u0010T\u001a\u00020?H\u0016J\b\u0010U\u001a\u00020?H\u0016J,\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\b2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010\\\u001a\u00020?2\b\b\u0002\u0010]\u001a\u00020&H\u0002J\u0006\u0010^\u001a\u00020?J\u0006\u0010_\u001a\u00020?J\u0010\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020\u000bH\u0002J\u001a\u0010b\u001a\u00020?2\u0006\u0010c\u001a\u00020&2\b\b\u0002\u0010X\u001a\u00020\u000bH\u0002J\b\u0010d\u001a\u00020?H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR#\u0010!\u001a\n \u001c*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b3\u0010 \u001a\u0004\b1\u00102R\u001b\u00104\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b6\u0010 \u001a\u0004\b5\u00102R\u000e\u00107\u001a\u000208X.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "activityDesc", "", "activityName", "activityType", "", "announceTv", "Landroid/widget/TextView;", "avatarImage", "Landroid/widget/ImageView;", "cancelBtn", "cndCoverUrl", "descEdit", "Lcom/tencent/mm/ui/widget/MMEditText;", "descMaxPaddingBottom", "descMinPaddingBottom", "descWordHintText", "endTime", "", "endTimeContent", "errorTipsLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getErrorTipsLayout", "()Landroid/view/View;", "errorTipsLayout$delegate", "Lkotlin/Lazy;", "errorTipsTextView", "getErrorTipsTextView", "()Landroid/widget/TextView;", "errorTipsTextView$delegate", "isCoverSet", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "localCoverUrl", "nameEdit", "nameWordHintText", "nickName", "nickNameText", "postBtn", "Landroid/widget/Button;", "postBtnMinMarginTop", "getPostBtnMinMarginTop", "()I", "postBtnMinMarginTop$delegate", "postBtnOriginMarginTop", "getPostBtnOriginMarginTop", "postBtnOriginMarginTop$delegate", "scrollView", "Landroid/widget/ScrollView;", "selectTimeText", "selectedDateIndex", "selectedHourIndex", "titleText", "userName", "animateDesc", "", "isBig", "cancelActivity", "checkPost", "doPost", "doScene", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getActivityName", "initEdit", "initSelectTime", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetTopicIdSuccess", "eventTopicId", "onKeyboardHeightChanged", "height", "isResized", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAnnounceView", "isCovered", "setCoverStyle", "setNormalStyle", "setTextColor", "color", "showErrorTips", "isShow", "showTimePicker", "Companion", "plugin-finder_release"})
public final class FinderActivityPostUIC extends UIComponent implements com.tencent.mm.ak.i, com.tencent.mm.ui.tools.g {
    private static final kotlin.f UHo = kotlin.g.ah(g.UHq);
    public static final f UHp = new f((byte) 0);
    private TextView UHb;
    private TextView UHc;
    private TextView UHd;
    private TextView UHe;
    private String UHf = "";
    private int UHg;
    private int UHh;
    private int UHi;
    private int UHj;
    private final kotlin.f UHk = kotlin.g.ah(new n(this));
    private final kotlin.f UHl = kotlin.g.ah(new o(this));
    private final kotlin.f UHm = kotlin.g.ah(new i(this));
    private final kotlin.f UHn = kotlin.g.ah(new j(this));
    private String activityName = "";
    private long endTime;
    private ScrollView gxx;
    private com.tencent.mm.ui.tools.h gyh;
    private TextView kaq;
    private String nickName = "";
    private ImageView tqQ;
    private TextView tqS;
    private boolean trA;
    private String trB = "";
    private String trC = "";
    private int trD = 101;
    private String trk = "";
    private TextView trw;
    private MMEditText trx;

    /* renamed from: try  reason: not valid java name */
    private MMEditText f5try;
    private Button trz;
    private String userName = "";

    private final int hSu() {
        AppMethodBeat.i(260105);
        int intValue = ((Number) this.UHk.getValue()).intValue();
        AppMethodBeat.o(260105);
        return intValue;
    }

    private final View hSv() {
        AppMethodBeat.i(260106);
        View view = (View) this.UHm.getValue();
        AppMethodBeat.o(260106);
        return view;
    }

    private final TextView hSw() {
        AppMethodBeat.i(260107);
        TextView textView = (TextView) this.UHn.getValue();
        AppMethodBeat.o(260107);
        return textView;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(FinderActivityPostUIC finderActivityPostUIC) {
            super(1);
            this.trE = finderActivityPostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(260103);
            kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
            Log.i("SimpleUIComponent", "setAnnounceView");
            y yVar = y.vXH;
            y.mk(this.trE.getContext());
            x xVar = x.SXb;
            AppMethodBeat.o(260103);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityPostUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242105);
        AppMethodBeat.o(242105);
    }

    public static final /* synthetic */ void a(FinderActivityPostUIC finderActivityPostUIC, com.tencent.mm.loader.g.c cVar) {
        AppMethodBeat.i(242112);
        finderActivityPostUIC.e(cVar);
        AppMethodBeat.o(242112);
    }

    public static final /* synthetic */ MMEditText c(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(242109);
        MMEditText mMEditText = finderActivityPostUIC.trx;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        AppMethodBeat.o(242109);
        return mMEditText;
    }

    public static final /* synthetic */ MMEditText d(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(242110);
        MMEditText mMEditText = finderActivityPostUIC.f5try;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        AppMethodBeat.o(242110);
        return mMEditText;
    }

    public static final /* synthetic */ ScrollView e(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(242111);
        ScrollView scrollView = finderActivityPostUIC.gxx;
        if (scrollView == null) {
            kotlin.g.b.p.btv("scrollView");
        }
        AppMethodBeat.o(242111);
        return scrollView;
    }

    public static final /* synthetic */ com.tencent.mm.ui.tools.h h(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(260115);
        com.tencent.mm.ui.tools.h hVar = finderActivityPostUIC.gyh;
        if (hVar == null) {
            kotlin.g.b.p.btv("keyboardHeightProvider");
        }
        AppMethodBeat.o(260115);
        return hVar;
    }

    public static final /* synthetic */ Button j(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(260116);
        Button button = finderActivityPostUIC.trz;
        if (button == null) {
            kotlin.g.b.p.btv("postBtn");
        }
        AppMethodBeat.o(260116);
        return button;
    }

    public static final /* synthetic */ TextView p(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(260119);
        TextView textView = finderActivityPostUIC.UHb;
        if (textView == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        AppMethodBeat.o(260119);
        return textView;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$Companion;", "", "()V", "DESC_ANIM_DURATION", "", "DESC_CHAR_LIMIT", "", "getDESC_CHAR_LIMIT", "()I", "DESC_CHAR_LIMIT$delegate", "Lkotlin/Lazy;", "DESC_SHOW_HINT_LEAST_LIMIT", "NAME_CHAR_LIMIT", "NAME_SHOW_HINT_LEAST_LIMIT", "plugin-finder_release"})
    public static final class f {
        private f() {
        }

        public /* synthetic */ f(byte b2) {
            this();
        }

        public static final /* synthetic */ int hSy() {
            AppMethodBeat.i(260094);
            kotlin.f fVar = FinderActivityPostUIC.UHo;
            f fVar2 = FinderActivityPostUIC.UHp;
            int intValue = ((Number) fVar.getValue()).intValue();
            AppMethodBeat.o(260094);
            return intValue;
        }
    }

    static {
        AppMethodBeat.i(260114);
        AppMethodBeat.o(260114);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(242096);
        super.onCreate(bundle);
        View findViewById = getActivity().findViewById(R.id.ck1);
        kotlin.g.b.p.g(findViewById, "activity.findViewById(R.…der_activity_post_scroll)");
        this.gxx = (ScrollView) findViewById;
        String stringExtra = getIntent().getStringExtra("key_nick_name");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.nickName = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("key_user_name");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.userName = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("key_activity_name");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.activityName = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("key_activity_desc");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.trk = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra("key_activity_local_cover_url");
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.trC = stringExtra5;
        this.trD = getIntent().getIntExtra("key_activity_type", 101);
        this.trA = Util.isNullOrNil(this.trC);
        this.UHi = (int) getResources().getDimension(R.dimen.cb);
        this.UHj = (int) getResources().getDimension(R.dimen.cm);
        String spannableString = com.tencent.mm.pluginsdk.ui.span.l.c(getActivity(), this.nickName).toString();
        kotlin.g.b.p.g(spannableString, "MMSpanManager.spanForSmi…this.nickName).toString()");
        View findViewById2 = getActivity().findViewById(R.id.cjs);
        ((TextView) findViewById2).setOnClickListener(new c(this));
        kotlin.g.b.p.g(findViewById2, "activity.findViewById<Te…)\n            }\n        }");
        this.kaq = (TextView) findViewById2;
        View findViewById3 = getActivity().findViewById(R.id.ck2);
        kotlin.g.b.p.g(findViewById3, "activity.findViewById(R.…nder_activity_post_title)");
        this.trw = (TextView) findViewById3;
        TextView textView = this.trw;
        if (textView == null) {
            kotlin.g.b.p.btv("titleText");
        }
        ao.a(textView.getPaint(), 0.8f);
        AppCompatActivity activity = getActivity();
        View findViewById4 = activity.findViewById(R.id.ck0);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.finder_activity_post_name_edit)");
        this.trx = (MMEditText) findViewById4;
        if (!TextUtils.isEmpty(this.activityName)) {
            MMEditText mMEditText = this.trx;
            if (mMEditText == null) {
                kotlin.g.b.p.btv("nameEdit");
            }
            mMEditText.setText(this.activityName);
        }
        View findViewById5 = activity.findViewById(R.id.cjw);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.finder_activity_post_desc_edit)");
        this.f5try = (MMEditText) findViewById5;
        if (!TextUtils.isEmpty(this.trk)) {
            MMEditText mMEditText2 = this.f5try;
            if (mMEditText2 == null) {
                kotlin.g.b.p.btv("descEdit");
            }
            mMEditText2.setText(this.trk);
        }
        View findViewById6 = activity.findViewById(R.id.f8);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.activity_profile_header_name)");
        this.tqS = (TextView) findViewById6;
        View findViewById7 = activity.findViewById(R.id.f5);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.activity_profile_header_avatar)");
        this.tqQ = (ImageView) findViewById7;
        TextView textView2 = this.tqS;
        if (textView2 == null) {
            kotlin.g.b.p.btv("nickNameText");
        }
        textView2.setText(spannableString);
        String stringExtra6 = getIntent().getStringExtra("key_avatar_url");
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(stringExtra6);
        ImageView imageView = this.tqQ;
        if (imageView == null) {
            kotlin.g.b.p.btv("avatarImage");
        }
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        dka.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        StringBuilder sb = new StringBuilder("nameEdit size ");
        MMEditText mMEditText3 = this.trx;
        if (mMEditText3 == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        StringBuilder append = sb.append(mMEditText3.getTextSize()).append("  descEdit size ");
        MMEditText mMEditText4 = this.f5try;
        if (mMEditText4 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        Log.i("SimpleUIComponent", append.append(mMEditText4.getTextSize()).toString());
        b bVar = new b(this);
        MMEditText mMEditText5 = this.trx;
        if (mMEditText5 == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        mMEditText5.setOnTouchListener(bVar);
        MMEditText mMEditText6 = this.f5try;
        if (mMEditText6 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        mMEditText6.setOnTouchListener(bVar);
        View findViewById8 = getActivity().findViewById(R.id.cjr);
        kotlin.g.b.p.g(findViewById8, "activity.findViewById(R.…finder_activity_post_btn)");
        this.trz = (Button) findViewById8;
        Button button = this.trz;
        if (button == null) {
            kotlin.g.b.p.btv("postBtn");
        }
        button.setOnClickListener(new d(this));
        this.UHc = (TextView) getActivity().findViewById(R.id.jsz);
        Fo(false);
        MMEditText mMEditText7 = this.trx;
        if (mMEditText7 == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        mMEditText7.addTextChangedListener(new e(this));
        MMEditText mMEditText8 = this.trx;
        if (mMEditText8 == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        ao.a(mMEditText8.getPaint(), 0.8f);
        this.UHd = (TextView) getActivity().findViewById(R.id.jvu);
        this.UHe = (TextView) getActivity().findViewById(R.id.jvt);
        MMEditText mMEditText9 = this.f5try;
        if (mMEditText9 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        mMEditText9.addTextChangedListener(new k(this));
        View findViewById9 = getActivity().findViewById(R.id.jvv);
        kotlin.g.b.p.g(findViewById9, "activity.findViewById(R.…inder_activity_time_text)");
        this.UHb = (TextView) findViewById9;
        TextView textView3 = this.UHb;
        if (textView3 == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        textView3.setOnClickListener(new l(this));
        Calendar instance = Calendar.getInstance();
        kotlin.g.b.p.g(instance, "currentDate");
        y yVar = y.vXH;
        instance.setTimeInMillis(y.dCO());
        instance.set(12, 0);
        instance.set(13, 0);
        Calendar instance2 = Calendar.getInstance();
        kotlin.g.b.p.g(instance2, "newDate");
        y yVar2 = y.vXH;
        instance2.setTimeInMillis(y.dCO());
        instance2.add(2, 1);
        instance2.add(11, 1);
        instance2.set(12, 0);
        instance2.set(13, 0);
        this.UHg = instance2.get(6) - instance.get(6);
        this.UHh = instance2.get(11);
        if (this.UHh > 23) {
            this.UHh = 23;
        }
        Log.i("SimpleUIComponent", "initSelectTime time:" + instance2.getTime() + ",timeInMills:" + instance2.getTimeInMillis());
        this.endTime = instance2.getTimeInMillis() / 1000;
        int i2 = instance2.get(7);
        int i3 = i2 + -2 < 0 ? 7 : i2 - 1;
        String str = getContext().getResources().getString(R.string.cxz, Integer.valueOf(instance2.get(2) + 1), Integer.valueOf(instance2.get(5))) + ' ' + com.tencent.mm.plugin.finder.utils.k.d(getContext(), i3, FirebaseAnalytics.b.CAMPAIGN);
        y yVar3 = y.vXH;
        String string = getContext().getResources().getString(R.string.j_8, y.LX(instance2.get(11)));
        kotlin.g.b.p.g(string, "context.resources.getStr…ime_picker_hour, hourStr)");
        this.UHf = str + ' ' + string;
        TextView textView4 = this.UHb;
        if (textView4 == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        textView4.setText(this.UHf);
        this.gyh = new com.tencent.mm.ui.tools.h(getActivity());
        com.tencent.mm.ui.tools.h hVar = this.gyh;
        if (hVar == null) {
            kotlin.g.b.p.btv("keyboardHeightProvider");
        }
        hVar.setKeyboardHeightObserver(this);
        AppMethodBeat.o(242096);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(260108);
        super.onResume();
        Button button = this.trz;
        if (button == null) {
            kotlin.g.b.p.btv("postBtn");
        }
        button.post(new m(this));
        AppMethodBeat.o(260108);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class m implements Runnable {
        final /* synthetic */ FinderActivityPostUIC trE;

        m(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        public final void run() {
            AppMethodBeat.i(260100);
            FinderActivityPostUIC.h(this.trE).start();
            AppMethodBeat.o(260100);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(260109);
        super.onPause();
        com.tencent.mm.ui.tools.h hVar = this.gyh;
        if (hVar == null) {
            kotlin.g.b.p.btv("keyboardHeightProvider");
        }
        hVar.close();
        AppMethodBeat.o(260109);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(242097);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(4050, this);
        AppMethodBeat.o(242097);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$1$1"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ FinderActivityPostUIC trE;

        c(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242093);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderActivityPostUIC.a(this.trE);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242093);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$2$1"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ FinderActivityPostUIC trE;

        d(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242094);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderActivityPostUIC.g(this.trE);
            FinderActivityPostUIC.b(this.trE);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242094);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
    public static final class e implements TextWatcher {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(242095);
            if (editable != null) {
                int length = editable.toString().length();
                if (8 <= length && 10 > length) {
                    TextView textView = this.trE.UHd;
                    if (textView != null) {
                        textView.setTextColor(this.trE.getResources().getColor(R.color.FG_1));
                    }
                    TextView textView2 = this.trE.UHd;
                    if (textView2 != null) {
                        textView2.setText(String.valueOf(10 - length));
                    }
                    FinderActivityPostUIC.j(this.trE).setEnabled(true);
                } else if (length == 10) {
                    TextView textView3 = this.trE.UHd;
                    if (textView3 != null) {
                        textView3.setTextColor(this.trE.getResources().getColor(R.color.FG_1));
                    }
                    TextView textView4 = this.trE.UHd;
                    if (textView4 != null) {
                        textView4.setText("");
                    }
                    FinderActivityPostUIC.j(this.trE).setEnabled(true);
                } else if (length > 10) {
                    TextView textView5 = this.trE.UHd;
                    if (textView5 != null) {
                        textView5.setTextColor(this.trE.getResources().getColor(R.color.Red));
                    }
                    TextView textView6 = this.trE.UHd;
                    if (textView6 != null) {
                        textView6.setText(String.valueOf(10 - length));
                    }
                    FinderActivityPostUIC.j(this.trE).setEnabled(false);
                } else {
                    TextView textView7 = this.trE.UHd;
                    if (textView7 != null) {
                        textView7.setText("");
                    }
                    FinderActivityPostUIC.j(this.trE).setEnabled(true);
                }
            }
            FinderActivityPostUIC.g(this.trE);
            AppMethodBeat.o(242095);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
    public static final class k implements TextWatcher {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        public final void afterTextChanged(Editable editable) {
            String obj;
            AppMethodBeat.i(260098);
            int length = (editable == null || (obj = editable.toString()) == null) ? 0 : obj.length();
            f fVar = FinderActivityPostUIC.UHp;
            int hSy = f.hSy() - 10;
            f fVar2 = FinderActivityPostUIC.UHp;
            int hSy2 = f.hSy();
            if (hSy <= length && hSy2 > length) {
                TextView textView = this.trE.UHe;
                if (textView != null) {
                    textView.setTextColor(this.trE.getResources().getColor(R.color.FG_1));
                }
                TextView textView2 = this.trE.UHe;
                if (textView2 != null) {
                    f fVar3 = FinderActivityPostUIC.UHp;
                    textView2.setText(String.valueOf(f.hSy() - length));
                }
                FinderActivityPostUIC.a(this.trE, true);
                FinderActivityPostUIC.j(this.trE).setEnabled(true);
            } else {
                f fVar4 = FinderActivityPostUIC.UHp;
                if (length == f.hSy()) {
                    TextView textView3 = this.trE.UHe;
                    if (textView3 != null) {
                        textView3.setTextColor(this.trE.getResources().getColor(R.color.FG_1));
                    }
                    TextView textView4 = this.trE.UHe;
                    if (textView4 != null) {
                        textView4.setText("");
                    }
                    FinderActivityPostUIC.a(this.trE, false);
                    FinderActivityPostUIC.j(this.trE).setEnabled(true);
                } else {
                    f fVar5 = FinderActivityPostUIC.UHp;
                    if (length > f.hSy()) {
                        TextView textView5 = this.trE.UHe;
                        if (textView5 != null) {
                            textView5.setTextColor(this.trE.getResources().getColor(R.color.Red));
                        }
                        TextView textView6 = this.trE.UHe;
                        if (textView6 != null) {
                            f fVar6 = FinderActivityPostUIC.UHp;
                            textView6.setText(String.valueOf(f.hSy() - length));
                        }
                        FinderActivityPostUIC.a(this.trE, true);
                        FinderActivityPostUIC.j(this.trE).setEnabled(false);
                    } else {
                        TextView textView7 = this.trE.UHe;
                        if (textView7 != null) {
                            textView7.setText("");
                        }
                        FinderActivityPostUIC.a(this.trE, false);
                        FinderActivityPostUIC.j(this.trE).setEnabled(true);
                    }
                }
            }
            FinderActivityPostUIC.g(this.trE);
            AppMethodBeat.o(260098);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ FinderActivityPostUIC trE;

        l(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260099);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderActivityPostUIC.l(this.trE);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260099);
        }
    }

    private final void Fo(boolean z) {
        AppMethodBeat.i(260110);
        String string = getContext().getResources().getString(R.string.j9p);
        kotlin.g.b.p.g(string, "context.resources.getStr…r_activity_announce_name)");
        String string2 = getResources().getString(R.string.j_0, string);
        kotlin.g.b.p.g(string2, "resources.getString(R.st…t_announce, announceName)");
        SpannableString spannableString = new SpannableString(string2);
        if (z) {
            TextView textView = this.UHc;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.BW_100_Alpha_0_5));
            }
        } else {
            TextView textView2 = this.UHc;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.FG_1));
            }
        }
        spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(string2, getResources().getColor(R.color.vj), getContext().getResources().getColor(R.color.ac_), false, false, new p(this)), string2.length() - string.length(), string2.length(), 17);
        TextView textView3 = this.UHc;
        if (textView3 != null) {
            textView3.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(getContext()));
        }
        TextView textView4 = this.UHc;
        if (textView4 != null) {
            textView4.setText(spannableString);
            AppMethodBeat.o(260110);
            return;
        }
        AppMethodBeat.o(260110);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$animateDesc$descAnimator$1$1"})
    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int UHr;
        final /* synthetic */ int UHs;
        final /* synthetic */ int UHt;
        final /* synthetic */ FinderActivityPostUIC trE;

        h(FinderActivityPostUIC finderActivityPostUIC, int i2, int i3, int i4) {
            this.trE = finderActivityPostUIC;
            this.UHr = i2;
            this.UHs = i3;
            this.UHt = i4;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(260095);
            kotlin.g.b.p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(260095);
                throw tVar;
            }
            FinderActivityPostUIC.d(this.trE).setPadding(this.UHr, this.UHs, this.UHt, ((Integer) animatedValue).intValue());
            AppMethodBeat.o(260095);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "hasSetResult", "", "result", "", "kotlin.jvm.PlatformType", "secondResult", "<anonymous parameter 3>", "onResult"})
    public static final class q<T> implements c.a<Object> {
        final /* synthetic */ com.tencent.mm.ui.widget.picker.c UHu;
        final /* synthetic */ kotlin.o UHv;
        final /* synthetic */ FinderActivityPostUIC trE;

        q(FinderActivityPostUIC finderActivityPostUIC, com.tencent.mm.ui.widget.picker.c cVar, kotlin.o oVar) {
            this.trE = finderActivityPostUIC;
            this.UHu = cVar;
            this.UHv = oVar;
        }

        @Override // com.tencent.mm.ui.widget.picker.c.a
        public final void a(boolean z, Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(260104);
            this.UHu.hide();
            if (z) {
                FinderActivityPostUIC finderActivityPostUIC = this.trE;
                A a2 = this.UHv.first;
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                    AppMethodBeat.o(260104);
                    throw tVar;
                }
                finderActivityPostUIC.UHg = kotlin.a.j.a((List) a2, (Object) ((CharSequence) obj));
                FinderActivityPostUIC finderActivityPostUIC2 = this.trE;
                Object obj4 = this.UHv.second.get(this.trE.UHg);
                kotlin.g.b.p.g(obj4, "timePair.second[selectedDateIndex]");
                List list = (List) obj4;
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                    AppMethodBeat.o(260104);
                    throw tVar2;
                }
                finderActivityPostUIC2.UHh = kotlin.a.j.a(list, (Object) ((CharSequence) obj2));
                y yVar = y.vXH;
                Date date = new Date(y.dCO());
                Calendar instance = Calendar.getInstance();
                kotlin.g.b.p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
                instance.setTime(date);
                instance.set(5, instance.get(5) + this.trE.UHg);
                instance.set(11, (24 - ((List) this.UHv.second.get(this.trE.UHg)).size()) + this.trE.UHh);
                instance.set(12, 0);
                instance.set(13, 0);
                Log.i("SimpleUIComponent", "chosen time:" + instance.getTime() + ",timeInMills:" + instance.getTimeInMillis());
                this.trE.endTime = instance.getTimeInMillis() / 1000;
                this.trE.UHf = new StringBuilder().append(obj).append(' ').append(obj2).toString();
                FinderActivityPostUIC.p(this.trE).setText(this.trE.UHf);
            }
            AppMethodBeat.o(260104);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class b implements View.OnTouchListener {
        final /* synthetic */ FinderActivityPostUIC trE;

        b(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242092);
            if (kotlin.g.b.p.j(view, FinderActivityPostUIC.c(this.trE)) || kotlin.g.b.p.j(view, FinderActivityPostUIC.d(this.trE))) {
                Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    FinderActivityPostUIC.e(this.trE).requestDisallowInterceptTouchEvent(true);
                } else if ((valueOf != null && valueOf.intValue() == 3) || (valueOf != null && valueOf.intValue() == 1)) {
                    FinderActivityPostUIC.e(this.trE).requestDisallowInterceptTouchEvent(false);
                }
            }
            AppMethodBeat.o(242092);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(242099);
        Log.i("SimpleUIComponent", "onSceneEnd: errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
        if (qVar instanceof cc) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderActivitySelectCoverUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivitySelectCoverUIC.class)).cXy();
            if (i2 == 0 && i3 == 0) {
                long j2 = ((cc) qVar).twd;
                String activityName2 = getActivityName();
                MMEditText mMEditText = this.f5try;
                if (mMEditText == null) {
                    kotlin.g.b.p.btv("descEdit");
                }
                String obj = mMEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("key_topic_id", j2);
                intent.putExtra("key_activity_name", activityName2);
                intent.putExtra("key_activity_desc", obj);
                intent.putExtra("key_nick_name", this.nickName);
                intent.putExtra("key_activity_local_cover_url", this.trC);
                intent.putExtra("key_cover_url", this.trB);
                intent.putExtra("key_activity_type", 101);
                Log.i("FinderActivityPostUI", "eventTopicId:" + j2 + "  name:" + activityName2 + "  desc:" + obj);
                AppCompatActivity activity = getActivity();
                activity.setResult(-1, intent);
                if (!activity.isFinishing()) {
                    activity.finish();
                }
                AppMethodBeat.o(242099);
                return;
            }
            ai(true, i3);
        }
        AppMethodBeat.o(242099);
    }

    private final String getActivityName() {
        AppMethodBeat.i(242100);
        MMEditText mMEditText = this.trx;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        String obj = mMEditText.getText().toString();
        AppMethodBeat.o(242100);
        return obj;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c> {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderActivityPostUIC finderActivityPostUIC) {
            this.trE = finderActivityPostUIC;
        }

        @Override // com.tencent.mm.loader.g.f
        public final void a(com.tencent.mm.loader.g.c cVar, com.tencent.mm.loader.g.j jVar) {
            AppMethodBeat.i(242091);
            kotlin.g.b.p.h(cVar, "task");
            kotlin.g.b.p.h(jVar, "status");
            if (jVar == com.tencent.mm.loader.g.j.Fail) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((FinderActivitySelectCoverUIC) com.tencent.mm.ui.component.a.b(this.trE.getActivity()).get(FinderActivitySelectCoverUIC.class)).cXy();
                AppMethodBeat.o(242091);
                return;
            }
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((FinderActivitySelectCoverUIC) com.tencent.mm.ui.component.a.b(this.trE.getActivity()).get(FinderActivitySelectCoverUIC.class)).setCover(this.trE.trC);
            FinderActivityPostUIC.a(this.trE, cVar);
            AppMethodBeat.o(242091);
        }
    }

    private final void e(com.tencent.mm.loader.g.c cVar) {
        String str;
        AppMethodBeat.i(242101);
        String activityName2 = getActivityName();
        MMEditText mMEditText = this.f5try;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        String obj = mMEditText.getText().toString();
        if (cVar instanceof com.tencent.mm.plugin.finder.upload.k) {
            str = ((com.tencent.mm.plugin.finder.upload.k) cVar).coverUrl;
        } else {
            str = "";
        }
        this.trB = str;
        com.tencent.mm.kernel.g.azz().a(4050, this);
        com.tencent.mm.kernel.g.azz().b(new cc(this.userName, activityName2, obj, this.trB, this.endTime, 0, 32));
        AppMethodBeat.o(242101);
    }

    public final void cXx() {
        AppMethodBeat.i(242102);
        this.trA = true;
        int color = getResources().getColor(R.color.pg);
        TextView textView = this.tqS;
        if (textView == null) {
            kotlin.g.b.p.btv("nickNameText");
        }
        textView.setTextColor(getResources().getColor(R.color.BW_100_Alpha_0_8));
        setTextColor(color);
        MMEditText mMEditText = this.trx;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        mMEditText.setBackgroundResource(R.drawable.a2q);
        MMEditText mMEditText2 = this.f5try;
        if (mMEditText2 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        mMEditText2.setBackgroundResource(R.drawable.a2q);
        TextView textView2 = this.UHb;
        if (textView2 == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        textView2.setBackgroundResource(R.drawable.a2q);
        MMEditText mMEditText3 = this.trx;
        if (mMEditText3 == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        mMEditText3.setHintTextColor(getResources().getColor(R.color.pj));
        MMEditText mMEditText4 = this.f5try;
        if (mMEditText4 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        mMEditText4.setHintTextColor(getResources().getColor(R.color.pj));
        TextView textView3 = this.UHb;
        if (textView3 == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        textView3.setHintTextColor(getResources().getColor(R.color.pj));
        Fo(true);
        AppMethodBeat.o(242102);
    }

    public final void cXo() {
        AppMethodBeat.i(242103);
        this.trA = false;
        setTextColor(getResources().getColor(R.color.fo));
        TextView textView = this.tqS;
        if (textView == null) {
            kotlin.g.b.p.btv("nickNameText");
        }
        textView.setTextColor(getResources().getColor(R.color.FG_0));
        MMEditText mMEditText = this.trx;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        mMEditText.setBackgroundResource(R.drawable.a2p);
        MMEditText mMEditText2 = this.trx;
        if (mMEditText2 == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        mMEditText2.setHintTextColor(getResources().getColor(R.color.BW_0_Alpha_0_3));
        MMEditText mMEditText3 = this.f5try;
        if (mMEditText3 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        mMEditText3.setBackgroundResource(R.drawable.a2p);
        MMEditText mMEditText4 = this.f5try;
        if (mMEditText4 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        mMEditText4.setHintTextColor(getResources().getColor(R.color.BW_0_Alpha_0_3));
        TextView textView2 = this.UHb;
        if (textView2 == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        textView2.setHintTextColor(getResources().getColor(R.color.BW_0_Alpha_0_3));
        TextView textView3 = this.UHb;
        if (textView3 == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        textView3.setBackgroundResource(R.drawable.a2p);
        Fo(false);
        AppMethodBeat.o(242103);
    }

    private final void setTextColor(int i2) {
        AppMethodBeat.i(242104);
        MMEditText mMEditText = this.trx;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        mMEditText.setTextColor(i2);
        MMEditText mMEditText2 = this.f5try;
        if (mMEditText2 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        mMEditText2.setTextColor(i2);
        TextView textView = this.trw;
        if (textView == null) {
            kotlin.g.b.p.btv("titleText");
        }
        textView.setTextColor(i2);
        TextView textView2 = this.kaq;
        if (textView2 == null) {
            kotlin.g.b.p.btv("cancelBtn");
        }
        textView2.setTextColor(i2);
        TextView textView3 = this.UHb;
        if (textView3 == null) {
            kotlin.g.b.p.btv("selectTimeText");
        }
        textView3.setTextColor(i2);
        AppMethodBeat.o(242104);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(260111);
        Button button = this.trz;
        if (button == null) {
            kotlin.g.b.p.btv("postBtn");
        }
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(260111);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int intValue = ((Number) this.UHl.getValue()).intValue() - i2;
        if (intValue < hSu()) {
            intValue = hSu();
        }
        marginLayoutParams.topMargin = intValue;
        Button button2 = this.trz;
        if (button2 == null) {
            kotlin.g.b.p.btv("postBtn");
        }
        button2.setLayoutParams(marginLayoutParams);
        AppMethodBeat.o(260111);
    }

    static /* synthetic */ void g(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(260113);
        finderActivityPostUIC.ai(false, 0);
        AppMethodBeat.o(260113);
    }

    private final void ai(boolean z, int i2) {
        AppMethodBeat.i(260112);
        if (z) {
            View hSv = hSv();
            kotlin.g.b.p.g(hSv, "errorTipsLayout");
            hSv.setVisibility(0);
            if (i2 == -4055) {
                hSw().setText(R.string.j9r);
                AppMethodBeat.o(260112);
            } else if (i2 == -4066) {
                hSw().setText(R.string.j9q);
                AppMethodBeat.o(260112);
            } else {
                hSw().setText(R.string.j9s);
                AppMethodBeat.o(260112);
            }
        } else {
            View hSv2 = hSv();
            kotlin.g.b.p.g(hSv2, "errorTipsLayout");
            hSv2.setVisibility(8);
            AppMethodBeat.o(260112);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final g UHq = new g();

        static {
            AppMethodBeat.i(260093);
            AppMethodBeat.o(260093);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(260092);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            Integer valueOf = Integer.valueOf(com.tencent.mm.plugin.finder.storage.c.dsA().value().intValue());
            AppMethodBeat.o(260092);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(FinderActivityPostUIC finderActivityPostUIC) {
            super(0);
            this.trE = finderActivityPostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(260101);
            Integer valueOf = Integer.valueOf(this.trE.getResources().getDimensionPixelOffset(R.dimen.cl));
            AppMethodBeat.o(260101);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(FinderActivityPostUIC finderActivityPostUIC) {
            super(0);
            this.trE = finderActivityPostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(260102);
            Integer valueOf = Integer.valueOf(this.trE.getResources().getDimensionPixelOffset(R.dimen.a4u));
            AppMethodBeat.o(260102);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderActivityPostUIC finderActivityPostUIC) {
            super(0);
            this.trE = finderActivityPostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(260096);
            View findViewById = this.trE.findViewById(R.id.jur);
            AppMethodBeat.o(260096);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderActivityPostUIC trE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderActivityPostUIC finderActivityPostUIC) {
            super(0);
            this.trE = finderActivityPostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(260097);
            TextView textView = (TextView) this.trE.findViewById(R.id.juq);
            AppMethodBeat.o(260097);
            return textView;
        }
    }

    public static final /* synthetic */ void a(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(242106);
        Intent intent = new Intent();
        intent.putExtra("key_topic_id", 0L);
        intent.putExtra("key_activity_name", "");
        intent.putExtra("key_activity_desc", "");
        intent.putExtra("key_activity_local_cover_url", "");
        intent.putExtra("key_cover_url", "");
        intent.putExtra("key_activity_type", 100);
        Log.i("FinderActivityPostUI", "cancelActivity");
        AppCompatActivity activity = finderActivityPostUIC.getActivity();
        activity.setResult(-1, intent);
        if (!activity.isFinishing()) {
            activity.finish();
        }
        AppMethodBeat.o(242106);
    }

    public static final /* synthetic */ void b(FinderActivityPostUIC finderActivityPostUIC) {
        boolean z;
        AppMethodBeat.i(242107);
        MMEditText mMEditText = finderActivityPostUIC.trx;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("nameEdit");
        }
        boolean isNullOrNil = Util.isNullOrNil(mMEditText.getText());
        MMEditText mMEditText2 = finderActivityPostUIC.f5try;
        if (mMEditText2 == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        boolean isNullOrNil2 = Util.isNullOrNil(mMEditText2.getText());
        boolean isNullOrNil3 = Util.isNullOrNil(finderActivityPostUIC.UHf);
        if (isNullOrNil || isNullOrNil3 || isNullOrNil2) {
            if (isNullOrNil) {
                MMEditText mMEditText3 = finderActivityPostUIC.trx;
                if (mMEditText3 == null) {
                    kotlin.g.b.p.btv("nameEdit");
                }
                mMEditText3.setHintTextColor(finderActivityPostUIC.getResources().getColor(R.color.Red));
            }
            if (isNullOrNil2) {
                MMEditText mMEditText4 = finderActivityPostUIC.f5try;
                if (mMEditText4 == null) {
                    kotlin.g.b.p.btv("descEdit");
                }
                mMEditText4.setHintTextColor(finderActivityPostUIC.getResources().getColor(R.color.Red));
            }
            if (isNullOrNil3) {
                TextView textView = finderActivityPostUIC.UHb;
                if (textView == null) {
                    kotlin.g.b.p.btv("selectTimeText");
                }
                textView.setHintTextColor(finderActivityPostUIC.getResources().getColor(R.color.Red));
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.i("SimpleUIComponent", "doPost: check post fail");
            AppMethodBeat.o(242107);
            return;
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        if (((FinderActivitySelectCoverUIC) com.tencent.mm.ui.component.a.b(finderActivityPostUIC.getActivity()).get(FinderActivitySelectCoverUIC.class)).trQ) {
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            finderActivityPostUIC.trC = ((FinderActivitySelectCoverUIC) com.tencent.mm.ui.component.a.b(finderActivityPostUIC.getActivity()).get(FinderActivitySelectCoverUIC.class)).trP;
        }
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        ((FinderActivitySelectCoverUIC) com.tencent.mm.ui.component.a.b(finderActivityPostUIC.getActivity()).get(FinderActivitySelectCoverUIC.class)).showProgress();
        if (Util.isNullOrNil(finderActivityPostUIC.trC)) {
            finderActivityPostUIC.e((com.tencent.mm.loader.g.c) null);
            AppMethodBeat.o(242107);
            return;
        }
        g.a aVar4 = com.tencent.mm.plugin.finder.upload.g.vSJ;
        com.tencent.mm.plugin.finder.upload.g gVar = com.tencent.mm.plugin.finder.upload.g.vSH;
        String str = finderActivityPostUIC.trC;
        a aVar5 = new a(finderActivityPostUIC);
        kotlin.g.b.p.h(str, "path");
        kotlin.g.b.p.h(aVar5, "callback");
        gVar.vSB.a(new com.tencent.mm.plugin.finder.upload.k(str), aVar5);
        AppMethodBeat.o(242107);
    }

    public static final /* synthetic */ void a(FinderActivityPostUIC finderActivityPostUIC, boolean z) {
        int i2;
        AppMethodBeat.i(260117);
        MMEditText mMEditText = finderActivityPostUIC.f5try;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("descEdit");
        }
        int paddingBottom = mMEditText.getPaddingBottom();
        if (z && paddingBottom == finderActivityPostUIC.UHj) {
            Log.i("SimpleUIComponent", "animateDesc isBig:" + paddingBottom + " paddingBottom:" + paddingBottom + " return");
            AppMethodBeat.o(260117);
        } else if (z || paddingBottom != finderActivityPostUIC.UHi) {
            MMEditText mMEditText2 = finderActivityPostUIC.f5try;
            if (mMEditText2 == null) {
                kotlin.g.b.p.btv("descEdit");
            }
            int paddingStart = mMEditText2.getPaddingStart();
            MMEditText mMEditText3 = finderActivityPostUIC.f5try;
            if (mMEditText3 == null) {
                kotlin.g.b.p.btv("descEdit");
            }
            int paddingTop = mMEditText3.getPaddingTop();
            MMEditText mMEditText4 = finderActivityPostUIC.f5try;
            if (mMEditText4 == null) {
                kotlin.g.b.p.btv("descEdit");
            }
            int paddingEnd = mMEditText4.getPaddingEnd();
            if (z) {
                i2 = finderActivityPostUIC.UHj;
            } else {
                i2 = finderActivityPostUIC.UHi;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(paddingBottom, i2);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new h(finderActivityPostUIC, paddingStart, paddingTop, paddingEnd));
            ofInt.start();
            AppMethodBeat.o(260117);
        } else {
            Log.i("SimpleUIComponent", "animateDesc isBig:" + paddingBottom + " paddingBottom:" + paddingBottom + " return");
            AppMethodBeat.o(260117);
        }
    }

    public static final /* synthetic */ void l(FinderActivityPostUIC finderActivityPostUIC) {
        AppMethodBeat.i(260118);
        y yVar = y.vXH;
        AppCompatActivity activity = finderActivityPostUIC.getActivity();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.hVe().value().intValue();
        kotlin.g.b.p.h(activity, "context");
        Date date = new Date(y.dCO());
        Calendar instance = Calendar.getInstance();
        ArrayList<String> arrayList = new ArrayList();
        int i2 = (date.getHours() < 23 || date.getMinutes() < 55) ? 0 : 1;
        for (int i3 = i2; i3 < intValue; i3++) {
            kotlin.g.b.p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            instance.setTime(date);
            instance.set(5, instance.get(5) + i3);
            int i4 = instance.get(5);
            int i5 = instance.get(2) + 1;
            if (i3 == i2) {
                Context context = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                arrayList.add(context.getResources().getString(R.string.dfl));
            } else if (i3 == i2 + 1) {
                StringBuilder sb = new StringBuilder();
                Context context2 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                StringBuilder append = sb.append(context2.getResources().getString(R.string.cxz, Integer.valueOf(i5), Integer.valueOf(i4))).append(' ');
                Context context3 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
                arrayList.add(append.append(context3.getResources().getString(R.string.dfm)).toString());
            } else if (i3 == i2 + 2) {
                StringBuilder sb2 = new StringBuilder();
                Context context4 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context4, "MMApplicationContext.getContext()");
                StringBuilder append2 = sb2.append(context4.getResources().getString(R.string.cxz, Integer.valueOf(i5), Integer.valueOf(i4))).append(' ');
                Context context5 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context5, "MMApplicationContext.getContext()");
                arrayList.add(append2.append(context5.getResources().getString(R.string.dfc)).toString());
            } else {
                int i6 = instance.get(7);
                int i7 = i6 + -2 < 0 ? 7 : i6 - 1;
                StringBuilder sb3 = new StringBuilder();
                Context context6 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context6, "MMApplicationContext.getContext()");
                arrayList.add(sb3.append(context6.getResources().getString(R.string.cxz, Integer.valueOf(i5), Integer.valueOf(i4))).append(' ').append(com.tencent.mm.plugin.finder.utils.k.d(activity, i7, FirebaseAnalytics.b.CAMPAIGN)).toString());
            }
        }
        for (String str : arrayList) {
            Log.i("getNoticePicker", str);
        }
        kotlin.o oVar = new kotlin.o(arrayList, y.R(arrayList.size(), R.string.j_8, true));
        com.tencent.mm.ui.widget.picker.c cVar2 = new com.tencent.mm.ui.widget.picker.c(finderActivityPostUIC.getActivity(), oVar.first, oVar.second);
        Calendar instance2 = Calendar.getInstance();
        kotlin.g.b.p.g(instance2, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        y yVar2 = y.vXH;
        instance2.setTimeInMillis(y.dCO());
        cVar2.lM(finderActivityPostUIC.UHg, finderActivityPostUIC.UHh);
        cVar2.aF(finderActivityPostUIC.getActivity().getResources().getString(R.string.j_h));
        cVar2.a(new q(finderActivityPostUIC, cVar2, oVar));
        View inflate = LayoutInflater.from(finderActivityPostUIC.getActivity()).inflate(R.layout.cer, (ViewGroup) null);
        kotlin.g.b.p.g(inflate, "LayoutInflater.from(acti…time_picker_header, null)");
        cVar2.setHeaderView(inflate);
        cVar2.apd(finderActivityPostUIC.getActivity().getResources().getColor(R.color.a2));
        cVar2.axw(R.drawable.k_);
        cVar2.show();
        AppMethodBeat.o(260118);
    }
}
