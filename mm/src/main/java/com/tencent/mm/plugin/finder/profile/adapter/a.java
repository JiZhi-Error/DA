package com.tencent.mm.plugin.finder.profile.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\fH\u0002J(\u0010!\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper;", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getHeader", "()Landroid/view/ViewGroup;", "visibleStateRecorder", "", "changeBtnPos", "", "isDown", "", "view", "Landroid/view/View;", "changePosition", "spannableStr", "Landroid/text/SpannableString;", "locationText", "", "lltext", "isRecordStat", "getChangeLeftRegionWidth", "", "text", "getChangeRightRegionWidth", "", "getEditWidth", "getLocationTextWidth", "getTotalAvailableWidth", "recordVisibleState", "isShouldRecord", "restoreVisibleState", "setProfileTextWidth", "availableWidth", "nameExtWidth", "Companion", "plugin-finder_release"})
public final class a {
    public static final C1262a uZI = new C1262a((byte) 0);
    private final int[] uZG = {0, 0};
    final ViewGroup uZH;

    static {
        AppMethodBeat.i(250016);
        AppMethodBeat.o(250016);
    }

    public a(ViewGroup viewGroup) {
        p.h(viewGroup, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        AppMethodBeat.i(250015);
        this.uZH = viewGroup;
        AppMethodBeat.o(250015);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.profile.adapter.a$a  reason: collision with other inner class name */
    public static final class C1262a {
        private C1262a() {
        }

        public /* synthetic */ C1262a(byte b2) {
            this();
        }
    }

    public final void a(SpannableString spannableString, String str) {
        AppMethodBeat.i(250012);
        p.h(str, "locationText");
        a(spannableString, str, true);
        AppMethodBeat.o(250012);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(SpannableString spannableString, String str, boolean z) {
        AppMethodBeat.i(250013);
        p.h(str, "lltext");
        if (spannableString == null || Util.isNullOrNil(spannableString.toString())) {
            AppMethodBeat.o(250013);
            return;
        }
        z.f fVar = new z.f();
        T t = (T) spannableString.toString();
        p.g(t, "spannableStr.toString()");
        fVar.SYG = t;
        z.f fVar2 = new z.f();
        fVar2.SYG = str;
        nP(z);
        if (fVar.SYG != null) {
            this.uZH.post(new b(this, fVar, fVar2, z));
        }
        AppMethodBeat.o(250013);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper$changePosition$1$1"})
    public static final class b implements Runnable {
        final /* synthetic */ a uZJ;
        final /* synthetic */ z.f uZK;
        final /* synthetic */ z.f uZL;
        final /* synthetic */ boolean uZM;

        b(a aVar, z.f fVar, z.f fVar2, boolean z) {
            this.uZJ = aVar;
            this.uZK = fVar;
            this.uZL = fVar2;
            this.uZM = z;
        }

        public final void run() {
            AppMethodBeat.i(250011);
            int a2 = a.a(this.uZJ);
            int b2 = a2 - a.b(this.uZJ);
            float c2 = a.c(this.uZJ);
            TextView textView = (TextView) this.uZJ.uZH.findViewById(R.id.d2q);
            p.g(textView, "header.finder_profile_name_tv");
            float measureText = textView.getPaint().measureText(this.uZK.SYG);
            float a3 = a.a(this.uZJ, this.uZL.SYG);
            if (measureText + c2 > ((float) b2) || a3 > ((float) b2)) {
                a aVar = this.uZJ;
                FrameLayout frameLayout = (FrameLayout) this.uZJ.uZH.findViewById(R.id.hju);
                p.g(frameLayout, "header.sendMsgBtn");
                a.a(aVar, true, (View) frameLayout);
                a aVar2 = this.uZJ;
                FrameLayout frameLayout2 = (FrameLayout) this.uZJ.uZH.findViewById(R.id.d2c);
                p.g(frameLayout2, "header.finder_profile_follow_btn");
                a.a(aVar2, true, (View) frameLayout2);
                a.a(this.uZJ, this.uZK.SYG, this.uZL.SYG, a2 - com.tencent.mm.cb.a.aH(this.uZJ.uZH.getContext(), R.dimen.cb), (int) c2);
            } else {
                a aVar3 = this.uZJ;
                FrameLayout frameLayout3 = (FrameLayout) this.uZJ.uZH.findViewById(R.id.hju);
                p.g(frameLayout3, "header.sendMsgBtn");
                a.a(aVar3, false, (View) frameLayout3);
                a aVar4 = this.uZJ;
                FrameLayout frameLayout4 = (FrameLayout) this.uZJ.uZH.findViewById(R.id.d2c);
                p.g(frameLayout4, "header.finder_profile_follow_btn");
                a.a(aVar4, false, (View) frameLayout4);
                a.a(this.uZJ, this.uZK.SYG, this.uZL.SYG, b2, (int) c2);
            }
            a.a(this.uZJ, this.uZM);
            AppMethodBeat.o(250011);
        }
    }

    private final void nP(boolean z) {
        AppMethodBeat.i(250014);
        if (z) {
            int[] iArr = this.uZG;
            FrameLayout frameLayout = (FrameLayout) this.uZH.findViewById(R.id.hju);
            p.g(frameLayout, "header.sendMsgBtn");
            iArr[0] = frameLayout.getVisibility();
            int[] iArr2 = this.uZG;
            FrameLayout frameLayout2 = (FrameLayout) this.uZH.findViewById(R.id.d2c);
            p.g(frameLayout2, "header.finder_profile_follow_btn");
            iArr2[1] = frameLayout2.getVisibility();
            FrameLayout frameLayout3 = (FrameLayout) this.uZH.findViewById(R.id.hju);
            p.g(frameLayout3, "header.sendMsgBtn");
            if (frameLayout3.getVisibility() == 0) {
                FrameLayout frameLayout4 = (FrameLayout) this.uZH.findViewById(R.id.hju);
                p.g(frameLayout4, "header.sendMsgBtn");
                frameLayout4.setVisibility(4);
            }
            FrameLayout frameLayout5 = (FrameLayout) this.uZH.findViewById(R.id.d2c);
            p.g(frameLayout5, "header.finder_profile_follow_btn");
            if (frameLayout5.getVisibility() == 0) {
                FrameLayout frameLayout6 = (FrameLayout) this.uZH.findViewById(R.id.d2c);
                p.g(frameLayout6, "header.finder_profile_follow_btn");
                frameLayout6.setVisibility(4);
            }
        }
        AppMethodBeat.o(250014);
    }

    public static final /* synthetic */ int a(a aVar) {
        AppMethodBeat.i(250017);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = aVar.uZH.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(250017);
            throw tVar;
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        p.g(windowManager, "(header.context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Log.i(FinderBottomCustomDialogHelper.UserInfoHelper.TAG, "screen width :" + displayMetrics.widthPixels);
        int aH = displayMetrics.widthPixels - com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.a4o);
        AppMethodBeat.o(250017);
        return aH;
    }

    public static final /* synthetic */ int b(a aVar) {
        int i2;
        AppMethodBeat.i(250018);
        if (aVar.uZG[0] == 0) {
            FrameLayout frameLayout = (FrameLayout) aVar.uZH.findViewById(R.id.hju);
            p.g(frameLayout, "header.sendMsgBtn");
            i2 = frameLayout.getWidth() + com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.ct) + 0;
        } else {
            i2 = 0;
        }
        if (aVar.uZG[1] == 0) {
            FrameLayout frameLayout2 = (FrameLayout) aVar.uZH.findViewById(R.id.d2c);
            p.g(frameLayout2, "header.finder_profile_follow_btn");
            i2 += frameLayout2.getWidth() + com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cb);
        }
        AppMethodBeat.o(250018);
        return i2;
    }

    public static final /* synthetic */ float c(a aVar) {
        float f2 = 0.0f;
        AppMethodBeat.i(250019);
        ImageView imageView = (ImageView) aVar.uZH.findViewById(R.id.d1o);
        p.g(imageView, "header.finder_profile_auth_icon");
        if (imageView.getVisibility() == 0) {
            f2 = ((float) com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cc)) + 0.0f;
        }
        WeImageView weImageView = (WeImageView) aVar.uZH.findViewById(R.id.d1t);
        p.g(weImageView, "header.finder_profile_block_icon");
        if (weImageView.getVisibility() == 0) {
            f2 += (float) com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cc);
        }
        AppMethodBeat.o(250019);
        return f2;
    }

