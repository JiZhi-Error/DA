package com.tencent.mm.app;

import android.content.ContextWrapper;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.kinda.debug.api.IPluginKindaReload;
import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.a;
import com.tencent.mm.co.k;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.l.a;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.recordvideo.res.PluginVideoRes;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.splash.h;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkEnvironment;

public class i extends d {
    private static boolean dkL = true;
    private k dkJ = new k();
    private volatile boolean dkK = false;

    public i() {
        AppMethodBeat.i(160118);
        AppMethodBeat.o(160118);
    }

    static /* synthetic */ void Wn() {
        AppMethodBeat.i(160126);
        Wl();
        AppMethodBeat.o(160126);
    }

    @Override // com.tencent.mm.kernel.a.d, com.tencent.mm.kernel.a.b
    public void VZ() {
        AppMethodBeat.i(160119);
        super.VZ();
        a.k("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
        MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        t.d(true, g.aAe().azG().mProcessName);
        ab.ab(a.C0281a.class);
        ab.gm("com.tencent.mm.boot");
        ab.a(g.aAe().azG().ca, g.aAe().azG().ca.getResources());
        XWalkEnvironment.setForceDarkMode(ao.isDarkMode());
        if (MMApplicationContext.isAppBrandProcess()) {
            a.C0367a.a(new com.tencent.mm.l.a() {
                /* class com.tencent.mm.app.i.AnonymousClass1 */

                @Override // com.tencent.mm.l.a
                public final boolean Wo() {
                    AppMethodBeat.i(160132);
                    com.tencent.mm.cr.d.a(WebView.c.WV_KIND_CW);
                    boolean hiB = com.tencent.mm.cr.d.hiB();
                    AppMethodBeat.o(160132);
                    return hiB;
                }
            });
        }
        XWalkEnvironment.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
        AppMethodBeat.o(160119);
    }

    @Override // com.tencent.mm.kernel.a.b
    public void Wa() {
        AppMethodBeat.i(160120);
        g.aAd().hqx = com.tencent.mm.plugin.zero.a.d.class;
        al(PluginZero.class);
        al(PluginMessengerFoundation.class);
        al(PluginReport.class);
        al(PluginAuth.class);
        al(PluginBigBallOfMud.class);
        al(PluginRecovery.class);
        FW("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
        FW("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
        FW("com.tencent.mm.plugin.avatar.PluginAvatar");
        FW("com.tencent.mm.plugin.image.PluginImageBase");
        FW("com.tencent.mm.plugin.comm.PluginComm");
        FW("com.tencent.mm.plugin.audio.PluginVoice");
        FW("com.tencent.mm.plugin.biz.PluginBiz");
        FX("com.tencent.mm.plugin.bizui.PluginBIZUI");
        FW("com.tencent.mm.plugin.brandservice.PluginBrandService");
        FW("com.tencent.mm.plugin.readerapp.PluginReaderApp");
        FW("com.tencent.mm.plugin.notification.PluginNotification");
        FW("com.tencent.mm.plugin.messenger.PluginMessenger");
        FW("com.tencent.mm.plugin.notification.PluginPNotification");
        FW("com.tencent.mm.plugin.welab.PluginWelab");
        FW("com.tencent.mm.plugin.sport.PluginSport");
        FW("com.tencent.mm.plugin.fts.PluginFTS");
        FW("com.tencent.mm.plugin.multitask.PluginMultiTask");
        FW("com.tencent.mm.plugin.taskbar.PluginTaskBar");
        FW("com.tencent.mm.plugin.updater.PluginUpdater");
        FW("com.tencent.mm.openim.PluginOpenIM");
        FX("com.tencent.mm.plugin.misc.PluginMisc");
        FW("com.tencent.mm.openim.room.PluginOpenIMRoom");
        FW("com.tencent.mm.roomsdk.PluginRoomSdk");
        FW("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
        FW("com.tencent.mm.plugin.abtest.PluginABTest");
        FW("com.tencent.mm.plugin.expt.PluginExpt");
        FW("com.tencent.mm.plugin.ai.PluginAi");
        FW("com.tencent.mm.plugin.backup.PluginBackup");
        FW("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
        FW("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
        FW("com.tencent.mm.plugin.teenmode.PluginTeenMode");
        FX("com.tencent.mm.plugin.secdata.PluginSecData");
        FX("com.tencent.mm.plugin.performance.PluginPerformance");
        FX("com.tencent.mm.plugin.chatroom.PluginChatroom");
        FX("com.tencent.mm.PluginFunctionMsg");
        FX("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
        FX("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
        FX("com.tencent.mm.plugin.handoff.PluginHandOff");
        FX("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
        FX("com.tencent.mm.plugin.ball.PluginBall");
        FX("com.tencent.mm.plugin.uishow.PluginUIShow");
        FX("com.tencent.mm.plugin.emoji.PluginEmoji");
        FX("com.tencent.mm.plugin.eggspring.PluginEggSpring");
        FX("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
        FX("com.tencent.mm.plugin.patmsg.PluginPatMsg");
        FX("com.tencent.mm.plugin.game.PluginGame");
        FX("com.tencent.mm.game.report.PluginGameReport");
        FX("com.tencent.mm.plugin.wepkg.PluginWePkg");
        FX("com.tencent.mm.plugin.game.commlib.PluginCommLib");
        FX("com.tencent.mm.plugin.gamelife.PluginGameLife");
        FX("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
        FX("com.tencent.mm.plugin.video.PluginVideo");
        FX("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
        FX("com.tencent.mm.plugin.sns.PluginSns");
        FX("com.tencent.mm.plugin.downloader.PluginDownloader");
        FX("com.tencent.mm.plugin.fav.PluginFav");
        FX("com.tencent.mm.plugin.fav.ui.PluginFavUI");
        FX("com.tencent.mm.plugin.record.PluginRecord");
        FX("com.tencent.mm.plugin.music.PluginMusic");
        FX("com.tencent.mm.plugin.MMPhotoEditPlugin");
        FX("com.tencent.mm.plugin.account.PluginAccount");
        b.a aVar = b.BMn;
        FX(b.a.getCLASS());
        FX("com.tencent.mm.plugin.facedetect.PluginFace");
        FX("com.tencent.mm.plugin.soter.PluginSoter");
        FX("com.tencent.mm.plugin.walletlock.PluginWalletLock");
        FX("com.tencent.mm.plugin.wxpay.PluginWxPay");
        FX("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
        FX("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
        FX(IPluginWxKindaApi.CLASS);
        FX("com.tencent.mm.plugin.festival.PluginFestival");
        if (BuildInfo.ENABLE_PAYTEST) {
            FX("com.tencent.mm.plugin.paytest.api.PluginPayTestHeaderApi");
        }
        FX("com.tencent.mm.plugin.radar.PluginRadar");
        FX("com.tencent.mm.plugin.topstory.PluginTopStory");
        FX("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
        FX("com.tencent.mm.plugin.websearch.PluginWebSearch");
        FX("com.tencent.mm.plugin.textstatus.PluginTextStatus");
        FX("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
        FX("com.tencent.mm.plugin.card.PluginCard");
        FX("com.tencent.mm.plugin.card.compat.PluginCardCompat");
        FX("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
        FX("com.tencent.mm.plugin.monitor.PluginMonitor");
        FW("com.tencent.mm.plugin.expansions.PluginExpansions");
        FX("com.tencent.mm.plugin.fcm.PluginFCM");
        FX("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
        FX("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
        FX("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
        FX("com.tencent.mm.plugin.webview.PluginWebView");
        FX("com.tencent.mm.plugin.priority.PluginPriority");
        FX("com.tencent.mm.plugin.qqmail.PluginQQMail");
        FX("com.tencent.mm.plugin.scanner.PluginScanTranslation");
        FX("com.tencent.mm.plugin.scanner.PluginScanner");
        FX("com.tencent.mm.plugin.newtips.PluginNewTips");
        FX("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
        FX("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
        FX("com.tencent.mm.plugin.editor.PluginEditor");
        FX("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
        FX("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
        FX("com.tencent.mm.plugin.selectrecord.PluginSelectRecord");
        FX("com.tencent.mm.contact.PluginContact");
        FX("com.tencent.mm.plugin.kidswatch.PluginKidsWatch");
        FX("com.tencent.mm.plugin.hld.PluginHld");
        FX("com.tencent.mm.plugin.mv.PluginMv");
        FX("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
        FX("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
        FX("com.tencent.mm.plugin.multimediareport.PluginMultiMediaReport");
        FX("com.tencent.mm.plugin.normsg.PluginNormsg");
        FX("com.tencent.mm.plugin.netmock.PluginNetMock");
        FX(IPluginKindaReload.CLASS);
        FX("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
        if (BuildInfo.ext.getBoolean("ENABLE_STETHO")) {
            FX("com.tencent.mm.plugin.stetho.PluginStetho");
        }
        FX("com.tencent.mm.plugin.notifymessage.PluginNotifyMessage");
        FX("com.tencent.mm.plugin.boots.PluginBoots");
        FX("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
        FX("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
        FX("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
        FX("com.tencent.mm.plugin.story.PluginStory");
        FX("com.tencent.mm.plugin.finder.PluginFinder");
        FX("com.tencent.mm.plugin.byp.PluginByp");
        FX("com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer");
        FX("com.tencent.mm.plugin.audio.PluginAudio");
        FX("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
        FX("com.tencent.mm.plugin.flutter.PluginFlutter");
        FX("com.tencent.mm.plugin.box.PluginBox");
        FX("com.tencent.mm.plugin.lite.PluginLiteApp");
        FX("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
        FX("com.tencent.mm.gpu.PluginGpuRes");
        FX("com.tencent.mm.live.PluginLive");
        FX(PluginVideoRes.class.getCanonicalName());
        FX("com.tencent.mm.wlogcat.PluginLogcat");
        FX("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
        FX("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
        com.tencent.mm.kernel.a.b.g gVar = c.aAu().hrT;
        gVar.hti.put(com.tencent.mm.kernel.api.c.class, g.ah(s.class));
        AppMethodBeat.o(160120);
    }

    @Override // com.tencent.mm.kernel.a.d, com.tencent.mm.kernel.a.b
    public final void a(final com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(160121);
        y.g(gVar);
        Wl();
        if (g.aAe().azG().aBb()) {
            new MMHandler("Startup-SideWork").post(new Runnable() {
                /* class com.tencent.mm.app.i.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(160137);
                    try {
                        k kVar = i.this.dkJ;
                        synchronized (kVar.mLock) {
                            try {
                                kVar.mLock[0] = -1;
                                j.i("MicroMsg.WxWaitingLock", "markUse %s", kVar);
                            } catch (Throwable th) {
                                AppMethodBeat.o(160137);
                                throw th;
                            }
                        }
                        i.this.dkJ.done();
                        ContextWrapper contextWrapper = new ContextWrapper(gVar.ca);
                        com.tencent.mm.kiss.a.b aBh = com.tencent.mm.kiss.a.b.aBh();
                        String serialTag = com.tencent.mm.kiss.a.a.aBg().mHandler.getSerialTag();
                        LayoutInflater jQ = aa.jQ(contextWrapper);
                        if (!aBh.mInitialized) {
                            aBh.mInitialized = true;
                            aBh.mInflater = jQ;
                            aBh.htL = serialTag;
                            aBh.mMode = 2;
                            aBh.htM = new MMHandler(aBh.htL) {
                                /* class com.tencent.mm.kiss.a.b.AnonymousClass1 */

                                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                                public final void handleMessage(Message message) {
                                    AppMethodBeat.i(140996);
                                    Log.i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
                                    c cVar = (c) message.obj;
                                    int size = cVar.dpI - cVar.htX.size();
                                    int i2 = cVar.Ve;
                                    Log.i("KISS.InflateRecycler", "InflateViewRecycler for %s", cVar.htZ);
                                    for (int i3 = 0; i3 < size; i3++) {
                                        try {
                                            View inflate = b.this.mInflater.inflate(i2, cVar.hub, false);
                                            if (!(cVar.hua == null || cVar.hua.length == 0)) {
                                                for (int i4 = 0; i4 < cVar.hua.length; i4 += 2) {
                                                    View findViewById = inflate.findViewById(cVar.hua[i4]);
                                                    if (findViewById != null && (findViewById instanceof ViewStub)) {
                                                        int i5 = cVar.hua[i4 + 1];
                                                        if (i5 != 0) {
                                                            ((ViewStub) findViewById).setLayoutResource(i5);
                                                        }
                                                        ((ViewStub) findViewById).inflate();
                                                    }
                                                }
                                            }
                                            synchronized (cVar) {
                                                try {
                                                    cVar.htX.add(inflate);
                                                } catch (Throwable th) {
                                                    AppMethodBeat.o(140996);
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e2) {
                                            Log.printErrStackTrace("KISS.InflateRecycler", e2, "pre inflate failed.", new Object[0]);
                                        }
                                    }
                                    Log.i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
                                    Log.i("KISS.InflateRecycler", "preload done");
                                    AppMethodBeat.o(140996);
                                }
                            };
                            if (com.tencent.mm.compatible.util.d.oE(26)) {
                                com.tencent.mm.kiss.a.b.htO = new b.a(serialTag);
                            }
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.DefaultBootStep", e2, "", new Object[0]);
                        com.tencent.mm.blink.a.t(10, 1);
                        Log.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", MMApplicationContext.getResources(), gVar.ca.getResources(), gVar.ca.getResources().getAssets());
                        i.a(i.this, gVar);
                        i.this.dkK = true;
                    } finally {
                        i.this.dkJ.done();
                        AppMethodBeat.o(160137);
                    }
                }
            });
        }
        super.a(gVar);
        AppMethodBeat.o(160121);
    }

    private static void Wl() {
        AppMethodBeat.i(160122);
        long currentTimeMillis = System.currentTimeMillis();
        ab.WH();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        com.tencent.mm.blink.a.t(4, currentTimeMillis2);
        com.tencent.mm.blink.a.t(5, 1);
        Log.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", Long.valueOf(currentTimeMillis2));
        AppMethodBeat.o(160122);
    }

    @Override // com.tencent.mm.kernel.a.d, com.tencent.mm.kernel.a.b
    public final void b(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(160123);
        if (g.aAe().azG().aBb()) {
            k kVar = this.dkJ;
            synchronized (kVar.mLock) {
                try {
                    if (kVar.mLock[0] == -1) {
                        j.i("MicroMsg.WxWaitingLock", "waiting %s", kVar);
                        kVar.mLock.wait();
                        j.i("MicroMsg.WxWaitingLock", "after waiting %s", kVar);
                    }
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.WxWaitingLock", e2, "", new Object[0]);
                }
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(160123);
                    throw th;
                }
            }
            if (this.dkK) {
                Log.e("MicroMsg.DefaultBootStep", "SVG still failed!");
            }
        }
        super.b(gVar);
        AppMethodBeat.o(160123);
    }

    @Override // com.tencent.mm.kernel.a.d
    public final boolean Wm() {
        AppMethodBeat.i(160124);
        if (dkL) {
            AppMethodBeat.o(160124);
            return true;
        } else if (!g.aAe().azG().aBb()) {
            AppMethodBeat.o(160124);
            return true;
        } else {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azo() || !g.aAf().azp()) {
                AppMethodBeat.o(160124);
                return true;
            } else if (h.NLB.size() != 1 || !MMApplicationContext.getLaunchName().equals(h.bb(h.NLB.get(0)))) {
                AppMethodBeat.o(160124);
                return true;
            } else {
                Log.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
                AppMethodBeat.o(160124);
                return false;
            }
        }
    }

    static /* synthetic */ void a(i iVar, final com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(160125);
        new SyncTask() {
            /* class com.tencent.mm.app.i.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(160133);
                i.Wn();
                AppMethodBeat.o(160133);
                return null;
            }
        }.exec(new MMHandler(Looper.getMainLooper()));
        AppMethodBeat.o(160125);
    }
}
