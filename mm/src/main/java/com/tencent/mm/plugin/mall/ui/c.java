package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private SparseArray<String> zjr = null;
    d zkK;
    private boolean zkL = false;
    private final int zkb = 4;
    List<ArrayList<C1470c>> zke = new ArrayList();

    public interface d {
        void a(int i2, bfv bfv);
    }

    public c(Context context) {
        AppMethodBeat.i(213545);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        AppMethodBeat.o(213545);
    }

    public final void ax(ArrayList<bfv> arrayList) {
        int i2;
        AppMethodBeat.i(213546);
        this.zke.clear();
        if (arrayList != null) {
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList<C1470c> arrayList2 = new ArrayList<>();
                int i4 = 0;
                while (i4 < 4 && i3 + i4 < arrayList.size()) {
                    int i5 = i3 + i4;
                    if (i4 > 0 && (i3 + i4) - 1 >= 0 && arrayList.get(i2).LPy != arrayList.get(i5).LPy) {
                        break;
                    }
                    C1470c cVar = new C1470c();
                    cVar.zkJ = i3 + i4;
                    cVar.zkP = arrayList.get(i3 + i4);
                    arrayList2.add(cVar);
                    i4++;
                }
                if (arrayList2.size() > 0) {
                    this.zke.add(arrayList2);
                }
                i3 += i4;
            }
        }
        this.zjr = com.tencent.mm.plugin.wallet_core.model.mall.b.fSa();
        notifyDataSetChanged();
        AppMethodBeat.o(213546);
    }

    public final int getCount() {
        AppMethodBeat.i(213547);
        int size = this.zke.size();
        AppMethodBeat.o(213547);
        return size;
    }

    public final Object getItem(int i2) {
        return null;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
        // Method dump skipped, instructions count: 923
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.c.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private void a(View view, C1470c cVar) {
        AppMethodBeat.i(213549);
        if (view == null) {
            AppMethodBeat.o(213549);
            return;
        }
        a aVar = (a) view.getTag();
        final bfv bfv = cVar.zkP;
        final int i2 = cVar.zkJ;
        if (ao.isDarkMode()) {
            aVar.iconUrl = bfv.LPr.NuA.NuG;
        } else {
            aVar.iconUrl = bfv.LPr.NuA.NuF;
        }
        com.tencent.mm.plugin.mall.b.a.d(aVar.zkp, aVar.iconUrl, R.raw.mall_index_icon_default);
        aVar.zkr.setText(bfv.LPr.Name);
        n(aVar.zkr, a.egP());
        if (bfv.LPx != null) {
            aVar.zks.setText(bfv.LPx);
            aVar.zks.setVisibility(0);
            n(aVar.zks, a.egP());
            this.zkL = true;
        } else {
            aVar.zks.setText("");
            aVar.zks.setVisibility(8);
        }
        if (bfv.LPs == null || bfv.LPs.Nut == null || !b(bfv)) {
            aVar.zkq.setImageBitmap(null);
            aVar.zkq.setVisibility(8);
        } else {
            if (ao.isDarkMode()) {
                aVar.zku = bfv.LPs.Nut.NuG;
            } else {
                aVar.zku = bfv.LPs.Nut.NuF;
            }
            com.tencent.mm.plugin.mall.b.a.t(aVar.zkq, aVar.zku);
            aVar.zkq.setVisibility(0);
            ((RelativeLayout.LayoutParams) aVar.zkq.getLayoutParams()).setMargins((a.egP() / 2) - 1, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 7), 0, 0);
            new StringBuilder().append(bfv.LPr.Nuz);
        }
        aVar.zko.setVisibility(0);
        aVar.zko.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(213544);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.v("MicroMsg.FunctionListAdapterNew", "on Click");
                if (c.this.zkK != null) {
                    c.this.zkK.a(i2, bfv);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213544);
            }
        });
        AppMethodBeat.o(213549);
    }

    public static boolean a(bfv bfv) {
        AppMethodBeat.i(213550);
        if (bfv.LPs == null || bfv.LPs.Nut == null || !b(bfv) || com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVx(new StringBuilder().append(bfv.LPr.Nuz).toString()) == null) {
            AppMethodBeat.o(213550);
            return false;
        }
        AppMethodBeat.o(213550);
        return true;
    }

    private static boolean b(bfv bfv) {
        AppMethodBeat.i(213551);
        MallNews aVx = com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVx(new StringBuilder().append(bfv.LPr.Nuz).toString());
        if (aVx == null || Util.isNullOrNil(aVx.FJm) || !aVx.FJm.equals(new StringBuilder().append(bfv.LPs.Nus).toString())) {
            Log.d("MicroMsg.FunctionListAdapterNew", "old news null or should be replaced %s %s", Integer.valueOf(bfv.LPs.Nus), bfv.LPr.Name);
            MallNews mallNews = new MallNews(new StringBuilder().append(bfv.LPr.Nuz).toString());
            mallNews.FJm = new StringBuilder().append(bfv.LPs.Nus).toString();
            com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().b(mallNews);
            AppMethodBeat.o(213551);
            return true;
        } else if (aVx == null) {
            AppMethodBeat.o(213551);
            return false;
        } else if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(aVx.Icl)) {
            Log.d("MicroMsg.FunctionListAdapterNew", "still old news or clicked, then should not show");
            AppMethodBeat.o(213551);
            return false;
        } else {
            Log.d("MicroMsg.FunctionListAdapterNew", "still old news and should show");
            AppMethodBeat.o(213551);
            return true;
        }
    }

    private static void n(TextView textView, int i2) {
        AppMethodBeat.i(213552);
        textView.setMaxEms(new StaticLayout(textView.getText(), textView.getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineEnd(0));
        AppMethodBeat.o(213552);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public String iconUrl = null;
        public View zko = null;
        public ImageView zkp = null;
        public ImageView zkq = null;
        public TextView zkr = null;
        public TextView zks = null;
        public String zku = null;

        a() {
        }
    }

    class b {
        TextView zkA;
        View zkC;
        View zkH;
        View zkO;
        LinearLayout zkz;

        b() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.mall.ui.c$c  reason: collision with other inner class name */
    public class C1470c {
        int zkJ;
        bfv zkP;

        C1470c() {
        }
    }
}
