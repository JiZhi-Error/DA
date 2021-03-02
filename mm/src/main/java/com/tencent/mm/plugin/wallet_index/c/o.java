package com.tencent.mm.plugin.wallet_index.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.tenpay.model.r;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public final class o extends IListener<aaa> implements i {
    private static final String IqR = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e24) + "?");
    private static final String IqS = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e23) + "?");
    private int IqT;
    private je IqU;
    private ph IqV;
    private Queue<ph> IqW;
    public IListener IqX = new IListener<je>() {
        /* class com.tencent.mm.plugin.wallet_index.c.o.AnonymousClass1 */

        {
            AppMethodBeat.i(160895);
            this.__eventId = je.class.getName().hashCode();
            AppMethodBeat.o(160895);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(je jeVar) {
            AppMethodBeat.i(71831);
            boolean a2 = a(jeVar);
            AppMethodBeat.o(71831);
            return a2;
        }

        private boolean a(je jeVar) {
            AppMethodBeat.i(71830);
            o.this.IqU = jeVar;
            String str = o.this.IqU.dNT.result;
            if (o.this.IqU.dNT.dNV != null) {
                o.this.mPayChannel = o.this.IqU.dNT.dNV.getInt("pay_channel", 0);
            }
            switch (o.this.IqU.dNT.actionCode) {
                case 10:
                case 11:
                    if (!EventCenter.instance.hadListened(this)) {
                        alive();
                    }
                    Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(str)));
                    if (str != null) {
                        if (!str.startsWith("weixin://wxpay")) {
                            o.this.IqT = 1;
                            o.a(o.this, str, o.this.mPayChannel);
                        } else if (WeChatEnvironment.hasDebugger()) {
                            Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
                            ph phVar = new ph();
                            phVar.dVp.url = str;
                            phVar.dVp.scene = 4;
                            phVar.dVp.channel = 12;
                            phVar.dVp.sourceType = 0;
                            phVar.dVp.source = "";
                            phVar.dVp.context = jeVar.dNT.context;
                            o.a(o.this, phVar);
                            Toast.makeText(jeVar.dNT.context, "click to do pay test", 1).show();
                        } else {
                            o.this.IqT = 4;
                            g.aAi();
                            g.aAg().hqi.a(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, o.this);
                            l lVar = new l(str, o.this.IqU.dNT.username, 4, 0, (int) System.currentTimeMillis(), new byte[0]);
                            g.aAi();
                            g.aAg().hqi.a(lVar, 0);
                            o.this.mRequestTime = System.currentTimeMillis();
                        }
                        AppMethodBeat.o(71830);
                        return true;
                    }
                    AppMethodBeat.o(71830);
                    return true;
                case 12:
                    o.a(o.this, str);
                    AppMethodBeat.o(71830);
                    return true;
                default:
                    AppMethodBeat.o(71830);
                    return false;
            }
        }
    };
    public IListener<ph> IqY = new IListener<ph>() {
        /* class com.tencent.mm.plugin.wallet_index.c.o.AnonymousClass2 */

        {
            AppMethodBeat.i(160896);
            this.__eventId = ph.class.getName().hashCode();
            AppMethodBeat.o(160896);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ph phVar) {
            AppMethodBeat.i(71833);
            o.a(o.this, phVar);
            AppMethodBeat.o(71833);
            return false;
        }
    };
    private int mPayChannel = 0;
    private long mRequestTime;

    public o() {
        AppMethodBeat.i(71839);
        this.__eventId = aaa.class.getName().hashCode();
        AppMethodBeat.o(71839);
    }

    static /* synthetic */ void a(o oVar, String str, int i2) {
        AppMethodBeat.i(71845);
        oVar.gb(str, i2);
        AppMethodBeat.o(71845);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(aaa aaa) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(71843);
        aaa aaa2 = aaa;
        ab.hht();
        if (aaa2 != null) {
            Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (aaa2.egJ.result == -1) + ", the event is " + aaa2);
            if (aaa2.egJ.result == -1) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                if (aaa2.egJ.intent == null || aaa2.egJ.intent.getIntExtra("pay_channel", 0) != 13) {
                    c.f(MMApplicationContext.getContext(), ".ui.LauncherUI", intent);
                } else {
                    Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
                }
                z = true;
            } else {
                z = false;
            }
            if (!aaa2.egJ.egL) {
                z2 = z;
            } else if (this.IqW != null && this.IqW.size() > 0) {
                final ph poll = this.IqW.poll();
                Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "One PayAuthNativeEvent has been consumed, and the size of mKindaAuthNativeEventQueue is " + this.IqW.size());
                switch (aaa2.egJ.result) {
                    case 0:
                        poll.dVq.ret = 1;
                        break;
                    case 3:
                        poll.dVq.ret = 2;
                        break;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_index.c.o.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(71838);
                        if (poll.callback != null) {
                            poll.callback.run();
                        }
                        AppMethodBeat.o(71838);
                    }
                });
                z2 = true;
            } else if (this.IqW != null) {
                Log.e("MicroMsg.WalletGetA8KeyRedirectListener", "The state of mKindaAuthNativeEventQueue is error! it's empty!");
            } else {
                Log.e("MicroMsg.WalletGetA8KeyRedirectListener", "The state of mKindaAuthNativeEventQueue is error! it is null!");
            }
        }
        Log.f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        if (!z2 || this.IqW.size() > 0) {
            Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "event isn't consumed, isDealEvent: " + z2 + ", and mKindaAuthNativeEventQueue.size(): " + this.IqW.size());
        } else {
            dead();
            Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "event is finish and consumed");
        }
        AppMethodBeat.o(71843);
        return z2;
    }

    static {
        AppMethodBeat.i(214271);
        AppMethodBeat.o(214271);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71840);
        if (qVar instanceof l) {
            long currentTimeMillis = System.currentTimeMillis() - this.mRequestTime;
            h.INSTANCE.a(11170, Integer.valueOf((int) TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS), 0, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), "");
            o(i2, i3, currentTimeMillis);
            Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
            g.aAi();
            g.aAg().hqi.b(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
            if (i2 == 0 && i3 == 0) {
                gb(((l) qVar).beQ(), this.mPayChannel);
                AppMethodBeat.o(71840);
                return;
            }
            if (Util.isNullOrNil(str)) {
                str = this.IqU.dNT.context.getString(R.string.itf);
            }
            com.tencent.mm.ui.base.h.d(this.IqU.dNT.context, str, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.c.o.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71834);
                    if (o.this.IqU.callback != null) {
                        o.this.IqU.dNU.ret = 1;
                        o.this.IqU.callback.run();
                    }
                    AppMethodBeat.o(71834);
                }
            });
            AppMethodBeat.o(71840);
        } else if (qVar instanceof com.tencent.mm.wallet_core.tenpay.model.o) {
            Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
            g.aAi();
            g.aAg().hqi.b(385, this);
            if (i2 == 0 && i3 == 0 && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(((com.tencent.mm.wallet_core.tenpay.model.o) qVar).RuX)) {
                if (this.IqV.callback != null) {
                    this.IqV.dVq.ret = 2;
                    this.IqV.callback.run();
                }
                af.z(this.IqT, ((com.tencent.mm.wallet_core.tenpay.model.o) qVar).dDL, i3);
                exi exi = ((com.tencent.mm.wallet_core.tenpay.model.o) qVar).IqN;
                if (exi == null || Util.isNullOrNil(exi.NuI)) {
                    com.tencent.mm.wallet_core.tenpay.model.o oVar = (com.tencent.mm.wallet_core.tenpay.model.o) qVar;
                    PayInfo payInfo = new PayInfo();
                    payInfo.dVv = this.IqT;
                    payInfo.dDL = oVar.dDL;
                    payInfo.appId = oVar.appId;
                    payInfo.IqM = oVar.IqM;
                    payInfo.productId = oVar.productId;
                    payInfo.channel = oVar.channel;
                    Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", payInfo.toString());
                    f.a(this.IqV.dVp.context, payInfo, 0);
                    if (this.IqV.callback != null) {
                        this.IqV.dVq.ret = 2;
                        this.IqV.callback.run();
                    }
                    AppMethodBeat.o(71840);
                    return;
                }
                com.tencent.mm.wallet_core.tenpay.model.o oVar2 = (com.tencent.mm.wallet_core.tenpay.model.o) qVar;
                Intent intent = new Intent();
                intent.putExtra("prepayId", oVar2.dDL);
                intent.putExtra("is_jsapi_offline_pay", false);
                exi exi2 = oVar2.IqN;
                intent.putExtra("pay_gate_url", exi2.NuI);
                intent.putExtra("need_dialog", exi2.NuK);
                intent.putExtra("dialog_text", exi2.NuL);
                intent.putExtra("max_count", exi2.NuJ.LbT);
                intent.putExtra("inteval_time", exi2.NuJ.LbS);
                intent.putExtra("default_wording", exi2.NuJ.LbU);
                c.c((Activity) this.IqV.dVp.context, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                if (this.IqV.callback != null) {
                    this.IqV.dVq.ret = 2;
                    this.IqV.callback.run();
                }
                Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", this.IqV.dVp.context);
                AppMethodBeat.o(71840);
                return;
            }
            if (this.IqV.callback != null) {
                this.IqV.dVq.ret = 1;
            }
            if (Util.isNullOrNil(str)) {
                if (!Util.isNullOrNil(((com.tencent.mm.wallet_core.tenpay.model.o) qVar).qwG)) {
                    str = ((com.tencent.mm.wallet_core.tenpay.model.o) qVar).qwG;
                } else {
                    str = this.IqV.dVp.context.getString(R.string.itf);
                }
            }
            af.z(this.IqT, "", i3);
            com.tencent.mm.ui.base.h.d(this.IqV.dVp.context, str, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.c.o.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71835);
                    if (o.this.IqV.callback != null) {
                        o.this.IqV.dVq.ret = 1;
                        o.this.IqV.callback.run();
                    }
                    AppMethodBeat.o(71835);
                }
            });
            AppMethodBeat.o(71840);
        } else {
            Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
            AppMethodBeat.o(71840);
        }
    }

    private void gb(String str, int i2) {
        AppMethodBeat.i(71841);
        Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(str)));
        PayInfo payInfo = new PayInfo();
        payInfo.dVv = this.IqT;
        String[] split = str.replace(IqS, "").split("&");
        String str2 = null;
        String str3 = null;
        for (String str4 : split) {
            if (str4.startsWith("errcode=")) {
                str3 = str4.replace("errcode=", "");
            } else if (str4.startsWith("errmsg=")) {
                str2 = str4.replace("errmsg=", "");
            } else if (str4.startsWith("reqkey=")) {
                payInfo.dDL = str4.replace("reqkey=", "");
            } else if (str4.startsWith("uuid=")) {
                payInfo.uuid = str4.replace("uuid=", "");
            } else if (str4.startsWith("appid=")) {
                payInfo.appId = str4.replace("appid=", "");
            } else if (str4.startsWith("appsource=")) {
                payInfo.IqM = str4.replace("appsource=", "");
            } else if (str4.startsWith("productid=")) {
                payInfo.productId = str4.replace("productid=", "");
            }
        }
        payInfo.channel = i2;
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3)) {
            b.hgC();
            if (b.b(b.a.clicfg_kinda_open, true)) {
                ((a) g.af(a.class)).startWxpayQueryCashierPay(payInfo.dDL, payInfo.dVv);
            } else {
                f.a(this.IqU.dNT.context, payInfo, 0);
            }
            if (this.IqU.callback != null) {
                this.IqU.dNU.ret = 1;
                this.IqU.callback.run();
            }
        } else {
            if (Util.isNullOrNil(str2)) {
                str2 = this.IqU.dNT.context.getString(R.string.itf);
            }
            com.tencent.mm.ui.base.h.d(this.IqU.dNT.context, str2, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.c.o.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71836);
                    if (o.this.IqU.callback != null) {
                        o.this.IqU.dNU.ret = 1;
                        o.this.IqU.callback.run();
                    }
                    AppMethodBeat.o(71836);
                }
            });
        }
        if (!TextUtils.isEmpty(str3) && Pattern.compile("[0-9]*").matcher(str3).matches()) {
            o(0, Integer.valueOf(str3).intValue(), 0);
        }
        AppMethodBeat.o(71841);
    }

    private void o(int i2, int i3, long j2) {
        AppMethodBeat.i(71842);
        int i4 = 132;
        if (this.IqT == 1) {
            i4 = TbsListener.ErrorCode.STARTDOWNLOAD_4;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(i4);
        iDKey.SetValue(1);
        iDKey.SetKey(26);
        arrayList.add(iDKey);
        if (!(i2 == 0 && i3 == 0)) {
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(i4);
            iDKey2.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i4);
            iDKey3.SetValue(1);
            iDKey2.SetKey(8);
            if (i3 < 0) {
                iDKey3.SetKey(9);
            } else if (i3 > 0) {
                iDKey3.SetKey(10);
            }
        }
        if (this.IqT == 4 && j2 > 0) {
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(i4);
            iDKey4.SetValue(1);
            IDKey iDKey5 = new IDKey();
            iDKey5.SetID(i4);
            iDKey5.SetValue(1);
            IDKey iDKey6 = new IDKey();
            iDKey6.SetID(i4);
            iDKey6.SetValue((long) ((int) j2));
            iDKey4.SetKey(0);
            if (j2 <= 1000) {
                iDKey5.SetKey(1);
                iDKey6.SetKey(4);
            } else if (j2 > 1000 && j2 <= 3000) {
                iDKey5.SetKey(2);
                iDKey6.SetKey(5);
            } else if (j2 > 3000) {
                iDKey5.SetKey(3);
                iDKey6.SetKey(6);
            }
            arrayList.add(iDKey4);
            arrayList.add(iDKey5);
            arrayList.add(iDKey6);
        }
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(71842);
    }

    static /* synthetic */ void a(o oVar, String str) {
        AppMethodBeat.i(214270);
        Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = ".concat(String.valueOf(str)));
        String[] split = str.replace(IqR, "").split("&");
        String str2 = null;
        String str3 = null;
        String str4 = null;
        for (String str5 : split) {
            if (str5.startsWith("errcode=")) {
                str4 = str5.replace("errcode=", "");
            } else if (str5.startsWith("errmsg=")) {
                str3 = str5.replace("errmsg=", "");
            } else if (str5.startsWith("importkey=")) {
                str2 = str5.replace("importkey=", "");
            }
        }
        if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str4) || Util.isNullOrNil(str2)) {
            if (Util.isNullOrNil(str3)) {
                str3 = oVar.IqU.dNT.context.getString(R.string.itf);
            }
            com.tencent.mm.ui.base.h.d(oVar.IqU.dNT.context, str3, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.c.o.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71837);
                    if (o.this.IqU.callback != null) {
                        o.this.IqU.dNU.ret = 1;
                        o.this.IqU.callback.run();
                    }
                    AppMethodBeat.o(71837);
                }
            });
        } else {
            Context context = oVar.IqU.dNT.context;
            Intent intent = new Intent();
            intent.putExtra("key_import_key", str2);
            intent.putExtra("key_bind_scene", 2);
            intent.putExtra("key_custom_bind_tips", (String) null);
            c.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
            if (oVar.IqU.callback != null) {
                oVar.IqU.dNU.ret = 1;
                oVar.IqU.callback.run();
                AppMethodBeat.o(214270);
                return;
            }
        }
        AppMethodBeat.o(214270);
    }

    static /* synthetic */ void a(o oVar, ph phVar) {
        String str;
        q oVar2;
        AppMethodBeat.i(71844);
        com.tencent.mm.wallet_core.b.hgC();
        if (!com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true)) {
            oVar.IqV = phVar;
            String str2 = phVar.dVp.url;
            int i2 = phVar.dVp.scene;
            int i3 = phVar.dVp.channel;
            int i4 = phVar.dVp.sourceType;
            if (phVar.dVp.source == null) {
                str = "";
            } else {
                str = phVar.dVp.source;
            }
            oVar.IqT = 1;
            Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
            int i5 = oVar.IqT;
            if (Util.isNullOrNil(str2)) {
                oVar2 = new com.tencent.mm.wallet_core.tenpay.model.o(str2, i2, i5, i3, i4, str);
            } else {
                int indexOf = str2.indexOf("/bizpayurl");
                int indexOf2 = str2.indexOf("?");
                if (indexOf < 0 || indexOf2 < 0 || indexOf >= indexOf2) {
                    oVar2 = new com.tencent.mm.wallet_core.tenpay.model.o(str2, i2, i5, i3, i4, str);
                } else if (str2.substring(indexOf, indexOf2).equals("/bizpayurl/up")) {
                    oVar2 = new r(str2, i2, i5, i3, i4, str);
                } else {
                    oVar2 = new com.tencent.mm.wallet_core.tenpay.model.o(str2, i2, i5, i3, i4, str);
                }
            }
            g.aAi();
            g.aAg().hqi.a(385, oVar);
            g.aAi();
            g.aAg().hqi.a(oVar2, 0);
            AppMethodBeat.o(71844);
            return;
        }
        if (oVar.IqW == null) {
            oVar.IqW = new LinkedList();
        }
        oVar.IqW.offer(phVar);
        if (!EventCenter.instance.hadListened(oVar)) {
            oVar.alive();
        }
        ((a) g.af(a.class)).startScanQRCodePay(phVar.dVp.context, phVar.dVp.scene, phVar.dVp.url, phVar.dVp.channel);
        AppMethodBeat.o(71844);
    }
}
