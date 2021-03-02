package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j extends LinearLayout implements f.a {
    private List<String> PVw;
    private Map<String, View> PVx;
    private List<String> PVy;
    private a PVz;
    private Context context;
    private LinearLayout tmh = null;

    public interface a {
        void anF(int i2);
    }

    public j(Context context2, a aVar) {
        super(context2);
        AppMethodBeat.i(37821);
        this.context = context2;
        this.PVz = aVar;
        reset();
        AppMethodBeat.o(37821);
    }

    public final int getEnterpriseFriendCount() {
        AppMethodBeat.i(37822);
        if (this.PVw == null || this.PVy == null) {
            AppMethodBeat.o(37822);
            return 0;
        }
        int size = this.PVw.size() + this.PVy.size();
        AppMethodBeat.o(37822);
        return size;
    }

    public final void reset() {
        AppMethodBeat.i(234000);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.ui.contact.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(37820);
                j jVar = j.this;
                f bah = ag.bah();
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                f.a(sb);
                f.c(sb);
                sb.append(" and bizinfo.type = 2 ");
                sb.append(" order by ");
                sb.append(f.aZD());
                String sb2 = sb.toString();
                Log.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", sb2);
                Cursor rawQuery = bah.rawQuery(sb2, new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            arrayList.add(rawQuery.getString(0));
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
                jVar.PVw = arrayList;
                j jVar2 = j.this;
                bg.aVF();
                jVar2.PVy = c.aSN().gBY();
                j.this.post(new Runnable() {
                    /* class com.tencent.mm.ui.contact.j.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233998);
                        if (j.this.PVy != null && j.this.PVy.contains("wework")) {
                            j.this.PVy.clear();
                            j.this.PVy.add("wework");
                        }
                        if (j.this.PVw.size() > 0 || j.this.PVy.size() > 0) {
                            Log.i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(j.this.PVw.size()));
                            if (j.this.tmh == null) {
                                View.inflate(j.this.getContext(), R.layout.a3s, j.this);
                                j.this.tmh = (LinearLayout) j.this.findViewById(R.id.be3);
                            }
                            j.this.tmh.removeAllViews();
                            if (j.this.PVy.size() > 0) {
                                for (int i2 = 0; i2 < j.this.PVy.size(); i2++) {
                                    z zVar = new z(j.this.getContext(), (String) j.this.PVy.get(i2));
                                    j.this.tmh.addView(zVar);
                                    if (i2 == j.this.PVy.size() - 1 && j.this.PVw.size() == 0) {
                                        View findViewById = zVar.findViewById(R.id.c45);
                                        int paddingLeft = findViewById.getPaddingLeft();
                                        findViewById.setBackground(at.aN(j.this.context, R.attr.sg));
                                        findViewById.findViewById(R.id.c47).setBackground(null);
                                        findViewById.setPadding(paddingLeft, 0, 0, 0);
                                    } else {
                                        zVar.findViewById(R.id.c45).setBackground(null);
                                        zVar.findViewById(R.id.c45).findViewById(R.id.c47).setBackground(at.aN(j.this.context, R.attr.sg));
                                    }
                                }
                            }
                            if (j.this.PVw.size() > 0) {
                                j.this.PVx = new HashMap();
                                for (int i3 = 0; i3 < j.this.PVw.size(); i3++) {
                                    String str = (String) j.this.PVw.get(i3);
                                    k kVar = new k(j.this.getContext(), str);
                                    j.this.tmh.addView(kVar);
                                    j.this.PVx.put(str, kVar);
                                    if (i3 == j.this.PVw.size() - 1) {
                                        View findViewById2 = kVar.findViewById(R.id.c45);
                                        int paddingLeft2 = findViewById2.getPaddingLeft();
                                        findViewById2.setBackgroundResource(R.drawable.b9w);
                                        findViewById2.findViewById(R.id.c46).setBackground(null);
                                        findViewById2.setPadding(paddingLeft2, 0, 0, 0);
                                    } else {
                                        kVar.findViewById(R.id.c45).setBackground(null);
                                        View findViewById3 = kVar.findViewById(R.id.c45).findViewById(R.id.c46);
                                        int paddingRight = findViewById3.getPaddingRight();
                                        findViewById3.setBackgroundResource(R.drawable.b9w);
                                        findViewById3.setPadding(0, 0, paddingRight, 0);
                                    }
                                }
                            }
                            j.this.PVz.anF(j.this.getEnterpriseFriendCount());
                        }
                        AppMethodBeat.o(233998);
                    }
                });
                AppMethodBeat.o(37820);
            }
        });
        AppMethodBeat.o(234000);
    }

    @Override // com.tencent.mm.al.f.a
    public final void a(f.a.b bVar) {
        AppMethodBeat.i(37824);
        if (bVar.iOi == null) {
            AppMethodBeat.o(37824);
        } else if (!bVar.iOi.UF()) {
            Log.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            AppMethodBeat.o(37824);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.contact.j.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(233999);
                    j.this.reset();
                    AppMethodBeat.o(233999);
                }
            });
            AppMethodBeat.o(37824);
        }
    }
}
