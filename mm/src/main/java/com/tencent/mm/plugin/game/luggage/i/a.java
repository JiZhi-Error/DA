package com.tencent.mm.plugin.game.luggage.i;

import android.webkit.ValueCallback;
import com.tencent.luggage.d.f;
import com.tencent.luggage.d.o;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends o {
    private static LinkedList<a> xzm = new LinkedList<>();
    public MTimerHandler cve;
    public f xzn = new f(this.xzo);
    public f xzo = ((f) this.ctG);
    public EnumC1399a xzp = EnumC1399a.none;

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(187004);
        aVar.azR(str);
        AppMethodBeat.o(187004);
    }

    static {
        AppMethodBeat.i(187006);
        AppMethodBeat.o(187006);
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.i.a$a  reason: collision with other inner class name */
    public enum EnumC1399a {
        none,
        initing,
        inited,
        failed,
        stopped,
        destroyed;

        public static EnumC1399a valueOf(String str) {
            AppMethodBeat.i(186995);
            EnumC1399a aVar = (EnumC1399a) Enum.valueOf(EnumC1399a.class, str);
            AppMethodBeat.o(186995);
            return aVar;
        }

        static {
            AppMethodBeat.i(186996);
            AppMethodBeat.o(186996);
        }
    }

    public static a dTW() {
        AppMethodBeat.i(186997);
        a peek = xzm.peek();
        AppMethodBeat.o(186997);
        return peek;
    }

    public static synchronized void create() {
        synchronized (a.class) {
            AppMethodBeat.i(186998);
            a peek = xzm.peek();
            if (peek == null || peek.xzp == EnumC1399a.destroyed) {
                Log.i("MicroMsg.GameJsCore", "create new");
                xzm.addFirst(new a());
                AppMethodBeat.o(186998);
            } else {
                if (peek.xzp == EnumC1399a.stopped) {
                    peek.xzp = EnumC1399a.inited;
                    peek.azS("onResume");
                }
                AppMethodBeat.o(186998);
            }
        }
    }

    private a() {
        super(MMApplicationContext.getContext(), e.class);
        AppMethodBeat.i(186999);
        this.xzo.a(b.dTr(), this);
        b.a(new b.a() {
            /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wepkg.b.a
            public final void azT(String str) {
                AppMethodBeat.i(186987);
                b.destroy();
                if (Util.isNullOrNil(str)) {
                    str = d.afA("gamecenter_jscore.js");
                }
                a.this.xzo.evaluateJavascript(str, new ValueCallback<String>() {
                    /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(186986);
                        a.this.xzp = EnumC1399a.inited;
                        f fVar = a.this.xzn;
                        Log.i("MicroMsg.Page2JsCoreMsgDispatch", "ready");
                        if (!fVar.xzH) {
                            fVar.xzG = true;
                            Log.i("MicroMsg.Page2JsCoreMsgDispatch", "flush");
                            Iterator<com.tencent.luggage.d.d> it = fVar.xzI.iterator();
                            while (it.hasNext()) {
                                com.tencent.luggage.d.d next = it.next();
                                Log.i("MicroMsg.Page2JsCoreMsgDispatch", "flush event name: %s, data: %s", next.name(), next.Ld());
                                fVar.xzo.a(next);
                            }
                            fVar.xzI.clear();
                            Iterator<g> it2 = fVar.xzJ.iterator();
                            while (it2.hasNext()) {
                                g next2 = it2.next();
                                fVar.xzo.evaluateJavascript(String.format("WxGameJsCoreBridge.invokeEvent(%s,\"%s\")", next2.pageId, next2.lnV.toString()), null);
                            }
                            fVar.xzJ.clear();
                        }
                        a.a(a.this, "inited");
                        AppMethodBeat.o(186986);
                    }
                });
                AppMethodBeat.o(186987);
            }
        });
        azR("initing");
        Log.i("MicroMsg.GameJsCore", "JS CORE CREATE");
        AppMethodBeat.o(186999);
    }

    private void azR(String str) {
        AppMethodBeat.i(187000);
        Iterator<s> it = j.gbV().iterator();
        while (it.hasNext()) {
            s next = it.next();
            next.ctS.a(new com.tencent.luggage.d.d() {
                /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass2 */

                @Override // com.tencent.luggage.d.d
                public final String name() {
                    return "onJsCoreReady";
                }

                @Override // com.tencent.luggage.d.d
                public final JSONObject Ld() {
                    return null;
                }
            });
            next.ctS.cT(String.format("window.__jscore_state__='%s';", str));
        }
        AppMethodBeat.o(187000);
    }

    @Override // com.tencent.luggage.d.o
    public final void init() {
        this.xzp = EnumC1399a.initing;
    }

    public final synchronized void dTX() {
        AppMethodBeat.i(187001);
        Log.i("MicroMsg.GameJsCore", "destroyDirectly");
        if (this.xzp != EnumC1399a.destroyed) {
            AppMethodBeat.o(187001);
        } else {
            if (this.cve != null && !this.cve.stopped()) {
                this.cve.stopTimer();
            }
            f fVar = this.xzn;
            fVar.xzH = true;
            fVar.xzI.clear();
            fVar.xzJ.clear();
            this.xzo.destroy();
            xzm.remove(this);
            AppMethodBeat.o(187001);
        }
    }

    public final void azS(final String str) {
        AppMethodBeat.i(187002);
        this.xzn.b(new com.tencent.luggage.d.d() {
            /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass5 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "onJsCoreLifeChange";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                AppMethodBeat.i(186990);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", str);
                } catch (JSONException e2) {
                }
                AppMethodBeat.o(186990);
                return jSONObject;
            }
        });
        AppMethodBeat.o(187002);
    }

    public final void ar(final String str, final String str2, final String str3) {
        AppMethodBeat.i(187003);
        Log.i("MicroMsg.GameJsCore", "onPageLifeChanged, state:[%s], pageId:[%s], url:[%s]", str, str2, str3);
        this.xzn.b(new com.tencent.luggage.d.d() {
            /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass6 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "onPageLifeChange";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                AppMethodBeat.i(186991);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", str);
                    if (str3 != null) {
                        jSONObject.put("url", str3);
                    }
                    jSONObject.put("pageId", str2);
                    AppMethodBeat.o(186991);
                    return jSONObject;
                } catch (JSONException e2) {
                    AppMethodBeat.o(186991);
                    return null;
                }
            }
        });
        AppMethodBeat.o(187003);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(187005);
        Log.i("MicroMsg.GameJsCore", "destroy");
        aVar.xzp = EnumC1399a.destroyed;
        aVar.azS("onDestroy");
        aVar.cve = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(186989);
                a.this.dTX();
                AppMethodBeat.o(186989);
                return false;
            }
        }, false);
        aVar.cve.startTimer(Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(187005);
    }
}
