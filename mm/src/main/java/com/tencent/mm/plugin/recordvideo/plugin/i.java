package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00105\u001a\u000206H\u0002J\n\u00107\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u00108\u001a\u0002062\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010:H\u0002J(\u0010;\u001a\u0002062\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010:2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010:H\u0002J\u0006\u0010>\u001a\u00020 J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u00020\u000bH\u0002J\u0006\u0010A\u001a\u00020\tJ\n\u0010B\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020\u000bH\u0016J\u0012\u0010I\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u000206H\u0016J\b\u0010M\u001a\u000206H\u0016J\u000e\u0010N\u001a\u0002062\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020 H\u0016J\b\u0010Q\u001a\u000206H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\u001c\u0010.\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "isNotifyMoment", "", "()Z", "setNotifyMoment", "(Z)V", "menuDialog", "Landroid/support/design/widget/BottomSheetDialog;", "mergedUserList", "Ljava/util/ArrayList;", "getMergedUserList", "()Ljava/util/ArrayList;", "setMergedUserList", "(Ljava/util/ArrayList;)V", "moreBtn", "Landroid/widget/ImageView;", "moreMenuStatusGroup", "Landroid/widget/LinearLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "scene", "", "selectedChatroomList", "getSelectedChatroomList", "()Ljava/lang/String;", "setSelectedChatroomList", "(Ljava/lang/String;)V", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "selectedLabelList", "getSelectedLabelList", "setSelectedLabelList", "selectedUserList", "getSelectedUserList", "setSelectedUserList", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cleanSelectedCache", "", "createMenuDialog", "getContactNamesFromChatroom", "chatrooms", "", "getContactNamesFromLabelsAndOtherUserName", "labels", "userNames", "getSelectIndex", "goLabelUI", "hasSelectedRange", "mergeSelectedRangeUser", "name", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onClick", "v", "Landroid/view/View;", "release", "reset", "setScene", "setVisibility", "visibility", "updateMenuStatus", "plugin-recordvideo_release"})
public final class i implements View.OnClickListener, t {
    private final ImageView BQk;
    private final LinearLayout BQl;
    private android.support.design.widget.a BQm;
    public boolean BQn;
    private String BQo;
    private String BQp;
    private String BQq;
    private ArrayList<String> BQr;
    private final String TAG = "MicroMsg.EditMenuPlugin";
    public int bxP;
    private ViewGroup parent;
    private int scene;
    private d wgr;

    public i(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(75524);
        this.parent = viewGroup;
        this.wgr = dVar;
        View findViewById = this.parent.findViewById(R.id.gwr);
        p.g(findViewById, "parent.findViewById(R.id.record_editor_more_menu)");
        this.BQk = (ImageView) findViewById;
        View findViewById2 = this.parent.findViewById(R.id.gws);
        p.g(findViewById2, "parent.findViewById(R.id…r_more_menu_status_group)");
        this.BQl = (LinearLayout) findViewById2;
        this.BQn = true;
        this.BQr = new ArrayList<>();
        this.BQk.setVisibility(8);
        this.BQk.setOnClickListener(this);
        AppMethodBeat.o(75524);
    }

    public static final /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(75525);
        iVar.eKx();
        AppMethodBeat.o(75525);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237287);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237287);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    private final void eKw() {
        this.bxP = 0;
        this.BQo = null;
        this.BQp = null;
        this.BQq = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void eKx() {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.plugin.i.eKx():void");
    }

    private final void gg(List<String> list) {
        AppMethodBeat.i(75516);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(75516);
            return;
        }
        for (String str : list) {
            ArrayList arrayList = new ArrayList();
            List<String> Id = v.Id(str);
            if (Id != null) {
                Log.d(this.TAG, "getContactNamesFromChatroom chatromm:%s membersCount:%s", str, Integer.valueOf(Id.size()));
                for (String str2 : Id) {
                    if (!this.BQr.contains(str2) && ab.IS(str2)) {
                        Log.i(this.TAG, "getContactNamesFromChatroom memberName:%s", str2);
                        this.BQr.add(str2);
                    }
                    if (ab.IS(str2)) {
                        arrayList.add(str2);
                    }
                }
                Log.d(this.TAG, "%s , %s", str, Integer.valueOf(arrayList.size()));
            }
        }
        AppMethodBeat.o(75516);
    }

    private final void r(List<String> list, List<String> list2) {
        AppMethodBeat.i(163428);
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            HashSet hashSet = new HashSet();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List<String> aCK = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(it.next()));
                if (aCK == null || aCK.size() == 0) {
                    Log.e(this.TAG, "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                } else {
                    for (String str : aCK) {
                        hashSet.add(str);
                        Log.d(this.TAG, "dz:name : %s", str);
                    }
                }
            }
            this.BQr = new ArrayList<>(hashSet);
        }
        if (list != null) {
            for (String str2 : list) {
                Util.isNullOrNil(str2);
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (String str3 : list2) {
                if (!this.BQr.contains(str3)) {
                    this.BQr.add(str3);
                }
            }
        }
        AppMethodBeat.o(163428);
    }

    public final void onClick(View view) {
        e eVar;
        AppMethodBeat.i(75517);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        android.support.design.widget.a aVar = this.BQm;
        if (aVar != null) {
            aVar.dismiss();
        }
        switch (this.scene) {
            case 3:
                Context context = this.parent.getContext();
                p.g(context, "parent.context");
                e eVar2 = new e(context);
                eVar2.Cds = this.BQn;
                eVar2.Cdr = new a(this);
                eVar = eVar2;
                break;
            default:
                eVar = null;
                break;
        }
        this.BQm = eVar;
        android.support.design.widget.a aVar2 = this.BQm;
        if (aVar2 != null) {
            aVar2.show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75517);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75518);
        this.BQk.setVisibility(i2);
        AppMethodBeat.o(75518);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_menu";
    }

    public final void setScene(int i2) {
        AppMethodBeat.i(75519);
        Log.i(this.TAG, "setScene ".concat(String.valueOf(i2)));
        this.scene = i2;
        switch (i2) {
            case 3:
                this.BQk.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_more, -1));
                if (com.tencent.mm.plugin.recordvideo.b.a.a.BNL.eJD()) {
                    this.BQk.setVisibility(0);
                    break;
                } else {
                    this.BQk.setVisibility(8);
                    AppMethodBeat.o(75519);
                    return;
                }
        }
        AppMethodBeat.o(75519);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String eKy() {
        /*
        // Method dump skipped, instructions count: 439
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.plugin.i.eKy():java.lang.String");
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75521);
        this.BQl.removeAllViews();
        this.BQn = true;
        eKw();
        AppMethodBeat.o(75521);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75522);
        this.BQl.removeAllViews();
        this.BQn = true;
        eKw();
        AppMethodBeat.o(75522);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(75523);
        Log.i(this.TAG, "onActivityResult requestCode:" + i2 + " resultCode:" + i3);
        switch (i2) {
            case 3:
                if (i3 == -1 && intent != null) {
                    this.bxP = intent.getIntExtra("Ktag_range_index", 0);
                    this.BQp = intent.getStringExtra("Klabel_name_list");
                    this.BQo = intent.getStringExtra("Kother_user_name_list");
                    this.BQq = intent.getStringExtra("Kchat_room_name_list");
                    eKx();
                    break;
                }
        }
        AppMethodBeat.o(75523);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i BQs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar) {
            super(0);
            this.BQs = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            AppMethodBeat.i(75514);
            i iVar = this.BQs;
            if (!this.BQs.BQn) {
                z = true;
            } else {
                z = false;
            }
            iVar.BQn = z;
            i.a(this.BQs);
            c cVar = c.BXI;
            c.VI(16);
            x xVar = x.SXb;
            AppMethodBeat.o(75514);
            return xVar;
        }
    }
}
