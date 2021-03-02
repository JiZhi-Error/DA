package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020!H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addPoiBtn", "Landroid/widget/ImageView;", "addPoiGroup", "Landroid/widget/RelativeLayout;", "addPoiTip", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "checkLocation", "", "getLocationResult", "data", "Landroid/content/Intent;", "initSafeArea", "name", "", "onActivityResult", "requestCode", "", "resultCode", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class b implements View.OnClickListener, t {
    private final RelativeLayout BPR;
    private final ImageView BPS;
    private final ImageView BPT;
    private dlg BPU = new dlg();
    private ViewGroup parent;
    private d wgr;

    public b(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(75464);
        this.parent = viewGroup;
        this.wgr = dVar;
        View findViewById = this.parent.findViewById(R.id.bwr);
        p.g(findViewById, "parent.findViewById(R.id…ditor_add_location_group)");
        this.BPR = (RelativeLayout) findViewById;
        View findViewById2 = this.parent.findViewById(R.id.bwp);
        p.g(findViewById2, "parent.findViewById(R.id.editor_add_location)");
        this.BPS = (ImageView) findViewById2;
        View findViewById3 = this.parent.findViewById(R.id.bwq);
        p.g(findViewById3, "parent.findViewById(R.id…ditor_add_location_check)");
        this.BPT = (ImageView) findViewById3;
        this.BPS.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_location, -1));
        ImageView imageView = this.BPT;
        Context context = this.parent.getContext();
        p.g(context, "parent.context");
        imageView.setImageDrawable(context.getResources().getDrawable(R.raw.popvideo_post_selected));
        this.BPR.setOnClickListener(this);
        Point az = au.az(this.parent.getContext());
        int i2 = az.y;
        int i3 = az.x;
        AppMethodBeat.o(75464);
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
        AppMethodBeat.i(237267);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237267);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    public final void eKn() {
        AppMethodBeat.i(75459);
        Intent intent = new Intent();
        intent.putExtra("get_poi_classify_id", this.BPU.LIb);
        intent.putExtra("get_poi_from_scene", "story");
        intent.putExtra("get_city", this.BPU.kea);
        intent.putExtra("poi_show_none", true);
        intent.putExtra("select_radio_icon_color", "#0E9CE6");
        c.b(this.parent.getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 2);
        AppMethodBeat.o(75459);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75460);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        WeChatBrands.Business.Entries entries = WeChatBrands.Business.Entries.SessionLocation;
        if (entries != null) {
            if (!entries.checkAvailable(view != null ? view.getContext() : null)) {
                a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75460);
                return;
            }
        }
        eKn();
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VI(10);
        a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75460);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75461);
        this.BPR.setVisibility(i2);
        AppMethodBeat.o(75461);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_tip";
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(75462);
        if (2 == i2 && i3 == -1 && intent != null) {
            this.BPU.kHV = Util.nullAs(intent.getStringExtra("get_poi_name"), "");
            this.BPU.kea = Util.nullAs(intent.getStringExtra("get_city"), "");
            this.BPU.LbD = intent.getFloatExtra("get_lat", -1000.0f);
            this.BPU.LbC = intent.getFloatExtra("get_lng", -1000.0f);
            this.BPU.LIb = intent.getStringExtra("get_poi_classify_id");
            if (!Util.isNullOrNil(this.BPU.kHV) || !Util.isNullOrNil(this.BPU.kea)) {
                this.BPT.setVisibility(0);
            } else {
                this.BPT.setVisibility(8);
            }
            Bundle bundle = new Bundle();
            bundle.putByteArray("PARAM_EDIT_POI_INFO", this.BPU.toByteArray());
            this.wgr.a(d.c.BVc, bundle);
            AppMethodBeat.o(75462);
            return;
        }
        AppMethodBeat.o(75462);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75463);
        this.BPU = new dlg();
        this.BPT.setVisibility(8);
        AppMethodBeat.o(75463);
    }
}
