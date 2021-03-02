package com.tencent.mm.live.core.core;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.a;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u0004J$\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(J\u0006\u0010)\u001a\u00020\u001fJ\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0010\u0010-\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0004J\u0010\u00104\u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J=\u00105\u001a\u00020\u001f2\b\b\u0002\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u0002082#\u00109\u001a\u001f\u0012\u0013\u0012\u00110+¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u001f\u0018\u00010:J\u000e\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020+J\u0010\u0010@\u001a\u00020\u001f2\b\u0010A\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010B\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0012j\b\u0012\u0004\u0012\u00020\r`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "", "()V", "CACHE_STRATEGY_AUTO", "", "CACHE_STRATEGY_FAST", "CACHE_STRATEGY_SMOOTH", "CACHE_TIME_FAST", "", "CACHE_TIME_SMOOTH", "LAG_QUEUE_MAX_COUNT", "QUALITY_MAX_SWITCH_CNT", "QUALITY_OBSERVE_INTERVAL", "", "TAG", "", "cdnSwitchCnt", "lagHistoryQueue", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastCdnQuality", "lastTime", "lastTimeDown", "lastTimeUp", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "mCacheStrategy", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "upTimePenalty", "countLag", "", "curCdnUrl", "getCacheStrategy", "getTXLivePlayer", "context", "Landroid/content/Context;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "outterConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "h265PlayErrProcess", "isPlaying", "", "isPlayingH265", "onNetStatus", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "setCacheStrategy", "cacheStrategy", "setRenderMode", "renderMode", "setupLiveRoomInfo", "startPlay", "streamType", "playerView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "stopPlay", "keepLastFrame", "switchCdnStream", "cdnUrl", "tryRestartPlay", "plugin-core_release"})
public final class d {
    private static final String TAG = TAG;
    private static final int hwG = 1;
    private static final int hwH = 2;
    private static final int hwI = 3;
    private static final float hwJ = hwJ;
    private static final float hwK = hwK;
    private static final int hwL = 100;
    private static final long hwM = hwM;
    private static final int hwN = 5;
    private static TXLivePlayer hwO;
    private static e hwP;
    private static long hwQ;
    private static int hwR;
    private static int hwS = a.CDN_QUALITY_HD.value;
    private static ArrayList<Long> hwT = new ArrayList<>(hwL);
    private static long hwU;
    private static long hwV;
    private static long hwW = (hwM * 5);
    private static int hwX = hwI;
    public static final d hwY = new d();

    static {
        AppMethodBeat.i(196401);
        AppMethodBeat.o(196401);
    }

    private d() {
    }

