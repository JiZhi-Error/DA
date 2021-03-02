package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.b.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/GetImageListRecommendAudioTask;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "scene", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/util/ArrayList;I)V", "imageList", "nextBitmap", "Landroid/graphics/Bitmap;", FirebaseAnalytics.b.INDEX, "onFinishImageData", "", "onPrepareImageData", "plugin-recordvideo_release"})
public final class g extends a {
    private ArrayList<String> BLy = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(b<a> bVar, ArrayList<String> arrayList, int i2) {
        super(bVar);
        p.h(bVar, "lifeCycleKeeper");
        p.h(arrayList, "images");
        AppMethodBeat.i(75426);
        this.BLy.addAll(arrayList);
        this.scene = i2;
        AppMethodBeat.o(75426);
    }

    @Override // com.tencent.mm.plugin.recordvideo.model.audio.a
    public final Bitmap VB(int i2) {
        boolean z;
        AppMethodBeat.i(75424);
        ArrayList<String> arrayList = this.BLy;
        if (arrayList == null || arrayList.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Bitmap createBitmap = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
            p.g(createBitmap, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
            AppMethodBeat.o(75424);
            return createBitmap;
        }
        int i3 = this.BOS[i2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.BLy.get(i3), options);
        options.inSampleSize = BitmapUtil.calculateInSampleSize(options.outWidth, options.outHeight, this.thumbWidth, this.thumbHeight);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = MMBitmapFactory.decodeFile(this.BLy.get(i3), options);
        if (decodeFile == null) {
            decodeFile = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
            p.g(decodeFile, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
        }
        AppMethodBeat.o(75424);
        return decodeFile;
    }

    @Override // com.tencent.mm.plugin.recordvideo.model.audio.a
    public final void eJS() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.model.audio.a
    public final void eJR() {
        AppMethodBeat.i(75425);
        if (this.scene == i.Finder.ordinal()) {
            this.pLQ = Util.MILLSECONDS_OF_MINUTE;
        } else {
            this.pLQ = 15000;
        }
        I(new int[]{0, 0, 0});
        if (this.BLy.size() >= 3) {
            this.BOS[1] = this.BLy.size() / 2;
            this.BOS[2] = this.BLy.size() - 1;
            AppMethodBeat.o(75425);
            return;
        }
        if (this.BLy.size() == 2) {
            this.BOS[1] = 1;
            this.BOS[2] = 1;
        }
        AppMethodBeat.o(75425);
    }
}
