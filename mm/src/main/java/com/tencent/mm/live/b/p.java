package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"})
public final class p implements com.tencent.mm.live.api.a {
    private static final String TAG = TAG;
    public static final p hHC = new p();

    static {
        AppMethodBeat.i(207649);
        AppMethodBeat.o(207649);
    }

    private p() {
    }

    public static final /* synthetic */ void h(Context context, LiveConfig liveConfig) {
        AppMethodBeat.i(207650);
        g(context, liveConfig);
        AppMethodBeat.o(207650);
    }

    public static final /* synthetic */ void i(Context context, LiveConfig liveConfig) {
        AppMethodBeat.i(207651);
        e(context, liveConfig);
        AppMethodBeat.o(207651);
    }

    public static final /* synthetic */ void j(Context context, LiveConfig liveConfig) {
        AppMethodBeat.i(207652);
        f(context, liveConfig);
        AppMethodBeat.o(207652);
    }

    @Override // com.tencent.mm.live.api.a
    public final boolean a(Context context, LiveConfig liveConfig) {
        boolean z;
        AppMethodBeat.i(207642);
        kotlin.g.b.p.h(context, "context");
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
            intent.putExtra("KEY_PARAMS_CONFIG", liveConfig);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            z = true;
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace(TAG, e2, "jumpToEntranceUI failed!", new Object[0]);
            z = false;
        }
        AppMethodBeat.o(207642);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
        if (r2 != com.tencent.mm.live.b.x.aGr().hyH) goto L_0x0094;
     */
    @Override // com.tencent.mm.live.api.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.content.Context r8, com.tencent.mm.live.api.LiveConfig r9) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.p.b(android.content.Context, com.tencent.mm.live.api.LiveConfig):boolean");
    }

    @Override // com.tencent.mm.live.api.a
    public final boolean d(Context context, LiveConfig liveConfig) {
        boolean z;
        AppMethodBeat.i(207644);
        kotlin.g.b.p.h(context, "context");
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.live.ui.LiveUID"));
            intent.putExtra("KEY_PARAMS_CONFIG", liveConfig);
            intent.addFlags(268435456);
            intent.putExtra("FROM_SENCE", 1);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            z = true;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "jumpToReplayUI failed!", new Object[0]);
            z = false;
        }
        AppMethodBeat.o(207644);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a3, code lost:
        if (r2 != com.tencent.mm.live.b.x.aGr().hyH) goto L_0x00a5;
     */
    @Override // com.tencent.mm.live.api.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(android.content.Context r10, com.tencent.mm.live.api.LiveConfig r11) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.p.c(android.content.Context, com.tencent.mm.live.api.LiveConfig):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
        if (r0 != false) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(android.content.Context r6, com.tencent.mm.live.api.LiveConfig r7) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.p.e(android.content.Context, com.tencent.mm.live.api.LiveConfig):void");
    }

    private static void f(Context context, LiveConfig liveConfig) {
        AppMethodBeat.i(207647);
        if (liveConfig != null) {
            com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().w(liveConfig.aBD(), liveConfig.getLiveId());
        }
        Intent intent = new Intent(context, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
        intent.putExtra("KEY_PARAMS_CONFIG", liveConfig);
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(207647);
    }

    private static void g(Context context, LiveConfig liveConfig) {
        AppMethodBeat.i(207648);
        Intent intent = new Intent(context, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
        intent.putExtra("KEY_PARAMS_CONFIG", liveConfig);
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(207648);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0002J$\u0010\u000f\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0002J$\u0010\u0010\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkAnchorLiving", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "errorCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "Lkotlin/ParameterName;", "name", "liveAnchorInfo", "", "checkIsUsePhone", "Lkotlin/Function0;", "checkLiveInfo", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"})
    public static final class a {
        public static final a hHD = new a();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "liveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "invoke"})
        static final class e extends q implements kotlin.g.a.b<cip, x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ LiveConfig hHI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(Context context, LiveConfig liveConfig) {
                super(1);
                this.$context = context;
                this.hHI = liveConfig;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(cip cip) {
                String str = null;
                AppMethodBeat.i(207622);
                final cip cip2 = cip;
                kotlin.g.b.p.h(cip2, "liveAnchorInfo");
                f.a bow = new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehr));
                Resources resources = this.$context.getResources();
                f.a boA = bow.boA(resources != null ? resources.getString(R.string.x_) : null);
                Resources resources2 = this.$context.getResources();
                if (resources2 != null) {
                    str = resources2.getString(R.string.sz);
                }
                boA.boB(str).b(new f.c(this) {
                    /* class com.tencent.mm.live.b.p.a.e.AnonymousClass1 */
                    final /* synthetic */ e hHO;

                    {
                        this.hHO = r1;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0049, code lost:
                        if (r2 != com.tencent.mm.live.b.x.aGr().hyH) goto L_0x004b;
                     */
                    @Override // com.tencent.mm.ui.widget.a.f.c
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void e(boolean r8, java.lang.String r9) {
                        /*
                            r7 = this;
                            r6 = 207620(0x32b04, float:2.90938E-40)
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                            com.tencent.mm.live.api.LiveConfig$a r0 = new com.tencent.mm.live.api.LiveConfig$a
                            r0.<init>()
                            int r1 = com.tencent.mm.live.api.LiveConfig.hvT
                            com.tencent.mm.live.api.LiveConfig$a r0 = r0.qo(r1)
                            com.tencent.mm.protocal.protobuf.cip r1 = r6
                            java.lang.String r1 = r1.MnB
                            com.tencent.mm.live.api.LiveConfig$a r0 = r0.Gc(r1)
                            com.tencent.mm.protocal.protobuf.cip r1 = r6
                            long r2 = r1.hyH
                            com.tencent.mm.live.api.LiveConfig$a r0 = r0.zt(r2)
                            com.tencent.mm.protocal.protobuf.cip r1 = r6
                            java.lang.String r1 = r1.LpF
                            com.tencent.mm.live.api.LiveConfig$a r0 = r0.Ge(r1)
                            com.tencent.mm.protocal.protobuf.cip r1 = r6
                            java.lang.String r1 = r1.MnC
                            com.tencent.mm.live.api.LiveConfig$a r0 = r0.Gg(r1)
                            com.tencent.mm.live.api.LiveConfig r0 = r0.aBR()
                            com.tencent.mm.live.b.p$a$e r1 = r7.hHO
                            com.tencent.mm.live.api.LiveConfig r1 = r1.hHI
                            if (r1 == 0) goto L_0x004b
                            long r2 = r1.getLiveId()
                            com.tencent.mm.live.b.x r1 = com.tencent.mm.live.b.x.hJf
                            com.tencent.mm.protocal.protobuf.civ r1 = com.tencent.mm.live.b.x.aGr()
                            long r4 = r1.hyH
                            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                            if (r1 == 0) goto L_0x0050
                        L_0x004b:
                            com.tencent.mm.live.b.x r1 = com.tencent.mm.live.b.x.hJf
                            com.tencent.mm.live.b.x.and()
                        L_0x0050:
                            com.tencent.mm.live.b.p r1 = com.tencent.mm.live.b.p.hHC
                            com.tencent.mm.live.b.p$a$e r1 = r7.hHO
                            android.content.Context r1 = r1.$context
                            com.tencent.mm.live.b.p.h(r1, r0)
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.p.a.e.AnonymousClass1.e(boolean, java.lang.String):void");
                    }
                }).a(AnonymousClass2.hHQ).show();
                x xVar = x.SXb;
                AppMethodBeat.o(207622);
                return xVar;
            }
        }

        static {
            AppMethodBeat.i(207639);
            AppMethodBeat.o(207639);
        }

        private a() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0098, code lost:
            if (com.tencent.mm.sdk.platformtools.Util.isEqual(com.tencent.mm.live.b.x.aGm(), r13.aBD()) != false) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a0, code lost:
            if (r13.getScene() == com.tencent.mm.live.api.LiveConfig.hvS) goto L_0x00a2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a2, code lost:
            r0 = false;
         */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.live.b.p.a a(com.tencent.mm.live.api.LiveConfig r13, kotlin.g.a.a<kotlin.x> r14) {
            /*
            // Method dump skipped, instructions count: 193
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.p.a.a(com.tencent.mm.live.api.LiveConfig, kotlin.g.a.a):com.tencent.mm.live.b.p$a");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.live.b.p.a l(kotlin.g.a.a<kotlin.x> r10) {
            /*
            // Method dump skipped, instructions count: 126
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.p.a.l(kotlin.g.a.a):com.tencent.mm.live.b.p$a");
        }

        /* access modifiers changed from: package-private */
        public final a m(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(207637);
            if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                aVar.invoke();
                AppMethodBeat.o(207637);
                return null;
            }
            AppMethodBeat.o(207637);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final a n(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(207638);
            xq xqVar = new xq();
            xqVar.edR.edT = true;
            EventCenter.instance.publish(xqVar);
            if (!Util.isNullOrNil(xqVar.edS.edV)) {
                aVar.invoke();
                AppMethodBeat.o(207638);
                return null;
            }
            AppMethodBeat.o(207638);
            return this;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.live.b.p$a$a  reason: collision with other inner class name */
        static final class C0375a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0375a(Context context, z.f fVar) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(207609);
                new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehv)).boA(this.hHE.SYG).b(AnonymousClass1.hHF).show();
                x xVar = x.SXb;
                AppMethodBeat.o(207609);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Context context, z.f fVar) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(207611);
                new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.eht)).boA(this.hHE.SYG).b(AnonymousClass1.hHG).show();
                x xVar = x.SXb;
                AppMethodBeat.o(207611);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Context context, z.f fVar) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(207613);
                new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehw)).boA(this.hHE.SYG).b(AnonymousClass1.hHH).show();
                x xVar = x.SXb;
                AppMethodBeat.o(207613);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class d extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;
            final /* synthetic */ LiveConfig hHI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(Context context, z.f fVar, LiveConfig liveConfig) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
                this.hHI = liveConfig;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                String str;
                String str2;
                String str3;
                String str4;
                String str5 = null;
                AppMethodBeat.i(207619);
                x xVar = x.hJf;
                if (Util.isEqual(x.aGt(), com.tencent.mm.model.z.aTY())) {
                    new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehs)).boA(this.hHE.SYG).b(AnonymousClass1.hHJ).show();
                } else {
                    LiveConfig liveConfig = this.hHI;
                    if (liveConfig == null || liveConfig.getScene() != LiveConfig.hvS) {
                        x xVar2 = x.hJf;
                        a.C0371a aVar = x.aHa().hKU;
                        if (aVar != null) {
                            str = aVar.hFJ;
                        } else {
                            str = null;
                        }
                        if (Util.isEqual(str, com.tencent.mm.model.z.aTY())) {
                            new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehs)).boA(this.hHE.SYG).b(AnonymousClass3.hHL).show();
                        } else {
                            b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
                            if (b.a.aDp()) {
                                b.a aVar3 = com.tencent.mm.live.core.core.a.b.hyv;
                                b.a.aDo();
                            } else {
                                b.a aVar4 = com.tencent.mm.live.core.core.d.b.hCo;
                                if (b.a.aDp()) {
                                    b.a aVar5 = com.tencent.mm.live.core.core.d.b.hCo;
                                    b.a.aEf();
                                }
                            }
                            f.a aVar6 = new f.a(this.$context);
                            Resources resources = this.$context.getResources();
                            if (resources != null) {
                                Object[] objArr = new Object[1];
                                LiveConfig liveConfig2 = this.hHI;
                                if (liveConfig2 != null) {
                                    str4 = liveConfig2.aBF();
                                } else {
                                    str4 = null;
                                }
                                objArr[0] = str4;
                                str2 = resources.getString(R.string.ehu, objArr);
                            } else {
                                str2 = null;
                            }
                            f.a bow = aVar6.bow(str2);
                            Resources resources2 = this.$context.getResources();
                            if (resources2 != null) {
                                str3 = resources2.getString(R.string.egi);
                            } else {
                                str3 = null;
                            }
                            f.a boA = bow.boA(str3);
                            Resources resources3 = this.$context.getResources();
                            if (resources3 != null) {
                                str5 = resources3.getString(R.string.sz);
                            }
                            boA.boB(str5).b(new f.c(this) {
                                /* class com.tencent.mm.live.b.p.a.d.AnonymousClass4 */
                                final /* synthetic */ d hHM;

                                {
                                    this.hHM = r1;
                                }

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                    AppMethodBeat.i(207617);
                                    if (z) {
                                        r rVar = r.hIg;
                                        r.aFZ();
                                        x xVar = x.hJf;
                                        x.aHi();
                                        p pVar = p.hHC;
                                        p.h(this.hHM.$context, this.hHM.hHI);
                                    }
                                    AppMethodBeat.o(207617);
                                }
                            }).a(AnonymousClass5.hHN).show();
                        }
                    } else {
                        new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehs)).boA(this.hHE.SYG).b(AnonymousClass2.hHK).show();
                    }
                }
                x xVar3 = x.SXb;
                AppMethodBeat.o(207619);
                return xVar3;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class f extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(Context context, z.f fVar) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(207624);
                new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehv)).boA(this.hHE.SYG).b(AnonymousClass1.hHR).show();
                x xVar = x.SXb;
                AppMethodBeat.o(207624);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class g extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(Context context, z.f fVar) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(207626);
                new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.eht)).boA(this.hHE.SYG).b(AnonymousClass1.hHS).show();
                x xVar = x.SXb;
                AppMethodBeat.o(207626);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class h extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(Context context, z.f fVar) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(207628);
                new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehw)).boA(this.hHE.SYG).b(AnonymousClass1.hHT).show();
                x xVar = x.SXb;
                AppMethodBeat.o(207628);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class i extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f hHE;
            final /* synthetic */ LiveConfig hHI;
            final /* synthetic */ z.f hHU;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(Context context, z.f fVar, LiveConfig liveConfig, z.f fVar2) {
                super(0);
                this.$context = context;
                this.hHE = fVar;
                this.hHI = liveConfig;
                this.hHU = fVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                String str;
                String str2;
                String str3;
                String str4;
                String str5 = null;
                AppMethodBeat.i(207634);
                x xVar = x.hJf;
                if (Util.isEqual(x.aGt(), com.tencent.mm.model.z.aTY())) {
                    new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehs)).boA(this.hHE.SYG).b(AnonymousClass1.hHV).show();
                } else {
                    LiveConfig liveConfig = this.hHI;
                    if (liveConfig == null || liveConfig.getScene() != LiveConfig.hvS) {
                        x xVar2 = x.hJf;
                        a.C0371a aVar = x.aHa().hKU;
                        if (aVar != null) {
                            str = aVar.hFJ;
                        } else {
                            str = null;
                        }
                        if (Util.isEqual(str, com.tencent.mm.model.z.aTY())) {
                            new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ehs)).boA(this.hHE.SYG).b(AnonymousClass3.hHX).show();
                        } else {
                            b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
                            if (b.a.aDp()) {
                                b.a aVar3 = com.tencent.mm.live.core.core.a.b.hyv;
                                b.a.aDo();
                            } else {
                                b.a aVar4 = com.tencent.mm.live.core.core.d.b.hCo;
                                if (b.a.aDp()) {
                                    b.a aVar5 = com.tencent.mm.live.core.core.d.b.hCo;
                                    b.a.aEf();
                                }
                            }
                            f.a aVar6 = new f.a(this.$context);
                            Resources resources = this.$context.getResources();
                            if (resources != null) {
                                Object[] objArr = new Object[1];
                                LiveConfig liveConfig2 = this.hHI;
                                if (liveConfig2 != null) {
                                    str4 = liveConfig2.aBF();
                                } else {
                                    str4 = null;
                                }
                                objArr[0] = str4;
                                str2 = resources.getString(R.string.ehu, objArr);
                            } else {
                                str2 = null;
                            }
                            f.a bow = aVar6.bow(str2);
                            Resources resources2 = this.$context.getResources();
                            if (resources2 != null) {
                                str3 = resources2.getString(R.string.egi);
                            } else {
                                str3 = null;
                            }
                            f.a boA = bow.boA(str3);
                            Resources resources3 = this.$context.getResources();
                            if (resources3 != null) {
                                str5 = resources3.getString(R.string.sz);
                            }
                            boA.boB(str5).b(new f.c(this) {
                                /* class com.tencent.mm.live.b.p.a.i.AnonymousClass4 */
                                final /* synthetic */ i hHY;

                                {
                                    this.hHY = r1;
                                }

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                    AppMethodBeat.i(207632);
                                    if (z) {
                                        r rVar = r.hIg;
                                        r.aFZ();
                                        x xVar = x.hJf;
                                        x.aHi();
                                        p pVar = p.hHC;
                                        p.i(this.hHY.$context, this.hHY.hHI);
                                    }
                                    AppMethodBeat.o(207632);
                                }
                            }).a(AnonymousClass5.hHZ).show();
                        }
                    } else {
                        new f.a(this.$context).hbu().bow(this.hHU.SYG).boA(this.hHE.SYG).b(AnonymousClass2.hHW).show();
                    }
                }
                x xVar3 = x.SXb;
                AppMethodBeat.o(207634);
                return xVar3;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g hIa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(0);
            this.hIa = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(207640);
            this.hIa.bMo();
            x xVar = x.SXb;
            AppMethodBeat.o(207640);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ g hIa;
        final /* synthetic */ LiveConfig hIb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar, Context context, LiveConfig liveConfig) {
            super(0);
            this.hIa = gVar;
            this.$context = context;
            this.hIb = liveConfig;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(207641);
            this.hIa.bMo();
            e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_LIVE_FIRST_VISITOR_INT_SYNC, (Object) 0);
            p pVar = p.hHC;
            p.j(this.$context, this.hIb);
            x xVar = x.SXb;
            AppMethodBeat.o(207641);
            return xVar;
        }
    }
}