    public static final /* synthetic */ float a(a aVar, String str) {
        AppMethodBeat.i(250020);
        float f2 = 0.0f;
        if (!Util.isNullOrNil(str)) {
            TextView textView = (TextView) aVar.uZH.findViewById(R.id.j1q);
            p.g(textView, "header.user_tag_layout");
            f2 = textView.getPaint().measureText(str);
        }
        AppMethodBeat.o(250020);
        return f2;
    }

    public static final /* synthetic */ void a(a aVar, boolean z, View view) {
        AppMethodBeat.i(250021);
        if (aVar.uZG[p.j(view, (FrameLayout) aVar.uZH.findViewById(R.id.hju)) ? (char) 0 : 1] == 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.o(250021);
                throw tVar;
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int i2 = layoutParams2.topMargin;
            if (z && i2 < com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cc) + 5) {
                layoutParams2.topMargin = com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cs);
            } else if (!z && i2 > com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cn)) {
                layoutParams2.topMargin = com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cc);
            }
            view.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(250021);
    }

    public static final /* synthetic */ void a(a aVar, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(250022);
        int i4 = i2 - i3;
        RelativeLayout relativeLayout = (RelativeLayout) aVar.uZH.findViewById(R.id.d28);
        p.g(relativeLayout, "header.finder_profile_edit_ll");
        if (relativeLayout.getVisibility() == 0) {
            int aH = i2 - com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cn);
            i2 -= com.tencent.mm.cb.a.aH(aVar.uZH.getContext(), R.dimen.cn);
            i4 = aH;
        }
        TextView textView = (TextView) aVar.uZH.findViewById(R.id.d2q);
        p.g(textView, "header.finder_profile_name_tv");
        textView.setMaxWidth(i4);
        TextView textView2 = (TextView) aVar.uZH.findViewById(R.id.d2q);
        p.g(textView2, "header.finder_profile_name_tv");
        textView2.setText(str);
        TextView textView3 = (TextView) aVar.uZH.findViewById(R.id.j1q);
        p.g(textView3, "header.user_tag_layout");
        textView3.setMaxWidth(i2);
        TextView textView4 = (TextView) aVar.uZH.findViewById(R.id.j1q);
        p.g(textView4, "header.user_tag_layout");
        textView4.setText(str2);
        AppMethodBeat.o(250022);
    }

    public static final /* synthetic */ void a(a aVar, boolean z) {
        AppMethodBeat.i(250023);
        if (z) {
            FrameLayout frameLayout = (FrameLayout) aVar.uZH.findViewById(R.id.hju);
            p.g(frameLayout, "header.sendMsgBtn");
            if (frameLayout.getVisibility() != aVar.uZG[0]) {
                FrameLayout frameLayout2 = (FrameLayout) aVar.uZH.findViewById(R.id.hju);
                p.g(frameLayout2, "header.sendMsgBtn");
                frameLayout2.setVisibility(aVar.uZG[0]);
            }
            FrameLayout frameLayout3 = (FrameLayout) aVar.uZH.findViewById(R.id.d2c);
            p.g(frameLayout3, "header.finder_profile_follow_btn");
            if (frameLayout3.getVisibility() != aVar.uZG[1]) {
                FrameLayout frameLayout4 = (FrameLayout) aVar.uZH.findViewById(R.id.d2c);
                p.g(frameLayout4, "header.finder_profile_follow_btn");
                frameLayout4.setVisibility(aVar.uZG[1]);
            }
            aVar.uZG[0] = 0;
            aVar.uZG[1] = 0;
        }
        AppMethodBeat.o(250023);
    }
}
