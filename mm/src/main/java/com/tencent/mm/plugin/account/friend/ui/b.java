package com.tencent.mm.plugin.account.friend.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public final class b extends BaseAdapter {
    LinkedList<bfo> gYE;
    private LinkedList<ctl> iAd;
    private final LayoutInflater kgB;
    boolean kgC;
    private boolean[] kgD;

    public b(LayoutInflater layoutInflater) {
        this.kgB = layoutInflater;
    }

    public final void vl(int i2) {
        AppMethodBeat.i(131224);
        if (i2 < 0 || i2 >= this.kgD.length) {
            AppMethodBeat.o(131224);
            return;
        }
        boolean[] zArr = this.kgD;
        zArr[i2] = !zArr[i2];
        super.notifyDataSetChanged();
        AppMethodBeat.o(131224);
    }

    public final void a(LinkedList<ctl> linkedList, int i2) {
        AppMethodBeat.i(131225);
        if (i2 < 0) {
            this.iAd = linkedList;
        } else {
            this.iAd = new LinkedList<>();
            for (int i3 = 0; i3 < linkedList.size(); i3++) {
                if (i2 == linkedList.get(i3).Ltr) {
                    this.iAd.add(linkedList.get(i3));
                }
            }
        }
        this.kgD = new boolean[this.iAd.size()];
        AppMethodBeat.o(131225);
    }

    public final String[] boI() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(131226);
        int i4 = 0;
        for (boolean z : this.kgD) {
            if (z) {
                i4++;
            }
        }
        String[] strArr = new String[i4];
        int i5 = 0;
        while (i3 < this.iAd.size()) {
            if (this.kgD[i3]) {
                strArr[i5] = this.iAd.get(i3).UserName;
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            i3++;
            i5 = i2;
        }
        AppMethodBeat.o(131226);
        return strArr;
    }

    public final int getCount() {
        AppMethodBeat.i(131227);
        if (this.kgC) {
            if (this.gYE == null) {
                AppMethodBeat.o(131227);
                return 0;
            }
            int size = this.gYE.size();
            AppMethodBeat.o(131227);
            return size;
        } else if (this.iAd != null) {
            int size2 = this.iAd.size();
            AppMethodBeat.o(131227);
            return size2;
        } else {
            AppMethodBeat.o(131227);
            return 0;
        }
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(131228);
        if (this.kgC) {
            bfo bfo = this.gYE.get(i2);
            AppMethodBeat.o(131228);
            return bfo;
        }
        ctl ctl = this.iAd.get(i2);
        AppMethodBeat.o(131228);
        return ctl;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        String str2;
        a aVar2;
        AppMethodBeat.i(131229);
        if (this.kgC) {
            bfo bfo = this.gYE.get(i2);
            if (view == 0 || ((a) view.getTag()).type != 2) {
                view = this.kgB.inflate(R.layout.aw_, viewGroup, false);
                a aVar3 = new a();
                aVar3.type = 2;
                aVar3.kgE = (TextView) view.findViewById(R.id.gml);
                view.setTag(aVar3);
                aVar2 = aVar3;
            } else {
                aVar2 = (a) view.getTag();
            }
            aVar2.kgE.setText(bfo.LPg);
            AppMethodBeat.o(131229);
        } else {
            ctl ctl = this.iAd.get(i2);
            if (view == null || ((a) view.getTag()).type != 1) {
                view = this.kgB.inflate(R.layout.aw9, viewGroup, false);
                aVar = new a();
                aVar.type = 1;
                aVar.gwR = (TextView) view.findViewById(R.id.e09);
                aVar.kgF = (TextView) view.findViewById(R.id.e07);
                aVar.kgH = (CheckBox) view.findViewById(R.id.e0_);
                aVar.kgG = (TextView) view.findViewById(R.id.dzw);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (((q) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getInviteFriendOpenStg()).Tf(ctl.UserName)) {
                aVar.kgG.setVisibility(0);
            } else {
                aVar.kgG.setVisibility(8);
            }
            TextView textView = aVar.gwR;
            if (ctl == null || (((str = ctl.LoI) == null || str.length() <= 0) && (((str = ctl.oUJ) == null || str.length() <= 0) && (((str = new p(ctl.rBx).toString()) == null || str.length() <= 0) && ((str = ctl.KPz) == null || str.length() <= 0))))) {
                str = "";
            }
            textView.setText(str);
            TextView textView2 = aVar.kgF;
            if (ctl != null) {
                if (ctl.Mjk == 0) {
                    str2 = ctl.UserName;
                } else if (ctl.Mjk == 2) {
                    str2 = ctl.UserName;
                } else if (ctl.Mjk == 1) {
                    String str3 = ctl.UserName;
                    if (!Util.isNullOrNil(str3)) {
                        String[] split = str3.split("@");
                        if (split == null || split.length < 2 || Util.isNullOrNil(split[0])) {
                            str2 = "";
                        } else {
                            str2 = "@" + split[0];
                        }
                    }
                }
                textView2.setText(str2);
                aVar.kgH.setChecked(this.kgD[i2]);
                AppMethodBeat.o(131229);
            }
            str2 = "";
            textView2.setText(str2);
            aVar.kgH.setChecked(this.kgD[i2]);
            AppMethodBeat.o(131229);
        }
        return view;
    }

    static class a {
        TextView gwR;
        TextView kgE;
        TextView kgF;
        TextView kgG;
        CheckBox kgH;
        int type;

        a() {
        }
    }
}
