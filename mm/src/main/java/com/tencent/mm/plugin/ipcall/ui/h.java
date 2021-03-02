package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h extends s<c> implements e.a {
    private static HashMap<String, c> ysD = null;
    private boolean poG = false;
    private d ytC;
    private HashMap<Long, c> ytD = new HashMap<>();
    private HashSet<String> ytE = new HashSet<>();
    private boolean ytF = false;
    ArrayList<k> yxa;
    private View.OnClickListener yxb = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.ipcall.ui.h.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(25858);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (!com.tencent.mm.plugin.ipcall.a.c.gq(h.this.context)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(25858);
                    return;
                }
                k Pm = h.this.Pm(intValue);
                c cVar = null;
                if (Pm.field_addressId > 0) {
                    if (h.this.ytD.containsKey(Long.valueOf(Pm.field_addressId))) {
                        cVar = (c) h.this.ytD.get(Long.valueOf(Pm.field_addressId));
                    } else {
                        cVar = i.eay().GR(Pm.field_addressId);
                    }
                    if (cVar != null) {
                        h.this.ytD.put(Long.valueOf(Pm.field_addressId), cVar);
                    }
                }
                if (cVar != null) {
                    Intent intent = new Intent(h.this.context, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_phoneNumber", Pm.field_phonenumber);
                    intent.putExtra("IPCallTalkUI_contactId", cVar.field_contactId);
                    intent.putExtra("IPCallTalkUI_nickname", cVar.field_systemAddressBookUsername);
                    intent.putExtra("IPCallTalkUI_toWechatUsername", cVar.field_wechatUsername);
                    intent.putExtra("IPCallTalkUI_dialScene", 3);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12059, 0, 0, 0, 0, 3);
                    ((FragmentActivity) h.this.context).startActivityForResult(intent, 1001);
                } else {
                    Intent intent2 = new Intent(h.this.context, IPCallTalkUI.class);
                    intent2.putExtra("IPCallTalkUI_phoneNumber", Pm.field_phonenumber);
                    intent2.putExtra("IPCallTalkUI_dialScene", 3);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12059, 0, 0, 0, 0, 3);
                    ((FragmentActivity) h.this.context).startActivityForResult(intent2, 1001);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25858);
        }
    };

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ c a(c cVar, Cursor cursor) {
        AppMethodBeat.i(25870);
        c cVar2 = cVar;
        if (cVar2 == null) {
            cVar2 = new c();
        }
        cVar2.convertFrom(cursor);
        AppMethodBeat.o(25870);
        return cVar2;
    }

    public h(Context context) {
        super(context, null);
        AppMethodBeat.i(25860);
        Bh(true);
        this.ytC = new d(context);
        p.aYn().a(this);
        AppMethodBeat.o(25860);
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(25863);
        if (this.yxa == null) {
            this.yxa = m.ebb();
        }
        if (this.yxa != null) {
            int size = this.yxa.size();
            AppMethodBeat.o(25863);
            return size;
        }
        AppMethodBeat.o(25863);
        return 0;
    }

    public final k Pm(int i2) {
        AppMethodBeat.i(25864);
        k kVar = this.yxa.get(i2);
        AppMethodBeat.o(25864);
        return kVar;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(25865);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.awt, viewGroup, false);
            a aVar = new a(this, (byte) 0);
            aVar.ytS = view.findViewById(R.id.e2e);
            aVar.ytT = view.findViewById(R.id.bsd);
            aVar.gyr = (ImageView) view.findViewById(R.id.x1);
            aVar.kcZ = (TextView) view.findViewById(R.id.fzg);
            aVar.ytK = (TextView) view.findViewById(R.id.gb2);
            aVar.ytL = (LinearLayout) view.findViewById(R.id.gu8);
            aVar.ytM = (TextView) view.findViewById(R.id.gua);
            aVar.ytN = (TextView) view.findViewById(R.id.gub);
            aVar.ytO = (TextView) view.findViewById(R.id.hp);
            aVar.ytP = (TextView) view.findViewById(R.id.he);
            aVar.ytQ = (ImageView) view.findViewById(R.id.hf);
            aVar.ytR = view.findViewById(R.id.e2j);
            aVar.ytR.setClickable(true);
            aVar.ytU = (ImageView) view.findViewById(R.id.brt);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.ytR.setClickable(true);
        aVar2.ytR.setTag(Integer.valueOf(i2));
        aVar2.ytU.setVisibility(8);
        if (Ox(i2)) {
            aVar2.kcZ.setVisibility(8);
            aVar2.ytK.setVisibility(8);
            aVar2.ytL.setVisibility(8);
            aVar2.gyr.setVisibility(8);
            aVar2.gyr.setTag(null);
            aVar2.ytP.setVisibility(8);
            aVar2.ytO.setVisibility(8);
            aVar2.ytQ.setVisibility(8);
        } else {
            k Pm = Pm(i2);
            if (Pm != null) {
                if (i2 == 0) {
                    aVar2.ytP.setVisibility(0);
                    aVar2.ytO.setVisibility(8);
                    aVar2.ytP.setText(this.context.getString(R.string.e78));
                } else {
                    aVar2.ytP.setVisibility(8);
                    aVar2.ytO.setVisibility(8);
                }
                aVar2.ytU.setVisibility(0);
                aVar2.kcZ.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar2.ytS.getLayoutParams();
                layoutParams.height = (int) aVar2.ytK.getContext().getResources().getDimension(R.dimen.o2);
                aVar2.ytS.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar2.gyr.getLayoutParams();
                layoutParams2.height = (int) aVar2.gyr.getContext().getResources().getDimension(R.dimen.aq6);
                layoutParams2.width = (int) aVar2.gyr.getContext().getResources().getDimension(R.dimen.aq6);
                aVar2.gyr.setLayoutParams(layoutParams2);
                if (Pm.field_addressId > 0) {
                    if (this.ytD.containsKey(Long.valueOf(Pm.field_addressId))) {
                        cVar = this.ytD.get(Long.valueOf(Pm.field_addressId));
                    } else {
                        cVar = i.eay().GR(Pm.field_addressId);
                    }
                    if (cVar != null) {
                        this.ytD.put(Long.valueOf(Pm.field_addressId), cVar);
                        aVar2.kcZ.setText(cVar.field_systemAddressBookUsername);
                    }
                } else {
                    aVar2.kcZ.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(Pm.field_phonenumber));
                    cVar = null;
                }
                aVar2.ytK.setVisibility(8);
                aVar2.ytL.setVisibility(0);
                aVar2.ytN.setText(com.tencent.mm.plugin.ipcall.a.c.GU(Pm.field_calltime));
                if (Pm.field_duration > 0) {
                    aVar2.ytM.setText(com.tencent.mm.plugin.ipcall.a.c.GY(Pm.field_duration));
                } else {
                    aVar2.ytM.setText(com.tencent.mm.plugin.ipcall.a.c.Pr(Pm.field_status));
                }
                ImageView imageView = aVar2.gyr;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.drawable.cac);
                    if (cVar != null) {
                        if (!Util.isNullOrNil(cVar.field_contactId) && !Util.isNullOrNil(cVar.field_wechatUsername)) {
                            this.ytC.a(cVar.field_contactId, cVar.field_wechatUsername, imageView);
                        } else if (!Util.isNullOrNil(cVar.field_contactId)) {
                            this.ytC.d(cVar.field_contactId, imageView);
                        } else if (!Util.isNullOrNil(cVar.field_wechatUsername)) {
                            this.ytC.f(cVar.field_wechatUsername, imageView);
                        }
                        if (!Util.isNullOrNil(cVar.field_wechatUsername)) {
                            this.ytE.add(cVar.field_wechatUsername);
                        }
                    }
                }
            }
            aVar2.ytR.setVisibility(0);
            aVar2.ytQ.setVisibility(0);
            aVar2.ytR.setOnClickListener(this.yxb);
        }
        AppMethodBeat.o(25865);
        return view;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(25866);
        int itemViewType = super.getItemViewType(i2);
        AppMethodBeat.o(25866);
        return itemViewType;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(25867);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(25867);
        return viewTypeCount;
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(25868);
        if (this.ytE.contains(str)) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.ui.h.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(25859);
                    h.this.notifyDataSetChanged();
                    AppMethodBeat.o(25859);
                }
            });
        }
        AppMethodBeat.o(25868);
    }

    class a {
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

        private a() {
        }

        /* synthetic */ a(h hVar, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(257950);
        this.yxa = m.ebb();
        AppMethodBeat.o(257950);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(258844);
        this.yxa = m.ebb();
        AppMethodBeat.o(258844);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(25869);
        this.yxa = m.ebb();
        this.ytD.clear();
        super.notifyDataSetChanged();
        AppMethodBeat.o(25869);
    }
}
