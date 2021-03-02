package com.tencent.mm.plugin.textstatus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.f.k;
import com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.plugin.textstatus.ui.e;
import com.tencent.mm.plugin.textstatus.ui.g;
import com.tencent.mm.plugin.textstatus.ui.j;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.y;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001dB\u0005¢\u0006\u0002\u0010\u0007J.\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u001c\u0010'\u001a\u00020(2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010.\u001a\u00020/2\u0006\u0010#\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0016J(\u00104\u001a\u00020/2\u0006\u0010#\u001a\u00020$2\u0006\u00100\u001a\u0002012\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u0019H\u0016J\b\u00107\u001a\u00020,H\u0016J\u0010\u00108\u001a\u0002092\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010#\u001a\u00020$2\u0006\u0010:\u001a\u00020;H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020\rH\u0016J$\u0010<\u001a\u0004\u0018\u00010=2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010A\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010B\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020\u0014H\u0016J*\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00192\b\u0010L\u001a\u0004\u0018\u00010\r2\u0006\u0010D\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\u0014H\u0016J\u001a\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010S\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020QH\u0016J\u0012\u0010T\u001a\u00020\u00142\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u001c\u0010T\u001a\u00020\u00142\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0018\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020[2\u0006\u0010-\u001a\u00020\rH\u0016J,\u0010\\\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010]\u001a\u00020^H\u0016J$\u0010\\\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010_2\b\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010`\u001a\u00020\u00142\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010a\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010-\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010b\u001a\u00020\u00142\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0012\u0010c\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/PluginTextStatus;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/textstatus/api/IPluginTextStatus;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "Lcom/tencent/mm/kernel/api/ICollectDBFactory;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "hasGetUserPermission", "", "attachTextStatusSpanSync", "", "userName", "", "displayName", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "", "clearTextStatus", "", "textView", "Landroid/widget/TextView;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execSQL", SharePluginInfo.ISSUE_KEY_SQL, "execute", "getBackPreview", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "context", "Landroid/content/Context;", "getDataManager", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusDataManager;", "getHistoryFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "getInfo", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusInfo;", ch.COL_USERNAME, "getMoreTabCardView", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "getProfileCardView", "headRoot", "extraPadding", "getSelfInfo", "getStatusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "getTextStatusSpanSync", "Landroid/text/style/ImageSpan;", "goLikeListFromSelfHistory", "goUnReadMsgPage", "contex", "hasStatus", "isHasStatusThumb", "isSpanSwitchOpen", "scene", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parallelsDependency", "report22208", NativeProtocol.WEB_DIALOG_ACTION, "", "actionResult", "report22210", "setSelfStatus", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "param", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setTextStatusDrawable", "imageView", "Landroid/widget/ImageView;", "setTextWithStatus", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "showCardDialog", "showStatusDetail", "showStatusPlanet", "updateStatus", "Companion", "plugin-textstatus_release"})
public final class PluginTextStatus extends f implements i, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, c, com.tencent.mm.plugin.textstatus.a.c {
    private static String FWZ = "";
    private static boolean FXa;
    public static final a FXb = new a((byte) 0);
    private boolean Vcy;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/PluginTextStatus$Companion;", "", "()V", "TAG", "", "sIsNeedUpdateTitle", "", "getSIsNeedUpdateTitle", "()Z", "setSIsNeedUpdateTitle", "(Z)V", "sTopicId", "getSTopicId", "()Ljava/lang/String;", "setSTopicId", "(Ljava/lang/String;)V", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216053);
        AppMethodBeat.o(216053);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final boolean hasStatus(String str) {
        com.tencent.mm.plugin.textstatus.f.f.a aTf;
        AppMethodBeat.i(216021);
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            aTf = null;
        } else {
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            aTf = com.tencent.mm.plugin.textstatus.b.f.aTf(str);
        }
        if (aTf != null) {
            AppMethodBeat.o(216021);
            return true;
        }
        AppMethodBeat.o(216021);
        return false;
    }

    public final o getSelfInfo() {
        AppMethodBeat.i(216022);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216022);
        throw nVar;
    }

    public final o getInfo(String str) {
        AppMethodBeat.i(216023);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216023);
        throw nVar;
    }

    public final void updateStatus(String str) {
        AppMethodBeat.i(216024);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216024);
        throw nVar;
    }

    public final void setSelfStatus(Activity activity) {
        AppMethodBeat.i(216025);
        setSelfStatus(activity, null);
        AppMethodBeat.o(216025);
    }

    public final void setSelfStatus(Activity activity, m mVar) {
        AppMethodBeat.i(216026);
        if (activity == null) {
            AppMethodBeat.o(216026);
            return;
        }
        TextStatusEditActivity.a aVar = TextStatusEditActivity.GeM;
        TextStatusEditActivity.a.b(activity, mVar);
        AppMethodBeat.o(216026);
    }

    public final void showStatusPlanet(Activity activity) {
        AppMethodBeat.i(216027);
        if (activity == null) {
            AppMethodBeat.o(216027);
            return;
        }
        new j(activity).show();
        AppMethodBeat.o(216027);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void showCardDialog(Activity activity, String str) {
        AppMethodBeat.i(216028);
        if (activity != null) {
            String str2 = str;
            if (!(str2 == null || n.aL(str2))) {
                com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                if (com.tencent.mm.plugin.textstatus.b.f.aTf(str) != null) {
                    new g(activity, str).show();
                    AppMethodBeat.o(216028);
                    return;
                }
            }
        }
        AppMethodBeat.o(216028);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void showStatusDetail(Context context, String str) {
        AppMethodBeat.i(216029);
        String str2 = str;
        if ((str2 == null || n.aL(str2)) || context == null) {
            AppMethodBeat.o(216029);
        } else {
            AppMethodBeat.o(216029);
        }
    }

    public final k getDataManager() {
        return com.tencent.mm.plugin.textstatus.b.f.FXJ;
    }

    public final com.tencent.mm.plugin.textstatus.a.f getStatusCardView(Context context) {
        AppMethodBeat.i(216030);
        p.h(context, "context");
        com.tencent.mm.plugin.textstatus.a.n nVar = com.tencent.mm.plugin.textstatus.a.n.FXs;
        p.g(nVar, "StatusShowParam.sDefaultShowParam");
        com.tencent.mm.plugin.textstatus.a.f statusCardView = getStatusCardView(context, nVar);
        AppMethodBeat.o(216030);
        return statusCardView;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final com.tencent.mm.plugin.textstatus.a.f getStatusCardView(Context context, com.tencent.mm.plugin.textstatus.a.n nVar) {
        AppMethodBeat.i(216031);
        p.h(context, "context");
        p.h(nVar, "showParam");
        com.tencent.mm.plugin.textstatus.ui.f fVar = new com.tencent.mm.plugin.textstatus.ui.f(context, nVar);
        AppMethodBeat.o(216031);
        return fVar;
    }

    public final com.tencent.mm.plugin.textstatus.a.f getStatusCardView(Context context, String str) {
        AppMethodBeat.i(216032);
        p.h(context, "context");
        p.h(str, ch.COL_USERNAME);
        com.tencent.mm.plugin.textstatus.ui.f fVar = new com.tencent.mm.plugin.textstatus.ui.f(context);
        fVar.DV(str);
        com.tencent.mm.plugin.textstatus.ui.f fVar2 = fVar;
        AppMethodBeat.o(216032);
        return fVar2;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final com.tencent.mm.plugin.textstatus.a.b getBackPreview(Context context) {
        AppMethodBeat.i(216033);
        p.h(context, "context");
        com.tencent.mm.plugin.textstatus.ui.a aVar = new com.tencent.mm.plugin.textstatus.ui.a(context);
        AppMethodBeat.o(216033);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final d getProfileCardView(Context context, RelativeLayout relativeLayout, LinearLayout linearLayout, int i2) {
        AppMethodBeat.i(216034);
        p.h(context, "context");
        p.h(relativeLayout, "rootLayout");
        p.h(linearLayout, "headRoot");
        e eVar = new e(context, relativeLayout, linearLayout, i2);
        AppMethodBeat.o(216034);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final d getMoreTabCardView(Context context, RelativeLayout relativeLayout, LinearLayout linearLayout) {
        AppMethodBeat.i(216035);
        p.h(context, "context");
        p.h(linearLayout, "headerRoot");
        com.tencent.mm.plugin.textstatus.ui.d dVar = new com.tencent.mm.plugin.textstatus.ui.d(context, relativeLayout, linearLayout);
        AppMethodBeat.o(216035);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void goUnReadMsgPage(Context context) {
        AppMethodBeat.i(216036);
        if (context == null) {
            AppMethodBeat.o(216036);
            return;
        }
        TextStatusLikeListActivity.b bVar = TextStatusLikeListActivity.Gfx;
        TextStatusLikeListActivity.b.hs(context);
        AppMethodBeat.o(216036);
    }

    public final void setTextStatusDrawable(ImageView imageView, String str) {
        AppMethodBeat.i(216037);
        p.h(imageView, "imageView");
        p.h(str, ch.COL_USERNAME);
        new k.b(str, imageView);
        AppMethodBeat.o(216037);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ff  */
    @Override // com.tencent.mm.plugin.textstatus.a.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void execSQL(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.PluginTextStatus.execSQL(java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void setTextWithStatus(TextView textView, String str, a.b bVar, a.c cVar) {
        AppMethodBeat.i(216039);
        p.h(bVar, "iconScene");
        p.h(cVar, "iconType");
        if (textView != null) {
            String str2 = str;
            if (!(str2 == null || n.aL(str2))) {
                if (isSpanSwitchOpen(bVar, str)) {
                    new k.c(str, textView, cVar, bVar);
                }
                AppMethodBeat.o(216039);
                return;
            }
        }
        AppMethodBeat.o(216039);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void setTextWithStatus(NoMeasuredTextView noMeasuredTextView, String str, a.b bVar) {
        AppMethodBeat.i(216040);
        p.h(bVar, "iconScene");
        if (noMeasuredTextView != null) {
            String str2 = str;
            if (!(str2 == null || n.aL(str2))) {
                if (isSpanSwitchOpen(bVar, str)) {
                    new k.d(str, noMeasuredTextView, bVar);
                }
                AppMethodBeat.o(216040);
                return;
            }
        }
        AppMethodBeat.o(216040);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void clearTextStatus(TextView textView, String str) {
        AppMethodBeat.i(216041);
        if (textView != null) {
            String str2 = str;
            if (!(str2 == null || n.aL(str2))) {
                com.tencent.mm.plugin.textstatus.f.k kVar = com.tencent.mm.plugin.textstatus.f.k.FZi;
                com.tencent.mm.plugin.textstatus.f.k.C(str, textView);
                AppMethodBeat.o(216041);
                return;
            }
        }
        AppMethodBeat.o(216041);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final boolean isHasStatusThumb(String str) {
        AppMethodBeat.i(216042);
        com.tencent.mm.plugin.textstatus.j.a aVar = com.tencent.mm.plugin.textstatus.j.a.GfU;
        if (str == null) {
            p.hyc();
        }
        if (s.YS(com.tencent.mm.plugin.textstatus.j.a.lf("thumb", str))) {
            AppMethodBeat.o(216042);
            return true;
        }
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.f.f.a aTf = com.tencent.mm.plugin.textstatus.b.f.aTf(str);
        if (aTf == null || TextUtils.isEmpty(aTf.field_MediaThumbUrl)) {
            AppMethodBeat.o(216042);
            return false;
        }
        AppMethodBeat.o(216042);
        return true;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final MMFragment getHistoryFragment(Context context, Bundle bundle) {
        AppMethodBeat.i(216043);
        Fragment instantiate = Fragment.instantiate(context, StatusAlbumUI.class.getName(), bundle);
        if (instantiate == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
            AppMethodBeat.o(216043);
            throw tVar;
        }
        MMFragment mMFragment = (MMFragment) instantiate;
        AppMethodBeat.o(216043);
        return mMFragment;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void goLikeListFromSelfHistory(Context context) {
        AppMethodBeat.i(216044);
        p.h(context, "context");
        TextStatusLikeListActivity.b bVar = TextStatusLikeListActivity.Gfx;
        p.h(context, "context");
        Intent intent = new Intent(context, TextStatusLikeListActivity.class);
        intent.putExtra("scene", 2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(216044);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void report22208(long j2, String str) {
        AppMethodBeat.i(258309);
        com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
        if (str == null) {
            str = "";
        }
        com.tencent.mm.plugin.textstatus.k.a.a(j2, str, (String) null, 4);
        AppMethodBeat.o(258309);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final void report22210(String str, long j2) {
        AppMethodBeat.i(258310);
        p.h(str, "userName");
        com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
        com.tencent.mm.plugin.textstatus.k.a.report22210(str, j2);
        AppMethodBeat.o(258310);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final ImageSpan getTextStatusSpanSync(String str, a.b bVar, float f2) {
        AppMethodBeat.i(216045);
        p.h(bVar, "iconScene");
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            AppMethodBeat.o(216045);
            return null;
        } else if (!isSpanSwitchOpen(bVar, str)) {
            AppMethodBeat.o(216045);
            return null;
        } else {
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            com.tencent.mm.plugin.textstatus.f.f.a aTf = com.tencent.mm.plugin.textstatus.b.f.aTf(str);
            if (aTf != null) {
                a.EnumC1808a aVar = a.EnumC1808a.DEFAULT;
                if (aTf.hXp() && (!p.j(aTf.field_IconID, "2021"))) {
                    aVar = a.EnumC1808a.GREY;
                }
                com.tencent.mm.plugin.textstatus.j.b bVar2 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
                Drawable a2 = com.tencent.mm.plugin.textstatus.j.b.a(aTf.field_IconID, a.c.OUTLINED, aVar);
                if (a2 != null) {
                    a2.setBounds(0, 0, (int) f2, (int) f2);
                    com.tencent.mm.plugin.textstatus.j.d dVar = new com.tencent.mm.plugin.textstatus.j.d(a2, aTf, bVar);
                    AppMethodBeat.o(216045);
                    return dVar;
                }
            }
            AppMethodBeat.o(216045);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.a.c
    public final CharSequence attachTextStatusSpanSync(String str, CharSequence charSequence, a.b bVar, float f2) {
        AppMethodBeat.i(216046);
        p.h(bVar, "iconScene");
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            if (!(charSequence == null || charSequence.length() == 0)) {
                if (!isSpanSwitchOpen(bVar, str)) {
                    AppMethodBeat.o(216046);
                    return charSequence;
                }
                ImageSpan textStatusSpanSync = getTextStatusSpanSync(str, bVar, f2);
                if (textStatusSpanSync != null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(textStatusSpanSync, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 34);
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    AppMethodBeat.o(216046);
                    return spannableStringBuilder2;
                }
                AppMethodBeat.o(216046);
                return charSequence;
            }
        }
        AppMethodBeat.o(216046);
        return charSequence;
    }

    private final boolean isSpanSwitchOpen(a.b bVar, String str) {
        AppMethodBeat.i(258311);
        switch (a.$EnumSwitchMapping$0[bVar.ordinal()]) {
            case 1:
                boolean fvC = com.tencent.mm.plugin.textstatus.a.p.fvC();
                AppMethodBeat.o(258311);
                return fvC;
            case 2:
                boolean fvH = com.tencent.mm.plugin.textstatus.a.p.fvH();
                AppMethodBeat.o(258311);
                return fvH;
            case 3:
                boolean fvI = com.tencent.mm.plugin.textstatus.a.p.fvI();
                AppMethodBeat.o(258311);
                return fvI;
            case 4:
                if (com.tencent.mm.plugin.textstatus.a.p.hXl()) {
                    com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                    com.tencent.mm.plugin.textstatus.f.f.a aTf = com.tencent.mm.plugin.textstatus.b.f.aTf(str);
                    boolean j2 = p.j(aTf != null ? aTf.field_IconID : null, "2021");
                    AppMethodBeat.o(258311);
                    return j2;
                }
                boolean fvJ = com.tencent.mm.plugin.textstatus.a.p.fvJ();
                AppMethodBeat.o(258311);
                return fvJ;
            case 5:
                boolean fvK = com.tencent.mm.plugin.textstatus.a.p.fvK();
                AppMethodBeat.o(258311);
                return fvK;
            case 6:
                boolean fvL = com.tencent.mm.plugin.textstatus.a.p.fvL();
                AppMethodBeat.o(258311);
                return fvL;
            case 7:
                boolean fvD = com.tencent.mm.plugin.textstatus.a.p.fvD();
                AppMethodBeat.o(258311);
                return fvD;
            default:
                AppMethodBeat.o(258311);
                return false;
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(216048);
        p.h(gVar, Scopes.PROFILE);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.textstatus.a.i.class, new com.tencent.mm.plugin.textstatus.f.j());
        }
        AppMethodBeat.o(216048);
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        return null;
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(216049);
        if (gVar != null && gVar.aBb()) {
            y.a("textstatus", "textstatus", TPAudioFrame.TP_CH_STEREO_LEFT, 7776000000L, 3);
        }
        AppMethodBeat.o(216049);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(216050);
        p.h(cVar, "upgrade");
        Log.i("MicroMsg.TxtStatus.PluginTextStatus", "onAccountInitialized");
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah).getSysCmdMsgExtension().a("modtextstatus", com.tencent.mm.plugin.textstatus.b.f.FXJ);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah2).getSysCmdMsgExtension().a("textstatuslike", com.tencent.mm.plugin.textstatus.b.f.FXJ);
        com.tencent.mm.kernel.g.azz().a(302, this);
        ((com.tencent.mm.plugin.messenger.foundation.a.e) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.e.class)).addContactAssembler(new b());
        com.tencent.mm.plugin.textstatus.f.h.c cVar2 = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
        com.tencent.mm.plugin.textstatus.f.h.c.cjR();
        if (cVar.hrc && com.tencent.mm.plugin.textstatus.a.p.hXn() == 1) {
            com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.textstatus.f.l());
            this.Vcy = true;
        }
        AppMethodBeat.o(216050);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J8\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/textstatus/PluginTextStatus$onAccountInitialized$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/IContactSyncCallback;", "afterContactUpdate", "", "newContact", "Lcom/tencent/mm/storage/Contact;", "oldContact", "cmdMC", "Lcom/tencent/mm/protocal/protobuf/ModContact;", "cmdBuf", "", "isInit", "", "assemble", "plugin-textstatus_release"})
    public static final class b implements com.tencent.mm.plugin.messenger.foundation.a.d {
        b() {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.d
        public final void a(as asVar, as asVar2, cpl cpl, byte[] bArr, boolean z) {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.d
        public final void b(as asVar, as asVar2, cpl cpl, byte[] bArr, boolean z) {
            boolean z2;
            AppMethodBeat.i(216020);
            if (cpl != null) {
                if ((asVar2 == null || !asVar2.arv()) && asVar != null && asVar.arv()) {
                    com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                    com.tencent.mm.plugin.textstatus.f.f.f fvO = com.tencent.mm.plugin.textstatus.b.f.fvO();
                    String username = asVar.getUsername();
                    p.g(username, "newContact.username");
                    p.h(username, "userName");
                    String hRD = fvO.hRD();
                    if (!(hRD == null || hRD.length() == 0)) {
                        com.tencent.mm.plugin.textstatus.f.f.e eVar = new com.tencent.mm.plugin.textstatus.f.f.e();
                        eVar.field_UserName = username;
                        eVar.field_HashUserName = com.tencent.mm.plugin.textstatus.f.f.f.fA(username, fvO.hRD());
                        fvO.replace(eVar);
                    }
                }
                if (cpl.MvB != 2 || asVar == null || !asVar.arv()) {
                    AppMethodBeat.o(216020);
                    return;
                }
                String str = cpl.LiD;
                String str2 = cpl.LiF;
                Log.i("MicroMsg.TxtStatus.PluginTextStatus", "afterContactUpdate, statusID: " + str + ", extInfo: " + str2);
                String str3 = str;
                if (str3 == null || str3.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    String str4 = str2;
                    if (!(str4 == null || str4.length() == 0)) {
                        com.tencent.mm.plugin.textstatus.g.g gVar = new com.tencent.mm.plugin.textstatus.g.g();
                        gVar.parseFrom(Base64.decode(str2, 0));
                        com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                        String username2 = asVar.getUsername();
                        p.g(username2, "newContact.username");
                        com.tencent.mm.plugin.textstatus.b.f.a(fVar2, username2, str, gVar);
                        AppMethodBeat.o(216020);
                        return;
                    }
                }
                com.tencent.mm.plugin.textstatus.b.f fVar3 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                com.tencent.mm.plugin.textstatus.f.f.d fvM = com.tencent.mm.plugin.textstatus.b.f.fvM();
                String username3 = asVar.getUsername();
                p.g(username3, "newContact.username");
                fvM.aTk(username3);
                AppMethodBeat.o(216020);
                return;
            }
            AppMethodBeat.o(216020);
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(216051);
        Log.i("MicroMsg.TxtStatus.PluginTextStatus", "onAccountRelease");
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah).getSysCmdMsgExtension().b("modtextstatus", com.tencent.mm.plugin.textstatus.b.f.FXJ);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah2).getSysCmdMsgExtension().b("textstatuslike", com.tencent.mm.plugin.textstatus.b.f.FXJ);
        com.tencent.mm.kernel.g.azz().b(302, this);
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.b.f.getDataDB().closeDB();
        AppMethodBeat.o(216051);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        eos eos;
        boolean z;
        AppMethodBeat.i(216052);
        p.h(qVar, "scene");
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.network.s reqResp = ((com.tencent.mm.modelsimple.p) qVar).getReqResp();
            if (reqResp == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                AppMethodBeat.o(216052);
                throw tVar;
            }
            com.tencent.mm.ak.d dVar = (com.tencent.mm.ak.d) reqResp;
            btd btd = (btd) (dVar != null ? dVar.aYK() : null);
            if (!(btd == null || (eos = btd.LZO) == null)) {
                String str2 = eos.LiD;
                String str3 = eos.LiF;
                Log.i("MicroMsg.TxtStatus.PluginTextStatus", "statusID: " + str2 + ", extInfo: " + str3);
                String str4 = str2;
                if (str4 == null || str4.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    String str5 = str3;
                    if (!(str5 == null || str5.length() == 0)) {
                        com.tencent.mm.plugin.textstatus.g.g gVar = new com.tencent.mm.plugin.textstatus.g.g();
                        gVar.parseFrom(Base64.decode(str3, 0));
                        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                        String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
                        p.g(ceA, "Account.username()");
                        com.tencent.mm.plugin.textstatus.b.f.a(fVar, ceA, str2, gVar);
                        com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.textstatus.f.g());
                    }
                }
                Log.i("MicroMsg.TxtStatus.PluginTextStatus", "del self");
                com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                com.tencent.mm.plugin.textstatus.f.f.d fvM = com.tencent.mm.plugin.textstatus.b.f.fvM();
                String ceA2 = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA2, "Account.username()");
                fvM.aTk(ceA2);
            }
        }
        if (!this.Vcy && com.tencent.mm.plugin.textstatus.a.p.hXn() == 1) {
            com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.textstatus.f.l());
        }
        AppMethodBeat.o(216052);
    }
}
