package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#J(\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020%2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020'R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "MENU_LIKE_TIME", "getMENU_LIKE_TIME", "MENU_LIVE_REC_INFO", "getMENU_LIVE_REC_INFO", "createFinderFeedDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createLiveDebugInfoDialog", "msg", "", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "createMegaVideoDialog", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "isEnableDebugInfo", "", "Companion", "plugin-finder_release"})
public final class FinderDebugUIC extends UIComponent {
    public static final String TAG = TAG;
    public static final a wvw = new a((byte) 0);
    final int wvp = 1;
    final int wvq = 2;
    final int wvr = 3;
    final int wvs = 4;
    final int wvt = 5;
    final int wvu = 6;
    final int wvv = 7;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createDialogInfo", "", "context", "Landroid/content/Context;", "txt", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void aG(Context context, String str) {
            AppMethodBeat.i(255452);
            p.h(context, "context");
            p.h(str, "txt");
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setGravity(3);
            textView.setTextSize(1, 13.0f);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            textView.setTextColor(context.getResources().getColor(R.color.fo));
            textView.setTypeface(Typeface.MONOSPACE);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.kb);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            Log.i(FinderDebugUIC.TAG, "dialog msg ".concat(String.valueOf(str)));
            h.a(context, "视频号测试", textView, "copy", "cancel", new b(str, context), DialogInterface$OnClickListenerC1352a.wvx);
            AppMethodBeat.o(255452);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        public static final class b implements DialogInterface.OnClickListener {
            final /* synthetic */ Context $context;
            final /* synthetic */ String wvy;

            b(String str, Context context) {
                this.wvy = str;
                this.$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(255451);
                a aVar = FinderDebugUIC.wvw;
                Log.i(FinderDebugUIC.TAG, "onClick1");
                ClipboardHelper.setText(this.wvy);
                Toast.makeText(this.$context, "copy done", 0).show();
                AppMethodBeat.o(255451);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC$a$a  reason: collision with other inner class name */
        public static final class DialogInterface$OnClickListenerC1352a implements DialogInterface.OnClickListener {
            public static final DialogInterface$OnClickListenerC1352a wvx = new DialogInterface$OnClickListenerC1352a();

            static {
                AppMethodBeat.i(255450);
                AppMethodBeat.o(255450);
            }

            DialogInterface$OnClickListenerC1352a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(255449);
                a aVar = FinderDebugUIC.wvw;
                Log.i(FinderDebugUIC.TAG, "onClickCancel");
                AppMethodBeat.o(255449);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderDebugUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255463);
        AppMethodBeat.o(255463);
    }

    static {
        AppMethodBeat.i(255464);
        AppMethodBeat.o(255464);
    }

    public final void a(Context context, BaseFinderFeed baseFinderFeed, s sVar, com.tencent.mm.view.recyclerview.h hVar) {
        boolean z;
        String str;
        AppMethodBeat.i(255461);
        p.h(context, "context");
        p.h(baseFinderFeed, "item");
        p.h(hVar, "holder");
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context, 0, false);
        long lT = baseFinderFeed.lT();
        FeedData.a aVar = FeedData.Companion;
        cjl cjl = (cjl) j.ks(FeedData.a.s(baseFinderFeed).getMediaList());
        if (cjl.mediaType == 4) {
            z = true;
        } else {
            z = false;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject put = jSONObject.put("tag", "ClickMoreDebug");
        FinderContact finderContact = baseFinderFeed.feedObject.getFeedObject().contact;
        if (finderContact == null || (str = finderContact.nickname) == null) {
            str = "";
        }
        JSONObject put2 = put.put("nickname", str).put("feedId", com.tencent.mm.ac.d.zs(baseFinderFeed.feedObject.getId())).put("signedFeedId", baseFinderFeed.feedObject.getId()).put("feedTime", Util.formatUnixTime(((long) baseFinderFeed.feedObject.getCreateTime()) * 1)).put("videoDuration", cjl.videoDuration).put("mediaWH", new StringBuilder().append(cjl.width).append(':').append(cjl.height).toString()).put("mediaRadio", String.valueOf(cjl.height / kotlin.k.j.aI(1.0f, cjl.width))).put("description", baseFinderFeed.feedObject.getDescription()).put("isVideo", z).put("file_format", sVar != null ? sVar.uIx : null).put(ch.COL_USERNAME, baseFinderFeed.feedObject.field_username);
        c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
        JSONObject put3 = put2.put("isFollow", c.a.asJ(baseFinderFeed.feedObject.field_username)).put("mediaType", baseFinderFeed.feedObject.getMediaType());
        String str2 = cjl.url;
        if (str2 == null) {
            str2 = "";
        }
        JSONObject put4 = put3.put("mediaId", MD5Util.getMD5String(str2)).put("url", cjl.url).put("thumbUrl", cjl.thumbUrl).put("thumbUrlToken", cjl.thumb_url_token).put("coverUrl", cjl.coverUrl).put("coverUrlToken", cjl.cover_url_token).put("longUrl", p.I(cjl.url, Util.nullAsNil(cjl.url_token))).put("longThumbUrl", p.I(cjl.thumbUrl, Util.nullAsNil(cjl.thumb_url_token)));
        String str3 = baseFinderFeed.feedObject.getFeedObject().debugMessage;
        if (str3 == null) {
            str3 = "";
        }
        put4.put("debugMessage", str3);
        String buv = n.buv("content=" + com.tencent.mm.ac.g.bN(baseFinderFeed.feedObject.getFeedObject()));
        Log.e(TAG, "START####################################################START");
        Log.e(TAG, "long click more button! ".concat(String.valueOf(jSONObject)));
        Log.e(TAG, "long click more button allInfo! ".concat(String.valueOf(buv)));
        Log.e(TAG, "END  ####################################################  END");
        if (dHZ()) {
            eVar.a(new b(this, z));
            eVar.a(new c(this, context, jSONObject, baseFinderFeed, lT, cjl, buv, hVar));
            eVar.dGm();
        }
        AppMethodBeat.o(255461);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class b implements o.f {
        final /* synthetic */ boolean wvA;
        final /* synthetic */ FinderDebugUIC wvz;

        b(FinderDebugUIC finderDebugUIC, boolean z) {
            this.wvz = finderDebugUIC;
            this.wvA = z;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(255453);
            mVar.b(this.wvz.wvp, "feed信息", R.raw.finder_icons_link);
            mVar.b(this.wvz.wvr, "强化流检查", R.raw.bottomsheet_icon_refresh);
            if (this.wvA) {
                mVar.b(this.wvz.wvs, "VIDEO信息", R.raw.bottomsheet_icon_brower);
                mVar.b(this.wvz.wvt, "转发视频文件", R.raw.bottomsheet_icon_transmit);
            }
            mVar.b(this.wvz.wvq, "拷贝feed全量信息", R.raw.bottomsheet_icon_star);
            mVar.b(this.wvz.wvu, "拷贝feed点赞信息", R.raw.bottomsheet_icon_star);
            AppMethodBeat.o(255453);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class c implements o.g {
        final /* synthetic */ Context $context;
        final /* synthetic */ cjl UVN;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ long txv;
        final /* synthetic */ JSONObject wvB;
        final /* synthetic */ String wvC;
        final /* synthetic */ FinderDebugUIC wvz;

        c(FinderDebugUIC finderDebugUIC, Context context, JSONObject jSONObject, BaseFinderFeed baseFinderFeed, long j2, cjl cjl, String str, com.tencent.mm.view.recyclerview.h hVar) {
            this.wvz = finderDebugUIC;
            this.$context = context;
            this.wvB = jSONObject;
            this.tAr = baseFinderFeed;
            this.txv = j2;
            this.UVN = cjl;
            this.wvC = str;
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(255455);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == this.wvz.wvp) {
                a aVar = FinderDebugUIC.wvw;
                Context context = this.$context;
                String jSONObject = this.wvB.toString();
                p.g(jSONObject, "json.toString()");
                a.aG(context, jSONObject);
                AppMethodBeat.o(255455);
            } else if (itemId == this.wvz.wvr) {
                a aVar2 = FinderDebugUIC.wvw;
                Context context2 = this.$context;
                StringBuilder sb = new StringBuilder("后台配置:");
                com.tencent.mm.plugin.finder.storage.data.h hVar = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                StringBuilder append = sb.append(com.tencent.mm.plugin.finder.storage.data.h.FI(this.tAr.feedObject.getId())).append(" \n是否触发拉取过:");
                com.tencent.mm.plugin.finder.storage.data.h hVar2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                a.aG(context2, append.append(!com.tencent.mm.plugin.finder.storage.data.h.FJ(this.txv)).toString());
                AppMethodBeat.o(255455);
            } else if (itemId == this.wvz.wvu) {
                StringBuilder sb2 = new StringBuilder("friendLikeCount=" + this.tAr.feedObject.getFeedObject().friendLikeCount + " incFriendLikeCount=" + this.tAr.feedObject.getFeedObject().incFriendLikeCount + '\n');
                LinkedList<FinderCommentInfo> linkedList = this.tAr.feedObject.getFeedObject().likeList;
                p.g(linkedList, "item.feedObject.feedObject.likeList");
                for (T t : linkedList) {
                    sb2.append(t.nickname).append("=").append(Util.formatUnixTime(t.createtime)).append("\n");
                }
                a aVar3 = FinderDebugUIC.wvw;
                Context context3 = this.$context;
                String sb3 = sb2.toString();
                p.g(sb3, "ss.toString()");
                a.aG(context3, sb3);
                AppMethodBeat.o(255455);
            } else if (itemId == this.wvz.wvs) {
                s b2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(this.tAr.lT(), this.UVN);
                a aVar4 = FinderDebugUIC.wvw;
                a.aG(this.$context, "path:" + b2.getPath() + " \nsize:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(b2.getPath())) + '\n' + "mediaId:" + b2.uIw.mediaId + '\n' + "url=" + this.UVN.url + " \n" + SightVideoJNI.getSimpleMp4InfoVFS(b2.getPath()) + " \nisH265:" + SightVideoJNI.isH265VideoVFS(b2.getPath()));
                AppMethodBeat.o(255455);
            } else if (itemId == this.wvz.wvt) {
                s b3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(this.tAr.lT(), this.UVN);
                String str = "path:" + b3.getPath() + " \nsize:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(b3.getPath())) + '\n' + "mediaId:" + b3.uIw.mediaId + '\n' + "url=" + this.UVN.url;
                Intent intent = new Intent();
                WXFileObject wXFileObject = new WXFileObject();
                wXFileObject.setFilePath(b3.getPath());
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXFileObject;
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(b3.getPath());
                wXMediaMessage.title = oVar.getName();
                wXMediaMessage.description = Util.getSizeKB(oVar.length());
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("Retr_Msg_Type", 2);
                Context context4 = this.$context;
                if (context4 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(255455);
                    throw tVar;
                }
                com.tencent.mm.br.c.a((MMFragmentActivity) context4, ".ui.transmit.SelectConversationUI", intent, 1004, new a(wXMediaMessage, str));
                AppMethodBeat.o(255455);
            } else {
                if (itemId == this.wvz.wvq) {
                    ClipboardHelper.setText(this.wvC);
                    Toast.makeText(this.qhp.getContext(), "debug info " + this.wvC, 1).show();
                }
                AppMethodBeat.o(255455);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        static final class a implements MMFragmentActivity.b {
            final /* synthetic */ String uhA;
            final /* synthetic */ WXMediaMessage wvD;

            a(WXMediaMessage wXMediaMessage, String str) {
                this.wvD = wXMediaMessage;
                this.uhA = str;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
            @Override // com.tencent.mm.ui.MMFragmentActivity.b
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void d(int r7, int r8, android.content.Intent r9) {
                /*
                // Method dump skipped, instructions count: 185
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.c.a.d(int, int, android.content.Intent):void");
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class f implements o.f {
        final /* synthetic */ FinderDebugUIC wvz;

        public f(FinderDebugUIC finderDebugUIC) {
            this.wvz = finderDebugUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(255458);
            mVar.b(this.wvz.wvp, "feed信息", R.raw.finder_icons_link);
            mVar.b(this.wvz.wvr, "强化流检查", R.raw.bottomsheet_icon_refresh);
            mVar.b(this.wvz.wvs, "VIDEO信息", R.raw.bottomsheet_icon_brower);
            mVar.b(this.wvz.wvt, "转发视频文件", R.raw.bottomsheet_icon_transmit);
            mVar.b(this.wvz.wvq, "拷贝feed全量信息", R.raw.bottomsheet_icon_star);
            mVar.b(this.wvz.wvu, "拷贝feed点赞信息", R.raw.bottomsheet_icon_star);
            AppMethodBeat.o(255458);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ long txv;
        final /* synthetic */ bm uKq;
        final /* synthetic */ JSONObject wvB;
        final /* synthetic */ String wvC;
        final /* synthetic */ FinderDebugUIC wvz;

        public g(FinderDebugUIC finderDebugUIC, Context context, JSONObject jSONObject, long j2, bm bmVar, String str, com.tencent.mm.view.recyclerview.h hVar) {
            this.wvz = finderDebugUIC;
            this.$context = context;
            this.wvB = jSONObject;
            this.txv = j2;
            this.uKq = bmVar;
            this.wvC = str;
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            Integer num;
            String str = null;
            AppMethodBeat.i(255460);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == this.wvz.wvp) {
                a aVar = FinderDebugUIC.wvw;
                Context context = this.$context;
                String jSONObject = this.wvB.toString();
                p.g(jSONObject, "json.toString()");
                a.aG(context, jSONObject);
                AppMethodBeat.o(255460);
            } else if (itemId == this.wvz.wvr) {
                a aVar2 = FinderDebugUIC.wvw;
                Context context2 = this.$context;
                StringBuilder sb = new StringBuilder("后台配置:");
                com.tencent.mm.plugin.finder.storage.data.h hVar = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                StringBuilder append = sb.append(com.tencent.mm.plugin.finder.storage.data.h.FI(this.txv)).append(" \n是否触发拉取过:");
                com.tencent.mm.plugin.finder.storage.data.h hVar2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                a.aG(context2, append.append(!com.tencent.mm.plugin.finder.storage.data.h.FJ(this.txv)).toString());
                AppMethodBeat.o(255460);
            } else if (itemId == this.wvz.wvu) {
                StringBuilder sb2 = new StringBuilder("friendLikeCount=");
                cng cng = this.uKq.tuP;
                if (cng != null) {
                    num = Integer.valueOf(cng.friendLikeCount);
                } else {
                    num = null;
                }
                StringBuilder sb3 = new StringBuilder(sb2.append(num).toString());
                a aVar3 = FinderDebugUIC.wvw;
                Context context3 = this.$context;
                String sb4 = sb3.toString();
                p.g(sb4, "ss.toString()");
                a.aG(context3, sb4);
                AppMethodBeat.o(255460);
            } else if (itemId == this.wvz.wvs) {
                cjl cjl = (cjl) j.kt(this.uKq.dkV());
                if (cjl != null) {
                    s b2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(this.txv, cjl);
                    String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(b2.getPath());
                    boolean isH265VideoVFS = SightVideoJNI.isH265VideoVFS(b2.getPath());
                    StringBuilder append2 = new StringBuilder("path:").append(b2.getPath()).append(" \nsize:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(b2.getPath()))).append('\n').append("mediaId:").append(b2.uIw.mediaId).append('\n').append("url=");
                    cjl cjl2 = (cjl) j.kt(this.uKq.dkV());
                    if (cjl2 != null) {
                        str = cjl2.url;
                    }
                    String sb5 = append2.append(str).append(" \n").append(simpleMp4InfoVFS).append(" \nisH265:").append(isH265VideoVFS).toString();
                    a aVar4 = FinderDebugUIC.wvw;
                    a.aG(this.$context, sb5);
                    AppMethodBeat.o(255460);
                    return;
                }
                AppMethodBeat.o(255460);
            } else if (itemId == this.wvz.wvt) {
                cjl cjl3 = (cjl) j.kt(this.uKq.dkV());
                if (cjl3 != null) {
                    s b3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(this.txv, cjl3);
                    StringBuilder append3 = new StringBuilder("path:").append(b3.getPath()).append(" \nsize:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(b3.getPath()))).append('\n').append("mediaId:").append(b3.uIw.mediaId).append('\n').append("url=");
                    cjl cjl4 = (cjl) j.kt(this.uKq.dkV());
                    if (cjl4 != null) {
                        str = cjl4.url;
                    }
                    String sb6 = append3.append(str).toString();
                    Intent intent = new Intent();
                    WXFileObject wXFileObject = new WXFileObject();
                    wXFileObject.setFilePath(b3.getPath());
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.mediaObject = wXFileObject;
                    com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(b3.getPath());
                    wXMediaMessage.title = oVar.getName();
                    wXMediaMessage.description = Util.getSizeKB(oVar.length());
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("select_is_ret", true);
                    intent.putExtra("Retr_Msg_Type", 2);
                    Context context4 = this.$context;
                    if (context4 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                        AppMethodBeat.o(255460);
                        throw tVar;
                    }
                    com.tencent.mm.br.c.a((MMFragmentActivity) context4, ".ui.transmit.SelectConversationUI", intent, 1004, new a(wXMediaMessage, sb6));
                    AppMethodBeat.o(255460);
                    return;
                }
                AppMethodBeat.o(255460);
            } else {
                if (itemId == this.wvz.wvq) {
                    ClipboardHelper.setText(this.wvC);
                    Toast.makeText(this.qhp.getContext(), "debug info " + this.wvC, 1).show();
                }
                AppMethodBeat.o(255460);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        static final class a implements MMFragmentActivity.b {
            final /* synthetic */ String uhA;
            final /* synthetic */ WXMediaMessage wvD;

            a(WXMediaMessage wXMediaMessage, String str) {
                this.wvD = wXMediaMessage;
                this.uhA = str;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
            @Override // com.tencent.mm.ui.MMFragmentActivity.b
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void d(int r7, int r8, android.content.Intent r9) {
                /*
                // Method dump skipped, instructions count: 185
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.g.a.d(int, int, android.content.Intent):void");
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ FinderDebugUIC wvz;

        public d(FinderDebugUIC finderDebugUIC) {
            this.wvz = finderDebugUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(255456);
            mVar.b(this.wvz.wvp, "feed信息", R.raw.finder_icons_link);
            mVar.b(this.wvz.wvv, "推荐信息", R.raw.finder_icons_link);
            AppMethodBeat.o(255456);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class e implements o.g {
        final /* synthetic */ Context $context;
        final /* synthetic */ String uhA;
        final /* synthetic */ String wvE;
        final /* synthetic */ FinderDebugUIC wvz;

        public e(FinderDebugUIC finderDebugUIC, Context context, String str, String str2) {
            this.wvz = finderDebugUIC;
            this.$context = context;
            this.wvE = str;
            this.uhA = str2;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(255457);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == this.wvz.wvp) {
                a aVar = FinderDebugUIC.wvw;
                a.aG(this.$context, this.wvE);
                AppMethodBeat.o(255457);
                return;
            }
            if (itemId == this.wvz.wvv) {
                a aVar2 = FinderDebugUIC.wvw;
                a.aG(this.$context, this.uhA);
            }
            AppMethodBeat.o(255457);
        }
    }

    public static boolean dHZ() {
        AppMethodBeat.i(255462);
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(255462);
            return true;
        }
        AppMethodBeat.o(255462);
        return false;
    }
}
