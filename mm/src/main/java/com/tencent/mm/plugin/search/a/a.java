package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public final class a {
    public static final SparseArray<C1684a> CVG;

    static {
        AppMethodBeat.i(28069);
        SparseArray<C1684a> sparseArray = new SparseArray<>();
        CVG = sparseArray;
        sparseArray.put(19, new C1684a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
        CVG.put(30, new C1684a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte) 0));
        CVG.put(18, new C1684a(18, -1, ".ui.ShakeReportUI", "shake", ""));
        CVG.put(17, new C1684a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
        CVG.put(16, new C1684a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
        CVG.put(31, new C1684a(31, -1, ".ui.GameCenterUI", "game", ""));
        CVG.put(20, new C1684a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
        CVG.put(21, new C1684a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
        CVG.put(26, new C1684a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
        CVG.put(29, new C1684a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
        CVG.put(23, new C1684a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
        if (((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true)) {
            CVG.put(1, new C1684a(1, -1, ".ui.MallIndexUIv2", "mall", ""));
        } else {
            CVG.put(1, new C1684a(1, -1, ".ui.MallIndexUI", "mall", ""));
        }
        CVG.put(24, new C1684a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
        CVG.put(27, new C1684a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
        CVG.put(28, new C1684a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
        CVG.put(32, new C1684a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
        CVG.put(33, new C1684a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
        if (((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true)) {
            CVG.put(34, new C1684a(34, -1, ".ui.MallIndexUIv2", "mall", ""));
        } else {
            CVG.put(34, new C1684a(34, -1, ".ui.MallIndexUI", "mall", ""));
        }
        CVG.put(35, new C1684a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
        CVG.put(38, new C1684a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
        CVG.put(39, new C1684a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
        CVG.put(6, new C1684a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
        CVG.put(41, new C1684a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
        CVG.put(42, new C1684a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
        CVG.put(40, new C1684a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
        CVG.put(43, new C1684a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
        CVG.put(50, new C1684a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
        CVG.put(51, new C1684a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
        CVG.put(66, new C1684a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
        CVG.put(63, new C1684a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
        CVG.put(64, new C1684a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
        CVG.put(65, new C1684a(65, -1, "", "", ""));
        CVG.put(67, new C1684a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
        CVG.put(68, new C1684a(68, -1, ".ui.chatting.ChattingUI", "", "gh_3dfda90e39d6"));
        CVG.put(69, new C1684a(69, -1, ".ui.conversation.AppBrandServiceConversationUI", "app", ""));
        CVG.put(70, new C1684a(70, -1, ".ui.chatting.ChattingUI", "", "gh_f0a92aa7146c"));
        CVG.put(71, new C1684a(71, -1, ".ui.chatting.ChattingUI", "", "appbrand_notify_message"));
        if (1 == ((b) g.af(b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0)) {
            CVG.put(72, new C1684a(72, -1, ".ui.chatting.ChattingUI", "", "gh_579db1f2cf89"));
        }
        AppMethodBeat.o(28069);
    }

    private static boolean bw(Context context, String str) {
        AppMethodBeat.i(28067);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(28067);
        return true;
    }

    public static boolean an(Context context, int i2) {
        bw aST;
        int i3;
        AppMethodBeat.i(28068);
        if (CVG.indexOfKey(i2) < 0) {
            AppMethodBeat.o(28068);
            return false;
        } else if (i2 != 30 || (!com.tencent.mm.q.a.o(context, true) && !com.tencent.mm.q.a.cA(context) && !com.tencent.mm.q.a.cE(context))) {
            C1684a aVar = CVG.get(i2);
            if (ab.IJ(aVar.username) && !WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (ab.IK(aVar.username) && !WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 41 && !WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 42 && !WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 31 && !WeChatBrands.Business.Entries.DiscoveryGame.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 18 && !WeChatBrands.Business.Entries.DiscoveryShake.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 65 && !WeChatBrands.Business.Entries.DiscoveryLooks.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 17 && !WeChatBrands.Business.Entries.DiscoveryNearby.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if ((i2 == 50 || i2 == 63 || i2 == 67) && !WeChatBrands.Business.Entries.HomeServiceOa.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 28 && !WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(context)) {
                AppMethodBeat.o(28068);
                return true;
            } else if (aVar.CVH != -1 && (z.aUl() & aVar.CVH) != 0) {
                boolean bw = bw(context, aVar.username);
                AppMethodBeat.o(28068);
                return bw;
            } else if (!Util.isNullOrNil(aVar.wJd)) {
                Intent intent = new Intent();
                if (i2 == 28) {
                    intent.putExtra("type", 20);
                }
                if (i2 == 1) {
                    intent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
                }
                intent.putExtra("animation_pop_in", aVar.CVI);
                if (i2 == 32) {
                    h.INSTANCE.a(12065, 6);
                }
                if (i2 == 6) {
                    intent.putExtra("pay_channel", 15);
                }
                if (i2 == 31) {
                    intent.putExtra("game_report_from_scene", 4);
                }
                if (i2 == 41) {
                    intent.putExtra("key_from_scene", 5);
                }
                if (i2 == 42) {
                    intent.putExtra("key_from_scene", 4);
                }
                if (i2 == 64) {
                    intent.putExtra("entry_fix_tools", 1);
                }
                if (i2 == 63 || i2 == 67) {
                    intent.putExtra("biz_enter_source", 2);
                }
                if (i2 == 69) {
                    intent.putExtra("Contact_User", "appbrandcustomerservicemsg");
                    intent.putExtra("app_brand_conversation_from_scene", 4);
                    intent.addFlags(67108864);
                }
                if (i2 == 33) {
                    com.tencent.mm.plugin.fav.a.b.b(context, ".ui.FavoriteIndexUI", new Intent());
                } else if (i2 == 35) {
                    intent.setClassName(context, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
                    MMWizardActivity.ay(context, intent);
                } else if (i2 == 66) {
                    ((t) g.af(t.class)).K(context, 16);
                } else if (!aVar.wJd.equals("app")) {
                    c.b(context, aVar.wJd, aVar.uri, intent);
                } else {
                    c.f(context, aVar.uri, intent);
                }
                com.tencent.mm.ui.base.b.az(context, intent);
                AppMethodBeat.o(28068);
                return true;
            } else if (i2 == 65) {
                com.tencent.mm.plugin.topstory.ui.c.as(context, 21);
                AppMethodBeat.o(28068);
                return true;
            } else {
                if (i2 == 71 && (aST = ((l) g.af(l.class)).aST()) != null) {
                    List<String> gCw = aST.gCw();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= gCw.size()) {
                            i4 = 0;
                            break;
                        } else if ("appbrand_notify_message".equals(gCw.get(i4))) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    az bjY = aST.bjY("appbrand_notify_message");
                    if (bjY != null) {
                        i3 = bjY.field_unReadCount;
                    } else {
                        i3 = 0;
                    }
                    com.tencent.mm.plugin.appbrand.service.g gVar = (com.tencent.mm.plugin.appbrand.service.g) g.af(com.tencent.mm.plugin.appbrand.service.g.class);
                    g.aAf();
                    gVar.UF(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
                    gVar.a(new g.a(i3, i4 + 1));
                }
                if (aVar.uri.equals(".ui.chatting.ChattingUI")) {
                    String str = aVar.username;
                    if (com.tencent.mm.contact.c.oR(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str).field_type)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", str);
                        intent2.putExtra("finish_direct", true);
                        intent2.putExtra("chat_from_scene", 5);
                        c.f(context, ".ui.chatting.ChattingUI", intent2);
                    } else {
                        bw(context, str);
                    }
                    AppMethodBeat.o(28068);
                    return true;
                } else if (aVar.uri.equals(".plugin.profile.ui.ContactInfoUI")) {
                    boolean bw2 = bw(context, aVar.username);
                    AppMethodBeat.o(28068);
                    return bw2;
                } else {
                    Log.e("MicroMsg.Feature", "Error URI of android feature");
                    AppMethodBeat.o(28068);
                    return false;
                }
            }
        } else {
            AppMethodBeat.o(28068);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.search.a.a$a  reason: collision with other inner class name */
    static class C1684a {
        int CVH;
        boolean CVI;
        int id;
        String uri;
        String username;
        String wJd;

        public C1684a(int i2, int i3, String str, String str2, String str3) {
            this(i2, i3, str, str2, str3, (byte) 0);
        }

        public C1684a(int i2, int i3, String str, String str2, String str3, byte b2) {
            this.id = i2;
            this.CVH = i3;
            this.uri = str;
            this.wJd = str2;
            this.username = str3;
        }
    }
}
