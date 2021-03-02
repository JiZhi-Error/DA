package com.tencent.mm.plugin.flutter.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.view.Surface;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.b.g;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.view.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class f implements io.flutter.embedding.engine.plugins.a, k.c {
    private k bbv;
    private a.b hgm;
    private final Map<Long, b> hgn = new HashMap();
    private a wLt = new a();
    b wLu;
    private HashMap<String, Integer> wLv = new HashMap<>();
    int wLw = NetUtil.getNetType(MMApplicationContext.getContext());

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(240988);
        this.hgm = bVar;
        this.bbv = new k(bVar.SOH, "com.tencent.mm.flutter/videoPlayer");
        this.bbv.a(this);
        AppMethodBeat.o(240988);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(240989);
        this.bbv.a(null);
        AppMethodBeat.o(240989);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        boolean ZA = false;
        private final d bbw;
        private Context context;
        MMHandler handler = new MMHandler() {
            /* class com.tencent.mm.plugin.flutter.f.f.b.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(240977);
                switch (message.what) {
                    case 1001:
                        b bVar = b.this;
                        Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering prepare]");
                        if (bVar.wLz != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("event", "preparing");
                            bVar.wLz.ba(hashMap);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(240977);
            }
        };
        private final c.a hgp;
        boolean isInitialized = false;
        private Surface surface;
        g wLy;
        i wLz = new i();

        static /* synthetic */ void a(b bVar, int i2, int i3, String str, String str2) {
            AppMethodBeat.i(240987);
            bVar.d(i2, i3, str, str2);
            AppMethodBeat.o(240987);
        }

        b(Context context2, d dVar, c.a aVar, String str, k.d dVar2) {
            AppMethodBeat.i(148923);
            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer create %s", Integer.valueOf(hashCode()));
            this.context = context2;
            this.bbw = dVar;
            this.hgp = aVar;
            this.wLy = new d(context2, aa.z(new o(context2.getCacheDir() + "/flutter/MMVideo-" + str.hashCode() + ".mp4").her()));
            this.wLy.setPath(str);
            dVar.a(new d.c() {
                /* class com.tencent.mm.plugin.flutter.f.f.b.AnonymousClass2 */

                @Override // io.flutter.plugin.a.d.c
                public final void a(Object obj, d.a aVar) {
                    AppMethodBeat.i(240978);
                    b.this.wLz.a(aVar);
                    AppMethodBeat.o(240978);
                }

                @Override // io.flutter.plugin.a.d.c
                public final void sT() {
                    AppMethodBeat.i(240979);
                    b.this.wLz.a(null);
                    AppMethodBeat.o(240979);
                }
            });
            this.surface = new Surface(aVar.surfaceTexture());
            this.wLy.setSurface(this.surface);
            this.wLy.a(new a() {
                /* class com.tencent.mm.plugin.flutter.f.f.b.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.flutter.f.h, com.tencent.mm.plugin.flutter.f.a
                public final void c(boolean z, int i2) {
                    AppMethodBeat.i(240980);
                    super.c(z, i2);
                    switch (i2) {
                        case 2:
                            b bVar = b.this;
                            if (bVar.wLz != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("event", "bufferingUpdate");
                                hashMap.put("values", Collections.singletonList(Arrays.asList(0, Integer.valueOf(bVar.wLy.getBufferedPercentage()))));
                                bVar.wLz.ba(hashMap);
                            }
                            AppMethodBeat.o(240980);
                            return;
                        case 3:
                            b.this.handler.removeMessages(1001);
                            if (!b.this.isInitialized) {
                                b.this.isInitialized = true;
                                b bVar2 = b.this;
                                if (bVar2.isInitialized) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("event", "initialized");
                                    hashMap2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(bVar2.wLy.getDurationMs()));
                                    hashMap2.put("width", Integer.valueOf(bVar2.wLy.getWidth()));
                                    hashMap2.put("height", Integer.valueOf(bVar2.wLy.getHeight()));
                                    bVar2.wLz.ba(hashMap2);
                                }
                                if (z) {
                                    b.this.wLy.start();
                                    AppMethodBeat.o(240980);
                                    return;
                                }
                            }
                            break;
                        case 4:
                            b bVar3 = b.this;
                            if (bVar3.isInitialized) {
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("event", "completed");
                                bVar3.wLz.ba(hashMap3);
                                break;
                            }
                            break;
                        case 5:
                            b.this.handler.sendEmptyMessageDelayed(1001, 500);
                            AppMethodBeat.o(240980);
                            return;
                        case 7:
                            b bVar4 = b.this;
                            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering start]");
                            if (bVar4.wLz != null) {
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("event", "bufferingStart");
                                bVar4.wLz.ba(hashMap4);
                            }
                            AppMethodBeat.o(240980);
                            return;
                        case 8:
                            b bVar5 = b.this;
                            Log.i("FlutterThumb", "[buffering end]");
                            if (bVar5.wLz != null) {
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put("event", "bufferingEnd");
                                bVar5.wLz.ba(hashMap5);
                            }
                            AppMethodBeat.o(240980);
                            return;
                    }
                    AppMethodBeat.o(240980);
                }

                @Override // com.tencent.mm.plugin.flutter.f.h, com.tencent.mm.plugin.flutter.f.a
                public final void c(int i2, int i3, String str, String str2) {
                    AppMethodBeat.i(240981);
                    super.c(i2, i3, str, str2);
                    if (b.this.wLz != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(i2));
                        hashMap.put("errorType", Integer.valueOf(i3));
                        hashMap.put(OpenSDKTool4Assistant.EXTRA_ERROR_MSG, str);
                        hashMap.put("errorActionDesc", str2);
                        b.this.wLz.b(String.valueOf(i2), str, hashMap);
                    }
                    AppMethodBeat.o(240981);
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", Long.valueOf(aVar.hxb()));
            dVar2.ba(hashMap);
            AppMethodBeat.o(148923);
        }

        /* access modifiers changed from: package-private */
        public final void prepare() {
            AppMethodBeat.i(240982);
            this.wLy.prepare();
            this.ZA = true;
            AppMethodBeat.o(240982);
        }

        /* access modifiers changed from: package-private */
        public final void pause() {
            AppMethodBeat.i(240983);
            Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer pause %s", Integer.valueOf(hashCode()));
            this.wLy.pause();
            AppMethodBeat.o(240983);
        }

        /* access modifiers changed from: package-private */
        public final void seekTo(int i2) {
            AppMethodBeat.i(240984);
            Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer seekTo %s", Integer.valueOf(hashCode()));
            this.wLy.seek(i2);
            AppMethodBeat.o(240984);
        }

        private void d(int i2, int i3, String str, String str2) {
            AppMethodBeat.i(240985);
            if (this.wLz != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(i2));
                hashMap.put("errorType", Integer.valueOf(i3));
                hashMap.put(OpenSDKTool4Assistant.EXTRA_ERROR_MSG, str);
                hashMap.put("errorActionDesc", str2);
                this.wLz.b(String.valueOf(i2), str, hashMap);
            }
            AppMethodBeat.o(240985);
        }

        /* access modifiers changed from: package-private */
        public final void dispose() {
            AppMethodBeat.i(148924);
            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer createOfDispose %s", Integer.valueOf(hashCode()));
            if (this.isInitialized) {
                this.wLy.stop();
            }
            this.hgp.release();
            this.bbw.a(null);
            if (this.surface != null && this.surface.isValid()) {
                this.surface.release();
            }
            if (this.wLy != null) {
                this.wLy.release();
            }
            AppMethodBeat.o(148924);
        }

        /* access modifiers changed from: package-private */
        public final String getVideoPath() {
            AppMethodBeat.i(240986);
            String videoPath = this.wLy.getVideoPath();
            AppMethodBeat.o(240986);
            return videoPath;
        }
    }

    public f() {
        AppMethodBeat.i(240990);
        MMApplicationContext.getContext().registerReceiver(this.wLt, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        AppMethodBeat.o(240990);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        char c2;
        b bVar;
        String btc;
        char c3 = 65535;
        AppMethodBeat.i(148926);
        c cVar = this.hgm.StA;
        if (cVar == null) {
            Log.e("MicroMsg.FlutterVideoPlayerPlugin", "texture null");
            dVar.b("no_activity", "video_player plugin requires a foreground activity", null);
            AppMethodBeat.o(148926);
            return;
        }
        boolean booleanValue = jVar.btq("force") != null ? ((Boolean) jVar.btq("force")).booleanValue() : false;
        String str = jVar.method;
        switch (str.hashCode()) {
            case -1352294148:
                if (str.equals("create")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -318476791:
                if (str.equals("preload")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3237136:
                if (str.equals(APMidasPluginInfo.LAUNCH_INTERFACE_INIT)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                for (b bVar2 : this.hgn.values()) {
                    bVar2.dispose();
                }
                this.hgn.clear();
                e.wLs.dMk().wLo = false;
                HashMap<String, h> hashMap = e.wLs.dMk().wLq.wLb;
                if (hashMap != null) {
                    hashMap.clear();
                    AppMethodBeat.o(148926);
                    return;
                }
                AppMethodBeat.o(148926);
                return;
            case 1:
                c.a hwY = cVar.hwY();
                d dVar2 = new d(this.hgm.SOH, "com.tencent.mm.flutter/videoPlayer/videoEvents" + hwY.hxb());
                if (jVar.btq("asset") != null) {
                    if (jVar.btq("package") != null) {
                        btc = this.hgm.SPB.op((String) jVar.btq("asset"), (String) jVar.btq("package"));
                    } else {
                        btc = this.hgm.SPB.btc((String) jVar.btq("asset"));
                    }
                    bVar = new b(this.hgm.applicationContext, dVar2, hwY, "asset:///".concat(String.valueOf(btc)), dVar);
                    this.hgn.put(Long.valueOf(hwY.hxb()), bVar);
                } else {
                    bVar = new b(this.hgm.applicationContext, dVar2, hwY, (String) jVar.btq(ShareConstants.MEDIA_URI), dVar);
                    this.hgn.put(Long.valueOf(hwY.hxb()), bVar);
                }
                if (booleanValue || a(bVar)) {
                    bVar.prepare();
                    e.wLs.dMk().wLp.hp(bVar.getVideoPath(), g.getMessageDigest(bVar.getVideoPath().getBytes()));
                }
                Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", Integer.valueOf(this.hgn.size()));
                AppMethodBeat.o(148926);
                return;
            case 2:
                String str2 = (String) jVar.btq("url");
                if (!Util.isNullOrNil(str2)) {
                    e.wLs.dMk().wLp.a(str2, (Long) null);
                    AppMethodBeat.o(148926);
                    return;
                }
                break;
            default:
                long longValue = ((Number) jVar.btq("textureId")).longValue();
                b bVar3 = this.hgn.get(Long.valueOf(longValue));
                if (bVar3 != null) {
                    String str3 = jVar.method;
                    switch (str3.hashCode()) {
                        case -971364356:
                            if (str3.equals("setLooping")) {
                                c3 = 0;
                                break;
                            }
                            break;
                        case -906224877:
                            if (str3.equals("seekTo")) {
                                c3 = 4;
                                break;
                            }
                            break;
                        case -493593704:
                            if (str3.equals("resetPosition")) {
                                c3 = 6;
                                break;
                            }
                            break;
                        case 3443508:
                            if (str3.equals(AssetExtension.SCENE_PLAY)) {
                                c3 = 2;
                                break;
                            }
                            break;
                        case 106440182:
                            if (str3.equals("pause")) {
                                c3 = 3;
                                break;
                            }
                            break;
                        case 670514716:
                            if (str3.equals(r.NAME)) {
                                c3 = 1;
                                break;
                            }
                            break;
                        case 747804969:
                            if (str3.equals("position")) {
                                c3 = 5;
                                break;
                            }
                            break;
                        case 1671767583:
                            if (str3.equals("dispose")) {
                                c3 = 7;
                                break;
                            }
                            break;
                    }
                    switch (c3) {
                        case 0:
                            bVar3.wLy.setLooping(((Boolean) jVar.btq("looping")).booleanValue());
                            dVar.ba(null);
                            AppMethodBeat.o(148926);
                            return;
                        case 1:
                            bVar3.wLy.u((double) ((float) Math.max(0.0d, Math.min(1.0d, ((Double) jVar.btq("volume")).doubleValue()))));
                            dVar.ba(null);
                            AppMethodBeat.o(148926);
                            return;
                        case 2:
                            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + jVar.method);
                            if (this.wLu != bVar3) {
                                if (this.wLu != null) {
                                    this.wLu.pause();
                                    e.wLs.dMk().wLp.axx(g.getMessageDigest(this.wLu.getVideoPath().getBytes()));
                                }
                                this.wLu = bVar3;
                            }
                            if (booleanValue) {
                                e.wLs.dMk().wLo = true;
                            }
                            if (a(this.wLu)) {
                                if (!this.wLu.ZA) {
                                    this.wLu.prepare();
                                }
                                if (this.wLv.containsKey(this.wLu.getVideoPath())) {
                                    this.wLu.seekTo(this.wLv.get(this.wLu.getVideoPath()).intValue());
                                }
                                b bVar4 = this.wLu;
                                Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer play %s", Integer.valueOf(bVar4.hashCode()));
                                bVar4.wLy.start();
                                e.wLs.dMk().wLp.hp(this.wLu.getVideoPath(), g.getMessageDigest(this.wLu.getVideoPath().getBytes()));
                            }
                            dVar.ba(null);
                            AppMethodBeat.o(148926);
                            return;
                        case 3:
                            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + jVar.method);
                            if (this.wLu == bVar3) {
                                bVar3.pause();
                            } else {
                                Log.d("MicroMsg.FlutterVideoPlayerPlugin", "pause ignore %s", Integer.valueOf(bVar3.hashCode()));
                            }
                            dVar.ba(null);
                            AppMethodBeat.o(148926);
                            return;
                        case 4:
                            if (this.wLu != bVar3) {
                                if (this.wLu != null) {
                                    this.wLu.pause();
                                    e.wLs.dMk().wLp.axx(g.getMessageDigest(this.wLu.getVideoPath().getBytes()));
                                }
                                this.wLu = bVar3;
                            }
                            int intValue = ((Number) jVar.btq(FirebaseAnalytics.b.LOCATION)).intValue();
                            this.wLv.put(this.wLu.getVideoPath(), Integer.valueOf(intValue));
                            this.wLu.seekTo(intValue);
                            e.wLs.dMk().wLp.hp(this.wLu.getVideoPath(), g.getMessageDigest(this.wLu.getVideoPath().getBytes()));
                            dVar.ba(null);
                            AppMethodBeat.o(148926);
                            return;
                        case 5:
                            long currentPosition = bVar3.wLy.getCurrentPosition();
                            this.wLv.put(bVar3.getVideoPath(), Integer.valueOf((int) currentPosition));
                            dVar.ba(Long.valueOf(currentPosition));
                            AppMethodBeat.o(148926);
                            return;
                        case 6:
                            bVar3.seekTo(0);
                            bVar3.pause();
                            this.wLv.put(bVar3.getVideoPath(), 0);
                            dVar.ba(null);
                            AppMethodBeat.o(148926);
                            return;
                        case 7:
                            if (!(this.wLu == null || bVar3 == null || !this.wLu.getVideoPath().equalsIgnoreCase(bVar3.getVideoPath()))) {
                                this.wLv.remove(bVar3.getVideoPath());
                            }
                            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + jVar.method);
                            if (this.wLu == bVar3) {
                                this.wLu = null;
                            }
                            bVar3.dispose();
                            this.hgn.remove(Long.valueOf(longValue));
                            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", Integer.valueOf(this.hgn.size()));
                            dVar.ba(null);
                            AppMethodBeat.o(148926);
                            return;
                        default:
                            dVar.dLv();
                            break;
                    }
                } else {
                    dVar.b("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(longValue)), null);
                    AppMethodBeat.o(148926);
                    return;
                }
        }
        AppMethodBeat.o(148926);
    }

    private static boolean a(b bVar) {
        AppMethodBeat.i(240991);
        e.wLs.dMk();
        if (!e.dMi()) {
            b.a(bVar, 1, 2, "视频加载失败，请检查网络连接后重试", "重试");
            AppMethodBeat.o(240991);
            return false;
        }
        if (!e.wLs.dMk().wLo) {
            e.wLs.dMk();
            if (!e.cGF()) {
                b.a(bVar, 2, 1, "当前为非Wi-Fi环境，是否使用流量观看视频？", "仍然播放");
                AppMethodBeat.o(240991);
                return false;
            }
        }
        AppMethodBeat.o(240991);
        return true;
    }

    class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(240976);
            int i2 = f.this.wLw;
            f.this.wLw = NetUtil.getNetType(MMApplicationContext.getContext());
            if (!(i2 == f.this.wLw || f.this.wLw == 5 || !NetUtil.isNetAvailable(MMApplicationContext.getContext()))) {
                Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net. reset enable play in mobile net false.");
                e.wLs.dMk().wLo = false;
                if (f.this.wLu != null) {
                    Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net.");
                    f.this.wLu.pause();
                }
            }
            AppMethodBeat.o(240976);
        }
    }
}
