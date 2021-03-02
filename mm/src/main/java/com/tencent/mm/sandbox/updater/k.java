package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.s;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.d.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.PermissionActivity;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements a, h {
    public int EtH;
    public String[] NEQ;
    public int NEo;
    c NFH;
    ArrayList<h> NFI;
    public String[] NFJ;
    public String NFK;
    public i NFL;
    public i.a NFM;
    public boolean NFN;
    public boolean NFO;
    public boolean NFP;
    public String NFQ;
    public boolean NFR;
    boolean NFS;
    long NFT;
    g NFU;
    private long NFV;
    private b.a NFW;
    public String desc;
    public String djj;
    public byte[] ees;
    private Intent intent;
    public byte[] jDo;
    public byte[] jDs;
    public int jjS;
    private Notification kYy;
    protected Context mContext;
    public String md5;
    public int size;
    public int uin;
    public int updateMode;

    /* synthetic */ k(byte b2) {
        this();
    }

    static /* synthetic */ void c(k kVar) {
        AppMethodBeat.i(32795);
        kVar.gwz();
        AppMethodBeat.o(32795);
    }

    static /* synthetic */ void d(k kVar) {
        AppMethodBeat.i(32796);
        kVar.gwy();
        AppMethodBeat.o(32796);
    }

    static final class a {
        public static final k NFZ = new k((byte) 0);

        static {
            AppMethodBeat.i(32770);
            AppMethodBeat.o(32770);
        }
    }

    private k() {
        AppMethodBeat.i(32771);
        this.NFH = null;
        this.NFI = new ArrayList<>(1);
        this.jjS = d.KyO;
        this.NFN = false;
        this.NFO = false;
        this.NFP = false;
        this.NFR = false;
        this.NFS = false;
        this.intent = null;
        this.kYy = null;
        this.mContext = null;
        this.NFU = new g(this);
        this.NFV = -1;
        this.NFW = new b.a() {
            /* class com.tencent.mm.sandbox.updater.k.AnonymousClass2 */

            @Override // com.tencent.mm.sandbox.b.a
            public final void fn(int i2, int i3) {
                AppMethodBeat.i(32766);
                Log.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (k.this.EtH != 2) {
                    k.a(k.this, i3, i2);
                }
                k.this.fn(i2, i3);
                AppMethodBeat.o(32766);
            }

            @Override // com.tencent.mm.sandbox.b.a
            public final void b(int i2, int i3, dpc dpc) {
                boolean z;
                AppMethodBeat.i(32767);
                k.this.NFS = false;
                k.this.NFU.stop();
                k.this.NFT = System.currentTimeMillis();
                if (k.this.NFH == null) {
                    k.this.bC(2, true);
                    AppMethodBeat.o(32767);
                } else if (i2 == 200 && i3 == 0) {
                    Log.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
                    if (k.this.EtH != 2) {
                        k.a(k.this, 100, 100);
                    }
                    if (k.this.NFN) {
                        j.aK(k.this.mContext, 0);
                    } else {
                        j.aK(k.this.mContext, 9);
                    }
                    SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", g.aps());
                    k.this.NFK = sharedPreferences.getString(MMApplicationContext.getPackageName(), "");
                    Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", k.this.NFK, k.this.NFH.gvY());
                    if (Util.isNullOrNil(k.this.NFK) || BuildInfo.IS_FLAVOR_RED) {
                        h.INSTANCE.idkeyStat(322, 8, 1, false);
                        h.INSTANCE.a(11098, Integer.valueOf((int) WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED));
                    } else {
                        try {
                            com.tencent.mm.d.c.g(new File(s.k(k.this.NFH.gvY(), true)), k.this.NFK);
                            Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
                            h.INSTANCE.idkeyStat(322, 6, 1, false);
                            h.INSTANCE.a(11098, Integer.valueOf((int) WearableStatusCodes.DUPLICATE_CAPABILITY), k.this.NFK);
                        } catch (Exception e2) {
                            Log.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + e2.getMessage());
                            h.INSTANCE.idkeyStat(322, 7, 1, false);
                            h.INSTANCE.a(11098, Integer.valueOf((int) WearableStatusCodes.UNKNOWN_CAPABILITY), e2.getMessage());
                        }
                    }
                    if (k.this.EtH == 1) {
                        j.aL(k.this.mContext, 8);
                        k.a(k.this);
                        k.this.aNH(k.this.NFH.gvY());
                        if (k.this.NFR) {
                            h.INSTANCE.idkeyStat(614, 58, 1, false);
                            Log.d("MicroMsg.UpdaterManager", "boots download success.");
                        }
                    } else if (k.this.EtH == 0) {
                        k.this.aNH(k.this.NFH.gvY());
                    } else if (k.this.EtH == 2) {
                        j.aL(k.this.mContext, 1);
                        k.a(k.this);
                    }
                    j.gwu();
                    AppMethodBeat.o(32767);
                } else if (i3 == -13) {
                    Log.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
                    UpdaterService.fK();
                    AppUpdaterUI.gwc();
                    j.gwt();
                    AppMethodBeat.o(32767);
                } else {
                    if (!(k.this.NFH instanceof c) || k.this.NEo == 4) {
                        Log.e("MicroMsg.UpdaterManager", "update failed");
                        j.aK(k.this.mContext, 10);
                        if (k.this.EtH == 1) {
                            k.e(k.this);
                        } else if (k.this.EtH == 0) {
                            k.this.bC(1, true);
                        }
                    } else {
                        Log.e("MicroMsg.UpdaterManager", "download package from cdn error.");
                        if (k.this.NFN) {
                            if (i2 == 3 || i2 == 4 || i2 == 2 || i2 == 1 || i2 == 13) {
                                j.aK(k.this.mContext, i2);
                            }
                            k.this.NFN = false;
                            if (k.this.EtH == 1) {
                                if (k.this.NFR) {
                                    Log.d("MicroMsg.UpdaterManager", "boots download failed. %d", Integer.valueOf(i2));
                                    switch (i2) {
                                        case 1:
                                            h.INSTANCE.idkeyStat(614, 51, 1, false);
                                            break;
                                        case 2:
                                            h.INSTANCE.idkeyStat(614, 54, 1, false);
                                            break;
                                        case 3:
                                            h.INSTANCE.idkeyStat(614, 52, 1, false);
                                            break;
                                        case 4:
                                            h.INSTANCE.idkeyStat(614, 53, 1, false);
                                            break;
                                        case 13:
                                            h.INSTANCE.idkeyStat(614, 55, 1, false);
                                            break;
                                    }
                                } else {
                                    k.b(k.this);
                                }
                            } else if (k.this.EtH == 0) {
                                k.this.bC(1, true);
                            } else if (k.this.EtH == 2) {
                                k.c(k.this);
                            }
                        } else {
                            k kVar = k.this;
                            int i4 = k.this.size;
                            String str = k.this.md5;
                            int i5 = k.this.NEo;
                            int i6 = k.this.uin;
                            byte[] bArr = k.this.jDo;
                            byte[] bArr2 = k.this.ees;
                            String[] strArr = k.this.NFJ;
                            if (k.this.EtH == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            kVar.NFH = new b(i4, str, i5, i6, bArr, bArr2, strArr, z);
                            k.d(k.this);
                        }
                    }
                    k.this.a(k.this.NFH);
                    AppMethodBeat.o(32767);
                }
            }

            @Override // com.tencent.mm.sandbox.a
            public final void MC(long j2) {
                AppMethodBeat.i(32768);
                g gVar = k.this.NFU;
                gVar.timer.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  
                      (wrap: com.tencent.mm.sdk.platformtools.MTimerHandler : 0x000a: IGET  (r1v0 com.tencent.mm.sdk.platformtools.MTimerHandler) = (r0v1 'gVar' com.tencent.mm.sandbox.updater.g) com.tencent.mm.sandbox.updater.g.timer com.tencent.mm.sdk.platformtools.MTimerHandler)
                      (wrap: com.tencent.mm.sandbox.updater.g$2 : 0x000e: CONSTRUCTOR  (r2v0 com.tencent.mm.sandbox.updater.g$2) = (r0v1 'gVar' com.tencent.mm.sandbox.updater.g), (r6v0 'j2' long) call: com.tencent.mm.sandbox.updater.g.2.<init>(com.tencent.mm.sandbox.updater.g, long):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MTimerHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.sandbox.updater.k.2.MC(long):void, file: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r2v0 com.tencent.mm.sandbox.updater.g$2) = (r0v1 'gVar' com.tencent.mm.sandbox.updater.g), (r6v0 'j2' long) call: com.tencent.mm.sandbox.updater.g.2.<init>(com.tencent.mm.sandbox.updater.g, long):void type: CONSTRUCTOR in method: com.tencent.mm.sandbox.updater.k.2.MC(long):void, file: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.sandbox.updater.g, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                    this = this;
                    r3 = 32768(0x8000, float:4.5918E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    com.tencent.mm.sandbox.updater.k r0 = com.tencent.mm.sandbox.updater.k.this
                    com.tencent.mm.sandbox.updater.g r0 = r0.NFU
                    com.tencent.mm.sdk.platformtools.MTimerHandler r1 = r0.timer
                    com.tencent.mm.sandbox.updater.g$2 r2 = new com.tencent.mm.sandbox.updater.g$2
                    r2.<init>(r6)
                    r1.post(r2)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.updater.k.AnonymousClass2.MC(long):void");
            }

            @Override // com.tencent.mm.sandbox.a
            public final void MD(long j2) {
                AppMethodBeat.i(32769);
                g gVar = k.this.NFU;
                gVar.timer.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  
                      (wrap: com.tencent.mm.sdk.platformtools.MTimerHandler : 0x000a: IGET  (r1v0 com.tencent.mm.sdk.platformtools.MTimerHandler) = (r0v1 'gVar' com.tencent.mm.sandbox.updater.g) com.tencent.mm.sandbox.updater.g.timer com.tencent.mm.sdk.platformtools.MTimerHandler)
                      (wrap: com.tencent.mm.sandbox.updater.g$3 : 0x000e: CONSTRUCTOR  (r2v0 com.tencent.mm.sandbox.updater.g$3) = (r0v1 'gVar' com.tencent.mm.sandbox.updater.g), (r6v0 'j2' long) call: com.tencent.mm.sandbox.updater.g.3.<init>(com.tencent.mm.sandbox.updater.g, long):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MTimerHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.sandbox.updater.k.2.MD(long):void, file: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r2v0 com.tencent.mm.sandbox.updater.g$3) = (r0v1 'gVar' com.tencent.mm.sandbox.updater.g), (r6v0 'j2' long) call: com.tencent.mm.sandbox.updater.g.3.<init>(com.tencent.mm.sandbox.updater.g, long):void type: CONSTRUCTOR in method: com.tencent.mm.sandbox.updater.k.2.MD(long):void, file: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.sandbox.updater.g, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                    this = this;
                    r3 = 32769(0x8001, float:4.5919E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    com.tencent.mm.sandbox.updater.k r0 = com.tencent.mm.sandbox.updater.k.this
                    com.tencent.mm.sandbox.updater.g r0 = r0.NFU
                    com.tencent.mm.sdk.platformtools.MTimerHandler r1 = r0.timer
                    com.tencent.mm.sandbox.updater.g$3 r2 = new com.tencent.mm.sandbox.updater.g$3
                    r2.<init>(r6)
                    r1.post(r2)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.updater.k.AnonymousClass2.MD(long):void");
            }
        };
        this.mContext = MMApplicationContext.getContext();
        AppMethodBeat.o(32771);
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final void Ay(boolean z) {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ENABLE);
        Log.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", Boolean.valueOf(z));
        g gVar = this.NFU;
        if (gVar.tcf != z) {
            gVar.Az(true);
            gVar.tcf = z;
        }
        if (this.EtH != 2 || this.NFS) {
            Log.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", Integer.valueOf(this.EtH), Boolean.valueOf(this.NFS));
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ENABLE);
            return;
        }
        if (z) {
            if (bv(this.intent)) {
                AA(true);
                AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ENABLE);
                return;
            }
        } else if (this.NFS) {
            cancel();
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ENABLE);
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final boolean bu(Intent intent2) {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_DISABLE);
        boolean bv = bv(intent2);
        Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", Boolean.valueOf(bv));
        if (bv) {
            AA(false);
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_DISABLE);
        return bv;
    }

    public final boolean bv(Intent intent2) {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
        Log.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
        if (intent2 == null) {
            Log.i("MicroMsg.UpdaterManager", "intent == null");
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
            return false;
        }
        int intExtra = intent2.getIntExtra("intent_update_type", 3);
        int intExtra2 = intent2.getIntExtra("intent_extra_download_mode", 1);
        String stringExtra = intent2.getStringExtra("intent_extra_md5");
        if (this.NFS && !stringExtra.equalsIgnoreCase(this.md5) && this.EtH == 2) {
            cancel();
        } else if (this.NFS) {
            Log.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
            return true;
        }
        j.gwu();
        reset();
        this.intent = intent2;
        this.updateMode = intent2.getIntExtra("intent_extra_updateMode", 0);
        this.djj = intent2.getStringExtra("intent_extra_marketUrl");
        this.NFJ = intent2.getStringArrayExtra("intent_short_ips");
        this.jjS = intent2.getIntExtra("intent_client_version", d.KyO);
        d.KyO = this.jjS;
        this.NEo = intExtra;
        this.jDo = intent2.getByteArrayExtra("intent_extra_session");
        this.ees = intent2.getByteArrayExtra("intent_extra_cookie");
        this.jDs = intent2.getByteArrayExtra("intent_extra_ecdhkey");
        this.uin = intent2.getIntExtra("intent_extra_uin", 0);
        this.md5 = stringExtra;
        this.desc = intent2.getStringExtra("intent_extra_desc");
        this.size = intent2.getIntExtra("intent_extra_size", 0);
        this.NEQ = intent2.getStringArrayExtra("intent_extra_download_url");
        this.EtH = intExtra2;
        this.NFP = intent2.getBooleanExtra("intent_extra_force_download_full", false);
        String stringExtra2 = intent2.getStringExtra("intent_extra_patchInfo");
        if (stringExtra2 != null) {
            Log.i("MicroMsg.UpdaterManager", "patchXml != null");
            this.NFL = i.fR(stringExtra2);
        }
        String stringExtra3 = intent2.getStringExtra("intent_extra_extinfo");
        Log.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", stringExtra3);
        if (!Util.isNullOrNil(stringExtra3)) {
            this.NFQ = XmlParser.parseXml(stringExtra3, Constants.EXTINFO, null).get(".extinfo.notautodownloadrange");
            Log.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", this.NFQ);
        }
        Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", Integer.valueOf(intExtra2), Boolean.valueOf(this.NFS));
        if (intExtra != 999 || this.NEQ == null || this.NEQ.length <= 0) {
            if (this.NEQ != null) {
                for (String str : this.NEQ) {
                    Log.i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(str)));
                }
            }
            Log.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", stringExtra, Integer.valueOf(this.size));
            if (stringExtra == null || this.size == 0) {
                AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
                return false;
            }
            if (intExtra == 2) {
                boolean Of = com.tencent.mm.modelcontrol.b.Of(this.NFQ);
                Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", Boolean.valueOf(Of));
                if (Of) {
                    h.INSTANCE.idkeyStat(405, 78, 1, true);
                    AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
                    return false;
                }
            }
            if (this.NFL != null) {
                Log.i("MicroMsg.UpdaterManager", "patchInfo != null");
                String iw = com.tencent.mm.pluginsdk.i.g.iw(this.mContext);
                this.NFM = this.NFL.fQ(iw);
                Log.i("MicroMsg.UpdaterManager", "increase apkMD5 = " + iw + " : " + (this.NFM == null ? "not match" : "match"));
            }
            Log.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", Boolean.valueOf(this.NFP));
            this.NFR = intent2.getBooleanExtra("intent_extra_tinker_patch", false);
            if ((this.NFM == null || c.bhG(stringExtra)) && !this.NFR) {
                Log.i("MicroMsg.UpdaterManager", "had try to download full pack.");
            } else {
                Log.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
                this.NFN = true;
            }
            String gnt = j.gnt();
            if (!Util.isNullOrNil(gnt) && !gnt.equals(stringExtra)) {
                j.gwv();
            }
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
            return true;
        }
        if (intExtra2 == 2) {
            Log.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
        return true;
    }

    public final void cID() {
        AppMethodBeat.i(258869);
        AA(false);
        AppMethodBeat.o(258869);
    }

    private void AA(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
        Log.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", Boolean.valueOf(z));
        Log.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", Integer.valueOf(this.EtH), Boolean.valueOf(this.NFS));
        if (this.intent == null) {
            Log.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
        } else if (this.NFS) {
            Log.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
        } else if (!g.getExternalStorageState().equals("mounted")) {
            Log.e("MicroMsg.UpdaterManager", "no sdcard.");
            gww();
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
        } else {
            if (this.EtH == 2 && !z) {
                j.aL(this.mContext, 0);
            }
            String aFr = c.aFr(this.md5);
            Log.i("MicroMsg.UpdaterManager", aFr);
            if (aFr != null) {
                Log.i("MicroMsg.UpdaterManager", "update package already exist.");
                bC(1, true);
                aNH(aFr);
                if (this.EtH == 2 && !j.bhM(this.md5)) {
                    j.a(this.md5, this.NFK, this.desc, this.size, this.EtH, this.NEo, this.NFQ);
                }
                AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
                return;
            }
            if (this.NFP) {
                if (this.NFH != null) {
                    this.NFH.deleteTempFile();
                }
                j.aK(this.mContext, 11);
            }
            if (!this.NFP && this.NFN && this.NFL != null && this.NFM != null) {
                Log.i("MicroMsg.UpdaterManager", "Incresment Update");
                j.aK(this.mContext, 5);
                if (!e.yV((long) (this.size + this.NFM.size))) {
                    gwx();
                    AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
                    return;
                }
                cancel();
                int i2 = this.NFM.size;
                String str = this.md5;
                int i3 = this.NEo;
                String str2 = this.NFL.djt + this.NFM.url;
                String str3 = this.NFM.patchMd5;
                String str4 = this.NFM.djw;
                if (this.EtH != 2) {
                    z2 = false;
                }
                this.NFH = new c(i2, str, i3, str2, str3, str4, z2);
                gwy();
                AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
            } else if (!e.yV((long) this.size)) {
                Log.e("MicroMsg.UpdaterManager", "SDCard is full");
                gwx();
                AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
            } else {
                gwz();
                AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_EARACTION);
            }
        }
    }

    public final void bC(final int i2, boolean z) {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED);
        this.NFO = z;
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.sandbox.updater.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(32765);
                ((NotificationManager) k.this.mContext.getSystemService("notification")).cancel(99);
                Log.d("MicroMsg.UpdaterManager", "finishType == " + i2);
                if (i2 == 2 && k.this.NEo == 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
                    k.this.mContext.sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
                }
                AppMethodBeat.o(32765);
            }
        }, 300);
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED);
    }

    public final void cancel() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETCONNECTEDDEVICE);
        if (this.NFH != null) {
            this.NFS = false;
            this.NFH.cancel();
            this.NFH = null;
            this.NFT = System.currentTimeMillis();
            this.NFU.stop();
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETCONNECTEDDEVICE);
    }

    private void reset() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETCONNECTINGDEVICE);
        cancel();
        this.updateMode = 0;
        this.djj = null;
        this.NFJ = null;
        this.jjS = d.KyO;
        this.NEo = 0;
        this.jDo = null;
        this.ees = null;
        this.jDs = null;
        this.uin = 0;
        this.md5 = null;
        this.size = 0;
        this.desc = null;
        this.NEQ = null;
        this.NFL = null;
        this.NFM = null;
        this.NFN = false;
        this.NFO = false;
        this.EtH = 0;
        this.NFP = false;
        this.intent = null;
        this.NFS = false;
        this.kYy = null;
        this.NFV = 0;
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETCONNECTINGDEVICE);
    }

    private void gww() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_VOICECALLPREPROCESS);
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400).commit();
        bC(2, true);
        gwe();
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_VOICECALLPREPROCESS);
    }

    private void gwx() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_VOICECALLPOSTPROCESS);
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400).commit();
        bC(2, true);
        gwf();
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_VOICECALLPOSTPROCESS);
    }

    private void gwy() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_STARTRING);
        if (this.EtH == 2 && !NetStatusUtil.isWifi(this.mContext)) {
            j.gws();
            Log.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_STARTRING);
        } else if (this.EtH != 2 || !g.bhL(this.md5)) {
            this.NFU.gM(this.md5, this.size);
            if (this.NFH != null) {
                bC(1, false);
                this.NFS = true;
                this.NFH.a(this.NFW);
                eWN();
                if (this.EtH == 2) {
                    j.gws();
                }
            }
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_STARTRING);
        } else {
            Log.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
            this.NFU.stop();
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_STARTRING);
        }
    }

    private void gwz() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_STOPRING);
        cancel();
        Log.i("MicroMsg.UpdaterManager", "downloadFullPack");
        j.aK(this.mContext, 7);
        if (this.NEQ == null || this.NEQ.length <= 0) {
            this.NFH = new b(this.size, this.md5, this.NEo, this.uin, this.jDo, this.ees, this.NFJ, this.EtH == 2);
            h.INSTANCE.idkeyStat(405, 77, 1, true);
        } else {
            this.NFH = new c(this.size, this.md5, this.NEo, this.NEQ, this.EtH == 2);
            h.INSTANCE.idkeyStat(405, 76, 1, true);
        }
        gwy();
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_STOPRING);
    }

    @Override // com.tencent.mm.sandbox.updater.h
    public final void fn(int i2, int i3) {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETSTREAMTYPE);
        Iterator<h> it = this.NFI.iterator();
        while (it.hasNext()) {
            it.next().fn(i2, i3);
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETSTREAMTYPE);
    }

    @Override // com.tencent.mm.sandbox.updater.h
    public final void eWN() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_UPDATE);
        Iterator<h> it = this.NFI.iterator();
        while (it.hasNext()) {
            it.next().eWN();
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_UPDATE);
    }

    @Override // com.tencent.mm.sandbox.updater.h
    public final void aNH(String str) {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE);
        Iterator<h> it = this.NFI.iterator();
        while (it.hasNext()) {
            it.next().aNH(str);
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE);
    }

    @Override // com.tencent.mm.sandbox.updater.h
    public final void a(c cVar) {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE);
        Iterator<h> it = this.NFI.iterator();
        while (it.hasNext()) {
            it.next().a(cVar);
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE);
    }

    @Override // com.tencent.mm.sandbox.updater.h
    public final void gwe() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_VOICECALL_AUIDOPARAM_CHANGED);
        Iterator<h> it = this.NFI.iterator();
        while (it.hasNext()) {
            it.next().gwe();
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_VOICECALL_AUIDOPARAM_CHANGED);
    }

    @Override // com.tencent.mm.sandbox.updater.h
    public final void gwf() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE);
        Iterator<h> it = this.NFI.iterator();
        while (it.hasNext()) {
            it.next().gwf();
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE);
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final void onDestroy() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_RECOVER_AUDIO_FOCUS);
        Log.i("MicroMsg.UpdaterManager", "onDestroy");
        if (!this.NFS) {
            reset();
            bC(1, true);
        }
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_RECOVER_AUDIO_FOCUS);
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final boolean isBusy() {
        AppMethodBeat.i(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS);
        if (this.NFS || System.currentTimeMillis() - this.NFT <= UpdaterService.NGc) {
            Log.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", Boolean.valueOf(this.NFS), Long.valueOf(this.NFT), Long.valueOf(System.currentTimeMillis() - this.NFT));
            AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS);
            return true;
        }
        Log.i("MicroMsg.UpdaterManager", "not busy");
        AppMethodBeat.o(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS);
        return false;
    }

    static /* synthetic */ void a(k kVar, int i2, int i3) {
        PendingIntent activity;
        boolean z;
        AppMethodBeat.i(32792);
        String string = kVar.mContext.getString(R.string.tp);
        if (i2 < i3) {
            long j2 = (((long) i2) * 100) / ((long) i3);
            if (j2 - kVar.NFV >= 1) {
                kVar.NFV = j2;
                Intent intent2 = new Intent(kVar.intent);
                intent2.setClass(kVar.mContext, AppUpdaterUI.class);
                intent2.addFlags(536870912);
                PendingIntent activity2 = PendingIntent.getActivity(kVar.mContext, 0, intent2, 134217728);
                s.c g2 = com.tencent.mm.bq.a.cd(kVar.mContext, "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(string).g(kVar.mContext.getString(R.string.ts) + String.valueOf(kVar.NFV) + "%");
                g2.Hv = activity2;
                g2.b(BitmapFactory.decodeResource(kVar.mContext.getResources(), R.drawable.bpe));
                g2.as(com.tencent.mm.bq.a.ezb());
                kVar.kYy = g2.build();
                kVar.kYy.icon = R.drawable.bpe;
            }
            AppMethodBeat.o(32792);
        }
        if (kVar.NFR) {
            String gvY = kVar.NFH.gvY();
            if (gvY == null || !new File(gvY).exists()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Log.i("MicroMsg.UpdaterManager", "do noting. wait for merge apk.");
            }
        }
        String string2 = kVar.mContext.getString(R.string.tn);
        Intent intent3 = new Intent("android.intent.action.VIEW");
        FileProviderHelper.setIntentDataAndType(kVar.mContext, intent3, new o(kVar.NFH.gvY()), "application/vnd.android.package-archive", false);
        intent3.addFlags(536870912);
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent4 = new Intent(MMApplicationContext.getContext(), PermissionActivity.class);
            intent4.putExtra("scene", 3);
            intent4.setSelector(intent3);
            activity = PendingIntent.getActivity(kVar.mContext, 0, intent4, 134217728);
        } else {
            activity = PendingIntent.getActivity(kVar.mContext, 0, intent3, 134217728);
        }
        s.c g3 = com.tencent.mm.bq.a.cd(kVar.mContext, "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(string).g(string2);
        g3.Hv = activity;
        g3.b(BitmapFactory.decodeResource(kVar.mContext.getResources(), R.drawable.bpe));
        g3.as(com.tencent.mm.bq.a.ezb());
        kVar.kYy = g3.build();
        kVar.kYy.icon = R.drawable.bpe;
        kVar.kYy.flags |= 16;
        if (!kVar.NFO) {
            ((NotificationManager) kVar.mContext.getSystemService("notification")).notify(99, kVar.kYy);
        }
        AppMethodBeat.o(32792);
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(32793);
        j.a(kVar.md5, kVar.NFK, kVar.desc, kVar.size, kVar.EtH, kVar.NEo, kVar.NFQ);
        AppMethodBeat.o(32793);
    }

    static /* synthetic */ void b(k kVar) {
        AppMethodBeat.i(32794);
        Log.i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
        String string = kVar.mContext.getString(R.string.tr, Util.getSizeKB((long) kVar.size));
        Intent intent2 = kVar.intent;
        intent2.putExtra("intent_extra_force_download_full", true);
        PendingIntent service = PendingIntent.getService(kVar.mContext, 0, intent2, 134217728);
        s.c g2 = com.tencent.mm.bq.a.cd(kVar.mContext, "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(string).g(null);
        g2.Hv = service;
        kVar.kYy = g2.build();
        kVar.kYy.icon = R.drawable.bpe;
        kVar.kYy.flags |= 16;
        ((NotificationManager) kVar.mContext.getSystemService("notification")).notify(99, kVar.kYy);
        AppMethodBeat.o(32794);
    }

    static /* synthetic */ void e(k kVar) {
        AppMethodBeat.i(32797);
        String string = kVar.mContext.getString(R.string.tq);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + FilePathGenerator.ANDROID_DIR_SEP));
        intent2.addFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(kVar.mContext, 0, intent2, 134217728);
        s.c g2 = com.tencent.mm.bq.a.cd(kVar.mContext, "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(string).g(null);
        g2.Hv = activity;
        kVar.kYy = g2.build();
        kVar.kYy.icon = R.drawable.bpe;
        kVar.kYy.flags |= 16;
        ((NotificationManager) kVar.mContext.getSystemService("notification")).notify(99, kVar.kYy);
        AppMethodBeat.o(32797);
    }
}
