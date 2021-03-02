package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class g {
    public int rbs;
    public List<f> rbt;
    public EmotionBanner rbu;
    public List<EmotionBanner> rbv;
    public List<EmotionBannerSet> rbw;
    public List<EmotionBannerSet> rbx;

    public final void FX(int i2) {
        this.rbs += i2;
    }

    public final void cFZ() {
        AppMethodBeat.i(108587);
        if (this.rbx == null) {
            AppMethodBeat.o(108587);
        } else if (this.rbx.isEmpty()) {
            AppMethodBeat.o(108587);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.rbx);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.rbt.add(0, new f((EmotionBannerSet) arrayList.get(size)));
                this.rbs++;
                this.rbx.remove(arrayList.get(size));
            }
            AppMethodBeat.o(108587);
        }
    }

    public final void dg(List<f> list) {
        f fVar;
        AppMethodBeat.i(108588);
        if (this.rbt == null) {
            this.rbt = new ArrayList();
        } else {
            int size = this.rbt.size() - 1;
            if (size >= 0 && size < this.rbt.size() && (fVar = this.rbt.get(size)) != null && fVar.qYl != null && !Util.isNullOrNil(fVar.qYl.ProductID) && fVar.qYl.ProductID.equals(new StringBuilder().append(EmojiGroupInfo.VkN).toString())) {
                this.rbt.remove(fVar);
            }
        }
        this.rbt.addAll(list);
        AppMethodBeat.o(108588);
    }
}
