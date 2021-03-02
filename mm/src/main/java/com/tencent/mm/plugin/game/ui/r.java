package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends BaseAdapter {
    Context context;
    boolean dDz = false;
    ArrayList<b> gUV;
    int xGW = 0;
    int xTs = 0;
    boolean xVK = false;
    int xVL = 0;
    int xVM = 0;
    int xVN = 0;
    int xVO = 0;
    private int xVP;
    boolean xVQ = false;
    boolean xVR = false;
    private ArrayList<d> xVS;

    public r(Context context2) {
        AppMethodBeat.i(42373);
        this.context = context2;
        this.gUV = null;
        this.xVP = context2.getResources().getColor(R.color.tg);
        AppMethodBeat.o(42373);
    }

    public final int getCount() {
        AppMethodBeat.i(42374);
        if (this.gUV == null) {
            AppMethodBeat.o(42374);
            return 0;
        }
        int size = this.gUV.size();
        AppMethodBeat.o(42374);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(42375);
        b bVar = this.gUV.get(i2);
        AppMethodBeat.o(42375);
        return bVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(42376);
        int i3 = ((b) getItem(i2)).type;
        AppMethodBeat.o(42376);
        return i3;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        int i3;
        AppMethodBeat.i(42377);
        b bVar = (b) getItem(i2);
        if (view == null) {
            aVar = new a((byte) 0);
            Context context2 = this.context;
            switch (bVar.type) {
                case 0:
                    i3 = R.layout.asl;
                    break;
                case 1:
                    i3 = R.layout.asf;
                    break;
                case 2:
                    i3 = R.layout.asm;
                    break;
                case 3:
                    i3 = R.layout.ask;
                    break;
                case 4:
                default:
                    i3 = 0;
                    break;
                case 5:
                    i3 = R.layout.ash;
                    break;
                case 6:
                    i3 = R.layout.asi;
                    break;
            }
            view = View.inflate(context2, i3, null);
            aVar.contentView = view.findViewById(R.id.dgg);
            aVar.vs = (ImageView) view.findViewById(R.id.dgj);
            aVar.xVW = (TextView) view.findViewById(R.id.dgl);
            aVar.xVX = (TextView) view.findViewById(R.id.dge);
            aVar.xVY = (TextView) view.findViewById(R.id.dgh);
            aVar.xVZ = (TextView) view.findViewById(R.id.dgm);
            aVar.xWa = view.findViewById(R.id.dgi);
            aVar.xWb = (TextView) view.findViewById(R.id.i31);
            aVar.xWc = (TextView) view.findViewById(R.id.bi6);
            view.setTag(aVar);
            if (!(aVar.xVW == null || aVar.xVY == null)) {
                final TextView textView = aVar.xVW;
                final TextView textView2 = aVar.xVY;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class com.tencent.mm.plugin.game.ui.r.AnonymousClass1 */

                    public final void onGlobalLayout() {
                        AppMethodBeat.i(42369);
                        if (textView.getLineCount() > 1) {
                            textView.setMaxLines(2);
                            textView2.setMaxLines(1);
                            AppMethodBeat.o(42369);
                            return;
                        }
                        textView2.setMaxLines(2);
                        AppMethodBeat.o(42369);
                    }
                });
            }
        } else {
            aVar = (a) view.getTag();
        }
        switch (bVar.type) {
            case 0:
                aVar.xVY.setText(bVar.name);
                break;
            case 1:
                if (!Util.isNullOrNil(bVar.iconUrl)) {
                    e.a.C1397a aVar2 = new e.a.C1397a();
                    aVar2.jbd = false;
                    aVar2.jbf = false;
                    e.dWR().a(aVar.vs, bVar.iconUrl, aVar2.dWS());
                }
                d(aVar.xVW, bVar.name);
                d(aVar.xVX, bVar.xWd);
                d(aVar.xVY, bVar.remark);
                break;
            case 2:
                if (!Util.isNullOrNil(bVar.iconUrl)) {
                    e.a.C1397a aVar3 = new e.a.C1397a();
                    aVar3.jbd = false;
                    aVar3.jbf = false;
                    aVar3.xZt = true;
                    e.dWR().a(aVar.vs, bVar.iconUrl, aVar3.dWS());
                    aVar.vs.setVisibility(0);
                } else {
                    aVar.vs.setVisibility(8);
                }
                d(aVar.xVW, bVar.name);
                d(aVar.xVY, bVar.remark);
                if (!Util.isNullOrNil(bVar.iFo)) {
                    aVar.xWb.setText(l.c(this.context, bVar.iFo));
                    aVar.xWb.setVisibility(0);
                } else {
                    aVar.xWb.setVisibility(8);
                }
                if (bVar.createTime > 0) {
                    aVar.xWc.setText(com.tencent.mm.plugin.game.e.b.n(this.context, bVar.createTime * 1000));
                    aVar.xWc.setVisibility(0);
                    break;
                } else {
                    aVar.xWc.setVisibility(8);
                    break;
                }
            case 3:
                if (!Util.isNullOrNil(bVar.iconUrl)) {
                    e.a.C1397a aVar4 = new e.a.C1397a();
                    aVar4.jbd = false;
                    aVar4.jbf = false;
                    e.dWR().a(aVar.vs, bVar.iconUrl, aVar4.dWS());
                }
                d(aVar.xVW, bVar.name);
                d(aVar.xVX, bVar.xWd);
                d(aVar.xVY, bVar.remark);
                TextView textView3 = aVar.xVZ;
                LinkedList<String> linkedList = bVar.xWg;
                StringBuilder sb = new StringBuilder();
                if (!Util.isNullOrNil(linkedList)) {
                    int size = linkedList.size();
                    for (int i4 = 0; i4 < size - 1; i4++) {
                        sb.append(linkedList.get(i4) + "\n");
                    }
                    sb.append(linkedList.get(size - 1));
                    textView3.setVisibility(0);
                    textView3.setText(sb.toString());
                    break;
                } else {
                    textView3.setVisibility(8);
                    break;
                }
            case 5:
                aVar.vs.setImageResource(R.raw.search_more_button_icon);
            case 6:
                aVar.xVW.setText(bVar.name);
                break;
        }
        switch (bVar.type) {
            case 0:
                if (bVar.xWj) {
                    aVar.xWa.setVisibility(8);
                    break;
                } else {
                    aVar.xWa.setVisibility(0);
                    break;
                }
            case 1:
            case 2:
            case 3:
            case 5:
                if (bVar.xWk) {
                    aVar.contentView.setBackgroundResource(R.drawable.qd);
                } else {
                    aVar.contentView.setBackgroundResource(R.drawable.qa);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.jq);
                aVar.contentView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        AppMethodBeat.o(42377);
        return view;
    }

    public final void reset() {
        this.xGW = 0;
        this.xVQ = false;
    }

    static class a {
        public View contentView;
        ImageView vs;
        TextView xVW;
        TextView xVX;
        TextView xVY;
        TextView xVZ;
        View xWa;
        TextView xWb;
        TextView xWc;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static class b {
        public int actionType;
        public String appId;
        public long createTime;
        public String dDv;
        public String iFo;
        public String iconUrl;
        public String name;
        public String remark;
        public int type;
        public String xWd;
        public bgm xWe;
        public String xWf;
        public LinkedList<String> xWg;
        public int xWh;
        public int xWi;
        public boolean xWj = false;
        public boolean xWk = false;
        public c xWl;

        public static b bA(int i2, String str) {
            AppMethodBeat.i(42370);
            b bVar = new b();
            bVar.type = i2;
            bVar.name = str;
            bVar.xWl = new c();
            AppMethodBeat.o(42370);
            return bVar;
        }

        public static b a(bgl bgl) {
            AppMethodBeat.i(42371);
            b bVar = new b();
            bVar.type = 2;
            bVar.name = bgl.Title;
            bVar.remark = bgl.Desc;
            bVar.iconUrl = bgl.ThumbUrl;
            bVar.xWf = bgl.LPS;
            bVar.xWh = bgl.LQm;
            bVar.xWi = bgl.LQn;
            bVar.appId = bgl.jfi;
            bVar.iFo = bgl.xMq;
            bVar.createTime = (long) bgl.Gaz;
            bVar.xWl = new c(bgl.LPS, (byte) 0);
            AppMethodBeat.o(42371);
            return bVar;
        }
    }

    public static class c {
        public int actionType;
        String appId;
        int dYu;
        String h5Url;
        int position;
        int type;
        int xWh;
        int xWi;
        String xWm;

        public c() {
        }

        public c(String str) {
            this.actionType = 2;
            this.h5Url = str;
        }

        public c(String str, byte b2) {
            this.actionType = 2;
            this.type = 3;
            this.h5Url = str;
        }

        public c(int i2, int i3, String str, String str2) {
            AppMethodBeat.i(42372);
            this.actionType = i2;
            this.type = i3;
            this.appId = str;
            if (i2 == 2) {
                this.h5Url = str2;
            }
            AppMethodBeat.o(42372);
        }
    }

    /* access modifiers changed from: package-private */
    public class d {
        int end;
        int start;

        private d() {
            this.start = -1;
            this.end = -1;
        }

        /* synthetic */ d(r rVar, byte b2) {
            this();
        }
    }

    private String aAD(String str) {
        AppMethodBeat.i(42378);
        if (this.xVS == null) {
            this.xVS = new ArrayList<>();
        } else {
            this.xVS.clear();
        }
        StringBuilder sb = new StringBuilder(str);
        d dVar = new d(this, (byte) 0);
        for (int indexOf = sb.indexOf("<em>"); indexOf >= 0; indexOf = sb.indexOf("<em>")) {
            dVar.start = indexOf;
            sb.delete(indexOf, indexOf + 4);
            int indexOf2 = sb.indexOf("</em>");
            if (indexOf2 < 0) {
                break;
            }
            dVar.end = indexOf2;
            sb.delete(indexOf2, indexOf2 + 5);
            this.xVS.add(dVar);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(42378);
        return sb2;
    }

    private void d(TextView textView, String str) {
        AppMethodBeat.i(42379);
        if (!Util.isNullOrNil(str)) {
            SpannableString spannableString = new SpannableString(aAD(str));
            Iterator<d> it = this.xVS.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.start < next.end) {
                    spannableString.setSpan(new ForegroundColorSpan(this.xVP), next.start, next.end, 33);
                }
            }
            textView.setText(spannableString);
            textView.setVisibility(0);
            AppMethodBeat.o(42379);
            return;
        }
        textView.setVisibility(8);
        AppMethodBeat.o(42379);
    }
}
