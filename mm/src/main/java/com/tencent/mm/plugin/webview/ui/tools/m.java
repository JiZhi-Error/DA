package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.q;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.webview.d.a.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.floatball.b;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class m extends f.a {
    private final WeakReference<WebViewUI> Jbp;

    static /* synthetic */ Intent b(m mVar) {
        AppMethodBeat.i(80034);
        Intent intent = mVar.getIntent();
        AppMethodBeat.o(80034);
        return intent;
    }

    public m(WebViewUI webViewUI) {
        AppMethodBeat.i(80008);
        this.Jbp = new WeakReference<>(webViewUI);
        AppMethodBeat.o(80008);
    }

    @Override // com.tencent.mm.plugin.webview.stub.f
    public final boolean f(int i2, final Bundle bundle) {
        AppMethodBeat.i(80009);
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(i2)));
        final WebViewUI webViewUI = this.Jbp.get();
        if (webViewUI == null || webViewUI.isFinishing()) {
            AppMethodBeat.o(80009);
            return false;
        }
        final h hVar = webViewUI.IBw;
        final g gVar = webViewUI.mHi;
        switch (i2) {
            case 13:
                if (bundle != null) {
                    bundle.putString("application_language", webViewUI.mHh.getLanguage());
                    webViewUI.JiQ = WebViewUI.a.bc(bundle);
                    break;
                }
                break;
            case 15:
                final String string = bundle.getString("exdevice_device_id");
                final boolean z = bundle.getBoolean("exdevice_is_complete");
                final byte[] byteArray = bundle.getByteArray("exdevice_broadcast_data");
                final boolean z2 = bundle.getBoolean("exdevice_is_lan_device");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass15 */

                    public final void run() {
                        AppMethodBeat.i(79958);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(79958);
                        } else if (hVar != null) {
                            h hVar = hVar;
                            String str = string;
                            byte[] bArr = byteArray;
                            boolean z = z;
                            boolean z2 = z2;
                            if (!hVar.GBl) {
                                Log.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                                AppMethodBeat.o(79958);
                                return;
                            }
                            Object[] objArr = new Object[3];
                            objArr[0] = str;
                            objArr[1] = Boolean.valueOf(z);
                            objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            Log.i("MicroMsg.JsApiHandler", "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s", objArr);
                            if (Util.isNullOrNil(str)) {
                                Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                AppMethodBeat.o(79958);
                                return;
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("deviceId", str);
                                a.gbs();
                                if (a.cz(bArr) || (bArr != null && z2)) {
                                    jSONObject2.put("base64BroadcastData", Base64.encodeToString(bArr, 2));
                                }
                                jSONArray.put(jSONObject2);
                                jSONObject.put("devices", jSONArray);
                                if (z) {
                                    jSONObject.put("isCompleted", "1");
                                } else {
                                    jSONObject.put("isCompleted", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", e2.getMessage());
                            }
                            String a2 = n.a.a("onScanWXDeviceResult", jSONObject, hVar.IRj, hVar.zpY);
                            try {
                                Log.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", a2);
                                hVar.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a2 + ")", null);
                            } catch (Exception e3) {
                                Log.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", e3.getMessage());
                            }
                            if (!z2) {
                                a.gbs().ISs = bArr;
                            }
                            AppMethodBeat.o(79958);
                        } else {
                            Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", hVar, gVar);
                            AppMethodBeat.o(79958);
                        }
                    }
                });
                break;
            case 16:
                final String string2 = bundle.getString("exdevice_device_id");
                final String string3 = bundle.getString("exdevice_brand_name");
                final byte[] byteArray2 = bundle.getByteArray("exdevice_data");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass16 */

                    public final void run() {
                        AppMethodBeat.i(79959);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(79959);
                            return;
                        }
                        if (hVar != null) {
                            h hVar = hVar;
                            String str = string2;
                            byte[] bArr = byteArray2;
                            String str2 = string3;
                            if (!hVar.GBl) {
                                Log.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                                AppMethodBeat.o(79959);
                                return;
                            }
                            Log.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", str, str2);
                            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || bArr == null) {
                                Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                AppMethodBeat.o(79959);
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("deviceId", str);
                            hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                            MMHandlerThread.postToMainThread(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0085: INVOKE  
                                  (wrap: com.tencent.mm.plugin.webview.d.h$6 : 0x0082: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$6) = 
                                  (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                  (wrap: java.lang.String : 0x007c: INVOKE  (r1v4 java.lang.String) = 
                                  ("onReceiveDataFromWXDevice")
                                  (r3v2 'hashMap' java.util.HashMap)
                                  (wrap: boolean : 0x0078: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                  (wrap: java.lang.String : 0x007a: IGET  (r4v4 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                 call: com.tencent.mm.plugin.webview.d.h.6.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.16.run():void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0082: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$6) = 
                                  (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                  (wrap: java.lang.String : 0x007c: INVOKE  (r1v4 java.lang.String) = 
                                  ("onReceiveDataFromWXDevice")
                                  (r3v2 'hashMap' java.util.HashMap)
                                  (wrap: boolean : 0x0078: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                  (wrap: java.lang.String : 0x007a: IGET  (r4v4 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                 call: com.tencent.mm.plugin.webview.d.h.6.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.16.run():void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 31 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 37 more
                                */
                            /*
                            // Method dump skipped, instructions count: 140
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass16.run():void");
                        }
                    });
                    break;
                case 17:
                    final String string4 = bundle.getString("exdevice_device_id");
                    final boolean z3 = bundle.getBoolean("exdevice_is_bound");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass17 */

                        public final void run() {
                            AppMethodBeat.i(79960);
                            if (webViewUI == null || webViewUI.isFinishing()) {
                                AppMethodBeat.o(79960);
                                return;
                            }
                            if (hVar != null) {
                                h hVar = hVar;
                                String str = string4;
                                boolean z = z3;
                                if (!hVar.GBl) {
                                    Log.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                                    AppMethodBeat.o(79960);
                                    return;
                                }
                                Log.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", str, Boolean.valueOf(z));
                                if (Util.isNullOrNil(str)) {
                                    Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                    AppMethodBeat.o(79960);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("deviceId", str);
                                if (z) {
                                    hashMap.put("state", "bind");
                                } else {
                                    hashMap.put("state", "unbind");
                                }
                                MMHandlerThread.postToMainThread(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0080: INVOKE  
                                      (wrap: com.tencent.mm.plugin.webview.d.h$7 : 0x007d: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$7) = 
                                      (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                      (wrap: java.lang.String : 0x0077: INVOKE  (r1v3 java.lang.String) = 
                                      ("onWXDeviceBindStateChange")
                                      (r3v3 'hashMap' java.util.HashMap)
                                      (wrap: boolean : 0x0073: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                      (wrap: java.lang.String : 0x0075: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                     call: com.tencent.mm.plugin.webview.d.h.7.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.17.run():void, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007d: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$7) = 
                                      (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                      (wrap: java.lang.String : 0x0077: INVOKE  (r1v3 java.lang.String) = 
                                      ("onWXDeviceBindStateChange")
                                      (r3v3 'hashMap' java.util.HashMap)
                                      (wrap: boolean : 0x0073: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                      (wrap: java.lang.String : 0x0075: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                     call: com.tencent.mm.plugin.webview.d.h.7.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.17.run():void, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 31 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 37 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 145
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass17.run():void");
                            }
                        });
                        break;
                    case 18:
                        final boolean z4 = bundle.getBoolean("exdevice_bt_state");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass18 */

                            public final void run() {
                                AppMethodBeat.i(79961);
                                if (webViewUI == null || webViewUI.isFinishing()) {
                                    AppMethodBeat.o(79961);
                                    return;
                                }
                                if (hVar != null) {
                                    h hVar = hVar;
                                    boolean z = z4;
                                    if (!hVar.GBl) {
                                        Log.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                                        AppMethodBeat.o(79961);
                                        return;
                                    }
                                    Log.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", Boolean.valueOf(z));
                                    HashMap hashMap = new HashMap();
                                    if (z) {
                                        hashMap.put("state", "on");
                                    } else {
                                        hashMap.put("state", "off");
                                    }
                                    MMHandlerThread.postToMainThread(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: INVOKE  
                                          (wrap: com.tencent.mm.plugin.webview.d.h$8 : 0x005f: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$8) = 
                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                          (wrap: java.lang.String : 0x0059: INVOKE  (r1v3 java.lang.String) = 
                                          ("onWXDeviceBluetoothStateChange")
                                          (r2v2 'hashMap' java.util.HashMap)
                                          (wrap: boolean : 0x0055: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                          (wrap: java.lang.String : 0x0057: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                         call: com.tencent.mm.plugin.webview.d.h.8.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.18.run():void, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$8) = 
                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                          (wrap: java.lang.String : 0x0059: INVOKE  (r1v3 java.lang.String) = 
                                          ("onWXDeviceBluetoothStateChange")
                                          (r2v2 'hashMap' java.util.HashMap)
                                          (wrap: boolean : 0x0055: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                          (wrap: java.lang.String : 0x0057: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                         call: com.tencent.mm.plugin.webview.d.h.8.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.18.run():void, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 27 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 33 more
                                        */
                                    /*
                                    // Method dump skipped, instructions count: 115
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass18.run():void");
                                }
                            });
                            break;
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                            break;
                        case 47:
                            final boolean z5 = bundle.getBoolean("exdevice_lan_state");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass19 */

                                public final void run() {
                                    AppMethodBeat.i(79962);
                                    if (webViewUI == null || webViewUI.isFinishing()) {
                                        AppMethodBeat.o(79962);
                                        return;
                                    }
                                    if (hVar != null) {
                                        h hVar = hVar;
                                        boolean z = z5;
                                        if (!hVar.GBl) {
                                            Log.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                                            AppMethodBeat.o(79962);
                                            return;
                                        }
                                        Log.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", Boolean.valueOf(z));
                                        HashMap hashMap = new HashMap();
                                        if (z) {
                                            hashMap.put("state", "on");
                                        } else {
                                            hashMap.put("state", "off");
                                        }
                                        MMHandlerThread.postToMainThread(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: INVOKE  
                                              (wrap: com.tencent.mm.plugin.webview.d.h$9 : 0x005f: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$9) = 
                                              (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                              (wrap: java.lang.String : 0x0059: INVOKE  (r1v3 java.lang.String) = 
                                              ("onWXDeviceLanStateChange")
                                              (r2v2 'hashMap' java.util.HashMap)
                                              (wrap: boolean : 0x0055: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                              (wrap: java.lang.String : 0x0057: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                             call: com.tencent.mm.plugin.webview.d.h.9.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.19.run():void, file: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$9) = 
                                              (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                              (wrap: java.lang.String : 0x0059: INVOKE  (r1v3 java.lang.String) = 
                                              ("onWXDeviceLanStateChange")
                                              (r2v2 'hashMap' java.util.HashMap)
                                              (wrap: boolean : 0x0055: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                              (wrap: java.lang.String : 0x0057: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                             call: com.tencent.mm.plugin.webview.d.h.9.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.19.run():void, file: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 27 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	... 33 more
                                            */
                                        /*
                                        // Method dump skipped, instructions count: 115
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass19.run():void");
                                    }
                                });
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                                String[] stringArray = bundle.getStringArray("msgIds");
                                String[] stringArray2 = bundle.getStringArray("contents");
                                String[] stringArray3 = bundle.getStringArray("senders");
                                int[] intArray = bundle.getIntArray("msgTypes");
                                int[] intArray2 = bundle.getIntArray("msgTimes");
                                final JSONArray jSONArray = new JSONArray();
                                int length = stringArray == null ? 0 : stringArray.length;
                                for (int i3 = 0; i3 < length; i3++) {
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("newMsgId", stringArray[i3]);
                                        jSONObject.put("content", stringArray2[i3]);
                                        jSONObject.put("sender", stringArray3[i3]);
                                        jSONObject.put("msgType", intArray[i3]);
                                        jSONObject.put("msgTime", intArray2[i3]);
                                        jSONArray.put(jSONObject);
                                    } catch (JSONException e2) {
                                        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetMsgProofItems exception " + e2.getMessage());
                                    }
                                }
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass22 */

                                    public final void run() {
                                        AppMethodBeat.i(79965);
                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                            AppMethodBeat.o(79965);
                                            return;
                                        }
                                        if (hVar != null) {
                                            h hVar = hVar;
                                            JSONArray jSONArray = jSONArray;
                                            if (!hVar.GBl) {
                                                Log.e("MicroMsg.JsApiHandler", "not ready");
                                                AppMethodBeat.o(79965);
                                                return;
                                            } else if (jSONArray == null) {
                                                Log.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                                                AppMethodBeat.o(79965);
                                                return;
                                            } else {
                                                Log.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                                                HashMap hashMap = new HashMap();
                                                hashMap.put("msgs", jSONArray);
                                                MMHandlerThread.postToMainThread(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: INVOKE  
                                                      (wrap: com.tencent.mm.plugin.webview.d.h$72 : 0x005f: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$72) = 
                                                      (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                      (wrap: java.lang.String : 0x0059: INVOKE  (r1v2 java.lang.String) = 
                                                      ("onGetMsgProofItems")
                                                      (r2v2 'hashMap' java.util.HashMap)
                                                      (wrap: boolean : 0x0055: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                      (wrap: java.lang.String : 0x0057: IGET  (r4v0 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                     call: com.tencent.mm.plugin.webview.d.h.72.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.22.run():void, file: classes.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$72) = 
                                                      (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                      (wrap: java.lang.String : 0x0059: INVOKE  (r1v2 java.lang.String) = 
                                                      ("onGetMsgProofItems")
                                                      (r2v2 'hashMap' java.util.HashMap)
                                                      (wrap: boolean : 0x0055: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                      (wrap: java.lang.String : 0x0057: IGET  (r4v0 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                     call: com.tencent.mm.plugin.webview.d.h.72.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.22.run():void, file: classes.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                    	... 30 more
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                    	... 36 more
                                                    */
                                                /*
                                                // Method dump skipped, instructions count: 105
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass22.run():void");
                                            }
                                        });
                                        break;
                                    case 60:
                                    case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                                    case 62:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH /*{ENCODED_INT: 127}*/:
                                    case 128:
                                    case 133:
                                    case com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX:
                                    case c.CTRL_INDEX:
                                    case r.CTRL_INDEX:
                                    case 137:
                                    case 138:
                                    case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                                    case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                                    case 144:
                                    case 145:
                                    case TbsListener.ErrorCode.NEEDDOWNLOAD_8 /*{ENCODED_INT: 147}*/:
                                    case 148:
                                    case 149:
                                    case 150:
                                    case 151:
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /*{ENCODED_INT: 100001}*/:
                                    case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND /*{ENCODED_INT: 100002}*/:
                                    case 200000:
                                    case 200001:
                                    case 200002:
                                    case 200003:
                                        if (webViewUI != null && !webViewUI.isFinishing()) {
                                            webViewUI.m(i2, bundle);
                                            break;
                                        }
                                    case 70:
                                        String string5 = bundle.getString("service_click_tid");
                                        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", string5);
                                        webViewUI.Jjq = string5;
                                        webViewUI.Jjr = System.currentTimeMillis();
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass26 */

                                            public final void run() {
                                                AppMethodBeat.i(79969);
                                                if (webViewUI == null || webViewUI.isFinishing()) {
                                                    AppMethodBeat.o(79969);
                                                    return;
                                                }
                                                if (webViewUI.pGj != null) {
                                                    d.INSTANCE.a(webViewUI.pGj, ub.class);
                                                    if (webViewUI.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false)) {
                                                        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                                                        EventCenter.instance.publish(new ub());
                                                    }
                                                }
                                                AppMethodBeat.o(79969);
                                            }
                                        });
                                        break;
                                    case 71:
                                    case 72:
                                        AnonymousClass25 r2 = new Runnable() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass25 */

                                            public final void run() {
                                                String str;
                                                String str2;
                                                Bundle bundle;
                                                boolean z;
                                                AppMethodBeat.i(79968);
                                                if (webViewUI == null || webViewUI.isFinishing()) {
                                                    AppMethodBeat.o(79968);
                                                    return;
                                                }
                                                if (bundle != null) {
                                                    String string = bundle.getString("key_bag_icon");
                                                    if (!Util.isNullOrNil(string)) {
                                                        if (webViewUI.Jjs != null) {
                                                            webViewUI.Jjs.setIcon(Util.nullAsNil(string));
                                                        }
                                                        if (webViewUI.Jju != null) {
                                                            webViewUI.Jju.agS(string);
                                                        }
                                                        webViewUI.Jjt.agS(string);
                                                    }
                                                    String string2 = bundle.getString("key_brand_name");
                                                    String string3 = bundle.getString("key_brand_user_name");
                                                    String string4 = bundle.getString("key_title");
                                                    if (!Util.isNullOrNil(string3)) {
                                                        webViewUI.getIntent().putExtra("srcUsername", string3);
                                                    }
                                                    Log.i("FloatBall", "currentMpInfo, brandName:%s, title:%s", string2, string4);
                                                    if (!(webViewUI.ILE == null || (bundle = bundle) == null)) {
                                                        String string5 = bundle.getString("key_url");
                                                        if (Util.isNullOrNil(string5)) {
                                                            Log.w("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url is null");
                                                        } else {
                                                            Log.d("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url %s", string5);
                                                            String ahz = o.ahz(string5);
                                                            Bundle bundle2 = o.Jgg.get(ahz);
                                                            if (bundle2 == null) {
                                                                o.Jgg.put(ahz, bundle);
                                                            } else {
                                                                if (bundle2.getBoolean("key_current_info_show")) {
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                                bundle.putBoolean("key_current_info_show", z);
                                                                o.Jgg.put(ahz, bundle);
                                                            }
                                                        }
                                                    }
                                                    if (webViewUI.Jjl != null) {
                                                        i iVar = webViewUI.Jjl;
                                                        Bundle bundle3 = bundle;
                                                        if (bundle3 != null) {
                                                            i.Jgg.put(i.ahz(iVar.nKc), Boolean.valueOf(bundle3.getBoolean("key_forbidForward")));
                                                        }
                                                    }
                                                    if (!Util.isNullOrNil(string4) || webViewUI.getMMTitle() == null) {
                                                        str = string4;
                                                    } else {
                                                        str = webViewUI.getMMTitle().toString();
                                                    }
                                                    if (!Util.isNullOrNil(str)) {
                                                        if (webViewUI.Jju != null) {
                                                            webViewUI.Jju.aCM(str);
                                                        }
                                                        webViewUI.Jjt.agT(str);
                                                        if (webViewUI.Jjs != null) {
                                                            webViewUI.Jjs.setTitle(str);
                                                        }
                                                    } else {
                                                        b bVar = webViewUI.Jjt;
                                                        if (bVar.oWE != null) {
                                                            str2 = bVar.oWE.name;
                                                        } else {
                                                            str2 = null;
                                                        }
                                                        if (Util.isNullOrNil(str2)) {
                                                            webViewUI.Jjt.agT(string2);
                                                        }
                                                        if (Util.isNullOrNil(webViewUI.Jju.IVb.title)) {
                                                            webViewUI.Jju.aCM(string2);
                                                        }
                                                        if (webViewUI.Jjs != null && Util.isNullOrNil(webViewUI.Jjs.getTitle()) && !Util.isNullOrNil(string2)) {
                                                            webViewUI.Jjs.setTitle(string2);
                                                        }
                                                    }
                                                    if (!Util.isNullOrNil(string2) && webViewUI.Jju != null) {
                                                        webViewUI.Jju.aGL(string2);
                                                    }
                                                    if (webViewUI.Jjs != null) {
                                                        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(webViewUI.Jjs);
                                                    }
                                                }
                                                AppMethodBeat.o(79968);
                                            }
                                        };
                                        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                                            r2.run();
                                            break;
                                        } else {
                                            com.tencent.f.h.RTc.aX(r2);
                                            break;
                                        }
                                    case 90:
                                        final String string6 = bundle.getString("webview_network_type");
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass24 */

                                            public final void run() {
                                                AppMethodBeat.i(79967);
                                                if (webViewUI == null || webViewUI.isFinishing()) {
                                                    AppMethodBeat.o(79967);
                                                    return;
                                                }
                                                if (hVar != null) {
                                                    hVar.aYj(string6);
                                                }
                                                AppMethodBeat.o(79967);
                                            }
                                        });
                                        break;
                                    case 254:
                                        final String string7 = bundle.getString("game_haowan_publish_post_id");
                                        final int i4 = bundle.getInt("game_haowan_publish_retcode");
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass28 */

                                            public final void run() {
                                                AppMethodBeat.i(79971);
                                                if (webViewUI == null || webViewUI.isFinishing()) {
                                                    AppMethodBeat.o(79971);
                                                    return;
                                                }
                                                if (hVar != null) {
                                                    h hVar = hVar;
                                                    String str = string7;
                                                    int i2 = i4;
                                                    if (!hVar.GBl) {
                                                        Log.e("MicroMsg.JsApiHandler", "not ready");
                                                        AppMethodBeat.o(79971);
                                                        return;
                                                    }
                                                    HashMap hashMap = new HashMap();
                                                    hashMap.put(ShareConstants.RESULT_POST_ID, str);
                                                    hashMap.put("result", Integer.valueOf(i2));
                                                    MMHandlerThread.postToMainThread(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0056: INVOKE  
                                                          (wrap: com.tencent.mm.plugin.webview.d.h$74 : 0x0053: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$74) = 
                                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                          (wrap: java.lang.String : 0x004d: INVOKE  (r1v3 java.lang.String) = 
                                                          ("onPublishHaowanEnd")
                                                          (r3v1 'hashMap' java.util.HashMap)
                                                          (wrap: boolean : 0x0049: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                          (wrap: java.lang.String : 0x004b: IGET  (r4v1 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                         call: com.tencent.mm.plugin.webview.d.h.74.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.28.run():void, file: classes.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0053: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$74) = 
                                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                          (wrap: java.lang.String : 0x004d: INVOKE  (r1v3 java.lang.String) = 
                                                          ("onPublishHaowanEnd")
                                                          (r3v1 'hashMap' java.util.HashMap)
                                                          (wrap: boolean : 0x0049: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                          (wrap: java.lang.String : 0x004b: IGET  (r4v1 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                         call: com.tencent.mm.plugin.webview.d.h.74.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.28.run():void, file: classes.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	... 27 more
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 33 more
                                                        */
                                                    /*
                                                        this = this;
                                                        r5 = 79971(0x13863, float:1.12063E-40)
                                                        com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                                        com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = r4
                                                        if (r0 == 0) goto L_0x0012
                                                        com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = r4
                                                        boolean r0 = r0.isFinishing()
                                                        if (r0 == 0) goto L_0x0016
                                                    L_0x0012:
                                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                    L_0x0015:
                                                        return
                                                    L_0x0016:
                                                        com.tencent.mm.plugin.webview.d.h r0 = r5
                                                        if (r0 == 0) goto L_0x0059
                                                        com.tencent.mm.plugin.webview.d.h r0 = r5
                                                        java.lang.String r1 = r6
                                                        int r2 = r7
                                                        boolean r3 = r0.GBl
                                                        if (r3 != 0) goto L_0x0031
                                                        java.lang.String r0 = "MicroMsg.JsApiHandler"
                                                        java.lang.String r1 = "not ready"
                                                        com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                        goto L_0x0015
                                                    L_0x0031:
                                                        java.util.HashMap r3 = new java.util.HashMap
                                                        r3.<init>()
                                                        java.lang.String r4 = "postId"
                                                        r3.put(r4, r1)
                                                        java.lang.String r1 = "result"
                                                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                                                        r3.put(r1, r2)
                                                        java.lang.String r1 = "onPublishHaowanEnd"
                                                        boolean r2 = r0.IRj
                                                        java.lang.String r4 = r0.zpY
                                                        java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r1, r3, r2, r4)
                                                        com.tencent.mm.plugin.webview.d.h$74 r2 = new com.tencent.mm.plugin.webview.d.h$74
                                                        r2.<init>(r1)
                                                        com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                                                    L_0x0059:
                                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                        goto L_0x0015
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass28.run():void");
                                                }
                                            });
                                            break;
                                        case 255:
                                            final String string8 = bundle.getString("game_haowan_publish_post_id");
                                            final float f2 = bundle.getFloat("game_haowan_publish_progress");
                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass29 */

                                                public final void run() {
                                                    AppMethodBeat.i(79972);
                                                    if (webViewUI == null || webViewUI.isFinishing()) {
                                                        AppMethodBeat.o(79972);
                                                        return;
                                                    }
                                                    if (hVar != null) {
                                                        h hVar = hVar;
                                                        String str = string8;
                                                        float f2 = f2;
                                                        if (!hVar.GBl) {
                                                            Log.e("MicroMsg.JsApiHandler", "not ready");
                                                            AppMethodBeat.o(79972);
                                                            return;
                                                        }
                                                        HashMap hashMap = new HashMap();
                                                        hashMap.put(ShareConstants.RESULT_POST_ID, str);
                                                        hashMap.put("percent", Float.valueOf(f2));
                                                        MMHandlerThread.postToMainThread(
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0056: INVOKE  
                                                              (wrap: com.tencent.mm.plugin.webview.d.h$76 : 0x0053: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$76) = 
                                                              (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                              (wrap: java.lang.String : 0x004d: INVOKE  (r1v3 java.lang.String) = 
                                                              ("onPublishHaowanProgress")
                                                              (r3v1 'hashMap' java.util.HashMap)
                                                              (wrap: boolean : 0x0049: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                              (wrap: java.lang.String : 0x004b: IGET  (r4v1 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                             call: com.tencent.mm.plugin.webview.d.h.76.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.29.run():void, file: classes.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0053: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$76) = 
                                                              (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                              (wrap: java.lang.String : 0x004d: INVOKE  (r1v3 java.lang.String) = 
                                                              ("onPublishHaowanProgress")
                                                              (r3v1 'hashMap' java.util.HashMap)
                                                              (wrap: boolean : 0x0049: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                              (wrap: java.lang.String : 0x004b: IGET  (r4v1 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                             call: com.tencent.mm.plugin.webview.d.h.76.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.29.run():void, file: classes.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                            	... 27 more
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                            	... 33 more
                                                            */
                                                        /*
                                                            this = this;
                                                            r5 = 79972(0x13864, float:1.12065E-40)
                                                            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                                            com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = r4
                                                            if (r0 == 0) goto L_0x0012
                                                            com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = r4
                                                            boolean r0 = r0.isFinishing()
                                                            if (r0 == 0) goto L_0x0016
                                                        L_0x0012:
                                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                        L_0x0015:
                                                            return
                                                        L_0x0016:
                                                            com.tencent.mm.plugin.webview.d.h r0 = r5
                                                            if (r0 == 0) goto L_0x0059
                                                            com.tencent.mm.plugin.webview.d.h r0 = r5
                                                            java.lang.String r1 = r6
                                                            float r2 = r7
                                                            boolean r3 = r0.GBl
                                                            if (r3 != 0) goto L_0x0031
                                                            java.lang.String r0 = "MicroMsg.JsApiHandler"
                                                            java.lang.String r1 = "not ready"
                                                            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                            goto L_0x0015
                                                        L_0x0031:
                                                            java.util.HashMap r3 = new java.util.HashMap
                                                            r3.<init>()
                                                            java.lang.String r4 = "postId"
                                                            r3.put(r4, r1)
                                                            java.lang.String r1 = "percent"
                                                            java.lang.Float r2 = java.lang.Float.valueOf(r2)
                                                            r3.put(r1, r2)
                                                            java.lang.String r1 = "onPublishHaowanProgress"
                                                            boolean r2 = r0.IRj
                                                            java.lang.String r4 = r0.zpY
                                                            java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r1, r3, r2, r4)
                                                            com.tencent.mm.plugin.webview.d.h$76 r2 = new com.tencent.mm.plugin.webview.d.h$76
                                                            r2.<init>(r1)
                                                            com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                                                        L_0x0059:
                                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                            goto L_0x0015
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass29.run():void");
                                                    }
                                                });
                                                break;
                                            case 1001:
                                                if (!webViewUI.isFinishing()) {
                                                    webViewUI.finish();
                                                    break;
                                                }
                                                break;
                                            case 1002:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass1 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79944);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79944);
                                                            return;
                                                        }
                                                        if (!(hVar == null || gVar == null || !gVar.gdH().pP(42))) {
                                                            hVar.j(bundle, "download_succ");
                                                        }
                                                        AppMethodBeat.o(79944);
                                                    }
                                                });
                                                break;
                                            case 1003:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass12 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79955);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79955);
                                                            return;
                                                        }
                                                        if (!(hVar == null || gVar == null || !gVar.gdH().pP(42))) {
                                                            hVar.j(bundle, "download_fail");
                                                        }
                                                        AppMethodBeat.o(79955);
                                                    }
                                                });
                                                break;
                                            case 1004:
                                                final String string9 = bundle.getString("exdevice_device_id");
                                                final int i5 = bundle.getInt("exdevice_on_state_change_state");
                                                final Boolean valueOf = Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"));
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass58 */

                                                    public final void run() {
                                                        boolean z;
                                                        boolean z2 = false;
                                                        AppMethodBeat.i(80006);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(80006);
                                                        } else if (hVar != null && gVar != null) {
                                                            gVar.gdH();
                                                            hVar.gj(string9, i5);
                                                            AppMethodBeat.o(80006);
                                                        } else if (hVar == null || !valueOf.booleanValue()) {
                                                            Object[] objArr = new Object[2];
                                                            if (hVar == null) {
                                                                z = true;
                                                            } else {
                                                                z = false;
                                                            }
                                                            objArr[0] = Boolean.valueOf(z);
                                                            if (gVar == null) {
                                                                z2 = true;
                                                            }
                                                            objArr[1] = Boolean.valueOf(z2);
                                                            Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "something null, %s, %s", objArr);
                                                            AppMethodBeat.o(80006);
                                                        } else {
                                                            hVar.gj(string9, i5);
                                                            AppMethodBeat.o(80006);
                                                        }
                                                    }
                                                });
                                                break;
                                            case 1006:
                                                if (hVar != null) {
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass14 */

                                                        public final void run() {
                                                            boolean z = true;
                                                            AppMethodBeat.i(79957);
                                                            if (webViewUI == null || webViewUI.isFinishing()) {
                                                                AppMethodBeat.o(79957);
                                                                return;
                                                            }
                                                            if (!bundle.containsKey("jsapi_preverify_fun_list") || gVar == null) {
                                                                Object[] objArr = new Object[1];
                                                                if (gVar == null) {
                                                                    z = false;
                                                                }
                                                                objArr[0] = Boolean.valueOf(z);
                                                                Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "has JSAPI_CONTROL_BYTES wvPerm %b", objArr);
                                                            } else {
                                                                gVar.aR(bundle);
                                                            }
                                                            if (hVar != null) {
                                                                hVar.gaY();
                                                            }
                                                            AppMethodBeat.o(79957);
                                                        }
                                                    });
                                                    break;
                                                }
                                                break;
                                            case 1007:
                                                final long j2 = bundle.getLong("download_manager_downloadid");
                                                final int i6 = bundle.getInt("download_manager_progress");
                                                final float f3 = bundle.getFloat("download_manager_progress_float");
                                                final String string10 = bundle.getString("download_manager_appid", "");
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass57 */

                                                    public final void run() {
                                                        AppMethodBeat.i(80005);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(80005);
                                                            return;
                                                        }
                                                        if (!(hVar == null || gVar == null || !gVar.gdH().pP(42))) {
                                                            hVar.a(string10, j2, i6, f3);
                                                        }
                                                        AppMethodBeat.o(80005);
                                                    }
                                                });
                                                break;
                                            case 1008:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass23 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79966);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79966);
                                                            return;
                                                        }
                                                        if (!(hVar == null || gVar == null || !gVar.gdH().pP(42))) {
                                                            hVar.j(bundle, "download_removed");
                                                        }
                                                        AppMethodBeat.o(79966);
                                                    }
                                                });
                                                break;
                                            case 1010:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass34 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79977);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79977);
                                                            return;
                                                        }
                                                        if (!(hVar == null || gVar == null || !gVar.gdH().pP(42))) {
                                                            hVar.j(bundle, "download_pause");
                                                        }
                                                        AppMethodBeat.o(79977);
                                                    }
                                                });
                                                break;
                                            case 1011:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass45 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79988);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79988);
                                                            return;
                                                        }
                                                        if (!(hVar == null || gVar == null || !gVar.gdH().pP(42))) {
                                                            hVar.j(bundle, "download_resumed");
                                                        }
                                                        AppMethodBeat.o(79988);
                                                    }
                                                });
                                                break;
                                            case 1012:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass56 */

                                                    public final void run() {
                                                        AppMethodBeat.i(80003);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(80003);
                                                            return;
                                                        }
                                                        if (!(hVar == null || gVar == null || !gVar.gdH().pP(42))) {
                                                            hVar.j(bundle, "download_start");
                                                        }
                                                        AppMethodBeat.o(80003);
                                                    }
                                                });
                                                break;
                                            case 1013:
                                                if (hVar != null) {
                                                    try {
                                                        LinkedList<cel> linkedList = new LinkedList<>();
                                                        String string11 = bundle.getString("__appId");
                                                        String string12 = bundle.getString("__url");
                                                        if (bundle.containsKey("__webComptList")) {
                                                            Iterator<String> it = bundle.getStringArrayList("__webComptList").iterator();
                                                            while (it.hasNext()) {
                                                                cel cel = new cel();
                                                                cel.parseFrom(bundle.getByteArray(it.next()));
                                                                linkedList.add(cel);
                                                            }
                                                        }
                                                        if (hVar.gbi() != null) {
                                                            hVar.gbi().c(string11, string12, linkedList);
                                                            break;
                                                        }
                                                    } catch (IOException e3) {
                                                        Log.printErrStackTrace("MicroMsg.WebViewStubCallbackAIDLStub", e3, "parse webCompt", new Object[0]);
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2002:
                                                final HashMap hashMap = new HashMap();
                                                hashMap.put("err_msg", bundle.getString("playResult"));
                                                hashMap.put(ch.COL_LOCALID, bundle.getString(ch.COL_LOCALID));
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass8 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79951);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79951);
                                                            return;
                                                        }
                                                        if (hVar != null) {
                                                            hVar.bI(hashMap);
                                                        }
                                                        AppMethodBeat.o(79951);
                                                    }
                                                });
                                                break;
                                            case 2003:
                                                final String string13 = bundle.getString("webview_jssdk_file_item_local_id");
                                                final int i7 = bundle.getInt("webview_jssdk_file_item_progreess");
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass2 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79945);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79945);
                                                            return;
                                                        }
                                                        if (hVar != null) {
                                                            hVar.gk(string13, i7);
                                                        }
                                                        AppMethodBeat.o(79945);
                                                    }
                                                });
                                                break;
                                            case 2004:
                                                final String string14 = bundle.getString("webview_jssdk_file_item_local_id");
                                                final int i8 = bundle.getInt("webview_jssdk_file_item_progreess");
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass4 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79947);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79947);
                                                            return;
                                                        }
                                                        if (hVar != null) {
                                                            hVar.gl(string14, i8);
                                                        }
                                                        AppMethodBeat.o(79947);
                                                    }
                                                });
                                                break;
                                            case 2005:
                                                final String string15 = bundle.getString("webview_jssdk_file_item_local_id");
                                                final int i9 = bundle.getInt("webview_jssdk_file_item_progreess");
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass5 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79948);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79948);
                                                            return;
                                                        }
                                                        if (hVar != null) {
                                                            hVar.gm(string15, i9);
                                                        }
                                                        AppMethodBeat.o(79948);
                                                    }
                                                });
                                                break;
                                            case 2006:
                                                final String string16 = bundle.getString("webview_jssdk_file_item_local_id");
                                                final int i10 = bundle.getInt("webview_jssdk_file_item_progreess");
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass6 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79949);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79949);
                                                            return;
                                                        }
                                                        if (hVar != null) {
                                                            hVar.gn(string16, i10);
                                                        }
                                                        AppMethodBeat.o(79949);
                                                    }
                                                });
                                                break;
                                            case 2007:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass10 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79953);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79953);
                                                            return;
                                                        }
                                                        webViewUI.setMMSubTitle(R.string.j08);
                                                        AppMethodBeat.o(79953);
                                                    }
                                                });
                                                break;
                                            case 2008:
                                                final HashMap hashMap2 = new HashMap();
                                                hashMap2.put(ch.COL_LOCALID, bundle.getString(ch.COL_LOCALID));
                                                hashMap2.put("err_msg", bundle.getString("recordResult"));
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass11 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79954);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79954);
                                                            return;
                                                        }
                                                        webViewUI.setMMSubTitle((String) null);
                                                        if (hVar != null) {
                                                            hVar.bJ(hashMap2);
                                                        }
                                                        AppMethodBeat.o(79954);
                                                    }
                                                });
                                                break;
                                            case 2009:
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass13 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79956);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79956);
                                                            return;
                                                        }
                                                        webViewUI.setMMSubTitle((String) null);
                                                        AppMethodBeat.o(79956);
                                                    }
                                                });
                                                break;
                                            case 2010:
                                                final String string17 = bundle.getString("webview_jssdk_file_item_local_id");
                                                final int i11 = bundle.getInt("webview_jssdk_file_item_progreess");
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass7 */

                                                    public final void run() {
                                                        AppMethodBeat.i(79950);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(79950);
                                                            return;
                                                        }
                                                        if (hVar != null) {
                                                            hVar.go(string17, i11);
                                                        }
                                                        AppMethodBeat.o(79950);
                                                    }
                                                });
                                                break;
                                            case 2011:
                                                final String string18 = bundle.getString("webview_jssdk_file_item_local_id");
                                                final int i12 = bundle.getInt("webview_jssdk_file_item_progreess");
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass59 */

                                                    public final void run() {
                                                        AppMethodBeat.i(80007);
                                                        if (webViewUI == null || webViewUI.isFinishing()) {
                                                            AppMethodBeat.o(80007);
                                                            return;
                                                        }
                                                        if (hVar != null) {
                                                            h hVar = hVar;
                                                            String str = string18;
                                                            int i2 = i12;
                                                            if (!hVar.GBl) {
                                                                Log.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                                                                AppMethodBeat.o(80007);
                                                                return;
                                                            }
                                                            Log.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i2));
                                                            HashMap hashMap = new HashMap();
                                                            hashMap.put(ch.COL_LOCALID, str);
                                                            hashMap.put("percent", Integer.valueOf(i2));
                                                            MMHandlerThread.postToMainThread(
                                                            /*  JADX ERROR: Method code generation error
                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006c: INVOKE  
                                                                  (wrap: com.tencent.mm.plugin.webview.d.h$15 : 0x0069: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$15) = 
                                                                  (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                                  (wrap: java.lang.String : 0x0063: INVOKE  (r1v3 java.lang.String) = 
                                                                  ("onMediaFileUploadProgress")
                                                                  (r3v2 'hashMap' java.util.HashMap)
                                                                  (wrap: boolean : 0x005f: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                                  (wrap: java.lang.String : 0x0061: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                                 call: com.tencent.mm.plugin.webview.d.h.15.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.59.run():void, file: classes.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0069: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$15) = 
                                                                  (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                                  (wrap: java.lang.String : 0x0063: INVOKE  (r1v3 java.lang.String) = 
                                                                  ("onMediaFileUploadProgress")
                                                                  (r3v2 'hashMap' java.util.HashMap)
                                                                  (wrap: boolean : 0x005f: IGET  (r2v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                                  (wrap: java.lang.String : 0x0061: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                                 call: com.tencent.mm.plugin.webview.d.h.15.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.59.run():void, file: classes.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                	... 27 more
                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                	... 33 more
                                                                */
                                                            /*
                                                            // Method dump skipped, instructions count: 115
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass59.run():void");
                                                        }
                                                    });
                                                    break;
                                                case 2100:
                                                    final String string19 = bundle.getString("background_audio_state_player_state");
                                                    final int i13 = bundle.getInt("background_audio_state_player_duration");
                                                    final String string20 = bundle.getString("background_audio_state_player_src");
                                                    final int i14 = bundle.getInt("background_audio_state_player_err_code");
                                                    final String string21 = bundle.getString("background_audio_state_player_err_msg");
                                                    final String string22 = bundle.getString("background_audio_state_player_src_id");
                                                    final String string23 = bundle.getString("background_audio_state_player_audio_id", "");
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass3 */

                                                        public final void run() {
                                                            AppMethodBeat.i(79946);
                                                            if (webViewUI == null || webViewUI.isFinishing()) {
                                                                AppMethodBeat.o(79946);
                                                                return;
                                                            }
                                                            if (hVar != null) {
                                                                h hVar = hVar;
                                                                String str = string19;
                                                                int i2 = i13;
                                                                String str2 = string20;
                                                                int i3 = i14;
                                                                String str3 = string21;
                                                                String str4 = string22;
                                                                String str5 = string23;
                                                                if (!hVar.GBl) {
                                                                    Log.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                                                                    AppMethodBeat.o(79946);
                                                                    return;
                                                                }
                                                                Log.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, str4);
                                                                HashMap hashMap = new HashMap();
                                                                hashMap.put("state", str);
                                                                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i2));
                                                                hashMap.put("src", str2);
                                                                hashMap.put("errCode", Integer.valueOf(i3));
                                                                hashMap.put("errMsg", str3);
                                                                hashMap.put("srcId", str4);
                                                                hashMap.put("audioId", str5);
                                                                MMHandlerThread.postToMainThread(
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a8: INVOKE  
                                                                      (wrap: com.tencent.mm.plugin.webview.d.h$21 : 0x00a5: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$21) = 
                                                                      (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                                      (wrap: java.lang.String : 0x009f: INVOKE  (r1v8 java.lang.String) = 
                                                                      ("onBackgroundAudioStateChange")
                                                                      (r8v2 'hashMap' java.util.HashMap)
                                                                      (wrap: boolean : 0x009b: IGET  (r2v3 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                                      (wrap: java.lang.String : 0x009d: IGET  (r3v1 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                                     call: com.tencent.mm.plugin.webview.d.h.21.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.3.run():void, file: classes.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a5: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$21) = 
                                                                      (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                                      (wrap: java.lang.String : 0x009f: INVOKE  (r1v8 java.lang.String) = 
                                                                      ("onBackgroundAudioStateChange")
                                                                      (r8v2 'hashMap' java.util.HashMap)
                                                                      (wrap: boolean : 0x009b: IGET  (r2v3 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                                      (wrap: java.lang.String : 0x009d: IGET  (r3v1 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                                     call: com.tencent.mm.plugin.webview.d.h.21.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.3.run():void, file: classes.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	... 27 more
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                    	... 33 more
                                                                    */
                                                                /*
                                                                // Method dump skipped, instructions count: 176
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass3.run():void");
                                                            }
                                                        });
                                                        break;
                                                    case WearableStatusCodes.UNKNOWN_CAPABILITY:
                                                        final int i15 = bundle.getInt("nfc_key_on_touch_errcode", 0);
                                                        MMHandlerThread.postToMainThread(new Runnable() {
                                                            /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass9 */

                                                            public final void run() {
                                                                AppMethodBeat.i(79952);
                                                                if (webViewUI == null || webViewUI.isFinishing()) {
                                                                    AppMethodBeat.o(79952);
                                                                    return;
                                                                }
                                                                if (hVar != null) {
                                                                    h hVar = hVar;
                                                                    int i2 = i15;
                                                                    if (!hVar.GBl) {
                                                                        Log.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                                                                        AppMethodBeat.o(79952);
                                                                        return;
                                                                    }
                                                                    Log.i("MicroMsg.JsApiHandler", "onNfcTouch errCode=%d", Integer.valueOf(i2));
                                                                    HashMap hashMap = new HashMap();
                                                                    hashMap.put("errCode", Integer.valueOf(i2));
                                                                    MMHandlerThread.postToMainThread(
                                                                    /*  JADX ERROR: Method code generation error
                                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0061: INVOKE  
                                                                          (wrap: com.tencent.mm.plugin.webview.d.h$24 : 0x005e: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$24) = 
                                                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                                          (wrap: java.lang.String : 0x0058: INVOKE  (r1v3 java.lang.String) = 
                                                                          ("onNfcTouch")
                                                                          (r2v2 'hashMap' java.util.HashMap)
                                                                          (wrap: boolean : 0x0054: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                                          (wrap: java.lang.String : 0x0056: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                                         call: com.tencent.mm.plugin.webview.d.h.24.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.m.9.run():void, file: classes.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005e: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$24) = 
                                                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                                                          (wrap: java.lang.String : 0x0058: INVOKE  (r1v3 java.lang.String) = 
                                                                          ("onNfcTouch")
                                                                          (r2v2 'hashMap' java.util.HashMap)
                                                                          (wrap: boolean : 0x0054: IGET  (r3v2 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                                          (wrap: java.lang.String : 0x0056: IGET  (r4v2 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                                         call: com.tencent.mm.plugin.webview.d.h.24.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.9.run():void, file: classes.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                        	... 27 more
                                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                        	... 33 more
                                                                        */
                                                                    /*
                                                                    // Method dump skipped, instructions count: 104
                                                                    */
                                                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass9.run():void");
                                                                }
                                                            });
                                                            break;
                                                        case CdnLogic.kMediaTypeStoryAudio:
                                                            final String string24 = bundle.getString("err_msg");
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass20 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79963);
                                                                    if (webViewUI == null || webViewUI.isFinishing()) {
                                                                        AppMethodBeat.o(79963);
                                                                        return;
                                                                    }
                                                                    if (hVar != null) {
                                                                        hVar.aYg(string24);
                                                                    }
                                                                    AppMethodBeat.o(79963);
                                                                }
                                                            });
                                                            break;
                                                        case 40002:
                                                            final String string25 = bundle.getString("uuid");
                                                            final int i16 = bundle.getInt("major");
                                                            final int i17 = bundle.getInt("minor");
                                                            final double d2 = bundle.getDouble("accuracy");
                                                            final double d3 = bundle.getDouble("rssi");
                                                            final float f4 = bundle.getFloat("heading");
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass21 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79964);
                                                                    if (webViewUI == null || webViewUI.isFinishing()) {
                                                                        AppMethodBeat.o(79964);
                                                                        return;
                                                                    }
                                                                    if (hVar != null) {
                                                                        hVar.a(string25, i16, i17, d2, d3, f4);
                                                                    }
                                                                    AppMethodBeat.o(79964);
                                                                }
                                                            });
                                                            break;
                                                        case 80001:
                                                        case 80002:
                                                            webViewUI.z(i2, bundle);
                                                            break;
                                                        case 110001:
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass27 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79970);
                                                                    if (webViewUI == null || webViewUI.isFinishing()) {
                                                                        AppMethodBeat.o(79970);
                                                                        return;
                                                                    }
                                                                    i iVar = webViewUI.Jjl;
                                                                    Bundle bundle = bundle;
                                                                    Log.i("MicroMsg.WebViewLongClickHelper", "onFetchQrCodeResp");
                                                                    iVar.mHu.q(bundle.getInt("key_resp_ret", -1), bundle.getByteArray("key_resp_item_bytes"));
                                                                    AppMethodBeat.o(79970);
                                                                }
                                                            });
                                                            break;
                                                        default:
                                                            Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
                                                            break;
                                                    }
                                                    AppMethodBeat.o(80009);
                                                    return true;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final boolean a(com.tencent.mm.plugin.webview.stub.d dVar) {
                                                    AppMethodBeat.i(80010);
                                                    AppMethodBeat.o(80010);
                                                    return true;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final boolean afl(final int i2) {
                                                    AppMethodBeat.i(80011);
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass30 */

                                                        public final void run() {
                                                            AppMethodBeat.i(79973);
                                                            if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                AppMethodBeat.o(79973);
                                                                return;
                                                            }
                                                            ((WebViewUI) m.this.Jbp.get()).setProgressBarIndeterminateVisibility(false);
                                                            Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", Integer.valueOf(i2));
                                                            if (i2 != 0) {
                                                                ((WebViewUI) m.this.Jbp.get()).JhV.finish();
                                                            } else if (!((WebViewUI) m.this.Jbp.get()).JiX && !((WebViewUI) m.this.Jbp.get()).JiY && !((WebViewUI) m.this.Jbp.get()).cpP()) {
                                                                ((WebViewUI) m.this.Jbp.get()).JhV.start();
                                                                AppMethodBeat.o(79973);
                                                                return;
                                                            }
                                                            AppMethodBeat.o(79973);
                                                        }
                                                    });
                                                    AppMethodBeat.o(80011);
                                                    return true;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final boolean a(final String str, final String str2, final Bundle bundle, final boolean z) {
                                                    AppMethodBeat.i(80012);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80012);
                                                    } else {
                                                        if (this.Jbp.get().IBw != null) {
                                                            AnonymousClass31 r0 = new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass31 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79974);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(79974);
                                                                        return;
                                                                    }
                                                                    ((WebViewUI) m.this.Jbp.get()).IBw.a(str, str2, n.aN(bundle), z);
                                                                    AppMethodBeat.o(79974);
                                                                }
                                                            };
                                                            if (MMHandlerThread.isMainThread()) {
                                                                r0.run();
                                                            } else {
                                                                MMHandlerThread.postToMainThread(r0);
                                                            }
                                                        }
                                                        AppMethodBeat.o(80012);
                                                    }
                                                    return false;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final String fWW() {
                                                    AppMethodBeat.i(80013);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80013);
                                                        return null;
                                                    }
                                                    String coX = this.Jbp.get().coX();
                                                    AppMethodBeat.o(80013);
                                                    return coX;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final String getCurrentUrl() {
                                                    AppMethodBeat.i(80014);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80014);
                                                        return null;
                                                    }
                                                    String fZM = this.Jbp.get().fZM();
                                                    AppMethodBeat.o(80014);
                                                    return fZM;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final String ePp() {
                                                    AppMethodBeat.i(211108);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(211108);
                                                        return null;
                                                    }
                                                    String ePp = this.Jbp.get().ePp();
                                                    AppMethodBeat.o(211108);
                                                    return ePp;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final String fWX() {
                                                    AppMethodBeat.i(80015);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80015);
                                                        return null;
                                                    }
                                                    String stringExtra = this.Jbp.get().getIntent().getStringExtra("srcUsername");
                                                    AppMethodBeat.o(80015);
                                                    return stringExtra;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final int fWY() {
                                                    AppMethodBeat.i(80016);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80016);
                                                        return 0;
                                                    }
                                                    int bLC = this.Jbp.get().bLC();
                                                    AppMethodBeat.o(80016);
                                                    return bLC;
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void yL(final boolean z) {
                                                    AppMethodBeat.i(80017);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80017);
                                                        return;
                                                    }
                                                    final boolean booleanExtra = this.Jbp.get().getIntent().getBooleanExtra("forceHideShare", false);
                                                    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(booleanExtra));
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass32 */

                                                        public final void run() {
                                                            AppMethodBeat.i(79975);
                                                            if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                AppMethodBeat.o(79975);
                                                            } else if (booleanExtra) {
                                                                if (((WebViewUI) m.this.Jbp.get()).pGj != null && !Util.isNullOrNil(((WebViewUI) m.this.Jbp.get()).pGj.getUrl())) {
                                                                    ((WebViewUI) m.this.Jbp.get()).JiM.put(((WebViewUI) m.this.Jbp.get()).pGj.getUrl(), Boolean.FALSE);
                                                                }
                                                                ((WebViewUI) m.this.Jbp.get()).zj(false);
                                                                AppMethodBeat.o(79975);
                                                            } else {
                                                                if (((WebViewUI) m.this.Jbp.get()).pGj != null && !Util.isNullOrNil(((WebViewUI) m.this.Jbp.get()).pGj.getUrl())) {
                                                                    ((WebViewUI) m.this.Jbp.get()).JiM.put(((WebViewUI) m.this.Jbp.get()).pGj.getUrl(), Boolean.valueOf(z));
                                                                }
                                                                ((WebViewUI) m.this.Jbp.get()).zj(z);
                                                                AppMethodBeat.o(79975);
                                                            }
                                                        }
                                                    });
                                                    AppMethodBeat.o(80017);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void yM(final boolean z) {
                                                    AppMethodBeat.i(80018);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80018);
                                                        return;
                                                    }
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass33 */

                                                        public final void run() {
                                                            AppMethodBeat.i(79976);
                                                            if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                AppMethodBeat.o(79976);
                                                                return;
                                                            }
                                                            ((WebViewUI) m.this.Jbp.get()).zi(z);
                                                            AppMethodBeat.o(79976);
                                                        }
                                                    });
                                                    AppMethodBeat.o(80018);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void fWV() {
                                                    AppMethodBeat.i(80019);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80019);
                                                        return;
                                                    }
                                                    if (this.Jbp.get().IBw != null) {
                                                        this.Jbp.get().IBw.fWV();
                                                    }
                                                    AppMethodBeat.o(80019);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void aM(Bundle bundle) {
                                                    AppMethodBeat.i(80020);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80020);
                                                        return;
                                                    }
                                                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
                                                    if (bundle != null) {
                                                        Intent intent = new Intent();
                                                        intent.putExtra("result_data", bundle);
                                                        this.Jbp.get().setResult(-1, intent);
                                                    }
                                                    this.Jbp.get().finish();
                                                    AppMethodBeat.o(80020);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void aWP(String str) {
                                                    final int i2 = 0;
                                                    AppMethodBeat.i(80021);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80021);
                                                        return;
                                                    }
                                                    try {
                                                        i2 = Util.getInt(str, 0);
                                                    } catch (Exception e2) {
                                                        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb, ex = " + e2.getMessage());
                                                    }
                                                    if (this.Jbp.get().pGj == null) {
                                                        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
                                                        AppMethodBeat.o(80021);
                                                        return;
                                                    }
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass35 */

                                                        public final void run() {
                                                            AppMethodBeat.i(79978);
                                                            if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                AppMethodBeat.o(79978);
                                                                return;
                                                            }
                                                            ((WebViewUI) m.this.Jbp.get()).agP(i2);
                                                            AppMethodBeat.o(79978);
                                                        }
                                                    });
                                                    AppMethodBeat.o(80021);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void fWZ() {
                                                    AppMethodBeat.i(80022);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80022);
                                                        return;
                                                    }
                                                    if (this.Jbp.get().IBw != null) {
                                                        this.Jbp.get().IBw.fWZ();
                                                    }
                                                    AppMethodBeat.o(80022);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void e(String str, final String str2, final int i2, final int i3) {
                                                    AppMethodBeat.i(80023);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80023);
                                                        return;
                                                    }
                                                    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(str2)));
                                                    if (this.Jbp.get().Jjl.mHo == null || str == null || !str.equals(this.Jbp.get().Jjl.mHo.Jbk)) {
                                                        AppMethodBeat.o(80023);
                                                        return;
                                                    }
                                                    if (this.Jbp.get().Jjl.mHo != null) {
                                                        this.Jbp.get().Jjl.mHo.gdA();
                                                    }
                                                    if (str2 == null || this.Jbp.get().Jjl == null) {
                                                        AppMethodBeat.o(80023);
                                                        return;
                                                    }
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass36 */

                                                        public final void run() {
                                                            AppMethodBeat.i(79979);
                                                            if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing() || ((WebViewUI) m.this.Jbp.get()).pGj == null) {
                                                                AppMethodBeat.o(79979);
                                                                return;
                                                            }
                                                            ((WebViewUI) m.this.Jbp.get()).Jjl.aF(str2, i2, i3);
                                                            AppMethodBeat.o(79979);
                                                        }
                                                    });
                                                    AppMethodBeat.o(80023);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void t(final int i2, final Bundle bundle) {
                                                    AppMethodBeat.i(80024);
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80024);
                                                        return;
                                                    }
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass37 */

                                                        public final void run() {
                                                            SparseBooleanArray sparseBooleanArray;
                                                            AppMethodBeat.i(79980);
                                                            if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing() || ((WebViewUI) m.this.Jbp.get()).pGj == null) {
                                                                AppMethodBeat.o(79980);
                                                                return;
                                                            }
                                                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + i2);
                                                            HashSet<Object> hashSet = new HashSet();
                                                            if (i2 == 3003 || i2 == 3004) {
                                                                hashSet.add("menuItem:share:brand");
                                                                hashSet.add("menuItem:share:appMessage");
                                                                hashSet.add("menuItem:share:dataMessage");
                                                                hashSet.add("menuItem:share:timeline");
                                                                hashSet.add("menuItem:favorite");
                                                                hashSet.add("menuItem:profile");
                                                                hashSet.add("menuItem:addContact");
                                                                hashSet.add("menuItem:copyUrl");
                                                                hashSet.add("menuItem:openWithSafari");
                                                                hashSet.add("menuItem:share:email");
                                                                hashSet.add("menuItem:delete");
                                                                hashSet.add("menuItem:editTag");
                                                                hashSet.add("menuItem:readMode");
                                                                hashSet.add("menuItem:originPage");
                                                                hashSet.add("menuItem:share:qq");
                                                                hashSet.add("menuItem:share:weiboApp");
                                                                hashSet.add("menuItem:share:QZone");
                                                                hashSet.add("menuItem:share:facebook");
                                                                hashSet.add("menuItem:share:enterprise");
                                                                hashSet.add("menuItem:share:wework");
                                                                hashSet.add("menuItem:share:wework_LOCAL");
                                                                hashSet.add("menuItem:share:weread");
                                                                hashSet.add("menuItem:addShortcut");
                                                                hashSet.add("menuItem:haoKan");
                                                                hashSet.add("menuItem:cancelHaoKan");
                                                            } else if (bundle == null) {
                                                                Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
                                                                AppMethodBeat.o(79980);
                                                                return;
                                                            } else {
                                                                ArrayList<String> stringArrayList = bundle.getStringArrayList("menu_item_list");
                                                                if (stringArrayList == null || stringArrayList.size() == 0) {
                                                                    Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
                                                                    AppMethodBeat.o(79980);
                                                                    return;
                                                                }
                                                                hashSet.addAll(stringArrayList);
                                                                hashSet.remove("menuItem:exposeArticle");
                                                                hashSet.remove("menuItem:setFont");
                                                                hashSet.remove("menuItem:keepTop");
                                                                hashSet.remove("menuItem:cancelKeepTop");
                                                                hashSet.remove("menuItem:profile");
                                                                hashSet.remove("menuItem:addContact");
                                                                hashSet.remove("menuItem:refresh");
                                                            }
                                                            String url = ((WebViewUI) m.this.Jbp.get()).pGj.getUrl();
                                                            SparseBooleanArray sparseBooleanArray2 = ((WebViewUI) m.this.Jbp.get()).Jjm.Jgj.get(url);
                                                            switch (i2) {
                                                                case 3001:
                                                                case 3003:
                                                                    if (sparseBooleanArray2 == null) {
                                                                        sparseBooleanArray = new SparseBooleanArray();
                                                                        ((WebViewUI) m.this.Jbp.get()).Jjm.Jgj.put(url, sparseBooleanArray);
                                                                        ((WebViewUI) m.this.Jbp.get()).Jjm.g(url, m.b(m.this));
                                                                    } else {
                                                                        sparseBooleanArray = sparseBooleanArray2;
                                                                    }
                                                                    for (Object obj : hashSet) {
                                                                        int nullAs = Util.nullAs(((WebViewUI) m.this.Jbp.get()).Jjm.Jgk.get(obj), -1);
                                                                        if (nullAs >= 0) {
                                                                            sparseBooleanArray.put(nullAs, true);
                                                                        }
                                                                    }
                                                                    ((WebViewUI) m.this.Jbp.get()).Jjm.ani();
                                                                    AppMethodBeat.o(79980);
                                                                    return;
                                                                case 3002:
                                                                case 3004:
                                                                    if (sparseBooleanArray2 != null) {
                                                                        for (Object obj2 : hashSet) {
                                                                            int nullAs2 = Util.nullAs(((WebViewUI) m.this.Jbp.get()).Jjm.Jgk.get(obj2), -1);
                                                                            if (nullAs2 >= 0) {
                                                                                sparseBooleanArray2.delete(nullAs2);
                                                                            }
                                                                        }
                                                                        ((WebViewUI) m.this.Jbp.get()).Jjm.ani();
                                                                        break;
                                                                    }
                                                                    break;
                                                            }
                                                            AppMethodBeat.o(79980);
                                                        }
                                                    });
                                                    AppMethodBeat.o(80024);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final void lz(final String str, String str2) {
                                                    AppMethodBeat.i(80025);
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass38 */

                                                        public final void run() {
                                                            AppMethodBeat.i(79981);
                                                            if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                AppMethodBeat.o(79981);
                                                            } else if (!Util.isNullOrNil(((WebViewUI) m.this.Jbp.get()).pGj.getUrl())) {
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + str);
                                                                ((WebViewUI) m.this.Jbp.get()).JiN.put(((WebViewUI) m.this.Jbp.get()).pGj.getUrl(), str);
                                                                AppMethodBeat.o(79981);
                                                            } else {
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
                                                                AppMethodBeat.o(79981);
                                                            }
                                                        }
                                                    });
                                                    AppMethodBeat.o(80025);
                                                }

                                                private Intent getIntent() {
                                                    AppMethodBeat.i(80026);
                                                    Intent intent = this.Jbp.get().getIntent();
                                                    AppMethodBeat.o(80026);
                                                    return intent;
                                                }

                                                private int aXI(String str) {
                                                    AppMethodBeat.i(80027);
                                                    int aXI = this.Jbp.get().aXI(str);
                                                    AppMethodBeat.o(80027);
                                                    return aXI;
                                                }

                                                private void y(int i2, Bundle bundle) {
                                                    AppMethodBeat.i(211109);
                                                    if (!(bundle == null || this.Jbp.get() == null || this.Jbp.get().IMH == null)) {
                                                        this.Jbp.get().IMH.ILG.a(new com.tencent.mm.plugin.webview.ui.tools.floatball.a(i2, bundle));
                                                    }
                                                    AppMethodBeat.o(211109);
                                                }

                                                @Override // com.tencent.mm.plugin.webview.stub.f
                                                public final Bundle j(int i2, final Bundle bundle) {
                                                    String str;
                                                    Bitmap bitmap;
                                                    int init;
                                                    AppMethodBeat.i(80028);
                                                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(i2)));
                                                    final Bundle bundle2 = new Bundle();
                                                    if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                        AppMethodBeat.o(80028);
                                                        return bundle2;
                                                    }
                                                    g gVar = this.Jbp.get().mHi;
                                                    switch (i2) {
                                                        case 11:
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass53 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(80000);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(80000);
                                                                        return;
                                                                    }
                                                                    if (((WebViewUI) m.this.Jbp.get()).JiR != null && ((WebViewUI) m.this.Jbp.get()).JiR.isShowing()) {
                                                                        ((WebViewUI) m.this.Jbp.get()).JiR.dismiss();
                                                                    }
                                                                    AppMethodBeat.o(80000);
                                                                }
                                                            });
                                                            break;
                                                        case 12:
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass54 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(80001);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(80001);
                                                                        return;
                                                                    }
                                                                    ((WebViewUI) m.this.Jbp.get()).JiQ = null;
                                                                    AppMethodBeat.o(80001);
                                                                }
                                                            });
                                                            break;
                                                        case 18:
                                                            bundle2.putString("KPublisherId", this.Jbp.get().eam);
                                                            Intent intent = getIntent();
                                                            if (intent != null) {
                                                                int aXI = aXI(getIntent().getStringExtra("geta8key_username"));
                                                                bundle2.putString("preChatName", intent.getStringExtra("preChatName"));
                                                                bundle2.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
                                                                bundle2.putString("prePublishId", intent.getStringExtra("prePublishId"));
                                                                bundle2.putString("preUsername", intent.getStringExtra("preUsername"));
                                                                bundle2.putInt("getA8KeyScene", aXI);
                                                                bundle2.putString("referUrl", this.Jbp.get().gfv());
                                                                bundle2.putString("url", this.Jbp.get().fZM());
                                                                bundle2.putString("rawUrl", this.Jbp.get().coX());
                                                                bundle2.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
                                                                bundle2.putString("KAppId", intent.getStringExtra("KAppId"));
                                                                this.Jbp.get().bC(bundle2);
                                                                break;
                                                            }
                                                            break;
                                                        case 22:
                                                            bundle2.putInt("pay_channel", getIntent().getIntExtra("pay_channel", -1));
                                                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)));
                                                            break;
                                                        case 25:
                                                            bundle2.putInt("scene", getIntent().getIntExtra("scene", -1));
                                                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", Integer.valueOf(getIntent().getIntExtra("scene", 0)));
                                                            break;
                                                        case 33:
                                                            Intent intent2 = getIntent();
                                                            if (intent2 != null) {
                                                                bundle2.putString("publishIdPrefix", intent2.getStringExtra("publishIdPrefix"));
                                                                bundle2.putString("reportSessionId", intent2.getStringExtra("reportSessionId"));
                                                                break;
                                                            }
                                                            break;
                                                        case 34:
                                                            y(i2, bundle);
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass41 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79984);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(79984);
                                                                        return;
                                                                    }
                                                                    WebViewUI webViewUI = (WebViewUI) m.this.Jbp.get();
                                                                    webViewUI.JjI.JgM = 
                                                                    /*  JADX ERROR: Method code generation error
                                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003d: IPUT  
                                                                          (wrap: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$3 : 0x003a: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.webview.ui.tools.WebViewUI$3) = (r0v11 'webViewUI' com.tencent.mm.plugin.webview.ui.tools.WebViewUI) call: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.3.<init>(com.tencent.mm.plugin.webview.ui.tools.WebViewUI):void type: CONSTRUCTOR)
                                                                          (wrap: com.tencent.mm.plugin.webview.ui.tools.k : 0x0036: IGET  (r1v0 com.tencent.mm.plugin.webview.ui.tools.k) = (r0v11 'webViewUI' com.tencent.mm.plugin.webview.ui.tools.WebViewUI) com.tencent.mm.plugin.webview.ui.tools.WebViewUI.JjI com.tencent.mm.plugin.webview.ui.tools.k)
                                                                         com.tencent.mm.plugin.webview.ui.tools.k.JgM com.tencent.mm.plugin.webview.ui.tools.k$a in method: com.tencent.mm.plugin.webview.ui.tools.m.41.run():void, file: classes.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003a: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.webview.ui.tools.WebViewUI$3) = (r0v11 'webViewUI' com.tencent.mm.plugin.webview.ui.tools.WebViewUI) call: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.3.<init>(com.tencent.mm.plugin.webview.ui.tools.WebViewUI):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.41.run():void, file: classes.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                        	... 18 more
                                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.ui.tools.WebViewUI, state: GENERATED_AND_UNLOADED
                                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                        	... 22 more
                                                                        */
                                                                    /*
                                                                    // Method dump skipped, instructions count: 142
                                                                    */
                                                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass41.run():void");
                                                                }
                                                            });
                                                            break;
                                                        case 35:
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass44 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79987);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(79987);
                                                                        return;
                                                                    }
                                                                    ((WebViewUI) m.this.Jbp.get()).JjI.startLoading();
                                                                    AppMethodBeat.o(79987);
                                                                }
                                                            });
                                                            break;
                                                        case 36:
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass42 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79985);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(79985);
                                                                        return;
                                                                    }
                                                                    ((WebViewUI) m.this.Jbp.get()).JjI.stopLoading();
                                                                    AppMethodBeat.o(79985);
                                                                }
                                                            });
                                                            break;
                                                        case 37:
                                                            final String string = bundle.getString("show_kb_placeholder");
                                                            final int i3 = bundle.getInt("show_kb_max_length");
                                                            final int i4 = bundle.getInt("show_kb_show_remind_word_count");
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass47 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79990);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(79990);
                                                                        return;
                                                                    }
                                                                    ((WebViewUI) m.this.Jbp.get()).aG(string, i3, i4);
                                                                    AppMethodBeat.o(79990);
                                                                }
                                                            });
                                                            break;
                                                        case 38:
                                                            y(i2, bundle);
                                                            if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass40 */

                                                                    public final void run() {
                                                                        AppMethodBeat.i(79983);
                                                                        if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                            AppMethodBeat.o(79983);
                                                                            return;
                                                                        }
                                                                        ((WebViewUI) m.this.Jbp.get()).JjI.zh(true);
                                                                        AppMethodBeat.o(79983);
                                                                    }
                                                                });
                                                                break;
                                                            }
                                                            break;
                                                        case 39:
                                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass46 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(79989);
                                                                    if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                        AppMethodBeat.o(79989);
                                                                        return;
                                                                    }
                                                                    WebViewUI webViewUI = (WebViewUI) m.this.Jbp.get();
                                                                    if (webViewUI.pGj != null) {
                                                                        webViewUI.pGj.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", 
                                                                        /*  JADX ERROR: Method code generation error
                                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0042: INVOKE  
                                                                              (wrap: com.tencent.mm.ui.widget.MMWebView : 0x003b: IGET  (r2v0 com.tencent.mm.ui.widget.MMWebView) = (r0v11 'webViewUI' com.tencent.mm.plugin.webview.ui.tools.WebViewUI) com.tencent.mm.plugin.webview.ui.tools.WebViewUI.pGj com.tencent.mm.ui.widget.MMWebView)
                                                                              ("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()")
                                                                              (wrap: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$4 : 0x003f: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.webview.ui.tools.WebViewUI$4) = (r0v11 'webViewUI' com.tencent.mm.plugin.webview.ui.tools.WebViewUI) call: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.4.<init>(com.tencent.mm.plugin.webview.ui.tools.WebViewUI):void type: CONSTRUCTOR)
                                                                             type: VIRTUAL call: com.tencent.mm.ui.widget.MMWebView.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void in method: com.tencent.mm.plugin.webview.ui.tools.m.46.run():void, file: classes.dex
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
                                                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.webview.ui.tools.WebViewUI$4) = (r0v11 'webViewUI' com.tencent.mm.plugin.webview.ui.tools.WebViewUI) call: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.4.<init>(com.tencent.mm.plugin.webview.ui.tools.WebViewUI):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.m.46.run():void, file: classes.dex
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                            	... 23 more
                                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.ui.tools.WebViewUI, state: GENERATED_AND_UNLOADED
                                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                            	... 29 more
                                                                            */
                                                                        /*
                                                                            this = this;
                                                                            r4 = 79989(0x13875, float:1.12088E-40)
                                                                            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                                                                            com.tencent.mm.plugin.webview.ui.tools.m r0 = com.tencent.mm.plugin.webview.ui.tools.m.this
                                                                            java.lang.ref.WeakReference r0 = com.tencent.mm.plugin.webview.ui.tools.m.a(r0)
                                                                            java.lang.Object r0 = r0.get()
                                                                            if (r0 == 0) goto L_0x0024
                                                                            com.tencent.mm.plugin.webview.ui.tools.m r0 = com.tencent.mm.plugin.webview.ui.tools.m.this
                                                                            java.lang.ref.WeakReference r0 = com.tencent.mm.plugin.webview.ui.tools.m.a(r0)
                                                                            java.lang.Object r0 = r0.get()
                                                                            com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = (com.tencent.mm.plugin.webview.ui.tools.WebViewUI) r0
                                                                            boolean r0 = r0.isFinishing()
                                                                            if (r0 == 0) goto L_0x0028
                                                                        L_0x0024:
                                                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                                                                        L_0x0027:
                                                                            return
                                                                        L_0x0028:
                                                                            com.tencent.mm.plugin.webview.ui.tools.m r0 = com.tencent.mm.plugin.webview.ui.tools.m.this
                                                                            java.lang.ref.WeakReference r0 = com.tencent.mm.plugin.webview.ui.tools.m.a(r0)
                                                                            java.lang.Object r0 = r0.get()
                                                                            com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = (com.tencent.mm.plugin.webview.ui.tools.WebViewUI) r0
                                                                            com.tencent.mm.ui.widget.MMWebView r1 = r0.pGj
                                                                            if (r1 == 0) goto L_0x0045
                                                                            java.lang.String r1 = "javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()"
                                                                            com.tencent.mm.ui.widget.MMWebView r2 = r0.pGj
                                                                            com.tencent.mm.plugin.webview.ui.tools.WebViewUI$4 r3 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$4
                                                                            r3.<init>()
                                                                            r2.evaluateJavascript(r1, r3)
                                                                        L_0x0045:
                                                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                                                                            goto L_0x0027
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass46.run():void");
                                                                    }
                                                                });
                                                                break;
                                                            case 43:
                                                                y(i2, bundle);
                                                                String string2 = bundle.getString("set_page_title_text");
                                                                WebViewUI webViewUI = this.Jbp.get();
                                                                if (webViewUI != null && !webViewUI.isFinishing() && webViewUI.CSQ) {
                                                                    if (string2 != null) {
                                                                        webViewUI.setMMTitle(string2);
                                                                    }
                                                                    float f2 = bundle.getFloat("set_page_title_alpha", 1.0f);
                                                                    webViewUI.setMMTitleColor(e.gw(bundle.getString("set_page_title_color"), this.Jbp.get().hXP()));
                                                                    if (f2 >= 0.0f && ((double) f2) <= 1.0d) {
                                                                        webViewUI.setTitleAlpha(f2);
                                                                        break;
                                                                    }
                                                                }
                                                            case 44:
                                                                y(i2, bundle);
                                                                String string3 = bundle.getString("set_navigation_bar_buttons_text");
                                                                String string4 = bundle.getString("set_navigation_bar_buttons_icon_data");
                                                                boolean z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                                                                boolean z2 = bundle.getBoolean("set_navigation_bar_right_style", false);
                                                                if (!Util.isNullOrNil(string4)) {
                                                                    try {
                                                                        bitmap = e.bah(string4);
                                                                    } catch (Exception e2) {
                                                                        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", e2);
                                                                        bitmap = null;
                                                                    }
                                                                } else {
                                                                    bitmap = null;
                                                                }
                                                                int gw = e.gw(bundle.getString("set_navigation_bar_buttons_left_text_color"), WebView.NIGHT_MODE_COLOR);
                                                                boolean z3 = bundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
                                                                int bag = (int) e.bag(bundle.getString("set_navigation_bar_buttons_text_color"));
                                                                if (this.Jbp.get() != null && !this.Jbp.get().isFinishing()) {
                                                                    if (z2 && this.Jbp.get().gff() != null) {
                                                                        this.Jbp.get().gff().ghZ();
                                                                    }
                                                                    if (z) {
                                                                        this.Jbp.get().zl(true);
                                                                        break;
                                                                    } else {
                                                                        String fZM = this.Jbp.get().fZM();
                                                                        Boolean bool = !Util.isNullOrNil(fZM) ? this.Jbp.get().JiP.get(fZM) : null;
                                                                        this.Jbp.get().zl(Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue());
                                                                        if (bitmap != null && !bitmap.isRecycled()) {
                                                                            this.Jbp.get().b(string3, new BitmapDrawable(this.Jbp.get().getResources(), bitmap));
                                                                            if (z3) {
                                                                                this.Jbp.get().updateOptionMenuListener(0, new MenuItem.OnMenuItemClickListener() {
                                                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass48 */

                                                                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                                                                        AppMethodBeat.i(259616);
                                                                                        Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                                                                        ((WebViewUI) m.this.Jbp.get()).IBw.gbg();
                                                                                        AppMethodBeat.o(259616);
                                                                                        return false;
                                                                                    }
                                                                                }, null);
                                                                            }
                                                                        } else if (Util.isNullOrNil(string3)) {
                                                                            this.Jbp.get().addIconOptionMenu(0, this.Jbp.get().gfL(), new MenuItem.OnMenuItemClickListener() {
                                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass51 */

                                                                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                                                                    AppMethodBeat.i(259619);
                                                                                    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                                                                    ((WebViewUI) m.this.Jbp.get()).IBw.gbg();
                                                                                    AppMethodBeat.o(259619);
                                                                                    return false;
                                                                                }
                                                                            }, this.Jbp.get().JjO);
                                                                        } else if (bag == -1) {
                                                                            this.Jbp.get().addTextOptionMenu(0, string3, new MenuItem.OnMenuItemClickListener() {
                                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass49 */

                                                                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                                                                    AppMethodBeat.i(259617);
                                                                                    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                                                                    ((WebViewUI) m.this.Jbp.get()).IBw.gbg();
                                                                                    AppMethodBeat.o(259617);
                                                                                    return false;
                                                                                }
                                                                            });
                                                                        } else {
                                                                            this.Jbp.get().addTextOptionMenu(0, string3, bag, new MenuItem.OnMenuItemClickListener() {
                                                                                /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass50 */

                                                                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                                                                    AppMethodBeat.i(259618);
                                                                                    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                                                                    ((WebViewUI) m.this.Jbp.get()).IBw.gbg();
                                                                                    AppMethodBeat.o(259618);
                                                                                    return false;
                                                                                }
                                                                            });
                                                                        }
                                                                        this.Jbp.get().agM(gw);
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 45:
                                                                y(i2, bundle);
                                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass52 */

                                                                    public final void run() {
                                                                        AppMethodBeat.i(79999);
                                                                        if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                            AppMethodBeat.o(79999);
                                                                            return;
                                                                        }
                                                                        boolean z = bundle.getBoolean("enable_fullscreen_params_enable", false);
                                                                        if (m.b(m.this) != null) {
                                                                            m.b(m.this).removeExtra("show_full_screen");
                                                                        }
                                                                        ((WebViewUI) m.this.Jbp.get()).aV(z, false);
                                                                        AppMethodBeat.o(79999);
                                                                    }
                                                                });
                                                                break;
                                                            case 47:
                                                                y(i2, bundle);
                                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass43 */

                                                                    public final void run() {
                                                                        AppMethodBeat.i(79986);
                                                                        if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                            AppMethodBeat.o(79986);
                                                                            return;
                                                                        }
                                                                        ((WebViewUI) m.this.Jbp.get()).JjI.geU();
                                                                        AppMethodBeat.o(79986);
                                                                    }
                                                                });
                                                                break;
                                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                                                            case 49:
                                                                break;
                                                            case 53:
                                                                y(i2, bundle);
                                                                if (this.Jbp.get() != null && !this.Jbp.get().isFinishing()) {
                                                                    this.Jbp.get().bb(bundle);
                                                                    break;
                                                                }
                                                            case 54:
                                                                boolean z4 = bundle.getBoolean("add_shortcut_status");
                                                                if (this.Jbp.get().IBw != null) {
                                                                    this.Jbp.get().IBw.yX(z4);
                                                                    break;
                                                                }
                                                                break;
                                                            case 71:
                                                                if (bundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
                                                                    bundle2.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
                                                                    bundle2.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1));
                                                                    break;
                                                                }
                                                                break;
                                                            case 72:
                                                                y(i2, bundle);
                                                                this.Jbp.get().JjI.agK(e.gw(bundle.getString("key_set_bounce_background_color"), this.Jbp.get().getResources().getColor(R.color.afj)));
                                                                break;
                                                            case com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX:
                                                                Intent intent3 = getIntent();
                                                                if (bundle != null) {
                                                                    int i5 = bundle.getInt("scene");
                                                                    switch (i5) {
                                                                        case 1:
                                                                        case 2:
                                                                        case 3:
                                                                        case 4:
                                                                        case 5:
                                                                        case 6:
                                                                        case 7:
                                                                        case 37:
                                                                        case 45:
                                                                            bundle2.putStringArrayList("proof", intent3.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                                                            break;
                                                                        case 33:
                                                                            bundle2.putString("newMsgId", com.tencent.mm.plugin.sns.data.r.Jb(intent3.getLongExtra("k_expose_msg_id", 0)));
                                                                            break;
                                                                        case 34:
                                                                            if (!Util.isNullOrNil(intent3.getStringExtra("k_webview_img"))) {
                                                                                String stringExtra = intent3.getStringExtra("k_webview_img");
                                                                                byte[] aW = s.aW(stringExtra, 0, (int) s.boW(stringExtra));
                                                                                s.deleteFile(stringExtra);
                                                                                bundle2.putString("webviewImg", Base64.encodeToString(aW, 0));
                                                                            }
                                                                            if (intent3.getStringExtra("k_webview_html") != null) {
                                                                                bundle2.putString("webviewHtml", intent3.getStringExtra("k_webview_html"));
                                                                            }
                                                                            StringBuilder sb = new StringBuilder();
                                                                            sb.append("<exposecontent>");
                                                                            sb.append("<weburl>");
                                                                            if (intent3.getStringExtra("k_expose_url") != null) {
                                                                                sb.append(intent3.getStringExtra("k_expose_url"));
                                                                            }
                                                                            sb.append("</weburl>");
                                                                            sb.append("<firstJumpUrl>");
                                                                            if (intent3.getStringExtra("k_expose_raw_url") != null) {
                                                                                sb.append(intent3.getStringExtra("k_expose_raw_url"));
                                                                            }
                                                                            sb.append("</firstJumpUrl>");
                                                                            sb.append("<webscence>");
                                                                            sb.append(intent3.getIntExtra("k_expose_web_scene", 0));
                                                                            sb.append("</webscence>");
                                                                            sb.append("</exposecontent>");
                                                                            bundle2.putString("url", sb.toString());
                                                                            break;
                                                                        case 35:
                                                                        case 36:
                                                                        case 38:
                                                                        case 39:
                                                                            break;
                                                                        case 51:
                                                                            bundle2.putString("newMsgId", String.valueOf(intent3.getLongExtra("k_expose_msg_id", 0)));
                                                                            bundle2.putStringArrayList("proof", intent3.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                                                            bundle2.putInt("msgType", intent3.getIntExtra("k_expose_msg_type", 0));
                                                                            break;
                                                                        default:
                                                                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", Integer.valueOf(i5));
                                                                            break;
                                                                    }
                                                                    bundle2.putString(ch.COL_USERNAME, intent3.getStringExtra("k_username"));
                                                                    break;
                                                                }
                                                                break;
                                                            case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                                                                bundle2.putString("KSessionId", this.Jbp.get().sessionId);
                                                                bundle2.putString("KUserAgent", this.Jbp.get().getUserAgent());
                                                                bundle2.putString("KUrl", this.Jbp.get().fZM());
                                                                int aXI2 = aXI(getIntent().getStringExtra("geta8key_username"));
                                                                if (aXI2 == 7 || aXI2 == 56) {
                                                                    bundle2.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                                                                    break;
                                                                }
                                                            case 79:
                                                                if (this.Jbp.get() != null && !this.Jbp.get().isFinishing()) {
                                                                    bundle2.putInt("height", this.Jbp.get().gfz());
                                                                    break;
                                                                }
                                                            case 81:
                                                                bundle2.putBoolean("from_shortcut", this.Jbp.get().Jix);
                                                                break;
                                                            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
                                                                CharSequence mMTitle = this.Jbp.get().getMMTitle();
                                                                String currentUrl = getCurrentUrl();
                                                                if (!Util.isNullOrNil(mMTitle) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(currentUrl)) {
                                                                    str = mMTitle;
                                                                } else {
                                                                    str = getIntent().getStringExtra("webpageTitle");
                                                                }
                                                                bundle2.putString("webview_current_url", currentUrl);
                                                                bundle2.putString("webview_current_title", str != null ? str.toString() : "");
                                                                bundle2.putString("webview_current_desc", currentUrl);
                                                                break;
                                                            case com.tencent.mm.plugin.appbrand.jsapi.pay.s.CTRL_INDEX:
                                                                CharSequence mMTitle2 = this.Jbp.get().getMMTitle();
                                                                String currentUrl2 = getCurrentUrl();
                                                                Intent intent4 = getIntent();
                                                                if (intent4 != null) {
                                                                    bundle2.putString("share_report_pre_msg_url", intent4.getStringExtra("share_report_pre_msg_url"));
                                                                    bundle2.putString("share_report_pre_msg_title", intent4.getStringExtra("share_report_pre_msg_title"));
                                                                    bundle2.putString("share_report_pre_msg_desc", intent4.getStringExtra("share_report_pre_msg_desc"));
                                                                    bundle2.putString("share_report_pre_msg_icon_url", intent4.getStringExtra("share_report_pre_msg_icon_url"));
                                                                    bundle2.putString("share_report_pre_msg_appid", intent4.getStringExtra("share_report_pre_msg_appid"));
                                                                    bundle2.putInt("share_report_from_scene", intent4.getIntExtra("share_report_from_scene", 0));
                                                                    bundle2.putString("share_report_biz_username", intent4.getStringExtra("share_report_biz_username"));
                                                                    Bundle bundleExtra = intent4.getBundleExtra("ad_report_bundle");
                                                                    if (!Util.isNullOrNil(currentUrl2) && bundleExtra != null && !Util.isNullOrNil(bundleExtra.getString("ad_report_ux_info"))) {
                                                                        Uri parse = Uri.parse(currentUrl2);
                                                                        String queryParameter = parse.getQueryParameter("mid");
                                                                        String queryParameter2 = parse.getQueryParameter("idx");
                                                                        bundleExtra.putString("ad_report_mid", queryParameter);
                                                                        bundleExtra.putString("ad_report_idx", queryParameter2);
                                                                        bundle2.putBundle("ad_report_bundle", bundleExtra);
                                                                    }
                                                                }
                                                                bundle2.putString("share_report_current_url", currentUrl2);
                                                                bundle2.putString("share_report_current_title", mMTitle2 != null ? mMTitle2.toString() : "");
                                                                break;
                                                            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
                                                                bundle2.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
                                                                break;
                                                            case 87:
                                                                if (this.Jbp.get().gfa()) {
                                                                    bundle2.putString("result", "not_return");
                                                                    break;
                                                                } else {
                                                                    bundle2.putString("full_url", Util.nullAsNil(this.Jbp.get().pFJ));
                                                                    if (this.Jbp.get().gfb() != null && this.Jbp.get().gfb().size() != 0) {
                                                                        bundle2.putInt("set_cookie", 1);
                                                                        com.tencent.xweb.d.lA(MMApplicationContext.getContext());
                                                                        com.tencent.xweb.c hsp = com.tencent.xweb.c.hsp();
                                                                        for (String str2 : this.Jbp.get().gfb().keySet()) {
                                                                            hsp.setCookie(Util.getDomin(this.Jbp.get().pFJ), str2 + "=" + this.Jbp.get().gfb().get(str2));
                                                                        }
                                                                        hsp.setCookie(Util.getDomin(this.Jbp.get().pFJ), "httponly");
                                                                        com.tencent.xweb.d.hsr();
                                                                        com.tencent.xweb.d.sync();
                                                                        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", hsp.getCookie(Util.getDomin(this.Jbp.get().pFJ)));
                                                                        break;
                                                                    } else {
                                                                        bundle2.putInt("set_cookie", 0);
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case PlayerException.EXCEPTION_IN_SEEK /*{ENCODED_INT: 95}*/:
                                                                this.Jbp.get().ba(bundle);
                                                                break;
                                                            case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                                                                bundle2.putInt("web_page_count", WebViewUI.Jjc);
                                                                break;
                                                            case 99:
                                                                int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
                                                                bundle2.putInt("geta8key_scene", intExtra);
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", Integer.valueOf(intExtra));
                                                                break;
                                                            case 101:
                                                                bundle.setClassLoader(WebViewUI.class.getClassLoader());
                                                                com.tencent.mm.br.c.b(this.Jbp.get(), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", this.Jbp.get().eam));
                                                                break;
                                                            case 107:
                                                                if (this.Jbp.get() != null && !this.Jbp.get().isFinishing()) {
                                                                    bundle2.putBoolean("isFullScreen", this.Jbp.get().bTK());
                                                                    break;
                                                                } else {
                                                                    bundle2.putBoolean("isFullScreen", false);
                                                                    break;
                                                                }
                                                                break;
                                                            case 140:
                                                                bundle2.putString("current_url", this.Jbp.get().fZM());
                                                                bundle2.putString("raw_url", this.Jbp.get().coX());
                                                                break;
                                                            case 150:
                                                                if (this.Jbp.get() instanceof GameWebViewUI) {
                                                                    GameWebViewUI gameWebViewUI = (GameWebViewUI) this.Jbp.get();
                                                                    bundle2.putString("raw_url", gameWebViewUI.coX());
                                                                    bundle2.putString("page_key", gameWebViewUI.ghj());
                                                                    e wePkgPlugin = gameWebViewUI.getWePkgPlugin();
                                                                    if (wePkgPlugin != null) {
                                                                        bundle2.putString("comm_js_version", e.gky());
                                                                        bundle2.putString("wepkg_version", wePkgPlugin.gkx());
                                                                        bundle2.putBoolean("is_used_wepkg", wePkgPlugin.isAvailable());
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case z.CTRL_INDEX:
                                                                if (this.Jbp.get().JhX != null && this.Jbp.get().JhX.isShowing()) {
                                                                    this.Jbp.get().JhX.dismiss();
                                                                }
                                                                if (bundle == null) {
                                                                    Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "show dialog, data is null");
                                                                    break;
                                                                } else {
                                                                    bundle.getString("title", this.Jbp.get().getString(R.string.zb));
                                                                    this.Jbp.get().JhX = com.tencent.mm.ui.base.h.a(this.Jbp.get(), bundle.getString("message", this.Jbp.get().getString(R.string.a06)), bundle.getBoolean("cancelable", true), new DialogInterface.OnCancelListener() {
                                                                        /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass55 */

                                                                        public final void onCancel(DialogInterface dialogInterface) {
                                                                            AppMethodBeat.i(80002);
                                                                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "WebViewUITipsDialogCancel");
                                                                            try {
                                                                                bundle.putInt("WebViewShare_BinderID", ((WebViewUI) m.this.Jbp.get()).fZu());
                                                                                ((WebViewUI) m.this.Jbp.get()).mHh.j(111, bundle);
                                                                                AppMethodBeat.o(80002);
                                                                            } catch (Exception e2) {
                                                                                Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hide dialog err %s", e2.getMessage());
                                                                                AppMethodBeat.o(80002);
                                                                            }
                                                                        }
                                                                    });
                                                                    break;
                                                                }
                                                            case 199:
                                                                if (this.Jbp.get().JhX != null && this.Jbp.get().JhX.isShowing()) {
                                                                    this.Jbp.get().JhX.dismiss();
                                                                    break;
                                                                }
                                                            case 200:
                                                                WebViewUI webViewUI2 = this.Jbp.get();
                                                                if (webViewUI2 == null) {
                                                                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "AC_ON_FAST_LOAD but null WebViewUI");
                                                                    break;
                                                                } else {
                                                                    b.a aVar = new b.a();
                                                                    Intent intent5 = new Intent();
                                                                    if (bundle.getBoolean("isNativePage")) {
                                                                        intent5.putExtras(bundle);
                                                                        com.tencent.mm.plugin.webview.h.g.a(webViewUI2, bundle.getString("currentInfo"), bZk(), intent5, webViewUI2.bTK());
                                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1061, 21, 1, false);
                                                                    }
                                                                    int i6 = bundle.getInt("scene");
                                                                    int i7 = bundle.getInt(e.b.OyR, 10000);
                                                                    String string5 = bundle.getString("url");
                                                                    if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(string5)) {
                                                                        string5 = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(string5, i6, i7, (int) (System.currentTimeMillis() / 1000));
                                                                    }
                                                                    if (webViewUI2.getIntent() != null) {
                                                                        intent5.putExtra(e.p.OzI, webViewUI2.getIntent().getStringExtra(e.p.OzI));
                                                                    }
                                                                    int i8 = bundle.getInt("item_show_type");
                                                                    bundle.getBoolean("isNativePage");
                                                                    bundle2.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(webViewUI2, string5, i8, i6, i7, intent5, bundle.getInt("openType"), aVar));
                                                                    if (!aVar.success && aVar.message != null) {
                                                                        bundle2.putString("desc", aVar.message);
                                                                        break;
                                                                    }
                                                                }
                                                            case 201:
                                                                if ((this.Jbp.get() instanceof com.tencent.mm.plugin.webview.h.a.b) && bundle != null) {
                                                                    WebViewUI webViewUI3 = this.Jbp.get();
                                                                    String string6 = bundle.getString(NativeProtocol.WEB_DIALOG_ACTION);
                                                                    char c2 = 65535;
                                                                    switch (string6.hashCode()) {
                                                                        case -1913642710:
                                                                            if (string6.equals("showToast")) {
                                                                                c2 = 1;
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case -1471793536:
                                                                            if (string6.equals("readArticle")) {
                                                                                c2 = 2;
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case -633182848:
                                                                            if (string6.equals("writeComment")) {
                                                                                c2 = 0;
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 2006199626:
                                                                            if (string6.equals("writeCommentReply")) {
                                                                                c2 = 3;
                                                                                break;
                                                                            }
                                                                            break;
                                                                    }
                                                                    switch (c2) {
                                                                        case 0:
                                                                            webViewUI3.aT(bundle);
                                                                            break;
                                                                        case 1:
                                                                            webViewUI3.aV(bundle);
                                                                            break;
                                                                        case 2:
                                                                            webViewUI3.aS(bundle);
                                                                            break;
                                                                        case 3:
                                                                            webViewUI3.aW(bundle);
                                                                            break;
                                                                    }
                                                                }
                                                                if (!(this.Jbp.get() instanceof com.tencent.mm.plugin.webview.h.a.c) || bundle == null) {
                                                                    if (bundle != null && "share".equals(bundle.getString(NativeProtocol.WEB_DIALOG_ACTION))) {
                                                                        this.Jbp.get().X(bundle);
                                                                        break;
                                                                    }
                                                                } else {
                                                                    com.tencent.mm.plugin.webview.h.a.c cVar = (com.tencent.mm.plugin.webview.h.a.c) this.Jbp.get();
                                                                    String string7 = bundle.getString(NativeProtocol.WEB_DIALOG_ACTION);
                                                                    if (!"share".equals(string7)) {
                                                                        if (!"switchVideo".equals(string7)) {
                                                                            if (!"createAdWebview".equals(string7)) {
                                                                                if (!"closeAdWebview".equals(string7)) {
                                                                                    if (!"getMPVideoState".equals(string7)) {
                                                                                        if (!"sendMPPageData".equals(string7)) {
                                                                                            if (!"closeDotWebview".equals(string7)) {
                                                                                                if (!"hideDotWebview".equals(string7)) {
                                                                                                    if (!"setDotScriptData".equals(string7)) {
                                                                                                        if ("opPlayer".equals(string7)) {
                                                                                                            cVar.af(bundle);
                                                                                                            break;
                                                                                                        }
                                                                                                    } else {
                                                                                                        cVar.ae(bundle);
                                                                                                        break;
                                                                                                    }
                                                                                                } else {
                                                                                                    cVar.ac(bundle);
                                                                                                    break;
                                                                                                }
                                                                                            } else {
                                                                                                cVar.ab(bundle);
                                                                                                break;
                                                                                            }
                                                                                        } else {
                                                                                            cVar.aa(bundle);
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        bundle2.putAll(cVar.cpH());
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    cVar.cpF();
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                bundle2.putBoolean("ret", cVar.Z(bundle));
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            cVar.Y(bundle);
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        cVar.X(bundle);
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 202:
                                                                if ((this.Jbp.get() instanceof com.tencent.mm.plugin.webview.h.a.b) && bundle != null) {
                                                                    WebViewUI webViewUI4 = this.Jbp.get();
                                                                    String string8 = bundle.getString(NativeProtocol.WEB_DIALOG_ACTION);
                                                                    if (!"writeComment".equals(string8)) {
                                                                        if ("closeComment".equals(string8)) {
                                                                            webViewUI4.gdM();
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        webViewUI4.aU(bundle);
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 203:
                                                                this.Jbp.get().ani();
                                                                break;
                                                            case 252:
                                                                if (this.Jbp.get() instanceof GameWebViewUI) {
                                                                    ((GameWebViewUI) this.Jbp.get()).hXR();
                                                                    break;
                                                                }
                                                                break;
                                                            case 253:
                                                                if (this.Jbp.get() instanceof GameWebViewUI) {
                                                                    ((GameWebViewUI) this.Jbp.get()).hXS();
                                                                    break;
                                                                }
                                                                break;
                                                            case com.tencent.mm.plugin.appbrand.jsapi.af.h.CTRL_INDEX:
                                                                Bundle bundle3 = new Bundle(1);
                                                                bundle3.putString("ad_info_traceId", l.Jhd.getTraceId());
                                                                AppMethodBeat.o(80028);
                                                                return bundle3;
                                                            case 300:
                                                                WebViewUI webViewUI5 = this.Jbp.get();
                                                                if (webViewUI5 == null || webViewUI5.getIntent() == null) {
                                                                    com.tencent.mm.plugin.s.a.p("WebViewStubCallback activity[%s]", webViewUI5);
                                                                    Bundle bundle4 = Bundle.EMPTY;
                                                                    AppMethodBeat.o(80028);
                                                                    return bundle4;
                                                                }
                                                                Bundle bundle5 = new Bundle(1);
                                                                bundle5.putString(e.p.OzI, webViewUI5.getIntent().getStringExtra(e.p.OzI));
                                                                com.tencent.mm.plugin.s.a.p("WebViewStubCallback activity[%s] adUxInfo[%s]", webViewUI5, bundle5.getString(e.p.OzI));
                                                                AppMethodBeat.o(80028);
                                                                return bundle5;
                                                            case 301:
                                                                Bundle bundle6 = new Bundle(1);
                                                                WebViewUI webViewUI6 = this.Jbp.get();
                                                                if (webViewUI6 == null || webViewUI6.getIntent() == null) {
                                                                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "AC_GET_H5_PAY_COOKIE but null WebViewUI");
                                                                    break;
                                                                } else {
                                                                    bundle6.putString("key_h5pay_cookie", getIntent().getStringExtra("key_h5pay_cookie"));
                                                                    AppMethodBeat.o(80028);
                                                                    return bundle6;
                                                                }
                                                                break;
                                                            case 1009:
                                                                if (this.Jbp.get().Jii != null) {
                                                                    this.Jbp.get().Jii.disable();
                                                                }
                                                                this.Jbp.get().screenOrientation = bundle.getInt("screen_orientation", -1);
                                                                if (this.Jbp.get().screenOrientation == 1001) {
                                                                    this.Jbp.get().screenOrientation = 0;
                                                                    if (this.Jbp.get().Jii != null) {
                                                                        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                                                        this.Jbp.get().Jii.enable();
                                                                    }
                                                                } else if (this.Jbp.get().screenOrientation == 1002) {
                                                                    this.Jbp.get().screenOrientation = 1;
                                                                    if (this.Jbp.get().Jii != null) {
                                                                        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                                                        this.Jbp.get().Jii.enable();
                                                                    }
                                                                }
                                                                this.Jbp.get().setMMOrientation();
                                                                break;
                                                            case 4001:
                                                            case 4002:
                                                            case WearableStatusCodes.DATA_ITEM_TOO_LARGE:
                                                            case WearableStatusCodes.INVALID_TARGET_NODE:
                                                            case WearableStatusCodes.ASSET_UNAVAILABLE:
                                                            case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED:
                                                                final k kVar = new k();
                                                                kVar.dCc.context = this.Jbp.get().getContext();
                                                                kVar.dCc.actionCode = i2;
                                                                if (4003 == i2) {
                                                                    kVar.dCc.dCe = bundle.getString("apdu");
                                                                } else if (4004 == i2) {
                                                                    String string9 = bundle.getString("apdus");
                                                                    boolean z5 = bundle.getBoolean("breakIfFail", true);
                                                                    boolean z6 = bundle.getBoolean("breakIfTrue", false);
                                                                    kVar.dCc.dCe = string9;
                                                                    kVar.dCc.dCf = z5;
                                                                    kVar.dCc.dCg = z6;
                                                                }
                                                                kVar.callback = new Runnable() {
                                                                    /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass39 */

                                                                    public final void run() {
                                                                        AppMethodBeat.i(79982);
                                                                        bundle2.putAll(kVar.dCd.dCh);
                                                                        AppMethodBeat.o(79982);
                                                                    }
                                                                };
                                                                EventCenter.instance.publish(kVar);
                                                                break;
                                                            case 5001:
                                                                y(i2, bundle);
                                                                if (this.Jbp.get().mHh.isSDCardAvailable()) {
                                                                    long availableExternalMemorySize2 = SdcardUtil.getAvailableExternalMemorySize2();
                                                                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", Long.valueOf(availableExternalMemorySize2));
                                                                    if (availableExternalMemorySize2 < 524288000) {
                                                                        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
                                                                    } else {
                                                                        o oVar = new o(com.tencent.mm.plugin.webview.a.IJo);
                                                                        boolean z7 = true;
                                                                        if (!oVar.exists()) {
                                                                            z7 = oVar.mkdirs();
                                                                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", oVar.getAbsolutePath(), Boolean.valueOf(z7));
                                                                        }
                                                                        if (z7) {
                                                                            int init2 = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), q.k(oVar.getAbsolutePath(), false));
                                                                            FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                                                                            init = init2;
                                                                        }
                                                                    }
                                                                    init = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), null);
                                                                } else {
                                                                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                                                                    init = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), null);
                                                                }
                                                                if (init == 0) {
                                                                    if (this.Jbp.get().Jjn == null) {
                                                                        this.Jbp.get().Jjn = this.Jbp.get().hXO();
                                                                        FactoryProxyManager.getPlayManager().setUtilsObject(this.Jbp.get().Jjn);
                                                                    }
                                                                    int localServerPort = FactoryProxyManager.getPlayManager().getLocalServerPort();
                                                                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", Integer.valueOf(init), Integer.valueOf(localServerPort));
                                                                    this.Jbp.get().gfg().axq(localServerPort);
                                                                }
                                                                bundle2.putInt("webview_video_proxy_init", init);
                                                                break;
                                                            case 5002:
                                                                y(i2, bundle);
                                                                String string10 = bundle.getString("webview_video_proxy_cdn_urls");
                                                                String string11 = bundle.getString("webview_video_proxy_fileId");
                                                                int i9 = bundle.getInt("webview_video_proxy_file_size");
                                                                int i10 = bundle.getInt("webview_video_proxy_file_duration");
                                                                int i11 = bundle.getInt("webview_video_proxy_file_type");
                                                                int startPlay = FactoryProxyManager.getPlayManager().startPlay(string10, i11, string11, (long) i9, i10);
                                                                String buildPlayURLMp4 = FactoryProxyManager.getPlayManager().buildPlayURLMp4(startPlay);
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", string10, string11, Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(startPlay), buildPlayURLMp4);
                                                                bundle2.putInt("webview_video_proxy_play_data_id", startPlay);
                                                                bundle2.putString("webview_video_proxy_local_url", buildPlayURLMp4);
                                                                break;
                                                            case 5003:
                                                                y(i2, bundle);
                                                                int i12 = bundle.getInt("webview_video_proxy_play_data_id");
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", Integer.valueOf(i12));
                                                                if (i12 > 0) {
                                                                    FactoryProxyManager.getPlayManager().stopPlay(i12);
                                                                    break;
                                                                }
                                                                break;
                                                            case 5004:
                                                                y(i2, bundle);
                                                                FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                                                                break;
                                                            case 5005:
                                                                y(i2, bundle);
                                                                FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                                                                break;
                                                            case 5006:
                                                                y(i2, bundle);
                                                                FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                                                                break;
                                                            case 5007:
                                                                y(i2, bundle);
                                                                int i13 = bundle.getInt("webview_video_proxy_play_data_id");
                                                                int i14 = bundle.getInt("webview_video_proxy_preload_duration");
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", Integer.valueOf(i13), Integer.valueOf(i14));
                                                                bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(i13, i14));
                                                                break;
                                                            case TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE:
                                                                boolean z8 = bundle.getBoolean("clear_webview_cache_clear_cookie", false);
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", Boolean.valueOf(z8));
                                                                Intent intent6 = new Intent();
                                                                intent6.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                                                intent6.putExtra("tools_clean_webview_cache_ignore_cookie", z8);
                                                                com.tencent.mm.cr.d.bJ(intent6);
                                                                break;
                                                            case 90000:
                                                                bundle2.putStringArray("webview_get_route_url_list", this.Jbp.get().Jjk.gdF());
                                                                bundle2.putInt("webview_get_route_url_geta8key_scene", aXI(getIntent().getStringExtra("geta8key_username")));
                                                                bundle2.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                                                                break;
                                                            case 90001:
                                                                String fZM2 = this.Jbp.get().fZM();
                                                                String cookie = com.tencent.xweb.c.hsp().getCookie(fZM2);
                                                                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", fZM2, cookie);
                                                                bundle2.putString("cookie", cookie);
                                                                bundle2.putFloat(Constants.PARAM_DENSITY, bZk());
                                                                if (bundle != null) {
                                                                    bundle2.putString("currentUrlPath", j.aZt(bundle.getString("currentPicUrl")));
                                                                    break;
                                                                }
                                                                break;
                                                            case 90002:
                                                                y(i2, bundle);
                                                                l.Jhd.me(bundle.getString("traceid"), bundle.getString(ch.COL_USERNAME));
                                                                break;
                                                            case 90003:
                                                                bundle2.putString("geta8key_data_req_url", this.Jbp.get().coX());
                                                                bundle2.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
                                                                bundle2.putInt("geta8key_data_scene", aXI(getIntent().getStringExtra("geta8key_username")));
                                                                bundle2.putInt("geta8key_data_reason", 8);
                                                                if (this.Jbp.get().pGj.getIsX5Kernel()) {
                                                                    bundle2.putInt("geta8key_data_flag", 1);
                                                                } else {
                                                                    bundle2.putInt("geta8key_data_flag", 0);
                                                                }
                                                                this.Jbp.get();
                                                                bundle2.putString("geta8key_data_net_type", az.gcX());
                                                                bundle2.putInt("geta8key_session_id", this.Jbp.get().Jiy);
                                                                bundle2.putInt("webview_binder_id", this.Jbp.get().fZu());
                                                                bundle2.putByteArray("k_a8key_cookie", this.Jbp.get().Jiz);
                                                                bundle2.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
                                                                break;
                                                            case 90004:
                                                                bundle.getString("geta8key_result_req_url");
                                                                String string12 = bundle.getString("geta8key_result_full_url");
                                                                if (!Util.isNullOrNil(string12)) {
                                                                    gVar.a(string12.replaceFirst(HttpWrapperBase.PROTOCAL_HTTP, "https//"), new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes")), new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1")));
                                                                    String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
                                                                    String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
                                                                    HashMap hashMap = new HashMap();
                                                                    if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
                                                                        for (int i15 = 0; i15 < stringArray.length; i15++) {
                                                                            hashMap.put(stringArray[i15], stringArray2[i15]);
                                                                        }
                                                                    }
                                                                    String string13 = bundle.getString("geta8key_result_title");
                                                                    if (string13 != null && string13.length() > 0) {
                                                                        this.Jbp.get().setMMTitle(string13);
                                                                        break;
                                                                    }
                                                                } else {
                                                                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
                                                                    break;
                                                                }
                                                            case 100000:
                                                                this.Jbp.get().Jjh = true;
                                                                break;
                                                            default:
                                                                Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
                                                                break;
                                                        }
                                                        AppMethodBeat.o(80028);
                                                        return bundle2;
                                                    }

                                                    @Override // com.tencent.mm.plugin.webview.stub.f
                                                    public final void aL(Bundle bundle) {
                                                        AppMethodBeat.i(80029);
                                                        if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                            AppMethodBeat.o(80029);
                                                            return;
                                                        }
                                                        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setCustomMenu");
                                                        ArrayList<String> stringArrayList = bundle.getStringArrayList("keys");
                                                        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("titles");
                                                        int size = stringArrayList.size();
                                                        ArrayList<e.b> arrayList = new ArrayList<>();
                                                        for (int i2 = 0; i2 < size; i2++) {
                                                            arrayList.add(new e.b(stringArrayList.get(i2), stringArrayList2.get(i2)));
                                                        }
                                                        if (stringArrayList.size() > 0) {
                                                            String url = this.Jbp.get().pGj.getUrl();
                                                            if (this.Jbp.get().JiO.containsKey(url)) {
                                                                this.Jbp.get().JiO.remove(url);
                                                            }
                                                            this.Jbp.get().JiO.put(url, arrayList);
                                                        }
                                                        AppMethodBeat.o(80029);
                                                    }

                                                    @Override // com.tencent.mm.plugin.webview.stub.f
                                                    public final void yN(boolean z) {
                                                        AppMethodBeat.i(80030);
                                                        if (this.Jbp.get() == null || this.Jbp.get().isFinishing()) {
                                                            AppMethodBeat.o(80030);
                                                            return;
                                                        }
                                                        this.Jbp.get().zl(z);
                                                        AppMethodBeat.o(80030);
                                                    }

                                                    private float bZk() {
                                                        float f2;
                                                        AppMethodBeat.i(80031);
                                                        float gvp = com.tencent.mm.cc.a.gvp();
                                                        if (this.Jbp.get().pGj == null || this.Jbp.get().pGj.getWebCoreType() != WebView.c.WV_KIND_CW || !XWalkEnvironment.getUsingCustomContext()) {
                                                            f2 = gvp;
                                                        } else {
                                                            f2 = this.Jbp.get().pGj.getResources().getDisplayMetrics().density;
                                                        }
                                                        AppMethodBeat.o(80031);
                                                        return f2;
                                                    }

                                                    @Override // com.tencent.mm.plugin.webview.stub.f
                                                    public final void lA(final String str, final String str2) {
                                                        AppMethodBeat.i(80032);
                                                        MMHandlerThread.postToMainThread(new Runnable() {
                                                            /* class com.tencent.mm.plugin.webview.ui.tools.m.AnonymousClass60 */

                                                            public final void run() {
                                                                AppMethodBeat.i(80004);
                                                                if (m.this.Jbp.get() == null || ((WebViewUI) m.this.Jbp.get()).isFinishing()) {
                                                                    AppMethodBeat.o(80004);
                                                                    return;
                                                                }
                                                                if (!Util.isNullOrNil(str)) {
                                                                    if (!Util.isNullOrNil(str2)) {
                                                                        m.b(m.this).putExtra("view_port_code", str2);
                                                                    }
                                                                    ((WebViewUI) m.this.Jbp.get()).loadUrl(str);
                                                                }
                                                                AppMethodBeat.o(80004);
                                                            }
                                                        });
                                                        AppMethodBeat.o(80032);
                                                    }

                                                    @Override // com.tencent.mm.plugin.webview.stub.f
                                                    public final Bundle fl(String str, String str2) {
                                                        AppMethodBeat.i(80033);
                                                        Bundle bga = com.tencent.mm.protocal.c.bga(null);
                                                        AppMethodBeat.o(80033);
                                                        return bga;
                                                    }
                                                }
