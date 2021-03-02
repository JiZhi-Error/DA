package com.tencent.mm.plugin.gamelife;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.game.report.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.c;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.plugin.gamelife.g.c;
import com.tencent.mm.plugin.gamelife.g.d;
import com.tencent.mm.plugin.gamelife.j.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.ae;
import kotlin.g.b.z;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001yB\u0005¢\u0006\u0002\u0010\u0005JO\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2#\u0010=\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002060>H\u0002J\u0006\u0010B\u001a\u000206J\u0014\u0010C\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020E0DH\u0016J\u0012\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J@\u0010I\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010A\u001a\u0004\u0018\u00010\u000f2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020&0M2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020&0M2\u0006\u0010=\u001a\u00020OH\u0016J\b\u0010P\u001a\u000206H\u0016J0\u0010Q\u001a\u0002062\u0006\u0010J\u001a\u00020K2\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<J\"\u0010R\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010S\u001a\u00020T2\u0006\u0010A\u001a\u00020\u000fH\u0016J$\u0010U\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010V\u001a\u0004\u0018\u00010\u000f2\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010W\u001a\u0002062\u0006\u0010J\u001a\u00020K2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010X\u001a\u0002062\u0006\u0010G\u001a\u00020HH\u0016J\u0006\u0010Y\u001a\u00020\rJ\u0006\u0010Z\u001a\u00020\u001bJ\u0006\u0010[\u001a\u00020\u001dJ\b\u0010\\\u001a\u00020$H\u0002J\u0006\u0010]\u001a\u000200J\u0006\u0010^\u001a\u000202J\b\u0010_\u001a\u000206H\u0002J&\u0010`\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010A\u001a\u0004\u0018\u00010\u000f2\b\u0010=\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010b\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010c\u001a\u0002062\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u000206H\u0016JD\u0010g\u001a\u0002062\u0006\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010m\u001a\u000206H\u0002JY\u0010n\u001a\u0002062\u0006\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020j2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000f2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010rJ\b\u0010s\u001a\u000206H\u0002JL\u0010t\u001a\u0002062\u0006\u0010J\u001a\u00020K2\u0006\u0010u\u001a\u00020\u000f2\u0006\u0010p\u001a\u00020:2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020&0M2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020&0M2\u0006\u0010=\u001a\u00020O2\u0006\u0010v\u001a\u00020wH\u0002J\u0006\u0010x\u001a\u000206R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0004\n\u0002\u0010'R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000¨\u0006z"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/PluginGameLife;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appMessageInterceptor", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "getAppMessageInterceptor", "()Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "appMessageInterceptor$delegate", "Lkotlin/Lazy;", "appMessageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "avatarPath", "", "getAvatarPath", "()Ljava/lang/String;", "setAvatarPath", "(Ljava/lang/String;)V", "cacheDBPath", "contactService", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "getContactService", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "contactService$delegate", "contactStorage", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "getConversationUpdateCallback", "()Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "conversationUpdateCallback$delegate", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "gameChatUnreadState", "", "Ljava/lang/Boolean;", "getContactInterceptor", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getContactInterceptor$delegate", "lock", "", "messageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkSessionIdAndContact", "", "selfUsername", "talker", "scene", "", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sessionId", "clearDB", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dealBlackList", "context", "Landroid/content/Context;", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "isAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "dependency", "enterChattingUI", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "outerUserName", "enterSendGift", "execute", "getAppMessageStorage", "getContactStorage", "getConversationStorage", "getDB", "getMessageStorage", "getSessionInfoStorage", "initDB", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "jumpToGameLifeSingleChatInfoUIReport", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "reportChattingDetail", "pos", "actionId", "", "selfUserName", "actionStatus", "reportGameChatUnreadState", "reportSingleChatInfoUIDetail", "dealWaGameAccountTogether", "accountType", "associate", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "resetDB", "showGameLifeDialog", "userName", "sessionInfo", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "testEnterChattingUI", "Companion", "plugin-gamelife_release"})
public final class PluginGameLife extends com.tencent.mm.kernel.b.f implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, c {
    private static final String yam = yam;
    private static final String yan = yan;
    public static final a yao = new a((byte) 0);
    private com.tencent.mm.storagebase.h hqK;
    private final byte[] lock = new byte[0];
    public String tjJ;
    private final kotlin.f toD = kotlin.g.ah(p.yaK);
    private final MStorage.IOnStorageChange xWT = new z(this);
    private String yac;
    private final kotlin.f yad = kotlin.g.ah(l.yaB);
    private final kotlin.f yae = kotlin.g.ah(k.yaA);
    private final kotlin.f yaf = kotlin.g.ah(b.yap);
    private com.tencent.mm.plugin.gamelife.d.c yag;
    private com.tencent.mm.plugin.gamelife.j.c yah;
    private com.tencent.mm.plugin.gamelife.e.e yai;
    private com.tencent.mm.plugin.gamelife.g.d yaj;
    private com.tencent.mm.plugin.gamelife.g.c yak;
    private Boolean yal;

    private final com.tencent.mm.plugin.gamelife.g.b getAppMessageInterceptor() {
        AppMethodBeat.i(241235);
        com.tencent.mm.plugin.gamelife.g.b bVar = (com.tencent.mm.plugin.gamelife.g.b) this.yaf.getValue();
        AppMethodBeat.o(241235);
        return bVar;
    }

    private final com.tencent.mm.plugin.gamelife.d.b getContactService() {
        AppMethodBeat.i(241233);
        com.tencent.mm.plugin.gamelife.d.b bVar = (com.tencent.mm.plugin.gamelife.d.b) this.yae.getValue();
        AppMethodBeat.o(241233);
        return bVar;
    }

    private final com.tencent.mm.plugin.gamelife.e.g getConversationUpdateCallback() {
        AppMethodBeat.i(241232);
        com.tencent.mm.plugin.gamelife.e.g gVar = (com.tencent.mm.plugin.gamelife.e.g) this.yad.getValue();
        AppMethodBeat.o(241232);
        return gVar;
    }

