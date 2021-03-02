package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.x;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r extends BaseAdapter {
    public static int Kfx = 5;
    public static int MAX_COUNT = 44;
    private List<as> GjL = new ArrayList();
    public boolean KfA = false;
    public boolean KfB = false;
    private List<Object> KfC = new ArrayList();
    int KfD = 0;
    int KfE = 0;
    e KfF;
    public boolean KfG = false;
    public boolean KfH = false;
    public boolean KfI = false;
    private boolean KfJ = true;
    boolean KfK = false;
    int KfL = 12;
    String KfM;
    private final int KfN;
    public boolean KfO = false;
    private boolean KfP = true;
    boolean KfQ = true;
    public boolean KfR = false;
    a Kfy;
    private ArrayList<as> Kfz = new ArrayList<>();
    private boolean dRx;
    private List<String> dSU = new ArrayList();
    ah gtd;
    boolean gyp;
    private com.tencent.mm.av.a.a.c gzE = null;
    private Context mContext;
    boolean tca = false;
    private String username;

    public interface a {
        void cCu();
    }

    public r(Context context) {
        AppMethodBeat.i(152192);
        this.mContext = context;
        this.gyp = false;
        this.KfN = context.getResources().getDimensionPixelSize(R.dimen.f3062g);
        AppMethodBeat.o(152192);
    }

    private void gpB() {
        AppMethodBeat.i(152193);
        if (this.tca && x.a.Kge != null) {
            this.gzE = x.a.Kge.beG(this.username);
        }
        AppMethodBeat.o(152193);
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(152194);
        this.username = str;
        this.dRx = ab.Eq(str);
        if (!this.dRx && x.a.Kge != null) {
            this.tca = x.a.Kge.beE(str);
        }
        if (!this.tca) {
            this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
        }
        gpB();
        AppMethodBeat.o(152194);
    }

    public final boolean gpC() {
        AppMethodBeat.i(152195);
        if (this.tca) {
            boolean z = this.KfB;
            AppMethodBeat.o(152195);
            return z;
        }
        boolean Eq = ab.Eq(this.username);
        AppMethodBeat.o(152195);
        return Eq;
    }

    public final void gX(List<String> list) {
        this.KfJ = true;
        this.dSU = list;
    }

    public final void bh(ArrayList<as> arrayList) {
        this.KfJ = false;
        this.Kfz = arrayList;
    }

    public final void amZ() {
        AppMethodBeat.i(152196);
        if (this.dSU == null && this.Kfz == null) {
            AppMethodBeat.o(152196);
            return;
        }
        if (!this.KfJ) {
            gpD();
        } else if (this.dSU != null) {
            Log.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", Integer.valueOf(this.dSU.size()));
            this.GjL.clear();
            this.KfC.clear();
            LinkedList linkedList = new LinkedList();
            if (this.dSU.size() > 0) {
                int i2 = 1;
                for (String str : this.dSU) {
                    if (this.tca) {
                        this.KfC.add(x.a.Kge.beF(str));
                    } else {
                        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                        if (this.gtd != null && str.equals(this.gtd.field_roomowner)) {
                            linkedList.add(new b(Kn, 0));
                        } else if (this.gtd == null || !this.gtd.bjf(Kn.field_username)) {
                            linkedList.add(new b(Kn, 100));
                        } else {
                            linkedList.add(new b(Kn, i2));
                            i2++;
                        }
                    }
                }
                if (this.KfP) {
                    Collections.sort(linkedList, new Comparator<b>() {
                        /* class com.tencent.mm.pluginsdk.ui.applet.r.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(b bVar, b bVar2) {
                            return bVar.order - bVar2.order;
                        }
                    });
                }
                if (!this.tca) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.GjL.add((as) ((b) it.next()).KfT);
                    }
                }
            }
            if (this.tca) {
                this.KfE = this.KfC.size();
            } else if (!this.dRx) {
                this.KfE = this.GjL.size();
            } else if (this.gtd == null || this.gtd.amD()) {
                this.KfE = this.GjL.size() >= MAX_COUNT + -1 ? MAX_COUNT - 1 : this.GjL.size();
            } else {
                this.KfE = this.GjL.size() >= MAX_COUNT ? MAX_COUNT : this.GjL.size();
            }
        }
        if (this.KfE == 0) {
            this.KfD = Kfx;
        } else if (this.KfH && this.KfG && this.KfI) {
            this.KfD = (((this.KfE + 2) / Kfx) + 1) * Kfx;
        } else if ((this.KfH && this.KfG && !this.KfI) || ((this.KfH && !this.KfG && this.KfI) || (!this.KfH && this.KfG && this.KfI))) {
            this.KfD = (((this.KfE + 1) / Kfx) + 1) * Kfx;
        } else if ((this.KfH && !this.KfG && !this.KfI) || ((!this.KfH && this.KfG && !this.KfI) || (!this.KfH && !this.KfG && this.KfI))) {
            this.KfD = ((this.KfE / Kfx) + 1) * Kfx;
        } else if (!this.KfH && !this.KfG && !this.KfI) {
            this.KfD = (((this.KfE - 1) / Kfx) + 1) * Kfx;
        }
        Log.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.KfE + " realySize : " + this.KfD);
        cCu();
        AppMethodBeat.o(152196);
    }

    private void gpD() {
        AppMethodBeat.i(152197);
        if (this.Kfz == null) {
            AppMethodBeat.o(152197);
            return;
        }
        Log.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", Integer.valueOf(this.Kfz.size()));
        this.GjL.clear();
        if (this.Kfz.size() > 0) {
            Iterator<as> it = this.Kfz.iterator();
            while (it.hasNext()) {
                this.GjL.add(it.next());
            }
        }
        this.KfE = this.GjL.size();
        AppMethodBeat.o(152197);
    }

    private void aim(int i2) {
        AppMethodBeat.i(152199);
        if (i2 < this.KfE) {
            this.gyp = true;
            cCu();
        }
        AppMethodBeat.o(152199);
    }

    private void cCu() {
        AppMethodBeat.i(152200);
        if (this.Kfy != null) {
            this.Kfy.cCu();
        }
        AppMethodBeat.o(152200);
    }

    private c gm(View view) {
        AppMethodBeat.i(152201);
        c cVar = new c();
        cVar.KfU = (ImageView) view.findViewById(R.id.h85);
        cVar.gAf = (AvatarPatTipImageView) view.findViewById(R.id.h8t);
        cVar.DeA = (ImageView) view.findViewById(R.id.h84);
        cVar.gvw = (TextView) view.findViewById(R.id.h8p);
        cVar.gzG = (TextView) view.findViewById(R.id.h8q);
        cVar.gzH = (TextView) view.findViewById(R.id.h8s);
        cVar.ooE = (ImageView) view.findViewById(R.id.h86);
        cVar.gAf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setTag(cVar);
        AppMethodBeat.o(152201);
        return cVar;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        Object obj;
        int i3;
        c cVar;
        SpannableString b2;
        String displayName;
        AppMethodBeat.i(152202);
        as asVar = null;
        if (i2 < this.KfE) {
            i3 = 0;
            if (this.tca) {
                obj = getItem(i2);
            } else {
                obj = null;
                asVar = (as) getItem(i2);
            }
        } else if (i2 == this.KfE && this.KfH) {
            obj = null;
            i3 = 3;
        } else if (i2 == this.KfE + 1 && this.KfG) {
            obj = null;
            i3 = 4;
        } else if (i2 == this.KfE + 1 && this.KfI && !this.KfG) {
            obj = null;
            i3 = 5;
        } else if (i2 != this.KfE + 2 || !this.KfI || !this.KfG) {
            obj = null;
            i3 = 2;
        } else {
            obj = null;
            i3 = 5;
        }
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.bnf, null);
            cVar = gm(view);
        } else {
            c cVar2 = (c) view.getTag();
            if (cVar2 == null) {
                cVar = gm(view);
            } else {
                cVar = cVar2;
            }
        }
        if (Kfx == 4 || this.KfR) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.il);
            cVar.gAf.getLayoutParams().height = dimensionPixelSize;
            cVar.gAf.getLayoutParams().width = dimensionPixelSize;
        } else {
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ij);
            cVar.gAf.getLayoutParams().height = dimensionPixelSize2;
            cVar.gAf.getLayoutParams().width = dimensionPixelSize2;
        }
        cVar.KfU.setVisibility(8);
        cVar.gzH.setVisibility(8);
        if (i3 == 0) {
            cVar.gAf.setVisibility(0);
            if (this.dRx) {
                if (!Util.isNullOrNil(asVar.field_conRemark)) {
                    displayName = asVar.field_conRemark;
                } else {
                    String str = asVar.field_username;
                    if (this.gtd == null) {
                        displayName = null;
                    } else {
                        displayName = this.gtd.getDisplayName(str);
                    }
                }
                if (Util.isNullOrNil(displayName)) {
                    displayName = asVar.field_conRemark;
                }
                if (Util.isNullOrNil(displayName)) {
                    displayName = asVar.arI();
                }
                b2 = com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, displayName, cVar.gvw.getTextSize());
            } else if (this.tca) {
                b2 = com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, x.a.Kge.dX(obj), cVar.gvw.getTextSize());
            } else if (as.bjp(asVar.field_username)) {
                b2 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), asVar.arJ(), (int) cVar.gvw.getTextSize());
            } else {
                b2 = com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, asVar.arJ(), cVar.gvw.getTextSize());
            }
            if (b2 instanceof SpannableString) {
                cVar.gvw.setVisibility(8);
                cVar.gzG.setVisibility(0);
                cVar.gzG.setText(b2);
            } else {
                cVar.gvw.setVisibility(0);
                cVar.gzG.setVisibility(8);
                cVar.gvw.setText(b2);
            }
            String O = com.tencent.mm.openim.room.a.a.O(asVar);
            if (TextUtils.isEmpty(O)) {
                cVar.gzH.setVisibility(8);
            } else {
                cVar.gzH.setVisibility(0);
                cVar.gzH.setText(O);
            }
            cVar.gAf.setContentDescription("");
            if (this.tca) {
                q.bcV().a(x.a.Kge.dY(obj), cVar.gAf, this.gzE);
                cVar.gAf.setBackgroundDrawable(null);
            } else {
                a.b.c(cVar.gAf, asVar.field_username);
                com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) cVar.gAf.getDrawable();
                if (this.KfF != null) {
                    this.KfF.a(aVar);
                }
                cVar.gAf.setTagUsername(asVar.field_username);
                cVar.gAf.setTagTalker(this.username);
                if (ab.Ix(this.username)) {
                    cVar.gAf.setTagScene(4);
                } else {
                    cVar.gAf.setTagScene(3);
                }
            }
            if (this.tca) {
                if (!this.gyp || (this.KfM != null && this.KfM.equals(x.a.Kge.dZ(obj)))) {
                    cVar.DeA.setVisibility(8);
                } else {
                    cVar.DeA.setVisibility(0);
                }
            } else if (!this.gyp || (this.KfM != null && this.KfM.equals(asVar.field_username))) {
                cVar.DeA.setVisibility(8);
            } else {
                cVar.DeA.setVisibility(0);
            }
        } else if (i3 == 3) {
            cVar.gvw.setVisibility(i2 == 0 ? 8 : 4);
            cVar.gzG.setVisibility(i2 == 0 ? 8 : 4);
            cVar.DeA.setVisibility(8);
            if (this.gyp) {
                cVar.gAf.setVisibility(4);
            } else {
                cVar.gAf.setVisibility(0);
                if (this.tca) {
                    q.bcV().a("", cVar.gAf, this.gzE);
                    cVar.gAf.setBackgroundDrawable(null);
                }
                cVar.gAf.setImageResource(R.drawable.gg);
                cVar.gAf.setContentDescription(this.mContext.getString(R.string.dk));
            }
        } else if (i3 == 4) {
            cVar.gvw.setVisibility(1 == i2 ? 8 : 4);
            cVar.gzG.setVisibility(1 == i2 ? 8 : 4);
            cVar.DeA.setVisibility(8);
            if (this.gyp || this.KfE == 0) {
                cVar.gAf.setVisibility(4);
            } else {
                cVar.gAf.setVisibility(0);
                if (this.tca) {
                    q.bcV().a("", cVar.gAf, this.gzE);
                    cVar.gAf.setBackgroundDrawable(null);
                }
                cVar.gAf.setImageResource(R.drawable.gh);
                cVar.gAf.setContentDescription(this.mContext.getString(R.string.bl_));
            }
        } else if (i3 == 5) {
            cVar.gvw.setVisibility(i2 == 0 ? 8 : 4);
            cVar.gzG.setVisibility(i2 == 0 ? 8 : 4);
            cVar.DeA.setVisibility(8);
            if (this.gyp) {
                cVar.gAf.setVisibility(4);
            } else {
                cVar.gAf.setVisibility(0);
                if (this.tca) {
                    q.bcV().a("", cVar.gAf, this.gzE);
                    cVar.gAf.setBackgroundDrawable(null);
                }
                cVar.gAf.setImageResource(R.drawable.gi);
                cVar.gAf.setContentDescription(this.mContext.getString(R.string.f3k));
            }
        } else if (i3 == 2) {
            if (this.tca) {
                q.bcV().a("", cVar.gAf, this.gzE);
            }
            cVar.gvw.setVisibility(4);
            cVar.gzG.setVisibility(4);
            cVar.DeA.setVisibility(8);
            cVar.gAf.setVisibility(4);
            cVar.gAf.setImageResource(R.drawable.aij);
            cVar.gAf.setBackgroundResource(R.drawable.aij);
        }
        if (!this.tca || obj == null) {
            cVar.ooE.setVisibility(8);
        }
        cVar.qcr = i3;
        AppMethodBeat.o(152202);
        return view;
    }

    /* access modifiers changed from: package-private */
    public class c {
        public ImageView DeA;
        public ImageView KfU;
        public AvatarPatTipImageView gAf;
        public TextView gvw;
        public TextView gzG;
        public TextView gzH;
        public ImageView ooE;
        public int qcr;

        c() {
        }
    }

    public final boolean ain(int i2) {
        return i2 < this.KfE;
    }

    public final void gpE() {
        AppMethodBeat.i(152203);
        this.gyp = false;
        amZ();
        AppMethodBeat.o(152203);
    }

    public final void fm(List<String> list) {
        AppMethodBeat.i(152204);
        gX(list);
        amZ();
        AppMethodBeat.o(152204);
    }

    public final int getCount() {
        AppMethodBeat.i(152205);
        if (this.KfK) {
            int min = Math.min(this.KfL, this.KfD);
            AppMethodBeat.o(152205);
            return min;
        }
        int i2 = this.KfD;
        AppMethodBeat.o(152205);
        return i2;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(152206);
        if (i2 >= this.KfE) {
            AppMethodBeat.o(152206);
            return null;
        } else if (this.tca) {
            Object obj = this.KfC.get(i2);
            AppMethodBeat.o(152206);
            return obj;
        } else {
            as asVar = this.GjL.get(i2);
            AppMethodBeat.o(152206);
            return asVar;
        }
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    /* access modifiers changed from: package-private */
    public class b {
        public Object KfT;
        public int order;

        public b(Object obj, int i2) {
            this.KfT = obj;
            this.order = i2;
        }
    }

    public final boolean ail(int i2) {
        AppMethodBeat.i(152198);
        if (!this.gyp) {
            aim(i2);
            AppMethodBeat.o(152198);
            return true;
        }
        AppMethodBeat.o(152198);
        return false;
    }
}
