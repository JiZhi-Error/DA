package com.tencent.mm.plugin.hp.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.s;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.HashMap;

public final class e implements m {
    final b ymE;
    private long ymF;

    public e(b bVar) {
        AppMethodBeat.i(117424);
        this.ymE = bVar;
        f.cBv();
        c.a(this);
        AppMethodBeat.o(117424);
    }

    public final boolean qk(boolean z) {
        boolean z2;
        String dZv;
        AppMethodBeat.i(117425);
        Log.i("Tinker.SyncResponseProcessor", "process tinker response: %s", this.ymE.toString());
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("updater", "closeAutoTinkerPatch")), 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(117425);
            return false;
        } else if (!this.ymE.dZw()) {
            Log.i("Tinker.SyncResponseProcessor", "process check response fail, just return");
            AppMethodBeat.o(117425);
            return false;
        } else if (this.ymE.dZx()) {
            final Context context = MMApplicationContext.getContext();
            final a lk = a.lk(context);
            if (!lk.Ska) {
                Log.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
            } else {
                Log.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process");
                new com.tencent.mm.modelmulti.m(MMApplicationContext.getContext(), new m.a() {
                    /* class com.tencent.mm.plugin.hp.b.e.AnonymousClass3 */

                    @Override // com.tencent.mm.modelmulti.m.a
                    public final void fH(boolean z) {
                        AppMethodBeat.i(117423);
                        if (!z) {
                            Log.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly");
                            ShareTinkerInternals.killAllOtherProcess(context);
                            lk.dZn();
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                            Object obj = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                            Process.killProcess(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        }
                        AppMethodBeat.o(117423);
                    }
                });
                SharePatchInfo.rewritePatchInfoFileWithLock(lk.SjW, new SharePatchInfo(lk.SjZ.Ske, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false), lk.SjX);
            }
            AppMethodBeat.o(117425);
            return true;
        } else if (!this.ymE.dZt()) {
            AppMethodBeat.o(117425);
            return true;
        } else if (this.ymE.dZy()) {
            Log.w("Tinker.SyncResponseProcessor", "is lower version skip.");
            h.INSTANCE.idkeyStat(614, 78, 1, false);
            AppMethodBeat.o(117425);
            return true;
        } else {
            if (MMApplicationContext.isMainProcess()) {
                try {
                    int intValue = Integer.decode(com.tencent.mm.loader.j.a.CLIENT_VERSION).intValue();
                    if (intValue >= 654316032 && intValue <= 654316287 && "vivo".equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT == 29 && ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enable_vivo_q_patch, 0) == 0) {
                        Log.w("Tinker.SyncResponseProcessor", "[!] [tomys] Patch was blocked due to some compatibility issues.");
                        AppMethodBeat.o(117425);
                        return true;
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("Tinker.SyncResponseProcessor", th, "[-] [tomys] Error happened in tmp ctrl code.", new Object[0]);
                }
            }
            if (CrashReportFactory.isOnlinePatchBlocked()) {
                Log.w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.");
                AppMethodBeat.o(117425);
                return true;
            } else if (this.ymE.pkI.intValue() != 3 || Util.isNullOrNil(this.ymE.clientVersion) || !com.tencent.mm.plugin.hp.d.c.aBK(this.ymE.clientVersion)) {
                Log.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s clientversion:%s", this.ymE.pkJ, this.ymE.dZv(), this.ymE.clientVersion);
                final Context context2 = MMApplicationContext.getContext();
                if (this.ymE.pkJ.intValue() != 2 || !NetStatusUtil.isMobile(MMApplicationContext.getContext()) || !this.ymE.dZu()) {
                    if (this.ymE.dZs() && !com.tencent.mm.plugin.hp.tinker.h.aU(context2, this.ymE.cri)) {
                        dZa();
                    }
                } else if (!com.tencent.mm.plugin.hp.tinker.h.aU(context2, this.ymE.cri)) {
                    if (this.ymE.pkI.intValue() == 2) {
                        i.a(MMApplicationContext.getContext().getString(R.string.dgd), MMApplicationContext.getContext().getString(R.string.dgf, this.ymE.dZv(), MMApplicationContext.getContext().getString(R.string.hsq), Util.getSizeKB((long) this.ymE.fileSize)), MMApplicationContext.getContext().getString(R.string.hsu), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.hp.b.e.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(117421);
                                if (e.this.ymE.dZs()) {
                                    e.this.dZa();
                                }
                                AppMethodBeat.o(117421);
                            }
                        }, MMApplicationContext.getContext().getString(R.string.hsi), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.hp.b.e.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(117422);
                                com.tencent.mm.plugin.hp.tinker.h.aV(context2, e.this.ymE.cri);
                                AppMethodBeat.o(117422);
                            }
                        });
                    } else if (this.ymE.pkI.intValue() == 3) {
                        Log.i("Tinker.SyncResponseProcessor", "showUpdateDialog ");
                        if (Util.isNullOrNil(this.ymE.dZv())) {
                            dZv = context2.getString(R.string.ht1);
                        } else {
                            dZv = this.ymE.dZv();
                        }
                        eht eht = new eht();
                        eht.cri = this.ymE.cri;
                        eht.title = context2.getString(R.string.dgd);
                        eht.Nhk = context2.getString(R.string.hsu);
                        eht.xWM = context2.getString(R.string.hsi);
                        eht.ynv = this.ymE.ynv;
                        eht.ynw = this.ymE.ynw;
                        eht.nJK = this.ymE.fileSize;
                        eht.pkK = this.ymE.pkK;
                        eht.patchMd5 = this.ymE.pkL;
                        eht.versionCode = this.ymE.versionCode;
                        eht.Nhj = d.aBN(this.ymE.ynv);
                        try {
                            eht.Nhl = d.aBM(this.ymE.clientVersion);
                        } catch (Exception e2) {
                        }
                        eht.msg = dZv;
                        d.a(eht);
                    }
                    a.OO(4);
                } else {
                    h.INSTANCE.idkeyStat(614, 44, 1, false);
                    Log.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", this.ymE.cri);
                }
                AppMethodBeat.o(117425);
                return true;
            } else {
                h.INSTANCE.idkeyStat(614, 77, 1, false);
                com.tencent.mm.plugin.hp.d.b bVar = this.ymE;
                Context context3 = MMApplicationContext.getContext();
                String string = Util.isNullOrNil(bVar.ynx) ? context3.getString(R.string.yb) : bVar.ynx;
                String str = Util.isNullOrNil(bVar.yny) ? "" : bVar.yny;
                String str2 = Util.isNullOrNil(bVar.ynz) ? HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : bVar.ynz;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.setFlags(872415232);
                PendingIntent activity = PendingIntent.getActivity(context3, 0, intent, 268435456);
                s.c g2 = com.tencent.mm.bq.a.cd(context3, "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(string).g(str);
                g2.Hv = activity;
                g2.as(com.tencent.mm.bq.a.ezb());
                Notification build = g2.build();
                build.flags |= 16;
                if (z) {
                    ((NotificationManager) context3.getSystemService("notification")).notify(19841110, build);
                } else {
                    Log.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
                }
                AppMethodBeat.o(117425);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dZa() {
        String dZv;
        AppMethodBeat.i(117426);
        if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted")) {
            Log.e("Tinker.SyncResponseProcessor", "no sdcard.");
            h.INSTANCE.idkeyStat(614, 50, 1, false);
            AppMethodBeat.o(117426);
        } else if (!com.tencent.mm.compatible.util.e.yV((long) this.ymE.fileSize)) {
            Log.e("Tinker.SyncResponseProcessor", "sdcard is full.");
            h.INSTANCE.idkeyStat(614, 51, 1, false);
            if (this.ymE.pkI.intValue() == 3) {
                h.INSTANCE.idkeyStat(614, 55, 1, false);
            }
            AppMethodBeat.o(117426);
        } else if (this.ymE.pkI.intValue() != 3 || Util.isNullOrNil(this.ymE.ynv) || !com.tencent.mm.vfs.s.YS(d.aBN(this.ymE.ynv)) || !com.tencent.mm.d.a.fP(d.aBN(this.ymE.ynv))) {
            this.ymE.pkI.intValue();
            dZb();
            AppMethodBeat.o(117426);
        } else {
            Context context = MMApplicationContext.getContext();
            if (Util.isNullOrNil(this.ymE.dZv())) {
                dZv = context.getString(R.string.ht1);
            } else {
                dZv = this.ymE.dZv();
            }
            eht eht = new eht();
            eht.cri = this.ymE.cri;
            eht.title = context.getString(R.string.dgd);
            eht.Nhk = context.getString(R.string.e3o);
            eht.xWM = context.getString(R.string.hsi);
            eht.ynv = this.ymE.ynv;
            eht.ynw = this.ymE.ynw;
            eht.nJK = this.ymE.fileSize;
            eht.pkK = this.ymE.pkK;
            eht.patchMd5 = this.ymE.pkL;
            eht.versionCode = this.ymE.versionCode;
            eht.Nhj = d.aBN(this.ymE.ynv);
            try {
                eht.Nhl = d.aBM(this.ymE.clientVersion);
            } catch (Exception e2) {
            }
            eht.msg = dZv;
            d.a(eht);
            Log.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", this.ymE.ynv);
            AppMethodBeat.o(117426);
        }
    }

    private void dZb() {
        AppMethodBeat.i(117427);
        MMApplicationContext.getContext();
        d.dZA();
        d.dZB();
        g.a aVar = new g.a();
        aVar.alj(this.ymE.pkK);
        aVar.all(this.ymE.cri);
        aVar.setFileMD5(this.ymE.pkL);
        aVar.kS(false);
        aVar.kU(true);
        aVar.Fl(2);
        aVar.kT(false);
        this.ymF = f.cBv().a(aVar.qIY);
        Log.i("Tinker.SyncResponseProcessor", "Download task id is :%d", Long.valueOf(this.ymF));
        h.INSTANCE.idkeyStat(614, 2, 1, false);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            h.INSTANCE.idkeyStat(614, 7, 1, false);
        } else {
            h.INSTANCE.idkeyStat(614, 8, 1, false);
        }
        if (this.ymE.pkI.intValue() == 2 && !Util.isNullOrNil(this.ymE.clientVersion)) {
            com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, this.ymE.clientVersion).dZi();
        }
        if (this.ymE.pkI.intValue() == 3) {
            h.INSTANCE.idkeyStat(614, 56, 1, false);
            Log.d("Tinker.SyncResponseProcessor", "boots download start silent.");
        }
        AppMethodBeat.o(117427);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void k(long j2, String str) {
        AppMethodBeat.i(117428);
        Log.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", Long.valueOf(j2));
        AppMethodBeat.o(117428);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, String str, boolean z) {
        File file;
        File[] listFiles;
        AppMethodBeat.i(117429);
        Log.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", Long.valueOf(j2), str, Boolean.valueOf(z));
        if (this.ymF != j2) {
            Log.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.ymF), Long.valueOf(j2));
            AppMethodBeat.o(117429);
            return;
        }
        b.OP(2);
        Context context = MMApplicationContext.getContext();
        File file2 = new File(com.tencent.mm.vfs.s.k(str, false));
        ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
        boolean z2 = false;
        try {
            z2 = shareSecurityCheck.verifyPatchMetaSignature(file2);
        } catch (Exception e2) {
            Log.printErrStackTrace("Tinker.SyncResponseProcessor", e2, "verify patch signature failed.", new Object[0]);
            h.INSTANCE.idkeyStat(614, 39, 1, false);
        }
        if (this.ymE.pkI.intValue() != 2 || z2) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                file = null;
            } else {
                file = new File(applicationInfo.dataDir, "tinker_server");
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            if (!(file == null || (listFiles = file.listFiles()) == null)) {
                String name = file2.getName();
                for (File file3 : listFiles) {
                    if (!file3.getName().equals(name)) {
                        SharePatchFileUtil.safeDeleteFile(file3);
                    }
                }
            }
            switch (this.ymE.pkI.intValue()) {
                case 1:
                    Log.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                    break;
                case 2:
                    Log.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply");
                    if (!MMApplicationContext.isToolsIsolatedProcess()) {
                        if (!CrashReportFactory.isOnlinePatchBlocked()) {
                            if (!ag.a.dmC.WN()) {
                                Log.w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.");
                                break;
                            } else {
                                HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
                                if (packagePropertiesIfPresent != null) {
                                    String str2 = packagePropertiesIfPresent.get("patch.client.ver");
                                    if (!TextUtils.isEmpty(str2)) {
                                        com.tencent.mm.plugin.hp.tinker.b ii = com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, str2);
                                        ii.dZk();
                                        ii.dZj();
                                    } else {
                                        Log.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
                                    }
                                }
                                com.tencent.tinker.lib.e.c.cY(context, file2.getAbsolutePath());
                                break;
                            }
                        } else {
                            Log.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.");
                            break;
                        }
                    }
                    break;
                case 3:
                    String absolutePath = file2.getAbsolutePath();
                    com.tencent.mm.plugin.hp.d.b bVar = this.ymE;
                    Log.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", absolutePath, bVar.ynv);
                    com.tencent.mm.kernel.g.aAk().postToWorker(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01c1: INVOKE  
                          (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x01b8: INVOKE  (r5v5 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                          (wrap: com.tencent.mm.plugin.hp.a.a$1 : 0x01be: CONSTRUCTOR  (r6v7 com.tencent.mm.plugin.hp.a.a$1) = 
                          (wrap: java.lang.String : 0x01b4: INVOKE  (r4v8 java.lang.String) = 
                          (wrap: java.lang.String : 0x01b2: IGET  (r4v7 java.lang.String) = (r3v10 'bVar' com.tencent.mm.plugin.hp.d.b) com.tencent.mm.plugin.hp.d.b.ynv java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.hp.d.d.aBN(java.lang.String):java.lang.String)
                          (r11v0 'context' android.content.Context)
                          (r2v16 'absolutePath' java.lang.String)
                          (r3v10 'bVar' com.tencent.mm.plugin.hp.d.b)
                         call: com.tencent.mm.plugin.hp.a.a.1.<init>(java.lang.String, android.content.Context, java.lang.String, com.tencent.mm.plugin.hp.d.b):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.plugin.hp.b.e.b(long, java.lang.String, boolean):void, file: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01be: CONSTRUCTOR  (r6v7 com.tencent.mm.plugin.hp.a.a$1) = 
                          (wrap: java.lang.String : 0x01b4: INVOKE  (r4v8 java.lang.String) = 
                          (wrap: java.lang.String : 0x01b2: IGET  (r4v7 java.lang.String) = (r3v10 'bVar' com.tencent.mm.plugin.hp.d.b) com.tencent.mm.plugin.hp.d.b.ynv java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.hp.d.d.aBN(java.lang.String):java.lang.String)
                          (r11v0 'context' android.content.Context)
                          (r2v16 'absolutePath' java.lang.String)
                          (r3v10 'bVar' com.tencent.mm.plugin.hp.d.b)
                         call: com.tencent.mm.plugin.hp.a.a.1.<init>(java.lang.String, android.content.Context, java.lang.String, com.tencent.mm.plugin.hp.d.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.hp.b.e.b(long, java.lang.String, boolean):void, file: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 28 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.hp.a.a, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 34 more
                        */
                    /*
                    // Method dump skipped, instructions count: 476
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hp.b.e.b(long, java.lang.String, boolean):void");
                }

                @Override // com.tencent.mm.plugin.downloader.model.m
                public final void b(long j2, int i2, boolean z) {
                    AppMethodBeat.i(117430);
                    Log.w("Tinker.SyncResponseProcessor", "onTaskFailed");
                    if (this.ymF != j2) {
                        Log.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.ymF), Long.valueOf(j2));
                        AppMethodBeat.o(117430);
                        return;
                    }
                    b.OQ(2);
                    if (this.ymE.pkI.intValue() == 3) {
                        h.INSTANCE.idkeyStat(614, 51, 1, false);
                    }
                    f.cBv();
                    c.b(this);
                    AppMethodBeat.o(117430);
                }

                @Override // com.tencent.mm.plugin.downloader.model.m
                public final void Bd(long j2) {
                    AppMethodBeat.i(117431);
                    Log.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", Long.valueOf(j2));
                    f.cBv();
                    c.b(this);
                    AppMethodBeat.o(117431);
                }

                @Override // com.tencent.mm.plugin.downloader.model.m
                public final void Be(long j2) {
                    AppMethodBeat.i(117432);
                    Log.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", Long.valueOf(j2));
                    AppMethodBeat.o(117432);
                }

                @Override // com.tencent.mm.plugin.downloader.model.m
                public final void a(long j2, String str, long j3, long j4) {
                    AppMethodBeat.i(196771);
                    Log.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", Long.valueOf(j2));
                    AppMethodBeat.o(196771);
                }

                @Override // com.tencent.mm.plugin.downloader.model.m
                public final void l(long j2, String str) {
                    AppMethodBeat.i(117434);
                    Log.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", Long.valueOf(j2), str);
                    AppMethodBeat.o(117434);
                }

                @Override // com.tencent.mm.plugin.downloader.model.m
                public final void Bf(long j2) {
                }
            }
