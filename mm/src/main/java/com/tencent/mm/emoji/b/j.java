package com.tencent.mm.emoji.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a;
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class j {
    private static j gXe;
    private boolean gXf = true;
    private boolean gXg = true;
    public boolean gXh = true;
    private boolean gXi = true;
    private boolean gXj = true;
    public ArrayList<EmojiGroupInfo> gXk = new ArrayList<>();
    public final LruCache<String, ArrayList<EmojiInfo>> gXl = new LruCache<String, ArrayList<EmojiInfo>>() {
        /* class com.tencent.mm.emoji.b.j.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.platformtools.LruCache
        public final /* synthetic */ int sizeOf(String str, ArrayList<EmojiInfo> arrayList) {
            AppMethodBeat.i(199752);
            ArrayList<EmojiInfo> arrayList2 = arrayList;
            if (arrayList2 == null) {
                AppMethodBeat.o(199752);
                return 0;
            }
            int size = arrayList2.size();
            AppMethodBeat.o(199752);
            return size;
        }
    };
    private final HashMap<String, PersonalDesigner> gXm = new HashMap<>();
    private final ajd gXn = new ajd();
    public String gXo;

    public static synchronized j auL() {
        j jVar;
        synchronized (j.class) {
            AppMethodBeat.i(104441);
            if (gXe == null) {
                gXe = new j();
            }
            jVar = gXe;
            AppMethodBeat.o(104441);
        }
        return jVar;
    }

    private j() {
        AppMethodBeat.i(104442);
        if (MMApplicationContext.isMainProcess()) {
            this.gXo = (String) g.aAh().azQ().get(-29414086, ad.avB());
            byte[] bArr = bj.gCJ().OpQ.get("cache_type_user_data");
            if (!Util.isNullOrNil(bArr)) {
                try {
                    this.gXn.parseFrom(bArr);
                    AppMethodBeat.o(104442);
                    return;
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.EmojiStorageCache", e2, "parse user data error", new Object[0]);
                }
            }
            AppMethodBeat.o(104442);
            return;
        }
        a.gvc();
        a.b bVar = a.NCN;
        this.gXo = a.b.dg(-29414086, ad.avB());
        AppMethodBeat.o(104442);
    }

    public final ajd auM() {
        return this.gXn;
    }

    public final void auN() {
        AppMethodBeat.i(199753);
        try {
            bj.gCJ().OpQ.l("cache_type_user_data", this.gXn.toByteArray());
            AppMethodBeat.o(199753);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.EmojiStorageCache", e2, "save user data error", new Object[0]);
            AppMethodBeat.o(199753);
        }
    }

    public final ArrayList<EmojiInfo> dT(boolean z) {
        ArrayList parcelableArrayList;
        AppMethodBeat.i(104443);
        Log.d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", Boolean.valueOf(z));
        ArrayList<EmojiInfo> arrayList = this.gXl.get("custom");
        if (arrayList == null || this.gXg) {
            Log.i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", Boolean.valueOf(this.gXg));
            if (g.aAe().azG().aBb()) {
                f fVar = bj.gCJ().OpN;
                ArrayList<EmojiInfo> arrayList2 = new ArrayList<>();
                List<EmojiInfo> bE = fVar.bE(EmojiGroupInfo.VkO, false);
                if (bE.size() < 2) {
                    fVar.init(MMApplicationContext.getContext());
                    bE = fVar.bE(EmojiGroupInfo.VkO, false);
                    h.INSTANCE.dN(1062, 0);
                }
                arrayList2.addAll(fVar.bE(EmojiGroupInfo.VkP, false));
                arrayList2.addAll(bE);
                arrayList = arrayList2;
            } else {
                arrayList = new ArrayList<>();
                Bundle call = a.call(a.getUri(), "getAllCustomEmoji", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("data") && (parcelableArrayList = call.getParcelableArrayList("data")) != null) {
                        arrayList.addAll(parcelableArrayList);
                        Log.i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", Integer.valueOf(parcelableArrayList.size()));
                    }
                }
            }
            this.gXl.put("custom", arrayList);
        }
        this.gXg = false;
        AppMethodBeat.o(104443);
        return arrayList;
    }

    public final ArrayList<EmojiInfo> auO() {
        AppMethodBeat.i(104444);
        ArrayList<EmojiInfo> arrayList = this.gXl.get("download_custom");
        if (arrayList == null || this.gXf) {
            if (g.aAe().azG().aBb()) {
                f fVar = bj.gCJ().OpN;
                ArrayList<EmojiInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(fVar.bE(EmojiGroupInfo.VkP, true));
                arrayList = arrayList2;
                this.gXl.put("download_custom", arrayList);
            } else {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("need get from main process");
                AppMethodBeat.o(104444);
                throw unsupportedOperationException;
            }
        }
        this.gXf = false;
        AppMethodBeat.o(104444);
        return arrayList;
    }

    public final ArrayList<EmojiInfo> EQ(String str) {
        ArrayList parcelableArrayList;
        AppMethodBeat.i(104445);
        if (this.gXh) {
            this.gXl.evictAll();
            this.gXh = false;
        }
        ArrayList<EmojiInfo> arrayList = this.gXl.get(str);
        if (arrayList == null) {
            if (g.aAe().azG().aBb()) {
                arrayList = (ArrayList) bj.gCJ().OpN.amo(str);
            } else {
                arrayList = new ArrayList<>();
                Bundle call = a.call(a.getUri(), "getEmojiListByGroupId", String.valueOf(str), null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("data") && (parcelableArrayList = call.getParcelableArrayList("data")) != null) {
                        arrayList.addAll(parcelableArrayList);
                        Log.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", Integer.valueOf(parcelableArrayList.size()));
                    }
                }
            }
            this.gXl.put(str, arrayList);
        }
        AppMethodBeat.o(104445);
        return arrayList;
    }

    public final PersonalDesigner ER(String str) {
        byte[] bArr;
        byte[] bArr2 = null;
        AppMethodBeat.i(183920);
        if (!this.gXm.containsKey(str)) {
            if (g.aAe().azG().aBb()) {
                l blt = bj.gCJ().OpR.blt(str);
                if (blt != null) {
                    bArr = blt.field_content;
                } else {
                    bArr = null;
                }
            } else {
                Bundle call = a.call(a.getUri(), "getDesignerInfo", str, null);
                if (call.containsKey("buffer")) {
                    bArr2 = call.getByteArray("buffer");
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
                try {
                    getEmotionDetailResponse.parseFrom(bArr);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.EmojiStorageCache", e2, "", new Object[0]);
                }
                if (!(getEmotionDetailResponse.EmotionDetail == null || getEmotionDetailResponse.EmotionDetail.PersonalDesigner == null)) {
                    this.gXm.put(str, getEmotionDetailResponse.EmotionDetail.PersonalDesigner);
                }
            }
        }
        PersonalDesigner personalDesigner = this.gXm.get(str);
        AppMethodBeat.o(183920);
        return personalDesigner;
    }

    public final ArrayList<EmojiGroupInfo> auP() {
        ArrayList parcelableArrayList;
        AppMethodBeat.i(104446);
        if (this.gXi) {
            if (g.aAe().azG().aBb()) {
                this.gXk = bj.gCJ().OpO.gEL();
            } else {
                ArrayList<EmojiGroupInfo> arrayList = new ArrayList<>();
                Bundle call = a.call(a.getUri(), "getEmojiGroupInfoList", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiGroupInfo.class.getClassLoader());
                    if (call.containsKey("data") && (parcelableArrayList = call.getParcelableArrayList("data")) != null) {
                        arrayList.addAll(parcelableArrayList);
                        Log.i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", Integer.valueOf(parcelableArrayList.size()));
                    }
                }
                this.gXk = arrayList;
            }
        }
        this.gXi = false;
        ArrayList<EmojiGroupInfo> arrayList2 = this.gXk;
        AppMethodBeat.o(104446);
        return arrayList2;
    }

    public final ArrayList<EmojiInfo> dU(boolean z) {
        ArrayList parcelableArrayList;
        AppMethodBeat.i(104447);
        Log.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", Boolean.valueOf(this.gXj), Boolean.valueOf(z));
        ArrayList<EmojiInfo> arrayList = this.gXl.get("capture");
        if (arrayList == null || this.gXj) {
            if (g.aAe().azG().aBb()) {
                arrayList = (ArrayList) bj.gCJ().OpN.AN(false);
            } else {
                arrayList = new ArrayList<>();
                Bundle call = a.call(a.getUri(), "getCaptureEmoji", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("key_data") && (parcelableArrayList = call.getParcelableArrayList("key_data")) != null) {
                        arrayList.addAll(parcelableArrayList);
                        Log.i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", Integer.valueOf(parcelableArrayList.size()));
                    }
                }
            }
            Log.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", Boolean.valueOf(this.gXj), Integer.valueOf(arrayList.size()));
            this.gXl.put("capture", arrayList);
        }
        this.gXj = false;
        if (z) {
            Log.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji list size: %s.", Integer.valueOf(arrayList.size()));
            AppMethodBeat.o(104447);
            return arrayList;
        }
        ArrayList<EmojiInfo> arrayList2 = new ArrayList<>();
        Iterator<EmojiInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            EmojiInfo next = it.next();
            if (next.hYs() == EmojiInfo.a.STATUS_SUCCESS) {
                arrayList2.add(next);
            }
        }
        Log.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", Integer.valueOf(arrayList2.size()));
        AppMethodBeat.o(104447);
        return arrayList2;
    }

    public final void dV(boolean z) {
        AppMethodBeat.i(104448);
        this.gXg = true;
        Log.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.KEY_TYPE, EmojiUpdateReceiver.hdn);
            MMApplicationContext.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(104448);
    }

    public final void dW(boolean z) {
        AppMethodBeat.i(104449);
        this.gXf = true;
        Log.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.KEY_TYPE, EmojiUpdateReceiver.hdo);
            MMApplicationContext.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(104449);
    }

    public final void dX(boolean z) {
        AppMethodBeat.i(104450);
        this.gXi = true;
        Log.i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.KEY_TYPE, EmojiUpdateReceiver.hdq);
            MMApplicationContext.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(104450);
    }

    public final void dY(boolean z) {
        AppMethodBeat.i(104451);
        this.gXj = true;
        if (z) {
            String str = EmojiUpdateReceiver.hdr;
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.KEY_TYPE, str);
            MMApplicationContext.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(104451);
    }

    public final boolean l(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104452);
        synchronized (this.gXl) {
            try {
                for (ArrayList<EmojiInfo> arrayList : this.gXl.values()) {
                    Iterator<EmojiInfo> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getMd5().equals(emojiInfo.getMd5())) {
                                return true;
                            }
                        }
                    }
                }
                AppMethodBeat.o(104452);
                return false;
            } finally {
                AppMethodBeat.o(104452);
            }
        }
    }
}
