package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bb {
    private Activity dKq;
    private List<cnb> list = new ArrayList();

    public bb(Activity activity) {
        AppMethodBeat.i(98728);
        this.dKq = activity;
        AppMethodBeat.o(98728);
    }

    /* access modifiers changed from: package-private */
    public final void v(View view, int i2, int i3) {
        AppMethodBeat.i(98729);
        a(view, i2, i3, null, 0);
        AppMethodBeat.o(98729);
    }

    public final void a(View view, int i2, int i3, bc bcVar, long j2) {
        k tP;
        k tP2;
        AppMethodBeat.i(98730);
        if (view == null) {
            Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", Integer.valueOf(i2));
            AppMethodBeat.o(98730);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof bc) {
            bc bcVar2 = (bc) tag;
            String str = bcVar2.dJX;
            int i4 = bcVar2.index;
            int i5 = bcVar2.position;
            if (!fK(str, i4)) {
                Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i4));
                AppMethodBeat.o(98730);
                return;
            }
            g.aAi();
            if (!g.aAh().isSDCardAvailable()) {
                Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
                AppMethodBeat.o(98730);
                return;
            }
            SnsInfo aQm = f.aQm(str);
            if (!fK(str, i4)) {
                Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i4));
                AppMethodBeat.o(98730);
                return;
            }
            Intent intent = new Intent();
            if (aQm != null) {
                if (bcVar != null) {
                    bcVar.DMa.M(aQm);
                }
                TimeLineObject timeLine = aQm.getTimeLine();
                cnb cnb = bcVar2.index < timeLine.ContentObj.LoV.size() ? timeLine.ContentObj.LoV.get(bcVar2.index) : new cnb();
                if (i2 == 1) {
                    tP = k.tO(716);
                } else {
                    tP = k.tP(716);
                }
                tP.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo()).PH(cnb.Id).tR(bcVar2.index).tR(timeLine.ContentObj.LoV.size());
                tP.bfK();
                if (i2 == 1) {
                    tP2 = k.tO(744);
                } else {
                    tP2 = k.tP(744);
                }
                tP2.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo());
                tP2.b(intent, "intent_key_StatisticsOplog");
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", 3);
                bundle.putString("stat_msg_id", "sns_" + r.Jb(aQm.field_snsId));
                bundle.putString("stat_send_msg_user", aQm.getUserName());
                intent.putExtra("_stat_obj", bundle);
            } else {
                Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
            }
            int[] iArr = new int[2];
            if (ao.gJK()) {
                view.getLocationOnScreen(iArr);
            } else {
                view.getLocationInWindow(iArr);
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (i2 == -1) {
                intent.putExtra("k_is_from_sns_msg_ui", true);
            }
            switch (i2) {
                case -1:
                    intent.putExtra("key_from_scene", 3);
                    break;
                case 1:
                    intent.putExtra("key_from_scene", 1);
                    break;
                case 2:
                    intent.putExtra("key_from_scene", 2);
                    break;
            }
            intent.putExtra("sns_gallery_localId", str);
            intent.putExtra("sns_gallery_position", i4);
            intent.putExtra("sns_position", i5);
            intent.putExtra("sns_gallery_showtype", 1);
            intent.putExtra("K_ad_scene", i2);
            intent.putExtra("K_source", i2);
            intent.putExtra("K_ad_source", i3);
            intent.putExtra("k_is_from_sns_main_timeline", bcVar2.EAv);
            intent.putExtra("sns_gallery_thumb_location", new Rect(iArr[0], iArr[1], width + iArr[0], iArr[1] + height));
            intent.putExtra("sns_ad_exposure_start_time", j2);
            intent.setClass(this.dKq, SnsBrowseUI.class);
            Activity activity = this.dKq;
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.dKq.overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(98730);
    }

    public static void a(Activity activity, Intent intent, SnsInfo snsInfo, bc bcVar, int i2, int i3, ai aiVar) {
        k tP;
        k tP2;
        AppMethodBeat.i(203587);
        if (intent == null) {
            Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
            AppMethodBeat.o(203587);
        } else if (aiVar == null) {
            Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
            AppMethodBeat.o(203587);
        } else if (snsInfo == null) {
            Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
            AppMethodBeat.o(203587);
        } else {
            g.aAi();
            if (!g.aAh().isSDCardAvailable()) {
                Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
                AppMethodBeat.o(203587);
                return;
            }
            String str = bcVar.dJX;
            int i4 = bcVar.index;
            int i5 = bcVar.position;
            TimeLineObject timeLine = snsInfo.getTimeLine();
            if (timeLine.ContentObj == null || timeLine.ContentObj.LoV.size() == 0) {
                Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
                AppMethodBeat.o(203587);
                return;
            }
            aiVar.fat().M(snsInfo);
            TimeLineObject timeLine2 = snsInfo.getTimeLine();
            cnb cnb = i4 < timeLine2.ContentObj.LoV.size() ? timeLine2.ContentObj.LoV.get(i4) : new cnb();
            if (!aj.faL().C(cnb)) {
                Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", Integer.valueOf(cnb.ecf));
                AppMethodBeat.o(203587);
                return;
            }
            if (i2 == 1) {
                tP = k.tO(716);
            } else {
                tP = k.tP(716);
            }
            tP.PH(r.v(snsInfo)).tR(snsInfo.field_type).fL(snsInfo.isAd()).PH(snsInfo.getUxinfo()).PH(cnb.Id).tR(i4).tR(timeLine2.ContentObj.LoV.size());
            tP.bfK();
            if (i2 == 1) {
                tP2 = k.tO(744);
            } else {
                tP2 = k.tP(744);
            }
            tP2.PH(r.v(snsInfo)).tR(snsInfo.field_type).fL(snsInfo.isAd()).PH(snsInfo.getUxinfo());
            tP2.b(intent, "intent_key_StatisticsOplog");
            intent.putExtra("sns_soon_enter_photoedit_ui", true);
            intent.putExtra("sns_gallery_localId", str);
            intent.putExtra("sns_gallery_position", i4);
            intent.putExtra("sns_position", i5);
            intent.putExtra("sns_gallery_showtype", 1);
            intent.putExtra("K_ad_scene", i2);
            intent.putExtra("K_ad_source", i3);
            intent.putExtra("k_is_from_sns_main_timeline", true);
            intent.setClass(activity, SnsBrowseUI.class);
            switch (i2) {
                case -1:
                    intent.putExtra("key_from_scene", 3);
                    break;
                case 1:
                    intent.putExtra("key_from_scene", 1);
                    break;
                case 2:
                    intent.putExtra("key_from_scene", 2);
                    break;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 3);
            bundle.putString("stat_msg_id", "sns_" + r.Jb(snsInfo.field_snsId));
            bundle.putString("stat_send_msg_user", snsInfo.getUserName());
            intent.putExtra("_stat_obj", bundle);
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.overridePendingTransition(0, 0);
            AppMethodBeat.o(203587);
        }
    }

    private boolean fK(String str, int i2) {
        AppMethodBeat.i(98731);
        SnsInfo aQm = f.aQm(str);
        if (aQm == null) {
            Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", str, Integer.valueOf(i2));
            AppMethodBeat.o(98731);
            return false;
        }
        TimeLineObject timeLine = aQm.getTimeLine();
        if (timeLine.ContentObj == null) {
            Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
            AppMethodBeat.o(98731);
            return false;
        } else if (timeLine.ContentObj.LoV.size() == 0) {
            Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
            AppMethodBeat.o(98731);
            return false;
        } else {
            this.list.clear();
            Iterator<cnb> it = timeLine.ContentObj.LoV.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                cnb next = it.next();
                this.list.add(next);
                if (i2 != i3 || aj.faL().C(next)) {
                    i3++;
                } else {
                    Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
                    AppMethodBeat.o(98731);
                    return false;
                }
            }
            AppMethodBeat.o(98731);
            return true;
        }
    }
}
