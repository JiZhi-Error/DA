package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;

public final class q {
    private static final ai<ayy> tUo = new a();
    private static final int vWa = vWa;
    public static final q vWb = new q();

    static {
        AppMethodBeat.i(253475);
        AppMethodBeat.o(253475);
    }

    private q() {
    }

    public static int dCb() {
        return vWa;
    }

    public static /* synthetic */ void a(m mVar, Context context, int i2, int i3, boolean z) {
        AppMethodBeat.i(253472);
        a(mVar, context, i2, i3, z, false);
        AppMethodBeat.o(253472);
    }

    public static void a(m mVar, Context context, int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(253471);
        p.h(mVar, "menu");
        p.h(context, "context");
        if (z) {
            mVar.a(i2, context.getString(R.string.d97), R.raw.icons_outlined_unlock, z2);
            AppMethodBeat.o(253471);
            return;
        }
        mVar.a(i3, context.getString(R.string.d95), R.raw.icons_outlined_lock, z2);
        AppMethodBeat.o(253471);
    }

    public static final class a implements ai<ayy> {
        a() {
        }

        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(ayy ayy, apg apg) {
            AppMethodBeat.i(253469);
            p.h(ayy, "req");
            p.h(apg, "ret");
            if (apg.retCode == 0) {
                Log.i("FinderPrivateUtil", "finder_feed_privacy_op_ok " + apg.retCode);
                AppMethodBeat.o(253469);
                return;
            }
            int i2 = apg.retCode;
            q qVar = q.vWb;
            if (i2 == q.dCb()) {
                u.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.d64), C1317a.vWc);
                AppMethodBeat.o(253469);
                return;
            }
            Log.i("FinderPrivateUtil", "finder_feed_privacy_op__no_ok " + apg.retCode);
            u.makeText(MMApplicationContext.getContext(), (int) R.string.d93, 0).show();
            AppMethodBeat.o(253469);
        }

        /* renamed from: com.tencent.mm.plugin.finder.utils.q$a$a */
        static final class C1317a implements u.b {
            public static final C1317a vWc = new C1317a();

            static {
                AppMethodBeat.i(253468);
                AppMethodBeat.o(253468);
            }

            C1317a() {
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                TextView textView;
                AppMethodBeat.i(253467);
                if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                    AppMethodBeat.o(253467);
                    return;
                }
                textView.setTextSize(1, 14.0f);
                AppMethodBeat.o(253467);
            }
        }
    }

    public static void a(Context context, FinderItem finderItem, boolean z) {
        AppMethodBeat.i(253473);
        p.h(context, "context");
        p.h(finderItem, "feed");
        ((v) g.af(v.class)).b(finderItem.getId(), finderItem.getFeedObject(), finderItem.getObjectNonceId(), z, tUo);
        AppMethodBeat.o(253473);
    }

    public static final class b implements ai<ayy> {
        final /* synthetic */ Context $context;
        final /* synthetic */ long vWd;
        final /* synthetic */ boolean vWe;

        b(long j2, boolean z, Context context) {
            this.vWd = j2;
            this.vWe = z;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(ayy ayy, apg apg) {
            int i2;
            LinkedList<aop> linkedList;
            aop aop;
            bei bei;
            AppMethodBeat.i(253470);
            p.h(ayy, "req");
            p.h(apg, "ret");
            if (apg.retCode == 0) {
                Log.i("FinderPrivateUtil", "finder_feed_privacy_op_ok " + apg.retCode);
                e.a aVar = e.vFX;
                FinderObject FD = e.a.FD(this.vWd);
                if (FD != null) {
                    aoq aoq = FD.attachmentList;
                    cng cng = (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null) ? null : bei.LIA;
                    if (cng != null) {
                        if (this.vWe) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        cng.privateFlag = i2;
                    }
                    e.a aVar2 = e.vFX;
                    e.a.j(FD);
                    hn hnVar = new hn();
                    hnVar.dLW.id = cng != null ? cng.id : 0;
                    hnVar.dLW.dLK = 1;
                    EventCenter.instance.publish(hnVar);
                    AppMethodBeat.o(253470);
                    return;
                }
                AppMethodBeat.o(253470);
                return;
            }
            Log.i("FinderPrivateUtil", "finder_feed_privacy_op__no_ok " + apg.retCode);
            u.makeText(this.$context, (int) R.string.d93, 0).show();
            AppMethodBeat.o(253470);
        }
    }

    public static void a(Context context, long j2, long j3, String str, boolean z) {
        AppMethodBeat.i(253474);
        p.h(context, "context");
        p.h(str, "objectNonceId");
        ((v) g.af(v.class)).b(j3, null, str, z, new b(j2, z, context));
        AppMethodBeat.o(253474);
    }
}
