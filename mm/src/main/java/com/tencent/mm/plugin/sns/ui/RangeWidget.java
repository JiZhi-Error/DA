package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.j.n;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget extends RelativeLayout {
    private m DOH = null;
    SnsUploadConfigView Eoy;
    private TextView ErY;
    private String EvA = "";
    private String EvB = "";
    private View.OnClickListener EvC = null;
    private TextView Evs;
    private LinearLayout Evt;
    private TextView Evu;
    private View Evv;
    private boolean Evw = true;
    private int Evx = 0;
    String Evy = "";
    private String Evz = "";
    private View contentView;
    private Activity mContext;
    public int style = 0;
    private ImageView uzC;

    public RangeWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(98226);
        init(context);
        AppMethodBeat.o(98226);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(98227);
        init(context);
        AppMethodBeat.o(98227);
    }

    public void setEnablePrivate(boolean z) {
        this.Evw = z;
    }

    public int getLabelRange() {
        return this.Evx;
    }

    private void init(Context context) {
        int i2 = 1;
        AppMethodBeat.i(98228);
        this.mContext = (Activity) context;
        this.contentView = View.inflate(context, getLayoutResource(), this);
        this.DOH = aj.faK().DOH;
        this.Evs = (TextView) this.contentView.findViewById(R.id.i14);
        this.ErY = (TextView) this.contentView.findViewById(R.id.eai);
        this.uzC = (ImageView) this.contentView.findViewById(R.id.gr2);
        this.Evt = (LinearLayout) this.contentView.findViewById(R.id.i10);
        this.Evu = (TextView) this.contentView.findViewById(R.id.i0z);
        this.Evv = this.contentView.findViewById(R.id.gr5);
        this.contentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.RangeWidget.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(98224);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(RangeWidget.this.mContext, SnsLabelUI.class);
                intent.putExtra("KLabel_range_index", RangeWidget.this.Evx);
                intent.putExtra("Klabel_name_list", RangeWidget.this.Evz);
                intent.putExtra("Kother_user_name_list", RangeWidget.this.EvA);
                intent.putExtra("Kchat_room_name_list", RangeWidget.this.EvB);
                intent.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
                RangeWidget.this.mContext.startActivityForResult(intent, 5);
                e eVar = e.DUQ;
                if (eVar.DVa != null) {
                    if (eVar.DVa.eTe <= 0) {
                        eVar.DVa.eTe = 1;
                    } else {
                        eVar.DVa.eTe++;
                    }
                }
                a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98224);
            }
        });
        if (!(this.Evt == null || this.Evu == null || this.Evv == null)) {
            this.Evt.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.RangeWidget.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(98225);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (RangeWidget.this.EvC != null) {
                        RangeWidget.this.EvC.onClick(view);
                        e.DUQ.DVa.eTg = 1;
                    }
                    a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98225);
                }
            });
            boolean z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_last_range_enable, 1) == 1;
            this.Evv.setBackground(null);
            this.Evt.setVisibility(8);
            if (z && this.DOH != null && this.DOH.DSe != null && !this.DOH.DSe.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<n> it = this.DOH.DSe.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next.type == 1) {
                        String aCG = com.tencent.mm.plugin.label.a.a.ecg().aCG(next.name);
                        if (aCG != null) {
                            arrayList.add(aCG);
                        }
                    } else if (next.type == 2) {
                        g.aAi();
                        as Kn = ((l) g.af(l.class)).aSN().Kn(next.name);
                        if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                            arrayList.add(next.name);
                        }
                    } else {
                        arrayList.add(next.name);
                    }
                }
                if (!Util.isNullOrNil(arrayList)) {
                    this.Evv.setBackground(context.getResources().getDrawable(R.drawable.b9w));
                    this.Evt.setVisibility(0);
                    this.Evu.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), String.format(context.getResources().getString(R.string.haf), Util.listToString(V(arrayList), ",")), this.Evu.getTextSize()));
                    if (this.DOH.DSg) {
                        i2 = 2;
                    }
                    e.DUQ.DVa.eTf = i2;
                    aj.faB().execute(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.RangeWidget.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(203356);
                            e eVar = e.DUQ;
                            LinkedList<n> linkedList = RangeWidget.this.DOH.DSe;
                            if (!(linkedList == null || linkedList.isEmpty() || eVar.DVa == null)) {
                                ArrayList<String> arrayList = new ArrayList();
                                ArrayList arrayList2 = new ArrayList();
                                ArrayList<String> arrayList3 = new ArrayList();
                                for (n nVar : linkedList) {
                                    switch (nVar.type) {
                                        case 0:
                                            arrayList2.add(nVar.name);
                                            break;
                                        case 1:
                                            arrayList3.add(nVar.name);
                                            break;
                                        case 2:
                                            arrayList.add(nVar.name);
                                            break;
                                    }
                                }
                                if (arrayList3.size() > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    for (String str : arrayList3) {
                                        List<String> aCK = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(str));
                                        if (!(aCK == null || aCK.size() == 0)) {
                                            sb.append(str).append("|").append(aCK.size()).append(";");
                                        }
                                    }
                                    eVar.DVa.eTl = arrayList3.size();
                                    kb kbVar = eVar.DVa;
                                    kbVar.eTm = kbVar.x("LatestTimelinePsotSettingLabelList", sb.toString(), true);
                                }
                                if (arrayList.size() > 0) {
                                    StringBuilder sb2 = new StringBuilder();
                                    for (String str2 : arrayList) {
                                        ArrayList arrayList4 = new ArrayList();
                                        List<String> Id = v.Id(str2);
                                        if (Id != null) {
                                            for (String str3 : Id) {
                                                if (ab.IS(str3)) {
                                                    arrayList4.add(str3);
                                                }
                                            }
                                            sb2.append(str2).append("|").append(arrayList4.size()).append(";");
                                        }
                                    }
                                    eVar.DVa.eTh = arrayList.size();
                                    kb kbVar2 = eVar.DVa;
                                    kbVar2.eTi = kbVar2.x("LatestTimelinePsotSettingGroupList", sb2.toString(), true);
                                }
                                eVar.DVa.eTj = arrayList2.size();
                                kb kbVar3 = eVar.DVa;
                                kbVar3.eTk = kbVar3.x("LatestTimelinePsotSettingUinList", Util.listToString(arrayList2, "|"), true);
                            }
                            AppMethodBeat.o(203356);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(98228);
    }

    private static List<String> V(List<String> list) {
        AppMethodBeat.i(98229);
        LinkedList linkedList = new LinkedList();
        g.aAi();
        if (!g.aAf().azp()) {
            AppMethodBeat.o(98229);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(98229);
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
            AppMethodBeat.o(98229);
            return linkedList;
        }
    }

    public boolean a(int i2, int i3, Intent intent, AtContactWidget atContactWidget) {
        AppMethodBeat.i(98230);
        this.Evx = intent.getIntExtra("Ktag_range_index", 0);
        this.Evz = intent.getStringExtra("Klabel_name_list");
        this.EvA = intent.getStringExtra("Kother_user_name_list");
        this.EvB = intent.getStringExtra("Kchat_room_name_list");
        int maxTagNameLen = getMaxTagNameLen();
        String str = "";
        if (!Util.isNullOrNil(this.EvB)) {
            str = str + Util.listToString(V(Arrays.asList(this.EvB.split(","))), ",");
        }
        if (!Util.isNullOrNil(this.Evz)) {
            if (str.length() > 0) {
                str = str + "," + this.Evz;
            } else {
                str = str + this.Evz;
            }
        }
        if (!Util.isNullOrNil(this.EvA)) {
            String listToString = Util.listToString(V(Arrays.asList(this.EvA.split(","))), ",");
            if (str.length() > 0) {
                str = str + "," + listToString;
            } else {
                str = str + listToString;
            }
        }
        if (!(maxTagNameLen == -1 || str == null || str.length() <= maxTagNameLen)) {
            str = str.substring(0, maxTagNameLen) + "...";
        }
        int i4 = this.Evx;
        SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), str, this.Evs.getTextSize());
        if (this.uzC != null) {
            this.uzC.setImageDrawable(ar.m(this.mContext, R.raw.album_group_icon_pressed, getContext().getResources().getColor(R.color.afp)));
            this.ErY.setTextColor(getResources().getColor(R.color.ts));
            this.Evs.setTextColor(getResources().getColor(R.color.ts));
        }
        if (this.Eoy != null) {
            this.Eoy.setPrivated(false);
        }
        switch (i4) {
            case 0:
                if (this.uzC != null) {
                    this.uzC.setImageDrawable(ar.m(this.mContext, R.raw.album_group_icon_normal, getContext().getResources().getColor(R.color.vm)));
                    this.ErY.setTextColor(getResources().getColor(R.color.a2x));
                    this.Evs.setTextColor(getResources().getColor(R.color.uj));
                }
                this.Evs.setText(R.string.h7n);
                break;
            case 1:
                if (this.Eoy != null) {
                    this.Eoy.setPrivated(true);
                }
                if (!(atContactWidget == null || this.Eoy == null || atContactWidget.getAtList().size() <= 0)) {
                    h.n(this.mContext, R.string.haq, R.string.zb);
                    atContactWidget.ffm();
                    this.Eoy.fjD();
                }
                this.Evs.setText(R.string.h7l);
                break;
            case 2:
                if (this.uzC != null) {
                    this.uzC.setImageDrawable(ar.m(this.mContext, R.raw.album_group_icon_normal, getResources().getColor(R.color.ts)));
                    this.ErY.setText(getResources().getString(R.string.hay));
                    this.ErY.setTextColor(getResources().getColor(R.color.ts));
                    this.Evs.setTextColor(getResources().getColor(R.color.ts));
                }
                this.Evs.setText(b2);
                break;
            case 3:
                if (this.uzC != null) {
                    this.uzC.setImageDrawable(ar.m(this.mContext, R.raw.album_group_icon_normal, -65536));
                    this.ErY.setText(getResources().getString(R.string.hae));
                    this.ErY.setTextColor(-65536);
                    this.Evs.setTextColor(-65536);
                }
                this.Evs.setText(b2);
                break;
        }
        AppMethodBeat.o(98230);
        return true;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.bkh;
    }

    /* access modifiers changed from: protected */
    public int getMaxTagNameLen() {
        return -1;
    }

    public void setRangeTipClickListener(View.OnClickListener onClickListener) {
        this.EvC = onClickListener;
    }
}
