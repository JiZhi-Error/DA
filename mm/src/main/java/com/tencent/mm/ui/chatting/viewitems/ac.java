package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.q;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class ac extends c {
    private c CIT = new c();
    private com.tencent.mm.plugin.scanner.util.a PLt = new com.tencent.mm.plugin.scanner.util.a();
    private com.tencent.mm.ui.chatting.e.a PhN;
    private View.OnClickListener rID = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.viewitems.ac.AnonymousClass1 */

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(37037);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bq bqVar = (bq) view.getTag();
            if (bqVar == null) {
                Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37037);
                return;
            }
            ca caVar = bqVar.dTX;
            if (caVar == null) {
                Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan msg not valid");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37037);
                return;
            }
            String str = caVar.field_content;
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan content not valid");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37037);
                return;
            }
            OfflineScanContext.a aVar = OfflineScanContext.CREATOR;
            OfflineScanContext aMx = OfflineScanContext.a.aMx(str);
            Log.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", Integer.valueOf(aMx.dFL), Boolean.valueOf(aMx.CFK));
            q qVar = q.CFL;
            String str2 = aMx.CFJ;
            String str3 = aMx.typeName;
            if (aMx.CFK) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            q.b(str2, str3, i2, aMx.networkType, 1);
            if (g.azz().aYS() == 0) {
                h.a(ac.this.PhN.Pwc.getContext(), ac.this.PhN.Pwc.getContext().getString(R.string.fic), "", ac.this.PhN.Pwc.getContext().getString(R.string.w1), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ac.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(37036);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(37036);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37037);
                return;
            }
            if (!e.d.bcW(aMx.typeName)) {
                String str4 = aMx.CFJ;
                if (Util.isNullOrNil(str4)) {
                    Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37037);
                    return;
                }
                ac.this.PLt.a(ac.this.PhN.Pwc.getContext(), null, null, str4, aMx.CFK, aMx.dFM, aMx.typeName, aMx.dFP, 3, true, aMx.networkType, false, 0);
            } else if (Util.isNullOrNil(aMx.CFJ)) {
                Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37037);
                return;
            } else {
                ac.this.CIT.a(ac.this.PhN.Pwc.getContext(), aMx.CFJ, aMx.source, aMx.typeName, aMx.dFL, aMx.dFM, null, null, aMx.dFP, 3, true, aMx.networkType, false);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
        }
    };

    ac() {
        AppMethodBeat.i(37039);
        AppMethodBeat.o(37039);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (z || i2 != 721420337) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37040);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.sf);
            view.setTag(new a().gX(view));
        }
        AppMethodBeat.o(37040);
        return view;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTU() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTX() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTV() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        AppMethodBeat.i(37041);
        this.PhN = aVar2;
        a aVar3 = (a) aVar;
        String str2 = caVar.field_content;
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(37041);
            return;
        }
        OfflineScanContext.a aVar4 = OfflineScanContext.CREATOR;
        OfflineScanContext aMx = OfflineScanContext.a.aMx(str2);
        Log.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", aMx.toString());
        TextView textView = aVar3.PLw;
        long j2 = aMx.timestamp;
        Time time = new Time();
        time.set(j2);
        String charSequence = com.tencent.mm.pluginsdk.i.e.a("yyyy-MM-dd kk:mm", time).toString();
        textView.setText(String.format(MMApplicationContext.getContext().getString(R.string.fie), charSequence));
        bq bqVar = new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0);
        aVar3.clickArea.setTag(bqVar);
        aVar3.clickArea.setOnLongClickListener(c(aVar2));
        aVar3.clickArea.setOnClickListener(this.rID);
        aVar3.PLx.setTag(bqVar);
        aVar3.PLx.setOnClickListener(this.rID);
        AppMethodBeat.o(37041);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(m mVar, View view, ca caVar) {
        AppMethodBeat.i(233777);
        bq bqVar = (bq) view.getTag();
        if (bqVar == null) {
            AppMethodBeat.o(233777);
            return false;
        }
        mVar.a(bqVar.position, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
        AppMethodBeat.o(233777);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    final class a extends c.a {
        TextView PLw;
        RelativeLayout PLx;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final a gX(View view) {
            AppMethodBeat.i(37038);
            super.create(view);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.clickArea = view.findViewById(R.id.auf);
            this.PLw = (TextView) view.findViewById(R.id.g3e);
            this.PLx = (RelativeLayout) view.findViewById(R.id.g3d);
            AppMethodBeat.o(37038);
            return this;
        }
    }
}
