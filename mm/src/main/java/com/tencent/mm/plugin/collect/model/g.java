package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.b.a.ku;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.collect.model.voice.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g extends IListener<ci> implements i, a.c {
    private static final com.tencent.mm.bw.b qvJ = com.tencent.mm.bw.b.bfZ("元");
    private static HandlerThread qvU = d.hB("syncCreatePlayer", 5);
    private boolean gVd = false;
    private MediaPlayer qvK;
    private MediaPlayer qvL;
    public ConcurrentLinkedQueue<c> qvM;
    private int qvN;
    private int qvO;
    private long qvP;
    private WeakReference<ArrayList<String>> qvQ;
    private ku qvR;
    private Map<String, ci> qvS = new HashMap();
    private final long qvT = 10000;

    /* access modifiers changed from: package-private */
    public interface b<T> {
        void czC();
    }

    static /* synthetic */ void a(g gVar, c cVar) {
        AppMethodBeat.i(63814);
        gVar.a(cVar);
        AppMethodBeat.o(63814);
    }

    static /* synthetic */ boolean czA() {
        AppMethodBeat.i(63817);
        boolean czv = czv();
        AppMethodBeat.o(63817);
        return czv;
    }

    static /* synthetic */ MediaPlayer czB() {
        AppMethodBeat.i(213149);
        MediaPlayer czx = czx();
        AppMethodBeat.o(213149);
        return czx;
    }

    static /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(63816);
        gVar.czw();
        AppMethodBeat.o(63816);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ci ciVar) {
        AppMethodBeat.i(63813);
        ci ciVar2 = ciVar;
        Log.i("MicroMsg.F2fRcvVoiceListener", "feeType: %s, voiceContent: %s, source: %s, tradeNo: %s, expireVoiceTimestamp: %s F2fRcvVoiceOffLineLogic.OFF_LINE: %s needFailover：%s", ciVar2.dFt.dFv, ciVar2.dFt.dFy, Integer.valueOf(ciVar2.dFt.source), ciVar2.dFt.dFw, ciVar2.dFt.dFz, Boolean.valueOf(com.tencent.mm.plugin.collect.model.voice.a.qwT), Boolean.valueOf(ciVar2.dFt.dFA));
        long j2 = ciVar2.dFt.gY;
        if (j2 > Util.MILLSECONDS_OF_MINUTE) {
            Log.i("MicroMsg.F2fRcvVoiceListener", "delay over 1min: %s, tradeNo: %s", Long.valueOf(j2), ciVar2.dFt.dFw);
            if (j2 <= 120000) {
                h.INSTANCE.idkeyStat(699, 3, 1, false);
            } else if (j2 <= 300000) {
                h.INSTANCE.idkeyStat(699, 4, 1, false);
            } else if (j2 <= 600000) {
                h.INSTANCE.idkeyStat(699, 5, 1, false);
            } else if (j2 <= 1800000) {
                h.INSTANCE.idkeyStat(699, 6, 1, false);
            } else {
                h.INSTANCE.idkeyStat(699, 7, 1, false);
            }
        }
        long j3 = 0;
        if (!Util.isNullOrNil(ciVar2.dFt.dFz)) {
            j3 = Util.getLong(ciVar2.dFt.dFz, 0);
        }
        if (!Util.isEqual(j3, 0) ? cl.aWy() / 1000 > j3 : j2 > 600000) {
            Log.i("MicroMsg.F2fRcvVoiceListener", "offline Synthesize delay > 10min or CurrentServerTime > expireVoiceTimestamp");
            if (!com.tencent.mm.plugin.collect.model.voice.a.qwT || Util.isNullOrNil(ciVar2.dFt.dFy)) {
                a(3, ciVar2.dFt.dFw, akM(ciVar2.dFt.dFx), ciVar2.dFt.dFy, ciVar2.dFt.dFu, com.tencent.mm.plugin.collect.model.voice.a.czG().czN(), 10);
            } else {
                a(6, ciVar2.dFt.dFw, akM(ciVar2.dFt.dFx), ciVar2.dFt.dFy, ciVar2.dFt.dFu, com.tencent.mm.plugin.collect.model.voice.a.czG().czN(), 10);
            }
            AppMethodBeat.o(63813);
        } else {
            a(ciVar2, true, false);
            AppMethodBeat.o(63813);
        }
        return false;
    }

    static {
        AppMethodBeat.i(63818);
        AppMethodBeat.o(63818);
    }

    public g() {
        AppMethodBeat.i(63797);
        this.__eventId = ci.class.getName().hashCode();
        AppMethodBeat.o(63797);
    }

    private void a(ci ciVar, boolean z, boolean z2) {
        AppMethodBeat.i(63798);
        Log.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", ciVar.dFt.dFw, Boolean.valueOf(z));
        long j2 = ciVar.dFt.gY;
        if (ciVar.dFt.dFx.equals("wx_f2f")) {
            com.tencent.mm.plugin.collect.a.a.czp();
            Log.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", Integer.valueOf(ciVar.dFt.dFu), Boolean.valueOf(com.tencent.mm.plugin.collect.a.a.czr()));
            if (z2 || !akL(ciVar.dFt.dFw)) {
                if (ciVar.dFt.source == 0) {
                    h.INSTANCE.idkeyStat(699, 8, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(699, 9, 1, false);
                }
                if (z && !com.tencent.mm.plugin.collect.model.voice.a.qwT && !Util.isNullOrNil(ciVar.dFt.dFy)) {
                    Log.i("MicroMsg.F2fRcvVoiceListener", "init tts");
                    com.tencent.mm.plugin.collect.model.voice.a.czG().kN(false);
                }
                if (!z || !com.tencent.mm.plugin.collect.model.voice.a.qwT || Util.isNullOrNil(ciVar.dFt.dFy)) {
                    Log.i("MicroMsg.F2fRcvVoiceListener", "useOnline");
                    i iVar = new i(ciVar.dFt.dFu, qvJ, ciVar.dFt.dFw, ciVar.dFt.source, j2);
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(iVar, 0);
                } else {
                    Log.i("MicroMsg.F2fRcvVoiceListener", "useOffline");
                    this.qvS.put(ciVar.dFt.dFw, ciVar);
                    com.tencent.mm.plugin.collect.model.voice.a.czG().a(ciVar);
                    AppMethodBeat.o(63798);
                    return;
                }
            }
            AppMethodBeat.o(63798);
        } else if (!ciVar.dFt.dFx.equals("wx_md")) {
            Log.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", ciVar.dFt.dFx);
            AppMethodBeat.o(63798);
        } else if (!z || !com.tencent.mm.plugin.collect.model.voice.a.qwT || Util.isNullOrNil(ciVar.dFt.dFy)) {
            o oVar = new o(ciVar.dFt.dFu, qvJ, ciVar.dFt.dFw);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(oVar, 0);
            AppMethodBeat.o(63798);
        } else {
            this.qvS.put(ciVar.dFt.dFw, ciVar);
            com.tencent.mm.plugin.collect.model.voice.a.czG().a(ciVar);
            AppMethodBeat.o(63798);
        }
    }

    private List<String> czu() {
        AppMethodBeat.i(63799);
        if (this.qvQ == null || this.qvQ.get() == null) {
            Log.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
            this.qvQ = new WeakReference<>(new ArrayList(Util.stringToList((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, ""), ",")));
        }
        ArrayList<String> arrayList = this.qvQ.get();
        AppMethodBeat.o(63799);
        return arrayList;
    }

    private synchronized boolean akL(String str) {
        List<String> list;
        boolean z;
        AppMethodBeat.i(63800);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", str);
            AppMethodBeat.o(63800);
            z = true;
        } else {
            List<String> czu = czu();
            Iterator<String> it = czu().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(str)) {
                        Log.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", str);
                        AppMethodBeat.o(63800);
                        z = true;
                        break;
                    }
                } else {
                    czu.add(str);
                    if (czu.size() > 10) {
                        Log.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
                        int size = czu.size();
                        list = czu.subList(size - 10, size);
                    } else {
                        list = czu;
                    }
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, Util.listToString(list, ","));
                    AppMethodBeat.o(63800);
                    z = false;
                }
            }
        }
        return z;
    }

    private static boolean m(String str, byte[] bArr) {
        AppMethodBeat.i(63801);
        com.tencent.mm.kernel.g.aAi();
        if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
            Log.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
            AppMethodBeat.o(63801);
            return false;
        } else if (s.f(str, bArr, bArr.length) == 0) {
            AppMethodBeat.o(63801);
            return true;
        } else {
            AppMethodBeat.o(63801);
            return false;
        }
    }

    public static boolean czv() {
        AppMethodBeat.i(63802);
        Log.i("MicroMsg.F2fRcvVoiceListener", "delete files");
        boolean dy = s.dy(czz(), true);
        AppMethodBeat.o(63802);
        return dy;
    }

    private synchronized void czw() {
        boolean z;
        AppMethodBeat.i(63803);
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_f2f_voice_overtime, 10000L);
        Log.i("MicroMsg.F2fRcvVoiceListener", "voiceOvertime: %s", Long.valueOf(a2));
        if (this.gVd && currentTimeMillis - this.qvP > a2) {
            Log.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", Long.valueOf(this.qvP));
            h.INSTANCE.idkeyStat(1143, 42, 1, false);
            this.gVd = false;
        }
        if (this.gVd) {
            Log.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
            AppMethodBeat.o(63803);
        } else {
            this.gVd = true;
            this.qvP = System.currentTimeMillis();
            final c poll = this.qvM.poll();
            int streamMaxVolume = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(3);
            this.qvN = com.tencent.mm.plugin.audio.c.a.getStreamVolume(3);
            this.qvO = Math.round(((float) streamMaxVolume) * 0.5f);
            Log.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", Integer.valueOf(this.qvN), Integer.valueOf(streamMaxVolume), Integer.valueOf(this.qvO));
            if (Build.VERSION.SDK_INT >= 23) {
                boolean cef = com.tencent.mm.plugin.audio.c.a.cef();
                Log.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", Boolean.valueOf(cef));
                z = cef;
            } else {
                z = false;
            }
            if (this.qvN == 0 || z) {
                Log.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
                int i2 = poll != null ? poll.qwa : 1;
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[5];
                objArr[0] = 3;
                objArr[1] = poll != null ? poll.dFw : "";
                objArr[2] = 5;
                objArr[3] = "";
                objArr[4] = Integer.valueOf(i2);
                hVar.a(14404, objArr);
            }
            if (this.qvN > 0 && this.qvN < this.qvO && !z) {
                com.tencent.mm.plugin.audio.c.a.eQ(3, this.qvO);
            }
            if (poll != null) {
                Log.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", Boolean.valueOf(poll.qwc));
                if (poll.qwc) {
                    a(poll);
                    if (!this.gVd || this.qvL != null) {
                        Log.i("MicroMsg.F2fRcvVoiceListener", "has played");
                        AppMethodBeat.o(63803);
                    } else {
                        Log.i("MicroMsg.F2fRcvVoiceListener", "isPlaying && moneyPlayer == null");
                        AppMethodBeat.o(63803);
                    }
                } else {
                    int i3 = poll.qwa;
                    if (!Util.isNullOrNil(poll.fileName)) {
                        Log.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", Integer.valueOf(i3));
                        this.qvK = a.a(MMApplicationContext.getContext(), new MediaPlayer.OnCompletionListener() {
                            /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass1 */

                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.i(63784);
                                Log.i("MicroMsg.F2fRcvVoiceListener", "start play money");
                                if (g.this.qvK == null || !g.this.gVd || g.this.qvL != null) {
                                    Log.i("MicroMsg.F2fRcvVoiceListener", "has played");
                                } else {
                                    g.a(g.this, poll);
                                }
                                g.this.qvK = null;
                                AppMethodBeat.o(63784);
                            }
                        }, new MediaPlayer.OnErrorListener() {
                            /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass2 */

                            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                AppMethodBeat.i(63785);
                                Log.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
                                g.this.gVd = false;
                                g.this.qvK = null;
                                g.f(g.this);
                                h.INSTANCE.a(14404, 3, poll.dFw, 7, Integer.valueOf(i2), Integer.valueOf(poll.qwa));
                                if (!g.this.qvM.isEmpty()) {
                                    g.h(g.this);
                                } else {
                                    g.czA();
                                }
                                AppMethodBeat.o(63785);
                                return false;
                            }
                        });
                        if (this.qvK != null) {
                            int duration = this.qvK.getDuration();
                            Log.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", Integer.valueOf(duration));
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(63786);
                                    if (g.this.qvK != null && g.this.gVd && g.this.qvL == null) {
                                        Log.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                                        h.INSTANCE.idkeyStat(699, 1, 1, false);
                                    }
                                    AppMethodBeat.o(63786);
                                }
                            }, (long) (duration + 1000));
                            AppMethodBeat.o(63803);
                        }
                    } else {
                        this.qvK = a.a(MMApplicationContext.getContext(), new MediaPlayer.OnCompletionListener() {
                            /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass4 */

                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.i(63787);
                                Log.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
                                g.f(g.this);
                                g.this.gVd = false;
                                g.this.qvK = null;
                                com.tencent.mm.plugin.collect.a.a.czp();
                                h.INSTANCE.a(14404, 4, poll.dFw, "", "", Integer.valueOf(poll.qwa));
                                if (!g.this.qvM.isEmpty()) {
                                    g.h(g.this);
                                    AppMethodBeat.o(63787);
                                    return;
                                }
                                g.czA();
                                AppMethodBeat.o(63787);
                            }
                        }, new MediaPlayer.OnErrorListener() {
                            /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass5 */

                            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                AppMethodBeat.i(63788);
                                Log.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
                                g.f(g.this);
                                g.this.gVd = false;
                                g.this.qvK = null;
                                h.INSTANCE.a(14404, 3, poll.dFw, 7, Integer.valueOf(i2), Integer.valueOf(poll.qwa));
                                AppMethodBeat.o(63788);
                                return false;
                            }
                        });
                        h.INSTANCE.idkeyStat(699, 2, 1, false);
                    }
                    AppMethodBeat.o(63803);
                }
            } else {
                this.gVd = false;
                AppMethodBeat.o(63803);
            }
        }
    }

    private void a(final c cVar) {
        AppMethodBeat.i(63804);
        this.qvL = a.a(cVar.fileName, new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass6 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(63789);
                Log.i("MicroMsg.F2fRcvVoiceListener", "play done");
                g.this.gVd = false;
                g.this.qvL = null;
                g.f(g.this);
                if (!g.this.qvM.isEmpty()) {
                    g.h(g.this);
                    AppMethodBeat.o(63789);
                    return;
                }
                g.czA();
                AppMethodBeat.o(63789);
            }
        }, new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass7 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(63790);
                Log.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                g.this.gVd = false;
                g.this.qvL = null;
                h.INSTANCE.a(14404, 3, cVar.dFw, 7, Integer.valueOf(i2), Integer.valueOf(cVar.qwa));
                g.f(g.this);
                if (!g.this.qvM.isEmpty()) {
                    g.h(g.this);
                } else {
                    g.czA();
                }
                AppMethodBeat.o(63790);
                return false;
            }
        }, new b() {
            /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.collect.model.g.b
            public final void czC() {
                AppMethodBeat.i(213145);
                h.INSTANCE.idkeyStat(1143, 41, 1, false);
                if (com.tencent.mm.plugin.collect.a.a.czp().qvz) {
                    Log.i("MicroMsg.F2fRcvVoiceListener", "play isForground");
                    if (cVar.qwc) {
                        h.INSTANCE.a(14404, 1, cVar.dFw, "", "", Integer.valueOf(cVar.qwa), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.czG().czN());
                        AppMethodBeat.o(213145);
                        return;
                    }
                    h.INSTANCE.a(14404, 1, cVar.dFw, "", "", Integer.valueOf(cVar.qwa));
                    AppMethodBeat.o(213145);
                    return;
                }
                Log.i("MicroMsg.F2fRcvVoiceListener", "play isBackground");
                if (cVar.qwc) {
                    h.INSTANCE.a(14404, 2, cVar.dFw, "", "", Integer.valueOf(cVar.qwa), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.czG().czN());
                    AppMethodBeat.o(213145);
                    return;
                }
                h.INSTANCE.a(14404, 2, cVar.dFw, "", "", Integer.valueOf(cVar.qwa));
                AppMethodBeat.o(213145);
            }
        });
        AppMethodBeat.o(63804);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63805);
        Log.i("MicroMsg.F2fRcvVoiceListener", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (qVar instanceof i) {
            i iVar = (i) qVar;
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", Integer.valueOf(iVar.qwf.Lhe), Integer.valueOf(iVar.qwf.dDN));
                if (iVar.qwf.Lhe == 1) {
                    Log.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", Long.valueOf(iVar.gY));
                    h.INSTANCE.a(14404, 3, iVar.dFw, 1, "", 1);
                    AppMethodBeat.o(63805);
                } else if (iVar.qwf.dDN == 0 && iVar.qwf.Lhd != null) {
                    a(1, iVar.qwf.Lhd.zy, iVar.qwf.Lba, iVar.dFw, iVar.qwf.Lhe, false);
                    h.INSTANCE.a(15763, iVar.dFw, 1, Integer.valueOf(Fc(iVar.source)), Long.valueOf(iVar.qwg), Integer.valueOf(czy()));
                    AppMethodBeat.o(63805);
                } else if (iVar.qwf.dDN <= 100) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(iVar.qwf.dDN);
                    objArr[1] = iVar.qwf.Lhd == null ? BuildConfig.COMMAND : "not null";
                    Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", objArr);
                    aO(1, iVar.dFw);
                    h.INSTANCE.a(15763, iVar.dFw, 2, Integer.valueOf(Fc(iVar.source)), Long.valueOf(iVar.qwg), Integer.valueOf(czy()));
                    AppMethodBeat.o(63805);
                } else {
                    Log.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
                    h.INSTANCE.a(14404, 3, iVar.dFw, 2, "", 1);
                    h.INSTANCE.a(15763, iVar.dFw, 2, Integer.valueOf(Fc(iVar.source)), Long.valueOf(iVar.qwg), Integer.valueOf(czy()));
                    AppMethodBeat.o(63805);
                }
            } else {
                Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", iVar);
                aO(1, iVar.dFw);
                h.INSTANCE.a(15763, iVar.dFw, 2, Integer.valueOf(Fc(iVar.source)), Long.valueOf(iVar.qwg), Integer.valueOf(czy()));
                h.INSTANCE.a(14404, 3, iVar.dFw, 3, "", 1);
                AppMethodBeat.o(63805);
            }
        } else {
            if (qVar instanceof o) {
                o oVar = (o) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", oVar);
                    h.INSTANCE.a(14404, 3, oVar.dFw, 3, "", 2);
                } else if (oVar.qwA.dDN == 0) {
                    o oVar2 = new o(czz());
                    if (oVar2.exists() || oVar2.mkdirs()) {
                        String str2 = czz() + UUID.randomUUID().toString() + ".tmp";
                        Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
                        if (m(str2, oVar.qwA.Lhd.zy)) {
                            c cVar = new c(this, (byte) 0);
                            cVar.fileName = str2;
                            cVar.dLt = oVar.qwA.Lba;
                            cVar.qwa = 2;
                            this.qvM.add(cVar);
                            czw();
                            AppMethodBeat.o(63805);
                            return;
                        }
                        Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                        AppMethodBeat.o(63805);
                        return;
                    }
                    Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
                    AppMethodBeat.o(63805);
                    return;
                } else {
                    h.INSTANCE.a(14404, 3, oVar.dFw, 2, "", 2);
                    AppMethodBeat.o(63805);
                    return;
                }
            }
            AppMethodBeat.o(63805);
        }
    }

    @Override // com.tencent.mm.plugin.collect.model.voice.a.c
    public final void a(int i2, String str, String str2, String str3, int i3, String str4, byte[] bArr) {
        AppMethodBeat.i(63806);
        Log.i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", Integer.valueOf(i2), str, str2, str3, str4, 0);
        int akM = akM(str2);
        ci remove = this.qvS.remove(str);
        if (i2 < 0) {
            if (remove == null) {
                aO(akM, str);
            } else if (remove.dFt.dFA) {
                a(remove, false, true);
            } else {
                Log.i("MicroMsg.F2fRcvVoiceListener", "onGetResult() needFailover:false");
            }
            a(6, str, akM, str3, i3, str4, 9);
            AppMethodBeat.o(63806);
            return;
        }
        a(akM, bArr, 1, str, 0, true);
        a(5, str, akM, str3, i3, str4, 0);
        AppMethodBeat.o(63806);
    }

    private void a(int i2, byte[] bArr, int i3, String str, int i4, boolean z) {
        AppMethodBeat.i(63807);
        o oVar = new o(czz());
        if (oVar.exists() || oVar.mkdirs()) {
            String str2 = czz() + UUID.randomUUID().toString() + ".tmp";
            Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
            if (m(str2, bArr)) {
                c cVar = new c(this, (byte) 0);
                cVar.fileName = str2;
                cVar.dLt = i3;
                cVar.qwa = i2;
                cVar.dFw = str;
                cVar.qwb = i4;
                cVar.qwc = z;
                this.qvM.add(cVar);
                czw();
                AppMethodBeat.o(63807);
                return;
            }
            Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
            AppMethodBeat.o(63807);
            return;
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
        AppMethodBeat.o(63807);
    }

    private void aO(int i2, String str) {
        AppMethodBeat.i(63808);
        Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
        c cVar = new c(this, (byte) 0);
        cVar.qwa = i2;
        cVar.dFw = str;
        this.qvM.add(cVar);
        czw();
        AppMethodBeat.o(63808);
    }

    private static int Fc(int i2) {
        if (i2 == 1) {
            return 3;
        }
        return 2;
    }

    private static int akM(String str) {
        AppMethodBeat.i(63809);
        int i2 = 0;
        if (str.equals("wx_f2f")) {
            i2 = 1;
        } else if (str.equals("wx_md")) {
            i2 = 2;
        }
        AppMethodBeat.o(63809);
        return i2;
    }

    private void a(int i2, String str, int i3, String str2, int i4, String str3, int i5) {
        AppMethodBeat.i(63810);
        this.qvR = new ku();
        this.qvR.erW = (long) i2;
        this.qvR.ym(str);
        if (!Util.isEqual(i5, 0)) {
            this.qvR.eXr = (long) i5;
        }
        this.qvR.evl = (long) i3;
        this.qvR.yn(str2);
        this.qvR.eXv = (long) i4;
        if (Util.isEqual(i2, 6)) {
            this.qvR.yo(str3);
        }
        this.qvR.bfK();
        AppMethodBeat.o(63810);
    }

    /* access modifiers changed from: package-private */
    public class c {
        String dFw;
        int dLt;
        String fileName;
        int qwa;
        int qwb;
        boolean qwc;

        private c() {
            this.qwb = 0;
            this.qwc = false;
        }

        /* synthetic */ c(g gVar, byte b2) {
            this();
        }
    }

    private static MediaPlayer czx() {
        AppMethodBeat.i(213148);
        Looper myLooper = Looper.myLooper();
        Log.i("MicroMsg.F2fRcvVoiceListener", "[syncCreatePlayer] %s", myLooper);
        if (myLooper == null || myLooper == Looper.getMainLooper() || myLooper == qvU.getLooper()) {
            k kVar = new k();
            AppMethodBeat.o(213148);
            return kVar;
        }
        if (!qvU.isAlive()) {
            qvU.start();
        }
        MMHandler mMHandler = new MMHandler(qvU.getLooper());
        final Object obj = new Object();
        final MediaPlayer[] mediaPlayerArr = {null};
        synchronized (obj) {
            try {
                mMHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.collect.model.g.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(213146);
                        mediaPlayerArr[0] = new k();
                        try {
                            synchronized (obj) {
                                try {
                                    obj.notify();
                                } finally {
                                    AppMethodBeat.o(213146);
                                }
                            }
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e2, "", new Object[0]);
                            AppMethodBeat.o(213146);
                        }
                    }
                });
                try {
                    obj.wait();
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e2, "", new Object[0]);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(213148);
                throw th;
            }
        }
        MediaPlayer mediaPlayer = mediaPlayerArr[0];
        AppMethodBeat.o(213148);
        return mediaPlayer;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00ff A[Catch:{ all -> 0x0134 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0104 A[SYNTHETIC, Splitter:B:29:0x0104] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x011e A[SYNTHETIC, Splitter:B:37:0x011e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static android.media.MediaPlayer a(android.content.Context r11, final android.media.MediaPlayer.OnCompletionListener r12, final android.media.MediaPlayer.OnErrorListener r13) {
            /*
            // Method dump skipped, instructions count: 314
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.collect.model.g.a.a(android.content.Context, android.media.MediaPlayer$OnCompletionListener, android.media.MediaPlayer$OnErrorListener):android.media.MediaPlayer");
        }

        public static MediaPlayer a(final String str, final MediaPlayer.OnCompletionListener onCompletionListener, final MediaPlayer.OnErrorListener onErrorListener, b bVar) {
            AppMethodBeat.i(213147);
            final MediaPlayer czB = g.czB();
            czB.setAudioStreamType(3);
            Log.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", Integer.valueOf(czB.hashCode()), str);
            try {
                czB.setDataSource(str);
                czB.setLooping(false);
                czB.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    /* class com.tencent.mm.plugin.collect.model.g.a.AnonymousClass3 */

                    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        AppMethodBeat.i(63793);
                        Log.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e2) {
                            }
                        }
                        if (czB != null) {
                            czB.release();
                        }
                        if (onErrorListener != null) {
                            onErrorListener.onError(mediaPlayer, i2, i3);
                        }
                        AppMethodBeat.o(63793);
                        return false;
                    }
                });
                czB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    /* class com.tencent.mm.plugin.collect.model.g.a.AnonymousClass4 */

                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(63794);
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = str;
                        Log.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (czB != null) {
                            czB.release();
                        }
                        if (onCompletionListener != null) {
                            onCompletionListener.onCompletion(mediaPlayer);
                        }
                        AppMethodBeat.o(63794);
                    }
                });
                czB.prepare();
                czB.start();
                bVar.czC();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(czB.hashCode());
                objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                Log.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", objArr);
                AppMethodBeat.o(213147);
                return czB;
            } catch (Exception e2) {
                Log.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", str, e2.getMessage());
                Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e2, "", new Object[0]);
                if (czB != null) {
                    czB.release();
                }
                AppMethodBeat.o(213147);
                return null;
            }
        }
    }

    private static int czy() {
        AppMethodBeat.i(63811);
        if (com.tencent.mm.plugin.audio.c.a.ceb()) {
            AppMethodBeat.o(63811);
            return 1;
        }
        AppMethodBeat.o(63811);
        return 0;
    }

    private static String czz() {
        AppMethodBeat.i(63812);
        String str = com.tencent.mm.loader.j.b.aKJ() + "wallet/voice/";
        AppMethodBeat.o(63812);
        return str;
    }

    static /* synthetic */ void f(g gVar) {
        AppMethodBeat.i(63815);
        Log.i("MicroMsg.F2fRcvVoiceListener", "reset user vol: %s", Integer.valueOf(gVar.qvN));
        com.tencent.mm.plugin.audio.c.a.eQ(3, gVar.qvN);
        AppMethodBeat.o(63815);
    }
}
