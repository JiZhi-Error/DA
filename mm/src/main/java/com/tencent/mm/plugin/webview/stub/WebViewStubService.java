package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.aav;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.game.api.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.scanner.d;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.webview.fts.c;
import com.tencent.mm.plugin.webview.k.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.f;
import com.tencent.mm.plugin.webview.model.h;
import com.tencent.mm.plugin.webview.model.q;
import com.tencent.mm.plugin.webview.model.x;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.modeltools.l;
import com.tencent.mm.plugin.webview.modeltools.m;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.tools.y;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewStubService extends Service implements i {
    private Map<String, Integer> IUV;
    private IListener IUW = new IListener<qy>() {
        /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass4 */

        {
            AppMethodBeat.i(160439);
            this.__eventId = qy.class.getName().hashCode();
            AppMethodBeat.o(160439);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qy qyVar) {
            AppMethodBeat.i(79386);
            qy qyVar2 = qyVar;
            if (WebViewStubService.this.IUV == null || WebViewStubService.this.IUV.containsKey(qyVar2.dXy.filePath)) {
                if (WebViewStubService.this.IUV != null) {
                    WebViewStubService.this.IUV.remove(qyVar2.dXy.filePath);
                }
                Log.w("MicroMsg.WebViewStubService", "delete qb recog fail: %s", qyVar2.dXy.filePath);
                s.deleteFile(qyVar2.dXy.filePath);
                AppMethodBeat.o(79386);
            } else {
                AppMethodBeat.o(79386);
            }
            return false;
        }
    };
    private h JaT;
    private final SparseArray<Bundle> Jdk = new SparseArray<>();
    private e.a Jdl = new e.a() {
        /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void v(int i2, Bundle bundle) {
            AppMethodBeat.i(79304);
            com.tencent.mm.plugin.webview.emojistore.a gdq = g.gdq();
            HashMap hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i2) {
                case 1:
                    gdq.bk(hashMap);
                    AppMethodBeat.o(79304);
                    return;
                default:
                    Log.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", Integer.valueOf(i2));
                    AppMethodBeat.o(79304);
                    return;
            }
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final Bundle w(int i2, Bundle bundle) {
            boolean z;
            AppMethodBeat.i(79305);
            c gds = g.gds();
            switch (i2) {
                case 1:
                    int i3 = bundle.getInt("webview_id");
                    gds.INY.remove(Integer.valueOf(i3));
                    c.e eVar = gds.IOd;
                    if (!eVar.gqx) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || Util.isNullOrNil(eVar.query)) {
                        Log.v("MicroMsg.WebSearch.FTSWebViewLogic", "can not report %s", eVar.query);
                    } else {
                        Log.v("MicroMsg.WebSearch.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", Boolean.valueOf(eVar.gqx), eVar.query, Boolean.valueOf(eVar.dDz), Boolean.valueOf(eVar.GjI), Integer.valueOf(eVar.rjr));
                        ar.a(eVar.scene, eVar.query, eVar.GjI, eVar.dDz, eVar.rjr);
                        eVar.gqx = true;
                    }
                    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "activity destroy %d", Integer.valueOf(i3));
                    break;
                case 5:
                    ((n) com.tencent.mm.kernel.g.ah(n.class)).deleteSOSHistory(bundle.getString("history"));
                    break;
                case 6:
                    com.tencent.mm.plugin.topstory.a.i.aTw(bundle.getString("reportString"));
                    break;
                case 7:
                    gr grVar = new gr();
                    grVar.dKH.dDe = 3;
                    grVar.dKH.md5 = bundle.getString("md5");
                    grVar.dKH.dKJ = bundle.getString("designerId");
                    grVar.dKH.aeskey = bundle.getString("aeskey");
                    grVar.dKH.dKK = bundle.getString("encryptUrl");
                    grVar.dKH.productId = bundle.getString("productId");
                    grVar.dKH.name = bundle.getString("name");
                    grVar.dKH.thumbUrl = bundle.getString("thumbUrl");
                    EventCenter.instance.publish(grVar);
                    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "GENERATE_EMOJI_PATH %s", grVar.dKI.path);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emojiPath", grVar.dKI.path);
                    AppMethodBeat.o(79305);
                    return bundle2;
                case 8:
                    doc doc = new doc();
                    doc.MRe = bundle.getString("reportString");
                    com.tencent.mm.kernel.g.azz().a(new ad(doc), 0);
                    break;
            }
            AppMethodBeat.o(79305);
            return null;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final Bundle u(int i2, Bundle bundle) {
            AppMethodBeat.i(79306);
            g.gds();
            Bundle u = c.u(i2, bundle);
            AppMethodBeat.o(79306);
            return u;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String getDisplayName(String str) {
            AppMethodBeat.i(79307);
            String arI = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str).arI();
            AppMethodBeat.o(79307);
            return arI;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean IS(String str) {
            AppMethodBeat.i(79308);
            boolean IS = ab.IS(str);
            AppMethodBeat.o(79308);
            return IS;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean JE(String str) {
            AppMethodBeat.i(79309);
            boolean JE = ab.JE(str);
            AppMethodBeat.o(79309);
            return JE;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean IT(String str) {
            AppMethodBeat.i(79310);
            boolean aAc = com.tencent.mm.kernel.g.aAc();
            Log.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = ".concat(String.valueOf(aAc)));
            if (!aAc) {
                AppMethodBeat.o(79310);
                return false;
            }
            boolean IT = ab.IT(str);
            AppMethodBeat.o(79310);
            return IT;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean apn() {
            AppMethodBeat.i(79311);
            boolean apn = com.tencent.mm.compatible.util.e.apn();
            AppMethodBeat.o(79311);
            return apn;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean gdW() {
            AppMethodBeat.i(79312);
            boolean aAc = com.tencent.mm.kernel.g.aAc();
            AppMethodBeat.o(79312);
            return aAc;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        @Deprecated
        public final void a(final int i2, final Bundle bundle, final int i3) {
            AppMethodBeat.i(79313);
            Log.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", Integer.valueOf(i2), Integer.valueOf(i3));
            WebViewStubService.this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(79295);
                    switch (i2) {
                        case 1:
                            WebViewStubService.a(WebViewStubService.this, 2, bundle, i3);
                            AppMethodBeat.o(79295);
                            return;
                        case 2:
                            u.g(WebViewStubService.this, null);
                            AppMethodBeat.o(79295);
                            return;
                        case 3:
                            Bundle bundle = new Bundle();
                            bundle.putInt("stat_scene", 4);
                            f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i3);
                            if (ahd != null) {
                                bundle.putString("stat_url", ahd.getCurrentUrl());
                            }
                            AnonymousClass1.a(AnonymousClass1.this, bundle, bundle);
                            AppMethodBeat.o(79295);
                            return;
                        case 4:
                            WebViewStubService.a(WebViewStubService.this, 3, bundle, i3);
                            AppMethodBeat.o(79295);
                            return;
                        case 5:
                            int i2 = bundle.getInt("scene_end_type", 0);
                            int i3 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i3 != -1) {
                                WebViewStubService.this.Jdo.add(Integer.valueOf(i3));
                            }
                            Log.i("MicroMsg.WebViewStubService", "add Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_inc_count[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(WebViewStubService.this.Jdo.size()), Integer.valueOf(WebViewStubService.this.Jdm));
                            if (i2 > 0) {
                                WebViewStubService.c(WebViewStubService.this);
                                Log.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", Integer.valueOf(i3));
                                com.tencent.mm.kernel.g.azz().a(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, WebViewStubService.this);
                                com.tencent.mm.kernel.g.azz().a(673, WebViewStubService.this);
                                com.tencent.mm.kernel.g.azz().a(com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX, WebViewStubService.this);
                                AppMethodBeat.o(79295);
                                return;
                            }
                            break;
                        case 6:
                            int i4 = bundle.getInt("scene_end_type", 0);
                            int i5 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i5 != -1) {
                                WebViewStubService.this.Jdo.remove(Integer.valueOf(i5));
                            }
                            Log.i("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_dec_count:[%d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(WebViewStubService.this.Jdo.size()), Integer.valueOf(WebViewStubService.this.Jdm));
                            if (i4 > 0) {
                                WebViewStubService.d(WebViewStubService.this);
                                if (WebViewStubService.this.Jdm < 0) {
                                    Log.e("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set size:[%d], unexpected_count[%d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(WebViewStubService.this.Jdo.size()), Integer.valueOf(WebViewStubService.this.Jdm));
                                    WebViewStubService.this.Jdm = 0;
                                }
                                if (WebViewStubService.this.Jdm <= 0 && WebViewStubService.this.Jdo.size() <= 0) {
                                    Log.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", Integer.valueOf(i5));
                                    if (com.tencent.mm.kernel.g.aAc()) {
                                        com.tencent.mm.kernel.g.azz().b(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, WebViewStubService.this);
                                        com.tencent.mm.kernel.g.azz().b(673, WebViewStubService.this);
                                        com.tencent.mm.kernel.g.azz().b(com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX, WebViewStubService.this);
                                        AppMethodBeat.o(79295);
                                        return;
                                    }
                                }
                            }
                            break;
                        case 7:
                            Intent intent = new Intent();
                            intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
                            intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                            intent.addFlags(268435456);
                            com.tencent.mm.plugin.webview.a.a.jRt.q(intent, WebViewStubService.this);
                            AppMethodBeat.o(79295);
                            return;
                        case 8:
                            Intent intent2 = new Intent();
                            intent2.putExtras(bundle);
                            intent2.addFlags(268435456);
                            com.tencent.mm.plugin.webview.a.a.jRt.r(intent2, WebViewStubService.this);
                            AppMethodBeat.o(79295);
                            return;
                        case 20:
                            bundle.setClassLoader(getClass().getClassLoader());
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i3).JsJ = bundle.getBundle("jsapiargs");
                            String str = (String) bundle.getCharSequence("bizofstartfrom");
                            Bundle bundle2 = bundle.getBundle("startwebviewparams");
                            if (!(str == null || bundle2 == null)) {
                                nz nzVar = new nz();
                                nzVar.dUc.dUd = str;
                                nzVar.dUc.params = bundle2;
                                EventCenter.instance.publish(nzVar);
                            }
                            WebViewStubService.this.Jdp = bundle.getInt("screen_orientation", -1);
                            AppMethodBeat.o(79295);
                            return;
                        case 21:
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i3).ghn().putAll(bundle);
                            AppMethodBeat.o(79295);
                            return;
                        case 29:
                            String string = bundle.getString("srcUsername");
                            ag.bah();
                            com.tencent.mm.al.f.MY(string);
                            ag.bah();
                            com.tencent.mm.al.f.MZ(string);
                            ag.bat();
                            com.tencent.mm.al.l.Nq(string);
                            AppMethodBeat.o(79295);
                            return;
                        case 30:
                            String string2 = bundle.getString("srcUsername");
                            ag.bah();
                            com.tencent.mm.al.f.Na(string2);
                            ag.bat();
                            com.tencent.mm.al.l.Nr(string2);
                            AppMethodBeat.o(79295);
                            return;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                            if (com.tencent.mm.kernel.g.aAc()) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i3).d(bundle, false);
                                AppMethodBeat.o(79295);
                                return;
                            }
                            break;
                        case 2210:
                            if (com.tencent.mm.kernel.g.aAc()) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i3).d(bundle, true);
                                AppMethodBeat.o(79295);
                                return;
                            }
                            break;
                        case 110000:
                            String string3 = bundle.getString("wxa_result");
                            int i6 = bundle.getInt("wxa_code_type", 0);
                            bundle.getInt("wxa_code_version", 0);
                            if (Util.isNullOrNil(string3)) {
                                Log.e("MicroMsg.WebViewStubService", "resultStr is null");
                                AppMethodBeat.o(79295);
                                return;
                            }
                            new d().bZ(i6, string3).a(new d.b<bws>() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.tencent.mm.vending.g.d.b
                                public final /* synthetic */ void bz(bws bws) {
                                    WebViewStubCallbackWrapper webViewStubCallbackWrapper;
                                    AppMethodBeat.i(79294);
                                    bws bws2 = bws;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= WebViewStubService.this.dLA.size()) {
                                            webViewStubCallbackWrapper = null;
                                            break;
                                        } else if (((WebViewStubCallbackWrapper) WebViewStubService.this.dLA.get(i2)).id == i3) {
                                            webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) WebViewStubService.this.dLA.get(i2);
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    }
                                    if (webViewStubCallbackWrapper == null) {
                                        Log.e("MicroMsg.WebViewStubService", "callbackWrapper is null");
                                        AppMethodBeat.o(79294);
                                        return;
                                    }
                                    Bundle bundle = new Bundle();
                                    if (bws2 == null) {
                                        bundle.putInt("key_resp_ret", -1);
                                        try {
                                            webViewStubCallbackWrapper.JhP.f(110001, bundle);
                                            AppMethodBeat.o(79294);
                                        } catch (RemoteException e2) {
                                            Log.w("MicroMsg.WebViewStubService", "processGetCodeNickName exp:%s", e2.getLocalizedMessage());
                                            AppMethodBeat.o(79294);
                                        }
                                    } else {
                                        try {
                                            byte[] byteArray = bws2.toByteArray();
                                            Log.i("MicroMsg.WebViewStubService", "response bytes len = %d ", Integer.valueOf(byteArray.length));
                                            bundle.putInt("key_resp_ret", 0);
                                            bundle.putByteArray("key_resp_item_bytes", byteArray);
                                            webViewStubCallbackWrapper.JhP.f(110001, bundle);
                                            AppMethodBeat.o(79294);
                                        } catch (IOException e3) {
                                            Log.e("MicroMsg.WebViewStubService", e3.getMessage());
                                            AppMethodBeat.o(79294);
                                        } catch (RemoteException e4) {
                                            Log.w("MicroMsg.WebViewStubService", "RemoteException exp:%s", e4.getLocalizedMessage());
                                            AppMethodBeat.o(79294);
                                        }
                                    }
                                }
                            });
                            AppMethodBeat.o(79295);
                            return;
                        default:
                            Log.e("MicroMsg.WebViewStubService", "not support action code:[%d]", Integer.valueOf(i2));
                            break;
                    }
                    AppMethodBeat.o(79295);
                }
            });
            AppMethodBeat.o(79313);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final c aY(Bundle bundle) {
            boolean z;
            AppMethodBeat.i(79314);
            a aVar = new a((byte) 0);
            long j2 = bundle.getLong("msg_id", Long.MIN_VALUE);
            String string = bundle.getString("sns_local_id");
            int i2 = bundle.getInt("news_svr_id", 0);
            String string2 = bundle.getString("news_svr_tweetid");
            cz czVar = new cz();
            if (Long.MIN_VALUE != j2) {
                czVar.dFZ.dGd = bundle.getInt("message_index", 0);
                z = ((com.tencent.mm.plugin.fav.a.ad) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ad.class)).a(czVar, j2);
            } else if (!Util.isNullOrNil(string)) {
                wo woVar = new wo();
                woVar.ecC.ecF = string;
                woVar.ecC.ecG = czVar;
                woVar.ecC.url = bundle.getString("rawUrl");
                woVar.ecC.ecE = true;
                EventCenter.instance.publish(woVar);
                z = woVar.ecD.dFE;
            } else if (i2 != 0) {
                qn qnVar = new qn();
                qnVar.dWV.opType = 3;
                qnVar.dWV.dWX = czVar;
                qnVar.dWV.dWY = i2;
                qnVar.dWV.dWZ = string2;
                EventCenter.instance.publish(qnVar);
                z = qnVar.dWW.dFE;
            } else {
                aVar.ISL = true;
                AppMethodBeat.o(79314);
                return aVar;
            }
            if (z) {
                String nullAsNil = Util.nullAsNil(bundle.getString("prePublishId"));
                String JX = com.tencent.mm.model.ad.JX(nullAsNil);
                ad.b G = com.tencent.mm.model.ad.aVe().G(JX, true);
                G.l("sendAppMsgScene", 2);
                G.l("preChatName", bundle.getString("preChatName"));
                G.l("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
                G.l("prePublishId", nullAsNil);
                G.l("preUsername", bundle.getString("preUsername"));
                G.l("getA8KeyScene", bundle.getString("getA8KeyScene"));
                G.l("referUrl", bundle.getString("referUrl"));
                Bundle bundle2 = bundle.getBundle("jsapiargs");
                if (bundle2 != null) {
                    G.l("adExtStr", bundle2.getString("key_snsad_statextstr"));
                }
                czVar.dFZ.sessionId = JX;
                EventCenter.instance.publish(czVar);
            } else {
                if (czVar.dFZ.dGe == 0) {
                    czVar.dFZ.dGe = R.string.c__;
                }
                EventCenter.instance.publish(czVar);
            }
            aVar.ret = czVar.dGa.ret;
            AppMethodBeat.o(79314);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean isSDCardAvailable() {
            AppMethodBeat.i(79316);
            boolean isSDCardAvailable = com.tencent.mm.kernel.g.aAh().isSDCardAvailable();
            AppMethodBeat.o(79316);
            return isSDCardAvailable;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final int kl(int i2, int i3) {
            AppMethodBeat.i(79317);
            int nullAs = Util.nullAs((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(i2, (Object) null), i3);
            AppMethodBeat.o(79317);
            return nullAs;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void km(final int i2, final int i3) {
            AppMethodBeat.i(79318);
            WebViewStubService.this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(79298);
                    com.tencent.mm.kernel.g.aAh().azQ().set(i2, Integer.valueOf(i3));
                    AppMethodBeat.o(79298);
                }
            });
            AppMethodBeat.o(79318);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String cX(int i2, String str) {
            AppMethodBeat.i(79319);
            String nullAs = Util.nullAs((String) com.tencent.mm.kernel.g.aAh().azQ().get(i2, (Object) null), str);
            AppMethodBeat.o(79319);
            return nullAs;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean x(int i2, Bundle bundle) {
            com.tencent.mm.modelsimple.l lVar;
            AppMethodBeat.i(79320);
            Log.i("MicroMsg.WebViewStubService", "doScene, type = %d", Integer.valueOf(i2));
            switch (i2) {
                case TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS /*{ENCODED_INT: 233}*/:
                    if (!gdW()) {
                        Log.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                        AppMethodBeat.o(79320);
                        return false;
                    }
                    String string = bundle.getString("geta8key_data_req_url");
                    if (!Util.isNullOrNil(bundle.getString("k_share_url"))) {
                        ba.mb(string, bundle.getString("k_share_url"));
                    }
                    if (!Util.isNullOrNil(string)) {
                        lVar = new com.tencent.mm.modelsimple.l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), bundle.getString("geta8key_data_appid"), bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), bundle.getByteArray("k_a8key_cookie"));
                    } else {
                        lVar = new com.tencent.mm.modelsimple.l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0));
                    }
                    lVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                    int i3 = bundle.getInt("geta8key_data_subscene", -1);
                    if (i3 > 0) {
                        lVar.setSubScene(i3);
                    }
                    String string2 = bundle.getString("geta8key_outer_url");
                    if (!Util.isNullOrNil(string2)) {
                        lVar.Pz(string2);
                    }
                    boolean a2 = com.tencent.mm.kernel.g.azz().a(lVar, 0);
                    AppMethodBeat.o(79320);
                    return a2;
                case com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX:
                    if (!gdW()) {
                        Log.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                        AppMethodBeat.o(79320);
                        return false;
                    }
                    boolean aX = WebViewStubService.aX(bundle);
                    AppMethodBeat.o(79320);
                    return aX;
                case 673:
                    if (!gdW()) {
                        Log.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                        AppMethodBeat.o(79320);
                        return false;
                    }
                    q qVar = new q(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height"));
                    qVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                    boolean a3 = com.tencent.mm.kernel.g.azz().a(qVar, 0);
                    AppMethodBeat.o(79320);
                    return a3;
                case 1295:
                    if (!gdW()) {
                        Log.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                        AppMethodBeat.o(79320);
                        return false;
                    } else if (bundle == null) {
                        AppMethodBeat.o(79320);
                        return false;
                    } else {
                        String string3 = bundle.getString("ad_report_data_str");
                        Log.d("MicroMsg.WebViewReportUtil", "doReportCgi : %s", string3);
                        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sns.b.a.class) == null) {
                            AppMethodBeat.o(79320);
                            return false;
                        }
                        ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sns.b.a.class)).r(13791, string3, (int) Util.nowSecond());
                        AppMethodBeat.o(79320);
                        return true;
                    }
                case 2836:
                    if (!gdW()) {
                        Log.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                        AppMethodBeat.o(79320);
                        return false;
                    }
                    boolean a4 = WebViewStubService.a(WebViewStubService.this, bundle);
                    AppMethodBeat.o(79320);
                    return a4;
                default:
                    Log.e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", Integer.valueOf(i2));
                    AppMethodBeat.o(79320);
                    return false;
            }
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean aZN() {
            AppMethodBeat.i(79321);
            boolean aZN = com.tencent.mm.al.g.aZN();
            AppMethodBeat.o(79321);
            return aZN;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void v(int i2, List<String> list) {
            AppMethodBeat.i(79323);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            com.tencent.mm.plugin.report.service.h.r(i2, list);
            AppMethodBeat.o(79323);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String aZR(String str) {
            AppMethodBeat.i(79325);
            String v = ((p) com.tencent.mm.kernel.g.af(p.class)).v(WebViewStubService.this, str);
            AppMethodBeat.o(79325);
            return v;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void gt(String str, int i2) {
            AppMethodBeat.i(79326);
            new Bundle().putInt("webview_binder_id", i2);
            WebViewStubService.a(WebViewStubService.this, 5, null, i2);
            AppMethodBeat.o(79326);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean aUM() {
            AppMethodBeat.i(79328);
            boolean aUM = z.aUM();
            AppMethodBeat.o(79328);
            return aUM;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void l(String str, boolean z, int i2) {
            AppMethodBeat.i(79329);
            f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2);
            if (!Util.isNullOrNil(str)) {
                Log.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", str);
                ahd.hho = false;
                ahd.JsI.add(str);
                if (z) {
                    ahd.JsH.add(str);
                }
            }
            AppMethodBeat.o(79329);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final Bundle agv(int i2) {
            AppMethodBeat.i(79330);
            Bundle ghn = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).ghn();
            AppMethodBeat.o(79330);
            return ghn;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean agw(int i2) {
            AppMethodBeat.i(79331);
            f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2);
            boolean z = ahd.hho;
            boolean z2 = com.tencent.mm.protocal.d.KyR;
            if (z) {
                Log.w("MicroMsg.WebViewStubService", "isBusy(%d), doingFunction = %s", Integer.valueOf(i2), ahd.JsO);
            } else if (z2 && ahd.JsP) {
                Log.i("MicroMsg.WebViewStubService", "isBusy(%d), awaiting proxyUI", Integer.valueOf(i2));
                AppMethodBeat.o(79331);
                return true;
            }
            AppMethodBeat.o(79331);
            return z;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void an(String str, String str2, int i2) {
            AppMethodBeat.i(79332);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).ghn().putString(str, str2);
            AppMethodBeat.o(79332);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void agx(int i2) {
            AppMethodBeat.i(79333);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).Jta.clear();
            AppMethodBeat.o(79333);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i2) {
            f fVar;
            Bundle bundle3;
            AppMethodBeat.i(79334);
            boolean aZP = WebViewStubService.aZP(str2);
            Log.i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + aZP);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            if ((!"wcPrivacyPolicyResult".equals(str2) || (bundle3 = (Bundle) WebViewStubService.this.Jdk.get(i2)) == null || !bundle3.getBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", false)) ? aZP : false) {
                if (WebViewStubService.a(WebViewStubService.this, str, str2, str3, jsapiPermissionWrapper, bundle2, i2)) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).zo(true);
                }
                AppMethodBeat.o(79334);
                return true;
            }
            com.tencent.mm.plugin.webview.d.n nVar = new com.tencent.mm.plugin.webview.d.n();
            nVar.type = str;
            nVar.mhO = str2;
            nVar.ISe = str3;
            nVar.params = com.tencent.mm.plugin.webview.d.n.aN(bundle2.getBundle("compatParams"));
            nVar.IRs = bundle2.getBundle("jsEngine");
            try {
                String string = bundle2.getString("rawParams");
                if (!TextUtils.isEmpty(string)) {
                    nVar.ISf = new JSONObject(string);
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.WebViewStubService", "get rawParams, e = %s", e2);
            }
            f fVar2 = null;
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i2) {
                    fVar = fVar2;
                } else {
                    fVar = webViewStubCallbackWrapper.JhP;
                }
                fVar2 = fVar;
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).K(true, str2);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).a(WebViewStubService.this, fVar2, fVar2);
            boolean a2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).a(nVar, jsapiPermissionWrapper);
            Log.i("MicroMsg.WebViewStubService", "handleRet = ".concat(String.valueOf(a2)));
            AppMethodBeat.o(79334);
            return a2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void a(String str, Bundle bundle, int i2) {
            AppMethodBeat.i(79335);
            Bundle bundle2 = new Bundle();
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
            bundle2.putString("proxyui_username_key", str);
            bundle2.putInt("webview_binder_id", i2);
            WebViewStubService.a(WebViewStubService.this, 4, bundle2, i2);
            AppMethodBeat.o(79335);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean gw(String str) {
            AppMethodBeat.i(79338);
            boolean gw = ((p) com.tencent.mm.kernel.g.af(p.class)).gw(str);
            AppMethodBeat.o(79338);
            return gw;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void aL(int i2, int i3, int i4) {
            AppMethodBeat.i(79339);
            Bundle bundle = new Bundle();
            bundle.putInt("proxyui_expired_errtype", i2);
            bundle.putInt("proxyui_expired_errcode", i3);
            WebViewStubService.a(WebViewStubService.this, 6, bundle, i4);
            AppMethodBeat.o(79339);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean aZU(String str) {
            AppMethodBeat.i(79340);
            boolean aZU = com.tencent.mm.br.c.aZU(str);
            AppMethodBeat.o(79340);
            return aZU;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void agy(int i2) {
            AppMethodBeat.i(79341);
            Log.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", Integer.valueOf(i2));
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                if (webViewStubCallbackWrapper.id == i2) {
                    WebViewStubService.this.dLA.remove(webViewStubCallbackWrapper);
                    AppMethodBeat.o(79341);
                    return;
                }
            }
            WebViewStubService.this.Jdk.remove(i2);
            AppMethodBeat.o(79341);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void a(f fVar, int i2) {
            AppMethodBeat.i(79342);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(fVar == null ? -1 : fVar.hashCode());
            objArr[1] = Integer.valueOf(i2);
            Log.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", objArr);
            WebViewStubService.this.dLA.add(new WebViewStubCallbackWrapper(fVar, i2));
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2);
            try {
                ArrayList arrayList = new ArrayList();
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                    if (!WebViewStubService.a(webViewStubCallbackWrapper)) {
                        arrayList.add(webViewStubCallbackWrapper);
                        Log.e("MicroMsg.WebViewStubService", "removeDeadCallBacker %d is dead, may be crash before, just remove it.", Integer.valueOf(webViewStubCallbackWrapper.id));
                    } else {
                        Log.d("MicroMsg.WebViewStubService", "removeDeadCallBacker %d is not dead.", Integer.valueOf(webViewStubCallbackWrapper.id));
                    }
                }
                if (!Util.isNullOrNil(arrayList)) {
                    WebViewStubService.this.dLA.remove(arrayList);
                }
                AppMethodBeat.o(79342);
            } catch (Exception e2) {
                Log.i("MicroMsg.WebViewStubService", "removeDeadCallBacker ex:%s", e2.getMessage());
                AppMethodBeat.o(79342);
            }
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String[] gdX() {
            AppMethodBeat.i(79343);
            String aj = com.tencent.mm.n.h.aqK().aj("WebViewConfig", "removeJavascriptInterface");
            if (Util.isNullOrNil(aj)) {
                AppMethodBeat.o(79343);
                return null;
            }
            String[] split = aj.split(";");
            AppMethodBeat.o(79343);
            return split;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean aZ(Bundle bundle) {
            AppMethodBeat.i(79344);
            cu cuVar = new cu();
            cuVar.dFU.dFW = bundle.getLong("fav_local_id", -1);
            EventCenter.instance.publish(cuVar);
            Log.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", Long.valueOf(cuVar.dFU.dFW), Boolean.valueOf(cuVar.dFV.dFE));
            boolean z = cuVar.dFV.dFE;
            AppMethodBeat.o(79344);
            return z;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String gdY() {
            AppMethodBeat.i(79345);
            String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(-1535680990, (Object) null);
            AppMethodBeat.o(79345);
            return str;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String aZj(String str) {
            AppMethodBeat.i(79346);
            String aZj = ba.aZj(str);
            AppMethodBeat.o(79346);
            return aZj;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String gdZ() {
            AppMethodBeat.i(79347);
            String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(WebViewStubService.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), WebViewStubService.this);
            AppMethodBeat.o(79347);
            return loadApplicationLanguage;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String aZV(final String str) {
            AppMethodBeat.i(79348);
            boolean aAc = com.tencent.mm.kernel.g.aAc();
            Log.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = ".concat(String.valueOf(aAc)));
            if (!aAc) {
                String str2 = (String) new SyncTask<String>() {
                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass5 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.tencent.mm.sdk.platformtools.SyncTask
                    public final /* synthetic */ String run() {
                        AppMethodBeat.i(79299);
                        if (com.tencent.mm.kernel.g.aAc()) {
                            String value = com.tencent.mm.n.h.aqJ().getValue(str);
                            AppMethodBeat.o(79299);
                            return value;
                        }
                        AppMethodBeat.o(79299);
                        return null;
                    }
                }.exec(WebViewStubService.this.handler);
                AppMethodBeat.o(79348);
                return str2;
            }
            String value = com.tencent.mm.n.h.aqJ().getValue(str);
            AppMethodBeat.o(79348);
            return value;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void aZW(final String str) {
            AppMethodBeat.i(79349);
            boolean aAc = com.tencent.mm.kernel.g.aAc();
            Log.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = ".concat(String.valueOf(aAc)));
            AnonymousClass6 r1 = new SyncTask<Void>() {
                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final /* synthetic */ Void run() {
                    AppMethodBeat.i(79300);
                    if (!com.tencent.mm.kernel.g.aAc()) {
                        AppMethodBeat.o(79300);
                    } else {
                        as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
                        if (Kn == null || ((int) Kn.gMZ) <= 0) {
                            as bjH = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjH(str);
                            if (bjH == null || ((int) bjH.gMZ) <= 0) {
                                ay.a.iDq.a(str, "", null);
                                AppMethodBeat.o(79300);
                            } else {
                                Log.v("MicroMsg.WebViewStubService", "triggerGetContact, alias already exist, no need to getcontact");
                                AppMethodBeat.o(79300);
                            }
                        } else {
                            Log.v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                            AppMethodBeat.o(79300);
                        }
                    }
                    return null;
                }
            };
            if (!aAc) {
                r1.exec(WebViewStubService.this.handler);
                AppMethodBeat.o(79349);
                return;
            }
            r1.exec(null);
            AppMethodBeat.o(79349);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String gu(String str, int i2) {
            AppMethodBeat.i(79350);
            switch (i2) {
                case 1:
                    String aYZ = com.tencent.mm.plugin.webview.model.ay.aYZ(str);
                    AppMethodBeat.o(79350);
                    return aYZ;
                case 2:
                    String aZa = com.tencent.mm.plugin.webview.model.ay.aZa(str);
                    AppMethodBeat.o(79350);
                    return aZa;
                default:
                    AppMethodBeat.o(79350);
                    return null;
            }
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final int aZX(String str) {
            AppMethodBeat.i(79351);
            cz czVar = new cz();
            ((com.tencent.mm.plugin.fav.a.ad) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ad.class)).a(czVar, 1, str);
            EventCenter.instance.publish(czVar);
            int i2 = czVar.dGa.ret;
            AppMethodBeat.o(79351);
            return i2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void favEditTag() {
            AppMethodBeat.i(79352);
            hb hbVar = new hb();
            hbVar.dLm.type = 35;
            EventCenter.instance.publish(hbVar);
            AppMethodBeat.o(79352);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean N(long j2, String str) {
            AppMethodBeat.i(79353);
            if (j2 == Long.MIN_VALUE && str == null) {
                AppMethodBeat.o(79353);
                return false;
            }
            ef efVar = new ef();
            if (j2 != Long.MIN_VALUE) {
                efVar.dHy.msgId = j2;
            }
            if (str != null) {
                efVar.dHy.dHp = str;
            }
            EventCenter.instance.publish(efVar);
            if (efVar.dHz.dGX) {
                AppMethodBeat.o(79353);
                return true;
            }
            if (com.tencent.mm.kernel.g.aAc() && j2 != Long.MIN_VALUE) {
                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
                if (Hb.getType() == 49) {
                    boolean Eq = ab.Eq(Hb.field_talker);
                    String str2 = Hb.field_content;
                    int i2 = Hb.field_isSend;
                    if (Eq && str2 != null && i2 == 0) {
                        str2 = bp.Kt(str2);
                    }
                    k.b HD = k.b.HD(str2);
                    if (HD.type == 3) {
                        boolean s = com.tencent.mm.pluginsdk.model.app.h.s(MMApplicationContext.getContext(), 16);
                        AppMethodBeat.o(79353);
                        return s;
                    } else if (HD.type == 4) {
                        boolean s2 = com.tencent.mm.pluginsdk.model.app.h.s(MMApplicationContext.getContext(), 8);
                        AppMethodBeat.o(79353);
                        return s2;
                    }
                }
            }
            AppMethodBeat.o(79353);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void aZY(String str) {
            EmojiInfo emojiInfo;
            boolean z;
            AppMethodBeat.i(79354);
            if (ImgUtil.isGif(str)) {
                EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(s.bhK(str));
                if (aml == null || !aml.hYi()) {
                    com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                    MMApplicationContext.getContext();
                    emojiInfo = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(emojiMgr.amn(str));
                } else {
                    emojiInfo = aml;
                }
                int boW = emojiInfo == null ? 0 : (int) s.boW(emojiInfo.hYx());
                if (emojiInfo != null) {
                    str = emojiInfo.hYx();
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if ((BitmapUtil.decodeFile(str, options) == null || options.outHeight <= com.tencent.mm.n.c.aqo()) && options.outWidth <= com.tencent.mm.n.c.aqo()) {
                    z = false;
                } else {
                    z = true;
                }
                if (boW > com.tencent.mm.n.c.aqp() || z) {
                    com.tencent.mm.ui.base.h.a(MMApplicationContext.getContext(), WebViewStubService.this.getString(R.string.bs3), "", WebViewStubService.this.getString(R.string.e2u), (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(79354);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", emojiInfo == null ? "" : emojiInfo.getMd5());
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                intent.addFlags(268435456);
                com.tencent.mm.plugin.webview.a.a.jRt.k(intent, WebViewStubService.this);
                AppMethodBeat.o(79354);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", str);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.jRt.k(intent2, WebViewStubService.this);
            AppMethodBeat.o(79354);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String getLanguage() {
            AppMethodBeat.i(79355);
            String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            AppMethodBeat.o(79355);
            return currentLanguage;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String gea() {
            AppMethodBeat.i(79356);
            jw jwVar = new jw();
            EventCenter.instance.publish(jwVar);
            String str = jwVar.dOP.url;
            AppMethodBeat.o(79356);
            return str;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final Map geb() {
            AppMethodBeat.i(79357);
            com.tencent.mm.n.e aqv = com.tencent.mm.n.h.aqK().aqv();
            if (aqv == null) {
                AppMethodBeat.o(79357);
                return null;
            }
            Map<String, String> map = aqv.gMi;
            AppMethodBeat.o(79357);
            return map;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String md(String str, String str2) {
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final int gec() {
            AppMethodBeat.i(79358);
            com.tencent.mm.kernel.g.aAf();
            int uin = com.tencent.mm.kernel.a.getUin();
            AppMethodBeat.o(79358);
            return uin;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final int ged() {
            AppMethodBeat.i(79359);
            int nullAsNil = Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(12304, (Object) null));
            AppMethodBeat.o(79359);
            return nullAsNil;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void gee() {
            AppMethodBeat.i(79360);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("sns_userName", (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, (Object) null));
            intent.addFlags(67108864);
            intent.putExtra("sns_adapter_type", 1);
            com.tencent.mm.kernel.g.aAh().azQ().set(68389, Integer.valueOf(Util.nullAs((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(68389, (Object) null), 0) + 1));
            intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI");
            WebViewStubService webViewStubService = WebViewStubService.this;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, bl.axQ(), "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "gotoSnsUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            webViewStubService.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "gotoSnsUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(79360);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void gef() {
            AppMethodBeat.i(79361);
            if (((z.aUl() & 32768) == 0) && com.tencent.mm.br.c.aZU("sns")) {
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.addFlags(67108864);
                intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                WebViewStubService webViewStubService = WebViewStubService.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, bl.axQ(), "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "gotoSnsUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                webViewStubService.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "gotoSnsUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(79361);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void bs(int i2, boolean z) {
            int i3;
            LinkedList<List> linkedList;
            com.tencent.mm.modelsns.k C;
            Parcelable parcelable;
            WebViewJSSDKFileItem aYO;
            AppMethodBeat.i(211036);
            if (WebViewStubService.this.dLA.size() == 0) {
                gf gfVar = new gf();
                gfVar.dJV.dJY = 2;
                EventCenter.instance.publish(gfVar);
                fz fzVar = new fz();
                fzVar.dJA.op = 2;
                EventCenter.instance.publish(fzVar);
                gc gcVar = new gc();
                gcVar.dJH.op = 2;
                EventCenter.instance.publish(gcVar);
            }
            f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2);
            Log.i("MicroMsg.MsgHandler", "onWebViewUIDestroy floating=%b", Boolean.valueOf(z));
            ahd.JsN = true;
            if (ahd.ghu() && (aYO = g.gdv().aYO(ahd.Jty)) != null) {
                MMHandlerThread.postToMainThread(new Runnable(aYO) {
                    /* class com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass113 */
                    final /* synthetic */ WebViewJSSDKFileItem JuX;

                    {
                        this.JuX = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(81359);
                        gc gcVar = new gc();
                        gcVar.dJH.op = 2;
                        gcVar.dJH.filePath = this.JuX.laR;
                        EventCenter.instance.publish(gcVar);
                        f.this.Jty = null;
                        AppMethodBeat.o(81359);
                    }
                });
            }
            if ((ahd.getPayChannel() == 8 || ahd.getPayChannel() == -1) && ahd.getScene() != 27) {
                if (ahd.getPayChannel() == 8) {
                    if (ahd.JsL == null || ahd.JsL.isEmpty()) {
                        Log.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                    } else {
                        Iterator<Map.Entry<String, String>> it = ahd.JsL.entrySet().iterator();
                        if (it != null) {
                            while (it.hasNext()) {
                                Map.Entry<String, String> next = it.next();
                                String key = next.getKey();
                                String value = next.getValue();
                                Log.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", key, value);
                                dy dyVar = new dy();
                                dyVar.dHa.dHc = key;
                                dyVar.dHa.dGL = value;
                                EventCenter.instance.publish(dyVar);
                                if (!dyVar.dHb.dGX) {
                                    try {
                                        dw dwVar = new dw();
                                        dwVar.dGU.dGW = false;
                                        dwVar.dGU.brandName = key;
                                        dwVar.dGU.dGL = value;
                                        EventCenter.instance.publish(dwVar);
                                        Log.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        Log.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                                    }
                                }
                            }
                        }
                        ahd.JsL.clear();
                    }
                }
            } else if ((ahd.JsM == null || ahd.JsM.isEmpty()) && (ahd.JsL == null || ahd.JsL.isEmpty())) {
                Log.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
            } else {
                if (ahd.JsM != null && !ahd.JsM.isEmpty()) {
                    for (Map.Entry<String, String> entry : ahd.JsM.entrySet()) {
                        String key2 = entry.getKey();
                        String value2 = entry.getValue();
                        Log.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", key2, value2);
                        try {
                            dx dxVar = new dx();
                            dxVar.dGY.dGW = false;
                            dxVar.dGY.brandName = key2;
                            dxVar.dGY.dGL = value2;
                            EventCenter.instance.publish(dxVar);
                            Log.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Exception e3) {
                            Log.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            Log.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                        }
                    }
                    ahd.JsM.clear();
                }
                if (ahd.JsL != null && !ahd.JsL.isEmpty()) {
                    Iterator<Map.Entry<String, String>> it2 = ahd.JsL.entrySet().iterator();
                    boolean ans = f.ans(ahd.ght());
                    Log.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", Boolean.valueOf(ans));
                    if (it2 != null) {
                        while (it2.hasNext()) {
                            Map.Entry<String, String> next2 = it2.next();
                            String key3 = next2.getKey();
                            String value3 = next2.getValue();
                            Log.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", key3, value3);
                            if (ans) {
                                dy dyVar2 = new dy();
                                dyVar2.dHa.dHc = key3;
                                dyVar2.dHa.dGL = value3;
                                EventCenter.instance.publish(dyVar2);
                                if (dyVar2.dHb.dGX) {
                                }
                            }
                            try {
                                dw dwVar2 = new dw();
                                dwVar2.dGU.dGW = false;
                                dwVar2.dGU.brandName = key3;
                                dwVar2.dGU.dGL = value3;
                                EventCenter.instance.publish(dwVar2);
                                Log.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                            } catch (Exception e4) {
                                Log.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                Log.printErrStackTrace("MicroMsg.MsgHandler", e4, "", new Object[0]);
                            }
                        }
                    }
                    ahd.JsL.clear();
                }
            }
            if (ahd.CDo != null) {
                ay.a.iDq.JZ(ahd.CDo);
            }
            com.tencent.mm.plugin.webview.model.h gcu = h.a.gcu();
            if (Util.isNullOrNil(gcu.IXG)) {
                Log.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
            } else if (!com.tencent.mm.kernel.g.aAc()) {
                Log.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
            } else {
                gcu.IXD = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLog2GSendSize", 20480);
                gcu.IXE = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLog3GSendSize", 30720);
                gcu.IXF = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogWifiSendSize", 51200);
                Log.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", Integer.valueOf(gcu.IXD), Integer.valueOf(gcu.IXE), Integer.valueOf(gcu.IXF));
                List<cfy> list = gcu.IXG;
                if (Util.isNullOrNil(list)) {
                    Log.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                    linkedList = null;
                } else {
                    Log.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    Log.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                    StringBuilder sb = new StringBuilder();
                    sb.setLength(0);
                    sb.append("{ ");
                    for (cfy cfy : list) {
                        sb.append(cfy.MlF).append(", ");
                    }
                    sb.append(" }");
                    Log.d("MicroMsg.WebView.JsLogHelper", sb.toString());
                    if (Util.ticksToNow(gcu.IXI) >= 100 || gcu.IXH <= 0) {
                        gcu.IXI = SystemClock.elapsedRealtime();
                        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                            int i4 = gcu.IXF;
                            gcu.IXH = i4;
                            i3 = i4;
                        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                            int i5 = gcu.IXE;
                            gcu.IXH = i5;
                            i3 = i5;
                        } else {
                            NetStatusUtil.is2G(MMApplicationContext.getContext());
                            int i6 = gcu.IXD;
                            gcu.IXH = i6;
                            i3 = i6;
                        }
                    } else {
                        i3 = gcu.IXH;
                    }
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.addAll(list);
                    LinkedList<List> linkedList3 = new LinkedList();
                    LinkedList linkedList4 = null;
                    int i7 = 0;
                    while (linkedList2.size() > 0) {
                        if (i7 <= 0) {
                            linkedList4 = new LinkedList();
                            cfy cfy2 = (cfy) linkedList2.remove();
                            i7 += cfy2.MlG.zy.length;
                            linkedList4.add(cfy2);
                            linkedList3.add(linkedList4);
                        } else if (((cfy) linkedList2.peek()).MlG.zy.length + i7 >= i3) {
                            i7 = 0;
                        } else {
                            cfy cfy3 = (cfy) linkedList2.remove();
                            i7 += cfy3.MlG.zy.length;
                            linkedList4.add(cfy3);
                        }
                    }
                    Log.d("MicroMsg.WebView.JsLogHelper", "split result: ");
                    for (List<cfy> list2 : linkedList3) {
                        sb.setLength(0);
                        sb.append("{ ");
                        for (cfy cfy4 : list2) {
                            sb.append(cfy4.MlF).append(", ");
                        }
                        sb.append(" }");
                        Log.d("MicroMsg.WebView.JsLogHelper", sb.toString());
                        Log.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                    }
                    Log.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    linkedList = linkedList3;
                }
                if (Util.isNullOrNil(linkedList)) {
                    Log.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
                } else {
                    for (List list3 : linkedList) {
                        if (!Util.isNullOrNil(list3)) {
                            Log.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                            com.tencent.mm.kernel.g.azz().a(new x(list3), 0);
                        }
                    }
                    gcu.IXG.clear();
                }
            }
            if (ahd.JsJ != null) {
                ahd.JsJ.setClassLoader(ahd.getClass().getClassLoader());
            }
            if (!(ahd.JsJ == null || (parcelable = ahd.JsJ.getParcelable("KSnsAdTag")) == null || !(parcelable instanceof SnsAdClick))) {
                sa saVar = new sa();
                saVar.dYC.dYD = 1;
                saVar.dYC.dYl = (SnsAdClick) parcelable;
                saVar.dYC.uxInfo = ahd.JsJ.getString("KAnsUxInfo", "");
                EventCenter.instance.publish(saVar);
            }
            String str = "";
            if (ahd.JsJ != null) {
                ahd.JsJ.setClassLoader(ahd.getClass().getClassLoader());
                str = ahd.JsJ.getString("KoriginUrl");
            }
            aav aav = new aav();
            aav.ehL.dvn = str;
            EventCenter.instance.publish(aav);
            if (!(ahd.JsJ == null || (C = com.tencent.mm.modelsns.k.C(ahd.JsJ)) == null)) {
                C.update();
                C.bfK();
            }
            for (String str2 : ahd.Jtx.keySet()) {
                if (!Util.isNullOrNil(str2)) {
                    g.gdu();
                    an.WG(str2);
                    f.b bVar = ahd.Jtx.get(str2);
                    if (bVar != null) {
                        if (bVar.Jvl != null) {
                            g.gdu().b(bVar.Jvl);
                        }
                        if (bVar.JsF != null) {
                            ahd.a(bVar.JsF, "uploadVideo:cancel", (Map<String, Object>) null, false);
                        }
                    }
                }
            }
            ahd.Jtx.clear();
            for (y.a aVar : y.gsJ()) {
                Log.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + aVar.getName());
                aVar.gbt();
            }
            y.clear();
            EventCenter.instance.removeListener(ahd.Dlg);
            EventCenter.instance.removeListener(ahd.Dlh);
            EventCenter.instance.removeListener(ahd.Jtw);
            EventCenter.instance.removeListener(ahd.JtI);
            if (ahd.Jtz != null) {
                EventCenter.instance.removeListener(ahd.Jtz);
            }
            if (ahd.lyu != null) {
                EventCenter.instance.removeListener(ahd.lyu);
            }
            if (ahd.JtG != null) {
                ahd.JtG.dead();
            }
            if (com.tencent.mm.kernel.g.aAc()) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.FALSE);
            }
            SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            ahd.JsG = null;
            ahd.Jtv = null;
            ahd.b(ahd.JsF, new int[0]);
            ahd.JsQ = null;
            ahd.JtD.clear();
            com.tencent.mm.kernel.g.azz().b(1093, ahd.JsS);
            AppMethodBeat.o(211036);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void gv(String str, int i2) {
            AppMethodBeat.i(79363);
            Bundle bundle = new Bundle();
            bundle.putString("proxyui_phone", str);
            WebViewStubService.a(WebViewStubService.this, 8, bundle, i2);
            AppMethodBeat.o(79363);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean geg() {
            AppMethodBeat.i(79364);
            boolean aUo = z.aUo();
            AppMethodBeat.o(79364);
            return aUo;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void a(String str, int[] iArr, int i2, int i3) {
            AppMethodBeat.i(79365);
            if (WebViewStubService.this.IUV == null) {
                WebViewStubService.this.IUV = new HashMap();
                EventCenter.instance.addListener(WebViewStubService.this.hms);
                EventCenter.instance.addListener(WebViewStubService.this.IUW);
            }
            ad.b G = com.tencent.mm.model.ad.aVe().G("basescanui@datacenter", true);
            G.l("key_basescanui_screen_position", Boolean.TRUE);
            G.l("key_basescanui_screen_x", Float.valueOf((float) i2));
            G.l("key_basescanui_screen_y", Float.valueOf((float) i3));
            qx qxVar = new qx();
            qxVar.dXu.filePath = str;
            qxVar.dXu.dDZ = System.currentTimeMillis();
            if (iArr != null && iArr.length > 0) {
                qxVar.dXu.dXv = new HashSet();
                for (int i4 : iArr) {
                    qxVar.dXu.dXv.add(Integer.valueOf(i4));
                }
            }
            EventCenter.instance.publish(qxVar);
            WebViewStubService.this.IUV.put(str, 1);
            AppMethodBeat.o(79365);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void aZZ(String str) {
            AppMethodBeat.i(79366);
            if (WebViewStubService.this.IUV == null || !WebViewStubService.this.IUV.containsKey(str)) {
                Log.e("MicroMsg.WebViewStubService", "%s is not recognizing", str);
                AppMethodBeat.o(79366);
                return;
            }
            ax axVar = new ax();
            axVar.dDY.filePath = str;
            EventCenter.instance.publish(axVar);
            WebViewStubService.this.IUV.remove(str);
            s.deleteFile(str);
            AppMethodBeat.o(79366);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void a(String str, String str2, String str3, int i2, int i3, Bundle bundle) {
            int i4;
            AppMethodBeat.i(79367);
            if (str == null) {
                AppMethodBeat.o(79367);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(MMApplicationContext.getContext(), WebviewScanImageActivity.class);
            intent.setFlags(872415232);
            intent.putExtra("key_string_for_scan", str);
            intent.putExtra("key_string_for_url", str2);
            intent.putExtra("key_string_for_image_url", str3);
            intent.putExtra("key_codetype_for_scan", i2);
            intent.putExtra("key_codeversion_for_scan", i3);
            if (bundle != null) {
                String string = bundle.getString("preUsername");
                String string2 = bundle.getString("preChatName");
                String string3 = bundle.getString("rawUrl");
                String JX = com.tencent.mm.model.ad.JX("WebviewQrCode");
                ad.b G = com.tencent.mm.model.ad.aVe().G(JX, true);
                G.l("preUsername", string);
                G.l("preChatName", string2);
                G.l("url", str2);
                if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(str2)) {
                    i4 = 6;
                } else {
                    i4 = 1;
                }
                G.l("Contact_Sub_Scene", Integer.valueOf(i4));
                G.l("Contact_Scene_Note", str2);
                G.l("rawUrl", string3);
                intent.putExtra("img_gallery_session_id", JX);
                String string4 = bundle.getString("pre_username");
                if (string4 != null && ab.IT(string4)) {
                    intent.putExtra("key_string_for_from_username", string4);
                }
            }
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(79367);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final String baa(String str) {
            AppMethodBeat.i(79368);
            com.tencent.mm.pluginsdk.g.ce(MMApplicationContext.getContext(), str);
            AppMethodBeat.o(79368);
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final boolean geh() {
            AppMethodBeat.i(79369);
            if (Se("EnableWebviewScanQRCode") == 1) {
                AppMethodBeat.o(79369);
                return true;
            }
            AppMethodBeat.o(79369);
            return false;
        }

        private static int Se(String str) {
            int i2 = 1;
            AppMethodBeat.i(79370);
            try {
                i2 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue(str), 1);
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(79370);
            return i2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void agz(int i2) {
            Parcelable parcelable;
            AppMethodBeat.i(79371);
            f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2);
            WebViewStubService webViewStubService = WebViewStubService.this;
            Log.d("MicroMsg.MsgHandler", "onWebViewUIResume");
            ahd.JsN = false;
            for (y.a aVar : y.gsJ()) {
                Log.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + aVar.getName());
                aVar.hU(webViewStubService);
            }
            ahd.JsT = false;
            if (!(ahd.JsJ == null || (parcelable = ahd.JsJ.getParcelable("KSnsAdTag")) == null || !(parcelable instanceof SnsAdClick))) {
                SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                if (snsAdClick.jkY > 0) {
                    snsAdClick.jkZ += Util.ticksToNow(snsAdClick.jkY);
                    snsAdClick.jkY = 0;
                }
            }
            AppMethodBeat.o(79371);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final void agA(int i2) {
            Parcelable parcelable;
            AppMethodBeat.i(79372);
            f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2);
            Log.d("MicroMsg.MsgHandler", "onWebViewUIPause");
            ahd.JsN = true;
            for (y.a aVar : y.gsJ()) {
                Log.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + aVar.getName());
                aVar.gbu();
            }
            if (!(ahd.JsJ == null || (parcelable = ahd.JsJ.getParcelable("KSnsAdTag")) == null || !(parcelable instanceof SnsAdClick))) {
                ((SnsAdClick) parcelable).jkY = Util.currentTicks();
            }
            AppMethodBeat.o(79372);
        }

        @Override // com.tencent.mm.plugin.webview.stub.e
        public final Bundle j(int i2, Bundle bundle) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            g.a bbo;
            f fVar;
            boolean z6;
            String str;
            int i3;
            AppMethodBeat.i(79373);
            Bundle bundle2 = new Bundle();
            switch (i2) {
                case 14:
                    if (bundle == null) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    String nullAsNil = Util.nullAsNil(bundle.getString("task_url"));
                    String string = bundle.getString("task_name");
                    Log.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", nullAsNil, string);
                    if (Util.isNullOrNil(nullAsNil)) {
                        Log.e("MicroMsg.WebViewStubService", "download url is null or nil");
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    g.a aVar = new g.a();
                    aVar.alj(nullAsNil);
                    aVar.all(string);
                    aVar.kS(true);
                    aVar.Fl(1);
                    long a2 = com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar.qIY);
                    Log.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", Long.valueOf(a2));
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("download_id", a2);
                    AppMethodBeat.o(79373);
                    return bundle3;
                case 15:
                    long j2 = bundle.getLong("download_id", 0);
                    FileDownloadTaskInfo Co = com.tencent.mm.plugin.downloader.model.f.cBv().Co(j2);
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(Co == null);
                    if (Co == null) {
                        i3 = 0;
                    } else {
                        i3 = Co.status;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    Log.i("MicroMsg.WebViewStubService", "query download task info, info == null ? %b task state = %d", objArr);
                    int i4 = 0;
                    if (Co != null) {
                        i4 = Co.status;
                    }
                    Log.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(j2), Integer.valueOf(i4));
                    Bundle bundle4 = new Bundle();
                    bundle4.putInt("download_state", i4);
                    AppMethodBeat.o(79373);
                    return bundle4;
                case 16:
                    long j3 = bundle.getLong("download_id", 0);
                    int Cn = com.tencent.mm.plugin.downloader.model.f.cBv().Cn(j3);
                    Log.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(j3), Integer.valueOf(Cn));
                    Bundle bundle5 = new Bundle();
                    bundle5.putBoolean("cancel_result", Cn > 0);
                    AppMethodBeat.o(79373);
                    return bundle5;
                case 17:
                    FileDownloadTaskInfo Co2 = com.tencent.mm.plugin.downloader.model.f.cBv().Co(bundle.getLong("download_id"));
                    Bundle bundle6 = new Bundle();
                    if (Co2 == null) {
                        Log.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                        bundle6.putBoolean("install_result", false);
                        AppMethodBeat.o(79373);
                        return bundle6;
                    } else if (Co2.status != 3) {
                        Log.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + Co2.status);
                        bundle6.putBoolean("install_result", false);
                        AppMethodBeat.o(79373);
                        return bundle6;
                    } else if (s.YS(Co2.path)) {
                        r.b(WebViewStubService.this, Co2.path, null, false);
                        bundle6.putBoolean("install_result", true);
                        AppMethodBeat.o(79373);
                        return bundle6;
                    } else {
                        Log.e("MicroMsg.WebViewStubService", "file not exists : %s", Co2.path);
                        bundle6.putBoolean("install_result", false);
                        AppMethodBeat.o(79373);
                        return bundle6;
                    }
                case 19:
                    Bundle bundle7 = new Bundle();
                    bundle7.putBoolean("webview_video_proxy_init", aw.gcU().hasInit);
                    AppMethodBeat.o(79373);
                    return bundle7;
                case 23:
                    boolean aAc = com.tencent.mm.kernel.g.aAc();
                    AnonymousClass8 r1 = new SyncTask<String>() {
                        /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass8 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // com.tencent.mm.sdk.platformtools.SyncTask
                        public final /* synthetic */ String run() {
                            AppMethodBeat.i(79303);
                            if (!com.tencent.mm.kernel.g.aAc()) {
                                AppMethodBeat.o(79303);
                                return "";
                            }
                            String aTY = z.aTY();
                            AppMethodBeat.o(79303);
                            return aTY;
                        }
                    };
                    if (!aAc) {
                        str = (String) r1.exec(WebViewStubService.this.handler);
                    } else {
                        str = (String) r1.exec(null);
                    }
                    Bundle bundle8 = new Bundle();
                    bundle8.putString("config_info_username", str);
                    AppMethodBeat.o(79373);
                    return bundle8;
                case 24:
                    if (!com.tencent.mm.kernel.g.aAc()) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    Bundle bundle9 = new Bundle();
                    com.tencent.mm.storage.c cVar = null;
                    try {
                        cVar = com.tencent.mm.model.c.d.aXu().Fu(com.tencent.mm.plugin.webview.modeltools.c.Jas);
                    } catch (AssertionFailedError e2) {
                        Log.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                    } catch (com.tencent.mm.model.b e3) {
                        Log.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                    }
                    if (cVar == null || !cVar.isValid()) {
                        Log.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", cVar);
                        AppMethodBeat.o(79373);
                        return bundle9;
                    }
                    Map<String, String> gzz = cVar.gzz();
                    long j4 = Util.getLong(gzz.get("interval"), 0);
                    long nowSecond = Util.nowSecond();
                    long nullAsNil2 = Util.nullAsNil((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, (Object) null));
                    Log.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", Long.valueOf(nullAsNil2), Long.valueOf(nowSecond), Long.valueOf(j4));
                    if (nullAsNil2 >= nowSecond) {
                        Log.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                        AppMethodBeat.o(79373);
                        return bundle9;
                    }
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(j4 + nowSecond));
                    int i5 = Util.getInt(gzz.get("urlCount"), 0);
                    ArrayList<String> arrayList = new ArrayList<>(i5);
                    for (int i6 = 0; i6 < i5; i6++) {
                        arrayList.add(gzz.get(String.format("url%d", Integer.valueOf(i6))));
                    }
                    bundle9.putStringArrayList("cookies_cleanup_url_list", arrayList);
                    AppMethodBeat.o(79373);
                    return bundle9;
                case 31:
                    if (!com.tencent.mm.kernel.g.aAc()) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100036");
                    if (!Fu.isValid()) {
                        Log.d("MicroMsg.WebViewStubService", "test is valid");
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    Map<String, String> gzz2 = Fu.gzz();
                    Bundle bundle10 = new Bundle();
                    int i7 = Util.getInt(gzz2.get("controlFlag"), 0);
                    bundle10.putInt("webview_ad_intercept_control_flag", i7);
                    if (i7 == 0) {
                        Log.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                        AppMethodBeat.o(79373);
                        return bundle10;
                    }
                    int i8 = Util.getInt(gzz2.get("blackListCount"), 0);
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    for (int i9 = 0; i9 < i8; i9++) {
                        String str2 = gzz2.get("blackList" + (i9 + 1));
                        if (!Util.isNullOrNil(str2) && !arrayList2.contains(str2)) {
                            Log.i("MicroMsg.WebViewStubService", "add black list domin = %s", str2);
                            arrayList2.add(str2);
                        }
                    }
                    int i10 = Util.getInt(gzz2.get("whiteListCount"), 0);
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    for (int i11 = 0; i11 < i10; i11++) {
                        String str3 = gzz2.get("whiteList" + (i11 + 1));
                        if (!Util.isNullOrNil(str3) && !arrayList3.contains(str3)) {
                            Log.i("MicroMsg.WebViewStubService", "add white list domin = %s", str3);
                            arrayList3.add(str3);
                        }
                    }
                    bundle10.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                    bundle10.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                    AppMethodBeat.o(79373);
                    return bundle10;
                case 50:
                    if (bundle == null) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    String string2 = bundle.getString("data");
                    if (string2 == null) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    Bundle bundle11 = new Bundle();
                    bundle11.putInt("key_biz_type", com.tencent.mm.al.g.fJ(string2).field_type);
                    AppMethodBeat.o(79373);
                    return bundle11;
                case 51:
                    try {
                        com.tencent.f.h.RTc.aX(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass7 */

                            public final void run() {
                                AppMethodBeat.i(79302);
                                com.tencent.mm.modelgeo.d.bca().a((b.a) new b.a() {
                                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass7.AnonymousClass1 */

                                    @Override // com.tencent.mm.modelgeo.b.a
                                    public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                                        AppMethodBeat.i(79301);
                                        Log.i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3));
                                        com.tencent.mm.modelgeo.d.bca().c(this);
                                        AppMethodBeat.o(79301);
                                        return false;
                                    }
                                }, true);
                                AppMethodBeat.o(79302);
                            }
                        });
                    } catch (Exception e4) {
                        Log.printErrStackTrace("MicroMsg.WebViewStubService", e4, "", new Object[0]);
                    }
                    AppMethodBeat.o(79373);
                    return null;
                case 71:
                    if (bundle == null) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    String string3 = bundle.getString("enterprise_action");
                    Bundle bundle12 = new Bundle();
                    if (string3.equals("enterprise_has_connector")) {
                        ag.bah();
                        if (com.tencent.mm.al.f.aZF().size() > 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        bundle12.putBoolean("enterprise_has_connector", z6);
                    } else if (string3.equals("enterprise_connectors")) {
                        ag.bah();
                        List<String> aZF = com.tencent.mm.al.f.aZF();
                        if (aZF != null) {
                            bundle12.putStringArrayList("enterprise_connectors", new ArrayList<>(aZF));
                        }
                    }
                    AppMethodBeat.o(79373);
                    return bundle12;
                case 75:
                    aw gcU = aw.gcU();
                    if (gcU.hasInit) {
                        gcU.ISw = null;
                        aw.IZA = null;
                        gcU.hasInit = false;
                    }
                    AppMethodBeat.o(79373);
                    return null;
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                    if (bundle == null) {
                        Bundle bundle13 = Bundle.EMPTY;
                        AppMethodBeat.o(79373);
                        return bundle13;
                    }
                    Bundle bundle14 = new Bundle();
                    bundle14.putString("appId", com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(bundle.getInt("webview_binder_id")).aXD(Util.nullAsNil(bundle.getString("rawUrl"))));
                    AppMethodBeat.o(79373);
                    return bundle14;
                case h.a.CTRL_INDEX:
                    bundle2.putBoolean("isOpenForFaceBook", z.aUC());
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    if (bundle != null) {
                        String string4 = bundle.getString("KAppId");
                        String string5 = bundle.getString("shortcut_user_name");
                        int i12 = bundle.getInt("webviewui_binder_id");
                        if (!Util.isNullOrNil(string4) && !Util.isNullOrNil(string5)) {
                            WebViewStubService.a(WebViewStubService.this, 10, bundle, i12);
                            break;
                        } else {
                            AppMethodBeat.o(79373);
                            return null;
                        }
                    } else {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    break;
                case 83:
                    WebViewStubService.this.Jdp = bundle.getInt("screen_orientation", -1);
                    break;
                case PlayerException.EXCEPTION_IN_PREPARE /*{ENCODED_INT: 91}*/:
                    if (bundle != null) {
                        int i13 = bundle.getInt("game_sourceScene");
                        is isVar = new is();
                        isVar.dNr.actionCode = 5;
                        isVar.dNr.scene = i13;
                        EventCenter.instance.publish(isVar);
                        break;
                    } else {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                case 92:
                    if (bundle != null) {
                        String string6 = bundle.getString("game_hv_menu_appid");
                        if (!Util.isNullOrNil(string6)) {
                            it itVar = new it();
                            itVar.dNs.EX = 3;
                            itVar.dNs.param = string6;
                            EventCenter.instance.publish(itVar);
                            bundle2.putString("game_hv_menu_pbcache", itVar.dNt.result);
                            break;
                        } else {
                            AppMethodBeat.o(79373);
                            return null;
                        }
                    } else {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                    if (bundle == null) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    Set<String> keySet = bundle.keySet();
                    if (keySet == null) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String str4 : keySet) {
                            jSONObject.put(str4, bundle.get(str4));
                        }
                        it itVar2 = new it();
                        itVar2.dNs.EX = 4;
                        itVar2.dNs.param = jSONObject.toString();
                        EventCenter.instance.publish(itVar2);
                        break;
                    } catch (JSONException e5) {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                case 102:
                    if (bundle != null) {
                        bundle2.putBoolean("is_enterprise_username", com.tencent.mm.al.g.Ne(bundle.getString("enterprise_biz_username")));
                        break;
                    } else {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                case 103:
                    int i14 = bundle.getInt("key_action", -1);
                    Bundle bundle15 = new Bundle();
                    if (com.tencent.mm.kernel.g.aAf().azp()) {
                        if (9 != i14) {
                            Log.i("MicroMsg.WebViewUIBagHelper", "MM doBagLogic action:%d", Integer.valueOf(i14));
                        }
                        switch (i14) {
                            case 5:
                            case 6:
                                com.tencent.mm.plugin.webview.ui.tools.bag.d dVar = com.tencent.mm.plugin.webview.ui.tools.bag.d.INSTANCE;
                                boolean z7 = bundle.getBoolean("key_in_webviewui_from_bag", false);
                                Log.i("MicroMsg.WebViewBagMgr", "markInWebViewUIFromBag inWebViewUIFromBag:%b", Boolean.valueOf(z7));
                                dVar.JkY = z7;
                                break;
                            case 7:
                                String string7 = bundle.getString("key_bag_id");
                                com.tencent.mm.plugin.webview.ui.tools.bag.d dVar2 = com.tencent.mm.plugin.webview.ui.tools.bag.d.INSTANCE;
                                Log.i("MicroMsg.WebViewBagMgr", "hasBagOfThePage targetId:%s currentId:%s", string7, dVar2.JkZ.id);
                                if (Util.isNullOrNil(dVar2.JkZ.url) || !Util.nullAsNil(string7).equals(dVar2.JkZ.id)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                bundle15.putBoolean("key_has_bag", z4);
                                break;
                            case 8:
                                com.tencent.mm.plugin.webview.ui.tools.bag.d dVar3 = com.tencent.mm.plugin.webview.ui.tools.bag.d.INSTANCE;
                                bundle15.putParcelable("key_current_bag_pos", new Point(dVar3.JkZ.Jlg, dVar3.JkZ.Jlf));
                                break;
                            default:
                                MMHandlerThread.postToMainThread(new Runnable(i14, bundle) {
                                    /* class com.tencent.mm.plugin.webview.ui.tools.bag.f.a.AnonymousClass1 */
                                    final /* synthetic */ Bundle doj;
                                    final /* synthetic */ int dos;

                                    {
                                        this.dos = r1;
                                        this.doj = r2;
                                    }

                                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                                    public final void run() {
                                        boolean z = false;
                                        AppMethodBeat.i(80463);
                                        switch (this.dos) {
                                            case 1:
                                                String string = this.doj.getString("key_url");
                                                String string2 = this.doj.getString("key_bag_icon");
                                                int i2 = this.doj.getInt("key_scene", 0);
                                                boolean z2 = this.doj.getBoolean("key_from_bag", false);
                                                Bundle bundle = this.doj.getBundle("key_extras");
                                                d dVar = d.INSTANCE;
                                                if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
                                                    Log.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
                                                    Context context = MMApplicationContext.getContext();
                                                    RequestFloatWindowPermissionDialog.a(context, context.getString(R.string.iy9), new RequestFloatWindowPermissionDialog.a(string, i2, string2, bundle, z2) {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.bag.d.AnonymousClass1 */
                                                        final /* synthetic */ String Jlc;
                                                        final /* synthetic */ boolean Jld;
                                                        final /* synthetic */ int gsA;
                                                        final /* synthetic */ Bundle val$extras;
                                                        final /* synthetic */ String val$url;

                                                        {
                                                            this.val$url = r2;
                                                            this.gsA = r3;
                                                            this.Jlc = r4;
                                                            this.val$extras = r5;
                                                            this.Jld = r6;
                                                        }

                                                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                                                        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                                                            AppMethodBeat.i(80439);
                                                            requestFloatWindowPermissionDialog.finish();
                                                            d.a(d.this, this.val$url, this.gsA, this.Jlc, this.val$extras, this.Jld);
                                                            d.a(d.this);
                                                            AppMethodBeat.o(80439);
                                                        }

                                                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                                                        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                                                            AppMethodBeat.i(80440);
                                                            requestFloatWindowPermissionDialog.finish();
                                                            AppMethodBeat.o(80440);
                                                        }

                                                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                                                        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                                                            AppMethodBeat.i(185938);
                                                            requestFloatWindowPermissionDialog.finish();
                                                            AppMethodBeat.o(185938);
                                                        }
                                                    }, com.tencent.mm.bq.a.apJ());
                                                    AppMethodBeat.o(80463);
                                                    return;
                                                }
                                                dVar.a(string, i2, string2, bundle, z2);
                                                dVar.ggp();
                                                AppMethodBeat.o(80463);
                                                return;
                                            case 2:
                                                d.INSTANCE.ggq();
                                                AppMethodBeat.o(80463);
                                                return;
                                            case 3:
                                                d dVar2 = d.INSTANCE;
                                                Log.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", Boolean.valueOf(dVar2.JkY));
                                                if (!Util.isNullOrNil(dVar2.JkZ.url) && !dVar2.JkY) {
                                                    if (System.currentTimeMillis() - dVar2.Dqp > 500) {
                                                        z = true;
                                                    }
                                                    if (!z) {
                                                        Log.w("MicroMsg.WebViewBagMgr", "click to fast!!!");
                                                    }
                                                    if (z) {
                                                        if (dVar2.JkW == null || dVar2.JkW.getVisibility() != 0) {
                                                            dVar2.ggp();
                                                            Log.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
                                                            AppMethodBeat.o(80463);
                                                            return;
                                                        }
                                                        Log.i("MicroMsg.WebViewBagMgr", "already show");
                                                        dVar2.JkW.setTouchEnable(true);
                                                        AppMethodBeat.o(80463);
                                                        return;
                                                    }
                                                }
                                                dVar2.ggq();
                                                Log.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
                                                AppMethodBeat.o(80463);
                                                return;
                                            case 4:
                                                d.INSTANCE.ggo();
                                                AppMethodBeat.o(80463);
                                                return;
                                            case 9:
                                                d.INSTANCE.ci(this.doj.getFloat("key_alpha", 1.0f));
                                                break;
                                        }
                                        AppMethodBeat.o(80463);
                                    }
                                });
                                break;
                        }
                    } else {
                        Log.w("MicroMsg.WebViewUIBagHelper", "MM doBagLogic not ready");
                    }
                    AppMethodBeat.o(79373);
                    return bundle15;
                case 104:
                    Bundle bundle16 = new Bundle();
                    com.tencent.mm.plugin.webview.modeltools.f.aQ(bundle);
                    bundle16.putBoolean("open_result", false);
                    AppMethodBeat.o(79373);
                    return bundle16;
                case 105:
                    if (bundle == null) {
                        Bundle bundle17 = new Bundle();
                        AppMethodBeat.o(79373);
                        return bundle17;
                    }
                    int i15 = bundle.getInt("WebViewShare_BinderID");
                    int i16 = bundle.getInt("WebViewShare_type");
                    Bundle bundle18 = new Bundle();
                    String string8 = bundle.getString("WebViewShare_wv_url", "");
                    l.a aVar2 = null;
                    if (i16 == 1) {
                        f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i15);
                        com.tencent.mm.plugin.webview.modeltools.l lVar = ahd.JsW;
                        if (!lVar.Jby.containsKey(string8) || lVar.Jby.get(string8) == null) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            aVar2 = null;
                        } else {
                            aVar2 = ahd.JsW.Jby.get(string8);
                        }
                        bundle18.putBoolean("WebViewShare_reslut", aVar2 != null);
                    } else if (i16 == 2) {
                        f ahd2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i15);
                        com.tencent.mm.plugin.webview.modeltools.l lVar2 = ahd2.JsW;
                        if (!lVar2.Jbz.containsKey(string8) || lVar2.Jbz.get(string8) == null) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            aVar2 = null;
                        } else {
                            aVar2 = ahd2.JsW.Jbz.get(string8);
                        }
                        if (aVar2 != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        bundle18.putBoolean("WebViewShare_reslut", z2);
                    }
                    if (aVar2 != null) {
                        bundle18.putString("link", aVar2.link);
                        bundle18.putString("title", aVar2.title);
                        bundle18.putString("desc", aVar2.desc);
                        bundle18.putString("img_url", aVar2.twt);
                    }
                    AppMethodBeat.o(79373);
                    return bundle18;
                case 108:
                    EventCenter.instance.publish(new cf());
                    AppMethodBeat.o(79373);
                    return null;
                case 109:
                    if (bundle == null) {
                        Bundle bundle19 = new Bundle();
                        AppMethodBeat.o(79373);
                        return bundle19;
                    }
                    int i17 = bundle.getInt("WebViewShare_BinderID");
                    String string9 = bundle.getString("WebViewShare_wv_url", "");
                    f ahd3 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i17);
                    String aYy = com.tencent.mm.pluginsdk.ui.tools.z.aYy(string9);
                    com.tencent.mm.plugin.webview.k.g gVar = ahd3.JsX;
                    if (!gVar.JBy.containsKey(aYy) || gVar.JBy.get(aYy) == null) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (!z5) {
                        bbo = null;
                    } else {
                        bbo = ahd3.JsX.bbo(aYy);
                    }
                    Bundle bundle20 = new Bundle();
                    if (bbo != null) {
                        bundle20.putInt("key_hao_kan_permission", bbo.permission);
                        bundle20.putInt("key_hao_kan_recommand", bbo.JBz);
                        bundle20.putString("key_hao_kan_title", bbo.title);
                    }
                    AppMethodBeat.o(79373);
                    return bundle20;
                case 110:
                    bundle2.putInt("sim_card_type", com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class) != null ? ((com.tencent.mm.plugin.misc.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class)).Qr(16) : 0);
                    AppMethodBeat.o(79373);
                    return bundle2;
                case 111:
                    f ahd4 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(bundle.getInt("WebViewShare_BinderID"));
                    if (bundle != null) {
                        String string10 = bundle.getString("function", "");
                        Log.i("MicroMsg.MsgHandler", "onWebViewUITipsDialogCancel %s", string10);
                        if (Scopes.PROFILE.equals(string10)) {
                            ay.a.iDq.JZ(bundle.getString(ch.COL_USERNAME, ""));
                            ahd4.a(ahd4.JsF, "profile:cancel", (Map<String, Object>) null);
                        }
                    }
                    AppMethodBeat.o(79373);
                    return null;
                case 112:
                    bundle2.putString("oaid", com.tencent.mm.compatible.deviceinfo.q.aoK());
                    AppMethodBeat.o(79373);
                    return bundle2;
                case 129:
                    int i18 = bundle.getInt("webview_instance_id");
                    f fVar2 = null;
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i18) {
                            fVar = fVar2;
                        } else {
                            fVar = webViewStubCallbackWrapper.JhP;
                        }
                        fVar2 = fVar;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i18).a(WebViewStubService.this, fVar2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", Integer.valueOf(bundle.getInt("scene")));
                    hashMap.put("webview_instance_id", Integer.valueOf(i18));
                    com.tencent.mm.plugin.webview.modeltools.g.gds().bp(hashMap);
                    break;
                case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("logString", bundle.getString("logString"));
                    c gds = com.tencent.mm.plugin.webview.modeltools.g.gds();
                    String N = ai.N(hashMap2, "logString");
                    HashMap hashMap3 = new HashMap();
                    if (!N.contains("h5version=")) {
                        hashMap3.put("h5version", Integer.valueOf(ai.aft(0)));
                    }
                    if (hashMap3.keySet().size() > 0) {
                        N = N.length() > 0 ? N + "&" + ai.toUrlParams(hashMap3) : ai.toUrlParams(hashMap3);
                    }
                    hashMap2.put("logString", N);
                    gds.br(hashMap2);
                    break;
                case 204:
                    if (bundle != null) {
                        try {
                            bundle.setClassLoader(getClass().getClassLoader());
                            if (bundle.getStringArrayList("reportAdH5Load") != null) {
                                ArrayList<String> stringArrayList = bundle.getStringArrayList("reportAdH5Load");
                                rs rsVar = new rs();
                                rsVar.dYm.dYl = (SnsAdClick) bundle.getParcelable("snsAdClick");
                                rsVar.dYm.url = com.tencent.mm.compatible.util.q.encode(stringArrayList.get(0), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                                rsVar.dYm.dYn = Util.safeParseInt(stringArrayList.get(1));
                                rsVar.dYm.timestamp = Util.safeParseLong(stringArrayList.get(2));
                                rsVar.dYm.uxInfo = stringArrayList.get(3);
                                rsVar.dYm.errorCode = bundle.getInt("errCode", 0);
                                EventCenter.instance.publish(rsVar);
                                break;
                            }
                        } catch (Exception e6) {
                            Log.e("MicroMsg.WebViewStubService", "report sns ad exception, %s", e6.getMessage());
                            break;
                        }
                    } else {
                        AppMethodBeat.o(79373);
                        return null;
                    }
                    break;
                case 250:
                    if (bundle != null) {
                        if (bundle != null) {
                            try {
                                ThreadPool.post(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x086f: INVOKE  
                                      (wrap: com.tencent.mm.modelstat.a.c$1 : 0x0869: CONSTRUCTOR  (r0v122 com.tencent.mm.modelstat.a.c$1) = (r14v0 'bundle' android.os.Bundle) call: com.tencent.mm.modelstat.a.c.1.<init>(android.os.Bundle):void type: CONSTRUCTOR)
                                      ("web_call_rpt")
                                     type: STATIC call: com.tencent.mm.sdk.thread.ThreadPool.post(java.lang.Runnable, java.lang.String):void in method: com.tencent.mm.plugin.webview.stub.WebViewStubService.1.j(int, android.os.Bundle):android.os.Bundle, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0869: CONSTRUCTOR  (r0v122 com.tencent.mm.modelstat.a.c$1) = (r14v0 'bundle' android.os.Bundle) call: com.tencent.mm.modelstat.a.c.1.<init>(android.os.Bundle):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.stub.WebViewStubService.1.j(int, android.os.Bundle):android.os.Bundle, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 34 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.modelstat.a.c, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 40 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 3294
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.j(int, android.os.Bundle):android.os.Bundle");
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final boolean gei() {
                                AppMethodBeat.i(79374);
                                com.tencent.mm.kernel.g.aAf();
                                if (!com.tencent.mm.kernel.a.azo() || com.tencent.mm.kernel.a.azj()) {
                                    AppMethodBeat.o(79374);
                                    return true;
                                }
                                AppMethodBeat.o(79374);
                                return false;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final void bm(Intent intent) {
                                AppMethodBeat.i(79375);
                                Intent intent2 = new Intent(WebViewStubService.this, WebViewStubProxyUI.class);
                                intent2.putExtra("proxyui_action_code_key", 9);
                                intent2.putExtra("proxyui_next_intent_key", intent);
                                intent2.setFlags(268435456);
                                WebViewStubService webViewStubService = WebViewStubService.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, bl.axQ(), "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "gotoSimpleLoginUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                webViewStubService.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, "com/tencent/mm/plugin/webview/stub/WebViewStubService$1", "gotoSimpleLoginUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(79375);
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final void U(int i2, String str, String str2) {
                                AppMethodBeat.i(79376);
                                WebViewJSSDKFileItem ag = WebViewJSSDKFileItem.ag(i2, str, str2);
                                ag.laW = false;
                                com.tencent.mm.plugin.webview.modeltools.g.gdv().a(ag);
                                com.tencent.mm.plugin.webview.modeltools.g.gdu().b(null, ag.dJX, null);
                                AppMethodBeat.o(79376);
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final List<String> gej() {
                                m mVar;
                                AppMethodBeat.i(79377);
                                if (com.tencent.mm.kernel.g.aAc()) {
                                    com.tencent.mm.plugin.webview.modeltools.g.gdp();
                                    mVar = com.tencent.mm.plugin.webview.modeltools.g.gdw();
                                } else {
                                    mVar = null;
                                }
                                if (mVar == null) {
                                    ArrayList arrayList = new ArrayList();
                                    AppMethodBeat.o(79377);
                                    return arrayList;
                                }
                                ArrayList arrayList2 = new ArrayList(mVar.gdE());
                                AppMethodBeat.o(79377);
                                return arrayList2;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final void b(Bundle bundle, int i2) {
                                AppMethodBeat.i(79378);
                                WebViewStubService.this.Jdk.put(i2, bundle);
                                AppMethodBeat.o(79378);
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final int getPayChannel() {
                                AppMethodBeat.i(79379);
                                int payChannel = com.tencent.mm.pluginsdk.wallet.h.getPayChannel();
                                AppMethodBeat.o(79379);
                                return payChannel;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final boolean gek() {
                                AppMethodBeat.i(79380);
                                if (Se("WebViewDownLoadFileSwitch") == 1) {
                                    AppMethodBeat.o(79380);
                                    return true;
                                }
                                AppMethodBeat.o(79380);
                                return false;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final String[] gel() {
                                AppMethodBeat.i(79381);
                                String aj = com.tencent.mm.n.h.aqK().aj("AsyncCheckUrl", "UrlHost");
                                if (!Util.isNullOrNil(aj)) {
                                    String[] split = aj.split(";");
                                    AppMethodBeat.o(79381);
                                    return split;
                                }
                                AppMethodBeat.o(79381);
                                return null;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final String aZQ(final String str) {
                                AppMethodBeat.i(79315);
                                String Me = com.tencent.mm.aj.c.Me(str);
                                if (!s.YS(Me)) {
                                    com.tencent.mm.plugin.webview.a.a.aj(new Runnable() {
                                        /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass3 */

                                        public final void run() {
                                            AppMethodBeat.i(79297);
                                            com.tencent.mm.aj.c.a(str, false, -1, null);
                                            AppMethodBeat.o(79297);
                                        }
                                    });
                                }
                                AppMethodBeat.o(79315);
                                return Me;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final List<String> aZM() {
                                AppMethodBeat.i(79322);
                                List<String> aZM = com.tencent.mm.al.g.aZM();
                                LinkedList linkedList = new LinkedList();
                                for (String str : aZM) {
                                    if (!com.tencent.mm.al.g.Ne(str)) {
                                        linkedList.add(str);
                                    }
                                }
                                AppMethodBeat.o(79322);
                                return linkedList;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final boolean a(String str, boolean z, Bundle bundle) {
                                AppMethodBeat.i(79324);
                                boolean a2 = q.a.JSZ.a(WebViewStubService.this, str, z, bundle);
                                AppMethodBeat.o(79324);
                                return a2;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final void cP(String str, boolean z) {
                                AppMethodBeat.i(79327);
                                q.a.JSZ.a(WebViewStubService.this, str, z);
                                AppMethodBeat.o(79327);
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final void aZS(String str) {
                                AppMethodBeat.i(79336);
                                com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, false, false);
                                if (o != null && Util.isNullOrNil(o.field_openId)) {
                                    Log.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = ".concat(String.valueOf(str)));
                                    jh jhVar = new jh();
                                    jhVar.dOa.appId = str;
                                    EventCenter.instance.publish(jhVar);
                                }
                                AppMethodBeat.o(79336);
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.e
                            public final String aZT(String str) {
                                AppMethodBeat.i(79337);
                                com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, false, false);
                                if (o == null) {
                                    AppMethodBeat.o(79337);
                                    return null;
                                }
                                String str2 = o.field_packageName;
                                AppMethodBeat.o(79337);
                                return str2;
                            }

                            static /* synthetic */ void a(AnonymousClass1 r3, final Bundle bundle, final Bundle bundle2) {
                                AppMethodBeat.i(79382);
                                WebViewStubService.this.handler.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass1.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(79296);
                                        Intent intent = new Intent();
                                        intent.addFlags(268435456);
                                        intent.putExtras(bundle);
                                        intent.putExtra("isFromWebView", true);
                                        intent.putExtra("_stat_obj", bundle2);
                                        com.tencent.mm.plugin.webview.a.a.jRt.p(intent, WebViewStubService.this);
                                        AppMethodBeat.o(79296);
                                    }
                                });
                                AppMethodBeat.o(79382);
                            }
                        };
                        private int Jdm = 0;
                        private com.tencent.mm.plugin.downloader.model.m Jdn;
                        private Set<Integer> Jdo = new HashSet();
                        private int Jdp = -1;
                        private List<WebViewStubCallbackWrapper> dLA = new ArrayList();
                        private MMHandler handler;
                        private IListener hms = new IListener<qz>() {
                            /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass3 */

                            {
                                AppMethodBeat.i(160438);
                                this.__eventId = qz.class.getName().hashCode();
                                AppMethodBeat.o(160438);
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                            @Override // com.tencent.mm.sdk.event.IListener
                            public final /* synthetic */ boolean callback(qz qzVar) {
                                AppMethodBeat.i(79385);
                                boolean a2 = a(qzVar);
                                AppMethodBeat.o(79385);
                                return a2;
                            }

                            private boolean a(qz qzVar) {
                                AppMethodBeat.i(79384);
                                if (!(qzVar instanceof qz)) {
                                    AppMethodBeat.o(79384);
                                } else if (WebViewStubService.this.IUV == null || WebViewStubService.this.IUV.containsKey(qzVar.dXz.filePath)) {
                                    if (WebViewStubService.this.IUV != null) {
                                        WebViewStubService.this.IUV.remove(qzVar.dXz.filePath);
                                    }
                                    s.deleteFile(qzVar.dXz.filePath);
                                    Log.d("MicroMsg.WebViewStubService", "result: " + qzVar.dXz.result);
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            Log.d("MicroMsg.WebViewStubService", "setRecogResultForQBarImg: %d", Integer.valueOf(webViewStubCallbackWrapper.id));
                                            if (WebViewStubService.a(webViewStubCallbackWrapper)) {
                                                webViewStubCallbackWrapper.JhP.e(qzVar.dXz.filePath, qzVar.dXz.result, qzVar.dXz.dFL, qzVar.dXz.dFM);
                                            }
                                        }
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.WebViewStubService", e2, "", new Object[0]);
                                    }
                                    AppMethodBeat.o(79384);
                                } else {
                                    AppMethodBeat.o(79384);
                                }
                                return false;
                            }
                        };
                        private com.tencent.mm.network.p netChanged;
                        private f.a xBZ;

                        public WebViewStubService() {
                            AppMethodBeat.i(79401);
                            AppMethodBeat.o(79401);
                        }

                        static /* synthetic */ int c(WebViewStubService webViewStubService) {
                            int i2 = webViewStubService.Jdm;
                            webViewStubService.Jdm = i2 + 1;
                            return i2;
                        }

                        static /* synthetic */ int d(WebViewStubService webViewStubService) {
                            int i2 = webViewStubService.Jdm;
                            webViewStubService.Jdm = i2 - 1;
                            return i2;
                        }

                        public void onCreate() {
                            AppMethodBeat.i(79402);
                            super.onCreate();
                            Log.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
                            this.handler = new MMHandler();
                            this.Jdn = new com.tencent.mm.plugin.downloader.model.m() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass5 */

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void k(long j2, String str) {
                                    AppMethodBeat.i(79387);
                                    Log.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(j2)));
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            Bundle bundle = new Bundle();
                                            bundle.putLong("download_manager_downloadid", j2);
                                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                                            bundle.putCharSequence("download_manager_appid", Cw != null ? Cw.field_appId : "");
                                            webViewStubCallbackWrapper.JhP.f(1012, bundle);
                                        }
                                        AppMethodBeat.o(79387);
                                    } catch (Exception e2) {
                                        Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e2.getMessage());
                                        AppMethodBeat.o(79387);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void b(long j2, String str, boolean z) {
                                    AppMethodBeat.i(79388);
                                    Log.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = ".concat(String.valueOf(j2)));
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            Bundle bundle = new Bundle();
                                            bundle.putLong("download_manager_downloadid", j2);
                                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                                            bundle.putCharSequence("download_manager_appid", Cw != null ? Cw.field_appId : "");
                                            webViewStubCallbackWrapper.JhP.f(1002, bundle);
                                        }
                                        AppMethodBeat.o(79388);
                                    } catch (Exception e2) {
                                        Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e2.getMessage());
                                        AppMethodBeat.o(79388);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void b(long j2, int i2, boolean z) {
                                    AppMethodBeat.i(79389);
                                    Log.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = ".concat(String.valueOf(j2)));
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            Bundle bundle = new Bundle();
                                            bundle.putLong("download_manager_downloadid", j2);
                                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                                            bundle.putCharSequence("download_manager_appid", Cw != null ? Cw.field_appId : "");
                                            bundle.putInt("download_manager_errcode", i2);
                                            webViewStubCallbackWrapper.JhP.f(1003, bundle);
                                        }
                                        AppMethodBeat.o(79389);
                                    } catch (Exception e2) {
                                        Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e2.getMessage());
                                        AppMethodBeat.o(79389);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void Bd(long j2) {
                                    AppMethodBeat.i(79390);
                                    Log.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = ".concat(String.valueOf(j2)));
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            Bundle bundle = new Bundle();
                                            bundle.putLong("download_manager_downloadid", j2);
                                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                                            bundle.putCharSequence("download_manager_appid", Cw != null ? Cw.field_appId : "");
                                            webViewStubCallbackWrapper.JhP.f(1008, bundle);
                                        }
                                        AppMethodBeat.o(79390);
                                    } catch (Exception e2) {
                                        Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e2.getMessage());
                                        AppMethodBeat.o(79390);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void Be(long j2) {
                                    AppMethodBeat.i(79391);
                                    Log.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskPaused, downloadId = ".concat(String.valueOf(j2)));
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            Bundle bundle = new Bundle();
                                            bundle.putLong("download_manager_downloadid", j2);
                                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                                            bundle.putCharSequence("download_manager_appid", Cw != null ? Cw.field_appId : "");
                                            webViewStubCallbackWrapper.JhP.f(1010, bundle);
                                        }
                                        AppMethodBeat.o(79391);
                                    } catch (Exception e2) {
                                        Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e2.getMessage());
                                        AppMethodBeat.o(79391);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void a(long j2, String str, long j3, long j4) {
                                    AppMethodBeat.i(211037);
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                                            if (Cw == null || Cw.field_totalSize == 0) {
                                                Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = ".concat(String.valueOf(j2)));
                                                AppMethodBeat.o(211037);
                                                return;
                                            }
                                            int i2 = (int) ((((double) Cw.field_downloadedSize) / ((double) Cw.field_totalSize)) * 100.0d);
                                            float f2 = (((float) Cw.field_downloadedSize) * 100.0f) / ((float) Cw.field_totalSize);
                                            Bundle bundle = new Bundle();
                                            bundle.putLong("download_manager_downloadid", j2);
                                            bundle.putInt("download_manager_progress", i2);
                                            bundle.putFloat("download_manager_progress_float", f2);
                                            bundle.putString("download_manager_appid", Cw.field_appId);
                                            webViewStubCallbackWrapper.JhP.f(1007, bundle);
                                        }
                                        AppMethodBeat.o(211037);
                                    } catch (Exception e2) {
                                        Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e2.getMessage());
                                        AppMethodBeat.o(211037);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void l(long j2, String str) {
                                    AppMethodBeat.i(79393);
                                    Log.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(j2)));
                                    try {
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            Bundle bundle = new Bundle();
                                            bundle.putLong("download_manager_downloadid", j2);
                                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                                            bundle.putCharSequence("download_manager_appid", Cw != null ? Cw.field_appId : "");
                                            webViewStubCallbackWrapper.JhP.f(1011, bundle);
                                        }
                                        AppMethodBeat.o(79393);
                                    } catch (Exception e2) {
                                        Log.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e2.getMessage());
                                        AppMethodBeat.o(79393);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.downloader.model.m
                                public final void Bf(long j2) {
                                }
                            };
                            com.tencent.mm.plugin.downloader.model.f.cBv();
                            com.tencent.mm.plugin.downloader.model.c.a(this.Jdn);
                            this.xBZ = new f.a() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass6 */

                                @Override // com.tencent.mm.plugin.webview.model.f.a
                                public final void a(boolean z, int i2, int i3, String str, String str2) {
                                    AppMethodBeat.i(79394);
                                    Log.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
                                    if (z) {
                                        try {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("webview_jssdk_file_item_local_id", str);
                                            bundle.putInt("webview_jssdk_file_item_progreess", i3);
                                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                                webViewStubCallbackWrapper.JhP.f(2011, bundle);
                                            }
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e2.getMessage());
                                        }
                                    }
                                    switch (i2) {
                                        case 1:
                                            if (z) {
                                                try {
                                                    Bundle bundle2 = new Bundle();
                                                    bundle2.putString("webview_jssdk_file_item_local_id", str);
                                                    bundle2.putInt("webview_jssdk_file_item_progreess", i3);
                                                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : WebViewStubService.this.dLA) {
                                                        webViewStubCallbackWrapper2.JhP.f(2003, bundle2);
                                                    }
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                } catch (Exception e3) {
                                                    Log.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e3.getMessage());
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                }
                                            } else {
                                                try {
                                                    Bundle bundle3 = new Bundle();
                                                    bundle3.putString("webview_jssdk_file_item_server_id", str2);
                                                    bundle3.putInt("webview_jssdk_file_item_progreess", i3);
                                                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper3 : WebViewStubService.this.dLA) {
                                                        webViewStubCallbackWrapper3.JhP.f(2004, bundle3);
                                                    }
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                } catch (Exception e4) {
                                                    Log.e("MicroMsg.WebViewStubService", "notify download image failed :%s", e4.getMessage());
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                }
                                            }
                                        case 2:
                                            if (z) {
                                                try {
                                                    Bundle bundle4 = new Bundle();
                                                    bundle4.putString("webview_jssdk_file_item_local_id", str);
                                                    bundle4.putInt("webview_jssdk_file_item_progreess", i3);
                                                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper4 : WebViewStubService.this.dLA) {
                                                        webViewStubCallbackWrapper4.JhP.f(2005, bundle4);
                                                    }
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                } catch (Exception e5) {
                                                    Log.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", e5.getMessage());
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                }
                                            } else {
                                                try {
                                                    Bundle bundle5 = new Bundle();
                                                    bundle5.putString("webview_jssdk_file_item_server_id", str2);
                                                    bundle5.putInt("webview_jssdk_file_item_progreess", i3);
                                                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper5 : WebViewStubService.this.dLA) {
                                                        webViewStubCallbackWrapper5.JhP.f(2006, bundle5);
                                                    }
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                } catch (Exception e6) {
                                                    Log.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", e6.getMessage());
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                }
                                            }
                                        case 3:
                                        default:
                                            Log.e("MicroMsg.WebViewStubService", "unsupport media type : %d", Integer.valueOf(i2));
                                            break;
                                        case 4:
                                            if (z) {
                                                try {
                                                    Bundle bundle6 = new Bundle();
                                                    bundle6.putString("webview_jssdk_file_item_local_id", str);
                                                    bundle6.putInt("webview_jssdk_file_item_progreess", i3);
                                                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper6 : WebViewStubService.this.dLA) {
                                                        webViewStubCallbackWrapper6.JhP.f(2010, bundle6);
                                                    }
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                } catch (Exception e7) {
                                                    Log.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", e7.getMessage());
                                                    AppMethodBeat.o(79394);
                                                    return;
                                                }
                                            }
                                            break;
                                    }
                                    AppMethodBeat.o(79394);
                                }
                            };
                            this.netChanged = new p.a() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass7 */
                                private final byte[] glH = new byte[0];

                                {
                                    AppMethodBeat.i(79395);
                                    AppMethodBeat.o(79395);
                                }

                                @Override // com.tencent.mm.network.p
                                public final void onNetworkChange(int i2) {
                                    AppMethodBeat.i(79396);
                                    synchronized (this.glH) {
                                        try {
                                            String gcX = com.tencent.mm.pluginsdk.ui.tools.z.gcX();
                                            Bundle bundle = new Bundle();
                                            bundle.putString("webview_network_type", gcX);
                                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                                webViewStubCallbackWrapper.JhP.f(90, bundle);
                                            }
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.WebViewStubService", "notify network change failed :%s", e2.getMessage());
                                        } catch (Throwable th) {
                                            AppMethodBeat.o(79396);
                                            throw th;
                                        }
                                    }
                                    AppMethodBeat.o(79396);
                                }
                            };
                            com.tencent.mm.kernel.g.aAg().a(this.netChanged);
                            if (com.tencent.mm.kernel.g.aAc()) {
                                com.tencent.mm.plugin.webview.modeltools.g.gdu().a(this.xBZ);
                            }
                            this.JaT = new com.tencent.mm.plugin.game.api.h() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass8 */

                                @Override // com.tencent.mm.plugin.game.api.h
                                public final void eb(String str, int i2) {
                                    AppMethodBeat.i(79397);
                                    try {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("game_haowan_publish_post_id", str);
                                        bundle.putInt("game_haowan_publish_retcode", i2);
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            webViewStubCallbackWrapper.JhP.f(254, bundle);
                                        }
                                        AppMethodBeat.o(79397);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.WebViewStubService", "notify network change failed :%s", e2.getMessage());
                                        AppMethodBeat.o(79397);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.game.api.h
                                public final void f(String str, float f2) {
                                    AppMethodBeat.i(79398);
                                    try {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("game_haowan_publish_post_id", str);
                                        bundle.putFloat("game_haowan_publish_progress", f2);
                                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.dLA) {
                                            webViewStubCallbackWrapper.JhP.f(255, bundle);
                                        }
                                        AppMethodBeat.o(79398);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.WebViewStubService", "notify network change failed :%s", e2.getMessage());
                                        AppMethodBeat.o(79398);
                                    }
                                }
                            };
                            com.tencent.mm.plugin.game.api.a.a(this.JaT);
                            AppMethodBeat.o(79402);
                        }

                        public IBinder onBind(Intent intent) {
                            AppMethodBeat.i(79403);
                            Log.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
                            e.a aVar = this.Jdl;
                            AppMethodBeat.o(79403);
                            return aVar;
                        }

                        public boolean onUnbind(Intent intent) {
                            AppMethodBeat.i(79404);
                            Log.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.detach();
                            ba.clear();
                            boolean onUnbind = super.onUnbind(intent);
                            AppMethodBeat.o(79404);
                            return onUnbind;
                        }

                        public void onDestroy() {
                            AppMethodBeat.i(79405);
                            Log.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
                            super.onDestroy();
                            com.tencent.mm.plugin.downloader.model.f.cBv();
                            com.tencent.mm.plugin.downloader.model.c.b(this.Jdn);
                            if (com.tencent.mm.kernel.g.aAc()) {
                                com.tencent.mm.plugin.webview.modeltools.g.gdu().b(this.xBZ);
                            }
                            com.tencent.mm.kernel.g.aAg().b(this.netChanged);
                            this.netChanged = null;
                            this.Jdn = null;
                            this.dLA.clear();
                            com.tencent.mm.plugin.game.api.a.b(this.JaT);
                            AppMethodBeat.o(79405);
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:142:0x05a7 A[SYNTHETIC] */
                        /* JADX WARNING: Removed duplicated region for block: B:49:0x0280  */
                        @Override // com.tencent.mm.ak.i
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onSceneEnd(int r16, int r17, java.lang.String r18, com.tencent.mm.ak.q r19) {
                            /*
                            // Method dump skipped, instructions count: 1450
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.stub.WebViewStubService.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
                        }

                        public static class b extends d.a {
                            public Bundle dQL;
                            public int errCode;
                            public String errMsg;
                            public int errType;
                            public int type;

                            @Override // com.tencent.mm.plugin.webview.stub.d
                            public final int getType() {
                                return this.type;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.d
                            public final int getErrType() {
                                return this.errType;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.d
                            public final int getErrCode() {
                                return this.errCode;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.d
                            public final String getErrMsg() {
                                return this.errMsg;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.d
                            public final Bundle getData() {
                                return this.dQL;
                            }
                        }

                        static class a extends c.a {
                            public boolean ISL;
                            public boolean result;
                            public int ret;
                            public int type;

                            private a() {
                            }

                            /* synthetic */ a(byte b2) {
                                this();
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.c
                            public final boolean gdT() {
                                return this.ISL;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.c
                            public final boolean getResult() {
                                return this.result;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.c
                            public final int getRet() {
                                return this.ret;
                            }

                            @Override // com.tencent.mm.plugin.webview.stub.c
                            public final int getType() {
                                return this.type;
                            }
                        }

                        static /* synthetic */ void a(WebViewStubService webViewStubService, int i2, Bundle bundle, int i3) {
                            AppMethodBeat.i(79407);
                            WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.dLA) {
                                if (webViewStubCallbackWrapper2 == null || webViewStubCallbackWrapper2.id != i3) {
                                    webViewStubCallbackWrapper2 = webViewStubCallbackWrapper;
                                }
                                webViewStubCallbackWrapper = webViewStubCallbackWrapper2;
                            }
                            if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.JhP == null) {
                                AppMethodBeat.o(79407);
                                return;
                            }
                            final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
                            intent.putExtras(bundle);
                            intent.putExtra("proxyui_action_code_key", i2);
                            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
                            intent.putExtra("webview_binder_id", i3);
                            intent.putExtra("screen_orientation", webViewStubService.Jdp);
                            intent.addFlags(268435456);
                            com.tencent.mm.plugin.webview.ui.tools.e.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.JhP, new Runnable() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass10 */

                                public final void run() {
                                    AppMethodBeat.i(79400);
                                    WebViewStubService webViewStubService = WebViewStubService.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, bl.axQ(), "com/tencent/mm/plugin/webview/stub/WebViewStubService$9", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    webViewStubService.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, "com/tencent/mm/plugin/webview/stub/WebViewStubService$9", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    AppMethodBeat.o(79400);
                                }
                            });
                            AppMethodBeat.o(79407);
                        }

                        static /* synthetic */ boolean aX(Bundle bundle) {
                            AppMethodBeat.i(79408);
                            com.tencent.mm.aq.c cVar = new com.tencent.mm.aq.c(bundle.getString("emoji_store_jump_url"));
                            cVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                            boolean a2 = com.tencent.mm.kernel.g.azz().a(cVar, 0);
                            AppMethodBeat.o(79408);
                            return a2;
                        }

                        static /* synthetic */ boolean a(WebViewStubService webViewStubService, Bundle bundle) {
                            AppMethodBeat.i(79409);
                            String string = bundle.getString("service_click_tid");
                            long j2 = bundle.getLong("service_click_stime", 0);
                            long j3 = bundle.getLong("service_click_etime", 0);
                            Log.i("MicroMsg.WebViewStubService", "doServiceClick tid = %s, stime = %d, etime = %d", string, Long.valueOf(j2), Long.valueOf(j3));
                            if (string == null || string.length() == 0) {
                                Log.e("MicroMsg.WebViewStubService", "doServiceClick fail, tid is null");
                                AppMethodBeat.o(79409);
                                return false;
                            }
                            d.a aVar = new d.a();
                            aVar.iLN = new dut();
                            aVar.iLO = new duu();
                            aVar.uri = "/cgi-bin/mmoc-bin/ad/service_click";
                            aVar.funcId = 2836;
                            com.tencent.mm.ak.d aXF = aVar.aXF();
                            dut dut = (dut) aXF.iLK.iLR;
                            dut.wPU = string;
                            dut.cUf = j2;
                            dut.MVZ = j3;
                            aa.a(aXF, new aa.a() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass2 */

                                @Override // com.tencent.mm.ak.aa.a
                                public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                                    AppMethodBeat.i(79383);
                                    Log.i("MicroMsg.WebViewStubService", "ServiceClick CGI return, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                    if (i2 == 0 && i3 == 0) {
                                        AppMethodBeat.o(79383);
                                    } else {
                                        Log.e("MicroMsg.WebViewStubService", "ServiceClick CGI fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                        AppMethodBeat.o(79383);
                                    }
                                    return 0;
                                }
                            });
                            AppMethodBeat.o(79409);
                            return true;
                        }

                        static /* synthetic */ boolean aZP(String str) {
                            AppMethodBeat.i(79410);
                            if (str == null) {
                                Log.e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
                            } else {
                                c.g bgb = com.tencent.mm.protocal.c.bgb(str);
                                if (bgb == null) {
                                    Log.e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", str);
                                } else if (bgb.gtu()) {
                                    AppMethodBeat.o(79410);
                                    return true;
                                }
                            }
                            AppMethodBeat.o(79410);
                            return false;
                        }

                        static /* synthetic */ boolean a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i2) {
                            AppMethodBeat.i(79411);
                            WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.dLA) {
                                if (webViewStubCallbackWrapper2 == null || webViewStubCallbackWrapper2.id != i2) {
                                    webViewStubCallbackWrapper2 = webViewStubCallbackWrapper;
                                }
                                webViewStubCallbackWrapper = webViewStubCallbackWrapper2;
                            }
                            if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.JhP == null) {
                                AppMethodBeat.o(79411);
                                return false;
                            }
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i2).K(true, str2);
                            final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
                            intent.putExtras(bundle);
                            intent.putExtra("proxyui_action_code_key", 1);
                            intent.putExtra("proxyui_type_key", str);
                            intent.putExtra("proxyui_function_key", str2);
                            intent.putExtra("proxyui_callback_key", str3);
                            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
                            intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
                            intent.putExtra("webview_binder_id", i2);
                            intent.putExtra("screen_orientation", webViewStubService.Jdp);
                            intent.addFlags(268435456);
                            boolean a2 = com.tencent.mm.plugin.webview.ui.tools.e.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.JhP, new Runnable() {
                                /* class com.tencent.mm.plugin.webview.stub.WebViewStubService.AnonymousClass9 */

                                public final void run() {
                                    AppMethodBeat.i(79399);
                                    WebViewStubService webViewStubService = WebViewStubService.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, bl.axQ(), "com/tencent/mm/plugin/webview/stub/WebViewStubService$8", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    webViewStubService.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(webViewStubService, "com/tencent/mm/plugin/webview/stub/WebViewStubService$8", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    AppMethodBeat.o(79399);
                                }
                            });
                            AppMethodBeat.o(79411);
                            return a2;
                        }

                        static /* synthetic */ boolean a(WebViewStubCallbackWrapper webViewStubCallbackWrapper) {
                            AppMethodBeat.i(211038);
                            if (webViewStubCallbackWrapper != null) {
                                IBinder asBinder = webViewStubCallbackWrapper.JhP.asBinder();
                                if (asBinder.isBinderAlive() && asBinder.pingBinder()) {
                                    AppMethodBeat.o(211038);
                                    return true;
                                }
                            }
                            AppMethodBeat.o(211038);
                            return false;
                        }
                    }
