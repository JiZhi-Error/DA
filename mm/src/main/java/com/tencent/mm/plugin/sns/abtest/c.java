package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static boolean DqY = false;
    private static String DrJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private static Set<Long> DrK = new HashSet();
    private static View.OnClickListener DrL;
    private static IListener Drh = new IListener<vl>() {
        /* class com.tencent.mm.plugin.sns.abtest.c.AnonymousClass1 */

        {
            AppMethodBeat.i(160644);
            this.__eventId = vl.class.getName().hashCode();
            AppMethodBeat.o(160644);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vl vlVar) {
            AppMethodBeat.i(94954);
            vl vlVar2 = vlVar;
            if (vlVar2 instanceof vl) {
                boolean z = vlVar2.ebH.ebI;
                long j2 = vlVar2.ebH.dNa;
                Log.d("MicroMsg.SellerABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j2));
                if (j2 != 0 && c.DrK.contains(Long.valueOf(j2))) {
                    c.H(j2, z);
                }
            }
            AppMethodBeat.o(94954);
            return false;
        }
    };

    static {
        AppMethodBeat.i(94961);
        AppMethodBeat.o(94961);
    }

    public static void eWz() {
        AppMethodBeat.i(94956);
        if (g.aWT().KR("6") != null) {
            DrJ = g.aWT().KR("6").value;
            Log.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", DrJ);
            DqY = true;
            EventCenter.instance.addListener(Drh);
            DrL = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.abtest.c.AnonymousClass2 */

                public final void onClick(View view) {
                    SnsInfo snsInfo;
                    AppMethodBeat.i(94955);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if ((view.getTag() instanceof SnsInfo) && (snsInfo = (SnsInfo) view.getTag()) != null && !Util.isNullOrNil(snsInfo.getSnsId())) {
                        c.Z(view.getContext(), snsInfo.getSnsId());
                    }
                    a.a(this, "com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(94955);
                }
            };
        }
        AppMethodBeat.o(94956);
    }

    public static void eWA() {
        AppMethodBeat.i(94957);
        DrL = null;
        EventCenter.instance.removeListener(Drh);
        if (DqY) {
            g.aWT().KR("6").igp = 2;
            g.aWT().KR("6").result = new StringBuilder().append(DrK.size()).toString();
            f.a(g.aWT().KR("6"));
            Log.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", 2, new StringBuilder().append(DrK.size()).toString());
        }
        DrJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        DqY = false;
        DrK.clear();
        AppMethodBeat.o(94957);
    }

    public static void b(View view, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(94958);
        if (DqY) {
            baseViewHolder.EXe = false;
            baseViewHolder.EXc = (ViewStub) view.findViewById(R.id.hzv);
            baseViewHolder.EXc.setVisibility(8);
        }
        AppMethodBeat.o(94958);
    }

    static /* synthetic */ void H(long j2, boolean z) {
        AppMethodBeat.i(94959);
        if (DqY) {
            g.aWT().KR("6").igp = 3;
            String str = (z ? 2 : 1) + "|" + j2;
            g.aWT().KR("6").result = str;
            f.a(g.aWT().KR("6"));
            Log.d("MicroMsg.SellerABTestManager", "endABTestWhenFinishBlock, snsSvrId:%d, isBlock:%b, scene:%d, actionResult:%s", Long.valueOf(j2), Boolean.valueOf(z), 3, str);
        }
        AppMethodBeat.o(94959);
    }

    static /* synthetic */ void Z(Context context, String str) {
        AppMethodBeat.i(94960);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            String userName = aQl.getUserName();
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", userName);
            intent.putExtra("sns_permission_snsinfo_svr_id", aQl.field_snsId);
            intent.putExtra("sns_permission_block_scene", 7);
            intent.setClass(context, SnsPermissionUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/abtest/SellerABTestManager", "startBlockSeller", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            a.a(context, "com/tencent/mm/plugin/sns/abtest/SellerABTestManager", "startBlockSeller", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(94960);
    }
}
