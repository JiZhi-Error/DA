package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a extends BaseAdapter {
    private Context Baq;
    private List<com.tencent.mm.plugin.product.c.a> Bar;
    private List<Boolean> Bas;
    private int Bat = 1;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(66941);
        com.tencent.mm.plugin.product.c.a Uu = Uu(i2);
        AppMethodBeat.o(66941);
        return Uu;
    }

    public a(Context context) {
        this.Baq = context;
    }

    public final void fO(List<com.tencent.mm.plugin.product.c.a> list) {
        AppMethodBeat.i(66935);
        this.Bar = list;
        this.Bat = 0;
        this.Bas = new ArrayList();
        if (this.Bar != null) {
            HashSet hashSet = new HashSet();
            for (com.tencent.mm.plugin.product.c.a aVar : list) {
                this.Bas.add(Boolean.FALSE);
                hashSet.add(Integer.valueOf(aVar.oUv));
            }
            this.Bat = list.size();
        }
        if (this.Bat <= 0) {
            this.Bat = 1;
        }
        AppMethodBeat.o(66935);
    }

    public final void a(Activity activity, View view, int i2) {
        AppMethodBeat.i(66936);
        b bVar = (b) view.getTag();
        Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + bVar.type);
        Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + bVar.Bax);
        switch (bVar.type) {
            case 0:
                AppMethodBeat.o(66936);
                return;
            case 1:
                if (bVar.Bax instanceof String) {
                    f.a(this.Baq, (String) bVar.Bax, false, 10000);
                    AppMethodBeat.o(66936);
                    return;
                }
                break;
            case 2:
                if (bVar.Bax instanceof ArrayList) {
                    Intent intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", (ArrayList) bVar.Bax);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(66936);
                    return;
                }
                break;
            case 3:
            default:
                Log.w("MicroMsg.MallCustomActionAdapter", "not support type");
                break;
            case 4:
            case 6:
                if (bVar.Bax instanceof String) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("title", bVar.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra("data", (String) bVar.Bax);
                    intent2.putExtra("QRDataFlag", false);
                    f.aA(activity, intent2);
                    AppMethodBeat.o(66936);
                    return;
                }
                break;
            case 5:
                if (this.Bas.get(i2).booleanValue()) {
                    this.Bas.set(i2, Boolean.FALSE);
                } else {
                    this.Bas.set(i2, Boolean.TRUE);
                }
                notifyDataSetChanged();
                AppMethodBeat.o(66936);
                return;
        }
        AppMethodBeat.o(66936);
    }

    public final int getCount() {
        AppMethodBeat.i(66937);
        if (this.Bar != null) {
            int size = this.Bar.size();
            AppMethodBeat.o(66937);
            return size;
        }
        AppMethodBeat.o(66937);
        return 0;
    }

    private com.tencent.mm.plugin.product.c.a Uu(int i2) {
        AppMethodBeat.i(66938);
        com.tencent.mm.plugin.product.c.a aVar = this.Bar.get(i2);
        AppMethodBeat.o(66938);
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getViewTypeCount() {
        return this.Bat;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(66939);
        int i3 = Uu(i2).oUv;
        AppMethodBeat.o(66939);
        return i3;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(66940);
        if (view == null) {
            view = View.inflate(this.Baq, R.layout.bj2, null);
            bVar = new b();
            bVar.mPa = (TextView) view.findViewById(R.id.ir3);
            bVar.Bau = (TextView) view.findViewById(R.id.iek);
            bVar.Bav = (ImageView) view.findViewById(R.id.dxq);
            bVar.Baw = (HtmlTextView) view.findViewById(R.id.boa);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.product.c.a Uu = Uu(i2);
        if (Uu != null) {
            bVar.mPa.setText(Uu.Name);
            bVar.Bau.setText(Uu.AZI);
            bVar.type = Uu.oUv;
            bVar.Bax = Uu.iAc;
            bVar.title = Uu.Name;
            switch (Uu.oUv) {
                case 0:
                    bVar.Bav.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (this.Bas.get(i2).booleanValue()) {
                        bVar.Baw.setVisibility(0);
                    } else {
                        bVar.Baw.setVisibility(8);
                    }
                    if (!bVar.Baw.getText().equals(Uu.iAc)) {
                        bVar.Baw.setText(Uu.iAc);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(66940);
        return view;
    }
}
