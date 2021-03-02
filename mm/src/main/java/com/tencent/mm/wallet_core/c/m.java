package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aav;
import com.tencent.mm.g.a.aba;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.wallet_core.ui.f;
import org.json.JSONObject;

public final class m {
    boolean Mlw;
    a RtJ;
    f RtK;
    IListener<aav> RtL = new IListener<aav>() {
        /* class com.tencent.mm.wallet_core.c.m.AnonymousClass2 */

        {
            AppMethodBeat.i(160907);
            this.__eventId = aav.class.getName().hashCode();
            AppMethodBeat.o(160907);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aav aav) {
            AppMethodBeat.i(72760);
            Log.i("MicroMsg.JumpRemind", "WebViewUIDestroyEvent close");
            m.this.RtL.dead();
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.wallet_core.c.m.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(72759);
                    if (!m.this.dDz) {
                        m.this.dDz = true;
                        m.this.RtK.onUrlCancel();
                    }
                    AppMethodBeat.o(72759);
                }
            }, 200);
            AppMethodBeat.o(72760);
            return false;
        }
    };
    public boolean RtM = false;
    boolean dDz = false;
    String dQx;
    String lHA;
    String lHB;
    String title;
    int uSc;
    IListener<aba> zmm = new IListener<aba>() {
        /* class com.tencent.mm.wallet_core.c.m.AnonymousClass1 */

        {
            AppMethodBeat.i(160906);
            this.__eventId = aba.class.getName().hashCode();
            AppMethodBeat.o(160906);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aba aba) {
            AppMethodBeat.i(72758);
            final aba aba2 = aba;
            Log.i("MicroMsg.JumpRemind", "WxPayGdprResultEvent result");
            m.this.dDz = true;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.wallet_core.c.m.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(72757);
                    if (aba2.eim.dNk == "agree_privacy") {
                        m.this.RtK.onUrlOk();
                        AppMethodBeat.o(72757);
                        return;
                    }
                    m.this.RtK.onUrlCancel();
                    AppMethodBeat.o(72757);
                }
            });
            m.this.zmm.dead();
            AppMethodBeat.o(72758);
            return false;
        }
    };

    /* access modifiers changed from: package-private */
    public static class a {
        String MPC;
        String dNI;
        String gTt;
        String path;
        int type;

        a() {
        }
    }

    public final boolean hhm() {
        if (this.uSc == 1) {
            return true;
        }
        return false;
    }

    public m() {
        AppMethodBeat.i(72770);
        AppMethodBeat.o(72770);
    }

    public static m a(cfm cfm) {
        AppMethodBeat.i(72771);
        if (cfm == null) {
            AppMethodBeat.o(72771);
            return null;
        }
        m mVar = new m();
        mVar.Mlw = cfm.Mlw;
        mVar.uSc = cfm.uSc;
        mVar.dQx = cfm.dQx;
        mVar.lHA = cfm.lHA;
        mVar.lHB = cfm.lHB;
        mVar.title = cfm.title;
        mVar.RtJ = new a();
        if (cfm.Mlx != null) {
            mVar.RtJ.type = cfm.Mlx.type;
            mVar.RtJ.dNI = cfm.Mlx.dNI;
            mVar.RtJ.MPC = cfm.Mlx.MPC;
            mVar.RtJ.path = cfm.Mlx.path;
            mVar.RtJ.gTt = cfm.Mlx.gTt;
        }
        AppMethodBeat.o(72771);
        return mVar;
    }

    public static m cj(JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(72772);
        try {
            Log.i("MicroMsg.JumpRemind", "feed %s", jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("bindquerynew_resp");
            if (optJSONObject == null) {
                optJSONObject = jSONObject;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("bindqueryresp");
            if (optJSONObject2 != null) {
                optJSONObject = optJSONObject2;
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("jumpRemind");
            if (optJSONObject3 == null) {
                optJSONObject3 = optJSONObject.optJSONObject("jump_remind");
            }
            if (optJSONObject3 == null) {
                jSONObject2 = optJSONObject.optJSONObject("jump_remind_info");
            } else {
                jSONObject2 = optJSONObject3;
            }
            if (jSONObject2 != null) {
                m mVar = new m();
                mVar.uSc = jSONObject2.optInt("jump_type");
                mVar.Mlw = jSONObject2.optBoolean("is_pop_up_windows");
                mVar.dQx = jSONObject2.optString("wording");
                mVar.lHA = jSONObject2.optString("left_button_wording");
                mVar.lHB = jSONObject2.optString("right_button_wording");
                mVar.title = jSONObject2.optString("title");
                JSONObject optJSONObject4 = jSONObject2.optJSONObject("url");
                mVar.RtJ = new a();
                if (optJSONObject4 != null) {
                    mVar.RtJ.type = optJSONObject4.optInt("type");
                    mVar.RtJ.dNI = optJSONObject4.optString("appid");
                    mVar.RtJ.MPC = optJSONObject4.optString("app_version");
                    mVar.RtJ.path = optJSONObject4.optString("path");
                    mVar.RtJ.gTt = optJSONObject4.optString("button_name");
                }
                AppMethodBeat.o(72772);
                return mVar;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JumpRemind", e2, "error create", new Object[0]);
        }
        AppMethodBeat.o(72772);
        return null;
    }

    public final void hhn() {
        AppMethodBeat.i(214332);
        if (this.RtJ == null || Util.isNullOrNil(this.RtJ.path)) {
            AppMethodBeat.o(214332);
        } else if (this.RtJ.path.contains("clientversion")) {
            Log.w("MicroMsg.JumpRemind", "url.path contain clientversion");
            AppMethodBeat.o(214332);
        } else {
            this.RtJ.path = w.q(this.RtJ.path, "clientversion" + "=" + d.KyO);
            AppMethodBeat.o(214332);
        }
    }

    public final boolean a(final Activity activity, f fVar) {
        AppMethodBeat.i(72773);
        this.RtK = fVar;
        if (this.Mlw) {
            h.c(activity, this.dQx, this.title, this.lHB, this.lHA, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.wallet_core.c.m.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(72761);
                    Log.i("MicroMsg.JumpRemind", "onClick1 ");
                    if (m.this.RtJ == null || !m.this.RtJ.gTt.equals("right_button_wording")) {
                        m.this.RtK.onCancel();
                        AppMethodBeat.o(72761);
                        return;
                    }
                    m.this.kP(activity);
                    AppMethodBeat.o(72761);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.wallet_core.c.m.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(72762);
                    Log.i("MicroMsg.JumpRemind", "onClick2");
                    if (m.this.RtJ == null || !m.this.RtJ.gTt.equals("left_button_wording")) {
                        m.this.RtK.onCancel();
                        AppMethodBeat.o(72762);
                        return;
                    }
                    m.this.kP(activity);
                    AppMethodBeat.o(72762);
                }
            });
            AppMethodBeat.o(72773);
        } else {
            kP(activity);
            AppMethodBeat.o(72773);
        }
        return true;
    }

    public final boolean a(final Activity activity, final g gVar) {
        AppMethodBeat.i(72774);
        boolean a2 = a(activity, new f() {
            /* class com.tencent.mm.wallet_core.c.m.AnonymousClass5 */

            @Override // com.tencent.mm.wallet_core.c.f
            public final void onCancel() {
                AppMethodBeat.i(72763);
                if (m.this.hhm()) {
                    gVar.eeY();
                    AppMethodBeat.o(72763);
                    return;
                }
                activity.finish();
                AppMethodBeat.o(72763);
            }

            @Override // com.tencent.mm.wallet_core.c.f
            public final void onEnter() {
            }

            @Override // com.tencent.mm.wallet_core.c.f
            public final void onUrlOk() {
                AppMethodBeat.i(72764);
                if (m.this.hhm()) {
                    gVar.eeY();
                }
                AppMethodBeat.o(72764);
            }

            @Override // com.tencent.mm.wallet_core.c.f
            public final void onUrlCancel() {
                AppMethodBeat.i(72765);
                if (m.this.hhm()) {
                    gVar.eeY();
                    AppMethodBeat.o(72765);
                    return;
                }
                activity.finish();
                AppMethodBeat.o(72765);
            }
        });
        AppMethodBeat.o(72774);
        return a2;
    }

    public final boolean a(Activity activity, final h hVar) {
        AppMethodBeat.i(72775);
        h.c(activity, this.dQx, this.title, this.lHB, this.lHA, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.c.m.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(72766);
                Log.i("MicroMsg.JumpRemind", "onClick1 ");
                if (m.this.RtJ == null || !m.this.RtJ.gTt.equals("right_button_wording")) {
                    hVar.onCancel();
                    AppMethodBeat.o(72766);
                    return;
                }
                hVar.bG(m.this.RtJ.type, m.this.RtJ.path);
                AppMethodBeat.o(72766);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.c.m.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(72767);
                Log.i("MicroMsg.JumpRemind", "onClick2");
                if (m.this.RtJ == null || !m.this.RtJ.gTt.equals("left_button_wording")) {
                    hVar.onCancel();
                    AppMethodBeat.o(72767);
                    return;
                }
                hVar.bG(m.this.RtJ.type, m.this.RtJ.path);
                AppMethodBeat.o(72767);
            }
        });
        AppMethodBeat.o(72775);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void kP(Context context) {
        AppMethodBeat.i(72776);
        if (context instanceof i) {
            ((i) context).register(new k() {
                /* class com.tencent.mm.wallet_core.c.m.AnonymousClass8 */

                @Override // com.tencent.mm.wallet_core.c.k
                public final void onDestroy() {
                    AppMethodBeat.i(72768);
                    m.this.zmm.dead();
                    m.this.RtL.dead();
                    AppMethodBeat.o(72768);
                }

                @Override // com.tencent.mm.wallet_core.c.k
                public final void hhl() {
                    AppMethodBeat.i(72769);
                    m.this.zmm.dead();
                    m.this.RtL.dead();
                    AppMethodBeat.o(72769);
                }
            });
            this.zmm.alive();
            this.RtL.alive();
            this.dDz = false;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.RtJ.path);
            intent.putExtra("showShare", false);
            this.RtK.onEnter();
            f.aA(context, intent);
            AppMethodBeat.o(72776);
            return;
        }
        if (this.RtM) {
            this.zmm.alive();
            this.RtL.alive();
            this.dDz = false;
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.RtJ.path);
            intent2.putExtra("showShare", false);
            this.RtK.onEnter();
            f.aA(context, intent2);
        }
        AppMethodBeat.o(72776);
    }

    public final void hho() {
        AppMethodBeat.i(72777);
        this.zmm.dead();
        this.RtL.dead();
        AppMethodBeat.o(72777);
    }
}
