package com.tencent.mm.plugin.lite.jsapi;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum a {
    INSTANCE;
    
    private Map<String, C1460a> iGj = new ConcurrentHashMap();
    private byte[] yEg = new byte[0];

    public interface b {
        void a(C1460a aVar);

        void onError();
    }

    private a(String str) {
        AppMethodBeat.i(198826);
        AppMethodBeat.o(198826);
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(198825);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(198825);
        return aVar;
    }

    static {
        AppMethodBeat.i(198828);
        AppMethodBeat.o(198828);
    }

    /* renamed from: com.tencent.mm.plugin.lite.jsapi.a$a  reason: collision with other inner class name */
    public class C1460a {
        public Map<String, String> mHeaders = new HashMap();
        public String yEk;
        public Map<String, String> yEl = new HashMap();

        public C1460a() {
            AppMethodBeat.i(198823);
            AppMethodBeat.o(198823);
        }
    }

    public final void a(final String str, final b bVar) {
        String str2;
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(198827);
        int currentTimeMillis = (int) System.currentTimeMillis();
        d at = l.a.at(str, 0);
        bhi bhi = (bhi) at.iLK.iLR;
        bhi.OpCode = 2;
        bhi.LRx = new dqi().bhy(str);
        bhi.Scene = 0;
        bhi.UserName = "";
        bhi.KMd = 0;
        bhi.KHa = 0;
        ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
            if (activeNetworkInfo.getType() == 1) {
                str2 = "WIFI";
            } else if (activeNetworkInfo.getExtraInfo() != null) {
                str2 = activeNetworkInfo.getExtraInfo().toLowerCase();
            }
            bhi.pLm = str2;
            bhi.LRB = currentTimeMillis;
            bhi.LRC = "";
            bhi.LRD = 0;
            bhi.LRu = new dqi().bhy("");
            bhi.LRE = new SKBuiltinBuffer_t().setBuffer(this.yEg);
            Log.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(str)));
            IPCRunCgi.a(at, null, new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.lite.jsapi.a.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(198822);
                    Log.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (dVar.iLL.iLR instanceof bhj) {
                        bhj bhj = (bhj) dVar.iLL.iLR;
                        Log.i("LiteApp.LiteAppGetA8Key", "fullurl:" + bhj.LRH);
                        if (bhj.LRH == null) {
                            if (bVar != null) {
                                bVar.onError();
                            }
                            AppMethodBeat.o(198822);
                            return;
                        }
                        int indexOf = bhj.LRH.indexOf("?");
                        if (indexOf < 0 || indexOf + 1 >= bhj.LRH.length()) {
                            Log.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
                            if (bVar != null) {
                                bVar.onError();
                            }
                            AppMethodBeat.o(198822);
                            return;
                        }
                        String[] split = bhj.LRH.substring(indexOf + 1).split("&");
                        if (split == null) {
                            Log.e("LiteApp.LiteAppGetA8Key", "params invalid");
                            if (bVar != null) {
                                bVar.onError();
                            }
                            AppMethodBeat.o(198822);
                            return;
                        }
                        C1460a aVar = new C1460a();
                        for (String str2 : split) {
                            if (str2.startsWith("key") || str2.startsWith(OpenSDKTool4Assistant.EXTRA_UIN) || str2.startsWith("pass_ticket")) {
                                if (aVar.yEk == null) {
                                    aVar.yEk = str2;
                                } else {
                                    aVar.yEk += "&" + str2;
                                }
                                int indexOf2 = str2.indexOf(61);
                                if (indexOf2 >= 0) {
                                    aVar.yEl.put(str2.substring(0, indexOf2).trim(), str2.substring(indexOf2 + 1).trim());
                                }
                            }
                        }
                        Iterator<ccc> it = bhj.LRq.iterator();
                        while (it.hasNext()) {
                            ccc next = it.next();
                            aVar.mHeaders.put(next.xMX, next.Cyk);
                        }
                        a.this.iGj.put(str, aVar);
                        if (bVar != null) {
                            bVar.a(aVar);
                        }
                        AppMethodBeat.o(198822);
                        return;
                    }
                    Log.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
                    if (bVar != null) {
                        bVar.onError();
                    }
                    AppMethodBeat.o(198822);
                }
            });
            AppMethodBeat.o(198827);
        }
        str2 = "no";
        bhi.pLm = str2;
        bhi.LRB = currentTimeMillis;
        bhi.LRC = "";
        bhi.LRD = 0;
        bhi.LRu = new dqi().bhy("");
        bhi.LRE = new SKBuiltinBuffer_t().setBuffer(this.yEg);
        Log.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(str)));
        IPCRunCgi.a(at, null, new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.lite.jsapi.a.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(198822);
                Log.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", Integer.valueOf(i2), Integer.valueOf(i3));
                if (dVar.iLL.iLR instanceof bhj) {
                    bhj bhj = (bhj) dVar.iLL.iLR;
                    Log.i("LiteApp.LiteAppGetA8Key", "fullurl:" + bhj.LRH);
                    if (bhj.LRH == null) {
                        if (bVar != null) {
                            bVar.onError();
                        }
                        AppMethodBeat.o(198822);
                        return;
                    }
                    int indexOf = bhj.LRH.indexOf("?");
                    if (indexOf < 0 || indexOf + 1 >= bhj.LRH.length()) {
                        Log.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
                        if (bVar != null) {
                            bVar.onError();
                        }
                        AppMethodBeat.o(198822);
                        return;
                    }
                    String[] split = bhj.LRH.substring(indexOf + 1).split("&");
                    if (split == null) {
                        Log.e("LiteApp.LiteAppGetA8Key", "params invalid");
                        if (bVar != null) {
                            bVar.onError();
                        }
                        AppMethodBeat.o(198822);
                        return;
                    }
                    C1460a aVar = new C1460a();
                    for (String str2 : split) {
                        if (str2.startsWith("key") || str2.startsWith(OpenSDKTool4Assistant.EXTRA_UIN) || str2.startsWith("pass_ticket")) {
                            if (aVar.yEk == null) {
                                aVar.yEk = str2;
                            } else {
                                aVar.yEk += "&" + str2;
                            }
                            int indexOf2 = str2.indexOf(61);
                            if (indexOf2 >= 0) {
                                aVar.yEl.put(str2.substring(0, indexOf2).trim(), str2.substring(indexOf2 + 1).trim());
                            }
                        }
                    }
                    Iterator<ccc> it = bhj.LRq.iterator();
                    while (it.hasNext()) {
                        ccc next = it.next();
                        aVar.mHeaders.put(next.xMX, next.Cyk);
                    }
                    a.this.iGj.put(str, aVar);
                    if (bVar != null) {
                        bVar.a(aVar);
                    }
                    AppMethodBeat.o(198822);
                    return;
                }
                Log.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
                if (bVar != null) {
                    bVar.onError();
                }
                AppMethodBeat.o(198822);
            }
        });
        AppMethodBeat.o(198827);
    }
}
