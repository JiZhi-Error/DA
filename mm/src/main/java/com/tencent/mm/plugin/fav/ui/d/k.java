package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.util.ArrayList;
import java.util.LinkedList;

public final class k extends b {
    private static int tlc;

    public static class a extends b.C1049b {
        View tlA;
        ImageView tlB;
        ImageView tlC;
        View tlD;
        TextView tlE;
        TextView tlF;
        TextView tlG;
        ImageView tlH;
        TextView tlI;
        TextView tlJ;
        TextView tlK;
        TextView tlL;
        View tlw;
        View tlx;
        View tly;
        View tlz;
    }

    public k(o oVar) {
        super(oVar);
        AppMethodBeat.i(107469);
        tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.eb);
        AppMethodBeat.o(107469);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        boolean z;
        String X;
        String[] strArr;
        String str;
        int asl;
        String str2;
        AppMethodBeat.i(107470);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7p, null), aVar2, gVar);
            aVar2.tlw = view.findViewById(R.id.gx0);
            aVar2.tlx = view.findViewById(R.id.b9q);
            aVar2.tly = view.findViewById(R.id.j9w);
            aVar2.tlz = view.findViewById(R.id.azf);
            aVar2.tlA = view.findViewById(R.id.cct);
            aVar2.tlB = (ImageView) view.findViewById(R.id.ccr);
            aVar2.tlD = view.findViewById(R.id.cc5);
            aVar2.tlC = (ImageView) view.findViewById(R.id.cc9);
            aVar2.tlE = (TextView) view.findViewById(R.id.cc6);
            aVar2.tlF = (TextView) view.findViewById(R.id.ccx);
            aVar2.tlG = (TextView) view.findViewById(R.id.ccs);
            aVar2.tlH = (ImageView) view.findViewById(R.id.cbh);
            aVar2.tlI = (TextView) view.findViewById(R.id.cb_);
            aVar2.tlJ = (TextView) view.findViewById(R.id.cb9);
            aVar2.tlK = (TextView) view.findViewById(R.id.cdw);
            aVar2.tlL = (TextView) view.findViewById(R.id.cbb);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        LinkedList<aml> linkedList = gVar.field_favProto.ppH;
        if (linkedList.size() < 2) {
            Log.e("MicroMsg.Fav.FavNoteListItem", "no other item");
            AppMethodBeat.o(107470);
        } else {
            int i2 = -1;
            int i3 = 0;
            int size = linkedList.size();
            boolean z2 = false;
            int i4 = -1;
            boolean z3 = true;
            int i5 = 0;
            while (true) {
                int i6 = i3;
                if (i5 < linkedList.size()) {
                    aml aml = linkedList.get(i5);
                    if (i5 != 0) {
                        if (aml.dataType == 2 || aml.dataType == 4 || aml.dataType == 15) {
                            i6++;
                            z2 = true;
                            if (i2 == -1) {
                                i2 = i5;
                            }
                        }
                        switch (aml.dataType) {
                            case 1:
                                if (Util.nullAs(aml.desc, "").trim().length() <= 0) {
                                    size--;
                                    break;
                                }
                            case 2:
                            case 4:
                            case 9:
                            case 12:
                            case 13:
                            case 15:
                            case 17:
                            case 18:
                            case 19:
                            case 21:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            default:
                                z3 = false;
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 10:
                            case 11:
                            case 14:
                            case 16:
                            case 20:
                            case 22:
                            case 29:
                                i4 = i5;
                                break;
                        }
                    } else {
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.d(aml));
                        if (!oVar.exists()) {
                            o.b(gVar, aml);
                        } else if (aml.Lwp == null) {
                            oc ocVar = new oc();
                            ocVar.dUe.type = 10;
                            ocVar.dUe.field_localId = gVar.field_localId;
                            ocVar.dUe.path = aa.z(oVar.her());
                            EventCenter.instance.publish(ocVar);
                        }
                    }
                    i3 = i6;
                    i5++;
                } else {
                    if (!z3 || size != 2) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z || i4 <= 0) {
                        aVar.tlw.setVisibility(0);
                        aVar.tlx.setVisibility(8);
                        aVar.tly.setVisibility(8);
                        aVar.tlz.setVisibility(8);
                        ArrayList arrayList = new ArrayList();
                        String str3 = null;
                        for (int i7 = 1; i7 < linkedList.size(); i7++) {
                            aml aml2 = linkedList.get(i7);
                            if (aml2.dataType == 1) {
                                String str4 = aml2.desc;
                                if (!Util.isNullOrNil(str4)) {
                                    if (str4.length() > 1000) {
                                        str4 = str4.substring(0, 1000);
                                    }
                                    strArr = str4.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split("\n");
                                } else {
                                    strArr = null;
                                }
                                if (strArr != null && strArr.length > 0) {
                                    ArrayList arrayList2 = new ArrayList();
                                    int i8 = 0;
                                    while (true) {
                                        if (i8 >= strArr.length) {
                                            i8 = 0;
                                        } else if (!Util.isNullOrNil(strArr[i8].trim())) {
                                            arrayList2.add(strArr[i8]);
                                        } else {
                                            i8++;
                                        }
                                    }
                                    String str5 = "";
                                    for (int i9 = i8 + 1; i9 < strArr.length; i9++) {
                                        str5 = str5 + strArr[i9] + " ";
                                    }
                                    String trim = str5.trim();
                                    if (trim.length() > 0) {
                                        arrayList2.add(trim);
                                    }
                                    int i10 = 0;
                                    if (arrayList2.size() <= 0 || !Util.isNullOrNil(str3)) {
                                        str = str3;
                                    } else {
                                        str = (String) arrayList2.get(0);
                                        i10 = 1;
                                    }
                                    while (i10 < arrayList2.size()) {
                                        arrayList.add(arrayList2.get(i10));
                                        i10++;
                                    }
                                    str3 = str;
                                }
                            } else {
                                try {
                                    Context context2 = view.getContext();
                                    switch (aml2.dataType) {
                                        case 3:
                                        case 20:
                                            X = n.X(context2, R.string.ccn) + " " + n.W(context2, (int) com.tencent.mm.plugin.fav.a.b.DO((long) aml2.duration));
                                            break;
                                        case 5:
                                            X = n.X(context2, R.string.ccl) + " " + aml2.title;
                                            break;
                                        case 6:
                                            ams ams = aml2.Lwh.LwQ;
                                            if (ams != null) {
                                                if (n.asr(ams.dWi)) {
                                                    X = n.X(context2, R.string.cch) + " " + ams.dWi;
                                                    break;
                                                } else {
                                                    X = n.X(context2, R.string.cch) + " " + ams.label;
                                                    break;
                                                }
                                            } else {
                                                X = n.X(context2, R.string.cch);
                                                break;
                                            }
                                        case 7:
                                        case 29:
                                            X = n.X(context2, R.string.cci) + " " + aml2.title;
                                            break;
                                        case 8:
                                            X = n.X(context2, R.string.ccc) + " " + aml2.title;
                                            break;
                                        case 10:
                                            X = n.X(context2, R.string.ca6) + " " + aml2.Lwh.LwU.title;
                                            break;
                                        case 16:
                                            X = n.X(context2, R.string.c_n);
                                            break;
                                        case 22:
                                            if (!com.tencent.mm.plugin.fav.a.b.cUq()) {
                                                X = n.X(context2, R.string.ccl) + " " + aml2.title;
                                                break;
                                            }
                                        default:
                                            X = "";
                                            break;
                                    }
                                    if (!Util.isNullOrNil(X)) {
                                        arrayList.add(X);
                                    }
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.Fav.FavNoteListItem", "getDataItemDesc exception:".concat(String.valueOf(e2)));
                                }
                            }
                        }
                        if (!Util.isNullOrNil(str3)) {
                            aVar.tlF.setText(l.b(aVar.tlF.getContext(), str3, aVar.tlF.getTextSize()));
                            aVar.tlF.setVisibility(0);
                            if (arrayList.size() > 0) {
                                aVar.tlF.setMaxLines(1);
                            } else {
                                aVar.tlF.setMaxLines(3);
                            }
                        } else {
                            aVar.tlF.setVisibility(8);
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        int i11 = 0;
                        while (i11 < arrayList.size() && i11 < 2) {
                            stringBuffer.append((String) arrayList.get(i11));
                            stringBuffer.append("\n");
                            i11++;
                        }
                        if (stringBuffer.length() != 0) {
                            aVar.tlG.setText(l.b(aVar.tlG.getContext(), stringBuffer.substring(0, stringBuffer.length() - 1), aVar.tlG.getTextSize()));
                            aVar.tlG.setVisibility(0);
                        } else {
                            aVar.tlG.setVisibility(8);
                        }
                        if (z2) {
                            aVar.tlA.setVisibility(0);
                            aml aml3 = linkedList.get(i2);
                            if (linkedList.get(i2).dataType == 2) {
                                ImageView imageView = aVar.tlB;
                                int i12 = tlc;
                                o.a(imageView, (int) R.raw.fav_list_img_default, aml3, gVar, true, i12, i12);
                                aVar.tlC.setVisibility(8);
                            } else {
                                aVar.tlC.setVisibility(0);
                                o oVar2 = this.tdg;
                                ImageView imageView2 = aVar.tlB;
                                String str6 = aml3.dFN;
                                int i13 = tlc;
                                oVar2.a(imageView2, aml3, gVar, str6, R.raw.app_attach_file_icon_video, i13, i13);
                            }
                            if (i6 > 1) {
                                aVar.tlE.setText(view.getContext().getString(R.string.c_r, Integer.valueOf(i6)));
                                aVar.tlE.setVisibility(0);
                                aVar.tlD.setVisibility(0);
                            } else {
                                aVar.tlE.setVisibility(8);
                                aVar.tlD.setVisibility(8);
                            }
                        } else {
                            aVar.tlA.setVisibility(8);
                        }
                    } else {
                        aml aml4 = linkedList.get(i4);
                        if (aml4.dataType == 3) {
                            aVar.tlw.setVisibility(8);
                            aVar.tlx.setVisibility(8);
                            aVar.tly.setVisibility(0);
                            aVar.tlz.setVisibility(8);
                            aVar.tlK.setText(n.W(this.tdg.context, (int) com.tencent.mm.plugin.fav.a.b.DO((long) aml4.duration)));
                        } else if (aml4.dataType == 20) {
                            aVar.tlw.setVisibility(8);
                            aVar.tlx.setVisibility(8);
                            aVar.tly.setVisibility(8);
                            aVar.tlz.setVisibility(0);
                            aVar.tlL.setText(n.W(this.tdg.context, (int) com.tencent.mm.plugin.fav.a.b.DO((long) aml4.duration)));
                        } else {
                            String str7 = null;
                            if (aml4.dataType == 6) {
                                asl = R.raw.app_attach_file_icon_location;
                                ams ams2 = aml4.Lwh.LwQ;
                                String str8 = aml4.Lwh.remark;
                                if (Util.isNullOrNil(str8)) {
                                    if (n.asr(b(ams2))) {
                                        str8 = b(ams2);
                                    } else {
                                        str2 = a(ams2);
                                    }
                                } else if (n.asr(b(ams2))) {
                                    str7 = b(ams2);
                                    str2 = str8;
                                }
                                str7 = a(ams2);
                                str2 = str8;
                            } else {
                                asl = e.asl(aml4.LvC);
                                str2 = aml4.title;
                                str7 = aml4.desc;
                                if (Util.isNullOrNil(str7)) {
                                    str7 = com.tencent.mm.plugin.fav.a.b.getLengthStr((float) aml4.LvI);
                                }
                            }
                            aVar.tly.setVisibility(8);
                            aVar.tlz.setVisibility(8);
                            aVar.tlw.setVisibility(8);
                            aVar.tlx.setVisibility(0);
                            aVar.tlH.setImageResource(asl);
                            aVar.tlI.setText(str2);
                            if (!Util.isNullOrNil(str7)) {
                                aVar.tlJ.setText(str7);
                                aVar.tlJ.setVisibility(0);
                            } else {
                                aVar.tlJ.setVisibility(8);
                            }
                        }
                    }
                    AppMethodBeat.o(107470);
                }
            }
        }
        return view;
    }

    private static String a(ams ams) {
        AppMethodBeat.i(107471);
        if (ams == null) {
            Log.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
            AppMethodBeat.o(107471);
            return "";
        }
        String str = ams.label;
        AppMethodBeat.o(107471);
        return str;
    }

    private static String b(ams ams) {
        AppMethodBeat.i(107472);
        if (ams == null) {
            Log.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
            AppMethodBeat.o(107472);
            return "";
        }
        String str = ams.dWi;
        AppMethodBeat.o(107472);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107473);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107473);
    }
}
