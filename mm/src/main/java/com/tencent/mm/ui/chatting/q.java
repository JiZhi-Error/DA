package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.m;
import com.tencent.mm.api.c;
import com.tencent.mm.br.c;
import com.tencent.mm.cj.a;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.n.h;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.subapp.d.i;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.z;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class q implements com.tencent.mm.pluginsdk.ui.chat.b {
    public static boolean PgR = true;
    private com.tencent.mm.ui.chatting.e.a OIz;
    private boolean Pdm;
    public m PgS;
    private String PgT;
    private String PgU;
    private ToneGenerator PgV;
    private boolean PgW;
    private boolean PgX;
    public boolean PgY;
    private boolean PgZ = true;
    private volatile boolean Pha = false;
    private volatile boolean Phb = false;
    private boolean Phc = false;
    private as contact;
    private final MTimerHandler jxC = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.chatting.q.AnonymousClass9 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(34493);
            q.this.znD.aiy(q.this.PgS.getMaxAmplitude());
            AppMethodBeat.o(34493);
            return true;
        }
    }, true);
    private String lem = "";
    private Object lock = new Object();
    private Vibrator paT;
    private final MTimerHandler qPy = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.chatting.q.AnonymousClass10 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(34494);
            long aas = q.this.PgS.aas();
            Log.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(aas)));
            int i2 = (int) ((Util.MILLSECONDS_OF_MINUTE - aas) / 1000);
            if (aas >= 50000 && aas <= Util.MILLSECONDS_OF_MINUTE && !q.this.Phc) {
                Util.lightShake(q.this.OIz.Pwc.getContext());
                q.this.Phc = true;
            }
            q.this.znD.setVoiceReactArea(i2);
            if (aas >= Util.MILLSECONDS_OF_MINUTE) {
                Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
                if (!q.this.znD.grl()) {
                    q.h(q.this);
                    q.this.znD.a(ChatFooter.h.SendVoice);
                } else {
                    q.this.znD.gqR();
                }
                PlaySound.play(q.this.OIz.Pwc.getContext(), R.string.hom);
                AppMethodBeat.o(34494);
                return false;
            }
            AppMethodBeat.o(34494);
            return true;
        }
    }, true);
    private String tOw = "";
    private ChatFooter znD;
    private final m.a znH = new m.a() {
        /* class com.tencent.mm.ui.chatting.q.AnonymousClass1 */

        @Override // com.tencent.mm.ak.m.a
        public final void onError() {
            AppMethodBeat.i(34487);
            q.this.PgS.reset();
            q.this.jxC.stopTimer();
            q.this.qPy.stopTimer();
            MMEntryLock.unlock("keep_app_silent");
            q.this.znD.a(ChatFooter.h.Error);
            aw awVar = (aw) q.this.OIz.bh(aw.class);
            if (!(awVar == null || awVar.gRx() == null)) {
                awVar.gRx().gMP();
            }
            Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
            q.this.OIz.Pwc.enableOptionMenu(true);
            q.this.OIz.Pwc.enableBackMenu(true);
            Toast.makeText(q.this.OIz.Pwc.getContext(), q.this.OIz.Pwc.getContext().getString(R.string.b1p), 0).show();
            AppMethodBeat.o(34487);
        }
    };
    private final m.b znI = new m.b() {
        /* class com.tencent.mm.ui.chatting.q.AnonymousClass7 */

        @Override // com.tencent.mm.ak.m.b
        public final void aYN() {
            AppMethodBeat.i(34491);
            q.this.znD.gqr();
            AppMethodBeat.o(34491);
        }
    };
    public AppPanel.a zon = new AppPanel.a() {
        /* class com.tencent.mm.ui.chatting.q.AnonymousClass11 */
        e Bcp = null;

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehU() {
            final boolean z;
            AppMethodBeat.i(34499);
            if (com.tencent.mm.q.a.cA(q.this.OIz.Pwc.getContext())) {
                AppMethodBeat.o(34499);
            } else if (com.tencent.mm.q.a.cB(q.this.OIz.Pwc.getContext())) {
                AppMethodBeat.o(34499);
            } else if (com.tencent.mm.q.a.p(q.this.OIz.Pwc.getContext(), true)) {
                AppMethodBeat.o(34499);
            } else if (com.tencent.mm.q.a.cE(q.this.OIz.Pwc.getContext())) {
                AppMethodBeat.o(34499);
            } else {
                zi ziVar = new zi();
                EventCenter.instance.publish(ziVar);
                if (q.this.getTalkerUserName() == null || q.this.getTalkerUserName().equals(ziVar.efv.talker) || (!ziVar.efv.dCH && !ziVar.efv.dCI)) {
                    if (1 == h.aqJ().getInt("EnableVoiceVoipFromPlugin", 0)) {
                        if (as.bjp(q.this.OIz.GUe.field_username) || ab.Iy(q.this.OIz.GUe.field_username)) {
                            z = (((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).RZ(q.this.OIz.GUe.field_openImAppid) & 8192) == 0;
                        } else {
                            z = false;
                        }
                        this.Bcp = new e((Context) q.this.OIz.Pwc.getContext(), 1, false);
                        this.Bcp.HLX = new o.f() {
                            /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                AppMethodBeat.i(34495);
                                mVar.aS(2, R.string.v4, R.raw.sharemore_videovoip);
                                if (!z) {
                                    mVar.aS(1, R.string.v6, R.raw.sharemore_voipvoice);
                                }
                                AppMethodBeat.o(34495);
                            }
                        };
                        this.Bcp.HLY = new o.g() {
                            /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(34496);
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        q.this.eEK();
                                        AppMethodBeat.o(34496);
                                        return;
                                    case 2:
                                        q.this.eEL();
                                        break;
                                }
                                AppMethodBeat.o(34496);
                            }
                        };
                        this.Bcp.dGm();
                    } else {
                        q.this.gNM();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11033, 4, 1, 0);
                    AppMethodBeat.o(34499);
                    return;
                }
                Toast.makeText(q.this.OIz.Pwc.getContext(), ziVar.efv.efw ? R.string.an0 : R.string.an1, 0).show();
                Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
                AppMethodBeat.o(34499);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehV() {
            AppMethodBeat.i(34500);
            if (com.tencent.mm.q.a.cA(q.this.OIz.Pwc.getContext())) {
                AppMethodBeat.o(34500);
            } else if (com.tencent.mm.q.a.cB(q.this.OIz.Pwc.getContext())) {
                AppMethodBeat.o(34500);
            } else if (com.tencent.mm.q.a.cE(q.this.OIz.Pwc.getContext())) {
                AppMethodBeat.o(34500);
            } else {
                zi ziVar = new zi();
                EventCenter.instance.publish(ziVar);
                if (q.this.getTalkerUserName().equals(ziVar.efv.talker) || (!ziVar.efv.dCH && !ziVar.efv.dCI)) {
                    q.this.gNL();
                    AppMethodBeat.o(34500);
                    return;
                }
                Toast.makeText(q.this.OIz.Pwc.getContext(), ziVar.efv.efw ? R.string.an0 : R.string.an1, 0).show();
                Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
                AppMethodBeat.o(34500);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehW() {
            AppMethodBeat.i(34501);
            if (!com.tencent.mm.q.a.cC(q.this.OIz.Pwc.getContext()) && !com.tencent.mm.q.a.cA(q.this.OIz.Pwc.getContext()) && !com.tencent.mm.q.a.cE(q.this.OIz.Pwc.getContext())) {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(q.this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
                Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), q.this.OIz.Pwc.getContext());
                if (!a2) {
                    AppMethodBeat.o(34501);
                    return;
                }
                q.this.gNN();
            }
            AppMethodBeat.o(34501);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehX() {
            AppMethodBeat.i(34502);
            ((ad) q.this.OIz.bh(ad.class)).gQI();
            AppMethodBeat.o(34502);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehY() {
            AppMethodBeat.i(34503);
            ((com.tencent.mm.ui.chatting.d.b.e) q.this.OIz.bh(com.tencent.mm.ui.chatting.d.b.e.class)).gPg();
            AppMethodBeat.o(34503);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void Qj(int i2) {
            AppMethodBeat.i(34504);
            switch (i2) {
                case 1:
                    bg.aVF();
                    if (!c.isSDCardAvailable()) {
                        u.g(q.this.OIz.Pwc.getContext(), q.this.OIz.Pwc.getContentView());
                        AppMethodBeat.o(34504);
                        return;
                    }
                    String string = q.this.OIz.Pwc.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
                    com.tencent.mm.plugin.report.service.g.Wl(19);
                    if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        s.f(q.this.OIz.Pwc);
                    } else {
                        String gRI = q.this.OIz.gRI();
                        String talkerUserName = q.this.OIz.getTalkerUserName();
                        Intent intent = new Intent();
                        if (q.this.OIz.gRM()) {
                            intent.putExtra("gallery_report_tag", 20);
                        } else {
                            intent.putExtra("gallery_report_tag", 21);
                        }
                        if (as.bju(talkerUserName)) {
                            intent.putExtra("album_business_tag", "album_business_byp");
                        }
                        if (q.this.PgY && q.PgR) {
                            s.a(q.this.OIz.Pwc, gRI, talkerUserName, intent);
                        } else if (as.HF(talkerUserName)) {
                            s.a(q.this.OIz.Pwc, 12, gRI, talkerUserName, intent);
                        } else {
                            s.a(q.this.OIz.Pwc, 3, gRI, talkerUserName, intent);
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 2, 1);
                    AppMethodBeat.o(34504);
                    return;
                case 0:
                    com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKV());
                    if (oVar.exists() || oVar.mkdirs()) {
                        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(q.this.OIz.Pwc.getContext(), "android.permission.CAMERA", 20, "", "");
                        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), q.this.OIz.Pwc.getContext());
                        if (a2) {
                            q.this.gNO();
                            break;
                        } else {
                            AppMethodBeat.o(34504);
                            return;
                        }
                    } else {
                        Toast.makeText(q.this.OIz.Pwc.getContext(), q.this.OIz.Pwc.getMMResources().getString(R.string.b2v), 1).show();
                        AppMethodBeat.o(34504);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(34504);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void d(com.tencent.mm.pluginsdk.model.app.g gVar) {
            AppMethodBeat.i(34505);
            ((com.tencent.mm.ui.chatting.d.b.b) q.this.OIz.bh(com.tencent.mm.ui.chatting.d.b.b.class)).u(gVar);
            AppMethodBeat.o(34505);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehZ() {
            AppMethodBeat.i(34506);
            com.tencent.mm.br.c.b(q.this.OIz.Pwc.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
            AppMethodBeat.o(34506);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eia() {
            AppMethodBeat.i(34507);
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            if (com.tencent.mm.al.g.DQ(q.this.contact.field_username)) {
                arrayList.add("4");
                arrayList.add("7");
                arrayList.add("21");
                arrayList.add("9");
                arrayList.add(PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
                arrayList.add("11");
                arrayList.add("12");
                arrayList.add("13");
                arrayList.add("15");
                arrayList.add("16");
                arrayList.add("17");
                arrayList.add("18");
            }
            intent.putExtra("key_to_user", q.this.contact.field_username);
            intent.putExtra("key_fav_item_id", TextUtils.join(",", arrayList));
            com.tencent.mm.plugin.fav.a.b.b(q.this.OIz.Pwc.getContext(), ".ui.FavSelectUI", intent);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14103, 1);
            AppMethodBeat.o(34507);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eib() {
            AppMethodBeat.i(34508);
            Intent intent = new Intent();
            intent.putExtra("service_app_talker_user", q.this.getTalkerUserName());
            com.tencent.mm.br.c.a(q.this.OIz.Pwc, "subapp", ".ui.openapi.ServiceAppUI", intent, (int) TbsListener.ErrorCode.UNLZMA_FAIURE);
            AppMethodBeat.o(34508);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eic() {
            AppMethodBeat.i(34509);
            if (((com.tencent.mm.plugin.flutter.a.b) g.ah(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter()) {
                ((com.tencent.mm.plugin.flutter.a.a) g.af(com.tencent.mm.plugin.flutter.a.a.class)).a(q.this.OIz.Pwc.getContext(), new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new LinkedHashMap()));
            } else {
                Intent intent = new Intent();
                intent.putExtra("download_entrance_scene", 17);
                intent.putExtra("preceding_scence", 13);
                com.tencent.mm.br.c.b(q.this.OIz.Pwc.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12065, 4);
            AppMethodBeat.o(34509);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void Qk(int i2) {
            AppMethodBeat.i(34510);
            if (!com.tencent.mm.q.a.o(q.this.OIz.Pwc.getContext(), true) && !com.tencent.mm.q.a.cC(q.this.OIz.Pwc.getContext()) && !com.tencent.mm.q.a.cA(q.this.OIz.Pwc.getContext()) && !com.tencent.mm.q.a.cE(q.this.OIz.Pwc.getContext())) {
                q.this.ami(i2);
            }
            AppMethodBeat.o(34510);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eid() {
            final int i2;
            final boolean z;
            final boolean z2;
            AppMethodBeat.i(34511);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12097, 11, 0, Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11850, 4, 1);
            q.this.lem = q.this.tOw + "_" + System.currentTimeMillis();
            final String uuid = UUID.randomUUID().toString();
            q.S(2, 0, q.this.lem);
            final b gNP = q.gNP();
            final String talkerUserName = q.this.getTalkerUserName();
            if (af.IA(talkerUserName)) {
                g.aAi();
                i2 = g.aAh().azQ().getInt(ar.a.USERINFO_LUCKY_MONEY_WEISHI_UNION_SWITCH_INT_SYNC, 0);
            } else {
                g.aAi();
                i2 = g.aAh().azQ().getInt(ar.a.USERINFO_LUCKY_MONEY_WEISHI_SWITCH_INT_SYNC, 0);
            }
            if (i2 != 1 || !gNP.Php) {
                z = false;
            } else {
                z = true;
            }
            if (q.this.PgW) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 1, 0, 0, 2, 2);
                g.aAi();
                int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_LIVE_SWITCH_INT_SYNC, (Object) 0)).intValue();
                if (!((aj) g.ah(aj.class)).showFinderEntry() || !((aj) g.ah(aj.class)).showPostEntry() || ((com.tencent.mm.plugin.i.a.ad) g.af(com.tencent.mm.plugin.i.a.ad.class)).dxX() || intValue != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z || z2) {
                    e eVar = new e((Context) q.this.OIz.Pwc.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                            a a2;
                            AppMethodBeat.i(163290);
                            mVar.d(0, q.this.OIz.Pwc.getMMResources().getString(R.string.b0v));
                            if (z2) {
                                mVar.a(1, q.this.OIz.Pwc.getMMResources().getString(R.string.j83), q.this.OIz.Pwc.getMMResources().getString(R.string.j82), 0);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 1, Long.valueOf(System.currentTimeMillis()));
                            }
                            if (z && (a2 = q.a(gNP)) != null) {
                                mVar.a(2, a2.title, a2.desc, 0);
                            }
                            AppMethodBeat.o(163290);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass4 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(163291);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    q.b(q.this, uuid);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18890, 5, 0, uuid);
                                    q.S(4, 0, q.this.lem);
                                    AppMethodBeat.o(163291);
                                    return;
                                case 1:
                                    ((aj) g.ah(aj.class)).createLuckyMoneyLive(q.this.OIz.Pwc.getContext(), q.this.getTalkerUserName());
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 2, Long.valueOf(System.currentTimeMillis()));
                                    AppMethodBeat.o(163291);
                                    return;
                                case 2:
                                    q.n(q.this);
                                    break;
                            }
                            AppMethodBeat.o(163291);
                        }
                    };
                    eVar.dGm();
                    q.o(q.this);
                    q.S(3, 0, q.this.lem);
                    AppMethodBeat.o(34511);
                    return;
                }
                q.b(q.this, uuid);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(18890, 4, 0, uuid);
                AppMethodBeat.o(34511);
            } else if ((i2 != 1 || !gNP.Php) && q.bmw(talkerUserName)) {
                q.c(q.this, uuid);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(18890, 4, 0, uuid);
                AppMethodBeat.o(34511);
            } else {
                e eVar2 = new e((Context) q.this.OIz.Pwc.getContext(), 1, false);
                eVar2.HLX = new o.f() {
                    /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass5 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                        a a2;
                        AppMethodBeat.i(163292);
                        mVar.d(0, q.this.OIz.Pwc.getMMResources().getString(R.string.b0v));
                        if (!q.bmw(talkerUserName)) {
                            ex exVar = new ex();
                            exVar.eEH = 13;
                            exVar.bfK();
                            mVar.d(1, q.this.OIz.Pwc.getMMResources().getString(R.string.b0u));
                        }
                        if (gNP.Php && i2 == 1 && (a2 = q.a(gNP)) != null) {
                            mVar.a(2, a2.title, a2.desc, 0);
                        }
                        AppMethodBeat.o(163292);
                    }
                };
                eVar2.HLY = new o.g() {
                    /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass6 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(163293);
                        Intent intent = new Intent();
                        switch (menuItem.getItemId()) {
                            case 0:
                                q.c(q.this, uuid);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(18890, 5, 0, uuid);
                                q.S(4, 0, q.this.lem);
                                AppMethodBeat.o(163293);
                                return;
                            case 1:
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 1, 0, 0, 1, 3);
                                intent.putExtra("key_username", q.this.getTalkerUserName());
                                intent.putExtra("key_way", 0);
                                intent.putExtra("pay_channel", 11);
                                com.tencent.mm.br.c.b(q.this.OIz.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", intent);
                                ex exVar = new ex();
                                exVar.eEH = 1;
                                exVar.bfK();
                                q.S(5, 0, q.this.lem);
                                AppMethodBeat.o(163293);
                                return;
                            case 2:
                                q.n(q.this);
                                break;
                        }
                        AppMethodBeat.o(163293);
                    }
                };
                eVar2.dGm();
                q.o(q.this);
                q.S(3, 0, q.this.lem);
                AppMethodBeat.o(34511);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eie() {
            AppMethodBeat.i(34512);
            bg.aVF();
            c.azQ().set(81, Boolean.FALSE);
            if (!NetStatusUtil.isNetworkConnected(q.this.OIz.Pwc.getContext())) {
                com.tencent.mm.bh.e.a(q.this.OIz.Pwc.getContext(), R.string.i3o, null);
                AppMethodBeat.o(34512);
                return;
            }
            q.this.gNK();
            AppMethodBeat.o(34512);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eif() {
            AppMethodBeat.i(34513);
            Intent intent = new Intent();
            intent.putExtra("enterprise_scene", 4);
            intent.putExtra("enterprise_biz_name", q.this.getTalkerUserName());
            intent.putExtra("biz_chat_chat_id", ((d) q.this.OIz.bh(d.class)).gPc());
            com.tencent.mm.br.c.b(q.this.OIz.Pwc.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent);
            AppMethodBeat.o(34513);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eig() {
            AppMethodBeat.i(232873);
            ((com.tencent.mm.plugin.gamelife.c) g.ah(com.tencent.mm.plugin.gamelife.c.class)).enterSendGift(q.this.OIz.Pwc.getContext(), q.this.getTalkerUserName());
            AppMethodBeat.o(232873);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eih() {
            AppMethodBeat.i(34514);
            if (q.this.PgW) {
                Intent intent = new Intent();
                intent.putExtra("enter_scene", 1);
                intent.putExtra("chatroom_name", q.this.getTalkerUserName());
                com.tencent.mm.br.c.b(q.this.OIz.Pwc.getContext(), "aa", ".ui.LaunchAAUI", intent);
            }
            AppMethodBeat.o(34514);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eii() {
            AppMethodBeat.i(34515);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14523, 0);
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(q.this.OIz.Pwc.getContext(), "android.permission.READ_EXTERNAL_STORAGE", 145, q.this.OIz.Pwc.getContext().getString(R.string.flp), q.this.OIz.Pwc.getContext().getString(R.string.gjw));
            Log.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), q.this.OIz.Pwc.getContext());
            if (!a2) {
                AppMethodBeat.o(34515);
                return;
            }
            q.this.gNI();
            AppMethodBeat.o(34515);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eik() {
            AppMethodBeat.i(179848);
            ((z) q.this.OIz.bh(z.class)).gQg();
            AppMethodBeat.o(179848);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eij() {
            AppMethodBeat.i(232874);
            if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
                Log.i("MicroMsg.ChattingFooterEventImpl", "exit in teen mode");
                ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(q.this.OIz.Pwc.getContext());
                AppMethodBeat.o(232874);
                return;
            }
            Log.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(q.this.OIz.Pwc.getContext(), "android.permission.CAMERA", 25, "", "");
            Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), q.this.OIz.Pwc.getContext());
            if (!a2) {
                AppMethodBeat.o(232874);
                return;
            }
            boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(q.this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
            Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), q.this.OIz.Pwc.getContext());
            if (!a3) {
                AppMethodBeat.o(232874);
                return;
            }
            if (!com.tencent.mm.q.a.o(q.this.OIz.Pwc.getContext(), true) && !com.tencent.mm.q.a.cC(q.this.OIz.Pwc.getContext()) && !com.tencent.mm.q.a.cA(q.this.OIz.Pwc.getContext()) && !com.tencent.mm.q.a.cE(q.this.OIz.Pwc.getContext())) {
                if (g.aAh().azQ().getInt(ar.a.USERINFO_LIVE_MODE_INT_SYNC, 0) == 1) {
                    final Activity context = q.this.OIz.Pwc.getContext();
                    l lVar = new l(context);
                    lVar.HLX = new o.f() {
                        /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass7 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                            AppMethodBeat.i(232871);
                            mVar.d(0, context.getString(R.string.efr));
                            mVar.d(1, context.getString(R.string.efq));
                            AppMethodBeat.o(232871);
                        }
                    };
                    lVar.HLY = new o.g() {
                        /* class com.tencent.mm.ui.chatting.q.AnonymousClass11.AnonymousClass8 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(232872);
                            if (i2 == 0) {
                                ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().a(q.this.OIz.Pwc.getContext(), LiveConfig.V(q.this.OIz.getTalkerUserName(), LiveConfig.hvS));
                                AppMethodBeat.o(232872);
                                return;
                            }
                            ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.this.OIz.Pwc.getContext(), LiveConfig.V(q.this.OIz.getTalkerUserName(), LiveConfig.hvS));
                            AppMethodBeat.o(232872);
                        }
                    };
                    lVar.gXI();
                    AppMethodBeat.o(232874);
                    return;
                }
                ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.this.OIz.Pwc.getContext(), LiveConfig.V(q.this.OIz.getTalkerUserName(), LiveConfig.hvS));
            }
            AppMethodBeat.o(232874);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eil() {
            AppMethodBeat.i(232875);
            Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", q.this.OIz.getTalkerUserName());
            Intent intent = new Intent();
            intent.putExtra("key_group_solitatire_create", true);
            intent.putExtra("key_group_solitatire_scene", 5);
            com.tencent.mm.plugin.groupsolitaire.c.a aVar = new com.tencent.mm.plugin.groupsolitaire.c.a();
            aVar.header = q.this.OIz.Pwc.getContext().getString(R.string.dvu) + "\n";
            aVar.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(aVar);
            aVar.separator = ".";
            aVar.yfG = 1;
            intent.putExtra("key_group_solitatire_key", aVar.field_key);
            intent.putExtra("key_group_solitatire_chatroom_username", q.this.OIz.getTalkerUserName());
            com.tencent.mm.plugin.groupsolitaire.b.b.a(q.this.OIz.getTalkerUserName(), aVar);
            ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(q.this.OIz.getTalkerUserName(), aVar);
            com.tencent.mm.br.c.b(q.this.OIz.Pwc.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", intent);
            AppMethodBeat.o(232875);
        }
    };

    public static class a {
        String desc;
        String title;
    }

    public static class b {
        boolean Php = false;
        a Phq;
        a Phr;
        a Phs;
        a Pht;
    }

    static /* synthetic */ b gNP() {
        AppMethodBeat.i(163301);
        b gNJ = gNJ();
        AppMethodBeat.o(163301);
        return gNJ;
    }

    static /* synthetic */ boolean h(q qVar) {
        AppMethodBeat.i(34550);
        boolean gNF = qVar.gNF();
        AppMethodBeat.o(34550);
        return gNF;
    }

    public q(com.tencent.mm.ui.chatting.e.a aVar, ChatFooter chatFooter, String str) {
        boolean z;
        com.tencent.mm.api.c fJ;
        c.b cG;
        AppMethodBeat.i(34518);
        this.OIz = aVar;
        this.znD = chatFooter;
        this.PgT = str;
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(str);
        this.PgW = ab.Eq(this.OIz.getTalkerUserName());
        this.PgX = ab.II(this.OIz.getTalkerUserName());
        this.Pdm = this.PgW || this.PgX;
        this.paT = (Vibrator) this.OIz.Pwc.getContext().getSystemService("vibrator");
        if (ab.Jp(this.PgT)) {
            this.PgS = new i();
            Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
        } else {
            String str2 = this.PgT;
            if (ab.JA(str2)) {
                z = true;
            } else {
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str2);
                if (!(Kn == null || !Kn.gBM() || (fJ = com.tencent.mm.al.g.fJ(Kn.field_username)) == null || (cG = fJ.cG(false)) == null)) {
                    if (cG.dhz != null) {
                        cG.dhD = "1".equals(cG.dhz.optString("CanReceiveSpeexVoice"));
                    }
                    if (cG.dhD) {
                        Log.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + Kn.field_username + " canReceiveSpeexVoice");
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                this.PgS = new com.tencent.mm.audio.b.h(this.OIz.Pwc.getContext(), true);
                Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
            } else {
                this.PgS = new com.tencent.mm.audio.b.h(this.OIz.Pwc.getContext(), false);
                Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
            }
        }
        this.PgS.a(this.znI);
        this.PgS.a(this.znH);
        chatFooter.setAppPanelListener(this.zon);
        this.PgZ = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true);
        bg.aVF();
        this.tOw = (String) com.tencent.mm.model.c.azQ().get(2, (Object) null);
        AppMethodBeat.o(34518);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean ehI() {
        AppMethodBeat.i(34519);
        synchronized (this.lock) {
            try {
                this.Pha = true;
            } catch (Throwable th) {
                AppMethodBeat.o(34519);
                throw th;
            }
        }
        if (!this.Phb) {
            Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
            AppMethodBeat.o(34519);
            return false;
        }
        this.Phb = false;
        releaseWakeLock();
        if (!gNF()) {
            this.znD.cDd();
            Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
        } else {
            this.znD.setExitType(0);
            ChatFooter chatFooter = this.znD;
            if (!chatFooter.Kkf) {
                if (1 == ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_trans_txt_edu_user_switch, 1)) {
                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(ChatFooter.KlG, 0);
                    if (sharedPreferences.getInt("trans2txt_edu_key", 0) == 0) {
                        sharedPreferences.edit().putInt("trans2txt_edu_key", 1).apply();
                        ca caVar = new ca();
                        String talkerUserName = chatFooter.Kjy.getTalkerUserName();
                        caVar.setCreateTime(bp.Kw(talkerUserName));
                        caVar.Cy(talkerUserName);
                        caVar.setContent(MMApplicationContext.getContext().getString(R.string.hyq));
                        caVar.setType(10000);
                        caVar.setStatus(6);
                        caVar.nv(0);
                        bg.aVF();
                        com.tencent.mm.model.c.aSQ().aC(caVar);
                    }
                }
            }
            this.znD.a(ChatFooter.h.SendVoice);
            Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
        }
        ((aw) this.OIz.bh(aw.class)).gRx().gMP();
        ((ao) this.OIz.bh(ao.class)).amF(4);
        ((ao) this.OIz.bh(ao.class)).stopSignalling();
        amh(1);
        ((aw) this.OIz.bh(aw.class)).a((MMFragment) this.OIz.Pwc, false);
        AppMethodBeat.o(34519);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean ehJ() {
        AppMethodBeat.i(34520);
        Log.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
        synchronized (this.lock) {
            try {
                this.Pha = true;
            } catch (Throwable th) {
                AppMethodBeat.o(34520);
                throw th;
            }
        }
        if (!this.Phb) {
            Log.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
            AppMethodBeat.o(34520);
            return false;
        }
        this.Phb = false;
        releaseWakeLock();
        this.OIz.Pwc.enableOptionMenu(true);
        this.OIz.Pwc.enableBackMenu(true);
        if (this.PgS != null) {
            this.PgS.aar();
            this.jxC.stopTimer();
            this.qPy.stopTimer();
        }
        this.znD.a(ChatFooter.h.StopRecord);
        ((aw) this.OIz.bh(aw.class)).gRx().gMP();
        ((ao) this.OIz.bh(ao.class)).amF(4);
        ((ao) this.OIz.bh(ao.class)).stopSignalling();
        amh(1);
        ((aw) this.OIz.bh(aw.class)).a((MMFragment) this.OIz.Pwc, false);
        AppMethodBeat.o(34520);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final String getFileName() {
        AppMethodBeat.i(34521);
        if (this.PgS != null) {
            String fileName = this.PgS.getFileName();
            AppMethodBeat.o(34521);
            return fileName;
        }
        AppMethodBeat.o(34521);
        return "";
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final long aas() {
        AppMethodBeat.i(34522);
        if (this.PgS != null) {
            long aas = this.PgS.aas();
            AppMethodBeat.o(34522);
            return aas;
        }
        AppMethodBeat.o(34522);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean ehL() {
        AppMethodBeat.i(34523);
        Log.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
        synchronized (this.lock) {
            try {
                this.Pha = true;
            } catch (Throwable th) {
                AppMethodBeat.o(34523);
                throw th;
            }
        }
        if (!this.Phb) {
            Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
            AppMethodBeat.o(34523);
            return false;
        }
        this.Phb = false;
        releaseWakeLock();
        ehM();
        this.znD.a(ChatFooter.h.Cancel);
        ((aw) this.OIz.bh(aw.class)).gRx().gMP();
        ((ao) this.OIz.bh(ao.class)).amF(4);
        ((ao) this.OIz.bh(ao.class)).stopSignalling();
        amh(1);
        ((aw) this.OIz.bh(aw.class)).a((MMFragment) this.OIz.Pwc, false);
        AppMethodBeat.o(34523);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012e, code lost:
        if (r8.OIz.Pwc.getContext().isFinishing() == false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0130, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(34524);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0140, code lost:
        if (android.os.Build.VERSION.SDK_INT < 17) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x014e, code lost:
        if (r8.OIz.Pwc.getContext().isDestroyed() == false) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0150, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(34524);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0156, code lost:
        r8.Phb = true;
        r0 = com.tencent.mm.plugin.transvoice.a.c.Guc;
        com.tencent.mm.plugin.transvoice.a.c.fAu().GtJ = true;
        r8.jxC.startTimer(100);
        r8.Phc = false;
        r8.qPy.startTimer(200);
        r8.znD.aix(r8.OIz.getListView().getHeight());
        r0 = ((com.tencent.mm.ui.chatting.d.b.aw) r8.OIz.bh(com.tencent.mm.ui.chatting.d.b.aw.class)).gRx();
        r0.ipv = true;
        r0.gMT();
        r0.gMO();
        r8.OIz.Pwc.enableOptionMenu(false);
        r8.OIz.Pwc.enableBackMenu(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01a5, code lost:
        if (r8.PgS == null) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a7, code lost:
        com.tencent.mm.sdk.platformtools.MMEntryLock.lock("keep_app_silent");
        r8.znD.setVoiceReactArea(-1);
        r8.PgS.hx(getTalkerUserName());
        r8.PgU = r8.PgS.getFileName();
        r8.PgS.a(r8.znI);
        r8.paT.vibrate(50);
        r8.OIz.cmy();
        gNE();
        r8.PgS.a(r8.znH);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01e1, code lost:
        r8.OIz.setKeepScreenOn(true);
        ((com.tencent.mm.ui.chatting.d.b.ao) r8.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).amF(3);
        ((com.tencent.mm.ui.chatting.d.b.ao) r8.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).keepSignalling();
        amh(0);
        ((com.tencent.mm.ui.chatting.d.b.aw) r8.OIz.bh(com.tencent.mm.ui.chatting.d.b.aw.class)).a((com.tencent.mm.ui.MMFragment) r8.OIz.Pwc, true);
        com.tencent.matrix.trace.core.AppMethodBeat.o(34524);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x021a, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return true;
     */
    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean ehN() {
        /*
        // Method dump skipped, instructions count: 551
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.q.ehN():boolean");
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehM() {
        AppMethodBeat.i(185863);
        this.OIz.Pwc.enableOptionMenu(true);
        this.OIz.Pwc.enableBackMenu(true);
        if (this.PgS != null) {
            this.PgS.cancel();
            this.jxC.stopTimer();
            this.qPy.stopTimer();
        }
        this.znD.a(ChatFooter.h.Cancel);
        AppMethodBeat.o(185863);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean aDN(String str) {
        AppMethodBeat.i(34525);
        gNE();
        this.OIz.gNY();
        boolean bmO = ((aq) this.OIz.bh(aq.class)).bmO(str);
        AppMethodBeat.o(34525);
        return bmO;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void aBt(String str) {
        AppMethodBeat.i(34526);
        ((aq) this.OIz.bh(aq.class)).aBt(str);
        AppMethodBeat.o(34526);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean eu(String str, int i2) {
        AppMethodBeat.i(34527);
        if (Util.isNullOrNil(str) || i2 <= 0 || com.tencent.mm.modelvoice.s.Ro(str) == null) {
            AppMethodBeat.o(34527);
            return false;
        }
        com.tencent.mm.modelvoice.s.aB(str, i2);
        com.tencent.mm.modelvoice.o.bid().run();
        AppMethodBeat.o(34527);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean aDO(String str) {
        AppMethodBeat.i(34528);
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.modelvoice.s.Ri(str);
            com.tencent.mm.modelvoice.o.bid().run();
            AppMethodBeat.o(34528);
            return true;
        }
        AppMethodBeat.o(34528);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehO() {
        AppMethodBeat.i(34529);
        gNE();
        this.OIz.gNY();
        AppMethodBeat.o(34529);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehP() {
        AppMethodBeat.i(34530);
        gNE();
        this.OIz.gNY();
        AppMethodBeat.o(34530);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehQ() {
        AppMethodBeat.i(232876);
        gNE();
        this.OIz.gNY();
        AppMethodBeat.o(232876);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void X(MotionEvent motionEvent) {
        AppMethodBeat.i(34531);
        if (motionEvent == null || motionEvent.getAction() == 1) {
            gNE();
            this.OIz.gNY();
        }
        AppMethodBeat.o(34531);
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    private void gNE() {
        AppMethodBeat.i(34532);
        this.OIz.BN(true);
        AppMethodBeat.o(34532);
    }

    private void releaseWakeLock() {
        AppMethodBeat.i(34533);
        this.OIz.setKeepScreenOn(false);
        AppMethodBeat.o(34533);
    }

    private boolean gNF() {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(34534);
        this.OIz.Pwc.enableOptionMenu(true);
        this.OIz.Pwc.enableBackMenu(true);
        if (this.PgS != null) {
            if (!this.PgS.isRecording() || !gNG()) {
                z2 = false;
            }
            z = this.PgS.Qt();
            this.jxC.stopTimer();
            this.qPy.stopTimer();
            if (z2) {
                gNH();
            }
            MMEntryLock.unlock("keep_app_silent");
        } else {
            Log.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
        }
        AppMethodBeat.o(34534);
        return z;
    }

    public final String getTalkerUserName() {
        AppMethodBeat.i(34535);
        if (this.contact != null && as.IG(this.contact.field_username)) {
            String str = this.PgT;
            AppMethodBeat.o(34535);
            return str;
        } else if (this.contact == null) {
            AppMethodBeat.o(34535);
            return null;
        } else {
            String str2 = this.contact.field_username;
            AppMethodBeat.o(34535);
            return str2;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void release() {
        AppMethodBeat.i(34536);
        if (this.PgV != null) {
            Log.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.PgV.release();
            this.PgV = null;
        }
        AppMethodBeat.o(34536);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void onPause() {
        AppMethodBeat.i(34537);
        if (this.PgV != null) {
            Log.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.PgV.release();
            this.PgV = null;
        }
        a.C0295a aVar = com.tencent.mm.cj.a.Owq;
        if (!a.C0295a.blI(this.PgS.getFileName())) {
            a.C0295a aVar2 = com.tencent.mm.cj.a.Owq;
            if (!a.C0295a.blK(this.PgS.getFileName())) {
                gNF();
            }
        }
        this.jxC.stopTimer();
        this.qPy.stopTimer();
        AppMethodBeat.o(34537);
    }

    private boolean gNG() {
        AppMethodBeat.i(34538);
        if (!this.contact.field_username.equals("medianote") || (com.tencent.mm.model.z.aUc() & 16384) != 0) {
            AppMethodBeat.o(34538);
            return false;
        }
        AppMethodBeat.o(34538);
        return true;
    }

    private void gNH() {
        AppMethodBeat.i(34539);
        ca caVar = new ca();
        caVar.Cy("medianote");
        caVar.setType(34);
        caVar.nv(1);
        caVar.Cz(this.PgU);
        caVar.setStatus(2);
        caVar.setContent(p.b(com.tencent.mm.model.z.aTY(), (long) this.PgS.aaq(), false));
        caVar.setCreateTime(bp.Kw("medianote"));
        if (this.PgS.aat() == 2) {
            caVar.BB("SOURCE_SILK_FILE");
        }
        bg.aVF();
        long aC = com.tencent.mm.model.c.aSQ().aC(caVar);
        if (aC <= 0) {
            Log.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
            AppMethodBeat.o(34539);
            return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(aC)));
        AppMethodBeat.o(34539);
    }

    public final void gNI() {
        AppMethodBeat.i(169859);
        Intent intent = new Intent();
        intent.setClass(this.OIz.Pwc.getContext(), FileSelectorUI.class);
        intent.putExtra("TO_USER", this.PgT);
        this.OIz.a(intent, TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, new c.a() {
            /* class com.tencent.mm.ui.chatting.q.AnonymousClass12 */

            @Override // com.tencent.mm.br.c.a
            public final void onActivityResult(int i2, int i3, Intent intent) {
                AppMethodBeat.i(169858);
                if (i2 == 227) {
                    q.a(q.this, q.this.OIz, i3, intent);
                }
                AppMethodBeat.o(169858);
            }
        });
        AppMethodBeat.o(169859);
    }

    public static void S(int i2, int i3, String str) {
        AppMethodBeat.i(163296);
        aa aaVar = new aa();
        aaVar.enl = (long) i2;
        aaVar.enn = System.currentTimeMillis();
        aaVar.eiB = aaVar.x("SessionId", str, true);
        aaVar.enm = (long) i3;
        aaVar.bfK();
        AppMethodBeat.o(163296);
    }

    public static boolean bmw(String str) {
        Integer num;
        AppMethodBeat.i(232877);
        if (af.IA(str)) {
            bg.aVF();
            num = (Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_LUCKY_MONEY_NEWYEAR_UNION_SWITCH_INT_SYNC, (Object) 0);
        } else {
            bg.aVF();
            num = (Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, (Object) 0);
        }
        bg.aVF();
        Integer num2 = (Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, (Object) 0);
        if ((num.intValue() == 1 || num2.intValue() == 1) && com.tencent.mm.model.z.aUr()) {
            AppMethodBeat.o(232877);
            return false;
        }
        AppMethodBeat.o(232877);
        return true;
    }

    private static b gNJ() {
        AppMethodBeat.i(163298);
        b bVar = new b();
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_weishi_hb_config, "");
        if (Util.isNullOrNil(a2)) {
            AppMethodBeat.o(163298);
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2);
            int i2 = jSONObject.getInt("weishi_hb_sw");
            Log.i("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() weishi_hb_sw: %s", Integer.valueOf(i2));
            if (i2 == 0) {
                bVar.Php = false;
            } else {
                bVar.Php = true;
            }
            bVar.Phq = p(jSONObject, "simple_chinese");
            bVar.Phr = p(jSONObject, "xg_traditional_chinese");
            bVar.Phs = p(jSONObject, "tw_traditional_chinese");
            bVar.Pht = p(jSONObject, "english");
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", e2.getMessage());
        }
        AppMethodBeat.o(163298);
        return bVar;
    }

    private static a p(JSONObject jSONObject, String str) {
        AppMethodBeat.i(163299);
        a aVar = null;
        if (jSONObject.has("wording")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("wording");
            if (optJSONObject.has(str)) {
                aVar = new a();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                aVar.title = optJSONObject2.optString("title");
                aVar.desc = optJSONObject2.optString("desc");
            }
        }
        AppMethodBeat.o(163299);
        return aVar;
    }

    public static a a(b bVar) {
        AppMethodBeat.i(163300);
        if (bVar == null) {
            AppMethodBeat.o(163300);
            return null;
        }
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        if (LocaleUtil.CHINA.equals(applicationLanguage)) {
            a aVar = bVar.Phq;
            AppMethodBeat.o(163300);
            return aVar;
        } else if (LocaleUtil.TAIWAN.equals(applicationLanguage)) {
            a aVar2 = bVar.Phs;
            AppMethodBeat.o(163300);
            return aVar2;
        } else if (LocaleUtil.HONGKONG.equals(applicationLanguage)) {
            a aVar3 = bVar.Phr;
            AppMethodBeat.o(163300);
            return aVar3;
        } else {
            a aVar4 = bVar.Pht;
            AppMethodBeat.o(163300);
            return aVar4;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void qY(boolean z) {
        AppMethodBeat.i(34540);
        if (z) {
            ((ao) this.OIz.bh(ao.class)).keepSignalling();
            AppMethodBeat.o(34540);
            return;
        }
        ((ao) this.OIz.bh(ao.class)).stopSignalling();
        AppMethodBeat.o(34540);
    }

    private static void amh(int i2) {
        AppMethodBeat.i(34541);
        rd rdVar = new rd();
        rdVar.dXT.state = i2;
        EventCenter.instance.publish(rdVar);
        AppMethodBeat.o(34541);
    }

    public final void gNK() {
        boolean z;
        AppMethodBeat.i(34542);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 22, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a2) {
            AppMethodBeat.o(34542);
            return;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a3) {
            AppMethodBeat.o(34542);
            return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
        Intent intent = new Intent();
        if (com.tencent.mm.bi.d.jpA.PZ(getTalkerUserName())) {
            Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.e3f, 0).show();
            AppMethodBeat.o(34542);
            return;
        }
        if (getTalkerUserName() != null) {
            List<String> aFK = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFK(getTalkerUserName());
            bg.aVF();
            String str = (String) com.tencent.mm.model.c.azQ().get(2, (Object) null);
            boolean aFH = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(getTalkerUserName());
            Iterator<String> it = aFK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (str != null && str.equals(next)) {
                    z = true;
                    break;
                }
            }
            if (aFK.size() < com.tencent.mm.plugin.multitalk.d.e.epZ() || z) {
                if (z) {
                    if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).ems()) {
                        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f64), 0).show();
                        AppMethodBeat.o(34542);
                        return;
                    }
                    Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
                }
                if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emq()) {
                    Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
                    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f64), 0).show();
                    AppMethodBeat.o(34542);
                    return;
                } else if (com.tencent.mm.q.a.cE(this.OIz.Pwc.getContext())) {
                    Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in appbrand voice!");
                    AppMethodBeat.o(34542);
                    return;
                } else if (com.tencent.mm.q.a.cB(this.OIz.Pwc.getContext())) {
                    AppMethodBeat.o(34542);
                    return;
                } else if (com.tencent.mm.q.a.p(this.OIz.Pwc.getContext(), true)) {
                    AppMethodBeat.o(34542);
                    return;
                } else if (aFH) {
                    Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
                    com.tencent.mm.ui.base.h.c(this.OIz.Pwc.getContext(), this.OIz.Pwc.getMMResources().getString(R.string.f7f), "", this.OIz.Pwc.getMMResources().getString(R.string.f5n), this.OIz.Pwc.getMMResources().getString(R.string.f5j), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.q.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(169853);
                            if (!((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(q.this.getTalkerUserName())) {
                                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f79), 0).show();
                                AppMethodBeat.o(169853);
                                return;
                            }
                            if (!((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFN(q.this.getTalkerUserName())) {
                                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f5x), 0).show();
                            }
                            AppMethodBeat.o(169853);
                        }
                    }, null);
                    AppMethodBeat.o(34542);
                    return;
                }
            } else {
                Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f6h, new StringBuilder().append(com.tencent.mm.plugin.multitalk.d.e.epZ()).toString()), 0).show();
                AppMethodBeat.o(34542);
                return;
            }
        }
        intent.putExtra("chatroomName", getTalkerUserName());
        intent.putExtra("key_need_gallery", true);
        intent.putExtra("titile", this.OIz.Pwc.getMMResources().getString(R.string.f70));
        com.tencent.mm.br.c.b(this.OIz.Pwc.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", intent);
        if (this.znD.gqJ()) {
            this.znD.setBottomPanelVisibility(8);
        }
        AppMethodBeat.o(34542);
    }

    public final void ami(final int i2) {
        AppMethodBeat.i(34543);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 18, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a2) {
            AppMethodBeat.o(34543);
        } else if (CrashReportFactory.hasDebuger() || ac.jPA) {
            l lVar = new l(this.OIz.Pwc.getContext());
            lVar.HLX = new o.f() {
                /* class com.tencent.mm.ui.chatting.q.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(169854);
                    mVar.d(1, q.this.OIz.Pwc.getMMResources().getString(R.string.um));
                    mVar.d(5, "拍摄参数设置面板");
                    AppMethodBeat.o(169854);
                }
            };
            lVar.HLY = new o.g() {
                /* class com.tencent.mm.ui.chatting.q.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(169856);
                    switch (menuItem.getItemId()) {
                        case 1:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 1);
                            SightParams sightParams = new SightParams(1, i2);
                            String Qv = t.Qv(q.this.getTalkerUserName());
                            com.tencent.mm.modelvideo.o.bhj();
                            String Qw = t.Qw(Qv);
                            com.tencent.mm.modelvideo.o.bhj();
                            RecordConfigProvider a2 = RecordConfigProvider.a(Qw, t.Qx(Qv), sightParams.irT, sightParams.irT.duration * 1000, 1);
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_ignore_remux_without_edit, false)) {
                                a2.remuxType = 2;
                            }
                            VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                            videoCaptureReportInfo.sQn = 3;
                            if (q.this.Pdm) {
                                videoCaptureReportInfo.sQn = 4;
                            }
                            a2.BOE = videoCaptureReportInfo;
                            UICustomParam.a aVar = new UICustomParam.a();
                            aVar.apE();
                            aVar.apD();
                            aVar.dz(true);
                            a2.BOn = aVar.gLU;
                            CaptureDataManager.BOb.BOa = new CaptureDataManager.c() {
                                /* class com.tencent.mm.ui.chatting.q.AnonymousClass5.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                                public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
                                    AppMethodBeat.i(169855);
                                    cly cly = new cly();
                                    cly.Mrn = true;
                                    cly.Mrm = false;
                                    SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath, com.tencent.mm.vfs.s.bpb(captureVideoNormalModel.videoPath), com.tencent.xweb.util.d.getMD5(captureVideoNormalModel.videoPath), Math.round((((float) captureVideoNormalModel.BOd.longValue()) * 1.0f) / 1000.0f), cly);
                                    if (captureVideoNormalModel.BOe.booleanValue()) {
                                        sightCaptureResult.zsy = true;
                                        sightCaptureResult.tkD = false;
                                        sightCaptureResult.zsG = captureVideoNormalModel.thumbPath;
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra("key_req_result", sightCaptureResult);
                                    ((Activity) context).setResult(-1, intent);
                                    ((Activity) context).finish();
                                    AppMethodBeat.o(169855);
                                }

                                @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                                public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
                                    return false;
                                }
                            };
                            if (q.this.PgZ) {
                                com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                                com.tencent.mm.plugin.recordvideo.jumper.a.a(q.this.OIz.Pwc.getContext(), 226, R.anim.ei, R.anim.ej, a2);
                                AppMethodBeat.o(169856);
                                return;
                            }
                            s.a(q.this.OIz.Pwc, new Intent(), q.this.getTalkerUserName(), i2);
                            AppMethodBeat.o(169856);
                            return;
                        case 5:
                            com.tencent.mm.br.c.b(q.this.OIz.Pwc.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
                            break;
                    }
                    AppMethodBeat.o(169856);
                }
            };
            lVar.gXI();
            AppMethodBeat.o(34543);
        } else {
            if (!ac.jPB) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 1);
                SightParams sightParams = new SightParams(1, i2);
                String Qv = t.Qv(getTalkerUserName());
                com.tencent.mm.modelvideo.o.bhj();
                String Qw = t.Qw(Qv);
                com.tencent.mm.modelvideo.o.bhj();
                RecordConfigProvider a3 = RecordConfigProvider.a(Qw, t.Qx(Qv), sightParams.irT, sightParams.irT.duration * 1000, 1);
                if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_ignore_remux_without_edit, false)) {
                    a3.remuxType = 2;
                }
                VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                videoCaptureReportInfo.sQn = 3;
                if (this.Pdm) {
                    videoCaptureReportInfo.sQn = 4;
                }
                a3.BOE = videoCaptureReportInfo;
                UICustomParam.a aVar = new UICustomParam.a();
                aVar.apE();
                aVar.apD();
                aVar.dz(true);
                a3.BOn = aVar.gLU;
                CaptureDataManager.BOb.BOa = new CaptureDataManager.c() {
                    /* class com.tencent.mm.ui.chatting.q.AnonymousClass6 */

                    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                    public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
                        AppMethodBeat.i(169857);
                        cly cly = new cly();
                        cly.Mrn = true;
                        cly.Mrm = false;
                        SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath, com.tencent.mm.vfs.s.bpb(captureVideoNormalModel.videoPath), com.tencent.xweb.util.d.getMD5(captureVideoNormalModel.videoPath), Math.round((((float) captureVideoNormalModel.BOd.longValue()) * 1.0f) / 1000.0f), cly);
                        if (captureVideoNormalModel.BOe.booleanValue()) {
                            sightCaptureResult.zsy = true;
                            sightCaptureResult.tkD = false;
                            sightCaptureResult.zsG = captureVideoNormalModel.thumbPath;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("key_req_result", sightCaptureResult);
                        ((Activity) context).setResult(-1, intent);
                        ((Activity) context).finish();
                        AppMethodBeat.o(169857);
                    }

                    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
                        return false;
                    }
                };
                if (this.PgZ) {
                    com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                    com.tencent.mm.plugin.recordvideo.jumper.a.a(this.OIz.Pwc.getContext(), 226, R.anim.ei, R.anim.ej, a3);
                    AppMethodBeat.o(34543);
                    return;
                }
                s.a(this.OIz.Pwc, new Intent(), getTalkerUserName(), i2);
            }
            AppMethodBeat.o(34543);
        }
    }

    public final void gNL() {
        AppMethodBeat.i(34544);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a2) {
            AppMethodBeat.o(34544);
            return;
        }
        if (this.znD.gqJ()) {
            this.znD.setBottomPanelVisibility(8);
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = getTalkerUserName();
        zjVar.efx.context = this.OIz.Pwc.getContext();
        zjVar.efx.eft = 3;
        EventCenter.instance.publish(zjVar);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11033, 4, 2, 0);
        AppMethodBeat.o(34544);
    }

    public final void gNM() {
        AppMethodBeat.i(34545);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 21, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a2) {
            AppMethodBeat.o(34545);
            return;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a3) {
            AppMethodBeat.o(34545);
            return;
        }
        if (this.znD.gqJ()) {
            this.znD.setBottomPanelVisibility(8);
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = getTalkerUserName();
        zjVar.efx.context = this.OIz.Pwc.getContext();
        zjVar.efx.eft = 2;
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(34545);
    }

    public final void eEK() {
        AppMethodBeat.i(34546);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a2) {
            AppMethodBeat.o(34546);
            return;
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = getTalkerUserName();
        zjVar.efx.context = this.OIz.Pwc.getContext();
        zjVar.efx.eft = 4;
        if (this.znD.gqJ()) {
            this.znD.setBottomPanelVisibility(8);
        }
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(34546);
    }

    public final void eEL() {
        AppMethodBeat.i(34547);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 19, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a2) {
            AppMethodBeat.o(34547);
            return;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), this.OIz.Pwc.getContext());
        if (!a3) {
            AppMethodBeat.o(34547);
            return;
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = getTalkerUserName();
        zjVar.efx.context = this.OIz.Pwc.getContext();
        zjVar.efx.eft = 2;
        if (this.znD.gqJ()) {
            this.znD.setBottomPanelVisibility(8);
        }
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(34547);
    }

    public final void gNN() {
        AppMethodBeat.i(34548);
        ((com.tencent.mm.ui.chatting.d.b.as) this.OIz.bh(com.tencent.mm.ui.chatting.d.b.as.class)).BU(false);
        this.znD.setBottomPanelVisibility(8);
        AppMethodBeat.o(34548);
    }

    public final void gNO() {
        AppMethodBeat.i(34549);
        if (!s.a((MMFragment) this.OIz.Pwc, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText(this.OIz.Pwc.getContext(), this.OIz.Pwc.getMMResources().getString(R.string.gix), 1).show();
        }
        AppMethodBeat.o(34549);
    }

    static /* synthetic */ void b(q qVar, String str) {
        AppMethodBeat.i(163302);
        Intent intent = new Intent();
        int Ie = v.Ie(qVar.getTalkerUserName());
        intent.putExtra("key_way", 1);
        intent.putExtra("key_chatroom_num", Ie);
        intent.putExtra("key_type", 1);
        intent.putExtra("key_from", 1);
        intent.putExtra("key_username", qVar.getTalkerUserName());
        intent.putExtra("key_session_id", str);
        intent.putExtra("pay_channel", 14);
        com.tencent.mm.br.c.b(qVar.OIz.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
        AppMethodBeat.o(163302);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x00a7 A[SYNTHETIC, Splitter:B:7:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void n(com.tencent.mm.ui.chatting.q r14) {
        /*
        // Method dump skipped, instructions count: 499
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.q.n(com.tencent.mm.ui.chatting.q):void");
    }

    static /* synthetic */ void o(q qVar) {
        AppMethodBeat.i(232878);
        Log.i("MicroMsg.ChattingFooterEventImpl", "do get config");
        if (af.IA(qVar.getTalkerUserName())) {
            g.azz().a(new com.tencent.mm.plugin.luckymoney.model.ar("v1.0", ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_UNION_INT_SYNC, (Object) 0)).intValue()), 0);
            AppMethodBeat.o(232878);
            return;
        }
        g.azz().a(new com.tencent.mm.plugin.luckymoney.model.aq("v1.0", ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 0)).intValue()), 0);
        AppMethodBeat.o(232878);
    }

    static /* synthetic */ void c(q qVar, String str) {
        AppMethodBeat.i(232879);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 1, 0, 0, 1, 1);
        Intent intent = new Intent();
        intent.putExtra("key_way", 0);
        intent.putExtra("key_type", 0);
        intent.putExtra("key_from", 1);
        intent.putExtra("key_username", qVar.getTalkerUserName());
        intent.putExtra("key_session_id", str);
        intent.putExtra("pay_channel", 11);
        com.tencent.mm.br.c.b(qVar.OIz.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
        AppMethodBeat.o(232879);
    }

    static /* synthetic */ void a(q qVar, com.tencent.mm.ui.chatting.e.a aVar, int i2, Intent intent) {
        int i3;
        String str;
        int i4;
        AppMethodBeat.i(163305);
        if (i2 == -1 && intent != null) {
            ((an) aVar.bh(an.class)).i(217, i2, intent);
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            if (aVar.gRM()) {
                i3 = v.Ie(qVar.PgT);
            } else {
                i3 = 0;
            }
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!Util.isNullOrNil(next)) {
                    try {
                        int lastIndexOf = next.lastIndexOf(47) + 1;
                        if (lastIndexOf < 0 || lastIndexOf == next.length()) {
                            lastIndexOf = 0;
                        }
                        str = next.substring(lastIndexOf, next.length());
                    } catch (Exception e2) {
                        Log.e("MicroMsg.ChattingFooterEventImpl", "get file name error " + e2.getMessage());
                        str = " ";
                    }
                } else {
                    str = next;
                }
                bg.aVF();
                String aB = com.tencent.mm.pluginsdk.model.app.m.aB(com.tencent.mm.model.c.aTg(), str, com.tencent.mm.vfs.s.akC(next));
                com.tencent.mm.vfs.s.nw(next, aB);
                WXFileObject wXFileObject = new WXFileObject();
                wXFileObject.setFilePath(aB);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXFileObject;
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(aB);
                wXMediaMessage.title = oVar.getName();
                wXMediaMessage.description = Util.getSizeKB(oVar.length());
                com.tencent.mm.pluginsdk.model.app.m.a(wXMediaMessage, "", "", qVar.PgT, 4, (String) null);
                int lastIndexOf2 = oVar.getName().lastIndexOf(".");
                String str2 = "";
                if (lastIndexOf2 >= 0 && lastIndexOf2 < oVar.getName().length() - 1) {
                    str2 = oVar.getName().substring(lastIndexOf2 + 1);
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[5];
                objArr[0] = Long.valueOf(oVar.length());
                objArr[1] = 0;
                if (aVar.gRM()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                objArr[2] = Integer.valueOf(i4);
                objArr[3] = Integer.valueOf(i3);
                objArr[4] = str2;
                hVar.a(14986, objArr);
            }
            String stringExtra = intent.getStringExtra("with_text_content");
            if (!Util.isNullOrNil(stringExtra)) {
                com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra, qVar.PgT);
            }
        }
        AppMethodBeat.o(163305);
    }
}
