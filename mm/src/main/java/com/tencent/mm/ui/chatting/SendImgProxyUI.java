package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.p;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI extends MMBaseActivity {
    private static boolean isRunning = false;
    private q nUq = null;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(34890);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ao.e(getWindow());
        Log.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        if (isRunning) {
            Log.w("MicroMsg.SendImgProxyUI", "duplicate instance");
            finish();
            AppMethodBeat.o(34890);
            return;
        }
        isRunning = true;
        setContentView(R.layout.hl);
        this.nUq = h.a((Context) this, getString(R.string.evg), false, (DialogInterface.OnCancelListener) null);
        final boolean isWifi = NetStatusUtil.isWifi(this);
        boolean z = WXHardCoderJNI.hcSendPicMsgEnable;
        int i3 = WXHardCoderJNI.hcSendPicMsgDelay;
        int i4 = WXHardCoderJNI.hcSendPicMsgCPU;
        int i5 = WXHardCoderJNI.hcSendPicMsgIO;
        if (WXHardCoderJNI.hcSendPicMsgThr) {
            i2 = g.aAk().getProcessTid();
        }
        final int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.SendImgProxyUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(34889);
                Log.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
                SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(-1);
                bg.aAk().setLowPriority();
                Log.i("MicroMsg.SendImgProxyUI", "test before finish");
                SendImgProxyUI.this.nUq.dismiss();
                SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
                boolean unused = SendImgProxyUI.isRunning = false;
                SendImgProxyUI.this.finish();
                if (NetStatusUtil.isWifi(SendImgProxyUI.this) == isWifi) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendPicMsgEnable, startPerformance);
                }
                AppMethodBeat.o(34889);
            }
        });
        AppMethodBeat.o(34890);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(34891);
        Log.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        super.onDestroy();
        AppMethodBeat.o(34891);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(34892);
        Log.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        super.onResume();
        AppMethodBeat.o(34892);
    }

    private static ArrayList<String> a(ArrayList<String> arrayList, int i2, ArrayList<String> arrayList2, boolean z) {
        AppMethodBeat.i(34893);
        ArrayList<String> arrayList3 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (ImgUtil.isImgFile(next)) {
                    long boW = s.boW(next);
                    if (z || boW <= ((long) i2)) {
                        arrayList3.add(next);
                    } else {
                        arrayList2.add(next);
                    }
                }
            }
        }
        AppMethodBeat.o(34893);
        return arrayList3;
    }

    private static void h(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        AppMethodBeat.i(34894);
        if (arrayList.size() != arrayList2.size()) {
            Log.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
            AppMethodBeat.o(34894);
            return;
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            int intValue = arrayList.get(i2).intValue();
            com.tencent.mm.av.g tl = com.tencent.mm.av.q.bcR().tl(intValue);
            int boW = (int) s.boW(arrayList2.get(i2));
            tl.setOffset(boW);
            tl.tf(boW);
            com.tencent.mm.av.q.bcR().a(intValue, tl);
            long j2 = tl.iXv;
            Log.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", Long.valueOf(j2), Integer.valueOf(intValue));
            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
            Hb.setStatus(5);
            Hb.nc(256);
            ((l) g.af(l.class)).eiy().a(j2, Hb);
            Log.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(Hb.field_msgId), Long.valueOf(Hb.field_msgSvrId), Hb.field_talker, Integer.valueOf(Hb.getType()), Integer.valueOf(Hb.field_isSend), Hb.field_imgPath, Integer.valueOf(Hb.field_status), Long.valueOf(Hb.field_createTime));
        }
        AppMethodBeat.o(34894);
    }

    static /* synthetic */ void a(SendImgProxyUI sendImgProxyUI, Intent intent) {
        AppMethodBeat.i(34895);
        if (intent == null) {
            Log.e("MicroMsg.SendImgProxyUI", "data is empty!");
            AppMethodBeat.o(34895);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
        intent.getStringExtra("GalleryUI_ToUser");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> a2 = a(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_limit_Img_Size", 26214400), arrayList, booleanExtra);
        intent.putStringArrayListExtra("CropImage_OutputPath_List", a2);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (a2.size() == 0 && arrayList.size() == 0 && (stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
            Toast.makeText(sendImgProxyUI, sendImgProxyUI.getString(R.string.dly), 0).show();
            Log.e("MicroMsg.SendImgProxyUI", "filelist is empty!");
            AppMethodBeat.o(34895);
            return;
        }
        int intExtra = intent.getIntExtra("from_source", 0);
        int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
        String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
        Log.d("MicroMsg.SendImgProxyUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
        if (stringExtra == null) {
            Log.e("MicroMsg.SendImgProxyUI", "toUserName is null");
            AppMethodBeat.o(34895);
            return;
        }
        if (arrayList.size() > 0) {
            p.bcF().a(arrayList, true, intExtra, intExtra2, stringExtra);
            h(p.bcF().OK(stringExtra), arrayList);
            Log.e("MicroMsg.SendImgProxyUI", "overSizeList size:%s!", Integer.valueOf(arrayList.size()));
        }
        p.bcF().a(a2, booleanExtra, intExtra, intExtra2, stringExtra);
        AppMethodBeat.o(34895);
    }
}
