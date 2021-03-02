package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.activity.FinderActivityProfileUI;
import com.tencent.mm.plugin.finder.edit.FinderFixRatioPhoneEditPluginLayout;
import com.tencent.mm.plugin.finder.edit.FinderPhotoEditPluginLayout;
import com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout;
import com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveInvitedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMsgUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoDetailUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI1;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI11;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI12;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI14;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI16;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI3;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI4;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI8;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI9;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.FinderFeedSearchUI;
import com.tencent.mm.plugin.finder.search.FinderMixSearchUI;
import com.tencent.mm.plugin.finder.search.FinderTopicSearchUI;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.ai;
import com.tencent.mm.plugin.finder.ui.FinderActivityDescUI;
import com.tencent.mm.plugin.finder.ui.FinderActivityPostUI;
import com.tencent.mm.plugin.finder.ui.FinderAlbumUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI;
import com.tencent.mm.plugin.finder.ui.FinderBlockListUI;
import com.tencent.mm.plugin.finder.ui.FinderConversationTempUI;
import com.tencent.mm.plugin.finder.ui.FinderConversationUI;
import com.tencent.mm.plugin.finder.ui.FinderConversationXXUI;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
import com.tencent.mm.plugin.finder.ui.FinderCreateGuideUI;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.FinderEditTextUI;
import com.tencent.mm.plugin.finder.ui.FinderFansListUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderFollowListUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI;
import com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI;
import com.tencent.mm.plugin.finder.ui.FinderManagementUI;
import com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI;
import com.tencent.mm.plugin.finder.ui.FinderModifyNameUI;
import com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.ui.FinderPostRouterUI;
import com.tencent.mm.plugin.finder.ui.FinderPostUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectSexUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.FinderUnOpenUI;
import com.tencent.mm.plugin.finder.ui.FinderWxMsgUI;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.fgv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

public final class a {
    public static final a vUU = new a();

    static {
        AppMethodBeat.i(167872);
        AppMethodBeat.o(167872);
    }

    private a() {
    }

    public static /* synthetic */ void v(Context context, Intent intent) {
        AppMethodBeat.i(167837);
        a(context, intent, 2);
        AppMethodBeat.o(167837);
    }

    public static void a(Context context, Intent intent, int i2) {
        AppMethodBeat.i(167836);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("FROM_SCENE_KEY", i2);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.setClass(context, FinderHomeUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167836);
    }

