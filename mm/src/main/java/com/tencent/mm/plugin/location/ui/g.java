package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;

public final class g implements f.c, i.a {
    private Context context;
    private String gxP = "";
    private ViewGroup yIT;
    private View yIU;
    private f yIV;
    private h yIW;
    private ArrayList<String> yIX;
    private String yIY = "";
    private boolean yIZ = false;
    private d yJa;
    public a yJb;

    public interface a {
        void aDg(String str);
    }

    public g(Context context2, ViewGroup viewGroup, View view, String str, d dVar) {
        AppMethodBeat.i(55913);
        this.yIT = viewGroup;
        this.yIU = view;
        this.context = context2;
        this.yIX = new ArrayList<>();
        this.gxP = str;
        this.yJa = dVar;
        init();
        AppMethodBeat.o(55913);
    }

    private void init() {
        AppMethodBeat.i(55914);
        Log.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", this.gxP);
        this.yIV = new f(this.context, this.yIU, this.gxP);
        this.yIV.yIL = this;
        this.yIW = new h(this.context, this.yIT, this.gxP);
        for (String str : n.ecS().PY(this.gxP)) {
            this.yIX.add(str);
        }
        AppMethodBeat.o(55914);
    }

    public final void aw(ArrayList<String> arrayList) {
        AppMethodBeat.i(55915);
        Log.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
        this.yIV.aw(arrayList);
        h hVar = this.yIW;
        Log.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (hVar.hXt.indexOf(next) == -1) {
                arrayList2.add(next);
            }
        }
        Iterator<String> it2 = hVar.hXt.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (arrayList.indexOf(next2) == -1) {
                arrayList3.add(next2);
            }
        }
        if (hVar.yJo) {
            hVar.yJo = false;
            if (arrayList2.size() > 0) {
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    hVar.hXt.add((String) it3.next());
                }
            }
            hVar.qH(false);
            AppMethodBeat.o(55915);
            return;
        }
        if (arrayList2.size() > 0) {
            String str = (String) arrayList2.get(0);
            hVar.hXt.add(str);
            if (!Util.isNullOrNil(aa.getDisplayName(str))) {
                hVar.mHandler.removeMessages(3);
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = str;
                hVar.mHandler.sendMessage(obtain);
                hVar.qH(true);
            }
        }
        if (arrayList3.size() > 0) {
            String str2 = (String) arrayList3.get(0);
            if (!Util.isNullOrNil(str2) && hVar.hXt.indexOf(str2) != -1) {
                hVar.hXt.remove(hVar.hXt.indexOf(str2));
                if (!Util.isNullOrNil(aa.getDisplayName(str2))) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 4;
                    obtain2.obj = str2;
                    hVar.mHandler.sendMessage(obtain2);
                    hVar.qH(true);
                }
            }
        }
        AppMethodBeat.o(55915);
    }

    @Override // com.tencent.mm.plugin.location.ui.f.c
    public final void aDg(String str) {
        AppMethodBeat.i(55916);
        if (this.yJb != null) {
            this.yJb.aDg(str);
        }
        AppMethodBeat.o(55916);
    }

    @Override // com.tencent.mm.plugin.location.ui.i.a
    public final void edq() {
        AppMethodBeat.i(55917);
        Log.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
        this.yIZ = true;
        String aTY = z.aTY();
        this.yIV.edm();
        this.yIV.aDd(aTY);
        h hVar = this.yIW;
        Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
        hVar.mHandler.removeMessages(6);
        hVar.mHandler.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 6;
        hVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        Object viewByItag = this.yJa.getViewByItag(aTY);
        if (viewByItag instanceof TrackPoint) {
            ((TrackPoint) viewByItag).set2Top();
        }
        this.yIY = aTY;
        AppMethodBeat.o(55917);
    }

    @Override // com.tencent.mm.plugin.location.ui.i.a
    public final void aDh(String str) {
        AppMethodBeat.i(55918);
        Log.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", str);
        if (this.yIZ) {
            AppMethodBeat.o(55918);
            return;
        }
        this.yIY = str;
        f fVar = this.yIV;
        String str2 = this.yIY;
        Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", str2);
        if (Util.isNullOrNil(str2)) {
            fVar.edm();
        } else {
            fVar.edm();
            fVar.aDd(str2);
        }
        h hVar = this.yIW;
        String str3 = this.yIY;
        Log.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", str3);
        if (!Util.isNullOrNil(str3)) {
            if (!Util.isNullOrNil(aa.getDisplayName(str3))) {
                hVar.yJt = true;
                hVar.mHandler.removeMessages(5);
                Message obtain = Message.obtain();
                obtain.what = 5;
                obtain.obj = str3;
                hVar.mHandler.sendMessageAtFrontOfQueue(obtain);
            }
            hVar.qH(true);
        } else {
            hVar.yJt = false;
            hVar.mHandler.removeMessages(10);
            Message obtain2 = Message.obtain();
            obtain2.what = 10;
            hVar.mHandler.sendMessage(obtain2);
            hVar.qH(true);
        }
        Object viewByItag = this.yJa.getViewByItag(this.yIY);
        if (viewByItag instanceof TrackPoint) {
            ((TrackPoint) viewByItag).set2Top();
        }
        AppMethodBeat.o(55918);
    }

    @Override // com.tencent.mm.plugin.location.ui.i.a
    public final void edr() {
        AppMethodBeat.i(55919);
        Log.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
        f fVar = this.yIV;
        String aTY = z.aTY();
        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", aTY);
        if (fVar.yIJ.aDf(aTY)) {
            fVar.yIJ.aDe(aTY).edp();
            fVar.yIJ.notifyDataSetChanged();
            fVar.yII.invalidate();
        }
        h hVar = this.yIW;
        Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
        hVar.mHandler.removeMessages(9);
        hVar.mHandler.removeMessages(10);
        Message obtain = Message.obtain();
        obtain.what = 9;
        hVar.mHandler.sendMessage(obtain);
        this.yIY = "";
        this.yIZ = false;
        AppMethodBeat.o(55919);
    }

    @Override // com.tencent.mm.plugin.location.ui.i.a
    public final void eds() {
        AppMethodBeat.i(55920);
        h hVar = this.yIW;
        Log.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
        hVar.mHandler.removeMessages(8);
        Message obtain = Message.obtain();
        obtain.what = 8;
        hVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        AppMethodBeat.o(55920);
    }

    @Override // com.tencent.mm.plugin.location.ui.i.a
    public final void aDi(String str) {
        AppMethodBeat.i(55921);
        h hVar = this.yIW;
        Log.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", str);
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(aa.getDisplayName(str))) {
            hVar.yJt = true;
            hVar.mHandler.removeMessages(7);
            Message obtain = Message.obtain();
            obtain.what = 7;
            hVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        }
        AppMethodBeat.o(55921);
    }
}
