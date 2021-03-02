package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class bd extends AnimatedExpandableListView.a {
    public static int[] EEO = {R.string.h7n, R.string.h7l, R.string.h7h, R.string.h79};
    public static int EFm = 0;
    public static int EFn = 1;
    public static int EFo = 2;
    public static int[] EFp = {R.string.h7o, R.string.h7m, R.string.h7i, R.string.h7_};
    public boolean EEV = false;
    ArrayList<String> EFq;
    public int EFr = 0;
    public boolean EFs = false;
    public ArrayList<String> EFt = new ArrayList<>();
    public ArrayList<String> EFu = new ArrayList<>();
    public ArrayList<String> EFv = new ArrayList<>();
    public ArrayList<String> EFw = new ArrayList<>();
    public ArrayList<String> EFx = new ArrayList<>();
    public ArrayList<String> EFy = new ArrayList<>();
    b EFz = null;
    private Context mContext;
    private LayoutInflater mInflater;
    public int style;

    public interface b {
        void a(c cVar);
    }

    public bd(Context context) {
        AppMethodBeat.i(98824);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_from_chatroom_enable, 1) == 1) {
            EFm = 0;
            EFn = 1;
        } else {
            EFm = -1;
            EFn = 0;
        }
        EFo = EFn + 1;
        Log.i("MicroMsg.Sns.AnimatedExpandableListAdapter", "initWithConfig %s %s %s", Integer.valueOf(EFm), Integer.valueOf(EFn), Integer.valueOf(EFo));
        AppMethodBeat.o(98824);
    }

    public final Object getChild(int i2, int i3) {
        AppMethodBeat.i(98825);
        String str = this.EFq.get(i3);
        AppMethodBeat.o(98825);
        return str;
    }

    public final long getChildId(int i2, int i3) {
        return 0;
    }

    public final void aR(ArrayList<String> arrayList) {
        AppMethodBeat.i(98826);
        List<String> fit = fit();
        ArrayList arrayList2 = new ArrayList();
        if (!(fit == null || arrayList == null)) {
            for (String str : fit) {
                if (p(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            String listToString = Util.listToString(arrayList2, ",");
            g.aAi();
            g.aAh().azQ().set(335875, listToString);
        }
        this.EFq = arrayList;
        AppMethodBeat.o(98826);
    }

    private static List<String> fit() {
        AppMethodBeat.i(98827);
        g.aAi();
        String str = (String) g.aAh().azQ().get(335875, (Object) null);
        Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(98827);
            return null;
        }
        ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
        AppMethodBeat.o(98827);
        return stringsToList;
    }

    public static void aRb(String str) {
        AppMethodBeat.i(98828);
        Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", str);
        if (fit() != null) {
            ArrayList arrayList = new ArrayList(fit());
            if (!p(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                String listToString = Util.listToString(arrayList, ",");
                g.aAi();
                g.aAh().azQ().set(335875, listToString);
            }
            AppMethodBeat.o(98828);
            return;
        }
        g.aAi();
        g.aAh().azQ().set(335875, str);
        AppMethodBeat.o(98828);
    }

    private static boolean p(List<String> list, String str) {
        AppMethodBeat.i(98829);
        for (String str2 : list) {
            if (str2.equals(str)) {
                AppMethodBeat.o(98829);
                return true;
            }
        }
        AppMethodBeat.o(98829);
        return false;
    }

    private boolean cu(int i2, String str) {
        AppMethodBeat.i(98830);
        if (i2 == 1) {
            boolean p = p(this.EFt, str);
            AppMethodBeat.o(98830);
            return p;
        }
        boolean p2 = p(this.EFu, str);
        AppMethodBeat.o(98830);
        return p2;
    }

    public final Object getGroup(int i2) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i2) {
        return 0;
    }

    public final View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        View inflate;
        AppMethodBeat.i(98831);
        if (view == null || !(view.getTag() instanceof a)) {
            if (this.style == 1) {
                inflate = this.mInflater.inflate(R.layout.bw7, (ViewGroup) null);
            } else {
                inflate = this.mInflater.inflate(R.layout.bw6, (ViewGroup) null);
            }
            a aVar2 = new a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(R.id.hyn);
            aVar2.zkw = (ImageView) inflate.findViewById(R.id.hyg);
            aVar2.yMM = (TextView) inflate.findViewById(R.id.hym);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.titleView.setText(EEO[i2]);
        aVar.yMM.setText(EFp[i2]);
        switch (i2) {
            case 0:
            case 1:
                if (this.EFr == i2) {
                    aVar.zkw.setImageResource(R.raw.radio_on);
                    aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
                    break;
                } else {
                    aVar.zkw.setImageResource(R.raw.radio_off);
                    break;
                }
            case 2:
                if (this.EFr == i2) {
                    aVar.zkw.setImageResource(R.raw.radio_on);
                    aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
                    break;
                } else {
                    aVar.zkw.setImageResource(R.raw.radio_off);
                    break;
                }
            case 3:
                if (this.style != 1) {
                    if (this.EFr == i2) {
                        aVar.zkw.setImageResource(R.raw.radio_on_red);
                        aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
                        break;
                    } else {
                        aVar.zkw.setImageResource(R.raw.radio_off);
                        break;
                    }
                } else if (this.EFr == i2) {
                    aVar.zkw.setImageResource(R.raw.round_selector_checked_orange);
                    aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
                    break;
                } else {
                    aVar.zkw.setImageResource(R.raw.radio_off);
                    break;
                }
        }
        if (this.EFs && i2 == 1) {
            View view2 = new View(this.mContext);
            view2.setVisibility(8);
            AppMethodBeat.o(98831);
            return view2;
        } else if (!this.EEV || !(i2 == 1 || i2 == 2)) {
            AppMethodBeat.o(98831);
            return view;
        } else {
            View view3 = new View(this.mContext);
            view3.setVisibility(8);
            AppMethodBeat.o(98831);
            return view3;
        }
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    class a {
        TextView EFB;
        TextView EFC;
        ImageView EFD;
        TextView titleView;
        TextView yMM;
        ImageView zkw;

        private a() {
        }

        /* synthetic */ a(bd bdVar, byte b2) {
            this();
        }
    }

    private static List<String> V(List<String> list) {
        AppMethodBeat.i(98832);
        LinkedList linkedList = new LinkedList();
        g.aAi();
        if (!g.aAf().azp()) {
            AppMethodBeat.o(98832);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(98832);
            return linkedList;
        } else {
            for (String str : list) {
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                    str = Kn.arJ();
                }
                linkedList.add(str);
            }
            AppMethodBeat.o(98832);
            return linkedList;
        }
    }

    @Override // com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a
    public final View d(int i2, int i3, View view) {
        a aVar;
        CharSequence charSequence;
        View inflate;
        AppMethodBeat.i(98833);
        if (view == null) {
            if (this.style == 1) {
                inflate = this.mInflater.inflate(R.layout.bw5, (ViewGroup) null);
            } else {
                inflate = this.mInflater.inflate(R.layout.bw4, (ViewGroup) null);
            }
            a aVar2 = new a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(R.id.hyn);
            aVar2.yMM = (TextView) inflate.findViewById(R.id.hym);
            aVar2.EFB = (TextView) inflate.findViewById(R.id.hyl);
            aVar2.EFC = (TextView) inflate.findViewById(R.id.hyk);
            aVar2.zkw = (ImageView) inflate.findViewById(R.id.hyg);
            aVar2.EFD = (ImageView) inflate.findViewById(R.id.hyj);
            aVar2.EFD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.bd.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(98823);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    c cVar = (view.getTag() == null || !(view.getTag() instanceof c)) ? null : (c) view.getTag();
                    if (cVar == null) {
                        Log.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(98823);
                        return;
                    }
                    if (bd.this.EFz != null) {
                        bd.this.EFz.a(cVar);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98823);
                }
            });
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        if (i3 == EFn) {
            aVar.titleView.setVisibility(8);
            aVar.yMM.setVisibility(8);
            aVar.zkw.setVisibility(8);
            aVar.EFD.setVisibility(8);
            aVar.EFB.setVisibility(0);
            aVar.EFB.setText(this.mContext.getResources().getString(R.string.h7p));
            aVar.EFC.setVisibility(0);
            if (i2 == 3) {
                if (this.EFw.size() > 0) {
                    aVar.EFC.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, "√".concat(String.valueOf(Util.listToString(V(this.EFw), ","))), aVar.EFC.getTextSize()));
                    aVar.EFC.setVisibility(0);
                    aVar.EFC.setTextColor(this.mContext.getResources().getColor(R.color.a9g));
                } else {
                    aVar.EFC.setText("");
                    aVar.EFC.setVisibility(8);
                }
            } else if (i2 == 2) {
                if (this.EFv.size() > 0) {
                    aVar.EFC.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, "√".concat(String.valueOf(Util.listToString(V(this.EFv), ","))), aVar.EFC.getTextSize()));
                    aVar.EFC.setVisibility(0);
                    aVar.EFC.setTextColor(this.mContext.getResources().getColor(R.color.a9f));
                } else {
                    aVar.EFC.setText("");
                    aVar.EFC.setVisibility(8);
                }
            }
        } else if (i3 == EFm) {
            aVar.titleView.setVisibility(8);
            aVar.yMM.setVisibility(8);
            aVar.zkw.setVisibility(8);
            aVar.EFD.setVisibility(8);
            aVar.EFB.setVisibility(0);
            aVar.EFB.setText(this.mContext.getResources().getString(R.string.h7q));
            aVar.EFC.setVisibility(0);
            if (i2 == 3) {
                if (this.EFy.size() > 0) {
                    aVar.EFC.setText("√".concat(String.valueOf(Util.listToString(V(this.EFy), ","))));
                    aVar.EFC.setVisibility(0);
                    aVar.EFC.setTextColor(this.mContext.getResources().getColor(R.color.a9g));
                } else {
                    aVar.EFC.setText("");
                    aVar.EFC.setVisibility(8);
                }
            } else if (i2 == 2) {
                if (this.EFx.size() > 0) {
                    aVar.EFC.setText("√".concat(String.valueOf(Util.listToString(V(this.EFx), ","))));
                    aVar.EFC.setVisibility(0);
                    aVar.EFC.setTextColor(this.mContext.getResources().getColor(R.color.a9f));
                } else {
                    aVar.EFC.setText("");
                    aVar.EFC.setVisibility(8);
                }
            }
        } else {
            int i4 = i3 - EFo;
            ImageView imageView = aVar.EFD;
            Object tag = imageView.getTag();
            if (tag == null || !(tag instanceof c)) {
                c cVar = new c();
                cVar.EFE = i2;
                cVar.EFF = i4;
                imageView.setTag(cVar);
            } else {
                c cVar2 = (c) imageView.getTag();
                cVar2.EFE = i2;
                cVar2.EFF = i4;
            }
            aVar.titleView.setVisibility(0);
            aVar.yMM.setVisibility(0);
            aVar.zkw.setVisibility(0);
            aVar.EFD.setVisibility(0);
            aVar.EFB.setVisibility(8);
            aVar.EFC.setVisibility(8);
            String str = this.EFq.get(i4);
            aVar.titleView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, str));
            TextView textView = aVar.yMM;
            List<String> aCK = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(str));
            if (aCK == null || aCK.size() == 0) {
                charSequence = "";
            } else {
                ArrayList arrayList = new ArrayList(aCK.size());
                for (String str2 : aCK) {
                    arrayList.add(((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str2));
                }
                charSequence = com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, Util.listToString(arrayList, ","));
            }
            textView.setText(charSequence);
            aVar.EFD.setImageDrawable(ar.m(this.mContext, R.raw.sns_label_more_btn, this.mContext.getResources().getColor(R.color.BW_50)));
            if (this.style == 1) {
                if (i2 == 2) {
                    if (cu(1, str)) {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_selected);
                    } else {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_unselected);
                    }
                } else if (i2 == 3) {
                    if (this.EFr != i2) {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_unselected_red);
                    } else {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_selected_red);
                    }
                    if (cu(2, str)) {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_selected_red);
                    } else {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_unselected_red);
                    }
                }
            } else if (i2 == 2) {
                if (cu(1, str)) {
                    aVar.zkw.setImageResource(R.raw.checkbox_selected);
                } else {
                    aVar.zkw.setImageResource(R.drawable.p5);
                }
            } else if (i2 == 3) {
                if (cu(2, str)) {
                    aVar.zkw.setImageResource(R.raw.checkbox_selected_red);
                } else {
                    aVar.zkw.setImageResource(R.drawable.p5);
                }
            }
        }
        AppMethodBeat.o(98833);
        return view;
    }

    @Override // com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a
    public final int ZO(int i2) {
        AppMethodBeat.i(98834);
        if (i2 <= 1 || this.EFq == null) {
            AppMethodBeat.o(98834);
            return 0;
        }
        int size = this.EFq.size() + EFo;
        AppMethodBeat.o(98834);
        return size;
    }

    class c {
        public int EFE;
        public int EFF;

        c() {
        }
    }
}
