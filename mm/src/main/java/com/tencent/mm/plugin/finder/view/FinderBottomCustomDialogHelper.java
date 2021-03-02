package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.b.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

public final class FinderBottomCustomDialogHelper {
    public static final Companion Companion = new Companion(null);
    private static final String TAG;

    static {
        AppMethodBeat.i(254662);
        AppMethodBeat.o(254662);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }

        public static /* synthetic */ void showUserInfoConfirmDialog$default(Companion companion, Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, int i2, Object obj) {
            AppMethodBeat.i(261505);
            companion.showUserInfoConfirmDialog(context, str, onClickListener, onClickListener2, (i2 & 16) != 0 ? null : onDismissListener);
            AppMethodBeat.o(261505);
        }

        public final void showUserInfoConfirmDialog(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
            AppMethodBeat.i(261504);
            p.h(context, "context");
            p.h(str, "finderUserName");
            String string = context.getString(R.string.db7);
            p.g(string, "context.getString(R.stri…_user_info_confirm_title)");
            String string2 = context.getString(R.string.db8);
            p.g(string2, "context.getString(R.stri…nder_user_info_ok_button)");
            String string3 = context.getString(R.string.db6);
            p.g(string3, "context.getString(R.stri…_user_info_cancel_button)");
            View inflate = View.inflate(context, R.layout.a9p, null);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(261504);
                throw tVar;
            }
            new UserInfoHelper(context, str, (ViewGroup) inflate).load(new FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialog$$inlined$let$lambda$1(context, str, inflate, string, string2, string3, onClickListener, onClickListener2, onDismissListener));
            AppMethodBeat.o(261504);
        }

        public final void showUserInfoConfirmDialogOnLiveRedPacket(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
            AppMethodBeat.i(261506);
            p.h(context, "context");
            p.h(str, "finderUserName");
            String string = context.getString(R.string.db7);
            p.g(string, "context.getString(R.stri…_user_info_confirm_title)");
            String string2 = context.getString(R.string.db8);
            p.g(string2, "context.getString(R.stri…nder_user_info_ok_button)");
            String string3 = context.getString(R.string.db6);
            p.g(string3, "context.getString(R.stri…_user_info_cancel_button)");
            View inflate = View.inflate(context, R.layout.a9p, null);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(261506);
                throw tVar;
            }
            new UserInfoHelper(context, str, (ViewGroup) inflate).load(new FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialogOnLiveRedPacket$$inlined$let$lambda$1(context, str, inflate, string, string2, string3, onClickListener, onClickListener2));
            AppMethodBeat.o(261506);
        }

        public static /* synthetic */ void showCreateFinderUserDialogOnLiveRedPacket$default(Companion companion, MMActivity mMActivity, int i2, Intent intent, int i3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, int i4, Object obj) {
            Intent intent2;
            int i5;
            DialogInterface.OnClickListener onClickListener3;
            DialogInterface.OnClickListener onClickListener4;
            AppMethodBeat.i(261508);
            if ((i4 & 4) != 0) {
                intent2 = null;
            } else {
                intent2 = intent;
            }
            if ((i4 & 8) != 0) {
                i5 = 0;
            } else {
                i5 = i3;
            }
            if ((i4 & 16) != 0) {
                onClickListener3 = null;
            } else {
                onClickListener3 = onClickListener;
            }
            if ((i4 & 32) != 0) {
                onClickListener4 = null;
            } else {
                onClickListener4 = onClickListener2;
            }
            companion.showCreateFinderUserDialogOnLiveRedPacket(mMActivity, i2, intent2, i5, onClickListener3, onClickListener4, (i4 & 64) != 0 ? null : onDismissListener);
            AppMethodBeat.o(261508);
        }

        public final void showCreateFinderUserDialogOnLiveRedPacket(MMActivity mMActivity, int i2, Intent intent, int i3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
            AppMethodBeat.i(261507);
            p.h(mMActivity, "context");
            String string = mMActivity.getString(R.string.cl1);
            p.g(string, "context.getString(R.string.finder_create_title)");
            String string2 = mMActivity.getString(R.string.j_b);
            p.g(string2, "context.getString(R.stri…nder_create_contact_tips)");
            String string3 = mMActivity.getString(R.string.j_e);
            p.g(string3, "context.getString(R.stri…to_create_finder_account)");
            String string4 = mMActivity.getString(R.string.ckj);
            p.g(string4, "context.getString(R.stri…ate_finder_cancel_button)");
            showConfirmMsgDialog$default(this, mMActivity, null, 0, string, string2, string3, string4, 1, new FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialogOnLiveRedPacket$1(intent, i2, mMActivity, i3, onClickListener), onClickListener2, onDismissListener, 6, null);
            AppMethodBeat.o(261507);
        }

        public static /* synthetic */ void showRealNameCertificationDialogOnRedPacket$default(Companion companion, Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, int i2, Object obj) {
            AppMethodBeat.i(261510);
            if ((i2 & 2) != 0) {
                onClickListener = null;
            }
            if ((i2 & 4) != 0) {
                onClickListener2 = null;
            }
            if ((i2 & 8) != 0) {
                onDismissListener = null;
            }
            companion.showRealNameCertificationDialogOnRedPacket(activity, onClickListener, onClickListener2, onDismissListener);
            AppMethodBeat.o(261510);
        }

        public final void showRealNameCertificationDialogOnRedPacket(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
            AppMethodBeat.i(261509);
            p.h(activity, "context");
            Drawable l = a.l(activity, R.raw.icons_outlined_finder_icon);
            int n = a.n(activity, R.color.Orange);
            String string = activity.getString(R.string.cl1);
            p.g(string, "context.getString(R.string.finder_create_title)");
            String string2 = activity.getString(R.string.j_a);
            p.g(string2, "context.getString(R.stri…out_need_real_name_title)");
            String string3 = activity.getString(R.string.d7j);
            p.g(string3, "context.getString(R.stri…nder_real_name_ok_button)");
            String string4 = activity.getString(R.string.d7h);
            p.g(string4, "context.getString(R.stri…_real_name_cancel_button)");
            showConfirmMsgDialog(activity, l, n, string, string2, string3, string4, 1, new FinderBottomCustomDialogHelper$Companion$showRealNameCertificationDialogOnRedPacket$1(activity, onClickListener), onClickListener2, onDismissListener);
            AppMethodBeat.o(261509);
        }

        public static /* synthetic */ void showCreateFinderUserDialog$default(Companion companion, Context context, int i2, Intent intent, int i3, Object obj) {
            AppMethodBeat.i(261512);
            if ((i3 & 4) != 0) {
                intent = null;
            }
            companion.showCreateFinderUserDialog(context, i2, intent);
            AppMethodBeat.o(261512);
        }

        public final void showCreateFinderUserDialog(Context context, int i2, Intent intent) {
            AppMethodBeat.i(261511);
            p.h(context, "context");
            String string = context.getString(R.string.ckn);
            p.g(string, "context.getString(R.stri…nder_create_finder_title)");
            String string2 = context.getString(R.string.ckk);
            p.g(string2, "context.getString(R.stri…finder_create_finder_msg)");
            String string3 = context.getString(R.string.ckm);
            p.g(string3, "context.getString(R.stri…_create_finder_ok_button)");
            String string4 = context.getString(R.string.ckj);
            p.g(string4, "context.getString(R.stri…ate_finder_cancel_button)");
            showConfirmMsgDialog$default(this, context, null, 0, string, string2, string3, string4, null, new FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$1(intent, i2, context), null, FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$2.INSTANCE, com.tencent.mm.plugin.appbrand.jsapi.n.a.CTRL_INDEX, null);
            AppMethodBeat.o(261511);
        }

        public final void showRealNameCertificationDialog(Activity activity) {
            AppMethodBeat.i(254638);
            p.h(activity, "context");
            Drawable l = a.l(activity, R.raw.icons_outlined_wechat);
            int n = a.n(activity, R.color.ac_);
            String string = activity.getString(R.string.d7r);
            p.g(string, "context.getString(R.string.finder_real_name_title)");
            String string2 = activity.getString(R.string.d7i);
            p.g(string2, "context.getString(R.string.finder_real_name_msg)");
            String string3 = activity.getString(R.string.d7j);
            p.g(string3, "context.getString(R.stri…nder_real_name_ok_button)");
            String string4 = activity.getString(R.string.d7h);
            p.g(string4, "context.getString(R.stri…_real_name_cancel_button)");
            showConfirmMsgDialog$default(this, activity, l, n, string, string2, string3, string4, null, new FinderBottomCustomDialogHelper$Companion$showRealNameCertificationDialog$1(activity), null, FinderBottomCustomDialogHelper$Companion$showRealNameCertificationDialog$2.INSTANCE, 640, null);
            AppMethodBeat.o(254638);
        }

        public static /* synthetic */ e showConfirmMsgDialog$default(Companion companion, Context context, Drawable drawable, int i2, String str, String str2, String str3, String str4, Integer num, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, int i3, Object obj) {
            Drawable drawable2;
            int i4;
            int i5;
            DialogInterface.OnClickListener onClickListener3;
            AppMethodBeat.i(261514);
            if ((i3 & 2) != 0) {
                drawable2 = null;
            } else {
                drawable2 = drawable;
            }
            if ((i3 & 4) != 0) {
                i4 = -1;
            } else {
                i4 = i2;
            }
            if ((i3 & 128) != 0) {
                i5 = 0;
            } else {
                i5 = num;
            }
            if ((i3 & 512) != 0) {
                onClickListener3 = null;
            } else {
                onClickListener3 = onClickListener2;
            }
            e showConfirmMsgDialog = companion.showConfirmMsgDialog(context, drawable2, i4, str, str2, str3, str4, i5, onClickListener, onClickListener3, (i3 & 1024) != 0 ? null : onDismissListener);
            AppMethodBeat.o(261514);
            return showConfirmMsgDialog;
        }

        public final e showConfirmMsgDialog(Context context, Drawable drawable, int i2, String str, String str2, String str3, String str4, Integer num, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
            AppMethodBeat.i(261513);
            p.h(context, "context");
            p.h(str2, "msg");
            View inflate = View.inflate(context, R.layout.a9o, null);
            TextView textView = (TextView) inflate.findViewById(R.id.d0a);
            p.g(textView, "msgView");
            textView.setText(Util.nullAsNil(str2));
            p.g(inflate, "msgContainer");
            e showConfirmDialog = showConfirmDialog(context, drawable, i2, str, inflate, str3, str4, num, onClickListener, onClickListener2, onDismissListener);
            AppMethodBeat.o(261513);
            return showConfirmDialog;
        }

        public static /* synthetic */ e showConfirmDialog$default(Companion companion, Context context, Drawable drawable, int i2, String str, View view, String str2, String str3, Integer num, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, int i3, Object obj) {
            Drawable drawable2;
            int i4;
            int i5;
            DialogInterface.OnClickListener onClickListener3;
            AppMethodBeat.i(261516);
            if ((i3 & 2) != 0) {
                drawable2 = null;
            } else {
                drawable2 = drawable;
            }
            if ((i3 & 4) != 0) {
                i4 = -1;
            } else {
                i4 = i2;
            }
            if ((i3 & 128) != 0) {
                i5 = 0;
            } else {
                i5 = num;
            }
            if ((i3 & 512) != 0) {
                onClickListener3 = null;
            } else {
                onClickListener3 = onClickListener2;
            }
            e showConfirmDialog = companion.showConfirmDialog(context, drawable2, i4, str, view, str2, str3, i5, onClickListener, onClickListener3, (i3 & 1024) != 0 ? null : onDismissListener);
            AppMethodBeat.o(261516);
            return showConfirmDialog;
        }

        public final e showConfirmDialog(Context context, Drawable drawable, int i2, String str, View view, String str2, String str3, Integer num, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
            AppMethodBeat.i(261515);
            p.h(context, "context");
            p.h(view, "content");
            e eVar = new e(context, 1, false);
            View inflate = View.inflate(context, R.layout.a9q, null);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
                AppMethodBeat.o(261515);
                throw tVar;
            }
            RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) inflate;
            ((FrameLayout) roundedCornerFrameLayout.findViewById(R.id.cky)).addView(view);
            WeImageView weImageView = (WeImageView) roundedCornerFrameLayout.findViewById(R.id.cme);
            if (drawable != null) {
                weImageView.setImageDrawable(drawable);
            } else {
                weImageView.setImageDrawable(a.l(context, R.raw.icons_outlined_finder_icon));
            }
            if (i2 != -1) {
                weImageView.setIconColor(i2);
            } else {
                weImageView.setIconColor(a.n(context, R.color.Orange));
            }
            TextView textView = (TextView) roundedCornerFrameLayout.findViewById(R.id.d3x);
            if (!Util.isNullOrNil(str)) {
                p.g(textView, "titleTv");
                textView.setText(str);
            }
            Button button = (Button) roundedCornerFrameLayout.findViewById(R.id.g3k);
            if (!Util.isNullOrNil(str2)) {
                p.g(button, "okBtn");
                button.setText(str2);
            }
            Button button2 = (Button) roundedCornerFrameLayout.findViewById(R.id.aib);
            if (!Util.isNullOrNil(str3)) {
                p.g(button2, "cancelBtn");
                button2.setText(str3);
            }
            roundedCornerFrameLayout.s((float) at.fromDPToPix(context, 12), (float) at.fromDPToPix(context, 12), 0.0f, 0.0f);
            button.setOnClickListener(new FinderBottomCustomDialogHelper$Companion$showConfirmDialog$1(eVar, onClickListener));
            button2.setOnClickListener(new FinderBottomCustomDialogHelper$Companion$showConfirmDialog$2(eVar, onClickListener2));
            eVar.b(new FinderBottomCustomDialogHelper$Companion$showConfirmDialog$3(onDismissListener));
            eVar.a(new FinderBottomCustomDialogHelper$Companion$showConfirmDialog$4(eVar, roundedCornerFrameLayout));
            if (num != null && num.intValue() == 1) {
                button.setTextColor(context.getResources().getColor(R.color.ag5));
                p.g(button, "okBtn");
                button.setBackground(context.getResources().getDrawable(R.drawable.cuz));
                button2.setTextColor(context.getResources().getColor(R.color.a5r));
            }
            eVar.Dm(true);
            eVar.dGm();
            AppMethodBeat.o(261515);
            return eVar;
        }
    }

    public static final class UserInfoHelper implements i {
        public static final Companion Companion = new Companion(null);
        public static final String TAG;
        private static final h<String, FinderProfileHeaderUIC.b> userExtInfoCache = new h<>(100);
        private b<? super Boolean, x> callback = FinderBottomCustomDialogHelper$UserInfoHelper$callback$1.INSTANCE;
        private final Context context;
        private d<?> dialogRunnable;
        private q loadingDialog;
        private final ViewGroup userInfoContainer;
        private final String username;

        public UserInfoHelper(Context context2, String str, ViewGroup viewGroup) {
            p.h(context2, "context");
            p.h(str, ch.COL_USERNAME);
            p.h(viewGroup, "userInfoContainer");
            AppMethodBeat.i(254659);
            this.context = context2;
            this.username = str;
            this.userInfoContainer = viewGroup;
            AppMethodBeat.o(254659);
        }

        public static final /* synthetic */ void access$loadInternal(UserInfoHelper userInfoHelper) {
            AppMethodBeat.i(254661);
            userInfoHelper.loadInternal();
            AppMethodBeat.o(254661);
        }

        public final Context getContext() {
            return this.context;
        }

        public final String getUsername() {
            return this.username;
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }

            public final h<String, FinderProfileHeaderUIC.b> getUserExtInfoCache() {
                AppMethodBeat.i(254643);
                h<String, FinderProfileHeaderUIC.b> hVar = UserInfoHelper.userExtInfoCache;
                AppMethodBeat.o(254643);
                return hVar;
            }
        }

        static {
            AppMethodBeat.i(254660);
            AppMethodBeat.o(254660);
        }

        private final void doSceneForUserInfo(String str) {
            AppMethodBeat.i(254648);
            Log.i(TAG, "doSceneForUserInfo, username:".concat(String.valueOf(str)));
            d<?> dVar = this.dialogRunnable;
            if (dVar != null) {
                dVar.cancel(false);
            }
            this.dialogRunnable = com.tencent.f.h.RTc.n(new FinderBottomCustomDialogHelper$UserInfoHelper$doSceneForUserInfo$1(this), 1500);
            g.azz().a(3736, this);
            com.tencent.mm.ak.t azz = g.azz();
            cn cnVar = new cn(str, 0, null, 0, null, 0, 0, 110);
            cnVar.twC = true;
            azz.b(cnVar);
            AppMethodBeat.o(254648);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            FinderProfileHeaderUIC.b bVar;
            AppMethodBeat.i(254649);
            q qVar2 = this.loadingDialog;
            if (qVar2 != null) {
                qVar2.dismiss();
            }
            d<?> dVar = this.dialogRunnable;
            if (dVar != null) {
                dVar.cancel(false);
            }
            if (i2 != 0 || i3 != 0) {
                this.callback.invoke(Boolean.FALSE);
            } else if (qVar instanceof cn) {
                StringBuilder append = new StringBuilder("username=").append(this.username).append(", scene username=");
                FinderContact cZk = ((cn) qVar).cZk();
                Log.i(TAG, append.append(cZk != null ? cZk.username : null).toString());
                FinderProfileHeaderUIC.b bVar2 = (FinderProfileHeaderUIC.b) userExtInfoCache.get(this.username);
                if (bVar2 == null) {
                    bVar = new FinderProfileHeaderUIC.b();
                } else {
                    bVar = bVar2;
                }
                bVar.fansCount = ((cn) qVar).fansCount;
                bVar.friendFollowCount = ((cn) qVar).friendFollowCount;
                bVar.at(new LinkedList<>(((cn) qVar).userTags));
                bVar.vcb = ((cn) qVar).cZl();
                userExtInfoCache.put(this.username, bVar);
                new MMHandler(Looper.getMainLooper()).postUI(new FinderBottomCustomDialogHelper$UserInfoHelper$onSceneEnd$1(this));
            }
            g.azz().b(3736, this);
            AppMethodBeat.o(254649);
        }

        public final void load(b<? super Boolean, x> bVar) {
            AppMethodBeat.i(254650);
            p.h(bVar, "callback");
            this.callback = bVar;
            if (!userExtInfoCache.check(this.username)) {
                doSceneForUserInfo(this.username);
                AppMethodBeat.o(254650);
                return;
            }
            loadInternal();
            AppMethodBeat.o(254650);
        }

        private final void loadInternal() {
            AppMethodBeat.i(254651);
            Object obj = userExtInfoCache.get(this.username);
            p.g(obj, "userExtInfoCache[username]");
            String userTagText = getUserTagText((FinderProfileHeaderUIC.b) obj);
            c.a aVar = c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(this.username);
            String spannableString = l.c(this.context, asG != null ? asG.getNickname() : null).toString();
            p.g(spannableString, "MMSpanManager.spanForSmi…act?.nickname).toString()");
            int totalAvailableWidth = getTotalAvailableWidth();
            float changeLeftRegionWidth = getChangeLeftRegionWidth(spannableString);
            TextView textView = (TextView) this.userInfoContainer.findViewById(R.id.d2q);
            p.g(textView, "userInfoContainer.finder_profile_name_tv");
            float measureText = textView.getPaint().measureText(spannableString);
            float locationTextWidth = getLocationTextWidth(userTagText);
            if (measureText + changeLeftRegionWidth > ((float) totalAvailableWidth) || locationTextWidth > ((float) totalAvailableWidth)) {
                setProfileTextWidth(spannableString, userTagText, totalAvailableWidth - a.aH(this.userInfoContainer.getContext(), R.dimen.cb), (int) changeLeftRegionWidth);
            } else {
                setProfileTextWidth(spannableString, userTagText, totalAvailableWidth, (int) changeLeftRegionWidth);
            }
            handleNickname(asG, this.userInfoContainer);
            handleAuth(asG);
            this.callback.invoke(Boolean.TRUE);
            AppMethodBeat.o(254651);
        }

        private final void handleNickname(com.tencent.mm.plugin.finder.api.g gVar, ViewGroup viewGroup) {
            AppMethodBeat.i(254652);
            if (gVar == null) {
                AppMethodBeat.o(254652);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.d2p);
            p.g(linearLayout, "userInfoContainer.finder_profile_name_container");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.o(254652);
                throw tVar;
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            TextView textView = (TextView) viewGroup.findViewById(R.id.j1q);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.d2q);
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.d1q);
            p.g(textView, "userTagLayout");
            if (textView.getVisibility() == 4) {
                layoutParams2.bottomToTop = -1;
                layoutParams2.topToTop = R.id.d1r;
                layoutParams2.bottomToBottom = R.id.d1r;
            } else {
                layoutParams2.bottomToTop = R.id.d1s;
                layoutParams2.topToTop = -1;
                layoutParams2.bottomToBottom = -1;
            }
            LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(R.id.d2p);
            p.g(linearLayout2, "userInfoContainer.finder_profile_name_container");
            linearLayout2.setLayoutParams(layoutParams2);
            p.g(textView2, "userNameTv");
            ao.a(textView2.getPaint(), 0.8f);
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> dka = m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(gVar.field_avatarUrl);
            p.g(imageView, "userAvatarIv");
            m mVar2 = m.uJa;
            dka.a(aVar, imageView, m.a(m.a.AVATAR));
            AppMethodBeat.o(254652);
        }

        private final void handleAuth(com.tencent.mm.plugin.finder.api.g gVar) {
            FinderAuthInfo finderAuthInfo;
            AppMethodBeat.i(254653);
            if (gVar == null || (finderAuthInfo = gVar.field_authInfo) == null) {
                Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] profileContact=" + (gVar != null));
                AppMethodBeat.o(254653);
            } else if (finderAuthInfo.authIconType <= 0) {
                Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] authIconType<=0");
                AppMethodBeat.o(254653);
            } else {
                y yVar = y.vXH;
                ImageView imageView = (ImageView) this.userInfoContainer.findViewById(R.id.d1o);
                p.g(imageView, "userInfoContainer.finder_profile_auth_icon");
                y.a(imageView, finderAuthInfo);
                AppMethodBeat.o(254653);
            }
        }

        private final float getLocationTextWidth(String str) {
            AppMethodBeat.i(254654);
            float f2 = 0.0f;
            if (!Util.isNullOrNil(str)) {
                TextView textView = (TextView) this.userInfoContainer.findViewById(R.id.j1q);
                p.g(textView, "userInfoContainer.user_tag_layout");
                f2 = textView.getPaint().measureText(str);
            }
            AppMethodBeat.o(254654);
            return f2;
        }

        private final void setProfileTextWidth(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(254655);
            TextView textView = (TextView) this.userInfoContainer.findViewById(R.id.d2q);
            p.g(textView, "userInfoContainer.finder_profile_name_tv");
            textView.setMaxWidth(i2 - i3);
            TextView textView2 = (TextView) this.userInfoContainer.findViewById(R.id.d2q);
            p.g(textView2, "userInfoContainer.finder_profile_name_tv");
            textView2.setText(str);
            TextView textView3 = (TextView) this.userInfoContainer.findViewById(R.id.j1q);
            p.g(textView3, "userInfoContainer.user_tag_layout");
            textView3.setMaxWidth(i2);
            TextView textView4 = (TextView) this.userInfoContainer.findViewById(R.id.j1q);
            p.g(textView4, "userInfoContainer.user_tag_layout");
            textView4.setText(str2);
            AppMethodBeat.o(254655);
        }

        private final float getChangeLeftRegionWidth(String str) {
            float f2;
            AppMethodBeat.i(254656);
            ImageView imageView = (ImageView) this.userInfoContainer.findViewById(R.id.d1o);
            p.g(imageView, "userInfoContainer.finder_profile_auth_icon");
            if (imageView.getVisibility() == 0) {
                f2 = ((float) a.aH(this.userInfoContainer.getContext(), R.dimen.cc)) + 0.0f;
            } else {
                f2 = 0.0f;
            }
            AppMethodBeat.o(254656);
            return f2;
        }

        private final int getTotalAvailableWidth() {
            AppMethodBeat.i(254657);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Context context2 = this.userInfoContainer.getContext();
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(254657);
                throw tVar;
            }
            WindowManager windowManager = ((Activity) context2).getWindowManager();
            p.g(windowManager, "(userInfoContainer.conte…s Activity).windowManager");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            Log.i(TAG, "screen width :" + displayMetrics.widthPixels);
            int aH = displayMetrics.widthPixels - a.aH(this.userInfoContainer.getContext(), R.dimen.a4o);
            AppMethodBeat.o(254657);
            return aH;
        }

        private final String getUserTagText(FinderProfileHeaderUIC.b bVar) {
            String str;
            AppMethodBeat.i(254658);
            LinkedList<String> linkedList = bVar.userTags;
            if (!linkedList.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<T> it = linkedList.iterator();
                while (it.hasNext()) {
                    sb.append((String) it.next()).append(" ");
                }
                SpannableString c2 = l.c(this.context, sb.toString());
                if (c2 != null) {
                    str = c2.toString();
                    p.g(str, "this.toString()");
                    AppMethodBeat.o(254658);
                    return str;
                }
            }
            str = "";
            AppMethodBeat.o(254658);
            return str;
        }
    }
}
