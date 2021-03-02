package com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a implements com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a {
    String currentAppId;
    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a mJW;
    private b mJX;
    private boolean mJY = false;
    private volatile boolean mJZ = false;
    private c.a mKa = new c.a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.appbrand.a.c.a
        public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
            AppMethodBeat.i(139480);
            if (str.equalsIgnoreCase(a.this.currentAppId)) {
                if (bVar == com.tencent.mm.plugin.appbrand.a.b.BACKGROUND) {
                    if (a.this.mJW != null) {
                        com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar = a.this.mJW;
                        int abL = com.tencent.mm.plugin.appbrand.jsapi.ag.b.abL(str);
                        if (aVar.cEP != null) {
                            aVar.cEP.post(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE  
                                  (wrap: android.os.Handler : 0x0026: IGET  (r2v2 android.os.Handler) = (r0v12 'aVar' com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a) com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.cEP android.os.Handler)
                                  (wrap: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$7 : 0x002a: CONSTRUCTOR  (r3v0 com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$7) = (r0v12 'aVar' com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a), (r1v2 'abL' int) call: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.7.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a, int):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.3.a(java.lang.String, com.tencent.mm.plugin.appbrand.a.b):void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: CONSTRUCTOR  (r3v0 com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$7) = (r0v12 'aVar' com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a), (r1v2 'abL' int) call: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.7.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.3.a(java.lang.String, com.tencent.mm.plugin.appbrand.a.b):void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 34 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 40 more
                                */
                            /*
                                this = this;
                                r4 = 139480(0x220d8, float:1.95453E-40)
                                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                                com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.this
                                java.lang.String r0 = r0.currentAppId
                                boolean r0 = r6.equalsIgnoreCase(r0)
                                if (r0 == 0) goto L_0x0050
                                com.tencent.mm.plugin.appbrand.a.b r0 = com.tencent.mm.plugin.appbrand.a.b.BACKGROUND
                                if (r7 != r0) goto L_0x0034
                                com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.this
                                com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a r0 = r0.mJW
                                if (r0 == 0) goto L_0x0050
                                com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.this
                                com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a r0 = r0.mJW
                                int r1 = com.tencent.mm.plugin.appbrand.jsapi.ag.b.abL(r6)
                                android.os.Handler r2 = r0.cEP
                                if (r2 == 0) goto L_0x0030
                                android.os.Handler r2 = r0.cEP
                                com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$7 r3 = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$7
                                r3.<init>(r1)
                                r2.post(r3)
                            L_0x0030:
                                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                            L_0x0033:
                                return
                            L_0x0034:
                                com.tencent.mm.plugin.appbrand.a.b r0 = com.tencent.mm.plugin.appbrand.a.b.kQH
                                if (r7 != r0) goto L_0x0050
                                com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.this
                                com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a r0 = r0.mJW
                                if (r0 == 0) goto L_0x0050
                                com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.this
                                com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a r0 = r0.mJW
                                android.os.Handler r1 = r0.cEP
                                if (r1 == 0) goto L_0x0050
                                android.os.Handler r1 = r0.cEP
                                com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$5 r2 = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$5
                                r2.<init>()
                                r1.post(r2)
                            L_0x0050:
                                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                                goto L_0x0033
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.AnonymousClass3.a(java.lang.String, com.tencent.mm.plugin.appbrand.a.b):void");
                        }
                    };

                    public a() {
                        AppMethodBeat.i(139481);
                        AppMethodBeat.o(139481);
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b Qa() {
                        AppMethodBeat.i(139482);
                        b bVar = new b();
                        AppMethodBeat.o(139482);
                        return bVar;
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c Qb() {
                        AppMethodBeat.i(139483);
                        com.tencent.mm.plugin.appbrand.jsapi.ag.c.c cVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.c();
                        AppMethodBeat.o(139483);
                        return cVar;
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar) {
                        this.mJW = aVar;
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final void m(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                        if (aVar instanceof b) {
                            this.mJX = (b) aVar;
                        }
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final boolean j(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                        final int i2;
                        AppMethodBeat.i(139484);
                        if (!(aVar instanceof b)) {
                            AppMethodBeat.o(139484);
                            return false;
                        }
                        JSONObject Ps = aVar.Ps();
                        f fVar = ((b) aVar).lqg;
                        final ac acVar = null;
                        if (fVar instanceof ac) {
                            acVar = (ac) fVar;
                        } else if (fVar instanceof s) {
                            acVar = ((s) fVar).getCurrentPageView();
                        }
                        if (acVar == null) {
                            Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
                            AppMethodBeat.o(139484);
                            return false;
                        } else if (Ps == null || !Ps.has("data")) {
                            AppMethodBeat.o(139484);
                            return false;
                        } else {
                            JSONArray optJSONArray = Ps.optJSONArray("data");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
                                AppMethodBeat.o(139484);
                                return false;
                            }
                            switch (optJSONArray.optInt(0, 0)) {
                                case -90:
                                    i2 = -90;
                                    break;
                                case 0:
                                    i2 = 0;
                                    break;
                                case 90:
                                    i2 = 90;
                                    break;
                                default:
                                    i2 = 90;
                                    break;
                            }
                            acVar.P(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(139478);
                                    if (!acVar.isRunning() || acVar.nmX == null) {
                                        Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
                                        AppMethodBeat.o(139478);
                                        return;
                                    }
                                    d fullscreenImpl = acVar.nmX.getFullscreenImpl();
                                    View wrapperView = acVar.nmX.getWrapperView();
                                    if (fullscreenImpl == null || wrapperView == null) {
                                        Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", fullscreenImpl, wrapperView);
                                        AppMethodBeat.o(139478);
                                        return;
                                    }
                                    fullscreenImpl.N(wrapperView, i2);
                                    Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", Integer.valueOf(i2));
                                    AppMethodBeat.o(139478);
                                }
                            });
                            AppMethodBeat.o(139484);
                            return true;
                        }
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final boolean k(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                        final ac acVar;
                        AppMethodBeat.i(139485);
                        if (!(aVar instanceof b)) {
                            AppMethodBeat.o(139485);
                            return false;
                        }
                        f fVar = ((b) aVar).lqg;
                        if (fVar instanceof ac) {
                            acVar = (ac) fVar;
                        } else if (fVar instanceof s) {
                            acVar = ((s) fVar).getCurrentPageView();
                        } else {
                            acVar = null;
                        }
                        if (acVar == null) {
                            Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
                            AppMethodBeat.o(139485);
                            return false;
                        }
                        acVar.P(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(139479);
                                if (!acVar.isRunning() || acVar.nmX == null) {
                                    Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
                                    AppMethodBeat.o(139479);
                                    return;
                                }
                                d fullscreenImpl = acVar.nmX.getFullscreenImpl();
                                if (fullscreenImpl != null) {
                                    fullscreenImpl.btC();
                                    Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen");
                                    AppMethodBeat.o(139479);
                                    return;
                                }
                                Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, state error");
                                AppMethodBeat.o(139479);
                            }
                        });
                        AppMethodBeat.o(139485);
                        return true;
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Bitmap bitmap) {
                        AppMethodBeat.i(139486);
                        if (!(aVar instanceof b)) {
                            AppMethodBeat.o(139486);
                        } else if (bitmap == null || bitmap.isRecycled()) {
                            Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
                            aVar.dP("fail:snapshot error");
                            AppMethodBeat.o(139486);
                        } else {
                            f fVar = ((b) aVar).lqg;
                            String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            try {
                                BitmapUtil.saveBitmapToImage(bitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
                                i<String> iVar = new i<>();
                                if (fVar.getFileSystem() == null) {
                                    aVar.dP("fail");
                                    AppMethodBeat.o(139486);
                                } else if (fVar.getFileSystem().a(new o(str), "jpg", true, iVar) != m.OK) {
                                    Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
                                    aVar.dP("fail:snapshot error");
                                    AppMethodBeat.o(139486);
                                } else {
                                    if (bitmap != null && !bitmap.isRecycled()) {
                                        Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + bitmap.toString());
                                        bitmap.recycle();
                                    }
                                    Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, actualPath:%s path:%s", str, iVar.value);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("tempImagePath", iVar.value);
                                    hashMap.put("width", Integer.valueOf(width));
                                    hashMap.put("height", Integer.valueOf(height));
                                    aVar.f("ok", hashMap);
                                    AppMethodBeat.o(139486);
                                }
                            } catch (IOException e2) {
                                Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", e2);
                                aVar.dP("fail:snapshot error");
                                AppMethodBeat.o(139486);
                            }
                        }
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Bundle bundle) {
                        AppMethodBeat.i(215861);
                        AppBrandRuntime y = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar);
                        if (y != null) {
                            this.currentAppId = y.mAppId;
                            y.kAH.a(this.mKa);
                            if (bundle.getBoolean("isVoip", false)) {
                                this.mJY = true;
                                if (y != null) {
                                    e eVar = (e) y.aw(e.class);
                                    if (eVar == null) {
                                        Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
                                        eVar = new e();
                                        y.a(eVar);
                                    }
                                    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar2 = this.mJW;
                                    eVar.mJP.add(aVar2);
                                    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", aVar2.PH());
                                    AppMethodBeat.o(215861);
                                    return;
                                }
                            } else {
                                this.mJY = false;
                                Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not voip mode");
                            }
                        }
                        AppMethodBeat.o(215861);
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final void l(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                        AppMethodBeat.i(139488);
                        AppBrandRuntime y = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar);
                        if (y != null) {
                            y.kAH.b(this.mKa);
                            if (y != null) {
                                e eVar = (e) y.aw(e.class);
                                if (eVar != null) {
                                    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar2 = this.mJW;
                                    eVar.mJP.remove(aVar2);
                                    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", aVar2.PH());
                                } else {
                                    Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
                                }
                            }
                            Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
                            if (this.mJY) {
                                Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, is voip mode");
                            } else if (this.mJW == null) {
                                Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
                            } else {
                                com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar3 = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) y.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
                                if (aVar3 == null) {
                                    Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
                                } else {
                                    aVar3.f(this.mJW);
                                }
                            }
                        }
                        this.mJZ = true;
                        AppMethodBeat.o(139488);
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final void hY(int i2) {
                        AppMethodBeat.i(215862);
                        Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(i2)));
                        if (this.mJZ) {
                            Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
                            AppMethodBeat.o(215862);
                            return;
                        }
                        switch (i2) {
                            case 2004:
                                Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
                                if (this.mJY) {
                                    Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, is voip mode");
                                    AppMethodBeat.o(215862);
                                    return;
                                } else if (this.mJW == null || this.mJX == null) {
                                    Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
                                    AppMethodBeat.o(215862);
                                    return;
                                } else {
                                    com.tencent.mm.plugin.appbrand.jsapi.ag.a f2 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
                                    if (f2 == null) {
                                        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
                                        AppMethodBeat.o(215862);
                                        return;
                                    }
                                    f2.d(this.mJW);
                                    AppMethodBeat.o(215862);
                                    return;
                                }
                            case -2301:
                            case 2006:
                                Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
                                if (!this.mJY) {
                                    if (this.mJW != null && this.mJX != null) {
                                        com.tencent.mm.plugin.appbrand.jsapi.ag.a f3 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
                                        if (f3 != null) {
                                            f3.e(this.mJW);
                                            break;
                                        } else {
                                            Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
                                            AppMethodBeat.o(215862);
                                            return;
                                        }
                                    } else {
                                        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
                                        AppMethodBeat.o(215862);
                                        return;
                                    }
                                } else {
                                    Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, is voip mode");
                                    AppMethodBeat.o(215862);
                                    return;
                                }
                        }
                        AppMethodBeat.o(215862);
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
                    public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar2, int i2) {
                        e eVar;
                        AppMethodBeat.i(215860);
                        AppBrandRuntime y = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar2);
                        if (y != null) {
                            eVar = (e) y.aw(e.class);
                        } else {
                            eVar = null;
                        }
                        if (eVar != null) {
                            boolean a2 = eVar.a(aVar, i2);
                            AppMethodBeat.o(215860);
                            return a2;
                        }
                        Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
                        AppMethodBeat.o(215860);
                        return false;
                    }
                }
