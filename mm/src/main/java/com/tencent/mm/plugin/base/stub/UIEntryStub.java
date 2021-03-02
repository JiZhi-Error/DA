package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.network.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.at;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

@a(7)
public class UIEntryStub extends HellActivity {
    private String LG;
    private Intent dRc;
    private boolean pdv;
    private int sdkVersion;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22185);
        super.onCreate(bundle);
        NotifyReceiver.akF();
        this.pdv = false;
        AppMethodBeat.o(22185);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(22186);
        super.onNewIntent(intent);
        this.dRc = intent;
        Log.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", Boolean.valueOf(this.pdv));
        this.pdv = false;
        AppMethodBeat.o(22186);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(22187);
        super.onResume();
        if (this.dRc == null) {
            this.dRc = getIntent();
        }
        bg.azz().a(new bu(new bu.a() {
            /* class com.tencent.mm.plugin.base.stub.UIEntryStub.AnonymousClass1 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(g gVar) {
                AppMethodBeat.i(22180);
                if (gVar == null) {
                    UIEntryStub.this.finish();
                    AppMethodBeat.o(22180);
                    return;
                }
                Log.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", Boolean.valueOf(UIEntryStub.this.pdv));
                if (!UIEntryStub.this.pdv) {
                    UIEntryStub.this.pdv = true;
                    UIEntryStub.a(UIEntryStub.this, UIEntryStub.this.dRc.getExtras());
                }
                AppMethodBeat.o(22180);
            }
        }), 0);
        AppMethodBeat.o(22187);
    }

    static /* synthetic */ void a(UIEntryStub uIEntryStub, final Bundle bundle) {
        WXImageObject wXImageObject;
        b dSQ;
        AppMethodBeat.i(22188);
        if (uIEntryStub.isFinishing() || bundle == null) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bundle == null);
            Log.e("MicroMsg.UIEntryStub", "handleWXAppMessage fail data null:%b", objArr);
            uIEntryStub.finish();
            AppMethodBeat.o(22188);
            return;
        }
        uIEntryStub.LG = bundle.getString(ConstantsAPI.APP_PACKAGE);
        uIEntryStub.sdkVersion = bundle.getInt(ConstantsAPI.SDK_VERSION);
        String string = bundle.getString(ConstantsAPI.CONTENT);
        if (Util.isNullOrNil(string)) {
            Log.e("MicroMsg.UIEntryStub", "content is null");
            uIEntryStub.finish();
            AppMethodBeat.o(22188);
            return;
        }
        String queryParameter = Uri.parse(string).getQueryParameter("appid");
        Log.d("MicroMsg.UIEntryStub", "handleWXAppMessage, appId = ".concat(String.valueOf(queryParameter)));
        if (h.gq(queryParameter) && (dSQ = b.a.dSQ()) != null) {
            dSQ.k(uIEntryStub, queryParameter, uIEntryStub.LG);
        }
        int i2 = bundle.getInt("_wxapi_command_type");
        try {
            bundle.putBoolean("SendAppMessageWrapper_NoNeedStayInWeixin", false);
        } catch (Throwable th) {
        }
        Log.i("MicroMsg.UIEntryStub", "handle wxapp message: " + uIEntryStub.LG + ", sdkver=" + uIEntryStub.sdkVersion + ", cmd=" + i2);
        switch (i2) {
            case 1:
                if (bg.aAc() && !bg.azj()) {
                    c.b(uIEntryStub, "webview", ".ui.tools.SDKOAuthUI", new Intent().putExtras(bundle));
                    break;
                } else {
                    Log.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
            case 2:
                final SendMessageToWX.Req req = new SendMessageToWX.Req(bundle);
                if (req.message != null && req.message.getType() == 2 && (wXImageObject = (WXImageObject) req.message.mediaObject) != null && !wXImageObject.checkArgs()) {
                    Log.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, WXImageObject checkArgs fail, maybe use deprecated field imageUrl");
                    ReportUtil.a(uIEntryStub, ReportUtil.d(uIEntryStub.getIntent().getExtras(), -5), false);
                } else if (req.message.getType() == 38 && req.scene != 1) {
                    Log.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, video file object only supported share to timeline");
                    ReportUtil.a(uIEntryStub, ReportUtil.d(uIEntryStub.getIntent().getExtras(), -5), false);
                } else if (req.scene == 1) {
                    Log.i("MicroMsg.UIEntryStub", "sendMessageToWx, req.scene = send to timeline");
                    if (req.message.getType() == 8) {
                        Log.e("MicroMsg.UIEntryStub", "sendMessageToWx fail, emoji does not support WXSceneTimeline");
                        ReportUtil.a(uIEntryStub, ReportUtil.d(uIEntryStub.getIntent().getExtras(), -5), false);
                    } else {
                        new d(uIEntryStub, queryParameter, req.openId, new d.a() {
                            /* class com.tencent.mm.plugin.base.stub.UIEntryStub.AnonymousClass2 */

                            @Override // com.tencent.mm.plugin.base.stub.d.a
                            public final void jZ(boolean z) {
                                AppMethodBeat.i(22182);
                                boolean isFinishing = UIEntryStub.this.isFinishing();
                                Log.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                                if (!z || isFinishing) {
                                    ReportUtil.a(UIEntryStub.this, ReportUtil.d(UIEntryStub.this.getIntent().getExtras(), -3), false);
                                } else {
                                    Intent intent = new Intent(UIEntryStub.this, SendAppMessageWrapperUI.class);
                                    intent.putExtras(bundle);
                                    intent.putExtra("Select_Conv_User", "weixinfile");
                                    intent.putExtra("SendAppMessageWrapper_Scene", req.scene);
                                    UIEntryStub uIEntryStub = UIEntryStub.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(uIEntryStub, bl.axQ(), "com/tencent/mm/plugin/base/stub/UIEntryStub$2", "onCheckEnd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    uIEntryStub.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(uIEntryStub, "com/tencent/mm/plugin/base/stub/UIEntryStub$2", "onCheckEnd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                }
                                new MMHandler().postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.base.stub.UIEntryStub.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(22181);
                                        UIEntryStub.this.finish();
                                        AppMethodBeat.o(22181);
                                    }
                                }, 1000);
                                AppMethodBeat.o(22182);
                            }
                        }).cjR();
                        AppMethodBeat.o(22188);
                        return;
                    }
                } else if (req.scene == 3) {
                    new d(uIEntryStub, queryParameter, req.openId, new d.a() {
                        /* class com.tencent.mm.plugin.base.stub.UIEntryStub.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.base.stub.d.a
                        public final void jZ(boolean z) {
                            AppMethodBeat.i(22184);
                            boolean isFinishing = UIEntryStub.this.isFinishing();
                            String string = bundle.getString("SendAppMessageWrapper_UserName", "");
                            Log.i("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing + ", username = " + string);
                            if (!z || isFinishing || Util.isNullOrNil(string)) {
                                ReportUtil.a(UIEntryStub.this, ReportUtil.d(UIEntryStub.this.getIntent().getExtras(), -3), false);
                            } else {
                                Intent intent = new Intent(UIEntryStub.this, ChattingUI.class);
                                intent.putExtras(bundle);
                                intent.putExtra("finish_direct", false);
                                intent.putExtra("Chat_User", string);
                                intent.putExtra("SendAppMessageWrapper_Scene", req.scene);
                                if (req.message.getType() == 45) {
                                    intent.putExtra("Select_Send_Card", true);
                                }
                                UIEntryStub uIEntryStub = UIEntryStub.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(uIEntryStub, bl.axQ(), "com/tencent/mm/plugin/base/stub/UIEntryStub$3", "onCheckEnd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                uIEntryStub.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(uIEntryStub, "com/tencent/mm/plugin/base/stub/UIEntryStub$3", "onCheckEnd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            new MMHandler().postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.base.stub.UIEntryStub.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(22183);
                                    UIEntryStub.this.finish();
                                    AppMethodBeat.o(22183);
                                }
                            }, 1000);
                            AppMethodBeat.o(22184);
                        }
                    }).cjR();
                    AppMethodBeat.o(22188);
                    return;
                } else {
                    ReportUtil.ReportArgs d2 = ReportUtil.d(bundle, -2);
                    Intent intent = new Intent(uIEntryStub, SelectConversationUI.class);
                    intent.putExtra("Select_Report_Args", d2);
                    intent.putExtra("Select_Conv_NextStep", new Intent(uIEntryStub, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("SendAppMessageWrapper_Scene", req.scene).putExtra("animation_pop_in", true));
                    intent.putExtra("Select_App_Id", queryParameter);
                    intent.putExtra("Select_Open_Id", req.openId);
                    intent.putExtra("Select_Conv_Type", 3);
                    if (req.message.getType() == 36 || req.message.getType() == 46) {
                        intent.putExtra("mutil_select_is_ret", !((WXMiniProgramObject) req.message.mediaObject).withShareTicket);
                    } else {
                        intent.putExtra("mutil_select_is_ret", true);
                    }
                    if (req.message.getType() == 45) {
                        intent.putExtra("Select_Send_Card", true);
                    }
                    if (!bg.aAc() || bg.azj()) {
                        Log.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    } else {
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(uIEntryStub, bl.axQ(), "com/tencent/mm/plugin/base/stub/UIEntryStub", "dealSendMsgToWx", "(Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        uIEntryStub.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(uIEntryStub, "com/tencent/mm/plugin/base/stub/UIEntryStub", "dealSendMsgToWx", "(Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                }
                uIEntryStub.finish();
                AppMethodBeat.o(22188);
                return;
            case 3:
                if (bg.aAc() && !bg.azj()) {
                    at.bv(bundle);
                    break;
                } else {
                    Log.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
            case 4:
                if (bg.aAc() && !bg.azj()) {
                    au.bv(bundle);
                    break;
                } else {
                    Log.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
        }
        uIEntryStub.finish();
        AppMethodBeat.o(22188);
    }
}
