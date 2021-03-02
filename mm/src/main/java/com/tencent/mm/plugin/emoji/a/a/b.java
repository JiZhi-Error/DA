package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bh;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private static boolean FQ(int i2) {
        return i2 == 7;
    }

    private static boolean FR(int i2) {
        return i2 == 6;
    }

    public static void a(c cVar, k.a aVar) {
        AppMethodBeat.i(108350);
        if (!z.aUn()) {
            AppMethodBeat.o(108350);
        } else if (cVar == null || cVar.size() <= 0) {
            AppMethodBeat.o(108350);
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<f> it = cVar.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!(next == null || next.qYk == f.a.cellset)) {
                    EmotionSummary emotionSummary = next.qYl;
                    boolean b2 = e.b(emotionSummary);
                    boolean a2 = e.a(emotionSummary);
                    if (!b2 && !a2) {
                        arrayList.add(emotionSummary.ProductID);
                        bh ame = cVar.ame(emotionSummary.ProductID);
                        if (ame != null) {
                            ame.Opx = 11;
                        }
                    }
                }
            }
            Context context = MMApplicationContext.getContext();
            if (arrayList.size() > 0) {
                k.a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), aVar);
            }
            AppMethodBeat.o(108350);
        }
    }

    public static void a(ArrayList<q> arrayList, c cVar) {
        boolean z;
        AppMethodBeat.i(108351);
        if (!z.aUn()) {
            AppMethodBeat.o(108351);
        } else if (cVar == null || arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(108351);
        } else {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null) {
                    Log.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", next);
                    bh ame = cVar.ame(next.productId);
                    if (ame != null) {
                        if (next.JVq == 10232) {
                            ame.OpB = next.JVn;
                            ame.Opz = next.JVo;
                            ame.OpA = new BigDecimal(next.JVp).divide(new BigDecimal(1000000)).toString();
                            ame.Opx = 12;
                            int i2 = ame.Opv;
                            if (!FQ(i2) && !FR(i2)) {
                                ame.akj(4);
                            }
                        } else {
                            ame.Opx = 10;
                            ame.Opy = next.JVq;
                            int i3 = ame.Opv;
                            if (!FQ(i3) && !FR(i3)) {
                                if (i3 == 3) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    ame.akj(10);
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(108351);
        }
    }
}
