package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

public final class a extends com.tencent.mm.plugin.multitask.b.c {
    private static final b uLv = new b();
    public static final C1220a uLw = new C1220a((byte) 0);
    private final Context context;
    public f uKk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context2, com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        p.h(context2, "context");
        p.h(aVar, "pageAdapter");
        AppMethodBeat.i(248457);
        this.context = context2;
        AppMethodBeat.o(248457);
    }

    /* renamed from: com.tencent.mm.plugin.finder.megavideo.multitask.a$a */
    public static final class C1220a {
        private C1220a() {
        }

        public /* synthetic */ C1220a(byte b2) {
            this();
        }

        public static void a(MultiTaskInfo multiTaskInfo, crq crq, boolean z, Activity activity) {
            List list;
            FinderObject feedObject;
            String str;
            AppMethodBeat.i(248449);
            p.h(multiTaskInfo, "multiTaskInfo");
            cnu cnu = new cnu();
            try {
                cnu.parseFrom(multiTaskInfo.field_data);
            } catch (Throwable th) {
                Log.e("MegaVideoMultiTaskHelper", "MegaVideoFloatBallInfo parse fail", th);
            }
            Intent intent = new Intent();
            LinkedList<FinderObject> linkedList = cnu.Muf;
            p.g(linkedList, "data.cacheNewVideoList");
            if (j.L(linkedList, cnu.Muc) == null) {
                Log.e("MegaVideoMultiTaskHelper", "onTaskBarItemClicked: currVideoPos item is null pos = " + cnu.Muc);
                cnu.Muc = 0;
            }
            cnu.key = multiTaskInfo.field_id;
            LinkedList<FinderObject> linkedList2 = cnu.Muf;
            p.g(linkedList2, "data.cacheNewVideoList");
            LinkedList<FinderObject> linkedList3 = linkedList2;
            ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
            for (T t : linkedList3) {
                p.g(t, LocaleUtil.ITALIAN);
                arrayList.add(new bm((FinderObject) t));
            }
            bm bmVar = (bm) j.L(arrayList, cnu.Muc);
            if (bmVar == null || (list = j.listOf(bmVar)) == null) {
                list = new LinkedList();
            }
            ad adVar = (ad) g.af(ad.class);
            Context context = MMApplicationContext.getContext();
            bm bmVar2 = (bm) j.kt(list);
            adVar.a(context, (bmVar2 == null || (feedObject = bmVar2.getFeedObject()) == null || (str = feedObject.username) == null) ? "" : str, new C1221a(z, list, cnu, intent, multiTaskInfo, crq, activity));
            AppMethodBeat.o(248449);
        }

        /* renamed from: com.tencent.mm.plugin.finder.megavideo.multitask.a$a$a */
        public static final class C1221a implements ad.a {
            final /* synthetic */ Intent $intent;
            final /* synthetic */ Activity msB;
            final /* synthetic */ List tAU;
            final /* synthetic */ crq uLA;
            final /* synthetic */ boolean uLx;
            final /* synthetic */ cnu uLy;
            final /* synthetic */ MultiTaskInfo uLz;

            C1221a(boolean z, List list, cnu cnu, Intent intent, MultiTaskInfo multiTaskInfo, crq crq, Activity activity) {
                this.uLx = z;
                this.tAU = list;
                this.uLy = cnu;
                this.$intent = intent;
                this.uLz = multiTaskInfo;
                this.uLA = crq;
                this.msB = activity;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e0, code lost:
                if (r11.$intent.putExtra("key_multi_task_common_info", r4.toByteArray()) == null) goto L_0x00e2;
             */
            @Override // com.tencent.mm.plugin.i.a.ad.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void mM(boolean r12) {
                /*
                // Method dump skipped, instructions count: 335
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.multitask.a.C1220a.C1221a.mM(boolean):void");
            }
        }
    }

    public static final class b implements c.a {
        b() {
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void a(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(248446);
            p.h(multiTaskInfo, "multiTaskInfo");
            AppMethodBeat.o(248446);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void b(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(248447);
            p.h(multiTaskInfo, "multiTaskInfo");
            C1220a aVar = a.uLw;
            C1220a.a(multiTaskInfo, null, false, null);
            AppMethodBeat.o(248447);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void c(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(248448);
            p.h(multiTaskInfo, "multiTaskInfo");
            AppMethodBeat.o(248448);
        }
    }

    static {
        AppMethodBeat.i(248458);
        AppMethodBeat.o(248458);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void bPu() {
        AppMethodBeat.i(248451);
        f fVar = this.uKk;
        if (fVar != null) {
            fVar.O(true, true);
            AppMethodBeat.o(248451);
            return;
        }
        AppMethodBeat.o(248451);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPs() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean dki() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final boolean O(int i2, boolean z) {
        AppMethodBeat.i(248452);
        boolean O = super.O(i2, z);
        AppMethodBeat.o(248452);
        return O;
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Runnable {
        final /* synthetic */ a uLC;

        c(a aVar) {
            this.uLC = aVar;
        }

        public final void run() {
            AppMethodBeat.i(248450);
            a aVar = this.uLC;
            a aVar2 = this.uLC;
            com.tencent.mm.plugin.multitask.a.a aVar3 = this.uLC.Aak;
            aVar.ai(aVar2.aj(aVar3 != null ? aVar3.getBitmap() : null));
            AppMethodBeat.o(248450);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void dkj() {
        AppMethodBeat.i(248453);
        h.RTc.aY(new c(this));
        AppMethodBeat.o(248453);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void ic(boolean z) {
        AppMethodBeat.i(248454);
        super.ic(z);
        if (z) {
            nH(false);
        }
        AppMethodBeat.o(248454);
    }

    @Override // com.tencent.mm.plugin.multitask.b.c
    public final void dkk() {
        AppMethodBeat.i(248455);
        nH(true);
        AppMethodBeat.o(248455);
    }

    private final void nH(boolean z) {
        bbn bbn;
        cng cng;
        long j2;
        String str;
        String str2;
        String str3;
        cns cns;
        aoq aoq;
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        long j3 = 0;
        int i2 = 1;
        AppMethodBeat.i(248456);
        cnu cnu = new cnu();
        try {
            MultiTaskInfo multiTaskInfo = this.Abp;
            cnu.parseFrom(multiTaskInfo != null ? multiTaskInfo.field_data : null);
        } catch (Throwable th) {
            Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", th);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.context);
        if (fH != null) {
            bbn = fH.dIx();
        } else {
            bbn = null;
        }
        LinkedList<FinderObject> linkedList2 = cnu.Muf;
        p.g(linkedList2, "floatBallInfo.cacheNewVideoList");
        FinderObject finderObject = (FinderObject) j.L(linkedList2, cnu.Muc);
        if (finderObject == null || (aoq = finderObject.attachmentList) == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null) {
            cng = null;
        } else {
            cng = bei.LIA;
        }
        af afVar = af.viA;
        long aWA = cl.aWA();
        if (!z) {
            i2 = 3;
        }
        if (cng != null) {
            j2 = cng.id;
        } else {
            j2 = 0;
        }
        String zs = d.zs(j2);
        if (bbn == null || (str = bbn.sessionId) == null) {
            str = "";
        }
        if (bbn == null || (str2 = bbn.sGQ) == null) {
            str2 = "";
        }
        if (bbn == null || (str3 = bbn.sGE) == null) {
            str3 = "";
        }
        if (!(cng == null || (cns = cng.MtI) == null)) {
            j3 = cns.hFK;
        }
        af.a(aWA, i2, 0, zs, "", str, str2, str3, d.zs(j3));
        AppMethodBeat.o(248456);
    }
}
