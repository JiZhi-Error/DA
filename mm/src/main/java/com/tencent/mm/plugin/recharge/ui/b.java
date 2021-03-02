package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    ArrayList<q> BDV = null;
    a BDW = null;
    private List<String> BDX = new ArrayList(Util.stringToList((String) g.aAh().azQ().get(ar.a.USERINFO_PHONE_RECHARGE_RECOMMENDED_LIST_STRING_SYNC, ""), ","));

    public interface a {
        void a(q qVar);
    }

    public b() {
        AppMethodBeat.i(67157);
        AppMethodBeat.o(67157);
    }

    public final int getCount() {
        AppMethodBeat.i(67158);
        if (this.BDV == null) {
            AppMethodBeat.o(67158);
            return 0;
        }
        int size = this.BDV.size();
        AppMethodBeat.o(67158);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(67159);
        q qVar = this.BDV.get(i2);
        AppMethodBeat.o(67159);
        return qVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        final C1628b bVar;
        AppMethodBeat.i(67160);
        final q qVar = (q) getItem(i2);
        if (view == null) {
            view = aa.jQ(viewGroup.getContext()).inflate(R.layout.blg, viewGroup, false);
            C1628b bVar2 = new C1628b(this, (byte) 0);
            bVar2.hPW = (TextView) view.findViewById(R.id.bmr);
            bVar2.gxs = (TextView) view.findViewById(R.id.ft7);
            bVar2.BEb = (TextView) view.findViewById(R.id.gho);
            bVar2.BEc = (ImageView) view.findViewById(R.id.gvp);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (C1628b) view.getTag();
        }
        bVar.gxs.setText(qVar.name);
        if (!Util.isNullOrNil(qVar.desc)) {
            bVar.hPW.setVisibility(0);
            bVar.hPW.setText(qVar.desc);
        } else {
            bVar.hPW.setVisibility(8);
        }
        if (!Util.isNullOrNil(qVar.HES)) {
            bVar.BEb.setVisibility(0);
            bVar.BEb.setText(qVar.HES);
        } else {
            bVar.BEb.setVisibility(8);
        }
        if (qVar.status == 1) {
            view.setEnabled(true);
            bVar.hPW.setEnabled(true);
            bVar.gxs.setEnabled(true);
        } else {
            view.setEnabled(false);
            bVar.hPW.setEnabled(false);
            bVar.gxs.setEnabled(false);
        }
        if (qVar.HEW != 1 || this.BDX.contains(qVar.HEX)) {
            bVar.BEc.setVisibility(8);
        } else {
            Log.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", qVar.HEX);
            bVar.BEc.setVisibility(0);
        }
        if (qVar.type == 1 && qVar.HET.equals("1") && !qVar.HEU.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Context context = viewGroup.getContext();
            int cI = com.tencent.mm.plugin.wallet_core.utils.g.cI(qVar.HEU, false);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) com.tencent.mm.cb.a.fromDPToPix(context, 2));
            gradientDrawable.setColor(cI);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) com.tencent.mm.cb.a.fromDPToPix(context, 2));
            gradientDrawable2.setStroke(2, com.tencent.mm.cb.a.n(context, R.color.BW_0_Alpha_0_2));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) com.tencent.mm.cb.a.fromDPToPix(context, 2));
            gradientDrawable3.setColor(com.tencent.mm.cb.a.n(context, R.color.a53));
            gradientDrawable3.setStroke(2, cI);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            Context context2 = viewGroup.getContext();
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842919}, new int[]{-16842910}, new int[0]}, new int[]{com.tencent.mm.cb.a.n(context2, R.color.afz), com.tencent.mm.cb.a.n(context2, R.color.a51), com.tencent.mm.plugin.wallet_core.utils.g.cI(qVar.HEU, false)});
            bVar.hPW.setTextColor(colorStateList);
            bVar.gxs.setTextColor(colorStateList);
            view.setBackground(stateListDrawable);
        }
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(67156);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (b.this.BDW != null) {
                    if (!b.this.BDX.contains(qVar.HEX)) {
                        Log.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", qVar.HEX);
                        if (qVar.HEX != null) {
                            b.this.BDX.add(qVar.HEX);
                            g.aAh().azQ().set(ar.a.USERINFO_PHONE_RECHARGE_RECOMMENDED_LIST_STRING_SYNC, Util.listToString(b.this.BDX, ","));
                            bVar.BEc.setVisibility(8);
                        }
                    }
                    b.this.BDW.a(qVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67156);
            }
        });
        AppMethodBeat.o(67160);
        return view;
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.b$b  reason: collision with other inner class name */
    class C1628b {
        TextView BEb;
        ImageView BEc;
        TextView gxs;
        TextView hPW;

        private C1628b() {
        }

        /* synthetic */ C1628b(b bVar, byte b2) {
            this();
        }
    }
}
