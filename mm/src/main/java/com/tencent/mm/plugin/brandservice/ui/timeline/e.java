package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.brandservice.ui.b.b;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.z;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

public final class e extends BaseAdapter {
    private int dEb;
    private int gwE;
    List<z> nZr;
    aa.c pmx = new aa.c() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.e.AnonymousClass1 */

        @Override // com.tencent.mm.storage.aa.c
        public final void a(Object obj, aa.a aVar) {
            e eVar;
            z cmo;
            AppMethodBeat.i(5905);
            if (aVar != null) {
                if (aVar.NQE == aa.b.INSERT && aVar.psm != null) {
                    e.this.nZr.add(0, aVar.psm);
                } else if (aVar.NQE == aa.b.DELETE && (cmo = (eVar = e.this).cmo()) != null) {
                    eVar.nZr.clear();
                    eVar.nZr.addAll(ae.o(ag.bap().iFy.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[]{String.valueOf(cmo.field_createTime)}, null, null, "createTime DESC")));
                }
            }
            e.this.notifyDataSetChanged();
            AppMethodBeat.o(5905);
        }
    };
    private BizTimeLineNewMsgUI prY;
    private long prZ;
    boolean prk = false;
    boolean psa = false;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(5914);
        z De = De(i2);
        AppMethodBeat.o(5914);
        return De;
    }

    public e(BizTimeLineNewMsgUI bizTimeLineNewMsgUI, List<z> list, int i2, int i3, long j2) {
        AppMethodBeat.i(5908);
        this.prY = bizTimeLineNewMsgUI;
        ag.bap().a(this.pmx, Looper.getMainLooper());
        this.nZr = list;
        this.gwE = i2;
        this.dEb = i3;
        this.prZ = j2;
        AppMethodBeat.o(5908);
    }

    public final int getCount() {
        AppMethodBeat.i(5909);
        int size = this.nZr.size();
        AppMethodBeat.o(5909);
        return size;
    }

    public final z De(int i2) {
        AppMethodBeat.i(5910);
        if (i2 < this.nZr.size()) {
            z zVar = this.nZr.get(i2);
            AppMethodBeat.o(5910);
            return zVar;
        }
        AppMethodBeat.o(5910);
        return null;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    static class a {
        View aus;
        ImageView gyr;
        TextView kcZ;
        View obi;
        TextView psc;
        ViewGroup psd;
        AppBrandNearbyShowcaseView pse;
        TextView timeTv;
        TextView titleTv;

        a() {
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        String displayName;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        k.b HD;
        AppMethodBeat.i(5911);
        z De = De(i2);
        if (De == null) {
            Log.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
            AppMethodBeat.o(5911);
        } else {
            String str2 = De.field_talker;
            int i3 = 0;
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.prY, R.layout.k2, null);
                aVar2.aus = view;
                aVar2.gyr = (ImageView) view.findViewById(R.id.x1);
                aVar2.kcZ = (TextView) view.findViewById(R.id.fz_);
                d dVar = d.pMy;
                d.i(aVar2.kcZ);
                aVar2.timeTv = (TextView) view.findViewById(R.id.in3);
                aVar2.titleTv = (TextView) view.findViewById(R.id.ir3);
                aVar2.psc = (TextView) view.findViewById(R.id.ir4);
                aVar2.obi = view.findViewById(R.id.aar);
                aVar2.psd = (ViewGroup) view.findViewById(R.id.a6z);
                aVar2.pse = (AppBrandNearbyShowcaseView) view.findViewById(R.id.a72);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.psd.setVisibility(8);
            if (De.gAw()) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(De.field_talker);
                if (Kn == null || !c.oR(Kn.field_type)) {
                    if (De.gAB() != null) {
                        c.a aVar3 = new c.a();
                        aVar3.jbq = R.drawable.bca;
                        aVar3.jbe = true;
                        aVar3.iaT = true;
                        q.bcV().a(De.gAB().iAR, aVar.gyr, aVar3.bdv());
                    }
                }
                a(aVar.gyr, De.field_talker);
            } else {
                if (De.gAx()) {
                    String I = com.tencent.mm.storage.ag.I(De);
                    if (!Util.isNullOrNil(I)) {
                        a(aVar.gyr, I);
                    }
                }
                a(aVar.gyr, De.field_talker);
            }
            if (De.gAw()) {
                displayName = De.gAB().nickName;
            } else {
                displayName = com.tencent.mm.model.aa.getDisplayName(De.field_talker);
            }
            aVar.titleTv.setMaxLines(Integer.MAX_VALUE);
            aVar.psc.setVisibility(8);
            aVar.kcZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.prY, displayName, aVar.kcZ.getTextSize()));
            aVar.timeTv.setText(b.f(this.prY, De.field_createTime));
            if (De.gAt()) {
                String HH = m.HH(De.field_content);
                if (Util.isNullOrNil(HH)) {
                    HH = this.prY.getString(R.string.ai1);
                }
                aVar.titleTv.setText(HH);
                str = str2;
            } else {
                if (!De.isText()) {
                    if (De.field_type == 10000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (De.gAw()) {
                            aVar.titleTv.setText(De.gAB().title);
                            str = str2;
                        } else if (De.gAz()) {
                            SpannableStringBuilder i4 = com.tencent.mm.storage.ag.i(De, 0);
                            if (!Util.isNullOrNil(i4)) {
                                aVar.titleTv.setText(i4);
                                com.tencent.mm.storage.ag.b(De, 0, aVar.titleTv);
                                SpannableStringBuilder i5 = com.tencent.mm.storage.ag.i(De, 1);
                                if (!Util.isNullOrNil(i5)) {
                                    aVar.psc.setText(i5);
                                    aVar.psc.setVisibility(0);
                                    com.tencent.mm.storage.ag.b(De, 1, aVar.psc);
                                }
                                String L = com.tencent.mm.storage.ag.L(De);
                                if (!Util.isNullOrNil(L)) {
                                    aVar.kcZ.setText(L);
                                }
                                str = str2;
                            } else {
                                aVar.titleTv.setText(this.prY.getString(R.string.xr));
                                str = str2;
                            }
                        } else if (De.gAy()) {
                            aVar.titleTv.setText(this.prY.getString(R.string.zz));
                            str = str2;
                        } else {
                            if (De.field_type == 43) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                aVar.titleTv.setText(this.prY.getString(R.string.zv));
                                str = str2;
                            } else {
                                if (De.field_type == 42 || De.field_type == 66) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    aVar.titleTv.setText(this.prY.getString(R.string.y1));
                                    str = str2;
                                } else if (com.tencent.mm.storage.ag.J(De)) {
                                    aVar.titleTv.setText(com.tencent.mm.storage.ag.h(De, 0));
                                    com.tencent.mm.storage.ag.a(De, 0, aVar.titleTv);
                                    SpannableStringBuilder h2 = com.tencent.mm.storage.ag.h(De, 1);
                                    if (!Util.isNullOrNil(h2)) {
                                        aVar.psc.setText(h2);
                                        aVar.psc.setVisibility(0);
                                        com.tencent.mm.storage.ag.a(De, 1, aVar.psc);
                                    }
                                    p.h(De, "info");
                                    String str3 = "";
                                    Map<String, String> K = com.tencent.mm.storage.ag.K(De);
                                    if (!(K == null || K == null)) {
                                        StringBuilder sb = new StringBuilder();
                                        String str4 = K.get(".msg.appmsg.mmreader.notify_msg.title2");
                                        if (str4 == null) {
                                            str4 = "";
                                        }
                                        StringBuilder append = sb.append(str4).append(' ');
                                        String str5 = K.get(".msg.appmsg.mmreader.notify_msg.action");
                                        if (str5 == null) {
                                            str5 = "";
                                        }
                                        str3 = append.append(str5).toString();
                                    }
                                    if (!Util.isNullOrNil(str3)) {
                                        aVar.kcZ.setText(str3);
                                    }
                                    str = com.tencent.mm.storage.ag.I(De);
                                    i3 = com.tencent.mm.storage.ag.f(De);
                                } else {
                                    if ((De.field_type & 65535) == 49) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (!z4 || (HD = k.b.HD(De.field_content)) == null) {
                                        aVar.titleTv.setText(this.prY.getString(R.string.aid));
                                        str = str2;
                                    } else {
                                        String str6 = "";
                                        switch (HD.type) {
                                            case 1:
                                                str6 = HD.title;
                                                break;
                                            case 2:
                                                str6 = this.prY.getString(R.string.xr);
                                                break;
                                            case 3:
                                                str6 = this.prY.getString(R.string.wv) + HD.title;
                                                break;
                                            case 4:
                                                str6 = this.prY.getString(R.string.zv) + HD.title;
                                                break;
                                            case 5:
                                                str6 = this.prY.getString(R.string.zp) + HD.getTitle();
                                                break;
                                            case 16:
                                                str6 = this.prY.getString(R.string.y1) + HD.getTitle();
                                                break;
                                            case 2001:
                                            case 436207665:
                                            case 469762097:
                                                str6 = "[" + HD.iyo + "]" + HD.iyk;
                                                break;
                                        }
                                        if (Util.isNullOrNil(str6)) {
                                            str6 = HD.getTitle();
                                        }
                                        aVar.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.prY, str6, aVar.titleTv.getTextSize()));
                                        str = str2;
                                    }
                                }
                            }
                        }
                    }
                }
                SpannableStringBuilder i6 = com.tencent.mm.storage.ag.i(De, 0);
                if (!Util.isNullOrNil(i6)) {
                    aVar.titleTv.setText(i6);
                    com.tencent.mm.storage.ag.b(De, 0, aVar.titleTv);
                    SpannableStringBuilder i7 = com.tencent.mm.storage.ag.i(De, 1);
                    if (!Util.isNullOrNil(i7)) {
                        aVar.psc.setText(i7);
                        aVar.psc.setVisibility(0);
                        com.tencent.mm.storage.ag.b(De, 1, aVar.psc);
                        String L2 = com.tencent.mm.storage.ag.L(De);
                        if (!Util.isNullOrNil(L2)) {
                            aVar.kcZ.setText(L2);
                        }
                    }
                    str = str2;
                } else {
                    aVar.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.d((Context) this.prY, (CharSequence) De.field_content, (int) aVar.titleTv.getTextSize()));
                    str = str2;
                }
            }
            if (i2 == getCount() - 1) {
                aVar.obi.setVisibility(4);
            } else {
                aVar.obi.setVisibility(0);
            }
            Df(i2);
            com.tencent.mm.storage.ag.a(str, 0, i3, De.field_msgId, i2, this.dEb, this.gwE - 1, (int) this.prZ);
            AppMethodBeat.o(5911);
        }
        return view;
    }

    public final z cmo() {
        AppMethodBeat.i(5912);
        if (this.nZr.size() > 0) {
            z zVar = this.nZr.get(this.nZr.size() - 1);
            AppMethodBeat.o(5912);
            return zVar;
        }
        AppMethodBeat.o(5912);
        return null;
    }

    public final void Df(final int i2) {
        AppMethodBeat.i(5913);
        if (this.gwE != 1 || this.psa) {
            if (i2 == getCount() - 1 && !this.prk) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.e.AnonymousClass2 */

                    /* JADX WARNING: Removed duplicated region for block: B:10:0x0077  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        // Method dump skipped, instructions count: 174
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.e.AnonymousClass2.run():void");
                    }
                }, 300);
            }
            AppMethodBeat.o(5913);
            return;
        }
        AppMethodBeat.o(5913);
    }

    private static void a(ImageView imageView, String str) {
        AppMethodBeat.i(194916);
        if (ab.IT(str)) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
            layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
            imageView.setLayoutParams(layoutParams);
            a.b.d(imageView, str);
            AppMethodBeat.o(194916);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        layoutParams2.width = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 36);
        layoutParams2.height = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 36);
        imageView.setLayoutParams(layoutParams2);
        a.b.c(imageView, str);
        AppMethodBeat.o(194916);
    }
}