    public static void Gm(String str) {
        int i2;
        String str2;
        boolean z;
        Integer num = null;
        AppMethodBeat.i(196390);
        e eVar = hwP;
        if (eVar != null) {
            Collection<String> values = eVar.hzs.values();
            p.g(values, "cdnUrlMap.values");
            int b2 = j.b((Iterable) values, (Object) str);
            Log.i("LiveRoomInfo", "indexOfUrl " + str + ", index:" + b2);
            i2 = b2;
        } else {
            i2 = 0;
        }
        Log.i(TAG, "switchCdnStream to " + str + ", indexOfUrl:" + i2);
        e eVar2 = hwP;
        if (eVar2 != null) {
            str2 = eVar2.qr(hwS);
        } else {
            str2 = null;
        }
        if (Util.isEqual(str2, str)) {
            Log.w(TAG, "switchCdnStream fail: curCdnUrl == cdnUrl");
            AppMethodBeat.o(196390);
            return;
        }
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.w(TAG, "switchCdnStream fail: cdnUrl is nullornil");
            AppMethodBeat.o(196390);
        } else if (hwO == null) {
            Log.w(TAG, "switchCdnStream fail: txLivePlayer == null");
            AppMethodBeat.o(196390);
        } else {
            hwS = i2;
            TXLivePlayer tXLivePlayer = hwO;
            if (tXLivePlayer != null) {
                num = Integer.valueOf(tXLivePlayer.switchStream(str));
            }
            if (num != null && num.intValue() == 0) {
                Log.i(TAG, "switchCdnStream ok");
                AppMethodBeat.o(196390);
                return;
            }
            Log.w(TAG, "switchCdnStream fail: ".concat(String.valueOf(num)));
            TXLivePlayer tXLivePlayer2 = hwO;
            if (tXLivePlayer2 != null) {
                tXLivePlayer2.stopPlay(false);
            }
            TXLivePlayer tXLivePlayer3 = hwO;
            if (tXLivePlayer3 != null) {
                tXLivePlayer3.startPlay(str, 1);
                AppMethodBeat.o(196390);
                return;
            }
            AppMethodBeat.o(196390);
        }
    }

    public static void a(e eVar) {
        AppMethodBeat.i(196391);
        hwP = eVar;
        hwS = a.CDN_QUALITY_HD.value;
        Integer valueOf = eVar != null ? Integer.valueOf(eVar.hzq) : null;
        if (valueOf != null) {
            hwS = valueOf.intValue();
        }
        AppMethodBeat.o(196391);
    }

    public static TXLivePlayer a(Context context, ITXLivePlayListener iTXLivePlayListener, TXLivePlayConfig tXLivePlayConfig) {
        AppMethodBeat.i(196392);
        p.h(context, "context");
        if (hwO == null) {
            hwO = new TXLivePlayer(context);
            if (tXLivePlayConfig == null) {
                tXLivePlayConfig = new TXLivePlayConfig();
            }
            int i2 = hwX;
            if (i2 == hwG) {
                tXLivePlayConfig.setAutoAdjustCacheTime(true);
                tXLivePlayConfig.setMaxAutoAdjustCacheTime(hwJ);
                tXLivePlayConfig.setMinAutoAdjustCacheTime(hwJ);
                tXLivePlayConfig.setCacheTime(hwJ);
            } else if (i2 == hwH) {
                tXLivePlayConfig.setAutoAdjustCacheTime(false);
                tXLivePlayConfig.setMaxAutoAdjustCacheTime(hwK);
                tXLivePlayConfig.setMinAutoAdjustCacheTime(hwK);
                tXLivePlayConfig.setCacheTime(hwK);
            } else if (i2 == hwI) {
                tXLivePlayConfig.setAutoAdjustCacheTime(true);
                tXLivePlayConfig.setMaxAutoAdjustCacheTime(hwK);
                tXLivePlayConfig.setMinAutoAdjustCacheTime(hwJ);
                tXLivePlayConfig.setCacheTime(hwJ);
            }
            TXLivePlayer tXLivePlayer = hwO;
            if (tXLivePlayer != null) {
                tXLivePlayer.setPlayListener(iTXLivePlayListener);
            }
            TXLivePlayer tXLivePlayer2 = hwO;
            if (tXLivePlayer2 != null) {
                tXLivePlayer2.enableHardwareDecode(true);
            }
            TXLivePlayer tXLivePlayer3 = hwO;
            if (tXLivePlayer3 != null) {
                tXLivePlayer3.setConfig(tXLivePlayConfig);
            }
            TXLivePlayer tXLivePlayer4 = hwO;
            if (tXLivePlayer4 != null) {
                tXLivePlayer4.setRenderMode(1);
            }
        }
        TXLivePlayer tXLivePlayer5 = hwO;
        AppMethodBeat.o(196392);
        return tXLivePlayer5;
    }

    public static void a(int i2, LiveVideoView liveVideoView, b<? super Boolean, x> bVar) {
        AppMethodBeat.i(196393);
        p.h(liveVideoView, "playerView");
        e eVar = hwP;
        String qr = eVar != null ? eVar.qr(hwS) : null;
        if (qr == null || hwO == null) {
            bVar.invoke(Boolean.FALSE);
            AppMethodBeat.o(196393);
            return;
        }
        TXLivePlayer tXLivePlayer = hwO;
        if (tXLivePlayer == null || tXLivePlayer.isPlaying()) {
            Log.i(TAG, "refresh palyView");
            TXLivePlayer tXLivePlayer2 = hwO;
            if (tXLivePlayer2 != null) {
                tXLivePlayer2.setPlayerView(liveVideoView);
            }
            bVar.invoke(Boolean.TRUE);
            AppMethodBeat.o(196393);
            return;
        }
        Log.i(TAG, "startPlay url:".concat(String.valueOf(qr)));
        TXLivePlayer tXLivePlayer3 = hwO;
        if (tXLivePlayer3 != null) {
            tXLivePlayer3.setPlayerView(liveVideoView);
        }
        TXLivePlayer tXLivePlayer4 = hwO;
        if (tXLivePlayer4 != null) {
            tXLivePlayer4.startPlay(qr, i2);
        }
        bVar.invoke(Boolean.TRUE);
        AppMethodBeat.o(196393);
    }

    public static void ev(boolean z) {
        AppMethodBeat.i(196394);
        Log.i(TAG, "stopPlay");
        TXLivePlayer tXLivePlayer = hwO;
        if (tXLivePlayer != null) {
            tXLivePlayer.stopPlay(z);
        }
        TXLivePlayer tXLivePlayer2 = hwO;
        if (tXLivePlayer2 != null) {
            tXLivePlayer2.setPlayListener(null);
        }
        hwO = null;
        hwQ = 0;
        hwR = 0;
        hwT.clear();
        hwU = 0;
        hwV = 0;
        hwW = hwM * 5;
        AppMethodBeat.o(196394);
    }

    public static boolean isPlaying() {
        AppMethodBeat.i(196395);
        TXLivePlayer tXLivePlayer = hwO;
        if (tXLivePlayer != null) {
            boolean isPlaying = tXLivePlayer.isPlaying();
            AppMethodBeat.o(196395);
            return isPlaying;
        }
        AppMethodBeat.o(196395);
        return false;
    }

    public static void aBZ() {
        a aVar;
        boolean z;
        int i2;
        int i3;
        int i4;
        String str = null;
        AppMethodBeat.i(196396);
        e eVar = hwP;
        if (eVar != null) {
            aVar = eVar.hzp;
        } else {
            aVar = null;
        }
        if (aVar == a.MMLiveStreamSwitchMode_Auto) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i5 = hwS;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - hwQ > hwM) {
                Iterator<T> it = hwT.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (currentTimeMillis - it.next().longValue() <= hwM) {
                        i4 = i2 + 1;
                    } else {
                        i4 = i2;
                    }
                    i2 = i4;
                }
            } else {
                i2 = 0;
            }
            if (i2 != 0 || currentTimeMillis - hwQ <= hwM + hwW) {
                if (i2 >= 3) {
                    if (hwS == a.CDN_QUALITY_HD.value) {
                        i3 = a.CDN_QUALITY_SD1.value;
                    } else {
                        if (hwS == a.CDN_QUALITY_SD1.value || hwS == a.CDN_QUALITY_SD2.value) {
                            i3 = a.CDN_QUALITY_SM.value;
                        }
                        i3 = hwS;
                    }
                }
                i3 = i5;
            } else {
                if (hwS != a.CDN_QUALITY_HD.value) {
                    if (hwS == a.CDN_QUALITY_SD1.value || hwS == a.CDN_QUALITY_SD2.value) {
                        i3 = a.CDN_QUALITY_HD.value;
                    } else {
                        if (hwS == a.CDN_QUALITY_SM.value) {
                            i3 = a.CDN_QUALITY_SD1.value;
                        }
                        i3 = i5;
                    }
                }
                i3 = hwS;
            }
            if (i3 != hwS && hwR < hwN) {
                if (i3 > hwS) {
                    hwV = currentTimeMillis;
                } else if (i3 < hwS) {
                    hwU = currentTimeMillis;
                }
                if (hwV > hwU && hwV - hwU < hwM * 2) {
                    hwW += hwM * 6;
                } else if (hwU > hwV && hwU - hwQ > hwM * 6) {
                    hwW = kotlin.k.j.aM(hwW - hwM, 0);
                }
                Log.i(TAG, "onNetStatus quality change: %d --> %d, duration:%d, upPenalty:%d, switchCnt:%d", Integer.valueOf(hwS), Integer.valueOf(i3), Long.valueOf(currentTimeMillis - hwQ), Long.valueOf(hwW), Integer.valueOf(hwR));
                hwQ = currentTimeMillis;
                hwR++;
                e eVar2 = hwP;
                if (eVar2 != null) {
                    str = eVar2.qr(i3);
                }
                Gm(str);
            }
        }
        AppMethodBeat.o(196396);
    }

    public static void aCa() {
        AppMethodBeat.i(196397);
        hwT.add(Long.valueOf(System.currentTimeMillis()));
        if (hwT.size() > hwL) {
            hwT.remove(0);
        }
        AppMethodBeat.o(196397);
    }

    public static void aCb() {
        String str = null;
        AppMethodBeat.i(196398);
        e eVar = hwP;
        Integer valueOf = eVar != null ? Integer.valueOf(eVar.hzr) : null;
        if (valueOf == null) {
            Log.i(TAG, "H265 play fail! cdnH265BackCfg is null");
            AppMethodBeat.o(196398);
            return;
        }
        Log.i(TAG, "H265 play fail! quality change: %d --> %d, switchCnt:%d", Integer.valueOf(hwS), valueOf, Integer.valueOf(hwR));
        e eVar2 = hwP;
        if (eVar2 != null) {
            str = eVar2.qr(valueOf.intValue());
        }
        Gm(str);
        hwR++;
        AppMethodBeat.o(196398);
    }

    public static boolean aCc() {
        return hwS == a.CDN_QUALITY_HEVC.value;
    }

    public static void qq(int i2) {
        boolean z;
        AppMethodBeat.i(196399);
        e eVar = hwP;
        String qr = eVar != null ? eVar.qr(hwS) : null;
        String str = qr;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            TXLivePlayer tXLivePlayer = hwO;
            if (tXLivePlayer != null) {
                tXLivePlayer.stopPlay(false);
            }
            TXLivePlayer tXLivePlayer2 = hwO;
            if (tXLivePlayer2 != null) {
                tXLivePlayer2.startPlay(qr, i2);
                AppMethodBeat.o(196399);
                return;
            }
            AppMethodBeat.o(196399);
            return;
        }
        Log.w(TAG, "tryRestartPlay fail: url is nullornil");
        AppMethodBeat.o(196399);
    }

    public static String aCd() {
        String str;
        AppMethodBeat.i(196400);
        e eVar = hwP;
        if (eVar == null || (str = eVar.qr(hwS)) == null) {
            str = "";
        }
        AppMethodBeat.o(196400);
        return str;
    }
}