    private final com.tencent.mm.plugin.gamelife.d.d getGetContactInterceptor() {
        AppMethodBeat.i(241234);
        com.tencent.mm.plugin.gamelife.d.d dVar = (com.tencent.mm.plugin.gamelife.d.d) this.toD.getValue();
        AppMethodBeat.o(241234);
        return dVar;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.f.i.d wqd;
        final /* synthetic */ z.f wqe;
        final /* synthetic */ String yat;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(com.tencent.f.i.d dVar, z.f fVar, String str, Context context) {
            super(1);
            this.wqd = dVar;
            this.wqe = fVar;
            this.yat = str;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(241212);
            String str2 = str;
            this.wqd.cancel(false);
            T t = this.wqe.SYG;
            if (t != null) {
                t.dismiss();
            }
            String str3 = str2;
            if (!(str3 == null || str3.length() == 0)) {
                Log.i("GameLife.PluginGameLife", "[startChattingUI] sessionId=".concat(String.valueOf(str2)));
                Intent intent = new Intent();
                intent.putExtra("Chat_Self", this.yat);
                intent.putExtra("Chat_User", str2);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.br.c.f(this.$context, ".ui.chatting.ChattingUI", intent);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(241212);
            return xVar;
        }
    }

    public PluginGameLife() {
        AppMethodBeat.i(241266);
        AppMethodBeat.o(241266);
    }

    public static final /* synthetic */ void access$reportGameChatUnreadState(PluginGameLife pluginGameLife) {
        AppMethodBeat.i(241268);
        pluginGameLife.reportGameChatUnreadState();
        AppMethodBeat.o(241268);
    }

    public static final /* synthetic */ void access$reportSingleChatInfoUIDetail(PluginGameLife pluginGameLife, int i2, long j2, String str, String str2, String str3, Boolean bool, Integer num, Boolean bool2) {
        AppMethodBeat.i(241270);
        pluginGameLife.reportSingleChatInfoUIDetail(i2, j2, str, str2, str3, bool, num, bool2);
        AppMethodBeat.o(241270);
    }

    public static final /* synthetic */ void access$showGameLifeDialog(PluginGameLife pluginGameLife, Context context, String str, int i2, com.tencent.mm.plugin.appbrand.ac.i iVar, com.tencent.mm.plugin.appbrand.ac.i iVar2, c.b bVar, com.tencent.mm.plugin.gamelife.a.e eVar) {
        AppMethodBeat.i(241269);
        pluginGameLife.showGameLifeDialog(context, str, i2, iVar, iVar2, bVar, eVar);
        AppMethodBeat.o(241269);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/PluginGameLife$Companion;", "", "()V", "FROM_USERNAME", "", "getFROM_USERNAME", "()Ljava/lang/String;", "TAG", "TO_USERNAME", "getTO_USERNAME", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241267);
        AppMethodBeat.o(241267);
    }

    public final String getAvatarPath() {
        AppMethodBeat.i(241230);
        String str = this.tjJ;
        if (str == null) {
            kotlin.g.b.p.btv("avatarPath");
        }
        AppMethodBeat.o(241230);
        return str;
    }

    public final void setAvatarPath(String str) {
        AppMethodBeat.i(241231);
        kotlin.g.b.p.h(str, "<set-?>");
        this.tjJ = str;
        AppMethodBeat.o(241231);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(241236);
        kotlin.g.b.p.h(gVar, Scopes.PROFILE);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.f.class, new com.tencent.mm.plugin.gamelife.j.b());
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.b.class, getContactService());
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.c.class, new com.tencent.mm.plugin.gamelife.e.d());
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.d.class, new com.tencent.mm.plugin.gamelife.h.a());
        }
        AppMethodBeat.o(241236);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(241237);
        Log.i("GameLife.PluginGameLife", "Account Init");
        initDB();
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        this.tjJ = sb.append(aAh.getAccPath()).append("gamelife/avatar/").toString();
        ((com.tencent.mm.plugin.byp.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(3, new com.tencent.mm.plugin.gamelife.g.e());
        com.tencent.mm.plugin.messenger.foundation.a.l lVar = (com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        lVar.eiy().a(getMessageStorage());
        lVar.aST().a(getConversationUpdateCallback());
        lVar.aSN().a(getContactService().ybG);
        j.a gov = a.b.gov();
        if (gov instanceof com.tencent.mm.pluginsdk.ui.b) {
            com.tencent.mm.plugin.gamelife.f.d dVar = new com.tencent.mm.plugin.gamelife.f.d(((com.tencent.mm.pluginsdk.ui.b) gov).gow());
            ((com.tencent.mm.pluginsdk.ui.b) gov).a("@gamelife", dVar);
            ((com.tencent.mm.pluginsdk.ui.b) gov).a("@gamelifesess", dVar);
        }
        af.a.a(getGetContactInterceptor());
        com.tencent.mm.plugin.r.a.eAT().a(getAppMessageInterceptor());
        ((com.tencent.mm.plugin.gamelife.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.xWT);
        com.tencent.f.h.RTc.o(new r(this), 1000);
        AppMethodBeat.o(241237);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class r implements Runnable {
        final /* synthetic */ PluginGameLife yaC;

        r(PluginGameLife pluginGameLife) {
            this.yaC = pluginGameLife;
        }

        public final void run() {
            AppMethodBeat.i(241218);
            PluginGameLife.access$reportGameChatUnreadState(this.yaC);
            AppMethodBeat.o(241218);
        }
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(241238);
        com.tencent.mm.vfs.y.a("gamelife", "gamelife/avatar", TPAudioFrame.TP_CH_STEREO_LEFT, 7776000000L, 3);
        AppMethodBeat.o(241238);
    }

    private final void initDB() {
        AppMethodBeat.i(241239);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        this.yac = sb.append(aAh.azM()).append("GameLife.db").toString();
        com.tencent.mm.storagebase.h hVar = this.hqK;
        if (hVar == null) {
            PluginGameLife pluginGameLife = this;
            com.tencent.mm.storagebase.h hVar2 = new com.tencent.mm.storagebase.h();
            String str = pluginGameLife.yac;
            if (str == null) {
                kotlin.g.b.p.btv("cacheDBPath");
            }
            if (!hVar2.a(str, pluginGameLife.collectDatabaseFactory(), true)) {
                SQLiteException sQLiteException = new SQLiteException("GameLife db init failed");
                AppMethodBeat.o(241239);
                throw sQLiteException;
            }
            hVar = hVar2;
        }
        this.hqK = hVar;
        AppMethodBeat.o(241239);
    }

    public final void clearDB() {
        AppMethodBeat.i(241240);
        String str = this.yac;
        if (str == null) {
            kotlin.g.b.p.btv("cacheDBPath");
        }
        com.tencent.mm.vfs.s.deleteFile(str);
        resetDB();
        initDB();
        AppMethodBeat.o(241240);
    }

    public final void testEnterChattingUI() {
        AppMethodBeat.i(241241);
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).enterChattingUI(context, yam, yan, 0, null);
        AppMethodBeat.o(241241);
    }

    private final void resetDB() {
        AppMethodBeat.i(241242);
        com.tencent.mm.storagebase.h hVar = this.hqK;
        if (hVar != null) {
            hVar.closeDB();
        }
        this.hqK = null;
        this.yag = null;
        this.yah = null;
        this.yai = null;
        this.yak = null;
        this.yaj = null;
        AppMethodBeat.o(241242);
    }

    private final com.tencent.mm.storagebase.h getDB() {
        AppMethodBeat.i(241243);
        com.tencent.mm.storagebase.h hVar = this.hqK;
        if (hVar == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241243);
        return hVar;
    }

    public final com.tencent.mm.plugin.gamelife.d.c getContactStorage() {
        AppMethodBeat.i(241244);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.gamelife.d.c cVar = this.yag;
        if (cVar == null) {
            cVar = new com.tencent.mm.plugin.gamelife.d.c(getDB());
        }
        this.yag = cVar;
        com.tencent.mm.plugin.gamelife.d.c cVar2 = this.yag;
        if (cVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241244);
        return cVar2;
    }

    public final com.tencent.mm.plugin.gamelife.j.c getSessionInfoStorage() {
        AppMethodBeat.i(241245);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.gamelife.j.c cVar = this.yah;
        if (cVar == null) {
            cVar = new com.tencent.mm.plugin.gamelife.j.c(getDB());
        }
        this.yah = cVar;
        com.tencent.mm.plugin.gamelife.j.c cVar2 = this.yah;
        if (cVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241245);
        return cVar2;
    }

    public final com.tencent.mm.plugin.gamelife.e.e getConversationStorage() {
        AppMethodBeat.i(241246);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.gamelife.e.e eVar = this.yai;
        if (eVar == null) {
            eVar = new com.tencent.mm.plugin.gamelife.e.e(getDB());
        }
        this.yai = eVar;
        com.tencent.mm.plugin.gamelife.e.e eVar2 = this.yai;
        if (eVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241246);
        return eVar2;
    }

    public final com.tencent.mm.plugin.gamelife.g.c getAppMessageStorage() {
        AppMethodBeat.i(241247);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.gamelife.g.c cVar = this.yak;
        if (cVar == null) {
            cVar = new com.tencent.mm.plugin.gamelife.g.c(getDB());
        }
        this.yak = cVar;
        com.tencent.mm.plugin.gamelife.g.c cVar2 = this.yak;
        if (cVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241247);
        return cVar2;
    }

    public final com.tencent.mm.plugin.gamelife.g.d getMessageStorage() {
        AppMethodBeat.i(241248);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        com.tencent.mm.plugin.messenger.foundation.a.a.i eiy = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy();
        com.tencent.mm.plugin.gamelife.g.d dVar = this.yaj;
        if (dVar == null) {
            kotlin.g.b.p.g(eiy, "msgStg");
            dVar = new com.tencent.mm.plugin.gamelife.g.d(eiy);
        }
        this.yaj = dVar;
        com.tencent.mm.plugin.gamelife.g.d dVar2 = this.yaj;
        if (dVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241248);
        return dVar2;
    }

    public final void enterChattingUI(Context context, String str, String str2, int i2, com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(241249);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "selfUsername");
        kotlin.g.b.p.h(str2, "talker");
        z.f fVar = new z.f();
        fVar.SYG = null;
        checkSessionIdAndContact(str, str2, i2, bVar, new n(com.tencent.f.h.RTc.n(new o(fVar, context), 1000), fVar, str, context));
        AppMethodBeat.o(241249);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class o implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f wqe;

        o(z.f fVar, Context context) {
            this.wqe = fVar;
            this.$context = context;
        }

        public final void run() {
            AppMethodBeat.i(241214);
            this.wqe.SYG = (T) com.tencent.mm.ui.base.q.a(this.$context, this.$context.getResources().getString(R.string.a06), false, 0, AnonymousClass1.yaJ);
            AppMethodBeat.o(241214);
        }
    }

    private final void checkSessionIdAndContact(String str, String str2, int i2, com.tencent.mm.bw.b bVar, kotlin.g.a.b<? super String, kotlin.x> bVar2) {
        AppMethodBeat.i(241250);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        LinkedList linkedList = new LinkedList();
        e eVar = new e(atomicInteger, linkedList, bVar2);
        ((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).a(str, str2, i2, bVar, new c(atomicInteger, bVar2, linkedList, eVar));
        ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(kotlin.a.j.listOf((Object[]) new String[]{str, str2}), new d(str, str2, eVar, atomicInteger, bVar2));
        AppMethodBeat.o(241250);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ AtomicInteger yaq;
        final /* synthetic */ LinkedList yar;

        e(AtomicInteger atomicInteger, LinkedList linkedList, kotlin.g.a.b bVar) {
            this.yaq = atomicInteger;
            this.yar = linkedList;
            this.gWe = bVar;
        }

        public final void run() {
            AppMethodBeat.i(241196);
            if (this.yaq.incrementAndGet() == 2) {
                Log.i("GameLife.PluginGameLife", "checkSessionIdAndContact success: " + ((String) this.yar.get(0)));
                this.gWe.invoke(this.yar.get(0));
            }
            AppMethodBeat.o(241196);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onDone"})
    public static final class c implements f.a {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ AtomicInteger yaq;
        final /* synthetic */ LinkedList yar;
        final /* synthetic */ Runnable yas;

        c(AtomicInteger atomicInteger, kotlin.g.a.b bVar, LinkedList linkedList, Runnable runnable) {
            this.yaq = atomicInteger;
            this.gWe = bVar;
            this.yar = linkedList;
            this.yas = runnable;
        }

        @Override // com.tencent.mm.plugin.gamelife.a.f.a
        public final void onDone(String str) {
            AppMethodBeat.i(241194);
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                this.yar.add(str);
                this.yas.run();
            } else if (this.yaq.getAndSet(-1) >= 0) {
                Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get session failed");
                this.gWe.invoke(null);
                AppMethodBeat.o(241194);
                return;
            }
            AppMethodBeat.o(241194);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    public static final class d implements b.c {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ String vdJ;
        final /* synthetic */ AtomicInteger yaq;
        final /* synthetic */ Runnable yas;
        final /* synthetic */ String yat;

        d(String str, String str2, Runnable runnable, AtomicInteger atomicInteger, kotlin.g.a.b bVar) {
            this.yat = str;
            this.vdJ = str2;
            this.yas = runnable;
            this.yaq = atomicInteger;
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.plugin.gamelife.a.b.c
        public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> map) {
            com.tencent.mm.plugin.gamelife.a.a aVar;
            AppMethodBeat.i(241195);
            com.tencent.mm.plugin.gamelife.a.a aVar2 = map.get(this.yat);
            if (aVar2 == null || !aVar2.isValid() || (aVar = map.get(this.vdJ)) == null || !aVar.isValid()) {
                if (this.yaq.getAndSet(-1) >= 0) {
                    Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get contact failed");
                    this.gWe.invoke(null);
                }
                AppMethodBeat.o(241195);
                return;
            }
            this.yas.run();
            AppMethodBeat.o(241195);
        }
    }

    public final void jumpToGameLifeSingleChatInfoUIReport(String str) {
        AppMethodBeat.i(241251);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Log.e("GameLife.PluginGameLife", "jumpToGameLifeSingleChatInfoUI sessionId null!");
            AppMethodBeat.o(241251);
            return;
        }
        com.tencent.mm.plugin.gamelife.a.e aAW = ((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(str);
        kotlin.g.b.p.g(aAW, "sessionInfo");
        String ajO = aAW.ajO();
        String selfUsername = aAW.getSelfUsername();
        kotlin.g.b.p.g(selfUsername, "selfUserName");
        reportChattingDetail$default(this, 1, 6, selfUsername, str, ajO, null, 32, null);
        AppMethodBeat.o(241251);
    }

    @Override // com.tencent.mm.plugin.gamelife.c
    public final void enterGameLifeProfileUI(Context context, String str, int i2) {
        AppMethodBeat.i(241252);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(241252);
            return;
        }
        if (i2 == a.xZY) {
            if (as.bjv(str)) {
                reportChattingDetail(2, 7, str, null, null, "1");
            } else {
                com.tencent.mm.plugin.gamelife.a.e aAW = ((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(str);
                kotlin.g.b.p.g(aAW, "sessionInfo");
                str = aAW.ajO();
                kotlin.g.b.p.g(str, "sessionInfo.talker");
                String selfUsername = aAW.getSelfUsername();
                kotlin.g.b.p.g(selfUsername, "sessionInfo.selfUsername");
                reportChattingDetail(2, 7, selfUsername, aAW.getSessionId(), aAW.ajO(), "2");
            }
        } else if (i2 == a.xZX) {
            com.tencent.mm.plugin.gamelife.a.e aAW2 = ((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(str);
            kotlin.g.b.p.g(aAW2, "sessionInfo");
            str = aAW2.ajO();
            kotlin.g.b.p.g(str, "sessionInfo.talker");
            String sessionId = aAW2.getSessionId();
            kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
            String selfUsername2 = aAW2.getSelfUsername();
            kotlin.g.b.p.g(selfUsername2, "sessionInfo.selfUsername");
            String ajO = aAW2.ajO();
            kotlin.g.b.p.g(ajO, "sessionInfo.talker");
            reportSingleChatInfoUIDetail$default(this, 2, 7, sessionId, selfUsername2, ajO, null, null, null, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, null);
        } else {
            str = "";
        }
        com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(str);
        String dWX = aAR != null ? aAR.dWX() : "";
        String str3 = dWX;
        if (str3 == null || str3.length() == 0) {
            Log.e("GameLife.PluginGameLife", "userName:%s,jumpUrl null");
            AppMethodBeat.o(241252);
            return;
        }
        Log.i("GameLife.PluginGameLife", "userName:%s,jumpUrl:%s", str, dWX);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", dWX);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(241252);
    }

    public final void enterExpose(Context context, Intent intent, String str) {
        AppMethodBeat.i(241253);
        kotlin.g.b.p.h(intent, "intent");
        kotlin.g.b.p.h(str, "sessionId");
        com.tencent.mm.plugin.gamelife.a.e aAW = ((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(str);
        kotlin.g.b.p.g(aAW, "sessionInfo");
        String ajO = aAW.ajO();
        Log.d("GameLife.PluginGameLife", "talkerName:%s", ajO);
        intent.putExtra("k_username", ajO);
        ae aeVar = ae.SYK;
        String str2 = e.C2115e.OyW;
        kotlin.g.b.p.g(str2, "ConstantsUI.ExposeUI.KExposeGameLifeUrl");
        String format = String.format(str2, Arrays.copyOf(new Object[]{39}, 1));
        kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
        intent.putExtra("rawUrl", format);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        String selfUsername = aAW.getSelfUsername();
        String sessionId = aAW.getSessionId();
        kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
        kotlin.g.b.p.g(selfUsername, "selfUserName");
        kotlin.g.b.p.g(ajO, "talkerName");
        reportSingleChatInfoUIDetail$default(this, 8, 40, sessionId, selfUsername, ajO, null, null, null, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, null);
        AppMethodBeat.o(241253);
    }

    public final void initGameLifeSingleChatInfoUI(Context context, String str, c.a aVar) {
        AppMethodBeat.i(241254);
        if (context == null) {
            AppMethodBeat.o(241254);
            return;
        }
        c.a aVar2 = com.tencent.mm.game.report.c.hhl;
        c.a.a(4, 0, 0, 1, 301).bfK();
        com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.q.a(context, context.getResources().getString(R.string.a06), true, 3, null);
        kotlin.g.b.p.g(a2, "MMProgressDialog.show(co…TLE_TRANSPARENT_BG, null)");
        com.tencent.mm.ui.base.q qVar = a2;
        qVar.show();
        com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).avi(str));
        kotlin.g.b.p.g(aAR, "contact");
        String username = aAR.getUsername();
        if (aAR.dWY() <= 0) {
            Toast.makeText(context, (int) R.string.dtf, 0).show();
            AppMethodBeat.o(241254);
            return;
        }
        ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(username, new q(qVar, aVar, context));
        AppMethodBeat.o(241254);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/gamelife/PluginGameLife$initGameLifeSingleChatInfoUI$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
    public static final class q implements b.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ ProgressDialog yaL;
        final /* synthetic */ c.a yaM;

        q(ProgressDialog progressDialog, c.a aVar, Context context) {
            this.yaL = progressDialog;
            this.yaM = aVar;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.gamelife.a.b.a
        public final void U(boolean z, boolean z2) {
            AppMethodBeat.i(241217);
            Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame isAssociate:%b,isOwnBlack:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (this.yaL != null && this.yaL.isShowing()) {
                this.yaL.dismiss();
            }
            c.a aVar = this.yaM;
            if (aVar != null) {
                aVar.U(z, z2);
                AppMethodBeat.o(241217);
                return;
            }
            AppMethodBeat.o(241217);
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.c
    public final void enterSendGift(Context context, String str) {
        AppMethodBeat.i(241255);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "sessionId");
        Log.i("GameLife.PluginGameLife", "enterSendGift sessionId[%s]", str);
        com.tencent.mm.plugin.gamelife.a.e aAW = ((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(str);
        if (aAW != null) {
            com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(aAW.getSelfUsername());
            com.tencent.mm.plugin.gamelife.a.a aAR2 = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(aAW.ajO());
            if (!(aAR == null || aAR2 == null)) {
                c.a aVar = com.tencent.mm.game.report.c.hhl;
                long dWY = (long) aAR.dWY();
                String username = aAR.getUsername();
                kotlin.g.b.p.g(username, "selfContact.username");
                long dWY2 = (long) aAR2.dWY();
                String username2 = aAR2.getUsername();
                kotlin.g.b.p.g(username2, "talkerContact.username");
                kotlin.g.b.p.h(str, "sessionId");
                kotlin.g.b.p.h(username, "fromUsername");
                kotlin.g.b.p.h(username2, "toUsername");
                eq a2 = c.a.a(3, 302, 2, 2, 301);
                a2.rP(str);
                a2.mX(dWY);
                a2.rN(username);
                a2.mY(dWY2);
                a2.rO(username2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ser_name", 4L);
                a2.rQ(URLEncoder.encode(jSONObject.toString()));
                a2.bfK();
            }
            int C = ((com.tencent.mm.plugin.game.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.c.class)).C(context, aAW.getSelfUsername(), aAW.ajO());
            if (!(aAR == null || aAR2 == null)) {
                if (C == 40) {
                    c.a aVar2 = com.tencent.mm.game.report.c.hhl;
                    String username3 = aAR.getUsername();
                    kotlin.g.b.p.g(username3, "selfContact.username");
                    String username4 = aAR2.getUsername();
                    kotlin.g.b.p.g(username4, "talkerContact.username");
                    c.a.a(str, (long) aAR.dWY(), username3, (long) aAR2.dWY(), username4, 40);
                    AppMethodBeat.o(241255);
                    return;
                }
                c.a aVar3 = com.tencent.mm.game.report.c.hhl;
                String username5 = aAR.getUsername();
                kotlin.g.b.p.g(username5, "selfContact.username");
                String username6 = aAR2.getUsername();
                kotlin.g.b.p.g(username6, "talkerContact.username");
                c.a.a(str, (long) aAR.dWY(), username5, (long) aAR2.dWY(), username6, 71);
            }
            AppMethodBeat.o(241255);
            return;
        }
        AppMethodBeat.o(241255);
    }

    @Override // com.tencent.mm.plugin.gamelife.c
    public final void dealBlackList(Context context, String str, com.tencent.mm.plugin.appbrand.ac.i<Boolean> iVar, com.tencent.mm.plugin.appbrand.ac.i<Boolean> iVar2, c.b bVar) {
        AppMethodBeat.i(241256);
        kotlin.g.b.p.h(iVar, "isBlackList");
        kotlin.g.b.p.h(iVar2, "isAssociateWithWAGame");
        kotlin.g.b.p.h(bVar, "callback");
        if (context == null) {
            AppMethodBeat.o(241256);
            return;
        }
        com.tencent.mm.plugin.gamelife.a.e aAW = ((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(str);
        kotlin.g.b.p.g(aAW, "sessionInfo");
        String ajO = aAW.ajO();
        String selfUsername = aAW.getSelfUsername();
        String sessionId = aAW.getSessionId();
        kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
        kotlin.g.b.p.g(selfUsername, "selfUserName");
        kotlin.g.b.p.g(ajO, "talkerName");
        reportSingleChatInfoUIDetail$default(this, 5, 2, sessionId, selfUsername, ajO, null, null, null, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, null);
        com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(ajO);
        kotlin.g.b.p.g(aAR, "contact");
        int dWY = aAR.dWY();
        String username = aAR.getUsername();
        if (dWY <= 0) {
            Toast.makeText(context, (int) R.string.dtf, 0).show();
            AppMethodBeat.o(241256);
            return;
        }
        if (dWY == 2) {
            if (!(iVar.value == null || iVar2.value == null)) {
                kotlin.g.b.p.g(username, "userName");
                showGameLifeDialog(context, username, dWY, iVar, iVar2, bVar, aAW);
                AppMethodBeat.o(241256);
                return;
            }
        } else if (dWY == 1) {
            com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.q.a(context, context.getResources().getString(R.string.a06), true, 3, null);
            if (a2 == null) {
                kotlin.g.b.p.hyc();
            }
            a2.show();
            ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(username, new m(this, iVar, iVar2, username, a2, context, dWY, bVar, aAW));
        }
        AppMethodBeat.o(241256);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/gamelife/PluginGameLife$dealBlackList$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
    public static final class m implements b.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ String jDi;
        final /* synthetic */ PluginGameLife yaC;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaD;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaE;
        final /* synthetic */ ProgressDialog yaF;
        final /* synthetic */ int yaG;
        final /* synthetic */ c.b yaH;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.a.e yaI;

        m(PluginGameLife pluginGameLife, com.tencent.mm.plugin.appbrand.ac.i iVar, com.tencent.mm.plugin.appbrand.ac.i iVar2, String str, ProgressDialog progressDialog, Context context, int i2, c.b bVar, com.tencent.mm.plugin.gamelife.a.e eVar) {
            this.yaC = pluginGameLife;
            this.yaD = iVar;
            this.yaE = iVar2;
            this.jDi = str;
            this.yaF = progressDialog;
            this.$context = context;
            this.yaG = i2;
            this.yaH = bVar;
            this.yaI = eVar;
        }

        @Override // com.tencent.mm.plugin.gamelife.a.b.a
        public final void U(boolean z, boolean z2) {
            AppMethodBeat.i(241211);
            this.yaD.value = (T) Boolean.valueOf(z2);
            this.yaE.value = (T) Boolean.valueOf(z);
            Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame userName:%s,isAssociate:%b,isOwnBlack:%b", this.jDi, Boolean.valueOf(z), Boolean.valueOf(z2));
            if (this.yaF != null && this.yaF.isShowing()) {
                this.yaF.dismiss();
                PluginGameLife pluginGameLife = this.yaC;
                Context context = this.$context;
                String str = this.jDi;
                kotlin.g.b.p.g(str, "userName");
                int i2 = this.yaG;
                com.tencent.mm.plugin.appbrand.ac.i iVar = this.yaD;
                com.tencent.mm.plugin.appbrand.ac.i iVar2 = this.yaE;
                c.b bVar = this.yaH;
                com.tencent.mm.plugin.gamelife.a.e eVar = this.yaI;
                kotlin.g.b.p.g(eVar, "sessionInfo");
                PluginGameLife.access$showGameLifeDialog(pluginGameLife, context, str, i2, iVar, iVar2, bVar, eVar);
            }
            AppMethodBeat.o(241211);
        }
    }

    private final void showGameLifeDialog(Context context, String str, int i2, com.tencent.mm.plugin.appbrand.ac.i<Boolean> iVar, com.tencent.mm.plugin.appbrand.ac.i<Boolean> iVar2, c.b bVar, com.tencent.mm.plugin.gamelife.a.e eVar) {
        AppMethodBeat.i(241257);
        com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(context, 1, 2, false);
        gVar.apf(R.layout.at9);
        View findViewById = gVar.lJI.findViewById(R.id.dj_);
        kotlin.g.b.p.g(findViewById, "dialog.rootView.findView…blacklist_notifymsg_text)");
        TextView textView = (TextView) findViewById;
        View findViewById2 = gVar.lJI.findViewById(R.id.dja);
        kotlin.g.b.p.g(findViewById2, "dialog.rootView.findView…agame_blacklist_checkbox)");
        CheckBox checkBox = (CheckBox) findViewById2;
        View findViewById3 = gVar.lJI.findViewById(R.id.djb);
        kotlin.g.b.p.g(findViewById3, "dialog.rootView.findView…fe_wagame_blacklist_text)");
        TextView textView2 = (TextView) findViewById3;
        com.tencent.mm.plugin.appbrand.ac.i iVar3 = new com.tencent.mm.plugin.appbrand.ac.i();
        iVar3.value = (T) Boolean.TRUE;
        checkBox.setOnCheckedChangeListener(new u(iVar3));
        if ((iVar != null ? iVar.value : null) == null) {
            Log.e("GameLife.PluginGameLife", "showGameLifeDialog isBlackList null");
            AppMethodBeat.o(241257);
            return;
        }
        T t2 = iVar.value;
        kotlin.g.b.p.g(t2, "isBlackList.value");
        if (t2.booleanValue()) {
            if (i2 == 2) {
                textView.setText(R.string.dpw);
                textView2.setVisibility(8);
                checkBox.setVisibility(8);
            } else if (i2 == 1) {
                textView.setText(R.string.dpv);
                if (iVar2 != null) {
                    T t3 = iVar2.value;
                    kotlin.g.b.p.g(t3, "isAssociateWithWAGame.value");
                    if (t3.booleanValue()) {
                        textView2.setText(R.string.dpx);
                    } else {
                        checkBox.setVisibility(8);
                        textView2.setVisibility(8);
                    }
                }
            }
            gVar.a(new v(this, bVar, iVar, gVar, iVar2, iVar3, eVar, i2), new w(this, gVar, iVar2, iVar3, str, iVar, context, bVar, eVar, i2));
            gVar.b(context.getResources().getString(R.string.sz), context.getResources().getString(R.string.dpt));
            gVar.aE(context.getResources().getString(R.string.dpu));
            gVar.dGm();
            String sessionId = eVar.getSessionId();
            kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
            String selfUsername = eVar.getSelfUsername();
            kotlin.g.b.p.g(selfUsername, "sessionInfo.selfUsername");
            String ajO = eVar.ajO();
            kotlin.g.b.p.g(ajO, "sessionInfo.talker");
            reportSingleChatInfoUIDetail$default(this, 7, 1, sessionId, selfUsername, ajO, null, null, null, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, null);
            AppMethodBeat.o(241257);
            return;
        }
        if (i2 == 2) {
            textView.setText(R.string.dpq);
            checkBox.setVisibility(8);
        } else if (i2 == 1) {
            textView.setText(R.string.dpp);
            if (iVar2 != null) {
                T t4 = iVar2.value;
                kotlin.g.b.p.g(t4, "isAssociateWithWAGame.value");
                if (t4.booleanValue()) {
                    textView2.setText(R.string.dpr);
                } else {
                    checkBox.setVisibility(8);
                    textView2.setVisibility(8);
                }
            }
        }
        gVar.a(new x(this, gVar, bVar, iVar, iVar2, iVar3, eVar, i2), new y(this, gVar, iVar2, iVar3, str, iVar, context, bVar, eVar, i2));
        gVar.apd(context.getResources().getColor(R.color.a2x));
        gVar.axv(2);
        gVar.b(context.getResources().getString(R.string.sz), context.getResources().getString(R.string.dps));
        gVar.aE(context.getResources().getString(R.string.dpo));
        gVar.dGm();
        String sessionId2 = eVar.getSessionId();
        kotlin.g.b.p.g(sessionId2, "sessionInfo.sessionId");
        String selfUsername2 = eVar.getSelfUsername();
        kotlin.g.b.p.g(selfUsername2, "sessionInfo.selfUsername");
        String ajO2 = eVar.ajO();
        kotlin.g.b.p.g(ajO2, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 6, 1, sessionId2, selfUsername2, ajO2, null, null, null, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, null);
        AppMethodBeat.o(241257);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
    public static final class u implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaT;

        u(com.tencent.mm.plugin.appbrand.ac.i iVar) {
            this.yaT = iVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(241221);
            this.yaT.value = (T) Boolean.valueOf(z);
            AppMethodBeat.o(241221);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class v implements g.a {
        final /* synthetic */ com.tencent.mm.ui.widget.a.g hIa;
        final /* synthetic */ PluginGameLife yaC;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaD;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaE;
        final /* synthetic */ int yaG;
        final /* synthetic */ c.b yaH;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.a.e yaI;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaT;

        v(PluginGameLife pluginGameLife, c.b bVar, com.tencent.mm.plugin.appbrand.ac.i iVar, com.tencent.mm.ui.widget.a.g gVar, com.tencent.mm.plugin.appbrand.ac.i iVar2, com.tencent.mm.plugin.appbrand.ac.i iVar3, com.tencent.mm.plugin.gamelife.a.e eVar, int i2) {
            this.yaC = pluginGameLife;
            this.yaH = bVar;
            this.yaD = iVar;
            this.hIa = gVar;
            this.yaE = iVar2;
            this.yaT = iVar3;
            this.yaI = eVar;
            this.yaG = i2;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            boolean z;
            boolean z2;
            AppMethodBeat.i(241222);
            c.b bVar = this.yaH;
            if (bVar != null) {
                T t = this.yaD.value;
                kotlin.g.b.p.g(t, "isBlackList.value");
                bVar.mM(t.booleanValue());
            }
            this.hIa.bMo();
            if (this.yaE != null) {
                T t2 = this.yaE.value;
                kotlin.g.b.p.g(t2, "isAssociateWithWAGame.value");
                if (t2.booleanValue()) {
                    T t3 = this.yaT.value;
                    kotlin.g.b.p.g(t3, "dealWaGameAccountTogetherCheckBox.value");
                    if (t3.booleanValue()) {
                        z2 = true;
                        z = z2;
                    }
                }
                z2 = false;
                z = z2;
            } else {
                Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
                z = false;
            }
            PluginGameLife pluginGameLife = this.yaC;
            String sessionId = this.yaI.getSessionId();
            kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
            String selfUsername = this.yaI.getSelfUsername();
            kotlin.g.b.p.g(selfUsername, "sessionInfo.selfUsername");
            String ajO = this.yaI.ajO();
            kotlin.g.b.p.g(ajO, "sessionInfo.talker");
            PluginGameLife.access$reportSingleChatInfoUIDetail(pluginGameLife, 7, 4, sessionId, selfUsername, ajO, Boolean.valueOf(z), Integer.valueOf(this.yaG), this.yaE.value);
            AppMethodBeat.o(241222);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class w implements g.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.ui.widget.a.g hIa;
        final /* synthetic */ String jDi;
        final /* synthetic */ PluginGameLife yaC;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaD;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaE;
        final /* synthetic */ int yaG;
        final /* synthetic */ c.b yaH;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.a.e yaI;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaT;

        w(PluginGameLife pluginGameLife, com.tencent.mm.ui.widget.a.g gVar, com.tencent.mm.plugin.appbrand.ac.i iVar, com.tencent.mm.plugin.appbrand.ac.i iVar2, String str, com.tencent.mm.plugin.appbrand.ac.i iVar3, Context context, c.b bVar, com.tencent.mm.plugin.gamelife.a.e eVar, int i2) {
            this.yaC = pluginGameLife;
            this.hIa = gVar;
            this.yaE = iVar;
            this.yaT = iVar2;
            this.jDi = str;
            this.yaD = iVar3;
            this.$context = context;
            this.yaH = bVar;
            this.yaI = eVar;
            this.yaG = i2;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            boolean z;
            AppMethodBeat.i(241224);
            this.hIa.bMo();
            final z.a aVar = new z.a();
            aVar.SYB = false;
            if (this.yaE != null) {
                T t = this.yaE.value;
                kotlin.g.b.p.g(t, "isAssociateWithWAGame.value");
                if (t.booleanValue()) {
                    T t2 = this.yaT.value;
                    kotlin.g.b.p.g(t2, "dealWaGameAccountTogetherCheckBox.value");
                    if (t2.booleanValue()) {
                        z = true;
                        aVar.SYB = z;
                    }
                }
                z = false;
                aVar.SYB = z;
            } else {
                Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList isAssociateWithWAGame null");
            }
            ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(this.jDi, false, aVar.SYB, new b.AbstractC1411b(this) {
                /* class com.tencent.mm.plugin.gamelife.PluginGameLife.w.AnonymousClass1 */
                final /* synthetic */ w yaU;

                {
                    this.yaU = r1;
                }

                @Override // com.tencent.mm.plugin.gamelife.a.b.AbstractC1411b
                public final void mM(boolean z) {
                    AppMethodBeat.i(241223);
                    Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b", this.yaU.jDi, Boolean.valueOf(z), Boolean.valueOf(aVar.SYB));
                    if (z) {
                        this.yaU.yaD.value = (T) Boolean.valueOf(!this.yaU.yaD.value.booleanValue());
                    } else {
                        Toast.makeText(this.yaU.$context, (int) R.string.dtq, 0).show();
                    }
                    c.b bVar = this.yaU.yaH;
                    T t = this.yaU.yaD.value;
                    kotlin.g.b.p.g(t, "isBlackList.value");
                    bVar.mM(t.booleanValue());
                    AppMethodBeat.o(241223);
                }
            });
            PluginGameLife pluginGameLife = this.yaC;
            String sessionId = this.yaI.getSessionId();
            kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
            String selfUsername = this.yaI.getSelfUsername();
            kotlin.g.b.p.g(selfUsername, "sessionInfo.selfUsername");
            String ajO = this.yaI.ajO();
            kotlin.g.b.p.g(ajO, "sessionInfo.talker");
            PluginGameLife.access$reportSingleChatInfoUIDetail(pluginGameLife, 7, 64, sessionId, selfUsername, ajO, Boolean.valueOf(aVar.SYB), Integer.valueOf(this.yaG), this.yaE.value);
            AppMethodBeat.o(241224);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class x implements g.a {
        final /* synthetic */ com.tencent.mm.ui.widget.a.g hIa;
        final /* synthetic */ PluginGameLife yaC;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaD;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaE;
        final /* synthetic */ int yaG;
        final /* synthetic */ c.b yaH;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.a.e yaI;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaT;

        x(PluginGameLife pluginGameLife, com.tencent.mm.ui.widget.a.g gVar, c.b bVar, com.tencent.mm.plugin.appbrand.ac.i iVar, com.tencent.mm.plugin.appbrand.ac.i iVar2, com.tencent.mm.plugin.appbrand.ac.i iVar3, com.tencent.mm.plugin.gamelife.a.e eVar, int i2) {
            this.yaC = pluginGameLife;
            this.hIa = gVar;
            this.yaH = bVar;
            this.yaD = iVar;
            this.yaE = iVar2;
            this.yaT = iVar3;
            this.yaI = eVar;
            this.yaG = i2;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            boolean z;
            boolean z2;
            AppMethodBeat.i(241225);
            this.hIa.bMo();
            c.b bVar = this.yaH;
            if (bVar != null) {
                T t = this.yaD.value;
                kotlin.g.b.p.g(t, "isBlackList.value");
                bVar.mM(t.booleanValue());
            }
            if (this.yaE != null) {
                T t2 = this.yaE.value;
                kotlin.g.b.p.g(t2, "isAssociateWithWAGame.value");
                if (t2.booleanValue()) {
                    T t3 = this.yaT.value;
                    kotlin.g.b.p.g(t3, "dealWaGameAccountTogetherCheckBox.value");
                    if (t3.booleanValue()) {
                        z2 = true;
                        z = z2;
                    }
                }
                z2 = false;
                z = z2;
            } else {
                Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
                z = false;
            }
            PluginGameLife pluginGameLife = this.yaC;
            String sessionId = this.yaI.getSessionId();
            kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
            String selfUsername = this.yaI.getSelfUsername();
            kotlin.g.b.p.g(selfUsername, "sessionInfo.selfUsername");
            String ajO = this.yaI.ajO();
            kotlin.g.b.p.g(ajO, "sessionInfo.talker");
            PluginGameLife.access$reportSingleChatInfoUIDetail(pluginGameLife, 6, 4, sessionId, selfUsername, ajO, Boolean.valueOf(z), Integer.valueOf(this.yaG), this.yaE.value);
            AppMethodBeat.o(241225);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class y implements g.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.ui.widget.a.g hIa;
        final /* synthetic */ String jDi;
        final /* synthetic */ PluginGameLife yaC;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaD;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaE;
        final /* synthetic */ int yaG;
        final /* synthetic */ c.b yaH;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.a.e yaI;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.ac.i yaT;

        y(PluginGameLife pluginGameLife, com.tencent.mm.ui.widget.a.g gVar, com.tencent.mm.plugin.appbrand.ac.i iVar, com.tencent.mm.plugin.appbrand.ac.i iVar2, String str, com.tencent.mm.plugin.appbrand.ac.i iVar3, Context context, c.b bVar, com.tencent.mm.plugin.gamelife.a.e eVar, int i2) {
            this.yaC = pluginGameLife;
            this.hIa = gVar;
            this.yaE = iVar;
            this.yaT = iVar2;
            this.jDi = str;
            this.yaD = iVar3;
            this.$context = context;
            this.yaH = bVar;
            this.yaI = eVar;
            this.yaG = i2;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            boolean z;
            AppMethodBeat.i(241227);
            this.hIa.bMo();
            final z.a aVar = new z.a();
            aVar.SYB = false;
            if (this.yaE != null) {
                T t = this.yaE.value;
                kotlin.g.b.p.g(t, "isAssociateWithWAGame.value");
                if (t.booleanValue()) {
                    T t2 = this.yaT.value;
                    kotlin.g.b.p.g(t2, "dealWaGameAccountTogetherCheckBox.value");
                    if (t2.booleanValue()) {
                        z = true;
                        aVar.SYB = z;
                    }
                }
                z = false;
                aVar.SYB = z;
            } else {
                Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null");
            }
            ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(this.jDi, true, aVar.SYB, new b.AbstractC1411b(this) {
                /* class com.tencent.mm.plugin.gamelife.PluginGameLife.y.AnonymousClass1 */
                final /* synthetic */ y yaW;

                {
                    this.yaW = r1;
                }

                @Override // com.tencent.mm.plugin.gamelife.a.b.AbstractC1411b
                public final void mM(boolean z) {
                    AppMethodBeat.i(241226);
                    Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b ", this.yaW.jDi, Boolean.valueOf(z), Boolean.valueOf(aVar.SYB));
                    if (z) {
                        this.yaW.yaD.value = (T) Boolean.valueOf(!this.yaW.yaD.value.booleanValue());
                    } else {
                        Toast.makeText(this.yaW.$context, (int) R.string.dtg, 0).show();
                    }
                    c.b bVar = this.yaW.yaH;
                    T t = this.yaW.yaD.value;
                    kotlin.g.b.p.g(t, "isBlackList.value");
                    bVar.mM(t.booleanValue());
                    AppMethodBeat.o(241226);
                }
            });
            PluginGameLife pluginGameLife = this.yaC;
            String sessionId = this.yaI.getSessionId();
            kotlin.g.b.p.g(sessionId, "sessionInfo.sessionId");
            String selfUsername = this.yaI.getSelfUsername();
            kotlin.g.b.p.g(selfUsername, "sessionInfo.selfUsername");
            String ajO = this.yaI.ajO();
            kotlin.g.b.p.g(ajO, "sessionInfo.talker");
            PluginGameLife.access$reportSingleChatInfoUIDetail(pluginGameLife, 6, 65, sessionId, selfUsername, ajO, Boolean.valueOf(aVar.SYB), Integer.valueOf(this.yaG), this.yaE.value);
            AppMethodBeat.o(241227);
        }
    }

    static /* synthetic */ void reportSingleChatInfoUIDetail$default(PluginGameLife pluginGameLife, int i2, long j2, String str, String str2, String str3, Boolean bool, Integer num, Boolean bool2, int i3, Object obj) {
        AppMethodBeat.i(241259);
        pluginGameLife.reportSingleChatInfoUIDetail(i2, j2, str, str2, str3, (i3 & 32) != 0 ? null : bool, (i3 & 64) != 0 ? null : num, (i3 & 128) != 0 ? null : bool2);
        AppMethodBeat.o(241259);
    }

    private final void reportSingleChatInfoUIDetail(int i2, long j2, String str, String str2, String str3, Boolean bool, Integer num, Boolean bool2) {
        AppMethodBeat.i(241258);
        com.tencent.mm.co.g.hio().i(new t(str2, str3, num, bool2, bool, i2, j2, str)).hdy();
        AppMethodBeat.o(241258);
    }

    static /* synthetic */ void reportChattingDetail$default(PluginGameLife pluginGameLife, int i2, long j2, String str, String str2, String str3, String str4, int i3, Object obj) {
        AppMethodBeat.i(241261);
        pluginGameLife.reportChattingDetail(i2, j2, str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4);
        AppMethodBeat.o(241261);
    }

    private final void reportChattingDetail(int i2, long j2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(241260);
        com.tencent.mm.co.g.hio().i(new s(str, str2, str3, i2, j2, str4)).hdy();
        AppMethodBeat.o(241260);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class f implements h.b {
        public static final f yau = new f();

        static {
            AppMethodBeat.i(241198);
            AppMethodBeat.o(241198);
        }

        f() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241197);
            c.a aVar = com.tencent.mm.plugin.gamelife.d.c.ybR;
            String[] dax = com.tencent.mm.plugin.gamelife.d.c.dax();
            AppMethodBeat.o(241197);
            return dax;
        }
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(241262);
        HashMap<Integer, h.b> g2 = kotlin.a.ae.g(kotlin.s.U(Integer.valueOf("GameLifeContact".hashCode()), f.yau), kotlin.s.U(Integer.valueOf("GameLifeSessionInfo".hashCode()), g.yav), kotlin.s.U(Integer.valueOf("GameLifeConversation".hashCode()), h.yax), kotlin.s.U(Integer.valueOf("gamelifemessage".hashCode()), i.yay), kotlin.s.U(Integer.valueOf("AppMessage".hashCode()), j.yaz));
        AppMethodBeat.o(241262);
        return g2;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class g implements h.b {
        public static final g yav = new g();

        static {
            AppMethodBeat.i(241200);
            AppMethodBeat.o(241200);
        }

        g() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241199);
            c.a aVar = com.tencent.mm.plugin.gamelife.j.c.ycx;
            String[] dax = com.tencent.mm.plugin.gamelife.j.c.dax();
            AppMethodBeat.o(241199);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class h implements h.b {
        public static final h yax = new h();

        static {
            AppMethodBeat.i(241202);
            AppMethodBeat.o(241202);
        }

        h() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241201);
            e.a aVar = com.tencent.mm.plugin.gamelife.e.e.ycb;
            String[] dax = com.tencent.mm.plugin.gamelife.e.e.dax();
            AppMethodBeat.o(241201);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class i implements h.b {
        public static final i yay = new i();

        static {
            AppMethodBeat.i(241204);
            AppMethodBeat.o(241204);
        }

        i() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241203);
            d.a aVar = com.tencent.mm.plugin.gamelife.g.d.yck;
            String[] dax = com.tencent.mm.plugin.gamelife.g.d.dax();
            AppMethodBeat.o(241203);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class j implements h.b {
        public static final j yaz = new j();

        static {
            AppMethodBeat.i(241206);
            AppMethodBeat.o(241206);
        }

        j() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241205);
            c.a aVar = com.tencent.mm.plugin.gamelife.g.c.ycj;
            String[] dax = com.tencent.mm.plugin.gamelife.g.c.dax();
            AppMethodBeat.o(241205);
            return dax;
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(241263);
        ((com.tencent.mm.plugin.byp.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(3);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aST().b(getConversationUpdateCallback());
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().b(getContactService().ybG);
        af.a.b(getGetContactInterceptor());
        com.tencent.mm.plugin.r.a.eAT().b(getAppMessageInterceptor());
        ((com.tencent.mm.plugin.gamelife.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.xWT);
        resetDB();
        AppMethodBeat.o(241263);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void dependency() {
        AppMethodBeat.i(241264);
        super.dependency();
        dependsOn(com.tencent.mm.plugin.byp.a.c.class);
        AppMethodBeat.o(241264);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class z implements MStorage.IOnStorageChange {
        final /* synthetic */ PluginGameLife yaC;

        z(PluginGameLife pluginGameLife) {
            this.yaC = pluginGameLife;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(241229);
            if (mStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a) {
                com.tencent.f.h.RTc.b(new Runnable(this) {
                    /* class com.tencent.mm.plugin.gamelife.PluginGameLife.z.AnonymousClass1 */
                    final /* synthetic */ z yaX;

                    {
                        this.yaX = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(241228);
                        PluginGameLife.access$reportGameChatUnreadState(this.yaX.yaC);
                        AppMethodBeat.o(241228);
                    }
                }, "reportGameChatUnreadState");
            }
            AppMethodBeat.o(241229);
        }
    }

    private final synchronized void reportGameChatUnreadState() {
        Boolean bool;
        PluginGameLife pluginGameLife;
        boolean z2;
        AppMethodBeat.i(241265);
        if (this.yal == null) {
            Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GAME_CHAT_UNREAD_MSG_STATE_BOOLEAN_SYNC, Boolean.FALSE);
            if (obj == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(241265);
                throw tVar;
            }
            this.yal = (Boolean) obj;
        }
        Boolean bool2 = this.yal;
        if (bool2 != null) {
            boolean booleanValue = bool2.booleanValue();
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IGameLi…ationService::class.java)");
            int dWZ = ((com.tencent.mm.plugin.gamelife.a.c) af).dWZ();
            if ((dWZ <= 0 || booleanValue) && (dWZ != 0 || !booleanValue)) {
                z2 = booleanValue;
            } else {
                z2 = dWZ > 0;
                Log.i("GameLife.PluginGameLife", "the state of game chat has changed, gameChatUnreadState:%b", Boolean.valueOf(z2));
                com.tencent.mm.game.report.d.a aVar = com.tencent.mm.game.report.d.a.hit;
                com.tencent.mm.game.report.d.a.ek(z2);
            }
            bool = Boolean.valueOf(z2);
            pluginGameLife = this;
        } else {
            bool = null;
            pluginGameLife = this;
        }
        pluginGameLife.yal = bool;
        AppMethodBeat.o(241265);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.e.g> {
        public static final l yaB = new l();

        static {
            AppMethodBeat.i(241210);
            AppMethodBeat.o(241210);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.gamelife.e.g invoke() {
            AppMethodBeat.i(241209);
            com.tencent.mm.plugin.gamelife.e.g gVar = new com.tencent.mm.plugin.gamelife.e.g();
            AppMethodBeat.o(241209);
            return gVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.d.b> {
        public static final k yaA = new k();

        static {
            AppMethodBeat.i(241208);
            AppMethodBeat.o(241208);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.gamelife.d.b invoke() {
            AppMethodBeat.i(241207);
            com.tencent.mm.plugin.gamelife.d.b bVar = new com.tencent.mm.plugin.gamelife.d.b();
            AppMethodBeat.o(241207);
            return bVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.d.d> {
        public static final p yaK = new p();

        static {
            AppMethodBeat.i(241216);
            AppMethodBeat.o(241216);
        }

        p() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.gamelife.d.d invoke() {
            AppMethodBeat.i(241215);
            com.tencent.mm.plugin.gamelife.d.d dVar = new com.tencent.mm.plugin.gamelife.d.d();
            AppMethodBeat.o(241215);
            return dVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.g.b> {
        public static final b yap = new b();

        static {
            AppMethodBeat.i(241193);
            AppMethodBeat.o(241193);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.gamelife.g.b invoke() {
            AppMethodBeat.i(241192);
            com.tencent.mm.plugin.gamelife.g.b bVar = new com.tencent.mm.plugin.gamelife.g.b();
            AppMethodBeat.o(241192);
            return bVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    public static final class t<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String $sessionId;
        final /* synthetic */ int prP;
        final /* synthetic */ String vdJ;
        final /* synthetic */ String yaN;
        final /* synthetic */ long yaO;
        final /* synthetic */ Integer yaQ;
        final /* synthetic */ Boolean yaR;
        final /* synthetic */ Boolean yaS;

        t(String str, String str2, Integer num, Boolean bool, Boolean bool2, int i2, long j2, String str3) {
            this.yaN = str;
            this.vdJ = str2;
            this.yaQ = num;
            this.yaR = bool;
            this.yaS = bool2;
            this.prP = i2;
            this.yaO = j2;
            this.$sessionId = str3;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            AppMethodBeat.i(241220);
            com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(this.yaN);
            com.tencent.mm.plugin.gamelife.a.a aAR2 = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(this.vdJ);
            int i2 = 0;
            Integer num = this.yaQ;
            if (num != null && num.intValue() == 1) {
                if (this.yaR != null) {
                    if (!this.yaR.booleanValue()) {
                        i2 = 1;
                        str = "";
                    } else if (this.yaS != null) {
                        if (this.yaS.booleanValue()) {
                            i2 = 3;
                            str = "1";
                        } else {
                            i2 = 1;
                            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                    }
                }
                str = "";
            } else {
                Integer num2 = this.yaQ;
                if (num2 == null) {
                    str = "";
                } else {
                    if (num2.intValue() == 2) {
                        i2 = 2;
                        str = "";
                    }
                    str = "";
                }
            }
            c.a aVar = com.tencent.mm.game.report.c.hhl;
            int i3 = this.prP;
            long j2 = this.yaO;
            String str2 = this.$sessionId;
            kotlin.g.b.p.g(aAR, "selfContact");
            long dWY = (long) aAR.dWY();
            String str3 = this.yaN;
            kotlin.g.b.p.g(aAR2, "talkerContact");
            String str4 = this.vdJ;
            Integer valueOf = Integer.valueOf(i2);
            kotlin.g.b.p.h(str2, "sessionId");
            kotlin.g.b.p.h(str3, "fromUsername");
            kotlin.g.b.p.h(str4, "toUsername");
            eq a2 = c.a.a(4, 401, (long) i3, j2, 401);
            a2.rP(str2);
            a2.mX(dWY);
            a2.rN(str3);
            a2.mY((long) aAR2.dWY());
            a2.rO(str4);
            a2.rM(str);
            if (!(valueOf == null || valueOf.intValue() == 0)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("role", valueOf.intValue());
                a2.rQ(URLEncoder.encode(jSONObject.toString()));
            }
            a2.bfK();
            AppMethodBeat.o(241220);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    public static final class s<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String $sessionId;
        final /* synthetic */ int prP;
        final /* synthetic */ String vdJ;
        final /* synthetic */ String yaN;
        final /* synthetic */ long yaO;
        final /* synthetic */ String yaP;

        s(String str, String str2, String str3, int i2, long j2, String str4) {
            this.yaN = str;
            this.$sessionId = str2;
            this.vdJ = str3;
            this.prP = i2;
            this.yaO = j2;
            this.yaP = str4;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(241219);
            com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(this.yaN);
            if (this.$sessionId == null || this.vdJ == null) {
                c.a aVar = com.tencent.mm.game.report.c.hhl;
                int i2 = this.prP;
                long j2 = this.yaO;
                kotlin.g.b.p.g(aAR, "selfContact");
                c.a.a(i2, j2, "", (long) aAR.dWY(), this.yaN, 0, "", this.yaP);
            } else {
                com.tencent.mm.plugin.gamelife.a.a aAR2 = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(this.vdJ);
                if (aAR2 != null) {
                    c.a aVar2 = com.tencent.mm.game.report.c.hhl;
                    int i3 = this.prP;
                    long j3 = this.yaO;
                    String str = this.$sessionId;
                    kotlin.g.b.p.g(aAR, "selfContact");
                    c.a.a(i3, j3, str, (long) aAR.dWY(), this.yaN, (long) aAR2.dWY(), this.vdJ, this.yaP);
                }
            }
            AppMethodBeat.o(241219);
            return null;
        }
    }
}
