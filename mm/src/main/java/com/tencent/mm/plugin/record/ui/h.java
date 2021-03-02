package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.av.q;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.record.ui.b.c;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.plugin.record.ui.b.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public abstract class h extends BaseAdapter {
    i BHC;
    public String BHK = "";
    public String BHL = "";
    SparseArray<b> BHM = new SparseArray<>();
    boolean BHN = false;
    boolean BHO = false;
    private boolean BHP = false;
    protected a BHQ;
    protected a BHR;
    public int BHS = 0;
    protected List<aml> BHs = new LinkedList();
    protected Context context;
    ListView mListView;
    private int padding = com.tencent.mm.cb.a.fromDPToPix(this.context, 35);
    private Runnable tdl = new Runnable() {
        /* class com.tencent.mm.plugin.record.ui.h.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(27870);
            Log.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
            h.this.notifyDataSetChanged();
            AppMethodBeat.o(27870);
        }
    };
    protected MMHandler wMu = null;

    public interface a {

        /* renamed from: com.tencent.mm.plugin.record.ui.h$a$a  reason: collision with other inner class name */
        public static class C1632a {
            public long BHU;
            public aml dKT;
            public ImageView dKU;
            public int dKV;
            public int height;
            public int width;
        }

        public static class b {
            public long BHU;
            public aml dKT;
            public boolean dKW;
            public boolean dKX;
            public int maxWidth;
        }

        public static class c {
            public long BHU;
            public aml dKT;
        }

        Bitmap a(b bVar);

        Bitmap a(c cVar);

        void a(C1632a aVar);

        void eIr();
    }

    public interface b {
        void a(View view, int i2, com.tencent.mm.plugin.record.ui.a.b bVar, Object obj);

        View createView(Context context);

        void destroy();

        void pause();
    }

    public abstract void a(a aVar);

    public abstract void d(com.tencent.mm.plugin.record.ui.a.b bVar);

    public h(Context context2, a aVar) {
        this.context = context2;
        this.wMu = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.plugin.record.ui.h.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(27869);
                if (message.what == 1) {
                    Log.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
                    h.this.notifyDataSetChanged();
                }
                AppMethodBeat.o(27869);
            }
        };
        this.BHR = aVar;
    }

    public final void eIy() {
        this.BHM.put(0, new d(this.context));
        this.BHM.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.BHR, this.mListView));
        this.BHM.put(2, new e());
        com.tencent.mm.plugin.record.ui.b.b bVar = new com.tencent.mm.plugin.record.ui.b.b(this.BHR, this.wMu);
        bVar.BHK = this.BHK;
        bVar.BHL = this.BHL;
        this.BHM.put(3, bVar);
        this.BHM.put(4, new c(this.BHR));
    }

    public final void destroy() {
        for (int i2 = 0; i2 < this.BHM.size(); i2++) {
            b valueAt = this.BHM.valueAt(i2);
            if (valueAt != null) {
                valueAt.destroy();
            }
        }
        if (this.BHR != null) {
            this.BHR.eIr();
            this.BHR = null;
        }
    }

    public int getItemViewType(int i2) {
        return o(getItem(i2));
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        if (this.BHs == null) {
            return 0;
        }
        return this.BHs.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: Vw */
    public aml getItem(int i2) {
        if (this.BHs != null && i2 >= 0 && i2 < this.BHs.size()) {
            return this.BHs.get(i2);
        }
        return null;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i2, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.record.ui.a.b cVar;
        String str;
        String str2;
        aml Vw = getItem(i2);
        b bVar = this.BHM.get(o(Vw));
        if (view == null) {
            view = bVar.createView(this.context);
        }
        switch (Vw.dataType) {
            case 2:
                cVar = new com.tencent.mm.plugin.record.ui.a.a();
                break;
            case 15:
                cVar = new com.tencent.mm.plugin.record.ui.a.c();
                break;
            default:
                cVar = new com.tencent.mm.plugin.record.ui.a.b();
                break;
        }
        cVar.dKT = Vw;
        cVar.BHK = this.BHK;
        cVar.BIN = this.BHL;
        d(cVar);
        bVar.a(view, i2, cVar, this.BHC);
        ImageView imageView = (ImageView) view.findViewById(R.id.gx3);
        TextView textView = (TextView) view.findViewById(R.id.gx7);
        String str3 = Vw.Lwj;
        if (Vw.Lwh != null) {
            amn amn = Vw.Lwh.LwO;
            if (amn.LxB) {
                String Is = aa.Is(amn.LxA);
                if (!Util.isNullOrNil(Is)) {
                    str3 = str3 + "(" + Is + ")";
                }
            } else if (amn.Lxx) {
                String Is2 = aa.Is(amn.dRL);
                if (!Util.isNullOrNil(Is2)) {
                    str3 = str3 + "(" + Is2 + ")";
                }
            }
        }
        SpannableString b2 = l.b(textView.getContext(), str3, textView.getTextSize());
        if (Util.isNullOrNil(Vw.LwI)) {
            textView.setText(b2);
        } else {
            String str4 = Vw.LwI;
            if (str4 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b2);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str4);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(R.color.a3_)), length, spannableStringBuilder.length(), 33);
                b2 = spannableStringBuilder;
            }
            textView.setText(b2);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.gx6);
        Log.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", Vw.Lwl);
        if (Vw.Lwl != null) {
            if (this.BHN) {
                String str5 = Vw.Lwl;
                String[] split = Vw.Lwl.split(" ");
                if (split.length < 2) {
                    textView2.setText(Vw.Lwl);
                } else {
                    String str6 = split[0];
                    try {
                        str2 = (String) DateFormat.format(this.context.getString(R.string.dev), new SimpleDateFormat("yyyy-MM-dd").parse(str6).getTime());
                    } catch (ParseException e2) {
                        str2 = str6;
                    }
                    textView2.setText(str2 + " " + str5.substring(split[0].length() + 1));
                }
            } else if (this.BHO) {
                String str7 = Vw.Lwl;
                String[] split2 = Vw.Lwl.split(" ");
                if (split2.length < 2) {
                    textView2.setText(Vw.Lwl);
                } else {
                    String substring = split2[0].substring(split2[0].indexOf("-") + 1);
                    try {
                        str = (String) DateFormat.format(this.context.getString(R.string.dec), new SimpleDateFormat("MM-dd").parse(substring).getTime());
                    } catch (ParseException e3) {
                        str = substring;
                    }
                    textView2.setText(str + " " + str7.substring(split2[0].length() + 1));
                }
            } else {
                String[] split3 = Vw.Lwl.split(" ");
                if (split3.length < 2) {
                    textView2.setText(Vw.Lwl);
                } else {
                    textView2.setText(Vw.Lwl.substring(split3[0].length() + 1));
                }
            }
        }
        if (i2 == 0) {
            if (Vw.Lwh != null) {
                amn amn2 = Vw.Lwh.LwO;
                imageView.setVisibility(0);
                if (amn2.LxB) {
                    aLa(amn2.LxA);
                    if (com.tencent.mm.al.a.e.NF(amn2.LxA)) {
                        q.bcV().loadImage(com.tencent.mm.al.a.e.NI(amn2.LxA), imageView);
                    } else if (!as.bjp(amn2.LxA) || !Vw.LwL || Util.isNullOrNil(Vw.LwK)) {
                        a.b.c(imageView, amn2.LxA);
                    } else {
                        q.bcV().loadImage(Vw.LwK, imageView);
                    }
                } else if (!amn2.Lxx || (z.aTY().equals(amn2.dRL) && amn2.dRL.equals(amn2.toUser))) {
                    imageView.setVisibility(8);
                    view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                    this.BHP = true;
                } else if (!as.bjp(amn2.dRL) || !Vw.LwL || Util.isNullOrNil(Vw.LwK)) {
                    aLa(amn2.dRL);
                    a.b.c(imageView, amn2.dRL);
                } else {
                    q.bcV().loadImage(Vw.LwK, imageView);
                }
            } else {
                imageView.setVisibility(8);
                view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                this.BHP = true;
            }
        } else if (i2 <= 0 || this.BHP) {
            imageView.setVisibility(8);
            view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
        } else {
            String str8 = "";
            amn amn3 = Vw.Lwh.LwO;
            if (getItem(i2 - 1).Lwh.LwO.LxB) {
                str8 = getItem(i2 - 1).Lwh.LwO.LxA;
            } else if (getItem(i2 - 1).Lwh.LwO.Lxx) {
                str8 = getItem(i2 - 1).Lwh.LwO.dRL;
            }
            imageView.setVisibility(0);
            if (Vw.Lwh.LwO.LxB) {
                String str9 = Vw.Lwh.LwO.LxA;
                if (!str8.equals(str9)) {
                    aLa(str9);
                    if (com.tencent.mm.al.a.e.NF(amn3.LxA)) {
                        q.bcV().loadImage(com.tencent.mm.al.a.e.NI(amn3.LxA), imageView);
                    } else if (!as.bjp(str9) || !Vw.LwL || Util.isNullOrNil(Vw.LwK)) {
                        a.b.c(imageView, str9);
                    } else {
                        q.bcV().loadImage(Vw.LwK, imageView);
                    }
                } else {
                    imageView.setVisibility(4);
                }
            } else if (Vw.Lwh.LwO.Lxx) {
                String str10 = Vw.Lwh.LwO.dRL;
                if (str8.equals(str10)) {
                    imageView.setVisibility(4);
                } else if (!as.bjp(str10) || !Vw.LwL || Util.isNullOrNil(Vw.LwK)) {
                    aLa(str10);
                    a.b.c(imageView, str10);
                } else {
                    q.bcV().loadImage(Vw.LwK, imageView);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i2 == getCount() - 1) {
            view.findViewById(R.id.gx5).setVisibility(8);
        } else {
            view.findViewById(R.id.gx5).setVisibility(0);
        }
        return view;
    }

    private static void aLa(String str) {
        if (!ab.IS(str)) {
            i iVar = new i();
            iVar.username = str;
            p.aYB().b(iVar);
        }
    }

    /* access modifiers changed from: protected */
    public final void eIz() {
        this.wMu.post(this.tdl);
    }

    private static int o(aml aml) {
        switch (aml.dataType) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 3;
        }
    }
}
