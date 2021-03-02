package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig;", "()V", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "canGotoFinderPage", "", "context", "Landroid/content/Context;", "userName", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig$OnCanGotoFinderPageCallback;", "getFinderOption", "", "isTeenMode", "", "isTeenModeAndFocus", "isTeenModeAndViewAll", "Companion", "plugin-finder_release"})
public final class ai implements ad {
    public static final a vFj = new a((byte) 0);
    private d<?> dialogRunnable;
    private q loadingDialog;

    static {
        AppMethodBeat.i(251885);
        AppMethodBeat.o(251885);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig$Companion;", "", "()V", "TAG", "", "checkTeenMode", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig$OnCanGotoFinderPageCallback;", "checkTeenModeInFocus", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void b(Context context, Intent intent, ad.a aVar) {
            AppMethodBeat.i(261400);
            p.h(context, "context");
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key_finder_teen_mode_scene", 0)) : null;
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            p.g(af, "MMKernel.service(ITeenModeService::class.java)");
            if (((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
                com.tencent.mm.kernel.c.a af2 = g.af(ad.class);
                p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
                if (!((ad) af2).dxY()) {
                    ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(context);
                    h.INSTANCE.a(20912, 3, valueOf, "", "");
                    aVar.mM(false);
                    AppMethodBeat.o(261400);
                    return;
                }
            }
            aVar.mM(true);
            AppMethodBeat.o(261400);
        }

        public static void a(Context context, Intent intent, ad.a aVar) {
            T t = null;
            AppMethodBeat.i(251877);
            p.h(context, "context");
            z.f fVar = new z.f();
            fVar.SYG = intent != null ? (T) Integer.valueOf(intent.getIntExtra("key_finder_teen_mode_scene", 0)) : null;
            z.f fVar2 = new z.f();
            fVar2.SYG = intent != null ? (T) intent.getStringExtra("key_finder_teen_mode_user_name") : null;
            z.f fVar3 = new z.f();
            if (intent != null) {
                t = (T) intent.getStringExtra("key_finder_teen_mode_user_id");
            }
            fVar3.SYG = t;
            if (TextUtils.isEmpty(fVar3.SYG)) {
                aVar.mM(true);
                AppMethodBeat.o(251877);
                return;
            }
            ((ad) g.af(ad.class)).a(context, fVar3.SYG, new C1280a(aVar, context, fVar, fVar3, fVar2));
            AppMethodBeat.o(251877);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onDone"})
        /* renamed from: com.tencent.mm.plugin.finder.storage.ai$a$a  reason: collision with other inner class name */
        public static final class C1280a implements ad.a {
            final /* synthetic */ Context $context;
            final /* synthetic */ ad.a vFk;
            final /* synthetic */ z.f vFl;
            final /* synthetic */ z.f vFm;
            final /* synthetic */ z.f vFn;

            C1280a(ad.a aVar, Context context, z.f fVar, z.f fVar2, z.f fVar3) {
                this.vFk = aVar;
                this.$context = context;
                this.vFl = fVar;
                this.vFm = fVar2;
                this.vFn = fVar3;
            }

            @Override // com.tencent.mm.plugin.i.a.ad.a
            public final void mM(boolean z) {
                AppMethodBeat.i(251876);
                if (z) {
                    ad.a aVar = this.vFk;
                    if (aVar != null) {
                        aVar.mM(z);
                        AppMethodBeat.o(251876);
                        return;
                    }
                    AppMethodBeat.o(251876);
                    return;
                }
                ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.$context);
                h.INSTANCE.a(20912, 3, this.vFl.SYG, this.vFm.SYG, this.vFn.SYG);
                ad.a aVar2 = this.vFk;
                if (aVar2 != null) {
                    aVar2.mM(z);
                    AppMethodBeat.o(251876);
                    return;
                }
                AppMethodBeat.o(251876);
            }
        }
    }

    private static boolean Vt() {
        AppMethodBeat.i(251880);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) af).Vt();
        AppMethodBeat.o(251880);
        return Vt;
    }

    private static int dxW() {
        AppMethodBeat.i(251881);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        int dxW = ((com.tencent.mm.plugin.teenmode.a.b) af).dxW();
        AppMethodBeat.o(251881);
        return dxW;
    }

