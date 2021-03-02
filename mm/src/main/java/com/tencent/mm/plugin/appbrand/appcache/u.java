package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Locale;
import org.json.JSONObject;

public final class u extends StateMachine implements Runnable {
    private static final String kKT = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e29) + "/weapp/public/commlib/%d.wxapkg");
    private final int kKU;
    private final String kKV;
    private final State kKW = new State() {
        /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(44256);
            super.enter();
            Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
            String bwd = ay.bwd();
            if (Util.isNullOrNil(bwd)) {
                u.a(u.this, "!!MockLibInfo Path Error!!");
                AppMethodBeat.o(44256);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", u.this.kKU);
                o oVar = new o(bwd);
                oVar.delete();
                oVar.createNewFile();
                byte[] bytes = jSONObject.toString().getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                int f2 = s.f(aa.z(oVar.her()), bytes, bytes.length);
                if (f2 != 0) {
                    u.a(u.this, "MockLibInfo Write Error ".concat(String.valueOf(f2)));
                    AppMethodBeat.o(44256);
                    return;
                }
                u.a(u.this, u.this.kKX);
                AppMethodBeat.o(44256);
            } catch (Exception e2) {
                u.a(u.this, "MockLibInfo Write Exception " + e2.getMessage());
                AppMethodBeat.o(44256);
            }
        }
    };
    private final State kKX = new State() {
        /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(44259);
            super.enter();
            Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
            fch fch = new fch();
            fch.url = String.format(Locale.US, u.kKT, Integer.valueOf(u.this.kKU));
            fch.version = u.this.kKU;
            fch.md5 = u.this.kKV;
            fch.MKJ = 1;
            n.buL().a(fch, new PInt());
            bj.a(fch.url, fch.version, new bj.a() {
                /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass2.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                public final /* bridge */ /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                    AppMethodBeat.i(44258);
                    Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "MockLibInfo Download Result %s", aVar);
                    if (aVar != b.a.EnumC0543a.OK) {
                        u.a(u.this, "Download MockLibInfo Error: " + aVar.name());
                        AppMethodBeat.o(44258);
                        return;
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(44257);
                            u.b(u.this, u.this.kKY);
                            u.this.sendMessage(0);
                            AppMethodBeat.o(44257);
                        }
                    });
                    AppMethodBeat.o(44258);
                }
            });
            AppMethodBeat.o(44259);
        }
    };
    private final State kKY = new State() {
        /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(44262);
            super.enter();
            Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
            au.gH(true);
            g.aAg().hqi.a(1168, new i() {
                /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass3.AnonymousClass1 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(44261);
                    if (qVar != null && (qVar.getReqResp() instanceof d)) {
                        int i4 = u.this.kKU;
                        int i5 = ((fch) ((d) qVar.getReqResp()).iLL.iLR).version;
                        bj.a(aw.B("@LibraryAppId", i4, i5), new bj.a() {
                            /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                            public final /* bridge */ /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                            public final /* bridge */ /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                                AppMethodBeat.i(44260);
                                if (aVar == b.a.EnumC0543a.OK) {
                                    u.a(u.this, "公共库增量(maybe)更新成功，重启微信确认是否生效");
                                    AppMethodBeat.o(44260);
                                    return;
                                }
                                u.a(u.this, "公共库增量失败");
                                AppMethodBeat.o(44260);
                            }
                        });
                    }
                    g.aAg().hqi.b(1168, this);
                    AppMethodBeat.o(44261);
                }
            });
            AppMethodBeat.o(44262);
        }
    };

    static /* synthetic */ void a(u uVar, IState iState) {
        AppMethodBeat.i(44268);
        uVar.transitionTo(iState);
        AppMethodBeat.o(44268);
    }

    static /* synthetic */ void b(u uVar, IState iState) {
        AppMethodBeat.i(226352);
        uVar.transitionTo(iState);
        AppMethodBeat.o(226352);
    }

    static /* synthetic */ void e(u uVar) {
        AppMethodBeat.i(226353);
        uVar.quit();
        AppMethodBeat.o(226353);
    }

    static {
        AppMethodBeat.i(226354);
        AppMethodBeat.o(226354);
    }

    public u(int i2, String str) {
        super("LibIncrementalTestCase", Looper.getMainLooper());
        AppMethodBeat.i(44264);
        this.kKU = i2;
        this.kKV = str;
        AppMethodBeat.o(44264);
    }

    public final void run() {
        AppMethodBeat.i(44265);
        addState(this.kKW);
        addState(this.kKX);
        addState(this.kKY);
        setInitialState(this.kKW);
        start();
        AppMethodBeat.o(44265);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public final void onQuitting() {
        AppMethodBeat.i(44266);
        super.onQuitting();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
        AppMethodBeat.o(44266);
    }

    static /* synthetic */ void a(u uVar, final String str) {
        AppMethodBeat.i(44267);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appcache.u.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(44263);
                Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                u.e(u.this);
                AppMethodBeat.o(44263);
            }
        });
        AppMethodBeat.o(44267);
    }
}
