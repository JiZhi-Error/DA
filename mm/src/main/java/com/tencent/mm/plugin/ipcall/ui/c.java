package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c extends s<com.tencent.mm.plugin.ipcall.model.h.c> implements e.a {
    static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> ysD = null;
    HashMap<String, Integer> gAI = new HashMap<>();
    private String kdi;
    PhoneFormater kqv = new PhoneFormater();
    private Context mContext;
    boolean poG = false;
    private d ytC;
    private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> ytD = new HashMap<>();
    private HashSet<String> ytE = new HashSet<>();
    private boolean ytF = false;
    private View.OnClickListener ytG = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.ipcall.ui.c.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(25611);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof Integer) {
                com.tencent.mm.plugin.ipcall.model.h.c Pg = c.this.Pg(((Integer) view.getTag()).intValue());
                Intent intent = new Intent(c.this.context, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", Pg.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", Pg.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", Pg.field_wechatUsername);
                Context context = c.this.context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25611);
        }
    };

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ com.tencent.mm.plugin.ipcall.model.h.c a(com.tencent.mm.plugin.ipcall.model.h.c cVar, Cursor cursor) {
        AppMethodBeat.i(25630);
        com.tencent.mm.plugin.ipcall.model.h.c cVar2 = cVar;
        if (cVar2 == null) {
            cVar2 = new com.tencent.mm.plugin.ipcall.model.h.c();
        }
        cVar2.convertFrom(cursor);
        AppMethodBeat.o(25630);
        return cVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ com.tencent.mm.plugin.ipcall.model.h.c getItem(int i2) {
        AppMethodBeat.i(25629);
        com.tencent.mm.plugin.ipcall.model.h.c Pg = Pg(i2);
        AppMethodBeat.o(25629);
        return Pg;
    }

    public c(Context context) {
        super(context, null);
        AppMethodBeat.i(25613);
        Bh(true);
        this.mContext = context;
        this.ytC = new d(context);
        p.aYn().a(this);
        AppMethodBeat.o(25613);
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(25614);
        int count = super.getCount();
        AppMethodBeat.o(25614);
        return count;
    }

    public final int ebe() {
        AppMethodBeat.i(25615);
        int count = super.getCount();
        AppMethodBeat.o(25615);
        return count;
    }

    public final com.tencent.mm.plugin.ipcall.model.h.c Pg(int i2) {
        AppMethodBeat.i(25616);
        com.tencent.mm.plugin.ipcall.model.h.c cVar = (com.tencent.mm.plugin.ipcall.model.h.c) super.getItem(i2);
        AppMethodBeat.o(25616);
        return cVar;
    }

    public final void SM(String str) {
        AppMethodBeat.i(25617);
        this.kdi = str;
        if (Util.isNullOrNil(this.kdi)) {
            this.ytF = false;
        } else {
            this.ytF = true;
        }
        this.OFH.clear();
        anp();
        notifyDataSetChanged();
        AppMethodBeat.o(25617);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        Cursor aBX;
        AppMethodBeat.i(25618);
        if (!this.ytF) {
            aBX = i.eay().eaZ();
        } else {
            this.poG = true;
            aBX = i.eay().aBX(this.kdi);
            this.poG = false;
        }
        if (aBX != null) {
            aBX.moveToFirst();
        }
        setCursor(aBX);
        ebg();
        AppMethodBeat.o(25618);
    }

    @Override // com.tencent.mm.ui.s
    public final void ebf() {
        AppMethodBeat.i(25619);
        super.ebf();
        AppMethodBeat.o(25619);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        AppMethodBeat.i(25621);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.awt, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.ytS = view.findViewById(R.id.e2e);
            bVar.ytT = view.findViewById(R.id.bsd);
            bVar.gyr = (ImageView) view.findViewById(R.id.x1);
            bVar.kcZ = (TextView) view.findViewById(R.id.fzg);
            bVar.ytK = (TextView) view.findViewById(R.id.gb2);
            bVar.ytL = (LinearLayout) view.findViewById(R.id.gu8);
            bVar.ytM = (TextView) view.findViewById(R.id.gua);
            bVar.ytN = (TextView) view.findViewById(R.id.gub);
            bVar.ytO = (TextView) view.findViewById(R.id.hp);
            bVar.ytP = (TextView) view.findViewById(R.id.he);
            bVar.ytQ = (ImageView) view.findViewById(R.id.hf);
            bVar.ytR = view.findViewById(R.id.e2j);
            bVar.ytR.setClickable(true);
            bVar.ytU = (ImageView) view.findViewById(R.id.brt);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.ytR.setClickable(true);
        bVar2.ytR.setTag(Integer.valueOf(i2));
        bVar2.ytU.setVisibility(8);
        if (Ox(i2)) {
            bVar2.kcZ.setVisibility(8);
            bVar2.ytK.setVisibility(8);
            bVar2.ytL.setVisibility(8);
            bVar2.gyr.setVisibility(8);
            bVar2.gyr.setTag(null);
            bVar2.ytP.setVisibility(8);
            bVar2.ytO.setVisibility(8);
            bVar2.ytQ.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.model.h.c Pg = Pg(i2);
            if (Pg != null) {
                if (!Util.isNullOrNil(Pg.field_systemAddressBookUsername)) {
                    bVar2.kcZ.setVisibility(0);
                    if (this.ytF) {
                        bVar2.ytK.setVisibility(0);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar2.ytS.getLayoutParams();
                        layoutParams.height = (int) bVar2.ytK.getContext().getResources().getDimension(R.dimen.aq8);
                        bVar2.ytS.setLayoutParams(layoutParams);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar2.gyr.getLayoutParams();
                        layoutParams2.height = (int) bVar2.gyr.getContext().getResources().getDimension(R.dimen.o1);
                        layoutParams2.width = (int) bVar2.gyr.getContext().getResources().getDimension(R.dimen.o1);
                        bVar2.gyr.setLayoutParams(layoutParams2);
                    } else {
                        bVar2.ytK.setVisibility(8);
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) bVar2.ytS.getLayoutParams();
                        layoutParams3.height = (int) bVar2.ytK.getContext().getResources().getDimension(R.dimen.o2);
                        bVar2.ytS.setLayoutParams(layoutParams3);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) bVar2.gyr.getLayoutParams();
                        layoutParams4.height = (int) bVar2.gyr.getContext().getResources().getDimension(R.dimen.aq6);
                        layoutParams4.width = (int) bVar2.gyr.getContext().getResources().getDimension(R.dimen.aq6);
                        bVar2.gyr.setLayoutParams(layoutParams4);
                    }
                    if (this.ytF && Pg.ysE == null && ysD != null && ysD.containsKey(Pg.field_contactId)) {
                        Pg.ysE = ysD.get(Pg.field_contactId).ysE;
                    } else if (this.ytF && Pg.ysE == null && (ysD == null || ysD.containsKey(Pg.field_contactId))) {
                        Pg.ysE = com.tencent.mm.plugin.ipcall.model.h.b.aBU(Pg.field_contactId);
                    }
                    if (!Util.isNullOrNil(this.kdi) && (Util.isNum(this.kdi.charAt(0)) || this.kdi.startsWith("+"))) {
                        bVar2.ytK.setText(f.b(a(Pg, this.kdi), PhoneFormater.formatMobileString(this.kdi)));
                        bVar2.kcZ.setText(f.b(Pg.field_systemAddressBookUsername, this.kdi));
                    } else if (!Util.isNullOrNil(this.kdi) && !Util.isNum(this.kdi.charAt(0))) {
                        String str2 = Pg.field_systemAddressBookUsername;
                        String str3 = Pg.field_systemAddressBookUsername;
                        String str4 = this.kdi;
                        if (Util.isNullOrNil(str4) || Util.isNullOrNil(str3)) {
                            str = "";
                        } else {
                            if (!Util.isChinese(str4) && Util.isAllAlpha(str4)) {
                                ArrayList arrayList = new ArrayList();
                                for (int i3 = 0; i3 < str3.length(); i3++) {
                                    String substring = str3.substring(i3, i3 + 1);
                                    arrayList.add(new a(com.tencent.mm.platformtools.f.Sh(substring), substring));
                                }
                                for (int i4 = 2; i4 <= str3.length(); i4++) {
                                    for (int i5 = 0; i5 <= str3.length() - i4; i5++) {
                                        String substring2 = str3.substring(i5, i5 + i4);
                                        arrayList.add(new a(com.tencent.mm.platformtools.f.Sh(substring2), substring2));
                                    }
                                }
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= arrayList.size()) {
                                        break;
                                    }
                                    a aVar = (a) arrayList.get(i6);
                                    if (aVar.ytI.contains(str4)) {
                                        str = aVar.ytJ;
                                        break;
                                    }
                                    i6++;
                                }
                            }
                            str = str4;
                        }
                        bVar2.kcZ.setText(f.b(str2, str));
                        bVar2.ytK.setText(a(Pg, this.kdi));
                    } else if (Util.isNullOrNil(this.kdi)) {
                        bVar2.kcZ.setText(Pg.field_systemAddressBookUsername);
                    }
                } else {
                    bVar2.kcZ.setVisibility(8);
                    bVar2.ytK.setVisibility(8);
                }
                ImageView imageView = bVar2.gyr;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.drawable.cac);
                    if (Pg != null) {
                        if (!Util.isNullOrNil(Pg.field_contactId) && !Util.isNullOrNil(Pg.field_wechatUsername)) {
                            this.ytC.a(Pg.field_contactId, Pg.field_wechatUsername, imageView);
                        } else if (!Util.isNullOrNil(Pg.field_contactId)) {
                            this.ytC.d(Pg.field_contactId, imageView);
                        } else if (!Util.isNullOrNil(Pg.field_wechatUsername)) {
                            this.ytC.f(Pg.field_wechatUsername, imageView);
                        }
                        if (!Util.isNullOrNil(Pg.field_wechatUsername)) {
                            this.ytE.add(Pg.field_wechatUsername);
                        }
                    }
                }
                bVar2.ytL.setVisibility(8);
                String aCh = aCh(Pg.field_sortKey);
                if (i2 == 0) {
                    bVar2.ytO.setVisibility(0);
                    bVar2.ytO.setText(aCh);
                    bVar2.ytP.setVisibility(8);
                } else if (!aCh(Pg(i2 - 1).field_sortKey).equals(aCh)) {
                    bVar2.ytO.setVisibility(0);
                    bVar2.ytO.setText(aCh);
                    bVar2.ytP.setVisibility(8);
                } else {
                    bVar2.ytO.setVisibility(8);
                    bVar2.ytO.setText("");
                    bVar2.ytP.setVisibility(8);
                }
            }
            bVar2.ytR.setVisibility(8);
            bVar2.ytQ.setVisibility(8);
            bVar2.ytQ.setOnClickListener(this.ytG);
        }
        boolean z = true;
        if (!(Pg(i2 + 1) == null || Pg(i2) == null || aCh(Pg(i2 + 1).field_sortKey).equals(aCh(Pg(i2).field_sortKey)))) {
            z = false;
        }
        if (i2 + 1 == getCount() || !z) {
            bVar2.ytT.setVisibility(8);
        } else {
            bVar2.ytT.setVisibility(0);
        }
        AppMethodBeat.o(25621);
        return view;
    }

    class a {
        String ytI;
        String ytJ;

        public a(String str, String str2) {
            this.ytJ = str2;
            this.ytI = str;
        }
    }

    private static String a(com.tencent.mm.plugin.ipcall.model.h.c cVar, String str) {
        AppMethodBeat.i(25622);
        if (!(cVar == null || cVar.ysE == null)) {
            Iterator<String> it = cVar.ysE.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.contains(str)) {
                    AppMethodBeat.o(25622);
                    return next;
                }
            }
        }
        AppMethodBeat.o(25622);
        return null;
    }

    private static String aCh(String str) {
        AppMethodBeat.i(25623);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(25623);
            return "";
        } else if (str.startsWith(com.tencent.mm.plugin.ipcall.model.h.b.gAH)) {
            AppMethodBeat.o(25623);
            return "#";
        } else {
            String substring = str.toUpperCase().substring(0, 1);
            AppMethodBeat.o(25623);
            return substring;
        }
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(25624);
        int itemViewType = super.getItemViewType(i2);
        AppMethodBeat.o(25624);
        return itemViewType;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(25625);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(25625);
        return viewTypeCount;
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(25626);
        if (this.ytE.contains(str)) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.ui.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(25612);
                    c.this.notifyDataSetChanged();
                    AppMethodBeat.o(25612);
                }
            });
        }
        AppMethodBeat.o(25626);
    }

    class b {
        ImageView gyr;
        TextView kcZ;
        TextView ytK;
        LinearLayout ytL;
        TextView ytM;
        TextView ytN;
        TextView ytO;
        TextView ytP;
        ImageView ytQ;
        View ytR;
        View ytS;
        View ytT;
        ImageView ytU;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(25627);
        this.ytD.clear();
        super.notifyDataSetChanged();
        AppMethodBeat.o(25627);
    }

    private void ebg() {
        AppMethodBeat.i(25628);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            String str = null;
            try {
                if (cursor.moveToFirst()) {
                    int i2 = 0;
                    while (!cursor.isAfterLast()) {
                        com.tencent.mm.plugin.ipcall.model.h.c cVar = new com.tencent.mm.plugin.ipcall.model.h.c();
                        cVar.convertFrom(cursor);
                        String aCh = aCh(cVar.field_sortKey);
                        if (i2 == 0) {
                            this.gAI.put(aCh, Integer.valueOf(i2));
                        } else if (str != null && !aCh.equals(str)) {
                            this.gAI.put(aCh, Integer.valueOf(i2));
                        }
                        i2++;
                        cursor.moveToNext();
                        str = aCh;
                    }
                }
                AppMethodBeat.o(25628);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(25628);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(25620);
        super.ebf();
        anp();
        AppMethodBeat.o(25620);
    }
}