    @Override // com.tencent.mm.plugin.i.a.ad
    public final boolean dxX() {
        AppMethodBeat.i(251882);
        if (!Vt() || dxW() != 0) {
            AppMethodBeat.o(251882);
            return false;
        }
        AppMethodBeat.o(251882);
        return true;
    }

    @Override // com.tencent.mm.plugin.i.a.ad
    public final boolean dxY() {
        AppMethodBeat.i(251883);
        if (!Vt() || dxW() != 1) {
            AppMethodBeat.o(251883);
            return false;
        }
        AppMethodBeat.o(251883);
        return true;
    }

    @Override // com.tencent.mm.plugin.i.a.ad
    public final void a(Context context, String str, ad.a aVar) {
        boolean z;
        AppMethodBeat.i(251884);
        if (context == null) {
            Log.w("Finder.FinderTeenModeConfig", "canGotoFinderPage, callback is null.");
            aVar.mM(true);
            AppMethodBeat.o(251884);
        } else if (!Vt()) {
            aVar.mM(true);
            AppMethodBeat.o(251884);
        } else {
            switch (dxW()) {
                case 1:
                    aVar.mM(true);
                    AppMethodBeat.o(251884);
                    return;
                case 2:
                    aVar.mM(false);
                    AppMethodBeat.o(251884);
                    return;
                default:
                    if (Util.isNullOrNil(str)) {
                        aVar.mM(true);
                        AppMethodBeat.o(251884);
                        return;
                    }
                    int a2 = ((m) g.af(m.class)).a(str, new c(this, str, context, aVar));
                    Logger.i("Finder.FinderTeenModeConfig", "canGotoFinderPage, userName:" + str + ", followState:" + a2);
                    if (a2 == 1) {
                        if (this.dialogRunnable != null) {
                            d<?> dVar = this.dialogRunnable;
                            if (dVar == null) {
                                p.hyc();
                            }
                            dVar.cancel(false);
                            this.dialogRunnable = null;
                        }
                        this.dialogRunnable = com.tencent.f.h.RTc.n(new b(this, context), 1500);
                        AppMethodBeat.o(251884);
                        return;
                    }
                    if (a2 == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.mM(z);
                    AppMethodBeat.o(251884);
                    return;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "state", "", "onDone"})
    static final class c implements m.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ String jDi;
        final /* synthetic */ ad.a vFk;
        final /* synthetic */ ai vFo;

        c(ai aiVar, String str, Context context, ad.a aVar) {
            this.vFo = aiVar;
            this.jDi = str;
            this.$context = context;
            this.vFk = aVar;
        }

        @Override // com.tencent.mm.plugin.i.a.m.c
        public final void yL(int i2) {
            boolean z = false;
            AppMethodBeat.i(251879);
            Logger.i("Finder.FinderTeenModeConfig", "canGotoFinderPage#onDone, userName:" + this.jDi + ", followState:" + i2);
            if (this.vFo.dialogRunnable != null) {
                d dVar = this.vFo.dialogRunnable;
                if (dVar == null) {
                    p.hyc();
                }
                dVar.cancel(false);
                this.vFo.dialogRunnable = null;
            }
            if (this.vFo.loadingDialog != null) {
                q qVar = this.vFo.loadingDialog;
                if (qVar == null) {
                    p.hyc();
                }
                qVar.dismiss();
                this.vFo.loadingDialog = null;
            }
            if (i2 == -1) {
                u.u(this.$context, this.$context.getString(R.string.h9z), R.raw.icons_filled_error);
                AppMethodBeat.o(251879);
                return;
            }
            ad.a aVar = this.vFk;
            if (i2 == 2) {
                z = true;
            }
            aVar.mM(z);
            AppMethodBeat.o(251879);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ ai vFo;

        b(ai aiVar, Context context) {
            this.vFo = aiVar;
            this.$context = context;
        }

        public final void run() {
            AppMethodBeat.i(251878);
            this.vFo.loadingDialog = q.a(this.$context, this.$context.getString(R.string.ekd), true, 3, null);
            AppMethodBeat.o(251878);
        }
    }
}
