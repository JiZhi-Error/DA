package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class g extends q implements MStorageEx.IOnStorageChange {
    int CuB;
    int CuC;
    private List<String> CuD;
    private int CuE = 0;
    private int fromScene;
    private Cursor jWh;

    public g(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, int i2) {
        super(mMBaseSelectContactUI, list2, true, false);
        AppMethodBeat.i(68115);
        this.CuD = list;
        this.fromScene = i2;
        Log.i("MicroMsg.RecentConversationAdapter", "create!");
        and();
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().add(this);
        AppMethodBeat.o(68115);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        int i2;
        Cursor cursor;
        AppMethodBeat.i(68116);
        Log.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        this.CuE = 0;
        ArrayList arrayList = new ArrayList();
        this.CuB = -1;
        this.CuC = -1;
        if (this.CuD == null || this.CuD.size() <= 0) {
            i2 = 0;
        } else {
            com.tencent.mm.kernel.g.aAi();
            Cursor iM = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().iM(this.CuD);
            arrayList.add(iM);
            int count = iM.getCount();
            if (count > 0) {
                this.CuB = this.PWg.getContentLV().getHeaderViewsCount();
                this.CuE++;
                i2 = count;
            } else {
                this.CuB = -1;
                i2 = count;
            }
        }
        List<String> list = this.gzY;
        if (list != null) {
            list.addAll(this.CuD);
        } else {
            list = this.CuD;
        }
        if (this.fromScene == 1 || this.fromScene == 3) {
            cursor = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().b(ab.iCF, list, com.tencent.mm.o.a.gNj, this.PWC, "");
        } else {
            cursor = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().b(ab.iCK, list, com.tencent.mm.o.a.gNj, this.PWC, "");
        }
        if (cursor.getCount() > 0) {
            this.CuE++;
            if (i2 > 0) {
                this.CuC = this.CuB + i2 + 1;
            } else {
                this.CuC = this.PWg.getContentLV().getHeaderViewsCount();
            }
        } else {
            this.CuC = -1;
        }
        arrayList.add(cursor);
        this.jWh = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        AppMethodBeat.o(68116);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        f fVar;
        int i3;
        AppMethodBeat.i(68117);
        if (i2 == this.CuC || i2 == this.CuB) {
            h hVar = new h(i2);
            if (i2 != this.CuB) {
                fVar = hVar;
                if (i2 == this.CuC) {
                    hVar.header = this.PWg.getActivity().getResources().getString(R.string.is5);
                    fVar = hVar;
                }
            } else if (this.fromScene == 1) {
                hVar.header = this.PWg.getActivity().getResources().getString(R.string.aq);
                fVar = hVar;
            } else if (this.fromScene == 3) {
                hVar.header = this.PWg.getActivity().getResources().getString(R.string.ec7);
                fVar = hVar;
            } else {
                hVar.header = this.PWg.getActivity().getResources().getString(R.string.g45);
                fVar = hVar;
            }
        } else {
            if (this.CuE == 2) {
                if (i2 > this.CuC) {
                    i3 = i2 - 2;
                } else {
                    i3 = i2 - 1;
                }
            } else if (this.CuE == 1) {
                i3 = i2 - 1;
            } else {
                Log.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", Integer.valueOf(i2));
                i3 = i2;
            }
            if (this.jWh.moveToPosition(i3)) {
                f fVar2 = new f(i2);
                az azVar = new az();
                azVar.convertFrom(this.jWh);
                com.tencent.mm.kernel.g.aAi();
                fVar2.contact = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjF(azVar.field_username);
                if (fVar2.contact == null) {
                    com.tencent.mm.kernel.g.aAi();
                    fVar2.contact = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjK(azVar.field_username);
                }
                fVar = fVar2;
            } else {
                Log.e("MicroMsg.RecentConversationAdapter", "wrong case: %s, %s", Boolean.valueOf(this.jWh.isClosed()), Integer.valueOf(i3));
                fVar = new a(i2);
            }
        }
        AppMethodBeat.o(68117);
        return fVar;
    }

    public final int getCount() {
        AppMethodBeat.i(68118);
        int count = this.jWh.getCount() + this.CuE;
        AppMethodBeat.o(68118);
        return count;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(68119);
        super.finish();
        Log.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().remove(this);
        AppMethodBeat.o(68119);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(68120);
        and();
        notifyDataSetChanged();
        AppMethodBeat.o(68120);
    }

    class a extends com.tencent.mm.ui.contact.a.a {
        public a(int i2) {
            super(4, i2);
        }

        @Override // com.tencent.mm.ui.contact.a.a
        public final void a(Context context, a.C2110a aVar) {
        }

        @Override // com.tencent.mm.ui.contact.a.a
        public final a.b bmx() {
            AppMethodBeat.i(177531);
            AnonymousClass1 r0 = new a.b() {
                /* class com.tencent.mm.plugin.remittance.ui.g.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.contact.a.a.b
                public final View a(Context context, ViewGroup viewGroup) {
                    View inflate;
                    AppMethodBeat.i(177529);
                    if (com.tencent.mm.cb.a.jk(context)) {
                        inflate = LayoutInflater.from(context).inflate(R.layout.bq0, viewGroup, false);
                    } else {
                        inflate = LayoutInflater.from(context).inflate(R.layout.bpz, viewGroup, false);
                    }
                    f.a aVar = (f.a) a.eOf();
                    aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
                    aVar.gvw = (TextView) inflate.findViewById(R.id.ir3);
                    aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
                    aVar.jBR.setVisibility(8);
                    aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hhc);
                    inflate.setEnabled(false);
                    inflate.setTag(aVar);
                    AppMethodBeat.o(177529);
                    return inflate;
                }

                @Override // com.tencent.mm.ui.contact.a.a.b
                public final void a(Context context, a.C2110a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
                    AppMethodBeat.i(177530);
                    f.a aVar3 = (f.a) aVar;
                    aVar3.gvw.setText("");
                    aVar3.jVQ.setVisibility(8);
                    AppMethodBeat.o(177530);
                }

                @Override // com.tencent.mm.ui.contact.a.a.b
                public final boolean a(Context context, View view, com.tencent.mm.ui.contact.a.a aVar) {
                    return false;
                }
            };
            AppMethodBeat.o(177531);
            return r0;
        }

        public static a.C2110a eOf() {
            AppMethodBeat.i(177532);
            f fVar = new f(0);
            fVar.getClass();
            f.a aVar = new f.a();
            AppMethodBeat.o(177532);
            return aVar;
        }
    }
}
