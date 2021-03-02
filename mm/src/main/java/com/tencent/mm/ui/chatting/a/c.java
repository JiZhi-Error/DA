package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c extends RecyclerView.a {
    public static e Pme;
    public static f Pmf = null;
    public String Pmg;
    private Context mContext;

    public interface e {
        void a(View view, int i2, b bVar);

        void b(View view, int i2, b bVar);
    }

    public interface f {
        RecyclerView.v N(ViewGroup viewGroup);

        void a(a aVar, int i2);

        b amy(int i2);

        int getCount();
    }

    public c(Context context, f fVar) {
        Pmf = fVar;
        this.mContext = context;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(35045);
        int type = Pmf.amy(i2).getType();
        AppMethodBeat.o(35045);
        return type;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(35046);
        if (i2 == Integer.MAX_VALUE) {
            d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aoc, viewGroup, false));
            AppMethodBeat.o(35046);
            return dVar;
        } else if (i2 == 2147483646) {
            AnonymousClass1 r0 = new RecyclerView.v(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ani, viewGroup, false)) {
                /* class com.tencent.mm.ui.chatting.a.c.AnonymousClass1 */
            };
            AppMethodBeat.o(35046);
            return r0;
        } else {
            RecyclerView.v N = Pmf.N(viewGroup);
            AppMethodBeat.o(35046);
            return N;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        String str;
        AppMethodBeat.i(35047);
        int itemViewType = getItemViewType(i2);
        b amy = Pmf.amy(i2);
        if (itemViewType == Integer.MAX_VALUE) {
            b amy2 = Pmf.amy(i2 + 1);
            if (i2 == getItemCount() - 1 || Cd(amy2.timestamp) != Cd(amy.timestamp)) {
                ((d) vVar).jUO.setVisibility(8);
                AppMethodBeat.o(35047);
                return;
            }
            ((d) vVar).jUO.setVisibility(0);
            ((d) vVar).jUO.setText(Cc(amy.timestamp));
            AppMethodBeat.o(35047);
            return;
        }
        if (itemViewType != 2147483646) {
            a aVar = (a) vVar;
            aVar.convertView.setTag(Integer.valueOf(i2));
            a.b.c(aVar.gvv, amy.username);
            TextView textView = aVar.kgE;
            Context context = this.mContext;
            if (Util.isNullOrNil(this.Pmg)) {
                if (Util.isNullOrNil(amy.cgo)) {
                    str = Util.isNullOrNil(amy.ogt) ? amy.nickname : amy.ogt;
                } else {
                    str = amy.cgo;
                }
            } else if (Util.isNullOrNil(amy.cgo)) {
                if (Util.isNullOrNil(amy.ogt)) {
                    str = amy.nickname;
                } else if (Util.isNullOrNil(amy.nickname) || !amy.nickname.contains(this.Pmg)) {
                    str = amy.ogt;
                } else {
                    str = amy.ogt + "(" + amy.nickname + ")";
                }
            } else if (!Util.isNullOrNil(amy.ogt) && amy.ogt.contains(this.Pmg)) {
                str = amy.cgo + "(" + amy.ogt + ")";
            } else if (Util.isNullOrNil(amy.nickname) || !amy.nickname.contains(this.Pmg)) {
                str = amy.cgo;
            } else {
                str = amy.cgo + "(" + amy.nickname + ")";
            }
            textView.setText(l.b(context, str, aVar.kgE.getTextSize()));
            aVar.timeTV.setText(m.h(this.mContext, amy.timestamp));
            aVar.jVO.setText(amy.title);
            Pmf.a((a) vVar, i2);
            if (!Util.isNullOrNil(this.Pmg)) {
                a.g(aVar.kgE, this.Pmg);
                a.g(aVar.jVO, this.Pmg);
            }
        }
        AppMethodBeat.o(35047);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        boolean z;
        AppMethodBeat.i(35048);
        int count = Pmf == null ? 0 : Pmf.getCount();
        Object[] objArr = new Object[2];
        if (Pmf == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(count);
        Log.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", objArr);
        AppMethodBeat.o(35048);
        return count;
    }

    public final String Cc(long j2) {
        AppMethodBeat.i(35049);
        String a2 = com.tencent.mm.ui.gridviewheaders.a.gWr().a(new Date(j2), this.mContext);
        AppMethodBeat.o(35049);
        return a2;
    }

    private static long Cd(long j2) {
        AppMethodBeat.i(35050);
        long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(j2));
        AppMethodBeat.o(35050);
        return b2;
    }

    public static class a extends RecyclerView.v {
        public View convertView;
        public ImageView gvv;
        public TextView jVO;
        public TextView kgE;
        public TextView timeTV;

        public a(View view) {
            super(view);
            AppMethodBeat.i(35042);
            this.convertView = view;
            this.gvv = (ImageView) view.findViewById(R.id.cb3);
            this.kgE = (TextView) view.findViewById(R.id.ccm);
            this.timeTV = (TextView) view.findViewById(R.id.cdl);
            this.jVO = (TextView) view.findViewById(R.id.cdm);
            this.jVO.setSingleLine(false);
            this.jVO.setMaxLines(2);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.a.c.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35040);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (c.Pme != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        c.Pme.a(view, intValue, c.Pmf.amy(intValue));
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35040);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.ui.chatting.a.c.a.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(35041);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (c.Pme != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        c.Pme.b(view, intValue, c.Pmf.amy(intValue));
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(35041);
                    return true;
                }
            });
            AppMethodBeat.o(35042);
        }

        public static void g(TextView textView, String str) {
            AppMethodBeat.i(35043);
            if (!Util.isNullOrNil(str)) {
                textView.getContext();
                textView.setText(com.tencent.mm.plugin.fts.a.f.b(textView.getText(), str));
            }
            AppMethodBeat.o(35043);
        }
    }

    public class d extends RecyclerView.v {
        TextView jUO;

        public d(View view) {
            super(view);
            AppMethodBeat.i(35044);
            this.jUO = (TextView) view.findViewById(R.id.bkk);
            this.jUO.setTextColor(c.this.mContext.getResources().getColor(R.color.p4));
            view.findViewById(R.id.be9).setBackgroundColor(c.this.mContext.getResources().getColor(R.color.oy));
            AppMethodBeat.o(35044);
        }
    }

    public static class g extends b {
        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final int getType() {
            return 2147483646;
        }
    }

    public static abstract class b {
        Pattern Pmj = Pattern.compile("[._a-zA-Z0-9]+");
        public String cgo;
        public long msgId;
        public String nickname;
        public String ogt;
        public long timestamp;
        public String title;
        public int type;
        public String username;

        public b() {
        }

        public b(long j2, int i2, String str, long j3, String str2, String str3, String str4, String str5) {
            this.timestamp = j2;
            this.type = i2;
            this.title = str;
            this.msgId = j3;
            this.username = str2;
            this.nickname = str3;
            this.cgo = str4;
            this.ogt = str5;
        }

        public int getType() {
            return this.type;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean bmC(java.lang.String r3) {
            /*
            // Method dump skipped, instructions count: 172
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.a.c.b.bmC(java.lang.String):boolean");
        }

        /* access modifiers changed from: protected */
        public final boolean ng(String str, String str2) {
            if (Util.isNullOrNil(str2)) {
                return false;
            }
            Matcher matcher = this.Pmj.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                String group = matcher.group();
                z = group.startsWith(str);
                Log.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", str, group);
                if (z) {
                    return z;
                }
            }
            return z;
        }

        protected static boolean bmD(String str) {
            char[] charArray = str.toCharArray();
            for (int i2 = 0; i2 < charArray.length; i2++) {
                if (charArray[i2] >= 19968 && charArray[i2] <= 40891) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return super.equals(obj);
            }
            return this.msgId == ((b) obj).msgId;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.c$c  reason: collision with other inner class name */
    public static class C2089c extends b {
        public C2089c(long j2) {
            this.timestamp = j2;
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final boolean bmC(String str) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final int getType() {
            return Integer.MAX_VALUE;
        }
    }
}
