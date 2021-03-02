package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.ui.LoginIndepPass;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.ModRemarkNameUI;
import com.tencent.mm.ui.contact.SnsLabelContactListUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.tools.CountryCodeUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.widget.a.d;

public final class al implements m {
    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Intent intent, Context context) {
        AppMethodBeat.i(19605);
        if (context == null) {
            AppMethodBeat.o(19605);
            return;
        }
        intent.setClassName(context, "com.tencent.mm.ui.contact.SayHiEditUI");
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSayHiEditUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startSayHiEditUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19605);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void b(Intent intent, Context context) {
        AppMethodBeat.i(19606);
        if (context == null) {
            AppMethodBeat.o(19606);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        c.f(context, ".ui.tools.MultiStageCitySelectUI", intent);
        AppMethodBeat.o(19606);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void bX(Context context) {
        AppMethodBeat.i(19607);
        c.b(context, "setting", ".ui.setting.EditSignatureUI", new Intent());
        AppMethodBeat.o(19607);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void c(Intent intent, Context context) {
        AppMethodBeat.i(19608);
        if (context == null) {
            AppMethodBeat.o(19608);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(19608);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void d(Intent intent, Context context) {
        AppMethodBeat.i(19609);
        if (context == null) {
            AppMethodBeat.o(19609);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        String stringExtra = intent.getStringExtra("Contact_User");
        if (stringExtra != null) {
            e.a(intent, stringExtra);
        }
        Log.i("MicroMsg.WorkerUICallbackImpl", "startChattingUI %s %s", stringExtra, Util.getStack().toString());
        intent.setClass(context, ChattingUI.class);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19609);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void e(Intent intent, Context context) {
        AppMethodBeat.i(19610);
        if (context == null) {
            AppMethodBeat.o(19610);
            return;
        }
        Log.i("MicroMsg.WorkerUICallbackImpl with result", "startChattingUI %s", Util.getStack().toString());
        intent.setClass(context, ChattingUI.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 1);
            AppMethodBeat.o(19610);
            return;
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUIForResult", "(Landroid/content/Intent;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUIForResult", "(Landroid/content/Intent;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19610);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void f(Intent intent, Context context) {
        AppMethodBeat.i(19611);
        if (context == null) {
            AppMethodBeat.o(19611);
            return;
        }
        intent.setClass(context, BindMContactIntroUI.class);
        MMWizardActivity.ay(context, intent);
        AppMethodBeat.o(19611);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void g(Intent intent, Context context) {
        AppMethodBeat.i(19612);
        if (context == null) {
            AppMethodBeat.o(19612);
            return;
        }
        intent.setClass(context, BindQQUI.class);
        MMWizardActivity.ay(context, intent);
        AppMethodBeat.o(19612);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void h(Intent intent, Context context) {
        AppMethodBeat.i(19613);
        intent.setClass(context, LauncherUI.class).addFlags(67108864);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startMainUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startMainUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19613);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void i(Intent intent, Context context) {
        AppMethodBeat.i(19614);
        if (context == null) {
            AppMethodBeat.o(19614);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(19614);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void j(Intent intent, Context context) {
        AppMethodBeat.i(19615);
        s.i(context, intent.getBundleExtra("reportArgs"));
        AppMethodBeat.o(19615);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final d bY(Context context) {
        AppMethodBeat.i(19616);
        d bY = MMAppMgr.bY(context);
        AppMethodBeat.o(19616);
        return bY;
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void k(Intent intent, Context context) {
        AppMethodBeat.i(19617);
        if (context != null) {
            if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
                intent.putExtra("Retr_Msg_Type", 4);
            }
            intent.setClass(context, MsgRetransmitUI.class);
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startMsgRetransmitUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startMsgRetransmitUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(19617);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(final Activity activity, final String str, final WXMediaMessage wXMediaMessage, final String str2, final String str3) {
        AppMethodBeat.i(231412);
        String string = activity.getResources().getString(R.string.wv);
        String stringBuffer = new StringBuffer(string).append(wXMediaMessage.title).toString();
        o.a aVar = new o.a(activity);
        aVar.ea(str2).beQ(stringBuffer).aii(R.string.b9_);
        aVar.p(Boolean.TRUE).a(new y.a() {
            /* class com.tencent.mm.app.al.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(19604);
                if (!z) {
                    AppMethodBeat.o(19604);
                    return;
                }
                com.tencent.mm.pluginsdk.model.app.m.a(wXMediaMessage, str, str3, str2, 3, (String) null);
                if (!Util.isNullOrNil(str)) {
                    tw twVar = new tw();
                    twVar.eaq.dkV = str2;
                    twVar.eaq.content = str;
                    twVar.eaq.type = ab.JG(str2);
                    twVar.eaq.flags = 0;
                    EventCenter.instance.publish(twVar);
                }
                h.cD(activity, activity.getResources().getString(R.string.z0));
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10910, "2");
                AppMethodBeat.o(19604);
            }
        }).kdo.show();
        AppMethodBeat.o(231412);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Intent intent, int i2, MMActivity mMActivity) {
        AppMethodBeat.i(231413);
        intent.setClass(mMActivity, SelectConversationUI.class);
        mMActivity.startActivityForResult(intent, i2);
        AppMethodBeat.o(231413);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Intent intent, int i2, MMActivity mMActivity, Intent intent2) {
        AppMethodBeat.i(19621);
        if (intent.getIntExtra("CropImageMode", 0) == 4) {
            intent.setClassName(mMActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
        } else {
            intent.setClass(mMActivity, ImageCropUI.class);
        }
        bg.aVF();
        com.tencent.mm.ui.tools.a.a(mMActivity, intent2, intent, com.tencent.mm.model.c.aSY(), i2);
        AppMethodBeat.o(19621);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Activity activity, Intent intent, int i2) {
        AppMethodBeat.i(19623);
        if (activity != null) {
            int intExtra = intent.getIntExtra("CropImageMode", 0);
            if (intExtra == 4 || intExtra == 2) {
                intent.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            } else {
                intent.setClass(activity, ImageCropUI.class);
            }
            activity.startActivityForResult(intent, i2);
        }
        AppMethodBeat.o(19623);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Activity activity, Intent intent, Intent intent2, String str, int i2, a.AbstractC2129a aVar) {
        AppMethodBeat.i(19624);
        if (activity != null) {
            int intExtra = intent2.getIntExtra("CropImageMode", 0);
            if (intExtra == 4 || intExtra == 2) {
                intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            } else {
                intent2.setClass(activity, ImageCropUI.class);
            }
            com.tencent.mm.ui.tools.a.b(activity, intent, intent2, str, i2, aVar);
        }
        AppMethodBeat.o(19624);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void l(Intent intent, Context context) {
        AppMethodBeat.i(19625);
        if (context != null) {
            intent.setClass(context, ContactRemarkInfoModUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startContactRemarkInfoModUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startContactRemarkInfoModUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(19625);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void m(Intent intent, Context context) {
        AppMethodBeat.i(19626);
        if (context != null) {
            intent.setClass(context, ModRemarkNameUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startRemarkUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startRemarkUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(19626);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Intent intent, Activity activity) {
        AppMethodBeat.i(19627);
        intent.setClass(activity, ModRemarkNameUI.class);
        activity.startActivityForResult(intent, 2);
        AppMethodBeat.o(19627);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void b(Intent intent, Activity activity) {
        AppMethodBeat.i(19628);
        if (activity != null) {
            intent.setClass(activity, CountryCodeUI.class);
            activity.startActivityForResult(intent, 100);
        }
        AppMethodBeat.o(19628);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void n(Intent intent, Context context) {
        AppMethodBeat.i(19629);
        if (context != null) {
            c.b(context, "setting", ".ui.setting.SettingsLanguageUI", intent);
        }
        AppMethodBeat.o(19629);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void o(Intent intent, Context context) {
        AppMethodBeat.i(19630);
        if (!(intent == null || context == null)) {
            intent.setClass(context, LauncherUI.class).addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startLauncherUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startLauncherUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(19630);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final Intent bZ(Context context) {
        AppMethodBeat.i(19631);
        Intent addFlags = new Intent(context, LauncherUI.class).addFlags(67108864);
        AppMethodBeat.o(19631);
        return addFlags;
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void ca(Context context) {
        AppMethodBeat.i(19632);
        c.b(context, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
        AppMethodBeat.o(19632);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Intent intent, MMActivity.a aVar, MMActivity mMActivity) {
        AppMethodBeat.i(19633);
        if (mMActivity != null) {
            intent.setClass(mMActivity, SelectConversationUI.class);
            mMActivity.mmStartActivityForResult(aVar, intent, 0);
        }
        AppMethodBeat.o(19633);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void p(Intent intent, Context context) {
        AppMethodBeat.i(19634);
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        c.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
        AppMethodBeat.o(19634);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void q(Intent intent, Context context) {
        AppMethodBeat.i(19635);
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        g.il(context);
        AppMethodBeat.o(19635);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void r(Intent intent, Context context) {
        AppMethodBeat.i(19636);
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            c.b(context, "subapp", ".ui.pluginapp.ContactSearchUI", intent2);
        }
        AppMethodBeat.o(19636);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void s(Intent intent, Context context) {
        AppMethodBeat.i(19637);
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            c.b(context, "subapp", ".ui.pluginapp.ContactSearchResultUI", intent2);
        }
        AppMethodBeat.o(19637);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Intent intent, Activity activity, int i2) {
        AppMethodBeat.i(19638);
        if (activity != null) {
            intent.setClassName(activity, "com.tencent.mm.ui.contact.SnsAddressUI");
            activity.startActivityForResult(intent, i2);
        }
        AppMethodBeat.o(19638);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void t(Intent intent, Context context) {
        AppMethodBeat.i(19639);
        intent.setClass(context, SnsLabelContactListUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSnsLabelContactUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startSnsLabelContactUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19639);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(boolean z, boolean z2, Context context, String str, int i2, int i3) {
        AppMethodBeat.i(19640);
        if (!z && !z2) {
            Intent intent = new Intent();
            intent.putExtra("VideoPlayer_File_nam", str);
            intent.putExtra("VideoRecorder_VideoLength", i2);
            intent.putExtra("VideoRecorder_VideoSize", i3);
            c.b(context, "subapp", ".ui.video.VideoPlayerUI", intent);
        } else if (!com.tencent.mm.pluginsdk.k.b.a.a.b(str, context, z2)) {
            Toast.makeText(context, context.getString(R.string.hxf), 0).show();
            AppMethodBeat.o(19640);
            return;
        }
        AppMethodBeat.o(19640);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void cb(Context context) {
        AppMethodBeat.i(19641);
        c.b(context, "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(19641);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void d(Context context, Intent intent) {
        AppMethodBeat.i(19642);
        if (context != null) {
            intent.setClass(context, ShowImageUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startShowImageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startShowImageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(19642);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void e(Context context, Intent intent) {
        AppMethodBeat.i(19643);
        if (context == null) {
            AppMethodBeat.o(19643);
            return;
        }
        c.b(context, "account", ".security.ui.MySafeDeviceListUI", intent);
        AppMethodBeat.o(19643);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(MMWizardActivity mMWizardActivity, Intent intent) {
        AppMethodBeat.i(19644);
        if (mMWizardActivity == null) {
            AppMethodBeat.o(19644);
            return;
        }
        intent.setClass(mMWizardActivity, MobileInputUI.class);
        MMWizardActivity.ay(mMWizardActivity, intent);
        AppMethodBeat.o(19644);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void f(Context context, Intent intent) {
        AppMethodBeat.i(19645);
        if (context == null) {
            AppMethodBeat.o(19645);
            return;
        }
        intent.setClass(context, RegByMobileVoiceVerifyUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startRegByMobileVoiceVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startRegByMobileVoiceVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19645);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Context context, Intent intent, Intent intent2) {
        AppMethodBeat.i(19646);
        int intExtra = intent.getIntExtra("from_source", 1);
        if (intExtra == 1) {
            intent.setClass(context, LoginUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(19646);
        } else if (intExtra == 2) {
            intent.setClass(context, LoginPasswordUI.class);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(19646);
        } else if (intExtra == 3) {
            intent.setClass(context, SimpleLoginUI.class);
            if (intent2 != null) {
                MMWizardActivity.b(context, intent, intent2);
                AppMethodBeat.o(19646);
                return;
            }
            MMWizardActivity.ay(context, intent);
            AppMethodBeat.o(19646);
        } else if (intExtra == 5) {
            intent.setClass(context, LoginIndepPass.class);
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(19646);
        } else {
            if (intExtra == 6) {
                intent.setClass(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("mobile_auth_type", 7);
                com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl4.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl4.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(19646);
        }
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void g(Context context, Intent intent) {
        AppMethodBeat.i(19647);
        if (context == null) {
            AppMethodBeat.o(19647);
            return;
        }
        c.a(context, "account", ".security.ui.SecurityAccountIntroUI", intent);
        AppMethodBeat.o(19647);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void h(Context context, Intent intent) {
        AppMethodBeat.i(19648);
        intent.setClassName(context, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSelectSpecialContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/WorkerUICallbackImpl", "startSelectSpecialContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19648);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Intent intent, int i2, MMActivity.a aVar, MMActivity mMActivity) {
        AppMethodBeat.i(19650);
        if (mMActivity != null) {
            intent.setClassName(mMActivity, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
            mMActivity.mmStartActivityForResult(aVar, intent, i2);
        }
        AppMethodBeat.o(19650);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void Xc() {
        AppMethodBeat.i(19651);
        MMAppMgr.Xc();
        AppMethodBeat.o(19651);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void a(Context context, String str, String str2, boolean z, y.a aVar) {
        AppMethodBeat.i(19654);
        o.a aVar2 = new o.a(context);
        aVar2.ea(str).beS(str2).p(Boolean.FALSE).aii(R.string.yq);
        if (z) {
            aVar2.beP(context.getResources().getString(R.string.h5x));
        } else {
            aVar2.beP(context.getResources().getString(R.string.h5y));
        }
        aVar2.a(aVar).kdo.show();
        AppMethodBeat.o(19654);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final boolean b(Context context, String str, Bundle bundle) {
        AppMethodBeat.i(19622);
        boolean a2 = q.a.JSZ.a(context, str, false, bundle);
        AppMethodBeat.o(19622);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final boolean a(Context context, String str, Object... objArr) {
        AppMethodBeat.i(19649);
        boolean b2 = q.a.JSZ.b(context, str, objArr);
        AppMethodBeat.o(19649);
        return b2;
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void cancelNotification(String str) {
        AppMethodBeat.i(19652);
        g.a.ali();
        if (str != null) {
            int id = b.alj().getId(str);
            Log.d("MicroMsg.Notification.Handle", "cancel : %s", str);
            b.alj().cancel(id);
        }
        AppMethodBeat.o(19652);
    }

    @Override // com.tencent.mm.pluginsdk.m
    public final void t(Context context, String str) {
        AppMethodBeat.i(19653);
        q.a.JSZ.a(context, str, true);
        AppMethodBeat.o(19653);
    }
}
