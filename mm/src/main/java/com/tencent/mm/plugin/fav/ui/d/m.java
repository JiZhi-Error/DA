package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class m extends b {
    private HashMap<String, SpannableString> tlN = new HashMap<>();
    private final int tlc;

    public static class a extends b.C1049b {
        ImageView nnL;
        ImageView tlC;
        ImageView tlO;
        TextView tlP;
        TextView tlQ;
        TextView tlR;
        TextView tlS;
        FrameLayout tlT;
    }

    public m(o oVar) {
        super(oVar);
        AppMethodBeat.i(107477);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.eb);
        AppMethodBeat.o(107477);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        String str;
        AppMethodBeat.i(107478);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7k, null), aVar2, gVar);
            aVar2.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar2.tlP = (TextView) view.findViewById(R.id.cdn);
            aVar2.tlQ = (TextView) view.findViewById(R.id.cbm);
            aVar2.tlR = (TextView) view.findViewById(R.id.cdo);
            aVar2.tlS = (TextView) view.findViewById(R.id.cbn);
            aVar2.tlC = (ImageView) view.findViewById(R.id.cc9);
            aVar2.tlO = (ImageView) view.findViewById(R.id.cc8);
            aVar2.tlT = (FrameLayout) view.findViewById(R.id.cc4);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        LinkedList<aml> linkedList = gVar.field_favProto.ppH;
        for (aml aml : linkedList) {
            switch (aml.dataType) {
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 14:
                case 16:
                case 17:
                case 22:
                case 29:
                    if (!z2) {
                        z2 = true;
                        i2 = i4;
                        continue;
                        i4++;
                    }
                    break;
                case 2:
                case 4:
                case 15:
                    if (!z) {
                        z = true;
                        z2 = z2;
                        i3 = i4;
                        i2 = i2;
                        continue;
                        i4++;
                    }
                    break;
            }
            z2 = z2;
            i2 = i2;
            i4++;
        }
        Log.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (linkedList.size() <= 0) {
            Log.w("MicroMsg.FavRecordListItem", "dataList size is null");
            AppMethodBeat.o(107478);
        } else {
            a(aVar.tlP, aVar.tlQ, linkedList.get(i2));
            if (z) {
                aVar.tlT.setVisibility(0);
                aVar.nnL.setVisibility(0);
                ImageView imageView = aVar.nnL;
                aml aml2 = linkedList.get(i3);
                switch (aml2.dataType) {
                    case 2:
                        o oVar = this.tdg;
                        int i5 = this.tlc;
                        int i6 = this.tlc;
                        if (imageView != null) {
                            if (e.apn()) {
                                if (!(aml2 == null || gVar == null || (str = aml2.dLl) == null)) {
                                    String[] strArr = null;
                                    if (aml2.dLl != null) {
                                        String[] strArr2 = oVar.tgg.get(str);
                                        if (strArr2 == null) {
                                            strArr = new String[]{com.tencent.mm.plugin.fav.a.b.d(aml2), com.tencent.mm.plugin.fav.a.b.a(aml2)};
                                            oVar.tgg.put(str, strArr);
                                        } else {
                                            strArr = strArr2;
                                        }
                                    }
                                    oVar.tgf.a(imageView, strArr, null, R.raw.record_nopicture_icon, i5, i6);
                                    if (strArr != null && strArr.length > 0) {
                                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable(strArr[0], gVar, aml2) {
                                            /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass2 */
                                            final /* synthetic */ String jsE;
                                            final /* synthetic */ g sZS;
                                            final /* synthetic */ aml tfL;

                                            {
                                                this.jsE = r2;
                                                this.sZS = r3;
                                                this.tfL = r4;
                                            }

                                            public final void run() {
                                                AppMethodBeat.i(106962);
                                                if (o.gi(this.jsE)) {
                                                    com.tencent.mm.plugin.fav.a.b.a(this.sZS, this.tfL, false);
                                                }
                                                AppMethodBeat.o(106962);
                                            }

                                            public final String toString() {
                                                AppMethodBeat.i(106963);
                                                String str = super.toString() + "|attachImg";
                                                AppMethodBeat.o(106963);
                                                return str;
                                            }
                                        });
                                        break;
                                    }
                                }
                            } else {
                                imageView.setImageResource(R.drawable.bjn);
                                break;
                            }
                        }
                        break;
                    case 4:
                    case 15:
                        this.tdg.b(imageView, aml2, gVar, R.raw.app_attach_file_icon_video, this.tlc, this.tlc);
                        break;
                }
            } else {
                aVar.tlT.setVisibility(8);
                aVar.nnL.setVisibility(8);
            }
            if (i2 + 1 < linkedList.size()) {
                aVar.tlR.setVisibility(0);
                aVar.tlS.setVisibility(0);
                a(aVar.tlR, aVar.tlS, linkedList.get(i2 + 1));
            } else {
                aVar.tlR.setVisibility(8);
                aVar.tlS.setVisibility(8);
            }
            AppMethodBeat.o(107478);
        }
        return view;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(TextView textView, TextView textView2, aml aml) {
        String str;
        AppMethodBeat.i(107479);
        if (!aml.Lwk) {
            Log.d("MicroMsg.FavRecordListItem", "has no datasrcname");
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(l.b(textView.getContext(), aml.Lwj, textView.getTextSize()));
        }
        Log.d("MicroMsg.FavRecordListItem", "field type %d", Integer.valueOf(aml.dataType));
        switch (aml.dataType) {
            case 1:
                textView2.setText(l.b(textView2.getContext(), aml.desc, textView2.getTextSize()));
                AppMethodBeat.o(107479);
                return;
            case 2:
                textView2.setText(X(textView2.getContext(), R.string.ccf));
                AppMethodBeat.o(107479);
                return;
            case 3:
                textView2.setText(X(textView2.getContext(), R.string.ccn));
                AppMethodBeat.o(107479);
                return;
            case 4:
                textView2.setText(X(textView2.getContext(), R.string.ccm));
                AppMethodBeat.o(107479);
                return;
            case 5:
                textView2.setText(X(textView2.getContext(), R.string.ccl) + aml.title);
                AppMethodBeat.o(107479);
                return;
            case 6:
                ams ams = aml.Lwh.LwQ;
                StringBuilder append = new StringBuilder().append(X(textView2.getContext(), R.string.cch));
                if (Util.isNullOrNil(ams.dWi)) {
                    str = ams.label;
                } else {
                    str = ams.dWi;
                }
                textView2.setText(append.append(str).toString());
                AppMethodBeat.o(107479);
                return;
            case 7:
            case 29:
                textView2.setText(X(textView2.getContext(), R.string.cci) + aml.title);
                AppMethodBeat.o(107479);
                return;
            case 8:
                textView2.setText(X(textView2.getContext(), R.string.ccc) + aml.title);
                AppMethodBeat.o(107479);
                return;
            case 10:
                textView2.setText(X(textView2.getContext(), R.string.ca6) + aml.Lwh.LwU.title);
                AppMethodBeat.o(107479);
                return;
            case 15:
                textView2.setText(X(textView2.getContext(), R.string.cc9));
                AppMethodBeat.o(107479);
                return;
            case 16:
                textView2.setText(X(textView2.getContext(), R.string.c_n));
                AppMethodBeat.o(107479);
                return;
            case 17:
                textView2.setText(X(textView2.getContext(), R.string.cck));
                AppMethodBeat.o(107479);
                return;
            case 19:
                textView2.setText(X(textView2.getContext(), R.string.cca) + aml.title);
                break;
            case 22:
                if (com.tencent.mm.plugin.fav.a.b.cUq()) {
                    textView2.setText("");
                    AppMethodBeat.o(107479);
                    return;
                }
                textView2.setText(X(textView2.getContext(), R.string.ccl) + Util.nullAsNil(aml.title));
                AppMethodBeat.o(107479);
                return;
        }
        AppMethodBeat.o(107479);
    }

    private static String X(Context context, int i2) {
        AppMethodBeat.i(107480);
        String str = "[" + context.getResources().getString(i2) + "]";
        AppMethodBeat.o(107480);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107481);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107481);
    }
}