    public static void w(Context context, Intent intent) {
        AppMethodBeat.i(167838);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderCreateContactUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167838);
    }

    public static void d(MMActivity mMActivity, Intent intent, int i2) {
        AppMethodBeat.i(261426);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (intent == null) {
            intent = new Intent();
        }
        intent.addFlags(67108864);
        intent.setClass(mMActivity, FinderCreateContactUI.class);
        mMActivity.startActivityForResult(intent, i2);
        AppMethodBeat.o(261426);
    }

    public static void enterFinderFollowListUI(Context context, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(253262);
        p.h(context, "context");
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        Intent intent3 = !(context instanceof Activity) ? intent2 : null;
        if (intent3 != null) {
            intent3.addFlags(268435456);
        }
        intent2.addFlags(67108864);
        intent2.setClass(context, FinderFollowListUI.class);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent2, 0, 0, false, 124);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFollowListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253262);
    }

    public static /* synthetic */ boolean fs(Context context) {
        AppMethodBeat.i(253264);
        p.h(context, "context");
        AppMethodBeat.o(253264);
        return false;
    }

    public static boolean fr(Context context) {
        AppMethodBeat.i(253263);
        p.h(context, "context");
        AppMethodBeat.o(253263);
        return false;
    }

    public static boolean c(Context context, String str, Intent intent) {
        AppMethodBeat.i(253265);
        p.h(context, "context");
        p.h(str, "intentString");
        p.h(intent, "extra");
        if (!Util.isNullOrNil(str)) {
            try {
                byte[] bqe = com.tencent.e.f.e.bqe(str);
                Parcel obtain = Parcel.obtain();
                p.g(obtain, "Parcel.obtain()");
                obtain.unmarshall(bqe, 0, bqe.length);
                obtain.setDataPosition(0);
                Intent intent2 = (Intent) Intent.CREATOR.createFromParcel(obtain);
                intent2.setExtrasClassLoader(LocalVideoCropInfoParcelable.CREATOR.getClass().getClassLoader());
                intent2.putExtras(intent);
                if (!Util.isNullOrNil(intent2.getStringExtra("saveText"))) {
                    E(context, intent2);
                } else {
                    enterFinderPostUI(context, intent2);
                }
                AppMethodBeat.o(253265);
                return true;
            } catch (Exception e2) {
                Log.e("Finder.ActivityRouter", "goDraft() ".concat(String.valueOf(e2)));
            }
        }
        AppMethodBeat.o(253265);
        return false;
    }

    public static void enterFinderPostUI(Context context, Intent intent) {
        AppMethodBeat.i(167840);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderPostUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167840);
    }

    public static void x(Context context, Intent intent) {
        AppMethodBeat.i(253266);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, OccupyFinderUI4.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253266);
    }

    public static void enterFinderPostRouterUI(Context context, Intent intent) {
        AppMethodBeat.i(167841);
        p.h(context, "context");
        com.tencent.mm.plugin.finder.upload.d dVar = com.tencent.mm.plugin.finder.upload.d.vSt;
        if (!com.tencent.mm.plugin.finder.upload.d.cameraCheck(context)) {
            Log.i("Finder.ActivityRouter", "enterFinderPostRouterUI cameraCheck false!");
            AppMethodBeat.o(167841);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderPostRouterUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.dq, R.anim.s);
        }
        AppMethodBeat.o(167841);
    }

    public static void b(Intent intent, Intent intent2) {
        AppMethodBeat.i(167842);
        p.h(intent, "intent");
        p.h(intent2, "curIntent");
        intent.putExtra("key_finder_post_from", intent2.getIntExtra("key_finder_post_from", -1));
        AppMethodBeat.o(167842);
    }

    public static void enterFinderProfileUI(Context context, Intent intent) {
        AppMethodBeat.i(167843);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderProfileUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167843);
    }

    public static void y(Context context, Intent intent) {
        AppMethodBeat.i(167844);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderProfileTimeLineUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167844);
    }

    public static void ft(Context context) {
        AppMethodBeat.i(167845);
        p.h(context, "context");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderSettingInfoUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167845);
    }

    public static void z(Context context, Intent intent) {
        AppMethodBeat.i(253267);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderSelfUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253267);
    }

    public static void a(Context context, aqw aqw, Intent intent) {
        AppMethodBeat.i(167847);
        p.h(context, "context");
        p.h(intent, "i");
        i iVar = i.vvu;
        i.a(aqw);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 2, 1, false);
        intent.setClass(context, FinderContactSearchUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167847);
    }

    public static void A(Context context, Intent intent) {
        AppMethodBeat.i(253268);
        p.h(context, "context");
        p.h(intent, "i");
        i iVar = i.vvu;
        i.a(null);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 2, 1, false);
        intent.setClass(context, FinderContactSearchIncludeFollowUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253268);
    }

    public static void B(Context context, Intent intent) {
        AppMethodBeat.i(253269);
        p.h(context, "context");
        p.h(intent, "i");
        i iVar = i.vvu;
        i.a(null);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 2, 1, false);
        intent.setClass(context, FinderTopicSearchUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTopicSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTopicSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253269);
    }

    public static void a(MMActivity mMActivity, Intent intent) {
        AppMethodBeat.i(253270);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(intent, "i");
        i iVar = i.vvu;
        i.a(null);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 2, 1, false);
        intent.setClass(mMActivity, FinderContactSearchIncludeFollowUI.class);
        mMActivity.startActivityForResult(intent, com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
        AppMethodBeat.o(253270);
    }

    public static void b(Context context, aqw aqw, Intent intent) {
        AppMethodBeat.i(253271);
        p.h(context, "context");
        p.h(intent, "i");
        i iVar = i.vvu;
        i.a(aqw);
        intent.setClass(context, FinderFeedSearchUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 1, 1, false);
        AppMethodBeat.o(253271);
    }

    public static void C(Context context, Intent intent) {
        AppMethodBeat.i(253272);
        p.h(context, "context");
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avn("search") != 0) {
            com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
            h.a(context, com.tencent.mm.plugin.finder.spam.a.avo("search"), "", context.getString(R.string.j34), (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(253272);
            return;
        }
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 0, 1, false);
        intent.setClass(context, FinderMixSearchUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253272);
    }

    public static void D(Context context, Intent intent) {
        AppMethodBeat.i(253273);
        p.h(context, "context");
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avn("search") != 0) {
            com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
            h.a(context, com.tencent.mm.plugin.finder.spam.a.avo("search"), "", context.getString(R.string.j34), (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(253273);
            return;
        }
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 0, 1, false);
        intent.setClass(context, FinderLongVideoPreviewUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHotSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253273);
    }

    public static void E(Context context, Intent intent) {
        AppMethodBeat.i(167851);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderEditTextUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167851);
    }

    public static void F(Context context, Intent intent) {
        AppMethodBeat.i(167852);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderShareFeedRelUI.class);
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.dnS();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167852);
    }

    public static void G(Context context, Intent intent) {
        AppMethodBeat.i(253274);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderShareFeedDetailUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253274);
    }

    public static void H(Context context, Intent intent) {
        AppMethodBeat.i(167853);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderRetransmitSourceUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167853);
    }

    public static void I(Context context, Intent intent) {
        AppMethodBeat.i(167854);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderMsgFeedDetailUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167854);
    }

    public static /* synthetic */ void J(Context context, Intent intent) {
        int i2 = -1;
        AppMethodBeat.i(253275);
        Boolean bool = Boolean.FALSE;
        Integer num = -1;
        p.h(context, "context");
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderAlbumUI.class);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drH()) {
            intent.putExtra("key_can_select_video_and_pic", true);
        }
        intent.putExtra("is_hide_album_footer", true);
        intent.putExtra("show_header_view", false);
        intent.putExtra("max_select_count", 9);
        intent.putExtra("query_source_type", 25);
        intent.putExtra("query_media_type", 3);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        intent.putExtra("album_video_max_duration", com.tencent.mm.plugin.finder.storage.c.dqA());
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        intent.putExtra("album_video_min_duration", com.tencent.mm.plugin.finder.storage.c.dqx().minDuration);
        if (!p.j(bool, Boolean.TRUE) || !(context instanceof Activity)) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(253275);
            return;
        }
        Activity activity = (Activity) context;
        if (num != null) {
            i2 = num.intValue();
        }
        activity.startActivityForResult(intent, i2);
        AppMethodBeat.o(253275);
    }

    public static void K(Context context, Intent intent) {
        AppMethodBeat.i(253276);
        p.h(context, "context");
        if (!((aj) com.tencent.mm.kernel.g.ah(aj.class)).canEnterMvAndShowToast()) {
            AppMethodBeat.o(253276);
            return;
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        try {
            Class<?> cls = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvMainUI");
            p.g(cls, "Class.forName(\"com.tence…gin.mv.ui.MusicMvMainUI\")");
            intent.setClass(context, cls);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMainUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(253276);
        } catch (ClassNotFoundException e2) {
            Log.e("Finder.ActivityRouter", "enterMusicMvMainUI : ".concat(String.valueOf(e2)));
            AppMethodBeat.o(253276);
        }
    }

    public static void L(Context context, Intent intent) {
        AppMethodBeat.i(253277);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        try {
            Class<?> cls = Class.forName("com.tencent.mm.plugin.mv.ui.MusicMvRouterUI");
            p.g(cls, "Class.forName(\"com.tence…n.mv.ui.MusicMvRouterUI\")");
            intent.putExtra("KEY_MUSIC_ROUTER", 3);
            intent.setClass(context, cls);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMusicMvMakerUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(253277);
        } catch (ClassNotFoundException e2) {
            Log.e("Finder.ActivityRouter", "enterMusicMvMakerUI : ".concat(String.valueOf(e2)));
            AppMethodBeat.o(253277);
        }
    }

    public static /* synthetic */ void a(Activity activity, String str, int i2, Matrix matrix, Rect rect) {
        AppMethodBeat.i(253279);
        a(activity, str, i2, matrix, rect, (float[]) null);
        AppMethodBeat.o(253279);
    }

    public static void a(Activity activity, String str, int i2, Matrix matrix, Rect rect, float[] fArr) {
        AppMethodBeat.i(253278);
        p.h(activity, "context");
        p.h(str, "rawPath");
        p.h(matrix, "matrix");
        p.h(rect, "cropRect");
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(false);
        aVar.apF();
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        Bundle bundle = new Bundle();
        bundle.putParcelable("cropRect", rect);
        bundle.putFloatArray("matrix", fArr2);
        bundle.putFloatArray("offset", fArr);
        if (i2 == 2) {
            RecordConfigProvider aD = RecordConfigProvider.aD(str, "", "");
            aD.scene = 11;
            aD.BOn = aVar.apG();
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            aD.BOm = com.tencent.mm.plugin.finder.storage.c.dqx();
            aD.remuxType = 2;
            aD.BOp = 3;
            aD.BOv = aD.BOm.duration * 1000;
            aVar.dy(false);
            aD.jkf = bundle;
            aD.F(2, FinderVideoEditPluginLayout.class.getName());
            com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(activity, 1, R.anim.s, R.anim.s, aD, 2, 0);
            AppMethodBeat.o(253278);
            return;
        }
        if (i2 == 1) {
            aVar.apC();
            RecordConfigProvider jA = RecordConfigProvider.jA(str, "");
            jA.scene = 11;
            jA.BOn = aVar.apG();
            jA.jkf = bundle;
            jA.F(1, FinderPhotoEditPluginLayout.class.getName());
            com.tencent.mm.plugin.recordvideo.jumper.a aVar3 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(activity, 1, R.anim.s, R.anim.s, jA, 1, 1);
        }
        AppMethodBeat.o(253278);
    }

    public static void f(Activity activity, String str, String str2) {
        AppMethodBeat.i(261427);
        p.h(activity, "context");
        p.h(str, "inputPath");
        p.h(str2, "outputPath");
        RecordConfigProvider jA = RecordConfigProvider.jA(str, str2);
        jA.scene = 11;
        Bundle bundle = new Bundle();
        bundle.putFloat("crop_fix_ratio", 0.75f);
        jA.jkf = bundle;
        jA.F(1, FinderFixRatioPhoneEditPluginLayout.class.getName());
        CaptureDataManager.BOb.a(null);
        com.tencent.mm.plugin.recordvideo.jumper.a aVar = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(activity, 20002, R.anim.s, R.anim.s, jA, 1, 1);
        AppMethodBeat.o(261427);
    }

    public static /* synthetic */ void a(Activity activity, ViewAnimHelper.ViewInfo viewInfo, cjk cjk, azy azy, boolean z, int i2) {
        AppMethodBeat.i(253280);
        if ((i2 & 8) != 0) {
            azy = null;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        p.h(activity, "context");
        p.h(cjk, "localContent");
        Intent intent = new Intent();
        intent.setClass(activity, FinderMediaPreviewUI.class);
        intent.putExtra("media_list_", cjk.toByteArray());
        intent.putExtra("crop_info", viewInfo);
        intent.putExtra("media_list_count", cjk.mediaList.size());
        intent.putExtra("ref_feed_info", azy != null ? azy.toByteArray() : null);
        intent.putExtra("long_video_preview", z);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (!z) {
            activity.overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(253280);
    }

    public static void fu(Context context) {
        AppMethodBeat.i(167859);
        p.h(context, "context");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        intent.setClass(context, FinderWxMsgUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167859);
    }

    public static void M(Context context, Intent intent) {
        AppMethodBeat.i(167860);
        p.h(context, "context");
        intent.setClass(context, FinderImagePreviewUI.class);
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167860);
    }

    public static void fv(Context context) {
        AppMethodBeat.i(167861);
        p.h(context, "context");
        Intent intent = new Intent();
        intent.setClass(context, FinderSelfQRCodeUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167861);
    }

    public static void N(Context context, Intent intent) {
        AppMethodBeat.i(167862);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderModifyNameUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167862);
    }

    public static void b(Activity activity, Intent intent, int i2) {
        AppMethodBeat.i(167863);
        p.h(activity, "context");
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(activity, FinderCropAvatarUI.class);
        intent.putExtra("key_result_file_name", "finder_avatar.tmp");
        intent.putExtra("key_crop_source", 1);
        activity.startActivityForResult(intent, i2);
        AppMethodBeat.o(167863);
    }

    public static void g(Activity activity, String str) {
        String str2;
        AppMethodBeat.i(253281);
        p.h(activity, "context");
        Bundle bundle = new Bundle();
        if (Util.isNullOrNil(str)) {
            ComponentName componentName = activity.getComponentName();
            p.g(componentName, "context.componentName");
            String className = componentName.getClassName();
            p.g(className, "context.componentName.className");
            String str3 = MMApplicationContext.getSourcePackageName() + ".plugin.finder";
            if (n.J(className, str3, false)) {
                int length = str3.length();
                if (className == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(253281);
                    throw tVar;
                }
                str2 = className.substring(length);
                p.g(str2, "(this as java.lang.String).substring(startIndex)");
            } else {
                str2 = className;
            }
            Log.i("Finder.ActivityRouter", "fullActivity " + className + ", fromActivity " + str2);
            bundle.putString("realname_verify_process_jump_activity", str2);
        } else {
            bundle.putString("realname_verify_process_jump_activity", str);
        }
        bundle.putString("realname_verify_process_jump_plugin", "finder");
        ((com.tencent.mm.plugin.wxpaysdk.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wxpaysdk.api.c.class)).h(activity, bundle);
        AppMethodBeat.o(253281);
    }

    public static /* synthetic */ void am(Activity activity) {
        AppMethodBeat.i(253282);
        h(activity, (String) null);
        AppMethodBeat.o(253282);
    }

    public static void h(Activity activity, String str) {
        AppMethodBeat.i(167864);
        p.h(activity, "context");
        if (!Util.isNullOrNil(str) || (activity instanceof FinderHomeUI) || (activity instanceof FinderTimelineUI) || (activity instanceof FinderSelfUI)) {
            g(activity, str);
            AppMethodBeat.o(167864);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, OccupyFinderUI5.class);
        intent.putExtra("enterRealnameVerifyUI", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRealnameVerifyUI", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167864);
    }

    public static void fw(Context context) {
        AppMethodBeat.i(167866);
        p.h(context, "context");
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(context, FinderUnOpenUI.class));
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167866);
    }

    public static void d(String str, Context context) {
        AppMethodBeat.i(167867);
        p.h(context, "context");
        Intent intent = new Intent();
        if (str == null) {
            str = "";
        }
        intent.putExtra("Contact_User", str);
        com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(167867);
    }

    public static void y(Context context, String str, String str2) {
        AppMethodBeat.i(167868);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(str2, "enterPath");
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.username = str;
        gVar.kHw = Util.nullAs(str2, "");
        gVar.scene = TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
        AppMethodBeat.o(167868);
    }

    public static void a(Context context, String str, String str2, int i2, String str3) {
        AppMethodBeat.i(253283);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(str2, "enterPath");
        p.h(str3, "sceneNote");
        Log.i("Finder.ActivityRouter", "enter we app appId:" + str + ",enterPath:" + str2 + ",scene:" + i2 + ",sceneNote:" + str3);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(253283);
            return;
        }
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.appId = str;
        gVar.kHw = str2;
        gVar.scene = i2;
        gVar.dCw = str3;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
        AppMethodBeat.o(253283);
    }

    public static void a(Context context, String str, String str2, int i2, String str3, Boolean bool) {
        AppMethodBeat.i(261428);
        p.h(context, "context");
        p.h(str, "appName");
        p.h(str2, "enterPath");
        p.h(str3, "sceneNote");
        Log.i("Finder.ActivityRouter", "enter we app appId:" + str + ",enterPath:" + str2 + ",scene:" + i2 + ",sceneNote:" + str3);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(261428);
            return;
        }
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.username = str;
        gVar.kHw = str2;
        gVar.scene = i2;
        gVar.dCw = str3;
        if (p.j(bool, Boolean.TRUE)) {
            gVar.iOo = 2;
        }
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
        AppMethodBeat.o(261428);
    }

    public static void a(MMActivity mMActivity, Intent intent, int i2) {
        AppMethodBeat.i(167869);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        intent.setClass(mMActivity, FinderSelectSexUI.class);
        mMActivity.startActivityForResult(intent, i2);
        AppMethodBeat.o(167869);
    }

    public static void O(Context context, Intent intent) {
        Intent intent2;
        Intent intent3 = null;
        AppMethodBeat.i(167870);
        p.h(context, "context");
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        if ((intent2 != null ? Boolean.valueOf(intent2.getBooleanExtra("key_finder_teen_mode_check", false)) : null).booleanValue()) {
            ai.a aVar = ai.vFj;
            ai.a.b(context, intent2, new e(intent2, context));
            AppMethodBeat.o(167870);
            return;
        }
        if (!(context instanceof Activity)) {
            intent3 = intent2;
        }
        if (intent3 != null) {
            intent3.addFlags(268435456);
        }
        intent2.setClass(context, FinderTopicFeedUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167870);
    }

    public static final class e implements ad.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;

        e(Intent intent, Context context) {
            this.$intent = intent;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.i.a.ad.a
        public final void mM(boolean z) {
            AppMethodBeat.i(253261);
            if (z) {
                Intent intent = this.$intent;
                if (intent == null) {
                    p.hyc();
                }
                intent.putExtra("key_finder_teen_mode_check", false);
                a aVar = a.vUU;
                a.O(this.$context, this.$intent);
            }
            AppMethodBeat.o(253261);
        }
    }

    public static void P(Context context, Intent intent) {
        AppMethodBeat.i(167871);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderTopicTimelineUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(167871);
    }

    public static void b(MMActivity mMActivity, Intent intent, int i2) {
        AppMethodBeat.i(253285);
        p.h(mMActivity, "context");
        intent.setClass(mMActivity, FinderFavFeedUI.class);
        mMActivity.startActivityForResult(intent, i2);
        AppMethodBeat.o(253285);
    }

    public static void b(Activity activity, Intent intent) {
        AppMethodBeat.i(253286);
        p.h(activity, "context");
        intent.setClass(activity, FinderFavTimelineUI.class);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(activity, intent, 0, 0, false, 124);
        activity.startActivityForResult(intent, 10001);
        AppMethodBeat.o(253286);
    }

    public static void Q(Context context, Intent intent) {
        AppMethodBeat.i(253287);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderLbsStreamListUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253287);
    }

    public static void c(Activity activity, Intent intent) {
        AppMethodBeat.i(253288);
        p.h(activity, "context");
        intent.setClass(activity, FinderLbsStreamListUI.class);
        activity.startActivityForResult(intent, 501);
        AppMethodBeat.o(253288);
    }

    public static void R(Context context, Intent intent) {
        AppMethodBeat.i(253289);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderRelatedFeedUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253289);
    }

    public static void S(Context context, Intent intent) {
        AppMethodBeat.i(253290);
        p.h(context, "context");
        intent.setClass(context, FinderRelatedTimelineUI.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 501);
            AppMethodBeat.o(253290);
            return;
        }
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253290);
    }

    public static void T(Context context, Intent intent) {
        AppMethodBeat.i(253291);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderFriendLikeTimelineUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253291);
    }

    public static void U(Context context, Intent intent) {
        AppMethodBeat.i(253292);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderLikedFeedUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253292);
    }

    public static void V(Context context, Intent intent) {
        AppMethodBeat.i(253294);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderFriendFoldedTimelineUI.class);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253294);
    }

    public static void W(Context context, Intent intent) {
        AppMethodBeat.i(253295);
        p.h(context, "context");
        intent.setClass(context, FinderFeedRelatedTimelineUI.class);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253295);
    }

    public static void enterAlbumRelatedTimelineUI(Context context, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(253296);
        p.h(context, "context");
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(context);
            Log.w("Finder.ActivityRouter", "青少年模式只看关注时，禁止进入专辑.");
            AppMethodBeat.o(253296);
            return;
        }
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        Intent intent3 = !(context instanceof Activity) ? intent2 : null;
        if (intent3 != null) {
            intent3.addFlags(268435456);
        }
        intent2.setClass(context, FinderAlbumTimelineUI.class);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent2, 0, 0, false, 124);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAlbumRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253296);
    }

    public static void X(Context context, Intent intent) {
        AppMethodBeat.i(253297);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderFeedRelTimelineUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253297);
    }

    public static /* synthetic */ void a(Activity activity, ViewAnimHelper.ViewInfo viewInfo, cjk cjk, int i2) {
        AppMethodBeat.i(253299);
        a(activity, viewInfo, cjk, i2, false);
        AppMethodBeat.o(253299);
    }

    public static void a(Activity activity, ViewAnimHelper.ViewInfo viewInfo, cjk cjk, int i2, boolean z) {
        AppMethodBeat.i(253298);
        p.h(activity, "context");
        p.h(viewInfo, "viewInfo");
        p.h(cjk, "localContent");
        Intent intent = new Intent();
        intent.setClass(activity, FinderSelectCoverUI.class);
        intent.putExtra("media_list_", cjk.toByteArray());
        intent.putExtra("crop_info", viewInfo);
        intent.putExtra("media_list_count", cjk.mediaList.size());
        intent.putExtra("isLongVideoPost", z);
        activity.startActivityForResult(intent, i2);
        AppMethodBeat.o(253298);
    }

    public static void Y(Context context, Intent intent) {
        AppMethodBeat.i(253300);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderFinderMsgUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNotifyMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253300);
    }

    public static void fy(Context context) {
        AppMethodBeat.i(253301);
        p.h(context, "context");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.addFlags(67108864);
        intent.setClass(context, FinderFinderSysMsgUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253301);
    }

    public static void fz(Context context) {
        AppMethodBeat.i(253302);
        p.h(context, "context");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderFansListUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253302);
    }

    public static void b(MMActivity mMActivity, Intent intent) {
        AppMethodBeat.i(253303);
        p.h(mMActivity, "context");
        Intent intent2 = !(mMActivity instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(mMActivity, FinderTimelineLbsUI.class);
        mMActivity.startActivityForResult(intent, 19999);
        AppMethodBeat.o(253303);
    }

    public static void enterFinderLbsLiveFriendsUI(Context context, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(253304);
        p.h(context, "context");
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        Intent intent3 = !(context instanceof Activity) ? intent2 : null;
        if (intent3 != null) {
            intent3.addFlags(268435456);
        }
        intent2.setClass(context, OccupyFinderUI11.class);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent2, 0, 0, false, 124);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253304);
    }

    public static void Z(Context context, Intent intent) {
        AppMethodBeat.i(253305);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, OccupyFinderUI12.class);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253305);
    }

    public static void a(MMFragmentActivity mMFragmentActivity, Intent intent) {
        AppMethodBeat.i(253306);
        p.h(mMFragmentActivity, "context");
        intent.setClass(mMFragmentActivity, FinderCommentUI.class);
        mMFragmentActivity.startActivityForResult(intent, 500);
        mMFragmentActivity.overridePendingTransition(0, 0);
        AppMethodBeat.o(253306);
    }

    public static void c(MMActivity mMActivity, Intent intent, int i2) {
        AppMethodBeat.i(253307);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        intent.setClass(mMActivity, FinderPostAtUI.class);
        mMActivity.startActivityForResult(intent, i2);
        AppMethodBeat.o(253307);
    }

    public static void c(MMActivity mMActivity, Intent intent) {
        AppMethodBeat.i(253308);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        intent.setClass(mMActivity, FinderActivityPostUI.class);
        mMActivity.startActivityForResult(intent, 20002);
        AppMethodBeat.o(253308);
    }

    public static void d(MMActivity mMActivity, Intent intent) {
        AppMethodBeat.i(253309);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        intent.setClass(mMActivity, FinderActivityDescUI.class);
        mMActivity.startActivityForResult(intent, 20002);
        AppMethodBeat.o(253309);
    }

    public static void aa(Context context, Intent intent) {
        Intent intent2;
        Intent intent3 = null;
        AppMethodBeat.i(253310);
        p.h(context, "context");
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        if ((intent2 != null ? Boolean.valueOf(intent2.getBooleanExtra("key_finder_teen_mode_check", false)) : null).booleanValue()) {
            ai.a aVar = ai.vFj;
            ai.a.b(context, intent2, new f(intent2, context));
            AppMethodBeat.o(253310);
            return;
        }
        if (!(context instanceof Activity)) {
            intent3 = intent2;
        }
        if (intent3 != null) {
            intent3.addFlags(268435456);
        }
        intent2.setClass(context, FinderActivityProfileUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterActivityProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253310);
    }

    public static final class f implements ad.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;

        f(Intent intent, Context context) {
            this.$intent = intent;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.i.a.ad.a
        public final void mM(boolean z) {
            AppMethodBeat.i(261423);
            if (z) {
                Intent intent = this.$intent;
                if (intent == null) {
                    p.hyc();
                }
                intent.putExtra("key_finder_teen_mode_check", false);
                a aVar = a.vUU;
                a.aa(this.$context, this.$intent);
            }
            AppMethodBeat.o(261423);
        }
    }

    public static void ab(Context context, Intent intent) {
        AppMethodBeat.i(253312);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderAtTimelineUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        k kVar = k.vfA;
        bp bpVar = new bp();
        bpVar.ep(cl.aWz());
        bpVar.jN(z.aUg());
        bpVar.jO(((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD());
        bpVar.bfK();
        k.a(bpVar);
        AppMethodBeat.o(253312);
    }

    public static void ac(Context context, Intent intent) {
        AppMethodBeat.i(253313);
        p.h(context, "context");
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, OccupyFinderUI10.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253313);
    }

    public static /* synthetic */ void fA(Context context) {
        AppMethodBeat.i(253314);
        p.h(context, "context");
        Intent intent = new Intent();
        intent.putExtra("KEY_TALKER_TYPE", 1);
        intent.putExtra("KEY_TALKER_SCENE", 2);
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        intent.setClass(context, FinderConversationUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderConversationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderConversationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253314);
    }

    public static /* synthetic */ void fB(Context context) {
        AppMethodBeat.i(253315);
        p.h(context, "context");
        Intent intent = new Intent();
        intent.putExtra("KEY_TALKER_TYPE", 1);
        intent.putExtra("KEY_TALKER_SCENE", 1);
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        intent.setClass(context, FinderConversationTempUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxConversationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxConversationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253315);
    }

    public static /* synthetic */ void fC(Context context) {
        AppMethodBeat.i(253316);
        p.h(context, "context");
        Intent intent = new Intent();
        intent.putExtra("KEY_TALKER_TYPE", 2);
        intent.putExtra("KEY_TALKER_SCENE", 2);
        intent.addFlags(67108864);
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        intent.setClass(context, FinderConversationXXUI.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 1);
            AppMethodBeat.o(253316);
            return;
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHelloConversationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderHelloConversationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253316);
    }

    public static void aD(Context context, String str) {
        AppMethodBeat.i(253317);
        p.h(context, "context");
        p.h(str, ch.COL_USERNAME);
        Log.i("Finder.ActivityRouter", "[startChattingUI] username=" + str + " scene=2");
        ((aa) com.tencent.mm.kernel.g.af(aa.class)).a(context, 2, str, new d(str, context));
        AppMethodBeat.o(253317);
    }

    /* access modifiers changed from: package-private */
    public static final class d implements aa.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ int $scene = 2;
        final /* synthetic */ String hLl;

        d(String str, Context context) {
            this.hLl = str;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.i.a.aa.a
        public final void j(final String str, final int i2, final int i3, final String str2) {
            AppMethodBeat.i(253260);
            Log.i("Finder.ActivityRouter", "[enterChattingUI] ]username=" + this.hLl + " sessionId=" + str);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.utils.a.d.AnonymousClass1 */
                final /* synthetic */ d vUY;

                {
                    this.vUY = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    boolean z;
                    AppMethodBeat.i(253259);
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vUY.$context);
                    bbn dIx = fH != null ? fH.dIx() : null;
                    y yVar = y.vXH;
                    if (!y.d(this.vUY.$context, i2, i3, str2)) {
                        String str = str;
                        p.g(str, "sessionId");
                        if (str.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            Intent intent = new Intent();
                            intent.putExtra("Chat_Self", z.aTY());
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("finish_direct", true);
                            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                            FinderReporterUIC.a.a(this.vUY.$context, intent, 0, 0, false, 124);
                            com.tencent.mm.br.c.f(this.vUY.$context, ".ui.chatting.ChattingUI", intent);
                            if (this.vUY.$scene == 2) {
                                com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
                                com.tencent.mm.plugin.finder.report.d.dnK().a(dIx, 3, 1);
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(253259);
                            return xVar;
                        }
                    }
                    if (this.vUY.$scene == 2) {
                        com.tencent.mm.plugin.finder.report.d dVar2 = com.tencent.mm.plugin.finder.report.d.vdp;
                        com.tencent.mm.plugin.finder.report.d.dnK().a(dIx, 3, 2);
                    }
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(253259);
                    return xVar2;
                }
            });
            AppMethodBeat.o(253260);
        }
    }

    public static void z(Context context, String str, String str2) {
        AppMethodBeat.i(261429);
        p.h(context, "context");
        p.h(str, "fromUsername");
        p.h(str2, "toUsername");
        Log.i("Finder.ActivityRouter", "[enterChattingUIFromLive] fromUsername=" + str + " toUsername=" + str2 + " scene=1");
        ((aa) com.tencent.mm.kernel.g.af(aa.class)).a(context, 1, str2, new g(str2, context, str));
        AppMethodBeat.o(261429);
    }

    /* access modifiers changed from: package-private */
    public static final class g implements aa.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ String UUY;
        final /* synthetic */ String UUZ;

        g(String str, Context context, String str2) {
            this.UUY = str;
            this.$context = context;
            this.UUZ = str2;
        }

        @Override // com.tencent.mm.plugin.i.a.aa.a
        public final void j(final String str, final int i2, final int i3, final String str2) {
            AppMethodBeat.i(261425);
            Log.i("Finder.ActivityRouter", "[enterChattingUIFromLive] toUsername=" + this.UUY + " sessionId=" + str);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.utils.a.g.AnonymousClass1 */
                final /* synthetic */ g UVa;

                {
                    this.UVa = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(261424);
                    y yVar = y.vXH;
                    if (!y.d(this.UVa.$context, i2, i3, str2)) {
                        String str = str;
                        p.g(str, "sessionId");
                        if (str.length() > 0) {
                            Intent intent = new Intent();
                            intent.putExtra("Chat_Self", this.UVa.UUZ);
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("finish_direct", true);
                            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                            FinderReporterUIC.a.a(this.UVa.$context, intent, 0, 0, false, 124);
                            com.tencent.mm.br.c.f(this.UVa.$context, ".ui.chatting.ChattingUI", intent);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(261424);
                    return xVar;
                }
            });
            AppMethodBeat.o(261425);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements aa.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ bbn $contextObj;

        b(Context context, bbn bbn) {
            this.$context = context;
            this.$contextObj = bbn;
        }

        @Override // com.tencent.mm.plugin.i.a.aa.a
        public final void j(final String str, final int i2, final int i3, final String str2) {
            AppMethodBeat.i(253256);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.utils.a.b.AnonymousClass1 */
                final /* synthetic */ b vUW;

                {
                    this.vUW = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(253255);
                    y yVar = y.vXH;
                    if (!y.d(this.vUW.$context, i2, i3, str2)) {
                        String str = str;
                        p.g(str, "sessionId");
                        if (str.length() > 0) {
                            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
                            com.tencent.mm.plugin.finder.report.d.dnK().a(this.vUW.$contextObj, 2, 1);
                            Intent intent = new Intent();
                            intent.putExtra("Chat_Self", z.aUg());
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("finish_direct", true);
                            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                            FinderReporterUIC.a.a(this.vUW.$context, intent, 0, 0, false, 124);
                            com.tencent.mm.br.c.f(this.vUW.$context, ".ui.chatting.ChattingUI", intent);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(253255);
                    return xVar;
                }
            });
            AppMethodBeat.o(253256);
        }
    }

    public static void a(Context context, String str, String str2, bbn bbn) {
        AppMethodBeat.i(253318);
        p.h(context, "context");
        p.h(str, "sessionId");
        p.h(str2, "fansId");
        ((aa) com.tencent.mm.kernel.g.af(aa.class)).a(context, str, str2, new b(context, bbn));
        AppMethodBeat.o(253318);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.finder.utils.a$a */
    public static final class C1312a implements aa.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ bbn $contextObj;

        C1312a(Context context, bbn bbn) {
            this.$context = context;
            this.$contextObj = bbn;
        }

        @Override // com.tencent.mm.plugin.i.a.aa.a
        public final void j(final String str, final int i2, final int i3, final String str2) {
            AppMethodBeat.i(253254);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.utils.a.C1312a.AnonymousClass1 */
                final /* synthetic */ C1312a vUV;

                {
                    this.vUV = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(253253);
                    y yVar = y.vXH;
                    if (!y.d(this.vUV.$context, i2, i3, str2)) {
                        String str = str;
                        p.g(str, "sessionId");
                        if (str.length() > 0) {
                            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
                            com.tencent.mm.plugin.finder.report.d.dnK().a(this.vUV.$contextObj, 1, 1);
                            Intent intent = new Intent();
                            intent.putExtra("Chat_Self", z.aUg());
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("finish_direct", true);
                            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                            FinderReporterUIC.a.a(this.vUV.$context, intent, 0, 0, false, 124);
                            com.tencent.mm.br.c.f(this.vUV.$context, ".ui.chatting.ChattingUI", intent);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(253253);
                    return xVar;
                }
            });
            AppMethodBeat.o(253254);
        }
    }

    public static void a(Context context, String str, String str2, long j2, long j3, bbn bbn) {
        AppMethodBeat.i(253319);
        p.h(context, "context");
        p.h(str, "sessionId");
        p.h(str2, ch.COL_USERNAME);
        ((aa) com.tencent.mm.kernel.g.af(aa.class)).a(context, str, str2, Long.valueOf(j2), Long.valueOf(j3), new C1312a(context, bbn));
        AppMethodBeat.o(253319);
    }

    public static /* synthetic */ void a(Context context, String str, bbn bbn) {
        AppMethodBeat.i(253321);
        a(context, 2, str, "", 0, bbn);
        AppMethodBeat.o(253321);
    }

    public static final class c implements aa.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ bbn $contextObj;
        final /* synthetic */ int $scene;

        c(Context context, bbn bbn, int i2) {
            this.$context = context;
            this.$contextObj = bbn;
            this.$scene = i2;
        }

        @Override // com.tencent.mm.plugin.i.a.aa.a
        public final void j(final String str, final int i2, final int i3, final String str2) {
            AppMethodBeat.i(253258);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.utils.a.c.AnonymousClass1 */
                final /* synthetic */ c vUX;

                {
                    this.vUX = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    String aUg;
                    AppMethodBeat.i(253257);
                    y yVar = y.vXH;
                    if (!y.d(this.vUX.$context, i2, i3, str2)) {
                        String str = str;
                        p.g(str, "sessionId");
                        if (str.length() > 0) {
                            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
                            com.tencent.mm.plugin.finder.report.d.dnK().a(this.vUX.$contextObj, 4, 1);
                            Intent intent = new Intent();
                            if (this.vUX.$scene == 2) {
                                aUg = z.aTY();
                            } else {
                                aUg = z.aUg();
                            }
                            intent.putExtra("Chat_Self", aUg);
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("finish_direct", true);
                            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                            FinderReporterUIC.a.a(this.vUX.$context, intent, 0, 0, false, 124);
                            com.tencent.mm.br.c.f(this.vUX.$context, ".ui.chatting.ChattingUI", intent);
                            x xVar = x.SXb;
                            AppMethodBeat.o(253257);
                            return xVar;
                        }
                    }
                    com.tencent.mm.plugin.finder.report.d dVar2 = com.tencent.mm.plugin.finder.report.d.vdp;
                    com.tencent.mm.plugin.finder.report.d.dnK().a(this.vUX.$contextObj, 4, 2);
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(253257);
                    return xVar2;
                }
            });
            AppMethodBeat.o(253258);
        }
    }

    public static void a(Context context, int i2, String str, String str2, long j2, bbn bbn) {
        AppMethodBeat.i(253320);
        p.h(context, "context");
        p.h(str2, "lotteryId");
        ((aa) com.tencent.mm.kernel.g.af(aa.class)).a(context, i2, str, str2, Long.valueOf(j2), new c(context, bbn, i2));
        AppMethodBeat.o(253320);
    }

    public static /* synthetic */ void a(a aVar, Context context, long j2, long j3, String str, String str2, String str3, String str4, int i2, String str5) {
        AppMethodBeat.i(261431);
        a(context, j2, j3, str, str2, str3, str4, i2, str5, "");
        AppMethodBeat.o(261431);
    }

    public static void a(Context context, long j2, long j3, String str, String str2, String str3, String str4, int i2, String str5, String str6) {
        AppMethodBeat.i(261430);
        p.h(context, "context");
        p.h(str, "anchorUserName");
        p.h(str2, "nonceId");
        p.h(str3, "desc");
        p.h(str4, "contextId");
        LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvU).zt(j3).Gd(str2).zu(j2).Gg(str).Gh(str3).Gl(str5).bxf(str6).aBR();
        p.g(aBR, "builder.toWhere(LiveConf…tId)\n            .build()");
        FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
        finderLiveConfig.uiu.add(aBR);
        finderLiveConfig.extFlag = i2;
        a(context, finderLiveConfig, str4, (String) null, (Intent) null, 24);
        AppMethodBeat.o(261430);
    }

    public static /* synthetic */ void a(Context context, FinderLiveConfig finderLiveConfig, String str, String str2, Intent intent, int i2) {
        AppMethodBeat.i(253324);
        if ((i2 & 4) != 0) {
            str = "";
        }
        if ((i2 & 8) != 0) {
            str2 = "";
        }
        if ((i2 & 16) != 0) {
            intent = null;
        }
        b(context, finderLiveConfig, str, str2, intent);
        AppMethodBeat.o(253324);
    }

    private static void b(Context context, FinderLiveConfig finderLiveConfig, String str, String str2, Intent intent) {
        long j2;
        com.tencent.mm.plugin.finder.live.model.h M;
        com.tencent.mm.plugin.finder.live.model.h K;
        com.tencent.mm.plugin.finder.live.model.h b2;
        com.tencent.mm.plugin.finder.live.model.h a2;
        AppMethodBeat.i(253323);
        p.h(context, "context");
        p.h(finderLiveConfig, "config");
        p.h(str, "contextId");
        p.h(str2, "clickTabContextId");
        Log.i("Finder.ActivityRouter", "[enterFinderLiveVisitorUI] ".concat(String.valueOf(finderLiveConfig)));
        aj ajVar = (aj) com.tencent.mm.kernel.g.ah(aj.class);
        LiveConfig dfu = finderLiveConfig.dfu();
        if (dfu != null) {
            j2 = Long.valueOf(dfu.getLiveId());
        } else {
            j2 = 0L;
        }
        ajVar.cleatLiveStatusCache(j2);
        if ((finderLiveConfig.extFlag & 4) > 0) {
            ((com.tencent.mm.plugin.festival.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class)).ba(context, finderLiveConfig.tCE + 100);
            AppMethodBeat.o(253323);
            return;
        }
        com.tencent.mm.plugin.finder.live.model.h hVar = com.tencent.mm.plugin.finder.live.model.h.uiL;
        p.h(context, "context");
        p.h(finderLiveConfig, "config");
        p.h(str, "contextId");
        p.h(str2, "clickTabContextId");
        ((com.tencent.mm.plugin.festival.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class)).dqm();
        z.f fVar = new z.f();
        T t = (T) context.getResources().getString(R.string.w0);
        p.g(t, "context.resources.getString(R.string.app_i_know)");
        fVar.SYG = t;
        com.tencent.mm.plugin.finder.live.model.h J = hVar.J(new h.g(context, fVar));
        if (J == null || (M = J.M(new h.C1185h(context))) == null || (K = M.K(new h.i(context))) == null || (b2 = K.b(false, new h.j(finderLiveConfig, context, str))) == null || (a2 = b2.a(context, new h.k(context))) == null || a2.L(new h.l(context)) == null) {
            AppMethodBeat.o(253323);
            return;
        }
        com.tencent.mm.plugin.finder.live.model.h.a(context, finderLiveConfig, str, str2, intent);
        AppMethodBeat.o(253323);
    }

    public static /* synthetic */ void a(Context context, boolean z, aqb aqb) {
        AppMethodBeat.i(261433);
        a(context, z, aqb, (Intent) null);
        AppMethodBeat.o(261433);
    }

    public static void a(Context context, boolean z, aqb aqb, Intent intent) {
        awe awe;
        Integer num;
        int i2;
        int i3;
        FinderObject finderObject;
        awe awe2;
        AppMethodBeat.i(261432);
        p.h(context, "context");
        if (aqb == null || (finderObject = aqb.LBU) == null || (awe2 = finderObject.liveInfo) == null) {
            awe = new awe();
        } else {
            awe = awe2;
        }
        p.g(awe, "prepareResp?.recover_liv…iveInfo?:FinderLiveInfo()");
        awt awt = aqb != null ? aqb.live_notice_info : null;
        LinkedList<axk> linkedList = aqb != null ? aqb.LBV : null;
        axk axk = aqb != null ? aqb.LBW : null;
        LinkedList<avh> linkedList2 = aqb != null ? aqb.LBX : null;
        Integer valueOf = aqb != null ? Integer.valueOf(aqb.Vis) : null;
        Integer valueOf2 = aqb != null ? Integer.valueOf(aqb.Viv) : null;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.hUO().value().intValue() > 0) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            num = com.tencent.mm.plugin.finder.storage.c.hUO().value();
            Log.i("Finder.ActivityRouter", "debug enterFinderLivePrepareUI maxUserCount ".concat(String.valueOf(num)));
        } else {
            num = valueOf2;
        }
        fgv fgv = new fgv();
        fgv.Vit = aqb != null ? aqb.Vit : 0;
        fgv.Viu = aqb != null ? aqb.Viu : 0;
        LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvT).zt(awe.liveId).Gg(com.tencent.mm.model.z.aUg()).aBR();
        p.g(aBR, "builder.toWhere(LiveConf…e())\n            .build()");
        Log.i("Finder.ActivityRouter", "enterFinderLiveAnchorUI " + aBR.info());
        FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
        finderLiveConfig.uiu.add(aBR);
        finderLiveConfig.uit = z;
        finderLiveConfig.uiv = awt;
        finderLiveConfig.sourceType = awe.LEg;
        finderLiveConfig.uiw = linkedList;
        finderLiveConfig.uix = axk;
        finderLiveConfig.ueu = linkedList2;
        if (valueOf != null) {
            i2 = valueOf.intValue();
        } else {
            i2 = 0;
        }
        finderLiveConfig.UKm = i2;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        finderLiveConfig.UKn = i3;
        finderLiveConfig.UKo = fgv.toByteArray();
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).cleatLiveStatusCache(Long.valueOf(awe.liveId));
        b(context, finderLiveConfig, "", intent);
        AppMethodBeat.o(261432);
    }

    public static /* synthetic */ void a(Context context, long j2, String str, awe awe, boolean z, awt awt, String str2, LinkedList linkedList, axk axk, String str3, String str4, LinkedList linkedList2, Intent intent, int i2) {
        AppMethodBeat.i(261434);
        if ((i2 & 8) != 0) {
            awe = new awe();
        }
        if ((i2 & 32) != 0) {
            m mVar = m.vVH;
            z = m.dBN();
        }
        if ((i2 & 64) != 0) {
            awt = null;
        }
        if ((i2 & 128) != 0) {
            str2 = null;
        }
        if ((i2 & 256) != 0) {
            linkedList = null;
        }
        if ((i2 & 512) != 0) {
            axk = null;
        }
        if ((i2 & 1024) != 0) {
            str3 = "";
        }
        if ((i2 & 2048) != 0) {
            str4 = null;
        }
        if ((i2 & 4096) != 0) {
            linkedList2 = null;
        }
        if ((i2 & 8192) != 0) {
            intent = null;
        }
        p.h(context, "context");
        p.h(str, "nonceId");
        p.h(awe, "liveInfo");
        p.h(str3, "contextId");
        LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvT).zt(awe.liveId).zu(j2).Gd(str).Gg(com.tencent.mm.model.z.aUg()).Gi("").aBP().aBQ().Gj("").Gk("").Gh(str2).Gl(str4).aBR();
        p.g(aBR, "builder.toWhere(LiveConf…fer)\n            .build()");
        Log.i("Finder.ActivityRouter", "enterFinderLiveAnchorUI " + aBR.info());
        FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
        finderLiveConfig.uiu.add(aBR);
        finderLiveConfig.uit = z;
        finderLiveConfig.uiv = awt;
        finderLiveConfig.sourceType = awe.LEg;
        finderLiveConfig.uiw = linkedList;
        finderLiveConfig.uix = axk;
        finderLiveConfig.ueu = linkedList2;
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).cleatLiveStatusCache(Long.valueOf(awe.liveId));
        b(context, finderLiveConfig, str3, intent);
        AppMethodBeat.o(261434);
    }

    public static /* synthetic */ void b(Context context, FinderLiveConfig finderLiveConfig, String str) {
        AppMethodBeat.i(261436);
        b(context, finderLiveConfig, str, null);
        AppMethodBeat.o(261436);
    }

    private static void b(Context context, FinderLiveConfig finderLiveConfig, String str, Intent intent) {
        AppMethodBeat.i(261435);
        p.h(context, "context");
        p.h(finderLiveConfig, "config");
        p.h(str, "contextId");
        Log.i("Finder.ActivityRouter", "[enterFinderLiveAnchorUI] ".concat(String.valueOf(finderLiveConfig)));
        com.tencent.mm.plugin.finder.live.model.h.a(com.tencent.mm.plugin.finder.live.model.h.uiL, context, finderLiveConfig, str, intent);
        AppMethodBeat.o(261435);
    }

    public static void a(Context context, String str, String str2, String str3, long j2, long j3) {
        AppMethodBeat.i(253328);
        p.h(context, "context");
        Intent intent = new Intent();
        intent.addFlags(268435456);
        if (str == null) {
            str = "";
        }
        intent.putExtra("key_anchor_finder_username", str);
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra("key_anchor_finder_nickname", str2);
        if (str3 == null) {
            str3 = "";
        }
        intent.putExtra("key_anchor_finder_avatar", str3);
        intent.putExtra("key_anchor_finder_object_id", j2);
        intent.putExtra("key_anchor_finder_live_id", j3);
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).cleatLiveStatusCache(Long.valueOf(j3));
        intent.setClass(context, FinderLiveInvitedUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveInvitedUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253328);
    }

    public static void ad(Context context, Intent intent) {
        AppMethodBeat.i(253329);
        p.h(context, "context");
        intent.setClass(context, FinderSnsGridFeedUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSnsGridFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253329);
    }

    public static void ae(Context context, Intent intent) {
        AppMethodBeat.i(253330);
        p.h(context, "context");
        Log.i("Finder.ActivityRouter", "enterFinderLiveFansListUI");
        intent.setClass(context, FinderLiveFansListUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253330);
    }

    public static void af(Context context, Intent intent) {
        AppMethodBeat.i(253331);
        p.h(context, "context");
        Log.i("Finder.ActivityRouter", "enterFinderLiveWeCoinHotUI");
        intent.setClass(context, OccupyFinderUI9.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLiveWeCoinHotUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253331);
    }

    public static /* synthetic */ void ag(Context context, Intent intent) {
        AppMethodBeat.i(253333);
        d(context, intent, false);
        AppMethodBeat.o(253333);
    }

    public static void d(Context context, Intent intent, boolean z) {
        AppMethodBeat.i(253332);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        if (z) {
            intent.setClass(context, FinderLongVideoDetailUI.class);
        } else {
            intent.setClass(context, FinderLongVideoTimelineUI.class);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 101);
            AppMethodBeat.o(253332);
            return;
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterMegaVideoTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253332);
    }

    public static /* synthetic */ void fD(Context context) {
        AppMethodBeat.i(253334);
        p.h(context, "context");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderManagementUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderManagementUi", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderManagementUi", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253334);
    }

    public static /* synthetic */ void ae(Context context, int i2) {
        AppMethodBeat.i(253336);
        ad(context, i2);
        AppMethodBeat.o(253336);
    }

    private static void ad(Context context, int i2) {
        AppMethodBeat.i(253335);
        p.h(context, "context");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderBlockListUI.class);
        intent.putExtra("BLOCK_LIST_TYPE", i2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListUi", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253335);
    }

    public static void aE(Context context, String str) {
        AppMethodBeat.i(253337);
        p.h(context, "context");
        p.h(str, "type");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        intent.setClass(context, FinderBlockListSearchUI.class);
        FinderBlockListSearchUI.a aVar = FinderBlockListSearchUI.vHv;
        intent.putExtra(FinderBlockListSearchUI.vHu, str);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderBlockListSearchUI", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253337);
    }

    public static void fE(Context context) {
        AppMethodBeat.i(253338);
        p.h(context, "context");
        ae aeVar = ae.SYK;
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_ACCOUNT_DETAIL_URL_STRING_SYNC, "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(253338);
            throw tVar;
        }
        String format = String.format(sb.append((String) obj).append("?wechat_real_lang=%s&username=%s").toString(), Arrays.copyOf(new Object[]{LocaleUtil.getApplicationLanguage(), com.tencent.mm.model.z.aUg()}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        y yVar = y.vXH;
        if (y.dCM()) {
            u.makeText(context, "url:".concat(String.valueOf(format)), 1).show();
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", format);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        k kVar = k.vfA;
        k.b(context, 9, 1);
        AppMethodBeat.o(253338);
    }

    public static void ah(Context context, Intent intent) {
        AppMethodBeat.i(253339);
        p.h(context, "context");
        intent.setClass(context, OccupyFinderUI16.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAccountManagementUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253339);
    }

    public static void d(Activity activity, Intent intent) {
        AppMethodBeat.i(253340);
        p.h(activity, "context");
        intent.setClass(activity, FinderLiveMsgUI.class);
        activity.startActivityForResult(intent, 1002);
        AppMethodBeat.o(253340);
    }

    public static void e(Activity activity, Intent intent) {
        AppMethodBeat.i(253341);
        p.h(activity, "context");
        intent.setClass(activity, OccupyFinderUI14.class);
        activity.startActivityForResult(intent, 1001);
        AppMethodBeat.o(253341);
    }

    public static void ai(Context context, Intent intent) {
        AppMethodBeat.i(253342);
        p.h(context, "context");
        p.h(intent, "intent");
        i iVar = i.vvu;
        i.a(null);
        intent.setClass(context, FinderCreateGuideUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253342);
    }

    public static /* synthetic */ void f(Activity activity, Intent intent) {
        AppMethodBeat.i(253344);
        a(activity, intent, false);
        AppMethodBeat.o(253344);
    }

    public static void a(Activity activity, Intent intent, boolean z) {
        AppMethodBeat.i(253343);
        p.h(activity, "context");
        if (intent == null) {
            intent = new Intent();
        }
        if (z) {
            intent.putExtra("KEY_IS_FROM_SETTING", true);
        }
        intent.setClass(activity, OccupyFinderUI1.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/app/Activity;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryUI", "(Landroid/app/Activity;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253343);
    }

    public static void g(Activity activity, Intent intent) {
        AppMethodBeat.i(253345);
        p.h(activity, "context");
        intent.setClass(activity, OccupyFinderUI2.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryHistoryDetailUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253345);
    }

    public static void h(Activity activity, Intent intent) {
        AppMethodBeat.i(253346);
        p.h(activity, "context");
        intent.setClass(activity, OccupyFinderUI3.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLotteryWinnerListUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253346);
    }

    public static void aj(Context context, Intent intent) {
        AppMethodBeat.i(253347);
        p.h(context, "context");
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, FinderPoiFeedUI.class);
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterPoiFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(253347);
    }

    public static void b(Activity activity, Intent intent, boolean z) {
        AppMethodBeat.i(261437);
        p.h(activity, "context");
        intent.putExtra("KEY_IS_FROM_SETTING", z);
        intent.setClass(activity, OccupyFinderUI8.class);
        activity.startActivityForResult(intent, 1009);
        AppMethodBeat.o(261437);
    }

    public static void k(Activity activity, Intent intent) {
        AppMethodBeat.i(261438);
        p.h(activity, "context");
        intent.setClass(activity, OccupyFinderUI15.class);
        activity.startActivityForResult(intent, 1);
        AppMethodBeat.o(261438);
    }

    public static void fx(Context context) {
        AppMethodBeat.i(253293);
        p.h(context, "context");
        ad(context, 1);
        AppMethodBeat.o(253293);
    }
}
