package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c implements h.b {
    public static Map<String, View> BJe = new HashMap();
    private h.a BHR;
    private View.OnClickListener dec = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.record.ui.b.c.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(28028);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.record.ui.a.b bVar2 = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            if (bVar2.dataType == 0) {
                if (p.d(bVar2.dKT, bVar2.msgId)) {
                    Log.i("MicroMsg.SightViewWrapper", "onclick: play sight");
                    Intent intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                    intent.putExtra("message_id", bVar2.msgId);
                    intent.putExtra("record_xml", bVar2.dXH);
                    intent.putExtra("record_data_id", bVar2.dKT.dLl);
                    Context context = view.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(context, bl.axQ(), "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    a.a(context, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    j aKX = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(p.g(bVar2.dKT.dLl, bVar2.msgId, true));
                    Object[] objArr = new Object[1];
                    objArr[0] = aKX == null ? BuildConfig.COMMAND : Integer.valueOf(aKX.field_status);
                    Log.i("MicroMsg.SightViewWrapper", "onclick: cdnInfo status %s", objArr);
                    if (!(aKX == null || 2 == aKX.field_status || 3 == aKX.field_status)) {
                        if (4 == aKX.field_status) {
                            com.tencent.mm.ui.base.h.cD(view.getContext(), view.getResources().getString(R.string.cbl));
                            a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(28028);
                            return;
                        } else if (aKX.field_status == 0 || 1 == aKX.field_status) {
                            a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(28028);
                            return;
                        }
                    }
                    p.b(bVar2.dKT, bVar2.msgId, true);
                }
            } else if (bVar2.dataType == 1) {
                Log.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(bVar2.qNT.field_id), Long.valueOf(bVar2.qNT.field_localId), Integer.valueOf(bVar2.qNT.field_itemStatus));
                if (bVar2.qNT.isDone()) {
                    hb hbVar = new hb();
                    hbVar.dLm.type = 14;
                    hbVar.dLm.dLo = bVar2.dKT;
                    EventCenter.instance.publish(hbVar);
                    Log.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", Integer.valueOf(hbVar.dLn.ret));
                    if (hbVar.dLn.ret == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_detail_info_id", bVar2.qNT.field_localId);
                        intent2.putExtra("key_detail_data_id", bVar2.dKT.dLl);
                        intent2.putExtra("key_detail_can_delete", false);
                        com.tencent.mm.plugin.fav.a.b.a(view.getContext(), ".ui.detail.FavoriteFileDetailUI", intent2, 1);
                        a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(28028);
                        return;
                    } else if (Util.isNullOrNil(bVar2.dKT.KuR)) {
                        Log.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                        a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(28028);
                        return;
                    } else {
                        Log.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (bVar2.qNT.cUz() || bVar2.qNT.cUy()) {
                    Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                } else if (bVar2.qNT.isDownloading() || bVar2.qNT.cUx()) {
                    Log.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                    a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(28028);
                    return;
                } else {
                    Log.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                }
                hb hbVar2 = new hb();
                hbVar2.dLm.dFW = bVar2.qNT.field_localId;
                if (bVar2.qNT.cUy()) {
                    Log.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                    hbVar2.dLm.type = 15;
                    EventCenter.instance.publish(hbVar2);
                } else {
                    Log.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                    hbVar2.dLm.type = 16;
                    EventCenter.instance.publish(hbVar2);
                }
            }
            a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/SightViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28028);
        }
    };

    public c(h.a aVar) {
        AppMethodBeat.i(28029);
        this.BHR = aVar;
        AppMethodBeat.o(28029);
    }

    static {
        AppMethodBeat.i(28032);
        AppMethodBeat.o(28032);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final View createView(Context context) {
        AppMethodBeat.i(28030);
        View inflate = View.inflate(context, R.layout.bln, null);
        ((com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.id.dup)).setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(context, 260));
        AppMethodBeat.o(28030);
        return inflate;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void a(View view, int i2, com.tencent.mm.plugin.record.ui.a.b bVar, Object obj) {
        AppMethodBeat.i(28031);
        view.setTag(bVar);
        view.setOnClickListener(this.dec);
        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.id.dup);
        ImageView imageView = (ImageView) view.findViewById(R.id.i59);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.id.gl7);
        aVar.setPosition(i2);
        com.tencent.mm.plugin.record.ui.a.c cVar = (com.tencent.mm.plugin.record.ui.a.c) bVar;
        h.a aVar2 = this.BHR;
        Map<String, View> map = BJe;
        h.a.c cVar2 = new h.a.c();
        cVar2.dKT = cVar.dKT;
        if (cVar.dataType == 0) {
            cVar2.BHU = cVar.msgId;
            if (p.d(cVar.dKT, cVar.msgId)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                String c2 = p.c(cVar.dKT, cVar.msgId);
                if (!c2.equals(aVar.getVideoPath())) {
                    aVar.setThumbBmp(aVar2.a(cVar2));
                }
                aVar.e(c2, false, 0);
                AppMethodBeat.o(28031);
                return;
            }
            j aKX = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(p.g(cVar.dKT.dLl, cVar.msgId, true));
            if (aKX == null || 2 == aKX.field_status) {
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            } else if (3 == aKX.field_status || 4 == aKX.field_status) {
                imageView.setImageResource(R.drawable.btc);
            } else if (aKX.field_status == 0 || 1 == aKX.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) aKX.field_offset) / ((float) Math.max(1, aKX.field_totalLen))) * 100.0f));
                aVar.clear();
                aVar.setThumbBmp(aVar2.a(cVar2));
                AppMethodBeat.o(28031);
                return;
            } else {
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.setThumbBmp(aVar2.a(cVar2));
            AppMethodBeat.o(28031);
            return;
        }
        if (cVar.dataType == 1) {
            map.put(cVar.dKT.dLl, view);
            Log.d("MicroMsg.SightRecordData", "dataId %s, status %s", Long.valueOf(cVar.qNT.field_localId), Integer.valueOf(cVar.qNT.field_itemStatus));
            cVar2.BHU = cVar.qNT.field_localId;
            hb hbVar = new hb();
            hbVar.dLm.type = 14;
            hbVar.dLm.dLo = cVar.dKT;
            EventCenter.instance.publish(hbVar);
            if (cVar.qNT.isDone() || hbVar.dLn.ret == 1) {
                if (hbVar.dLn.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    hbVar.dLm.type = 2;
                    EventCenter.instance.publish(hbVar);
                    String str = hbVar.dLn.path;
                    if (Util.isNullOrNil(str)) {
                        Log.w("MicroMsg.SightRecordData", "videoPath is null!");
                        AppMethodBeat.o(28031);
                        return;
                    }
                    if (!str.equals(aVar.getVideoPath())) {
                        aVar.setThumbBmp(aVar2.a(cVar2));
                    }
                    aVar.e(str, false, 0);
                    AppMethodBeat.o(28031);
                    return;
                } else if (Util.isNullOrNil(cVar.dKT.KuR)) {
                    imageView.setImageResource(R.drawable.btc);
                } else {
                    Log.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(R.raw.shortvideo_play_btn);
                }
            } else if (cVar.qNT.cUz() || cVar.qNT.cUy()) {
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            } else if (cVar.qNT.isDownloading()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.gYN();
                aVar.clear();
                aVar.setThumbBmp(aVar2.a(cVar2));
                AppMethodBeat.o(28031);
                return;
            } else {
                Log.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.setThumbBmp(aVar2.a(cVar2));
        }
        AppMethodBeat.o(28031);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void destroy() {
        this.BHR = null;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void pause() {
    }
}
