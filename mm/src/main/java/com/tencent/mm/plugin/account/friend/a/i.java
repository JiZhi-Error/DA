package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.b.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    public Context context;
    int dDG = 1;
    public List<String[]> kbT;
    public LinkedList<cik> ket = new LinkedList<>();
    private LinkedList<cik> keu = new LinkedList<>();
    private List<String[]> kev = new LinkedList();
    private a kew;
    public com.tencent.mm.ui.applet.b kex = new com.tencent.mm.ui.applet.b(new b.a() {
        /* class com.tencent.mm.plugin.account.friend.a.i.AnonymousClass1 */

        @Override // com.tencent.mm.ui.applet.b.a
        public final Bitmap Ta(String str) {
            AppMethodBeat.i(130999);
            Bitmap a2 = c.a(str, false, -1, null);
            AppMethodBeat.o(130999);
            return a2;
        }
    });
    private b.AbstractC2078b kez = null;
    public int[] pt;

    public interface a {
        void notifyDataSetChanged();
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(131016);
        cik vf = vf(i2);
        AppMethodBeat.o(131016);
        return vf;
    }

    public i(Context context2, a aVar, int i2) {
        AppMethodBeat.i(131005);
        this.context = context2;
        this.dDG = i2;
        this.kew = aVar;
        this.pt = new int[this.ket.size()];
        AppMethodBeat.o(131005);
    }

    static class b {
        TextView kcS;
        ImageView keC;
        TextView keD;
        Button keE;
        Button keF;
        TextView keG;
        TextView keH;

        b() {
        }
    }

    public final int getSelectCount() {
        int[] iArr = this.pt;
        int i2 = 0;
        for (int i3 : iArr) {
            if (this.dDG == 1) {
                if (i3 == 1) {
                    i2++;
                }
            } else if (this.dDG == 2 && i3 == 2) {
                i2++;
            }
        }
        return i2;
    }

    public final boolean bnV() {
        if (this.pt == null || this.pt.length == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.pt.length; i2++) {
            int i3 = this.pt[i2];
            if (this.dDG == 1) {
                if (i3 == 0) {
                    return false;
                }
            } else if (this.dDG == 2 && i3 == 0) {
                return false;
            }
        }
        return true;
    }

    public final void select(int i2) {
        AppMethodBeat.i(131006);
        if (this.dDG == 1) {
            this.pt[i2] = 1;
        } else if (this.dDG == 2) {
            this.pt[i2] = 2;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(131006);
    }

    public final void gk(boolean z) {
        AppMethodBeat.i(131007);
        if (this.dDG == 1) {
            for (int i2 = 0; i2 < this.pt.length; i2++) {
                this.pt[i2] = z ? 1 : 0;
            }
        } else if (this.dDG == 2) {
            for (int i3 = 0; i3 < this.pt.length; i3++) {
                this.pt[i3] = z ? 2 : 0;
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(131007);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(131008);
        super.notifyDataSetChanged();
        if (this.kew != null) {
            this.kew.notifyDataSetChanged();
        }
        AppMethodBeat.o(131008);
    }

    public final void s(LinkedList<cik> linkedList) {
        AppMethodBeat.i(131009);
        if (linkedList != null) {
            this.keu.clear();
            this.ket.clear();
            this.kev.clear();
            for (String[] strArr : this.kbT) {
                Iterator<cik> it = linkedList.iterator();
                while (it.hasNext()) {
                    cik next = it.next();
                    if (this.dDG == 1) {
                        if ((next.oTW == 1 || next.oTW == 0) && !Util.isNullOrNil(strArr[2]) && next.Cyk.equals(g.getMessageDigest(strArr[2].getBytes()))) {
                            a(next, strArr);
                        }
                    } else if (this.dDG == 2 && next.oTW == 2 && !Util.isNullOrNil(strArr[2]) && next.Cyk.equals(g.getMessageDigest(strArr[2].getBytes()))) {
                        a(next, strArr);
                    }
                }
            }
        }
        this.pt = new int[this.keu.size()];
        this.ket.addAll(this.keu);
        this.keu.clear();
        AppMethodBeat.o(131009);
    }

    private void a(cik cik, String[] strArr) {
        AppMethodBeat.i(131010);
        Iterator<cik> it = this.keu.iterator();
        while (it.hasNext()) {
            cik next = it.next();
            if (next.Cyk != null && cik.Cyk != null && next.Cyk.equals(cik.Cyk)) {
                Log.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
                AppMethodBeat.o(131010);
                return;
            }
        }
        this.keu.add(cik);
        this.kev.add(new String[]{strArr[2], strArr[1]});
        AppMethodBeat.o(131010);
    }

    public final int getCount() {
        AppMethodBeat.i(131011);
        int size = this.ket.size();
        AppMethodBeat.o(131011);
        return size;
    }

    public final cik vf(int i2) {
        AppMethodBeat.i(131012);
        cik cik = this.ket.get(i2);
        AppMethodBeat.o(131012);
        return cik;
    }

    public final long getItemId(int i2) {
        AppMethodBeat.i(131013);
        long hashCode = (long) this.ket.get(i2).hashCode();
        AppMethodBeat.o(131013);
        return hashCode;
    }

    public final View getView(final int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(131014);
        if (this.dDG == 1) {
            if (this.kez == null) {
                this.kez = new b.AbstractC2078b() {
                    /* class com.tencent.mm.plugin.account.friend.a.i.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                    public final String vg(int i2) {
                        AppMethodBeat.i(131000);
                        if (i2 < 0 || i2 >= i.this.getCount()) {
                            Log.e("MicroMsg.FriendAdapter", "pos is invalid");
                            AppMethodBeat.o(131000);
                            return null;
                        }
                        cik vf = i.this.vf(i2);
                        if (vf == null) {
                            AppMethodBeat.o(131000);
                            return null;
                        }
                        String str = vf.UserName;
                        AppMethodBeat.o(131000);
                        return str;
                    }

                    @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                    public final int bnW() {
                        AppMethodBeat.i(131001);
                        int count = i.this.getCount();
                        AppMethodBeat.o(131001);
                        return count;
                    }
                };
            }
            if (this.kex != null) {
                this.kex.a(i2, this.kez);
            }
        }
        cik cik = this.ket.get(i2);
        if (view == null) {
            bVar = new b();
            if (this.dDG == 1) {
                view = View.inflate(this.context, R.layout.a90, null);
                bVar.kcS = (TextView) view.findViewById(R.id.fgv);
                bVar.keD = (TextView) view.findViewById(R.id.fgo);
                bVar.keE = (Button) view.findViewById(R.id.fgp);
                bVar.keF = (Button) view.findViewById(R.id.fgr);
                bVar.keC = (ImageView) view.findViewById(R.id.dah);
                bVar.keG = (TextView) view.findViewById(R.id.fgw);
                bVar.keH = (TextView) view.findViewById(R.id.fgz);
                view.setTag(bVar);
            } else if (this.dDG == 2) {
                view = View.inflate(this.context, R.layout.a91, null);
                bVar.kcS = (TextView) view.findViewById(R.id.fgv);
                bVar.keD = (TextView) view.findViewById(R.id.fgo);
                bVar.keE = (Button) view.findViewById(R.id.fgp);
                bVar.keF = (Button) view.findViewById(R.id.fgr);
                bVar.keG = (TextView) view.findViewById(R.id.fgw);
                bVar.keH = (TextView) view.findViewById(R.id.fgz);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        bVar.keH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.a.i.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(131002);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i iVar = i.this;
                int i2 = i2;
                if (iVar.dDG == 1) {
                    iVar.pt[i2] = 0;
                } else if (iVar.dDG == 2) {
                    iVar.pt[i2] = 0;
                }
                iVar.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131002);
            }
        });
        if (this.dDG == 1) {
            if (!Util.isNullOrNil(this.kev.get(i2)[1])) {
                bVar.kcS.setText(this.kev.get(i2)[1]);
            } else if (Util.isNullOrNil(cik.oUJ)) {
                bVar.kcS.setText(cik.UserName);
            } else {
                bVar.kcS.setText(cik.oUJ);
            }
            bVar.keE.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.friend.a.i.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(131003);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    i.this.select(i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(131003);
                }
            });
            a.b.c(bVar.keC, cik.UserName);
        } else if (this.dDG == 2) {
            bVar.kcS.setText(this.kev.get(i2)[1]);
            bVar.keF.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.friend.a.i.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(131004);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    i.this.select(i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(131004);
                }
            });
        }
        switch (this.pt[i2]) {
            case 0:
                if (this.dDG != 1) {
                    if (this.dDG == 2) {
                        bVar.keD.setVisibility(8);
                        bVar.keE.setVisibility(8);
                        bVar.keF.setVisibility(0);
                        bVar.keG.setVisibility(8);
                        bVar.keH.setVisibility(8);
                        break;
                    }
                } else {
                    bVar.keD.setVisibility(8);
                    bVar.keE.setVisibility(0);
                    bVar.keF.setVisibility(8);
                    bVar.keG.setVisibility(8);
                    bVar.keH.setVisibility(8);
                    break;
                }
                break;
            case 1:
                bVar.keE.setVisibility(8);
                bVar.keD.setVisibility(0);
                bVar.keG.setVisibility(0);
                bVar.keH.setVisibility(0);
                break;
            case 2:
                bVar.keE.setVisibility(8);
                bVar.keF.setVisibility(8);
                bVar.keD.setVisibility(0);
                bVar.keG.setVisibility(0);
                bVar.keH.setVisibility(0);
                break;
            case 3:
                bVar.keE.setVisibility(8);
                bVar.keD.setVisibility(0);
                bVar.keG.setVisibility(0);
                bVar.keH.setVisibility(0);
                break;
        }
        AppMethodBeat.o(131014);
        return view;
    }

    public final void SZ(String str) {
        AppMethodBeat.i(131015);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.kev.size(); i2++) {
            if (this.pt[i2] == 2) {
                arrayList.add(this.kev.get(i2)[0]);
            }
        }
        com.tencent.mm.kernel.g.azz().a(new al(str, arrayList), 0);
        AppMethodBeat.o(131015);
    }
}
