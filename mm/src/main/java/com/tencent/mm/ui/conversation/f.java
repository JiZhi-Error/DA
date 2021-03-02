package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.q;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.i;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import junit.framework.Assert;

public final class f implements AdapterView.OnItemClickListener {
    private ListView Qbd;
    private i Qct;
    private Activity activity;

    public f(i iVar, ListView listView, Activity activity2) {
        this.Qct = iVar;
        this.Qbd = listView;
        this.activity = activity2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        az azVar;
        boolean z;
        Object obj;
        byte[] decodeBytes;
        AppMethodBeat.i(38324);
        if (i2 < this.Qbd.getHeaderViewsCount()) {
            AppMethodBeat.o(38324);
            return;
        }
        int headerViewsCount = i2 - this.Qbd.getHeaderViewsCount();
        try {
            azVar = (az) this.Qct.getItem(headerViewsCount);
        } catch (IllegalStateException e2) {
            Log.printErrStackTrace("MicroMsg.ConversationClickListener", e2, "", new Object[0]);
            azVar = null;
        }
        if (azVar == null) {
            Log.e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(headerViewsCount)));
            AppMethodBeat.o(38324);
            return;
        }
        if (view.getTag() instanceof i.f) {
            Log.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", Integer.valueOf(headerViewsCount), azVar.field_username, ((i.f) view.getTag()).username);
        }
        if (azVar.oV(TPMediaCodecProfileLevel.HEVCMainTierLevel62)) {
            azVar.oU(TPMediaCodecProfileLevel.HEVCMainTierLevel62);
            bg.aVF();
            c.aST().a(azVar, azVar.field_username);
        }
        if (azVar.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel62)) {
            azVar.oU(TPMediaCodecProfileLevel.HEVCHighTierLevel62);
            bg.aVF();
            c.aST().a(azVar, azVar.field_username);
        }
        if (azVar.oV(134217728)) {
            azVar.oU(134217728);
            bg.aVF();
            c.aST().a(azVar, azVar.field_username);
        }
        if (ab.IY(azVar.field_username)) {
            if (z.aUv()) {
                com.tencent.mm.br.c.V(this.activity, "tmessage", ".ui.TConversationUI");
            } else {
                com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
            }
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        } else if (ab.IZ(azVar.field_username)) {
            if (z.aUu()) {
                com.tencent.mm.br.c.V(this.activity, "bottle", ".ui.BottleConversationUI");
            } else {
                com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
            }
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        } else if (ab.Je(azVar.field_username)) {
            MMAppMgr.cancelNotification(azVar.field_username);
            com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        } else if (ab.IW(azVar.field_username)) {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(view.getContext())) {
                AppMethodBeat.o(38324);
                return;
            } else if (z.aUG()) {
                z = true;
            } else {
                com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                this.Qct.a(view, headerViewsCount, azVar.field_username);
                z = false;
            }
        } else if (ab.Jk(azVar.field_username)) {
            z = false;
        } else if (ab.Jj(azVar.field_username)) {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(view.getContext())) {
                AppMethodBeat.o(38324);
                return;
            }
            if (z.aUA()) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("type", 20);
                com.tencent.mm.br.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
            } else {
                com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
            }
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        } else if (ab.Jr(azVar.field_username)) {
            if (z.aUB()) {
                Intent intent2 = new Intent();
                intent2.addFlags(67108864);
                intent2.putExtra("type", 11);
                com.tencent.mm.br.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent2);
            } else {
                com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
            }
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        } else if (ab.Jb(azVar.field_username)) {
            com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        } else if (ab.Jc(azVar.field_username)) {
            if (z.aUD()) {
                com.tencent.mm.br.c.b(this.activity, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
            } else {
                com.tencent.mm.br.c.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
            }
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        } else if (ab.Jq(azVar.field_username)) {
            if (ay.a.iDt != null) {
                ay.a.iDt.Kl(azVar.field_username);
            }
            z = true;
        } else if (ab.Js(azVar.field_username)) {
            if (!WeChatBrands.Business.Entries.HomeServiceOa.checkAvailable(view.getContext())) {
                AppMethodBeat.o(38324);
                return;
            }
            Log.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", 901, Integer.valueOf(WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener")));
            if (!com.tencent.mm.storage.ab.clc()) {
                Activity activity2 = this.activity;
                a bl = new a().bl(new Intent(this.activity, BizConversationUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(activity2, bl.axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity2, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.Qct.a(view, headerViewsCount, azVar.field_username);
                z = false;
            } else if (((q) g.af(q.class)).Vv()) {
                ((b) g.af(b.class)).hr(this.activity);
                ((q) g.af(q.class)).o(9, azVar.field_username);
                z = false;
            } else {
                com.tencent.mm.storage.ab.AK(true);
                Intent intent3 = new Intent(this.activity, BizTimeLineUI.class);
                intent3.putExtra("KOpenArticleSceneFromScene", 93);
                intent3.putExtra("Main_IndexInSessionList", headerViewsCount);
                intent3.putExtra("Main_UnreadCount", azVar.field_unReadCount);
                Activity activity3 = this.activity;
                a bl2 = new a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(activity3, bl2.axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity3.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity3, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.storage.ab.gAX();
                com.tencent.mm.pluginsdk.c cVar = com.tencent.mm.pluginsdk.c.JSr;
                com.tencent.mm.pluginsdk.c.glP();
                com.tencent.mm.plugin.biz.b.a aVar = com.tencent.mm.plugin.biz.b.a.pfl;
                long decodeLong = com.tencent.mm.plugin.biz.b.a.aTI().decodeLong("BizLastMsgId");
                long decodeLong2 = com.tencent.mm.plugin.biz.b.a.aTI().decodeLong("BizLastMsgTime");
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.al.c.iNQ.getSlot();
                String ahe = com.tencent.mm.plugin.biz.b.a.ahe(new StringBuilder().append(decodeLong).append('-').append(decodeLong2).toString());
                if (multiProcessMMKV.containsKey(ahe) && (decodeBytes = multiProcessMMKV.decodeBytes(ahe)) != null) {
                    if (!(decodeBytes.length == 0)) {
                        try {
                            Object newInstance = ahh.class.newInstance();
                            ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                            obj = (com.tencent.mm.bw.a) newInstance;
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e3, "decode ProtoBuffer", new Object[0]);
                        }
                        com.tencent.mm.plugin.biz.b.a.pfj = (ahh) obj;
                        this.Qct.a(view, headerViewsCount, azVar.field_username);
                        z = false;
                    }
                }
                obj = null;
                com.tencent.mm.plugin.biz.b.a.pfj = (ahh) obj;
                this.Qct.a(view, headerViewsCount, azVar.field_username);
                z = false;
            }
        } else if (!ab.IT(azVar.field_username) || !com.tencent.mm.al.g.Ng(azVar.field_username)) {
            if (!ab.IT(azVar.field_username) || !com.tencent.mm.al.g.DQ(azVar.field_username)) {
                if (ab.JB(azVar.field_username)) {
                    Intent intent4 = new Intent();
                    intent4.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                    intent4.putExtra("Contact_User", azVar.field_username);
                    intent4.putExtra("app_brand_conversation_from_scene", 1);
                    intent4.addFlags(67108864);
                    Activity activity4 = this.activity;
                    a bl3 = new a().bl(intent4);
                    com.tencent.mm.hellhoundlib.a.a.a(activity4, bl3.axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity4.startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity4, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    this.Qct.a(view, headerViewsCount, azVar.field_username);
                    z = false;
                } else if (!ab.Jx(azVar.field_username) || WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(view.getContext())) {
                    z = true;
                } else {
                    AppMethodBeat.o(38324);
                    return;
                }
            } else if (!ab.IS(azVar.field_username)) {
                h.cD(this.activity, this.activity.getString(R.string.bxo));
                AppMethodBeat.o(38324);
                return;
            } else {
                Intent intent5 = new Intent(this.activity, BizChatConversationUI.class);
                intent5.putExtra("Contact_User", azVar.field_username);
                intent5.putExtra("biz_chat_from_scene", 1);
                intent5.addFlags(67108864);
                Activity activity5 = this.activity;
                a bl4 = new a().bl(intent5);
                com.tencent.mm.hellhoundlib.a.a.a(activity5, bl4.axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity5.startActivity((Intent) bl4.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity5, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.Qct.a(view, headerViewsCount, azVar.field_username);
                z = false;
            }
        } else if (!ab.IS(azVar.field_username)) {
            h.cD(this.activity, this.activity.getString(R.string.bxo));
            AppMethodBeat.o(38324);
            return;
        } else {
            Intent intent6 = new Intent(this.activity, EnterpriseConversationUI.class);
            intent6.putExtra("enterprise_biz_name", azVar.field_username);
            intent6.putExtra("enterprise_biz_display_name", aa.getDisplayName(azVar.field_username));
            intent6.putExtra("enterprise_from_scene", 1);
            Activity activity6 = this.activity;
            a bl5 = new a().bl(intent6);
            com.tencent.mm.hellhoundlib.a.a.a(activity6, bl5.axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity6.startActivity((Intent) bl5.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity6, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.Qct.a(view, headerViewsCount, azVar.field_username);
            z = false;
        }
        if (z) {
            if ((as.bjp(azVar.field_username) || ab.Iy(azVar.field_username)) && !WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(view.getContext())) {
                AppMethodBeat.o(38324);
                return;
            } else if (!ab.IJ(azVar.field_username) || WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(view.getContext())) {
                this.Qct.a(view, headerViewsCount, azVar.field_username);
                com.tencent.mm.plugin.report.service.g.Wl(9);
                LauncherUI launcherUI = (LauncherUI) this.activity;
                Assert.assertTrue("Launcher should not be empty.", launcherUI != null);
                Bundle bundle = new Bundle();
                bundle.putInt("specific_chat_from_scene", 7);
                bundle.putInt("KOpenArticleSceneFromScene", 93);
                bundle.putInt("chat_from_scene_for_group_chats", 3);
                bundle.putInt("Main_IndexInSessionList", headerViewsCount);
                bundle.putInt("Main_UnreadCount", azVar.field_unReadCount);
                bundle.putInt("chat_from_scene", 0);
                launcherUI.startChatting(azVar.field_username, bundle, true);
                if (ab.Iy(azVar.field_username)) {
                    gq gqVar = new gq();
                    gqVar.us(azVar.field_username);
                    gqVar.erw = 1;
                    gqVar.bfK();
                }
            } else {
                AppMethodBeat.o(38324);
                return;
            }
        }
        AppMethodBeat.o(38324);
    }
}
