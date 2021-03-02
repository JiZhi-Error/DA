package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class c implements StackUpLayout.a {
    private static final int[] Dzz = {0, 1, 2};
    private static final Map<String, int[]> map = new ArrayMap();
    private String Dsr;
    private d Dzw;
    private int[] Dzx = Dzz;
    private String Dzy;

    public final void a(StackUpLayout stackUpLayout, SnsInfo snsInfo) {
        AppMethodBeat.i(202274);
        try {
            b(stackUpLayout, snsInfo);
            AppMethodBeat.o(202274);
        } catch (Throwable th) {
            Log.w("SnsAd.Participants", "injectAdapter error " + th.getMessage());
            AppMethodBeat.o(202274);
        }
    }

    private void b(StackUpLayout stackUpLayout, SnsInfo snsInfo) {
        AppMethodBeat.i(202275);
        if (stackUpLayout == null || snsInfo == null) {
            Log.w("SnsAd.Participants", "the input layout or sns information is null!!");
            AppMethodBeat.o(202275);
            return;
        }
        String v = r.v(snsInfo);
        if (TextUtils.isEmpty(v) || v.equals(this.Dsr)) {
            Log.w("SnsAd.Participants", "the sns id is empty or same as last one!!");
            AppMethodBeat.o(202275);
            return;
        }
        d o = o(snsInfo);
        if (o == null) {
            Log.w("SnsAd.Participants", "i think you are crazy!!!! Why is the topic-info null?");
            AppMethodBeat.o(202275);
            return;
        }
        this.Dsr = v;
        this.Dzw = o;
        int size = o.DrR == null ? 0 : o.DrR.size();
        eYa();
        this.Dzx = ah(v, eYa(), size);
        if (stackUpLayout != null) {
            stackUpLayout.setAdapter(this);
        }
        AppMethodBeat.o(202275);
    }

    private String eYa() {
        AppMethodBeat.i(202276);
        if (TextUtils.isEmpty(this.Dzy)) {
            g.aAf();
            this.Dzy = a.ayV();
        }
        String str = this.Dzy;
        AppMethodBeat.o(202276);
        return str;
    }

    private static d o(SnsInfo snsInfo) {
        AppMethodBeat.i(202277);
        if (snsInfo == null || snsInfo.getAdXml() == null) {
            Log.w("SnsAd.Participants", "the sns info or ad xml is null!!");
            AppMethodBeat.o(202277);
            return null;
        }
        d dVar = snsInfo.getAdXml().adFinderTopicInfo;
        AppMethodBeat.o(202277);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout.a
    public final int getItemCount() {
        AppMethodBeat.i(202278);
        try {
            d dVar = this.Dzw;
            if (dVar == null) {
                AppMethodBeat.o(202278);
                return 0;
            }
            List<String> list = dVar.DrR;
            if (list == null) {
                AppMethodBeat.o(202278);
                return 0;
            }
            int min = Math.min(list.size(), 3);
            AppMethodBeat.o(202278);
            return min;
        } catch (Throwable th) {
            Log.w("SnsAd.Participants", "getItemCount error ");
            AppMethodBeat.o(202278);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout.a
    public final void av(View view, int i2) {
        AppMethodBeat.i(202279);
        try {
            d dVar = this.Dzw;
            if (dVar == null) {
                AppMethodBeat.o(202279);
                return;
            }
            List<String> list = dVar.DrR;
            int[] iArr = this.Dzx;
            if (com.tencent.e.d.b.a.isEmpty(list) || com.tencent.mm.plugin.sns.ad.i.c.K(iArr)) {
                AppMethodBeat.o(202279);
                return;
            }
            if (i2 >= 0 && i2 < iArr.length && iArr[i2] >= 0 && iArr[i2] < list.size() && (view instanceof ImageView)) {
                b.a(list.get(iArr[i2]), (ImageView) view, 2);
            }
            AppMethodBeat.o(202279);
        } catch (Throwable th) {
            Log.w("SnsAd.Participants", "fillChildView error ");
            AppMethodBeat.o(202279);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout.a
    public final View j(Context context, int i2, int i3) {
        AppMethodBeat.i(202280);
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(context);
        roundCornerImageView.setLayoutParams(new ViewGroup.LayoutParams(i2, i3));
        roundCornerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        roundCornerImageView.lx(com.tencent.mm.cb.a.fromDPToPix(context, 1), context.getResources().getColor(R.color.f3045c));
        roundCornerImageView.ly(i2, i3);
        roundCornerImageView.setBackgroundResource(R.drawable.auj);
        AppMethodBeat.o(202280);
        return roundCornerImageView;
    }

    static {
        AppMethodBeat.i(202283);
        AppMethodBeat.o(202283);
    }

    private static int[] ah(String str, String str2, int i2) {
        AppMethodBeat.i(202281);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i2 < 3) {
            int[] iArr = Dzz;
            AppMethodBeat.o(202281);
            return iArr;
        }
        int[] iArr2 = map.get(str);
        if (com.tencent.mm.plugin.sns.ad.i.c.K(iArr2)) {
            iArr2 = fs(str + str2 + i2, i2);
            map.put(str, iArr2);
        }
        AppMethodBeat.o(202281);
        return iArr2;
    }

    private static int[] fs(String str, int i2) {
        int nextInt;
        int i3;
        int nextInt2;
        AppMethodBeat.i(202282);
        if (str == null || i2 <= 0) {
            int[] iArr = Dzz;
            AppMethodBeat.o(202282);
            return iArr;
        }
        Random random = new Random((long) str.hashCode());
        int nextInt3 = random.nextInt(i2);
        int i4 = 0;
        do {
            nextInt = random.nextInt(i2);
            i4++;
            if (nextInt3 != nextInt) {
                break;
            }
        } while (i4 < 3);
        if (i4 >= 3) {
            i3 = (nextInt3 + 1) % i2;
        } else {
            i3 = nextInt;
        }
        int i5 = 0;
        do {
            nextInt2 = random.nextInt(i2);
            i5++;
            if (nextInt2 != i3 && nextInt2 != nextInt3) {
                break;
            }
        } while (i5 < 3);
        if (i5 >= 3) {
            nextInt2 = (i3 + 1) % i2;
        }
        if (nextInt3 == i3 || nextInt3 == nextInt2 || i3 == nextInt2) {
            int[] iArr2 = Dzz;
            AppMethodBeat.o(202282);
            return iArr2;
        }
        int[] iArr3 = {nextInt3, i3, nextInt2};
        AppMethodBeat.o(202282);
        return iArr3;
    }
}
