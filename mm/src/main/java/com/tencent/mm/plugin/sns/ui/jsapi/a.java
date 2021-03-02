package com.tencent.mm.plugin.sns.ui.jsapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends AnimatedExpandableListView.a {
    public int[] EEO = {R.string.h7n, R.string.h7l, R.string.h7h, R.string.h79};
    public int[] EFp = {R.string.h7o, R.string.h7m, R.string.h7i, R.string.h7_};
    ArrayList<String> EFq;
    public int EFr = 0;
    public boolean EFs = false;
    public ArrayList<String> EFt = new ArrayList<>();
    public ArrayList<String> EFu = new ArrayList<>();
    public ArrayList<String> EFv = new ArrayList<>();
    public ArrayList<String> EFw = new ArrayList<>();
    public int EZU = 0;
    public int EZV = 1;
    public int EZW = 2;
    public int EZX = 3;
    int Fad = 4;
    List<String> Fae;
    b Faf = null;
    boolean Fag = true;
    private Context mContext;
    private LayoutInflater mInflater;
    public int style;

    public interface b {
        void a(c cVar);
    }

    public a(Context context) {
        AppMethodBeat.i(100178);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        AppMethodBeat.o(100178);
    }

    public final Object getChild(int i2, int i3) {
        AppMethodBeat.i(100179);
        String str = this.EFq.get(i3);
        AppMethodBeat.o(100179);
        return str;
    }

    public final long getChildId(int i2, int i3) {
        return 0;
    }

    public final void aR(ArrayList<String> arrayList) {
        AppMethodBeat.i(100180);
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
        AppMethodBeat.o(100180);
    }

    private static List<String> fit() {
        AppMethodBeat.i(100181);
        g.aAi();
        String str = (String) g.aAh().azQ().get(335875, (Object) null);
        Log.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(100181);
            return null;
        }
        ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
        AppMethodBeat.o(100181);
        return stringsToList;
    }

    public static void aRb(String str) {
        AppMethodBeat.i(100182);
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
            AppMethodBeat.o(100182);
            return;
        }
        g.aAi();
        g.aAh().azQ().set(335875, str);
        AppMethodBeat.o(100182);
    }

    private static boolean p(List<String> list, String str) {
        AppMethodBeat.i(100183);
        for (String str2 : list) {
            if (str2.equals(str)) {
                AppMethodBeat.o(100183);
                return true;
            }
        }
        AppMethodBeat.o(100183);
        return false;
    }

    private boolean cu(int i2, String str) {
        AppMethodBeat.i(100184);
        if (i2 == 1) {
            boolean p = p(this.EFt, str);
            AppMethodBeat.o(100184);
            return p;
        }
        boolean p2 = p(this.EFu, str);
        AppMethodBeat.o(100184);
        return p2;
    }

    public final Object getGroup(int i2) {
        return null;
    }

    public final int getGroupCount() {
        return this.Fad;
    }

    public final long getGroupId(int i2) {
        return 0;
    }

    public final View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        C1739a aVar;
        View inflate;
        AppMethodBeat.i(100185);
        if (view == null || !(view.getTag() instanceof C1739a)) {
            if (this.style == 1) {
                inflate = this.mInflater.inflate(R.layout.bw7, (ViewGroup) null);
            } else {
                inflate = this.mInflater.inflate(R.layout.bw6, (ViewGroup) null);
            }
            C1739a aVar2 = new C1739a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(R.id.hyn);
            aVar2.zkw = (ImageView) inflate.findViewById(R.id.hyg);
            aVar2.yMM = (TextView) inflate.findViewById(R.id.hym);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (C1739a) view.getTag();
        }
        aVar.titleView.setText(this.EEO[i2]);
        aVar.yMM.setText(this.EFp[i2]);
        if (i2 == this.EZV || i2 == this.EZU) {
            if (this.EFr != i2) {
                aVar.zkw.setImageResource(R.raw.radio_off);
            } else {
                aVar.zkw.setImageResource(R.raw.radio_on);
                aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
            }
        } else if (i2 == this.EZW) {
            if (this.EFr != i2) {
                aVar.zkw.setImageResource(R.raw.radio_off);
            } else {
                aVar.zkw.setImageResource(R.raw.radio_on);
                aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
            }
        } else if (i2 == this.EZX) {
            if (this.style == 1) {
                if (this.EFr != i2) {
                    aVar.zkw.setImageResource(R.raw.radio_off);
                } else {
                    aVar.zkw.setImageResource(R.raw.round_selector_checked_orange);
                    aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
                }
            } else if (this.EFr != i2) {
                aVar.zkw.setImageResource(R.raw.radio_off);
            } else {
                aVar.zkw.setImageResource(R.raw.radio_on_red);
                aVar.zkw.setContentDescription(this.mContext.getString(R.string.giy));
            }
        }
        if (!this.EFs || i2 != this.EZV) {
            AppMethodBeat.o(100185);
            return view;
        }
        View view2 = new View(this.mContext);
        view2.setVisibility(8);
        AppMethodBeat.o(100185);
        return view2;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.a$a  reason: collision with other inner class name */
    class C1739a {
        TextView EFB;
        TextView EFC;
        ImageView EFD;
        TextView titleView;
        TextView yMM;
        ImageView zkw;

        private C1739a() {
        }

        /* synthetic */ C1739a(a aVar, byte b2) {
            this();
        }
    }

    private static List<String> V(List<String> list) {
        AppMethodBeat.i(100186);
        LinkedList linkedList = new LinkedList();
        g.aAi();
        if (!g.aAf().azp()) {
            AppMethodBeat.o(100186);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(100186);
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
            AppMethodBeat.o(100186);
            return linkedList;
        }
    }

    @Override // com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a
    public final View d(int i2, int i3, View view) {
        C1739a aVar;
        CharSequence charSequence;
        View inflate;
        AppMethodBeat.i(100187);
        if (view == null) {
            if (this.style == 1) {
                inflate = this.mInflater.inflate(R.layout.bw5, (ViewGroup) null);
            } else {
                inflate = this.mInflater.inflate(R.layout.bw4, (ViewGroup) null);
            }
            C1739a aVar2 = new C1739a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(R.id.hyn);
            aVar2.yMM = (TextView) inflate.findViewById(R.id.hym);
            aVar2.EFB = (TextView) inflate.findViewById(R.id.hyl);
            aVar2.EFC = (TextView) inflate.findViewById(R.id.hyk);
            aVar2.zkw = (ImageView) inflate.findViewById(R.id.hyg);
            aVar2.EFD = (ImageView) inflate.findViewById(R.id.hyj);
            aVar2.EFD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.jsapi.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(100177);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    c cVar = (view.getTag() == null || !(view.getTag() instanceof c)) ? null : (c) view.getTag();
                    if (cVar == null) {
                        Log.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100177);
                        return;
                    }
                    if (a.this.Faf != null) {
                        a.this.Faf.a(cVar);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/jsapi/JsapiSnsLabelUIAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100177);
                }
            });
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            aVar = (C1739a) view.getTag();
        }
        ImageView imageView = aVar.EFD;
        Object tag = imageView.getTag();
        if (tag == null || !(tag instanceof c)) {
            c cVar = new c();
            cVar.EFE = i2;
            cVar.EFF = i3;
            imageView.setTag(cVar);
        } else {
            c cVar2 = (c) imageView.getTag();
            cVar2.EFE = i2;
            cVar2.EFF = i3;
        }
        if (i3 == this.EFq.size()) {
            aVar.titleView.setVisibility(8);
            aVar.yMM.setVisibility(8);
            aVar.zkw.setVisibility(8);
            aVar.EFD.setVisibility(8);
            aVar.EFB.setVisibility(0);
            aVar.EFC.setVisibility(0);
            if (i2 == this.EZX) {
                if (this.EFw.size() > 0) {
                    aVar.EFC.setText("√".concat(String.valueOf(Util.listToString(V(this.EFw), ","))));
                    aVar.EFC.setVisibility(0);
                    aVar.EFC.setTextColor(this.mContext.getResources().getColor(R.color.a9g));
                } else {
                    aVar.EFC.setText("");
                    aVar.EFC.setVisibility(8);
                }
            } else if (i2 == this.EZW) {
                if (this.EFv.size() > 0) {
                    aVar.EFC.setText("√".concat(String.valueOf(Util.listToString(V(this.EFv), ","))));
                    aVar.EFC.setVisibility(0);
                    aVar.EFC.setTextColor(this.mContext.getResources().getColor(R.color.a9f));
                } else {
                    aVar.EFC.setText("");
                    aVar.EFC.setVisibility(8);
                }
            }
        } else {
            aVar.titleView.setVisibility(0);
            aVar.yMM.setVisibility(0);
            aVar.zkw.setVisibility(0);
            aVar.EFD.setVisibility(4);
            aVar.EFB.setVisibility(8);
            aVar.EFC.setVisibility(8);
            String str = this.EFq.get(i3);
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
            aVar.EFD.setImageResource(R.raw.sns_label_more_btn);
            if (this.style == 1) {
                if (i2 == this.EZW) {
                    if (cu(1, str)) {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_selected);
                    } else {
                        aVar.zkw.setImageResource(R.raw.sight_list_checkbox_unselected);
                    }
                } else if (i2 == this.EZX) {
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
            } else if (i2 == this.EZW) {
                if (cu(1, str)) {
                    aVar.zkw.setImageResource(R.raw.checkbox_selected);
                } else {
                    aVar.zkw.setImageResource(R.drawable.p5);
                }
            } else if (i2 == this.EZX) {
                if (cu(2, str)) {
                    aVar.zkw.setImageResource(R.raw.checkbox_selected_red);
                } else {
                    aVar.zkw.setImageResource(R.drawable.p5);
                }
            }
        }
        AppMethodBeat.o(100187);
        return view;
    }

    @Override // com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a
    public final int ZO(int i2) {
        AppMethodBeat.i(100188);
        if (("visible".equals(this.Fae.get(i2)) || "invisible".equals(this.Fae.get(i2))) && this.EFq != null) {
            int size = this.EFq.size() + 1;
            AppMethodBeat.o(100188);
            return size;
        }
        AppMethodBeat.o(100188);
        return 0;
    }

    class c {
        public int EFE;
        public int EFF;

        c() {
        }
    }
}
