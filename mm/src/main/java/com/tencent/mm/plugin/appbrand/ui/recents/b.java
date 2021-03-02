package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderCollectionEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-appbrand-integration_release"})
public final class b extends f {
    public b(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        super(fragmentActivity, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final String getTitle() {
        AppMethodBeat.i(51291);
        String string = getActivity().getString(R.string.qe);
        p.g(string, "activity.getString(R.str…list_collection_entrance)");
        AppMethodBeat.o(51291);
        return string;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final void onClick(View view) {
        int i2;
        AppMethodBeat.i(51292);
        FragmentActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Intent intent = activity.getIntent();
        if (intent == null || intent.getIntExtra("extra_get_usage_reason", 3) != 9) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        AppBrandLauncherFolderUI.a aVar = AppBrandLauncherFolderUI.nTH;
        FragmentActivity activity2 = getActivity();
        p.g(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Intent intent2 = new Intent();
        intent2.putExtra("extra_get_usage_reason", 8);
        intent2.putExtra("extra_get_usage_prescene", i2);
        intent2.putExtra("extra_enter_scene", 1);
        AppBrandLauncherFolderUI.a.n(activity2, intent2);
        f fVar = f.nGV;
        FragmentActivity activity3 = getActivity();
        p.g(activity3, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        h.INSTANCE.a(19468, 5, "", "", "", "", "", Long.valueOf(f.b(activity3).mSessionId));
        AppMethodBeat.o(51292);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void a(WeImageView weImageView) {
        AppMethodBeat.i(180693);
        p.h(weImageView, "imageView");
        weImageView.setVisibility(0);
        weImageView.setImageResource(R.raw.icons_filled_myminiprogram);
        FragmentActivity activity = getActivity();
        p.g(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        weImageView.setIconColor(activity.getResources().getColor(R.color.Yellow));
        AppMethodBeat.o(180693);
    }
}
