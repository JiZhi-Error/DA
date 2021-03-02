package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.game.e.a.b;
import com.tencent.mm.plugin.appbrand.game.f.a.d;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends b {
    public static final int CTRL_INDEX = 666;
    public static final String NAME = "operateGameRecorder";
    a lsK = new a();
    c.a lsL = null;
    String lsM = null;

    public e() {
        AppMethodBeat.i(45155);
        AppMethodBeat.o(45155);
    }

    static /* synthetic */ void a(e eVar, s sVar, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(45159);
        eVar.a(sVar, i2, i3, i4, str);
        AppMethodBeat.o(45159);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45158);
        final com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        String optString = jSONObject.optString("operationType");
        Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: operating game screen recorder: %s json: %s", optString, jSONObject.toString());
        if ("start".equalsIgnoreCase(optString)) {
            MagicBrushView h2 = h(cVar2);
            if (h2 == null) {
                Log.e("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: cannot retrieve magicbrush view!");
                a(cVar2, i2, 1, 111, "game view not prepared");
                AppMethodBeat.o(45158);
            } else if (!cVar2.bsz().cwV) {
                Log.w("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: current game is not in foreground. ignore start!");
                a(cVar2, i2, 2, -2, "can not start in background");
                AppMethodBeat.o(45158);
            } else {
                d dVar = (d) h2.getRendererView();
                int surfaceWidth = dVar.getSurfaceWidth();
                int surfaceHeight = dVar.getSurfaceHeight();
                int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                int optInt2 = jSONObject.optInt("fps");
                int optInt3 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) * 1000;
                int optInt4 = jSONObject.optInt("gop");
                if (cVar2.getFileSystem() == null) {
                    Log.w("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: not file system");
                    a(cVar2, i2, 1, -1, "no file system!");
                    AppMethodBeat.o(45158);
                    return;
                }
                b.a a2 = a(cVar2, "src_game_screenrecord.mp4");
                b.a a3 = a(cVar2, "src_game_screenrecord_thumb.jpg");
                if (a2 == null || a3 == null) {
                    Log.e("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: WAGameJsApiScreenRecorderOperate, alloc file failed");
                    a(cVar2, i2, 1, -1, "internal create file failed!");
                    AppMethodBeat.o(45158);
                    return;
                }
                Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: given duration: %d, fps: %d, bitrate: %d, gop: %d, width: %d, height: %d, srcFileName: %s, srcThumbPath: %s", Integer.valueOf(optInt), Integer.valueOf(optInt2), Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(surfaceWidth), Integer.valueOf(surfaceHeight), a2.lsB, a3.lsB);
                c.b bVar = new c.b();
                bVar.width = surfaceWidth;
                bVar.height = surfaceHeight;
                bVar.duration = optInt;
                bVar.fps = optInt2;
                bVar.bitrate = optInt3;
                bVar.gop = optInt4;
                bVar.lvz = a2;
                bVar.lvy = a3;
                final long currentTicks = Util.currentTicks();
                com.tencent.mm.plugin.appbrand.game.g.b g2 = g(cVar2);
                AnonymousClass1 r4 = new com.tencent.mm.plugin.appbrand.game.g.d<String>() {
                    /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.game.g.d
                    public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                        AppMethodBeat.i(45145);
                        Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: request start done! using: %d ms, %d, %d, %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            e eVar = e.this;
                            com.tencent.mm.plugin.appbrand.service.c cVar = cVar2;
                            eVar.lsM = cVar.getAppId();
                            eVar.lsL = new c.a(cVar) {
                                /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass3 */
                                final /* synthetic */ com.tencent.mm.plugin.appbrand.service.c lsE;

                                {
                                    this.lsE = r2;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.a.c.a
                                public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                                    AppMethodBeat.i(45149);
                                    if (bVar != com.tencent.mm.plugin.appbrand.a.b.BACKGROUND || Util.isNullOrNil(str) || !str.equals(e.this.lsM)) {
                                        if (bVar == com.tencent.mm.plugin.appbrand.a.b.kQH && !Util.isNullOrNil(str) && str.equals(e.this.lsM)) {
                                            Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: %s trigger foreground, resume recording", str);
                                            e.g(this.lsE).f(new com.tencent.mm.plugin.appbrand.game.g.d<String>() {
                                                /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass3.AnonymousClass2 */

                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                                                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                                                    AppMethodBeat.i(45148);
                                                    Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: active resume result %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                                    if (i2 == 0 && i3 == 0) {
                                                        e.this.lsK.f(AnonymousClass3.this.lsE);
                                                    }
                                                    AppMethodBeat.o(45148);
                                                }
                                            });
                                        }
                                        AppMethodBeat.o(45149);
                                        return;
                                    }
                                    Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: %s trigger background, pause recording", str);
                                    e.g(this.lsE).e(new com.tencent.mm.plugin.appbrand.game.g.d<String>() {
                                        /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass3.AnonymousClass1 */

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                        @Override // com.tencent.mm.plugin.appbrand.game.g.d
                                        public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                                            AppMethodBeat.i(45147);
                                            Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: active pause result %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                            if (i2 == 0 && i3 == 0) {
                                                e.this.lsK.e(AnonymousClass3.this.lsE);
                                            }
                                            AppMethodBeat.o(45147);
                                        }
                                    });
                                    AppMethodBeat.o(45149);
                                }
                            };
                            if (!(cVar.getRuntime() == null || cVar.getRuntime().kAH == null)) {
                                cVar.getRuntime().kAH.a(eVar.lsL);
                            }
                            e.this.a(cVar2, i2, (Map<String, Object>) null);
                            a aVar = e.this.lsK;
                            aVar.g(cVar2);
                            Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch start");
                            HashMap hashMap = new HashMap(1);
                            hashMap.put("state", "start");
                            aVar.L(hashMap).bEo();
                            AppMethodBeat.o(45145);
                            return;
                        }
                        e.a(e.this, cVar2, i2, i2, i3, str);
                        AppMethodBeat.o(45145);
                    }
                };
                AnonymousClass2 r6 = new b.AbstractC0588b() {
                    /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.game.g.b.AbstractC0588b
                    public final void Bc(long j2) {
                        AppMethodBeat.i(45146);
                        Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: relative ticks in ms: %d", Long.valueOf(j2));
                        a aVar = e.this.lsK;
                        aVar.g(cVar2);
                        Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch stamp change: %d", Long.valueOf(j2));
                        HashMap hashMap = new HashMap(2);
                        hashMap.put("state", "timeUpdate");
                        hashMap.put("currentTime", Long.valueOf(j2));
                        aVar.L(hashMap).bEo();
                        AppMethodBeat.o(45146);
                    }
                };
                MagicBrushView bDB = g2.luP.bDB();
                if (bDB == null) {
                    Log.w("MicroMsg.GameRecorderMgr", "hy: view lost");
                    r4.a(1, -2, "view lost", null);
                    AppMethodBeat.o(45158);
                    return;
                }
                bDB.a(false, true, new kotlin.g.a.b<Boolean, Void>(r4, bVar, r6, bDB) {
                    /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass11 */
                    final /* synthetic */ d luL;
                    final /* synthetic */ c.b lvf;
                    final /* synthetic */ AbstractC0588b lvg;
                    final /* synthetic */ MagicBrushView lvh;

                    {
                        this.luL = r2;
                        this.lvf = r3;
                        this.lvg = r4;
                        this.lvh = r5;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ Void invoke(Boolean bool) {
                        AppMethodBeat.i(45340);
                        if (bool.booleanValue()) {
                            b.this.luO.postToWorker(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass11.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(45339);
                                    if (b.this.luR == e.Running) {
                                        Log.w("MicroMsg.GameRecorderMgr", "hy: already running!");
                                        AnonymousClass11.this.luL.a(2, 103, "already started", null);
                                        AppMethodBeat.o(45339);
                                    } else if (b.this.luR == e.Paused) {
                                        Log.w("MicroMsg.GameRecorderMgr", "hy: currently paused. fail");
                                        AnonymousClass11.this.luL.a(2, 104, "currently paused. please call resume", null);
                                        AppMethodBeat.o(45339);
                                    } else {
                                        if (b.this.luR == e.NotInit) {
                                            b.this.luR = e.Inited;
                                        }
                                        if (!b.b(AnonymousClass11.this.lvf, AnonymousClass11.this.luL)) {
                                            AppMethodBeat.o(45339);
                                            return;
                                        }
                                        b.this.luP.a(AnonymousClass11.this.lvf, new d<String>() {
                                            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass11.AnonymousClass1.AnonymousClass1 */

                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                            @Override // com.tencent.mm.plugin.appbrand.game.g.d
                                            public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                                                AppMethodBeat.i(45338);
                                                if (i2 == 0 && i3 == 0) {
                                                    b.this.luR = e.Running;
                                                    b.this.luS = AnonymousClass11.this.lvf.lvz;
                                                    b.this.luT = AnonymousClass11.this.lvf.lvy;
                                                    b.c(b.this);
                                                    b.this.luP.a(AnonymousClass11.this.lvg);
                                                    AnonymousClass11.this.luL.a(0, 0, "ok", null);
                                                    AppMethodBeat.o(45338);
                                                    return;
                                                }
                                                Log.w("MicroMsg.GameRecorderMgr", "hy: start record failed!");
                                                AnonymousClass11.this.luL.a(i2, i3, str, "");
                                                AppMethodBeat.o(45338);
                                            }
                                        });
                                        AppMethodBeat.o(45339);
                                    }
                                }
                            });
                        } else {
                            Log.w("MicroMsg.GameRecorderMgr", "hy: switch failed!");
                            this.luL.a(1, -1, "view switch failed", null);
                            this.lvh.a(true, false, new kotlin.g.a.b<Boolean, Void>() {
                                /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass11.AnonymousClass2 */

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // kotlin.g.a.b
                                public final /* synthetic */ Void invoke(Boolean bool) {
                                    AppMethodBeat.i(226637);
                                    Log.i("MicroMsg.GameRecorderMgr", "force change result: %b", bool);
                                    AppMethodBeat.o(226637);
                                    return null;
                                }
                            });
                        }
                        AppMethodBeat.o(45340);
                        return null;
                    }
                });
                AppMethodBeat.o(45158);
            }
        } else if ("pause".equalsIgnoreCase(optString)) {
            if (!cVar2.getCurrentPageView().cwV) {
                Log.w("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: current game is not in foreground. ignore pause!");
                a(cVar2, i2, 2, -2, "can not pause in background");
                AppMethodBeat.o(45158);
                return;
            }
            g(cVar2).e(new com.tencent.mm.plugin.appbrand.game.g.d<String>() {
                /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                    AppMethodBeat.i(45150);
                    Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: pause result %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        e.this.a(cVar2, i2, (Map<String, Object>) null);
                        e.this.lsK.e(cVar2);
                        AppMethodBeat.o(45150);
                        return;
                    }
                    e.a(e.this, cVar2, i2, i2, i3, str);
                    AppMethodBeat.o(45150);
                }
            });
            AppMethodBeat.o(45158);
        } else if ("resume".equalsIgnoreCase(optString)) {
            if (!cVar2.getCurrentPageView().cwV) {
                Log.w("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: current game is not in foreground. ignore resume!");
                a(cVar2, i2, 2, -2, "can not resume in background");
                AppMethodBeat.o(45158);
                return;
            }
            g(cVar2).f(new com.tencent.mm.plugin.appbrand.game.g.d<String>() {
                /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                    AppMethodBeat.i(45151);
                    Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: resume result %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        e.this.a(cVar2, i2, (Map<String, Object>) null);
                        e.this.lsK.f(cVar2);
                        AppMethodBeat.o(45151);
                        return;
                    }
                    e.a(e.this, cVar2, i2, i2, i3, str);
                    AppMethodBeat.o(45151);
                }
            });
            AppMethodBeat.o(45158);
        } else if ("abort".equalsIgnoreCase(optString)) {
            com.tencent.mm.plugin.appbrand.game.g.b g3 = g(cVar2);
            AnonymousClass6 r42 = new com.tencent.mm.plugin.appbrand.game.g.d<String>() {
                /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass6 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                    AppMethodBeat.i(45152);
                    Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: abort result %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        e.this.a(cVar2, i2, (Map<String, Object>) null);
                        a aVar = e.this.lsK;
                        aVar.g(cVar2);
                        Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch abort");
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("state", "abort");
                        aVar.L(hashMap).bEo();
                        AppMethodBeat.o(45152);
                        return;
                    }
                    e.a(e.this, cVar2, i2, i2, i3, str);
                    AppMethodBeat.o(45152);
                }
            };
            Log.i("MicroMsg.GameRecorderMgr", "hy: trigger abort");
            g3.luO.postToWorker(new Runnable(r42) {
                /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass17 */
                final /* synthetic */ d luL;

                {
                    this.luL = r2;
                }

                public final void run() {
                    AppMethodBeat.i(45356);
                    if (!b.f(b.this)) {
                        Log.w("MicroMsg.GameRecorderMgr", "hy: abort failed: not started");
                        this.luL.a(2, 401, "not start yet!", null);
                        AppMethodBeat.o(45356);
                        return;
                    }
                    b.this.luP.d(new d<String>() {
                        /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass17.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                        @Override // com.tencent.mm.plugin.appbrand.game.g.d
                        public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                            AppMethodBeat.i(45355);
                            b.i(b.this);
                            if (b.this.luP.bDB() == null) {
                                Log.w("MicroMsg.GameRecorderMgr", "hy: abort failed: view lost");
                            }
                            AnonymousClass17.this.luL.a(0, 0, "ok", null);
                            AppMethodBeat.o(45355);
                        }
                    });
                    AppMethodBeat.o(45356);
                }
            });
            AppMethodBeat.o(45158);
        } else if ("stop".equalsIgnoreCase(optString)) {
            com.tencent.mm.plugin.appbrand.game.g.b g4 = g(cVar2);
            AnonymousClass7 r43 = new com.tencent.mm.plugin.appbrand.game.g.d<b.f>() {
                /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass7 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, b.f fVar) {
                    AppMethodBeat.i(45154);
                    b.f fVar2 = fVar;
                    Log.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: stop result %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        e.this.lsM = null;
                        if (!(cVar2.getRuntime() == null || cVar2.getRuntime().kAH == null)) {
                            cVar2.getRuntime().kAH.b(e.this.lsL);
                        }
                        if (fVar2 == null || fVar2.lvx == null || Util.isNullOrNil(fVar2.lvx.getAbsolutePath())) {
                            Log.e("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: callback ok without path!");
                            e.a(e.this, cVar2, i2, 1, -1, "stop success without filePath!");
                            AppMethodBeat.o(45154);
                            return;
                        }
                        final b.a aVar = (b.a) fVar2.lvx;
                        final b.a aVar2 = (b.a) fVar2.lvy;
                        e.g(cVar2).a(aVar.lsB, new com.tencent.mm.plugin.appbrand.game.g.d<b.a>() {
                            /* class com.tencent.mm.plugin.appbrand.game.e.a.e.AnonymousClass7.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                            @Override // com.tencent.mm.plugin.appbrand.game.g.d
                            public final /* synthetic */ void a(int i2, int i3, String str, b.a aVar) {
                                AppMethodBeat.i(45153);
                                b.a aVar2 = aVar;
                                if (i2 == 0 && i3 == 0) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("path", aVar.lsC);
                                    hashMap.put("thumbPath", aVar2.lsC);
                                    e.this.a(cVar2, i2, hashMap);
                                    a aVar3 = e.this.lsK;
                                    s sVar = cVar2;
                                    String str2 = aVar.lsC;
                                    String str3 = aVar2.lsC;
                                    long j2 = aVar2.duration * 1000;
                                    long j3 = aVar2.fileSize;
                                    aVar3.g(sVar);
                                    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch stop: %s, %d, %d", str2, Long.valueOf(j2), Long.valueOf(j3));
                                    HashMap hashMap2 = new HashMap(4);
                                    hashMap2.put("state", "stop");
                                    hashMap2.put("tempFilePath", str2);
                                    hashMap2.put("tempThumbPath", str3);
                                    hashMap2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(j2));
                                    hashMap2.put("fileSize", Long.valueOf(j3));
                                    aVar3.L(hashMap2).bEo();
                                    AppMethodBeat.o(45153);
                                    return;
                                }
                                e.a(e.this, cVar2, i2, i2, i3, str);
                                AppMethodBeat.o(45153);
                            }
                        });
                        AppMethodBeat.o(45154);
                        return;
                    }
                    e.a(e.this, cVar2, i2, i2, i3, str);
                    AppMethodBeat.o(45154);
                }
            };
            Log.i("MicroMsg.GameRecorderMgr", "hy: trigger stop");
            g4.luO.postToWorker(new Runnable(r43) {
                /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass16 */
                final /* synthetic */ d luL;

                {
                    this.luL = r2;
                }

                public final void run() {
                    AppMethodBeat.i(45354);
                    if (!b.f(b.this)) {
                        Log.w("MicroMsg.GameRecorderMgr", "hy: stop failed: not started");
                        this.luL.a(0, 501, "not start yet!", null);
                        AppMethodBeat.o(45354);
                        return;
                    }
                    b.this.luP.a(new d<String>() {
                        /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass16.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                        @Override // com.tencent.mm.plugin.appbrand.game.g.d
                        public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                            AppMethodBeat.i(45353);
                            if (b.this.luP.bDB() == null) {
                                Log.w("MicroMsg.GameRecorderMgr", "hy: stop failed: view lost");
                                AnonymousClass16.this.luL.a(1, -2, "view lost", null);
                                AppMethodBeat.o(45353);
                            } else if (i2 == 0 && i3 == 0) {
                                f fVar = new f();
                                fVar.lvx = b.this.luS;
                                fVar.lvy = b.this.luT;
                                b.i(b.this);
                                AnonymousClass16.this.luL.a(0, 0, "ok", fVar);
                                AppMethodBeat.o(45353);
                            } else {
                                AnonymousClass16.this.luL.a(i2, i3, str, null);
                                AppMethodBeat.o(45353);
                            }
                        }
                    });
                    AppMethodBeat.o(45354);
                }
            });
            AppMethodBeat.o(45158);
        } else {
            Log.e("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: invalid operate type: %s", optString);
            cVar2.i(i2, h(String.format("fail: not valid operate type: %s", optString), null));
            AppMethodBeat.o(45158);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(s sVar, int i2, Map<String, Object> map) {
        AppMethodBeat.i(45157);
        HashMap hashMap = new HashMap(1);
        hashMap.put("errCode", 0);
        if (map != null) {
            hashMap.putAll(map);
        }
        sVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(45157);
    }

    private void a(s sVar, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(45156);
        String format = String.format("fail: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("errCode", Integer.valueOf(i4));
        sVar.i(i2, n(format, hashMap));
        a aVar = this.lsK;
        aVar.g(sVar);
        Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch error: %d, %s", Integer.valueOf(i4), str);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("state", "error");
        hashMap2.put("errCode", Integer.valueOf(i4));
        hashMap2.put("errMsg", str);
        aVar.L(hashMap2).bEo();
        AppMethodBeat.o(45156);
    }
}
