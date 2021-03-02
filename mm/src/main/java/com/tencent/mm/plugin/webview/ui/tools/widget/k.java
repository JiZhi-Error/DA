package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.h.l;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.k;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.j;
import com.tencent.xweb.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class k extends ac {
    public g IRi;
    public e JpV;
    public h JpW;
    com.tencent.mm.plugin.webview.d.k Jqa;
    private String JyA;
    private final Map<String, Integer> JyB;
    protected b JyC;
    protected a JyD;
    protected ar JyE;
    protected String JyF;
    protected String JyG;
    private String JyH;
    private List<com.tencent.mm.plugin.webview.d.d.a> JyI;
    private final Map<String, String> JyJ;
    private final Map<String, Map<String, String>> JyK;
    protected boolean JyL;
    protected boolean JyM;
    private boolean JyN;
    protected Map<String, String> JyO;
    private boolean JyP;
    private final Runnable JyQ;
    protected c JyR;
    public m JyS;
    final Bundle Jyy;
    protected boolean Jyz;
    protected MutableContextWrapper ctH;
    public MMWebView iGY;
    MMHandler mHandler;
    protected String xwe;

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(212117);
        kVar.gir();
        AppMethodBeat.o(212117);
    }

    static /* synthetic */ String c(k kVar) {
        AppMethodBeat.i(212120);
        String fZM = kVar.fZM();
        AppMethodBeat.o(212120);
        return fZM;
    }

    public final boolean gio() {
        return this.JyM;
    }

    public final String coy() {
        return this.xwe;
    }

    public final Map gip() {
        return this.JyO;
    }

    public k(MMWebView mMWebView) {
        this(mMWebView, (byte) 0);
    }

    public k(MMWebView mMWebView, byte b2) {
        this(mMWebView, false, null);
    }

    public k(MMWebView mMWebView, boolean z, Bundle bundle) {
        Parcelable parcelableExtra;
        Parcelable parcelable = null;
        AppMethodBeat.i(82199);
        this.Jqa = null;
        this.JpW = null;
        this.Jyz = false;
        this.JyA = "";
        this.JyB = new HashMap();
        this.JyC = new b();
        this.JyD = new a(null);
        this.JyF = null;
        this.JyG = null;
        this.JyH = null;
        this.JyI = new ArrayList();
        this.JyJ = new HashMap();
        this.JyK = new ConcurrentHashMap();
        this.JyL = false;
        this.JyM = false;
        this.JyN = false;
        this.JyP = true;
        this.JyQ = new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(212073);
                if (k.this.Jqa == null) {
                    AppMethodBeat.o(212073);
                    return;
                }
                k.this.Jqa.gbl();
                k.this.Jqa.KY();
                AppMethodBeat.o(212073);
            }
        };
        this.JyR = new c();
        this.JyS = new m() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6 */
            private m JyU = new m();

            {
                AppMethodBeat.i(212093);
                AppMethodBeat.o(212093);
            }

            private m git() {
                AppMethodBeat.i(212094);
                m bLB = k.this.bLB();
                if (bLB == null) {
                    m mVar = this.JyU;
                    AppMethodBeat.o(212094);
                    return mVar;
                }
                AppMethodBeat.o(212094);
                return bLB;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final boolean afl(int i2) {
                AppMethodBeat.i(212095);
                boolean afl = git().afl(i2);
                AppMethodBeat.o(212095);
                return afl;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final boolean f(int i2, final Bundle bundle) {
                AppMethodBeat.i(212096);
                Log.i("MicroMsg.MMWebViewClient", "callback, actionCode = ".concat(String.valueOf(i2)));
                switch (i2) {
                    case 90:
                        if (k.this.JpW != null) {
                            k.this.mHandler.post(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass5 */

                                public final void run() {
                                    AppMethodBeat.i(212080);
                                    if (k.this.JpW != null) {
                                        k.this.JpW.aYj(bundle.getString("webview_network_type"));
                                    }
                                    AppMethodBeat.o(212080);
                                }
                            });
                            break;
                        }
                        break;
                    case 1002:
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(212076);
                                if (!(k.this.JpW == null || k.this.IRi == null || !k.this.IRi.gdH().pP(42))) {
                                    k.this.JpW.j(bundle, "download_succ");
                                }
                                AppMethodBeat.o(212076);
                            }
                        });
                        break;
                    case 1003:
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass10 */

                            public final void run() {
                                AppMethodBeat.i(212085);
                                if (!(k.this.JpW == null || k.this.IRi == null || !k.this.IRi.gdH().pP(42))) {
                                    k.this.JpW.j(bundle, "download_fail");
                                }
                                AppMethodBeat.o(212085);
                            }
                        });
                        break;
                    case 1006:
                        if (k.this.JpW != null) {
                            k.this.mHandler.post(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass4 */

                                public final void run() {
                                    boolean z = true;
                                    AppMethodBeat.i(212079);
                                    if (!bundle.containsKey("jsapi_preverify_fun_list") || k.this.IRi == null) {
                                        Object[] objArr = new Object[1];
                                        if (k.this.IRi == null) {
                                            z = false;
                                        }
                                        objArr[0] = Boolean.valueOf(z);
                                        Log.e("MicroMsg.MMWebViewClient", "has JSAPI_CONTROL_BYTES wvPerm %b", objArr);
                                    } else {
                                        k.this.IRi.aR(bundle);
                                    }
                                    if (k.this.JpW != null) {
                                        k.this.JpW.gaY();
                                    }
                                    AppMethodBeat.o(212079);
                                }
                            });
                            break;
                        }
                        break;
                    case 1007:
                        final long j2 = bundle.getLong("download_manager_downloadid");
                        final int i3 = bundle.getInt("download_manager_progress");
                        final float f2 = bundle.getFloat("download_manager_progress_float");
                        final String string = bundle.getString("download_manager_appid", "");
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass12 */

                            public final void run() {
                                AppMethodBeat.i(212087);
                                if (!(k.this.JpW == null || k.this.IRi == null || !k.this.IRi.gdH().pP(42))) {
                                    k.this.JpW.a(string, j2, i3, f2);
                                }
                                AppMethodBeat.o(212087);
                            }
                        });
                        break;
                    case 1008:
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass11 */

                            public final void run() {
                                AppMethodBeat.i(212086);
                                if (!(k.this.JpW == null || k.this.IRi == null || !k.this.IRi.gdH().pP(42))) {
                                    k.this.JpW.j(bundle, "download_removed");
                                }
                                AppMethodBeat.o(212086);
                            }
                        });
                        break;
                    case 2002:
                        final HashMap hashMap = new HashMap();
                        hashMap.put("err_msg", bundle.getString("playResult"));
                        hashMap.put(ch.COL_LOCALID, bundle.getString(ch.COL_LOCALID));
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(212077);
                                if (k.this.JpW != null) {
                                    k.this.JpW.bI(hashMap);
                                }
                                AppMethodBeat.o(212077);
                            }
                        });
                        break;
                    case 2003:
                        final String string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        final int i4 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass13 */

                            public final void run() {
                                AppMethodBeat.i(212088);
                                if (k.this.JpW != null) {
                                    k.this.JpW.gk(string2, i4);
                                }
                                AppMethodBeat.o(212088);
                            }
                        });
                        break;
                    case 2004:
                        final String string3 = bundle.getString("webview_jssdk_file_item_local_id");
                        final int i5 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass14 */

                            public final void run() {
                                AppMethodBeat.i(212089);
                                if (k.this.JpW != null) {
                                    k.this.JpW.gl(string3, i5);
                                }
                                AppMethodBeat.o(212089);
                            }
                        });
                        break;
                    case 2005:
                        final String string4 = bundle.getString("webview_jssdk_file_item_local_id");
                        final int i6 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass15 */

                            public final void run() {
                                AppMethodBeat.i(212090);
                                if (k.this.JpW != null) {
                                    k.this.JpW.gm(string4, i6);
                                }
                                AppMethodBeat.o(212090);
                            }
                        });
                        break;
                    case 2006:
                        final String string5 = bundle.getString("webview_jssdk_file_item_local_id");
                        final int i7 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass16 */

                            public final void run() {
                                AppMethodBeat.i(212091);
                                if (k.this.JpW != null) {
                                    k.this.JpW.gn(string5, i7);
                                }
                                AppMethodBeat.o(212091);
                            }
                        });
                        break;
                    case 2008:
                        final HashMap hashMap2 = new HashMap();
                        hashMap2.put(ch.COL_LOCALID, bundle.getString(ch.COL_LOCALID));
                        hashMap2.put("err_msg", bundle.getString("recordResult"));
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(212078);
                                if (k.this.JpW != null) {
                                    k.this.JpW.bJ(hashMap2);
                                }
                                AppMethodBeat.o(212078);
                            }
                        });
                        break;
                    case 2010:
                        final String string6 = bundle.getString("webview_jssdk_file_item_local_id");
                        final int i8 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass17 */

                            public final void run() {
                                AppMethodBeat.i(212092);
                                if (k.this.JpW != null) {
                                    k.this.JpW.go(string6, i8);
                                }
                                AppMethodBeat.o(212092);
                            }
                        });
                        break;
                    case CdnLogic.kMediaTypeStoryAudio:
                        if (k.this.JpW != null) {
                            final String string7 = bundle.getString("err_msg");
                            k.this.mHandler.post(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass6 */

                                public final void run() {
                                    AppMethodBeat.i(212081);
                                    if (k.this.JpW != null) {
                                        k.this.JpW.aYg(string7);
                                    }
                                    AppMethodBeat.o(212081);
                                }
                            });
                            break;
                        }
                        break;
                    case 40002:
                        final String string8 = bundle.getString("uuid");
                        final int i9 = bundle.getInt("major");
                        final int i10 = bundle.getInt("minor");
                        final double d2 = bundle.getDouble("accuracy");
                        final double d3 = bundle.getDouble("rssi");
                        final float f3 = bundle.getFloat("heading");
                        if (k.this.JpW != null) {
                            final String string9 = bundle.getString("err_msg");
                            k.this.mHandler.post(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass7 */

                                public final void run() {
                                    AppMethodBeat.i(212082);
                                    if (k.this.JpW != null) {
                                        k.this.JpW.aYg(string9);
                                        k.this.JpW.a(string8, i9, i10, d2, d3, f3);
                                    }
                                    AppMethodBeat.o(212082);
                                }
                            });
                            break;
                        }
                        break;
                    default:
                        Log.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                        break;
                }
                git().f(i2, bundle);
                AppMethodBeat.o(212096);
                return true;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final boolean a(com.tencent.mm.plugin.webview.stub.d dVar) {
                AppMethodBeat.i(212097);
                if (k.this.iGY == null) {
                    AppMethodBeat.o(212097);
                    return true;
                }
                Log.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + k.this.iGY.hashCode());
                final int type = dVar.getType();
                final int errType = dVar.getErrType();
                final int errCode = dVar.getErrCode();
                final String errMsg = dVar.getErrMsg();
                final Bundle data = dVar.getData();
                k.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(212083);
                        try {
                            k.a(k.this, type, errType, errCode, data != null ? data : new Bundle());
                            AppMethodBeat.o(212083);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.MMWebViewClient", e2.getMessage());
                            AppMethodBeat.o(212083);
                        }
                    }
                });
                boolean a2 = git().a(dVar);
                AppMethodBeat.o(212097);
                return a2;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final boolean a(final String str, final String str2, final Bundle bundle, final boolean z) {
                AppMethodBeat.i(212098);
                if (k.this.JpW == null) {
                    AppMethodBeat.o(212098);
                } else {
                    k.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass6.AnonymousClass9 */

                        public final void run() {
                            AppMethodBeat.i(212084);
                            k.this.JpW.a(str, str2, n.aN(bundle), z);
                            AppMethodBeat.o(212084);
                        }
                    });
                    git().a(str, str2, bundle, z);
                    AppMethodBeat.o(212098);
                }
                return false;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final String fWW() {
                return k.this.JyF;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final String getCurrentUrl() {
                AppMethodBeat.i(212099);
                String c2 = k.c(k.this);
                AppMethodBeat.o(212099);
                return c2;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final String fWX() {
                AppMethodBeat.i(212100);
                String fWX = git().fWX();
                AppMethodBeat.o(212100);
                return fWX;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void yL(boolean z) {
                AppMethodBeat.i(212101);
                git().yL(z);
                AppMethodBeat.o(212101);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void yM(boolean z) {
                AppMethodBeat.i(212102);
                git().yM(z);
                AppMethodBeat.o(212102);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void t(int i2, Bundle bundle) {
                AppMethodBeat.i(212103);
                git().t(i2, bundle);
                AppMethodBeat.o(212103);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void fWV() {
                AppMethodBeat.i(212104);
                if (k.this.JpW != null) {
                    k.this.JpW.fWV();
                }
                AppMethodBeat.o(212104);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void aM(Bundle bundle) {
                AppMethodBeat.i(212105);
                git().aM(bundle);
                AppMethodBeat.o(212105);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void aWP(String str) {
                AppMethodBeat.i(212106);
                git().aWP(str);
                AppMethodBeat.o(212106);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void lz(String str, String str2) {
                AppMethodBeat.i(212107);
                git().lz(str, str2);
                AppMethodBeat.o(212107);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void fWZ() {
                AppMethodBeat.i(212108);
                if (k.this.JpW != null) {
                    k.this.JpW.fWZ();
                }
                AppMethodBeat.o(212108);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void e(String str, String str2, int i2, int i3) {
                AppMethodBeat.i(212109);
                git().e(str, str2, i2, i3);
                AppMethodBeat.o(212109);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final Bundle j(int i2, Bundle bundle) {
                AppMethodBeat.i(212110);
                Bundle j2 = git().j(i2, bundle);
                AppMethodBeat.o(212110);
                return j2;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void aL(Bundle bundle) {
                AppMethodBeat.i(212111);
                git().aL(bundle);
                AppMethodBeat.o(212111);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void yN(boolean z) {
                AppMethodBeat.i(212112);
                git().yN(z);
                AppMethodBeat.o(212112);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final void lA(String str, String str2) {
                AppMethodBeat.i(212113);
                git().lA(str, str2);
                AppMethodBeat.o(212113);
            }

            @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
            public final Bundle fl(String str, String str2) {
                AppMethodBeat.i(212114);
                Bundle fl = git().fl(str, str2);
                AppMethodBeat.o(212114);
                return fl;
            }
        };
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(mMWebView.getContext());
        if (mMWebView.getContext() instanceof MutableContextWrapper) {
            this.ctH = (MutableContextWrapper) mMWebView.getContext();
        } else {
            this.ctH = new MutableContextWrapper(mMWebView.getContext());
            if (castActivityOrNull != null) {
                this.ctH.setBaseContext(castActivityOrNull);
            }
        }
        this.iGY = mMWebView;
        this.mHandler = new MMHandler();
        this.IRi = new g(new g.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.f.g.b
            public final String fZK() {
                AppMethodBeat.i(212071);
                String url = k.this.iGY.getUrl();
                AppMethodBeat.o(212071);
                return url;
            }

            @Override // com.tencent.mm.plugin.webview.f.g.b
            public final String fZL() {
                AppMethodBeat.i(212072);
                String url = k.this.iGY.getUrl();
                AppMethodBeat.o(212072);
                return url;
            }
        });
        g gVar = this.IRi;
        if (castActivityOrNull == null) {
            parcelableExtra = null;
        } else {
            parcelableExtra = castActivityOrNull.getIntent().getParcelableExtra("hardcode_jspermission");
        }
        gVar.a((JsapiPermissionWrapper) parcelableExtra, (GeneralControlWrapper) (castActivityOrNull != null ? castActivityOrNull.getIntent().getParcelableExtra("hardcode_general_ctrl") : parcelable));
        this.Jyz = z;
        this.Jyy = bundle;
        this.JyE = new ar(this.ctH);
        Log.i("MicroMsg.MMWebViewClient", "MMWebViewClient init, webview: %d, resourceInterrupter: %d", Integer.valueOf(this.iGY.hashCode()), Integer.valueOf(this.JyE.hashCode()));
        AppMethodBeat.o(82199);
    }

    /* access modifiers changed from: protected */
    public void baH(String str) {
    }

    public void a(e eVar, g gVar) {
    }

    /* access modifiers changed from: protected */
    public m bLB() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int bLC() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int bLD() {
        return 5;
    }

    /* access modifiers changed from: protected */
    public String abH(String str) {
        return "";
    }

    /* access modifiers changed from: protected */
    public String getSource() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) {
    }

    /* access modifiers changed from: protected */
    public void b(com.tencent.mm.plugin.webview.d.k kVar) {
    }

    /* access modifiers changed from: protected */
    public void f(Bundle bundle, String str) {
    }

    /* access modifiers changed from: protected */
    public boolean baF(String str) {
        if (this.iGY != null) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean Lb(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(WebView webView, String str, boolean z) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(WebView webView, String str, Bitmap bitmap) {
    }

    /* access modifiers changed from: protected */
    public void f(WebView webView, String str) {
    }

    /* access modifiers changed from: protected */
    public void ghd() {
    }

    /* access modifiers changed from: protected */
    public final boolean bbm(String str) {
        AppMethodBeat.i(82200);
        for (com.tencent.mm.plugin.webview.d.d.a aVar : this.JyI) {
            if (aVar.aXK(str)) {
                Log.i("MicroMsg.MMWebViewClient", "url handled, ret = " + aVar.aXJ(str) + ", url = " + str);
                AppMethodBeat.o(82200);
                return true;
            }
        }
        boolean Lb = Lb(str);
        AppMethodBeat.o(82200);
        return Lb;
    }

    /* access modifiers changed from: protected */
    public boolean abG(String str) {
        AppMethodBeat.i(82201);
        boolean aYH = al.aYH(str);
        AppMethodBeat.o(82201);
        return aYH;
    }

    @Override // com.tencent.xweb.ac
    public final boolean a(WebView webView, final String str) {
        AppMethodBeat.i(82202);
        Log.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = ".concat(String.valueOf(str)));
        if (this.JpV == null) {
            Log.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            AppMethodBeat.o(82202);
            return true;
        } else if (!abG(str)) {
            Log.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = ".concat(String.valueOf(str)));
            baH(str);
            AppMethodBeat.o(82202);
            return true;
        } else if (str.equals(this.JyH)) {
            this.JyH = "";
            AppMethodBeat.o(82202);
            return true;
        } else if (DownloadChecker.a(str, getSource(), webView)) {
            Log.i("MicroMsg.MMWebViewClient", "use the downloader to download");
            AppMethodBeat.o(82202);
            return true;
        } else {
            boolean bbm = bbm(str);
            if (!bbm && str.startsWith("weixin://")) {
                Log.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                AppMethodBeat.o(82202);
                return true;
            } else if (bbm) {
                AppMethodBeat.o(82202);
                return true;
            } else {
                int cO = this.JyD.cO(str, this.JyP);
                if ((cO == 0 || cO == 2) && !this.Jyz) {
                    Log.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = ".concat(String.valueOf(cO)));
                    boolean z = cO == 2 || (!str.equals(this.JyA) && !this.IRi.aZK(str));
                    if (baF(str)) {
                        this.iGY.stopLoading();
                        this.iGY.post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(82131);
                                k.this.azM(str);
                                AppMethodBeat.o(82131);
                            }
                        });
                    } else if (z) {
                        this.iGY.stopLoading();
                    }
                    if (!z) {
                        Log.w("MicroMsg.MMWebViewClient", "shouldOverride, not trigger getA8key, nowURL[%s] newURL[%s] lastGetA8KeyUrl[%s] reason[%d]", webView.getUrl(), str, this.JyA, Integer.valueOf(cO));
                        AppMethodBeat.o(82202);
                        return false;
                    }
                    av(str, true);
                    AppMethodBeat.o(82202);
                    return true;
                }
                AppMethodBeat.o(82202);
                return false;
            }
        }
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str, boolean z) {
        AppMethodBeat.i(82203);
        Log.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
        super.b(webView, str, z);
        if (a(webView, str, z)) {
            AppMethodBeat.o(82203);
            return;
        }
        String url = webView.getUrl();
        if (this.Jyz) {
            av(url, false);
        }
        if (this.IRi != null && !this.IRi.has(url)) {
            Log.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", url);
            av(url, false);
        }
        AppMethodBeat.o(82203);
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(82204);
        Log.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", str);
        if (this.JpV == null || this.JyL) {
            this.JyL = false;
            AppMethodBeat.o(82204);
        } else if (!abG(str)) {
            Log.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            baH(str);
            AppMethodBeat.o(82204);
        } else if (bbm(str)) {
            this.JyH = str;
            AppMethodBeat.o(82204);
        } else {
            this.JyG = str;
            super.b(webView, str, bitmap);
            com.tencent.mm.plugin.webview.d.k kVar = this.Jqa;
            Log.v("MicroMsg.JsLoader", "onPageStarted");
            if (kVar.IBw != null) {
                kVar.IBw.yV(false);
            }
            if (baF(str)) {
                this.iGY.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.JpW != null) {
                    this.JpW.M(this.JyJ.get(str), this.JyK.get(str));
                }
            }
            av(str, false);
            a(webView, str, bitmap);
            AppMethodBeat.o(82204);
        }
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str) {
        Activity castActivityOrNull;
        boolean z = true;
        AppMethodBeat.i(82205);
        Log.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", str);
        if (this.JpV != null) {
            if (webView != null && ((castActivityOrNull = AndroidContextUtil.castActivityOrNull(webView.getContext())) == null || !castActivityOrNull.isFinishing())) {
                z = false;
            }
            if (!z) {
                super.b(webView, str);
                if (!abG(str)) {
                    Log.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(str)));
                    baH(str);
                    AppMethodBeat.o(82205);
                    return;
                }
                this.JyH = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    Log.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                    f(webView, str);
                    AppMethodBeat.o(82205);
                    return;
                }
                this.mHandler.postDelayed(this.JyQ, 1000);
                f(webView, str);
                AppMethodBeat.o(82205);
                return;
            }
        }
        AppMethodBeat.o(82205);
    }

    @Override // com.tencent.xweb.ac
    public void a(WebView webView, r rVar, SslError sslError) {
        AppMethodBeat.i(82206);
        super.a(webView, rVar, sslError);
        AppMethodBeat.o(82206);
    }

    @Override // com.tencent.xweb.ac
    public void a(WebView webView, int i2, String str, String str2) {
        AppMethodBeat.i(82207);
        super.a(webView, i2, str, str2);
        AppMethodBeat.o(82207);
    }

    @Override // com.tencent.xweb.ac
    public final void h(WebView webView, String str) {
        AppMethodBeat.i(82208);
        Log.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = ".concat(String.valueOf(str)));
        super.h(webView, str);
        AppMethodBeat.o(82208);
    }

    @Override // com.tencent.xweb.ac
    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(82209);
        if (webResourceRequest == null || webResourceRequest.getUrl() == null || Util.isNullOrNil(webResourceRequest.getUrl().toString())) {
            WebResourceResponse a2 = super.a(webView, webResourceRequest);
            AppMethodBeat.o(82209);
            return a2;
        }
        Log.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame()));
        WebResourceResponse a3 = this.JyE.a(null, webResourceRequest, false, this.JpV);
        AppMethodBeat.o(82209);
        return a3;
    }

    @Override // com.tencent.xweb.ac
    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(82210);
        if (webResourceRequest == null || webResourceRequest.getUrl() == null || Util.isNullOrNil(webResourceRequest.getUrl().toString())) {
            WebResourceResponse a2 = super.a(webView, webResourceRequest, bundle);
            AppMethodBeat.o(82210);
            return a2;
        }
        Log.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame()));
        if (com.tencent.mm.cr.d.kS(this.iGY.getContext())) {
            try {
                int i2 = bundle.getInt("resourceType");
                if (i2 == 1 || i2 == 7) {
                    Log.i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i2));
                    m(webResourceRequest.getUrl().toString(), false, bLD());
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", e2.getMessage());
            } catch (Throwable th) {
                Log.w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", th.getMessage());
            }
        }
        WebResourceResponse a3 = this.JyE.a(null, webResourceRequest, true, this.JpV);
        AppMethodBeat.o(82210);
        return a3;
    }

    @Override // com.tencent.xweb.ac
    public final void a(WebView webView, j jVar, String str, String str2) {
        AppMethodBeat.i(212116);
        super.a(webView, jVar, str, str2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(155, 35, 1);
        AppMethodBeat.o(212116);
    }

    public void cleanup() {
        AppMethodBeat.i(82211);
        this.mHandler.removeCallbacks(this.JyQ);
        try {
            this.JpV.agy(this.iGY.hashCode());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMWebViewClient", e2, "", new Object[0]);
        }
        if (this.JyR != null) {
            try {
                this.ctH.unbindService(this.JyR);
            } catch (Exception e3) {
                Log.e("MicroMsg.MMWebViewClient", e3.getMessage());
            }
        }
        if (this.JpW != null) {
            this.JpW.detach();
        }
        if (this.Jqa != null) {
            this.Jqa.detach();
        }
        gis();
        this.JyS = null;
        ghd();
        AppMethodBeat.o(82211);
    }

    public final void giq() {
        int i2;
        AppMethodBeat.i(82212);
        this.JpW = new h(this.iGY, this.IRi, this.iGY.hashCode());
        this.JpW.mHh = this.JpV;
        Log.i("MicroMsg.MMWebViewClient", "initJsApi， webview: %d, jsapi: %d", Integer.valueOf(this.iGY.hashCode()), Integer.valueOf(this.JpW.hashCode()));
        this.JpW.dVU = null;
        this.iGY.addJavascriptInterface(this.JpW, "__wx");
        if (this.JpW.gbi() != null) {
            this.iGY.addJavascriptInterface(this.JpW.gbi(), "__wxtag");
        }
        this.JyI.add(this.JpW);
        this.Jqa = new com.tencent.mm.plugin.webview.d.k(this.iGY, this.JpW, new k.a() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.webview.d.k.a
            public final void gbn() {
                AppMethodBeat.i(212074);
                k.this.a(k.this.JpW);
                AppMethodBeat.o(212074);
            }
        });
        b(this.Jqa);
        try {
            i2 = Util.getInt(this.JpV.aZV("WebviewDisableDigestVerify"), 0);
        } catch (Exception e2) {
            Log.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e2.getMessage());
            i2 = 0;
        }
        Log.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", Integer.valueOf(i2));
        if (i2 == 0 && this.ctH.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.JpW.gaT();
        }
        AppMethodBeat.o(82212);
    }

    /* access modifiers changed from: protected */
    public void ghe() {
        AppMethodBeat.i(82213);
        if (TextUtils.isEmpty(this.JyF)) {
            AppMethodBeat.o(82213);
        } else if (l.C(this.JyF, "weixin://")) {
            Log.w("MicroMsg.MMWebViewClient", "loadInitialUrl can not deal with this weixin scheme, stop directly, url = %s", this.JyF);
            AppMethodBeat.o(82213);
        } else if (bbm(this.JyF)) {
            AppMethodBeat.o(82213);
        } else {
            Uri parse = Uri.parse(this.JyF);
            if (parse.getScheme() == null) {
                this.JyF += HttpWrapperBase.PROTOCAL_HTTP;
                parse = Uri.parse(this.JyF);
            }
            if (parse.getScheme().startsWith("http")) {
                Log.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.JyD = new a(this.JyF);
                if (this.Jyz || this.IRi.has(this.JyF)) {
                    this.iGY.loadUrl(this.JyF);
                    AppMethodBeat.o(82213);
                    return;
                }
                av(this.JyF, false);
                AppMethodBeat.o(82213);
            } else if (!abG(this.JyF)) {
                baH(this.JyF);
                AppMethodBeat.o(82213);
            } else {
                this.iGY.loadUrl(this.JyF);
                AppMethodBeat.o(82213);
            }
        }
    }

    private void gir() {
        AppMethodBeat.i(82214);
        Log.i("MicroMsg.MMWebViewClient", "tryBindService");
        this.ctH.bindService(new Intent(this.ctH, WebViewStubService.class), this.JyR, 1);
        AppMethodBeat.o(82214);
    }

    /* access modifiers changed from: protected */
    public boolean baG(String str) {
        AppMethodBeat.i(82215);
        if (this.JpV == null) {
            this.JyF = str;
            gir();
            AppMethodBeat.o(82215);
            return true;
        }
        AppMethodBeat.o(82215);
        return false;
    }

    public class c implements ServiceConnection {
        protected c() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(82176);
            Log.i("MicroMsg.MMWebViewClient", "onServiceConnected");
            if (k.this.iGY == null) {
                Log.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
                AppMethodBeat.o(82176);
                return;
            }
            try {
                k.this.JpV = e.a.H(iBinder);
                k.this.JpV.a(new d(new WeakReference(k.this.JyS)), k.this.iGY.hashCode());
                if (k.this.Jyy != null) {
                    k.this.JpV.b(k.this.Jyy, k.this.iGY.hashCode());
                }
                k.this.giq();
                k.this.ghe();
                k.this.a(k.this.JpV, k.this.IRi);
                AppMethodBeat.o(82176);
            } catch (Exception e2) {
                Log.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", e2.getMessage());
                AppMethodBeat.o(82176);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(82177);
            Log.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
            if (!k.this.iGY.mDestroyed) {
                Log.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
                k.a(k.this);
                AppMethodBeat.o(82177);
                return;
            }
            k.this.JpV = null;
            AppMethodBeat.o(82177);
        }
    }

    public static class a {
        private static final Pattern lnT = Pattern.compile(".*#.*wechat_redirect");
        private String ISo = null;

        static {
            AppMethodBeat.i(82174);
            AppMethodBeat.o(82174);
        }

        public a(String str) {
            this.ISo = str;
        }

        public final int cO(String str, boolean z) {
            AppMethodBeat.i(212115);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
                AppMethodBeat.o(212115);
                return 0;
            } else if (str.equals(this.ISo) && z) {
                AppMethodBeat.o(212115);
                return 0;
            } else if (lnT.matcher(str).find()) {
                AppMethodBeat.o(212115);
                return 2;
            } else {
                AppMethodBeat.o(212115);
                return 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void azM(String str) {
        AppMethodBeat.i(82216);
        HashMap hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.iGY.loadUrl(str, hashMap);
        AppMethodBeat.o(82216);
    }

    public void av(String str, boolean z) {
        AppMethodBeat.i(82217);
        m(str, z, bLC());
        AppMethodBeat.o(82217);
    }

    private void m(String str, boolean z, int i2) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(82218);
        if (this.iGY.mDestroyed) {
            AppMethodBeat.o(82218);
        } else if (this.IRi == null) {
            Log.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            AppMethodBeat.o(82218);
        } else if (this.Jyz) {
            Log.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
            this.IRi.a(str, null, null);
            AppMethodBeat.o(82218);
        } else {
            Integer valueOf = Integer.valueOf(this.JyD.cO(str, this.JyP));
            if (this.JpV == null || !valueOf.equals(this.JyB.get(str))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if ((this.IRi.has(str) || z2) && !z) {
                Log.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = ".concat(String.valueOf(str)));
                AppMethodBeat.o(82218);
                return;
            }
            Log.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = " + i2 + ", username = " + "" + ", reason = " + valueOf + ", force = " + z);
            Log.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
            this.JyB.put(str, valueOf);
            this.IRi.a(str, null, null);
            this.JyM = true;
            this.JyC.giu();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", "");
            bundle.putInt("geta8key_data_scene", i2);
            bundle.putInt("geta8key_data_reason", valueOf.intValue());
            if (this.iGY.getIsX5Kernel()) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", 0);
            }
            bundle.putString("geta8key_data_net_type", z.gcX());
            bundle.putInt("webview_binder_id", this.iGY.hashCode());
            bundle.putString("geta8key_outer_url", abH(str));
            this.JyA = str;
            f(bundle, str);
            this.JyP = false;
            try {
                z3 = this.JpV.x(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, bundle);
            } catch (Exception e2) {
                Log.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e2.getMessage());
            }
            Log.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = ".concat(String.valueOf(z3)));
            AppMethodBeat.o(82218);
        }
    }

    private void gis() {
        AppMethodBeat.i(82219);
        try {
            if (this.JpV != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
                bundle.putInt("scene_end_listener_hash_code", this.iGY.hashCode());
                this.JpV.a(6, bundle, this.iGY.hashCode());
            }
            AppMethodBeat.o(82219);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e2.getMessage());
            AppMethodBeat.o(82219);
        }
    }

    public final void zv(boolean z) {
        this.JyL = z;
    }

    /* access modifiers changed from: protected */
    public class b {
        int JyW = 0;

        protected b() {
        }

        public final void giu() {
            AppMethodBeat.i(82175);
            if (this.JyW == 0) {
                k.b(k.this);
            }
            this.JyW++;
            AppMethodBeat.o(82175);
        }
    }

    private void T(String str, Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(82220);
        String nullAs = Util.nullAs(fZM(), this.JyF);
        if (Util.isNullOrNil(nullAs)) {
            Log.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.iGY.loadUrl(str);
            AppMethodBeat.o(82220);
        } else if (this.JpW == null) {
            if (map.size() > 0) {
                this.iGY.loadUrl(str, map);
                AppMethodBeat.o(82220);
                return;
            }
            this.iGY.loadUrl(str);
            AppMethodBeat.o(82220);
        } else if (!Util.nullAsNil(str).contains("#wechat_redirect")) {
            if (!ml(nullAs, str)) {
                String byD = com.tencent.mm.plugin.webview.e.b.byD(nullAs);
                String byD2 = com.tencent.mm.plugin.webview.e.b.byD(str);
                if (Util.isNullOrNil(byD2) || Util.isNullOrNil(byD) || !byD2.equals(byD) || this.JpV == null || !baF(nullAs)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    if (map.size() > 0) {
                        this.iGY.loadUrl(str, map);
                        AppMethodBeat.o(82220);
                        return;
                    }
                    this.iGY.loadUrl(str);
                    AppMethodBeat.o(82220);
                    return;
                }
            }
            this.JyJ.put(nullAs, str);
            this.JyK.put(nullAs, map);
            this.JpW.M(str, map);
            AppMethodBeat.o(82220);
        } else if (map.size() > 0) {
            this.iGY.loadUrl(str, map);
            AppMethodBeat.o(82220);
        } else {
            this.iGY.loadUrl(str);
            AppMethodBeat.o(82220);
        }
    }

    private boolean ml(String str, String str2) {
        AppMethodBeat.i(82221);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(82221);
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.IJn.matcher(str).matches() && com.tencent.mm.plugin.webview.a.IJn.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst(HttpWrapperBase.PROTOCAL_HTTP, "").replaceFirst(HttpWrapperBase.PROTOCAL_HTTPS, "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst(HttpWrapperBase.PROTOCAL_HTTP, "").replaceFirst(HttpWrapperBase.PROTOCAL_HTTPS, "").startsWith(replaceFirst) && this.JpV != null && baF(str)) {
                AppMethodBeat.o(82221);
                return true;
            }
        }
        AppMethodBeat.o(82221);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean bk(Bundle bundle) {
        AppMethodBeat.i(82222);
        Log.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i2 = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        Log.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i2 + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        HashMap hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i3 = 0; i3 < stringArray.length; i3++) {
                hashMap.put(stringArray[i3], stringArray2[i3]);
            }
        }
        this.JyO = hashMap;
        switch (i2) {
            case 1:
                Log.i("MicroMsg.MMWebViewClient", "getA8key-text: ".concat(String.valueOf(string3)));
                if (string3 == null || string3.length() == 0) {
                    Log.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    AppMethodBeat.o(82222);
                    return false;
                }
                this.iGY.getSettings().setJavaScriptEnabled(false);
                this.iGY.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                AppMethodBeat.o(82222);
                return true;
            case 2:
            case 7:
                Log.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    Log.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    AppMethodBeat.o(82222);
                    return false;
                } else if (!abG(string2)) {
                    Log.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    baH(string2);
                    AppMethodBeat.o(82222);
                    return true;
                } else {
                    T(string2, hashMap);
                    AppMethodBeat.o(82222);
                    return true;
                }
            case 3:
            case 4:
            case 5:
            default:
                Log.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = ".concat(String.valueOf(i2)));
                AppMethodBeat.o(82222);
                return false;
            case 6:
                Log.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = ".concat(String.valueOf(string2)));
                if (string2 == null || string2.length() == 0) {
                    Log.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    AppMethodBeat.o(82222);
                    return false;
                } else if (!abG(string2)) {
                    Log.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    baH(string2);
                    AppMethodBeat.o(82222);
                    return true;
                } else {
                    this.iGY.loadUrl(string2);
                    AppMethodBeat.o(82222);
                    return true;
                }
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.i(82223);
        if (!Util.isNullOrNil(str2)) {
            this.IRi.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.JyB.remove(str2);
            this.JyM = false;
            this.xwe = str2;
        }
        if (ml(str, str2)) {
            this.IRi.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.JyB.remove(str);
            AppMethodBeat.o(82223);
        } else if (this.JpV == null || Util.isNullOrNil(str) || !baF(str2)) {
            AppMethodBeat.o(82223);
        } else {
            this.IRi.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.JyB.remove(str);
            AppMethodBeat.o(82223);
        }
    }

    private String fZM() {
        AppMethodBeat.i(82224);
        if (!Util.isNullOrNil(this.JyG)) {
            String str = this.JyG;
            AppMethodBeat.o(82224);
            return str;
        } else if (this.mHandler == null) {
            AppMethodBeat.o(82224);
            return null;
        } else if (Thread.currentThread().getId() != this.mHandler.getLooper().getThread().getId()) {
            String str2 = (String) new SyncTask<String>("") {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.k.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final /* synthetic */ String run() {
                    AppMethodBeat.i(212075);
                    if (k.this.iGY == null) {
                        AppMethodBeat.o(212075);
                        return "";
                    }
                    String url = k.this.iGY.getUrl();
                    AppMethodBeat.o(212075);
                    return url;
                }
            }.exec(this.mHandler);
            AppMethodBeat.o(82224);
            return str2;
        } else if (this.iGY == null) {
            AppMethodBeat.o(82224);
            return "";
        } else {
            String url = this.iGY.getUrl();
            AppMethodBeat.o(82224);
            return url;
        }
    }

    protected static class d extends m {
        private WeakReference<m> nsR;

        public d(WeakReference<m> weakReference) {
            this.nsR = weakReference;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final boolean afl(int i2) {
            AppMethodBeat.i(82178);
            m mVar = this.nsR.get();
            if (mVar != null) {
                boolean afl = mVar.afl(i2);
                AppMethodBeat.o(82178);
                return afl;
            }
            AppMethodBeat.o(82178);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final boolean f(int i2, Bundle bundle) {
            AppMethodBeat.i(82179);
            m mVar = this.nsR.get();
            if (mVar != null) {
                boolean f2 = mVar.f(i2, bundle);
                AppMethodBeat.o(82179);
                return f2;
            }
            AppMethodBeat.o(82179);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final boolean a(com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(82180);
            m mVar = this.nsR.get();
            if (mVar != null) {
                boolean a2 = mVar.a(dVar);
                AppMethodBeat.o(82180);
                return a2;
            }
            AppMethodBeat.o(82180);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            AppMethodBeat.i(82181);
            m mVar = this.nsR.get();
            if (mVar != null) {
                boolean a2 = mVar.a(str, str2, bundle, z);
                AppMethodBeat.o(82181);
                return a2;
            }
            AppMethodBeat.o(82181);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final String fWW() {
            AppMethodBeat.i(82182);
            m mVar = this.nsR.get();
            if (mVar != null) {
                String fWW = mVar.fWW();
                AppMethodBeat.o(82182);
                return fWW;
            }
            AppMethodBeat.o(82182);
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final String getCurrentUrl() {
            AppMethodBeat.i(82183);
            m mVar = this.nsR.get();
            if (mVar != null) {
                String currentUrl = mVar.getCurrentUrl();
                AppMethodBeat.o(82183);
                return currentUrl;
            }
            AppMethodBeat.o(82183);
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final String fWX() {
            AppMethodBeat.i(82184);
            m mVar = this.nsR.get();
            if (mVar != null) {
                String fWX = mVar.fWX();
                AppMethodBeat.o(82184);
                return fWX;
            }
            AppMethodBeat.o(82184);
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void yL(boolean z) {
            AppMethodBeat.i(82185);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.yL(z);
            }
            AppMethodBeat.o(82185);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void yM(boolean z) {
            AppMethodBeat.i(82186);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.yM(z);
            }
            AppMethodBeat.o(82186);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void t(int i2, Bundle bundle) {
            AppMethodBeat.i(82187);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.t(i2, bundle);
            }
            AppMethodBeat.o(82187);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void fWV() {
            AppMethodBeat.i(82188);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.fWV();
            }
            AppMethodBeat.o(82188);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void aM(Bundle bundle) {
            AppMethodBeat.i(82189);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.aM(bundle);
            }
            AppMethodBeat.o(82189);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void aWP(String str) {
            AppMethodBeat.i(82190);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.aWP(str);
            }
            AppMethodBeat.o(82190);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void lz(String str, String str2) {
            AppMethodBeat.i(82191);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.lz(str, str2);
            }
            AppMethodBeat.o(82191);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void fWZ() {
            AppMethodBeat.i(82192);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.fWZ();
            }
            AppMethodBeat.o(82192);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void e(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(82193);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.e(str, str2, i2, i3);
            }
            AppMethodBeat.o(82193);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final Bundle j(int i2, Bundle bundle) {
            AppMethodBeat.i(82194);
            m mVar = this.nsR.get();
            if (mVar != null) {
                Bundle j2 = mVar.j(i2, bundle);
                AppMethodBeat.o(82194);
                return j2;
            }
            Bundle bundle2 = new Bundle();
            AppMethodBeat.o(82194);
            return bundle2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void aL(Bundle bundle) {
            AppMethodBeat.i(82195);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.aL(bundle);
            }
            AppMethodBeat.o(82195);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void yN(boolean z) {
            AppMethodBeat.i(82196);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.yN(z);
            }
            AppMethodBeat.o(82196);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void lA(String str, String str2) {
            AppMethodBeat.i(82197);
            m mVar = this.nsR.get();
            if (mVar != null) {
                mVar.lA(str, str2);
            }
            AppMethodBeat.o(82197);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final Bundle fl(String str, String str2) {
            AppMethodBeat.i(82198);
            m mVar = this.nsR.get();
            if (mVar != null) {
                Bundle fl = mVar.fl(str, str2);
                AppMethodBeat.o(82198);
                return fl;
            }
            AppMethodBeat.o(82198);
            return null;
        }
    }

    static /* synthetic */ void b(k kVar) {
        AppMethodBeat.i(212118);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
            bundle.putInt("scene_end_listener_hash_code", kVar.iGY.hashCode());
            kVar.JpV.a(5, bundle, kVar.iGY.hashCode());
            AppMethodBeat.o(212118);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e2.getMessage());
            AppMethodBeat.o(212118);
        }
    }

    static /* synthetic */ boolean a(k kVar, int i2, int i3, int i4, Bundle bundle) {
        AppMethodBeat.i(212119);
        if (!kVar.iGY.mDestroyed && kVar.IRi != null) {
            int i5 = bundle.getInt("scene_end_listener_hash_code");
            Log.i("MicroMsg.MMWebViewClient", "get hash code = %d, self hash code = %d", Integer.valueOf(i5), Integer.valueOf(kVar.iGY.hashCode()));
            Log.i("MicroMsg.MMWebViewClient", "edw onSceneEnd, type = " + i2 + ", errCode = " + i4 + ", errType = " + i3);
            if (i5 == kVar.iGY.hashCode()) {
                switch (i2) {
                    case TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS /*{ENCODED_INT: 233}*/:
                        b bVar = kVar.JyC;
                        bVar.JyW--;
                        if (bVar.JyW <= 0) {
                            k.this.gis();
                        }
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1"));
                        int i6 = bundle.getInt("geta8key_result_reason");
                        Log.i("MicroMsg.MMWebViewClient", "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(i6)));
                        switch (i6) {
                            case 0:
                            case 2:
                                if ((i3 == 0 && i4 == 0) || (i3 == 4 && i4 == -2005)) {
                                    kVar.a(bundle.getString("geta8key_result_req_url"), bundle.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                    kVar.bk(bundle);
                                    break;
                                }
                            case 1:
                            case 5:
                                if (i3 != 0 || i4 != 0) {
                                    if (i3 != 4 || i4 != -2005) {
                                        if (i3 != 0 && i4 == -3300) {
                                            kVar.JyN = true;
                                            break;
                                        }
                                    } else {
                                        kVar.iGY.stopLoading();
                                        kVar.a(bundle.getString("geta8key_result_req_url"), bundle.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                        kVar.bk(bundle);
                                        break;
                                    }
                                } else {
                                    String string = bundle.getString("geta8key_result_req_url");
                                    kVar.IRi.a(string, jsapiPermissionWrapper, generalControlWrapper);
                                    kVar.JyB.remove(string);
                                    break;
                                }
                        }
                        break;
                }
            } else {
                Log.e("MicroMsg.MMWebViewClient", "hash code not equal");
            }
        } else {
            Log.w("MicroMsg.MMWebViewClient", "onSceneEnd, isFinishing, do nothing");
        }
        AppMethodBeat.o(212119);
        return true;
    }
}
