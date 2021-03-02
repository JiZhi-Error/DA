package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.qq.wx.voice.embed.recognizer.a;
import com.qq.wx.voice.embed.recognizer.b;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.g;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;

public class ExtControlProviderVoiceControl extends ExtContentProviderBase implements i {
    private static final String[] sMy = {"retCode"};
    private Context context;
    private String[] sMN = null;
    private int sMO = -1;
    private int sOm = 4;
    private long sOn;
    private long sOo;
    private long sOp;
    b sOq = new b();
    private long sOr = 0;
    private boolean sOs;
    private c sOt = new c() {
        /* class com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.AnonymousClass5 */

        @Override // com.qq.wx.voice.embed.recognizer.c
        public final void a(a aVar) {
            AppMethodBeat.i(24521);
            if (aVar == null) {
                Log.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
                AppMethodBeat.o(24521);
                return;
            }
            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.this.sOr), aVar.text, aVar.name);
            if (!Util.isNullOrNil(aVar.name)) {
                ExtControlProviderVoiceControl.this.sOs = true;
                ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this, aVar.name);
            }
            AppMethodBeat.o(24521);
        }

        @Override // com.qq.wx.voice.embed.recognizer.c
        public final void onGetError(int i2) {
            AppMethodBeat.i(24522);
            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", Integer.valueOf(i2));
            AppMethodBeat.o(24522);
        }
    };

    static /* synthetic */ void b(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.i(24532);
        extControlProviderVoiceControl.arx(str);
        AppMethodBeat.o(24532);
    }

    public ExtControlProviderVoiceControl(String[] strArr, int i2, Context context2) {
        AppMethodBeat.i(24524);
        this.sMN = strArr;
        this.sMO = i2;
        this.context = context2;
        AppMethodBeat.o(24524);
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(24525);
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", Integer.valueOf(this.sMO));
        this.sOn = 0;
        this.sOo = 0;
        a(uri, this.context, this.sMO, this.sMN);
        if (uri == null) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
            fP(3, 5);
            MatrixCursor ahx = com.tencent.mm.pluginsdk.d.a.a.ahx(5);
            AppMethodBeat.o(24525);
            return ahx;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Util.isNullOrNil(this.sMZ)) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
            fP(3, 7);
            MatrixCursor ahx2 = com.tencent.mm.pluginsdk.d.a.a.ahx(7);
            AppMethodBeat.o(24525);
            return ahx2;
        } else if (Util.isNullOrNil(cSt())) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
            fP(3, 6);
            MatrixCursor ahx3 = com.tencent.mm.pluginsdk.d.a.a.ahx(6);
            AppMethodBeat.o(24525);
            return ahx3;
        } else {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis3 = System.currentTimeMillis() - System.currentTimeMillis();
            int cSu = cSu();
            if (cSu != 1) {
                Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(cSu)));
                fP(2, cSu);
                MatrixCursor ahx4 = com.tencent.mm.pluginsdk.d.a.a.ahx(cSu);
                AppMethodBeat.o(24525);
                return ahx4;
            }
            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis3));
            switch (this.sMO) {
                case 29:
                    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
                    if (strArr2 == null || strArr2.length < 4) {
                        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        fP(3, 3501);
                        this.sOm = 3501;
                        MatrixCursor ahx5 = com.tencent.mm.pluginsdk.d.a.a.ahx(3501);
                        AppMethodBeat.o(24525);
                        return ahx5;
                    }
                    final String str3 = strArr2[0];
                    final String str4 = strArr2[1];
                    final String str5 = strArr2[2];
                    final String str6 = strArr2[3];
                    final String str7 = strArr2[4];
                    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", str3, str4, str5, str6, str7);
                    if (Util.isNullOrNil(str3) || Util.isNullOrNil(str4) || Util.isNullOrNil(str5) || Util.isNullOrNil(str6) || Util.isNullOrNil(str7)) {
                        fP(3, 3502);
                        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        MatrixCursor ahx6 = com.tencent.mm.pluginsdk.d.a.a.ahx(3502);
                        AppMethodBeat.o(24525);
                        return ahx6;
                    } else if (!s.YS(str7)) {
                        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
                        fP(3, 3503);
                        MatrixCursor ahx7 = com.tencent.mm.pluginsdk.d.a.a.ahx(3503);
                        AppMethodBeat.o(24525);
                        return ahx7;
                    } else {
                        this.sOn = System.currentTimeMillis();
                        bg.azz().a(985, this);
                        this.sOq.c(13000, new Runnable() {
                            /* class com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(24517);
                                int i2 = Util.getInt(str3, 4);
                                if (i2 == 1) {
                                    ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, str7);
                                } else {
                                    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
                                }
                                if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this.sMZ, i2, Util.getInt(str4, 4), Util.getInt(str5, 16000), Util.getInt(str6, 16), str7)) {
                                    Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
                                    ExtControlProviderVoiceControl.this.sOm = 3504;
                                    ExtControlProviderVoiceControl.this.sOq.countDown();
                                }
                                AppMethodBeat.o(24517);
                            }
                        });
                        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", Long.valueOf(this.sOo - this.sOn), Long.valueOf(System.currentTimeMillis() - this.sOo));
                        bg.azz().b(985, this);
                        ac(10, 0, 1);
                        if (1 != this.sOm) {
                            ac(11, 4, 1);
                        } else {
                            ac(10, 0, 1);
                        }
                        HF(0);
                        MatrixCursor ahx8 = com.tencent.mm.pluginsdk.d.a.a.ahx(this.sOm);
                        AppMethodBeat.o(24525);
                        return ahx8;
                    }
                default:
                    fP(3, 15);
                    MatrixCursor ahx9 = com.tencent.mm.pluginsdk.d.a.a.ahx(15);
                    AppMethodBeat.o(24525);
                    return ahx9;
            }
        }
    }

    public static boolean b(String str, int i2, int i3, int i4, int i5, String str2) {
        String str3;
        byte[] aW;
        int i6;
        AppMethodBeat.i(24526);
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
        if (i2 != 4) {
            str3 = str2 + ".speex";
            new d();
            if (!d.U(str2, str3)) {
                Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", str2, str3);
                AppMethodBeat.o(24526);
                return false;
            }
        } else {
            str3 = str2;
        }
        int boW = (int) s.boW(str3);
        gv gvVar = new gv();
        gvVar.KKA = 4;
        gvVar.KKB = 4;
        gvVar.KKC = i4;
        gvVar.KKD = i5;
        gu guVar = new gu();
        guVar.BsF = boW;
        guVar.BsG = 0;
        if (boW <= 16384) {
            guVar.BsH = boW;
            aW = s.aW(str3, 0, boW);
        } else {
            guVar.BsH = 16384;
            aW = s.aW(str3, 0, 16384);
        }
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(boW), 16384);
        if (aW == null || aW.length <= 0) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
            AppMethodBeat.o(24526);
            return false;
        }
        gt gtVar = new gt();
        gtVar.KKy = gvVar;
        gtVar.KKt = guVar;
        gtVar.KKz = com.tencent.mm.bw.b.cD(aW);
        int hashCode = new StringBuilder().append(Util.nowMilliSecond()).toString().hashCode();
        if (hashCode != Integer.MIN_VALUE) {
            i6 = Math.abs(hashCode);
        } else {
            i6 = Integer.MIN_VALUE;
        }
        bg.azz().a(new a(i6, str, boW, str3, gtVar), 0);
        AppMethodBeat.o(24526);
        return true;
    }

    private static boolean a(a aVar, int i2, int i3) {
        AppMethodBeat.i(24527);
        if (aVar == null) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
            AppMethodBeat.o(24527);
            return false;
        } else if (aVar.sOE == null) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
            AppMethodBeat.o(24527);
            return false;
        } else if (aVar.sOE.KKt == null) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
            AppMethodBeat.o(24527);
            return false;
        } else {
            new gt();
            gt gtVar = aVar.sOE;
            gtVar.KKt.BsG = i2;
            gtVar.KKt.BsH = i3;
            byte[] aW = s.aW(aVar.sOD, i2, i3);
            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", Integer.valueOf(aVar.sOB), Integer.valueOf(i2), Integer.valueOf(i3));
            if (aW == null || aW.length <= 0) {
                Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", aVar.sOD);
                AppMethodBeat.o(24527);
                return false;
            }
            gtVar.KKz = com.tencent.mm.bw.b.cD(aW);
            a aVar2 = new a(aVar.sOB, aVar.appId, aVar.iKP, aVar.sOD, gtVar);
            aVar2.bNu = aVar.bNu;
            bg.azz().a(aVar2, 0);
            AppMethodBeat.o(24527);
            return true;
        }
    }

    public final boolean a(int i2, String str, com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(24528);
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", Integer.valueOf(i2), str);
        if (this.sOo == 0) {
            this.sOo = System.currentTimeMillis();
        }
        this.sOp = System.currentTimeMillis();
        gn gnVar = new gn();
        gnVar.KKm = bVar;
        bg.azz().a(new a(i2, str, gnVar, this.sOo), 0);
        AppMethodBeat.o(24528);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(24529);
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar == null) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
            this.sOm = 3506;
            this.sOq.countDown();
            AppMethodBeat.o(24529);
        } else if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", Integer.valueOf(qVar.getType()));
            if (qVar.getType() == 985) {
                if (this.sOs) {
                    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
                    AppMethodBeat.o(24529);
                    return;
                }
                final a aVar = (a) qVar;
                a aVar2 = (a) qVar;
                final gp gpVar = (aVar2.rr == null || aVar2.rr.iLL.iLR == null) ? null : (gp) aVar2.rr.iLL.iLR;
                if (gpVar == null) {
                    Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
                    this.sOm = 3508;
                    this.sOq.countDown();
                    AppMethodBeat.o(24529);
                    return;
                }
                aVar.sOC = gpVar.KKm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(aVar.dJY);
                if (gpVar.KKm == null) {
                    str2 = BuildConfig.COMMAND;
                } else {
                    str2 = new String(gpVar.KKm.zy);
                }
                objArr[1] = str2;
                Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", objArr);
                if (aVar.dJY == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (aVar.dJY == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
                        long currentTimeMillis = System.currentTimeMillis() - aVar.sOH;
                        if (currentTimeMillis > ((long) aVar.sOG)) {
                            Log.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.sOG));
                            z3 = true;
                        } else {
                            Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.sOG));
                            z3 = false;
                        }
                        if (z3) {
                            this.sOm = 3509;
                            this.sOq.countDown();
                            AppMethodBeat.o(24529);
                            return;
                        }
                        if (gpVar.KKu != null) {
                            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", Integer.valueOf(gpVar.KKu.KKn), Integer.valueOf(gpVar.KKu.KKv));
                        }
                        if (gpVar.KKu == null || gpVar.KKu.KKv != 0) {
                            if (System.currentTimeMillis() - this.sOp >= ((long) gpVar.KKr)) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.AnonymousClass3 */

                                    public final void run() {
                                        AppMethodBeat.i(24519);
                                        ExtControlProviderVoiceControl.this.a(aVar.sOB, aVar.appId, aVar.sOC);
                                        AppMethodBeat.o(24519);
                                    }
                                });
                                AppMethodBeat.o(24529);
                                return;
                            }
                            long currentTimeMillis2 = ((long) gpVar.KKr) - (System.currentTimeMillis() - this.sOp);
                            if (currentTimeMillis2 > ((long) gpVar.KKr)) {
                                currentTimeMillis2 = (long) gpVar.KKr;
                            }
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(24520);
                                    ExtControlProviderVoiceControl.this.a(aVar.sOB, aVar.appId, aVar.sOC);
                                    AppMethodBeat.o(24520);
                                }
                            }, currentTimeMillis2);
                            AppMethodBeat.o(24529);
                            return;
                        } else if (gpVar.KKu.KKw == null) {
                            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
                            this.sOm = 3511;
                            this.sOq.countDown();
                            AppMethodBeat.o(24529);
                            return;
                        } else if (gpVar.KKu.KKw.KKx == null || gpVar.KKu.KKw.KKx.size() <= 0) {
                            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
                            this.sOm = 3511;
                            this.sOq.countDown();
                            AppMethodBeat.o(24529);
                            return;
                        } else if (gpVar.KKu.KKw.KKx.size() == 0) {
                            this.sOm = 3511;
                            this.sOq.countDown();
                            AppMethodBeat.o(24529);
                            return;
                        } else if (gpVar.KKu.KKw.KKx.size() == 1) {
                            arx(gpVar.KKu.KKw.KKx.get(0).Username);
                            AppMethodBeat.o(24529);
                            return;
                        } else {
                            String[] strArr = new String[gpVar.KKu.KKw.KKx.size()];
                            for (int i4 = 0; i4 < strArr.length; i4++) {
                                strArr[i4] = gpVar.KKu.KKw.KKx.get(i4).Username;
                                Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", strArr[i4]);
                            }
                            Intent intent = new Intent();
                            intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                            intent.putExtra("VoiceSearchResultUI_VoiceId", aVar.sOB);
                            intent.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
                            intent.setFlags(67108864);
                            intent.putExtra("VoiceSearchResultUI_ShowType", 1);
                            com.tencent.mm.br.c.f(this.context, ".ui.voicesearch.VoiceSearchResultUI", intent);
                            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
                            this.sOm = 1;
                            this.sOq.countDown();
                            AppMethodBeat.o(24529);
                            return;
                        }
                    }
                } else if (gpVar.KKt == null) {
                    Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
                    this.sOm = 3508;
                    this.sOq.countDown();
                    AppMethodBeat.o(24529);
                    return;
                } else {
                    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", Integer.valueOf(gpVar.KKr), Integer.valueOf(gpVar.KKs), Integer.valueOf(gpVar.KKt.BsG), Integer.valueOf(gpVar.KKt.BsH));
                    if (gpVar.KKt.BsG >= aVar.iKP) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(24518);
                                Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                                a aVar = aVar;
                                int i2 = gpVar.KKs;
                                Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", Integer.valueOf(i2));
                                aVar.sOG = i2;
                                ExtControlProviderVoiceControl.this.a(aVar.sOB, aVar.appId, aVar.sOC);
                                AppMethodBeat.o(24518);
                            }
                        }, (long) gpVar.KKr);
                        AppMethodBeat.o(24529);
                        return;
                    }
                    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
                    if (gpVar.KKt.BsG == 0 || gpVar.KKt.BsG != aVar.bNu) {
                        aVar.bNu = gpVar.KKt.BsG;
                        if (gpVar.KKt.BsG + gpVar.KKt.BsH < aVar.iKP) {
                            if (!a(aVar, gpVar.KKt.BsG, gpVar.KKt.BsH)) {
                                Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
                                this.sOm = 3510;
                                this.sOq.countDown();
                                AppMethodBeat.o(24529);
                                return;
                            }
                        } else if (!a(aVar, gpVar.KKt.BsG, aVar.iKP - gpVar.KKt.BsG)) {
                            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
                            this.sOm = 3510;
                            this.sOq.countDown();
                            AppMethodBeat.o(24529);
                            return;
                        }
                        AppMethodBeat.o(24529);
                        return;
                    }
                    Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
                    AppMethodBeat.o(24529);
                    return;
                }
            }
            AppMethodBeat.o(24529);
        } else {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.sOm = 3507;
            this.sOq.countDown();
            AppMethodBeat.o(24529);
        }
    }

    private void arx(final String str) {
        AppMethodBeat.i(24530);
        bg.aVF();
        as Kn = com.tencent.mm.model.c.aSN().Kn(str);
        if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
            this.sOm = 3505;
            this.sOq.countDown();
            AppMethodBeat.o(24530);
            return;
        }
        com.tencent.mm.compatible.a.a.a(11, new a.AbstractC0298a() {
            /* class com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.AnonymousClass6 */

            @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
            public final void run() {
                AppMethodBeat.i(24523);
                ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this, str);
                AppMethodBeat.o(24523);
            }
        });
        this.sOm = 1;
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", str);
        this.sOq.countDown();
        AppMethodBeat.o(24530);
    }

    static /* synthetic */ void a(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.i(24531);
        extControlProviderVoiceControl.sOs = false;
        extControlProviderVoiceControl.sOr = System.currentTimeMillis();
        boolean z = MMApplicationContext.getDefaultPreference().getBoolean("hasInitVoiceControlData", true);
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl  hasInit:%s", Boolean.valueOf(z));
        if (z) {
            byte[] aW = s.aW(str, 0, -1);
            com.qq.wx.voice.embed.recognizer.b bVar = b.a.cgn;
            Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "recognize ret:%s", Integer.valueOf(bVar.cgm.a(extControlProviderVoiceControl.sOt, aW)));
        }
        AppMethodBeat.o(24531);
    }

    static /* synthetic */ void c(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.i(24533);
        if (g.Ng(str)) {
            Intent intent = new Intent();
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("enterprise_biz_display_name", aa.getDisplayName(str));
            com.tencent.mm.br.c.f(extControlProviderVoiceControl.context, ".ui.conversation.EnterpriseConversationUI", intent);
            AppMethodBeat.o(24533);
        } else if (g.DQ(str)) {
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_User", str);
            intent2.addFlags(67108864);
            intent2.putExtra("biz_chat_from_scene", 7);
            com.tencent.mm.br.c.f(extControlProviderVoiceControl.context, ".ui.bizchat.BizChatConversationUI", intent2);
            AppMethodBeat.o(24533);
        } else if (g.Nh(str)) {
            com.tencent.mm.api.c fJ = g.fJ(str);
            String UJ = fJ == null ? null : fJ.UJ();
            if (UJ == null) {
                UJ = "";
            }
            Intent intent3 = new Intent();
            intent3.putExtra("rawUrl", UJ);
            intent3.putExtra("useJs", true);
            intent3.putExtra("srcUsername", str);
            intent3.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent3.addFlags(67108864);
            com.tencent.mm.br.c.b(extControlProviderVoiceControl.context, "webview", ".ui.tools.WebViewUI", intent3);
            AppMethodBeat.o(24533);
        } else {
            Intent intent4 = new Intent();
            intent4.putExtra("Chat_User", str);
            intent4.addFlags(268435456);
            intent4.addFlags(32768);
            com.tencent.mm.plugin.ext.a.jRt.d(intent4, extControlProviderVoiceControl.context);
            AppMethodBeat.o(24533);
        }
    }
}
