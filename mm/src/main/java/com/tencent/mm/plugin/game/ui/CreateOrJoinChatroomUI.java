package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.plugin.game.protobuf.ak;
import com.tencent.mm.plugin.game.protobuf.al;
import com.tencent.mm.plugin.game.protobuf.az;
import com.tencent.mm.plugin.game.protobuf.ba;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    private String Nl;
    private ProgressDialog iLh = null;
    private String krY;
    private String mAppId;
    private String mPackageName;
    private String xOq;
    private String xOr;
    private String xOs;
    private String xOt;
    private int xOu = 1;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI) {
        AppMethodBeat.i(41870);
        createOrJoinChatroomUI.dWg();
        AppMethodBeat.o(41870);
    }

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI, int i2) {
        AppMethodBeat.i(41869);
        createOrJoinChatroomUI.Or(i2);
        AppMethodBeat.o(41869);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        byte[] bytes;
        byte[] bytes2;
        byte[] bytes3;
        AppMethodBeat.i(41864);
        super.onCreate(bundle);
        requestWindowFeature(1);
        Log.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.Nl = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        this.mPackageName = intent.getStringExtra("package_name");
        this.mAppId = intent.getStringExtra("key_app_id");
        this.xOq = intent.getStringExtra("key_transaction");
        this.xOr = intent.getStringExtra(FirebaseAnalytics.b.GROUP_ID);
        this.xOs = intent.getStringExtra("chatroom_name");
        this.krY = intent.getStringExtra("chatroom_nickname");
        this.xOt = intent.getStringExtra("ext_msg");
        if (Util.isNullOrNil(this.Nl) || Util.isNullOrNil(this.mAppId) || Util.isNullOrNil(this.xOr)) {
            Log.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            AppMethodBeat.o(41864);
            return;
        }
        this.iLh = h.a((Context) this, getBaseContext().getString(R.string.dsz), true, (DialogInterface.OnCancelListener) null);
        if (this.Nl.equals("action_create")) {
            Log.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", this.mAppId, this.xOr, this.xOs);
            d.a aVar = new d.a();
            aVar.iLN = new ak();
            aVar.iLO = new al();
            aVar.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            aVar.funcId = TXLiteAVCode.WARNING_SPEAKER_DEVICE_ABNORMAL;
            d aXF = aVar.aXF();
            ak akVar = (ak) aXF.iLK.iLR;
            akVar.hik = this.mAppId;
            akVar.xKj = this.xOr;
            if (this.xOs == null) {
                bytes2 = new byte[0];
            } else {
                bytes2 = this.xOs.getBytes();
            }
            akVar.xKk = new b(bytes2);
            if (this.krY == null) {
                bytes3 = new byte[0];
            } else {
                bytes3 = this.krY.getBytes();
            }
            akVar.xKl = new b(bytes3);
            aa.a(aXF, new aa.a() {
                /* class com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(41862);
                    al alVar = (al) dVar.iLL.iLR;
                    if (i2 == 0 && i3 == 0) {
                        String str2 = alVar.xKm;
                        Log.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", str2);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, str2);
                        AppMethodBeat.o(41862);
                    } else {
                        Log.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 4) {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, alVar.rBL);
                        } else {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, -1);
                        }
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.this.finish();
                        AppMethodBeat.o(41862);
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(41864);
            return;
        }
        if (this.Nl.equals("action_join")) {
            d.a aVar2 = new d.a();
            aVar2.iLN = new az();
            aVar2.iLO = new ba();
            aVar2.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            aVar2.funcId = 1206;
            d aXF2 = aVar2.aXF();
            az azVar = (az) aXF2.iLK.iLR;
            azVar.hik = this.mAppId;
            azVar.xKj = this.xOr;
            if (this.krY == null) {
                bytes = new byte[0];
            } else {
                bytes = this.krY.getBytes();
            }
            azVar.xKl = new b(bytes);
            aa.a(aXF2, new aa.a() {
                /* class com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI.AnonymousClass2 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(41863);
                    ba baVar = (ba) dVar.iLL.iLR;
                    if (i2 == 0 && i3 == 0) {
                        String str2 = baVar.xKW;
                        Log.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", str2);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, str2);
                        AppMethodBeat.o(41863);
                    } else {
                        Log.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 4) {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, baVar.rBL);
                        } else {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, -1);
                        }
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.this.finish();
                        AppMethodBeat.o(41863);
                    }
                    return 0;
                }
            });
        }
        AppMethodBeat.o(41864);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(41865);
        dWg();
        super.onDestroy();
        AppMethodBeat.o(41865);
    }

    private void dWg() {
        AppMethodBeat.i(41866);
        if (this.iLh != null && this.iLh.isShowing()) {
            this.iLh.cancel();
        }
        AppMethodBeat.o(41866);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(41867);
        if (i2 == 5) {
            if (i3 == 4) {
                Or(0);
            } else if (i3 == 5) {
                if (intent != null) {
                    q.a.JSZ.b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i3 == 0) {
                Or(-2);
            }
        }
        finish();
        AppMethodBeat.o(41867);
    }

    private void Or(int i2) {
        AppMethodBeat.i(41868);
        g o = com.tencent.mm.pluginsdk.model.app.h.o(this.mAppId, true, false);
        Bundle bundle = new Bundle();
        if (this.Nl.equals("action_create")) {
            CreateChatroom.Resp resp = new CreateChatroom.Resp();
            if (o != null) {
                resp.openId = o.field_openId;
            }
            resp.transaction = this.xOq;
            resp.extMsg = this.xOt;
            resp.errCode = i2;
            resp.toBundle(bundle);
        } else if (this.Nl.equals("action_join")) {
            JoinChatroom.Resp resp2 = new JoinChatroom.Resp();
            if (o != null) {
                resp2.openId = o.field_openId;
            }
            resp2.transaction = this.xOq;
            resp2.extMsg = this.xOt;
            resp2.errCode = i2;
            resp2.toBundle(bundle);
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = this.mPackageName;
        args.bundle = bundle;
        com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
        com.tencent.mm.pluginsdk.model.app.q.bp(bundle);
        MMessageActV2.send(MMApplicationContext.getContext(), args);
        AppMethodBeat.o(41868);
    }

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI, String str) {
        AppMethodBeat.i(41871);
        Intent intent = new Intent();
        String r = com.tencent.mm.pluginsdk.model.app.h.r(createOrJoinChatroomUI, createOrJoinChatroomUI.mAppId);
        intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, createOrJoinChatroomUI.Nl);
        intent.putExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, r);
        intent.putExtra("rawUrl", str);
        c.b(createOrJoinChatroomUI, "webview", ".ui.tools.game.GameChattingRoomWebViewUI", intent, 5);
        AppMethodBeat.o(41871);
    }
}
